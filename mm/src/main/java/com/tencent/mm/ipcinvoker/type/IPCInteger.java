package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCInteger implements Parcelable {
    public static final Parcelable.Creator<IPCInteger> CREATOR = new Parcelable.Creator<IPCInteger>() {
        /* class com.tencent.mm.ipcinvoker.type.IPCInteger.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ IPCInteger[] newArray(int i2) {
            return new IPCInteger[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IPCInteger createFromParcel(Parcel parcel) {
            AppMethodBeat.i(158861);
            IPCInteger iPCInteger = new IPCInteger();
            iPCInteger.value = parcel.readInt();
            AppMethodBeat.o(158861);
            return iPCInteger;
        }
    };
    public int value;

    public IPCInteger() {
    }

    public IPCInteger(int i2) {
        this.value = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(158862);
        parcel.writeInt(this.value);
        AppMethodBeat.o(158862);
    }

    public String toString() {
        AppMethodBeat.i(158863);
        String num = Integer.toString(this.value);
        AppMethodBeat.o(158863);
        return num;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(158864);
        if (obj == this) {
            AppMethodBeat.o(158864);
            return true;
        } else if (obj instanceof IPCInteger) {
            if (this.value == ((IPCInteger) obj).value) {
                AppMethodBeat.o(158864);
                return true;
            }
            AppMethodBeat.o(158864);
            return false;
        } else if (obj instanceof Integer) {
            boolean equals = obj.equals(Integer.valueOf(this.value));
            AppMethodBeat.o(158864);
            return equals;
        } else {
            AppMethodBeat.o(158864);
            return false;
        }
    }

    static {
        AppMethodBeat.i(158865);
        AppMethodBeat.o(158865);
    }
}
