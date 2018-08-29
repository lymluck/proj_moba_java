package server;

import com.alibaba.fastjson.JSON;
import entity.GameInfo;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import tactics.Three;
import util.InstructionsUtils;
import util.NowDataUtils;

import java.net.URI;

/**
 * 需要考虑断线重连机制
 */
public class WsServer extends WebSocketClient {

    private static volatile WsServer instance = null;
    private boolean isConnect;

    public boolean isConnect() {
        return isConnect;
    }

    public WsServer(URI serverUri) {
        super(serverUri);
    }


    public static WsServer getInstance(URI serverUri) {
        if (instance == null) {
            synchronized (WsServer.class) {
                if (instance == null) {
                    instance = new WsServer(serverUri);
                }
            }
        }
        return instance;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("onOpen");
        isConnect = true;
        //连接成功，加入房间
        InstructionsUtils.joinRoom(this);

    }

    @Override
    public void onMessage(String message) {
        System.out.println("onMessage：" + message);
        //响应服务器指令
        GameInfo info = JSON.parseObject(message, GameInfo.class);
        switch (info.getType()) {
            case "picking":
                //选择英雄
                InstructionsUtils.chooseHero(this);
                break;
            case "update":
                //状态更新,5人实时战斗
                String myCamp = info.getMyCamp();
                GameInfo.StateEntity state = info.getState();
                Three.realTimeAttack(this, NowDataUtils.getHeros(myCamp, state.getHeros()), NowDataUtils.getTowers(myCamp, state.getTowers()), state);
                state = null;
                break;
            case "start":
                //游戏开始
                break;
        }
        info = null;
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("onClose:" + code);
        isConnect = false;
    }

    @Override
    public void onError(Exception ex) {
        System.out.println("onError:" + ex.getMessage());
        isConnect = false;
    }

}
