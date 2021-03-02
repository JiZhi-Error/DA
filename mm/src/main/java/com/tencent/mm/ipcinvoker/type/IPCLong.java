package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCLong implements Parcelable {
    public static final Parcelable.Creator<IPCLong> CREATOR = new Parcelable.Creator<IPCLong>() {
        /* class com.tencent.mm.ipcinvoker.type.IPCLong.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ IPCLong[] newArray(int i2) {
            return new IPCLong[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IPCLong createFromParcel(Parcel parcel) {
            AppMethodBeat.i(158866);
            IPCLong iPCLong = new IPCLong();
            iPCLong.value = parcel.readLong();
            AppMethodBeat.o(158866);
            return iPCLong;
        }
    };
    public long value;

    public IPCLong() {
    }

    public IPCLong(long j2) {
        this.value = j2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(158867);
        parcel.writeLong(this.value);
        AppMethodBeat.o(158867);
    }

    public String toString() {
        AppMethodBeat.i(158868);
        String l = Long.toString(this.value);
        AppMethodBeat.o(158868);
        return l;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(158869);
        if (obj == this) {
            AppMethodBeat.o(158869);
            return true;
        } else if (obj instanceof IPCLong) {
            if (this.value == ((IPCLong) obj).value) {
                AppMethodBeat.o(158869);
                return true;
            }
            AppMethodBeat.o(158869);
            return false;
        } else if (obj instanceof Long) {
            boolean equals = obj.equals(Long.valueOf(this.value));
            AppMethodBeat.o(158869);
            return equals;
        } else {
            AppMethodBeat.o(158869);
            return false;
        }
    }

    static {
        AppMethodBeat.i(158870);
        AppMethodBeat.o(158870);
    }
}
