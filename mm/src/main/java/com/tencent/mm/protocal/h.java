package com.tencent.mm.protocal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface h extends IInterface {
    boolean a(int i2, byte[] bArr, int i3, byte[] bArr2, byte[] bArr3, int i4, boolean z);

    byte[] aZm();

    String aZn();

    void an(byte[] bArr);

    int getClientVersion();

    int getCmdId();

    String getDeviceID();

    String getDeviceType();

    long getECDHEngine();

    byte[] getPassKey();

    String getPassword();

    int getSceneStatus();

    byte[] getSessionKey();

    boolean getShortSupport();

    int getUin();

    String getUserName();

    boolean isAxAuth();

    void sL(int i2);

    void setClientVersion(int i2);

    void setDeviceID(String str);

    void setDeviceType(String str);

    void setPassKey(byte[] bArr);

    void setSceneStatus(int i2);

    void setSessionKey(byte[] bArr);

    void setUin(int i2);

    void setUseAxsession(boolean z);

    boolean useAxSession();

    public static abstract class a extends Binder implements h {
        public a() {
            attachInterface(this, "com.tencent.mm.protocal.IMMBaseReq_AIDL");
        }

        public static h J(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof h)) {
                return new C2038a(iBinder);
            }
            return (h) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            boolean z;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            boolean z2 = false;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    int readInt = parcel.readInt();
                    byte[] createByteArray = parcel.createByteArray();
                    int readInt2 = parcel.readInt();
                    byte[] createByteArray2 = parcel.createByteArray();
                    byte[] createByteArray3 = parcel.createByteArray();
                    int readInt3 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean a2 = a(readInt, createByteArray, readInt2, createByteArray2, createByteArray3, readInt3, z);
                    parcel2.writeNoException();
                    if (a2) {
                        i5 = 1;
                    }
                    parcel2.writeInt(i5);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    byte[] aZm = aZm();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(aZm);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    setSessionKey(parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    byte[] sessionKey = getSessionKey();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(sessionKey);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    setUin(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    int uin = getUin();
                    parcel2.writeNoException();
                    parcel2.writeInt(uin);
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    setClientVersion(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    int clientVersion = getClientVersion();
                    parcel2.writeNoException();
                    parcel2.writeInt(clientVersion);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    setDeviceType(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    String deviceType = getDeviceType();
                    parcel2.writeNoException();
                    parcel2.writeString(deviceType);
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    String deviceID = getDeviceID();
                    parcel2.writeNoException();
                    parcel2.writeString(deviceID);
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    setDeviceID(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    setSceneStatus(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    int sceneStatus = getSceneStatus();
                    parcel2.writeNoException();
                    parcel2.writeInt(sceneStatus);
                    return true;
                case 15:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    byte[] passKey = getPassKey();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(passKey);
                    return true;
                case 16:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    setPassKey(parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    String userName = getUserName();
                    parcel2.writeNoException();
                    parcel2.writeString(userName);
                    return true;
                case 18:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    String password = getPassword();
                    parcel2.writeNoException();
                    parcel2.writeString(password);
                    return true;
                case 19:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    String aZn = aZn();
                    parcel2.writeNoException();
                    parcel2.writeString(aZn);
                    return true;
                case 20:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    int cmdId = getCmdId();
                    parcel2.writeNoException();
                    parcel2.writeInt(cmdId);
                    return true;
                case 21:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    boolean shortSupport = getShortSupport();
                    parcel2.writeNoException();
                    if (shortSupport) {
                        i6 = 1;
                    }
                    parcel2.writeInt(i6);
                    return true;
                case 22:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    long eCDHEngine = getECDHEngine();
                    parcel2.writeNoException();
                    parcel2.writeLong(eCDHEngine);
                    return true;
                case 23:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    boolean isAxAuth = isAxAuth();
                    parcel2.writeNoException();
                    if (isAxAuth) {
                        i7 = 1;
                    }
                    parcel2.writeInt(i7);
                    return true;
                case 24:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    if (parcel.readInt() != 0) {
                        z2 = true;
                    }
                    setUseAxsession(z2);
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    boolean useAxSession = useAxSession();
                    parcel2.writeNoException();
                    if (useAxSession) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 26:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    sL(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    an(parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.protocal.h$a$a  reason: collision with other inner class name */
        public static class C2038a implements h {
            public static h Kzk;
            private IBinder mRemote;

            C2038a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.protocal.h
            public final boolean a(int i2, byte[] bArr, int i3, byte[] bArr2, byte[] bArr3, int i4, boolean z) {
                boolean z2;
                AppMethodBeat.i(133045);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeInt(i2);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i3);
                    obtain.writeByteArray(bArr2);
                    obtain.writeByteArray(bArr3);
                    obtain.writeInt(i4);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.gtJ() == null) {
                        obtain2.readException();
                        z2 = obtain2.readInt() != 0;
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(133045);
                    } else {
                        z2 = a.gtJ().a(i2, bArr, i3, bArr2, bArr3, i4, z);
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133045);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final byte[] aZm() {
                AppMethodBeat.i(133046);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && a.gtJ() != null) {
                        return a.gtJ().aZm();
                    }
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133046);
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133046);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final void setSessionKey(byte[] bArr) {
                AppMethodBeat.i(133047);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeByteArray(bArr);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || a.gtJ() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(133047);
                        return;
                    }
                    a.gtJ().setSessionKey(bArr);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133047);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final byte[] getSessionKey() {
                AppMethodBeat.i(133048);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && a.gtJ() != null) {
                        return a.gtJ().getSessionKey();
                    }
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133048);
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133048);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final void setUin(int i2) {
                AppMethodBeat.i(133049);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || a.gtJ() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(133049);
                        return;
                    }
                    a.gtJ().setUin(i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133049);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final int getUin() {
                AppMethodBeat.i(133050);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && a.gtJ() != null) {
                        return a.gtJ().getUin();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133050);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133050);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final void setClientVersion(int i2) {
                AppMethodBeat.i(133051);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(7, obtain, obtain2, 0) || a.gtJ() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(133051);
                        return;
                    }
                    a.gtJ().setClientVersion(i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133051);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final int getClientVersion() {
                AppMethodBeat.i(133052);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && a.gtJ() != null) {
                        return a.gtJ().getClientVersion();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133052);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133052);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final void setDeviceType(String str) {
                AppMethodBeat.i(133053);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeString(str);
                    if (this.mRemote.transact(9, obtain, obtain2, 0) || a.gtJ() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(133053);
                        return;
                    }
                    a.gtJ().setDeviceType(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133053);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final String getDeviceType() {
                AppMethodBeat.i(133054);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && a.gtJ() != null) {
                        return a.gtJ().getDeviceType();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133054);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133054);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final String getDeviceID() {
                AppMethodBeat.i(133055);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && a.gtJ() != null) {
                        return a.gtJ().getDeviceID();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133055);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133055);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final void setDeviceID(String str) {
                AppMethodBeat.i(133056);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeString(str);
                    if (this.mRemote.transact(12, obtain, obtain2, 0) || a.gtJ() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(133056);
                        return;
                    }
                    a.gtJ().setDeviceID(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133056);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final void setSceneStatus(int i2) {
                AppMethodBeat.i(133057);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(13, obtain, obtain2, 0) || a.gtJ() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(133057);
                        return;
                    }
                    a.gtJ().setSceneStatus(i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133057);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final int getSceneStatus() {
                AppMethodBeat.i(133058);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && a.gtJ() != null) {
                        return a.gtJ().getSceneStatus();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133058);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133058);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final byte[] getPassKey() {
                AppMethodBeat.i(133059);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    if (!this.mRemote.transact(15, obtain, obtain2, 0) && a.gtJ() != null) {
                        return a.gtJ().getPassKey();
                    }
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133059);
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133059);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final void setPassKey(byte[] bArr) {
                AppMethodBeat.i(133060);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeByteArray(bArr);
                    if (this.mRemote.transact(16, obtain, obtain2, 0) || a.gtJ() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(133060);
                        return;
                    }
                    a.gtJ().setPassKey(bArr);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133060);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final String getUserName() {
                AppMethodBeat.i(133061);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    if (!this.mRemote.transact(17, obtain, obtain2, 0) && a.gtJ() != null) {
                        return a.gtJ().getUserName();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133061);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133061);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final String getPassword() {
                AppMethodBeat.i(133062);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    if (!this.mRemote.transact(18, obtain, obtain2, 0) && a.gtJ() != null) {
                        return a.gtJ().getPassword();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133062);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133062);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final String aZn() {
                AppMethodBeat.i(133063);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    if (!this.mRemote.transact(19, obtain, obtain2, 0) && a.gtJ() != null) {
                        return a.gtJ().aZn();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133063);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133063);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final int getCmdId() {
                AppMethodBeat.i(133064);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    if (!this.mRemote.transact(20, obtain, obtain2, 0) && a.gtJ() != null) {
                        return a.gtJ().getCmdId();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133064);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133064);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final boolean getShortSupport() {
                boolean z = false;
                AppMethodBeat.i(133065);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    if (this.mRemote.transact(21, obtain, obtain2, 0) || a.gtJ() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(133065);
                    } else {
                        z = a.gtJ().getShortSupport();
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133065);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final long getECDHEngine() {
                AppMethodBeat.i(133066);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    if (!this.mRemote.transact(22, obtain, obtain2, 0) && a.gtJ() != null) {
                        return a.gtJ().getECDHEngine();
                    }
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133066);
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133066);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final boolean isAxAuth() {
                boolean z = false;
                AppMethodBeat.i(133067);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    if (this.mRemote.transact(23, obtain, obtain2, 0) || a.gtJ() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(133067);
                    } else {
                        z = a.gtJ().isAxAuth();
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133067);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final void setUseAxsession(boolean z) {
                int i2 = 0;
                AppMethodBeat.i(133068);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(24, obtain, obtain2, 0) || a.gtJ() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(133068);
                        return;
                    }
                    a.gtJ().setUseAxsession(z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133068);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final boolean useAxSession() {
                boolean z = false;
                AppMethodBeat.i(133069);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    if (this.mRemote.transact(25, obtain, obtain2, 0) || a.gtJ() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(133069);
                    } else {
                        z = a.gtJ().useAxSession();
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133069);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final void sL(int i2) {
                AppMethodBeat.i(197125);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(26, obtain, obtain2, 0) || a.gtJ() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(197125);
                        return;
                    }
                    a.gtJ().sL(i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(197125);
                }
            }

            @Override // com.tencent.mm.protocal.h
            public final void an(byte[] bArr) {
                AppMethodBeat.i(197126);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeByteArray(bArr);
                    if (this.mRemote.transact(27, obtain, obtain2, 0) || a.gtJ() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(197126);
                        return;
                    }
                    a.gtJ().an(bArr);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(197126);
                }
            }
        }

        public static h gtJ() {
            return C2038a.Kzk;
        }
    }
}
