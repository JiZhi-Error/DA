package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.k;
import com.tencent.kinda.framework.app.MainFragment;
import com.tencent.kinda.framework.widget.tools.ConstantsKinda;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;
import java.util.List;
import java.util.Stack;

public class FrLifeController {
    public static final String TAG = "MicroMsg.FragmentController";
    private BaseFrActivity activity;
    private int fragmentCount = 0;
    private Stack<BaseFragment> mFragmentBackStack;
    private boolean needTinyCallback = true;
    private MainFragment tinyAppFragment = null;
    private int tinyappCount = 0;
    private MainFragment webViewFragment = null;
    private int webviewCount = 0;

    public interface IFrLife {
        void onDestroyView();

        void onPause();

        void onResume();

        void onViewCreate(Bundle bundle);
    }

    static /* synthetic */ BaseFragment access$100(FrLifeController frLifeController, int i2) {
        AppMethodBeat.i(18796);
        BaseFragment fragMent = frLifeController.getFragMent(i2);
        AppMethodBeat.o(18796);
        return fragMent;
    }

    public FrLifeController(BaseFrActivity baseFrActivity) {
        AppMethodBeat.i(18782);
        this.activity = baseFrActivity;
        g.enableDebugLogging(true);
        this.activity.getSupportFragmentManager().addOnBackStackChangedListener(new g.c() {
            /* class com.tencent.kinda.framework.widget.base.FrLifeController.AnonymousClass1 */

            @Override // android.support.v4.app.g.c
            public void onBackStackChanged() {
                AppMethodBeat.i(178767);
                g supportFragmentManager = FrLifeController.this.activity.getSupportFragmentManager();
                Log.i(FrLifeController.TAG, "onBackstackChanged: %s, fragments: %s", Integer.valueOf(supportFragmentManager.getBackStackEntryCount()), supportFragmentManager.getFragments());
                AppMethodBeat.o(178767);
            }
        });
        this.mFragmentBackStack = new Stack<>();
        AppMethodBeat.o(18782);
    }

    private void watchLife(final BaseFragment baseFragment) {
        AppMethodBeat.i(18783);
        if (baseFragment == null) {
            Log.e(TAG, Util.stackTraceToString(new Throwable("Watch a null fragment!!")));
            AppMethodBeat.o(18783);
            return;
        }
        baseFragment.watchLife(new IFrLife() {
            /* class com.tencent.kinda.framework.widget.base.FrLifeController.AnonymousClass2 */

            @Override // com.tencent.kinda.framework.widget.base.FrLifeController.IFrLife
            public void onResume() {
            }

            @Override // com.tencent.kinda.framework.widget.base.FrLifeController.IFrLife
            public void onPause() {
            }

            @Override // com.tencent.kinda.framework.widget.base.FrLifeController.IFrLife
            public void onViewCreate(Bundle bundle) {
                AppMethodBeat.i(178768);
                if (!baseFragment.isActive()) {
                    Log.i(FrLifeController.TAG, "From onResume, Active create view fragment: " + baseFragment);
                    baseFragment.willActive();
                }
                BaseFragment access$100 = FrLifeController.access$100(FrLifeController.this, -2);
                if (access$100 != null && (baseFragment instanceof MainFragment) && access$100.isActive()) {
                    Log.i(FrLifeController.TAG, "From onCreateView, DeActive covered fragment: " + baseFragment);
                    access$100.willDeActive();
                    baseFragment.recordCoveredFragment(access$100);
                }
                AppMethodBeat.o(178768);
            }

            @Override // com.tencent.kinda.framework.widget.base.FrLifeController.IFrLife
            public void onDestroyView() {
                AppMethodBeat.i(178769);
                BaseFragment coveredFragment = baseFragment.getCoveredFragment();
                if (coveredFragment != null && coveredFragment.equals(FrLifeController.access$100(FrLifeController.this, -1))) {
                    Log.i(FrLifeController.TAG, "From onDestroyView, active covered fragment: ".concat(String.valueOf(coveredFragment)));
                    coveredFragment.willActive();
                }
                AppMethodBeat.o(178769);
            }
        });
        AppMethodBeat.o(18783);
    }

