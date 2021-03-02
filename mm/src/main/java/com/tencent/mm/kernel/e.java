package com.tencent.mm.kernel;

import android.content.SharedPreferences;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mm.b.p;
import com.tencent.mm.co.a;
import com.tencent.mm.compatible.deviceinfo.l;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.cp;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ConfigFile;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ck;
import com.tencent.mm.storage.cq;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.g;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.mm.vfs.w;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

public final class e {
    private static HashMap<Integer, h.b> baseDBFactories;
    public String cachePath;
    public final an hqB = azH();
    private com.tencent.mm.kernel.api.e hqC;
    public b hqD = new b();
    b hqE = new b();
    public String hqF;
    public String hqG;
    public String hqH;
    String hqI;
    public String hqJ;
    public h hqK = null;
    public h hqL = null;
    ao hqM;
    ck hqN;
    cq hqO;
    ConcurrentHashMap<Integer, String> hqP;
    boolean hqQ = false;
    cp hqR;
    ConcurrentHashMap<String, SharedPreferences> hqS = new ConcurrentHashMap<>();
    public boolean hqT = false;
    private long hqU = 0;
    private MMHandler hqV = null;
    public volatile Boolean hqW = null;
    public a hqX = new a(this, (byte) 0);
    public long hqY = 0;

    public static class c {
        public boolean hrc = false;
        public int hrd = 0;
    }

    public static class b extends com.tencent.mm.co.a<h.a> implements h.a {
        b() {
        }

