package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.support.v4.e.a;
import android.text.TextUtils;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.luggage.h.l;
import com.tencent.luggage.sdk.config.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.g;
import com.tencent.mm.plugin.appbrand.bb;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash;
import com.tencent.mm.plugin.appbrand.ui.c.a.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.s;

public final class k {
    private static final a<AppBrandRuntime, Bitmap> nUe = new a<>();

    public static aa a(Context context, AppBrandInitConfigWC appBrandInitConfigWC) {
        AppMethodBeat.i(227610);
        if (!appBrandInitConfigWC.ldN) {
            AppMethodBeat.o(227610);
            return null;
        } else if (!TextUtils.isEmpty(l.dM(appBrandInitConfigWC.kHw))) {
            AppMethodBeat.o(227610);
            return null;
        } else if (!b.bZg()) {
            Log.i("MicroMsg.AppBrandLoadingSplashFactory", "createSnapshotDisplayLoadingSplash but switch off, appId:%s", appBrandInitConfigWC.appId);
            AppMethodBeat.o(227610);
            return null;
        } else {
            String str = appBrandInitConfigWC.lea;
            if (s.YS(str)) {
                Log.i("MicroMsg.AppBrandLoadingSplashFactory", "createScreenshotSplash with appId:%s, path:%s", appBrandInitConfigWC.appId, str);
                Bitmap decodeFile = BitmapUtil.decodeFile(str);
                if (decodeFile != null && !decodeFile.isRecycled()) {
                    aa aaVar = new aa(context, decodeFile);
                    AppMethodBeat.o(227610);
                    return aaVar;
                }
            }
            AppMethodBeat.o(227610);
            return null;
        }
    }

    public static ab a(Context context, final q qVar) {
        m mVar;
        boolean z;
        AppMethodBeat.i(48659);
        Bitmap remove = nUe.remove(qVar);
        if (remove == null || remove.isRecycled()) {
            aa a2 = a(context, qVar.bsC());
            if (a2 != null) {
                a2.setRuntime(qVar);
                AppMethodBeat.o(48659);
                return a2;
            } else if (g.an(qVar)) {
                com.tencent.mm.plugin.appbrand.af.b bVar = new com.tencent.mm.plugin.appbrand.af.b(en(context), qVar);
                AppMethodBeat.o(48659);
                return bVar;
            } else if (r.am(qVar) || bb.r(qVar) || qVar.bsN()) {
                if (qVar.NA()) {
                    mVar = new g(en(context), qVar, qVar.bsC().cyv);
                } else {
                    mVar = new m(en(context), qVar, qVar.bsC().cyv);
                }
                if (qVar.bsN()) {
                    mVar.CF(true);
                }
                AppMethodBeat.o(48659);
                return mVar;
            } else if (qVar.NA()) {
                h hVar = new h(en(context), qVar);
                if (qVar.brL()) {
                    c cVar = new c(en(context), qVar, hVar, qVar.kDu);
                    AppMethodBeat.o(48659);
                    return cVar;
                }
                AppMethodBeat.o(48659);
                return hVar;
            } else {
                AppBrandUILoadingSplash appBrandUILoadingSplash = (AppBrandUILoadingSplash) qVar.bsn().a(AppBrandUILoadingSplash.class, context);
                if (appBrandUILoadingSplash != null) {
                    Log.d("MicroMsg.AppBrandUILoadingSplash", "attachRuntime %s", qVar.OU().brandName);
                    appBrandUILoadingSplash.kEc = qVar;
                    Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(qVar.mContext);
                    if (appBrandUILoadingSplash.getContext() instanceof MutableContextWrapper) {
                        ((MutableContextWrapper) appBrandUILoadingSplash.getContext()).setBaseContext(castActivityOrNull);
                        int color = appBrandUILoadingSplash.getResources().getColor(R.color.f3045c);
                        if (!appBrandUILoadingSplash.isDarkMode()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        appBrandUILoadingSplash.S(color, z);
                    }
                } else {
                    appBrandUILoadingSplash = new AppBrandUILoadingSplash(en(context), qVar);
                }
                appBrandUILoadingSplash.setLabelInjector(new AppBrandUILoadingSplash.a() {
                    /* class com.tencent.mm.plugin.appbrand.ui.k.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash.a
                    public final void a(ViewStub viewStub) {
                        AppMethodBeat.i(227608);
                        if (e.hO(qVar.bsC().lec) && ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_show_official_flag, 0) == 1) {
                            viewStub.setLayoutResource(R.layout.fq);
                            viewStub.inflate();
                        }
                        AppMethodBeat.o(227608);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash.a
                    @SuppressLint({"ResourceType"})
                    public final void b(ViewStub viewStub) {
                        AppMethodBeat.i(227609);
                        if (e.hP(qVar.bsC().leb) && ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_scene_appbrand_loading_splash, 0) == 1) {
                            viewStub.setLayoutResource(R.layout.ft);
                            ((ImageView) viewStub.inflate().findViewById(R.id.dt5)).setImageResource(ao.isDarkMode() ? R.raw.appbrand_trading_guarantee_icon_white : R.raw.appbrand_trading_guarantee_icon_gray);
                        }
                        AppMethodBeat.o(227609);
                    }
                });
                if (qVar.brL()) {
                    c cVar2 = new c(en(context), qVar, appBrandUILoadingSplash, qVar.kDu);
                    AppMethodBeat.o(48659);
                    return cVar2;
                }
                AppMethodBeat.o(48659);
                return appBrandUILoadingSplash;
            }
        } else {
            o oVar = new o(context, remove);
            AppMethodBeat.o(48659);
            return oVar;
        }
    }

    public static boolean bXf() {
        boolean z;
        AppMethodBeat.i(161867);
        if (MMApplicationContext.isMainProcess()) {
            AppMethodBeat.o(161867);
            return false;
        }
        if (com.tencent.mm.cc.a.gvt() || !com.tencent.mm.cc.a.gvm()) {
            z = false;
        } else {
            z = true;
        }
        if (!z || com.tencent.mm.cc.a.gvs()) {
            AppMethodBeat.o(161867);
            return false;
        }
        AppMethodBeat.o(161867);
        return true;
    }

    private static Context en(Context context) {
        AppMethodBeat.i(48660);
        if (context == null) {
            context = MMApplicationContext.getContext();
        }
        if (bXf()) {
            context = new w(context);
        }
        AppMethodBeat.o(48660);
        return context;
    }

    static {
        AppMethodBeat.i(48662);
        AppMethodBeat.o(48662);
    }

    public static void a(AppBrandRuntime appBrandRuntime, Bitmap bitmap) {
        AppMethodBeat.i(48661);
        if (appBrandRuntime == null || bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(48661);
            return;
        }
        nUe.put(appBrandRuntime, bitmap);
        AppMethodBeat.o(48661);
    }
}
