package com.tencent.mm.plugin.appbrand.v;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.v.b;

public interface a extends IInterface {
    void a(b bVar);

    int yo(int i2);

    /* renamed from: com.tencent.mm.plugin.appbrand.v.a$a  reason: collision with other inner class name */
    public static abstract class AbstractBinderC0815a extends Binder implements a {
        public AbstractBinderC0815a() {
            attachInterface(this, "com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCall");
        }

        public static a s(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCall");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0816a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            b aVar;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCall");
                    int yo = yo(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(yo);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCall");
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder == null) {
                        aVar = null;
                    } else {
                        IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCallback");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                            aVar = new b.a.C0817a(readStrongBinder);
                        } else {
                            aVar = (b) queryLocalInterface;
                        }
                    }
                    a(aVar);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCall");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.appbrand.v.a$a$a  reason: collision with other inner class name */
        public static class C0816a implements a {
            public static a nFB;
            private IBinder mRemote;

            C0816a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.appbrand.v.a
            public final int yo(int i2) {
                AppMethodBeat.i(47999);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCall");
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && AbstractBinderC0815a.bUa() != null) {
                        return AbstractBinderC0815a.bUa().yo(i2);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(47999);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(47999);
                }
            }

            @Override // com.tencent.mm.plugin.appbrand.v.a
            public final void a(b bVar) {
                AppMethodBeat.i(48000);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCall");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || AbstractBinderC0815a.bUa() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(48000);
                        return;
                    }
                    AbstractBinderC0815a.bUa().a(bVar);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(48000);
                }
            }
        }

        public static a bUa() {
            return C0816a.nFB;
        }
    }
}
