package com.google.firebase.iid;

import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.firebase_messaging.zze;
import com.google.android.gms.internal.firebase_messaging.zzf;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzi implements Parcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new z();
    private Messenger bMs;
    private zze bMt;

    public static final class a extends ClassLoader {
        /* access modifiers changed from: protected */
        @Override // java.lang.ClassLoader
        public final Class<?> loadClass(String str, boolean z) {
            AppMethodBeat.i(4220);
            if ("com.google.android.gms.iid.MessengerCompat".equals(str)) {
                FirebaseInstanceId.yg();
                AppMethodBeat.o(4220);
                return zzi.class;
            }
            Class<?> loadClass = super.loadClass(str, z);
            AppMethodBeat.o(4220);
            return loadClass;
        }
    }

    static {
        AppMethodBeat.i(4227);
        AppMethodBeat.o(4227);
    }

    public zzi(IBinder iBinder) {
        AppMethodBeat.i(4221);
        if (Build.VERSION.SDK_INT >= 21) {
            this.bMs = new Messenger(iBinder);
            AppMethodBeat.o(4221);
            return;
        }
        this.bMt = zzf.zza(iBinder);
        AppMethodBeat.o(4221);
    }

    private final IBinder getBinder() {
        AppMethodBeat.i(4223);
        if (this.bMs != null) {
            IBinder binder = this.bMs.getBinder();
            AppMethodBeat.o(4223);
            return binder;
        }
        IBinder asBinder = this.bMt.asBinder();
        AppMethodBeat.o(4223);
        return asBinder;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        AppMethodBeat.i(4224);
        if (obj == null) {
            AppMethodBeat.o(4224);
        } else {
            try {
                z = getBinder().equals(((zzi) obj).getBinder());
                AppMethodBeat.o(4224);
            } catch (ClassCastException e2) {
                AppMethodBeat.o(4224);
            }
        }
        return z;
    }

    public int hashCode() {
        AppMethodBeat.i(4225);
        int hashCode = getBinder().hashCode();
        AppMethodBeat.o(4225);
        return hashCode;
    }

    public final void send(Message message) {
        AppMethodBeat.i(4222);
        if (this.bMs != null) {
            this.bMs.send(message);
            AppMethodBeat.o(4222);
            return;
        }
        this.bMt.send(message);
        AppMethodBeat.o(4222);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(4226);
        if (this.bMs != null) {
            parcel.writeStrongBinder(this.bMs.getBinder());
            AppMethodBeat.o(4226);
            return;
        }
        parcel.writeStrongBinder(this.bMt.asBinder());
        AppMethodBeat.o(4226);
    }
}
