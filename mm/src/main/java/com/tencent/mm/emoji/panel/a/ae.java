package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.u;
import com.tencent.mm.emoji.loader.b;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0015\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000b¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/TitlePanelViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "designer", "Landroid/widget/TextView;", "getDesigner", "()Landroid/widget/TextView;", "designerGroup", "getDesignerGroup", "()Landroid/view/View;", "designerIcon", "Landroid/widget/ImageView;", "getDesignerIcon", "()Landroid/widget/ImageView;", "redDot", "getRedDot", "title", "getTitle", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emojisdk_release"})
public final class ae extends q<u> {
    private final View hbG;
    private final TextView hbH;
    private final ImageView hbI;
    private final View hbJ;
    private final TextView hbb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ae(View view, n nVar) {
        super(view, nVar);
        p.h(view, "itemView");
        AppMethodBeat.i(105705);
        View findViewById = view.findViewById(R.id.c11);
        p.g(findViewById, "itemView.findViewById(R.…ji_panel_title_item_text)");
        this.hbb = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.c0y);
        p.g(findViewById2, "itemView.findViewById(R.…nel_title_designer_group)");
        this.hbG = findViewById2;
        View findViewById3 = view.findViewById(R.id.c0x);
        p.g(findViewById3, "itemView.findViewById(R.…oji_panel_title_designer)");
        this.hbH = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.c0z);
        p.g(findViewById4, "itemView.findViewById(R.…anel_title_designer_icon)");
        this.hbI = (ImageView) findViewById4;
        View findViewById5 = view.findViewById(R.id.c10);
        p.g(findViewById5, "itemView.findViewById(R.…l_title_designer_red_dot)");
        this.hbJ = findViewById5;
        view.setOnClickListener(null);
        this.hbG.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.emoji.panel.a.ae.AnonymousClass1 */
            final /* synthetic */ ae hbK;

            {
                this.hbK = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(183961);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/emoji/panel/adapter/TitlePanelViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                n nVar = this.hbK.hbi;
                if (nVar != null) {
                    p.g(view, LocaleUtil.ITALIAN);
                    Context context = view.getContext();
                    p.g(context, "it.context");
                    nVar.a(view, context, this.hbK.lR(), this.hbK.hbh);
                }
                a.a(this, "com/tencent/mm/emoji/panel/adapter/TitlePanelViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(183961);
            }
        });
        AppMethodBeat.o(105705);
    }

    @Override // com.tencent.mm.emoji.panel.a.q
    public final void a(ac acVar) {
        AppMethodBeat.i(105704);
        p.h(acVar, "item");
        super.a(acVar);
        u uVar = (u) this.hbh;
        if (uVar != null) {
            this.hbb.setText(uVar.gVA.beq());
            PersonalDesigner personalDesigner = uVar.gYM;
            if (personalDesigner != null) {
                this.hbH.setVisibility(0);
                this.hbH.setText(personalDesigner.Name);
                this.hbI.setVisibility(0);
                this.hbI.setImageDrawable(null);
                b.a aVar = com.tencent.mm.emoji.loader.b.gVC;
                String aTd = com.tencent.mm.plugin.emoji.h.b.aTd();
                p.g(aTd, "EmojiUtils.getAccEmojiPath()");
                String hYf = uVar.gVA.hYf();
                p.g(hYf, "it.groupInfo.productID");
                String str = personalDesigner.HeadUrl;
                p.g(str, "designerInfo.HeadUrl");
                com.tencent.mm.av.a.a.bdb().a(personalDesigner.HeadUrl, this.hbI, new c.a().bdo().bdp().OS(b.a.j(aTd, hYf, str)).bdt().bdv());
                if (uVar.gYN) {
                    this.hbJ.setVisibility(0);
                    AppMethodBeat.o(105704);
                    return;
                }
                this.hbJ.setVisibility(8);
                AppMethodBeat.o(105704);
                return;
            }
            this.hbI.setImageDrawable(null);
            this.hbI.setVisibility(8);
            this.hbH.setVisibility(8);
            this.hbJ.setVisibility(8);
            AppMethodBeat.o(105704);
            return;
        }
        AppMethodBeat.o(105704);
    }
}
