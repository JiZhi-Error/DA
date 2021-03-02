package com.google.a.a;

import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class b {
    private final byte[] buffer;
    final int limit;
    int position = 0;

    b(byte[] bArr, int i2) {
        this.buffer = bArr;
        this.limit = i2 + 0;
    }

    public final void n(int i2, long j2) {
        br(i2, 0);
        aJ(j2);
    }

    public final void q(int i2, long j2) {
        br(i2, 0);
        aJ(j2);
    }

    public final void bs(int i2, int i3) {
        br(i2, 0);
        if (i3 >= 0) {
            hc(i3);
        } else {
            aJ((long) i3);
        }
    }

    public final void e(int i2, String str) {
        br(i2, 2);
        byte[] bytes = str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        hc(bytes.length);
        s(bytes, bytes.length);
    }

    public final void a(int i2, e eVar) {
        br(i2, 2);
        hc(eVar.If());
        eVar.a(this);
    }

    public final void b(int i2, byte[] bArr) {
        br(i2, 2);
        hc(bArr.length);
        s(bArr, bArr.length);
    }

    public final void bB(int i2, int i3) {
        br(i2, 0);
        hc(i3);
    }

    public static int p(int i2, long j2) {
        return fS(i2) + aK(j2);
    }

    public static int r(int i2, long j2) {
        return fS(i2) + aK(j2);
    }

    public static int bu(int i2, int i3) {
        return fS(i2) + fT(i3);
    }

    public static int f(int i2, String str) {
        return fS(i2) + cb(str);
    }

    public static int b(int i2, e eVar) {
        int fS = fS(i2);
        int yC = eVar.yC();
        return fS + yC + fY(yC);
    }

    public static int c(int i2, byte[] bArr) {
        return fS(i2) + fY(bArr.length) + bArr.length;
    }

    public static int bC(int i2, int i3) {
        return fS(i2) + fY(i3);
    }

    public static int fT(int i2) {
        if (i2 >= 0) {
            return fY(i2);
        }
        return 10;
    }

    public static int cb(String str) {
        try {
            byte[] bytes = str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            return bytes.length + fY(bytes.length);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static class a extends IOException {
        a(int i2, int i3) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i2 + " limit " + i3 + ").");
        }
    }

    private void hb(int i2) {
        byte b2 = (byte) i2;
        if (this.position == this.limit) {
            throw new a(this.position, this.limit);
        }
        byte[] bArr = this.buffer;
        int i3 = this.position;
        this.position = i3 + 1;
        bArr[i3] = b2;
    }

    private void s(byte[] bArr, int i2) {
        if (this.limit - this.position >= i2) {
            System.arraycopy(bArr, 0, this.buffer, this.position, i2);
            this.position += i2;
            return;
        }
        throw new a(this.position, this.limit);
    }

    private void br(int i2, int i3) {
        hc(g.bA(i2, i3));
    }

    private static int fS(int i2) {
        return fY(g.bA(i2, 0));
    }

    private void hc(int i2) {
        while ((i2 & -128) != 0) {
            hb((i2 & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH) | 128);
            i2 >>>= 7;
        }
        hb(i2);
    }

    public static int fY(int i2) {
        if ((i2 & -128) == 0) {
            return 1;
        }
        if ((i2 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i2) == 0) {
            return 3;
        }
        if ((-268435456 & i2) == 0) {
            return 4;
        }
        return 5;
    }

    private void aJ(long j2) {
        while ((-128 & j2) != 0) {
            hb((((int) j2) & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH) | 128);
            j2 >>>= 7;
        }
        hb((int) j2);
    }

    private static int aK(long j2) {
        if ((-128 & j2) == 0) {
            return 1;
        }
        if ((-16384 & j2) == 0) {
            return 2;
        }
        if ((-2097152 & j2) == 0) {
            return 3;
        }
        if ((-268435456 & j2) == 0) {
            return 4;
        }
        if ((-34359738368L & j2) == 0) {
            return 5;
        }
        if ((-4398046511104L & j2) == 0) {
            return 6;
        }
        if ((-562949953421312L & j2) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j2) == 0) {
            return 8;
        }
        if ((Long.MIN_VALUE & j2) == 0) {
            return 9;
        }
        return 10;
    }
}
