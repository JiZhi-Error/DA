package com.tencent.kinda.framework.app;

import com.tencent.kinda.framework.widget.PlatformWrapLayout;
import com.tencent.kinda.framework.widget.base.BaseFragment;
import com.tencent.kinda.framework.widget.base.MMKViewLayout;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.gen.IUIPage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;

public class MainFragment extends BaseFragment {
    public static final String TAG = "MicroMsg.MainFragment";
    private IUIPage page;
    private MMKViewLayout root;

    public void attachPage(IUIPage iUIPage) {
        this.page = iUIPage;
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFragment, com.tencent.mm.ui.MMFragment
    public int getLayoutId() {
        return R.layout.axy;
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFragment
    public void initPagePlatformDelegate() {
        AppMethodBeat.i(214428);
        super.initPagePlatformDelegate();
        if (this.page != null) {
            this.page.setPlatformFuncDelegate(this.pagePlatformFuncDelegate);
            this.page.setPlatformDelegate(this.pagePlatformDelegate);
        }
        AppMethodBeat.o(214428);
    }

    private void initPage() {
        AppMethodBeat.i(18531);
        if (this.page != null) {
            this.page.setPlatformFuncDelegate(this.pagePlatformFuncDelegate);
            this.page.setPlatformDelegate(this.pagePlatformDelegate);
            covertPlatformData(getActivity().getIntent().getBundleExtra("key_platform_data"));
            initWithNavigationBarConfig(this.page.defaultNavigationBarConfig());
            if (this.page.fullPageMode() && getController().mActionBar != null) {
                Log.i(TAG, "UIPage is fullPageMode, so hide Actionbar.");
                getController().mActionBar.hide();
            }
            Log.i(TAG, "finish init page");
        }
        AppMethodBeat.o(18531);
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFragment
    public void willActive() {
        AppMethodBeat.i(18532);
        super.willActive();
        if (this.page != null) {
            this.page.onVisible();
        }
        if (getSwipeBackLayout() != null) {
            getSwipeBackLayout().setEnableGesture(false);
        }
        AppMethodBeat.o(18532);
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFragment
    public void willDeActive() {
        AppMethodBeat.i(18533);
        super.willDeActive();
        if (this.page != null) {
            this.page.onInvisible();
        }
        AppMethodBeat.o(18533);
    }

    @Override // com.tencent.kinda.framework.widget.base.LifecycleFragment, android.support.v4.app.Fragment, com.tencent.kinda.framework.widget.base.BaseFragment, com.tencent.mm.ui.MMFragment
    public void onResume() {
        AppMethodBeat.i(18534);
        super.onResume();
        AppMethodBeat.o(18534);
    }

    @Override // com.tencent.kinda.framework.widget.base.LifecycleFragment, android.support.v4.app.Fragment, com.tencent.kinda.framework.widget.base.BaseFragment, com.tencent.mm.ui.MMFragment
    public void onPause() {
        AppMethodBeat.i(18535);
        super.onPause();
        AppMethodBeat.o(18535);
    }

    @Override // com.tencent.kinda.framework.widget.base.LifecycleFragment, com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.kinda.framework.widget.base.BaseFragment, com.tencent.mm.ui.MMFragment
    public void onDestroy() {
        AppMethodBeat.i(18536);
        super.onDestroy();
        if (this.page != null) {
            this.page.onBack();
            this.page.onDestroy();
        }
        this.page = null;
        AppMethodBeat.o(18536);
    }

    @Override // com.tencent.kinda.framework.widget.base.LifecycleFragment, com.tencent.kinda.framework.widget.base.FragmentLifecycle, com.tencent.kinda.framework.widget.base.BaseFragment
    public void onFragmentOnResume() {
        AppMethodBeat.i(178762);
        super.onFragmentOnResume();
        setSystemUIByFullMode();
        AppMethodBeat.o(178762);
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFragment
    public void initOnCreate() {
        AppMethodBeat.i(18537);
        initPage();
        if (this.page != null) {
            this.page.onCreate();
            initPageView();
        }
        AppMethodBeat.o(18537);
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFragment
    public void onCreateLayout(PlatformWrapLayout platformWrapLayout) {
        AppMethodBeat.i(18538);
        this.root = platformWrapLayout;
        this.page.onCreateLayout(platformWrapLayout);
        AppMethodBeat.o(18538);
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFragment
    public String getTagName() {
        return TAG;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        AppMethodBeat.i(18539);
        super.finalize();
        Log.i(TAG, "finalize " + this.page);
        AppMethodBeat.o(18539);
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFragment
    public void onKeyboardShow(boolean z, int i2) {
        AppMethodBeat.i(214429);
        if (this.pagePlatformFuncDelegate != null) {
            this.pagePlatformFuncDelegate.onKeyboardShow(z, i2);
        }
        AppMethodBeat.o(214429);
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFragment
    public boolean onBackPressed() {
        AppMethodBeat.i(18541);
        if (this.page != null) {
            this.page.onClickAndroidBack();
            AppMethodBeat.o(18541);
            return true;
        }
        AppMethodBeat.o(18541);
        return false;
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFragment
    public void setTopRightBtnImage(String str) {
        AppMethodBeat.i(18542);
        this.pagePlatformFuncDelegate.setTopRightBtnImage(str);
        AppMethodBeat.o(18542);
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFragment
    public void setTopRightBtnTitle(String str, String str2) {
        AppMethodBeat.i(18543);
        this.pagePlatformFuncDelegate.setTopRightBtnTitle(str, str2);
        AppMethodBeat.o(18543);
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFragment
    public int getIUIHashCode() {
        AppMethodBeat.i(18544);
        if (this.page != null) {
            int hashCode = this.page.hashCode();
            AppMethodBeat.o(18544);
            return hashCode;
        }
        AppMethodBeat.o(18544);
        return 0;
    }

    private void setSystemUIByFullMode() {
        AppMethodBeat.i(178763);
        setActionBarColor((int) ColorUtil.getColorByMode(this.page.defaultNavigationBarConfig().mBackgroundColor));
        AppMethodBeat.o(178763);
    }
}
