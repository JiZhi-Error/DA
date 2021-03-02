package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage;
import com.tencent.mm.plugin.appbrand.ah.a.a;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApi;", "", "NAME", "", "getNAME", "()Ljava/lang/String;", "backToApp", "", "invokeArgs", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "context", "Landroid/content/Context;", "retMsg", "invoke", "appOpenBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "plugin-appbrand-integration_release"})
public interface b {
    void a(WechatNativeExtraDataInvokeFunctionalPage wechatNativeExtraDataInvokeFunctionalPage, Context context);

    void a(WechatNativeExtraDataInvokeFunctionalPage wechatNativeExtraDataInvokeFunctionalPage, g gVar);

    String bOK();

    @l(hxD = {1, 1, 16})
    public static final class a {
        public static /* synthetic */ void a(b bVar, WechatNativeExtraDataInvokeFunctionalPage wechatNativeExtraDataInvokeFunctionalPage, Context context, int i2) {
            AppMethodBeat.i(228892);
            if ((i2 & 2) != 0) {
                context = null;
            }
            bVar.a(wechatNativeExtraDataInvokeFunctionalPage, context);
            AppMethodBeat.o(228892);
        }

        public static void a(WechatNativeExtraDataInvokeFunctionalPage wechatNativeExtraDataInvokeFunctionalPage, Context context, String str) {
            AppMethodBeat.i(228891);
            p.h(wechatNativeExtraDataInvokeFunctionalPage, "invokeArgs");
            Bundle bundle = new Bundle();
            WXLaunchWxaRedirectingPage.Resp resp = new WXLaunchWxaRedirectingPage.Resp(Bundle.EMPTY);
            String str2 = wechatNativeExtraDataInvokeFunctionalPage.invokeTicket;
            if (str2 == null) {
                p.hyc();
            }
            resp.invokeTicket = str2;
            resp.callbackActivity = wechatNativeExtraDataInvokeFunctionalPage.callbackActivity;
            resp.errStr = null;
            resp.toBundle(bundle);
            q.bo(bundle);
            q.bp(bundle);
            a.C0537a aVar = a.C0537a.oFy;
            String str3 = wechatNativeExtraDataInvokeFunctionalPage.invokeTicket;
            if (str3 == null) {
                p.hyc();
            }
            Activity agm = a.C0537a.agm(str3);
            if (agm != null) {
                agm.overridePendingTransition(0, 0);
            }
            if (context == null) {
                context = MMApplicationContext.getContext();
            }
            MMessageActV2.Args args = new MMessageActV2.Args();
            args.targetPkgName = wechatNativeExtraDataInvokeFunctionalPage.packageName;
            args.bundle = bundle;
            MMessageActV2.send(context, args);
            AppMethodBeat.o(228891);
        }
    }
}
