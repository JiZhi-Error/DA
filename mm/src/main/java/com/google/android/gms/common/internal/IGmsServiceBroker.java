package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.constraint.ConstraintLayout;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface IGmsServiceBroker extends IInterface {

    public static abstract class Stub extends Binder implements IGmsServiceBroker {

        /* access modifiers changed from: package-private */
        public static class zza implements IGmsServiceBroker {
            private final IBinder zza;

            zza(IBinder iBinder) {
                this.zza = iBinder;
            }

            public final IBinder asBinder() {
                return this.zza;
            }

            @Override // com.google.android.gms.common.internal.IGmsServiceBroker
            public final void getService(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest) {
                AppMethodBeat.i(4695);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(iGmsCallbacks != null ? iGmsCallbacks.asBinder() : null);
                    if (getServiceRequest != null) {
                        obtain.writeInt(1);
                        getServiceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zza.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(4695);
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
        }

        public static IGmsServiceBroker asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGmsServiceBroker)) ? new zza(iBinder) : (IGmsServiceBroker) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* access modifiers changed from: protected */
        public void getLegacyService(int i2, IGmsCallbacks iGmsCallbacks, int i3, String str, String str2, String[] strArr, Bundle bundle, IBinder iBinder, String str3, String str4) {
            throw new UnsupportedOperationException();
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            String str;
            String str2;
            IBinder iBinder;
            Bundle bundle;
            String[] strArr;
            String str3;
            if (i2 > 16777215) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            IGmsCallbacks asInterface = IGmsCallbacks.Stub.asInterface(parcel.readStrongBinder());
            if (i2 == 46) {
                getService(asInterface, parcel.readInt() != 0 ? GetServiceRequest.CREATOR.createFromParcel(parcel) : null);
            } else if (i2 == 47) {
                validateAccount(asInterface, parcel.readInt() != 0 ? ValidateAccountRequest.CREATOR.createFromParcel(parcel) : null);
            } else {
                int readInt = parcel.readInt();
                String readString = i2 != 4 ? parcel.readString() : null;
                switch (i2) {
                    case 1:
                        str2 = parcel.readString();
                        strArr = parcel.createStringArray();
                        str3 = parcel.readString();
                        if (parcel.readInt() == 0) {
                            str = null;
                            iBinder = null;
                            bundle = null;
                            break;
                        } else {
                            str = null;
                            iBinder = null;
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                            break;
                        }
                    case 2:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 23:
                    case 25:
                    case 27:
                    case 37:
                    case 38:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                    case 43:
                        if (parcel.readInt() != 0) {
                            str = null;
                            str2 = null;
                            iBinder = null;
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                            strArr = null;
                            str3 = null;
                            break;
                        }
                    case 3:
                    case 4:
                    case 21:
                    case 22:
                    case 24:
                    case 26:
                    case 28:
                    case 29:
                    case 31:
                    case 32:
                    case 33:
                    case 35:
                    case 36:
                    case 39:
                    case 40:
                    case 42:
                    default:
                        str = null;
                        str2 = null;
                        iBinder = null;
                        bundle = null;
                        strArr = null;
                        str3 = null;
                        break;
                    case 9:
                        str3 = parcel.readString();
                        strArr = parcel.createStringArray();
                        str2 = parcel.readString();
                        iBinder = parcel.readStrongBinder();
                        str = parcel.readString();
                        if (parcel.readInt() == 0) {
                            bundle = null;
                            break;
                        } else {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                            break;
                        }
                    case 10:
                        str3 = parcel.readString();
                        strArr = parcel.createStringArray();
                        str = null;
                        str2 = null;
                        iBinder = null;
                        bundle = null;
                        break;
                    case 19:
                        iBinder = parcel.readStrongBinder();
                        if (parcel.readInt() == 0) {
                            str = null;
                            str2 = null;
                            bundle = null;
                            strArr = null;
                            str3 = null;
                            break;
                        } else {
                            str = null;
                            str2 = null;
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                            strArr = null;
                            str3 = null;
                            break;
                        }
                    case 20:
                    case 30:
                        strArr = parcel.createStringArray();
                        str3 = parcel.readString();
                        if (parcel.readInt() == 0) {
                            str = null;
                            str2 = null;
                            iBinder = null;
                            bundle = null;
                            break;
                        } else {
                            str = null;
                            str2 = null;
                            iBinder = null;
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                            break;
                        }
                    case 34:
                        str3 = parcel.readString();
                        str = null;
                        str2 = null;
                        iBinder = null;
                        bundle = null;
                        strArr = null;
                        break;
                }
                getLegacyService(i2, asInterface, readInt, readString, str3, strArr, bundle, iBinder, str2, str);
            }
            parcel2.writeNoException();
            return true;
        }

        /* access modifiers changed from: protected */
        public void validateAccount(IGmsCallbacks iGmsCallbacks, ValidateAccountRequest validateAccountRequest) {
            throw new UnsupportedOperationException();
        }
    }

    void getService(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest);
}
