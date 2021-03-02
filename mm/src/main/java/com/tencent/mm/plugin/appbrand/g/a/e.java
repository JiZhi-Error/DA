package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public abstract class e implements d {
    protected a ljv;
    protected String ljw;
    protected String ljx;
    protected Map<String, String> ljy = new HashMap();
    protected String mUrl;

    public abstract String bBg();

    public e(String str, String str2) {
        this.mUrl = str;
        this.ljx = str2;
        this.ljw = bBg();
        this.ljv = a.POST;
    }

    /* access modifiers changed from: protected */
    public final void bBi() {
        cV("Content-Type", "text/xml;charset=\"utf-8\"");
        cV("Connection", "close");
    }

    /* access modifiers changed from: protected */
    public final void a(a aVar) {
        this.ljv = aVar;
    }

    public final a bBj() {
        return this.ljv;
    }

    public final void cV(String str, String str2) {
        this.ljy.put(str, str2);
    }

    public final Map<String, String> bBk() {
        return this.ljy;
    }

    public final String getUrl() {
        return this.mUrl;
    }

    public enum a {
        GET("GET"),
        POST("POST"),
        NOTIFY("NOTIFY"),
        M_SEARCH("M-SEARCH"),
        SUBSCRIBE("SUBSCRIBE"),
        UNSUBSCRIBE("UNSUBSCRIBE"),
        RENEW_SUBSCRIBE("SUBSCRIBE"),
        UNKNOWN("UNKNOWN");
        
        String name;

        public static a valueOf(String str) {
            AppMethodBeat.i(158885);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(158885);
            return aVar;
        }

        static {
            AppMethodBeat.i(158886);
            AppMethodBeat.o(158886);
        }

        private a(String str) {
            this.name = str;
        }
    }
}
