package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.plugin.sport.a.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class j {
    public static i fmC() {
        AppMethodBeat.i(149330);
        if (MMApplicationContext.isMainProcess()) {
            i iVar = new i(a.FiV);
            AppMethodBeat.o(149330);
            return iVar;
        } else if (MMApplicationContext.isPushProcess()) {
            i iVar2 = new i(a.FiW);
            AppMethodBeat.o(149330);
            return iVar2;
        } else {
            AppMethodBeat.o(149330);
            return null;
        }
    }

    public static String fmD() {
        AppMethodBeat.i(149331);
        if (MMApplicationContext.isPushProcess()) {
            String string = ((PluginSport) g.ah(PluginSport.class)).getSportFileStorage().getString(301, "");
            AppMethodBeat.o(149331);
            return string;
        }
        String string2 = new i(a.FiW).getString(301, "");
        AppMethodBeat.o(149331);
        return string2;
    }

    public static long aJ(int i2, long j2) {
        AppMethodBeat.i(149332);
        if (MMApplicationContext.isMainProcess()) {
            long j3 = ((PluginSport) g.ah(PluginSport.class)).getSportFileStorage().getLong(i2, j2);
            AppMethodBeat.o(149332);
            return j3;
        }
        long j4 = new i(a.FiV).getLong(i2, j2);
        AppMethodBeat.o(149332);
        return j4;
    }

    public static void aK(int i2, long j2) {
        AppMethodBeat.i(149333);
        if (MMApplicationContext.isMainProcess()) {
            ((PluginSport) g.ah(PluginSport.class)).getSportFileStorage().setLong(i2, j2);
            AppMethodBeat.o(149333);
            return;
        }
        RuntimeException runtimeException = new RuntimeException(String.format("not support set value in %s process", MMApplicationContext.getProcessName()));
        AppMethodBeat.o(149333);
        throw runtimeException;
    }

    public static void aRE(String str) {
        AppMethodBeat.i(149334);
        if (MMApplicationContext.isMainProcess()) {
            ((PluginSport) g.ah(PluginSport.class)).getSportFileStorage().setString(2, str);
            AppMethodBeat.o(149334);
            return;
        }
        RuntimeException runtimeException = new RuntimeException(String.format("not support set value in %s process", MMApplicationContext.getProcessName()));
        AppMethodBeat.o(149334);
        throw runtimeException;
    }

    public static void aRF(String str) {
        AppMethodBeat.i(149335);
        if (MMApplicationContext.isPushProcess()) {
            ((PluginSport) g.ah(PluginSport.class)).getSportFileStorage().setString(301, str);
            AppMethodBeat.o(149335);
            return;
        }
        RuntimeException runtimeException = new RuntimeException(String.format("not support set value in %s process", MMApplicationContext.getProcessName()));
        AppMethodBeat.o(149335);
        throw runtimeException;
    }
}
