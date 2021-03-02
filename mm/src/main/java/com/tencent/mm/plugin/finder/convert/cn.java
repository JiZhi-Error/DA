package com.tencent.mm.plugin.finder.convert;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.e.d;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.loader.q;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J@\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderVideoFoldedConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFoldedConvert;", "controller", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "(Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;)V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
public final class cn extends am {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public cn(FinderFoldedScrollLayout.b bVar) {
        super(bVar, R.layout.abf);
        p.h(bVar, "controller");
        AppMethodBeat.i(243378);
        AppMethodBeat.o(243378);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.finder.convert.am
    public final /* bridge */ /* synthetic */ void a(h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(243377);
        a(hVar, baseFinderFeed, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(243377);
    }

    @Override // com.tencent.mm.plugin.finder.convert.am
    public final void a(h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List<Object> list) {
        d dVar;
        d dVar2;
        AppMethodBeat.i(243376);
        p.h(hVar, "holder");
        p.h(baseFinderFeed, "item");
        super.a(hVar, baseFinderFeed, i2, i3, z, list);
        cjl cjl = (cjl) j.ks(baseFinderFeed.feedObject.getMediaList());
        ImageView imageView = (ImageView) hVar.Mn(R.id.imb);
        if (Util.isNullOrNil(cjl.coverUrl)) {
            k kVar = new k(cjl, x.THUMB_IMAGE, null, null, 12);
            m mVar = m.uJa;
            com.tencent.mm.loader.d<o> djY = m.djY();
            m mVar2 = m.uJa;
            b<o, Bitmap> a2 = djY.a(kVar, m.a(m.a.TIMELINE));
            c cVar = c.vCb;
            if (c.dtK().value().intValue() > 0) {
                dVar2 = new d(null, new g(imageView), 1);
            } else {
                dVar2 = null;
            }
            com.tencent.mm.loader.b<o, Bitmap> a3 = a2.a(dVar2);
            p.g(imageView, "thumbIv");
            a3.c(imageView);
            AppMethodBeat.o(243376);
            return;
        }
        q qVar = new q(cjl, x.FULL_IMAGE);
        m mVar3 = m.uJa;
        com.tencent.mm.loader.d<o> djY2 = m.djY();
        m mVar4 = m.uJa;
        b<o, Bitmap> a4 = djY2.a(qVar, m.a(m.a.TIMELINE));
        c cVar2 = c.vCb;
        if (c.dtK().value().intValue() > 0) {
            dVar = new d(null, new g(imageView), 1);
        } else {
            dVar = null;
        }
        com.tencent.mm.loader.b<o, Bitmap> a5 = a4.a(dVar);
        p.g(imageView, "thumbIv");
        a5.c(imageView);
        AppMethodBeat.o(243376);
    }
}