        @Override // com.tencent.mm.storagebase.h.a
        public final void azX() {
            AppMethodBeat.i(132074);
            a(new a.AbstractC0297a<h.a>() {
                /* class com.tencent.mm.kernel.e.b.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(h.a aVar) {
                    AppMethodBeat.i(132071);
                    aVar.azX();
                    AppMethodBeat.o(132071);
                }
            });
            AppMethodBeat.o(132074);
        }

        @Override // com.tencent.mm.storagebase.h.a
        public final void azY() {
            AppMethodBeat.i(132075);
            a(new a.AbstractC0297a<h.a>() {
                /* class com.tencent.mm.kernel.e.b.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(h.a aVar) {
                    AppMethodBeat.i(132072);
                    aVar.azY();
                    AppMethodBeat.o(132072);
                }
            });
            AppMethodBeat.o(132075);
        }

        @Override // com.tencent.mm.storagebase.h.a
        public final void azZ() {
            AppMethodBeat.i(132076);
            a(new a.AbstractC0297a<h.a>() {
                /* class com.tencent.mm.kernel.e.b.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(h.a aVar) {
                    AppMethodBeat.i(132073);
                    aVar.azZ();
                    AppMethodBeat.o(132073);
                }
            });
            AppMethodBeat.o(132076);
        }
    }

    public e(com.tencent.mm.kernel.api.e eVar) {
        AppMethodBeat.i(132077);
        a.hpJ.a(this.hqB);
        String str = ar.NSe + "alphahold.ini";
        Log.i("MMKernel.CoreStorage", "initialize dkalpha client:%x  isapha:%b %s", Integer.valueOf(d.KyO), Boolean.valueOf(d.KyR), str);
        if (d.KyR) {
            String value = ConfigFile.getValue(str, "noneedhold");
            int i2 = d.KyO;
            try {
                i2 = Integer.decode(com.tencent.mm.loader.j.a.CLIENT_VERSION).intValue();
            } catch (Throwable th) {
            }
            if (!String.valueOf(i2).equals(value)) {
                Log.w("MMKernel.CoreStorage", "dkalpha version need  reset to DefaultAccount , hold it! client:%x  isapha:%b", Integer.valueOf(i2), Boolean.valueOf(d.KyR));
                a.azb();
                ConfigFile.saveValue(str, "noneedhold", String.valueOf(i2));
            }
        } else {
            s.deleteFile(str);
        }
        this.hqF = azP();
        this.hqC = eVar;
        AppMethodBeat.o(132077);
    }

    private static an azH() {
        AppMethodBeat.i(132078);
        Log.i("MMKernel.CoreStorage", "initialize packageInfo:%s version:%x", BuildInfo.info(), Integer.valueOf(d.KyO));
        o oVar = new o(ar.NSe);
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        an anVar = new an(ar.NSe + "systemInfo.cfg");
        String str = (String) anVar.get(CdnLogic.kAppTypeFestivalVideo);
        if (str != null) {
            l.aol().set(CdnLogic.kAppTypeFestivalVideo, str);
        }
        try {
            StatFs statFs = new StatFs(g.getDataDirectory().getPath());
            Log.i("MMKernel.CoreStorage", "CheckData path[%s] blocksize:%d blockcount:%d availcount:%d", g.getDataDirectory().getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()));
        } catch (Exception e2) {
            Log.e("MMKernel.CoreStorage", "check data size failed :%s", e2.getMessage());
        }
        AppMethodBeat.o(132078);
        return anVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0165  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.mm.model.at r11) {
        /*
        // Method dump skipped, instructions count: 462
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.kernel.e.a(com.tencent.mm.model.at):boolean");
    }

    /* access modifiers changed from: package-private */
    public final void azI() {
        AppMethodBeat.i(132080);
        this.hqM.set(14, Integer.valueOf(d.KyO));
        AppMethodBeat.o(132080);
    }

    private void y(String str, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(132081);
        Log.i("MMKernel.CoreStorage", "remount resetSysPath sysPath:[%s] newSysPath:[%s] accPath:[%s] cachePath: [%s]", this.hqF, str, this.hqG, this.cachePath);
        if (!Util.isNullOrNil(str)) {
            this.hqG.substring(this.hqF.length());
            this.hqF = str;
            if (!z || !this.hqF.startsWith(com.tencent.mm.loader.j.b.aKD())) {
                z2 = false;
            }
            this.hqJ = z2 ? this.hqI : this.hqH;
            this.hqG = this.hqF + this.hqJ + FilePathGenerator.ANDROID_DIR_SEP;
            azJ();
        }
        AppMethodBeat.o(132081);
    }

    /* access modifiers changed from: package-private */
    public final void azJ() {
        AppMethodBeat.i(132082);
        com.tencent.mm.kernel.a.c.aAu().FU(this.hqG);
        o oVar = new o(this.hqG + FilePathGenerator.NO_MEDIA_FILENAME);
        if (!oVar.exists()) {
            try {
                oVar.createNewFile();
                AppMethodBeat.o(132082);
                return;
            } catch (IOException e2) {
                Log.e("MMKernel.CoreStorage", "exception:%s", Util.stackTraceToString(e2));
            }
        }
        AppMethodBeat.o(132082);
    }

    /* access modifiers changed from: package-private */
    public final void FP(String str) {
        AppMethodBeat.i(132083);
        o oVar = new o(str + "-recovery");
        if (oVar.isFile()) {
            Log.i("MMKernel.CoreStorage", "Recovery database found, replace original one.");
            s.deleteFile(str + ".ini");
            o oVar2 = new o(str);
            oVar2.delete();
            if (!oVar.am(oVar2)) {
                Log.e("MMKernel.CoreStorage", "Rename database file failed!");
            }
        }
        final String name = oVar.getName();
        o[] b2 = oVar.heq().b(new w() {
            /* class com.tencent.mm.kernel.e.AnonymousClass1 */

            @Override // com.tencent.mm.vfs.w
            public final boolean accept(o oVar, String str) {
                AppMethodBeat.i(196989);
                if (!str.startsWith(name) || str.equals(name)) {
                    AppMethodBeat.o(196989);
                    return false;
                }
                AppMethodBeat.o(196989);
                return true;
            }
        });
        if (b2 != null) {
            for (o oVar3 : b2) {
                Log.i("MMKernel.CoreStorage", "Delete temporary recovery database file: " + oVar3.getName());
                oVar3.delete();
            }
        }
        AppMethodBeat.o(132083);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x011c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.mm.storagebase.f r23, java.util.HashMap<java.lang.Integer, com.tencent.mm.storagebase.h.b> r24) {
        /*
        // Method dump skipped, instructions count: 1444
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.kernel.e.a(com.tencent.mm.storagebase.f, java.util.HashMap):boolean");
    }

    public final boolean azK() {
        AppMethodBeat.i(132085);
        g.aAi();
        g.aAf().azk();
        int nullAsNil = Util.nullAsNil((Integer) this.hqM.get(89, (Object) null));
        if (nullAsNil != 0) {
            Log.i("MMKernel.CoreStorage", "isDBCorrupted: false, recoveryState: ".concat(String.valueOf(nullAsNil)));
            AppMethodBeat.o(132085);
            return false;
        }
        boolean z = Util.nullAsNil((String) this.hqM.get(8195, null)).length() <= 0 || Util.nullAsNil((Integer) this.hqM.get(15, null)) == 0;
        if (!z || azL() == null) {
            this.hqM.set(89, (Object) 1);
            this.hqM.gBI();
            Log.i("MMKernel.CoreStorage", "isDBCorrupted: false, needInit: ".concat(String.valueOf(z)));
            AppMethodBeat.o(132085);
            return false;
        }
        Log.i("MMKernel.CoreStorage", "isDBCorrupted: true");
        AppMethodBeat.o(132085);
        return true;
    }

    public final String azL() {
        AppMethodBeat.i(132086);
        o oVar = new o(this.cachePath + "/ctest", "EnMicroMsg.db");
        if (oVar.isFile()) {
            String z = aa.z(oVar.her());
            AppMethodBeat.o(132086);
            return z;
        }
        o oVar2 = new o(this.cachePath + "/corrupted", "EnMicroMsg.db");
        if (oVar2.isFile()) {
            String z2 = aa.z(oVar2.her());
            AppMethodBeat.o(132086);
            return z2;
        }
        String[] a2 = new o(this.cachePath).a(new w() {
            /* class com.tencent.mm.kernel.e.AnonymousClass5 */

            @Override // com.tencent.mm.vfs.w
            public final boolean accept(o oVar, String str) {
                AppMethodBeat.i(196990);
                boolean startsWith = str.startsWith("EnMicroMsg.dberr");
                AppMethodBeat.o(196990);
                return startsWith;
            }
        });
        if (a2 == null || a2.length <= 0) {
            AppMethodBeat.o(132086);
            return null;
        }
        String str = a2[0];
        for (int i2 = 1; i2 < a2.length; i2++) {
            String str2 = a2[i2];
            if (str2.compareTo(str) > 0) {
                str = str2;
            }
        }
        String str3 = this.cachePath + '/' + str;
        AppMethodBeat.o(132086);
        return str3;
    }

    public final void CL(String str) {
        AppMethodBeat.i(132087);
        if (this.hqL != null) {
            this.hqL.closeDB();
        }
        if (this.hqK != null) {
            this.hqK.CL(str);
        }
        this.hqC.onDataBaseClosed(this.hqK, this.hqL);
        this.hqQ = false;
        AppMethodBeat.o(132087);
    }

    public final String azM() {
        return this.cachePath;
    }

    public static String qf(int i2) {
        AppMethodBeat.i(132088);
        String str = ar.NSe + com.tencent.mm.b.g.getMessageDigest("mm".concat(String.valueOf(i2)).getBytes()) + '/';
        AppMethodBeat.o(132088);
        return str;
    }

    public final String getAccPath() {
        return this.hqG;
    }

    public final h getDataDB() {
        return this.hqK;
    }

    public final String azN() {
        AppMethodBeat.i(132089);
        String str = this.cachePath + "MicroMsg.db";
        AppMethodBeat.o(132089);
        return str;
    }

    public final String azO() {
        AppMethodBeat.i(132090);
        String str = this.cachePath + "EnMicroMsg.db";
        AppMethodBeat.o(132090);
        return str;
    }

    public final SharedPreferences FQ(String str) {
        AppMethodBeat.i(132091);
        g.aAi();
        g.aAf();
        int uin = a.getUin();
        if (uin == 0) {
            AppMethodBeat.o(132091);
            return null;
        } else if (this.hqS.containsKey(str)) {
            SharedPreferences sharedPreferences = this.hqS.get(str);
            AppMethodBeat.o(132091);
            return sharedPreferences;
        } else {
            try {
                String str2 = MMApplicationContext.getContext().getFilesDir().getParent() + "/shared_prefs/";
                String str3 = MMApplicationContext.getDefaultPreferencePath() + str + uin + ".xml.bak";
                o oVar = new o(str2 + (MMApplicationContext.getDefaultPreferencePath() + str + uin + ".xml"));
                if (oVar.exists()) {
                    oVar.delete();
                }
                o oVar2 = new o(str2 + str3);
                if (oVar2.exists()) {
                    oVar2.delete();
                }
            } catch (Exception e2) {
            }
            SharedPreferences sharedPreferences2 = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + str + MD5Util.getMD5String(uin + MD5Util.getMD5String(String.valueOf(uin / 2))), 0);
            this.hqS.put(str, sharedPreferences2);
            AppMethodBeat.o(132091);
            return sharedPreferences2;
        }
    }

