package com.tencent.mm.ui.a;

import android.annotation.TargetApi;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.a.a;

@TargetApi(14)
public final class c extends View.AccessibilityDelegate {
    private boolean OLZ;

    public c() {
        AppMethodBeat.i(205155);
        this.OLZ = false;
        this.OLZ = a.C2075a.OLX.gKd();
        AppMethodBeat.o(205155);
    }

    public final void sendAccessibilityEvent(View view, int i2) {
        CharSequence contentDescription;
        AppMethodBeat.i(205156);
        Log.i("MicroMsg.MMSecureAccessibilityAndroidRDelegate", "sendAccessibilityEventt: eventType:%s, trace: %s", Integer.valueOf(i2), android.util.Log.getStackTraceString(new Throwable()));
        if (i2 == 32768) {
            super.sendAccessibilityEvent(view, i2);
            AppMethodBeat.o(205156);
        } else if (!this.OLZ) {
            if (view != null && (i2 == 128 || i2 == 1)) {
                a.C2075a.OLX.gs(view);
            }
            AppMethodBeat.o(205156);
        } else {
            if (view != null && (i2 == 128 || i2 == 1)) {
                if (view instanceof EditText) {
                    EditText editText = (EditText) view;
                    contentDescription = !Util.isNullOrNil(editText.getText()) ? editText.getText() : !Util.isNullOrNil(editText.getContentDescription()) ? editText.getContentDescription() : editText.getHint() != null ? editText.getHint() : null;
                } else if (view instanceof TextView) {
                    contentDescription = Util.isNullOrNil(view.getContentDescription()) ? ((TextView) view).getText() : view.getContentDescription();
                } else {
                    contentDescription = view.getContentDescription();
                }
                Log.d("MicroMsg.MMSecureAccessibilityAndroidRDelegate", "speak content: %s", contentDescription);
                if (Util.isNullOrNil(contentDescription)) {
                    AppMethodBeat.o(205156);
                    return;
                }
                a.C2075a.OLX.g(view, contentDescription.toString());
            }
            AppMethodBeat.o(205156);
        }
    }
}
