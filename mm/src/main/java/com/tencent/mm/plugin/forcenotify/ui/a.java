package com.tencent.mm.plugin.forcenotify.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J \u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "dividerHeight", "", "(Landroid/content/Context;I)V", "bounds", "Landroid/graphics/Rect;", "getContext", "()Landroid/content/Context;", "getDividerHeight", "()I", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "getItemOffsets", "", "outRect", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDrawOver", "canvas", "Landroid/graphics/Canvas;", "plugin-force-notify_release"})
public final class a extends RecyclerView.h {
    private final Context context;
    private final int dividerHeight;
    private final Rect hN = new Rect();
    private final Paint paint;

    public a(Context context2, int i2) {
        p.h(context2, "context");
        AppMethodBeat.i(261786);
        this.context = context2;
        this.dividerHeight = i2;
        Paint paint2 = new Paint();
        paint2.setColor(this.context.getResources().getColor(R.color.agt));
        paint2.setAntiAlias(true);
        this.paint = paint2;
        AppMethodBeat.o(261786);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        AppMethodBeat.i(261784);
        p.h(canvas, "canvas");
        p.h(recyclerView, "parent");
        p.h(sVar, "state");
        super.b(canvas, recyclerView, sVar);
        canvas.save();
        int childCount = recyclerView.getChildCount();
        if (childCount > 1) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                if (RecyclerView.bw(childAt) != 0) {
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if (layoutManager != null) {
                        layoutManager.getDecoratedBoundsWithMargins(childAt, this.hN);
                    }
                    TextView textView = (TextView) childAt.findViewById(R.id.ir3);
                    int i3 = this.hN.top - this.dividerHeight;
                    int i4 = this.hN.top;
                    int right = recyclerView.getRight();
                    p.g(textView, "titleTv");
                    int left = textView.getLeft();
                    Log.i("ARNOLIANG", "drawDivider top:" + i3 + ", bottom:" + i4 + ", left:" + left + ", right:" + right);
                    canvas.drawRect((float) left, (float) i3, (float) right, (float) i4, this.paint);
                }
            }
        }
        canvas.restore();
        AppMethodBeat.o(261784);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        AppMethodBeat.i(261785);
        p.h(rect, "outRect");
        p.h(view, "view");
        p.h(recyclerView, "parent");
        p.h(sVar, "state");
        super.a(rect, view, recyclerView, sVar);
        if (RecyclerView.bw(view) != 0) {
            rect.top = this.dividerHeight;
        }
        AppMethodBeat.o(261785);
    }
}
