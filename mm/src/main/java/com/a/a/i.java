package com.a.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.util.Base64;
import com.a.a.b;
import com.a.a.f;
import com.a.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* access modifiers changed from: package-private */
public final class i {
    private static HashSet<String> aTo = null;
    private h aSO;
    private Canvas aTi;
    float aTj;
    g aTk;
    private Stack<g> aTl;
    private Stack<h.aj> aTm;
    private Stack<Matrix> aTn;
    private b.p aTp = null;

    static /* synthetic */ boolean d(i iVar) {
        AppMethodBeat.i(206646);
        boolean visible = iVar.visible();
        AppMethodBeat.o(206646);
        return visible;
    }

    static /* synthetic */ void rr() {
    }

    /* access modifiers changed from: package-private */
    public class g {
        h.ae aPk;
        h.b aQb;
        h.b aQc;
        boolean aTG;
        boolean aTH;
        Paint aTI;
        Paint aTJ;
        boolean aTK;

        g() {
            AppMethodBeat.i(206573);
            this.aTI = new Paint();
            this.aTI.setFlags(193);
            if (Build.VERSION.SDK_INT >= 14) {
                this.aTI.setHinting(0);
            }
            this.aTI.setStyle(Paint.Style.FILL);
            this.aTI.setTypeface(Typeface.DEFAULT);
            this.aTJ = new Paint();
            this.aTJ.setFlags(193);
            if (Build.VERSION.SDK_INT >= 14) {
                this.aTJ.setHinting(0);
            }
            this.aTJ.setStyle(Paint.Style.STROKE);
            this.aTJ.setTypeface(Typeface.DEFAULT);
            this.aPk = h.ae.qU();
            AppMethodBeat.o(206573);
        }

        g(g gVar) {
            AppMethodBeat.i(206574);
            this.aTG = gVar.aTG;
            this.aTH = gVar.aTH;
            this.aTI = new Paint(gVar.aTI);
            this.aTJ = new Paint(gVar.aTJ);
            if (gVar.aQc != null) {
                this.aQc = new h.b(gVar.aQc);
            }
            if (gVar.aQb != null) {
                this.aQb = new h.b(gVar.aQb);
            }
            this.aTK = gVar.aTK;
            try {
                this.aPk = (h.ae) gVar.aPk.clone();
                AppMethodBeat.o(206574);
            } catch (CloneNotSupportedException e2) {
                this.aPk = h.ae.qU();
                AppMethodBeat.o(206574);
            }
        }
    }

    private void rb() {
        AppMethodBeat.i(206579);
        this.aTk = new g();
        this.aTl = new Stack<>();
        a(this.aTk, h.ae.qU());
        this.aTk.aQc = null;
        this.aTk.aTK = false;
        this.aTl.push(new g(this.aTk));
        this.aTn = new Stack<>();
        this.aTm = new Stack<>();
        AppMethodBeat.o(206579);
    }

    i(Canvas canvas, float f2) {
        this.aTi = canvas;
        this.aTj = f2;
    }

    /* access modifiers changed from: package-private */
    public final float rc() {
        AppMethodBeat.i(206580);
        float textSize = this.aTk.aTI.getTextSize();
        AppMethodBeat.o(206580);
        return textSize;
    }

    /* access modifiers changed from: package-private */
    public final h.b rd() {
        if (this.aTk.aQb != null) {
            return this.aTk.aQb;
        }
        return this.aTk.aQc;
    }

