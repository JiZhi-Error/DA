package com.tencent.mm.plugin.finder.search;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchContactHeaderHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "moreArrow", "moreTV", "Landroid/widget/TextView;", "onBindView", "", "needShowMore", "", "moreClickListener", "Landroid/view/View$OnClickListener;", "plugin-finder_release"})
public final class b extends RecyclerView.v {
    TextView vui;
    View vuj;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view) {
        super(view);
        p.h(view, "itemView");
        AppMethodBeat.i(166798);
        View findViewById = view.findViewById(R.id.fl3);
        p.g(findViewById, "itemView.findViewById(R.id.more_tv)");
        this.vui = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.fjt);
        p.g(findViewById2, "itemView.findViewById(R.id.more_arrow)");
        this.vuj = findViewById2;
        AppMethodBeat.o(166798);
    }
}
