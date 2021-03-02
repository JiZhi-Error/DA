package com.tencent.mm.ui.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.c;
import java.lang.reflect.Field;

public class i extends Dialog {
    private static final String TAG = "MicroMsg.MMDialog";
    private c iOnDialogDismissListener;
    private Runnable mHijackDismissAction;
    private final Runnable mReplaceRunnable = new Runnable() {
        /* class com.tencent.mm.ui.base.i.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(141873);
            try {
                Log.i(i.TAG, "run on hijack runnable");
                i.this.mHijackDismissAction.run();
                AppMethodBeat.o(141873);
            } catch (Exception e2) {
                Log.e(i.TAG, "protect : " + e2.getMessage());
                AppMethodBeat.o(141873);
            }
        }
    };

    public i(Context context) {
        super(context);
        AppMethodBeat.i(141874);
        hijackDismissAction();
        AppMethodBeat.o(141874);
    }

    public i(Context context, int i2) {
        super(context, i2);
        AppMethodBeat.i(141875);
        hijackDismissAction();
        AppMethodBeat.o(141875);
    }

    public void dismiss() {
        AppMethodBeat.i(141876);
        try {
            super.dismiss();
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
        if (this.iOnDialogDismissListener != null) {
            this.iOnDialogDismissListener.onDialogDismiss(this);
        }
        AppMethodBeat.o(141876);
    }

    public void show() {
        AppMethodBeat.i(141877);
        try {
            super.show();
            AppMethodBeat.o(141877);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(141877);
        }
    }

    public void setiOnDialogDismissListener(c cVar) {
        this.iOnDialogDismissListener = cVar;
    }

    private void hijackDismissAction() {
        AppMethodBeat.i(141878);
        if (Build.VERSION.SDK_INT > 28) {
            AppMethodBeat.o(141878);
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
            AppMethodBeat.o(141878);
        } catch (NoSuchFieldException e3) {
            Log.e(TAG, "hijack fail NoSuchFieldException");
            AppMethodBeat.o(141878);
        } catch (IllegalAccessException e4) {
            Log.e(TAG, "hijack fail IllegalAccessException");
            AppMethodBeat.o(141878);
        }
    }
}
