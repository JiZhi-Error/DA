package com.tencent.mm.plugin.appbrand.jsapi.profile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.c;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
public final class d extends AppBrandProxyUIProcessTask {
    public static final /* synthetic */ MMActivity a(d dVar) {
        AppMethodBeat.i(50658);
        MMActivity bDF = dVar.bDF();
        AppMethodBeat.o(50658);
        return bDF;
    }

    public static final /* synthetic */ void a(d dVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
        AppMethodBeat.i(50657);
        dVar.b(processResult);
        AppMethodBeat.o(50657);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest processRequest) {
        AppMethodBeat.i(50656);
        p.h(processRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        ProfileResult profileResult = new ProfileResult();
        if (!(processRequest instanceof ProfileRequest)) {
            Log.w("ProfileTask", "handleRequest, request not instance of ProfileRequest");
            profileResult.resultCode = 0;
            b(profileResult);
            AppMethodBeat.o(50656);
            return;
        }
        g.aAf();
        if (!com.tencent.mm.kernel.a.azo()) {
            Log.e("ProfileTask", "handleRequest, MMKernel.account().hasLogin() is false");
            profileResult.resultCode = 0;
            b(profileResult);
            AppMethodBeat.o(50656);
            return;
        }
        int i2 = ((ProfileRequest) processRequest).scene;
        String str = ((ProfileRequest) processRequest).username;
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str);
        if (Kn == null || Kn.arH() <= 0) {
            com.tencent.mm.kernel.c.a af2 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af2, "MMKernel.service(IMessengerStorage::class.java)");
            Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af2).aSN().bjH(str);
        }
        if (Kn == null || Kn.arH() <= 0) {
            Log.i("ProfileTask", "handleRequest, request contact info");
            bDF().getString(R.string.zb);
            ay.a.aVo().a(str, "", new a(this, profileResult, h.a((Context) bDF(), bDF().getString(R.string.a06), true, (DialogInterface.OnCancelListener) new b(this, str, profileResult)), i2));
            AppMethodBeat.o(50656);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", str);
        profileResult.username = Kn.getUsername();
        if (Kn.gBM()) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10298, Kn.getUsername() + "," + i2);
            profileResult.mnH |= 1;
            intent.putExtra("Contact_Scene", i2);
        }
        if (Kn.arv()) {
            profileResult.mnH |= 2;
            uj ujVar = new uj();
            ujVar.eaI.intent = intent;
            ujVar.eaI.username = str;
            EventCenter.instance.publish(ujVar);
        }
        profileResult.resultCode = 1;
        b(profileResult);
        AppMethodBeat.o(50656);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class b implements DialogInterface.OnCancelListener {
        final /* synthetic */ String hLl;
        final /* synthetic */ d mnI;
        final /* synthetic */ ProfileResult mnJ;

        b(d dVar, String str, ProfileResult profileResult) {
            this.mnI = dVar;
            this.hLl = str;
            this.mnJ = profileResult;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(50655);
            ay.a.aVo().JZ(this.hLl);
            this.mnJ.resultCode = 2;
            d.a(this.mnI, this.mnJ);
            AppMethodBeat.o(50655);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", ch.COL_USERNAME, "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
    static final class a implements ay.b.a {
        final /* synthetic */ int $scene;
        final /* synthetic */ d mnI;
        final /* synthetic */ ProfileResult mnJ;
        final /* synthetic */ q mnK;

        a(d dVar, ProfileResult profileResult, q qVar, int i2) {
            this.mnI = dVar;
            this.mnJ = profileResult;
            this.mnK = qVar;
            this.$scene = i2;
        }

        @Override // com.tencent.mm.model.ay.b.a
        public final void p(String str, boolean z) {
            AppMethodBeat.i(50654);
            if (d.a(this.mnI) == null) {
                Log.w("ProfileTask", "handleRequest, getNow callback, context has already been detached!");
                this.mnJ.resultCode = 0;
                d.a(this.mnI, this.mnJ);
                AppMethodBeat.o(50654);
                return;
            }
            q qVar = this.mnK;
            if (qVar != null) {
                qVar.dismiss();
            }
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str);
            if (Kn == null || Kn.arH() <= 0) {
                com.tencent.mm.kernel.c.a af2 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                p.g(af2, "MMKernel.service(IMessengerStorage::class.java)");
                ((com.tencent.mm.plugin.messenger.foundation.a.l) af2).aSN().bjH(str);
                z = false;
            } else {
                str = Kn.getUsername();
            }
            if (!z) {
                Log.w("ProfileTask", "handleRequest, getNow callback fail");
                this.mnJ.resultCode = 0;
                d.a(this.mnI, this.mnJ);
                AppMethodBeat.o(50654);
                return;
            }
            c.ap(str, 3);
            com.tencent.mm.aj.p.aYD().Mg(str);
            if (Kn == null) {
                p.hyc();
            }
            if (Kn.gBM()) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10298, Kn.getUsername() + "," + this.$scene);
                this.mnJ.mnH |= 1;
            }
            if (Kn.arv()) {
                this.mnJ.mnH |= 2;
            }
            this.mnJ.resultCode = 1;
            d.a(this.mnI, this.mnJ);
            AppMethodBeat.o(50654);
        }
    }
}