    private static String azP() {
        AppMethodBeat.i(132092);
        String str = ar.NSe;
        o oVar = new o(com.tencent.mm.loader.j.b.aKD());
        Log.i("MMKernel.CoreStorage", "summer buildSysPath sysPath[" + str + "] SDCARD_ROOT[" + com.tencent.mm.loader.j.b.aKD() + "] file.exists:" + oVar.exists() + " CUtil.isSDCardAvail():" + com.tencent.mm.compatible.util.e.apn());
        if (oVar.exists() && com.tencent.mm.compatible.util.e.apn()) {
            if (FR(com.tencent.mm.loader.j.b.aKJ())) {
                str = com.tencent.mm.loader.j.b.aKJ();
            }
            o oVar2 = new o(com.tencent.mm.loader.j.b.aKV());
            if (!oVar2.exists()) {
                oVar2.mkdirs();
            }
            o oVar3 = new o(com.tencent.mm.loader.j.b.aKN());
            if (!oVar3.exists()) {
                oVar3.mkdirs();
            }
            o oVar4 = new o(com.tencent.mm.loader.j.b.aKO());
            if (!oVar4.exists()) {
                oVar4.mkdirs();
            }
            o oVar5 = new o(com.tencent.mm.loader.j.b.aKP());
            if (!oVar5.exists()) {
                oVar5.mkdirs();
            }
            o oVar6 = new o(com.tencent.mm.loader.j.b.aKN() + FilePathGenerator.NO_MEDIA_FILENAME);
            if (!oVar6.exists()) {
                try {
                    oVar6.createNewFile();
                } catch (IOException e2) {
                    Log.e("MMKernel.CoreStorage", "exception:%s", Util.stackTraceToString(e2));
                }
            }
            FR(com.tencent.mm.loader.j.b.aKM());
        }
        o oVar7 = new o(str);
        if (!oVar7.exists()) {
            oVar7.mkdirs();
        }
        Log.i("MMKernel.CoreStorage", "summer buildSysPath ret sysPath: ".concat(String.valueOf(str)));
        AppMethodBeat.o(132092);
        return str;
    }

