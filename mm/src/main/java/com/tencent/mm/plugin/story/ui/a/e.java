package com.tencent.mm.plugin.story.ui.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.plugin.story.ui.view.CommentAvatarImageView;
import com.tencent.mm.plugin.story.ui.view.CommentItemView;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 52\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u00044567B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010$\u001a\u00020\u0007H\u0002J\b\u0010%\u001a\u00020\u0007H\u0002J\b\u0010&\u001a\u00020\u0005H\u0016J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0016J\u001c\u0010)\u001a\u00020\u000b2\n\u0010*\u001a\u00060\u0002R\u00020\u00002\u0006\u0010(\u001a\u00020\u0005H\u0016J\u001c\u0010+\u001a\u00060\u0002R\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0005H\u0016J\u000e\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u0007J\u0014\u00101\u001a\u00020\u000b2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001203R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019RL\u0010\u001a\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00068"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "()V", "animStartPosition", "", "animateOnBind", "", "bindMaxPosition", "blankAreaClickListener", "Lkotlin/Function0;", "", "getBlankAreaClickListener", "()Lkotlin/jvm/functions/Function0;", "setBlankAreaClickListener", "(Lkotlin/jvm/functions/Function0;)V", "comments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "hostStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getHostStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setHostStory", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "replyClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "isReply", "getReplyClickListener", "()Lkotlin/jvm/functions/Function2;", "setReplyClickListener", "(Lkotlin/jvm/functions/Function2;)V", "filterFavItem", "filterValidItem", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAnimateEnable", "enable", "update", "storyComments", "", "BaseStoryCommentViewHolder", "Companion", "StoryBubbleViewHolder", "StoryCommentViewHolder", "plugin-story_release"})
public final class e extends RecyclerView.a<a> {
    private static final int FxP = 0;
    private static final int FxQ = 1;
    public static final b FxR = new b((byte) 0);
    private final ArrayList<com.tencent.mm.plugin.story.f.b.a> FwY = new ArrayList<>();
    public boolean FxL;
    public j FxM;
    public m<? super com.tencent.mm.plugin.story.f.b.a, ? super Boolean, x> FxN;
    public kotlin.g.a.a<x> FxO;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$Companion;", "", "()V", "ViewTypeBubble", "", "ViewTypeNormal", "plugin-story_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public e() {
        AppMethodBeat.i(119745);
        AppMethodBeat.o(119745);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        d dVar;
        AppMethodBeat.i(119743);
        p.h(viewGroup, "parent");
        if (i2 == FxQ) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bzp, viewGroup, false);
            p.g(inflate, "LayoutInflater.from(pare…em_bubble, parent, false)");
            dVar = new c(this, inflate);
        } else {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bzo, viewGroup, false);
            p.g(inflate2, "LayoutInflater.from(pare…ment_item, parent, false)");
            dVar = new d(this, inflate2);
        }
        RecyclerView.v vVar = dVar;
        AppMethodBeat.o(119743);
        return vVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(119744);
        a aVar2 = aVar;
        p.h(aVar2, "holder");
        com.tencent.mm.plugin.story.f.b.a aVar3 = this.FwY.get(i2);
        p.g(aVar3, "comments[position]");
        aVar2.a(i2, aVar3);
        AppMethodBeat.o(119744);
    }

    static {
        AppMethodBeat.i(119746);
        AppMethodBeat.o(119746);
    }

    public final void hw(List<com.tencent.mm.plugin.story.f.b.a> list) {
        AppMethodBeat.i(119740);
        p.h(list, "storyComments");
        this.FwY.clear();
        this.FwY.addAll(list);
        AppMethodBeat.o(119740);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(119741);
        int size = this.FwY.size();
        AppMethodBeat.o(119741);
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(119742);
        if (this.FwY.get(i2).FnX) {
            int i3 = FxQ;
            AppMethodBeat.o(119742);
            return i3;
        }
        int i4 = FxP;
        AppMethodBeat.o(119742);
        return i4;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0003H&J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "avatar", "Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "getAvatar", "()Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "blankArea", "getBlankArea", "()Landroid/view/View;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", "maskView", "getMaskView", "setMaskView", "(Landroid/view/View;)V", "findMaskView", "onBind", "", "position", "", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onBindAvatar", "onBindMask", "onBindUsername", "plugin-story_release"})
    public abstract class a extends RecyclerView.v {
        private final CommentAvatarImageView FxS;
        final /* synthetic */ e FxT;
        final TextView Fxb;
        private final View hRx;
        private View maskView = frT();
        private final TextView znW;

        public abstract View frT();

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(e eVar, View view) {
            super(view);
            p.h(view, "itemView");
            this.FxT = eVar;
            View findViewById = view.findViewById(R.id.i8j);
            p.g(findViewById, "itemView.findViewById(R.…tory_comment_item_avatar)");
            this.FxS = (CommentAvatarImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.i8t);
            p.g(findViewById2, "itemView.findViewById(R.…ry_comment_item_username)");
            this.Fxb = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.i8m);
            p.g(findViewById3, "itemView.findViewById(R.…ory_comment_item_content)");
            this.znW = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.i8k);
            p.g(findViewById4, "itemView.findViewById(R.…_comment_item_blank_area)");
            this.hRx = findViewById4;
        }

        public void a(int i2, com.tencent.mm.plugin.story.f.b.a aVar) {
            boolean z;
            SpannableString spannableString;
            String arJ;
            String arJ2;
            int i3 = 0;
            p.h(aVar, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
            if (this.aus instanceof CommentItemView) {
                ((CommentItemView) this.aus).setComment(aVar);
            }
            View view = this.aus;
            p.g(view, "itemView");
            view.setVisibility(4);
            this.aus.post(new RunnableC1775a(this));
            this.hRx.setOnClickListener(new b(this));
            if (this.aus instanceof CommentItemView) {
                if (aVar.FnW) {
                    Drawable background = this.maskView.getBackground();
                    p.g(background, "bg");
                    View view2 = this.aus;
                    p.g(view2, "itemView");
                    Context context = ((CommentItemView) view2).getContext();
                    p.g(context, "itemView.context");
                    background.setColorFilter(new PorterDuffColorFilter(context.getResources().getColor(R.color.Indigo), PorterDuff.Mode.SRC_ATOP));
                } else {
                    Drawable background2 = this.maskView.getBackground();
                    p.g(background2, "bg");
                    View view3 = this.aus;
                    p.g(view3, "itemView");
                    Context context2 = ((CommentItemView) view3).getContext();
                    p.g(context2, "itemView.context");
                    background2.setColorFilter(new PorterDuffColorFilter(context2.getResources().getColor(R.color.a_s), PorterDuff.Mode.SRC_ATOP));
                }
            }
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(aVar.dRL);
            SpannableString b2 = com.tencent.mm.pluginsdk.ui.span.l.b(this.Fxb.getContext(), (Kn == null || (arJ2 = Kn.arJ()) == null) ? "" : arJ2, this.Fxb.getTextSize());
            com.tencent.mm.kernel.c.a af2 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af2, "MMKernel.service(IMessengerStorage::class.java)");
            as Kn2 = ((com.tencent.mm.plugin.messenger.foundation.a.l) af2).aSN().Kn(aVar.toUser);
            SpannableString b3 = com.tencent.mm.pluginsdk.ui.span.l.b(this.Fxb.getContext(), (Kn2 == null || (arJ = Kn2.arJ()) == null) ? "" : arJ, this.Fxb.getTextSize());
            if (aVar.Fob != 0) {
                z = true;
            } else {
                z = false;
            }
            TextView textView = this.Fxb;
            if (z) {
                StringBuilder append = new StringBuilder().append((Object) b2).append(' ');
                Context context3 = this.Fxb.getContext();
                p.g(context3, "fromUser.context");
                spannableString = append.append(context3.getResources().getString(R.string.yf)).append(' ').append((Object) b3).toString();
            } else {
                spannableString = b2;
            }
            textView.setText(spannableString);
            this.znW.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.znW.getContext(), aVar.content, this.znW.getTextSize()));
            a.b.d(this.FxS, aVar.dRL);
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            f aSw = j.b.fod().aSw(aVar.dRL);
            this.FxS.setShowStoryHint(aSw != null ? aSw.frA() : false);
            this.FxS.aSD(aVar.dRL);
            CommentAvatarImageView commentAvatarImageView = this.FxS;
            if (aVar.FnX) {
                i3 = this.FxS.getResources().getColor(R.color.a_s);
            }
            commentAvatarImageView.setHintBg(i3);
            this.FxS.setOnClickListener(new c(this, aVar));
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.story.ui.a.e$a$a  reason: collision with other inner class name */
        public static final class RunnableC1775a implements Runnable {
            final /* synthetic */ a FxU;

            RunnableC1775a(a aVar) {
                this.FxU = aVar;
            }

            public final void run() {
                AppMethodBeat.i(119728);
                View view = this.FxU.aus;
                p.g(view, "itemView");
                view.setVisibility(0);
                AppMethodBeat.o(119728);
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        public static final class b implements View.OnClickListener {
            final /* synthetic */ a FxU;

            b(a aVar) {
                this.FxU = aVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(119729);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder$onBind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kotlin.g.a.a<x> aVar = this.FxU.FxT.FxO;
                if (aVar != null) {
                    aVar.invoke();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder$onBind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(119729);
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        public static final class c implements View.OnClickListener {
            final /* synthetic */ a FxU;
            final /* synthetic */ com.tencent.mm.plugin.story.f.b.a FxV;

            c(a aVar, com.tencent.mm.plugin.story.f.b.a aVar2) {
                this.FxU = aVar;
                this.FxV = aVar2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(119730);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder$onBindAvatar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("Contact_User", this.FxV.dRL);
                intent.putExtra("CONTACT_INFO_UI_SOURCE", 12);
                View view2 = this.FxU.aus;
                p.g(view2, "itemView");
                com.tencent.mm.br.c.b(view2.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder$onBindAvatar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(119730);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "opTv", "Landroid/widget/TextView;", "getOpTv", "()Landroid/widget/TextView;", "findMaskView", "onBind", "", "position", "", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onBindOpTv", "plugin-story_release"})
    public final class d extends a {
        private final TextView Epm;
        final /* synthetic */ e FxT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(e eVar, View view) {
            super(eVar, view);
            p.h(view, "itemView");
            this.FxT = eVar;
            AppMethodBeat.i(119739);
            View findViewById = view.findViewById(R.id.i8p);
            p.g(findViewById, "itemView.findViewById(R.…story_comment_item_op_tv)");
            this.Epm = (TextView) findViewById;
            AppMethodBeat.o(119739);
        }

        @Override // com.tencent.mm.plugin.story.ui.a.e.a
        public final View frT() {
            AppMethodBeat.i(119737);
            View findViewById = this.aus.findViewById(R.id.i86);
            p.g(findViewById, "itemView.findViewById(R.…mment_content_background)");
            AppMethodBeat.o(119737);
            return findViewById;
        }

        @Override // com.tencent.mm.plugin.story.ui.a.e.a
        public final void a(int i2, com.tencent.mm.plugin.story.f.b.a aVar) {
            AppMethodBeat.i(119738);
            p.h(aVar, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
            super.a(i2, aVar);
            if (aVar.FnX) {
                com.tencent.mm.ac.d.f(this.Fxb);
            }
            if (!aVar.FnX) {
                j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                boolean isEqual = Util.isEqual(j.b.fau(), aVar.dRL);
                this.Epm.setVisibility(0);
                if (isEqual) {
                    this.Epm.setOnClickListener(new b(this, aVar));
                    TextView textView = this.Epm;
                    View view = this.aus;
                    p.g(view, "itemView");
                    Context context = view.getContext();
                    p.g(context, "itemView.context");
                    textView.setText(context.getResources().getString(R.string.hgv));
                    this.Epm.setTextColor(-1);
                    com.tencent.mm.ac.d.f(this.Epm);
                } else if (com.tencent.mm.plugin.story.c.a.a.FkW.fnu() && (e.a(this.FxT) || e.b(this.FxT))) {
                    this.Epm.setOnClickListener(new c(this, aVar));
                    TextView textView2 = this.Epm;
                    View view2 = this.aus;
                    p.g(view2, "itemView");
                    Context context2 = view2.getContext();
                    p.g(context2, "itemView.context");
                    textView2.setText(context2.getResources().getString(R.string.hgw));
                    this.Epm.setTextColor(-1);
                    com.tencent.mm.ac.d.f(this.Epm);
                }
                this.aus.setOnClickListener(new a(this, aVar));
                AppMethodBeat.o(119738);
            }
            this.Epm.setVisibility(8);
            this.aus.setOnClickListener(new a(this, aVar));
            AppMethodBeat.o(119738);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ com.tencent.mm.plugin.story.f.b.a FxV;
            final /* synthetic */ d FxW;

            a(d dVar, com.tencent.mm.plugin.story.f.b.a aVar) {
                this.FxW = dVar;
                this.FxV = aVar;
            }

            public final void onClick(View view) {
                m<? super com.tencent.mm.plugin.story.f.b.a, ? super Boolean, x> mVar;
                AppMethodBeat.i(119734);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (com.tencent.mm.plugin.story.c.a.a.FkW.fnu() && (e.a(this.FxW.FxT) || e.b(this.FxW.FxT))) {
                    j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
                    if (!Util.isEqual(j.b.fau(), this.FxV.dRL) && (mVar = this.FxW.FxT.FxN) != null) {
                        mVar.invoke(this.FxV, Boolean.TRUE);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(119734);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class b implements View.OnClickListener {
            final /* synthetic */ com.tencent.mm.plugin.story.f.b.a FxV;
            final /* synthetic */ d FxW;

            b(d dVar, com.tencent.mm.plugin.story.f.b.a aVar) {
                this.FxW = dVar;
                this.FxV = aVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(119735);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder$onBindOpTv$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                m<? super com.tencent.mm.plugin.story.f.b.a, ? super Boolean, x> mVar = this.FxW.FxT.FxN;
                if (mVar != null) {
                    mVar.invoke(this.FxV, Boolean.FALSE);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder$onBindOpTv$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(119735);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class c implements View.OnClickListener {
            final /* synthetic */ com.tencent.mm.plugin.story.f.b.a FxV;
            final /* synthetic */ d FxW;

            c(d dVar, com.tencent.mm.plugin.story.f.b.a aVar) {
                this.FxW = dVar;
                this.FxV = aVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(119736);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder$onBindOpTv$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                m<? super com.tencent.mm.plugin.story.f.b.a, ? super Boolean, x> mVar = this.FxW.FxT.FxN;
                if (mVar != null) {
                    mVar.invoke(this.FxV, Boolean.TRUE);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryCommentViewHolder$onBindOpTv$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(119736);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$StoryBubbleViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter$BaseStoryCommentViewHolder;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/StoryCommentAdapter;Landroid/view/View;)V", "findMaskView", "onBind", "", "position", "", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "plugin-story_release"})
    public final class c extends a {
        final /* synthetic */ e FxT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(e eVar, View view) {
            super(eVar, view);
            p.h(view, "itemView");
            this.FxT = eVar;
            AppMethodBeat.i(119733);
            AppMethodBeat.o(119733);
        }

        @Override // com.tencent.mm.plugin.story.ui.a.e.a
        public final View frT() {
            AppMethodBeat.i(119731);
            View findViewById = this.aus.findViewById(R.id.i7z);
            p.g(findViewById, "itemView.findViewById(R.…omment_bubble_background)");
            AppMethodBeat.o(119731);
            return findViewById;
        }

        @Override // com.tencent.mm.plugin.story.ui.a.e.a
        public final void a(int i2, com.tencent.mm.plugin.story.f.b.a aVar) {
            AppMethodBeat.i(119732);
            p.h(aVar, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
            super.a(i2, aVar);
            if (aVar.FnX) {
                com.tencent.mm.ac.d.f(this.Fxb);
            }
            AppMethodBeat.o(119732);
        }
    }

    public static final /* synthetic */ boolean a(e eVar) {
        AppMethodBeat.i(119747);
        com.tencent.mm.plugin.story.i.j jVar = eVar.FxM;
        if (jVar == null || !jVar.frK()) {
            AppMethodBeat.o(119747);
            return false;
        }
        AppMethodBeat.o(119747);
        return true;
    }

    public static final /* synthetic */ boolean b(e eVar) {
        com.tencent.mm.plugin.story.i.j jVar;
        AppMethodBeat.i(119748);
        com.tencent.mm.plugin.story.i.j jVar2 = eVar.FxM;
        if (jVar2 == null || jVar2.frL() || (jVar = eVar.FxM) == null || jVar.frJ()) {
            AppMethodBeat.o(119748);
            return false;
        }
        AppMethodBeat.o(119748);
        return true;
    }
}
