package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.recovery.wx.util.WXUtil;

public class LoginByMobileSendSmsUI extends MMActivity implements i {
    private TextView contentView;
    private int countDown = 15;
    private String edo = "";
    private SecurityImage kdp = null;
    protected String kjv;
    private String kkz = "";
    private ProgressDialog klA;
    private int klB;
    private Button klC;
    private Button klD;
    private TextView klE;
    private MTimerHandler klF;
    private String klr = "";
    private String kls = "";
    private g klt = new g();
    private boolean klu;
    private boolean klv;
    private String klw;
    private String klx;
    protected String kly = "";
    private h klz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LoginByMobileSendSmsUI() {
        AppMethodBeat.i(128070);
        AppMethodBeat.o(128070);
    }

    static /* synthetic */ void a(LoginByMobileSendSmsUI loginByMobileSendSmsUI) {
        AppMethodBeat.i(128080);
        loginByMobileSendSmsUI.goBack();
        AppMethodBeat.o(128080);
    }

    static /* synthetic */ int j(LoginByMobileSendSmsUI loginByMobileSendSmsUI) {
        int i2 = loginByMobileSendSmsUI.countDown;
        loginByMobileSendSmsUI.countDown = i2 - 1;
        return i2;
    }

    static /* synthetic */ void l(LoginByMobileSendSmsUI loginByMobileSendSmsUI) {
        AppMethodBeat.i(128083);
        loginByMobileSendSmsUI.stopTimer();
        AppMethodBeat.o(128083);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128071);
        super.onCreate(bundle);
        this.klr = Util.nullAsNil(getIntent().getStringExtra("from_mobile"));
        this.klv = getIntent().getBooleanExtra("from_switch_account", false);
        this.klw = bf.iDu.aA(WXUtil.LAST_LOGIN_WEXIN_USERNAME, "");
        initView();
        final a aVar = new a(this.klr, 16, "", 0, "", 1);
        g.azz().a(aVar, 0);
        getString(R.string.zb);
        this.klA = h.a((Context) this, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginByMobileSendSmsUI.AnonymousClass9 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(128065);
                g.azz().a(aVar);
                AppMethodBeat.o(128065);
            }
        });
        AppMethodBeat.o(128071);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(128072);
        super.initView();
        ((TextView) findViewById(R.id.hkm)).setText(getString(R.string.fzd, new Object[]{this.klr}));
        this.contentView = (TextView) findViewById(R.id.hkj);
        this.contentView.setText(Tr(getString(R.string.fzc, new Object[]{this.kkz})));
        this.klE = (TextView) findViewById(R.id.hkn);
        this.klE.setText(Tr(getString(R.string.fzf, new Object[]{this.kls})));
        this.klC = (Button) findViewById(R.id.hki);
        this.klD = (Button) findViewById(R.id.fz0);
        setMMTitle(R.string.fze);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginByMobileSendSmsUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128059);
                LoginByMobileSendSmsUI.a(LoginByMobileSendSmsUI.this);
                AppMethodBeat.o(128059);
                return true;
            }
        });
        this.klt.account = this.klr;
        AppMethodBeat.o(128072);
    }

    private m Tr(String str) {
        AppMethodBeat.i(128073);
        m mVar = new m(str);
        Log.d("MicroMsg.LoginByMobileSendSmsUI", "content: %s", str);
        int indexOf = str.indexOf(32) + 1;
        mVar.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(R.dimen.hf)), indexOf, str.length(), 33);
        mVar.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.ts)), indexOf, str.length(), 33);
        AppMethodBeat.o(128073);
        return mVar;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bba;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(128074);
        super.onResume();
        g.azz().a(145, this);
        AppMethodBeat.o(128074);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(128075);
        super.onStop();
        stopTimer();
        g.azz().b(145, this);
        AppMethodBeat.o(128075);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0599  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0411  */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(final int r10, int r11, java.lang.String r12, com.tencent.mm.ak.q r13) {
        /*
        // Method dump skipped, instructions count: 1556
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.account.ui.LoginByMobileSendSmsUI.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }

    private void stopTimer() {
        AppMethodBeat.i(128077);
        if (this.klF != null) {
            this.klF.stopTimer();
        }
        this.klD.setText(R.string.fz8);
        this.klD.setEnabled(true);
        AppMethodBeat.o(128077);
    }

    private void goBack() {
        AppMethodBeat.i(128078);
        h.a(this, getString(R.string.fz_), "", new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginByMobileSendSmsUI.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(128062);
                LoginByMobileSendSmsUI.l(LoginByMobileSendSmsUI.this);
                LoginByMobileSendSmsUI.this.finish();
                AppMethodBeat.o(128062);
            }
        }, (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(128078);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(128079);
        if (i2 == 4) {
            goBack();
            AppMethodBeat.o(128079);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(128079);
        return onKeyDown;
    }

    static /* synthetic */ void b(LoginByMobileSendSmsUI loginByMobileSendSmsUI) {
        AppMethodBeat.i(128081);
        loginByMobileSendSmsUI.klD.setEnabled(false);
        if (loginByMobileSendSmsUI.klF != null) {
            loginByMobileSendSmsUI.klF.stopTimer();
            loginByMobileSendSmsUI.countDown = 15;
            loginByMobileSendSmsUI.klB = 0;
            loginByMobileSendSmsUI.klF.startTimer(0, 1000);
            AppMethodBeat.o(128081);
            return;
        }
        loginByMobileSendSmsUI.klF = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.account.ui.LoginByMobileSendSmsUI.AnonymousClass5 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(128061);
                if (LoginByMobileSendSmsUI.this.countDown > 0) {
                    LoginByMobileSendSmsUI.this.klD.setText(LoginByMobileSendSmsUI.this.getString(R.string.fzh, new Object[]{Integer.valueOf(LoginByMobileSendSmsUI.this.countDown)}));
                    LoginByMobileSendSmsUI.j(LoginByMobileSendSmsUI.this);
                    if (LoginByMobileSendSmsUI.this.countDown % 4 == 0) {
                        LoginByMobileSendSmsUI.k(LoginByMobileSendSmsUI.this);
                    }
                    AppMethodBeat.o(128061);
                    return true;
                }
                LoginByMobileSendSmsUI.this.klD.setText(R.string.fz8);
                LoginByMobileSendSmsUI.this.klD.setEnabled(true);
                AppMethodBeat.o(128061);
                return false;
            }
        }, true);
        loginByMobileSendSmsUI.klF.startTimer(0, 1000);
        AppMethodBeat.o(128081);
    }

    static /* synthetic */ void k(LoginByMobileSendSmsUI loginByMobileSendSmsUI) {
        AppMethodBeat.i(128082);
        loginByMobileSendSmsUI.klB++;
        if (loginByMobileSendSmsUI.klB <= 4) {
            a aVar = new a(loginByMobileSendSmsUI.klr, 17, "", 0, "");
            aVar.tb(1);
            aVar.F(loginByMobileSendSmsUI.klB, loginByMobileSendSmsUI.klB == 4);
            g.azz().a(aVar, 0);
        }
        AppMethodBeat.o(128082);
    }
}
