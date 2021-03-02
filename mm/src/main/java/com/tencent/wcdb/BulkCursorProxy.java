package com.tencent.wcdb;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class BulkCursorProxy implements IBulkCursor {
    private Bundle mExtras = null;
    private IBinder mRemote;

    public BulkCursorProxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public final IBinder asBinder() {
        return this.mRemote;
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public final CursorWindow getWindow(int i2) {
        AppMethodBeat.i(2648);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IBulkCursor.descriptor);
            obtain.writeInt(i2);
            this.mRemote.transact(1, obtain, obtain2, 0);
            DatabaseUtils.readExceptionFromParcel(obtain2);
            CursorWindow cursorWindow = null;
            if (obtain2.readInt() == 1) {
                cursorWindow = CursorWindow.newFromParcel(obtain2);
            }
            return cursorWindow;
        } finally {
            obtain.recycle();
            obtain2.recycle();
            AppMethodBeat.o(2648);
        }
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public final void onMove(int i2) {
        AppMethodBeat.i(2649);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IBulkCursor.descriptor);
            obtain.writeInt(i2);
            this.mRemote.transact(4, obtain, obtain2, 0);
            DatabaseUtils.readExceptionFromParcel(obtain2);
        } finally {
            obtain.recycle();
            obtain2.recycle();
            AppMethodBeat.o(2649);
        }
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public final void deactivate() {
        AppMethodBeat.i(2650);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IBulkCursor.descriptor);
            this.mRemote.transact(2, obtain, obtain2, 0);
            DatabaseUtils.readExceptionFromParcel(obtain2);
        } finally {
            obtain.recycle();
            obtain2.recycle();
            AppMethodBeat.o(2650);
        }
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public final void close() {
        AppMethodBeat.i(2651);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IBulkCursor.descriptor);
            this.mRemote.transact(7, obtain, obtain2, 0);
            DatabaseUtils.readExceptionFromParcel(obtain2);
        } finally {
            obtain.recycle();
            obtain2.recycle();
            AppMethodBeat.o(2651);
        }
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public final int requery(IContentObserver iContentObserver) {
        int readInt;
        AppMethodBeat.i(2652);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IBulkCursor.descriptor);
            obtain.writeStrongInterface(iContentObserver);
            boolean transact = this.mRemote.transact(3, obtain, obtain2, 0);
            DatabaseUtils.readExceptionFromParcel(obtain2);
            if (!transact) {
                readInt = -1;
            } else {
                readInt = obtain2.readInt();
                this.mExtras = obtain2.readBundle(getClass().getClassLoader());
            }
            return readInt;
        } finally {
            obtain.recycle();
            obtain2.recycle();
            AppMethodBeat.o(2652);
        }
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public final Bundle getExtras() {
        AppMethodBeat.i(2653);
        if (this.mExtras == null) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IBulkCursor.descriptor);
                this.mRemote.transact(5, obtain, obtain2, 0);
                DatabaseUtils.readExceptionFromParcel(obtain2);
                this.mExtras = obtain2.readBundle(getClass().getClassLoader());
                obtain.recycle();
                obtain2.recycle();
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                AppMethodBeat.o(2653);
                throw th;
            }
        }
        Bundle bundle = this.mExtras;
        AppMethodBeat.o(2653);
        return bundle;
    }

    @Override // com.tencent.wcdb.IBulkCursor
    public final Bundle respond(Bundle bundle) {
        AppMethodBeat.i(2654);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IBulkCursor.descriptor);
            obtain.writeBundle(bundle);
            this.mRemote.transact(6, obtain, obtain2, 0);
            DatabaseUtils.readExceptionFromParcel(obtain2);
            return obtain2.readBundle(getClass().getClassLoader());
        } finally {
            obtain.recycle();
            obtain2.recycle();
            AppMethodBeat.o(2654);
        }
    }
}
