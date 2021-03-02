package c.t.m.sapp.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static String f67a = "6.7.6";

    /* renamed from: b  reason: collision with root package name */
    public static h f68b;

    /* renamed from: c  reason: collision with root package name */
    public Context f69c;

    /* renamed from: d  reason: collision with root package name */
    public List<a> f70d = new ArrayList();

    public h(Context context) {
        AppMethodBeat.i(222969);
        this.f69c = context;
        AppMethodBeat.o(222969);
    }

    public static h a(Context context) {
        AppMethodBeat.i(222970);
        if (f68b == null) {
            synchronized (h.class) {
                try {
                    if (f68b == null) {
                        f68b = new h(context);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(222970);
                    throw th;
                }
            }
        }
        h hVar = f68b;
        AppMethodBeat.o(222970);
        return hVar;
    }

    public DexClassLoader b() {
        AppMethodBeat.i(222971);
        a();
        if (l.b(this.f69c) == 6) {
            l.c(this.f69c);
        }
        if (!a(true, a("__SP_Tencent_Loc_COMP_INFO__sapp_"), q.f94b)) {
            d();
        }
        DexClassLoader a2 = b.a(this.f69c).a(a("__SP_Tencent_Loc_COMP_INFO__sapp_"), q.f94b);
        AppMethodBeat.o(222971);
        return a2;
    }

    public final void c() {
        AppMethodBeat.i(222976);
        File file = new File(this.f69c.getFilesDir(), q.f94b);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(this.f69c.getFilesDir(), q.f95c);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        l.a(this.f69c);
        AppMethodBeat.o(222976);
    }

    public void d() {
        AppMethodBeat.i(222974);
        e.a(this.f69c).a("DCR", "goback");
        if (!l.d(this.f69c)) {
            e.a(this.f69c).a("DCR", "copy from asset failed");
        }
        AppMethodBeat.o(222974);
    }

    public boolean a() {
        AppMethodBeat.i(222972);
        c();
        String str = f67a;
        String a2 = q.a(this.f69c, "__Tencent_Cover_SDK_Version__sapp_", "");
        j.a("cv:" + a2 + "_" + str);
        e.a(this.f69c).a("DCV", a2 + "_" + str);
        if (!str.equals(a2)) {
            System.currentTimeMillis();
            if (!l.d(this.f69c)) {
                j.a("copy to private dir failed");
                AppMethodBeat.o(222972);
                return false;
            }
            q.b(this.f69c, "__Tencent_Cover_SDK_Version__sapp_", str);
            q.b(this.f69c, "__pro_dex_load_info___sapp", BuildConfig.KINDA_DEFAULT);
            q.b(this.f69c, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", "");
            q.a(this.f69c.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation_sapp/UpCp");
            AppMethodBeat.o(222972);
            return true;
        }
        AppMethodBeat.o(222972);
        return false;
    }

    public boolean a(boolean z, List<a> list, String str) {
        boolean z2;
        boolean z3;
        AppMethodBeat.i(222973);
        List<String> a2 = q.a(this.f69c, new File(this.f69c.getFilesDir(), str));
        if (a2 == null || a2.size() == 0 || list.size() == 0) {
            j.a("private dir files is empty");
            e.a(this.f69c).a("DLC", "localComp file error");
            z2 = false;
        } else {
            String a3 = q.a(this.f69c, "__bad_dex_info___sapp", "preference_default_sapp");
            List<a> e2 = q.e(a3);
            if (a3.equals("preference_default_sapp") || e2.isEmpty() || !l.a(list, e2)) {
                z2 = true;
                for (a aVar : list) {
                    Iterator<String> it = a2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z3 = false;
                            break;
                        }
                        String[] split = it.next().split(",");
                        if (split.length == 3 && aVar.f34c.equals(split[0]) && String.valueOf(aVar.f35d).equals(split[1]) && aVar.f36e.equals(split[2])) {
                            z3 = true;
                            break;
                        }
                    }
                    if (!z3) {
                        z2 = false;
                    }
                }
            } else {
                AppMethodBeat.o(222973);
                return false;
            }
        }
        AppMethodBeat.o(222973);
        return z2;
    }

    public List<a> a(String str) {
        AppMethodBeat.i(222975);
        List<a> e2 = q.e(q.a(this.f69c, str, ""));
        if (e2.size() == 0) {
            e.a(this.f69c).a("DLC", "localComp parse error");
        }
        AppMethodBeat.o(222975);
        return e2;
    }
}
