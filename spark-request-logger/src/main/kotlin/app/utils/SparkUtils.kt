package app.utils

import org.apache.logging.log4j.Logger
import org.eclipse.jetty.server.AbstractNCSARequestLog
import spark.embeddedserver.jetty.EmbeddedJettyFactory
import spark.embeddedserver.EmbeddedServers

class SparkUtils {
    companion object {
        fun createServerWithRequestLog(logger: Logger): Unit {
            val factory: EmbeddedJettyFactory = createEmbeddedJettyFactoryWithRequestLog(logger)
            EmbeddedServers.add(EmbeddedServers.Identifiers.JETTY, factory)
        }

        fun createEmbeddedJettyFactoryWithRequestLog(logger: Logger): EmbeddedJettyFactory {
            val requestLog: AbstractNCSARequestLog = RequestLogFactory(logger).create()
            return EmbeddedJettyFactoryConstructor(requestLog).create()
        }
    }
}
