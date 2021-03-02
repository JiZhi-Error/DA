package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.i;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.k;
import com.tencent.mm.plugin.exdevice.service.n;
import com.tencent.mm.plugin.exdevice.service.p;
import com.tencent.mm.plugin.exdevice.service.q;
import com.tencent.mm.plugin.exdevice.service.s;
import com.tencent.mm.plugin.exdevice.service.t;

public interface h extends IInterface {
    boolean De(long j2);

    boolean Df(long j2);

    boolean Dg(long j2);

    boolean Dh(long j2);

    long a(p pVar);

    void a(n nVar);

    boolean a(long j2, int i2, k kVar);

    boolean a(i iVar);

    boolean a(s sVar);

    boolean a(String str, boolean z, q qVar);

    boolean b(int i2, j jVar);

    boolean b(long j2, int i2, k kVar);

    boolean b(long j2, byte[] bArr, t tVar);

    boolean b(i iVar);

    boolean c(int i2, j jVar);

    long[] cLa();

    boolean d(int i2, j jVar);

    boolean e(int i2, j jVar);

    void setChannelSessionKey(long j2, byte[] bArr);

    public static abstract class a extends Binder implements h {
        public a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        }

        public static h w(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof h)) {
                return new C0987a(iBinder);
            }
            return (h) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            t tVar = null;
            n aVar = null;
            q aVar2 = null;
            s aVar3 = null;
            int i4 = 0;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    boolean b2 = b(parcel.readInt(), j.a.y(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(b2 ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    boolean c2 = c(parcel.readInt(), j.a.y(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (c2) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    long[] cLa = cLa();
                    parcel2.writeNoException();
                    parcel2.writeLongArray(cLa);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    boolean a2 = a(parcel.readLong(), parcel.readInt(), k.a.z(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (a2) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    boolean De = De(parcel.readLong());
                    parcel2.writeNoException();
                    if (De) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    boolean Df = Df(parcel.readLong());
                    parcel2.writeNoException();
                    if (Df) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    long a3 = a(p.a.C(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeLong(a3);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    boolean Dg = Dg(parcel.readLong());
                    parcel2.writeNoException();
                    if (Dg) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    boolean a4 = a(i.a.x(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (a4) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    boolean b3 = b(i.a.x(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (b3) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceInvoker_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof n)) {
                            aVar = new n.a.C0992a(readStrongBinder);
                        } else {
                            aVar = (n) queryLocalInterface;
                        }
                    }
                    a(aVar);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    setChannelSessionKey(parcel.readLong(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    String readString = parcel.readString();
                    boolean z = parcel.readInt() != 0;
                    IBinder readStrongBinder2 = parcel.readStrongBinder();
                    if (readStrongBinder2 != null) {
                        IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IIBeaconCallback_AIDL");
                        if (queryLocalInterface2 == null || !(queryLocalInterface2 instanceof q)) {
                            aVar2 = new q.a.C0995a(readStrongBinder2);
                        } else {
                            aVar2 = (q) queryLocalInterface2;
                        }
                    }
                    boolean a5 = a(readString, z, aVar2);
                    parcel2.writeNoException();
                    if (a5) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 14:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    boolean d2 = d(parcel.readInt(), j.a.y(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (d2) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 15:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    boolean e2 = e(parcel.readInt(), j.a.y(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (e2) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 16:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    boolean b4 = b(parcel.readLong(), parcel.readInt(), k.a.z(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (b4) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 17:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    boolean Dh = Dh(parcel.readLong());
                    parcel2.writeNoException();
                    if (Dh) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 18:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    IBinder readStrongBinder3 = parcel.readStrongBinder();
                    if (readStrongBinder3 != null) {
                        IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnRecv_AIDL");
                        if (queryLocalInterface3 == null || !(queryLocalInterface3 instanceof s)) {
                            aVar3 = new s.a.C0996a(readStrongBinder3);
                        } else {
                            aVar3 = (s) queryLocalInterface3;
                        }
                    }
                    boolean a6 = a(aVar3);
                    parcel2.writeNoException();
                    if (a6) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 19:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    long readLong = parcel.readLong();
                    byte[] createByteArray = parcel.createByteArray();
                    IBinder readStrongBinder4 = parcel.readStrongBinder();
                    if (readStrongBinder4 != null) {
                        IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnSendEnd_AIDL");
                        if (queryLocalInterface4 == null || !(queryLocalInterface4 instanceof t)) {
                            tVar = new t.a.C0997a(readStrongBinder4);
                        } else {
                            tVar = (t) queryLocalInterface4;
                        }
                    }
                    boolean b5 = b(readLong, createByteArray, tVar);
                    parcel2.writeNoException();
                    if (b5) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.exdevice.service.h$a$a  reason: collision with other inner class name */
        public static class C0987a implements h {
            public static h rDH;
            private IBinder mRemote;

            C0987a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.exdevice.service.h
            public final boolean b(int i2, j jVar) {
                boolean z = true;
                AppMethodBeat.i(23660);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.cLe() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() == 0) {
                            z = false;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23660);
                    } else {
                        z = a.cLe().b(i2, jVar);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23660);
                }
            }

            @Override // com.tencent.mm.plugin.exdevice.service.h
            public final boolean c(int i2, j jVar) {
                boolean z = false;
                AppMethodBeat.i(23661);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || a.cLe() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23661);
                    } else {
                        z = a.cLe().c(i2, jVar);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23661);
                }
            }

            @Override // com.tencent.mm.plugin.exdevice.service.h
            public final long[] cLa() {
                AppMethodBeat.i(23662);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && a.cLe() != null) {
                        return a.cLe().cLa();
                    }
                    obtain2.readException();
                    long[] createLongArray = obtain2.createLongArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23662);
                    return createLongArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23662);
                }
            }

            @Override // com.tencent.mm.plugin.exdevice.service.h
            public final boolean a(long j2, int i2, k kVar) {
                boolean z = false;
                AppMethodBeat.i(23663);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeLong(j2);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(kVar != null ? kVar.asBinder() : null);
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || a.cLe() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23663);
                    } else {
                        z = a.cLe().a(j2, i2, kVar);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23663);
                }
            }

            @Override // com.tencent.mm.plugin.exdevice.service.h
            public final boolean De(long j2) {
                boolean z = false;
                AppMethodBeat.i(23664);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeLong(j2);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || a.cLe() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23664);
                    } else {
                        z = a.cLe().De(j2);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23664);
                }
            }

            @Override // com.tencent.mm.plugin.exdevice.service.h
            public final boolean Df(long j2) {
                boolean z = false;
                AppMethodBeat.i(23665);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeLong(j2);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || a.cLe() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23665);
                    } else {
                        z = a.cLe().Df(j2);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23665);
                }
            }

            @Override // com.tencent.mm.plugin.exdevice.service.h
            public final long a(p pVar) {
                AppMethodBeat.i(23666);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeStrongBinder(pVar != null ? pVar.asBinder() : null);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && a.cLe() != null) {
                        return a.cLe().a(pVar);
                    }
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23666);
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23666);
                }
            }

            @Override // com.tencent.mm.plugin.exdevice.service.h
            public final boolean Dg(long j2) {
                boolean z = false;
                AppMethodBeat.i(23667);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeLong(j2);
                    if (this.mRemote.transact(8, obtain, obtain2, 0) || a.cLe() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23667);
                    } else {
                        z = a.cLe().Dg(j2);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23667);
                }
            }

            @Override // com.tencent.mm.plugin.exdevice.service.h
            public final boolean a(i iVar) {
                boolean z = false;
                AppMethodBeat.i(23668);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeStrongBinder(iVar != null ? iVar.asBinder() : null);
                    if (this.mRemote.transact(9, obtain, obtain2, 0) || a.cLe() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23668);
                    } else {
                        z = a.cLe().a(iVar);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23668);
                }
            }

            @Override // com.tencent.mm.plugin.exdevice.service.h
            public final boolean b(i iVar) {
                boolean z = false;
                AppMethodBeat.i(23669);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeStrongBinder(iVar != null ? iVar.asBinder() : null);
                    if (this.mRemote.transact(10, obtain, obtain2, 0) || a.cLe() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23669);
                    } else {
                        z = a.cLe().b(iVar);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23669);
                }
            }

            @Override // com.tencent.mm.plugin.exdevice.service.h
            public final void a(n nVar) {
                AppMethodBeat.i(23670);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeStrongBinder(nVar != null ? nVar.asBinder() : null);
                    if (this.mRemote.transact(11, obtain, obtain2, 0) || a.cLe() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23670);
                        return;
                    }
                    a.cLe().a(nVar);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23670);
                }
            }

            @Override // com.tencent.mm.plugin.exdevice.service.h
            public final void setChannelSessionKey(long j2, byte[] bArr) {
                AppMethodBeat.i(23671);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeLong(j2);
                    obtain.writeByteArray(bArr);
                    if (this.mRemote.transact(12, obtain, obtain2, 0) || a.cLe() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23671);
                        return;
                    }
                    a.cLe().setChannelSessionKey(j2, bArr);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23671);
                }
            }

            @Override // com.tencent.mm.plugin.exdevice.service.h
            public final boolean a(String str, boolean z, q qVar) {
                boolean z2 = true;
                AppMethodBeat.i(23672);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeStrongBinder(qVar != null ? qVar.asBinder() : null);
                    if (this.mRemote.transact(13, obtain, obtain2, 0) || a.cLe() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() == 0) {
                            z2 = false;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23672);
                    } else {
                        z2 = a.cLe().a(str, z, qVar);
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23672);
                }
            }

            @Override // com.tencent.mm.plugin.exdevice.service.h
            public final boolean d(int i2, j jVar) {
                boolean z = false;
                AppMethodBeat.i(23673);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    if (this.mRemote.transact(14, obtain, obtain2, 0) || a.cLe() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23673);
                    } else {
                        z = a.cLe().d(i2, jVar);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23673);
                }
            }

            @Override // com.tencent.mm.plugin.exdevice.service.h
            public final boolean e(int i2, j jVar) {
                boolean z = false;
                AppMethodBeat.i(23674);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    if (this.mRemote.transact(15, obtain, obtain2, 0) || a.cLe() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23674);
                    } else {
                        z = a.cLe().e(i2, jVar);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23674);
                }
            }

            @Override // com.tencent.mm.plugin.exdevice.service.h
            public final boolean b(long j2, int i2, k kVar) {
                boolean z = false;
                AppMethodBeat.i(23675);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeLong(j2);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(kVar != null ? kVar.asBinder() : null);
                    if (this.mRemote.transact(16, obtain, obtain2, 0) || a.cLe() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23675);
                    } else {
                        z = a.cLe().b(j2, i2, kVar);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23675);
                }
            }

            @Override // com.tencent.mm.plugin.exdevice.service.h
            public final boolean Dh(long j2) {
                boolean z = false;
                AppMethodBeat.i(23676);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeLong(j2);
                    if (this.mRemote.transact(17, obtain, obtain2, 0) || a.cLe() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23676);
                    } else {
                        z = a.cLe().Dh(j2);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23676);
                }
            }

            @Override // com.tencent.mm.plugin.exdevice.service.h
            public final boolean a(s sVar) {
                boolean z = false;
                AppMethodBeat.i(23677);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeStrongBinder(sVar != null ? sVar.asBinder() : null);
                    if (this.mRemote.transact(18, obtain, obtain2, 0) || a.cLe() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23677);
                    } else {
                        z = a.cLe().a(sVar);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23677);
                }
            }

            @Override // com.tencent.mm.plugin.exdevice.service.h
            public final boolean b(long j2, byte[] bArr, t tVar) {
                boolean z = false;
                AppMethodBeat.i(23678);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeLong(j2);
                    obtain.writeByteArray(bArr);
                    obtain.writeStrongBinder(tVar != null ? tVar.asBinder() : null);
                    if (this.mRemote.transact(19, obtain, obtain2, 0) || a.cLe() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23678);
                    } else {
                        z = a.cLe().b(j2, bArr, tVar);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23678);
                }
            }
        }

        public static h cLe() {
            return C0987a.rDH;
        }
    }
}
