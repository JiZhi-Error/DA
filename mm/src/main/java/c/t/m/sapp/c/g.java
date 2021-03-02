package c.t.m.sapp.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g {
    public static void a(Context context) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(222966);
        b(context);
        List<String> c2 = c(context);
        List<a> e2 = q.e(q.a(context, "__SP_Tencent_Loc_COMP_INFO__sapp_", ""));
        if (c2 == null || c2.size() == 0 || e2.size() == 0) {
            z = false;
        } else {
            z = true;
            for (a aVar : e2) {
                Iterator<String> it = c2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    String[] split = it.next().split(",");
                    if (split.length == 3 && aVar.f34c.equals(split[0]) && String.valueOf(aVar.f35d).equals(split[1]) && aVar.f36e.equals(split[2])) {
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    z = false;
                }
            }
        }
        if (z) {
            byte[] bArr = new byte[2048];
            String str = context.getFilesDir().getAbsolutePath() + File.separator + q.f94b;
            String str2 = context.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation_sapp/lastComp";
            ArrayList<a> arrayList = new ArrayList();
            boolean z3 = false;
            for (a aVar2 : e2) {
                File file = new File(str2, aVar2.f34c);
                if (file.exists()) {
                    if (aVar2.f36e.equals(q.a(file))) {
                    }
                }
                if (q.b(context, str + File.separator + aVar2.f34c, str2, "tmp__sapp" + aVar2.f34c, (long) aVar2.f35d, bArr)) {
                    arrayList.add(aVar2);
                } else {
                    File file2 = new File(str2 + File.separator + "tmp__sapp" + aVar2.f34c);
                    if (!file2.exists() || !file2.isFile()) {
                        z3 = true;
                    } else {
                        file2.delete();
                        z3 = true;
                    }
                }
            }
            if (z3) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    File file3 = new File(str2 + File.separator + "tmp__sapp" + ((a) it2.next()).f34c);
                    if (file3.exists() && file3.isFile()) {
                        file3.delete();
                    }
                }
            } else if (e2.size() == arrayList.size()) {
                for (a aVar3 : arrayList) {
                    File file4 = new File(str2, aVar3.f34c);
                    if (file4.exists() && file4.isFile()) {
                        file4.delete();
                    }
                    new File(str2, "tmp__sapp" + aVar3.f34c).renameTo(file4);
                }
                q.b(context, "__SP_LAST_TencentLoc_COMP_INFO__sapp_", q.a(arrayList));
                q.b(context, "__SP_LAST_TencentLoc_COMP_SDK_VER__sapp_", h.f67a);
            }
        }
        AppMethodBeat.o(222966);
    }

    public static void b(Context context) {
        AppMethodBeat.i(222967);
        File file = new File(context.getFilesDir(), "TencentLocation_sapp/lastComp");
        if (!file.exists()) {
            file.mkdirs();
        }
        AppMethodBeat.o(222967);
    }

    public static List<String> c(Context context) {
        File[] listFiles;
        AppMethodBeat.i(222968);
        File file = new File(context.getFilesDir(), q.f94b);
        ArrayList arrayList = null;
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            arrayList = new ArrayList();
            for (File file2 : listFiles) {
                arrayList.add(file2.getName() + "," + file2.length() + "," + q.a(file2));
            }
        }
        AppMethodBeat.o(222968);
        return arrayList;
    }
}
