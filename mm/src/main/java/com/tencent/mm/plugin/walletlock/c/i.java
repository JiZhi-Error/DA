package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public enum i {
    INSTANCE;
    
    private boolean IwZ = false;
    private boolean Ixa = false;
    private Object Ixb = new Object();
    public HashSet<WeakReference<Activity>> Ixc = new HashSet<>();

    private i(String str) {
        AppMethodBeat.i(129942);
        AppMethodBeat.o(129942);
    }

    public static i valueOf(String str) {
        AppMethodBeat.i(129941);
        i iVar = (i) Enum.valueOf(i.class, str);
        AppMethodBeat.o(129941);
        return iVar;
    }

    static {
        AppMethodBeat.i(129945);
        AppMethodBeat.o(129945);
    }

    public final void yH(boolean z) {
        synchronized (this.Ixb) {
            this.IwZ = z;
        }
    }

    public final boolean fVz() {
        boolean z;
        synchronized (this.Ixb) {
            z = this.IwZ;
        }
        return z;
    }

    public final void yI(boolean z) {
        synchronized (this.Ixb) {
            this.Ixa = z;
        }
    }

    public final boolean fVA() {
        boolean z;
        synchronized (this.Ixb) {
            z = this.Ixa;
        }
        return z;
    }

    public final void fVB() {
        synchronized (this.Ixb) {
            this.Ixa = true;
        }
    }

    public final void j(WeakReference<Activity> weakReference) {
        AppMethodBeat.i(129943);
        if (this.Ixc != null) {
            if (weakReference.get() != null) {
                Log.v("MicroMsg.WalletLockStatusManager", "alvinluo addProtectActivity %s", weakReference.get().getClass().getName());
            }
            this.Ixc.add(weakReference);
        }
        AppMethodBeat.o(129943);
    }

    public final void fVC() {
        AppMethodBeat.i(129944);
        Iterator<WeakReference<Activity>> it = this.Ixc.iterator();
        while (it.hasNext()) {
            Activity activity = it.next().get();
            if (activity != null && !activity.isFinishing()) {
                Log.v("MicroMsg.WalletLockStatusManager", "alvinluo finish %s", activity.getClass().getName());
                activity.finish();
            }
            it.remove();
        }
        AppMethodBeat.o(129944);
    }
}
