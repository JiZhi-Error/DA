package com.tencent.mm.plugin.flutter;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.flutter.a.b;
import com.tencent.mm.plugin.flutter.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import io.flutter.view.FlutterMain;

public class PluginFlutter extends f implements c, b {
    private a wIZ;
    private a wJa;
    private boolean wJb;

    static /* synthetic */ void access$000(PluginFlutter pluginFlutter) {
        AppMethodBeat.i(148845);
        pluginFlutter.initFlutter();
        AppMethodBeat.o(148845);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-flutter";
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(148841);
        if (gVar.aBb()) {
            com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.flutter.a.a.class, new b());
        }
        AppMethodBeat.o(148841);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(148842);
        this.wJa = new a();
        this.wIZ = new a();
        com.tencent.mm.pluginsdk.cmd.b.a(this.wIZ, "//flutter");
        h.RTc.n(new Runnable() {
            /* class com.tencent.mm.plugin.flutter.PluginFlutter.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(148840);
                PluginFlutter.access$000(PluginFlutter.this);
                AppMethodBeat.o(148840);
            }
        }, 500);
        AppMethodBeat.o(148842);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(148843);
        if (this.wIZ != null) {
            com.tencent.mm.pluginsdk.cmd.b.V("//flutter");
            this.wIZ = null;
        }
        if (this.wJa != null) {
            a aVar = this.wJa;
            if (MMHandlerThread.isMainThread()) {
                aVar.onDestroy();
            } else {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.flutter.b.a.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(240928);
                        a.this.onDestroy();
                        AppMethodBeat.o(240928);
                    }
                });
            }
            this.wJa = null;
        }
        AppMethodBeat.o(148843);
    }

    private void initFlutter() {
        AppMethodBeat.i(148844);
        try {
            if (isOpenFlutter()) {
                long currentTimeMillis = System.currentTimeMillis();
                FlutterMain.startInitialization(MMApplicationContext.getContext());
                FlutterMain.ensureInitializationComplete(MMApplicationContext.getContext(), new String[0]);
                long currentTimeMillis2 = System.currentTimeMillis();
                this.wJb = true;
                Log.i("MicroMsg.Flutter", "initFlutterEngine useTime %d", Long.valueOf(currentTimeMillis2 - currentTimeMillis));
            }
            AppMethodBeat.o(148844);
        } catch (Exception e2) {
            AppMethodBeat.o(148844);
        }
    }

    public a getFlutterEngineMgr() {
        return this.wJa;
    }

    @Override // com.tencent.mm.plugin.flutter.a.b
    public boolean isInitFlutter() {
        return this.wJb;
    }

    public boolean isOpenFlutter() {
        AppMethodBeat.i(240927);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_flutter_video_editor_preload_flag, false)) {
            AppMethodBeat.o(240927);
            return true;
        }
        AppMethodBeat.o(240927);
        return false;
    }
}
