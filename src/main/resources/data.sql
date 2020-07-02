
insert into Factor values (1, 'FRGMNTN', 'Description', 'TIME_FRAGMENTATION', FALSE)
insert into question values (100, 1, 'how are you1', 1)
insert into question values (101, 1, 'how are you2', 1)
insert into question values (102, 1, 'how are you3', 1)
--
--
insert into QUESTION_ANSWER_OPTIONS  values (100, 'option1')
insert into QUESTION_ANSWER_OPTIONS  values (100, 'option2')
insert into QUESTION_ANSWER_OPTIONS  values (100, 'option3')
insert into QUESTION_ANSWER_OPTIONS  values (100, 'option4')

insert into TEAM values (1, 'cisco-dp-ea-app', '')
insert into MEMBER  values (1, 'Emad', 'Emad Ashour', 1)
insert into MEMBER  values (2, 'Emad2', 'Emad Ashour2', 1)
--
insert into ANSWER values (1, sysdate(), 1, 'CHSN', 'how are you', 'cisco-dp-ea-app', 1)
insert into ANSWER values (2, sysdate(), 2, 'CHSN', 'how are you', 'cisco-dp-ea-app', 1)
insert into ANSWER values (3, sysdate(), 2, 'CHSN', 'how are you', 'cisco', 2)
--
--
insert into POSTED_QUESTION values (1, 'COHESION', 'How are you1?', TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), 'cisco-dp-ea-app')
insert into POSTED_QUESTION values (2, 'COHESION', 'How are you2?', TO_DATE('2020/01/06 22:02:44', 'yyyy/mm/dd hh24:mi:ss'), 'cisco-dp-ea-app')
insert into POSTED_QUESTION values (3, 'COHESION', 'How are you3?', sysdate(), 'cisco-dp-ea-app')
