package com.tenpay.android.wechat;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.bankcard.LogUtil;
import java.lang.reflect.Method;

public class TenpayAccessibilityDelegate extends View.AccessibilityDelegate {
    public void sendAccessibilityEvent(View view, int i2) {
        CharSequence charSequence;
        AppMethodBeat.i(130958);
        LogUtil.d("CFT", "sendAccessibilityEvent eventType=".concat(String.valueOf(i2)));
        if (view != null && i2 == 128) {
            if (view instanceof EditText) {
                LogUtil.d("CFT", "EditText");
                EditText editText = (EditText) view;
                if (!TextUtils.isEmpty(editText.getContentDescription())) {
                    charSequence = editText.getContentDescription();
                } else if (editText.getHint() != null) {
                    charSequence = editText.getHint();
                } else {
                    charSequence = null;
                }
                if (!TextUtils.isEmpty(charSequence)) {
                    for (int i3 = 0; i3 < charSequence.length(); i3++) {
                        TenpayTTSUtil.speak(String.valueOf(charSequence.charAt(i3)));
                    }
                }
            } else {
                LogUtil.d("CFT", "not EditText");
                charSequence = view.getContentDescription();
                TenpayTTSUtil.speak(charSequence);
            }
            LogUtil.d("CFT", "content = ".concat(String.valueOf(charSequence)));
            LogUtil.d("CFT", "host.getContentDescription() = " + ((Object) view.getContentDescription()));
            if (!TextUtils.isEmpty(charSequence)) {
                try {
                    Method method = View.class.getMethod("clearAccessibilityFocus", new Class[0]);
                    method.setAccessible(true);
                    method.invoke(view, new Object[0]);
                    Method method2 = View.class.getMethod("requestAccessibilityFocus", new Class[0]);
                    method2.setAccessible(true);
                    method2.invoke(view, new Object[0]);
                    AppMethodBeat.o(130958);
                    return;
                } catch (Exception e2) {
                }
            }
        }
        AppMethodBeat.o(130958);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        return null;
    }

    public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
        return false;
    }
}
