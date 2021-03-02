package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.f;
import com.tencent.mm.network.l;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.i;

public interface t extends IInterface {
    void a(f fVar, l lVar, int i2, int i3);

    void a(l lVar, int i2, int i3);

    void a(l lVar, int i2, int i3, String str);

    h aZo();

    i aZp();

    int aZq();

    boolean aZr();

    String getCgiVerifyPrivateKey();

    String getCgiVerifyPublicKey();

    boolean getIsLongPolling();

    boolean getIsUserCmd();

    int getLongPollingTimeout();

    int getMMReqRespHash();

    int getNewExtFlags();

    int getOptions();

    int getTimeOut();

    byte[] getTransHeader();

    int getType();

    String getUri();

    boolean isSingleSession();

    void setConnectionInfo(String str);

    public static abstract class a extends Binder implements t {
        public a() {
            attachInterface(this, "com.tencent.mm.network.IReqResp_AIDL");
        }

        public static t q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.network.IReqResp_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof t)) {
                return new C0495a(iBinder);
            }
            return (t) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            IBinder iBinder = null;
            int i4 = 0;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    int type = getType();
                    parcel2.writeNoException();
                    parcel2.writeInt(type);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    String uri = getUri();
                    parcel2.writeNoException();
                    parcel2.writeString(uri);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    i aZp = aZp();
                    parcel2.writeNoException();
                    if (aZp != null) {
                        iBinder = aZp.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    h aZo = aZo();
                    parcel2.writeNoException();
                    if (aZo != null) {
                        iBinder = aZo.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    a(l.a.p(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    int mMReqRespHash = getMMReqRespHash();
                    parcel2.writeNoException();
                    parcel2.writeInt(mMReqRespHash);
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    boolean isUserCmd = getIsUserCmd();
                    parcel2.writeNoException();
                    parcel2.writeInt(isUserCmd ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    int options = getOptions();
                    parcel2.writeNoException();
                    parcel2.writeInt(options);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    setConnectionInfo(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    a(l.a.p(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    a(f.a.m(parcel.readStrongBinder()), l.a.p(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    int aZq = aZq();
                    parcel2.writeNoException();
                    parcel2.writeInt(aZq);
                    return true;
                case 13:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    int timeOut = getTimeOut();
                    parcel2.writeNoException();
                    parcel2.writeInt(timeOut);
                    return true;
                case 14:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    boolean isSingleSession = isSingleSession();
                    parcel2.writeNoException();
                    if (isSingleSession) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 15:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    boolean isLongPolling = getIsLongPolling();
                    parcel2.writeNoException();
                    if (isLongPolling) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 16:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    boolean aZr = aZr();
                    parcel2.writeNoException();
                    if (aZr) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 17:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    int longPollingTimeout = getLongPollingTimeout();
                    parcel2.writeNoException();
                    parcel2.writeInt(longPollingTimeout);
                    return true;
                case 18:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    int newExtFlags = getNewExtFlags();
                    parcel2.writeNoException();
                    parcel2.writeInt(newExtFlags);
                    return true;
                case 19:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    byte[] transHeader = getTransHeader();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(transHeader);
                    return true;
                case 20:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    String cgiVerifyPublicKey = getCgiVerifyPublicKey();
                    parcel2.writeNoException();
                    parcel2.writeString(cgiVerifyPublicKey);
                    return true;
                case 21:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    String cgiVerifyPrivateKey = getCgiVerifyPrivateKey();
                    parcel2.writeNoException();
                    parcel2.writeString(cgiVerifyPrivateKey);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.network.IReqResp_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.network.t$a$a  reason: collision with other inner class name */
        public static class C0495a implements t {
            public static t jEb;
            private IBinder mRemote;

            C0495a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.network.t
            public final int getType() {
                AppMethodBeat.i(132757);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && a.bjJ() != null) {
                        return a.bjJ().getType();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132757);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132757);
                }
            }

            @Override // com.tencent.mm.network.t
            public final String getUri() {
                AppMethodBeat.i(132758);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && a.bjJ() != null) {
                        return a.bjJ().getUri();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132758);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132758);
                }
            }

            @Override // com.tencent.mm.network.t
            public final i aZp() {
                AppMethodBeat.i(132759);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && a.bjJ() != null) {
                        return a.bjJ().aZp();
                    }
                    obtain2.readException();
                    i K = i.a.K(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132759);
                    return K;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132759);
                }
            }

            @Override // com.tencent.mm.network.t
            public final h aZo() {
                AppMethodBeat.i(132760);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && a.bjJ() != null) {
                        return a.bjJ().aZo();
                    }
                    obtain2.readException();
                    h J = h.a.J(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132760);
                    return J;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132760);
                }
            }

            @Override // com.tencent.mm.network.t
            public final void a(l lVar, int i2, int i3) {
                AppMethodBeat.i(132761);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    obtain.writeStrongBinder(lVar != null ? lVar.asBinder() : null);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || a.bjJ() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132761);
                        return;
                    }
                    a.bjJ().a(lVar, i2, i3);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132761);
                }
            }

            @Override // com.tencent.mm.network.t
            public final int getMMReqRespHash() {
                AppMethodBeat.i(132762);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && a.bjJ() != null) {
                        return a.bjJ().getMMReqRespHash();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132762);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132762);
                }
            }

            @Override // com.tencent.mm.network.t
            public final boolean getIsUserCmd() {
                boolean z = false;
                AppMethodBeat.i(132763);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    if (this.mRemote.transact(7, obtain, obtain2, 0) || a.bjJ() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132763);
                    } else {
                        z = a.bjJ().getIsUserCmd();
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132763);
                }
            }

            @Override // com.tencent.mm.network.t
            public final int getOptions() {
                AppMethodBeat.i(132764);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && a.bjJ() != null) {
                        return a.bjJ().getOptions();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132764);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132764);
                }
            }

            @Override // com.tencent.mm.network.t
            public final void setConnectionInfo(String str) {
                AppMethodBeat.i(132765);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    obtain.writeString(str);
                    if (this.mRemote.transact(9, obtain, obtain2, 0) || a.bjJ() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132765);
                        return;
                    }
                    a.bjJ().setConnectionInfo(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132765);
                }
            }

            @Override // com.tencent.mm.network.t
            public final void a(l lVar, int i2, int i3, String str) {
                AppMethodBeat.i(132766);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    obtain.writeStrongBinder(lVar != null ? lVar.asBinder() : null);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (this.mRemote.transact(10, obtain, obtain2, 0) || a.bjJ() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132766);
                        return;
                    }
                    a.bjJ().a(lVar, i2, i3, str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132766);
                }
            }

            @Override // com.tencent.mm.network.t
            public final void a(f fVar, l lVar, int i2, int i3) {
                IBinder iBinder = null;
                AppMethodBeat.i(132767);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    obtain.writeStrongBinder(fVar != null ? fVar.asBinder() : null);
                    if (lVar != null) {
                        iBinder = lVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (this.mRemote.transact(11, obtain, obtain2, 0) || a.bjJ() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132767);
                        return;
                    }
                    a.bjJ().a(fVar, lVar, i2, i3);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132767);
                }
            }

            @Override // com.tencent.mm.network.t
            public final int aZq() {
                AppMethodBeat.i(132768);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && a.bjJ() != null) {
                        return a.bjJ().aZq();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132768);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132768);
                }
            }

            @Override // com.tencent.mm.network.t
            public final int getTimeOut() {
                AppMethodBeat.i(132769);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && a.bjJ() != null) {
                        return a.bjJ().getTimeOut();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132769);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132769);
                }
            }

            @Override // com.tencent.mm.network.t
            public final boolean isSingleSession() {
                boolean z = false;
                AppMethodBeat.i(132770);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    if (this.mRemote.transact(14, obtain, obtain2, 0) || a.bjJ() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132770);
                    } else {
                        z = a.bjJ().isSingleSession();
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132770);
                }
            }

            @Override // com.tencent.mm.network.t
            public final boolean getIsLongPolling() {
                boolean z = false;
                AppMethodBeat.i(197097);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    if (this.mRemote.transact(15, obtain, obtain2, 0) || a.bjJ() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(197097);
                    } else {
                        z = a.bjJ().getIsLongPolling();
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(197097);
                }
            }

            @Override // com.tencent.mm.network.t
            public final boolean aZr() {
                boolean z = false;
                AppMethodBeat.i(197098);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    if (this.mRemote.transact(16, obtain, obtain2, 0) || a.bjJ() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(197098);
                    } else {
                        z = a.bjJ().aZr();
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(197098);
                }
            }

            @Override // com.tencent.mm.network.t
            public final int getLongPollingTimeout() {
                AppMethodBeat.i(197099);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    if (!this.mRemote.transact(17, obtain, obtain2, 0) && a.bjJ() != null) {
                        return a.bjJ().getLongPollingTimeout();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(197099);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(197099);
                }
            }

            @Override // com.tencent.mm.network.t
            public final int getNewExtFlags() {
                AppMethodBeat.i(197100);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    if (!this.mRemote.transact(18, obtain, obtain2, 0) && a.bjJ() != null) {
                        return a.bjJ().getNewExtFlags();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(197100);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(197100);
                }
            }

            @Override // com.tencent.mm.network.t
            public final byte[] getTransHeader() {
                AppMethodBeat.i(197101);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    if (!this.mRemote.transact(19, obtain, obtain2, 0) && a.bjJ() != null) {
                        return a.bjJ().getTransHeader();
                    }
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(197101);
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(197101);
                }
            }

            @Override // com.tencent.mm.network.t
            public final String getCgiVerifyPublicKey() {
                AppMethodBeat.i(197102);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    if (!this.mRemote.transact(20, obtain, obtain2, 0) && a.bjJ() != null) {
                        return a.bjJ().getCgiVerifyPublicKey();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(197102);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(197102);
                }
            }

            @Override // com.tencent.mm.network.t
            public final String getCgiVerifyPrivateKey() {
                AppMethodBeat.i(197103);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    if (!this.mRemote.transact(21, obtain, obtain2, 0) && a.bjJ() != null) {
                        return a.bjJ().getCgiVerifyPrivateKey();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(197103);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(197103);
                }
            }
        }

        public static t bjJ() {
            return C0495a.jEb;
        }
    }
}
