package com.tencent.tbs.one.impl.e.c;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.k;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.f;
import com.tencent.tbs.one.impl.d.a;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public final class a extends com.tencent.tbs.one.impl.a.a<e<File>> implements a.AbstractC2197a {

    /* renamed from: b  reason: collision with root package name */
    int f2700b;

    /* renamed from: c  reason: collision with root package name */
    private Context f2701c;

    /* renamed from: d  reason: collision with root package name */
    private String f2702d;

    /* renamed from: e  reason: collision with root package name */
    private d.a f2703e;

    /* renamed from: f  reason: collision with root package name */
    private File f2704f;

    /* renamed from: g  reason: collision with root package name */
    private File f2705g;

    /* renamed from: h  reason: collision with root package name */
    private com.tencent.tbs.one.impl.d.a f2706h;

    /* renamed from: i  reason: collision with root package name */
    private long f2707i = -1;

    /* renamed from: j  reason: collision with root package name */
    private Bundle f2708j;

    public a(Context context, String str, d.a aVar, File file, Bundle bundle) {
        AppMethodBeat.i(188003);
        this.f2701c = context;
        this.f2702d = str;
        this.f2703e = aVar;
        this.f2704f = file;
        this.f2708j = bundle;
        this.f2705g = f.a(this.f2701c, this.f2701c, str, aVar.f2558a, aVar.f2560c);
        AppMethodBeat.o(188003);
    }

    @Override // com.tencent.tbs.one.impl.a.a
    public final void a() {
        AppMethodBeat.i(174009);
        this.f2706h = new com.tencent.tbs.one.impl.d.a(this.f2701c, this.f2703e.f2561d);
        this.f2706h.f2621f = this;
        this.f2706h.a((l) new l<Integer>() {
            /* class com.tencent.tbs.one.impl.e.c.a.AnonymousClass1 */

            @Override // com.tencent.tbs.one.impl.a.l
            public final void a(int i2, int i3) {
                AppMethodBeat.i(174012);
                a.this.a(i3);
                AppMethodBeat.o(174012);
            }

            @Override // com.tencent.tbs.one.impl.a.l
            public final void a(int i2, String str, Throwable th) {
                AppMethodBeat.i(174013);
                a.this.a(i2, str, th);
                AppMethodBeat.o(174013);
            }
        });
        AppMethodBeat.o(174009);
    }

    @Override // com.tencent.tbs.one.impl.d.a.AbstractC2197a
    public final void a(int i2, Map<String, List<String>> map, InputStream inputStream) {
        int shouldInterceptComponentResponse;
        AppMethodBeat.i(174011);
        Context context = this.f2701c;
        final String str = this.f2702d;
        final String str2 = this.f2703e.f2558a;
        int i3 = this.f2703e.f2560c;
        String str3 = this.f2703e.f2561d;
        final File file = this.f2704f;
        if (this.f2705g != null && !this.f2705g.exists()) {
            this.f2705g.mkdirs();
        }
        File file2 = this.f2705g == null ? null : new File(this.f2705g, this.f2703e.f2558a + ".tbs");
        com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Receiving component response: [%d] %s", str, str2, Integer.valueOf(i2), map);
        if (i2 != 200 || inputStream == null) {
            a(215, "Invalid component response stream, url: " + str3 + ", statusCode: " + i2, (Throwable) null);
            AppMethodBeat.o(174011);
            return;
        }
        List<String> list = map.get("Content-Length");
        if (list == null || list.size() <= 0) {
            com.tencent.tbs.one.impl.a.f.a("No Content-Length header exists, url: %s", str3);
        } else {
            try {
                this.f2707i = Long.parseLong(list.get(0));
            } catch (Exception e2) {
                com.tencent.tbs.one.impl.a.f.c("Failed to parse Content-Length header %s, url: %s", list, str3, e2);
            }
        }
        TBSOneRuntimeExtension b2 = com.tencent.tbs.one.impl.common.a.b(context, str);
        if (b2 == null || (shouldInterceptComponentResponse = b2.shouldInterceptComponentResponse(str, str2, i3, null, inputStream, file, new TBSOneCallback<Void>() {
            /* class com.tencent.tbs.one.impl.e.c.a.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.tbs.one.TBSOneCallback
            public final /* synthetic */ void onCompleted(Void r7) {
                AppMethodBeat.i(174008);
                com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Finished intercepting component download stream by runtime extension", str, str2);
                a.this.f2700b = 0;
                a.this.a(e.a(e.a.EXTENSION, file));
                AppMethodBeat.o(174008);
            }

            @Override // com.tencent.tbs.one.TBSOneCallback
            public final void onError(int i2, String str) {
                AppMethodBeat.i(174007);
                a.this.f2700b = 0;
                a.this.a(i2, str, (Throwable) null);
                AppMethodBeat.o(174007);
            }

            @Override // com.tencent.tbs.one.TBSOneCallback
            public final void onProgressChanged(int i2, int i3) {
                AppMethodBeat.i(174006);
                a.this.a(i3);
                AppMethodBeat.o(174006);
            }
        })) == 0) {
            try {
                com.tencent.tbs.one.impl.e.f.a(inputStream, this.f2703e.f2562e, this.f2707i, file, file2, new k.a() {
                    /* class com.tencent.tbs.one.impl.e.c.a.AnonymousClass3 */

                    @Override // com.tencent.tbs.one.impl.a.k.a
                    public final void a(int i2) {
                        AppMethodBeat.i(174019);
                        a.this.a(i2);
                        AppMethodBeat.o(174019);
                    }

                    @Override // com.tencent.tbs.one.impl.a.k.a
                    public final boolean a() {
                        return !a.this.f2326a;
                    }
                });
                com.tencent.tbs.one.impl.e.f.a(file, file);
                com.tencent.tbs.one.impl.e.f.a(file, i3);
                com.tencent.tbs.one.impl.e.f.a(this.f2701c.getDir("tbs", 0));
                com.tencent.tbs.one.impl.e.f.b(file);
                a(e.a(e.a.ONLINE, file));
                AppMethodBeat.o(174011);
            } catch (TBSOneException e3) {
                a(e3.getErrorCode(), e3.getMessage(), e3.getCause());
                AppMethodBeat.o(174011);
            }
        } else {
            com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Intercepted component download stream by runtime extension", str, str2);
            this.f2700b = shouldInterceptComponentResponse;
            AppMethodBeat.o(174011);
        }
    }

    @Override // com.tencent.tbs.one.impl.a.a
    public final void b() {
        TBSOneRuntimeExtension b2;
        AppMethodBeat.i(174010);
        super.b();
        if (this.f2706h != null) {
            this.f2706h.b();
        }
        if (!(this.f2700b == 0 || (b2 = com.tencent.tbs.one.impl.common.a.b(this.f2701c, this.f2702d)) == null)) {
            b2.cancel(this.f2700b);
        }
        AppMethodBeat.o(174010);
    }
}
