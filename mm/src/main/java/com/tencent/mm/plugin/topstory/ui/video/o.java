package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.a.b.b;
import com.tencent.mm.plugin.topstory.a.b.c;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public final class o {
    private int Fdo;
    private eiw GjH;
    private b GlS;
    Map<String, c> GnR = new HashMap();
    public int GnS = 2;
    public b GnT;
    public List<String> GnU = new ArrayList();

    public o() {
        AppMethodBeat.i(126164);
        AppMethodBeat.o(126164);
    }

    public final void j(eiw eiw) {
        AppMethodBeat.i(126165);
        if (eiw == null) {
            Log.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose null");
        }
        c cVar = new c(eiw);
        if (!this.GnR.containsKey(cVar.GjH.psI)) {
            this.GnR.put(cVar.GjH.psI, cVar);
            Log.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose %s", eiw);
            AppMethodBeat.o(126165);
            return;
        }
        this.GnR.get(cVar.GjH.psI).GjH = eiw;
        AppMethodBeat.o(126165);
    }

    public final void d(b bVar) {
        this.Fdo++;
        this.GlS = bVar;
    }

    public final void onUIDestroy() {
        AppMethodBeat.i(126166);
        this.Fdo--;
        Log.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "onUIDestroy %d", Integer.valueOf(this.Fdo));
        if (this.Fdo <= 0) {
            fzB();
            this.GlS = null;
        }
        AppMethodBeat.o(126166);
    }

    public final void k(eiw eiw) {
        AppMethodBeat.i(126167);
        j(eiw);
        this.GnR.get(eiw.psI).GjI = true;
        AppMethodBeat.o(126167);
    }

    public final void fzB() {
        AppMethodBeat.i(126168);
        HashSet<c> hashSet = new HashSet<>();
        for (c cVar : this.GnR.values()) {
            if (!cVar.vtY) {
                hashSet.add(cVar);
                cVar.vtY = true;
            }
        }
        if (this.GlS != null) {
            ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.GlS.fyD(), hashSet);
        }
        AppMethodBeat.o(126168);
    }

    public final void a(eiw eiw, int i2, String str) {
        AppMethodBeat.i(126169);
        this.GjH = eiw;
        this.GnT = new b();
        this.GnT.Gjm = System.currentTimeMillis();
        this.GnT.Gju = 2;
        this.GnT.Gjt = (long) this.GnS;
        this.GnT.position = (long) (i2 + 1);
        eit fyD = this.GlS.fyD();
        this.GnT.iAh = fyD.scene + "_" + fyD.hes + "_" + fyD.Nib;
        if (this.GlS.isFullscreenMode()) {
            this.GnT.Gjs = 1;
        }
        this.GnS = 2;
        Log.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "startVideoPlay %s %s %s reportInfo: %d %d", str, eiw.psI, eiw.title, Long.valueOf(this.GnT.Gjt), Long.valueOf(this.GnT.Gju));
        AppMethodBeat.o(126169);
    }

    public final void b(eit eit) {
        AppMethodBeat.i(126170);
        fzC();
        ((PluginTopStory) g.ah(PluginTopStory.class)).getReporter();
        com.tencent.mm.plugin.topstory.c.a(eit, this.GjH, this.GnT);
        this.GjH = null;
        this.GnT = null;
        AppMethodBeat.o(126170);
    }

    public final void fzC() {
        AppMethodBeat.i(126171);
        if (!(this.GnT == null || this.GjH == null)) {
            this.GnU.add(this.GjH.psI + "#" + (this.GnT.Gjp / 1000));
        }
        AppMethodBeat.o(126171);
    }
}
