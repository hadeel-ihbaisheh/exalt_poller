google.charts.load('current');
google.charts.setOnLoadCallback(drawHistoryChart)

google.charts.load('current', {
    'packages': ['gauge']
});
google.charts.setOnLoadCallback(drawChartCallback);



//Required Data:
var cohesionData = null;
var communicationData = null;

var scheduleData = null;

var timeFragmentationData = null;

var appExperienceData = null;

var reqStabilityData = null;
//charts:

var cohesionChart = null;

var communicationChart = null;

var scheduleChart = null;

var timeFragmentationChart = null;

var appExperienceChart = null;

var reqStabilityChart = null;
//options
var options = {
    redFrom: 1,
    redTo: 2,
    yellowFrom: 2,
    yellowTo: 3,
    max: 5,
    min: 1,
    majorTicks: 1
};

//selected factor
var selectedFactor = "overall"

//timer:

var chartUpdateTimer = null;



//global dev to set the selected team
var selectedTeam = 'nokia-ea-app-elias';

displayQuestionInfo();
displayVotingTable();

function refresh() {
    document.getElementById('votingTable').innerHTML = "Loading..."
    displayVotingTable()
}

function displayQuestionInfo() {


    w3Http("../recentQuestionInfo/" + selectedTeam, function() {
        if (this.readyState == 4 && (this.status == 204 || this.status == 200)) {
            var postedQuestionInfo = JSON.parse(this.responseText);
            var postedQuestionTime = new Date(postedQuestionInfo['time']);
            var nextQuestionTime = new Date(postedQuestionTime.getTime() + (80 * 60 * 1000)); //
            var postedQuestionsCount = parseInt(postedQuestionInfo['postedQuestionsCount'])
            document.getElementById("questionText").innerText = "Last question was: '" + postedQuestionInfo['question'] + "'";
            if (postedQuestionsCount == 6) {
                nextQuestionMessage = "No more questions for today"
            } else if (postedQuestionsCount == 0) {
                //document.getElementById("questionText").innerText = "Last question was yesterday!";
                today = new Date().getDay();
                if (today == 5 || today == 6) {
                    nextQuestionMessage = "No questions for today. Happy weekend!";
                } else {
                    nextQuestionMessage = "Question posting will be started at 9:00AM"
                }
            } else {
                nextQuestionMessage = "Next question will be on " + nextQuestionTime.toLocaleString("en-us");
            }

            document.getElementById("questionFactor").innerText = "Was about " + postedQuestionInfo['factor'];
            document.getElementById("questionTime").innerText = "Posted on " + postedQuestionTime.toLocaleString("en-us");
            document.getElementById("nextQuestionTime").innerText = nextQuestionMessage;
            document.getElementById("questionVotingRate").innerText = "Voting rate on it is " + postedQuestionInfo['votingRate'];
            document.getElementById("postedQuestionCount").innerText = "Number of posted questions so far is " + postedQuestionInfo['postedQuestionsCount'];
        }
    })
}


function displayVotingTable() {
    w3Http("../votingInfo/" + selectedTeam, function() {
        if (this.readyState == 4 && (this.status == 204 || this.status == 200)) {
            var votingInfo = JSON.parse(this.responseText);


            var color = "red";
            var table = '<table id="votingTable" class="w3-table w3-striped w3-white">';
            for (index = 0; index < votingInfo.length; index++) {


                //document.getElementById('votingTable').innerHTML = "Hello";//this.responseText;
                var rate = votingInfo[index].votingRate;
                color = rate < 50 ? "red" : "blue";
                table += '<tr>';
                table += '<td><i class="fa fa-user w3-text-' + color + ' w3-large"></i></td>';
                table += '<td>' + votingInfo[index].memberName + '</td>';
                table += '<td><i>' + votingInfo[index].votingRate + '%</i></td>';
                table += '</tr>';

            }
            table += '</table>';
            document.getElementById('votingTable').innerHTML = table;
        }
    })
}


function selectTeam(team) {
    //request data of team
    //set
    //set as default label
    selectTeamButton = document.getElementById('selectTeamButton');
    selectTeamButton.innerText = team;
    selectedTeam = team;
    selectedFactor = "overall"
    resetGauges();
    updateGauges();
    setGaugesTimer();
    drawHistoryChart();
    displayQuestionInfo();
    displayVotingTable();
}

function selectFactor(factor) {
    selectFactorButton = document.getElementById('selectFactorButton');
    label = document.getElementById(factor).innerText

    selectFactorButton.innerText = label;
    selectedFactor = factor;

    drawHistoryChart();
}

