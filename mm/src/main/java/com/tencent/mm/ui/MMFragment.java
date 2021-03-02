package com.tencent.mm.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.h.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.k.a;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.Locale;

public abstract class MMFragment extends FragmentActivitySupport implements View.OnAttachStateChangeListener, a {
    protected static final int DEFAULT_TOAST_TIME = 3000;
    public static final String FLAG_OVERRIDE_ENTER_ANIMATION = "MMActivity.OverrideEnterAnimation";
    public static final String FLAG_OVERRIDE_EXIT_ANIMATION = "MMActivity.OverrideExitAnimation";
    private static final String TAG = "MicroMsg.MMFragment";
    private static final String TAG2 = "MicroMsg.INIT";
    String className;
    protected t mController = new t() {
        /* class com.tencent.mm.ui.MMFragment.AnonymousClass1 */

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.t
        public final int getLayoutId() {
            AppMethodBeat.i(141392);
            int layoutId = MMFragment.this.getLayoutId();
            AppMethodBeat.o(141392);
            return layoutId;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.t
        public final void dealContentView(View view) {
            AppMethodBeat.i(141393);
            MMFragment.this.dealContentView(view);
            AppMethodBeat.o(141393);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.t
        public final String getIdentString() {
            AppMethodBeat.i(141394);
            String identityString = MMFragment.this.getIdentityString();
            AppMethodBeat.o(141394);
            return identityString;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.t
        public final View getLayoutView() {
            AppMethodBeat.i(141395);
            View layoutView = MMFragment.this.getLayoutView();
            AppMethodBeat.o(141395);
            return layoutView;
        }

        @Override // com.tencent.mm.ui.t
        public final void onKeyboardStateChanged() {
            AppMethodBeat.i(141396);
            MMFragment.this.onKeyboardStateChanged();
            AppMethodBeat.o(141396);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.t
        public final void onCreateBeforeSetContentView() {
            AppMethodBeat.i(141397);
            MMFragment.this.onCreateBeforeSetContentView();
            AppMethodBeat.o(141397);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.t
        public final String getClassName() {
            AppMethodBeat.i(141398);
            String name = MMFragment.this.getClass().getName();
            AppMethodBeat.o(141398);
            return name;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.t
        public final boolean fromFullScreenActivity() {
            return false;
        }

        @Override // com.tencent.mm.ui.t
        public final boolean noActionBar() {
            AppMethodBeat.i(141399);
            boolean noActionBar = MMFragment.this.noActionBar();
            AppMethodBeat.o(141399);
            return noActionBar;
        }
    };
    private boolean mCurVisible = false;
    private a mListener;
    protected AppCompatActivity mParent;
    private MMFragment mParentFragment;
    private boolean mParentVisible = false;
    private SwipeBackLayout mSwipeBackLayout;

    /* access modifiers changed from: protected */
    public abstract int getLayoutId();

    public MMFragment() {
    }

    public MMFragment(boolean z) {
        super(z);
    }

    public void setBackGroundColorResource(int i2) {
        this.mController.setBackGroundColorResource(i2);
    }

    public static Locale initLanguage(Context context) {
        return t.initLanguage(context);
    }

    public void setMMNormalView() {
        this.mController.setMMNormalView();
    }

    /* access modifiers changed from: protected */
    public void onCreateBeforeSetContentView() {
    }

    public void setActivityController(t tVar) {
        if (tVar != null) {
            this.mController = tVar;
        }
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.a(thisActivity().getBaseContext(), (AppCompatActivity) thisActivity());
        this.mController.setNavigationbarColor(thisActivity().getResources().getColor(R.color.f3044b));
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        getView().addOnAttachStateChangeListener(this);
    }

    public SwipeBackLayout getSwipeBackLayout() {
        return this.mSwipeBackLayout;
    }

    public boolean isSupportCustomActionBar() {
        return isSupportNavigationSwipeBack();
    }

    public boolean supportNavigationSwipeBack() {
        return true;
    }

    public boolean noActionBar() {
        return false;
    }

    public void onSwipeBack() {
    }

    public void onDragBegin() {
    }

    public void onCancelDrag() {
    }

    private View initSwipeBack() {
        View contentView = getContentView();
        ViewGroup viewGroup = (ViewGroup) contentView.getParent();
        if (viewGroup != null) {
            this.mSwipeBackLayout = (SwipeBackLayout) LayoutInflater.from(thisActivity()).inflate(R.layout.c1b, viewGroup, false);
            viewGroup.removeView(contentView);
            viewGroup.addView(this.mSwipeBackLayout);
        } else {
            this.mSwipeBackLayout = (SwipeBackLayout) LayoutInflater.from(thisActivity()).inflate(R.layout.c1b, (ViewGroup) null);
        }
        this.mSwipeBackLayout.addView(contentView);
        this.mSwipeBackLayout.setContentView(contentView);
        this.mSwipeBackLayout.CV(true);
        this.mSwipeBackLayout.setSwipeGestureDelegate(new SwipeBackLayout.a() {
            /* class com.tencent.mm.ui.MMFragment.AnonymousClass2 */

            @Override // com.tencent.mm.ui.widget.SwipeBackLayout.a
            public final void onSwipeBack() {
                AppMethodBeat.i(141400);
                MMFragment.this.onSwipeBack();
                AppMethodBeat.o(141400);
            }

            @Override // com.tencent.mm.ui.widget.SwipeBackLayout.a
            public final void onCancel() {
                AppMethodBeat.i(141401);
                MMFragment.this.onCancelDrag();
                AppMethodBeat.o(141401);
            }

            @Override // com.tencent.mm.ui.widget.SwipeBackLayout.a
            public final void onDrag() {
                AppMethodBeat.i(141402);
                MMFragment.this.onDragBegin();
                AppMethodBeat.o(141402);
            }
        });
        return this.mSwipeBackLayout;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Log.i(TAG, "onCreateView");
        setHasOptionsMenu(true);
        View contentView = getContentView();
        if (isSupportNavigationSwipeBack()) {
            return initSwipeBack();
        }
        return contentView;
    }

    /* access modifiers changed from: protected */
    public void dealContentView(View view) {
    }

    public int keyboardState() {
        return this.mController.OGC;
    }

    public void onKeyboardStateChanged() {
    }

    public void setParent(AppCompatActivity appCompatActivity) {
        this.mParent = appCompatActivity;
    }

    @Override // android.support.v4.app.Fragment
    public final Activity getContext() {
        return this.mController.OGe;
    }

    public t getController() {
        return this.mController;
    }

    public boolean isScreenEnable() {
        return this.mController.OFT;
    }

    public void setScreenEnable(boolean z) {
        this.mController.setScreenEnable(z);
    }

    /* access modifiers changed from: protected */
    public final void setBodyView(int i2) {
        this.mController.setBodyView(i2);
    }

    public View getBodyView() {
        return this.mController.GDE;
    }

    public final View getContentView() {
        return this.mController.contentView;
    }

    /* access modifiers changed from: protected */
    public int getForceOrientation() {
        return this.mController.getForceOrientation();
    }

    public boolean getLandscapeMode() {
        return this.mController.getLandscapeMode();
    }

    public int getStreamVolume(int i2) {
        return this.mController.getStreamVolume(i2);
    }

    public int getStreamMaxVolume(int i2) {
        return this.mController.getStreamMaxVolume(i2);
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (this.mController.onKeyUp(i2, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.mController.onKeyDown(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public boolean needShowIdcError() {
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        long currentTimeMillis = System.currentTimeMillis();
        am.dl(1, this.className);
        super.onResume();
        Log.v(TAG2, "KEVIN MMActivity super..onResume " + (System.currentTimeMillis() - currentTimeMillis));
        this.mController.onResume();
        Log.v(TAG2, "KEVIN MMActivity onResume :" + (System.currentTimeMillis() - currentTimeMillis));
        onParentVisibilityChanged(true);
    }

    public void addDialog(Dialog dialog) {
        this.mController.addDialog(dialog);
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mController.jM(getActivity());
    }

    public void activateBroadcast(boolean z) {
        this.mController.activateBroadcast(z);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        long currentTimeMillis = System.currentTimeMillis();
        am.dl(2, this.className);
        super.onPause();
        this.mController.onPause();
        Log.v(TAG2, "KEVIN MMActivity onPause:" + (System.currentTimeMillis() - currentTimeMillis));
        onParentVisibilityChanged(false);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (!this.mController.onCreateOptionsMenu(menu)) {
            super.onCreateOptionsMenu(menu, menuInflater);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        this.mController.onPrepareOptionsMenu(menu);
        super.onPrepareOptionsMenu(menu);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mController.onOptionsItemSelected(menuItem);
    }

    public boolean callBackMenu() {
        return this.mController.callBackMenu();
    }

    public String getIdentityString() {
        return "";
    }

    /* access modifiers changed from: protected */
    public View getLayoutView() {
        return null;
    }

    @Deprecated
    public void setToTop(View.OnClickListener onClickListener) {
    }

    @Deprecated
    public void setTitleClickAction(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
    }

    @Deprecated
    public void setRedDotVisibilty(int i2) {
    }

    public void fullScreenNoTitleBar(boolean z) {
        this.mController.fullScreenNoTitleBar(z);
    }

    public void fullScreenWithTitleBar(boolean z) {
        this.mController.fullScreenWithTitleBar(z);
    }

    public void setTitleVisibility(int i2) {
        this.mController.setTitleVisibility(i2);
    }

    public void setMMTitle(String str) {
        this.mController.setMMTitle(str);
    }

    public void updateDescription(String str) {
        this.mController.updateDescription(str);
    }

    public void setMMTitle(int i2) {
        this.mController.setMMTitle(i2);
    }

    public void setMMSubTitle(String str) {
        this.mController.setMMSubTitle(str);
    }

    public void setMMSubTitle(int i2) {
        this.mController.setMMSubTitle(i2);
    }

    public void setMMSubTitleColor(int i2) {
    }

    public void setTitleLogo(int i2, int i3) {
        this.mController.setTitleLogo(i2, i3);
    }

    public void showHomeBtn(boolean z) {
        this.mController.showHomeBtn(z);
    }

    public void enableBackMenu(boolean z) {
        this.mController.enableBackMenu(z);
    }

    public void enableOptionMenu(boolean z) {
        this.mController.c(true, -1, z);
    }

    public void enableOptionMenu(int i2, boolean z) {
        this.mController.c(false, i2, z);
    }

    public void showOptionMenu(boolean z) {
        this.mController.d(true, -1, z);
    }

    public void showOptionMenu(int i2, boolean z) {
        this.mController.d(false, i2, z);
    }

    public void addSearchMenu(boolean z, s sVar) {
        this.mController.addSearchMenu(z, sVar);
    }

    public void addTextOptionMenu(int i2, String str, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addTextOptionMenu(i2, str, onMenuItemClickListener);
    }

    public void addTextOptionMenu(int i2, String str, MenuItem.OnMenuItemClickListener onMenuItemClickListener, View.OnLongClickListener onLongClickListener) {
        this.mController.addTextOptionMenu(i2, str, onMenuItemClickListener, onLongClickListener);
    }

    public void addTextOptionMenu(int i2, String str, MenuItem.OnMenuItemClickListener onMenuItemClickListener, View.OnLongClickListener onLongClickListener, t.b bVar) {
        this.mController.addTextOptionMenu(i2, str, onMenuItemClickListener, onLongClickListener, bVar);
    }

    public void addIconOptionMenu(int i2, int i3, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i2, i3, onMenuItemClickListener);
    }

    public void addIconOptionMenu(int i2, int i3, MenuItem.OnMenuItemClickListener onMenuItemClickListener, int i4) {
        t tVar = this.mController;
        t.b bVar = t.b.NORMAL;
        t.a aVar = new t.a();
        aVar.Oye = i2;
        aVar.OGQ = i4;
        aVar.Oyf = i3;
        aVar.text = "";
        aVar.kjh = onMenuItemClickListener;
        aVar.tib = null;
        aVar.OGS = bVar;
        aVar.eho = false;
        if (aVar.Oyf == R.drawable.aii && Util.isNullOrNil("")) {
            aVar.text = tVar.mContext.getString(R.string.wp);
        }
        tVar.akW(aVar.Oye);
        tVar.OxV.add(aVar);
        tVar.supportInvalidateOptionsMenu();
    }

    public void addIconOptionMenu(int i2, String str, int i3, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i2, str, i3, onMenuItemClickListener);
    }

    public void addIconOptionMenu(int i2, int i3, int i4, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i2, i3, i4, onMenuItemClickListener);
    }

    public void addIconOptionMenu(int i2, int i3, int i4, boolean z, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i2, i3, i4, z, onMenuItemClickListener);
    }

    public void addIconOptionMenu(int i2, int i3, MenuItem.OnMenuItemClickListener onMenuItemClickListener, View.OnLongClickListener onLongClickListener) {
        this.mController.addIconOptionMenu(i2, i3, onMenuItemClickListener, onLongClickListener);
    }

    public void addIconOptionMenu(int i2, int i3, int i4, MenuItem.OnMenuItemClickListener onMenuItemClickListener, View.OnLongClickListener onLongClickListener) {
        this.mController.addIconOptionMenu(i2, i3, i4, onMenuItemClickListener, onLongClickListener);
    }

    public void addIconOptionMenu(int i2, int i3, Drawable drawable, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i2, getString(i3), drawable, onMenuItemClickListener);
    }

    public void addIconOptionMenu(int i2, String str, Drawable drawable, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i2, str, drawable, onMenuItemClickListener);
    }

    public void updateOptionMenuIcon(int i2, int i3) {
        this.mController.updateOptionMenuIcon(i2, i3);
    }

    public void updateOptionMenuText(int i2, String str) {
        this.mController.updateOptionMenuText(i2, str);
    }

    public void updateOptionMenuListener(int i2, MenuItem.OnMenuItemClickListener onMenuItemClickListener, View.OnLongClickListener onLongClickListener) {
        this.mController.updateOptionMenuListener(i2, onMenuItemClickListener, onLongClickListener);
    }

    public t.a findMenuInfo(int i2) {
        return this.mController.akX(i2);
    }

    public void updateOptionMenu(int i2, int i3, int i4, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        updateOptionMenu(i2, i3, i4, false, onMenuItemClickListener);
    }

    public void updateOptionMenu(int i2, int i3, int i4, boolean z, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        t tVar = this.mController;
        tVar.updateOptionMenuText(i2, tVar.OGe.getString(i3));
        this.mController.updateOptionMenuIcon(i2, i4);
        this.mController.updateOptionMenuListener(i2, onMenuItemClickListener, null);
        this.mController.updateOptionMenuRedDot(i2, z);
        this.mController.a(this.mController.akX(i2));
    }

    public void updateOptionMenu(int i2, int i3, MenuItem.OnMenuItemClickListener onMenuItemClickListener, int i4) {
        this.mController.updateOptionMenuIcon(i2, i3);
        this.mController.updateOptionMenuListener(i2, onMenuItemClickListener, null);
        t tVar = this.mController;
        t.a akX = tVar.akX(i2);
        if (!(akX == null || akX.Oyf == i3)) {
            akX.Oyf = i3;
            akX.OGQ = i4;
            tVar.supportInvalidateOptionsMenu();
        }
        this.mController.a(this.mController.akX(i2));
    }

    public void updateOptionMenuRedDot(int i2, boolean z) {
        this.mController.updateOptionMenuRedDot(i2, z);
    }

    public void setTitleBarDoubleClickListener(Runnable runnable) {
        this.mController.setTitleBarDoubleClickListener(runnable);
    }

    public void setBackBtn(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.setBackBtn(onMenuItemClickListener, 0);
    }

    public void setBackBtn(MenuItem.OnMenuItemClickListener onMenuItemClickListener, int i2) {
        this.mController.setBackBtn(onMenuItemClickListener, i2);
    }

    public void removeAllOptionMenu() {
        this.mController.removeAllOptionMenu();
    }

    public boolean removeOptionMenu(int i2) {
        return this.mController.removeOptionMenu(i2);
    }

    public CharSequence getMMTitle() {
        return this.mController.getMMTitle();
    }

    public void hideTitleView() {
        this.mController.hideTitleView();
    }

    public void showTitleView() {
        this.mController.showTitleView();
    }

    public boolean isTitleShowing() {
        return this.mController.isTitleShowing();
    }

    public int getTitleLocation() {
        return this.mController.getTitleLocation();
    }

    public void setTitlePhoneIconVisibility(int i2) {
        this.mController.setTitlePhoneIconVisibility(i2);
    }

    public void setTitleMuteIconVisibility(int i2) {
        this.mController.setTitleMuteIconVisibility(i2);
    }

    public boolean hideVKB() {
        return this.mController.hideVKB();
    }

    public boolean hideVKB(View view) {
        return this.mController.hideVKB(view);
    }

    public void showVKB() {
        t.showVKB(this.mController.OGe);
    }

    public static void showVKB(Activity activity) {
        View currentFocus;
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null && (currentFocus = activity.getCurrentFocus()) != null && currentFocus.getWindowToken() != null) {
            inputMethodManager.toggleSoftInput(0, 2);
        }
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport
    public void finish() {
        super.finish();
        int intExtra = thisActivity().getIntent().getIntExtra("MMActivity.OverrideEnterAnimation", -1);
        int intExtra2 = thisActivity().getIntent().getIntExtra("MMActivity.OverrideExitAnimation", -1);
        if (intExtra != -1) {
            BackwardSupportUtil.AnimationHelper.overridePendingTransition(getContext(), intExtra, intExtra2);
        }
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment
    public void startActivity(Intent intent) {
        startActivityReal(intent);
    }

    public void startActivityReal(Intent intent) {
        super.startActivity(intent);
    }

    public Resources thisResources() {
        FragmentActivity activity = super.getActivity();
        if (activity == null) {
            return MMApplicationContext.getContext().getResources();
        }
        return activity.getResources();
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport
    public FragmentActivity thisActivity() {
        if (this.mController.OGe != null) {
            return this.mController.OGe;
        }
        return super.getActivity();
    }

    public Resources getMMResources() {
        return thisActivity().getResources();
    }

    public String getMMString(int i2) {
        return thisActivity().getString(i2);
    }

    public String getMMString(int i2, Object... objArr) {
        return thisActivity().getString(i2, objArr);
    }

    public boolean interceptSupportInvalidateOptionsMenu() {
        if (!this.mController.interceptSupportInvalidateOptionsMenu()) {
            return false;
        }
        this.mController.supportInvalidateOptionsMenu();
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        this.mController.onStart();
        super.onStart();
        onParentVisibilityChanged(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        onParentVisibilityChanged(false);
    }

    @Override // android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        filterAndNotifyVisibility(!z, z);
    }

    @Override // android.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Log.i(TAG, "[setUserVisibleHint] isVisibleToUser:%s name:%s", Boolean.valueOf(z), getClass().getName());
        super.setUserVisibleHint(z);
        filterAndNotifyVisibility(z);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach");
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (parentFragment instanceof MMFragment)) {
            this.mParentFragment = (MMFragment) parentFragment;
            this.mParentFragment.setOnVisibilityChangedListener(this);
        }
        filterAndNotifyVisibility(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        if (this.mParentFragment != null) {
            this.mParentFragment.setOnVisibilityChangedListener(null);
        }
        super.onDetach();
        filterAndNotifyVisibility(false);
        this.mParentFragment = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        getView().removeOnAttachStateChangeListener(this);
    }

    public void onViewAttachedToWindow(View view) {
        filterAndNotifyVisibility(true);
    }

    public void onViewDetachedFromWindow(View view) {
        filterAndNotifyVisibility(false);
    }

    @Override // com.tencent.mm.ui.k.a
    public void onFragmentVisibilityChanged(boolean z) {
        filterAndNotifyVisibility(z);
    }

    /* access modifiers changed from: protected */
    public void onParentVisibilityChanged(boolean z) {
        this.mParentVisible = z;
        filterAndNotifyVisibility(z);
    }

    public void setOnVisibilityChangedListener(a aVar) {
        this.mListener = aVar;
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(boolean z) {
        if (this.mListener != null) {
            this.mListener.onFragmentVisibilityChanged(z);
        }
        int i2 = -1;
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey(getClass().getName())) {
            i2 = arguments.getInt(getClass().getName());
        }
        Log.i(TAG, "[onVisibilityChanged] visible:%s name:%s id:%s", Boolean.valueOf(z), getClass().getName(), Integer.valueOf(i2));
    }

    public boolean isFragmentVisible() {
        return this.mCurVisible;
    }

    private void filterAndNotifyVisibility(boolean z) {
        filterAndNotifyVisibility(z, false);
    }

    private void filterAndNotifyVisibility(boolean z, boolean z2) {
        boolean z3;
        if (z != this.mCurVisible) {
            boolean isFragmentVisible = this.mParentFragment == null ? this.mParentVisible : this.mParentFragment.isFragmentVisible();
            boolean isVisible = super.isVisible();
            boolean userVisibleHint = getUserVisibleHint();
            if (!isFragmentVisible || !isVisible || !userVisibleHint || z2) {
                z3 = false;
            } else {
                z3 = true;
            }
            Log.i(TAG, "[filterAndNotifyVisibility] visible = %s parent = %s, super = %s, hint = %s name:%s", Boolean.valueOf(z3), Boolean.valueOf(isFragmentVisible), Boolean.valueOf(isVisible), Boolean.valueOf(userVisibleHint), getClass().getName());
            if (z3 != this.mCurVisible) {
                this.mCurVisible = z3;
                onVisibilityChanged(this.mCurVisible);
            }
        }
    }

    public final boolean isSupportNavigationSwipeBack() {
        if (!d.oD(19) || !b.apl()) {
            return false;
        }
        return supportNavigationSwipeBack();
    }
}
