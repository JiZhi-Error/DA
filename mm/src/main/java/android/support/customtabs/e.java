package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.customtabs.d;

public interface e extends IInterface {
    boolean a(d dVar);

    boolean aK();

    Bundle aN();

    boolean b(d dVar);

    boolean c(d dVar);

    boolean d(d dVar);

    int e(d dVar);

    boolean f(d dVar);

    public static abstract class a extends Binder implements e {
        public a() {
            attachInterface(this, "android.support.customtabs.ICustomTabsService");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            int i4 = 0;
            switch (i2) {
                case 2:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    parcel.readLong();
                    boolean aK = aK();
                    parcel2.writeNoException();
                    if (aK) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 3:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    boolean a2 = a(d.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (a2) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 4:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    d a3 = d.a.a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        Uri.CREATOR.createFromParcel(parcel);
                    }
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel.createTypedArrayList(Bundle.CREATOR);
                    boolean b2 = b(a3);
                    parcel2.writeNoException();
                    if (b2) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 5:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    Bundle aN = aN();
                    parcel2.writeNoException();
                    if (aN != null) {
                        parcel2.writeInt(1);
                        aN.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 6:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    d a4 = d.a.a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    boolean c2 = c(a4);
                    parcel2.writeNoException();
                    if (c2) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 7:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    d a5 = d.a.a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        Uri.CREATOR.createFromParcel(parcel);
                    }
                    boolean d2 = d(a5);
                    parcel2.writeNoException();
                    if (d2) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 8:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    d a6 = d.a.a(parcel.readStrongBinder());
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    int e2 = e(a6);
                    parcel2.writeNoException();
                    parcel2.writeInt(e2);
                    return true;
                case 9:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    d a7 = d.a.a(parcel.readStrongBinder());
                    parcel.readInt();
                    if (parcel.readInt() != 0) {
                        Uri.CREATOR.createFromParcel(parcel);
                    }
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    boolean f2 = f(a7);
                    parcel2.writeNoException();
                    if (f2) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 1598968902:
                    parcel2.writeString("android.support.customtabs.ICustomTabsService");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }
    }
}
