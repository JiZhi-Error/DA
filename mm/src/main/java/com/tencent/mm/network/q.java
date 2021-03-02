package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface q extends IInterface {
    void a(long j2, String str, boolean z, boolean z2);

    public static abstract class a extends Binder implements q {
        public a() {
            attachInterface(this, "com.tencent.mm.network.IOnReportKV_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            boolean z;
            boolean z2;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.network.IOnReportKV_AIDL");
                    long readLong = parcel.readLong();
                    String readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (parcel.readInt() != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    a(readLong, readString, z, z2);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.network.IOnReportKV_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.network.q$a$a  reason: collision with other inner class name */
        public static class C0494a implements q {
            public static q jDY;
            private IBinder mRemote;

            C0494a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.network.q
            public final void a(long j2, String str, boolean z, boolean z2) {
                int i2 = 1;
                AppMethodBeat.i(132748);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IOnReportKV_AIDL");
                    obtain.writeLong(j2);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.bjI() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(132748);
                        return;
                    }
                    a.bjI().a(j2, str, z, z2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(132748);
                }
            }
        }

        public static q bjI() {
            return C0494a.jDY;
        }
    }
}
