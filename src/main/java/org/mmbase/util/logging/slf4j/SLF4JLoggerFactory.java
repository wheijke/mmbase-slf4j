/*

 This software is OSI Certified Open Source Software.
 OSI Certified is a certification mark of the Open Source Initiative.

 The license (Mozilla version 1.0) can be read at the MMBase site.
 See http://www.MMBase.org/license

 */
package org.mmbase.util.logging.slf4j;

import java.util.Hashtable;
import java.util.Map;

import org.slf4j.LoggerFactory;

/**
 * SLF4J logging factory for MMBase, use this class in log4j.xml
 * 
 * @author Wouter Heijke
 */
public class SLF4JLoggerFactory {

	private static Map<String, SLF4JLogger> logInstances = new Hashtable<String, SLF4JLogger>();

	private SLF4JLoggerFactory() {
		System.out.println("SLF4JLogger");
	}

	/**
	 * Is called automagically by org.mmbase.util.logging.Logging
	 * 
	 * @param name Usually the name of the class we want to log
	 * @return A logger
	 */
	public static SLF4JLogger getLoggerInstance(String name) {
		SLF4JLogger logInstance = logInstances.get(name);
		if (logInstance != null) {
			return logInstance;
		}

		logInstance = new SLF4JLogger(LoggerFactory.getLogger(name));

		logInstances.put(name, logInstance);
		return logInstance;
	}
}