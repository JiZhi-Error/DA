package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.b.aa;
import com.tencent.mm.emoji.b.b.ab;
import com.tencent.mm.emoji.b.b.ad;
import com.tencent.mm.emoji.b.b.af;
import com.tencent.mm.emoji.b.b.ak;
import com.tencent.mm.emoji.b.b.am;
import com.tencent.mm.emoji.b.b.f;
import com.tencent.mm.emoji.b.b.i;
import com.tencent.mm.emoji.b.b.w;
import com.tencent.mm.emoji.panel.EmojiPanelRecyclerView;
import com.tencent.mm.emoji.panel.SmileyPanelView;
import com.tencent.mm.emoji.panel.a.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 62\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u00045678B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0016J\u001c\u0010)\u001a\u00020*2\n\u0010+\u001a\u00060\u0002R\u00020\u00002\u0006\u0010(\u001a\u00020&H\u0016J\u001c\u0010,\u001a\u00060\u0002R\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020&H\u0016J\u0014\u00100\u001a\u00020*2\n\u0010+\u001a\u00060\u0002R\u00020\u0000H\u0016J&\u00101\u001a\u00020*2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u0017032\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a03R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018X\u0004¢\u0006\u0002\n\u0000R&\u0010\u0019\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a0\u0016j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a`\u0018X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00069"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "lifeCycle", "Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "smileyItemSize", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "emojiItemSize", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;)V", "TAG", "", "clickListener", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "getClickListener", "()Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "setClickListener", "(Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getConfig", "()Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "groupList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "Lkotlin/collections/ArrayList;", "groupModelList", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "getLifeCycle", "()Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "pool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "textOperationListener", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "getTextOperationListener", "()Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "setTextOperationListener", "(Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "updateData", "groups", "", "models", "AbsPanelGroupViewHolder", "Companion", "EmojiPanelGroupViewHolder", "SmileyPanelGroupViewHolder", "plugin-emojisdk_release"})
public final class g extends RecyclerView.a<a> {
    public static final b haO = new b((byte) 0);
    private final String TAG = "MicroMsg.EmojiPanelGroupAdapter";
    final i gYa;
    public final ArrayList<EmojiGroupInfo> haH = new ArrayList<>();
    public final ArrayList<ab<?>> haI = new ArrayList<>();
    private final RecyclerView.m haJ = new RecyclerView.m();
    public n haK;
    final af haL;
    private final o haM;
    private final o haN;
    public ChatFooterPanel.a har;

    static {
        AppMethodBeat.i(105649);
        AppMethodBeat.o(105649);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        c cVar;
        AppMethodBeat.i(105644);
        p.h(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i2 == 1) {
            View inflate = from.inflate(R.layout.a21, viewGroup, false);
            p.g(inflate, "itemView");
            cVar = new d(this, inflate);
        } else {
            View inflate2 = from.inflate(R.layout.a20, viewGroup, false);
            p.g(inflate2, "itemView");
            cVar = new c(this, inflate2);
        }
        RecyclerView.v vVar = cVar;
        AppMethodBeat.o(105644);
        return vVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(105647);
        a aVar2 = aVar;
        p.h(aVar2, "holder");
        super.a(aVar2);
        aVar2.avR();
        AppMethodBeat.o(105647);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(105646);
        a aVar2 = aVar;
        p.h(aVar2, "holder");
        ab<?> abVar = this.haI.get(i2);
        p.g(abVar, "groupModelList[position]");
        aVar2.a(abVar);
        AppMethodBeat.o(105646);
    }

    public g(i iVar, af afVar, o oVar, o oVar2) {
        p.h(iVar, "config");
        p.h(afVar, "lifeCycle");
        p.h(oVar, "smileyItemSize");
        p.h(oVar2, "emojiItemSize");
        AppMethodBeat.i(199967);
        this.gYa = iVar;
        this.haL = afVar;
        this.haM = oVar;
        this.haN = oVar2;
        this.haJ.aw(0, 50);
        this.haJ.aw(1, 30);
        this.haJ.aw(2, 3);
        this.haJ.aw(3, 1);
        this.haJ.aw(4, 2);
        this.haJ.aw(5, 3);
        AppMethodBeat.o(199967);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$Companion;", "", "()V", "ViewTypeEmoji", "", "ViewTypeSmiley", "plugin-emojisdk_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(105643);
        EmojiGroupInfo emojiGroupInfo = this.haH.get(i2);
        p.g(emojiGroupInfo, "groupList[position]");
        if (p.j(emojiGroupInfo.hYf(), ad.avB())) {
            AppMethodBeat.o(105643);
            return 1;
        }
        AppMethodBeat.o(105643);
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(105645);
        int size = this.haH.size();
        AppMethodBeat.o(105645);
        return size;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b¦\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010#\u001a\u00020$2\n\u0010%\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0016J\b\u0010&\u001a\u00020$H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006'"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "sizeResolver", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "layoutManager", "Landroid/support/v7/widget/GridLayoutManager;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;Landroid/support/v7/widget/GridLayoutManager;)V", "adapter", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "getAdapter", "()Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "getLayoutManager", "()Landroid/support/v7/widget/GridLayoutManager;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter$ListenerToAdapter;", "getListener", "()Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter$ListenerToAdapter;", "model", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "getModel", "()Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "setModel", "(Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;)V", "recycler", "Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "getRecycler", "()Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "sizeLookup", "Lcom/tencent/mm/emoji/panel/adapter/PanelSpanSizeLookup;", "getSizeLookup", "()Lcom/tencent/mm/emoji/panel/adapter/PanelSpanSizeLookup;", "getSizeResolver", "()Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "onBind", "", "groupModel", "onUnbind", "plugin-emojisdk_release"})
    public abstract class a extends RecyclerView.v {
        private final EmojiPanelRecyclerView haP;
        private final h haQ = new h();
        private final h.a haR = new h.a(this.haQ);
        private final p haS = new p(this.haQ, this.haU);
        private ab<?> haT;
        private final GridLayoutManager haU;
        final /* synthetic */ g haV;
        private final o hah;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(g gVar, View view, o oVar, GridLayoutManager gridLayoutManager) {
            super(view);
            p.h(view, "itemView");
            p.h(oVar, "sizeResolver");
            p.h(gridLayoutManager, "layoutManager");
            this.haV = gVar;
            this.hah = oVar;
            this.haU = gridLayoutManager;
            View findViewById = view.findViewById(R.id.c0p);
            p.g(findViewById, "itemView.findViewById(R.…oji_panel_group_recycler)");
            this.haP = (EmojiPanelRecyclerView) findViewById;
            this.haP.setRecycledViewPool(gVar.haJ);
            this.haP.setHasFixedSize(true);
            this.haP.setAdapter(this.haQ);
            this.haP.setSizeResolver(this.hah);
            this.haP.setPanelLifeCycle(gVar.haL);
            this.haP.b(new i(this.hah));
            this.haU.a(this.haS);
            this.haP.setLayoutManager(this.haU);
            this.haP.setFocusable(false);
            this.haP.setItemAnimator(null);
            this.haQ.haK = gVar.haK;
        }

        public void a(ab<?> abVar) {
            int i2;
            p.h(abVar, "groupModel");
            Log.i(this.haV.TAG, "onBind: " + abVar.avp().avm().hYf() + ' ' + abVar.avp().avn().size());
            this.haU.bW(this.hah.att);
            this.haQ.ad(abVar.avp().avn());
            this.haQ.notifyDataSetChanged();
            if (!p.j(this.haT, abVar)) {
                ab<?> abVar2 = this.haT;
                if (abVar2 != null) {
                    abVar2.a((aa) null);
                }
                this.haT = abVar;
            }
            ab<?> abVar3 = this.haT;
            if (abVar3 != null) {
                abVar3.a((aa) this.haR);
            }
            EmojiPanelRecyclerView emojiPanelRecyclerView = this.haP;
            p.h(abVar, "groupModel");
            if (abVar instanceof ak) {
                Context context = emojiPanelRecyclerView.getContext();
                p.g(context, "context");
                emojiPanelRecyclerView.haf = new com.tencent.mm.view.popview.d(context);
                return;
            }
            if (abVar instanceof f) {
                i2 = 0;
            } else if (abVar instanceof com.tencent.mm.emoji.b.b.d) {
                i2 = 1;
            } else if (abVar instanceof am) {
                i2 = 2;
            } else {
                i2 = -1;
            }
            emojiPanelRecyclerView.setEmojiPopupType(i2);
        }

        public void avR() {
            String str;
            w avp;
            EmojiGroupInfo avm;
            String str2 = this.haV.TAG;
            StringBuilder sb = new StringBuilder("onUnbind: ");
            ab<?> abVar = this.haT;
            if (abVar == null || (avp = abVar.avp()) == null || (avm = avp.avm()) == null) {
                str = null;
            } else {
                str = avm.hYf();
            }
            Log.i(str2, sb.append(str).toString());
            ab<?> abVar2 = this.haT;
            if (abVar2 != null) {
                abVar2.a((aa) null);
            }
            this.haT = null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$EmojiPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;Landroid/view/View;)V", "plugin-emojisdk_release"})
    public final class c extends a {
        final /* synthetic */ g haV;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public c(com.tencent.mm.emoji.panel.a.g r5, android.view.View r6) {
            /*
                r4 = this;
                r3 = 105639(0x19ca7, float:1.48032E-40)
                java.lang.String r0 = "itemView"
                kotlin.g.b.p.h(r6, r0)
                r4.haV = r5
                com.tencent.mm.emoji.panel.a.o r0 = com.tencent.mm.emoji.panel.a.g.c(r5)
                android.support.v7.widget.GridLayoutManager r1 = new android.support.v7.widget.GridLayoutManager
                r6.getContext()
                com.tencent.mm.emoji.panel.a.o r2 = com.tencent.mm.emoji.panel.a.g.c(r5)
                int r2 = r2.att
                r1.<init>(r2)
                r4.<init>(r5, r6, r0, r1)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.emoji.panel.a.g.c.<init>(com.tencent.mm.emoji.panel.a.g, android.view.View):void");
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0014\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$SmileyPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter$AbsPanelGroupViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelGroupAdapter;Landroid/view/View;)V", "smileyView", "Lcom/tencent/mm/emoji/panel/SmileyPanelView;", "getSmileyView", "()Lcom/tencent/mm/emoji/panel/SmileyPanelView;", "onBind", "", "groupModel", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "onUnbind", "plugin-emojisdk_release"})
    public final class d extends a {
        final /* synthetic */ g haV;
        private final SmileyPanelView haW;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public d(com.tencent.mm.emoji.panel.a.g r6, android.view.View r7) {
            /*
                r5 = this;
                r4 = 105642(0x19caa, float:1.48036E-40)
                java.lang.String r0 = "itemView"
                kotlin.g.b.p.h(r7, r0)
                r5.haV = r6
                com.tencent.mm.emoji.panel.a.o r1 = com.tencent.mm.emoji.panel.a.g.d(r6)
                com.tencent.mm.emoji.panel.layout.SmileyLayoutManager r0 = new com.tencent.mm.emoji.panel.layout.SmileyLayoutManager
                android.content.Context r2 = r7.getContext()
                java.lang.String r3 = "itemView.context"
                kotlin.g.b.p.g(r2, r3)
                com.tencent.mm.emoji.panel.a.o r3 = com.tencent.mm.emoji.panel.a.g.d(r6)
                int r3 = r3.att
                r0.<init>(r2, r3)
                android.support.v7.widget.GridLayoutManager r0 = (android.support.v7.widget.GridLayoutManager) r0
                r5.<init>(r6, r7, r1, r0)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                r0 = 2131300017(0x7f090eb1, float:1.8218052E38)
                android.view.View r0 = r7.findViewById(r0)
                java.lang.String r1 = "itemView.findViewById(R.…_panel_smiley_panel_view)"
                kotlin.g.b.p.g(r0, r1)
                com.tencent.mm.emoji.panel.SmileyPanelView r0 = (com.tencent.mm.emoji.panel.SmileyPanelView) r0
                r5.haW = r0
                com.tencent.mm.emoji.panel.SmileyPanelView r0 = r5.haW
                com.tencent.mm.pluginsdk.ui.ChatFooterPanel$a r1 = r6.har
                r0.setTextOperationListener(r1)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.emoji.panel.a.g.d.<init>(com.tencent.mm.emoji.panel.a.g, android.view.View):void");
        }

        @Override // com.tencent.mm.emoji.panel.a.g.a
        public final void a(ab<?> abVar) {
            AppMethodBeat.i(105640);
            p.h(abVar, "groupModel");
            super.a(abVar);
            SmileyPanelView smileyPanelView = this.haW;
            i iVar = this.haV.gYa;
            p.h(iVar, "config");
            i iVar2 = smileyPanelView.gYa;
            if (iVar2 != null) {
                iVar2.g(smileyPanelView.hap);
            }
            smileyPanelView.gYa = iVar;
            i iVar3 = smileyPanelView.gYa;
            if (iVar3 != null) {
                kotlin.g.a.a<x> aVar = smileyPanelView.hap;
                p.h(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
                iVar3.gYq.add(aVar);
            }
            smileyPanelView.hap.invoke();
            AppMethodBeat.o(105640);
        }

        @Override // com.tencent.mm.emoji.panel.a.g.a
        public final void avR() {
            AppMethodBeat.i(105641);
            super.avR();
            SmileyPanelView smileyPanelView = this.haW;
            i iVar = smileyPanelView.gYa;
            if (iVar != null) {
                iVar.g(smileyPanelView.hap);
                AppMethodBeat.o(105641);
                return;
            }
            AppMethodBeat.o(105641);
        }
    }
}
