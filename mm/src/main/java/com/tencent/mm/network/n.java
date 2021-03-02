package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.t;

public interface n extends IInterface {
    void a(int i2, int i3, int i4, String str, t tVar, byte[] bArr);

    public static abstract class a extends Binder implements n {
        public a() {
            attachInterface(this, "com.tencent.mm.network.IOnGYNetEnd_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.network.IOnGYNetEnd_AIDL");
                    a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), t.a.q(parcel.readStrongBinder()), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.network.IOnGYNetEnd_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.network.n$a$a  reason: collision with other inner class name */
        public static class C0492a implements n {
            public static n jDW;
            private IBinder mRemote;

            C0492a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.network.n
            public final void a(int i2, int i3, int i4, String str, t tVar, byte[] bArr) {
                AppMethodBeat.i(132746);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IOnGYNetEnd_AIDL");
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(tVar != null ? tVar.asBinder() : null);
                    obtain.writeByteArray(bArr);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.bjH() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132746);
                        return;
                    }
                    a.bjH().a(i2, i3, i4, str, tVar, bArr);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132746);
                }
            }
        }

        public static n bjH() {
            return C0492a.jDW;
        }
    }
}
