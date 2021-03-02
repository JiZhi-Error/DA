package com.tencent.mm.plugin.appbrand.ui.banner;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class d extends b implements View.OnClickListener, f {
    private static boolean oag = false;
    private View oaa;
    private TextView oab;
    private ImageView oac;
    private String oad;
    private final Runnable oae;
    private final b.k oaf;

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getLayoutId() {
        return R.layout.pv;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final boolean bYa() {
        AppMethodBeat.i(48994);
        if (!oag) {
            ((e) g.af(e.class)).b(this);
            ((e) g.af(e.class)).bXX();
            ((e) g.af(e.class)).a(this);
            oag = true;
        }
        BannerModel bYf = BannerModel.bYf();
        if (bYf == null || Util.isNullOrNil(bYf.appId)) {
            setVisibility(8);
            AppMethodBeat.o(48994);
            return false;
        }
        String str = bYf.appName;
        String str2 = bYf.oax;
        String str3 = bYf.kVZ;
        if (!Util.isNullOrNil(str2)) {
            str = str2;
        }
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(48994);
            return false;
        }
        setVisibility(0);
        if (this.oab != null) {
            this.oab.setText(str);
        }
        if (!Util.isNullOrNil(str3)) {
            Bitmap bitmap = null;
            if (!Util.isNullOrNil(this.oad)) {
                bitmap = com.tencent.mm.modelappbrand.a.b.aXY().LE(this.oad);
            }
            if (bitmap == null || bitmap.isRecycled()) {
                this.oad = com.tencent.mm.modelappbrand.a.b.aXY().a(this.oaf, str3, com.tencent.mm.modelappbrand.a.g.iJB);
            } else {
                this.oaf.I(bitmap);
            }
        }
        AppMethodBeat.o(48994);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void setVisibility(int i2) {
        AppMethodBeat.i(48995);
        if (this.oaa != null) {
            this.oaa.setVisibility(i2);
        }
        AppMethodBeat.o(48995);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void destroy() {
        AppMethodBeat.i(48996);
        if (this.oaa != null) {
            ((ViewGroup) this.oaa).removeAllViews();
            this.oaa.setVisibility(8);
        }
        this.oaa = null;
        this.oab = null;
        this.oac = null;
        ((e) g.af(e.class)).b(this);
        AppMethodBeat.o(48996);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(48997);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        BannerModel bYf = BannerModel.bYf();
        if (bYf == null) {
            a.a(this, "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(48997);
            return;
        }
        String str = bYf.appId;
        int i2 = bYf.iOo;
        if (Util.isNullOrNil(str)) {
            bYa();
            a.a(this, "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(48997);
            return;
        }
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1022;
        ((r) g.af(r.class)).a(view.getContext(), (String) null, str, i2, -1, (String) null, appBrandStatObject);
        a.a(this, "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(48997);
    }

    public static void bYb() {
        oag = false;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.banner.f
    public final void bJ(String str, int i2) {
        AppMethodBeat.i(48998);
        MMHandlerThread.postToMainThread(this.oae);
        AppMethodBeat.o(48998);
    }
}
