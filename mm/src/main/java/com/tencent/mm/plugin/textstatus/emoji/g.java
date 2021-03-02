package com.tencent.mm.plugin.textstatus.emoji;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.textstatus.g.ac;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiGridViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;)V", "emojiData", "Lcom/tencent/mm/plugin/textstatus/proto/WxImeEmojiData;", "emojiTv", "Landroid/widget/TextView;", "mListener", "rootView", "Landroid/widget/RelativeLayout;", "fillContent", "", "onClick", "v", "plugin-textstatus_release"})
public final class g extends RecyclerView.v implements View.OnClickListener {
    private final a VcF;
    TextView VcW;
    ac VcX;
    private RelativeLayout zWu;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(View view, a aVar) {
        super(view);
        p.h(view, "itemView");
        AppMethodBeat.i(258339);
        View findViewById = view.findViewById(R.id.h8v);
        p.g(findViewById, "itemView.findViewById(R.id.root)");
        this.zWu = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.jup);
        p.g(findViewById2, "itemView.findViewById(R.id.emoji_text)");
        this.VcW = (TextView) findViewById2;
        this.VcF = aVar;
        this.zWu.setOnClickListener(this);
        AppMethodBeat.o(258339);
    }

    public final void onClick(View view) {
        String str;
        AppMethodBeat.i(258338);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/textstatus/emoji/ImeEmojiGridViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        StringBuilder sb = new StringBuilder("onClick ");
        ac acVar = this.VcX;
        Log.d("WxIme.ImeEmojiGridAdapter", sb.append(acVar != null ? acVar.Vez : null).toString());
        a aVar = this.VcF;
        if (aVar != null) {
            ac acVar2 = this.VcX;
            if (acVar2 == null || (str = acVar2.content) == null) {
                str = "";
            }
            aVar.byp(str);
        }
        a.a(this, "com/tencent/mm/plugin/textstatus/emoji/ImeEmojiGridViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(258338);
    }
}
