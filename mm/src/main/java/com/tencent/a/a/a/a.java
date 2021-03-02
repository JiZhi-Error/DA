package com.tencent.a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface a extends IInterface {
    int a(b bVar);

    int a(String str, String str2, b bVar);

    byte[] b(String str, byte[] bArr);

    void c(String str, byte[] bArr);

    /* renamed from: com.tencent.a.a.a.a$a  reason: collision with other inner class name */
    public static abstract class AbstractBinderC0128a extends Binder implements a {
        public static a k(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.assistant.sdk.BaseService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0129a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.assistant.sdk.BaseService");
                    int a2 = a(parcel.readString(), parcel.readString(), b.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(a2);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.assistant.sdk.BaseService");
                    int a3 = a(b.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(a3);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.assistant.sdk.BaseService");
                    byte[] b2 = b(parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeByteArray(b2);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.assistant.sdk.BaseService");
                    c(parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.assistant.sdk.BaseService");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* renamed from: com.tencent.a.a.a.a$a$a  reason: collision with other inner class name */
        static class C0129a implements a {
            private IBinder mRemote;

            C0129a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.a.a.a.a
            public final int a(String str, String str2, b bVar) {
                AppMethodBeat.i(101835);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.assistant.sdk.BaseService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(101835);
                }
            }

            @Override // com.tencent.a.a.a.a
            public final int a(b bVar) {
                AppMethodBeat.i(101836);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.assistant.sdk.BaseService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(101836);
                }
            }

            @Override // com.tencent.a.a.a.a
            public final byte[] b(String str, byte[] bArr) {
                AppMethodBeat.i(101837);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.assistant.sdk.BaseService");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(101837);
                }
            }

            @Override // com.tencent.a.a.a.a
            public final void c(String str, byte[] bArr) {
                AppMethodBeat.i(101838);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.assistant.sdk.BaseService");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(101838);
                }
            }
        }
    }
}
