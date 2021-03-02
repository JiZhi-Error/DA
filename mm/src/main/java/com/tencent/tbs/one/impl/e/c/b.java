package com.tencent.tbs.one.impl.e.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.a;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.d.a;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public final class b extends a<e<d>> implements a.AbstractC2197a {

    /* renamed from: b  reason: collision with root package name */
    com.tencent.tbs.one.impl.d.a f2715b;

    /* renamed from: c  reason: collision with root package name */
    int f2716c;

    /* renamed from: d  reason: collision with root package name */
    private Context f2717d;

    /* renamed from: e  reason: collision with root package name */
    private String f2718e;

    /* renamed from: f  reason: collision with root package name */
    private String f2719f;

    /* renamed from: g  reason: collision with root package name */
    private File f2720g;

    public b(Context context, String str, String str2, File file) {
        this.f2717d = context;
        this.f2718e = str;
        this.f2719f = str2;
        this.f2720g = file;
    }

    @Override // com.tencent.tbs.one.impl.a.a
    public final void a() {
        AppMethodBeat.i(174014);
        this.f2715b = new com.tencent.tbs.one.impl.d.a(this.f2717d, this.f2719f);
        this.f2715b.f2621f = this;
        this.f2715b.a((l) new l<Integer>() {
            /* class com.tencent.tbs.one.impl.e.c.b.AnonymousClass1 */

            @Override // com.tencent.tbs.one.impl.a.l
            public final void a(int i2, int i3) {
                AppMethodBeat.i(174017);
                b.this.a(i3);
                AppMethodBeat.o(174017);
            }

            @Override // com.tencent.tbs.one.impl.a.l
            public final void a(int i2, String str, Throwable th) {
                AppMethodBeat.i(174018);
                b.this.f2715b = null;
                b.this.a(i2, str, th);
                AppMethodBeat.o(174018);
            }
        });
        AppMethodBeat.o(174014);
    }

    @Override // com.tencent.tbs.one.impl.d.a.AbstractC2197a
    public final void a(int i2, Map<String, List<String>> map, InputStream inputStream) {
        int shouldInterceptDEPSResponse;
        AppMethodBeat.i(174016);
        Context context = this.f2717d;
        String str = this.f2719f;
        final String str2 = this.f2718e;
        final File file = this.f2720g;
        f.a("[%s] Receiving DEPS response: [%d] %s", str2, Integer.valueOf(i2), map);
        if (i2 != 200 || inputStream == null) {
            a(210, "Invalid DEPS response stream, url: " + str + ", statusCode: " + i2, (Throwable) null);
            AppMethodBeat.o(174016);
            return;
        }
        TBSOneRuntimeExtension b2 = com.tencent.tbs.one.impl.common.a.b(context, str2);
        if (b2 == null || (shouldInterceptDEPSResponse = b2.shouldInterceptDEPSResponse(str2, null, inputStream, file, new TBSOneCallback<Void>() {
            /* class com.tencent.tbs.one.impl.e.c.b.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.tbs.one.TBSOneCallback
            public final /* synthetic */ void onCompleted(Void r6) {
                AppMethodBeat.i(174005);
                f.a("[%s] Finished intercepting DEPS download stream by runtime extension", str2);
                b.this.f2716c = 0;
                try {
                    b.this.a(e.a(e.a.EXTENSION, d.a(file)));
                    AppMethodBeat.o(174005);
                } catch (TBSOneException e2) {
                    b.this.a(e2.getErrorCode(), e2.getMessage(), e2.getCause());
                    AppMethodBeat.o(174005);
                }
            }

            @Override // com.tencent.tbs.one.TBSOneCallback
            public final void onError(int i2, String str) {
                AppMethodBeat.i(174004);
                b.this.f2716c = 0;
                b.this.a(i2, str, (Throwable) null);
                AppMethodBeat.o(174004);
            }

            @Override // com.tencent.tbs.one.TBSOneCallback
            public final void onProgressChanged(int i2, int i3) {
                AppMethodBeat.i(174003);
                b.this.a(i3);
                AppMethodBeat.o(174003);
            }
        })) == 0) {
            try {
                a(e.a(e.a.ONLINE, d.a(c.a(inputStream, ProtocolPackage.ServerEncoding, file))));
                AppMethodBeat.o(174016);
            } catch (IOException e2) {
                a(305, "Failed to download online DEPS from " + str + " to " + file.getAbsolutePath(), e2);
                AppMethodBeat.o(174016);
            } catch (TBSOneException e3) {
                a(e3.getErrorCode(), e3.getMessage(), e3.getCause());
                AppMethodBeat.o(174016);
            }
        } else {
            f.a("[%s] Intercepted DEPS download stream by runtime extension", str2);
            this.f2716c = shouldInterceptDEPSResponse;
            AppMethodBeat.o(174016);
        }
    }

    @Override // com.tencent.tbs.one.impl.a.a
    public final void b() {
        TBSOneRuntimeExtension b2;
        AppMethodBeat.i(174015);
        super.b();
        if (this.f2715b != null) {
            this.f2715b.b();
        }
        if (!(this.f2716c == 0 || (b2 = com.tencent.tbs.one.impl.common.a.b(this.f2717d, this.f2718e)) == null)) {
            b2.cancel(this.f2716c);
        }
        AppMethodBeat.o(174015);
    }
}