    private static final boolean FR(String str) {
        AppMethodBeat.i(132093);
        if (Util.isNullOrNil(str)) {
            Log.i("MMKernel.CoreStorage", "forceMkdirs absolutePath isNullOrNil ret false");
            AppMethodBeat.o(132093);
            return false;
        }
        o oVar = new o(str);
        Log.i("MMKernel.CoreStorage", "forceMkdirs absolutePath[%s], f.exists[%b], f.isDirectory[%b]", str, Boolean.valueOf(oVar.exists()), Boolean.valueOf(oVar.isDirectory()));
        if (!oVar.exists() || !oVar.isDirectory()) {
            String[] split = str.split(FilePathGenerator.ANDROID_DIR_SEP);
            if (split == null || split.length < 2) {
                Log.i("MMKernel.CoreStorage", "forceMkdirs absolutePath arr len illegal ret false");
                AppMethodBeat.o(132093);
                return false;
            }
            String str2 = FilePathGenerator.ANDROID_DIR_SEP;
            Log.i("MMKernel.CoreStorage", "forceMkdirs absolutePath arr len: " + split.length);
            for (int i2 = 0; i2 < split.length; i2++) {
                if (!Util.isNullOrNil(split[i2])) {
                    str2 = str2 + FilePathGenerator.ANDROID_DIR_SEP + split[i2];
                    o oVar2 = new o(str2);
                    if (oVar2.isFile() && !oVar2.am(new o(str2 + "_mmbak"))) {
                        Log.i("MMKernel.CoreStorage", "forceMkdirs renameTo false ret false file[%s]", oVar2.getName());
                        AppMethodBeat.o(132093);
                        return false;
                    } else if (!oVar2.exists() && !oVar2.mkdirs()) {
                        Log.i("MMKernel.CoreStorage", "forceMkdirs mkdir false ret false file[%s]", oVar2.getName());
                        AppMethodBeat.o(132093);
                        return false;
                    }
                }
            }
            Log.i("MMKernel.CoreStorage", "forceMkdirs false ret true");
            AppMethodBeat.o(132093);
            return true;
        }
        Log.i("MMKernel.CoreStorage", "forceMkdirs f is dir and exist ret true");
        AppMethodBeat.o(132093);
        return true;
    }

