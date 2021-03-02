package com.tencent.mm.emoji.panel.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/EmojiLoadingPanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelViewHolder;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "captureStatusFailureView", "getCaptureStatusFailureView", "()Landroid/view/View;", "captureStatusLayout", "getCaptureStatusLayout", "captureStatusLoadingView", "getCaptureStatusLoadingView", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class b extends k {
    private final View haA;
    private final View haB;
    private final View haz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view, n nVar) {
        super(view, nVar);
        p.h(view, "itemView");
        AppMethodBeat.i(105630);
        View findViewById = view.findViewById(R.id.bza);
        p.g(findViewById, "itemView.findViewById(R.…ji_capture_status_layout)");
        this.haz = findViewById;
        View findViewById2 = view.findViewById(R.id.bz9);
        p.g(findViewById2, "itemView.findViewById(R.…oji_capture_loading_view)");
        this.haA = findViewById2;
        View findViewById3 = view.findViewById(R.id.bz5);
        p.g(findViewById3, "itemView.findViewById(R.…oji_capture_failure_view)");
        this.haB = findViewById3;
        AppMethodBeat.o(105630);
    }

    @Override // com.tencent.mm.emoji.panel.a.k, com.tencent.mm.emoji.panel.a.q
    public final void a(ac acVar) {
        AppMethodBeat.i(105629);
        p.h(acVar, "item");
        super.a(acVar);
        h hVar = (h) this.hbh;
        if (hVar != null) {
            EmojiInfo.a hYs = hVar.gWm.hYs();
            if (hYs != null) {
                switch (c.$EnumSwitchMapping$0[hYs.ordinal()]) {
                    case 1:
                        break;
                    case 2:
                    case 3:
                        this.haz.setVisibility(0);
                        this.haA.setVisibility(0);
                        this.haB.setVisibility(8);
                        AppMethodBeat.o(105629);
                        return;
                    case 4:
                    case 5:
                        this.haz.setVisibility(0);
                        this.haA.setVisibility(8);
                        this.haB.setVisibility(0);
                        AppMethodBeat.o(105629);
                        return;
                    default:
                        AppMethodBeat.o(105629);
                        return;
                }
            }
            this.haz.setVisibility(8);
            AppMethodBeat.o(105629);
            return;
        }
        AppMethodBeat.o(105629);
    }
}
