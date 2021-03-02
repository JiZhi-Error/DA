package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.b.ag;
import com.tencent.mm.emoji.b.b.i;
import com.tencent.mm.emoji.b.b.o;
import com.tencent.mm.emoji.b.b.q;
import com.tencent.mm.emoji.debug.EmojiDebugUI;
import com.tencent.mm.emoji.e.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 \u001f2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003\u001f !B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\fJ\b\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fH\u0016J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\fJ\u0014\u0010\u001c\u001a\u00020\u00142\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u001eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder;", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;)V", "mData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/emoji/model/panel/PanelTab;", "onItemClickListener", "Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$OnItemClickListener;", "selectedPosition", "", "getItem", "position", "getItemCount", "getItemId", "", "getItemViewType", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickListener", "setSelection", "update", "data", "", "Companion", "OnItemClickListener", "ViewHolder", "plugin-emojisdk_release"})
public final class ad extends RecyclerView.a<c> {
    public static final String TAG = TAG;
    public static final a hbC = new a((byte) 0);
    private final i gYa;
    public b hbB;
    public final ArrayList<ag> mData = new ArrayList<>();
    private int va = -1;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$OnItemClickListener;", "", "onItemClick", "", "position", "", "itemView", "Landroid/view/View;", "plugin-emojisdk_release"})
    public interface b {
        void b(int i2, View view);
    }

    public ad(i iVar) {
        p.h(iVar, "config");
        AppMethodBeat.i(105702);
        this.gYa = iVar;
        AppMethodBeat.o(105702);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ c a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(105700);
        p.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.btn, viewGroup, false);
        p.g(inflate, "LayoutInflater.from(pare…view_item, parent, false)");
        c cVar = new c(this, inflate);
        AppMethodBeat.o(105700);
        return cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(c cVar, int i2) {
        AppMethodBeat.i(105701);
        c cVar2 = cVar;
        p.h(cVar2, "viewHolder");
        View view = cVar2.aus;
        p.g(view, "viewHolder.itemView");
        Context context = view.getContext();
        p.g(context, "context");
        int color = context.getResources().getColor(e.cG(context));
        View view2 = cVar2.aus;
        p.g(view2, "viewHolder.itemView");
        view2.setSelected(this.va == i2);
        ag pp = pp(i2);
        if (pp == null) {
            cVar2.dKU.setVisibility(8);
            cVar2.dKU.setTag("");
            Log.i(TAG, "emoji group info is null. position:%d", Integer.valueOf(i2));
            AppMethodBeat.o(105701);
            return;
        }
        cVar2.dKU.setVisibility(0);
        cVar2.hbD.setVisibility(8);
        if (pp.type == 1) {
            e.a(cVar2.dKU, R.raw.emoticonstore_manager_icon, color);
            cVar2.dKU.setContentDescription(context.getString(R.string.gof));
            AppMethodBeat.o(105701);
        } else if (pp.type == 2) {
            if (com.tencent.mm.search.a.gxp()) {
                e.a(cVar2.dKU, R.raw.icons_outlined_search, color);
            } else {
                e.a(cVar2.dKU, R.raw.emoticonstore_add_icon, color);
            }
            cVar2.dKU.setContentDescription(context.getString(R.string.bwu));
            if (WeChatEnvironment.hasDebugger() || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
                cVar2.aus.setOnLongClickListener(d.hbF);
            }
            AppMethodBeat.o(105701);
        } else {
            ag pp2 = pp(i2);
            if (pp2 == null) {
                p.hyc();
            }
            EmojiGroupInfo emojiGroupInfo = pp2.gVA;
            q qVar = q.gYK;
            String hYf = emojiGroupInfo.hYf();
            p.g(hYf, "info.productID");
            o ES = q.ES(hYf);
            if (ES != null) {
                ES.a(cVar2.dKU, color, emojiGroupInfo);
                AppMethodBeat.o(105701);
            } else if (p.j(com.tencent.mm.emoji.b.b.ad.avB(), emojiGroupInfo.hYf())) {
                e.a(cVar2.dKU, R.raw.emoticonstore_emoji_icon, color);
                cVar2.dKU.setContentDescription(context.getString(R.string.bwi));
                AppMethodBeat.o(105701);
            } else if (p.j(com.tencent.mm.emoji.b.b.ad.avC(), emojiGroupInfo.hYf())) {
                e.a(cVar2.dKU, R.raw.emoticonstore_custom_icon, color);
                cVar2.dKU.setContentDescription(context.getString(R.string.bwt));
                AppMethodBeat.o(105701);
            } else if (p.j(String.valueOf(EmojiGroupInfo.VkN), emojiGroupInfo.hYf())) {
                cVar2.dKU.setImageResource(R.drawable.bcp);
                cVar2.dKU.setContentDescription(context.getString(R.string.bvz));
                AppMethodBeat.o(105701);
            } else {
                if (p.j(com.tencent.mm.emoji.b.b.ad.avD(), emojiGroupInfo.hYf())) {
                    e.a(cVar2.dKU, R.raw.emoticonstore_capture_icon, color);
                    cVar2.dKU.setContentDescription(context.getString(R.string.bws));
                    com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
                    p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
                    if (((com.tencent.mm.plugin.emoji.b.d) ah).getProvider().cFS() && this.gYa.scene == ChatFooterPanel.KbC) {
                        cVar2.hbD.setVisibility(0);
                        AppMethodBeat.o(105701);
                        return;
                    }
                } else {
                    cVar2.dKU.setLayerPaint(null);
                    com.tencent.mm.emoji.loader.d dVar = com.tencent.mm.emoji.loader.d.gVH;
                    com.tencent.mm.emoji.loader.d.getLoader().bQ(new com.tencent.mm.emoji.loader.a(emojiGroupInfo)).c(cVar2.dKU);
                    if (Util.isNullOrNil(emojiGroupInfo.beq())) {
                        cVar2.dKU.setContentDescription(context.getString(R.string.bvt));
                        AppMethodBeat.o(105701);
                        return;
                    }
                    cVar2.dKU.setContentDescription(emojiGroupInfo.beq());
                }
                AppMethodBeat.o(105701);
            }
        }
    }

