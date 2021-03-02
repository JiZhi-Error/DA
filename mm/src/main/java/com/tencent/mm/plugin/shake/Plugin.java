package com.tencent.mm.plugin.shake;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin implements d {
    private c Dgq = new c() {
        /* class com.tencent.mm.plugin.shake.Plugin.AnonymousClass1 */

        @Override // com.tencent.mm.pluginsdk.b.c
        public final a ak(Context context, String str) {
            AppMethodBeat.i(28082);
            com.tencent.mm.plugin.shake.ui.a aVar = new com.tencent.mm.plugin.shake.ui.a(context);
            AppMethodBeat.o(28082);
            return aVar;
        }
    };

    public Plugin() {
        AppMethodBeat.i(28083);
        AppMethodBeat.o(28083);
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public n createApplication() {
        AppMethodBeat.i(28084);
        a aVar = new a();
        AppMethodBeat.o(28084);
        return aVar;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public c getContactWidgetFactory() {
        return this.Dgq;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public bd createSubCore() {
        AppMethodBeat.i(28085);
        m mVar = new m();
        AppMethodBeat.o(28085);
        return mVar;
    }
}
