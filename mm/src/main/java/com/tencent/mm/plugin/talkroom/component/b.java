package com.tencent.mm.plugin.talkroom.component;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface b extends IInterface {
    void keep_OnError(int i2);

    void keep_OnOpenSuccess();

    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL");
                    keep_OnOpenSuccess();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL");
                    keep_OnError(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.talkroom.component.b$a$a  reason: collision with other inner class name */
        public static class C1795a implements b {
            public static b FOU;
            private IBinder mRemote;

            C1795a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.talkroom.component.b
            public final void keep_OnOpenSuccess() {
                AppMethodBeat.i(29381);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL");
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.ftG() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(29381);
                        return;
                    }
                    a.ftG().keep_OnOpenSuccess();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29381);
                }
            }

            @Override // com.tencent.mm.plugin.talkroom.component.b
            public final void keep_OnError(int i2) {
                AppMethodBeat.i(29382);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL");
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || a.ftG() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(29382);
                        return;
                    }
                    a.ftG().keep_OnError(i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29382);
                }
            }
        }

        public static b ftG() {
            return C1795a.FOU;
        }
    }
}
