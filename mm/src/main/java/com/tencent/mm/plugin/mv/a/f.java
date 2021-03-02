package com.tencent.mm.plugin.mv.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Size;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u001f\u001a\u00020\u001dJ\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J \u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00122\b\b\u0002\u0010(\u001a\u00020\u001dJ \u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00122\b\b\u0002\u0010(\u001a\u00020\u001dR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "", "drawable", "Landroid/graphics/drawable/Drawable;", "position", "Landroid/graphics/Point;", "size", "Landroid/util/Size;", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/Point;Landroid/util/Size;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "getPosition", "()Landroid/graphics/Point;", "getSize", "()Landroid/util/Size;", "attachTo", "", "imageView", "Landroid/widget/ImageView;", "component1", "component2", "component3", "copy", "cv", "", "from", "to", "progress", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hasDrawable", "hashCode", "", "toString", "", "transitionTo", "Landroid/animation/Animator;", "Landroid/view/View;", "animateView", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "plugin-mv_release"})
public final class f {
    public final Point ApS;
    public final Size ApT;
    private final Drawable drawable;

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        if (kotlin.g.b.p.j(r3.ApT, r4.ApT) != false) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 256794(0x3eb1a, float:3.59845E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x002c
            boolean r0 = r4 instanceof com.tencent.mm.plugin.mv.a.f
            if (r0 == 0) goto L_0x0031
            com.tencent.mm.plugin.mv.a.f r4 = (com.tencent.mm.plugin.mv.a.f) r4
            android.graphics.drawable.Drawable r0 = r3.drawable
            android.graphics.drawable.Drawable r1 = r4.drawable
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0031
            android.graphics.Point r0 = r3.ApS
            android.graphics.Point r1 = r4.ApS
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0031
            android.util.Size r0 = r3.ApT
            android.util.Size r1 = r4.ApT
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0031
        L_0x002c:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0030:
            return r0
        L_0x0031:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.a.f.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(256793);
        Drawable drawable2 = this.drawable;
        int hashCode = (drawable2 != null ? drawable2.hashCode() : 0) * 31;
        Point point = this.ApS;
        int hashCode2 = ((point != null ? point.hashCode() : 0) + hashCode) * 31;
        Size size = this.ApT;
        if (size != null) {
            i2 = size.hashCode();
        }
        int i3 = hashCode2 + i2;
        AppMethodBeat.o(256793);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(256792);
        String str = "MusicMvAnimationInfo(drawable=" + this.drawable + ", position=" + this.ApS + ", size=" + this.ApT + ")";
        AppMethodBeat.o(256792);
        return str;
    }

    public f(Drawable drawable2, Point point, Size size) {
        p.h(point, "position");
        p.h(size, "size");
        AppMethodBeat.i(256791);
        this.drawable = drawable2;
        this.ApS = point;
        this.ApT = size;
        AppMethodBeat.o(256791);
    }

    public final void i(ImageView imageView) {
        AppMethodBeat.i(256789);
        p.h(imageView, "imageView");
        imageView.setAlpha(1.0f);
        imageView.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = this.ApT.getWidth();
        layoutParams.height = this.ApT.getHeight();
        imageView.setLayoutParams(layoutParams);
        imageView.setX((float) this.ApS.x);
        imageView.setY((float) this.ApS.y);
        imageView.setImageDrawable(this.drawable);
        AppMethodBeat.o(256789);
    }

    public final Animator a(f fVar, ImageView imageView, boolean z) {
        AppMethodBeat.i(256790);
        p.h(fVar, "to");
        p.h(imageView, "animateView");
        i(imageView);
        float f2 = (float) this.ApS.x;
        float f3 = (float) fVar.ApS.x;
        float f4 = (float) this.ApS.y;
        float f5 = (float) fVar.ApS.y;
        float width = (float) this.ApT.getWidth();
        float width2 = (float) fVar.ApT.getWidth();
        float height = (float) this.ApT.getHeight();
        float height2 = (float) fVar.ApT.getHeight();
        ValueAnimator ofFloat = ObjectAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new a(this, f2, f3, f4, f5, width, width2, height, height2, imageView, z));
        p.g(ofFloat, "anim");
        ValueAnimator valueAnimator = ofFloat;
        AppMethodBeat.o(256790);
        return valueAnimator;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ f ApU;
        final /* synthetic */ float ApV;
        final /* synthetic */ float ApW;
        final /* synthetic */ float ApX;
        final /* synthetic */ float ApY;
        final /* synthetic */ float ApZ;
        final /* synthetic */ float Aqa;
        final /* synthetic */ float Aqb;
        final /* synthetic */ float Aqc;
        final /* synthetic */ ImageView Aqd;
        final /* synthetic */ boolean Aqe;

        a(f fVar, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, ImageView imageView, boolean z) {
            this.ApU = fVar;
            this.ApV = f2;
            this.ApW = f3;
            this.ApX = f4;
            this.ApY = f5;
            this.ApZ = f6;
            this.Aqa = f7;
            this.Aqb = f8;
            this.Aqc = f9;
            this.Aqd = imageView;
            this.Aqe = z;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(256788);
            p.g(valueAnimator, "animator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(256788);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            float n = f.n(this.ApV, this.ApW, floatValue);
            float n2 = f.n(this.ApX, this.ApY, floatValue);
            float n3 = f.n(this.ApZ, this.Aqa, floatValue);
            float n4 = f.n(this.Aqb, this.Aqc, floatValue);
            float f2 = 1.0f - floatValue;
            this.Aqd.setX(n);
            this.Aqd.setY(n2);
            ImageView imageView = this.Aqd;
            ViewGroup.LayoutParams layoutParams = this.Aqd.getLayoutParams();
            layoutParams.width = (int) n3;
            layoutParams.height = (int) n4;
            imageView.setLayoutParams(layoutParams);
            if (this.Aqe) {
                this.Aqd.setAlpha(f2);
            }
            AppMethodBeat.o(256788);
        }
    }

    public static final /* synthetic */ float n(float f2, float f3, float f4) {
        return ((f3 - f2) * f4) + f2;
    }
}
