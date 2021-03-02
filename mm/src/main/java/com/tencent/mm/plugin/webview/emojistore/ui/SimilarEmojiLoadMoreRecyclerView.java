package com.tencent.mm.plugin.webview.emojistore.ui;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.panel.EmojiPanelRecyclerView;
import com.tencent.mm.hellhoundlib.b.b;

public class SimilarEmojiLoadMoreRecyclerView extends EmojiPanelRecyclerView {
    private a INA;
    boolean oEn;

    public interface a {
        void gas();
    }

    public SimilarEmojiLoadMoreRecyclerView(Context context) {
        super(context);
        AppMethodBeat.i(77872);
        init();
        AppMethodBeat.o(77872);
    }

    public SimilarEmojiLoadMoreRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(77873);
        init();
        AppMethodBeat.o(77873);
    }

    public SimilarEmojiLoadMoreRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(77874);
        init();
        AppMethodBeat.o(77874);
    }

    private void init() {
        AppMethodBeat.i(77875);
        setEnableLongPress(false);
        avQ();
        a(new RecyclerView.l() {
            /* class com.tencent.mm.plugin.webview.emojistore.ui.SimilarEmojiLoadMoreRecyclerView.AnonymousClass1 */

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                AppMethodBeat.i(210817);
                b bVar = new b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                bVar.pH(i3);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                super.onScrolled(recyclerView, i2, i3);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(210817);
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                AppMethodBeat.i(77871);
                b bVar = new b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 != 0 || SimilarEmojiLoadMoreRecyclerView.this.oEn || SimilarEmojiLoadMoreRecyclerView.this.getLayoutManager() == null || SimilarEmojiLoadMoreRecyclerView.this.getAdapter() == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                    AppMethodBeat.o(77871);
                    return;
                }
                if (((GridLayoutManager) SimilarEmojiLoadMoreRecyclerView.this.getLayoutManager()).apM + ((GridLayoutManager) SimilarEmojiLoadMoreRecyclerView.this.getLayoutManager()).ku() + 1 >= SimilarEmojiLoadMoreRecyclerView.this.getAdapter().getItemCount() && SimilarEmojiLoadMoreRecyclerView.this.INA != null) {
                    a aVar = SimilarEmojiLoadMoreRecyclerView.this.INA;
                    SimilarEmojiLoadMoreRecyclerView.this.getAdapter();
                    aVar.gas();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                AppMethodBeat.o(77871);
            }
        });
        AppMethodBeat.o(77875);
    }

    public final boolean gar() {
        return this.oEn;
    }

    public final void showLoading(boolean z) {
        if (this.oEn != z) {
            this.oEn = z;
        }
    }

    public void setOnLoadingStateChangedListener(a aVar) {
        this.INA = aVar;
    }
}
