package com.tencent.mm.plugin.appbrand.jsapi.h5_interact;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SendDataToMiniProgramFromH5Event implements Parcelable {
    public static final Parcelable.Creator<SendDataToMiniProgramFromH5Event> CREATOR = new Parcelable.Creator<SendDataToMiniProgramFromH5Event>() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SendDataToMiniProgramFromH5Event[] newArray(int i2) {
            return new SendDataToMiniProgramFromH5Event[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SendDataToMiniProgramFromH5Event createFromParcel(Parcel parcel) {
            AppMethodBeat.i(46355);
            SendDataToMiniProgramFromH5Event sendDataToMiniProgramFromH5Event = new SendDataToMiniProgramFromH5Event(parcel);
            AppMethodBeat.o(46355);
            return sendDataToMiniProgramFromH5Event;
        }
    };
    public String data;
    public String lWe;
    public int lWf;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(46356);
        parcel.writeString(this.lWe);
        parcel.writeString(this.data);
        parcel.writeInt(this.lWf);
        AppMethodBeat.o(46356);
    }

    public SendDataToMiniProgramFromH5Event() {
    }

    protected SendDataToMiniProgramFromH5Event(Parcel parcel) {
        AppMethodBeat.i(46357);
        this.lWe = parcel.readString();
        this.data = parcel.readString();
        this.lWf = parcel.readInt();
        AppMethodBeat.o(46357);
    }

    static {
        AppMethodBeat.i(46358);
        AppMethodBeat.o(46358);
    }
}
