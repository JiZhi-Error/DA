package g.a.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.io.InputStream;
import java.util.LinkedList;

public final class a {
    private int TDu = 0;
    private int bNq = 67108864;
    private int bNt = 0;
    private int bNv = 0;
    private int bNx = Integer.MAX_VALUE;
    private byte[] buffer;
    private int bufferSize;
    private int cbm;
    private InputStream input;

    public final int yT() {
        AppMethodBeat.i(168737);
        if (this.cbm != this.bufferSize || Fd(false)) {
            this.bNv = zi();
            if (this.bNv == 0) {
                b hPs = b.hPs();
                AppMethodBeat.o(168737);
                throw hPs;
            }
            int i2 = this.bNv;
            AppMethodBeat.o(168737);
            return i2;
        }
        this.bNv = 0;
        AppMethodBeat.o(168737);
        return 0;
    }

    public final LinkedList<Integer> hPm() {
        AppMethodBeat.i(2410);
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (this.cbm < this.bufferSize) {
            linkedList.add(Integer.valueOf(zi()));
        }
        AppMethodBeat.o(2410);
        return linkedList;
    }

    public final LinkedList<Long> hPn() {
        AppMethodBeat.i(183559);
        LinkedList<Long> linkedList = new LinkedList<>();
        while (this.cbm < this.bufferSize) {
            linkedList.add(Long.valueOf(zl()));
        }
        AppMethodBeat.o(183559);
        return linkedList;
    }

    public final boolean yZ() {
        AppMethodBeat.i(2411);
        if (zi() != 0) {
            AppMethodBeat.o(2411);
            return true;
        }
        AppMethodBeat.o(2411);
        return false;
    }

    public final LinkedList<byte[]> awh(int i2) {
        AppMethodBeat.i(2412);
        LinkedList<byte[]> linkedList = new LinkedList<>();
        int zi = zi();
        try {
            byte[] bArr = new byte[zi];
            System.arraycopy(this.buffer, this.cbm, bArr, 0, zi);
            linkedList.add(bArr);
            this.cbm = zi + this.cbm;
            int i3 = this.cbm;
            if (this.cbm == this.bufferSize) {
                AppMethodBeat.o(2412);
                return linkedList;
            }
            while (true) {
                int[] awi = awi(i3);
                if (g.a.a.b.a.gY(awi[0]) != i2) {
                    break;
                }
                this.cbm = awi[1];
                int zi2 = zi();
                byte[] bArr2 = new byte[zi2];
                System.arraycopy(this.buffer, this.cbm, bArr2, 0, zi2);
                linkedList.add(bArr2);
                this.cbm = zi2 + this.cbm;
                if (this.cbm == this.bufferSize) {
                    break;
                }
                i3 = this.cbm;
            }
            AppMethodBeat.o(2412);
            return linkedList;
        } catch (OutOfMemoryError e2) {
            OutOfMemoryError outOfMemoryError = new OutOfMemoryError("alloc bytes:".concat(String.valueOf(zi)));
            AppMethodBeat.o(2412);
            throw outOfMemoryError;
        }
    }

