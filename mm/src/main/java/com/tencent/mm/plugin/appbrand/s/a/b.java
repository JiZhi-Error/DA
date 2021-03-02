package com.tencent.mm.plugin.appbrand.s.a;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.f.h;
import com.tencent.luggage.a.e;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.s.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLContext;

public final class b implements Runnable {
    private HttpURLConnection conn;
    private String contentType = "unknow";
    String filename;
    public volatile boolean isRunning = false;
    public String jEY;
    private boolean jFh = false;
    private boolean jFi = false;
    private String jsf;
    f lqg;
    private final String mGo;
    private boolean mgB = false;
    public SSLContext nhR;
    boolean niA = true;
    public ArrayList<String> nis;
    int nit = 15;
    public String nix;
    volatile boolean niy = false;
    private boolean niz = false;
    final a njm;
    public Map<String, String> njn;
    public volatile int njo;
    long njp;
    String njq;
    private long startTime;
    public int timeout = 60000;
    String uri;

    public b(f fVar, String str, String str2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, a aVar) {
        AppMethodBeat.i(207111);
        this.lqg = fVar;
        this.uri = str;
        this.filename = str2;
        this.jsf = str3;
        this.njm = aVar;
        this.startTime = System.currentTimeMillis();
        this.mGo = str4;
        this.mgB = z;
        this.jFh = z2;
        this.jFi = z3;
        this.niz = z4;
        this.niA = z5;
        AppMethodBeat.o(207111);
    }

    private String getUrl() {
        return this.uri;
    }

