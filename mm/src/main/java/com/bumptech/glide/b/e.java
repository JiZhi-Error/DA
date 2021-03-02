package com.bumptech.glide.b;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

public class e implements a {
    private static final String TAG = e.class.getSimpleName();
    private Bitmap aEA;
    private boolean aEB;
    private int aEC;
    private int aED;
    private Boolean aEE;
    private Bitmap.Config aEF;
    private byte[] aEo;
    private ByteBuffer aEp;
    private c aEq;
    private int[] aEr;
    private final int[] aEs;
    private final a.AbstractC0062a aEt;
    private short[] aEu;
    private byte[] aEv;
    private byte[] aEw;
    private byte[] aEx;
    private int[] aEy;
    private int aEz;
    private int sampleSize;
    private int status;

    static {
        AppMethodBeat.i(3487);
        AppMethodBeat.o(3487);
    }

    public e(a.AbstractC0062a aVar, c cVar, ByteBuffer byteBuffer, int i2) {
        this(aVar);
        AppMethodBeat.i(3476);
        a(cVar, byteBuffer, i2);
        AppMethodBeat.o(3476);
    }

    private e(a.AbstractC0062a aVar) {
        AppMethodBeat.i(3477);
        this.aEs = new int[256];
        this.aEF = Bitmap.Config.ARGB_8888;
        this.aEt = aVar;
        this.aEq = new c();
        AppMethodBeat.o(3477);
    }

    @Override // com.bumptech.glide.b.a
    public final ByteBuffer getData() {
        return this.aEp;
    }

    @Override // com.bumptech.glide.b.a
    public final void advance() {
        this.aEz = (this.aEz + 1) % this.aEq.frameCount;
    }

    @Override // com.bumptech.glide.b.a
    public final int of() {
        AppMethodBeat.i(3478);
        if (this.aEq.frameCount <= 0 || this.aEz < 0) {
            AppMethodBeat.o(3478);
            return 0;
        }
        int i2 = this.aEz;
        int i3 = -1;
        if (i2 >= 0 && i2 < this.aEq.frameCount) {
            i3 = this.aEq.aEj.get(i2).delay;
        }
        AppMethodBeat.o(3478);
        return i3;
    }

    @Override // com.bumptech.glide.b.a
    public final int getFrameCount() {
        return this.aEq.frameCount;
    }

    @Override // com.bumptech.glide.b.a
    public final int og() {
        return this.aEz;
    }

    @Override // com.bumptech.glide.b.a
    public final void oh() {
        this.aEz = -1;
    }

    @Override // com.bumptech.glide.b.a
    public final int oi() {
        AppMethodBeat.i(3479);
        int limit = this.aEp.limit() + this.aEx.length + (this.aEy.length * 4);
        AppMethodBeat.o(3479);
        return limit;
    }

    @Override // com.bumptech.glide.b.a
    public final synchronized Bitmap oj() {
        Bitmap bitmap;
        b bVar;
        int[] iArr;
        AppMethodBeat.i(3480);
        if (this.aEq.frameCount <= 0 || this.aEz < 0) {
            if (Log.isLoggable(TAG, 3)) {
                new StringBuilder("Unable to decode frame, frameCount=").append(this.aEq.frameCount).append(", framePointer=").append(this.aEz);
            }
            this.status = 1;
        }
        if (this.status == 1 || this.status == 2) {
            if (Log.isLoggable(TAG, 3)) {
                new StringBuilder("Unable to decode frame, status=").append(this.status);
            }
            AppMethodBeat.o(3480);
            bitmap = null;
        } else {
            this.status = 0;
            if (this.aEo == null) {
                this.aEo = this.aEt.de(255);
            }
            b bVar2 = this.aEq.aEj.get(this.aEz);
            int i2 = this.aEz - 1;
            if (i2 >= 0) {
                bVar = this.aEq.aEj.get(i2);
            } else {
                bVar = null;
            }
            if (bVar2.aEg != null) {
                iArr = bVar2.aEg;
            } else {
                iArr = this.aEq.aEh;
            }
            this.aEr = iArr;
            if (this.aEr == null) {
                if (Log.isLoggable(TAG, 3)) {
                    new StringBuilder("No valid color table found for frame #").append(this.aEz);
                }
                this.status = 1;
                AppMethodBeat.o(3480);
                bitmap = null;
            } else {
                if (bVar2.aEc) {
                    System.arraycopy(this.aEr, 0, this.aEs, 0, this.aEr.length);
                    this.aEr = this.aEs;
                    this.aEr[bVar2.aEe] = 0;
                }
                bitmap = a(bVar2, bVar);
                AppMethodBeat.o(3480);
            }
        }
        return bitmap;
    }

