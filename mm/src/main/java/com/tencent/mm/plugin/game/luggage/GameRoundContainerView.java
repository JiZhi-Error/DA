package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.at;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J(\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0014R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/game/luggage/GameRoundContainerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "path", "Landroid/graphics/Path;", "radius", "", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "luggage-game_release"})
public final class GameRoundContainerView extends FrameLayout {
    private Path lR;
    private int radius;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GameRoundContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(187025);
        this.radius = at.fromDPToPix(context, 12);
        AppMethodBeat.o(187025);
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(187023);
        super.onSizeChanged(i2, i3, i4, i5);
        this.lR = new Path();
        Path path = this.lR;
        if (path == null) {
            p.btv("path");
        }
        path.addArc(0.0f, 0.0f, 2.0f * ((float) this.radius), 2.0f * ((float) this.radius), 180.0f, 90.0f);
        Path path2 = this.lR;
        if (path2 == null) {
            p.btv("path");
        }
        path2.lineTo(((float) i2) - ((float) this.radius), 0.0f);
        Path path3 = this.lR;
        if (path3 == null) {
            p.btv("path");
        }
        path3.addArc(((float) i2) - (2.0f * ((float) this.radius)), 0.0f, (float) i2, 2.0f * ((float) this.radius), 270.0f, 90.0f);
        Path path4 = this.lR;
        if (path4 == null) {
            p.btv("path");
        }
        path4.lineTo((float) i2, (float) i3);
        Path path5 = this.lR;
        if (path5 == null) {
            p.btv("path");
        }
        path5.lineTo(0.0f, (float) i3);
        Path path6 = this.lR;
        if (path6 == null) {
            p.btv("path");
        }
        path6.lineTo(0.0f, (float) this.radius);
        AppMethodBeat.o(187023);
    }

    /* access modifiers changed from: protected */
    public final void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(187024);
        p.h(canvas, "canvas");
        Path path = this.lR;
        if (path == null) {
            p.btv("path");
        }
        canvas.clipPath(path);
        super.dispatchDraw(canvas);
        AppMethodBeat.o(187024);
    }
}
