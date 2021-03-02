package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.o;

public class XParcelableWrapper implements Parcelable {
    public static final Parcelable.Creator<XParcelableWrapper> CREATOR = new Parcelable.Creator<XParcelableWrapper>() {
        /* class com.tencent.mm.ipcinvoker.extension.XParcelableWrapper.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ XParcelableWrapper[] newArray(int i2) {
            return new XParcelableWrapper[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ XParcelableWrapper createFromParcel(Parcel parcel) {
            AppMethodBeat.i(158814);
            XParcelableWrapper xParcelableWrapper = new XParcelableWrapper((byte) 0);
            if (parcel.readInt() == 1) {
                String readString = parcel.readString();
                if (xParcelableWrapper.hnB == null) {
                    xParcelableWrapper.hnB = (f) o.c(readString, f.class);
                }
                if (xParcelableWrapper.hnB != null) {
                    xParcelableWrapper.hnB.readFromParcel(parcel);
                }
            }
            AppMethodBeat.o(158814);
            return xParcelableWrapper;
        }
    };
    public f hnB;

    /* synthetic */ XParcelableWrapper(byte b2) {
        this();
    }

    private XParcelableWrapper() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(158815);
        if (this.hnB != null) {
            parcel.writeInt(1);
            parcel.writeString(this.hnB.getClass().getName());
            this.hnB.e(parcel);
            AppMethodBeat.o(158815);
            return;
        }
        parcel.writeInt(0);
        AppMethodBeat.o(158815);
    }

    static {
        AppMethodBeat.i(158816);
        AppMethodBeat.o(158816);
    }
}
