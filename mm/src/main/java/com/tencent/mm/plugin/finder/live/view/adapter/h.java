package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.finder.live.model.cgi.r;
import com.tencent.mm.plugin.finder.live.model.cgi.t;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.u;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.ae;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awp;
import com.tencent.mm.protocal.protobuf.aww;
import com.tencent.mm.protocal.protobuf.det;
import com.tencent.mm.protocal.protobuf.ffq;
import com.tencent.mm.protocal.protobuf.fhd;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 i2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002ijB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ$\u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u00020<2\n\u0010&\u001a\u00060\u0002R\u00020\u00002\u0006\u0010=\u001a\u00020)H\u0002J$\u0010>\u001a\u00020\u00172\u0006\u0010;\u001a\u00020?2\n\u0010&\u001a\u00060\u0002R\u00020\u00002\u0006\u0010=\u001a\u00020)H\u0002J\b\u0010@\u001a\u00020)H\u0016J\u0010\u0010A\u001a\u00020B2\u0006\u0010=\u001a\u00020)H\u0002J\u0012\u0010C\u001a\u0004\u0018\u00010\f2\u0006\u0010*\u001a\u00020)H\u0002J\u001c\u0010D\u001a\u00020\u00172\u0006\u0010=\u001a\u00020)2\n\u0010&\u001a\u00060\u0002R\u00020\u0000H\u0002J$\u0010E\u001a\u00020\u00172\n\u0010&\u001a\u00060\u0002R\u00020\u00002\u0006\u0010*\u001a\u00020)2\u0006\u0010F\u001a\u00020)H\u0002J\u001c\u0010G\u001a\u00020\u00172\n\u0010&\u001a\u00060\u0002R\u00020\u00002\u0006\u0010=\u001a\u00020)H\u0016J*\u0010G\u001a\u00020\u00172\n\u0010&\u001a\u00060\u0002R\u00020\u00002\u0006\u0010=\u001a\u00020)2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020J0IH\u0016J\u001c\u0010K\u001a\u00060\u0002R\u00020\u00002\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020)H\u0016J$\u0010O\u001a\u00020\u00172\n\u0010&\u001a\u00060\u0002R\u00020\u00002\u0006\u0010*\u001a\u00020)2\u0006\u0010F\u001a\u00020)H\u0002J\u0010\u0010P\u001a\u00020\u00172\u0006\u0010Q\u001a\u00020\fH\u0002J\u0010\u0010R\u001a\u00020\u00172\u0006\u0010Q\u001a\u00020\fH\u0002J\u001c\u0010S\u001a\u00020\u00172\n\u0010&\u001a\u00060\u0002R\u00020\u00002\u0006\u0010=\u001a\u00020)H\u0002J4\u0010T\u001a\u00020\u00172\u0006\u0010U\u001a\u0002022\u0006\u0010V\u001a\u0002022\u0006\u0010W\u001a\u00020B2\n\u0010&\u001a\u00060\u0002R\u00020\u00002\u0006\u0010*\u001a\u00020)H\u0002J \u0010X\u001a\u00020\u00172\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020B2\u0006\u0010\\\u001a\u00020BH\u0002J\u001c\u0010]\u001a\u00020\u00172\n\u0010&\u001a\u00060\u0002R\u00020\u00002\u0006\u0010=\u001a\u00020)H\u0002J6\u0010^\u001a\u00020\u00172\u0006\u0010U\u001a\u0002022\u0006\u0010V\u001a\u0002022\b\b\u0002\u0010_\u001a\u0002022\n\u0010&\u001a\u00060\u0002R\u00020\u00002\u0006\u0010*\u001a\u00020)H\u0002J\u001c\u0010`\u001a\u00020\u00172\u0006\u0010V\u001a\u0002022\n\u0010&\u001a\u00060\u0002R\u00020\u0000H\u0002J2\u0010a\u001a\u00020\u00172\n\u0010&\u001a\u00060\u0002R\u00020\u00002\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)2\u0006\u0010b\u001a\u00020)2\u0006\u0010c\u001a\u00020)J\u0010\u0010d\u001a\u00020\u00172\b\u0010e\u001a\u0004\u0018\u00010\fJ\u0016\u0010f\u001a\u00020\u00172\u000e\u0010g\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bJ\u001c\u0010h\u001a\u00020\u00172\n\u0010&\u001a\u00060\u0002R\u00020\u00002\u0006\u0010*\u001a\u00020)H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R7\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR7\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R7\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bRe\u0010$\u001aM\u0012\u0017\u0012\u00150\u0002R\u00020\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110'¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b((\u0012\u0013\u0012\u00110)¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u0017\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R7\u00101\u001a\u001f\u0012\u0013\u0012\u001102¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0019\"\u0004\b5\u0010\u001bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R7\u00106\u001a\u001f\u0012\u0013\u0012\u001102¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0019\"\u0004\b9\u0010\u001b¨\u0006k"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$ShoppingViewHolder;", "context", "Landroid/content/Context;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "(Landroid/content/Context;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "gotoFullScreenMiniProgram", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "Lkotlin/ParameterName;", "name", "bunde", "", "getGotoFullScreenMiniProgram", "()Lkotlin/jvm/functions/Function1;", "setGotoFullScreenMiniProgram", "(Lkotlin/jvm/functions/Function1;)V", "gotoHalfScreenMiniProgram", "getGotoHalfScreenMiniProgram", "setGotoHalfScreenMiniProgram", "onBuyClickCallback", "", "productId", "getOnBuyClickCallback", "setOnBuyClickCallback", "onItemLongClickCallback", "Lkotlin/Function3;", "holder", "Landroid/view/View;", "itemView", "", "pos", "getOnItemLongClickCallback", "()Lkotlin/jvm/functions/Function3;", "setOnItemLongClickCallback", "(Lkotlin/jvm/functions/Function3;)V", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "promotingProductCallback", "", "promting", "getPromotingProductCallback", "setPromotingProductCallback", "updateProductCallback", "empty", "getUpdateProductCallback", "setUpdateProductCallback", "bindAdItem", "item", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowAdItem;", "position", "bindProductItem", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowProductItem;", "getItemCount", "getPositionText", "", "getShoppingData", "goAd", "modifyProduct", "scene", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "i", "promoteProduct", "reportStartTalk", "data", "reportStopTalk", "setAdOnClickListener", "setAdUserActionText", "anchor", "promoting", "buttonText", "setProductDesc", "productDescTv", "Landroid/widget/TextView;", "shopName", "goodsDesc", "setProductOnClickListener", "setProductUserActionText", "sellOut", "setPromotingAnim", "showPopupMenu", "anchorPosX", "anchorPosY", "updatePromotingProduct", "promotingProduct", "updateShoppingList", "productList", "userProductAction", "Companion", "ShoppingViewHolder", "plugin-finder_release"})
public final class h extends RecyclerView.a<b> {
    public static final a uBH = new a((byte) 0);
    private final Context context;
    private final com.tencent.mm.live.c.b hOp;
    private final com.tencent.mm.plugin.finder.live.viewmodel.g liveData;
    public LinkedList<bo> ppH = new LinkedList<>();
    public com.tencent.mm.ui.widget.b.a pqr = new com.tencent.mm.ui.widget.b.a(this.context);
    public kotlin.g.a.b<? super com.tencent.mm.plugin.appbrand.api.g, x> uBB;
    public kotlin.g.a.b<? super com.tencent.mm.plugin.appbrand.api.g, x> uBC;
    public kotlin.g.a.b<? super Boolean, x> uBD;
    public kotlin.g.a.b<? super Boolean, x> uBE;
    public q<? super b, ? super View, ? super Integer, x> uBF;
    public kotlin.g.a.b<? super Long, x> uBG;

    static {
        AppMethodBeat.i(247849);
        AppMethodBeat.o(247849);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\b"}, hxF = {"<anonymous>", "", "gotoHalfScreen", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "invoke", "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$userProductAction$1$1$1", "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$$special$$inlined$let$lambda$1"})
    public static final class j extends kotlin.g.b.q implements kotlin.g.a.m<Boolean, com.tencent.mm.plugin.appbrand.api.g, x> {
        final /* synthetic */ bo UPg;
        final /* synthetic */ h uBP;
        final /* synthetic */ int uBS;
        final /* synthetic */ b uBV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(h hVar, int i2, bo boVar, b bVar) {
            super(2);
            this.uBP = hVar;
            this.uBS = i2;
            this.UPg = boVar;
            this.uBV = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, com.tencent.mm.plugin.appbrand.api.g gVar) {
            String str;
            String str2;
            AppMethodBeat.i(247835);
            boolean booleanValue = bool.booleanValue();
            com.tencent.mm.plugin.appbrand.api.g gVar2 = gVar;
            if (gVar2 != null) {
                if (this.uBP.hOp.getLiveRole() == 1) {
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    s dpl = com.tencent.mm.plugin.finder.report.live.k.dpl();
                    String str3 = gVar2.appId;
                    String str4 = gVar2.dCw;
                    if (str3 == null) {
                        str3 = "";
                    }
                    dpl.vly = str3;
                    if (str4 == null) {
                        str2 = "";
                    } else {
                        str2 = str4;
                    }
                    dpl.vlz = str2;
                }
                com.tencent.mm.plugin.finder.live.g gVar3 = com.tencent.mm.plugin.finder.live.g.ufT;
                com.tencent.mm.plugin.finder.live.g.c(gVar2);
                if (booleanValue) {
                    kotlin.g.a.b<? super com.tencent.mm.plugin.appbrand.api.g, x> bVar = this.uBP.uBC;
                    if (bVar != null) {
                        bVar.invoke(gVar2);
                    }
                } else {
                    kotlin.g.a.b<? super com.tencent.mm.plugin.appbrand.api.g, x> bVar2 = this.uBP.uBB;
                    if (bVar2 != null) {
                        bVar2.invoke(gVar2);
                    }
                }
                kotlin.g.a.b<? super Long, x> bVar3 = this.uBP.uBG;
                if (bVar3 != null) {
                    bVar3.invoke(Long.valueOf(((com.tencent.mm.plugin.finder.live.view.a.c) this.UPg).uko));
                }
            }
            com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
            s.au auVar = s.au.CommerceActionPurchaseButtonClick;
            if (gVar2 != null) {
                str = gVar2.dCw;
            } else {
                str = null;
            }
            com.tencent.mm.plugin.finder.report.live.m.a(mVar, auVar, str, String.valueOf(((com.tencent.mm.plugin.finder.live.view.a.c) this.UPg).uko));
            x xVar = x.SXb;
            AppMethodBeat.o(247835);
            return xVar;
        }
    }

    public h(Context context2, com.tencent.mm.live.c.b bVar, com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
        p.h(context2, "context");
        p.h(bVar, "statusMonitor");
        p.h(gVar, "liveData");
        AppMethodBeat.i(247848);
        this.context = context2;
        this.hOp = bVar;
        this.liveData = gVar;
        AppMethodBeat.o(247848);
    }

    public static final /* synthetic */ bo a(h hVar, int i2) {
        AppMethodBeat.i(260972);
        bo awN = hVar.awN(i2);
        AppMethodBeat.o(260972);
        return awN;
    }

    public static final /* synthetic */ void a(h hVar, boolean z, b bVar) {
        AppMethodBeat.i(247853);
        hVar.a(z, bVar);
        AppMethodBeat.o(247853);
    }

    public static final /* synthetic */ void a(boolean z, b bVar, int i2) {
        AppMethodBeat.i(260975);
        a(true, z, false, bVar, i2);
        AppMethodBeat.o(260975);
    }

    public static final /* synthetic */ void a(boolean z, String str, b bVar, int i2) {
        AppMethodBeat.i(260974);
        a(true, z, str, bVar, i2);
        AppMethodBeat.o(260974);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ b a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(247837);
        p.h(viewGroup, "parent");
        View inflate = View.inflate(viewGroup.getContext(), R.layout.afc, null);
        p.g(inflate, "itemView");
        b bVar = new b(this, inflate);
        AppMethodBeat.o(247837);
        return bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* bridge */ /* synthetic */ void a(b bVar, int i2) {
        AppMethodBeat.i(247841);
        a(bVar, i2);
        AppMethodBeat.o(247841);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int, java.util.List] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(b bVar, int i2, List list) {
        AppMethodBeat.i(247839);
        b bVar2 = bVar;
        p.h(bVar2, "holder");
        p.h(list, "payloads");
        Log.i("Finder.LiveShoppingListAdapter", "onBindViewHolder payload, pos:" + i2 + ",payloads:" + list);
        bo boVar = this.ppH.get(i2);
        p.g(boVar, "dataList[position]");
        boolean z = boVar instanceof fhd;
        if (!(list.isEmpty())) {
            for (Object obj : list) {
                if (obj instanceof Integer) {
                    if (p.j(obj, 1) || p.j(obj, 2)) {
                        TextView textView = bVar2.uBK;
                        p.g(textView, "holder.productSeq");
                        textView.setText(awM(i2));
                        if (!z) {
                            b(bVar2, i2);
                        } else {
                            c(bVar2, i2);
                        }
                    } else if (p.j(obj, 3)) {
                        a(true, bVar2);
                    } else if (p.j(obj, 4)) {
                        a(false, bVar2);
                    }
                }
            }
            AppMethodBeat.o(247839);
            return;
        }
        a(bVar2, i2);
        AppMethodBeat.o(247839);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$Companion;", "", "()V", "MENU_ID_ITEM_DELETE", "", "MENU_ID_ITEM_MOVE_TO_FIRST", "TAG", "", "payloadDelete", "payloadMove", "payloadPromteFinish", "payloadPromting", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void ao(LinkedList<bo> linkedList) {
        AppMethodBeat.i(247836);
        Log.i("Finder.LiveShoppingListAdapter", "updateShoppingList,ori size:" + this.ppH.size() + ",new size:" + (linkedList != null ? Integer.valueOf(linkedList.size()) : null));
        if (linkedList != null) {
            this.ppH.clear();
            boolean z = this.hOp.getLiveRole() == 1;
            if (z) {
                com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.dpl().vmp.clear();
            }
            LinkedList<bo> linkedList2 = linkedList;
            ArrayList arrayList = new ArrayList(kotlin.a.j.a(linkedList2, 10));
            for (T t : linkedList2) {
                this.ppH.add(t);
                if (z) {
                    if (t instanceof com.tencent.mm.plugin.finder.live.view.a.c) {
                        com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                        com.tencent.mm.plugin.finder.report.live.k.dpl().vmp.add(Long.valueOf(t.uko));
                    } else if (t instanceof fhd) {
                        com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                        com.tencent.mm.plugin.finder.report.live.k.dpl().vmp.add(Long.valueOf(t.UPE));
                    }
                }
                arrayList.add(x.SXb);
            }
            AppMethodBeat.o(247836);
            return;
        }
        AppMethodBeat.o(247836);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(247838);
        int size = this.ppH.size();
        AppMethodBeat.o(247838);
        return size;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\"\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n \u0006*\u0004\u0018\u00010\f0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\n \u0006*\u0004\u0018\u00010\u00120\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\n \u0006*\u0004\u0018\u00010\f0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\"\u0010\u001a\u001a\n \u0006*\u0004\u0018\u00010\f0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\"\u0010\u001d\u001a\n \u0006*\u0004\u0018\u00010\u001e0\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\n \u0006*\u0004\u0018\u00010\f0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R\"\u0010&\u001a\n \u0006*\u0004\u0018\u00010\f0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u000e\"\u0004\b(\u0010\u0010¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$ShoppingViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter;Landroid/view/View;)V", "itemDetail", "kotlin.jvm.PlatformType", "getItemDetail", "()Landroid/view/View;", "setItemDetail", "(Landroid/view/View;)V", "productDesc", "Landroid/widget/TextView;", "getProductDesc", "()Landroid/widget/TextView;", "setProductDesc", "(Landroid/widget/TextView;)V", "productImg", "Landroid/widget/ImageView;", "getProductImg", "()Landroid/widget/ImageView;", "setProductImg", "(Landroid/widget/ImageView;)V", "productPrice", "getProductPrice", "setProductPrice", "productSeq", "getProductSeq", "setProductSeq", "promoting", "Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "getPromoting", "()Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "setPromoting", "(Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;)V", "realDesc", "getRealDesc", "setRealDesc", "userAction", "getUserAction", "setUserAction", "plugin-finder_release"})
    public final class b extends RecyclerView.v {
        TextView UOT;
        private View uBI;
        ImageView uBJ;
        TextView uBK;
        FinderLiveOnliveWidget uBL;
        public TextView uBM;
        TextView uBN;
        TextView uBO;
        final /* synthetic */ h uBP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(h hVar, View view) {
            super(view);
            p.h(view, "itemView");
            this.uBP = hVar;
            AppMethodBeat.i(247824);
            this.uBI = view.findViewById(R.id.e2a);
            this.uBJ = (ImageView) view.findViewById(R.id.gi6);
            this.uBK = (TextView) view.findViewById(R.id.gi9);
            this.uBL = (FinderLiveOnliveWidget) view.findViewById(R.id.gls);
            this.uBM = (TextView) view.findViewById(R.id.ghs);
            this.uBN = (TextView) view.findViewById(R.id.gi8);
            this.uBO = (TextView) view.findViewById(R.id.ghm);
            this.UOT = (TextView) view.findViewById(R.id.k1r);
            y yVar = y.vXH;
            TextView textView = this.uBN;
            p.g(textView, "productPrice");
            y.q(textView);
            this.uBO.post(new Runnable(this) {
                /* class com.tencent.mm.plugin.finder.live.view.adapter.h.b.AnonymousClass1 */
                final /* synthetic */ b uBQ;

                {
                    this.uBQ = r1;
                }

                public final void run() {
                    AppMethodBeat.i(247823);
                    Rect rect = new Rect();
                    this.uBQ.uBO.getHitRect(rect);
                    Context context = MMApplicationContext.getContext();
                    p.g(context, "MMApplicationContext.getContext()");
                    int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.ct);
                    rect.inset(-dimensionPixelOffset, -dimensionPixelOffset);
                    TextView textView = this.uBQ.uBO;
                    p.g(textView, "userAction");
                    ViewParent parent = textView.getParent();
                    if (parent == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.View");
                        AppMethodBeat.o(247823);
                        throw tVar;
                    }
                    ((View) parent).setTouchDelegate(new TouchDelegate(rect, this.uBQ.uBO));
                    AppMethodBeat.o(247823);
                }
            });
            AppMethodBeat.o(247824);
        }
    }

    private void a(b bVar, int i2) {
        AppMethodBeat.i(247840);
        p.h(bVar, "holder");
        bo boVar = this.ppH.get(i2);
        p.g(boVar, "dataList[position]");
        bo boVar2 = boVar;
        if (boVar2 instanceof com.tencent.mm.plugin.finder.live.view.a.c) {
            a((com.tencent.mm.plugin.finder.live.view.a.c) boVar2, bVar, i2);
            AppMethodBeat.o(247840);
            return;
        }
        if (boVar2 instanceof com.tencent.mm.plugin.finder.live.view.a.b) {
            a((com.tencent.mm.plugin.finder.live.view.a.b) boVar2, bVar, i2);
        }
        AppMethodBeat.o(247840);
    }

    private final String awM(int i2) {
        AppMethodBeat.i(260966);
        int i3 = 0;
        Iterator<bo> it = this.ppH.iterator();
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (it.next() instanceof com.tencent.mm.plugin.finder.live.view.a.b) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            if (i2 == i3) {
                AppMethodBeat.o(260966);
                return "";
            } else if (i2 > i3) {
                String valueOf = String.valueOf(i2);
                AppMethodBeat.o(260966);
                return valueOf;
            } else if (i2 < i3) {
                String valueOf2 = String.valueOf(i2 + 1);
                AppMethodBeat.o(260966);
                return valueOf2;
            }
        }
        String valueOf3 = String.valueOf(i2 + 1);
        AppMethodBeat.o(260966);
        return valueOf3;
    }

    private static void a(TextView textView, String str, String str2) {
        AppMethodBeat.i(247842);
        com.tencent.mm.pluginsdk.ui.span.m mVar = new com.tencent.mm.pluginsdk.ui.span.m(str + str2);
        Context context2 = textView.getContext();
        p.g(context2, "productDescTv.context");
        float dimension = context2.getResources().getDimension(R.dimen.bt);
        float e2 = (float) com.tencent.mm.view.d.e(textView.getContext(), 2.0f);
        Context context3 = textView.getContext();
        p.g(context3, "productDescTv.context");
        int color = context3.getResources().getColor(R.color.ag);
        Context context4 = textView.getContext();
        p.g(context4, "productDescTv.context");
        mVar.a(new u(new u.a(dimension, dimension, dimension, dimension, dimension, e2, color, context4.getResources().getColor(R.color.ad), com.tencent.mm.view.d.e(textView.getContext(), 12.0f))), str, 0);
        textView.setText(mVar);
        AppMethodBeat.o(247842);
    }

    private static void a(boolean z, boolean z2, boolean z3, b bVar, int i2) {
        AppMethodBeat.i(260967);
        Log.i("Finder.LiveShoppingListAdapter", "setAnchorPromoteText,anchor:" + z + ",promoting:" + z2 + ",pos:" + i2);
        if (z3) {
            TextView textView = bVar.uBO;
            p.g(textView, "holder.userAction");
            TextView textView2 = bVar.uBO;
            p.g(textView2, "holder.userAction");
            Context context2 = textView2.getContext();
            p.g(context2, "holder.userAction.context");
            textView.setText(context2.getResources().getString(R.string.cz_));
            TextView textView3 = bVar.uBO;
            TextView textView4 = bVar.uBO;
            p.g(textView4, "holder.userAction");
            Context context3 = textView4.getContext();
            p.g(context3, "holder.userAction.context");
            textView3.setTextColor(context3.getResources().getColor(R.color.aa));
            bVar.uBO.setBackgroundResource(R.drawable.a1n);
            TextView textView5 = bVar.uBO;
            p.g(textView5, "holder.userAction");
            textView5.setEnabled(false);
            AppMethodBeat.o(260967);
            return;
        }
        if (!z3) {
            if (z) {
                if (z2) {
                    TextView textView6 = bVar.uBO;
                    p.g(textView6, "holder.userAction");
                    TextView textView7 = bVar.uBO;
                    p.g(textView7, "holder.userAction");
                    Context context4 = textView7.getContext();
                    p.g(context4, "holder.userAction.context");
                    textView6.setText(context4.getResources().getString(R.string.czc));
                    TextView textView8 = bVar.uBO;
                    TextView textView9 = bVar.uBO;
                    p.g(textView9, "holder.userAction");
                    Context context5 = textView9.getContext();
                    p.g(context5, "holder.userAction.context");
                    textView8.setTextColor(context5.getResources().getColor(R.color.q5));
                    bVar.uBO.setBackgroundResource(R.drawable.a1n);
                } else {
                    TextView textView10 = bVar.uBO;
                    p.g(textView10, "holder.userAction");
                    TextView textView11 = bVar.uBO;
                    p.g(textView11, "holder.userAction");
                    Context context6 = textView11.getContext();
                    p.g(context6, "holder.userAction.context");
                    textView10.setText(context6.getResources().getString(R.string.czb));
                    TextView textView12 = bVar.uBO;
                    TextView textView13 = bVar.uBO;
                    p.g(textView13, "holder.userAction");
                    Context context7 = textView13.getContext();
                    p.g(context7, "holder.userAction.context");
                    textView12.setTextColor(context7.getResources().getColor(R.color.am));
                    bVar.uBO.setBackgroundResource(R.drawable.a01);
                }
            } else if (!z) {
                TextView textView14 = bVar.uBO;
                p.g(textView14, "holder.userAction");
                TextView textView15 = bVar.uBO;
                p.g(textView15, "holder.userAction");
                Context context8 = textView15.getContext();
                p.g(context8, "holder.userAction.context");
                textView14.setText(context8.getResources().getString(R.string.cz4));
                TextView textView16 = bVar.uBO;
                TextView textView17 = bVar.uBO;
                p.g(textView17, "holder.userAction");
                Context context9 = textView17.getContext();
                p.g(context9, "holder.userAction.context");
                textView16.setTextColor(context9.getResources().getColor(R.color.am));
                bVar.uBO.setBackgroundResource(R.drawable.a01);
            }
            TextView textView18 = bVar.uBO;
            p.g(textView18, "holder.userAction");
            textView18.setEnabled(true);
        }
        AppMethodBeat.o(260967);
    }

    private static void a(boolean z, boolean z2, String str, b bVar, int i2) {
        AppMethodBeat.i(260968);
        Log.i("Finder.LiveShoppingListAdapter", "setAnchorPromoteText,anchor:" + z + ",promoting:" + z2 + ",pos:" + i2);
        if (z) {
            if (z2) {
                TextView textView = bVar.uBO;
                p.g(textView, "holder.userAction");
                TextView textView2 = bVar.uBO;
                p.g(textView2, "holder.userAction");
                Context context2 = textView2.getContext();
                p.g(context2, "holder.userAction.context");
                textView.setText(context2.getResources().getString(R.string.czc));
                TextView textView3 = bVar.uBO;
                TextView textView4 = bVar.uBO;
                p.g(textView4, "holder.userAction");
                Context context3 = textView4.getContext();
                p.g(context3, "holder.userAction.context");
                textView3.setTextColor(context3.getResources().getColor(R.color.q5));
                bVar.uBO.setBackgroundResource(R.drawable.a1n);
            } else {
                TextView textView5 = bVar.uBO;
                p.g(textView5, "holder.userAction");
                TextView textView6 = bVar.uBO;
                p.g(textView6, "holder.userAction");
                Context context4 = textView6.getContext();
                p.g(context4, "holder.userAction.context");
                textView5.setText(context4.getResources().getString(R.string.czb));
                TextView textView7 = bVar.uBO;
                TextView textView8 = bVar.uBO;
                p.g(textView8, "holder.userAction");
                Context context5 = textView8.getContext();
                p.g(context5, "holder.userAction.context");
                textView7.setTextColor(context5.getResources().getColor(R.color.am));
                bVar.uBO.setBackgroundResource(R.drawable.a01);
            }
        } else if (!z) {
            TextView textView9 = bVar.uBO;
            p.g(textView9, "holder.userAction");
            textView9.setText(str);
            TextView textView10 = bVar.uBO;
            TextView textView11 = bVar.uBO;
            p.g(textView11, "holder.userAction");
            Context context6 = textView11.getContext();
            p.g(context6, "holder.userAction.context");
            textView10.setTextColor(context6.getResources().getColor(R.color.am));
            bVar.uBO.setBackgroundResource(R.drawable.a01);
        }
        TextView textView12 = bVar.uBO;
        p.g(textView12, "holder.userAction");
        textView12.setEnabled(true);
        AppMethodBeat.o(260968);
    }

    private final void a(boolean z, b bVar) {
        AppMethodBeat.i(247844);
        if (z) {
            FinderLiveOnliveWidget finderLiveOnliveWidget = bVar.uBL;
            p.g(finderLiveOnliveWidget, "holder.promoting");
            finderLiveOnliveWidget.setVisibility(0);
            bVar.uBL.dGW();
            if (this.hOp.getLiveRole() == 1) {
                com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.dpl().vmn = true;
                AppMethodBeat.o(247844);
                return;
            }
        } else {
            FinderLiveOnliveWidget finderLiveOnliveWidget2 = bVar.uBL;
            p.g(finderLiveOnliveWidget2, "holder.promoting");
            finderLiveOnliveWidget2.setVisibility(8);
            bVar.uBL.cEA();
        }
        AppMethodBeat.o(247844);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class k implements View.OnClickListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ h uBP;

        k(h hVar, int i2) {
            this.uBP = hVar;
            this.gUj = i2;
        }

        public final void onClick(View view) {
            String str;
            String str2 = null;
            AppMethodBeat.i(260961);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setProductOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            final bo a2 = h.a(this.uBP, this.gUj);
            if (a2 instanceof com.tencent.mm.plugin.finder.live.view.a.c) {
                StringBuilder sb = new StringBuilder("on product item click appId:");
                det det = ((com.tencent.mm.plugin.finder.live.view.a.c) a2).LHI;
                if (det != null) {
                    str = det.appId;
                } else {
                    str = null;
                }
                StringBuilder append = sb.append(str).append(",path:");
                det det2 = ((com.tencent.mm.plugin.finder.live.view.a.c) a2).LHI;
                if (det2 != null) {
                    str2 = det2.path;
                }
                Log.i("Finder.LiveShoppingListAdapter", append.append(str2).toString());
                com.tencent.mm.plugin.finder.live.g gVar = com.tencent.mm.plugin.finder.live.g.ufT;
                com.tencent.mm.plugin.finder.live.g.a(this.uBP.liveData, ((com.tencent.mm.plugin.finder.live.view.a.c) a2).UPJ, new kotlin.g.a.m<Boolean, com.tencent.mm.plugin.appbrand.api.g, x>(this) {
                    /* class com.tencent.mm.plugin.finder.live.view.adapter.h.k.AnonymousClass1 */
                    final /* synthetic */ k UPe;

                    {
                        this.UPe = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // kotlin.g.a.m
                    public final /* synthetic */ x invoke(Boolean bool, com.tencent.mm.plugin.appbrand.api.g gVar) {
                        kotlin.g.a.b<? super com.tencent.mm.plugin.appbrand.api.g, x> bVar;
                        String str;
                        String str2;
                        awe awe;
                        awc awc;
                        AppMethodBeat.i(260960);
                        boolean booleanValue = bool.booleanValue();
                        com.tencent.mm.plugin.appbrand.api.g gVar2 = gVar;
                        if (gVar2 != null) {
                            com.tencent.mm.plugin.finder.live.g gVar3 = com.tencent.mm.plugin.finder.live.g.ufT;
                            com.tencent.mm.plugin.finder.live.g.c(gVar2);
                            if (booleanValue) {
                                kotlin.g.a.b<? super com.tencent.mm.plugin.appbrand.api.g, x> bVar2 = this.UPe.uBP.uBC;
                                if (bVar2 != null) {
                                    bVar2.invoke(gVar2);
                                }
                            } else if (!booleanValue && (bVar = this.UPe.uBP.uBB) != null) {
                                bVar.invoke(gVar2);
                            }
                            kotlin.g.a.b<? super Long, x> bVar3 = this.UPe.uBP.uBG;
                            if (bVar3 != null) {
                                bVar3.invoke(Long.valueOf(((com.tencent.mm.plugin.finder.live.view.a.c) a2).uko));
                            }
                            if (this.UPe.uBP.hOp.getLiveRole() == 1) {
                                com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                                com.tencent.mm.plugin.finder.report.live.k.dpl().vmo = true;
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("type", s.aa.LIVE_CLICK_GOODS.action);
                                com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                                jSONObject.put("sessionid", com.tencent.mm.plugin.finder.report.live.k.dpl().vlJ);
                                o oVar = o.ujN;
                                com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
                                if (dfZ == null || (awc = dfZ.uEl) == null || (str = awc.vtD) == null) {
                                    str = "";
                                }
                                jSONObject.put("shopwindowid", str);
                                jSONObject.put("productid", ((com.tencent.mm.plugin.finder.live.view.a.c) a2).uko);
                                o oVar2 = o.ujN;
                                com.tencent.mm.plugin.finder.live.viewmodel.g dfZ2 = o.dfZ();
                                if (dfZ2 == null || !dfZ2.djk()) {
                                    o oVar3 = o.ujN;
                                    com.tencent.mm.plugin.finder.live.viewmodel.g dfZ3 = o.dfZ();
                                    if (dfZ3 != null && dfZ3.isLiveStarted()) {
                                        o oVar4 = o.ujN;
                                        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ4 = o.dfZ();
                                        if (dfZ4 != null) {
                                            str2 = dfZ4.uEq;
                                        } else {
                                            str2 = null;
                                        }
                                        jSONObject.put("appid", str2);
                                        o oVar5 = o.ujN;
                                        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ5 = o.dfZ();
                                        long j2 = (dfZ5 == null || (awe = dfZ5.liveInfo) == null) ? -1 : awe.liveId;
                                        if (j2 < 0) {
                                            jSONObject.put("liveid", "");
                                        } else {
                                            jSONObject.put("liveid", com.tencent.mm.plugin.expt.hellhound.core.b.zs(j2));
                                        }
                                        c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                                        jSONObject.put("clickid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEB);
                                        c.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                                        c.a.apD("");
                                        com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                                        com.tencent.mm.plugin.finder.report.live.k.a(s.c.LIVE_ANCHOR_ACTION_COMMERCE, jSONObject.toString());
                                    }
                                } else {
                                    com.tencent.mm.plugin.finder.report.live.k kVar4 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                                    com.tencent.mm.plugin.finder.report.live.k.q(s.a.LIVE_COMMERCE.hlf, jSONObject.toString());
                                }
                            } else if (this.UPe.uBP.hOp.getLiveRole() == 0) {
                                com.tencent.mm.plugin.finder.report.live.m.a(com.tencent.mm.plugin.finder.report.live.m.vli, s.au.CommerceActionGoodsItemClick, gVar2.dCw, String.valueOf(((com.tencent.mm.plugin.finder.live.view.a.c) a2).uko));
                            }
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(260960);
                        return xVar;
                    }
                });
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setProductOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260961);
        }
    }

    private final void b(b bVar, int i2) {
        String str;
        AppMethodBeat.i(260969);
        bVar.aus.setOnClickListener(new k(this, i2));
        bVar.uBO.setOnClickListener(new l(this, bVar, i2));
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
            bVar.aus.setOnLongClickListener(new m(this, bVar, i2));
        }
        bo awN = awN(i2);
        if (this.hOp.getLiveRole() == 0) {
            if (awN instanceof com.tencent.mm.plugin.finder.live.view.a.c) {
                com.tencent.mm.plugin.finder.report.live.m.a(com.tencent.mm.plugin.finder.report.live.m.vli, s.au.CommerceActionGoodsItemShow, (String) null, String.valueOf(((com.tencent.mm.plugin.finder.live.view.a.c) awN).uko));
                AppMethodBeat.o(260969);
                return;
            } else if (awN instanceof com.tencent.mm.plugin.finder.live.view.a.b) {
                com.tencent.mm.plugin.finder.report.live.m mVar2 = com.tencent.mm.plugin.finder.report.live.m.vli;
                s.au auVar = s.au.CommerceActionGoodsItemShow;
                String valueOf = String.valueOf(((com.tencent.mm.plugin.finder.live.view.a.b) awN).UPE);
                ffq ffq = ((com.tencent.mm.plugin.finder.live.view.a.b) awN).UPF;
                if (ffq == null || (str = ffq.LYB) == null) {
                    str = "";
                }
                String valueOf2 = String.valueOf(((com.tencent.mm.plugin.finder.live.view.a.b) awN).UPE);
                String str2 = ((com.tencent.mm.plugin.finder.live.view.a.b) awN).gTk;
                if (str2 == null) {
                    str2 = "";
                }
                mVar2.a(auVar, null, valueOf, str, valueOf2, str2);
            }
        }
        AppMethodBeat.o(260969);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class l implements View.OnClickListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ h uBP;
        final /* synthetic */ b uCa;

        l(h hVar, b bVar, int i2) {
            this.uBP = hVar;
            this.uCa = bVar;
            this.gUj = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(260962);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setProductOnClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            h.a(this.uBP, this.uCa, this.gUj);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setProductOnClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260962);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    public static final class m implements View.OnLongClickListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ h uBP;
        final /* synthetic */ b uCa;

        m(h hVar, b bVar, int i2) {
            this.uBP = hVar;
            this.uCa = bVar;
            this.gUj = i2;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(260963);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setProductOnClickListener$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            q<? super b, ? super View, ? super Integer, x> qVar = this.uBP.uBF;
            if (qVar != null) {
                b bVar2 = this.uCa;
                p.g(view, LocaleUtil.ITALIAN);
                qVar.d(bVar2, view, Integer.valueOf(this.gUj));
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setProductOnClickListener$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(260963);
            return true;
        }
    }

    private final void c(b bVar, int i2) {
        AppMethodBeat.i(260970);
        bVar.aus.setOnClickListener(new e(this, i2, bVar));
        bVar.uBO.setOnClickListener(new f(this, bVar, i2));
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
            bVar.aus.setOnLongClickListener(g.UPd);
        }
        AppMethodBeat.o(260970);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ h uBP;
        final /* synthetic */ b uCa;

        e(h hVar, int i2, b bVar) {
            this.uBP = hVar;
            this.gUj = i2;
            this.uCa = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(260956);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setAdOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            h.a(this.uBP, this.gUj, this.uCa);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setAdOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260956);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class f implements View.OnClickListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ h uBP;
        final /* synthetic */ b uCa;

        f(h hVar, b bVar, int i2) {
            this.uBP = hVar;
            this.uCa = bVar;
            this.gUj = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(260957);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setAdOnClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
            if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
                h.a(this.uBP, this.uCa, this.gUj);
            } else {
                h.a(this.uBP, this.gUj, this.uCa);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setAdOnClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260957);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    public static final class g implements View.OnLongClickListener {
        public static final g UPd = new g();

        static {
            AppMethodBeat.i(260959);
            AppMethodBeat.o(260959);
        }

        g() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(260958);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setAdOnClickListener$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setAdOnClickListener$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(260958);
            return true;
        }
    }

    private final void a(b bVar, int i2, int i3) {
        long j2;
        long j3;
        AppMethodBeat.i(247846);
        z.f fVar = new z.f();
        fVar.SYG = (T) awN(i2);
        if ((fVar.SYG instanceof com.tencent.mm.plugin.finder.live.view.a.c) || (fVar.SYG instanceof com.tencent.mm.plugin.finder.live.view.a.b)) {
            T t = fVar.SYG;
            if (!(t instanceof com.tencent.mm.plugin.finder.live.view.a.c)) {
                t = null;
            }
            T t2 = t;
            if (t2 != null) {
                j2 = t2.uko;
            } else {
                j2 = 0;
            }
            T t3 = fVar.SYG;
            if (!(t3 instanceof com.tencent.mm.plugin.finder.live.view.a.b)) {
                t3 = null;
            }
            T t4 = t3;
            if (t4 != null) {
                j3 = t4.UPE;
            } else {
                j3 = 0;
            }
            int i4 = fVar.SYG instanceof com.tencent.mm.plugin.finder.live.view.a.b ? 1 : 0;
            Log.i("Finder.LiveShoppingListAdapter", "promoteProduct id:" + j2 + ",adId:" + j3 + " scene:" + i3 + ", promoteType:" + i4);
            long j4 = this.liveData.liveInfo.liveId;
            long j5 = this.liveData.hFK;
            String aUg = com.tencent.mm.model.z.aUg();
            p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
            new com.tencent.mm.plugin.finder.live.model.cgi.t(j4, j5, aUg, j2, i4, j3, i3, new d(this, j2, j3, i3, i4, fVar, bVar, i2)).aYI();
        }
        AppMethodBeat.o(247846);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$promoteProduct$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePromoteProduct$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteProductResponse;", "plugin-finder_release"})
    public static final class d implements t.a {
        final /* synthetic */ int $scene;
        final /* synthetic */ long UOX;
        final /* synthetic */ long UOY;
        final /* synthetic */ int UOZ;
        final /* synthetic */ z.f UPa;
        final /* synthetic */ int prP;
        final /* synthetic */ h uBP;
        final /* synthetic */ b uCa;

        d(h hVar, long j2, long j3, int i2, int i3, z.f fVar, b bVar, int i4) {
            this.uBP = hVar;
            this.UOX = j2;
            this.UOY = j3;
            this.$scene = i2;
            this.UOZ = i3;
            this.UPa = fVar;
            this.uCa = bVar;
            this.prP = i4;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.t.a
        public final void a(int i2, int i3, String str, aww aww) {
            AppMethodBeat.i(260955);
            p.h(aww, "resp");
            com.tencent.mm.ac.d.h(new a(this, aww, i2, i3, str));
            AppMethodBeat.o(260955);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ int $errCode;
            final /* synthetic */ String $errMsg;
            final /* synthetic */ int $errType;
            final /* synthetic */ d UPb;
            final /* synthetic */ aww UPc;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, aww aww, int i2, int i3, String str) {
                super(0);
                this.UPb = dVar;
                this.UPc = aww;
                this.$errType = i2;
                this.$errCode = i3;
                this.$errMsg = str;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                String str;
                String str2;
                Long l;
                AppMethodBeat.i(260954);
                if (this.UPb.UOX == this.UPc.uko || this.UPb.UOY == this.UPc.UPE) {
                    if (this.$errType == 0 && this.$errCode == 0) {
                        switch (this.UPb.$scene) {
                            case 1:
                                if (this.UPb.UOZ == 1) {
                                    T t = this.UPb.UPa.SYG;
                                    if (!(t instanceof com.tencent.mm.plugin.finder.live.view.a.b)) {
                                        t = null;
                                    }
                                    T t2 = t;
                                    if (t2 == null || (str2 = t2.UPG) == null) {
                                        str2 = "";
                                    }
                                    h.a(true, str2, this.UPb.uCa, this.UPb.prP);
                                } else {
                                    h.a(true, this.UPb.uCa, this.UPb.prP);
                                }
                                h.a(this.UPb.uBP, true, this.UPb.uCa);
                                kotlin.g.a.b<? super Boolean, x> bVar = this.UPb.uBP.uBE;
                                if (bVar != null) {
                                    bVar.invoke(Boolean.TRUE);
                                }
                                h.a(this.UPb.uBP, this.UPb.UPa.SYG);
                                break;
                            case 2:
                                if (this.UPb.UOZ == 1) {
                                    T t3 = this.UPb.UPa.SYG;
                                    if (!(t3 instanceof com.tencent.mm.plugin.finder.live.view.a.b)) {
                                        t3 = null;
                                    }
                                    T t4 = t3;
                                    if (t4 == null || (str = t4.UPG) == null) {
                                        str = "";
                                    }
                                    h.a(false, str, this.UPb.uCa, this.UPb.prP);
                                } else {
                                    h.a(false, this.UPb.uCa, this.UPb.prP);
                                }
                                h.a(this.UPb.uBP, false, this.UPb.uCa);
                                h.b(this.UPb.uBP, this.UPb.UPa.SYG);
                                break;
                        }
                    } else {
                        Context context = MMApplicationContext.getContext();
                        p.g(context, "MMApplicationContext.getContext()");
                        String string = context.getResources().getString(R.string.cyi);
                        p.g(string, "MMApplicationContext.get…ofile_action_fail_prefix)");
                        String str3 = "";
                        switch (this.UPb.$scene) {
                            case 1:
                                Context context2 = MMApplicationContext.getContext();
                                p.g(context2, "MMApplicationContext.getContext()");
                                str3 = context2.getResources().getString(R.string.czb);
                                p.g(str3, "MMApplicationContext.get…ive_shopping_talking_btn)");
                                break;
                            case 2:
                                Context context3 = MMApplicationContext.getContext();
                                p.g(context3, "MMApplicationContext.getContext()");
                                str3 = context3.getResources().getString(R.string.czc);
                                p.g(str3, "MMApplicationContext.get…ive_shopping_talking_end)");
                                break;
                        }
                        com.tencent.mm.ui.base.u.makeText(MMApplicationContext.getContext(), string + str3, 0).show();
                        ae aeVar = ae.vZW;
                        String dEk = ae.dEk();
                        int i2 = this.$errCode;
                        int i3 = this.$errType;
                        String str4 = this.$errMsg;
                        if (str4 == null) {
                            str4 = "";
                        }
                        ae.a(dEk, i2, i3, str4, this.UPb.uBP.liveData);
                    }
                } else {
                    StringBuilder append = new StringBuilder("promote product fail,req productId:").append(this.UPb.UOX).append(",resp:");
                    aww aww = this.UPc;
                    if (aww != null) {
                        l = Long.valueOf(aww.uko);
                    } else {
                        l = null;
                    }
                    Log.i("Finder.LiveShoppingListAdapter", append.append(l.longValue()).append(", req adId:").append(this.UPb.UOY).append(", resp:").append(this.UPc.UPE).toString());
                }
                x xVar = x.SXb;
                AppMethodBeat.o(260954);
                return xVar;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
    /* renamed from: com.tencent.mm.plugin.finder.live.view.adapter.h$h  reason: collision with other inner class name */
    public static final class View$OnCreateContextMenuListenerC1199h implements View.OnCreateContextMenuListener {
        final /* synthetic */ h uBP;

        public View$OnCreateContextMenuListenerC1199h(h hVar) {
            this.uBP = hVar;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(247833);
            contextMenu.add(0, 100, 0, this.uBP.context.getResources().getString(R.string.czd));
            contextMenu.add(0, 101, 1, this.uBP.context.getResources().getString(R.string.cz6));
            AppMethodBeat.o(247833);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class i implements o.g {
        final /* synthetic */ bo UPf;
        final /* synthetic */ int prP;
        final /* synthetic */ h uBP;
        final /* synthetic */ b uCa;

        public i(h hVar, b bVar, int i2, bo boVar) {
            this.uBP = hVar;
            this.uCa = bVar;
            this.prP = i2;
            this.UPf = boVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            String str;
            String str2;
            bo boVar;
            awe awe;
            awc awc;
            LinkedList<com.tencent.mm.plugin.finder.report.live.o> linkedList;
            String str3;
            String str4;
            bo boVar2;
            awe awe2;
            awc awc2;
            AppMethodBeat.i(247834);
            p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 100:
                    this.uBP.pqr.gNq();
                    h.a(this.uBP, this.prP, 1);
                    if (this.uBP.hOp.getLiveRole() == 1) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("type", s.aa.LIVE_SET_TOP_GOODS.action);
                        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                        jSONObject.put("sessionid", com.tencent.mm.plugin.finder.report.live.k.dpl().vlJ);
                        com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = com.tencent.mm.plugin.finder.live.model.o.dfZ();
                        if (dfZ == null || (awc2 = dfZ.uEl) == null || (str3 = awc2.vtD) == null) {
                            str3 = "";
                        }
                        jSONObject.put("shopwindowid", str3);
                        com.tencent.mm.plugin.finder.live.view.a.c cVar = (com.tencent.mm.plugin.finder.live.view.a.c) this.UPf;
                        jSONObject.put("productid", (cVar != null ? Long.valueOf(cVar.uko) : null).longValue());
                        com.tencent.mm.plugin.finder.live.model.o oVar2 = com.tencent.mm.plugin.finder.live.model.o.ujN;
                        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ2 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
                        if (dfZ2 == null || !dfZ2.djk()) {
                            com.tencent.mm.plugin.finder.live.model.o oVar3 = com.tencent.mm.plugin.finder.live.model.o.ujN;
                            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ3 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
                            if (dfZ3 != null) {
                                if (dfZ3.isLiveStarted()) {
                                    com.tencent.mm.plugin.finder.live.model.o oVar4 = com.tencent.mm.plugin.finder.live.model.o.ujN;
                                    com.tencent.mm.plugin.finder.live.viewmodel.g dfZ4 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
                                    if (dfZ4 != null) {
                                        str4 = dfZ4.uEq;
                                    } else {
                                        str4 = null;
                                    }
                                    jSONObject.put("appid", str4);
                                    com.tencent.mm.plugin.finder.live.model.o oVar5 = com.tencent.mm.plugin.finder.live.model.o.ujN;
                                    com.tencent.mm.plugin.finder.live.viewmodel.g dfZ5 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
                                    long j2 = (dfZ5 == null || (awe2 = dfZ5.liveInfo) == null) ? -1 : awe2.liveId;
                                    if (j2 < 0) {
                                        jSONObject.put("liveid", "");
                                    } else {
                                        jSONObject.put("liveid", com.tencent.mm.plugin.expt.hellhound.core.b.zs(j2));
                                    }
                                    c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                                    jSONObject.put("clickid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEB);
                                    c.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                                    c.a.apD("");
                                    com.tencent.mm.plugin.finder.live.model.o oVar6 = com.tencent.mm.plugin.finder.live.model.o.ujN;
                                    com.tencent.mm.plugin.finder.live.viewmodel.g dfZ6 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
                                    jSONObject.put("productid", (dfZ6 == null || (boVar2 = dfZ6.UPW) == null) ? "" : Long.valueOf(boVar2.lT()));
                                    com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                                    com.tencent.mm.plugin.finder.report.live.k.a(s.c.LIVE_ANCHOR_ACTION_COMMERCE, jSONObject.toString());
                                }
                                AppMethodBeat.o(247834);
                                return;
                            }
                            AppMethodBeat.o(247834);
                            return;
                        }
                        com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                        com.tencent.mm.plugin.finder.report.live.k.q(s.a.LIVE_COMMERCE.hlf, jSONObject.toString());
                        AppMethodBeat.o(247834);
                        return;
                    }
                    break;
                case 101:
                    this.uBP.pqr.gNq();
                    h.a(this.uBP, this.prP, 2);
                    if (this.uBP.hOp.getLiveRole() == 1) {
                        bo boVar3 = this.UPf;
                        com.tencent.mm.plugin.finder.live.view.a.c cVar2 = (com.tencent.mm.plugin.finder.live.view.a.c) boVar3;
                        if (cVar2 != null && cVar2.LHK == 1) {
                            com.tencent.mm.plugin.finder.report.live.k kVar4 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                            s dpl = com.tencent.mm.plugin.finder.report.live.k.dpl();
                            long j3 = ((com.tencent.mm.plugin.finder.live.view.a.c) boVar3).uko;
                            HashMap<Long, LinkedList<com.tencent.mm.plugin.finder.report.live.o>> hashMap = dpl.vmj.vtA;
                            if (!hashMap.isEmpty() && (linkedList = hashMap.get(Long.valueOf(j3))) != null && !linkedList.isEmpty() && !linkedList.getLast().vlm) {
                                long currentTimeMillis = System.currentTimeMillis() - linkedList.getLast().time;
                                com.tencent.mm.plugin.finder.report.live.o last = linkedList.getLast();
                                if (currentTimeMillis <= 0) {
                                    currentTimeMillis = 0;
                                }
                                last.time = currentTimeMillis;
                                linkedList.getLast().vlm = true;
                            }
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("type", s.aa.LIVE_DELETE_GOODS.action);
                        com.tencent.mm.plugin.finder.report.live.k kVar5 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                        jSONObject2.put("sessionid", com.tencent.mm.plugin.finder.report.live.k.dpl().vlJ);
                        com.tencent.mm.plugin.finder.live.model.o oVar7 = com.tencent.mm.plugin.finder.live.model.o.ujN;
                        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ7 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
                        if (dfZ7 == null || (awc = dfZ7.uEl) == null || (str = awc.vtD) == null) {
                            str = "";
                        }
                        jSONObject2.put("shopwindowid", str);
                        com.tencent.mm.plugin.finder.live.view.a.c cVar3 = (com.tencent.mm.plugin.finder.live.view.a.c) this.UPf;
                        jSONObject2.put("productid", (cVar3 != null ? Long.valueOf(cVar3.uko) : null).longValue());
                        com.tencent.mm.plugin.finder.live.model.o oVar8 = com.tencent.mm.plugin.finder.live.model.o.ujN;
                        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ8 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
                        if (dfZ8 == null || !dfZ8.djk()) {
                            com.tencent.mm.plugin.finder.live.model.o oVar9 = com.tencent.mm.plugin.finder.live.model.o.ujN;
                            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ9 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
                            if (dfZ9 != null) {
                                if (dfZ9.isLiveStarted()) {
                                    com.tencent.mm.plugin.finder.live.model.o oVar10 = com.tencent.mm.plugin.finder.live.model.o.ujN;
                                    com.tencent.mm.plugin.finder.live.viewmodel.g dfZ10 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
                                    if (dfZ10 != null) {
                                        str2 = dfZ10.uEq;
                                    } else {
                                        str2 = null;
                                    }
                                    jSONObject2.put("appid", str2);
                                    com.tencent.mm.plugin.finder.live.model.o oVar11 = com.tencent.mm.plugin.finder.live.model.o.ujN;
                                    com.tencent.mm.plugin.finder.live.viewmodel.g dfZ11 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
                                    long j4 = (dfZ11 == null || (awe = dfZ11.liveInfo) == null) ? -1 : awe.liveId;
                                    if (j4 < 0) {
                                        jSONObject2.put("liveid", "");
                                    } else {
                                        jSONObject2.put("liveid", com.tencent.mm.plugin.expt.hellhound.core.b.zs(j4));
                                    }
                                    c.a aVar3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                                    jSONObject2.put("clickid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEB);
                                    c.a aVar4 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                                    c.a.apD("");
                                    com.tencent.mm.plugin.finder.live.model.o oVar12 = com.tencent.mm.plugin.finder.live.model.o.ujN;
                                    com.tencent.mm.plugin.finder.live.viewmodel.g dfZ12 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
                                    jSONObject2.put("productid", (dfZ12 == null || (boVar = dfZ12.UPW) == null) ? "" : Long.valueOf(boVar.lT()));
                                    com.tencent.mm.plugin.finder.report.live.k kVar6 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                                    com.tencent.mm.plugin.finder.report.live.k.a(s.c.LIVE_ANCHOR_ACTION_COMMERCE, jSONObject2.toString());
                                    break;
                                }
                            } else {
                                AppMethodBeat.o(247834);
                                return;
                            }
                        } else {
                            com.tencent.mm.plugin.finder.report.live.k kVar7 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                            com.tencent.mm.plugin.finder.report.live.k.q(s.a.LIVE_COMMERCE.hlf, jSONObject2.toString());
                            AppMethodBeat.o(247834);
                            return;
                        }
                    }
                    break;
            }
            AppMethodBeat.o(247834);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$modifyProduct$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModifyProduct$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopWindowProductResponse;", "plugin-finder_release"})
    public static final class c implements r.a {
        final /* synthetic */ int $scene;
        final /* synthetic */ bo UOU;
        final /* synthetic */ int prP;
        final /* synthetic */ h uBP;

        c(h hVar, bo boVar, int i2, int i3) {
            this.uBP = hVar;
            this.UOU = boVar;
            this.$scene = i2;
            this.prP = i3;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.r.a
        public final void a(int i2, int i3, awp awp) {
            AppMethodBeat.i(260953);
            p.h(awp, "resp");
            com.tencent.mm.ac.d.h(new a(this, awp, i2, i3));
            AppMethodBeat.o(260953);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ int $errCode;
            final /* synthetic */ int $errType;
            final /* synthetic */ c UOV;
            final /* synthetic */ awp UOW;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar, awp awp, int i2, int i3) {
                super(0);
                this.UOV = cVar;
                this.UOW = awp;
                this.$errType = i2;
                this.$errCode = i3;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                Long l;
                kotlin.g.a.b<? super Boolean, x> bVar;
                int itemCount;
                AppMethodBeat.i(260952);
                long j2 = ((com.tencent.mm.plugin.finder.live.view.a.c) this.UOV.UOU).uko;
                awp awp = this.UOW;
                if (awp != null && j2 == awp.uko) {
                    if (this.$errType == 0 && this.$errCode == 0) {
                        switch (this.UOV.$scene) {
                            case 1:
                                int itemCount2 = this.UOV.uBP.getItemCount();
                                int i2 = this.UOV.prP;
                                if (i2 >= 0 && itemCount2 > i2) {
                                    bo remove = this.UOV.uBP.ppH.remove(this.UOV.prP);
                                    p.g(remove, "dataList.removeAt(pos)");
                                    this.UOV.uBP.ppH.add(0, remove);
                                    if (this.UOV.uBP.hOp.getLiveRole() == 1) {
                                        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                                        Long remove2 = com.tencent.mm.plugin.finder.report.live.k.dpl().vmp.remove(this.UOV.prP);
                                        p.g(remove2, "HellLiveReport.getConfig…rProductIds.removeAt(pos)");
                                        long longValue = remove2.longValue();
                                        com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                                        com.tencent.mm.plugin.finder.report.live.k.dpl().vmp.add(0, Long.valueOf(longValue));
                                    }
                                    this.UOV.uBP.ar(this.UOV.prP, 0);
                                    h hVar = this.UOV.uBP;
                                    if (this.UOV.prP + 1 < this.UOV.uBP.getItemCount()) {
                                        itemCount = this.UOV.prP + 1;
                                    } else {
                                        itemCount = this.UOV.uBP.getItemCount();
                                    }
                                    hVar.e(0, itemCount, 1);
                                    break;
                                }
                            case 2:
                                long j3 = this.UOV.uBP.liveData.liveInfo.liveId;
                                long j4 = this.UOV.uBP.liveData.hFK;
                                String aUg = com.tencent.mm.model.z.aUg();
                                p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
                                new com.tencent.mm.plugin.finder.live.model.cgi.t(j3, j4, aUg, ((com.tencent.mm.plugin.finder.live.view.a.c) this.UOV.UOU).uko, 0, 0, 2, null).aYI();
                                int itemCount3 = this.UOV.uBP.getItemCount();
                                int i3 = this.UOV.prP;
                                if (i3 >= 0 && itemCount3 > i3) {
                                    this.UOV.uBP.ppH.remove(this.UOV.prP);
                                    if (this.UOV.uBP.hOp.getLiveRole() == 1) {
                                        com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                                        com.tencent.mm.plugin.finder.report.live.k.dpl().vmp.remove(this.UOV.prP);
                                    }
                                    this.UOV.uBP.ck(this.UOV.prP);
                                    this.UOV.uBP.e(this.UOV.prP, this.UOV.uBP.getItemCount() - this.UOV.prP, 2);
                                }
                                if (this.UOV.uBP.getItemCount() == 0 && (bVar = this.UOV.uBP.uBD) != null) {
                                    bVar.invoke(Boolean.TRUE);
                                    break;
                                }
                        }
                    } else {
                        Context context = MMApplicationContext.getContext();
                        p.g(context, "MMApplicationContext.getContext()");
                        String string = context.getResources().getString(R.string.cyi);
                        p.g(string, "MMApplicationContext.get…ofile_action_fail_prefix)");
                        String str = "";
                        switch (this.UOV.$scene) {
                            case 1:
                                Context context2 = MMApplicationContext.getContext();
                                p.g(context2, "MMApplicationContext.getContext()");
                                str = context2.getResources().getString(R.string.czd);
                                p.g(str, "MMApplicationContext.get….finder_live_shopping_up)");
                                break;
                            case 2:
                                Context context3 = MMApplicationContext.getContext();
                                p.g(context3, "MMApplicationContext.getContext()");
                                str = context3.getResources().getString(R.string.cz6);
                                p.g(str, "MMApplicationContext.get…der_live_shopping_delete)");
                                break;
                        }
                        com.tencent.mm.ui.base.u.makeText(MMApplicationContext.getContext(), string + str, 0).show();
                    }
                } else {
                    StringBuilder append = new StringBuilder("modify product fail,req productId:").append(((com.tencent.mm.plugin.finder.live.view.a.c) this.UOV.UOU).uko).append(",resp:");
                    awp awp2 = this.UOW;
                    if (awp2 != null) {
                        l = Long.valueOf(awp2.uko);
                    } else {
                        l = null;
                    }
                    Log.i("Finder.LiveShoppingListAdapter", append.append(l.longValue()).toString());
                }
                x xVar = x.SXb;
                AppMethodBeat.o(260952);
                return xVar;
            }
        }
    }

    private final void a(com.tencent.mm.plugin.finder.live.view.a.c cVar, b bVar, int i2) {
        AppMethodBeat.i(260964);
        TextView textView = bVar.UOT;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = bVar.uBN;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = bVar.uBK;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
        com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dkb = com.tencent.mm.plugin.finder.loader.m.dkb();
        com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(cVar.twt);
        ImageView imageView = bVar.uBJ;
        p.g(imageView, "holder.productImg");
        com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
        dkb.a(aVar, imageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.LIVE_SHOPPING_DEFAULT));
        TextView textView4 = bVar.uBK;
        p.g(textView4, "holder.productSeq");
        textView4.setText(awM(i2));
        TextView textView5 = bVar.uBM;
        p.g(textView5, "holder.productDesc");
        String str = cVar.LHM;
        if (str == null) {
            str = "";
        }
        String str2 = cVar.title;
        if (str2 == null) {
            str2 = "";
        }
        a(textView5, str, str2);
        if (cVar.AZr < 0 || cVar.AZq < cVar.AZr) {
            Log.i("Finder.LiveShoppingListAdapter", "invalid price,min:" + cVar.AZr + ",max:" + cVar.AZq);
        } else {
            TextView textView6 = bVar.uBN;
            p.g(textView6, "holder.productPrice");
            y yVar = y.vXH;
            textView6.setText(y.LS(cVar.AZr));
        }
        TextView textView7 = bVar.uBO;
        p.g(textView7, "holder.userAction");
        textView7.setVisibility(0);
        if (this.liveData.liveInfo.liveId == 0) {
            TextView textView8 = bVar.uBO;
            p.g(textView8, "holder.userAction");
            textView8.setVisibility(8);
        } else {
            if (cVar.LHJ <= 0) {
                y yVar2 = y.vXH;
                if (!y.c(cVar.UPJ)) {
                    a(false, false, true, bVar, i2);
                }
            }
            com.tencent.mm.plugin.finder.utils.m mVar3 = com.tencent.mm.plugin.finder.utils.m.vVH;
            if (!com.tencent.mm.plugin.finder.utils.m.dBP()) {
                a(false, false, false, bVar, i2);
            } else if (cVar.LHK == 1) {
                a(true, true, false, bVar, i2);
            } else {
                a(true, false, false, bVar, i2);
            }
        }
        if (cVar.LHK == 1) {
            a(true, bVar);
        } else {
            a(false, bVar);
        }
        b(bVar, i2);
        AppMethodBeat.o(260964);
    }

    private final void a(com.tencent.mm.plugin.finder.live.view.a.b bVar, b bVar2, int i2) {
        AppMethodBeat.i(260965);
        TextView textView = bVar2.UOT;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = bVar2.uBN;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        TextView textView3 = bVar2.uBK;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        Log.i("Finder.LiveShoppingListAdapter", "bindAdItem " + bVar.UPH + ", " + bVar.title + ", " + bVar.UPG);
        com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
        com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dkb = com.tencent.mm.plugin.finder.loader.m.dkb();
        com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(bVar.KRv);
        ImageView imageView = bVar2.uBJ;
        p.g(imageView, "holder.productImg");
        com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
        dkb.a(aVar, imageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.LIVE_SHOPPING_DEFAULT));
        TextView textView4 = bVar2.uBK;
        p.g(textView4, "holder.productSeq");
        textView4.setText("");
        TextView textView5 = bVar2.UOT;
        if (textView5 != null) {
            textView5.setText(bVar.desc);
        }
        TextView textView6 = bVar2.uBM;
        p.g(textView6, "holder.productDesc");
        String str = bVar.UPH;
        if (str == null) {
            str = "";
        }
        String str2 = bVar.title;
        if (str2 == null) {
            str2 = "";
        }
        a(textView6, str, str2);
        TextView textView7 = bVar2.uBO;
        p.g(textView7, "holder.userAction");
        textView7.setVisibility(0);
        if (this.liveData.liveInfo.liveId == 0) {
            TextView textView8 = bVar2.uBO;
            p.g(textView8, "holder.userAction");
            textView8.setVisibility(8);
        } else {
            com.tencent.mm.plugin.finder.utils.m mVar3 = com.tencent.mm.plugin.finder.utils.m.vVH;
            if (!com.tencent.mm.plugin.finder.utils.m.dBP()) {
                String str3 = bVar.UPG;
                if (str3 == null) {
                    str3 = "";
                }
                a(false, false, str3, bVar2, i2);
            } else if (bVar.LHK == 1) {
                String str4 = bVar.UPG;
                if (str4 == null) {
                    str4 = "";
                }
                a(true, true, str4, bVar2, i2);
            } else {
                String str5 = bVar.UPG;
                if (str5 == null) {
                    str5 = "";
                }
                a(true, false, str5, bVar2, i2);
            }
        }
        if (bVar.LHK == 1) {
            a(true, bVar2);
        } else {
            a(false, bVar2);
        }
        c(bVar2, i2);
        AppMethodBeat.o(260965);
    }

    public final bo awN(int i2) {
        AppMethodBeat.i(260971);
        int size = this.ppH.size();
        if (i2 >= 0 && size > i2) {
            bo boVar = this.ppH.get(i2);
            AppMethodBeat.o(260971);
            return boVar;
        }
        AppMethodBeat.o(260971);
        return null;
    }

    public static final /* synthetic */ void a(h hVar, b bVar, int i2) {
        ffq ffq;
        String str;
        String str2;
        String str3;
        String str4;
        bo boVar;
        det det;
        String str5 = null;
        AppMethodBeat.i(247851);
        bo awN = hVar.awN(i2);
        if (awN == null) {
            AppMethodBeat.o(247851);
            return;
        }
        TextView textView = bVar.uBO;
        if (textView == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(247851);
            throw tVar;
        }
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
            StringBuilder append = new StringBuilder().append(textView.getText()).append(" pos:").append(i2).append(",appId:");
            if (!(awN instanceof com.tencent.mm.plugin.finder.live.view.a.c)) {
                boVar = null;
            } else {
                boVar = awN;
            }
            com.tencent.mm.plugin.finder.live.view.a.c cVar = (com.tencent.mm.plugin.finder.live.view.a.c) boVar;
            if (!(cVar == null || (det = cVar.LHN) == null)) {
                str5 = det.appId;
            }
            Log.i("Finder.LiveShoppingListAdapter", append.append(str5).toString());
            CharSequence text = textView.getText();
            Context context2 = textView.getContext();
            p.g(context2, "it.context");
            if (p.j(text, context2.getResources().getString(R.string.czb))) {
                hVar.a(bVar, i2, 1);
                AppMethodBeat.o(247851);
                return;
            }
            CharSequence text2 = textView.getText();
            Context context3 = textView.getContext();
            p.g(context3, "it.context");
            if (p.j(text2, context3.getResources().getString(R.string.czc))) {
                hVar.a(bVar, i2, 2);
            }
            AppMethodBeat.o(247851);
            return;
        }
        if (awN instanceof com.tencent.mm.plugin.finder.live.view.a.c) {
            CharSequence text3 = textView.getText();
            Context context4 = textView.getContext();
            p.g(context4, "it.context");
            if (p.j(text3, context4.getResources().getString(R.string.cz4))) {
                StringBuilder append2 = new StringBuilder("buy pos:").append(i2).append(",buy appId:");
                det det2 = ((com.tencent.mm.plugin.finder.live.view.a.c) awN).LHN;
                if (det2 != null) {
                    str2 = det2.appId;
                } else {
                    str2 = null;
                }
                StringBuilder append3 = append2.append(str2).append(",buy path:");
                det det3 = ((com.tencent.mm.plugin.finder.live.view.a.c) awN).LHN;
                if (det3 != null) {
                    str3 = det3.path;
                } else {
                    str3 = null;
                }
                StringBuilder append4 = append3.append(str3).append(",detail appId:");
                det det4 = ((com.tencent.mm.plugin.finder.live.view.a.c) awN).LHI;
                if (det4 != null) {
                    str4 = det4.appId;
                } else {
                    str4 = null;
                }
                StringBuilder append5 = append4.append(str4).append(", detail path:");
                det det5 = ((com.tencent.mm.plugin.finder.live.view.a.c) awN).LHI;
                if (det5 != null) {
                    str5 = det5.path;
                }
                Log.i("Finder.LiveShoppingListAdapter", append5.append(str5).toString());
                com.tencent.mm.plugin.finder.live.g gVar = com.tencent.mm.plugin.finder.live.g.ufT;
                com.tencent.mm.plugin.finder.live.g.b(hVar.liveData, ((com.tencent.mm.plugin.finder.live.view.a.c) awN).UPJ, new j(hVar, i2, awN, bVar));
                AppMethodBeat.o(247851);
                return;
            }
        } else if ((awN instanceof com.tencent.mm.plugin.finder.live.view.a.b) && (ffq = ((com.tencent.mm.plugin.finder.live.view.a.b) awN).UPF) != null) {
            if (hVar.hOp.getLiveRole() == 0) {
                com.tencent.mm.plugin.finder.report.live.m mVar2 = com.tencent.mm.plugin.finder.report.live.m.vli;
                s.au auVar = s.au.CommerceActionPurchaseButtonClick;
                String valueOf = String.valueOf(((com.tencent.mm.plugin.finder.live.view.a.b) awN).UPE);
                ffq ffq2 = ((com.tencent.mm.plugin.finder.live.view.a.b) awN).UPF;
                if (ffq2 == null || (str = ffq2.LYB) == null) {
                    str = "";
                }
                String valueOf2 = String.valueOf(((com.tencent.mm.plugin.finder.live.view.a.b) awN).UPE);
                String str6 = ((com.tencent.mm.plugin.finder.live.view.a.b) awN).gTk;
                if (str6 == null) {
                    str6 = "";
                }
                mVar2.a(auVar, null, valueOf, str, valueOf2, str6);
            }
            com.tencent.mm.plugin.finder.utils.m mVar3 = com.tencent.mm.plugin.finder.utils.m.vVH;
            View view = bVar.aus;
            p.g(view, "holder.itemView");
            Context context5 = view.getContext();
            p.g(context5, "holder.itemView.context");
            String str7 = ffq.LYB;
            if (str7 == null) {
                str7 = "";
            }
            String str8 = ((com.tencent.mm.plugin.finder.live.view.a.b) awN).gTk;
            if (str8 == null) {
                str8 = "";
            }
            com.tencent.mm.plugin.finder.utils.m.ad(context5, str7, str8);
            AppMethodBeat.o(247851);
            return;
        }
        AppMethodBeat.o(247851);
    }

    public static final /* synthetic */ void a(h hVar, int i2, b bVar) {
        ffq ffq;
        String str;
        AppMethodBeat.i(260973);
        bo awN = hVar.awN(i2);
        if (!(awN instanceof com.tencent.mm.plugin.finder.live.view.a.b) || (ffq = ((com.tencent.mm.plugin.finder.live.view.a.b) awN).UPF) == null) {
            AppMethodBeat.o(260973);
            return;
        }
        if (hVar.hOp.getLiveRole() == 0) {
            com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
            s.au auVar = s.au.CommerceActionGoodsItemClick;
            String valueOf = String.valueOf(((com.tencent.mm.plugin.finder.live.view.a.b) awN).UPE);
            ffq ffq2 = ((com.tencent.mm.plugin.finder.live.view.a.b) awN).UPF;
            if (ffq2 == null || (str = ffq2.LYB) == null) {
                str = "";
            }
            String valueOf2 = String.valueOf(((com.tencent.mm.plugin.finder.live.view.a.b) awN).UPE);
            String str2 = ((com.tencent.mm.plugin.finder.live.view.a.b) awN).gTk;
            if (str2 == null) {
                str2 = "";
            }
            mVar.a(auVar, null, valueOf, str, valueOf2, str2);
        }
        com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
        View view = bVar.aus;
        p.g(view, "holder.itemView");
        Context context2 = view.getContext();
        p.g(context2, "holder.itemView.context");
        String str3 = ffq.LYB;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = ((com.tencent.mm.plugin.finder.live.view.a.b) awN).gTk;
        if (str4 == null) {
            str4 = "";
        }
        com.tencent.mm.plugin.finder.utils.m.ad(context2, str3, str4);
        AppMethodBeat.o(260973);
    }

    public static final /* synthetic */ void a(h hVar, bo boVar) {
        long j2;
        String str;
        String str2;
        awe awe;
        awc awc;
        LinkedList<com.tencent.mm.plugin.finder.report.live.o> linkedList;
        AppMethodBeat.i(260976);
        if (hVar.hOp.getLiveRole() == 1) {
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.dpl().vmn = true;
            com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.dpl().dpv();
            if (boVar instanceof com.tencent.mm.plugin.finder.live.view.a.c) {
                j2 = ((com.tencent.mm.plugin.finder.live.view.a.c) boVar).uko;
            } else if (boVar instanceof com.tencent.mm.plugin.finder.live.view.a.b) {
                j2 = ((com.tencent.mm.plugin.finder.live.view.a.b) boVar).UPE;
            } else {
                j2 = 0;
            }
            com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            if (com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtA.containsKey(Long.valueOf(j2))) {
                com.tencent.mm.plugin.finder.report.live.k kVar4 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                LinkedList<com.tencent.mm.plugin.finder.report.live.o> linkedList2 = com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtA.get(Long.valueOf(j2));
                if (linkedList2 == null) {
                    linkedList = new LinkedList<>();
                } else {
                    linkedList = linkedList2;
                }
                linkedList.addLast(new com.tencent.mm.plugin.finder.report.live.o(System.currentTimeMillis()));
                com.tencent.mm.plugin.finder.report.live.k kVar5 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtA.put(Long.valueOf(j2), linkedList);
            } else {
                LinkedList<com.tencent.mm.plugin.finder.report.live.o> linkedList3 = new LinkedList<>();
                linkedList3.addLast(new com.tencent.mm.plugin.finder.report.live.o(System.currentTimeMillis()));
                com.tencent.mm.plugin.finder.report.live.k kVar6 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtA.put(Long.valueOf(j2), linkedList3);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", s.aa.LIVE_START_PROMOTE_GOODS.action);
            com.tencent.mm.plugin.finder.report.live.k kVar7 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            jSONObject.put("sessionid", com.tencent.mm.plugin.finder.report.live.k.dpl().vlJ);
            com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = com.tencent.mm.plugin.finder.live.model.o.dfZ();
            if (dfZ == null || (awc = dfZ.uEl) == null || (str = awc.vtD) == null) {
                str = "";
            }
            jSONObject.put("shopwindowid", str);
            jSONObject.put("productid", j2);
            com.tencent.mm.plugin.finder.live.model.o oVar2 = com.tencent.mm.plugin.finder.live.model.o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ2 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
            if (dfZ2 != null) {
                str2 = dfZ2.uEq;
            } else {
                str2 = null;
            }
            jSONObject.put("appid", str2);
            com.tencent.mm.plugin.finder.live.model.o oVar3 = com.tencent.mm.plugin.finder.live.model.o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ3 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
            long j3 = (dfZ3 == null || (awe = dfZ3.liveInfo) == null) ? -1 : awe.liveId;
            if (j3 < 0) {
                jSONObject.put("liveid", "");
            } else {
                jSONObject.put("liveid", com.tencent.mm.plugin.expt.hellhound.core.b.zs(j3));
            }
            c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
            jSONObject.put("clickid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEB);
            c.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
            c.a.apD("");
            com.tencent.mm.plugin.finder.report.live.k kVar8 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.a(s.c.LIVE_ANCHOR_ACTION_COMMERCE, jSONObject.toString());
        }
        AppMethodBeat.o(260976);
    }

    public static final /* synthetic */ void b(h hVar, bo boVar) {
        long j2;
        String str;
        String str2;
        awe awe;
        awc awc;
        boolean z;
        AppMethodBeat.i(260977);
        if (hVar.hOp.getLiveRole() == 1) {
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.dpl().vmn = false;
            if (boVar instanceof com.tencent.mm.plugin.finder.live.view.a.c) {
                j2 = ((com.tencent.mm.plugin.finder.live.view.a.c) boVar).uko;
            } else if (boVar instanceof com.tencent.mm.plugin.finder.live.view.a.b) {
                j2 = ((com.tencent.mm.plugin.finder.live.view.a.b) boVar).UPE;
            } else {
                j2 = 0;
            }
            com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            if (com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtA.containsKey(Long.valueOf(j2))) {
                com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                LinkedList<com.tencent.mm.plugin.finder.report.live.o> linkedList = com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtA.get(Long.valueOf(j2));
                if (linkedList != null) {
                    if (!linkedList.isEmpty()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z && !linkedList.getLast().vlm) {
                        long currentTimeMillis = System.currentTimeMillis() - linkedList.getLast().time;
                        com.tencent.mm.plugin.finder.report.live.o last = linkedList.getLast();
                        if (currentTimeMillis <= 0) {
                            currentTimeMillis = 0;
                        }
                        last.time = currentTimeMillis;
                        linkedList.getLast().vlm = true;
                        com.tencent.mm.plugin.finder.report.live.k kVar4 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                        com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtA.put(Long.valueOf(j2), linkedList);
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", s.aa.LIVE_FINISH_PROMOTE_GOODS.action);
            com.tencent.mm.plugin.finder.report.live.k kVar5 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            jSONObject.put("sessionid", com.tencent.mm.plugin.finder.report.live.k.dpl().vlJ);
            com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = com.tencent.mm.plugin.finder.live.model.o.dfZ();
            if (dfZ == null || (awc = dfZ.uEl) == null || (str = awc.vtD) == null) {
                str = "";
            }
            jSONObject.put("shopwindowid", str);
            jSONObject.put("productid", j2);
            com.tencent.mm.plugin.finder.live.model.o oVar2 = com.tencent.mm.plugin.finder.live.model.o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ2 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
            if (dfZ2 != null) {
                str2 = dfZ2.uEq;
            } else {
                str2 = null;
            }
            jSONObject.put("appid", str2);
            com.tencent.mm.plugin.finder.live.model.o oVar3 = com.tencent.mm.plugin.finder.live.model.o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ3 = com.tencent.mm.plugin.finder.live.model.o.dfZ();
            long j3 = (dfZ3 == null || (awe = dfZ3.liveInfo) == null) ? -1 : awe.liveId;
            if (j3 < 0) {
                jSONObject.put("liveid", "");
            } else {
                jSONObject.put("liveid", com.tencent.mm.plugin.expt.hellhound.core.b.zs(j3));
            }
            c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
            jSONObject.put("clickid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEB);
            c.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
            c.a.apD("");
            com.tencent.mm.plugin.finder.report.live.k kVar6 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.a(s.c.LIVE_ANCHOR_ACTION_COMMERCE, jSONObject.toString());
        }
        AppMethodBeat.o(260977);
    }

    public static final /* synthetic */ void a(h hVar, int i2, int i3) {
        AppMethodBeat.i(247856);
        bo awN = hVar.awN(i2);
        if (awN instanceof com.tencent.mm.plugin.finder.live.view.a.c) {
            Log.i("Finder.LiveShoppingListAdapter", "modifyProduct id:" + ((com.tencent.mm.plugin.finder.live.view.a.c) awN).uko + " scene:" + i3);
            long j2 = hVar.liveData.liveInfo.liveId;
            long j3 = hVar.liveData.hFK;
            String aUg = com.tencent.mm.model.z.aUg();
            p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
            new r(j2, j3, aUg, ((com.tencent.mm.plugin.finder.live.view.a.c) awN).uko, i3, new c(hVar, awN, i3, i2)).aYI();
        }
        AppMethodBeat.o(247856);
    }
}
