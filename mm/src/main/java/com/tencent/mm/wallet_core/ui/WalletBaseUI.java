package com.tencent.mm.wallet_core.ui;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.deviceinfo.l;
import com.tencent.mm.g.a.pi;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.t;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.c;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class WalletBaseUI extends MMSecDataActivity implements i, f {
    public static final int CLEAN_UI_DATA_ACTION_CODE_CLEAN_PASSWORD = 1;
    public static final int CLEAN_UI_DATA_ACTION_CODE_DEFAULT = 0;
    public static final int DIALOG_ID_CONFIRM_FINISH = 1000;
    public static final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = a.fromDPToPix(MMApplicationContext.getContext(), 270);
    private static final String TAG = "MicroMsg.WalletBaseUI";
    private static Set<String> mLockSet = new HashSet();
    private boolean _hasFinish = false;
    private MenuItem.OnMenuItemClickListener backListener;
    private LinkedList<k> callbacks = new LinkedList<>();
    public boolean isVKBFirstTimeShown = false;
    private Bundle mBundle = new Bundle();
    private s mCurrentNetScene = null;
    private boolean mIsAuthDoing;
    public View mKBLayout;
    public MyKeyboardWindow mKeyboard;
    public boolean mKindaEnable;
    private g mNetController = null;
    public com.tencent.mm.wallet_core.d.i mNetSceneMgr = null;
    private IListener<pi> mPayLoopInterruptListener = new IListener<pi>() {
        /* class com.tencent.mm.wallet_core.ui.WalletBaseUI.AnonymousClass1 */

        {
            AppMethodBeat.i(160909);
            this.__eventId = pi.class.getName().hashCode();
            AppMethodBeat.o(160909);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(pi piVar) {
            AppMethodBeat.i(72962);
            if (1 == piVar.dVr.ret) {
                WalletBaseUI.this.finish();
            }
            AppMethodBeat.o(72962);
            return false;
        }
    };
    public int mPayResultType = 0;
    private d mProcess = null;
    private d.a mProcessEnd;
    private Dialog mProgressDialog;
    private a mTenpayKBStateListener;
    private Dialog mTipDialog = null;
    public WcPayKeyboard mWcKeyboard;
    private MenuItem.OnMenuItemClickListener nextListener;

    public abstract boolean onSceneEnd(int i2, int i3, String str, q qVar);

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public Bundle getInput() {
        return this.mBundle;
    }

    public String getPayReqKey() {
        PayInfo payInfo;
        if (this.mBundle == null || (payInfo = (PayInfo) this.mBundle.getParcelable("key_pay_info")) == null) {
            return "";
        }
        return payInfo.dDL;
    }

    public void forceCancel() {
        Log.d(TAG, "cancelforceScene");
        this.mNetSceneMgr.forceCancel();
        finish();
    }

    public void setmPayResultType(int i2) {
        this.mPayResultType = i2;
    }

    /* access modifiers changed from: protected */
    public boolean shouldEnsureSoterConnection() {
        return false;
    }

    public void keepProcessEnd(d.a aVar) {
        this.mProcessEnd = aVar;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        if (needLockPage()) {
            lockPage();
        }
        shouldFixStatusBar();
        if (shouldEnsureSoterConnection()) {
            ((com.tencent.mm.plugin.wxpay.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
            com.tencent.soter.a.a.hlD();
        }
        super.onCreate(bundle);
        setStatusColor();
        if (!com.tencent.mm.kernel.g.aAc()) {
            Log.e(TAG, "hy: account not ready. finish now");
            h.a((Context) this, getString(R.string.i5f), "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.wallet_core.ui.WalletBaseUI.AnonymousClass10 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(72969);
                    com.tencent.mm.wallet_core.a.c(WalletBaseUI.this, null, -10000);
                    AppMethodBeat.o(72969);
                }
            });
        }
        this.mNetSceneMgr = new com.tencent.mm.wallet_core.d.i(this, this);
        this.mNetSceneMgr.addSceneEndListener(385);
        this.mNetSceneMgr.addSceneEndListener(1518);
        this.mPayLoopInterruptListener.alive();
        Log.d(TAG, "current process:" + getIntent().getIntExtra("process_id", 0));
        d by = com.tencent.mm.wallet_core.a.by(this);
        if (by != null) {
            this.mNetSceneMgr.mProcessName = by.dKC();
            by.a(this);
        }
        Log.d(TAG, "proc ".concat(String.valueOf(by)));
        this.mBundle = com.tencent.mm.wallet_core.a.bx(this);
        if (this.mBundle == null) {
            this.mBundle = new Bundle();
        }
        this.mNetSceneMgr.mBundle = this.mBundle;
        if (checkProcLife() && !com.tencent.mm.wallet_core.a.bw(this)) {
            Log.e(TAG, "Activity extends WalletBaseUI but not in process!!!");
        }
        if (getLayoutId() > 0) {
            String subTitle = getSubTitle();
            if (!Util.isNullOrNil(subTitle)) {
                setMMSubTitle(subTitle);
            }
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.wallet_core.ui.WalletBaseUI.AnonymousClass11 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(72970);
                WalletBaseUI.this.mPayResultType = 4;
                if (WalletBaseUI.this.needConfirmFinish()) {
                    WalletBaseUI.this.hideVKB();
                    WalletBaseUI.this.showDialog(1000);
                } else {
                    WalletBaseUI.this.finish();
                }
                AppMethodBeat.o(72970);
                return true;
            }
        });
        this.mNetController = getNetController();
        if (this.mNetController == null || !this.mNetController.A(new Object[0])) {
            setContentViewVisibility();
        } else {
            setContentViewVisibility(4);
        }
        dispatchOnCreate();
        b.hgC();
        this.mKindaEnable = b.b(b.a.clicfg_kinda_open, true);
        Log.i(TAG, "old id: %s, new id: %s", (String) l.aol().get(256), com.tencent.mm.compatible.deviceinfo.q.aoG());
    }

    public boolean hasFinish() {
        return this._hasFinish;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        super.finish();
        this._hasFinish = true;
    }

    /* access modifiers changed from: protected */
    public void shouldFixStatusBar() {
    }

    /* access modifiers changed from: protected */
    public void setStatusColor() {
        setActionbarColor(getActionbarColor());
    }

    private void setContentViewVisibility() {
        if (getLayoutId() <= 0) {
            setContentViewVisibility(4);
        } else if (isTransparent()) {
            setContentViewVisibility(4);
        } else {
            setContentViewVisibility(0);
        }
    }

    public int getContentViewVisibility() {
        return getContentView().getVisibility();
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void setBackBtn(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.backListener = onMenuItemClickListener;
        super.setBackBtn(onMenuItemClickListener);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void addTextOptionMenu(int i2, String str, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.nextListener = onMenuItemClickListener;
        super.addTextOptionMenu(i2, str, onMenuItemClickListener);
    }

    public void addTextOptionMenu(int i2, String str, MenuItem.OnMenuItemClickListener onMenuItemClickListener, t.b bVar) {
        this.nextListener = onMenuItemClickListener;
        super.addTextOptionMenu(i2, str, onMenuItemClickListener, null, bVar);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        TenpaySecureEditText.setSalt(f.hhV());
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        super.onPause();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        this.mNetSceneMgr.removeSceneEndListener(385);
        this.mNetSceneMgr.removeSceneEndListener(1518);
        this.mPayLoopInterruptListener.dead();
        d process = getProcess();
        if (process != null) {
            process.b(this);
        }
        unlockPage();
        dispatchOnDestroy();
        this.callbacks.clear();
        keepProcessEnd(null);
    }

    public String getSubTitle() {
        return "";
    }

    @Override // com.tencent.mm.wallet_core.d.f
    public void onSceneEnd(int i2, int i3, String str, q qVar, boolean z) {
        Log.d(TAG, "errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        TenpaySecureEditText.setSalt(f.hhV());
        if (qVar instanceof s) {
            s sVar = (s) qVar;
            this.mCurrentNetScene = sVar;
            if (this.mBundle != null) {
                if (sVar.is_gen_cert > 0) {
                    this.mBundle.putInt("key_is_gen_cert", sVar.is_gen_cert);
                }
                if (sVar.is_hint_cert > 0) {
                    this.mBundle.putInt("key_is_hint_crt", sVar.is_hint_cert);
                }
                if (sVar.is_ignore_cert > 0) {
                    this.mBundle.putInt("key_is_ignore_cert", sVar.is_ignore_cert);
                }
                if (!Util.isNullOrNil(sVar.crt_token)) {
                    this.mBundle.putString("key_crt_token", sVar.crt_token);
                }
                if (!Util.isNullOrNil(sVar.crt_wording)) {
                    this.mBundle.putString("key_crt_wording", sVar.crt_wording);
                }
            }
        }
        onPreSceneEnd(i2, i3, str, qVar);
        g.a(this, i2, i3, str, qVar, z);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        getNetController().onActivityResult(i2, i3, intent);
        dispatchOnActivityResult(i2, i3, intent);
    }

    public void cleanUiData(int i2) {
    }

    public boolean onPreSceneEnd(int i2, int i3, String str, q qVar) {
        return true;
    }

    public boolean checkProcLife() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onProgressFinish() {
        return false;
    }

    public boolean isTransparent() {
        if (getLayoutId() > 0 && !this.mNetSceneMgr.isProcessing()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean getCancelable() {
        return true;
    }

    public boolean needConfirmFinish() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void cancelQRPay() {
        PayInfo payInfo = (PayInfo) getInput().getParcelable("key_pay_info");
        if (payInfo == null) {
            payInfo = (PayInfo) getIntent().getParcelableExtra("key_pay_info");
        }
        if (payInfo != null && !Util.isNullOrNil(payInfo.uuid)) {
            this.mNetSceneMgr.a(new n(payInfo.uuid, payInfo.dDL), true, 1);
            payInfo.uuid = null;
        }
    }

    /* access modifiers changed from: protected */
    public boolean needExecuteBackListener() {
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            if (this.mKBLayout != null && this.mKBLayout.isShown()) {
                hideTenpayKB();
                return true;
            } else if (needConfirmFinish()) {
                hideVKB();
                showDialog(1000);
                return true;
            } else if (this.backListener != null && needExecuteBackListener()) {
                this.backListener.onMenuItemClick(null);
                return true;
            } else if (this.nextListener != null) {
                this.nextListener.onMenuItemClick(null);
                return true;
            }
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onSwipeBackFinish() {
        if (this.backListener != null) {
            this.backListener.onMenuItemClick(null);
            return true;
        } else if (this.nextListener == null) {
            return super.onSwipeBackFinish();
        } else {
            this.nextListener.onMenuItemClick(null);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public Dialog onCreateDialog(int i2) {
        int i3;
        Log.i(TAG, "onCreateDialog id = ".concat(String.valueOf(i2)));
        switch (i2) {
            case 1000:
                d by = com.tencent.mm.wallet_core.a.by(this);
                if (by != null) {
                    i3 = by.a(this, 1);
                } else {
                    i3 = -1;
                }
                if (i3 != -1) {
                    return h.a((Context) this, true, getString(i3), "", getString(R.string.a0_), getString(R.string.x6), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.wallet_core.ui.WalletBaseUI.AnonymousClass12 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(72971);
                            WalletBaseUI.this.cancelQRPay();
                            d by = com.tencent.mm.wallet_core.a.by(WalletBaseUI.this);
                            WalletBaseUI.this.mPayResultType = 4;
                            if (by == null) {
                                WalletBaseUI.this.finish();
                            } else if (!by.j(WalletBaseUI.this, WalletBaseUI.this.getInput())) {
                                by.b(WalletBaseUI.this, WalletBaseUI.this.getInput());
                                AppMethodBeat.o(72971);
                                return;
                            }
                            AppMethodBeat.o(72971);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.wallet_core.ui.WalletBaseUI.AnonymousClass13 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(72972);
                            if (WalletBaseUI.this.getContentView() != null) {
                                WalletBaseUI.this.getContentView().findFocus();
                            }
                            AppMethodBeat.o(72972);
                        }
                    });
                }
                if (by != null) {
                    by.b(this, getInput());
                } else {
                    this.mPayResultType = 4;
                    finish();
                }
                return super.onCreateDialog(i2);
            default:
                return super.onCreateDialog(i2);
        }
    }

    public boolean isHandleAutoShowNormalStWcKb() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void setEditFocusListener(View view, int i2, boolean z) {
        setEditFocusListener(view, i2, z, true);
    }

    /* access modifiers changed from: protected */
    public void setWPKeyboard(final EditText editText, final boolean z, boolean z2) {
        if (this.mWcKeyboard == null) {
            this.mWcKeyboard = (WcPayKeyboard) findViewById(R.id.joy);
        }
        if (this.mWcKeyboard != null && editText != null) {
            final View.OnFocusChangeListener onFocusChangeListener = null;
            if (z2) {
                onFocusChangeListener = editText.getOnFocusChangeListener();
            }
            f.setNoSystemInputOnEditText(editText);
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                /* class com.tencent.mm.wallet_core.ui.WalletBaseUI.AnonymousClass14 */
                private boolean firstTime = true;

                public final void onFocusChange(final View view, boolean z) {
                    AppMethodBeat.i(72975);
                    if (z) {
                        ((InputMethodManager) WalletBaseUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        new MMHandler().postDelayed(new Runnable() {
                            /* class com.tencent.mm.wallet_core.ui.WalletBaseUI.AnonymousClass14.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(72973);
                                if (!WalletBaseUI.this.mWcKeyboard.isShown() && view.isShown()) {
                                    if (z || !AnonymousClass14.this.firstTime) {
                                        WalletBaseUI.this.showNormalStWcKb();
                                    }
                                    AnonymousClass14.this.firstTime = false;
                                }
                                WalletBaseUI.this.mWcKeyboard.setInputEditText(editText);
                                ((InputMethodManager) WalletBaseUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                                AppMethodBeat.o(72973);
                            }
                        }, 300);
                    } else {
                        new MMHandler().postDelayed(new Runnable() {
                            /* class com.tencent.mm.wallet_core.ui.WalletBaseUI.AnonymousClass14.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(72974);
                                WalletBaseUI.this.hideWcKb();
                                AppMethodBeat.o(72974);
                            }
                        }, 200);
                    }
                    if (onFocusChangeListener != null) {
                        onFocusChangeListener.onFocusChange(view, z);
                    }
                    AppMethodBeat.o(72975);
                }
            });
            if (com.tencent.mm.compatible.util.d.oD(28) && z && (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || ifAutoReqFocusTarget28())) {
                editText.post(new Runnable() {
                    /* class com.tencent.mm.wallet_core.ui.WalletBaseUI.AnonymousClass15 */

                    public final void run() {
                        AppMethodBeat.i(72976);
                        if (editText.findFocus() == null) {
                            editText.requestFocus();
                        }
                        AppMethodBeat.o(72976);
                    }
                });
            }
            editText.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.wallet_core.ui.WalletBaseUI.AnonymousClass16 */

                public final void onClick(View view) {
                    AppMethodBeat.i(72977);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/WalletBaseUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    WalletBaseUI.this.showNormalStWcKb();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/WalletBaseUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(72977);
                }
            });
        }
    }

    public void hideWcKb() {
        if (this.mWcKeyboard != null) {
            this.mWcKeyboard.hideWcKb();
            if (this.mTenpayKBStateListener != null) {
                this.mTenpayKBStateListener.onVisibleStateChange(false);
            }
        }
    }

    public void showWcKb() {
        if (this.mWcKeyboard != null && !this.mWcKeyboard.isShown()) {
            this.mWcKeyboard.DJ(true);
            if (this.mTenpayKBStateListener != null) {
                this.mTenpayKBStateListener.onVisibleStateChange(true);
            }
        }
    }

    public void showCircleStWcKb() {
        if (this.mWcKeyboard != null) {
            this.mWcKeyboard.hgN();
            if (this.mTenpayKBStateListener != null) {
                this.mTenpayKBStateListener.onVisibleStateChange(true);
            }
        }
    }

    public void showNormalStWcKb() {
        if (this.mWcKeyboard != null) {
            this.mWcKeyboard.showNormalStWcKb();
            if (this.mTenpayKBStateListener != null) {
                this.mTenpayKBStateListener.onVisibleStateChange(true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setWcKbHeightListener(WcPayKeyboard.a aVar) {
        if (this.mWcKeyboard != null) {
            this.mWcKeyboard.setHeightListener(aVar);
        }
    }

    /* access modifiers changed from: protected */
    public void setEditFocusListener(View view, int i2, boolean z, boolean z2) {
        setEditFocusListener(view, i2, z, true, z2);
    }

    @TargetApi(14)
    public void setEditFocusListener(View view, int i2, boolean z, boolean z2, boolean z3) {
        setEditFocusListener(view, null, i2, z, z2, z3);
    }

    /* access modifiers changed from: protected */
    public void setEditFocusListener(final View view, EditText editText, final int i2, final boolean z, boolean z2, boolean z3) {
        final EditText editText2;
        this.mKeyboard = (MyKeyboardWindow) findViewById(R.id.ijb);
        this.mKBLayout = findViewById(R.id.ija);
        View findViewById = findViewById(R.id.ijc);
        if (editText == null) {
            editText2 = (EditText) view.findViewById(R.id.jf4);
        } else {
            editText2 = editText;
        }
        if (this.mKeyboard != null && editText2 != null && this.mKBLayout != null) {
            final View.OnFocusChangeListener onFocusChangeListener = null;
            if (z3) {
                onFocusChangeListener = editText2.getOnFocusChangeListener();
            }
            f.setNoSystemInputOnEditText(editText2);
            editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                /* class com.tencent.mm.wallet_core.ui.WalletBaseUI.AnonymousClass17 */

                public final void onFocusChange(final View view, boolean z) {
                    AppMethodBeat.i(72980);
                    if (!view.isFocused() || z) {
                        new MMHandler().postDelayed(new Runnable() {
                            /* class com.tencent.mm.wallet_core.ui.WalletBaseUI.AnonymousClass17.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(72979);
                                WalletBaseUI.this.hideTenpayKB();
                                if (z) {
                                    ((InputMethodManager) WalletBaseUI.this.getContext().getSystemService("input_method")).showSoftInput(editText2, 0);
                                }
                                AppMethodBeat.o(72979);
                            }
                        }, 200);
                    } else {
                        ((InputMethodManager) WalletBaseUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        new MMHandler().postDelayed(new Runnable() {
                            /* class com.tencent.mm.wallet_core.ui.WalletBaseUI.AnonymousClass17.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(72978);
                                if (!WalletBaseUI.this.mKBLayout.isShown() && view.isShown()) {
                                    WalletBaseUI.this.showTenpayKB();
                                }
                                if ((view instanceof WalletFormView) && Build.VERSION.SDK_INT >= 14) {
                                    WalletFormView walletFormView = (WalletFormView) view;
                                    if ((z.aUo() || walletFormView.getEncrptType() == 100) && (!z.aUo() || walletFormView.getEncrptType() == 0)) {
                                        WalletBaseUI.this.mKeyboard.resetSecureAccessibility();
                                        editText2.setAccessibilityDelegate(null);
                                    } else {
                                        com.tencent.mm.ui.a.d dVar = new com.tencent.mm.ui.a.d();
                                        WalletBaseUI.this.mKeyboard.setSecureAccessibility(dVar);
                                        editText2.setAccessibilityDelegate(dVar);
                                    }
                                }
                                if ((view instanceof EditHintPasswdView) && Build.VERSION.SDK_INT >= 14) {
                                    com.tencent.mm.ui.a.d dVar2 = new com.tencent.mm.ui.a.d();
                                    WalletBaseUI.this.mKeyboard.setSecureAccessibility(dVar2);
                                    editText2.setAccessibilityDelegate(dVar2);
                                }
                                WalletBaseUI.this.setKBMode(i2);
                                WalletBaseUI.this.mKeyboard.setInputEditText((EditText) view);
                                ((InputMethodManager) WalletBaseUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                                AppMethodBeat.o(72978);
                            }
                        }, 300);
                    }
                    if (onFocusChangeListener != null) {
                        onFocusChangeListener.onFocusChange(view, z);
                    }
                    AppMethodBeat.o(72980);
                }
            });
            editText2.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.wallet_core.ui.WalletBaseUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(72963);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/WalletBaseUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!WalletBaseUI.this.mKBLayout.isShown() && !z) {
                        WalletBaseUI.this.showTenpayKB();
                        WalletBaseUI.this.setKBMode(i2);
                    } else if (z) {
                        WalletBaseUI.this.hideTenpayKB();
                        ((InputMethodManager) WalletBaseUI.this.getContext().getSystemService("input_method")).showSoftInput(editText2, 0);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/WalletBaseUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(72963);
                }
            });
            if (com.tencent.mm.compatible.util.d.oD(28) && z2 && (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || ifAutoReqFocusTarget28())) {
                editText2.post(new Runnable() {
                    /* class com.tencent.mm.wallet_core.ui.WalletBaseUI.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(72964);
                        if (editText2.findFocus() == null) {
                            editText2.requestFocus();
                        }
                        AppMethodBeat.o(72964);
                    }
                });
            }
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.wallet_core.ui.WalletBaseUI.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(72965);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/WalletBaseUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    WalletBaseUI.this.hideTenpayKB();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/WalletBaseUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(72965);
                }
            });
        }
    }

    public static boolean ifAutoReqFocusTarget28() {
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_target28_pay_keyboard_focus, 1);
        Log.i(TAG, "ifAutoReqFocusTarget28() swt:%s", Integer.valueOf(a2));
        return a2 == 1;
    }

    public boolean resend(boolean z) {
        if (this.mCurrentNetScene == null || (!this.mCurrentNetScene.resend() && !z)) {
            return false;
        }
        this.mNetSceneMgr.b(this.mCurrentNetScene, true);
        return true;
    }

    public void clearErr() {
        g.clearErr();
    }

    public void hideTenpayKB() {
        if (this.mKBLayout != null && this.mKBLayout.isShown()) {
            this.mKBLayout.setVisibility(8);
            if (this.mTenpayKBStateListener != null) {
                this.mTenpayKBStateListener.onVisibleStateChange(false);
            }
        }
    }

    public void showTenpayKB() {
        if (this.mKBLayout != null && !this.mKBLayout.isShown()) {
            this.mKBLayout.setVisibility(0);
            if (this.mTenpayKBStateListener != null) {
                this.mTenpayKBStateListener.onVisibleStateChange(true);
            }
        }
    }

    public void setTenpayKBStateListener(a aVar) {
        this.mTenpayKBStateListener = aVar;
    }

    public void setKBMode(int i2) {
        this.mKeyboard.setXMode(i2);
    }

    public d getProcess() {
        if (this.mProcess == null) {
            this.mProcess = com.tencent.mm.wallet_core.a.by(this);
        }
        return this.mProcess;
    }

    public g getNetController() {
        if (this.mNetController == null) {
            d process = getProcess();
            if (process != null) {
                this.mNetController = process.a(this, this.mNetSceneMgr);
            }
            if (this.mNetController == null) {
                this.mNetController = new g(this, this.mNetSceneMgr) {
                    /* class com.tencent.mm.wallet_core.ui.WalletBaseUI.AnonymousClass5 */

                    @Override // com.tencent.mm.wallet_core.d.g
                    public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                        return false;
                    }

                    @Override // com.tencent.mm.wallet_core.d.g
                    public final boolean r(Object... objArr) {
                        return false;
                    }
                };
            }
        }
        return this.mNetController;
    }

    public CharSequence getTips(int i2) {
        if (this.mNetController == null) {
            return null;
        }
        return this.mNetController.getTips(i2);
    }

    public void next() {
        getProcess().a(this, 0, getInput());
    }

    public void next(Bundle bundle) {
        getProcess().a(this, 0, bundle);
    }

    public void addSceneEndListener(int i2) {
        this.mNetSceneMgr.addSceneEndListener(i2);
    }

    public void regeistQueryOrder(int i2, c cVar) {
        com.tencent.mm.wallet_core.d.i iVar = this.mNetSceneMgr;
        cVar.rtType = i2;
        cVar.Rux = iVar;
        iVar.RuD.put(Integer.valueOf(i2), cVar);
    }

    public void removeSceneEndListener(int i2) {
        this.mNetSceneMgr.removeSceneEndListener(i2);
    }

    public void doSceneProgress(q qVar, boolean z) {
        doSceneProgress(qVar, z, false);
    }

    public void doSceneProgress(q qVar, boolean z, boolean z2) {
        doSceneProgress(qVar, z, z2, 0);
    }

    public void doSceneProgress(q qVar, boolean z, boolean z2, int i2) {
        setProcessBundle();
        int i3 = 1;
        if (!z2) {
            i3 = 2;
        }
        this.mNetSceneMgr.a(qVar, z, i3, i2);
    }

    public void doSceneSafeProgress(q qVar) {
        doSceneProgress(qVar, true, true);
    }

    public void doSceneProgress(q qVar) {
        doSceneProgress(qVar, true, true);
    }

    public void doSceneProgressWithVerify(q qVar) {
        setProcessBundle();
        this.mNetSceneMgr.a(qVar, true, 3);
    }

    public void doSceneForceProgress(q qVar) {
        doSceneProgress(qVar, true, false);
    }

    public void doSceneForceProgress(q qVar, int i2) {
        doSceneProgress(qVar, true, false, i2);
    }

    public void showSafeProgress() {
        if (this.mProgressDialog == null || (this.mProgressDialog != null && !this.mProgressDialog.isShowing())) {
            if (this.mProgressDialog != null) {
                this.mProgressDialog.dismiss();
            }
            this.mProgressDialog = h.a((Context) this, false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.wallet_core.ui.WalletBaseUI.AnonymousClass6 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(72966);
                    WalletBaseUI.this.forceCancel();
                    AppMethodBeat.o(72966);
                }
            });
        }
    }

    public void hideProgress() {
        if (this.mProgressDialog != null) {
            this.mProgressDialog.dismiss();
        }
    }

    public void showProgress() {
        if (this.mProgressDialog == null || (this.mProgressDialog != null && !this.mProgressDialog.isShowing())) {
            if (this.mProgressDialog != null) {
                this.mProgressDialog.dismiss();
            }
            this.mProgressDialog = h.c(this, false, new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.wallet_core.ui.WalletBaseUI.AnonymousClass7 */

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
        }
    }

    public void cancelNetScene(q qVar) {
        com.tencent.mm.wallet_core.d.i iVar = this.mNetSceneMgr;
        Log.i("MicroMsg.WalletNetSceneMgr", "cancel scene: %s %s", iVar, qVar);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(qVar);
        iVar.ksP.remove(qVar);
        iVar.ksO.remove(qVar);
        if (iVar.ksP.isEmpty() && iVar.ksO.isEmpty() && iVar.tipDialog != null && iVar.tipDialog.isShowing()) {
            iVar.tipDialog.dismiss();
        }
    }

    public void cleanScenes() {
        this.mNetSceneMgr.forceCancel();
    }

    public boolean isProcessing() {
        return this.mNetSceneMgr.isProcessing();
    }

    private void setProcessBundle() {
        d process = getProcess();
        if (process != null) {
            this.mNetSceneMgr.mBundle = process.dQL;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void setContentViewVisibility(int i2) {
        super.setContentViewVisibility(i2);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("key_process_is_end", false) && !intent.getBooleanExtra("key_process_is_stay", true)) {
            setIntent(intent);
            Bundle extras = getIntent().getExtras();
            int i2 = (extras == null || !extras.containsKey("key_process_result_code")) ? 0 : extras.getInt("key_process_result_code", 0);
            if (i2 == -1) {
                Log.i(TAG, "process end ok!");
                setResult(-1, getIntent());
            } else {
                Log.i(TAG, "process end with user cancel or err! resultCode : ".concat(String.valueOf(i2)));
                setResult(0, getIntent());
            }
            finish();
        }
    }

    public void scrollToFormEditPosAfterShowTenPay(final View view, View view2, int i2) {
        if (view != null) {
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int height = iArr[1] + view2.getHeight();
            int jo = a.jo(this);
            int fromDPToPix = (jo - height) - a.fromDPToPix((Context) this, i2);
            Log.d(TAG, "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", Integer.valueOf(height), Integer.valueOf(jo), Integer.valueOf(fromDPToPix), Integer.valueOf(HARDCODE_TENPAY_KEYBOARD_HEIGHT));
            if (fromDPToPix > 0 && fromDPToPix < HARDCODE_TENPAY_KEYBOARD_HEIGHT) {
                final int i3 = HARDCODE_TENPAY_KEYBOARD_HEIGHT - fromDPToPix;
                Log.d(TAG, "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", Integer.valueOf(i3));
                view.post(new Runnable() {
                    /* class com.tencent.mm.wallet_core.ui.WalletBaseUI.AnonymousClass8 */

                    public final void run() {
                        AppMethodBeat.i(72967);
                        view.scrollBy(0, i3);
                        AppMethodBeat.o(72967);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean needLockPage() {
        return false;
    }

    public boolean lockPage() {
        String simpleName = getClass().getSimpleName();
        if (!mLockSet.contains(simpleName)) {
            return mLockSet.add(simpleName);
        }
        Log.w(TAG, "has contain lock key: %s", simpleName);
        finish();
        return false;
    }

    public void unlockPage() {
        mLockSet.remove(getClass().getSimpleName());
    }

    @Override // com.tencent.mm.wallet_core.c.i
    public void register(k kVar) {
        if (!this.callbacks.contains(kVar)) {
            this.callbacks.add(kVar);
        }
    }

    public void unregister(k kVar) {
        if (this.callbacks.contains(kVar)) {
            this.callbacks.remove(kVar);
        }
    }

    private void dispatchOnCreate() {
        Iterator it = ((List) this.callbacks.clone()).iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private void dispatchOnDestroy() {
        for (k kVar : (List) this.callbacks.clone()) {
            kVar.onDestroy();
        }
    }

    private void dispatchOnActivityResult(int i2, int i3, Intent intent) {
        for (k kVar : (List) this.callbacks.clone()) {
            kVar.hhl();
        }
    }

    public void showLoading(boolean z) {
        if (this.mTipDialog != null) {
            this.mTipDialog.show();
            return;
        }
        if (z) {
            this.mTipDialog = h.b(getContext(), false, new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.wallet_core.ui.WalletBaseUI.AnonymousClass9 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(72968);
                    if (WalletBaseUI.this.mTipDialog != null && WalletBaseUI.this.mTipDialog.isShowing()) {
                        WalletBaseUI.this.mTipDialog.dismiss();
                    }
                    if (WalletBaseUI.this.getContentView().getVisibility() == 8 || WalletBaseUI.this.getContentView().getVisibility() == 4) {
                        Log.i(WalletBaseUI.TAG, "usr cancel, & visibility not visiable, so finish");
                        WalletBaseUI.this.finish();
                    }
                    WalletBaseUI.this.forceCancel();
                    AppMethodBeat.o(72968);
                }
            });
        } else {
            this.mTipDialog = h.c(getContext(), true, null);
        }
        if (this.mTipDialog != null) {
            this.mTipDialog.setCancelable(true);
        }
    }

    public void showLoading() {
        showLoading(true);
    }

    public void hideLoading() {
        if (this.mTipDialog != null && this.mTipDialog.isShowing()) {
            this.mTipDialog.dismiss();
        }
    }

    public void setAuthState(boolean z) {
        this.mIsAuthDoing = z;
        com.tencent.mm.pluginsdk.wallet.g gsU = com.tencent.mm.pluginsdk.wallet.g.gsU();
        gsU.KxR.put("key_pay_offline_is_auth_doing", Boolean.valueOf(z));
    }

    /* access modifiers changed from: protected */
    public boolean isAuthDoing() {
        return this.mIsAuthDoing;
    }
}
