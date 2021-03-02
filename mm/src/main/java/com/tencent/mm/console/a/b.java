package com.tencent.mm.console.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;

public final class b implements a {
    static {
        AppMethodBeat.i(20171);
        com.tencent.mm.pluginsdk.cmd.b.a(new b(), "//diag");
        AppMethodBeat.o(20171);
    }

    public static void init() {
    }

    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(20170);
        Log.d("MicroMsg.DiagnosticCommand", "process Command : %s", Arrays.toString(strArr));
        Intent intent = new Intent();
        intent.setClassName(context, "com.tencent.mm.plugin.performance.diagnostic.DiagnosticSettingsUI");
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/console/command/DiagnosticCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/console/command/DiagnosticCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(20170);
        return true;
    }
}
