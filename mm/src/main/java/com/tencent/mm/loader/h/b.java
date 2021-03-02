package com.tencent.mm.loader.h;

import com.tencent.mm.loader.b.a.c;
import com.tencent.mm.loader.h.b.a;
import com.tencent.mm.loader.h.f;
import java.io.OutputStream;

public final class b extends f<byte[]> {
    public String contentType;
    private f.a ibT;

    private b(byte[] bArr, String str, f.a<byte[]> aVar) {
        super(bArr);
        this.contentType = str;
        this.ibT = aVar;
    }

    public static b d(final byte[] bArr, String str) {
        return new b(bArr, str, new f.a<byte[]>() {
            /* class com.tencent.mm.loader.h.b.AnonymousClass1 */

            @Override // com.tencent.mm.loader.h.f.a
            public final /* synthetic */ a aKj() {
                return a.ae(bArr);
            }
        });
    }

    @Override // com.tencent.mm.loader.h.f
    public final void b(OutputStream outputStream) {
        c cVar = c.hYJ;
        c.a((byte[]) this.data, outputStream);
    }

    @Override // com.tencent.mm.loader.h.f
    public final a aKi() {
        return this.ibT.aKj();
    }
}
