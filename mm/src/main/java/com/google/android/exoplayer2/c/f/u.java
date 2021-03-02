package com.google.android.exoplayer2.c.f;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.f.v;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class u implements e {
    public static final h bil = new h() {
        /* class com.google.android.exoplayer2.c.f.u.AnonymousClass1 */

        @Override // com.google.android.exoplayer2.c.h
        public final e[] ux() {
            AppMethodBeat.i(92287);
            e[] eVarArr = {new u()};
            AppMethodBeat.o(92287);
            return eVarArr;
        }
    };
    private static final long bss = ((long) x.bJ("AC-3"));
    private static final long bst = ((long) x.bJ("EAC3"));
    private static final long bsu = ((long) x.bJ("HEVC"));
    private g bph;
    private final SparseBooleanArray bsA;
    private int bsB;
    private boolean bsC;
    private v bsD;
    private final List<com.google.android.exoplayer2.i.u> bsv;
    private final m bsw;
    private final SparseIntArray bsx;
    private final v.c bsy;
    private final SparseArray<v> bsz;
    private final int mode;

    static /* synthetic */ int b(u uVar) {
        int i2 = uVar.bsB;
        uVar.bsB = i2 + 1;
        return i2;
    }

    static {
        AppMethodBeat.i(92299);
        AppMethodBeat.o(92299);
    }

    public u() {
        this((byte) 0);
    }

    private u(byte b2) {
        this(1, 0);
    }

    public u(int i2, int i3) {
        this(i2, new com.google.android.exoplayer2.i.u(0), new e(i3));
        AppMethodBeat.i(92292);
        AppMethodBeat.o(92292);
    }

    public u(int i2, com.google.android.exoplayer2.i.u uVar, v.c cVar) {
        AppMethodBeat.i(92293);
        this.bsy = (v.c) com.google.android.exoplayer2.i.a.checkNotNull(cVar);
        this.mode = i2;
        if (i2 == 1 || i2 == 2) {
            this.bsv = Collections.singletonList(uVar);
        } else {
            this.bsv = new ArrayList();
            this.bsv.add(uVar);
        }
        this.bsw = new m(9400);
        this.bsA = new SparseBooleanArray();
        this.bsz = new SparseArray<>();
        this.bsx = new SparseIntArray();
        uT();
        AppMethodBeat.o(92293);
    }

    @Override // com.google.android.exoplayer2.c.e
    public final boolean a(f fVar) {
        AppMethodBeat.i(92294);
        byte[] bArr = this.bsw.data;
        fVar.b(bArr, 0, 940);
        for (int i2 = 0; i2 < 188; i2++) {
            for (int i3 = 0; i3 != 5; i3++) {
                if (bArr[(i3 * 188) + i2] == 71) {
                }
            }
            fVar.dP(i2);
            AppMethodBeat.o(92294);
            return true;
        }
        AppMethodBeat.o(92294);
        return false;
    }

    @Override // com.google.android.exoplayer2.c.e
    public final void a(g gVar) {
        AppMethodBeat.i(92295);
        this.bph = gVar;
        gVar.a(new l.a(-9223372036854775807L));
        AppMethodBeat.o(92295);
    }

    @Override // com.google.android.exoplayer2.c.e
    public final void f(long j2, long j3) {
        AppMethodBeat.i(92296);
        int size = this.bsv.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.bsv.get(i2).bHG = -9223372036854775807L;
        }
        this.bsw.reset();
        this.bsx.clear();
        uT();
        AppMethodBeat.o(92296);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c0, code lost:
        if (r7 != ((r9 + 1) & 15)) goto L_0x00c2;
     */
    @Override // com.google.android.exoplayer2.c.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.google.android.exoplayer2.c.f r13, com.google.android.exoplayer2.c.k r14) {
        /*
        // Method dump skipped, instructions count: 251
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.c.f.u.a(com.google.android.exoplayer2.c.f, com.google.android.exoplayer2.c.k):int");
    }

    private void uT() {
        AppMethodBeat.i(92298);
        this.bsA.clear();
        this.bsz.clear();
        SparseArray<v> uS = this.bsy.uS();
        int size = uS.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.bsz.put(uS.keyAt(i2), uS.valueAt(i2));
        }
        this.bsz.put(0, new r(new a()));
        this.bsD = null;
        AppMethodBeat.o(92298);
    }

    /* access modifiers changed from: package-private */
    public class a implements q {
        private final com.google.android.exoplayer2.i.l bsE = new com.google.android.exoplayer2.i.l(new byte[4]);

        public a() {
            AppMethodBeat.i(92288);
            AppMethodBeat.o(92288);
        }

        @Override // com.google.android.exoplayer2.c.f.q
        public final void a(com.google.android.exoplayer2.i.u uVar, g gVar, v.d dVar) {
        }

        @Override // com.google.android.exoplayer2.c.f.q
        public final void t(m mVar) {
            AppMethodBeat.i(92289);
            if (mVar.readUnsignedByte() != 0) {
                AppMethodBeat.o(92289);
                return;
            }
            mVar.eZ(7);
            int xd = mVar.xd() / 4;
            for (int i2 = 0; i2 < xd; i2++) {
                mVar.c(this.bsE, 4);
                int em = this.bsE.em(16);
                this.bsE.en(3);
                if (em == 0) {
                    this.bsE.en(13);
                } else {
                    int em2 = this.bsE.em(13);
                    u.this.bsz.put(em2, new r(new b(em2)));
                    u.b(u.this);
                }
            }
            if (u.this.mode != 2) {
                u.this.bsz.remove(0);
            }
            AppMethodBeat.o(92289);
        }
    }

    class b implements q {
        private final com.google.android.exoplayer2.i.l bsG = new com.google.android.exoplayer2.i.l(new byte[5]);
        private final SparseArray<v> bsH = new SparseArray<>();
        private final SparseIntArray bsI = new SparseIntArray();
        private final int pid;

        public b(int i2) {
            AppMethodBeat.i(92290);
            this.pid = i2;
            AppMethodBeat.o(92290);
        }

        @Override // com.google.android.exoplayer2.c.f.q
        public final void a(com.google.android.exoplayer2.i.u uVar, g gVar, v.d dVar) {
        }

        @Override // com.google.android.exoplayer2.c.f.q
        public final void t(m mVar) {
            com.google.android.exoplayer2.i.u uVar;
            int i2;
            v a2;
            AppMethodBeat.i(92291);
            if (mVar.readUnsignedByte() != 2) {
                AppMethodBeat.o(92291);
                return;
            }
            if (u.this.mode == 1 || u.this.mode == 2 || u.this.bsB == 1) {
                uVar = (com.google.android.exoplayer2.i.u) u.this.bsv.get(0);
            } else {
                uVar = new com.google.android.exoplayer2.i.u(((com.google.android.exoplayer2.i.u) u.this.bsv.get(0)).bqk);
                u.this.bsv.add(uVar);
            }
            mVar.eZ(2);
            int readUnsignedShort = mVar.readUnsignedShort();
            mVar.eZ(5);
            mVar.c(this.bsG, 2);
            this.bsG.en(4);
            mVar.eZ(this.bsG.em(12));
            if (u.this.mode == 2 && u.this.bsD == null) {
                u.this.bsD = u.this.bsy.a(21, new v.b(21, null, null, new byte[0]));
                u.this.bsD.a(uVar, u.this.bph, new v.d(readUnsignedShort, 21, 8192));
            }
            this.bsH.clear();
            this.bsI.clear();
            int xd = mVar.xd();
            while (xd > 0) {
                mVar.c(this.bsG, 5);
                int em = this.bsG.em(8);
                this.bsG.en(3);
                int em2 = this.bsG.em(13);
                this.bsG.en(4);
                int em3 = this.bsG.em(12);
                int i3 = mVar.position;
                int i4 = i3 + em3;
                int i5 = -1;
                String str = null;
                ArrayList arrayList = null;
                while (mVar.position < i4) {
                    int readUnsignedByte = mVar.readUnsignedByte();
                    int readUnsignedByte2 = mVar.readUnsignedByte() + mVar.position;
                    if (readUnsignedByte == 5) {
                        long dE = mVar.dE();
                        if (dE == u.bss) {
                            i5 = 129;
                        } else if (dE == u.bst) {
                            i5 = c.CTRL_INDEX;
                        } else if (dE == u.bsu) {
                            i5 = 36;
                        }
                    } else if (readUnsignedByte == 106) {
                        i5 = 129;
                    } else if (readUnsignedByte == 122) {
                        i5 = c.CTRL_INDEX;
                    } else if (readUnsignedByte == 123) {
                        i5 = 138;
                    } else if (readUnsignedByte == 10) {
                        str = mVar.readString(3).trim();
                    } else if (readUnsignedByte == 89) {
                        i5 = 89;
                        arrayList = new ArrayList();
                        while (mVar.position < readUnsignedByte2) {
                            String trim = mVar.readString(3).trim();
                            int readUnsignedByte3 = mVar.readUnsignedByte();
                            byte[] bArr = new byte[4];
                            mVar.readBytes(bArr, 0, 4);
                            arrayList.add(new v.a(trim, readUnsignedByte3, bArr));
                        }
                    }
                    mVar.eZ(readUnsignedByte2 - mVar.position);
                }
                mVar.setPosition(i4);
                v.b bVar = new v.b(i5, str, arrayList, Arrays.copyOfRange(mVar.data, i3, i4));
                if (em == 6) {
                    i2 = bVar.streamType;
                } else {
                    i2 = em;
                }
                int i6 = xd - (em3 + 5);
                int i7 = u.this.mode == 2 ? i2 : em2;
                if (!u.this.bsA.get(i7)) {
                    if (u.this.mode == 2 && i2 == 21) {
                        a2 = u.this.bsD;
                    } else {
                        a2 = u.this.bsy.a(i2, bVar);
                    }
                    if (u.this.mode != 2 || em2 < this.bsI.get(i7, 8192)) {
                        this.bsI.put(i7, em2);
                        this.bsH.put(i7, a2);
                    }
                    xd = i6;
                } else {
                    xd = i6;
                }
            }
            int size = this.bsI.size();
            for (int i8 = 0; i8 < size; i8++) {
                int keyAt = this.bsI.keyAt(i8);
                u.this.bsA.put(keyAt, true);
                v valueAt = this.bsH.valueAt(i8);
                if (valueAt != null) {
                    if (valueAt != u.this.bsD) {
                        valueAt.a(uVar, u.this.bph, new v.d(readUnsignedShort, keyAt, 8192));
                    }
                    u.this.bsz.put(this.bsI.valueAt(i8), valueAt);
                }
            }
            if (u.this.mode != 2) {
                u.this.bsz.remove(this.pid);
                u.this.bsB = u.this.mode == 1 ? 0 : u.this.bsB - 1;
                if (u.this.bsB == 0) {
                    u.this.bph.uy();
                    u.this.bsC = true;
                }
            } else if (!u.this.bsC) {
                u.this.bph.uy();
                u.this.bsB = 0;
                u.this.bsC = true;
                AppMethodBeat.o(92291);
                return;
            }
            AppMethodBeat.o(92291);
        }
    }
}
