package com.tencent.mm.plugin.emojicapture.ui.editor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.bizvideochannel.a;
import com.tencent.thumbplayer.api.TPOptionalID;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\u0016\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorOutsideView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clipPath", "Landroid/graphics/Path;", "outsidePaint", "Landroid/graphics/Paint;", "outsidePath", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setValidArea", "bounds", "Landroid/graphics/RectF;", "radius", "", "plugin-emojicapture_release"})
public final class EditorOutsideView extends View {
    private final Path rqV;
    private final Paint rva;
    private final Path rvb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditorOutsideView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(766);
        this.rqV = new Path();
        this.rva = new Paint();
        this.rvb = new Path();
        this.rva.setAntiAlias(true);
        this.rva.setColor(getResources().getColor(R.color.BW_93));
        this.rva.setAlpha(TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH);
        AppMethodBeat.o(766);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EditorOutsideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(a.CTRL_INDEX);
        AppMethodBeat.o(a.CTRL_INDEX);
    }

    public final void a(RectF rectF, float f2) {
        AppMethodBeat.i(764);
        p.h(rectF, "bounds");
        this.rqV.reset();
        this.rqV.addRoundRect(new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom), f2, f2, Path.Direction.CW);
        postInvalidate();
        AppMethodBeat.o(764);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(765);
        p.h(canvas, "canvas");
        super.onDraw(canvas);
        this.rvb.reset();
        this.rvb.addPath(this.rqV);
        this.rvb.addRect(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), Path.Direction.CCW);
        canvas.drawPath(this.rvb, this.rva);
        AppMethodBeat.o(765);
    }
}
