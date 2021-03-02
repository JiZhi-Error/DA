package com.tencent.mm.plugin.qqmail;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public abstract class c {
    protected static String BqJ = "";
    public static String USER_AGENT = "weixin/android";
    protected static String host = "";
    protected static int timeout = 0;

    public interface d {
        void eGj();
    }

    public static class g {
        public String filePath;
        public String param;
    }

    public abstract f a(String str, String str2, e eVar, d dVar);

    public abstract void cancel();

    public static class e {
        public g BqS = null;
        public Map<String, String> cookie;
        public int method;
        public Map<String, String> params;

        public e(int i2, Map<String, String> map, Map<String, String> map2) {
            this.method = i2;
            this.params = map;
            this.cookie = map2;
        }

        public final String toString() {
            AppMethodBeat.i(198567);
            String str = "Request method:" + this.method + ", params:" + (this.params != null ? this.params : "") + ", cookie:" + (this.cookie != null ? this.cookie : "");
            AppMethodBeat.o(198567);
            return str;
        }
    }

    public static class f {
        public String content;
        public Map<String, String> cookie;
        public int status = 0;

        public f(int i2, Map<String, String> map, String str) {
            this.status = i2;
            this.cookie = map;
            this.content = str;
        }

        public final String toString() {
            AppMethodBeat.i(198568);
            String str = "Response status:" + this.status + ", cookie:" + (this.cookie != null ? this.cookie : "") + ", content length :" + (this.content != null ? this.content.length() : 0);
            AppMethodBeat.o(198568);
            return str;
        }
    }

    public static abstract class a {
        public abstract void onError(int i2, String str);

        public abstract void onSuccess(String str, Map<String, String> map);

        public boolean onReady() {
            return true;
        }

        public void onComplete() {
        }
    }

    public static class b {
        public boolean BqK = false;
        public boolean BqL = true;
        public boolean BqM = true;

        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.i(198565);
            this.BqK = bundle.getBoolean("qqmail_httpoptions_expired");
            this.BqL = bundle.getBoolean("qqmail_httpoptions_needcache");
            this.BqM = bundle.getBoolean("qqmail_httpoptions_needparse");
            AppMethodBeat.o(198565);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.c$c  reason: collision with other inner class name */
    public static class C1612c {
        public b BqN;
        public e BqO;
        public f BqP;
        public Map<String, String> BqQ;
        public a BqR;
        public long id = System.currentTimeMillis();
        public String uri;

        public C1612c(String str, e eVar, a aVar) {
            AppMethodBeat.i(198566);
            this.uri = str;
            this.BqO = eVar;
            this.BqR = aVar;
            AppMethodBeat.o(198566);
        }
    }

    public static String d(String str, String str2, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (!str2.startsWith(HttpWrapperBase.PROTOCAL_HTTP) && !str2.startsWith(HttpWrapperBase.PROTOCAL_HTTPS)) {
            sb.append(str + host);
        }
        sb.append(str2);
        if (map == null) {
            return sb.toString();
        }
        sb.append('?');
        boolean z = true;
        for (String str3 : map.keySet()) {
            sb.append(z ? "" : "&").append(URLEncoder.encode(str3, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode(Util.nullAsNil(map.get(str3)), ProtocolPackage.ServerEncoding));
            z = false;
        }
        return sb.toString();
    }

    public static String getCookie(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (String str : map.keySet()) {
            sb.append(URLEncoder.encode(str, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode(map.get(str), ProtocolPackage.ServerEncoding));
            i2++;
            if (map.size() > i2) {
                sb.append("; ");
            }
        }
        return sb.toString();
    }

    public static Map<String, String> parseCookie(String str) {
        HashMap hashMap = new HashMap();
        if (!(str == null || str.length() == 0)) {
            for (String str2 : str.split(";")) {
                String[] split = str2.split("=");
                if (split.length == 2) {
                    hashMap.put(split[0], split[1]);
                }
            }
        }
        return hashMap;
    }
}
