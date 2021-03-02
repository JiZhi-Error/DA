package com.tencent.mm.plugin.rubbishbin;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface a extends IInterface {
    void F(int i2, int i3, String str);

    /* renamed from: com.tencent.mm.plugin.rubbishbin.a$a  reason: collision with other inner class name */
    public static abstract class AbstractBinderC1662a extends Binder implements a {
        public AbstractBinderC1662a() {
            attachInterface(this, "com.tencent.mm.plugin.rubbishbin.IRubbishBinInterface");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.rubbishbin.IRubbishBinInterface");
                    F(parcel.readInt(), parcel.readInt(), parcel.readString());
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.rubbishbin.IRubbishBinInterface");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }
    }
}
