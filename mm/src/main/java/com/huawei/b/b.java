package com.huawei.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface b extends IInterface {
    void a(int i2, int i3, int i4, byte[] bArr);

    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "com.huawei.securitymgr.IAuthenticationClient");
        }

        public static b i(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.securitymgr.IAuthenticationClient");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new C0125a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationClient");
                    a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.huawei.securitymgr.IAuthenticationClient");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* renamed from: com.huawei.b.b$a$a  reason: collision with other inner class name */
        static class C0125a implements b {
            private IBinder mRemote;

            C0125a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.b.b
            public final void a(int i2, int i3, int i4, byte[] bArr) {
                AppMethodBeat.i(88779);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationClient");
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88779);
                }
            }
        }
    }
}
