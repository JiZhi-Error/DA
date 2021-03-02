package com.tencent.mm.protocal;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bgt;
import com.tencent.mm.sdk.platformtools.Log;

public class GeneralControlWrapper implements Parcelable {
    public static final Parcelable.Creator<GeneralControlWrapper> CREATOR = new Parcelable.Creator<GeneralControlWrapper>() {
        /* class com.tencent.mm.protocal.GeneralControlWrapper.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GeneralControlWrapper[] newArray(int i2) {
            return new GeneralControlWrapper[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GeneralControlWrapper createFromParcel(Parcel parcel) {
            AppMethodBeat.i(152437);
            GeneralControlWrapper generalControlWrapper = new GeneralControlWrapper(parcel, (byte) 0);
            AppMethodBeat.o(152437);
            return generalControlWrapper;
        }
    };
    public static final GeneralControlWrapper Kzg = new GeneralControlWrapper(10);
    public static final GeneralControlWrapper Kzh = new GeneralControlWrapper(1);
    private static Boolean Kzj = null;
    public int Kzi;

    /* synthetic */ GeneralControlWrapper(Parcel parcel, byte b2) {
        this(parcel);
    }

    static {
        AppMethodBeat.i(152449);
        AppMethodBeat.o(152449);
    }

    public GeneralControlWrapper(bgt bgt) {
        AppMethodBeat.i(152438);
        if (bgt == null) {
            this.Kzi = 0;
        } else {
            this.Kzi = bgt.LQC;
        }
        Log.d("MicroMsg.GeneralControlWrapper", "edw <init>, ".concat(String.valueOf(this)));
        AppMethodBeat.o(152438);
    }

    public GeneralControlWrapper(int i2) {
        AppMethodBeat.i(152439);
        this.Kzi = i2;
        Log.d("MicroMsg.GeneralControlWrapper", "edw <init>, ".concat(String.valueOf(this)));
        AppMethodBeat.o(152439);
    }

    public final boolean gtB() {
        AppMethodBeat.i(223874);
        boolean z = (this.Kzi & 8192) != 0;
        Log.d("MicroMsg.GeneralControlWrapper", "allowOuterOpenUrl, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(223874);
        return z;
    }

    public final boolean gtC() {
        AppMethodBeat.i(152441);
        boolean z = (this.Kzi & 2) > 0;
        Log.d("MicroMsg.GeneralControlWrapper", "allowInnerOpenUrl, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(152441);
        return z;
    }

    public final boolean gtD() {
        AppMethodBeat.i(152442);
        boolean z = (this.Kzi & 64) > 0;
        Log.d("MicroMsg.GeneralControlWrapper", "allowScanQRCode, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(152442);
        return z;
    }

    public final boolean gtE() {
        AppMethodBeat.i(223875);
        boolean z = (this.Kzi & 512) > 0;
        Log.d("MicroMsg.GeneralControlWrapper", "allowUploadHosts, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(223875);
        return z;
    }

    public final boolean gtF() {
        AppMethodBeat.i(223876);
        boolean z = (this.Kzi & 1024) > 0;
        Log.d("MicroMsg.GeneralControlWrapper", "allowUploadHTML, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(223876);
        return z;
    }

    public final boolean gtG() {
        AppMethodBeat.i(152443);
        boolean z = (this.Kzi & 2048) > 0;
        Log.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(152443);
        return z;
    }

    public final boolean gtH() {
        AppMethodBeat.i(152444);
        boolean z = (this.Kzi & 16384) > 0;
        Log.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(152444);
        return z;
    }

    public final boolean gtI() {
        AppMethodBeat.i(152445);
        boolean z = (this.Kzi & 32768) > 0;
        Log.d("MicroMsg.GeneralControlWrapper", "allowFavImage, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(152445);
        return z;
    }

    public String toString() {
        AppMethodBeat.i(152446);
        String str = "[bitset=0x" + Integer.toHexString(this.Kzi) + "]";
        AppMethodBeat.o(152446);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(152447);
        parcel.writeInt(this.Kzi);
        AppMethodBeat.o(152447);
    }

    private GeneralControlWrapper(Parcel parcel) {
        AppMethodBeat.i(152448);
        this.Kzi = parcel.readInt();
        AppMethodBeat.o(152448);
    }
}
