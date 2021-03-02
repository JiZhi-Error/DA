package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface j extends IInterface {
    void networkAnalysisCallBack(int i2, int i3, boolean z, String str);

    public static abstract class a extends Binder implements j {
        public a() {
            attachInterface(this, "com.tencent.mm.network.INetworkDiagnoseCallback_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.network.INetworkDiagnoseCallback_AIDL");
                    networkAnalysisCallBack(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.network.INetworkDiagnoseCallback_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.network.j$a$a  reason: collision with other inner class name */
        public static class C0489a implements j {
            public static j jDT;
            private IBinder mRemote;

            C0489a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.network.j
            public final void networkAnalysisCallBack(int i2, int i3, boolean z, String str) {
                int i4 = 1;
                AppMethodBeat.i(132739);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.INetworkDiagnoseCallback_AIDL");
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (!z) {
                        i4 = 0;
                    }
                    obtain.writeInt(i4);
                    obtain.writeString(str);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.bjB() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132739);
                        return;
                    }
                    a.bjB().networkAnalysisCallBack(i2, i3, z, str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132739);
                }
            }
        }

        public static j bjB() {
            return C0489a.jDT;
        }
    }
}
