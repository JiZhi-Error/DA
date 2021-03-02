package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.pay.tool.APPluginConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cc.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMEditText;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class MobileVerifyUI extends MMActivity {
    protected String dSf;
    protected ProgressDialog gtM = null;
    protected Button gxv;
    int jkp;
    String kbV;
    protected EditText kbd;
    protected TextView kbe;
    SecurityImage kdp = null;
    protected boolean kmX = false;
    private com.tencent.mm.platformtools.b kmf;
    private int knQ;
    protected String knu;
    protected MMFormInputView koR;
    protected TextView koS;
    protected TextView koT;
    protected TextView koU;
    protected ScrollView koV;
    private long koW = 0;
    private boolean koX = false;
    private String[] koY;
    private boolean koZ = false;
    String kof;
    int kon;
    protected int kop;
    Boolean kpa;
    private int kpb = 30;
    protected boolean kpc = false;
    protected boolean kpd = false;
    protected int kpe = -1;
    private c kpf;
    String kpg;
    protected String kph;
    private Timer mTimer;
    String nickName;

    public interface c {
        void a(MobileVerifyUI mobileVerifyUI);

        boolean a(a aVar);

        void start();

        void stop();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ long b(MobileVerifyUI mobileVerifyUI) {
        long j2 = mobileVerifyUI.koW;
        mobileVerifyUI.koW = j2 - 1;
        return j2;
    }

    static /* synthetic */ void e(MobileVerifyUI mobileVerifyUI) {
        AppMethodBeat.i(128469);
        mobileVerifyUI.bpv();
        AppMethodBeat.o(128469);
    }

    static /* synthetic */ void g(MobileVerifyUI mobileVerifyUI) {
        AppMethodBeat.i(128470);
        mobileVerifyUI.bpw();
        AppMethodBeat.o(128470);
    }

    static /* synthetic */ void i(MobileVerifyUI mobileVerifyUI) {
        AppMethodBeat.i(128471);
        mobileVerifyUI.goBack();
        AppMethodBeat.o(128471);
    }

    /* access modifiers changed from: protected */
    public enum a {
        GoBack,
        GoNext,
        DoSend,
        DoProcessSMS;

        public static a valueOf(String str) {
            AppMethodBeat.i(128452);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(128452);
            return aVar;
        }

        static {
            AppMethodBeat.i(128453);
            AppMethodBeat.o(128453);
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128454);
        super.onCreate(bundle);
        this.kon = getIntent().getIntExtra("key_reg_style", 1);
        this.knQ = getIntent().getIntExtra("mobile_verify_purpose", 0);
        this.kpg = getIntent().getStringExtra("MicroMsg.MobileVerifyUIIntent_sms_code");
        this.kof = getIntent().getStringExtra("kintent_password");
        this.nickName = getIntent().getStringExtra("kintent_nickname");
        this.kpa = Boolean.valueOf(getIntent().getBooleanExtra("kintent_hasavatar", false));
        this.kmX = getIntent().getBooleanExtra("from_deep_link", false);
        this.knu = getIntent().getStringExtra("regsession_id");
        this.kph = getIntent().getStringExtra("reg_3d_app_ticket");
        this.kop = getIntent().getIntExtra("reg_3d_app_type", 0);
        switch (this.knQ) {
            case 2:
                this.kpf = new p();
                if (this.kof != null && this.kof.length() >= 8) {
                    this.jkp = 1;
                    break;
                } else {
                    this.jkp = 4;
                    break;
                }
            case 3:
            case 5:
                this.kpf = new n(this.knQ);
                break;
            case 4:
                this.kpf = new o();
                break;
            default:
                Log.e("MicroMsg.MobileVerifyUI", "wrong purpose %s", Integer.valueOf(this.knQ));
                finish();
                AppMethodBeat.o(128454);
                return;
        }
        String string = getString(R.string.ael);
        if (d.KyR || BuildInfo.IS_FLAVOR_BLUE) {
            string = getString(R.string.wx) + h.jr(this);
        }
        setMMTitle(string);
        this.kpb = getIntent().getIntExtra("mobileverify_countdownsec", 30);
        this.kpc = getIntent().getBooleanExtra("mobileverify_fb", false);
        this.kpd = getIntent().getBooleanExtra("mobileverify_reg_qq", false);
        this.dSf = getIntent().getExtras().getString("bindmcontact_mobile");
        this.kbV = com.tencent.mm.plugin.b.a.caK();
        initView();
        this.kpf.a(this);
        if (this.kpg != null) {
            this.kbd.setText(this.kpg);
            bpv();
        } else if (this.knQ == 5) {
            this.kpf.a(a.DoSend);
        }
        this.kmf = new com.tencent.mm.platformtools.b();
        AppMethodBeat.o(128454);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(128455);
        if (this.kmf != null) {
            this.kmf.close();
        }
        super.onDestroy();
        AppMethodBeat.o(128455);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(128456);
        super.onResume();
        this.kpf.start();
        AppMethodBeat.o(128456);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(128457);
        super.onPause();
        this.kpf.stop();
        AppMethodBeat.o(128457);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bbb;
    }

    /* access modifiers changed from: package-private */
    public static class b extends TimerTask {
        WeakReference<MobileVerifyUI> kps;

        b(MobileVerifyUI mobileVerifyUI) {
            AppMethodBeat.i(196887);
            this.kps = new WeakReference<>(mobileVerifyUI);
            AppMethodBeat.o(196887);
        }

        public final void run() {
            AppMethodBeat.i(196888);
            final MobileVerifyUI mobileVerifyUI = this.kps.get();
            if (mobileVerifyUI == null) {
                AppMethodBeat.o(196888);
                return;
            }
            mobileVerifyUI.koT.post(new Runnable() {
                /* class com.tencent.mm.plugin.account.ui.MobileVerifyUI.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(196886);
                    MobileVerifyUI.b(mobileVerifyUI);
                    if (mobileVerifyUI.koW >= 0) {
                        mobileVerifyUI.koT.setText(mobileVerifyUI.getResources().getQuantityString(R.plurals.v, (int) mobileVerifyUI.koW, Integer.valueOf((int) mobileVerifyUI.koW)));
                        AppMethodBeat.o(196886);
                        return;
                    }
                    mobileVerifyUI.koT.setVisibility(8);
                    mobileVerifyUI.koS.setVisibility(0);
                    MobileVerifyUI.d(mobileVerifyUI);
                    mobileVerifyUI.koS.setEnabled(true);
                    mobileVerifyUI.koS.setText(mobileVerifyUI.getString(R.string.f2l));
                    AppMethodBeat.o(196886);
                }
            });
            AppMethodBeat.o(196888);
        }
    }

    private void bpu() {
        AppMethodBeat.i(128458);
        if (!this.koX) {
            this.mTimer = new Timer();
            this.koX = true;
            this.koW = (long) this.kpb;
            this.mTimer.schedule(new b(this), 1000, 1000);
        }
        AppMethodBeat.o(128458);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void onKeyboardStateChanged() {
        AppMethodBeat.i(128459);
        if (keyboardState() == 1) {
            this.koV.scrollTo(0, this.koV.getChildAt(0).getMeasuredHeight() - this.koV.getMeasuredHeight());
            AppMethodBeat.o(128459);
            return;
        }
        this.koV.scrollTo(0, 0);
        AppMethodBeat.o(128459);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(128460);
        Log.d("MicroMsg.MobileVerifyUI", "init getintent mobile:" + this.dSf);
        this.koR = (MMFormInputView) findViewById(R.id.a4e);
        this.koR.setImeOption(5);
        this.koR.setInputType(3);
        this.kbd = this.koR.getContentEditText();
        this.koS = (TextView) findViewById(R.id.fij);
        this.koT = (TextView) findViewById(R.id.fii);
        this.kbe = (TextView) findViewById(R.id.a4c);
        this.kbe.setText(this.dSf);
        this.dSf = PhoneFormater.pureNumber(this.dSf);
        this.koS.setText(getString(R.string.f2m));
        this.koU = (TextView) findViewById(R.id.a4f);
        this.gxv = (Button) findViewById(R.id.fz0);
        this.koV = (ScrollView) findViewById(R.id.hci);
        this.koY = getResources().getStringArray(R.array.aq);
        this.koU.setText(Html.fromHtml(getString(R.string.fz5)));
        InputFilter[] inputFilterArr = {new InputFilter() {
            /* class com.tencent.mm.plugin.account.ui.MobileVerifyUI.AnonymousClass1 */

            public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
                AppMethodBeat.i(196877);
                CharSequence filterNumber = Util.filterNumber(charSequence);
                AppMethodBeat.o(196877);
                return filterNumber;
            }
        }};
        this.koT.setVisibility(0);
        this.koT.setText(getResources().getQuantityString(R.plurals.v, this.kpb, Integer.valueOf(this.kpb)));
        bpu();
        this.koZ = false;
        this.kbd.setFilters(inputFilterArr);
        this.kbd.addTextChangedListener(new MMEditText.c(this.kbd, null, 12));
        this.gxv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.MobileVerifyUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(196878);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                MobileVerifyUI.e(MobileVerifyUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(196878);
            }
        });
        this.gxv.setEnabled(false);
        this.kbd.setTextSize(15.0f);
        this.kbd.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.account.ui.MobileVerifyUI.AnonymousClass5 */

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(196879);
                if (Util.isNullOrNil(MobileVerifyUI.this.kbd.getText().toString())) {
                    MobileVerifyUI.this.kbd.setTextSize(15.0f);
                    MobileVerifyUI.this.kbd.setGravity(16);
                } else {
                    MobileVerifyUI.this.kbd.setTextSize(24.0f);
                    MobileVerifyUI.this.kbd.setGravity(16);
                }
                if (MobileVerifyUI.this.kbd.getText() == null || MobileVerifyUI.this.kbd.getText().toString().length() <= 0) {
                    MobileVerifyUI.this.gxv.setEnabled(false);
                    AppMethodBeat.o(196879);
                    return;
                }
                MobileVerifyUI.this.gxv.setEnabled(true);
                AppMethodBeat.o(196879);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.koS.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.MobileVerifyUI.AnonymousClass6 */
            private final int kpj = 0;
            private final int kpk = 1;
            private final int kpl = 2;

            public final void onClick(View view) {
                AppMethodBeat.i(196882);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                l lVar = new l(MobileVerifyUI.this);
                lVar.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.account.ui.MobileVerifyUI.AnonymousClass6.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(196880);
                        mVar.d(0, MobileVerifyUI.this.getString(R.string.f2m));
                        if (com.tencent.mm.aw.b.Pg(MobileVerifyUI.this.dSf)) {
                            mVar.d(1, MobileVerifyUI.this.getString(R.string.afc));
                        }
                        if (MobileVerifyUI.this.knQ == 2 && MobileVerifyUI.this.kpd) {
                            mVar.d(2, MobileVerifyUI.this.getString(R.string.fz9));
                        }
                        AppMethodBeat.o(196880);
                    }
                };
                lVar.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.account.ui.MobileVerifyUI.AnonymousClass6.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(196881);
                        switch (menuItem.getItemId()) {
                            case 0:
                                MobileVerifyUI.g(MobileVerifyUI.this);
                                AppMethodBeat.o(196881);
                                return;
                            case 1:
                                MobileVerifyUI.this.hideVKB();
                                if (MobileVerifyUI.this.knQ == 2) {
                                    com.tencent.mm.plugin.b.a.bxl("R200_500");
                                } else if (MobileVerifyUI.this.knQ == 3) {
                                    com.tencent.mm.plugin.b.a.bxl("F200_300");
                                }
                                Intent intent = new Intent(MobileVerifyUI.this, RegByMobileVoiceVerifyUI.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("bindmcontact_mobile", MobileVerifyUI.this.dSf);
                                bundle.putInt("voice_verify_type", MobileVerifyUI.h(MobileVerifyUI.this));
                                intent.putExtras(bundle);
                                MobileVerifyUI mobileVerifyUI = MobileVerifyUI.this;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(mobileVerifyUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/MobileVerifyUI$4$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                mobileVerifyUI.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(mobileVerifyUI, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$4$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                break;
                        }
                        AppMethodBeat.o(196881);
                    }
                };
                lVar.gXI();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(196882);
            }
        });
        this.koS.setEnabled(false);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.MobileVerifyUI.AnonymousClass7 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(196883);
                MobileVerifyUI.i(MobileVerifyUI.this);
                AppMethodBeat.o(196883);
                return true;
            }
        });
        this.kbd.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.account.ui.MobileVerifyUI.AnonymousClass8 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(196884);
                if (i2 == 6 || i2 == 5) {
                    MobileVerifyUI.e(MobileVerifyUI.this);
                    AppMethodBeat.o(196884);
                    return true;
                }
                AppMethodBeat.o(196884);
                return false;
            }
        });
        this.kbd.setOnKeyListener(new View.OnKeyListener() {
            /* class com.tencent.mm.plugin.account.ui.MobileVerifyUI.AnonymousClass9 */

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(196885);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                bVar.pH(i2);
                bVar.bm(keyEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileVerifyUI$7", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
                if (66 == i2 && keyEvent.getAction() == 0) {
                    MobileVerifyUI.e(MobileVerifyUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$7", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(196885);
                    return true;
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$7", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(196885);
                return false;
            }
        });
        AppMethodBeat.o(128460);
    }

    private void bpv() {
        AppMethodBeat.i(128461);
        hideVKB();
        if (this.kbd.getText().toString().trim().equals("")) {
            com.tencent.mm.ui.base.h.n(this, R.string.af_, R.string.zb);
            AppMethodBeat.o(128461);
            return;
        }
        this.kpf.a(a.GoNext);
        AppMethodBeat.o(128461);
    }

    private void bpw() {
        AppMethodBeat.i(128462);
        this.koZ = false;
        this.koS.setEnabled(false);
        this.koT.setVisibility(0);
        this.koT.setText(getResources().getQuantityString(R.plurals.v, this.kpb, Integer.valueOf(this.kpb)));
        this.koS.setVisibility(8);
        bpu();
        this.kpf.a(a.DoSend);
        com.tencent.mm.ui.base.h.cD(this, getString(R.string.f17));
        AppMethodBeat.o(128462);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(128463);
        if (i2 == 4) {
            goBack();
            AppMethodBeat.o(128463);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(128463);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(128464);
        com.tencent.mm.plugin.b.a.bxl(this.kbV);
        if (!this.kpf.a(a.GoBack)) {
            finish();
            AppMethodBeat.o(128464);
            return;
        }
        AppMethodBeat.o(128464);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(128465);
        super.onNewIntent(intent);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("nofification_type");
            Log.d("MicroMsg.MobileVerifyUI", "[oneliang][notificationType]%s", stringExtra);
            if (stringExtra != null && stringExtra.equals("no_reg_notification")) {
                bpw();
            }
        }
        AppMethodBeat.o(128465);
    }

    /* access modifiers changed from: protected */
    public final boolean n(int i2, int i3, String str) {
        String ayX;
        boolean z;
        AppMethodBeat.i(128466);
        com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
        if (Dk != null) {
            Dk.a(this, null, null);
            AppMethodBeat.o(128466);
            return true;
        }
        if (i2 == 4) {
            switch (i3) {
                case -75:
                    y.dz(this);
                    AppMethodBeat.o(128466);
                    return true;
                case -1:
                    if (g.azz().aYS() == 5) {
                        com.tencent.mm.ui.base.h.n(this, R.string.fbf, R.string.fbe);
                        AppMethodBeat.o(128466);
                        return true;
                    }
                    y.dz(this);
                    AppMethodBeat.o(128466);
                    return true;
            }
        }
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
                    /* class com.tencent.mm.plugin.account.ui.MobileVerifyUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                }, new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.account.ui.MobileVerifyUI.AnonymousClass3 */

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                z = true;
                break;
            case APPluginConstants.ERROR_IO_SSLException_SSLPeerUnverifiedException:
                Toast.makeText(this, (int) R.string.adr, 0).show();
                z = true;
                break;
            case APPluginConstants.ERROR_IO_SSLException_SSLHandshakeException:
                Toast.makeText(this, (int) R.string.adt, 0).show();
                z = true;
                break;
            case APPluginConstants.ERROR_IO_ObjectStreamException_NotSerializableException:
                Toast.makeText(this, (int) R.string.adw, 0).show();
                z = true;
                break;
            case APPluginConstants.ERROR_IO_ObjectStreamException_InvalidObjectException:
                Toast.makeText(this, (int) R.string.adu, 0).show();
                z = true;
                break;
            case APPluginConstants.ERROR_IO_ObjectStreamException_InvalidClassException:
                com.tencent.mm.ui.base.h.a(this, (int) R.string.af3, (int) R.string.af9, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.ui.MobileVerifyUI.AnonymousClass11 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                z = true;
                break;
            case APPluginConstants.ERROR_IO_NoHttpResponseException:
                com.tencent.mm.ui.base.h.d(this, getString(R.string.af5), "", new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.ui.MobileVerifyUI.AnonymousClass10 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            AppMethodBeat.o(128466);
            return true;
        }
        if (this.kmf.a(this, new ae(i2, i3, str))) {
            AppMethodBeat.o(128466);
            return true;
        }
        AppMethodBeat.o(128466);
        return false;
    }

    /* access modifiers changed from: protected */
    public final void gq(boolean z) {
        AppMethodBeat.i(128467);
        Intent intent = new Intent(this, RegByMobileSetPwdUI.class);
        intent.putExtra("kintent_hint", getString(R.string.gr1));
        intent.putExtra("kintent_cancelable", z);
        startActivityForResult(intent, 0);
        AppMethodBeat.o(128467);
    }

    static /* synthetic */ void d(MobileVerifyUI mobileVerifyUI) {
        AppMethodBeat.i(128468);
        mobileVerifyUI.koX = false;
        if (mobileVerifyUI.mTimer != null) {
            mobileVerifyUI.mTimer.cancel();
        }
        AppMethodBeat.o(128468);
    }

    static /* synthetic */ int h(MobileVerifyUI mobileVerifyUI) {
        switch (mobileVerifyUI.knQ) {
            case 2:
                return 0;
            case 3:
                return 2;
            case 4:
                return 1;
            default:
                return 3;
        }
    }
}
