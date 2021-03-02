package android.support.d.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.a.g;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public final class c extends h implements b {
    ArrayList<Object> fy;
    private Context mContext;
    private a wW;
    private ArgbEvaluator wX;
    private Animator.AnimatorListener wY;
    final Drawable.Callback wZ;

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

    c() {
        this(null, (byte) 0);
    }

    private c(Context context) {
        this(context, (byte) 0);
    }

    private c(Context context, byte b2) {
        this.wX = null;
        this.wY = null;
        this.fy = null;
        this.wZ = new Drawable.Callback() {
            /* class android.support.d.a.c.AnonymousClass1 */

            public final void invalidateDrawable(Drawable drawable) {
                c.this.invalidateSelf();
            }

            public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
                c.this.scheduleSelf(runnable, j2);
            }

            public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                c.this.unscheduleSelf(runnable);
            }
        };
        this.mContext = context;
        this.wW = new a();
    }

    public final Drawable mutate() {
        if (this.xk != null) {
            this.xk.mutate();
        }
        return this;
    }

    public static c a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        c cVar = new c(context);
        cVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cVar;
    }

    public final Drawable.ConstantState getConstantState() {
        if (this.xk == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new b(this.xk.getConstantState());
    }

    public final int getChangingConfigurations() {
        if (this.xk != null) {
            return this.xk.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.wW.mChangingConfigurations;
    }

    public final void draw(Canvas canvas) {
        if (this.xk != null) {
            this.xk.draw(canvas);
            return;
        }
        this.wW.xb.draw(canvas);
        if (this.wW.xc.isStarted()) {
            invalidateSelf();
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.d.a.h
    public final void onBoundsChange(Rect rect) {
        if (this.xk != null) {
            this.xk.setBounds(rect);
        } else {
            this.wW.xb.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean onStateChange(int[] iArr) {
        if (this.xk != null) {
            return this.xk.setState(iArr);
        }
        return this.wW.xb.setState(iArr);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.d.a.h
    public final boolean onLevelChange(int i2) {
        if (this.xk != null) {
            return this.xk.setLevel(i2);
        }
        return this.wW.xb.setLevel(i2);
    }

    public final int getAlpha() {
        if (this.xk != null) {
            return android.support.v4.graphics.drawable.a.f(this.xk);
        }
        return this.wW.xb.getAlpha();
    }

    public final void setAlpha(int i2) {
        if (this.xk != null) {
            this.xk.setAlpha(i2);
        } else {
            this.wW.xb.setAlpha(i2);
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.xk != null) {
            this.xk.setColorFilter(colorFilter);
        } else {
            this.wW.xb.setColorFilter(colorFilter);
        }
    }

    @Override // android.support.v4.graphics.drawable.e
    public final void setTint(int i2) {
        if (this.xk != null) {
            android.support.v4.graphics.drawable.a.a(this.xk, i2);
        } else {
            this.wW.xb.setTint(i2);
        }
    }

    @Override // android.support.v4.graphics.drawable.e
    public final void setTintList(ColorStateList colorStateList) {
        if (this.xk != null) {
            android.support.v4.graphics.drawable.a.a(this.xk, colorStateList);
        } else {
            this.wW.xb.setTintList(colorStateList);
        }
    }

    @Override // android.support.v4.graphics.drawable.e
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.xk != null) {
            android.support.v4.graphics.drawable.a.a(this.xk, mode);
        } else {
            this.wW.xb.setTintMode(mode);
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        if (this.xk != null) {
            return this.xk.setVisible(z, z2);
        }
        this.wW.xb.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public final boolean isStateful() {
        if (this.xk != null) {
            return this.xk.isStateful();
        }
        return this.wW.xb.isStateful();
    }

    public final int getOpacity() {
        if (this.xk != null) {
            return this.xk.getOpacity();
        }
        return this.wW.xb.getOpacity();
    }

    public final int getIntrinsicWidth() {
        if (this.xk != null) {
            return this.xk.getIntrinsicWidth();
        }
        return this.wW.xb.getIntrinsicWidth();
    }

    public final int getIntrinsicHeight() {
        if (this.xk != null) {
            return this.xk.getIntrinsicHeight();
        }
        return this.wW.xb.getIntrinsicHeight();
    }

    public final boolean isAutoMirrored() {
        if (this.xk != null) {
            return android.support.v4.graphics.drawable.a.e(this.xk);
        }
        return this.wW.xb.isAutoMirrored();
    }

    public final void setAutoMirrored(boolean z) {
        if (this.xk != null) {
            android.support.v4.graphics.drawable.a.a(this.xk, z);
        } else {
            this.wW.xb.setAutoMirrored(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Animator a2;
        if (this.xk != null) {
            android.support.v4.graphics.drawable.a.a(this.xk, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray a3 = g.a(resources, theme, attributeSet, a.wO);
                    int resourceId = a3.getResourceId(0, 0);
                    if (resourceId != 0) {
                        i a4 = i.a(resources, resourceId, theme);
                        a4.xq = false;
                        a4.setCallback(this.wZ);
                        if (this.wW.xb != null) {
                            this.wW.xb.setCallback(null);
                        }
                        this.wW.xb = a4;
                    }
                    a3.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, a.wP);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.mContext != null) {
                            Context context = this.mContext;
                            if (Build.VERSION.SDK_INT >= 24) {
                                a2 = AnimatorInflater.loadAnimator(context, resourceId2);
                            } else {
                                a2 = e.a(context, context.getResources(), context.getTheme(), resourceId2);
                            }
                            a2.setTarget(this.wW.xb.xm.yj.yi.get(string));
                            if (Build.VERSION.SDK_INT < 21) {
                                b(a2);
                            }
                            if (this.wW.xd == null) {
                                this.wW.xd = new ArrayList<>();
                                this.wW.xe = new android.support.v4.e.a<>();
                            }
                            this.wW.xd.add(a2);
                            this.wW.xe.put(a2, string);
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        a aVar = this.wW;
        if (aVar.xc == null) {
            aVar.xc = new AnimatorSet();
        }
        aVar.xc.playTogether(aVar.xd);
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // android.support.d.a.h
    public final void applyTheme(Resources.Theme theme) {
        if (this.xk != null) {
            android.support.v4.graphics.drawable.a.a(this.xk, theme);
        }
    }

    public final boolean canApplyTheme() {
        if (this.xk != null) {
            return android.support.v4.graphics.drawable.a.g(this.xk);
        }
        return false;
    }

    static class b extends Drawable.ConstantState {
        private final Drawable.ConstantState xf;

        public b(Drawable.ConstantState constantState) {
            this.xf = constantState;
        }

        public final Drawable newDrawable() {
            c cVar = new c();
            cVar.xk = this.xf.newDrawable();
            cVar.xk.setCallback(cVar.wZ);
            return cVar;
        }

        public final Drawable newDrawable(Resources resources) {
            c cVar = new c();
            cVar.xk = this.xf.newDrawable(resources);
            cVar.xk.setCallback(cVar.wZ);
            return cVar;
        }

        public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
            c cVar = new c();
            cVar.xk = this.xf.newDrawable(resources, theme);
            cVar.xk.setCallback(cVar.wZ);
            return cVar;
        }

        public final boolean canApplyTheme() {
            return this.xf.canApplyTheme();
        }

        public final int getChangingConfigurations() {
            return this.xf.getChangingConfigurations();
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends Drawable.ConstantState {
        int mChangingConfigurations;
        i xb;
        AnimatorSet xc;
        ArrayList<Animator> xd;
        android.support.v4.e.a<Animator, String> xe;

        public final Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public final Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public final int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }
    }

    private void b(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i2 = 0; i2 < childAnimations.size(); i2++) {
                b(childAnimations.get(i2));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.wX == null) {
                    this.wX = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.wX);
            }
        }
    }

    public final boolean isRunning() {
        if (this.xk != null) {
            return ((AnimatedVectorDrawable) this.xk).isRunning();
        }
        return this.wW.xc.isRunning();
    }

    public final void start() {
        if (this.xk != null) {
            ((AnimatedVectorDrawable) this.xk).start();
        } else if (!this.wW.xc.isStarted()) {
            this.wW.xc.start();
            invalidateSelf();
        }
    }

    public final void stop() {
        if (this.xk != null) {
            ((AnimatedVectorDrawable) this.xk).stop();
        } else {
            this.wW.xc.end();
        }
    }
}
