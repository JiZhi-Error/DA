package com.tencent.mm.framework.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.kinda.framework.app.MainFragment;
import com.tencent.kinda.framework.module.impl.KindaCacheServiceImpl;
import com.tencent.kinda.framework.widget.base.BaseFrActivity;
import com.tencent.kinda.framework.widget.base.BaseFragment;
import com.tencent.kinda.framework.widget.base.FrLifeController;
import com.tencent.kinda.framework.widget.base.IEventFragment;
import com.tencent.kinda.framework.widget.base.KindaActionBarColorManager;
import com.tencent.kinda.framework.widget.tools.ActivityController;
import com.tencent.kinda.framework.widget.tools.ConstantsKinda;
import com.tencent.kinda.gen.VoidBoolStringI32StringCallback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.li;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.wallet_core.ui.f;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.OnPasswdInputListener;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@com.tencent.mm.ui.base.a(1)
public class UIPageFragmentActivity extends BaseFrActivity implements IEventFragment, g {
    private static HashMap<Integer, a> hgC = new HashMap<>();
    private boolean crv;
    private h gyh;
    private boolean hgA = false;
    public AtomicInteger hgB = new AtomicInteger(5);
    public boolean hgt = true;
    private boolean hgu;
    public FrLifeController hgv;
    public VoidBoolStringI32StringCallback hgw = null;
    public VoidCallback hgx = null;
    private boolean hgy;
    private int hgz = 0;
    KindaCacheServiceImpl kindaCacheService = new KindaCacheServiceImpl();

    public interface a {
        void handle(int i2, Intent intent);
    }

    public UIPageFragmentActivity() {
        AppMethodBeat.i(214579);
        AppMethodBeat.o(214579);
    }

    static /* synthetic */ boolean c(UIPageFragmentActivity uIPageFragmentActivity) {
        AppMethodBeat.i(214600);
        boolean awX = uIPageFragmentActivity.awX();
        AppMethodBeat.o(214600);
        return awX;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.kinda.framework.widget.base.BaseFrActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.i(214580);
        this.hgy = getIntent().getBooleanExtra(ConstantsKinda.CHEEK_WALLET_LOCK, false);
        Log.d("MicroMsg.UIPageFragmentActivity", "MainFragmentActivity oncreate %s", this);
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(782, 37);
        this.crv = ao.isDarkMode();
        Log.i("MicroMsg.UIPageFragmentActivity", "isDarkMode:%s", Boolean.valueOf(ao.isDarkMode()));
        this.hgv = new FrLifeController(this);
        this.hgu = getIntent().getBooleanExtra("key_support_swipe_back", true);
        super.onCreate(bundle);
        if (this.kindaCacheService != null) {
            Log.i("MicroMsg.UIPageFragmentActivity", "force kindaShowingDialog is false");
            this.kindaCacheService.setBool("kindaShowingDialog", false, 0);
        }
        if (this.hgy) {
            z = ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
        }
        if (!z) {
            t(getIntent().getBundleExtra("intent_bundle"));
        }
        setTenpayKBStateCallBackListener(new BaseFrActivity.IWalletTenpayKBStateCallBackListener() {
            /* class com.tencent.mm.framework.app.UIPageFragmentActivity.AnonymousClass1 */

            @Override // com.tencent.kinda.framework.widget.base.BaseFrActivity.IWalletTenpayKBStateCallBackListener
            public final void onCallBackKinda(boolean z, float f2) {
                AppMethodBeat.i(214576);
                BaseFragment current = UIPageFragmentActivity.this.hgv.getCurrent();
                if (f2 == 0.0f) {
                    f2 = 230.0f;
                }
                if (current != null) {
                    if (z) {
                        current.onKeyboardShow(true, com.tencent.mm.cb.a.E(UIPageFragmentActivity.this.getContext(), (int) f2));
                        if (!UIPageFragmentActivity.this.hgA) {
                            UIPageFragmentActivity.this.hgA = UIPageFragmentActivity.c(UIPageFragmentActivity.this);
                            AppMethodBeat.o(214576);
                            return;
                        }
                    } else {
                        current.onKeyboardShow(false, com.tencent.mm.cb.a.E(UIPageFragmentActivity.this.getContext(), (int) f2));
                    }
                }
                AppMethodBeat.o(214576);
            }
        });
        this.gyh = new h(getContext());
        this.gyh.Quk = this;
        AppMethodBeat.o(214580);
    }