    public final String readString() {
        AppMethodBeat.i(2413);
        int zi = zi();
        if (zi >= this.bufferSize - this.cbm || zi <= 0) {
            String str = new String(ha(zi), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            AppMethodBeat.o(2413);
            return str;
        }
        String str2 = new String(this.buffer, this.cbm, zi, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        this.cbm = zi + this.cbm;
        AppMethodBeat.o(2413);
        return str2;
    }

    public final b hPo() {
        AppMethodBeat.i(2414);
        int zi = zi();
        if (zi >= this.bufferSize - this.cbm || zi <= 0) {
            b cD = b.cD(ha(zi));
            AppMethodBeat.o(2414);
            return cD;
        }
        b Q = b.Q(this.buffer, this.cbm, zi);
        this.cbm = zi + this.cbm;
        AppMethodBeat.o(2414);
        return Q;
    }

    public final int zi() {
        AppMethodBeat.i(2416);
        int zq = zq();
        if (zq >= 0) {
            AppMethodBeat.o(2416);
        } else {
            int i2 = zq & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH;
            byte zq2 = zq();
            if (zq2 >= 0) {
                zq = i2 | (zq2 << 7);
            } else {
                int i3 = i2 | ((zq2 & Byte.MAX_VALUE) << 7);
                byte zq3 = zq();
                if (zq3 >= 0) {
                    zq = i3 | (zq3 << 14);
                } else {
                    int i4 = i3 | ((zq3 & Byte.MAX_VALUE) << 14);
                    byte zq4 = zq();
                    if (zq4 >= 0) {
                        zq = i4 | (zq4 << 21);
                    } else {
                        int i5 = i4 | ((zq4 & Byte.MAX_VALUE) << 21);
                        byte zq5 = zq();
                        zq = i5 | (zq5 << 28);
                        if (zq5 < 0) {
                            for (int i6 = 0; i6 < 5; i6++) {
                                if (zq() >= 0) {
                                    AppMethodBeat.o(2416);
                                }
                            }
                            b hPr = b.hPr();
                            AppMethodBeat.o(2416);
                            throw hPr;
                        }
                    }
                }
            }
            AppMethodBeat.o(2416);
        }
        return zq;
    }

    public final long zl() {
        AppMethodBeat.i(2417);
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte zq = zq();
            j2 |= ((long) (zq & Byte.MAX_VALUE)) << i2;
            if ((zq & 128) == 0) {
                AppMethodBeat.o(2417);
                return j2;
            }
        }
        b hPr = b.hPr();
        AppMethodBeat.o(2417);
        throw hPr;
    }

    public final int zm() {
        AppMethodBeat.i(2418);
        int zq = (zq() & 255) | ((zq() & 255) << 8) | ((zq() & 255) << 16) | ((zq() & 255) << 24);
        AppMethodBeat.o(2418);
        return zq;
    }

    public final long zn() {
        AppMethodBeat.i(2419);
        byte zq = zq();
        byte zq2 = zq();
        long j2 = (((long) zq2) & 255) << 8;
        long zq3 = j2 | (((long) zq) & 255) | ((((long) zq()) & 255) << 16) | ((((long) zq()) & 255) << 24) | ((((long) zq()) & 255) << 32) | ((((long) zq()) & 255) << 40) | ((((long) zq()) & 255) << 48) | ((((long) zq()) & 255) << 56);
        AppMethodBeat.o(2419);
        return zq3;
    }

    public a(byte[] bArr, int i2) {
        AppMethodBeat.i(2420);
        this.buffer = bArr;
        this.bufferSize = i2 + 0;
        this.cbm = 0;
        this.input = null;
        AppMethodBeat.o(2420);
    }

    private void zo() {
        this.bufferSize += this.bNt;
        int i2 = this.TDu + this.bufferSize;
        if (i2 > this.bNx) {
            this.bNt = i2 - this.bNx;
            this.bufferSize -= this.bNt;
            return;
        }
        this.bNt = 0;
    }

    private boolean Fd(boolean z) {
        AppMethodBeat.i(2421);
        if (this.cbm < this.bufferSize) {
            IllegalStateException illegalStateException = new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
            AppMethodBeat.o(2421);
            throw illegalStateException;
        } else if (this.TDu + this.bufferSize != this.bNx) {
            this.TDu += this.bufferSize;
            this.cbm = 0;
            this.bufferSize = this.input == null ? -1 : this.input.read(this.buffer);
            if (this.bufferSize == -1) {
                this.bufferSize = 0;
                if (z) {
                    b hPp = b.hPp();
                    AppMethodBeat.o(2421);
                    throw hPp;
                }
                AppMethodBeat.o(2421);
                return false;
            }
            zo();
            int i2 = this.TDu + this.bufferSize + this.bNt;
            if (i2 > this.bNq || i2 < 0) {
                b hPt = b.hPt();
                AppMethodBeat.o(2421);
                throw hPt;
            }
            AppMethodBeat.o(2421);
            return true;
        } else if (z) {
            b hPp2 = b.hPp();
            AppMethodBeat.o(2421);
            throw hPp2;
        } else {
            AppMethodBeat.o(2421);
            return false;
        }
    }

    private byte zq() {
        AppMethodBeat.i(2422);
        if (this.cbm == this.bufferSize) {
            Fd(true);
        }
        byte[] bArr = this.buffer;
        int i2 = this.cbm;
        this.cbm = i2 + 1;
        byte b2 = bArr[i2];
        AppMethodBeat.o(2422);
        return b2;
    }

    private byte[] ha(int i2) {
        AppMethodBeat.i(2423);
        if (i2 < 0) {
            b hPq = b.hPq();
            AppMethodBeat.o(2423);
            throw hPq;
        } else if (this.TDu + this.cbm + i2 > this.bNx) {
            fJ((this.bNx - this.TDu) - this.cbm);
            b hPp = b.hPp();
            AppMethodBeat.o(2423);
            throw hPp;
        } else if (i2 <= this.bufferSize - this.cbm) {
            byte[] bArr = new byte[i2];
            System.arraycopy(this.buffer, this.cbm, bArr, 0, i2);
            this.cbm += i2;
            AppMethodBeat.o(2423);
            return bArr;
        } else if (i2 < 2048) {
            byte[] bArr2 = new byte[i2];
            int i3 = this.bufferSize - this.cbm;
            System.arraycopy(this.buffer, this.cbm, bArr2, 0, i3);
            this.cbm = this.bufferSize;
            Fd(true);
            while (i2 - i3 > this.bufferSize) {
                System.arraycopy(this.buffer, 0, bArr2, i3, this.bufferSize);
                i3 += this.bufferSize;
                this.cbm = this.bufferSize;
                Fd(true);
            }
            System.arraycopy(this.buffer, 0, bArr2, i3, i2 - i3);
            this.cbm = i2 - i3;
            AppMethodBeat.o(2423);
            return bArr2;
        } else {
            int i4 = this.cbm;
            int i5 = this.bufferSize;
            this.TDu += this.bufferSize;
            this.cbm = 0;
            this.bufferSize = 0;
            LinkedList linkedList = new LinkedList();
            int i6 = i2 - (i5 - i4);
            while (i6 > 0) {
                byte[] bArr3 = new byte[Math.min(i6, 2048)];
                int i7 = 0;
                while (i7 < bArr3.length) {
                    int read = this.input == null ? -1 : this.input.read(bArr3, i7, bArr3.length - i7);
                    if (read == -1) {
                        b hPp2 = b.hPp();
                        AppMethodBeat.o(2423);
                        throw hPp2;
                    }
                    this.TDu += read;
                    i7 += read;
                }
                linkedList.add(bArr3);
                i6 -= bArr3.length;
            }
            byte[] bArr4 = new byte[i2];
            int i8 = i5 - i4;
            System.arraycopy(this.buffer, i4, bArr4, 0, i8);
            int i9 = i8;
            for (int i10 = 0; i10 < linkedList.size(); i10++) {
                byte[] bArr5 = (byte[]) linkedList.get(i10);
                System.arraycopy(bArr5, 0, bArr4, i9, bArr5.length);
                i9 += bArr5.length;
            }
            AppMethodBeat.o(2423);
            return bArr4;
        }
    }

    private void fJ(int i2) {
        AppMethodBeat.i(2424);
        if (i2 < 0) {
            b hPq = b.hPq();
            AppMethodBeat.o(2424);
            throw hPq;
        } else if (this.TDu + this.cbm + i2 > this.bNx) {
            fJ((this.bNx - this.TDu) - this.cbm);
            b hPp = b.hPp();
            AppMethodBeat.o(2424);
            throw hPp;
        } else if (i2 < this.bufferSize - this.cbm) {
            this.cbm += i2;
            AppMethodBeat.o(2424);
        } else {
            int i3 = this.bufferSize - this.cbm;
            this.TDu += i3;
            this.cbm = 0;
            this.bufferSize = 0;
            int i4 = i3;
            while (i4 < i2) {
                int skip = this.input == null ? -1 : (int) this.input.skip((long) (i2 - i4));
                if (skip <= 0) {
                    b hPp2 = b.hPp();
                    AppMethodBeat.o(2424);
                    throw hPp2;
                }
                i4 += skip;
                this.TDu = skip + this.TDu;
            }
            AppMethodBeat.o(2424);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: byte */
    /* JADX DEBUG: Multi-variable search result rejected for r1v10, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: byte */
    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: int[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v16, resolved type: int[] */
    /* JADX WARN: Multi-variable type inference failed */
    private int[] awi(int i2) {
        int i3;
        int i4;
        AppMethodBeat.i(2415);
        byte b2 = this.buffer[i2];
        int i5 = i2 + 1;
        if (b2 >= 0) {
            int[] iArr = {b2, i5};
            AppMethodBeat.o(2415);
            return iArr;
        }
        int i6 = b2 & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH;
        byte b3 = this.buffer[i5];
        if (b3 >= 0) {
            i4 = i5 + 1;
            i3 = i6 | (b3 << 7);
        } else {
            int i7 = i6 | ((b3 & Byte.MAX_VALUE) << 7);
            byte b4 = this.buffer[i5];
            if (b4 >= 0) {
                i4 = i5 + 1;
                i3 = i7 | (b4 << 14);
            } else {
                int i8 = i7 | ((b4 & Byte.MAX_VALUE) << 14);
                byte b5 = this.buffer[i5];
                if (b5 >= 0) {
                    i4 = i5 + 1;
                    i3 = i8 | (b5 << 21);
                } else {
                    int i9 = i8 | ((b5 & Byte.MAX_VALUE) << 21);
                    byte b6 = this.buffer[i5];
                    i3 = i9 | (b6 << 28);
                    i4 = i5 + 1;
                    if (b6 < 0) {
                        for (int i10 = 0; i10 < 5; i10++) {
                            if (this.buffer[i4] >= 0) {
                                int[] iArr2 = {b6, i4 + 1};
                                AppMethodBeat.o(2415);
                                return iArr2;
                            }
                        }
                        b hPr = b.hPr();
                        AppMethodBeat.o(2415);
                        throw hPr;
                    }
                }
            }
        }
        int[] iArr3 = {i3, i4};
        AppMethodBeat.o(2415);
        return iArr3;
    }
}
