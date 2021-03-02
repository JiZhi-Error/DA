package com.tencent.mm.plugin.story.ui.a;

import android.content.Intent;
import android.support.v7.h.c;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.plugin.story.ui.view.CommentAvatarImageView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001,B\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001e\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020\fH\u0002J\b\u0010 \u001a\u00020!H\u0016J\u001c\u0010\"\u001a\u00020\u00192\n\u0010#\u001a\u00060\u0002R\u00020\u00002\u0006\u0010$\u001a\u00020!H\u0016J\u001c\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020!H\u0016J\u0014\u0010)\u001a\u00020\u00192\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050+R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f`\rX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R7\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$CommentViewHolder;", "commentDatas", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "TAG", "", "hasStoryStateMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "hostStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getHostStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setHostStory", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "onItemClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "commentItem", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "filterFavItem", "filterValidItem", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateComments", "newComments", "", "CommentViewHolder", "plugin-story_release"})
public final class f extends RecyclerView.a<a> {
    public j FxM;
    private final HashMap<String, Boolean> FxX = new HashMap<>();
    public kotlin.g.a.b<? super com.tencent.mm.plugin.story.f.b.a, x> FxY;
    private final ArrayList<com.tencent.mm.plugin.story.f.b.a> FxZ;
    private final String TAG = "MicroMsg.StoryCommentListAdapter";

