package com.tencent.mm.plugin.gamelife.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.ui.b;
import com.tencent.mm.plugin.gamelife.ui.f;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.tools.v;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0017J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J \u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider;", "delegate", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;)V", "onItemClickListener", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;)V", "onLongClickListener", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "getOnLongClickListener", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "setOnLongClickListener", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;)V", "bindHistoryConversation", "", "holder", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "item", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "pos", "", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "reportConversationItem", "actionType", "", "plugin-gamelife_release"})
public final class d extends f {
    b.c ycF;
    b.d ycG;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(f.a aVar) {
        super(aVar);
        p.h(aVar, "delegate");
        AppMethodBeat.i(241469);
        AppMethodBeat.o(241469);
    }

    @Override // com.tencent.mm.plugin.gamelife.ui.f
    public final b.C1424b y(ViewGroup viewGroup) {
        AppMethodBeat.i(241467);
        p.h(viewGroup, "parent");
        View inflate = aa.jQ(viewGroup.getContext()).inflate(R.layout.atb, viewGroup, false);
        p.g(inflate, "MMLayoutInflater.getInfl…rmal_item, parent, false)");
        b.C1424b bVar = new b.C1424b(inflate);
        AppMethodBeat.o(241467);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.gamelife.ui.f
    @SuppressLint({"ResourceType"})
    public final void a(b.C1424b bVar, int i2) {
        SpannableStringBuilder spannableStringBuilder;
        String valueOf;
        Drawable drawable;
        AppMethodBeat.i(241468);
        p.h(bVar, "holder");
        View view = bVar.aus;
        p.g(view, "holder.itemView");
        com.tencent.mm.plugin.gamelife.e.a OD = this.ydp.OD(i2);
        bVar.et(OD);
        view.setBackgroundResource(R.drawable.qa);
        ((TextView) view.findViewById(R.id.bmt)).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        ca aEx = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eiy().aEx(OD.field_sessionId);
        if (aEx != null && aEx.getStatus() == 5) {
            Context context = view.getContext();
            p.g(context, "itemView.context");
            Drawable drawable2 = context.getResources().getDrawable(R.raw.msg_state_failed);
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                drawable = drawable2;
            } else {
                drawable = null;
            }
            ((TextView) view.findViewById(R.id.bmt)).setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        TextView textView = (TextView) view.findViewById(R.id.bmt);
        p.g(textView, "itemView.descTv");
        Context context2 = MMApplicationContext.getContext();
        if ((OD.field_digestFlag & 1) > 0) {
            OD.field_digestPrefix = com.tencent.mm.cb.a.aI(context2, R.string.dth);
            OD.field_digestFlag = 0;
        }
        String str = OD.field_digestPrefix;
        if (str == null || str.length() == 0) {
            SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(context2, OD.field_digest);
            p.g(c2, "MMSpanManager.spanForSmiley(context, field_digest)");
            spannableStringBuilder = c2;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(OD.field_digestPrefix);
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(com.tencent.mm.cb.a.n(context2, R.color.Red)), 0, spannableStringBuilder2.length(), 33);
            spannableStringBuilder2.append((CharSequence) " ").append((CharSequence) com.tencent.mm.pluginsdk.ui.span.l.c(context2, OD.field_digest));
            spannableStringBuilder = spannableStringBuilder2;
        }
        textView.setText(spannableStringBuilder);
        TextView textView2 = (TextView) view.findViewById(R.id.ims);
        p.g(textView2, "itemView.timeTv");
        textView2.setText(String.valueOf(com.tencent.mm.pluginsdk.i.f.c(view.getContext(), OD.field_updateTime, true)));
        TextView textView3 = (TextView) view.findViewById(R.id.io8);
        p.g(textView3, "itemView.tipNomalTv");
        textView3.setVisibility(8);
        TextView textView4 = (TextView) view.findViewById(R.id.io7);
        p.g(textView4, "itemView.tipCountTv");
        textView4.setVisibility(OD.field_unReadCount > 0 ? 0 : 8);
        TextView textView5 = (TextView) view.findViewById(R.id.io7);
        p.g(textView5, "itemView.tipCountTv");
        if (OD.field_unReadCount <= 99) {
            valueOf = String.valueOf(OD.field_unReadCount);
        }
        textView5.setText(valueOf);
        ((TextView) view.findViewById(R.id.io7)).setBackgroundResource(v.aQ(view.getContext(), OD.field_unReadCount));
        if (OD.dXj()) {
            View view2 = bVar.aus;
            TextView textView6 = (TextView) view2.findViewById(R.id.io7);
            p.g(textView6, "tipCountTv");
            textView6.setVisibility(8);
            TextView textView7 = (TextView) view2.findViewById(R.id.io8);
            p.g(textView7, "tipNomalTv");
            textView7.setVisibility((OD.field_unReadCount == Integer.MAX_VALUE || OD.field_unReadCount == 0) ? 8 : 0);
            ((ImageView) view2.findViewById(R.id.wo)).setImageResource(R.drawable.a6m);
            TextView textView8 = (TextView) view2.findViewById(R.id.bfx);
            p.g(textView8, "conversationName");
            textView8.setText(com.tencent.mm.cb.a.aI(view2.getContext(), R.string.dtl));
            view2.setOnClickListener(new a(view2, this, OD, i2, bVar));
            view2.setOnLongClickListener(new b(view2, this, OD, i2, bVar));
            AppMethodBeat.o(241468);
            return;
        }
        view.setOnClickListener(new c(view, this, OD, i2, bVar));
        view.setOnLongClickListener(new View$OnLongClickListenerC1426d(view, this, OD, i2, bVar));
        TextView textView9 = (TextView) view.findViewById(R.id.bfx);
        p.g(textView9, "conversationName");
        textView9.setText(OD.tyr);
        com.tencent.mm.ui.g.a.a.c((ImageView) view.findViewById(R.id.wo), OD.field_sessionId);
        AppMethodBeat.o(241468);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$2$1"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ View tCl;
        final /* synthetic */ int uBS;
        final /* synthetic */ d ycT;
        final /* synthetic */ com.tencent.mm.plugin.gamelife.e.a ycU;
        final /* synthetic */ b.C1424b ycV;

        c(View view, d dVar, com.tencent.mm.plugin.gamelife.e.a aVar, int i2, b.C1424b bVar) {
            this.tCl = view;
            this.ycT = dVar;
            this.ycU = aVar;
            this.uBS = i2;
            this.ycV = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(241465);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            d.a(this.ycT, this.ycU, 2, this.uBS);
            com.tencent.mm.plugin.gamelife.e.a aVar = (com.tencent.mm.plugin.gamelife.e.a) this.ycV.hgv();
            b.c cVar = this.ycT.ycF;
            if (cVar != null) {
                View view2 = this.tCl;
                p.g(aVar, "conversation");
                cVar.a(view2, aVar);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241465);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$2$2"})
    /* renamed from: com.tencent.mm.plugin.gamelife.ui.d$d  reason: collision with other inner class name */
    static final class View$OnLongClickListenerC1426d implements View.OnLongClickListener {
        final /* synthetic */ View tCl;
        final /* synthetic */ int uBS;
        final /* synthetic */ d ycT;
        final /* synthetic */ com.tencent.mm.plugin.gamelife.e.a ycU;
        final /* synthetic */ b.C1424b ycV;

        View$OnLongClickListenerC1426d(View view, d dVar, com.tencent.mm.plugin.gamelife.e.a aVar, int i2, b.C1424b bVar) {
            this.tCl = view;
            this.ycT = dVar;
            this.ycU = aVar;
            this.uBS = i2;
            this.ycV = bVar;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(241466);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$$inlined$apply$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            d.a(this.ycT, this.ycU, 72, this.uBS);
            com.tencent.mm.plugin.gamelife.e.a aVar = (com.tencent.mm.plugin.gamelife.e.a) this.ycV.hgv();
            b.d dVar = this.ycT.ycG;
            if (dVar != null) {
                View view2 = this.tCl;
                int i2 = this.uBS;
                p.g(aVar, "conversation");
                dVar.a(view2, i2, aVar, this.ycT.ydp.dXo());
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$onBindViewHolder$$inlined$apply$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(241466);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$1$1"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ View tCl;
        final /* synthetic */ int uBS;
        final /* synthetic */ d ycT;
        final /* synthetic */ com.tencent.mm.plugin.gamelife.e.a ycU;
        final /* synthetic */ b.C1424b ycV;

        a(View view, d dVar, com.tencent.mm.plugin.gamelife.e.a aVar, int i2, b.C1424b bVar) {
            this.tCl = view;
            this.ycT = dVar;
            this.ycU = aVar;
            this.uBS = i2;
            this.ycV = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(241463);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.ycU.field_unReadCount != Integer.MAX_VALUE) {
                this.ycU.field_unReadCount = Integer.MAX_VALUE;
                ((PluginGameLife) g.ah(PluginGameLife.class)).getConversationStorage().update(this.ycU.systemRowid, this.ycU, false);
                ((PluginGameLife) g.ah(PluginGameLife.class)).getConversationStorage().doNotify(MStorageEventData.EventType.SINGLE, 4, this.ycU);
            }
            d.a(this.ycT, this.ycU, 7, this.uBS);
            ((com.tencent.mm.plugin.game.api.c) g.af(com.tencent.mm.plugin.game.api.c.class)).fV(this.tCl.getContext());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241463);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$1$2"})
    static final class b implements View.OnLongClickListener {
        final /* synthetic */ View tCl;
        final /* synthetic */ int uBS;
        final /* synthetic */ d ycT;
        final /* synthetic */ com.tencent.mm.plugin.gamelife.e.a ycU;
        final /* synthetic */ b.C1424b ycV;

        b(View view, d dVar, com.tencent.mm.plugin.gamelife.e.a aVar, int i2, b.C1424b bVar) {
            this.tCl = view;
            this.ycT = dVar;
            this.ycU = aVar;
            this.uBS = i2;
            this.ycV = bVar;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(241464);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$$inlined$apply$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            d.a(this.ycT, this.ycU, 72, this.uBS);
            com.tencent.mm.plugin.gamelife.e.a aVar = (com.tencent.mm.plugin.gamelife.e.a) this.ycV.hgv();
            b.d dVar = this.ycT.ycG;
            if (dVar != null) {
                View view2 = this.tCl;
                p.g(view2, "this");
                int i2 = this.uBS;
                p.g(aVar, "conversation");
                dVar.a(view2, i2, aVar, this.ycT.ydp.dXo());
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider$bindHistoryConversation$$inlined$apply$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(241464);
            return true;
        }
    }

    public static final /* synthetic */ void a(d dVar, com.tencent.mm.plugin.gamelife.e.a aVar, long j2, int i2) {
        AppMethodBeat.i(241470);
        String str = null;
        if (j2 == 72) {
            str = "2";
        }
        if (!aVar.dXj()) {
            com.tencent.mm.plugin.gamelife.a.a aAR = ((com.tencent.mm.plugin.gamelife.a.b) g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAR(aVar.field_selfUserName);
            if (aAR != null) {
                c.a aVar2 = com.tencent.mm.game.report.c.hhl;
                int i3 = (i2 - 2) + 1;
                int dXo = dVar.ydp.dXo();
                String str2 = aVar.field_sessionId;
                p.g(str2, "item.field_sessionId");
                long dWY = (long) aAR.dWY();
                String str3 = aVar.field_selfUserName;
                p.g(str3, "item.field_selfUserName");
                com.tencent.mm.plugin.gamelife.d.a aVar3 = aVar.ybV;
                if (aVar3 == null) {
                    p.hyc();
                }
                long j3 = (long) aVar3.field_accountType;
                String str4 = aVar.field_talker;
                p.g(str4, "item.field_talker");
                long dXi = aVar.dXi();
                com.tencent.mm.plugin.gamelife.i.a aVar4 = com.tencent.mm.plugin.gamelife.i.a.ycs;
                c.a.a(i3, j2, dXo, str2, dWY, str3, j3, str4, dXi, com.tencent.mm.plugin.gamelife.i.a.dXm(), str);
                AppMethodBeat.o(241470);
                return;
            }
            AppMethodBeat.o(241470);
            return;
        }
        c.a aVar5 = com.tencent.mm.game.report.c.hhl;
        int dXo2 = dVar.ydp.dXo();
        String str5 = aVar.field_sessionId;
        p.g(str5, "item.field_sessionId");
        long dXi2 = aVar.dXi();
        com.tencent.mm.plugin.gamelife.i.a aVar6 = com.tencent.mm.plugin.gamelife.i.a.ycs;
        c.a.a((i2 - 2) + 1, j2, dXo2, str5, 0, "", 0, "", dXi2, com.tencent.mm.plugin.gamelife.i.a.dXm(), str);
        AppMethodBeat.o(241470);
    }
}
