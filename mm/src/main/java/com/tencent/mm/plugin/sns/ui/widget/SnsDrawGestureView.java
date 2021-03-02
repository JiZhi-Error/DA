package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public class SnsDrawGestureView extends ImageView {
    private Paint Afb;
    private a Ffv;
    private int Ffw;
    private Paint Ffx;
    private List<PointF> points;

    public interface a {
        void fkn();

        void hi(List<PointF> list);

        void onClick();
    }

    public SnsDrawGestureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public SnsDrawGestureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(100540);
        this.points = new ArrayList();
        this.Ffw = -1;
        this.Afb = new Paint();
        this.Ffx = new Paint();
        this.Afb.setColor(this.Ffw);
        this.Afb.setStyle(Paint.Style.STROKE);
        this.Afb.setStrokeWidth((float) com.tencent.mm.cb.a.fromDPToPix(getContext(), 8));
        this.Afb.setPathEffect(new CornerPathEffect((float) com.tencent.mm.cb.a.fromDPToPix(getContext(), 4)));
        this.Afb.setAntiAlias(true);
        this.Ffx.setColor(this.Ffw);
        this.Ffx.setStyle(Paint.Style.FILL);
        this.Ffx.setAntiAlias(true);
        if (d.oE(21)) {
            setLayerType(1, null);
        }
        AppMethodBeat.o(100540);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(100541);
        if (motionEvent.getActionMasked() == 0) {
            if (this.Ffv != null) {
                this.Ffv.fkn();
            }
            this.points.clear();
            this.points.add(new PointF(motionEvent.getX(), motionEvent.getY()));
        } else if (motionEvent.getActionMasked() == 2) {
            this.points.add(new PointF(motionEvent.getX(), motionEvent.getY()));
            postInvalidate();
        } else if (motionEvent.getActionMasked() == 1) {
            Log.i("MicroMsg.SnsDrawGestureViewView", "point count %d", Integer.valueOf(this.points.size()));
            if (this.points.size() < 6) {
                this.points.clear();
                if (this.Ffv != null) {
                    this.Ffv.onClick();
                }
            } else if (this.Ffv != null) {
                this.Ffv.hi(flj());
            }
        } else if (this.Ffv != null) {
            this.Ffv.hi(flj());
        }
        AppMethodBeat.o(100541);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(100542);
        super.onDraw(canvas);
        if (this.points.size() > 0) {
            Path path = new Path();
            path.moveTo(this.points.get(0).x, this.points.get(0).y);
            canvas.drawCircle(this.points.get(0).x, this.points.get(0).y, ((float) com.tencent.mm.cb.a.fromDPToPix(getContext(), 8)) / 2.0f, this.Ffx);
            for (int i2 = 1; i2 < this.points.size(); i2++) {
                path.lineTo(this.points.get(i2).x, this.points.get(i2).y);
            }
            canvas.drawPath(path, this.Afb);
            canvas.drawCircle(this.points.get(this.points.size() - 1).x, this.points.get(this.points.size() - 1).y, ((float) com.tencent.mm.cb.a.fromDPToPix(getContext(), 8)) / 2.0f, this.Ffx);
        }
        AppMethodBeat.o(100542);
    }

    private List<PointF> flj() {
        AppMethodBeat.i(100543);
        ArrayList arrayList = new ArrayList();
        for (PointF pointF : this.points) {
            arrayList.add(new PointF(pointF.x, pointF.y));
        }
        AppMethodBeat.o(100543);
        return arrayList;
    }

    public void setPaintColor(int i2) {
        AppMethodBeat.i(100544);
        this.Ffw = i2;
        this.Afb.setColor(this.Ffw);
        this.Ffx.setColor(this.Ffw);
        AppMethodBeat.o(100544);
    }

    public final void flk() {
        AppMethodBeat.i(100545);
        this.points.clear();
        postInvalidate();
        AppMethodBeat.o(100545);
    }

    public void setOnGestureListener(a aVar) {
        this.Ffv = aVar;
    }

    public a getOnGestureListener() {
        return this.Ffv;
    }
}
