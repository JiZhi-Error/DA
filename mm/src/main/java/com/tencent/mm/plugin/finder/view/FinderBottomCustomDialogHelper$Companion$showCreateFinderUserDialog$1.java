package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.a;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
public final class FinderBottomCustomDialogHelper$Companion$showCreateFinderUserDialog$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ Context $context;
    final /* synthetic */ Intent $intent;
    final /* synthetic */ int $scene;

    FinderBottomCustomDialogHelper$Companion$showCreateFinderUserDialog$1(Intent intent, int i2, Context context) {
        this.$intent = intent;
        this.$scene = i2;
        this.$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        AppMethodBeat.i(254626);
        Intent intent = this.$intent;
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra("scene", this.$scene);
        intent.putExtra("key_create_scene", this.$scene);
        a aVar = a.vUU;
        a.w(this.$context, intent);
        k kVar = k.vkd;
        k.a(s.af.CLICK_START_LIVE);
        AppMethodBeat.o(254626);
    }
}
