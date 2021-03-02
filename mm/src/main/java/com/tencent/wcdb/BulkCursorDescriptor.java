package com.tencent.wcdb;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class BulkCursorDescriptor implements Parcelable {
    public static final Parcelable.Creator<BulkCursorDescriptor> CREATOR = new Parcelable.Creator<BulkCursorDescriptor>() {
        /* class com.tencent.wcdb.BulkCursorDescriptor.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final BulkCursorDescriptor createFromParcel(Parcel parcel) {
            AppMethodBeat.i(2641);
            BulkCursorDescriptor bulkCursorDescriptor = new BulkCursorDescriptor();
            bulkCursorDescriptor.readFromParcel(parcel);
            AppMethodBeat.o(2641);
            return bulkCursorDescriptor;
        }

        @Override // android.os.Parcelable.Creator
        public final BulkCursorDescriptor[] newArray(int i2) {
            return new BulkCursorDescriptor[i2];
        }
    };
    public String[] columnNames;
    public int count;
    public IBulkCursor cursor;
    public boolean wantsAllOnMoveCalls;
    public CursorWindow window;

    static {
        AppMethodBeat.i(2647);
        AppMethodBeat.o(2647);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(2644);
        parcel.writeStrongBinder(this.cursor.asBinder());
        parcel.writeStringArray(this.columnNames);
        parcel.writeInt(this.wantsAllOnMoveCalls ? 1 : 0);
        parcel.writeInt(this.count);
        if (this.window != null) {
            parcel.writeInt(1);
            this.window.writeToParcel(parcel, i2);
            AppMethodBeat.o(2644);
            return;
        }
        parcel.writeInt(0);
        AppMethodBeat.o(2644);
    }

    public final String[] readStringArray(Parcel parcel) {
        AppMethodBeat.i(2645);
        String[] strArr = null;
        int readInt = parcel.readInt();
        if (readInt >= 0) {
            strArr = new String[readInt];
            for (int i2 = 0; i2 < readInt; i2++) {
                strArr[i2] = parcel.readString();
            }
        }
        AppMethodBeat.o(2645);
        return strArr;
    }

    public final void readFromParcel(Parcel parcel) {
        AppMethodBeat.i(2646);
        this.cursor = BulkCursorNative.asInterface(parcel.readStrongBinder());
        this.columnNames = readStringArray(parcel);
        this.wantsAllOnMoveCalls = parcel.readInt() != 0;
        this.count = parcel.readInt();
        if (parcel.readInt() != 0) {
            this.window = CursorWindow.CREATOR.createFromParcel(parcel);
        }
        AppMethodBeat.o(2646);
    }
}
