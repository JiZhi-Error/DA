package com.tencent.mm.plugin.webview.stub;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface c extends IInterface {
    boolean gdT();

    boolean getResult();

    int getRet();

    int getType();

    public static abstract class a extends Binder implements c {
        public a() {
            attachInterface(this, "com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
        }

        public static c G(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
                return new C1970a(iBinder);
            }
            return (c) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            int i4 = 0;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    boolean gdT = gdT();
                    parcel2.writeNoException();
                    if (gdT) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    boolean result = getResult();
                    parcel2.writeNoException();
                    if (result) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    int ret = getRet();
                    parcel2.writeNoException();
                    parcel2.writeInt(ret);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    int type = getType();
                    parcel2.writeNoException();
                    parcel2.writeInt(type);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.webview.stub.c$a$a  reason: collision with other inner class name */
        public static class C1970a implements c {
            public static c Jda;
            private IBinder mRemote;

            C1970a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.webview.stub.c
            public final boolean gdT() {
                boolean z = true;
                AppMethodBeat.i(79248);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.gdU() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() == 0) {
                            z = false;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79248);
                    } else {
                        z = a.gdU().gdT();
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79248);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.c
            public final boolean getResult() {
                boolean z = false;
                AppMethodBeat.i(79249);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || a.gdU() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79249);
                    } else {
                        z = a.gdU().getResult();
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79249);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.c
            public final int getRet() {
                AppMethodBeat.i(79250);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && a.gdU() != null) {
                        return a.gdU().getRet();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79250);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79250);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.c
            public final int getType() {
                AppMethodBeat.i(79251);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && a.gdU() != null) {
                        return a.gdU().getType();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79251);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79251);
                }
            }
        }

        public static c gdU() {
            return C1970a.Jda;
        }
    }
}
