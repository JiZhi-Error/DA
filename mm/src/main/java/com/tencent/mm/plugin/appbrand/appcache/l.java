package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import java.util.Locale;

public final class l extends a {
    final int kKA;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public l(java.lang.String r11, int r12, int r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 124
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appcache.l.<init>(java.lang.String, int, int, java.lang.String):void");
    }

    private l(String str, String str2, String str3, String str4, int i2, int i3) {
        super(str, str2, str3, str4, i3, 0);
        this.kKA = i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.a.a
    public final String toShortString() {
        AppMethodBeat.i(90550);
        String format = String.format(Locale.US, "EncryptPkgDownloadRequest[%s %d %d]", this.appId, Integer.valueOf(this.kKA), Integer.valueOf(this.version));
        AppMethodBeat.o(90550);
        return format;
    }
}
