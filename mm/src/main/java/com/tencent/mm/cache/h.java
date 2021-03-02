package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface h extends IInterface {
    MCacheItem CV(String str);

    void CW(String str);

    void b(String str, Bitmap bitmap);

    Bitmap getBitmap(String str);

    public static abstract class a extends Binder implements h {
        public a() {
            attachInterface(this, "com.tencent.mm.cache.IMMCache_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            Bitmap bitmap;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.cache.IMMCache_AIDL");
                    CV(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(0);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.cache.IMMCache_AIDL");
                    String readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        MCacheItem.CREATOR.createFromParcel(parcel);
                    }
                    CW(readString);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.cache.IMMCache_AIDL");
                    Bitmap bitmap2 = getBitmap(parcel.readString());
                    parcel2.writeNoException();
                    if (bitmap2 != null) {
                        parcel2.writeInt(1);
                        bitmap2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.cache.IMMCache_AIDL");
                    String readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bitmap = (Bitmap) Bitmap.CREATOR.createFromParcel(parcel);
                    } else {
                        bitmap = null;
                    }
                    b(readString2, bitmap);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.cache.IMMCache_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }
    }
}
