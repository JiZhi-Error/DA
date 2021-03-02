package com.tencent.mm.plugin.masssend;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin implements d {
    private c pkO = new c() {
        /* class com.tencent.mm.plugin.masssend.Plugin.AnonymousClass1 */

        @Override // com.tencent.mm.pluginsdk.b.c
        public final a ak(Context context, String str) {
            AppMethodBeat.i(26339);
            com.tencent.mm.plugin.masssend.ui.a aVar = new com.tencent.mm.plugin.masssend.ui.a(context);
            AppMethodBeat.o(26339);
            return aVar;
        }
    };

    public Plugin() {
        AppMethodBeat.i(26340);
        AppMethodBeat.o(26340);
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public n createApplication() {
        AppMethodBeat.i(26341);
        a aVar = new a();
        AppMethodBeat.o(26341);
        return aVar;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public c getContactWidgetFactory() {
        return this.pkO;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public bd createSubCore() {
        AppMethodBeat.i(26342);
        h hVar = new h();
        AppMethodBeat.o(26342);
        return hVar;
    }
}
