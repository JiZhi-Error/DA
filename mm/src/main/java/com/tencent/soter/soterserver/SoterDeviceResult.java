package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SoterDeviceResult implements Parcelable {
    public static final Parcelable.Creator<SoterDeviceResult> CREATOR = new Parcelable.Creator<SoterDeviceResult>() {
        /* class com.tencent.soter.soterserver.SoterDeviceResult.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SoterDeviceResult[] newArray(int i2) {
            return new SoterDeviceResult[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SoterDeviceResult createFromParcel(Parcel parcel) {
            AppMethodBeat.i(88739);
            SoterDeviceResult soterDeviceResult = new SoterDeviceResult(parcel);
            AppMethodBeat.o(88739);
            return soterDeviceResult;
        }
    };
    public byte[] RQo;
    public int RQp;
    public int resultCode;

    public SoterDeviceResult() {
    }

    protected SoterDeviceResult(Parcel parcel) {
        AppMethodBeat.i(88740);
        this.resultCode = parcel.readInt();
        this.RQo = parcel.createByteArray();
        this.RQp = parcel.readInt();
        AppMethodBeat.o(88740);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(88741);
        parcel.writeInt(this.resultCode);
        parcel.writeByteArray(this.RQo);
        parcel.writeInt(this.RQp);
        AppMethodBeat.o(88741);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(88742);
        AppMethodBeat.o(88742);
    }
}
