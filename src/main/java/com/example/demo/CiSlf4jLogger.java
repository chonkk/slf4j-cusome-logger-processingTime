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


import org.slf4j.MDC;
import org.slf4j.Marker;
import org.slf4j.spi.LocationAwareLogger;

public class CiSlf4jLogger implements org.slf4j.Logger {
    protected org.slf4j.Logger logger = null;
    private static final String FQCN = CiSlf4jLogger.class.getName();

    public CiSlf4jLogger(org.slf4j.Logger logger) {
        this.logger = logger;
    }

    private void default_processing_time() {
        try{
            if(MDC.get("startTime")!=null){
                long startTime = 0L;
                Object obj = MDC.get("startTime");
                if(obj instanceof Long) { startTime = ((Long) obj).longValue(); } else { startTime =  Long.parseLong((String)obj ); }
                if(startTime > 0) {MDC.put("processingTimeMSec", String.format(", processingTimeMSec[%s]", System.currentTimeMillis() - startTime));}
            }else if(MDC.get("processingTimeMSec")!=null) {MDC.remove("processingTimeMSec");}
        }catch(Exception e){}
    }

    public void log(org.slf4j.Marker marker, Throwable t, int level, String format, Object...args) {
        if(format==null) {
            return;
        }

        default_processing_time();

        if(logger instanceof LocationAwareLogger) {
            ((LocationAwareLogger) logger).log(marker, FQCN, level, format, args, t);
        }else {

            switch(level) {
                case 0: logger.trace(marker, String.format(format, args), t); break;
                case 10: logger.debug(marker, String.format(format, args), t); break;
                case 20: logger.info(marker, String.format(format, args), t); break;
                case 30: logger.warn(marker, String.format(format, args), t); break;
                case 40: logger.error(marker, String.format(format, args), t); break;
            }
        }
    }

    @Override
    public String getName() {
        return logger.getName();
    }

    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    @Override
    public void trace(String msg) {
        log(null, null, LocationAwareLogger.TRACE_INT, msg);
    }

    @Override
    public void trace(String format, Object arg) {
        log(null, null, LocationAwareLogger.TRACE_INT, String.format(format, arg));
    }

    @Override
    public void trace(String format, Object arg1, Object arg2) {
        log(null, null, LocationAwareLogger.TRACE_INT, String.format(format, arg1, arg2));
    }

    @Override
    public void trace(String format, Object... arguments) {
        log(null, null, LocationAwareLogger.TRACE_INT, String.format(format, arguments));
    }

    @Override
    public void trace(String msg, Throwable t) {
        log(null, t, LocationAwareLogger.TRACE_INT, msg);
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return logger.isTraceEnabled(marker);
    }

    @Override
    public void trace(Marker marker, String msg) {
        log(marker, null, LocationAwareLogger.TRACE_INT, msg);
    }

    @Override
    public void trace(Marker marker, String format, Object arg) {
        log(marker, null, LocationAwareLogger.TRACE_INT, String.format(format, arg));
    }

    @Override
    public void trace(Marker marker, String format, Object arg1, Object arg2) {
        log(marker, null, LocationAwareLogger.TRACE_INT, String.format(format, arg1, arg2));
    }

    @Override
    public void trace(Marker marker, String format, Object... argArray) {
        log(marker, null, LocationAwareLogger.TRACE_INT, String.format(format, argArray));
    }

