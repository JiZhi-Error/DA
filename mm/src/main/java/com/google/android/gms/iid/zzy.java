package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzy {
    final Messenger zzab;
    final MessengerCompat zzcj;

    zzy(IBinder iBinder) {
        AppMethodBeat.i(2571);
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.zzab = new Messenger(iBinder);
            this.zzcj = null;
            AppMethodBeat.o(2571);
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.zzcj = new MessengerCompat(iBinder);
            this.zzab = null;
            AppMethodBeat.o(2571);
        } else {
            String valueOf = String.valueOf(interfaceDescriptor);
            if (valueOf.length() != 0) {
                "Invalid interface descriptor: ".concat(valueOf);
            } else {
                new String("Invalid interface descriptor: ");
            }
            RemoteException remoteException = new RemoteException();
            AppMethodBeat.o(2571);
            throw remoteException;
        }
    }
}
