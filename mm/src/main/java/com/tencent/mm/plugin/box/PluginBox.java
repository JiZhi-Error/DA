package com.tencent.mm.plugin.box;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.lx;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.box.a.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class PluginBox extends f implements b, c, d {
    private boolean isLoading = false;
    private IListener kiA = new IListener<bp>() {
        /* class com.tencent.mm.plugin.box.PluginBox.AnonymousClass1 */

        {
            AppMethodBeat.i(160986);
            this.__eventId = bp.class.getName().hashCode();
            AppMethodBeat.o(160986);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bp bpVar) {
            AppMethodBeat.i(76318);
            bp bpVar2 = bpVar;
            if (bpVar2 != null) {
                if (bpVar2.dEN.dEO == 62) {
                    Log.i("MicroMsg.Box.PluginBox", "CheckResUpdateCacheFileEvent %d", Integer.valueOf(bpVar2.dEN.subType));
                    switch (bpVar2.dEN.subType) {
                        case 2:
                            String boxFlightResPath = PluginBox.getBoxFlightResPath();
                            if (s.YS(boxFlightResPath)) {
                                s.deleteFile(boxFlightResPath);
                            }
                            o oVar = new o(boxFlightResPath);
                            if (!oVar.heq().exists()) {
                                s.boN(oVar.getParent());
                            }
                            s.nw(bpVar2.dEN.filePath, boxFlightResPath);
                            PluginBox.access$000(PluginBox.this);
                            break;
                    }
                } else if (bpVar2.dEN.dEO == 73 && bpVar2.dEN.subType == 1) {
                    Log.i("MicroMsg.Box.PluginBox", "[checkResUpdateListener] word bank download, subtype: %d, file path: %s, version: %s, updated: %s", Integer.valueOf(bpVar2.dEN.subType), bpVar2.dEN.filePath, Integer.valueOf(bpVar2.dEN.dEP), Boolean.valueOf(bpVar2.dEN.dEQ));
                    PluginBox.access$100(PluginBox.this, bpVar2.dEN.filePath);
                }
            }
            AppMethodBeat.o(76318);
            return false;
        }
    };
    a plH = new a();
    private IListener plI = new IListener<lx>() {
        /* class com.tencent.mm.plugin.box.PluginBox.AnonymousClass2 */

        {
            AppMethodBeat.i(196201);
            this.__eventId = lx.class.getName().hashCode();
            AppMethodBeat.o(196201);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lx lxVar) {
            AppMethodBeat.i(196202);
            lx lxVar2 = lxVar;
            if (lxVar2 != null && lxVar2.dRu.dEO == 73 && lxVar2.dRu.subType == 1) {
                PluginBox.access$100(PluginBox.this, lxVar2.dRu.filePath);
            }
            AppMethodBeat.o(196202);
            return false;
        }
    };
    private boolean plJ = false;

    public PluginBox() {
        AppMethodBeat.i(76320);
        AppMethodBeat.o(76320);
    }

    static /* synthetic */ void access$000(PluginBox pluginBox) {
        AppMethodBeat.i(76327);
        pluginBox.loadFlightNumberAsync();
        AppMethodBeat.o(76327);
    }

    static /* synthetic */ void access$100(PluginBox pluginBox, String str) {
        AppMethodBeat.i(196214);
        pluginBox.updateWordBankRes(str);
        AppMethodBeat.o(196214);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(76321);
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("functionmsg", this.plH.plo);
        this.kiA.alive();
        this.plI.alive();
        loadFlightNumberAsync();
        loadWordBankAsync();
        AppMethodBeat.o(76321);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(76322);
        this.kiA.dead();
        this.plI.dead();
        AppMethodBeat.o(76322);
    }

    @Override // com.tencent.mm.kernel.a.b.b
    public void parallelsDependency() {
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(76323);
        if (gVar.aBb()) {
            g.b(com.tencent.mm.plugin.box.a.c.class, new b());
        }
        AppMethodBeat.o(76323);
    }

    private void updateWordBankRes(final String str) {
        AppMethodBeat.i(196205);
        int ckV = c.ckV();
        int ahs = c.ahs(str);
        if (ahs > ckV) {
            Log.i("MicroMsg.Box.PluginBox", "[updateWordBankRes] currVersion=%s, recvVersion: %d, start to update", Integer.valueOf(ckV), Integer.valueOf(ahs));
            h.RTc.b(new Runnable() {
                /* class com.tencent.mm.plugin.box.PluginBox.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(196203);
                    try {
                        if (c.aht(str) == 0) {
                            c.kh(true);
                            c.aho(c.ki(false));
                        }
                        AppMethodBeat.o(196203);
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.Box.PluginBox", e2, "[updateWordBankRes]", new Object[0]);
                        AppMethodBeat.o(196203);
                    }
                }
            }, "box.HotWordSearchModel");
            AppMethodBeat.o(196205);
            return;
        }
        Log.i("MicroMsg.Box.PluginBox", "[updateWordBankRes] currVersion=%s, recvVersion: %d, pass", Integer.valueOf(ckV), Integer.valueOf(ahs));
        AppMethodBeat.o(196205);
    }

    private void loadFlightNumberAsync() {
        AppMethodBeat.i(76324);
        b.a aVar = b.a.clicfg_box_flight_number_open_flag;
        com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(aVar, com.tencent.mm.util.c.hdd()) == 0) {
            AppMethodBeat.o(76324);
            return;
        }
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.box.PluginBox.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(196204);
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    if (!PluginBox.this.isLoading) {
                        Log.i("MicroMsg.Box.PluginBox", "start to load flight number");
                        PluginBox.this.isLoading = true;
                        if (!s.YS(PluginBox.getBoxFlightResPath())) {
                            Log.i("MicroMsg.Box.PluginBox", "flight number file not exist");
                            return;
                        }
                        String[] split = new String(s.aW(PluginBox.getBoxFlightResPath(), 0, -1)).split("\n");
                        com.tencent.mm.pluginsdk.ui.span.c cVar = com.tencent.mm.pluginsdk.ui.span.c.KqA;
                        cVar.Kqz = null;
                        cVar.Kqx = 0;
                        cVar.Kqy = 0;
                        for (int i2 = 0; i2 < split.length; i2++) {
                            if (!Util.isNullOrNil(split[i2])) {
                                com.tencent.mm.pluginsdk.ui.span.c.KqA.bff(split[i2]);
                            }
                        }
                        PluginBox.this.plJ = true;
                        Log.i("MicroMsg.Box.PluginBox", "load flight number success NodeCount：%d CharacterCount：%d useTime: %d", Integer.valueOf(com.tencent.mm.pluginsdk.ui.span.c.KqA.Kqy), Integer.valueOf(com.tencent.mm.pluginsdk.ui.span.c.KqA.Kqx), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    } else {
                        Log.i("MicroMsg.Box.PluginBox", "flight number is loading");
                    }
                    PluginBox.this.isLoading = false;
                    AppMethodBeat.o(196204);
                } catch (Exception e2) {
                    a.pl(0);
                    Log.printErrStackTrace("MicroMsg.Box.PluginBox", e2, e2.getMessage(), new Object[0]);
                } finally {
                    PluginBox.this.isLoading = false;
                    AppMethodBeat.o(196204);
                }
            }
        }, "Box.LoadFlightNumberAsync");
        AppMethodBeat.o(76324);
    }

    public boolean isInitBox() {
        AppMethodBeat.i(76325);
        if (!this.plJ || ai.aft(2) == 1) {
            AppMethodBeat.o(76325);
            return false;
        }
        AppMethodBeat.o(76325);
        return true;
    }

    public static String getBoxFlightResPath() {
        AppMethodBeat.i(76326);
        String z = aa.z(new o(new o(ai.afr(2).fYs()).heq(), "flight.txt").her());
        AppMethodBeat.o(76326);
        return z;
    }

    private void loadWordBankAsync() {
        AppMethodBeat.i(196206);
        h.RTc.b(c.plC, "box.HotWordSearchModel");
        AppMethodBeat.o(196206);
    }

    public boolean checkIfHasHotWord(String str) {
        AppMethodBeat.i(196207);
        boolean ahp = c.ahp(str);
        AppMethodBeat.o(196207);
        return ahp;
    }

    @Override // com.tencent.mm.plugin.box.d
    public String checkAllHotWords(String str) {
        AppMethodBeat.i(196208);
        ArrayList arrayList = new ArrayList();
        Matcher matcher = com.tencent.mm.plugin.box.a.b.plL.matcher(str);
        if (matcher.find()) {
            String group = matcher.group();
            if (group.length() <= 15 && group.length() >= 13) {
                arrayList.add("$Express$");
            }
        }
        arrayList.addAll(c.ahr(str));
        String listToString = Util.listToString(arrayList, "|");
        AppMethodBeat.o(196208);
        return listToString;
    }

    @Override // com.tencent.mm.plugin.box.d
    public String checkFirstHotWord(String str) {
        AppMethodBeat.i(196209);
        Matcher matcher = com.tencent.mm.plugin.box.a.b.plL.matcher(str);
        if (matcher.find()) {
            String group = matcher.group();
            if (group.length() <= 15 && group.length() >= 13) {
                AppMethodBeat.o(196209);
                return "$Express$";
            }
        }
        String ahq = c.ahq(str);
        AppMethodBeat.o(196209);
        return ahq;
    }

    @Override // com.tencent.mm.plugin.box.d
    public String getMatchedFingerWord(String str, String str2) {
        AppMethodBeat.i(196210);
        if ("$Express$".equals(str)) {
            Matcher matcher = com.tencent.mm.plugin.box.a.b.plL.matcher(str2);
            if (matcher.find()) {
                String group = matcher.group();
                if (group.length() <= 15 && group.length() >= 13) {
                    AppMethodBeat.o(196210);
                    return group;
                }
            }
        }
        AppMethodBeat.o(196210);
        return str;
    }

    @Override // com.tencent.mm.plugin.box.d
    public String getExposedFingerWord(String str) {
        AppMethodBeat.i(196211);
        if ("$Express$".equals(str)) {
            String exposedWord = ((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).getExposedWord("express");
            AppMethodBeat.o(196211);
            return exposedWord;
        }
        AppMethodBeat.o(196211);
        return str;
    }

    @Override // com.tencent.mm.plugin.box.d
    public String getWordBankVersionForStat() {
        AppMethodBeat.i(196212);
        String wordBankVersionForStat = c.getWordBankVersionForStat();
        AppMethodBeat.o(196212);
        return wordBankVersionForStat;
    }

    @Override // com.tencent.mm.plugin.box.d
    public int getSearchDuration() {
        AppMethodBeat.i(196213);
        int searchDuration = c.getSearchDuration();
        AppMethodBeat.o(196213);
        return searchDuration;
    }
}
