package com.tencent.mm.plugin.appbrand.launching.e;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.service.d;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends ContextWrapper implements g {
    private int lvW = 0;
    private String mToken;
    private final IListener<d> mZm = new IListener<d>() {
        /* class com.tencent.mm.plugin.appbrand.launching.e.e.AnonymousClass1 */

        {
            AppMethodBeat.i(160607);
            this.__eventId = d.class.getName().hashCode();
            AppMethodBeat.o(160607);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(d dVar) {
            AppMethodBeat.i(47453);
            e.a(e.this, "AppBrand_onEnterAnimationComplete");
            AppMethodBeat.o(47453);
            return false;
        }
    };
    private d mZn;

    static /* synthetic */ void a(e eVar, String str) {
        AppMethodBeat.i(47461);
        eVar.acm(str);
        AppMethodBeat.o(47461);
    }

    public e(AppBrandLaunchProxyUI appBrandLaunchProxyUI) {
        super(appBrandLaunchProxyUI);
        AppMethodBeat.i(47454);
        AppMethodBeat.o(47454);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.e.g
    public final boolean bOi() {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.e.g
    public final void onResume() {
        AppMethodBeat.i(47457);
        this.lvW++;
        Log.i("MicroMsg.FromMMProxyUI", "onResume, resume count:%d", Integer.valueOf(this.lvW));
        if (this.lvW > 1) {
            acm("NotFirstResume");
        }
        AppMethodBeat.o(47457);
    }

    private void acm(String str) {
        AppMethodBeat.i(47458);
        if (this.mZn == null || this.mZn.mYU) {
            Log.i("MicroMsg.FromMMProxyUI", "reason[%s] process[%s] isFinished, just finish activity", str, this.mToken);
            finish();
        }
        AppMethodBeat.o(47458);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.e.g
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.e.g
    public final void onDestroy() {
        AppMethodBeat.i(47459);
        this.mZm.dead();
        if (this.mZn != null) {
            this.mZn.bOc();
        }
        AppMethodBeat.o(47459);
    }

    private void finish() {
        AppMethodBeat.i(47455);
        ((AppBrandLaunchProxyUI) super.getBaseContext()).finish();
        AppMethodBeat.o(47455);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.e.g
    public final void H(Intent intent) {
        AppMethodBeat.i(47456);
        y.e(((AppBrandLaunchProxyUI) super.getBaseContext()).getWindow());
        y.d(((AppBrandLaunchProxyUI) super.getBaseContext()).getWindow(), true);
        String stringExtra = intent.getStringExtra("extra_entry_token");
        d acl = d.acl(stringExtra);
        if (acl == null) {
            finish();
            AppMethodBeat.o(47456);
            return;
        }
        acl.setBaseContext((AppBrandLaunchProxyUI) super.getBaseContext());
        this.mToken = stringExtra;
        this.mZn = acl;
        this.mZm.alive();
        AppMethodBeat.o(47456);
    }

    public final /* bridge */ /* synthetic */ Context getBaseContext() {
        AppMethodBeat.i(47460);
        AppBrandLaunchProxyUI appBrandLaunchProxyUI = (AppBrandLaunchProxyUI) super.getBaseContext();
        AppMethodBeat.o(47460);
        return appBrandLaunchProxyUI;
    }
}
