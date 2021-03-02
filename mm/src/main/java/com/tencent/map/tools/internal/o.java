package com.tencent.map.tools.internal;

import android.content.Context;
import android.util.Pair;
import com.tencent.map.tools.EncryptAesUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class o {

    /* renamed from: a  reason: collision with root package name */
    List<p> f1384a;

    /* renamed from: b  reason: collision with root package name */
    volatile int f1385b;

    /* renamed from: c  reason: collision with root package name */
    private String f1386c = o.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    private Context f1387d;

    public o(Context context) {
        AppMethodBeat.i(180833);
        this.f1387d = context;
        AppMethodBeat.o(180833);
    }

    public final void a() {
        AppMethodBeat.i(180834);
        try {
            v.a(this.f1387d).a("update");
            for (int i2 = 0; i2 < 3 && !b(); i2++) {
            }
            v.a(this.f1387d).b("update");
            AppMethodBeat.o(180834);
        } catch (Throwable th) {
            AppMethodBeat.o(180834);
        }
    }

    private static boolean a(String str, byte[] bArr, p pVar) {
        AppMethodBeat.i(180835);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(180835);
            return false;
        } else if (!new w(str).a(bArr)) {
            AppMethodBeat.o(180835);
            return false;
        } else {
            String a2 = x.a(new File(str));
            if (a2 == null || !pVar.f1392e.equals(a2)) {
                AppMethodBeat.o(180835);
                return false;
            }
            AppMethodBeat.o(180835);
            return true;
        }
    }

    private synchronized boolean b() {
        boolean z;
        boolean z2;
        int i2;
        AppMethodBeat.i(180836);
        this.f1385b = 0;
        if (this.f1384a != null && this.f1384a.size() > 0) {
            this.f1385b = 1;
            if (x.d() < 10485760) {
                this.f1385b = 2;
                z = false;
                AppMethodBeat.o(180836);
            } else {
                String b2 = x.b(this.f1387d, t.B, BuildConfig.KINDA_DEFAULT);
                List<p> a2 = (b2 == null || b2.equals(BuildConfig.KINDA_DEFAULT)) ? null : x.a(b2);
                boolean z3 = false;
                int i3 = 0;
                int i4 = s.a(this.f1387d).f1397a;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i5 = 0; i5 < this.f1384a.size(); i5++) {
                    p pVar = this.f1384a.get(i5);
                    p a3 = x.a(pVar.f1388a, a2);
                    if (a(pVar)) {
                        arrayList2.add(new Pair(BuildConfig.KINDA_DEFAULT, BuildConfig.KINDA_DEFAULT));
                        if (x.a(pVar.f1388a)) {
                            z3 = true;
                        } else {
                            i3++;
                        }
                        arrayList.add(pVar);
                    } else {
                        try {
                            byte[] a4 = r.a(t.E + pVar.f1392e);
                            if (a4 != null) {
                                byte[] a5 = x.a(EncryptAesUtils.decryptAes256(a4, "dwMmNhTC43xDnMGp", t.G));
                                if (!x.a(pVar.f1388a)) {
                                    String b3 = x.b(this.f1387d, x.f1427d);
                                    String str = b3 + File.separator + pVar.f1390c;
                                    String str2 = null;
                                    if (a3 != null) {
                                        str2 = b3 + File.separator + a3.f1390c;
                                    }
                                    if (a(str, a5, pVar)) {
                                        x.a(pVar.f1388a, a2);
                                        arrayList2.add(new Pair(str2, str));
                                        arrayList.add(pVar);
                                        i2 = i3 + 1;
                                        i3 = i2;
                                    }
                                } else if (pVar.f1388a == i4) {
                                    String b4 = x.b(this.f1387d, x.f1428e + File.separator + t.F[i4]);
                                    String str3 = b4 + File.separator + pVar.f1390c;
                                    String str4 = null;
                                    if (a3 != null) {
                                        str4 = b4 + File.separator + a3.f1390c;
                                    }
                                    if (a(str3, a5, pVar)) {
                                        z3 = true;
                                        x.a(pVar.f1388a, a2);
                                        arrayList2.add(new Pair(str4, str3));
                                        arrayList.add(pVar);
                                    } else {
                                        z3 = false;
                                    }
                                }
                            }
                            i2 = i3;
                            i3 = i2;
                        } catch (Throwable th) {
                            z3 = z3;
                        }
                    }
                }
                if (y.f1437e == 1) {
                    if (i3 > 0 && z3 && this.f1384a.size() == arrayList.size()) {
                        z2 = true;
                    } else if (i3 == 0 && z3 && this.f1384a.size() == arrayList.size()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else if (y.f1437e == 0 && this.f1384a.size() == arrayList.size()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        String str5 = (String) pair.first;
                        Object obj = pair.second;
                        if (str5 != null && !str5.equals(BuildConfig.KINDA_DEFAULT)) {
                            File file = new File(str5);
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                    }
                    x.a(this.f1387d, t.B, x.a(this.f1384a));
                    x.a(this.f1387d, t.u, t.k);
                    this.f1385b = 4;
                    z = true;
                    AppMethodBeat.o(180836);
                } else {
                    x.c(new File(t.f1407h));
                    x.a(this.f1387d, t.B, BuildConfig.KINDA_DEFAULT);
                }
            }
        }
        this.f1385b = 3;
        z = false;
        AppMethodBeat.o(180836);
        return z;
    }

    private boolean a(p pVar) {
        String str;
        AppMethodBeat.i(180837);
        try {
            if (x.a(pVar.f1388a)) {
                str = x.f1428e + File.separator + t.F[pVar.f1388a] + File.separator + pVar.f1390c;
            } else {
                str = x.f1427d + File.separator + pVar.f1390c;
            }
            File file = new File(x.b(this.f1387d, str));
            if (file.exists() || file.isFile()) {
                String name = file.getName();
                long length = file.length();
                String a2 = x.a(file);
                if (a2 == null) {
                    AppMethodBeat.o(180837);
                    return false;
                }
                if (pVar.f1390c.equals(name) && pVar.f1391d == length && pVar.f1392e.equals(a2)) {
                    AppMethodBeat.o(180837);
                    return true;
                }
                AppMethodBeat.o(180837);
                return false;
            }
            AppMethodBeat.o(180837);
            return false;
        } catch (Exception e2) {
        }
    }
}
