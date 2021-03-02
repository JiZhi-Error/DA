package com.tencent.mm.plugin.sns.ad.remote.ipc.impl;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.plugin.sns.ad.remote.ipc.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;

public final class a implements com.tencent.mm.plugin.sns.ad.remote.ipc.a, b {
    public com.tencent.mm.plugin.sns.ad.remote.a.b Dxq;
    public com.tencent.mm.plugin.sns.ad.remote.a.a Dxr;
    public IPCRemoteProxy Dxs;

    @Override // com.tencent.mm.plugin.sns.ad.remote.ipc.a
    public final Bundle aA(Bundle bundle) {
        String str;
        AppMethodBeat.i(202065);
        if (bundle != null) {
            if (this.Dxq != null) {
                str = this.Dxq.getClass().getName();
            } else {
                str = "";
            }
            bundle.putCharSequence("key_server_class", str);
            if (this.Dxs != null) {
                Object REMOTE_CALL = this.Dxs.REMOTE_CALL("calledOnServer", getClass().getName(), bundle);
                if (REMOTE_CALL instanceof Bundle) {
                    Bundle bundle2 = (Bundle) REMOTE_CALL;
                    AppMethodBeat.o(202065);
                    return bundle2;
                }
            }
            AppMethodBeat.o(202065);
            return null;
        }
        Log.w("SimpleRemoteRequest", "the input args is null, are you sure?");
        AppMethodBeat.o(202065);
        return null;
    }

    @Override // com.tencent.mm.plugin.sns.ad.remote.ipc.b
    public final void aB(Bundle bundle) {
        AppMethodBeat.i(202066);
        if (this.Dxs != null) {
            this.Dxs.CLIENT_CALL("callbackFromServer", bundle);
        }
        AppMethodBeat.o(202066);
    }

    static Object aNN(String str) {
        AppMethodBeat.i(202067);
        try {
            Object newInstance = Class.forName(str).newInstance();
            AppMethodBeat.o(202067);
            return newInstance;
        } catch (Throwable th) {
            AppMethodBeat.o(202067);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean eXA() {
        com.tencent.mm.plugin.sns.ad.remote.b bVar;
        AppMethodBeat.i(202068);
        com.tencent.mm.plugin.sns.ad.remote.a.a aVar = this.Dxr;
        if (aVar == null) {
            AppMethodBeat.o(202068);
            return false;
        }
        try {
            Method[] methods = com.tencent.mm.plugin.sns.ad.remote.a.a.class.getMethods();
            if (c.w(methods)) {
                AppMethodBeat.o(202068);
                return false;
            }
            Method method = aVar.getClass().getMethod(methods[0].getName(), Bundle.class);
            if (!(method == null || (bVar = (com.tencent.mm.plugin.sns.ad.remote.b) method.getAnnotation(com.tencent.mm.plugin.sns.ad.remote.b.class)) == null)) {
                boolean eXz = bVar.eXz();
                AppMethodBeat.o(202068);
                return eXz;
            }
            AppMethodBeat.o(202068);
            return false;
        } catch (Throwable th) {
        }
    }
}
