package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SoterSignResult implements Parcelable {
    public static final Parcelable.Creator<SoterSignResult> CREATOR = new Parcelable.Creator<SoterSignResult>() {
        /* class com.tencent.soter.soterserver.SoterSignResult.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SoterSignResult[] newArray(int i2) {
            return new SoterSignResult[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SoterSignResult createFromParcel(Parcel parcel) {
            AppMethodBeat.i(88751);
            SoterSignResult soterSignResult = new SoterSignResult(parcel);
            AppMethodBeat.o(88751);
            return soterSignResult;
        }
    };
    public byte[] RQo;
    public int RQp;
    public int resultCode;

    public SoterSignResult() {
    }

    protected SoterSignResult(Parcel parcel) {
        AppMethodBeat.i(88752);
        this.resultCode = parcel.readInt();
        this.RQo = parcel.createByteArray();
        this.RQp = parcel.readInt();
        AppMethodBeat.o(88752);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(88753);
        parcel.writeInt(this.resultCode);
        parcel.writeByteArray(this.RQo);
        parcel.writeInt(this.RQp);
        AppMethodBeat.o(88753);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(88754);
        AppMethodBeat.o(88754);
    }
}
