package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCFloat implements Parcelable {
    public static final Parcelable.Creator<IPCFloat> CREATOR = new Parcelable.Creator<IPCFloat>() {
        /* class com.tencent.mm.ipcinvoker.type.IPCFloat.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ IPCFloat[] newArray(int i2) {
            return new IPCFloat[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IPCFloat createFromParcel(Parcel parcel) {
            AppMethodBeat.i(158856);
            IPCFloat iPCFloat = new IPCFloat();
            iPCFloat.value = parcel.readFloat();
            AppMethodBeat.o(158856);
            return iPCFloat;
        }
    };
    public float value;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(158857);
        parcel.writeFloat(this.value);
        AppMethodBeat.o(158857);
    }

    public String toString() {
        AppMethodBeat.i(158858);
        String f2 = Float.toString(this.value);
        AppMethodBeat.o(158858);
        return f2;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(158859);
        if (obj == this) {
            AppMethodBeat.o(158859);
            return true;
        } else if (obj instanceof IPCFloat) {
            if (this.value == ((IPCFloat) obj).value) {
                AppMethodBeat.o(158859);
                return true;
            }
            AppMethodBeat.o(158859);
            return false;
        } else if (obj instanceof Float) {
            boolean equals = obj.equals(Float.valueOf(this.value));
            AppMethodBeat.o(158859);
            return equals;
        } else {
            AppMethodBeat.o(158859);
            return false;
        }
    }

    static {
        AppMethodBeat.i(158860);
        AppMethodBeat.o(158860);
    }
}
