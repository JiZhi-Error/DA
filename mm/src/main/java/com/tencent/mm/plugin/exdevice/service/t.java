package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface t extends IInterface {
    void b(long j2, int i2, int i3, String str);

    public static abstract class a extends Binder implements t {
        public a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.ISimpleBTOnSendEnd_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnSendEnd_AIDL");
                    b(parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnSendEnd_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.exdevice.service.t$a$a  reason: collision with other inner class name */
        public static class C0997a implements t {
            public static t rDR;
            private IBinder mRemote;

            C0997a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.exdevice.service.t
            public final void b(long j2, int i2, int i3, String str) {
                AppMethodBeat.i(23693);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnSendEnd_AIDL");
                    obtain.writeLong(j2);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.cLv() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23693);
                        return;
                    }
                    a.cLv().b(j2, i2, i3, str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23693);
                }
            }
        }

        public static t cLv() {
            return C0997a.rDR;
        }
    }
}
