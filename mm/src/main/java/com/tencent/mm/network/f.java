package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface f extends IInterface {
    byte[] MC(String str);

    byte[] MD(String str);

    byte[] ME(String str);

    byte[] MF(String str);

    boolean MG(String str);

    void RL(String str);

    boolean RN(String str);

    void a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i2);

    byte[] aZa();

    boolean aZb();

    byte[] aZc();

    String aZd();

    byte[] aZe();

    void aZf();

    void aZg();

    int al(byte[] bArr);

    int am(byte[] bArr);

    void av(byte[] bArr);

    void aw(byte[] bArr);

    void ax(byte[] bArr);

    boolean ay(byte[] bArr);

    void b(int i2, byte[] bArr, byte[] bArr2);

    int getUin();

    String getUsername();

    void h(int i2, byte[] bArr);

    void i(String str, byte[] bArr);

    boolean isForeground();

    byte[] qe(int i2);

    void reset();

    void setForeground(boolean z);

    void setUin(int i2);

    void setUsername(String str);

    public static abstract class a extends Binder implements f {
        public a() {
            attachInterface(this, "com.tencent.mm.network.IAccInfo_AIDL");
        }

        public static f m(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.network.IAccInfo_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof f)) {
                return new C0486a(iBinder);
            }
            return (f) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            int i4 = 0;
            int i5 = 0;
            boolean z = false;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    reset();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    a(parcel.createByteArray(), parcel.createByteArray(), parcel.createByteArray(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    setUin(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    setUsername(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    av(parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    aw(parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    String username = getUsername();
                    parcel2.writeNoException();
                    parcel2.writeString(username);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    byte[] qe = qe(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeByteArray(qe);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    byte[] aZa = aZa();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(aZa);
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    byte[] aZc = aZc();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(aZc);
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    int uin = getUin();
                    parcel2.writeNoException();
                    parcel2.writeInt(uin);
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    boolean aZb = aZb();
                    parcel2.writeNoException();
                    if (aZb) {
                        i5 = 1;
                    }
                    parcel2.writeInt(i5);
                    return true;
                case 13:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    i(parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    byte[] MC = MC(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeByteArray(MC);
                    return true;
                case 15:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    setForeground(z);
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    boolean isForeground = isForeground();
                    parcel2.writeNoException();
                    if (isForeground) {
                        i6 = 1;
                    }
                    parcel2.writeInt(i6);
                    return true;
                case 17:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    String aZd = aZd();
                    parcel2.writeNoException();
                    parcel2.writeString(aZd);
                    return true;
                case 18:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    RL(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    int al = al(parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(al);
                    return true;
                case 20:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    byte[] aZe = aZe();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(aZe);
                    return true;
                case 21:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    int am = am(parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(am);
                    return true;
                case 22:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    h(parcel.readInt(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    b(parcel.readInt(), parcel.createByteArray(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    ax(parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    boolean ay = ay(parcel.createByteArray());
                    parcel2.writeNoException();
                    if (ay) {
                        i7 = 1;
                    }
                    parcel2.writeInt(i7);
                    return true;
                case 26:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    byte[] MD = MD(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeByteArray(MD);
                    return true;
                case 27:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    byte[] MF = MF(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeByteArray(MF);
                    return true;
                case 28:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    byte[] ME = ME(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeByteArray(ME);
                    return true;
                case 29:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    boolean MG = MG(parcel.readString());
                    parcel2.writeNoException();
                    if (MG) {
                        i8 = 1;
                    }
                    parcel2.writeInt(i8);
                    return true;
                case 30:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    aZf();
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    aZg();
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    boolean RN = RN(parcel.readString());
                    parcel2.writeNoException();
                    if (RN) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.network.IAccInfo_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.network.f$a$a  reason: collision with other inner class name */
        public static class C0486a implements f {
            public static f jDQ;
            private IBinder mRemote;

            C0486a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.network.f
            public final void reset() {
                AppMethodBeat.i(132667);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.bjv() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132667);
                        return;
                    }
                    a.bjv().reset();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132667);
                }
            }

            @Override // com.tencent.mm.network.f
            public final void a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i2) {
                AppMethodBeat.i(132668);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeByteArray(bArr);
                    obtain.writeByteArray(bArr2);
                    obtain.writeByteArray(bArr3);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || a.bjv() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132668);
                        return;
                    }
                    a.bjv().a(bArr, bArr2, bArr3, i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132668);
                }
            }

            @Override // com.tencent.mm.network.f
            public final void setUin(int i2) {
                AppMethodBeat.i(132669);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || a.bjv() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132669);
                        return;
                    }
                    a.bjv().setUin(i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132669);
                }
            }

            @Override // com.tencent.mm.network.f
            public final void setUsername(String str) {
                AppMethodBeat.i(132670);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeString(str);
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || a.bjv() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132670);
                        return;
                    }
                    a.bjv().setUsername(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132670);
                }
            }

            @Override // com.tencent.mm.network.f
            public final void av(byte[] bArr) {
                AppMethodBeat.i(132671);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeByteArray(bArr);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || a.bjv() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132671);
                        return;
                    }
                    a.bjv().av(bArr);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132671);
                }
            }

            @Override // com.tencent.mm.network.f
            public final void aw(byte[] bArr) {
                AppMethodBeat.i(132672);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeByteArray(bArr);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || a.bjv() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132672);
                        return;
                    }
                    a.bjv().aw(bArr);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132672);
                }
            }

            @Override // com.tencent.mm.network.f
            public final String getUsername() {
                AppMethodBeat.i(132673);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && a.bjv() != null) {
                        return a.bjv().getUsername();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132673);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132673);
                }
            }

            @Override // com.tencent.mm.network.f
            public final byte[] qe(int i2) {
                AppMethodBeat.i(132674);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && a.bjv() != null) {
                        return a.bjv().qe(i2);
                    }
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132674);
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132674);
                }
            }

            @Override // com.tencent.mm.network.f
            public final byte[] aZa() {
                AppMethodBeat.i(132675);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && a.bjv() != null) {
                        return a.bjv().aZa();
                    }
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132675);
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132675);
                }
            }

            @Override // com.tencent.mm.network.f
            public final byte[] aZc() {
                AppMethodBeat.i(132676);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && a.bjv() != null) {
                        return a.bjv().aZc();
                    }
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132676);
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132676);
                }
            }

            @Override // com.tencent.mm.network.f
            public final int getUin() {
                AppMethodBeat.i(132677);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && a.bjv() != null) {
                        return a.bjv().getUin();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132677);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132677);
                }
            }

            @Override // com.tencent.mm.network.f
            public final boolean aZb() {
                boolean z = false;
                AppMethodBeat.i(132678);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    if (this.mRemote.transact(12, obtain, obtain2, 0) || a.bjv() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132678);
                    } else {
                        z = a.bjv().aZb();
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132678);
                }
            }

            @Override // com.tencent.mm.network.f
            public final void i(String str, byte[] bArr) {
                AppMethodBeat.i(132679);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    if (this.mRemote.transact(13, obtain, obtain2, 0) || a.bjv() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132679);
                        return;
                    }
                    a.bjv().i(str, bArr);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132679);
                }
            }

            @Override // com.tencent.mm.network.f
            public final byte[] MC(String str) {
                AppMethodBeat.i(132680);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && a.bjv() != null) {
                        return a.bjv().MC(str);
                    }
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132680);
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132680);
                }
            }

            @Override // com.tencent.mm.network.f
            public final void setForeground(boolean z) {
                int i2 = 0;
                AppMethodBeat.i(132681);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(15, obtain, obtain2, 0) || a.bjv() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132681);
                        return;
                    }
                    a.bjv().setForeground(z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132681);
                }
            }

            @Override // com.tencent.mm.network.f
            public final boolean isForeground() {
                boolean z = false;
                AppMethodBeat.i(132682);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    if (this.mRemote.transact(16, obtain, obtain2, 0) || a.bjv() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132682);
                    } else {
                        z = a.bjv().isForeground();
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132682);
                }
            }

            @Override // com.tencent.mm.network.f
            public final String aZd() {
                AppMethodBeat.i(132683);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    if (!this.mRemote.transact(17, obtain, obtain2, 0) && a.bjv() != null) {
                        return a.bjv().aZd();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132683);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132683);
                }
            }

            @Override // com.tencent.mm.network.f
            public final void RL(String str) {
                AppMethodBeat.i(132684);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeString(str);
                    if (this.mRemote.transact(18, obtain, obtain2, 0) || a.bjv() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132684);
                        return;
                    }
                    a.bjv().RL(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132684);
                }
            }

            @Override // com.tencent.mm.network.f
            public final int al(byte[] bArr) {
                AppMethodBeat.i(132685);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeByteArray(bArr);
                    if (!this.mRemote.transact(19, obtain, obtain2, 0) && a.bjv() != null) {
                        return a.bjv().al(bArr);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132685);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132685);
                }
            }

            @Override // com.tencent.mm.network.f
            public final byte[] aZe() {
                AppMethodBeat.i(132686);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    if (!this.mRemote.transact(20, obtain, obtain2, 0) && a.bjv() != null) {
                        return a.bjv().aZe();
                    }
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132686);
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132686);
                }
            }

            @Override // com.tencent.mm.network.f
            public final int am(byte[] bArr) {
                AppMethodBeat.i(197092);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeByteArray(bArr);
                    if (!this.mRemote.transact(21, obtain, obtain2, 0) && a.bjv() != null) {
                        return a.bjv().am(bArr);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(197092);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(197092);
                }
            }

            @Override // com.tencent.mm.network.f
            public final void h(int i2, byte[] bArr) {
                AppMethodBeat.i(132687);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeInt(i2);
                    obtain.writeByteArray(bArr);
                    if (this.mRemote.transact(22, obtain, obtain2, 0) || a.bjv() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132687);
                        return;
                    }
                    a.bjv().h(i2, bArr);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132687);
                }
            }

            @Override // com.tencent.mm.network.f
            public final void b(int i2, byte[] bArr, byte[] bArr2) {
                AppMethodBeat.i(132688);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeInt(i2);
                    obtain.writeByteArray(bArr);
                    obtain.writeByteArray(bArr2);
                    if (this.mRemote.transact(23, obtain, obtain2, 0) || a.bjv() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132688);
                        return;
                    }
                    a.bjv().b(i2, bArr, bArr2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132688);
                }
            }

            @Override // com.tencent.mm.network.f
            public final void ax(byte[] bArr) {
                AppMethodBeat.i(132689);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeByteArray(bArr);
                    if (this.mRemote.transact(24, obtain, obtain2, 0) || a.bjv() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132689);
                        return;
                    }
                    a.bjv().ax(bArr);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132689);
                }
            }

            @Override // com.tencent.mm.network.f
            public final boolean ay(byte[] bArr) {
                boolean z = false;
                AppMethodBeat.i(132690);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeByteArray(bArr);
                    if (this.mRemote.transact(25, obtain, obtain2, 0) || a.bjv() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132690);
                    } else {
                        z = a.bjv().ay(bArr);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132690);
                }
            }

            @Override // com.tencent.mm.network.f
            public final byte[] MD(String str) {
                AppMethodBeat.i(132691);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(26, obtain, obtain2, 0) && a.bjv() != null) {
                        return a.bjv().MD(str);
                    }
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132691);
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132691);
                }
            }

            @Override // com.tencent.mm.network.f
            public final byte[] MF(String str) {
                AppMethodBeat.i(132692);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(27, obtain, obtain2, 0) && a.bjv() != null) {
                        return a.bjv().MF(str);
                    }
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132692);
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132692);
                }
            }

            @Override // com.tencent.mm.network.f
            public final byte[] ME(String str) {
                AppMethodBeat.i(132693);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(28, obtain, obtain2, 0) && a.bjv() != null) {
                        return a.bjv().ME(str);
                    }
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132693);
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132693);
                }
            }

            @Override // com.tencent.mm.network.f
            public final boolean MG(String str) {
                boolean z = false;
                AppMethodBeat.i(132694);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeString(str);
                    if (this.mRemote.transact(29, obtain, obtain2, 0) || a.bjv() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132694);
                    } else {
                        z = a.bjv().MG(str);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132694);
                }
            }

            @Override // com.tencent.mm.network.f
            public final void aZf() {
                AppMethodBeat.i(132695);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    if (this.mRemote.transact(30, obtain, obtain2, 0) || a.bjv() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132695);
                        return;
                    }
                    a.bjv().aZf();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132695);
                }
            }

            @Override // com.tencent.mm.network.f
            public final void aZg() {
                AppMethodBeat.i(132696);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    if (this.mRemote.transact(31, obtain, obtain2, 0) || a.bjv() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132696);
                        return;
                    }
                    a.bjv().aZg();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132696);
                }
            }

            @Override // com.tencent.mm.network.f
            public final boolean RN(String str) {
                boolean z = false;
                AppMethodBeat.i(132697);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeString(str);
                    if (this.mRemote.transact(32, obtain, obtain2, 0) || a.bjv() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132697);
                    } else {
                        z = a.bjv().RN(str);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132697);
                }
            }
        }

        public static f bjv() {
            return C0486a.jDQ;
        }
    }
}
