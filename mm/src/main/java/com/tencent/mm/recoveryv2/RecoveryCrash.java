package com.tencent.mm.recoveryv2;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.recoveryv2.g;

public final class RecoveryCrash {
    public c NBA;
    public long NBx;
    public String NBy;
    g NBz;
    final Context mContext;

    public static RecoveryCrash iI(Context context) {
        AppMethodBeat.i(193769);
        RecoveryCrash recoveryCrash = new RecoveryCrash(context);
        recoveryCrash.guA();
        recoveryCrash.guB();
        AppMethodBeat.o(193769);
        return recoveryCrash;
    }

    public static RecoveryCrash iJ(Context context) {
        AppMethodBeat.i(193770);
        RecoveryCrash recoveryCrash = new RecoveryCrash(context);
        recoveryCrash.guA();
        AppMethodBeat.o(193770);
        return recoveryCrash;
    }

    private RecoveryCrash(Context context) {
        AppMethodBeat.i(193771);
        this.mContext = context;
        this.NBz = new g.a(context, "recovery_crash");
        AppMethodBeat.o(193771);
    }

    RecoveryCrash(Context context, long j2, String str, g gVar, c cVar) {
        this.mContext = context;
        this.NBx = j2;
        this.NBy = str;
        this.NBz = gVar;
        this.NBA = cVar;
    }

    private void guA() {
        AppMethodBeat.i(193772);
        this.NBA = c.iK(this.mContext);
        AppMethodBeat.o(193772);
    }

    public final void guB() {
        AppMethodBeat.i(193773);
        this.NBz.guE();
        if (this.NBy != null) {
            AppMethodBeat.o(193773);
            return;
        }
        this.NBy = this.NBz.getString("crash_version", null);
        this.NBx = Math.max(this.NBz.getLong("crash_time", 0), 0L);
        AppMethodBeat.o(193773);
    }

    public final RecoveryCrash ajr(int i2) {
        this.NBA.NBC = i2;
        return this;
    }

    public final RecoveryCrash guC() {
        this.NBA.NBC = 0;
        this.NBx = 0;
        this.NBy = null;
        return this;
    }

    public final void save() {
        AppMethodBeat.i(193774);
        this.NBA.save();
        this.NBz.mK("crash_version", this.NBy).bT("crash_time", this.NBx).guF();
        AppMethodBeat.o(193774);
    }

    public final Record guD() {
        AppMethodBeat.i(193775);
        guB();
        Record record = new Record();
        record.crashCount = this.NBA.NBC;
        record.LKH = this.NBx;
        record.NBB = this.NBy;
        AppMethodBeat.o(193775);
        return record;
    }

    public static class Record implements Parcelable {
        public static final Parcelable.Creator<Record> CREATOR = new Parcelable.Creator<Record>() {
            /* class com.tencent.mm.recoveryv2.RecoveryCrash.Record.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Record[] newArray(int i2) {
                return new Record[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Record createFromParcel(Parcel parcel) {
                AppMethodBeat.i(193765);
                Record record = new Record(parcel);
                AppMethodBeat.o(193765);
                return record;
            }
        };
        public long LKH;
        public String NBB;
        public int crashCount;

        Record() {
        }

        protected Record(Parcel parcel) {
            AppMethodBeat.i(193766);
            this.crashCount = parcel.readInt();
            this.LKH = parcel.readLong();
            this.NBB = parcel.readString();
            AppMethodBeat.o(193766);
        }

        static {
            AppMethodBeat.i(193768);
            AppMethodBeat.o(193768);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(193767);
            parcel.writeInt(this.crashCount);
            parcel.writeLong(this.LKH);
            parcel.writeString(this.NBB);
            AppMethodBeat.o(193767);
        }
    }
}