function drawHistoryChart() {

    var wrapper = new google.visualization.ChartWrapper({
        chartType: 'LineChart',
        options: {
            'title': 'History diagram'
        },
        containerId: 'curve_chart'
    });
    if (selectedFactor == "overall") {
        url = "../overallStatus/" + selectedTeam;
    } else {
        url = "../factorInfo/" + selectedTeam + "/" + selectedFactor;
    }

    w3Http(url, function() {
        if (this.readyState == 4 && (this.status == 204 || this.status == 200)) {
            var dataTable = JSON.parse(this.responseText);
            wrapper.setDataTable(dataTable)
            wrapper.draw()
        }
    })

    //wrapper.draw()
}

function resetGauges() {
    communicationData.setValue(0, 1, 5);
    communicationChart.draw(communicationData, options)

    cohesionData.setValue(0, 1, 5);
    cohesionChart.draw(cohesionData, options)

    appExperienceData.setValue(0, 1, 5);
    appExperienceChart.draw(appExperienceData, options)

    timeFragmentationData.setValue(0, 1, 5);
    timeFragmentationChart.draw(timeFragmentationData, options)

    scheduleData.setValue(0, 1, 5);
    scheduleChart.draw(scheduleData, options)

    reqStabilityData.setValue(0, 1, 5);
    reqStabilityChart.draw(reqStabilityData, options)
}

function updateGauges() {

    w3Http("../statistics/" + selectedTeam, function() {
        if (this.readyState == 4 && (this.status == 204 || this.status == 200)) {
            var statistics = JSON.parse(this.responseText);
            if (statistics) {
                result = statistics['factors']
                if (result != null || result != undefined) {
                    for (i = 0; i < result.length; i++) {
                        mean = result[i].mean
                        switch (result[i].factor) {
                            case 'COMMUNICATION':
                                communicationData.setValue(0, 1, mean);
                                communicationChart.draw(communicationData, options)
                                break;
                            case 'COHESION':
                                cohesionData.setValue(0, 1, mean);
                                cohesionChart.draw(cohesionData, options)
                                break;
                            case 'APP_EXPERIENCE':
                                appExperienceData.setValue(0, 1, mean);
                                appExperienceChart.draw(appExperienceData, options)
                                break;
                            case 'TIME_FRAMGMENTATION':
                                timeFragmentationData.setValue(0, 1, mean);
                                timeFragmentationChart.draw(timeFragmentationData, options)
                                break;
                            case 'SCHEDULE':
                                scheduleData.setValue(0, 1, mean);
                                scheduleChart.draw(scheduleData, options)
                                break;
                            case 'REQ_STABILITY':

                                reqStabilityData.setValue(0, 1, mean);
                                reqStabilityChart.draw(reqStabilityData, options)
                                break;
                            default:
                                break;
                        }
                    }
                }
            }

        }
    });

}

function setGaugesTimer() {
    if (chartUpdateTimer != null) {
        clearInterval(chartUpdateTimer);
    }

    chartUpdateTimer = setInterval(updateGauges, 60000);
}

function drawChartCallback() {



    //Required Data:
    cohesionData = google.visualization.arrayToDataTable([
        ['Label', 'Value'],
        ['', 5]
    ]);

    communicationData = google.visualization.arrayToDataTable([
        ['Label', 'Value'],
        ['', 5]
    ]);

    scheduleData = google.visualization.arrayToDataTable([
        ['Label', 'Value'],
        ['', 5]
    ]);

    timeFragmentationData = google.visualization.arrayToDataTable([
        ['Label', 'Value'],
        ['', 5]
    ]);

    appExperienceData = google.visualization.arrayToDataTable([
        ['Label', 'Value'],
        ['', 5]
    ]);

    reqStabilityData = google.visualization.arrayToDataTable([
        ['Label', 'Value'],
        ['', 5]
    ]);


    cohesionChart = new google.visualization.Gauge(document.getElementById('chart_div_cohesion'));
    cohesionChart.draw(cohesionData, options);

    communicationChart = new google.visualization.Gauge(document.getElementById('chart_div_communication'));
    communicationChart.draw(communicationData, options);

    scheduleChart = new google.visualization.Gauge(document.getElementById('chart_div_schedule'));
    scheduleChart.draw(scheduleData, options);

    timeFragmentationChart = new google.visualization.Gauge(document.getElementById('chart_div_timeFragmentation'));
    timeFragmentationChart.draw(timeFragmentationData, options);

    appExperienceChart = new google.visualization.Gauge(document.getElementById('chart_div_appExperience'));
    appExperienceChart.draw(appExperienceData, options);

    reqStabilityChart = new google.visualization.Gauge(document.getElementById('chart_div_reqStability'));
    reqStabilityChart.draw(reqStabilityData, options);
    updateGauges();
    setGaugesTimer();
}