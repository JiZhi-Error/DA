package com.tencent.mm.plugin.readerapp;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.readerapp.ui.b;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.Log;

public final class Plugin implements d {
    private c pkO = new c() {
        /* class com.tencent.mm.plugin.readerapp.Plugin.AnonymousClass1 */

        @Override // com.tencent.mm.pluginsdk.b.c
        public final a ak(Context context, String str) {
            AppMethodBeat.i(102643);
            Log.i("MicroMsg.ReaderApp.Plugin", "create contact widget type[%s]", str);
            if ("widget_type_news".equals(str)) {
                b bVar = new b(context);
                AppMethodBeat.o(102643);
                return bVar;
            }
            AppMethodBeat.o(102643);
            return null;
        }
    };

    public Plugin() {
        AppMethodBeat.i(102644);
        AppMethodBeat.o(102644);
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final n createApplication() {
        AppMethodBeat.i(102645);
        com.tencent.mm.plugin.readerapp.b.a aVar = new com.tencent.mm.plugin.readerapp.b.a();
        AppMethodBeat.o(102645);
        return aVar;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final c getContactWidgetFactory() {
        return this.pkO;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final bd createSubCore() {
        return null;
    }
}
