package com.tencent.kinda.framework.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.View;
import com.tencent.kinda.framework.widget.base.BaseFragment;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.framework.widget.tools.ResourcesUtils;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.IUIPagePlatformFuncDelegate;
import com.tencent.kinda.gen.VoidBoolI32Callback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.h;
import com.tencent.tinker.loader.shareutil.ShareConstants;

public class UIPagePlatformFuncDelegateImpl implements IUIPagePlatformFuncDelegate {
    private static final String TAG = "UIPagePlatformFuncDelegateImpl";
    private MMFragment activity;
    private Dialog mTipDialog = null;
    private String mmTitle = "";
    private VoidBoolI32Callback onKeyboardShowCallback;
    private VoidCallback topLeftBtnCallback;
    private VoidCallback topRightBtnCallback;
    private String topRightBtnColor;
    private int topRightBtnResId = -1;
    private String topRightBtnTitle;

    public UIPagePlatformFuncDelegateImpl(MMActivity mMActivity) {
    }

    public UIPagePlatformFuncDelegateImpl(MMFragment mMFragment) {
        this.activity = mMFragment;
    }

    @Override // com.tencent.kinda.gen.IUIPagePlatformFuncDelegate
    public void setTitle(String str) {
        AppMethodBeat.i(18595);
        this.activity.setMMTitle(str);
        this.mmTitle = str;
        AppMethodBeat.o(18595);
    }

    @Override // com.tencent.kinda.gen.IUIPagePlatformFuncDelegate
    public String getTitle() {
        AppMethodBeat.i(18596);
        String sb = new StringBuilder().append((Object) this.activity.getMMTitle()).toString();
        AppMethodBeat.o(18596);
        return sb;
    }

    @Override // com.tencent.kinda.gen.IUIPagePlatformFuncDelegate
    public void closeUI(boolean z) {
        AppMethodBeat.i(214434);
        if (this.activity instanceof BaseFragment) {
            BaseFragment baseFragment = (BaseFragment) this.activity;
            if (baseFragment.isTinyApp && baseFragment.tinyAppUserName != null) {
                ((r) g.af(r.class)).ej(baseFragment.tinyAppUserName, "");
            }
            baseFragment.popFragment();
        }
        AppMethodBeat.o(214434);
    }

    @Override // com.tencent.kinda.gen.IUIPagePlatformFuncDelegate
    public void setKeyBoardShowCallbackImpl(VoidBoolI32Callback voidBoolI32Callback) {
        this.onKeyboardShowCallback = voidBoolI32Callback;
    }

    @Override // com.tencent.kinda.gen.IUIPagePlatformFuncDelegate
    public void beginIgnoringInteractionEvents() {
        AppMethodBeat.i(18598);
        this.activity.getWindow().addFlags(16);
        AppMethodBeat.o(18598);
    }

