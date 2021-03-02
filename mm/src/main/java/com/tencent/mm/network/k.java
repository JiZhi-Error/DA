package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.p;

public interface k extends IInterface {
    int bjC();

    void bjD();

    long bjE();

    boolean c(p pVar);

    boolean d(p pVar);

    public static abstract class a extends Binder implements k {
        public a() {
            attachInterface(this, "com.tencent.mm.network.INetworkEvent_AIDL");
        }

        public static k o(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.network.INetworkEvent_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof k)) {
                return new C0490a(iBinder);
            }
            return (k) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            int i4 = 0;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.network.INetworkEvent_AIDL");
                    int bjC = bjC();
                    parcel2.writeNoException();
                    parcel2.writeInt(bjC);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.network.INetworkEvent_AIDL");
                    boolean c2 = c(p.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (c2) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.network.INetworkEvent_AIDL");
                    boolean d2 = d(p.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (d2) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.network.INetworkEvent_AIDL");
                    bjD();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.network.INetworkEvent_AIDL");
                    long bjE = bjE();
                    parcel2.writeNoException();
                    parcel2.writeLong(bjE);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.network.INetworkEvent_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.network.k$a$a  reason: collision with other inner class name */
        public static class C0490a implements k {
            public static k jDU;
            private IBinder mRemote;

            C0490a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.network.k
            public final int bjC() {
                AppMethodBeat.i(132740);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.INetworkEvent_AIDL");
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && a.bjF() != null) {
                        return a.bjF().bjC();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132740);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132740);
                }
            }

            @Override // com.tencent.mm.network.k
            public final boolean c(p pVar) {
                boolean z = false;
                AppMethodBeat.i(132741);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.INetworkEvent_AIDL");
                    obtain.writeStrongBinder(pVar != null ? pVar.asBinder() : null);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || a.bjF() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132741);
                    } else {
                        z = a.bjF().c(pVar);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132741);
                }
            }

            @Override // com.tencent.mm.network.k
            public final boolean d(p pVar) {
                boolean z = false;
                AppMethodBeat.i(132742);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.INetworkEvent_AIDL");
                    obtain.writeStrongBinder(pVar != null ? pVar.asBinder() : null);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || a.bjF() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132742);
                    } else {
                        z = a.bjF().d(pVar);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132742);
                }
            }

            @Override // com.tencent.mm.network.k
            public final void bjD() {
                AppMethodBeat.i(132743);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.INetworkEvent_AIDL");
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || a.bjF() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132743);
                        return;
                    }
                    a.bjF().bjD();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132743);
                }
            }

            @Override // com.tencent.mm.network.k
            public final long bjE() {
                AppMethodBeat.i(132744);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.INetworkEvent_AIDL");
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && a.bjF() != null) {
                        return a.bjF().bjE();
                    }
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132744);
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132744);
                }
            }
        }

        public static k bjF() {
            return C0490a.jDU;
        }
    }
}
