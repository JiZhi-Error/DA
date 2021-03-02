package com.tencent.mm.console.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.performance.jectl.JeVersion;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class f implements a {
    static {
        AppMethodBeat.i(231530);
        b.a(new f(), "//jeversion");
        AppMethodBeat.o(231530);
    }

    public static void init() {
    }

    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(231529);
        MMApplicationContext.getContext().startService(new Intent(MMApplicationContext.getContext(), JeVersion.JeService.class));
        AppMethodBeat.o(231529);
        return true;
    }
}
