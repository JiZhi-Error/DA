package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.m;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016R\u0019\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001a\u001a\n \u000f*\u0004\u0018\u00010\u001b0\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015¨\u0006$"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/SearchEmojiTipsViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EntranceItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "showId", "", "word", "showSearchMore", "", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;IIZ)V", "searchMore", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getSearchMore", "()Landroid/widget/LinearLayout;", "getShowId", "()I", "setShowId", "(I)V", "getShowSearchMore", "()Z", "setShowSearchMore", "(Z)V", "tips", "Landroid/widget/TextView;", "getTips", "()Landroid/widget/TextView;", "getWord", "setWord", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class v extends q<m> {
    private final TextView hbm;
    private final LinearLayout hbn;
    private int hbo = R.id.h5p;
    private int hbp;
    private boolean hbq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(View view, n nVar, int i2, boolean z) {
        super(view, nVar);
        p.h(view, "itemView");
        AppMethodBeat.i(199979);
        this.hbp = i2;
        this.hbq = z;
        this.hbm = (TextView) view.findViewById(this.hbo);
        this.hbn = (LinearLayout) view.findViewById(R.id.hen);
        view.setOnClickListener(null);
        AppMethodBeat.o(199979);
    }

    @Override // com.tencent.mm.emoji.panel.a.q
    public final void a(ac acVar) {
        AppMethodBeat.i(199978);
        p.h(acVar, "item");
        super.a(acVar);
        View view = this.aus;
        if (view == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(199978);
            throw tVar;
        }
        Iterator it = j.mY(0, ((ViewGroup) view).getChildCount()).iterator();
        while (it.hasNext()) {
            View childAt = ((ViewGroup) this.aus).getChildAt(((ab) it).nextInt());
            p.g(childAt, "itemView.getChildAt(it)");
            childAt.setVisibility(8);
        }
        TextView textView = this.hbm;
        p.g(textView, "tips");
        TextView textView2 = this.hbm;
        p.g(textView2, "tips");
        textView.setText(textView2.getContext().getString(this.hbp));
        TextView textView3 = this.hbm;
        p.g(textView3, "tips");
        textView3.setVisibility(0);
        if (this.hbq) {
            LinearLayout linearLayout = this.hbn;
            p.g(linearLayout, "searchMore");
            linearLayout.setVisibility(0);
            this.hbn.setOnClickListener(new a(this));
            AppMethodBeat.o(199978);
            return;
        }
        LinearLayout linearLayout2 = this.hbn;
        p.g(linearLayout2, "searchMore");
        linearLayout2.setVisibility(8);
        AppMethodBeat.o(199978);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ v hbr;

        a(v vVar) {
            this.hbr = vVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(199977);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/adapter/SearchEmojiTipsViewHolder$onBind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            n nVar = this.hbr.hbi;
            if (nVar != null) {
                p.g(view, LocaleUtil.ITALIAN);
                Context context = view.getContext();
                p.g(context, "it.context");
                nVar.a(view, context, this.hbr.lR(), this.hbr.hbh);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/adapter/SearchEmojiTipsViewHolder$onBind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(199977);
        }
    }
}
