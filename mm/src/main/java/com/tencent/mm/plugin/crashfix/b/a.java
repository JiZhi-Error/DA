package com.tencent.mm.plugin.crashfix.b;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;

public final class a extends Dialog {
    private Runnable mHijackDismissAction;
    private final Runnable mReplaceRunnable = new Runnable() {
        /* class com.tencent.mm.plugin.crashfix.b.a.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(145617);
            try {
                Log.i("MicroMsg.SafeDismissDialog", "run on hijack runnable");
                a.this.mHijackDismissAction.run();
                AppMethodBeat.o(145617);
            } catch (Exception e2) {
                Log.e("MicroMsg.SafeDismissDialog", "protect : " + e2.getMessage());
                AppMethodBeat.o(145617);
            }
        }
    };

    public a(Context context) {
        super(context);
        AppMethodBeat.i(145618);
        hijackDismissAction();
        AppMethodBeat.o(145618);
    }

    public a(Context context, int i2) {
        super(context, i2);
        AppMethodBeat.i(145619);
        hijackDismissAction();
        AppMethodBeat.o(145619);
    }

    public final void dismiss() {
        AppMethodBeat.i(145620);
        try {
            super.dismiss();
            AppMethodBeat.o(145620);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SafeDismissDialog", e2, "", new Object[0]);
            AppMethodBeat.o(145620);
        }
    }

    private void hijackDismissAction() {
        AppMethodBeat.i(145621);
        if (Build.VERSION.SDK_INT > 28) {
            AppMethodBeat.o(145621);
            return;
        }
        try {
            Field declaredField = Dialog.class.getDeclaredField("mDismissAction");
            declaredField.setAccessible(true);
            try {
                Field declaredField2 = Field.class.getDeclaredField("accessFlags");
                declaredField2.setAccessible(true);
                declaredField2.setInt(declaredField, declaredField.getModifiers() & -17);
            } catch (Exception e2) {
            }
            this.mHijackDismissAction = (Runnable) declaredField.get(this);
            declaredField.set(this, this.mReplaceRunnable);
            AppMethodBeat.o(145621);
        } catch (NoSuchFieldException e3) {
            Log.e("MicroMsg.SafeDismissDialog", "hijack fail NoSuchFieldException");
            AppMethodBeat.o(145621);
        } catch (IllegalAccessException e4) {
            Log.e("MicroMsg.SafeDismissDialog", "hijack fail IllegalAccessException");
            AppMethodBeat.o(145621);
        }
    }
}
