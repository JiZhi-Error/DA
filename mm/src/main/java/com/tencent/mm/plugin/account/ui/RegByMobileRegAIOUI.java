package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.aw.b;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.g.b.a.ka;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.model.j;
import com.tencent.mm.plugin.account.ui.ResizeLayout;
import com.tencent.mm.plugin.appbrand.jsapi.cp;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.protocal.protobuf.ehh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.a.d;

public class RegByMobileRegAIOUI extends MMActivity implements i {
    private String countryCode = null;
    private String dYB = "";
    private ImageView gvv;
    private String jbZ = null;
    private LinearLayout kaX;
    private TextView kaZ;
    private String kbV;
    private String kbb = null;
    private q kdn;
    private IListener kkK = new IListener<lz>() {
        /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass1 */

        {
            AppMethodBeat.i(161706);
            this.__eventId = lz.class.getName().hashCode();
            AppMethodBeat.o(161706);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lz lzVar) {
            AppMethodBeat.i(128506);
            lz lzVar2 = lzVar;
            if (lzVar2 == null || lzVar2.dRz == null) {
                AppMethodBeat.o(128506);
                return false;
            }
            Log.i("MicroMsg.RegByMobileRegAIOUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", lzVar2.dRz.content, lzVar2.dRz.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", lzVar2.dRz.content);
            intent.putExtra("key_disaster_url", lzVar2.dRz.url);
            intent.setClass(MMApplicationContext.getContext(), DisasterUI.class).addFlags(268435456);
            Context context = MMApplicationContext.getContext();
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$1", "callback", "(Lcom/tencent/mm/autogen/events/LoginDisasterEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$1", "callback", "(Lcom/tencent/mm/autogen/events/LoginDisasterEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(128506);
            return true;
        }
    };
    private ka kkY = new ka();
    private String klq = null;
    private x kmF = new x();
    private final int kmZ = 128;
    private ResizeLayout kmb;
    private TextView knG;
    private Button knH;
    private boolean knN = true;
    private String knP = null;
    private String knm;
    private String knn;
    private int kno = 0;
    private String knu;
    private int kop;
    private String kpG;
    private boolean kpI = false;
    private EditText kpT;
    private TextView kpU;
    private MMFormInputView kpV;
    private String kpW = null;
    private View kpX;
    private CheckBox kpY;
    private MMFormInputView kpZ;
    private ImageView kqa;
    private MMFormInputView kqb;
    private Bitmap kqc;
    private ScrollView kqd;
    private String kqe;
    private String kqf;
    private String kqg;
    private String kqh;
    private boolean kqi = true;
    private d kqj = null;
    private boolean kqk = false;
    private int kql;
    private int kqm;
    private boolean kqn;
    private boolean kqo;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RegByMobileRegAIOUI() {
        AppMethodBeat.i(128538);
        AppMethodBeat.o(128538);
    }

    static /* synthetic */ boolean b(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        AppMethodBeat.i(128556);
        boolean bpq = regByMobileRegAIOUI.bpq();
        AppMethodBeat.o(128556);
        return bpq;
    }

    static /* synthetic */ void e(RegByMobileRegAIOUI regByMobileRegAIOUI, String str) {
        AppMethodBeat.i(196931);
        regByMobileRegAIOUI.Tv(str);
        AppMethodBeat.o(196931);
    }

    static /* synthetic */ void m(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        AppMethodBeat.i(196930);
        regByMobileRegAIOUI.bpC();
        AppMethodBeat.o(196930);
    }

    static /* synthetic */ void p(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        AppMethodBeat.i(196932);
        regByMobileRegAIOUI.bnm();
        AppMethodBeat.o(196932);
    }

    static /* synthetic */ void x(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        AppMethodBeat.i(196934);
        regByMobileRegAIOUI.bpD();
        AppMethodBeat.o(196934);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bmc;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128539);
        super.onCreate(bundle);
        super.setRequestedOrientation(1);
        this.jbZ = Util.nullAs(getIntent().getStringExtra("country_name"), "");
        this.countryCode = PhoneFormater.pureCountryCode(Util.nullAs(getIntent().getStringExtra("couttry_code"), ""));
        this.klq = Util.nullAsNil(getIntent().getStringExtra("iso_code"));
        this.kbb = Util.nullAs(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.kqe = getIntent().getStringExtra("register_title");
        this.kpG = getIntent().getStringExtra("register_nick_name");
        this.kqh = getIntent().getStringExtra("register_avatar");
        this.kqf = getIntent().getStringExtra("third_app_token");
        this.kop = getIntent().getIntExtra("reg_3d_app_type", 0);
        initView();
        AppMethodBeat.o(128539);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(128540);
        EventCenter.instance.addListener(this.kkK);
        super.onResume();
        g.azz().a(701, this);
        g.azz().a(252, this);
        g.azz().a(145, this);
        g.azz().a(132, this);
        g.azz().a(cp.CTRL_INDEX, this);
        g.azz().a(252, this);
        g.azz().a(701, this);
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",RE200_100,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(true, append.append(com.tencent.mm.kernel.a.FN("RE200_100")).append(",1").toString());
        this.kno = 0;
        AppMethodBeat.o(128540);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(128541);
        super.onPause();
        if (this.kdn != null) {
            this.kdn.dismiss();
        }
        EventCenter.instance.removeListener(this.kkK);
        g.azz().b(701, this);
        g.azz().b(252, this);
        g.azz().b(145, this);
        g.azz().b(132, this);
        g.azz().b(cp.CTRL_INDEX, this);
        g.azz().b(252, this);
        g.azz().b(701, this);
        com.tencent.mm.plugin.b.a.bxk("RE200_100");
        AppMethodBeat.o(128541);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(128542);
        this.kaX = (LinearLayout) findViewById(R.id.bgn);
        this.kaZ = (TextView) findViewById(R.id.bgp);
        this.kpU = (TextView) findViewById(R.id.gz7);
        this.kpV = (MMFormInputView) findViewById(R.id.gze);
        this.kpV.setInputType(3);
        this.kpT = this.kpV.getContentEditText();
        this.kpX = findViewById(R.id.ijf);
        this.kpY = (CheckBox) findViewById(R.id.gz6);
        this.knG = (TextView) findViewById(R.id.gz5);
        this.knH = (Button) findViewById(R.id.gz0);
        this.gvv = (ImageView) findViewById(R.id.hlf);
        this.kqa = (ImageView) findViewById(R.id.hlh);
        this.kpZ = (MMFormInputView) findViewById(R.id.gzb);
        c.f(this.kpZ.getContentEditText()).aoq(16).a((c.a) null);
        this.kqd = (ScrollView) findViewById(R.id.hcl);
        this.kmb = (ResizeLayout) findViewById(R.id.h5e);
        this.kqb = (MMFormInputView) findViewById(R.id.gz2);
        this.kmb.setOnSizeChanged(new ResizeLayout.a() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass12 */

            @Override // com.tencent.mm.plugin.account.ui.ResizeLayout.a
            public final void bpj() {
                AppMethodBeat.i(128525);
                RegByMobileRegAIOUI.a(RegByMobileRegAIOUI.this);
                AppMethodBeat.o(128525);
            }
        });
        this.kpY.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass19 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(128529);
                RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this);
                AppMethodBeat.o(128529);
            }
        });
        this.knG.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass20 */

            public final void onClick(View view) {
                AppMethodBeat.i(128530);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String bu = com.tencent.mm.aw.b.bu(RegByMobileRegAIOUI.this.countryCode, RegByMobileRegAIOUI.this.getString(R.string.bj8));
                com.tencent.mm.plugin.account.a.b.a.b(RegByMobileRegAIOUI.this, RegByMobileRegAIOUI.this.getString(R.string.htp, new Object[]{LocaleUtil.getApplicationLanguage(), bu}), 0, false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128530);
            }
        });
        final boolean[] zArr = {true};
        this.kpT.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass21 */
            private PhoneFormater kqv = new PhoneFormater();

            {
                AppMethodBeat.i(128531);
                AppMethodBeat.o(128531);
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(128532);
                RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this);
                AppMethodBeat.o(128532);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(128533);
                if (zArr[0]) {
                    zArr[0] = false;
                    com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIL("ie_reg");
                }
                com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIM("ie_reg");
                AppMethodBeat.o(128533);
            }
        });
        this.kpT.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass22 */

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(128534);
                if (z) {
                    zArr[0] = true;
                    AppMethodBeat.o(128534);
                    return;
                }
                com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIN("ie_reg");
                AppMethodBeat.o(128534);
            }
        });
        this.kpZ.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass23 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(128535);
                RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this);
                AppMethodBeat.o(128535);
            }
        });
        this.kqb.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass24 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(128536);
                RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this);
                AppMethodBeat.o(128536);
            }
        });
        final boolean[] zArr2 = {false};
        this.knH.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass25 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(128537);
                switch (motionEvent.getAction()) {
                    case 0:
                    case 5:
                        zArr2[0] = true;
                        RegByMobileRegAIOUI.this.dYB = com.tencent.mm.plugin.normsg.a.c.TN(1);
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aA("ce_reg", "<Reg>", RegByMobileRegAIOUI.this.dYB);
                        break;
                    case 1:
                    case 6:
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.a("ce_reg", motionEvent);
                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIQ("ce_reg");
                        break;
                }
                AppMethodBeat.o(128537);
                return false;
            }
        });
        this.knH.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(128510);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (zArr2[0]) {
                    zArr2[0] = false;
                } else {
                    RegByMobileRegAIOUI.this.dYB = com.tencent.mm.plugin.normsg.a.c.TN(1);
                    com.tencent.mm.plugin.normsg.a.d.INSTANCE.aA("ce_reg", "<Reg>", RegByMobileRegAIOUI.this.dYB);
                    com.tencent.mm.plugin.normsg.a.d.INSTANCE.a("ce_reg", MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, 65535));
                    com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIQ("ce_reg");
                }
                if (!RegByMobileRegAIOUI.this.kpY.isChecked()) {
                    RegByMobileRegAIOUI.this.kpX.startAnimation(AnimationUtils.loadAnimation(RegByMobileRegAIOUI.this, R.anim.a1));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(128510);
                    return;
                }
                c.f(RegByMobileRegAIOUI.this.kqb.getContentEditText()).lv(1, 32).CN(true).a(new c.a() {
                    /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.tools.b.c.a
                    public final void Tw(String str) {
                        AppMethodBeat.i(128507);
                        RegByMobileRegAIOUI.this.knP = PhoneFormater.pureNumber(RegByMobileRegAIOUI.this.kpT.getText().toString());
                        RegByMobileRegAIOUI.this.kpW = PhoneFormater.countryCodeWithPlus(RegByMobileRegAIOUI.this.countryCode);
                        String str2 = RegByMobileRegAIOUI.this.kpW + RegByMobileRegAIOUI.this.knP;
                        RegByMobileRegAIOUI.this.hideVKB();
                        if (RegByMobileRegAIOUI.this.kqi) {
                            if (Util.isNullOrNil(RegByMobileRegAIOUI.this.klq)) {
                                RegByMobileRegAIOUI.this.klq = com.tencent.mm.aw.b.bu(RegByMobileRegAIOUI.this.countryCode, RegByMobileRegAIOUI.this.getString(R.string.bj8));
                            }
                            com.tencent.mm.plugin.account.a.b.a.b(RegByMobileRegAIOUI.this, RegByMobileRegAIOUI.this.getString(R.string.ee8, new Object[]{LocaleUtil.getApplicationLanguage(), RegByMobileRegAIOUI.this.klq, "reg", 1, 0}), 30847, false);
                            AppMethodBeat.o(128507);
                        } else if (!Util.isNullOrNil(RegByMobileRegAIOUI.this.kqf)) {
                            RegByMobileRegAIOUI.m(RegByMobileRegAIOUI.this);
                            AppMethodBeat.o(128507);
                        } else {
                            RegByMobileRegAIOUI.e(RegByMobileRegAIOUI.this, str2);
                            AppMethodBeat.o(128507);
                        }
                    }

                    @Override // com.tencent.mm.ui.tools.b.c.a
                    public final void Tx(String str) {
                        AppMethodBeat.i(196921);
                        h.n(RegByMobileRegAIOUI.this, R.string.gqv, R.string.gqy);
                        AppMethodBeat.o(196921);
                    }

                    @Override // com.tencent.mm.ui.tools.b.c.a
                    public final void dv(String str) {
                        AppMethodBeat.i(169145);
                        h.n(RegByMobileRegAIOUI.this, R.string.gqw, R.string.gqy);
                        AppMethodBeat.o(169145);
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128510);
            }
        });
        this.knH.setEnabled(false);
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
        if (!Util.isNullOrNil(this.kqe)) {
            this.kpU.setText(this.kqe);
        }
        if (Util.isNullOrNil(this.jbZ) || Util.isNullOrNil(this.countryCode)) {
            this.klq = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            Log.i("MicroMsg.RegByMobileRegAIOUI", "tm.getSimCountryIso()" + this.klq);
            if (Util.isNullOrNil(this.klq)) {
                Log.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
            } else {
                b.a bs = com.tencent.mm.aw.b.bs(this.klq, getString(R.string.bj8));
                if (bs == null) {
                    Log.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
                } else {
                    this.jbZ = bs.jbZ;
                    this.countryCode = bs.jbY;
                }
            }
        }
        bps();
        if (this.kbb != null && !this.kbb.equals("")) {
            this.kpT.setText(this.kbb);
        }
        this.kaX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(169146);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("country_name", RegByMobileRegAIOUI.this.jbZ);
                intent.putExtra("couttry_code", RegByMobileRegAIOUI.this.countryCode);
                com.tencent.mm.plugin.account.a.a.jRt.b(intent, (Activity) RegByMobileRegAIOUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(169146);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(169147);
                RegByMobileRegAIOUI.this.hideVKB();
                RegByMobileRegAIOUI.p(RegByMobileRegAIOUI.this);
                RegByMobileRegAIOUI.this.finish();
                AppMethodBeat.o(169147);
                return true;
            }
        }, R.raw.actionbar_icon_close_black);
        this.gvv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(169148);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (com.tencent.mm.pluginsdk.permission.b.a(RegByMobileRegAIOUI.this, "android.permission.WRITE_EXTERNAL_STORAGE", 34, "", "")) {
                    com.tencent.mm.plugin.account.a.a.jRu.s(RegByMobileRegAIOUI.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(169148);
            }
        });
        if (Util.isNullOrNil(this.kqf)) {
            g.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread() {
                /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass6 */
                String nickname;

                @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
                public final boolean onPostExecute() {
                    AppMethodBeat.i(169149);
                    if (!Util.isNullOrNil(this.nickname) && Util.isNullOrNil(new StringBuilder().append((Object) RegByMobileRegAIOUI.this.kqb.getText()).toString().trim())) {
                        RegByMobileRegAIOUI.this.kqb.setText(this.nickname);
                    }
                    if (!e.apn()) {
                        Log.e("MicroMsg.RegByMobileRegAIOUI", "SDcard is not available");
                        AppMethodBeat.o(169149);
                        return false;
                    }
                    if (RegByMobileRegAIOUI.this.kqc != null && !RegByMobileRegAIOUI.this.kqc.isRecycled() && !RegByMobileRegAIOUI.this.kpI) {
                        RegByMobileRegAIOUI.this.gvv.setImageBitmap(RegByMobileRegAIOUI.this.kqc);
                        RegByMobileRegAIOUI.this.kqa.setVisibility(8);
                        RegByMobileRegAIOUI.this.kpI = true;
                    }
                    AppMethodBeat.o(169149);
                    return true;
                }

                @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
                public final boolean doInBackground() {
                    AppMethodBeat.i(169150);
                    AppMethodBeat.o(169150);
                    return true;
                }

                public final String toString() {
                    AppMethodBeat.i(169151);
                    String str = super.toString() + "|initView2";
                    AppMethodBeat.o(169151);
                    return str;
                }
            });
        } else {
            this.kqb.setText(this.kpG);
            g.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread() {
                /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass7 */

                /* JADX WARNING: Removed duplicated region for block: B:21:0x0074 A[SYNTHETIC, Splitter:B:21:0x0074] */
                /* JADX WARNING: Removed duplicated region for block: B:31:0x008e  */
                /* JADX WARNING: Removed duplicated region for block: B:35:0x0096  */
                @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final boolean doInBackground() {
                    /*
                    // Method dump skipped, instructions count: 170
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass7.doInBackground():boolean");
                }

                @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
                public final boolean onPostExecute() {
                    AppMethodBeat.i(128517);
                    if (!RegByMobileRegAIOUI.this.kpI && RegByMobileRegAIOUI.this.kqc != null && !RegByMobileRegAIOUI.this.kqc.isRecycled()) {
                        RegByMobileRegAIOUI.this.gvv.setImageBitmap(RegByMobileRegAIOUI.this.kqc);
                        RegByMobileRegAIOUI.this.kqa.setVisibility(8);
                        RegByMobileRegAIOUI.this.kpI = true;
                    }
                    AppMethodBeat.o(128517);
                    return true;
                }
            });
        }
        String str = "";
        if (com.tencent.mm.protocal.d.KyR || BuildInfo.IS_FLAVOR_BLUE) {
            str = getString(R.string.wx) + com.tencent.mm.cc.h.jr(this);
        }
        setMMTitle(str);
        setActionbarColor(getResources().getColor(R.color.afz));
        hideActionbarLine();
        if (com.tencent.mm.compatible.util.d.oD(23)) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.afz));
            updataStatusBarIcon(ao.isDarkMode());
        }
        AppMethodBeat.o(128542);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(128543);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            bnm();
            AppMethodBeat.o(128543);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(128543);
        return onKeyDown;
    }

    private void bnm() {
        AppMethodBeat.i(128544);
        com.tencent.mm.plugin.b.a.bxl(this.kbV);
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",RE200_100,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(false, append.append(com.tencent.mm.kernel.a.FN("RE200_100")).append(",2").toString());
        finish();
        overridePendingTransition(R.anim.s, R.anim.s);
        AppMethodBeat.o(128544);
    }

    private void bpC() {
        AppMethodBeat.i(128545);
        if (!Util.isNullOrNil(this.kqf)) {
            if (this.kdn != null) {
                this.kdn.dismiss();
            }
            getString(R.string.zb);
            this.kdn = h.a((Context) this, getString(R.string.a06), true, (DialogInterface.OnCancelListener) null);
            g.azz().a(new j(this.kqf), 0);
        }
        AppMethodBeat.o(128545);
    }

    private void Tv(final String str) {
        AppMethodBeat.i(128546);
        if (!com.tencent.mm.plugin.account.a.b.a.V(this, this.kpZ.getText().toString())) {
            AppMethodBeat.o(128546);
            return;
        }
        if (this.kdn != null) {
            this.kdn.dismiss();
        }
        this.kmF.b(this, new Runnable() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(169152);
                RegByMobileRegAIOUI.f(RegByMobileRegAIOUI.this, str);
                AppMethodBeat.o(169152);
            }
        });
        AppMethodBeat.o(128546);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(169153);
        if (i2 != 34) {
            this.kmF.a(this, i2, strArr, iArr);
        } else if (iArr != null && iArr.length > 0 && iArr[0] == 0) {
            com.tencent.mm.plugin.account.a.a.jRu.s(this);
            AppMethodBeat.o(169153);
            return;
        }
        AppMethodBeat.o(169153);
    }

    private void bps() {
        AppMethodBeat.i(128547);
        if (Util.isNullOrNil(this.jbZ) || Util.isNullOrNil(this.countryCode)) {
            this.kaZ.setText(getString(R.string.f14));
            AppMethodBeat.o(128547);
            return;
        }
        this.kaZ.setText(PhoneFormater.countryNameWithCode(this.jbZ, this.countryCode));
        AppMethodBeat.o(128547);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(128548);
        super.onActivityResult(i2, i3, intent);
        if (i2 != 30846) {
            if (i2 != 30847) {
                switch (i3) {
                    case 100:
                        this.jbZ = Util.nullAs(intent.getStringExtra("country_name"), "");
                        this.countryCode = Util.nullAs(intent.getStringExtra("couttry_code"), "");
                        this.klq = Util.nullAs(intent.getStringExtra("iso_code"), "");
                        if (!com.tencent.mm.aw.b.Pj(this.countryCode)) {
                            bps();
                            AppMethodBeat.o(128548);
                            return;
                        } else if (Util.isNullOrNil(this.kqf) || Util.isNullOrNil(this.kpG) || Util.isNullOrNil(this.kqh)) {
                            Intent intent2 = new Intent(this, MobileInputUI.class);
                            intent2.putExtra("mobile_input_purpose", 2);
                            intent2.putExtra("couttry_code", this.countryCode);
                            intent2.putExtra("country_name", this.jbZ);
                            a bl = new a().bl(intent2);
                            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            finish();
                            overridePendingTransition(R.anim.s, R.anim.s);
                            AppMethodBeat.o(128548);
                            return;
                        } else {
                            bps();
                            AppMethodBeat.o(128548);
                            return;
                        }
                    default:
                        this.kqc = com.tencent.mm.plugin.account.a.a.jRu.b(this, i2, i3, intent);
                        if (this.kqc != null) {
                            this.gvv.setImageBitmap(this.kqc);
                            this.kpI = true;
                            this.kqa.setVisibility(8);
                            break;
                        }
                        break;
                }
            } else {
                Bundle bundle = null;
                if (intent != null) {
                    bundle = intent.getBundleExtra("result_data");
                }
                if (bundle == null || !bundle.getString("go_next", "").equals("agree_privacy")) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(712, 1, 1, false);
                    AppMethodBeat.o(128548);
                    return;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(712, 2, 1, false);
                this.kqi = false;
                if (!Util.isNullOrNil(this.kqf)) {
                    bpC();
                    AppMethodBeat.o(128548);
                    return;
                }
                Tv(this.kpW + this.knP);
                AppMethodBeat.o(128548);
                return;
            }
        } else if (i3 == -1 && bpq()) {
            bpD();
            com.tencent.mm.plugin.b.a.bxl("RE200_250");
            AppMethodBeat.o(128548);
            return;
        }
        AppMethodBeat.o(128548);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        String str2;
        com.tencent.mm.h.a Dk;
        AppMethodBeat.i(128549);
        Log.i("MicroMsg.RegByMobileRegAIOUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.kdn != null) {
            this.kdn.dismiss();
            this.kdn = null;
        }
        if (i3 == -75) {
            h.n(this, R.string.h0, R.string.fxq);
            AppMethodBeat.o(128549);
            return;
        }
        if (qVar.getType() == 145) {
            int Vj = ((com.tencent.mm.modelfriend.a) qVar).Vj();
            if (Vj == 12) {
                if (i3 == -41 || i3 == -59) {
                    com.tencent.mm.h.a Dk2 = com.tencent.mm.h.a.Dk(str);
                    if (Dk2 != null) {
                        Dk2.a(this, null, null);
                        AppMethodBeat.o(128549);
                        return;
                    }
                    h.n(this, R.string.fz6, R.string.fz7);
                    AppMethodBeat.o(128549);
                    return;
                }
                this.knP = PhoneFormater.pureNumber(this.knP);
                this.knn = this.kpW + this.knP;
                this.knu = ((com.tencent.mm.modelfriend.a) qVar).bbU();
                if (i3 == -36 || i3 == -35 || i3 == -3) {
                    String bbI = ((com.tencent.mm.modelfriend.a) qVar).bbI();
                    if (!Util.isNullOrNil(bbI)) {
                        this.knP = bbI.trim();
                    }
                    com.tencent.mm.plugin.b.a.bxk("RE200_100");
                    StringBuilder sb = new StringBuilder();
                    g.aAf();
                    StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",RE200_200,");
                    g.aAf();
                    com.tencent.mm.plugin.b.a.j(true, append.append(com.tencent.mm.kernel.a.FN("RE200_200")).append(",1").toString());
                    com.tencent.mm.h.a Dk3 = com.tencent.mm.h.a.Dk(str);
                    if (Dk3 != null) {
                        Dk3.a(this, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass11 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(128524);
                                RegByMobileRegAIOUI.x(RegByMobileRegAIOUI.this);
                                com.tencent.mm.plugin.b.a.bxl("RE200_250");
                                AppMethodBeat.o(128524);
                            }
                        }, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass13 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(196924);
                                StringBuilder sb = new StringBuilder();
                                g.aAf();
                                StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(RegByMobileRegAIOUI.this.getClass().getName()).append(",RE200_200,");
                                g.aAf();
                                com.tencent.mm.plugin.b.a.j(false, append.append(com.tencent.mm.kernel.a.FN("RE200_200")).append(",2").toString());
                                com.tencent.mm.plugin.b.a.bxl("RE200_100");
                                AppMethodBeat.o(196924);
                            }
                        });
                        AppMethodBeat.o(128549);
                        return;
                    }
                    bpD();
                    com.tencent.mm.plugin.b.a.bxl("RE200_250");
                    AppMethodBeat.o(128549);
                    return;
                } else if (i3 == -355) {
                    y.g(this, str, 30846);
                    this.kkY.eTd = (long) this.kop;
                    this.kkY.ejA = 5;
                    this.kkY.bfK();
                    AppMethodBeat.o(128549);
                    return;
                } else if (i3 == -34) {
                    h.c(this, getString(R.string.adu), "", true);
                    AppMethodBeat.o(128549);
                    return;
                } else if (com.tencent.mm.plugin.account.a.a.jRu.a(this, i2, i3, str)) {
                    AppMethodBeat.o(128549);
                    return;
                } else {
                    Toast.makeText(this, getString(R.string.af2, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
                }
            }
            if (Vj == 14) {
                if (i3 == 0) {
                    int bbJ = ((com.tencent.mm.modelfriend.a) qVar).bbJ();
                    if (bbJ == 2) {
                        cta bbM = ((com.tencent.mm.modelfriend.a) qVar).bbM();
                        if (bbM != null) {
                            Log.i("MicroMsg.RegByMobileRegAIOUI", "network check url %s", bbM.url);
                            Intent intent = new Intent();
                            intent.putExtra("Key_Seq", bbM.seq);
                            intent.putExtra("Key_Url", bbM.url);
                            intent.putExtra("Key_CountryCode", this.kpW);
                            intent.putExtra("Key_Mobile", this.knP);
                            intent.putExtra("Key_reg_sessionId", this.knu);
                            intent.putExtra("kintent_nickname", this.kqb.getText().toString());
                            intent.putExtra("kintent_password", this.kpZ.getText().toString());
                            intent.putExtra("kintent_hasavatar", this.kpI);
                            intent.setClass(this, RegByMobileAutoVerifyUI.class);
                            a bl = new a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        }
                    } else if (bbJ == 1) {
                        String bbL = ((com.tencent.mm.modelfriend.a) qVar).bbL();
                        String bbK = ((com.tencent.mm.modelfriend.a) qVar).bbK();
                        Intent intent2 = new Intent(this, RegByMobileSendSmsUI.class);
                        intent2.putExtra("regsession_id", this.knu);
                        intent2.putExtra("key_reg_style", 1);
                        intent2.putExtra("from_mobile", this.kpW + this.knP);
                        intent2.putExtra("to_mobile", bbL);
                        intent2.putExtra("verify_code", bbK);
                        intent2.putExtra("kintent_nickname", this.kqb.getText().toString());
                        intent2.putExtra("kintent_password", this.kpZ.getText().toString());
                        intent2.putExtra("kintent_hasavatar", this.kpI);
                        intent2.putExtra("reg_3d_app_type", this.kop);
                        intent2.putExtra("reg_3d_app_ticket", this.kqg);
                        a bl2 = new a().bl(intent2);
                        com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        startActivity((Intent) bl2.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    } else {
                        this.kql = ((com.tencent.mm.modelfriend.a) qVar).bbO();
                        this.kqm = ((com.tencent.mm.modelfriend.a) qVar).bbP();
                        this.kqn = ((com.tencent.mm.modelfriend.a) qVar).bbQ();
                        this.kqo = ((com.tencent.mm.modelfriend.a) qVar).bbR();
                        bpF();
                    }
                } else if (i3 == -41) {
                    h.n(this, R.string.fz6, R.string.fz7);
                    AppMethodBeat.o(128549);
                    return;
                } else if (i3 == -34) {
                    h.c(this, getString(R.string.adu), "", true);
                    AppMethodBeat.o(128549);
                    return;
                } else if (com.tencent.mm.plugin.account.a.a.jRu.a(this, i2, i3, str)) {
                    AppMethodBeat.o(128549);
                    return;
                } else {
                    Toast.makeText(this, getString(R.string.af2, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
                    AppMethodBeat.o(128549);
                    return;
                }
            }
        } else if (qVar.getType() == 755) {
            if (i2 == 0 && i3 == 0) {
                j jVar = (j) qVar;
                if (jVar.rr.iLL.iLR != null) {
                    str2 = ((ehh) jVar.rr.iLL.iLR).MyI;
                } else {
                    str2 = "";
                }
                this.kqg = str2;
                Tv(this.kpW + this.knP);
            } else if (i3 == -7) {
                this.kkY.eTd = (long) this.kop;
                this.kkY.ejA = 7;
                this.kkY.bfK();
                h.a((Context) this, getString(R.string.c7r), getString(R.string.zb), getString(R.string.dvg), getString(R.string.sz), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass14 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(196925);
                        RegByMobileRegAIOUI.y(RegByMobileRegAIOUI.this);
                        RegByMobileRegAIOUI.this.kkY.eTd = (long) RegByMobileRegAIOUI.this.kop;
                        RegByMobileRegAIOUI.this.kkY.ejA = 8;
                        RegByMobileRegAIOUI.this.kkY.bfK();
                        AppMethodBeat.o(196925);
                    }
                }, (DialogInterface.OnClickListener) null);
            }
        } else if ((qVar.getType() == 701 || qVar.getType() == 252) && i2 == 0 && i3 == 0) {
            this.kkY.eTd = (long) this.kop;
            this.kkY.ejA = 12;
            this.kkY.bfK();
            l.boe();
            y.St(z.aTY());
            t.dr(this);
            y.showAddrBookUploadConfirm(this, new Runnable() {
                /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass15 */

                public final void run() {
                    AppMethodBeat.i(196926);
                    Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(RegByMobileRegAIOUI.this);
                    bZ.addFlags(67108864);
                    RegByMobileRegAIOUI regByMobileRegAIOUI = RegByMobileRegAIOUI.this;
                    a bl = new a().bl(bZ);
                    com.tencent.mm.hellhoundlib.a.a.a(regByMobileRegAIOUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$22", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    regByMobileRegAIOUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(regByMobileRegAIOUI, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$22", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    StringBuilder sb = new StringBuilder();
                    g.aAf();
                    StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(RegByMobileRegAIOUI.this.getClass().getName()).append(",L14,");
                    g.aAf();
                    com.tencent.mm.plugin.b.a.DX(append.append(com.tencent.mm.kernel.a.FN("L14")).append(",4").toString());
                    RegByMobileRegAIOUI.this.finish();
                    AppMethodBeat.o(196926);
                }
            }, false, 2);
            AppMethodBeat.o(128549);
            return;
        }
        if (com.tencent.mm.plugin.account.a.a.jRu.a(this, i2, i3, str)) {
            AppMethodBeat.o(128549);
        } else if ((qVar.getType() == 252 || qVar.getType() == 701) && (Dk = com.tencent.mm.h.a.Dk(str)) != null && Dk.a(this, null, null)) {
            AppMethodBeat.o(128549);
        } else {
            AppMethodBeat.o(128549);
        }
    }

    private void bpD() {
        AppMethodBeat.i(128550);
        getString(R.string.zb);
        this.kdn = h.a((Context) this, getString(R.string.fyo), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass17 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        int bpE = bpE();
        Log.i("MicroMsg.RegByMobileRegAIOUI", "select mobile check type %d", Integer.valueOf(bpE));
        com.tencent.mm.modelfriend.a aVar = new com.tencent.mm.modelfriend.a(this.kpW + this.knP, 14, "", 0, "", bpE);
        aVar.Ok(this.knu);
        g.azz().a(aVar, 0);
        AppMethodBeat.o(128550);
    }

    private int bpE() {
        AppMethodBeat.i(196929);
        if (!Util.isNullOrNil(this.kqf)) {
            AppMethodBeat.o(196929);
            return 1;
        }
        Log.i("MicroMsg.RegByMobileRegAIOUI", "isMobile:%s, isMobileOpen:%s, SIM iso:%s", Boolean.valueOf(NetStatusUtil.isMobile(this)), Boolean.valueOf(NetStatusUtil.isMobileNetworkOpen(this)), com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso());
        if (NetStatusUtil.isMobile(this) || (NetStatusUtil.isMobileNetworkOpen(this) && !Util.isNullOrNil(com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso()))) {
            AppMethodBeat.o(196929);
            return 2;
        }
        AppMethodBeat.o(196929);
        return 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(128551);
        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIN("ie_reg");
        if (this.kqj != null) {
            this.kqj.dismiss();
        }
        this.kkY.bfK();
        super.onDestroy();
        AppMethodBeat.o(128551);
    }

    private synchronized void bpF() {
        AppMethodBeat.i(128552);
        if (!this.kqk) {
            this.kqk = true;
            finish();
            Intent intent = new Intent();
            intent.putExtra("bindmcontact_mobile", this.kpW + " " + this.kpT.getText().toString());
            intent.putExtra("bindmcontact_shortmobile", this.knP);
            intent.putExtra("country_name", this.jbZ);
            intent.putExtra("couttry_code", this.countryCode);
            intent.putExtra("mobileverify_countdownsec", this.kql);
            intent.putExtra("mobileverify_countdownstyle", this.kqm);
            intent.putExtra("mobileverify_fb", this.kqn);
            intent.putExtra("mobileverify_reg_qq", this.kqo);
            intent.putExtra("kintent_nickname", this.kqb.getText().toString());
            intent.putExtra("kintent_password", this.kpZ.getText().toString());
            intent.putExtra("kintent_hasavatar", this.kpI);
            intent.putExtra("key_reg_style", 1);
            intent.putExtra("regsession_id", this.knu);
            intent.putExtra("reg_3d_app_ticket", this.kqg);
            intent.putExtra("reg_3d_app_type", this.kop);
            intent.putExtra("mobile_verify_purpose", 2);
            startActivity(MobileVerifyUI.class, intent);
        }
        AppMethodBeat.o(128552);
    }

    private boolean bpq() {
        boolean z;
        AppMethodBeat.i(128553);
        if (Util.isNullOrNil(this.countryCode)) {
            z = false;
        } else {
            z = true;
        }
        boolean a2 = z & a(this.kpT.getText(), this.kpZ.getText(), this.kqb.getText());
        if (a2) {
            this.knH.setEnabled(true);
        } else {
            this.knH.setEnabled(false);
        }
        AppMethodBeat.o(128553);
        return a2;
    }

    private boolean a(Editable... editableArr) {
        boolean z;
        AppMethodBeat.i(128554);
        int i2 = 0;
        while (true) {
            if (i2 >= 3) {
                z = true;
                break;
            }
            Editable editable = editableArr[i2];
            if (editable == null || editable.toString().length() == 0) {
                z = false;
            } else {
                i2++;
            }
        }
        z = false;
        if (!z || !this.knN) {
            AppMethodBeat.o(128554);
            return false;
        }
        AppMethodBeat.o(128554);
        return true;
    }

    static /* synthetic */ void a(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        AppMethodBeat.i(128555);
        View currentFocus = regByMobileRegAIOUI.getWindow().getCurrentFocus();
        if (currentFocus != null) {
            int[] iArr = new int[2];
            currentFocus.getLocationInWindow(iArr);
            final int height = (iArr[1] - regByMobileRegAIOUI.getSupportActionBar().getHeight()) - 128;
            if (height > 0) {
                regByMobileRegAIOUI.kqd.post(new Runnable() {
                    /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass18 */

                    public final void run() {
                        AppMethodBeat.i(196928);
                        RegByMobileRegAIOUI.this.kqd.smoothScrollBy(0, height);
                        AppMethodBeat.o(196928);
                    }
                });
            }
        }
        AppMethodBeat.o(128555);
    }

    static /* synthetic */ void f(RegByMobileRegAIOUI regByMobileRegAIOUI, final String str) {
        int i2 = 0;
        AppMethodBeat.i(196933);
        final com.tencent.mm.modelfriend.a aVar = new com.tencent.mm.modelfriend.a(str, 12, "", 0, "");
        regByMobileRegAIOUI.getString(R.string.zb);
        regByMobileRegAIOUI.kdn = h.a((Context) regByMobileRegAIOUI, regByMobileRegAIOUI.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass9 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(196922);
                synchronized (aVar) {
                    try {
                        g.azz().a(aVar);
                    } catch (Throwable th) {
                    }
                    try {
                    } catch (Throwable th2) {
                        AppMethodBeat.o(196922);
                        throw th2;
                    }
                }
                AppMethodBeat.o(196922);
            }
        });
        String pureNumber = PhoneFormater.pureNumber(regByMobileRegAIOUI.kpT.getText().toString().trim());
        if (regByMobileRegAIOUI.knm != null && regByMobileRegAIOUI.knn != null && !pureNumber.equals(regByMobileRegAIOUI.knm) && pureNumber.equals(regByMobileRegAIOUI.knn)) {
            i2 = 1;
        } else if (regByMobileRegAIOUI.knm != null && regByMobileRegAIOUI.knn != null && !regByMobileRegAIOUI.knn.equals(regByMobileRegAIOUI.knm) && !pureNumber.equals(regByMobileRegAIOUI.knn)) {
            i2 = 2;
        }
        regByMobileRegAIOUI.knm = PhoneFormater.pureNumber(regByMobileRegAIOUI.kpT.getText().toString().trim());
        aVar.sZ(regByMobileRegAIOUI.kno);
        aVar.ta(i2);
        regByMobileRegAIOUI.kno++;
        final String obj = regByMobileRegAIOUI.kqb.getText().toString();
        final String mD5String = MD5Util.getMD5String(regByMobileRegAIOUI.kpZ.getText().toString());
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass10 */

            /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
                ((com.tencent.mm.protocal.n.a) r0.iMO.getReqObj()).KzI.KQc = r8.kqp.kqg;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
                if (com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIO("ie_reg") == false) goto L_0x004e;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
                com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIN("ie_reg");
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x004e, code lost:
                r0 = new com.tencent.mm.protocal.protobuf.dmd();
                r0.oUJ = r4;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x005d, code lost:
                if (r8.kqp.kpI == false) goto L_0x0083;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x0065, code lost:
                if (r8.kqp.kqc == null) goto L_0x0083;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x0071, code lost:
                if (r8.kqp.kqc.isRecycled() != false) goto L_0x0083;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x0073, code lost:
                r0.Mvm = com.tencent.mm.sdk.platformtools.MD5Util.getMD5String(com.tencent.mm.sdk.platformtools.BitmapUtil.Bitmap2Bytes(r8.kqp.kqc));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0083, code lost:
                r0.MPI = r9;
                r0.MPH = r6;
                r0.rBH = com.tencent.mm.sdk.platformtools.Util.getTimeZoneOffset();
                r0.MPJ = java.util.TimeZone.getDefault().getID();
                r1 = r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x009d, code lost:
                monitor-enter(r1);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a4, code lost:
                if (r0.isCanceled() == false) goto L_0x00b2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a6, code lost:
                monitor-exit(r1);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b2, code lost:
                monitor-exit(r1);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b3, code lost:
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RegByMobileRegAIOUI", "%s,%s", r0.rBH, r0.MPJ);
                r1 = new com.tencent.mm.protocal.protobuf.ewf();
                r1.NtO = new com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIP("ie_reg"));
                r1.NtP = new com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIS("ce_reg"));
                r1.NtQ = new com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.exJ());
                r1.NtU = new com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.exM());
                r2 = com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIT("ce_reg");
             */
            /* JADX WARNING: Code restructure failed: missing block: B:34:0x011f, code lost:
                if (r2 == null) goto L_0x0130;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:35:0x0121, code lost:
                r1.NtV = new com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t().setBuffer(r2.getBytes());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
                r1.NtR = new com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t().setBuffer(r0.toByteArray());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:45:0x0155, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:47:0x0157, code lost:
                com.tencent.matrix.trace.core.AppMethodBeat.o(196923);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:48:0x015a, code lost:
                throw r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:49:0x015b, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:50:0x015c, code lost:
                com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.RegByMobileRegAIOUI", r0, "convert to byte error ! %s", r0.getMessage());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
                if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r8.kqp.kqg) != false) goto L_0x003b;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 387
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass10.run():void");
            }
        }, "reg_permchk", 7);
        AppMethodBeat.o(196933);
    }

    static /* synthetic */ void y(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        AppMethodBeat.i(196935);
        regByMobileRegAIOUI.getString(R.string.zb);
        String string = regByMobileRegAIOUI.getString(R.string.emm);
        final com.tencent.mm.modelsimple.t tVar = new com.tencent.mm.modelsimple.t("facebook@wechat_auth", regByMobileRegAIOUI.kqf, 0, "", "", "", 0, "", true, false);
        regByMobileRegAIOUI.kdn = h.a((Context) regByMobileRegAIOUI, string, true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.AnonymousClass16 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(196927);
                g.azz().a(tVar);
                AppMethodBeat.o(196927);
            }
        });
        g.azz().a(tVar, 0);
        AppMethodBeat.o(196935);
    }
}
