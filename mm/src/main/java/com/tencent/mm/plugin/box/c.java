package com.tencent.mm.plugin.box;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.protocal.protobuf.dkb;
import com.tencent.mm.protocal.protobuf.fbs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c {
    private static HashSet<String> plA = new HashSet<>();
    private static HashSet<String> plB = new HashSet<>();
    public static final Runnable plC = new Runnable() {
        /* class com.tencent.mm.plugin.box.c.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(196184);
            try {
                String ki = c.ki(false);
                for (int i2 = 0; i2 < 3; i2++) {
                    int aho = c.aho(ki);
                    if (aho == 0) {
                        AppMethodBeat.o(196184);
                        return;
                    }
                    switch (aho) {
                        case -4:
                            Log.e("MicroMsg.HotWordSearchUtil", "[loadTask] wordBank file empty");
                        case -3:
                            s.deleteFile(ki);
                            Log.e("MicroMsg.HotWordSearchUtil", "[loadTask] wordBank file broken, reCreate Model");
                            break;
                        case -2:
                            break;
                        default:
                    }
                    if (-1 == c.kh(true)) {
                        Log.e("MicroMsg.HotWordSearchUtil", "[loadTask] wordBank file broken, and raw file not exist");
                        AppMethodBeat.o(196184);
                        return;
                    }
                }
                AppMethodBeat.o(196184);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.HotWordSearchUtil", e2, "[loadTask]", new Object[0]);
                AppMethodBeat.o(196184);
            }
        }
    };
    private static int plD = 1;
    private static int plE = 0;
    private static AtomicBoolean plr = new AtomicBoolean(false);
    private static AtomicBoolean pls = new AtomicBoolean(false);
    private static short[][] plt;
    private static int[][] plu;
    private static final HashMap<Integer, LinkedList<Integer>> plv = new HashMap<>();
    private static int plw = 0;
    private static int plx = 2;
    private static int ply = 400;
    private static int plz = 0;

    static {
        AppMethodBeat.i(196200);
        AppMethodBeat.o(196200);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f6 A[LOOP:2: B:41:0x00f4->B:42:0x00f6, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0180 A[Catch:{ Exception -> 0x0212 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01b6 A[Catch:{ Exception -> 0x0212 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int kh(boolean r15) {
        /*
        // Method dump skipped, instructions count: 552
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.box.c.kh(boolean):int");
    }

    public static void ba(byte[] bArr) {
        AppMethodBeat.i(196186);
        try {
            dkb dkb = (dkb) new dkb().parseFrom(bArr);
            plw = dkb.version;
            fbs fbs = dkb.MNY;
            plA.clear();
            plA.addAll(fbs.NxQ);
            fbs fbs2 = dkb.MNX;
            plB.clear();
            plB.addAll(fbs2.NxQ);
            Iterator<String> it = plB.iterator();
            while (it.hasNext()) {
                Log.i("MicroMsg.HotWordSearchUtil", "[white word]: %s", it.next());
            }
            Iterator<String> it2 = plA.iterator();
            while (it2.hasNext()) {
                Log.i("MicroMsg.HotWordSearchUtil", "[black word]: %s", it2.next());
            }
            Log.i("MicroMsg.HotWordSearchUtil", "realTimeWordsVersion: %s, minMatchLen: %s, maxMatchLen: %s, disable: %s, blackList.size: %s, whiteList.size: %s", Integer.valueOf(plw), Integer.valueOf(plx), Integer.valueOf(ply), Integer.valueOf(plz), Integer.valueOf(plA.size()), Integer.valueOf(plB.size()));
            AppMethodBeat.o(196186);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.HotWordSearchUtil", e2, "[resolveRealTimeWordBankFile]", new Object[0]);
            AppMethodBeat.o(196186);
        }
    }

    public static int aho(String str) {
        int i2;
        AppMethodBeat.i(196187);
        if (!((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch() || !((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch()) {
            Log.i("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] finger search not open");
            AppMethodBeat.o(196187);
            return 0;
        } else if (!s.YS(str)) {
            Log.e("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] wordBank file do NOT exist, path: %s", str);
            AppMethodBeat.o(196187);
            return -2;
        } else {
            pls.set(true);
            plr.set(false);
            long aWA = cl.aWA();
            byte[] aW = s.aW(str, 0, -1);
            plE = 0;
            if (aW.length < 24) {
                Log.e("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] bytes.length(%s) < 24", Integer.valueOf(aW.length));
                if (aW.length == 0) {
                    AppMethodBeat.o(196187);
                    return -4;
                }
                AppMethodBeat.o(196187);
                return -3;
            }
            plw = bb(aW);
            plx = bb(aW);
            ply = bb(aW);
            plz = bb(aW);
            int bb = bb(aW);
            if (bb != 20003) {
                Log.e("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] wordBank file broken, wordGroupC: %s, reCreate model", Integer.valueOf(bb));
                AppMethodBeat.o(196187);
                return -3;
            }
            int length = ((aW.length - 20) - (bb * 4)) / 6;
            Log.i("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] wordCntAvailable = %s", Integer.valueOf(length));
            plt = new short[bb][];
            plu = new int[bb][];
            int i3 = 0;
            int i4 = 0;
            while (i3 < bb) {
                int bb2 = bb(aW);
                int i5 = i4 + bb2;
                if (i5 > length) {
                    Log.e("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] currCnt(%s) > wordCntAvailable%(%s)", Integer.valueOf(i5), Integer.valueOf(length));
                    AppMethodBeat.o(196187);
                    return -3;
                }
                plt[i3] = new short[bb2];
                plu[i3] = new int[bb2];
                for (int i6 = 0; i6 < bb2; i6++) {
                    short[] sArr = plt[i3];
                    int i7 = plE;
                    plE = i7 + 1;
                    int i8 = plE;
                    plE = i8 + 1;
                    sArr[i6] = (short) (((aW[i7] << 8) & 255) + (aW[i8] & 255));
                    plu[i3][i6] = bb(aW);
                }
                if (bb2 > 200) {
                    LinkedList<Integer> linkedList = new LinkedList<>();
                    short s = plt[i3][0];
                    int i9 = 1;
                    int i10 = 1;
                    while (i10 < bb2) {
                        if (plt[i3][i10] != s) {
                            linkedList.addLast(Integer.valueOf(i9));
                            i2 = 1;
                            s = plt[i3][i10];
                        } else {
                            i2 = i9 + 1;
                        }
                        i10++;
                        i9 = i2;
                    }
                    linkedList.addLast(Integer.valueOf(i9));
                    plv.put(Integer.valueOf(i3), linkedList);
                }
                i3++;
                i4 = i5;
            }
            plr.set(true);
            pls.set(false);
            long ceil = (long) Math.ceil((double) (cl.aWA() - aWA));
            ar.o((long) i4, ceil, 2);
            Log.i("MicroMsg.HotWordSearchUtil", "[loadFromCustomProtocolFile] load model from disk use %s ms, total cnt = %s", Long.valueOf(ceil), Integer.valueOf(i4));
            AppMethodBeat.o(196187);
            return 0;
        }
    }

    public static boolean ahp(String str) {
        AppMethodBeat.i(196188);
        if (pls.get()) {
            Log.i("MicroMsg.HotWordSearchUtil", "[hashSearch] wordBank is loading, Give UP searching");
            AppMethodBeat.o(196188);
            return false;
        } else if (!plr.get() || plt == null || plu == null) {
            Log.w("MicroMsg.HotWordSearchUtil", "[hashSearch] wordBank has NOT init");
            AppMethodBeat.o(196188);
            return false;
        } else if (str.length() < plx || str.length() > ply) {
            Log.i("MicroMsg.HotWordSearchUtil", "[hashSearch] text.length(%s) is NOT in range [%s, %s]", Integer.valueOf(str.length()), Integer.valueOf(plx), Integer.valueOf(ply));
            AppMethodBeat.o(196188);
            return false;
        } else {
            long aWA = cl.aWA();
            int length = str.length();
            int i2 = 0;
            while (i2 < str.length() - 1) {
                int hashCode = str.substring(i2, i2 + 2).hashCode();
                int length2 = plt.length;
                short[] sArr = plt[hashCode % length2];
                int[] iArr = plu[hashCode % length2];
                int length3 = sArr.length;
                if (length3 > 200) {
                    LinkedList<Integer> linkedList = plv.get(Integer.valueOf(hashCode % length2));
                    if (linkedList == null) {
                        Log.e("MicroMsg.HotWordSearchUtil", "[hashSearch] hashConflictHandler.get(%d) == null", Integer.valueOf(hashCode % length2));
                        AppMethodBeat.o(196188);
                        return false;
                    }
                    int i3 = 0;
                    Iterator<Integer> it = linkedList.iterator();
                    while (it.hasNext()) {
                        int intValue = it.next().intValue();
                        if (sArr[i3] + i2 > length) {
                            continue;
                            break;
                        }
                        int ahu = ahu(str.substring(i2, sArr[i3] + i2));
                        int i4 = (i3 + intValue) - 1;
                        int i5 = i3;
                        while (i5 <= i4) {
                            int i6 = (i5 + i4) / 2;
                            if (ahu == iArr[i6]) {
                                String substring = str.substring(i2, sArr[i3] + i2);
                                plD = Math.max((int) Math.ceil((double) (cl.aWA() - aWA)), 1);
                                Log.i("MicroMsg.HotWordSearchUtil", "[hashSearch] found hot word: %s, use %s ms", substring, Integer.valueOf(plD));
                                AppMethodBeat.o(196188);
                                return true;
                            } else if (ahu < iArr[i6]) {
                                i4 = i6 - 1;
                            } else {
                                i5 = i6 + 1;
                            }
                        }
                        i3 += intValue;
                    }
                    continue;
                } else {
                    int i7 = 0;
                    while (i7 < length3 && sArr[i7] + i2 <= length) {
                        if (ahu(str.substring(i2, sArr[i7] + i2)) == iArr[i7]) {
                            plD = Math.max((int) Math.ceil((double) (cl.aWA() - aWA)), 1);
                            Log.i("MicroMsg.HotWordSearchUtil", "[hashSearch] found hot word: %s, use %s ms", str.substring(i2, sArr[i7] + i2), Integer.valueOf(plD));
                            AppMethodBeat.o(196188);
                            return true;
                        }
                        i7++;
                    }
                }
                i2++;
            }
            plD = Math.max((int) Math.ceil((double) (cl.aWA() - aWA)), 1);
            Log.i("MicroMsg.HotWordSearchUtil", "[hashSearch] NO hot word found");
            AppMethodBeat.o(196188);
            return false;
        }
    }

    public static String ahq(String str) {
        AppMethodBeat.i(196189);
        if (pls.get()) {
            Log.i("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] wordBank is loading, Give UP searching");
            AppMethodBeat.o(196189);
            return "";
        } else if (!plr.get() || plt == null || plu == null) {
            Log.w("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] wordBank has NOT init");
            AppMethodBeat.o(196189);
            return "";
        } else if (str.length() < plx || str.length() > ply) {
            Log.i("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] text.length(%s) is NOT in range [%s, %s]", Integer.valueOf(str.length()), Integer.valueOf(plx), Integer.valueOf(ply));
            AppMethodBeat.o(196189);
            return "";
        } else {
            int length = str.length();
            short s = 0;
            while (s < str.length() - 1) {
                int hashCode = str.substring(s, s + 2).hashCode();
                int length2 = plt.length;
                short[] sArr = plt[hashCode % length2];
                int[] iArr = plu[hashCode % length2];
                int length3 = sArr.length;
                if (length3 > 200) {
                    LinkedList<Integer> linkedList = plv.get(Integer.valueOf(hashCode % length2));
                    if (linkedList == null) {
                        Log.e("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] hashConflictHandler.get(%d) == null", Integer.valueOf(hashCode % length2));
                        AppMethodBeat.o(196189);
                        return "";
                    }
                    Iterator<Integer> it = linkedList.iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        int intValue = it.next().intValue();
                        if (sArr[i2] + s > length) {
                            continue;
                            break;
                        }
                        int ahu = ahu(str.substring(s, sArr[i2] + s));
                        int i3 = (i2 + intValue) - 1;
                        int i4 = i2;
                        while (i4 <= i3) {
                            int i5 = (i4 + i3) / 2;
                            if (ahu == iArr[i5]) {
                                String substring = str.substring(s, sArr[i2] + s);
                                AppMethodBeat.o(196189);
                                return substring;
                            } else if (ahu < iArr[i5]) {
                                i3 = i5 - 1;
                            } else {
                                i4 = i5 + 1;
                            }
                        }
                        i2 += intValue;
                    }
                    continue;
                } else {
                    int i6 = 0;
                    while (i6 < length3 && sArr[i6] + s <= length) {
                        if (ahu(str.substring(s, sArr[i6] + s)) == iArr[i6]) {
                            String substring2 = str.substring(s, sArr[i6] + s);
                            AppMethodBeat.o(196189);
                            return substring2;
                        }
                        i6++;
                    }
                }
                s++;
            }
            AppMethodBeat.o(196189);
            return "";
        }
    }

    public static HashSet<String> ahr(String str) {
        AppMethodBeat.i(196190);
        HashSet<String> hashSet = new HashSet<>();
        if (pls.get()) {
            Log.i("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] wordBank is loading, Give UP searching");
            AppMethodBeat.o(196190);
            return hashSet;
        } else if (!plr.get() || plt == null || plu == null) {
            Log.w("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] wordBank has NOT init");
            AppMethodBeat.o(196190);
            return hashSet;
        } else if (str.length() < plx || str.length() > ply) {
            Log.i("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] text.length(%s) is NOT in range [%s, %s]", Integer.valueOf(str.length()), Integer.valueOf(plx), Integer.valueOf(ply));
            AppMethodBeat.o(196190);
            return hashSet;
        } else {
            int length = str.length();
            int i2 = 0;
            while (i2 < str.length() - 1) {
                int hashCode = str.substring(i2, i2 + 2).hashCode();
                int length2 = plt.length;
                short[] sArr = plt[hashCode % length2];
                int[] iArr = plu[hashCode % length2];
                int length3 = sArr.length;
                if (length3 > 200) {
                    LinkedList<Integer> linkedList = plv.get(Integer.valueOf(hashCode % length2));
                    if (linkedList != null) {
                        int i3 = 0;
                        Iterator<Integer> it = linkedList.iterator();
                        while (it.hasNext()) {
                            int intValue = it.next().intValue();
                            if (sArr[i3] + i2 > length) {
                                break;
                            }
                            int ahu = ahu(str.substring(i2, sArr[i3] + i2));
                            int i4 = (i3 + intValue) - 1;
                            int i5 = i3;
                            while (true) {
                                if (i5 > i4) {
                                    break;
                                }
                                int i6 = (i5 + i4) / 2;
                                if (ahu == iArr[i6]) {
                                    hashSet.add(str.substring(i2, sArr[i3] + i2));
                                    break;
                                } else if (ahu < iArr[i6]) {
                                    i4 = i6 - 1;
                                } else {
                                    i5 = i6 + 1;
                                }
                            }
                            i3 += intValue;
                        }
                    } else {
                        Log.e("MicroMsg.HotWordSearchUtil", "[hashSearchFullStr] hashConflictHandler.get(%d) == null", Integer.valueOf(hashCode % length2));
                        AppMethodBeat.o(196190);
                        return null;
                    }
                } else {
                    int i7 = 0;
                    while (i7 < length3 && sArr[i7] + i2 <= length) {
                        if (ahu(str.substring(i2, sArr[i7] + i2)) == iArr[i7]) {
                            hashSet.add(str.substring(i2, sArr[i7] + i2));
                        }
                        i7++;
                    }
                }
                i2++;
            }
            AppMethodBeat.o(196190);
            return hashSet;
        }
    }

    public static int ahs(String str) {
        AppMethodBeat.i(196191);
        o oVar = new o(MMApplicationContext.getContext().getCacheDir(), "wordBank/temp");
        if (oVar.exists()) {
            s.dy(aa.z(oVar.her()), true);
        }
        oVar.mkdirs();
        int fW = s.fW(str, aa.z(oVar.her()));
        if (fW < 0) {
            Log.e("MicroMsg.HotWordSearchUtil", "unzip fail, ret = " + fW + ", zipFilePath = " + str + ", unzipPath = " + aa.z(oVar.her()));
            AppMethodBeat.o(196191);
            return -1;
        }
        o oVar2 = new o(oVar, "config.conf");
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = s.ao(oVar2);
            properties.load(inputStream);
            aa.closeQuietly(inputStream);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.HotWordSearchUtil", e2, "[getWordBankVersionFromZip] %s", str);
            aa.closeQuietly(inputStream);
        } catch (Throwable th) {
            aa.closeQuietly(inputStream);
            AppMethodBeat.o(196191);
            throw th;
        }
        int parseInt = Integer.parseInt(properties.getProperty("version", "1").trim());
        AppMethodBeat.o(196191);
        return parseInt;
    }

    public static int ckV() {
        AppMethodBeat.i(196192);
        String ckX = ckX();
        if (!s.YS(ckX + "/config.conf")) {
            Log.i("MicroMsg.HotWordSearchUtil", "[getCurrentWordBankVersion] config.conf NOT exist, path: %s", ckX + "/config.conf");
            AppMethodBeat.o(196192);
            return 1;
        }
        o oVar = new o(ckX, "config.conf");
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = s.ao(oVar);
            properties.load(inputStream);
            aa.closeQuietly(inputStream);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.HotWordSearchUtil", e2, "[getCurrentWordBankVersion]", new Object[0]);
            aa.closeQuietly(inputStream);
        } catch (Throwable th) {
            aa.closeQuietly(inputStream);
            AppMethodBeat.o(196192);
            throw th;
        }
        int parseInt = Integer.parseInt(properties.getProperty("version", "1").trim());
        AppMethodBeat.o(196192);
        return parseInt;
    }

    public static String getWordBankVersionForStat() {
        AppMethodBeat.i(196193);
        String str = ckV() + "_" + plw;
        AppMethodBeat.o(196193);
        return str;
    }

    public static String ki(boolean z) {
        AppMethodBeat.i(196195);
        String z2 = aa.z(new o(new o(ckX()), z ? "fs_kw_main.txt" : "wordBank").her());
        AppMethodBeat.o(196195);
        return z2;
    }

    public static String ckW() {
        AppMethodBeat.i(196196);
        String z = aa.z(new o(new o(ckX()), "blackWhite").her());
        AppMethodBeat.o(196196);
        return z;
    }

    private static String ckX() {
        AppMethodBeat.i(196197);
        String str = ai.afr(2).fYs() + "/wordBankDir";
        AppMethodBeat.o(196197);
        return str;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        short plF;
        int plG;

        a(short s, int i2) {
            this.plF = s;
            this.plG = i2;
        }
    }

    public static int getSearchDuration() {
        AppMethodBeat.i(196198);
        int max = Math.max(plD, 1);
        AppMethodBeat.o(196198);
        return max;
    }

    private static int ahu(String str) {
        int i2 = 0;
        AppMethodBeat.i(196199);
        for (int i3 = 0; i3 < str.length(); i3++) {
            i2 = (i2 * TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE) + ((short) str.charAt(i3));
        }
        int i4 = Integer.MAX_VALUE & i2;
        AppMethodBeat.o(196199);
        return i4;
    }

    private static int bb(byte[] bArr) {
        int i2 = plE;
        plE = i2 + 1;
        int i3 = plE;
        plE = i3 + 1;
        int i4 = ((bArr[i2] & 255) << 24) + ((bArr[i3] & 255) << 16);
        int i5 = plE;
        plE = i5 + 1;
        int i6 = i4 + ((bArr[i5] & 255) << 8);
        int i7 = plE;
        plE = i7 + 1;
        return i6 + (bArr[i7] & 255);
    }

    public static int aht(String str) {
        AppMethodBeat.i(196194);
        String ckX = ckX();
        if (s.YS(ckX)) {
            s.dy(ckX, true);
        }
        s.boN(ckX);
        int fW = s.fW(str, ckX);
        if (fW < 0) {
            Log.e("MicroMsg.HotWordSearchUtil", "[updateWordBank] unzip fail, ret = " + fW + ", zipFilePath = " + str + ", unzipPath = " + ckX);
            AppMethodBeat.o(196194);
            return -1;
        }
        Log.i("MicroMsg.HotWordSearchUtil", "[updateWordBank] unzip success, path: %s", ckX);
        AppMethodBeat.o(196194);
        return 0;
    }
}
