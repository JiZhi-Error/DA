package com.tencent.mm.plugin.appbrand.media.record.record_imp;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.record.b;
import com.tencent.mm.plugin.appbrand.media.record.f;

public class RecordParam implements Parcelable {
    public static final Parcelable.Creator<RecordParam> CREATOR = new Parcelable.Creator<RecordParam>() {
        /* class com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RecordParam[] newArray(int i2) {
            return new RecordParam[0];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RecordParam createFromParcel(Parcel parcel) {
            AppMethodBeat.i(146357);
            RecordParam recordParam = new RecordParam(parcel);
            AppMethodBeat.o(146357);
            return recordParam;
        }
    };
    public String appId = "";
    public int duration = 0;
    public String gLc;
    public String lEB;
    public int mFQ = 0;
    public int mFR = 0;
    public double mFS = 0.0d;
    public b neu = b.MIC;
    public f nev;
    public String processName = "";
    public int sampleRate = 0;
    public int scene = 0;

    public RecordParam() {
    }

    public int describeContents() {
        return 0;
    }

    public RecordParam(Parcel parcel) {
        AppMethodBeat.i(146358);
        this.duration = parcel.readInt();
        this.sampleRate = parcel.readInt();
        this.mFQ = parcel.readInt();
        this.mFR = parcel.readInt();
        this.lEB = parcel.readString();
        this.gLc = parcel.readString();
        this.scene = parcel.readInt();
        this.mFS = parcel.readDouble();
        this.processName = parcel.readString();
        this.appId = parcel.readString();
        this.neu = b.values()[parcel.readInt()];
        AppMethodBeat.o(146358);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(146359);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.mFQ);
        parcel.writeInt(this.mFR);
        parcel.writeString(this.lEB);
        parcel.writeString(this.gLc);
        parcel.writeInt(this.scene);
        parcel.writeDouble(this.mFS);
        parcel.writeString(this.processName);
        parcel.writeString(this.appId);
        parcel.writeInt(this.neu.ordinal());
        AppMethodBeat.o(146359);
    }

    static {
        AppMethodBeat.i(146360);
        AppMethodBeat.o(146360);
    }
}
