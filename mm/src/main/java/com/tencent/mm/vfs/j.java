package com.tencent.mm.vfs;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdcard_migrate.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.aa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class j {
    private static final int[] RcI = {10, 20};
    private static final int[] RcJ = {11, 21};
    private static final int[] RcK = {12, 22};
    private static final int[] RcL = {13, 23};
    private static final int[] RcM = {14, 24};
    private static final int[] RcN = {15, 25};
    private static final int[] RcO = {16, 26};
    private static final int[] RcP = {17, 27};
    private static final int[] RcQ = {18, 28};
    private static final int[] RcR = {19, 29};
    private static final Map<String, Integer> RcS;

    static {
        AppMethodBeat.i(197238);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(MessengerShareContentUtility.ATTACHMENT, 1966120);
        linkedHashMap.put("Download", 2031657);
        linkedHashMap.put("voice", 2097194);
        linkedHashMap.put("voice2", 2162731);
        linkedHashMap.put("image", 2228268);
        linkedHashMap.put("oldimage2", 2293805);
        linkedHashMap.put("video", 2359342);
        linkedHashMap.put("oneday", 2424879);
        linkedHashMap.put("emoji", 2490416);
        linkedHashMap.put("finder", 2555953);
        linkedHashMap.put("CDNDownloadBigFile", 9896088);
        linkedHashMap.put("CheckResUpdate", 10092699);
        RcS = Collections.unmodifiableMap(linkedHashMap);
        AppMethodBeat.o(197238);
    }

    public static void run() {
        int i2;
        int i3;
        boolean b2;
        int i4;
        AppMethodBeat.i(197235);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("VFSStatistic");
        long j2 = mmkv.getLong("VFSReportTime", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - j2 < Util.MILLSECONDS_OF_DAY) {
            AppMethodBeat.o(197235);
            return;
        }
        d.hdU();
        mmkv.encode("VFSReportTime", currentTimeMillis);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        arrayList.add(new IDKey(1387, 0, 1));
        arrayList.add(new IDKey(1387, 2, 1));
        arrayList.add(new IDKey(1387, 3, 1));
        arrayList.add(new IDKey(1387, 4, 1));
        if (b.bhQ(com.tencent.mm.loader.j.b.aKI())) {
            arrayList.add(new IDKey(1387, 100, 1));
        }
        boolean z = mmkv.getBoolean("VFSAsyncFinished", false);
        boolean z2 = mmkv.getBoolean("VFSAsyncFinished3", false);
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(z ? RcI[1] : RcI[0]);
        Log.i("MicroMsg.PostTaskVFSStat", "VFS_ASYNC_KEY_FINISH is %s", objArr);
        Object[] objArr2 = new Object[1];
        objArr2[0] = Integer.valueOf(z2 ? 150 : 149);
        Log.i("MicroMsg.PostTaskVFSStat", "VFS_ASYNC_KEY_FINISH_3 is %s", objArr2);
        arrayList.add(new IDKey(1387, z ? RcI[1] : RcI[0], 1));
        arrayList.add(new IDKey(1387, z2 ? 150 : 149, 1));
        g hYQ = g.hYQ();
        boolean z3 = false;
        boolean z4 = true;
        for (Map.Entry<String, FileSystem> entry : hYQ.hec().entrySet()) {
            String key = entry.getKey();
            FileSystem value = entry.getValue();
            FileSystem.b boT = hYQ.hYT().boT(key);
            if (RcS.containsKey(key)) {
                if (boT instanceof c) {
                    if (value instanceof MigrationFileSystem) {
                        b2 = a((c) boT);
                    } else {
                        b2 = b((c) boT);
                    }
                    z4 = z4 && b2;
                    if (!z2) {
                        int intValue = RcS.get(key).intValue();
                        if (b2) {
                            i4 = (intValue & -65536) >> 16;
                        } else {
                            i4 = intValue & 65535;
                        }
                        arrayList.add(new IDKey(1387, i4, 1));
                        Log.i("MicroMsg.PostTaskVFSStat", "FileSystem %s, isMigrationFinished is %s", key, Boolean.valueOf(b2));
                        if (key.equals("image") && !b2) {
                            z3 = true;
                        }
                    }
                } else {
                    Log.e("MicroMsg.PostTaskVFSStat", "FileSystem %s type error %s", key, value);
                }
            }
            z3 = z3;
            z4 = z4;
        }
        if (z3) {
            arrayList.add(new IDKey(1387, 90, 1));
            FileSystem.b boT2 = g.hYQ().hYT().boT("image");
            if (!(boT2 instanceof c)) {
                Log.i("MicroMsg.PostTaskVFSStat", "state is not DelegateFileSystemState");
            } else {
                aa.a(boT2, new aa.b() {
                    /* class com.tencent.mm.vfs.j.AnonymousClass1 */

                    @Override // com.tencent.mm.vfs.aa.b
                    public final boolean a(FileSystem.b bVar) {
                        AppMethodBeat.i(197234);
                        if (!(bVar instanceof c)) {
                            Log.i("MicroMsg.PostTaskVFSStat", "List image directory of %s:", bVar);
                            Iterable<e> dx = bVar.dx("", false);
                            if (dx != null) {
                                int i2 = 0;
                                for (e eVar : dx) {
                                    i2++;
                                    if (eVar != null) {
                                        Log.i("MicroMsg.PostTaskVFSStat", "--> %s", eVar.NGP);
                                    }
                                    if (i2 > 50) {
                                        break;
                                    }
                                }
                            }
                        }
                        AppMethodBeat.o(197234);
                        return false;
                    }
                });
            }
        }
        Log.i("MicroMsg.PostTaskVFSStat", "VFSP_REPORT_ASYNC_FINISHED is %s, isMigrationFinished is %s", Boolean.valueOf(z2), Boolean.valueOf(z4));
        if (z2 && !z4) {
            arrayList.add(new IDKey(1387, 5, 1));
        }
        if (z2) {
            i2 = mmkv.getInt("VFSAsyncFinish", 0);
        } else {
            i2 = mmkv.getInt("VFSAsyncStart", 0) + 1;
        }
        if (i2 <= 1) {
            i3 = z2 ? RcJ[1] : RcJ[0];
        } else if (i2 <= 2) {
            i3 = z2 ? RcK[1] : RcK[0];
        } else if (i2 <= 3) {
            i3 = z2 ? RcL[1] : RcL[0];
        } else if (i2 <= 5) {
            i3 = z2 ? RcM[1] : RcM[0];
        } else if (i2 <= 10) {
            i3 = z2 ? RcN[1] : RcN[0];
        } else if (i2 <= 15) {
            i3 = z2 ? RcO[1] : RcO[0];
        } else if (i2 <= 20) {
            i3 = z2 ? RcP[1] : RcP[0];
        } else if (i2 <= 30) {
            i3 = z2 ? RcQ[1] : RcQ[0];
        } else {
            i3 = z2 ? RcR[1] : RcR[0];
        }
        Log.i("MicroMsg.PostTaskVFSStat", "DaysKey %s", Integer.valueOf(i3));
        arrayList.add(new IDKey(1387, i3, 1));
        e.INSTANCE.b(arrayList, false);
        if (!z2) {
            if (z4) {
                mmkv.encode("VFSAsyncFinished", true);
                mmkv.encode("VFSAsyncFinished3", true);
                mmkv.encode("VFSAsyncFinish", i2);
                AppMethodBeat.o(197235);
                return;
            }
            mmkv.encode("VFSAsyncStart", i2);
        }
        AppMethodBeat.o(197235);
    }

    private static boolean a(c cVar) {
        AppMethodBeat.i(197236);
        List<FileSystem.b> hdS = cVar.hdS();
        for (FileSystem.b bVar : hdS.subList(1, hdS.size())) {
            Iterable<e> dx = bVar.dx("", false);
            if (dx != null && dx.iterator().hasNext()) {
                AppMethodBeat.o(197236);
                return false;
            }
        }
        AppMethodBeat.o(197236);
        return true;
    }

    private static boolean b(c cVar) {
        AppMethodBeat.i(197237);
        List<FileSystem.b> hdS = cVar.hdS();
        if (hdS == null) {
            AppMethodBeat.o(197237);
            return true;
        }
        for (T t : hdS) {
            if (t != null && (t.hdQ() instanceof MigrationFileSystem) && (t instanceof c) && !a(t)) {
                AppMethodBeat.o(197237);
                return false;
            }
        }
        AppMethodBeat.o(197237);
        return true;
    }
}
