package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aw.b;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.account.model.d;
import com.tencent.mm.plugin.account.ui.ResizeLayout;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.a.e;

public class MobileInputUI extends MMActivity {
    protected String countryCode = null;
    protected int iDM;
    protected String jbZ = null;
    protected LinearLayout kaX;
    protected TextView kaZ;
    protected String kbV;
    protected String kbb = null;
    protected q kdn;
    private IListener kkK = new IListener<lz>() {
        /* class com.tencent.mm.plugin.account.ui.MobileInputUI.AnonymousClass1 */

        {
            AppMethodBeat.i(161704);
            this.__eventId = lz.class.getName().hashCode();
            AppMethodBeat.o(161704);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lz lzVar) {
            AppMethodBeat.i(128333);
            lz lzVar2 = lzVar;
            if (lzVar2 == null || lzVar2.dRz == null) {
                AppMethodBeat.o(128333);
                return false;
            }
            Log.i("MicroMsg.MobileInputUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", lzVar2.dRz.content, lzVar2.dRz.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", lzVar2.dRz.content);
            intent.putExtra("key_disaster_url", lzVar2.dRz.url);
            intent.setClass(MMApplicationContext.getContext(), DisasterUI.class).addFlags(268435456);
            Context context = MMApplicationContext.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/account/ui/MobileInputUI$1", "callback", "(Lcom/tencent/mm/autogen/events/LoginDisasterEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/account/ui/MobileInputUI$1", "callback", "(Lcom/tencent/mm/autogen/events/LoginDisasterEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(128333);
            return true;
        }
    };
    protected EditText klM;
    protected Button klS;
    protected Button klT;
    private View klU;
    protected Button klV;
    protected String klq = null;
    protected boolean klv;
    private x kmF = new x();
    protected MMFormInputView kmS;
    private MMKeyboardUperView kmW;
    protected boolean kmX = false;
    private final int kmZ = 128;
    private ResizeLayout kmb;
    private Button kml;
    protected int[] kmr = new int[5];
    protected MMFormInputView knB;
    protected EditText knC;
    protected MMFormVerifyCodeInputView knD;
    protected View knE;
    protected CheckBox knF;
    protected TextView knG;
    protected Button knH;
    protected TextView knI;
    protected TextView knJ;
    protected TextView knK;
    protected Button knL;
    protected View knM;
    protected boolean knN = true;
    protected String knO = null;
    protected String knP = null;
    private int knQ = 0;
    private b knR;
    protected boolean knS;
    private String knT = "";
    private String knU = "";

    public interface b {
        void a(a aVar);

        void a(MobileInputUI mobileInputUI);

        void start();

        void stop();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MobileInputUI() {
        AppMethodBeat.i(128356);
        AppMethodBeat.o(128356);
    }

    static /* synthetic */ void Z(Context context, String str) {
        AppMethodBeat.i(128372);
        Y(context, str);
        AppMethodBeat.o(128372);
    }

    static /* synthetic */ void b(MobileInputUI mobileInputUI) {
        AppMethodBeat.i(128370);
        mobileInputUI.goBack();
        AppMethodBeat.o(128370);
    }

    static /* synthetic */ boolean e(MobileInputUI mobileInputUI) {
        AppMethodBeat.i(128374);
        boolean bpo = mobileInputUI.bpo();
        AppMethodBeat.o(128374);
        return bpo;
    }

    static /* synthetic */ boolean f(MobileInputUI mobileInputUI) {
        AppMethodBeat.i(128375);
        boolean bpp = mobileInputUI.bpp();
        AppMethodBeat.o(128375);
        return bpp;
    }

    static /* synthetic */ void i(MobileInputUI mobileInputUI) {
        AppMethodBeat.i(169143);
        mobileInputUI.bpr();
        AppMethodBeat.o(169143);
    }

    /* access modifiers changed from: protected */
    public enum a {
        GoBack,
        GoNext;

        public static a valueOf(String str) {
            AppMethodBeat.i(128354);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(128354);
            return aVar;
        }

        static {
            AppMethodBeat.i(128355);
            AppMethodBeat.o(128355);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bax;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128357);
        super.onCreate(bundle);
        super.setRequestedOrientation(1);
        getWindow().getDecorView().setBackgroundColor(getContext().getResources().getColor(R.color.a2s));
        this.knQ = getIntent().getIntExtra("mobile_input_purpose", 0);
        this.iDM = getIntent().getIntExtra("mobile_auth_type", 0);
        this.knS = getIntent().getBooleanExtra("can_finish", false);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.MobileInputUI.AnonymousClass12 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128345);
                MobileInputUI.b(MobileInputUI.this);
                AppMethodBeat.o(128345);
                return true;
            }
        }, R.raw.actionbar_icon_close_black);
        setActionbarColor(getContext().getResources().getColor(R.color.a2r));
        hideActionbarLine();
        switch (this.knQ) {
            case -1:
                this.knR = new m();
                break;
            case 0:
            default:
                Log.e("MicroMsg.MobileInputUI", "wrong purpose %s", Integer.valueOf(this.knQ));
                finish();
                AppMethodBeat.o(128357);
                return;
            case 1:
                if (Util.isNullOrNil(getIntent().getStringExtra("auth_ticket"))) {
                    int[] intArrayExtra = getIntent().getIntArrayExtra("kv_report_login_method_data");
                    if (intArrayExtra != null) {
                        this.kmr = intArrayExtra;
                    }
                    this.knR = new j();
                    break;
                } else {
                    this.knR = new m();
                    break;
                }
            case 2:
                this.knR = new l();
                break;
            case 3:
                this.knR = new i();
                break;
            case 4:
                this.knR = new k();
                break;
        }
        this.countryCode = PhoneFormater.pureCountryCode(Util.nullAs(getIntent().getStringExtra("couttry_code"), ""));
        this.jbZ = Util.nullAs(getIntent().getStringExtra("country_name"), "");
        this.klq = Util.nullAsNil(getIntent().getStringExtra("iso_code"));
        this.kbb = Util.nullAs(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.knO = PhoneFormater.countryCodeWithPlus(this.countryCode);
        this.knP = Util.nullAs(getIntent().getStringExtra("input_mobile_number"), "");
        this.kbV = com.tencent.mm.plugin.b.a.caK();
        initView();
        this.kmX = getIntent().getBooleanExtra("from_deep_link", false);
        if (this.kmX && !Util.isNullOrNil(this.knO) && !Util.isNullOrNil(this.knP)) {
            this.knB.setText(this.knP);
        }
        this.knR.a(this);
        if (!BuildInfo.EX_DEVICE_LOGIN) {
            if (ao.gJH() && !ao.gJL()) {
                d.a aVar = d.kiq;
            }
            this.klv = getIntent().getBooleanExtra("from_switch_account", false);
            com.tencent.mm.cr.d.hiy();
            AppMethodBeat.o(128357);
        }
        this.kml.setVisibility(0);
        this.kml.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.MobileInputUI.AnonymousClass15 */

            public final void onClick(View view) {
                AppMethodBeat.i(128347);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c.V(MobileInputUI.this, "login_exdevice", ".ui.LoginAsExDeviceUI");
                MobileInputUI.this.overridePendingTransition(R.anim.dn, R.anim.s);
                h.INSTANCE.Ip(3);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128347);
            }
        });
        this.klv = getIntent().getBooleanExtra("from_switch_account", false);
        com.tencent.mm.cr.d.hiy();
        AppMethodBeat.o(128357);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(128358);
        EventCenter.instance.addListener(this.kkK);
        super.onResume();
        this.knR.start();
        AppMethodBeat.o(128358);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(128359);
        super.onPause();
        EventCenter.instance.removeListener(this.kkK);
        this.knR.stop();
        AppMethodBeat.o(128359);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(128360);
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.s);
        h.INSTANCE.a(14262, Integer.valueOf(this.kmr[0]), Integer.valueOf(this.kmr[1]), Integer.valueOf(this.kmr[2]), Integer.valueOf(this.kmr[3]), Integer.valueOf(this.kmr[4]));
        AppMethodBeat.o(128360);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(128361);
        if (bpo()) {
            com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIN("ie_reg_eu");
        }
        if (bpp()) {
            com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIN("ie_login");
        }
        if (this.knD != null) {
            this.knD.reset();
        }
        super.onDestroy();
        AppMethodBeat.o(128361);
    }

    private boolean bpo() {
        return this.knQ == 2;
    }

    private boolean bpp() {
        return this.iDM == 7 || this.iDM == 6;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(128362);
        this.kmS = (MMFormInputView) findViewById(R.id.hlj);
        this.klM = this.kmS.getContentEditText();
        com.tencent.mm.ui.tools.b.c.f(this.klM).aoq(16).a((c.a) null);
        this.knB = (MMFormInputView) findViewById(R.id.fh3);
        this.knB.setInputType(3);
        this.knC = this.knB.getContentEditText();
        this.knD = (MMFormVerifyCodeInputView) findViewById(R.id.htp);
        this.knD.setInputType(3);
        this.kaX = (LinearLayout) findViewById(R.id.bgn);
        this.kaZ = (TextView) findViewById(R.id.bgp);
        this.knE = findViewById(R.id.gyz);
        this.knF = (CheckBox) findViewById(R.id.gz6);
        this.knG = (TextView) findViewById(R.id.gz5);
        this.knH = (Button) findViewById(R.id.fz0);
        this.knI = (TextView) findViewById(R.id.gzn);
        this.knJ = (TextView) findViewById(R.id.esg);
        this.knK = (TextView) findViewById(R.id.fh0);
        this.knL = (Button) findViewById(R.id.erw);
        this.kml = (Button) findViewById(R.id.erk);
        this.klS = (Button) findViewById(R.id.es1);
        this.klT = (Button) findViewById(R.id.es3);
        this.klU = findViewById(R.id.d9x);
        this.klV = (Button) findViewById(R.id.es8);
        this.knM = findViewById(R.id.aac);
        this.kmb = (ResizeLayout) findViewById(R.id.h5e);
        this.kmW = (MMKeyboardUperView) findViewById(R.id.hcl);
        this.kaX.setVisibility(8);
        this.kmS.setVisibility(8);
        this.knD.setVisibility(8);
        this.knB.setVisibility(8);
        this.knI.setVisibility(8);
        this.knJ.setVisibility(8);
        this.knH.setVisibility(8);
        this.knE.setVisibility(8);
        this.knL.setVisibility(8);
        this.kmb.setOnSizeChanged(new ResizeLayout.a() {
            /* class com.tencent.mm.plugin.account.ui.MobileInputUI.AnonymousClass16 */

            @Override // com.tencent.mm.plugin.account.ui.ResizeLayout.a
            public final void bpj() {
                AppMethodBeat.i(128348);
                MobileInputUI.c(MobileInputUI.this);
                AppMethodBeat.o(128348);
            }
        });
        this.klS.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.MobileInputUI.AnonymousClass17 */

            public final void onClick(View view) {
                AppMethodBeat.i(128349);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                MobileInputUI.Z(MobileInputUI.this, MobileInputUI.this.getString(R.string.ema) + LocaleUtil.getApplicationLanguage());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128349);
            }
        });
        this.klT.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.MobileInputUI.AnonymousClass18 */

            public final void onClick(View view) {
                AppMethodBeat.i(128350);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                MobileInputUI.Z(MobileInputUI.this, MobileInputUI.this.getString(R.string.diw, new Object[]{LocaleUtil.getApplicationLanguage()}));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128350);
            }
        });
        final e eVar = new e((Context) this, 1, false);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.account.ui.MobileInputUI.AnonymousClass19 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(128351);
                if (mVar.gKQ()) {
                    mVar.kV(5001, R.string.j1w);
                    mVar.kV(5002, R.string.j1t);
                }
                AppMethodBeat.o(128351);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.account.ui.MobileInputUI.AnonymousClass20 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(128352);
                switch (menuItem.getItemId()) {
                    case 5001:
                        MobileInputUI.d(MobileInputUI.this);
                        AppMethodBeat.o(128352);
                        return;
                    case 5002:
                        MobileInputUI.Z(MobileInputUI.this, MobileInputUI.this.getString(R.string.j1u) + LocaleUtil.getApplicationLanguage());
                        break;
                }
                AppMethodBeat.o(128352);
            }
        };
        eVar.PGl = new e.b() {
            /* class com.tencent.mm.plugin.account.ui.MobileInputUI.AnonymousClass21 */

            @Override // com.tencent.mm.ui.widget.a.e.b
            public final void onDismiss() {
            }
        };
        if (LocaleUtil.isSimplifiedChineseAppLang()) {
            this.klV.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.ui.MobileInputUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(128334);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    MobileInputUI.d(MobileInputUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(128334);
                }
            });
        } else {
            this.klU.setVisibility(8);
            this.klV.setText(R.string.els);
            this.klV.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.ui.MobileInputUI.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(128335);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    eVar.dGm();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(128335);
                }
            });
        }
        final boolean[] zArr = {true};
        this.knC.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.mm.plugin.account.ui.MobileInputUI.AnonymousClass4 */

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(128336);
                if (z) {
                    zArr[0] = true;
                    AppMethodBeat.o(128336);
                    return;
                }
                if (MobileInputUI.e(MobileInputUI.this)) {
                    com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIN("ie_reg_eu");
                }
                if (MobileInputUI.f(MobileInputUI.this)) {
                    com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIN("ie_login");
                }
                AppMethodBeat.o(128336);
            }
        });
        this.knC.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.account.ui.MobileInputUI.AnonymousClass5 */

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(128337);
                MobileInputUI.this.knH.setEnabled(MobileInputUI.this.bpq());
                AppMethodBeat.o(128337);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(128338);
                if (zArr[0]) {
                    zArr[0] = false;
                    if (MobileInputUI.e(MobileInputUI.this)) {
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIL("ie_reg_eu");
                    }
                    if (MobileInputUI.f(MobileInputUI.this)) {
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIL("ie_login");
                    }
                }
                if (MobileInputUI.e(MobileInputUI.this)) {
                    com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIM("ie_reg_eu");
                }
                if (MobileInputUI.f(MobileInputUI.this)) {
                    com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIM("ie_login");
                }
                AppMethodBeat.o(128338);
            }
        });
        this.klM.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.account.ui.MobileInputUI.AnonymousClass6 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(128339);
                MobileInputUI.this.knH.setEnabled(MobileInputUI.this.bpq());
                AppMethodBeat.o(128339);
            }
        });
        this.knC.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.account.ui.MobileInputUI.AnonymousClass7 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(128340);
                if (i2 == 6 || i2 == 5) {
                    boolean bpq = MobileInputUI.this.bpq();
                    AppMethodBeat.o(128340);
                    return bpq;
                }
                AppMethodBeat.o(128340);
                return false;
            }
        });
        this.knC.setOnKeyListener(new View.OnKeyListener() {
            /* class com.tencent.mm.plugin.account.ui.MobileInputUI.AnonymousClass8 */

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(128341);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                bVar.pH(i2);
                bVar.bm(keyEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$16", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
                if (66 == i2 && keyEvent.getAction() == 0) {
                    boolean bpq = MobileInputUI.this.bpq();
                    com.tencent.mm.hellhoundlib.a.a.a(bpq, this, "com/tencent/mm/plugin/account/ui/MobileInputUI$16", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(128341);
                    return bpq;
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/account/ui/MobileInputUI$16", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(128341);
                return false;
            }
        });
        final boolean[] zArr2 = {false};
        this.knH.setEnabled(false);
        this.knH.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.account.ui.MobileInputUI.AnonymousClass9 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(128342);
                switch (motionEvent.getAction()) {
                    case 0:
                    case 5:
                        zArr2[0] = true;
                        if (MobileInputUI.e(MobileInputUI.this)) {
                            MobileInputUI.this.knT = com.tencent.mm.plugin.normsg.a.c.TN(1);
                            com.tencent.mm.plugin.normsg.a.d.INSTANCE.aA("ce_reg", "<Reg>", MobileInputUI.this.knT);
                        }
                        if (MobileInputUI.f(MobileInputUI.this)) {
                            MobileInputUI.this.knU = com.tencent.mm.plugin.normsg.a.c.TN(2);
                            com.tencent.mm.plugin.normsg.a.d.INSTANCE.aA("ce_login_id", "<Login>", MobileInputUI.this.knU);
                            break;
                        }
                        break;
                    case 1:
                    case 6:
                        if (MobileInputUI.e(MobileInputUI.this)) {
                            com.tencent.mm.plugin.normsg.a.d.INSTANCE.a("ce_reg", motionEvent);
                            com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIQ("ce_reg");
                        }
                        if (MobileInputUI.f(MobileInputUI.this)) {
                            com.tencent.mm.plugin.normsg.a.d.INSTANCE.a("ce_login_id", motionEvent);
                            com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIQ("ce_login_id");
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(128342);
                return false;
            }
        });
        this.knH.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.MobileInputUI.AnonymousClass10 */

            public final void onClick(View view) {
                AppMethodBeat.i(128343);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (zArr2[0]) {
                    zArr2[0] = false;
                } else {
                    if (MobileInputUI.e(MobileInputUI.this)) {
                        MobileInputUI.this.knT = com.tencent.mm.plugin.normsg.a.c.TN(1);
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aA("ce_reg", "<Reg>", MobileInputUI.this.knT);
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.a("ce_reg", MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, 65535));
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIQ("ce_reg");
                    }
                    if (MobileInputUI.f(MobileInputUI.this)) {
                        MobileInputUI.this.knU = com.tencent.mm.plugin.normsg.a.c.TN(2);
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aA("ce_login_id", "<Login>", MobileInputUI.this.knU);
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.a("ce_login_id", MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, 65535));
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIQ("ce_login_id");
                    }
                }
                MobileInputUI.i(MobileInputUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128343);
            }
        });
        if (WeChatSomeFeatureSwitch.onlyUSMobile()) {
            this.countryCode = "1";
            this.jbZ = com.tencent.mm.aw.b.bt(this.countryCode, getString(R.string.bj8));
        }
        if (Util.isNullOrNil(this.countryCode)) {
            this.jbZ = getString(R.string.bj_);
            this.countryCode = PhoneFormater.pureCountryCode(getString(R.string.bj9));
        } else {
            this.jbZ = com.tencent.mm.aw.b.bt(this.countryCode, getString(R.string.bj8));
        }
        if (Util.isNullOrNil(this.jbZ) || Util.isNullOrNil(this.countryCode)) {
            this.klq = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            Log.d("MicroMsg.MobileInputUI", "tm.getSimCountryIso()" + this.klq);
            if (Util.isNullOrNil(this.klq)) {
                Log.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
            } else {
                b.a bs = com.tencent.mm.aw.b.bs(this.klq, getString(R.string.bj8));
                if (bs == null) {
                    Log.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
                } else {
                    this.countryCode = PhoneFormater.pureCountryCode(bs.jbY);
                    this.jbZ = bs.jbZ;
                }
            }
        }
        bps();
        if (Util.isNullOrNil(this.kbb)) {
            this.knC.setText(this.kbb);
        }
        this.kaX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.MobileInputUI.AnonymousClass11 */

            public final void onClick(View view) {
                AppMethodBeat.i(128344);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                view.getContext();
                if (com.tencent.mm.aw.b.Pf(MobileInputUI.this.getString(R.string.bj8)).size() > 1) {
                    Intent intent = new Intent();
                    intent.putExtra("country_name", MobileInputUI.this.jbZ);
                    intent.putExtra("couttry_code", MobileInputUI.this.countryCode);
                    intent.putExtra("iso_code", MobileInputUI.this.klq);
                    com.tencent.mm.plugin.account.a.a.jRt.b(intent, (Activity) MobileInputUI.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128344);
            }
        });
        String str = "";
        if (com.tencent.mm.protocal.d.KyR || BuildInfo.IS_FLAVOR_BLUE) {
            str = getString(R.string.wx) + com.tencent.mm.cc.h.jr(this);
        }
        setMMTitle(str);
        setActionbarColor(getResources().getColor(R.color.a2r));
        hideActionbarLine();
        if (WeChatBrands.Business.Entries.LoginPasswordReset.banned()) {
            this.klS.setVisibility(8);
        }
        AppMethodBeat.o(128362);
    }

    public final boolean bpq() {
        AppMethodBeat.i(128363);
        if (this.knC.getText() != null && !Util.isNullOrNil(this.knC.getText().toString()) && this.knN) {
            if (this.knQ != 2) {
                AppMethodBeat.o(128363);
                return true;
            } else if (this.klM.getText() != null && !Util.isNullOrNil(this.klM.getText().toString())) {
                AppMethodBeat.o(128363);
                return true;
            }
        }
        AppMethodBeat.o(128363);
        return false;
    }

    private void bpr() {
        AppMethodBeat.i(128364);
        hideVKB();
        this.kmF.b(this, new Runnable() {
            /* class com.tencent.mm.plugin.account.ui.MobileInputUI.AnonymousClass14 */

            public final void run() {
                AppMethodBeat.i(169141);
                MobileInputUI.k(MobileInputUI.this);
                AppMethodBeat.o(169141);
            }
        });
        AppMethodBeat.o(128364);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(169142);
        this.kmF.a(this, i2, strArr, iArr);
        AppMethodBeat.o(169142);
    }

    private void goBack() {
        AppMethodBeat.i(128365);
        if (this.knS) {
            hideVKB();
            Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
            bZ.addFlags(67108864);
            bZ.putExtra("can_finish", true);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bZ);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/account/ui/MobileInputUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            finish();
            com.tencent.mm.ui.base.b.kd(this);
            AppMethodBeat.o(128365);
            return;
        }
        this.knR.a(a.GoBack);
        com.tencent.mm.plugin.b.a.bxl(this.kbV);
        hideVKB();
        finish();
        AppMethodBeat.o(128365);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(128366);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(128366);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(128366);
        return onKeyDown;
    }

    private void bps() {
        AppMethodBeat.i(128367);
        if (Util.isNullOrNil(this.jbZ) || Util.isNullOrNil(this.countryCode)) {
            this.kaZ.setText(getString(R.string.f14));
            AppMethodBeat.o(128367);
            return;
        }
        this.kaZ.setText(PhoneFormater.countryNameWithCode(this.jbZ, this.countryCode));
        AppMethodBeat.o(128367);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Bundle bundle = null;
        int i4 = 0;
        AppMethodBeat.i(128368);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 32047) {
            if (intent != null) {
                bundle = intent.getBundleExtra("result_data");
            }
            if (bundle == null || !bundle.getString("go_next", "").equals("agree_privacy")) {
                h.INSTANCE.idkeyStat(712, 1, 1, false);
                if (this.knR instanceof l) {
                    ((l) this.knR).knv = 1;
                }
                AppMethodBeat.o(128368);
                return;
            }
            h.INSTANCE.idkeyStat(712, 2, 1, false);
            if (this.knR instanceof l) {
                ((l) this.knR).knv = 0;
            }
            this.knR.a(a.GoNext);
            AppMethodBeat.o(128368);
        } else if (i2 == 32046) {
            if (intent != null) {
                bundle = intent.getBundleExtra("result_data");
            }
            if (i3 == -1 && bundle != null && bundle.getString("go_next", "").equals("get_reg_verify_code")) {
                if (this.knR instanceof l) {
                    ((l) this.knR).knv = 2;
                }
                this.knR.a(a.GoNext);
            }
            AppMethodBeat.o(128368);
        } else if (i2 == 32045) {
            if (intent != null) {
                bundle = intent.getBundleExtra("result_data");
            }
            if (i3 == -1 && bundle != null && bundle.getString("go_next", "").equals("auth_again") && (this.knR instanceof m)) {
                this.knR.a(a.GoNext);
            }
            AppMethodBeat.o(128368);
        } else {
            switch (i3) {
                case 100:
                    this.jbZ = Util.nullAs(intent.getStringExtra("country_name"), "");
                    this.countryCode = Util.nullAs(intent.getStringExtra("couttry_code"), "");
                    this.klq = Util.nullAs(intent.getStringExtra("iso_code"), "");
                    if (this.knQ != 2 || com.tencent.mm.aw.b.Pj(this.countryCode)) {
                        bps();
                        AppMethodBeat.o(128368);
                        return;
                    }
                    Intent intent2 = new Intent(this, RegByMobileRegAIOUI.class);
                    intent2.putExtra("couttry_code", this.countryCode);
                    intent2.putExtra("country_name", this.jbZ);
                    intent2.putExtra("iso_code", this.klq);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/account/ui/MobileInputUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    finish();
                    AppMethodBeat.o(128368);
                    return;
                case -1:
                    if (i2 == 1024 && intent != null) {
                        String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
                        int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
                        Object[] objArr = new Object[3];
                        objArr[0] = Boolean.valueOf(Util.isNullOrNil(stringExtra));
                        if (!Util.isNullOrNil(stringExtra)) {
                            i4 = stringExtra.length();
                        }
                        objArr[1] = Integer.valueOf(i4);
                        objArr[2] = Integer.valueOf(intExtra);
                        Log.d("MicroMsg.MobileInputUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", objArr);
                        if (intExtra == -217) {
                            bpr();
                            AppMethodBeat.o(128368);
                            return;
                        }
                    }
                    break;
            }
            AppMethodBeat.o(128368);
        }
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public void setRequestedOrientation(int i2) {
    }

    private static void Y(Context context, String str) {
        AppMethodBeat.i(128369);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
        com.tencent.mm.br.c.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.o(128369);
    }

    static /* synthetic */ void c(MobileInputUI mobileInputUI) {
        AppMethodBeat.i(128371);
        View currentFocus = mobileInputUI.getWindow().getCurrentFocus();
        if (currentFocus != null) {
            int[] iArr = new int[2];
            currentFocus.getLocationInWindow(iArr);
            final int height = (iArr[1] - mobileInputUI.getSupportActionBar().getHeight()) - 128;
            if (height > 0) {
                mobileInputUI.kmW.post(new Runnable() {
                    /* class com.tencent.mm.plugin.account.ui.MobileInputUI.AnonymousClass13 */

                    public final void run() {
                        AppMethodBeat.i(128346);
                        MobileInputUI.this.kmW.smoothScrollBy(0, height);
                        AppMethodBeat.o(128346);
                    }
                });
            }
        }
        AppMethodBeat.o(128371);
    }

    static /* synthetic */ void d(MobileInputUI mobileInputUI) {
        AppMethodBeat.i(128373);
        Y(mobileInputUI, mobileInputUI.getString(R.string.j1x) + LocaleUtil.getApplicationLanguage());
        AppMethodBeat.o(128373);
    }

    static /* synthetic */ void k(MobileInputUI mobileInputUI) {
        AppMethodBeat.i(196876);
        mobileInputUI.hideVKB();
        mobileInputUI.knR.a(a.GoNext);
        AppMethodBeat.o(196876);
    }
}
