package com.tencent.kinda.framework.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.kinda.framework.widget.PlatformWrapLayout;
import com.tencent.kinda.framework.widget.base.BaseFragment;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.gen.IUIModal;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;

public class ModalFragment extends BaseFragment {
    public static final String TAG = "MicroMsg.ModalFragment";
    private Fragment mPreFragment;
    private View mViewCenterPadding;
    private IUIModal page;

    public void attachModal(IUIModal iUIModal) {
        this.page = iUIModal;
    }

    private void initPage() {
        AppMethodBeat.i(18545);
        if (this.page != null) {
            this.page.setPlatformDelegate(this.pagePlatformDelegate);
            covertPlatformData(getActivity().getIntent().getBundleExtra("key_platform_data"));
            Log.i(TAG, "finish init page");
        }
        AppMethodBeat.o(18545);
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFragment
    public void onCreateLayout(PlatformWrapLayout platformWrapLayout) {
        AppMethodBeat.i(18546);
        this.page.onCreateLayout(platformWrapLayout);
        AppMethodBeat.o(18546);
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFragment
    public void willActive() {
        AppMethodBeat.i(18547);
        super.willActive();
        AppMethodBeat.o(18547);
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFragment
    public void willDeActive() {
        AppMethodBeat.i(18548);
        super.willDeActive();
        AppMethodBeat.o(18548);
    }

    @Override // com.tencent.kinda.framework.widget.base.LifecycleFragment, com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.kinda.framework.widget.base.BaseFragment, com.tencent.mm.ui.MMFragment
    public void onDestroy() {
        AppMethodBeat.i(18549);
        super.onDestroy();
        this.page = null;
        AppMethodBeat.o(18549);
    }

    @Override // com.tencent.kinda.framework.widget.base.LifecycleFragment, android.support.v4.app.Fragment, com.tencent.kinda.framework.widget.base.BaseFragment, com.tencent.mm.ui.MMFragment
    public void onStart() {
        AppMethodBeat.i(18550);
        super.onStart();
        if (this.page != null && getIsEnterBackground()) {
            this.page.onModalEnterForeground();
            setIsEnterBackground(false);
        }
        AppMethodBeat.o(18550);
    }

    @Override // com.tencent.kinda.framework.widget.base.LifecycleFragment, android.support.v4.app.Fragment, com.tencent.kinda.framework.widget.base.BaseFragment, com.tencent.mm.ui.MMFragment
    public void onStop() {
        AppMethodBeat.i(18551);
        super.onStop();
        if (this.page != null && !getWillBeRemoved()) {
            this.page.onModalEnterBackground();
            setIsEnterBackground(true);
        }
        AppMethodBeat.o(18551);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.kinda.framework.widget.base.BaseFragment, com.tencent.mm.ui.MMFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(18552);
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (getContext() != null) {
            if (this.page.IsShowAndroidCenterPadding()) {
                initCenterPaddingView(onCreateView);
            }
            setupActionAndStatusBarColor();
        }
        AppMethodBeat.o(18552);
        return onCreateView;
    }

    private void setupActionAndStatusBarColor() {
        AppMethodBeat.i(178764);
        this.mPreFragment = getPrevFragment();
        if (this.mPreFragment == null) {
            int color = getContext().getResources().getColor(getBlackMaskColorRes());
            setActionBarColor(color);
            setCenterPaddingColor(color);
            AppMethodBeat.o(178764);
        } else if (this.mPreFragment instanceof ModalFragment) {
            int gIN = ((ModalFragment) this.mPreFragment).getController().gIN();
            setCenterPaddingColor(getContext().getResources().getColor(R.color.ac_));
            setActionBarColor(gIN);
            AppMethodBeat.o(178764);
        } else {
            if (this.mPreFragment instanceof MainFragment) {
                if (this.page == null || this.page.statusbarColor() == null || this.page.statusbarColor().mNormalColor <= 0) {
                    int gIN2 = ((MainFragment) this.mPreFragment).getController().gIN();
                    int color2 = getContext().getResources().getColor(getBlackMaskColorRes());
                    setActionBarColor((int) ColorUtil.MergeColors((long) gIN2, (long) color2));
                    setCenterPaddingColor(color2);
                } else {
                    setActionBarColor((int) ColorUtil.getColorByModeNoCompat(this.page.statusbarColor()));
                    AppMethodBeat.o(178764);
                    return;
                }
            }
            AppMethodBeat.o(178764);
        }
    }

    @Override // com.tencent.kinda.framework.widget.base.LifecycleFragment, com.tencent.kinda.framework.widget.base.FragmentLifecycle, com.tencent.kinda.framework.widget.base.BaseFragment
    public void onFragmentOnResume() {
        AppMethodBeat.i(178765);
        super.onFragmentOnResume();
        setupActionAndStatusBarColor();
        AppMethodBeat.o(178765);
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFragment
    public void initOnCreate() {
        AppMethodBeat.i(18553);
        getController().mActionBar.hide();
        initPage();
        if (this.page != null) {
            initPageView();
        }
        AppMethodBeat.o(18553);
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFragment
    public String getTagName() {
        return TAG;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        AppMethodBeat.i(18554);
        super.finalize();
        Log.i(TAG, "finalize " + this.page);
        AppMethodBeat.o(18554);
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFragment
    public void onKeyboardShow(boolean z, int i2) {
        AppMethodBeat.i(214430);
        if (this.pagePlatformFuncDelegate != null) {
            this.pagePlatformFuncDelegate.onKeyboardShow(z, i2);
        }
        AppMethodBeat.o(214430);
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFragment
    public boolean onBackPressed() {
        AppMethodBeat.i(18556);
        if (this.page != null) {
            this.page.onClickAndroidBack();
            AppMethodBeat.o(18556);
            return true;
        }
        AppMethodBeat.o(18556);
        return false;
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFragment
    public void restoreActionBarColor() {
        AppMethodBeat.i(18557);
        if (this.mPreFragment != null || !isFinishing()) {
            super.restoreActionBarColor();
        } else if (getContext() != null) {
            setActionBarColor(TPMediaCodecProfileLevel.HEVCMainTierLevel62);
            AppMethodBeat.o(18557);
            return;
        }
        AppMethodBeat.o(18557);
    }

    private void setCenterPaddingColor(int i2) {
        AppMethodBeat.i(18558);
        if (this.mViewCenterPadding != null) {
            this.mViewCenterPadding.setBackgroundColor(i2);
        }
        AppMethodBeat.o(18558);
    }

    private void initCenterPaddingView(View view) {
        AppMethodBeat.i(18559);
        if (view != null) {
            this.mViewCenterPadding = view.findViewById(R.id.j7f);
            int statusBarHeight = ao.getStatusBarHeight(getContext());
            this.mViewCenterPadding.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.mViewCenterPadding.getLayoutParams();
            layoutParams.height = statusBarHeight;
            this.mViewCenterPadding.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(18559);
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFragment
    public void setTopRightBtnImage(String str) {
        AppMethodBeat.i(18560);
        this.pagePlatformFuncDelegate.setTopRightBtnImage(str);
        AppMethodBeat.o(18560);
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFragment
    public void setTopRightBtnTitle(String str, String str2) {
        AppMethodBeat.i(18561);
        this.pagePlatformFuncDelegate.setTopRightBtnTitle(str, str2);
        AppMethodBeat.o(18561);
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFragment
    public int getIUIHashCode() {
        AppMethodBeat.i(18562);
        if (this.page != null) {
            int hashCode = this.page.hashCode();
            AppMethodBeat.o(18562);
            return hashCode;
        }
        AppMethodBeat.o(18562);
        return 0;
    }

    private int getBlackMaskColorRes() {
        AppMethodBeat.i(178766);
        if (ao.isDarkMode()) {
            AppMethodBeat.o(178766);
            return R.color.ado;
        }
        AppMethodBeat.o(178766);
        return R.color.adp;
    }
}
