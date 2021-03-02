package com.tencent.mm.plugin.topstory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.d;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.xweb.WebView;

public class PluginTopStory extends f implements b, c, com.tencent.mm.plugin.topstory.a.b {
    private c GiE;
    private b GiF;
    private a GiG;
    private WebView.c GiH = WebView.c.WV_KIND_CW;

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
    }

    @Override // com.tencent.mm.kernel.a.b.b
    public void parallelsDependency() {
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(88410);
        this.GiE = new c();
        this.GiF = new b();
        this.GiG = new a();
        ThreadPool.post(new a(this, (byte) 0), "TopStory.InitTopStoryCacheFolderTask");
        preInitXWebView();
        AppMethodBeat.o(88410);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(88411);
        if (this.GiE != null) {
            c cVar = this.GiE;
            cVar.Eyp.removeCallbacksAndMessages(null);
            cVar.Eyp.quit();
            this.GiE = null;
        }
        if (this.GiF != null) {
            b bVar = this.GiF;
            ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", bVar.GiO);
            EventCenter.instance.removeListener(bVar.GiS);
            this.GiF = null;
        }
        if (this.GiG != null) {
            this.GiG.GiJ.clear();
            this.GiG = null;
        }
        if (com.tencent.mm.plugin.topstory.a.b.a.Gjc != null) {
            if (com.tencent.mm.plugin.topstory.a.b.a.Gjc.Gjg != null) {
                com.tencent.mm.kernel.g.azz().a(com.tencent.mm.plugin.topstory.a.b.a.Gjc.Gjg);
                com.tencent.mm.plugin.topstory.a.b.a.Gjc.Gjg = null;
            }
            if (com.tencent.mm.plugin.topstory.a.b.a.Gjc.Gjh != null) {
                com.tencent.mm.kernel.g.azz().a(com.tencent.mm.plugin.topstory.a.b.a.Gjc.Gjh);
                com.tencent.mm.plugin.topstory.a.b.a.Gjc.Gjh = null;
            }
            com.tencent.mm.kernel.g.azz().b(2748, com.tencent.mm.plugin.topstory.a.b.a.Gjc);
            com.tencent.mm.plugin.topstory.a.b.a.Gjc = null;
        }
        AppMethodBeat.o(88411);
    }

    public void onVideoListUICreate() {
    }

    @Override // com.tencent.mm.plugin.topstory.a.b
    public void onVideoListUIDestroy(eit eit) {
    }

    @Override // com.tencent.mm.plugin.topstory.a.b
    public void onVideoListUIPause() {
    }

    @Override // com.tencent.mm.plugin.topstory.a.b
    public void onVideoListUIResume() {
    }

    @Override // com.tencent.mm.plugin.topstory.a.b
    public c getReporter() {
        return this.GiE;
    }

    @Override // com.tencent.mm.plugin.topstory.a.b
    public b getRedDotMgr() {
        return this.GiF;
    }

    public a getPerformTracer() {
        return this.GiG;
    }

    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(PluginTopStory pluginTopStory, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(88409);
            Log.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard ftsrecommendVideo folder %b", Boolean.valueOf(com.tencent.mm.vfs.s.dy(com.tencent.mm.loader.j.b.aKJ() + "ftsrecommendVideo/", true)));
            Log.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard topstory folder %b", Boolean.valueOf(com.tencent.mm.vfs.s.dy(com.tencent.mm.loader.j.b.aKJ() + "topstory/", true)));
            Log.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard cache topstory folder %b", Boolean.valueOf(com.tencent.mm.vfs.s.dy(MMApplicationContext.getContext().getCacheDir() + "topstory/", true)));
            o oVar = new o(h.fxQ());
            if (oVar.exists()) {
                o[] het = oVar.het();
                if (het != null) {
                    for (o oVar2 : het) {
                        Log.i("MicroMsg.TopStory.PluginTopStory", "Delete Cache File %s %b", aa.z(oVar2.her()), Boolean.valueOf(com.tencent.mm.vfs.s.dy(aa.z(oVar2.her()), true)));
                    }
                }
                com.tencent.mm.vfs.s.boN(h.fxQ() + ".nomedia/");
                AppMethodBeat.o(88409);
                return;
            }
            com.tencent.mm.vfs.s.boN(h.fxQ());
            com.tencent.mm.vfs.s.boN(h.fxQ() + ".nomedia/");
            Log.i("MicroMsg.TopStory.PluginTopStory", "Create TopStoryCacheFolder");
            AppMethodBeat.o(88409);
        }
    }

    private void preInitXWebView() {
        AppMethodBeat.i(88412);
        d.a(this.GiH, new WebView.PreInitCallback() {
            /* class com.tencent.mm.plugin.topstory.PluginTopStory.AnonymousClass1 */

            @Override // com.tencent.xweb.WebView.PreInitCallback
            public final void onCoreInitFinished() {
                AppMethodBeat.i(88407);
                Log.i("MicroMsg.TopStory.PluginTopStory", "onCoreInitFinished");
                AppMethodBeat.o(88407);
            }

            @Override // com.tencent.xweb.WebView.PreInitCallback
            public final void btl() {
                AppMethodBeat.i(88408);
                Log.i("MicroMsg.TopStory.PluginTopStory", "onCoreInitFailed");
                AppMethodBeat.o(88408);
            }
        });
        Log.i("MicroMsg.TopStory.PluginTopStory", "Start To Load WebView %s", this.GiH.name());
        AppMethodBeat.o(88412);
    }

    @Override // com.tencent.mm.plugin.topstory.a.b
    public WebView.c getWebViewType() {
        return this.GiH;
    }

    @Override // com.tencent.mm.plugin.topstory.a.b
    public boolean openJsAccelerate() {
        AppMethodBeat.i(201208);
        b.a aVar = b.a.clicfg_topstory_js_accelerate_flag;
        com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(aVar, Util.getInt(com.tencent.mm.util.c.axY(com.tencent.mm.util.c.np("topstory", "openJsAccelerate")), 0)) == 1) {
            AppMethodBeat.o(201208);
            return true;
        }
        AppMethodBeat.o(201208);
        return false;
    }
}