    @Override // com.bumptech.glide.b.a
    public final void clear() {
        AppMethodBeat.i(3481);
        this.aEq = null;
        if (this.aEx != null) {
            this.aEt.k(this.aEx);
        }
        if (this.aEy != null) {
            this.aEt.p(this.aEy);
        }
        if (this.aEA != null) {
            this.aEt.f(this.aEA);
        }
        this.aEA = null;
        this.aEp = null;
        this.aEE = null;
        if (this.aEo != null) {
            this.aEt.k(this.aEo);
        }
        AppMethodBeat.o(3481);
    }

    private synchronized void a(c cVar, ByteBuffer byteBuffer, int i2) {
        AppMethodBeat.i(3482);
        if (i2 <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Sample size must be >=0, not: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(3482);
            throw illegalArgumentException;
        }
        int highestOneBit = Integer.highestOneBit(i2);
        this.status = 0;
        this.aEq = cVar;
        this.aEz = -1;
        this.aEp = byteBuffer.asReadOnlyBuffer();
        this.aEp.position(0);
        this.aEp.order(ByteOrder.LITTLE_ENDIAN);
        this.aEB = false;
        Iterator<b> it = cVar.aEj.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().aEd == 3) {
                    this.aEB = true;
                    break;
                }
            } else {
                break;
            }
        }
        this.sampleSize = highestOneBit;
        this.aED = cVar.width / highestOneBit;
        this.aEC = cVar.height / highestOneBit;
        this.aEx = this.aEt.de(cVar.width * cVar.height);
        this.aEy = this.aEt.df(this.aED * this.aEC);
        AppMethodBeat.o(3482);
    }

    @Override // com.bumptech.glide.b.a
    public final void a(Bitmap.Config config) {
        AppMethodBeat.i(3483);
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.aEF = config;
            AppMethodBeat.o(3483);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
        AppMethodBeat.o(3483);
        throw illegalArgumentException;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:246:0x02c1 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: short[] */
    /* JADX DEBUG: Multi-variable search result rejected for r4v84, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    private Bitmap a(b bVar, b bVar2) {
        int i2;
        boolean booleanValue;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Boolean bool;
        int i9;
        int i10;
        short s;
        int i11;
        int i12;
        AppMethodBeat.i(3484);
        int[] iArr = this.aEy;
        if (bVar2 == null) {
            if (this.aEA != null) {
                this.aEt.f(this.aEA);
            }
            this.aEA = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.aEd == 3 && this.aEA == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.aEd > 0) {
            if (bVar2.aEd == 2) {
                int i13 = 0;
                if (!bVar.aEc) {
                    i13 = this.aEq.bgColor;
                    if (bVar.aEg != null && this.aEq.aEm == bVar.aEe) {
                        i13 = 0;
                    }
                } else if (this.aEz == 0) {
                    this.aEE = Boolean.TRUE;
                }
                int i14 = bVar2.aEa / this.sampleSize;
                int i15 = bVar2.aDY / this.sampleSize;
                int i16 = bVar2.aDZ / this.sampleSize;
                int i17 = (i15 * this.aED) + (bVar2.aDX / this.sampleSize);
                int i18 = i17 + (i14 * this.aED);
                while (i17 < i18) {
                    int i19 = i17 + i16;
                    for (int i20 = i17; i20 < i19; i20++) {
                        iArr[i20] = i13;
                    }
                    i17 += this.aED;
                }
            } else if (bVar2.aEd == 3 && this.aEA != null) {
                this.aEA.getPixels(iArr, 0, this.aED, 0, 0, this.aED, this.aEC);
            }
        }
        if (bVar != null) {
            this.aEp.position(bVar.aEf);
        }
        if (bVar == null) {
            i2 = this.aEq.width * this.aEq.height;
        } else {
            i2 = bVar.aDZ * bVar.aEa;
        }
        if (this.aEx == null || this.aEx.length < i2) {
            this.aEx = this.aEt.de(i2);
        }
        byte[] bArr = this.aEx;
        if (this.aEu == null) {
            this.aEu = new short[4096];
        }
        short[] sArr = this.aEu;
        if (this.aEv == null) {
            this.aEv = new byte[4096];
        }
        byte[] bArr2 = this.aEv;
        if (this.aEw == null) {
            this.aEw = new byte[4097];
        }
        byte[] bArr3 = this.aEw;
        int oq = oq();
        int i21 = 1 << oq;
        int i22 = i21 + 1;
        int i23 = i21 + 2;
        int i24 = -1;
        int i25 = oq + 1;
        int i26 = (1 << i25) - 1;
        for (int i27 = 0; i27 < i21; i27++) {
            sArr[i27] = 0;
            bArr2[i27] = (byte) i27;
        }
        byte[] bArr4 = this.aEo;
        int i28 = 0;
        int i29 = 0;
        int i30 = 0;
        int i31 = 0;
        int i32 = 0;
        int i33 = 0;
        int i34 = 0;
        int i35 = 0;
        while (true) {
            if (i28 >= i2) {
                break;
            }
            if (i31 == 0) {
                i31 = oq();
                if (i31 > 0) {
                    this.aEp.get(this.aEo, 0, Math.min(i31, this.aEp.remaining()));
                }
                if (i31 <= 0) {
                    this.status = 3;
                    break;
                }
                i35 = 0;
            }
            int i36 = i35 + 1;
            int i37 = i31 - 1;
            i29 = ((bArr4[i35] & 255) << i30) + i29;
            i30 += 8;
            while (i30 >= i25) {
                int i38 = i29 & i26;
                i29 >>= i25;
                i30 -= i25;
                if (i38 == i21) {
                    i25 = oq + 1;
                    i26 = (1 << i25) - 1;
                    i23 = i21 + 2;
                    i24 = -1;
                } else if (i38 == i22) {
                    break;
                } else if (i24 == -1) {
                    bArr[i34] = bArr2[i38];
                    i28++;
                    i32 = i38;
                    i34++;
                    i24 = i38;
                } else {
                    if (i38 >= i23) {
                        bArr3[i33] = (byte) i32;
                        i10 = i33 + 1;
                        s = i24;
                    } else {
                        i10 = i33;
                        s = i38;
                    }
                    while (s >= i21) {
                        bArr3[i10] = bArr2[s];
                        i10++;
                        s = sArr[s];
                    }
                    i32 = bArr2[s] & 255;
                    bArr[i34] = (byte) i32;
                    int i39 = i34 + 1;
                    i28++;
                    i33 = i10;
                    while (i33 > 0) {
                        int i40 = i33 - 1;
                        bArr[i39] = bArr3[i40];
                        i39++;
                        i28++;
                        i33 = i40;
                    }
                    if (i23 < 4096) {
                        sArr[i23] = (short) i24;
                        bArr2[i23] = (byte) i32;
                        i23++;
                        if ((i23 & i26) == 0 && i23 < 4096) {
                            i11 = i25 + 1;
                            i12 = i26 + i23;
                            i34 = i39;
                            i25 = i11;
                            i24 = i38;
                            i26 = i12;
                        }
                    }
                    i11 = i25;
                    i12 = i26;
                    i34 = i39;
                    i25 = i11;
                    i24 = i38;
                    i26 = i12;
                }
            }
            i31 = i37;
            i35 = i36;
        }
        Arrays.fill(bArr, i34, i2, (byte) 0);
        if (bVar.aEb || this.sampleSize != 1) {
            int[] iArr2 = this.aEy;
            int i41 = bVar.aEa / this.sampleSize;
            int i42 = bVar.aDY / this.sampleSize;
            int i43 = bVar.aDZ / this.sampleSize;
            int i44 = bVar.aDX / this.sampleSize;
            int i45 = 1;
            int i46 = 8;
            int i47 = 0;
            boolean z = this.aEz == 0;
            int i48 = this.sampleSize;
            int i49 = this.aED;
            int i50 = this.aEC;
            byte[] bArr5 = this.aEx;
            int[] iArr3 = this.aEr;
            Boolean bool2 = this.aEE;
            int i51 = 0;
            while (i51 < i41) {
                if (bVar.aEb) {
                    if (i47 >= i41) {
                        i45++;
                        switch (i45) {
                            case 2:
                                i47 = 4;
                                break;
                            case 3:
                                i47 = 2;
                                i46 = 4;
                                break;
                            case 4:
                                i47 = 1;
                                i46 = 2;
                                break;
                        }
                    }
                    i3 = i46;
                    i4 = i47;
                    i5 = i47 + i46;
                    i6 = i45;
                } else {
                    i3 = i46;
                    i4 = i51;
                    i5 = i47;
                    i6 = i45;
                }
                int i52 = i4 + i42;
                boolean z2 = i48 == 1;
                if (i52 < i50) {
                    int i53 = i52 * i49;
                    int i54 = i53 + i44;
                    int i55 = i54 + i43;
                    if (i53 + i49 < i55) {
                        i7 = i53 + i49;
                    } else {
                        i7 = i55;
                    }
                    int i56 = bVar.aDZ * i51 * i48;
                    if (z2) {
                        Boolean bool3 = bool2;
                        while (i54 < i7) {
                            int i57 = iArr3[bArr5[i56] & 255];
                            if (i57 != 0) {
                                iArr2[i54] = i57;
                            } else if (z && bool3 == null) {
                                bool3 = Boolean.TRUE;
                            }
                            i56 += i48;
                            i54++;
                        }
                        bool2 = bool3;
                    } else {
                        int i58 = i56 + ((i7 - i54) * i48);
                        int i59 = i56;
                        for (int i60 = i54; i60 < i7; i60++) {
                            int i61 = bVar.aDZ;
                            int i62 = 0;
                            int i63 = 0;
                            int i64 = 0;
                            int i65 = 0;
                            int i66 = 0;
                            int i67 = i59;
                            while (i67 < this.sampleSize + i59 && i67 < this.aEx.length && i67 < i58) {
                                int i68 = this.aEr[this.aEx[i67] & 255];
                                if (i68 != 0) {
                                    i62 += (i68 >> 24) & 255;
                                    i63 += (i68 >> 16) & 255;
                                    i64 += (i68 >> 8) & 255;
                                    i65 += i68 & 255;
                                    i66++;
                                }
                                i67++;
                            }
                            int i69 = i59 + i61;
                            while (i69 < i59 + i61 + this.sampleSize && i69 < this.aEx.length && i69 < i58) {
                                int i70 = this.aEr[this.aEx[i69] & 255];
                                if (i70 != 0) {
                                    i62 += (i70 >> 24) & 255;
                                    i63 += (i70 >> 16) & 255;
                                    i64 += (i70 >> 8) & 255;
                                    i65 += i70 & 255;
                                    i66++;
                                }
                                i69++;
                            }
                            if (i66 == 0) {
                                i8 = 0;
                            } else {
                                i8 = ((i62 / i66) << 24) | ((i63 / i66) << 16) | ((i64 / i66) << 8) | (i65 / i66);
                            }
                            if (i8 != 0) {
                                iArr2[i60] = i8;
                                bool = bool2;
                            } else if (!z || bool2 != null) {
                                bool = bool2;
                            } else {
                                bool = Boolean.TRUE;
                            }
                            i59 += i48;
                            bool2 = bool;
                        }
                    }
                }
                i51++;
                i46 = i3;
                i47 = i5;
                i45 = i6;
            }
            if (this.aEE == null) {
                if (bool2 == null) {
                    booleanValue = false;
                } else {
                    booleanValue = bool2.booleanValue();
                }
                this.aEE = Boolean.valueOf(booleanValue);
            }
        } else {
            int[] iArr4 = this.aEy;
            int i71 = bVar.aEa;
            int i72 = bVar.aDY;
            int i73 = bVar.aDZ;
            int i74 = bVar.aDX;
            boolean z3 = this.aEz == 0;
            int i75 = this.aED;
            byte[] bArr6 = this.aEx;
            int[] iArr5 = this.aEr;
            int i76 = 0;
            byte b2 = -1;
            while (i76 < i71) {
                int i77 = (i76 + i72) * i75;
                int i78 = i77 + i74;
                int i79 = i78 + i73;
                if (i77 + i75 < i79) {
                    i9 = i77 + i75;
                } else {
                    i9 = i79;
                }
                int i80 = i76 * bVar.aDZ;
                byte b3 = b2;
                while (i78 < i9) {
                    byte b4 = bArr6[i80];
                    int i81 = b4 & 255;
                    if (i81 != b3) {
                        int i82 = iArr5[i81];
                        if (i82 != 0) {
                            iArr4[i78] = i82;
                        } else {
                            b3 = b4;
                        }
                    }
                    i80++;
                    i78++;
                }
                i76++;
                b2 = b3;
            }
            this.aEE = Boolean.valueOf(this.aEE == null && z3 && b2 != -1);
        }
        if (this.aEB && (bVar.aEd == 0 || bVar.aEd == 1)) {
            if (this.aEA == null) {
                this.aEA = or();
            }
            this.aEA.setPixels(iArr, 0, this.aED, 0, 0, this.aED, this.aEC);
        }
        Bitmap or = or();
        or.setPixels(iArr, 0, this.aED, 0, 0, this.aED, this.aEC);
        AppMethodBeat.o(3484);
        return or;
    }

    private int oq() {
        AppMethodBeat.i(3485);
        int i2 = this.aEp.get() & 255;
        AppMethodBeat.o(3485);
        return i2;
    }

    private Bitmap or() {
        AppMethodBeat.i(3486);
        Bitmap a2 = this.aEt.a(this.aED, this.aEC, (this.aEE == null || this.aEE.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.aEF);
        a2.setHasAlpha(true);
        AppMethodBeat.o(3486);
        return a2;
    }
}
