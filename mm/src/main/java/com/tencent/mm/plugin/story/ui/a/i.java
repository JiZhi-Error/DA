package com.tencent.mm.plugin.story.ui.a;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.a;
import com.tencent.mm.loader.e;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.story.f.c.d;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.ui.view.StoryCommentView;
import com.tencent.mm.plugin.story.ui.view.StoryMsgView;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryItemView;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryPostTip;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bp;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0011R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;)V", "bindItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "commentView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "msgView", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", "postTipView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "storyItemView", "thumbView", "Landroid/widget/ImageView;", "onBind", "", "item", "position", "", "isActive", "", "reBindBitmap", "plugin-story_release"})
public final class i extends RecyclerView.v {
    final StoryGalleryItemView Fyf;
    final StoryCommentView Fyg;
    final StoryMsgView Fyh;
    final StoryGalleryPostTip Fyi;
    h Fyj;
    private final ImageView tiQ;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(StoryGalleryItemView storyGalleryItemView) {
        super(storyGalleryItemView);
        p.h(storyGalleryItemView, "itemView");
        AppMethodBeat.i(119773);
        this.Fyf = storyGalleryItemView;
        this.Fyg = storyGalleryItemView.getCommentView();
        this.Fyh = storyGalleryItemView.getMsgView();
        this.tiQ = storyGalleryItemView.getThumbView();
        this.Fyi = storyGalleryItemView.getPostTipView();
        AppMethodBeat.o(119773);
    }

    public final void frU() {
        AppMethodBeat.i(119772);
        h hVar = this.Fyj;
        if (hVar == null) {
            AppMethodBeat.o(119772);
            return;
        }
        bp akk = bp.gDa().akk(hVar.FoT.iXu);
        if (hVar.FoT.foV()) {
            Log.i(h.TAG, "reBindBitmap FakeVideo");
            if (hVar.FoT.Fpe == null) {
                e eVar = e.hXU;
                e.aJs().Hf("").c(this.tiQ);
                AppMethodBeat.o(119772);
                return;
            }
            c cVar = hVar.FoT.Fpe;
            if (cVar != null) {
                Log.i(h.TAG, "load fake localFile:" + cVar.eII().thumbPath + ", position:" + getPosition() + ", videoPath:" + cVar.eII().videoPath);
                e eVar2 = e.hXU;
                a aJs = e.aJs();
                String str = cVar.eII().thumbPath;
                p.g(str, "it.editorProtoData.thumbPath");
                aJs.Hf(str).a(this.tiQ, false);
                AppMethodBeat.o(119772);
                return;
            }
            AppMethodBeat.o(119772);
            return;
        }
        edt edt = hVar.FoT.Fpd;
        String str2 = hVar.userName;
        p.g(akk, "fromScene");
        d dVar = new d(edt, str2, akk);
        Log.i(h.TAG, "reBindBitmap NormalVideo " + dVar.auA());
        j.b bVar = j.Fmy;
        j.b.fok().bQ(dVar).c(this.tiQ);
        AppMethodBeat.o(119772);
    }
}
