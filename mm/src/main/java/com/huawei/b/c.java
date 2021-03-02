package com.huawei.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface c extends IInterface {
    int[] II();

    int a(b bVar, int[] iArr, byte[] bArr);

    int a(b bVar, int[] iArr, byte[] bArr, int i2);

    void a(b bVar);

    boolean a(b bVar, int i2);

    boolean a(b bVar, int i2, boolean z);

    String b(b bVar, int i2);

    void b(b bVar);

    int[] c(b bVar);

    int[] c(b bVar, int i2);

    boolean cx(String str);

    int d(b bVar, int i2);

    long d(b bVar);

    byte[] e(b bVar);

    boolean hn(int i2);

    int ho(int i2);

    public static abstract class a extends Binder implements c {
        public static c j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.securitymgr.IAuthenticationService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
                return new C0126a(iBinder);
            }
            return (c) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            boolean z;
            int i4 = 0;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    boolean a2 = a(b.a.i(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (a2) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 2:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    int a3 = a(b.a.i(parcel.readStrongBinder()), parcel.createIntArray(), parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(a3);
                    return true;
                case 3:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    a(b.a.i(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    b(b.a.i(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    int[] c2 = c(b.a.i(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeIntArray(c2);
                    return true;
                case 6:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    int[] II = II();
                    parcel2.writeNoException();
                    parcel2.writeIntArray(II);
                    return true;
                case 7:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    boolean hn = hn(parcel.readInt());
                    parcel2.writeNoException();
                    if (hn) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 8:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    int ho = ho(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(ho);
                    return true;
                case 9:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    boolean cx = cx(parcel.readString());
                    parcel2.writeNoException();
                    if (cx) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 10:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    String b2 = b(b.a.i(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(b2);
                    return true;
                case 11:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    int[] c3 = c(b.a.i(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeIntArray(c3);
                    return true;
                case 12:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    int d2 = d(b.a.i(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(d2);
                    return true;
                case 13:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    b i5 = b.a.i(parcel.readStrongBinder());
                    int readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean a4 = a(i5, readInt, z);
                    parcel2.writeNoException();
                    if (a4) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 14:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    long d3 = d(b.a.i(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeLong(d3);
                    return true;
                case 15:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    int a5 = a(b.a.i(parcel.readStrongBinder()), parcel.createIntArray(), parcel.createByteArray(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(a5);
                    return true;
                case 16:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    byte[] e2 = e(b.a.i(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeByteArray(e2);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.huawei.securitymgr.IAuthenticationService");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* renamed from: com.huawei.b.c$a$a  reason: collision with other inner class name */
        static class C0126a implements c {
            private IBinder mRemote;

            C0126a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.b.c
            public final boolean a(b bVar, int i2) {
                boolean z = true;
                AppMethodBeat.i(88763);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeInt(i2);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88763);
                }
            }

            @Override // com.huawei.b.c
            public final int a(b bVar, int[] iArr, byte[] bArr) {
                AppMethodBeat.i(88764);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeIntArray(iArr);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88764);
                }
            }

            @Override // com.huawei.b.c
            public final void a(b bVar) {
                AppMethodBeat.i(88765);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88765);
                }
            }

            @Override // com.huawei.b.c
            public final void b(b bVar) {
                AppMethodBeat.i(88766);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88766);
                }
            }

            @Override // com.huawei.b.c
            public final int[] c(b bVar) {
                AppMethodBeat.i(88767);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createIntArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88767);
                }
            }

            @Override // com.huawei.b.c
            public final int[] II() {
                AppMethodBeat.i(88768);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createIntArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88768);
                }
            }

            @Override // com.huawei.b.c
            public final boolean hn(int i2) {
                boolean z = false;
                AppMethodBeat.i(88769);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeInt(i2);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88769);
                }
            }

            @Override // com.huawei.b.c
            public final int ho(int i2) {
                AppMethodBeat.i(88770);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeInt(i2);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88770);
                }
            }

            @Override // com.huawei.b.c
            public final boolean cx(String str) {
                boolean z = false;
                AppMethodBeat.i(88771);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeString(str);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88771);
                }
            }

            @Override // com.huawei.b.c
            public final String b(b bVar, int i2) {
                AppMethodBeat.i(88772);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeInt(i2);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88772);
                }
            }

            @Override // com.huawei.b.c
            public final int[] c(b bVar, int i2) {
                AppMethodBeat.i(88773);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeInt(i2);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createIntArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88773);
                }
            }

            @Override // com.huawei.b.c
            public final int d(b bVar, int i2) {
                AppMethodBeat.i(88774);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeInt(i2);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88774);
                }
            }

            @Override // com.huawei.b.c
            public final boolean a(b bVar, int i2, boolean z) {
                int i3;
                boolean z2 = true;
                AppMethodBeat.i(88775);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeInt(i2);
                    if (z) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88775);
                }
            }

            @Override // com.huawei.b.c
            public final long d(b bVar) {
                AppMethodBeat.i(88776);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88776);
                }
            }

            @Override // com.huawei.b.c
            public final int a(b bVar, int[] iArr, byte[] bArr, int i2) {
                AppMethodBeat.i(88777);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeIntArray(iArr);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i2);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88777);
                }
            }

            @Override // com.huawei.b.c
            public final byte[] e(b bVar) {
                AppMethodBeat.i(88778);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88778);
                }
            }
        }
    }
}
