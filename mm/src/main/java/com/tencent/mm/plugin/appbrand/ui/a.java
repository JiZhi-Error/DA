package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.co;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AccountReleasePromptMMTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "TAG", "", "checkShouldLogin", "", "handleRequest", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class a extends AppBrandProxyUIProcessTask {
    private final String TAG = "MicroMsg.AccountReleasePromptMMTask";

    public static final /* synthetic */ void a(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
        AppMethodBeat.i(51099);
        aVar.b(processResult);
        AppMethodBeat.o(51099);
    }

    public static final /* synthetic */ boolean a(a aVar) {
        AppMethodBeat.i(51097);
        boolean bWH = aVar.bWH();
        AppMethodBeat.o(51097);
        return bWH;
    }

    public static final /* synthetic */ MMActivity b(a aVar) {
        AppMethodBeat.i(51098);
        MMActivity bDF = aVar.bDF();
        AppMethodBeat.o(51098);
        return bDF;
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest processRequest) {
        AppMethodBeat.i(51095);
        if (!bWH()) {
            b(new AccountReleaseProxyUILaunchResult());
            AppMethodBeat.o(51095);
            return;
        }
        h.a((Context) bDF(), getString(R.string.hq), getString(R.string.zb), getString(R.string.jn), false, (DialogInterface.OnClickListener) new DialogInterface$OnClickListenerC0802a(this));
        new b(this).alive();
        AppMethodBeat.o(51095);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/appbrand/ui/AccountReleasePromptMMTask$handleRequest$1", "Landroid/content/DialogInterface$OnClickListener;", "onClick", "", "dialog", "Landroid/content/DialogInterface;", "which", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.a$a  reason: collision with other inner class name */
    public static final class DialogInterface$OnClickListenerC0802a implements DialogInterface.OnClickListener {
        final /* synthetic */ a nRe;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        DialogInterface$OnClickListenerC0802a(a aVar) {
            this.nRe = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(51093);
            if (a.a(this.nRe)) {
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.addFlags(67108864);
                intent.putExtra("Intro_Switch", true);
                c.f(a.b(this.nRe), ".ui.LauncherUI", intent);
            }
            a.a(this.nRe, new AccountReleaseProxyUILaunchResult());
            AppMethodBeat.o(51093);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/ui/AccountReleasePromptMMTask$handleRequest$2", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CoreAccountInitializationNotifiedEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
    public static final class b extends IListener<co> {
        final /* synthetic */ a nRe;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(a aVar) {
            this.nRe = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(co coVar) {
            AppMethodBeat.i(51094);
            a.a(this.nRe, new AccountReleaseProxyUILaunchResult());
            AppMethodBeat.o(51094);
            return false;
        }
    }

    private final boolean bWH() {
        AppMethodBeat.i(51096);
        if (com.tencent.mm.kernel.a.azj()) {
            Log.i(this.TAG, "checkShouldLogin account hold, return true");
            AppMethodBeat.o(51096);
            return true;
        } else if (!g.aAi().aAb() || !g.aAf().azp()) {
            Log.i(this.TAG, "checkShouldLogin fallback return true");
            AppMethodBeat.o(51096);
            return true;
        } else {
            Log.i(this.TAG, "checkShouldLogin account initialized, return false");
            AppMethodBeat.o(51096);
            return false;
        }
    }
}
