package org.slf4j.spi;

import java.util.function.Supplier;

import org.slf4j.Marker;

/**
 * A no-operation implementation of {@link LoggingEventBuilder}.
 * As the name indicates, this implementation does nothing.
 *
 * @author Ceki G&uuml;lc&uuml;
 * @since 2.0.0
 *
 */
public class NOPLoggingEventBuilder implements LoggingEventBuilder {

	static final NOPLoggingEventBuilder SINGLETON = new NOPLoggingEventBuilder();

	public static LoggingEventBuilder singleton() {
		return SINGLETON;
	}

	@Override
	public LoggingEventBuilder setCause(Throwable cause) {
		return singleton();
	}

	@Override
	public void log(Supplier<String> messageSupplier) {
	}

}
