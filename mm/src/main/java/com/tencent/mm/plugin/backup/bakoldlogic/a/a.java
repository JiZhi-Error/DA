package com.tencent.mm.plugin.backup.bakoldlogic.a;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.dqj;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a {
    private static List<String> gzY = null;

    public static List<String> cfd() {
        AppMethodBeat.i(21795);
        if (gzY != null) {
            List<String> list = gzY;
            AppMethodBeat.o(21795);
            return list;
        }
        gzY = new LinkedList();
        for (String str : ab.iCO) {
            gzY.add(str);
        }
        gzY.add("weixin");
        gzY.add("weibo");
        gzY.add("qqmail");
        gzY.add("fmessage");
        gzY.add("tmessage");
        gzY.add("qmessage");
        gzY.add("qqsync");
        gzY.add("floatbottle");
        gzY.add("lbsapp");
        gzY.add("shakeapp");
        gzY.add("medianote");
        gzY.add("qqfriend");
        gzY.add("readerapp");
        gzY.add("newsapp");
        gzY.add("blogapp");
        gzY.add("facebookapp");
        gzY.add("masssendapp");
        gzY.add("meishiapp");
        gzY.add("feedsapp");
        gzY.add("voipapp");
        gzY.add("officialaccounts");
        gzY.add("helper_entry");
        gzY.add("pc_share");
        gzY.add("cardpackage");
        gzY.add("voicevoipapp");
        gzY.add("voiceinputapp");
        gzY.add("linkedinplugin");
        gzY.add("appbrandcustomerservicemsg");
        List<String> list2 = gzY;
        AppMethodBeat.o(21795);
        return list2;
    }

    public static String agK(String str) {
        AppMethodBeat.i(21796);
        if (str == null) {
            AppMethodBeat.o(21796);
            return "";
        }
        String messageDigest = g.getMessageDigest(str.getBytes());
        String str2 = "";
        String str3 = "";
        if (messageDigest.length() > 0) {
            str2 = messageDigest.charAt(0) + FilePathGenerator.ANDROID_DIR_SEP;
        }
        if (messageDigest.length() >= 2) {
            str3 = messageDigest.charAt(1) + FilePathGenerator.ANDROID_DIR_SEP;
        }
        String str4 = str2 + str3;
        AppMethodBeat.o(21796);
        return str4;
    }

    public static String cgW() {
        AppMethodBeat.i(21797);
        StringBuilder sb = new StringBuilder();
        bg.aVF();
        String sb2 = sb.append(c.getAccPath()).append("backup/").toString();
        AppMethodBeat.o(21797);
        return sb2;
    }

    public static void agL(String str) {
        AppMethodBeat.i(21798);
        s.boN(str);
        s.boN(str + "backupItem/");
        s.boN(str + "backupMeida/");
        AppMethodBeat.o(21798);
    }

    public static boolean a(long j2, PLong pLong, PLong pLong2, String str) {
        AppMethodBeat.i(21799);
        StatFs statFs = new StatFs(b.aKJ());
        pLong.value = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        o X = o.X(com.tencent.mm.compatible.util.g.getDataDirectory());
        StatFs statFs2 = new StatFs(aa.z(X.mUri));
        long blockCount = (long) statFs2.getBlockCount();
        long availableBlocks = (long) statFs2.getAvailableBlocks();
        pLong2.value = ((long) statFs2.getBlockSize()) * ((long) statFs2.getAvailableBlocks());
        Log.i("MicroMsg.BakUtil", "checkDataFull, SDAvailSize:%d, DataAvailSize%d, dbSize:%d", Long.valueOf(pLong.value), Long.valueOf(pLong2.value), Long.valueOf(j2));
        if (blockCount <= 0) {
            AppMethodBeat.o(21799);
            return false;
        } else if (blockCount - availableBlocks < 0) {
            AppMethodBeat.o(21799);
            return false;
        } else {
            if (pLong.value == pLong2.value || str.startsWith(aa.z(X.mUri))) {
                pLong.value = 0;
            }
            if (j2 > pLong2.value) {
                AppMethodBeat.o(21799);
                return false;
            }
            AppMethodBeat.o(21799);
            return true;
        }
    }

    public static boolean agB(String str) {
        AppMethodBeat.i(21800);
        if (str == null) {
            AppMethodBeat.o(21800);
            return false;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        if (XmlParser.parseXml(str, "msg", null) != null) {
            AppMethodBeat.o(21800);
            return true;
        }
        AppMethodBeat.o(21800);
        return false;
    }

    public static String agM(String str) {
        AppMethodBeat.i(21801);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(21801);
            return "";
        }
        String str2 = cgW() + "backupMeida/" + agK(str) + str;
        AppMethodBeat.o(21801);
        return str2;
    }

    public static int c(is isVar, int i2) {
        AppMethodBeat.i(21802);
        if (isVar.KMU != i2) {
            if (!(isVar.KMR == null || isVar.KMQ == null)) {
                Iterator<dqj> it = isVar.KMR.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    if (it.next().MTq == i2) {
                        int boW = (int) s.boW(agM(isVar.KMQ.get(i3).MTo));
                        AppMethodBeat.o(21802);
                        return boW;
                    }
                    i3++;
                }
            }
            AppMethodBeat.o(21802);
            return 0;
        } else if (isVar.KMS == null) {
            AppMethodBeat.o(21802);
            return 0;
        } else {
            int length = isVar.KMS.getBuffer().zy.length;
            AppMethodBeat.o(21802);
            return length;
        }
    }

    public static String a(is isVar, int i2, String str) {
        AppMethodBeat.i(21803);
        if (isVar.KMU != i2 || isVar.KMS == null) {
            int i3 = 0;
            if (!(isVar.KMR == null || isVar.KMQ == null)) {
                Iterator<dqj> it = isVar.KMR.iterator();
                while (it.hasNext()) {
                    if (it.next().MTq == i2) {
                        String str2 = isVar.KMQ.get(i3).MTo;
                        if (!Util.isNullOrNil(str) && !str2.endsWith(str)) {
                            i3 = i3 + 1 + 1;
                        } else if (s.YS(agM(str2))) {
                            AppMethodBeat.o(21803);
                            return str2;
                        } else {
                            AppMethodBeat.o(21803);
                            return null;
                        }
                    } else {
                        i3++;
                    }
                }
            }
            AppMethodBeat.o(21803);
            return null;
        }
        String messageDigest = g.getMessageDigest(isVar.KMS.getBuffer().zy);
        AppMethodBeat.o(21803);
        return messageDigest;
    }

    public static String a(is isVar, int i2) {
        AppMethodBeat.i(21804);
        String a2 = a(isVar, i2, null);
        AppMethodBeat.o(21804);
        return a2;
    }

    public static byte[] b(is isVar, int i2) {
        AppMethodBeat.i(21805);
        if (isVar.KMU != i2 || isVar.KMS == null) {
            if (!(isVar.KMR == null || isVar.KMQ == null)) {
                Iterator<dqj> it = isVar.KMR.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    if (it.next().MTq == i2) {
                        String agM = agM(isVar.KMQ.get(i3).MTo);
                        int boW = (int) s.boW(agM);
                        if (boW == 0 || boW > 1048576) {
                            Log.e("MicroMsg.BakUtil", "thumb not exist or  too big!");
                            AppMethodBeat.o(21805);
                            return null;
                        }
                        byte[] aW = s.aW(agM, 0, -1);
                        AppMethodBeat.o(21805);
                        return aW;
                    }
                    i3++;
                }
            }
            AppMethodBeat.o(21805);
            return null;
        }
        byte[] bArr = isVar.KMS.getBuffer().zy;
        AppMethodBeat.o(21805);
        return bArr;
    }

    public static boolean b(is isVar, int i2, String str) {
        AppMethodBeat.i(21806);
        if (isVar.KMU != i2 || isVar.KMS == null) {
            String a2 = a(isVar, i2, null);
            if (!Util.isNullOrNil(a2)) {
                s.nw(agM(a2), str);
                AppMethodBeat.o(21806);
                return true;
            }
            AppMethodBeat.o(21806);
            return false;
        }
        byte[] bArr = isVar.KMS.getBuffer().zy;
        if (bArr.length <= 0) {
            AppMethodBeat.o(21806);
            return false;
        }
        s.f(str, bArr, bArr.length);
        AppMethodBeat.o(21806);
        return true;
    }

    public static int cv(String str, int i2) {
        AppMethodBeat.i(21807);
        int i3 = Util.getInt(str, i2);
        AppMethodBeat.o(21807);
        return i3;
    }

    public static boolean d(is isVar, int i2) {
        AppMethodBeat.i(21808);
        if (isVar.KMU != i2 || isVar.KMS == null) {
            Iterator<dqj> it = isVar.KMR.iterator();
            while (it.hasNext()) {
                if (it.next().MTq == i2) {
                    AppMethodBeat.o(21808);
                    return true;
                }
            }
            AppMethodBeat.o(21808);
            return false;
        }
        AppMethodBeat.o(21808);
        return true;
    }
}
