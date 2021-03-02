package com.tencent.mm.plugin.talkroom.component;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface d extends IInterface {
    void bgt();

    void ftI();

    int ftJ();

    void release();

    void start();

    public static abstract class a extends Binder implements d {
        public a() {
            attachInterface(this, "com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
        }

        public static d E(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof d)) {
                return new C1797a(iBinder);
            }
            return (d) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                    ftI();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                    bgt();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                    release();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                    int ftJ = ftJ();
                    parcel2.writeNoException();
                    parcel2.writeInt(ftJ);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                    start();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.talkroom.component.d$a$a  reason: collision with other inner class name */
        public static class C1797a implements d {
            public static d FOW;
            private IBinder mRemote;

            C1797a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.talkroom.component.d
            public final void ftI() {
                AppMethodBeat.i(29384);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.ftK() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(29384);
                        return;
                    }
                    a.ftK().ftI();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29384);
                }
            }

            @Override // com.tencent.mm.plugin.talkroom.component.d
            public final void bgt() {
                AppMethodBeat.i(29385);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || a.ftK() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(29385);
                        return;
                    }
                    a.ftK().bgt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29385);
                }
            }

            @Override // com.tencent.mm.plugin.talkroom.component.d
            public final void release() {
                AppMethodBeat.i(29386);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || a.ftK() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(29386);
                        return;
                    }
                    a.ftK().release();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29386);
                }
            }

            @Override // com.tencent.mm.plugin.talkroom.component.d
            public final int ftJ() {
                AppMethodBeat.i(29387);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && a.ftK() != null) {
                        return a.ftK().ftJ();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29387);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29387);
                }
            }

            @Override // com.tencent.mm.plugin.talkroom.component.d
            public final void start() {
                AppMethodBeat.i(29388);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || a.ftK() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(29388);
                        return;
                    }
                    a.ftK().start();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29388);
                }
            }
        }

        public static d ftK() {
            return C1797a.FOW;
        }
    }
}
