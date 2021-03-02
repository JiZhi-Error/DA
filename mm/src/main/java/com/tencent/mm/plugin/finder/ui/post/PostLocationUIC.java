package com.tencent.mm.plugin.finder.ui.post;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.upload.postui.c;
import com.tencent.mm.pluginsdk.location.a;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\"\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\b\u0010\u001c\u001a\u00020\u0011H\u0002J\u0006\u0010\u001d\u001a\u00020\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/post/PostLocationUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/pluginsdk/location/IGetLocationService$IGetLocationCallback;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "locationWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderLocationWidget;", "postDataManager", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "getPostDataManager", "()Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "postDataManager$delegate", "Lkotlin/Lazy;", "checkPermission", "", "initLocationWidget", "", "initView", "onGetLbsLifes", "city", "", "lifeList", "", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "onSelectLocation", "data", "Landroid/content/Intent;", "requestLocation", "restore", "plugin-finder_release"})
public final class PostLocationUIC extends UIComponent implements a.AbstractC2021a {
    c uHb;
    private final f vQW;

    /* access modifiers changed from: package-private */
    public final com.tencent.mm.plugin.finder.widget.post.c dAD() {
        AppMethodBeat.i(252956);
        com.tencent.mm.plugin.finder.widget.post.c cVar = (com.tencent.mm.plugin.finder.widget.post.c) this.vQW.getValue();
        AppMethodBeat.o(252956);
        return cVar;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PostLocationUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(252959);
        this.vQW = g.ah(new b(appCompatActivity));
        AppMethodBeat.o(252959);
    }

    public static final /* synthetic */ c a(PostLocationUIC postLocationUIC) {
        AppMethodBeat.i(252960);
        c cVar = postLocationUIC.uHb;
        if (cVar == null) {
            p.btv("locationWidget");
        }
        AppMethodBeat.o(252960);
        return cVar;
    }

    /* access modifiers changed from: package-private */
    public final boolean TW() {
        AppMethodBeat.i(252957);
        if (Build.VERSION.SDK_INT >= 23 || !(!p.j("MNC", Build.VERSION.CODENAME))) {
            try {
                if (android.support.v4.content.b.checkSelfPermission(getActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
                    AppMethodBeat.o(252957);
                    return true;
                }
                AppMethodBeat.o(252957);
                return false;
            } catch (Exception e2) {
                Log.e("SimpleUIComponent", "check mpermission exception:%s.", e2);
                AppMethodBeat.o(252957);
                return true;
            }
        } else {
            AppMethodBeat.o(252957);
            return true;
        }
    }

    @Override // com.tencent.mm.pluginsdk.location.a.AbstractC2021a
    public final void s(String str, List<chj> list) {
        AppMethodBeat.i(252958);
        List<chj> list2 = list;
        if (!(list2 == null || list2.isEmpty())) {
            Log.i("SimpleUIComponent", "get lbsLife success");
            c cVar = this.uHb;
            if (cVar == null) {
                p.btv("locationWidget");
            }
            dAD();
            cVar.a(str, (chj) j.ks(list));
            AppMethodBeat.o(252958);
            return;
        }
        c cVar2 = this.uHb;
        if (cVar2 == null) {
            p.btv("locationWidget");
        }
        cVar2.diy();
        AppMethodBeat.o(252958);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "invoke"})
    static final class b extends q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.widget.post.c> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.widget.post.c invoke() {
            AppMethodBeat.i(252955);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.plugin.finder.widget.post.c dAD = ((PostMainUIC) com.tencent.mm.ui.component.a.b(this.uQi).get(PostMainUIC.class)).dAD();
            AppMethodBeat.o(252955);
            return dAD;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ PostLocationUIC vRa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(PostLocationUIC postLocationUIC) {
            super(0);
            this.vRa = postLocationUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(252954);
            c a2 = PostLocationUIC.a(this.vRa);
            if (!a2.vUN) {
                a2.isLoading = true;
                a2.vUO.dix();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(252954);
            return xVar;
        }
    }
}
