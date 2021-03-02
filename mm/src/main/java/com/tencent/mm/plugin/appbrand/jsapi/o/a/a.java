package com.tencent.mm.plugin.appbrand.jsapi.o.a;

import com.google.android.gms.common.Scopes;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.n;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.jsapi.base.h;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.am;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.plugin.appbrand.s.c;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.o;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class a implements h {
    private b.AbstractC0793b mgA;
    protected boolean mgB = false;
    com.tencent.mm.plugin.appbrand.jsapi.base.a mgb;
    private final AtomicBoolean mgl = new AtomicBoolean(false);

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.o.a.a$a  reason: collision with other inner class name */
    public static class C0691a extends bc {
        public static final int CTRL_INDEX = 271;
        public static final String NAME = "onDownloadTaskStateChange";
    }

    public a(b.AbstractC0793b bVar, com.tencent.mm.plugin.appbrand.jsapi.base.a aVar) {
        AppMethodBeat.i(207094);
        this.mgA = bVar;
        this.mgb = aVar;
        AppMethodBeat.o(207094);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final String bjl() {
        AppMethodBeat.i(179507);
        StringBuilder sb = new StringBuilder();
        c.bPx();
        String sb2 = sb.append(c.bPw()).toString();
        AppMethodBeat.o(179507);
        return sb2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final String auJ() {
        return "downloadTaskId";
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final void a(final f fVar, JSONObject jSONObject, final String str) {
        AppMethodBeat.i(179508);
        Log.d("MicroMsg.BaseCreateDownloadTask", "JsApiCreateDownloadTask");
        if (!this.mgl.getAndSet(true)) {
            if (this.mgA != null) {
                b.AbstractC0793b bVar = this.mgA;
                fVar.getAppId();
                this.mgB = bVar.btA();
            }
            if (this.mgB) {
                com.tencent.mm.plugin.appbrand.s.a aVar = (com.tencent.mm.plugin.appbrand.s.a) fVar.av(com.tencent.mm.plugin.appbrand.s.a.class);
                if (aVar == null) {
                    Log.e("MicroMsg.BaseCreateDownloadTask", "setupRequestMode config not found, setUserCertVerify false appId(%s)", fVar.getAppId());
                    CronetLogic.setUserCertVerify(false);
                } else {
                    Log.i("MicroMsg.BaseCreateDownloadTask", "setupRequestMode(%b),appId(%s)", Boolean.valueOf(aVar.nhO), fVar.getAppId());
                    CronetLogic.setUserCertVerify(aVar.nhO);
                }
            }
        }
        fVar.getAppId();
        final String optString = jSONObject.optString("filePath");
        AnonymousClass1 r7 = new b.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.o.a.a.AnonymousClass1 */
            private JSONObject mgC;

            @Override // com.tencent.mm.plugin.appbrand.s.b.a
            public final void a(int i2, String str, String str2, int i3, long j2, Map map) {
                T t;
                AppMethodBeat.i(179502);
                Log.i("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode errMsg = %d, mimeType = %s, filePath = %s, statusCode = %d, dataLength = %d", Integer.valueOf(i2), str, str2, Integer.valueOf(i3), Long.valueOf(j2));
                if (!Util.isNullOrNil(optString)) {
                    String a2 = am.a(fVar, new o(str2), optString, (i<String>) null);
                    if (b.FAILED != i2 && "ok".equals(a2)) {
                        Log.i("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode filePath %s", optString);
                        HashMap hashMap = new HashMap();
                        hashMap.put("downloadTaskId", str);
                        hashMap.put("filePath", optString);
                        hashMap.put("dataLength", Long.valueOf(j2));
                        hashMap.put("statusCode", Integer.valueOf(i3));
                        hashMap.put("state", "success");
                        if (this.mgC != null) {
                            hashMap.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, this.mgC);
                        }
                        if (map != null && map.size() > 0) {
                            hashMap.put(Scopes.PROFILE, map);
                        }
                        new C0691a().h(fVar).Zh(new JSONObject(hashMap).toString()).a(a.this.mgb.Zz(str));
                        a.this.mgb.remove(str);
                        AppMethodBeat.o(179502);
                    } else if (a.i(fVar, str)) {
                        AppMethodBeat.o(179502);
                    } else {
                        a.this.b(fVar, str, a2);
                        AppMethodBeat.o(179502);
                    }
                } else {
                    f fVar = fVar;
                    String extByMimeType = MimeTypeUtil.getExtByMimeType(str);
                    if (Util.isNullOrNil(extByMimeType) && "audio/mp4".equals(str)) {
                        extByMimeType = "mp4";
                    }
                    i<String> iVar = new i<>();
                    if (fVar.getFileSystem().a(new o(str2), extByMimeType, true, iVar) != m.OK) {
                        t = null;
                    } else {
                        t = iVar.value;
                    }
                    if (i2 != b.FAILED && t != null) {
                        Log.i("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode localId %s", t);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("downloadTaskId", str);
                        hashMap2.put("tempFilePath", t);
                        hashMap2.put("dataLength", Long.valueOf(j2));
                        hashMap2.put("statusCode", Integer.valueOf(i3));
                        hashMap2.put("state", "success");
                        if (this.mgC != null) {
                            hashMap2.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, this.mgC);
                        }
                        if (map != null && map.size() > 0) {
                            hashMap2.put(Scopes.PROFILE, map);
                        }
                        new C0691a().h(fVar).Zh(new JSONObject(hashMap2).toString()).a(a.this.mgb.Zz(str));
                        a.this.mgb.remove(str);
                        AppMethodBeat.o(179502);
                    } else if (a.i(fVar, str)) {
                        AppMethodBeat.o(179502);
                    } else {
                        a.this.b(fVar, str, "download fail");
                        AppMethodBeat.o(179502);
                    }
                }
            }

            @Override // com.tencent.mm.plugin.appbrand.s.b.a
            public final void h(int i2, long j2, long j3) {
                AppMethodBeat.i(179503);
                HashMap hashMap = new HashMap();
                hashMap.put("downloadTaskId", str);
                hashMap.put("state", "progressUpdate");
                hashMap.put("progress", Integer.valueOf(i2));
                hashMap.put("totalBytesWritten", Long.valueOf(j2));
                hashMap.put("totalBytesExpectedToWrite", Long.valueOf(j3));
                new C0691a().h(fVar).Zh(new JSONObject(hashMap).toString()).a(a.this.mgb.Zz(str));
                AppMethodBeat.o(179503);
            }

            @Override // com.tencent.mm.plugin.appbrand.s.b.a
            public final void ah(int i2, String str) {
                AppMethodBeat.i(207093);
                Log.i("MicroMsg.BaseCreateDownloadTask", "onDownloadError  downloadTaskId = %s, errMsg = %d, error = %s", str, Integer.valueOf(i2), str);
                if (a.i(fVar, str)) {
                    AppMethodBeat.o(207093);
                    return;
                }
                a.this.b(fVar, str, str);
                AppMethodBeat.o(207093);
            }

            @Override // com.tencent.mm.plugin.appbrand.s.b.a
            public final void J(JSONObject jSONObject) {
                AppMethodBeat.i(179505);
                if (jSONObject == null) {
                    AppMethodBeat.o(179505);
                } else if (!jSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__")) {
                    this.mgC = jSONObject;
                    HashMap hashMap = new HashMap();
                    hashMap.put("downloadTaskId", str);
                    hashMap.put("state", "headersReceived");
                    hashMap.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, this.mgC);
                    new C0691a().h(fVar).Zh(new JSONObject(hashMap).toString()).a(a.this.mgb.Zz(str));
                    AppMethodBeat.o(179505);
                } else if (!((com.tencent.mm.plugin.appbrand.s.a) fVar.av(com.tencent.mm.plugin.appbrand.s.a.class)).cyp) {
                    AppMethodBeat.o(179505);
                } else {
                    jSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
                    n nVar = new n();
                    nVar.dCn.dCo = "download";
                    nVar.dCn.dCq = jSONObject;
                    nVar.dCn.dCp = str;
                    EventCenter.instance.publish(nVar);
                    AppMethodBeat.o(179505);
                }
            }
        };
        com.tencent.mm.plugin.appbrand.s.a aVar2 = (com.tencent.mm.plugin.appbrand.s.a) fVar.av(com.tencent.mm.plugin.appbrand.s.a.class);
        Map<String, String> a2 = j.a(jSONObject, aVar2);
        String optString2 = jSONObject.optString("url");
        if (Util.isNullOrNil(optString2)) {
            Log.i("MicroMsg.BaseCreateDownloadTask", "url is null");
            b(fVar, str, "url is null or nil");
            AppMethodBeat.o(179508);
            return;
        }
        boolean z = jSONObject.optBoolean("__skipDomainCheck__") ? false : aVar2.nhD;
        if (!z || j.c(aVar2.cyW, optString2)) {
            if (aVar2.cyM <= 0) {
                Log.i("MicroMsg.BaseCreateDownloadTask", "maxDownloadConcurrent <= 0 ");
            }
            int i2 = 60000;
            int optInt = jSONObject.optInt("timeout", 0);
            if (optInt <= 0) {
                optInt = j.a(aVar2, 3);
            }
            if (optInt > 0) {
                i2 = optInt;
            }
            Log.i("MicroMsg.BaseCreateDownloadTask", "lm:configTimeout: %d,timeout: %d", Integer.valueOf(optInt), Integer.valueOf(i2));
            a(fVar, aVar2, z, jSONObject, i2, a2, r7, str);
            AppMethodBeat.o(179508);
            return;
        }
        Log.i("MicroMsg.BaseCreateDownloadTask", "not in domain url %s", optString2);
        b(fVar, str, "url not in domain list");
        AppMethodBeat.o(179508);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00c4, code lost:
        r6 = r22.optString("filePath");
        r9 = r22.optBoolean("enableHttp2", false);
        r10 = r22.optBoolean("enableQuic", false);
        r11 = r22.optBoolean("enableCache", false);
        r12 = r22.optBoolean("enableProfile", true);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandNetworkDownload", "download taskId %s,useHttp2 %b, useQuic %b, useMemoryCache %b, useProfile %b", r26, java.lang.Boolean.valueOf(r9), java.lang.Boolean.valueOf(r10), java.lang.Boolean.valueOf(r11), java.lang.Boolean.valueOf(r12));
        r2 = new com.tencent.mm.plugin.appbrand.s.a.b(r15.lqg, r4, r15.nhQ + com.tencent.mm.sdk.platformtools.MD5Util.getMD5String(r4) + "temp" + java.lang.System.currentTimeMillis(), r6, r15.mGo, r15.mgB, r9, r10, r11, r12, new com.tencent.mm.plugin.appbrand.s.b.AnonymousClass1(r26, r25));
        r2.njn = r24;
        r2.timeout = r23;
        r2.isRunning = true;
        r2.nis = r14;
        r2.njo = r0;
        r2.nhR = r15.nhR;
        r2.jEY = r26;
        r2.nix = "createDownloadTask";
        r3 = r15.nhU;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0179, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r15.nhU.add(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x017f, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0180, code lost:
        r5 = r15.nhT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0182, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0189, code lost:
        if (r15.nhT.containsKey(r4) != false) goto L_0x01d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x018b, code lost:
        r3 = new java.util.concurrent.ConcurrentLinkedQueue<>();
        r15.nhT.put(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0195, code lost:
        r3.offer(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0198, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x019f, code lost:
        if (r15.nhT.get(r4) == null) goto L_0x01e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x01ae, code lost:
        if (r15.nhT.get(r4).size() <= 1) goto L_0x01e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x01b0, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandNetworkDownload", "hy: more than one same url in the queue, just add and wait");
        com.tencent.matrix.trace.core.AppMethodBeat.o(179509);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x01ca, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01cc, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(179509);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01d2, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01d3, code lost:
        r3 = r15.nhT.get(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01dc, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01de, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(179509);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01e4, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01e5, code lost:
        r15.acR(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.tencent.mm.plugin.appbrand.jsapi.f r19, com.tencent.mm.plugin.appbrand.s.a r20, boolean r21, org.json.JSONObject r22, int r23, java.util.Map<java.lang.String, java.lang.String> r24, com.tencent.mm.plugin.appbrand.s.b.a r25, java.lang.String r26) {
        /*
        // Method dump skipped, instructions count: 499
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.o.a.a.a(com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.s.a, boolean, org.json.JSONObject, int, java.util.Map, com.tencent.mm.plugin.appbrand.s.b$a, java.lang.String):void");
    }

    public final void b(f fVar, String str, String str2) {
        AppMethodBeat.i(179510);
        Log.w("MicroMsg.BaseCreateDownloadTask", "sendFailMsg, downloadTaskId = %s, errMsg = %s", str, str2);
        HashMap hashMap = new HashMap();
        hashMap.put("downloadTaskId", str);
        hashMap.put("state", "fail");
        hashMap.put("errMsg", str2);
        new C0691a().h(fVar).Zh(new JSONObject(hashMap).toString()).a(this.mgb.Zz(str));
        this.mgb.remove(str);
        AppMethodBeat.o(179510);
    }

    static /* synthetic */ boolean i(f fVar, String str) {
        AppMethodBeat.i(179511);
        b acV = c.bPx().acV(fVar.getAppId());
        if (acV == null || !acV.acT(str)) {
            AppMethodBeat.o(179511);
            return false;
        }
        Log.i("MicroMsg.BaseCreateDownloadTask", "download abort %s", str);
        AppMethodBeat.o(179511);
        return true;
    }
}
