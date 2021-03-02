package com.tencent.mm.plugin.facedetectlight.Utils;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class YTAGFaceReflectResult implements Parcelable {
    public static final Parcelable.Creator<YTAGFaceReflectResult> CREATOR = new Parcelable.Creator<YTAGFaceReflectResult>() {
        /* class com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectResult.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ YTAGFaceReflectResult[] newArray(int i2) {
            return new YTAGFaceReflectResult[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ YTAGFaceReflectResult createFromParcel(Parcel parcel) {
            AppMethodBeat.i(104276);
            YTAGFaceReflectResult yTAGFaceReflectResult = new YTAGFaceReflectResult(parcel);
            AppMethodBeat.o(104276);
            return yTAGFaceReflectResult;
        }
    };
    public byte[] data;
    public int result;
    public byte[] sidedata;

    public YTAGFaceReflectResult(int i2) {
        this.result = i2;
        this.data = null;
        this.sidedata = null;
    }

    protected YTAGFaceReflectResult(Parcel parcel) {
        AppMethodBeat.i(104277);
        this.result = parcel.readInt();
        this.data = parcel.createByteArray();
        this.sidedata = parcel.createByteArray();
        AppMethodBeat.o(104277);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(104278);
        parcel.writeInt(this.result);
        parcel.writeByteArray(this.data);
        parcel.writeByteArray(this.sidedata);
        AppMethodBeat.o(104278);
    }

    static {
        AppMethodBeat.i(104279);
        AppMethodBeat.o(104279);
    }

    public int describeContents() {
        return 0;
    }

    public void setResult(int i2) {
        this.result = i2;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setSidedata(byte[] bArr) {
        this.sidedata = bArr;
    }
}
