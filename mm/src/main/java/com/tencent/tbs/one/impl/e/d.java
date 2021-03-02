package com.tencent.tbs.one.impl.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.a;
import com.tencent.tbs.one.impl.a.b;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.common.f;
import com.tencent.tbs.one.impl.e.e;
import java.io.File;

public final class d extends b<e<com.tencent.tbs.one.impl.common.d>> {

    /* renamed from: e  reason: collision with root package name */
    private a<e<com.tencent.tbs.one.impl.common.d>> f2725e;

    /* renamed from: f  reason: collision with root package name */
    private File f2726f;

    public d(a<e<com.tencent.tbs.one.impl.common.d>> aVar, File file) {
        super(f.e(file, ".lock"));
        AppMethodBeat.i(174108);
        this.f2725e = aVar;
        this.f2726f = file;
        AppMethodBeat.o(174108);
    }

    @Override // com.tencent.tbs.one.impl.a.a, com.tencent.tbs.one.impl.a.b
    public final void a(int i2, String str, Throwable th) {
        AppMethodBeat.i(174111);
        File file = this.f2726f;
        c.c(file);
        f.f(file);
        super.a(i2, str, th);
        AppMethodBeat.o(174111);
    }

    public final void a(e<com.tencent.tbs.one.impl.common.d> eVar) {
        AppMethodBeat.i(174112);
        f.f(this.f2726f);
        super.a((Object) eVar);
        AppMethodBeat.o(174112);
    }

    @Override // com.tencent.tbs.one.impl.a.b
    public final void a(Exception exc) {
        AppMethodBeat.i(174110);
        a(301, "Failed to wait for DEPS installation lock " + this.f2726f, exc);
        AppMethodBeat.o(174110);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.tbs.one.impl.a.a, com.tencent.tbs.one.impl.a.b
    public final /* bridge */ /* synthetic */ void a(e<com.tencent.tbs.one.impl.common.d> eVar) {
        AppMethodBeat.i(174114);
        a(eVar);
        AppMethodBeat.o(174114);
    }

    @Override // com.tencent.tbs.one.impl.a.a
    public final void b() {
        AppMethodBeat.i(174113);
        super.b();
        this.f2725e.b();
        AppMethodBeat.o(174113);
    }

    @Override // com.tencent.tbs.one.impl.a.b
    public final void c() {
        AppMethodBeat.i(174109);
        File file = this.f2726f;
        if (f.g(file)) {
            if (file.exists()) {
                try {
                    a(e.a(e.a.EXISTING, com.tencent.tbs.one.impl.common.d.a(file)));
                    AppMethodBeat.o(174109);
                    return;
                } catch (TBSOneException e2) {
                    a(e2.getErrorCode(), e2.getMessage(), e2.getCause());
                    AppMethodBeat.o(174109);
                    return;
                }
            } else {
                f.e(file);
            }
        } else if (file.exists()) {
            c.c(file);
        }
        this.f2725e.a(new l<e<com.tencent.tbs.one.impl.common.d>>() {
            /* class com.tencent.tbs.one.impl.e.d.AnonymousClass1 */

            @Override // com.tencent.tbs.one.impl.a.l
            public final void a(int i2, int i3) {
                AppMethodBeat.i(174024);
                d.this.a(i3);
                AppMethodBeat.o(174024);
            }

            @Override // com.tencent.tbs.one.impl.a.l
            public final void a(int i2, String str, Throwable th) {
                AppMethodBeat.i(174025);
                d.this.a(i2, str, th);
                AppMethodBeat.o(174025);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.tbs.one.impl.a.l
            public final /* bridge */ /* synthetic */ void a(e<com.tencent.tbs.one.impl.common.d> eVar) {
                AppMethodBeat.i(174026);
                d.this.a(eVar);
                AppMethodBeat.o(174026);
            }
        });
        AppMethodBeat.o(174109);
    }
}
