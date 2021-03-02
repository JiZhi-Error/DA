package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import android.support.v4.app.a;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pc;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener;
import com.tencent.mm.plugin.appbrand.media.record.c;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public final class k extends d<s> {
    public static final int CTRL_INDEX = 295;
    public static final String NAME = "operateRecorder";
    private static Vector<String> lDK = new Vector<>();
    private h.c cxI;
    private b lEt;
    private ac lEu;
    private i.a lEv;

    public static final class a extends com.tencent.mm.plugin.appbrand.jsapi.s {
        private static final int CTRL_INDEX = 296;
        private static final String NAME = "onRecorderStateChange";
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* bridge */ /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45942);
        a(sVar, jSONObject, i2);
        AppMethodBeat.o(45942);
    }

    static {
        AppMethodBeat.i(45944);
        AppMethodBeat.o(45944);
    }

    /* access modifiers changed from: package-private */
    public static class b extends a {
        public int action;
        public String appId;
        h.c cxI;
        private boolean dVg;
        private int duration = 0;
        public boolean error = false;
        private String filePath = "";
        private int fileSize = 0;
        private byte[] frameBuffer;
        public String jFn = "";
        public s kGT;
        public String lEA;
        private String lEB = "";
        private String lEC;
        private int lED;
        private final IListener<pc> lEE = new IListener<pc>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.audio.k.b.AnonymousClass1 */

            {
                AppMethodBeat.i(160597);
                this.__eventId = pc.class.getName().hashCode();
                AppMethodBeat.o(160597);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(pc pcVar) {
                int i2;
                AppMethodBeat.i(45935);
                pc pcVar2 = pcVar;
                Log.i("MicroMsg.Record.JsApiOperateRecorder", "mListener callback action : %d", Integer.valueOf(pcVar2.dVf.action));
                if (!b.this.appId.equalsIgnoreCase(pcVar2.dVf.appId)) {
                    Log.e("MicroMsg.Record.JsApiOperateRecorder", "appId is diff, don't send event");
                    AppMethodBeat.o(45935);
                    return false;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("state", pcVar2.dVf.state);
                b.this.state = pcVar2.dVf.state;
                if (pcVar2.dVf.action == 2) {
                    b.this.filePath = pcVar2.dVf.filePath;
                    b.this.duration = pcVar2.dVf.duration;
                    b.this.fileSize = pcVar2.dVf.fileSize;
                    c.acF(b.this.appId);
                }
                if (pcVar2.dVf.action == 4) {
                    hashMap.put("errCode", Integer.valueOf(pcVar2.dVf.errCode));
                    String str = "";
                    if (!TextUtils.isEmpty(pcVar2.dVf.errMsg)) {
                        str = pcVar2.dVf.errMsg;
                    }
                    hashMap.put("errMsg", str);
                }
                if (pcVar2.dVf.action == 5) {
                    if (pcVar2.dVf.frameBuffer == null || pcVar2.dVf.frameBuffer.length <= 819200) {
                        b.this.frameBuffer = pcVar2.dVf.frameBuffer;
                    } else {
                        b.a(b.this, pcVar2);
                    }
                    b bVar = b.this;
                    if (pcVar2.dVf.frameBuffer != null) {
                        i2 = pcVar2.dVf.frameBuffer.length;
                    } else {
                        i2 = 0;
                    }
                    bVar.lED = i2;
                    b.this.dVg = pcVar2.dVf.dVg;
                    Log.i("MicroMsg.Record.JsApiOperateRecorder", "frameBufferSize:%d", Integer.valueOf(b.this.lED));
                }
                b.this.lEk = new JSONObject(hashMap).toString();
                b.this.action = pcVar2.dVf.action;
                b.this.callback();
                AppMethodBeat.o(45935);
                return true;
            }
        };
        public String lEk;
        AudioRecordVoIPInterruptListener lEy;
        private k lEz;
        public int lqe;
        public String processName = "";
        private String state = "";

        public b(k kVar, s sVar, int i2) {
            AppMethodBeat.i(45936);
            this.lEz = kVar;
            this.kGT = sVar;
            this.lqe = i2;
            com.tencent.mm.plugin.appbrand.ac.i<String> iVar = new com.tencent.mm.plugin.appbrand.ac.i<>();
            if (sVar.getFileSystem().a(iVar) == m.OK) {
                this.lEC = aa.z(new o((String) iVar.value, "frameBuffer").her());
                AppMethodBeat.o(45936);
                return;
            }
            this.lEC = aa.z(new o(sVar.getContext().getCacheDir(), "frameBuffer_" + sVar.getAppId()).her());
            AppMethodBeat.o(45936);
        }

        /* JADX WARNING: Removed duplicated region for block: B:34:0x0176  */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x0279  */
        @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.d
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void YC() {
            /*
            // Method dump skipped, instructions count: 943
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.audio.k.b.YC():void");
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.a
        public final void callback() {
            AppMethodBeat.i(45938);
            super.callback();
            if (this.kGT == null) {
                Log.e("MicroMsg.Record.JsApiOperateRecorder", "service is null, don't callback");
                AppMethodBeat.o(45938);
            } else if (this.action != -1) {
                a aVar = new a();
                switch (this.action) {
                    case 0:
                    case 1:
                        k.a(this.lEz, true);
                        if (!k.lDK.contains(this.appId)) {
                            h.a(this.appId, this.cxI);
                            k.lDK.add(this.appId);
                            break;
                        }
                        break;
                    case 2:
                    case 3:
                    case 4:
                        k.a(this.lEz, false);
                        if (this.action == 2 || this.action == 4) {
                            h.b(this.appId, this.cxI);
                            k.lDK.remove(this.appId);
                            break;
                        }
                }
                if (this.action == 2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("state", this.state);
                    Log.i("MicroMsg.Record.JsApiOperateRecorder", "filePath:%s, encodeFormat:%s", this.filePath, this.lEB);
                    com.tencent.mm.plugin.appbrand.ac.i<String> iVar = new com.tencent.mm.plugin.appbrand.ac.i<>();
                    if (this.kGT.getFileSystem().a(new o(this.filePath), com.tencent.mm.plugin.appbrand.media.record.h.acG(this.lEB), true, iVar) == m.OK) {
                        hashMap.put("tempFilePath", iVar.value);
                    } else {
                        Log.e("MicroMsg.Record.JsApiOperateRecorder", "AppBrandLocalMediaObject obj is null");
                        hashMap.put("tempFilePath", "");
                    }
                    hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(this.duration));
                    hashMap.put("fileSize", Integer.valueOf(this.fileSize));
                    this.lEk = new JSONObject(hashMap).toString();
                }
                if (this.action == 5) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("state", this.state);
                    hashMap2.put("isLastFrame", Boolean.valueOf(this.dVg));
                    if (this.lED > 819200) {
                        bEC();
                    }
                    if (this.frameBuffer != null) {
                        hashMap2.put("frameBuffer", x.aP(this.frameBuffer));
                    } else {
                        Log.e("MicroMsg.Record.JsApiOperateRecorder", "framBuffer is null, error");
                    }
                    x.b a2 = x.a(this.kGT.getJsRuntime(), hashMap2, (x.a) this.kGT.av(x.a.class));
                    if (a2 == x.b.OK) {
                        this.lEk = new JSONObject(hashMap2).toString();
                    } else if (a2 == x.b.FAIL_SIZE_EXCEED_LIMIT) {
                        x.m(this.kGT, "onRecorderStateChange");
                        AppMethodBeat.o(45938);
                        return;
                    }
                }
                Log.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", Integer.valueOf(this.action), this.lEk);
                aVar.g(this.kGT).Zg(this.lEk).bEo();
                AppMethodBeat.o(45938);
            } else if (!this.error) {
                Log.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder ok");
                this.kGT.i(this.lqe, this.lEz.h("ok", null));
                AppMethodBeat.o(45938);
            } else {
                Log.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder fail:%s", this.jFn);
                this.kGT.i(this.lqe, this.lEz.h("fail:" + this.jFn, null));
                AppMethodBeat.o(45938);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:29:0x009f A[SYNTHETIC, Splitter:B:29:0x009f] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00a4  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00d7 A[SYNTHETIC, Splitter:B:42:0x00d7] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00dc  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x0104 A[SYNTHETIC, Splitter:B:54:0x0104] */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x0109  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void bEC() {
            /*
            // Method dump skipped, instructions count: 318
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.audio.k.b.bEC():void");
        }

        static /* synthetic */ void a(b bVar, pc pcVar) {
            AppMethodBeat.i(45940);
            long nanoTime = System.nanoTime();
            OutputStream outputStream = null;
            try {
                o oVar = new o(bVar.lEC);
                Log.d("MicroMsg.Record.JsApiOperateRecorder", "frameBufferPath:%s", bVar.lEC);
                if (!oVar.exists()) {
                    oVar.createNewFile();
                }
                OutputStream ap = com.tencent.mm.vfs.s.ap(oVar);
                ap.write(pcVar.dVf.frameBuffer);
                ap.close();
                if (ap != null) {
                    try {
                        ap.close();
                    } catch (IOException e2) {
                        Log.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e2, "", new Object[0]);
                    }
                }
            } catch (FileNotFoundException e3) {
                Log.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e3, "", new Object[0]);
                if (0 != 0) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                        Log.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e4, "", new Object[0]);
                    }
                }
            } catch (IOException e5) {
                Log.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e5, "", new Object[0]);
                if (0 != 0) {
                    try {
                        outputStream.close();
                    } catch (IOException e6) {
                        Log.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e6, "", new Object[0]);
                    }
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        outputStream.close();
                    } catch (IOException e7) {
                        Log.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e7, "", new Object[0]);
                    }
                }
                AppMethodBeat.o(45940);
                throw th;
            }
            Log.d("MicroMsg.Record.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
            AppMethodBeat.o(45940);
        }
    }

    public final void a(final s sVar, final JSONObject jSONObject, final int i2) {
        boolean a2;
        AppMethodBeat.i(45941);
        r.a(sVar.getAppId(), new a.AbstractC0015a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.audio.k.AnonymousClass3 */

            @Override // android.support.v4.app.a.AbstractC0015a
            public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                AppMethodBeat.i(45934);
                if (i2 != 116) {
                    AppMethodBeat.o(45934);
                } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    Log.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, SYS_PERM_DENIED");
                    sVar.i(i2, k.this.h("fail:system permission denied", null));
                    AppMethodBeat.o(45934);
                } else {
                    Log.i("MicroMsg.Record.JsApiOperateRecorder", "PERMISSION_GRANTED, do invoke again");
                    k.this.a(sVar, jSONObject, i2);
                    AppMethodBeat.o(45934);
                }
            }
        });
        Activity activity = sVar.getContext() instanceof Activity ? (Activity) sVar.getContext() : null;
        if (activity == null) {
            Log.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, pageContext is null");
            sVar.i(i2, h("fail", null));
            a2 = false;
        } else {
            a2 = com.tencent.mm.pluginsdk.permission.b.a(activity, "android.permission.RECORD_AUDIO", 116, "", "");
            if (a2) {
                r.aeq(sVar.getAppId());
            }
        }
        if (!a2) {
            Log.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, requestPermission fail");
            sVar.i(i2, h("fail:system permission denied", null));
            AppMethodBeat.o(45941);
            return;
        }
        w brh = sVar.getRuntime().brh();
        if (brh.getCurrentPage() == null || brh.getCurrentPage().getCurrentPageView() == null) {
            sVar.i(i2, h("fail", null));
            AppMethodBeat.o(45941);
            return;
        }
        this.lEu = brh.getCurrentPage().getCurrentPageView();
        if (jSONObject == null) {
            Log.e("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder, data is null");
            sVar.i(i2, h("fail:data is null", null));
            AppMethodBeat.o(45941);
            return;
        }
        final String appId = sVar.getAppId();
        Log.i("MicroMsg.Record.JsApiOperateRecorder", "operateRecorder appId:%s, data:%s", appId, jSONObject.toString());
        if (this.lEt == null) {
            this.lEt = new b(this, sVar, i2);
        }
        this.lEt.lqe = i2;
        this.lEt.appId = appId;
        this.lEt.lEA = jSONObject.toString();
        this.lEt.processName = MMApplicationContext.getProcessName();
        if (this.cxI == null) {
            this.cxI = new h.c() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.audio.k.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.h.c
                public final void a(h.d dVar) {
                    AppMethodBeat.i(45931);
                    Log.i("MicroMsg.Record.JsApiOperateRecorder", "onPause, appId:%s", appId);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("operationType", "pause");
                    } catch (JSONException e2) {
                        Log.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e2, "", new Object[0]);
                    }
                    if (k.this.lEt == null) {
                        k.this.lEt = new b(k.this, sVar, i2);
                    }
                    k.this.lEt.lEA = jSONObject.toString();
                    k.this.lEt.appId = appId;
                    k.this.lEt.action = -1;
                    k.this.lEt.bjm();
                    AppMethodBeat.o(45931);
                }

                @Override // com.tencent.mm.plugin.appbrand.h.c
                public final void onDestroy() {
                    AppMethodBeat.i(45932);
                    Log.i("MicroMsg.Record.JsApiOperateRecorder", "onDestroy, appId:%s", appId);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("operationType", "stop");
                    } catch (JSONException e2) {
                        Log.printErrStackTrace("MicroMsg.Record.JsApiOperateRecorder", e2, "", new Object[0]);
                    }
                    if (k.this.lEt == null) {
                        k.this.lEt = new b(k.this, sVar, i2);
                    }
                    k.this.lEt.lEA = jSONObject.toString();
                    k.this.lEt.appId = appId;
                    k.this.lEt.action = -1;
                    k.this.lEt.bEy();
                    h.b(appId, this);
                    k.lDK.remove(appId);
                    AppMethodBeat.o(45932);
                }
            };
        }
        this.lEt.cxI = this.cxI;
        this.lEt.bjm();
        AppMethodBeat.o(45941);
    }

    static /* synthetic */ void a(k kVar, final boolean z) {
        AppMethodBeat.i(45943);
        if (!MMHandlerThread.isMainThread()) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.audio.k.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(45933);
                    k.a(k.this, z);
                    AppMethodBeat.o(45933);
                }
            });
            AppMethodBeat.o(45943);
        } else if (kVar.lEu == null || kVar.lEu.getRuntime() == null) {
            AppMethodBeat.o(45943);
        } else if (z) {
            kVar.lEv = a.C0775a.ah(kVar.lEu.getRuntime()).a(a.b.VOICE);
            AppMethodBeat.o(45943);
        } else {
            if (kVar.lEv != null) {
                kVar.lEv.dismiss();
                kVar.lEv = null;
            }
            AppMethodBeat.o(45943);
        }
    }
}