    public final void run() {
        AppMethodBeat.i(144466);
        if (!URLUtil.isHttpsUrl(this.uri) && !URLUtil.isHttpUrl(this.uri)) {
            this.njm.K(this.filename, this.uri, "downloadFile protocol must be http or https");
            AppMethodBeat.o(144466);
        } else if (this.nis != null && !j.c(this.nis, this.uri)) {
            this.njm.K(this.filename, this.uri, "url not in domain list");
            Log.i("MicroMsg.AppBrandDownloadWorker", "not in domain url %s", this.uri);
            AppMethodBeat.o(144466);
        } else if (this.mgB) {
            final long currentTimeMillis = System.currentTimeMillis();
            final a aVar = new a();
            if (!this.isRunning) {
                this.njm.K(this.filename, this.uri, "force stop");
                if (Util.isNullOrNil(this.jsf)) {
                    ((o) e.N(o.class)).a(this.lqg.getAppId(), this.nix, "GET", this.uri, 0, 0, 0, 2, bPz(), this.filename, this.contentType);
                    AppMethodBeat.o(144466);
                    return;
                }
                ((o) e.N(o.class)).a(this.lqg.getAppId(), this.nix, "GET", this.uri, 0, 0, 0, 2, bPz(), this.jsf, this.contentType);
                AppMethodBeat.o(144466);
                return;
            }
            this.njp = System.currentTimeMillis();
            this.njm.ey(this.filename, this.uri);
            ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197, 0, 1, false);
            Log.i("MicroMsg.AppBrandDownloadWorker", "downloadCronetFile prepare to start download taskid is %s, usehttp2 is %b, usequic is %b, usecache is %b, url is %s, filename is %s", this.jEY, Boolean.valueOf(this.jFh), Boolean.valueOf(this.jFi), Boolean.valueOf(this.niz), this.uri, this.filename);
            final AnonymousClass1 r2 = new com.tencent.f.i.b() {
                /* class com.tencent.mm.plugin.appbrand.s.a.b.AnonymousClass1 */

                @Override // com.tencent.f.i.h, com.tencent.f.i.g
                public final String getKey() {
                    return "AppBrandDownloadWorker#TimerTask";
                }

                public final void run() {
                    AppMethodBeat.i(175396);
                    Log.e("MicroMsg.AppBrandDownloadWorker", "call cronet time out taskid:%s,timeout:%d,url:%s", b.this.jEY, Integer.valueOf(b.this.timeout), b.this.uri);
                    if (!b.this.niy) {
                        b.this.niy = true;
                        b.this.njm.K(b.this.filename, b.this.uri, "socket timeout");
                    } else {
                        Log.e("MicroMsg.AppBrandDownloadWorker", "call cronet time out already callback");
                    }
                    ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197, 6, 1, false);
                    if (!Util.isNullOrNil(b.this.njq)) {
                        CronetLogic.cancelCronetTask(b.this.njq);
                    }
                    AppMethodBeat.o(175396);
                }
            };
            AnonymousClass2 r0 = new CronetLogic.CronetTaskCallback() {
                /* class com.tencent.mm.plugin.appbrand.s.a.b.AnonymousClass2 */

                @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
                public final void onDownloadProgressChanged(String str, CronetLogic.CronetDownloadProgress cronetDownloadProgress) {
                    AppMethodBeat.i(175398);
                    if (j.I(b.this.lqg)) {
                        Log.w("MicroMsg.AppBrandDownloadWorker", "onDownloadProgressChanged shouldStopTask fileKey:%s,taskid %s,CronetRequestId:%s", str, b.this.jEY, b.this.njq);
                        if (!b.this.niy) {
                            b.this.niy = true;
                            CronetLogic.cancelCronetTask(b.this.njq);
                            b.this.njm.K(b.this.filename, b.this.uri, "interrupted");
                        } else {
                            Log.e("MicroMsg.AppBrandDownloadWorker", "onDownloadProgressChanged already callback");
                        }
                        if (r2 != null) {
                            r2.cancel();
                            Log.i("MicroMsg.AppBrandDownloadWorker", "cronet onDownloadProgressChanged shouldStopTask TimerTask cancel");
                        }
                        AppMethodBeat.o(175398);
                    } else if (cronetDownloadProgress.currentWriteByte <= 0 || b.this.njo <= 0 || cronetDownloadProgress.currentWriteByte < ((long) (b.this.njo * 1048576))) {
                        if (cronetDownloadProgress.totalByte > 0 && b.this.isRunning) {
                            if (cronetDownloadProgress.totalByte > 0) {
                                if (cronetDownloadProgress.currentWriteByte > cronetDownloadProgress.totalByte) {
                                    aVar.percent = 100;
                                } else {
                                    aVar.percent = (int) ((cronetDownloadProgress.currentWriteByte * 100) / cronetDownloadProgress.totalByte);
                                }
                                if (aVar.jEa != aVar.percent) {
                                    a aVar = b.this.njm;
                                    String unused = b.this.filename;
                                    aVar.a(b.this.uri, aVar.percent, cronetDownloadProgress.currentWriteByte, cronetDownloadProgress.totalByte);
                                    aVar.jEa = aVar.percent;
                                }
                            } else {
                                a aVar2 = b.this.njm;
                                String unused2 = b.this.filename;
                                aVar2.a(b.this.uri, aVar.percent, cronetDownloadProgress.currentWriteByte, 0);
                            }
                            if (aVar.percent == 100) {
                                Log.i("MicroMsg.AppBrandDownloadWorker", "cronet download size %d, totalSize %d, percent = %d", Long.valueOf(cronetDownloadProgress.currentWriteByte), Long.valueOf(cronetDownloadProgress.totalByte), Integer.valueOf(aVar.percent));
                            }
                        }
                        AppMethodBeat.o(175398);
                    } else if (!b.this.niy) {
                        Log.i("MicroMsg.AppBrandDownloadWorker", "onDownloadProgressChanged currentWriteByte %d exceed limit,fileKey:%s,taskid %s,CronetRequestId:%s", Long.valueOf(cronetDownloadProgress.currentWriteByte), str, b.this.jEY, b.this.njq);
                        b.this.niy = true;
                        CronetLogic.cancelCronetTask(b.this.njq);
                        b.this.njm.K(b.this.filename, b.this.uri, "exceed max file size");
                        if (r2 != null) {
                            r2.cancel();
                            Log.i("MicroMsg.AppBrandDownloadWorker", "cronet onDownloadProgressChanged exceed max file size TimerTask cancel");
                        }
                        AppMethodBeat.o(175398);
                    } else {
                        Log.e("MicroMsg.AppBrandDownloadWorker", "cronet onDownloadProgressChanged max file size already callback");
                        AppMethodBeat.o(175398);
                    }
                }

                @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
                public final int onCronetReceiveHeader(CronetLogic.ResponseHeader responseHeader, int i2) {
                    int i3;
                    AppMethodBeat.i(175399);
                    Log.i("MicroMsg.AppBrandDownloadWorker", "cronet file download onCronetReceiveHeader status %d,taskid:%s,CronetRequestId:%s", Integer.valueOf(i2), b.this.jEY, b.this.njq);
                    Map<String, List<String>> headerList = CronetLogic.getHeaderList(responseHeader);
                    b.this.njm.J(j.c(headerList, 2));
                    Iterator<Map.Entry<String, List<String>>> it = headerList.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            i3 = 0;
                            break;
                        }
                        Map.Entry<String, List<String>> next = it.next();
                        String key = next.getKey();
                        List<String> value = next.getValue();
                        if (!Util.isNullOrNil(key) && value != null && !value.isEmpty()) {
                            if (key.equals("Content-Length")) {
                                Log.i("MicroMsg.AppBrandDownloadWorker", "onCronetReceiveHeader Content-Length:%s", value.get(0));
                                i3 = Integer.parseInt(value.get(0));
                                break;
                            } else if (key.equals("content-length")) {
                                Log.i("MicroMsg.AppBrandDownloadWorker", "onCronetReceiveHeader content-length:%s", value.get(0));
                                i3 = Integer.parseInt(value.get(0));
                                break;
                            }
                        }
                    }
                    if (i3 > 0) {
                        ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197, 16, (long) i3, false);
                    } else {
                        Log.e("MicroMsg.AppBrandDownloadWorker", "cronet onCronetReceiveHeader contentLength fail");
                    }
                    if (i3 <= 0 || b.this.njo <= 0 || i3 < b.this.njo * 1048576) {
                        AppMethodBeat.o(175399);
                        return 0;
                    }
                    Log.i("MicroMsg.AppBrandDownloadWorker", "onCronetReceiveHeader before actually read stream, contentLength %d exceed limit", Integer.valueOf(i3));
                    if (!b.this.niy) {
                        b.this.niy = true;
                        b.this.njm.K(b.this.filename, b.this.uri, "exceed max file size");
                    } else {
                        Log.e("MicroMsg.AppBrandDownloadWorker", "cronet onCronetReceiveHeader max file size already callback");
                    }
                    if (r2 != null) {
                        r2.cancel();
                        Log.i("MicroMsg.AppBrandDownloadWorker", "cronet onCronetReceiveHeader exceed max file size TimerTask cancel");
                    }
                    AppMethodBeat.o(175399);
                    return -1;
                }

                @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
                public final void onCronetTaskCompleted(String str, final CronetLogic.CronetTaskResult cronetTaskResult) {
                    AppMethodBeat.i(175400);
                    Log.i("MicroMsg.AppBrandDownloadWorker", "onCronetTaskCompleted errorCode:%d,errorMsg:%s,statusCode:%d,totalReceiveByte:%d,taskid:%s,CronetRequestId:%s,fileKey:%s", Integer.valueOf(cronetTaskResult.errorCode), cronetTaskResult.errorMsg, Integer.valueOf(cronetTaskResult.statusCode), Long.valueOf(cronetTaskResult.totalReceiveByte), b.this.jEY, b.this.njq, str);
                    if (r2 != null) {
                        r2.cancel();
                    }
                    h.RTc.aX(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.s.a.b.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(175397);
                            int i2 = (int) cronetTaskResult.totalReceiveByte;
                            int i3 = cronetTaskResult.statusCode;
                            Log.i("MicroMsg.AppBrandDownloadWorker", "appbrand_cronetdownload_callback_thread run taskid:%s,CronetRequestId:%s", b.this.jEY, b.this.njq);
                            if (cronetTaskResult.errorCode == 0) {
                                int i4 = 28;
                                if (i3 >= 100 && i3 < 200) {
                                    i4 = 20;
                                } else if (200 == i3) {
                                    i4 = 21;
                                } else if (i3 > 200 && i3 < 300) {
                                    i4 = 22;
                                } else if (302 == i3) {
                                    i4 = 23;
                                } else if (i3 >= 300 && i3 < 400) {
                                    i4 = 24;
                                } else if (404 == i3) {
                                    i4 = 25;
                                } else if (i3 >= 400 && i3 < 500) {
                                    i4 = 26;
                                } else if (i3 >= 500) {
                                    i4 = 27;
                                }
                                ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197, (long) i4, 1, false);
                                Log.i("MicroMsg.AppBrandDownloadWorker", "reportCronetStatusCode:%d, key:%d", Integer.valueOf(i3), Integer.valueOf(i4));
                                String str = "";
                                for (Map.Entry<String, String> entry : cronetTaskResult.getHeaderMap().entrySet()) {
                                    String key = entry.getKey();
                                    String value = entry.getValue();
                                    if (key.equalsIgnoreCase("Content-Type") || key.equalsIgnoreCase("content-type")) {
                                        str = b.ez(value, b.this.uri);
                                    }
                                }
                                if (i3 != 200) {
                                    Log.e("MicroMsg.AppBrandDownloadWorker", "failed code: %d,url is %s,filename is %s ", Integer.valueOf(i3), b.this.uri, b.this.filename);
                                    if (j.rS(i3)) {
                                        String str2 = cronetTaskResult.newLocation;
                                        if (!TextUtils.isEmpty(str2)) {
                                            b bVar = b.this;
                                            int i5 = bVar.nit;
                                            bVar.nit = i5 - 1;
                                            if (i5 <= 0) {
                                                Log.w("MicroMsg.AppBrandDownloadWorker", "reach the max redirect count(%d)", 15);
                                                if (!b.this.niy) {
                                                    b.this.niy = true;
                                                    if (b.this.niA) {
                                                        b.this.njm.a(b.this.filename, str, b.this.uri, i3, 0, j.a(cronetTaskResult.webPageProfile));
                                                    } else {
                                                        b.this.njm.a(b.this.filename, str, b.this.uri, i3, 0, null);
                                                    }
                                                    ((o) e.N(o.class)).a(b.this.lqg.getAppId(), b.this.nix, "GET", b.this.uri, 0, (long) i2, i3, 1, b.this.bPz(), b.this.filename, str);
                                                    ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197, 10, 1, false);
                                                    ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197, 12, System.currentTimeMillis() - b.this.njp, false);
                                                    AppMethodBeat.o(175397);
                                                    return;
                                                }
                                                Log.e("MicroMsg.AppBrandDownloadWorker", "cronet onCronetTaskCompleted max redirect already callback");
                                                AppMethodBeat.o(175397);
                                                return;
                                            }
                                            Log.i("MicroMsg.AppBrandDownloadWorker", "redirect(%d) URL(%s) to URL(%s)", Integer.valueOf(b.this.nit), b.this.uri, str2);
                                            b.this.uri = str2;
                                            b.this.run();
                                            AppMethodBeat.o(175397);
                                            return;
                                        }
                                    }
                                }
                                if (!b.this.niy) {
                                    b.this.niy = true;
                                    if (b.this.isRunning) {
                                        if (b.this.niA) {
                                            b.this.njm.a(b.this.filename, str, b.this.uri, i3, (long) i2, j.a(cronetTaskResult.webPageProfile));
                                        } else {
                                            b.this.njm.a(b.this.filename, str, b.this.uri, i3, (long) i2, null);
                                        }
                                        long j2 = cronetTaskResult.totalReceiveByte;
                                        long currentTimeMillis = System.currentTimeMillis() - b.this.njp;
                                        if (j2 <= 0 || currentTimeMillis <= 0) {
                                            Log.i("MicroMsg.AppBrandDownloadWorker", "reportCronetSpeed len:%d, time:%d return", Long.valueOf(j2), Long.valueOf(currentTimeMillis));
                                        } else {
                                            int i6 = 34;
                                            double d2 = (((double) j2) / ((double) currentTimeMillis)) * 0.9765625d;
                                            if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
                                                i6 = 30;
                                            } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
                                                i6 = 31;
                                            } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
                                                i6 = 32;
                                            } else if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                                                i6 = 33;
                                            }
                                            ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197, (long) i6, (long) d2, false);
                                            Log.i("MicroMsg.AppBrandDownloadWorker", "reportCronetSpeed len:%d, time:%d, speed:%f, key:%d", Long.valueOf(j2), Long.valueOf(currentTimeMillis), Double.valueOf(d2), Integer.valueOf(i6));
                                        }
                                        aVar.success = true;
                                    } else {
                                        b.this.njm.K(b.this.filename, b.this.uri, "force stop");
                                    }
                                    Log.i("MicroMsg.AppBrandDownloadWorker", "cronet download file finished taskid:%s,CronetRequestId:%s,contentType:%s,filename: %s, url:%s ", b.this.jEY, b.this.njq, str, b.this.filename, b.this.uri);
                                    b.this.njm.acU(b.this.jEY);
                                    ((o) e.N(o.class)).a(b.this.lqg.getAppId(), b.this.nix, "GET", b.this.uri, 0, (long) i2, i3, 1, b.this.bPz(), b.this.filename, str);
                                    ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197, 10, 1, false);
                                    ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197, 12, System.currentTimeMillis() - b.this.njp, false);
                                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                    Log.i("cronet download time", "request time is ".concat(String.valueOf(currentTimeMillis2)));
                                    ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1199, 99, currentTimeMillis2, false);
                                    ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1199, 97, 1, false);
                                    AppMethodBeat.o(175397);
                                    return;
                                }
                                Log.e("MicroMsg.AppBrandDownloadWorker", "cronet onCronetTaskCompleted already callback");
                                AppMethodBeat.o(175397);
                            } else if (!b.this.niy) {
                                b.this.niy = true;
                                b.this.njm.K(b.this.filename, b.this.uri, "download fail:" + cronetTaskResult.errorCode + ":" + cronetTaskResult.errorMsg);
                                ((o) e.N(o.class)).a(b.this.lqg.getAppId(), b.this.nix, "GET", b.this.uri, 0, (long) i2, i3, 2, b.this.bPz(), b.this.filename, "");
                                ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197, 11, 1, false);
                                ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197, 13, System.currentTimeMillis() - b.this.njp, false);
                                int netType = NetStatusUtil.getNetType(MMApplicationContext.getContext());
                                if (netType == -1) {
                                    ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197, 7, 1, false);
                                }
                                Log.i("MicroMsg.AppBrandDownloadWorker", "cronet downloadFile fail ret:%d", Integer.valueOf(netType));
                                AppMethodBeat.o(175397);
                            } else {
                                Log.e("MicroMsg.AppBrandDownloadWorker", "cronet onCronetTaskCompleted downloadFile fail already callback");
                                AppMethodBeat.o(175397);
                            }
                        }
                    });
                    AppMethodBeat.o(175400);
                }
            };
            CronetLogic.CronetRequestParams cronetRequestParams = new CronetLogic.CronetRequestParams();
            cronetRequestParams.url = this.uri;
            cronetRequestParams.taskId = this.jEY;
            cronetRequestParams.followRedirect = false;
            cronetRequestParams.savePath = this.filename;
            cronetRequestParams.method = "GET";
            cronetRequestParams.needWirteCache = true;
            cronetRequestParams.useHttp2 = this.jFh;
            cronetRequestParams.useQuic = this.jFi;
            cronetRequestParams.useMemoryCache = this.niz;
            Map<String, String> map = this.njn;
            if (!map.containsKey("Accept-Encoding")) {
                map.put("Accept-Encoding", "gzip,compress,br,deflate");
            } else {
                Log.i("MicroMsg.AppBrandDownloadWorker", "startCronetHttpsRequest Accept-Encoding:%s", map.get("Accept-Encoding"));
            }
            map.put("User-Agent", this.mGo);
            cronetRequestParams.makeRequestHeader(map);
            this.njm.J(j.c(j.X(map), 1));
            cronetRequestParams.taskType = 2;
            h.RTc.o(r2, (long) this.timeout);
            Log.i("MicroMsg.AppBrandDownloadWorker", "startCronetHttpsRequest taskId:%s", cronetRequestParams.taskId);
            CronetLogic.CronetHttpsCreateResult startCronetDownloadTask = CronetLogic.startCronetDownloadTask(cronetRequestParams, r0);
            Log.i("MicroMsg.AppBrandDownloadWorker", "startCronetHttpsRequest createRet is %d, taskId %s,CronetRequestId:%s", Integer.valueOf(startCronetDownloadTask.createRet), this.jEY, startCronetDownloadTask.taskId);
            if (startCronetDownloadTask == null || startCronetDownloadTask.createRet == 0) {
                this.njq = startCronetDownloadTask.taskId;
                ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197, 2, 1, false);
                AppMethodBeat.o(144466);
                return;
            }
            ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197, 1, 1, false);
            AppMethodBeat.o(144466);
        } else {
            bPM();
            AppMethodBeat.o(144466);
        }
    }

    /* access modifiers changed from: package-private */
    public class a {
        public int jEa = -1;
        public int percent = 0;
        public boolean success = false;

        a() {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:106:0x085a, code lost:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", r2, "Exception: read err stream failed", new java.lang.Object[0]);
        r28 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x01c1, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x01c2, code lost:
        r17 = null;
        r20 = null;
        r15 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x12e5, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x12e6, code lost:
        r21 = null;
        r28 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:314:0x1543, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:315:0x1544, code lost:
        r21 = null;
        r28 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:0x17a1, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:347:0x17a2, code lost:
        r21 = null;
        r28 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:378:0x19ff, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x1a00, code lost:
        r21 = null;
        r28 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:410:0x1c6b, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:411:0x1c6c, code lost:
        r21 = null;
        r28 = null;
        r10 = 0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x01c1 A[ExcHandler: UnsupportedEncodingException (e java.io.UnsupportedEncodingException), PHI: r12 
      PHI: (r12v11 int) = (r12v0 int), (r12v12 int), (r12v12 int) binds: [B:7:0x00be, B:75:0x06c1, B:101:0x083c] A[DONT_GENERATE, DONT_INLINE], Splitter:B:7:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x119f  */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x12e5 A[ExcHandler: FileNotFoundException (e java.io.FileNotFoundException), PHI: r12 
      PHI: (r12v9 int) = (r12v0 int), (r12v12 int), (r12v12 int) binds: [B:7:0x00be, B:75:0x06c1, B:101:0x083c] A[DONT_GENERATE, DONT_INLINE], Splitter:B:7:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x132a  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x1392 A[SYNTHETIC, Splitter:B:291:0x1392] */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x1397 A[SYNTHETIC, Splitter:B:294:0x1397] */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x13fd  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0270 A[SYNTHETIC, Splitter:B:30:0x0270] */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x1543 A[ExcHandler: SSLHandshakeException (e javax.net.ssl.SSLHandshakeException), PHI: r12 
      PHI: (r12v7 int) = (r12v0 int), (r12v12 int), (r12v12 int) binds: [B:7:0x00be, B:75:0x06c1, B:101:0x083c] A[DONT_GENERATE, DONT_INLINE], Splitter:B:7:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x1588  */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x15f0 A[SYNTHETIC, Splitter:B:323:0x15f0] */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x15f5 A[SYNTHETIC, Splitter:B:326:0x15f5] */
    /* JADX WARNING: Removed duplicated region for block: B:330:0x165b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0275 A[SYNTHETIC, Splitter:B:33:0x0275] */
    /* JADX WARNING: Removed duplicated region for block: B:346:0x17a1 A[ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), PHI: r12 
      PHI: (r12v5 int) = (r12v0 int), (r12v12 int), (r12v12 int) binds: [B:7:0x00be, B:75:0x06c1, B:101:0x083c] A[DONT_GENERATE, DONT_INLINE], Splitter:B:7:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x17e6  */
    /* JADX WARNING: Removed duplicated region for block: B:355:0x184e A[SYNTHETIC, Splitter:B:355:0x184e] */
    /* JADX WARNING: Removed duplicated region for block: B:358:0x1853 A[SYNTHETIC, Splitter:B:358:0x1853] */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x18b9  */
    /* JADX WARNING: Removed duplicated region for block: B:382:0x1a52  */
    /* JADX WARNING: Removed duplicated region for block: B:387:0x1aba A[SYNTHETIC, Splitter:B:387:0x1aba] */
    /* JADX WARNING: Removed duplicated region for block: B:390:0x1abf A[SYNTHETIC, Splitter:B:390:0x1abf] */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x1b25  */
    /* JADX WARNING: Removed duplicated region for block: B:410:0x1c6b A[ExcHandler: all (th java.lang.Throwable), PHI: r12 
      PHI: (r12v2 int) = (r12v0 int), (r12v12 int), (r12v12 int) binds: [B:7:0x00be, B:75:0x06c1, B:101:0x083c] A[DONT_GENERATE, DONT_INLINE], Splitter:B:7:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:413:0x1c74  */
    /* JADX WARNING: Removed duplicated region for block: B:418:0x1cda A[SYNTHETIC, Splitter:B:418:0x1cda] */
    /* JADX WARNING: Removed duplicated region for block: B:421:0x1cdf A[SYNTHETIC, Splitter:B:421:0x1cdf] */
    /* JADX WARNING: Removed duplicated region for block: B:426:0x1d42  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bPM() {
        /*
        // Method dump skipped, instructions count: 8044
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.s.a.b.bPM():void");
    }

    public final void bPN() {
        AppMethodBeat.i(144468);
        this.isRunning = false;
        if (this.conn != null) {
            try {
                this.conn.getInputStream().close();
            } catch (IOException e2) {
                Log.e("MicroMsg.AppBrandDownloadWorker", e2.getMessage());
            }
            try {
                this.conn.disconnect();
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e3, "abortTask Exception", new Object[0]);
            }
        }
        if (!Util.isNullOrNil(this.njq)) {
            CronetLogic.cancelCronetTask(this.njq);
        }
        AppMethodBeat.o(144468);
    }

    static String ez(String str, String str2) {
        AppMethodBeat.i(144469);
        MimeTypeUtil.ContentType obtain = MimeTypeUtil.ContentType.obtain(str);
        if (obtain == null) {
            String mimeTypeByFilePath = MimeTypeUtil.getMimeTypeByFilePath(str2);
            AppMethodBeat.o(144469);
            return mimeTypeByFilePath;
        } else if (obtain.mimeType.contains("application/octet-stream")) {
            String mimeTypeByFilePath2 = MimeTypeUtil.getMimeTypeByFilePath(str2);
            if (Util.isNullOrNil(mimeTypeByFilePath2)) {
                String str3 = obtain.mimeType;
                AppMethodBeat.o(144469);
                return str3;
            }
            AppMethodBeat.o(144469);
            return mimeTypeByFilePath2;
        } else {
            String str4 = obtain.mimeType;
            AppMethodBeat.o(144469);
            return str4;
        }
    }

    private static void yE(int i2) {
        AppMethodBeat.i(144470);
        int i3 = 28;
        if (i2 >= 100 && i2 < 200) {
            i3 = 20;
        } else if (200 == i2) {
            i3 = 21;
        } else if (i2 > 200 && i2 < 300) {
            i3 = 22;
        } else if (302 == i2) {
            i3 = 23;
        } else if (i2 >= 300 && i2 < 400) {
            i3 = 24;
        } else if (404 == i2) {
            i3 = 25;
        } else if (i2 >= 400 && i2 < 500) {
            i3 = 26;
        } else if (i2 >= 500) {
            i3 = 27;
        }
        ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(437, (long) i3, 1, false);
        Log.i("MicroMsg.AppBrandDownloadWorker", "reportStatusCode:%d, key:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(144470);
    }

    private static void I(long j2, long j3) {
        AppMethodBeat.i(144471);
        if (j2 <= 0 || j3 <= 0) {
            Log.i("MicroMsg.AppBrandDownloadWorker", "reportSpeed len:%d, time:%d return", Long.valueOf(j2), Long.valueOf(j3));
            AppMethodBeat.o(144471);
            return;
        }
        int i2 = 34;
        double d2 = (((double) j2) / ((double) j3)) * 0.9765625d;
        if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
            i2 = 30;
        } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
            i2 = 31;
        } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
            i2 = 32;
        } else if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            i2 = 33;
        }
        ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(437, (long) i2, (long) d2, false);
        Log.i("MicroMsg.AppBrandDownloadWorker", "reportSpeed len:%d, time:%d, speed:%f, key:%d", Long.valueOf(j2), Long.valueOf(j3), Double.valueOf(d2), Integer.valueOf(i2));
        AppMethodBeat.o(144471);
    }

    private String bjl() {
        return this.jEY;
    }

    private String bFb() {
        return this.nix;
    }

    public final int bPz() {
        AppMethodBeat.i(144472);
        int currentTimeMillis = (int) (System.currentTimeMillis() - this.startTime);
        AppMethodBeat.o(144472);
        return currentTimeMillis;
    }
}
