package com.tencent.mm.plugin.story.ui.a;

import android.content.Context;
import android.content.Intent;
import android.support.v7.h.c;
import android.support.v7.h.d;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.ui.view.CommentAvatarImageView;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.at;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001bB\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0014\u0010\u0018\u001a\u00020\u00112\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aR\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f`\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$BubbleViewHolder;", "bubbleDatas", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "TAG", "", "hasStoryStateMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateBubbles", "newBubbles", "", "BubbleViewHolder", "plugin-story_release"})
public final class l extends RecyclerView.a<a> {
    private final HashMap<String, Boolean> FxX = new HashMap<>();
    private final ArrayList<com.tencent.mm.plugin.story.f.b.a> Fyu;
    private final String TAG = "MicroMsg.StoryVisitorListAdapter";

    public l(ArrayList<com.tencent.mm.plugin.story.f.b.a> arrayList) {
        p.h(arrayList, "bubbleDatas");
        AppMethodBeat.i(119803);
        this.Fyu = arrayList;
        AppMethodBeat.o(119803);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(119799);
        p.h(viewGroup, "parent");
        this.Fyu.clone();
        View inflate = View.inflate(viewGroup.getContext(), R.layout.c0k, null);
        p.g(inflate, "View.inflate(parent.cont…bubble_item_layout, null)");
        a aVar = new a(this, inflate);
        AppMethodBeat.o(119799);
        return aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar, int i2) {
        String arJ;
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(119801);
        a aVar2 = aVar;
        p.h(aVar2, "holder");
        com.tencent.mm.plugin.story.f.b.a aVar3 = this.Fyu.get(i2);
        p.g(aVar3, "bubbleDatas[position]");
        com.tencent.mm.plugin.story.f.b.a aVar4 = aVar3;
        p.h(aVar4, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
        a.b.d(aVar2.FxS, aVar4.dRL);
        if (aVar4.FnW) {
            CommentAvatarImageView commentAvatarImageView = aVar2.FxS;
            Context context = aVar2.FxS.getContext();
            p.g(context, "avatar.context");
            commentAvatarImageView.setBackground(context.getResources().getDrawable(R.drawable.axs));
            aVar2.FxS.setPadding(aVar2.Fya, aVar2.Fya, aVar2.Fya, aVar2.Fya);
            CommentAvatarImageView commentAvatarImageView2 = aVar2.FxS;
            Context context2 = aVar2.FxS.getContext();
            p.g(context2, "avatar.context");
            commentAvatarImageView2.setHintBg(context2.getResources().getColor(R.color.a_l));
        } else {
            aVar2.FxS.setBackground(null);
            aVar2.FxS.setPadding(0, 0, 0, 0);
            aVar2.FxS.setHintBg(0);
        }
        HashMap<String, Boolean> hashMap = aVar2.Fyv.FxX;
        String str = aVar4.dRL;
        j.b bVar = j.Fmy;
        if (!Util.isEqual(j.b.fau(), aVar4.dRL)) {
            j.b bVar2 = j.Fmy;
            f aSw = j.b.fod().aSw(aVar4.dRL);
            if (aSw != null) {
                z = aSw.frA();
            } else {
                z = false;
            }
            if (z) {
                z2 = true;
            }
        }
        hashMap.put(str, Boolean.valueOf(z2));
        CommentAvatarImageView commentAvatarImageView3 = aVar2.FxS;
        Boolean bool = aVar2.Fyv.FxX.get(aVar4.dRL);
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        commentAvatarImageView3.setShowStoryHint(bool.booleanValue());
        aVar2.FxS.aSD(aVar4.dRL);
        aVar2.FxS.setOnClickListener(new a.View$OnClickListenerC1777a(aVar2, aVar4));
        p.h(aVar4, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(aVar4.dRL);
        aVar2.Fxb.setText(com.tencent.mm.pluginsdk.ui.span.l.b(aVar2.Fxb.getContext(), (Kn == null || (arJ = Kn.arJ()) == null) ? "" : arJ, aVar2.Fxb.getTextSize()));
        AppMethodBeat.o(119801);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(119800);
        int size = this.Fyu.size();
        AppMethodBeat.o(119800);
        return size;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0075 A[EDGE_INSN: B:19:0x0075->B:12:0x0075 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void hx(java.util.List<com.tencent.mm.plugin.story.f.b.a> r9) {
        /*
        // Method dump skipped, instructions count: 175
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.ui.a.l.hx(java.util.List):void");
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$updateBubbles$result$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-story_release"})
    public static final class c extends c.a {
        final /* synthetic */ l Fyv;
        final /* synthetic */ List Fyx;

        c(l lVar, List list) {
            this.Fyv = lVar;
            this.Fyx = list;
        }

        @Override // android.support.v7.h.c.a
        public final int aB() {
            AppMethodBeat.i(119795);
            int size = this.Fyv.Fyu.size();
            AppMethodBeat.o(119795);
            return size;
        }

        @Override // android.support.v7.h.c.a
        public final int aC() {
            AppMethodBeat.i(119796);
            int size = this.Fyx.size();
            AppMethodBeat.o(119796);
            return size;
        }

        @Override // android.support.v7.h.c.a
        public final boolean i(int i2, int i3) {
            AppMethodBeat.i(119797);
            if (((com.tencent.mm.plugin.story.f.b.a) this.Fyv.Fyu.get(i2)).edx == ((com.tencent.mm.plugin.story.f.b.a) this.Fyx.get(i3)).edx && ((com.tencent.mm.plugin.story.f.b.a) this.Fyv.Fyu.get(i2)).FnS == ((com.tencent.mm.plugin.story.f.b.a) this.Fyx.get(i3)).FnS) {
                AppMethodBeat.o(119797);
                return true;
            }
            AppMethodBeat.o(119797);
            return false;
        }

        @Override // android.support.v7.h.c.a
        public final boolean j(int i2, int i3) {
            AppMethodBeat.i(119798);
            if (((com.tencent.mm.plugin.story.f.b.a) this.Fyv.Fyu.get(i2)).FnW != ((com.tencent.mm.plugin.story.f.b.a) this.Fyx.get(i3)).FnW || !Util.isEqual(((com.tencent.mm.plugin.story.f.b.a) this.Fyv.Fyu.get(i2)).content, ((com.tencent.mm.plugin.story.f.b.a) this.Fyx.get(i3)).content)) {
                AppMethodBeat.o(119798);
                return false;
            }
            AppMethodBeat.o(119798);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$updateBubbles$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-story_release"})
    public static final class b implements d {
        final /* synthetic */ l Fyv;
        final /* synthetic */ List Fyx;

        b(l lVar, List list) {
            this.Fyv = lVar;
            this.Fyx = list;
        }

        @Override // android.support.v7.h.d
        public final void c(int i2, int i3, Object obj) {
            AppMethodBeat.i(119791);
            Log.d(this.Fyv.TAG, "onChanged position:" + i2 + ", count:" + i3);
            this.Fyv.Fyu.clear();
            this.Fyv.Fyu.addAll(this.Fyx);
            this.Fyv.aq(i2, i3);
            AppMethodBeat.o(119791);
        }

        @Override // android.support.v7.h.d
        public final void l(int i2, int i3) {
            AppMethodBeat.i(119792);
            Log.d(this.Fyv.TAG, "onMoved fromPosition:" + i2 + ", toPosition:" + i3);
            AppMethodBeat.o(119792);
        }

        @Override // android.support.v7.h.d
        public final void f(int i2, int i3) {
            AppMethodBeat.i(119793);
            Log.d(this.Fyv.TAG, "onInserted position:" + i2 + ", count:" + i3);
            this.Fyv.Fyu.clear();
            this.Fyv.Fyu.addAll(this.Fyx);
            this.Fyv.as(i2, i3);
            AppMethodBeat.o(119793);
        }

        @Override // android.support.v7.h.d
        public final void k(int i2, int i3) {
            AppMethodBeat.i(119794);
            Log.d(this.Fyv.TAG, "onRemoved position:" + i2 + ", count:" + i3);
            this.Fyv.Fyu.clear();
            this.Fyv.Fyu.addAll(this.Fyx);
            this.Fyv.at(i2, i3);
            AppMethodBeat.o(119794);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$BubbleViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "unreadPadding", "", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter;Landroid/view/View;I)V", "avatar", "Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "getAvatar", "()Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "fromUser", "Landroid/widget/TextView;", "getFromUser", "()Landroid/widget/TextView;", "onBindAvatar", "", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onBindUsername", "plugin-story_release"})
    public final class a extends RecyclerView.v {
        final CommentAvatarImageView FxS;
        final TextView Fxb;
        final int Fya;
        final /* synthetic */ l Fyv;

        public /* synthetic */ a(l lVar, View view) {
            this(lVar, view, at.fromDPToPix(MMApplicationContext.getContext(), 4));
            AppMethodBeat.i(119790);
            AppMethodBeat.o(119790);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private a(l lVar, View view, int i2) {
            super(view);
            p.h(view, "itemView");
            this.Fyv = lVar;
            AppMethodBeat.i(119789);
            this.Fya = i2;
            View findViewById = view.findViewById(R.id.ibt);
            p.g(findViewById, "itemView.findViewById(R.…sg_bubble_item_avatar_iv)");
            this.FxS = (CommentAvatarImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.ibv);
            p.g(findViewById2, "itemView.findViewById(R.…_bubble_item_username_tv)");
            this.Fxb = (TextView) findViewById2;
            AppMethodBeat.o(119789);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.story.ui.a.l$a$a  reason: collision with other inner class name */
        static final class View$OnClickListenerC1777a implements View.OnClickListener {
            final /* synthetic */ com.tencent.mm.plugin.story.f.b.a FxV;
            final /* synthetic */ a Fyw;

            View$OnClickListenerC1777a(a aVar, com.tencent.mm.plugin.story.f.b.a aVar2) {
                this.Fyw = aVar;
                this.FxV = aVar2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(119788);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$BubbleViewHolder$onBindAvatar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("Contact_User", this.FxV.dRL);
                intent.putExtra("CONTACT_INFO_UI_SOURCE", 12);
                com.tencent.mm.br.c.b(this.Fyw.FxS.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryVisitorListAdapter$BubbleViewHolder$onBindAvatar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(119788);
            }
        }
    }
}
