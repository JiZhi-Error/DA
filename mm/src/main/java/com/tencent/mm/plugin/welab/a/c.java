package com.tencent.mm.plugin.welab.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.welab.e.b;
import com.tencent.mm.plugin.welab.ui.WelabMainUI;

public final class c implements com.tencent.mm.plugin.welab.a.a.c {
    @Override // com.tencent.mm.plugin.welab.a.a.c
    public final void at(Context context, Intent intent) {
        int i2;
        AppMethodBeat.i(146243);
        intent.setClass(context, WelabMainUI.class);
        if (gji() || gjj()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        intent.putExtra("para_from_with_red_point", i2);
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/welab/api/LabUIExporter", "startWelabUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/welab/api/LabUIExporter", "startWelabUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(146243);
    }

    @Override // com.tencent.mm.plugin.welab.a.a.c
    public final boolean gji() {
        AppMethodBeat.i(146244);
        b.gju();
        if (!b.gjx() || gjj()) {
            AppMethodBeat.o(146244);
            return false;
        }
        AppMethodBeat.o(146244);
        return true;
    }

    @Override // com.tencent.mm.plugin.welab.a.a.c
    public final boolean gjj() {
        AppMethodBeat.i(146245);
        b.gju();
        if (!b.gjy()) {
            b.gju();
            if (b.gjx()) {
                AppMethodBeat.o(146245);
                return true;
            }
        }
        AppMethodBeat.o(146245);
        return false;
    }

    @Override // com.tencent.mm.plugin.welab.a.a.c
    public final boolean gjk() {
        AppMethodBeat.i(146246);
        if (!gjj()) {
            AppMethodBeat.o(146246);
            return true;
        }
        AppMethodBeat.o(146246);
        return false;
    }
}
