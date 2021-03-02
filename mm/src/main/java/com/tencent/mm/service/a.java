package com.tencent.mm.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface a extends IInterface {
    void O(IBinder iBinder);

    /* renamed from: com.tencent.mm.service.a$a  reason: collision with other inner class name */
    public static abstract class AbstractBinderC2059a extends Binder implements a {
        public AbstractBinderC2059a() {
            attachInterface(this, "com.tencent.mm.service.IMMServiceConnectionStub_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.service.IMMServiceConnectionStub_AIDL");
                    O(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.service.IMMServiceConnectionStub_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.service.a$a$a  reason: collision with other inner class name */
        public static class C2060a implements a {
            public static a NJV;
            private IBinder mRemote;

            C2060a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.service.a
            public final void O(IBinder iBinder) {
                AppMethodBeat.i(125304);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.service.IMMServiceConnectionStub_AIDL");
                    obtain.writeStrongBinder(iBinder);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || AbstractBinderC2059a.gxD() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(125304);
                        return;
                    }
                    AbstractBinderC2059a.gxD().O(iBinder);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(125304);
                }
            }
        }

        public static a gxD() {
            return C2060a.NJV;
        }
    }
}
