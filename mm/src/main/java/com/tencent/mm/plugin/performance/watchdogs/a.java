package com.tencent.mm.plugin.performance.watchdogs;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class a implements Runnable {
    private static final a AVV = new a();
    private static final Set<String> AWg;
    private boolean AVW;
    private boolean AVX;
    private boolean AVY;
    @Deprecated
    private boolean AVZ;
    private int AWa;
    private int AWb;
    private final Map<String, Map<String, Integer>> AWc = new HashMap();
    private final Map<String, Integer> AWd = new HashMap();
    public int AWe = 1024;
    private boolean AWf;

    static {
        AppMethodBeat.i(201129);
        HashSet hashSet = new HashSet();
        AWg = hashSet;
        hashSet.add("anon_inode:sync_file");
        AppMethodBeat.o(201129);
    }

    private a() {
        AppMethodBeat.i(201122);
        AppMethodBeat.o(201122);
    }

    public static a eCE() {
        return AVV;
    }

    public final void run() {
        int i2;
        AppMethodBeat.i(201123);
        if (MMApplicationContext.isMainProcess()) {
            i2 = 100;
        } else if (MMApplicationContext.isToolsProcess() || MMApplicationContext.isToolsMpProcess()) {
            i2 = 120;
        } else if (MMApplicationContext.isAppBrandProcess()) {
            i2 = 140;
        } else if (MMApplicationContext.isPushProcess()) {
            i2 = 150;
        } else {
            i2 = 0;
        }
        int eCG = eCG();
        if (eCG <= 256 && eCG - this.AWb > 32) {
            e.INSTANCE.idkeyStat(1031, (long) (i2 - 2), 1, false);
            this.AWb = Math.max(eCG, this.AWb);
        } else if (256 < eCG && eCG <= 512 && !this.AVW) {
            e.INSTANCE.idkeyStat(1031, (long) (i2 - 1), 1, false);
            this.AVW = true;
        } else if (512 < eCG && eCG <= 768 && !this.AVX) {
            e.INSTANCE.idkeyStat(1031, (long) i2, 1, false);
            this.AVX = true;
        } else if (768 < eCG && eCG <= 896 && !this.AVY) {
            e.INSTANCE.idkeyStat(1031, (long) (i2 + 1), 1, false);
            this.AVY = true;
        } else if (eCG > 896 && !this.AVZ) {
            e.INSTANCE.idkeyStat(1031, (long) (i2 + 2), 1, false);
            Log.e("MicroMsg.FDWatchDog", ">>>>>>>>>>>> FD SOS: total count = %d", Integer.valueOf(eCG));
            o(eCG, eCF(), 0);
            this.AVZ = true;
        }
        if (((double) eCG) > ((double) this.AWe) * 0.9d && !this.AWf) {
            Log.e("MicroMsg.FDWatchDog", ">>>>>>>>>>>> FD SOS: total count = %d", Integer.valueOf(eCG));
            this.AWf = true;
            e.INSTANCE.idkeyStat(1031, (long) (i2 + 4), 1, false);
            o(eCG, eCF(), 1);
        }
        h.RTc.o(this, 1800000);
        AppMethodBeat.o(201123);
    }

    private String eCF() {
        AppMethodBeat.i(201124);
        ArrayList<Map.Entry> arrayList = new ArrayList(this.AWd.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() {
            /* class com.tencent.mm.plugin.performance.watchdogs.a.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                AppMethodBeat.i(201117);
                Map.Entry<String, Integer> entry3 = entry;
                Map.Entry<String, Integer> entry4 = entry2;
                if (entry4.getValue() == null || entry3.getValue() == null) {
                    AppMethodBeat.o(201117);
                    return 0;
                }
                int intValue = entry4.getValue().intValue() - entry3.getValue().intValue();
                AppMethodBeat.o(201117);
                return intValue;
            }
        });
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (Map.Entry entry : arrayList) {
            Log.e("MicroMsg.FDWatchDog", ">>>>>>>>>>>> FD SOS: type = %s, count = %s", entry.getKey(), entry.getValue());
            Map<String, Integer> map = this.AWc.get(entry.getKey());
            if (map != null) {
                ArrayList<Map.Entry> arrayList2 = new ArrayList(map.entrySet());
                Collections.sort(arrayList2, new Comparator<Map.Entry<String, Integer>>() {
                    /* class com.tencent.mm.plugin.performance.watchdogs.a.AnonymousClass2 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // java.util.Comparator
                    public final /* synthetic */ int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                        AppMethodBeat.i(201118);
                        Map.Entry<String, Integer> entry3 = entry;
                        Map.Entry<String, Integer> entry4 = entry2;
                        if (entry4.getValue() == null || entry3.getValue() == null) {
                            AppMethodBeat.o(201118);
                            return 0;
                        }
                        int intValue = entry4.getValue().intValue() - entry3.getValue().intValue();
                        AppMethodBeat.o(201118);
                        return intValue;
                    }
                });
                for (Map.Entry entry2 : arrayList2) {
                    Log.e("MicroMsg.FDWatchDog", "-> [%s] %s", entry2.getValue(), entry2.getKey());
                    int i3 = i2 + 1;
                    if (i2 < 40) {
                        sb.append("[").append(entry2.getValue()).append("]").append((String) entry2.getKey()).append(";");
                    }
                    i2 = i3;
                }
            }
        }
        String sb2 = sb.toString();
        Log.e("MicroMsg.FDWatchDog", "top path is %s", sb2);
        AppMethodBeat.o(201124);
        return sb2;
    }

    private int a(EnumC1574a aVar) {
        AppMethodBeat.i(201125);
        Integer num = this.AWd.get(aVar.name());
        if (num == null) {
            AppMethodBeat.o(201125);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(201125);
        return intValue;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0113  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int eCG() {
        /*
        // Method dump skipped, instructions count: 545
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.performance.watchdogs.a.eCG():int");
    }

    private void o(int i2, String str, int i3) {
        AppMethodBeat.i(201127);
        e.INSTANCE.a(17899, Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()), MMApplicationContext.getProcessName(), Integer.valueOf(a(EnumC1574a.FD_TYPE_ANNON_INODE_EVENT)), Integer.valueOf(a(EnumC1574a.FD_TYPE_ANNON_INODE_DMABUF)), Integer.valueOf(a(EnumC1574a.FD_TYPE_SOCKET)), Integer.valueOf(a(EnumC1574a.FD_TYPE_PATH_DATA_MM_FILES_MMKV)), Integer.valueOf(a(EnumC1574a.FD_TYPE_PATH_DATA_MM_FILES_KVCOMM)), Integer.valueOf(a(EnumC1574a.FD_TYPE_PATH_DATA_MM_FILES_XLOG)), Integer.valueOf(a(EnumC1574a.FD_TYPE_PATH_DATA_MM_FILES_OTHERS)), Integer.valueOf(a(EnumC1574a.FD_TYPE_PATH_DATA_MM_MICRO_MSG)), Integer.valueOf(a(EnumC1574a.FD_TYPE_PATH_DATA_MM_OTHERS)), Integer.valueOf(a(EnumC1574a.FD_TYPE_PATH_EXT_AC_VOICE)), Integer.valueOf(a(EnumC1574a.FD_TYPE_PATH_EXT_AC_VIDEO)), Integer.valueOf(a(EnumC1574a.FD_TYPE_PATH_EXT_AC_ATTACHMENT)), Integer.valueOf(a(EnumC1574a.FD_TYPE_PATH_EXT_AC_IMAGE)), Integer.valueOf(a(EnumC1574a.FD_TYPE_PATH_EXT_AC_OTHERS)), Integer.valueOf(a(EnumC1574a.FD_TYPE_PATH_EXT_OTHERS)), Integer.valueOf(a(EnumC1574a.FD_TYPE_PATH_SYSTEM_FRAMEWORK)), Integer.valueOf(a(EnumC1574a.FD_TYPE_PATH_DEV_ASHMEM)), Integer.valueOf(a(EnumC1574a.FD_TYPE_PATH_DEV_OTHERS)), Integer.valueOf(a(EnumC1574a.FD_TYPE_OTHERS)), str, Integer.valueOf(this.AWa), Integer.valueOf(a(EnumC1574a.FD_TYPE_ANNON_INODE_GRALLOC)), Integer.valueOf(a(EnumC1574a.FD_TYPE_PIPE)), Integer.valueOf(a(EnumC1574a.FD_TYPE_ANNON_INODE_MALITL)), Integer.valueOf(i3), Integer.valueOf(this.AWe), Integer.valueOf(a(EnumC1574a.FD_TYPE_RAW_PATH)));
        AppMethodBeat.o(201127);
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"SdCardPath"})
    /* renamed from: com.tencent.mm.plugin.performance.watchdogs.a$a  reason: collision with other inner class name */
    public enum EnumC1574a {
        FD_TYPE_ANNON_INODE_EVENT("anon_inode:\\[event.*\\]"),
        FD_TYPE_ANNON_INODE_DMABUF(".*dmabuf.*"),
        FD_TYPE_ANNON_INODE_GRALLOC("anon_inode:gralloc.*"),
        FD_TYPE_ANNON_INODE_MALITL("anon_inode:malitl.*"),
        FD_TYPE_SOCKET(".*socket:.*"),
        FD_TYPE_PIPE(".*pipe:[0-9]*"),
        FD_TYPE_PATH_DATA_MM_FILES_MMKV("/data/.*/" + MMApplicationContext.getApplicationId() + "/files/mmkv/.*"),
        FD_TYPE_PATH_DATA_MM_FILES_KVCOMM("/data/.*/" + MMApplicationContext.getApplicationId() + "/files/kvcomm/.*"),
        FD_TYPE_PATH_DATA_MM_FILES_XLOG("/data/.*/" + MMApplicationContext.getApplicationId() + "/files/xlog/.*"),
        FD_TYPE_PATH_DATA_MM_FILES_OTHERS("/data/.*/" + MMApplicationContext.getApplicationId() + "/files/.*"),
        FD_TYPE_PATH_DATA_MM_MICRO_MSG("/data/.*/" + MMApplicationContext.getApplicationId() + "/MicroMsg/.*"),
        FD_TYPE_PATH_DATA_MM_OTHERS("/data/.*/" + MMApplicationContext.getApplicationId() + "/.*"),
        FD_TYPE_PATH_EXT_AC_VOICE(".*/MicroMsg/[0-9a-eA-E]+/voice2/.*"),
        FD_TYPE_PATH_EXT_AC_VIDEO(".*/MicroMsg/[0-9a-eA-E]+/video/.*"),
        FD_TYPE_PATH_EXT_AC_ATTACHMENT(".*/MicroMsg/[0-9a-eA-E]+/attachment/.*"),
        FD_TYPE_PATH_EXT_AC_IMAGE(".*/MicroMsg/[0-9a-eA-E]+/image[2]?/.*"),
        FD_TYPE_PATH_EXT_AC_OTHERS(".*/MicroMsg/[0-9a-eA-E]+/.*"),
        FD_TYPE_PATH_EXT_OTHERS(".*/MicroMsg/.*"),
        FD_TYPE_PATH_SYSTEM_FRAMEWORK("/system/framework/.*"),
        FD_TYPE_PATH_DEV_ASHMEM("/dev/ashmem"),
        FD_TYPE_PATH_DEV_OTHERS("/dev/.*"),
        FD_TYPE_RAW_PATH("/proc/[0-9]*/fd/[0-9]*"),
        FD_TYPE_OTHERS(".*");
        
        private final String AWF;

        public static EnumC1574a valueOf(String str) {
            AppMethodBeat.i(201120);
            EnumC1574a aVar = (EnumC1574a) Enum.valueOf(EnumC1574a.class, str);
            AppMethodBeat.o(201120);
            return aVar;
        }

        static {
            AppMethodBeat.i(201121);
            AppMethodBeat.o(201121);
        }

        private EnumC1574a(String str) {
            this.AWF = str;
        }
    }

    private static boolean aJZ(String str) {
        AppMethodBeat.i(201128);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(201128);
            return true;
        }
        for (String str2 : AWg) {
            if (str.matches(str2)) {
                AppMethodBeat.o(201128);
                return true;
            }
        }
        AppMethodBeat.o(201128);
        return false;
    }
}
