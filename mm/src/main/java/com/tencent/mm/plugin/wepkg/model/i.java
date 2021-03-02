package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.aod;
import com.tencent.mm.protocal.protobuf.dbq;
import com.tencent.mm.protocal.protobuf.eya;
import com.tencent.mm.protocal.protobuf.fbd;
import com.tencent.mm.protocal.protobuf.fbh;
import com.tencent.mm.protocal.protobuf.fbk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i {

    public interface a {
        void aR(JSONObject jSONObject);
    }

    public static synchronized h bcF(String str) {
        h hVar;
        HashMap hashMap;
        synchronized (i.class) {
            AppMethodBeat.i(110712);
            Log.d("MicroMsg.Wepkg.WepkgManager", "loadWepkg");
            String bcO = d.bcO(str);
            String bcP = d.bcP(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (Util.isNullOrNil(bcO) || Util.isNullOrNil(bcP)) {
                Log.e("MicroMsg.Wepkg.WepkgManager", "pkgId = %s, domain = %s", bcO, bcP);
                hVar = new h(8, false, "");
                AppMethodBeat.o(110712);
            } else {
                h.INSTANCE.idkeyStat(859, 6, 1, false);
                WepkgVersion bcI = j.bcI(bcO);
                if (bcI == null) {
                    Log.i("MicroMsg.Wepkg.WepkgManager", "DB dont have valid record, pkgid:%s, domain:%s, version:%s:", bcO, "", "");
                    com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", str, bcO, null, 0, 0, com.tencent.mm.plugin.wepkg.utils.a.ahr(14));
                    h.INSTANCE.idkeyStat(859, 7, 1, false);
                    hVar = new h(14, false, "");
                    AppMethodBeat.o(110712);
                } else if (!bcI.JNV || (!bcI.JNW && bcI.JNX)) {
                    Log.i("MicroMsg.Wepkg.WepkgManager", "local cache disable, pkgid:%s, version:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s", bcI.hhD, bcI.version, Boolean.valueOf(bcI.JNV), Boolean.valueOf(bcI.JNW), Boolean.valueOf(bcI.JNX));
                    com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", str, bcO, bcI.version, 0, 0, com.tencent.mm.plugin.wepkg.utils.a.ahr(16));
                    h.INSTANCE.idkeyStat(859, 10, 1, false);
                    hVar = new h(16, false, bcI.version);
                    AppMethodBeat.o(110712);
                } else if (!bcP.equalsIgnoreCase(bcI.domain)) {
                    Log.i("MicroMsg.Wepkg.WepkgManager", "the domain not match, pkgid:%s, version:%s, UrlDomain[%s] != DBDomain[%s]", bcO, bcI.version, bcP, bcI.domain);
                    com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", str, bcO, null, 0, 0, com.tencent.mm.plugin.wepkg.utils.a.ahr(13));
                    h.INSTANCE.idkeyStat(859, 8, 1, false);
                    hVar = new h(13, true, bcI.version);
                    AppMethodBeat.o(110712);
                } else if (Util.isNullOrNil(bcI.version)) {
                    Log.i("MicroMsg.Wepkg.WepkgManager", "this pkgid(%s) is disable form server", bcO);
                    com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", str, bcO, null, 0, 0, com.tencent.mm.plugin.wepkg.utils.a.ahr(15));
                    h.INSTANCE.idkeyStat(859, 9, 1, false);
                    hVar = new h(15, true, bcI.version);
                    AppMethodBeat.o(110712);
                } else {
                    g a2 = a(bcO, bcI.version, bcI.pkgPath, bcI.md5, bcI.JNT);
                    if (a2 != null || Util.isNullOrNil(bcI.pkgPath)) {
                        boolean z = bcI.JNX;
                        if (Util.isNullOrNil(bcO)) {
                            hashMap = null;
                        } else {
                            hashMap = new HashMap();
                            List<WepkgPreloadFile> bcL = j.bcL(bcO);
                            if (!Util.isNullOrNil(bcL)) {
                                boolean z2 = false;
                                for (WepkgPreloadFile wepkgPreloadFile : bcL) {
                                    if (wepkgPreloadFile != null) {
                                        if (Util.isNullOrNil(wepkgPreloadFile.filePath)) {
                                            Log.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath is null, isAtomic:%s", Boolean.valueOf(z));
                                            if (z) {
                                                mu(wepkgPreloadFile.hhD, wepkgPreloadFile.JNn);
                                                z2 = true;
                                            } else {
                                                j.a(bcO, wepkgPreloadFile.JNn, "", (a) null);
                                            }
                                        } else {
                                            o oVar = new o(wepkgPreloadFile.filePath);
                                            if (!oVar.exists()) {
                                                Log.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath:%s, file dont exist, isAtomic:%s", wepkgPreloadFile.filePath, Boolean.valueOf(z));
                                                if (z) {
                                                    mu(wepkgPreloadFile.hhD, wepkgPreloadFile.JNn);
                                                    z2 = true;
                                                } else {
                                                    j.a(bcO, wepkgPreloadFile.JNn, "", (a) null);
                                                }
                                            } else if (oVar.length() != ((long) wepkgPreloadFile.size)) {
                                                Log.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, [server_pkgSize:%d] != [local_pkgSize:%d], isAtomic:%s", Integer.valueOf(wepkgPreloadFile.size), Long.valueOf(oVar.length()), Boolean.valueOf(z));
                                                if (z) {
                                                    mu(wepkgPreloadFile.hhD, wepkgPreloadFile.JNn);
                                                    oVar.delete();
                                                    z2 = true;
                                                } else {
                                                    j.a(bcO, wepkgPreloadFile.JNn, "", (a) null);
                                                }
                                            } else {
                                                hashMap.put(wepkgPreloadFile.JNn, wepkgPreloadFile);
                                            }
                                        }
                                    }
                                }
                                if (z2) {
                                    hashMap = null;
                                }
                            }
                        }
                        if (hashMap == null) {
                            com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", str, bcO, bcI.version, 0, 0, com.tencent.mm.plugin.wepkg.utils.a.ahr(18));
                            h.INSTANCE.idkeyStat(859, 11, 1, false);
                            hVar = new h(18, true, bcI.version);
                            AppMethodBeat.o(110712);
                        } else {
                            hVar = new h(bcI, a2, hashMap);
                            Log.i("MicroMsg.Wepkg.WepkgManager", "loadWepkg time:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            h.INSTANCE.idkeyStat(859, 12, 1, false);
                            AppMethodBeat.o(110712);
                        }
                    } else {
                        com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", str, bcO, bcI.version, 0, 0, com.tencent.mm.plugin.wepkg.utils.a.ahr(17));
                        h.INSTANCE.idkeyStat(859, 11, 1, false);
                        hVar = new h(17, true, bcI.version);
                        AppMethodBeat.o(110712);
                    }
                }
            }
        }
        return hVar;
    }

    public static List<String> a(dbq dbq) {
        AppMethodBeat.i(110713);
        if (dbq == null || dbq.MGA == null) {
            AppMethodBeat.o(110713);
            return null;
        }
        fbd fbd = dbq.MGA.NxH;
        fbk fbk = dbq.MGA.NxI;
        ArrayList arrayList = new ArrayList();
        if (!(fbd == null || fbd.Nxt == null)) {
            arrayList.add(MD5Util.getMD5String(dbq.xJD + fbd.Nxt.xuc));
        }
        if (fbk != null && !Util.isNullOrNil(fbk.NxE)) {
            Iterator<fbh> it = fbk.NxE.iterator();
            while (it.hasNext()) {
                fbh next = it.next();
                if (!(next == null || next.Nxt == null)) {
                    arrayList.add(MD5Util.getMD5String(dbq.xJD + next.Nxt.xuc));
                }
            }
        }
        AppMethodBeat.o(110713);
        return arrayList;
    }

    public static g a(String str, String str2, String str3, String str4, int i2) {
        AppMethodBeat.i(110714);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str3) || Util.isNullOrNil(str4)) {
            Log.i("MicroMsg.Wepkg.WepkgManager", "pkgid or pkgPath or md5 is null, pkg invalid");
            AppMethodBeat.o(110714);
            return null;
        }
        o oVar = new o(str3);
        if (!oVar.exists()) {
            Log.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, pkgPath:%s, file dont exist", str3);
            bcG(str);
            com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, str, str2, 1, 0, null);
            AppMethodBeat.o(110714);
            return null;
        } else if (oVar.length() != ((long) i2)) {
            Log.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, [server_pkgSize:%d] != [local_pkgSize:%d]", Integer.valueOf(i2), Long.valueOf(oVar.length()));
            oVar.delete();
            bcG(str);
            com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, str, str2, 2, 0, null);
            AppMethodBeat.o(110714);
            return null;
        } else {
            if (oVar.length() <= 5242880) {
                String bhK = s.bhK(aa.z(oVar.mUri));
                if (!str4.equalsIgnoreCase(bhK)) {
                    Log.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage, [server_md5:%s] != [local_md5:%s]", str4, bhK);
                    oVar.delete();
                    bcG(str);
                    com.tencent.mm.plugin.wepkg.utils.a.b("PkgModified", null, str, str2, 3, 0, null);
                    AppMethodBeat.o(110714);
                    return null;
                }
            } else {
                Log.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage fileLength(%d) > checkSize(%d). dont check md5", Long.valueOf(oVar.length()), 5242880L);
            }
            Log.i("MicroMsg.Wepkg.WepkgManager", "this is big package. localPath: %s", str3);
            g gVar = new g(oVar);
            if (!gVar.kKk || gVar.JNe == null) {
                c.gkN();
                c.aI(str, 2, 4);
                AppMethodBeat.o(110714);
                return null;
            }
            AppMethodBeat.o(110714);
            return gVar;
        }
    }

    public static void a(final a aVar) {
        AppMethodBeat.i(110715);
        final String gkQ = e.gkQ();
        final o oVar = new o(gkQ);
        if (!oVar.exists() || !oVar.isDirectory()) {
            aVar.aR(null);
        }
        final WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.EX = 1001;
        wepkgCrossProcessTask.lyv = new Runnable() {
            /* class com.tencent.mm.plugin.wepkg.model.i.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(110710);
                if (wepkgCrossProcessTask.result) {
                    d.cyh().postToWorker(new Runnable() {
                        /* class com.tencent.mm.plugin.wepkg.model.i.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(110709);
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("rootDir", gkQ);
                                HashMap hashMap = new HashMap();
                                i.a(oVar, hashMap);
                                JSONArray jSONArray = new JSONArray();
                                for (Map.Entry entry : hashMap.entrySet()) {
                                    if (((List) entry.getValue()).size() != 0) {
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("pkgId", entry.getKey());
                                        WepkgVersion bcH = j.bcH((String) entry.getKey());
                                        if (bcH != null) {
                                            jSONObject2.put("controlInfo", bcH.gkT());
                                        }
                                        List<WepkgPreloadFile> bcL = j.bcL((String) entry.getKey());
                                        if (!Util.isNullOrNil(bcL)) {
                                            JSONArray jSONArray2 = new JSONArray();
                                            for (WepkgPreloadFile wepkgPreloadFile : bcL) {
                                                jSONArray2.put(wepkgPreloadFile.gkT());
                                            }
                                            jSONObject2.put("preloadFilesInfo", jSONArray2);
                                        }
                                        JSONArray jSONArray3 = new JSONArray();
                                        for (b bVar : (List) entry.getValue()) {
                                            JSONObject jSONObject3 = new JSONObject();
                                            jSONObject3.put("version", bVar.version);
                                            if (!Util.isNullOrNil(bVar.EnT)) {
                                                o oVar = new o(bVar.EnT);
                                                if (oVar.exists() && oVar.isFile()) {
                                                    jSONObject3.put("md5", s.bhK(aa.z(oVar.mUri)));
                                                    jSONObject3.put("size", oVar.length());
                                                    eya eya = new g(oVar).JNe;
                                                    if (eya != null) {
                                                        jSONObject3.put("charset", eya.Nvi);
                                                        jSONObject3.put("desc", eya.Desc);
                                                        if (eya.Nvh != null) {
                                                            JSONArray jSONArray4 = new JSONArray();
                                                            Iterator<aod> it = eya.Nvh.iterator();
                                                            while (it.hasNext()) {
                                                                aod next = it.next();
                                                                JSONObject jSONObject4 = new JSONObject();
                                                                jSONObject4.put("rid", next.LzG);
                                                                jSONObject4.put("offset", next.LzH);
                                                                jSONObject4.put("size", next.oUq);
                                                                jSONObject4.put("mimeType", next.LzI);
                                                                jSONArray4.put(jSONObject4);
                                                            }
                                                            jSONObject3.put("resList", jSONArray4);
                                                        }
                                                    }
                                                }
                                            }
                                            List<String> list = bVar.JNz;
                                            if (!Util.isNullOrNil(list)) {
                                                JSONArray jSONArray5 = new JSONArray();
                                                for (String str : list) {
                                                    jSONArray5.put(str);
                                                }
                                                jSONObject3.put("preloadFiles", jSONArray5);
                                            }
                                            jSONArray3.put(jSONObject3);
                                        }
                                        jSONObject2.put("versionList", jSONArray3);
                                        jSONArray.put(jSONObject2);
                                    }
                                }
                                jSONObject.put("pkgList", jSONArray);
                                if (aVar != null) {
                                    aVar.aR(jSONObject);
                                }
                                AppMethodBeat.o(110709);
                            } catch (Exception e2) {
                                if (aVar != null) {
                                    aVar.aR(null);
                                }
                                AppMethodBeat.o(110709);
                            }
                        }
                    });
                }
                wepkgCrossProcessTask.bDK();
                AppMethodBeat.o(110710);
            }
        };
        wepkgCrossProcessTask.bDJ();
        AppBrandMainProcessService.a(wepkgCrossProcessTask);
        AppMethodBeat.o(110715);
    }

    /* access modifiers changed from: package-private */
    public static class b {
        String EnT;
        List<String> JNz;
        String version;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    private static void bcG(String str) {
        AppMethodBeat.i(110716);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(110716);
            return;
        }
        j.a(str, "", false, (a) new a() {
            /* class com.tencent.mm.plugin.wepkg.model.i.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.wepkg.model.a
            public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
            }
        });
        AppMethodBeat.o(110716);
    }

    private static void mu(final String str, String str2) {
        AppMethodBeat.i(110717);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(110717);
            return;
        }
        final AnonymousClass3 r0 = new a() {
            /* class com.tencent.mm.plugin.wepkg.model.i.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.wepkg.model.a
            public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
            }
        };
        j.a(str, str2, "", new a() {
            /* class com.tencent.mm.plugin.wepkg.model.i.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.wepkg.model.a
            public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                AppMethodBeat.i(110711);
                String str = str;
                a aVar = r0;
                WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                wepkgCrossProcessTask.EX = 3006;
                wepkgCrossProcessTask.JNh.hhD = str;
                wepkgCrossProcessTask.JNh.JNW = false;
                if (MMApplicationContext.isMMProcess()) {
                    d.cyh().postToWorker(new Runnable(wepkgCrossProcessTask, aVar) {
                        /* class com.tencent.mm.plugin.wepkg.model.j.AnonymousClass11 */
                        final /* synthetic */ a JNC;
                        final /* synthetic */ WepkgCrossProcessTask JNH;

                        {
                            this.JNH = r1;
                            this.JNC = r2;
                        }

                        public final void run() {
                            AppMethodBeat.i(110735);
                            this.JNH.bjj();
                            if (this.JNC != null) {
                                this.JNC.a(this.JNH);
                            }
                            AppMethodBeat.o(110735);
                        }
                    });
                    AppMethodBeat.o(110711);
                    return;
                }
                wepkgCrossProcessTask.lyv = new Runnable(aVar, wepkgCrossProcessTask) {
                    /* class com.tencent.mm.plugin.wepkg.model.j.AnonymousClass12 */
                    final /* synthetic */ a JNC;
                    final /* synthetic */ WepkgCrossProcessTask JNH;

                    {
                        this.JNC = r1;
                        this.JNH = r2;
                    }

                    public final void run() {
                        AppMethodBeat.i(110736);
                        if (this.JNC != null) {
                            this.JNC.a(this.JNH);
                        }
                        this.JNH.bDK();
                        AppMethodBeat.o(110736);
                    }
                };
                wepkgCrossProcessTask.bDJ();
                AppBrandMainProcessService.a(wepkgCrossProcessTask);
                AppMethodBeat.o(110711);
            }
        });
        AppMethodBeat.o(110717);
    }

    static /* synthetic */ boolean a(o oVar, Map map) {
        AppMethodBeat.i(177091);
        if (oVar == null || !oVar.isDirectory()) {
            AppMethodBeat.o(177091);
            return false;
        }
        o[] het = oVar.het();
        if (het == null || het.length == 0) {
            AppMethodBeat.o(177091);
            return false;
        }
        for (o oVar2 : het) {
            o[] het2 = oVar2.het();
            if (!(het2 == null || het2.length == 0)) {
                ArrayList arrayList = new ArrayList();
                for (o oVar3 : het2) {
                    b bVar = new b((byte) 0);
                    bVar.version = oVar3.getName();
                    String str = aa.z(oVar3.her()) + "/package";
                    if (s.YS(str)) {
                        bVar.EnT = str;
                    }
                    o oVar4 = new o(aa.z(oVar3.her()) + "/preload_files");
                    if (!oVar4.isDirectory()) {
                        arrayList.add(bVar);
                    } else {
                        o[] het3 = oVar4.het();
                        if (het3 == null || het3.length == 0) {
                            arrayList.add(bVar);
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            for (o oVar5 : het3) {
                                arrayList2.add(oVar5.getName());
                            }
                            bVar.JNz = arrayList2;
                            arrayList.add(bVar);
                        }
                    }
                }
                map.put(oVar2.getName(), arrayList);
            }
        }
        AppMethodBeat.o(177091);
        return true;
    }
}
