package com.google.android.search.verification.a;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface a extends IInterface {
    boolean a(Intent intent, Bundle bundle);

    int getVersion();

    /* renamed from: com.google.android.search.verification.a.a$a  reason: collision with other inner class name */
    public static abstract class AbstractBinderC0118a extends Binder implements a {
        public static a g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.search.verification.api.ISearchActionVerificationService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0119a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            Intent intent;
            Bundle bundle;
            int i4;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.google.android.search.verification.api.ISearchActionVerificationService");
                    if (parcel.readInt() != 0) {
                        intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                    } else {
                        intent = null;
                    }
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle = null;
                    }
                    boolean a2 = a(intent, bundle);
                    parcel2.writeNoException();
                    if (a2) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.search.verification.api.ISearchActionVerificationService");
                    int version = getVersion();
                    parcel2.writeNoException();
                    parcel2.writeInt(version);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.search.verification.api.ISearchActionVerificationService");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* renamed from: com.google.android.search.verification.a.a$a$a  reason: collision with other inner class name */
        static class C0119a implements a {
            private IBinder mRemote;

            C0119a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.google.android.search.verification.a.a
            public final boolean a(Intent intent, Bundle bundle) {
                boolean z = true;
                AppMethodBeat.i(73440);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.search.verification.api.ISearchActionVerificationService");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(73440);
                }
            }

            @Override // com.google.android.search.verification.a.a
            public final int getVersion() {
                AppMethodBeat.i(73441);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.search.verification.api.ISearchActionVerificationService");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(73441);
                }
            }
        }
    }
}
