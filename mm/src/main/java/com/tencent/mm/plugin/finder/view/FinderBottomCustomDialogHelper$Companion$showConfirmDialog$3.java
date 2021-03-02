package com.tencent.mm.plugin.finder.view;

import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.e;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
public final class FinderBottomCustomDialogHelper$Companion$showConfirmDialog$3 implements e.b {
    final /* synthetic */ DialogInterface.OnDismissListener $ldismiss;

    FinderBottomCustomDialogHelper$Companion$showConfirmDialog$3(DialogInterface.OnDismissListener onDismissListener) {
        this.$ldismiss = onDismissListener;
    }

    @Override // com.tencent.mm.ui.widget.a.e.b
    public final void onDismiss() {
        AppMethodBeat.i(254624);
        DialogInterface.OnDismissListener onDismissListener = this.$ldismiss;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(null);
            AppMethodBeat.o(254624);
            return;
        }
        AppMethodBeat.o(254624);
    }
}
