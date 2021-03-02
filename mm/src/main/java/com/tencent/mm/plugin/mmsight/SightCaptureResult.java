package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.sdk.platformtools.Log;

public class SightCaptureResult implements Parcelable {
    public static final Parcelable.Creator<SightCaptureResult> CREATOR = new Parcelable.Creator<SightCaptureResult>() {
        /* class com.tencent.mm.plugin.mmsight.SightCaptureResult.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SightCaptureResult[] newArray(int i2) {
            return new SightCaptureResult[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SightCaptureResult createFromParcel(Parcel parcel) {
            AppMethodBeat.i(148777);
            SightCaptureResult sightCaptureResult = new SightCaptureResult(parcel);
            AppMethodBeat.o(148777);
            return sightCaptureResult;
        }
    };
    public boolean tkD = false;
    public String zsA = "";
    public String zsB = "";
    public String zsC = "";
    public String zsD = "";
    public int zsE = 0;
    public cly zsF = new cly();
    public String zsG = "";
    public boolean zsy = false;
    public boolean zsz = true;

    public SightCaptureResult(boolean z, String str, String str2, String str3, String str4, int i2, cly cly) {
        AppMethodBeat.i(148778);
        this.zsz = z;
        this.zsA = str;
        this.zsB = str2;
        this.zsC = str3;
        this.zsE = i2;
        this.zsF = cly;
        this.zsD = str4;
        this.tkD = true;
        this.zsy = false;
        AppMethodBeat.o(148778);
    }

    public SightCaptureResult(boolean z, String str) {
        AppMethodBeat.i(148779);
        this.zsz = z;
        this.zsG = str;
        this.tkD = false;
        this.zsy = true;
        AppMethodBeat.o(148779);
    }

    protected SightCaptureResult(Parcel parcel) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(148780);
        this.tkD = parcel.readByte() != 0;
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.zsy = z;
        if (parcel.readByte() != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.zsz = z2;
        this.zsA = parcel.readString();
        this.zsB = parcel.readString();
        this.zsC = parcel.readString();
        this.zsD = parcel.readString();
        this.zsE = parcel.readInt();
        this.zsG = parcel.readString();
        try {
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            this.zsF = new cly();
            this.zsF.parseFrom(bArr);
            AppMethodBeat.o(148780);
        } catch (Exception e2) {
            Log.e("MicroMsg.SightCaptureResult", "read ext info error: %s", e2.getMessage());
            AppMethodBeat.o(148780);
        }
    }

    static {
        AppMethodBeat.i(148782);
        AppMethodBeat.o(148782);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        int i4 = 1;
        AppMethodBeat.i(148781);
        parcel.writeByte((byte) (this.tkD ? 1 : 0));
        if (this.zsy) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        if (!this.zsz) {
            i4 = 0;
        }
        parcel.writeByte((byte) i4);
        parcel.writeString(this.zsA);
        parcel.writeString(this.zsB);
        parcel.writeString(this.zsC);
        parcel.writeString(this.zsD);
        parcel.writeInt(this.zsE);
        parcel.writeString(this.zsG);
        try {
            byte[] byteArray = this.zsF.toByteArray();
            parcel.writeInt(byteArray.length);
            parcel.writeByteArray(byteArray);
            AppMethodBeat.o(148781);
        } catch (Exception e2) {
            Log.e("MicroMsg.SightCaptureResult", "write ext info error");
            AppMethodBeat.o(148781);
        }
    }
}
