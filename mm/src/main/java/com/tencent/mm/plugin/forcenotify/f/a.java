package com.tencent.mm.plugin.forcenotify.f;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.s;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J$\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/forcenotify/util/ForceNotifyPermissionUtil;", "", "()V", "TAG", "", "TYPE_CHAT", "", "TYPE_LIVE", "checkPermission", "", "context", "Landroid/content/Context;", "type", "dialogNewTask", "", "callback", "Lcom/tencent/mm/plugin/forcenotify/util/ForceNotifyPermissionUtil$IPermissionCallback;", "getWordingByType", "Lkotlin/Pair;", "isPermissionGranted", "IPermissionCallback", "plugin-force-notify_release"})
public final class a {
    public static final a UWN = new a();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/forcenotify/util/ForceNotifyPermissionUtil$IPermissionCallback;", "", "onResult", "", "ok", "", "plugin-force-notify_release"})
    /* renamed from: com.tencent.mm.plugin.forcenotify.f.a$a  reason: collision with other inner class name */
    public interface AbstractC1365a {
        void dQ(boolean z);
    }

    static {
        AppMethodBeat.i(261875);
        AppMethodBeat.o(261875);
    }

    private a() {
    }

    public static boolean ml(Context context) {
        AppMethodBeat.i(261873);
        p.h(context, "context");
        boolean cx = com.tencent.mm.compatible.e.b.cx(context);
        AppMethodBeat.o(261873);
        return cx;
    }

    public static void a(Context context, int i2, AbstractC1365a aVar) {
        o U;
        AppMethodBeat.i(261874);
        p.h(context, "context");
        p.h(aVar, "callback");
        if (com.tencent.mm.compatible.e.b.cx(context)) {
            Log.w("MicroMsg.ForceNotifyPermissionUtil", "checkPermission already granted");
            aVar.dQ(true);
            AppMethodBeat.o(261874);
            return;
        }
        ar.a aVar2 = null;
        if (i2 == 2) {
            aVar2 = ar.a.USERINFO_FORCE_NOTIFY_PERMISSION_LIVE_POP_COUNT_INT_SYNC;
        }
        if (aVar2 != null) {
            com.tencent.mm.plugin.forcenotify.d.b bVar = com.tencent.mm.plugin.forcenotify.d.b.UWa;
            int j2 = com.tencent.mm.plugin.forcenotify.d.b.j(aVar2);
            if (j2 > 0) {
                aVar.dQ(false);
                AppMethodBeat.o(261874);
                return;
            }
            com.tencent.mm.plugin.forcenotify.d.b bVar2 = com.tencent.mm.plugin.forcenotify.d.b.UWa;
            com.tencent.mm.plugin.forcenotify.d.b.d(aVar2, j2 + 1);
        }
        b bVar3 = new b(aVar, context);
        switch (i2) {
            case 1:
                U = s.U(context.getString(R.string.jd8), context.getString(R.string.jd6));
                break;
            case 2:
                U = s.U(context.getString(R.string.jd9), context.getString(R.string.jd7));
                break;
            default:
                U = s.U(context.getString(R.string.jd8), context.getString(R.string.jd6));
                break;
        }
        A a2 = U.first;
        B b2 = U.second;
        ForceNotifyAcceptUI.a aVar3 = ForceNotifyAcceptUI.UWd;
        b bVar4 = bVar3;
        String apJ = com.tencent.mm.bq.a.apJ();
        p.g(apJ, "NotificationHelper.getMessageChannelIdUse()");
        p.h(context, "context");
        p.h(a2, "title");
        p.h(b2, "warningContent");
        p.h(bVar4, "resultCallBack");
        p.h(apJ, "channel");
        ForceNotifyAcceptUI.a(bVar4);
        Intent intent = new Intent(context, ForceNotifyAcceptUI.class);
        intent.putExtra("title", (String) a2);
        intent.putExtra("warning_content", (String) b2);
        String canonicalName = ForceNotifyAcceptUI.class.getCanonicalName();
        if (canonicalName == null) {
            p.hyc();
        }
        p.g(canonicalName, "ForceNotifyAcceptUI::class.java.canonicalName!!");
        com.tencent.mm.util.a.a(context, intent, b2, canonicalName, apJ);
        AppMethodBeat.o(261874);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/forcenotify/util/ForceNotifyPermissionUtil$checkPermission$resultCallback$1", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyAcceptUI;", "onResultCancel", "onResultRefuse", "plugin-force-notify_release"})
    public static final class b implements ForceNotifyAcceptUI.b {
        final /* synthetic */ Context $context;
        final /* synthetic */ AbstractC1365a UWO;

        b(AbstractC1365a aVar, Context context) {
            this.UWO = aVar;
            this.$context = context;
        }

        @Override // com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI.b
        public final void b(ForceNotifyAcceptUI forceNotifyAcceptUI) {
            AppMethodBeat.i(261870);
            Log.w("MicroMsg.ForceNotifyPermissionUtil", "checkPermission permission granted");
            forceNotifyAcceptUI.finish();
            this.UWO.dQ(true);
            AppMethodBeat.o(261870);
        }

        @Override // com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI.b
        public final void c(ForceNotifyAcceptUI forceNotifyAcceptUI) {
            AppMethodBeat.i(261871);
            Log.w("MicroMsg.ForceNotifyPermissionUtil", "checkPermission permission refused");
            forceNotifyAcceptUI.finish();
            this.UWO.dQ(false);
            AppMethodBeat.o(261871);
        }

        @Override // com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI.b
        public final void d(ForceNotifyAcceptUI forceNotifyAcceptUI) {
            AppMethodBeat.i(261872);
            boolean cx = com.tencent.mm.compatible.e.b.cx(this.$context);
            Log.w("MicroMsg.ForceNotifyPermissionUtil", "checkPermission cancel, ok:".concat(String.valueOf(cx)));
            if (forceNotifyAcceptUI != null) {
                forceNotifyAcceptUI.finish();
            }
            this.UWO.dQ(cx);
            AppMethodBeat.o(261872);
        }
    }
}