    public final void setSelection(int i2) {
        AppMethodBeat.i(105696);
        Log.i(TAG, "setSelection: %s", Integer.valueOf(i2));
        if (this.va != i2) {
            ci(this.va);
            this.va = i2;
            ci(this.va);
        }
        AppMethodBeat.o(105696);
    }

    public final ag pp(int i2) {
        AppMethodBeat.i(105697);
        if (this.mData.isEmpty() || this.mData.size() < i2 || i2 < 0) {
            AppMethodBeat.o(105697);
            return null;
        }
        ag agVar = this.mData.get(i2);
        AppMethodBeat.o(105697);
        return agVar;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final long getItemId(int i2) {
        return (long) i2;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(105698);
        int size = this.mData.size();
        AppMethodBeat.o(105698);
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(105699);
        ag pp = pp(i2);
        if (pp == null) {
            p.hyc();
        }
        int i3 = pp.type;
        AppMethodBeat.o(105699);
        return i3;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class d implements View.OnLongClickListener {
        public static final d hbF = new d();

        static {
            AppMethodBeat.i(105695);
            AppMethodBeat.o(105695);
        }

        d() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(105694);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$onBindViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            p.g(view, "v");
            Intent intent = new Intent(view.getContext(), EmojiDebugUI.class);
            Context context = view.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$onBindViewHolder$1", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$onBindViewHolder$1", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$onBindViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(105694);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter;Landroid/view/View;)V", "dotView", "Landroid/widget/ImageView;", "getDotView", "()Landroid/widget/ImageView;", "setDotView", "(Landroid/widget/ImageView;)V", "imageView", "getImageView", "setImageView", "onClick", "", "v", "plugin-emojisdk_release"})
    public final class c extends RecyclerView.v implements View.OnClickListener {
        ImageView dKU;
        ImageView hbD;
        final /* synthetic */ ad hbE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ad adVar, View view) {
            super(view);
            p.h(view, "view");
            this.hbE = adVar;
            AppMethodBeat.i(105693);
            View findViewById = view.findViewById(R.id.htd);
            p.g(findViewById, "view.findViewById(R.id.smiley_listview_item_view)");
            this.dKU = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.htc);
            p.g(findViewById2, "view.findViewById(R.id.smiley_listview_item_dot)");
            this.hbD = (ImageView) findViewById2;
            view.setOnClickListener(this);
            AppMethodBeat.o(105693);
        }

        public final void onClick(View view) {
            AppMethodBeat.i(105692);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            p.h(view, "v");
            if (this.hbE.hbB != null) {
                b bVar2 = this.hbE.hbB;
                if (bVar2 == null) {
                    p.hyc();
                }
                bVar2.b(lR(), view);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(105692);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/SmileyTabAdapter$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(105703);
        AppMethodBeat.o(105703);
    }
}
