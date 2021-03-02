package com.tencent.mm.vfs;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.co;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.g;
import java.io.File;
import java.io.InputStream;
import java.security.Key;
import java.util.LinkedHashSet;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;

public final class y {
    private static volatile boolean FgY;
    private static volatile boolean ReA = false;
    private static volatile boolean ReB = false;
    private static volatile boolean ReC = false;
    private static volatile String ReD = "";
    private static String ReE = null;
    private static String ReF = null;
    private static String ReG = null;
    private static final o ReH = new o(o.X(MMApplicationContext.getContext().getCacheDir()), "temp");
    private static final o ReI;
    private static final a Rey = new a((byte) 0);
    private static boolean Rez = false;

    private y() {
    }

    static {
        o oVar = null;
        AppMethodBeat.i(176883);
        o X = o.X(MMApplicationContext.getContext().getExternalCacheDir());
        if (X != null) {
            oVar = new o(X, "temp");
        }
        ReI = oVar;
        AppMethodBeat.o(176883);
    }

    public static void at(String str, String str2, int i2) {
        AppMethodBeat.i(133511);
        if (!FgY) {
            AppMethodBeat.o(133511);
            return;
        }
        String bpe = bpe(str);
        String bpe2 = bpe(str2);
        String[] hq = hq(bpe2, i2);
        AbstractFileSystem a2 = a(bpe, hq, i2);
        a2.a(bpe, x.heu());
        StatisticsFileSystem statisticsFileSystem = new StatisticsFileSystem(a2);
        statisticsFileSystem.a(bpe, new d(hq[0], 1, i2, 0, 0));
        a(bpe, statisticsFileSystem, hq, i2);
        d.hp(bpe2, i2);
        AppMethodBeat.o(133511);
    }

    public static void a(String str, String str2, long j2, long j3, int i2) {
        AppMethodBeat.i(259574);
        if (!FgY) {
            AppMethodBeat.o(259574);
            return;
        }
        String bpe = bpe(str);
        String bpe2 = bpe(str2);
        String[] hq = hq(bpe2, i2);
        StatisticsFileSystem statisticsFileSystem = new StatisticsFileSystem(a(bpe, hq, i2));
        statisticsFileSystem.a(bpe, new d(hq[0], 4, i2, j2 / 2, j3));
        QuotaFileSystem quotaFileSystem = new QuotaFileSystem(statisticsFileSystem, j2 / 2, j2, j3);
        quotaFileSystem.a(bpe, x.heu());
        a(bpe, quotaFileSystem, hq, i2);
        d.hp(bpe2, i2);
        AppMethodBeat.o(259574);
    }

    public static void b(String str, String str2, long j2, int i2) {
        AppMethodBeat.i(197245);
        if (!FgY) {
            AppMethodBeat.o(197245);
            return;
        }
        String bpe = bpe(str);
        String bpe2 = bpe(str2);
        int i3 = i2 | 32;
        String[] hq = hq(bpe2, i3);
        StatisticsFileSystem statisticsFileSystem = new StatisticsFileSystem(a(bpe, hq, i3));
        statisticsFileSystem.a(bpe, new d(hq[0], 3, i3, 0, j2));
        ExpireFileSystem expireFileSystem = new ExpireFileSystem(statisticsFileSystem, j2);
        expireFileSystem.a(bpe, x.heu());
        a(bpe, expireFileSystem, hq, i3);
        d.hp(bpe2, i3);
        AppMethodBeat.o(197245);
    }

    public static void nA(String str, String str2) {
        boolean z = true;
        AppMethodBeat.i(197246);
        if (Util.getInt(d.cRY().b("clicfg_clean_expire_switch", "1", false, true), 1) <= 0) {
            z = false;
        }
        if (!z) {
            b(str, str2, 604800000, 19);
            AppMethodBeat.o(197246);
        } else if (!FgY) {
            AppMethodBeat.o(197246);
        } else {
            String bpe = bpe(str);
            String bpe2 = bpe(str2);
            String[] hq = hq(bpe2, 51);
            StatisticsFileSystem statisticsFileSystem = new StatisticsFileSystem(a(bpe, hq, 51));
            statisticsFileSystem.a(bpe, new d(hq[0], 3, 51, 0, 604800000));
            CleanExpireFileSystem cleanExpireFileSystem = new CleanExpireFileSystem(statisticsFileSystem);
            cleanExpireFileSystem.a(bpe, x.heu());
            a(bpe, cleanExpireFileSystem, hq, 51);
            d.hp(bpe2, 51);
            AppMethodBeat.o(197246);
        }
    }

