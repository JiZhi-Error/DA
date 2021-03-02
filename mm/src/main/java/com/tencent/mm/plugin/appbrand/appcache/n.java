package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import android.os.Build;
import android.os.StatFs;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.lr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.predownload.export.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.launching.m;
import com.tencent.mm.plugin.appbrand.page.bj;
import com.tencent.mm.plugin.appbrand.ui.c.a.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import org.xwalk.core.BuildConfig;

public interface n extends Runnable {

    public static class c {
        private static final d kKC = new d();

        static {
            AppMethodBeat.i(44244);
            AppMethodBeat.o(44244);
        }

        public static n bvr() {
            AppMethodBeat.i(44242);
            d dVar = kKC;
            AppMethodBeat.o(44242);
            return dVar;
        }

        public static void interrupt() {
            AppMethodBeat.i(44243);
            d dVar = kKC;
            try {
                h.INSTANCE.dN(1007, 2);
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.AppBrand.PkgCleanupNewLogic", th, "cleanup interrupted report", new Object[0]);
            }
            dVar.kKD.set(true);
            AppMethodBeat.o(44243);
        }
    }

    public static class b {
        public static long bvq() {
            AppMethodBeat.i(44241);
            long q = com.tencent.mm.plugin.appbrand.appstorage.n.q(new o(az.bwm()));
            AppMethodBeat.o(44241);
            return q;
        }
    }

    public static class e {
        public static int bvx() {
            AppMethodBeat.i(44255);
            HashSet hashSet = new HashSet();
            Cursor rawQuery = com.tencent.mm.plugin.appbrand.app.n.buy().rawQuery("select distinct appId from AppBrandWxaPkgManifestRecord where  ( appId not like '%%$%%' or appId like " + String.format(Locale.US, "'%%$%s'", ModulePkgInfo.MAIN_MODULE_NAME) + " )  and  ( pkgPath is not null  and pkgPath != ''  ) ", null, 2);
            if (rawQuery != null && !rawQuery.isClosed()) {
                if (rawQuery.moveToFirst()) {
                    do {
                        String string = rawQuery.getString(0);
                        int indexOf = string.indexOf(36);
                        if (indexOf > 0) {
                            string = string.substring(0, indexOf);
                        }
                        hashSet.add(string);
                    } while (rawQuery.moveToNext());
                }
                rawQuery.close();
            }
            Cursor rawQuery2 = com.tencent.mm.plugin.appbrand.app.n.buy().rawQuery("select distinct appId from PredownloadEncryptPkgInfo where pkgPath is not null  and pkgPath != '' ", null, 2);
            if (rawQuery2 != null && !rawQuery2.isClosed()) {
                if (rawQuery2.moveToFirst()) {
                    hashSet.add(rawQuery2.getString(0));
                }
                do {
                } while (rawQuery2.moveToNext());
                rawQuery2.close();
            }
            int size = hashSet.size();
            AppMethodBeat.o(44255);
            return size;
        }
    }

    public static class a {
        static void US(String str) {
            AppMethodBeat.i(44240);
            s.deleteFile(str);
            try {
                Runtime.getRuntime().exec("rm -r " + str + "_xdir");
                AppMethodBeat.o(44240);
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrand.PkgCleanupLogic.CleanupUtil", "rm -r %s, e = %s", str + "_xdir", e2);
                AppMethodBeat.o(44240);
            }
        }
    }

    public static class d implements n {
        final AtomicBoolean kKD = new AtomicBoolean();

        public d() {
            AppMethodBeat.i(44248);
            AppMethodBeat.o(44248);
        }

        private void bvs() {
            AppMethodBeat.i(44249);
            if (this.kKD.get()) {
                InterruptedException interruptedException = new InterruptedException();
                AppMethodBeat.o(44249);
                throw interruptedException;
            }
            AppMethodBeat.o(44249);
        }

