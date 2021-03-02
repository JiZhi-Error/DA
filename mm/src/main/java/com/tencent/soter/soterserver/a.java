package com.tencent.soter.soterserver;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface a extends IInterface {
    SoterSignResult OC(long j2);

    SoterSessionResult ab(int i2, String str, String str2);

    int aqG(int i2);

    SoterExportResult aqH(int i2);

    boolean aqI(int i2);

    int aqJ(int i2);

    int ds(int i2, String str);

    int dt(int i2, String str);

    SoterExportResult du(int i2, String str);

    boolean dv(int i2, String str);

    int getVersion();

    SoterDeviceResult hlB();

    /* renamed from: com.tencent.soter.soterserver.a$a  reason: collision with other inner class name */
    public static abstract class AbstractBinderC2193a extends Binder implements a {
        public static a Q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.soter.soterserver.ISoterService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C2194a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            int i4 = 0;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    int aqG = aqG(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(aqG);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    SoterExportResult aqH = aqH(parcel.readInt());
                    parcel2.writeNoException();
                    if (aqH != null) {
                        parcel2.writeInt(1);
                        aqH.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    boolean aqI = aqI(parcel.readInt());
                    parcel2.writeNoException();
                    if (aqI) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    int ds = ds(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(ds);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    int dt = dt(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(dt);
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    SoterExportResult du = du(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    if (du != null) {
                        parcel2.writeInt(1);
                        du.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    int aqJ = aqJ(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(aqJ);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    boolean dv = dv(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    if (dv) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    SoterSessionResult ab = ab(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (ab != null) {
                        parcel2.writeInt(1);
                        ab.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    SoterSignResult OC = OC(parcel.readLong());
                    parcel2.writeNoException();
                    if (OC != null) {
                        parcel2.writeInt(1);
                        OC.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    SoterDeviceResult hlB = hlB();
                    parcel2.writeNoException();
                    if (hlB != null) {
                        parcel2.writeInt(1);
                        hlB.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    int version = getVersion();
                    parcel2.writeNoException();
                    parcel2.writeInt(version);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.soter.soterserver.ISoterService");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.soter.soterserver.a$a$a  reason: collision with other inner class name */
        public static class C2194a implements a {
            private IBinder mRemote;

            C2194a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.soter.soterserver.a
            public final int aqG(int i2) {
                AppMethodBeat.i(88727);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i2);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88727);
                }
            }

            @Override // com.tencent.soter.soterserver.a
            public final SoterExportResult aqH(int i2) {
                SoterExportResult soterExportResult;
                AppMethodBeat.i(88728);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i2);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        soterExportResult = SoterExportResult.CREATOR.createFromParcel(obtain2);
                    } else {
                        soterExportResult = null;
                    }
                    return soterExportResult;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88728);
                }
            }

            @Override // com.tencent.soter.soterserver.a
            public final boolean aqI(int i2) {
                boolean z = false;
                AppMethodBeat.i(88729);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i2);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88729);
                }
            }

            @Override // com.tencent.soter.soterserver.a
            public final int ds(int i2, String str) {
                AppMethodBeat.i(88730);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88730);
                }
            }

            @Override // com.tencent.soter.soterserver.a
            public final int dt(int i2, String str) {
                AppMethodBeat.i(88731);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88731);
                }
            }

            @Override // com.tencent.soter.soterserver.a
            public final SoterExportResult du(int i2, String str) {
                SoterExportResult soterExportResult;
                AppMethodBeat.i(88732);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        soterExportResult = SoterExportResult.CREATOR.createFromParcel(obtain2);
                    } else {
                        soterExportResult = null;
                    }
                    return soterExportResult;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88732);
                }
            }

            @Override // com.tencent.soter.soterserver.a
            public final int aqJ(int i2) {
                AppMethodBeat.i(88733);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i2);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88733);
                }
            }

            @Override // com.tencent.soter.soterserver.a
            public final boolean dv(int i2, String str) {
                boolean z = false;
                AppMethodBeat.i(88734);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88734);
                }
            }

            @Override // com.tencent.soter.soterserver.a
            public final SoterSessionResult ab(int i2, String str, String str2) {
                SoterSessionResult soterSessionResult;
                AppMethodBeat.i(88735);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        soterSessionResult = SoterSessionResult.CREATOR.createFromParcel(obtain2);
                    } else {
                        soterSessionResult = null;
                    }
                    return soterSessionResult;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88735);
                }
            }

            @Override // com.tencent.soter.soterserver.a
            public final SoterSignResult OC(long j2) {
                SoterSignResult soterSignResult;
                AppMethodBeat.i(88736);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
                    obtain.writeLong(j2);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        soterSignResult = SoterSignResult.CREATOR.createFromParcel(obtain2);
                    } else {
                        soterSignResult = null;
                    }
                    return soterSignResult;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88736);
                }
            }

            @Override // com.tencent.soter.soterserver.a
            public final SoterDeviceResult hlB() {
                SoterDeviceResult soterDeviceResult;
                AppMethodBeat.i(88737);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        soterDeviceResult = SoterDeviceResult.CREATOR.createFromParcel(obtain2);
                    } else {
                        soterDeviceResult = null;
                    }
                    return soterDeviceResult;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88737);
                }
            }

            @Override // com.tencent.soter.soterserver.a
            public final int getVersion() {
                AppMethodBeat.i(88738);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(88738);
                }
            }
        }
    }
}
