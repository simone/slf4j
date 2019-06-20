package org.slf4j.spi;

import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.event.Level;

public class DefaultLoggingEventBuilder implements LoggingEventBuilder {

  private final Level level;
  private final Logger logger;
  private Throwable throwable;

  public DefaultLoggingEventBuilder(Logger logger, Level level) {
    this.logger = logger;
    this.level = level;
  }

  @Override
  public LoggingEventBuilder setCause(Throwable t) {
    this.throwable = t;
    return this;
  }

  private void logViaPublicLoggerAPI(String msg) {

    if (throwable == null){
      switch (level) {
        case TRACE:
          logger.trace(msg);
          break;
        case DEBUG:
          logger.debug(msg);
          break;
        case INFO:
          logger.info(msg);
          break;
        case WARN:
          logger.warn(msg);
          break;
        case ERROR:
          logger.error(msg);
          break;
      }
    } else {
      switch (level) {
        case TRACE:
          logger.trace(msg, throwable);
          break;
        case DEBUG:
          logger.debug(msg, throwable);
          break;
        case INFO:
          logger.info(msg, throwable);
          break;
        case WARN:
          logger.warn(msg, throwable);
          break;
        case ERROR:
          logger.error(msg, throwable);
          break;
      }
    }
  }

  @Override
  public void log(Supplier<String> messageSupplier) {
    if (messageSupplier != null) {
      logViaPublicLoggerAPI(messageSupplier.get());
    }
  }

}
