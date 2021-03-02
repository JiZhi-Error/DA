package com.tencent.tinker.lib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface a extends IInterface {

    /* renamed from: com.tencent.tinker.lib.a$a  reason: collision with other inner class name */
    public static abstract class AbstractBinderC2214a extends Binder implements a {
        public AbstractBinderC2214a() {
            attachInterface(this, "com.tencent.tinker.lib.IForeService");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.tinker.lib.IForeService");
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.tinker.lib.IForeService");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }
    }
}
