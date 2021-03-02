package com.tencent.mm.plugin.appbrand.ui.recents;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.wu;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ap;
import com.tencent.mm.plugin.appbrand.appusage.t;
import com.tencent.mm.plugin.appbrand.launching.e.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.l;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyEmptyUI;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.ajs;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.ui.widget.imageview.WeImageView;

/* access modifiers changed from: package-private */
public final class j extends f implements View.OnClickListener, ap.c {
    private boolean odH;

    j(FragmentActivity fragmentActivity, ViewGroup viewGroup) {
        super(fragmentActivity, viewGroup);
        AppMethodBeat.i(180409);
        this.odH = b.n(fragmentActivity, "android.permission.ACCESS_FINE_LOCATION");
        AppMethodBeat.o(180409);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.f, com.tencent.mm.plugin.appbrand.ui.recents.a
    public final void onResume() {
        AppMethodBeat.i(49181);
        super.onResume();
        if (!this.odH && b.n(this.mActivity, "android.permission.ACCESS_FINE_LOCATION")) {
            this.odH = true;
            bSx();
        }
        AppMethodBeat.o(49181);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.f, com.tencent.mm.plugin.appbrand.ui.recents.a
    public final void bSx() {
        AppMethodBeat.i(49182);
        super.bSx();
        setViewEnable(bYH());
        AppMethodBeat.o(49182);
    }

    private static boolean bYH() {
        AppMethodBeat.i(227734);
        if (!((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt() || ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvp() == 1) {
            AppMethodBeat.o(227734);
            return true;
        }
        AppMethodBeat.o(227734);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
    @SuppressLint({"ResourceType"})
    public final void a(WeImageView weImageView) {
        AppMethodBeat.i(180411);
        weImageView.setVisibility(0);
        weImageView.setImageResource(R.raw.icons_outlined_location);
        weImageView.setIconColor(this.mActivity.getResources().getColor(R.color.Blue));
        AppMethodBeat.o(180411);
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ap.c
    public final void a(ajs ajs) {
        AppMethodBeat.i(180412);
        b(ajs);
        AppMethodBeat.o(180412);
    }

    @Override // com.tencent.mm.plugin.appbrand.appusage.ap.c
    public final ap.b byw() {
        return ap.b.ENTRANCE_ID_NEARBY;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.ui.recents.f
    public final String getTitle() {
        AppMethodBeat.i(180410);
        String string = this.mActivity.getResources().getString(R.string.nx);
        AppMethodBeat.o(180410);
        return string;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.f
    public final void onClick(View view) {
        AppMethodBeat.i(49192);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListNearByHeader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        FragmentActivity fragmentActivity = this.mActivity;
        if (fragmentActivity == null) {
            a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListNearByHeader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(49192);
        } else if (!this.odH) {
            bYI();
            fragmentActivity.startActivityForResult(new Intent(fragmentActivity, AppBrandNearbyEmptyUI.class).putExtra("extra_enter_reason", 1), 3);
            a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListNearByHeader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(49192);
        } else {
            EventCenter.instance.publish(new wu());
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1001;
            f.mZp.a(fragmentActivity, "gh_2b2e3862a1fb@app", null, "pages/index/index.html", 0, 0, appBrandStatObject, null, null);
            bYI();
            l lVar = new l();
            lVar.nJe = l.b.TOP_ENTRANCE_IN_DESKTOP;
            lVar.nJf = 0;
            lVar.nJg = "";
            lVar.nJi = l.a.NEARBY_MINI_PROGRAM;
            lVar.report();
            a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListNearByHeader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(49192);
        }
    }

    private void bYI() {
        AppMethodBeat.i(49193);
        FragmentActivity fragmentActivity = this.mActivity;
        if (fragmentActivity == null) {
            AppMethodBeat.o(49193);
            return;
        }
        t.d dVar = ((AppBrandLauncherUI) fragmentActivity).nTP;
        if (dVar != null) {
            dVar.byg();
        }
        if (this.obG != null) {
            com.tencent.mm.plugin.appbrand.report.f fVar = com.tencent.mm.plugin.appbrand.report.f.nGV;
            com.tencent.mm.plugin.appbrand.report.f.b(this.mActivity).bUr();
        }
        AppMethodBeat.o(49193);
    }
}
