package com.deskmate01;

import java.sql.Connection;

import com.deskmate.utils.DbConnectionFactory;

public class TestMain {
	public static void main(String[] args) {
		Connection connection = DbConnectionFactory.getConnection();
	}

}
