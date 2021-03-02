package com.tencent.mm.plugin.ai.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;

public final class b implements g.a {
    private a kwM = null;
    public String kwN = "";
    private boolean kwO = false;
    private String kwP = "";
    private String md5 = "";
    public String mediaId = "";
    private String savePath = "";
    public String url = "";

    /* access modifiers changed from: package-private */
    public interface a {
        void a(boolean z, String str, String str2, boolean z2, String str3);
    }

    public b(String str, String str2, String str3, a aVar, String str4) {
        AppMethodBeat.i(238906);
        this.url = str;
        this.savePath = str2;
        this.md5 = str3;
        this.kwM = aVar;
        this.mediaId = "ai_download_" + str.hashCode() + Util.nowMilliSecond();
        this.kwN = str2 + ".tmp";
        this.kwO = true;
        this.kwP = str4;
        AppMethodBeat.o(238906);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x006b  */
    @Override // com.tencent.mm.i.g.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.lang.String r10, int r11, com.tencent.mm.i.c r12, com.tencent.mm.i.d r13, boolean r14) {
        /*
        // Method dump skipped, instructions count: 126
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ai.d.a.b.a(java.lang.String, int, com.tencent.mm.i.c, com.tencent.mm.i.d, boolean):int");
    }

    @Override // com.tencent.mm.i.g.a
    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    @Override // com.tencent.mm.i.g.a
    public final byte[] f(String str, byte[] bArr) {
        return new byte[0];
    }
}
