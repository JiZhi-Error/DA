package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.HashSet;

public final class u {
    public static final int PWR = Q(256, 16, 1, 2, 4);
    public static final int PWS = Q(16, 1, 2, 4, 64, 16384);
    public static int PWT = Q(16, 1, 2, 4, 64, 16384, TPMediaCodecProfileLevel.HEVCMainTierLevel62);
    public static int PWU = Q(16, 1, 2, 4, 64, 4096, TPMediaCodecProfileLevel.HEVCMainTierLevel62);
    public static final int PWV = Q(PWR, 64, 16384, 4096, 16777216);
    public static final int PWW = Q(16, 2, 16384, 4);
    public static final int PWX = Q(PWR, 16384, 64, 4096, 16777216);
    public static final int PWY = Q(PWR, 16384, 64, 131072, 8192, 16777216);
    public static final int PWZ = Q(16, 32, 1, 4, 2, 64);
    public static final int PXa = Q(1, 2, 4, 64, 256, 16384);
    public static final int PXb = Q(PWT, 131072);

    static {
        AppMethodBeat.i(133757);
        AppMethodBeat.o(133757);
    }

    public static HashSet<String> gVb() {
        AppMethodBeat.i(133752);
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("weixin");
        AppMethodBeat.o(133752);
        return hashSet;
    }

    public static void h(HashSet<String> hashSet) {
        AppMethodBeat.i(133753);
        hashSet.remove("filehelper");
        AppMethodBeat.o(133753);
    }

    public static HashSet<String> gVc() {
        AppMethodBeat.i(133754);
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("officialaccounts");
        hashSet.add("newsapp");
        for (String str : ab.iCO) {
            hashSet.add(str);
        }
        hashSet.add("weibo");
        hashSet.add("qqmail");
        hashSet.add("fmessage");
        hashSet.add("tmessage");
        hashSet.add("floatbottle");
        hashSet.add("lbsapp");
        hashSet.add("shakeapp");
        hashSet.add("medianote");
        hashSet.add("qqfriend");
        hashSet.add("readerapp");
        hashSet.add("newsapp");
        hashSet.add("blogapp");
        hashSet.add("facebookapp");
        hashSet.add("masssendapp");
        hashSet.add("meishiapp");
        hashSet.add("feedsapp");
        hashSet.add("voipapp");
        hashSet.add("filehelper");
        hashSet.add("officialaccounts");
        hashSet.add("helper_entry");
        hashSet.add("pc_share");
        hashSet.add("cardpackage");
        hashSet.add("voicevoipapp");
        hashSet.add("voiceinputapp");
        hashSet.add("linkedinplugin");
        hashSet.add("appbrandcustomerservicemsg");
        AppMethodBeat.o(133754);
        return hashSet;
    }

    public static boolean hasAttr(int i2, int i3) {
        return (i2 & i3) > 0;
    }

    public static int ll(int i2, int i3) {
        return (i3 ^ -1) & i2;
    }

    public static int Q(int... iArr) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            i2++;
            i3 = iArr[i2] | i3;
        }
        return i3;
    }

    public static void init() {
        AppMethodBeat.i(133755);
        if (!gVd()) {
            if (hasAttr(PWT, TPMediaCodecProfileLevel.HEVCMainTierLevel62)) {
                PWT &= -16777217;
            }
            if (hasAttr(PWU, TPMediaCodecProfileLevel.HEVCMainTierLevel62)) {
                PWU &= -16777217;
                AppMethodBeat.o(133755);
                return;
            }
        } else {
            if (!hasAttr(PWT, TPMediaCodecProfileLevel.HEVCMainTierLevel62)) {
                PWT = Q(PWT, 16777216);
            }
            if (!hasAttr(PWU, TPMediaCodecProfileLevel.HEVCMainTierLevel62)) {
                PWU = Q(PWU, 16777216);
            }
        }
        AppMethodBeat.o(133755);
    }

    public static boolean gVd() {
        AppMethodBeat.i(133756);
        int i2 = ((a) g.af(a.class)).aqJ().getInt("ShowOpenImInGroup", 0);
        Log.i("MMSelectContactLogic", "config_val %s ", Integer.valueOf(i2));
        if (i2 == 0) {
            AppMethodBeat.o(133756);
            return false;
        }
        AppMethodBeat.o(133756);
        return true;
    }
}
