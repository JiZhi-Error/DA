package c.t.m.sapp.c;

import android.annotation.TargetApi;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f38a;

    /* renamed from: b  reason: collision with root package name */
    public Context f39b;

    /* renamed from: c  reason: collision with root package name */
    public List<a> f40c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f41d = "";

    public b(Context context) {
        AppMethodBeat.i(222935);
        this.f39b = context;
        this.f40c = new ArrayList();
        AppMethodBeat.o(222935);
    }

    public static b a(Context context) {
        AppMethodBeat.i(222936);
        if (f38a == null) {
            f38a = new b(context);
        }
        b bVar = f38a;
        AppMethodBeat.o(222936);
        return bVar;
    }

    @TargetApi(3)
    public final synchronized DexClassLoader a() {
        DexClassLoader dexClassLoader;
        DexClassLoader dexClassLoader2;
        Exception exc;
        File[] listFiles;
        AppMethodBeat.i(222938);
        l.a(this.f39b);
        List<a> list = this.f40c;
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(222938);
            dexClassLoader = null;
        } else {
            q.f96d = q.a(this.f40c);
            String str = this.f39b.getFilesDir().getAbsolutePath() + File.separator + this.f41d;
            String str2 = this.f39b.getFilesDir().getAbsolutePath() + File.separator + q.f95c;
            StringBuilder sb = new StringBuilder();
            for (a aVar : this.f40c) {
                if (aVar != null) {
                    sb.append(str);
                    sb.append(File.separator);
                    sb.append(aVar.f34c);
                    sb.append(File.pathSeparator);
                }
            }
            try {
                System.currentTimeMillis();
                dexClassLoader = new DexClassLoader(sb.toString(), str2, null, getClass().getClassLoader());
                String str3 = "";
                try {
                    File file = new File(str);
                    if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                        for (File file2 : listFiles) {
                            str3 = str3 + (file2.getName() + "," + file2.length() + "," + q.a(file2)) + ";";
                        }
                    }
                    j.a("before load ,private dir files:" + str3);
                    e.a(this.f39b).a("CPL", "suc:" + q.f96d);
                    AppMethodBeat.o(222938);
                } catch (Exception e2) {
                    dexClassLoader2 = dexClassLoader;
                    exc = e2;
                    j.a("try once", exc);
                    e.a(this.f39b).a("CPL", "fail:" + q.f96d + ",exc:" + exc.toString());
                    l.a(this.f39b);
                    try {
                        System.currentTimeMillis();
                        dexClassLoader = new DexClassLoader(sb.toString(), str2, null, getClass().getClassLoader());
                        try {
                            e.a(this.f39b).a("CPL", "suc:c" + q.f96d);
                            AppMethodBeat.o(222938);
                        } catch (Throwable th) {
                            j.a("try once failed", exc);
                            AppMethodBeat.o(222938);
                            return dexClassLoader;
                        }
                    } catch (Throwable th2) {
                        dexClassLoader = dexClassLoader2;
                        j.a("try once failed", exc);
                        AppMethodBeat.o(222938);
                        return dexClassLoader;
                    }
                    return dexClassLoader;
                }
            } catch (Exception e3) {
                dexClassLoader2 = null;
                exc = e3;
                j.a("try once", exc);
                e.a(this.f39b).a("CPL", "fail:" + q.f96d + ",exc:" + exc.toString());
                l.a(this.f39b);
                System.currentTimeMillis();
                dexClassLoader = new DexClassLoader(sb.toString(), str2, null, getClass().getClassLoader());
                e.a(this.f39b).a("CPL", "suc:c" + q.f96d);
                AppMethodBeat.o(222938);
                return dexClassLoader;
            }
        }
        return dexClassLoader;
    }

    public DexClassLoader a(List<a> list, String str) {
        Throwable th;
        AppMethodBeat.i(222937);
        this.f40c = list;
        this.f41d = str;
        int i2 = 0;
        DexClassLoader dexClassLoader = null;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= 3) {
                break;
            }
            try {
                dexClassLoader = a();
                try {
                    e.b().a("CPL", "lcn:" + i3);
                    if (dexClassLoader != null) {
                        l.f(this.f39b);
                        AppMethodBeat.o(222937);
                        break;
                    }
                    i2 = i3;
                } catch (Throwable th2) {
                    th = th2;
                    e.b().a("CPL", "fail:" + th.toString());
                    l.f(this.f39b);
                    AppMethodBeat.o(222937);
                    return dexClassLoader;
                }
            } catch (Throwable th3) {
                th = th3;
                e.b().a("CPL", "fail:" + th.toString());
                l.f(this.f39b);
                AppMethodBeat.o(222937);
                return dexClassLoader;
            }
        }
        l.f(this.f39b);
        AppMethodBeat.o(222937);
        return dexClassLoader;
    }
}
