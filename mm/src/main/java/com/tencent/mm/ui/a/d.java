package com.tencent.mm.ui.a;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.a.a;

@TargetApi(14)
public final class d extends View.AccessibilityDelegate {
    private boolean OLZ;

    public d() {
        AppMethodBeat.i(141503);
        this.OLZ = false;
        this.OLZ = a.C2075a.OLX.gKd();
        AppMethodBeat.o(141503);
    }

    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        return null;
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
    }

    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
    }

    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
    }

    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return true;
    }

    public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
        return true;
    }

    public final void sendAccessibilityEvent(View view, int i2) {
        CharSequence contentDescription;
        AppMethodBeat.i(141504);
        if (!this.OLZ) {
            if (view != null && (i2 == 128 || i2 == 1)) {
                a.C2075a.OLX.gs(view);
            }
            AppMethodBeat.o(141504);
            return;
        }
        if (view != null && (i2 == 128 || i2 == 1)) {
            if (view instanceof EditText) {
                EditText editText = (EditText) view;
                contentDescription = !Util.isNullOrNil(editText.getText()) ? editText.getText() : !Util.isNullOrNil(editText.getContentDescription()) ? editText.getContentDescription() : editText.getHint() != null ? editText.getHint() : null;
            } else if (view instanceof TextView) {
                contentDescription = Util.isNullOrNil(view.getContentDescription()) ? ((TextView) view).getText() : view.getContentDescription();
            } else {
                contentDescription = view.getContentDescription();
            }
            Log.d("MicroMsg.MMSecureAccessibilityDelegate", "speak content: %s", contentDescription);
            if (Util.isNullOrNil(contentDescription)) {
                AppMethodBeat.o(141504);
                return;
            }
            a.C2075a.OLX.g(view, contentDescription.toString());
        }
        AppMethodBeat.o(141504);
    }

    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
    }
}
