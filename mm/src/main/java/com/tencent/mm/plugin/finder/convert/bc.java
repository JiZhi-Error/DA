package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.cl;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.FinderTopicTimelineUIContract;
import com.tencent.mm.plugin.finder.feed.aj;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.q;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.plugin.finder.storage.o;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.atv;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0002J@\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0016J\"\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020\u000bH\u0002J \u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J \u0010*\u001a\u00020\r2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "ratio", "", "getLayoutId", "", "initAuthIcon", "", "authIcon", "Landroid/widget/ImageView;", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "loadUrl", "iconUrl", "", "iconIv", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onClickReport", "clickType", "", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "feedIndex", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "setIcon", "plugin-finder_release"})
public final class bc extends e<c> {
    private final float tEJ = 1.1666666f;
    private final aj.a<c> tEK;

    public bc(aj.a<c> aVar) {
        p.h(aVar, "presenter");
        AppMethodBeat.i(243182);
        this.tEK = aVar;
        AppMethodBeat.o(243182);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, c cVar, int i2, int i3, boolean z, List list) {
        String str;
        String str2;
        AppMethodBeat.i(243180);
        c cVar2 = cVar;
        p.h(hVar, "holder");
        p.h(cVar2, "item");
        o oVar = cVar2.uNJ.vEF;
        if (oVar == null) {
            AppMethodBeat.o(243180);
            return;
        }
        ImageView imageView = (ImageView) hVar.Mn(R.id.hfu);
        TextView textView = (TextView) hVar.Mn(R.id.hg7);
        TextView textView2 = (TextView) hVar.Mn(R.id.hg6);
        TextView textView3 = (TextView) hVar.Mn(R.id.hfs);
        View Mn = hVar.Mn(R.id.hg5);
        p.g(imageView, "iconIv");
        imageView.setVisibility(0);
        switch (oVar.dxE().jjN) {
            case 1:
                Context context = hVar.getContext();
                Context context2 = hVar.getContext();
                p.g(context2, "holder.context");
                imageView.setImageDrawable(ar.m(context, R.raw.icons_filled_me, context2.getResources().getColor(R.color.BW_70)));
                break;
            case 2:
                Context context3 = hVar.getContext();
                Context context4 = hVar.getContext();
                p.g(context4, "holder.context");
                imageView.setImageDrawable(ar.m(context3, R.raw.icons_filled_location, context4.getResources().getColor(R.color.BW_70)));
                break;
            case 3:
                Context context5 = hVar.getContext();
                Context context6 = hVar.getContext();
                p.g(context6, "holder.context");
                imageView.setImageDrawable(ar.m(context5, R.raw.finder_filled_fire, context6.getResources().getColor(R.color.BW_70)));
                break;
            case 4:
                if (ao.isDarkMode()) {
                    str = oVar.dxE().Kib;
                    if (str == null) {
                        str = "";
                    }
                } else {
                    str = oVar.dxE().LLq;
                    if (str == null) {
                        str = "";
                    }
                }
                if (Util.isNullOrNil(str)) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setVisibility(0);
                }
                cjl cjl = new cjl();
                cjl.mediaId = MD5Util.getMD5String(str);
                cjl.url = str;
                cjl.thumbUrl = str;
                k kVar = new k(cjl, x.THUMB_IMAGE, null, null, 12);
                m mVar = m.uJa;
                m.djY().bQ(kVar).c(imageView);
                break;
            case 5:
                Context context7 = hVar.getContext();
                Context context8 = hVar.getContext();
                p.g(context8, "holder.context");
                imageView.setImageDrawable(ar.m(context7, R.raw.finder_icons_filled_topic, context8.getResources().getColor(R.color.BW_70)));
                break;
            case 6:
                Context context9 = hVar.getContext();
                Context context10 = hVar.getContext();
                p.g(context10, "holder.context");
                imageView.setImageDrawable(ar.m(context9, R.raw.finder_icons_filled_sight, context10.getResources().getColor(R.color.BW_70)));
                break;
            case 7:
                Context context11 = hVar.getContext();
                Context context12 = hVar.getContext();
                p.g(context12, "holder.context");
                imageView.setImageDrawable(ar.m(context11, R.raw.finder_icons_filled_food, context12.getResources().getColor(R.color.BW_70)));
                break;
            case 8:
            default:
                imageView.setVisibility(8);
                break;
            case 9:
                Context context13 = hVar.getContext();
                Context context14 = hVar.getContext();
                p.g(context14, "holder.context");
                imageView.setImageDrawable(ar.m(context13, R.raw.icons_filled_nearby, context14.getResources().getColor(R.color.BW_70)));
                break;
        }
        p.g(textView, "titleTv");
        ao.a(textView.getPaint(), 0.8f);
        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(hVar.getContext(), oVar.cxc()));
        if (Util.isNullOrNil(oVar.dxH())) {
            p.g(textView2, "subTv");
            textView2.setVisibility(8);
        } else {
            p.g(textView2, "subTv");
            textView2.setVisibility(0);
            textView2.setText(oVar.dxH());
        }
        if (Util.isNullOrNil(oVar.dxG())) {
            p.g(textView3, "descTv");
            textView3.setVisibility(8);
        } else {
            p.g(textView3, "descTv");
            textView3.setVisibility(0);
            textView3.setText(oVar.dxG());
        }
        if (!z) {
            ArrayList<View> arrayList = new ArrayList();
            arrayList.clear();
            View Mn2 = hVar.Mn(R.id.hg0);
            p.g(Mn2, "holder.getView(R.id.section_item_bottom_feed_1)");
            arrayList.add(Mn2);
            View Mn3 = hVar.Mn(R.id.hg1);
            p.g(Mn3, "holder.getView(R.id.section_item_bottom_feed_2)");
            arrayList.add(Mn3);
            View Mn4 = hVar.Mn(R.id.hg2);
            p.g(Mn4, "holder.getView(R.id.section_item_bottom_feed_3)");
            arrayList.add(Mn4);
            Context context15 = hVar.getContext();
            p.g(context15, "holder.context");
            Resources resources = context15.getResources();
            p.g(resources, "holder.context.resources");
            int fromDPToPix = (resources.getDisplayMetrics().widthPixels - com.tencent.mm.cb.a.fromDPToPix(hVar.getContext(), 32)) / 3;
            int i4 = (int) (((float) fromDPToPix) * this.tEJ);
            for (View view : arrayList) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = fromDPToPix;
                layoutParams.height = i4;
                view.setLayoutParams(layoutParams);
                view.setVisibility(8);
            }
            int i5 = 0;
            for (Object obj : arrayList) {
                int i6 = i5 + 1;
                if (i5 < 0) {
                    j.hxH();
                }
                View view2 = (View) obj;
                if (i5 >= oVar.vDZ.size()) {
                    view2.setVisibility(8);
                    i5 = i6;
                } else {
                    view2.setVisibility(0);
                    ImageView imageView2 = (ImageView) view2.findViewById(R.id.hg4);
                    ImageView imageView3 = (ImageView) view2.findViewById(R.id.hfw);
                    TextView textView4 = (TextView) view2.findViewById(R.id.hg3);
                    ImageView imageView4 = (ImageView) view2.findViewById(R.id.hfv);
                    BaseFinderFeed baseFinderFeed = oVar.vDZ.get(i5);
                    p.g(baseFinderFeed, "lbsItem.feedList[index]");
                    BaseFinderFeed baseFinderFeed2 = baseFinderFeed;
                    cjl cjl2 = (cjl) j.kt(baseFinderFeed2.feedObject.getMediaList());
                    imageView2.setImageResource(R.color.BW_97);
                    if (cjl2 != null) {
                        if (cjl2.mediaType != 4) {
                            m mVar2 = m.uJa;
                            d<com.tencent.mm.plugin.finder.loader.o> djY = m.djY();
                            k kVar2 = new k(cjl2, x.THUMB_IMAGE, null, null, 12);
                            p.g(imageView2, "thumbIv");
                            m mVar3 = m.uJa;
                            djY.a(kVar2, imageView2, m.a(m.a.TIMELINE));
                        } else if (Util.isNullOrNil(cjl2.coverUrl)) {
                            k kVar3 = new k(cjl2, x.THUMB_IMAGE, null, null, 12);
                            m mVar4 = m.uJa;
                            d<com.tencent.mm.plugin.finder.loader.o> djY2 = m.djY();
                            p.g(imageView2, "thumbIv");
                            m mVar5 = m.uJa;
                            djY2.a(kVar3, imageView2, m.a(m.a.TIMELINE));
                        } else {
                            q qVar = new q(cjl2, x.FULL_IMAGE);
                            m mVar6 = m.uJa;
                            d<com.tencent.mm.plugin.finder.loader.o> djY3 = m.djY();
                            p.g(imageView2, "thumbIv");
                            m mVar7 = m.uJa;
                            djY3.a(qVar, imageView2, m.a(m.a.TIMELINE));
                        }
                    }
                    FinderContact finderContact = baseFinderFeed2.feedObject.getFeedObject().contact;
                    imageView3.setImageResource(R.color.BW_97);
                    m mVar8 = m.uJa;
                    d<com.tencent.mm.plugin.finder.loader.o> dka = m.dka();
                    if (finderContact == null || (str2 = finderContact.headUrl) == null) {
                        str2 = "";
                    }
                    com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(str2);
                    p.g(imageView3, "avatarIv");
                    m mVar9 = m.uJa;
                    dka.a(aVar, imageView3, m.a(m.a.AVATAR));
                    p.g(textView4, "nicknameTv");
                    SpannableString nickNameSpan = baseFinderFeed2.feedObject.getNickNameSpan();
                    textView4.setText(nickNameSpan != null ? nickNameSpan : "");
                    p.g(imageView4, "authIcon");
                    imageView4.setVisibility(8);
                    FinderAuthInfo finderAuthInfo = finderContact != null ? finderContact.authInfo : null;
                    if (finderAuthInfo != null) {
                        y yVar = y.vXH;
                        y.a(imageView4, finderAuthInfo);
                    }
                    view2.setOnClickListener(new a(i5, view2, baseFinderFeed2, this, oVar, hVar));
                    i5 = i6;
                }
            }
        }
        if (oVar.dxE().LLo == 0) {
            p.g(Mn, "moreBtn");
            Mn.setVisibility(8);
        }
        hVar.Mn(R.id.hft).setOnClickListener(new b(this, oVar, hVar));
        AppMethodBeat.o(243180);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.ach;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243179);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        AppMethodBeat.o(243179);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$1$1"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ int puW;
        final /* synthetic */ View tEL;
        final /* synthetic */ BaseFinderFeed tEM;
        final /* synthetic */ bc tEN;
        final /* synthetic */ o tEO;
        final /* synthetic */ h tzq;

        a(int i2, View view, BaseFinderFeed baseFinderFeed, bc bcVar, o oVar, h hVar) {
            this.puW = i2;
            this.tEL = view;
            this.tEM = baseFinderFeed;
            this.tEN = bcVar;
            this.tEO = oVar;
            this.tzq = hVar;
        }

        public final void onClick(View view) {
            String str;
            AppMethodBeat.i(243177);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            switch (this.tEO.dxE().LLo) {
                case 1:
                case 2:
                    intent.putExtra("UI_TITLE", this.tEO.cxc());
                    atp dxJ = this.tEO.dxJ();
                    ato ato = new ato();
                    ato.lastBuffer = dxJ.lastBuffer;
                    ato.dLS = 2;
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
                    kotlin.o<Float, Float> dHP = FinderGlobalLocationVM.dHP();
                    ato.dTj = dHP.first.floatValue();
                    ato.latitude = dHP.second.floatValue();
                    ato.tvs = this.tEO.dxE();
                    y yVar = y.vXH;
                    y.a(this.puW, this.tEO.vDZ, dxJ.lastBuffer, intent);
                    intent.putExtra("KEY_TITLE", this.tEO.cxc());
                    intent.putExtra("KEY_REQUEST_PB", ato.toByteArray());
                    intent.putExtra("KEY_MORE_ACTION_TYPE", this.tEO.dxE().LLo);
                    FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                    Context context = this.tEL.getContext();
                    p.g(context, "feedView.context");
                    FinderReporterUIC.a.a(context, intent, 0, 0, false, 124);
                    com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                    Context context2 = this.tEL.getContext();
                    p.g(context2, "feedView.context");
                    com.tencent.mm.plugin.finder.utils.a.S(context2, intent);
                    break;
                case 3:
                case 4:
                    atv dxI = this.tEO.dxI();
                    BaseFinderFeed baseFinderFeed = (BaseFinderFeed) j.kt(this.tEO.vDZ);
                    if (baseFinderFeed != null) {
                        Intent intent2 = new Intent();
                        if (this.tEO.dxE().LLo == 4) {
                            intent2.putExtra("key_topic_type", 2);
                            intent2.putExtra("KEY_FINDER_LOCATION", baseFinderFeed.feedObject.getLocation().toByteArray());
                        } else {
                            intent2.putExtra("key_topic_type", 1);
                        }
                        bds bds = dxI.LEG;
                        if (bds == null || (str = bds.dST) == null) {
                            str = "";
                        }
                        intent2.putExtra("key_topic_title", str);
                        intent2.putExtra("key_ref_object_id", 0);
                        intent2.putExtra("KEY_CLICK_FEED_ID", this.tEM.feedObject.getId());
                        intent2.putExtra("KEY_CLICK_FEED_POSITION", this.puW);
                        y yVar2 = y.vXH;
                        y.a(this.puW, this.tEO.vDZ, dxI.lastBuffer, intent2, new FinderTopicTimelineUIContract.c(null, dxI.lastBuffer));
                        intent2.putExtra("KEY_SECTION_INFO", this.tEO.dxE().toByteArray());
                        FinderReporterUIC.a aVar4 = FinderReporterUIC.wzC;
                        Context context3 = this.tzq.getContext();
                        p.g(context3, "holder.context");
                        FinderReporterUIC.a.a(context3, intent2, 0, 0, false, 124);
                        com.tencent.mm.plugin.finder.utils.a aVar5 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        Context context4 = this.tzq.getContext();
                        p.g(context4, "holder.context");
                        com.tencent.mm.plugin.finder.utils.a.P(context4, intent2);
                        break;
                    }
                    break;
            }
            this.tEN.a(2, this.tEO, this.puW);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243177);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ h qhp;
        final /* synthetic */ bc tEN;
        final /* synthetic */ o tEP;

        b(bc bcVar, o oVar, h hVar) {
            this.tEN = bcVar;
            this.tEP = oVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            String str;
            AppMethodBeat.i(243178);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            switch (this.tEP.dxE().LLo) {
                case 1:
                case 2:
                    intent.putExtra("UI_TITLE", this.tEP.cxc());
                    atp dxJ = this.tEP.dxJ();
                    ato ato = new ato();
                    ato.lastBuffer = dxJ.lastBuffer;
                    ato.dLS = 2;
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
                    kotlin.o<Float, Float> dHP = FinderGlobalLocationVM.dHP();
                    ato.dTj = dHP.first.floatValue();
                    ato.latitude = dHP.second.floatValue();
                    ato.tvs = this.tEP.dxE();
                    y yVar = y.vXH;
                    y.a(0, this.tEP.vDZ, dxJ.lastBuffer, intent);
                    intent.putExtra("SECTION_REQ", ato.toByteArray());
                    intent.putExtra("SECTION_FIRST_RSP", dxJ.toByteArray());
                    intent.putExtra("KEY_MORE_ACTION_TYPE", this.tEP.dxE().LLo);
                    FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                    Context context = this.qhp.getContext();
                    p.g(context, "holder.context");
                    FinderReporterUIC.a.a(context, intent, 0, 0, false, 124);
                    com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                    Context context2 = this.qhp.getContext();
                    p.g(context2, "holder.context");
                    com.tencent.mm.plugin.finder.utils.a.R(context2, intent);
                    break;
                case 3:
                case 4:
                    atv dxI = this.tEP.dxI();
                    BaseFinderFeed baseFinderFeed = (BaseFinderFeed) j.kt(this.tEP.vDZ);
                    if (baseFinderFeed != null) {
                        Intent intent2 = new Intent();
                        if (this.tEP.dxE().LLo == 4) {
                            intent2.putExtra("key_topic_type", 2);
                            intent2.putExtra("key_topic_poi_location", baseFinderFeed.feedObject.getLocation().toByteArray());
                        } else {
                            intent2.putExtra("key_topic_type", 1);
                        }
                        bds bds = dxI.LEG;
                        if (bds == null || (str = bds.dST) == null) {
                            str = "";
                        }
                        intent2.putExtra("key_topic_title", str);
                        intent2.putExtra("key_ref_object_id", 0);
                        y yVar2 = y.vXH;
                        y.a(0, this.tEP.vDZ, dxI.lastBuffer, intent2, new FinderTopicTimelineUIContract.c(null, dxI.lastBuffer));
                        intent2.putExtra("KEY_SECTION_INFO", this.tEP.dxE().toByteArray());
                        intent2.putExtra("KEY_TOPIC_RSP", dxI.toByteArray());
                        FinderReporterUIC.a aVar4 = FinderReporterUIC.wzC;
                        Context context3 = this.qhp.getContext();
                        p.g(context3, "holder.context");
                        FinderReporterUIC.a.a(context3, intent2, 0, 0, false, 124);
                        com.tencent.mm.plugin.finder.utils.a aVar5 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        Context context4 = this.qhp.getContext();
                        p.g(context4, "holder.context");
                        com.tencent.mm.plugin.finder.utils.a.O(context4, intent2);
                        break;
                    }
                    break;
            }
            this.tEN.a(1, this.tEP, -1);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderMixLbsSectionFeedConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243178);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(long j2, o oVar, int i2) {
        AppMethodBeat.i(243181);
        cl clVar = new cl();
        clVar.gw(j2);
        clVar.gx(com.tencent.mm.model.cl.aWA());
        this.tEK.a(clVar, oVar, i2);
        AppMethodBeat.o(243181);
    }
}