        public final void run() {
            ArrayList<bd> arrayList;
            AppMethodBeat.i(44250);
            if (com.tencent.mm.plugin.appbrand.app.n.buL() == null) {
                Log.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "run() entered but storage not ready");
                AppMethodBeat.o(44250);
                return;
            }
            this.kKD.set(false);
            try {
                h.INSTANCE.dN(1007, 1);
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.AppBrand.PkgCleanupNewLogic", th, "cleanup start report", new Object[0]);
            }
            long currentTicks = Util.currentTicks();
            try {
                bh buL = com.tencent.mm.plugin.appbrand.app.n.buL();
                StringBuilder sb = new StringBuilder("debugType");
                sb.append(" in (");
                for (int i2 : j.kKv) {
                    sb.append(i2).append(',');
                }
                sb.append(-1).append(')');
                Cursor query = buL.kNJ.query("AppBrandWxaPkgManifestRecord", null, sb.toString(), null, null, null, null, 2);
                if (query == null) {
                    arrayList = null;
                } else if (!query.moveToFirst()) {
                    query.close();
                    arrayList = null;
                } else {
                    arrayList = new ArrayList();
                    do {
                        bd bdVar = new bd();
                        bdVar.convertFrom(query);
                        arrayList.add(bdVar);
                    } while (query.moveToNext());
                    query.close();
                }
                if (!Util.isNullOrNil(arrayList)) {
                    bvs();
                    long nowSecond = Util.nowSecond();
                    for (bd bdVar2 : arrayList) {
                        if (com.tencent.mm.plugin.appbrand.task.h.bWb().afi(bdVar2.field_appId)) {
                            Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug appID(%s) is running, skip", bdVar2.field_appId);
                        } else {
                            bvs();
                            if (bdVar2.field_endTime <= 0 || bdVar2.field_endTime > nowSecond) {
                                if (bdVar2.field_debugType == 999) {
                                    Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug, debug library not exceed time range[%d %d]", Long.valueOf(bdVar2.field_startTime), Long.valueOf(bdVar2.field_endTime));
                                }
                            } else if (bdVar2.field_debugType == 999) {
                                a.US(bdVar2.field_pkgPath);
                                com.tencent.mm.plugin.appbrand.app.n.buL().a(bdVar2);
                                Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processDebug, (%s, %d) exceed time range[%d, %d]", bdVar2.field_appId, Integer.valueOf(bdVar2.field_debugType), Long.valueOf(bdVar2.field_startTime), Long.valueOf(bdVar2.field_endTime));
                            }
                        }
                    }
                }
                bvt();
                bvu();
                bvv();
                bvw();
                bvs();
                StatFs statFs = new StatFs(az.bwm());
                long blockCountLong = Build.VERSION.SDK_INT >= 18 ? statFs.getBlockCountLong() : (long) statFs.getBlockCount();
                long bvq = b.bvq();
                double blockSizeLong = ((double) (bvq / (Build.VERSION.SDK_INT >= 18 ? statFs.getBlockSizeLong() : (long) statFs.getBlockSize()))) / ((double) blockCountLong);
                double d2 = (double) (((float) AppBrandGlobalSystemConfig.bzP().ldk.ldE) / 100.0f);
                boolean z = blockSizeLong > d2 && bvq > AppBrandGlobalSystemConfig.bzP().ldk.ldD * 1048576;
                Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, usedPercent(%f), maxPercent(%f), usedBytes(%d), maxMB(%d), shouldCleanup=%B", Double.valueOf(blockSizeLong), Double.valueOf(d2), Long.valueOf(bvq), Long.valueOf(AppBrandGlobalSystemConfig.bzP().ldk.ldD), Boolean.valueOf(z));
                if (z) {
                    Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, cleanup by conditions usedPercent(%f) > maxPercent(%f)", Double.valueOf(blockSizeLong), Double.valueOf(d2));
                    long blockSizeLong2 = (long) (((double) (Build.VERSION.SDK_INT >= 18 ? statFs.getBlockSizeLong() : (long) statFs.getBlockSize())) * ((double) blockCountLong) * (blockSizeLong - d2));
                    if (blockSizeLong2 < 0) {
                        Log.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "processByFilesystemUsage, calculated bytesToTrim is minus");
                    } else {
                        bvs();
                        ac.a(blockSizeLong2, new ac.a() {
                            /* class com.tencent.mm.plugin.appbrand.appcache.n.d.AnonymousClass3 */

                            @Override // com.tencent.mm.plugin.appbrand.appcache.ac.a
                            public final boolean bqX() {
                                AppMethodBeat.i(44247);
                                boolean z = d.this.kKD.get();
                                AppMethodBeat.o(44247);
                                return z;
                            }
                        });
                        if (v.bvG()) {
                            ak.a(blockSizeLong2 / 5, new ak.a() {
                                /* class com.tencent.mm.plugin.appbrand.appcache.n.d.AnonymousClass4 */

                                @Override // com.tencent.mm.plugin.appbrand.appcache.ak.a
                                public final boolean bqX() {
                                    AppMethodBeat.i(258037);
                                    boolean z = d.this.kKD.get();
                                    AppMethodBeat.o(258037);
                                    return z;
                                }
                            });
                        }
                    }
                }
                Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "run() cost %dms", Long.valueOf(Util.currentTicks() - currentTicks));
                AppMethodBeat.o(44250);
            } catch (InterruptedException e2) {
                Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "interrupted %s", android.util.Log.getStackTraceString(e2));
                Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "run() cost %dms", Long.valueOf(Util.currentTicks() - currentTicks));
                AppMethodBeat.o(44250);
            } catch (Throwable th2) {
                Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "run() cost %dms", Long.valueOf(Util.currentTicks() - currentTicks));
                AppMethodBeat.o(44250);
                throw th2;
            }
        }

        private void bvt() {
            int i2;
            AppMethodBeat.i(226351);
            bvs();
            r.a buy = com.tencent.mm.plugin.appbrand.app.n.buy();
            int[] bVY = com.tencent.mm.plugin.appbrand.task.h.bWb().bVY();
            int i3 = Integer.MAX_VALUE;
            for (int i4 : bVY) {
                if (i4 > 0) {
                    i3 = Math.min(i3, i4);
                }
            }
            if (Integer.MAX_VALUE == i3) {
                WxaPkgWrappingInfo bS = m.bS("@LibraryAppId", 0);
                i2 = bS == null ? 0 : bS.pkgVersion;
            } else {
                i2 = i3;
            }
            if (i2 > 0) {
                Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, library.minValidVersion = %d", Integer.valueOf(i2));
                int max = i2 - Math.max(0, ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_comm_lib_version_keep_count, 3) - 1);
                Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, delete libraries record < %d", Integer.valueOf(max));
                int[] Vt = com.tencent.mm.plugin.appbrand.app.n.buL().Vt("@LibraryAppId");
                com.tencent.mm.plugin.appbrand.app.n.buL().E("@LibraryAppId", 0, max);
                if (Vt != null && Vt.length > 0) {
                    for (int i5 : Vt) {
                        if (i5 < max) {
                            s.dy(bj.yR(i5), true);
                        }
                    }
                }
            }
            Cursor rawQuery = buy.rawQuery("select distinct appId from AppBrandWxaPkgManifestRecord where debugType=? and appId!=? and appId not like '%%$%%'", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, "@LibraryAppId"});
            if (rawQuery == null || rawQuery.isClosed()) {
                AppMethodBeat.o(226351);
                return;
            }
            LinkedList<String> linkedList = new LinkedList();
            if (rawQuery.moveToFirst()) {
                do {
                    String string = rawQuery.getString(0);
                    if (com.tencent.mm.plugin.appbrand.task.h.bWb().afi(string)) {
                        Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease appID(%s) is running, skip", string);
                    } else {
                        linkedList.add(string);
                    }
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            LinkedList linkedList2 = new LinkedList();
            bvs();
            AnonymousClass1 r4 = new HashMap<String, c.b>() {
                /* class com.tencent.mm.plugin.appbrand.appcache.n.d.AnonymousClass1 */

                {
                    AppMethodBeat.i(258035);
                    for (c.b bVar : com.tencent.mm.plugin.appbrand.appcache.predownload.export.c.bwU().bxg()) {
                        if (bVar != null) {
                            put(bVar.appId, bVar);
                        }
                    }
                    AppMethodBeat.o(258035);
                }
            };
            for (String str : linkedList) {
                WxaAttributes e2 = com.tencent.mm.plugin.appbrand.app.n.buC().e(str, "versionInfo");
                if (e2 == null || Util.isNullOrNil(e2.field_versionInfo)) {
                    linkedList2.add(str);
                } else {
                    bvs();
                    if (r4.containsKey(str)) {
                        c.b bVar = (c.b) r4.get(str);
                        if (bVar == null) {
                            Log.e("MicroMsg.AppBrand.PkgCleanupNewLogic", "processReleaseContact, pkg is null!");
                        } else {
                            Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processReleaseContact, for export occupied, delete record(%s) < %d, deleting pkgCount: %d, moduleCount: %d", bVar.appId, Integer.valueOf(bVar.version), Integer.valueOf(com.tencent.mm.plugin.appbrand.app.n.buL().E(bVar.appId, bVar.iOo, bVar.version)), Integer.valueOf(com.tencent.mm.plugin.appbrand.app.n.buL().F(bVar.appId, bVar.iOo, bVar.version)));
                        }
                    } else {
                        int i6 = e2.bAp() == null ? 0 : e2.bAp().appVersion;
                        if (i6 > 0) {
                            int[] Vs = com.tencent.mm.plugin.appbrand.app.n.buL().Vs(str);
                            int E = com.tencent.mm.plugin.appbrand.app.n.buL().E(str, 0, i6);
                            if (E > 0) {
                                Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processRelease, delete record(%s) < %d, count(%d)", str, Integer.valueOf(i6), Integer.valueOf(E));
                                lr lrVar = new lr();
                                lrVar.eZr = 2;
                                lr yZ = lrVar.yZ(str);
                                yZ.eZs = 0;
                                yZ.eZt = (long) E;
                                yZ.eZp = 1;
                                yZ.bfK();
                                if (Vs != null && Vs.length > 0) {
                                    for (int i7 : Vs) {
                                        if (i7 < i6) {
                                            s.dy(bj.cc(str, i7), true);
                                        }
                                    }
                                }
                            }
                            com.tencent.mm.plugin.appbrand.app.n.buL().F(str, 0, i6);
                            ((com.tencent.mm.plugin.appbrand.ui.c.a.b) com.tencent.mm.plugin.appbrand.app.n.W(com.tencent.mm.plugin.appbrand.ui.c.a.b.class)).a(str, 0, new b.AbstractC0806b.c(i6));
                        }
                    }
                }
            }
            bd(linkedList2);
            AppMethodBeat.o(226351);
        }

        private static void bd(List<String> list) {
            AppMethodBeat.i(44251);
            if (Util.isNullOrNil(list)) {
                AppMethodBeat.o(44251);
                return;
            }
            HashSet hashSet = new HashSet(list);
            List<c.b> bxg = com.tencent.mm.plugin.appbrand.appcache.predownload.export.c.bwU().bxg();
            if (!bxg.isEmpty()) {
                for (c.b bVar : bxg) {
                    hashSet.remove(bVar.appId);
                    Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processReleaseContact, for export occupied, delete record(%s) < %d, deleting pkgCount: %d, moduleCount: %d", bVar.appId, Integer.valueOf(bVar.version), Integer.valueOf(com.tencent.mm.plugin.appbrand.app.n.buL().E(bVar.appId, bVar.iOo, bVar.version)), Integer.valueOf(com.tencent.mm.plugin.appbrand.app.n.buL().F(bVar.appId, bVar.iOo, bVar.version)));
                }
            }
            long nowSecond = Util.nowSecond() - AppBrandGlobalSystemConfig.bzP().ldk.ldC;
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (Util.isNullOrNil(str) || !str.endsWith(ModulePkgInfo.PLUGIN_CODE)) {
                    WxaPkgWrappingInfo bS = m.bS(str, 0);
                    if (bS == null) {
                        if (m.bS(str + '$' + ModulePkgInfo.MAIN_MODULE_NAME, 0) == null) {
                        }
                    } else if (TimeUnit.MILLISECONDS.toSeconds(new o(bS.pkgPath).lastModified()) < nowSecond) {
                        Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processReleaseWithoutContact, delete record(%s) < %d", str, Integer.valueOf(bS.pkgVersion));
                        com.tencent.mm.plugin.appbrand.app.n.buL().E(str, 0, bS.pkgVersion);
                        com.tencent.mm.plugin.appbrand.app.n.buL().F(str, 0, bS.pkgVersion);
                        ((com.tencent.mm.plugin.appbrand.ui.c.a.b) com.tencent.mm.plugin.appbrand.app.n.W(com.tencent.mm.plugin.appbrand.ui.c.a.b.class)).a(str, 0, new b.AbstractC0806b.c(bS.pkgVersion));
                    }
                }
            }
            AppMethodBeat.o(44251);
        }

        private void bvu() {
            AppMethodBeat.i(44252);
            bvs();
            long nowSecond = Util.nowSecond() - AppBrandGlobalSystemConfig.bzP().ldk.ldC;
            Cursor all = ((an) com.tencent.mm.plugin.appbrand.app.n.W(an.class)).getAll();
            if (all == null || all.isClosed()) {
                AppMethodBeat.o(44252);
                return;
            }
            LinkedList<am> linkedList = new LinkedList();
            if (all.moveToFirst()) {
                do {
                    am amVar = new am();
                    amVar.convertFrom(all);
                    linkedList.add(amVar);
                } while (all.moveToNext());
            }
            all.close();
            bvs();
            for (am amVar2 : linkedList) {
                if (s.YS(amVar2.field_pkgPath)) {
                    bvs();
                    if (TimeUnit.MILLISECONDS.toSeconds(new o(amVar2.field_pkgPath).lastModified()) < nowSecond) {
                        Log.i("MicroMsg.AppBrand.PkgCleanupNewLogic", "processEncrypted, delete record(%s %d %d)", amVar2.field_appId, Integer.valueOf(amVar2.field_type), Integer.valueOf(amVar2.field_version));
                        ((an) com.tencent.mm.plugin.appbrand.app.n.W(an.class)).delete(amVar2, new String[0]);
                        s.dy(amVar2.field_pkgPath, true);
                    }
                }
            }
            AppMethodBeat.o(44252);
        }

        private void bvv() {
            boolean moveToFirst;
            AppMethodBeat.i(44253);
            o oVar = new o(az.bwm());
            if (!oVar.exists() || !oVar.isDirectory()) {
                AppMethodBeat.o(44253);
                return;
            }
            o[] a2 = oVar.a(new q() {
                /* class com.tencent.mm.plugin.appbrand.appcache.n.d.AnonymousClass2 */

                @Override // com.tencent.mm.vfs.q
                public final boolean accept(o oVar) {
                    AppMethodBeat.i(258036);
                    boolean isFile = oVar.isFile();
                    AppMethodBeat.o(258036);
                    return isFile;
                }
            });
            for (o oVar2 : a2) {
                Cursor query = com.tencent.mm.plugin.appbrand.app.n.buL().kNJ.query("AppBrandWxaPkgManifestRecord", new String[]{"appId"}, String.format("%s=?", "pkgPath"), new String[]{aa.z(oVar2.her())}, null, null, null, 2);
                if (query == null) {
                    moveToFirst = false;
                } else {
                    moveToFirst = query.moveToFirst();
                    query.close();
                }
                if (!moveToFirst) {
                    a.US(aa.z(oVar2.her()));
                }
            }
            AppMethodBeat.o(44253);
        }

        private static void bvw() {
            String str;
            String substring;
            AppMethodBeat.i(44254);
            bj.a aVar = bj.ntu;
            o oVar = new o(bj.a.Mo());
            if (!oVar.exists() || !oVar.isDirectory()) {
                oVar.delete();
                AppMethodBeat.o(44254);
                return;
            }
            HashMap hashMap = new HashMap();
            o[] het = oVar.het();
            for (o oVar2 : het) {
                String[] split = oVar2.getName().split(Pattern.quote("-"));
                if (split == null || split.length < 2) {
                    s.deleteFile(aa.z(oVar2.her()));
                    s.dy(aa.z(oVar2.her()), true);
                } else {
                    String str2 = split[0];
                    if (BuildConfig.INSTALL_TYPE.equals(str2)) {
                        str = "@LibraryAppId";
                    } else {
                        str = str2;
                    }
                    String str3 = split[1];
                    if (str3 == null) {
                        substring = null;
                    } else if (1 > str3.length()) {
                        substring = "";
                    } else {
                        substring = str3.substring(1);
                    }
                    int i2 = Util.getInt(substring, 0);
                    int[] iArr = (int[]) hashMap.get(str);
                    if (iArr == null) {
                        iArr = com.tencent.mm.plugin.appbrand.app.n.buL().Vs(str);
                        hashMap.put(str, iArr);
                    }
                    if (!org.apache.commons.b.a.contains(iArr, i2)) {
                        s.deleteFile(aa.z(oVar2.her()));
                        s.dy(aa.z(oVar2.her()), true);
                    }
                }
            }
            AppMethodBeat.o(44254);
        }
    }
}
