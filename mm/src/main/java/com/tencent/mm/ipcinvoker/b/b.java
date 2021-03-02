package com.tencent.mm.ipcinvoker.b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface b extends IInterface {
    void v(Bundle bundle);

    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeCallback");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            Bundle bundle;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeCallback");
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle = null;
                    }
                    v(bundle);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeCallback");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.ipcinvoker.b.b$a$a  reason: collision with other inner class name */
        public static class C0355a implements b {
            public static b hns;
            private IBinder mRemote;

            C0355a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.ipcinvoker.b.b
            public final void v(Bundle bundle) {
                AppMethodBeat.i(158783);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeCallback");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.ayi() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(158783);
                        return;
                    }
                    a.ayi().v(bundle);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(158783);
                }
            }
        }

        public static b ayi() {
            return C0355a.hns;
        }
    }
}
