package com.tencent.mm.plugin.appbrand.v;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface b extends IInterface {
    void t(IBinder iBinder);

    void zb(int i2);

    public static abstract class a extends Binder implements b {
        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCallback");
                    zb(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCallback");
                    t(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCallback");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.appbrand.v.b$a$a  reason: collision with other inner class name */
        public static class C0817a implements b {
            public static b nFC;
            private IBinder mRemote;

            C0817a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.appbrand.v.b
            public final void zb(int i2) {
                AppMethodBeat.i(48001);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCallback");
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.bUb() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(48001);
                        return;
                    }
                    a.bUb().zb(i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(48001);
                }
            }

            @Override // com.tencent.mm.plugin.appbrand.v.b
            public final void t(IBinder iBinder) {
                AppMethodBeat.i(227363);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.appbrand.preloading.IAppBrandProgressTriggerCallback");
                    obtain.writeStrongBinder(iBinder);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || a.bUb() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(227363);
                        return;
                    }
                    a.bUb().t(iBinder);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(227363);
                }
            }
        }

        public static b bUb() {
            return C0817a.nFC;
        }
    }
}
