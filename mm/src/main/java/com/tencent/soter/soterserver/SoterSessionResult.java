package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SoterSessionResult implements Parcelable {
    public static final Parcelable.Creator<SoterSessionResult> CREATOR = new Parcelable.Creator<SoterSessionResult>() {
        /* class com.tencent.soter.soterserver.SoterSessionResult.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SoterSessionResult[] newArray(int i2) {
            return new SoterSessionResult[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SoterSessionResult createFromParcel(Parcel parcel) {
            AppMethodBeat.i(88747);
            SoterSessionResult soterSessionResult = new SoterSessionResult(parcel);
            AppMethodBeat.o(88747);
            return soterSessionResult;
        }
    };
    public long dDZ;
    public int resultCode;

    public SoterSessionResult() {
    }

    protected SoterSessionResult(Parcel parcel) {
        AppMethodBeat.i(88748);
        this.dDZ = parcel.readLong();
        this.resultCode = parcel.readInt();
        AppMethodBeat.o(88748);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(88749);
        parcel.writeLong(this.dDZ);
        parcel.writeInt(this.resultCode);
        AppMethodBeat.o(88749);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(88750);
        AppMethodBeat.o(88750);
    }
}
