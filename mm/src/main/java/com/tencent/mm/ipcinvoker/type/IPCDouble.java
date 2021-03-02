package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCDouble implements Parcelable {
    public static final Parcelable.Creator<IPCDouble> CREATOR = new Parcelable.Creator<IPCDouble>() {
        /* class com.tencent.mm.ipcinvoker.type.IPCDouble.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ IPCDouble[] newArray(int i2) {
            return new IPCDouble[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IPCDouble createFromParcel(Parcel parcel) {
            AppMethodBeat.i(158851);
            IPCDouble iPCDouble = new IPCDouble();
            iPCDouble.value = parcel.readDouble();
            AppMethodBeat.o(158851);
            return iPCDouble;
        }
    };
    public double value;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(158852);
        parcel.writeDouble(this.value);
        AppMethodBeat.o(158852);
    }

    public String toString() {
        AppMethodBeat.i(158853);
        String d2 = Double.toString(this.value);
        AppMethodBeat.o(158853);
        return d2;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(158854);
        if (obj == this) {
            AppMethodBeat.o(158854);
            return true;
        } else if (obj instanceof IPCDouble) {
            if (this.value == ((IPCDouble) obj).value) {
                AppMethodBeat.o(158854);
                return true;
            }
            AppMethodBeat.o(158854);
            return false;
        } else if (obj instanceof Double) {
            boolean equals = obj.equals(Double.valueOf(this.value));
            AppMethodBeat.o(158854);
            return equals;
        } else {
            AppMethodBeat.o(158854);
            return false;
        }
    }

    static {
        AppMethodBeat.i(158855);
        AppMethodBeat.o(158855);
    }
}
