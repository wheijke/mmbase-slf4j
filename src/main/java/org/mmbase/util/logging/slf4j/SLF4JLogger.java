/*

 This software is OSI Certified Open Source Software.
 OSI Certified is a certification mark of the Open Source Initiative.

 The license (Mozilla version 1.0) can be read at the MMBase site.
 See http://www.MMBase.org/license

 */
package org.mmbase.util.logging.slf4j;

import org.mmbase.util.logging.AbstractSimpleImpl;
import org.slf4j.Logger;

/**
 * SLF4J logging for MMBase, contains a single Log instance, fatal goes to error
 * and service to info
 * 
 * @author Wouter Heijke
 */
public class SLF4JLogger extends AbstractSimpleImpl implements org.mmbase.util.logging.Logger {

	private Logger log;

	// There is no format basically
	private static final String FORMAT = "{}";

	public SLF4JLogger(Logger logger) {
		log = logger;
	}

	@Override
	protected final void log(String s) {
		if (log.isTraceEnabled()) {
			log.trace(s);
		} else if (log.isDebugEnabled()) {
			log.debug(s);
		} else if (log.isInfoEnabled()) {
			log.info(s);
		} else if (log.isWarnEnabled()) {
			log.warn(s);
		} else if (log.isErrorEnabled()) {
			log.error(s);
		}
	}

	@Override
	public void debug(Object message) {
		log.debug(FORMAT, message);
	}

	@Override
	public void error(Object message) {
		log.error(FORMAT, message);
	}

	@Override
	public void fatal(Object message) {
		// TODO map this configurable somehow
		log.error(FORMAT, message);
	}

	@Override
	public void info(Object message) {
		log.info(FORMAT, message);
	}

	@Override
	public void service(Object message) {
		// TODO map this configurable somehow
		log.info(FORMAT, message);
	}

	@Override
	public void trace(Object message) {
		log.trace(FORMAT, message);
	}

	@Override
	public void warn(Object message) {
		log.warn(FORMAT, message);
	}

	@Override
	public void debug(Object message, Throwable t) {
		log.debug(FORMAT, message, t);
	}

	@Override
	public void error(Object message, Throwable t) {
		log.error(FORMAT, message, t);
	}

	@Override
	public void fatal(Object message, Throwable t) {
		// TODO map this configurable somehow
		log.error(FORMAT, message, t);
	}

	@Override
	public void info(Object message, Throwable t) {
		log.info(FORMAT, message, t);
	}

	@Override
	public void trace(Object message, Throwable t) {
		log.trace(FORMAT, message, t);
	}

	@Override
	public void warn(Object message, Throwable t) {
		log.warn(FORMAT, message, t);
	}

	@Override
	public boolean isDebugEnabled() {
		return log.isDebugEnabled();
	}

	@Override
	public boolean isServiceEnabled() {
		// TODO map this configurable somehow
		return log.isInfoEnabled();
	}

	public boolean isErrorEnabled() {
		return log.isErrorEnabled();
	}

	public boolean isFatalEnabled() {
		// TODO map this configurable somehow
		return log.isErrorEnabled();
	}

	public boolean isInfoEnabled() {
		return log.isInfoEnabled();
	}

	@Override
	public boolean isTraceEnabled() {
		return log.isTraceEnabled();
	}

	public boolean isWarnEnabled() {
		return log.isWarnEnabled();
	}
}