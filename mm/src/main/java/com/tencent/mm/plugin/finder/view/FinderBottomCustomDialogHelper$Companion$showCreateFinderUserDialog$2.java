package com.tencent.mm.plugin.finder.view;

import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
public final class FinderBottomCustomDialogHelper$Companion$showCreateFinderUserDialog$2 implements DialogInterface.OnDismissListener {
    public static final FinderBottomCustomDialogHelper$Companion$showCreateFinderUserDialog$2 INSTANCE = new FinderBottomCustomDialogHelper$Companion$showCreateFinderUserDialog$2();

    static {
        AppMethodBeat.i(254628);
        AppMethodBeat.o(254628);
    }

    FinderBottomCustomDialogHelper$Companion$showCreateFinderUserDialog$2() {
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        AppMethodBeat.i(254627);
        k kVar = k.vkd;
        k.a(s.af.CLICK_CANCEL_RETURN);
        AppMethodBeat.o(254627);
    }
}