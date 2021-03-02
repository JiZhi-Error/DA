package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface j extends IInterface {
    void a(int i2, int i3, String str, String str2, String str3, int i4, byte[] bArr);

    public static abstract class a extends Binder implements j {
        public a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IBTOnScanCallback_AIDL");
        }

        public static j y(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IBTOnScanCallback_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof j)) {
                return new C0989a(iBinder);
            }
            return (j) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTOnScanCallback_AIDL");
                    a(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.exdevice.service.IBTOnScanCallback_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.exdevice.service.j$a$a  reason: collision with other inner class name */
        public static class C0989a implements j {
            public static j rDJ;
            private IBinder mRemote;

            C0989a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.exdevice.service.j
            public final void a(int i2, int i3, String str, String str2, String str3, int i4, byte[] bArr) {
                AppMethodBeat.i(23680);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTOnScanCallback_AIDL");
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeInt(i4);
                    obtain.writeByteArray(bArr);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.cLg() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23680);
                        return;
                    }
                    a.cLg().a(i2, i3, str, str2, str3, i4, bArr);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23680);
                }
            }
        }

        public static j cLg() {
            return C0989a.rDJ;
        }
    }
}
