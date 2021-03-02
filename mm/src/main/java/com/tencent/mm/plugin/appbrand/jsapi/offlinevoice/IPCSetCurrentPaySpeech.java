package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public class IPCSetCurrentPaySpeech implements b<IPCSetCurrentPaySpeechParam, Bundle> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public /* synthetic */ void invoke(IPCSetCurrentPaySpeechParam iPCSetCurrentPaySpeechParam, d<Bundle> dVar) {
        String str;
        boolean z = false;
        AppMethodBeat.i(46656);
        IPCSetCurrentPaySpeechParam iPCSetCurrentPaySpeechParam2 = iPCSetCurrentPaySpeechParam;
        Bundle bundle = new Bundle();
        if (Util.isNullOrNil(iPCSetCurrentPaySpeechParam2.mjv)) {
            Log.e("MicroMsg.OfflineVoice.IPCSetCurrentPaySpeech", "fail:dialectPackId is null");
            if (dVar != null) {
                bundle.putString("IPCResultInfo", "fail:dialectPackId is null");
                dVar.bn(bundle);
            }
            AppMethodBeat.o(46656);
            return;
        }
        Log.i("MicroMsg.OfflineVoice.IPCSetCurrentPaySpeech", "data.dialectPackId: %s,data.md5Sum:%s ,data.tempFileAbsolutePath :%s ,data.isOnlyDownload:%s ，data.version: %s", iPCSetCurrentPaySpeechParam2.mjv, iPCSetCurrentPaySpeechParam2.mjz, iPCSetCurrentPaySpeechParam2.mjx, Boolean.valueOf(iPCSetCurrentPaySpeechParam2.mjy), iPCSetCurrentPaySpeechParam2.version);
        if (Util.isNullOrNil(iPCSetCurrentPaySpeechParam2.mjx)) {
            Log.i("MicroMsg.OfflineVoice.IPCSetCurrentPaySpeech", "tempFileAbsolutePath == null");
        } else if (Util.isNullOrNil(iPCSetCurrentPaySpeechParam2.mjz) || !iPCSetCurrentPaySpeechParam2.mjz.equalsIgnoreCase(s.bhK(iPCSetCurrentPaySpeechParam2.mjx))) {
            Log.e("MicroMsg.OfflineVoice.IPCSetCurrentPaySpeech", "fail:md5Sum:%s", Boolean.valueOf(Util.isNullOrNil(iPCSetCurrentPaySpeechParam2.mjz)));
            if (dVar != null) {
                bundle.putString("IPCResultInfo", "fail:md5Sum is null or md5Sum is not euqal tempFileAbsolutePath MD5");
                dVar.bn(bundle);
            }
            AppMethodBeat.o(46656);
            return;
        } else {
            s.boN(d.mjC);
            String str2 = d.mjC + iPCSetCurrentPaySpeechParam2.mjv + ".pos";
            if (s.YS(str2)) {
                Log.i("MicroMsg.OfflineVoice.IPCSetCurrentPaySpeech", " has this voice resource file before ，first delete exist file");
                s.deleteFile(str2);
            }
            s.nw(iPCSetCurrentPaySpeechParam2.mjx, str2);
            d.bIh().h(iPCSetCurrentPaySpeechParam2.mjv, str2, iPCSetCurrentPaySpeechParam2.mjz, iPCSetCurrentPaySpeechParam2.version);
            Log.i("MicroMsg.OfflineVoice.IPCSetCurrentPaySpeech", "copyFile to %s %s", str2, iPCSetCurrentPaySpeechParam2.mjz);
        }
        if (iPCSetCurrentPaySpeechParam2.mjy) {
            Log.i("MicroMsg.OfflineVoice.IPCSetCurrentPaySpeech", "isOnlyDownload:%s", Boolean.valueOf(iPCSetCurrentPaySpeechParam2.mjy));
            str = "isOnlyDownload is true, dont reset source";
        } else if (!Util.isNullOrNil(iPCSetCurrentPaySpeechParam2.mjw)) {
            d.bIh();
            d.aaw(iPCSetCurrentPaySpeechParam2.mjv);
            str = "data.tempFilePath is not null，data.dialectPackId is " + iPCSetCurrentPaySpeechParam2.mjv + ", set source";
        } else if (Util.isEqual(iPCSetCurrentPaySpeechParam2.mjv, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            d.bIh();
            String aax = d.aax(iPCSetCurrentPaySpeechParam2.mjv);
            if (Util.isNullOrNil(aax) || !s.YS(aax)) {
                str = "isOnlyDownload is false , data.tempFilePath is null、data.dialectPackId = " + iPCSetCurrentPaySpeechParam2.mjv + "，dont have this resource , set defaylt resource";
            } else {
                str = "isOnlyDownload is false , data.tempFilePath is null、data.dialectPackId = " + iPCSetCurrentPaySpeechParam2.mjv + "，set resource";
            }
            d.bIh();
            d.aaw(iPCSetCurrentPaySpeechParam2.mjv);
        } else {
            d.bIh();
            String aax2 = d.aax(iPCSetCurrentPaySpeechParam2.mjv);
            if (Util.isNullOrNil(aax2) || !s.YS(aax2)) {
                Log.e("MicroMsg.OfflineVoice.IPCSetCurrentPaySpeech", "resPath:%s %s", Util.nullAs(aax2, BuildConfig.COMMAND), Boolean.valueOf(s.YS(aax2)));
                str = "isOnlyDownload is false , data.tempFilePath is null、data.dialectPackId =" + iPCSetCurrentPaySpeechParam2.mjv + "，dont have this resource";
                z = true;
            } else {
                d.bIh();
                d.aaw(iPCSetCurrentPaySpeechParam2.mjv);
                str = "isOnlyDownload is false , data.tempFilePath is null、data.dialectPackId = " + iPCSetCurrentPaySpeechParam2.mjv + "，set resource";
            }
        }
        if (dVar != null) {
            if (z) {
                bundle.putString("IPCResultInfo", "fail:".concat(String.valueOf(str)));
                dVar.bn(bundle);
                AppMethodBeat.o(46656);
                return;
            }
            bundle.putString("IPCResultInfo", "ok:".concat(String.valueOf(str)));
            dVar.bn(bundle);
        }
        AppMethodBeat.o(46656);
    }

    public static final class IPCSetCurrentPaySpeechParam implements Parcelable {
        public static final Parcelable.Creator<IPCSetCurrentPaySpeechParam> CREATOR = new Parcelable.Creator<IPCSetCurrentPaySpeechParam>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.IPCSetCurrentPaySpeech.IPCSetCurrentPaySpeechParam.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ IPCSetCurrentPaySpeechParam[] newArray(int i2) {
                return new IPCSetCurrentPaySpeechParam[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ IPCSetCurrentPaySpeechParam createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46652);
                IPCSetCurrentPaySpeechParam iPCSetCurrentPaySpeechParam = new IPCSetCurrentPaySpeechParam(parcel);
                AppMethodBeat.o(46652);
                return iPCSetCurrentPaySpeechParam;
            }
        };
        private String mjv;
        private String mjw;
        private String mjx;
        private boolean mjy;
        private String mjz;
        private String version;

        public IPCSetCurrentPaySpeechParam(String str, String str2, String str3, boolean z, String str4, String str5) {
            this.mjv = str;
            this.mjw = str2;
            this.mjx = str3;
            this.mjy = z;
            this.mjz = str4;
            this.version = str5;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(46653);
            parcel.writeString(this.mjv);
            parcel.writeString(this.mjw);
            parcel.writeString(this.mjx);
            parcel.writeByte(this.mjy ? (byte) 1 : 0);
            parcel.writeString(this.mjz);
            parcel.writeString(this.version);
            AppMethodBeat.o(46653);
        }

        public IPCSetCurrentPaySpeechParam() {
        }

        protected IPCSetCurrentPaySpeechParam(Parcel parcel) {
            AppMethodBeat.i(46654);
            this.mjv = parcel.readString();
            this.mjw = parcel.readString();
            this.mjx = parcel.readString();
            this.mjy = parcel.readByte() != 0;
            this.mjz = parcel.readString();
            this.version = parcel.readString();
            AppMethodBeat.o(46654);
        }

        static {
            AppMethodBeat.i(46655);
            AppMethodBeat.o(46655);
        }
    }
}
