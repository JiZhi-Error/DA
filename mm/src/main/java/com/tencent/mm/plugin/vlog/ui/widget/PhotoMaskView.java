package com.tencent.mm.plugin.vlog.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB+\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/widget/PhotoMaskView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "maskPaint", "Landroid/graphics/Paint;", "visibleRect", "Landroid/graphics/RectF;", "getVisibleRect", "()Landroid/graphics/RectF;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "plugin-vlog_release"})
public final class PhotoMaskView extends View {
    private final Paint GQz = new Paint();
    private final RectF GyF = new RectF();

    public PhotoMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(192214);
        this.GQz.setColor(WebView.NIGHT_MODE_COLOR);
        this.GQz.setStyle(Paint.Style.FILL);
        AppMethodBeat.o(192214);
    }

    public PhotoMaskView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(192215);
        this.GQz.setColor(WebView.NIGHT_MODE_COLOR);
        this.GQz.setStyle(Paint.Style.FILL);
        AppMethodBeat.o(192215);
    }

    public final RectF getVisibleRect() {
        return this.GyF;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(192213);
        super.onDraw(canvas);
        if (!this.GyF.isEmpty()) {
            if (canvas != null) {
                canvas.drawRect(0.0f, 0.0f, (float) getWidth(), this.GyF.top, this.GQz);
            }
            if (canvas != null) {
                canvas.drawRect(0.0f, this.GyF.bottom, (float) getWidth(), (float) getHeight(), this.GQz);
                AppMethodBeat.o(192213);
                return;
            }
        }
        AppMethodBeat.o(192213);
    }
}
