package com.tencent.mm.protocal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface i extends IInterface {
    boolean a(int i2, byte[] bArr, byte[] bArr2, long j2);

    byte[] aZa();

    byte[] aZc();

    String aZd();

    byte[] aZs();

    String aZt();

    String aZu();

    int aZv();

    void ao(byte[] bArr);

    byte[] getAuthResponse();

    int getCmdId();

    String getErrMsg();

    int getHeadExtFlags();

    int getRetCode();

    int getUin();

    byte[] qe(int i2);

    void setErrMsg(String str);

    void setRetCode(int i2);

    public static abstract class a extends Binder implements i {
        public a() {
            attachInterface(this, "com.tencent.mm.protocal.IMMBaseResp_AIDL");
        }

        public static i K(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof i)) {
                return new C2039a(iBinder);
            }
            return (i) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    boolean a2 = a(parcel.readInt(), parcel.createByteArray(), parcel.createByteArray(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(a2 ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    byte[] aZa = aZa();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(aZa);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    setRetCode(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    int retCode = getRetCode();
                    parcel2.writeNoException();
                    parcel2.writeInt(retCode);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    int headExtFlags = getHeadExtFlags();
                    parcel2.writeNoException();
                    parcel2.writeInt(headExtFlags);
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    String errMsg = getErrMsg();
                    parcel2.writeNoException();
                    parcel2.writeString(errMsg);
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    setErrMsg(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    byte[] qe = qe(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeByteArray(qe);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    byte[] aZs = aZs();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(aZs);
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    byte[] aZc = aZc();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(aZc);
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    int uin = getUin();
                    parcel2.writeNoException();
                    parcel2.writeInt(uin);
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    String aZd = aZd();
                    parcel2.writeNoException();
                    parcel2.writeString(aZd);
                    return true;
                case 13:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    int cmdId = getCmdId();
                    parcel2.writeNoException();
                    parcel2.writeInt(cmdId);
                    return true;
                case 14:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    String aZt = aZt();
                    parcel2.writeNoException();
                    parcel2.writeString(aZt);
                    return true;
                case 15:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    String aZu = aZu();
                    parcel2.writeNoException();
                    parcel2.writeString(aZu);
                    return true;
                case 16:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    int aZv = aZv();
                    parcel2.writeNoException();
                    parcel2.writeInt(aZv);
                    return true;
                case 17:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    byte[] authResponse = getAuthResponse();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(authResponse);
                    return true;
                case 18:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    ao(parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.protocal.i$a$a  reason: collision with other inner class name */
        public static class C2039a implements i {
            public static i Kzl;
            private IBinder mRemote;

            C2039a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.protocal.i
            public final boolean a(int i2, byte[] bArr, byte[] bArr2, long j2) {
                boolean z = true;
                AppMethodBeat.i(133070);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    obtain.writeInt(i2);
                    obtain.writeByteArray(bArr);
                    obtain.writeByteArray(bArr2);
                    obtain.writeLong(j2);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.gtK() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() == 0) {
                            z = false;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(133070);
                    } else {
                        z = a.gtK().a(i2, bArr, bArr2, j2);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133070);
                }
            }

            @Override // com.tencent.mm.protocal.i
            public final byte[] aZa() {
                AppMethodBeat.i(133071);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && a.gtK() != null) {
                        return a.gtK().aZa();
                    }
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133071);
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133071);
                }
            }

            @Override // com.tencent.mm.protocal.i
            public final void setRetCode(int i2) {
                AppMethodBeat.i(133072);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || a.gtK() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(133072);
                        return;
                    }
                    a.gtK().setRetCode(i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133072);
                }
            }

            @Override // com.tencent.mm.protocal.i
            public final int getRetCode() {
                AppMethodBeat.i(133073);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && a.gtK() != null) {
                        return a.gtK().getRetCode();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133073);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133073);
                }
            }

            @Override // com.tencent.mm.protocal.i
            public final int getHeadExtFlags() {
                AppMethodBeat.i(133074);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && a.gtK() != null) {
                        return a.gtK().getHeadExtFlags();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133074);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133074);
                }
            }

            @Override // com.tencent.mm.protocal.i
            public final String getErrMsg() {
                AppMethodBeat.i(133075);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && a.gtK() != null) {
                        return a.gtK().getErrMsg();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133075);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133075);
                }
            }

            @Override // com.tencent.mm.protocal.i
            public final void setErrMsg(String str) {
                AppMethodBeat.i(133076);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    obtain.writeString(str);
                    if (this.mRemote.transact(7, obtain, obtain2, 0) || a.gtK() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(133076);
                        return;
                    }
                    a.gtK().setErrMsg(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133076);
                }
            }

            @Override // com.tencent.mm.protocal.i
            public final byte[] qe(int i2) {
                AppMethodBeat.i(133077);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && a.gtK() != null) {
                        return a.gtK().qe(i2);
                    }
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133077);
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133077);
                }
            }

            @Override // com.tencent.mm.protocal.i
            public final byte[] aZs() {
                AppMethodBeat.i(133078);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && a.gtK() != null) {
                        return a.gtK().aZs();
                    }
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133078);
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133078);
                }
            }

            @Override // com.tencent.mm.protocal.i
            public final byte[] aZc() {
                AppMethodBeat.i(133079);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && a.gtK() != null) {
                        return a.gtK().aZc();
                    }
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133079);
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133079);
                }
            }

            @Override // com.tencent.mm.protocal.i
            public final int getUin() {
                AppMethodBeat.i(133080);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && a.gtK() != null) {
                        return a.gtK().getUin();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133080);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133080);
                }
            }

            @Override // com.tencent.mm.protocal.i
            public final String aZd() {
                AppMethodBeat.i(133081);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && a.gtK() != null) {
                        return a.gtK().aZd();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133081);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133081);
                }
            }

            @Override // com.tencent.mm.protocal.i
            public final int getCmdId() {
                AppMethodBeat.i(133082);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && a.gtK() != null) {
                        return a.gtK().getCmdId();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133082);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133082);
                }
            }

            @Override // com.tencent.mm.protocal.i
            public final String aZt() {
                AppMethodBeat.i(133083);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && a.gtK() != null) {
                        return a.gtK().aZt();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133083);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133083);
                }
            }

            @Override // com.tencent.mm.protocal.i
            public final String aZu() {
                AppMethodBeat.i(133084);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    if (!this.mRemote.transact(15, obtain, obtain2, 0) && a.gtK() != null) {
                        return a.gtK().aZu();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133084);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133084);
                }
            }

            @Override // com.tencent.mm.protocal.i
            public final int aZv() {
                AppMethodBeat.i(133085);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    if (!this.mRemote.transact(16, obtain, obtain2, 0) && a.gtK() != null) {
                        return a.gtK().aZv();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133085);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133085);
                }
            }

            @Override // com.tencent.mm.protocal.i
            public final byte[] getAuthResponse() {
                AppMethodBeat.i(133086);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    if (!this.mRemote.transact(17, obtain, obtain2, 0) && a.gtK() != null) {
                        return a.gtK().getAuthResponse();
                    }
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133086);
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133086);
                }
            }

            @Override // com.tencent.mm.protocal.i
            public final void ao(byte[] bArr) {
                AppMethodBeat.i(197127);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    obtain.writeByteArray(bArr);
                    if (this.mRemote.transact(18, obtain, obtain2, 0) || a.gtK() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(197127);
                        return;
                    }
                    a.gtK().ao(bArr);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(197127);
                }
            }
        }

        public static i gtK() {
            return C2039a.Kzl;
        }
    }
}
