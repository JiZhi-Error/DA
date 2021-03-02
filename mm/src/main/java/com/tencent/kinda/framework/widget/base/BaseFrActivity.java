package com.tencent.kinda.framework.widget.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.facebook.yoga.android.YogaLayout;
import com.tencent.kinda.framework.widget.tools.ActivityController;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.a.a;
import com.tencent.mm.ui.a.c;
import com.tencent.mm.ui.a.d;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.TenpaySecureEditText;

public abstract class BaseFrActivity extends MMActivity {
    public static final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = a.fromDPToPix(MMApplicationContext.getContext(), 270);
    public static final String TAG = "MicroMsg.BaseFrActivity";
    private final int PWD_INPUT_VIEW_AND_KEYBOARD_GAP_PX = 26;
    private boolean isDestroyByThisFinish = false;
    protected boolean isVKBFirstTimeShown = false;
    public IWalletTenpayKBStateCallBackListener mTenpayKBStateCallBackListener;
    private com.tencent.mm.wallet_core.ui.a mTenpayKBStateListener;
    private View m_scrollViewBecouseOfKeyBoard = null;

    public interface IWalletTenpayKBStateCallBackListener {
        void onCallBackKinda(boolean z, float f2);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        Log.i(TAG, "onCreate");
        super.onCreate(bundle);
        ActivityController.attach(this);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity
    public View findViewById(int i2) {
        return super.findViewById(i2);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        if (!this.isDestroyByThisFinish) {
            ActivityController.detach(this);
        }
        super.onDestroy();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        super.finish();
        this.isDestroyByThisFinish = true;
        ActivityController.detach(this);
        Log.i(TAG, "BaseFrActivity finish exec! " + android.util.Log.getStackTraceString(new Throwable("the stack of finish: ")));
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        ActivityController.attach(this);
    }

    public void setEditFocusListener(View view, int i2, boolean z) {
        setEditFocusListener(view, i2, z, true);
    }

    /* access modifiers changed from: protected */
    public MyKeyboardWindow getKeyboard() {
        int size = getSupportFragmentManager().getFragments().size();
        if (size <= 0) {
            return (MyKeyboardWindow) findViewById(R.id.ijb);
        }
        return (MyKeyboardWindow) ((BaseFragment) getSupportFragmentManager().getFragments().get(size - 1)).findViewById(R.id.ijb);
    }

    /* access modifiers changed from: protected */
    public View getKBLayout() {
        int size = getSupportFragmentManager().getFragments().size();
        if (size <= 0) {
            return findViewById(R.id.ija);
        }
        return ((BaseFragment) getSupportFragmentManager().getFragments().get(size - 1)).findViewById(R.id.ija);
    }

    /* access modifiers changed from: protected */
    public LinearLayout getMainContainer() {
        int size = getSupportFragmentManager().getFragments().size();
        if (size <= 0) {
            return null;
        }
        return (LinearLayout) ((BaseFragment) getSupportFragmentManager().getFragments().get(size - 1)).findViewById(R.id.be3);
    }

    /* access modifiers changed from: protected */
    public TenpaySecureEditText getTenpaySecureEditText() {
        View findViewById;
        int size = getSupportFragmentManager().getFragments().size();
        if (size <= 0) {
            findViewById = findViewById(R.id.jf4);
        } else {
            findViewById = ((BaseFragment) getSupportFragmentManager().getFragments().get(size - 1)).findViewById(R.id.jf4);
        }
        if (findViewById instanceof TenpaySecureEditText) {
            return (TenpaySecureEditText) findViewById;
        }
        return null;
    }

