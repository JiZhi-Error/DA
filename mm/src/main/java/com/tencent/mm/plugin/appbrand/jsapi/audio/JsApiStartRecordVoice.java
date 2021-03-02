package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.media.record.a;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiStartRecordVoice extends d<s> {
    public static final int CTRL_INDEX = 31;
    public static final String NAME = "startRecord";
    static volatile String lEU = null;
    private StartRecordVoice lEV;
    private ac lEu;
    private i.a lEv;

    static /* synthetic */ void a(JsApiStartRecordVoice jsApiStartRecordVoice, boolean z) {
        AppMethodBeat.i(45992);
        jsApiStartRecordVoice.hl(z);
        AppMethodBeat.o(45992);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* bridge */ /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45991);
        a(sVar, jSONObject, i2);
        AppMethodBeat.o(45991);
    }

    private void hl(final boolean z) {
        AppMethodBeat.i(45990);
        if (this.lEu == null) {
            AppMethodBeat.o(45990);
        } else if (!MMHandlerThread.isMainThread()) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(45975);
                    JsApiStartRecordVoice.a(JsApiStartRecordVoice.this, z);
                    AppMethodBeat.o(45975);
                }
            });
            AppMethodBeat.o(45990);
        } else if (z) {
            this.lEv = a.C0775a.ah(this.lEu.getRuntime()).a(a.b.VOICE);
            p.Un(this.lEu.getAppId()).kCS = this.lEv;
            AppMethodBeat.o(45990);
        } else {
            if (this.lEv != null) {
                this.lEv.dismiss();
                this.lEv = null;
            }
            AppMethodBeat.o(45990);
        }
    }

    /* access modifiers changed from: package-private */
    public static class StartRecordVoice extends MainProcessTask {
        public static final Parcelable.Creator<StartRecordVoice> CREATOR = new Parcelable.Creator<StartRecordVoice>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice.StartRecordVoice.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ StartRecordVoice[] newArray(int i2) {
                return new StartRecordVoice[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ StartRecordVoice createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45979);
                StartRecordVoice startRecordVoice = new StartRecordVoice(parcel);
                AppMethodBeat.o(45979);
                return startRecordVoice;
            }
        };
        private String appId;
        private int duration;
        private String filePath;
        private s kGT;
        private JsApiStartRecordVoice lEX;
        private boolean lEY = false;
        private int lqe;
        private int result;

        static /* synthetic */ boolean b(StartRecordVoice startRecordVoice) {
            AppMethodBeat.i(45986);
            boolean bDU = startRecordVoice.bDU();
            AppMethodBeat.o(45986);
            return bDU;
        }

        static /* synthetic */ boolean e(StartRecordVoice startRecordVoice) {
            AppMethodBeat.i(45987);
            boolean bDU = startRecordVoice.bDU();
            AppMethodBeat.o(45987);
            return bDU;
        }

        StartRecordVoice(JsApiStartRecordVoice jsApiStartRecordVoice, s sVar, int i2, int i3) {
            AppMethodBeat.i(45980);
            this.lEX = jsApiStartRecordVoice;
            this.kGT = sVar;
            this.duration = i2;
            this.lqe = i3;
            this.appId = sVar.getAppId();
            String Rq = w.Rq(this.appId);
            com.tencent.mm.plugin.appbrand.ac.i<String> iVar = new com.tencent.mm.plugin.appbrand.ac.i<>();
            if (sVar.getFileSystem().a(iVar) == m.OK) {
                this.filePath = aa.z(new o((String) iVar.value, Rq).her());
                AppMethodBeat.o(45980);
                return;
            }
            this.filePath = aa.z(new o(sVar.getContext().getCacheDir(), Rq).her());
            AppMethodBeat.o(45980);
        }

        StartRecordVoice(Parcel parcel) {
            AppMethodBeat.i(45981);
            f(parcel);
            AppMethodBeat.o(45981);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(45982);
            f.bZn().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice.StartRecordVoice.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(45978);
                    StartRecordVoice.this.lEY = com.tencent.mm.plugin.appbrand.media.record.a.a(StartRecordVoice.this.filePath, new a.AbstractC0752a() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice.StartRecordVoice.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.appbrand.media.record.a.AbstractC0752a
                        public final void wM(int i2) {
                            AppMethodBeat.i(45977);
                            StartRecordVoice.this.result = i2;
                            StartRecordVoice.b(StartRecordVoice.this);
                            AppMethodBeat.o(45977);
                        }
                    }, StartRecordVoice.this.duration * 1000);
                    if (!StartRecordVoice.this.lEY) {
                        StartRecordVoice.e(StartRecordVoice.this);
                    }
                    AppMethodBeat.o(45978);
                }
            });
            AppMethodBeat.o(45982);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(45983);
            if (this.result == -1) {
                Log.e("MicroMsg.JsApiStartRecordVoice", "fail:record_error");
                this.kGT.i(this.lqe, this.lEX.h("fail:record_error", null));
                AppMethodBeat.o(45983);
                return;
            }
            if (this.lEY) {
                HashMap hashMap = new HashMap(1);
                com.tencent.mm.plugin.appbrand.ac.i<String> iVar = new com.tencent.mm.plugin.appbrand.ac.i<>();
                if (this.kGT.getFileSystem().a(new o(this.filePath), "silk", true, iVar) == m.OK) {
                    hashMap.put("tempFilePath", iVar.value);
                    this.kGT.i(this.lqe, this.lEX.n("ok", hashMap));
                    Log.i("MicroMsg.JsApiStartRecordVoice", "runInClientProcess, appId = %s, startRecordOk = %b", this.appId, Boolean.valueOf(this.lEY));
                    JsApiStartRecordVoice.a(this.lEX, false);
                    AppMethodBeat.o(45983);
                }
                Log.e("MicroMsg.JsApiStartRecordVoice", "AppBrandLocalMediaObject obj is null");
                hashMap.put("tempFilePath", "");
            }
            this.kGT.i(this.lqe, this.lEX.h("fail", null));
            Log.i("MicroMsg.JsApiStartRecordVoice", "runInClientProcess, appId = %s, startRecordOk = %b", this.appId, Boolean.valueOf(this.lEY));
            JsApiStartRecordVoice.a(this.lEX, false);
            AppMethodBeat.o(45983);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(45984);
            this.lqe = parcel.readInt();
            this.appId = parcel.readString();
            this.filePath = parcel.readString();
            this.lEY = parcel.readByte() != 0;
            this.duration = parcel.readInt();
            this.result = parcel.readInt();
            AppMethodBeat.o(45984);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public int describeContents() {
            return 0;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(45985);
            parcel.writeInt(this.lqe);
            parcel.writeString(this.appId);
            parcel.writeString(this.filePath);
            parcel.writeByte(this.lEY ? (byte) 1 : 0);
            parcel.writeInt(this.duration);
            parcel.writeInt(this.result);
            AppMethodBeat.o(45985);
        }

        static {
            AppMethodBeat.i(45988);
            AppMethodBeat.o(45988);
        }
    }

    public final void a(final s sVar, final JSONObject jSONObject, final int i2) {
        boolean a2;
        AppMethodBeat.i(45989);
        r.a(sVar.getAppId(), new a.AbstractC0015a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice.AnonymousClass4 */

            @Override // android.support.v4.app.a.AbstractC0015a
            public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                AppMethodBeat.i(45976);
                if (i2 != 116) {
                    AppMethodBeat.o(45976);
                } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    sVar.i(i2, JsApiStartRecordVoice.this.h("fail:system permission denied", null));
                    AppMethodBeat.o(45976);
                } else {
                    JsApiStartRecordVoice.this.a(sVar, jSONObject, i2);
                    AppMethodBeat.o(45976);
                }
            }
        });
        Activity activity = sVar.getContext() instanceof Activity ? (Activity) sVar.getContext() : null;
        if (activity == null) {
            sVar.i(i2, h("fail", null));
            a2 = false;
        } else {
            a2 = b.a(activity, "android.permission.RECORD_AUDIO", 116, "", "");
            if (a2) {
                r.aeq(sVar.getAppId());
            }
        }
        if (!a2) {
            sVar.i(i2, h("fail", null));
            AppMethodBeat.o(45989);
            return;
        }
        com.tencent.mm.plugin.appbrand.page.w brh = sVar.getRuntime().brh();
        if (brh.getCurrentPage() == null || brh.getCurrentPage().getCurrentPageView() == null) {
            sVar.i(i2, h("fail", null));
            AppMethodBeat.o(45989);
        } else if (lEU != null) {
            sVar.i(i2, h("fail:audio is recording, don't start record again", null));
            AppMethodBeat.o(45989);
        } else {
            this.lEu = brh.getCurrentPage().getCurrentPageView();
            int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 60);
            if (optInt <= 0) {
                Log.e("MicroMsg.JsApiStartRecordVoice", "duration is invalid, less than 0");
                optInt = 60;
            }
            if (optInt > 600) {
                Log.e("MicroMsg.JsApiStartRecordVoice", "duration is invalid, more than %d", 600);
                optInt = 600;
            }
            this.lEu.a(new i.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
                public final void onBackground() {
                    AppMethodBeat.i(45973);
                    JsApiStopRecordVoice.o(sVar);
                    JsApiStartRecordVoice.this.lEu.b(this);
                    AppMethodBeat.o(45973);
                }
            });
            this.lEu.a(new i.c() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.i.c
                public final void onDestroy() {
                    AppMethodBeat.i(45974);
                    JsApiStopRecordVoice.o(sVar);
                    JsApiStartRecordVoice.this.lEu.b(this);
                    AppMethodBeat.o(45974);
                }
            });
            this.lEV = new StartRecordVoice(this, sVar, optInt, i2);
            lEU = this.lEV.filePath;
            AppBrandMainProcessService.a(this.lEV);
            hl(true);
            AppMethodBeat.o(45989);
        }
    }
}
