package com.tencent.mm.plugin.vlog.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.vlog.ui.LabelSlider;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u001eH\u0002J\u0010\u0010/\u001a\u0002002\u0006\u0010.\u001a\u00020\u001eH\u0002J\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001e02J\u0010\u00103\u001a\u0002002\u0006\u00104\u001a\u000205H\u0014J(\u00106\u001a\u0002002\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\tH\u0014J\u0010\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020=H\u0016J\u000e\u0010>\u001a\u0002002\u0006\u0010\u0013\u001a\u00020\tJ\u000e\u0010?\u001a\u0002002\u0006\u0010@\u001a\u00020\tJ\u000e\u0010A\u001a\u0002002\u0006\u0010B\u001a\u00020\tJ\u0010\u0010C\u001a\u0002002\b\u0010D\u001a\u0004\u0018\u00010\u0018J\u000e\u0010E\u001a\u0002002\u0006\u0010F\u001a\u00020\tJ\u000e\u0010G\u001a\u0002002\u0006\u0010H\u001a\u00020\u001eJ\b\u0010I\u001a\u000200H\u0002J\b\u0010J\u001a\u000200H\u0002R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/SliderTrackView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;)V", "pointCount", "pointSize", "selectIndex", "startOffset", "thumbDrawable", "Landroid/graphics/drawable/Drawable;", "thumbHeight", "thumbRect", "Landroid/graphics/Rect;", "thumbWidth", "thumbX", "", "thumbY", "touchDownX", "touchDownY", "touchDrag", "", "touchMoved", "touchSlop", "touchX", "touchY", "trackPaint", "Landroid/graphics/Paint;", "trackPoint", "Ljava/util/LinkedList;", "Landroid/graphics/PointF;", "clampThumbPoint", "x", "findThumbPoint", "", "getTrackPoint", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setPointCount", "setSelection", FirebaseAnalytics.b.INDEX, "setStartOffset", "offset", "setThumbDrawable", "drawable", "setTrackColor", "color", "setTrackLineWidth", "lineWidth", "updateThumb", "updateTrackPoint", "plugin-vlog_release"})
public final class SliderTrackView extends View {
    private final Rect COM;
    private LabelSlider.a GDu;
    private boolean GFC;
    private final Paint GFD;
    private int GFE;
    private final LinkedList<PointF> GFF;
    private float GFG;
    private float GFH;
    private final String TAG;
    private boolean gZU;
    private float gZX;
    private float gZY;
    private float gZZ;
    private float haa;
    private Drawable oyT;
    private int pointCount;
    private final int rZ;
    private int startOffset;
    private int thumbHeight;
    private int thumbWidth;
    private int whv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderTrackView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(191126);
        this.TAG = "MicroMsg.LabelSlider";
        this.GFD = new Paint();
        this.pointCount = 5;
        this.startOffset = a.aG(context, R.dimen.cl);
        this.GFE = a.aG(context, R.dimen.ct);
        this.GFF = new LinkedList<>();
        this.COM = new Rect();
        this.thumbWidth = 48;
        this.thumbHeight = 48;
        this.GFD.setStyle(Paint.Style.STROKE);
        this.GFD.setColor(-855638017);
        this.GFD.setStrokeWidth(a.getDensity(context));
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        p.g(viewConfiguration, "ViewConfiguration.get(context)");
        this.rZ = viewConfiguration.getScaledTouchSlop();
        AppMethodBeat.o(191126);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SliderTrackView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(191127);
        AppMethodBeat.o(191127);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SliderTrackView(Context context) {
        this(context, null);
        p.h(context, "context");
        AppMethodBeat.i(191128);
        AppMethodBeat.o(191128);
    }

    public final LabelSlider.a getCallback() {
        return this.GDu;
    }

    public final void setCallback(LabelSlider.a aVar) {
        this.GDu = aVar;
    }

    public final void setPointCount(int i2) {
        AppMethodBeat.i(191113);
        if (i2 < 2) {
            Log.e(this.TAG, "invalid pointCount ".concat(String.valueOf(i2)));
            AppMethodBeat.o(191113);
            return;
        }
        this.pointCount = i2;
        fCK();
        if (this.whv >= i2) {
            this.whv = i2 - 1;
            LabelSlider.a aVar = this.GDu;
            if (aVar != null) {
                aVar.Ir(this.whv);
                AppMethodBeat.o(191113);
                return;
            }
        }
        AppMethodBeat.o(191113);
    }

    public final void setSelection(int i2) {
        AppMethodBeat.i(191114);
        this.whv = i2;
        fCL();
        invalidate();
        AppMethodBeat.o(191114);
    }

    public final void setTrackColor(int i2) {
        AppMethodBeat.i(191115);
        this.GFD.setColor(i2);
        postInvalidate();
        AppMethodBeat.o(191115);
    }

    public final void setTrackLineWidth(float f2) {
        AppMethodBeat.i(191116);
        this.GFD.setStrokeWidth(f2);
        postInvalidate();
        AppMethodBeat.o(191116);
    }

    public final void setStartOffset(int i2) {
        AppMethodBeat.i(191117);
        this.startOffset = i2;
        fCK();
        AppMethodBeat.o(191117);
    }

