package com.tencent.mm.plugin.finder.view;

import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.ui.MMActivity;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
public final class FinderBottomCustomDialogHelper$Companion$showCreateFinderUserDialogOnLiveRedPacket$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ MMActivity $context;
    final /* synthetic */ Intent $intent;
    final /* synthetic */ DialogInterface.OnClickListener $lok;
    final /* synthetic */ int $requestCode;
    final /* synthetic */ int $scene;

    FinderBottomCustomDialogHelper$Companion$showCreateFinderUserDialogOnLiveRedPacket$1(Intent intent, int i2, MMActivity mMActivity, int i3, DialogInterface.OnClickListener onClickListener) {
        this.$intent = intent;
        this.$scene = i2;
        this.$context = mMActivity;
        this.$requestCode = i3;
        this.$lok = onClickListener;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        AppMethodBeat.i(261498);
        Intent intent = this.$intent;
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra("scene", this.$scene);
        intent.putExtra("key_create_scene", this.$scene);
        a aVar = a.vUU;
        a.d(this.$context, intent, this.$requestCode);
        DialogInterface.OnClickListener onClickListener = this.$lok;
        if (onClickListener != null) {
            onClickListener.onClick(dialogInterface, i2);
            AppMethodBeat.o(261498);
            return;
        }
        AppMethodBeat.o(261498);
    }
}
