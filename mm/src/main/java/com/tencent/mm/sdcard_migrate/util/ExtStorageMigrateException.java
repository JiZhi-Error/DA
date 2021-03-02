package com.tencent.mm.sdcard_migrate.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ExtStorageMigrateException extends RemoteException implements Parcelable {
    public static final Parcelable.Creator<ExtStorageMigrateException> CREATOR = new Parcelable.Creator<ExtStorageMigrateException>() {
        /* class com.tencent.mm.sdcard_migrate.util.ExtStorageMigrateException.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ExtStorageMigrateException[] newArray(int i2) {
            return new ExtStorageMigrateException[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ExtStorageMigrateException createFromParcel(Parcel parcel) {
            AppMethodBeat.i(204693);
            ExtStorageMigrateException extStorageMigrateException = (ExtStorageMigrateException) parcel.readParcelable(ExtStorageMigrateException.class.getClassLoader());
            AppMethodBeat.o(204693);
            return extStorageMigrateException;
        }
    };

    public ExtStorageMigrateException(Throwable th) {
        AppMethodBeat.i(204694);
        initCause(th);
        AppMethodBeat.o(204694);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(204695);
        parcel.writeParcelable(this, i2);
        AppMethodBeat.o(204695);
    }

    static {
        AppMethodBeat.i(204696);
        AppMethodBeat.o(204696);
    }
}
