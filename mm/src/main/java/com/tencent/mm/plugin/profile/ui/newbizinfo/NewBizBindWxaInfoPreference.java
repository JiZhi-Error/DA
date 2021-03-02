package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.c;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.List;

public class NewBizBindWxaInfoPreference extends Preference {
    private static final int gCk = a.fromDPToPix(MMApplicationContext.getContext(), 25);
    private static final int gCl = a.fromDPToPix(MMApplicationContext.getContext(), 20);
    private static final int gCm = a.fromDPToPix(MMApplicationContext.getContext(), 2);
    private static int gCn = -1;
    private View.OnClickListener BcZ;
    private c Bdk;
    private Context context;
    private b.h gCj;
    private View mView = null;
    private ThreeDotsLoadingView nNl;
    private AppBrandNearbyShowcaseView ogf;
    private View ogg;
    private boolean ogh = false;
    private List<WxaAttributes.WxaEntryInfo> olD;
    private View.OnClickListener rID;

    public NewBizBindWxaInfoPreference(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(27482);
        this.context = context2;
        init();
        AppMethodBeat.o(27482);
    }

    public NewBizBindWxaInfoPreference(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(27483);
        this.context = context2;
        init();
        AppMethodBeat.o(27483);
    }

    private void init() {
        AppMethodBeat.i(27484);
        this.rID = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizBindWxaInfoPreference.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(27478);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Object tag = view.getTag();
                if (tag == null || !(tag instanceof String)) {
                    Log.e("MicroMsg.NewBizBindWxaInfoPreference", "username is null, err");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(27478);
                    return;
                }
                Log.i("MicroMsg.NewBizBindWxaInfoPreference", "jump to wxa:%s", (String) tag);
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1020;
                appBrandStatObject.dCw = NewBizBindWxaInfoPreference.this.Bdk.field_username;
                ((r) g.af(r.class)).a(NewBizBindWxaInfoPreference.this.mContext, (String) tag, null, 0, 0, null, appBrandStatObject, NewBizBindWxaInfoPreference.this.Bdk.field_appId);
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.I(NewBizBindWxaInfoPreference.this.Bdk.field_username, 500, 0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(27478);
            }
        };
        this.BcZ = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizBindWxaInfoPreference.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(27479);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizBindWxaInfoPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ((t) g.af(t.class)).a(NewBizBindWxaInfoPreference.this.mContext, NewBizBindWxaInfoPreference.this.Bdk.field_username, NewBizBindWxaInfoPreference.this.Bdk.field_appId, NewBizBindWxaInfoPreference.this.olD);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizBindWxaInfoPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(27479);
            }
        };
        gCn = this.context.getResources().getColor(R.color.vl);
        AppMethodBeat.o(27484);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(27485);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(27485);
        return view2;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(27486);
        super.onBindView(view);
        this.ogg = view.findViewById(R.id.fve);
        this.nNl = (ThreeDotsLoadingView) view.findViewById(R.id.fvg);
        this.ogf = (AppBrandNearbyShowcaseView) view.findViewById(R.id.fvf);
        this.ogf.setIconSize(gCk + (gCm * 2));
        this.ogf.setIconGap(gCl);
        rJ();
        AppMethodBeat.o(27486);
    }

    private void rJ() {
        AppMethodBeat.i(27487);
        if (this.nNl == null) {
            Log.i("MicroMsg.NewBizBindWxaInfoPreference", "startLoad or mLoadingView is null");
            AppMethodBeat.o(27487);
        } else if (this.ogh) {
            Log.i("MicroMsg.NewBizBindWxaInfoPreference", "startLoad has load.");
            AppMethodBeat.o(27487);
        } else {
            this.ogh = true;
            cH(this.ogg);
            g(this.nNl, null);
            this.nNl.gZh();
            bBG();
            AppMethodBeat.o(27487);
        }
    }

    static {
        AppMethodBeat.i(27491);
        AppMethodBeat.o(27491);
    }

    private void bBG() {
        AppMethodBeat.i(27488);
        if (this.Bdk == null || this.olD == null) {
            Log.w("MicroMsg.NewBizBindWxaInfoPreference", "mWxaEntryInfoList or bizInfo is null, return");
            AppMethodBeat.o(27488);
            return;
        }
        this.nNl.gZi();
        cH(this.nNl);
        if (this.olD.size() > 0) {
            this.ogf.setVisibility(0);
            this.ogf.setIconLayerCount(Math.min(this.olD.size(), 4));
            final boolean z = this.ogg.getVisibility() != 0;
            if (z) {
                this.ogf.bZV();
            }
            if (this.gCj == null) {
                this.gCj = new com.tencent.mm.plugin.appbrand.ui.widget.a(gCk, gCm, gCn);
            }
            for (int i2 = 0; i2 < this.ogf.getChildCount(); i2++) {
                b.aXY().a(this.ogf.zK(i2), this.olD.size() > i2 ? this.olD.get(i2).iconUrl : null, com.tencent.mm.modelappbrand.a.a.aXX(), this.gCj);
            }
            g(this.ogg, new Runnable() {
                /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizBindWxaInfoPreference.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(27480);
                    if (z && NewBizBindWxaInfoPreference.this.ogf != null) {
                        NewBizBindWxaInfoPreference.this.ogf.bZW();
                    }
                    AppMethodBeat.o(27480);
                }
            });
            if (this.olD.size() == 1) {
                this.mView.setTag(this.olD.get(0).username);
                this.mView.setOnClickListener(this.rID);
                AppMethodBeat.o(27488);
                return;
            }
            this.mView.setTag(null);
            this.mView.setOnClickListener(this.BcZ);
            AppMethodBeat.o(27488);
            return;
        }
        this.ogf.setVisibility(8);
        AppMethodBeat.o(27488);
    }

    private static void g(View view, Runnable runnable) {
        AppMethodBeat.i(27489);
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.animate().setDuration(200).alpha(1.0f).withEndAction(runnable).start();
        AppMethodBeat.o(27489);
    }

    private void cH(final View view) {
        AppMethodBeat.i(27490);
        if (view.getVisibility() == 0) {
            view.animate().setDuration(200).alpha(0.0f).withEndAction(new Runnable() {
                /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizBindWxaInfoPreference.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(27481);
                    view.setVisibility(8);
                    AppMethodBeat.o(27481);
                }
            }).start();
        }
        AppMethodBeat.o(27490);
    }
}
