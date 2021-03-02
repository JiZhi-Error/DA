package com.tencent.mm.plugin.appbrand.page.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/navigation/AppBrandPageConfirmNavigateBackInterceptorWC;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageConfirmNavigateBackInterceptor;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "()V", "onClickDialogLeaveButton", "", "runtime", "onClickDialogStayButton", "onCustomIntercept", "", "scene", "", "onInterceptionDialogShown", "reportEvent", "eventId", "", "Companion", "plugin-appbrand-integration_release"})
public final class a extends c<q> {
    public static final C0769a nvI = new C0769a((byte) 0);

    static {
        AppMethodBeat.i(229252);
        AppMethodBeat.o(229252);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.AppBrandRuntime] */
    @Override // com.tencent.mm.plugin.appbrand.page.b.c
    public final /* synthetic */ void ai(q qVar) {
        AppMethodBeat.i(229248);
        q qVar2 = qVar;
        p.h(qVar2, "runtime");
        super.ai(qVar2);
        a(qVar2, 1);
        AppMethodBeat.o(229248);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.AppBrandRuntime] */
    @Override // com.tencent.mm.plugin.appbrand.page.b.c
    public final /* synthetic */ void aj(q qVar) {
        AppMethodBeat.i(229249);
        q qVar2 = qVar;
        p.h(qVar2, "runtime");
        super.aj(qVar2);
        a(qVar2, 3);
        AppMethodBeat.o(229249);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.AppBrandRuntime] */
    @Override // com.tencent.mm.plugin.appbrand.page.b.c
    public final /* synthetic */ void ak(q qVar) {
        AppMethodBeat.i(229250);
        q qVar2 = qVar;
        p.h(qVar2, "runtime");
        super.ak(qVar2);
        a(qVar2, 2);
        AppMethodBeat.o(229250);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.AppBrandRuntime, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.page.b.c
    public final /* synthetic */ boolean l(q qVar, String str) {
        AppMethodBeat.i(229247);
        q qVar2 = qVar;
        p.h(qVar2, "runtime");
        p.h(str, "scene");
        if (qVar2.bsC().cyo == 7) {
            Log.i("MicroMsg.AppBrandPageNavigateBackInterceptorWC", "fake native wxa, can't intercept");
            AppMethodBeat.o(229247);
            return false;
        }
        AppMethodBeat.o(229247);
        return true;
    }

    private static void a(q qVar, int i2) {
        g a2;
        String str;
        String str2;
        AppMethodBeat.i(229251);
        x bsD = qVar.bsD();
        p.g(bsD, "runtime.pageContainer");
        t currentPage = bsD.getCurrentPage();
        if (currentPage == null || (a2 = currentPage.a(i.WITH_CONFIRM_DIALOG)) == null) {
            AppMethodBeat.o(229251);
            return;
        }
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[5];
        objArr[0] = qVar.getAppId();
        objArr[1] = Long.valueOf(System.currentTimeMillis());
        x bsD2 = qVar.bsD();
        p.g(bsD2, "runtime.pageContainer");
        t currentPage2 = bsD2.getCurrentPage();
        if (currentPage2 == null || (str = currentPage2.getCurrentUrl()) == null) {
            str = "";
        }
        objArr[2] = str;
        objArr[3] = Integer.valueOf(i2);
        if (i2 == 1) {
            str2 = a2.nvR;
        } else {
            str2 = "";
        }
        objArr[4] = str2;
        hVar.a(19169, objArr);
        AppMethodBeat.o(229251);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/navigation/AppBrandPageConfirmNavigateBackInterceptorWC$Companion;", "", "()V", "REPORT_EVENT_CLICK_LEAVE_BUTTON", "", "REPORT_EVENT_CLICK_STAY_BUTTON", "REPORT_EVENT_SHOW_DIALOG", "TAG", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.page.b.a$a  reason: collision with other inner class name */
    public static final class C0769a {
        private C0769a() {
        }

        public /* synthetic */ C0769a(byte b2) {
            this();
        }
    }
}
