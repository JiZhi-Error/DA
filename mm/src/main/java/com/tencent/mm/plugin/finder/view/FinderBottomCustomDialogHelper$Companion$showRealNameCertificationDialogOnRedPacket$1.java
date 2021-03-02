package com.tencent.mm.plugin.finder.view;

import android.app.Activity;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.a;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
public final class FinderBottomCustomDialogHelper$Companion$showRealNameCertificationDialogOnRedPacket$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ Activity $context;
    final /* synthetic */ DialogInterface.OnClickListener $lok;

    FinderBottomCustomDialogHelper$Companion$showRealNameCertificationDialogOnRedPacket$1(Activity activity, DialogInterface.OnClickListener onClickListener) {
        this.$context = activity;
        this.$lok = onClickListener;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        AppMethodBeat.i(261499);
        a aVar = a.vUU;
        a.am(this.$context);
        DialogInterface.OnClickListener onClickListener = this.$lok;
        if (onClickListener != null) {
            onClickListener.onClick(dialogInterface, i2);
            AppMethodBeat.o(261499);
            return;
        }
        AppMethodBeat.o(261499);
    }
}
