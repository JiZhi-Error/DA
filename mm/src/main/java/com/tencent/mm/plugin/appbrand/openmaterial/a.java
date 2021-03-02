package com.tencent.mm.plugin.appbrand.openmaterial;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.ny;
import com.tencent.mm.g.b.a.nz;
import com.tencent.mm.plugin.appbrand.openmaterial.a.b;
import com.tencent.mm.plugin.appbrand.openmaterial.g;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialDetailModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.ui.a;
import com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.OpenMaterialJsBridge;
import com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.OpenMaterialWebView;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.z;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 '2\u00020\u0001:\u0001'B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0003J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J \u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001fH\u0003J\f\u0010#\u001a\u00020\u0017*\u00020$H\u0002J\u0014\u0010%\u001a\u00020\u0017*\u00020&2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "context", "Landroid/content/Context;", "bottomSheet4Config", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "openMaterialReporter", "Lcom/tencent/mm/plugin/appbrand/openmaterial/report/AppBrandOpenMaterialReporter;", "(Landroid/content/Context;Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;Lcom/tencent/mm/plugin/appbrand/openmaterial/report/AppBrandOpenMaterialReporter;)V", "bottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet;", "jsBridge", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/OpenMaterialJsBridge;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet$IListener;", "buildHybridBottomSheet", "buildTitleView", "Landroid/view/View;", "dead", "", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "requireBottomSheet", "setListener", "show", "showDirectly", "tryLaunchAppBrand", "appId", "", "versionType", "", "enterPath", "configDialog", "Landroid/app/Dialog;", "loadDataAsync", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/OpenMaterialWebView;", "Companion", "plugin-appbrand-integration_release"})
public final class a implements g {
    private static com.tencent.mm.plugin.appbrand.openmaterial.model.b nkA;
    public static final C0756a nkB = new C0756a((byte) 0);
    private final Context context;
    private com.tencent.mm.plugin.appbrand.openmaterial.ui.a nkt;
    private OpenMaterialJsBridge nku;
    private g.b nkv;
    private final com.tencent.mm.ui.widget.a.e nkw;
    private final AppBrandOpenMaterialCollection nkx;
    private final j nky;
    private final com.tencent.mm.plugin.appbrand.openmaterial.b.a nkz;

    static {
        AppMethodBeat.i(229086);
        AppMethodBeat.o(229086);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/OpenMaterialWebView;", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<OpenMaterialWebView, x> {
        final /* synthetic */ a nkC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar) {
            super(1);
            this.nkC = aVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialDetailModel;", "appId", "", "versionType", "", "enterPath", "invoke", "com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildHybridBottomSheet$1$jsBridge$1$findOpenMaterialModel$1"})
        /* renamed from: com.tencent.mm.plugin.appbrand.openmaterial.a$c$a  reason: collision with other inner class name */
        static final class C0758a extends q implements kotlin.g.a.q<String, Integer, String, AppBrandOpenMaterialDetailModel> {
            final /* synthetic */ c nkD;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0758a(c cVar) {
                super(3);
                this.nkD = cVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.q
            public final /* synthetic */ AppBrandOpenMaterialDetailModel d(String str, Integer num, String str2) {
                T t;
                boolean z;
                AppMethodBeat.i(229071);
                String str3 = str;
                num.intValue();
                String str4 = str2;
                p.h(str3, "appId");
                p.h(str4, "enterPath");
                List<AppBrandOpenMaterialDetailModel> list = this.nkD.nkC.nkx.nlF;
                p.g(list, "openMaterialCollection.a…dOpenMaterialDetailModels");
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    T next = it.next();
                    T t2 = next;
                    if (!p.j(str3, ((AppBrandOpenMaterialDetailModel) t2).appId) || !p.j(str4, ((AppBrandOpenMaterialDetailModel) t2).kHw)) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        t = next;
                        break;
                    }
                }
                T t3 = t;
                AppMethodBeat.o(229071);
                return t3;
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(OpenMaterialWebView openMaterialWebView) {
            AppMethodBeat.i(229075);
            OpenMaterialWebView openMaterialWebView2 = openMaterialWebView;
            p.h(openMaterialWebView2, "$receiver");
            openMaterialWebView2.bQq();
            boolean isDarkMode = ao.isDarkMode();
            Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "buildHybridBottomSheet, isDarkMode: ".concat(String.valueOf(isDarkMode)));
            z settings = openMaterialWebView2.getSettings();
            p.g(settings, "settings");
            settings.setForceDarkMode(isDarkMode ? 2 : 0);
            Object systemService = openMaterialWebView2.getContext().getSystemService("window");
            if (systemService == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.WindowManager");
                AppMethodBeat.o(229075);
                throw tVar;
            }
            openMaterialWebView2.setConfigCallback((WindowManager) systemService);
            OpenMaterialJsBridge openMaterialJsBridge = new OpenMaterialJsBridge(openMaterialWebView2);
            C0758a aVar = new C0758a(this);
            openMaterialJsBridge.setLaunchWeAppDelegate(new b(aVar, this));
            openMaterialJsBridge.setWeAppExposureDelegate(new C0759c(aVar, this));
            openMaterialWebView2.addJavascriptInterface(openMaterialJsBridge, "OpenMaterialJsApi");
            a.a(this.nkC, openMaterialWebView2, openMaterialJsBridge);
            this.nkC.nku = openMaterialJsBridge;
            x xVar = x.SXb;
            AppMethodBeat.o(229075);
            return xVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildHybridBottomSheet$1$jsBridge$1$1", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/ILaunchWeAppDelegate;", "launch", "", "appId", "", "versionType", "", "enterPath", "plugin-appbrand-integration_release"})
        public static final class b implements com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.c {
            final /* synthetic */ c nkD;
            final /* synthetic */ kotlin.g.a.q nkE;

