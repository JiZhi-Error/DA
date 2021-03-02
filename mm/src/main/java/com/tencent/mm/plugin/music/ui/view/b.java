package com.tencent.mm.plugin.music.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0014\u0010\u0017\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/music/ui/view/MusicMVDurationDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "drawingContent", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "textPaint", "Landroid/graphics/Paint;", "textWidth", "", "onDrawOver", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "updateContent", "tickMsList", "", "", "plugin-music_release"})
public final class b extends RecyclerView.h {
    private final ArrayList<String> Aok = new ArrayList<>();
    private final Paint cgU = new Paint(1);
    private final Context context;
    private float jq;

    public b(Context context2) {
        p.h(context2, "context");
        AppMethodBeat.i(220037);
        this.context = context2;
        this.cgU.setColor(this.context.getResources().getColor(R.color.BW_100_Alpha_0_3));
        this.cgU.setTextSize((float) a.fromDPToPix(this.context, 10));
        this.jq = this.cgU.measureText("00:00");
        AppMethodBeat.o(220037);
    }

    public final void fD(List<Long> list) {
        AppMethodBeat.i(220035);
        p.h(list, "tickMsList");
        this.Aok.clear();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss", Locale.getDefault());
        ArrayList<String> arrayList = this.Aok;
        List<Long> list2 = list;
        ArrayList arrayList2 = new ArrayList(j.a(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList2.add(simpleDateFormat.format(Long.valueOf(it.next().longValue())));
        }
        arrayList.addAll(arrayList2);
        AppMethodBeat.o(220035);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        AppMethodBeat.i(220036);
        p.h(canvas, "c");
        p.h(recyclerView, "parent");
        p.h(sVar, "state");
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            int bw = RecyclerView.bw(childAt);
            p.g(childAt, "child");
            float bottom = ((float) childAt.getBottom()) - this.cgU.getFontMetrics().descent;
            int left = childAt.getLeft();
            int right = childAt.getRight();
            if (((float) left) > (-this.jq) / 2.0f) {
                canvas.drawText(this.Aok.get(bw), ((float) left) - (this.jq / 2.0f), bottom, this.cgU);
            }
            if (i2 == childCount - 1 && bw + 1 < this.Aok.size() && ((float) right) < ((float) recyclerView.getWidth()) + (this.jq / 2.0f)) {
                canvas.drawText(this.Aok.get(bw + 1), ((float) right) - (this.jq / 2.0f), bottom - this.cgU.getFontMetrics().descent, this.cgU);
            }
        }
        super.b(canvas, recyclerView, sVar);
        AppMethodBeat.o(220036);
    }
}
