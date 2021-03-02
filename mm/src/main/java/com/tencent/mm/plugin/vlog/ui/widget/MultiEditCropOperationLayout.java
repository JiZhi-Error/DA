package com.tencent.mm.plugin.vlog.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 )2\u00020\u0001:\u0001)B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\u0006\u0010\u0019\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u000eJ\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J(\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020(H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropOperationLayout;", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "boxPaint", "Landroid/graphics/Paint;", "isBelongCenterBlock", "", "isEnableOutsideTouch", "isFullscreenMode", "maxVisibilityRect", "Landroid/graphics/RectF;", "getMaxVisibilityRect", "()Landroid/graphics/RectF;", "drawCutBoxLine", "", "canvas", "Landroid/graphics/Canvas;", "enableFullscreenMode", "enableOutsideTouch", "enable", "onDown", "event", "Landroid/view/MotionEvent;", "onScroll", "e2", "distanceX", "", "distanceY", "onTouchEvent", "showBorder", "alpha", "delay", "", "Companion", "plugin-vlog_release"})
public final class MultiEditCropOperationLayout extends WxCropOperationLayout {
    public static final a GQn = new a((byte) 0);
    private final Paint BYU = new Paint();
    private final RectF GQk = new RectF();
    private boolean GQl;
    public boolean GQm;
    public boolean Gna;

    static {
        AppMethodBeat.i(192185);
        AppMethodBeat.o(192185);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiEditCropOperationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(192183);
        this.BYU.setColor(-1);
        this.BYU.setAntiAlias(true);
        this.BYU.setStrokeWidth((float) com.tencent.mm.cb.a.fromDPToPix(getContext(), 2));
        this.BYU.setStyle(Paint.Style.STROKE);
        getGridLinePaint().setColor(Color.parseColor("#4DFFFFFF"));
        getGridLinePaint().setAntiAlias(true);
        getGridLinePaint().setStrokeWidth((float) com.tencent.mm.cb.a.fromDPToPix(getContext(), 1));
        getGridLinePaint().setStyle(Paint.Style.STROKE);
        AppMethodBeat.o(192183);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiEditCropOperationLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(192184);
        this.BYU.setColor(-1);
        this.BYU.setAntiAlias(true);
        this.BYU.setStrokeWidth((float) com.tencent.mm.cb.a.fromDPToPix(getContext(), 2));
        this.BYU.setStyle(Paint.Style.STROKE);
        getGridLinePaint().setColor(Color.parseColor("#4DFFFFFF"));
        getGridLinePaint().setAntiAlias(true);
        getGridLinePaint().setStrokeWidth((float) com.tencent.mm.cb.a.fromDPToPix(getContext(), 1));
        getGridLinePaint().setStyle(Paint.Style.STROKE);
        AppMethodBeat.o(192184);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropOperationLayout$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final RectF getMaxVisibilityRect() {
        return this.GQk;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(192178);
        p.h(motionEvent, "event");
        if (!this.Gna) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(192178);
            return onTouchEvent;
        }
        super.onTouchEvent(motionEvent);
        boolean z = this.GQl | this.BZp | this.BZq;
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.GQl = false;
            setBelongTopBlock(false);
            setBelongBottomBlock(false);
        }
        if (getStyle() != WxCropOperationLayout.j.RECT_ADJUST) {
            AppMethodBeat.o(192178);
            return false;
        } else if (this.GQm) {
            AppMethodBeat.o(192178);
            return z;
        } else {
            AppMethodBeat.o(192178);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout
    public final boolean onDown(MotionEvent motionEvent) {
        AppMethodBeat.i(192179);
        p.h(motionEvent, "event");
        if (!this.Gna) {
            boolean onDown = super.onDown(motionEvent);
            AppMethodBeat.o(192179);
            return onDown;
        } else if (getStyle() == WxCropOperationLayout.j.RECT_ADJUST) {
            this.GQl = false;
            if (getVisibilityRect().contains(motionEvent.getX(), motionEvent.getY())) {
                this.GQl = true;
            }
            AppMethodBeat.o(192179);
            return true;
        } else {
            AppMethodBeat.o(192179);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        AppMethodBeat.i(192180);
        p.h(motionEvent, "event");
        p.h(motionEvent2, "e2");
        if (!this.Gna) {
            boolean onScroll = super.onScroll(motionEvent, motionEvent2, f2, f3);
            AppMethodBeat.o(192180);
            return onScroll;
        }
        new StringBuilder("[onScroll] event=").append(motionEvent);
        if (this.GQl) {
            getVisibilityRect().offset(-f2, -f3);
            if (getVisibilityRect().top < this.GQk.top) {
                getVisibilityRect().offset(0.0f, this.GQk.top - getVisibilityRect().top);
            }
            if (getVisibilityRect().bottom > this.GQk.bottom) {
                getVisibilityRect().offset(0.0f, this.GQk.bottom - getVisibilityRect().bottom);
            }
            if (getVisibilityRect().left < this.GQk.left) {
                getVisibilityRect().offset(this.GQk.left - getVisibilityRect().left, 0.0f);
            }
            if (getVisibilityRect().right > this.GQk.right) {
                getVisibilityRect().offset(this.GQk.right - getVisibilityRect().right, 0.0f);
            }
        }
        postInvalidate();
        boolean z = this.GQl;
        AppMethodBeat.o(192180);
        return z;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout
    public final void u(Canvas canvas) {
        AppMethodBeat.i(192181);
        p.h(canvas, "canvas");
        if (!this.Gna) {
            super.u(canvas);
            AppMethodBeat.o(192181);
            return;
        }
        if (getStyle() == WxCropOperationLayout.j.RECT_ADJUST || getStyle() == WxCropOperationLayout.j.RECT_LINE_HARD) {
            if (getShowGridLine()) {
                canvas.drawPath(getGridLinePath(), getGridLinePaint());
            }
            canvas.drawRect(getBoxRect(), this.BYU);
        }
        AppMethodBeat.o(192181);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout
    public final void ay(int i2, long j2) {
        AppMethodBeat.i(192182);
        if (!this.Gna) {
            super.ay(i2, j2);
            AppMethodBeat.o(192182);
            return;
        }
        AppMethodBeat.o(192182);
    }
}
