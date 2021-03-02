package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class KVReportDataInfo implements Parcelable {
    public static final Parcelable.Creator<KVReportDataInfo> CREATOR = new Parcelable.Creator<KVReportDataInfo>() {
        /* class com.tencent.mm.plugin.report.service.KVReportDataInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ KVReportDataInfo[] newArray(int i2) {
            return new KVReportDataInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ KVReportDataInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(143842);
            KVReportDataInfo kVReportDataInfo = new KVReportDataInfo(parcel);
            AppMethodBeat.o(143842);
            return kVReportDataInfo;
        }
    };
    public boolean CxY;
    public boolean Cyr;
    public boolean Cys;
    public long dDw = 0;
    public long dQR;
    public String value;

    public KVReportDataInfo() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        int i4;
        int i5 = 1;
        AppMethodBeat.i(143843);
        parcel.writeLong(this.dQR);
        parcel.writeLong(this.dDw);
        parcel.writeString(this.value);
        if (this.Cyr) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeInt(i3);
        if (this.CxY) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        parcel.writeInt(i4);
        if (!this.Cys) {
            i5 = 0;
        }
        parcel.writeInt(i5);
        AppMethodBeat.o(143843);
    }

    protected KVReportDataInfo(Parcel parcel) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(143844);
        this.dQR = parcel.readLong();
        this.dDw = parcel.readLong();
        this.value = parcel.readString();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.Cyr = z;
        if (parcel.readInt() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.CxY = z2;
        this.Cys = parcel.readInt() != 1 ? false : z3;
        AppMethodBeat.o(143844);
    }

    static {
        AppMethodBeat.i(143845);
        AppMethodBeat.o(143845);
    }
}
