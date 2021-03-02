package com.tencent.mm.protocal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface ab extends IInterface {
    int ac(byte[] bArr);

    byte[] azB();

    byte[] azC();

    public static abstract class a extends Binder implements ab {
        public a() {
            attachInterface(this, "com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                    byte[] azB = azB();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(azB);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                    byte[] azC = azC();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(azC);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                    int ac = ac(parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(ac);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* renamed from: com.tencent.mm.protocal.ab$a$a  reason: collision with other inner class name */
        public static class C2036a implements ab {
            public static ab KAv;
            private IBinder mRemote;

            public C2036a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.protocal.ab
            public final byte[] azB() {
                AppMethodBeat.i(133129);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && a.gtQ() != null) {
                        return a.gtQ().azB();
                    }
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133129);
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133129);
                }
            }

            @Override // com.tencent.mm.protocal.ab
            public final byte[] azC() {
                AppMethodBeat.i(133130);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && a.gtQ() != null) {
                        return a.gtQ().azC();
                    }
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133130);
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133130);
                }
            }

            @Override // com.tencent.mm.protocal.ab
            public final int ac(byte[] bArr) {
                AppMethodBeat.i(133131);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                    obtain.writeByteArray(bArr);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && a.gtQ() != null) {
                        return a.gtQ().ac(bArr);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133131);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(133131);
                }
            }
        }

        public static ab gtQ() {
            return C2036a.KAv;
        }
    }
}
