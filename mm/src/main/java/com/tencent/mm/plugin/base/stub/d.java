package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class d {
    protected String appId;
    protected Context context;
    protected String openId;
    protected a pdr;

    public interface a {
        void jZ(boolean z);
    }

    public d(Context context2, String str, String str2, a aVar) {
        this.context = context2;
        this.appId = str;
        this.openId = str2;
        this.pdr = aVar;
    }

    public final void cjR() {
        AppMethodBeat.i(22178);
        if (this.openId == null || this.openId.length() == 0) {
            Log.w("MicroMsg.OpenIdChecker", "doCheck, openId is null");
            this.pdr.jZ(true);
            AppMethodBeat.o(22178);
            return;
        }
        g o = h.o(this.appId, false, false);
        if (o == null) {
            Log.e("MicroMsg.OpenIdChecker", "doCheck fail, local app is null, appId = " + this.appId);
            this.pdr.jZ(true);
            AppMethodBeat.o(22178);
        } else if (Util.isNullOrNil(o.field_openId)) {
            Log.w("MicroMsg.OpenIdChecker", "doCheck fail, local openId is null, appId = " + this.appId);
            Log.d("MicroMsg.OpenIdChecker", "doCheck, trigger getappsetting, appId = " + this.appId);
            ao.eAU().add(this.appId);
            this.pdr.jZ(true);
            AppMethodBeat.o(22178);
        } else if (this.openId.equalsIgnoreCase(o.field_openId)) {
            Log.d("MicroMsg.OpenIdChecker", "doCheck succ, appId = " + this.appId);
            this.pdr.jZ(true);
            AppMethodBeat.o(22178);
        } else {
            Log.w("MicroMsg.OpenIdChecker", "doCheck fail, appId = " + this.appId + ", openId = " + this.openId + ", localOpenId = " + o.field_openId);
            cjQ();
            AppMethodBeat.o(22178);
        }
    }

    /* access modifiers changed from: protected */
    public void cjQ() {
        AppMethodBeat.i(22179);
        com.tencent.mm.ui.base.h.a(this.context, (int) R.string.fj3, (int) R.string.zb, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.base.stub.d.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(22177);
                b dSQ = b.a.dSQ();
                if (dSQ != null) {
                    dSQ.k(d.this.openId, z.aUb(), d.this.appId);
                }
                d.this.pdr.jZ(false);
                AppMethodBeat.o(22177);
            }
        });
        AppMethodBeat.o(22179);
    }
}
