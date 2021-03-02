package com.tencent.mm.plugin.appbrand.report.model;

import android.support.v4.e.l;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.appbrand.jsapi.audio.e;
import com.tencent.mm.plugin.appbrand.jsapi.auth.k;
import com.tencent.mm.plugin.appbrand.jsapi.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.bp;
import com.tencent.mm.plugin.appbrand.jsapi.bz;
import com.tencent.mm.plugin.appbrand.jsapi.cn;
import com.tencent.mm.plugin.appbrand.jsapi.ct;
import com.tencent.mm.plugin.appbrand.jsapi.h.h;
import com.tencent.mm.plugin.appbrand.jsapi.i.m;
import com.tencent.mm.plugin.appbrand.jsapi.k.ag;
import com.tencent.mm.plugin.appbrand.jsapi.k.d;
import com.tencent.mm.plugin.appbrand.jsapi.k.g;
import com.tencent.mm.plugin.appbrand.jsapi.k.h;
import com.tencent.mm.plugin.appbrand.jsapi.k.l;
import com.tencent.mm.plugin.appbrand.jsapi.k.v;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.p.j;
import com.tencent.mm.plugin.appbrand.jsapi.p.r;
import com.tencent.mm.plugin.appbrand.jsapi.storage.n;
import com.tencent.mm.plugin.appbrand.jsapi.storage.o;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i {
    private static final String[] nIJ = {com.tencent.mm.plugin.appbrand.jsapi.k.c.NAME, d.NAME, g.NAME, h.NAME, e.NAME, com.tencent.mm.plugin.appbrand.jsapi.o.b.b.NAME, com.tencent.mm.plugin.appbrand.jsapi.o.e.NAME, com.tencent.mm.plugin.appbrand.jsapi.audio.g.NAME, com.tencent.mm.plugin.appbrand.jsapi.p.b.NAME, f.NAME, com.tencent.mm.plugin.appbrand.jsapi.audio.h.NAME, "getCurrentRoute", l.NAME, com.tencent.mm.plugin.appbrand.jsapi.storage.f.NAME, com.tencent.mm.plugin.appbrand.jsapi.storage.i.NAME, "getSystemInfo", "hideToast", v.NAME, "onAccelerometerChange", "onCompassChange", h.a.NAME, "onMapRegionChange", "onSocketClose", "onSocketError", "onSocketMessage", "onSocketOpen", e.C0599e.NAME, e.d.NAME, e.c.NAME, "onVideoTimeUpdate", com.tencent.mm.plugin.appbrand.jsapi.audio.i.NAME, com.tencent.mm.plugin.appbrand.jsapi.o.g.NAME, com.tencent.mm.plugin.appbrand.jsapi.storage.l.NAME, "reportIDKey", com.tencent.mm.plugin.appbrand.jsapi.w.f.NAME, com.tencent.mm.plugin.appbrand.jsapi.w.g.NAME, n.NAME, o.NAME, "showModal", "showToast", "syncAudioEvent", com.tencent.mm.plugin.appbrand.jsapi.b.l.NAME, ag.NAME, ct.NAME};
    private static final Set<String> nIK = new HashSet(Arrays.asList(nIJ));
    private static final ExecutorService nIL = new com.tencent.f.b("AppBrandJsApiInvokeReportWorker", new LinkedBlockingDeque()) {
        /* class com.tencent.mm.plugin.appbrand.report.model.i.AnonymousClass1 */

        @Override // com.tencent.f.b
        public final void afterExecute(Runnable runnable, Throwable th) {
            AppMethodBeat.i(180355);
            super.afterExecute(runnable, th);
            if (runnable instanceof b) {
                i.nIM.a((b) runnable);
            }
            AppMethodBeat.o(180355);
        }
    };
    private static final c nIM = new c((byte) 0);
    private static final Pattern nIN = Pattern.compile(".*\"errMsg\":\"[^:]+:([^\"]+)\".*");

    static final class a {
        private static final Set<String> nIO = new HashSet();

        static {
            InputStream inputStream;
            AppMethodBeat.i(48121);
            try {
                inputStream = MMApplicationContext.getContext().getAssets().open("15007_api_list.txt");
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e2, "open read 15007_api_list.txt", new Object[0]);
                inputStream = null;
            }
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            return;
                        }
                        if (!Util.isNullOrNil(readLine)) {
                            nIO.add(readLine);
                        }
                    } catch (Exception e3) {
                        Log.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e3, "readLine()", new Object[0]);
                        return;
                    } finally {
                        Util.qualityClose(bufferedReader);
                        Util.qualityClose(inputStreamReader);
                        AppMethodBeat.o(48121);
                    }
                }
            } else {
                AppMethodBeat.o(48121);
            }
        }
    }

    static {
        AppMethodBeat.i(48134);
        AppMethodBeat.o(48134);
    }

    public static boolean aeO(String str) {
        AppMethodBeat.i(48130);
        if (nIK.contains(str)) {
            AppMethodBeat.o(48130);
            return true;
        }
        AppMethodBeat.o(48130);
        return false;
    }

    public static void a(String str, String str2, String str3, String str4, int i2, long j2, String str5) {
        AppMethodBeat.i(48131);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(48131);
            return;
        }
        b bUL = nIM.bUL();
        bUL.appId = str;
        bUL.dCx = str2;
        bUL.nlH = str3;
        bUL.lEA = str4;
        bUL.nIP = i2;
        bUL.costTime = j2;
        bUL.dNk = str5;
        nIL.submit(bUL);
        AppMethodBeat.o(48131);
    }

    public static String aeP(String str) {
        AppMethodBeat.i(48132);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(48132);
            return "";
        }
        Matcher matcher = nIN.matcher(str);
        if (matcher.matches()) {
            String nullAsNil = Util.nullAsNil(matcher.group(1));
            AppMethodBeat.o(48132);
            return nullAsNil;
        }
        AppMethodBeat.o(48132);
        return "";
    }

    /* access modifiers changed from: package-private */
    public static final class b implements Runnable {
        String appId;
        long costTime;
        String dCx;
        String dNk;
        String lEA;
        int nIP;
        String nlH;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        private String bUK() {
            AppMethodBeat.i(48123);
            String str = "";
            if (Util.isNullOrNil(this.dNk) || Util.isNullOrNil(this.nlH)) {
                AppMethodBeat.o(48123);
            } else {
                try {
                    String str2 = this.nlH;
                    char c2 = 65535;
                    switch (str2.hashCode()) {
                        case -316023509:
                            if (str2.equals(m.NAME)) {
                                c2 = 0;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            com.tencent.mm.ab.c FF = com.tencent.mm.ab.h.FF(this.dNk);
                            str = String.format("%s;%s;%s;%s;%s;%s;%s", FF.optString("latitude"), FF.optString("longitude"), FF.optString("speed"), FF.optString("accuracy"), FF.optString("altitude"), FF.optString("verticalAccuracy"), FF.optString("horizontalAccuracy"));
                            break;
                    }
                } catch (com.tencent.mm.ab.g e2) {
                    Log.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e2, "get keyParam error!", new Object[0]);
                }
                AppMethodBeat.o(48123);
            }
            return str;
        }

        private String b(com.tencent.mm.ab.c cVar) {
            AppMethodBeat.i(48124);
            com.tencent.mm.ab.i iVar = new com.tencent.mm.ab.i();
            try {
                String str = this.nlH;
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1701611132:
                        if (str.equals(JsApiChooseImage.NAME)) {
                            c2 = 0;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        iVar.h("sizeType", cVar.optString("sizeType"));
                        break;
                }
            } catch (com.tencent.mm.ab.g e2) {
                Log.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e2, "get keyParam error!", new Object[0]);
            }
            String str2 = null;
            try {
                str2 = URLEncoder.encode(iVar.toString(), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            } catch (UnsupportedEncodingException e3) {
            }
            AppMethodBeat.o(48124);
            return str2;
        }

        public final void run() {
            String str;
            AppMethodBeat.i(48122);
            AppBrandStatObject TS = com.tencent.mm.plugin.appbrand.a.TS(this.appId);
            if (TS == null) {
                Log.e("MicroMsg.AppBrand.JsApiInvokeReportProtocol", "statObject is Null!");
                AppMethodBeat.o(48122);
                return;
            }
            if (!i.nIK.contains(this.nlH)) {
                String str2 = "";
                String str3 = "";
                if (!Util.isNullOrNil(this.lEA) && !Util.isNullOrNil(this.nlH)) {
                    try {
                        com.tencent.mm.ab.c FF = com.tencent.mm.ab.h.FF(this.lEA);
                        str3 = b(FF);
                        if (FF.has("url") && (this.nlH.equals(bz.NAME) || this.nlH.equals(r.NAME) || this.nlH.equals(j.NAME) || this.nlH.equals(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID) || this.nlH.equals("connectSocket") || this.nlH.equals("uploadFile") || this.nlH.equals("downloadFile"))) {
                            str2 = FF.optString("url");
                        } else if (this.nlH.equals(k.NAME)) {
                            try {
                                com.tencent.mm.ab.a FG = com.tencent.mm.ab.h.FG(FF.optString("scope"));
                                LinkedList linkedList = new LinkedList();
                                for (int i2 = 0; i2 < FG.length(); i2++) {
                                    linkedList.add(FG.optString(i2));
                                }
                                str2 = linkedList.toString();
                            } catch (Exception e2) {
                                Log.e("MicroMsg.AppBrand.JsApiInvokeReportProtocol", "Exception %s", e2.getMessage());
                                AppMethodBeat.o(48122);
                                return;
                            }
                        } else if (this.nlH.equals(com.tencent.mm.plugin.appbrand.jsapi.share.d.NAME)) {
                            try {
                                str2 = URLEncoder.encode(Util.nullAsNil(FF.toString()), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                            } catch (UnsupportedEncodingException e3) {
                                Log.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e3, "", new Object[0]);
                            }
                        } else if (this.nlH.equals(com.tencent.mm.plugin.appbrand.jsapi.pay.n.NAME)) {
                            str2 = FF.optString("package");
                        } else if (this.nlH.equals(cn.NAME)) {
                            str2 = p.Um(this.appId).kCP;
                        } else if (this.nlH.equals(bp.NAME)) {
                            str2 = FF.optString("phoneNumber");
                        } else if (this.nlH.equals("chooseVideo")) {
                            str2 = FF.optString("maxDuration");
                        } else if (this.nlH.equals(com.tencent.mm.plugin.appbrand.jsapi.af.i.NAME)) {
                            str2 = FF.optString("src");
                            try {
                                str2 = URLEncoder.encode(FF.optString("src"), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                            } catch (Exception e4) {
                                Log.e("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e4.toString());
                            }
                        } else if (this.nlH.equals("showKeyboard")) {
                            str2 = FF.optString("confirmType");
                        } else if (this.nlH.equals(com.tencent.mm.plugin.appbrand.jsapi.audio.l.NAME)) {
                            str2 = FF.optString("volume");
                        }
                    } catch (com.tencent.mm.ab.g e5) {
                        Log.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e5, "get keyParam error!", new Object[0]);
                    }
                }
                String bUK = bUK();
                String str4 = "";
                if (!Util.isNullOrNil(this.dCx) && this.dCx.contains(".html")) {
                    str4 = this.dCx.substring(0, this.dCx.lastIndexOf(".html") + 5);
                }
                String str5 = "";
                try {
                    str5 = URLEncoder.encode(Util.nullAsNil(str4), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                } catch (UnsupportedEncodingException e6) {
                    Log.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e6, "encode page path error!", new Object[0]);
                }
                String str6 = "";
                try {
                    str6 = URLEncoder.encode(Util.nullAsNil(str2), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                } catch (UnsupportedEncodingException e7) {
                    Log.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e7, "encode keyParam path error!", new Object[0]);
                }
                try {
                    str = URLEncoder.encode(Util.nullAsNil(bUK), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                } catch (UnsupportedEncodingException e8) {
                    Log.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", e8, "encode keyResult path error!", new Object[0]);
                    str = "";
                }
                String nullAsNil = Util.nullAsNil(this.nlH);
                String aeP = i.aeP(this.dNk);
                int aeQ = i.aeQ(aeP);
                String nullAsNil2 = Util.nullAsNil(TS.dCw);
                String networkType = com.tencent.mm.plugin.appbrand.report.i.getNetworkType(MMApplicationContext.getContext());
                if (TS.scene == 0) {
                    TS.scene = 1000;
                }
                AppBrandSysConfigWC TR = com.tencent.mm.plugin.appbrand.a.TR(this.appId);
                if (TR != null) {
                    AppBrandInitConfigWC bsC = com.tencent.mm.plugin.appbrand.a.TQ(this.appId).bsC();
                    int i3 = TR.leE.pkgVersion;
                    int i4 = TR.leE.kNW + 1;
                    int aeH = com.tencent.mm.plugin.appbrand.report.i.aeH(this.appId);
                    if (Log.getLogLevel() <= 1) {
                        Log.d("MicroMsg.AppBrand.JsApiInvokeReportProtocol", "jsapi invoke fields, scene : %s, sceneNote %s, appId %s, appVersion %d, appState %d, pagePath %s, networkType %s, functionName %s, keyParam %s, result %d, permissionValue %d, errorCode %d, costTime %s, errCode %d, errMsg %s, usedState %d, appType %d, keyResult %s, keyRequest %s, instanceId:%s, sessionId:%s", Integer.valueOf(TS.scene), nullAsNil2, this.appId, Integer.valueOf(i3), Integer.valueOf(i4), str4, networkType, nullAsNil, str2, Integer.valueOf(aeQ), Integer.valueOf(this.nIP), 0, Long.valueOf(this.costTime), 0, aeP, Integer.valueOf(TS.nHt), Integer.valueOf(aeH), bUK, str3, bsC.cyn, bsC.cym);
                    }
                    Object[] objArr = {Integer.valueOf(TS.scene), nullAsNil2, this.appId, Integer.valueOf(i3), Integer.valueOf(i4), str5, networkType, nullAsNil, str6, Integer.valueOf(aeQ), Integer.valueOf(this.nIP), 0, Long.valueOf(this.costTime), 0, aeP, Integer.valueOf(TS.nHt), Integer.valueOf(TS.ecU), TS.ecV, Integer.valueOf(aeH), str, str3, bsC.cyn, bsC.cym};
                    boolean startsWith = nullAsNil.startsWith(com.tencent.mm.plugin.appbrand.jsapi.share.d.NAME);
                    if (startsWith) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13542, false, false, true, objArr);
                    } else {
                        com.tencent.mm.plugin.appbrand.report.a aVar = com.tencent.mm.plugin.appbrand.report.a.nFX;
                        com.tencent.mm.plugin.appbrand.report.a.a(13542, false, false, true, objArr);
                    }
                    if (a.nIO.contains(nullAsNil)) {
                        if (startsWith) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(15761, objArr);
                            AppMethodBeat.o(48122);
                            return;
                        }
                        com.tencent.mm.plugin.appbrand.report.a.nFX.a(15761, objArr);
                    }
                }
            }
            AppMethodBeat.o(48122);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c implements l.a<b> {
        private final Queue<b> dxk;

        private c() {
            AppMethodBeat.i(48125);
            this.dxk = new ConcurrentLinkedQueue();
            AppMethodBeat.o(48125);
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.support.v4.e.l.a
        public final /* synthetic */ b acquire() {
            AppMethodBeat.i(48129);
            b bUL = bUL();
            AppMethodBeat.o(48129);
            return bUL;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.support.v4.e.l.a
        public final /* synthetic */ boolean release(b bVar) {
            AppMethodBeat.i(48128);
            boolean a2 = a(bVar);
            AppMethodBeat.o(48128);
            return a2;
        }

        public final b bUL() {
            AppMethodBeat.i(48126);
            b poll = this.dxk.poll();
            if (poll == null) {
                b bVar = new b((byte) 0);
                AppMethodBeat.o(48126);
                return bVar;
            }
            AppMethodBeat.o(48126);
            return poll;
        }

        public final boolean a(b bVar) {
            AppMethodBeat.i(48127);
            boolean offer = this.dxk.offer(bVar);
            AppMethodBeat.o(48127);
            return offer;
        }
    }

    static /* synthetic */ int aeQ(String str) {
        AppMethodBeat.i(48133);
        if (Util.isNullOrNil(str) || str.startsWith("ok") || !str.startsWith("fail")) {
            AppMethodBeat.o(48133);
            return 1;
        }
        AppMethodBeat.o(48133);
        return 2;
    }
}
