package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScanSettingsCompat implements Parcelable {
    public static final Parcelable.Creator<ScanSettingsCompat> CREATOR = new Parcelable.Creator<ScanSettingsCompat>() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanSettingsCompat.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ScanSettingsCompat[] newArray(int i2) {
            return new ScanSettingsCompat[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ScanSettingsCompat createFromParcel(Parcel parcel) {
            AppMethodBeat.i(144647);
            ScanSettingsCompat scanSettingsCompat = new ScanSettingsCompat(parcel, (byte) 0);
            AppMethodBeat.o(144647);
            return scanSettingsCompat;
        }
    };
    final int lOQ;
    private final int lOR;
    final long lOS;

    /* synthetic */ ScanSettingsCompat(int i2, long j2, byte b2) {
        this(i2, j2);
    }

    /* synthetic */ ScanSettingsCompat(Parcel parcel, byte b2) {
        this(parcel);
    }

    private ScanSettingsCompat(int i2, long j2) {
        this.lOQ = i2;
        this.lOR = 1;
        this.lOS = j2;
    }

    private ScanSettingsCompat(Parcel parcel) {
        AppMethodBeat.i(144650);
        this.lOQ = parcel.readInt();
        this.lOR = parcel.readInt();
        this.lOS = parcel.readLong();
        AppMethodBeat.o(144650);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(144651);
        parcel.writeInt(this.lOQ);
        parcel.writeInt(this.lOR);
        parcel.writeLong(this.lOS);
        AppMethodBeat.o(144651);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(144652);
        AppMethodBeat.o(144652);
    }

    public static final class a {
        private int lOQ = 0;
        private final int lOR = 1;
        private long lOS = 0;

        public final a wT(int i2) {
            AppMethodBeat.i(144648);
            if (i2 < 0 || i2 > 2) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("invalid scan mode ".concat(String.valueOf(i2)));
                AppMethodBeat.o(144648);
                throw illegalArgumentException;
            }
            this.lOQ = i2;
            AppMethodBeat.o(144648);
            return this;
        }

        public final ScanSettingsCompat bFy() {
            AppMethodBeat.i(144649);
            ScanSettingsCompat scanSettingsCompat = new ScanSettingsCompat(this.lOQ, this.lOS, (byte) 0);
            AppMethodBeat.o(144649);
            return scanSettingsCompat;
        }
    }
}