    /* access modifiers changed from: package-private */
    public final void a(h hVar, g gVar) {
        f fVar;
        h.b bVar;
        AppMethodBeat.i(206581);
        this.aSO = hVar;
        h.af afVar = hVar.aQf;
        if (afVar == null) {
            String.format("Nothing to render. Document is empty.", new Object[0]);
            AppMethodBeat.o(206581);
            return;
        }
        if (gVar.qI()) {
            h.al aa = this.aSO.aa(gVar.viewId);
            if (aa == null || !(aa instanceof h.bf)) {
                String.format("View element with id \"%s\" not found.", gVar.viewId);
                AppMethodBeat.o(206581);
                return;
            }
            h.bf bfVar = (h.bf) aa;
            if (bfVar.aQb == null) {
                String.format("View element with id \"%s\" is missing a viewBox attribute.", gVar.viewId);
                AppMethodBeat.o(206581);
                return;
            }
            bVar = bfVar.aQb;
            fVar = bfVar.aPZ;
        } else {
            h.b bVar2 = gVar.qJ() ? gVar.aQb : afVar.aQb;
            if (gVar.qH()) {
                fVar = gVar.aPZ;
                bVar = bVar2;
            } else {
                fVar = afVar.aPZ;
                bVar = bVar2;
            }
        }
        if (gVar.qG()) {
            hVar.b(gVar.aPY);
        }
        if (gVar.qK()) {
            this.aTp = new b.p();
            this.aTp.aPl = hVar.aa(gVar.aQa);
        }
        rb();
        c((h.an) afVar);
        re();
        h.b bVar3 = new h.b(gVar.aQc);
        if (afVar.aQJ != null) {
            bVar3.width = afVar.aQJ.a(this, bVar3.width);
        }
        if (afVar.aQK != null) {
            bVar3.height = afVar.aQK.a(this, bVar3.height);
        }
        a(afVar, bVar3, bVar, fVar);
        rf();
        if (gVar.qG()) {
            hVar.qP();
        }
        AppMethodBeat.o(206581);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0255, code lost:
        b(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x02d9, code lost:
        if (com.a.a.h.qQ() != null) goto L_0x02db;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(com.a.a.h.an r13) {
        /*
        // Method dump skipped, instructions count: 1944
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.i.b(com.a.a.h$an):void");
    }

    private void a(h.aj ajVar, boolean z) {
        AppMethodBeat.i(206583);
        if (z) {
            a(ajVar);
        }
        for (h.an anVar : ajVar.getChildren()) {
            b(anVar);
        }
        if (z) {
            rg();
        }
        AppMethodBeat.o(206583);
    }

    private void re() {
        AppMethodBeat.i(206584);
        this.aTi.save();
        this.aTl.push(this.aTk);
        this.aTk = new g(this.aTk);
        AppMethodBeat.o(206584);
    }

    private void rf() {
        AppMethodBeat.i(206585);
        this.aTi.restore();
        this.aTk = this.aTl.pop();
        AppMethodBeat.o(206585);
    }

    private void a(h.aj ajVar) {
        AppMethodBeat.i(206586);
        this.aTm.push(ajVar);
        this.aTn.push(this.aTi.getMatrix());
        AppMethodBeat.o(206586);
    }

    private void rg() {
        AppMethodBeat.i(206587);
        this.aTm.pop();
        this.aTn.pop();
        AppMethodBeat.o(206587);
    }

    private void a(g gVar, h.al alVar) {
        AppMethodBeat.i(206588);
        gVar.aPk.aI(alVar.aSP == null);
        if (alVar.aSM != null) {
            a(gVar, alVar.aSM);
        }
        if (this.aSO.qO()) {
            for (b.o oVar : this.aSO.aQh.aPm) {
                if (b.a(this.aTp, oVar.aPj, alVar)) {
                    a(gVar, oVar.aPk);
                }
            }
        }
        if (alVar.aPk != null) {
            a(gVar, alVar.aPk);
        }
        AppMethodBeat.o(206588);
    }

    private void c(h.an anVar) {
        AppMethodBeat.i(206589);
        if (!(anVar instanceof h.al)) {
            AppMethodBeat.o(206589);
            return;
        }
        h.al alVar = (h.al) anVar;
        if (alVar.aSL != null) {
            this.aTk.aTK = alVar.aSL.booleanValue();
        }
        AppMethodBeat.o(206589);
    }

    private void a(h.ak akVar, Path path) {
        AppMethodBeat.i(206590);
        if (this.aTk.aPk.aRk instanceof h.u) {
            h.an Z = this.aSO.Z(((h.u) this.aTk.aPk.aRk).aQk);
            if (Z instanceof h.y) {
                a(akVar, path, (h.y) Z);
                AppMethodBeat.o(206590);
                return;
            }
        }
        this.aTi.drawPath(path, this.aTk.aTI);
        AppMethodBeat.o(206590);
    }

    private void d(Path path) {
        AppMethodBeat.i(206591);
        if (this.aTk.aPk.aRU == h.ae.i.NonScalingStroke) {
            Matrix matrix = this.aTi.getMatrix();
            Path path2 = new Path();
            path.transform(matrix, path2);
            this.aTi.setMatrix(new Matrix());
            Shader shader = this.aTk.aTJ.getShader();
            Matrix matrix2 = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(matrix2);
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.postConcat(matrix);
                shader.setLocalMatrix(matrix3);
            }
            this.aTi.drawPath(path2, this.aTk.aTJ);
            this.aTi.setMatrix(matrix);
            if (shader != null) {
                shader.setLocalMatrix(matrix2);
            }
            AppMethodBeat.o(206591);
            return;
        }
        this.aTi.drawPath(path, this.aTk.aTJ);
        AppMethodBeat.o(206591);
    }

    private void a(h.af afVar, h.b bVar, h.b bVar2, f fVar) {
        f fVar2;
        AppMethodBeat.i(206592);
        if (bVar.width == 0.0f || bVar.height == 0.0f) {
            AppMethodBeat.o(206592);
            return;
        }
        if (fVar == null) {
            fVar2 = afVar.aPZ != null ? afVar.aPZ : f.aPD;
        } else {
            fVar2 = fVar;
        }
        a(this.aTk, afVar);
        if (!rl()) {
            AppMethodBeat.o(206592);
            return;
        }
        this.aTk.aQc = bVar;
        if (!this.aTk.aPk.aRE.booleanValue()) {
            j(this.aTk.aQc.minX, this.aTk.aQc.minY, this.aTk.aQc.width, this.aTk.aQc.height);
        }
        b(afVar, this.aTk.aQc);
        if (bVar2 != null) {
            this.aTi.concat(a(this.aTk.aQc, bVar2, fVar2));
            this.aTk.aQb = afVar.aQb;
        } else {
            this.aTi.translate(this.aTk.aQc.minX, this.aTk.aQc.minY);
        }
        boolean rh = rh();
        rn();
        a((h.aj) afVar, true);
        if (rh) {
            b((h.ak) afVar);
        }
        a((h.ak) afVar);
        AppMethodBeat.o(206592);
    }

    private h.b a(h.p pVar, h.p pVar2, h.p pVar3, h.p pVar4) {
        float f2 = 0.0f;
        AppMethodBeat.i(206593);
        float a2 = pVar != null ? pVar.a(this) : 0.0f;
        if (pVar2 != null) {
            f2 = pVar2.b(this);
        }
        h.b rd = rd();
        h.b bVar = new h.b(a2, f2, pVar3 != null ? pVar3.a(this) : rd.width, pVar4 != null ? pVar4.b(this) : rd.height);
        AppMethodBeat.o(206593);
        return bVar;
    }

    private void a(h.ak akVar) {
        AppMethodBeat.i(206594);
        if (akVar.aSP == null) {
            AppMethodBeat.o(206594);
        } else if (akVar.aSK == null) {
            AppMethodBeat.o(206594);
        } else {
            Matrix matrix = new Matrix();
            if (this.aTn.peek().invert(matrix)) {
                float[] fArr = {akVar.aSK.minX, akVar.aSK.minY, akVar.aSK.qR(), akVar.aSK.minY, akVar.aSK.qR(), akVar.aSK.qS(), akVar.aSK.minX, akVar.aSK.qS()};
                matrix.preConcat(this.aTi.getMatrix());
                matrix.mapPoints(fArr);
                RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
                for (int i2 = 2; i2 <= 6; i2 += 2) {
                    if (fArr[i2] < rectF.left) {
                        rectF.left = fArr[i2];
                    }
                    if (fArr[i2] > rectF.right) {
                        rectF.right = fArr[i2];
                    }
                    if (fArr[i2 + 1] < rectF.top) {
                        rectF.top = fArr[i2 + 1];
                    }
                    if (fArr[i2 + 1] > rectF.bottom) {
                        rectF.bottom = fArr[i2 + 1];
                    }
                }
                h.ak akVar2 = (h.ak) this.aTm.peek();
                if (akVar2.aSK == null) {
                    akVar2.aSK = h.b.i(rectF.left, rectF.top, rectF.right, rectF.bottom);
                    AppMethodBeat.o(206594);
                    return;
                }
                akVar2.aSK.a(h.b.i(rectF.left, rectF.top, rectF.right, rectF.bottom));
            }
            AppMethodBeat.o(206594);
        }
    }

    private boolean rh() {
        h.an Z;
        AppMethodBeat.i(206595);
        if (!ri()) {
            AppMethodBeat.o(206595);
            return false;
        }
        this.aTi.saveLayerAlpha(null, T(this.aTk.aPk.aRv.floatValue()), 31);
        this.aTl.push(this.aTk);
        this.aTk = new g(this.aTk);
        if (this.aTk.aPk.aRP == null || ((Z = this.aSO.Z(this.aTk.aPk.aRP)) != null && (Z instanceof h.s))) {
            AppMethodBeat.o(206595);
            return true;
        }
        String.format("Mask reference '%s' not found", this.aTk.aPk.aRP);
        this.aTk.aPk.aRP = null;
        AppMethodBeat.o(206595);
        return true;
    }

    private void b(h.ak akVar) {
        AppMethodBeat.i(206596);
        a(akVar, akVar.aSK);
        AppMethodBeat.o(206596);
    }

    private void a(h.ak akVar, h.b bVar) {
        AppMethodBeat.i(206597);
        if (this.aTk.aPk.aRP != null) {
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.aTi.saveLayer(null, paint, 31);
            Paint paint2 = new Paint();
            paint2.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2127f, 0.7151f, 0.0722f, 0.0f, 0.0f})));
            this.aTi.saveLayer(null, paint2, 31);
            h.an Z = this.aSO.Z(this.aTk.aPk.aRP);
            a((h.s) Z, akVar, bVar);
            this.aTi.restore();
            Paint paint3 = new Paint();
            paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.aTi.saveLayer(null, paint3, 31);
            a((h.s) Z, akVar, bVar);
            this.aTi.restore();
            this.aTi.restore();
        }
        rf();
        AppMethodBeat.o(206597);
    }

    private boolean ri() {
        AppMethodBeat.i(206598);
        if (this.aTk.aPk.aRv.floatValue() < 1.0f || this.aTk.aPk.aRP != null) {
            AppMethodBeat.o(206598);
            return true;
        }
        AppMethodBeat.o(206598);
        return false;
    }

    private static synchronized void rj() {
        synchronized (i.class) {
            AppMethodBeat.i(206599);
            HashSet<String> hashSet = new HashSet<>();
            aTo = hashSet;
            hashSet.add("Structure");
            aTo.add("BasicStructure");
            aTo.add("ConditionalProcessing");
            aTo.add("Image");
            aTo.add("Style");
            aTo.add("ViewportAttribute");
            aTo.add("Shape");
            aTo.add("BasicText");
            aTo.add("PaintAttribute");
            aTo.add("BasicPaintAttribute");
            aTo.add("OpacityAttribute");
            aTo.add("BasicGraphicsAttribute");
            aTo.add("Marker");
            aTo.add("Gradient");
            aTo.add("Pattern");
            aTo.add("Clip");
            aTo.add("BasicClip");
            aTo.add("Mask");
            aTo.add("View");
            AppMethodBeat.o(206599);
        }
    }

    private static h.b e(Path path) {
        AppMethodBeat.i(206600);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        h.b bVar = new h.b(rectF.left, rectF.top, rectF.width(), rectF.height());
        AppMethodBeat.o(206600);
        return bVar;
    }

    private List<b> a(h.z zVar) {
        int i2 = 2;
        AppMethodBeat.i(206601);
        int length = zVar.points.length;
        if (length < 2) {
            AppMethodBeat.o(206601);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        float f2 = 0.0f;
        float f3 = 0.0f;
        b bVar = new b(zVar.points[0], zVar.points[1], 0.0f, 0.0f);
        while (i2 < length) {
            f3 = zVar.points[i2];
            f2 = zVar.points[i2 + 1];
            bVar.q(f3, f2);
            arrayList.add(bVar);
            i2 += 2;
            bVar = new b(f3, f2, f3 - bVar.x, f2 - bVar.y);
        }
        if (!(zVar instanceof h.aa)) {
            arrayList.add(bVar);
        } else if (!(f3 == zVar.points[0] || f2 == zVar.points[1])) {
            float f4 = zVar.points[0];
            float f5 = zVar.points[1];
            bVar.q(f4, f5);
            arrayList.add(bVar);
            b bVar2 = new b(f4, f5, f4 - bVar.x, f5 - bVar.y);
            bVar2.a((b) arrayList.get(0));
            arrayList.add(bVar2);
            arrayList.set(0, bVar2);
        }
        AppMethodBeat.o(206601);
        return arrayList;
    }

    private h.ae.f rk() {
        if (this.aTk.aPk.aRC == h.ae.EnumC0057h.LTR || this.aTk.aPk.aRD == h.ae.f.Middle) {
            return this.aTk.aPk.aRD;
        }
        return this.aTk.aPk.aRD == h.ae.f.Start ? h.ae.f.End : h.ae.f.Start;
    }

    /* access modifiers changed from: package-private */
    public class e extends AbstractC0059i {
        float x;
        float y;

        e(float f2, float f3) {
            super(i.this, (byte) 0);
            this.x = f2;
            this.y = f3;
        }

        @Override // com.a.a.i.AbstractC0059i
        public void ac(String str) {
            AppMethodBeat.i(206570);
            i.rr();
            if (i.d(i.this)) {
                if (i.this.aTk.aTG) {
                    i.this.aTi.drawText(str, this.x, this.y, i.this.aTk.aTI);
                }
                if (i.this.aTk.aTH) {
                    i.this.aTi.drawText(str, this.x, this.y, i.this.aTk.aTJ);
                }
            }
            this.x += i.this.aTk.aTI.measureText(str);
            AppMethodBeat.o(206570);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.a.a.i$i  reason: collision with other inner class name */
    public abstract class AbstractC0059i {
        public abstract void ac(String str);

        private AbstractC0059i() {
        }

        /* synthetic */ AbstractC0059i(i iVar, byte b2) {
            this();
        }

        public boolean b(h.ay ayVar) {
            return true;
        }
    }

    private void a(h.ay ayVar, AbstractC0059i iVar) {
        float f2;
        float f3;
        h.ae.f rk;
        float f4;
        float f5;
        AppMethodBeat.i(206602);
        if (!rl()) {
            AppMethodBeat.o(206602);
            return;
        }
        Iterator it = ayVar.aQz.iterator();
        boolean z = true;
        while (it.hasNext()) {
            h.an anVar = (h.an) it.next();
            if (anVar instanceof h.bc) {
                iVar.ac(a(((h.bc) anVar).text, z, !it.hasNext()));
            } else if (iVar.b((h.ay) anVar)) {
                if (anVar instanceof h.az) {
                    re();
                    h.az azVar = (h.az) anVar;
                    a(this.aTk, azVar);
                    if (rl() && visible()) {
                        h.an Z = azVar.aSO.Z(azVar.aQk);
                        if (Z == null) {
                            String.format("TextPath reference '%s' not found", azVar.aQk);
                        } else {
                            h.v vVar = (h.v) Z;
                            Path path = new c(vVar.aQZ).lR;
                            if (vVar.transform != null) {
                                path.transform(vVar.transform);
                            }
                            float a2 = azVar.aST != null ? azVar.aST.a(this, new PathMeasure(path, false).getLength()) : 0.0f;
                            h.ae.f rk2 = rk();
                            if (rk2 != h.ae.f.Start) {
                                float a3 = a((h.ay) azVar);
                                if (rk2 == h.ae.f.Middle) {
                                    f5 = a2 - (a3 / 2.0f);
                                } else {
                                    f5 = a2 - a3;
                                }
                            } else {
                                f5 = a2;
                            }
                            c((h.ak) azVar.aSS);
                            boolean rh = rh();
                            a(azVar, new d(path, f5));
                            if (rh) {
                                b((h.ak) azVar);
                            }
                        }
                    }
                } else if (anVar instanceof h.av) {
                    re();
                    h.av avVar = (h.av) anVar;
                    a(this.aTk, avVar);
                    if (rl()) {
                        float f6 = 0.0f;
                        float f7 = 0.0f;
                        float f8 = 0.0f;
                        boolean z2 = avVar.aSU != null && avVar.aSU.size() > 0;
                        if (iVar instanceof e) {
                            f6 = !z2 ? ((e) iVar).x : ((h.p) avVar.aSU.get(0)).a(this);
                            float b2 = (avVar.aSV == null || avVar.aSV.size() == 0) ? ((e) iVar).y : ((h.p) avVar.aSV.get(0)).b(this);
                            f8 = (avVar.aSW == null || avVar.aSW.size() == 0) ? 0.0f : ((h.p) avVar.aSW.get(0)).a(this);
                            if (avVar.aSX == null || avVar.aSX.size() == 0) {
                                f4 = 0.0f;
                            } else {
                                f4 = ((h.p) avVar.aSX.get(0)).b(this);
                            }
                            f2 = f4;
                            f7 = b2;
                        } else {
                            f2 = 0.0f;
                        }
                        if (!z2 || (rk = rk()) == h.ae.f.Start) {
                            f3 = f6;
                        } else {
                            float a4 = a((h.ay) avVar);
                            if (rk == h.ae.f.Middle) {
                                f3 = f6 - (a4 / 2.0f);
                            } else {
                                f3 = f6 - a4;
                            }
                        }
                        c((h.ak) avVar.aSS);
                        if (iVar instanceof e) {
                            ((e) iVar).x = f3 + f8;
                            ((e) iVar).y = f7 + f2;
                        }
                        boolean rh2 = rh();
                        a(avVar, iVar);
                        if (rh2) {
                            b((h.ak) avVar);
                        }
                    }
                    rf();
                } else if (anVar instanceof h.au) {
                    re();
                    h.au auVar = (h.au) anVar;
                    a(this.aTk, auVar);
                    if (rl()) {
                        c((h.ak) auVar.aSS);
                        h.an Z2 = anVar.aSO.Z(auVar.aQk);
                        if (Z2 == null || !(Z2 instanceof h.ay)) {
                            String.format("Tref reference '%s' not found", auVar.aQk);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            a((h.ay) Z2, sb);
                            if (sb.length() > 0) {
                                iVar.ac(sb.toString());
                            }
                        }
                    }
                }
                rf();
            }
            z = false;
        }
        AppMethodBeat.o(206602);
    }

    /* access modifiers changed from: package-private */
    public class d extends e {
        private Path lR;

        d(Path path, float f2) {
            super(f2, 0.0f);
            this.lR = path;
        }

        @Override // com.a.a.i.e, com.a.a.i.AbstractC0059i
        public final void ac(String str) {
            AppMethodBeat.i(206569);
            if (i.d(i.this)) {
                if (i.this.aTk.aTG) {
                    i.this.aTi.drawTextOnPath(str, this.lR, this.x, this.y, i.this.aTk.aTI);
                }
                if (i.this.aTk.aTH) {
                    i.this.aTi.drawTextOnPath(str, this.lR, this.x, this.y, i.this.aTk.aTJ);
                }
            }
            this.x += i.this.aTk.aTI.measureText(str);
            AppMethodBeat.o(206569);
        }
    }

    private float a(h.ay ayVar) {
        AppMethodBeat.i(206603);
        j jVar = new j(this, (byte) 0);
        a(ayVar, jVar);
        float f2 = jVar.x;
        AppMethodBeat.o(206603);
        return f2;
    }

    /* access modifiers changed from: package-private */
    public class j extends AbstractC0059i {
        float x;

        private j() {
            super(i.this, (byte) 0);
            this.x = 0.0f;
        }

        /* synthetic */ j(i iVar, byte b2) {
            this();
        }

        @Override // com.a.a.i.AbstractC0059i
        public final void ac(String str) {
            AppMethodBeat.i(206578);
            this.x += i.this.aTk.aTI.measureText(str);
            AppMethodBeat.o(206578);
        }
    }

    /* access modifiers changed from: package-private */
    public class h extends AbstractC0059i {
        RectF aTL = new RectF();
        float x;
        float y;

        h(float f2, float f3) {
            super(i.this, (byte) 0);
            AppMethodBeat.i(206575);
            this.x = f2;
            this.y = f3;
            AppMethodBeat.o(206575);
        }

        @Override // com.a.a.i.AbstractC0059i
        public final boolean b(h.ay ayVar) {
            AppMethodBeat.i(206576);
            if (ayVar instanceof h.az) {
                h.az azVar = (h.az) ayVar;
                h.an Z = ayVar.aSO.Z(azVar.aQk);
                if (Z == null) {
                    i.f("TextPath path reference '%s' not found", new Object[]{azVar.aQk});
                    AppMethodBeat.o(206576);
                    return false;
                }
                h.v vVar = (h.v) Z;
                Path path = new c(vVar.aQZ).lR;
                if (vVar.transform != null) {
                    path.transform(vVar.transform);
                }
                RectF rectF = new RectF();
                path.computeBounds(rectF, true);
                this.aTL.union(rectF);
                AppMethodBeat.o(206576);
                return false;
            }
            AppMethodBeat.o(206576);
            return true;
        }

        @Override // com.a.a.i.AbstractC0059i
        public final void ac(String str) {
            AppMethodBeat.i(206577);
            if (i.d(i.this)) {
                Rect rect = new Rect();
                i.this.aTk.aTI.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.x, this.y);
                this.aTL.union(rectF);
            }
            this.x += i.this.aTk.aTI.measureText(str);
            AppMethodBeat.o(206577);
        }
    }

    private void a(h.ay ayVar, StringBuilder sb) {
        AppMethodBeat.i(206604);
        Iterator it = ayVar.aQz.iterator();
        boolean z = true;
        while (it.hasNext()) {
            h.an anVar = (h.an) it.next();
            if (anVar instanceof h.ay) {
                a((h.ay) anVar, sb);
            } else if (anVar instanceof h.bc) {
                sb.append(a(((h.bc) anVar).text, z, !it.hasNext()));
            }
            z = false;
        }
        AppMethodBeat.o(206604);
    }

    private String a(String str, boolean z, boolean z2) {
        AppMethodBeat.i(206605);
        if (this.aTk.aTK) {
            String replaceAll = str.replaceAll("[\\n\\t]", " ");
            AppMethodBeat.o(206605);
            return replaceAll;
        }
        String replaceAll2 = str.replaceAll("\\n", "").replaceAll("\\t", " ");
        if (z) {
            replaceAll2 = replaceAll2.replaceAll("^\\s+", "");
        }
        if (z2) {
            replaceAll2 = replaceAll2.replaceAll("\\s+$", "");
        }
        String replaceAll3 = replaceAll2.replaceAll("\\s{2,}", " ");
        AppMethodBeat.o(206605);
        return replaceAll3;
    }

    private static Bitmap checkForImageDataURL(String str) {
        Bitmap bitmap = null;
        AppMethodBeat.i(206606);
        if (!str.startsWith("data:")) {
            AppMethodBeat.o(206606);
        } else if (str.length() < 14) {
            AppMethodBeat.o(206606);
        } else {
            int indexOf = str.indexOf(44);
            if (indexOf < 12) {
                AppMethodBeat.o(206606);
            } else if (!";base64".equals(str.substring(indexOf - 7, indexOf))) {
                AppMethodBeat.o(206606);
            } else {
                try {
                    byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
                    bitmap = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                    AppMethodBeat.o(206606);
                } catch (Exception e2) {
                    AppMethodBeat.o(206606);
                }
            }
        }
        return bitmap;
    }

    private boolean rl() {
        AppMethodBeat.i(206607);
        if (this.aTk.aPk.aRJ != null) {
            boolean booleanValue = this.aTk.aPk.aRJ.booleanValue();
            AppMethodBeat.o(206607);
            return booleanValue;
        }
        AppMethodBeat.o(206607);
        return true;
    }

    private boolean visible() {
        AppMethodBeat.i(206608);
        if (this.aTk.aPk.aRK != null) {
            boolean booleanValue = this.aTk.aPk.aRK.booleanValue();
            AppMethodBeat.o(206608);
            return booleanValue;
        }
        AppMethodBeat.o(206608);
        return true;
    }

    private static Matrix a(h.b bVar, h.b bVar2, f fVar) {
        AppMethodBeat.i(206609);
        Matrix matrix = new Matrix();
        if (fVar == null || fVar.aPz == null) {
            AppMethodBeat.o(206609);
            return matrix;
        }
        float f2 = bVar.width / bVar2.width;
        float f3 = bVar.height / bVar2.height;
        float f4 = -bVar2.minX;
        float f5 = -bVar2.minY;
        if (fVar.equals(f.aPC)) {
            matrix.preTranslate(bVar.minX, bVar.minY);
            matrix.preScale(f2, f3);
            matrix.preTranslate(f4, f5);
            AppMethodBeat.o(206609);
            return matrix;
        }
        float max = fVar.aPA == f.b.slice ? Math.max(f2, f3) : Math.min(f2, f3);
        float f6 = bVar.width / max;
        float f7 = bVar.height / max;
        switch (fVar.aPz) {
            case xMidYMin:
            case xMidYMid:
            case xMidYMax:
                f4 -= (bVar2.width - f6) / 2.0f;
                break;
            case xMaxYMin:
            case xMaxYMid:
            case xMaxYMax:
                f4 -= bVar2.width - f6;
                break;
        }
        switch (fVar.aPz) {
            case xMidYMid:
            case xMaxYMid:
            case xMinYMid:
                f5 -= (bVar2.height - f7) / 2.0f;
                break;
            case xMidYMax:
            case xMaxYMax:
            case xMinYMax:
                f5 -= bVar2.height - f7;
                break;
        }
        matrix.preTranslate(bVar.minX, bVar.minY);
        matrix.preScale(max, max);
        matrix.preTranslate(f4, f5);
        AppMethodBeat.o(206609);
        return matrix;
    }

    private static boolean a(h.ae aeVar, long j2) {
        return (aeVar.aRj & j2) != 0;
    }

    private void a(g gVar, h.ae aeVar) {
        Typeface typeface;
        boolean z = true;
        AppMethodBeat.i(206610);
        if (a(aeVar, 4096)) {
            gVar.aPk.aRw = aeVar.aRw;
        }
        if (a(aeVar, 2048)) {
            gVar.aPk.aRv = aeVar.aRv;
        }
        if (a(aeVar, 1)) {
            gVar.aPk.aRk = aeVar.aRk;
            gVar.aTG = (aeVar.aRk == null || aeVar.aRk == h.f.aQv) ? false : true;
        }
        if (a(aeVar, 4)) {
            gVar.aPk.aRm = aeVar.aRm;
        }
        if (a(aeVar, 6149)) {
            a(gVar, true, gVar.aPk.aRk);
        }
        if (a(aeVar, 2)) {
            gVar.aPk.aRl = aeVar.aRl;
        }
        if (a(aeVar, 8)) {
            gVar.aPk.aRn = aeVar.aRn;
            gVar.aTH = (aeVar.aRn == null || aeVar.aRn == h.f.aQv) ? false : true;
        }
        if (a(aeVar, 16)) {
            gVar.aPk.aRo = aeVar.aRo;
        }
        if (a(aeVar, 6168)) {
            a(gVar, false, gVar.aPk.aRn);
        }
        if (a(aeVar, 34359738368L)) {
            gVar.aPk.aRU = aeVar.aRU;
        }
        if (a(aeVar, 32)) {
            gVar.aPk.aRp = aeVar.aRp;
            gVar.aTJ.setStrokeWidth(gVar.aPk.aRp.c(this));
        }
        if (a(aeVar, 64)) {
            gVar.aPk.aRq = aeVar.aRq;
            switch (aeVar.aRq) {
                case Butt:
                    gVar.aTJ.setStrokeCap(Paint.Cap.BUTT);
                    break;
                case Round:
                    gVar.aTJ.setStrokeCap(Paint.Cap.ROUND);
                    break;
                case Square:
                    gVar.aTJ.setStrokeCap(Paint.Cap.SQUARE);
                    break;
            }
        }
        if (a(aeVar, 128)) {
            gVar.aPk.aRr = aeVar.aRr;
            switch (aeVar.aRr) {
                case Miter:
                    gVar.aTJ.setStrokeJoin(Paint.Join.MITER);
                    break;
                case Round:
                    gVar.aTJ.setStrokeJoin(Paint.Join.ROUND);
                    break;
                case Bevel:
                    gVar.aTJ.setStrokeJoin(Paint.Join.BEVEL);
                    break;
            }
        }
        if (a(aeVar, 256)) {
            gVar.aPk.aRs = aeVar.aRs;
            gVar.aTJ.setStrokeMiter(aeVar.aRs.floatValue());
        }
        if (a(aeVar, 512)) {
            gVar.aPk.aRt = aeVar.aRt;
        }
        if (a(aeVar, 1024)) {
            gVar.aPk.aRu = aeVar.aRu;
        }
        if (a(aeVar, 1536)) {
            if (gVar.aPk.aRt == null) {
                gVar.aTJ.setPathEffect(null);
            } else {
                int length = gVar.aPk.aRt.length;
                int i2 = length % 2 == 0 ? length : length * 2;
                float[] fArr = new float[i2];
                float f2 = 0.0f;
                for (int i3 = 0; i3 < i2; i3++) {
                    fArr[i3] = gVar.aPk.aRt[i3 % length].c(this);
                    f2 += fArr[i3];
                }
                if (f2 == 0.0f) {
                    gVar.aTJ.setPathEffect(null);
                } else {
                    float c2 = gVar.aPk.aRu.c(this);
                    if (c2 < 0.0f) {
                        c2 = (c2 % f2) + f2;
                    }
                    gVar.aTJ.setPathEffect(new DashPathEffect(fArr, c2));
                }
            }
        }
        if (a(aeVar, 16384)) {
            float rc = rc();
            gVar.aPk.aRy = aeVar.aRy;
            gVar.aTI.setTextSize(aeVar.aRy.a(this, rc));
            gVar.aTJ.setTextSize(aeVar.aRy.a(this, rc));
        }
        if (a(aeVar, 8192)) {
            gVar.aPk.aRx = aeVar.aRx;
        }
        if (a(aeVar, 32768)) {
            if (aeVar.aRz.intValue() == -1 && gVar.aPk.aRz.intValue() > 100) {
                h.ae aeVar2 = gVar.aPk;
                aeVar2.aRz = Integer.valueOf(aeVar2.aRz.intValue() - 100);
            } else if (aeVar.aRz.intValue() != 1 || gVar.aPk.aRz.intValue() >= 900) {
                gVar.aPk.aRz = aeVar.aRz;
            } else {
                h.ae aeVar3 = gVar.aPk;
                aeVar3.aRz = Integer.valueOf(aeVar3.aRz.intValue() + 100);
            }
        }
        if (a(aeVar, 65536)) {
            gVar.aPk.aRA = aeVar.aRA;
        }
        if (a(aeVar, 106496)) {
            if (gVar.aPk.aRx == null || this.aSO == null) {
                typeface = null;
            } else {
                j qQ = h.qQ();
                typeface = null;
                for (String str : gVar.aPk.aRx) {
                    typeface = a(str, gVar.aPk.aRz, gVar.aPk.aRA);
                    if (typeface == null && qQ != null) {
                        gVar.aPk.aRz.intValue();
                        String.valueOf(gVar.aPk.aRA);
                        typeface = null;
                        continue;
                    }
                    if (typeface != null) {
                    }
                }
            }
            if (typeface == null) {
                typeface = a("serif", gVar.aPk.aRz, gVar.aPk.aRA);
            }
            gVar.aTI.setTypeface(typeface);
            gVar.aTJ.setTypeface(typeface);
        }
        if (a(aeVar, 131072)) {
            gVar.aPk.aRB = aeVar.aRB;
            gVar.aTI.setStrikeThruText(aeVar.aRB == h.ae.g.LineThrough);
            gVar.aTI.setUnderlineText(aeVar.aRB == h.ae.g.Underline);
            if (Build.VERSION.SDK_INT >= 17) {
                gVar.aTJ.setStrikeThruText(aeVar.aRB == h.ae.g.LineThrough);
                Paint paint = gVar.aTJ;
                if (aeVar.aRB != h.ae.g.Underline) {
                    z = false;
                }
                paint.setUnderlineText(z);
            }
        }
        if (a(aeVar, 68719476736L)) {
            gVar.aPk.aRC = aeVar.aRC;
        }
        if (a(aeVar, 262144)) {
            gVar.aPk.aRD = aeVar.aRD;
        }
        if (a(aeVar, (long) com.tencent.mm.hardcoder.g.ACTION_MINI_PROGRAM_LAUNCH)) {
            gVar.aPk.aRE = aeVar.aRE;
        }
        if (a(aeVar, 2097152)) {
            gVar.aPk.aRG = aeVar.aRG;
        }
        if (a(aeVar, 4194304)) {
            gVar.aPk.aRH = aeVar.aRH;
        }
        if (a(aeVar, 8388608)) {
            gVar.aPk.aRI = aeVar.aRI;
        }
        if (a(aeVar, 16777216)) {
            gVar.aPk.aRJ = aeVar.aRJ;
        }
        if (a(aeVar, 33554432)) {
            gVar.aPk.aRK = aeVar.aRK;
        }
        if (a(aeVar, 1048576)) {
            gVar.aPk.aRF = aeVar.aRF;
        }
        if (a(aeVar, 268435456)) {
            gVar.aPk.aRN = aeVar.aRN;
        }
        if (a(aeVar, (long) TPAudioFrame.TP_CH_STEREO_LEFT)) {
            gVar.aPk.aRO = aeVar.aRO;
        }
        if (a(aeVar, (long) TPAudioFrame.TP_CH_STEREO_RIGHT)) {
            gVar.aPk.aRP = aeVar.aRP;
        }
        if (a(aeVar, 67108864)) {
            gVar.aPk.aRL = aeVar.aRL;
        }
        if (a(aeVar, 134217728)) {
            gVar.aPk.aRM = aeVar.aRM;
        }
        if (a(aeVar, 8589934592L)) {
            gVar.aPk.aRS = aeVar.aRS;
        }
        if (a(aeVar, 17179869184L)) {
            gVar.aPk.aRT = aeVar.aRT;
        }
        if (a(aeVar, 137438953472L)) {
            gVar.aPk.aRV = aeVar.aRV;
        }
        AppMethodBeat.o(206610);
    }

    private static void a(g gVar, boolean z, h.ao aoVar) {
        int i2;
        AppMethodBeat.i(206611);
        float floatValue = (z ? gVar.aPk.aRm : gVar.aPk.aRo).floatValue();
        if (aoVar instanceof h.f) {
            i2 = ((h.f) aoVar).aQt;
        } else if (aoVar instanceof h.g) {
            i2 = gVar.aPk.aRw.aQt;
        } else {
            AppMethodBeat.o(206611);
            return;
        }
        int h2 = h(i2, floatValue);
        if (z) {
            gVar.aTI.setColor(h2);
            AppMethodBeat.o(206611);
            return;
        }
        gVar.aTJ.setColor(h2);
        AppMethodBeat.o(206611);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003d, code lost:
        if (r9.equals("serif") != false) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Typeface a(java.lang.String r9, java.lang.Integer r10, com.a.a.h.ae.b r11) {
        /*
        // Method dump skipped, instructions count: 180
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.i.a(java.lang.String, java.lang.Integer, com.a.a.h$ae$b):android.graphics.Typeface");
    }

    private static int T(float f2) {
        int i2 = (int) (256.0f * f2);
        if (i2 < 0) {
            return 0;
        }
        if (i2 <= 255) {
            return i2;
        }
        return 255;
    }

    private static int h(int i2, float f2) {
        int i3 = 255;
        AppMethodBeat.i(206613);
        int round = Math.round(((float) ((i2 >> 24) & 255)) * f2);
        if (round < 0) {
            i3 = 0;
        } else if (round <= 255) {
            i3 = round;
        }
        int i4 = (i3 << 24) | (16777215 & i2);
        AppMethodBeat.o(206613);
        return i4;
    }

    private Path.FillType rm() {
        if (this.aTk.aPk.aRl == null || this.aTk.aPk.aRl != h.ae.a.EvenOdd) {
            return Path.FillType.WINDING;
        }
        return Path.FillType.EVEN_ODD;
    }

    private void j(float f2, float f3, float f4, float f5) {
        AppMethodBeat.i(206614);
        float f6 = f2 + f4;
        float f7 = f3 + f5;
        if (this.aTk.aPk.aRF != null) {
            f2 += this.aTk.aPk.aRF.aQo.a(this);
            f3 += this.aTk.aPk.aRF.aQl.b(this);
            f6 -= this.aTk.aPk.aRF.aQm.a(this);
            f7 -= this.aTk.aPk.aRF.aQn.b(this);
        }
        this.aTi.clipRect(f2, f3, f6, f7);
        AppMethodBeat.o(206614);
    }

    private void rn() {
        int i2;
        AppMethodBeat.i(206615);
        if (this.aTk.aPk.aRS instanceof h.f) {
            i2 = ((h.f) this.aTk.aPk.aRS).aQt;
        } else if (this.aTk.aPk.aRS instanceof h.g) {
            i2 = this.aTk.aPk.aRw.aQt;
        } else {
            AppMethodBeat.o(206615);
            return;
        }
        if (this.aTk.aPk.aRT != null) {
            i2 = h(i2, this.aTk.aPk.aRT.floatValue());
        }
        this.aTi.drawColor(i2);
        AppMethodBeat.o(206615);
    }

    /* access modifiers changed from: protected */
    public static class c implements h.x {
        float aTD;
        float aTE;
        Path lR = new Path();

        c(h.w wVar) {
            AppMethodBeat.i(206562);
            if (wVar == null) {
                AppMethodBeat.o(206562);
                return;
            }
            wVar.a(this);
            AppMethodBeat.o(206562);
        }

        @Override // com.a.a.h.x
        public final void moveTo(float f2, float f3) {
            AppMethodBeat.i(206563);
            this.lR.moveTo(f2, f3);
            this.aTD = f2;
            this.aTE = f3;
            AppMethodBeat.o(206563);
        }

        @Override // com.a.a.h.x
        public final void lineTo(float f2, float f3) {
            AppMethodBeat.i(206564);
            this.lR.lineTo(f2, f3);
            this.aTD = f2;
            this.aTE = f3;
            AppMethodBeat.o(206564);
        }

        @Override // com.a.a.h.x
        public final void cubicTo(float f2, float f3, float f4, float f5, float f6, float f7) {
            AppMethodBeat.i(206565);
            this.lR.cubicTo(f2, f3, f4, f5, f6, f7);
            this.aTD = f6;
            this.aTE = f7;
            AppMethodBeat.o(206565);
        }

        @Override // com.a.a.h.x
        public final void quadTo(float f2, float f3, float f4, float f5) {
            AppMethodBeat.i(206566);
            this.lR.quadTo(f2, f3, f4, f5);
            this.aTD = f4;
            this.aTE = f5;
            AppMethodBeat.o(206566);
        }

        @Override // com.a.a.h.x
        public final void a(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6) {
            AppMethodBeat.i(206567);
            i.a(this.aTD, this.aTE, f2, f3, f4, z, z2, f5, f6, this);
            this.aTD = f5;
            this.aTE = f6;
            AppMethodBeat.o(206567);
        }

        @Override // com.a.a.h.x
        public final void close() {
            AppMethodBeat.i(206568);
            this.lR.close();
            AppMethodBeat.o(206568);
        }
    }

    /* access modifiers changed from: package-private */
    public class b {
        float aTA = 0.0f;
        float aTB = 0.0f;
        boolean aTC = false;
        float x;
        float y;

        b(float f2, float f3, float f4, float f5) {
            AppMethodBeat.i(206559);
            this.x = f2;
            this.y = f3;
            double sqrt = Math.sqrt((double) ((f4 * f4) + (f5 * f5)));
            if (sqrt != 0.0d) {
                this.aTA = (float) (((double) f4) / sqrt);
                this.aTB = (float) (((double) f5) / sqrt);
            }
            AppMethodBeat.o(206559);
        }

        /* access modifiers changed from: package-private */
        public final void q(float f2, float f3) {
            AppMethodBeat.i(206560);
            float f4 = f2 - this.x;
            float f5 = f3 - this.y;
            double sqrt = Math.sqrt((double) ((f4 * f4) + (f5 * f5)));
            if (sqrt != 0.0d) {
                f4 = (float) (((double) f4) / sqrt);
                f5 = (float) (((double) f5) / sqrt);
            }
            if (f4 == (-this.aTA) && f5 == (-this.aTB)) {
                this.aTC = true;
                this.aTA = -f5;
                this.aTB = f4;
                AppMethodBeat.o(206560);
                return;
            }
            this.aTA = f4 + this.aTA;
            this.aTB = f5 + this.aTB;
            AppMethodBeat.o(206560);
        }

        /* access modifiers changed from: package-private */
        public final void a(b bVar) {
            if (bVar.aTA == (-this.aTA) && bVar.aTB == (-this.aTB)) {
                this.aTC = true;
                this.aTA = -bVar.aTB;
                this.aTB = bVar.aTA;
                return;
            }
            this.aTA += bVar.aTA;
            this.aTB += bVar.aTB;
        }

        public final String toString() {
            AppMethodBeat.i(206561);
            String str = "(" + this.x + "," + this.y + " " + this.aTA + "," + this.aTB + ")";
            AppMethodBeat.o(206561);
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    public class a implements h.x {
        List<b> aTt = new ArrayList();
        private b aTu = null;
        private boolean aTv = false;
        private boolean aTw = true;
        private int aTx = -1;
        private boolean aTy;

        /* renamed from: me  reason: collision with root package name */
        private float f106me;
        private float mf;

        a(h.w wVar) {
            AppMethodBeat.i(206552);
            if (wVar == null) {
                AppMethodBeat.o(206552);
                return;
            }
            wVar.a(this);
            if (this.aTy) {
                this.aTu.a(this.aTt.get(this.aTx));
                this.aTt.set(this.aTx, this.aTu);
                this.aTy = false;
            }
            if (this.aTu != null) {
                this.aTt.add(this.aTu);
            }
            AppMethodBeat.o(206552);
        }

        @Override // com.a.a.h.x
        public final void moveTo(float f2, float f3) {
            AppMethodBeat.i(206553);
            if (this.aTy) {
                this.aTu.a(this.aTt.get(this.aTx));
                this.aTt.set(this.aTx, this.aTu);
                this.aTy = false;
            }
            if (this.aTu != null) {
                this.aTt.add(this.aTu);
            }
            this.f106me = f2;
            this.mf = f3;
            this.aTu = new b(f2, f3, 0.0f, 0.0f);
            this.aTx = this.aTt.size();
            AppMethodBeat.o(206553);
        }

        @Override // com.a.a.h.x
        public final void lineTo(float f2, float f3) {
            AppMethodBeat.i(206554);
            this.aTu.q(f2, f3);
            this.aTt.add(this.aTu);
            this.aTu = new b(f2, f3, f2 - this.aTu.x, f3 - this.aTu.y);
            this.aTy = false;
            AppMethodBeat.o(206554);
        }

        @Override // com.a.a.h.x
        public final void cubicTo(float f2, float f3, float f4, float f5, float f6, float f7) {
            AppMethodBeat.i(206555);
            if (this.aTw || this.aTv) {
                this.aTu.q(f2, f3);
                this.aTt.add(this.aTu);
                this.aTv = false;
            }
            this.aTu = new b(f6, f7, f6 - f4, f7 - f5);
            this.aTy = false;
            AppMethodBeat.o(206555);
        }

        @Override // com.a.a.h.x
        public final void quadTo(float f2, float f3, float f4, float f5) {
            AppMethodBeat.i(206556);
            this.aTu.q(f2, f3);
            this.aTt.add(this.aTu);
            this.aTu = new b(f4, f5, f4 - f2, f5 - f3);
            this.aTy = false;
            AppMethodBeat.o(206556);
        }

        @Override // com.a.a.h.x
        public final void a(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6) {
            AppMethodBeat.i(206557);
            this.aTv = true;
            this.aTw = false;
            i.a(this.aTu.x, this.aTu.y, f2, f3, f4, z, z2, f5, f6, this);
            this.aTw = true;
            this.aTy = false;
            AppMethodBeat.o(206557);
        }

        @Override // com.a.a.h.x
        public final void close() {
            AppMethodBeat.i(206558);
            this.aTt.add(this.aTu);
            lineTo(this.f106me, this.mf);
            this.aTy = true;
            AppMethodBeat.o(206558);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0131  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.a.a.h.l r13) {
        /*
        // Method dump skipped, instructions count: 499
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.i.a(com.a.a.h$l):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0145  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.a.a.h.r r14, com.a.a.i.b r15) {
        /*
        // Method dump skipped, instructions count: 392
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.i.a(com.a.a.h$r, com.a.a.i$b):void");
    }

    private g d(h.an anVar) {
        AppMethodBeat.i(206618);
        g gVar = new g();
        a(gVar, h.ae.qU());
        g a2 = a(anVar, gVar);
        AppMethodBeat.o(206618);
        return a2;
    }

    private g a(h.an anVar, g gVar) {
        AppMethodBeat.i(206619);
        ArrayList<h.al> arrayList = new ArrayList();
        h.an anVar2 = anVar;
        while (true) {
            if (anVar2 instanceof h.al) {
                arrayList.add(0, (h.al) anVar2);
            }
            if (anVar2.aSP == null) {
                break;
            }
            anVar2 = (h.an) anVar2.aSP;
        }
        for (h.al alVar : arrayList) {
            a(gVar, alVar);
        }
        gVar.aQb = this.aTk.aQb;
        gVar.aQc = this.aTk.aQc;
        AppMethodBeat.o(206619);
        return gVar;
    }

    private void c(h.ak akVar) {
        AppMethodBeat.i(206620);
        if (this.aTk.aPk.aRk instanceof h.u) {
            a(true, akVar.aSK, (h.u) this.aTk.aPk.aRk);
        }
        if (this.aTk.aPk.aRn instanceof h.u) {
            a(false, akVar.aSK, (h.u) this.aTk.aPk.aRn);
        }
        AppMethodBeat.o(206620);
    }

    private void a(boolean z, h.b bVar, h.u uVar) {
        String str;
        AppMethodBeat.i(206621);
        h.an Z = this.aSO.Z(uVar.aQk);
        if (Z == null) {
            Object[] objArr = new Object[2];
            if (z) {
                str = "Fill";
            } else {
                str = "Stroke";
            }
            objArr[0] = str;
            objArr[1] = uVar.aQk;
            String.format("%s reference '%s' not found", objArr);
            if (uVar.aQY != null) {
                a(this.aTk, z, uVar.aQY);
                AppMethodBeat.o(206621);
            } else if (z) {
                this.aTk.aTG = false;
                AppMethodBeat.o(206621);
            } else {
                this.aTk.aTH = false;
                AppMethodBeat.o(206621);
            }
        } else if (Z instanceof h.am) {
            a(z, bVar, (h.am) Z);
            AppMethodBeat.o(206621);
        } else if (Z instanceof h.aq) {
            a(z, bVar, (h.aq) Z);
            AppMethodBeat.o(206621);
        } else {
            if (Z instanceof h.ac) {
                a(z, (h.ac) Z);
            }
            AppMethodBeat.o(206621);
        }
    }

    private void a(boolean z, h.b bVar, h.am amVar) {
        float a2;
        float a3;
        float a4;
        float f2;
        AppMethodBeat.i(206622);
        if (amVar.aQk != null) {
            a(amVar, amVar.aQk);
        }
        boolean z2 = amVar.aQA != null && amVar.aQA.booleanValue();
        Paint paint = z ? this.aTk.aTI : this.aTk.aTJ;
        if (z2) {
            h.b rd = rd();
            float a5 = amVar.aQM != null ? amVar.aQM.a(this) : 0.0f;
            a2 = amVar.aQN != null ? amVar.aQN.b(this) : 0.0f;
            a3 = amVar.aQO != null ? amVar.aQO.a(this) : rd.width;
            a4 = amVar.aQP != null ? amVar.aQP.b(this) : 0.0f;
            f2 = a5;
        } else {
            float a6 = amVar.aQM != null ? amVar.aQM.a(this, 1.0f) : 0.0f;
            a2 = amVar.aQN != null ? amVar.aQN.a(this, 1.0f) : 0.0f;
            a3 = amVar.aQO != null ? amVar.aQO.a(this, 1.0f) : 1.0f;
            a4 = amVar.aQP != null ? amVar.aQP.a(this, 1.0f) : 0.0f;
            f2 = a6;
        }
        re();
        this.aTk = d(amVar);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(bVar.minX, bVar.minY);
            matrix.preScale(bVar.width, bVar.height);
        }
        if (amVar.aQB != null) {
            matrix.preConcat(amVar.aQB);
        }
        int size = amVar.aQz.size();
        if (size == 0) {
            rf();
            if (z) {
                this.aTk.aTG = false;
                AppMethodBeat.o(206622);
                return;
            }
            this.aTk.aTH = false;
            AppMethodBeat.o(206622);
            return;
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        int i2 = 0;
        float f3 = -1.0f;
        for (h.an anVar : amVar.aQz) {
            h.ad adVar = (h.ad) anVar;
            float floatValue = adVar.aRi != null ? adVar.aRi.floatValue() : 0.0f;
            if (i2 == 0 || floatValue >= f3) {
                fArr[i2] = floatValue;
                f3 = floatValue;
            } else {
                fArr[i2] = f3;
            }
            re();
            a(this.aTk, adVar);
            h.f fVar = (h.f) this.aTk.aPk.aRL;
            if (fVar == null) {
                fVar = h.f.aQu;
            }
            iArr[i2] = h(fVar.aQt, this.aTk.aPk.aRM.floatValue());
            rf();
            i2++;
        }
        if ((f2 == a3 && a2 == a4) || size == 1) {
            rf();
            paint.setColor(iArr[size - 1]);
            AppMethodBeat.o(206622);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (amVar.aQC != null) {
            if (amVar.aQC == h.k.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (amVar.aQC == h.k.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        rf();
        LinearGradient linearGradient = new LinearGradient(f2, a2, a3, a4, iArr, fArr, tileMode);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
        paint.setAlpha(T(this.aTk.aPk.aRm.floatValue()));
        AppMethodBeat.o(206622);
    }

    private void a(boolean z, h.b bVar, h.aq aqVar) {
        float a2;
        float a3;
        float f2;
        AppMethodBeat.i(206623);
        if (aqVar.aQk != null) {
            a(aqVar, aqVar.aQk);
        }
        boolean z2 = aqVar.aQA != null && aqVar.aQA.booleanValue();
        Paint paint = z ? this.aTk.aTI : this.aTk.aTJ;
        if (z2) {
            h.p pVar = new h.p(50.0f, h.bd.percent);
            float a4 = aqVar.aQp != null ? aqVar.aQp.a(this) : pVar.a(this);
            a2 = aqVar.aQq != null ? aqVar.aQq.b(this) : pVar.b(this);
            if (aqVar.aQr != null) {
                a3 = aqVar.aQr.c(this);
            } else {
                a3 = pVar.c(this);
            }
            f2 = a4;
        } else {
            float a5 = aqVar.aQp != null ? aqVar.aQp.a(this, 1.0f) : 0.5f;
            a2 = aqVar.aQq != null ? aqVar.aQq.a(this, 1.0f) : 0.5f;
            a3 = aqVar.aQr != null ? aqVar.aQr.a(this, 1.0f) : 0.5f;
            f2 = a5;
        }
        re();
        this.aTk = d(aqVar);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(bVar.minX, bVar.minY);
            matrix.preScale(bVar.width, bVar.height);
        }
        if (aqVar.aQB != null) {
            matrix.preConcat(aqVar.aQB);
        }
        int size = aqVar.aQz.size();
        if (size == 0) {
            rf();
            if (z) {
                this.aTk.aTG = false;
                AppMethodBeat.o(206623);
                return;
            }
            this.aTk.aTH = false;
            AppMethodBeat.o(206623);
            return;
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        int i2 = 0;
        float f3 = -1.0f;
        for (h.an anVar : aqVar.aQz) {
            h.ad adVar = (h.ad) anVar;
            float floatValue = adVar.aRi != null ? adVar.aRi.floatValue() : 0.0f;
            if (i2 == 0 || floatValue >= f3) {
                fArr[i2] = floatValue;
                f3 = floatValue;
            } else {
                fArr[i2] = f3;
            }
            re();
            a(this.aTk, adVar);
            h.f fVar = (h.f) this.aTk.aPk.aRL;
            if (fVar == null) {
                fVar = h.f.aQu;
            }
            iArr[i2] = h(fVar.aQt, this.aTk.aPk.aRM.floatValue());
            rf();
            i2++;
        }
        if (a3 == 0.0f || size == 1) {
            rf();
            paint.setColor(iArr[size - 1]);
            AppMethodBeat.o(206623);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        if (aqVar.aQC != null) {
            if (aqVar.aQC == h.k.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (aqVar.aQC == h.k.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        rf();
        RadialGradient radialGradient = new RadialGradient(f2, a2, a3, iArr, fArr, tileMode);
        radialGradient.setLocalMatrix(matrix);
        paint.setShader(radialGradient);
        paint.setAlpha(T(this.aTk.aPk.aRm.floatValue()));
        AppMethodBeat.o(206623);
    }

    private static void a(h.j jVar, String str) {
        AppMethodBeat.i(206624);
        while (true) {
            h.an Z = jVar.aSO.Z(str);
            if (Z == null) {
                String.format("Gradient reference '%s' not found", str);
                AppMethodBeat.o(206624);
                return;
            } else if (!(Z instanceof h.j)) {
                String.format("Gradient href attributes must point to other gradient elements", new Object[0]);
                AppMethodBeat.o(206624);
                return;
            } else if (Z == jVar) {
                String.format("Circular reference in gradient href attribute '%s'", str);
                AppMethodBeat.o(206624);
                return;
            } else {
                h.j jVar2 = (h.j) Z;
                if (jVar.aQA == null) {
                    jVar.aQA = jVar2.aQA;
                }
                if (jVar.aQB == null) {
                    jVar.aQB = jVar2.aQB;
                }
                if (jVar.aQC == null) {
                    jVar.aQC = jVar2.aQC;
                }
                if (jVar.aQz.isEmpty()) {
                    jVar.aQz = jVar2.aQz;
                }
                try {
                    if (jVar instanceof h.am) {
                        a((h.am) jVar, (h.am) Z);
                    } else {
                        a((h.aq) jVar, (h.aq) Z);
                    }
                } catch (ClassCastException e2) {
                }
                if (jVar2.aQk != null) {
                    str = jVar2.aQk;
                } else {
                    AppMethodBeat.o(206624);
                    return;
                }
            }
        }
    }

    private static void a(h.am amVar, h.am amVar2) {
        if (amVar.aQM == null) {
            amVar.aQM = amVar2.aQM;
        }
        if (amVar.aQN == null) {
            amVar.aQN = amVar2.aQN;
        }
        if (amVar.aQO == null) {
            amVar.aQO = amVar2.aQO;
        }
        if (amVar.aQP == null) {
            amVar.aQP = amVar2.aQP;
        }
    }

    private static void a(h.aq aqVar, h.aq aqVar2) {
        if (aqVar.aQp == null) {
            aqVar.aQp = aqVar2.aQp;
        }
        if (aqVar.aQq == null) {
            aqVar.aQq = aqVar2.aQq;
        }
        if (aqVar.aQr == null) {
            aqVar.aQr = aqVar2.aQr;
        }
        if (aqVar.aSQ == null) {
            aqVar.aSQ = aqVar2.aSQ;
        }
        if (aqVar.aSR == null) {
            aqVar.aSR = aqVar2.aSR;
        }
    }

    private void a(boolean z, h.ac acVar) {
        boolean z2 = true;
        AppMethodBeat.i(206625);
        if (z) {
            if (a(acVar.aSM, 2147483648L)) {
                this.aTk.aPk.aRk = acVar.aSM.aRQ;
                g gVar = this.aTk;
                if (acVar.aSM.aRQ == null) {
                    z2 = false;
                }
                gVar.aTG = z2;
            }
            if (a(acVar.aSM, 4294967296L)) {
                this.aTk.aPk.aRm = acVar.aSM.aRR;
            }
            if (a(acVar.aSM, 6442450944L)) {
                g gVar2 = this.aTk;
                a(gVar2, z, gVar2.aPk.aRk);
                AppMethodBeat.o(206625);
                return;
            }
        } else {
            if (a(acVar.aSM, 2147483648L)) {
                this.aTk.aPk.aRn = acVar.aSM.aRQ;
                g gVar3 = this.aTk;
                if (acVar.aSM.aRQ == null) {
                    z2 = false;
                }
                gVar3.aTH = z2;
            }
            if (a(acVar.aSM, 4294967296L)) {
                this.aTk.aPk.aRo = acVar.aSM.aRR;
            }
            if (a(acVar.aSM, 6442450944L)) {
                g gVar4 = this.aTk;
                a(gVar4, z, gVar4.aPk.aRn);
            }
        }
        AppMethodBeat.o(206625);
    }

    private void d(h.ak akVar) {
        AppMethodBeat.i(206626);
        b(akVar, akVar.aSK);
        AppMethodBeat.o(206626);
    }

    private void b(h.ak akVar, h.b bVar) {
        AppMethodBeat.i(206627);
        if (this.aTk.aPk.aRN == null) {
            AppMethodBeat.o(206627);
        } else if (Build.VERSION.SDK_INT >= 19) {
            Path c2 = c(akVar, bVar);
            if (c2 != null) {
                this.aTi.clipPath(c2);
            }
            AppMethodBeat.o(206627);
        } else {
            d(akVar, bVar);
            AppMethodBeat.o(206627);
        }
    }

    @TargetApi(19)
    private Path c(h.ak akVar, h.b bVar) {
        Path a2;
        boolean z = false;
        AppMethodBeat.i(206628);
        h.an Z = akVar.aSO.Z(this.aTk.aPk.aRN);
        if (Z == null) {
            String.format("ClipPath reference '%s' not found", this.aTk.aPk.aRN);
            AppMethodBeat.o(206628);
            return null;
        }
        h.e eVar = (h.e) Z;
        this.aTl.push(this.aTk);
        this.aTk = d((h.an) eVar);
        if (eVar.aQs == null || eVar.aQs.booleanValue()) {
            z = true;
        }
        Matrix matrix = new Matrix();
        if (!z) {
            matrix.preTranslate(bVar.minX, bVar.minY);
            matrix.preScale(bVar.width, bVar.height);
        }
        if (eVar.transform != null) {
            matrix.preConcat(eVar.transform);
        }
        Path path = new Path();
        for (h.an anVar : eVar.aQz) {
            if ((anVar instanceof h.ak) && (a2 = a((h.ak) anVar, true)) != null) {
                path.op(a2, Path.Op.UNION);
            }
        }
        if (this.aTk.aPk.aRN != null) {
            if (eVar.aSK == null) {
                eVar.aSK = e(path);
            }
            Path c2 = c(eVar, eVar.aSK);
            if (c2 != null) {
                path.op(c2, Path.Op.INTERSECT);
            }
        }
        path.transform(matrix);
        this.aTk = this.aTl.pop();
        AppMethodBeat.o(206628);
        return path;
    }

    @TargetApi(19)
    private Path a(h.ak akVar, boolean z) {
        Path a2;
        Path c2;
        AppMethodBeat.i(206629);
        this.aTl.push(this.aTk);
        this.aTk = new g(this.aTk);
        a(this.aTk, akVar);
        if (!rl() || !visible()) {
            this.aTk = this.aTl.pop();
            AppMethodBeat.o(206629);
            return null;
        }
        if (akVar instanceof h.be) {
            if (!z) {
                String.format("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
            }
            h.be beVar = (h.be) akVar;
            h.an Z = akVar.aSO.Z(beVar.aQk);
            if (Z == null) {
                String.format("Use reference '%s' not found", beVar.aQk);
                this.aTk = this.aTl.pop();
                AppMethodBeat.o(206629);
                return null;
            } else if (!(Z instanceof h.ak)) {
                this.aTk = this.aTl.pop();
                AppMethodBeat.o(206629);
                return null;
            } else {
                a2 = a((h.ak) Z, false);
                if (a2 == null) {
                    AppMethodBeat.o(206629);
                    return null;
                }
                if (beVar.aSK == null) {
                    beVar.aSK = e(a2);
                }
                if (beVar.transform != null) {
                    a2.transform(beVar.transform);
                }
            }
        } else if (akVar instanceof h.l) {
            h.l lVar = (h.l) akVar;
            if (akVar instanceof h.v) {
                a2 = new c(((h.v) akVar).aQZ).lR;
                if (akVar.aSK == null) {
                    akVar.aSK = e(a2);
                }
            } else {
                a2 = akVar instanceof h.ab ? a((h.ab) akVar) : akVar instanceof h.d ? a((h.d) akVar) : akVar instanceof h.i ? a((h.i) akVar) : akVar instanceof h.z ? b((h.z) akVar) : null;
            }
            if (a2 == null) {
                AppMethodBeat.o(206629);
                return null;
            }
            if (lVar.aSK == null) {
                lVar.aSK = e(a2);
            }
            if (lVar.transform != null) {
                a2.transform(lVar.transform);
            }
            a2.setFillType(rq());
        } else if (akVar instanceof h.aw) {
            h.aw awVar = (h.aw) akVar;
            a2 = a(awVar);
            if (awVar.transform != null) {
                a2.transform(awVar.transform);
            }
            a2.setFillType(rq());
        } else {
            String.format("Invalid %s element found in clipPath definition", akVar.getNodeName());
            AppMethodBeat.o(206629);
            return null;
        }
        if (!(this.aTk.aPk.aRN == null || (c2 = c(akVar, akVar.aSK)) == null)) {
            a2.op(c2, Path.Op.INTERSECT);
        }
        this.aTk = this.aTl.pop();
        AppMethodBeat.o(206629);
        return a2;
    }

    private void d(h.ak akVar, h.b bVar) {
        AppMethodBeat.i(206630);
        h.an Z = akVar.aSO.Z(this.aTk.aPk.aRN);
        if (Z == null) {
            String.format("ClipPath reference '%s' not found", this.aTk.aPk.aRN);
            AppMethodBeat.o(206630);
            return;
        }
        h.e eVar = (h.e) Z;
        if (eVar.aQz.isEmpty()) {
            this.aTi.clipRect(0, 0, 0, 0);
            AppMethodBeat.o(206630);
            return;
        }
        boolean z = eVar.aQs == null || eVar.aQs.booleanValue();
        if (!(akVar instanceof h.m) || z) {
            ro();
            if (!z) {
                Matrix matrix = new Matrix();
                matrix.preTranslate(bVar.minX, bVar.minY);
                matrix.preScale(bVar.width, bVar.height);
                this.aTi.concat(matrix);
            }
            if (eVar.transform != null) {
                this.aTi.concat(eVar.transform);
            }
            this.aTk = d((h.an) eVar);
            d((h.ak) eVar);
            Path path = new Path();
            for (h.an anVar : eVar.aQz) {
                a(anVar, true, path, new Matrix());
            }
            this.aTi.clipPath(path);
            rp();
            AppMethodBeat.o(206630);
            return;
        }
        String.format("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", akVar.getNodeName());
        AppMethodBeat.o(206630);
    }

    private void a(h.an anVar, boolean z, Path path, Matrix matrix) {
        AppMethodBeat.i(206631);
        if (!rl()) {
            AppMethodBeat.o(206631);
            return;
        }
        ro();
        if (anVar instanceof h.be) {
            if (z) {
                a((h.be) anVar, path, matrix);
            } else {
                String.format("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
            }
        } else if (anVar instanceof h.v) {
            a((h.v) anVar, path, matrix);
        } else if (anVar instanceof h.aw) {
            a((h.aw) anVar, path, matrix);
        } else if (anVar instanceof h.l) {
            a((h.l) anVar, path, matrix);
        } else {
            String.format("Invalid %s element found in clipPath definition", anVar.toString());
        }
        rp();
        AppMethodBeat.o(206631);
    }

    private void ro() {
        AppMethodBeat.i(206632);
        c.c(this.aTi, c.aPv);
        this.aTl.push(this.aTk);
        this.aTk = new g(this.aTk);
        AppMethodBeat.o(206632);
    }

    private void rp() {
        AppMethodBeat.i(206633);
        this.aTi.restore();
        this.aTk = this.aTl.pop();
        AppMethodBeat.o(206633);
    }

    private Path.FillType rq() {
        if (this.aTk.aPk.aRO == null || this.aTk.aPk.aRO != h.ae.a.EvenOdd) {
            return Path.FillType.WINDING;
        }
        return Path.FillType.EVEN_ODD;
    }

    private void a(h.v vVar, Path path, Matrix matrix) {
        AppMethodBeat.i(206634);
        a(this.aTk, vVar);
        if (!rl()) {
            AppMethodBeat.o(206634);
        } else if (!visible()) {
            AppMethodBeat.o(206634);
        } else {
            if (vVar.transform != null) {
                matrix.preConcat(vVar.transform);
            }
            Path path2 = new c(vVar.aQZ).lR;
            if (vVar.aSK == null) {
                vVar.aSK = e(path2);
            }
            d((h.ak) vVar);
            path.setFillType(rq());
            path.addPath(path2, matrix);
            AppMethodBeat.o(206634);
        }
    }

    private void a(h.l lVar, Path path, Matrix matrix) {
        Path b2;
        AppMethodBeat.i(206635);
        a(this.aTk, lVar);
        if (!rl()) {
            AppMethodBeat.o(206635);
        } else if (!visible()) {
            AppMethodBeat.o(206635);
        } else {
            if (lVar.transform != null) {
                matrix.preConcat(lVar.transform);
            }
            if (lVar instanceof h.ab) {
                b2 = a((h.ab) lVar);
            } else if (lVar instanceof h.d) {
                b2 = a((h.d) lVar);
            } else if (lVar instanceof h.i) {
                b2 = a((h.i) lVar);
            } else if (lVar instanceof h.z) {
                b2 = b((h.z) lVar);
            } else {
                AppMethodBeat.o(206635);
                return;
            }
            d((h.ak) lVar);
            path.setFillType(rq());
            path.addPath(b2, matrix);
            AppMethodBeat.o(206635);
        }
    }

    private void a(h.be beVar, Path path, Matrix matrix) {
        AppMethodBeat.i(206636);
        a(this.aTk, beVar);
        if (!rl()) {
            AppMethodBeat.o(206636);
        } else if (!visible()) {
            AppMethodBeat.o(206636);
        } else {
            if (beVar.transform != null) {
                matrix.preConcat(beVar.transform);
            }
            h.an Z = beVar.aSO.Z(beVar.aQk);
            if (Z == null) {
                String.format("Use reference '%s' not found", beVar.aQk);
                AppMethodBeat.o(206636);
                return;
            }
            d((h.ak) beVar);
            a(Z, false, path, matrix);
            AppMethodBeat.o(206636);
        }
    }

    private void a(h.aw awVar, Path path, Matrix matrix) {
        float f2 = 0.0f;
        AppMethodBeat.i(206637);
        a(this.aTk, awVar);
        if (!rl()) {
            AppMethodBeat.o(206637);
            return;
        }
        if (awVar.transform != null) {
            matrix.preConcat(awVar.transform);
        }
        float a2 = (awVar.aSU == null || awVar.aSU.size() == 0) ? 0.0f : ((h.p) awVar.aSU.get(0)).a(this);
        float b2 = (awVar.aSV == null || awVar.aSV.size() == 0) ? 0.0f : ((h.p) awVar.aSV.get(0)).b(this);
        float a3 = (awVar.aSW == null || awVar.aSW.size() == 0) ? 0.0f : ((h.p) awVar.aSW.get(0)).a(this);
        if (!(awVar.aSX == null || awVar.aSX.size() == 0)) {
            f2 = ((h.p) awVar.aSX.get(0)).b(this);
        }
        if (this.aTk.aPk.aRD != h.ae.f.Start) {
            float a4 = a((h.ay) awVar);
            if (this.aTk.aPk.aRD == h.ae.f.Middle) {
                a2 -= a4 / 2.0f;
            } else {
                a2 -= a4;
            }
        }
        if (awVar.aSK == null) {
            h hVar = new h(a2, b2);
            a(awVar, hVar);
            awVar.aSK = new h.b(hVar.aTL.left, hVar.aTL.top, hVar.aTL.width(), hVar.aTL.height());
        }
        d((h.ak) awVar);
        Path path2 = new Path();
        a(awVar, new f(a2 + a3, f2 + b2, path2));
        path.setFillType(rq());
        path.addPath(path2, matrix);
        AppMethodBeat.o(206637);
    }

    /* access modifiers changed from: package-private */
    public class f extends AbstractC0059i {
        Path aTF;
        float x;
        float y;

        f(float f2, float f3, Path path) {
            super(i.this, (byte) 0);
            this.x = f2;
            this.y = f3;
            this.aTF = path;
        }

        @Override // com.a.a.i.AbstractC0059i
        public final boolean b(h.ay ayVar) {
            AppMethodBeat.i(206571);
            if (ayVar instanceof h.az) {
                i.g("Using <textPath> elements in a clip path is not supported.", new Object[0]);
                AppMethodBeat.o(206571);
                return false;
            }
            AppMethodBeat.o(206571);
            return true;
        }

        @Override // com.a.a.i.AbstractC0059i
        public final void ac(String str) {
            AppMethodBeat.i(206572);
            if (i.d(i.this)) {
                Path path = new Path();
                i.this.aTk.aTI.getTextPath(str, 0, str.length(), this.x, this.y, path);
                this.aTF.addPath(path);
            }
            this.x += i.this.aTk.aTI.measureText(str);
            AppMethodBeat.o(206572);
        }
    }

    private Path a(h.ab abVar) {
        float b2;
        float f2;
        AppMethodBeat.i(206638);
        if (abVar.aQx == null && abVar.aQy == null) {
            b2 = 0.0f;
            f2 = 0.0f;
        } else if (abVar.aQx == null) {
            float b3 = abVar.aQy.b(this);
            b2 = b3;
            f2 = b3;
        } else if (abVar.aQy == null) {
            float a2 = abVar.aQx.a(this);
            b2 = a2;
            f2 = a2;
        } else {
            float a3 = abVar.aQx.a(this);
            b2 = abVar.aQy.b(this);
            f2 = a3;
        }
        float min = Math.min(f2, abVar.aQJ.a(this) / 2.0f);
        float min2 = Math.min(b2, abVar.aQK.b(this) / 2.0f);
        float a4 = abVar.aQH != null ? abVar.aQH.a(this) : 0.0f;
        float b4 = abVar.aQI != null ? abVar.aQI.b(this) : 0.0f;
        float a5 = abVar.aQJ.a(this);
        float b5 = abVar.aQK.b(this);
        if (abVar.aSK == null) {
            abVar.aSK = new h.b(a4, b4, a5, b5);
        }
        float f3 = a4 + a5;
        float f4 = b4 + b5;
        Path path = new Path();
        if (min == 0.0f || min2 == 0.0f) {
            path.moveTo(a4, b4);
            path.lineTo(f3, b4);
            path.lineTo(f3, f4);
            path.lineTo(a4, f4);
            path.lineTo(a4, b4);
        } else {
            float f5 = min * 0.5522848f;
            float f6 = min2 * 0.5522848f;
            path.moveTo(a4, b4 + min2);
            path.cubicTo(a4, (b4 + min2) - f6, (a4 + min) - f5, b4, a4 + min, b4);
            path.lineTo(f3 - min, b4);
            path.cubicTo((f3 - min) + f5, b4, f3, (b4 + min2) - f6, f3, b4 + min2);
            path.lineTo(f3, f4 - min2);
            path.cubicTo(f3, (f4 - min2) + f6, (f3 - min) + f5, f4, f3 - min, f4);
            path.lineTo(a4 + min, f4);
            path.cubicTo((a4 + min) - f5, f4, a4, (f4 - min2) + f6, a4, f4 - min2);
            path.lineTo(a4, b4 + min2);
        }
        path.close();
        AppMethodBeat.o(206638);
        return path;
    }

    private Path a(h.d dVar) {
        AppMethodBeat.i(206639);
        float a2 = dVar.aQp != null ? dVar.aQp.a(this) : 0.0f;
        float b2 = dVar.aQq != null ? dVar.aQq.b(this) : 0.0f;
        float c2 = dVar.aQr.c(this);
        float f2 = a2 - c2;
        float f3 = b2 - c2;
        float f4 = a2 + c2;
        float f5 = b2 + c2;
        if (dVar.aSK == null) {
            dVar.aSK = new h.b(f2, f3, 2.0f * c2, 2.0f * c2);
        }
        float f6 = c2 * 0.5522848f;
        Path path = new Path();
        path.moveTo(a2, f3);
        path.cubicTo(a2 + f6, f3, f4, b2 - f6, f4, b2);
        path.cubicTo(f4, b2 + f6, a2 + f6, f5, a2, f5);
        path.cubicTo(a2 - f6, f5, f2, b2 + f6, f2, b2);
        path.cubicTo(f2, b2 - f6, a2 - f6, f3, a2, f3);
        path.close();
        AppMethodBeat.o(206639);
        return path;
    }

    private Path a(h.i iVar) {
        AppMethodBeat.i(206640);
        float a2 = iVar.aQp != null ? iVar.aQp.a(this) : 0.0f;
        float b2 = iVar.aQq != null ? iVar.aQq.b(this) : 0.0f;
        float a3 = iVar.aQx.a(this);
        float b3 = iVar.aQy.b(this);
        float f2 = a2 - a3;
        float f3 = b2 - b3;
        float f4 = a2 + a3;
        float f5 = b2 + b3;
        if (iVar.aSK == null) {
            iVar.aSK = new h.b(f2, f3, 2.0f * a3, 2.0f * b3);
        }
        float f6 = a3 * 0.5522848f;
        float f7 = b3 * 0.5522848f;
        Path path = new Path();
        path.moveTo(a2, f3);
        path.cubicTo(a2 + f6, f3, f4, b2 - f7, f4, b2);
        path.cubicTo(f4, b2 + f7, a2 + f6, f5, a2, f5);
        path.cubicTo(a2 - f6, f5, f2, b2 + f7, f2, b2);
        path.cubicTo(f2, b2 - f7, a2 - f6, f3, a2, f3);
        path.close();
        AppMethodBeat.o(206640);
        return path;
    }

    private static Path b(h.z zVar) {
        AppMethodBeat.i(206641);
        Path path = new Path();
        path.moveTo(zVar.points[0], zVar.points[1]);
        for (int i2 = 2; i2 < zVar.points.length; i2 += 2) {
            path.lineTo(zVar.points[i2], zVar.points[i2 + 1]);
        }
        if (zVar instanceof h.aa) {
            path.close();
        }
        if (zVar.aSK == null) {
            zVar.aSK = e(path);
        }
        AppMethodBeat.o(206641);
        return path;
    }

    private Path a(h.aw awVar) {
        float f2 = 0.0f;
        AppMethodBeat.i(206642);
        float a2 = (awVar.aSU == null || awVar.aSU.size() == 0) ? 0.0f : ((h.p) awVar.aSU.get(0)).a(this);
        float b2 = (awVar.aSV == null || awVar.aSV.size() == 0) ? 0.0f : ((h.p) awVar.aSV.get(0)).b(this);
        float a3 = (awVar.aSW == null || awVar.aSW.size() == 0) ? 0.0f : ((h.p) awVar.aSW.get(0)).a(this);
        if (!(awVar.aSX == null || awVar.aSX.size() == 0)) {
            f2 = ((h.p) awVar.aSX.get(0)).b(this);
        }
        if (this.aTk.aPk.aRD != h.ae.f.Start) {
            float a4 = a((h.ay) awVar);
            if (this.aTk.aPk.aRD == h.ae.f.Middle) {
                a2 -= a4 / 2.0f;
            } else {
                a2 -= a4;
            }
        }
        if (awVar.aSK == null) {
            h hVar = new h(a2, b2);
            a(awVar, hVar);
            awVar.aSK = new h.b(hVar.aTL.left, hVar.aTL.top, hVar.aTL.width(), hVar.aTL.height());
        }
        Path path = new Path();
        a(awVar, new f(a2 + a3, f2 + b2, path));
        AppMethodBeat.o(206642);
        return path;
    }

    private void a(h.ak akVar, Path path, h.y yVar) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        AppMethodBeat.i(206643);
        boolean z = yVar.aRf != null && yVar.aRf.booleanValue();
        if (yVar.aQk != null) {
            a(yVar, yVar.aQk);
        }
        if (z) {
            float a2 = yVar.aQH != null ? yVar.aQH.a(this) : 0.0f;
            float b2 = yVar.aQI != null ? yVar.aQI.b(this) : 0.0f;
            float a3 = yVar.aQJ != null ? yVar.aQJ.a(this) : 0.0f;
            if (yVar.aQK != null) {
                f6 = yVar.aQK.b(this);
            } else {
                f6 = 0.0f;
            }
            f2 = f6;
            f3 = a3;
            f4 = b2;
            f5 = a2;
        } else {
            float a4 = yVar.aQH != null ? yVar.aQH.a(this, 1.0f) : 0.0f;
            float a5 = yVar.aQI != null ? yVar.aQI.a(this, 1.0f) : 0.0f;
            float a6 = yVar.aQJ != null ? yVar.aQJ.a(this, 1.0f) : 0.0f;
            float a7 = yVar.aQK != null ? yVar.aQK.a(this, 1.0f) : 0.0f;
            float f7 = (a4 * akVar.aSK.width) + akVar.aSK.minX;
            float f8 = (a5 * akVar.aSK.height) + akVar.aSK.minY;
            float f9 = a6 * akVar.aSK.width;
            f2 = a7 * akVar.aSK.height;
            f3 = f9;
            f4 = f8;
            f5 = f7;
        }
        if (f3 == 0.0f || f2 == 0.0f) {
            AppMethodBeat.o(206643);
            return;
        }
        f fVar = yVar.aPZ != null ? yVar.aPZ : f.aPD;
        re();
        this.aTi.clipPath(path);
        g gVar = new g();
        a(gVar, h.ae.qU());
        gVar.aPk.aRE = Boolean.FALSE;
        this.aTk = a(yVar, gVar);
        h.b bVar = akVar.aSK;
        if (yVar.aRh != null) {
            this.aTi.concat(yVar.aRh);
            Matrix matrix = new Matrix();
            if (yVar.aRh.invert(matrix)) {
                float[] fArr = {akVar.aSK.minX, akVar.aSK.minY, akVar.aSK.qR(), akVar.aSK.minY, akVar.aSK.qR(), akVar.aSK.qS(), akVar.aSK.minX, akVar.aSK.qS()};
                matrix.mapPoints(fArr);
                RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
                for (int i2 = 2; i2 <= 6; i2 += 2) {
                    if (fArr[i2] < rectF.left) {
                        rectF.left = fArr[i2];
                    }
                    if (fArr[i2] > rectF.right) {
                        rectF.right = fArr[i2];
                    }
                    if (fArr[i2 + 1] < rectF.top) {
                        rectF.top = fArr[i2 + 1];
                    }
                    if (fArr[i2 + 1] > rectF.bottom) {
                        rectF.bottom = fArr[i2 + 1];
                    }
                }
                bVar = new h.b(rectF.left, rectF.top, rectF.right - rectF.left, rectF.bottom - rectF.top);
            }
        }
        float floor = f5 + (((float) Math.floor((double) ((bVar.minX - f5) / f3))) * f3);
        float qR = bVar.qR();
        float qS = bVar.qS();
        h.b bVar2 = new h.b(0.0f, 0.0f, f3, f2);
        boolean rh = rh();
        for (float floor2 = (((float) Math.floor((double) ((bVar.minY - f4) / f2))) * f2) + f4; floor2 < qS; floor2 += f2) {
            for (float f10 = floor; f10 < qR; f10 += f3) {
                bVar2.minX = f10;
                bVar2.minY = floor2;
                re();
                if (!this.aTk.aPk.aRE.booleanValue()) {
                    j(bVar2.minX, bVar2.minY, bVar2.width, bVar2.height);
                }
                if (yVar.aQb != null) {
                    this.aTi.concat(a(bVar2, yVar.aQb, fVar));
                } else {
                    boolean z2 = yVar.aRg == null || yVar.aRg.booleanValue();
                    this.aTi.translate(f10, floor2);
                    if (!z2) {
                        this.aTi.scale(akVar.aSK.width, akVar.aSK.height);
                    }
                }
                for (h.an anVar : yVar.aQz) {
                    b(anVar);
                }
                rf();
            }
        }
        if (rh) {
            b((h.ak) yVar);
        }
        rf();
        AppMethodBeat.o(206643);
    }

    private static void a(h.y yVar, String str) {
        AppMethodBeat.i(206644);
        while (true) {
            h.an Z = yVar.aSO.Z(str);
            if (Z == null) {
                String.format("Pattern reference '%s' not found", str);
                AppMethodBeat.o(206644);
                return;
            } else if (!(Z instanceof h.y)) {
                String.format("Pattern href attributes must point to other pattern elements", new Object[0]);
                AppMethodBeat.o(206644);
                return;
            } else if (Z == yVar) {
                String.format("Circular reference in pattern href attribute '%s'", str);
                AppMethodBeat.o(206644);
                return;
            } else {
                h.y yVar2 = (h.y) Z;
                if (yVar.aRf == null) {
                    yVar.aRf = yVar2.aRf;
                }
                if (yVar.aRg == null) {
                    yVar.aRg = yVar2.aRg;
                }
                if (yVar.aRh == null) {
                    yVar.aRh = yVar2.aRh;
                }
                if (yVar.aQH == null) {
                    yVar.aQH = yVar2.aQH;
                }
                if (yVar.aQI == null) {
                    yVar.aQI = yVar2.aQI;
                }
                if (yVar.aQJ == null) {
                    yVar.aQJ = yVar2.aQJ;
                }
                if (yVar.aQK == null) {
                    yVar.aQK = yVar2.aQK;
                }
                if (yVar.aQz.isEmpty()) {
                    yVar.aQz = yVar2.aQz;
                }
                if (yVar.aQb == null) {
                    yVar.aQb = yVar2.aQb;
                }
                if (yVar.aPZ == null) {
                    yVar.aPZ = yVar2.aPZ;
                }
                if (yVar2.aQk != null) {
                    str = yVar2.aQk;
                } else {
                    AppMethodBeat.o(206644);
                    return;
                }
            }
        }
    }

    private void a(h.s sVar, h.ak akVar, h.b bVar) {
        float f2;
        float f3;
        float f4 = 1.2f;
        AppMethodBeat.i(206645);
        if (sVar.aQW != null && sVar.aQW.booleanValue()) {
            f2 = sVar.aQJ != null ? sVar.aQJ.a(this) : bVar.width;
            if (sVar.aQK != null) {
                f3 = sVar.aQK.b(this);
            } else {
                f3 = bVar.height;
            }
        } else {
            float a2 = sVar.aQJ != null ? sVar.aQJ.a(this, 1.0f) : 1.2f;
            if (sVar.aQK != null) {
                f4 = sVar.aQK.a(this, 1.0f);
            }
            f2 = a2 * bVar.width;
            f3 = f4 * bVar.height;
        }
        if (f2 == 0.0f || f3 == 0.0f) {
            AppMethodBeat.o(206645);
            return;
        }
        re();
        this.aTk = d((h.an) sVar);
        this.aTk.aPk.aRv = Float.valueOf(1.0f);
        boolean rh = rh();
        this.aTi.save();
        if (!(sVar.aQX == null || sVar.aQX.booleanValue())) {
            this.aTi.translate(bVar.minX, bVar.minY);
            this.aTi.scale(bVar.width, bVar.height);
        }
        a((h.aj) sVar, false);
        this.aTi.restore();
        if (rh) {
            a(akVar, bVar);
        }
        rf();
        AppMethodBeat.o(206645);
    }

    static /* synthetic */ void f(String str, Object[] objArr) {
        AppMethodBeat.i(206647);
        String.format(str, objArr);
        AppMethodBeat.o(206647);
    }

    static /* synthetic */ void a(float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, float f7, float f8, h.x xVar) {
        double d2;
        double d3;
        double acos;
        AppMethodBeat.i(206648);
        if (!(f2 == f7 && f3 == f8)) {
            if (f4 == 0.0f || f5 == 0.0f) {
                xVar.lineTo(f7, f8);
                AppMethodBeat.o(206648);
                return;
            }
            float abs = Math.abs(f4);
            float abs2 = Math.abs(f5);
            double radians = Math.toRadians(((double) f6) % 360.0d);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d4 = ((double) (f2 - f7)) / 2.0d;
            double d5 = ((double) (f3 - f8)) / 2.0d;
            double d6 = (cos * d4) + (sin * d5);
            double d7 = (d4 * (-sin)) + (d5 * cos);
            double d8 = (double) (abs * abs);
            double d9 = (double) (abs2 * abs2);
            double d10 = d6 * d6;
            double d11 = d7 * d7;
            double d12 = (d10 / d8) + (d11 / d9);
            if (d12 > 0.99999d) {
                double sqrt = Math.sqrt(d12) * 1.00001d;
                abs = (float) (((double) abs) * sqrt);
                abs2 = (float) (sqrt * ((double) abs2));
                d2 = (double) (abs2 * abs2);
                d3 = (double) (abs * abs);
            } else {
                d2 = d9;
                d3 = d8;
            }
            double d13 = z == z2 ? -1.0d : 1.0d;
            double d14 = (((d3 * d2) - (d3 * d11)) - (d2 * d10)) / ((d2 * d10) + (d3 * d11));
            if (d14 < 0.0d) {
                d14 = 0.0d;
            }
            double sqrt2 = Math.sqrt(d14) * d13;
            double d15 = ((((double) abs) * d7) / ((double) abs2)) * sqrt2;
            double d16 = sqrt2 * (-((((double) abs2) * d6) / ((double) abs)));
            double d17 = (((double) (f2 + f7)) / 2.0d) + ((cos * d15) - (sin * d16));
            double d18 = (((double) (f3 + f8)) / 2.0d) + (cos * d16) + (sin * d15);
            double d19 = (d6 - d15) / ((double) abs);
            double d20 = (d7 - d16) / ((double) abs2);
            double d21 = ((-d6) - d15) / ((double) abs);
            double d22 = ((-d7) - d16) / ((double) abs2);
            double acos2 = Math.acos(d19 / Math.sqrt((d19 * d19) + (d20 * d20))) * (d20 < 0.0d ? -1.0d : 1.0d);
            double sqrt3 = Math.sqrt(((d19 * d19) + (d20 * d20)) * ((d21 * d21) + (d22 * d22)));
            double d23 = (d20 * d22) + (d19 * d21);
            double d24 = (d19 * d22) - (d21 * d20) < 0.0d ? -1.0d : 1.0d;
            double d25 = d23 / sqrt3;
            if (d25 < -1.0d) {
                acos = 3.141592653589793d;
            } else {
                acos = d25 > 1.0d ? 0.0d : Math.acos(d25);
            }
            double d26 = acos * d24;
            if (d26 == 0.0d) {
                xVar.lineTo(f7, f8);
                AppMethodBeat.o(206648);
                return;
            }
            if (!z2 && d26 > 0.0d) {
                d26 -= 6.283185307179586d;
            } else if (z2 && d26 < 0.0d) {
                d26 += 6.283185307179586d;
            }
            double d27 = d26 % 6.283185307179586d;
            double d28 = acos2 % 6.283185307179586d;
            int ceil = (int) Math.ceil((Math.abs(d27) * 2.0d) / 3.141592653589793d);
            double d29 = d27 / ((double) ceil);
            double sin2 = (1.3333333333333333d * Math.sin(d29 / 2.0d)) / (1.0d + Math.cos(d29 / 2.0d));
            float[] fArr = new float[(ceil * 6)];
            int i2 = 0;
            for (int i3 = 0; i3 < ceil; i3++) {
                double d30 = (((double) i3) * d29) + d28;
                double cos2 = Math.cos(d30);
                double sin3 = Math.sin(d30);
                int i4 = i2 + 1;
                fArr[i2] = (float) (cos2 - (sin2 * sin3));
                int i5 = i4 + 1;
                fArr[i4] = (float) ((cos2 * sin2) + sin3);
                double d31 = d30 + d29;
                double cos3 = Math.cos(d31);
                double sin4 = Math.sin(d31);
                int i6 = i5 + 1;
                fArr[i5] = (float) ((sin2 * sin4) + cos3);
                int i7 = i6 + 1;
                fArr[i6] = (float) (sin4 - (sin2 * cos3));
                int i8 = i7 + 1;
                fArr[i7] = (float) cos3;
                i2 = i8 + 1;
                fArr[i8] = (float) sin4;
            }
            Matrix matrix = new Matrix();
            matrix.postScale(abs, abs2);
            matrix.postRotate(f6);
            matrix.postTranslate((float) d17, (float) d18);
            matrix.mapPoints(fArr);
            fArr[fArr.length - 2] = f7;
            fArr[fArr.length - 1] = f8;
            for (int i9 = 0; i9 < fArr.length; i9 += 6) {
                xVar.cubicTo(fArr[i9], fArr[i9 + 1], fArr[i9 + 2], fArr[i9 + 3], fArr[i9 + 4], fArr[i9 + 5]);
            }
        }
        AppMethodBeat.o(206648);
    }

    static /* synthetic */ void g(String str, Object[] objArr) {
        AppMethodBeat.i(206649);
        String.format(str, objArr);
        AppMethodBeat.o(206649);
    }
}
