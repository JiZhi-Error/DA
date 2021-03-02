package com.tencent.mm.plugin.gamelife.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.api.c;
import com.tencent.mm.plugin.gamelife.ui.b;
import com.tencent.mm.plugin.gamelife.ui.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0006\u0010\u0015\u001a\u00020\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/ui/GameServiceNotifyMsgViewProvider;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider;", "delegate", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;)V", "isFirst", "", "viewHolder", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "getExtInfo", "", "unreadCount", "", "(Ljava/lang/Integer;)Ljava/lang/String;", "onBindViewHolder", "", "holder", "pos", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "refreshView", "plugin-gamelife_release"})
public final class g extends f {
    private boolean isFirst = true;
    b.C1424b ycy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(f.a aVar) {
        super(aVar);
        p.h(aVar, "delegate");
        AppMethodBeat.i(241532);
        AppMethodBeat.o(241532);
    }

    @Override // com.tencent.mm.plugin.gamelife.ui.f
    public final b.C1424b y(ViewGroup viewGroup) {
        AppMethodBeat.i(241529);
        p.h(viewGroup, "parent");
        View inflate = aa.jQ(viewGroup.getContext()).inflate(R.layout.atb, viewGroup, false);
        p.g(inflate, "MMLayoutInflater.getInfl…rmal_item, parent, false)");
        this.ycy = new b.C1424b(inflate);
        b.C1424b bVar = this.ycy;
        if (bVar == null) {
            p.hyc();
        }
        AppMethodBeat.o(241529);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.gamelife.ui.f
    public final void a(b.C1424b bVar, int i2) {
        AppMethodBeat.i(241530);
        p.h(bVar, "holder");
        View view = bVar.aus;
        p.g(view, "holder.itemView");
        View view2 = bVar.aus;
        view2.setOnClickListener(new a(view2, this));
        if (ao.isDarkMode()) {
            ((ImageView) view.findViewById(R.id.wo)).setImageResource(R.raw.ic_filled_bell_dark);
        } else {
            ((ImageView) view.findViewById(R.id.wo)).setImageResource(R.raw.ic_filled_bell);
        }
        view.setBackgroundResource(R.drawable.qa);
        ((TextView) view.findViewById(R.id.bfx)).setText(R.string.dtr);
        TextView textView = (TextView) view.findViewById(R.id.bmt);
        p.g(textView, "itemView.descTv");
        textView.setVisibility(0);
        TextView textView2 = (TextView) view.findViewById(R.id.ims);
        p.g(textView2, "itemView.timeTv");
        textView2.setVisibility(8);
        TextView textView3 = (TextView) view.findViewById(R.id.io7);
        p.g(textView3, "itemView.tipCountTv");
        textView3.setVisibility(8);
        TextView textView4 = (TextView) view.findViewById(R.id.io8);
        p.g(textView4, "itemView.tipNomalTv");
        textView4.setVisibility(8);
        WeImageView weImageView = (WeImageView) view.findViewById(R.id.h6m);
        p.g(weImageView, "itemView.rightArrow");
        weImageView.setVisibility(0);
        View findViewById = view.findViewById(R.id.bsb);
        p.g(findViewById, "itemView.divider_2px");
        findViewById.setVisibility(8);
        View findViewById2 = view.findViewById(R.id.bsc);
        p.g(findViewById2, "itemView.divider_8dp");
        findViewById2.setVisibility(0);
        int NY = ((c) com.tencent.mm.kernel.g.af(c.class)).NY(2);
        View view3 = bVar.aus;
        p.g(view3, "holder.itemView");
        view3.setTag(Integer.valueOf(NY));
        if (NY > 0) {
            TextView textView5 = (TextView) view.findViewById(R.id.io8);
            p.g(textView5, "itemView.tipNomalTv");
            textView5.setVisibility(0);
        }
        TextView textView6 = (TextView) view.findViewById(R.id.bmt);
        p.g(textView6, "itemView.descTv");
        textView6.setText(((c) com.tencent.mm.kernel.g.af(c.class)).NZ(2));
        if (this.isFirst) {
            this.isFirst = false;
            Context context = MMApplicationContext.getContext();
            com.tencent.mm.plugin.gamelife.i.a aVar = com.tencent.mm.plugin.gamelife.i.a.ycs;
            com.tencent.mm.game.report.f.a(context, 21, 2101, 2, 1, (int) com.tencent.mm.plugin.gamelife.i.a.dXm(), k(Integer.valueOf(NY)));
        }
        AppMethodBeat.o(241530);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/gamelife/ui/GameServiceNotifyMsgViewProvider$onBindViewHolder$1$1"})
    public static final class a implements View.OnClickListener {
        final /* synthetic */ View tCl;
        final /* synthetic */ g yds;

        a(View view, g gVar) {
            this.tCl = view;
            this.yds = gVar;
        }

        public final void onClick(View view) {
            Integer num;
            AppMethodBeat.i(241528);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameServiceNotifyMsgViewProvider$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            intent.putExtra("game_msg_center_tab_type", 2);
            com.tencent.mm.br.c.b(this.tCl.getContext(), "game", ".ui.message.GameMsgCenterUI", intent);
            p.g(view, "view");
            Object tag = view.getTag();
            if (tag == null) {
                num = null;
            } else if (tag instanceof Integer) {
                num = Integer.valueOf(((Number) tag).intValue());
            } else {
                num = 0;
            }
            Context context = MMApplicationContext.getContext();
            com.tencent.mm.plugin.gamelife.i.a aVar = com.tencent.mm.plugin.gamelife.i.a.ycs;
            com.tencent.mm.game.report.f.a(context, 21, 2101, 2, 6, (int) com.tencent.mm.plugin.gamelife.i.a.dXm(), g.k(num));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameServiceNotifyMsgViewProvider$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241528);
        }
    }

    public static String k(Integer num) {
        AppMethodBeat.i(241531);
        int intValue = num != null ? num.intValue() : 0;
        HashMap hashMap = new HashMap();
        if (intValue > 0) {
            hashMap.put("RedDot", "1");
        } else {
            hashMap.put("RedDot", "2");
        }
        hashMap.put("TotalNum", String.valueOf(intValue));
        String t = com.tencent.mm.game.report.f.t(hashMap);
        p.g(t, "Report_12909.genExtInfo(map)");
        AppMethodBeat.o(241531);
        return t;
    }
}
