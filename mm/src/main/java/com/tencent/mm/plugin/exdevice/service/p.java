package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.l;
import com.tencent.mm.plugin.exdevice.service.o;

public interface p extends IInterface {
    o cLq();

    l cLr();

    public static abstract class a extends Binder implements p {
        public a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
        }

        public static p C(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof p)) {
                return new C0994a(iBinder);
            }
            return (p) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            IBinder iBinder = null;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
                    o cLq = cLq();
                    parcel2.writeNoException();
                    if (cLq != null) {
                        iBinder = cLq.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
                    l cLr = cLr();
                    parcel2.writeNoException();
                    if (cLr != null) {
                        iBinder = cLr.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.exdevice.service.p$a$a  reason: collision with other inner class name */
        public static class C0994a implements p {
            public static p rDO;
            private IBinder mRemote;

            C0994a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.exdevice.service.p
            public final o cLq() {
                AppMethodBeat.i(23689);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && a.cLs() != null) {
                        return a.cLs().cLq();
                    }
                    obtain2.readException();
                    o B = o.a.B(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23689);
                    return B;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23689);
                }
            }

            @Override // com.tencent.mm.plugin.exdevice.service.p
            public final l cLr() {
                AppMethodBeat.i(23690);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && a.cLs() != null) {
                        return a.cLs().cLr();
                    }
                    obtain2.readException();
                    l A = l.a.A(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23690);
                    return A;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23690);
                }
            }
        }

        public static p cLs() {
            return C0994a.rDO;
        }
    }
}
