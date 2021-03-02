package com.tencent.mm.plugin.story.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0014\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "commentAdapter", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;", "commentRecycler", "Landroid/support/v7/widget/RecyclerView;", "getLayoutId", "", "onCommentsLoaded", "", "comments", "", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "CommentUnreadAdapter", "plugin-story_release"})
public final class StoryCommentsUI extends MMActivity {
    private RecyclerView FwW;
    private a FwX;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "position", "", "item", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "invoke"})
    static final class b extends q implements m<Integer, com.tencent.mm.plugin.story.f.b.a, x> {
        public static final b Fxf = new b();

        static {
            AppMethodBeat.i(119637);
            AppMethodBeat.o(119637);
        }

        b() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Integer num, com.tencent.mm.plugin.story.f.b.a aVar) {
            AppMethodBeat.i(119636);
            num.intValue();
            p.h(aVar, "item");
            x xVar = x.SXb;
            AppMethodBeat.o(119636);
            return xVar;
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(119638);
        super.onCreate(bundle);
        View findViewById = findViewById(R.id.i8z);
        p.g(findViewById, "findViewById(R.id.story_comment_recycler)");
        this.FwW = (RecyclerView) findViewById;
        RecyclerView recyclerView = this.FwW;
        if (recyclerView == null) {
            p.btv("commentRecycler");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager());
        this.FwX = new a();
        RecyclerView recyclerView2 = this.FwW;
        if (recyclerView2 == null) {
            p.btv("commentRecycler");
        }
        a aVar = this.FwX;
        if (aVar == null) {
            p.btv("commentAdapter");
        }
        recyclerView2.setAdapter(aVar);
        a aVar2 = this.FwX;
        if (aVar2 == null) {
            p.btv("commentAdapter");
        }
        aVar2.uAj = b.Fxf;
        ArrayList arrayList = new ArrayList();
        a aVar3 = this.FwX;
        if (aVar3 == null) {
            p.btv("commentAdapter");
        }
        ArrayList arrayList2 = arrayList;
        p.h(arrayList2, "storyComments");
        aVar3.FwY.clear();
        aVar3.FwY.addAll(arrayList2);
        aVar3.notifyDataSetChanged();
        AppMethodBeat.o(119638);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.bzs;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u000bH\u0016J \u0010\u0016\u001a\u00020\u00102\u000e\u0010\u0017\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J \u0010\u0018\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\u0014\u0010\u001c\u001a\u00020\u00102\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001eR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000RL\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder;", "Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;", "(Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI;)V", "comments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "storyComments", "", "CommentUnreadViewHolder", "plugin-story_release"})
    public final class a extends RecyclerView.a<C1771a> {
        final ArrayList<com.tencent.mm.plugin.story.f.b.a> FwY = new ArrayList<>();
        m<? super Integer, ? super com.tencent.mm.plugin.story.f.b.a, x> uAj;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
            AppMethodBeat.i(119635);
            AppMethodBeat.o(119635);
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ C1771a a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(119633);
            p.h(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bzq, viewGroup, false);
            p.g(inflate, "LayoutInflater.from(pare…em_normal, parent, false)");
            C1771a aVar = new C1771a(this, inflate);
            AppMethodBeat.o(119633);
            return aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(C1771a aVar, int i2) {
            AppMethodBeat.i(119634);
            C1771a aVar2 = aVar;
            p.h(aVar2, "holder");
            com.tencent.mm.plugin.story.f.b.a aVar3 = this.FwY.get(i2);
            p.g(aVar3, "comments[position]");
            com.tencent.mm.plugin.story.f.b.a aVar4 = aVar3;
            p.h(aVar4, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
            a.b.c(aVar2.keC, aVar4.dRL);
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(aVar4.dRL);
            Context context = aVar2.Fxb.getContext();
            p.g(Kn, "contact");
            aVar2.Fxb.setText(com.tencent.mm.pluginsdk.ui.span.l.b(context, Kn.arJ(), aVar2.Fxb.getTextSize()));
            aVar2.znW.setText(com.tencent.mm.pluginsdk.ui.span.l.b(aVar2.znW.getContext(), aVar4.content, aVar2.znW.getTextSize()));
            AppMethodBeat.o(119634);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(119632);
            int size = this.FwY.size();
            AppMethodBeat.o(119632);
            return size;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\b¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "fromUser", "getFromUser", ShareConstants.WEB_DIALOG_PARAM_QUOTE, "getQuote", "storyPreview", "getStoryPreview", "onBind", "", "position", "", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "plugin-story_release"})
        /* renamed from: com.tencent.mm.plugin.story.ui.StoryCommentsUI$a$a  reason: collision with other inner class name */
        public final class C1771a extends RecyclerView.v {
            private final ImageView Fxa;
            final TextView Fxb;
            private final TextView Fxc;
            final /* synthetic */ a Fxd;
            final ImageView keC;
            final TextView znW;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C1771a(a aVar, View view) {
                super(view);
                p.h(view, "itemView");
                this.Fxd = aVar;
                AppMethodBeat.i(119631);
                View findViewById = view.findViewById(R.id.i8j);
                p.g(findViewById, "itemView.findViewById(R.…tory_comment_item_avatar)");
                this.keC = (ImageView) findViewById;
                View findViewById2 = view.findViewById(R.id.i8q);
                p.g(findViewById2, "itemView.findViewById(R.…ory_comment_item_preview)");
                this.Fxa = (ImageView) findViewById2;
                View findViewById3 = view.findViewById(R.id.i8t);
                p.g(findViewById3, "itemView.findViewById(R.…ry_comment_item_username)");
                this.Fxb = (TextView) findViewById3;
                View findViewById4 = view.findViewById(R.id.i8m);
                p.g(findViewById4, "itemView.findViewById(R.…ory_comment_item_content)");
                this.znW = (TextView) findViewById4;
                View findViewById5 = view.findViewById(R.id.i8r);
                p.g(findViewById5, "itemView.findViewById(R.…mment_item_quote_content)");
                this.Fxc = (TextView) findViewById5;
                view.setOnClickListener(new View.OnClickListener(this) {
                    /* class com.tencent.mm.plugin.story.ui.StoryCommentsUI.a.C1771a.AnonymousClass1 */
                    final /* synthetic */ C1771a Fxe;

                    {
                        this.Fxe = r1;
                    }

                    public final void onClick(View view) {
                        AppMethodBeat.i(119630);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        int lR = this.Fxe.lR();
                        Object obj = this.Fxe.Fxd.FwY.get(lR);
                        p.g(obj, "comments[position]");
                        com.tencent.mm.plugin.story.f.b.a aVar = (com.tencent.mm.plugin.story.f.b.a) obj;
                        m<? super Integer, ? super com.tencent.mm.plugin.story.f.b.a, x> mVar = this.Fxe.Fxd.uAj;
                        if (mVar != null) {
                            mVar.invoke(Integer.valueOf(lR), aVar);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StoryCommentsUI$CommentUnreadAdapter$CommentUnreadViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(119630);
                    }
                });
                AppMethodBeat.o(119631);
            }
        }
    }
}
