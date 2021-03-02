package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public class FaceDetectReportInfo implements Parcelable {
    public static final Parcelable.Creator<FaceDetectReportInfo> CREATOR = new Parcelable.Creator<FaceDetectReportInfo>() {
        /* class com.tencent.mm.plugin.facedetect.model.FaceDetectReportInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ FaceDetectReportInfo[] newArray(int i2) {
            return new FaceDetectReportInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ FaceDetectReportInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103745);
            FaceDetectReportInfo faceDetectReportInfo = new FaceDetectReportInfo(parcel);
            AppMethodBeat.o(103745);
            return faceDetectReportInfo;
        }
    };
    protected int dyP = 0;
    protected int sPx = 0;
    protected int sRb = 0;
    protected int sRc = 0;
    protected int sRd = 0;
    protected int sRe = 0;
    protected int sRf = 0;
    protected int sRg = 0;
    protected int sRh = 0;
    protected int sRi = 0;
    protected int sRj = 0;
    protected int sRk = 0;
    protected int sRl = 0;
    protected int sRm = 0;
    protected int sRn = 0;
    protected int sRo = 0;
    protected int sRp = 0;
    protected int sRq = 0;
    protected HashMap<Integer, Long> sRr = new HashMap<>();
    protected HashMap<Integer, Long> sRs = new HashMap<>();
    protected long sessionId = 0;
    protected int unstableCount = 0;

    public FaceDetectReportInfo() {
        AppMethodBeat.i(103746);
        AppMethodBeat.o(103746);
    }

    protected FaceDetectReportInfo(Parcel parcel) {
        AppMethodBeat.i(103747);
        this.sessionId = parcel.readLong();
        this.sRb = parcel.readInt();
        this.sRc = parcel.readInt();
        this.sRd = parcel.readInt();
        this.sRe = parcel.readInt();
        this.sRf = parcel.readInt();
        this.sRg = parcel.readInt();
        this.sRh = parcel.readInt();
        this.sRi = parcel.readInt();
        this.sRj = parcel.readInt();
        this.sRk = parcel.readInt();
        this.sRl = parcel.readInt();
        this.sRm = parcel.readInt();
        this.sRn = parcel.readInt();
        this.sRo = parcel.readInt();
        this.unstableCount = parcel.readInt();
        this.dyP = parcel.readInt();
        this.sPx = parcel.readInt();
        this.sRp = parcel.readInt();
        this.sRq = parcel.readInt();
        try {
            this.sRr = parcel.readHashMap(HashMap.class.getClassLoader());
            this.sRs = parcel.readHashMap(HashMap.class.getClassLoader());
            AppMethodBeat.o(103747);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FaceDetectReportInfo", e2, "", new Object[0]);
            AppMethodBeat.o(103747);
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(103748);
        parcel.writeLong(this.sessionId);
        parcel.writeInt(this.sRb);
        parcel.writeInt(this.sRc);
        parcel.writeInt(this.sRd);
        parcel.writeInt(this.sRe);
        parcel.writeInt(this.sRf);
        parcel.writeInt(this.sRg);
        parcel.writeInt(this.sRh);
        parcel.writeInt(this.sRi);
        parcel.writeInt(this.sRj);
        parcel.writeInt(this.sRk);
        parcel.writeInt(this.sRl);
        parcel.writeInt(this.sRm);
        parcel.writeInt(this.sRn);
        parcel.writeInt(this.sRo);
        parcel.writeInt(this.unstableCount);
        parcel.writeInt(this.dyP);
        parcel.writeInt(this.sPx);
        parcel.writeInt(this.sRp);
        parcel.writeInt(this.sRq);
        parcel.writeMap(this.sRr);
        parcel.writeMap(this.sRs);
        AppMethodBeat.o(103748);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(103751);
        AppMethodBeat.o(103751);
    }

    public final void HJ(int i2) {
        if (i2 > 0) {
            if (i2 == 1) {
                this.sRc++;
            } else if (i2 == 2) {
                this.sRd++;
            } else {
                this.sRc++;
            }
        } else if (i2 == 0) {
            this.sRe++;
        } else if (i2 == -11) {
            this.sRg++;
        } else if (i2 == -12) {
            this.sRh++;
        } else if (i2 == -13) {
            this.sRi++;
        } else if (i2 == -101) {
            this.sRm++;
        } else if (i2 == -102) {
            this.sRj++;
        } else if (i2 == -103) {
            this.sRk++;
        } else if (i2 == -105) {
            this.sRl++;
        } else if (i2 == -106) {
            this.sRf++;
        } else if (i2 == -107) {
            this.sRn++;
        } else if (i2 == -108) {
            this.sRo++;
        } else if (i2 == -109) {
            this.unstableCount++;
        } else {
            this.sRb++;
        }
    }

    public final void reset() {
        AppMethodBeat.i(103749);
        this.sessionId = 0;
        this.sRc = 0;
        this.sRd = 0;
        this.sRe = 0;
        this.sRb = 0;
        this.sRf = 0;
        this.sRg = 0;
        this.sRh = 0;
        this.sRi = 0;
        this.sRj = 0;
        this.sRk = 0;
        this.sRl = 0;
        this.sRm = 0;
        this.sRn = 0;
        this.dyP = 0;
        this.sPx = 0;
        this.sRp = 0;
        this.sRq = 0;
        this.sRr.clear();
        this.sRs.clear();
        AppMethodBeat.o(103749);
    }

    public String toString() {
        AppMethodBeat.i(103750);
        String str = "detectOk: " + this.sRc + ", motionOk: " + this.sRd + ", noFace: " + this.sRe + ", systemErr: " + this.sRb + ", noLiveFace: " + this.sRf + ", tooDark: " + this.sRg + ", tooLight: " + this.sRh + ", backLight: " + this.sRi + ", tooSmall: " + this.sRj + ", tooBig: " + this.sRk + ", tooActive: " + this.sRl + ", poseNotValid: " + this.sRm + ", timeOut: " + this.sRn + ", totalFrame: " + this.dyP + ", verifyTime: " + this.sPx + ", processTimePerFrame: " + this.sRq;
        AppMethodBeat.o(103750);
        return str;
    }
}
