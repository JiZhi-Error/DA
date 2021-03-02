package com.tencent.mm.plugin.appbrand.message;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WxaAppMsgChannel implements Parcelable {
    public static final Parcelable.Creator<WxaAppMsgChannel> CREATOR = new Parcelable.Creator<WxaAppMsgChannel>() {
        /* class com.tencent.mm.plugin.appbrand.message.WxaAppMsgChannel.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WxaAppMsgChannel[] newArray(int i2) {
            return new WxaAppMsgChannel[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WxaAppMsgChannel createFromParcel(Parcel parcel) {
            AppMethodBeat.i(227190);
            WxaAppMsgChannel wxaAppMsgChannel = new WxaAppMsgChannel(parcel);
            AppMethodBeat.o(227190);
            return wxaAppMsgChannel;
        }
    };
    public String appId;
    public String dWG;
    public long lhG;
    public String msgId;
    public int msgType;
    public String ngf;
    public String ngg;

    public WxaAppMsgChannel() {
    }

    public WxaAppMsgChannel(Parcel parcel) {
        AppMethodBeat.i(227191);
        this.msgId = parcel.readString();
        this.ngf = parcel.readString();
        this.ngg = parcel.readString();
        this.appId = parcel.readString();
        this.msgType = parcel.readInt();
        this.dWG = parcel.readString();
        this.lhG = parcel.readLong();
        AppMethodBeat.o(227191);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(227192);
        parcel.writeString(this.msgId);
        parcel.writeString(this.ngf);
        parcel.writeString(this.ngg);
        parcel.writeString(this.appId);
        parcel.writeInt(this.msgType);
        parcel.writeString(this.dWG);
        parcel.writeLong(this.lhG);
        AppMethodBeat.o(227192);
    }

    static {
        AppMethodBeat.i(227193);
        AppMethodBeat.o(227193);
    }
}
