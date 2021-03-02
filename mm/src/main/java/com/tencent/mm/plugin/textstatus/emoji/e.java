package com.tencent.mm.plugin.textstatus.emoji;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiContentViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;)V", "contentRv", "Landroid/support/v7/widget/RecyclerView;", "getContentRv", "()Landroid/support/v7/widget/RecyclerView;", "exceptionTipRl", "Landroid/widget/LinearLayout;", "getListener", "()Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;", "rootSv", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiGridScrollView;", "getRootSv", "()Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiGridScrollView;", "subType", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeData;", "fillContent", "", "context", "Landroid/content/Context;", "subTypeData", "plugin-textstatus_release"})
public final class e extends RecyclerView.v {
    final ImeEmojiGridScrollView VcM;
    final RecyclerView VcN;
    LinearLayout VcO;
    j VcP;
    final a VcQ;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(View view, a aVar) {
        super(view);
        p.h(view, "itemView");
        AppMethodBeat.i(258328);
        this.VcQ = aVar;
        View findViewById = view.findViewById(R.id.h9a);
        p.g(findViewById, "itemView.findViewById(R.id.root_view)");
        this.VcM = (ImeEmojiGridScrollView) findViewById;
        View findViewById2 = view.findViewById(R.id.h8v);
        p.g(findViewById2, "itemView.findViewById(R.id.root)");
        this.VcN = (RecyclerView) findViewById2;
        View findViewById3 = view.findViewById(R.id.jum);
        p.g(findViewById3, "itemView.findViewById(R.id.emoji_exception_tip_rl)");
        this.VcO = (LinearLayout) findViewById3;
        AppMethodBeat.o(258328);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "nestedScrollView", "Landroid/support/v4/widget/NestedScrollView;", "scrollX", "", "scrollY", "oldScrollX", "oldScrollY", "onScrollChange"})
    static final class a implements NestedScrollView.b {
        final /* synthetic */ e VcR;

        a(e eVar) {
            this.VcR = eVar;
        }

        @Override // android.support.v4.widget.NestedScrollView.b
        public final void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(258327);
            p.h(nestedScrollView, "nestedScrollView");
            Log.d("WxIme.ImeEmojiContentAdapter", "scrollX:" + i2 + " scrollY:" + i3 + " oldScrollX:" + i4 + " oldScrollY:" + i5);
            RecyclerView.LayoutManager layoutManager = this.VcR.VcN.getLayoutManager();
            if (layoutManager == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.emoji.EmojiLayoutManager");
                AppMethodBeat.o(258327);
                throw tVar;
            }
            ((EmojiLayoutManager) layoutManager).axn(i3);
            AppMethodBeat.o(258327);
        }
    }
}
