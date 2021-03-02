package com.tencent.mm.ui.widget.cedit.util;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ParcelableParcel implements Parcelable {
    public static final Parcelable.ClassLoaderCreator<ParcelableParcel> CREATOR = new Parcelable.ClassLoaderCreator<ParcelableParcel>() {
        /* class com.tencent.mm.ui.widget.cedit.util.ParcelableParcel.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.ClassLoaderCreator
        public final /* synthetic */ ParcelableParcel createFromParcel(Parcel parcel, ClassLoader classLoader) {
            AppMethodBeat.i(206120);
            ParcelableParcel parcelableParcel = new ParcelableParcel(parcel, classLoader);
            AppMethodBeat.o(206120);
            return parcelableParcel;
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new ParcelableParcel[i2];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(206121);
            ParcelableParcel parcelableParcel = new ParcelableParcel(parcel, null);
            AppMethodBeat.o(206121);
            return parcelableParcel;
        }
    };
    public final Parcel aBu = Parcel.obtain();
    final ClassLoader mClassLoader;

    public ParcelableParcel(Parcel parcel, ClassLoader classLoader) {
        int i2;
        AppMethodBeat.i(206122);
        this.mClassLoader = classLoader;
        int readInt = parcel.readInt();
        if (readInt < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Negative size read from parcel");
            AppMethodBeat.o(206122);
            throw illegalArgumentException;
        }
        int dataPosition = parcel.dataPosition();
        if (readInt == 0) {
            i2 = dataPosition;
        } else if (readInt > 0 && dataPosition <= Integer.MAX_VALUE - readInt) {
            i2 = dataPosition + readInt;
        } else if (readInt >= 0 || dataPosition < Integer.MIN_VALUE - readInt) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Addition overflow: " + dataPosition + " + " + readInt);
            AppMethodBeat.o(206122);
            throw illegalArgumentException2;
        } else {
            i2 = dataPosition + readInt;
        }
        parcel.setDataPosition(i2);
        this.aBu.appendFrom(parcel, dataPosition, readInt);
        AppMethodBeat.o(206122);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(206123);
        parcel.writeInt(this.aBu.dataSize());
        parcel.appendFrom(this.aBu, 0, this.aBu.dataSize());
        AppMethodBeat.o(206123);
    }

    static {
        AppMethodBeat.i(206124);
        AppMethodBeat.o(206124);
    }
}