    public final ao azQ() {
        AppMethodBeat.i(132094);
        g.aAi();
        g.aAf().azk();
        ao aoVar = this.hqM;
        AppMethodBeat.o(132094);
        return aoVar;
    }

    public final ck azR() {
        AppMethodBeat.i(132095);
        g.aAi();
        g.aAf().azk();
        ck ckVar = this.hqN;
        AppMethodBeat.o(132095);
        return ckVar;
    }

    public final void azS() {
        AppMethodBeat.i(132096);
        this.hqW = Boolean.valueOf(isSDCardAvailable());
        AppMethodBeat.o(132096);
    }

    public class a implements com.tencent.f.i.e, Runnable {
        public Future dBz;

        private a() {
        }

        /* synthetic */ a(e eVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(132070);
            e.this.azS();
            AppMethodBeat.o(132070);
        }

        @Override // com.tencent.f.i.e
        public final void a(Future future) {
            this.dBz = future;
        }
    }

    public final boolean isSDCardAvailable() {
        AppMethodBeat.i(132098);
        boolean startsWith = this.hqF.startsWith(com.tencent.mm.loader.j.b.aKD());
        long nowMilliSecond = Util.nowMilliSecond();
        long j2 = nowMilliSecond - this.hqU;
        if (startsWith) {
            g.aAi();
            if (g.aAf().azp() && j2 > 0 && j2 < 2000 && new o(this.hqF).exists()) {
                AppMethodBeat.o(132098);
                return true;
            }
        }
        this.hqU = nowMilliSecond;
        boolean apn = com.tencent.mm.compatible.util.e.apn();
        g.aAi();
        g.aAf();
        Log.i("MMKernel.CoreStorage", "isSDCardAvail:%b uin:%s toNow:%d sysPath:[%s] sdRoot:[%s], acc init:[%b]", Boolean.valueOf(apn), p.getString(a.getUin()), Long.valueOf(j2), this.hqF, com.tencent.mm.loader.j.b.aKD(), Boolean.valueOf(g.aAf().azp()));
        if (!apn) {
            AppMethodBeat.o(132098);
            return false;
        } else if (startsWith) {
            AppMethodBeat.o(132098);
            return true;
        } else {
            g.aAi();
            if (g.aAf().azp()) {
                Log.i("MMKernel.CoreStorage", "summer isSDCardAvailable accHasReady and remount");
                azT();
            }
            AppMethodBeat.o(132098);
            return true;
        }
    }

