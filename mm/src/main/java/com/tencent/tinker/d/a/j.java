package com.tencent.tinker.d.a;

import java.io.InputStream;

public final class j {
    public static void a(h hVar, g gVar, i iVar) {
        InputStream inputStream = null;
        try {
            inputStream = hVar.a(gVar);
            iVar.b(new g(gVar));
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                iVar.write(bArr, 0, read);
            }
            iVar.closeEntry();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.tencent.tinker.d.a.g r4, java.io.File r5, long r6, com.tencent.tinker.d.a.i r8) {
        /*
        // Method dump skipped, instructions count: 112
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.d.a.j.a(com.tencent.tinker.d.a.g, java.io.File, long, com.tencent.tinker.d.a.i):void");
    }
}
