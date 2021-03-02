package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative;

public class FaceCharacteristicsResult implements Parcelable {
    public static final Parcelable.Creator<FaceCharacteristicsResult> CREATOR = new Parcelable.Creator<FaceCharacteristicsResult>() {
        /* class com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ FaceCharacteristicsResult[] newArray(int i2) {
            return new FaceCharacteristicsResult[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ FaceCharacteristicsResult createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103702);
            FaceCharacteristicsResult faceCharacteristicsResult = new FaceCharacteristicsResult(parcel);
            AppMethodBeat.o(103702);
            return faceCharacteristicsResult;
        }
    };
    public int errCode;
    public String errMsg;
    public FaceProNative.FaceStatus sQG;

    protected FaceCharacteristicsResult(Parcel parcel) {
        AppMethodBeat.i(103703);
        this.errCode = parcel.readInt();
        this.errMsg = parcel.readString();
        AppMethodBeat.o(103703);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(103704);
        parcel.writeParcelable(this.sQG, i2);
        parcel.writeInt(this.errCode);
        parcel.writeString(this.errMsg);
        AppMethodBeat.o(103704);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(103706);
        AppMethodBeat.o(103706);
    }

    public String toString() {
        AppMethodBeat.i(103705);
        String str = "FaceCharacteristicsResult{mStatus=" + this.sQG + ", errCode=" + this.errCode + ", errMsg='" + this.errMsg + '\'' + '}';
        AppMethodBeat.o(103705);
        return str;
    }

    public FaceCharacteristicsResult() {
    }

    public static boolean HG(int i2) {
        return i2 >= 10 && i2 < 100;
    }

    public static boolean HH(int i2) {
        return i2 > 0 && i2 < 10;
    }

    public static boolean HI(int i2) {
        return i2 <= 0;
    }

    public final void aW(int i2, String str) {
        this.errCode = i2;
        this.errMsg = str;
    }
}
