package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.account.ui.ResizeLayout;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.xlog.app.XLogSetup;

public class SimpleLoginUI extends MMWizardActivity implements i {
    private TextWatcher aws = new TextWatcher() {
        /* class com.tencent.mm.plugin.account.ui.SimpleLoginUI.AnonymousClass1 */

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(128758);
            SimpleLoginUI.a(SimpleLoginUI.this);
            AppMethodBeat.o(128758);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    };
    private String edo = "";
    private ProgressDialog gtM = null;
    private SecurityImage kdp = null;
    private String kjv;
    private IListener kkK = new IListener<lz>() {
        /* class com.tencent.mm.plugin.account.ui.SimpleLoginUI.AnonymousClass12 */

        {
            AppMethodBeat.i(161707);
            this.__eventId = lz.class.getName().hashCode();
            AppMethodBeat.o(161707);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lz lzVar) {
            AppMethodBeat.i(128769);
            lz lzVar2 = lzVar;
            if (lzVar2 == null || lzVar2.dRz == null) {
                AppMethodBeat.o(128769);
                return false;
            }
            Log.i("MicroMsg.SimpleLoginUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", lzVar2.dRz.content, lzVar2.dRz.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", lzVar2.dRz.content);
            intent.putExtra("key_disaster_url", lzVar2.dRz.url);
            intent.setClass(MMApplicationContext.getContext(), DisasterUI.class).addFlags(268435456);
            Context context = MMApplicationContext.getContext();
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/account/ui/SimpleLoginUI$2", "callback", "(Lcom/tencent/mm/autogen/events/LoginDisasterEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/account/ui/SimpleLoginUI$2", "callback", "(Lcom/tencent/mm/autogen/events/LoginDisasterEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(128769);
            return true;
        }
    };
    private String klX;
    private g klt = new g();
    private String klx;
    private MMClearEditText kmP;
    private MMClearEditText kmQ;
    private MMFormInputView kmR;
    private MMFormInputView kmS;
    private Button kmT;
    private MMKeyboardUperView kmW;
    private ResizeLayout kmb;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SimpleLoginUI() {
        AppMethodBeat.i(128778);
        AppMethodBeat.o(128778);
    }

    static /* synthetic */ void b(SimpleLoginUI simpleLoginUI) {
        AppMethodBeat.i(128791);
        simpleLoginUI.bpf();
        AppMethodBeat.o(128791);
    }

    static /* synthetic */ void f(SimpleLoginUI simpleLoginUI) {
        AppMethodBeat.i(128792);
        simpleLoginUI.bnm();
        AppMethodBeat.o(128792);
    }

    static /* synthetic */ void j(SimpleLoginUI simpleLoginUI) {
        AppMethodBeat.i(196936);
        simpleLoginUI.ala(-1);
        AppMethodBeat.o(196936);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b2g;
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128779);
        super.onCreate(bundle);
        SharedPreferences sharedPreferences = getSharedPreferences("system_config_prefs", g.aps());
        if (sharedPreferences.getBoolean("first_launch_weixin", true)) {
            sharedPreferences.edit().putBoolean("first_launch_weixin", false).commit();
            XLogSetup.realSetupXlog();
        }
        setMMTitle(R.string.wx);
        if (com.tencent.mm.plugin.account.a.a.jRu != null) {
            com.tencent.mm.plugin.account.a.a.jRu.Xc();
        }
        initView();
        com.tencent.mm.kernel.g.azz().a(701, this);
        com.tencent.mm.kernel.g.azz().a(252, this);
        if (!b.aW(this)) {
            new Intent().addFlags(67108864);
            com.tencent.mm.plugin.account.a.a.jRt.o(new Intent(), this);
        }
        AppMethodBeat.o(128779);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(128780);
        EventCenter.instance.addListener(this.kkK);
        super.onResume();
        AppMethodBeat.o(128780);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(128781);
        com.tencent.mm.kernel.g.azz().b(701, this);
        com.tencent.mm.kernel.g.azz().b(252, this);
        super.onDestroy();
        AppMethodBeat.o(128781);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(128782);
        super.onNewIntent(intent);
        this.kjv = intent.getStringExtra("auth_ticket");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.kjv = extras.getString("auth_ticket");
        }
        if (!Util.isNullOrNil(this.kjv)) {
            this.kmP.setText(Util.nullAsNil(g.bpk()));
            this.kmQ.setText(Util.nullAsNil(g.bpl()));
            new MMHandler().postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.account.ui.SimpleLoginUI.AnonymousClass13 */

                public final void run() {
                    AppMethodBeat.i(128770);
                    SimpleLoginUI.b(SimpleLoginUI.this);
                    AppMethodBeat.o(128770);
                }
            }, 500);
        }
        AppMethodBeat.o(128782);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(128783);
        this.kmR = (MMFormInputView) findViewById(R.id.erh);
        TextView textView = (TextView) findViewById(R.id.esg);
        if (WeChatBrands.AppInfo.current().isMainland()) {
            this.kmR.setHint(R.string.elc);
            textView.setText(R.string.elw);
        } else {
            this.kmR.setHint(R.string.eld);
            textView.setText(R.string.elx);
        }
        this.kmS = (MMFormInputView) findViewById(R.id.es_);
        this.kmP = (MMClearEditText) this.kmR.getContentEditText();
        this.kmP.setFocusableInTouchMode(false);
        this.kmP.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.account.ui.SimpleLoginUI.AnonymousClass14 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(128771);
                SimpleLoginUI.this.kmP.setFocusableInTouchMode(true);
                boolean onTouch = SimpleLoginUI.this.kmP.getDefaultOnTouchListener().onTouch(view, motionEvent);
                AppMethodBeat.o(128771);
                return onTouch;
            }
        });
        this.kmQ = (MMClearEditText) this.kmS.getContentEditText();
        this.kmQ.setFocusableInTouchMode(false);
        this.kmQ.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.account.ui.SimpleLoginUI.AnonymousClass15 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(128772);
                SimpleLoginUI.this.kmQ.setFocusableInTouchMode(true);
                SimpleLoginUI.this.kmP.setFocusableInTouchMode(false);
                boolean onTouch = SimpleLoginUI.this.kmQ.getDefaultOnTouchListener().onTouch(view, motionEvent);
                AppMethodBeat.o(128772);
                return onTouch;
            }
        });
        c.f(this.kmQ).aoq(16).a((c.a) null);
        this.kmT = (Button) findViewById(R.id.erp);
        this.kmT.setEnabled(false);
        this.kmP.addTextChangedListener(this.aws);
        this.kmQ.addTextChangedListener(this.aws);
        this.kmQ.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.account.ui.SimpleLoginUI.AnonymousClass16 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(128773);
                if (i2 == 6 || i2 == 5) {
                    SimpleLoginUI.b(SimpleLoginUI.this);
                    AppMethodBeat.o(128773);
                    return true;
                }
                AppMethodBeat.o(128773);
                return false;
            }
        });
        this.kmQ.setOnKeyListener(new View.OnKeyListener() {
            /* class com.tencent.mm.plugin.account.ui.SimpleLoginUI.AnonymousClass17 */

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(128774);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                bVar.pH(i2);
                bVar.bm(keyEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/SimpleLoginUI$7", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
                if (66 == i2 && keyEvent.getAction() == 0) {
                    SimpleLoginUI.b(SimpleLoginUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/account/ui/SimpleLoginUI$7", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(128774);
                    return true;
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/account/ui/SimpleLoginUI$7", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(128774);
                return false;
            }
        });
        this.kmb = (ResizeLayout) findViewById(R.id.h5e);
        this.kmW = (MMKeyboardUperView) findViewById(R.id.hcl);
        this.kmb.setOnSizeChanged(new ResizeLayout.a() {
            /* class com.tencent.mm.plugin.account.ui.SimpleLoginUI.AnonymousClass18 */

            @Override // com.tencent.mm.plugin.account.ui.ResizeLayout.a
            public final void bpj() {
                AppMethodBeat.i(128776);
                SimpleLoginUI.this.kmW.post(new Runnable() {
                    /* class com.tencent.mm.plugin.account.ui.SimpleLoginUI.AnonymousClass18.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(128775);
                        SimpleLoginUI.this.kmW.fullScroll(130);
                        AppMethodBeat.o(128775);
                    }
                });
                AppMethodBeat.o(128776);
            }
        });
        this.kmW.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.account.ui.SimpleLoginUI.AnonymousClass19 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(128777);
                SimpleLoginUI.this.hideVKB();
                AppMethodBeat.o(128777);
                return false;
            }
        });
        findViewById(R.id.erw).setVisibility(8);
        setMMTitle(R.string.emu);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.SimpleLoginUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128759);
                SimpleLoginUI.f(SimpleLoginUI.this);
                AppMethodBeat.o(128759);
                return true;
            }
        });
        this.kjv = getIntent().getStringExtra("auth_ticket");
        if (!Util.isNullOrNil(this.kjv)) {
            this.kmP.setText(Util.nullAsNil(g.bpk()));
            this.kmQ.setText(Util.nullAsNil(g.bpl()));
            new MMHandler().postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.account.ui.SimpleLoginUI.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(128760);
                    SimpleLoginUI.b(SimpleLoginUI.this);
                    AppMethodBeat.o(128760);
                }
            }, 500);
        }
        if (ChannelUtil.shouldShowGprsAlert) {
            com.tencent.mm.plugin.account.a.a.jRu.t(this);
        }
        this.kmT.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.SimpleLoginUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(128761);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/SimpleLoginUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SimpleLoginUI.b(SimpleLoginUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/SimpleLoginUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128761);
            }
        });
        AppMethodBeat.o(128783);
    }

    private void bnm() {
        AppMethodBeat.i(128784);
        boolean booleanExtra = getIntent().getBooleanExtra("key_auto_login_wizard_exit", false);
        if (!booleanExtra) {
            cancel();
        }
        ala(1);
        if (booleanExtra) {
            exit(1);
        }
        AppMethodBeat.o(128784);
    }

    private void bpf() {
        AppMethodBeat.i(128785);
        this.klt.account = this.kmP.getText().toString().trim();
        this.klt.kdq = this.kmQ.getText().toString();
        if (this.klt.account.equals("")) {
            h.n(this, R.string.hvs, R.string.em8);
            AppMethodBeat.o(128785);
        } else if (this.klt.kdq.equals("")) {
            h.n(this, R.string.hvk, R.string.em8);
            AppMethodBeat.o(128785);
        } else {
            hideVKB();
            final t tVar = new t(this.klt.account, this.klt.kdq, this.kjv, 0);
            com.tencent.mm.kernel.g.azz().a(tVar, 0);
            getString(R.string.zb);
            this.gtM = h.a((Context) this, getString(R.string.emm), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.account.ui.SimpleLoginUI.AnonymousClass5 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(128762);
                    com.tencent.mm.kernel.g.azz().a(tVar);
                    AppMethodBeat.o(128762);
                }
            });
            AppMethodBeat.o(128785);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(128786);
        if (i2 == 4) {
            bnm();
            AppMethodBeat.o(128786);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(128786);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(128787);
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        super.onPause();
        EventCenter.instance.removeListener(this.kkK);
        AppMethodBeat.o(128787);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0118  */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int r10, int r11, java.lang.String r12, com.tencent.mm.ak.q r13) {
        /*
        // Method dump skipped, instructions count: 870
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.account.ui.SimpleLoginUI.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        int i4 = 0;
        AppMethodBeat.i(128789);
        super.onActivityResult(i2, i3, intent);
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Boolean.valueOf(intent == null);
        Log.d("MicroMsg.SimpleLoginUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", objArr);
        if (i3 == -1 && i2 == 1024 && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(Util.isNullOrNil(stringExtra));
            if (!Util.isNullOrNil(stringExtra)) {
                i4 = stringExtra.length();
            }
            objArr2[1] = Integer.valueOf(i4);
            objArr2[2] = Integer.valueOf(intExtra);
            Log.d("MicroMsg.SimpleLoginUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", objArr2);
            if (intExtra == -217) {
                bpf();
                AppMethodBeat.o(128789);
                return;
            }
        }
        AppMethodBeat.o(128789);
    }

    static /* synthetic */ void a(SimpleLoginUI simpleLoginUI) {
        AppMethodBeat.i(128790);
        if (Util.isNullOrNil(simpleLoginUI.kmP.getText().toString()) || Util.isNullOrNil(simpleLoginUI.kmQ.getText().toString())) {
            simpleLoginUI.kmT.setEnabled(false);
            AppMethodBeat.o(128790);
            return;
        }
        simpleLoginUI.kmT.setEnabled(true);
        AppMethodBeat.o(128790);
    }
}
