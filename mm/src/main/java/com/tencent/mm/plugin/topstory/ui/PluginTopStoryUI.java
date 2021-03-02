package com.tencent.mm.plugin.topstory.ui;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.g.a.kn;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.b;
import com.tencent.mm.plugin.topstory.ui.b.a;
import com.tencent.mm.plugin.topstory.ui.home.d;
import com.tencent.mm.plugin.topstory.ui.multitask.uic.TopStoryMultiTaskUIC;
import com.tencent.mm.protocal.protobuf.eij;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.util.HashMap;

public class PluginTopStoryUI extends f implements b, c, b {
    private int GjO = 2;
    private d GjP;
    private HashMap<String, Integer> GjQ = new HashMap<>();
    private b.a GjR;
    private IListener<kn> GjS = new IListener<kn>() {
        /* class com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI.AnonymousClass3 */

        {
            AppMethodBeat.i(236377);
            this.__eventId = kn.class.getName().hashCode();
            AppMethodBeat.o(236377);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(kn knVar) {
            AppMethodBeat.i(236379);
            boolean a2 = a(knVar);
            AppMethodBeat.o(236379);
            return a2;
        }

        private boolean a(kn knVar) {
            AppMethodBeat.i(236378);
            if (knVar.dPD == null) {
                AppMethodBeat.o(236378);
                return false;
            }
            Log.i("MicroMsg.TopStory.PluginTopStoryUI", "recv HaoKanActionEvent, serverData:%s, clientData:%s", knVar.dPD.dPE, knVar.dPD.dPF);
            if (!Util.isNullOrNil(knVar.dPD.dPE) && PluginTopStoryUI.this.GjR != null) {
                PluginTopStoryUI.this.GjR.aTx(knVar.dPD.dPE);
            }
            if (!Util.isNullOrNil(knVar.dPD.dPF)) {
                try {
                    i iVar = new i(knVar.dPD.dPF);
                    String string = iVar.getString(NativeProtocol.WEB_DIALOG_ACTION);
                    i FJ = iVar.FJ(NativeProtocol.WEB_DIALOG_PARAMS);
                    if (string.equals("updateNumReddot")) {
                        FJ.optString("msgId");
                        int i2 = FJ.getInt("latestTimeStamp");
                        ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().j((long) i2, FJ.getInt("seq"), true);
                    } else if (string.equals("openProfile")) {
                        c.aTz(FJ.getString("openId"));
                    } else if (string.equals("openWowColikeSetting")) {
                        c.hw(MMApplicationContext.getContext());
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.TopStory.PluginTopStoryUI", "HaoKanActionEvent error");
                    Log.printErrStackTrace("MicroMsg.TopStory.PluginTopStoryUI", e2, "", new Object[0]);
                }
            }
            AppMethodBeat.o(236378);
            return true;
        }
    };

    public PluginTopStoryUI() {
        AppMethodBeat.i(125859);
        AppMethodBeat.o(125859);
    }

    @Override // com.tencent.mm.kernel.a.b.b
    public void parallelsDependency() {
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        boolean z;
        AppMethodBeat.i(125860);
        this.GjP = new d();
        this.GjS.alive();
        a.bCM();
        ((com.tencent.mm.plugin.multitask.d) g.ah(com.tencent.mm.plugin.multitask.d.class)).registerMultiTaskUIC(8, TopStoryMultiTaskUIC.class);
        long a2 = g.aAh().azQ().a(ar.a.USERINFO_TOP_STORY_HOME_UI_TIMESTAMP_LONG, 0);
        if (System.currentTimeMillis() - a2 <= 259200000) {
            Log.i("MicroMsg.TopStory.PluginTopStoryUI", "Use TopStory In Three Days %s", com.tencent.mm.pluginsdk.i.f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, a2 / 1000));
            com.tencent.mm.plugin.websearch.api.ar.afB(23);
            z = true;
        } else {
            z = false;
        }
        if (z) {
            tryToCreateTopStoryWebView();
        }
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(125854);
                d dVar = PluginTopStoryUI.this.GjP;
                o oVar = new o(h.fxS());
                if (oVar.exists()) {
                    o[] het = oVar.het();
                    if (het == null || het.length <= 0) {
                        Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Folder Not Files %s", aa.z(oVar.her()));
                    } else {
                        for (o oVar2 : het) {
                            int i2 = Util.getInt(oVar2.getName(), -1);
                            if (i2 > 0) {
                                eij eij = new eij();
                                try {
                                    byte[] aW = s.aW(aa.z(oVar2.her()), 0, -1);
                                    eij.parseFrom(aW);
                                    dVar.GlL.put(Integer.valueOf(i2), eij);
                                    Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "put home data cache key:%d size:%d", Integer.valueOf(i2), Integer.valueOf(aW.length));
                                } catch (Exception e2) {
                                    Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", e2, "loadHomeDataCache %s", oVar2.hes());
                                }
                            } else {
                                Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Decode Key Error %s", aa.z(oVar2.her()));
                            }
                        }
                    }
                } else {
                    Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadHomeDataCache Folder Not Exist %s", aa.z(oVar.her()));
                }
                d dVar2 = PluginTopStoryUI.this.GjP;
                o oVar3 = new o(h.fxT());
                if (oVar3.exists()) {
                    o[] het2 = oVar3.het();
                    if (het2 == null || het2.length <= 0) {
                        Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Folder Not Files %s", aa.z(oVar3.her()));
                        AppMethodBeat.o(125854);
                        return;
                    }
                    for (o oVar4 : het2) {
                        int i3 = Util.getInt(oVar4.getName(), -1);
                        if (i3 > 0) {
                            try {
                                byte[] aW2 = s.aW(aa.z(oVar4.her()), 0, -1);
                                dVar2.GlM.put(Integer.valueOf(i3), new String(aW2, ProtocolPackage.ServerEncoding));
                                Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "put neg cache key:%d size:%d", Integer.valueOf(i3), Integer.valueOf(aW2.length));
                            } catch (Exception e3) {
                                Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", e3, "loadNegDataCache %s", oVar4.hes());
                            }
                        } else {
                            Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Decode Key Error %s", aa.z(oVar4.her()));
                        }
                    }
                    AppMethodBeat.o(125854);
                    return;
                }
                Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadNegDataCache Folder Not Exist %s", aa.z(oVar3.her()));
                AppMethodBeat.o(125854);
            }
        }, "TopStory.LoadHomeCacheData");
        AppMethodBeat.o(125860);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(125861);
        this.GjP = null;
        this.GjS.dead();
        a.bCN();
        com.tencent.mm.pluginsdk.cmd.b.V("//topstory");
        this.GjQ.clear();
        AppMethodBeat.o(125861);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(125862);
        if (gVar.aBb()) {
            g.b(com.tencent.mm.plugin.topstory.a.g.class, new d());
        }
        AppMethodBeat.o(125862);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.b
    public d getWebViewMgr() {
        return this.GjP;
    }

    public int getFirstLoadWebView() {
        return this.GjO;
    }

    public void setFirstLoadWebView(int i2) {
        this.GjO = i2;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.b
    public void tryToCreateTopStoryWebView() {
        AppMethodBeat.i(125863);
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI.AnonymousClass2 */

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 165
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI.AnonymousClass2.run():void");
            }
        }, 5000);
        AppMethodBeat.o(125863);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.b
    public void setHaokanEventListener(b.a aVar) {
        this.GjR = aVar;
    }

    public HashMap<String, Integer> getVideoPlayProgressMap() {
        return this.GjQ;
    }
}
