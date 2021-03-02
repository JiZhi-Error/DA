package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONObject;

public final class JsApiPausePlayVoice extends d<s> {
    public static final int CTRL_INDEX = 34;
    public static final String NAME = "pauseVoice";
    private PausePlayVoice lEG;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45949);
        this.lEG = new PausePlayVoice((byte) 0);
        AppBrandMainProcessService.a(this.lEG);
        JsApiStartPlayVoice.lEP = null;
        sVar.i(i2, h("ok", null));
        AppMethodBeat.o(45949);
    }

    static class PausePlayVoice extends MainProcessTask {
        public static final Parcelable.Creator<PausePlayVoice> CREATOR = new Parcelable.Creator<PausePlayVoice>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiPausePlayVoice.PausePlayVoice.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ PausePlayVoice[] newArray(int i2) {
                return new PausePlayVoice[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PausePlayVoice createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45946);
                PausePlayVoice pausePlayVoice = new PausePlayVoice((byte) 0);
                pausePlayVoice.f(parcel);
                AppMethodBeat.o(45946);
                return pausePlayVoice;
            }
        };

        private PausePlayVoice() {
        }

        /* synthetic */ PausePlayVoice(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(45947);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiPausePlayVoice.PausePlayVoice.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(45945);
                    b bVar = b.INSTANCE;
                    b.pause();
                    AppMethodBeat.o(45945);
                }
            });
            AppMethodBeat.o(45947);
        }

        static {
            AppMethodBeat.i(45948);
            AppMethodBeat.o(45948);
        }
    }
}
