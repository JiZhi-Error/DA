package com.tencent.mm.network.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface b extends IInterface {
    void a(int i2, int i3, String str, int i4, String str2, boolean z);

    void u(int i2, int i3, int i4, int i5);

    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
                    a(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
                    u(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* renamed from: com.tencent.mm.network.a.b$a$a  reason: collision with other inner class name */
        public static class C0485a implements b {
            public static b jGv;
            private IBinder mRemote;

            public C0485a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.network.a.b
            public final void a(int i2, int i3, String str, int i4, String str2, boolean z) {
                AppMethodBeat.i(132963);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeInt(i4);
                    obtain.writeString(str2);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.bkt() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132963);
                        return;
                    }
                    a.bkt().a(i2, i3, str, i4, str2, z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132963);
                }
            }

            @Override // com.tencent.mm.network.a.b
            public final void u(int i2, int i3, int i4, int i5) {
                AppMethodBeat.i(132964);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || a.bkt() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132964);
                        return;
                    }
                    a.bkt().u(i2, i3, i4, i5);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132964);
                }
            }
        }

        public static b bkt() {
            return C0485a.jGv;
        }
    }
}
