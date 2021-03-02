package g.a.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.io.UnsupportedEncodingException;

public final class a {
    private final byte[] buffer;
    private final int limit;
    private int position = 0;

    public a(byte[] bArr, int i2) {
        AppMethodBeat.i(2425);
        this.buffer = bArr;
        this.limit = i2 + 0;
        AppMethodBeat.o(2425);
    }

    public final void e(int i2, double d2) {
        AppMethodBeat.i(2426);
        br(i2, 1);
        long doubleToLongBits = Double.doubleToLongBits(d2);
        l((byte) (((int) doubleToLongBits) & 255));
        l((byte) (((int) (doubleToLongBits >> 8)) & 255));
        l((byte) (((int) (doubleToLongBits >> 16)) & 255));
        l((byte) (((int) (doubleToLongBits >> 24)) & 255));
        l((byte) (((int) (doubleToLongBits >> 32)) & 255));
        l((byte) (((int) (doubleToLongBits >> 40)) & 255));
        l((byte) (((int) (doubleToLongBits >> 48)) & 255));
        l((byte) (((int) (doubleToLongBits >> 56)) & 255));
        AppMethodBeat.o(2426);
    }

    public final void E(int i2, float f2) {
        AppMethodBeat.i(2427);
        br(i2, 5);
        int floatToIntBits = Float.floatToIntBits(f2);
        l((byte) (floatToIntBits & 255));
        l((byte) ((floatToIntBits >> 8) & 255));
        l((byte) ((floatToIntBits >> 16) & 255));
        l((byte) ((floatToIntBits >> 24) & 255));
        AppMethodBeat.o(2427);
    }

    public final void q(int i2, long j2) {
        AppMethodBeat.i(2428);
        br(i2, 0);
        aJ(j2);
        AppMethodBeat.o(2428);
    }

    public final void bs(int i2, int i3) {
        AppMethodBeat.i(2429);
        br(i2, 0);
        if (i3 >= 0) {
            hc(i3);
            AppMethodBeat.o(2429);
            return;
        }
        aJ((long) i3);
        AppMethodBeat.o(2429);
    }

    public final void r(int i2, boolean z) {
        AppMethodBeat.i(2430);
        br(i2, 0);
        if (z) {
            l((byte) 1);
            AppMethodBeat.o(2430);
            return;
        }
        l((byte) 0);
        AppMethodBeat.o(2430);
    }

    public final void e(int i2, String str) {
        AppMethodBeat.i(2431);
        if (str == null) {
            AppMethodBeat.o(2431);
            return;
        }
        br(i2, 2);
        byte[] bytes = str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        hc(bytes.length);
        dk(bytes);
        AppMethodBeat.o(2431);
    }

    public final void a(int i2, b bVar) {
        AppMethodBeat.i(2432);
        if (bVar == null) {
            AppMethodBeat.o(2432);
            return;
        }
        br(i2, 2);
        byte[] byteArray = bVar.toByteArray();
        hc(byteArray.length);
        dk(byteArray);
        AppMethodBeat.o(2432);
    }

    public final void ni(int i2, int i3) {
        AppMethodBeat.i(2433);
        br(i2, 2);
        hc(i3);
        AppMethodBeat.o(2433);
    }

    public static int r(int i2, long j2) {
        AppMethodBeat.i(2434);
        int fS = fS(i2) + aK(j2);
        AppMethodBeat.o(2434);
        return fS;
    }

    public static int bu(int i2, int i3) {
        AppMethodBeat.i(2435);
        if (i3 >= 0) {
            int fS = fS(i2) + fY(i3);
            AppMethodBeat.o(2435);
            return fS;
        }
        int fS2 = fS(i2) + 10;
        AppMethodBeat.o(2435);
        return fS2;
    }

    public static int f(int i2, String str) {
        AppMethodBeat.i(2436);
        if (str == null) {
            AppMethodBeat.o(2436);
            return 0;
        }
        try {
            byte[] bytes = str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            int length = bytes.length + fS(i2) + fY(bytes.length);
            AppMethodBeat.o(2436);
            return length;
        } catch (UnsupportedEncodingException e2) {
            IllegalStateException illegalStateException = new IllegalStateException("UTF-8 not supported.");
            AppMethodBeat.o(2436);
            throw illegalStateException;
        }
    }

    public static int b(int i2, b bVar) {
        AppMethodBeat.i(2437);
        if (bVar == null) {
            AppMethodBeat.o(2437);
            return 0;
        }
        int fS = fS(i2) + fY(bVar.zy.length) + bVar.zy.length;
        AppMethodBeat.o(2437);
        return fS;
    }

    private void l(byte b2) {
        byte[] bArr = this.buffer;
        int i2 = this.position;
        this.position = i2 + 1;
        bArr[i2] = b2;
    }

    private void dk(byte[] bArr) {
        AppMethodBeat.i(2438);
        if (bArr == null) {
            AppMethodBeat.o(2438);
            return;
        }
        s(bArr, bArr.length);
        AppMethodBeat.o(2438);
    }

    private void s(byte[] bArr, int i2) {
        AppMethodBeat.i(2439);
        if (bArr == null) {
            AppMethodBeat.o(2439);
        } else if (this.limit - this.position >= i2) {
            System.arraycopy(bArr, 0, this.buffer, this.position, i2);
            this.position += i2;
            AppMethodBeat.o(2439);
        } else {
            int i3 = this.limit - this.position;
            System.arraycopy(bArr, 0, this.buffer, this.position, i3);
            int i4 = i3 + 0;
            int i5 = i2 - i3;
            this.position = this.limit;
            if (i5 <= this.limit) {
                System.arraycopy(bArr, i4, this.buffer, 0, i5);
                this.position = i5;
            }
            AppMethodBeat.o(2439);
        }
    }

    public final void br(int i2, int i3) {
        AppMethodBeat.i(2440);
        hc(g.a.a.b.a.bA(i2, i3));
        AppMethodBeat.o(2440);
    }

    public static int fS(int i2) {
        AppMethodBeat.i(2441);
        int fY = fY(g.a.a.b.a.bA(i2, 0));
        AppMethodBeat.o(2441);
        return fY;
    }

    public final void hc(int i2) {
        AppMethodBeat.i(2442);
        while ((i2 & -128) != 0) {
            l((byte) ((i2 & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH) | 128));
            i2 >>>= 7;
        }
        l((byte) i2);
        AppMethodBeat.o(2442);
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

    public final void aJ(long j2) {
        AppMethodBeat.i(2443);
        while ((-128 & j2) != 0) {
            l((byte) ((((int) j2) & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH) | 128));
            j2 >>>= 7;
        }
        l((byte) ((int) j2));
        AppMethodBeat.o(2443);
    }

    public static int aK(long j2) {
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
