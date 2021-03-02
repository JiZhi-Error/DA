package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.mm.plugin.appbrand.ae.e.h;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

public interface d {
    public static final ArrayList<e> mGL = new ArrayList<>();

    public interface a {
        void XT(String str);

        void XU(String str);

        void a(com.tencent.mm.plugin.appbrand.ae.e.a aVar);

        void a(h hVar, Map<String, Long> map);

        void aar(String str);

        void ae(int i2, String str);

        void k(ByteBuffer byteBuffer);
    }

    void a(e eVar);

    void a(e eVar, int i2, String str);

    void a(e eVar, String str);

    void a(e eVar, ByteBuffer byteBuffer);

    void a(String str, String str2, int i2, int i3, JSONObject jSONObject, Map<String, String> map, a aVar);

    e aby(String str);

    boolean b(e eVar);

    void release();
}
