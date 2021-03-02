package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public class FaceDetectReporter implements Parcelable {
    public static final Parcelable.Creator<FaceDetectReporter> CREATOR = new Parcelable.Creator<FaceDetectReporter>() {
        /* class com.tencent.mm.plugin.facedetect.model.FaceDetectReporter.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ FaceDetectReporter[] newArray(int i2) {
            return new FaceDetectReporter[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ FaceDetectReporter createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103752);
            FaceDetectReporter faceDetectReporter = new FaceDetectReporter(parcel);
            AppMethodBeat.o(103752);
            return faceDetectReporter;
        }
    };
    public static FaceDetectReporter sRy = new FaceDetectReporter();
    String appId = "";
    long sRA = -1;
    public long sRB = -1;
    int sRC = 0;
    boolean sRD = false;
    public boolean sRt = false;
    public FaceDetectReportInfo sRu = null;
    private int sRv = -1;
    public int sRw = 0;
    public int sRx = 0;
    long sRz = 0;
    public long sessionId = 0;

    static {
        AppMethodBeat.i(103767);
        AppMethodBeat.o(103767);
    }

    protected FaceDetectReporter(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(103753);
        this.sessionId = parcel.readLong();
        this.sRt = parcel.readByte() != 0;
        this.sRu = (FaceDetectReportInfo) parcel.readParcelable(FaceDetectReportInfo.class.getClassLoader());
        this.appId = parcel.readString();
        this.sRv = parcel.readInt();
        this.sRw = parcel.readInt();
        this.sRx = parcel.readInt();
        this.sRz = parcel.readLong();
        this.sRA = parcel.readLong();
        this.sRB = parcel.readLong();
        this.sRC = parcel.readInt();
        this.sRD = parcel.readByte() == 0 ? false : z;
        AppMethodBeat.o(103753);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3 = 1;
        AppMethodBeat.i(103754);
        parcel.writeLong(this.sessionId);
        parcel.writeByte((byte) (this.sRt ? 1 : 0));
        parcel.writeParcelable(this.sRu, i2);
        parcel.writeString(this.appId);
        parcel.writeInt(this.sRv);
        parcel.writeInt(this.sRw);
        parcel.writeInt(this.sRx);
        parcel.writeLong(this.sRz);
        parcel.writeLong(this.sRA);
        parcel.writeLong(this.sRB);
        parcel.writeInt(this.sRC);
        if (!this.sRD) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        AppMethodBeat.o(103754);
    }

    public int describeContents() {
        return 0;
    }

    public static FaceDetectReporter cTe() {
        FaceDetectReporter faceDetectReporter;
        AppMethodBeat.i(103755);
        if (sRy == null) {
            synchronized (FaceDetectReporter.class) {
                try {
                    if (sRy == null) {
                        sRy = new FaceDetectReporter();
                    }
                    faceDetectReporter = sRy;
                } finally {
                    AppMethodBeat.o(103755);
                }
            }
            return faceDetectReporter;
        }
        FaceDetectReporter faceDetectReporter2 = sRy;
        AppMethodBeat.o(103755);
        return faceDetectReporter2;
    }

    public static void h(long j2, int i2, int i3) {
        AppMethodBeat.i(103756);
        Log.i("MicroMsg.FaceDetectReporter", "hy: report video: bioId: %d, errType: %d, errCode: %d", Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3));
        h.INSTANCE.a(14121, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(103756);
    }

    private FaceDetectReporter() {
    }

    public final long cTf() {
        AppMethodBeat.i(103757);
        Log.v("MicroMsg.FaceDetectReporter", "create report session");
        if (this.sRu == null) {
            this.sRu = new FaceDetectReportInfo();
        }
        this.sRu.reset();
        this.sRt = false;
        this.sessionId = System.currentTimeMillis();
        this.sRu.sessionId = this.sessionId;
        long j2 = this.sessionId;
        AppMethodBeat.o(103757);
        return j2;
    }

    public static int HK(int i2) {
        switch (i2) {
            case 0:
            case 3:
                return 2;
            case 1:
            case 4:
                return 3;
            case 2:
                return 1;
            case 5:
                return 4;
            default:
                return -1;
        }
    }

    public final void dr(String str, int i2) {
        long j2 = -1;
        int i3 = 1;
        AppMethodBeat.i(103763);
        if (this.sRA == -1 || this.sRB == -1 || this.sRB < this.sRA) {
            Log.e("MicroMsg.FaceDetectReporter", "alvinluo not set calledStartTime:%d or calledEndTime: %d, total time is not valid", Long.valueOf(this.sRA), Long.valueOf(this.sRB));
        } else {
            j2 = this.sRB - this.sRA;
        }
        Log.i("MicroMsg.FaceDetectReporter", "alvinluo report face detect interface called result, sessionId: %d, functionName: %s, interfaceType: %d, businessType: %d, totalTime: %d, isSuccess: %b, appId: %s, faceDetectCount: %d", Long.valueOf(this.sRz), str, -1, Integer.valueOf(i2), Long.valueOf(j2), Boolean.valueOf(this.sRD), this.appId, Integer.valueOf(this.sRC));
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[8];
        objArr[0] = Long.valueOf(this.sRz);
        objArr[1] = str;
        objArr[2] = -1;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = this.appId;
        if (!this.sRD) {
            i3 = 0;
        }
        objArr[5] = Integer.valueOf(i3);
        objArr[6] = Long.valueOf(j2);
        objArr[7] = Integer.valueOf(this.sRC);
        hVar.a(14560, objArr);
        AppMethodBeat.o(103763);
    }

    public final void ac(int i2, long j2) {
        AppMethodBeat.i(103764);
        if (this.sRu != null) {
            this.sRu.dyP++;
            FaceDetectReportInfo faceDetectReportInfo = this.sRu;
            faceDetectReportInfo.sRp = (int) (((long) faceDetectReportInfo.sRp) + j2);
            this.sRu.HJ(i2);
        }
        AppMethodBeat.o(103764);
    }

    public final void ad(int i2, long j2) {
        AppMethodBeat.i(103765);
        if (this.sRu != null) {
            Log.i("MicroMsg.FaceDetectReporter", "hashCode :" + hashCode() + " startTime" + j2);
            this.sRu.sRr.put(Integer.valueOf(i2), Long.valueOf(j2));
        }
        AppMethodBeat.o(103765);
    }

    public final void ae(int i2, long j2) {
        AppMethodBeat.i(103766);
        if (this.sRu != null) {
            Log.i("MicroMsg.FaceDetectReporter", "hashCode :" + hashCode() + " endTime:" + j2);
            this.sRu.sRs.put(Integer.valueOf(i2), Long.valueOf(j2));
        }
        AppMethodBeat.o(103766);
    }

    public final void ad(int i2, int i3, int i4) {
        int i5;
        int i6;
        AppMethodBeat.i(186368);
        Log.v("MicroMsg.FaceDetectReporter", "reportFaceDetectVerifyResult sessionId: %d, hasReported: %b, businessType: %d, isRetry: %b, result: %d, errType: %d, errCode: %d", Long.valueOf(this.sessionId), Boolean.valueOf(this.sRt), Integer.valueOf(i2), Boolean.FALSE, 3, Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.sRu != null && !this.sRt) {
            Log.v("MicroMsg.FaceDetectReporter", "info: %s", this.sRu.toString());
            this.sRt = true;
            this.sRu.sPx = 0;
            if (this.sRu.dyP != 0) {
                this.sRu.sRq = this.sRu.sRp / this.sRu.dyP;
            }
            if (!this.sRu.sRr.containsKey(0) || !this.sRu.sRs.containsKey(0)) {
                i5 = 0;
            } else {
                int longValue = (int) (this.sRu.sRs.get(0).longValue() - this.sRu.sRr.get(0).longValue());
                Log.i("MicroMsg.FaceDetectReporter", "normalMotionTime : " + longValue + "  hashCode :" + hashCode());
                i5 = longValue;
            }
            if (!this.sRu.sRr.containsKey(4) || !this.sRu.sRs.containsKey(4)) {
                i6 = 0;
            } else {
                i6 = (int) (this.sRu.sRs.get(4).longValue() - this.sRu.sRr.get(4).longValue());
                Log.i("MicroMsg.FaceDetectReporter", "readNumberMotionTime : " + i6 + "  hashCode :" + hashCode());
            }
            if (this.sRu.sRr.containsKey(6) && this.sRu.sRs.containsKey(6)) {
                i6 = (int) (this.sRu.sRs.get(6).longValue() - this.sRu.sRr.get(6).longValue());
                Log.i("MicroMsg.FaceDetectReporter", "MOTION_REFLECTION : " + i6 + "  hashCode :" + hashCode());
            }
            Log.v("MicroMsg.FaceDetectReporter", "alvinluo normal motion time: %d ms, read number motion time: %d ms ,hashcode %d", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(hashCode()));
            h.INSTANCE.a(14006, Long.valueOf(this.sessionId), Integer.valueOf(i2), 0, 3, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(this.sRu.sRc), Integer.valueOf(this.sRu.sRd), Integer.valueOf(this.sRu.sRe), Integer.valueOf(this.sRu.sRb), Integer.valueOf(this.sRu.sRf), Integer.valueOf(this.sRu.sRg), Integer.valueOf(this.sRu.sRh), Integer.valueOf(this.sRu.sRi), Integer.valueOf(this.sRu.sRj), Integer.valueOf(this.sRu.sRk), Integer.valueOf(this.sRu.sRl), Integer.valueOf(this.sRu.sRm), Integer.valueOf(this.sRu.sRn), Integer.valueOf(this.sRu.sPx), Integer.valueOf(this.sRu.sRo), Integer.valueOf(this.sRu.unstableCount), Integer.valueOf(this.sRu.sRq), Integer.valueOf(i5), Integer.valueOf(i6), this.appId, Integer.valueOf(this.sRv), Integer.valueOf(this.sRw), Integer.valueOf(this.sRx));
        }
        AppMethodBeat.o(186368);
    }
}
