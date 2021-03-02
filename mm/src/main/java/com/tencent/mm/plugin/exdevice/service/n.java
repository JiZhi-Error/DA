package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface n extends IInterface {
    Bundle n(int i2, Bundle bundle);

    public static abstract class a extends Binder implements n {
        public a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IExDeviceInvoker_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            Bundle bundle;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceInvoker_AIDL");
                    int readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle = null;
                    }
                    Bundle n = n(readInt, bundle);
                    parcel2.writeNoException();
                    if (n != null) {
                        parcel2.writeInt(1);
                        n.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.exdevice.service.IExDeviceInvoker_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.exdevice.service.n$a$a  reason: collision with other inner class name */
        public static class C0992a implements n {
            public static n rDM;
            private IBinder mRemote;

            C0992a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.exdevice.service.n
            public final Bundle n(int i2, Bundle bundle) {
                Bundle bundle2;
                AppMethodBeat.i(23683);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceInvoker_AIDL");
                    obtain.writeInt(i2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.cLj() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                        } else {
                            bundle2 = null;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23683);
                    } else {
                        bundle2 = a.cLj().n(i2, bundle);
                    }
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23683);
                }
            }
        }

        public static n cLj() {
            return C0992a.rDM;
        }
    }
}
