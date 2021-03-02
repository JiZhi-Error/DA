package com.tencent.mm.plugin.sns.ad.timeline.feedback.ui;

import android.content.Context;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends PopupWindow implements PopupWindow.OnDismissListener {
    private PopupWindow.OnDismissListener DyL;
    private boolean DyM;
    public Context mContext;

    public a(Context context) {
        super(context);
        AppMethodBeat.i(202192);
        super.setOnDismissListener(this);
        this.mContext = context;
        AppMethodBeat.o(202192);
    }

    public final void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.DyL = onDismissListener;
    }

    public final void dismiss() {
        AppMethodBeat.i(202193);
        try {
            super.dismiss();
            AppMethodBeat.o(202193);
        } catch (Throwable th) {
            if (!this.DyM && this.DyL != null) {
                this.DyL.onDismiss();
            }
            AppMethodBeat.o(202193);
        }
    }

    public final void onDismiss() {
        AppMethodBeat.i(202194);
        try {
            this.DyM = true;
            if (this.DyL != null) {
                this.DyL.onDismiss();
            }
            AppMethodBeat.o(202194);
        } catch (Throwable th) {
            AppMethodBeat.o(202194);
        }
    }
}
