package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.x;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0005\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\t\u001a\u0004\b\n\u0010\u0007R#\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDistrictTipUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "isSelf", "", "()Z", "isSelf$delegate", "Lkotlin/Lazy;", "isSelfFlag", "isSelfFlag$delegate", ch.COL_USERNAME, "", "kotlin.jvm.PlatformType", "getUsername", "()Ljava/lang/String;", "username$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderProfileDistrictTipUIC extends UIComponent {
    private final f tZk;
    private final f tZl;
    private final f vag = g.ah(new a(this));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderProfileDistrictTipUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(250137);
        this.tZk = g.ah(new e(appCompatActivity));
        this.tZl = g.ah(new b(this));
        AppMethodBeat.o(250137);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        app app;
        AppMethodBeat.i(250136);
        super.onCreate(bundle);
        if (((Boolean) this.vag.getValue()).booleanValue() && ((Boolean) this.tZl.getValue()).booleanValue()) {
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.drV() != 1) {
                com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.drW()) {
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    bme bme = ((FinderGlobalLocationVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class)).wtO;
                    if (bme != null) {
                        c.a aVar2 = com.tencent.mm.plugin.finder.api.c.tsp;
                        com.tencent.mm.plugin.finder.api.g asG = c.a.asG(z.aUg());
                        if (asG == null || (app = asG.field_extInfo) == null) {
                            AppMethodBeat.o(250136);
                            return;
                        }
                        if ((!p.j(bme.keh, app.country)) || (!p.j(bme.kdZ, app.fuJ)) || (!p.j(bme.kea, app.fuK))) {
                            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                            p.g(aAh, "MMKernel.storage()");
                            aAh.azQ().set(ar.a.USERINFO_FINDER_SHOW_CHANGE_DISTRICT_LONG, (Object) 1L);
                            com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
                            bme bme2 = ((FinderGlobalLocationVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class)).wtO;
                            if (bme2 != null) {
                                AppCompatActivity activity = getActivity();
                                y yVar = y.vXH;
                                String str = bme2.keh;
                                p.g(str, "it.Country");
                                String str2 = bme2.kdZ;
                                p.g(str2, "it.Province");
                                String str3 = bme2.kea;
                                p.g(str3, "it.City");
                                String string = activity.getString(R.string.d0p, new Object[]{y.al(str, str2, str3)});
                                p.g(string, "activity.getString(R.str…y, it.Province, it.City))");
                                h.a((Context) getActivity(), string, "", getString(R.string.d9_), getString(R.string.sz), true, (DialogInterface.OnClickListener) new c(bme2, bme, this), (DialogInterface.OnClickListener) new d(bme, this));
                                AppMethodBeat.o(250136);
                                return;
                            }
                        }
                        AppMethodBeat.o(250136);
                        return;
                    }
                }
            }
        }
        AppMethodBeat.o(250136);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\n"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDistrictTipUIC$onCreate$1$1$1$1", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDistrictTipUIC$$special$$inlined$let$lambda$1", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDistrictTipUIC$$special$$inlined$let$lambda$3"})
    static final class c implements DialogInterface.OnClickListener {
        final /* synthetic */ FinderProfileDistrictTipUIC vaC;
        final /* synthetic */ bme vaD;
        final /* synthetic */ bme vaE;

        c(bme bme, bme bme2, FinderProfileDistrictTipUIC finderProfileDistrictTipUIC) {
            this.vaD = bme;
            this.vaE = bme2;
            this.vaC = finderProfileDistrictTipUIC;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(250133);
            k kVar = k.vfA;
            String a2 = FinderProfileDistrictTipUIC.a(this.vaC);
            p.g(a2, ch.COL_USERNAME);
            k.dA(a2, 1);
            String str = this.vaD.keh;
            p.g(str, "it.Country");
            String str2 = this.vaD.kdZ;
            p.g(str2, "it.Province");
            String str3 = this.vaD.kea;
            p.g(str3, "it.City");
            ((x) com.tencent.mm.kernel.g.af(x.class)).a(str, str2, str3, 0, new ai<azg>(this) {
                /* class com.tencent.mm.plugin.finder.profile.uic.FinderProfileDistrictTipUIC.c.AnonymousClass1 */
                final /* synthetic */ c vaF;

                {
                    this.vaF = r1;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
                @Override // com.tencent.mm.plugin.i.a.ai
                public final /* synthetic */ void a(azg azg, apg apg) {
                    AppMethodBeat.i(250132);
                    p.h(azg, "req");
                    p.h(apg, "ret");
                    if (apg.retCode == 0) {
                        u.makeText(this.vaF.vaC.getActivity(), this.vaF.vaC.getString(R.string.daz), 0).show();
                        AppMethodBeat.o(250132);
                        return;
                    }
                    u.makeText(this.vaF.vaC.getActivity(), this.vaF.vaC.getString(R.string.dax), 0).show();
                    AppMethodBeat.o(250132);
                }
            });
            AppMethodBeat.o(250133);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\n"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDistrictTipUIC$onCreate$1$1$1$2", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDistrictTipUIC$$special$$inlined$let$lambda$2", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDistrictTipUIC$$special$$inlined$let$lambda$4"})
    static final class d implements DialogInterface.OnClickListener {
        final /* synthetic */ FinderProfileDistrictTipUIC vaC;
        final /* synthetic */ bme vaE;

        d(bme bme, FinderProfileDistrictTipUIC finderProfileDistrictTipUIC) {
            this.vaE = bme;
            this.vaC = finderProfileDistrictTipUIC;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(250134);
            k kVar = k.vfA;
            String a2 = FinderProfileDistrictTipUIC.a(this.vaC);
            p.g(a2, ch.COL_USERNAME);
            k.dA(a2, 2);
            AppMethodBeat.o(250134);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ FinderProfileDistrictTipUIC vaC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(FinderProfileDistrictTipUIC finderProfileDistrictTipUIC) {
            super(0);
            this.vaC = finderProfileDistrictTipUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(250130);
            Boolean valueOf = Boolean.valueOf(p.j(FinderProfileDistrictTipUIC.a(this.vaC), z.aUg()));
            AppMethodBeat.o(250130);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends q implements kotlin.g.a.a<String> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(250135);
            String stringExtra = this.uQi.getIntent().getStringExtra("finder_username");
            AppMethodBeat.o(250135);
            return stringExtra;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ FinderProfileDistrictTipUIC vaC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderProfileDistrictTipUIC finderProfileDistrictTipUIC) {
            super(0);
            this.vaC = finderProfileDistrictTipUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(250131);
            Boolean valueOf = Boolean.valueOf(this.vaC.getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false));
            AppMethodBeat.o(250131);
            return valueOf;
        }
    }

    public static final /* synthetic */ String a(FinderProfileDistrictTipUIC finderProfileDistrictTipUIC) {
        AppMethodBeat.i(250138);
        String str = (String) finderProfileDistrictTipUIC.tZk.getValue();
        AppMethodBeat.o(250138);
        return str;
    }
}
