package com.tencent.mm.sdcard_migrate;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface e extends IInterface {
    void a(ExtStorageMigrateConfig extStorageMigrateConfig);

    void a(MigrateResultCallback migrateResultCallback);

    void b(MigrateResultCallback migrateResultCallback);

    boolean gwS();

    void gwW();

    public static abstract class a extends Binder implements e {
        public a() {
            attachInterface(this, "com.tencent.mm.sdcard_migrate.IMigrateServiceController");
        }

        public static e N(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.sdcard_migrate.IMigrateServiceController");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof e)) {
                return new C2053a(iBinder);
            }
            return (e) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            ExtStorageMigrateConfig extStorageMigrateConfig = null;
            MigrateResultCallback migrateResultCallback = null;
            MigrateResultCallback migrateResultCallback2 = null;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateServiceController");
                    boolean gwS = gwS();
                    parcel2.writeNoException();
                    parcel2.writeInt(gwS ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateServiceController");
                    if (parcel.readInt() != 0) {
                        migrateResultCallback = MigrateResultCallback.CREATOR.createFromParcel(parcel);
                    }
                    a(migrateResultCallback);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateServiceController");
                    if (parcel.readInt() != 0) {
                        migrateResultCallback2 = MigrateResultCallback.CREATOR.createFromParcel(parcel);
                    }
                    b(migrateResultCallback2);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateServiceController");
                    if (parcel.readInt() != 0) {
                        extStorageMigrateConfig = ExtStorageMigrateConfig.CREATOR.createFromParcel(parcel);
                    }
                    a(extStorageMigrateConfig);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateServiceController");
                    gwW();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.sdcard_migrate.IMigrateServiceController");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.sdcard_migrate.e$a$a  reason: collision with other inner class name */
        public static class C2053a implements e {
            public static e NHD;
            private IBinder mRemote;

            C2053a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.sdcard_migrate.e
            public final boolean gwS() {
                boolean z = true;
                AppMethodBeat.i(204641);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateServiceController");
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.gxk() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() == 0) {
                            z = false;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(204641);
                    } else {
                        z = a.gxk().gwS();
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(204641);
                }
            }

            @Override // com.tencent.mm.sdcard_migrate.e
            public final void a(MigrateResultCallback migrateResultCallback) {
                AppMethodBeat.i(204642);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateServiceController");
                    if (migrateResultCallback != null) {
                        obtain.writeInt(1);
                        migrateResultCallback.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || a.gxk() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(204642);
                        return;
                    }
                    a.gxk().a(migrateResultCallback);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(204642);
                }
            }

            @Override // com.tencent.mm.sdcard_migrate.e
            public final void b(MigrateResultCallback migrateResultCallback) {
                AppMethodBeat.i(204643);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateServiceController");
                    if (migrateResultCallback != null) {
                        obtain.writeInt(1);
                        migrateResultCallback.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || a.gxk() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(204643);
                        return;
                    }
                    a.gxk().b(migrateResultCallback);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(204643);
                }
            }

            @Override // com.tencent.mm.sdcard_migrate.e
            public final void a(ExtStorageMigrateConfig extStorageMigrateConfig) {
                AppMethodBeat.i(204644);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateServiceController");
                    if (extStorageMigrateConfig != null) {
                        obtain.writeInt(1);
                        extStorageMigrateConfig.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || a.gxk() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(204644);
                        return;
                    }
                    a.gxk().a(extStorageMigrateConfig);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(204644);
                }
            }

            @Override // com.tencent.mm.sdcard_migrate.e
            public final void gwW() {
                AppMethodBeat.i(204645);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateServiceController");
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || a.gxk() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(204645);
                        return;
                    }
                    a.gxk().gwW();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(204645);
                }
            }
        }

        public static e gxk() {
            return C2053a.NHD;
        }
    }
}
