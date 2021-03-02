package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e.h;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TimeUtil;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* access modifiers changed from: package-private */
public final class b extends h {
    g bpb;
    private a bpc;

    b() {
    }

    public static boolean r(m mVar) {
        AppMethodBeat.i(92145);
        if (mVar.xd() >= 5 && mVar.readUnsignedByte() == 127 && mVar.dE() == 1179402563) {
            AppMethodBeat.o(92145);
            return true;
        }
        AppMethodBeat.o(92145);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c.e.h
    public final void reset(boolean z) {
        AppMethodBeat.i(92146);
        super.reset(z);
        if (z) {
            this.bpb = null;
            this.bpc = null;
        }
        AppMethodBeat.o(92146);
    }

    private static boolean t(byte[] bArr) {
        return bArr[0] == -1;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c.e.h
    public final long s(m mVar) {
        int i2;
        int i3;
        AppMethodBeat.i(92147);
        if (!t(mVar.data)) {
            AppMethodBeat.o(92147);
            return -1;
        }
        int i4 = (mVar.data[2] & 255) >> 4;
        switch (i4) {
            case 1:
                i2 = 192;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                i2 = 576 << (i4 - 2);
                break;
            case 6:
            case 7:
                mVar.eZ(4);
                long j2 = (long) mVar.data[mVar.position];
                int i5 = 7;
                while (true) {
                    if (i5 >= 0) {
                        if ((((long) (1 << i5)) & j2) != 0) {
                            i5--;
                        } else if (i5 < 6) {
                            j2 &= (long) ((1 << i5) - 1);
                            i3 = 7 - i5;
                        } else if (i5 == 7) {
                            i3 = 1;
                        }
                    }
                }
                i3 = 0;
                if (i3 != 0) {
                    for (int i6 = 1; i6 < i3; i6++) {
                        byte b2 = mVar.data[mVar.position + i6];
                        if ((b2 & 192) != 128) {
                            NumberFormatException numberFormatException = new NumberFormatException("Invalid UTF-8 sequence continuation byte: ".concat(String.valueOf(j2)));
                            AppMethodBeat.o(92147);
                            throw numberFormatException;
                        }
                        j2 = (j2 << 6) | ((long) (b2 & 63));
                    }
                    mVar.position += i3;
                    int readUnsignedByte = i4 == 6 ? mVar.readUnsignedByte() : mVar.readUnsignedShort();
                    mVar.setPosition(0);
                    i2 = readUnsignedByte + 1;
                    break;
                } else {
                    NumberFormatException numberFormatException2 = new NumberFormatException("Invalid UTF-8 sequence first byte: ".concat(String.valueOf(j2)));
                    AppMethodBeat.o(92147);
                    throw numberFormatException2;
                }
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                i2 = 256 << (i4 - 8);
                break;
            default:
                i2 = -1;
                break;
        }
        long j3 = (long) i2;
        AppMethodBeat.o(92147);
        return j3;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c.e.h
    public final boolean a(m mVar, long j2, h.a aVar) {
        AppMethodBeat.i(92148);
        byte[] bArr = mVar.data;
        if (this.bpb == null) {
            this.bpb = new g(bArr);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 9, mVar.limit);
            copyOfRange[4] = Byte.MIN_VALUE;
            List singletonList = Collections.singletonList(copyOfRange);
            g gVar = this.bpb;
            aVar.bdF = Format.a(null, "audio/flac", -1, gVar.sampleRate * gVar.bsU, this.bpb.channels, this.bpb.sampleRate, singletonList, null, null);
        } else if ((bArr[0] & Byte.MAX_VALUE) == 3) {
            this.bpc = new a();
            a aVar2 = this.bpc;
            mVar.eZ(1);
            int xf = mVar.xf() / 18;
            aVar2.bpd = new long[xf];
            aVar2.bpe = new long[xf];
            for (int i2 = 0; i2 < xf; i2++) {
                aVar2.bpd[i2] = mVar.readLong();
                aVar2.bpe[i2] = mVar.readLong();
                mVar.eZ(2);
            }
        } else if (t(bArr)) {
            if (this.bpc != null) {
                this.bpc.firstFrameOffset = j2;
                aVar.bpA = this.bpc;
            }
            AppMethodBeat.o(92148);
            return false;
        }
        AppMethodBeat.o(92148);
        return true;
    }

    class a implements f, l {
        long[] bpd;
        long[] bpe;
        private long bpf = -1;
        long firstFrameOffset = -1;

        public a() {
        }

        @Override // com.google.android.exoplayer2.c.e.f
        public final long i(f fVar) {
            if (this.bpf < 0) {
                return -1;
            }
            long j2 = -(this.bpf + 2);
            this.bpf = -1;
            return j2;
        }

        @Override // com.google.android.exoplayer2.c.e.f
        public final long R(long j2) {
            AppMethodBeat.i(92143);
            long T = b.this.T(j2);
            this.bpf = this.bpd[x.a(this.bpd, T, true)];
            AppMethodBeat.o(92143);
            return T;
        }

        @Override // com.google.android.exoplayer2.c.e.f
        public final l uH() {
            return this;
        }

        @Override // com.google.android.exoplayer2.c.l
        public final boolean uu() {
            return true;
        }

        @Override // com.google.android.exoplayer2.c.l
        public final long L(long j2) {
            AppMethodBeat.i(92144);
            int a2 = x.a(this.bpd, b.this.T(j2), true);
            long j3 = this.bpe[a2] + this.firstFrameOffset;
            AppMethodBeat.o(92144);
            return j3;
        }

        @Override // com.google.android.exoplayer2.c.l
        public final long getDurationUs() {
            g gVar = b.this.bpb;
            return (gVar.bHe * TimeUtil.SECOND_TO_US) / ((long) gVar.sampleRate);
        }
    }
}