            b(kotlin.g.a.q qVar, c cVar) {
                this.nkE = qVar;
                this.nkD = cVar;
            }

            @Override // com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.c
            public final void B(final String str, final int i2, final String str2) {
                AppMethodBeat.i(229073);
                p.h(str, "appId");
                p.h(str2, "enterPath");
                h.RTc.aV(new Runnable(this) {
                    /* class com.tencent.mm.plugin.appbrand.openmaterial.a.c.b.AnonymousClass1 */
                    final /* synthetic */ b nkF;

                    {
                        this.nkF = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(229072);
                        com.tencent.mm.plugin.appbrand.openmaterial.ui.a aVar = this.nkF.nkD.nkC.nkt;
                        if (aVar != null) {
                            aVar.hide();
                        }
                        AppBrandOpenMaterialDetailModel appBrandOpenMaterialDetailModel = (AppBrandOpenMaterialDetailModel) this.nkF.nkE.d(str, Integer.valueOf(i2), str2);
                        if (appBrandOpenMaterialDetailModel == null) {
                            Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "launch#buildHybridBottomSheet, openMaterialModel is null");
                        } else {
                            com.tencent.mm.plugin.appbrand.openmaterial.b.a aVar2 = this.nkF.nkD.nkC.nkz;
                            AppBrandOpenMaterialDetailModel appBrandOpenMaterialDetailModel2 = appBrandOpenMaterialDetailModel;
                            p.h(appBrandOpenMaterialDetailModel2, "openMaterialModel");
                            Log.i(aVar2.bQh(), "onListPageAppBrandClick");
                            List<AppBrandOpenMaterialDetailModel> list = aVar2.nkx.nlF;
                            p.g(list, "openMaterialCollection.a…dOpenMaterialDetailModels");
                            long a2 = (long) (j.a((List) list, (Object) appBrandOpenMaterialDetailModel2) + 1);
                            Log.d(aVar2.bQh(), "onListPageAppBrandClick, index: ".concat(String.valueOf(a2)));
                            ny Bf = ((ny) aVar2.nlV.getValue()).yt(((Number) aVar2.nlY.getValue()).longValue()).yu(a2).Bf(((AppBrandOpenMaterialModel) appBrandOpenMaterialDetailModel2).appId);
                            String str = appBrandOpenMaterialDetailModel2.appName;
                            if (str == null) {
                                str = "";
                            }
                            Bf.Bg(str).bfK();
                        }
                        a.a(this.nkF.nkD.nkC, str, i2, str2);
                        AppMethodBeat.o(229072);
                    }
                });
                AppMethodBeat.o(229073);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildHybridBottomSheet$1$jsBridge$1$2", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/IWeAppExposureDelegate;", "onWeAppExposure", "", "appId", "", "versionType", "", "enterPath", "plugin-appbrand-integration_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.openmaterial.a$c$c  reason: collision with other inner class name */
        public static final class C0759c implements com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.d {
            final /* synthetic */ c nkD;
            final /* synthetic */ kotlin.g.a.q nkE;

