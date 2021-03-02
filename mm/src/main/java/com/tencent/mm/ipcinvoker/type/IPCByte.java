package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCByte implements Parcelable {
    public static final Parcelable.Creator<IPCByte> CREATOR = new Parcelable.Creator<IPCByte>() {
        /* class com.tencent.mm.ipcinvoker.type.IPCByte.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ IPCByte[] newArray(int i2) {
            return new IPCByte[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IPCByte createFromParcel(Parcel parcel) {
            AppMethodBeat.i(158846);
            IPCByte iPCByte = new IPCByte();
            iPCByte.value = parcel.readByte();
            AppMethodBeat.o(158846);
            return iPCByte;
        }
    };
    public byte value;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(158847);
        parcel.writeByte(this.value);
        AppMethodBeat.o(158847);
    }

    public String toString() {
        AppMethodBeat.i(158848);
        String num = Integer.toString(this.value);
        AppMethodBeat.o(158848);
        return num;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(158849);
        if (obj == this) {
            AppMethodBeat.o(158849);
            return true;
        } else if (obj instanceof IPCByte) {
            if (this.value == ((IPCByte) obj).value) {
                AppMethodBeat.o(158849);
                return true;
            }
            AppMethodBeat.o(158849);
            return false;
        } else if (obj instanceof Byte) {
            boolean equals = obj.equals(Byte.valueOf(this.value));
            AppMethodBeat.o(158849);
            return equals;
        } else {
            AppMethodBeat.o(158849);
            return false;
        }
    }

    static {
        AppMethodBeat.i(158850);
        AppMethodBeat.o(158850);
    }
}
