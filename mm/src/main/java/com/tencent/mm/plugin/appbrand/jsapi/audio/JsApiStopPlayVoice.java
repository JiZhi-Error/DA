package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiStopPlayVoice extends d<s> {
    public static final int CTRL_INDEX = 35;
    public static final String NAME = "stopVoice";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45998);
        s sVar2 = sVar;
        Log.i("MicroMsg.JsApiStopPlayVoice", "doStopVoice, appId : %s, localId : %s", sVar2.getAppId(), jSONObject.optString(ch.COL_LOCALID));
        AppBrandMainProcessService.a(new StopPlayVoice((byte) 0));
        sVar2.i(i2, h("ok", null));
        JsApiStartPlayVoice.lEP = null;
        AppMethodBeat.o(45998);
    }

    /* access modifiers changed from: package-private */
    public static class StopPlayVoice extends MainProcessTask {
        public static final Parcelable.Creator<StopPlayVoice> CREATOR = new Parcelable.Creator<StopPlayVoice>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopPlayVoice.StopPlayVoice.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ StopPlayVoice[] newArray(int i2) {
                return new StopPlayVoice[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ StopPlayVoice createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45994);
                StopPlayVoice stopPlayVoice = new StopPlayVoice((byte) 0);
                AppMethodBeat.o(45994);
                return stopPlayVoice;
            }
        };

        private StopPlayVoice() {
        }

        /* synthetic */ StopPlayVoice(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(45995);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopPlayVoice.StopPlayVoice.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(45993);
                    b bVar = b.INSTANCE;
                    b.stop();
                    AppMethodBeat.o(45993);
                }
            });
            AppMethodBeat.o(45995);
        }

        static {
            AppMethodBeat.i(45996);
            AppMethodBeat.o(45996);
        }
    }

    public static void bED() {
        AppMethodBeat.i(45997);
        if (Util.isNullOrNil(JsApiStartPlayVoice.lEP)) {
            AppMethodBeat.o(45997);
            return;
        }
        AppBrandMainProcessService.a(new StopPlayVoice((byte) 0));
        JsApiStartPlayVoice.lEP = null;
        AppMethodBeat.o(45997);
    }
}
