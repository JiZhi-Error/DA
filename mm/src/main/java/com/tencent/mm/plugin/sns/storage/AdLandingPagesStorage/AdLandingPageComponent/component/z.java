package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ch.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class z extends q {
    public z(Context context, q qVar, ViewGroup viewGroup) {
        super(context, qVar, viewGroup);
        AppMethodBeat.i(96657);
        g o = h.o(qVar.DYs, true, false);
        this.Edn.kv("pkg", o == null ? "" : o.field_packageName);
        this.Edn.kv("appid", qVar.DYs);
        AppMethodBeat.o(96657);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q
    public final void fde() {
        AppMethodBeat.i(96658);
        q fdx = fdx();
        if (h.s(this.context, fdx.DYs)) {
            g o = h.o(fdx.DYs, true, false);
            if (o == null || TextUtils.isEmpty(o.field_packageName) || !I(this.context, o.field_packageName, h.a(this.context, o, (String) null))) {
                super.fde();
                AppMethodBeat.o(96658);
                return;
            }
            fdf();
            AppMethodBeat.o(96658);
            return;
        }
        super.fde();
        AppMethodBeat.o(96658);
    }

    private boolean I(final Context context, String str, final String str2) {
        AppMethodBeat.i(96659);
        if (context == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(96659);
            return false;
        }
        try {
            final Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                if (!(context instanceof Activity)) {
                    context = this.context;
                }
                a.post(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(96656);
                        h.b(context, launchIntentForPackage, str2);
                        AppMethodBeat.o(96656);
                    }
                });
                AppMethodBeat.o(96659);
                return true;
            }
        } catch (Exception e2) {
            Log.e("AdLandingPageOpenAppBtnComp", Util.stackTraceToString(e2));
        }
        AppMethodBeat.o(96659);
        return false;
    }
}
