package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.loader.q;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J \u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J \u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J \u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0016J \u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J@\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0016J \u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020(2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0005H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/NearbyLiveFeedsConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "()V", "screenWidth", "", "getScreenWidth", "()I", "screenWidth$delegate", "Lkotlin/Lazy;", "bindCover", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "item", "bindDesc", "bindLive", "localFinderMedia", "feed", "bindUserInfo", "getLayoutId", "jumpProfile", "context", "Landroid/content/Context;", "feedId", "", ch.COL_USERNAME, "", "onBindViewHolder", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public class co extends e<BaseFinderFeed> {
    private final f tCY = g.ah(c.tHi);

    public co() {
        AppMethodBeat.i(243386);
        AppMethodBeat.o(243386);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public /* bridge */ /* synthetic */ void a(h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(243385);
        a(hVar, baseFinderFeed, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(243385);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.bez;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243383);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        AppMethodBeat.o(243383);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class a implements View.OnClickListener {
        final /* synthetic */ h qhp;
        final /* synthetic */ BaseFinderFeed tAr;
        final /* synthetic */ co tHh;

        a(co coVar, h hVar, BaseFinderFeed baseFinderFeed) {
            this.tHh = coVar;
            this.qhp = hVar;
            this.tAr = baseFinderFeed;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243379);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/NearbyLiveFeedsConvert$bindUserInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Context context = this.qhp.getContext();
            p.g(context, "holder.context");
            this.tAr.lT();
            co.aB(context, this.tAr.feedObject.getUserName());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/NearbyLiveFeedsConvert$bindUserInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243379);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ h qhp;
        final /* synthetic */ BaseFinderFeed tAr;
        final /* synthetic */ co tHh;

        b(co coVar, h hVar, BaseFinderFeed baseFinderFeed) {
            this.tHh = coVar;
            this.qhp = hVar;
            this.tAr = baseFinderFeed;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243380);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/NearbyLiveFeedsConvert$bindUserInfo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Context context = this.qhp.getContext();
            p.g(context, "holder.context");
            this.tAr.lT();
            co.aB(context, this.tAr.feedObject.getUserName());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/NearbyLiveFeedsConvert$bindUserInfo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243380);
        }
    }

    public void a(h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List<Object> list) {
        cjl cjl;
        int a2;
        String str;
        Integer num;
        AppMethodBeat.i(243384);
        p.h(hVar, "holder");
        p.h(baseFinderFeed, "item");
        if (baseFinderFeed.feedObject.isLiveFeed()) {
            cjl = (cjl) j.ks(baseFinderFeed.feedObject.getLiveMediaList());
        } else {
            cjl = (cjl) j.ks(baseFinderFeed.feedObject.getMediaList());
        }
        ImageView imageView = (ImageView) hVar.Mn(R.id.cka);
        m mVar = m.uJa;
        d<o> dka = m.dka();
        com.tencent.mm.plugin.finder.api.g gVar = baseFinderFeed.contact;
        com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(Util.nullAsNil(gVar != null ? gVar.cXH() : null));
        p.g(imageView, "avatar");
        m mVar2 = m.uJa;
        dka.a(aVar, imageView, m.a(m.a.AVATAR));
        imageView.setOnClickListener(new a(this, hVar, baseFinderFeed));
        TextView textView = (TextView) hVar.Mn(R.id.d0q);
        TextView textView2 = (TextView) hVar.Mn(R.id.cl2);
        p.g(textView, "nickname");
        textView.setText(baseFinderFeed.feedObject.getNickNameSpan());
        p.g(textView2, "desc");
        ao.a(textView2.getPaint(), 0.8f);
        ao.a(textView.getPaint(), 0.8f);
        textView.setOnClickListener(new b(this, hVar, baseFinderFeed));
        com.tencent.mm.plugin.finder.api.g gVar2 = baseFinderFeed.contact;
        if (gVar2 != null) {
            y yVar = y.vXH;
            View Mn = hVar.Mn(R.id.w0);
            p.g(Mn, "holder.getView<ImageView>(R.id.auth_icon)");
            y.a((ImageView) Mn, gVar2.field_authInfo);
        }
        TextView textView3 = (TextView) hVar.Mn(R.id.cl2);
        if (!Util.isNullOrNil(baseFinderFeed.feedObject.getDescription())) {
            p.g(textView3, "descTv");
            textView3.setVisibility(0);
            textView3.setText(baseFinderFeed.feedObject.getDescriptionSpan());
        } else {
            p.g(textView3, "descTv");
            textView3.setVisibility(8);
        }
        ImageView imageView2 = (ImageView) hVar.Mn(R.id.imb);
        p.g(imageView2, "thumbIv");
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        int intValue = ((Number) this.tCY.getValue()).intValue();
        Context context = hVar.getContext();
        p.g(context, "holder.context");
        int dimension = (intValue - ((int) context.getResources().getDimension(R.dimen.a4k))) / 2;
        if (baseFinderFeed.feedObject.isLiveFeed()) {
            a2 = (int) (1.3317f * ((float) dimension));
        } else {
            y yVar2 = y.vXH;
            a2 = y.a(baseFinderFeed, cjl, dimension);
        }
        if (a2 > 0) {
            layoutParams.width = dimension;
            layoutParams.height = a2;
            imageView2.setLayoutParams(layoutParams);
        }
        if (Util.isNullOrNil(cjl.coverUrl)) {
            k kVar = new k(cjl, x.THUMB_IMAGE, null, null, 12);
            m mVar3 = m.uJa;
            d<o> djY = m.djY();
            m mVar4 = m.uJa;
            djY.a(kVar, imageView2, m.a(m.a.TIMELINE));
            Log.i("NearbyLiveFeedsConvert", "name:" + ((Object) baseFinderFeed.feedObject.getNickNameSpan()) + " videoThumb:" + kVar.aBE());
        } else {
            q qVar = new q(cjl, x.FULL_IMAGE);
            m mVar5 = m.uJa;
            d<o> djY2 = m.djY();
            m mVar6 = m.uJa;
            djY2.a(qVar, imageView2, m.a(m.a.TIMELINE));
            Log.i("NearbyLiveFeedsConvert", "name:" + ((Object) baseFinderFeed.feedObject.getNickNameSpan()) + " videoCover:" + qVar.aBE());
        }
        ImageView imageView3 = (ImageView) hVar.Mn(R.id.imb);
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
        View Mn2 = hVar.Mn(R.id.cw9);
        TextView textView4 = (TextView) hVar.Mn(R.id.cl2);
        if (baseFinderFeed.feedObject.isLiveFeed()) {
            awe liveInfo = baseFinderFeed.feedObject.getLiveInfo();
            if (liveInfo == null || liveInfo.liveStatus != 1) {
                com.tencent.mm.plugin.finder.utils.m mVar7 = com.tencent.mm.plugin.finder.utils.m.vVH;
                p.g(imageView3, "thumbIv");
                com.tencent.mm.plugin.finder.utils.m.h(imageView3, str);
                p.g(finderLiveOnliveWidget, "liveFinishView");
                finderLiveOnliveWidget.setVisibility(0);
                p.g(Mn2, "onLiveWidgetLayout");
                Mn2.setVisibility(8);
            } else {
                m mVar8 = m.uJa;
                d<o> djY3 = m.djY();
                com.tencent.mm.plugin.finder.loader.p pVar = new com.tencent.mm.plugin.finder.loader.p(str, x.FULL_IMAGE);
                p.g(imageView3, "thumbIv");
                m mVar9 = m.uJa;
                djY3.a(pVar, imageView3, m.a(m.a.TIMELINE));
                p.g(finderLiveOnliveWidget, "liveFinishView");
                finderLiveOnliveWidget.setVisibility(8);
                p.g(Mn2, "onLiveWidgetLayout");
                Mn2.setVisibility(0);
                p.g(textView4, "desc");
                textView4.setVisibility(8);
            }
        } else {
            p.g(finderLiveOnliveWidget, "liveFinishView");
            finderLiveOnliveWidget.setVisibility(8);
            p.g(Mn2, "onLiveWidgetLayout");
            Mn2.setVisibility(8);
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
        Log.i("FinderFeedVideoLiveFriendsConvert", append2.append((refObjectContact != null ? Integer.valueOf(refObjectContact.liveStatus) : null).intValue()).toString());
        AppMethodBeat.o(243384);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        public static final c tHi = new c();

        static {
            AppMethodBeat.i(243382);
            AppMethodBeat.o(243382);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(243381);
            Integer valueOf = Integer.valueOf(au.az(MMApplicationContext.getContext()).x);
            AppMethodBeat.o(243381);
            return valueOf;
        }
    }

    public static final /* synthetic */ void aB(Context context, String str) {
        AppMethodBeat.i(243387);
        Intent intent = new Intent();
        com.tencent.mm.plugin.finder.nearby.report.d dVar = com.tencent.mm.plugin.finder.nearby.report.d.uTq;
        intent.putExtra("key_click_tab_context_id", com.tencent.mm.plugin.finder.nearby.report.d.dlA());
        intent.putExtra("finder_username", str);
        com.tencent.mm.plugin.finder.nearby.report.d dVar2 = com.tencent.mm.plugin.finder.nearby.report.d.uTq;
        ((aj) com.tencent.mm.kernel.g.ah(aj.class)).fillContextIdToIntent(com.tencent.mm.plugin.finder.nearby.report.d.acj(), intent);
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(context, intent);
        AppMethodBeat.o(243387);
    }
}
