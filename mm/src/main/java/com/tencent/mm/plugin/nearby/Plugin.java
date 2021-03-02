package com.tencent.mm.plugin.nearby;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.nearby.a.f;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin implements d {
    private c pkO = new c() {
        /* class com.tencent.mm.plugin.nearby.Plugin.AnonymousClass1 */

        @Override // com.tencent.mm.pluginsdk.b.c
        public final a ak(Context context, String str) {
            AppMethodBeat.i(89750);
            com.tencent.mm.plugin.nearby.ui.a aVar = new com.tencent.mm.plugin.nearby.ui.a(context);
            AppMethodBeat.o(89750);
            return aVar;
        }
    };

    public Plugin() {
        AppMethodBeat.i(89751);
        AppMethodBeat.o(89751);
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public n createApplication() {
        AppMethodBeat.i(89752);
        a aVar = new a();
        AppMethodBeat.o(89752);
        return aVar;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public c getContactWidgetFactory() {
        return this.pkO;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public bd createSubCore() {
        AppMethodBeat.i(89753);
        f fVar = new f();
        AppMethodBeat.o(89753);
        return fVar;
    }
}
