package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;

public final class d extends RecyclerView.h {
    private static int pzN = 0;
    int padding;
    Paint paint = new Paint();
    private float pzM;

    public d(int i2, Context context) {
        AppMethodBeat.i(195019);
        this.padding = i2;
        this.paint.setColor(context.getResources().getColor(R.color.FG_3));
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setFlags(1);
        this.pzM = (float) a.eP(context);
        pzN = a.fromDPToPix(context, 4);
        AppMethodBeat.o(195019);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(6133);
        int bx = RecyclerView.bx(view);
        rect.top = 0;
        rect.bottom = 0;
        if (((BizTimeLineHotListView) recyclerView).pyY) {
            rect.left = (bx == 0 || bx == 1) ? 0 : this.padding / 2;
            if (!(bx == 0 || bx == 1)) {
                i3 = this.padding / 2;
            }
            rect.right = i3;
            AppMethodBeat.o(6133);
            return;
        }
        if (bx != 0) {
            i2 = this.padding / 2;
        } else {
            i2 = 0;
        }
        rect.left = i2;
        if (bx != 0) {
            i3 = this.padding / 2;
        }
        rect.right = i3;
        AppMethodBeat.o(6133);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        AppMethodBeat.i(195020);
        super.a(canvas, recyclerView, sVar);
        BizTimeLineHotListView bizTimeLineHotListView = (BizTimeLineHotListView) recyclerView;
        if (!bizTimeLineHotListView.pyY || bizTimeLineHotListView.getDataCount() <= 2) {
            AppMethodBeat.o(195020);
            return;
        }
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount - 1; i2++) {
            View childAt = bizTimeLineHotListView.getChildAt(i2);
            int bx = RecyclerView.bx(childAt);
            if (bx == 1 || (bx == 0 && i2 == 1)) {
                float max = Math.max(0.0f, (((float) (childAt.getBottom() - childAt.getTop())) - this.pzM) / 2.0f);
                float right = (float) childAt.getRight();
                canvas.drawRect(right - 0.35f, (((float) childAt.getTop()) + max) - ((float) (pzN * 2)), 1.0f + right, (((float) childAt.getBottom()) - max) - ((float) (pzN * 2)), this.paint);
                AppMethodBeat.o(195020);
                return;
            }
        }
        AppMethodBeat.o(195020);
    }
}
