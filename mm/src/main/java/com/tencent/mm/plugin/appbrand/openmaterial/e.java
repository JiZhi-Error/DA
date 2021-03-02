package com.tencent.mm.plugin.appbrand.openmaterial;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.ng;
import com.tencent.mm.g.b.a.nz;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.openmaterial.a.b;
import com.tencent.mm.plugin.appbrand.openmaterial.f;
import com.tencent.mm.plugin.appbrand.openmaterial.h;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialDetailModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.BaseAppBrandOpenMaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001/B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u001b\u001a\u00020\u0012H\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015H\u0002J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020\u0016H\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0002R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R'\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00148BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/openmaterial/GridBottomSheetEnhanceLogic;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/BottomSheetEnhanceLogic;", "openMaterialScene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "context", "Landroid/content/Context;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "openMaterialBottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;Landroid/content/Context;Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;)V", "curEnhanceState", "Lcom/tencent/mm/plugin/appbrand/openmaterial/GridBottomSheetEnhanceLogic$EnhanceState;", "enhancedMenu", "Lcom/tencent/mm/ui/base/MMMenu;", "itemClickAction", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialModel;", "", "getItemClickAction", "()Lkotlin/jvm/functions/Function1;", "itemClickAction$delegate", "Lkotlin/Lazy;", "convertOpenMaterialCollection2Menu", "convertOpenMaterialModel2MenuItem", "Lcom/tencent/mm/ui/base/MMMenuItem;", FirebaseAnalytics.b.INDEX, "", "openMaterialModel", "enhance", "newEnhanceType", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IEnhanceBottomSheetController$EnhanceType;", "enable", "", "enhanceInner", "enhanceQuick", "isViewExposure", "view", "Landroid/view/View;", "revokeEnhance", "wrapIconWithPadding", "Landroid/graphics/Bitmap;", "icon", "EnhanceState", "plugin-appbrand-integration_release"})
public final class e extends c {
    private d FTW = new d(h.a.HIDE, true);
    private m nkQ;
    private final kotlin.f nkR;

