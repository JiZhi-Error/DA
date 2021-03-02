package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.widget.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\"\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J&\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/widget/ToastUtil;", "", "()V", "dismiss", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dialog", "showProgress", "wording", "", "context", "Landroid/content/Context;", "showToast", "bundle", "Landroid/os/Bundle;", "plugin-webview_release"})
public final class p {
    public static final p JAu = new p();

    static {
        AppMethodBeat.i(82756);
        AppMethodBeat.o(82756);
    }

    private p() {
    }

    public static final q a(Bundle bundle, Context context, q qVar) {
        String str;
        String str2;
        AppMethodBeat.i(82753);
        kotlin.g.b.p.h(context, "context");
        if (bundle != null) {
            str = bundle.getString("status");
        } else {
            str = null;
        }
        if (str != null) {
            switch (str.hashCode()) {
                case -1867169789:
                    if (str.equals("success")) {
                        if (bundle != null) {
                            str2 = bundle.getString("wording");
                        } else {
                            str2 = null;
                        }
                        u.cG(context, str2);
                        break;
                    }
                    break;
                case 336650556:
                    if (str.equals("loading")) {
                        String string = context.getString(R.string.a06);
                        kotlin.g.b.p.g(string, "context.getString(R.string.app_waiting)");
                        q a2 = a(string, context, qVar);
                        AppMethodBeat.o(82753);
                        return a2;
                    }
                    break;
                case 1940070258:
                    if (str.equals("dismissloading")) {
                        q b2 = b(qVar);
                        AppMethodBeat.o(82753);
                        return b2;
                    }
                    break;
            }
        }
        AppMethodBeat.o(82753);
        return null;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    public static final class a implements DialogInterface.OnCancelListener {
        public static final a JAv = new a();

        static {
            AppMethodBeat.i(82752);
            AppMethodBeat.o(82752);
        }

        a() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(82751);
            try {
                dialogInterface.dismiss();
                AppMethodBeat.o(82751);
            } catch (Exception e2) {
                n.a aVar = n.JzB;
                Log.e(n.TAG, "showProgressDlg onCancel exp: %s ", e2.getLocalizedMessage());
                AppMethodBeat.o(82751);
            }
        }
    }

    public static q b(q qVar) {
        AppMethodBeat.i(82755);
        if (qVar != null && qVar.isShowing()) {
            qVar.dismiss();
        }
        AppMethodBeat.o(82755);
        return qVar;
    }

    public static q a(String str, Context context, q qVar) {
        AppMethodBeat.i(82754);
        kotlin.g.b.p.h(str, "wording");
        kotlin.g.b.p.h(context, "context");
        MMActivity ib = q.ib(context);
        if (ib == null || !ib.isFinishing()) {
            if (qVar != null) {
                b(qVar);
                if (!qVar.isShowing()) {
                    qVar.show();
                    AppMethodBeat.o(82754);
                    return qVar;
                }
            }
            q a2 = h.a(context, str, true, (DialogInterface.OnCancelListener) a.JAv);
            AppMethodBeat.o(82754);
            return a2;
        }
        AppMethodBeat.o(82754);
        return null;
    }
}
