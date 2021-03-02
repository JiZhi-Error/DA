package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ad.b;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.sdk.platformtools.AndroidOSafety;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentActivity;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.h;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Set;

public class MMFragmentActivity extends UIComponentActivity implements SwipeBackLayout.a, h.a, com.tencent.mm.vending.e.b {
    public static final long ANIMATION_DURATION = 260;
    public static final String EXTRA_USE_SYSTEM_DEFAULT_ENTER_EXIT_ANIM = "extra_use_system_default_enter_exit_anim";
    private static final String TAG = "MicroMsg.MMFragmentActivity";
    public static final float WIDTH_SETTLE_FACT = 3.5f;
    String className;
    private Resources customResources;
    private a mActivityAnimStyle = new a();
    private View mContentViewForSwipeBack = null;
    private boolean mIsPaused;
    private com.tencent.mm.vending.a.a mLifeCycleKeeper = new com.tencent.mm.vending.a.a();
    private c mNfcFilterHelper;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean mSwiping;
    private b onActResult = null;
    ArrayList<WeakReference<MMFragment>> record = new ArrayList<>();
    private boolean updateResource = false;

    public interface b {
        void d(int i2, int i3, Intent intent);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MMFragmentActivity() {
        AppMethodBeat.i(141406);
        AppMethodBeat.o(141406);
    }

    static abstract class d implements SharedPreferences.OnSharedPreferenceChangeListener, com.tencent.mm.vending.e.a {
        public d() {
            MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).registerOnSharedPreferenceChangeListener(this);
        }

