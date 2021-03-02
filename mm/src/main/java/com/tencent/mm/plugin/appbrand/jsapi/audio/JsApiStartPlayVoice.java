package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.k;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiStartPlayVoice extends d<s> {
    public static final int CTRL_INDEX = 33;
    public static final String NAME = "playVoice";
    public static String lEP = null;
    private StartPlayVoice lEQ;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45972);
        s sVar2 = sVar;
        String nullAs = Util.nullAs(jSONObject.optString("filePath", null), jSONObject.optString(ch.COL_LOCALID));
        Log.i("MicroMsg.JsApiStartPlayVoice", "doPlayVoice, appId : %s, localId : %s", sVar2.getAppId(), nullAs);
        if (Util.isNullOrNil(nullAs)) {
            sVar2.i(i2, h("fail_missing arguments", null));
            AppMethodBeat.o(45972);
            return;
        }
        o VY = sVar2.getFileSystem().VY(nullAs);
        final ac currentPageView = sVar2.getCurrentPageView();
        if (VY == null || !VY.exists() || currentPageView == null) {
            sVar2.i(i2, h("fail", null));
            AppMethodBeat.o(45972);
            return;
        }
        ad.b G = ad.aVe().G("JsApi@" + currentPageView.hashCode(), true);
        i.b bVar = (i.b) G.get("onBackgroundListener", null);
        if (bVar == null) {
            bVar = new i.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
                public final void onBackground() {
                    AppMethodBeat.i(45958);
                    JsApiStopPlayVoice.bED();
                    currentPageView.b(this);
                    AppMethodBeat.o(45958);
                }
            };
            G.l("onBackgroundListener", bVar);
        }
        currentPageView.a(bVar);
        if (((i.c) G.get("onDestroyListener", null)) == null) {
            AnonymousClass2 r0 = new i.c() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.i.c
                public final void onDestroy() {
                    AppMethodBeat.i(45959);
                    JsApiStopPlayVoice.bED();
                    currentPageView.b(this);
                    ad.b JW = ad.aVe().JW("JsApi@" + currentPageView.hashCode());
                    if (JW != null) {
                        JW.recycle();
                    }
                    AppMethodBeat.o(45959);
                }
            };
            G.l("onDestroyListener", r0);
            currentPageView.a(r0);
        }
        if (this.lEQ == null) {
            this.lEQ = new StartPlayVoice(this, sVar2, i2);
        }
        if (lEP != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(ch.COL_LOCALID, this.lEQ.dJX);
            sVar2.i(this.lEQ.lqe, n("fail", hashMap));
            AppMethodBeat.o(45972);
            return;
        }
        this.lEQ.lAw = this;
        this.lEQ.kGT = sVar2;
        this.lEQ.lqe = i2;
        this.lEQ.dJX = nullAs;
        this.lEQ.filePath = aa.z(VY.her());
        AppBrandMainProcessService.a(this.lEQ);
        lEP = nullAs;
        AppMethodBeat.o(45972);
    }

    static class StartPlayVoice extends MainProcessTask {
        public static final Parcelable.Creator<StartPlayVoice> CREATOR = new Parcelable.Creator<StartPlayVoice>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice.StartPlayVoice.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ StartPlayVoice[] newArray(int i2) {
                return new StartPlayVoice[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ StartPlayVoice createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45963);
                StartPlayVoice startPlayVoice = new StartPlayVoice(parcel);
                AppMethodBeat.o(45963);
                return startPlayVoice;
            }
        };
        public String dJX;
        public boolean error = false;
        public String filePath;
        private s kGT;
        private p lAw;
        private int lqe;

        static /* synthetic */ boolean b(StartPlayVoice startPlayVoice) {
            AppMethodBeat.i(45969);
            boolean bDU = startPlayVoice.bDU();
            AppMethodBeat.o(45969);
            return bDU;
        }

        static /* synthetic */ boolean c(StartPlayVoice startPlayVoice) {
            AppMethodBeat.i(45970);
            boolean bDU = startPlayVoice.bDU();
            AppMethodBeat.o(45970);
            return bDU;
        }

        public StartPlayVoice(p pVar, s sVar, int i2) {
            this.lAw = pVar;
            this.kGT = sVar;
            this.lqe = i2;
        }

        public StartPlayVoice(Parcel parcel) {
            AppMethodBeat.i(45964);
            f(parcel);
            AppMethodBeat.o(45964);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(45965);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice.StartPlayVoice.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(45962);
                    b bVar = b.INSTANCE;
                    b.a(StartPlayVoice.this.filePath, new k.a() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice.StartPlayVoice.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.ak.k.a
                        public final void onCompletion() {
                            AppMethodBeat.i(45960);
                            StartPlayVoice.this.error = false;
                            StartPlayVoice.b(StartPlayVoice.this);
                            AppMethodBeat.o(45960);
                        }
                    }, new k.b() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice.StartPlayVoice.AnonymousClass1.AnonymousClass2 */

                        @Override // com.tencent.mm.ak.k.b
                        public final void onError() {
                            AppMethodBeat.i(45961);
                            StartPlayVoice.this.error = true;
                            StartPlayVoice.c(StartPlayVoice.this);
                            AppMethodBeat.o(45961);
                        }
                    });
                    AppMethodBeat.o(45962);
                }
            });
            AppMethodBeat.o(45965);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(45966);
            HashMap hashMap = new HashMap();
            hashMap.put(ch.COL_LOCALID, this.dJX);
            this.kGT.i(this.lqe, this.lAw.n(this.error ? "fail" : "ok", hashMap));
            JsApiStartPlayVoice.lEP = null;
            AppMethodBeat.o(45966);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(45967);
            this.dJX = parcel.readString();
            this.filePath = parcel.readString();
            this.error = parcel.readByte() != 0;
            AppMethodBeat.o(45967);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(45968);
            parcel.writeString(this.dJX);
            parcel.writeString(this.filePath);
            parcel.writeByte(this.error ? (byte) 1 : 0);
            AppMethodBeat.o(45968);
        }

        static {
            AppMethodBeat.i(45971);
            AppMethodBeat.o(45971);
        }
    }
}
