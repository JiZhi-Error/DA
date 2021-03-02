package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.mt;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public class AppStartupPerformanceReportBundle implements Parcelable, m {
    public static final Parcelable.Creator<AppStartupPerformanceReportBundle> CREATOR = new Parcelable.Creator<AppStartupPerformanceReportBundle>() {
        /* class com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppStartupPerformanceReportBundle[] newArray(int i2) {
            return new AppStartupPerformanceReportBundle[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppStartupPerformanceReportBundle createFromParcel(Parcel parcel) {
            AppMethodBeat.i(47152);
            AppStartupPerformanceReportBundle appStartupPerformanceReportBundle = new AppStartupPerformanceReportBundle(parcel, (byte) 0);
            AppMethodBeat.o(47152);
            return appStartupPerformanceReportBundle;
        }
    };
    public final String kEY;
    public long mSA;
    public long mSB;
    public long mSC;
    public long mSD;
    public long mSE;
    public int mSF;
    public boolean mSG;
    public boolean mSH;
    public long mSe;
    public final List<mt> mSw;
    public final List<kv_14609> mSx;
    public long mSy;
    public long mSz;

    /* synthetic */ AppStartupPerformanceReportBundle(Parcel parcel, byte b2) {
        this(parcel);
    }

    public final boolean bNr() {
        AppMethodBeat.i(47153);
        if (this.mSx == null) {
            AppMethodBeat.o(47153);
            return false;
        }
        for (kv_14609 kv_14609 : this.mSx) {
            if (kv_14609 != null && kv_14609.bNr()) {
                AppMethodBeat.o(47153);
                return true;
            }
        }
        AppMethodBeat.o(47153);
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3 = 1;
        AppMethodBeat.i(47154);
        parcel.writeString(this.kEY);
        if (Util.isNullOrNil(this.mSw)) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(this.mSw.size());
            for (mt mtVar : this.mSw) {
                parcel.writeString(mtVar.abV());
            }
        }
        parcel.writeTypedList(this.mSx);
        parcel.writeByte((byte) (this.mSG ? 1 : 0));
        parcel.writeLong(this.mSe);
        parcel.writeLong(this.mSy);
        parcel.writeLong(this.mSz);
        parcel.writeLong(this.mSA);
        parcel.writeLong(this.mSB);
        parcel.writeLong(this.mSC);
        if (!this.mSH) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeLong(this.mSD);
        parcel.writeLong(this.mSE);
        parcel.writeInt(this.mSF);
        AppMethodBeat.o(47154);
    }

    AppStartupPerformanceReportBundle(String str) {
        AppMethodBeat.i(47155);
        this.kEY = str;
        this.mSw = new LinkedList();
        this.mSx = new LinkedList();
        AppMethodBeat.o(47155);
    }

    private AppStartupPerformanceReportBundle(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(47156);
        this.kEY = parcel.readString();
        this.mSw = new LinkedList();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            for (int i2 = 0; i2 < readInt; i2++) {
                this.mSw.add(new mt(parcel.readString()));
            }
        }
        this.mSx = parcel.createTypedArrayList(kv_14609.CREATOR);
        this.mSG = parcel.readByte() > 0;
        this.mSe = parcel.readLong();
        this.mSy = parcel.readLong();
        this.mSz = parcel.readLong();
        this.mSA = parcel.readLong();
        this.mSB = parcel.readLong();
        this.mSC = parcel.readLong();
        this.mSH = parcel.readByte() <= 0 ? false : z;
        this.mSD = parcel.readLong();
        this.mSE = parcel.readLong();
        this.mSF = parcel.readInt();
        AppMethodBeat.o(47156);
    }

    static {
        AppMethodBeat.i(47157);
        AppMethodBeat.o(47157);
    }
}
