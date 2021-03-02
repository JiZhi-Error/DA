package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface p extends IInterface {
    void onNetworkChange(int i2);

    public static abstract class a extends Binder implements p {
        private static final String DESCRIPTOR = "com.tencent.mm.network.IOnNetworkChange_AIDL";
        static final int TRANSACTION_onNetworkChange = 1;

        public a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static p asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof p)) {
                return new C0493a(iBinder);
            }
            return (p) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    onNetworkChange(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.network.p$a$a  reason: collision with other inner class name */
        public static class C0493a implements p {
            public static p jDX;
            private IBinder mRemote;

            C0493a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.network.p
            public final void onNetworkChange(int i2) {
                AppMethodBeat.i(132747);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132747);
                        return;
                    }
                    a.getDefaultImpl().onNetworkChange(i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132747);
                }
            }
        }

        public static boolean setDefaultImpl(p pVar) {
            if (C0493a.jDX != null || pVar == null) {
                return false;
            }
            C0493a.jDX = pVar;
            return true;
        }

        public static p getDefaultImpl() {
            return C0493a.jDX;
        }
    }
}
