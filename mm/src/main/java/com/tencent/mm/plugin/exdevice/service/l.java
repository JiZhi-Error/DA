package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.p;

public interface l extends IInterface {
    void a(long j2, int i2, int i3, String str, p pVar);

    public static abstract class a extends Binder implements l {
        public a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IBTOnTaskEnd_AIDL");
        }

        public static l A(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IBTOnTaskEnd_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof l)) {
                return new C0991a(iBinder);
            }
            return (l) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTOnTaskEnd_AIDL");
                    a(parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readString(), p.a.C(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.exdevice.service.IBTOnTaskEnd_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.exdevice.service.l$a$a  reason: collision with other inner class name */
        public static class C0991a implements l {
            public static l rDL;
            private IBinder mRemote;

            C0991a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.exdevice.service.l
            public final void a(long j2, int i2, int i3, String str, p pVar) {
                AppMethodBeat.i(23682);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTOnTaskEnd_AIDL");
                    obtain.writeLong(j2);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(pVar != null ? pVar.asBinder() : null);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.cLi() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(23682);
                        return;
                    }
                    a.cLi().a(j2, i2, i3, str, pVar);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(23682);
                }
            }
        }

        public static l cLi() {
            return C0991a.rDL;
        }
    }
}