    public final void azT() {
        boolean z = true;
        AppMethodBeat.i(132099);
        g.aAi();
        synchronized (g.aAf().hpI) {
            try {
                boolean apn = com.tencent.mm.compatible.util.e.apn();
                String azP = azP();
                Log.i("MMKernel.CoreStorage", "remount begin uin:%d oldpath:[%s] newPath:[%s] init:[%b]", Integer.valueOf(a.getUin()), this.hqF, azP, Boolean.valueOf(g.aAf().azp()));
                if (!Util.isNullOrNil(azP)) {
                    if (azP.equalsIgnoreCase(this.hqF)) {
                        try {
                            Log.i("MMKernel.CoreStorage", "testSdcardWritable done ret:" + azU());
                        } catch (Exception e2) {
                            Log.w("MMKernel.CoreStorage", "testSdcardWritable Exception e: " + e2.getMessage());
                        }
                        try {
                            Log.i("MMKernel.CoreStorage", "testSdcardReadable done ret:" + azV());
                        } catch (Exception e3) {
                            Log.w("MMKernel.CoreStorage", "testSdcardReadable Exception e: " + e3.getMessage());
                        }
                        return;
                    }
                    y(azP, apn);
                    boolean z2 = apn && this.hqF.startsWith(com.tencent.mm.loader.j.b.aKD());
                    g.a hYS = com.tencent.mm.vfs.g.hYQ().hYS();
                    if (this.hqI.equals(this.hqH)) {
                        z = false;
                    }
                    y.a(hYS, z2, z);
                    y.a(hYS, this.hqF, z2);
                    hYS.nt("accountSd", z2 ? this.hqI : this.hqH).commit();
                    com.tencent.mm.kernel.a.c.aAu().hrX.aAp();
                    Log.i("MMKernel.CoreStorage", "remout isSDCardAvail :[%b] done", Boolean.valueOf(apn));
                }
                AppMethodBeat.o(132099);
            } finally {
                AppMethodBeat.o(132099);
            }
        }
    }

