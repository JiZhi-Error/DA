package com.tencent.mm.plugin.webview.stub;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;

public interface f extends IInterface {
    boolean a(d dVar);

    boolean a(String str, String str2, Bundle bundle, boolean z);

    void aL(Bundle bundle);

    void aM(Bundle bundle);

    void aWP(String str);

    boolean afl(int i2);

    void e(String str, String str2, int i2, int i3);

    String ePp();

    boolean f(int i2, Bundle bundle);

    void fWV();

    String fWW();

    String fWX();

    int fWY();

    void fWZ();

    Bundle fl(String str, String str2);

    String getCurrentUrl();

    Bundle j(int i2, Bundle bundle);

    void lA(String str, String str2);

    void lz(String str, String str2);

    void t(int i2, Bundle bundle);

    void yL(boolean z);

    void yM(boolean z);

    void yN(boolean z);

    public static abstract class a extends Binder implements f {
        public a() {
            attachInterface(this, "com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        }

        public static f I(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof f)) {
                return new C1973a(iBinder);
            }
            return (f) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            boolean z;
            int i4;
            Bundle bundle = null;
            Bundle bundle2 = null;
            d aVar = null;
            Bundle bundle3 = null;
            Bundle bundle4 = null;
            Bundle bundle5 = null;
            Bundle bundle6 = null;
            boolean z2 = false;
            int i5 = 0;
            int i6 = 0;
            boolean z3 = false;
            boolean z4 = false;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    boolean afl = afl(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(afl ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    int readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    boolean f2 = f(readInt, bundle2);
                    parcel2.writeNoException();
                    if (f2) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    parcel2.writeInt(i4);
                    if (bundle2 != null) {
                        parcel2.writeInt(1);
                        bundle2.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof d)) {
                            aVar = new d.a.C1971a(readStrongBinder);
                        } else {
                            aVar = (d) queryLocalInterface;
                        }
                    }
                    boolean a2 = a(aVar);
                    parcel2.writeNoException();
                    if (a2) {
                        i5 = 1;
                    }
                    parcel2.writeInt(i5);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    if (parcel.readInt() != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean a3 = a(readString, readString2, bundle3, z);
                    parcel2.writeNoException();
                    if (a3) {
                        i6 = 1;
                    }
                    parcel2.writeInt(i6);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    String fWW = fWW();
                    parcel2.writeNoException();
                    parcel2.writeString(fWW);
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    String currentUrl = getCurrentUrl();
                    parcel2.writeNoException();
                    parcel2.writeString(currentUrl);
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    String ePp = ePp();
                    parcel2.writeNoException();
                    parcel2.writeString(ePp);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    String fWX = fWX();
                    parcel2.writeNoException();
                    parcel2.writeString(fWX);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    int fWY = fWY();
                    parcel2.writeNoException();
                    parcel2.writeInt(fWY);
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (parcel.readInt() != 0) {
                        z3 = true;
                    }
                    yL(z3);
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (parcel.readInt() != 0) {
                        z4 = true;
                    }
                    yM(z4);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    int readInt2 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle4 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    t(readInt2, bundle4);
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    fWV();
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (parcel.readInt() != 0) {
                        bundle5 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    aM(bundle5);
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    aWP(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    lz(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    fWZ();
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    e(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    int readInt3 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle6 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    Bundle j2 = j(readInt3, bundle6);
                    parcel2.writeNoException();
                    if (j2 != null) {
                        parcel2.writeInt(1);
                        j2.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 20:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    aL(bundle);
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (parcel.readInt() != 0) {
                        z2 = true;
                    }
                    yN(z2);
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    lA(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    Bundle fl = fl(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (fl != null) {
                        parcel2.writeInt(1);
                        fl.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.webview.stub.f$a$a  reason: collision with other inner class name */
        public static class C1973a implements f {
            public static f JdJ;
            private IBinder mRemote;

            C1973a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.webview.stub.f
            public final boolean afl(int i2) {
                boolean z = true;
                AppMethodBeat.i(79507);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.gen() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() == 0) {
                            z = false;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79507);
                    } else {
                        z = a.gen().afl(i2);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79507);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.f
            public final boolean f(int i2, Bundle bundle) {
                boolean z = true;
                AppMethodBeat.i(79508);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    obtain.writeInt(i2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || a.gen() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() == 0) {
                            z = false;
                        }
                        if (obtain2.readInt() != 0) {
                            bundle.readFromParcel(obtain2);
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79508);
                    } else {
                        z = a.gen().f(i2, bundle);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79508);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.f
            public final boolean a(d dVar) {
                boolean z = false;
                AppMethodBeat.i(79509);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || a.gen() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79509);
                    } else {
                        z = a.gen().a(dVar);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79509);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.f
            public final boolean a(String str, String str2, Bundle bundle, boolean z) {
                boolean z2 = true;
                AppMethodBeat.i(79510);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || a.gen() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() == 0) {
                            z2 = false;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79510);
                    } else {
                        z2 = a.gen().a(str, str2, bundle, z);
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79510);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.f
            public final String fWW() {
                AppMethodBeat.i(79511);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && a.gen() != null) {
                        return a.gen().fWW();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79511);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79511);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.f
            public final String getCurrentUrl() {
                AppMethodBeat.i(79512);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && a.gen() != null) {
                        return a.gen().getCurrentUrl();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79512);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79512);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.f
            public final String ePp() {
                AppMethodBeat.i(224511);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && a.gen() != null) {
                        return a.gen().ePp();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(224511);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(224511);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.f
            public final String fWX() {
                AppMethodBeat.i(79513);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && a.gen() != null) {
                        return a.gen().fWX();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79513);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79513);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.f
            public final int fWY() {
                AppMethodBeat.i(79514);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && a.gen() != null) {
                        return a.gen().fWY();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79514);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79514);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.f
            public final void yL(boolean z) {
                int i2 = 0;
                AppMethodBeat.i(79515);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(10, obtain, obtain2, 0) || a.gen() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79515);
                        return;
                    }
                    a.gen().yL(z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79515);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.f
            public final void yM(boolean z) {
                int i2 = 0;
                AppMethodBeat.i(79516);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(11, obtain, obtain2, 0) || a.gen() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79516);
                        return;
                    }
                    a.gen().yM(z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79516);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.f
            public final void t(int i2, Bundle bundle) {
                AppMethodBeat.i(79517);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    obtain.writeInt(i2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(12, obtain, obtain2, 0) || a.gen() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79517);
                        return;
                    }
                    a.gen().t(i2, bundle);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79517);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.f
            public final void fWV() {
                AppMethodBeat.i(79518);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (this.mRemote.transact(13, obtain, obtain2, 0) || a.gen() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79518);
                        return;
                    }
                    a.gen().fWV();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79518);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.f
            public final void aM(Bundle bundle) {
                AppMethodBeat.i(79519);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(14, obtain, obtain2, 0) || a.gen() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79519);
                        return;
                    }
                    a.gen().aM(bundle);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79519);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.f
            public final void aWP(String str) {
                AppMethodBeat.i(79520);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    obtain.writeString(str);
                    if (this.mRemote.transact(15, obtain, obtain2, 0) || a.gen() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79520);
                        return;
                    }
                    a.gen().aWP(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79520);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.f
            public final void lz(String str, String str2) {
                AppMethodBeat.i(79521);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(16, obtain, obtain2, 0) || a.gen() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79521);
                        return;
                    }
                    a.gen().lz(str, str2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79521);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.f
            public final void fWZ() {
                AppMethodBeat.i(79522);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (this.mRemote.transact(17, obtain, obtain2, 0) || a.gen() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79522);
                        return;
                    }
                    a.gen().fWZ();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79522);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.f
            public final void e(String str, String str2, int i2, int i3) {
                AppMethodBeat.i(79523);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (this.mRemote.transact(18, obtain, obtain2, 0) || a.gen() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79523);
                        return;
                    }
                    a.gen().e(str, str2, i2, i3);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79523);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.f
            public final Bundle j(int i2, Bundle bundle) {
                Bundle bundle2;
                AppMethodBeat.i(79524);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    obtain.writeInt(i2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(19, obtain, obtain2, 0) || a.gen() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                        } else {
                            bundle2 = null;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79524);
                    } else {
                        bundle2 = a.gen().j(i2, bundle);
                    }
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79524);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.f
            public final void aL(Bundle bundle) {
                AppMethodBeat.i(79525);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(20, obtain, obtain2, 0) || a.gen() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79525);
                        return;
                    }
                    a.gen().aL(bundle);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79525);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.f
            public final void yN(boolean z) {
                int i2 = 0;
                AppMethodBeat.i(79526);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(21, obtain, obtain2, 0) || a.gen() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79526);
                        return;
                    }
                    a.gen().yN(z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79526);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.f
            public final void lA(String str, String str2) {
                AppMethodBeat.i(79527);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(22, obtain, obtain2, 0) || a.gen() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79527);
                        return;
                    }
                    a.gen().lA(str, str2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79527);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.f
            public final Bundle fl(String str, String str2) {
                Bundle bundle;
                AppMethodBeat.i(79528);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(23, obtain, obtain2, 0) || a.gen() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                        } else {
                            bundle = null;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79528);
                    } else {
                        bundle = a.gen().fl(str, str2);
                    }
                    return bundle;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79528);
                }
            }
        }

        public static f gen() {
            return C1973a.JdJ;
        }
    }
}
