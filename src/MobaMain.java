import server.ReConnectTask;
import server.WsServer;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MobaMain {

    public static void main(String[] args) {

        URI serverUri = null;
        try {
            // http://112.17.81.72:6688?server=112.17.81.72&id=
//            http://172.17.7.72:6688/?server=172.17.7.72&id=
//            http://172.17.7.72:6688/?server=172.17.7.72&id=
            serverUri = new URI("ws://112.17.81.72:7788");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        WsServer wsServer = WsServer.getInstance(serverUri);
        wsServer.connect();
        //断线重连
        ScheduledExecutorService service = Executors
                .newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        service.scheduleAtFixedRate(new ReConnectTask(serverUri), 30, 1, TimeUnit.MILLISECONDS);
    }
}
