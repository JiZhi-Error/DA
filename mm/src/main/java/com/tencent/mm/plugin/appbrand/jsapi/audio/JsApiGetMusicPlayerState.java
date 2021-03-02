package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.media.music.a;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public class JsApiGetMusicPlayerState extends d<f> {
    public static final int CTRL_INDEX = 46;
    public static final String NAME = "getMusicPlayerState";
    private GetMusicPlayerState lDT;

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(145726);
        this.lDT = new GetMusicPlayerState(this, fVar, i2);
        this.lDT.mAppid = fVar.getAppId();
        AppBrandMainProcessService.a(this.lDT);
        AppMethodBeat.o(145726);
    }

    static class GetMusicPlayerState extends MainProcessTask {
        public static final Parcelable.Creator<GetMusicPlayerState> CREATOR = new Parcelable.Creator<GetMusicPlayerState>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState.GetMusicPlayerState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ GetMusicPlayerState[] newArray(int i2) {
                return new GetMusicPlayerState[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ GetMusicPlayerState createFromParcel(Parcel parcel) {
                AppMethodBeat.i(145719);
                GetMusicPlayerState getMusicPlayerState = new GetMusicPlayerState(parcel);
                AppMethodBeat.o(145719);
                return getMusicPlayerState;
            }
        };
        public int atU;
        public boolean error = false;
        public String jFn;
        private p lAw;
        private f lAx;
        public int lDU;
        public String lDV;
        private int lqe;
        public String mAppid;
        public int mPosition;
        public int mStatus;

        public GetMusicPlayerState(p pVar, f fVar, int i2) {
            this.lAw = pVar;
            this.lAx = fVar;
            this.lqe = i2;
        }

        public GetMusicPlayerState(Parcel parcel) {
            AppMethodBeat.i(145720);
            f(parcel);
            AppMethodBeat.o(145720);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            String str;
            AppMethodBeat.i(145722);
            HashMap hashMap = new HashMap();
            hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(this.atU));
            hashMap.put("currentPosition", Integer.valueOf(this.mPosition));
            hashMap.put("status", Integer.valueOf(this.mStatus));
            hashMap.put("downloadPercent", Integer.valueOf(this.lDU));
            hashMap.put("dataUrl", this.lDV);
            f fVar = this.lAx;
            int i2 = this.lqe;
            p pVar = this.lAw;
            if (this.error) {
                str = "fail" + (TextUtils.isEmpty(this.jFn) ? "" : ":" + this.jFn);
            } else {
                str = "ok";
            }
            fVar.i(i2, pVar.n(str, hashMap));
            AppMethodBeat.o(145722);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(145723);
            this.mAppid = parcel.readString();
            this.error = parcel.readByte() != 0;
            this.atU = parcel.readInt();
            this.mPosition = parcel.readInt();
            this.mStatus = parcel.readInt();
            this.lDU = parcel.readInt();
            this.lDV = parcel.readString();
            this.jFn = parcel.readString();
            AppMethodBeat.o(145723);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(145724);
            parcel.writeString(this.mAppid);
            parcel.writeByte(this.error ? (byte) 1 : 0);
            parcel.writeInt(this.atU);
            parcel.writeInt(this.mPosition);
            parcel.writeInt(this.mStatus);
            parcel.writeInt(this.lDU);
            parcel.writeString(this.lDV);
            parcel.writeString(this.jFn);
            AppMethodBeat.o(145724);
        }

        static {
            AppMethodBeat.i(145725);
            AppMethodBeat.o(145725);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            int i2;
            int i3;
            AppMethodBeat.i(145721);
            String str = a.C0751a.ndb.ncY;
            if (Util.isNullOrNil(str) || str.equals(this.mAppid)) {
                com.tencent.mm.ay.f bef = com.tencent.mm.ay.a.bef();
                if (bef != null) {
                    c beg = com.tencent.mm.ay.a.beg();
                    if (beg != null) {
                        int i4 = beg.atU;
                        i2 = beg.mPosition;
                        this.mStatus = beg.mStatus;
                        this.lDU = beg.jeP;
                        i3 = i4;
                    } else {
                        i2 = -1;
                        i3 = -1;
                    }
                    this.atU = i3 / 1000;
                    this.mPosition = i2 / 1000;
                    this.lDV = bef.jfb;
                    this.jFn = "";
                    this.error = false;
                } else {
                    this.mStatus = 2;
                    this.jFn = "";
                    this.error = false;
                }
                Log.i("MicroMsg.JsApiGetMusicPlayerState", "duration %d , position %d ,status %s , downloadpercent %d , dataurl %s", Integer.valueOf(this.atU), Integer.valueOf(this.mPosition), Integer.valueOf(this.mStatus), Integer.valueOf(this.lDU), this.lDV);
                bDU();
                AppMethodBeat.o(145721);
                return;
            }
            Log.i("MicroMsg.JsApiGetMusicPlayerState", "appid not match cannot operate");
            this.error = true;
            this.jFn = "appid not match cannot operate";
            bDU();
            AppMethodBeat.o(145721);
        }
    }
}
