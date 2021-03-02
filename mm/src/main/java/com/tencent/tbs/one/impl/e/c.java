package com.tencent.tbs.one.impl.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.impl.a.a;
import com.tencent.tbs.one.impl.a.b;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.f;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.thumbplayer.core.player.TPNativePlayerInitConfig;
import java.io.File;

public final class c extends b<e<File>> {

    /* renamed from: e  reason: collision with root package name */
    private d.a f2696e;

    /* renamed from: f  reason: collision with root package name */
    private a<e<File>> f2697f;

    /* renamed from: g  reason: collision with root package name */
    private File f2698g;

    public c(d.a aVar, a<e<File>> aVar2, File file) {
        super(f.e(file, ".lock"));
        AppMethodBeat.i(173996);
        this.f2696e = aVar;
        this.f2697f = aVar2;
        this.f2698g = file;
        AppMethodBeat.o(173996);
    }

    @Override // com.tencent.tbs.one.impl.a.a, com.tencent.tbs.one.impl.a.b
    public final void a(int i2, String str, Throwable th) {
        AppMethodBeat.i(173999);
        File file = this.f2698g;
        com.tencent.tbs.one.impl.a.c.c(file);
        f.f(file);
        super.a(i2, str, th);
        AppMethodBeat.o(173999);
    }

    public final void a(e<File> eVar) {
        AppMethodBeat.i(174000);
        f.f(this.f2698g);
        super.a((Object) eVar);
        AppMethodBeat.o(174000);
    }

    @Override // com.tencent.tbs.one.impl.a.b
    public final void a(Exception exc) {
        AppMethodBeat.i(173998);
        a(TPNativePlayerInitConfig.INT_WIDTH, "Failed to wait for component installation lock " + this.f2698g, exc);
        AppMethodBeat.o(173998);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.tbs.one.impl.a.a, com.tencent.tbs.one.impl.a.b
    public final /* bridge */ /* synthetic */ void a(e<File> eVar) {
        AppMethodBeat.i(174002);
        a(eVar);
        AppMethodBeat.o(174002);
    }

    @Override // com.tencent.tbs.one.impl.a.a
    public final void b() {
        AppMethodBeat.i(174001);
        super.b();
        this.f2697f.b();
        AppMethodBeat.o(174001);
    }

    @Override // com.tencent.tbs.one.impl.a.b
    public final void c() {
        AppMethodBeat.i(173997);
        File file = this.f2698g;
        if (f.g(file)) {
            if (file.exists()) {
                a(e.a(e.a.EXISTING, file));
                AppMethodBeat.o(173997);
                return;
            }
            f.e(file);
        } else if (file.exists()) {
            com.tencent.tbs.one.impl.a.c.c(file);
        }
        this.f2697f.a(new l<e<File>>() {
            /* class com.tencent.tbs.one.impl.e.c.AnonymousClass1 */

            @Override // com.tencent.tbs.one.impl.a.l
            public final void a(int i2, int i3) {
                AppMethodBeat.i(174021);
                c.this.a(i3);
                AppMethodBeat.o(174021);
            }

            @Override // com.tencent.tbs.one.impl.a.l
            public final void a(int i2, String str, Throwable th) {
                AppMethodBeat.i(174022);
                c.this.a(i2, str, th);
                AppMethodBeat.o(174022);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.tbs.one.impl.a.l
            public final /* bridge */ /* synthetic */ void a(e<File> eVar) {
                AppMethodBeat.i(174023);
                c.this.a(eVar);
                AppMethodBeat.o(174023);
            }
        });
        AppMethodBeat.o(173997);
    }
}
