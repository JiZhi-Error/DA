package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.base.u;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke", "com/tencent/mm/plugin/finder/view/FinderBottomCustomDialogHelper$Companion$showUserInfoConfirmDialog$1$1"})
public final class FinderBottomCustomDialogHelper$Companion$showUserInfoConfirmDialog$$inlined$let$lambda$1 extends q implements b<Boolean, x> {
    final /* synthetic */ String $cancel$inlined;
    final /* synthetic */ Context $context$inlined;
    final /* synthetic */ DialogInterface.OnDismissListener $dismiss$inlined;
    final /* synthetic */ String $finderUserName$inlined;
    final /* synthetic */ DialogInterface.OnClickListener $lcancel$inlined;
    final /* synthetic */ DialogInterface.OnClickListener $lok$inlined;
    final /* synthetic */ String $ok$inlined;
    final /* synthetic */ String $title$inlined;
    final /* synthetic */ View $userInfoContainer$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderBottomCustomDialogHelper$Companion$showUserInfoConfirmDialog$$inlined$let$lambda$1(Context context, String str, View view, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener) {
        super(1);
        this.$context$inlined = context;
        this.$finderUserName$inlined = str;
        this.$userInfoContainer$inlined = view;
        this.$title$inlined = str2;
        this.$ok$inlined = str3;
        this.$cancel$inlined = str4;
        this.$lok$inlined = onClickListener;
        this.$lcancel$inlined = onClickListener2;
        this.$dismiss$inlined = onDismissListener;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ x invoke(Boolean bool) {
        AppMethodBeat.i(254632);
        invoke(bool.booleanValue());
        x xVar = x.SXb;
        AppMethodBeat.o(254632);
        return xVar;
    }

    public final void invoke(boolean z) {
        AppMethodBeat.i(254633);
        if (z) {
            FinderBottomCustomDialogHelper.Companion.showConfirmDialog$default(FinderBottomCustomDialogHelper.Companion, this.$context$inlined, null, 0, this.$title$inlined, this.$userInfoContainer$inlined, this.$ok$inlined, this.$cancel$inlined, 1, this.$lok$inlined, this.$lcancel$inlined, new DialogInterface.OnDismissListener(this) {
                /* class com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper$Companion$showUserInfoConfirmDialog$$inlined$let$lambda$1.AnonymousClass1 */
                final /* synthetic */ FinderBottomCustomDialogHelper$Companion$showUserInfoConfirmDialog$$inlined$let$lambda$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(261500);
                    DialogInterface.OnDismissListener onDismissListener = this.this$0.$dismiss$inlined;
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(dialogInterface);
                    }
                    k kVar = k.vkd;
                    k.a(s.af.CLICK_CANCEL_RETURN);
                    AppMethodBeat.o(261500);
                }
            }, 6, null);
            AppMethodBeat.o(254633);
            return;
        }
        u.u(this.$context$inlined, this.$context$inlined.getString(R.string.h9z), R.raw.icons_filled_error);
        AppMethodBeat.o(254633);
    }
}
