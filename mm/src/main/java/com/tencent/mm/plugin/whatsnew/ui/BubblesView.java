package com.tencent.mm.plugin.whatsnew.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.whatsnew.ui.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.j.c;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u00010B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0014J(\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0014J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0002J\u0006\u0010-\u001a\u00020\u001bJ\u0014\u0010.\u001a\u00020\u0007*\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0015\u001a\u00020\n*\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0015\u001a\u00020\u0018*\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0019¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/whatsnew/ui/BubblesView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addInterval", "", "bubbles", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/whatsnew/ui/Bubble;", "config", "Lcom/tencent/mm/plugin/whatsnew/ui/Config;", "lastAddTs", "", "lastDrawTs", "paint", "Landroid/graphics/Paint;", "dp", "getDp", "(D)D", "", "(I)F", "addBubble", "", "isStart", "", "drawBubbles", "canvas", "Landroid/graphics/Canvas;", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "parseColor", "str", "", "random", "start", "end", "resume", "withAlpha", "alpha", "Companion", "app_release"})
public final class BubblesView extends View {
    public static final a JOD = new a((byte) 0);
    private long JOA;
    private double JOB;
    private b JOC;
    private final LinkedList<a> JOy;
    long JOz;
    private final Paint paint;

    static {
        AppMethodBeat.i(230944);
        AppMethodBeat.o(230944);
    }

    public BubblesView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    private /* synthetic */ BubblesView(Context context, AttributeSet attributeSet, byte b2) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BubblesView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(230943);
        this.JOy = new LinkedList<>();
        this.paint = new Paint(1);
        this.JOA = SystemClock.uptimeMillis();
        c.a aVar = c.JOX;
        this.JOC = (b) e.a(c.JOW, kotlin.j.c.SYP);
        this.paint.setStyle(Paint.Style.FILL);
        if (ahs(this.JOC.jbm) > 0.0f) {
            this.paint.setMaskFilter(new BlurMaskFilter(ahs(this.JOC.jbm), BlurMaskFilter.Blur.NORMAL));
        }
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TL_BR;
        String[] strArr = this.JOC.JOR;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(Integer.valueOf(parseColor(str)));
        }
        setBackground(new GradientDrawable(orientation, j.u((Collection<Integer>) arrayList)));
        AppMethodBeat.o(230943);
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(230935);
        super.onSizeChanged(i2, i3, i4, i5);
        this.JOz = SystemClock.uptimeMillis();
        int i6 = this.JOC.initCount;
        for (int i7 = 0; i7 < i6; i7++) {
            zF(true);
        }
        AppMethodBeat.o(230935);
    }

    private final void zF(boolean z) {
        double nextDouble;
        double height;
        AppMethodBeat.i(230936);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (z || ((double) (uptimeMillis - this.JOA)) >= this.JOB) {
            this.JOA = uptimeMillis;
            double A = A(ku(this.JOC.JOJ, this.JOC.JOK));
            if (z) {
                c.b bVar = kotlin.j.c.SYP;
                nextDouble = (kotlin.j.c.SYN.nextDouble() * (((double) getWidth()) + (2.0d * A))) - A;
            } else {
                c.b bVar2 = kotlin.j.c.SYP;
                nextDouble = ((kotlin.j.c.SYN.nextDouble() * (((double) (getWidth() * 2)) + (2.0d * A))) - ((double) getWidth())) - A;
            }
            if (z) {
                c.b bVar3 = kotlin.j.c.SYP;
                height = (kotlin.j.c.SYN.nextDouble() * (((double) getHeight()) + (2.0d * A))) + A;
            } else {
                height = ((double) getHeight()) + A;
            }
            double radians = Math.toRadians(ku(this.JOC.JOO, this.JOC.JOP));
            int kv = kv(parseColor((String) e.a(this.JOC.JOQ, kotlin.j.c.SYP)), kotlin.h.a.K(255.0d * this.JOC.JOL));
            double A2 = A(ku(this.JOC.JOM, this.JOC.JON)) / 1000.0d;
            LinkedList<a> linkedList = this.JOy;
            a aVar = new a(nextDouble, height, A, radians, A2, kv);
            new StringBuilder("add ").append(aVar);
            linkedList.add(aVar);
            this.JOB = ((double) this.JOC.vPo) / A2;
            AppMethodBeat.o(230936);
            return;
        }
        AppMethodBeat.o(230936);
    }

    private static int parseColor(String str) {
        int i2;
        AppMethodBeat.i(230937);
        try {
            i2 = Color.parseColor(str);
        } catch (Exception e2) {
            i2 = -65536;
        }
        AppMethodBeat.o(230937);
        return i2;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        boolean z;
        boolean z2;
        int i2;
        AppMethodBeat.i(230938);
        p.h(canvas, "canvas");
        super.onDraw(canvas);
        long uptimeMillis = SystemClock.uptimeMillis();
        int i3 = 0;
        for (T t : this.JOy) {
            this.paint.setColor(t.color);
            double d2 = ((double) (uptimeMillis - this.JOz)) * t.dxQ;
            t.x += Math.cos(t.JOx) * d2;
            t.y -= d2 * Math.sin(t.JOx);
            canvas.drawCircle((float) t.x, (float) t.y, (float) t.radius, this.paint);
            int width = getWidth();
            int height = getHeight();
            if (t.x < (-t.radius) || t.x > ((double) width) + t.radius || t.y < (-t.radius) || t.y > ((double) height) + t.radius) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                i2 = i3 + 1;
            } else {
                i2 = i3;
            }
            i3 = i2;
        }
        this.JOz = uptimeMillis;
        Iterator<a> it = this.JOy.iterator();
        p.g(it, "bubbles.iterator()");
        if (it.hasNext()) {
            a next = it.next();
            p.g(next, "iterator.next()");
            a aVar = next;
            int width2 = getWidth();
            if (aVar.y < (-aVar.radius) || aVar.x > ((double) width2) + aVar.radius) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                new StringBuilder("remove ").append(aVar);
                it.remove();
            }
        }
        if (i3 < this.JOC.JOI) {
            zF(false);
        }
        invalidate();
        AppMethodBeat.o(230938);
    }

    private static double ku(int i2, int i3) {
        AppMethodBeat.i(230939);
        c.b bVar = kotlin.j.c.SYP;
        double nextDouble = ((double) i2) + (kotlin.j.c.SYN.nextDouble() * ((double) (i3 - i2)));
        AppMethodBeat.o(230939);
        return nextDouble;
    }

    private final float ahs(int i2) {
        AppMethodBeat.i(230940);
        Resources resources = getResources();
        p.g(resources, "resources");
        float applyDimension = TypedValue.applyDimension(1, (float) i2, resources.getDisplayMetrics());
        AppMethodBeat.o(230940);
        return applyDimension;
    }

    private final double A(double d2) {
        AppMethodBeat.i(230941);
        Resources resources = getResources();
        p.g(resources, "resources");
        double applyDimension = (double) TypedValue.applyDimension(1, (float) d2, resources.getDisplayMetrics());
        AppMethodBeat.o(230941);
        return applyDimension;
    }

    private static int kv(int i2, int i3) {
        AppMethodBeat.i(230942);
        if (!(i3 >= 0 && 255 >= i3)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
            AppMethodBeat.o(230942);
            throw illegalArgumentException;
        }
        int i4 = (16777215 & i2) | (i3 << 24);
        AppMethodBeat.o(230942);
        return i4;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/whatsnew/ui/BubblesView$Companion;", "", "()V", "TAG", "", "app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
