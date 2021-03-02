package com.tencent.mm.plugin.selectcontact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.df;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.selectcontact.a.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.contact.u;

public class PluginSelectContact extends f implements c, a {
    private IListener CWJ = new IListener<df>() {
        /* class com.tencent.mm.plugin.selectcontact.PluginSelectContact.AnonymousClass1 */

        {
            AppMethodBeat.i(160781);
            this.__eventId = df.class.getName().hashCode();
            AppMethodBeat.o(160781);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(df dfVar) {
            AppMethodBeat.i(102767);
            u.init();
            AppMethodBeat.o(102767);
            return false;
        }
    };

    public PluginSelectContact() {
        AppMethodBeat.i(102768);
        AppMethodBeat.o(102768);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-selectcontact";
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(102769);
        alias(PluginSelectContact.class);
        AppMethodBeat.o(102769);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(102770);
        gVar.aBb();
        AppMethodBeat.o(102770);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(102771);
        gVar.aBb();
        AppMethodBeat.o(102771);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(102772);
        u.init();
        this.CWJ.alive();
        AppMethodBeat.o(102772);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(102773);
        this.CWJ.dead();
        AppMethodBeat.o(102773);
    }
}
