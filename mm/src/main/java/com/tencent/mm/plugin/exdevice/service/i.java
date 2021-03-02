package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface i extends IInterface {
    void a(int i2, long j2, int i3, int i4, byte[] bArr);

    public static abstract class a extends Binder implements i {
        public a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IBTOnDeviceRequest_AIDL");
        }

        public static i x(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IBTOnDeviceRequest_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof i)) {
                return new C0988a(iBinder);
            }
            return (i) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTOnDeviceRequest_AIDL");
                    a(parcel.readInt(), parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.exdevice.service.IBTOnDeviceRequest_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.exdevice.service.i$a$a  reason: collision with other inner class name */
        public static class C0988a implements i {
            public static i rDI;
            private IBinder mRemote;

            C0988a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.exdevice.service.i
            public final void a(int i2, long j2, int i3, int i4, byte[] bArr) {
                AppMethodBeat.i(23679);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTOnDeviceRequest_AIDL");
                    obtain.writeInt(i2);
                    obtain.writeLong(j2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeByteArray(bArr);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.cLf() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23679);
                        return;
                    }
                    a.cLf().a(i2, j2, i3, i4, bArr);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23679);
                }
            }
        }

        public static i cLf() {
            return C0988a.rDI;
        }
    }
}
