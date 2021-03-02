package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VideoCaptureReportInfo implements Parcelable {
    public static final Parcelable.Creator<VideoCaptureReportInfo> CREATOR = new Parcelable.Creator<VideoCaptureReportInfo>() {
        /* class com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ VideoCaptureReportInfo[] newArray(int i2) {
            return new VideoCaptureReportInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ VideoCaptureReportInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(101523);
            VideoCaptureReportInfo videoCaptureReportInfo = new VideoCaptureReportInfo(parcel);
            AppMethodBeat.o(101523);
            return videoCaptureReportInfo;
        }
    };
    public int rna = -1;
    public int sQn = -1;
    public long twG = -1;

    public VideoCaptureReportInfo() {
    }

    public VideoCaptureReportInfo(Parcel parcel) {
        AppMethodBeat.i(101524);
        this.sQn = parcel.readInt();
        this.rna = parcel.readInt();
        this.twG = parcel.readLong();
        AppMethodBeat.o(101524);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101525);
        parcel.writeInt(this.sQn);
        parcel.writeInt(this.rna);
        parcel.writeLong(this.twG);
        AppMethodBeat.o(101525);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(101526);
        AppMethodBeat.o(101526);
    }
}
