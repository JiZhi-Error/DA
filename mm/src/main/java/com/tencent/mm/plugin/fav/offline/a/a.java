package com.tencent.mm.plugin.fav.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.fav.offline.PluginFavOffline;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public static boolean cVs() {
        AppMethodBeat.i(73538);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_fav_web_cache_open, 0);
        Log.d("MicroMsg.offline.FavOfflineHelp", "isOpenFavOffline() open:%s", Integer.valueOf(a2));
        if (a2 == 1) {
            AppMethodBeat.o(73538);
            return true;
        }
        AppMethodBeat.o(73538);
        return false;
    }

    private static long cVt() {
        AppMethodBeat.i(73539);
        long a2 = ((b) g.af(b.class)).a(b.a.clicfg_fav_web_cache_max_size, 20971520L);
        Log.d("MicroMsg.offline.FavOfflineHelp", "getFavOfflineMaxSize() maxSize:%s", Long.valueOf(a2));
        AppMethodBeat.o(73539);
        return a2;
    }

    private static long cVu() {
        AppMethodBeat.i(73540);
        long a2 = (long) ((b) g.af(b.class)).a(b.a.clicfg_fav_web_cache_max_total_size, 1073741824);
        AppMethodBeat.o(73540);
        return a2;
    }

    private static long cVv() {
        AppMethodBeat.i(73541);
        long a2 = g.aAh().azQ().a(ar.a.USERINFO_FAV_OFFLINE_ALL_SIZE_LONG_SYNC, 0);
        AppMethodBeat.o(73541);
        return a2;
    }

    private static void O(long j2, long j3) {
        AppMethodBeat.i(73542);
        g.aAh().azQ().set(ar.a.USERINFO_FAV_OFFLINE_ALL_SIZE_LONG_SYNC, Long.valueOf(cVv() + (j3 - j2)));
        AppMethodBeat.o(73542);
    }

    public static void Un() {
        int i2;
        AppMethodBeat.i(73543);
        List<com.tencent.mm.plugin.fav.offline.b.a> cVx = ((PluginFavOffline) g.ah(PluginFavOffline.class)).getFavOfflineStorage().cVx();
        int i3 = 0;
        for (com.tencent.mm.plugin.fav.offline.b.a aVar : cVx) {
            if (((PluginFavOffline) g.ah(PluginFavOffline.class)).getFavOfflineStorage().delete(aVar.systemRowid)) {
                i2 = i3 + 1;
            } else {
                i2 = i3;
            }
            i3 = i2;
        }
        s.dy(PluginFavOffline.getFavOfflinePath(), true);
        Log.i("MicroMsg.offline.FavOfflineHelp", "cleanAllCache maxSize:%s allSize:%s allNum:%s deleteResult:%s", Long.valueOf(cVu()), Long.valueOf(cVv()), Integer.valueOf(cVx.size()), Integer.valueOf(i3));
        g.aAh().azQ().set(ar.a.USERINFO_FAV_OFFLINE_ALL_SIZE_LONG_SYNC, (Object) 0L);
        AppMethodBeat.o(73543);
    }

    public static boolean af(String str, String str2, String str3) {
        boolean z;
        AppMethodBeat.i(73544);
        long asf = asf(str2);
        boolean deleteFile = s.deleteFile(str2);
        if (deleteFile) {
            O(asf, 0);
        }
        if (!Util.isNullOrNil(str3)) {
            long asf2 = asf(str3);
            z = s.dy(str3, true);
            if (z) {
                O(asf2, 0);
            }
        } else {
            z = true;
        }
        if (!deleteFile || !z) {
            Log.i("MicroMsg.offline.FavOfflineHelp", "deleteFavOffline deleteHtml:%s deleteImg:%s", Boolean.valueOf(deleteFile), Boolean.valueOf(z));
            AppMethodBeat.o(73544);
            return false;
        }
        boolean asj = ((PluginFavOffline) g.ah(PluginFavOffline.class)).getFavOfflineStorage().asj(str);
        AppMethodBeat.o(73544);
        return asj;
    }

    public static boolean a(com.tencent.mm.plugin.fav.offline.b.a aVar) {
        AppMethodBeat.i(73545);
        if (aVar == null) {
            Log.i("MicroMsg.offline.FavOfflineHelp", "deleteFavOfflineContent favOffline is null!");
            AppMethodBeat.o(73545);
            return false;
        }
        long asf = asf(aVar.field_path);
        boolean deleteFile = s.deleteFile(aVar.field_path);
        if (deleteFile) {
            O(asf, 0);
        }
        Log.i("MicroMsg.offline.FavOfflineHelp", "deleteFavOfflineContent deleteHtml:%s", Boolean.valueOf(deleteFile));
        aVar.field_size = 0;
        aVar.field_status = 0;
        boolean c2 = ((PluginFavOffline) g.ah(PluginFavOffline.class)).getFavOfflineStorage().c(aVar);
        AppMethodBeat.o(73545);
        return c2;
    }

    public static boolean d(String str, String str2, String str3, int i2) {
        long j2;
        AppMethodBeat.i(73546);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.offline.FavOfflineHelp", "updateFavOffline: url is null!");
            AppMethodBeat.o(73546);
            return false;
        }
        com.tencent.mm.plugin.fav.offline.b.a ask = ((PluginFavOffline) g.ah(PluginFavOffline.class)).getFavOfflineStorage().ask(str);
        if (ask == null) {
            Log.i("MicroMsg.offline.FavOfflineHelp", "updateFavOffline: favOffline(%s) is null!", str);
            AppMethodBeat.o(73546);
            return false;
        }
        long length = new o(str2).length();
        if (!Util.isNullOrNil(str3)) {
            j2 = length + asf(str3);
        } else {
            j2 = length;
        }
        if (j2 > cVt()) {
            Log.i("MicroMsg.offline.FavOfflineHelp", "url(%s) bytelength(%s) exceed %s", str, Long.valueOf(j2), Long.valueOf(cVt()));
            if (i2 == 0) {
                a(ask, (int) j2, 0);
            }
            boolean af = af(str, str2, str3);
            AppMethodBeat.o(73546);
            return af;
        }
        int i3 = ask.field_status;
        O(ask.field_size, j2);
        ask.field_path = str2;
        ask.field_size = j2;
        ask.field_updateTime = cl.aWy();
        if (!Util.isNullOrNil(str3) && Util.isNullOrNil(ask.field_imgDirPath)) {
            ask.field_imgDirPath = str3;
        }
        ask.field_status = i2;
        boolean c2 = ((PluginFavOffline) g.ah(PluginFavOffline.class)).getFavOfflineStorage().c(ask);
        if (i3 != 1 && i2 == 2) {
            a(ask, 1);
        }
        long cVv = cVv();
        if (cVv > cVu()) {
            List<com.tencent.mm.plugin.fav.offline.b.a> cVx = ((PluginFavOffline) g.ah(PluginFavOffline.class)).getFavOfflineStorage().cVx();
            ArrayList<com.tencent.mm.plugin.fav.offline.b.a> arrayList = new ArrayList();
            long j3 = 0;
            for (com.tencent.mm.plugin.fav.offline.b.a aVar : cVx) {
                if (j3 >= cVu() / 2) {
                    break;
                }
                j3 += aVar.field_size;
                arrayList.add(aVar);
            }
            int i4 = 0;
            for (com.tencent.mm.plugin.fav.offline.b.a aVar2 : arrayList) {
                boolean deleteFile = s.deleteFile(aVar2.field_path);
                long asf = asf(aVar2.field_path);
                boolean dy = s.dy(aVar2.field_imgDirPath, true);
                long asf2 = asf(aVar2.field_imgDirPath);
                if (!deleteFile || !dy) {
                    if (deleteFile) {
                        O(asf, 0);
                    }
                    if (dy) {
                        O(asf2, 0);
                    }
                } else {
                    O(asf + asf2, 0);
                    if (((PluginFavOffline) g.ah(PluginFavOffline.class)).getFavOfflineStorage().delete(aVar2.systemRowid)) {
                        i4++;
                    }
                }
            }
            Log.i("MicroMsg.offline.FavOfflineHelp", "cleanHalfCache maxSize:%s allSize:%s allNum:%s deleteSize:%s deleteNum:%s deleteResult:%s", Long.valueOf(cVu()), Long.valueOf(cVv), Integer.valueOf(cVx.size()), Long.valueOf(j3), Integer.valueOf(arrayList.size()), Integer.valueOf(i4));
        }
        Log.i("MicroMsg.offline.FavOfflineHelp", "allFavOffline size:%s, url(%s) status(%s) size:%s", Long.valueOf(cVv()), str, Integer.valueOf(i2), Long.valueOf(j2));
        AppMethodBeat.o(73546);
        return c2;
    }

    private static long asf(String str) {
        long j2;
        long j3 = 0;
        AppMethodBeat.i(73547);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(73547);
            return 0;
        }
        o oVar = new o(str);
        if (oVar.isFile()) {
            long length = oVar.length();
            AppMethodBeat.o(73547);
            return length;
        }
        Iterable<e> dC = s.dC(str, true);
        if (dC == null) {
            AppMethodBeat.o(73547);
            return 0;
        }
        for (e eVar : dC) {
            if (eVar != null) {
                j2 = eVar.size + j3;
            } else {
                j2 = j3;
            }
            j3 = j2;
        }
        AppMethodBeat.o(73547);
        return j3;
    }

    public static int asg(String str) {
        AppMethodBeat.i(73548);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.offline.FavOfflineHelp", "updateOfflineTaskFailNum: url is null!");
            AppMethodBeat.o(73548);
            return -1;
        }
        com.tencent.mm.plugin.fav.offline.b.a ask = ((PluginFavOffline) g.ah(PluginFavOffline.class)).getFavOfflineStorage().ask(str);
        if (ask == null) {
            Log.i("MicroMsg.offline.FavOfflineHelp", "updateOfflineTaskFailNum: favOffline(%s) is null!", str);
            AppMethodBeat.o(73548);
            return -1;
        }
        ask.field_failNum++;
        Log.i("MicroMsg.offline.FavOfflineHelp", "updateOfflineTaskFailNum result:%s", Boolean.valueOf(((PluginFavOffline) g.ah(PluginFavOffline.class)).getFavOfflineStorage().c(ask)));
        if (ask.field_failNum >= 5) {
            a(ask, 0);
        }
        int i2 = ask.field_failNum;
        AppMethodBeat.o(73548);
        return i2;
    }

    private static void a(com.tencent.mm.plugin.fav.offline.b.a aVar, int i2) {
        AppMethodBeat.i(73549);
        if (a(aVar, 0, i2)) {
            aVar.field_isReport = 1;
            ((PluginFavOffline) g.ah(PluginFavOffline.class)).getFavOfflineStorage().c(aVar);
        }
        AppMethodBeat.o(73549);
    }

    private static boolean a(com.tencent.mm.plugin.fav.offline.b.a aVar, int i2, int i3) {
        AppMethodBeat.i(73550);
        if (aVar == null) {
            Log.i("MicroMsg.offline.FavOfflineHelp", "report: favOffline is null!");
            AppMethodBeat.o(73550);
            return false;
        } else if (aVar.field_isReport == 1) {
            AppMethodBeat.o(73550);
            return false;
        } else {
            ba baVar = new ba();
            baVar.erm = aVar.systemRowid;
            if (i2 == 0) {
                long length = new o(aVar.field_path).length();
                if (!Util.isNullOrNil(aVar.field_imgDirPath)) {
                    length += asf(aVar.field_imgDirPath);
                }
                baVar.ern = length;
            } else {
                baVar.ern = (long) i2;
            }
            baVar.ero = (long) ((PluginFavOffline) g.ah(PluginFavOffline.class)).getFavOfflineStorage().cVx().size();
            baVar.erp = cVv();
            baVar.erq = (long) i3;
            baVar.bfK();
            AppMethodBeat.o(73550);
            return true;
        }
    }
}
