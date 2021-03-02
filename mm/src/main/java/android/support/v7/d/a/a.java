package android.support.v7.d.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.d.a.i;
import android.support.v4.content.a.g;
import android.support.v4.e.o;
import android.support.v7.a.a;
import android.support.v7.d.a.b;
import android.support.v7.d.a.e;
import android.util.AttributeSet;
import android.util.StateSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class a extends e {
    private static final String LOGTAG = a.class.getSimpleName();
    private b abU;
    private f abV;
    private int abW;
    private int abX;
    private boolean xp;

    @Override // android.support.v7.d.a.b, android.support.v7.d.a.e
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i2) {
        return super.onLayoutDirectionChanged(i2);
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        super.scheduleDrawable(drawable, runnable, j2);
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ void setAlpha(int i2) {
        super.setAlpha(i2);
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // android.support.v7.d.a.b
    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    public a() {
        this(null, null);
    }

    a(b bVar, Resources resources) {
        super((byte) 0);
        this.abW = -1;
        this.abX = -1;
        a(new b(bVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static a b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (!name.equals("animated-selector")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
        }
        a aVar = new a();
        TypedArray a2 = g.a(resources, theme, attributeSet, a.C0040a.AnimatedStateListDrawableCompat);
        aVar.setVisible(a2.getBoolean(1, true), true);
        b bVar = aVar.abU;
        if (Build.VERSION.SDK_INT >= 21) {
            bVar.mChangingConfigurations |= a2.getChangingConfigurations();
        }
        bVar.acA = a2.getBoolean(2, bVar.acA);
        bVar.acD = a2.getBoolean(3, bVar.acD);
        bVar.acQ = a2.getInt(4, bVar.acQ);
        bVar.acR = a2.getInt(5, bVar.acR);
        aVar.setDither(a2.getBoolean(0, bVar.acP));
        aVar.ach.e(resources);
        a2.recycle();
        aVar.c(context, resources, xmlPullParser, attributeSet, theme);
        aVar.onStateChange(aVar.getState());
        return aVar;
    }

    @Override // android.support.v7.d.a.b
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.abV != null && (visible || z2)) {
            if (z) {
                this.abV.start();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    @Override // android.support.v7.d.a.b, android.support.v7.d.a.e
    public boolean isStateful() {
        return true;
    }

    @Override // android.support.v7.d.a.b
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        if (this.abV != null) {
            this.abV.stop();
            this.abV = null;
            selectDrawable(this.abW);
            this.abW = -1;
            this.abX = -1;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // android.support.v7.d.a.b, android.support.v7.d.a.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onStateChange(int[] r13) {
        /*
        // Method dump skipped, instructions count: 263
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.d.a.a.onStateChange(int[]):boolean");
    }

    /* access modifiers changed from: package-private */
    public static abstract class f {
        public abstract void start();

        public abstract void stop();

        private f() {
        }

        /* synthetic */ f(byte b2) {
            this();
        }

        public void reverse() {
        }

        public boolean hu() {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: android.support.v7.d.a.a$a  reason: collision with other inner class name */
    public static class C0045a extends f {
        private final Animatable abY;

        C0045a(Animatable animatable) {
            super((byte) 0);
            this.abY = animatable;
        }

        @Override // android.support.v7.d.a.a.f
        public final void start() {
            this.abY.start();
        }

        @Override // android.support.v7.d.a.a.f
        public final void stop() {
            this.abY.stop();
        }
    }

    /* access modifiers changed from: package-private */
    public static class d extends f {
        private final ObjectAnimator acc;
        private final boolean acd;

        d(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super((byte) 0);
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i2 = z ? numberOfFrames - 1 : 0;
            int i3 = z ? 0 : numberOfFrames - 1;
            e eVar = new e(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i2, i3);
            if (Build.VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration((long) eVar.acg);
            ofInt.setInterpolator(eVar);
            this.acd = z2;
            this.acc = ofInt;
        }

        @Override // android.support.v7.d.a.a.f
        public final boolean hu() {
            return this.acd;
        }

        @Override // android.support.v7.d.a.a.f
        public final void start() {
            this.acc.start();
        }

        @Override // android.support.v7.d.a.a.f
        public final void reverse() {
            this.acc.reverse();
        }

        @Override // android.support.v7.d.a.a.f
        public final void stop() {
            this.acc.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public static class c extends f {
        private final android.support.d.a.c acb;

        c(android.support.d.a.c cVar) {
            super((byte) 0);
            this.acb = cVar;
        }

        @Override // android.support.v7.d.a.a.f
        public final void start() {
            this.acb.start();
        }

        @Override // android.support.v7.d.a.a.f
        public final void stop() {
            this.acb.stop();
        }
    }

    private void c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        int i2;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next2 == 3) {
                    return;
                }
                if (next2 == 2 && depth2 <= depth) {
                    if (xmlPullParser.getName().equals("item")) {
                        TypedArray a2 = g.a(resources, theme, attributeSet, a.C0040a.AnimatedStateListDrawableItem);
                        int resourceId = a2.getResourceId(0, 0);
                        Drawable drawable = null;
                        int resourceId2 = a2.getResourceId(1, -1);
                        if (resourceId2 > 0) {
                            drawable = android.support.v7.c.a.a.l(context, resourceId2);
                        }
                        a2.recycle();
                        int i3 = 0;
                        int attributeCount = attributeSet.getAttributeCount();
                        int[] iArr = new int[attributeCount];
                        int i4 = 0;
                        while (i4 < attributeCount) {
                            int attributeNameResource = attributeSet.getAttributeNameResource(i4);
                            switch (attributeNameResource) {
                                case 0:
                                    i2 = i3;
                                    break;
                                case 16842960:
                                case 16843161:
                                    i2 = i3;
                                    break;
                                default:
                                    int i5 = i3 + 1;
                                    if (!attributeSet.getAttributeBooleanValue(i4, false)) {
                                        attributeNameResource = -attributeNameResource;
                                    }
                                    iArr[i3] = attributeNameResource;
                                    i2 = i5;
                                    break;
                            }
                            i4++;
                            i3 = i2;
                        }
                        int[] trimStateSet = StateSet.trimStateSet(iArr, i3);
                        if (drawable == null) {
                            do {
                                next = xmlPullParser.next();
                            } while (next == 4);
                            if (next != 2) {
                                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                            } else if (xmlPullParser.getName().equals("vector")) {
                                drawable = i.a(resources, xmlPullParser, attributeSet, theme);
                            } else if (Build.VERSION.SDK_INT >= 21) {
                                drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                            } else {
                                drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                            }
                        }
                        if (drawable == null) {
                            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                        }
                        b bVar = this.abU;
                        int addChild = bVar.addChild(drawable);
                        bVar.adf[addChild] = trimStateSet;
                        bVar.aca.put(addChild, Integer.valueOf(resourceId));
                    } else if (xmlPullParser.getName().equals("transition")) {
                        d(context, resources, xmlPullParser, attributeSet, theme);
                    }
                }
            } else {
                return;
            }
        }
    }

    private int d(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray a2 = g.a(resources, theme, attributeSet, a.C0040a.AnimatedStateListDrawableTransition);
        int resourceId = a2.getResourceId(2, -1);
        int resourceId2 = a2.getResourceId(1, -1);
        Drawable drawable = null;
        int resourceId3 = a2.getResourceId(0, -1);
        if (resourceId3 > 0) {
            drawable = android.support.v7.c.a.a.l(context, resourceId3);
        }
        boolean z = a2.getBoolean(3, false);
        a2.recycle();
        if (drawable == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (xmlPullParser.getName().equals("animated-vector")) {
                drawable = android.support.d.a.c.a(context, resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (drawable == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.abU.a(resourceId, resourceId2, drawable, z);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
    }

    @Override // android.support.v7.d.a.b, android.support.v7.d.a.e
    public Drawable mutate() {
        if (!this.xp && super.mutate() == this) {
            this.abU.ht();
            this.xp = true;
        }
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: hq */
    public b hs() {
        return new b(this.abU, this, null);
    }

    /* access modifiers changed from: package-private */
    public static class b extends e.a {
        android.support.v4.e.g<Long> abZ;
        o<Integer> aca;

        b(b bVar, a aVar, Resources resources) {
            super(bVar, aVar, resources);
            if (bVar != null) {
                this.abZ = bVar.abZ;
                this.aca = bVar.aca;
                return;
            }
            this.abZ = new android.support.v4.e.g<>();
            this.aca = new o<>();
        }

        /* access modifiers changed from: package-private */
        @Override // android.support.v7.d.a.e.a, android.support.v7.d.a.b.AbstractC0046b
        public final void ht() {
            this.abZ = this.abZ.clone();
            this.aca = this.aca.clone();
        }

        /* access modifiers changed from: package-private */
        public final int a(int i2, int i3, Drawable drawable, boolean z) {
            int addChild = super.addChild(drawable);
            long K = K(i2, i3);
            long j2 = 0;
            if (z) {
                j2 = 8589934592L;
            }
            this.abZ.append(K, Long.valueOf(((long) addChild) | j2));
            if (z) {
                this.abZ.append(K(i3, i2), Long.valueOf(j2 | ((long) addChild) | 4294967296L));
            }
            return addChild;
        }

        /* access modifiers changed from: package-private */
        public final int g(int[] iArr) {
            int h2 = super.h(iArr);
            return h2 >= 0 ? h2 : super.h(StateSet.WILD_CARD);
        }

        /* access modifiers changed from: package-private */
        public final int bt(int i2) {
            if (i2 < 0) {
                return 0;
            }
            return this.aca.get(i2, 0).intValue();
        }

        @Override // android.support.v7.d.a.e.a
        public final Drawable newDrawable() {
            return new a(this, null);
        }

        @Override // android.support.v7.d.a.e.a
        public final Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }

        static long K(int i2, int i3) {
            return (((long) i2) << 32) | ((long) i3);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.d.a.b, android.support.v7.d.a.e
    public final void a(b.AbstractC0046b bVar) {
        super.a(bVar);
        if (bVar instanceof b) {
            this.abU = (b) bVar;
        }
    }

    static class e implements TimeInterpolator {
        private int[] ace;
        private int acf;
        int acg;

        e(AnimationDrawable animationDrawable, boolean z) {
            a(animationDrawable, z);
        }

        private int a(AnimationDrawable animationDrawable, boolean z) {
            int i2;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.acf = numberOfFrames;
            if (this.ace == null || this.ace.length < numberOfFrames) {
                this.ace = new int[numberOfFrames];
            }
            int[] iArr = this.ace;
            int i3 = 0;
            int i4 = 0;
            while (i3 < numberOfFrames) {
                if (z) {
                    i2 = (numberOfFrames - i3) - 1;
                } else {
                    i2 = i3;
                }
                int duration = animationDrawable.getDuration(i2);
                iArr[i3] = duration;
                i3++;
                i4 = duration + i4;
            }
            this.acg = i4;
            return i4;
        }

        public final float getInterpolation(float f2) {
            float f3;
            int i2 = (int) ((((float) this.acg) * f2) + 0.5f);
            int i3 = this.acf;
            int[] iArr = this.ace;
            int i4 = 0;
            while (i4 < i3 && i2 >= iArr[i4]) {
                i2 -= iArr[i4];
                i4++;
            }
            if (i4 < i3) {
                f3 = ((float) i2) / ((float) this.acg);
            } else {
                f3 = 0.0f;
            }
            return f3 + (((float) i4) / ((float) i3));
        }
    }
}
