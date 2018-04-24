package app.utils

import org.eclipse.jetty.server.AbstractNCSARequestLog
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.util.thread.QueuedThreadPool

import spark.embeddedserver.jetty.EmbeddedJettyFactory

class EmbeddedJettyFactoryConstructor(internal val requestLog : AbstractNCSARequestLog) {

    internal fun create() : EmbeddedJettyFactory {
        return EmbeddedJettyFactory { maxThreads : Int, minThreads : Int, threadTimeoutMillis ->
            var server : Server

            if(maxThreads > 0) {
                val max = if (maxThreads > 0) maxThreads else 200
                val min = if (minThreads > 0) minThreads else 8
                val idleTimeout = if (threadTimeoutMillis > 0) threadTimeoutMillis else 60000

                server = Server(QueuedThreadPool(max, min, idleTimeout))
            } else {
                server = Server()
            }

            server.requestLog = requestLog
            server
        }
    }
}
