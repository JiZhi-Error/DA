package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GetOnLineInfoInfoResult implements Parcelable {
    public static final Parcelable.Creator<GetOnLineInfoInfoResult> CREATOR = new Parcelable.Creator<GetOnLineInfoInfoResult>() {
        /* class com.tencent.mm.plugin.appbrand.config.GetOnLineInfoInfoResult.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GetOnLineInfoInfoResult[] newArray(int i2) {
            return new GetOnLineInfoInfoResult[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GetOnLineInfoInfoResult createFromParcel(Parcel parcel) {
            AppMethodBeat.i(194336);
            GetOnLineInfoInfoResult getOnLineInfoInfoResult = new GetOnLineInfoInfoResult(parcel);
            AppMethodBeat.o(194336);
            return getOnLineInfoInfoResult;
        }
    };
    public int jjN = -1;
    public int jjS = 0;
    public boolean kDf = false;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(194337);
        parcel.writeInt(this.jjN);
        parcel.writeInt(this.jjS);
        parcel.writeByte(this.kDf ? (byte) 1 : 0);
        AppMethodBeat.o(194337);
    }

    public GetOnLineInfoInfoResult() {
    }

    protected GetOnLineInfoInfoResult(Parcel parcel) {
        boolean z = false;
        AppMethodBeat.i(194338);
        this.jjN = parcel.readInt();
        this.jjS = parcel.readInt();
        this.kDf = parcel.readByte() != 0 ? true : z;
        AppMethodBeat.o(194338);
    }

    static {
        AppMethodBeat.i(194340);
        AppMethodBeat.o(194340);
    }

    public String toString() {
        AppMethodBeat.i(194339);
        String str = "GetOnLineInfoInfoResult{iconType=" + this.jjN + ", clientVersion=" + this.jjS + ", isWXOnline=" + this.kDf + '}';
        AppMethodBeat.o(194339);
        return str;
    }
}
