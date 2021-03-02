package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface u extends IInterface {
    boolean check();

    public static abstract class a extends Binder implements u {
        public a() {
            attachInterface(this, "com.tencent.mm.network.IWorkerCallback_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.network.IWorkerCallback_AIDL");
                    boolean check = check();
                    parcel2.writeNoException();
                    parcel2.writeInt(check ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.network.IWorkerCallback_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.network.u$a$a  reason: collision with other inner class name */
        public static class C0496a implements u {
            public static u jEc;
            private IBinder mRemote;

            C0496a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.network.u
            public final boolean check() {
                boolean z = true;
                AppMethodBeat.i(132771);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IWorkerCallback_AIDL");
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.bjK() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() == 0) {
                            z = false;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132771);
                    } else {
                        z = a.bjK().check();
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132771);
                }
            }
        }

        public static u bjK() {
            return C0496a.jEc;
        }
    }
}
