package com.tencent.mm.plugin.multitalk.ui.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarLayoutHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarLayout", "Landroid/widget/RelativeLayout;", "plugin-multitalk_release"})
public final class t extends RecyclerView.v {
    public RelativeLayout zVi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(View view) {
        super(view);
        p.h(view, "itemView");
        AppMethodBeat.i(178992);
        View findViewById = view.findViewById(R.id.ht2);
        if (findViewById == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
            AppMethodBeat.o(178992);
            throw tVar;
        }
        this.zVi = (RelativeLayout) findViewById;
        AppMethodBeat.o(178992);
    }
}
