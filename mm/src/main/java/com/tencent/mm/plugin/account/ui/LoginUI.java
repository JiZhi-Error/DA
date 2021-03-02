package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.cc.h;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.b;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.model.d;
import com.tencent.mm.plugin.account.ui.ResizeLayout;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.recovery.wx.util.WXUtil;

public class LoginUI extends MMActivity implements i {
    private TextWatcher aws = new TextWatcher() {
        /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass1 */

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(128202);
            LoginUI.a(LoginUI.this);
            AppMethodBeat.o(128202);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    };
    private String dHx = null;
    private String dYB = "";
    private String edo = "";
    private ProgressDialog gtM = null;
    private String kbV;
    private SecurityImage kdp = null;
    private String kjv;
    private IListener kkK = new IListener<lz>() {
        /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass12 */

        {
            AppMethodBeat.i(161703);
            this.__eventId = lz.class.getName().hashCode();
            AppMethodBeat.o(161703);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lz lzVar) {
            AppMethodBeat.i(128213);
            lz lzVar2 = lzVar;
            if (lzVar2 == null || lzVar2.dRz == null) {
                AppMethodBeat.o(128213);
                return false;
            }
            Log.i("MicroMsg.LoginUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", lzVar2.dRz.content, lzVar2.dRz.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", lzVar2.dRz.content);
            intent.putExtra("key_disaster_url", lzVar2.dRz.url);
            intent.setClass(MMApplicationContext.getContext(), DisasterUI.class).addFlags(268435456);
            Context context = MMApplicationContext.getContext();
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/account/ui/LoginUI$2", "callback", "(Lcom/tencent/mm/autogen/events/LoginDisasterEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/account/ui/LoginUI$2", "callback", "(Lcom/tencent/mm/autogen/events/LoginDisasterEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(128213);
            return true;
        }
    };
    protected Button klS;
    protected Button klT;
    private View klU;
    protected Button klV;
    private String klX;
    private g klt = new g();
    private boolean klv;
    private String klw;
    private String klx;
    private x kmF = new x();
    private MMClearEditText kmP;
    private MMClearEditText kmQ;
    private MMFormInputView kmR;
    private MMFormInputView kmS;
    private Button kmT;
    private Button kmU;
    protected View kmV;
    private MMKeyboardUperView kmW;
    private boolean kmX = false;
    final boolean[] kmY = {true};
    private final int kmZ = 128;
    private ResizeLayout kmb;
    private b kmf;
    private Button kml;
    private int sceneType = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LoginUI() {
        AppMethodBeat.i(128229);
        AppMethodBeat.o(128229);
    }

    static /* synthetic */ void Z(Context context, String str) {
        AppMethodBeat.i(128245);
        Y(context, str);
        AppMethodBeat.o(128245);
    }

    static /* synthetic */ void d(LoginUI loginUI) {
        AppMethodBeat.i(128247);
        loginUI.goBack();
        AppMethodBeat.o(128247);
    }

    static /* synthetic */ void f(LoginUI loginUI) {
        AppMethodBeat.i(196873);
        loginUI.bpf();
        AppMethodBeat.o(196873);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b2g;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128230);
        super.onCreate(bundle);
        getWindow().getDecorView().setBackgroundColor(getContext().getResources().getColor(R.color.a2s));
        String str = "";
        if (d.KyR || BuildInfo.IS_FLAVOR_BLUE) {
            str = getString(R.string.wx) + h.jr(this);
        }
        this.sceneType = getIntent().getIntExtra("login_type", 0);
        setMMTitle(str);
        setActionbarColor(getResources().getColor(R.color.a2r));
        hideActionbarLine();
        com.tencent.mm.plugin.account.a.a.jRu.Xc();
        this.kbV = com.tencent.mm.plugin.b.a.caK();
        initView();
        this.kmf = new b();
        this.klv = getIntent().getBooleanExtra("from_switch_account", false);
        this.klw = bf.iDu.aA(WXUtil.LAST_LOGIN_WEXIN_USERNAME, "");
        int[] intArrayExtra = getIntent().getIntArrayExtra("kv_report_login_method_data");
        if (intArrayExtra != null) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14262, Integer.valueOf(intArrayExtra[0]), Integer.valueOf(intArrayExtra[1]), Integer.valueOf(intArrayExtra[2]), Integer.valueOf(intArrayExtra[3]), Integer.valueOf(intArrayExtra[4]));
        }
        com.tencent.mm.cr.d.hiy();
        AppMethodBeat.o(128230);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(128231);
        EventCenter.instance.addListener(this.kkK);
        super.onResume();
        if (this.sceneType == 0) {
            StringBuilder sb = new StringBuilder();
            g.aAf();
            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L100_100_logout,");
            g.aAf();
            com.tencent.mm.plugin.b.a.j(true, append.append(com.tencent.mm.kernel.a.FN("L100_100_logout")).append(",1").toString());
            com.tencent.mm.plugin.b.a.bxk("L100_100_logout");
            AppMethodBeat.o(128231);
            return;
        }
        if (this.sceneType == 1) {
            StringBuilder sb2 = new StringBuilder();
            g.aAf();
            StringBuilder append2 = sb2.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L400_100_login,");
            g.aAf();
            com.tencent.mm.plugin.b.a.j(true, append2.append(com.tencent.mm.kernel.a.FN("L400_100_login")).append(",1").toString());
            com.tencent.mm.plugin.b.a.bxk("L400_100_login");
        }
        AppMethodBeat.o(128231);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(128232);
        super.onPause();
        EventCenter.instance.removeListener(this.kkK);
        if (this.sceneType == 0) {
            StringBuilder sb = new StringBuilder();
            g.aAf();
            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L100_100_logout,");
            g.aAf();
            com.tencent.mm.plugin.b.a.j(false, append.append(com.tencent.mm.kernel.a.FN("L100_100_logout")).append(",2").toString());
            AppMethodBeat.o(128232);
            return;
        }
        if (this.sceneType == 1) {
            StringBuilder sb2 = new StringBuilder();
            g.aAf();
            StringBuilder append2 = sb2.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L400_100_login,");
            g.aAf();
            com.tencent.mm.plugin.b.a.j(false, append2.append(com.tencent.mm.kernel.a.FN("L400_100_login")).append(",2").toString());
        }
        AppMethodBeat.o(128232);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(128233);
        if (this.kmf != null) {
            this.kmf.close();
        }
        g.azz().b(701, this);
        g.azz().b(252, this);
        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIN("ie_login_id");
        super.onDestroy();
        AppMethodBeat.o(128233);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(128234);
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
        this.kmQ = (MMClearEditText) this.kmS.getContentEditText();
        c.f(this.kmQ).aoq(16).a((c.a) null);
        this.kmP.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass22 */

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(128223);
                if (LoginUI.this.kmY[0]) {
                    LoginUI.this.kmY[0] = false;
                    com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIL("ie_login_id");
                }
                com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIM("ie_login_id");
                AppMethodBeat.o(128223);
            }
        });
        this.kmT = (Button) findViewById(R.id.erp);
        this.kmT.setEnabled(false);
        this.kmU = (Button) findViewById(R.id.erw);
        this.kml = (Button) findViewById(R.id.erk);
        this.kmV = findViewById(R.id.ero);
        this.kmV.setVisibility(0);
        this.klS = (Button) findViewById(R.id.es1);
        this.klU = findViewById(R.id.d9x);
        this.klT = (Button) findViewById(R.id.es3);
        this.klV = (Button) findViewById(R.id.es8);
        this.kmb = (ResizeLayout) findViewById(R.id.h5e);
        this.kmW = (MMKeyboardUperView) findViewById(R.id.hcl);
        this.kmb.setOnSizeChanged(new ResizeLayout.a() {
            /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass23 */

            @Override // com.tencent.mm.plugin.account.ui.ResizeLayout.a
            public final void bpj() {
                AppMethodBeat.i(128224);
                LoginUI.b(LoginUI.this);
                AppMethodBeat.o(128224);
            }
        });
        this.klS.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass24 */

            public final void onClick(View view) {
                AppMethodBeat.i(128225);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LoginUI.Z(LoginUI.this, LoginUI.this.getString(R.string.ema) + LocaleUtil.getApplicationLanguage());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128225);
            }
        });
        this.klT.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass25 */

            public final void onClick(View view) {
                AppMethodBeat.i(128226);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LoginUI.Z(LoginUI.this, LoginUI.this.getString(R.string.diw, new Object[]{LocaleUtil.getApplicationLanguage()}));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128226);
            }
        });
        final e eVar = new e((Context) this, 1, false);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass26 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(128227);
                if (mVar.gKQ()) {
                    mVar.kV(5001, R.string.j1w);
                    mVar.kV(5002, R.string.j1t);
                }
                AppMethodBeat.o(128227);
            }
        };
        eVar.PGl = new e.b() {
            /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass27 */

            @Override // com.tencent.mm.ui.widget.a.e.b
            public final void onDismiss() {
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass28 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(128228);
                switch (menuItem.getItemId()) {
                    case 5001:
                        LoginUI.c(LoginUI.this);
                        AppMethodBeat.o(128228);
                        return;
                    case 5002:
                        LoginUI.Z(LoginUI.this, LoginUI.this.getString(R.string.j1u) + LocaleUtil.getApplicationLanguage());
                        break;
                }
                AppMethodBeat.o(128228);
            }
        };
        if (LocaleUtil.isSimplifiedChineseAppLang()) {
            this.klV.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(128203);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    LoginUI.c(LoginUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(128203);
                }
            });
        } else {
            this.klU.setVisibility(8);
            this.klV.setText(R.string.els);
            this.klV.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(128204);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    eVar.dGm();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(128204);
                }
            });
        }
        setMMTitle("");
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128205);
                LoginUI.d(LoginUI.this);
                AppMethodBeat.o(128205);
                return true;
            }
        }, R.raw.actionbar_icon_close_black);
        final boolean[] zArr = {false};
        this.kmT.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(128206);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (zArr[0]) {
                    zArr[0] = false;
                } else {
                    LoginUI.this.dYB = com.tencent.mm.plugin.normsg.a.c.TN(2);
                    com.tencent.mm.plugin.normsg.a.d.INSTANCE.aA("ce_login_id", "<LoginByID>", LoginUI.this.dYB);
                    com.tencent.mm.plugin.normsg.a.d.INSTANCE.a("ce_login_id", MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, 65535));
                    com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIQ("ce_login_id");
                }
                LoginUI.f(LoginUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128206);
            }
        });
        this.kmT.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass6 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(128207);
                switch (motionEvent.getAction()) {
                    case 0:
                    case 5:
                        zArr[0] = true;
                        LoginUI.this.dYB = com.tencent.mm.plugin.normsg.a.c.TN(2);
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aA("ce_login_id", "<LoginByID>", LoginUI.this.dYB);
                        break;
                    case 1:
                    case 6:
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.a("ce_login_id", motionEvent);
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIQ("ce_login_id");
                        break;
                }
                AppMethodBeat.o(128207);
                return false;
            }
        });
        this.kmU.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(128208);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(LoginUI.this, MobileInputUI.class);
                int[] iArr = new int[5];
                iArr[0] = 2;
                intent.putExtra("mobile_input_purpose", 1);
                intent.putExtra("kv_report_login_method_data", iArr);
                intent.putExtra("from_switch_account", LoginUI.this.klv);
                LoginUI loginUI = LoginUI.this;
                a bl = new a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(loginUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/LoginUI$15", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                loginUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(loginUI, "com/tencent/mm/plugin/account/ui/LoginUI$15", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                LoginUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128208);
            }
        });
        this.kjv = getIntent().getStringExtra("auth_ticket");
        if (!Util.isNullOrNil(this.kjv)) {
            this.kmP.setText(Util.nullAsNil(g.bpk()));
            this.kmQ.setText(Util.nullAsNil(g.bpl()));
            new MMHandler().postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(128209);
                    LoginUI.f(LoginUI.this);
                    AppMethodBeat.o(128209);
                }
            }, 500);
        }
        this.kmP.addTextChangedListener(this.aws);
        this.kmQ.addTextChangedListener(this.aws);
        this.kmQ.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass9 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(128210);
                if (i2 == 6 || i2 == 5) {
                    LoginUI.f(LoginUI.this);
                    AppMethodBeat.o(128210);
                    return true;
                }
                AppMethodBeat.o(128210);
                return false;
            }
        });
        this.kmQ.setOnKeyListener(new View.OnKeyListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass10 */

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(128211);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                bVar.pH(i2);
                bVar.bm(keyEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginUI$18", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
                if (66 == i2 && keyEvent.getAction() == 0) {
                    LoginUI.f(LoginUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/account/ui/LoginUI$18", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(128211);
                    return true;
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/account/ui/LoginUI$18", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(128211);
                return false;
            }
        });
        if (ChannelUtil.shouldShowGprsAlert) {
            com.tencent.mm.plugin.account.a.a.jRu.t(this);
        }
        String stringExtra = getIntent().getStringExtra("login_username");
        this.kmX = getIntent().getBooleanExtra("from_deep_link", false);
        if (!Util.isNullOrNil(stringExtra)) {
            this.kmP.setText(stringExtra);
        }
        if (!BuildInfo.EX_DEVICE_LOGIN) {
            if (ao.gJH() && !ao.gJL()) {
                d.a aVar = com.tencent.mm.plugin.account.model.d.kiq;
            }
            AppMethodBeat.o(128234);
        }
        this.kml.setVisibility(0);
        this.kml.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass11 */

            public final void onClick(View view) {
                AppMethodBeat.i(128212);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.br.c.V(LoginUI.this, "login_exdevice", ".ui.LoginAsExDeviceUI");
                LoginUI.this.overridePendingTransition(R.anim.dn, R.anim.s);
                com.tencent.mm.plugin.report.service.h.INSTANCE.Ip(2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128212);
            }
        });
        AppMethodBeat.o(128234);
    }

    private static void Y(Context context, String str) {
        AppMethodBeat.i(128235);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
        com.tencent.mm.br.c.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.o(128235);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(128236);
        if (i2 == 4) {
            goBack();
            AppMethodBeat.o(128236);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(128236);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(128237);
        hideVKB();
        com.tencent.mm.plugin.b.a.bxl(this.kbV);
        q.gmZ();
        finish();
        AppMethodBeat.o(128237);
    }

    private boolean n(int i2, int i3, String str) {
        String ayX;
        AppMethodBeat.i(128238);
        if (com.tencent.mm.plugin.account.a.a.jRu.a(getContext(), i2, i3, str)) {
            AppMethodBeat.o(128238);
            return true;
        }
        if (i2 == 4) {
            switch (i3) {
                case -2023:
                case -100:
                    com.tencent.mm.kernel.a.hold();
                    AppCompatActivity context = getContext();
                    g.aAf();
                    if (TextUtils.isEmpty(com.tencent.mm.kernel.a.ayX())) {
                        ayX = com.tencent.mm.cb.a.aI(getContext(), R.string.ev5);
                    } else {
                        g.aAf();
                        ayX = com.tencent.mm.kernel.a.ayX();
                    }
                    com.tencent.mm.ui.base.h.a(context, ayX, getContext().getString(R.string.zb), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass16 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(128218);
                            LoginUI.l(LoginUI.this);
                            AppMethodBeat.o(128218);
                        }
                    }, new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass17 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(128219);
                            LoginUI.l(LoginUI.this);
                            AppMethodBeat.o(128219);
                        }
                    });
                    AppMethodBeat.o(128238);
                    return true;
                case -311:
                case -310:
                case -6:
                    g.azz().a(701, this);
                    g.azz().a(252, this);
                    if (this.kdp == null) {
                        this.kdp = SecurityImage.a.a(this, this.klt.kmJ, this.klt.kdr, this.klt.kds, this.klt.kdt, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass14 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(128216);
                                if (LoginUI.this.kdp == null) {
                                    Log.e("MicroMsg.LoginUI", "secimg is null!");
                                    AppMethodBeat.o(128216);
                                    return;
                                }
                                Log.d("MicroMsg.LoginUI", "imgSid:" + LoginUI.this.klt.kds + " img len" + LoginUI.this.klt.kdr.length + " " + f.apq());
                                final t tVar = new t(LoginUI.this.klt.account, LoginUI.this.klt.kdq, LoginUI.this.klt.kmJ, LoginUI.this.kdp.getSecImgCode(), LoginUI.this.kdp.getSecImgSid(), LoginUI.this.kdp.getSecImgEncryptKey(), 2, "", false, false);
                                g.azz().a(tVar, 0);
                                LoginUI loginUI = LoginUI.this;
                                LoginUI loginUI2 = LoginUI.this;
                                LoginUI.this.getString(R.string.zb);
                                loginUI.gtM = com.tencent.mm.ui.base.h.a((Context) loginUI2, LoginUI.this.getString(R.string.emm), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                    /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass14.AnonymousClass1 */

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(128215);
                                        g.azz().a(tVar);
                                        g.azz().b(701, LoginUI.this);
                                        g.azz().b(252, LoginUI.this);
                                        AppMethodBeat.o(128215);
                                    }
                                });
                                AppMethodBeat.o(128216);
                            }
                        }, null, new DialogInterface.OnDismissListener() {
                            /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass15 */

                            public final void onDismiss(DialogInterface dialogInterface) {
                                AppMethodBeat.i(128217);
                                LoginUI.this.kdp = null;
                                AppMethodBeat.o(128217);
                            }
                        }, this.klt);
                    } else {
                        Log.d("MicroMsg.LoginUI", "imgSid:" + this.klt.kds + " img len" + this.klt.kdr.length + " " + f.apq());
                        this.kdp.b(this.klt.kmJ, this.klt.kdr, this.klt.kds, this.klt.kdt);
                    }
                    AppMethodBeat.o(128238);
                    return true;
                case -205:
                    Log.i("MicroMsg.LoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", Util.secPrint(this.kjv), this.klx);
                    g.a(this.klt);
                    com.tencent.mm.plugin.b.a.bxl("L600_100");
                    Intent intent = new Intent();
                    intent.putExtra("auth_ticket", this.kjv);
                    intent.putExtra("binded_mobile", this.klX);
                    intent.putExtra("close_safe_device_style", this.klx);
                    intent.putExtra("from_source", 1);
                    com.tencent.mm.plugin.account.a.a.jRt.g(this, intent);
                    AppMethodBeat.o(128238);
                    return true;
                case -140:
                    if (!Util.isNullOrNil(this.edo)) {
                        y.m(this, str, this.edo);
                    }
                    AppMethodBeat.o(128238);
                    return true;
                case -75:
                    y.dz(getContext());
                    AppMethodBeat.o(128238);
                    return true;
                case -72:
                    com.tencent.mm.ui.base.h.n(getContext(), R.string.g0b, R.string.zb);
                    AppMethodBeat.o(128238);
                    return true;
                case -9:
                    com.tencent.mm.ui.base.h.n(this, R.string.em7, R.string.em8);
                    AppMethodBeat.o(128238);
                    return true;
                case -3:
                    com.tencent.mm.ui.base.h.n(this, R.string.by2, R.string.em8);
                    AppMethodBeat.o(128238);
                    return true;
                case -1:
                    if (g.azz().aYS() == 5) {
                        com.tencent.mm.ui.base.h.n(this, R.string.fbf, R.string.fbe);
                        AppMethodBeat.o(128238);
                        return true;
                    }
                    AppMethodBeat.o(128238);
                    return false;
            }
        }
        boolean a2 = this.kmf.a(this, new ae(i2, i3, str));
        AppMethodBeat.o(128238);
        return a2;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, final com.tencent.mm.ak.q qVar) {
        boolean z;
        AppMethodBeat.i(128239);
        Log.i("MicroMsg.LoginUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (qVar.getType() == 252 || qVar.getType() == 701) {
            g.azz().b(252, this);
            g.azz().b(701, this);
            this.edo = ((t) qVar).bfk();
            this.klt.kds = ((t) qVar).bfl();
            this.klt.kdr = ((t) qVar).bfm();
            this.klt.kdt = ((t) qVar).bfn();
            this.klt.kmJ = ((t) qVar).getSecCodeType();
            this.klt.account = ((t) qVar).account;
            if (i3 == -205) {
                this.kjv = ((t) qVar).bbH();
                this.klX = ((t) qVar).bfp();
                this.klx = ((t) qVar).bfs();
            }
            if (i2 == 4 && (i3 == -16 || i3 == -17)) {
                g.azz().a(new bu(new bu.a() {
                    /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass18 */

                    @Override // com.tencent.mm.model.bu.a
                    public final void a(com.tencent.mm.network.g gVar) {
                        AppMethodBeat.i(128220);
                        if (gVar == null) {
                            AppMethodBeat.o(128220);
                            return;
                        }
                        g.aAf();
                        gVar.aZh().a(new byte[0], new byte[0], new byte[0], com.tencent.mm.kernel.a.getUin());
                        AppMethodBeat.o(128220);
                    }
                }), 0);
                z = true;
            } else {
                z = false;
            }
            if (z || (i2 == 0 && i3 == 0)) {
                com.tencent.mm.kernel.a.unhold();
                l.boe();
                y.St(this.klt.account);
                String aA = bf.iDu.aA(WXUtil.LAST_LOGIN_WEXIN_USERNAME, "");
                com.tencent.mm.platformtools.t.dr(this);
                if (this.klv) {
                    ch.iFO.aR(this.klw, aA);
                    ch.iFO.h(z.aTY(), z.aUS());
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14978, 1, 9, ch.iFO.aWp());
                }
                y.showAddrBookUploadConfirm(this, new Runnable() {
                    /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass19 */

                    public final void run() {
                        AppMethodBeat.i(128221);
                        Log.d("MicroMsg.LoginUI", "onSceneEnd, in runnable");
                        Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(LoginUI.this);
                        bZ.addFlags(67108864);
                        bZ.putExtra("kstyle_show_bind_mobile_afterauth", ((t) qVar).bfq());
                        bZ.putExtra("kstyle_bind_wording", ((t) qVar).bfr());
                        bZ.putExtra("kstyle_bind_recommend_show", ((t) qVar).bft());
                        LoginUI loginUI = LoginUI.this;
                        a bl = new a().bl(bZ);
                        com.tencent.mm.hellhoundlib.a.a.a(loginUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/LoginUI$26", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        loginUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(loginUI, "com/tencent/mm/plugin/account/ui/LoginUI$26", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        LoginUI.this.finish();
                        AppMethodBeat.o(128221);
                    }
                }, false, 2);
                StringBuilder sb = new StringBuilder();
                g.aAf();
                StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_900_phone,");
                g.aAf();
                com.tencent.mm.plugin.b.a.DX(append.append(com.tencent.mm.kernel.a.FN("R200_900_phone")).append(",4").toString());
                if (this.kmX) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11930, MMApplicationContext.getContext().getSharedPreferences("randomid_prefs", com.tencent.mm.compatible.util.g.aps()).getString("randomID", ""), 4);
                }
                AppMethodBeat.o(128239);
            } else if (i3 == -106) {
                y.g(this, str, 32644);
                AppMethodBeat.o(128239);
            } else if (i3 == -217) {
                y.a(this, com.tencent.mm.platformtools.e.a((t) qVar), i3);
                AppMethodBeat.o(128239);
            } else if (n(i2, i3, str)) {
                AppMethodBeat.o(128239);
            } else if (i3 != -5) {
                com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
                if (Dk == null || !Dk.a(this, null, null)) {
                    Toast.makeText(this, getString(R.string.de5, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
                    AppMethodBeat.o(128239);
                    return;
                }
                AppMethodBeat.o(128239);
            } else if (WeChatBrands.AppInfo.current().isMainland()) {
                Toast.makeText(this, getString(R.string.emx), 0).show();
                AppMethodBeat.o(128239);
            } else {
                Toast.makeText(this, getString(R.string.em8), 0).show();
                AppMethodBeat.o(128239);
            }
        } else {
            AppMethodBeat.o(128239);
        }
    }

    private void bpf() {
        AppMethodBeat.i(128240);
        this.klt.account = this.kmP.getText().toString().trim();
        this.klt.kdq = this.kmQ.getText().toString();
        if (this.klt.account.equals("")) {
            com.tencent.mm.ui.base.h.n(this, R.string.hvs, R.string.em8);
            AppMethodBeat.o(128240);
        } else if (this.klt.kdq.equals("")) {
            com.tencent.mm.ui.base.h.n(this, R.string.hvk, R.string.em8);
            AppMethodBeat.o(128240);
        } else {
            hideVKB();
            this.kmF.b(this, new Runnable() {
                /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass20 */

                public final void run() {
                    AppMethodBeat.i(169137);
                    LoginUI.m(LoginUI.this);
                    AppMethodBeat.o(169137);
                }
            });
            AppMethodBeat.o(128240);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(169139);
        this.kmF.a(this, i2, strArr, iArr);
        AppMethodBeat.o(169139);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(128241);
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.s);
        AppMethodBeat.o(128241);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Bundle bundleExtra;
        int i4 = 0;
        AppMethodBeat.i(128242);
        super.onActivityResult(i2, i3, intent);
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Boolean.valueOf(intent == null);
        Log.d("MicroMsg.LoginUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", objArr);
        if (i3 == -1) {
            if (i2 == 1024 && intent != null) {
                String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
                int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
                Object[] objArr2 = new Object[3];
                objArr2[0] = Boolean.valueOf(Util.isNullOrNil(stringExtra));
                if (!Util.isNullOrNil(stringExtra)) {
                    i4 = stringExtra.length();
                }
                objArr2[1] = Integer.valueOf(i4);
                objArr2[2] = Integer.valueOf(intExtra);
                Log.d("MicroMsg.LoginUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", objArr2);
                if (intExtra == -217) {
                    this.klt.kdq = stringExtra;
                    bpf();
                    AppMethodBeat.o(128242);
                    return;
                }
                AppMethodBeat.o(128242);
                return;
            } else if (i2 == 32644 && intent != null && (bundleExtra = intent.getBundleExtra("result_data")) != null && bundleExtra.getString("go_next", "").equals("auth_again")) {
                bpf();
            }
        }
        AppMethodBeat.o(128242);
    }

    static /* synthetic */ void a(LoginUI loginUI) {
        AppMethodBeat.i(128243);
        if (Util.isNullOrNil(loginUI.kmP.getText().toString()) || Util.isNullOrNil(loginUI.kmQ.getText().toString())) {
            loginUI.kmT.setEnabled(false);
            AppMethodBeat.o(128243);
            return;
        }
        loginUI.kmT.setEnabled(true);
        AppMethodBeat.o(128243);
    }

    static /* synthetic */ void b(LoginUI loginUI) {
        AppMethodBeat.i(128244);
        View currentFocus = loginUI.getWindow().getCurrentFocus();
        if (currentFocus != null) {
            int[] iArr = new int[2];
            currentFocus.getLocationInWindow(iArr);
            final int height = (iArr[1] - loginUI.getSupportActionBar().getHeight()) - 128;
            if (height > 0) {
                loginUI.kmW.post(new Runnable() {
                    /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass13 */

                    public final void run() {
                        AppMethodBeat.i(128214);
                        LoginUI.this.kmW.smoothScrollBy(0, height);
                        AppMethodBeat.o(128214);
                    }
                });
            }
        }
        AppMethodBeat.o(128244);
    }

    static /* synthetic */ void c(LoginUI loginUI) {
        AppMethodBeat.i(128246);
        Y(loginUI, loginUI.getString(R.string.j1x) + LocaleUtil.getApplicationLanguage());
        AppMethodBeat.o(128246);
    }

    static /* synthetic */ void l(LoginUI loginUI) {
        AppMethodBeat.i(169140);
        g.aAi().FS("");
        Intent intent = new Intent();
        intent.putExtra("Intro_Switch", true).addFlags(67108864);
        loginUI.finish();
        com.tencent.mm.plugin.account.a.a.jRt.o(intent, loginUI);
        AppMethodBeat.o(169140);
    }

    static /* synthetic */ void m(LoginUI loginUI) {
        AppMethodBeat.i(196874);
        g.azz().a(252, loginUI);
        g.azz().a(701, loginUI);
        final t tVar = new t(loginUI.klt.account, loginUI.klt.kdq, loginUI.kjv, 2);
        g.azz().a(tVar, 0);
        loginUI.getString(R.string.zb);
        loginUI.gtM = com.tencent.mm.ui.base.h.a((Context) loginUI, loginUI.getString(R.string.emm), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginUI.AnonymousClass21 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(169138);
                g.azz().a(tVar);
                g.azz().b(252, LoginUI.this);
                g.azz().b(701, LoginUI.this);
                AppMethodBeat.o(169138);
            }
        });
        AppMethodBeat.o(196874);
    }
}
