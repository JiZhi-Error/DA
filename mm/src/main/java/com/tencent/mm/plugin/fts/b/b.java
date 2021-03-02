package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.yn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.c.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.recovery.wx.WXConstantsRecovery;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b extends com.tencent.mm.plugin.fts.a.b {
    m hgI;
    private IListener<bp> iUx = new IListener<bp>() {
        /* class com.tencent.mm.plugin.fts.b.b.AnonymousClass2 */

        {
            AppMethodBeat.i(160980);
            this.__eventId = bp.class.getName().hashCode();
            AppMethodBeat.o(160980);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bp bpVar) {
            AppMethodBeat.i(52696);
            final bp bpVar2 = bpVar;
            if (bpVar2.dEN.dEO == 35 && bpVar2.dEN.subType == 1) {
                Log.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "CheckResUpdateCacheFileEvent: %s", bpVar2.dEN.filePath);
                h.RTc.b(new Runnable() {
                    /* class com.tencent.mm.plugin.fts.b.b.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(187309);
                        b bVar = b.this;
                        String str = bpVar2.dEN.filePath;
                        o oVar = new o(b.dON(), "temp");
                        if (oVar.exists()) {
                            s.dy(aa.z(oVar.her()), true);
                        }
                        oVar.mkdirs();
                        try {
                            int fW = s.fW(str, aa.z(oVar.her()));
                            Log.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "unzip %s %d", str, Integer.valueOf(fW));
                            if (fW >= 0) {
                                o dOO = b.dOO();
                                o oVar2 = new o(oVar, "fts_feature");
                                int S = b.S(oVar2);
                                int S2 = b.S(dOO);
                                Log.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "updateFeatureList: updateVersion %d currentVersion %d", Integer.valueOf(S), Integer.valueOf(S2));
                                if (S > S2) {
                                    s.dy(aa.z(dOO.her()), true);
                                    oVar2.am(dOO);
                                    bVar.hgI.a(65596, new d(aa.z(dOO.her())));
                                }
                            }
                            AppMethodBeat.o(187309);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e2, "updateFeatureList", new Object[0]);
                            e.Nk(22);
                            AppMethodBeat.o(187309);
                        }
                    }
                }, "FTS.updateFeatureList");
            }
            AppMethodBeat.o(52696);
            return true;
        }
    };
    com.tencent.mm.plugin.fts.c.b wYL;
    private IListener wYg = new IListener<yn>() {
        /* class com.tencent.mm.plugin.fts.b.b.AnonymousClass1 */

        {
            AppMethodBeat.i(160979);
            this.__eventId = yn.class.getName().hashCode();
            AppMethodBeat.o(160979);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(yn ynVar) {
            AppMethodBeat.i(52694);
            b.this.hgI.a(65596, new d(aa.z(b.dOO().her())));
            AppMethodBeat.o(52694);
            return true;
        }
    };

    public b() {
        AppMethodBeat.i(52702);
        AppMethodBeat.o(52702);
    }

    @Override // com.tencent.mm.plugin.fts.a.k, com.tencent.mm.plugin.fts.a.b
    public final com.tencent.mm.plugin.fts.a.a.a a(j jVar) {
        AppMethodBeat.i(52703);
        com.tencent.mm.plugin.fts.a.a.a a2 = this.hgI.a(-65536, new c(this, jVar, (byte) 0));
        AppMethodBeat.o(52703);
        return a2;
    }

    @Override // com.tencent.mm.plugin.fts.a.b
    public final boolean onCreate() {
        AppMethodBeat.i(52704);
        if (!((n) g.ah(n.class)).isFTSContextReady()) {
            Log.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Fail!");
            AppMethodBeat.o(52704);
            return false;
        }
        Log.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Success!");
        this.hgI = ((n) g.ah(n.class)).getFTSTaskDaemon();
        this.wYL = (com.tencent.mm.plugin.fts.c.b) ((n) g.ah(n.class)).getFTSIndexStorage(17);
        this.wYg.alive();
        this.iUx.alive();
        this.hgI.a(131132, new C1376b(this, (byte) 0));
        this.hgI.a(131133, new a(this, (byte) 0));
        AppMethodBeat.o(52704);
        return true;
    }

    @Override // com.tencent.mm.plugin.fts.a.b
    public final boolean axa() {
        AppMethodBeat.i(52705);
        this.wYg.dead();
        this.iUx.dead();
        this.wYL = null;
        this.hgI = null;
        AppMethodBeat.o(52705);
        return true;
    }

    @Override // com.tencent.mm.plugin.fts.a.k
    public final String getName() {
        return "FTS5SearchFeatureLogic";
    }

    class c extends i {
        /* synthetic */ c(b bVar, j jVar, byte b2) {
            this(jVar);
        }

        private c(j jVar) {
            super(jVar);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "SearchFeatureTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final int getId() {
            return 12;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(k kVar) {
            AppMethodBeat.i(52700);
            kVar.wWd = com.tencent.mm.plugin.fts.a.a.h.bE(this.wWO.query, true);
            kVar.wXb = new ArrayList();
            HashSet hashSet = new HashSet();
            Cursor a2 = b.this.wYL.a(kVar.wWd, com.tencent.mm.plugin.fts.a.c.wUE, this.wWO.wWV, true, true);
            while (a2.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.n nVar = new com.tencent.mm.plugin.fts.a.a.n();
                nVar.i(a2);
                if (!hashSet.contains(Long.valueOf(nVar.wXe)) && !this.wWO.wWX.contains(nVar.wVX)) {
                    nVar.dOC();
                    kVar.wXb.add(nVar);
                    hashSet.add(Long.valueOf(nVar.wXe));
                }
            }
            if (a2 != null) {
                a2.close();
            }
            if (Thread.interrupted()) {
                InterruptedException interruptedException = new InterruptedException();
                AppMethodBeat.o(52700);
                throw interruptedException;
            }
            if (this.wWO.wWY != null) {
                Collections.sort(kVar.wXb, this.wWO.wWY);
            }
            for (com.tencent.mm.plugin.fts.a.a.m mVar : kVar.wXb) {
                mVar.userData = b.this.wYL.Np((int) mVar.wXe);
            }
            AppMethodBeat.o(52700);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.b$b  reason: collision with other inner class name */
    class C1376b extends com.tencent.mm.plugin.fts.a.a.a {
        private C1376b() {
        }

        /* synthetic */ C1376b(b bVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52699);
            int S = b.S(b.dOO());
            int dOP = b.dOP();
            Log.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "start to check feature resource task %d, pkgversion:%s", Integer.valueOf(S), Integer.valueOf(dOP));
            if (dOP > S && dOP > 0) {
                S = -1;
            }
            if (S < 0) {
                o oVar = new o(MMApplicationContext.getContext().getCacheDir(), "fts/feature/fts_feature.zip");
                byte[] aW = s.aW("assets:///fts/feature/fts_feature.zip", 0, -1);
                if (oVar.exists()) {
                    oVar.delete();
                }
                if (!oVar.heq().exists()) {
                    oVar.heq().mkdirs();
                }
                s.f(aa.z(oVar.her()), aW, aW.length);
                bp bpVar = new bp();
                bpVar.dEN.dEO = 35;
                bpVar.dEN.subType = 1;
                bpVar.dEN.filePath = aa.z(oVar.her());
                EventCenter.instance.asyncPublish(bpVar, Looper.getMainLooper());
            }
            AppMethodBeat.o(52699);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "CheckFeatureResourceTask";
        }
    }

    class a extends com.tencent.mm.plugin.fts.a.a.a {
        private int wYO;
        private int wYP;

        private a() {
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52697);
            Log.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "start to build feature index task");
            com.tencent.mm.plugin.fts.c.b bVar = b.this.wYL;
            List<com.tencent.mm.plugin.fts.a.a.d> arrayList = new ArrayList<>();
            Cursor rawQuery = bVar.wUt.rawQuery(String.format("SELECT * FROM Feature", new Object[0]), null);
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.d dVar = new com.tencent.mm.plugin.fts.a.a.d();
                dVar.convertFrom(rawQuery);
                arrayList.add(dVar);
            }
            rawQuery.close();
            if (arrayList.size() == 0) {
                try {
                    arrayList = b.ayD(aa.z(b.dOO().her()));
                    b.this.wYL.eR(arrayList);
                } catch (Exception e2) {
                }
            }
            List<b.a> dOY = b.this.wYL.dOY();
            HashMap hashMap = new HashMap();
            for (com.tencent.mm.plugin.fts.a.a.d dVar2 : arrayList) {
                hashMap.put(Integer.valueOf(dVar2.field_featureId), dVar2);
            }
            if (b.this.wYL.wUt.inTransaction()) {
                b.this.wYL.commit();
            }
            b.this.wYL.beginTransaction();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (b.a aVar : dOY) {
                com.tencent.mm.plugin.fts.a.a.d dVar3 = (com.tencent.mm.plugin.fts.a.a.d) hashMap.remove(Integer.valueOf(aVar.wZI));
                if (dVar3 == null) {
                    hashSet.add(Integer.valueOf(aVar.wZI));
                } else if (aVar.timestamp != dVar3.field_timestamp) {
                    hashSet2.add(dVar3);
                    b.this.wYL.c(com.tencent.mm.plugin.fts.a.c.wUE, (long) dVar3.field_featureId);
                    ((PluginFTS) g.ah(PluginFTS.class)).getTopHitsLogic().c(com.tencent.mm.plugin.fts.a.c.wUE, String.valueOf(dVar3.field_featureId));
                }
            }
            hashSet2.addAll(hashMap.values());
            b.this.wYL.commit();
            b.this.wYL.beginTransaction();
            this.wYO = hashSet.size();
            this.wYP = hashSet2.size();
            Iterator it = hashSet2.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.fts.a.a.d dVar4 = (com.tencent.mm.plugin.fts.a.a.d) it.next();
                b bVar2 = b.this;
                bVar2.wYL.a(TPMediaCodecProfileLevel.HEVCMainTierLevel52, 1, (long) dVar4.field_featureId, String.valueOf(dVar4.field_featureId), dVar4.field_timestamp, dVar4.field_title);
                String bB = com.tencent.mm.plugin.fts.a.d.bB(dVar4.field_title, false);
                if (!Util.isNullOrNil(bB)) {
                    bVar2.wYL.a(TPMediaCodecProfileLevel.HEVCMainTierLevel52, 2, (long) dVar4.field_featureId, String.valueOf(dVar4.field_featureId), dVar4.field_timestamp, bB);
                }
                String bB2 = com.tencent.mm.plugin.fts.a.d.bB(dVar4.field_title, true);
                if (!Util.isNullOrNil(bB2)) {
                    bVar2.wYL.a(TPMediaCodecProfileLevel.HEVCMainTierLevel52, 3, (long) dVar4.field_featureId, String.valueOf(dVar4.field_featureId), dVar4.field_timestamp, bB2);
                }
                bVar2.wYL.a(TPMediaCodecProfileLevel.HEVCMainTierLevel52, 4, (long) dVar4.field_featureId, String.valueOf(dVar4.field_featureId), dVar4.field_timestamp, dVar4.field_tag);
                ((PluginFTS) g.ah(PluginFTS.class)).getTopHitsLogic().ayF(String.valueOf(dVar4.field_featureId));
            }
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                b.this.wYL.c(com.tencent.mm.plugin.fts.a.c.wUE, (long) ((Integer) it2.next()).intValue());
            }
            b.this.wYL.commit();
            AppMethodBeat.o(52697);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String bCQ() {
            AppMethodBeat.i(52698);
            String format = String.format("{remove: %d add: %d}", Integer.valueOf(this.wYO), Integer.valueOf(this.wYP));
            AppMethodBeat.o(52698);
            return format;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "BuildFeatureIndexTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final int getId() {
            return 5;
        }
    }

    class d extends com.tencent.mm.plugin.fts.a.a.a {
        private String path;

        public d(String str) {
            this.path = str;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "UpdateFeatureIndexTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52701);
            List<com.tencent.mm.plugin.fts.a.a.d> ayD = b.ayD(this.path);
            b.this.wYL.beginTransaction();
            b.this.wYL.eR(ayD);
            b.this.wYL.commit();
            b.this.wYL.B(com.tencent.mm.plugin.fts.a.c.wUE);
            b.this.hgI.a(131132, new a(b.this, (byte) 0));
            e topHitsLogic = ((PluginFTS) g.ah(PluginFTS.class)).getTopHitsLogic();
            topHitsLogic.wZn.j(com.tencent.mm.plugin.fts.a.c.wUE, 1);
            AppMethodBeat.o(52701);
            return true;
        }
    }

    public static o dON() {
        AppMethodBeat.i(52706);
        o oVar = new o(new o(com.tencent.mm.loader.j.b.aKC(), "fts"), "feature");
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        AppMethodBeat.o(52706);
        return oVar;
    }

    public static o dOO() {
        AppMethodBeat.i(52707);
        o oVar = new o(dON(), "fts_feature");
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        AppMethodBeat.o(52707);
        return oVar;
    }

    static int S(o oVar) {
        AppMethodBeat.i(52708);
        o oVar2 = new o(oVar, WXConstantsRecovery.VersionInfoFile);
        int i2 = -1;
        try {
            if (oVar2.exists()) {
                i2 = Integer.parseInt(s.boY(aa.z(oVar2.her())), 10);
            } else {
                Log.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "version file %s not exist", aa.z(oVar2.her()));
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e2, "getFeatureVersion", new Object[0]);
        }
        AppMethodBeat.o(52708);
        return i2;
    }

    static int dOP() {
        BufferedReader bufferedReader;
        Throwable th;
        Exception e2;
        AppMethodBeat.i(52709);
        int i2 = -1;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(MMApplicationContext.getContext().getAssets().open("fts/feature/version.info")));
            try {
                i2 = Integer.valueOf(bufferedReader.readLine()).intValue();
                Util.qualityClose(bufferedReader);
            } catch (Exception e3) {
                e2 = e3;
                try {
                    Log.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e2, e2.getMessage(), new Object[0]);
                    Util.qualityClose(bufferedReader);
                    AppMethodBeat.o(52709);
                    return i2;
                } catch (Throwable th2) {
                    th = th2;
                    Util.qualityClose(bufferedReader);
                    AppMethodBeat.o(52709);
                    throw th;
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            bufferedReader = null;
            Log.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e2, e2.getMessage(), new Object[0]);
            Util.qualityClose(bufferedReader);
            AppMethodBeat.o(52709);
            return i2;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            Util.qualityClose(bufferedReader);
            AppMethodBeat.o(52709);
            throw th;
        }
        AppMethodBeat.o(52709);
        return i2;
    }

    static /* synthetic */ List ayD(String str) {
        String lowerCase;
        int indexOf;
        AppMethodBeat.i(52710);
        Object[] objArr = new Object[2];
        objArr[0] = str;
        String currentLanguage = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        if (currentLanguage.equalsIgnoreCase(LocaleUtil.CHINA)) {
            lowerCase = LocaleUtil.CHINA.toLowerCase();
        } else if (currentLanguage.equalsIgnoreCase(LocaleUtil.TAIWAN) || currentLanguage.equalsIgnoreCase(LocaleUtil.HONGKONG)) {
            lowerCase = LocaleUtil.TAIWAN.toLowerCase();
        } else {
            lowerCase = LocaleUtil.ENGLISH.toLowerCase();
        }
        objArr[1] = lowerCase;
        String format = String.format("%s/feature_%s.conf", objArr);
        Log.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "decodeToFeatureList %s", format);
        long boX = s.boX(format);
        int boW = (int) s.boW(format);
        ArrayList arrayList = new ArrayList();
        if (boW == 0) {
            com.tencent.mm.plugin.fts.a.a.o oVar = new com.tencent.mm.plugin.fts.a.a.o("data file no exist error");
            AppMethodBeat.o(52710);
            throw oVar;
        }
        String[] split = new String(s.aW(format, 0, boW)).split("\n");
        com.tencent.mm.plugin.fts.a.a.d dVar = null;
        for (String str2 : split) {
            if (str2 != null) {
                String trim = str2.trim();
                if (trim.length() != 0 && (indexOf = trim.indexOf("=")) >= 0) {
                    String substring = trim.substring(0, indexOf);
                    String substring2 = trim.substring(indexOf + 1);
                    if (substring.equals("FeatureID")) {
                        if (dVar != null) {
                            dVar.field_iconPath = str + "/icon/" + dVar.field_featureId + ".png";
                            arrayList.add(dVar);
                        }
                        dVar = new com.tencent.mm.plugin.fts.a.a.d();
                        dVar.field_featureId = Util.getInt(substring2, 0);
                        dVar.field_timestamp = boX;
                    }
                    if (dVar != null) {
                        if (substring.equals("Title")) {
                            dVar.field_title = WeChatBrands.Wordings.translate(substring2);
                        } else if (substring.equals("TitlePY")) {
                            dVar.field_titlePY = substring2;
                        } else if (substring.equals("TitleShortPY")) {
                            dVar.field_titleShortPY = substring2;
                        } else if (substring.equals("Tag")) {
                            dVar.field_tag = WeChatBrands.Wordings.translate(substring2);
                        } else if (substring.equals("ActionType")) {
                            if (substring2.equals("H5")) {
                                dVar.field_actionType = 2;
                            } else if (substring2.equals("Native")) {
                                dVar.field_actionType = 1;
                            }
                        } else if (substring.equals("Url")) {
                            dVar.field_url = WeChatBrands.Wordings.translate(substring2);
                        } else if (substring.equals("HelpUrl")) {
                            dVar.field_helpUrl = WeChatBrands.Wordings.translate(substring2);
                        } else if (substring.equals("UpdateUrl")) {
                            if (!WeChatSomeFeatureSwitch.blockFTSUpdate()) {
                                dVar.field_updateUrl = WeChatBrands.Wordings.translate(substring2);
                            }
                        } else if (substring.equals("AndroidUrl")) {
                            dVar.field_androidUrl = WeChatBrands.Wordings.translate(substring2);
                        }
                    }
                }
            }
        }
        if (dVar != null) {
            dVar.field_iconPath = str + "/icon/" + dVar.field_featureId + ".png";
            dVar.field_timestamp = boX;
            arrayList.add(dVar);
        }
        if (arrayList.size() == 0) {
            com.tencent.mm.plugin.fts.a.a.o oVar2 = new com.tencent.mm.plugin.fts.a.a.o("no data error");
            AppMethodBeat.o(52710);
            throw oVar2;
        }
        AppMethodBeat.o(52710);
        return arrayList;
    }
}
