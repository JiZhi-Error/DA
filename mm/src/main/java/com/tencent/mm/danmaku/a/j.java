package com.tencent.mm.danmaku.a;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.b.a;
import com.tencent.mm.danmaku.c.m;
import com.tencent.mm.danmaku.d.c;
import com.tencent.mm.danmaku.d.f;
import com.tencent.mm.danmaku.d.h;
import com.tencent.mm.danmaku.e.d;
import com.tencent.mm.danmaku.e.e;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j extends a {
    protected int gOE;
    private int gOF;
    private int[] gOG;
    private a[] gOH;
    private List<List<a>> gOI;

    protected j(com.tencent.mm.danmaku.c.a aVar, b bVar, Comparator<a> comparator, f fVar, c cVar) {
        super(aVar, bVar, comparator, fVar, cVar);
    }

    @Override // com.tencent.mm.danmaku.a.a
    public final void arP() {
        int ceil;
        AppMethodBeat.i(241669);
        m asO = com.tencent.mm.danmaku.c.a.asO();
        this.gOE = asO.gPH;
        if (this.gOG == null || this.gOF != asO.gOF) {
            this.gOF = asO.gOF;
            this.gOG = new int[this.gOF];
            a[] aVarArr = new a[this.gOF];
            if (this.gOH != null) {
                System.arraycopy(this.gOH, 0, aVarArr, 0, Math.min(aVarArr.length, this.gOH.length));
            }
            this.gOH = aVarArr;
            if (this.gOI != null) {
                int size = this.gOI.size();
                if (size >= this.gOF) {
                    while (true) {
                        size--;
                        if (size < this.gOF) {
                            break;
                        }
                        this.gOI.remove(size);
                    }
                } else {
                    while (size < this.gOF) {
                        this.gOI.add(new LinkedList());
                        size++;
                    }
                }
            } else {
                this.gOI = new ArrayList(this.gOF);
                for (int i2 = 0; i2 < this.gOF; i2++) {
                    this.gOI.add(new LinkedList());
                }
            }
        }
        com.tencent.mm.danmaku.c.a aVar = this.gNt;
        if (aVar.gPy != null) {
            ceil = aVar.gPy.asU();
        } else {
            ceil = (int) Math.ceil((double) d.a(com.tencent.mm.danmaku.c.a.asO()));
        }
        StringBuilder sb = new StringBuilder("[");
        int i3 = 0;
        while (i3 < this.gOF) {
            this.gOG[i3] = (i3 * ceil) + this.gOE;
            sb.append(this.gOG[i3]).append(i3 != this.gOF + -1 ? ", " : "");
            i3++;
        }
        sb.append("]");
        e.d("Danmaku_R2LWindow", "reloadConfig, mRowCount = %d, mMarginTop = %d, lineHeight = %d, lineTops = %s", Integer.valueOf(this.gOF), Integer.valueOf(this.gOE), Integer.valueOf(ceil), sb);
        a(this.gOI, this.gOG);
        a(this.gOI, this.gOG);
        AppMethodBeat.o(241669);
    }

    private void a(List<List<a>> list, int[] iArr) {
        AppMethodBeat.i(241670);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Iterator<a> it = list.get(i2).iterator();
            while (it.hasNext()) {
                com.tencent.mm.danmaku.b.d dVar = (com.tencent.mm.danmaku.b.d) it.next();
                dVar.asu();
                long j2 = this.gNw.gQv;
                int i3 = (int) dVar.mLeft;
                b(dVar);
                dVar.ze(j2 - ((long) ((int) (((float) (com.tencent.mm.danmaku.b.d.getScreenWidth() - i3)) / (-(-dVar.gPj))))));
                dVar.mTop = (float) iArr[i2];
                dVar.mLeft = (float) i3;
            }
        }
        AppMethodBeat.o(241670);
    }

    private void a(a aVar, int i2) {
        AppMethodBeat.i(241672);
        aVar.asI();
        aVar.a((float) i2, this.gNv.gQA, this.gNw.gQv);
        AppMethodBeat.o(241672);
    }

    private void ast() {
        AppMethodBeat.i(241673);
        int size = this.gOI.size();
        for (int i2 = 0; i2 < size; i2++) {
            Iterator<a> it = this.gOI.get(i2).iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.yZ(this.gNw.gQv) || !next.isShown()) {
                    if (next == this.gOH[i2]) {
                        this.gOH[i2] = null;
                    }
                    it.remove();
                    this.gNo--;
                    this.gNq.add(next);
                }
            }
        }
        AppMethodBeat.o(241673);
    }

    @Override // com.tencent.mm.danmaku.a.a
    public final void i(Canvas canvas) {
        AppMethodBeat.i(241674);
        int size = this.gOI.size();
        for (int i2 = 0; i2 < size; i2++) {
            for (a aVar : this.gOI.get(i2)) {
                aVar.x(this.gNw.gQw, this.gNw.gQv);
                if (!aVar.za(this.gNw.gQv)) {
                    a(canvas, aVar);
                }
            }
        }
        AppMethodBeat.o(241674);
    }

    @Override // com.tencent.mm.danmaku.a.a
    public final void arQ() {
        AppMethodBeat.i(241675);
        for (int i2 = 0; i2 < this.gOF; i2++) {
            this.gOH[i2] = null;
        }
        int size = this.gOI.size();
        for (int i3 = 0; i3 < size; i3++) {
            Iterator<a> it = this.gOI.get(i3).iterator();
            while (it.hasNext()) {
                it.remove();
                this.gNo--;
                this.gNq.add(it.next());
            }
        }
        AppMethodBeat.o(241675);
    }

    @Override // com.tencent.mm.danmaku.a.a
    public final a a(h hVar) {
        boolean z;
        AppMethodBeat.i(241676);
        int size = this.gOI.size();
        for (int i2 = 0; i2 < size; i2++) {
            for (a aVar : this.gOI.get(i2)) {
                if (a.asF()) {
                    float f2 = (float) hVar.mPoint.x;
                    float f3 = (float) hVar.mPoint.y;
                    float f4 = (float) hVar.gQF;
                    float[] zd = aVar.zd(hVar.mTime);
                    if (zd == null || zd[0] > f2 || f2 > f4 + zd[2] || zd[1] > f3 || f3 > zd[3]) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        if (e.gQV >= 5) {
                            e.v("Danmaku_R2LWindow", "onClick:", aVar, "[left:", Float.valueOf(aVar.getLeft()), ",top:", Float.valueOf(aVar.getTop()), "]");
                        }
                        AppMethodBeat.o(241676);
                        return aVar;
                    }
                }
            }
        }
        e.v("Danmaku_R2LWindow", "onClick:null");
        AppMethodBeat.o(241676);
        return null;
    }

    @Override // com.tencent.mm.danmaku.a.a
    public final void layout() {
        boolean z;
        int oX;
        boolean z2;
        int i2;
        int i3;
        AppMethodBeat.i(241671);
        com.tencent.mm.danmaku.c.a.asO();
        if (e.gQV >= 5) {
            e.d("Danmaku_R2LWindow", Integer.valueOf(this.gNp.size()));
        }
        Iterator it = this.gNp.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            a aVar = (a) it.next();
            it.remove();
            if (!aVar.yZ(this.gNw.gQv) && !aVar.yY(this.gNv.gQA)) {
                Iterator<List<a>> it2 = this.gOI.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next().contains(aVar)) {
                            e.d("Danmaku_R2LWindow", aVar, " is repeat");
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    if (!aVar.asx()) {
                        h.a(this.gNt, aVar);
                    }
                    int oY = aVar.oY(this.gOF);
                    if (oY >= 0) {
                        oX = oY;
                    } else {
                        oX = aVar.oX(this.gOF);
                    }
                    int i5 = Integer.MAX_VALUE;
                    int i6 = oY >= 0 ? oX + 1 : this.gOF + oX;
                    e.d("Danmaku_R2LWindow", "startLayout, startLine = " + oX + ", maxLine = " + i6 + ", danmaku = " + aVar);
                    int i7 = i4;
                    while (true) {
                        if (oX >= i6) {
                            z2 = false;
                            i4 = i7;
                            break;
                        }
                        int i8 = oX;
                        while (i8 >= this.gOF) {
                            i8 -= this.gOF;
                        }
                        if (e.gQV >= 5) {
                            e.d("Danmaku_R2LWindow", aVar, " try layout");
                            for (int i9 = 0; i9 < this.gOF; i9++) {
                                e.d("Danmaku_R2LWindow", "row " + i9 + (this.gOH[i9] == null ? " null" : this.gOH[i9]));
                            }
                        }
                        if (this.gOH[i8] == null) {
                            this.gOH[i8] = aVar;
                            this.gOI.get(i8).add(aVar);
                            this.gNo++;
                            a(aVar, this.gOG[i8]);
                            if (e.gQV >= 4) {
                                e.d("Danmaku_R2LWindow", aVar, " layout success:", Integer.valueOf(i8), ",top:", Integer.valueOf(this.gOG[i8]));
                            }
                            z2 = true;
                            i4 = i7;
                        } else {
                            if (!this.gOH[i8].isPaused()) {
                                int a2 = com.tencent.mm.danmaku.e.c.a(this.gOH[i8], aVar, this.gNw.gQv);
                                if (a2 < i5) {
                                    i3 = i8;
                                } else {
                                    a2 = i5;
                                    i3 = i7;
                                }
                                if (a2 < 0) {
                                    this.gOH[i8] = aVar;
                                    this.gOI.get(i8).add(aVar);
                                    this.gNo++;
                                    a(aVar, this.gOG[i8]);
                                    if (e.gQV >= 4) {
                                        e.d("Danmaku_R2LWindow", aVar, " layout success:", Integer.valueOf(i8), ",top:", this.gOG[i8] + ", hitTime = " + a2);
                                    }
                                    z2 = true;
                                    i5 = a2;
                                    i4 = i3;
                                } else {
                                    i2 = a2;
                                }
                            } else {
                                i2 = i5;
                                i3 = i7;
                            }
                            oX++;
                            i5 = i2;
                            i7 = i3;
                        }
                    }
                    if (!z2 && aVar.oW(i5)) {
                        this.gOH[i4] = aVar;
                        this.gOI.get(i4).add(aVar);
                        this.gNo++;
                        a(aVar, this.gOG[i4]);
                        if (e.gQV >= 4) {
                            e.d("Danmaku_R2LWindow", aVar, " layout success:", Integer.valueOf(i4), ",top:", this.gOG[i4] + ", danmakuRepeatTime = " + aVar.asD());
                        }
                        z2 = true;
                    }
                    if (!z2) {
                        this.gNq.add(aVar);
                        if (e.gQV >= 4) {
                            e.d("Danmaku_R2LWindow", aVar, " can not in window");
                        }
                    }
                    if (aVar.asM() && z2) {
                        e.d("Danmaku_R2LWindow", "must show danmaku layout success :".concat(String.valueOf(aVar)));
                    }
                }
            }
            if (e.gQV >= 5) {
                e.d("Danmaku_R2LWindow", aVar, " is out side");
            }
            this.gNq.add(aVar);
        }
        ast();
        AppMethodBeat.o(241671);
    }
}
