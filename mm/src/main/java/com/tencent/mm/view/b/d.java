package com.tencent.mm.view.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;

public final class d extends a {
    public d(Context context, b bVar) {
        super(context, bVar);
    }

    @Override // com.tencent.mm.view.b.a
    public final Rect getAliveRect() {
        AppMethodBeat.i(9399);
        if (super.getAliveRect().isEmpty()) {
            Rect boardRect = getBoardRect();
            AppMethodBeat.o(9399);
            return boardRect;
        }
        Rect aliveRect = super.getAliveRect();
        AppMethodBeat.o(9399);
        return aliveRect;
    }

    @Override // com.tencent.mm.view.b.a
    public final boolean hgb() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.b.a
    public final boolean hga() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.b.a
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(9400);
        canvas.drawColor(0);
        canvas.setMatrix(this.drT);
        getPresenter().onDraw(canvas);
        AppMethodBeat.o(9400);
    }
}
