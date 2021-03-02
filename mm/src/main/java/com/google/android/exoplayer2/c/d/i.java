package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i {
    private static final int[] bon = {x.bJ("isom"), x.bJ("iso2"), x.bJ("iso3"), x.bJ("iso4"), x.bJ("iso5"), x.bJ("iso6"), x.bJ("avc1"), x.bJ("hvc1"), x.bJ("hev1"), x.bJ("mp41"), x.bJ("mp42"), x.bJ("3g2a"), x.bJ("3g2b"), x.bJ("3gr6"), x.bJ("3gs6"), x.bJ("3ge6"), x.bJ("3gg6"), x.bJ("M4V "), x.bJ("M4A "), x.bJ("f4v "), x.bJ("kddi"), x.bJ("M4VP"), x.bJ("qt  "), x.bJ("MSNV")};

    static {
        AppMethodBeat.i(92128);
        AppMethodBeat.o(92128);
    }

    public static boolean g(f fVar) {
        AppMethodBeat.i(92124);
        boolean b2 = b(fVar, true);
        AppMethodBeat.o(92124);
        return b2;
    }

    public static boolean h(f fVar) {
        AppMethodBeat.i(92125);
        boolean b2 = b(fVar, false);
        AppMethodBeat.o(92125);
        return b2;
    }

    private static boolean b(f fVar, boolean z) {
        AppMethodBeat.i(92126);
        long length = fVar.getLength();
        if (length == -1 || length > 4096) {
            length = 4096;
        }
        int i2 = (int) length;
        m mVar = new m(64);
        boolean z2 = false;
        boolean z3 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            int i4 = 8;
            mVar.reset(8);
            fVar.b(mVar.data, 0, 8);
            long dE = mVar.dE();
            int readInt = mVar.readInt();
            if (dE == 1) {
                i4 = 16;
                fVar.b(mVar.data, 8, 8);
                mVar.eY(16);
                dE = mVar.xm();
            } else if (dE == 0) {
                long length2 = fVar.getLength();
                if (length2 != -1) {
                    dE = (length2 - fVar.getPosition()) + 8;
                }
            }
            if (dE >= ((long) i4)) {
                i3 += i4;
                if (readInt != a.blk) {
                    if (readInt != a.blt && readInt != a.blv) {
                        if ((((long) i3) + dE) - ((long) i4) >= ((long) i2)) {
                            break;
                        }
                        int i5 = (int) (dE - ((long) i4));
                        int i6 = i3 + i5;
                        if (readInt != a.bkJ) {
                            if (i5 != 0) {
                                fVar.dQ(i5);
                            }
                            i3 = i6;
                        } else if (i5 < 8) {
                            AppMethodBeat.o(92126);
                            return false;
                        } else {
                            mVar.reset(i5);
                            fVar.b(mVar.data, 0, i5);
                            int i7 = i5 / 4;
                            int i8 = 0;
                            while (true) {
                                if (i8 >= i7) {
                                    break;
                                }
                                if (i8 == 1) {
                                    mVar.eZ(4);
                                } else if (eh(mVar.readInt())) {
                                    z2 = true;
                                    break;
                                }
                                i8++;
                            }
                            if (!z2) {
                                AppMethodBeat.o(92126);
                                return false;
                            }
                            i3 = i6;
                        }
                    } else {
                        z3 = true;
                    }
                }
            } else {
                AppMethodBeat.o(92126);
                return false;
            }
        }
        if (!z2 || z != z3) {
            AppMethodBeat.o(92126);
            return false;
        }
        AppMethodBeat.o(92126);
        return true;
    }

    private static boolean eh(int i2) {
        AppMethodBeat.i(92127);
        if ((i2 >>> 8) == x.bJ("3gp")) {
            AppMethodBeat.o(92127);
            return true;
        }
        for (int i3 : bon) {
            if (i3 == i2) {
                AppMethodBeat.o(92127);
                return true;
            }
        }
        AppMethodBeat.o(92127);
        return false;
    }
}
