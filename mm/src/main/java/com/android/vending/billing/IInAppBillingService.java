package com.android.vending.billing;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface IInAppBillingService extends IInterface {
    Bundle a(int i2, String str, String str2, String str3, String str4);

    int b(int i2, String str, String str2);

    Bundle b(int i2, String str, String str2, String str3);

    int c(int i2, String str, String str2);

    Bundle getSkuDetails(int i2, String str, String str2, Bundle bundle);

    public static abstract class a extends Binder implements IInAppBillingService {
        public a() {
            attachInterface(this, "com.android.vending.billing.IInAppBillingService");
        }

        public static IInAppBillingService f(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IInAppBillingService)) {
                return new C0060a(iBinder);
            }
            return (IInAppBillingService) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            Bundle bundle;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    int b2 = b(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(b2);
                    return true;
                case 2:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    int readInt = parcel.readInt();
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle = null;
                    }
                    Bundle skuDetails = getSkuDetails(readInt, readString, readString2, bundle);
                    parcel2.writeNoException();
                    if (skuDetails != null) {
                        parcel2.writeInt(1);
                        skuDetails.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 3:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    Bundle a2 = a(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (a2 != null) {
                        parcel2.writeInt(1);
                        a2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    Bundle b3 = b(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (b3 != null) {
                        parcel2.writeInt(1);
                        b3.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 5:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    int c2 = c(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(c2);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.android.vending.billing.IInAppBillingService");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.android.vending.billing.IInAppBillingService$a$a  reason: collision with other inner class name */
        public static class C0060a implements IInAppBillingService {
            public static IInAppBillingService aCf;
            private IBinder mRemote;

            C0060a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public final int b(int i2, String str, String str2) {
                AppMethodBeat.i(63280);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && a.nL() != null) {
                        return a.nL().b(i2, str, str2);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(63280);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(63280);
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public final Bundle getSkuDetails(int i2, String str, String str2, Bundle bundle) {
                Bundle bundle2;
                AppMethodBeat.i(63281);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || a.nL() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                        } else {
                            bundle2 = null;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(63281);
                    } else {
                        bundle2 = a.nL().getSkuDetails(i2, str, str2, bundle);
                    }
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(63281);
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public final Bundle a(int i2, String str, String str2, String str3, String str4) {
                Bundle bundle;
                AppMethodBeat.i(63282);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || a.nL() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                        } else {
                            bundle = null;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(63282);
                    } else {
                        bundle = a.nL().a(i2, str, str2, str3, str4);
                    }
                    return bundle;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(63282);
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public final Bundle b(int i2, String str, String str2, String str3) {
                Bundle bundle;
                AppMethodBeat.i(63283);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || a.nL() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                        } else {
                            bundle = null;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(63283);
                    } else {
                        bundle = a.nL().b(i2, str, str2, str3);
                    }
                    return bundle;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(63283);
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public final int c(int i2, String str, String str2) {
                AppMethodBeat.i(63284);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && a.nL() != null) {
                        return a.nL().c(i2, str, str2);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(63284);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(63284);
                }
            }
        }

        public static IInAppBillingService nL() {
            return C0060a.aCf;
        }
    }
}
