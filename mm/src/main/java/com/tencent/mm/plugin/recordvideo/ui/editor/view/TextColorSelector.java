package com.tencent.mm.plugin.recordvideo.ui.editor.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.k.f;
import kotlin.k.j;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u001aH\u0002J\u0006\u00101\u001a\u00020\tJ\u0010\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u000204H\u0014J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016J\u000e\u00109\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010:\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R7\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001a\u0010)\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\u000e\u0010,\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/TextColorSelector;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "colorArray", "", "colorSelectedCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.b.INDEX, "", "getColorSelectedCallback", "()Lkotlin/jvm/functions/Function1;", "setColorSelectedCallback", "(Lkotlin/jvm/functions/Function1;)V", "dotInterval", "", "outerColor", "paint", "Landroid/graphics/Paint;", "radiusNormalInner", "getRadiusNormalInner", "()F", "setRadiusNormalInner", "(F)V", "radiusNormalOuter", "getRadiusNormalOuter", "setRadiusNormalOuter", "radiusSelectInner", "getRadiusSelectInner", "setRadiusSelectInner", "radiusSelectOuter", "getRadiusSelectOuter", "setRadiusSelectOuter", "selectedIndex", "touchDownIndex", "getNearestIndex", "x", "y", "getSelected", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setColorList", "setSelected", "select", "plugin-recordvideo_release"})
public final class TextColorSelector extends View {
    private final int ChM;
    private float ChN;
    private int[] ChO;
    private int ChP;
    private float ChQ;
    private float ChR;
    private float ChS;
    private float ChT;
    private b<? super Integer, x> ChU;
    private final String TAG;
    private int bxP;
    private Paint paint;

    public TextColorSelector(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(237971);
        this.TAG = "TextColorSelector";
        this.ChM = -1;
        this.paint = new Paint(1);
        this.ChO = new int[0];
        this.ChP = -1;
        this.bxP = -1;
        this.ChQ = getResources().getDimension(R.dimen.a11);
        this.ChR = getResources().getDimension(R.dimen.a12);
        this.ChS = getResources().getDimension(R.dimen.a13);
        this.ChT = getResources().getDimension(R.dimen.a14);
        this.paint.setStyle(Paint.Style.FILL);
        AppMethodBeat.o(237971);
    }

    public TextColorSelector(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final float getRadiusNormalInner() {
        return this.ChQ;
    }

    public final void setRadiusNormalInner(float f2) {
        this.ChQ = f2;
    }

    public final float getRadiusNormalOuter() {
        return this.ChR;
    }

    public final void setRadiusNormalOuter(float f2) {
        this.ChR = f2;
    }

    public final float getRadiusSelectInner() {
        return this.ChS;
    }

    public final void setRadiusSelectInner(float f2) {
        this.ChS = f2;
    }

    public final float getRadiusSelectOuter() {
        return this.ChT;
    }

    public final void setRadiusSelectOuter(float f2) {
        this.ChT = f2;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.Integer, kotlin.x>, kotlin.g.a.b<java.lang.Integer, kotlin.x> */
    public final b<Integer, x> getColorSelectedCallback() {
        return this.ChU;
    }

    public final void setColorSelectedCallback(b<? super Integer, x> bVar) {
        this.ChU = bVar;
    }

    public final void setColorList(int[] iArr) {
        AppMethodBeat.i(237967);
        p.h(iArr, "colorArray");
        this.ChO = iArr;
        AppMethodBeat.o(237967);
    }

    public final void setSelected(int i2) {
        this.bxP = i2;
    }

    public final int getSelected() {
        return this.bxP;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(237968);
        p.h(canvas, "canvas");
        super.onDraw(canvas);
        this.ChN = (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) - (this.ChR * 2.0f)) / ((float) (this.ChO.length - 1));
        float height = ((float) getHeight()) / 2.0f;
        int length = this.ChO.length;
        for (int i2 = 0; i2 < length; i2++) {
            float paddingLeft = (this.ChN * ((float) i2)) + this.ChR + ((float) getPaddingLeft());
            this.paint.setColor(this.ChM);
            if (i2 == this.bxP) {
                canvas.drawCircle(paddingLeft, height, this.ChT, this.paint);
            } else {
                canvas.drawCircle(paddingLeft, height, this.ChR, this.paint);
            }
            this.paint.setColor(this.ChO[i2]);
            if (i2 == this.bxP) {
                canvas.drawCircle(paddingLeft, height, this.ChS, this.paint);
            } else {
                canvas.drawCircle(paddingLeft, height, this.ChQ, this.paint);
            }
        }
        AppMethodBeat.o(237968);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(237969);
        p.h(motionEvent, "event");
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.ChP = ah(motionEvent.getX(), motionEvent.getY());
                break;
            case 1:
                int ah = ah(motionEvent.getX(), motionEvent.getY());
                if (ah >= 0 && ah == this.ChP) {
                    this.bxP = ah;
                    b<? super Integer, x> bVar = this.ChU;
                    if (bVar != null) {
                        bVar.invoke(Integer.valueOf(this.bxP));
                    }
                }
                this.ChP = -1;
                postInvalidate();
                break;
            case 3:
                this.ChP = -1;
                break;
        }
        AppMethodBeat.o(237969);
        return true;
    }

    private final int ah(float f2, float f3) {
        int round;
        AppMethodBeat.i(237970);
        if (!j.a(new f(0, getMeasuredHeight()), f3) || (round = Math.round(((f2 - ((float) getPaddingLeft())) - this.ChR) / this.ChN)) < 0 || round >= this.ChO.length) {
            AppMethodBeat.o(237970);
            return -1;
        }
        AppMethodBeat.o(237970);
        return round;
    }
}