    @Override // com.tencent.mm.ui.tools.g
    public final void y(int i2, boolean z) {
        AppMethodBeat.i(214581);
        Log.d("MicroMsg.UIPageFragmentActivity", "onKeyboardHeightChanged %s", Integer.valueOf(i2));
        BaseFragment current = this.hgv.getCurrent();
        if (current == null) {
            AppMethodBeat.o(214581);
            return;
        }
        if (i2 > 0 && this.hgz <= 0) {
            this.hgz = i2;
            current.onKeyboardShow(true, com.tencent.mm.cb.a.E(getContext(), i2));
            Log.d("MicroMsg.UIPageFragmentActivity", "show keyboard %s", Integer.valueOf(i2));
        }
        if (i2 <= 0 && this.hgz > 0) {
            this.hgz = i2;
            current.onKeyboardShow(false, com.tencent.mm.cb.a.E(getContext(), i2));
            Log.d("MicroMsg.UIPageFragmentActivity", "hide keyboard %s", Integer.valueOf(i2));
        }
        AppMethodBeat.o(214581);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFrActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(214582);
        Log.i("MicroMsg.UIPageFragmentActivity", "onResume");
        super.onResume();
        if (this.hgy) {
            com.tencent.mm.plugin.walletlock.a.b bVar = (com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class);
            bVar.a(this, bVar.fUE(), null);
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(782, 40);
        if (this.hgv == null || !this.hgv.processCallback(3) || !awW()) {
            TenpaySecureEditText.setSalt(f.hhV());
        } else {
            finish();
        }
        if (this.gyh != null) {
            this.gyh.start();
        }
        this.hgv.setTinyCallbackTag(true);
        AppMethodBeat.o(214582);
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFrActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(214583);
        AppMethodBeat.at(this, z);
        super.onWindowFocusChanged(z);
        if (this.gyh != null) {
            this.gyh.start();
        }
        AppMethodBeat.o(214583);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(214584);
        Log.i("MicroMsg.UIPageFragmentActivity", "onPause");
        super.onPause();
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(782, 42);
        EventCenter.instance.publish(new li());
        if (this.gyh != null) {
            this.gyh.close();
        }
        AppMethodBeat.o(214584);
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFrActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(214585);
        super.onDestroy();
        KindaActionBarColorManager.getInstance().reset();
        this.hgv.onActivityDestroy();
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(782, 44);
        d.INSTANCE.sw(false);
        AppMethodBeat.o(214585);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b50;
    }

    public final void t(Bundle bundle) {
        AppMethodBeat.i(214586);
        if (bundle == null) {
            AppMethodBeat.o(214586);
            return;
        }
        BaseFragment resolveFragment = ActivityController.resolveFragment(bundle);
        if (resolveFragment != null) {
            boolean z = bundle.getBoolean(ConstantsKinda.INTENT_WEBVIEW, false);
            boolean z2 = bundle.getBoolean(ConstantsKinda.INTENT_TINYAPP, false);
            if (z && (resolveFragment instanceof MainFragment)) {
                this.hgv.startWebViewUIPage(bundle, (MainFragment) resolveFragment);
                AppMethodBeat.o(214586);
            } else if (!z2 || !(resolveFragment instanceof MainFragment)) {
                this.hgv.addFragment(resolveFragment);
                AppMethodBeat.o(214586);
            } else {
                this.hgv.startTinyAppUIPage(bundle, (MainFragment) resolveFragment);
                AppMethodBeat.o(214586);
            }
        } else {
            super.onBackPressed();
            AppMethodBeat.o(214586);
        }
    }

    @Override // com.tencent.kinda.framework.widget.base.IEventFragment
    public boolean addFragment(BaseFragment baseFragment) {
        AppMethodBeat.i(214587);
        Log.i("MicroMsg.UIPageFragmentActivity", "addFragment: ".concat(String.valueOf(baseFragment)));
        boolean addFragment = this.hgv.addFragment(baseFragment);
        AppMethodBeat.o(214587);
        return addFragment;
    }

    @Override // com.tencent.kinda.framework.widget.base.IEventFragment
    public boolean removeModal(BaseFragment baseFragment) {
        AppMethodBeat.i(214588);
        if (this.hgv.removeModal(baseFragment)) {
            Log.i("MicroMsg.UIPageFragmentActivity", "removeModal, There is still Fragment, and UIPageFragmentActivity hold.");
            AppMethodBeat.o(214588);
            return true;
        }
        Log.i("MicroMsg.UIPageFragmentActivity", "removeModal, hasOpenH5OrTinyApp: %b, kindaShowingDialog: %b", Boolean.valueOf(this.hgv.hasOpenH5OrTinyApp()), Boolean.valueOf(this.kindaCacheService.getBool("kindaShowingDialog")));
        if (!this.hgv.hasOpenH5OrTinyApp() && !this.kindaCacheService.getBool("kindaShowingDialog")) {
            Log.i("MicroMsg.UIPageFragmentActivity", "removeModal, finish the UIPageFragmentActivity.");
            finish();
        }
        AppMethodBeat.o(214588);
        return false;
    }

    @Override // com.tencent.kinda.framework.widget.base.IEventFragment
    public boolean popFragment() {
        AppMethodBeat.i(214589);
        if (this.hgv.popFragment()) {
            Log.i("MicroMsg.UIPageFragmentActivity", "popFragment, There is still Fragment, and UIPageFragmentActivity hold.");
            AppMethodBeat.o(214589);
            return true;
        }
        Log.i("MicroMsg.UIPageFragmentActivity", "popFragment, finish the UIPageFragmentActivity.");
        finish();
        AppMethodBeat.o(214589);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(214590);
        Log.i("MicroMsg.UIPageFragmentActivity", "onBackPressed");
        if (!this.hgv.getCurrent().onBackPressed()) {
            popFragment();
        }
        AppMethodBeat.o(214590);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
    public void onSwipeBack() {
        AppMethodBeat.i(214591);
        Log.d("MicroMsg.UIPageFragmentActivity", "onSwipeBack onSwipeBack %s %s", Boolean.valueOf(this.hgu), this);
        if (!this.hgu) {
            AppMethodBeat.o(214591);
            return;
        }
        super.onSwipeBack();
        AppMethodBeat.o(214591);
    }

    static {
        AppMethodBeat.i(214602);
        AppMethodBeat.o(214602);
    }

    public static void a(int i2, a aVar) {
        AppMethodBeat.i(214592);
        hgC.put(Integer.valueOf(i2), aVar);
        AppMethodBeat.o(214592);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Boolean bool;
        AppMethodBeat.i(214593);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.UIPageFragmentActivity", "onActivityResult requestCode: " + i2 + ", resultCode: " + i3 + ", data: " + intent);
        boolean z = false;
        if (i2 == 4 && intent != null) {
            int intExtra = intent.getIntExtra("err_code", 0);
            int intExtra2 = intent.getIntExtra("scene", 0);
            int intExtra3 = intent.getIntExtra("countFace", 0);
            long longExtra = intent.getLongExtra("totalTime", 0);
            int intExtra4 = intent.getIntExtra("err_type", 6);
            Log.i("MicroMsg.UIPageFragmentActivity", "errCode： ".concat(String.valueOf(intExtra)));
            Log.i("MicroMsg.UIPageFragmentActivity", "scene： ".concat(String.valueOf(intExtra2)));
            Log.i("MicroMsg.UIPageFragmentActivity", "countFace： ".concat(String.valueOf(intExtra3)));
            Log.i("MicroMsg.UIPageFragmentActivity", "totalTime： ".concat(String.valueOf(longExtra)));
            Log.i("MicroMsg.UIPageFragmentActivity", "errorType： ".concat(String.valueOf(intExtra4)));
            if (i3 == -1) {
                Log.i("MicroMsg.UIPageFragmentActivity", "resultCode：RESULT_OK");
                if (!(this.hgw == null || intent.getExtras() == null)) {
                    this.hgw.call(false, intent.getExtras().getString("token"), intExtra, "");
                    this.hgw = null;
                }
            } else {
                if (!(this.hgw == null || intent.getExtras() == null)) {
                    String string = intent.getExtras().getString("click_other_verify_btn");
                    boolean z2 = !Util.isNullOrNil(string) && string.equalsIgnoreCase("yes");
                    Log.i("MicroMsg.UIPageFragmentActivity", "isClickOtherVerify: %s", string);
                    if (z2) {
                        Log.i("MicroMsg.UIPageFragmentActivity", "check face failed, click other verify");
                        this.hgw.call(true, "", intExtra, "");
                        this.hgw = null;
                    }
                }
                if (i3 == 0) {
                    Log.i("MicroMsg.UIPageFragmentActivity", "resultCode：RESULT_CANCELED");
                    if (this.hgx != null) {
                        this.hgx.call();
                        this.hgx = null;
                    }
                }
            }
            z = true;
        } else if (this.hgv != null && this.hgv.processCallback(i2) && awW()) {
            finish();
            AppMethodBeat.o(214593);
            return;
        }
        if (this.hgv == null || this.hgv.getFragmentListSize() > 0) {
            if (!z) {
                a aVar = hgC.get(Integer.valueOf(i2));
                if (aVar != null) {
                    aVar.handle(i3, intent);
                    bool = Boolean.TRUE;
                } else {
                    bool = Boolean.FALSE;
                }
                if (bool.booleanValue()) {
                    AppMethodBeat.o(214593);
                    return;
                }
            }
            AppMethodBeat.o(214593);
            return;
        }
        finish();
        AppMethodBeat.o(214593);
    }

    @Override // com.tencent.mm.ui.widget.h.a, com.tencent.mm.ui.MMFragmentActivity
    public void onSwipe(float f2) {
        AppMethodBeat.i(214594);
        Log.i("MicroMsg.UIPageFragmentActivity", "onSwipe %s", Float.valueOf(f2));
        super.onSwipe(f2);
        AppMethodBeat.o(214594);
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public boolean convertActivityFromTranslucent() {
        return false;
    }

    public final boolean awW() {
        AppMethodBeat.i(214595);
        if (this.hgv == null) {
            Log.i("MicroMsg.UIPageFragmentActivity", "shouldFinish, controller is null!");
        } else {
            Log.i("MicroMsg.UIPageFragmentActivity", "shouldFinish, fragment size: ", Integer.valueOf(this.hgv.getFragmentListSize()));
        }
        if (this.hgv == null || this.hgv.getFragmentListSize() != 0) {
            AppMethodBeat.o(214595);
            return false;
        }
        AppMethodBeat.o(214595);
        return true;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(214596);
        bundle.putBoolean("key_dark_mode_state", this.crv);
        Log.i("MicroMsg.UIPageFragmentActivity", "onSaveInstanceState，isDarkMode:%s", Boolean.valueOf(this.crv));
        super.onSaveInstanceState(bundle);
        AppMethodBeat.o(214596);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public void onRestoreInstanceState(Bundle bundle) {
        AppMethodBeat.i(214597);
        boolean z = bundle.getBoolean("key_dark_mode_state");
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_kinda_darkmode_change_adaptation, true);
        Log.i("MicroMsg.UIPageFragmentActivity", "onRestoreInstanceState，lastDarkMode:%s  nowDarkMode:%s,svgconfig:%s", Boolean.valueOf(z), Boolean.valueOf(ao.isDarkMode()), Boolean.valueOf(a2));
        if (a2 && (ao.isDarkMode() ^ z)) {
            finish();
        }
        super.onRestoreInstanceState(bundle);
        AppMethodBeat.o(214597);
    }

    @Override // com.tencent.kinda.framework.widget.base.BaseFrActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(214598);
        super.finish();
        Log.i("MicroMsg.UIPageFragmentActivity", "finish onlyModal:" + this.hgt);
        if (this.hgt) {
            super.overridePendingTransition(0, 0);
        }
        AppMethodBeat.o(214598);
    }

    /* access modifiers changed from: package-private */
    public static class b implements MyKeyboardWindow.OnTouchListener {
        com.tencent.i.a.f hgG;
        com.tencent.i.a.g hgH;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        @Override // com.tenpay.android.wechat.MyKeyboardWindow.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(214578);
            if (this.hgG != null) {
                this.hgG.a(this.hgH, motionEvent);
            }
            AppMethodBeat.o(214578);
            return false;
        }
    }

    private boolean awX() {
        AppMethodBeat.i(214599);
        MyKeyboardWindow keyboard = getKeyboard();
        final TenpaySecureEditText tenpaySecureEditText = getTenpaySecureEditText();
        if (keyboard == null || tenpaySecureEditText == null) {
            Log.i("MicroMsg.UIPageFragmentActivity", "Keyboard or EditText not found");
            AppMethodBeat.o(214599);
            return false;
        }
        final b bVar = new b((byte) 0);
        keyboard.setOnTouchListener(bVar);
        d.INSTANCE.a(new com.tencent.mm.plugin.normsg.a.b() {
            /* class com.tencent.mm.framework.app.UIPageFragmentActivity.AnonymousClass2 */

            @Override // com.tencent.i.a.g
            public final boolean a(com.tencent.i.a.f fVar) {
                b bVar = bVar;
                bVar.hgG = fVar;
                bVar.hgH = this;
                return true;
            }
        });
        tenpaySecureEditText.setOnPasswdInputListener(new OnPasswdInputListener() {
            /* class com.tencent.mm.framework.app.UIPageFragmentActivity.AnonymousClass3 */

            @Override // com.tenpay.android.wechat.OnPasswdInputListener
            public final void onDone() {
                AppMethodBeat.i(214577);
                if (tenpaySecureEditText.getEditState() == TenpaySecureEditText.EditState.PASSWORD) {
                    UIPageFragmentActivity.ej(true);
                    AppMethodBeat.o(214577);
                    return;
                }
                UIPageFragmentActivity.ej(false);
                AppMethodBeat.o(214577);
            }
        });
        AppMethodBeat.o(214599);
        return true;
    }

    static /* synthetic */ void ej(boolean z) {
        AppMethodBeat.i(214601);
        d.INSTANCE.sw(z);
        AppMethodBeat.o(214601);
    }
}
