package com.tencent.mm.plugin.updater.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/updater/model/UpdaterConfig;", "", "()V", "UpdaterConfigName", "", "getUpdaterCacheFolder", "getUpdaterSharePreference", "Landroid/content/SharedPreferences;", "plugin-updater_release"})
public final class d {
    public static final d GwL = new d();

    static {
        AppMethodBeat.i(194766);
        AppMethodBeat.o(194766);
    }

    private d() {
    }

    public static SharedPreferences fAO() {
        AppMethodBeat.i(194765);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("UpdaterConfigSharedPreferences", 0);
        p.g(sharedPreferences, "MMApplicationContext.get…me, Context.MODE_PRIVATE)");
        AppMethodBeat.o(194765);
        return sharedPreferences;
    }
}
