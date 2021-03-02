package com.tencent.mm.plugin.cdndownloader.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cdndownloader.a.b;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;

public interface a extends IInterface {
    void EL(int i2);

    int a(CDNTaskInfo cDNTaskInfo);

    void a(b bVar);

    boolean akr(String str);

    boolean aks(String str);

    CDNTaskState akt(String str);

    int b(CDNTaskInfo cDNTaskInfo);

    void b(b bVar);

    void cxU();

    void cxV();

    void cxW();

    /* renamed from: com.tencent.mm.plugin.cdndownloader.a.a$a  reason: collision with other inner class name */
    public static abstract class AbstractBinderC0919a extends Binder implements a {
        public AbstractBinderC0919a() {
            attachInterface(this, "com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
        }

        public static a u(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0920a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            CDNTaskInfo cDNTaskInfo = null;
            int i4 = 0;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    if (parcel.readInt() != 0) {
                        cDNTaskInfo = CDNTaskInfo.CREATOR.createFromParcel(parcel);
                    }
                    int a2 = a(cDNTaskInfo);
                    parcel2.writeNoException();
                    parcel2.writeInt(a2);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    if (parcel.readInt() != 0) {
                        cDNTaskInfo = CDNTaskInfo.CREATOR.createFromParcel(parcel);
                    }
                    int b2 = b(cDNTaskInfo);
                    parcel2.writeNoException();
                    parcel2.writeInt(b2);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    boolean akr = akr(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(akr ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    boolean aks = aks(parcel.readString());
                    parcel2.writeNoException();
                    if (aks) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    CDNTaskState akt = akt(parcel.readString());
                    parcel2.writeNoException();
                    if (akt != null) {
                        parcel2.writeInt(1);
                        akt.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    a(b.a.v(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    b(b.a.v(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    EL(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    cxU();
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    cxV();
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    cxW();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.cdndownloader.a.a$a$a  reason: collision with other inner class name */
        public static class C0920a implements a {
            public static a qmo;
            private IBinder mRemote;

            C0920a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.cdndownloader.a.a
            public final int a(CDNTaskInfo cDNTaskInfo) {
                AppMethodBeat.i(120693);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    if (cDNTaskInfo != null) {
                        obtain.writeInt(1);
                        cDNTaskInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && AbstractBinderC0919a.cxX() != null) {
                        return AbstractBinderC0919a.cxX().a(cDNTaskInfo);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(120693);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(120693);
                }
            }

            @Override // com.tencent.mm.plugin.cdndownloader.a.a
            public final int b(CDNTaskInfo cDNTaskInfo) {
                AppMethodBeat.i(120694);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    if (cDNTaskInfo != null) {
                        obtain.writeInt(1);
                        cDNTaskInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && AbstractBinderC0919a.cxX() != null) {
                        return AbstractBinderC0919a.cxX().b(cDNTaskInfo);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(120694);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(120694);
                }
            }

            @Override // com.tencent.mm.plugin.cdndownloader.a.a
            public final boolean akr(String str) {
                boolean z = false;
                AppMethodBeat.i(120695);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    obtain.writeString(str);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || AbstractBinderC0919a.cxX() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(120695);
                    } else {
                        z = AbstractBinderC0919a.cxX().akr(str);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(120695);
                }
            }

            @Override // com.tencent.mm.plugin.cdndownloader.a.a
            public final boolean aks(String str) {
                boolean z = false;
                AppMethodBeat.i(120696);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    obtain.writeString(str);
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || AbstractBinderC0919a.cxX() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(120696);
                    } else {
                        z = AbstractBinderC0919a.cxX().aks(str);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(120696);
                }
            }

            @Override // com.tencent.mm.plugin.cdndownloader.a.a
            public final CDNTaskState akt(String str) {
                CDNTaskState cDNTaskState;
                AppMethodBeat.i(120697);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    obtain.writeString(str);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || AbstractBinderC0919a.cxX() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            cDNTaskState = CDNTaskState.CREATOR.createFromParcel(obtain2);
                        } else {
                            cDNTaskState = null;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(120697);
                    } else {
                        cDNTaskState = AbstractBinderC0919a.cxX().akt(str);
                    }
                    return cDNTaskState;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(120697);
                }
            }

            @Override // com.tencent.mm.plugin.cdndownloader.a.a
            public final void a(b bVar) {
                AppMethodBeat.i(120698);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || AbstractBinderC0919a.cxX() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(120698);
                        return;
                    }
                    AbstractBinderC0919a.cxX().a(bVar);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(120698);
                }
            }

            @Override // com.tencent.mm.plugin.cdndownloader.a.a
            public final void b(b bVar) {
                AppMethodBeat.i(120699);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (this.mRemote.transact(7, obtain, obtain2, 0) || AbstractBinderC0919a.cxX() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(120699);
                        return;
                    }
                    AbstractBinderC0919a.cxX().b(bVar);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(120699);
                }
            }

            @Override // com.tencent.mm.plugin.cdndownloader.a.a
            public final void EL(int i2) {
                AppMethodBeat.i(120700);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(8, obtain, obtain2, 0) || AbstractBinderC0919a.cxX() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(120700);
                        return;
                    }
                    AbstractBinderC0919a.cxX().EL(i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(120700);
                }
            }

            @Override // com.tencent.mm.plugin.cdndownloader.a.a
            public final void cxU() {
                AppMethodBeat.i(120701);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    if (this.mRemote.transact(9, obtain, obtain2, 0) || AbstractBinderC0919a.cxX() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(120701);
                        return;
                    }
                    AbstractBinderC0919a.cxX().cxU();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(120701);
                }
            }

            @Override // com.tencent.mm.plugin.cdndownloader.a.a
            public final void cxV() {
                AppMethodBeat.i(120702);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    if (this.mRemote.transact(10, obtain, obtain2, 0) || AbstractBinderC0919a.cxX() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(120702);
                        return;
                    }
                    AbstractBinderC0919a.cxX().cxV();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(120702);
                }
            }

            @Override // com.tencent.mm.plugin.cdndownloader.a.a
            public final void cxW() {
                AppMethodBeat.i(120703);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    if (this.mRemote.transact(11, obtain, obtain2, 0) || AbstractBinderC0919a.cxX() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(120703);
                        return;
                    }
                    AbstractBinderC0919a.cxX().cxW();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(120703);
                }
            }
        }

        public static a cxX() {
            return C0920a.qmo;
        }
    }
}