        @Override // com.tencent.mm.vending.e.a
        public void dead() {
            Log.i(MMFragmentActivity.TAG, "OnSharedPreferenceChangeListenerLifeCycleAware dead");
            MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).unregisterOnSharedPreferenceChangeListener(this);
        }
    }

    @Override // com.tencent.mm.vending.e.b
    public void keep(com.tencent.mm.vending.e.a aVar) {
        AppMethodBeat.i(141407);
        this.mLifeCycleKeeper.QYJ.keep(aVar);
        AppMethodBeat.o(141407);
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    /* access modifiers changed from: protected */
    public com.tencent.mm.vending.e.b theCreate() {
        return this.mLifeCycleKeeper.QYJ;
    }

    /* access modifiers changed from: protected */
    public com.tencent.mm.vending.e.b theResume() {
        return this.mLifeCycleKeeper.QYK;
    }

    /* access modifiers changed from: protected */
    public com.tencent.mm.vending.e.b theStart() {
        return this.mLifeCycleKeeper.QYK;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(141408);
        this.className = getClass().getName();
        am.dl(3, this.className);
        super.onCreate(bundle);
        if (isNfcFilterEnabled()) {
            final AnonymousClass1 r0 = new Runnable() {
                /* class com.tencent.mm.ui.MMFragmentActivity.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(205121);
                    Log.i(MMFragmentActivity.TAG, "createNfcFilterHelperTask run");
                    MMFragmentActivity.this.mNfcFilterHelper = new c(MMFragmentActivity.this, (byte) 0);
                    c cVar = MMFragmentActivity.this.mNfcFilterHelper;
                    try {
                        Log.i(MMFragmentActivity.TAG, "[NFC] getDefaultAdapter");
                        cVar.OHF = NfcAdapter.getDefaultAdapter(MMFragmentActivity.this);
                    } catch (Throwable th) {
                        Log.printErrStackTrace(MMFragmentActivity.TAG, th, "", new Object[0]);
                    }
                    cVar.init();
                    AppMethodBeat.o(205121);
                }
            };
            if (!ChannelUtil.shouldShowGprsAlert || !MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("gprs_alert", true)) {
                r0.run();
            } else {
                keep(new d() {
                    /* class com.tencent.mm.ui.MMFragmentActivity.AnonymousClass2 */

                    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                        AppMethodBeat.i(205122);
                        if (str.equals("gprs_alert") && !sharedPreferences.getBoolean("gprs_alert", true)) {
                            Log.i(MMFragmentActivity.TAG, "onSharedPreferenceChanged");
                            r0.run();
                            if (!MMFragmentActivity.this.isPaused() && MMFragmentActivity.this.mNfcFilterHelper != null) {
                                MMFragmentActivity.this.mNfcFilterHelper.onResume();
                            }
                            dead();
                        }
                        AppMethodBeat.o(205122);
                    }
                });
            }
        }
        Log.i(TAG, "checktask onCreate:%s#0x%x, taskid:%d, task:%s appendMemLog:%s", getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), Util.getActivityTaskInfo(this), appendMemLog());
        AppMethodBeat.o(141408);
    }

    public String appendMemLog() {
        AppMethodBeat.i(141409);
        long j2 = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        String format = String.format("Runtime: [%s:%s:%s] Native: [%s:%s:%s] ", Long.valueOf(j2), Long.valueOf(freeMemory), Long.valueOf(j2 - freeMemory), Long.valueOf(Debug.getNativeHeapSize()), Long.valueOf(Debug.getNativeHeapAllocatedSize()), Long.valueOf(Debug.getNativeHeapFreeSize()));
        AppMethodBeat.o(141409);
        return format;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(141410);
        Log.i(TAG, "checktask onDestroy:%s#0x%x task:%s appendMemLog:%s", getClass().getSimpleName(), Integer.valueOf(hashCode()), Util.getActivityTaskInfo(this), appendMemLog());
        this.mLifeCycleKeeper.QYJ.dead();
        super.onDestroy();
        if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER) && Build.VERSION.SDK_INT == 24) {
            try {
                if (b.a.hvx == null) {
                    Class<?> cls = Class.forName("android.rms.iaware.FastgrabConfigReader");
                    b.a.hvx = cls;
                    Field declaredField = cls.getDeclaredField("mFastgrabConfigReader");
                    b.a.field_mFastgrabConfigReader = declaredField;
                    declaredField.setAccessible(true);
                    Field declaredField2 = b.a.hvx.getDeclaredField("mContext");
                    b.a.field_mContext = declaredField2;
                    declaredField2.setAccessible(true);
                }
                Object obj = b.a.field_mFastgrabConfigReader.get(b.a.hvx);
                if (b.a.field_mContext.get(obj) == this) {
                    b.a.field_mContext.set(obj, null);
                }
            } catch (Throwable th) {
            }
        }
        if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER) && Build.VERSION.SDK_INT == 24) {
            try {
                if (b.C0243b.aWC == null) {
                    Class<?> cls2 = Class.forName("android.gestureboost.GestureBoostManager");
                    b.C0243b.aWC = cls2;
                    Field declaredField3 = cls2.getDeclaredField("sGestureBoostManager");
                    b.C0243b.hvy = declaredField3;
                    declaredField3.setAccessible(true);
                    Field declaredField4 = b.C0243b.aWC.getDeclaredField("mContext");
                    b.C0243b.hvz = declaredField4;
                    declaredField4.setAccessible(true);
                }
                Object obj2 = b.C0243b.hvy.get(null);
                if (obj2 != null) {
                    b.C0243b.hvz.set(obj2, null);
                }
            } catch (Throwable th2) {
            }
        }
        try {
            if (Build.VERSION.SDK_INT >= 23 && Build.MANUFACTURER.equalsIgnoreCase("samsung")) {
                Object systemService = MMApplicationContext.getContext().getSystemService(Class.forName("com.samsung.android.content.clipboard.SemClipboardManager"));
                Field declaredField5 = systemService.getClass().getDeclaredField("mContext");
                declaredField5.setAccessible(true);
                declaredField5.set(systemService, MMApplicationContext.getContext());
            }
        } catch (Throwable th3) {
        }
        Log.i(TAG, "Activity dump [%s]", com.tencent.mm.ad.a.aBz());
        AppMethodBeat.o(141410);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(141411);
        this.mLifeCycleKeeper.QYL.dead();
        super.onStop();
        AppMethodBeat.o(141411);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(141412);
        super.onStart();
        AppMethodBeat.o(141412);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(141413);
        am.dl(2, this.className);
        this.mIsPaused = true;
        super.onPause();
        if (isSupportNavigationSwipeBack()) {
            if (getSwipeBackLayout() != null) {
                getSwipeBackLayout().setEnableGesture(false);
            }
            if (!isFinishing()) {
                h.a(this);
            }
        }
        if (this.mNfcFilterHelper != null) {
            c cVar = this.mNfcFilterHelper;
            if (cVar.OHF != null) {
                try {
                    Log.i(TAG, "[NFC] disableForegroundDispatch");
                    cVar.OHF.disableForegroundDispatch(MMFragmentActivity.this);
                } catch (Exception e2) {
                    Log.e(TAG, "lo-nfc-onPause: exp:" + e2.getLocalizedMessage());
                }
            }
        }
        this.mLifeCycleKeeper.QYK.dead();
        AppMethodBeat.o(141413);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(141414);
        am.dl(1, this.className);
        this.mIsPaused = false;
        super.onResume();
        if (isSupportNavigationSwipeBack()) {
            h.b(this);
            onSwipe(1.0f);
            if (getSwipeBackLayout() != null) {
                getSwipeBackLayout().setEnableGesture(true);
                getSwipeBackLayout().hfx = false;
            }
        }
        if (this.mNfcFilterHelper != null) {
            this.mNfcFilterHelper.onResume();
        }
        AppMethodBeat.o(141414);
    }

    public void switchFragmentInternalWithoutAnim(Fragment fragment) {
        AppMethodBeat.i(141415);
        if (fragment == null) {
            AppMethodBeat.o(141415);
            return;
        }
        switchFragmentInternalWithoutAnim(fragment, fragment.getId());
        AppMethodBeat.o(141415);
    }

    public void switchFragmentInternalWithoutAnim(Fragment fragment, int i2) {
        AppMethodBeat.i(141416);
        switchFragment(fragment, i2, false, false, 0, 0);
        AppMethodBeat.o(141416);
    }

    public void switchFragmentInternalFarwardWithAnim(Fragment fragment) {
        AppMethodBeat.i(141417);
        if (fragment == null) {
            AppMethodBeat.o(141417);
            return;
        }
        switchFragmentInternalFarwardWithAnim(fragment, fragment.getId());
        AppMethodBeat.o(141417);
    }

    public void switchFragmentInternalFarwardWithAnim(Fragment fragment, int i2) {
        AppMethodBeat.i(141418);
        switchFragment(fragment, i2, false, true, R.anim.eq, R.anim.en);
        AppMethodBeat.o(141418);
    }

    public void switchFragmentInternalBackwardWithAnim(Fragment fragment) {
        AppMethodBeat.i(141419);
        switchFragmentInternalBackwardWithAnim(fragment, fragment.getId());
        AppMethodBeat.o(141419);
    }

    public void switchFragmentInternalBackwardWithAnim(Fragment fragment, int i2) {
        AppMethodBeat.i(141420);
        switchFragment(fragment, i2, false, true, R.anim.em, R.anim.er);
        AppMethodBeat.o(141420);
    }

    public void switchFragmentInternalBackwardWithAnimLeftSelfView(Fragment fragment, View view) {
        AppMethodBeat.i(141421);
        if (fragment == null) {
            AppMethodBeat.o(141421);
            return;
        }
        switchFragmentInternalBackwardWithAnimLeftSelfView(fragment, fragment.getId(), view);
        AppMethodBeat.o(141421);
    }

    public void switchFragmentInternalBackwardWithAnimLeftSelfView(Fragment fragment, int i2, View view) {
        AppMethodBeat.i(141422);
        switchFragment(fragment, i2, false, true, 0, R.anim.er);
        if (view == null) {
            AppMethodBeat.o(141422);
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.em);
        if (loadAnimation != null) {
            view.startAnimation(loadAnimation);
        }
        view.setVisibility(0);
        AppMethodBeat.o(141422);
    }

    public void switchFragmentActivity(Fragment fragment) {
        AppMethodBeat.i(141423);
        if (fragment == null) {
            AppMethodBeat.o(141423);
            return;
        }
        switchFragmentActivity(fragment, fragment.getId());
        AppMethodBeat.o(141423);
    }

    public void switchFragmentActivity(Fragment fragment, int i2) {
        AppMethodBeat.i(141424);
        switchFragment(fragment, i2, true, true, R.anim.dd, R.anim.di);
        this.record.add(new WeakReference<>((MMFragment) fragment));
        AppMethodBeat.o(141424);
    }

    public boolean popBackStackImmediate() {
        AppMethodBeat.i(141425);
        if (this.record.size() == 0) {
            AppMethodBeat.o(141425);
            return false;
        }
        this.record.remove(this.record.size() - 1);
        boolean popBackStackImmediate = getSupportFragmentManager().popBackStackImmediate();
        AppMethodBeat.o(141425);
        return popBackStackImmediate;
    }

    public void switchFragment(Fragment fragment, int i2, boolean z, boolean z2, int i3, int i4) {
        AppMethodBeat.i(141426);
        if (fragment == null || i2 == 0) {
            AppMethodBeat.o(141426);
            return;
        }
        g supportFragmentManager = getSupportFragmentManager();
        k beginTransaction = supportFragmentManager.beginTransaction();
        if (z2) {
            beginTransaction.u(i3, i4);
        }
        if (supportFragmentManager.findFragmentById(i2) == null) {
            beginTransaction.a(i2, fragment, fragment.getTag());
        } else if (fragment.isHidden()) {
            beginTransaction.b(fragment);
        }
        if (z) {
            beginTransaction.dY();
        }
        beginTransaction.commit();
        supportFragmentManager.executePendingTransactions();
        AppMethodBeat.o(141426);
    }

    public MMFragment getCurrentFragmet() {
        AppMethodBeat.i(141427);
        int size = this.record.size();
        if (size == 0) {
            AppMethodBeat.o(141427);
            return null;
        }
        MMFragment mMFragment = this.record.get(size - 1).get();
        if (mMFragment == null || !mMFragment.isShowing()) {
            AppMethodBeat.o(141427);
            return null;
        }
        AppMethodBeat.o(141427);
        return mMFragment;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(141428);
        if (Build.VERSION.SDK_INT < 11) {
            super.onSaveInstanceState(bundle);
        }
        AppMethodBeat.o(141428);
    }

    public static class a {
        public static int OHB = ogm;
        public static int OHC = ogn;
        public static int OHD = ogo;
        public static int OHE = ogp;
        public static int ogm;
        public static int ogn;
        public static int ogo;
        public static int ogp;

        public static void gIV() {
            int i2 = R.anim.s;
            AppMethodBeat.i(141403);
            y yVar = ae.gKy;
            boolean aoW = y.aoW();
            Log.i(MMFragmentActivity.TAG, "lm: setAnimationStyle swipbackType = ".concat(String.valueOf(aoW)));
            if (!aoW) {
                AppMethodBeat.o(141403);
                return;
            }
            boolean apl = com.tencent.mm.compatible.h.b.apl() & com.tencent.mm.compatible.util.d.oD(19);
            Log.i(MMFragmentActivity.TAG, "lm: setAnimationStyle supportSwipe = ".concat(String.valueOf(apl)));
            ogm = apl ? R.anim.eq : R.anim.dd;
            ogn = apl ? R.anim.en : R.anim.s;
            if (apl) {
                i2 = R.anim.em;
            }
            ogo = i2;
            ogp = apl ? R.anim.er : R.anim.di;
            OHB = ogm;
            OHC = ogn;
            OHD = ogo;
            OHE = ogp;
            AppMethodBeat.o(141403);
        }

        static {
            int i2;
            int i3 = R.anim.s;
            AppMethodBeat.i(141404);
            boolean apl = com.tencent.mm.compatible.h.b.apl() & com.tencent.mm.compatible.util.d.oD(19);
            ogm = apl ? R.anim.eq : R.anim.dd;
            ogn = apl ? R.anim.en : R.anim.s;
            if (apl) {
                i3 = R.anim.em;
            }
            ogo = i3;
            if (apl) {
                i2 = R.anim.er;
            } else {
                i2 = R.anim.di;
            }
            ogp = i2;
            AppMethodBeat.o(141404);
        }
    }

    public void putActivityOpenAnimation(int i2, int i3) {
        AppMethodBeat.i(141429);
        if (enableActivityAnimation()) {
            a.OHB = i2;
            a.OHC = i3;
        }
        super.overridePendingTransition(i2, i3);
        AppMethodBeat.o(141429);
    }

    public void putActivityCloseAnimation(int i2, int i3) {
        AppMethodBeat.i(141430);
        if (enableActivityAnimation()) {
            a.OHD = i2;
            a.OHE = i3;
        }
        super.overridePendingTransition(i2, i3);
        AppMethodBeat.o(141430);
    }

    public boolean enableActivityAnimation() {
        boolean z;
        AppMethodBeat.i(141431);
        Intent intent = getIntent();
        if (intent != null) {
            z = IntentUtil.getBooleanExtra(intent, EXTRA_USE_SYSTEM_DEFAULT_ENTER_EXIT_ANIM, false);
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(141431);
            return false;
        }
        AppMethodBeat.o(141431);
        return true;
    }

    /* access modifiers changed from: protected */
    public void initActivityOpenAnimation(Intent intent) {
        boolean z;
        AppMethodBeat.i(141432);
        if (enableActivityAnimation()) {
            ComponentName component = intent == null ? null : intent.getComponent();
            if (component != null) {
                String e2 = com.tencent.mm.ui.base.b.e(component);
                if ((com.tencent.mm.ui.base.b.blZ(e2) & 2) == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (ao.gJK()) {
                        super.overridePendingTransition(0, 0);
                        AppMethodBeat.o(141432);
                        return;
                    }
                    super.overridePendingTransition(a.OHB, a.OHC);
                    AppMethodBeat.o(141432);
                    return;
                } else if (!com.tencent.mm.ui.base.b.bmb(e2)) {
                    com.tencent.mm.ui.base.b.kb(this);
                    AppMethodBeat.o(141432);
                    return;
                } else {
                    com.tencent.mm.ui.base.b.ke(this);
                }
            }
        }
        AppMethodBeat.o(141432);
    }

    /* access modifiers changed from: protected */
    public void initActivityCloseAnimation() {
        boolean z = false;
        AppMethodBeat.i(141433);
        if (enableActivityAnimation()) {
            if (!com.tencent.mm.ui.base.b.bg(getClass())) {
                if ((com.tencent.mm.ui.base.b.bd(getClass()) & 4) != 0) {
                    z = true;
                }
                if (!z) {
                    com.tencent.mm.ui.base.b.kd(this);
                    AppMethodBeat.o(141433);
                    return;
                }
                com.tencent.mm.ui.base.b.ke(this);
            } else if (ao.gJK()) {
                super.overridePendingTransition(0, 0);
                AppMethodBeat.o(141433);
                return;
            } else {
                super.overridePendingTransition(a.OHD, a.OHE);
                AppMethodBeat.o(141433);
                return;
            }
        }
        AppMethodBeat.o(141433);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void finish() {
        AppMethodBeat.i(141434);
        super.finish();
        initActivityCloseAnimation();
        AppMethodBeat.o(141434);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    @TargetApi(16)
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        AppMethodBeat.i(141435);
        if (d.a(this, this.mIsPaused, intentArr, bundle)) {
            AppMethodBeat.o(141435);
            return;
        }
        super.startActivities(intentArr, bundle);
        initActivityOpenAnimation(null);
        AppMethodBeat.o(141435);
    }

    @TargetApi(11)
    public void startActivities(Intent[] intentArr) {
        AppMethodBeat.i(141436);
        super.startActivities(intentArr);
        initActivityOpenAnimation(null);
        AppMethodBeat.o(141436);
    }

    public void startActivity(Intent intent) {
        AppMethodBeat.i(141437);
        super.startActivity(intent);
        initActivityOpenAnimation(intent);
        AppMethodBeat.o(141437);
    }

    @TargetApi(16)
    public void startActivity(Intent intent, Bundle bundle) {
        AppMethodBeat.i(141438);
        super.startActivity(intent, bundle);
        initActivityOpenAnimation(intent);
        AppMethodBeat.o(141438);
    }

    @Override // android.support.v4.app.FragmentActivity
    public void startActivityForResult(Intent intent, int i2) {
        AppMethodBeat.i(141439);
        super.startActivityForResult(intent, i2);
        initActivityOpenAnimation(intent);
        AppMethodBeat.o(141439);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    @TargetApi(16)
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        AppMethodBeat.i(141440);
        if (d.a(this, this.mIsPaused, new Intent[]{intent}, Integer.valueOf(i2), bundle)) {
            AppMethodBeat.o(141440);
            return;
        }
        super.startActivityForResult(intent, i2, bundle);
        initActivityOpenAnimation(intent);
        AppMethodBeat.o(141440);
    }

    @Override // android.support.v4.app.FragmentActivity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i2) {
        AppMethodBeat.i(141441);
        super.startActivityFromFragment(fragment, intent, i2);
        initActivityOpenAnimation(intent);
        AppMethodBeat.o(141441);
    }

    @Override // android.support.v4.app.FragmentActivity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        AppMethodBeat.i(141442);
        if (d.a(this, this.mIsPaused, new Intent[]{intent}, fragment, Integer.valueOf(i2))) {
            AppMethodBeat.o(141442);
            return;
        }
        super.startActivityFromFragment(fragment, intent, i2, bundle);
        AppMethodBeat.o(141442);
    }

    public SwipeBackLayout getSwipeBackLayout() {
        return this.mSwipeBackLayout;
    }

    public boolean isSwiping() {
        return this.mSwiping;
    }

    public boolean isHideStatusBar() {
        AppMethodBeat.i(141444);
        if ((com.tencent.mm.ui.base.b.bd(getClass()) & 32) != 0) {
            AppMethodBeat.o(141444);
            return true;
        }
        AppMethodBeat.o(141444);
        return false;
    }

    public boolean supportNavigationSwipeBack() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean convertActivityFromTranslucent() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void initSwipeBack() {
        AppMethodBeat.i(141446);
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        this.mSwipeBackLayout = (SwipeBackLayout) LayoutInflater.from(this).inflate(R.layout.c1b, viewGroup, false);
        this.mSwipeBackLayout.init();
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().getDecorView().setBackgroundDrawable(null);
        View childAt = viewGroup.getChildAt(0);
        childAt.setBackgroundResource(R.color.ac_);
        viewGroup.removeView(childAt);
        this.mSwipeBackLayout.addView(childAt);
        this.mSwipeBackLayout.setContentView(childAt);
        viewGroup.addView(this.mSwipeBackLayout);
        this.mSwipeBackLayout.setSwipeGestureDelegate(this);
        AppMethodBeat.o(141446);
    }

    @Override // android.content.Context, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.app.Activity
    public Object getSystemService(String str) {
        AppMethodBeat.i(141447);
        if (("clipboard".equals(str) || "power".equals(str)) && getApplicationContext() != null) {
            Object systemService = getApplicationContext().getSystemService(str);
            AppMethodBeat.o(141447);
            return systemService;
        }
        Object systemService2 = super.getSystemService(str);
        if ("layout_inflater".equals(str)) {
            LayoutInflater b2 = aa.b((LayoutInflater) systemService2);
            AppMethodBeat.o(141447);
            return b2;
        }
        AppMethodBeat.o(141447);
        return systemService2;
    }

    @Override // android.support.v7.app.AppCompatActivity
    public Resources getResources() {
        AppMethodBeat.i(141448);
        if (getAssets() == null || MMApplicationContext.getResources() == null) {
            Resources resources = super.getResources();
            AppMethodBeat.o(141448);
            return resources;
        }
        if (!this.updateResource || this.customResources == null) {
            Resources resources2 = getBaseContext().getResources();
            this.customResources = MMApplicationContext.getResources();
            if ((this.customResources instanceof com.tencent.mm.cc.b) && resources2 != null) {
                com.tencent.mm.cc.b bVar = (com.tencent.mm.cc.b) this.customResources;
                Configuration g2 = bVar.NDo.g(resources2.getConfiguration());
                com.tencent.mm.cc.c.a(g2, ao.f(this.customResources));
                bVar.getConfiguration().updateFrom(g2);
                this.customResources = bVar;
                this.updateResource = true;
            }
        }
        Resources resources3 = this.customResources;
        AppMethodBeat.o(141448);
        return resources3;
    }

    public final Resources getOriginalResources() {
        AppMethodBeat.i(141449);
        Resources resources = super.getResources();
        AppMethodBeat.o(141449);
        return resources;
    }

    public void setRequestedOrientation(int i2) {
        AppMethodBeat.i(141450);
        if (!AndroidOSafety.safety(this, i2)) {
            Log.e(TAG, "AndroidOSafety.safety false ignore setRequestedOrientation %s for activity %s", Integer.valueOf(i2), this);
            AppMethodBeat.o(141450);
            return;
        }
        try {
            super.setRequestedOrientation(i2);
            AppMethodBeat.o(141450);
        } catch (Throwable th) {
            Log.printErrStackTrace(TAG, th, "AndroidOSafety.safety uncaught", new Object[0]);
            AppMethodBeat.o(141450);
        }
    }

    @Override // com.tencent.mm.ui.widget.h.a
    public void onSwipe(float f2) {
        AppMethodBeat.i(141451);
        Log.v("ashutest", "ashutest::on swipe %f, duration %d", Float.valueOf(f2), 260L);
        if (this.mContentViewForSwipeBack == null) {
            this.mContentViewForSwipeBack = ao.a(getWindow(), getSupportActionBar() != null ? getSupportActionBar().getCustomView() : null);
        }
        View view = this.mContentViewForSwipeBack;
        if (Float.compare(1.0f, f2) <= 0) {
            j.q(view, 0.0f);
            AppMethodBeat.o(141451);
            return;
        }
        j.q(view, (((float) view.getWidth()) / 3.5f) * (1.0f - f2) * -1.0f);
        AppMethodBeat.o(141451);
    }

    @Override // com.tencent.mm.ui.widget.h.a
    public void onSettle(boolean z, int i2) {
        long j2 = 130;
        AppMethodBeat.i(141452);
        Log.v("ashutest", "ashutest:: on settle %B, speed %d", Boolean.valueOf(z), Integer.valueOf(i2));
        if (this.mContentViewForSwipeBack == null) {
            this.mContentViewForSwipeBack = ao.a(getWindow(), getSupportActionBar().getCustomView());
        }
        View view = this.mContentViewForSwipeBack;
        if (z) {
            if (i2 <= 0) {
                j2 = 260;
            }
            j.a(view, j2, 0.0f, null);
            AppMethodBeat.o(141452);
            return;
        }
        if (i2 <= 0) {
            j2 = 260;
        }
        j.a(view, j2, ((float) (view.getWidth() * -1)) / 3.5f, null);
        AppMethodBeat.o(141452);
    }

    @Override // com.tencent.mm.ui.widget.SwipeBackLayout.a
    public void onSwipeBack() {
        AppMethodBeat.i(141453);
        if (!isFinishing()) {
            finish();
        }
        getWindow().getDecorView().setVisibility(8);
        overridePendingTransition(0, 0);
        this.mSwiping = false;
        AppMethodBeat.o(141453);
    }

    @Override // com.tencent.mm.ui.widget.SwipeBackLayout.a
    public void onCancel() {
        this.mSwiping = false;
    }

    @Override // com.tencent.mm.ui.widget.SwipeBackLayout.a
    public void onDrag() {
        this.mSwiping = true;
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(141454);
        if (isSupportNavigationSwipeBack()) {
            SwipeBackLayout swipeBackLayout = getSwipeBackLayout();
            if (keyEvent.getKeyCode() == 4 && swipeBackLayout != null && swipeBackLayout.gqI()) {
                Log.w("ashutest", "ashutest::IS SwipeBack ING, ignore KeyBack Event");
                AppMethodBeat.o(141454);
                return true;
            }
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(141454);
        return dispatchKeyEvent;
    }

    @Override // com.tencent.mm.ui.widget.h.a
    public boolean forceRemoveNoMatchOnPath() {
        return false;
    }

    public boolean isNfcFilterEnabled() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final class c {
        NfcAdapter OHF;
        private PendingIntent OHG;
        private IntentFilter[] OHH;
        private String[][] OHI;

        private c() {
            this.OHF = null;
        }

        /* synthetic */ c(MMFragmentActivity mMFragmentActivity, byte b2) {
            this();
        }

        public final void onResume() {
            AppMethodBeat.i(205123);
            if (this.OHF != null) {
                if (this.OHG == null || this.OHH == null || this.OHI == null) {
                    init();
                }
                try {
                    Log.i(MMFragmentActivity.TAG, "[NFC] enableForegroundDispatch");
                    this.OHF.enableForegroundDispatch(MMFragmentActivity.this, this.OHG, this.OHH, this.OHI);
                    AppMethodBeat.o(205123);
                    return;
                } catch (Exception e2) {
                    Log.e(MMFragmentActivity.TAG, "lo-nfc-onResume: exp:" + e2.getLocalizedMessage());
                }
            }
            AppMethodBeat.o(205123);
        }

        /* access modifiers changed from: package-private */
        public final void init() {
            AppMethodBeat.i(141405);
            Intent intent = new Intent();
            intent.setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI");
            intent.addFlags(536870912);
            this.OHG = PendingIntent.getActivity(MMFragmentActivity.this, 0, intent, 0);
            IntentFilter intentFilter = new IntentFilter("android.nfc.action.NDEF_DISCOVERED");
            try {
                intentFilter.addDataType("*/*");
                IntentFilter intentFilter2 = new IntentFilter("android.nfc.action.TECH_DISCOVERED");
                intentFilter2.addDataScheme("vnd.android.nfc");
                this.OHH = new IntentFilter[]{intentFilter, intentFilter2, new IntentFilter("android.nfc.action.TAG_DISCOVERED")};
                this.OHI = new String[][]{new String[]{NfcA.class.getName(), IsoDep.class.getName()}};
                AppMethodBeat.o(141405);
            } catch (IntentFilter.MalformedMimeTypeException e2) {
                RuntimeException runtimeException = new RuntimeException("fail", e2);
                AppMethodBeat.o(141405);
                throw runtimeException;
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        ViewGroup viewGroup;
        View findViewById;
        AppMethodBeat.i(141455);
        super.onConfigurationChanged(configuration);
        if (!(getSupportActionBar() == null || (viewGroup = (ViewGroup) findViewById(R.id.bl6)) == null || (findViewById = viewGroup.findViewById(R.id.c7)) == null || !(findViewById instanceof Toolbar))) {
            Toolbar toolbar = (Toolbar) findViewById;
            ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = com.tencent.mm.compatible.util.a.cy(this);
            }
            toolbar.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(141455);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        AppMethodBeat.i(141456);
        if (getCurrentFragmet() == null || !getCurrentFragmet().interceptSupportInvalidateOptionsMenu()) {
            super.supportInvalidateOptionsMenu();
            AppMethodBeat.o(141456);
            return;
        }
        AppMethodBeat.o(141456);
    }

    public WindowManager getWindowManager() {
        AppMethodBeat.i(141457);
        if (!isDestroyed()) {
            WindowManager windowManager = super.getWindowManager();
            AppMethodBeat.o(141457);
            return windowManager;
        }
        try {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace != null && stackTrace.length >= 2 && stackTrace[1].getMethodName().equals("handleDestroyActivity")) {
                WindowManager a2 = com.tencent.mm.plugin.crashfix.b.a.a.a(super.getWindowManager());
                AppMethodBeat.o(141457);
                return a2;
            }
        } catch (Throwable th) {
            Log.e(TAG, th.getMessage());
        }
        WindowManager windowManager2 = super.getWindowManager();
        AppMethodBeat.o(141457);
        return windowManager2;
    }

    public void setMMOnFragmentActivityResult(b bVar) {
        this.onActResult = bVar;
    }

    public void mmStartActivityForResult(b bVar, Intent intent, int i2) {
        AppMethodBeat.i(141458);
        this.onActResult = bVar;
        startActivityForResult(intent, i2);
        AppMethodBeat.o(141458);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(141459);
        super.onActivityResult(i2, i3, intent);
        if (this.onActResult != null) {
            this.onActResult.d(i2, i3, intent);
        }
        this.onActResult = null;
        AppMethodBeat.o(141459);
    }

    public void hideVKB() {
        AppMethodBeat.i(205124);
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            hideVKB(getWindow().getDecorView());
            AppMethodBeat.o(205124);
            return;
        }
        hideVKB(currentFocus);
        AppMethodBeat.o(205124);
    }

    public void hideVKB(View view) {
        AppMethodBeat.i(205125);
        if (view == null) {
            AppMethodBeat.o(205125);
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.o(205125);
            return;
        }
        IBinder windowToken = view.getWindowToken();
        if (windowToken == null) {
            AppMethodBeat.o(205125);
            return;
        }
        try {
            inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
            AppMethodBeat.o(205125);
        } catch (IllegalArgumentException e2) {
            Log.e(TAG, "hide VKB(View) exception %s", e2);
            AppMethodBeat.o(205125);
        }
    }

    public void showVKB() {
        AppMethodBeat.i(205126);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.o(205126);
            return;
        }
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            AppMethodBeat.o(205126);
        } else if (currentFocus.getWindowToken() == null) {
            AppMethodBeat.o(205126);
        } else {
            inputMethodManager.toggleSoftInput(0, 2);
            AppMethodBeat.o(205126);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public Set<Class<? extends UIComponent>> importUIComponents() {
        return null;
    }

    public boolean isSupportNavigationSwipeBack() {
        AppMethodBeat.i(141443);
        if (!com.tencent.mm.compatible.util.d.oD(19) || !com.tencent.mm.compatible.h.b.apl()) {
            AppMethodBeat.o(141443);
            return false;
        } else if (!supportNavigationSwipeBack() || !com.tencent.mm.ui.base.b.bf(getClass())) {
            AppMethodBeat.o(141443);
            return false;
        } else {
            AppMethodBeat.o(141443);
            return true;
        }
    }

    public boolean initNavigationSwipeBack() {
        boolean z;
        AppMethodBeat.i(141445);
        if (com.tencent.mm.compatible.util.d.oD(19)) {
            if (!com.tencent.mm.ui.base.b.bf(getClass()) || !convertActivityFromTranslucent()) {
                if ((com.tencent.mm.ui.base.b.bd(getClass()) & 16) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && MMHandlerThread.isMainThread()) {
                    com.tencent.mm.ui.base.b.bp(this);
                }
            } else if (MMHandlerThread.isMainThread()) {
                com.tencent.mm.ui.base.b.bp(this);
            }
        }
        if (isSupportNavigationSwipeBack()) {
            initSwipeBack();
            AppMethodBeat.o(141445);
            return true;
        }
        AppMethodBeat.o(141445);
        return false;
    }
}