    private void checkSwipeBackLayout() {
        AppMethodBeat.i(18784);
        if (!this.activity.isSupportNavigationSwipeBack()) {
            AppMethodBeat.o(18784);
            return;
        }
        int size = this.mFragmentBackStack.size();
        Log.i(TAG, "checkSwipeBackLayout %s %s", Integer.valueOf(size), Integer.valueOf(this.activity.getFragmentManager().getBackStackEntryCount()));
        if (size > 1) {
            this.activity.getSwipeBackLayout().setEnableGesture(false);
            AppMethodBeat.o(18784);
            return;
        }
        this.activity.getSwipeBackLayout().setEnableGesture(true);
        AppMethodBeat.o(18784);
    }

    public void onActivityDestroy() {
        AppMethodBeat.i(214459);
        this.mFragmentBackStack.clear();
        AppMethodBeat.o(214459);
    }

    public boolean addFragment(BaseFragment baseFragment) {
        AppMethodBeat.i(18785);
        this.fragmentCount++;
        k beginTransaction = this.activity.getSupportFragmentManager().beginTransaction();
        if (baseFragment instanceof MainFragment) {
            beginTransaction = beginTransaction.u(R.anim.eq, R.anim.en);
        }
        beginTransaction.a(R.id.d9p, baseFragment);
        watchLife(baseFragment);
        this.mFragmentBackStack.add(baseFragment);
        beginTransaction.commitAllowingStateLoss();
        Log.i(TAG, "fragment [" + baseFragment + "] has add! current fragmentCount: " + this.fragmentCount);
        AppMethodBeat.o(18785);
        return true;
    }

    public boolean popFragment() {
        AppMethodBeat.i(18786);
        Log.i(TAG, "popFragment, fragmentCount: %d, isStateSaved: %b", Integer.valueOf(this.fragmentCount), Boolean.valueOf(this.activity.getSupportFragmentManager().isStateSaved()));
        if (this.fragmentCount <= 1 || this.activity.getSupportFragmentManager().isStateSaved()) {
            Log.i(TAG, "NO popFragment before return, fragmentCount: %d", Integer.valueOf(this.fragmentCount));
            AppMethodBeat.o(18786);
            return false;
        }
        removeModal(this.mFragmentBackStack.peek());
        Log.i(TAG, "popFragment to remove, fragmentCount: %d", Integer.valueOf(this.fragmentCount));
        if (this.fragmentCount > 0) {
            AppMethodBeat.o(18786);
            return true;
        }
        AppMethodBeat.o(18786);
        return false;
    }

    public boolean removeModal(BaseFragment baseFragment) {
        AppMethodBeat.i(18787);
        if (this.fragmentCount > 0) {
            if (baseFragment.isActive()) {
                baseFragment.willDeActive();
            }
            this.fragmentCount--;
            baseFragment.setWillBeRemoved(true);
            k beginTransaction = this.activity.getSupportFragmentManager().beginTransaction();
            if (baseFragment instanceof MainFragment) {
                beginTransaction = beginTransaction.u(R.anim.eq, R.anim.er);
            }
            beginTransaction.a(baseFragment);
            beginTransaction.commitAllowingStateLoss();
            this.mFragmentBackStack.remove(baseFragment);
        }
        Log.i(TAG, "removeModal [%s] before return, fragmentCount: %d", baseFragment, Integer.valueOf(this.fragmentCount));
        if (this.fragmentCount > 0) {
            AppMethodBeat.o(18787);
            return true;
        }
        AppMethodBeat.o(18787);
        return false;
    }

    public BaseFragment getCurrent() {
        AppMethodBeat.i(18788);
        List<Fragment> fragments = this.activity.getSupportFragmentManager().getFragments();
        if (fragments.size() > 0) {
            Fragment fragment = fragments.get(fragments.size() - 1);
            if (fragment instanceof BaseFragment) {
                BaseFragment baseFragment = (BaseFragment) fragment;
                AppMethodBeat.o(18788);
                return baseFragment;
            }
            AppMethodBeat.o(18788);
            return null;
        }
        AppMethodBeat.o(18788);
        return null;
    }

