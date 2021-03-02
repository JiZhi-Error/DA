package com.tencent.mm.plugin.appbrand.jsapi.h5_interact;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public class SendDataToH5FromMiniProgramEvent extends IEvent implements Parcelable {
    public static final Parcelable.Creator<SendDataToH5FromMiniProgramEvent> CREATOR = new Parcelable.Creator<SendDataToH5FromMiniProgramEvent>() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToH5FromMiniProgramEvent.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SendDataToH5FromMiniProgramEvent[] newArray(int i2) {
            return new SendDataToH5FromMiniProgramEvent[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SendDataToH5FromMiniProgramEvent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(121065);
            SendDataToH5FromMiniProgramEvent sendDataToH5FromMiniProgramEvent = new SendDataToH5FromMiniProgramEvent(parcel);
            AppMethodBeat.o(121065);
            return sendDataToH5FromMiniProgramEvent;
        }
    };
    public String data;
    public String lWc;
    public int lWd;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(121066);
        parcel.writeString(this.lWc);
        parcel.writeString(this.data);
        parcel.writeInt(this.lWd);
        AppMethodBeat.o(121066);
    }

    public SendDataToH5FromMiniProgramEvent() {
    }

    protected SendDataToH5FromMiniProgramEvent(Parcel parcel) {
        AppMethodBeat.i(121067);
        this.lWc = parcel.readString();
        this.data = parcel.readString();
        this.lWd = parcel.readInt();
        AppMethodBeat.o(121067);
    }

    static {
        AppMethodBeat.i(121068);
        AppMethodBeat.o(121068);
    }
}