    @Override
    public void trace(Marker marker, String msg, Throwable t) {
        log(marker, t, LocationAwareLogger.TRACE_INT, msg);
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    @Override
    public void debug(String msg) {
        log(null, null, LocationAwareLogger.DEBUG_INT, msg);
    }

    @Override
    public void debug(String format, Object arg) {
        log(null, null, LocationAwareLogger.DEBUG_INT, String.format(format, arg));
    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {
        log(null, null, LocationAwareLogger.DEBUG_INT, String.format(format, arg1, arg2));
    }

    @Override
    public void debug(String format, Object... arguments) {
        log(null, null, LocationAwareLogger.DEBUG_INT, String.format(format, arguments));
    }

    @Override
    public void debug(String msg, Throwable t) {
        log(null, t, LocationAwareLogger.DEBUG_INT, msg);
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return logger.isDebugEnabled(marker);
    }

    @Override
    public void debug(Marker marker, String msg) {
        log(marker, null, LocationAwareLogger.DEBUG_INT, msg);
    }

    @Override
    public void debug(Marker marker, String format, Object arg) {
        log(marker, null, LocationAwareLogger.DEBUG_INT, String.format(format, arg));
    }

    @Override
    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        log(marker, null, LocationAwareLogger.DEBUG_INT, String.format(format, arg1, arg2));
    }

    @Override
    public void debug(Marker marker, String format, Object... arguments) {
        log(marker, null, LocationAwareLogger.DEBUG_INT, String.format(format, arguments));
    }

    @Override
    public void debug(Marker marker, String msg, Throwable t) {
        log(marker, t, LocationAwareLogger.DEBUG_INT, msg);
    }

    @Override
    public boolean isInfoEnabled() {
        return this.logger.isInfoEnabled();
    }

    @Override
    public void info(String msg) {
        log(null, null, LocationAwareLogger.INFO_INT, msg);
    }

    @Override
    public void info(String format, Object arg) {
        log(null, null,LocationAwareLogger.INFO_INT, format, arg);
    }

    @Override
    public void info(String format, Object arg1, Object arg2) {
        log(null, null,LocationAwareLogger.INFO_INT, String.format(format, arg1, arg2));
    }

    @Override
    public void info(String format, Object... arguments) {
        log(null, null,LocationAwareLogger.INFO_INT, String.format(format, arguments));
    }

    @Override
    public void info(String msg, Throwable t) {
        log(null, t,LocationAwareLogger.INFO_INT, msg);
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return logger.isInfoEnabled(marker);
    }

    @Override
    public void info(Marker marker, String msg) {
        log(marker, null, LocationAwareLogger.INFO_INT, msg);
    }

    @Override
    public void info(Marker marker, String format, Object arg) {
        log(marker, null, LocationAwareLogger.INFO_INT, String.format(format, arg));
    }

    @Override
    public void info(Marker marker, String format, Object arg1, Object arg2) {
        log(marker, null, LocationAwareLogger.INFO_INT, String.format(format, arg1, arg2));
    }

    @Override
    public void info(Marker marker, String format, Object... arguments) {
        log(marker, null, LocationAwareLogger.INFO_INT, String.format(format, arguments));
    }

    @Override
    public void info(Marker marker, String msg, Throwable t) {
        log(marker, t, LocationAwareLogger.INFO_INT, msg);
    }

    @Override
    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    @Override
    public void warn(String msg) {
        log(null, null, LocationAwareLogger.WARN_INT, msg);
    }

    @Override
    public void warn(String format, Object arg) {
        log(null, null, LocationAwareLogger.WARN_INT, String.format(format, arg));
    }

    @Override
    public void warn(String format, Object... arguments) {
        log(null, null, LocationAwareLogger.WARN_INT, String.format(format, arguments));
    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {
        log(null, null, LocationAwareLogger.WARN_INT, String.format(format, arg1, arg2));
    }

    @Override
    public void warn(String msg, Throwable t) {
        log(null, t, LocationAwareLogger.WARN_INT, msg);
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return logger.isWarnEnabled(marker);
    }

    @Override
    public void warn(Marker marker, String msg) {
        log(marker, null, LocationAwareLogger.WARN_INT, msg);
    }

    @Override
    public void warn(Marker marker, String format, Object arg) {
        log(marker, null, LocationAwareLogger.WARN_INT, String.format(format, arg));
    }

    @Override
    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        log(marker, null, LocationAwareLogger.WARN_INT, String.format(format, arg1, arg2));
    }

    @Override
    public void warn(Marker marker, String format, Object... arguments) {
        log(marker, null, LocationAwareLogger.WARN_INT, String.format(format, arguments));
    }

    @Override
    public void warn(Marker marker, String msg, Throwable t) {
        log(marker, t, LocationAwareLogger.WARN_INT, msg);
    }

    @Override
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    @Override
    public void error(String msg) {
        log(null, null, LocationAwareLogger.ERROR_INT, msg);
    }

    @Override
    public void error(String format, Object arg) {
        log(null, null, LocationAwareLogger.ERROR_INT, String.format(format, arg));
    }

    @Override
    public void error(String format, Object arg1, Object arg2) {
        log(null, null, LocationAwareLogger.ERROR_INT, String.format(format, arg1, arg2));
    }

    @Override
    public void error(String format, Object... arguments) {
        log(null, null, LocationAwareLogger.ERROR_INT, String.format(format, arguments));
    }

    @Override
    public void error(String msg, Throwable t) {
        log(null, t, LocationAwareLogger.ERROR_INT, msg);
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return logger.isErrorEnabled(marker);
    }

    @Override
    public void error(Marker marker, String msg) {
        log(marker, null, LocationAwareLogger.ERROR_INT, msg);
    }

    @Override
    public void error(Marker marker, String format, Object arg) {
        log(marker, null, LocationAwareLogger.ERROR_INT, String.format(format, arg));
    }

    @Override
    public void error(Marker marker, String format, Object arg1, Object arg2) {
        log(marker, null, LocationAwareLogger.ERROR_INT, String.format(format, arg1, arg2));
    }

    @Override
    public void error(Marker marker, String format, Object... arguments) {
        log(marker, null, LocationAwareLogger.ERROR_INT, String.format(format, arguments));
    }

    @Override
    public void error(Marker marker, String msg, Throwable t) {
        log(marker, t, LocationAwareLogger.ERROR_INT, msg);
    }
    public void error(Throwable t, String format, Object...args) {
        log(null, t, LocationAwareLogger.ERROR_INT, String.format(format, args));
    }

    public void error(Throwable t) {
        log(null, t, LocationAwareLogger.ERROR_INT, "");
    }
}
