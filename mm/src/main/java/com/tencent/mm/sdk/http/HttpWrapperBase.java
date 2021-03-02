package com.tencent.mm.sdk.http;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public abstract class HttpWrapperBase {
    protected static final String ACCEPT_ENCODING = "compress;q=0.5, gzip;q=1.0";
    protected static final String CHARSET = "utf-8";
    public static final int METHOD_GET = 0;
    public static final int METHOD_POST = 1;
    public static final String PROTOCAL_HTTP = "http://";
    public static final String PROTOCAL_HTTPS = "https://";
    private static final String TAG = "MicroMsg.HttpWrapperBase";
    protected final String userAgent = "weixin/android";

    public abstract void cancel();

    public abstract void send(Request request, Response response);

    public static class Attachment {
        public String filePath;
        public String param;

        public Attachment(String str, String str2) {
            this.param = str;
            this.filePath = str2;
        }
    }

    public static class Request {
        public Attachment attachment;
        public Map<String, String> cookie;
        public byte[] customPostData;
        public String host;
        public int method;
        public Map<String, String> params;
        public String protocal;
        public int timeout;
        public String uri;

        public Request(int i2, Map<String, String> map, Map<String, String> map2, Attachment attachment2) {
            this.method = i2;
            this.params = map;
            this.cookie = map2;
            this.attachment = attachment2;
        }

        public String getUrl() {
            AppMethodBeat.i(157522);
            StringBuilder sb = new StringBuilder();
            if (!this.uri.startsWith(HttpWrapperBase.PROTOCAL_HTTP) && !this.uri.startsWith(HttpWrapperBase.PROTOCAL_HTTPS)) {
                sb.append(this.protocal + this.host);
            }
            sb.append(this.uri);
            if (this.params == null) {
                String sb2 = sb.toString();
                AppMethodBeat.o(157522);
                return sb2;
            }
            sb.append('?');
            boolean z = true;
            for (String str : this.params.keySet()) {
                sb.append(z ? "" : "&").append(URLEncoder.encode(str, "utf-8")).append('=').append(URLEncoder.encode(Util.nullAsNil(this.params.get(str)), "utf-8"));
                z = false;
            }
            String sb3 = sb.toString();
            AppMethodBeat.o(157522);
            return sb3;
        }

        public String toString() {
            AppMethodBeat.i(157523);
            try {
                String url = getUrl();
                AppMethodBeat.o(157523);
                return url;
            } catch (UnsupportedEncodingException e2) {
                Log.printErrStackTrace(HttpWrapperBase.TAG, e2, "", new Object[0]);
                AppMethodBeat.o(157523);
                return "";
            }
        }
    }

    public static class Response {
        public Attachment attachment;
        public String content;
        public long contentLength;
        public Map<String, String> cookie;
        public int status = 0;

        public Response(int i2, Map<String, String> map, String str) {
            this.status = i2;
            this.cookie = map;
            this.content = str;
        }

        public String toString() {
            AppMethodBeat.i(157524);
            String str = "Response status:" + this.status + ", cookie:" + (this.cookie != null ? this.cookie : "") + ", content length :" + (this.content != null ? this.content.length() : 0);
            AppMethodBeat.o(157524);
            return str;
        }

        public void onComplete() {
        }
    }

    public void asyncSend(final Request request, final Response response, final MMHandler mMHandler) {
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.sdk.http.HttpWrapperBase.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(157521);
                HttpWrapperBase.this.send(request, response);
                if (mMHandler != null) {
                    mMHandler.post(new Runnable() {
                        /* class com.tencent.mm.sdk.http.HttpWrapperBase.AnonymousClass1.AnonymousClass1 */

                        public void run() {
                            AppMethodBeat.i(157520);
                            response.onComplete();
                            AppMethodBeat.o(157520);
                        }
                    });
                    AppMethodBeat.o(157521);
                    return;
                }
                response.onComplete();
                AppMethodBeat.o(157521);
            }
        }, getClass().getName());
    }

    public static String getCookie(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (String str : map.keySet()) {
            sb.append(URLEncoder.encode(str, "utf-8")).append('=').append(URLEncoder.encode(map.get(str), "utf-8"));
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
