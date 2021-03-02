package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.q;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/LoadingDialog;", "Lcom/tencent/mm/plugin/finder/utils/LoadingWidget;", "()V", "loadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getLoadingDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setLoadingDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "getOnCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "setOnCancelListener", "(Landroid/content/DialogInterface$OnCancelListener;)V", "wording", "", "getWording", "()Ljava/lang/String;", "setWording", "(Ljava/lang/String;)V", "dismiss", "", "show", "plugin-finder_release"})
public final class ag extends ai {
    private String dQx;
    DialogInterface.OnCancelListener kke;
    private q loadingDialog;

    public ag() {
        AppMethodBeat.i(253791);
        String string = MMApplicationContext.getContext().getString(R.string.a06);
        p.g(string, "MMApplicationContext.get…ing(R.string.app_waiting)");
        this.dQx = string;
        AppMethodBeat.o(253791);
    }

    public final void awz(String str) {
        AppMethodBeat.i(253788);
        p.h(str, "<set-?>");
        this.dQx = str;
        AppMethodBeat.o(253788);
    }

    @Override // com.tencent.mm.plugin.finder.utils.ai
    public final void dismiss() {
        AppMethodBeat.i(253790);
        q qVar = this.loadingDialog;
        if (qVar != null) {
            qVar.dismiss();
            AppMethodBeat.o(253790);
            return;
        }
        AppMethodBeat.o(253790);
    }

    @Override // com.tencent.mm.plugin.finder.utils.ai
    public final void show() {
        boolean z;
        Context context;
        AppMethodBeat.i(253789);
        WeakReference<Context> weakReference = this.lAM;
        Context context2 = (weakReference == null || (context = weakReference.get()) == null) ? MMApplicationContext.getContext() : context;
        String str = this.dQx;
        if (this.kke != null) {
            z = true;
        } else {
            z = false;
        }
        this.loadingDialog = q.a(context2, str, z, 0, this.kke);
        AppMethodBeat.o(253789);
    }
}
