package com.google.android.gms.iid;

import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MessengerCompat implements ReflectedParcelable {
    public static final Parcelable.Creator<MessengerCompat> CREATOR = new zzq();
    private Messenger zzab;
    private zzl zzby;

    static {
        AppMethodBeat.i(2481);
        AppMethodBeat.o(2481);
    }

    public MessengerCompat(IBinder iBinder) {
        zzl zzm;
        AppMethodBeat.i(2475);
        if (Build.VERSION.SDK_INT >= 21) {
            this.zzab = new Messenger(iBinder);
            AppMethodBeat.o(2475);
            return;
        }
        if (iBinder == null) {
            zzm = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
            zzm = queryLocalInterface instanceof zzl ? (zzl) queryLocalInterface : new zzm(iBinder);
        }
        this.zzby = zzm;
        AppMethodBeat.o(2475);
    }

    private final IBinder getBinder() {
        AppMethodBeat.i(2477);
        if (this.zzab != null) {
            IBinder binder = this.zzab.getBinder();
            AppMethodBeat.o(2477);
            return binder;
        }
        IBinder asBinder = this.zzby.asBinder();
        AppMethodBeat.o(2477);
        return asBinder;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        AppMethodBeat.i(2478);
        if (obj == null) {
            AppMethodBeat.o(2478);
        } else {
            try {
                z = getBinder().equals(((MessengerCompat) obj).getBinder());
                AppMethodBeat.o(2478);
            } catch (ClassCastException e2) {
                AppMethodBeat.o(2478);
            }
        }
        return z;
    }

    public int hashCode() {
        AppMethodBeat.i(2479);
        int hashCode = getBinder().hashCode();
        AppMethodBeat.o(2479);
        return hashCode;
    }

    public final void send(Message message) {
        AppMethodBeat.i(2476);
        if (this.zzab != null) {
            this.zzab.send(message);
            AppMethodBeat.o(2476);
            return;
        }
        this.zzby.send(message);
        AppMethodBeat.o(2476);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(2480);
        if (this.zzab != null) {
            parcel.writeStrongBinder(this.zzab.getBinder());
            AppMethodBeat.o(2480);
            return;
        }
        parcel.writeStrongBinder(this.zzby.asBinder());
        AppMethodBeat.o(2480);
    }
}
