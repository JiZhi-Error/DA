package com.tencent.mm.plugin.whatsnew.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.b;
import android.support.v4.view.ViewPager;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.mogic.WxViewPager;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0014J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\bH\u0016J \u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\bH\u0016J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\bH\u0016J\u000e\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020)R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/whatsnew/ui/LegacyCircleIndicator;", "Landroid/view/View;", "Landroid/support/v4/view/ViewPager$OnPageChangeListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapterCount", "dotSize", "dotSpacing", "dotsCount", "normalColor", "paint", "Landroid/graphics/Paint;", "scrollPosition", "scrollRatio", "", "value", "selected", "setSelected", "(I)V", "selectedColor", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPageScrollStateChanged", "state", "onPageScrolled", "position", "ratio", "pixels", "onPageSelected", "setupViewPager", "viewPager", "Lcom/tencent/mm/ui/mogic/WxViewPager;", "app_release"})
public final class LegacyCircleIndicator extends View implements ViewPager.OnPageChangeListener {
    private int JOY;
    private int JOZ;
    private final int JPa;
    private final int JPb;
    private int UZ;
    private final int ddP;
    private final Paint paint;
    private final int ruC;
    private int selected;
    private float zRB;

    public LegacyCircleIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    private /* synthetic */ LegacyCircleIndicator(Context context, AttributeSet attributeSet, byte b2) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LegacyCircleIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(230967);
        this.paint = new Paint(1);
        this.ruC = b.n(context, R.color.BW_100_Alpha_0_6);
        this.ddP = b.n(context, R.color.BW_100_Alpha_0_3);
        this.JPa = a.fromDPToPix(context, 6);
        this.JPb = a.fromDPToPix(context, 8);
        AppMethodBeat.o(230967);
    }

    private final void setSelected(int i2) {
        AppMethodBeat.i(230961);
        this.selected = Math.min(this.JOY - 1, i2);
        invalidate();
        AppMethodBeat.o(230961);
    }

    public final void setupViewPager(WxViewPager wxViewPager) {
        AppMethodBeat.i(230962);
        p.h(wxViewPager, "viewPager");
        q adapter = wxViewPager.getAdapter();
        if (adapter == null) {
            IllegalStateException illegalStateException = new IllegalStateException("adapter of viewPager is null".toString());
            AppMethodBeat.o(230962);
            throw illegalStateException;
        }
        this.JOZ = adapter.getCount();
        this.JOY = adapter.getCount() - 1;
        setSelected(Math.max(wxViewPager.getCurrentItem(), 0));
        requestLayout();
        AppMethodBeat.o(230962);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i2, float f2, int i3) {
        this.UZ = i2;
        this.zRB = f2;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i2) {
        AppMethodBeat.i(230963);
        setSelected(i2);
        this.UZ = i2;
        this.zRB = 0.0f;
        AppMethodBeat.o(230963);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i2) {
        AppMethodBeat.i(230964);
        if (i2 == 2) {
            setSelected(this.zRB < 0.5f ? this.UZ : this.UZ + 1);
        }
        AppMethodBeat.o(230964);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(230965);
        int i4 = 0;
        int i5 = this.JPa;
        if (this.JOY > 0) {
            i4 = (this.JPa * this.JOY) + (this.JPb * (this.JOY - 1));
        }
        setMeasuredDimension(i4, i5);
        AppMethodBeat.o(230965);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(230966);
        p.h(canvas, "canvas");
        super.onDraw(canvas);
        Iterator it = j.mY(0, this.JOY).iterator();
        while (it.hasNext()) {
            int nextInt = ((ab) it).nextInt();
            if (nextInt == this.selected) {
                this.paint.setColor(this.ruC);
            } else {
                this.paint.setColor(this.ddP);
            }
            canvas.drawCircle(((float) (nextInt * (this.JPa + this.JPb))) + (((float) this.JPa) / 2.0f), ((float) this.JPa) / 2.0f, ((float) this.JPa) / 2.0f, this.paint);
        }
        AppMethodBeat.o(230966);
    }
}