            C0759c(kotlin.g.a.q qVar, c cVar) {
                this.nkE = qVar;
                this.nkD = cVar;
            }

            @Override // com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.d
            public final void C(String str, int i2, String str2) {
                AppMethodBeat.i(229074);
                p.h(str, "appId");
                p.h(str2, "enterPath");
                AppBrandOpenMaterialDetailModel appBrandOpenMaterialDetailModel = (AppBrandOpenMaterialDetailModel) this.nkE.d(str, Integer.valueOf(i2), str2);
                if (appBrandOpenMaterialDetailModel == null) {
                    Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "onWeAppExposure#buildHybridBottomSheet, openMaterialModel is null");
                    AppMethodBeat.o(229074);
                    return;
                }
                com.tencent.mm.plugin.appbrand.openmaterial.b.a aVar = this.nkD.nkC.nkz;
                AppBrandOpenMaterialDetailModel appBrandOpenMaterialDetailModel2 = appBrandOpenMaterialDetailModel;
                p.h(appBrandOpenMaterialDetailModel2, "openMaterialModel");
                Log.i(aVar.bQh(), "onListPageAppBrandExposure");
                if (!aVar.nma.contains(appBrandOpenMaterialDetailModel2)) {
                    nz Bi = aVar.bQj().yv(2).Bi(((AppBrandOpenMaterialModel) appBrandOpenMaterialDetailModel2).appId);
                    String str3 = appBrandOpenMaterialDetailModel2.appName;
                    if (str3 == null) {
                        str3 = "";
                    }
                    Bi.Bj(str3).bfK();
                    aVar.nma.add(appBrandOpenMaterialDetailModel2);
                }
                AppMethodBeat.o(229074);
            }
        }
    }

    public a(Context context2, com.tencent.mm.ui.widget.a.e eVar, AppBrandOpenMaterialCollection appBrandOpenMaterialCollection, j jVar, com.tencent.mm.plugin.appbrand.openmaterial.b.a aVar) {
        p.h(context2, "context");
        p.h(appBrandOpenMaterialCollection, "openMaterialCollection");
        p.h(jVar, "launchAppBrandExecutor");
        p.h(aVar, "openMaterialReporter");
        AppMethodBeat.i(229085);
        this.context = context2;
        this.nkw = eVar;
        this.nkx = appBrandOpenMaterialCollection;
        this.nky = jVar;
        this.nkz = aVar;
        if (this.context instanceof MMFragmentActivity) {
            ((MMFragmentActivity) this.context).keep(this);
            AppMethodBeat.o(229085);
            return;
        }
        Log.e("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "<init>, context is not lifecycle keeper");
        AppMethodBeat.o(229085);
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.g
    public final void a(g.b bVar) {
        this.nkv = bVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.g
    public final void bPY() {
        AppMethodBeat.i(229082);
        Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "showDirectly");
        show();
        com.tencent.mm.plugin.appbrand.openmaterial.b.a aVar = this.nkz;
        Log.i(aVar.bQh(), "onLaunchListPageDirectly");
        aVar.bQi().xE(4).xF(com.tencent.mm.plugin.appbrand.openmaterial.b.a.d(aVar.nkA)).xG(aVar.bQk()).xH(0).bfK();
        AppMethodBeat.o(229082);
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.g
    public final void hide() {
        AppMethodBeat.i(229083);
        com.tencent.mm.plugin.appbrand.openmaterial.ui.a aVar = this.nkt;
        if (aVar != null) {
            aVar.hide();
            AppMethodBeat.o(229083);
            return;
        }
        AppMethodBeat.o(229083);
    }

    @Override // com.tencent.mm.vending.e.a
    public final void dead() {
        AppMethodBeat.i(229084);
        com.tencent.mm.plugin.appbrand.openmaterial.ui.a aVar = this.nkt;
        if (aVar != null) {
            aVar.dead();
            AppMethodBeat.o(229084);
            return;
        }
        AppMethodBeat.o(229084);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss", "com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$requireBottomSheet$1$1"})
    public static final class f implements DialogInterface.OnDismissListener {
        final /* synthetic */ a nkC;

        f(a aVar) {
            this.nkC = aVar;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(229079);
            Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "onDismiss");
            g.b bVar = this.nkC.nkv;
            if (bVar != null) {
                bVar.bQd();
                AppMethodBeat.o(229079);
                return;
            }
            AppMethodBeat.o(229079);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildHybridBottomSheet$2$1", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;", "onContentVisibleHeightChange", "", "height", "", "plugin-appbrand-integration_release"})
    public static final class b implements a.AbstractC0763a {
        final /* synthetic */ a nkC;

        b(a aVar) {
            this.nkC = aVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.openmaterial.ui.a.AbstractC0763a
        public final void yH(int i2) {
            AppMethodBeat.i(229070);
            OpenMaterialJsBridge openMaterialJsBridge = this.nkC.nku;
            if (openMaterialJsBridge != null) {
                openMaterialJsBridge.onWindowHeightChange(com.tencent.mm.plugin.appbrand.ac.g.zC(i2));
                AppMethodBeat.o(229070);
                return;
            }
            AppMethodBeat.o(229070);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class g implements Runnable {
        final /* synthetic */ String kPQ;
        final /* synthetic */ int kQh;
        final /* synthetic */ String mXY;
        final /* synthetic */ a nkC;
        final /* synthetic */ r nkL;

        g(a aVar, r rVar, String str, int i2, String str2) {
            this.nkC = aVar;
            this.nkL = rVar;
            this.kPQ = str;
            this.kQh = i2;
            this.mXY = str2;
        }

        public final void run() {
            AppMethodBeat.i(229080);
            Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "tryLaunchAppBrand, launch appBrand");
            r rVar = this.nkL;
            Context context = this.nkC.context;
            com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
            gVar.appId = this.kPQ;
            gVar.iOo = this.kQh;
            gVar.kHw = this.mXY;
            gVar.scene = 1173;
            String str = this.nkC.nkx.nlD.mimeType;
            p.g(str, "openMaterialCollection.materialModel.mimeType");
            String str2 = this.nkC.nkx.nlD.nlI;
            p.g(str2, "openMaterialCollection.materialModel.materialPath");
            gVar.kHx = new com.tencent.mm.plugin.appbrand.openmaterial.model.a(str, str2);
            rVar.a(context, gVar);
            b.a aVar = b.nlq;
            b bQe = b.a.bQe();
            MaterialModel materialModel = this.nkC.nkx.nlD;
            p.g(materialModel, "openMaterialCollection.materialModel");
            bQe.c(materialModel);
            AppMethodBeat.o(229080);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildTitleView$1$1"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ a nkC;

        d(a aVar) {
            this.nkC = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(229076);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildTitleView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "iv_close#onClick");
            this.nkC.hide();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildTitleView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(229076);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ a nkC;
        final /* synthetic */ OpenMaterialWebView nkG;
        final /* synthetic */ OpenMaterialJsBridge nkH;

        e(a aVar, OpenMaterialWebView openMaterialWebView, OpenMaterialJsBridge openMaterialJsBridge) {
            this.nkC = aVar;
            this.nkG = openMaterialWebView;
            this.nkH = openMaterialJsBridge;
        }

        public final void run() {
            boolean z = false;
            AppMethodBeat.i(229078);
            at afr = ai.afr(7);
            if (afr == null) {
                Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "loadDataAsync, openMaterialTemplate is null");
                AppMethodBeat.o(229078);
                return;
            }
            String str = afr.fYs() + '/' + at.fYy();
            Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "loadDataAsync, htmlPath: ".concat(String.valueOf(str)));
            byte[] aW = s.aW(str, 0, -1);
            if (aW != null) {
                if (aW.length == 0) {
                    z = true;
                }
                if (!z) {
                    final String concat = "file://".concat(String.valueOf(str));
                    Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "loadDataAsync, baseUrl: ".concat(String.valueOf(concat)));
                    OpenMaterialJsBridge openMaterialJsBridge = this.nkH;
                    com.tencent.mm.plugin.appbrand.openmaterial.model.b bVar = this.nkC.nkz.nkA;
                    List<AppBrandOpenMaterialDetailModel> list = this.nkC.nkx.nlF;
                    p.g(list, "openMaterialCollection.a…dOpenMaterialDetailModels");
                    final byte[] attachMyOpenMaterials2Template = openMaterialJsBridge.attachMyOpenMaterials2Template(aW, bVar, list);
                    h.RTc.aV(new Runnable(this) {
                        /* class com.tencent.mm.plugin.appbrand.openmaterial.a.e.AnonymousClass1 */
                        final /* synthetic */ e nkI;

                        {
                            this.nkI = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(229077);
                            this.nkI.nkG.loadDataWithBaseURL(concat, new String(attachMyOpenMaterials2Template, kotlin.n.d.UTF_8), "text/html", ProtocolPackage.ServerEncoding, null);
                            AppMethodBeat.o(229077);
                        }
                    });
                    AppMethodBeat.o(229078);
                    return;
                }
            }
            Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "loadDataAsync, rawHtmlContent is empty");
            AppMethodBeat.o(229078);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J4\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$Companion;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet$IFactory;", "()V", "scene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "create", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "context", "Landroid/content/Context;", "bottomSheet4Config", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "openMaterialReporter", "Lcom/tencent/mm/plugin/appbrand/openmaterial/report/AppBrandOpenMaterialReporter;", "setScene", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.openmaterial.a$a  reason: collision with other inner class name */
    public static final class C0756a implements g.a {
        private C0756a() {
        }

        public /* synthetic */ C0756a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.openmaterial.g.a
        public final g.a b(com.tencent.mm.plugin.appbrand.openmaterial.model.b bVar) {
            AppMethodBeat.i(229067);
            p.h(bVar, "scene");
            Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "setScene, scene: ".concat(String.valueOf(bVar)));
            a.nkA = bVar;
            C0756a aVar = this;
            AppMethodBeat.o(229067);
            return aVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.openmaterial.g.a
        public final g a(Context context, com.tencent.mm.ui.widget.a.e eVar, AppBrandOpenMaterialCollection appBrandOpenMaterialCollection) {
            AppMethodBeat.i(229068);
            p.h(context, "context");
            p.h(appBrandOpenMaterialCollection, "openMaterialCollection");
            g a2 = a(context, eVar, appBrandOpenMaterialCollection, null, null);
            AppMethodBeat.o(229068);
            return a2;
        }

        public static g a(Context context, com.tencent.mm.ui.widget.a.e eVar, AppBrandOpenMaterialCollection appBrandOpenMaterialCollection, j jVar, com.tencent.mm.plugin.appbrand.openmaterial.b.a aVar) {
            j jVar2;
            com.tencent.mm.plugin.appbrand.openmaterial.b.a aVar2;
            AppMethodBeat.i(229069);
            p.h(context, "context");
            p.h(appBrandOpenMaterialCollection, "openMaterialCollection");
            Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "create");
            if (d.eg(context)) {
                if (jVar == null) {
                    jVar2 = j.nlj;
                    p.g(jVar2, "ILaunchAppBrandExecutor.DEFAULT");
                } else {
                    jVar2 = jVar;
                }
                if (aVar == null) {
                    com.tencent.mm.plugin.appbrand.openmaterial.model.b bVar = a.nkA;
                    if (bVar == null) {
                        p.hyc();
                    }
                    aVar2 = new com.tencent.mm.plugin.appbrand.openmaterial.b.a(bVar, appBrandOpenMaterialCollection);
                } else {
                    aVar2 = aVar;
                }
                a aVar3 = new a(context, eVar, appBrandOpenMaterialCollection, jVar2, aVar2);
                AppMethodBeat.o(229069);
                return aVar3;
            }
            Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "create, context is invalid, use dummy");
            g gVar = g.nlh;
            p.g(gVar, "IAppBrandOpenMaterialBottomSheet.DUMMY");
            AppMethodBeat.o(229069);
            return gVar;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.g
    public final void show() {
        View decorView;
        View decorView2;
        Window window;
        View decorView3;
        Window window2;
        int i2;
        AppMethodBeat.i(229081);
        com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.a aVar = this.nkt;
        if (aVar == null) {
            com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.a aVar2 = new com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.a(this.context, new c(this));
            b bVar = new b(this);
            aVar2.nmf.nme = bVar;
            aVar2.nme = bVar;
            aVar = aVar2;
            View inflate = LayoutInflater.from(this.context).inflate(R.layout.bh0, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.e4e);
            if (imageView != null) {
                if (ao.isDarkMode()) {
                    i2 = R.drawable.bwd;
                } else {
                    i2 = R.drawable.bw9;
                }
                imageView.setImageResource(i2);
                imageView.setOnClickListener(new d(this));
                o.hp(imageView);
            }
            TextView textView = (TextView) inflate.findViewById(R.id.iyx);
            if (textView != null) {
                textView.setText(R.string.o4);
            }
            p.g(inflate, "titleView");
            aVar.setTitleView(inflate);
            aVar.getDialog().setOnDismissListener(new f(this));
            this.nkt = aVar;
        }
        Dialog dialog = aVar.getDialog();
        if (Build.VERSION.SDK_INT >= 21 && (window2 = dialog.getWindow()) != null) {
            window2.addFlags(Integer.MIN_VALUE);
        }
        com.tencent.mm.ui.widget.a.e eVar = this.nkw;
        if (eVar != null && true == eVar.hbp() && Build.VERSION.SDK_INT >= 23) {
            Window window3 = dialog.getWindow();
            if (!(window3 == null || (decorView3 = window3.getDecorView()) == null)) {
                decorView3.setSystemUiVisibility(9216);
            }
            Window window4 = dialog.getWindow();
            if (window4 != null) {
                window4.setStatusBarColor(0);
            }
        }
        com.tencent.mm.ui.widget.a.e eVar2 = this.nkw;
        if (!(eVar2 == null || true != eVar2.isHideStatusBar() || (window = dialog.getWindow()) == null)) {
            window.addFlags(1024);
        }
        com.tencent.mm.ui.widget.a.e eVar3 = this.nkw;
        if (eVar3 == null || true != eVar3.hbq()) {
            Window window5 = dialog.getWindow();
            if (window5 != null) {
                window5.clearFlags(8);
            }
            Window window6 = dialog.getWindow();
            if (window6 != null) {
                window6.clearFlags(131072);
            }
            Window window7 = dialog.getWindow();
            if (window7 != null) {
                window7.clearFlags(128);
            }
            Window window8 = dialog.getWindow();
            if (!(window8 == null || (decorView = window8.getDecorView()) == null)) {
                decorView.setSystemUiVisibility(0);
            }
        } else {
            Window window9 = dialog.getWindow();
            if (window9 != null) {
                window9.setFlags(8, 8);
            }
            Window window10 = dialog.getWindow();
            if (window10 != null) {
                window10.addFlags(131200);
            }
            Window window11 = dialog.getWindow();
            if (!(window11 == null || (decorView2 = window11.getDecorView()) == null)) {
                decorView2.setSystemUiVisibility(6);
            }
        }
        aVar.show();
        AppMethodBeat.o(229081);
    }

    public static final /* synthetic */ void a(a aVar, String str, int i2, String str2) {
        AppMethodBeat.i(229087);
        Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "tryLaunchAppBrand, appId: " + str + ", versionType: " + i2 + ", enterPath: " + str2);
        r rVar = (r) com.tencent.mm.kernel.g.af(r.class);
        if (rVar == null) {
            Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "tryLaunchAppBrand, appBrandLauncher is null");
            AppMethodBeat.o(229087);
            return;
        }
        aVar.nky.ae(new g(aVar, rVar, str, i2, str2));
        AppMethodBeat.o(229087);
    }

    public static final /* synthetic */ void a(a aVar, OpenMaterialWebView openMaterialWebView, OpenMaterialJsBridge openMaterialJsBridge) {
        AppMethodBeat.i(229088);
        Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "loadDataAsync");
        h.RTc.aX(new e(aVar, openMaterialWebView, openMaterialJsBridge));
        AppMethodBeat.o(229088);
    }
}
