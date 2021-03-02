package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface o extends IInterface {
    long cLk();

    byte[] cLl();

    int cLm();

    int cLn();

    int cLo();

    public static abstract class a extends Binder implements o {
        public a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
        }

        public static o B(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof o)) {
                return new C0993a(iBinder);
            }
            return (o) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                    long cLk = cLk();
                    parcel2.writeNoException();
                    parcel2.writeLong(cLk);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                    byte[] cLl = cLl();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(cLl);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                    int cLm = cLm();
                    parcel2.writeNoException();
                    parcel2.writeInt(cLm);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                    int cLn = cLn();
                    parcel2.writeNoException();
                    parcel2.writeInt(cLn);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                    int cLo = cLo();
                    parcel2.writeNoException();
                    parcel2.writeInt(cLo);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.exdevice.service.o$a$a  reason: collision with other inner class name */
        public static class C0993a implements o {
            public static o rDN;
            private IBinder mRemote;

            C0993a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.exdevice.service.o
            public final long cLk() {
                AppMethodBeat.i(23684);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && a.cLp() != null) {
                        return a.cLp().cLk();
                    }
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23684);
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23684);
                }
            }

            @Override // com.tencent.mm.plugin.exdevice.service.o
            public final byte[] cLl() {
                AppMethodBeat.i(23685);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && a.cLp() != null) {
                        return a.cLp().cLl();
                    }
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23685);
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23685);
                }
            }

            @Override // com.tencent.mm.plugin.exdevice.service.o
            public final int cLm() {
                AppMethodBeat.i(23686);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && a.cLp() != null) {
                        return a.cLp().cLm();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23686);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23686);
                }
            }

            @Override // com.tencent.mm.plugin.exdevice.service.o
            public final int cLn() {
                AppMethodBeat.i(23687);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && a.cLp() != null) {
                        return a.cLp().cLn();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23687);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23687);
                }
            }

            @Override // com.tencent.mm.plugin.exdevice.service.o
            public final int cLo() {
                AppMethodBeat.i(23688);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && a.cLp() != null) {
                        return a.cLp().cLo();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23688);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23688);
                }
            }
        }

        public static o cLp() {
            return C0993a.rDN;
        }
    }
}
