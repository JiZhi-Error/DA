package com.tencent.mm.danmaku.render;

import android.graphics.Canvas;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.f.a;
import com.tencent.mm.danmaku.render.NativeDanmakuView;
import com.tencent.mm.danmaku.render.d;

public final class e implements NativeDanmakuView.a, d {
    private d.b gOb;
    private boolean gPY;
    private boolean gPZ;
    private d.a gQa;
    private NativeDanmakuView gQb;

    public e(NativeDanmakuView nativeDanmakuView) {
        this.gQb = nativeDanmakuView;
        this.gQb.gPX = this;
    }

    @Override // com.tencent.mm.danmaku.render.d
    public final Canvas lockCanvas() {
        return null;
    }

    @Override // com.tencent.mm.danmaku.render.d
    public final void unlockCanvasAndPost(Canvas canvas) {
        this.gOb = null;
    }

    @Override // com.tencent.mm.danmaku.render.d
    public final void a(d.a aVar) {
        this.gQa = aVar;
    }

    @Override // com.tencent.mm.danmaku.render.d
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        AppMethodBeat.i(241704);
        this.gQb.setOnTouchListener(onTouchListener);
        AppMethodBeat.o(241704);
    }

    @Override // com.tencent.mm.danmaku.render.d
    public final float atd() {
        AppMethodBeat.i(241705);
        float y = this.gQb.getY();
        AppMethodBeat.o(241705);
        return y;
    }

    @Override // com.tencent.mm.danmaku.render.d
    public final void unlock() {
        this.gOb = null;
    }

    @Override // com.tencent.mm.danmaku.render.d
    public final void a(d.b bVar) {
        AppMethodBeat.i(241706);
        this.gPZ = true;
        this.gOb = bVar;
        if (a.ato()) {
            this.gQb.postInvalidateOnAnimation();
            AppMethodBeat.o(241706);
            return;
        }
        this.gQb.postInvalidate();
        AppMethodBeat.o(241706);
    }

    @Override // com.tencent.mm.danmaku.render.NativeDanmakuView.a
    public final void ate() {
        AppMethodBeat.i(241707);
        if (!this.gPY) {
            if (this.gQa != null) {
                this.gQa.asg();
                this.gQa.ash();
            }
            this.gPY = true;
            AppMethodBeat.o(241707);
            return;
        }
        if (this.gQa != null) {
            this.gQa.ash();
        }
        AppMethodBeat.o(241707);
    }

    @Override // com.tencent.mm.danmaku.render.NativeDanmakuView.a
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(241708);
        if (!this.gPZ) {
            AppMethodBeat.o(241708);
            return;
        }
        this.gPZ = false;
        if (this.gOb != null) {
            this.gOb.l(canvas);
        }
        AppMethodBeat.o(241708);
    }

    @Override // com.tencent.mm.danmaku.render.NativeDanmakuView.a
    public final void onDestroy() {
        AppMethodBeat.i(241709);
        if (this.gQa != null) {
            this.gQa.asi();
        }
        this.gPY = false;
        AppMethodBeat.o(241709);
    }
}
