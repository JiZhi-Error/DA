package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SoterExportResult implements Parcelable {
    public static final Parcelable.Creator<SoterExportResult> CREATOR = new Parcelable.Creator<SoterExportResult>() {
        /* class com.tencent.soter.soterserver.SoterExportResult.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SoterExportResult[] newArray(int i2) {
            return new SoterExportResult[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SoterExportResult createFromParcel(Parcel parcel) {
            AppMethodBeat.i(88743);
            SoterExportResult soterExportResult = new SoterExportResult(parcel);
            AppMethodBeat.o(88743);
            return soterExportResult;
        }
    };
    public byte[] RQo;
    public int RQp;
    public int resultCode;

    public SoterExportResult() {
    }

    public SoterExportResult(Parcel parcel) {
        AppMethodBeat.i(88744);
        this.resultCode = parcel.readInt();
        this.RQo = parcel.createByteArray();
        this.RQp = parcel.readInt();
        AppMethodBeat.o(88744);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(88745);
        parcel.writeInt(this.resultCode);
        parcel.writeByteArray(this.RQo);
        parcel.writeInt(this.RQp);
        AppMethodBeat.o(88745);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(88746);
        AppMethodBeat.o(88746);
    }
}
