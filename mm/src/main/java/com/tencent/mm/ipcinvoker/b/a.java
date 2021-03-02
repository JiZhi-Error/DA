package com.tencent.mm.ipcinvoker.b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b.b;

public interface a extends IInterface {
    void a(Bundle bundle, String str, b bVar);

    Bundle e(Bundle bundle, String str);

    /* renamed from: com.tencent.mm.ipcinvoker.b.a$a  reason: collision with other inner class name */
    public static abstract class AbstractBinderC0353a extends Binder implements a {
        public AbstractBinderC0353a() {
            attachInterface(this, "com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
        }

        public static a l(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0354a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            Bundle bundle;
            Bundle bundle2;
            b bVar = null;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    String readString = parcel.readString();
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeCallback");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                            bVar = new b.a.C0355a(readStrongBinder);
                        } else {
                            bVar = (b) queryLocalInterface;
                        }
                    }
                    a(bundle2, readString, bVar);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle = null;
                    }
                    Bundle e2 = e(bundle, parcel.readString());
                    parcel2.writeNoException();
                    if (e2 != null) {
                        parcel2.writeInt(1);
                        e2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.ipcinvoker.b.a$a$a  reason: collision with other inner class name */
        public static class C0354a implements a {
            public static a hnr;
            private IBinder mRemote;

            C0354a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.ipcinvoker.b.a
            public final void a(Bundle bundle, String str, b bVar) {
                IBinder iBinder = null;
                AppMethodBeat.i(158781);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (bVar != null) {
                        iBinder = bVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (this.mRemote.transact(1, obtain, null, 1) || AbstractBinderC0353a.ayh() == null) {
                        obtain.recycle();
                        AppMethodBeat.o(158781);
                        return;
                    }
                    AbstractBinderC0353a.ayh().a(bundle, str, bVar);
                } finally {
                    obtain.recycle();
                    AppMethodBeat.o(158781);
                }
            }

            @Override // com.tencent.mm.ipcinvoker.b.a
            public final Bundle e(Bundle bundle, String str) {
                Bundle bundle2;
                AppMethodBeat.i(158782);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || AbstractBinderC0353a.ayh() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                        } else {
                            bundle2 = null;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(158782);
                    } else {
                        bundle2 = AbstractBinderC0353a.ayh().e(bundle, str);
                    }
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(158782);
                }
            }
        }

        public static a ayh() {
            return C0354a.hnr;
        }
    }
}
