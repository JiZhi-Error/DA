package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface d extends IInterface {
    void N(Bundle bundle);

    void O(Bundle bundle);

    void a(IBinder iBinder, String str);

    public static abstract class a extends Binder implements d {
        public a() {
            attachInterface(this, "com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
        }

        public static d r(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof d)) {
                return new C0592a(iBinder);
            }
            return (d) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            Bundle bundle = null;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    N(bundle);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    O(bundle);
                    parcel2.writeNoException();
                    if (bundle != null) {
                        parcel2.writeInt(1);
                        bundle.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
                    a(parcel.readStrongBinder(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.appbrand.ipc.d$a$a  reason: collision with other inner class name */
        public static class C0592a implements d {
            public static d lwO;
            private IBinder mRemote;

            C0592a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.appbrand.ipc.d
            public final void N(Bundle bundle) {
                AppMethodBeat.i(140617);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, null, 1) || a.bDS() == null) {
                        obtain.recycle();
                        AppMethodBeat.o(140617);
                        return;
                    }
                    a.bDS().N(bundle);
                } finally {
                    obtain.recycle();
                    AppMethodBeat.o(140617);
                }
            }

            @Override // com.tencent.mm.plugin.appbrand.ipc.d
            public final void O(Bundle bundle) {
                AppMethodBeat.i(140618);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || a.bDS() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            bundle.readFromParcel(obtain2);
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(140618);
                        return;
                    }
                    a.bDS().O(bundle);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(140618);
                }
            }

            @Override // com.tencent.mm.plugin.appbrand.ipc.d
            public final void a(IBinder iBinder, String str) {
                AppMethodBeat.i(140619);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || a.bDS() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(140619);
                        return;
                    }
                    a.bDS().a(iBinder, str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(140619);
                }
            }
        }

        public static d bDS() {
            return C0592a.lwO;
        }
    }
}
