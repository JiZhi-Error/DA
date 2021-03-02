package c.t.m.sapp.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.g;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public static int f42a;

    /* renamed from: b  reason: collision with root package name */
    public final int f43b = CommonUtils.MAX_TIMEOUT_MS;

    /* renamed from: c  reason: collision with root package name */
    public final int f44c = g.sHCENCODEVIDEOTIMEOUT;

    /* renamed from: d  reason: collision with root package name */
    public Context f45d;

    /* renamed from: e  reason: collision with root package name */
    public List<a> f46e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f47f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48g = false;

    public c(Context context) {
        AppMethodBeat.i(222939);
        this.f45d = context;
        this.f47f = this.f45d.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation_sapp/UpCp";
        File file = new File(this.f45d.getFilesDir().getAbsolutePath(), "TencentLocation_sapp/UpCp");
        if (!file.exists()) {
            file.mkdirs();
        }
        AppMethodBeat.o(222939);
    }

    public final synchronized void a() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(222942);
            List<a> list = this.f46e;
            if (list != null && list.size() > 0) {
                f42a = 1;
                q.j(this.f45d);
                if (q.d() < 10485760) {
                    f42a = 2;
                    AppMethodBeat.o(222942);
                } else {
                    ArrayList arrayList = new ArrayList();
                    boolean z2 = true;
                    for (a aVar : this.f46e) {
                        if (!a(aVar)) {
                            z2 = false;
                        } else {
                            arrayList.add(aVar);
                        }
                    }
                    if (!z2) {
                        f42a = 2;
                        a(arrayList);
                        AppMethodBeat.o(222942);
                    } else if (arrayList.size() == this.f46e.size()) {
                        q.a(this.f45d, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", "");
                        if (q.a(this.f45d, this.f46e)) {
                            q.b(this.f45d, "__SP_UPDATE_TencentLoc_COMP_SDK_VER__sapp_", h.f67a);
                            for (a aVar2 : arrayList) {
                                if (!aVar2.f34c.contains(ShareConstants.DEX_SUFFIX)) {
                                    aVar2.f34c += ShareConstants.DEX_SUFFIX;
                                }
                                File file = new File(this.f47f, aVar2.f34c);
                                boolean delete = file.exists() ? file.delete() : true;
                                File file2 = new File(this.f47f, aVar2.f34c);
                                boolean renameTo = new File(this.f47f, "tmp__sapp" + aVar2.f34c).renameTo(file2);
                                boolean a2 = a(aVar2, file2);
                                if (delete && renameTo && a2) {
                                    z = true;
                                }
                            }
                            if (!z) {
                                q.b(this.f45d, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", "");
                                q.a(this.f47f);
                                f42a = 2;
                                AppMethodBeat.o(222942);
                            } else {
                                f42a = 1;
                                e.a(this.f45d).a("CPU", "down suc");
                                AppMethodBeat.o(222942);
                            }
                        } else {
                            a(arrayList);
                            f42a = 2;
                            AppMethodBeat.o(222942);
                        }
                    } else {
                        j.a("down load failed");
                        e.a(this.f45d).a("CPU", "down failed");
                        a(arrayList);
                        f42a = 2;
                    }
                }
            }
            AppMethodBeat.o(222942);
        }
    }

    public void b(List<a> list) {
        AppMethodBeat.i(222941);
        this.f46e = list;
        if (f42a != 1) {
            new Thread(this).start();
        }
        AppMethodBeat.o(222941);
    }

    public void run() {
        AppMethodBeat.i(222940);
        d.a(this.f45d).b("updatelock_sapp");
        a();
        e.a(this.f45d).d();
        d.a(this.f45d).c("updatelock_sapp");
        AppMethodBeat.o(222940);
    }

    public final void a(List<a> list) {
        AppMethodBeat.i(222943);
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(this.f47f, "tmp__sapp" + it.next().f34c);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
        AppMethodBeat.o(222943);
    }

    public final boolean a(a aVar) {
        BufferedOutputStream bufferedOutputStream;
        byte[] c2;
        Exception exc;
        Throwable th;
        BufferedOutputStream bufferedOutputStream2;
        AppMethodBeat.i(222944);
        try {
            String str = "https://maplbs-40171.sh.gfp.tencent-cloud.com/Index/" + aVar.f36e;
            j.a("start down load:" + aVar.f36e);
            BufferedOutputStream bufferedOutputStream3 = null;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= 3) {
                    break;
                }
                byte[] a2 = p.a(str);
                if (a2 == null || (c2 = q.c(m.a(a2, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q"))) == null) {
                    bufferedOutputStream = bufferedOutputStream3;
                } else {
                    File file = new File(this.f47f, "tmp__sapp" + aVar.f34c);
                    try {
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, false), 1024);
                        try {
                            bufferedOutputStream.write(c2);
                            if (a(aVar, file)) {
                                j.a("down load available:" + aVar.f36e);
                                e.a(this.f45d).a("CPU", "sud:" + aVar.f36e);
                                try {
                                    bufferedOutputStream.close();
                                } catch (Exception e2) {
                                }
                                AppMethodBeat.o(222944);
                                return true;
                            }
                            j.a("down load unavailable:" + aVar.f36e);
                            e.a(this.f45d).a("CPU", "failed:" + aVar.f36e);
                            if (file.exists() && file.isFile()) {
                                file.delete();
                            }
                            try {
                                bufferedOutputStream.close();
                            } catch (Exception e3) {
                            }
                        } catch (Exception e4) {
                            exc = e4;
                            try {
                                if (file.exists() && file.isFile()) {
                                    file.delete();
                                }
                                e.a(this.f45d).a("CPU", "failed:" + exc.toString());
                                bufferedOutputStream.close();
                                q.a(5000L);
                                i2 = i3;
                                bufferedOutputStream3 = bufferedOutputStream;
                            } catch (Throwable th2) {
                                bufferedOutputStream2 = bufferedOutputStream;
                                th = th2;
                                try {
                                    bufferedOutputStream2.close();
                                } catch (Exception e5) {
                                }
                                AppMethodBeat.o(222944);
                                throw th;
                            }
                        }
                    } catch (Exception e6) {
                        exc = e6;
                        bufferedOutputStream = bufferedOutputStream3;
                        file.delete();
                        e.a(this.f45d).a("CPU", "failed:" + exc.toString());
                        bufferedOutputStream.close();
                        q.a(5000L);
                        i2 = i3;
                        bufferedOutputStream3 = bufferedOutputStream;
                    } catch (Throwable th3) {
                        bufferedOutputStream2 = bufferedOutputStream3;
                        th = th3;
                        bufferedOutputStream2.close();
                        AppMethodBeat.o(222944);
                        throw th;
                    }
                }
                q.a(5000L);
                i2 = i3;
                bufferedOutputStream3 = bufferedOutputStream;
            }
        } catch (Throwable th4) {
        }
        AppMethodBeat.o(222944);
        return false;
    }

    public final boolean a(a aVar, File file) {
        AppMethodBeat.i(222945);
        boolean z = false;
        if (file != null && file.exists()) {
            int length = (int) file.length();
            String a2 = q.a(file);
            if (aVar.f35d == length && aVar.f36e.equals(a2)) {
                z = true;
            }
        }
        AppMethodBeat.o(222945);
        return z;
    }
}
