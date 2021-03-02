package com.tencent.mm.plugin.scanner.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.s;

public class ScanGoodsRequest extends BaseScanRequest implements Parcelable {
    public static final Parcelable.Creator<ScanGoodsRequest> CREATOR = new Parcelable.Creator<ScanGoodsRequest>() {
        /* class com.tencent.mm.plugin.scanner.api.ScanGoodsRequest.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ScanGoodsRequest[] newArray(int i2) {
            return new ScanGoodsRequest[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ScanGoodsRequest createFromParcel(Parcel parcel) {
            AppMethodBeat.i(224193);
            ScanGoodsRequest scanGoodsRequest = new ScanGoodsRequest(parcel);
            AppMethodBeat.o(224193);
            return scanGoodsRequest;
        }
    };
    public int CAM;
    public String CAN;
    public String CAO;
    public String CAP;
    public String CAQ;
    public boolean CAR = true;
    public boolean CAS = false;
    public String extInfo;
    public int kca = 0;
    public int mode;
    public int requestType;

    public ScanGoodsRequest() {
        this.CAE = true;
        this.CAF = true;
        this.CAG = true;
        this.CAH = true;
        this.CAI = true;
        this.CAR = true;
        this.CAS = false;
        this.CAM = 0;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanGoodsRequest(Parcel parcel) {
        super(parcel);
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(224194);
        this.mode = parcel.readInt();
        this.requestType = parcel.readInt();
        this.CAM = parcel.readInt();
        this.CAN = parcel.readString();
        this.CAO = parcel.readString();
        this.CAP = parcel.readString();
        this.CAQ = parcel.readString();
        this.kca = parcel.readInt();
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.CAR = z;
        this.CAS = parcel.readByte() == 0 ? false : z2;
        this.extInfo = parcel.readString();
        AppMethodBeat.o(224194);
    }

    public final boolean isValid() {
        AppMethodBeat.i(224195);
        if (!s.YS(this.CAN) || !s.YS(this.CAO) || !s.YS(this.CAP)) {
            AppMethodBeat.o(224195);
            return false;
        }
        AppMethodBeat.o(224195);
        return true;
    }

    @Override // com.tencent.mm.plugin.scanner.api.BaseScanRequest
    public void writeToParcel(Parcel parcel, int i2) {
        byte b2;
        byte b3 = 1;
        AppMethodBeat.i(224196);
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.mode);
        parcel.writeInt(this.requestType);
        parcel.writeInt(this.CAM);
        parcel.writeString(this.CAN);
        parcel.writeString(this.CAO);
        parcel.writeString(this.CAP);
        parcel.writeString(this.CAQ);
        parcel.writeInt(this.kca);
        if (this.CAR) {
            b2 = 1;
        } else {
            b2 = 0;
        }
        parcel.writeByte(b2);
        if (!this.CAS) {
            b3 = 0;
        }
        parcel.writeByte(b3);
        parcel.writeString(this.extInfo);
        AppMethodBeat.o(224196);
    }

    @Override // com.tencent.mm.plugin.scanner.api.BaseScanRequest
    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(224198);
        AppMethodBeat.o(224198);
    }

    public static ScanGoodsRequest eOU() {
        AppMethodBeat.i(224197);
        ScanGoodsRequest scanGoodsRequest = new ScanGoodsRequest();
        scanGoodsRequest.mode = 5;
        scanGoodsRequest.requestType = 1;
        scanGoodsRequest.CAE = true;
        scanGoodsRequest.CAF = true;
        scanGoodsRequest.CAG = true;
        scanGoodsRequest.CAH = true;
        scanGoodsRequest.CAI = true;
        scanGoodsRequest.CAR = false;
        scanGoodsRequest.CAS = true;
        scanGoodsRequest.kca = a.fromDPToPix(MMApplicationContext.getContext(), 514);
        AppMethodBeat.o(224197);
        return scanGoodsRequest;
    }
}
