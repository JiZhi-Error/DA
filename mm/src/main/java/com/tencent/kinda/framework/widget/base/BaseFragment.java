package com.tencent.kinda.framework.widget.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.ActionBarContainer;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.facebook.yoga.android.YogaLayout;
import com.tencent.kinda.framework.animate.KindaAnimatorWatch;
import com.tencent.kinda.framework.app.UIPagePlatformFuncDelegateImpl;
import com.tencent.kinda.framework.widget.PlatformWrapLayout;
import com.tencent.kinda.framework.widget.base.FrLifeController;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.LeftBarButtonType;
import com.tencent.kinda.gen.NavigationBarConfig;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.b.b;
import com.tencent.mm.ui.v;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseFragment extends LifecycleFragment implements View.OnTouchListener, FragmentLifecycle {
    public static final String TAG = "MicroMsg.BaseFragment";
    protected IEventFragment fragEvent;
    private boolean isActive = false;
    private boolean isEnterBackground = false;
    public boolean isTinyApp = false;
    private FrLifeController.IFrLife life;
    private ActionBarContainer mActionBarContainer = null;
    private BaseFragment mCoveredFragment;
    public v mCustomActioinBarController = null;
    protected UIPagePlatformDelegateImpl pagePlatformDelegate;
    protected UIPagePlatformFuncDelegateImpl pagePlatformFuncDelegate;
    public String tinyAppUserName = "";
    private boolean willBeRemoved = false;

    public abstract int getIUIHashCode();

    public abstract String getTagName();

    /* access modifiers changed from: protected */
    public abstract void initOnCreate();

    public abstract boolean onBackPressed();

    /* access modifiers changed from: protected */
    public abstract void onCreateLayout(PlatformWrapLayout platformWrapLayout);

    public abstract void onKeyboardShow(boolean z, int i2);

    public abstract void setTopRightBtnImage(String str);

    public abstract void setTopRightBtnTitle(String str, String str2);

    @Override // com.tencent.kinda.framework.widget.base.LifecycleFragment, com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.kinda.framework.widget.base.LifecycleFragment, com.tencent.kinda.framework.widget.base.FragmentLifecycle
    public /* bridge */ /* synthetic */ void onFragmentOnCreate() {
        super.onFragmentOnCreate();
    }

    @Override // com.tencent.kinda.framework.widget.base.LifecycleFragment, com.tencent.kinda.framework.widget.base.FragmentLifecycle
    public /* bridge */ /* synthetic */ void onFragmentOnPause() {
        super.onFragmentOnPause();
    }

    @Override // com.tencent.kinda.framework.widget.base.LifecycleFragment, com.tencent.kinda.framework.widget.base.FragmentLifecycle
    public /* bridge */ /* synthetic */ void onFragmentOnResume() {
        super.onFragmentOnResume();
    }

    @Override // com.tencent.kinda.framework.widget.base.LifecycleFragment, com.tencent.kinda.framework.widget.base.FragmentLifecycle
    public /* bridge */ /* synthetic */ void onFragmentOnStart() {
        super.onFragmentOnStart();
    }

    @Override // com.tencent.kinda.framework.widget.base.LifecycleFragment, com.tencent.kinda.framework.widget.base.FragmentLifecycle
    public /* bridge */ /* synthetic */ void onFragmentOnStop() {
        super.onFragmentOnStop();
    }

    @Override // com.tencent.kinda.framework.widget.base.LifecycleFragment, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public /* bridge */ /* synthetic */ void onStart() {
        super.onStart();
    }

    @Override // com.tencent.kinda.framework.widget.base.LifecycleFragment, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public /* bridge */ /* synthetic */ void onStop() {
        super.onStop();
    }

    public void watchLife(FrLifeController.IFrLife iFrLife) {
        this.life = iFrLife;
    }

    @Override // com.tencent.mm.ui.MMFragment
    public void dealContentView(View view) {
        super.dealContentView(view);
        if (isSupportCustomActionBar()) {
            if (this.mActionBarContainer == null) {
                this.mActionBarContainer = (ActionBarContainer) ((ViewStub) view.findViewById(R.id.e6l)).inflate();
            }
            this.mCustomActioinBarController.OHt.WN = (ViewGroup) view;
        }
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (isSupportCustomActionBar()) {
            this.mCustomActioinBarController = new v();
            v vVar = this.mCustomActioinBarController;
            vVar.OHs = this;
            vVar.OHt = new b(thisActivity(), vVar);
            setActivityController(this.mCustomActioinBarController);
        }
    }

    public BaseFragment() {
        KindaAnimatorWatch.didObjCreated(hashCode());
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        Log.i(TAG, "onHiddenChanged %s", Boolean.valueOf(z));
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onCreate(Bundle bundle) {
        Log.d(TAG, "onCreate %s %s", getTagName(), this);
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        KindaActionBarColorManager.getInstance().pushActionBarColorItem(this, getController().gIN());
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.tencent.kinda.framework.widget.base.LifecycleFragment, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView %s %s", getTagName(), this);
        this.pagePlatformDelegate = null;
        this.pagePlatformFuncDelegate = null;
        restoreActionBarColor();
        if (this.life != null) {
            this.life.onDestroyView();
        }
        this.life = null;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setWillBeRemoved(boolean z) {
        this.willBeRemoved = z;
    }

    public boolean getWillBeRemoved() {
        return this.willBeRemoved;
    }

    public void setIsEnterBackground(boolean z) {
        this.isEnterBackground = z;
    }

    public boolean getIsEnterBackground() {
        return this.isEnterBackground;
    }

    public void willActive() {
        Log.d(TAG, "willActive %s %s", getTagName(), this);
        this.isActive = true;
    }

    public void recordCoveredFragment(BaseFragment baseFragment) {
        this.mCoveredFragment = baseFragment;
    }

    public BaseFragment getCoveredFragment() {
        return this.mCoveredFragment;
    }

    @Override // com.tencent.kinda.framework.widget.base.LifecycleFragment, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Log.d(TAG, "onViewCreated %s %s", getTagName(), this);
        this.pagePlatformDelegate = new UIPagePlatformDelegateImpl(getActivity());
        this.pagePlatformFuncDelegate = new UIPagePlatformFuncDelegateImpl(this);
        initOnCreate();
        KindaAnimatorWatch.didViewCreated(hashCode());
        view.setOnTouchListener(this);
        if (this.life != null) {
            this.life.onViewCreate(bundle);
        }
    }

    public void initPagePlatformDelegate() {
        this.pagePlatformDelegate = new UIPagePlatformDelegateImpl(getActivity());
        this.pagePlatformFuncDelegate = new UIPagePlatformFuncDelegateImpl(this);
    }

    public void willDeActive() {
        this.isActive = false;
        Log.d(TAG, "willDeActive %s %s", getTagName(), this);
    }

    @Override // com.tencent.kinda.framework.widget.base.LifecycleFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Log.d(TAG, "onActivityCreated %s %s", getTagName(), this);
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport
    public View findViewById(int i2) {
        if (getView() != null) {
            return getView().findViewById(i2);
        }
        if (getActivity() != null) {
            return getActivity().findViewById(i2);
        }
        return null;
    }

    @Override // com.tencent.kinda.framework.widget.base.LifecycleFragment, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onResume() {
        Log.d(TAG, "onResume %s %s", getTagName(), this);
        super.onResume();
        if (this.life != null) {
            this.life.onResume();
        }
    }

    @Override // com.tencent.kinda.framework.widget.base.LifecycleFragment, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause %s %s", getTagName(), this);
        if (this.life != null) {
            this.life.onPause();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        Log.d(TAG, "onAttach %s %s", getTagName(), this);
        super.onAttach(activity);
        try {
            this.fragEvent = (IEventFragment) activity;
        } catch (ClassCastException e2) {
            Log.e(TAG, "error IEventFragment");
        }
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onDetach() {
        Log.d(TAG, "onDetach %s %s", getTagName(), this);
        super.onDetach();
        this.fragEvent = null;
    }

    @Override // com.tencent.kinda.framework.widget.base.LifecycleFragment, com.tencent.kinda.framework.widget.base.FragmentLifecycle
    public void onFragmentOnDestroy() {
        super.onFragmentOnDestroy();
        this.pagePlatformFuncDelegate = null;
        this.mCustomActioinBarController = null;
    }

    @Override // com.tencent.mm.ui.MMFragment
    public void onSwipeBack() {
        super.onSwipeBack();
        Log.d(TAG, "onSwipeBack %s %s", getTagName(), this);
        this.fragEvent.popFragment();
    }

    @Override // com.tencent.mm.ui.MMFragment
    public int getLayoutId() {
        return R.layout.axy;
    }

    /* access modifiers changed from: protected */
    public void initPageView() {
        YogaLayout yogaLayout = new YogaLayout(getActivity());
        yogaLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ((ViewGroup) getView().findViewById(R.id.be3)).addView(yogaLayout);
        Log.i(TAG, "initPageView rootLayout %s", yogaLayout);
        onCreateLayout(new PlatformWrapLayout(yogaLayout));
    }

    public void popFragment() {
        if (this.fragEvent != null) {
            this.fragEvent.popFragment();
        }
    }

    public ITransmitKvData covertPlatformData(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        ITransmitKvData create = ITransmitKvData.create();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                if (obj instanceof String) {
                    create.putString(str, (String) obj);
                } else if (obj instanceof Long) {
                    create.putLong(str, ((Long) obj).longValue());
                } else if (obj instanceof Integer) {
                    create.putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof ArrayList) {
                    ArrayList<Integer> arrayList = (ArrayList) obj;
                    if (arrayList.get(0) instanceof String) {
                        create.putListString(str, arrayList);
                    } else if (arrayList.get(0) instanceof Long) {
                        create.putListLong(str, arrayList);
                    } else if (arrayList.get(0) instanceof Integer) {
                        create.putListInt(str, arrayList);
                    }
                }
            }
        }
        return create;
    }

    public void initWithNavigationBarConfig(NavigationBarConfig navigationBarConfig) {
        Log.i(TAG, "NavigationBarConfig: %s", navigationBarConfig);
        if (navigationBarConfig != null && getController().mActionBar != null) {
            if (navigationBarConfig.mBackgroundColor != null) {
                getController().mActionBar.setBackgroundDrawable(new ColorDrawable((int) ColorUtil.getColorByMode(navigationBarConfig.mBackgroundColor)));
                setActionBarColor((int) ColorUtil.getColorByModeNoCompat(navigationBarConfig.mBackgroundColor));
            }
            if (navigationBarConfig.mBarTitle != null) {
                setMMTitle(navigationBarConfig.mBarTitle);
            }
            if (!Util.isNullOrNil(navigationBarConfig.mLeftButtonColor)) {
                try {
                    Drawable mutate = getResources().getDrawable(R.drawable.b1).mutate();
                    if (mutate instanceof StateListDrawable) {
                        mutate = getResources().getDrawable(R.raw.back_icon_normal);
                        mutate.setColorFilter(Color.parseColor(navigationBarConfig.mLeftButtonColor), PorterDuff.Mode.SRC_ATOP);
                    } else {
                        mutate.setColorFilter(Color.parseColor(navigationBarConfig.mLeftButtonColor), PorterDuff.Mode.SRC_ATOP);
                    }
                    getController().updateBackBtn(mutate);
                    getController().setBackBtnColorFilter(Color.parseColor(navigationBarConfig.mLeftButtonColor));
                } catch (Exception e2) {
                }
            }
            ActionBar actionBar = getController().mActionBar;
            if (actionBar != null) {
                actionBar.setElevation(0.0f);
            }
            if (navigationBarConfig.mLeftBarButtonType == LeftBarButtonType.BACK) {
                setBackBtn(new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.kinda.framework.widget.base.BaseFragment.AnonymousClass1 */

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(18762);
                        BaseFragment.this.popFragment();
                        AppMethodBeat.o(18762);
                        return true;
                    }
                });
            } else if (navigationBarConfig.mLeftBarButtonType == LeftBarButtonType.CANCEL) {
                setBackBtn(new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.kinda.framework.widget.base.BaseFragment.AnonymousClass2 */

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(18763);
                        BaseFragment.this.popFragment();
                        AppMethodBeat.o(18763);
                        return true;
                    }
                }, R.raw.actionbar_icon_dark_close);
            } else if (navigationBarConfig.mLeftBarButtonType == LeftBarButtonType.NONE) {
                getController().setBackBtnVisible(false);
            }
            setTopRightBtnImage(navigationBarConfig.mRightButtonImage);
            setTopRightBtnTitle(navigationBarConfig.mRightButtonTitle, navigationBarConfig.mRightButtonColor);
        }
    }

    @Override // com.tencent.mm.ui.MMFragment
    public boolean isSupportCustomActionBar() {
        return true;
    }

    @Override // com.tencent.mm.ui.MMFragment
    public boolean supportNavigationSwipeBack() {
        return false;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.v(TAG, "on touch");
        return true;
    }

    /* access modifiers changed from: protected */
    public void setActionBarColor(int i2) {
        if (getContext() != null) {
            getController().setActionbarColor(i2);
            KindaActionBarColorManager.getInstance().pushActionBarColorItem(this, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void restoreActionBarColor() {
        FragmentActivity activity;
        if (isFinishing() || (activity = getActivity()) == null) {
            return;
        }
        if (!(activity instanceof MMActivity) || !((MMActivity) activity).activityHasDestroyed()) {
            KindaActionBarColorManager.getInstance().onRestoreActionBarColor(this);
        }
    }

    /* access modifiers changed from: protected */
    public Fragment getPrevFragment() {
        if (getFragmentManager() == null) {
            return null;
        }
        List<Fragment> fragments = getFragmentManager().getFragments();
        if (fragments.size() <= 1) {
            return null;
        }
        int indexOf = fragments.indexOf(this);
        if (indexOf - 1 >= 0) {
            return fragments.get(indexOf - 1);
        }
        return null;
    }
}
