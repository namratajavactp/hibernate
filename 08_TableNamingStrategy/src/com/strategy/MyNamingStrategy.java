package com.strategy;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.util.StringHelper;

public class MyNamingStrategy extends ImprovedNamingStrategy {
	public String classToTableName(String className) {
		System.out.println("class to table name");
		return "Seed_"+StringHelper.unqualify(className);
	}

	public String propertyToColumnName(String propertyName) {
		System.out.println("property to field name");
		return "Seed"+propertyName;
	}

	public String tableName(String tableName) {
		System.out.println("Table Name");
		return "Seed_" + tableName;
	}

	public String columnName(String columnName) {
		System.out.println("Column name");
		return "Seed"+columnName;
	}

	public String propertyToTableName(String className, String propertyName) {
		System.out.println("property to table name");
		return "Seed" + classToTableName(className) + '_'
				+ propertyToColumnName(propertyName);
	}
}
