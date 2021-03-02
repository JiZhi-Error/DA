package com.tencent.mm.ipcinvoker.extension.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.a;
import com.tencent.mm.ipcinvoker.extension.c;

class WrapperParcelable implements Parcelable {
    public static final Parcelable.Creator<WrapperParcelable> CREATOR = new Parcelable.Creator<WrapperParcelable>() {
        /* class com.tencent.mm.ipcinvoker.extension.event.WrapperParcelable.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WrapperParcelable[] newArray(int i2) {
            return new WrapperParcelable[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WrapperParcelable createFromParcel(Parcel parcel) {
            AppMethodBeat.i(158817);
            WrapperParcelable wrapperParcelable = new WrapperParcelable((byte) 0);
            if (parcel.readInt() == 1) {
                wrapperParcelable.hnx = c.a(parcel.readString(), parcel);
            }
            AppMethodBeat.o(158817);
            return wrapperParcelable;
        }
    };
    Object hnx;

    /* synthetic */ WrapperParcelable(byte b2) {
        this();
    }

    private WrapperParcelable() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        a bq;
        AppMethodBeat.i(158818);
        if (this.hnx == null || (bq = c.bq(this.hnx)) == null) {
            parcel.writeInt(1);
            AppMethodBeat.o(158818);
            return;
        }
        parcel.writeInt(1);
        parcel.writeString(bq.getClass().getName());
        bq.a(this.hnx, parcel);
        AppMethodBeat.o(158818);
    }

    static {
        AppMethodBeat.i(158819);
        AppMethodBeat.o(158819);
    }
}
