package server;

import java.net.URI;

public class ReConnectTask implements Runnable {

    private URI serverUri;

    public ReConnectTask(URI serverUri) {
        this.serverUri = serverUri;
    }

    @Override
    public void run() {
        if (!WsServer.getInstance(serverUri).isConnect()) {
            WsServer.getInstance(serverUri).connect();
        }
    }
}
