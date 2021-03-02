package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.media.music.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tav.core.AssetExtension;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiOperateBackgroundAudio<CONTEXT extends f> extends d<CONTEXT> {
    public static final int CTRL_INDEX = 161;
    public static final String NAME = "operateBackgroundAudio";
    protected JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask lEa;

    public static final class c extends bc {
        private static final int CTRL_INDEX = 162;
        private static final String NAME = "onBackgroundAudioStateChange";
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(CONTEXT context, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(145741);
        if (jSONObject == null) {
            context.i(i2, h("fail:data is null", null));
            Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio data is null");
            AppMethodBeat.o(145741);
            return;
        }
        String appId = context.getAppId();
        Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio appId:%s", appId);
        if (this.lEa == null) {
            this.lEa = a(this, context, i2);
        }
        this.lEa.lqe = i2;
        this.lEa.appId = appId;
        l(context);
        OperateBackgroundAudioTask operateBackgroundAudioTask = new OperateBackgroundAudioTask(this, context, i2);
        operateBackgroundAudioTask.lqe = i2;
        operateBackgroundAudioTask.appId = appId;
        operateBackgroundAudioTask.lEd = jSONObject.toString();
        AppBrandMainProcessService.a(operateBackgroundAudioTask);
        AppMethodBeat.o(145741);
    }

    /* access modifiers changed from: protected */
    public JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask a(d dVar, CONTEXT context, int i2) {
        AppMethodBeat.i(145742);
        JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask setBackgroundAudioListenerTask = new JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask(this, context, i2);
        AppMethodBeat.o(145742);
        return setBackgroundAudioListenerTask;
    }

    /* access modifiers changed from: protected */
    public void l(CONTEXT context) {
    }

    public static final class b extends bc {
        private static final int CTRL_INDEX = 162;
        private static final String NAME = "onBackgroundAudioPrev";
        private static final b lEc = new b();

        static {
            AppMethodBeat.i(145733);
            AppMethodBeat.o(145733);
        }

        static synchronized void m(f fVar) {
            synchronized (b.class) {
                AppMethodBeat.i(145732);
                Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", NAME);
                lEc.h(fVar).bEo();
                AppMethodBeat.o(145732);
            }
        }
    }

    public static final class a extends bc {
        private static final int CTRL_INDEX = 162;
        private static final String NAME = "onBackgroundAudioNext";
        private static final a lEb = new a();

        static {
            AppMethodBeat.i(145731);
            AppMethodBeat.o(145731);
        }

        static synchronized void m(f fVar) {
            synchronized (a.class) {
                AppMethodBeat.i(145730);
                Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", NAME);
                lEb.h(fVar).bEo();
                AppMethodBeat.o(145730);
            }
        }
    }

    protected static class OperateBackgroundAudioTask extends MainProcessTask {
        public static final Parcelable.Creator<OperateBackgroundAudioTask> CREATOR = new Parcelable.Creator<OperateBackgroundAudioTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio.OperateBackgroundAudioTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ OperateBackgroundAudioTask[] newArray(int i2) {
                return new OperateBackgroundAudioTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ OperateBackgroundAudioTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(145734);
                OperateBackgroundAudioTask operateBackgroundAudioTask = new OperateBackgroundAudioTask(parcel);
                AppMethodBeat.o(145734);
                return operateBackgroundAudioTask;
            }
        };
        public String appId;
        public boolean error = false;
        public String jFn = "";
        private p lAw;
        public f lAx;
        public String lEd;
        public int lqe;

        public OperateBackgroundAudioTask(d dVar, f fVar, int i2) {
            this.lAw = dVar;
            this.lAx = fVar;
            this.lqe = i2;
        }

        public OperateBackgroundAudioTask(Parcel parcel) {
            AppMethodBeat.i(145735);
            f(parcel);
            AppMethodBeat.o(145735);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(145736);
            Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "runInMainProcess");
            String str = a.C0751a.ndb.ncY;
            if (Util.isNullOrNil(str) || str.equals(this.appId)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.lEd);
                    String optString = jSONObject.optString("operationType");
                    double optDouble = jSONObject.optDouble("currentTime", -1.0d);
                    if (TextUtils.isEmpty(optString)) {
                        Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is null");
                        this.error = true;
                        this.jFn = "operationType is null";
                        bDU();
                        AppMethodBeat.o(145736);
                        return;
                    }
                    Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType;%s, currentTime:%f", optString, Double.valueOf(optDouble));
                    this.error = false;
                    if (optString.equalsIgnoreCase(AssetExtension.SCENE_PLAY)) {
                        com.tencent.mm.ay.f fVar = a.C0751a.ndb.nda;
                        if (fVar == null) {
                            fVar = com.tencent.mm.ay.a.bef();
                        }
                        if (fVar != null) {
                            a.C0751a.ndb.ncZ = fVar.jeV;
                        }
                        if (com.tencent.mm.ay.b.beh()) {
                            Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "play music ok");
                        } else if (com.tencent.mm.ay.a.bec()) {
                            this.error = true;
                            this.jFn = "music is playing, don't play again";
                        } else if (fVar == null || !this.appId.equals(fVar.jfi)) {
                            this.error = true;
                            this.jFn = "play music fail";
                        } else {
                            Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "startPlayMusic play music ok, appId is same!");
                            com.tencent.mm.ay.a.c(fVar);
                        }
                    } else if (optString.equalsIgnoreCase("pause")) {
                        if (com.tencent.mm.ay.b.bei()) {
                            Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "pause music ok");
                        } else {
                            this.error = true;
                            this.jFn = "pause music fail";
                        }
                    } else if (optString.equalsIgnoreCase("seek")) {
                        if (optDouble < 0.0d) {
                            Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "currentTime is invalid!");
                            this.error = true;
                            this.jFn = "currentTime is invalid";
                        } else if (com.tencent.mm.ay.a.tG((int) (1000.0d * optDouble))) {
                            Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "seek music ok");
                        } else {
                            this.error = true;
                            this.jFn = "seek music fail";
                        }
                    } else if (!optString.equalsIgnoreCase("stop")) {
                        Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is invalid");
                        this.error = true;
                        this.jFn = "operationType is invalid";
                    } else if (com.tencent.mm.ay.b.bej()) {
                        Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "stop music ok");
                    } else {
                        this.error = true;
                        this.jFn = "stop music fail";
                    }
                    if (this.error) {
                        Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", this.jFn);
                    }
                    bDU();
                    AppMethodBeat.o(145736);
                } catch (JSONException e2) {
                    Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "new json exists exception, data is invalid, jsonStr:%s", this.lEd);
                    this.error = true;
                    this.jFn = "parser data fail, data is invalid";
                    Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "exception:%s" + e2.getMessage());
                    bDU();
                    AppMethodBeat.o(145736);
                }
            } else {
                Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "appid not match cannot operate, preAppId:%s, appId:%s", str, this.appId);
                this.error = true;
                this.jFn = "appid not match cannot operate";
                bDU();
                AppMethodBeat.o(145736);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(145737);
            if (this.lAx == null) {
                Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "service is null, don't callback");
                AppMethodBeat.o(145737);
            } else if (!this.error) {
                Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio ok");
                this.lAx.i(this.lqe, this.lAw.h("ok", null));
                AppMethodBeat.o(145737);
            } else {
                Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio fail:%s", this.jFn);
                this.lAx.i(this.lqe, this.lAw.h("fail:" + this.jFn, null));
                AppMethodBeat.o(145737);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(145738);
            this.appId = parcel.readString();
            this.lEd = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.error = z;
            this.jFn = parcel.readString();
            AppMethodBeat.o(145738);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(145739);
            parcel.writeString(this.appId);
            parcel.writeString(this.lEd);
            parcel.writeInt(this.error ? 1 : 0);
            parcel.writeString(this.jFn);
            AppMethodBeat.o(145739);
        }

        static {
            AppMethodBeat.i(145740);
            AppMethodBeat.o(145740);
        }
    }
}
