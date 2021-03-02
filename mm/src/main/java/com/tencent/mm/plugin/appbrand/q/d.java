package com.tencent.mm.plugin.appbrand.q;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.plugin.multitask.a.a;
import com.tencent.mm.plugin.multitask.a.b;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public final class d extends b {
    private q lqE;

    public d(Activity activity, q qVar) {
        super(activity);
        this.lqE = qVar;
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final Activity getActivity() {
        AppMethodBeat.i(227213);
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.lqE.mContext);
        AppMethodBeat.o(227213);
        return castActivityOrNull;
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final View getContentView() {
        if (this.lqE != null) {
            return this.lqE.kAt;
        }
        return null;
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final View getMaskView() {
        AppMethodBeat.i(227214);
        View contentView = getContentView();
        AppMethodBeat.o(227214);
        return contentView;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0095 A[Catch:{ Exception -> 0x01d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0179  */
    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap getBitmap() {
        /*
        // Method dump skipped, instructions count: 499
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.q.d.getBitmap():android.graphics.Bitmap");
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final void a(boolean z, com.tencent.mm.plugin.multitask.b.b bVar) {
        boolean z2;
        AppMethodBeat.i(227216);
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
        AppMethodBeat.o(227216);
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final void a(a.b bVar) {
        AppMethodBeat.i(227218);
        super.a(bVar);
        if (ai.et(getActivity()) && getActivity().getResources().getConfiguration().orientation != 2) {
            ((ViewGroup) getContentView().getParent()).setBackground(null);
        }
        AppMethodBeat.o(227218);
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final boolean bPv() {
        return true;
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final boolean bCI() {
        boolean z;
        AppMethodBeat.i(227217);
        if (this.lqE != null) {
            z = this.lqE.NA();
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(227217);
            return false;
        }
        boolean bCI = super.bCI();
        AppMethodBeat.o(227217);
        return bCI;
    }
}
