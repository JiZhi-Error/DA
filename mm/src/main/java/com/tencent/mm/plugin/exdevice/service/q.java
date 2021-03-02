package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface q extends IInterface {
    void a(double d2, int i2, int i3, byte[] bArr, double d3, int i4, String str);

    public static abstract class a extends Binder implements q {
        public a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IIBeaconCallback_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IIBeaconCallback_AIDL");
                    a(parcel.readDouble(), parcel.readInt(), parcel.readInt(), parcel.createByteArray(), parcel.readDouble(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.exdevice.service.IIBeaconCallback_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.exdevice.service.q$a$a  reason: collision with other inner class name */
        public static class C0995a implements q {
            public static q rDP;
            private IBinder mRemote;

            C0995a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.exdevice.service.q
            public final void a(double d2, int i2, int i3, byte[] bArr, double d3, int i4, String str) {
                AppMethodBeat.i(23691);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IIBeaconCallback_AIDL");
                    obtain.writeDouble(d2);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeByteArray(bArr);
                    obtain.writeDouble(d3);
                    obtain.writeInt(i4);
                    obtain.writeString(str);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.cLt() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23691);
                        return;
                    }
                    a.cLt().a(d2, i2, i3, bArr, d3, i4, str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23691);
                }
            }
        }

        public static q cLt() {
            return C0995a.rDP;
        }
    }
}
