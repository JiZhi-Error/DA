package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J@\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageRoundCornerConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "()V", "screenWidth", "", "getScreenWidth", "()I", "screenWidth$delegate", "Lkotlin/Lazy;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
public class v extends ae {
    private final f tCY = g.ah(a.tCZ);

    public v() {
        super(R.layout.ab4);
        AppMethodBeat.i(243024);
        AppMethodBeat.o(243024);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.plugin.finder.convert.ae, com.tencent.mm.view.recyclerview.e
    public /* bridge */ /* synthetic */ void a(h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(165397);
        a(hVar, baseFinderFeed, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(165397);
    }

    @Override // com.tencent.mm.plugin.finder.convert.ae
    public void a(h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List<Object> list) {
        AppMethodBeat.i(165396);
        p.h(hVar, "holder");
        p.h(baseFinderFeed, "item");
        super.a(hVar, baseFinderFeed, i2, i3, z, list);
        cjl cjl = (cjl) j.ks(baseFinderFeed.feedObject.getMediaList());
        ImageView imageView = (ImageView) hVar.Mn(R.id.imb);
        p.g(imageView, "thumbIv");
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int intValue = ((Number) this.tCY.getValue()).intValue();
        Context context = hVar.getContext();
        p.g(context, "holder.context");
        int dimension = (intValue - ((int) context.getResources().getDimension(R.dimen.c5))) / 2;
        y yVar = y.vXH;
        int a2 = y.a(baseFinderFeed, cjl, dimension);
        if (a2 > 0) {
            layoutParams.width = dimension;
            layoutParams.height = a2;
            imageView.setLayoutParams(layoutParams);
        }
        m mVar = m.uJa;
        d<o> djY = m.djY();
        k kVar = new k(cjl, x.THUMB_IMAGE, null, null, 12);
        m mVar2 = m.uJa;
        djY.a(kVar, imageView, m.a(m.a.TIMELINE));
        ImageIndicatorView imageIndicatorView = (ImageIndicatorView) hVar.Mn(R.id.dvx);
        if (imageIndicatorView != null) {
            imageIndicatorView.setVisibility(0);
        }
        if (imageIndicatorView != null) {
            imageIndicatorView.aan(baseFinderFeed.feedObject.getMediaList().size());
        }
        j(hVar, baseFinderFeed);
        if (!y(baseFinderFeed) || imageIndicatorView == null) {
            AppMethodBeat.o(165396);
            return;
        }
        Context context2 = hVar.getContext();
        p.g(context2, "holder.context");
        imageIndicatorView.setBackgroundColor(context2.getResources().getColor(R.color.agp));
        AppMethodBeat.o(165396);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<Integer> {
        public static final a tCZ = new a();

        static {
            AppMethodBeat.i(243023);
            AppMethodBeat.o(243023);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(243022);
            Integer valueOf = Integer.valueOf(au.az(MMApplicationContext.getContext()).x);
            AppMethodBeat.o(243022);
            return valueOf;
        }
    }
}
