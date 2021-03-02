package com.tencent.mm.plugin.vlog.ui.plugin.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.vlog.ui.thumb.f;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u00010B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J1\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u001b0\u001fJ\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0019H\u0002J \u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020*2\u0006\u0010%\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0016J\u0014\u0010-\u001a\u00020\u001b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190.J\u0006\u0010/\u001a\u00020\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\f\u0012\b\u0012\u00060\u000fR\u00020\u00000\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000eX\u0004¢\u0006\u0002\n\u0000¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionMarkDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "getContext", "()Landroid/content/Context;", "halfMarkWidth", "", "markRange", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionMarkDecoration$Range;", "markWidth", "offset", "selectIndex", "getSelectIndex", "()I", "setSelectIndex", "(I)V", "touchExtend", "transMarkStatusList", "", "checkClick", "", "x", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "position", "createTransitionMarkView", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "hasTransition", "onDrawOver", "c", "Landroid/graphics/Canvas;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "updateTransMarkStatus", "", "width", "Range", "plugin-vlog_release"})
public final class e extends RecyclerView.h {
    public final int GOa = com.tencent.mm.cb.a.fromDPToPix(this.context, 22);
    private final int GOb = (this.GOa / 2);
    private final List<a> GOc = new ArrayList();
    private final List<Boolean> GOd = new ArrayList();
    private final int GOe = com.tencent.mm.cb.a.fromDPToPix(this.context, 16);
    private final f GOf;
    private final Context context;
    private int offset;
    public int whv = -1;

    public e(Context context2, f fVar) {
        p.h(context2, "context");
        p.h(fVar, "adapter");
        AppMethodBeat.i(192018);
        this.context = context2;
        this.GOf = fVar;
        AppMethodBeat.o(192018);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionMarkDecoration$Range;", "", "position", "", "left", "", "right", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionMarkDecoration;IFF)V", "getLeft", "()F", "setLeft", "(F)V", "getPosition", "()I", "setPosition", "(I)V", "getRight", "setRight", "contains", "", "value", "set", "", "plugin-vlog_release"})
    public final class a {
        float left;
        int position;
        float right;

        public a(int i2, float f2, float f3) {
            this.position = i2;
            this.left = f2;
            this.right = f3;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        AppMethodBeat.i(192015);
        p.h(canvas, "c");
        p.h(recyclerView, "parent");
        p.h(sVar, "state");
        super.b(canvas, recyclerView, sVar);
        int itemCount = this.GOf.getItemCount();
        this.offset = 0;
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            int bw = RecyclerView.bw(childAt);
            if (bw > 1 && bw < itemCount - 1) {
                if (this.whv >= 0) {
                    int i3 = this.whv + 1;
                    int i4 = this.whv + 2;
                    if (i3 <= bw) {
                        if (i4 < bw) {
                        }
                    }
                }
                p.g(childAt, "childView");
                int left = childAt.getLeft();
                Boolean bool = (Boolean) j.L(this.GOd, bw - 2);
                boolean booleanValue = bool != null ? bool.booleanValue() : false;
                View inflate = LayoutInflater.from(this.context).inflate(R.layout.c6g, (ViewGroup) recyclerView, false);
                ((ImageView) inflate.findViewById(R.id.j93)).setImageDrawable(ar.m(this.context, R.raw.icons_filled_transform, this.context.getResources().getColor(booleanValue ? R.color.Orange : R.color.BW_50)));
                inflate.measure(this.GOa, this.GOa);
                inflate.layout(0, 0, this.GOa, this.GOa);
                p.g(inflate, "view");
                float f2 = ((float) left) - ((float) this.GOb);
                float f3 = ((float) left) + ((float) this.GOb);
                canvas.save();
                canvas.translate(f2, ((float) (recyclerView.getHeight() - this.GOa)) / 2.0f);
                inflate.draw(canvas);
                canvas.restore();
                if (this.offset < this.GOc.size()) {
                    a aVar = this.GOc.get(this.offset);
                    float f4 = f2 - ((float) this.GOe);
                    aVar.position = bw - 2;
                    aVar.left = f4;
                    aVar.right = f3 + ((float) this.GOe);
                } else {
                    this.GOc.add(new a(bw - 2, f2 - ((float) this.GOe), f3 + ((float) this.GOe)));
                }
                this.offset++;
            }
        }
        AppMethodBeat.o(192015);
    }

    public final void a(float f2, b<? super Integer, x> bVar) {
        AppMethodBeat.i(192016);
        p.h(bVar, "callback");
        int i2 = this.offset;
        for (int i3 = 0; i3 < i2; i3++) {
            a aVar = this.GOc.get(i3);
            if (f2 >= aVar.left && f2 <= aVar.right) {
                bVar.invoke(Integer.valueOf(this.GOc.get(i3).position));
                AppMethodBeat.o(192016);
                return;
            }
        }
        bVar.invoke(-1);
        AppMethodBeat.o(192016);
    }

    public final void hS(List<Boolean> list) {
        AppMethodBeat.i(192017);
        p.h(list, "transMarkStatusList");
        this.GOd.clear();
        this.GOd.addAll(list);
        AppMethodBeat.o(192017);
    }
}
