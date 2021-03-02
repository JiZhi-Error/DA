package com.tencent.mm.plugin.appbrand.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.e.c;
import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import java.io.StringReader;
import java.util.LinkedList;
import kotlin.f.d;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/permission/WeChatBrandsApiInvokeInterceptor;", "", "()V", "ERR_MSG_BANNED", "", "PAY_API_CHECK_ISSUED_TEXT", "PAY_API_CHECK_LIST", "Ljava/util/LinkedList;", "shouldInterceptInvoke", "", "env", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", ProviderConstants.API_PATH, "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "interceptHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent$InterceptHandler;", "plugin-appbrand-integration_release"})
public final class s {
    private static final String nxN = "requestPayment\nrequestPaymentToBank\nsendBizRedPacket\nrequestVirtualPayment\nopenOfflinePayView\nopenWCPayCardList\nrequestMallPayment\nopenWCPayLQTDetail\nopenWCPayLQTSave\nopenWCPayLQTDepositPlan\nopenWCPayLQTDepositPlanAdd\nsetCurrentPaySpeech\nloadPaySpeechDialectConfig\nopenWCPayOverseaPaymentReceive\nhandleWCPayOverseaWalletBuffer\nrequestH5Transaction\nrequestJointPayment\ngetWCPayOverseaPrepayRequest\nrequestVerifyUserIdentity\nopenSelectPayment\nrequestEntrustAuthorization\nrequestPayCardVerify\nrequestBizSplitBillPayment\nrequestQueryCashier\n\nsendRedPacket\nopenRedPacket\nopenWCCardHomePage\nopenWCCertHomePage\nhandleWCPayOverseaWalletBuffer\ngetWCPayOverseaPrepayRequest\nrequestMidasFriendPayment\nrequestFacetoFacePayment";
    private static final LinkedList<String> nxO = new LinkedList<>();
    public static final s nxP = new s();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "supplier", "Lcom/tencent/mm/sdk/platformtools/WeChatBrands$Business$AvailabilityAlertSupplier;", "kotlin.jvm.PlatformType", "accept"})
    public static final class a<T> implements c<WeChatBrands.Business.AvailabilityAlertSupplier> {
        final /* synthetic */ f.a nxR;
        final /* synthetic */ p nxS;
        final /* synthetic */ k nxT;

        a(f.a aVar, p pVar, k kVar) {
            this.nxR = aVar;
            this.nxS = pVar;
            this.nxT = kVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.support.v4.e.c
        public final /* synthetic */ void accept(WeChatBrands.Business.AvailabilityAlertSupplier availabilityAlertSupplier) {
            AppMethodBeat.i(229259);
            final WeChatBrands.Business.AvailabilityAlertSupplier availabilityAlertSupplier2 = availabilityAlertSupplier;
            f.a aVar = this.nxR;
            if (aVar != null) {
                aVar.Zb(this.nxS.Zf("fail limited use"));
            }
            this.nxT.P(new Runnable(this) {
                /* class com.tencent.mm.plugin.appbrand.permission.s.a.AnonymousClass1 */
                final /* synthetic */ a nxU;

                {
                    this.nxU = r1;
                }

                public final void run() {
                    AppMethodBeat.i(229258);
                    Context context = this.nxU.nxT.getContext();
                    if (!(context == null || this.nxU.nxT.getDialogContainer() == null)) {
                        b bVar = new b(context);
                        WeChatBrands.Business.AvailabilityAlertSupplier availabilityAlertSupplier = availabilityAlertSupplier2;
                        kotlin.g.b.p.g(availabilityAlertSupplier, "supplier");
                        bVar.setTitle(availabilityAlertSupplier.getTilte());
                        WeChatBrands.Business.AvailabilityAlertSupplier availabilityAlertSupplier2 = availabilityAlertSupplier2;
                        kotlin.g.b.p.g(availabilityAlertSupplier2, "supplier");
                        bVar.setMessage(availabilityAlertSupplier2.getBody());
                        WeChatBrands.Business.AvailabilityAlertSupplier availabilityAlertSupplier3 = availabilityAlertSupplier2;
                        kotlin.g.b.p.g(availabilityAlertSupplier3, "supplier");
                        String negativeBtnText = availabilityAlertSupplier3.getNegativeBtnText();
                        if (!(negativeBtnText == null || negativeBtnText.length() == 0)) {
                            WeChatBrands.Business.AvailabilityAlertSupplier availabilityAlertSupplier4 = availabilityAlertSupplier2;
                            kotlin.g.b.p.g(availabilityAlertSupplier4, "supplier");
                            WeChatBrands.Business.AvailabilityAlertSupplier availabilityAlertSupplier5 = availabilityAlertSupplier2;
                            kotlin.g.b.p.g(availabilityAlertSupplier5, "supplier");
                            bVar.b(availabilityAlertSupplier4.getNegativeBtnText(), true, availabilityAlertSupplier5.getOnNegativeClickListener());
                        }
                        WeChatBrands.Business.AvailabilityAlertSupplier availabilityAlertSupplier6 = availabilityAlertSupplier2;
                        kotlin.g.b.p.g(availabilityAlertSupplier6, "supplier");
                        WeChatBrands.Business.AvailabilityAlertSupplier availabilityAlertSupplier7 = availabilityAlertSupplier2;
                        kotlin.g.b.p.g(availabilityAlertSupplier7, "supplier");
                        bVar.a(availabilityAlertSupplier6.getPositiveBtnText(), true, availabilityAlertSupplier7.getOnPositiveClickListener());
                        bVar.setOnDismissListener(new DialogInterface.OnDismissListener(this) {
                            /* class com.tencent.mm.plugin.appbrand.permission.s.a.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 nxW;

                            {
                                this.nxW = r1;
                            }

                            public final void onDismiss(DialogInterface dialogInterface) {
                                AppMethodBeat.i(229257);
                                WeChatBrands.Business.AvailabilityAlertSupplier availabilityAlertSupplier = availabilityAlertSupplier2;
                                kotlin.g.b.p.g(availabilityAlertSupplier, "supplier");
                                if (availabilityAlertSupplier.getOnDismissListener() != null) {
                                    WeChatBrands.Business.AvailabilityAlertSupplier availabilityAlertSupplier2 = availabilityAlertSupplier2;
                                    kotlin.g.b.p.g(availabilityAlertSupplier2, "supplier");
                                    availabilityAlertSupplier2.getOnDismissListener().onClick(dialogInterface, -2);
                                }
                                AppMethodBeat.o(229257);
                            }
                        });
                        m dialogContainer = this.nxU.nxT.getDialogContainer();
                        if (dialogContainer == null) {
                            kotlin.g.b.p.hyc();
                        }
                        dialogContainer.b(bVar);
                    }
                    AppMethodBeat.o(229258);
                }
            });
            AppMethodBeat.o(229259);
        }
    }

    static {
        AppMethodBeat.i(229261);
        d.a(new StringReader(nxN), AnonymousClass1.nxQ);
        AppMethodBeat.o(229261);
    }

    private s() {
    }

    public static final boolean a(k kVar, p pVar, f.a aVar) {
        AppMethodBeat.i(229260);
        kotlin.g.b.p.h(kVar, "env");
        kotlin.g.b.p.h(pVar, ProviderConstants.API_PATH);
        if (!nxO.contains(pVar.getName())) {
            AppMethodBeat.o(229260);
            return false;
        } else if (!WeChatBrands.Business.Entries.PaymentAppbrandJsb.checkAvailableSlient(kVar.getContext(), new a(aVar, pVar, kVar))) {
            AppMethodBeat.o(229260);
            return true;
        } else {
            AppMethodBeat.o(229260);
            return false;
        }
    }
}
