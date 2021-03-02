package com.tencent.kinda.framework.widget.tools;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.tencent.kinda.framework.widget.base.BaseFrActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.f;

public class KindaWcKeyboardHelpr {
    private static String TAG = "MicroMsg.KindaWcKeyboardHelper";

    public static WcPayKeyboard bind(final UIPageFragmentActivity uIPageFragmentActivity, final EditText editText, String str, final BaseFrActivity.IWalletTenpayKBStateCallBackListener iWalletTenpayKBStateCallBackListener) {
        final WcPayKeyboard wcPayKeyboard;
        AppMethodBeat.i(214574);
        WcPayKeyboard wcPayKeyboard2 = (WcPayKeyboard) uIPageFragmentActivity.hgv.getCurrent().findViewById(R.id.jjh);
        if (wcPayKeyboard2 != null) {
            Log.i(TAG, "has exist keyboard");
            wcPayKeyboard = wcPayKeyboard2;
        } else {
            wcPayKeyboard = new WcPayKeyboard(uIPageFragmentActivity);
            wcPayKeyboard.setId(R.id.jjh);
            FrameLayout frameLayout = (FrameLayout) uIPageFragmentActivity.hgv.getCurrent().findViewById(R.id.be7);
            if (frameLayout == null) {
                Log.w(TAG, "can not find content layout");
                AppMethodBeat.o(214574);
                return null;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            frameLayout.addView(wcPayKeyboard, layoutParams);
            wcPayKeyboard.setVisibility(8);
        }
        if (!Util.isNullOrNil(str)) {
            wcPayKeyboard.setActionText(str);
        }
        f.setNoSystemInputOnEditText(editText);
        final View.OnFocusChangeListener onFocusChangeListener = editText.getOnFocusChangeListener();
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener(wcPayKeyboard) {
            /* class com.tencent.kinda.framework.widget.tools.KindaWcKeyboardHelpr.AnonymousClass1 */
            private boolean firstTime = true;
            final /* synthetic */ WcPayKeyboard val$finalKeyboard;

            {
                this.val$finalKeyboard = r3;
            }

            public final void onFocusChange(final View view, boolean z) {
                AppMethodBeat.i(214573);
                if (z) {
                    ((InputMethodManager) uIPageFragmentActivity.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                    new MMHandler().postDelayed(new Runnable() {
                        /* class com.tencent.kinda.framework.widget.tools.KindaWcKeyboardHelpr.AnonymousClass1.AnonymousClass1 */

                        public void run() {
                            AppMethodBeat.i(214571);
                            if (!AnonymousClass1.this.val$finalKeyboard.isShown() && view.isShown()) {
                                AnonymousClass1.this.val$finalKeyboard.showNormalStWcKb();
                                iWalletTenpayKBStateCallBackListener.onCallBackKinda(true, 0.0f);
                                AnonymousClass1.this.firstTime = false;
                            }
                            AnonymousClass1.this.val$finalKeyboard.setInputEditText(editText);
                            ((InputMethodManager) uIPageFragmentActivity.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                            AppMethodBeat.o(214571);
                        }
                    }, 200);
                } else {
                    new MMHandler().postDelayed(new Runnable() {
                        /* class com.tencent.kinda.framework.widget.tools.KindaWcKeyboardHelpr.AnonymousClass1.AnonymousClass2 */

                        public void run() {
                            AppMethodBeat.i(214572);
                            wcPayKeyboard.hideWcKb();
                            iWalletTenpayKBStateCallBackListener.onCallBackKinda(false, 0.0f);
                            AppMethodBeat.o(214572);
                        }
                    }, 200);
                }
                if (onFocusChangeListener != null) {
                    onFocusChangeListener.onFocusChange(view, z);
                }
                AppMethodBeat.o(214573);
            }
        });
        AppMethodBeat.o(214574);
        return wcPayKeyboard;
    }
}
