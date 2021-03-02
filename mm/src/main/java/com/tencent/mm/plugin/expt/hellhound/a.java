package com.tencent.mm.plugin.expt.hellhound;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.i.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

public final class a {
    private static PBool syC = null;
    private static PBool syD = null;
    private static PBool syE = null;
    private static PBool syF = null;
    private static PBool syG = null;
    private static PBool syH = null;
    private static PBool syI = null;
    private static PInt syJ = null;
    private static String syK = null;
    private static final List<String> syL = new ArrayList();
    private static boolean syM = false;
    private static boolean syN = false;
    private static int syO = 0;
    private static String syP = "";
    public static boolean syQ = false;

    static {
        AppMethodBeat.i(220382);
        AppMethodBeat.o(220382);
    }

    public static void aov(String str) {
        syK = str;
    }

    public static String cNi() {
        return syK;
    }

    public static void lW(boolean z) {
        AppMethodBeat.i(220378);
        syM = z;
        if (!z) {
            syL.clear();
        }
        AppMethodBeat.o(220378);
    }

    public static boolean aow(String str) {
        AppMethodBeat.i(220379);
        if (!syM) {
            syL.clear();
            AppMethodBeat.o(220379);
            return false;
        } else if (syL.contains(str)) {
            AppMethodBeat.o(220379);
            return true;
        } else {
            syL.add(str);
            AppMethodBeat.o(220379);
            return false;
        }
    }

    public static void lX(boolean z) {
        syN = z;
    }

    public static boolean cNj() {
        return syN;
    }

    public static void cNk() {
        syO++;
    }

    public static boolean cNl() {
        return syO > 0;
    }

    public static void cNm() {
        syO = 0;
    }

    public static void aox(String str) {
        if (str == null) {
            str = "";
        }
        syP = str;
    }

    public static String cNn() {
        return syP;
    }

    public static boolean cNo() {
        boolean z = false;
        AppMethodBeat.i(121797);
        if (syC == null) {
            c.cSa();
            String c2 = c.c(b.a.clicfg_hellhound_switch, "1");
            PBool pBool = new PBool();
            syC = pBool;
            if (Util.getInt(c2, 0) > 0) {
                z = true;
            }
            pBool.value = z;
        }
        if (!syC.value) {
            Log.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, hellhoundSwitch: [false]");
        }
        boolean z2 = syC.value;
        AppMethodBeat.o(121797);
        return z2;
    }

    public static boolean cNp() {
        boolean z = false;
        AppMethodBeat.i(121798);
        if (syD == null) {
            c.cSa();
            String c2 = c.c(b.a.clicfg_hellhound_frontback_switch, "1");
            PBool pBool = new PBool();
            syD = pBool;
            if (Util.getInt(c2, 0) > 0) {
                z = true;
            }
            pBool.value = z;
        }
        if (!syD.value) {
            Log.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, frontbackSwitch: [false]");
        }
        boolean z2 = syD.value;
        AppMethodBeat.o(121798);
        return z2;
    }

    public static boolean cNq() {
        boolean z = false;
        AppMethodBeat.i(121799);
        if (syE == null) {
            c.cSa();
            String c2 = c.c(b.a.clicfg_hellhound_frontback_switch, "1");
            PBool pBool = new PBool();
            syE = pBool;
            if (Util.getInt(c2, 0) > 0) {
                z = true;
            }
            pBool.value = z;
        }
        if (!syE.value) {
            Log.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, sessionSwitch: [false]");
        }
        boolean z2 = syE.value;
        AppMethodBeat.o(121799);
        return z2;
    }

    public static boolean cNr() {
        boolean z = false;
        AppMethodBeat.i(169255);
        if (syG == null) {
            c.cSa();
            String c2 = c.c(b.a.clicfg_hellhound_finder_switch, "1");
            PBool pBool = new PBool();
            syG = pBool;
            if (Util.getInt(c2, 0) > 0) {
                z = true;
            }
            pBool.value = z;
        }
        if (!syG.value) {
            Log.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, fetchFinderSwitch: [false]");
        }
        boolean z2 = syG.value;
        AppMethodBeat.o(169255);
        return z2;
    }

    public static boolean cNs() {
        AppMethodBeat.i(121800);
        if (syF == null) {
            c.cSa();
            String c2 = c.c(b.a.clicfg_hellhound_timeline_switch, "1");
            PBool pBool = new PBool();
            syF = pBool;
            pBool.value = Util.getInt(c2, 0) > 0;
        }
        if (Build.BRAND.equalsIgnoreCase("meizu")) {
            syF.value = false;
        }
        boolean z = syF.value;
        AppMethodBeat.o(121800);
        return z;
    }

    public static boolean cNt() {
        boolean z = false;
        AppMethodBeat.i(121801);
        if (syH == null) {
            c.cSa();
            String c2 = c.c(b.a.clicfg_hellhound_usingasyncevent, "1");
            PBool pBool = new PBool();
            syH = pBool;
            if (Util.getInt(c2, 0) > 0) {
                z = true;
            }
            pBool.value = z;
        }
        if (!syH.value) {
            Log.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, fetchAsyncEventSwitch: [false]");
        }
        boolean z2 = syH.value;
        AppMethodBeat.o(121801);
        return z2;
    }

    public static boolean cNu() {
        boolean z = false;
        AppMethodBeat.i(220380);
        if (syI == null) {
            c.cSa();
            String c2 = c.c(b.a.clicfg_hellhound_hellcgi_switch, "1");
            PBool pBool = new PBool();
            syI = pBool;
            if (Util.getInt(c2, 0) > 0) {
                z = true;
            }
            pBool.value = z;
        }
        if (!syI.value) {
            Log.i("HABBYGE-MALI.HellhoundConfig", "HellhoundConfig, fetchHellCgiSwitch: [false]");
        }
        boolean z2 = syI.value;
        AppMethodBeat.o(220380);
        return z2;
    }

    public static int cNv() {
        AppMethodBeat.i(220381);
        if (syJ == null) {
            c.cSa();
            String c2 = c.c(b.a.clicfg_hellhound_scroll_sampling, "50");
            PInt pInt = new PInt();
            syJ = pInt;
            pInt.value = Util.getInt(c2, 50);
        }
        int i2 = syJ.value;
        AppMethodBeat.o(220381);
        return i2;
    }
}
