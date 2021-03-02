package com.tencent.mm.vfs;

import android.os.StatFs;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.g;
import com.tencent.mm.vfs.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class x {
    private static a RdM;
    private static int RdN = 1401;
    private static int RdO = 0;
    private static int RdP = 1;
    private static int RdQ = 2;
    private static int RdR = 3;
    private static int RdS = 4;
    private static int RdT = 5;
    private static int RdU = 6;
    private static int RdV = 7;
    private static int RdW = 8;
    private static int RdX = 9;
    private static int RdY = 20047;
    private static int RdZ = 1;
    private static int Rea = 2;
    private static int Reb = 3;
    private static HashMap<String, Long> Rec = new HashMap<>();
    private static HashMap<String, Long> Red = new HashMap<>();
    private static int Ree = 0;
    private static float Ref = -1.0f;
    private static int Reg = 0;
    private static float Reh = -1.0f;
    private static long Rei = 0;
    private static long Rej = 0;
    private static long Rek = -1;
    private static long Rel = -1;
    private static long Rem = -1;
    private static int Ren = -1;
    private static int Reo = -1;
    private static long Rep = -1;
    private static long Req = -1;
    private static long Rer = 0;
    private static long Res = -1;
    private static long Reu = 0;
    private static long Rev = 0;
    private static long Rew = -1;
    private static long Rex = -1;
    private static ArrayList<IDKey> dmd = new ArrayList<>();
    private static LinkedList<String> ljc = new LinkedList<>();
    private static long qpE = 0;

    static {
        AppMethodBeat.i(197244);
        Rec.put("sns", 0L);
        Rec.put("sns_ad_landingpages", 0L);
        Rec.put("finder", 0L);
        Rec.put("brandicon", 0L);
        Rec.put("bizcache", 0L);
        Rec.put("openapi_cache", 0L);
        Rec.put("CDNTemp", 0L);
        Rec.put("vproxy", 0L);
        Rec.put("backupRecover", 0L);
        Rec.put("msgsynchronize", 0L);
        Red.put("oneday", 0L);
        Red.put("bizimg", 0L);
        Red.put("openim", 0L);
        Red.put("avatar", 0L);
        Red.put("wallet_images", 0L);
        Red.put("emoji", 0L);
        AppMethodBeat.o(197244);
    }

    public static a heu() {
        AppMethodBeat.i(197242);
        if (RdM == null) {
            RdM = new a((byte) 0);
            h.Rco.a(RdM);
        }
        a aVar = RdM;
        AppMethodBeat.o(197242);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public static class a implements g.d, n.a {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.vfs.n.a
        public final void a(String str, FileSystem fileSystem, int i2, Map<String, Object> map) {
            AppMethodBeat.i(197239);
            Log.d("MicroMsg.VFSStatistics", "VFS statistics name:%s, fs:%s, phase:%s, params:%s", str, fileSystem.toString(), Integer.valueOf(i2), map);
            if (!(fileSystem instanceof ExpireFileSystem)) {
                if (!(fileSystem instanceof QuotaFileSystem)) {
                    if ((fileSystem instanceof CleanExpireFileSystem) && str.equals("sns")) {
                        switch (i2) {
                            case 1:
                                long unused = x.Rep = System.currentTimeMillis();
                                long unused2 = x.Req = -1;
                                long unused3 = x.Rer = 0;
                                AppMethodBeat.o(197239);
                                return;
                            case 3:
                                if (x.Rep > 0) {
                                    long unused4 = x.Req = System.currentTimeMillis() - x.Rep;
                                    long unused5 = x.Rep = -1;
                                }
                                int unused6 = x.Ree = ((Integer) map.get("cleanStorageCount")).intValue();
                                float unused7 = x.Ref = ((Float) map.get("cleanRepetitionRatio")).floatValue();
                                int unused8 = x.Reg = ((Integer) map.get("cleanRepetitionRatioCount")).intValue();
                                float unused9 = x.Reh = ((Float) map.get("cleanStorageRepetitionRatio")).floatValue();
                                long unused10 = x.Rei = ((Long) map.get("cleanStorageDeleteSize")).longValue();
                                long unused11 = x.Rej = ((Long) map.get("cleanStorageFreeSize")).longValue();
                                long unused12 = x.qpE = ((Long) map.get("deleteSize")).longValue();
                                long unused13 = x.Rek = ((Long) map.get("cleanOriginExpireTime")).longValue();
                                long unused14 = x.Rel = ((Long) map.get("cleanNewExpireTime")).longValue();
                                long unused15 = x.Rem = ((Long) map.get("cleanExtraCostTime")).longValue();
                                int unused16 = x.Ren = ((Integer) map.get("cleanTrend")).intValue();
                                int unused17 = x.Reo = ((Integer) map.get("changeSwitch")).intValue();
                                x.Rer += x.qpE;
                                x.Reu += x.qpE;
                                break;
                        }
                    }
                } else {
                    switch (i2) {
                        case 2:
                            long unused18 = x.Res = ((Long) map.get("totalSize")).longValue();
                            AppMethodBeat.o(197239);
                            return;
                        case 3:
                            if (x.Res >= 0) {
                                long longValue = x.Res - ((Long) map.get("totalSize")).longValue();
                                if (longValue <= 0) {
                                    Log.e("MicroMsg.VFSStatistics", "deleteSize <= 0!, deleteSize:%d, quotaBeginSize:%d", Long.valueOf(longValue), Long.valueOf(x.Res));
                                    x.ljc.add(str);
                                } else if (x.Red.containsKey(str)) {
                                    x.Red.put(str, Long.valueOf(((Long) x.Red.get(str)).longValue() + longValue));
                                } else {
                                    x.Red.put(str, Long.valueOf(longValue));
                                }
                                x.Rev += longValue;
                                long unused19 = x.Res = -1;
                                break;
                            } else {
                                Log.e("MicroMsg.VFSStatistics", "quotaBeginSize is not initialize");
                                x.ljc.add(str);
                                AppMethodBeat.o(197239);
                                return;
                            }
                    }
                    AppMethodBeat.o(197239);
                    return;
                }
            } else if (i2 == 3) {
                long longValue2 = ((Long) map.get("deleteSize")).longValue();
                if (x.Rec.containsKey(str)) {
                    x.Rec.put(str, Long.valueOf(((Long) x.Rec.get(str)).longValue() + longValue2));
                } else {
                    x.Rec.put(str, Long.valueOf(longValue2));
                }
                x.Reu += longValue2;
                AppMethodBeat.o(197239);
                return;
            }
            AppMethodBeat.o(197239);
        }

        @Override // com.tencent.mm.vfs.g.d
        public final void hdV() {
            AppMethodBeat.i(197240);
            Log.i("MicroMsg.VFSStatistics", "onMaintenanceBegin");
            x.resetParams();
            long unused = x.Rew = System.currentTimeMillis();
            x.dmd.add(new IDKey(x.RdN, x.RdO, 1));
            AppMethodBeat.o(197240);
        }

        @Override // com.tencent.mm.vfs.g.d
        public final void bh(boolean z, boolean z2) {
            int i2;
            AppMethodBeat.i(197241);
            Log.i("MicroMsg.VFSStatistics", "onMaintenanceEnd");
            x.dmd.add(new IDKey(x.RdN, x.RdP, 1));
            long j2 = x.Reu + x.Rev;
            long j3 = j2 / 1024 == 0 ? 1 : j2 / 1024;
            x.dmd.add(new IDKey((long) x.RdN, (long) x.RdQ, j3));
            if (z) {
                int i3 = x.Rea;
                x.dmd.add(new IDKey(x.RdN, x.RdT, 1));
                x.dmd.add(new IDKey((long) x.RdN, (long) x.RdU, j3));
                i2 = i3;
            } else if (z2) {
                int i4 = x.Reb;
                x.dmd.add(new IDKey(x.RdN, x.RdV, 1));
                x.dmd.add(new IDKey((long) x.RdN, (long) x.RdW, j3));
                i2 = i4;
            } else {
                int i5 = x.RdZ;
                x.dmd.add(new IDKey(x.RdN, x.RdR, 1));
                x.dmd.add(new IDKey((long) x.RdN, (long) x.RdS, j3));
                i2 = i5;
            }
            if (x.Rew > 0) {
                long unused = x.Rex = System.currentTimeMillis() - x.Rew;
                x.dmd.add(new IDKey((long) x.RdN, (long) x.RdX, x.Rex));
            }
            e.INSTANCE.b(x.dmd, true);
            StringBuilder sb = new StringBuilder();
            for (String str : x.Rec.keySet()) {
                Log.d("MicroMsg.VFSStatistics", "name:%s, size:%d", str, x.Rec.get(str));
                sb.append(str).append(":").append(x.Rec.get(str)).append(";");
            }
            for (String str2 : x.Red.keySet()) {
                Log.d("MicroMsg.VFSStatistics", "name:%s, size:%d", str2, x.Red.get(str2));
                sb.append(str2).append(":").append(x.Red.get(str2)).append(";");
            }
            StringBuilder sb2 = new StringBuilder();
            Iterator it = x.ljc.iterator();
            while (it.hasNext()) {
                sb2.append((String) it.next()).append(";");
            }
            String path = com.tencent.mm.compatible.util.g.getExternalStorageDirectory().getPath();
            long j4 = 0;
            if (b.aKE().equals(path)) {
                try {
                    StatFs statFs = new StatFs(path);
                    j4 = (long) (statFs.getAvailableBlocks() * statFs.getBlockSize());
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.VFSStatistics", e2, "Unable to get FS size.", new Object[0]);
                }
            } else {
                StatFs statFs2 = new StatFs(b.aKE());
                j4 = (long) (statFs2.getAvailableBlocks() * statFs2.getBlockSize());
            }
            e.INSTANCE.a(x.RdY, Integer.valueOf(i2), Long.valueOf(x.Rex), Long.valueOf(j2), Long.valueOf(x.Reu), Long.valueOf(x.Rev), sb.toString(), sb2.toString(), Integer.valueOf(x.Ree), Integer.valueOf((int) x.Ref), Integer.valueOf((int) x.Reh), Long.valueOf(x.Rei), Long.valueOf(x.Rej), Long.valueOf(x.Rer), Long.valueOf(x.Rel), Long.valueOf(x.Rem), Long.valueOf(x.Req), Integer.valueOf(x.Ren), Integer.valueOf(x.Reo), Long.valueOf(x.Rek), Integer.valueOf(x.Reg), 1, Long.valueOf(j4));
            Log.i("MicroMsg.VFSStatistics", "onMaintenanceEnd report finish code:%d, costTime:%d, deleteSize:%d, result:%s, errList:%s, storageCount:%d, repetitionRatio:%s, storageRepetitionRatio:%s, storageDeleteSize:%d, storageFreeSize:%d, vfsCleanExpireDeleteSize:%d, newExpireTime:%d, cleanExtraCostTime:%d, vfsCleanExpireCostTime:%d, cleanTrend:%d, changeSwitch:%d, originExpireTime:%d, repetitionRatioCount:%d, isVFSOpened:%d, availableSize:%d", Integer.valueOf(i2), Long.valueOf(x.Rex), Long.valueOf(j2), sb.toString(), sb2.toString(), Integer.valueOf(x.Ree), Float.valueOf(x.Ref), Float.valueOf(x.Reh), Long.valueOf(x.Rei), Long.valueOf(x.Rej), Long.valueOf(x.Rer), Long.valueOf(x.Rel), Long.valueOf(x.Rem), Long.valueOf(x.Req), Integer.valueOf(x.Ren), Integer.valueOf(x.Reo), Long.valueOf(x.Rek), Integer.valueOf(x.Reg), 1, Long.valueOf(j4));
            AppMethodBeat.o(197241);
        }
    }

    public static void resetParams() {
        AppMethodBeat.i(197243);
        dmd.clear();
        Rec.clear();
        Red.clear();
        ljc.clear();
        Res = -1;
        Reu = 0;
        Rev = 0;
        Rew = -1;
        Rex = -1;
        Ree = 0;
        Ref = -1.0f;
        Reg = 0;
        Reh = -1.0f;
        Rei = 0;
        Rej = 0;
        qpE = 0;
        Rek = -1;
        Rek = -1;
        Rel = -1;
        Rem = -1;
        Ren = -1;
        Reo = -1;
        Rep = -1;
        Req = -1;
        Rer = 0;
        AppMethodBeat.o(197243);
    }
}
