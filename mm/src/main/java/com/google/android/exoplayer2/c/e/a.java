package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;

/* access modifiers changed from: package-private */
public final class a implements f {
    final long bmy;
    private final e boR = new e();
    final long boS;
    final h boT;
    long boU;
    private long boV;
    private long boW;
    private long boX;
    private long boY;
    private long boZ;
    private long start;
    private int state;

    public a(long j2, long j3, h hVar, int i2, long j4) {
        AppMethodBeat.i(92137);
        com.google.android.exoplayer2.i.a.checkArgument(j2 >= 0 && j3 > j2);
        this.boT = hVar;
        this.boS = j2;
        this.bmy = j3;
        if (((long) i2) == j3 - j2) {
            this.boU = j4;
            this.state = 3;
            AppMethodBeat.o(92137);
            return;
        }
        this.state = 0;
        AppMethodBeat.o(92137);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.exoplayer2.c.e.f
    public final long i(f fVar) {
        long j2;
        long a2;
        int i2 = 1;
        AppMethodBeat.i(92138);
        switch (this.state) {
            case 0:
                this.boV = fVar.getPosition();
                this.state = 1;
                long j3 = this.bmy - 65307;
                if (j3 > this.boV) {
                    AppMethodBeat.o(92138);
                    return j3;
                }
                break;
            case 1:
                break;
            case 2:
                if (this.boW == 0) {
                    a2 = 0;
                } else {
                    long j4 = this.boW;
                    if (this.start == this.boX) {
                        j2 = -(this.boY + 2);
                    } else {
                        long position = fVar.getPosition();
                        if (a(fVar, this.boX)) {
                            this.boR.c(fVar, false);
                            fVar.uv();
                            long j5 = j4 - this.boR.bpp;
                            int i3 = this.boR.bkI + this.boR.bpu;
                            if (j5 < 0 || j5 > 72000) {
                                if (j5 < 0) {
                                    this.boX = position;
                                    this.boZ = this.boR.bpp;
                                } else {
                                    this.start = fVar.getPosition() + ((long) i3);
                                    this.boY = this.boR.bpp;
                                    if ((this.boX - this.start) + ((long) i3) < 100000) {
                                        fVar.dP(i3);
                                        j2 = -(this.boY + 2);
                                    }
                                }
                                if (this.boX - this.start < 100000) {
                                    this.boX = this.start;
                                    j2 = this.start;
                                } else {
                                    if (j5 <= 0) {
                                        i2 = 2;
                                    }
                                    j2 = Math.min(Math.max((fVar.getPosition() - ((long) (i2 * i3))) + ((j5 * (this.boX - this.start)) / (this.boZ - this.boY)), this.start), this.boX - 1);
                                }
                            } else {
                                fVar.dP(i3);
                                j2 = -(this.boR.bpp + 2);
                            }
                        } else if (this.start == position) {
                            IOException iOException = new IOException("No ogg page can be found.");
                            AppMethodBeat.o(92138);
                            throw iOException;
                        } else {
                            j2 = this.start;
                        }
                    }
                    if (j2 >= 0) {
                        AppMethodBeat.o(92138);
                        return j2;
                    }
                    a2 = a(fVar, this.boW, -(j2 + 2));
                }
                this.state = 3;
                long j6 = -(a2 + 2);
                AppMethodBeat.o(92138);
                return j6;
            case 3:
                AppMethodBeat.o(92138);
                return -1;
            default:
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.o(92138);
                throw illegalStateException;
        }
        if (!a(fVar, this.bmy)) {
            EOFException eOFException = new EOFException();
            AppMethodBeat.o(92138);
            throw eOFException;
        }
        this.boR.reset();
        while ((this.boR.type & 4) != 4 && fVar.getPosition() < this.bmy) {
            this.boR.c(fVar, false);
            fVar.dP(this.boR.bkI + this.boR.bpu);
        }
        this.boU = this.boR.bpp;
        this.state = 3;
        long j7 = this.boV;
        AppMethodBeat.o(92138);
        return j7;
    }

    @Override // com.google.android.exoplayer2.c.e.f
    public final long R(long j2) {
        AppMethodBeat.i(92139);
        com.google.android.exoplayer2.i.a.checkArgument(this.state == 3 || this.state == 2);
        this.boW = j2 == 0 ? 0 : this.boT.T(j2);
        this.state = 2;
        this.start = this.boS;
        this.boX = this.bmy;
        this.boY = 0;
        this.boZ = this.boU;
        long j3 = this.boW;
        AppMethodBeat.o(92139);
        return j3;
    }

    /* renamed from: com.google.android.exoplayer2.c.e.a$a  reason: collision with other inner class name */
    class C0103a implements l {
        private C0103a() {
        }

        /* synthetic */ C0103a(a aVar, byte b2) {
            this();
        }

        @Override // com.google.android.exoplayer2.c.l
        public final boolean uu() {
            return true;
        }

        @Override // com.google.android.exoplayer2.c.l
        public final long L(long j2) {
            AppMethodBeat.i(92135);
            if (j2 == 0) {
                long j3 = a.this.boS;
                AppMethodBeat.o(92135);
                return j3;
            }
            long T = a.this.boT.T(j2);
            a aVar = a.this;
            long j4 = (((T * (aVar.bmy - aVar.boS)) / aVar.boU) - 30000) + a.this.boS;
            if (j4 < aVar.boS) {
                j4 = aVar.boS;
            }
            if (j4 >= aVar.bmy) {
                j4 = aVar.bmy - 1;
            }
            AppMethodBeat.o(92135);
            return j4;
        }

        @Override // com.google.android.exoplayer2.c.l
        public final long getDurationUs() {
            AppMethodBeat.i(92136);
            long S = a.this.boT.S(a.this.boU);
            AppMethodBeat.o(92136);
            return S;
        }
    }

    private boolean a(f fVar, long j2) {
        int i2 = 2048;
        AppMethodBeat.i(92140);
        long min = Math.min(3 + j2, this.bmy);
        byte[] bArr = new byte[2048];
        while (true) {
            if (fVar.getPosition() + ((long) i2) <= min || (i2 = (int) (min - fVar.getPosition())) >= 4) {
                fVar.b(bArr, 0, i2, false);
                for (int i3 = 0; i3 < i2 - 3; i3++) {
                    if (bArr[i3] == 79 && bArr[i3 + 1] == 103 && bArr[i3 + 2] == 103 && bArr[i3 + 3] == 83) {
                        fVar.dP(i3);
                        AppMethodBeat.o(92140);
                        return true;
                    }
                }
                fVar.dP(i2 - 3);
            } else {
                AppMethodBeat.o(92140);
                return false;
            }
        }
    }

    private long a(f fVar, long j2, long j3) {
        AppMethodBeat.i(92141);
        this.boR.c(fVar, false);
        while (this.boR.bpp < j2) {
            fVar.dP(this.boR.bkI + this.boR.bpu);
            j3 = this.boR.bpp;
            this.boR.c(fVar, false);
        }
        fVar.uv();
        AppMethodBeat.o(92141);
        return j3;
    }

    @Override // com.google.android.exoplayer2.c.e.f
    public final /* synthetic */ l uH() {
        AppMethodBeat.i(92142);
        if (this.boU != 0) {
            C0103a aVar = new C0103a(this, (byte) 0);
            AppMethodBeat.o(92142);
            return aVar;
        }
        AppMethodBeat.o(92142);
        return null;
    }
}
