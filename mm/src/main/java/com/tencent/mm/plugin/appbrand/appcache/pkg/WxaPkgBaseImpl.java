package com.tencent.mm.plugin.appbrand.appcache.pkg;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class WxaPkgBaseImpl implements a {
    public static int A(byte[] bArr, int i2, int i3) {
        if (bArr == null) {
            return 0;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i2, i3);
        wrap.order(ByteOrder.BIG_ENDIAN);
        if (i3 == 4) {
            return wrap.getInt();
        }
        byte[] bArr2 = new byte[i3];
        wrap.get(bArr2);
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            i4 |= bArr2[i5] << (((i3 - i5) - 1) * 8);
        }
        return i4;
    }

    public static class Info extends WxaPkg.Info {
        public Info(String str, String str2, int i2, int i3) {
            super(str, str2, i2, i3);
        }
    }
}
