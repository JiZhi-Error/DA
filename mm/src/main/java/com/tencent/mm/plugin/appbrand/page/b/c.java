package com.tencent.mm.plugin.appbrand.page.b;

import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.b.e;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u0018*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J'\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00102\u0006\u0010\t\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0011J\u001d\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0014¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00102\u0006\u0010\t\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0011J\b\u0010\u0016\u001a\u00020\u0017H\u0016¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageConfirmNavigateBackInterceptor;", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor;", "()V", "getTypePageNavigateBackInterceptor", "Lcom/tencent/mm/plugin/appbrand/page/navigation/TypePageNavigateBackInterceptor;", "intercept", "", "runtime", "scene", "", "continueNavigateBack", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;Ljava/lang/Runnable;)Z", "onClickDialogLeaveButton", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "onClickDialogStayButton", "onCustomIntercept", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)Z", "onInterceptionDialogShown", DownloadInfo.PRIORITY, "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority;", "Companion", "luggage-wxa-app_release"})
public class c<T extends AppBrandRuntime> implements e<T> {
    public static final a nvJ = new a((byte) 0);

    static {
        AppMethodBeat.i(219737);
        AppMethodBeat.o(219737);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.b.e
    public final boolean a(T t, String str, Runnable runnable) {
        String str2;
        AppMethodBeat.i(219732);
        p.h(t, "runtime");
        p.h(str, "scene");
        w brh = t.brh();
        p.g(brh, "runtime.pageContainer");
        t currentPage = brh.getCurrentPage();
        g a2 = currentPage != null ? currentPage.a(i.WITH_CONFIRM_DIALOG) : null;
        if (a2 == null) {
            Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "navigateBackInterceptionInfo is null");
            AppMethodBeat.o(219732);
            return false;
        } else if (!a2.adY(str)) {
            Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "scene:[" + str + "] disable");
            AppMethodBeat.o(219732);
            return false;
        } else {
            w brh2 = t.brh();
            p.g(brh2, "runtime.pageContainer");
            if (brh2.getPageCount() <= 1) {
                Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "leave current wxa, can't intercept");
                AppMethodBeat.o(219732);
                return false;
            } else if (!l(t, str)) {
                Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "custom intercept return false");
                AppMethodBeat.o(219732);
                return false;
            } else {
                Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "show navigate back interception dialog");
                com.tencent.mm.plugin.appbrand.widget.dialog.b bVar = new com.tencent.mm.plugin.appbrand.widget.dialog.b(t.getContext());
                if (Util.isNullOrNil(a2.nvR)) {
                    str2 = "";
                } else {
                    str2 = a2.nvR;
                }
                bVar.setMessage(str2);
                bVar.setCanceledOnTouchOutside(false);
                bVar.setCancelable(false);
                bVar.a(R.string.a2a, new b(this, runnable, t, bVar));
                bVar.b(R.string.a2b, new DialogInterface$OnClickListenerC0771c(this, t, bVar));
                m dialogContainer = t.getDialogContainer();
                if (dialogContainer != null) {
                    dialogContainer.b(bVar);
                }
                ai(t);
                AppMethodBeat.o(219732);
                return true;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    static final class b implements DialogInterface.OnClickListener {
        final /* synthetic */ c nvK;
        final /* synthetic */ Runnable nvL;
        final /* synthetic */ AppBrandRuntime nvM;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.widget.dialog.b nvN;

        b(c cVar, Runnable runnable, AppBrandRuntime appBrandRuntime, com.tencent.mm.plugin.appbrand.widget.dialog.b bVar) {
            this.nvK = cVar;
            this.nvL = runnable;
            this.nvM = appBrandRuntime;
            this.nvN = bVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.tencent.mm.plugin.appbrand.page.b.c */
        /* JADX WARN: Multi-variable type inference failed */
        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(219730);
            c cVar = this.nvK;
            Runnable runnable = this.nvL;
            if (runnable != null) {
                runnable.run();
            }
            Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "dialog confirm to navigate back");
            cVar.ak(this.nvM);
            this.nvN.dismiss();
            AppMethodBeat.o(219730);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.page.b.c$c  reason: collision with other inner class name */
    static final class DialogInterface$OnClickListenerC0771c implements DialogInterface.OnClickListener {
        final /* synthetic */ c nvK;
        final /* synthetic */ AppBrandRuntime nvM;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.widget.dialog.b nvN;

        DialogInterface$OnClickListenerC0771c(c cVar, AppBrandRuntime appBrandRuntime, com.tencent.mm.plugin.appbrand.widget.dialog.b bVar) {
            this.nvK = cVar;
            this.nvM = appBrandRuntime;
            this.nvN = bVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.tencent.mm.plugin.appbrand.page.b.c */
        /* JADX WARN: Multi-variable type inference failed */
        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(219731);
            c cVar = this.nvK;
            Log.i("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "keep staying current page");
            cVar.aj(this.nvM);
            this.nvN.dismiss();
            AppMethodBeat.o(219731);
        }
    }

    /* access modifiers changed from: protected */
    public boolean l(T t, String str) {
        AppMethodBeat.i(219733);
        p.h(t, "runtime");
        p.h(str, "scene");
        AppMethodBeat.o(219733);
        return true;
    }

    /* access modifiers changed from: protected */
    public void ai(T t) {
        AppMethodBeat.i(219734);
        p.h(t, "runtime");
        AppMethodBeat.o(219734);
    }

    /* access modifiers changed from: protected */
    public void aj(T t) {
        AppMethodBeat.i(219735);
        p.h(t, "runtime");
        AppMethodBeat.o(219735);
    }

    /* access modifiers changed from: protected */
    public void ak(T t) {
        AppMethodBeat.i(219736);
        p.h(t, "runtime");
        AppMethodBeat.o(219736);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/navigation/BaseAppBrandPageConfirmNavigateBackInterceptor$Companion;", "", "()V", "TAG", "", "luggage-wxa-app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.page.b.e
    public final e.a bSD() {
        return e.a.b.nvQ;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.b.e
    public final i bSE() {
        return i.WITH_CONFIRM_DIALOG;
    }
}
