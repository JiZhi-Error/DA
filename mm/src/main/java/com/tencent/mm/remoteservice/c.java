package com.tencent.mm.remoteservice;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.remoteservice.b;

public interface c extends IInterface {
    void a(String str, String str2, Bundle bundle, b bVar);

    public static abstract class a extends Binder implements c {
        public a() {
            attachInterface(this, "com.tencent.mm.remoteservice.ICommRemoteServer");
        }

        public static c L(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.remoteservice.ICommRemoteServer");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
                return new C2047a(iBinder);
            }
            return (c) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            Bundle bundle;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.remoteservice.ICommRemoteServer");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle = null;
                    }
                    a(readString, readString2, bundle, b.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (bundle != null) {
                        parcel2.writeInt(1);
                        bundle.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.remoteservice.ICommRemoteServer");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.remoteservice.c$a$a  reason: collision with other inner class name */
        public static class C2047a implements c {
            public static c NCy;
            private IBinder mRemote;

            C2047a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.remoteservice.c
            public final void a(String str, String str2, Bundle bundle, b bVar) {
                AppMethodBeat.i(152740);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.remoteservice.ICommRemoteServer");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.gvb() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            bundle.readFromParcel(obtain2);
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(152740);
                        return;
                    }
                    a.gvb().a(str, str2, bundle, bVar);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(152740);
                }
            }
        }

        public static c gvb() {
            return C2047a.NCy;
        }
    }
}
