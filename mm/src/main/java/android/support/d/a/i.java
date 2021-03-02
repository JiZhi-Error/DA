package android.support.d.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.support.v4.graphics.c;
import android.util.AttributeSet;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class i extends h {
    static final PorterDuff.Mode xl = PorterDuff.Mode.SRC_IN;
    g xm;
    private PorterDuffColorFilter xn;
    private ColorFilter xo;
    private boolean xp;
    boolean xq;
    private Drawable.ConstantState xr;
    private final float[] xs;
    private final Matrix xt;
    private final Rect xu;

    @Override // android.support.d.a.h
    public final /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.support.d.a.h
    public final /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.support.d.a.h
    public final /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    @Override // android.support.d.a.h
    public final /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.support.d.a.h
    public final /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // android.support.d.a.h
    public final /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.support.d.a.h
    public final /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // android.support.d.a.h
    public final /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // android.support.d.a.h
    public final /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.support.d.a.h
    public final /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.support.d.a.h
    public final /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    @Override // android.support.d.a.h
    public final /* bridge */ /* synthetic */ void setColorFilter(int i2, PorterDuff.Mode mode) {
        super.setColorFilter(i2, mode);
    }

    @Override // android.support.d.a.h
    public final /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // android.support.d.a.h
    public final /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // android.support.d.a.h
    public final /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    @Override // android.support.d.a.h
    public final /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    i() {
        this.xq = true;
        this.xs = new float[9];
        this.xt = new Matrix();
        this.xu = new Rect();
        this.xm = new g();
    }

    i(g gVar) {
        this.xq = true;
        this.xs = new float[9];
        this.xt = new Matrix();
        this.xu = new Rect();
        this.xm = gVar;
        this.xn = a(gVar.yk, gVar.yl);
    }

    public final Drawable mutate() {
        if (this.xk != null) {
            this.xk.mutate();
        } else if (!this.xp && super.mutate() == this) {
            this.xm = new g(this.xm);
            this.xp = true;
        }
        return this;
    }

    public final Drawable.ConstantState getConstantState() {
        if (this.xk != null && Build.VERSION.SDK_INT >= 24) {
            return new h(this.xk.getConstantState());
        }
        this.xm.mChangingConfigurations = getChangingConfigurations();
        return this.xm;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d3, code lost:
        if (r1 == false) goto L_0x00d5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void draw(android.graphics.Canvas r12) {
        /*
        // Method dump skipped, instructions count: 379
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.d.a.i.draw(android.graphics.Canvas):void");
    }

    public final int getAlpha() {
        if (this.xk != null) {
            return android.support.v4.graphics.drawable.a.f(this.xk);
        }
        return this.xm.yj.getRootAlpha();
    }

    public final void setAlpha(int i2) {
        if (this.xk != null) {
            this.xk.setAlpha(i2);
        } else if (this.xm.yj.getRootAlpha() != i2) {
            this.xm.yj.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.xk != null) {
            this.xk.setColorFilter(colorFilter);
            return;
        }
        this.xo = colorFilter;
        invalidateSelf();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.support.v4.graphics.drawable.e
    public final void setTint(int i2) {
        if (this.xk != null) {
            android.support.v4.graphics.drawable.a.a(this.xk, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    @Override // android.support.v4.graphics.drawable.e
    public final void setTintList(ColorStateList colorStateList) {
        if (this.xk != null) {
            android.support.v4.graphics.drawable.a.a(this.xk, colorStateList);
            return;
        }
        g gVar = this.xm;
        if (gVar.yk != colorStateList) {
            gVar.yk = colorStateList;
            this.xn = a(colorStateList, gVar.yl);
            invalidateSelf();
        }
    }

    @Override // android.support.v4.graphics.drawable.e
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.xk != null) {
            android.support.v4.graphics.drawable.a.a(this.xk, mode);
            return;
        }
        g gVar = this.xm;
        if (gVar.yl != mode) {
            gVar.yl = mode;
            this.xn = a(gVar.yk, mode);
            invalidateSelf();
        }
    }

    public final boolean isStateful() {
        if (this.xk != null) {
            return this.xk.isStateful();
        }
        return super.isStateful() || (this.xm != null && (this.xm.yj.isStateful() || (this.xm.yk != null && this.xm.yk.isStateful())));
    }

    /* access modifiers changed from: protected */
    public final boolean onStateChange(int[] iArr) {
        if (this.xk != null) {
            return this.xk.setState(iArr);
        }
        boolean z = false;
        g gVar = this.xm;
        if (!(gVar.yk == null || gVar.yl == null)) {
            this.xn = a(gVar.yk, gVar.yl);
            invalidateSelf();
            z = true;
        }
        if (!gVar.yj.isStateful()) {
            return z;
        }
        boolean e2 = gVar.yj.ya.e(iArr);
        gVar.ys |= e2;
        if (!e2) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    public final int getOpacity() {
        if (this.xk != null) {
            return this.xk.getOpacity();
        }
        return -3;
    }

    public final int getIntrinsicWidth() {
        if (this.xk != null) {
            return this.xk.getIntrinsicWidth();
        }
        return (int) this.xm.yj.yb;
    }

    public final int getIntrinsicHeight() {
        if (this.xk != null) {
            return this.xk.getIntrinsicHeight();
        }
        return (int) this.xm.yj.yc;
    }

    public final boolean canApplyTheme() {
        if (this.xk == null) {
            return false;
        }
        android.support.v4.graphics.drawable.a.g(this.xk);
        return false;
    }

    public final boolean isAutoMirrored() {
        if (this.xk != null) {
            return android.support.v4.graphics.drawable.a.e(this.xk);
        }
        return this.xm.ym;
    }

    public final void setAutoMirrored(boolean z) {
        if (this.xk != null) {
            android.support.v4.graphics.drawable.a.a(this.xk, z);
        } else {
            this.xm.ym = z;
        }
    }

    public static i a(Resources resources, int i2, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            i iVar = new i();
            iVar.xk = android.support.v4.content.a.f.c(resources, i2, theme);
            iVar.xr = new h(iVar.xk.getConstantState());
            return iVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i2);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return a(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException | XmlPullParserException e2) {
            return null;
        }
    }

    public static i a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        i iVar = new i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    static int d(int i2, float f2) {
        return (((int) (((float) Color.alpha(i2)) * f2)) << 24) | (16777215 & i2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.xk != null) {
            this.xk.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        if (this.xk != null) {
            android.support.v4.graphics.drawable.a.a(this.xk, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        g gVar = this.xm;
        gVar.yj = new f();
        TypedArray a2 = android.support.v4.content.a.g.a(resources, theme, attributeSet, a.wK);
        g gVar2 = this.xm;
        f fVar = gVar2.yj;
        int a3 = android.support.v4.content.a.g.a(a2, xmlPullParser, "tintMode", 6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        switch (a3) {
            case 3:
                mode = PorterDuff.Mode.SRC_OVER;
                break;
            case 5:
                mode = PorterDuff.Mode.SRC_IN;
                break;
            case 9:
                mode = PorterDuff.Mode.SRC_ATOP;
                break;
            case 14:
                mode = PorterDuff.Mode.MULTIPLY;
                break;
            case 15:
                mode = PorterDuff.Mode.SCREEN;
                break;
            case 16:
                mode = PorterDuff.Mode.ADD;
                break;
        }
        gVar2.yl = mode;
        ColorStateList colorStateList = a2.getColorStateList(1);
        if (colorStateList != null) {
            gVar2.yk = colorStateList;
        }
        gVar2.ym = android.support.v4.content.a.g.a(a2, xmlPullParser, "autoMirrored", 5, gVar2.ym);
        fVar.yd = android.support.v4.content.a.g.a(a2, xmlPullParser, "viewportWidth", 7, fVar.yd);
        fVar.ye = android.support.v4.content.a.g.a(a2, xmlPullParser, "viewportHeight", 8, fVar.ye);
        if (fVar.yd <= 0.0f) {
            throw new XmlPullParserException(a2.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (fVar.ye <= 0.0f) {
            throw new XmlPullParserException(a2.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            fVar.yb = a2.getDimension(3, fVar.yb);
            fVar.yc = a2.getDimension(2, fVar.yc);
            if (fVar.yb <= 0.0f) {
                throw new XmlPullParserException(a2.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (fVar.yc <= 0.0f) {
                throw new XmlPullParserException(a2.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                fVar.setAlpha(android.support.v4.content.a.g.a(a2, xmlPullParser, "alpha", 4, fVar.getAlpha()));
                String string = a2.getString(0);
                if (string != null) {
                    fVar.yg = string;
                    fVar.yi.put(string, fVar);
                }
                a2.recycle();
                gVar.mChangingConfigurations = getChangingConfigurations();
                gVar.ys = true;
                b(resources, xmlPullParser, attributeSet, theme);
                this.xn = a(gVar.yk, gVar.yl);
            }
        }
    }

    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        boolean z;
        g gVar = this.xm;
        f fVar = gVar.yj;
        boolean z2 = true;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(fVar.ya);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        int i2 = eventType;
        while (i2 != 1 && (xmlPullParser.getDepth() >= depth || i2 != 3)) {
            if (i2 == 2) {
                String name = xmlPullParser.getName();
                c cVar = (c) arrayDeque.peek();
                if ("path".equals(name)) {
                    b bVar = new b();
                    TypedArray a2 = android.support.v4.content.a.g.a(resources, theme, attributeSet, a.wM);
                    bVar.a(a2, xmlPullParser, theme);
                    a2.recycle();
                    cVar.mChildren.add(bVar);
                    if (bVar.getPathName() != null) {
                        fVar.yi.put(bVar.getPathName(), bVar);
                    }
                    z = false;
                    gVar.mChangingConfigurations = bVar.mChangingConfigurations | gVar.mChangingConfigurations;
                } else if ("clip-path".equals(name)) {
                    a aVar = new a();
                    if (android.support.v4.content.a.g.a(xmlPullParser, "pathData")) {
                        TypedArray a3 = android.support.v4.content.a.g.a(resources, theme, attributeSet, a.wN);
                        aVar.a(a3);
                        a3.recycle();
                    }
                    cVar.mChildren.add(aVar);
                    if (aVar.getPathName() != null) {
                        fVar.yi.put(aVar.getPathName(), aVar);
                    }
                    gVar.mChangingConfigurations |= aVar.mChangingConfigurations;
                    z = z2;
                } else {
                    if ("group".equals(name)) {
                        c cVar2 = new c();
                        TypedArray a4 = android.support.v4.content.a.g.a(resources, theme, attributeSet, a.wL);
                        cVar2.xv = null;
                        cVar2.xI = android.support.v4.content.a.g.a(a4, xmlPullParser, "rotation", 5, cVar2.xI);
                        cVar2.xJ = a4.getFloat(1, cVar2.xJ);
                        cVar2.xK = a4.getFloat(2, cVar2.xK);
                        cVar2.xL = android.support.v4.content.a.g.a(a4, xmlPullParser, "scaleX", 3, cVar2.xL);
                        cVar2.xM = android.support.v4.content.a.g.a(a4, xmlPullParser, "scaleY", 4, cVar2.xM);
                        cVar2.xN = android.support.v4.content.a.g.a(a4, xmlPullParser, "translateX", 6, cVar2.xN);
                        cVar2.xO = android.support.v4.content.a.g.a(a4, xmlPullParser, "translateY", 7, cVar2.xO);
                        String string = a4.getString(0);
                        if (string != null) {
                            cVar2.xQ = string;
                        }
                        cVar2.dB();
                        a4.recycle();
                        cVar.mChildren.add(cVar2);
                        arrayDeque.push(cVar2);
                        if (cVar2.getGroupName() != null) {
                            fVar.yi.put(cVar2.getGroupName(), cVar2);
                        }
                        gVar.mChangingConfigurations |= cVar2.mChangingConfigurations;
                    }
                    z = z2;
                }
            } else {
                if (i2 == 3 && "group".equals(xmlPullParser.getName())) {
                    arrayDeque.pop();
                }
                z = z2;
            }
            i2 = xmlPullParser.next();
            z2 = z;
        }
        if (z2) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.d.a.h
    public final void onBoundsChange(Rect rect) {
        if (this.xk != null) {
            this.xk.setBounds(rect);
        }
    }

    public final int getChangingConfigurations() {
        if (this.xk != null) {
            return this.xk.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.xm.getChangingConfigurations();
    }

    public final void invalidateSelf() {
        if (this.xk != null) {
            this.xk.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public final void scheduleSelf(Runnable runnable, long j2) {
        if (this.xk != null) {
            this.xk.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        if (this.xk != null) {
            return this.xk.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public final void unscheduleSelf(Runnable runnable) {
        if (this.xk != null) {
            this.xk.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    static class h extends Drawable.ConstantState {
        private final Drawable.ConstantState xf;

        public h(Drawable.ConstantState constantState) {
            this.xf = constantState;
        }

        public final Drawable newDrawable() {
            i iVar = new i();
            iVar.xk = (VectorDrawable) this.xf.newDrawable();
            return iVar;
        }

        public final Drawable newDrawable(Resources resources) {
            i iVar = new i();
            iVar.xk = (VectorDrawable) this.xf.newDrawable(resources);
            return iVar;
        }

        public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
            i iVar = new i();
            iVar.xk = (VectorDrawable) this.xf.newDrawable(resources, theme);
            return iVar;
        }

        public final boolean canApplyTheme() {
            return this.xf.canApplyTheme();
        }

        public final int getChangingConfigurations() {
            return this.xf.getChangingConfigurations();
        }
    }

    /* access modifiers changed from: package-private */
    public static class g extends Drawable.ConstantState {
        int mChangingConfigurations;
        f yj;
        ColorStateList yk;
        PorterDuff.Mode yl;
        boolean ym;
        Bitmap yn;
        ColorStateList yo;
        PorterDuff.Mode yp;
        int yq;
        boolean yr;
        boolean ys;
        Paint yt;

        public g(g gVar) {
            this.yk = null;
            this.yl = i.xl;
            if (gVar != null) {
                this.mChangingConfigurations = gVar.mChangingConfigurations;
                this.yj = new f(gVar.yj);
                if (gVar.yj.xY != null) {
                    this.yj.xY = new Paint(gVar.yj.xY);
                }
                if (gVar.yj.xX != null) {
                    this.yj.xX = new Paint(gVar.yj.xX);
                }
                this.yk = gVar.yk;
                this.yl = gVar.yl;
                this.ym = gVar.ym;
            }
        }

        public final void s(int i2, int i3) {
            this.yn.eraseColor(0);
            this.yj.a(new Canvas(this.yn), i2, i3);
        }

        public g() {
            this.yk = null;
            this.yl = i.xl;
            this.yj = new f();
        }

        public final Drawable newDrawable() {
            return new i(this);
        }

        public final Drawable newDrawable(Resources resources) {
            return new i(this);
        }

        public final int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }
    }

    /* access modifiers changed from: package-private */
    public static class f {
        private static final Matrix xV = new Matrix();
        private int mChangingConfigurations;
        private final Path xT;
        private final Path xU;
        private final Matrix xW;
        Paint xX;
        Paint xY;
        private PathMeasure xZ;
        final c ya;
        float yb;
        float yc;
        float yd;
        float ye;
        int yf;
        String yg;
        Boolean yh;
        final android.support.v4.e.a<String, Object> yi;

        public f() {
            this.xW = new Matrix();
            this.yb = 0.0f;
            this.yc = 0.0f;
            this.yd = 0.0f;
            this.ye = 0.0f;
            this.yf = 255;
            this.yg = null;
            this.yh = null;
            this.yi = new android.support.v4.e.a<>();
            this.ya = new c();
            this.xT = new Path();
            this.xU = new Path();
        }

        public final void setRootAlpha(int i2) {
            this.yf = i2;
        }

        public final int getRootAlpha() {
            return this.yf;
        }

        public final void setAlpha(float f2) {
            setRootAlpha((int) (255.0f * f2));
        }

        public final float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public f(f fVar) {
            this.xW = new Matrix();
            this.yb = 0.0f;
            this.yc = 0.0f;
            this.yd = 0.0f;
            this.ye = 0.0f;
            this.yf = 255;
            this.yg = null;
            this.yh = null;
            this.yi = new android.support.v4.e.a<>();
            this.ya = new c(fVar.ya, this.yi);
            this.xT = new Path(fVar.xT);
            this.xU = new Path(fVar.xU);
            this.yb = fVar.yb;
            this.yc = fVar.yc;
            this.yd = fVar.yd;
            this.ye = fVar.ye;
            this.mChangingConfigurations = fVar.mChangingConfigurations;
            this.yf = fVar.yf;
            this.yg = fVar.yg;
            if (fVar.yg != null) {
                this.yi.put(fVar.yg, this);
            }
            this.yh = fVar.yh;
        }

        private void a(c cVar, Matrix matrix, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            cVar.xH.set(matrix);
            cVar.xH.preConcat(cVar.xP);
            canvas.save();
            for (int i4 = 0; i4 < cVar.mChildren.size(); i4++) {
                d dVar = cVar.mChildren.get(i4);
                if (dVar instanceof c) {
                    a((c) dVar, cVar.xH, canvas, i2, i3, colorFilter);
                } else if (dVar instanceof e) {
                    e eVar = (e) dVar;
                    float f2 = ((float) i2) / this.yd;
                    float f3 = ((float) i3) / this.ye;
                    float min = Math.min(f2, f3);
                    Matrix matrix2 = cVar.xH;
                    this.xW.set(matrix2);
                    this.xW.postScale(f2, f3);
                    float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                    matrix2.mapVectors(fArr);
                    float f4 = (fArr[3] * fArr[0]) - (fArr[1] * fArr[2]);
                    float max = Math.max((float) Math.hypot((double) fArr[0], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
                    float abs = max > 0.0f ? Math.abs(f4) / max : 0.0f;
                    if (abs != 0.0f) {
                        eVar.b(this.xT);
                        Path path = this.xT;
                        this.xU.reset();
                        if (eVar.dA()) {
                            this.xU.addPath(path, this.xW);
                            canvas.clipPath(this.xU);
                        } else {
                            b bVar = (b) eVar;
                            if (!(bVar.xB == 0.0f && bVar.xC == 1.0f)) {
                                float f5 = (bVar.xB + bVar.xD) % 1.0f;
                                float f6 = (bVar.xC + bVar.xD) % 1.0f;
                                if (this.xZ == null) {
                                    this.xZ = new PathMeasure();
                                }
                                this.xZ.setPath(this.xT, false);
                                float length = this.xZ.getLength();
                                float f7 = f5 * length;
                                float f8 = f6 * length;
                                path.reset();
                                if (f7 > f8) {
                                    this.xZ.getSegment(f7, length, path, true);
                                    this.xZ.getSegment(0.0f, f8, path, true);
                                } else {
                                    this.xZ.getSegment(f7, f8, path, true);
                                }
                                path.rLineTo(0.0f, 0.0f);
                            }
                            this.xU.addPath(path, this.xW);
                            if (bVar.xx.ey()) {
                                android.support.v4.content.a.b bVar2 = bVar.xx;
                                if (this.xY == null) {
                                    this.xY = new Paint(1);
                                    this.xY.setStyle(Paint.Style.FILL);
                                }
                                Paint paint = this.xY;
                                if (bVar2.ex()) {
                                    Shader shader = bVar2.JC;
                                    shader.setLocalMatrix(this.xW);
                                    paint.setShader(shader);
                                    paint.setAlpha(Math.round(bVar.xA * 255.0f));
                                } else {
                                    paint.setColor(i.d(bVar2.mColor, bVar.xA));
                                }
                                paint.setColorFilter(colorFilter);
                                this.xU.setFillType(bVar.xz == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                canvas.drawPath(this.xU, paint);
                            }
                            if (bVar.xw.ey()) {
                                android.support.v4.content.a.b bVar3 = bVar.xw;
                                if (this.xX == null) {
                                    this.xX = new Paint(1);
                                    this.xX.setStyle(Paint.Style.STROKE);
                                }
                                Paint paint2 = this.xX;
                                if (bVar.xF != null) {
                                    paint2.setStrokeJoin(bVar.xF);
                                }
                                if (bVar.xE != null) {
                                    paint2.setStrokeCap(bVar.xE);
                                }
                                paint2.setStrokeMiter(bVar.xG);
                                if (bVar3.ex()) {
                                    Shader shader2 = bVar3.JC;
                                    shader2.setLocalMatrix(this.xW);
                                    paint2.setShader(shader2);
                                    paint2.setAlpha(Math.round(bVar.xy * 255.0f));
                                } else {
                                    paint2.setColor(i.d(bVar3.mColor, bVar.xy));
                                }
                                paint2.setColorFilter(colorFilter);
                                paint2.setStrokeWidth(bVar.mStrokeWidth * min * abs);
                                canvas.drawPath(this.xU, paint2);
                            }
                        }
                    }
                }
            }
            canvas.restore();
        }

        public final void a(Canvas canvas, int i2, int i3) {
            a(this.ya, xV, canvas, i2, i3, null);
        }

        public final boolean isStateful() {
            if (this.yh == null) {
                this.yh = Boolean.valueOf(this.ya.isStateful());
            }
            return this.yh.booleanValue();
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class d {
        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }

        public boolean isStateful() {
            return false;
        }

        public boolean e(int[] iArr) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public static class c extends d {
        int mChangingConfigurations;
        final ArrayList<d> mChildren = new ArrayList<>();
        final Matrix xH = new Matrix();
        float xI = 0.0f;
        float xJ = 0.0f;
        float xK = 0.0f;
        float xL = 1.0f;
        float xM = 1.0f;
        float xN = 0.0f;
        float xO = 0.0f;
        final Matrix xP = new Matrix();
        String xQ = null;
        int[] xv;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v0, types: [android.support.v4.e.a<java.lang.String, java.lang.Object>, android.support.v4.e.a] */
        /* JADX WARN: Type inference failed for: r2v9, types: [android.support.d.a.i$b] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public c(android.support.d.a.i.c r6, android.support.v4.e.a<java.lang.String, java.lang.Object> r7) {
            /*
            // Method dump skipped, instructions count: 184
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.d.a.i.c.<init>(android.support.d.a.i$c, android.support.v4.e.a):void");
        }

        public c() {
            super((byte) 0);
        }

        public final String getGroupName() {
            return this.xQ;
        }

        public final Matrix getLocalMatrix() {
            return this.xP;
        }

        /* access modifiers changed from: package-private */
        public final void dB() {
            this.xP.reset();
            this.xP.postTranslate(-this.xJ, -this.xK);
            this.xP.postScale(this.xL, this.xM);
            this.xP.postRotate(this.xI, 0.0f, 0.0f);
            this.xP.postTranslate(this.xN + this.xJ, this.xO + this.xK);
        }

        public final float getRotation() {
            return this.xI;
        }

        public final void setRotation(float f2) {
            if (f2 != this.xI) {
                this.xI = f2;
                dB();
            }
        }

        public final float getPivotX() {
            return this.xJ;
        }

        public final void setPivotX(float f2) {
            if (f2 != this.xJ) {
                this.xJ = f2;
                dB();
            }
        }

        public final float getPivotY() {
            return this.xK;
        }

        public final void setPivotY(float f2) {
            if (f2 != this.xK) {
                this.xK = f2;
                dB();
            }
        }

        public final float getScaleX() {
            return this.xL;
        }

        public final void setScaleX(float f2) {
            if (f2 != this.xL) {
                this.xL = f2;
                dB();
            }
        }

        public final float getScaleY() {
            return this.xM;
        }

        public final void setScaleY(float f2) {
            if (f2 != this.xM) {
                this.xM = f2;
                dB();
            }
        }

        public final float getTranslateX() {
            return this.xN;
        }

        public final void setTranslateX(float f2) {
            if (f2 != this.xN) {
                this.xN = f2;
                dB();
            }
        }

        public final float getTranslateY() {
            return this.xO;
        }

        public final void setTranslateY(float f2) {
            if (f2 != this.xO) {
                this.xO = f2;
                dB();
            }
        }

        @Override // android.support.d.a.i.d
        public final boolean isStateful() {
            for (int i2 = 0; i2 < this.mChildren.size(); i2++) {
                if (this.mChildren.get(i2).isStateful()) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.support.d.a.i.d
        public final boolean e(int[] iArr) {
            boolean z = false;
            for (int i2 = 0; i2 < this.mChildren.size(); i2++) {
                z |= this.mChildren.get(i2).e(iArr);
            }
            return z;
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class e extends d {
        int mChangingConfigurations;
        protected c.b[] xR = null;
        String xS;

        public e() {
            super((byte) 0);
        }

        public e(e eVar) {
            super((byte) 0);
            this.xS = eVar.xS;
            this.mChangingConfigurations = eVar.mChangingConfigurations;
            this.xR = android.support.v4.graphics.c.a(eVar.xR);
        }

        public final void b(Path path) {
            path.reset();
            if (this.xR != null) {
                c.b.a(this.xR, path);
            }
        }

        public String getPathName() {
            return this.xS;
        }

        public boolean dA() {
            return false;
        }

        public c.b[] getPathData() {
            return this.xR;
        }

        public void setPathData(c.b[] bVarArr) {
            if (!android.support.v4.graphics.c.a(this.xR, bVarArr)) {
                this.xR = android.support.v4.graphics.c.a(bVarArr);
                return;
            }
            c.b[] bVarArr2 = this.xR;
            for (int i2 = 0; i2 < bVarArr.length; i2++) {
                bVarArr2[i2].JT = bVarArr[i2].JT;
                for (int i3 = 0; i3 < bVarArr[i2].JU.length; i3++) {
                    bVarArr2[i2].JU[i3] = bVarArr[i2].JU[i3];
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends e {
        public a() {
        }

        public a(a aVar) {
            super(aVar);
        }

        /* access modifiers changed from: package-private */
        public final void a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.xS = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.xR = android.support.v4.graphics.c.y(string2);
            }
        }

        @Override // android.support.d.a.i.e
        public final boolean dA() {
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b extends e {
        float mStrokeWidth = 0.0f;
        float xA = 1.0f;
        float xB = 0.0f;
        float xC = 1.0f;
        float xD = 0.0f;
        Paint.Cap xE = Paint.Cap.BUTT;
        Paint.Join xF = Paint.Join.MITER;
        float xG = 4.0f;
        private int[] xv;
        android.support.v4.content.a.b xw;
        android.support.v4.content.a.b xx;
        float xy = 1.0f;
        int xz = 0;

        public b() {
        }

        public b(b bVar) {
            super(bVar);
            this.xv = bVar.xv;
            this.xw = bVar.xw;
            this.mStrokeWidth = bVar.mStrokeWidth;
            this.xy = bVar.xy;
            this.xx = bVar.xx;
            this.xz = bVar.xz;
            this.xA = bVar.xA;
            this.xB = bVar.xB;
            this.xC = bVar.xC;
            this.xD = bVar.xD;
            this.xE = bVar.xE;
            this.xF = bVar.xF;
            this.xG = bVar.xG;
        }

        /* access modifiers changed from: package-private */
        public final void a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.xv = null;
            if (android.support.v4.content.a.g.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.xS = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.xR = android.support.v4.graphics.c.y(string2);
                }
                this.xx = android.support.v4.content.a.g.a(typedArray, xmlPullParser, theme, "fillColor", 1);
                this.xA = android.support.v4.content.a.g.a(typedArray, xmlPullParser, "fillAlpha", 12, this.xA);
                int a2 = android.support.v4.content.a.g.a(typedArray, xmlPullParser, "strokeLineCap", 8, -1);
                Paint.Cap cap = this.xE;
                switch (a2) {
                    case 0:
                        cap = Paint.Cap.BUTT;
                        break;
                    case 1:
                        cap = Paint.Cap.ROUND;
                        break;
                    case 2:
                        cap = Paint.Cap.SQUARE;
                        break;
                }
                this.xE = cap;
                int a3 = android.support.v4.content.a.g.a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1);
                Paint.Join join = this.xF;
                switch (a3) {
                    case 0:
                        join = Paint.Join.MITER;
                        break;
                    case 1:
                        join = Paint.Join.ROUND;
                        break;
                    case 2:
                        join = Paint.Join.BEVEL;
                        break;
                }
                this.xF = join;
                this.xG = android.support.v4.content.a.g.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.xG);
                this.xw = android.support.v4.content.a.g.a(typedArray, xmlPullParser, theme, "strokeColor", 3);
                this.xy = android.support.v4.content.a.g.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.xy);
                this.mStrokeWidth = android.support.v4.content.a.g.a(typedArray, xmlPullParser, "strokeWidth", 4, this.mStrokeWidth);
                this.xC = android.support.v4.content.a.g.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.xC);
                this.xD = android.support.v4.content.a.g.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.xD);
                this.xB = android.support.v4.content.a.g.a(typedArray, xmlPullParser, "trimPathStart", 5, this.xB);
                this.xz = android.support.v4.content.a.g.a(typedArray, xmlPullParser, "fillType", 13, this.xz);
            }
        }

        @Override // android.support.d.a.i.d
        public final boolean isStateful() {
            return this.xx.isStateful() || this.xw.isStateful();
        }

        @Override // android.support.d.a.i.d
        public final boolean e(int[] iArr) {
            return this.xx.e(iArr) | this.xw.e(iArr);
        }

        /* access modifiers changed from: package-private */
        public final int getStrokeColor() {
            return this.xw.mColor;
        }

        /* access modifiers changed from: package-private */
        public final void setStrokeColor(int i2) {
            this.xw.mColor = i2;
        }

        /* access modifiers changed from: package-private */
        public final float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        /* access modifiers changed from: package-private */
        public final void setStrokeWidth(float f2) {
            this.mStrokeWidth = f2;
        }

        /* access modifiers changed from: package-private */
        public final float getStrokeAlpha() {
            return this.xy;
        }

        /* access modifiers changed from: package-private */
        public final void setStrokeAlpha(float f2) {
            this.xy = f2;
        }

        /* access modifiers changed from: package-private */
        public final int getFillColor() {
            return this.xx.mColor;
        }

        /* access modifiers changed from: package-private */
        public final void setFillColor(int i2) {
            this.xx.mColor = i2;
        }

        /* access modifiers changed from: package-private */
        public final float getFillAlpha() {
            return this.xA;
        }

        /* access modifiers changed from: package-private */
        public final void setFillAlpha(float f2) {
            this.xA = f2;
        }

        /* access modifiers changed from: package-private */
        public final float getTrimPathStart() {
            return this.xB;
        }

        /* access modifiers changed from: package-private */
        public final void setTrimPathStart(float f2) {
            this.xB = f2;
        }

        /* access modifiers changed from: package-private */
        public final float getTrimPathEnd() {
            return this.xC;
        }

        /* access modifiers changed from: package-private */
        public final void setTrimPathEnd(float f2) {
            this.xC = f2;
        }

        /* access modifiers changed from: package-private */
        public final float getTrimPathOffset() {
            return this.xD;
        }

        /* access modifiers changed from: package-private */
        public final void setTrimPathOffset(float f2) {
            this.xD = f2;
        }
    }
}
