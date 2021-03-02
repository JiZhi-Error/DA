package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.cr.d;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApiOpenGrowthCare;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApi;", "()V", "NAME", "", "getNAME", "()Ljava/lang/String;", "invoke", "", "invokeArgs", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "appOpenBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "plugin-appbrand-integration_release"})
public final class g implements b {
    private final String NAME = "sdk_openGrowthCare";

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/MMActivity;", "invoke"})
    static final class a extends q implements b<MMActivity, x> {
        final /* synthetic */ String mkH;
        final /* synthetic */ WechatNativeExtraDataInvokeFunctionalPage nbo;
        final /* synthetic */ g nbv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(g gVar, WechatNativeExtraDataInvokeFunctionalPage wechatNativeExtraDataInvokeFunctionalPage, String str) {
            super(1);
            this.nbv = gVar;
            this.nbo = wechatNativeExtraDataInvokeFunctionalPage;
            this.mkH = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(MMActivity mMActivity) {
            AppMethodBeat.i(228905);
            final MMActivity mMActivity2 = mMActivity;
            p.h(mMActivity2, LocaleUtil.ITALIAN);
            mMActivity2.mmSetOnActivityResultCallback(new MMActivity.a(this) {
                /* class com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.g.a.AnonymousClass1 */
                final /* synthetic */ a nbw;

                {
                    this.nbw = r1;
                }

                @Override // com.tencent.mm.ui.MMActivity.a
                public final void d(int i2, int i3, Intent intent) {
                    AppMethodBeat.i(228904);
                    b.a.a(this.nbw.nbv, this.nbw.nbo, mMActivity2, 4);
                    mMActivity2.finish();
                    AppMethodBeat.o(228904);
                }
            });
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.mkH);
            intent.putExtra("forceHideShare", true);
            c.a((Context) mMActivity2, "webview", ".ui.tools.WebViewUI", intent, com.tencent.luggage.sdk.g.a.aK(mMActivity2), true);
            mMActivity2.overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
            x xVar = x.SXb;
            AppMethodBeat.o(228905);
            return xVar;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.b
    public final void a(WechatNativeExtraDataInvokeFunctionalPage wechatNativeExtraDataInvokeFunctionalPage, Context context) {
        AppMethodBeat.i(228907);
        p.h(wechatNativeExtraDataInvokeFunctionalPage, "invokeArgs");
        b.a.a(wechatNativeExtraDataInvokeFunctionalPage, context, null);
        AppMethodBeat.o(228907);
    }

    @Override // com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.b
    public final String bOK() {
        return this.NAME;
    }

    @Override // com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.b
    public final void a(WechatNativeExtraDataInvokeFunctionalPage wechatNativeExtraDataInvokeFunctionalPage, com.tencent.mm.plugin.appbrand.api.g gVar) {
        AppMethodBeat.i(228906);
        p.h(wechatNativeExtraDataInvokeFunctionalPage, "invokeArgs");
        p.h(gVar, "appOpenBundle");
        d.bpI("com.tencent.mm.intent.ACTION_START_MPTOOLS_PROCESS");
        d.b(null, new a(this, wechatNativeExtraDataInvokeFunctionalPage, "https://jiazhang.qq.com/wap/family/dist/main/index.html?_wv=1&source=h5_wx_sdk#/Index"));
        AppMethodBeat.o(228906);
    }
}
