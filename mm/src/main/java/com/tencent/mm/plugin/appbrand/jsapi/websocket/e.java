package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.mm.plugin.appbrand.ae.e.h;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Timer;

public interface e {
    public static final String jEY = null;

    public interface a {
        void XT(String str);

        void a(com.tencent.mm.plugin.appbrand.ae.e.a aVar);

        void a(h hVar, Map<String, Long> map);

        void aar(String str);

        void ae(int i2, String str);

        void k(ByteBuffer byteBuffer);
    }

    void a(a aVar);

    void a(Socket socket);

    void a(Timer timer);

    void abA(String str);

    void abz(String str);

    Timer bLn();

    void bQ(String str, int i2);

    String bjl();

    void close();

    void connect();

    Socket getSocket();

    boolean isOpen();

    void o(ByteBuffer byteBuffer);

    void setTcpNoDelay(boolean z);
}