    public f(ArrayList<com.tencent.mm.plugin.story.f.b.a> arrayList) {
        p.h(arrayList, "commentDatas");
        AppMethodBeat.i(119765);
        this.FxZ = arrayList;
        AppMethodBeat.o(119765);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(119761);
        p.h(viewGroup, "parent");
        View inflate = View.inflate(viewGroup.getContext(), R.layout.c0l, null);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        p.g(inflate, "itemView");
        inflate.setLayoutParams(layoutParams);
        a aVar = new a(this, inflate);
        AppMethodBeat.o(119761);
        return aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x015d, code lost:
        if (r4 != false) goto L_0x015f;
     */
    @Override // android.support.v7.widget.RecyclerView.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void a(com.tencent.mm.plugin.story.ui.a.f.a r11, int r12) {
        /*
        // Method dump skipped, instructions count: 449
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.ui.a.f.a(android.support.v7.widget.RecyclerView$v, int):void");
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(119762);
        int size = this.FxZ.size();
        AppMethodBeat.o(119762);
        return size;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.story.f.b.a FxV;
        final /* synthetic */ f Fyb;

        b(f fVar, com.tencent.mm.plugin.story.f.b.a aVar) {
            this.Fyb = fVar;
            this.FxV = aVar;
        }

        public final void onClick(View view) {
            kotlin.g.a.b<? super com.tencent.mm.plugin.story.f.b.a, x> bVar;
            AppMethodBeat.i(119752);
            com.tencent.mm.hellhoundlib.b.b bVar2 = new com.tencent.mm.hellhoundlib.b.b();
            bVar2.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar2.axR());
            if ((f.a(this.Fyb) || f.b(this.Fyb)) && (bVar = this.Fyb.FxY) != null) {
                bVar.invoke(this.FxV);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119752);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0075 A[EDGE_INSN: B:19:0x0075->B:12:0x0075 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aj(java.util.List<com.tencent.mm.plugin.story.f.b.a> r9) {
        /*
        // Method dump skipped, instructions count: 175
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.ui.a.f.aj(java.util.List):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$updateComments$result$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-story_release"})
    public static final class d extends c.a {
        final /* synthetic */ f Fyb;
        final /* synthetic */ List Fyd;

        d(f fVar, List list) {
            this.Fyb = fVar;
            this.Fyd = list;
        }

        @Override // android.support.v7.h.c.a
        public final int aB() {
            AppMethodBeat.i(119757);
            int size = this.Fyb.FxZ.size();
            AppMethodBeat.o(119757);
            return size;
        }

        @Override // android.support.v7.h.c.a
        public final int aC() {
            AppMethodBeat.i(119758);
            int size = this.Fyd.size();
            AppMethodBeat.o(119758);
            return size;
        }

        @Override // android.support.v7.h.c.a
        public final boolean i(int i2, int i3) {
            AppMethodBeat.i(119759);
            if (((com.tencent.mm.plugin.story.f.b.a) this.Fyb.FxZ.get(i2)).edx == ((com.tencent.mm.plugin.story.f.b.a) this.Fyd.get(i3)).edx && ((com.tencent.mm.plugin.story.f.b.a) this.Fyb.FxZ.get(i2)).FnS == ((com.tencent.mm.plugin.story.f.b.a) this.Fyd.get(i3)).FnS) {
                AppMethodBeat.o(119759);
                return true;
            }
            AppMethodBeat.o(119759);
            return false;
        }

        @Override // android.support.v7.h.c.a
        public final boolean j(int i2, int i3) {
            AppMethodBeat.i(119760);
            if (((com.tencent.mm.plugin.story.f.b.a) this.Fyb.FxZ.get(i2)).FnW != ((com.tencent.mm.plugin.story.f.b.a) this.Fyd.get(i3)).FnW || !Util.isEqual(((com.tencent.mm.plugin.story.f.b.a) this.Fyb.FxZ.get(i2)).content, ((com.tencent.mm.plugin.story.f.b.a) this.Fyd.get(i3)).content)) {
                AppMethodBeat.o(119760);
                return false;
            }
            AppMethodBeat.o(119760);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$updateComments$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-story_release"})
    public static final class c implements android.support.v7.h.d {
        final /* synthetic */ f Fyb;
        final /* synthetic */ List Fyd;

        c(f fVar, List list) {
            this.Fyb = fVar;
            this.Fyd = list;
        }

        @Override // android.support.v7.h.d
        public final void c(int i2, int i3, Object obj) {
            AppMethodBeat.i(119753);
            Log.d(this.Fyb.TAG, "onChanged position:" + i2 + ", count:" + i3);
            this.Fyb.FxZ.clear();
            this.Fyb.FxZ.addAll(this.Fyd);
            this.Fyb.aq(i2, i3);
            AppMethodBeat.o(119753);
        }

        @Override // android.support.v7.h.d
        public final void l(int i2, int i3) {
            AppMethodBeat.i(119754);
            Log.d(this.Fyb.TAG, "onMoved fromPosition:" + i2 + ", toPosition:" + i3);
            AppMethodBeat.o(119754);
        }

        @Override // android.support.v7.h.d
        public final void f(int i2, int i3) {
            AppMethodBeat.i(119755);
            Log.d(this.Fyb.TAG, "onInserted position:" + i2 + ", count:" + i3);
            this.Fyb.FxZ.clear();
            this.Fyb.FxZ.addAll(this.Fyd);
            this.Fyb.as(i2, i3);
            AppMethodBeat.o(119755);
        }

        @Override // android.support.v7.h.d
        public final void k(int i2, int i3) {
            AppMethodBeat.i(119756);
            Log.d(this.Fyb.TAG, "onRemoved position:" + i2 + ", count:" + i3);
            this.Fyb.FxZ.clear();
            this.Fyb.FxZ.addAll(this.Fyd);
            this.Fyb.at(i2, i3);
            AppMethodBeat.o(119756);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$CommentViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "unreadPadding", "", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter;Landroid/view/View;I)V", "avatar", "Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "getAvatar", "()Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", "onBindAvatar", "", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "position", "onBindContent", "onBindUsername", "plugin-story_release"})
    public final class a extends RecyclerView.v {
        final CommentAvatarImageView FxS;
        final TextView Fxb;
        final int Fya;
        final /* synthetic */ f Fyb;
        final TextView znW;

        public /* synthetic */ a(f fVar, View view) {
            this(fVar, view, at.fromDPToPix(MMApplicationContext.getContext(), 4));
            AppMethodBeat.i(119751);
            AppMethodBeat.o(119751);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private a(f fVar, View view, int i2) {
            super(view);
            p.h(view, "itemView");
            this.Fyb = fVar;
            AppMethodBeat.i(119750);
            this.Fya = i2;
            View findViewById = view.findViewById(R.id.ibx);
            p.g(findViewById, "itemView.findViewById(R.…ry_msg_comment_avatar_iv)");
            this.FxS = (CommentAvatarImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.ic0);
            p.g(findViewById2, "itemView.findViewById(R.…comment_content_username)");
            this.Fxb = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.ibz);
            p.g(findViewById3, "itemView.findViewById(R.…_msg_comment_content_msg)");
            this.znW = (TextView) findViewById3;
            AppMethodBeat.o(119750);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.story.ui.a.f$a$a  reason: collision with other inner class name */
        static final class View$OnClickListenerC1776a implements View.OnClickListener {
            final /* synthetic */ com.tencent.mm.plugin.story.f.b.a FxV;
            final /* synthetic */ a Fyc;

            View$OnClickListenerC1776a(a aVar, com.tencent.mm.plugin.story.f.b.a aVar2) {
                this.Fyc = aVar;
                this.FxV = aVar2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(119749);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$CommentViewHolder$onBindAvatar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("Contact_User", this.FxV.dRL);
                intent.putExtra("CONTACT_INFO_UI_SOURCE", 12);
                com.tencent.mm.br.c.b(this.Fyc.FxS.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentListAdapter$CommentViewHolder$onBindAvatar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(119749);
            }
        }
    }

    public static final /* synthetic */ boolean a(f fVar) {
        AppMethodBeat.i(163168);
        j jVar = fVar.FxM;
        if (jVar == null || !jVar.frK()) {
            AppMethodBeat.o(163168);
            return false;
        }
        AppMethodBeat.o(163168);
        return true;
    }

    public static final /* synthetic */ boolean b(f fVar) {
        j jVar;
        AppMethodBeat.i(163169);
        j jVar2 = fVar.FxM;
        if (jVar2 == null || jVar2.frL() || (jVar = fVar.FxM) == null || jVar.frJ()) {
            AppMethodBeat.o(163169);
            return false;
        }
        AppMethodBeat.o(163169);
        return true;
    }
}
