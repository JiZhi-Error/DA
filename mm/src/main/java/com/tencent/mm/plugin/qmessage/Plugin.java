package com.tencent.mm.plugin.qmessage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.plugin.qmessage.ui.b;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin implements d {
    private c pkO = new c() {
        /* class com.tencent.mm.plugin.qmessage.Plugin.AnonymousClass1 */

        @Override // com.tencent.mm.pluginsdk.b.c
        public final a ak(Context context, String str) {
            AppMethodBeat.i(27705);
            if ("widget_type_contact".equals(str)) {
                com.tencent.mm.plugin.qmessage.ui.a aVar = new com.tencent.mm.plugin.qmessage.ui.a(context);
                AppMethodBeat.o(27705);
                return aVar;
            }
            b bVar = new b(context);
            AppMethodBeat.o(27705);
            return bVar;
        }
    };

    public Plugin() {
        AppMethodBeat.i(27706);
        AppMethodBeat.o(27706);
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public n createApplication() {
        AppMethodBeat.i(27707);
        a aVar = new a();
        AppMethodBeat.o(27707);
        return aVar;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public c getContactWidgetFactory() {
        return this.pkO;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public bd createSubCore() {
        AppMethodBeat.i(27708);
        g gVar = new g();
        AppMethodBeat.o(27708);
        return gVar;
    }
}
