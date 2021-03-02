package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.hardcoder.g;
import com.tencent.mm.plugin.appbrand.jsapi.i.m;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.live.viewmodel.FinderLivePostUIC;
import com.tencent.mm.plugin.finder.upload.postui.c;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.pluginsdk.location.a;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\"\u0010\u001e\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0016R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLocationWidget;", "Lcom/tencent/mm/pluginsdk/location/IGetLocationService$IGetLocationCallback;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "root", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;)V", "REQUEST_CODE_PICK_LOCATION", "", "getREQUEST_CODE_PICK_LOCATION", "()I", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "locationWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderLocationWidget;", "getLocationWidget", "()Lcom/tencent/mm/plugin/finder/upload/postui/FinderLocationWidget;", "setLocationWidget", "(Lcom/tencent/mm/plugin/finder/upload/postui/FinderLocationWidget;)V", "getRoot", "()Landroid/view/View;", m.NAME, "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "initLocation", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onGetLbsLifes", "city", "", "lifeList", "", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "plugin-finder_release"})
public final class k implements a.AbstractC2021a {
    final MMActivity activity;
    private final View gvQ;
    public final int uHa = g.sHCENCODEVIDEOTIMEOUT;
    public c uHb;

    public k(MMActivity mMActivity, View view) {
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(view, "root");
        AppMethodBeat.i(248127);
        this.activity = mMActivity;
        this.gvQ = view;
        this.activity.getIntent().putExtra("saveLocation", false);
        this.activity.getIntent().putExtra("is_force_dark_mode", true);
        this.activity.getIntent().putExtra("show_city", false);
        this.activity.getIntent().putExtra("poi_show_none", false);
        MMActivity mMActivity2 = this.activity;
        View findViewById = this.gvQ.findViewById(R.id.gfh);
        p.g(findViewById, "root.findViewById<Finder…(R.id.post_location_view)");
        this.uHb = new c(mMActivity2, (b) findViewById, null, null, this.uHa);
        c cVar = this.uHb;
        Intent intent = this.activity.getIntent();
        p.g(intent, "activity.intent");
        cVar.c(intent, new Bundle());
        b bVar = this.uHb.vUO;
        Context context = this.gvQ.getContext();
        p.g(context, "root.context");
        bVar.setIconColor(context.getResources().getColor(R.color.am));
        b bVar2 = this.uHb.vUO;
        Context context2 = this.gvQ.getContext();
        p.g(context2, "root.context");
        bVar2.setTextColor(context2.getResources().getColor(R.color.am));
        b bVar3 = this.uHb.vUO;
        Context context3 = this.gvQ.getContext();
        p.g(context3, "root.context");
        bVar3.setDefaultStateIconColor(context3.getResources().getColor(R.color.BW_100_Alpha_0_8));
        b bVar4 = this.uHb.vUO;
        Context context4 = this.gvQ.getContext();
        p.g(context4, "root.context");
        bVar4.setDefaultStateTextColor(context4.getResources().getColor(R.color.am));
        b bVar5 = this.uHb.vUO;
        Context context5 = this.gvQ.getContext();
        p.g(context5, "root.context");
        bVar5.setDefaultLoadingPBarColor(context5.getResources().getColor(R.color.am));
        b bVar6 = this.uHb.vUO;
        Context context6 = this.gvQ.getContext();
        p.g(context6, "root.context");
        bVar6.setDefaultLoadingTipColor(context6.getResources().getColor(R.color.am));
        this.uHb.vUO.diz();
        d.i(new a(this));
        AppMethodBeat.o(248127);
    }

    @Override // com.tencent.mm.pluginsdk.location.a.AbstractC2021a
    public final void s(String str, List<chj> list) {
        AppMethodBeat.i(248126);
        List<chj> list2 = list;
        if (!(list2 == null || list2.isEmpty())) {
            FinderLivePostUIC.c cVar = FinderLivePostUIC.uDb;
            Log.i(FinderLivePostUIC.TAG, "get lbsLife success");
            this.uHb.a(str, (chj) j.ks(list));
            this.uHb.diy();
            AppMethodBeat.o(248126);
            return;
        }
        FinderLivePostUIC.c cVar2 = FinderLivePostUIC.uDb;
        Log.i(FinderLivePostUIC.TAG, "get lbsLife fail");
        this.uHb.diy();
        AppMethodBeat.o(248126);
    }

    public final axt getLocation() {
        AppMethodBeat.i(261222);
        axt axt = this.uHb.vUM;
        if (axt == null) {
            axt axt2 = new axt();
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
            o<Float, Float> dHP = FinderGlobalLocationVM.dHP();
            axt2.latitude = dHP.second.floatValue();
            axt2.dTj = dHP.first.floatValue();
            axt = axt2;
        }
        AppMethodBeat.o(261222);
        return axt;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ k uHc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(k kVar) {
            super(0);
            this.uHc = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(248125);
            if (!this.uHc.activity.getIntent().getBooleanExtra("saveLocation", false)) {
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
                if (FinderGlobalLocationVM.dHO()) {
                    com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                    com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
                    o<Float, Float> dHP = FinderGlobalLocationVM.dHP();
                    chk chk = new chk();
                    chk.LbC = dHP.first.floatValue();
                    chk.LbD = dHP.second.floatValue();
                    chk.LuW = 0;
                    chk.LuT = 1;
                    ((com.tencent.mm.pluginsdk.location.a) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.location.a.class)).a(chk, this.uHc);
                    this.uHc.uHb.diy();
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(248125);
            return xVar;
        }
    }
}
