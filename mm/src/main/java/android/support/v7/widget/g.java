package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.d.a.i;
import android.support.v4.e.h;
import android.support.v4.e.o;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.tencent.mm.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class g {
    private static final PorterDuff.Mode akq = PorterDuff.Mode.SRC_IN;
    private static g akr;
    private static final c aks = new c();
    private static final int[] akt = {R.drawable.b8e, R.drawable.b8c, R.drawable.b76};
    private static final int[] aku = {R.drawable.b7d, R.drawable.ao, R.drawable.b7i, R.drawable.b7e, R.drawable.b7f, R.drawable.b7h, R.drawable.b7g};
    private static final int[] akv = {R.drawable.b8b, R.drawable.b8d, R.drawable.b7c, R.drawable.au, R.drawable.b86, R.drawable.b88, R.drawable.b8_, R.drawable.b87, R.drawable.b89, R.drawable.b8a};
    private static final int[] akw = {R.drawable.b7x, R.drawable.a3, R.drawable.b7w};
    private static final int[] akx = {R.drawable.at, R.drawable.av};
    private static final int[] aky = {R.drawable.z, R.drawable.a2};
    private android.support.v4.e.a<String, d> akA;
    private o<String> akB;
    private final WeakHashMap<Context, android.support.v4.e.g<WeakReference<Drawable.ConstantState>>> akC = new WeakHashMap<>(0);
    private TypedValue akD;
    private boolean akE;
    private WeakHashMap<Context, o<ColorStateList>> akz;

    /* access modifiers changed from: package-private */
    public interface d {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public static synchronized g jk() {
        g gVar;
        synchronized (g.class) {
            if (akr == null) {
                g gVar2 = new g();
                akr = gVar2;
                if (Build.VERSION.SDK_INT < 24) {
                    gVar2.a("vector", new e());
                    gVar2.a("animated-vector", new b());
                    gVar2.a("animated-selector", new a());
                }
            }
            gVar = akr;
        }
        return gVar;
    }

    public final synchronized Drawable l(Context context, int i2) {
        return b(context, i2, false);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        if (r0 == false) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized android.graphics.drawable.Drawable b(android.content.Context r8, int r9, boolean r10) {
        /*
        // Method dump skipped, instructions count: 157
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.g.b(android.content.Context, int, boolean):android.graphics.drawable.Drawable");
    }

    public final synchronized void ac(Context context) {
        android.support.v4.e.g<WeakReference<Drawable.ConstantState>> gVar = this.akC.get(context);
        if (gVar != null) {
            gVar.clear();
        }
    }

    private static long a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable a(Context context, int i2, boolean z, Drawable drawable) {
        ColorStateList s = s(context, i2);
        if (s != null) {
            if (x.t(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable i3 = android.support.v4.graphics.drawable.a.i(drawable);
            android.support.v4.graphics.drawable.a.a(i3, s);
            PorterDuff.Mode bJ = bJ(i2);
            if (bJ == null) {
                return i3;
            }
            android.support.v4.graphics.drawable.a.a(i3, bJ);
            return i3;
        } else if (i2 == R.drawable.ap) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(16908288), av.v(context, R.attr.fy), akq);
            a(layerDrawable.findDrawableByLayerId(16908303), av.v(context, R.attr.fy), akq);
            a(layerDrawable.findDrawableByLayerId(16908301), av.v(context, R.attr.fw), akq);
            return drawable;
        } else if (i2 == R.drawable.al || i2 == R.drawable.ak || i2 == R.drawable.am) {
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            a(layerDrawable2.findDrawableByLayerId(16908288), av.x(context, R.attr.fy), akq);
            a(layerDrawable2.findDrawableByLayerId(16908303), av.v(context, R.attr.fw), akq);
            a(layerDrawable2.findDrawableByLayerId(16908301), av.v(context, R.attr.fw), akq);
            return drawable;
        } else if (a(context, i2, drawable) || !z) {
            return drawable;
        } else {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable r(android.content.Context r10, int r11) {
        /*
        // Method dump skipped, instructions count: 188
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.g.r(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    private synchronized Drawable a(Context context, long j2) {
        Drawable drawable;
        android.support.v4.e.g<WeakReference<Drawable.ConstantState>> gVar = this.akC.get(context);
        if (gVar == null) {
            drawable = null;
        } else {
            WeakReference<Drawable.ConstantState> weakReference = gVar.get(j2, null);
            if (weakReference != null) {
                Drawable.ConstantState constantState = weakReference.get();
                if (constantState != null) {
                    drawable = constantState.newDrawable(context.getResources());
                } else {
                    int a2 = android.support.v4.e.d.a(gVar.OV, gVar.mSize, j2);
                    if (a2 >= 0 && gVar.OW[a2] != android.support.v4.e.g.OT) {
                        gVar.OW[a2] = android.support.v4.e.g.OT;
                        gVar.OU = true;
                    }
                }
            }
            drawable = null;
        }
        return drawable;
    }

    private synchronized boolean a(Context context, long j2, Drawable drawable) {
        boolean z;
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            android.support.v4.e.g<WeakReference<Drawable.ConstantState>> gVar = this.akC.get(context);
            if (gVar == null) {
                gVar = new android.support.v4.e.g<>();
                this.akC.put(context, gVar);
            }
            gVar.put(j2, new WeakReference<>(constantState));
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final synchronized Drawable a(Context context, be beVar, int i2) {
        Drawable drawable;
        Drawable r = r(context, i2);
        if (r == null) {
            r = beVar.cY(i2);
        }
        if (r != null) {
            drawable = a(context, i2, false, r);
        } else {
            drawable = null;
        }
        return drawable;
    }

    static boolean a(Context context, int i2, Drawable drawable) {
        int i3;
        boolean z;
        int i4 = 16842801;
        PorterDuff.Mode mode = akq;
        if (c(akt, i2)) {
            i4 = R.attr.fy;
            i3 = -1;
            z = true;
        } else if (c(akv, i2)) {
            i4 = R.attr.fw;
            i3 = -1;
            z = true;
        } else if (c(akw, i2)) {
            mode = PorterDuff.Mode.MULTIPLY;
            i3 = -1;
            z = true;
        } else if (i2 == R.drawable.b7p) {
            i4 = 16842800;
            i3 = Math.round(40.8f);
            z = true;
        } else if (i2 == R.drawable.a5) {
            i3 = -1;
            z = true;
        } else {
            i3 = -1;
            i4 = 0;
            z = false;
        }
        if (!z) {
            return false;
        }
        if (x.t(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(b(av.v(context, i4), mode));
        if (i3 == -1) {
            return true;
        }
        drawable.setAlpha(i3);
        return true;
    }

    private void a(String str, d dVar) {
        if (this.akA == null) {
            this.akA = new android.support.v4.e.a<>();
        }
        this.akA.put(str, dVar);
    }

    private static boolean c(int[] iArr, int i2) {
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    private static PorterDuff.Mode bJ(int i2) {
        if (i2 == R.drawable.as) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final synchronized ColorStateList s(Context context, int i2) {
        ColorStateList colorStateList;
        ColorStateList m;
        if (this.akz != null) {
            o<ColorStateList> oVar = this.akz.get(context);
            colorStateList = oVar != null ? oVar.get(i2, null) : null;
        } else {
            colorStateList = null;
        }
        if (colorStateList == null) {
            if (i2 == R.drawable.a6) {
                m = android.support.v7.c.a.a.m(context, R.color.bb);
            } else if (i2 == R.drawable.b84) {
                m = android.support.v7.c.a.a.m(context, R.color.be);
            } else if (i2 == R.drawable.as) {
                int[][] iArr = new int[3][];
                int[] iArr2 = new int[3];
                ColorStateList w = av.w(context, R.attr.gb);
                if (w == null || !w.isStateful()) {
                    iArr[0] = av.kh;
                    iArr2[0] = av.x(context, R.attr.gb);
                    iArr[1] = av.jV;
                    iArr2[1] = av.v(context, R.attr.fw);
                    iArr[2] = av.EMPTY_STATE_SET;
                    iArr2[2] = av.v(context, R.attr.gb);
                } else {
                    iArr[0] = av.kh;
                    iArr2[0] = w.getColorForState(iArr[0], 0);
                    iArr[1] = av.jV;
                    iArr2[1] = av.v(context, R.attr.fw);
                    iArr[2] = av.EMPTY_STATE_SET;
                    iArr2[2] = w.getDefaultColor();
                }
                m = new ColorStateList(iArr, iArr2);
            } else if (i2 == R.drawable.a1) {
                m = t(context, av.v(context, R.attr.fv));
            } else if (i2 == R.drawable.y) {
                m = t(context, 0);
            } else if (i2 == R.drawable.a0) {
                m = t(context, av.v(context, R.attr.ft));
            } else if (i2 == R.drawable.b83 || i2 == R.drawable.ar) {
                m = android.support.v7.c.a.a.m(context, R.color.bd);
            } else if (c(aku, i2)) {
                m = av.w(context, R.attr.fy);
            } else if (c(akx, i2)) {
                m = android.support.v7.c.a.a.m(context, R.color.ba);
            } else if (c(aky, i2)) {
                m = android.support.v7.c.a.a.m(context, R.color.b_);
            } else {
                m = i2 == R.drawable.an ? android.support.v7.c.a.a.m(context, R.color.bc) : colorStateList;
            }
            if (m != null) {
                if (this.akz == null) {
                    this.akz = new WeakHashMap<>();
                }
                o<ColorStateList> oVar2 = this.akz.get(context);
                if (oVar2 == null) {
                    oVar2 = new o<>();
                    this.akz.put(context, oVar2);
                }
                oVar2.append(i2, m);
            }
            colorStateList = m;
        }
        return colorStateList;
    }

    private static ColorStateList t(Context context, int i2) {
        int v = av.v(context, R.attr.fx);
        int x = av.x(context, R.attr.fv);
        return new ColorStateList(new int[][]{av.kh, av.PRESSED_STATE_SET, av.FOCUSED_STATE_SET, av.EMPTY_STATE_SET}, new int[]{x, android.support.v4.graphics.b.v(v, i2), android.support.v4.graphics.b.v(v, i2), i2});
    }

    /* access modifiers changed from: package-private */
    public static class c extends h<Integer, PorterDuffColorFilter> {
        public c() {
            super(6);
        }

        static int c(int i2, PorterDuff.Mode mode) {
            return ((i2 + 31) * 31) + mode.hashCode();
        }
    }

    static void a(Drawable drawable, ax axVar, int[] iArr) {
        ColorStateList colorStateList;
        PorterDuff.Mode mode;
        PorterDuffColorFilter porterDuffColorFilter = null;
        if (!x.t(drawable) || drawable.mutate() == drawable) {
            if (axVar.acT || axVar.acU) {
                if (axVar.acT) {
                    colorStateList = axVar.Kr;
                } else {
                    colorStateList = null;
                }
                if (axVar.acU) {
                    mode = axVar.yl;
                } else {
                    mode = akq;
                }
                if (!(colorStateList == null || mode == null)) {
                    porterDuffColorFilter = b(colorStateList.getColorForState(iArr, 0), mode);
                }
                drawable.setColorFilter(porterDuffColorFilter);
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
        }
    }

    public static synchronized PorterDuffColorFilter b(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (g.class) {
            porterDuffColorFilter = (PorterDuffColorFilter) aks.get(Integer.valueOf(c.c(i2, mode)));
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(i2, mode);
                aks.put(Integer.valueOf(c.c(i2, mode)), porterDuffColorFilter);
            }
        }
        return porterDuffColorFilter;
    }

    private static void a(Drawable drawable, int i2, PorterDuff.Mode mode) {
        if (x.t(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = akq;
        }
        drawable.setColorFilter(b(i2, mode));
    }

    /* access modifiers changed from: package-private */
    public static class e implements d {
        e() {
        }

        @Override // android.support.v7.widget.g.d
        public final Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return i.a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class b implements d {
        b() {
        }

        @Override // android.support.v7.widget.g.d
        public final Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return android.support.d.a.c.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class a implements d {
        a() {
        }

        @Override // android.support.v7.widget.g.d
        public final Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return android.support.v7.d.a.a.b(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                return null;
            }
        }
    }
}