    @Override // com.tencent.kinda.gen.IUIPagePlatformFuncDelegate
    public void endIgnoringInteractionEvents() {
        AppMethodBeat.i(18599);
        new MMHandler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.tencent.kinda.framework.app.UIPagePlatformFuncDelegateImpl.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(18591);
                UIPagePlatformFuncDelegateImpl.this.activity.getWindow().clearFlags(16);
                AppMethodBeat.o(18591);
            }
        });
        AppMethodBeat.o(18599);
    }

    @Override // com.tencent.kinda.gen.IUIPagePlatformFuncDelegate
    public void setTopLeftBackBtnCallbackImpl(final VoidCallback voidCallback) {
        AppMethodBeat.i(18600);
        this.topLeftBtnCallback = voidCallback;
        this.activity.setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.kinda.framework.app.UIPagePlatformFuncDelegateImpl.AnonymousClass2 */

            public boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(18592);
                if (voidCallback != null) {
                    voidCallback.call();
                    AppMethodBeat.o(18592);
                    return true;
                }
                AppMethodBeat.o(18592);
                return false;
            }
        });
        AppMethodBeat.o(18600);
    }

    @Override // com.tencent.kinda.gen.IUIPagePlatformFuncDelegate
    public void setTopRightCallbackImpl(VoidCallback voidCallback) {
        AppMethodBeat.i(18601);
        this.topRightBtnCallback = voidCallback;
        recreateTopRightBtn();
        AppMethodBeat.o(18601);
    }

    @Override // com.tencent.kinda.gen.IUIPagePlatformFuncDelegate
    public void setTopRightBtnImage(String str) {
        AppMethodBeat.i(18602);
        if (!Util.isNullOrNil(str)) {
            this.topRightBtnResId = ResourcesUtils.getDrawableId(this.activity.getContext(), str);
            if (this.topRightBtnResId <= 0) {
                this.topRightBtnResId = ResourcesUtils.getResId(this.activity.getContext(), str, ShareConstants.DEXMODE_RAW);
            }
            recreateTopRightBtn();
        }
        AppMethodBeat.o(18602);
    }

    @Override // com.tencent.kinda.gen.IUIPagePlatformFuncDelegate
    public void setTopRightBtnTitle(String str, String str2) {
        this.topRightBtnTitle = str;
        this.topRightBtnColor = str2;
    }

    @Override // com.tencent.kinda.gen.IUIPagePlatformFuncDelegate
    public void refreshNavigationBar() {
    }

    private void recreateTopRightBtn() {
        AppMethodBeat.i(18603);
        this.activity.removeAllOptionMenu();
        Drawable drawable = null;
        if (this.topRightBtnResId > 0 && (drawable = this.activity.getResources().getDrawable(this.topRightBtnResId)) != null && !Util.isNullOrNil(this.topRightBtnColor)) {
            try {
                drawable.setColorFilter(Color.parseColor(this.topRightBtnColor), PorterDuff.Mode.SRC_ATOP);
            } catch (Exception e2) {
            }
        }
        this.activity.addIconOptionMenu(1, this.topRightBtnTitle, drawable, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.kinda.framework.app.UIPagePlatformFuncDelegateImpl.AnonymousClass3 */

            public boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(18593);
                if (UIPagePlatformFuncDelegateImpl.this.topRightBtnCallback != null) {
                    UIPagePlatformFuncDelegateImpl.this.topRightBtnCallback.call();
                    AppMethodBeat.o(18593);
                    return true;
                }
                AppMethodBeat.o(18593);
                return false;
            }
        });
        AppMethodBeat.o(18603);
    }

    public void reset() {
        AppMethodBeat.i(18604);
        this.activity.setMMNormalView();
        if (!Util.isNullOrNil(this.mmTitle)) {
            this.activity.setMMTitle(this.mmTitle);
        }
        recreateTopRightBtn();
        if (this.topLeftBtnCallback != null) {
            setTopLeftBackBtnCallbackImpl(this.topLeftBtnCallback);
        }
        AppMethodBeat.o(18604);
    }

    @Override // com.tencent.kinda.gen.IUIPagePlatformFuncDelegate
    public void endEditing() {
        AppMethodBeat.i(18605);
        this.activity.hideVKB();
        if (this.activity.getActivity() != null) {
            View kBLayout = getKBLayout(this.activity.getActivity());
            if (kBLayout != null && kBLayout.isShown()) {
                kBLayout.setVisibility(8);
            }
            WcPayKeyboard wcPayKeyboard = getWcPayKeyboard(this.activity.getActivity());
            if (wcPayKeyboard != null) {
                wcPayKeyboard.hideWcKb();
                if (wcPayKeyboard.mInputEditText != null) {
                    wcPayKeyboard.mInputEditText.clearFocus();
                }
            }
        }
        AppMethodBeat.o(18605);
    }

    /* access modifiers changed from: protected */
    public View getKBLayout(FragmentActivity fragmentActivity) {
        AppMethodBeat.i(214435);
        int size = fragmentActivity.getSupportFragmentManager().getFragments().size();
        if (size <= 0) {
            View findViewById = fragmentActivity.findViewById(R.id.ija);
            AppMethodBeat.o(214435);
            return findViewById;
        }
        View findViewById2 = ((BaseFragment) fragmentActivity.getSupportFragmentManager().getFragments().get(size - 1)).findViewById(R.id.ija);
        AppMethodBeat.o(214435);
        return findViewById2;
    }

    /* access modifiers changed from: protected */
    public WcPayKeyboard getWcPayKeyboard(FragmentActivity fragmentActivity) {
        AppMethodBeat.i(214436);
        int size = fragmentActivity.getSupportFragmentManager().getFragments().size();
        if (size <= 0) {
            WcPayKeyboard wcPayKeyboard = (WcPayKeyboard) fragmentActivity.findViewById(R.id.jjh);
            AppMethodBeat.o(214436);
            return wcPayKeyboard;
        }
        WcPayKeyboard wcPayKeyboard2 = (WcPayKeyboard) ((BaseFragment) fragmentActivity.getSupportFragmentManager().getFragments().get(size - 1)).findViewById(R.id.jjh);
        AppMethodBeat.o(214436);
        return wcPayKeyboard2;
    }

    public void onKeyboardShow(boolean z, int i2) {
        AppMethodBeat.i(214437);
        if (this.onKeyboardShowCallback != null) {
            this.onKeyboardShowCallback.call(z, i2);
        }
        AppMethodBeat.o(214437);
    }

    @Override // com.tencent.kinda.gen.IUIPagePlatformFuncDelegate
    public void setBackgroundColor(DynamicColor dynamicColor) {
    }

    @Override // com.tencent.kinda.gen.IUIPagePlatformFuncDelegate
    public void startLoading(String str, boolean z) {
        AppMethodBeat.i(18607);
        if (this.mTipDialog != null) {
            this.mTipDialog.show();
            AppMethodBeat.o(18607);
            return;
        }
        Activity topOrUIPageFragmentActivity = KindaContext.getTopOrUIPageFragmentActivity();
        if (topOrUIPageFragmentActivity == null) {
            Log.e(TAG, "IUIPagePlatformFuncDelegate can't startLoading because the activity is null!");
            AppMethodBeat.o(18607);
            return;
        }
        this.mTipDialog = h.c(topOrUIPageFragmentActivity, topOrUIPageFragmentActivity.getString(R.string.inu), true, new DialogInterface.OnCancelListener() {
            /* class com.tencent.kinda.framework.app.UIPagePlatformFuncDelegateImpl.AnonymousClass4 */

            public void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(18594);
                if (UIPagePlatformFuncDelegateImpl.this.mTipDialog != null && UIPagePlatformFuncDelegateImpl.this.mTipDialog.isShowing()) {
                    UIPagePlatformFuncDelegateImpl.this.mTipDialog.dismiss();
                }
                AppMethodBeat.o(18594);
            }
        });
        this.mTipDialog.setCancelable(false);
        AppMethodBeat.o(18607);
    }

    @Override // com.tencent.kinda.gen.IUIPagePlatformFuncDelegate
    public void stopLoading() {
        AppMethodBeat.i(18608);
        if (this.mTipDialog != null && this.mTipDialog.isShowing()) {
            this.mTipDialog.dismiss();
        }
        AppMethodBeat.o(18608);
    }

    @Override // com.tencent.kinda.gen.IUIPagePlatformFuncDelegate
    public void setWindowAdjustUnspecified(boolean z) {
        AppMethodBeat.i(214438);
        if (this.activity.getActivity().getWindow() != null) {
            if (z) {
                this.activity.getActivity().getWindow().setSoftInputMode(19);
                AppMethodBeat.o(214438);
                return;
            }
            this.activity.getActivity().getWindow().setSoftInputMode(35);
        }
        AppMethodBeat.o(214438);
    }
}
