package com.tencent.mm.sdcard_migrate;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdcard_migrate.util.ExtStorageMigrateException;

public interface d extends IInterface {
    void ajH(int i2);

    void ajI(int i2);

    void b(int i2, ExtStorageMigrateException extStorageMigrateException);

    void gxi();

    void kJ(int i2, int i3);

    void mN(String str, String str2);

    public static abstract class a extends Binder implements d {
        public a() {
            attachInterface(this, "com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
        }

        public static d M(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof d)) {
                return new C2052a(iBinder);
            }
            return (d) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            ExtStorageMigrateException extStorageMigrateException;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
                    ajH(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
                    mN(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
                    ajI(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
                    int readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        extStorageMigrateException = ExtStorageMigrateException.CREATOR.createFromParcel(parcel);
                    } else {
                        extStorageMigrateException = null;
                    }
                    b(readInt, extStorageMigrateException);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
                    gxi();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
                    kJ(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.sdcard_migrate.d$a$a  reason: collision with other inner class name */
        public static class C2052a implements d {
            public static d NHC;
            private IBinder mRemote;

            C2052a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.sdcard_migrate.d
            public final void ajH(int i2) {
                AppMethodBeat.i(204635);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.gxj() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(204635);
                        return;
                    }
                    a.gxj().ajH(i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(204635);
                }
            }

            @Override // com.tencent.mm.sdcard_migrate.d
            public final void mN(String str, String str2) {
                AppMethodBeat.i(204636);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || a.gxj() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(204636);
                        return;
                    }
                    a.gxj().mN(str, str2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(204636);
                }
            }

            @Override // com.tencent.mm.sdcard_migrate.d
            public final void ajI(int i2) {
                AppMethodBeat.i(204637);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || a.gxj() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(204637);
                        return;
                    }
                    a.gxj().ajI(i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(204637);
                }
            }

            @Override // com.tencent.mm.sdcard_migrate.d
            public final void b(int i2, ExtStorageMigrateException extStorageMigrateException) {
                AppMethodBeat.i(204638);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
                    obtain.writeInt(i2);
                    if (extStorageMigrateException != null) {
                        obtain.writeInt(1);
                        extStorageMigrateException.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || a.gxj() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(204638);
                        return;
                    }
                    a.gxj().b(i2, extStorageMigrateException);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(204638);
                }
            }

            @Override // com.tencent.mm.sdcard_migrate.d
            public final void gxi() {
                AppMethodBeat.i(204639);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || a.gxj() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(204639);
                        return;
                    }
                    a.gxj().gxi();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(204639);
                }
            }

            @Override // com.tencent.mm.sdcard_migrate.d
            public final void kJ(int i2, int i3) {
                AppMethodBeat.i(204640);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || a.gxj() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(204640);
                        return;
                    }
                    a.gxj().kJ(i2, i3);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(204640);
                }
            }
        }

        public static d gxj() {
            return C2052a.NHC;
        }
    }
}
