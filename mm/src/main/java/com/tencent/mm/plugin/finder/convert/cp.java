package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.loader.q;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J@\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/NearbyVideoFeedConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "()V", "screenWidth", "", "getScreenWidth", "()I", "screenWidth$delegate", "Lkotlin/Lazy;", "bindLive", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
public class cp extends ae {
    private final f tCY = g.ah(a.tHj);

    public cp() {
        super(R.layout.ab4);
        AppMethodBeat.i(243392);
        AppMethodBeat.o(243392);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.plugin.finder.convert.ae, com.tencent.mm.view.recyclerview.e
    public /* bridge */ /* synthetic */ void a(h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(243391);
        a(hVar, baseFinderFeed, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(243391);
    }

    @Override // com.tencent.mm.plugin.finder.convert.ae
    public void a(h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List<Object> list) {
        cjl cjl;
        String str;
        Integer num;
        AppMethodBeat.i(243390);
        p.h(hVar, "holder");
        p.h(baseFinderFeed, "item");
        super.a(hVar, baseFinderFeed, i2, i3, z, list);
        if (baseFinderFeed.feedObject.isLiveFeed()) {
            cjl = (cjl) j.ks(baseFinderFeed.feedObject.getLiveMediaList());
        } else {
            cjl = (cjl) j.ks(baseFinderFeed.feedObject.getMediaList());
        }
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
        if (Util.isNullOrNil(cjl.coverUrl)) {
            k kVar = new k(cjl, x.THUMB_IMAGE, null, null, 12);
            m mVar = m.uJa;
            d<o> djY = m.djY();
            m mVar2 = m.uJa;
            djY.a(kVar, imageView, m.a(m.a.TIMELINE));
        } else {
            q qVar = new q(cjl, x.FULL_IMAGE);
            m mVar3 = m.uJa;
            d<o> djY2 = m.djY();
            m mVar4 = m.uJa;
            djY2.a(qVar, imageView, m.a(m.a.TIMELINE));
        }
        ImageView imageView2 = (ImageView) hVar.Mn(R.id.imb);
        String str2 = cjl.coverUrl;
        if (str2 == null) {
            str2 = "";
        }
        p.g(str2, "localFinderMedia.coverUrl ?: \"\"");
        if (Util.isNullOrNil(str2)) {
            str = p.I(cjl.thumbUrl, Util.nullAsNil(cjl.thumb_url_token));
        } else {
            str = str2;
        }
        FinderLiveOnliveWidget finderLiveOnliveWidget = (FinderLiveOnliveWidget) hVar.Mn(R.id.cud);
        View Mn = hVar.Mn(R.id.cw_);
        TextView textView = (TextView) hVar.Mn(R.id.cl2);
        if (baseFinderFeed.feedObject.isLiveFeed()) {
            awe liveInfo = baseFinderFeed.feedObject.getLiveInfo();
            if (liveInfo == null || liveInfo.liveStatus != 1) {
                com.tencent.mm.plugin.finder.utils.m mVar5 = com.tencent.mm.plugin.finder.utils.m.vVH;
                p.g(imageView2, "thumbIv");
                com.tencent.mm.plugin.finder.utils.m.h(imageView2, str);
                p.g(finderLiveOnliveWidget, "liveFinishView");
                finderLiveOnliveWidget.setVisibility(0);
                p.g(Mn, "onliveWidget");
                Mn.setVisibility(8);
            } else {
                m mVar6 = m.uJa;
                d<o> djY3 = m.djY();
                com.tencent.mm.plugin.finder.loader.p pVar = new com.tencent.mm.plugin.finder.loader.p(str, x.FULL_IMAGE);
                p.g(imageView2, "thumbIv");
                m mVar7 = m.uJa;
                djY3.a(pVar, imageView2, m.a(m.a.TIMELINE));
                p.g(finderLiveOnliveWidget, "liveFinishView");
                finderLiveOnliveWidget.setVisibility(8);
                p.g(Mn, "onliveWidget");
                Mn.setVisibility(0);
                p.g(textView, "desc");
                textView.setVisibility(8);
            }
        } else {
            p.g(finderLiveOnliveWidget, "liveFinishView");
            finderLiveOnliveWidget.setVisibility(8);
            p.g(Mn, "onliveWidget");
            Mn.setVisibility(8);
        }
        StringBuilder append = new StringBuilder("mediaType:").append(baseFinderFeed.feedObject.getMediaType()).append(",liveStatus:");
        awe liveInfo2 = baseFinderFeed.feedObject.getLiveInfo();
        if (liveInfo2 != null) {
            num = Integer.valueOf(liveInfo2.liveStatus);
        } else {
            num = null;
        }
        StringBuilder append2 = append.append(num).append(",contact liveStatus:");
        FinderContact refObjectContact = baseFinderFeed.feedObject.getRefObjectContact();
        Log.i("FinderFeedVideoRoundCornerConvert", append2.append((refObjectContact != null ? Integer.valueOf(refObjectContact.liveStatus) : null).intValue()).toString());
        AppMethodBeat.o(243390);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        public static final a tHj = new a();

        static {
            AppMethodBeat.i(243389);
            AppMethodBeat.o(243389);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(243388);
            Integer valueOf = Integer.valueOf(au.az(MMApplicationContext.getContext()).x);
            AppMethodBeat.o(243388);
            return valueOf;
        }
    }
}
