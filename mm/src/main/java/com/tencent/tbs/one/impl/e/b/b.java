package com.tencent.tbs.one.impl.e.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.a;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.f;
import com.tencent.tbs.one.impl.e.e;
import java.io.File;
import java.io.IOException;

public final class b extends a<e<d>> {

    /* renamed from: b  reason: collision with root package name */
    Context f2692b;

    /* renamed from: c  reason: collision with root package name */
    String f2693c;

    /* renamed from: d  reason: collision with root package name */
    File f2694d;

    public b(Context context, String str, File file) {
        this.f2692b = context;
        this.f2693c = str;
        this.f2694d = file;
    }

    @Override // com.tencent.tbs.one.impl.a.a
    public final void a() {
        AppMethodBeat.i(174067);
        m.d(new Runnable() {
            /* class com.tencent.tbs.one.impl.e.b.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(174069);
                b bVar = b.this;
                Context context = b.this.f2692b;
                String str = b.this.f2693c;
                File file = b.this.f2694d;
                File a2 = f.a(context);
                try {
                    c.a(f.c(a2, str), file);
                    try {
                        bVar.a(e.a(e.a.BUILTIN, d.a(file)));
                        AppMethodBeat.o(174069);
                    } catch (TBSOneException e2) {
                        bVar.a(e2.getErrorCode(), e2.getMessage(), e2.getCause());
                        AppMethodBeat.o(174069);
                    }
                } catch (IOException e3) {
                    bVar.a(302, "Failed to copy builtin DEPS from " + a2.getAbsolutePath() + " to " + file.getAbsolutePath(), e3);
                    AppMethodBeat.o(174069);
                }
            }
        });
        AppMethodBeat.o(174067);
    }
}
