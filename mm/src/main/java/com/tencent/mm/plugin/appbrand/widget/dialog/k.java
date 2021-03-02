package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.DialogInterface;
import android.view.View;

public interface k extends DialogInterface {

    public interface a extends DialogInterface, k {
        void setCancelable(boolean z);

        void setCanceledOnTouchOutside(boolean z);

        void setMessage(CharSequence charSequence);

        void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener);

        void setTitle(CharSequence charSequence);
    }

    void a(m mVar);

    boolean bjb();

    boolean bjc();

    View getContentView();

    int getPosition();

    boolean isCancelable();

    void onCancel();

    void ut(int i2);
}
