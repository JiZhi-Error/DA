package com.tencent.mm.plugin.story.ui.album;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 \u001e2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020\r2\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u0014\u0010\u001b\u001a\u00020\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001dR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000R7\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$StoryAlbumItemViewHolder;", "()V", "mMediaList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/collections/ArrayList;", "mOnGridItemClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "info", "", "getMOnGridItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setMOnGridItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateDatas", "datas", "", "Companion", "StoryAlbumItemViewHolder", "plugin-story_release"})
public final class d extends RecyclerView.a<b> {
    public static final a FyR = new a((byte) 0);
    private static final String TAG = TAG;
    kotlin.g.a.b<? super h, x> FyG;
    final ArrayList<h> FyQ = new ArrayList<>();

    public d() {
        AppMethodBeat.i(119828);
        AppMethodBeat.o(119828);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ b a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(119825);
        p.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bz8, viewGroup, false);
        p.g(inflate, "LayoutInflater.from(pare…da_layout, parent, false)");
        b bVar = new b(this, inflate);
        bVar.FyS.setOnClickListener(new c(this));
        b bVar2 = bVar;
        AppMethodBeat.o(119825);
        return bVar2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(b bVar, int i2) {
        AppMethodBeat.i(119827);
        b bVar2 = bVar;
        p.h(bVar2, "holder");
        bVar2.FyS.setTag(bVar2.FyU.FyQ.get(i2));
        eek frG = bVar2.FyU.FyQ.get(i2).Fqr.frG();
        LinkedList<edt> linkedList = frG.NeB.LoV;
        if (!linkedList.isEmpty()) {
            j.b bVar3 = j.Fmy;
            com.tencent.mm.loader.d<com.tencent.mm.plugin.story.f.c.d> fok = j.b.fok();
            edt edt = linkedList.get(0);
            p.g(edt, "mediaList[0]");
            String str = frG.UserName;
            bp bpVar = bp.Oqx;
            p.g(bpVar, "FROM_SCENE.storyalbum");
            com.tencent.mm.plugin.story.f.c.d dVar = new com.tencent.mm.plugin.story.f.c.d(edt, str, bpVar);
            ImageView imageView = bVar2.FyS;
            j.b bVar4 = j.Fmy;
            fok.a(dVar, imageView, j.b.a(com.tencent.mm.plugin.story.f.c.a.ALBUM_SCENE));
        }
        if (bVar2.FyU.FyQ.get(i2).field_count > 1) {
            bVar2.FyT.setImageDrawable(ar.m(bVar2.FyT.getContext(), R.raw.icons_filled_photo_wall, Color.parseColor("#FFFFFF")));
            bVar2.FyT.setVisibility(8);
            bVar2.hXK.setText(String.valueOf(bVar2.FyU.FyQ.get(i2).field_count));
            bVar2.hXK.setVisibility(0);
            AppMethodBeat.o(119827);
            return;
        }
        bVar2.FyT.setVisibility(8);
        bVar2.hXK.setVisibility(8);
        AppMethodBeat.o(119827);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119829);
        AppMethodBeat.o(119829);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ d FyU;

        c(d dVar) {
            this.FyU = dVar;
        }

        public final void onClick(View view) {
            kotlin.g.a.b<? super h, x> bVar;
            AppMethodBeat.i(119824);
            com.tencent.mm.hellhoundlib.b.b bVar2 = new com.tencent.mm.hellhoundlib.b.b();
            bVar2.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar2.axR());
            p.g(view, "view");
            if (!(view.getTag() == null || !(view.getTag() instanceof h) || (bVar = this.FyU.FyG) == null)) {
                Object tag = view.getTag();
                if (tag == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryHistoryInfo");
                    AppMethodBeat.o(119824);
                    throw tVar;
                }
                bVar.invoke((h) tag);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119824);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(119826);
        int size = this.FyQ.size();
        AppMethodBeat.o(119826);
        return size;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter$StoryAlbumItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;Landroid/view/View;)V", "countTv", "Landroid/widget/TextView;", "getCountTv", "()Landroid/widget/TextView;", "setCountTv", "(Landroid/widget/TextView;)V", "img", "Landroid/widget/ImageView;", "getImg", "()Landroid/widget/ImageView;", "setImg", "(Landroid/widget/ImageView;)V", "multipleTip", "getMultipleTip", "setMultipleTip", "onBind", "", "position", "", "plugin-story_release"})
    public final class b extends RecyclerView.v {
        ImageView FyS;
        ImageView FyT;
        final /* synthetic */ d FyU;
        TextView hXK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(d dVar, View view) {
            super(view);
            p.h(view, "view");
            this.FyU = dVar;
            AppMethodBeat.i(119823);
            View findViewById = view.findViewById(R.id.l2);
            p.g(findViewById, "view.findViewById(R.id.album_story_item_media_img)");
            this.FyS = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.l3);
            p.g(findViewById2, "view.findViewById(R.id.a…_story_item_multiple_tip)");
            this.FyT = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.kw);
            p.g(findViewById3, "view.findViewById(R.id.album_story_item_count_tv)");
            this.hXK = (TextView) findViewById3;
            AppMethodBeat.o(119823);
        }
    }
}
