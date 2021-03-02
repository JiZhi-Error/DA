package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.view.MenuItem;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.ui.recommend.k;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.soter.core.biometric.FaceManager;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUIForceEntryConfig;", "", "()V", "KEY_FORCE_NATIVE_LAUNCHER", "", "KEY_FORCE_WE_USE_FAKE_NATIVE", "KEY_FORCE_WE_USE_FAKE_NATIVE_APPID", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getForceWeUseFakeNativeAppIdOrDefault", "isForceOpenNativeLauncher", "", "isForceOpenWeUseFakeNative", "showChooseSheet", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class i {
    public static final i nTZ = new i();

    static {
        AppMethodBeat.i(180659);
        AppMethodBeat.o(180659);
    }

    private i() {
    }

    public static final /* synthetic */ MultiProcessMMKV bXe() {
        AppMethodBeat.i(180660);
        MultiProcessMMKV VQ = VQ();
        AppMethodBeat.o(180660);
        return VQ;
    }

    static MultiProcessMMKV VQ() {
        AppMethodBeat.i(180656);
        MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("AppBrandLauncherUIForceEntryConfig");
        p.g(singleMMKV, "MultiProcessMMKV.getSing…ncherUIForceEntryConfig\")");
        AppMethodBeat.o(180656);
        return singleMMKV;
    }

    public static void em(Context context) {
        AppMethodBeat.i(180657);
        p.h(context, "context");
        e eVar = new e(context, 1, false);
        eVar.a(a.nUa);
        eVar.a(b.nUb);
        eVar.dGm();
        AppMethodBeat.o(180657);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class a implements o.f {
        public static final a nUa = new a();

        static {
            AppMethodBeat.i(180653);
            AppMethodBeat.o(180653);
        }

        a() {
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(180652);
            mVar.kV(0, R.string.l6);
            mVar.kV(1, R.string.l4);
            mVar.kV(2, R.string.l5);
            mVar.kV(10, R.string.l3);
            mVar.kV(20, R.string.l7);
            AppMethodBeat.o(180652);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class b implements o.g {
        public static final b nUb = new b();

        static {
            AppMethodBeat.i(180655);
            AppMethodBeat.o(180655);
        }

        b() {
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(180654);
            p.g(menuItem, "menuItem");
            if (20 == menuItem.getItemId()) {
                j jVar = j.kAc;
                g gVar = new g();
                i iVar = i.nTZ;
                gVar.appId = i.bXd();
                gVar.scene = FaceManager.FACE_ACQUIRED_BRIGHT;
                gVar.kHx = new k();
                j.a(gVar, new f() {
                    /* class com.tencent.mm.plugin.appbrand.ui.i.b.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.api.f
                    public final void onSuccess() {
                    }

                    @Override // com.tencent.mm.plugin.appbrand.api.f
                    public final void onError(int i2, String str) {
                    }
                });
                AppMethodBeat.o(180654);
                return;
            }
            i iVar2 = i.nTZ;
            i.bXe().clearAll();
            int itemId = menuItem.getItemId();
            if (itemId == 0) {
                i iVar3 = i.nTZ;
                i.bXe().putBoolean("KEY_FORCE_NATIVE_LAUNCHER", true);
                AppMethodBeat.o(180654);
                return;
            }
            if (itemId == 1 || itemId == 2) {
                i iVar4 = i.nTZ;
                i.bXe().putBoolean("KEY_FORCE_WE_USE_FAKE_NATIVE", true);
                i iVar5 = i.nTZ;
                i.bXe().putString("KEY_FORCE_WE_USE_FAKE_NATIVE_APPID", itemId == 2 ? "wx6bd2fb149a93a9c5" : null);
            }
            AppMethodBeat.o(180654);
        }
    }

    public static String bXd() {
        AppMethodBeat.i(180658);
        String string = VQ().getString("KEY_FORCE_WE_USE_FAKE_NATIVE_APPID", null);
        if (string == null) {
            string = "wxb6d22f922f37b35a";
        }
        AppMethodBeat.o(180658);
        return string;
    }
}