    private static boolean azU() {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(132100);
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        boolean equalsIgnoreCase = com.tencent.mm.loader.j.b.aKD().equalsIgnoreCase(absolutePath);
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        try {
            z = new o(Environment.getExternalStorageDirectory().getAbsolutePath()).canWrite();
        } catch (Exception e2) {
            Log.w("MMKernel.CoreStorage", "testSdcardWritable 1 e: " + e2.getMessage());
            z = false;
        }
        o oVar = new o(Environment.getExternalStorageDirectory().getAbsolutePath(), "test_writable");
        OutputStream outputStream = null;
        try {
            oVar.createNewFile();
            outputStream = s.ap(oVar);
            outputStream.write(APMidasPayAPI.ENV_TEST.getBytes());
            outputStream.flush();
            outputStream.close();
            boolean delete = oVar.delete();
            if (outputStream != null) {
                try {
                    outputStream.close();
                    z2 = delete;
                } catch (IOException e3) {
                    Log.e("MMKernel.CoreStorage", "exception:%s", Util.stackTraceToString(e3));
                    z2 = delete;
                }
            } else {
                z2 = delete;
            }
        } catch (Exception e4) {
            Log.w("MMKernel.CoreStorage", "testSdcardWritable 2 e: " + e4.getMessage());
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e5) {
                    Log.e("MMKernel.CoreStorage", "exception:%s", Util.stackTraceToString(e5));
                }
            }
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e6) {
                    Log.e("MMKernel.CoreStorage", "exception:%s", Util.stackTraceToString(e6));
                }
            }
            AppMethodBeat.o(132100);
            throw th;
        }
        Log.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + com.tencent.mm.loader.j.b.aKD() + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canWrite: " + z + " canTrueWrite:" + z2);
        AppMethodBeat.o(132100);
        return z2;
    }

    private static boolean azV() {
        boolean z;
        AppMethodBeat.i(132101);
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        boolean equalsIgnoreCase = com.tencent.mm.loader.j.b.aKD().equalsIgnoreCase(absolutePath);
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        try {
            z = new o(Environment.getExternalStorageDirectory().getAbsolutePath()).canRead();
        } catch (Exception e2) {
            z = false;
            Log.w("MMKernel.CoreStorage", "testSdcardReadable 1 e: " + e2.getMessage());
        }
        o oVar = new o(com.tencent.mm.loader.j.b.aKJ());
        boolean exists = oVar.exists();
        if (exists) {
            Log.i("MMKernel.CoreStorage", "testSdcardReadable testFile isDirectory:" + oVar.isDirectory() + " isFile:" + oVar.isFile());
        }
        Log.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + com.tencent.mm.loader.j.b.aKD() + " CConstants.DATAROOT_SDCARD_PATH: " + com.tencent.mm.loader.j.b.aKJ() + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canRead: " + z + " canTrueRead:" + exists);
        AppMethodBeat.o(132101);
        return exists;
    }

    static {
        AppMethodBeat.i(132107);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("CONFIG_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.kernel.e.AnonymousClass6 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return ao.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("TablesVersion".hashCode()), new h.b() {
            /* class com.tencent.mm.kernel.e.AnonymousClass7 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return cq.SQL_CREATE;
            }
        });
        AppMethodBeat.o(132107);
    }

    static HashMap<Integer, h.b> getBaseDBFactories() {
        AppMethodBeat.i(132102);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.putAll(baseDBFactories);
        AppMethodBeat.o(132102);
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] g(com.tencent.mm.vfs.o r10) {
        /*
        // Method dump skipped, instructions count: 259
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.kernel.e.g(com.tencent.mm.vfs.o):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] azW() {
        /*
        // Method dump skipped, instructions count: 114
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.kernel.e.azW():byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(com.tencent.mm.vfs.o r8, byte[] r9) {
        /*
        // Method dump skipped, instructions count: 129
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.kernel.e.a(com.tencent.mm.vfs.o, byte[]):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean d(com.tencent.mm.vfs.o r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 101
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.kernel.e.d(com.tencent.mm.vfs.o, java.lang.String):boolean");
    }

    static String E(int i2, String str) {
        byte[] azW;
        boolean z;
        AppMethodBeat.i(132106);
        o oVar = new o(com.tencent.mm.loader.j.b.aKA(), "account.bin");
        o oVar2 = new o(com.tencent.mm.loader.j.b.aKA() + "MicroMsg/" + str + "/account.bin");
        o oVar3 = new o(com.tencent.mm.loader.j.b.aKA() + "MicroMsg/" + str + "/account.mapping");
        byte[] g2 = g(oVar);
        byte[] g3 = g(oVar2);
        if (g3 != null) {
            z = false;
            azW = g3;
        } else if (g2 != null) {
            z = false;
            azW = g2;
        } else {
            azW = azW();
            if (azW == null) {
                AppMethodBeat.o(132106);
                return null;
            }
            z = true;
        }
        boolean z2 = false;
        if (g3 == null || oVar2.length() != 4112) {
            z2 = a(oVar2, azW) | false;
        }
        if (g2 == null || oVar.length() != 4112) {
            z2 |= a(oVar, azW);
        }
        if (!z || z2) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(azW);
                instance.update(Integer.toString(i2).getBytes());
                byte[] digest = instance.digest();
                StringBuilder sb = new StringBuilder(digest.length * 2);
                char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
                for (int i3 = 0; i3 < 16; i3++) {
                    byte b2 = digest[i3];
                    sb.append(cArr[(b2 >>> 4) & 15]).append(cArr[b2 & 15]);
                }
                String sb2 = sb.toString();
                if (!oVar3.exists()) {
                    d(oVar3, sb2);
                }
                AppMethodBeat.o(132106);
                return sb2;
            } catch (NoSuchAlgorithmException e2) {
                RuntimeException runtimeException = new RuntimeException(e2);
                AppMethodBeat.o(132106);
                throw runtimeException;
            }
        } else {
            Log.e("MMKernel.CoreStorage", "Cannot write new generated data to account files.");
            AppMethodBeat.o(132106);
            return null;
        }
    }
}
