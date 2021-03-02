package com.tencent.mm.plugin.gallery.a;

import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.kz;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.n.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.s;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class d {
    private static final String[] xsA = {"Pictures/Screenshots", "DCIM/Screenshots", "Screenshot"};
    private static final String[] xsB = {"DCIM/Video screenshots", "DCIM/Screen recordings", "DCIM/ScreenRecorder", "Movies/Screenrecords"};
    public static final int xsC = b.aKV().substring(0, b.aKV().length() - 1).toLowerCase().hashCode();
    public static final int xsD = azj("DCIM/Camera");
    public static final int xsE = azj("download");
    public static final ArrayList<Integer> xsF = new ArrayList<>(xsA.length);
    public static final ArrayList<Integer> xsG = new ArrayList<>(xsB.length);

    public static void swap(List<?> list, int i2, int i3) {
        AppMethodBeat.i(111741);
        if (i2 > i3) {
            while (i2 > i3) {
                Collections.swap(list, i2, i2 - 1);
                i2--;
            }
            AppMethodBeat.o(111741);
            return;
        }
        while (i2 < i3) {
            Collections.swap(list, i2, i2 + 1);
            i2++;
        }
        AppMethodBeat.o(111741);
    }

    public static void bw(int i2, String str) {
        AppMethodBeat.i(111742);
        h.INSTANCE.kvStat(i2, str);
        AppMethodBeat.o(111742);
    }

    public static void c(String str, String str2, boolean z, boolean z2) {
        AppMethodBeat.i(111743);
        if (EventCenter.instance != null) {
            kz kzVar = new kz();
            kzVar.dQb.dQc = Boolean.valueOf(z);
            kzVar.dQb.imagePath = str;
            kzVar.dQb.dQd = 0;
            kzVar.dQb.toUser = str2;
            kzVar.dQb.dQe = Boolean.valueOf(z2);
            EventCenter.instance.publish(kzVar);
        }
        AppMethodBeat.o(111743);
    }

    public static void dSa() {
        AppMethodBeat.i(173783);
        g.Wm(19);
        AppMethodBeat.o(173783);
    }

    public static int aqq() {
        AppMethodBeat.i(173784);
        int aqq = c.aqq();
        AppMethodBeat.o(173784);
        return aqq;
    }

    public static int aqp() {
        AppMethodBeat.i(173785);
        int aqp = c.aqp();
        AppMethodBeat.o(173785);
        return aqp;
    }

    public static int aqo() {
        AppMethodBeat.i(173786);
        int aqo = c.aqo();
        AppMethodBeat.o(173786);
        return aqo;
    }

    public static boolean dSx() {
        AppMethodBeat.i(173787);
        com.tencent.mm.kernel.g.aAi();
        if (!com.tencent.mm.kernel.g.aAf().azp()) {
            AppMethodBeat.o(173787);
            return false;
        }
        boolean z = com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, true);
        AppMethodBeat.o(173787);
        return z;
    }

    public static int azh(String str) {
        AppMethodBeat.i(173788);
        PInt pInt = new PInt();
        u.a(str, pInt, new PInt());
        int i2 = pInt.value;
        AppMethodBeat.o(173788);
        return i2;
    }

    public static boolean at(ArrayList<GalleryItem.MediaItem> arrayList) {
        int i2;
        AppMethodBeat.i(111744);
        if (arrayList == null || arrayList.isEmpty()) {
            AppMethodBeat.o(111744);
            return false;
        }
        Iterator<GalleryItem.MediaItem> it = arrayList.iterator();
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        while (true) {
            if (!it.hasNext()) {
                i2 = i3;
                break;
            }
            GalleryItem.MediaItem next = it.next();
            if (next.getType() == 1) {
                i2 = i3;
                z2 = true;
            } else if (next.getType() == 2) {
                i2 = i3 + 1;
                z = true;
            } else {
                i2 = i3;
            }
            if ((z && z2) || i2 > 1) {
                break;
            }
            i3 = i2;
        }
        if ((!z || !z2) && i2 <= 1) {
            AppMethodBeat.o(111744);
            return false;
        }
        AppMethodBeat.o(111744);
        return true;
    }

    public static String a(Context context, int i2, int i3, int i4, String str, ArrayList<GalleryItem.MediaItem> arrayList) {
        int i5;
        boolean z;
        AppMethodBeat.i(111745);
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_enable_vlog, false);
        boolean a3 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_enable_vlog, false);
        if (com.tencent.mm.kernel.g.aAf().azp()) {
            i5 = com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.USERINFO_TOP_STORY_VLOG_ENABLE_INT, 0);
        } else {
            i5 = 0;
        }
        boolean z2 = i5 == 1 || a2;
        if (i5 == 1 || a3) {
            z = true;
        } else {
            z = false;
        }
        switch (i2) {
            case 4:
                if (z2 && at(arrayList)) {
                    String str2 = context.getString(R.string.dmc) + "(" + i3 + FilePathGenerator.ANDROID_DIR_SEP + i4 + ")";
                    AppMethodBeat.o(111745);
                    return str2;
                } else if (i3 == 0 || i4 <= 1) {
                    String string = context.getString(R.string.dm_);
                    AppMethodBeat.o(111745);
                    return string;
                } else {
                    String str3 = context.getString(R.string.dm_) + "(" + i3 + FilePathGenerator.ANDROID_DIR_SEP + i4 + ")";
                    AppMethodBeat.o(111745);
                    return str3;
                }
            case 5:
            case 6:
            case 9:
            case 10:
            case 11:
            case 12:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            default:
                if (i3 == 0 || i4 <= 1) {
                    String string2 = context.getString(R.string.yq);
                    AppMethodBeat.o(111745);
                    return string2;
                }
                String string3 = context.getString(R.string.dm1, Integer.valueOf(i3), Integer.valueOf(i4));
                AppMethodBeat.o(111745);
                return string3;
            case 7:
            case 15:
            case 16:
                if (Util.isNullOrNil(str) || !str.equals("album_business_bubble_media_by_coordinate")) {
                    if (i3 == 0 || i4 <= 1) {
                        String string4 = context.getString(R.string.dm_);
                        AppMethodBeat.o(111745);
                        return string4;
                    }
                    String str4 = context.getString(R.string.dm_) + "(" + i3 + FilePathGenerator.ANDROID_DIR_SEP + i4 + ")";
                    AppMethodBeat.o(111745);
                    return str4;
                } else if (i3 == 0 || i4 <= 1) {
                    String string5 = context.getString(R.string.x5);
                    AppMethodBeat.o(111745);
                    return string5;
                } else {
                    String str5 = context.getString(R.string.x5) + "(" + i3 + FilePathGenerator.ANDROID_DIR_SEP + i4 + ")";
                    AppMethodBeat.o(111745);
                    return str5;
                }
            case 8:
            case 13:
                if (i3 == 0 || i4 <= 1) {
                    String string6 = context.getString(R.string.dm_);
                    AppMethodBeat.o(111745);
                    return string6;
                }
                String str6 = context.getString(R.string.dm_) + "(" + i3 + FilePathGenerator.ANDROID_DIR_SEP + i4 + ")";
                AppMethodBeat.o(111745);
                return str6;
            case 14:
            case 22:
                if (z && at(arrayList)) {
                    String str7 = context.getString(R.string.dmc) + "(" + i3 + FilePathGenerator.ANDROID_DIR_SEP + i4 + ")";
                    AppMethodBeat.o(111745);
                    return str7;
                } else if (i3 == 0 || i4 <= 1) {
                    String string7 = context.getString(R.string.dm_);
                    AppMethodBeat.o(111745);
                    return string7;
                } else {
                    String str8 = context.getString(R.string.dm_) + "(" + i3 + FilePathGenerator.ANDROID_DIR_SEP + i4 + ")";
                    AppMethodBeat.o(111745);
                    return str8;
                }
        }
    }

    public static boolean dSy() {
        AppMethodBeat.i(111746);
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_enable_vlog, false);
        if (com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.USERINFO_TOP_STORY_VLOG_ENABLE_INT, 0) == 1 || a2) {
            AppMethodBeat.o(111746);
            return true;
        }
        AppMethodBeat.o(111746);
        return false;
    }

    public static boolean dSz() {
        AppMethodBeat.i(111747);
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_enable_vlog, false);
        if (com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.USERINFO_TOP_STORY_VLOG_ENABLE_INT, 0) == 1 || a2) {
            AppMethodBeat.o(111747);
            return true;
        }
        AppMethodBeat.o(111747);
        return false;
    }

    public static boolean dSA() {
        AppMethodBeat.i(173789);
        boolean z = false;
        switch (e.dQK().mcq) {
            case 4:
                z = dSy();
                break;
            case 14:
            case 22:
                z = dSz();
                break;
        }
        AppMethodBeat.o(173789);
        return z;
    }

    public static String a(String str, s.e eVar, int i2) {
        String str2;
        AppMethodBeat.i(179480);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("getDecodeTaskKey filePath is null!!!");
            AppMethodBeat.o(179480);
            throw nullPointerException;
        }
        String concat = str.concat("#*$");
        if (eVar != null) {
            str2 = eVar.id;
        } else {
            str2 = "";
        }
        String concat2 = concat.concat(str2).concat(-1 == i2 ? "" : String.valueOf(i2));
        AppMethodBeat.o(179480);
        return concat2;
    }

    public static String azi(String str) {
        AppMethodBeat.i(179481);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("getFilePathFromKey key is null!!!");
            AppMethodBeat.o(179481);
            throw nullPointerException;
        }
        int indexOf = str.indexOf("#*$");
        if (indexOf <= 0) {
            NullPointerException nullPointerException2 = new NullPointerException("getFilePathFromKey end <= 0!!!");
            AppMethodBeat.o(179481);
            throw nullPointerException2;
        }
        String substring = str.substring(0, indexOf);
        AppMethodBeat.o(179481);
        return substring;
    }

    public static String a(String str, s.e eVar, long j2) {
        String str2;
        AppMethodBeat.i(179482);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("getCacheKey filePath is null!!!");
            AppMethodBeat.o(179482);
            throw nullPointerException;
        }
        String concat = str.concat("#*$");
        if (eVar != null) {
            str2 = eVar.id;
        } else {
            str2 = "";
        }
        String concat2 = concat.concat(str2).concat(String.valueOf(j2));
        AppMethodBeat.o(179482);
        return concat2;
    }

    static {
        AppMethodBeat.i(173791);
        for (String str : xsA) {
            xsF.add(Integer.valueOf(azj(str)));
        }
        for (String str2 : xsB) {
            xsG.add(Integer.valueOf(azj(str2)));
        }
        AppMethodBeat.o(173791);
    }

    public static int azj(String str) {
        AppMethodBeat.i(173790);
        int hashCode = (Environment.getExternalStorageDirectory().toString() + FilePathGenerator.ANDROID_DIR_SEP + str).toLowerCase().hashCode();
        AppMethodBeat.o(173790);
        return hashCode;
    }

    public static boolean dSB() {
        AppMethodBeat.i(257762);
        if (MMApplicationContext.getContext().getApplicationInfo().targetSdkVersion >= 29) {
            AppMethodBeat.o(257762);
            return true;
        }
        AppMethodBeat.o(257762);
        return false;
    }
}