    public final void setThumbDrawable(Drawable drawable) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(191118);
        this.oyT = drawable;
        Drawable drawable2 = this.oyT;
        if (drawable2 != null) {
            i2 = drawable2.getIntrinsicWidth();
        } else {
            i2 = 0;
        }
        this.thumbWidth = i2;
        Drawable drawable3 = this.oyT;
        if (drawable3 != null) {
            i3 = drawable3.getIntrinsicHeight();
        }
        this.thumbHeight = i3;
        AppMethodBeat.o(191118);
    }

    public final List<Float> getTrackPoint() {
        AppMethodBeat.i(191119);
        LinkedList<PointF> linkedList = this.GFF;
        ArrayList arrayList = new ArrayList(j.a(linkedList, 10));
        Iterator<T> it = linkedList.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(((PointF) it.next()).x));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(191119);
        return arrayList2;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        float f2;
        AppMethodBeat.i(191120);
        p.h(motionEvent, "event");
        switch (motionEvent.getAction()) {
            case 0:
                this.gZX = motionEvent.getX();
                this.gZY = motionEvent.getY();
                this.gZZ = motionEvent.getX();
                this.haa = motionEvent.getY();
                this.GFC = this.COM.contains((int) this.gZX, (int) this.gZY);
                break;
            case 1:
            case 3:
                this.gZZ = motionEvent.getX();
                this.haa = motionEvent.getY();
                if (!this.gZU || this.GFC) {
                    cg(this.gZZ);
                    postInvalidate();
                }
                this.GFC = false;
                this.gZU = false;
                break;
            case 2:
                this.gZZ = motionEvent.getX();
                this.haa = motionEvent.getY();
                if (!this.gZU && (Math.abs(this.gZZ - this.gZX) > ((float) this.rZ) || Math.abs(this.haa - this.gZY) > ((float) this.rZ))) {
                    this.gZU = true;
                }
                if (this.GFC) {
                    float f3 = this.gZZ;
                    LinkedList<PointF> linkedList = this.GFF;
                    ArrayList arrayList = new ArrayList(j.a(linkedList, 10));
                    Iterator<T> it = linkedList.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Float.valueOf(((PointF) it.next()).x));
                    }
                    ArrayList arrayList2 = arrayList;
                    Float x = j.x(arrayList2);
                    Float v = j.v((Iterable<Float>) arrayList2);
                    if (x == null || v == null) {
                        f2 = f3;
                    } else {
                        f2 = Math.max(x.floatValue(), Math.min(v.floatValue(), f3));
                    }
                    this.GFG = f2;
                    this.COM.left = (int) (this.GFG - ((float) (this.thumbWidth / 2)));
                    this.COM.right = (int) (this.GFG + ((float) (this.thumbWidth / 2)));
                    postInvalidate();
                    break;
                }
                break;
        }
        AppMethodBeat.o(191120);
        return true;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(191121);
        p.h(canvas, "canvas");
        super.onDraw(canvas);
        if (this.GFF.size() < 2) {
            AppMethodBeat.o(191121);
            return;
        }
        float height = ((float) getHeight()) / 2.0f;
        float f2 = height - ((float) (this.GFE / 2));
        float f3 = height + ((float) (this.GFE / 2));
        canvas.drawLine(this.GFF.get(0).x, f2, this.GFF.get(0).x, f3, this.GFD);
        int i2 = this.pointCount - 1;
        for (int i3 = 0; i3 < i2; i3++) {
            canvas.drawLine(this.GFF.get(i3).x, height, this.GFF.get(i3 + 1).x, height, this.GFD);
            canvas.drawLine(this.GFF.get(i3 + 1).x, f2, this.GFF.get(i3 + 1).x, f3, this.GFD);
        }
        Drawable drawable = this.oyT;
        if (drawable != null) {
            drawable.setBounds(this.COM);
        }
        Drawable drawable2 = this.oyT;
        if (drawable2 != null) {
            drawable2.draw(canvas);
            AppMethodBeat.o(191121);
            return;
        }
        AppMethodBeat.o(191121);
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(191122);
        super.onSizeChanged(i2, i3, i4, i5);
        fCK();
        AppMethodBeat.o(191122);
    }

    private final void fCK() {
        AppMethodBeat.i(191123);
        int width = (getWidth() - (this.startOffset * 2)) / (this.pointCount - 1);
        float f2 = (float) this.startOffset;
        float height = ((float) getHeight()) / 2.0f;
        this.GFF.clear();
        this.GFF.add(new PointF(f2, height));
        int i2 = this.pointCount - 1;
        for (int i3 = 0; i3 < i2; i3++) {
            this.GFF.add(new PointF(((float) (width * i3)) + f2 + ((float) width), height));
        }
        this.GFH = height;
        fCL();
        postInvalidate();
        AppMethodBeat.o(191123);
    }

    private final void cg(float f2) {
        int i2;
        AppMethodBeat.i(191124);
        if (this.GFF.size() < 2) {
            AppMethodBeat.o(191124);
            return;
        }
        float width = (float) getWidth();
        int i3 = -1;
        int i4 = 0;
        int size = this.GFF.size();
        while (i4 < size) {
            float abs = Math.abs(f2 - this.GFF.get(i4).x);
            if (abs < width) {
                i2 = i4;
            } else {
                i2 = i3;
                abs = width;
            }
            i4++;
            i3 = i2;
            width = abs;
        }
        if (i3 >= 0) {
            this.whv = i3;
            fCL();
            LabelSlider.a aVar = this.GDu;
            if (aVar != null) {
                aVar.Ir(this.whv);
                AppMethodBeat.o(191124);
                return;
            }
        }
        AppMethodBeat.o(191124);
    }

    private final void fCL() {
        AppMethodBeat.i(191125);
        this.COM.top = (int) (this.GFH - ((float) (this.thumbHeight / 2)));
        this.COM.bottom = (int) (this.GFH + ((float) (this.thumbHeight / 2)));
        this.GFG = this.GFF.get(this.whv).x;
        this.COM.left = (int) (this.GFG - ((float) (this.thumbWidth / 2)));
        this.COM.right = (int) (this.GFG + ((float) (this.thumbWidth / 2)));
        AppMethodBeat.o(191125);
    }
}
