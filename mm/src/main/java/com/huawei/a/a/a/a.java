package com.huawei.a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public interface a extends IInterface {
    String IC();

    int cw(String str);

    String d(String str, Map map);

    String e(Map map);

    String f(Map map);

    String g(Map map);

    String h(Map map);

    String i(Map map);

    String j(Map map);

    String k(Map map);

    String n(String str, int i2);

    /* renamed from: com.huawei.a.a.a.a$a  reason: collision with other inner class name */
    public static abstract class AbstractBinderC0122a extends Binder implements a {
        public static a h(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0123a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
                    int cw = cw(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(cw);
                    return true;
                case 2:
                    parcel.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
                    String IC = IC();
                    parcel2.writeNoException();
                    parcel2.writeString(IC);
                    return true;
                case 3:
                    parcel.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
                    String e2 = e(parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    parcel2.writeString(e2);
                    return true;
                case 4:
                    parcel.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
                    String f2 = f(parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    parcel2.writeString(f2);
                    return true;
                case 5:
                    parcel.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
                    String g2 = g(parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    parcel2.writeString(g2);
                    return true;
                case 6:
                    parcel.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
                    String n = n(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(n);
                    return true;
                case 7:
                    parcel.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
                    String h2 = h(parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    parcel2.writeString(h2);
                    return true;
                case 8:
                    parcel.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
                    String i4 = i(parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    parcel2.writeString(i4);
                    return true;
                case 9:
                    parcel.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
                    String j2 = j(parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    parcel2.writeString(j2);
                    return true;
                case 10:
                    parcel.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
                    String k = k(parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    parcel2.writeString(k);
                    return true;
                case 11:
                    parcel.enforceInterface("com.huawei.nfc.sdk.service.IHwTransitOpenService");
                    String d2 = d(parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    parcel2.writeString(d2);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.huawei.nfc.sdk.service.IHwTransitOpenService");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.huawei.a.a.a.a$a$a  reason: collision with other inner class name */
        public static class C0123a implements a {
            public static a cfP;
            private IBinder mRemote;

            C0123a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.a.a.a.a
            public final int cw(String str) {
                AppMethodBeat.i(226023);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && AbstractBinderC0122a.ID() != null) {
                        return AbstractBinderC0122a.ID().cw(str);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(226023);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(226023);
                }
            }

            @Override // com.huawei.a.a.a.a
            public final String IC() {
                AppMethodBeat.i(226024);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && AbstractBinderC0122a.ID() != null) {
                        return AbstractBinderC0122a.ID().IC();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(226024);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(226024);
                }
            }

            @Override // com.huawei.a.a.a.a
            public final String e(Map map) {
                AppMethodBeat.i(226025);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
                    obtain.writeMap(map);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && AbstractBinderC0122a.ID() != null) {
                        return AbstractBinderC0122a.ID().e(map);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(226025);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(226025);
                }
            }

            @Override // com.huawei.a.a.a.a
            public final String f(Map map) {
                AppMethodBeat.i(226026);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
                    obtain.writeMap(map);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && AbstractBinderC0122a.ID() != null) {
                        return AbstractBinderC0122a.ID().f(map);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(226026);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(226026);
                }
            }

            @Override // com.huawei.a.a.a.a
            public final String g(Map map) {
                AppMethodBeat.i(226027);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
                    obtain.writeMap(map);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && AbstractBinderC0122a.ID() != null) {
                        return AbstractBinderC0122a.ID().g(map);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(226027);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(226027);
                }
            }

            @Override // com.huawei.a.a.a.a
            public final String n(String str, int i2) {
                AppMethodBeat.i(226028);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && AbstractBinderC0122a.ID() != null) {
                        return AbstractBinderC0122a.ID().n(str, i2);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(226028);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(226028);
                }
            }

            @Override // com.huawei.a.a.a.a
            public final String h(Map map) {
                AppMethodBeat.i(226029);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
                    obtain.writeMap(map);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && AbstractBinderC0122a.ID() != null) {
                        return AbstractBinderC0122a.ID().h(map);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(226029);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(226029);
                }
            }

            @Override // com.huawei.a.a.a.a
            public final String i(Map map) {
                AppMethodBeat.i(226030);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
                    obtain.writeMap(map);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && AbstractBinderC0122a.ID() != null) {
                        return AbstractBinderC0122a.ID().i(map);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(226030);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(226030);
                }
            }

            @Override // com.huawei.a.a.a.a
            public final String j(Map map) {
                AppMethodBeat.i(226031);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
                    obtain.writeMap(map);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && AbstractBinderC0122a.ID() != null) {
                        return AbstractBinderC0122a.ID().j(map);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(226031);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(226031);
                }
            }

            @Override // com.huawei.a.a.a.a
            public final String k(Map map) {
                AppMethodBeat.i(226032);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
                    obtain.writeMap(map);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && AbstractBinderC0122a.ID() != null) {
                        return AbstractBinderC0122a.ID().k(map);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(226032);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(226032);
                }
            }

            @Override // com.huawei.a.a.a.a
            public final String d(String str, Map map) {
                AppMethodBeat.i(226033);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwTransitOpenService");
                    obtain.writeString(str);
                    obtain.writeMap(map);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && AbstractBinderC0122a.ID() != null) {
                        return AbstractBinderC0122a.ID().d(str, map);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(226033);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(226033);
                }
            }
        }

        public static a ID() {
            return C0123a.cfP;
        }
    }
}
