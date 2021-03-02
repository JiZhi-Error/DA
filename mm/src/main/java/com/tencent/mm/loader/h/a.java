package com.tencent.mm.loader.h;

import com.tencent.mm.loader.b.a.c;
import com.tencent.mm.loader.h.f;
import java.io.OutputStream;

public final class a extends f<String> {
    public String contentType;
    private f.a ibT;

    private a(String str, String str2, f.a<String> aVar) {
        super(str);
        this.contentType = str2;
        this.ibT = aVar;
    }

    public static a az(final String str, String str2) {
        return new a(str, str2, new f.a<String>() {
            /* class com.tencent.mm.loader.h.a.AnonymousClass1 */

            @Override // com.tencent.mm.loader.h.f.a
            public final /* synthetic */ com.tencent.mm.loader.h.b.a aKj() {
                return com.tencent.mm.loader.h.b.a.Hk(str);
            }
        });
    }

    @Override // com.tencent.mm.loader.h.f
    public final void b(OutputStream outputStream) {
        c cVar = c.hYJ;
        c.a((String) this.data, outputStream);
    }

    @Override // com.tencent.mm.loader.h.f
    public final com.tencent.mm.loader.h.b.a aKi() {
        return this.ibT.aKj();
    }
}
