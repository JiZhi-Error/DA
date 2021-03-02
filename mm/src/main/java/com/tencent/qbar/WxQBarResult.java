package com.tencent.qbar;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qbar.a;

public class WxQBarResult extends a.C2180a implements Parcelable {
    public static final Parcelable.Creator<WxQBarResult> CREATOR = new Parcelable.Creator<WxQBarResult>() {
        /* class com.tencent.qbar.WxQBarResult.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WxQBarResult[] newArray(int i2) {
            return new WxQBarResult[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WxQBarResult createFromParcel(Parcel parcel) {
            AppMethodBeat.i(176209);
            WxQBarResult wxQBarResult = new WxQBarResult(parcel);
            AppMethodBeat.o(176209);
            return wxQBarResult;
        }
    };
    public int RJN = 0;
    public WxQBarPoint RKp;

    public WxQBarResult(int i2, String str, String str2, byte[] bArr, String str3, int i3) {
        this.typeID = i2;
        this.typeName = str;
        this.data = str2;
        this.rawData = bArr;
        this.charset = str3;
        this.priorityLevel = i3;
    }

    public WxQBarResult(Parcel parcel) {
        AppMethodBeat.i(176210);
        this.typeID = parcel.readInt();
        this.typeName = parcel.readString();
        this.data = parcel.readString();
        parcel.readByteArray(this.rawData);
        this.charset = parcel.readString();
        this.RJN = parcel.readInt();
        this.RKp = (WxQBarPoint) parcel.readParcelable(WxQBarPoint.class.getClassLoader());
        this.priorityLevel = parcel.readInt();
        AppMethodBeat.o(176210);
    }

    static {
        AppMethodBeat.i(176212);
        AppMethodBeat.o(176212);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(176211);
        parcel.writeInt(this.typeID);
        parcel.writeString(this.typeName);
        parcel.writeString(this.data);
        parcel.writeByteArray(this.rawData);
        parcel.writeString(this.charset);
        parcel.writeInt(this.RJN);
        parcel.writeParcelable(this.RKp, i2);
        parcel.writeInt(this.priorityLevel);
        AppMethodBeat.o(176211);
    }
}