    @TargetApi(14)
    public void setEditFocusListener(final View view, final int i2, final boolean z, final boolean z2) {
        final MyKeyboardWindow keyboard = getKeyboard();
        final View kBLayout = getKBLayout();
        if (keyboard != null && kBLayout != null) {
            View findViewById = kBLayout.findViewById(R.id.ijc);
            final EditText editText = view instanceof TenpaySecureEditText ? (EditText) view : (EditText) view.findViewById(R.id.jf4);
            if (editText != null) {
                f.setNoSystemInputOnEditText(editText);
                editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    /* class com.tencent.kinda.framework.widget.base.BaseFrActivity.AnonymousClass1 */

                    public void onFocusChange(final View view, boolean z) {
                        AppMethodBeat.i(18758);
                        if (!view.isFocused() || z) {
                            new MMHandler().postDelayed(new Runnable() {
                                /* class com.tencent.kinda.framework.widget.base.BaseFrActivity.AnonymousClass1.AnonymousClass2 */

                                public void run() {
                                    AppMethodBeat.i(18757);
                                    BaseFrActivity.this.hideTenpayKB();
                                    if (BaseFrActivity.this.m_scrollViewBecouseOfKeyBoard != null) {
                                        BaseFrActivity.this.m_scrollViewBecouseOfKeyBoard.scrollTo(0, 0);
                                        BaseFrActivity.this.m_scrollViewBecouseOfKeyBoard = null;
                                    }
                                    if (z) {
                                        ((InputMethodManager) BaseFrActivity.this.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
                                    }
                                    AppMethodBeat.o(18757);
                                }
                            }, 200);
                        } else {
                            ((InputMethodManager) BaseFrActivity.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                            new MMHandler().postDelayed(new Runnable() {
                                /* class com.tencent.kinda.framework.widget.base.BaseFrActivity.AnonymousClass1.AnonymousClass1 */

                                public void run() {
                                    boolean z;
                                    AppMethodBeat.i(18756);
                                    if (!(kBLayout == BaseFrActivity.this.getKBLayout())) {
                                        AppMethodBeat.o(18756);
                                        return;
                                    }
                                    if (!kBLayout.isShown() && view.getVisibility() == 0 && (z2 || BaseFrActivity.this.isVKBFirstTimeShown)) {
                                        BaseFrActivity.this.isVKBFirstTimeShown = true;
                                        BaseFrActivity.this.showTenpayKB();
                                    }
                                    if ((view instanceof WalletFormView) && Build.VERSION.SDK_INT >= 14) {
                                        WalletFormView walletFormView = (WalletFormView) view;
                                        if ((z.aUo() || walletFormView.getEncrptType() == 100) && (!z.aUo() || walletFormView.getEncrptType() == 0)) {
                                            keyboard.resetSecureAccessibility();
                                            editText.setAccessibilityDelegate(null);
                                        } else {
                                            d dVar = new d();
                                            keyboard.setSecureAccessibility(dVar);
                                            editText.setAccessibilityDelegate(dVar);
                                        }
                                    }
                                    if ((view instanceof EditHintPasswdView) && Build.VERSION.SDK_INT >= 14) {
                                        d dVar2 = new d();
                                        keyboard.setSecureAccessibility(dVar2);
                                        editText.setAccessibilityDelegate(dVar2);
                                        if (((b) g.af(b.class)).a(b.a.clicfg_accessibility_strategy_android_r, 1) == 1) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (z && com.tencent.mm.compatible.util.d.oD(30) && a.C2075a.OLX.gKc()) {
                                            h.INSTANCE.dN(1624, 11);
                                            keyboard.setSecureAccessibility(new c());
                                        }
                                    }
                                    keyboard.setXMode(i2);
                                    keyboard.setInputEditText((EditText) view);
                                    ((InputMethodManager) BaseFrActivity.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                                    AppMethodBeat.o(18756);
                                }
                            }, 300);
                        }
                        if (view instanceof TenpaySecureEditText) {
                            TenpaySecureEditText tenpaySecureEditText = (TenpaySecureEditText) view;
                            if (tenpaySecureEditText.getTag() instanceof MMKEditText) {
                                MMKEditText mMKEditText = (MMKEditText) tenpaySecureEditText.getTag();
                                if (!tenpaySecureEditText.isFocused()) {
                                    mMKEditText.setVisibleClearIcon(false);
                                    mMKEditText.callBackKindaTextEndEditing();
                                    AppMethodBeat.o(18758);
                                    return;
                                }
                                if (BaseFrActivity.this.needToShowClearIcon(tenpaySecureEditText)) {
                                    mMKEditText.setVisibleClearIcon(true);
                                }
                                AppMethodBeat.o(18758);
                                return;
                            } else if (tenpaySecureEditText.getTag() instanceof KindaSecureEditTextImpl) {
                                if (!tenpaySecureEditText.isFocused()) {
                                    ((KindaSecureEditTextImpl) tenpaySecureEditText.getTag()).setVisibleClearIcon(false);
                                    AppMethodBeat.o(18758);
                                    return;
                                }
                                if (BaseFrActivity.this.needToShowClearIcon(tenpaySecureEditText)) {
                                    ((KindaSecureEditTextImpl) tenpaySecureEditText.getTag()).setVisibleClearIcon(true);
                                }
                                AppMethodBeat.o(18758);
                                return;
                            } else if (!tenpaySecureEditText.isFocused()) {
                                tenpaySecureEditText.setCompoundDrawables(tenpaySecureEditText.getCompoundDrawables()[0], tenpaySecureEditText.getCompoundDrawables()[1], null, tenpaySecureEditText.getCompoundDrawables()[3]);
                                AppMethodBeat.o(18758);
                                return;
                            } else if (BaseFrActivity.this.needToShowClearIcon(tenpaySecureEditText)) {
                                tenpaySecureEditText.setCompoundDrawables(tenpaySecureEditText.getCompoundDrawables()[0], tenpaySecureEditText.getCompoundDrawables()[1], tenpaySecureEditText.getClearBtnDrawable(), tenpaySecureEditText.getCompoundDrawables()[3]);
                            }
                        }
                        AppMethodBeat.o(18758);
                    }
                });
                editText.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.kinda.framework.widget.base.BaseFrActivity.AnonymousClass2 */
                    private byte _hellAccFlag_;

                    public void onClick(View view) {
                        AppMethodBeat.i(18759);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/kinda/framework/widget/base/BaseFrActivity$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (!kBLayout.isShown() && !z) {
                            BaseFrActivity.this.showTenpayKB();
                            keyboard.setXMode(i2);
                        } else if (z) {
                            BaseFrActivity.this.hideTenpayKB();
                            ((InputMethodManager) BaseFrActivity.this.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/kinda/framework/widget/base/BaseFrActivity$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(18759);
                    }
                });
                findViewById.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.kinda.framework.widget.base.BaseFrActivity.AnonymousClass3 */
                    private byte _hellAccFlag_;

                    public void onClick(View view) {
                        AppMethodBeat.i(18760);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/kinda/framework/widget/base/BaseFrActivity$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        BaseFrActivity.this.hideTenpayKB();
                        if (BaseFrActivity.this.m_scrollViewBecouseOfKeyBoard != null) {
                            BaseFrActivity.this.m_scrollViewBecouseOfKeyBoard.scrollTo(0, 0);
                            BaseFrActivity.this.m_scrollViewBecouseOfKeyBoard = null;
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/kinda/framework/widget/base/BaseFrActivity$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(18760);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: protected */
    public void scrollPwdInputViewOnTopOfKeyBoard(View view, int i2) {
        if (view instanceof TenpaySecureEditText) {
            if (i2 <= 0) {
                i2 = (int) ((getResources().getDisplayMetrics().density * 270.0f) + 0.5f);
            }
            int height = view.getHeight();
            int height2 = getController().GDE.getHeight();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i3 = iArr[1];
            int i4 = height2 - (i3 + height);
            if (i4 < i2) {
                int i5 = (i2 - i4) + 26;
                LinearLayout mainContainer = getMainContainer();
                if (mainContainer != null) {
                    View childAt = mainContainer.getChildAt(0);
                    YogaLayout yogaLayout = null;
                    if (childAt != null && (childAt instanceof YogaLayout)) {
                        yogaLayout = (YogaLayout) childAt;
                    }
                    while (yogaLayout != null && yogaLayout.getHeight() < i3 + height) {
                        childAt = yogaLayout.getChildAt(0);
                        if (childAt != null && (childAt instanceof YogaLayout)) {
                            yogaLayout = (YogaLayout) childAt;
                        }
                    }
                    if (childAt != null) {
                        childAt.scrollTo(0, i5);
                        this.m_scrollViewBecouseOfKeyBoard = childAt;
                    }
                }
            }
        }
    }

    public void setTenpayKBStateListener(com.tencent.mm.wallet_core.ui.a aVar) {
        this.mTenpayKBStateListener = aVar;
    }

    public void hideTenpayKB() {
        View kBLayout = getKBLayout();
        if (kBLayout != null && kBLayout.isShown()) {
            kBLayout.setVisibility(8);
            if (this.mTenpayKBStateListener != null) {
                this.mTenpayKBStateListener.onVisibleStateChange(false);
            }
            if (this.mTenpayKBStateCallBackListener != null) {
                this.mTenpayKBStateCallBackListener.onCallBackKinda(false, (float) kBLayout.getHeight());
            }
        }
    }

    public void showTenpayKB() {
        View kBLayout = getKBLayout();
        if (kBLayout != null && !kBLayout.isShown()) {
            kBLayout.setVisibility(0);
            if (this.mTenpayKBStateListener != null) {
                this.mTenpayKBStateListener.onVisibleStateChange(true);
            }
            if (this.mTenpayKBStateCallBackListener != null) {
                this.mTenpayKBStateCallBackListener.onCallBackKinda(true, (float) kBLayout.getHeight());
            }
        }
    }

    public void setTenpayKBStateCallBackListener(IWalletTenpayKBStateCallBackListener iWalletTenpayKBStateCallBackListener) {
        this.mTenpayKBStateCallBackListener = iWalletTenpayKBStateCallBackListener;
    }

    public void scrollToFormEditPosAfterShowTenPay(final View view, View view2, int i2) {
        if (view != null) {
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int height = iArr[1] + view2.getHeight();
            int jo = com.tencent.mm.cb.a.jo(getContext());
            int fromDPToPix = (jo - height) - com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), i2);
            Log.d(TAG, "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", Integer.valueOf(height), Integer.valueOf(jo), Integer.valueOf(fromDPToPix), Integer.valueOf(HARDCODE_TENPAY_KEYBOARD_HEIGHT));
            if (fromDPToPix > 0 && fromDPToPix < HARDCODE_TENPAY_KEYBOARD_HEIGHT) {
                final int i3 = HARDCODE_TENPAY_KEYBOARD_HEIGHT - fromDPToPix;
                Log.d(TAG, "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", Integer.valueOf(i3));
                view.post(new Runnable() {
                    /* class com.tencent.kinda.framework.widget.base.BaseFrActivity.AnonymousClass4 */

                    public void run() {
                        AppMethodBeat.i(18761);
                        view.scrollBy(0, i3);
                        AppMethodBeat.o(18761);
                    }
                });
            }
        }
    }

    public void scrollTo(View view, int i2, int i3) {
        if (view != null) {
            view.scrollTo(i2, i3);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.appbrand.widget.input.ad, com.tencent.mm.ui.MMFragmentActivity
    public void showVKB() {
        View currentFocus;
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null && (currentFocus = getCurrentFocus()) != null && currentFocus.getWindowToken() != null) {
            inputMethodManager.toggleSoftInput(0, 2);
        }
    }

    public boolean needToShowClearIcon(TenpaySecureEditText tenpaySecureEditText) {
        return (tenpaySecureEditText.getText().toString().equals("") || TenpaySecureEditText.EditState.PASSWORD == tenpaySecureEditText.getEditState() || TenpaySecureEditText.EditState.CVV_PAYMENT == tenpaySecureEditText.getEditState() || TenpaySecureEditText.EditState.CVV_4_PAYMENT == tenpaySecureEditText.getEditState()) ? false : true;
    }
}
