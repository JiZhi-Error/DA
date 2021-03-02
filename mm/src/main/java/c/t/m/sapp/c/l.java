package c.t.m.sapp.c;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class l {
    public static boolean a(Context context, int i2) {
        AppMethodBeat.i(222992);
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == i2) {
                    AppMethodBeat.o(222992);
                    return true;
                }
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(222992);
        return false;
    }

    public static int b(Context context) {
        AppMethodBeat.i(222990);
        List<a> e2 = q.e(q.a(context, "__SP_Tencent_Loc_COMP_INFO__sapp_", ""));
        int e3 = e(context);
        if (e3 <= 3) {
            q.b(context, "__pro_dex_load_info___sapp", BuildConfig.KINDA_DEFAULT);
        }
        if (e2 == null || e2.equals("")) {
            AppMethodBeat.o(222990);
            return 0;
        }
        String a2 = q.a(context, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", "");
        if (a2 == null || a2.equals("")) {
            AppMethodBeat.o(222990);
            return 1;
        } else if (a(e2, q.e(a2))) {
            if (e3 <= 3) {
                AppMethodBeat.o(222990);
                return 2;
            }
            AppMethodBeat.o(222990);
            return 3;
        } else if (e3 <= 3) {
            AppMethodBeat.o(222990);
            return 6;
        } else {
            AppMethodBeat.o(222990);
            return 5;
        }
    }

    public static boolean c(Context context) {
        AppMethodBeat.i(222995);
        if (!q.a(context, "__SP_UPDATE_TencentLoc_COMP_SDK_VER__sapp_", "").equals(h.f67a)) {
            AppMethodBeat.o(222995);
            return false;
        }
        String a2 = q.a(context, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", "");
        if (a2 == null || a2.equals("")) {
            AppMethodBeat.o(222995);
            return false;
        }
        List<a> e2 = q.e(a2);
        if (e2 == null || e2.isEmpty()) {
            AppMethodBeat.o(222995);
            return false;
        }
        String a3 = q.a(context, "__bad_dex_info___sapp", "preference_default_sapp");
        List<a> e3 = q.e(a3);
        if (a3.equals("preference_default_sapp") || e3.isEmpty() || !a(e2, e3)) {
            byte[] bArr = new byte[2048];
            String str = context.getFilesDir().getAbsolutePath() + File.separator + q.f94b;
            String str2 = context.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation_sapp/UpCp";
            ArrayList<a> arrayList = new ArrayList();
            boolean z = true;
            for (a aVar : e2) {
                if (!q.b(context, str2 + File.separator + aVar.f34c, str, "tmp_backup__sapp" + aVar.f34c, (long) aVar.f35d, bArr)) {
                    File file = new File(str + File.separator + "tmp_backup__sapp" + aVar.f34c);
                    if (!file.exists() || !file.isFile()) {
                        z = false;
                    } else {
                        file.delete();
                        z = false;
                    }
                } else {
                    arrayList.add(aVar);
                }
            }
            if (!z) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    File file2 = new File(str + File.separator + "tmp_backup__sapp" + ((a) it.next()).f34c);
                    if (file2.exists() && file2.isFile()) {
                        file2.delete();
                    }
                }
                arrayList.clear();
                AppMethodBeat.o(222995);
                return false;
            } else if (e2.size() == arrayList.size()) {
                for (a aVar2 : arrayList) {
                    File file3 = new File(str, aVar2.f34c);
                    if (file3.exists() && file3.isFile()) {
                        file3.delete();
                    }
                    new File(str, "tmp_backup__sapp" + aVar2.f34c).renameTo(file3);
                }
                String a4 = q.a(arrayList);
                q.b(context, "__SP_Tencent_Loc_COMP_INFO__sapp_", a4);
                e.a(context).a("DBC", a4);
                AppMethodBeat.o(222995);
                return true;
            } else {
                AppMethodBeat.o(222995);
                return false;
            }
        } else {
            AppMethodBeat.o(222995);
            return false;
        }
    }

    public static boolean d(Context context) {
        boolean z;
        AppMethodBeat.i(222996);
        String d2 = q.d(context);
        if (!q.a(d2)) {
            j.a("clear private dir failed");
        }
        String b2 = q.b(context, "TencentLocationComp_sapp" + File.separator + "comp_list");
        j.a("base comp info:" + b2);
        List<a> e2 = q.e(b2);
        byte[] bArr = new byte[2048];
        ArrayList arrayList = new ArrayList();
        Iterator<a> it = e2.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            a next = it.next();
            next.f34c += ShareConstants.DEX_SUFFIX;
            String str = "tmp_asset__sapp" + next.f34c;
            if (!q.a(context, "TencentLocationComp_sapp" + File.separator + next.f34c, d2, str, (long) next.f35d, bArr)) {
                File file = new File(d2 + File.separator + str);
                if (!file.exists() || !file.isFile()) {
                    z = false;
                } else {
                    file.delete();
                    z = false;
                }
            } else {
                arrayList.add(next);
            }
        }
        if (!z) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                File file2 = new File(d2 + File.separator + "tmp_asset__sapp" + ((a) it2.next()).f34c);
                if (file2.exists() && file2.isFile()) {
                    file2.delete();
                }
            }
            AppMethodBeat.o(222996);
            return false;
        } else if (arrayList.size() == e2.size()) {
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                a aVar = (a) it3.next();
                File file3 = new File(d2, aVar.f34c);
                if (file3.exists() && file3.isFile()) {
                    file3.delete();
                }
                new File(d2, "tmp_asset__sapp" + aVar.f34c).renameTo(file3);
            }
            q.b(context, "__SP_Tencent_Loc_COMP_INFO__sapp_", q.a(e2));
            AppMethodBeat.o(222996);
            return true;
        } else {
            AppMethodBeat.o(222996);
            return false;
        }
    }

    public static int e(Context context) {
        boolean z = true;
        AppMethodBeat.i(222991);
        String a2 = q.a(context, "__pro_dex_load_info___sapp", BuildConfig.KINDA_DEFAULT);
        if (a2.equals(BuildConfig.KINDA_DEFAULT)) {
            AppMethodBeat.o(222991);
            return 1;
        }
        try {
            String[] split = a2.split("#");
            if (split != null && split.length > 0) {
                for (String str : split) {
                    String[] split2 = str.split("&");
                    if (split2 != null && split2.length == 2 && a(context, Integer.parseInt(split2[0]))) {
                        z = false;
                    }
                }
            }
            if (z) {
                AppMethodBeat.o(222991);
                return 3;
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(222991);
        return 4;
    }

    public static void f(Context context) {
        AppMethodBeat.i(222993);
        String e2 = q.e(context);
        if (e2 == null) {
            AppMethodBeat.o(222993);
            return;
        }
        int g2 = q.g();
        String a2 = q.a(context, "__pro_dex_load_info___sapp", BuildConfig.KINDA_DEFAULT);
        if (a2.equals(BuildConfig.KINDA_DEFAULT)) {
            q.b(context, "__pro_dex_load_info___sapp", g2 + "&" + e2 + "#");
            AppMethodBeat.o(222993);
            return;
        }
        try {
            String[] split = a2.split("#");
            if (split != null && split.length > 0) {
                boolean z = false;
                for (int i2 = 0; i2 < split.length; i2++) {
                    String[] split2 = split[i2].split("&");
                    if (split2 != null && split2.length == 2) {
                        String str = split2[1];
                        Integer.parseInt(split2[0]);
                        if (e2.equals(str)) {
                            split[i2] = g2 + "&" + e2;
                            z = true;
                        }
                    }
                }
                String str2 = "";
                for (int i3 = 0; i3 < split.length; i3++) {
                    str2 = str2 + split[i3] + "#";
                }
                q.b(context, "__pro_dex_load_info___sapp", !z ? str2 + g2 + "&" + e2 + "#" : str2);
                AppMethodBeat.o(222993);
                return;
            }
        } catch (Exception e3) {
        }
        AppMethodBeat.o(222993);
    }

    public static void a(Context context) {
        AppMethodBeat.i(222994);
        try {
            File file = new File(context.getFilesDir(), q.f95c);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!file.canRead() || !file.canWrite() || !file.canExecute()) {
                boolean readable = file.setReadable(true);
                e.b().a("DMK", "ods:" + file.setWritable(true) + "_" + readable + "_" + file.setExecutable(true));
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        if (!file2.canRead() || !file2.canWrite() || !file2.canExecute()) {
                            e.b().a("DMK", "ofs:" + file2.setWritable(true) + "_" + file2.setReadable(true) + "_" + file2.setExecutable(true));
                        } else {
                            e.b().a("DMK", "ofs:ok");
                        }
                    }
                }
                AppMethodBeat.o(222994);
                return;
            }
            e.b().a("DMK", "ods:ok");
            AppMethodBeat.o(222994);
        } catch (Throwable th) {
            e.b().a("DMK", "exp:" + th.toString());
        }
    }

    public static boolean a(List<a> list, List<a> list2) {
        boolean z;
        AppMethodBeat.i(222997);
        boolean z2 = true;
        for (a aVar : list) {
            if (!aVar.f34c.contains(ShareConstants.DEX_SUFFIX)) {
                aVar.f34c += ShareConstants.DEX_SUFFIX;
            }
            Iterator<a> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                a next = it.next();
                if (!next.f34c.contains(ShareConstants.DEX_SUFFIX)) {
                    next.f34c += ShareConstants.DEX_SUFFIX;
                }
                if (aVar.f34c.equals(next.f34c) && aVar.f35d == next.f35d && aVar.f36e.equals(next.f36e)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                z2 = false;
            }
        }
        AppMethodBeat.o(222997);
        return z2;
    }
}
