package com.tencent.wcdb;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.wcdb.IContentObserver;

public abstract class BulkCursorNative extends Binder implements IBulkCursor {
    public BulkCursorNative() {
        attachInterface(this, IBulkCursor.descriptor);
    }

    public static IBulkCursor asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IBulkCursor iBulkCursor = (IBulkCursor) iBinder.queryLocalInterface(IBulkCursor.descriptor);
        return iBulkCursor == null ? new BulkCursorProxy(iBinder) : iBulkCursor;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
        switch (i2) {
            case 1:
                try {
                    parcel.enforceInterface(IBulkCursor.descriptor);
                    CursorWindow window = getWindow(parcel.readInt());
                    parcel2.writeNoException();
                    if (window == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    window.writeToParcel(parcel2, 1);
                    return true;
                } catch (Exception e2) {
                    DatabaseUtils.writeExceptionToParcel(parcel2, e2);
                    return true;
                }
            case 2:
                parcel.enforceInterface(IBulkCursor.descriptor);
                deactivate();
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface(IBulkCursor.descriptor);
                int requery = requery(IContentObserver.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(requery);
                parcel2.writeBundle(getExtras());
                return true;
            case 4:
                parcel.enforceInterface(IBulkCursor.descriptor);
                onMove(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface(IBulkCursor.descriptor);
                Bundle extras = getExtras();
                parcel2.writeNoException();
                parcel2.writeBundle(extras);
                return true;
            case 6:
                parcel.enforceInterface(IBulkCursor.descriptor);
                Bundle respond = respond(parcel.readBundle(getClass().getClassLoader()));
                parcel2.writeNoException();
                parcel2.writeBundle(respond);
                return true;
            case 7:
                parcel.enforceInterface(IBulkCursor.descriptor);
                close();
                parcel2.writeNoException();
                return true;
            default:
                return super.onTransact(i2, parcel, parcel2, i3);
        }
    }

    public IBinder asBinder() {
        return this;
    }
}
