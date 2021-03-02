package com.tencent.mm.plugin.appbrand.floatball;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ak;
import com.tencent.mm.plugin.appbrand.ao;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public class d extends e {
    q lqE;

    public d(Activity activity, q qVar) {
        super(activity);
        AppMethodBeat.i(226544);
        this.lqE = qVar;
        q qVar2 = this.lqE;
        qVar2.kAB.kFx.add(new ao() {
            /* class com.tencent.mm.plugin.appbrand.floatball.d.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.ao
            public final void b(ak akVar) {
                AppMethodBeat.i(226543);
                d.this.activity = AndroidContextUtil.castActivityOrNull(d.this.lqE.mContext);
                AppMethodBeat.o(226543);
            }

            @Override // com.tencent.mm.plugin.appbrand.ao
            public final void btq() {
                d.this.activity = null;
            }
        });
        AppMethodBeat.o(226544);
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final Activity getActivity() {
        AppMethodBeat.i(226545);
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.lqE.mContext);
        AppMethodBeat.o(226545);
        return castActivityOrNull;
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final boolean aGg() {
        return false;
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final View getContentView() {
        if (this.lqE != null) {
            return this.lqE.kAt;
        }
        return null;
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final View getMaskView() {
        AppMethodBeat.i(44976);
        View contentView = getContentView();
        AppMethodBeat.o(44976);
        return contentView;
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final Bitmap getBitmap() {
        AppMethodBeat.i(44977);
        try {
            if (!(this.lqE == null || this.lqE.bsD() == null || this.lqE.bsD().getCurrentPage() == null || this.lqE.bsD().getCurrentPage().getCurrentPageView() == null)) {
                Bitmap bRB = this.lqE.bsD().getCurrentPage().getCurrentPageView().bRB();
                AppMethodBeat.o(44977);
                return bRB;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandFloatBallPageAdapter", e2, "appbrand getBitmap fail exception:%s", e2.getMessage());
        }
        Bitmap bitmap = super.getBitmap();
        AppMethodBeat.o(44977);
        return bitmap;
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public final void hb(boolean z) {
        boolean z2;
        AppMethodBeat.i(44978);
        if (this.lqE != null) {
            if (getActivity() instanceof AppBrandUI) {
                AppBrandUI appBrandUI = (AppBrandUI) getActivity();
                if (!z) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                appBrandUI.nXd = z2;
            }
            this.lqE.bsu();
        }
        AppMethodBeat.o(44978);
    }

    @Override // com.tencent.mm.plugin.ball.a.e, com.tencent.mm.plugin.ball.a.f
    public boolean bCI() {
        boolean z;
        AppMethodBeat.i(44979);
        if (this.lqE != null) {
            z = this.lqE.NA();
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(44979);
            return false;
        } else if (com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.INSTANCE.qtB) {
            AppMethodBeat.o(44979);
            return false;
        } else {
            boolean bCI = super.bCI();
            AppMethodBeat.o(44979);
            return bCI;
        }
    }
}
