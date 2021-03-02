package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface k extends IInterface {
    void a(long j2, int i2, int i3, int i4, long j3);

    public static abstract class a extends Binder implements k {
        public a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IBTOnStateChange_AIDL");
        }

        public static k z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IBTOnStateChange_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof k)) {
                return new C0990a(iBinder);
            }
            return (k) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTOnStateChange_AIDL");
                    a(parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.exdevice.service.IBTOnStateChange_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.exdevice.service.k$a$a  reason: collision with other inner class name */
        public static class C0990a implements k {
            public static k rDK;
            private IBinder mRemote;

            C0990a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.exdevice.service.k
            public final void a(long j2, int i2, int i3, int i4, long j3) {
                AppMethodBeat.i(23681);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTOnStateChange_AIDL");
                    obtain.writeLong(j2);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeLong(j3);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.cLh() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23681);
                        return;
                    }
                    a.cLh().a(j2, i2, i3, i4, j3);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23681);
                }
            }
        }

        public static k cLh() {
            return C0990a.rDK;
        }
    }
}
