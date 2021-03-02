package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView;

public class MenuAppBrandRecentView extends BaseAppBrandRecentView {
    private static final int oDK = (d.omI - 1);
    private static final int oDL = d.omI;
    private AppBrandRecentView.b oDv;

    public MenuAppBrandRecentView(Context context) {
        super(context);
    }

    public MenuAppBrandRecentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
    public int getLayoutId() {
        return R.layout.gs;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
    public String getType() {
        AppMethodBeat.i(227833);
        String simpleName = MenuAppBrandRecentView.class.getSimpleName();
        AppMethodBeat.o(227833);
        return simpleName;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView, com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
    public void setOnItemClickListener(AppBrandRecentView.b bVar) {
        this.oDv = bVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
    public final void a(BaseAppBrandRecentView.b bVar, e eVar, int i2) {
        AppMethodBeat.i(227834);
        super.a(bVar, eVar, i2);
        bVar.titleTv.setTextColor(getContext().getResources().getColor(R.color.a2x));
        if (eVar == null || eVar.type != 2) {
            if (eVar != null && eVar.type == -1) {
                bVar.nnL.setImageResource(R.raw.default_avatar);
            }
            AppMethodBeat.o(227834);
            return;
        }
        bVar.titleTv.setVisibility(0);
        bVar.ooB.setVisibility(8);
        bVar.titleTv.setText(R.string.f7p);
        bVar.nnL.setImageResource(R.raw.app_brand_capsule_multitasking_wechat);
        AppMethodBeat.o(227834);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
    public int getLoadCount() {
        return oDL;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
    public int getShowCount() {
        return oDK;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
    public final void init(Context context) {
        AppMethodBeat.i(227835);
        super.init(context);
        super.setOnItemClickListener(new AppBrandRecentView.b() {
            /* class com.tencent.mm.plugin.appbrand.widget.recent.MenuAppBrandRecentView.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView.b
            public final boolean a(View view, e eVar, float f2, float f3) {
                boolean z;
                AppMethodBeat.i(227831);
                if (MenuAppBrandRecentView.this.oDv != null) {
                    z = MenuAppBrandRecentView.this.oDv.a(view, eVar, f2, f3);
                } else {
                    z = false;
                }
                if (z) {
                    AppMethodBeat.o(227831);
                    return true;
                }
                if (eVar.type != 2) {
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = 1090;
                    ((r) g.af(r.class)).a(MenuAppBrandRecentView.this.getContext(), eVar.ooj.username, (String) null, eVar.ooj.iOo, -1, (String) null, appBrandStatObject);
                }
                AppMethodBeat.o(227831);
                return false;
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView.b
            public final boolean b(View view, e eVar, float f2, float f3) {
                AppMethodBeat.i(227832);
                boolean z = false;
                if (MenuAppBrandRecentView.this.oDv != null) {
                    z = MenuAppBrandRecentView.this.oDv.b(view, eVar, f2, f3);
                }
                AppMethodBeat.o(227832);
                return z;
            }
        });
        AppMethodBeat.o(227835);
    }
}
