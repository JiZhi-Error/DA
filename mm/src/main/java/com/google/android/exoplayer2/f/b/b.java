package com.google.android.exoplayer2.f.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.util.SparseArray;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class b {
    private static final byte[] bBG = {0, 7, 8, 15};
    private static final byte[] bBH = {0, 119, -120, -1};
    private static final byte[] bBI = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private final Canvas aTi;
    private final Paint bBJ = new Paint();
    private final Paint bBK;
    private final C0109b bBL;
    private final a bBM;
    final h bBN;
    private Bitmap bitmap;

    public b(int i2, int i3) {
        AppMethodBeat.i(92794);
        this.bBJ.setStyle(Paint.Style.FILL_AND_STROKE);
        this.bBJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.bBJ.setPathEffect(null);
        this.bBK = new Paint();
        this.bBK.setStyle(Paint.Style.FILL);
        this.bBK.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.bBK.setPathEffect(null);
        this.aTi = new Canvas();
        this.bBL = new C0109b(719, 575, 0, 719, 0, 575);
        this.bBM = new a(0, wr(), ws(), wt());
        this.bBN = new h(i2, i3);
        AppMethodBeat.o(92794);
    }

    public final List<com.google.android.exoplayer2.f.a> g(byte[] bArr, int i2) {
        C0109b bVar;
        a aVar;
        int i3;
        c cVar;
        Paint paint;
        int[] iArr;
        int i4;
        int i5;
        int i6;
        int i7;
        AppMethodBeat.i(92795);
        l lVar = new l(bArr, i2);
        while (lVar.wZ() >= 48 && lVar.em(8) == 15) {
            h hVar = this.bBN;
            int em = lVar.em(8);
            int em2 = lVar.em(16);
            int em3 = lVar.em(16);
            int xa = lVar.xa() + em3;
            if (em3 * 8 > lVar.wZ()) {
                lVar.en(lVar.wZ());
            } else {
                switch (em) {
                    case 16:
                        if (em2 == hVar.bCp) {
                            d dVar = hVar.bCw;
                            int em4 = lVar.em(8);
                            int em5 = lVar.em(4);
                            int em6 = lVar.em(2);
                            lVar.en(2);
                            int i8 = em3 - 2;
                            SparseArray sparseArray = new SparseArray();
                            while (i8 > 0) {
                                int em7 = lVar.em(8);
                                lVar.en(8);
                                i8 -= 6;
                                sparseArray.put(em7, new e(lVar.em(16), lVar.em(16)));
                            }
                            d dVar2 = new d(em4, em5, em6, sparseArray);
                            if (dVar2.state == 0) {
                                if (!(dVar == null || dVar.version == dVar2.version)) {
                                    hVar.bCw = dVar2;
                                    break;
                                }
                            } else {
                                hVar.bCw = dVar2;
                                hVar.bBZ.clear();
                                hVar.bCr.clear();
                                hVar.bCs.clear();
                                break;
                            }
                        }
                        break;
                    case 17:
                        d dVar3 = hVar.bCw;
                        if (em2 == hVar.bCp && dVar3 != null) {
                            f a2 = a(lVar, em3);
                            if (dVar3.state == 0) {
                                a2.a(hVar.bBZ.get(a2.id));
                            }
                            hVar.bBZ.put(a2.id, a2);
                            break;
                        }
                    case 18:
                        if (em2 != hVar.bCp) {
                            if (em2 == hVar.bCq) {
                                a b2 = b(lVar, em3);
                                hVar.bCt.put(b2.id, b2);
                                break;
                            }
                        } else {
                            a b3 = b(lVar, em3);
                            hVar.bCr.put(b3.id, b3);
                            break;
                        }
                        break;
                    case 19:
                        if (em2 != hVar.bCp) {
                            if (em2 == hVar.bCq) {
                                c b4 = b(lVar);
                                hVar.bCu.put(b4.id, b4);
                                break;
                            }
                        } else {
                            c b5 = b(lVar);
                            hVar.bCs.put(b5.id, b5);
                            break;
                        }
                        break;
                    case 20:
                        if (em2 == hVar.bCp) {
                            lVar.en(4);
                            boolean uI = lVar.uI();
                            lVar.en(3);
                            int em8 = lVar.em(16);
                            int em9 = lVar.em(16);
                            if (uI) {
                                i4 = lVar.em(16);
                                i7 = lVar.em(16);
                                i5 = lVar.em(16);
                                i6 = lVar.em(16);
                            } else {
                                i4 = 0;
                                i5 = 0;
                                i6 = em9;
                                i7 = em8;
                            }
                            hVar.bCv = new C0109b(em8, em9, i4, i7, i5, i6);
                            break;
                        }
                        break;
                }
                int xa2 = xa - lVar.xa();
                com.google.android.exoplayer2.i.a.checkState(lVar.bpJ == 0);
                lVar.bpI += xa2;
                lVar.uJ();
            }
        }
        if (this.bBN.bCw == null) {
            List<com.google.android.exoplayer2.f.a> emptyList = Collections.emptyList();
            AppMethodBeat.o(92795);
            return emptyList;
        }
        if (this.bBN.bCv != null) {
            bVar = this.bBN.bCv;
        } else {
            bVar = this.bBL;
        }
        if (!(this.bitmap != null && bVar.width + 1 == this.bitmap.getWidth() && bVar.height + 1 == this.bitmap.getHeight())) {
            this.bitmap = Bitmap.createBitmap(bVar.width + 1, bVar.height + 1, Bitmap.Config.ARGB_8888);
            this.aTi.setBitmap(this.bitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray2 = this.bBN.bCw.bBZ;
        for (int i9 = 0; i9 < sparseArray2.size(); i9++) {
            e valueAt = sparseArray2.valueAt(i9);
            f fVar = this.bBN.bBZ.get(sparseArray2.keyAt(i9));
            int i10 = valueAt.bCa + bVar.bBR;
            int i11 = valueAt.bCb + bVar.bBT;
            this.aTi.clipRect((float) i10, (float) i11, (float) Math.min(fVar.width + i10, bVar.bBS), (float) Math.min(fVar.height + i11, bVar.bBU), Region.Op.REPLACE);
            a aVar2 = this.bBN.bCr.get(fVar.bCf);
            if (aVar2 == null && (aVar2 = this.bBN.bCt.get(fVar.bCf)) == null) {
                aVar = this.bBM;
            } else {
                aVar = aVar2;
            }
            SparseArray<g> sparseArray3 = fVar.bCj;
            for (int i12 = 0; i12 < sparseArray3.size(); i12++) {
                int keyAt = sparseArray3.keyAt(i12);
                g valueAt2 = sparseArray3.valueAt(i12);
                c cVar2 = this.bBN.bCs.get(keyAt);
                if (cVar2 == null) {
                    cVar = this.bBN.bCu.get(keyAt);
                } else {
                    cVar = cVar2;
                }
                if (cVar != null) {
                    if (cVar.bBV) {
                        paint = null;
                    } else {
                        paint = this.bBJ;
                    }
                    int i13 = fVar.bCe;
                    int i14 = i10 + valueAt2.bCl;
                    int i15 = i11 + valueAt2.bCm;
                    Canvas canvas = this.aTi;
                    if (i13 == 3) {
                        iArr = aVar.bBQ;
                    } else if (i13 == 2) {
                        iArr = aVar.bBP;
                    } else {
                        iArr = aVar.bBO;
                    }
                    a(cVar.bBW, iArr, i13, i14, i15, paint, canvas);
                    a(cVar.bBX, iArr, i13, i14, i15 + 1, paint, canvas);
                }
            }
            if (fVar.bCc) {
                if (fVar.bCe == 3) {
                    i3 = aVar.bBQ[fVar.bCg];
                } else if (fVar.bCe == 2) {
                    i3 = aVar.bBP[fVar.bCh];
                } else {
                    i3 = aVar.bBO[fVar.bCi];
                }
                this.bBK.setColor(i3);
                this.aTi.drawRect((float) i10, (float) i11, (float) (fVar.width + i10), (float) (fVar.height + i11), this.bBK);
            }
            arrayList.add(new com.google.android.exoplayer2.f.a(Bitmap.createBitmap(this.bitmap, i10, i11, fVar.width, fVar.height), ((float) i10) / ((float) bVar.width), ((float) i11) / ((float) bVar.height), ((float) fVar.width) / ((float) bVar.width), ((float) fVar.height) / ((float) bVar.height)));
            this.aTi.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        AppMethodBeat.o(92795);
        return arrayList;
    }

    private static f a(l lVar, int i2) {
        AppMethodBeat.i(92796);
        int em = lVar.em(8);
        lVar.en(4);
        boolean uI = lVar.uI();
        lVar.en(3);
        int em2 = lVar.em(16);
        int em3 = lVar.em(16);
        int em4 = lVar.em(3);
        int em5 = lVar.em(3);
        lVar.en(2);
        int em6 = lVar.em(8);
        int em7 = lVar.em(8);
        int em8 = lVar.em(4);
        int em9 = lVar.em(2);
        lVar.en(2);
        int i3 = i2 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i3 > 0) {
            int em10 = lVar.em(16);
            int em11 = lVar.em(2);
            int em12 = lVar.em(2);
            int em13 = lVar.em(12);
            lVar.en(4);
            int em14 = lVar.em(12);
            int i4 = i3 - 6;
            int i5 = 0;
            int i6 = 0;
            if (em11 == 1 || em11 == 2) {
                i5 = lVar.em(8);
                i6 = lVar.em(8);
                i4 -= 2;
            }
            i3 = i4;
            sparseArray.put(em10, new g(em11, em12, em13, em14, i5, i6));
        }
        f fVar = new f(em, uI, em2, em3, em4, em5, em6, em7, em8, em9, sparseArray);
        AppMethodBeat.o(92796);
        return fVar;
    }

    private static a b(l lVar, int i2) {
        int[] iArr;
        int em;
        int em2;
        int em3;
        int em4;
        AppMethodBeat.i(92797);
        int em5 = lVar.em(8);
        lVar.en(8);
        int i3 = i2 - 2;
        int[] wr = wr();
        int[] ws = ws();
        int[] wt = wt();
        while (i3 > 0) {
            int em6 = lVar.em(8);
            int em7 = lVar.em(8);
            int i4 = i3 - 2;
            if ((em7 & 128) != 0) {
                iArr = wr;
            } else if ((em7 & 64) != 0) {
                iArr = ws;
            } else {
                iArr = wt;
            }
            if ((em7 & 1) != 0) {
                em = lVar.em(8);
                em2 = lVar.em(8);
                em3 = lVar.em(8);
                em4 = lVar.em(8);
                i3 = i4 - 4;
            } else {
                em = lVar.em(6) << 2;
                em2 = lVar.em(4) << 4;
                em3 = lVar.em(4) << 4;
                em4 = lVar.em(2) << 6;
                i3 = i4 - 2;
            }
            if (em == 0) {
                em2 = 0;
                em3 = 0;
                em4 = 255;
            }
            iArr[em6] = n((byte) (255 - (em4 & 255)), x.s((int) (((double) em) + (1.402d * ((double) (em2 - 128)))), 0, 255), x.s((int) ((((double) em) - (0.34414d * ((double) (em3 - 128)))) - (0.71414d * ((double) (em2 - 128)))), 0, 255), x.s((int) (((double) em) + (1.772d * ((double) (em3 - 128)))), 0, 255));
        }
        a aVar = new a(em5, wr, ws, wt);
        AppMethodBeat.o(92797);
        return aVar;
    }

    private static c b(l lVar) {
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3 = null;
        AppMethodBeat.i(92798);
        int em = lVar.em(16);
        lVar.en(4);
        int em2 = lVar.em(2);
        boolean uI = lVar.uI();
        lVar.en(1);
        if (em2 == 1) {
            lVar.en(lVar.em(8) * 16);
            bArr = null;
            bArr2 = null;
        } else if (em2 == 0) {
            int em3 = lVar.em(16);
            int em4 = lVar.em(16);
            if (em3 > 0) {
                bArr3 = new byte[em3];
                lVar.p(bArr3, em3);
            }
            if (em4 > 0) {
                bArr = new byte[em4];
                lVar.p(bArr, em4);
                bArr2 = bArr3;
            } else {
                bArr = bArr3;
                bArr2 = bArr3;
            }
        } else {
            bArr = null;
            bArr2 = null;
        }
        c cVar = new c(em, uI, bArr2, bArr);
        AppMethodBeat.o(92798);
        return cVar;
    }

    private static int[] wr() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    private static int[] ws() {
        AppMethodBeat.i(92799);
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i2 = 1; i2 < 16; i2++) {
            if (i2 < 8) {
                iArr[i2] = n(255, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) != 0 ? 255 : 0);
            } else {
                iArr[i2] = n(255, (i2 & 1) != 0 ? 127 : 0, (i2 & 2) != 0 ? 127 : 0, (i2 & 4) != 0 ? 127 : 0);
            }
        }
        AppMethodBeat.o(92799);
        return iArr;
    }

    private static int[] wt() {
        AppMethodBeat.i(92800);
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            if (i2 < 8) {
                iArr[i2] = n(63, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) != 0 ? 255 : 0);
            } else {
                switch (i2 & r.CTRL_INDEX) {
                    case 0:
                        iArr[i2] = n(255, ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0), ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0), ((i2 & 64) != 0 ? 170 : 0) + ((i2 & 4) != 0 ? 85 : 0));
                        continue;
                    case 8:
                        iArr[i2] = n(TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH, ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0), ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0), ((i2 & 64) != 0 ? 170 : 0) + ((i2 & 4) != 0 ? 85 : 0));
                        continue;
                    case 128:
                        iArr[i2] = n(255, ((i2 & 1) != 0 ? 43 : 0) + TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 64) != 0 ? 85 : 0) + ((i2 & 4) != 0 ? 43 : 0) + TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH);
                        continue;
                    case r.CTRL_INDEX /*{ENCODED_INT: 136}*/:
                        iArr[i2] = n(255, ((i2 & 1) != 0 ? 43 : 0) + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 64) != 0 ? 85 : 0) + ((i2 & 4) != 0 ? 43 : 0));
                        continue;
                }
            }
        }
        AppMethodBeat.o(92800);
        return iArr;
    }

    private static int n(int i2, int i3, int i4, int i5) {
        return (i2 << 24) | (i3 << 16) | (i4 << 8) | i5;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0040 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:54:0x00e8 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r1v59 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r1v97 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r1v108 */
    /* JADX WARN: Type inference failed for: r1v109 */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(byte[] r14, int[] r15, int r16, int r17, int r18, android.graphics.Paint r19, android.graphics.Canvas r20) {
        /*
        // Method dump skipped, instructions count: 568
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.f.b.b.a(byte[], int[], int, int, int, android.graphics.Paint, android.graphics.Canvas):void");
    }

    private static byte[] a(int i2, int i3, l lVar) {
        AppMethodBeat.i(92802);
        byte[] bArr = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) lVar.em(i3);
        }
        AppMethodBeat.o(92802);
        return bArr;
    }

    static final class h {
        public final SparseArray<f> bBZ = new SparseArray<>();
        public final int bCp;
        public final int bCq;
        public final SparseArray<a> bCr = new SparseArray<>();
        public final SparseArray<c> bCs = new SparseArray<>();
        public final SparseArray<a> bCt = new SparseArray<>();
        public final SparseArray<c> bCu = new SparseArray<>();
        public C0109b bCv;
        public d bCw;

        public h(int i2, int i3) {
            AppMethodBeat.i(92793);
            this.bCp = i2;
            this.bCq = i3;
            AppMethodBeat.o(92793);
        }
    }

    /* renamed from: com.google.android.exoplayer2.f.b.b$b  reason: collision with other inner class name */
    static final class C0109b {
        public final int bBR;
        public final int bBS;
        public final int bBT;
        public final int bBU;
        public final int height;
        public final int width;

        public C0109b(int i2, int i3, int i4, int i5, int i6, int i7) {
            this.width = i2;
            this.height = i3;
            this.bBR = i4;
            this.bBS = i5;
            this.bBT = i6;
            this.bBU = i7;
        }
    }

    static final class d {
        public final int bBY;
        public final SparseArray<e> bBZ;
        public final int state;
        public final int version;

        public d(int i2, int i3, int i4, SparseArray<e> sparseArray) {
            this.bBY = i2;
            this.version = i3;
            this.state = i4;
            this.bBZ = sparseArray;
        }
    }

    static final class e {
        public final int bCa;
        public final int bCb;

        public e(int i2, int i3) {
            this.bCa = i2;
            this.bCb = i3;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class f {
        public final boolean bCc;
        public final int bCd;
        public final int bCe;
        public final int bCf;
        public final int bCg;
        public final int bCh;
        public final int bCi;
        public final SparseArray<g> bCj;
        public final int height;
        public final int id;
        public final int width;

        public f(int i2, boolean z, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, SparseArray<g> sparseArray) {
            this.id = i2;
            this.bCc = z;
            this.width = i3;
            this.height = i4;
            this.bCd = i5;
            this.bCe = i6;
            this.bCf = i7;
            this.bCg = i8;
            this.bCh = i9;
            this.bCi = i10;
            this.bCj = sparseArray;
        }

        public final void a(f fVar) {
            AppMethodBeat.i(92792);
            if (fVar == null) {
                AppMethodBeat.o(92792);
                return;
            }
            SparseArray<g> sparseArray = fVar.bCj;
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                this.bCj.put(sparseArray.keyAt(i2), sparseArray.valueAt(i2));
            }
            AppMethodBeat.o(92792);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class g {
        public final int bCk;
        public final int bCl;
        public final int bCm;
        public final int bCn;
        public final int bCo;
        public final int type;

        public g(int i2, int i3, int i4, int i5, int i6, int i7) {
            this.type = i2;
            this.bCk = i3;
            this.bCl = i4;
            this.bCm = i5;
            this.bCn = i6;
            this.bCo = i7;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        public final int[] bBO;
        public final int[] bBP;
        public final int[] bBQ;
        public final int id;

        public a(int i2, int[] iArr, int[] iArr2, int[] iArr3) {
            this.id = i2;
            this.bBO = iArr;
            this.bBP = iArr2;
            this.bBQ = iArr3;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c {
        public final boolean bBV;
        public final byte[] bBW;
        public final byte[] bBX;
        public final int id;

        public c(int i2, boolean z, byte[] bArr, byte[] bArr2) {
            this.id = i2;
            this.bBV = z;
            this.bBW = bArr;
            this.bBX = bArr2;
        }
    }
}
