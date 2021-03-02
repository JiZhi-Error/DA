package com.tencent.mm.plugin.multitalk.ui.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarHolderInContactUI;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "headerStub", "getHeaderStub", "()Landroid/view/View;", "setHeaderStub", "plugin-multitalk_release"})
public final class r extends RecyclerView.v {
    ImageView gyr;
    View zRg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(View view) {
        super(view);
        p.h(view, "itemView");
        AppMethodBeat.i(178985);
        View findViewById = view.findViewById(R.id.wm);
        p.g(findViewById, "itemView.findViewById(R.id.avatar)");
        this.gyr = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.dot);
        p.g(findViewById2, "itemView.findViewById(R.id.header_stub)");
        this.zRg = findViewById2;
        AppMethodBeat.o(178985);
    }
}
