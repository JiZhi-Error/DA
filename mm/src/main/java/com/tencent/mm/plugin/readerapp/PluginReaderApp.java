package com.tencent.mm.plugin.readerapp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.b;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.readerapp.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;

public class PluginReaderApp extends f implements c, a {
    private i BBT = new i() {
        /* class com.tencent.mm.plugin.readerapp.PluginReaderApp.AnonymousClass2 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(102647);
            g.aAi();
            if (Util.nullAsNil((Integer) g.aAh().azQ().get(15, (Object) null)) != 0) {
                PluginReaderApp.access$000(PluginReaderApp.this);
                g.azz().b(138, this);
            }
            AppMethodBeat.o(102647);
        }
    };

    public PluginReaderApp() {
        AppMethodBeat.i(102648);
        AppMethodBeat.o(102648);
    }

    static /* synthetic */ void access$000(PluginReaderApp pluginReaderApp) {
        AppMethodBeat.i(102658);
        pluginReaderApp.reportPluginStatus();
        AppMethodBeat.o(102658);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(102649);
        alias(a.class);
        AppMethodBeat.o(102649);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(102650);
        dependsOn(s.class);
        AppMethodBeat.o(102650);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(102651);
        if (gVar.aBb()) {
            pin(new y(com.tencent.mm.plugin.readerapp.c.g.class));
        }
        AppMethodBeat.o(102651);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(102652);
        if (gVar.aBb()) {
            b.bfQ("readerapp");
        }
        AppMethodBeat.o(102652);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(102653);
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.readerapp.PluginReaderApp.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(102646);
                if (System.currentTimeMillis() - ((Long) g.aAh().azQ().get(ar.a.USERINFO_READERAPP_REPORT_TIMESTAMP_LONG, (Object) 0L)).longValue() >= 604800000) {
                    g.aAi();
                    if (Util.nullAsNil((Integer) g.aAh().azQ().get(15, null)) != 0) {
                        PluginReaderApp.access$000(PluginReaderApp.this);
                        AppMethodBeat.o(102646);
                        return;
                    }
                    g.azz().a(138, PluginReaderApp.this.BBT);
                }
                AppMethodBeat.o(102646);
            }
        }, "ReaderAppReport");
        AppMethodBeat.o(102653);
    }

    private void reportPluginStatus() {
        int i2;
        AppMethodBeat.i(102654);
        int i3 = checkInstall() ? 1 : 0;
        if (checkRecvNews()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        h.INSTANCE.a(15416, "newsapp", Integer.valueOf(i3), Integer.valueOf(i2));
        g.aAh().azQ().set(ar.a.USERINFO_READERAPP_REPORT_TIMESTAMP_LONG, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(102654);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(102655);
        g.azz().b(138, this.BBT);
        AppMethodBeat.o(102655);
    }

    private boolean checkInstall() {
        AppMethodBeat.i(102656);
        if ((z.aUl() & 524288) == 0) {
            AppMethodBeat.o(102656);
            return true;
        }
        AppMethodBeat.o(102656);
        return false;
    }

    private boolean checkRecvNews() {
        AppMethodBeat.i(102657);
        if ((z.aUe() & 1024) == 0) {
            AppMethodBeat.o(102657);
            return true;
        }
        AppMethodBeat.o(102657);
        return false;
    }
}
