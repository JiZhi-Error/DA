package com.tencent.mm.remoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.remoteservice.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Constructor;

public class RemoteService extends Service {
    private c.a NCz = new c.a() {
        /* class com.tencent.mm.remoteservice.RemoteService.AnonymousClass1 */

        @Override // com.tencent.mm.remoteservice.c
        public final void a(String str, String str2, Bundle bundle, b bVar) {
            a aVar;
            AppMethodBeat.i(152741);
            try {
                Class<?> loadClass = RemoteService.this.getClassLoader().loadClass(str);
                Constructor<?>[] constructors = loadClass.getConstructors();
                if (constructors.length > 0) {
                    Object[] objArr = new Object[constructors[0].getParameterTypes().length];
                    objArr[0] = null;
                    aVar = (a) constructors[0].newInstance(objArr);
                } else {
                    aVar = (a) loadClass.newInstance();
                }
                aVar.NCv = bVar;
                aVar.NCu = RemoteService.this;
                aVar.onCallback(str2, bundle, false);
                AppMethodBeat.o(152741);
            } catch (Exception e2) {
                Log.e("MicroMsg.RemoveService", "exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(152741);
            }
        }
    };

    public RemoteService() {
        AppMethodBeat.i(152742);
        AppMethodBeat.o(152742);
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(152743);
        new StringBuilder("onBind, threadId:").append(Thread.currentThread().getId());
        c.a aVar = this.NCz;
        AppMethodBeat.o(152743);
        return aVar;
    }

    public void onRebind(Intent intent) {
        AppMethodBeat.i(152744);
        new StringBuilder("onRebind, threadId:").append(Thread.currentThread().getId());
        super.onRebind(intent);
        AppMethodBeat.o(152744);
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.i(152745);
        new StringBuilder("onUnbind, threadId:").append(Thread.currentThread().getId());
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.o(152745);
        return onUnbind;
    }

    public void onDestroy() {
        AppMethodBeat.i(152746);
        new StringBuilder("onDestroy, threadId:").append(Thread.currentThread().getId());
        super.onDestroy();
        AppMethodBeat.o(152746);
    }
}
