package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.e.d;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J@\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016J \u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFoldedFullConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFoldedConvert;", "controller", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "(Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;)V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class an extends am {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public an(FinderFoldedScrollLayout.b bVar) {
        super(bVar, R.layout.abz);
        p.h(bVar, "controller");
        AppMethodBeat.i(243131);
        AppMethodBeat.o(243131);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.finder.convert.am
    public final /* bridge */ /* synthetic */ void a(h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(243130);
        a(hVar, baseFinderFeed, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(243130);
    }

    @Override // com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.finder.convert.am
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243128);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        super.a(recyclerView, hVar, i2);
        Context context = hVar.getContext();
        p.g(context, "holder.context");
        float dimension = context.getResources().getDimension(R.dimen.c7);
        int height = recyclerView.getHeight();
        Context context2 = recyclerView.getContext();
        p.g(context2, "recyclerView.context");
        Resources resources = context2.getResources();
        p.g(resources, "recyclerView.context.resources");
        View view = hVar.aus;
        p.g(view, "holder.itemView");
        view.setLayoutParams(new RecyclerView.LayoutParams(-1, (int) ((((float) Math.max(height, resources.getDisplayMetrics().heightPixels)) - dimension) / 3.0f)));
        AppMethodBeat.o(243128);
    }

    @Override // com.tencent.mm.plugin.finder.convert.am
    public final void a(h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List<Object> list) {
        d dVar;
        AppMethodBeat.i(243129);
        p.h(hVar, "holder");
        p.h(baseFinderFeed, "item");
        super.a(hVar, baseFinderFeed, i2, i3, z, list);
        m mVar = m.uJa;
        com.tencent.mm.loader.d<o> djY = m.djY();
        cjl first = baseFinderFeed.feedObject.getMediaList().getFirst();
        p.g(first, "item.feedObject.mediaList.first");
        b<o, Bitmap> bQ = djY.bQ(new k(first, x.THUMB_IMAGE, null, null, 12));
        c cVar = c.vCb;
        if (c.dtK().value().intValue() > 0) {
            dVar = new d(null, null, 3);
        } else {
            dVar = null;
        }
        com.tencent.mm.loader.b<o, Bitmap> a2 = bQ.a(dVar);
        m mVar2 = m.uJa;
        com.tencent.mm.loader.b<o, Bitmap> a3 = a2.a(m.a(m.a.DARK_TIMELINE));
        View view = hVar.aus;
        p.g(view, "holder.itemView");
        ImageView imageView = (ImageView) view.findViewById(R.id.imb);
        p.g(imageView, "holder.itemView.thumb_iv");
        a3.c(imageView);
        AppMethodBeat.o(243129);
    }
}
