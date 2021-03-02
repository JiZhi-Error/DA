package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.d.b;
import com.tencent.mm.plugin.fav.ui.f;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/fav/ui/listitem/FavFinderListItem;", "Lcom/tencent/mm/plugin/fav/ui/listitem/FavBaseListItem;", "imageServer", "Lcom/tencent/mm/plugin/fav/ui/FavoriteImageServer;", "(Lcom/tencent/mm/plugin/fav/ui/FavoriteImageServer;)V", "ITEM_SIZE", "", "getITEM_SIZE", "()I", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "itemInfo", "Lcom/tencent/mm/plugin/fav/api/FavItemInfo;", "onListItemClick", "", "view", "favReportInfo", "Lcom/tencent/mm/protocal/protobuf/FavReportInfo;", "FavFinderHolder", "ui-fav_release"})
public final class e extends b {
    private final int tlc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(o oVar) {
        super(oVar);
        p.h(oVar, "imageServer");
        AppMethodBeat.i(164112);
        this.tlc = com.tencent.mm.cb.a.aG(oVar.getContext(), R.dimen.e9);
        AppMethodBeat.o(164112);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/fav/ui/listitem/FavFinderListItem$FavFinderHolder;", "Lcom/tencent/mm/plugin/fav/ui/listitem/FavBaseListItem$FavBaseHolder;", "(Lcom/tencent/mm/plugin/fav/ui/listitem/FavFinderListItem;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "imageIV", "Landroid/widget/ImageView;", "getImageIV", "()Landroid/widget/ImageView;", "setImageIV", "(Landroid/widget/ImageView;)V", "tagIv", "getTagIv", "setTagIv", "titleTv", "getTitleTv", "setTitleTv", "ui-fav_release"})
    public final class a extends b.C1049b {
        TextView hPW;
        TextView titleTv;
        ImageView tlo;
        ImageView tlp;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final View a(View view, ViewGroup viewGroup, g gVar) {
        a aVar;
        anb anb;
        bcj guk;
        ImageView imageView;
        TextView textView;
        Object obj = null;
        AppMethodBeat.i(164110);
        Context context = viewGroup != null ? viewGroup.getContext() : null;
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, R.layout.a7f, null), aVar, gVar);
            View findViewById = view.findViewById(R.id.ccr);
            if (findViewById == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.ImageView");
                AppMethodBeat.o(164110);
                throw tVar;
            }
            aVar.tlo = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.ccx);
            if (findViewById2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.widget.TextView");
                AppMethodBeat.o(164110);
                throw tVar2;
            }
            aVar.titleTv = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.ccs);
            if (findViewById3 == null) {
                t tVar3 = new t("null cannot be cast to non-null type android.widget.TextView");
                AppMethodBeat.o(164110);
                throw tVar3;
            }
            aVar.hPW = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.cmh);
            if (findViewById4 == null) {
                t tVar4 = new t("null cannot be cast to non-null type android.widget.ImageView");
                AppMethodBeat.o(164110);
                throw tVar4;
            }
            aVar.tlp = (ImageView) findViewById4;
        } else {
            if (view != null) {
                obj = view.getTag();
            }
            if (obj == null) {
                t tVar5 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.fav.ui.listitem.FavFinderListItem.FavFinderHolder");
                AppMethodBeat.o(164110);
                throw tVar5;
            }
            aVar = (a) obj;
        }
        a(aVar, gVar);
        TextView textView2 = aVar.titleTv;
        if (textView2 != null) {
            textView2.setText("");
        }
        TextView textView3 = aVar.hPW;
        if (textView3 != null) {
            textView3.setText("");
        }
        if (!(gVar == null || (anb = gVar.field_favProto) == null || (guk = anb.guk()) == null)) {
            TextView textView4 = aVar.titleTv;
            if (textView4 != null) {
                if (context == null) {
                    p.hyc();
                }
                textView4.setText(com.tencent.mm.pluginsdk.ui.span.l.c(context, guk.nickname));
            }
            if (!(guk.vXJ == 1 || (textView = aVar.hPW) == null)) {
                if (context == null) {
                    p.hyc();
                }
                textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(context, guk.desc));
            }
            if (guk.vXJ == 2) {
                ImageView imageView2 = aVar.tlp;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                ImageView imageView3 = aVar.tlp;
                if (imageView3 != null) {
                    imageView3.setImageDrawable(ar.m(context, R.raw.icons_filled_album, com.tencent.mm.cb.a.n(context, R.color.am)));
                }
            } else if (!(guk.vXJ == 4 || (imageView = aVar.tlp) == null)) {
                imageView.setVisibility(8);
            }
            if (guk.mediaList != null && !guk.mediaList.isEmpty()) {
                aj ajVar = (aj) com.tencent.mm.kernel.g.ah(aj.class);
                String str = guk.mediaList.get(0).thumbUrl;
                ImageView imageView4 = aVar.tlo;
                if (imageView4 == null) {
                    p.hyc();
                }
                ajVar.loadImage(str, imageView4);
            }
        }
        if (view == null) {
            p.hyc();
        }
        AppMethodBeat.o(164110);
        return view;
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final void a(View view, and and) {
        anb anb;
        bcj guk;
        AppMethodBeat.i(164111);
        if (!WeChatBrands.Business.Entries.SessionChannels.checkAvailable(view != null ? view.getContext() : null)) {
            AppMethodBeat.o(164111);
            return;
        }
        Object tag = view != null ? view.getTag() : null;
        if (tag == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.fav.ui.listitem.FavFinderListItem.FavFinderHolder");
            AppMethodBeat.o(164111);
            throw tVar;
        }
        g gVar = ((a) tag).tbr;
        if (gVar == null || (anb = gVar.field_favProto) == null || (guk = anb.guk()) == null) {
            AppMethodBeat.o(164111);
            return;
        }
        f fVar = f.teu;
        Context context = view.getContext();
        p.g(context, "view.context");
        f.a(context, guk);
        AppMethodBeat.o(164111);
    }
}
