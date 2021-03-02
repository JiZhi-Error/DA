package com.tencent.mm.memory.a.a.a;

import android.app.ActivityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.loader.hotplug.EnvConsts;

public final class a {
    private static a iui = new a();
    public static boolean iuj = false;
    public String dUb = BuildConfig.KINDA_DEFAULT;
    public int iuk = 10485760;
    public int iul = 3;
    public int ium = 2000;
    public double iun = 0.15d;
    public int iuo = 3;
    public Class<?> targetClass;

    static {
        AppMethodBeat.i(156507);
        AppMethodBeat.o(156507);
    }

    public static a aSp() {
        return iui;
    }

    public a() {
        AppMethodBeat.i(156505);
        int largeMemoryClass = ((ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getLargeMemoryClass();
        Log.i("MicroMsg.CacheInvoke", "BitmapPool %dMB", Integer.valueOf(largeMemoryClass));
        if (largeMemoryClass >= 512) {
            this.iuk = 62914560;
        } else if (largeMemoryClass >= 256) {
            this.iuk = 31457280;
        } else {
            this.iuk = 15728640;
        }
        this.targetClass = com.tencent.mm.memory.a.a.a.class;
        this.iul = 3;
        this.ium = 2000;
        this.iuo = 3;
        this.iun = 0.15d;
        AppMethodBeat.o(156505);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(156506);
        if (obj instanceof a) {
            boolean equals = this.dUb.equals(((a) obj).dUb);
            AppMethodBeat.o(156506);
            return equals;
        }
        boolean equals2 = super.equals(obj);
        AppMethodBeat.o(156506);
        return equals2;
    }
}
