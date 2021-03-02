package com.tencent.mm.plugin.expt.hellhound.core;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c;
import com.tencent.mm.plugin.expt.hellhound.core.b.a.b;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.g;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.plugin.expt.hellhound.core.stack.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

@TargetApi(14)
public class a {
    private static volatile a syS;
    public final c syT = new b();
    public final e syU = new g();
    private WeakReference<Object> syV = null;

    public final void df(Object obj) {
        AppMethodBeat.i(220398);
        Log.w("HABBYGE-MALI.HellhoundMonitor", "HellhoundMonitor-setPageObj: %s", obj.getClass().getSimpleName());
        this.syV = new WeakReference<>(obj);
        AppMethodBeat.o(220398);
    }

    public final Object cNw() {
        AppMethodBeat.i(220399);
        if (this.syV == null) {
            AppMethodBeat.o(220399);
            return null;
        }
        Object obj = this.syV.get();
        AppMethodBeat.o(220399);
        return obj;
    }

    public static a cNx() {
        AppMethodBeat.i(121840);
        if (syS == null) {
            synchronized (a.class) {
                try {
                    if (syS == null) {
                        syS = new a();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(121840);
                    throw th;
                }
            }
        }
        a aVar = syS;
        AppMethodBeat.o(121840);
        return aVar;
    }

    private a() {
        AppMethodBeat.i(121841);
        com.tencent.mm.plugin.expt.hellhound.core.a.a.cNF();
        d.cNM();
        c.cNY();
        com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
        Log.i("HABBYGE-MALI.ActivityBundleDao", "ActivityBundleDao reset");
        if (b.isMMProcess()) {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_ac_ble_mmkv_key", new byte[0]);
        }
        try {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_key_page_se_dao", new byte[0]);
            AppMethodBeat.o(121841);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.PageStateDao", e2, "PageStateDao writeBack", new Object[0]);
            AppMethodBeat.o(121841);
        }
    }

    public static void a(f fVar) {
        AppMethodBeat.i(121844);
        d.cNM().szA.szB.szE = fVar;
        AppMethodBeat.o(121844);
    }
}
