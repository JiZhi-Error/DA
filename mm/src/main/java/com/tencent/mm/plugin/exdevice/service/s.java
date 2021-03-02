package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface s extends IInterface {
    void c(long j2, byte[] bArr);

    public static abstract class a extends Binder implements s {
        public a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.ISimpleBTOnRecv_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnRecv_AIDL");
                    c(parcel.readLong(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnRecv_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.exdevice.service.s$a$a  reason: collision with other inner class name */
        public static class C0996a implements s {
            public static s rDQ;
            private IBinder mRemote;

            C0996a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.exdevice.service.s
            public final void c(long j2, byte[] bArr) {
                AppMethodBeat.i(23692);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnRecv_AIDL");
                    obtain.writeLong(j2);
                    obtain.writeByteArray(bArr);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.cLu() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23692);
                        return;
                    }
                    a.cLu().c(j2, bArr);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23692);
                }
            }
        }

        public static s cLu() {
            return C0996a.rDQ;
        }
    }
}
