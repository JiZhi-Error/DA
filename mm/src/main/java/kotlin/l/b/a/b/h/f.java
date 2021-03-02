package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class f {
    private int TDw = 0;
    private final byte[] buffer;
    private final int limit;
    private final OutputStream output;
    private int position;

    private f(OutputStream outputStream, byte[] bArr) {
        AppMethodBeat.i(59400);
        this.output = outputStream;
        this.buffer = bArr;
        this.position = 0;
        this.limit = bArr.length;
        AppMethodBeat.o(59400);
    }

    public static f f(OutputStream outputStream, int i2) {
        AppMethodBeat.i(59401);
        f fVar = new f(outputStream, new byte[i2]);
        AppMethodBeat.o(59401);
        return fVar;
    }

    public final void bs(int i2, int i3) {
        AppMethodBeat.i(59402);
        br(i2, 0);
        fK(i3);
        AppMethodBeat.o(59402);
    }

    public final void EJ(boolean z) {
        AppMethodBeat.i(59403);
        br(3, 0);
        be(z);
        AppMethodBeat.o(59403);
    }

    public final void a(int i2, q qVar) {
        AppMethodBeat.i(59404);
        br(i2, 2);
        b(qVar);
        AppMethodBeat.o(59404);
    }

    public final void a(int i2, d dVar) {
        AppMethodBeat.i(59405);
        br(i2, 2);
        b(dVar);
        AppMethodBeat.o(59405);
    }

    public final void nb(int i2, int i3) {
        AppMethodBeat.i(59406);
        br(i2, 0);
        fK(i3);
        AppMethodBeat.o(59406);
    }

    public final void b(int i2, q qVar) {
        AppMethodBeat.i(59407);
        br(1, 3);
        br(2, 0);
        hc(i2);
        a(3, qVar);
        br(1, 4);
        AppMethodBeat.o(59407);
    }

    public final void f(double d2) {
        AppMethodBeat.i(59408);
        Pj(Double.doubleToRawLongBits(d2));
        AppMethodBeat.o(59408);
    }

    public final void ad(float f2) {
        AppMethodBeat.i(59409);
        avB(Float.floatToRawIntBits(f2));
        AppMethodBeat.o(59409);
    }

    public final void fK(int i2) {
        AppMethodBeat.i(59410);
        if (i2 >= 0) {
            hc(i2);
            AppMethodBeat.o(59410);
            return;
        }
        aJ((long) i2);
        AppMethodBeat.o(59410);
    }

    public final void be(boolean z) {
        int i2;
        AppMethodBeat.i(59411);
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        l((byte) i2);
        AppMethodBeat.o(59411);
    }

    public final void ca(String str) {
        AppMethodBeat.i(59412);
        byte[] bytes = str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        hc(bytes.length);
        s(bytes, bytes.length);
        AppMethodBeat.o(59412);
    }

    public final void b(q qVar) {
        AppMethodBeat.i(59413);
        hc(qVar.yC());
        qVar.a(this);
        AppMethodBeat.o(59413);
    }

    public final void b(d dVar) {
        AppMethodBeat.i(59414);
        hc(dVar.size());
        e(dVar);
        AppMethodBeat.o(59414);
    }

    public final void dj(byte[] bArr) {
        AppMethodBeat.i(59415);
        hc(bArr.length);
        s(bArr, bArr.length);
        AppMethodBeat.o(59415);
    }

    public final void fM(int i2) {
        AppMethodBeat.i(59416);
        hc(fX(i2));
        AppMethodBeat.o(59416);
    }

    public final void aw(long j2) {
        AppMethodBeat.i(59417);
        aJ(aC(j2));
        AppMethodBeat.o(59417);
    }

    public static int bu(int i2, int i3) {
        AppMethodBeat.i(59418);
        int fS = fS(i2) + fT(i3);
        AppMethodBeat.o(59418);
        return fS;
    }

    public static int c(int i2, q qVar) {
        AppMethodBeat.i(59419);
        int fS = fS(i2) + c(qVar);
        AppMethodBeat.o(59419);
        return fS;
    }

    public static int c(d dVar) {
        AppMethodBeat.i(59420);
        int fS = fS(6) + d(dVar);
        AppMethodBeat.o(59420);
        return fS;
    }

    public static int bv(int i2, int i3) {
        AppMethodBeat.i(59421);
        int fS = fS(i2) + fT(i3);
        AppMethodBeat.o(59421);
        return fS;
    }

    public static int Pi(long j2) {
        AppMethodBeat.i(59422);
        int fS = fS(2) + aK(aC(j2));
        AppMethodBeat.o(59422);
        return fS;
    }

    public static int fT(int i2) {
        AppMethodBeat.i(59423);
        if (i2 >= 0) {
            int fY = fY(i2);
            AppMethodBeat.o(59423);
            return fY;
        }
        AppMethodBeat.o(59423);
        return 10;
    }

    public static int cb(String str) {
        AppMethodBeat.i(59424);
        try {
            byte[] bytes = str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            int length = bytes.length + fY(bytes.length);
            AppMethodBeat.o(59424);
            return length;
        } catch (UnsupportedEncodingException e2) {
            RuntimeException runtimeException = new RuntimeException("UTF-8 not supported.", e2);
            AppMethodBeat.o(59424);
            throw runtimeException;
        }
    }

    public static int c(q qVar) {
        AppMethodBeat.i(59425);
        int yC = qVar.yC();
        int fY = yC + fY(yC);
        AppMethodBeat.o(59425);
        return fY;
    }

    public static int a(m mVar) {
        AppMethodBeat.i(59426);
        int yC = mVar.yC();
        int fY = yC + fY(yC);
        AppMethodBeat.o(59426);
        return fY;
    }

    public static int d(d dVar) {
        AppMethodBeat.i(59427);
        int fY = fY(dVar.size()) + dVar.size();
        AppMethodBeat.o(59427);
        return fY;
    }

    public static int D(byte[] bArr) {
        AppMethodBeat.i(59428);
        int fY = fY(bArr.length) + bArr.length;
        AppMethodBeat.o(59428);
        return fY;
    }

    private void hJu() {
        AppMethodBeat.i(59429);
        if (this.output == null) {
            a aVar = new a();
            AppMethodBeat.o(59429);
            throw aVar;
        }
        this.output.write(this.buffer, 0, this.position);
        this.position = 0;
        AppMethodBeat.o(59429);
    }

    public final void flush() {
        AppMethodBeat.i(59430);
        if (this.output != null) {
            hJu();
        }
        AppMethodBeat.o(59430);
    }

    public static class a extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private void l(byte b2) {
        AppMethodBeat.i(59431);
        if (this.position == this.limit) {
            hJu();
        }
        byte[] bArr = this.buffer;
        int i2 = this.position;
        this.position = i2 + 1;
        bArr[i2] = b2;
        this.TDw++;
        AppMethodBeat.o(59431);
    }

    public final void e(d dVar) {
        AppMethodBeat.i(59432);
        a(dVar, dVar.size());
        AppMethodBeat.o(59432);
    }

    private void s(byte[] bArr, int i2) {
        AppMethodBeat.i(59433);
        if (this.limit - this.position >= i2) {
            System.arraycopy(bArr, 0, this.buffer, this.position, i2);
            this.position += i2;
        } else {
            int i3 = this.limit - this.position;
            System.arraycopy(bArr, 0, this.buffer, this.position, i3);
            int i4 = i3 + 0;
            i2 -= i3;
            this.position = this.limit;
            this.TDw = i3 + this.TDw;
            hJu();
            if (i2 <= this.limit) {
                System.arraycopy(bArr, i4, this.buffer, 0, i2);
                this.position = i2;
            } else {
                this.output.write(bArr, i4, i2);
            }
        }
        this.TDw += i2;
        AppMethodBeat.o(59433);
    }

    private void a(d dVar, int i2) {
        AppMethodBeat.i(59434);
        if (this.limit - this.position >= i2) {
            dVar.j(this.buffer, 0, this.position, i2);
            this.position += i2;
        } else {
            int i3 = this.limit - this.position;
            dVar.j(this.buffer, 0, this.position, i3);
            int i4 = i3 + 0;
            i2 -= i3;
            this.position = this.limit;
            this.TDw = i3 + this.TDw;
            hJu();
            if (i2 <= this.limit) {
                dVar.j(this.buffer, i4, 0, i2);
                this.position = i2;
            } else {
                dVar.a(this.output, i4, i2);
            }
        }
        this.TDw += i2;
        AppMethodBeat.o(59434);
    }

    public final void br(int i2, int i3) {
        AppMethodBeat.i(59435);
        hc(z.bA(i2, i3));
        AppMethodBeat.o(59435);
    }

    public static int fS(int i2) {
        AppMethodBeat.i(59436);
        int fY = fY(z.bA(i2, 0));
        AppMethodBeat.o(59436);
        return fY;
    }

    public final void hc(int i2) {
        AppMethodBeat.i(59437);
        while ((i2 & -128) != 0) {
            l((byte) ((i2 & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH) | 128));
            i2 >>>= 7;
        }
        l((byte) i2);
        AppMethodBeat.o(59437);
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
        AppMethodBeat.i(59438);
        while ((-128 & j2) != 0) {
            l((byte) ((((int) j2) & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH) | 128));
            j2 >>>= 7;
        }
        l((byte) ((int) j2));
        AppMethodBeat.o(59438);
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

    public final void avB(int i2) {
        AppMethodBeat.i(59439);
        l((byte) (i2 & 255));
        l((byte) ((i2 >> 8) & 255));
        l((byte) ((i2 >> 16) & 255));
        l((byte) ((i2 >> 24) & 255));
        AppMethodBeat.o(59439);
    }

    public final void Pj(long j2) {
        AppMethodBeat.i(59440);
        l((byte) (((int) j2) & 255));
        l((byte) (((int) (j2 >> 8)) & 255));
        l((byte) (((int) (j2 >> 16)) & 255));
        l((byte) (((int) (j2 >> 24)) & 255));
        l((byte) (((int) (j2 >> 32)) & 255));
        l((byte) (((int) (j2 >> 40)) & 255));
        l((byte) (((int) (j2 >> 48)) & 255));
        l((byte) (((int) (j2 >> 56)) & 255));
        AppMethodBeat.o(59440);
    }

    public static int fX(int i2) {
        return (i2 << 1) ^ (i2 >> 31);
    }

    public static long aC(long j2) {
        return (j2 << 1) ^ (j2 >> 63);
    }
}