    private static String[] hq(String str, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        String str2;
        boolean z4 = true;
        AppMethodBeat.i(133514);
        boolean z5 = (i2 & 4) == 0;
        if ((i2 & 32) == 0 || (i2 & 512) != 0) {
            z = false;
        } else {
            z = true;
        }
        if ((i2 & 1) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((i2 & 2) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((i2 & 256) == 0) {
            z4 = false;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z3) {
            str2 = z ? "${sdToCache}/" : "${sdTo}/MicroMsg/";
            if (z5) {
                str2 = str2 + "${accountSd}/";
            }
        } else {
            str2 = z ? "${dataCache}/" : "${data}/MicroMsg/";
            if (z5) {
                str2 = str2 + "${account}/";
            }
        }
        linkedHashSet.add(str2 + str);
        if (z2) {
            if (z5) {
                if (z || !z3) {
                    linkedHashSet.add("${extSDFrom}/MicroMsg/" + "${accountSalt}/" + str);
                    linkedHashSet.add("${extSDFrom}/MicroMsg/" + "${account}/" + str);
                }
                linkedHashSet.add("${sdFrom}/MicroMsg/" + "${accountSalt}/" + str);
                linkedHashSet.add("${sdFrom}/MicroMsg/" + "${account}/" + str);
            } else {
                linkedHashSet.add("${sdFrom}/MicroMsg/" + str);
                if (z || !z3) {
                    linkedHashSet.add("${extSDFrom}/MicroMsg/" + str);
                }
            }
        } else if (!z4) {
            String str3 = "${data}/MicroMsg/";
            if (z5) {
                str3 = str3 + "${account}/";
            }
            linkedHashSet.add(str3 + str);
        } else if (z5) {
            linkedHashSet.add("${sdFrom}/MicroMsg/" + "${accountSalt}/" + str);
            linkedHashSet.add("${sdFrom}/MicroMsg/" + "${account}/" + str);
            linkedHashSet.add("${sdTo}/MicroMsg/${accountSalt}/".concat(String.valueOf(str)));
            linkedHashSet.add("${sdTo}/MicroMsg/${account}/".concat(String.valueOf(str)));
        } else {
            linkedHashSet.add("${sdFrom}/MicroMsg/" + str);
            linkedHashSet.add("${sdTo}/MicroMsg/".concat(String.valueOf(str)));
        }
        String[] strArr = (String[]) linkedHashSet.toArray(new String[0]);
        AppMethodBeat.o(133514);
        return strArr;
    }

    private static AbstractFileSystem au(String str, String str2, int i2) {
        AppMethodBeat.i(197247);
        NativeFileSystem nativeFileSystem = new NativeFileSystem(str2);
        if ((i2 & 8) == 0) {
            AppMethodBeat.o(197247);
            return nativeFileSystem;
        }
        RC4EncryptedFileSystem rC4EncryptedFileSystem = new RC4EncryptedFileSystem(nativeFileSystem, str);
        AppMethodBeat.o(197247);
        return rC4EncryptedFileSystem;
    }

    private static AbstractFileSystem a(String str, String[] strArr, int i2) {
        AppMethodBeat.i(197248);
        if (strArr.length == 1 || (i2 & 64) != 0) {
            AbstractFileSystem au = au(str, strArr[0], i2);
            AppMethodBeat.o(197248);
            return au;
        }
        FileSystem[] fileSystemArr = new FileSystem[(strArr.length - 1)];
        for (int i3 = 1; i3 < strArr.length; i3++) {
            fileSystemArr[i3 - 1] = au(str, strArr[i3], i2);
        }
        boolean z = (i2 & 128) == 0;
        boolean z2 = (i2 & 1024) != 0;
        MigrationFileSystem migrationFileSystem = new MigrationFileSystem(z ? "${sdFrom}" : null, z ? "${sdFrom}" : null, z2 ? "${sdFrom}" : null, au(str, strArr[0], i2), fileSystemArr);
        AppMethodBeat.o(197248);
        return migrationFileSystem;
    }

    private static void a(String str, FileSystem fileSystem, String[] strArr, int i2) {
        FileSystem maintenanceGroup;
        AppMethodBeat.i(197249);
        g.a a2 = g.hYQ().hYS().a(str, fileSystem);
        for (String str2 : strArr) {
            a2.ns(str2, str);
        }
        if ((i2 & 64) != 0 && strArr.length > 1) {
            if (strArr.length == 2) {
                maintenanceGroup = new DeleteAllFileSystem(new NativeFileSystem(strArr[1]));
            } else {
                FileSystem[] fileSystemArr = new FileSystem[(strArr.length - 1)];
                for (int i3 = 0; i3 < fileSystemArr.length; i3++) {
                    fileSystemArr[i3] = new DeleteAllFileSystem(new NativeFileSystem(strArr[i3 + 1]));
                }
                maintenanceGroup = new MaintenanceGroup(fileSystemArr);
            }
            a2.b("@DeleteAll-".concat(String.valueOf(str)), maintenanceGroup);
        }
        a2.commit();
        AppMethodBeat.o(197249);
    }

    private static String bpe(String str) {
        AppMethodBeat.i(133518);
        if (str.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            str = str.substring(1);
        }
        if (str.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            str = str.substring(0, str.length() - 1);
        }
        AppMethodBeat.o(133518);
        return str;
    }

    static class a implements g.b {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.vfs.g.b
        public final Key Z(String str, Map<String, String> map) {
            String pVar;
            AppMethodBeat.i(176878);
            if (map.get("account") == null) {
                AppMethodBeat.o(176878);
                return null;
            }
            Log.i("VFS.Debug", "KeyGen.generate: ".concat(String.valueOf(str)));
            if (MMApplicationContext.isMainProcess()) {
                com.tencent.mm.kernel.g.aAf();
                pVar = com.tencent.mm.kernel.a.ayV();
            } else {
                pVar = new p(com.tencent.mm.kernel.a.azs()).toString();
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(com.tencent.mm.b.g.Q((pVar + str).getBytes()), "RC4");
            AppMethodBeat.o(176878);
            return secretKeySpec;
        }
    }

    public static synchronized void f(com.tencent.mm.kernel.b.g gVar) {
        boolean z = true;
        synchronized (y.class) {
            AppMethodBeat.i(176882);
            boolean aBb = gVar.aBb();
            FgY = aBb;
            g.setContext(gVar.ca);
            if (aBb) {
                z = false;
            }
            g.FL(z);
            g.a(Rey);
            g.hYQ();
            try {
                ExtStorageMigrateMonitor.gwK().i("VFS.VFSStrategy", "Early init, isMainProcess: " + aBb + ", VFSSwitch.isAsyncMigrationOpen():true, asyncMigrationDynCfgOpen:true, syncMigrationDynCfgOpen:true, isNewInstalled:" + z.heY(), new Object[0]);
            } catch (Throwable th) {
                ExtStorageMigrateMonitor.gwK().printErrStackTrace("VFS.VFSStrategy", th, "Rarely exception.", new Object[0]);
            }
            ExtStorageMigrateMonitor.gwK().i("VFS.VFSStrategy", "[+] updateSdCardPathOnDemand, isPathRemapOpened, NEW_SDCARD_ROOT: %s", b.aKF());
            b.aLI();
            b.A(b.aKF(), true);
            AppMethodBeat.o(176882);
        }
    }

    public static synchronized void g(com.tencent.mm.kernel.b.g gVar) {
        boolean z = true;
        synchronized (y.class) {
            AppMethodBeat.i(133519);
            boolean aBb = gVar.aBb();
            FgY = aBb;
            Rez = true;
            if (aBb) {
                z = false;
            }
            g.FL(z);
            g.a(Rey);
            if (aBb) {
                ExpireFileSystem expireFileSystem = new ExpireFileSystem(new NativeFileSystem("${dataCache}/temp"), 259200000);
                ExpireFileSystem expireFileSystem2 = new ExpireFileSystem(new NativeFileSystem("${extCache}/temp"), 259200000);
                g hYQ = g.hYQ();
                hYQ.Vmw = false;
                g.a hYS = hYQ.hYS();
                hYS.Rcf.clear();
                hYS.Rch.clear();
                hYS.Rci.clear();
                hYS.Rcj = null;
                hYS.Rck = true;
                g.a ns = hYS.a("assets", AssetsSchemeResolver.hdP()).a("content", ContentsSchemeResolver.hdT()).a("data-root", new NativeFileSystem("${data}")).a("storage-root", new NativeFileSystem("${storage}")).a("temp", expireFileSystem).a("extTemp", expireFileSystem2).ns("${data}", "data-root").ns("${storage}", "storage-root").ns("${dataCache}/temp", "temp").ns("${extCache}/temp", "extTemp");
                d(ns);
                a(ns, e.apn(), true).Dx(false);
            }
            MMBitmapFactory.setStreamProvider(new MMBitmapFactory.b() {
                /* class com.tencent.mm.vfs.y.AnonymousClass1 */

                @Override // com.tencent.mm.graphics.MMBitmapFactory.b
                public final InputStream getStreamFromPath(String str) {
                    AppMethodBeat.i(176875);
                    InputStream openRead = s.openRead(str);
                    AppMethodBeat.o(176875);
                    return openRead;
                }
            });
            AppMethodBeat.o(133519);
        }
    }

    private static void Dy(boolean z) {
        l lVar;
        AppMethodBeat.i(197250);
        Log.i("VFS.VFSStrategy", "Broadcasting enabled.");
        g hYQ = g.hYQ();
        g.a hYS = hYQ.hYS();
        d.b(hYS);
        d.c(hYS);
        b.a(hYS);
        hYS.commit();
        d.init();
        hYQ.Vmw = true;
        synchronized (hYQ.mLock) {
            try {
                lVar = hYQ.Vmk;
            } finally {
                AppMethodBeat.o(197250);
            }
        }
        hYQ.a(lVar);
        if (z) {
            h hVar = h.Rco;
            g.d dVar = hYQ.Vmv;
            hYQ.Vmv = hVar;
            hYQ.aQ(420000, Util.MILLSECONDS_OF_DAY);
        }
    }

    public static void heW() {
        boolean z = false;
        AppMethodBeat.i(133520);
        Log.i("VFS.VFSStrategy", "Configuration done.");
        ReB = true;
        synchronized (y.class) {
            try {
                if (FgY && ReA) {
                    if (!ReC) {
                        z = true;
                    }
                    if (z) {
                        ReC = true;
                    }
                }
            } finally {
                AppMethodBeat.o(133520);
            }
        }
        if (z) {
            Dy(e.apn());
        }
    }

    public static synchronized void Dz(boolean z) {
        boolean z2 = false;
        synchronized (y.class) {
            AppMethodBeat.i(133521);
            Log.i("VFS.VFSStrategy", "Account ready.");
            ReA = true;
            synchronized (y.class) {
                try {
                    if (FgY && ReB) {
                        if (!ReC) {
                            z2 = true;
                        }
                        if (z2) {
                            ReC = true;
                        }
                    }
                } finally {
                    AppMethodBeat.o(133521);
                }
            }
        }
        if (z2) {
            Dy(z);
        }
    }

    public static void apG(final int i2) {
        AppMethodBeat.i(133522);
        EventCenter.instance.add(new IListener<co>() {
            /* class com.tencent.mm.vfs.y.AnonymousClass2 */

            {
                AppMethodBeat.i(176876);
                this.__eventId = co.class.getName().hashCode();
                AppMethodBeat.o(176876);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(co coVar) {
                AppMethodBeat.i(176877);
                if (!y.FgY) {
                    AppMethodBeat.o(176877);
                } else {
                    com.tencent.mm.plugin.report.e.INSTANCE.b(1146, i2, 0, 1, true);
                    AppMethodBeat.o(176877);
                }
                return false;
            }
        });
        AppMethodBeat.o(133522);
    }

    public static g.a a(g.a aVar, boolean z, boolean z2) {
        String parent;
        String path;
        AppMethodBeat.i(133523);
        Context context = MMApplicationContext.getContext();
        Log.i("VFS.VFSStrategy", "Update SDCard status: isSDCardAvailAndSysPathOk = ".concat(String.valueOf(z)));
        if (z) {
            String str = b.aKE() + "/tencent";
            String aKF = b.aKF();
            File externalCacheDir = context.getExternalCacheDir();
            if (!z2) {
                Log.w("VFS.VFSStrategy", "do not use external private storage.");
                externalCacheDir = null;
            }
            g.a nt = aVar.nt("sdFrom", str);
            if (externalCacheDir == null) {
                parent = str;
            } else {
                parent = externalCacheDir.getParent();
            }
            g.a nt2 = nt.nt("sdTo", parent);
            if (externalCacheDir == null) {
                path = str + "/MicroMsg";
            } else {
                path = externalCacheDir.getPath();
            }
            g.a nt3 = nt2.nt("sdToCache", path).nt("extSDFrom", aKF);
            AppMethodBeat.o(133523);
            return nt3;
        }
        File cacheDir = context.getCacheDir();
        g.a nt4 = aVar.boQ("sdFrom").boQ("extSDFrom").nt("sdTo", cacheDir.getParent()).nt("sdToCache", cacheDir.getPath());
        AppMethodBeat.o(133523);
        return nt4;
    }

    public static g.a a(g.a aVar, String str, boolean z) {
        MigrationFileSystem migrationFileSystem;
        AppMethodBeat.i(133524);
        Log.i("VFS.VFSStrategy", "Update account migration: sysPath = " + str + ", useSaltPath = " + z);
        String str2 = ReD;
        if (z) {
            if (b.aKD().equals(b.aKE())) {
                migrationFileSystem = new MigrationFileSystem("${sdFrom}", "${sdFrom}", new NativeFileSystem(str + "${accountSalt}"), new NativeFileSystem(str + "${account}"));
            } else {
                migrationFileSystem = new MigrationFileSystem("${sdFrom}", "${sdFrom}", new NativeFileSystem(str + "${accountSalt}"), new NativeFileSystem(str + "${account}"), new NativeFileSystem(b.aKI() + "${accountSalt}"), new NativeFileSystem(b.aKI() + "${account}"));
            }
            ReD = str;
            g.a ns = aVar.a("accPathMigration", migrationFileSystem).boP(str2 + "${accountSalt}").boP(str2 + "${account}").ns(str + "${accountSalt}", "accPathMigration").ns(str + "${account}", "accPathMigration");
            AppMethodBeat.o(133524);
            return ns;
        }
        ReD = "";
        g.a boP = aVar.boO("accPathMigration").boP(str2 + "${accountSalt}").boP(str2 + "${account}");
        AppMethodBeat.o(133524);
        return boP;
    }

    private static synchronized g.a d(g.a aVar) {
        synchronized (y.class) {
            AppMethodBeat.i(185096);
            if (ReE != null) {
                aVar.boO("camera-path-remapfs");
                aVar.boP(ReE);
            }
            if (!(ReF == null && ReG == null)) {
                aVar.boO("sdcard-path-remapfs");
                if (ReF != null) {
                    aVar.boP(ReF);
                }
                if (ReG != null) {
                    aVar.boP(ReG);
                }
            }
            String aKU = b.aKU();
            String str = b.aKF() + "/MicroMsg/";
            String aKI = b.aKI();
            ExtStorageMigrateMonitor.gwK().i("VFS.VFSStrategy", "[+] updateMigratePathRemappings, lastMountNewCameraPath: %s, lastMountNewSDCardPath: %s, lastMountOldSDCardPath: %s, newCameraPath: %s, newSDCardPath: %s, oldSDCardPath: %s", ReE, ReF, ReG, aKU, str, aKI);
            if (b.aKU().equals(b.aKT())) {
                ExtStorageMigrateMonitor.gwK().e("VFS.VFSStrategy", "[-] Fail to get new camera path, and we use old camera path for fallback.", new Object[0]);
                if (MMApplicationContext.isMainProcess()) {
                    ExtStorageMigrateMonitor.ME(142);
                }
            }
            ReE = aKU;
            ReF = str;
            ReG = aKI;
            aVar.a("sdcard-path-remapfs", new MigrationFileSystem(false, false, (FileSystem) new NativeFileSystem(str), new NativeFileSystem(aKI))).a("camera-path-remapfs", new MigrationFileSystem(false, false, (FileSystem) new NativeFileSystem(aKU), new NativeFileSystem(aKI + "WeChat/"), new NativeFileSystem(aKI + "WeiXin/"))).ns(str, "sdcard-path-remapfs").ns(aKU, "camera-path-remapfs").ns(aKI, "sdcard-path-remapfs").ns(aKI + "WeChat/", "camera-path-remapfs").ns(aKI + "WeiXin/", "camera-path-remapfs");
            AppMethodBeat.o(185096);
        }
        return aVar;
    }

    public static void heX() {
        AppMethodBeat.i(185097);
        ExtStorageMigrateMonitor.gwK().i("VFS.VFSStrategy", "[+] updateSdCardPathOnDemand called.", new Object[0]);
        ExtStorageMigrateMonitor.gwK().i("VFS.VFSStrategy", "[+] updateSdCardPathOnDemand, isPathRemapOpened, NEW_SDCARD_ROOT: %s", b.aKF());
        b.aLI();
        b.A(b.aKF(), true);
        if (MMApplicationContext.isMainProcess()) {
            d(g.hYQ().hYS()).commit();
        }
        AppMethodBeat.o(185097);
    }
}
