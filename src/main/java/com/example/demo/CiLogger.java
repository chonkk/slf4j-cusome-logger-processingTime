/*
 *     Copyright (c) 2021 chonkk@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 2021-07-30
 */
package com.example.demo;


import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import ch.qos.logback.classic.LoggerContext;
import org.slf4j.IMarkerFactory;
import org.slf4j.MDC;
import org.slf4j.Marker;
import org.slf4j.spi.LocationAwareLogger;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;


public class CiLogger {

	private static  org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CiLogger.class);
    private static final String FQCN = CiLogger.class.getName();

    private CiLogger() {
    }

    private static void default_processing_time() {
		try{
			if(MDC.get("startTime")!=null){
				long startTime = 0L;
				Object obj = MDC.get("startTime");
				if(obj instanceof Long) { startTime = ((Long) obj).longValue(); } else { startTime =  Long.parseLong((String)obj ); }
				if(startTime > 0) {MDC.put("processingTimeMSec", String.format(", processingTimeMSec[%s]", System.currentTimeMillis() - startTime));}
			}else if(MDC.get("processingTimeMSec")!=null) {MDC.remove("processingTimeMSec");}
		}catch(Exception e){}
	}


	public static void log(Throwable t, int level, String format, Object...args) {
    	default_processing_time();
    	//default_app_info();
    	if(format==null) {
        	return;
    	}

    	if(log instanceof LocationAwareLogger) {
    		 ((LocationAwareLogger) log).log(null, FQCN, level, String.format(format, args), null, t);
    	}else {

    		switch(level) {
	    		case 0: log.trace(String.format(format, args), t); break;
	    		case 10: log.debug(String.format(format, args), t); break;
	    		case 20: log.info(String.format(format, args), t); break;
	    		case 30: log.warn(String.format(format, args), t); break;
	    		case 40: log.error(String.format(format, args), t); break;
    		}
    	}
	}

    public static void trace(String format, Object...args){
    	log(null, LocationAwareLogger.TRACE_INT, format, args);
    }

    public static void debug(String format, Object...args){
    	log(null, LocationAwareLogger.DEBUG_INT, format, args);
    }

    public static void info(String format, Object...args){
    	log(null, LocationAwareLogger.INFO_INT, format, args);
    }

    public static void warn(String format, Object...args){
    	log(null, LocationAwareLogger.WARN_INT, format, args);
    }

    public static void error(String format, Object...args){
    	log(null, LocationAwareLogger.ERROR_INT, format, args);
    }

    public static void fatal(String format, Object...args){
    	log(null, LocationAwareLogger.ERROR_INT, format, args);
    }

	public static void error(Throwable t, String format, Object...args) {

    	log(t, LocationAwareLogger.ERROR_INT, format, args);
	}

	public static void error(Throwable t) {
    	log(t, LocationAwareLogger.ERROR_INT, "");
	}

	public static void warn(Throwable t, String format, Object...args) {

    	log(t, LocationAwareLogger.WARN_INT, format, args);
	}

}
