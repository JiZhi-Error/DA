package com.tencent.mm.remoteservice;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface b extends IInterface {
    void onCallback(String str, Bundle bundle, boolean z);

    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "com.tencent.mm.remoteservice.ICommClientCallback");
        }

        public static b asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.remoteservice.ICommClientCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new C2046a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            Bundle bundle;
            boolean z;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.remoteservice.ICommClientCallback");
                    String readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle = null;
                    }
                    if (parcel.readInt() != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    onCallback(readString, bundle, z);
                    parcel2.writeNoException();
                    if (bundle != null) {
                        parcel2.writeInt(1);
                        bundle.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.remoteservice.ICommClientCallback");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.remoteservice.b$a$a  reason: collision with other inner class name */
        public static class C2046a implements b {
            public static b NCx;
            private IBinder mRemote;

            C2046a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.remoteservice.b
            public final void onCallback(String str, Bundle bundle, boolean z) {
                int i2 = 1;
                AppMethodBeat.i(152739);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.remoteservice.ICommClientCallback");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.getDefaultImpl() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            bundle.readFromParcel(obtain2);
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(152739);
                        return;
                    }
                    a.getDefaultImpl().onCallback(str, bundle, z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(152739);
                }
            }
        }

        public static boolean setDefaultImpl(b bVar) {
            if (C2046a.NCx != null || bVar == null) {
                return false;
            }
            C2046a.NCx = bVar;
            return true;
        }

        public static b getDefaultImpl() {
            return C2046a.NCx;
        }
    }
}
