package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.ServiceConnection;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;

public final class n extends MutableContextWrapper {
    private boolean nWr = false;
    private ContextThemeWrapper nWs;

    public static n eo(Context context) {
        AppMethodBeat.i(48774);
        n nVar = new n(context, x.bXG());
        AppMethodBeat.o(48774);
        return nVar;
    }

    private n(Context context, int i2) {
        super(context);
        AppMethodBeat.i(177763);
        this.nWs = new a(context.getApplicationContext(), i2);
        if (!(context instanceof ContextThemeWrapper)) {
            super.setBaseContext(this.nWs);
        } else {
            context.setTheme(i2);
        }
        this.nWr = context instanceof AppBrandUI;
        AppMethodBeat.o(177763);
    }

    public final void setBaseContext(Context context) {
        AppMethodBeat.i(48776);
        if (context == getBaseContext()) {
            AppMethodBeat.o(48776);
            return;
        }
        if (this.nWr) {
            Log.i("MicroMsg.AppBrandRuntimePersistentContextWrapper", "setBaseContext hash:%d, new:%s, old:%s, stack:%s", Integer.valueOf(hashCode()), context, super.getBaseContext(), android.util.Log.getStackTraceString(new Throwable()));
        }
        if (context instanceof Activity) {
            super.setBaseContext(context);
            this.nWr = true;
            AppMethodBeat.o(48776);
            return;
        }
        super.setBaseContext(this.nWs);
        AppMethodBeat.o(48776);
    }

    public final void unbindService(ServiceConnection serviceConnection) {
        AppMethodBeat.i(48778);
        try {
            super.unbindService(serviceConnection);
            AppMethodBeat.o(48778);
        } catch (IllegalArgumentException e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandRuntimePersistentContextWrapper", e2, "[CAPTURED CRASH]", new Object[0]);
            AppMethodBeat.o(48778);
        }
    }

    public final void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        AppMethodBeat.i(227665);
        try {
            super.unregisterReceiver(broadcastReceiver);
            AppMethodBeat.o(227665);
        } catch (IllegalArgumentException e2) {
            Log.e("MicroMsg.AppBrandRuntimePersistentContextWrapper", "unregisterReceiver IllegalArgumentException %s", e2);
            AppMethodBeat.o(227665);
        }
    }

    @Override // android.content.Context, android.content.ContextWrapper
    public final Object getSystemService(String str) {
        AppMethodBeat.i(48777);
        if ("layout_inflater".equals(str)) {
            Object systemService = this.nWs.getSystemService(str);
            AppMethodBeat.o(48777);
            return systemService;
        }
        Object systemService2 = super.getSystemService(str);
        AppMethodBeat.o(48777);
        return systemService2;
    }

    static final class a extends ContextThemeWrapper {
        private volatile LayoutInflater mInflater;

        public a(Context context, int i2) {
            super(context, i2);
        }

        @Override // android.content.Context, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public final Object getSystemService(String str) {
            LayoutInflater layoutInflater;
            AppMethodBeat.i(177762);
            if ("layout_inflater".equals(str)) {
                synchronized (this) {
                    try {
                        if (this.mInflater == null) {
                            this.mInflater = ((LayoutInflater) getApplicationContext().getSystemService(str)).cloneInContext(this);
                            this.mInflater = aa.b(this.mInflater);
                        }
                        layoutInflater = this.mInflater;
                    } finally {
                        AppMethodBeat.o(177762);
                    }
                }
                return layoutInflater;
            }
            Object systemService = super.getSystemService(str);
            AppMethodBeat.o(177762);
            return systemService;
        }
    }
}
