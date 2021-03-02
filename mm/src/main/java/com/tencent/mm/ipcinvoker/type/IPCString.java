package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCString implements Parcelable {
    public static final Parcelable.Creator<IPCString> CREATOR = new Parcelable.Creator<IPCString>() {
        /* class com.tencent.mm.ipcinvoker.type.IPCString.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ IPCString[] newArray(int i2) {
            return new IPCString[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IPCString createFromParcel(Parcel parcel) {
            AppMethodBeat.i(158871);
            IPCString iPCString = new IPCString();
            iPCString.value = parcel.readString();
            AppMethodBeat.o(158871);
            return iPCString;
        }
    };
    public String value;

    public IPCString() {
    }

    public IPCString(String str) {
        this.value = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(158872);
        parcel.writeString(this.value);
        AppMethodBeat.o(158872);
    }

    public String toString() {
        return this.value;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(158873);
        if (obj == this) {
            AppMethodBeat.o(158873);
            return true;
        } else if (obj instanceof IPCString) {
            IPCString iPCString = (IPCString) obj;
            if (this.value == iPCString.value || (this.value != null && this.value.equals(iPCString.value))) {
                AppMethodBeat.o(158873);
                return true;
            }
            AppMethodBeat.o(158873);
            return false;
        } else if (obj instanceof String) {
            boolean equals = obj.equals(this.value);
            AppMethodBeat.o(158873);
            return equals;
        } else {
            AppMethodBeat.o(158873);
            return false;
        }
    }

    static {
        AppMethodBeat.i(158874);
        AppMethodBeat.o(158874);
    }
}
