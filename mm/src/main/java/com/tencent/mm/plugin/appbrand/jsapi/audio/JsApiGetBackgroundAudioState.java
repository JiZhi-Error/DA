package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.media.music.a;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public class JsApiGetBackgroundAudioState extends ab {
    public static final int CTRL_INDEX = 159;
    public static final String NAME = "getBackgroundAudioState";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final String a(f fVar, JSONObject jSONObject) {
        AppMethodBeat.i(145718);
        String appId = fVar.getAppId();
        GetBackgroundAudioStateTask getBackgroundAudioStateTask = new GetBackgroundAudioStateTask();
        getBackgroundAudioStateTask.appId = appId;
        if (!AppBrandMainProcessService.b(getBackgroundAudioStateTask)) {
            Log.e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail");
            String h2 = h("fail", null);
            AppMethodBeat.o(145718);
            return h2;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Double.valueOf(getBackgroundAudioStateTask.lDN));
        hashMap.put("currentTime", Double.valueOf(getBackgroundAudioStateTask.lDO));
        hashMap.put("paused", Boolean.valueOf(getBackgroundAudioStateTask.jnj == 1));
        hashMap.put("buffered", Double.valueOf(getBackgroundAudioStateTask.lDP));
        hashMap.put("src", getBackgroundAudioStateTask.dtT);
        hashMap.put("title", getBackgroundAudioStateTask.title);
        hashMap.put("epname", getBackgroundAudioStateTask.lDQ);
        hashMap.put("singer", getBackgroundAudioStateTask.lDR);
        hashMap.put("coverImgUrl", getBackgroundAudioStateTask.coverImgUrl);
        hashMap.put("webUrl", getBackgroundAudioStateTask.lDS);
        hashMap.put("protocol", getBackgroundAudioStateTask.protocol == null ? "" : getBackgroundAudioStateTask.protocol);
        hashMap.put("startTime", Integer.valueOf(getBackgroundAudioStateTask.dvv / 1000));
        hashMap.put("songLyric", getBackgroundAudioStateTask.songLyric);
        hashMap.put("playbackRate", Double.valueOf(getBackgroundAudioStateTask.iJH));
        hashMap.put("referrerPolicy", getBackgroundAudioStateTask.iJP);
        String str = TextUtils.isEmpty(getBackgroundAudioStateTask.jFn) ? "" : getBackgroundAudioStateTask.jFn;
        if (getBackgroundAudioStateTask.error) {
            Log.e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail, err:%s", str);
            String h3 = h("fail:".concat(String.valueOf(str)), null);
            AppMethodBeat.o(145718);
            return h3;
        }
        Log.d("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState is ok");
        String n = n("ok", hashMap);
        AppMethodBeat.o(145718);
        return n;
    }

    static class GetBackgroundAudioStateTask extends MainProcessTask {
        public static final Parcelable.Creator<GetBackgroundAudioStateTask> CREATOR = new Parcelable.Creator<GetBackgroundAudioStateTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState.GetBackgroundAudioStateTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ GetBackgroundAudioStateTask[] newArray(int i2) {
                return new GetBackgroundAudioStateTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ GetBackgroundAudioStateTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(145712);
                GetBackgroundAudioStateTask getBackgroundAudioStateTask = new GetBackgroundAudioStateTask(parcel);
                AppMethodBeat.o(145712);
                return getBackgroundAudioStateTask;
            }
        };
        public String appId = "";
        public String coverImgUrl;
        public String dtT;
        public int dvv;
        public boolean error = false;
        public double iJH;
        public String iJP = null;
        public String jFn;
        public int jnj;
        public double lDN = 0.0d;
        public double lDO;
        public double lDP;
        public String lDQ;
        public String lDR;
        public String lDS;
        public String protocol;
        public String songLyric;
        public String title;

        public GetBackgroundAudioStateTask() {
        }

        public GetBackgroundAudioStateTask(Parcel parcel) {
            AppMethodBeat.i(145713);
            f(parcel);
            AppMethodBeat.o(145713);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(145715);
            this.appId = parcel.readString();
            this.lDN = parcel.readDouble();
            this.lDO = parcel.readDouble();
            this.jnj = parcel.readInt();
            this.lDP = parcel.readDouble();
            this.dtT = parcel.readString();
            this.title = parcel.readString();
            this.lDQ = parcel.readString();
            this.lDR = parcel.readString();
            this.coverImgUrl = parcel.readString();
            this.lDS = parcel.readString();
            this.protocol = parcel.readString();
            this.songLyric = parcel.readString();
            this.dvv = parcel.readInt();
            this.iJH = parcel.readDouble();
            this.iJP = parcel.readString();
            AppMethodBeat.o(145715);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(145716);
            parcel.writeString(this.appId);
            parcel.writeDouble(this.lDN);
            parcel.writeDouble(this.lDO);
            parcel.writeInt(this.jnj);
            parcel.writeDouble(this.lDP);
            parcel.writeString(this.dtT);
            parcel.writeString(this.title);
            parcel.writeString(this.lDQ);
            parcel.writeString(this.lDR);
            parcel.writeString(this.coverImgUrl);
            parcel.writeString(this.lDS);
            parcel.writeString(this.protocol);
            parcel.writeString(this.songLyric);
            parcel.writeInt(this.dvv);
            parcel.writeDouble(this.iJH);
            parcel.writeString(this.iJP);
            AppMethodBeat.o(145716);
        }

        static {
            AppMethodBeat.i(145717);
            AppMethodBeat.o(145717);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            double d2 = 0.0d;
            AppMethodBeat.i(145714);
            String str = a.C0751a.ndb.ncY;
            if (Util.isNullOrNil(str) || str.equals(this.appId)) {
                com.tencent.mm.ay.f bef = com.tencent.mm.ay.a.bef();
                if (bef != null) {
                    c beg = com.tencent.mm.ay.a.beg();
                    int i2 = -1;
                    int i3 = -1;
                    if (beg != null) {
                        i2 = beg.atU;
                        i3 = beg.mPosition;
                    }
                    if (beg == null || i2 < 0 || i3 < 0) {
                        Log.e("MicroMsg.JsApiGetBackgroundAudioState", "return parameter is invalid, duration_t:%d, position:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                        this.error = true;
                        this.jFn = "return parameter is invalid";
                        bDU();
                        AppMethodBeat.o(145714);
                        return;
                    }
                    this.lDN = ((double) i2) / 1000.0d;
                    this.lDO = ((double) i3) / 1000.0d;
                    int i4 = beg.mStatus;
                    int i5 = beg.jeP;
                    if (this.lDN > 0.0d) {
                        d2 = (((double) i5) * this.lDN) / 100.0d;
                    }
                    this.lDP = d2;
                    this.jnj = i4 == 1 ? 0 : 1;
                    this.dtT = bef.jfb;
                    this.title = bef.jeX;
                    this.lDQ = bef.jeZ;
                    this.lDR = bef.jeY;
                    this.coverImgUrl = bef.jfa;
                    this.lDS = bef.jfd;
                    this.protocol = bef.protocol;
                    this.dvv = bef.dvv;
                    this.songLyric = bef.jfe;
                    this.iJH = bef.iJH;
                    this.iJP = bef.iJP;
                    Log.d("MicroMsg.JsApiGetBackgroundAudioState", "duration: %f , currentTime: %f ,paused: %d , buffered: %f , src: %s, startTime:%d, title:%s, singer:%s, webUrl:%s, coverImgUrl:%s, protocol:%s, playbackRate:%f, referrerPolicy: %s", Double.valueOf(this.lDN), Double.valueOf(this.lDO), Integer.valueOf(this.jnj), Double.valueOf(this.lDP), this.dtT, Integer.valueOf(this.dvv), this.title, this.lDR, this.lDS, this.coverImgUrl, this.protocol, Double.valueOf(this.iJH), this.iJP);
                } else {
                    Log.e("MicroMsg.JsApiGetBackgroundAudioState", "currentWrapper is null");
                    this.error = true;
                    this.jFn = "currentWrapper is null";
                }
                bDU();
                AppMethodBeat.o(145714);
                return;
            }
            Log.i("MicroMsg.JsApiGetBackgroundAudioState", "appid not match cannot get background audio state, preAppId:%s, appId:%s", str, this.appId);
            this.error = true;
            this.jFn = "appid not match cannot get background audio state";
            bDU();
            AppMethodBeat.o(145714);
        }
    }
}
