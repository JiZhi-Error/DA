package com.tencent.mm.plugin.talkroom.component;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface e extends IInterface {
    void cXa();

    void eYd();

    int ftJ();

    void release();

    void start();

    public static abstract class a extends Binder implements e {
        public a() {
            attachInterface(this, "com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
        }

        public static e F(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof e)) {
                return new C1798a(iBinder);
            }
            return (e) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
                    cXa();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
                    eYd();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
                    release();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
                    int ftJ = ftJ();
                    parcel2.writeNoException();
                    parcel2.writeInt(ftJ);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
                    start();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.talkroom.component.e$a$a  reason: collision with other inner class name */
        public static class C1798a implements e {
            public static e FOX;
            private IBinder mRemote;

            C1798a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.talkroom.component.e
            public final void cXa() {
                AppMethodBeat.i(29389);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.ftL() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(29389);
                        return;
                    }
                    a.ftL().cXa();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29389);
                }
            }

            @Override // com.tencent.mm.plugin.talkroom.component.e
            public final void eYd() {
                AppMethodBeat.i(29390);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || a.ftL() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(29390);
                        return;
                    }
                    a.ftL().eYd();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29390);
                }
            }

            @Override // com.tencent.mm.plugin.talkroom.component.e
            public final void release() {
                AppMethodBeat.i(29391);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || a.ftL() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(29391);
                        return;
                    }
                    a.ftL().release();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29391);
                }
            }

            @Override // com.tencent.mm.plugin.talkroom.component.e
            public final int ftJ() {
                AppMethodBeat.i(29392);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && a.ftL() != null) {
                        return a.ftL().ftJ();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29392);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29392);
                }
            }

            @Override // com.tencent.mm.plugin.talkroom.component.e
            public final void start() {
                AppMethodBeat.i(29393);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || a.ftL() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(29393);
                        return;
                    }
                    a.ftL().start();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(29393);
                }
            }
        }

        public static e ftL() {
            return C1798a.FOX;
        }
    }
}
