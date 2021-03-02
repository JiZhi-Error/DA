package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ao {
    final zzi bMP;
    final Messenger bMs;

    ao(IBinder iBinder) {
        AppMethodBeat.i(4270);
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.bMs = new Messenger(iBinder);
            this.bMP = null;
            AppMethodBeat.o(4270);
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.bMP = new zzi(iBinder);
            this.bMs = null;
            AppMethodBeat.o(4270);
        } else {
            String valueOf = String.valueOf(interfaceDescriptor);
            if (valueOf.length() != 0) {
                "Invalid interface descriptor: ".concat(valueOf);
            } else {
                new String("Invalid interface descriptor: ");
            }
            RemoteException remoteException = new RemoteException();
            AppMethodBeat.o(4270);
            throw remoteException;
        }
    }
}
