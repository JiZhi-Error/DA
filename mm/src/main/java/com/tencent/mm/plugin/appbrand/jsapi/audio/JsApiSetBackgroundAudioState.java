package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.g;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.u.a;
import com.tencent.mm.plugin.appbrand.jsapi.u.c;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.music.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiSetBackgroundAudioState extends d {
    public static final int CTRL_INDEX = 160;
    public static final String NAME = "setBackgroundAudioState";
    protected SetBackgroundAudioListenerTask lEa;

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        String str;
        Pair pair;
        AppMethodBeat.i(145770);
        if (jSONObject == null) {
            fVar.i(i2, h("fail:data is null", null));
            Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState data is null");
            AppMethodBeat.o(145770);
            return;
        }
        String appId = fVar.getAppId();
        Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState appId:%s ,data:%s", appId, jSONObject.toString());
        if (this.lEa == null) {
            this.lEa = a(this, fVar, i2);
        }
        this.lEa.lqe = i2;
        this.lEa.appId = appId;
        this.lEa.lEM = true;
        String JX = ad.JX("AppBrandService#" + fVar.hashCode());
        a(JX, fVar);
        final ad.b G = ad.aVe().G(JX, true);
        synchronized (G) {
            try {
                if (((h.c) G.get("AppBrandLifeCycle.Listener", null)) == null) {
                    AnonymousClass1 r0 = new h.c() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.appbrand.h.c
                        public final void onDestroy() {
                            AppMethodBeat.i(145750);
                            String string = G.getString("appId", "");
                            Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onDestroy, appId:%s", string);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("operationType", "stop");
                            } catch (JSONException e2) {
                            }
                            SetBackgroundAudioStateTask setBackgroundAudioStateTask = new SetBackgroundAudioStateTask(JsApiSetBackgroundAudioState.this, fVar, i2);
                            setBackgroundAudioStateTask.lEd = jSONObject.toString();
                            setBackgroundAudioStateTask.appId = string;
                            AppBrandMainProcessService.b(setBackgroundAudioStateTask);
                            AppMethodBeat.o(145750);
                        }
                    };
                    G.l("AppBrandLifeCycle.Listener", r0);
                    G.l("appId", appId);
                    this.lEa.cxI = r0;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(145770);
                throw th;
            }
        }
        AppBrandMainProcessService.a(this.lEa);
        SetBackgroundAudioStateTask b2 = b(this, fVar, i2);
        b2.lqe = i2;
        b2.appId = appId;
        b2.lEd = jSONObject.toString();
        String optString = jSONObject.optString("src");
        if (optString == null || optString.length() <= 0) {
            optString = "";
        } else if (!optString.startsWith(HttpWrapperBase.PROTOCAL_HTTP) && !optString.startsWith(HttpWrapperBase.PROTOCAL_HTTPS)) {
            o VY = fVar.getFileSystem().VY(optString);
            if (VY == null || !VY.exists()) {
                optString = "";
            } else {
                optString = aa.z(VY.her());
                if (!optString.startsWith("file://")) {
                    optString = "file://".concat(String.valueOf(optString));
                }
            }
        }
        b2.dUs = optString;
        a aVar = (a) e.M(a.class);
        if (aVar == null) {
            Log.w("MicroMsg.Music.JsApiSetBackgroundAudioState", "getReferrers, referrerHelper is null");
            pair = new Pair(null, "invalidReferrer");
        } else {
            String af = aVar.af(jSONObject);
            if (af != null) {
                c aaF = aVar.aaF(af);
                if (aaF == null) {
                    aaF = aVar.x(fVar);
                }
                if (c.NO_REFERRER == aaF) {
                    str = null;
                } else if (c.ORIGIN == aaF) {
                    str = aVar.y(fVar);
                }
                Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "getReferrers, referrerPolicyStr: %s, referrer: %s", af, str);
                pair = new Pair(af, str);
            }
            str = "invalidReferrer";
            Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "getReferrers, referrerPolicyStr: %s, referrer: %s", af, str);
            pair = new Pair(af, str);
        }
        b2.iJP = (String) pair.first;
        b2.iJQ = (String) pair.second;
        AppBrandMainProcessService.a(b2);
        AppMethodBeat.o(145770);
    }

    /* access modifiers changed from: protected */
    public SetBackgroundAudioStateTask b(d dVar, f fVar, int i2) {
        AppMethodBeat.i(145772);
        SetBackgroundAudioStateTask setBackgroundAudioStateTask = new SetBackgroundAudioStateTask(this, fVar, i2);
        AppMethodBeat.o(145772);
        return setBackgroundAudioStateTask;
    }

    /* access modifiers changed from: protected */
    public SetBackgroundAudioListenerTask a(d dVar, f fVar, int i2) {
        AppMethodBeat.i(145773);
        SetBackgroundAudioListenerTask setBackgroundAudioListenerTask = new SetBackgroundAudioListenerTask(this, fVar, i2);
        AppMethodBeat.o(145773);
        return setBackgroundAudioListenerTask;
    }

    /* access modifiers changed from: protected */
    public void a(String str, f fVar) {
    }

    public static class SetBackgroundAudioStateTask extends MainProcessTask {
        public static final Parcelable.Creator<SetBackgroundAudioStateTask> CREATOR = new Parcelable.Creator<SetBackgroundAudioStateTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SetBackgroundAudioStateTask[] newArray(int i2) {
                return new SetBackgroundAudioStateTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SetBackgroundAudioStateTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(145762);
                SetBackgroundAudioStateTask setBackgroundAudioStateTask = new SetBackgroundAudioStateTask(parcel);
                AppMethodBeat.o(145762);
                return setBackgroundAudioStateTask;
            }
        };
        public String appId;
        public String dUs;
        public boolean error = false;
        public String iJP = null;
        public String iJQ = null;
        public String jFn = "";
        private p lAw;
        public f lAx;
        public String lEd;
        public int lqe;

        public SetBackgroundAudioStateTask(d dVar, f fVar, int i2) {
            this.lAw = dVar;
            this.lAx = fVar;
            this.lqe = i2;
        }

        public SetBackgroundAudioStateTask(Parcel parcel) {
            AppMethodBeat.i(145763);
            f(parcel);
            AppMethodBeat.o(145763);
        }

        public String Zn(String str) {
            AppMethodBeat.i(145764);
            String str2 = b.aKJ() + "/image/" + str.hashCode();
            AppMethodBeat.o(145764);
            return str2;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            double d2;
            AppMethodBeat.i(145765);
            Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess");
            try {
                JSONObject jSONObject = new JSONObject(this.lEd);
                String optString = jSONObject.optString("src");
                String optString2 = jSONObject.optString("title");
                String optString3 = jSONObject.optString("epname");
                String optString4 = jSONObject.optString("singer");
                String optString5 = jSONObject.optString("coverImgUrl");
                String optString6 = jSONObject.optString("webUrl");
                String optString7 = jSONObject.optString("protocol");
                double optDouble = jSONObject.optDouble("startTime", 0.0d);
                String optString8 = jSONObject.optString("songLyric");
                double optDouble2 = jSONObject.optDouble("playbackRate", 1.0d);
                double optDouble3 = jSONObject.optDouble("volume", 1.0d);
                String optString9 = jSONObject.optString("operationType");
                if (!TextUtils.isEmpty(optString9)) {
                    Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "come from onStickyBannerChanged pause or lifeCycleListener onDestroy");
                    String str = a.C0751a.ndb.ncY;
                    if (Util.isNullOrNil(str) || str.equals(this.appId)) {
                        this.error = false;
                        if (optString9.equalsIgnoreCase("pause")) {
                            if (com.tencent.mm.ay.b.bei()) {
                                Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pause music ok");
                                AppMethodBeat.o(145765);
                                return;
                            }
                            this.error = true;
                            this.jFn = "pause music fail";
                        } else if (optString9.equalsIgnoreCase("stop")) {
                            if (com.tencent.mm.ay.b.bej()) {
                                Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "stop music ok");
                                AppMethodBeat.o(145765);
                                return;
                            }
                            this.error = true;
                            this.jFn = "stop music fail";
                        }
                        bDU();
                        AppMethodBeat.o(145765);
                        return;
                    }
                    Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "appid not match cannot operate, preAppId:%s, appId:%s", str, this.appId);
                    AppMethodBeat.o(145765);
                } else if (TextUtils.isEmpty(optString)) {
                    Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "src is null");
                    this.error = true;
                    this.jFn = "src is null";
                    bDU();
                    AppMethodBeat.o(145765);
                } else if (optString8 == null || optString8.length() <= 32768) {
                    Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "src;%s, title:%s, epname:%s, singer:%s, coverImgUrl:%s, protocol:%s, webUrl:%s, startTime:%f, localPath:%s, playbackRate:%f", optString, optString2, optString3, optString4, optString5, optString7, optString6, Double.valueOf(optDouble), this.dUs, Double.valueOf(optDouble2));
                    if (optDouble2 < 0.5d || optDouble2 > 2.0d) {
                        d2 = 1.0d;
                    } else {
                        d2 = optDouble2;
                    }
                    if (optString5 == null) {
                        optString5 = "";
                    }
                    if (TextUtils.isEmpty(optString8)) {
                        Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric is empty");
                    } else {
                        Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric:%s", optString8);
                    }
                    com.tencent.mm.ay.f a2 = g.a(11, optString5, optString2, optString4, optString6, optString, optString, new StringBuilder().append((this.appId + optString + optString5).hashCode()).toString(), b.aKJ(), Zn(optString5), optString3, this.appId);
                    a2.dvv = (int) (1000.0d * optDouble);
                    a2.protocol = optString7;
                    a2.jfe = optString8;
                    a2.iJH = d2;
                    if (this.dUs.startsWith("file://")) {
                        a2.jfh = this.dUs;
                    }
                    a2.iJP = this.iJP;
                    a2.iJQ = this.iJQ;
                    a2.volume = (float) optDouble3;
                    a.C0751a.ndb.ncZ = a2.jeV;
                    a.C0751a.ndb.nda = a2;
                    if (!(a2.g(com.tencent.mm.ay.a.bef()) && com.tencent.mm.ay.a.bec())) {
                        Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "play the music");
                        com.tencent.mm.ay.a.c(a2);
                    } else {
                        Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "The same music is playing");
                        com.tencent.mm.ay.a.b(a2);
                    }
                    Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess startPlayMusic");
                    Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
                    this.error = false;
                    bDU();
                    AppMethodBeat.o(145765);
                } else {
                    Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric is large than 32KB");
                    this.error = true;
                    this.jFn = "songLyric is large than 32KB";
                    bDU();
                    AppMethodBeat.o(145765);
                }
            } catch (JSONException e2) {
                Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "new json exists exception, data is invalid");
                this.error = true;
                this.jFn = "parser data fail, data is invalid";
                Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "exception:%s" + e2.getMessage());
                bDU();
                AppMethodBeat.o(145765);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(145766);
            if (this.lAx == null) {
                Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "service is null, don't callback");
                AppMethodBeat.o(145766);
            } else if (!this.error) {
                Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
                this.lAx.i(this.lqe, this.lAw.h("ok", null));
                AppMethodBeat.o(145766);
            } else {
                Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState fail:%s", this.jFn);
                this.lAx.i(this.lqe, this.lAw.h("fail:" + this.jFn, null));
                AppMethodBeat.o(145766);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(145767);
            this.appId = parcel.readString();
            this.lEd = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.error = z;
            this.jFn = parcel.readString();
            this.dUs = parcel.readString();
            this.iJP = parcel.readString();
            this.iJQ = parcel.readString();
            AppMethodBeat.o(145767);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(145768);
            parcel.writeString(this.appId);
            parcel.writeString(this.lEd);
            parcel.writeInt(this.error ? 1 : 0);
            parcel.writeString(this.jFn);
            parcel.writeString(this.dUs);
            parcel.writeString(this.iJP);
            parcel.writeString(this.iJQ);
            AppMethodBeat.o(145768);
        }

        static {
            AppMethodBeat.i(145769);
            AppMethodBeat.o(145769);
        }
    }

    public static class SetBackgroundAudioListenerTask extends MainProcessTask {
        public static final Parcelable.Creator<SetBackgroundAudioListenerTask> CREATOR = new Parcelable.Creator<SetBackgroundAudioListenerTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SetBackgroundAudioListenerTask[] newArray(int i2) {
                return new SetBackgroundAudioListenerTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SetBackgroundAudioListenerTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(145751);
                SetBackgroundAudioListenerTask setBackgroundAudioListenerTask = new SetBackgroundAudioListenerTask(parcel);
                AppMethodBeat.o(145751);
                return setBackgroundAudioListenerTask;
            }
        };
        public int action;
        public String appId;
        public String appUserName;
        public String brandName;
        h.c cxI;
        public int dMe;
        private p lAw;
        public f lAx;
        private boolean lEM = false;
        public String lEk;
        private final IListener lEl = new IListener<mx>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask.AnonymousClass2 */

            {
                AppMethodBeat.i(161229);
                this.__eventId = mx.class.getName().hashCode();
                AppMethodBeat.o(161229);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(mx mxVar) {
                boolean z;
                AppMethodBeat.i(145752);
                mx mxVar2 = mxVar;
                Log.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "musicPlayerListener callback action : %d", Integer.valueOf(mxVar2.dSE.action));
                HashMap hashMap = new HashMap();
                String str = mxVar2.dSE.state;
                if (mxVar2.dSE.action == 10) {
                    String str2 = mxVar2.dSE.appId;
                    if (str2.equals(SetBackgroundAudioListenerTask.this.appId)) {
                        Log.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "appId is same, don't send ON_PREEMPTED event");
                        AppMethodBeat.o(145752);
                        return false;
                    }
                    Log.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "send ON_PREEMPTED event, sender appId:%s,  receive appId:%s", str2, SetBackgroundAudioListenerTask.this.appId);
                    hashMap.put("state", str);
                    SetBackgroundAudioListenerTask.this.lEk = new JSONObject(hashMap).toString();
                    SetBackgroundAudioListenerTask.this.action = mxVar2.dSE.action;
                    SetBackgroundAudioListenerTask.b(SetBackgroundAudioListenerTask.this);
                    AppMethodBeat.o(145752);
                    return true;
                }
                com.tencent.mm.ay.f fVar = mxVar2.dSE.dSy;
                if (fVar == null) {
                    Log.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "wrapper is null");
                    AppMethodBeat.o(145752);
                    return false;
                } else if (!mxVar2.dSE.dSG) {
                    Log.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "is not from QQMusicPlayer, don't callback!");
                    AppMethodBeat.o(145752);
                    return false;
                } else {
                    if (mxVar2.dSE.action != 2 || !mxVar2.dSE.dSH) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        Log.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "isSwitchMusicIng, don't callback!");
                        AppMethodBeat.o(145752);
                        return false;
                    }
                    String str3 = a.C0751a.ndb.ncY;
                    if (!SetBackgroundAudioListenerTask.this.appId.equals(str3)) {
                        Log.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "appId is not equals preAppId, don't send any event, appId:%s, preAppId:%s", SetBackgroundAudioListenerTask.this.appId, str3);
                        AppMethodBeat.o(145752);
                        return false;
                    }
                    hashMap.put("src", fVar.jfb);
                    hashMap.put("state", str);
                    hashMap.put("errCode", Integer.valueOf(mxVar2.dSE.errCode));
                    String str4 = "";
                    if (!TextUtils.isEmpty(mxVar2.dSE.errMsg)) {
                        str4 = mxVar2.dSE.errMsg;
                    }
                    hashMap.put("errMsg", str4);
                    SetBackgroundAudioListenerTask.this.lEk = new JSONObject(hashMap).toString();
                    SetBackgroundAudioListenerTask.this.action = mxVar2.dSE.action;
                    SetBackgroundAudioListenerTask.c(SetBackgroundAudioListenerTask.this);
                    AppMethodBeat.o(145752);
                    return true;
                }
            }
        };
        public int lqe;

        static /* synthetic */ boolean b(SetBackgroundAudioListenerTask setBackgroundAudioListenerTask) {
            AppMethodBeat.i(145759);
            boolean bDU = setBackgroundAudioListenerTask.bDU();
            AppMethodBeat.o(145759);
            return bDU;
        }

        static /* synthetic */ boolean c(SetBackgroundAudioListenerTask setBackgroundAudioListenerTask) {
            AppMethodBeat.i(145760);
            boolean bDU = setBackgroundAudioListenerTask.bDU();
            AppMethodBeat.o(145760);
            return bDU;
        }

        public SetBackgroundAudioListenerTask(d dVar, f fVar, int i2) {
            AppMethodBeat.i(145753);
            this.lAw = dVar;
            this.lAx = fVar;
            this.lqe = i2;
            AppMethodBeat.o(145753);
        }

        public SetBackgroundAudioListenerTask(Parcel parcel) {
            AppMethodBeat.i(145754);
            f(parcel);
            AppMethodBeat.o(145754);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(145755);
            Log.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInMainProcess");
            if (this.lEM) {
                Log.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "send Preempted Event");
                this.lEM = false;
                mx mxVar = new mx();
                mxVar.dSE.action = 10;
                mxVar.dSE.state = "preempted";
                mxVar.dSE.appId = this.appId;
                mxVar.dSE.dSG = true;
                EventCenter.instance.publish(mxVar);
            }
            String str = a.C0751a.ndb.ncY;
            if (!Util.isNullOrNil(str)) {
                Log.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "remove listener preAppid is %s, appid is %s", str, this.appId);
                a.C0751a.ndb.acD(str);
            }
            a.C0751a.ndb.a(this.lEl, this.appId);
            com.tencent.mm.plugin.appbrand.media.music.a aVar = a.C0751a.ndb;
            String str2 = this.appId;
            int i2 = this.dMe;
            String str3 = this.brandName;
            String str4 = this.appUserName;
            aVar.ncY = str2;
            aVar.dMe = i2;
            aVar.brandName = str3;
            aVar.appUserName = str4;
            AppMethodBeat.o(145755);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(145756);
            if (this.lAx == null) {
                Log.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "service is null, don't callback");
                AppMethodBeat.o(145756);
                return;
            }
            wL(this.action);
            switch (this.action) {
                case 0:
                case 1:
                    h.a(this.appId, this.cxI);
                    AppBrandMusicClientService.ncV.ncW = this.appId;
                    break;
                case 2:
                case 3:
                case 4:
                case 7:
                    h.b(this.appId, this.cxI);
                    break;
                case 13:
                    JsApiOperateBackgroundAudio.b.m(this.lAx);
                    AppMethodBeat.o(145756);
                    return;
                case 14:
                    JsApiOperateBackgroundAudio.a.m(this.lAx);
                    AppMethodBeat.o(145756);
                    return;
            }
            Log.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInClientProcess callback action:%d, retJson:%s", Integer.valueOf(this.action), this.lEk);
            new JsApiOperateBackgroundAudio.c().h(this.lAx).Zh(this.lEk).bEo();
            AppBrandMusicClientService appBrandMusicClientService = AppBrandMusicClientService.ncV;
            int i2 = this.action;
            Log.i("MicroMsg.AppBrandMusicClientService", "notifyAction, action:%d", Integer.valueOf(i2));
            for (Map.Entry<String, AppBrandMusicClientService.a> entry : appBrandMusicClientService.ncU.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    AppBrandMusicClientService.a value = entry.getValue();
                    if (!TextUtils.isEmpty(appBrandMusicClientService.ncW) && appBrandMusicClientService.ncW.equalsIgnoreCase(key)) {
                        Log.i("MicroMsg.AppBrandMusicClientService", "current play music appId is %s", appBrandMusicClientService.ncW);
                        if (value != null) {
                            if (i2 == 10) {
                                value.bxf();
                            } else if (i2 == 2) {
                                value.onStop();
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(145756);
        }

        /* access modifiers changed from: protected */
        public void wL(int i2) {
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(145757);
            this.appId = parcel.readString();
            this.lEk = parcel.readString();
            this.action = parcel.readInt();
            this.dMe = parcel.readInt();
            this.brandName = parcel.readString();
            this.appUserName = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.lEM = z;
            AppMethodBeat.o(145757);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(145758);
            parcel.writeString(this.appId);
            parcel.writeString(this.lEk);
            parcel.writeInt(this.action);
            parcel.writeInt(this.dMe);
            parcel.writeString(this.brandName);
            parcel.writeString(this.appUserName);
            parcel.writeInt(this.lEM ? 1 : 0);
            AppMethodBeat.o(145758);
        }

        static {
            AppMethodBeat.i(145761);
            AppMethodBeat.o(145761);
        }
    }
}
