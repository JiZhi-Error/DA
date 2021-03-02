package com.tencent.mm.plugin.appbrand.openmaterial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.openmaterial.h;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialDetailModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/openmaterial/ListBottomSheetEnhanceLogic;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/BottomSheetEnhanceLogic;", "openMaterialScene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "context", "Landroid/content/Context;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "openMaterialBottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;Landroid/content/Context;Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;)V", "buildMoreOpenWaysView", "Landroid/view/View;", "enhance", "", "type", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IEnhanceBottomSheetController$EnhanceType;", "plugin-appbrand-integration_release"})
public final class k extends c {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(b bVar, Context context, e eVar, AppBrandOpenMaterialCollection appBrandOpenMaterialCollection, g gVar, j jVar) {
        super(bVar, context, eVar, appBrandOpenMaterialCollection, gVar, jVar);
        p.h(bVar, "openMaterialScene");
        p.h(context, "context");
        p.h(eVar, "bottomSheet");
        p.h(appBrandOpenMaterialCollection, "openMaterialCollection");
        p.h(jVar, "launchAppBrandExecutor");
        AppMethodBeat.i(229128);
        AppMethodBeat.o(229128);
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.h
    public final void a(h.a aVar) {
        boolean z;
        AppMethodBeat.i(261690);
        p.h(aVar, "type");
        Log.d("MicroMsg.AppBrand.ListBottomSheetEnhanceLogic", "enhance, type: ".concat(String.valueOf(aVar)));
        List<AppBrandOpenMaterialDetailModel> list = this.nkx.nlF;
        p.g(list, "openMaterialCollection.a…dOpenMaterialDetailModels");
        if (!list.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            e eVar = this.hOv;
            View inflate = LayoutInflater.from(this.context).inflate(R.layout.dc, (ViewGroup) null);
            int color = this.context.getResources().getColor(R.color.a2x);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.fkp);
            if (imageView != null) {
                imageView.setImageDrawable(ar.m(this.context, R.raw.icons_filled_mini_program, color));
            }
            TextView textView = (TextView) inflate.findViewById(R.id.fkq);
            if (textView != null) {
                textView.setTextColor(color);
            }
            inflate.setOnClickListener(new a(this));
            p.g(inflate, "moreOpenWaysView");
            eVar.setFooterView(inflate);
            if (this.hOv.isShowing()) {
                d.a(this.hOv, this.context);
            }
        }
        AppMethodBeat.o(261690);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ k nlk;

        a(k kVar) {
            this.nlk = kVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(229126);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/openmaterial/ListBottomSheetEnhanceLogic$buildMoreOpenWaysView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.AppBrand.ListBottomSheetEnhanceLogic", "buildMoreOpenWaysView#onClick");
            this.nlk.hOv.bMo();
            this.nlk.bQb().show();
            this.nlk.nkz.bQl();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/openmaterial/ListBottomSheetEnhanceLogic$buildMoreOpenWaysView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(229126);
        }
    }
}
