package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCBoolean implements Parcelable {
    public static final Parcelable.Creator<IPCBoolean> CREATOR = new Parcelable.Creator<IPCBoolean>() {
        /* class com.tencent.mm.ipcinvoker.type.IPCBoolean.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ IPCBoolean[] newArray(int i2) {
            return new IPCBoolean[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IPCBoolean createFromParcel(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(158841);
            IPCBoolean iPCBoolean = new IPCBoolean();
            if (parcel.readInt() != 1) {
                z = false;
            }
            iPCBoolean.value = z;
            AppMethodBeat.o(158841);
            return iPCBoolean;
        }
    };
    public boolean value;

    public IPCBoolean() {
    }

    public IPCBoolean(boolean z) {
        this.value = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(158842);
        parcel.writeInt(this.value ? 1 : 0);
        AppMethodBeat.o(158842);
    }

    public String toString() {
        AppMethodBeat.i(158843);
        String bool = Boolean.toString(this.value);
        AppMethodBeat.o(158843);
        return bool;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(158844);
        if (obj == this) {
            AppMethodBeat.o(158844);
            return true;
        } else if (obj instanceof IPCBoolean) {
            if (this.value == ((IPCBoolean) obj).value) {
                AppMethodBeat.o(158844);
                return true;
            }
            AppMethodBeat.o(158844);
            return false;
        } else if (obj instanceof Boolean) {
            boolean equals = obj.equals(Boolean.valueOf(this.value));
            AppMethodBeat.o(158844);
            return equals;
        } else {
            AppMethodBeat.o(158844);
            return false;
        }
    }

    static {
        AppMethodBeat.i(158845);
        AppMethodBeat.o(158845);
    }
}
