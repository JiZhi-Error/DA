package com.tencent.mm.plugin.updater;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.hp.b.e;
import com.tencent.mm.plugin.hp.d.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.updater.a.a;
import com.tencent.mm.plugin.updater.model.d;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public class PluginUpdater extends f implements c, a {
    private i gNh = new i() {
        /* class com.tencent.mm.plugin.updater.PluginUpdater.AnonymousClass1 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            boolean z;
            int i4;
            boolean z2 = true;
            AppMethodBeat.i(194693);
            if (qVar instanceof com.tencent.mm.plugin.updater.model.c) {
                com.tencent.mm.plugin.updater.model.c cVar = (com.tencent.mm.plugin.updater.model.c) qVar;
                b bVar = cVar.GwJ;
                com.tencent.mm.util.c cVar2 = com.tencent.mm.util.c.QYz;
                if (Util.getInt(com.tencent.mm.util.c.axY(com.tencent.mm.util.c.np("updater", "openAutoProcessor")), 0) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    if (bVar == null || !bVar.dZw() || !bVar.dZt() || bVar.dZx() || bVar.dZy()) {
                        Log.i("MicroMsg.Updater.PluginUpdater", "not handle response");
                        z2 = false;
                    } else {
                        Log.i("MicroMsg.Updater.PluginUpdater", "TinkerSyncResponse packageType:%d", bVar.pkI);
                        if (cVar.source == 0) {
                            if (bVar.pkI.intValue() == 3) {
                                try {
                                    i4 = Integer.decode(bVar.clientVersion).intValue();
                                } catch (Exception e2) {
                                    i4 = 0;
                                }
                                Log.i("MicroMsg.Updater.PluginUpdater", "save update client version %s %d", bVar.clientVersion, Integer.valueOf(i4));
                                if (i4 != 0) {
                                    d dVar = d.GwL;
                                    d.fAO().edit().putInt("KeyCurrentUpdateVersion", i4).putInt("RedDotCheckUpdateTab", 1).apply();
                                }
                            } else {
                                if (bVar.pkI.intValue() == 2) {
                                    com.tencent.mm.plugin.updater.model.b.GwB.a(bVar);
                                    z2 = false;
                                }
                                z2 = false;
                            }
                        } else if (cVar.source == 1 || cVar.source == 2) {
                            Log.i("MicroMsg.Updater.PluginUpdater", "handle response source=%d", Integer.valueOf(cVar.source));
                            com.tencent.mm.plugin.updater.model.b.GwB.a(bVar);
                            z2 = false;
                        } else {
                            Log.i("MicroMsg.Updater.PluginUpdater", "not handle response unknown source=%d", Integer.valueOf(cVar.source));
                            z2 = false;
                        }
                    }
                    if (bVar == null) {
                        Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.hta), 0).show();
                    }
                    Iterator it = PluginUpdater.this.ndV.iterator();
                    while (it.hasNext()) {
                        ((com.tencent.mm.plugin.updater.a.b) it.next()).uq(z2);
                    }
                    AppMethodBeat.o(194693);
                    return;
                }
                Log.i("MicroMsg.Updater.PluginUpdater", "test auto sync processor response");
                MMApplicationContext.getContext();
                com.tencent.mm.plugin.hp.d.d.dZA();
                new e(bVar).qk(true);
            }
            AppMethodBeat.o(194693);
        }
    };
    private LinkedList<com.tencent.mm.plugin.updater.a.b> ndV = new LinkedList<>();

    public PluginUpdater() {
        AppMethodBeat.i(194694);
        AppMethodBeat.o(194694);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
    }

    @Override // com.tencent.mm.plugin.updater.a.a
    public boolean hasSettingTabRedDot() {
        AppMethodBeat.i(194695);
        d dVar = d.GwL;
        if (d.fAO().getInt("RedDotSettingTab", 0) == 1) {
            AppMethodBeat.o(194695);
            return true;
        }
        AppMethodBeat.o(194695);
        return false;
    }

    @Override // com.tencent.mm.plugin.updater.a.a
    public void clickSettingTabRedDot() {
        AppMethodBeat.i(194696);
        Log.i("MicroMsg.Updater.PluginUpdater", "clickSettingTabRedDot");
        d dVar = d.GwL;
        d.fAO().edit().putInt("RedDotSettingTab", 0).putInt("RedDotBottomTab", 0).apply();
        AppMethodBeat.o(194696);
    }

    @Override // com.tencent.mm.plugin.updater.a.a
    public boolean hasBottomTabRedDot() {
        AppMethodBeat.i(194697);
        d dVar = d.GwL;
        if (d.fAO().getInt("RedDotBottomTab", 0) == 1) {
            AppMethodBeat.o(194697);
            return true;
        }
        AppMethodBeat.o(194697);
        return false;
    }

    @Override // com.tencent.mm.plugin.updater.a.a
    public void clickBottomTabRedDot() {
        AppMethodBeat.i(194698);
        Log.i("MicroMsg.Updater.PluginUpdater", "clickBottomTabRedDot");
        d dVar = d.GwL;
        d.fAO().edit().putInt("RedDotBottomTab", 0).apply();
        AppMethodBeat.o(194698);
    }

    @Override // com.tencent.mm.plugin.updater.a.a
    public boolean hasAboutWechatRedDot() {
        AppMethodBeat.i(194699);
        d dVar = d.GwL;
        if (d.fAO().getInt("RedDotAboutWechatTab", 0) == 1) {
            AppMethodBeat.o(194699);
            return true;
        }
        AppMethodBeat.o(194699);
        return false;
    }

    @Override // com.tencent.mm.plugin.updater.a.a
    public void clickAboutWechatRedDot() {
        AppMethodBeat.i(194700);
        Log.i("MicroMsg.Updater.PluginUpdater", "clickAboutWechatRedDot");
        d dVar = d.GwL;
        d.fAO().edit().putInt("RedDotAboutWechatTab", 0).putInt("RedDotSettingTab", 0).putInt("RedDotBottomTab", 0).apply();
        AppMethodBeat.o(194700);
    }

    @Override // com.tencent.mm.plugin.updater.a.a
    public boolean hasCheckUpdateTabRedDot() {
        AppMethodBeat.i(194701);
        d dVar = d.GwL;
        if (d.fAO().getInt("RedDotCheckUpdateTab", 0) == 1) {
            AppMethodBeat.o(194701);
            return true;
        }
        AppMethodBeat.o(194701);
        return false;
    }

    @Override // com.tencent.mm.plugin.updater.a.a
    public void clickCheckUpdateRedDot() {
        AppMethodBeat.i(194702);
        Log.i("MicroMsg.Updater.PluginUpdater", "clickCheckUpdateRedDot");
        d dVar = d.GwL;
        d.fAO().edit().putInt("RedDotCheckUpdateTab", 0).putInt("RedDotAboutWechatTab", 0).putInt("RedDotSettingTab", 0).putInt("RedDotBottomTab", 0).apply();
        AppMethodBeat.o(194702);
    }

    @Override // com.tencent.mm.plugin.updater.a.a
    public void setFullCheckUpdateRedDot(int i2) {
        AppMethodBeat.i(194703);
        Log.i("MicroMsg.Updater.PluginUpdater", "setFullCheckUpdateRedDot %s", Integer.valueOf(i2));
        if (i2 != 0) {
            h.INSTANCE.idkeyStat(1429, 25, 1, false);
            d dVar = d.GwL;
            d.fAO().edit().putInt("KeyCurrentUpdateVersion", i2).putInt("RedDotCheckUpdateTab", 1).putInt("RedDotAboutWechatTab", 1).putInt("RedDotSettingTab", 1).putInt("RedDotBottomTab", 1).apply();
            AppMethodBeat.o(194703);
            return;
        }
        h.INSTANCE.idkeyStat(1429, 26, 1, false);
        AppMethodBeat.o(194703);
    }

    @Override // com.tencent.mm.plugin.updater.a.a
    public int getUpdateVersion() {
        AppMethodBeat.i(194704);
        d dVar = d.GwL;
        int i2 = d.fAO().getInt("KeyCurrentUpdateVersion", 0);
        AppMethodBeat.o(194704);
        return i2;
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(194705);
        com.tencent.mm.kernel.g.azz().a(3899, this.gNh);
        if (cVar.hrc) {
            d dVar = d.GwL;
            d.fAO().edit().putInt("RedDotCheckUpdateTab", 0).putInt("RedDotAboutWechatTab", 0).putInt("RedDotSettingTab", 0).putInt("RedDotBottomTab", 0).apply();
        }
        AppMethodBeat.o(194705);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(194706);
        com.tencent.mm.kernel.g.azz().b(3899, this.gNh);
        AppMethodBeat.o(194706);
    }

    @Override // com.tencent.mm.plugin.updater.a.a
    public void addManualCheckUpdateListener(com.tencent.mm.plugin.updater.a.b bVar) {
        AppMethodBeat.i(194707);
        this.ndV.add(bVar);
        AppMethodBeat.o(194707);
    }

    @Override // com.tencent.mm.plugin.updater.a.a
    public void removeManualCheckUpdateListener(com.tencent.mm.plugin.updater.a.b bVar) {
        AppMethodBeat.i(194708);
        this.ndV.remove(bVar);
        AppMethodBeat.o(194708);
    }

    @Override // com.tencent.mm.plugin.updater.a.a
    public void manualCheckUpdate(int i2) {
        AppMethodBeat.i(194709);
        Log.i("MicroMsg.Updater.PluginUpdater", "manualCheckUpdate %s", Integer.valueOf(i2));
        com.tencent.mm.kernel.g.azz().a(new com.tencent.mm.plugin.updater.model.c(getBasePatchId(), getTinkerPatchId(), getTinkerConditionList(), i2), 0);
        if (i2 == 2) {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1429, 14, 1, false);
            AppMethodBeat.o(194709);
        } else if (i2 == 1) {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1429, 15, 1, false);
            AppMethodBeat.o(194709);
        } else {
            if (i2 == 0) {
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1429, 16, 1, false);
            }
            AppMethodBeat.o(194709);
        }
    }

    public void autoCheckUpdate(int i2) {
        AppMethodBeat.i(194710);
        Log.i("MicroMsg.Updater.PluginUpdater", "autoCheckUpdate %s", Integer.valueOf(i2));
        com.tencent.mm.kernel.g.azz().a(new com.tencent.mm.plugin.hp.net.d(getBasePatchId(), getTinkerPatchId(), getTinkerConditionList()), 0);
        AppMethodBeat.o(194710);
    }

    private String getBasePatchId() {
        AppMethodBeat.i(194711);
        com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
        if (com.tencent.mm.util.c.hdg()) {
            com.tencent.mm.util.c cVar2 = com.tencent.mm.util.c.QYz;
            if (!Util.isNullOrNil(com.tencent.mm.util.c.hdk())) {
                com.tencent.mm.util.c cVar3 = com.tencent.mm.util.c.QYz;
                String hdk = com.tencent.mm.util.c.hdk();
                AppMethodBeat.o(194711);
                return hdk;
            }
        }
        String nullAs = Util.nullAs(com.tencent.mm.loader.j.a.aKw(), "");
        AppMethodBeat.o(194711);
        return nullAs;
    }

    private String getTinkerPatchId() {
        AppMethodBeat.i(194712);
        String nullAs = Util.nullAs(com.tencent.mm.loader.j.a.aKx(), "");
        AppMethodBeat.o(194712);
        return nullAs;
    }

    private LinkedList<cxu> getTinkerConditionList() {
        AppMethodBeat.i(194713);
        LinkedList<cxu> dZe = com.tencent.mm.plugin.hp.net.e.dZe();
        AppMethodBeat.o(194713);
        return dZe;
    }

    @Override // com.tencent.mm.plugin.updater.a.a
    public boolean openUpdater() {
        boolean z;
        AppMethodBeat.i(194714);
        com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
        if (com.tencent.mm.util.c.hdg()) {
            com.tencent.mm.util.c cVar2 = com.tencent.mm.util.c.QYz;
            z = Util.getInt(com.tencent.mm.util.c.axY(com.tencent.mm.util.c.np("updater", "openNewUpdater")), 0) == 1;
        } else {
            z = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_updater_flag, 0) == 1;
        }
        Log.i("MicroMsg.Updater.PluginUpdater", "openUpdater %s", Boolean.valueOf(z));
        AppMethodBeat.o(194714);
        return z;
    }
}
