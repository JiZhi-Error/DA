package com.tencent.mm.plugin.cdndownloader.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface b extends IInterface {
    void f(String str, int i2, int i3, String str2);

    void w(String str, long j2, long j3);

    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadServiceCallback");
        }

        public static b v(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadServiceCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new C0921a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadServiceCallback");
                    f(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadServiceCallback");
                    w(parcel.readString(), parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadServiceCallback");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.cdndownloader.a.b$a$a  reason: collision with other inner class name */
        public static class C0921a implements b {
            public static b qmp;
            private IBinder mRemote;

            C0921a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.cdndownloader.a.b
            public final void f(String str, int i2, int i3, String str2) {
                AppMethodBeat.i(120704);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadServiceCallback");
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.cxY() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(120704);
                        return;
                    }
                    a.cxY().f(str, i2, i3, str2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(120704);
                }
            }

            @Override // com.tencent.mm.plugin.cdndownloader.a.b
            public final void w(String str, long j2, long j3) {
                AppMethodBeat.i(120705);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadServiceCallback");
                    obtain.writeString(str);
                    obtain.writeLong(j2);
                    obtain.writeLong(j3);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || a.cxY() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(120705);
                        return;
                    }
                    a.cxY().w(str, j2, j3);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(120705);
                }
            }
        }

        public static b cxY() {
            return C0921a.qmp;
        }
    }
}
