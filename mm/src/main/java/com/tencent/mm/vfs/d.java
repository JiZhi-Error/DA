package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.g;
import com.tencent.mm.vfs.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d implements n.a {
    private static final int Rbr;
    private static Map<String, a> Rbs = new HashMap();
    private static Map<String, a> Rbt;
    private static boolean Rbu = false;
    private static Set<String> Rbv = new HashSet();
    private static Set<String> Rbw = new HashSet();
    private static final g.d Rbx = new g.d() {
        /* class com.tencent.mm.vfs.d.AnonymousClass1 */

        @Override // com.tencent.mm.vfs.g.d
        public final void hdV() {
            AppMethodBeat.i(197205);
            synchronized (d.sLock) {
                try {
                    Map unused = d.Rbt = new HashMap();
                } catch (Throwable th) {
                    AppMethodBeat.o(197205);
                    throw th;
                }
            }
            Log.i("VFS.DiskFileStatistics", "Begin statistics maintenance");
            AppMethodBeat.o(197205);
        }

        @Override // com.tencent.mm.vfs.g.d
        public final void bh(boolean z, boolean z2) {
            AppMethodBeat.i(197206);
            if (z || z2) {
                synchronized (d.sLock) {
                    try {
                        Log.i("VFS.DiskFileStatistics", "Interrupted statistics maintenance, statistics count: " + d.Rbt.size());
                        d.Rbs.putAll(d.Rbt);
                        Map unused = d.Rbt = null;
                    } finally {
                        AppMethodBeat.o(197206);
                    }
                }
                return;
            }
            try {
                long currentTimeMillis = System.currentTimeMillis();
                Iterable<e> dx = new NativeFileSystem("${data}/MicroMsg/${account}").cj(g.hYQ().hYU()).dx("", false);
                if (dx != null) {
                    for (e eVar : dx) {
                        if (!eVar.RbJ && eVar.name.endsWith(".db")) {
                            String str = "${data}/MicroMsg/${account}/" + eVar.name;
                            a aVar = new a("@DiskSpace-DB", 12, 0, str, eVar.RbH, 1, 0, 1, eVar.size, eVar.RbI - currentTimeMillis, 0, 0);
                            synchronized (d.sLock) {
                                try {
                                    (d.Rbt == null ? d.Rbs : d.Rbt).put(str + '|' + "@DiskSpace-DB", aVar);
                                } catch (Throwable th) {
                                    AppMethodBeat.o(197206);
                                    throw th;
                                }
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("VFS.DiskFileStatistics", e2, "Failed to calculate databases.", new Object[0]);
            }
            int i2 = d.Rbr;
            com.tencent.mm.kernel.g.aAf();
            boolean z3 = ((i2 ^ com.tencent.mm.kernel.a.getUin()) ^ BuildInfo.CLIENT_VERSION_INT) % 1024 == 0 || WeChatEnvironment.hasDebugger();
            synchronized (d.sLock) {
                try {
                    Map unused2 = d.Rbs = d.Rbt;
                    for (a aVar2 : d.Rbs.values()) {
                        if (z3) {
                            e.INSTANCE.a(21388, aVar2.name, Integer.valueOf(aVar2.type), Integer.valueOf(aVar2.flags), aVar2.path, Long.valueOf(aVar2.oJj), Integer.valueOf(aVar2.fileCount), Integer.valueOf(aVar2.RbA), Integer.valueOf(aVar2.RbB), Long.valueOf(aVar2.RbC), 0L, Long.valueOf(aVar2.RbD), Long.valueOf(aVar2.RbE), Long.valueOf(aVar2.jmW));
                        }
                        Log.i("VFS.DiskFileStatistics", "KV > name: %s, type: %d, flags: %d, path: %s, totalSize: %d, fileCount: %d, dirCount: %d, maxDepth: %d, maxFileSize: %d, filesAge: %d", aVar2.name, Integer.valueOf(aVar2.type), Integer.valueOf(aVar2.flags), aVar2.path, Long.valueOf(aVar2.oJj), Integer.valueOf(aVar2.fileCount), Integer.valueOf(aVar2.RbA), Integer.valueOf(aVar2.RbB), Long.valueOf(aVar2.RbC), Long.valueOf(aVar2.RbD));
                    }
                    Log.i("VFS.DiskFileStatistics", "End statistics maintenance, statistics count: " + d.Rbt.size());
                    Map unused3 = d.Rbt = null;
                    boolean unused4 = d.Rbu = true;
                } catch (Throwable th2) {
                    AppMethodBeat.o(197206);
                    throw th2;
                }
            }
            d.VV();
            AppMethodBeat.o(197206);
        }
    };
    private static final Pattern Rbz = Pattern.compile("[0-9a-f]{32}(?:temp[0-9]+)?");
    private static final Object sLock = new Object();
    private final int FV;
    private final long Rby;
    private final String mPath;
    private final int mType;
    private final long nfE;

    static {
        AppMethodBeat.i(197215);
        long nanoTime = System.nanoTime();
        Random random = new Random();
        random.setSeed(nanoTime);
        Rbr = random.nextInt();
        AppMethodBeat.o(197215);
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        final int RbA;
        final int RbB;
        final long RbC;
        final long RbD;
        final long RbE;
        final int fileCount;
        final int flags;
        final long jmW;
        final String name;
        final long oJj;
        final String path;
        final int type;

        a(String str, int i2, int i3, String str2, long j2, int i4, int i5, int i6, long j3, long j4, long j5, long j6) {
            this.name = str;
            this.type = i2;
            this.flags = i3;
            this.path = str2;
            this.oJj = j2;
            this.fileCount = i4;
            this.RbA = i5;
            this.RbB = i6;
            this.RbC = j3;
            this.RbD = j4;
            this.RbE = j5;
            this.jmW = j6;
        }
    }

    public d(String str, int i2, int i3, long j2, long j3) {
        this.mPath = str;
        this.mType = i2;
        this.FV = i3;
        this.Rby = j2;
        this.nfE = j3;
    }

    @Override // com.tencent.mm.vfs.n.a
    public final void a(String str, FileSystem fileSystem, int i2, Map<String, Object> map) {
        String str2;
        AppMethodBeat.i(197207);
        String str3 = (String) map.get("relPath");
        if (!str3.isEmpty()) {
            str2 = this.mPath + '/' + str3;
        } else {
            str2 = this.mPath;
        }
        a aVar = new a(str, this.mType, this.FV, str2, ((Long) map.get("totalSize")).longValue(), ((Integer) map.get("fileCount")).intValue(), ((Integer) map.get("dirCount")).intValue(), ((Integer) map.get("maxDepth")).intValue(), ((Long) map.get("maxFileSize")).longValue(), ((Long) map.get("averageAge")).longValue(), this.Rby, this.nfE);
        synchronized (sLock) {
            try {
                (Rbt == null ? Rbs : Rbt).put(str2 + '|' + str, aVar);
            } finally {
                AppMethodBeat.o(197207);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009e, code lost:
        r26 = ((double) r14) / ((double) r22);
        r28 = ((double) r20) / ((double) r22);
        r30 = ((double) r12) / ((double) r22);
        r32 = new java.util.ArrayList<>();
        r32.add(new com.tencent.mars.smc.IDKey(1556, 0, 1));
        r32.add(new com.tencent.mars.smc.IDKey(1556, 1, r20 / 1048576));
        r32.add(new com.tencent.mars.smc.IDKey(1556, 2, r18 / 1048576));
        r32.add(new com.tencent.mars.smc.IDKey(1556, 3, r8 / 1048576));
        r32.add(new com.tencent.mars.smc.IDKey(1556, 4, r14 / 1048576));
        r32.add(new com.tencent.mars.smc.IDKey(1556, 5, r24 / 1048576));
        r32.add(new com.tencent.mars.smc.IDKey(1556, 6, r10 / 1048576));
        r32.add(new com.tencent.mars.smc.IDKey(1556, 7, r12 / 1048576));
        r32.add(new com.tencent.mars.smc.IDKey(1556, 9, r22 / 1048576));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0162, code lost:
        if (r14 >= com.tencent.thumbplayer.core.common.TPAudioFrame.TP_CH_STEREO_LEFT) goto L_0x0265;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0164, code lost:
        r2 = 41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0166, code lost:
        r32.add(new com.tencent.mars.smc.IDKey(1556, r2, 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x017a, code lost:
        if (r26 >= 0.2d) goto L_0x028e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x017c, code lost:
        r2 = 51;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x017e, code lost:
        r32.add(new com.tencent.mars.smc.IDKey(1556, r2, 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0192, code lost:
        if (r28 >= 0.2d) goto L_0x02a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0194, code lost:
        r2 = 61;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0196, code lost:
        r32.add(new com.tencent.mars.smc.IDKey(1556, r2, 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x01aa, code lost:
        if (r30 >= 0.2d) goto L_0x02c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x01ac, code lost:
        r2 = 71;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x01ae, code lost:
        r32.add(new com.tencent.mars.smc.IDKey(1556, r2, 1));
        com.tencent.mm.plugin.report.e.INSTANCE.b(r32, true);
        com.tencent.mm.sdk.platformtools.Log.i("VFS.DiskFileStatistics", "IDKEY > persist: %dM, expire: %dM, lru: %dM, nonVfs: %dM, cache: %dM, tencent: %dM, other: %dM, all: %dM, nonVfsRatio: %.2f%%, persistRatio: %.2f%%, otherRatio: %.2f%%", java.lang.Long.valueOf(r20 / 1048576), java.lang.Long.valueOf(r18 / 1048576), java.lang.Long.valueOf(r8 / 1048576), java.lang.Long.valueOf(r14 / 1048576), java.lang.Long.valueOf(r24 / 1048576), java.lang.Long.valueOf(r10 / 1048576), java.lang.Long.valueOf(r12 / 1048576), java.lang.Long.valueOf(r22 / 1048576), java.lang.Double.valueOf(100.0d * r26), java.lang.Double.valueOf(100.0d * r28), java.lang.Double.valueOf(100.0d * r30));
        com.tencent.matrix.trace.core.AppMethodBeat.o(197209);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x026a, code lost:
        if (r14 >= com.tencent.thumbplayer.core.common.TPAudioFrame.TP_CH_STEREO_RIGHT) goto L_0x0270;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x026c, code lost:
        r2 = 42;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0277, code lost:
        if (r14 >= 2147483648L) goto L_0x027d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0279, code lost:
        r2 = 43;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0284, code lost:
        if (r14 >= 4294967296L) goto L_0x028a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0286, code lost:
        r2 = 44;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x028a, code lost:
        r2 = 45;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0292, code lost:
        if (r26 >= 0.5d) goto L_0x0298;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0294, code lost:
        r2 = 52;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x029f, code lost:
        if (r26 >= 0.8d) goto L_0x02a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x02a1, code lost:
        r2 = 53;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x02a5, code lost:
        r2 = 54;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x02ad, code lost:
        if (r28 >= 0.5d) goto L_0x02b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x02af, code lost:
        r2 = 62;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x02ba, code lost:
        if (r28 >= 0.8d) goto L_0x02c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x02bc, code lost:
        r2 = 63;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x02c0, code lost:
        r2 = 64;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x02c8, code lost:
        if (r30 >= 0.5d) goto L_0x02ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x02ca, code lost:
        r2 = 72;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x02d5, code lost:
        if (r30 >= 0.8d) goto L_0x02db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x02d7, code lost:
        r2 = 73;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x02db, code lost:
        r2 = 74;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void hdU() {
        /*
        // Method dump skipped, instructions count: 760
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.vfs.d.hdU():void");
    }

    private static void a(g.a aVar, String str, String[] strArr, Set<String> set, boolean z, int i2) {
        AppMethodBeat.i(197210);
        Map<String, String> hYU = g.hYQ().hYU();
        for (String str2 : strArr) {
            ArrayList arrayList = new ArrayList();
            try {
                NativeFileSystem nativeFileSystem = new NativeFileSystem(str2);
                for (e eVar : nativeFileSystem.cj(hYU).dx("", false)) {
                    if (eVar.RbJ && !set.contains(eVar.name) && Rbz.matcher(eVar.name).matches() == z) {
                        arrayList.add(eVar.name);
                    }
                }
                StatisticsFileSystem statisticsFileSystem = new StatisticsFileSystem(nativeFileSystem, arrayList);
                statisticsFileSystem.a(str + str2, new d(str2, i2, 0, 0, 0));
                aVar.b(str + str2, statisticsFileSystem);
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(197210);
    }

    public static void hp(String str, int i2) {
        boolean z = true;
        AppMethodBeat.i(197211);
        boolean z2 = (i2 & 4) == 0;
        if ((i2 & 3) == 0) {
            z = false;
        }
        if (!z) {
            AppMethodBeat.o(197211);
            return;
        }
        synchronized (sLock) {
            if (z2) {
                try {
                    Rbw.add(str);
                } catch (Throwable th) {
                    AppMethodBeat.o(197211);
                    throw th;
                }
            } else {
                Rbv.add(str);
            }
        }
        AppMethodBeat.o(197211);
    }

    public static void b(g.a aVar) {
        Set<String> set;
        Set<String> set2;
        AppMethodBeat.i(197212);
        synchronized (sLock) {
            try {
                set = Rbv;
                set2 = Rbw;
                Rbv = Collections.emptySet();
                Rbw = Collections.emptySet();
            } catch (Throwable th) {
                AppMethodBeat.o(197212);
                throw th;
            }
        }
        a(aVar, "@DiskSpace-NonAccountSdcard-", new String[]{"${sdFrom}/MicroMsg", "${sdTo}/MicroMsg", "${sdToCache}"}, set, false, 10);
        a(aVar, "@DiskSpace-AccountSdcard-", new String[]{"${sdFrom}/MicroMsg/${account}", "${sdTo}/MicroMsg/${account}", "${sdToCache}/${account}", "${sdFrom}/MicroMsg/${accountSalt}", "${sdTo}/MicroMsg/${accountSalt}", "${sdToCache}/${accountSalt}"}, set2, false, 11);
        a(aVar, "@DiskSpace-NonAccountData-", new String[]{"${data}", "${dataCache}"}, new HashSet(Arrays.asList(".vfs", "MicroMsg", "cache")), false, 7);
        StatisticsFileSystem statisticsFileSystem = new StatisticsFileSystem(new NativeFileSystem("${data}/MicroMsg/${account}"));
        statisticsFileSystem.a("@DiskSpace-AccountData", new d("${data}/MicroMsg/${account}", 8, 0, 0, 0));
        aVar.b("@DiskSpace-AccountData", statisticsFileSystem);
        AppMethodBeat.o(197212);
    }

    public static void c(g.a aVar) {
        AppMethodBeat.i(197213);
        Map<String, String> hYU = g.hYQ().hYU();
        HashSet hashSet = new HashSet(Arrays.asList(hYU.get("account"), hYU.get("accountSalt")));
        a(aVar, "@DiskSpace-OtherAccountSdcard-", new String[]{"${sdFrom}/MicroMsg", "${sdTo}/MicroMsg", "${sdToCache}"}, hashSet, true, 5);
        a(aVar, "@DiskSpace-OtherAccountData-", new String[]{"${data}/MicroMsg"}, hashSet, true, 9);
        AppMethodBeat.o(197213);
    }

    static void init() {
        AppMethodBeat.i(197208);
        try {
            JSONObject jSONObject = new JSONObject(s.boY(aa.z(new o(MMApplicationContext.getContext().getFilesDir(), "vfs-statistics").mUri)));
            if (jSONObject.optInt("version") != 1) {
                Log.e("VFS.DiskFileStatistics", "Mismatched file version: " + jSONObject.optInt("version"));
            } else {
                JSONArray jSONArray = jSONObject.getJSONArray("content");
                int length = jSONArray.length();
                HashMap hashMap = new HashMap();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    String string = jSONObject2.getString("name");
                    String string2 = jSONObject2.getString("path");
                    hashMap.put(string2 + '|' + string, new a(string, jSONObject2.getInt("type"), jSONObject2.getInt("flags"), string2, jSONObject2.getLong("totalSize"), jSONObject2.getInt("fileCount"), jSONObject2.getInt("dirCount"), jSONObject2.getInt("maxDepth"), jSONObject2.getLong("maxFileSize"), jSONObject2.getLong("filesAge"), jSONObject2.optLong("targetSize"), jSONObject2.optLong("expireTime")));
                }
                Log.i("VFS.DiskFileStatistics", "Loaded statistics, count: " + hashMap.size());
                synchronized (sLock) {
                    try {
                        Rbs = hashMap;
                        Rbu = true;
                    } catch (Throwable th) {
                        AppMethodBeat.o(197208);
                        throw th;
                    }
                }
            }
        } catch (IOException | JSONException e2) {
            Log.printErrStackTrace("VFS.DiskFileStatistics", e2, "Unable to load statistics", new Object[0]);
        }
        h.Rco.a(Rbx);
        AppMethodBeat.o(197208);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0117  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void VV() {
        /*
        // Method dump skipped, instructions count: 306
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.vfs.d.VV():void");
    }
}
