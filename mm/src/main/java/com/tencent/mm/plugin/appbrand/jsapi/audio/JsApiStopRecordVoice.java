package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.media.record.a;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiStopRecordVoice extends d<s> {
    public static final int CTRL_INDEX = 32;
    public static final String NAME = "stopRecord";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46004);
        s sVar2 = sVar;
        o(sVar2);
        sVar2.i(i2, h("ok", null));
        AppMethodBeat.o(46004);
    }

    /* access modifiers changed from: package-private */
    public static class StopRecordVoice extends MainProcessTask {
        public static final Parcelable.Creator<StopRecordVoice> CREATOR = new Parcelable.Creator<StopRecordVoice>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice.StopRecordVoice.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ StopRecordVoice[] newArray(int i2) {
                return new StopRecordVoice[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ StopRecordVoice createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46000);
                StopRecordVoice stopRecordVoice = new StopRecordVoice((byte) 0);
                AppMethodBeat.o(46000);
                return stopRecordVoice;
            }
        };

        private StopRecordVoice() {
        }

        /* synthetic */ StopRecordVoice(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(46001);
            m.bZn().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice.StopRecordVoice.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(45999);
                    a.yv(1);
                    AppMethodBeat.o(45999);
                }
            });
            AppMethodBeat.o(46001);
        }

        static {
            AppMethodBeat.i(46002);
            AppMethodBeat.o(46002);
        }
    }

    static void o(s sVar) {
        AppMethodBeat.i(46003);
        if (Util.isNullOrNil(JsApiStartRecordVoice.lEU)) {
            AppMethodBeat.o(46003);
            return;
        }
        i.a aVar = p.Um(sVar.getAppId()).kCS;
        if (aVar != null) {
            aVar.dismiss();
        }
        AppBrandMainProcessService.a(new StopRecordVoice((byte) 0));
        JsApiStartRecordVoice.lEU = null;
        AppMethodBeat.o(46003);
    }
}
