package com.tencent.mm.emoji.panel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.m.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0010R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/emoji/panel/EmojiPanelGroupView;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "scrollEnabled", "", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "setScrollEnable", "", "enable", "plugin-emojisdk_release"})
public final class EmojiPanelGroupView extends RecyclerView {
    private final String TAG;
    private final b gZR;
    private boolean gZS;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmojiPanelGroupView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(105596);
        this.TAG = "MicroMsg.EmojiPanelGroupView";
        this.gZR = new b(context);
        setItemViewCacheSize(0);
        AppMethodBeat.o(105596);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EmojiPanelGroupView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(105597);
        AppMethodBeat.o(105597);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        if (r3 == false) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            r5 = 105595(0x19c7b, float:1.4797E-40)
            r1 = 1
            r2 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            java.lang.String r0 = "ev"
            kotlin.g.b.p.h(r7, r0)
            com.tencent.mm.ui.m.b r0 = r6.gZR
            r0.al(r7)
            com.tencent.mm.ui.m.b r0 = r6.gZR
            int r3 = r0.QnD
            android.support.v7.widget.RecyclerView$LayoutManager r0 = r6.getLayoutManager()
            boolean r4 = r0 instanceof com.tencent.mm.emoji.panel.layout.EmojiPanelLayoutManager
            if (r4 != 0) goto L_0x0020
            r0 = 0
        L_0x0020:
            com.tencent.mm.emoji.panel.layout.EmojiPanelLayoutManager r0 = (com.tencent.mm.emoji.panel.layout.EmojiPanelLayoutManager) r0
            if (r0 == 0) goto L_0x0037
            boolean r4 = r6.gZS
            if (r4 == 0) goto L_0x0041
            com.tencent.mm.ui.m.b$a r4 = com.tencent.mm.ui.m.b.QnH
            r4 = r3 & 1
            if (r4 != 0) goto L_0x0032
            r3 = r3 & 2
            if (r3 == 0) goto L_0x003f
        L_0x0032:
            r3 = r1
        L_0x0033:
            if (r3 != 0) goto L_0x0041
        L_0x0035:
            r0.hbX = r1
        L_0x0037:
            boolean r0 = super.dispatchTouchEvent(r7)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            return r0
        L_0x003f:
            r3 = r2
            goto L_0x0033
        L_0x0041:
            r1 = r2
            goto L_0x0035
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.emoji.panel.EmojiPanelGroupView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void setScrollEnable(boolean z) {
        this.gZS = z;
    }
}
