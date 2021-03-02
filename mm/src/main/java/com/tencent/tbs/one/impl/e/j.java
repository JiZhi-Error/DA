package com.tencent.tbs.one.impl.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.impl.a.a;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.common.c;
import com.tencent.tbs.one.impl.common.d;
import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class j extends a<Void> {

    /* renamed from: b  reason: collision with root package name */
    i f2780b;

    /* renamed from: c  reason: collision with root package name */
    boolean f2781c;

    /* renamed from: d  reason: collision with root package name */
    Map<String, a> f2782d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    Bundle f2783e;

    public j(i iVar, Bundle bundle) {
        AppMethodBeat.i(188001);
        this.f2780b = iVar;
        this.f2783e = bundle;
        AppMethodBeat.o(188001);
    }

    static /* synthetic */ void a(j jVar, Bundle bundle, d dVar) {
        AppMethodBeat.i(188002);
        jVar.f2782d.remove("DEPS");
        if (dVar.f2555a == jVar.f2780b.m.getInt("in_use_deps_version", -1)) {
            jVar.a(506, "Failed to request the latest DEPS which different from current", (Throwable) null);
            AppMethodBeat.o(188002);
            return;
        }
        String[] l = jVar.f2780b.l();
        if (l == null || l.length <= 0) {
            jVar.a(507, "No in-use components", (Throwable) null);
            AppMethodBeat.o(188002);
            return;
        }
        HashSet hashSet = new HashSet();
        int length = l.length;
        int i2 = 0;
        while (true) {
            if (i2 < length) {
                if (!jVar.a(dVar, l[i2], hashSet)) {
                    break;
                }
                i2++;
            } else {
                for (d.a aVar : hashSet) {
                    final String str = aVar.f2558a;
                    final int i3 = aVar.f2560c;
                    f.a("[%s] Updating component %s#%d", jVar.f2780b.f2754b, str, Integer.valueOf(i3));
                    jVar.f2782d.put(str, jVar.f2780b.a(bundle, aVar, new c<e<File>>() {
                        /* class com.tencent.tbs.one.impl.e.j.AnonymousClass2 */

                        @Override // com.tencent.tbs.one.impl.a.l, com.tencent.tbs.one.impl.common.c
                        public final void a(int i2, String str, Throwable th) {
                            AppMethodBeat.i(174106);
                            f.c("[%s] Failed to update component %s#%d, error: [%d] %s", j.this.f2780b.f2754b, str, Integer.valueOf(i3), Integer.valueOf(i2), str, th);
                            j.this.a(i2, "Failed to update component " + str + ", caused by: " + str, th);
                            AppMethodBeat.o(174106);
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.tbs.one.impl.a.l, com.tencent.tbs.one.impl.common.c
                        public final /* synthetic */ void a(e<File> eVar) {
                            AppMethodBeat.i(174107);
                            e<File> eVar2 = eVar;
                            f.a("[%s] Finished updating component at %s from %s", j.this.f2780b.f2754b, eVar2.f2729b.getAbsolutePath(), eVar2.f2728a);
                            j jVar = j.this;
                            jVar.f2782d.remove(str);
                            if (!jVar.f2781c && jVar.f2782d.size() <= 0) {
                                f.a("[%s] Finished updating", jVar.f2780b.f2754b);
                                jVar.a((Object) null);
                            }
                            AppMethodBeat.o(174107);
                        }
                    }));
                }
            }
        }
        AppMethodBeat.o(188002);
    }

    private boolean a(d dVar, String str, Set<d.a> set) {
        AppMethodBeat.i(173971);
        d.a b2 = dVar.b(str);
        if (b2 != null) {
            String[] strArr = b2.f2563f;
            if (strArr != null) {
                for (String str2 : strArr) {
                    if (!a(dVar, str2, set)) {
                        AppMethodBeat.o(173971);
                        return false;
                    }
                }
            }
            set.add(b2);
            AppMethodBeat.o(173971);
            return true;
        }
        a(309, "Failed to get info for component ".concat(String.valueOf(str)), (Throwable) null);
        AppMethodBeat.o(173971);
        return false;
    }

    private void c() {
        AppMethodBeat.i(173972);
        for (a aVar : this.f2782d.values()) {
            aVar.b();
        }
        this.f2782d.clear();
        AppMethodBeat.o(173972);
    }

    @Override // com.tencent.tbs.one.impl.a.a
    public final void a() {
        AppMethodBeat.i(173970);
        f.a("[%s] Requesting the latest DEPS", this.f2780b.f2754b);
        final i iVar = this.f2780b;
        final String str = iVar.f2754b;
        File c2 = com.tencent.tbs.one.impl.common.f.c(iVar.f2755c);
        if (c2.exists()) {
            com.tencent.tbs.one.impl.a.c.c(c2);
        }
        a<e<d>> a2 = iVar.a(TBSOneManager.Policy.AUTO, -1, c2, this.f2783e);
        a2.a(new c<e<d>>() {
            /* class com.tencent.tbs.one.impl.e.j.AnonymousClass1 */

            @Override // com.tencent.tbs.one.impl.a.l, com.tencent.tbs.one.impl.common.c
            public final void a(int i2, String str, Throwable th) {
                AppMethodBeat.i(174104);
                f.c("[%s] Failed to request the latest DEPS, error: [%d] %s", str, Integer.valueOf(i2), str, th);
                j.this.a(i2, str, th);
                AppMethodBeat.o(174104);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.tbs.one.impl.a.l, com.tencent.tbs.one.impl.common.c
            public final /* synthetic */ void a(e<d> eVar) {
                AppMethodBeat.i(174105);
                e<d> eVar2 = eVar;
                f.a("[%s] Finished Requesting the latest DEPS#%d from %s", str, Integer.valueOf(eVar2.f2729b.f2555a), eVar2.f2728a);
                iVar.b(eVar2);
                j.a(j.this, j.this.f2783e, eVar2.f2729b);
                AppMethodBeat.o(174105);
            }
        });
        this.f2782d.put("DEPS", a2);
        AppMethodBeat.o(173970);
    }

    @Override // com.tencent.tbs.one.impl.a.a
    public final void a(int i2, String str, Throwable th) {
        AppMethodBeat.i(173973);
        f.b("Failed to update, error: [%d] %s", Integer.valueOf(i2), str);
        this.f2781c = true;
        c();
        File c2 = com.tencent.tbs.one.impl.common.f.c(this.f2780b.f2755c);
        if (c2.exists()) {
            com.tencent.tbs.one.impl.a.c.c(c2);
        }
        super.a(i2, str, th);
        AppMethodBeat.o(173973);
    }

    @Override // com.tencent.tbs.one.impl.a.a
    public final void b() {
        AppMethodBeat.i(173974);
        super.b();
        c();
        AppMethodBeat.o(173974);
    }
}
