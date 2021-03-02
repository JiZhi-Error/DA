package com.tencent.mm.plugin.wepkg;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.game.commlib.c.a;
import com.tencent.mm.plugin.game.commlib.d.b;
import com.tencent.mm.plugin.game.protobuf.dj;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.downloader.i;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class PluginWePkg extends f implements a, c, d, com.tencent.mm.plugin.wepkg.a.a {
    com.tencent.f.i.d JLv;
    private com.tencent.mm.plugin.wepkg.utils.c JLw;

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(110518);
        if (gVar.aBb()) {
            Log.i("MicroMsg.WePkg.PluginWePkg", "PluginWePkg execute");
            com.tencent.mm.plugin.game.commlib.d.a.a(new b() {
                /* class com.tencent.mm.plugin.wepkg.PluginWePkg.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.game.commlib.d.b
                public final void awp() {
                    AppMethodBeat.i(110517);
                    com.tencent.mm.plugin.wepkg.utils.d.cyh().postToWorker(new Runnable() {
                        /* class com.tencent.mm.plugin.wepkg.PluginWePkg.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            boolean z;
                            ArrayList arrayList;
                            AppMethodBeat.i(110516);
                            com.tencent.mm.plugin.game.api.b dSQ = b.a.dSQ();
                            if (dSQ != null) {
                                MMApplicationContext.getContext();
                                z = dSQ.dSE();
                            } else {
                                z = false;
                            }
                            boolean z2 = (z.aUd() & 8388608) != 0;
                            Object[] objArr = new Object[2];
                            objArr[0] = Boolean.valueOf(z);
                            objArr[1] = Boolean.valueOf(!z2);
                            Log.i("MicroMsg.WePkg.PluginWePkg", "shouldShowGame %s, openGameEntry %s", objArr);
                            if (z && !z2) {
                                if (com.tencent.mm.plugin.game.commlib.a.xvl != null) {
                                    if (com.tencent.mm.plugin.game.commlib.a.xvl.WepkgControl != null) {
                                        LinkedList<dj> linkedList = com.tencent.mm.plugin.game.commlib.a.xvl.WepkgControl.xNM;
                                        if (!Util.isNullOrNil(linkedList)) {
                                            ArrayList arrayList2 = new ArrayList();
                                            for (dj djVar : linkedList) {
                                                if (djVar != null && !Util.isNullOrNil(djVar.xJD)) {
                                                    arrayList2.add(djVar.xJD);
                                                }
                                            }
                                            arrayList = arrayList2;
                                        }
                                    }
                                    arrayList = null;
                                } else {
                                    com.tencent.mm.plugin.game.commlib.a.dSS();
                                    arrayList = null;
                                }
                                List dSW = com.tencent.mm.plugin.game.commlib.a.dSW();
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                Log.i("MicroMsg.Wepkg.WepkgVersionUpdater", "pkgIdsForAll size:%d", Integer.valueOf(arrayList.size()));
                                if (dSW == null) {
                                    dSW = new ArrayList();
                                }
                                Log.i("MicroMsg.Wepkg.WepkgVersionUpdater", "pkgIdsIfExists size:%d", Integer.valueOf(dSW.size()));
                                List<String> gkG = com.tencent.mm.plugin.wepkg.b.f.gkF().gkG();
                                if (gkG == null) {
                                    gkG = new ArrayList<>();
                                }
                                Log.i("MicroMsg.Wepkg.WepkgVersionUpdater", "localPkgIdList size:%d", Integer.valueOf(gkG.size()));
                                HashSet hashSet = new HashSet();
                                hashSet.addAll(gkG);
                                hashSet.retainAll(dSW);
                                hashSet.addAll(arrayList);
                                WepkgVersionUpdater.a(hashSet, 2, true);
                            }
                            AppMethodBeat.o(110516);
                        }
                    });
                    AppMethodBeat.o(110517);
                }
            });
        }
        if (gVar.FY(":tools") || gVar.FY(":toolsmp")) {
            com.tencent.mm.plugin.game.commlib.c.a.dTf().a("preload_commlib", new a.AbstractC1395a() {
                /* class com.tencent.mm.plugin.wepkg.PluginWePkg.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.game.commlib.c.a.AbstractC1395a
                public final void cBm() {
                    AppMethodBeat.i(200140);
                    try {
                        d.cCf();
                        b.vC();
                        AppMethodBeat.o(200140);
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.WePkg.PluginWePkg", e2, "", new Object[0]);
                        h.INSTANCE.idkeyStat(859, 19, 1, false);
                        AppMethodBeat.o(200140);
                    }
                }
            });
        }
        if (gVar.FY(":lite")) {
            Log.i("MicroMsg.WePkg.PluginWePkg", "cpan offline registerService IGameLiteAppOfficeService");
            ((com.tencent.mm.plugin.lite.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.lite.a.a.class)).iw(ToolsProcessIPCService.dkO, c.class.getName());
        }
        AppMethodBeat.o(110518);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(110519);
        Log.i("MicroMsg.WePkg.PluginWePkg", "onAccountInitialized");
        this.JLv = com.tencent.f.h.RTc.n(new Runnable() {
            /* class com.tencent.mm.plugin.wepkg.PluginWePkg.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(200141);
                if (PluginWePkg.this.JLw == null) {
                    PluginWePkg.this.JLw = new com.tencent.mm.plugin.wepkg.utils.c();
                }
                com.tencent.mm.plugin.wepkg.utils.c cVar = PluginWePkg.this.JLw;
                Log.i("MicroMsg.Wepkg.WepkgListener", "wepkg start listen");
                EventCenter.instance.addListener(cVar.JOg);
                EventCenter.instance.addListener(cVar.JOf);
                i.cBn();
                cVar.appForegroundListener.alive();
                Context context = MMApplicationContext.getContext();
                if (context != null) {
                    try {
                        SharedPreferences sharedPreferences = context.getSharedPreferences("we_pkg_sp", 4);
                        if (sharedPreferences == null) {
                            Log.e("MicroMsg.Wepkg.WepkgListener", "sp is null");
                            AppMethodBeat.o(200141);
                            return;
                        }
                        if (sharedPreferences.getBoolean("disable_we_pkg", false)) {
                            Log.i("MicroMsg.Wepkg.WepkgListener", "enable wepkg");
                            sharedPreferences.edit().putBoolean("disable_we_pkg", false).commit();
                        }
                        sharedPreferences.edit().putInt("white_screen_times", 0).commit();
                        AppMethodBeat.o(200141);
                        return;
                    } catch (Exception e2) {
                        Log.e("MicroMsg.Wepkg.WepkgListener", e2.getMessage());
                    }
                }
                AppMethodBeat.o(200141);
            }
        }, 1000);
        AppMethodBeat.o(110519);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(110520);
        Log.i("MicroMsg.WePkg.PluginWePkg", "onAccountRelease");
        if (this.JLv != null) {
            this.JLv.cancel(true);
        }
        if (this.JLw != null) {
            com.tencent.mm.plugin.wepkg.utils.c cVar = this.JLw;
            Log.i("MicroMsg.Wepkg.WepkgListener", "wepkg stop listen");
            EventCenter.instance.removeListener(cVar.JOg);
            cVar.appForegroundListener.dead();
            EventCenter.instance.removeListener(cVar.JOf);
            i.cBo();
            com.tencent.mm.plugin.wepkg.utils.d.bZm();
            this.JLw = null;
        }
        AppMethodBeat.o(110520);
    }

    @Override // com.tencent.mm.kernel.api.a
    public HashMap<Integer, h.b> collectDatabaseFactory() {
        AppMethodBeat.i(200142);
        Log.i("MicroMsg.WePkg.PluginWePkg", "collectDatabaseFactory");
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("CHECK_WEPKG_VERSION".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.wepkg.PluginWePkg.AnonymousClass4 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.wepkg.b.f.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("WEPKG_PRELOAD_FILES".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.wepkg.PluginWePkg.AnonymousClass5 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.wepkg.b.d.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("WEPKG_DIFF_PACK".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.wepkg.PluginWePkg.AnonymousClass6 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.wepkg.b.b.SQL_CREATE;
            }
        });
        AppMethodBeat.o(200142);
        return hashMap;
    }

    @Override // com.tencent.mm.kernel.api.e
    public void onDataBaseOpened(com.tencent.mm.storagebase.h hVar, com.tencent.mm.storagebase.h hVar2) {
        AppMethodBeat.i(200143);
        Log.i("MicroMsg.WePkg.PluginWePkg", "onDataBaseOpened");
        com.tencent.mm.plugin.wepkg.utils.b.JOe = true;
        AppMethodBeat.o(200143);
    }

    @Override // com.tencent.mm.kernel.api.e
    public void onDataBaseClosed(com.tencent.mm.storagebase.h hVar, com.tencent.mm.storagebase.h hVar2) {
        AppMethodBeat.i(200144);
        Log.i("MicroMsg.WePkg.PluginWePkg", "onDataBaseClosed");
        com.tencent.mm.plugin.wepkg.utils.b.JOe = false;
        AppMethodBeat.o(200144);
    }
}
