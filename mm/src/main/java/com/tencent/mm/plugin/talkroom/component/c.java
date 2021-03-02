package com.tencent.mm.plugin.talkroom.component;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface c extends IInterface {
    void E(int i2, int i3, boolean z);

    public static abstract class a extends Binder implements c {
        public a() {
            attachInterface(this, "com.tencent.mm.plugin.talkroom.component.IMemberUpdateCallback_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMemberUpdateCallback_AIDL");
                    E(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.talkroom.component.IMemberUpdateCallback_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.talkroom.component.c$a$a  reason: collision with other inner class name */
        public static class C1796a implements c {
            public static c FOV;
            private IBinder mRemote;

            C1796a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.talkroom.component.c
            public final void E(int i2, int i3, boolean z) {
                int i4 = 1;
                AppMethodBeat.i(29383);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IMemberUpdateCallback_AIDL");
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (!z) {
                        i4 = 0;
                    }
                    obtain.writeInt(i4);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.ftH() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(29383);
                        return;
                    }
                    a.ftH().E(i2, i3, z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29383);
                }
            }
        }

        public static c ftH() {
            return C1796a.FOV;
        }
    }
}