    public static final /* synthetic */ Bitmap W(Bitmap bitmap) {
        AppMethodBeat.i(229123);
        Bitmap V = V(bitmap);
        AppMethodBeat.o(229123);
        return V;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(com.tencent.mm.plugin.appbrand.openmaterial.model.b bVar, Context context, com.tencent.mm.ui.widget.a.e eVar, AppBrandOpenMaterialCollection appBrandOpenMaterialCollection, g gVar, j jVar) {
        super(bVar, context, eVar, appBrandOpenMaterialCollection, gVar, jVar);
        p.h(bVar, "openMaterialScene");
        p.h(context, "context");
        p.h(eVar, "bottomSheet");
        p.h(appBrandOpenMaterialCollection, "openMaterialCollection");
        p.h(jVar, "launchAppBrandExecutor");
        AppMethodBeat.i(229121);
        this.nkR = kotlin.g.ah(new j(eVar, jVar, context, appBrandOpenMaterialCollection));
        AppMethodBeat.o(229121);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/openmaterial/GridBottomSheetEnhanceLogic$EnhanceState;", "", "type", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IEnhanceBottomSheetController$EnhanceType;", "hidden", "", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/IEnhanceBottomSheetController$EnhanceType;Z)V", "getHidden", "()Z", "getType", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/IEnhanceBottomSheetController$EnhanceType;", "component1", "component2", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "plugin-appbrand-integration_release"})
    public static final class d {
        final h.a FUu;
        final boolean nno;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
            if (r3.nno == r4.nno) goto L_0x001e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 261672(0x3fe28, float:3.6668E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x001e
                boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.openmaterial.e.d
                if (r0 == 0) goto L_0x0023
                com.tencent.mm.plugin.appbrand.openmaterial.e$d r4 = (com.tencent.mm.plugin.appbrand.openmaterial.e.d) r4
                com.tencent.mm.plugin.appbrand.openmaterial.h$a r0 = r3.FUu
                com.tencent.mm.plugin.appbrand.openmaterial.h$a r1 = r4.FUu
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0023
                boolean r0 = r3.nno
                boolean r1 = r4.nno
                if (r0 != r1) goto L_0x0023
            L_0x001e:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0022:
                return r0
            L_0x0023:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0022
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.openmaterial.e.d.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(261671);
            h.a aVar = this.FUu;
            int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
            boolean z = this.nno;
            if (z) {
                z = true;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = i2 + hashCode;
            AppMethodBeat.o(261671);
            return i5;
        }

        public final String toString() {
            AppMethodBeat.i(261670);
            String str = "EnhanceState(type=" + this.FUu + ", hidden=" + this.nno + ")";
            AppMethodBeat.o(261670);
            return str;
        }

        public d(h.a aVar, boolean z) {
            p.h(aVar, "type");
            AppMethodBeat.i(261669);
            this.FUu = aVar;
            this.nno = z;
            AppMethodBeat.o(261669);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.h
    public final void a(h.a aVar) {
        AppMethodBeat.i(261685);
        p.h(aVar, "newEnhanceType");
        Log.i("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "enhance, newEnhanceType: " + aVar + ", curEnhanceState: " + this.FTW);
        if (this.FTW.FUu == aVar) {
            AppMethodBeat.o(261685);
            return;
        }
        switch (m.$EnumSwitchMapping$0[aVar.ordinal()]) {
            case 1:
                ji(true);
                break;
            case 2:
                ji(false);
                break;
            case 3:
                Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "revokeEnhance");
                this.hOv.a(new m(this.context), null, null);
                this.hOv.a((o.a) null);
                this.hOv.a(l.FVy);
                this.hOv.Dn(false);
                this.FTW = new d(h.a.HIDE, true);
                break;
        }
        if (this.hOv.isShowing()) {
            d.a(this.hOv, this.context);
        }
        AppMethodBeat.o(261685);
    }

    private final void ji(boolean z) {
        h.a aVar;
        AppMethodBeat.i(261686);
        Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "enhance, enable: ".concat(String.valueOf(z)));
        if (this.FTW.nno) {
            mN(z);
        } else {
            ng(z);
        }
        if (z) {
            aVar = h.a.ENABLE;
        } else {
            aVar = h.a.DISABLE;
        }
        this.FTW = new d(aVar, false);
        AppMethodBeat.o(261686);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onClick"})
    static final class l implements e.AbstractC2138e {
        public static final l FVy = new l();

        static {
            AppMethodBeat.i(261684);
            AppMethodBeat.o(261684);
        }

        l() {
        }

        @Override // com.tencent.mm.ui.widget.a.e.AbstractC2138e
        public final void onClick() {
        }
    }

    private final void mN(boolean z) {
        boolean z2;
        AppMethodBeat.i(261687);
        Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "enhance, enable: ".concat(String.valueOf(z)));
        k kVar = k.FUU;
        this.hOv.a(cbj(), C0761e.FUv, f.FUw);
        this.hOv.a(kVar);
        List<AppBrandOpenMaterialDetailModel> list = this.nkx.nlF;
        p.g(list, "openMaterialCollection.a…dOpenMaterialDetailModels");
        if (!list.isEmpty()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.hOv.a(new g(this), this.context.getString(R.string.o5), h.FUT, kVar, new i(this));
        }
        ng(z);
        AppMethodBeat.o(261687);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "imageView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MenuItem;", "onAttach"})
    public static final class k implements o.a {
        public static final k FUU = new k();

        static {
            AppMethodBeat.i(261683);
            AppMethodBeat.o(261683);
        }

        k() {
        }

        @Override // com.tencent.mm.ui.base.o.a
        public final void f(ImageView imageView) {
            AppMethodBeat.i(261682);
            Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onAttach#iconBadgeCreator");
            imageView.setBackgroundResource(R.drawable.d7);
            imageView.setImageResource(R.raw.app_brand_open_material_badge_icon);
            AppMethodBeat.o(261682);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "i", "", "onMMMenuItemSelected"})
    /* renamed from: com.tencent.mm.plugin.appbrand.openmaterial.e$e  reason: collision with other inner class name */
    public static final class C0761e implements o.g {
        public static final C0761e FUv = new C0761e();

        static {
            AppMethodBeat.i(261675);
            AppMethodBeat.o(261675);
        }

        C0761e() {
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(261674);
            Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onMMMenuItemSelected, menuItem: " + menuItem + ", i: " + i2);
            if (menuItem instanceof n) {
                ((n) menuItem).performClick();
                AppMethodBeat.o(261674);
                return;
            }
            Log.w("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onMMMenuItemSelected, menuItem is not MMMenuItem");
            AppMethodBeat.o(261674);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "menuItem", "Landroid/view/MenuItem;", "onAttach"})
    public static final class f implements o.c {
        public static final f FUw = new f();

        static {
            AppMethodBeat.i(261677);
            AppMethodBeat.o(261677);
        }

        f() {
        }

        @Override // com.tencent.mm.ui.base.o.c
        public final void a(TextView textView, MenuItem menuItem) {
            AppMethodBeat.i(261676);
            Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onAttach, menuItem: ".concat(String.valueOf(menuItem)));
            p.g(menuItem, "menuItem");
            ContextMenu.ContextMenuInfo menuInfo = menuItem.getMenuInfo();
            if (!(menuInfo instanceof l)) {
                menuInfo = null;
            }
            l lVar = (l) menuInfo;
            if (lVar == null) {
                Log.w("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onAttach, menuInfo is not RawFunctionName2Show");
                AppMethodBeat.o(261676);
                return;
            }
            p.g(textView, "textView");
            if (!lVar.nlm) {
                textView.setText(lVar.nll);
                AppMethodBeat.o(261676);
                return;
            }
            textView.post(new f.a(textView, lVar));
            AppMethodBeat.o(261676);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onClick"})
    public static final class g implements e.AbstractC2138e {
        final /* synthetic */ e nkS;

        g(e eVar) {
            this.nkS = eVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.AbstractC2138e
        public final void onClick() {
            AppMethodBeat.i(261678);
            Log.i("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onClick");
            if (h.a.ENABLE != this.nkS.FTW.FUu) {
                AppMethodBeat.o(261678);
                return;
            }
            this.nkS.nkz.bQl();
            this.nkS.hOv.bMo();
            this.nkS.bQb().show();
            AppMethodBeat.o(261678);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "imageView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MenuItem;", "onAttach"})
    public static final class h implements o.b {
        public static final h FUT = new h();

        static {
            AppMethodBeat.i(261680);
            AppMethodBeat.o(261680);
        }

        h() {
        }

        @Override // com.tencent.mm.ui.base.o.b
        public final void a(ImageView imageView, MenuItem menuItem) {
            int i2;
            AppMethodBeat.i(261679);
            Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onAttach#iconCreator");
            if (ao.isDarkMode()) {
                i2 = R.raw.app_brand_open_material_filled_more_night;
            } else {
                i2 = R.raw.app_brand_open_material_filled_more_normal;
            }
            imageView.setImageResource(i2);
            AppMethodBeat.o(261679);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuView", "Landroid/view/View;", "onMMMenuItemVisible"})
    public static final class i implements o.h {
        final /* synthetic */ e nkS;

        i(e eVar) {
            this.nkS = eVar;
        }

        @Override // com.tencent.mm.ui.base.o.h
        public final void cy(View view) {
            AppMethodBeat.i(261681);
            p.g(view, "menuView");
            if (e.cx(view)) {
                com.tencent.mm.plugin.appbrand.openmaterial.b.a aVar = this.nkS.nkz;
                Log.i(aVar.bQh(), "onBottomSheetListPageEntranceExposure");
                if (!aVar.nmb) {
                    aVar.bQi().xE(2).xF(com.tencent.mm.plugin.appbrand.openmaterial.b.a.d(aVar.nkA)).xG(aVar.bQk()).xH(0).bfK();
                    aVar.nmb = true;
                }
            }
            AppMethodBeat.o(261681);
        }
    }

    private final void ng(boolean z) {
        List<MenuItem> avn;
        AppMethodBeat.i(261688);
        m mVar = this.nkQ;
        if (!(mVar == null || (avn = mVar.avn()) == null)) {
            for (T t : avn) {
                if (!(t instanceof n)) {
                    t = null;
                }
                T t2 = t;
                if (t2 != null) {
                    t2.Bw(!z);
                }
            }
        }
        this.hOv.Dn(z);
        AppMethodBeat.o(261688);
    }

    private final m cbj() {
        l lVar;
        Bitmap bitmap;
        AppMethodBeat.i(261689);
        Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "convertOpenMaterialCollection2Menu");
        m mVar = new m(this.context);
        List<AppBrandOpenMaterialModel> list = this.nkx.nlE;
        p.g(list, "openMaterialCollection.appBrandOpenMaterialModels");
        int na = kotlin.k.j.na(list.size(), Integer.MAX_VALUE);
        for (int i2 = 0; i2 < na; i2++) {
            AppBrandOpenMaterialModel appBrandOpenMaterialModel = list.get(i2);
            p.g(appBrandOpenMaterialModel, "myOpenMaterialModels[i]");
            AppBrandOpenMaterialModel appBrandOpenMaterialModel2 = appBrandOpenMaterialModel;
            Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "convertOpenMaterialModel2MenuItem, index: " + i2 + ", openMaterialModel: " + appBrandOpenMaterialModel2);
            n nVar = new n(this.context, i2, 0);
            String str = appBrandOpenMaterialModel2.appName;
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                String str3 = appBrandOpenMaterialModel2.nlH;
                p.g(str3, "functionName");
                lVar = new l(str3, (String) null, 6);
            } else {
                String str4 = appBrandOpenMaterialModel2.nlH;
                p.g(str4, "functionName");
                int a2 = kotlin.n.n.a((CharSequence) str4, str, 0, false, 6);
                if (-1 == a2) {
                    String str5 = appBrandOpenMaterialModel2.nlH;
                    p.g(str5, "functionName");
                    lVar = new l(str5, (String) null, 6);
                } else {
                    int length = str.length() + a2;
                    if (length != appBrandOpenMaterialModel2.nlH.length()) {
                        String str6 = appBrandOpenMaterialModel2.nlH;
                        p.g(str6, "functionName");
                        if (str6 == null) {
                            t tVar = new t("null cannot be cast to non-null type java.lang.String");
                            AppMethodBeat.o(261689);
                            throw tVar;
                        }
                        String substring = str6.substring(0, length);
                        p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        String str7 = appBrandOpenMaterialModel2.nlH;
                        p.g(str7, "functionName");
                        if (str7 == null) {
                            t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                            AppMethodBeat.o(261689);
                            throw tVar2;
                        }
                        String substring2 = str7.substring(length);
                        p.g(substring2, "(this as java.lang.String).substring(startIndex)");
                        lVar = new l(substring, substring2, true);
                    } else if (a2 != 0) {
                        String str8 = appBrandOpenMaterialModel2.nlH;
                        p.g(str8, "functionName");
                        if (str8 == null) {
                            t tVar3 = new t("null cannot be cast to non-null type java.lang.String");
                            AppMethodBeat.o(261689);
                            throw tVar3;
                        }
                        String substring3 = str8.substring(0, a2);
                        p.g(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        lVar = new l(substring3, str, 4);
                    } else {
                        String str9 = appBrandOpenMaterialModel2.nlH;
                        p.g(str9, "functionName");
                        lVar = new l(str9, (String) null, 6);
                    }
                }
            }
            Log.i("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "convertOpenMaterialModel2MenuItem, functionName: " + appBrandOpenMaterialModel2.nlH + ", rawFunctionName2Show: " + lVar);
            nVar.a(lVar);
            String str10 = appBrandOpenMaterialModel2.iconUrl;
            Drawable aXX = com.tencent.mm.modelappbrand.a.a.aXX();
            if ((aXX instanceof android.support.v4.graphics.drawable.b) && (bitmap = ((android.support.v4.graphics.drawable.b) aXX).getBitmap()) != null) {
                p.g(bitmap, LocaleUtil.ITALIAN);
                nVar.f(new BitmapDrawable(V(bitmap)), 0);
            }
            if (str10 != null) {
                com.tencent.mm.modelappbrand.a.b.aXY().a(new a(this, nVar), str10, com.tencent.mm.modelappbrand.a.g.iJB, (b.f) null);
            }
            nVar.setOnMenuItemClickListener(new b(this, appBrandOpenMaterialModel2));
            nVar.a(new c(this, appBrandOpenMaterialModel2));
            mVar.g(nVar);
        }
        this.nkQ = mVar;
        AppMethodBeat.o(261689);
        return mVar;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/appbrand/openmaterial/GridBottomSheetEnhanceLogic$convertOpenMaterialModel2MenuItem$2", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$ILoadTarget;", "beforeLoadBitmap", "", "key", "", "kotlin.jvm.PlatformType", "onBitmapLoaded", "bitmap", "Landroid/graphics/Bitmap;", "onLoadFailed", "plugin-appbrand-integration_release"})
    public static final class a implements b.k {
        final /* synthetic */ e nkS;
        final /* synthetic */ n nkT;

        a(e eVar, n nVar) {
            this.nkS = eVar;
            this.nkT = nVar;
        }

        @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
        public final String Lb() {
            AppMethodBeat.i(229099);
            String cO = com.tencent.mm.plugin.appbrand.ac.n.cO(this);
            AppMethodBeat.o(229099);
            return cO;
        }

        @Override // com.tencent.mm.modelappbrand.a.b.k
        public final void oD() {
            AppMethodBeat.i(229100);
            Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onLoadFailed");
            AppMethodBeat.o(229100);
        }

        @Override // com.tencent.mm.modelappbrand.a.b.k
        public final void I(Bitmap bitmap) {
            AppMethodBeat.i(229101);
            Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onBitmapLoaded");
            if (bitmap == null) {
                Log.w("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onBitmapLoaded, bitmap is null");
                AppMethodBeat.o(229101);
                return;
            }
            this.nkT.f(new BitmapDrawable(e.W(bitmap)), 0);
            AppMethodBeat.o(229101);
        }

        @Override // com.tencent.mm.modelappbrand.a.b.k
        public final void aYg() {
            AppMethodBeat.i(229102);
            Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "beforeLoadBitmap");
            AppMethodBeat.o(229102);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ e nkS;
        final /* synthetic */ AppBrandOpenMaterialModel nkU;

        b(e eVar, AppBrandOpenMaterialModel appBrandOpenMaterialModel) {
            this.nkS = eVar;
            this.nkU = appBrandOpenMaterialModel;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(229103);
            if (h.a.ENABLE != this.nkS.FTW.FUu) {
                AppMethodBeat.o(229103);
                return false;
            }
            com.tencent.mm.plugin.appbrand.openmaterial.b.a aVar = this.nkS.nkz;
            AppBrandOpenMaterialModel appBrandOpenMaterialModel = this.nkU;
            p.h(appBrandOpenMaterialModel, "openMaterialModel");
            Log.i(aVar.bQh(), "onBottomSheetAppBrandClick");
            long indexOf = (long) (aVar.nkx.nlE.indexOf(appBrandOpenMaterialModel) + 1);
            Log.d(aVar.bQh(), "onBottomSheetAppBrandClick, index: ".concat(String.valueOf(indexOf)));
            ng Ar = aVar.bQi().xE(6).xF(com.tencent.mm.plugin.appbrand.openmaterial.b.a.d(aVar.nkA)).xG(aVar.bQk()).xH(indexOf).Ar(appBrandOpenMaterialModel.appId);
            String str = appBrandOpenMaterialModel.appName;
            if (str == null) {
                str = "";
            }
            Ar.As(str).bfK();
            e.a(this.nkS).invoke(this.nkU);
            AppMethodBeat.o(229103);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuView", "Landroid/view/View;", "onMMMenuItemVisible"})
    public static final class c implements o.h {
        final /* synthetic */ e nkS;
        final /* synthetic */ AppBrandOpenMaterialModel nkU;

        c(e eVar, AppBrandOpenMaterialModel appBrandOpenMaterialModel) {
            this.nkS = eVar;
            this.nkU = appBrandOpenMaterialModel;
        }

        @Override // com.tencent.mm.ui.base.o.h
        public final void cy(View view) {
            AppMethodBeat.i(229104);
            p.g(view, "menuView");
            if (e.cx(view)) {
                com.tencent.mm.plugin.appbrand.openmaterial.b.a aVar = this.nkS.nkz;
                AppBrandOpenMaterialModel appBrandOpenMaterialModel = this.nkU;
                p.h(appBrandOpenMaterialModel, "openMaterialModel");
                Log.i(aVar.bQh(), "onBottomSheetAppBrandExposure");
                if (!aVar.nlZ.contains(appBrandOpenMaterialModel)) {
                    nz Bi = aVar.bQj().yv(1).Bi(appBrandOpenMaterialModel.appId);
                    String str = appBrandOpenMaterialModel.appName;
                    if (str == null) {
                        str = "";
                    }
                    Bi.Bj(str).bfK();
                    aVar.nlZ.add(appBrandOpenMaterialModel);
                }
            }
            AppMethodBeat.o(229104);
        }
    }

    private static Bitmap V(Bitmap bitmap) {
        AppMethodBeat.i(229119);
        int width = bitmap.getWidth();
        int i2 = width / 14;
        int i3 = (i2 * 2) + width;
        Log.i("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "wrapIconWithPadding, sideLen: " + width + ", padding: " + i2 + ", newSideLen: " + i3);
        Bitmap createBitmap = Bitmap.createBitmap(i3, i3, bitmap.getConfig());
        new Canvas(createBitmap).drawBitmap(bitmap, (float) i2, (float) i2, (Paint) null);
        p.g(createBitmap, "newIcon");
        AppMethodBeat.o(229119);
        return createBitmap;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/BaseAppBrandOpenMaterialModel;", "", "invoke"})
    static final class j extends q implements kotlin.g.a.a<kotlin.g.a.b<? super BaseAppBrandOpenMaterialModel, ? extends x>> {
        final /* synthetic */ Context $context;
        final /* synthetic */ com.tencent.mm.ui.widget.a.e nkZ;
        final /* synthetic */ j nla;
        final /* synthetic */ AppBrandOpenMaterialCollection nlb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(com.tencent.mm.ui.widget.a.e eVar, j jVar, Context context, AppBrandOpenMaterialCollection appBrandOpenMaterialCollection) {
            super(0);
            this.nkZ = eVar;
            this.nla = jVar;
            this.$context = context;
            this.nlb = appBrandOpenMaterialCollection;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.g.a.b<? super BaseAppBrandOpenMaterialModel, ? extends x> invoke() {
            AppMethodBeat.i(229117);
            AnonymousClass1 r0 = new kotlin.g.a.b<BaseAppBrandOpenMaterialModel, x>(this) {
                /* class com.tencent.mm.plugin.appbrand.openmaterial.e.j.AnonymousClass1 */
                final /* synthetic */ j nlc;

                {
                    this.nlc = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(BaseAppBrandOpenMaterialModel baseAppBrandOpenMaterialModel) {
                    AppMethodBeat.i(229116);
                    final BaseAppBrandOpenMaterialModel baseAppBrandOpenMaterialModel2 = baseAppBrandOpenMaterialModel;
                    p.h(baseAppBrandOpenMaterialModel2, "openMaterialModel");
                    this.nlc.nkZ.bMo();
                    final r rVar = (r) com.tencent.mm.kernel.g.af(r.class);
                    if (rVar == null) {
                        Log.w("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "itemClickAction, appBrandLauncher is null");
                    } else {
                        this.nlc.nla.ae(new Runnable(this) {
                            /* class com.tencent.mm.plugin.appbrand.openmaterial.e.j.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 nld;

                            {
                                this.nld = r1;
                            }

                            public final void run() {
                                AppMethodBeat.i(229115);
                                Log.i("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "itemClickAction, launch appBrand");
                                r rVar = rVar;
                                Context context = this.nld.nlc.$context;
                                com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
                                gVar.appId = baseAppBrandOpenMaterialModel2.appId;
                                gVar.iOo = baseAppBrandOpenMaterialModel2.iOo;
                                gVar.kHw = baseAppBrandOpenMaterialModel2.kHw;
                                gVar.scene = 1173;
                                String str = this.nld.nlc.nlb.nlD.mimeType;
                                p.g(str, "openMaterialCollection.materialModel.mimeType");
                                String str2 = this.nld.nlc.nlb.nlD.nlI;
                                p.g(str2, "openMaterialCollection.materialModel.materialPath");
                                gVar.kHx = new com.tencent.mm.plugin.appbrand.openmaterial.model.a(str, str2);
                                rVar.a(context, gVar);
                                b.a aVar = com.tencent.mm.plugin.appbrand.openmaterial.a.b.nlq;
                                com.tencent.mm.plugin.appbrand.openmaterial.a.b bQe = b.a.bQe();
                                MaterialModel materialModel = this.nld.nlc.nlb.nlD;
                                p.g(materialModel, "openMaterialCollection.materialModel");
                                bQe.c(materialModel);
                                AppMethodBeat.o(229115);
                            }
                        });
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(229116);
                    return xVar;
                }
            };
            AppMethodBeat.o(229117);
            return r0;
        }
    }

    public static final /* synthetic */ boolean cx(View view) {
        AppMethodBeat.i(229122);
        if (!view.isShown()) {
            Log.w("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "isViewExposure view is not shown");
            AppMethodBeat.o(229122);
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (rect.width() < view.getMeasuredWidth()) {
            Log.i("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "isViewExposure, view is visible but not exposure");
            AppMethodBeat.o(229122);
            return false;
        }
        AppMethodBeat.o(229122);
        return true;
    }

    public static final /* synthetic */ kotlin.g.a.b a(e eVar) {
        AppMethodBeat.i(229124);
        kotlin.g.a.b bVar = (kotlin.g.a.b) eVar.nkR.getValue();
        AppMethodBeat.o(229124);
        return bVar;
    }
}
