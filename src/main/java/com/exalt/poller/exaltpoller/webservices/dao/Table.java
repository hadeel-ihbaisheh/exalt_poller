package com.exalt.poller.exaltpoller.webservices.dao;

import java.util.List;

public class Table {

	private List<Column> cols;
	
	private List<Row> rows;
	
	public Table() {
		
	}

	public List<Column> getCols() {
		return cols;
	}

	public void setCols(List<Column> cols) {
		this.cols = cols;
	}

	public List<Row> getRows() {
		return rows;
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
	}
	
	
}
