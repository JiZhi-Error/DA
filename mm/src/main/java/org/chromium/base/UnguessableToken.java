package org.chromium.base;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class UnguessableToken implements Parcelable {
    public static final Parcelable.Creator<UnguessableToken> CREATOR = new Parcelable.Creator<UnguessableToken>() {
        /* class org.chromium.base.UnguessableToken.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final UnguessableToken createFromParcel(Parcel parcel) {
            AppMethodBeat.i(53737);
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            if (readLong == 0 || readLong2 == 0) {
                AppMethodBeat.o(53737);
                return null;
            }
            UnguessableToken unguessableToken = new UnguessableToken(readLong, readLong2);
            AppMethodBeat.o(53737);
            return unguessableToken;
        }

        @Override // android.os.Parcelable.Creator
        public final UnguessableToken[] newArray(int i2) {
            return new UnguessableToken[i2];
        }
    };
    private final long mHigh;
    private final long mLow;

    private UnguessableToken(long j2, long j3) {
        this.mHigh = j2;
        this.mLow = j3;
    }

    private static UnguessableToken create(long j2, long j3) {
        AppMethodBeat.i(53746);
        UnguessableToken unguessableToken = new UnguessableToken(j2, j3);
        AppMethodBeat.o(53746);
        return unguessableToken;
    }

    public long getHighForSerialization() {
        return this.mHigh;
    }

    public long getLowForSerialization() {
        return this.mLow;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(53747);
        parcel.writeLong(this.mHigh);
        parcel.writeLong(this.mLow);
        AppMethodBeat.o(53747);
    }

    static {
        AppMethodBeat.i(53749);
        AppMethodBeat.o(53749);
    }

    private UnguessableToken parcelAndUnparcelForTesting() {
        AppMethodBeat.i(53748);
        Parcel obtain = Parcel.obtain();
        writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        UnguessableToken createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        AppMethodBeat.o(53748);
        return createFromParcel;
    }
}
