package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.t;

public interface l extends IInterface {
    void a(t tVar, int i2, int i3, String str);

    public static abstract class a extends Binder implements l {
        public a() {
            attachInterface(this, "com.tencent.mm.network.IOnAutoAuth_AIDL");
        }

        public static l p(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.network.IOnAutoAuth_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof l)) {
                return new C0491a(iBinder);
            }
            return (l) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.network.IOnAutoAuth_AIDL");
                    a(t.a.q(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.network.IOnAutoAuth_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.network.l$a$a  reason: collision with other inner class name */
        public static class C0491a implements l {
            public static l jDV;
            private IBinder mRemote;

            C0491a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.network.l
            public final void a(t tVar, int i2, int i3, String str) {
                AppMethodBeat.i(132745);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IOnAutoAuth_AIDL");
                    obtain.writeStrongBinder(tVar != null ? tVar.asBinder() : null);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.bjG() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132745);
                        return;
                    }
                    a.bjG().a(tVar, i2, i3, str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132745);
                }
            }
        }

        public static l bjG() {
            return C0491a.jDV;
        }
    }
}
