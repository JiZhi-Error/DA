package com.google.android.gms.common.net;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.net.ISocketFactoryCreator;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class SocketFactoryCreator extends RemoteCreator<ISocketFactoryCreator> {
    private static SocketFactoryCreator zzvr;

    protected SocketFactoryCreator() {
        super("com.google.android.gms.common.net.SocketFactoryCreatorImpl");
    }

    public static SocketFactoryCreator getInstance() {
        AppMethodBeat.i(4952);
        if (zzvr == null) {
            zzvr = new SocketFactoryCreator();
        }
        SocketFactoryCreator socketFactoryCreator = zzvr;
        AppMethodBeat.o(4952);
        return socketFactoryCreator;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.RemoteCreator
    public ISocketFactoryCreator getRemoteCreator(IBinder iBinder) {
        AppMethodBeat.i(4951);
        ISocketFactoryCreator asInterface = ISocketFactoryCreator.Stub.asInterface(iBinder);
        AppMethodBeat.o(4951);
        return asInterface;
    }

    public SSLSocketFactory makeSocketFactory(Context context, KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, boolean z) {
        AppMethodBeat.i(4949);
        try {
            SSLSocketFactory sSLSocketFactory = (SSLSocketFactory) ObjectWrapper.unwrap(((ISocketFactoryCreator) getRemoteCreatorInstance(context)).newSocketFactory(ObjectWrapper.wrap(context), ObjectWrapper.wrap(keyManagerArr), ObjectWrapper.wrap(trustManagerArr), z));
            AppMethodBeat.o(4949);
            return sSLSocketFactory;
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            RuntimeException runtimeException = new RuntimeException(e2);
            AppMethodBeat.o(4949);
            throw runtimeException;
        }
    }

    public SSLSocketFactory makeSocketFactoryWithCacheDir(Context context, KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, String str) {
        AppMethodBeat.i(4950);
        try {
            SSLSocketFactory sSLSocketFactory = (SSLSocketFactory) ObjectWrapper.unwrap(((ISocketFactoryCreator) getRemoteCreatorInstance(context)).newSocketFactoryWithCacheDir(ObjectWrapper.wrap(context), ObjectWrapper.wrap(keyManagerArr), ObjectWrapper.wrap(trustManagerArr), str));
            AppMethodBeat.o(4950);
            return sSLSocketFactory;
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            RuntimeException runtimeException = new RuntimeException(e2);
            AppMethodBeat.o(4950);
            throw runtimeException;
        }
    }
}
