package com.tencent.mm.plugin.appbrand.keepalive;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    public static final a mOf = new a();
    ConcurrentHashMap<String, C0727a> mOg = new ConcurrentHashMap<>();

    public a() {
        AppMethodBeat.i(47028);
        AppMethodBeat.o(47028);
    }

    static {
        AppMethodBeat.i(47029);
        AppMethodBeat.o(47029);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.keepalive.a$a  reason: collision with other inner class name */
    static final class C0727a {
        ServiceConnection mOh;

        private C0727a() {
            AppMethodBeat.i(47027);
            this.mOh = new ServiceConnection() {
                /* class com.tencent.mm.plugin.appbrand.keepalive.a.C0727a.AnonymousClass1 */

                public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                }

                public final void onServiceDisconnected(ComponentName componentName) {
                }
            };
            AppMethodBeat.o(47027);
        }

        /* synthetic */ C0727a(byte b2) {
            this();
        }
    }
}
