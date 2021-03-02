package com.tencent.mm.plugin.report.service;

import android.content.Context;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public final class f {
    private static Byte Cyt = (byte) 0;
    private static String filePath = (getAppFilePath() + "/kvcomm/exception/");

    static {
        AppMethodBeat.i(143852);
        if (!s.YS(filePath)) {
            s.boN(filePath);
        }
        AppMethodBeat.o(143852);
    }

    private static String getAppFilePath() {
        String str = null;
        AppMethodBeat.i(143846);
        Context context = MMApplicationContext.getContext();
        if (context == null) {
            AppMethodBeat.o(143846);
        } else {
            try {
                o X = o.X(context.getFilesDir());
                if (!X.exists()) {
                    X.createNewFile();
                }
                str = X.toString();
                AppMethodBeat.o(143846);
            } catch (Exception e2) {
                Log.e("MicroMsg.ReportManagerKvCheck", e2.getMessage());
                AppMethodBeat.o(143846);
            }
        }
        return str;
    }

    public static void eOF() {
        AppMethodBeat.i(143847);
        synchronized (Cyt) {
            try {
                if (!s.YS(filePath)) {
                    Log.w("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, filepath:" + filePath + " not exist.");
                    return;
                }
                o[] het = new o(filePath).het();
                if (het == null) {
                    Log.e("MicroMsg.ReportManagerKvCheck", "list file fail, filePath:" + filePath);
                    AppMethodBeat.o(143847);
                    return;
                }
                for (o oVar : het) {
                    if (oVar == null) {
                        Log.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, file is null");
                    } else {
                        String z = aa.z(oVar.her());
                        int i2 = 0;
                        int boW = (int) s.boW(z);
                        Log.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, filename:" + aa.z(oVar.her()) + ", filelenth:" + boW);
                        while (true) {
                            if (i2 >= boW) {
                                Log.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, read to end, deletefile:".concat(String.valueOf(z)));
                                break;
                            }
                            byte[] aW = s.aW(z, i2, 4);
                            if (aW == null) {
                                Log.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, get obj_len fail. delete file:".concat(String.valueOf(z)));
                                break;
                            }
                            int i3 = i2 + 4;
                            try {
                                int byteArrayToInt = byteArrayToInt(aW);
                                byte[] aW2 = s.aW(z, i3, byteArrayToInt);
                                if (aW2 == null) {
                                    Log.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, get obj_data fail. delete file:".concat(String.valueOf(z)));
                                    break;
                                }
                                int i4 = i3 + byteArrayToInt;
                                if (z.contains(".statictis_new2")) {
                                    d dVar = new d();
                                    try {
                                        dVar.parseFrom(aW2);
                                        int i5 = dVar.hii;
                                        int i6 = dVar.oUv;
                                        String str = dVar.Cyk;
                                        boolean z2 = dVar.Cyc;
                                        boolean z3 = dVar.Cyl;
                                        boolean z4 = dVar.Cym;
                                        Log.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, reportkvcomm, logid:" + i5 + ", type:" + i6 + ", value:" + str + ", isReportNow:" + z3 + ", isImportant" + z2);
                                        h hVar = h.INSTANCE;
                                        if (!MMApplicationContext.isMMProcess()) {
                                            h.b(i5, i6, str, z3, z4);
                                        } else if (c.CxC) {
                                            boolean z5 = c.CxD;
                                            e.a((long) i5, (long) i6, str, z5, z5, z4);
                                        } else {
                                            e.a((long) i5, (long) i6, str, z3, false, z4);
                                        }
                                    } catch (Exception e2) {
                                        Log.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(kvcomm), Exception:" + e2.getMessage());
                                        i2 = i4;
                                    }
                                } else if (!z.contains(".monitor")) {
                                    if (!z.contains(".group_monitor")) {
                                        Log.e("MicroMsg.ReportManagerKvCheck", "invalid filename:".concat(String.valueOf(z)));
                                        break;
                                    }
                                    a aVar = new a();
                                    try {
                                        aVar.parseFrom(aW2);
                                        ArrayList<IDKey> arrayList = new ArrayList<>();
                                        boolean z6 = false;
                                        Iterator<b> it = aVar.CxZ.iterator();
                                        while (it.hasNext()) {
                                            b next = it.next();
                                            IDKey iDKey = new IDKey(next.ID, next.Cya, next.Cyb);
                                            boolean z7 = next.Cyc;
                                            arrayList.add(iDKey);
                                            Log.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, idkeyGroupStat, id:" + next.ID + ", key:" + next.Cya + ", value:" + next.Cyb + ", isImportant" + z7);
                                            z6 = z7;
                                        }
                                        h.INSTANCE.b(arrayList, z6);
                                    } catch (IOException e3) {
                                        Log.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(idkey), IOException:" + e3.getMessage());
                                        i2 = i4;
                                    }
                                } else {
                                    b bVar = new b();
                                    try {
                                        bVar.parseFrom(aW2);
                                        long j2 = (long) bVar.ID;
                                        long j3 = (long) bVar.Cya;
                                        long j4 = (long) bVar.Cyb;
                                        boolean z8 = bVar.Cyc;
                                        Log.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, reportidkey, id:" + j2 + ", key:" + j3 + ", value:" + j4 + ", isImportant" + z8);
                                        h.INSTANCE.idkeyStat(j2, j3, j4, z8);
                                    } catch (IOException e4) {
                                        Log.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(idkey), IOException:" + e4.getMessage());
                                        i2 = i4;
                                    }
                                }
                                Log.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, curLen:".concat(String.valueOf(i4)));
                                i2 = i4;
                            } catch (Exception e5) {
                                Log.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, byteArrayToInt error. delete file:".concat(String.valueOf(z)));
                            }
                        }
                        s.deleteFile(z);
                    }
                }
                AppMethodBeat.o(143847);
            } finally {
                AppMethodBeat.o(143847);
            }
        }
    }

    public static void a(int i2, int i3, String str, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(143848);
        if (!s.YS(filePath)) {
            Log.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, filepath:" + filePath + " not exist , logId:" + i2 + ", type:" + i3 + ", val:" + str + ", isImportant:" + z2 + ", reportnow:" + z + ", ignoreFreqLimit:" + z3);
            AppMethodBeat.o(143848);
            return;
        }
        Log.i("MicroMsg.ReportManagerKvCheck", "saveKVcommData, logId:" + i2 + ", type:" + i3 + ", val:" + str + ", isImportant:" + z2 + ", reportnow:" + z + "," + z3);
        String eOG = eOG();
        if ("MM".equals(eOG)) {
            Log.e("MicroMsg.ReportManagerKvCheck", "error path, invalid processname:" + eOG + ", logId:" + i2 + ", type:" + i3 + ", val:" + str + ", isImportant:" + z2 + ", reportnow:" + z + ", ignoreFreqLimit:" + z3);
            AppMethodBeat.o(143848);
            return;
        }
        String str2 = filePath + eOG + ".statictis_new2";
        d dVar = new d();
        dVar.hii = i2;
        dVar.oUv = i3;
        dVar.Cyk = str;
        dVar.Cyc = z2;
        dVar.Cyl = z;
        dVar.Cym = z3;
        try {
            byte[] byteArray = dVar.toByteArray();
            if (byteArray == null) {
                Log.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, null == temp.");
                AppMethodBeat.o(143848);
                return;
            }
            synchronized (Cyt) {
                try {
                    if (s.e(str2, Wk(byteArray.length), 4) != 0) {
                        Log.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, write obj_len to file:" + str2 + " fail.");
                        return;
                    }
                    if (s.e(str2, byteArray, byteArray.length) != 0) {
                        Log.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, write object to file:" + str2 + " fail.");
                    }
                    AppMethodBeat.o(143848);
                } finally {
                    AppMethodBeat.o(143848);
                }
            }
        } catch (IOException e2) {
            Log.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, IOException, detail:" + e2.getMessage());
            AppMethodBeat.o(143848);
        }
    }

    public static void c(int i2, int i3, int i4, boolean z) {
        AppMethodBeat.i(143849);
        Log.i("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, id:" + i2 + ", key:" + i3 + ", value:" + i4 + ", isImportant:" + z);
        if (!s.YS(filePath)) {
            Log.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, filepath:" + filePath + " not exist , Id:" + i2 + ", key:" + i3 + ", value:" + i4 + ", isImportant:" + z);
            AppMethodBeat.o(143849);
            return;
        }
        String eOG = eOG();
        if ("MM".equals(eOG)) {
            Log.e("MicroMsg.ReportManagerKvCheck", "error path, current processname:" + eOG + ", id:" + i2 + ", key:" + i3 + ", val:" + i4 + ", isImportant:" + z);
            AppMethodBeat.o(143849);
            return;
        }
        String str = filePath + eOG + ".monitor";
        b bVar = new b();
        bVar.ID = i2;
        bVar.Cya = i3;
        bVar.Cyb = i4;
        bVar.Cyc = z;
        try {
            byte[] byteArray = bVar.toByteArray();
            if (byteArray == null) {
                Log.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, null == temp.");
                AppMethodBeat.o(143849);
                return;
            }
            synchronized (Cyt) {
                try {
                    if (s.e(str, Wk(byteArray.length), 4) != 0) {
                        Log.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, write obj_len to file:" + str + " fail.");
                        return;
                    }
                    if (s.e(str, byteArray, byteArray.length) != 0) {
                        Log.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, write object to file:" + str + " fail.");
                    }
                    Log.d("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, fileLength:" + s.boW(str));
                    AppMethodBeat.o(143849);
                } finally {
                    AppMethodBeat.o(143849);
                }
            }
        } catch (IOException e2) {
            Log.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, IOException, detail:" + e2.getMessage());
            AppMethodBeat.o(143849);
        }
    }

    public static void f(ArrayList<IDKey> arrayList, boolean z) {
        AppMethodBeat.i(143850);
        Iterator<IDKey> it = arrayList.iterator();
        while (it.hasNext()) {
            IDKey next = it.next();
            Log.i("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, id:" + next.GetID() + ", key:" + next.GetKey() + ", value:" + next.GetValue() + ", isImportant:" + z);
        }
        if (!s.YS(filePath)) {
            Log.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, filepath:" + filePath + " not exist ");
            AppMethodBeat.o(143850);
            return;
        }
        String eOG = eOG();
        if ("MM".equals(eOG)) {
            Log.e("MicroMsg.ReportManagerKvCheck", "error path, current processname:".concat(String.valueOf(eOG)));
            AppMethodBeat.o(143850);
            return;
        }
        String str = filePath + eOG + ".group_monitor";
        a aVar = new a();
        aVar.oTz = arrayList.size();
        Iterator<IDKey> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            IDKey next2 = it2.next();
            b bVar = new b();
            bVar.ID = (int) next2.GetID();
            bVar.Cya = (int) next2.GetKey();
            bVar.Cyb = (int) next2.GetValue();
            bVar.Cyc = z;
            aVar.CxZ.add(bVar);
        }
        try {
            byte[] byteArray = aVar.toByteArray();
            if (byteArray == null) {
                Log.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, null == temp.");
                AppMethodBeat.o(143850);
                return;
            }
            synchronized (Cyt) {
                try {
                    if (s.e(str, Wk(byteArray.length), 4) != 0) {
                        Log.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, write obj_len to file:" + str + " fail.");
                        return;
                    }
                    if (s.e(str, byteArray, byteArray.length) != 0) {
                        Log.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, write object to file:" + str + " fail.");
                    }
                    AppMethodBeat.o(143850);
                } finally {
                    AppMethodBeat.o(143850);
                }
            }
        } catch (IOException e2) {
            Log.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, IOException, detail:" + e2.getMessage());
            AppMethodBeat.o(143850);
        }
    }

    private static String eOG() {
        AppMethodBeat.i(143851);
        String processName = MMApplicationContext.getProcessName();
        if (processName == null || processName.length() == 0) {
            AppMethodBeat.o(143851);
            return "MM";
        }
        String[] split = processName.split(":");
        if (split.length <= 1) {
            AppMethodBeat.o(143851);
            return "MM";
        }
        String str = split[1];
        AppMethodBeat.o(143851);
        return str;
    }

    private static byte[] Wk(int i2) {
        return new byte[]{(byte) ((i2 >> 24) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255)};
    }

    private static int byteArrayToInt(byte[] bArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            i2 = ((bArr[i3] & 255) << ((3 - i3) * 8)) + i2;
        }
        return i2;
    }
}
