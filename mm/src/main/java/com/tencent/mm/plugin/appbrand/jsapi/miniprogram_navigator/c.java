package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.plugin.appbrand.d;
import org.json.JSONObject;

public interface c {

    public static class a {
        public String businessType;
        public String dCw;
        public int ecU;
        public String ecV;
        public String leq;
        public String meP;
        public int scene;
        public int sourceType;
    }

    public interface b {
        void cancel();

        void proceed();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c$c  reason: collision with other inner class name */
    public interface AbstractC0681c {
        void o(boolean z, String str);
    }

    void a(d dVar, String str, int i2, String str2, a aVar, JSONObject jSONObject, AbstractC0681c cVar);
}
