package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.extension.reddot.h;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "showBottomSheetRunnable", "Ljava/lang/Runnable;", "getShowBottomSheetRunnable", "()Ljava/lang/Runnable;", "setShowBottomSheetRunnable", "(Ljava/lang/Runnable;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "showBottomSheet", "Companion", "plugin-finder_release"})
public final class FinderPostQualificationUIC extends UIComponent {
    public static final a wyS = new a((byte) 0);
    Runnable wyR;

    static {
        AppMethodBeat.i(255861);
        AppMethodBeat.o(255861);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    static final class b<T> implements Observer<h.a> {
        final /* synthetic */ FinderPostQualificationUIC wyT;
        final /* synthetic */ z.a wyU;

        b(FinderPostQualificationUIC finderPostQualificationUIC, z.a aVar) {
            this.wyT = finderPostQualificationUIC;
            this.wyU = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            AppMethodBeat.i(255856);
            h.a aVar2 = aVar;
            Log.i("Finder.PostQualityUIC", "[MENU_ID_POST] red=" + (aVar2 != null && aVar2.dEF) + "，hasShowQualityBottomSheet = " + this.wyU.SYB);
            if (aVar2 != null) {
                if (aVar2.dEF) {
                    bdo bdo = aVar2.tKS;
                    if ((!p.j(bdo != null ? bdo.title : null, "temp")) && !this.wyU.SYB) {
                        this.wyU.SYB = true;
                        e aAh = g.aAh();
                        p.g(aAh, "MMKernel.storage()");
                        aAh.azQ().set(ar.a.USERINFO_FINDER_HAS_SHOWN_GET_POST_QUALITY_TIPS_BOOLEAN_SYNC, Boolean.TRUE);
                        this.wyT.wyR = new Runnable(this) {
                            /* class com.tencent.mm.plugin.finder.viewmodel.component.FinderPostQualificationUIC.b.AnonymousClass1 */
                            final /* synthetic */ b wyV;

                            {
                                this.wyV = r1;
                            }

                            public final void run() {
                                AppMethodBeat.i(255855);
                                FinderPostQualificationUIC.a(this.wyV.wyT);
                                AppMethodBeat.o(255855);
                            }
                        };
                    }
                }
                AppMethodBeat.o(255856);
                return;
            }
            AppMethodBeat.o(255856);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderPostQualificationUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255860);
        AppMethodBeat.o(255860);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(255858);
        super.onCreate(bundle);
        z.a aVar = new z.a();
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_FINDER_HAS_SHOWN_GET_POST_QUALITY_TIPS_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(255858);
            throw tVar;
        }
        aVar.SYB = ((Boolean) obj).booleanValue();
        if (!aVar.SYB) {
            h hVar = h.tKR;
            h hVar2 = h.tKR;
            h.a(h.daL(), getActivity(), new b(this, aVar));
        }
        AppMethodBeat.o(255858);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(255859);
        super.onResume();
        if (this.wyR != null) {
            Log.i("Finder.PostQualityUIC", "showBottomSheet onResume");
            Runnable runnable = this.wyR;
            if (runnable == null) {
                p.hyc();
            }
            d.a(0, runnable);
        }
        AppMethodBeat.o(255859);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC$showBottomSheet$1$1"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.finder.view.d tOn;

        c(com.tencent.mm.plugin.finder.view.d dVar) {
            this.tOn = dVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(255857);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.tOn.bMo();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderPostQualificationUIC$showBottomSheet$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255857);
        }
    }

    public static final /* synthetic */ void a(FinderPostQualificationUIC finderPostQualificationUIC) {
        AppMethodBeat.i(255862);
        Log.i("Finder.PostQualityUIC", "showBottomSheet");
        String aUg = com.tencent.mm.model.z.aUg();
        if (!(aUg == null || aUg.length() == 0)) {
            Log.i("Finder.PostQualityUIC", "showBottomSheet return ,finder account exit");
        }
        com.tencent.mm.plugin.finder.view.d dVar = new com.tencent.mm.plugin.finder.view.d(finderPostQualificationUIC.getActivity());
        dVar.Ml(R.layout.abd);
        dVar.lJI.findViewById(R.id.djr).setOnClickListener(new c(dVar));
        ((ImageView) dVar.lJI.findViewById(R.id.djt)).setImageResource(ao.isDarkMode() ? R.drawable.csv : R.drawable.csu);
        dVar.dGm();
        finderPostQualificationUIC.wyR = null;
        AppMethodBeat.o(255862);
    }
}
