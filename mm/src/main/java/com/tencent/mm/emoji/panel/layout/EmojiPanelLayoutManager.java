package com.tencent.mm.emoji.panel.layout;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/emoji/panel/layout/EmojiPanelLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "(Landroid/content/Context;)V", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "TAG", "", "isScrollEnabled", "()Z", "setScrollEnabled", "(Z)V", "canScrollHorizontally", "canScrollVertically", "plugin-emojisdk_release"})
public final class EmojiPanelLayoutManager extends LinearLayoutManager {
    private final String TAG = "MicroMsg.EmojiPanelLayoutManager";
    public boolean hbX = true;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmojiPanelLayoutManager(Context context) {
        super(0, false);
        p.h(context, "context");
        AppMethodBeat.i(105717);
        AppMethodBeat.o(105717);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final boolean canScrollHorizontally() {
        AppMethodBeat.i(105715);
        if (!this.hbX || !super.canScrollHorizontally()) {
            AppMethodBeat.o(105715);
            return false;
        }
        AppMethodBeat.o(105715);
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final boolean canScrollVertically() {
        AppMethodBeat.i(105716);
        if (!this.hbX || !super.canScrollVertically()) {
            AppMethodBeat.o(105716);
            return false;
        }
        AppMethodBeat.o(105716);
        return true;
    }
}
