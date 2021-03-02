package com.tencent.mm.plugin.exdevice.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.compatible.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cg;
import com.tencent.mm.model.cj;
import com.tencent.mm.plugin.exdevice.c.k;
import com.tencent.mm.plugin.exdevice.g.b.b.a;
import com.tencent.mm.plugin.exdevice.g.b.b.b;
import com.tencent.mm.plugin.exdevice.g.b.b.d;
import com.tencent.mm.plugin.exdevice.g.b.b.e;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storagebase.h;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.XWalkFeature;

public final class ad implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    private ab rBa = new ab();
    private b rBb;
    private c rBc;
    private d rBd;
    private a rBe;
    private b rBf;
    private e rBg;
    private e rBh;
    private d rBi;
    private com.tencent.mm.plugin.exdevice.g.b.c rBj;
    private com.tencent.mm.plugin.exdevice.g.b.a rBk;
    private com.tencent.mm.plugin.exdevice.g.a.c rBl;
    private com.tencent.mm.av.a.a rBm = null;
    private com.tencent.mm.av.a.a.c rBn = null;
    private af rBo;
    private h rBp;
    private cj.a rBq = new cj.a() {
        /* class com.tencent.mm.plugin.exdevice.model.ad.AnonymousClass8 */

        /* JADX WARNING: Removed duplicated region for block: B:7:0x0031  */
        @Override // com.tencent.mm.model.cj.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.ak.h.a r13) {
            /*
            // Method dump skipped, instructions count: 764
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.model.ad.AnonymousClass8.a(com.tencent.mm.ak.h$a):void");
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };
    MStorageEx.IOnStorageChange rBr = new MStorageEx.IOnStorageChange() {
        /* class com.tencent.mm.plugin.exdevice.model.ad.AnonymousClass9 */

        @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
        public final void onNotifyChange(int i2, MStorageEx mStorageEx, final Object obj) {
            AppMethodBeat.i(23452);
            try {
                if (!bg.aAc()) {
                    Log.w("MicroMsg.exdevice.SubCoreExDevice", "onNotifyChange,acc has not ready");
                    AppMethodBeat.o(23452);
                    return;
                }
                if (obj instanceof String) {
                    bg.aAk().postToWorkerDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.exdevice.model.ad.AnonymousClass9.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(23451);
                            String str = (String) obj;
                            if (ad.cKN().anD(str)) {
                                bg.aVF();
                                if (!com.tencent.mm.model.c.aSN().bjG(str)) {
                                    bg.azz().a(new com.tencent.mm.plugin.exdevice.g.a.h(str, null), 0);
                                }
                            }
                            AppMethodBeat.o(23451);
                        }
                    }, 2000);
                }
                AppMethodBeat.o(23452);
            } catch (Exception e2) {
                Log.e("MicroMsg.exdevice.SubCoreExDevice", "ap : onNotifyChange exception %s", e2.getMessage());
                AppMethodBeat.o(23452);
            }
        }
    };

    static {
        AppMethodBeat.i(23473);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("HARDDEVICEINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.exdevice.model.ad.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return c.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("HARDDEVICERANKINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.exdevice.model.ad.AnonymousClass3 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return d.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("HARDDEVICERANKFOLLOWINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.exdevice.model.ad.AnonymousClass4 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return a.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("HARDDEVICELIKEINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.exdevice.model.ad.AnonymousClass5 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return e.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("HARDDEVICECHAMPIONINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.exdevice.model.ad.AnonymousClass6 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return b.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("HARDDEVICERANKDETAILINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.exdevice.model.ad.AnonymousClass7 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.exdevice.g.b.b.c.SQL_CREATE;
            }
        });
        AppMethodBeat.o(23473);
    }

    public ad() {
        AppMethodBeat.i(23454);
        if (this.rBi == null) {
            this.rBi = new d();
        }
        if (this.rBh == null) {
            this.rBh = new e();
        }
        Log.i("MicroMsg.exdevice.SubCoreExDevice", "create SubCoreExDevice.");
        EventCenter.instance.addListener(this.rBh.ryU);
        AppMethodBeat.o(23454);
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    private static ad cKK() {
        AppMethodBeat.i(23455);
        bg.aVz();
        ad adVar = (ad) cg.KG("plugin.exdevice");
        if (adVar == null) {
            Log.w("MicroMsg.exdevice.SubCoreExDevice", "not found in MMCore, new one");
            adVar = new ad();
            bg.aVz().a("plugin.exdevice", adVar);
        }
        AppMethodBeat.o(23455);
        return adVar;
    }

    public static c cKL() {
        AppMethodBeat.i(23456);
        g.aAf().azk();
        if (cKK().rBc == null) {
            ad cKK = cKK();
            bg.aVF();
            cKK.rBc = new c(com.tencent.mm.model.c.getDataDB());
        }
        c cVar = cKK().rBc;
        AppMethodBeat.o(23456);
        return cVar;
    }

    public static d cKM() {
        AppMethodBeat.i(23457);
        g.aAf().azk();
        if (cKK().rBd == null) {
            ad cKK = cKK();
            bg.aVF();
            cKK.rBd = new d(com.tencent.mm.model.c.getDataDB());
        }
        d dVar = cKK().rBd;
        AppMethodBeat.o(23457);
        return dVar;
    }

    public static a cKN() {
        AppMethodBeat.i(23458);
        g.aAf().azk();
        if (cKK().rBe == null) {
            ad cKK = cKK();
            bg.aVF();
            cKK.rBe = new a(com.tencent.mm.model.c.getDataDB());
        }
        a aVar = cKK().rBe;
        AppMethodBeat.o(23458);
        return aVar;
    }

    public static com.tencent.mm.av.a.a cKO() {
        AppMethodBeat.i(23459);
        if (cKK().rBm == null) {
            cKK().rBm = q.bcV();
        }
        com.tencent.mm.av.a.a aVar = cKK().rBm;
        AppMethodBeat.o(23459);
        return aVar;
    }

    public static com.tencent.mm.av.a.a.c any(String str) {
        AppMethodBeat.i(23460);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.exdevice.SubCoreExDevice", "newImageOptions failed, url is null or nil, return default.");
            ad cKK = cKK();
            if (cKK.rBn == null) {
                c.a aVar = new c.a();
                q.bcW();
                aVar.jbw = null;
                aVar.hZA = 640;
                aVar.hZz = 640;
                aVar.jbd = false;
                aVar.jbf = true;
                cKK.rBn = aVar.bdv();
            }
            com.tencent.mm.av.a.a.c cVar = cKK().rBn;
            AppMethodBeat.o(23460);
            return cVar;
        }
        c.a aVar2 = new c.a();
        aVar2.hZA = 640;
        aVar2.hZz = 640;
        aVar2.jbd = false;
        aVar2.jbe = true;
        bg.aVF();
        aVar2.prefixPath = com.tencent.mm.model.c.aSY();
        com.tencent.mm.av.a.a.c bdv = aVar2.bdv();
        AppMethodBeat.o(23460);
        return bdv;
    }

    public static b cKP() {
        AppMethodBeat.i(23461);
        g.aAf().azk();
        if (cKK().rBf == null) {
            ad cKK = cKK();
            bg.aVF();
            cKK.rBf = new b(com.tencent.mm.model.c.getDataDB());
        }
        b bVar = cKK().rBf;
        AppMethodBeat.o(23461);
        return bVar;
    }

    public static e cKQ() {
        AppMethodBeat.i(23462);
        g.aAf().azk();
        if (cKK().rBg == null) {
            ad cKK = cKK();
            bg.aVF();
            cKK.rBg = new e(com.tencent.mm.model.c.getDataDB());
        }
        e eVar = cKK().rBg;
        AppMethodBeat.o(23462);
        return eVar;
    }

    public static b cKR() {
        AppMethodBeat.i(23463);
        g.aAf().azk();
        if (cKK().rBb == null) {
            cKK().rBb = new b();
        }
        b bVar = cKK().rBb;
        AppMethodBeat.o(23463);
        return bVar;
    }

    public static d cKS() {
        AppMethodBeat.i(23464);
        if (cKK().rBi == null) {
            cKK().rBi = new d();
        }
        d dVar = cKK().rBi;
        AppMethodBeat.o(23464);
        return dVar;
    }

    public static com.tencent.mm.plugin.exdevice.g.b.c cKT() {
        AppMethodBeat.i(23465);
        if (cKK().rBj == null) {
            cKK().rBj = new com.tencent.mm.plugin.exdevice.g.b.c();
        }
        com.tencent.mm.plugin.exdevice.g.b.c cVar = cKK().rBj;
        AppMethodBeat.o(23465);
        return cVar;
    }

    public static com.tencent.mm.plugin.exdevice.g.b.a cKU() {
        AppMethodBeat.i(23466);
        if (cKK().rBk == null) {
            cKK().rBk = new com.tencent.mm.plugin.exdevice.g.b.a();
        }
        com.tencent.mm.plugin.exdevice.g.b.a aVar = cKK().rBk;
        AppMethodBeat.o(23466);
        return aVar;
    }

    public static com.tencent.mm.plugin.exdevice.g.a.c cKV() {
        AppMethodBeat.i(23467);
        if (cKK().rBl == null) {
            cKK().rBl = new com.tencent.mm.plugin.exdevice.g.a.c();
        }
        com.tencent.mm.plugin.exdevice.g.a.c cVar = cKK().rBl;
        AppMethodBeat.o(23467);
        return cVar;
    }

    public static e cKW() {
        AppMethodBeat.i(23468);
        if (cKK().rBh == null) {
            cKK().rBh = new e();
        }
        e eVar = cKK().rBh;
        AppMethodBeat.o(23468);
        return eVar;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(23469);
        bg.aVF();
        com.tencent.mm.model.c.aSN().add(this.rBr);
        bg.azz().a(538, k.cKl());
        this.rBo = new af();
        EventCenter.instance.addListener(this.rBa);
        bg.getSysCmdMsgExtension().a("wcdevicemsg", this.rBq, true);
        EventCenter.instance.addListener(cKW().ryv);
        EventCenter.instance.addListener(cKW().ryw);
        EventCenter.instance.addListener(cKW().ryx);
        EventCenter.instance.addListener(cKW().ryQ);
        EventCenter.instance.addListener(cKW().ryu);
        EventCenter.instance.addListener(cKW().ryt);
        EventCenter.instance.addListener(cKW().ryy);
        EventCenter.instance.addListener(cKW().ryz);
        EventCenter.instance.addListener(cKW().ryA);
        EventCenter.instance.addListener(cKW().ryR);
        EventCenter.instance.addListener(cKW().ryB);
        EventCenter.instance.addListener(cKW().ryC);
        EventCenter.instance.addListener(cKW().ryD);
        EventCenter.instance.addListener(cKW().ryF);
        EventCenter.instance.addListener(cKW().ryE);
        EventCenter.instance.addListener(cKW().ryJ);
        EventCenter.instance.addListener(cKW().ryH);
        EventCenter.instance.addListener(cKW().ryI);
        EventCenter.instance.addListener(cKW().ryK);
        EventCenter.instance.addListener(cKW().ryS);
        EventCenter.instance.addListener(cKW().oVj);
        EventCenter.instance.addListener(cKW().ryG);
        EventCenter.instance.addListener(cKW().ryL);
        EventCenter.instance.addListener(cKW().ryM);
        EventCenter.instance.addListener(cKW().ryN);
        EventCenter.instance.addListener(cKW().ryO);
        EventCenter.instance.addListener(cKW().rzb);
        EventCenter.instance.addListener(cKW().rzc);
        EventCenter.instance.addListener(cKW().rzd);
        EventCenter.instance.addListener(cKW().rzf);
        EventCenter.instance.addListener(cKW().rze);
        EventCenter.instance.addListener(cKW().ryV);
        EventCenter.instance.addListener(cKW().ryW);
        EventCenter.instance.addListener(cKW().ryX);
        EventCenter.instance.addListener(cKW().ryY);
        EventCenter.instance.addListener(cKW().ryZ);
        EventCenter.instance.addListener(cKW().rza);
        EventCenter.instance.addListener(cKW().ryT);
        EventCenter.instance.addListener(cKW().ryU);
        i iVar = i.INSTANCE;
        Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "addSceneEndListener");
        bg.azz().a(539, iVar);
        com.tencent.mm.compatible.a.a.a(19, new a.AbstractC0298a() {
            /* class com.tencent.mm.plugin.exdevice.model.ad.AnonymousClass10 */

            @Override // com.tencent.mm.compatible.a.a.AbstractC0298a
            public final void run() {
                AppMethodBeat.i(23453);
                ad.a(ad.this);
                AppMethodBeat.o(23453);
            }
        });
        g.b(com.tencent.mm.plugin.exdevice.a.b.class, new com.tencent.mm.plugin.exdevice.a.a());
        AppMethodBeat.o(23469);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(23470);
        bg.aVF();
        com.tencent.mm.model.c.aSN().remove(this.rBr);
        EventCenter.instance.removeListener(cKW().ryv);
        EventCenter.instance.removeListener(cKW().ryw);
        EventCenter.instance.removeListener(cKW().ryx);
        EventCenter.instance.removeListener(cKW().ryQ);
        EventCenter.instance.removeListener(cKW().ryS);
        EventCenter.instance.removeListener(cKW().ryu);
        EventCenter.instance.removeListener(cKW().ryt);
        EventCenter.instance.removeListener(cKW().ryy);
        EventCenter.instance.removeListener(cKW().ryz);
        EventCenter.instance.removeListener(cKW().ryA);
        EventCenter.instance.removeListener(cKW().ryR);
        EventCenter.instance.removeListener(cKW().rzb);
        EventCenter.instance.removeListener(cKW().rzc);
        EventCenter.instance.removeListener(cKW().rzd);
        EventCenter.instance.removeListener(cKW().rzf);
        EventCenter.instance.removeListener(cKW().rze);
        EventCenter.instance.removeListener(cKW().ryV);
        EventCenter.instance.removeListener(cKW().ryW);
        EventCenter.instance.removeListener(cKW().ryX);
        EventCenter.instance.removeListener(cKW().ryY);
        EventCenter.instance.removeListener(cKW().ryZ);
        EventCenter.instance.removeListener(cKW().rza);
        EventCenter.instance.removeListener(cKW().ryC);
        EventCenter.instance.removeListener(cKW().ryT);
        EventCenter.instance.removeListener(cKW().ryU);
        Log.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "releaseAllSharePreferences");
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
        } else if (!sharedPreferences.edit().clear().commit()) {
            Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().clear().commit() Failed!!!");
        }
        f cLx = u.cLx();
        Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "delAllDeviceAuthFlag");
        if (cLx.rDC == null) {
            Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "null == exdeviceInfoList");
        } else {
            for (Map.Entry<Long, f.a> entry : cLx.rDC.entrySet()) {
                f.a value = entry.getValue();
                value.rDG = false;
                entry.setValue(value);
            }
        }
        bg.azz().b(538, k.cKl());
        k.rxE = null;
        EventCenter.instance.removeListener(this.rBa);
        bg.getSysCmdMsgExtension().b("wcdevicemsg", this.rBq, true);
        EventCenter.instance.removeListener(cKW().ryB);
        if (cKK().rBb != null) {
            cKK();
        }
        i iVar = i.INSTANCE;
        Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "removeSceneEndListener");
        bg.azz().b(539, iVar);
        if (iVar.gtM != null && iVar.gtM.isShowing()) {
            iVar.gtM.dismiss();
            iVar.gtM = null;
        }
        d dVar = cKK().rBi;
        if (dVar.rya != null && !dVar.rya.isEmpty()) {
            for (Map.Entry<Long, MTimerHandler> entry2 : dVar.rya.entrySet()) {
                entry2.getValue().stopTimer();
            }
            dVar.rya.clear();
        }
        if (cKK().rBj != null) {
            com.tencent.mm.plugin.exdevice.g.b.c cVar = cKK().rBj;
            bg.azz().b(1042, cVar);
            bg.azz().b(1041, cVar);
            bg.azz().b(1043, cVar);
            bg.azz().b(XWalkFeature.INTERFACE_SHOW_HIDE, cVar);
        }
        if (cKK().rBm != null) {
            cKK().rBm.detach();
        }
        EventCenter.instance.removeListener(this.rBo.gmC);
        g.ag(com.tencent.mm.plugin.exdevice.a.b.class);
        AppMethodBeat.o(23470);
    }

    public static h cKX() {
        AppMethodBeat.i(23471);
        if (cKK().rBp == null) {
            cKK().rBp = new h();
        }
        h hVar = cKK().rBp;
        AppMethodBeat.o(23471);
        return hVar;
    }

    static /* synthetic */ void a(ad adVar) {
        AppMethodBeat.i(23472);
        try {
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.exdevice.model.ad.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(23449);
                    boolean hasSystemFeature = MMApplicationContext.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
                    boolean hasSystemFeature2 = MMApplicationContext.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
                    if (hasSystemFeature && hasSystemFeature2) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11891, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, true, true);
                    } else if (hasSystemFeature) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11891, "1", true, true);
                    } else if (hasSystemFeature2) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11891, "2", true, true);
                    }
                    Log.i("MicroMsg.exdevice.SubCoreExDevice", "[hakon][step] deviceFeatures stepCounter %s, stepDetector %s", Boolean.valueOf(hasSystemFeature), Boolean.valueOf(hasSystemFeature2));
                    AppMethodBeat.o(23449);
                }
            }, 30000);
            AppMethodBeat.o(23472);
        } catch (Exception e2) {
            Log.e("MicroMsg.exdevice.SubCoreExDevice", "[hakon][step] exception in deviceFeaturesKVStat, %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.exdevice.SubCoreExDevice", e2, "", new Object[0]);
            AppMethodBeat.o(23472);
        }
    }
}
