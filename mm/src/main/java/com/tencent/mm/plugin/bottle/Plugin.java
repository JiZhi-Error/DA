package com.tencent.mm.plugin.bottle;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public final class Plugin implements d {
    private c pkO = new c() {
        /* class com.tencent.mm.plugin.bottle.Plugin.AnonymousClass1 */

        @Override // com.tencent.mm.pluginsdk.b.c
        public final a ak(Context context, String str) {
            return null;
        }
    };

    public Plugin() {
        AppMethodBeat.i(22640);
        AppMethodBeat.o(22640);
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final n createApplication() {
        AppMethodBeat.i(22641);
        a aVar = new a();
        AppMethodBeat.o(22641);
        return aVar;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final bd createSubCore() {
        AppMethodBeat.i(22642);
        com.tencent.mm.plugin.bottle.a.d dVar = new com.tencent.mm.plugin.bottle.a.d();
        AppMethodBeat.o(22642);
        return dVar;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final c getContactWidgetFactory() {
        return this.pkO;
    }
}
