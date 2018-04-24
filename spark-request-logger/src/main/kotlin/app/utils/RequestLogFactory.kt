package app.utils

import org.apache.logging.log4j.Logger
import org.eclipse.jetty.server.AbstractNCSARequestLog

class RequestLogFactory constructor(val logger: Logger) {

    fun create(): AbstractNCSARequestLog {
        return object: AbstractNCSARequestLog() {
            override fun isEnabled() : Boolean {
                return true
            }

            override fun write(string : String) {
                logger.info(string)
            }
        }
    }
}
