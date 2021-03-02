package com.tencent.mm.service;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.service.a;

public interface b extends IInterface {
    void a(Intent intent, a aVar);

    void bs(Intent intent);

    void bw(Intent intent);

    void startService(Intent intent);

    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "com.tencent.mm.service.IMMServiceStub_AIDL");
        }

        public static b P(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.service.IMMServiceStub_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new C2061a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            Intent intent;
            Intent intent2;
            Intent intent3;
            Intent intent4;
            a aVar = null;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.service.IMMServiceStub_AIDL");
                    if (parcel.readInt() != 0) {
                        intent4 = (Intent) Intent.CREATOR.createFromParcel(parcel);
                    } else {
                        intent4 = null;
                    }
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.service.IMMServiceConnectionStub_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                            aVar = new a.AbstractBinderC2059a.C2060a(readStrongBinder);
                        } else {
                            aVar = (a) queryLocalInterface;
                        }
                    }
                    a(intent4, aVar);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.service.IMMServiceStub_AIDL");
                    if (parcel.readInt() != 0) {
                        intent3 = (Intent) Intent.CREATOR.createFromParcel(parcel);
                    } else {
                        intent3 = null;
                    }
                    bw(intent3);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.service.IMMServiceStub_AIDL");
                    if (parcel.readInt() != 0) {
                        intent2 = (Intent) Intent.CREATOR.createFromParcel(parcel);
                    } else {
                        intent2 = null;
                    }
                    startService(intent2);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.service.IMMServiceStub_AIDL");
                    if (parcel.readInt() != 0) {
                        intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                    } else {
                        intent = null;
                    }
                    bs(intent);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.service.IMMServiceStub_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.service.b$a$a  reason: collision with other inner class name */
        public static class C2061a implements b {
            public static b NJW;
            private IBinder mRemote;

            C2061a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.service.b
            public final void a(Intent intent, a aVar) {
                AppMethodBeat.i(125305);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.service.IMMServiceStub_AIDL");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.gxE() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(125305);
                        return;
                    }
                    a.gxE().a(intent, aVar);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(125305);
                }
            }

            @Override // com.tencent.mm.service.b
            public final void bw(Intent intent) {
                AppMethodBeat.i(125306);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.service.IMMServiceStub_AIDL");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || a.gxE() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(125306);
                        return;
                    }
                    a.gxE().bw(intent);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(125306);
                }
            }

            @Override // com.tencent.mm.service.b
            public final void startService(Intent intent) {
                AppMethodBeat.i(125307);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.service.IMMServiceStub_AIDL");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || a.gxE() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(125307);
                        return;
                    }
                    a.gxE().startService(intent);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(125307);
                }
            }

            @Override // com.tencent.mm.service.b
            public final void bs(Intent intent) {
                AppMethodBeat.i(125308);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.service.IMMServiceStub_AIDL");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || a.gxE() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(125308);
                        return;
                    }
                    a.gxE().bs(intent);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(125308);
                }
            }
        }

        public static b gxE() {
            return C2061a.NJW;
        }
    }
}
