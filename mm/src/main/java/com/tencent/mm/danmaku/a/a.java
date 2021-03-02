package com.tencent.mm.danmaku.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.mm.danmaku.c.m;
import com.tencent.mm.danmaku.d.c;
import com.tencent.mm.danmaku.d.f;
import com.tencent.mm.danmaku.d.h;
import com.tencent.mm.danmaku.render.b;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public abstract class a {
    protected int gNo;
    protected final TreeSet<com.tencent.mm.danmaku.b.a> gNp;
    protected final List<com.tencent.mm.danmaku.b.a> gNq = new LinkedList();
    protected final b gNr;
    private ArrayList<Object> gNs;
    protected com.tencent.mm.danmaku.c.a gNt;
    protected b gNu;
    protected f gNv;
    protected c gNw;

    public abstract com.tencent.mm.danmaku.b.a a(h hVar);

    public abstract void arQ();

    public abstract void i(Canvas canvas);

    public abstract void layout();

    public static a a(com.tencent.mm.danmaku.c.a aVar, b bVar, Comparator<com.tencent.mm.danmaku.b.a> comparator, f fVar, c cVar) {
        return new j(aVar, bVar, comparator, fVar, cVar);
    }

    protected a(com.tencent.mm.danmaku.c.a aVar, b bVar, Comparator<com.tencent.mm.danmaku.b.a> comparator, f fVar, c cVar) {
        this.gNt = aVar;
        this.gNu = bVar;
        this.gNv = fVar;
        this.gNw = cVar;
        this.gNr = new b(bVar);
        this.gNp = new TreeSet<>(comparator);
        arP();
    }

    public void arP() {
    }

    public final void a(com.tencent.mm.danmaku.b.a aVar) {
        this.gNp.add(aVar);
    }

    public final void b(com.tencent.mm.danmaku.b.a aVar) {
        aVar.gPe = true;
        aVar.gPd = true;
        float asB = aVar.asB();
        h.a(this.gNt, aVar);
        aVar.aj((aVar.asB() + ((float) com.tencent.mm.danmaku.b.a.getScreenWidth())) / (asB + ((float) com.tencent.mm.danmaku.b.a.getScreenWidth())));
    }

    public final void h(Canvas canvas) {
        i(canvas);
        if (this.gNs != null && canvas != null) {
            Iterator<Object> it = this.gNs.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(Canvas canvas, com.tencent.mm.danmaku.b.a aVar) {
        Bitmap asJ;
        boolean z;
        com.tencent.mm.danmaku.render.a e2 = this.gNt.e(aVar);
        b bVar = this.gNr;
        com.tencent.mm.danmaku.c.a aVar2 = this.gNt;
        if (canvas != null) {
            if (aVar.asI()) {
                b bVar2 = bVar.gNu;
                if (aVar == null) {
                    throw new RuntimeException("fetchBitmapCache NullPointException, BaseDanmaku is null");
                }
                if (aVar.gPe) {
                    asJ = aVar.asJ();
                    if (asJ == null) {
                        asJ = bVar2.gNx.getBitmap((int) aVar.asB(), (int) aVar.asC());
                    } else if (asJ.getWidth() < ((int) aVar.asB()) || asJ.getHeight() < ((int) aVar.asC())) {
                        bVar2.gNx.x(asJ);
                        asJ = bVar2.gNx.getBitmap((int) aVar.asB(), (int) aVar.asC());
                    }
                    aVar.w(asJ);
                    if (asJ == null) {
                        asJ = null;
                    } else {
                        Canvas asK = aVar.asK();
                        if (asK == null) {
                            asK = new Canvas(asJ);
                            aVar.m(asK);
                        } else {
                            asK.setBitmap(asJ);
                        }
                        asJ.eraseColor(0);
                        aVar.gPe = false;
                        aVar2.e(aVar).a(asK, aVar, (float) com.tencent.mm.danmaku.c.a.asO().gPJ, (float) com.tencent.mm.danmaku.c.a.asO().gPI);
                    }
                } else {
                    asJ = aVar.asJ();
                }
                if (asJ == null) {
                    z = false;
                } else {
                    int save = canvas.save();
                    bVar.gPU.set(0, 0, (int) aVar.asB(), (int) aVar.asC());
                    bVar.gPV.set((int) aVar.getLeft(), (int) aVar.getTop(), (int) aVar.getRight(), (int) aVar.getBottom());
                    canvas.drawBitmap(asJ, bVar.gPU, bVar.gPV, bVar.gPW);
                    canvas.restoreToCount(save);
                    z = true;
                }
                if (!z) {
                    m.asX();
                }
            }
            int save2 = canvas.save();
            e2.a(canvas, aVar, aVar.asG(), aVar.asH());
            canvas.restoreToCount(save2);
        }
        aVar.ako();
    }

    public final int arR() {
        return this.gNo;
    }

    public final List<com.tencent.mm.danmaku.b.a> arS() {
        return this.gNq;
    }

    public final void arT() {
        this.gNq.clear();
    }
}