    private BaseFragment getFragMent(int i2) {
        AppMethodBeat.i(18789);
        if (this.mFragmentBackStack == null || this.mFragmentBackStack.size() == 0) {
            AppMethodBeat.o(18789);
            return null;
        } else if (i2 < 0) {
            int size = this.mFragmentBackStack.size() + i2;
            if (size < 0 || size >= this.mFragmentBackStack.size()) {
                AppMethodBeat.o(18789);
                return null;
            }
            BaseFragment baseFragment = this.mFragmentBackStack.get(this.mFragmentBackStack.size() + i2);
            AppMethodBeat.o(18789);
            return baseFragment;
        } else if (i2 < this.mFragmentBackStack.size()) {
            BaseFragment baseFragment2 = this.mFragmentBackStack.get(i2);
            AppMethodBeat.o(18789);
            return baseFragment2;
        } else {
            AppMethodBeat.o(18789);
            return null;
        }
    }

    public int getFragmentListSize() {
        AppMethodBeat.i(18790);
        Log.i(TAG, "getFragmentListSize: %d", Integer.valueOf(this.fragmentCount));
        int i2 = this.fragmentCount;
        AppMethodBeat.o(18790);
        return i2;
    }

    public void startWebViewUIPage(Bundle bundle, MainFragment mainFragment) {
        AppMethodBeat.i(18791);
        f.a((Context) this.activity, bundle.getString(ConstantsKinda.INTENT_WEBVIEW_URL, ""), true, 2);
        this.webViewFragment = mainFragment;
        this.webviewCount++;
        AppMethodBeat.o(18791);
    }

    public void startTinyAppUIPage(Bundle bundle, MainFragment mainFragment) {
        AppMethodBeat.i(18792);
        String string = bundle.getString(ConstantsKinda.INTENT_TINYAPP_USERNAME, "");
        String string2 = bundle.getString(ConstantsKinda.INTENT_TINYAPP_PATH, "");
        String string3 = bundle.getString(ConstantsKinda.INTENT_TINYAPP_VERSION, "");
        int i2 = bundle.getInt(ConstantsKinda.INTENT_TINYAPP_TYPE, 0);
        int i3 = bundle.getInt(ConstantsKinda.INTENT_TINYAPP_SCENE, 0);
        mainFragment.isTinyApp = true;
        mainFragment.tinyAppUserName = string;
        mainFragment.initPagePlatformDelegate();
        com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
        gVar.username = string;
        gVar.kHw = Util.nullAs(string2, "");
        if (i3 == 0) {
            gVar.scene = 1034;
        } else {
            gVar.scene = i3;
        }
        if (i2 == 0) {
            gVar.iOo = 0;
        } else {
            gVar.iOo = 2;
        }
        int i4 = Util.getInt(string3, 0);
        if (i4 > 0) {
            gVar.version = i4;
        }
        gVar.kHC = 3;
        ((r) com.tencent.mm.kernel.g.af(r.class)).a(this.activity, gVar);
        this.tinyAppFragment = mainFragment;
        this.tinyappCount++;
        if (this.fragmentCount == 0) {
            Log.i(TAG, "only tinyApp,dont need TinyCallback");
            this.needTinyCallback = false;
            AppMethodBeat.o(18792);
            return;
        }
        this.needTinyCallback = true;
        AppMethodBeat.o(18792);
    }

    public boolean processCallback(int i2) {
        AppMethodBeat.i(18793);
        if (i2 == 2 && this.webviewCount > 0 && this.webViewFragment != null) {
            this.webViewFragment.onDestroy();
            this.webViewFragment = null;
            this.webviewCount--;
            AppMethodBeat.o(18793);
            return true;
        } else if (i2 != 3 || this.tinyappCount <= 0 || this.tinyAppFragment == null || !this.needTinyCallback) {
            AppMethodBeat.o(18793);
            return false;
        } else {
            this.tinyAppFragment.onDestroy();
            this.tinyAppFragment = null;
            this.tinyappCount--;
            AppMethodBeat.o(18793);
            return true;
        }
    }

    public boolean hasOpenH5OrTinyApp() {
        AppMethodBeat.i(18794);
        Log.i(TAG, "hasOpenH5OrTinyApp, webviewCount: %d, tinyappCount: %d", Integer.valueOf(this.webviewCount), Integer.valueOf(this.tinyappCount));
        if (this.webviewCount > 0 || this.tinyappCount > 0) {
            AppMethodBeat.o(18794);
            return true;
        }
        AppMethodBeat.o(18794);
        return false;
    }

    public void setTinyCallbackTag(boolean z) {
        this.needTinyCallback = z;
    }
}
