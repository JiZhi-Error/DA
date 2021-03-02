package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.g.a.zs;
import com.tencent.mm.g.b.a.kx;
import com.tencent.mm.g.b.a.le;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.remittance.a.c;
import com.tencent.mm.plugin.remittance.model.ad;
import com.tencent.mm.plugin.remittance.model.o;
import com.tencent.mm.plugin.remittance.model.t;
import com.tencent.mm.plugin.remittance.model.u;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.plugin.remittance.ui.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.pay.a.b;
import com.tencent.mm.plugin.wallet_core.c.ai;
import com.tencent.mm.plugin.wallet_core.c.aj;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.view.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.zd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@com.tencent.mm.ui.base.a(2)
public abstract class RemittanceBaseUI extends WalletBaseUI implements e.a {
    protected String APz;
    private double Cpd;
    protected com.tencent.mm.plugin.wallet.a CqM = null;
    protected String CqN;
    protected String CqO;
    protected String CqP;
    private int CqQ = -1;
    protected boolean CqR = false;
    protected String CqS;
    protected ImageView CqT;
    protected TextView CqU;
    protected TextView CqV;
    protected TextView CqW;
    protected TextView CqX;
    protected TextView CqY;
    private TextView CqZ;
    private boolean CrA = false;
    private IListener CrB = new IListener<zs>() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass5 */

        {
            AppMethodBeat.i(160837);
            this.__eventId = zs.class.getName().hashCode();
            AppMethodBeat.o(160837);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zs zsVar) {
            AppMethodBeat.i(67954);
            if (Util.isEqual(RemittanceBaseUI.this.Cry.getUri(), zsVar.efL.uri) && Util.isEqual(RemittanceBaseUI.this.Cry.yXM, 1)) {
                RemittanceBaseUI.this.finish();
            }
            AppMethodBeat.o(67954);
            return false;
        }
    };
    private boolean CrC = false;
    private boolean CrD = false;
    private boolean CrE = false;
    private boolean CrF = false;
    private zd CrG = null;
    private IListener CrH = new IListener<gl>() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass22 */

        {
            AppMethodBeat.i(160838);
            this.__eventId = gl.class.getName().hashCode();
            AppMethodBeat.o(160838);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(gl glVar) {
            AppMethodBeat.i(67970);
            gl glVar2 = glVar;
            if (glVar2.dKn.dKp == 1) {
                h.INSTANCE.a(15386, 4, 1);
            } else {
                h.INSTANCE.a(15386, 5, 1);
            }
            Log.i("MicroMsg.RemittanceBaseUI", "receive dynamic req: %s, %s", Integer.valueOf(glVar2.dKn.dKp), glVar2.dKn.dKo);
            if (RemittanceBaseUI.this.mPayScene == 33) {
                RemittanceBaseUI remittanceBaseUI = RemittanceBaseUI.this;
                String str = RemittanceBaseUI.this.mDesc;
                int unused = RemittanceBaseUI.this.CqQ;
                remittanceBaseUI.aMj(str);
            } else {
                RemittanceBaseUI remittanceBaseUI2 = RemittanceBaseUI.this;
                String str2 = RemittanceBaseUI.this.mDesc;
                int unused2 = RemittanceBaseUI.this.CqQ;
                remittanceBaseUI2.aMj(str2);
            }
            AppMethodBeat.o(67970);
            return false;
        }
    };
    protected double CrI = 0.0d;
    protected String CrJ = "";
    protected String CrK = "";
    protected String CrL = "";
    private IListener<gn> CrM = new IListener<gn>() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass26 */

        {
            AppMethodBeat.i(213762);
            this.__eventId = gn.class.getName().hashCode();
            AppMethodBeat.o(213762);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(gn gnVar) {
            boolean z = true;
            AppMethodBeat.i(213763);
            gn gnVar2 = gnVar;
            if (gnVar2.dKu.isKinda) {
                Log.f("MicroMsg.RemittanceBaseUI", "F2fPayCheckEvent is from kinda");
                if (gnVar2.dKu.dDN == 1) {
                    RemittanceBaseUI.a(RemittanceBaseUI.this, gnVar2.dKu.dDL, gnVar2.dKu.dDM);
                    if (gnVar2.dKu.dKv == RemittanceBaseUI.this.getContext().hashCode()) {
                        c.eMU().eMX().jM(RemittanceBaseUI.this.Crw, RemittanceBaseUI.this.goe);
                    } else {
                        Log.w("MicroMsg.RemittanceBaseUI", "callback to wrong page: %s, %s", Integer.valueOf(gnVar2.dKu.dKv), Integer.valueOf(RemittanceBaseUI.this.getContext().hashCode()));
                    }
                } else if (gnVar2.dKu.dDN == 2) {
                    if (!(RemittanceBaseUI.this.mScene == 2 || RemittanceBaseUI.this.mScene == 5)) {
                        z = false;
                    }
                    if (Util.isNullOrNil(RemittanceBaseUI.this.goe) || z) {
                        RemittanceBaseUI.this.finish();
                    } else {
                        Intent intent = new Intent();
                        intent.putExtra("Chat_User", RemittanceBaseUI.this.goe);
                        intent.putExtra("finish_direct", false);
                        com.tencent.mm.br.c.f(RemittanceBaseUI.this, ".ui.chatting.ChattingUI", intent);
                    }
                }
                AppMethodBeat.o(213763);
            } else {
                RemittanceBaseUI.a(RemittanceBaseUI.this, gnVar2.dKu.dDL, gnVar2.dKu.dDM);
                AppMethodBeat.o(213763);
            }
            return false;
        }
    };
    private TextView Cra;
    protected TextView Crb;
    private LinearLayout Crc;
    private LinearLayout Crd;
    private LinearLayout Cre;
    private TextView Crf;
    private TextView Crg;
    private LinearLayout Crh;
    protected String Cri;
    protected boolean Crj = true;
    protected String Crk;
    private String Crl;
    private String Crm;
    protected String Crn;
    protected String Cro = null;
    protected String Crp = null;
    protected int Crq;
    private int Crr;
    protected String Crs;
    protected String Crt;
    protected String Cru;
    private Map<String, a> Crv = new HashMap();
    private String Crw;
    protected boolean Crx = false;
    private w Cry;
    private kx Crz;
    private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 270);
    private String dRM;
    protected int dYe = 0;
    protected String goe;
    protected ScrollView jVf;
    protected double jVp;
    protected Button krs;
    private int mChannel;
    protected String mDesc;
    protected String mName;
    protected int mPayScene;
    protected int mScene;
    protected WalletFormView qAh;
    protected String qnT;

    public abstract void aMj(String str);

    public abstract void eNK();

    public abstract void eNN();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(RemittanceBaseUI remittanceBaseUI, String str, String str2) {
        a aVar = remittanceBaseUI.Crv.get(str);
        Log.d("MicroMsg.RemittanceBaseUI", "match reqKey: %s, %d", str, Integer.valueOf(remittanceBaseUI.Crv.size()));
        if (aVar == null) {
            Log.i("MicroMsg.RemittanceBaseUI", "no data for: %s", str);
        } else {
            Log.i("MicroMsg.RemittanceBaseUI", "pay check: %d", Integer.valueOf(remittanceBaseUI.mPayScene));
            if (Util.isNullOrNil(aVar.dDM)) {
                aVar.dDM = str2;
            }
            if (Util.isNullOrNil(aVar.qvD)) {
                aVar.qvD = str2;
            }
            if (remittanceBaseUI.mPayScene == 31) {
                g.azz().a(new t(str, aVar.dQp, aVar.dDM, aVar.Cpm, aVar.CrW, aVar.qya), 0);
            } else {
                g.azz().a(new o(aVar.Cph, aVar.qvD, aVar.qya, aVar.Cpi, aVar.yRL), 0);
            }
        }
        remittanceBaseUI.Crv.clear();
    }

    static /* synthetic */ void c(RemittanceBaseUI remittanceBaseUI) {
        if (remittanceBaseUI.mPayScene != 33 && remittanceBaseUI.mPayScene != 32) {
            if (!Util.isEqual(remittanceBaseUI.CqQ, 0) || Util.isNullOrNil(remittanceBaseUI.mName)) {
                remittanceBaseUI.Cre.setVisibility(8);
                return;
            }
            remittanceBaseUI.Cre.setVisibility(0);
            remittanceBaseUI.Crf.setText(remittanceBaseUI.mName + "  " + remittanceBaseUI.APz);
            remittanceBaseUI.Crg.setText(remittanceBaseUI.Cri);
        }
    }

    static /* synthetic */ void d(RemittanceBaseUI remittanceBaseUI) {
        ForegroundColorSpan foregroundColorSpan;
        if (Util.isNullOrNil(remittanceBaseUI.mDesc)) {
            remittanceBaseUI.CqX.setVisibility(8);
            if (remittanceBaseUI.mScene == 1) {
                remittanceBaseUI.CqY.setText(R.string.g1i);
            } else {
                remittanceBaseUI.CqY.setText(R.string.g1h);
            }
            remittanceBaseUI.CqY.setVisibility(0);
            return;
        }
        new l(remittanceBaseUI.getContext());
        String string = remittanceBaseUI.getString(R.string.g3a);
        SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(remittanceBaseUI, remittanceBaseUI.getString(R.string.b6m, new Object[]{remittanceBaseUI.mDesc, string}));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(c2);
        if (Util.isEqual(remittanceBaseUI.CqQ, 0)) {
            foregroundColorSpan = new ForegroundColorSpan(-15970418);
        } else {
            foregroundColorSpan = new ForegroundColorSpan(remittanceBaseUI.getContext().getResources().getColor(R.color.x0));
        }
        spannableStringBuilder.setSpan(foregroundColorSpan, c2.length() - string.length(), c2.length(), 34);
        remittanceBaseUI.CqX.setText(spannableStringBuilder);
        remittanceBaseUI.CqY.setVisibility(8);
        remittanceBaseUI.CqX.setVisibility(0);
    }

    static /* synthetic */ void eNT() {
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        if (this.mPayScene == 33 || this.mPayScene == 32) {
            return R.layout.bmw;
        }
        if (!Util.isEqual(this.CqQ, 0)) {
            return R.layout.bmv;
        }
        hideActionbarLine();
        return R.layout.bmz;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        this.mScene = getIntent().getIntExtra("scene", 0);
        this.mPayScene = getIntent().getIntExtra("pay_scene", 31);
        if (!eNQ()) {
            this.dRM = UUID.randomUUID().toString();
            b.aUU(this.dRM);
        }
        if (this instanceof RemittanceHKUI) {
            this.CqQ = 1;
        } else if (this instanceof RemittanceOSUI) {
            this.CqQ = 2;
        }
        super.onCreate(bundle);
        this.CqM = com.tencent.mm.plugin.wallet.a.be(getIntent());
        this.CqS = getIntent().getStringExtra("scan_remittance_id");
        this.jVp = getIntent().getDoubleExtra("fee", 0.0d);
        this.goe = getIntent().getStringExtra("receiver_name");
        this.CqO = getIntent().getStringExtra("recv_headimgurl");
        this.qnT = getIntent().getStringExtra("receiver_nick_name");
        this.Crn = getIntent().getStringExtra("receiver_true_name");
        this.CqN = getIntent().getStringExtra("mch_name");
        this.CqP = getIntent().getStringExtra("mch_info");
        this.mChannel = getIntent().getIntExtra("pay_channel", 0);
        this.Crs = Util.nullAs(getIntent().getStringExtra("rcvr_open_id"), "");
        Log.i("MicroMsg.RemittanceBaseUI", "mUserName %s", this.goe);
        g.aAi();
        long longValue = ((Long) g.aAh().azQ().get(147457, (Object) 0L)).longValue();
        if ((16 & longValue) != 0) {
            this.Crr = 1;
        } else if ((longValue & 32) != 0) {
            this.Crr = 2;
        } else {
            this.Crr = 0;
        }
        p.aYn().a(this);
        initView();
        this.CrM.alive();
        com.tencent.mm.wallet_core.b.hgC();
        this.mKindaEnable = com.tencent.mm.wallet_core.b.b(b.a.clicfg_kinda_open, true);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        super.onDestroy();
        EventCenter.instance.removeListener(this.CrB);
        p.aYn().b(this);
        this.CrM.dead();
        this.CrH.dead();
        com.tencent.mm.plugin.wallet.pay.a.b.aUV(this.dRM);
    }

    public void eNI() {
        u uVar = new u(this.goe, this.CqS);
        uVar.setProcessName("RemittanceProcess");
        doSceneProgress(uVar);
    }

    public void eNJ() {
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        if (this.mPayScene == 33 || this.mPayScene == 32) {
            setMMTitle(R.string.g1y);
        } else {
            setMMTitle(R.string.g4o);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(67950);
                if (RemittanceBaseUI.this.mScene == 1 || RemittanceBaseUI.this.mScene == 6) {
                    RemittanceBaseUI.this.eNI();
                    RemittanceBaseUI.this.finish();
                } else if (RemittanceBaseUI.this.mScene == 2 || RemittanceBaseUI.this.mScene == 5) {
                    RemittanceBaseUI.this.finish();
                } else {
                    RemittanceBaseUI.this.eNS();
                }
                RemittanceBaseUI.this.eNJ();
                AppMethodBeat.o(67950);
                return true;
            }
        });
        this.mKeyboard = (MyKeyboardWindow) findViewById(R.id.ijb);
        this.mKBLayout = findViewById(R.id.ija);
        this.jVf = (ScrollView) findViewById(R.id.h9a);
        this.CqT = (ImageView) findViewById(R.id.h2j);
        this.CqU = (TextView) findViewById(R.id.h2k);
        this.CqV = (TextView) findViewById(R.id.h2l);
        this.CqV.setVisibility(8);
        this.Crd = (LinearLayout) findViewById(R.id.h1t);
        this.Crc = (LinearLayout) findViewById(R.id.h22);
        this.Cra = (TextView) findViewById(R.id.h20);
        this.Crb = (TextView) findViewById(R.id.h21);
        this.CqZ = (TextView) findViewById(R.id.h1w);
        if (Util.isEqual(this.CqQ, 0)) {
            this.Cre = (LinearLayout) findViewById(R.id.h0d);
            this.Crf = (TextView) findViewById(R.id.fth);
            this.Crg = (TextView) findViewById(R.id.ha);
        }
        eNO();
        this.qAh = (WalletFormView) findViewById(R.id.fjf);
        if (this.mPayScene == 33) {
            this.Cra.setText(f.formatMoney2f(this.jVp));
            this.Crb.setText(ah.hhz());
            this.Crk = getIntent().getStringExtra("desc");
            if (!Util.isNullOrNil(this.Crk)) {
                this.CqZ.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), this.Crk, this.CqZ.getTextSize()));
                this.CqZ.setVisibility(0);
            } else {
                this.CqZ.setVisibility(8);
            }
            this.Crc.setVisibility(0);
            this.Crd.setVisibility(8);
        } else {
            this.qAh.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass32 */

                public final void onClick(View view) {
                    AppMethodBeat.i(67984);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    RemittanceBaseUI.this.hideTenpayKB();
                    RemittanceBaseUI.eNT();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(67984);
                }
            });
            this.qAh.getTitleTv().setText(String.format(getString(R.string.g3d), "¥"));
            this.qAh.a(new TextWatcher() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass2 */

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void afterTextChanged(Editable editable) {
                    AppMethodBeat.i(67951);
                    if (editable.toString().startsWith(".")) {
                        editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    }
                    String obj = editable.toString();
                    int indexOf = obj.indexOf(".");
                    int length = obj.length();
                    if (indexOf >= 0 && length - indexOf > 2) {
                        editable.delete(indexOf + 3, length);
                    }
                    AppMethodBeat.o(67951);
                }
            });
            setEditFocusListener(this.qAh, 2, false);
            findViewById(R.id.gc4);
            findViewById(R.id.h2a).setVisibility(0);
            this.Crc.setVisibility(8);
            this.Crd.setVisibility(0);
            setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.ui.a
                public final void onVisibleStateChange(boolean z) {
                    AppMethodBeat.i(67952);
                    if (z) {
                        RemittanceBaseUI.this.scrollToFormEditPosAfterShowTenPay(RemittanceBaseUI.this.jVf, RemittanceBaseUI.this.krs, 30);
                        AppMethodBeat.o(67952);
                        return;
                    }
                    RemittanceBaseUI.this.jVf.scrollTo(0, 0);
                    AppMethodBeat.o(67952);
                }
            });
        }
        this.krs = (Button) findViewById(R.id.fz0);
        this.krs.setOnClickListener(new x() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass12 */

            @Override // com.tencent.mm.ui.x
            public final void czW() {
                AppMethodBeat.i(67960);
                if (RemittanceBaseUI.this.mPayScene == 33) {
                    RemittanceBaseUI remittanceBaseUI = RemittanceBaseUI.this;
                    String str = RemittanceBaseUI.this.mDesc;
                    int unused = RemittanceBaseUI.this.CqQ;
                    remittanceBaseUI.aMj(str);
                } else {
                    RemittanceBaseUI.this.jVp = Util.getDouble(RemittanceBaseUI.this.qAh.getText(), 0.0d);
                    if (!RemittanceBaseUI.this.qAh.bql()) {
                        com.tencent.mm.ui.base.u.makeText(RemittanceBaseUI.this.getContext(), (int) R.string.i7f, 0).show();
                    } else if (RemittanceBaseUI.this.jVp < 0.01d) {
                        RemittanceBaseUI.this.eNK();
                    } else {
                        RemittanceBaseUI.this.hideTenpayKB();
                        RemittanceBaseUI.eNT();
                        RemittanceBaseUI remittanceBaseUI2 = RemittanceBaseUI.this;
                        String str2 = RemittanceBaseUI.this.mDesc;
                        int unused2 = RemittanceBaseUI.this.CqQ;
                        remittanceBaseUI2.aMj(str2);
                    }
                }
                if (RemittanceBaseUI.this.Cpd == 0.0d) {
                    if (RemittanceBaseUI.this.mScene == 1) {
                        h.INSTANCE.a(12689, 15, 1);
                    } else {
                        h.INSTANCE.a(12689, 6, 1);
                    }
                }
                if (RemittanceBaseUI.this.mScene == 1 && !Util.isNullOrNil(RemittanceBaseUI.this.mDesc)) {
                    h.INSTANCE.a(14074, 2);
                }
                AppMethodBeat.o(67960);
            }
        });
        this.CqX = (TextView) findViewById(R.id.h13);
        this.CqY = (TextView) findViewById(R.id.gw);
        if (this.mScene == 1 || this.mScene == 6) {
            this.CqY.setText(R.string.g1i);
        } else {
            this.CqY.setText(R.string.g1h);
        }
        if (!z.aUo()) {
            findViewById(R.id.h14).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass23 */

                public final void onClick(View view) {
                    String str;
                    String str2;
                    AppMethodBeat.i(67977);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    RemittanceBaseUI.this.hideTenpayKB();
                    RemittanceBaseUI.eNT();
                    h.INSTANCE.a(12689, 9, 1);
                    if (RemittanceBaseUI.this.mScene == 1 || RemittanceBaseUI.this.mScene == 6) {
                        str2 = RemittanceBaseUI.this.getString(R.string.g1i);
                        str = RemittanceBaseUI.this.getString(R.string.g29);
                        h.INSTANCE.a(14074, 1);
                    } else {
                        str2 = RemittanceBaseUI.this.getString(R.string.g1h);
                        str = RemittanceBaseUI.this.getString(R.string.g1o);
                        if (Util.isEqual(RemittanceBaseUI.this.CqQ, 0) && RemittanceBaseUI.this.CqR) {
                            com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceBaseUI.this, str2, RemittanceBaseUI.this.mDesc, str, RemittanceBaseUI.this.Crj, RemittanceBaseUI.this.mName, RemittanceBaseUI.this.APz, RemittanceBaseUI.this.Cri, new a.AbstractC1922a() {
                                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass23.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.wallet_core.ui.view.a.AbstractC1922a
                                public final boolean a(boolean z, String str, String str2, String str3, String str4) {
                                    AppMethodBeat.i(67971);
                                    RemittanceBaseUI.this.Crj = z;
                                    if (!Util.isNullOrNil(str)) {
                                        RemittanceBaseUI.this.mDesc = str;
                                    } else {
                                        RemittanceBaseUI.this.mDesc = null;
                                    }
                                    if (!RemittanceBaseUI.this.Crj) {
                                        if (!Util.isNullOrNil(str2)) {
                                            RemittanceBaseUI.this.mName = str2;
                                        } else {
                                            RemittanceBaseUI.this.mName = null;
                                        }
                                        if (!Util.isNullOrNil(str3)) {
                                            RemittanceBaseUI.this.APz = str3;
                                        } else {
                                            RemittanceBaseUI.this.APz = null;
                                        }
                                        if (!Util.isNullOrNil(str4)) {
                                            RemittanceBaseUI.this.Cri = str4;
                                        } else {
                                            RemittanceBaseUI.this.Cri = null;
                                        }
                                    } else {
                                        RemittanceBaseUI.this.mName = null;
                                        RemittanceBaseUI.this.APz = null;
                                        RemittanceBaseUI.this.Cri = null;
                                    }
                                    RemittanceBaseUI.c(RemittanceBaseUI.this);
                                    RemittanceBaseUI.d(RemittanceBaseUI.this);
                                    AppMethodBeat.o(67971);
                                    return true;
                                }
                            }, new f.c() {
                                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass23.AnonymousClass2 */

                                @Override // com.tencent.mm.ui.widget.a.f.c
                                public final void e(boolean z, String str) {
                                    AppMethodBeat.i(67973);
                                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass23.AnonymousClass2.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(67972);
                                            RemittanceBaseUI.this.hideVKB();
                                            AppMethodBeat.o(67972);
                                        }
                                    }, 500);
                                    AppMethodBeat.o(67973);
                                }
                            });
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(67977);
                            return;
                        }
                    }
                    com.tencent.mm.plugin.wallet_core.ui.view.a.a(RemittanceBaseUI.this, str2, RemittanceBaseUI.this.mDesc, str, 20, new h.b() {
                        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass23.AnonymousClass3 */

                        @Override // com.tencent.mm.ui.base.h.b
                        public final boolean onFinish(CharSequence charSequence) {
                            AppMethodBeat.i(67974);
                            if (!Util.isNullOrNil(charSequence.toString())) {
                                RemittanceBaseUI.this.mDesc = charSequence.toString();
                                RemittanceBaseUI.d(RemittanceBaseUI.this);
                            } else {
                                RemittanceBaseUI.this.mDesc = null;
                                RemittanceBaseUI.d(RemittanceBaseUI.this);
                            }
                            AppMethodBeat.o(67974);
                            return true;
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass23.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(67976);
                            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass23.AnonymousClass4.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(67975);
                                    RemittanceBaseUI.this.hideVKB();
                                    AppMethodBeat.o(67975);
                                }
                            }, 500);
                            AppMethodBeat.o(67976);
                        }
                    });
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(67977);
                }
            });
        }
        if (this.mScene == 1) {
            g.aAi();
            if (((String) g.aAh().azQ().get(327732, AppEventsConstants.EVENT_PARAM_VALUE_NO)).equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                com.tencent.mm.ui.base.h.a(getContext(), (int) R.string.g3g, (int) R.string.g3h, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass27 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                g.aAi();
                g.aAh().azQ().set(327732, "1");
                g.aAi();
                g.aAh().azQ().gBI();
            }
        }
        this.CqW = (TextView) findViewById(R.id.gc4);
        this.Crh = (LinearLayout) findViewById(R.id.h2a);
        eNM();
        eNN();
        eNL();
        if (this.mPayScene == 33 || this.mPayScene == 32) {
        }
    }

    private void eNL() {
        if (!eNQ() || Util.isNullOrNil(this.Crp) || this.Crr == 0 || this.Crq != 1) {
            removeAllOptionMenu();
        } else {
            addIconOptionMenu(0, R.drawable.crt, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass28 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(67980);
                    com.tencent.mm.wallet_core.ui.f.p(RemittanceBaseUI.this.getContext(), RemittanceBaseUI.this.Crp, false);
                    AppMethodBeat.o(67980);
                    return false;
                }
            });
        }
    }

    private void eNM() {
        int i2;
        if (Util.isNullOrNil(this.Cro) || this.Crr == 0) {
            this.CqW.setText("");
            this.CqW.setVisibility(8);
            return;
        }
        if (this.Crr == 1) {
            i2 = 2;
        } else {
            i2 = 24;
        }
        try {
            this.CqW.setText(String.format(this.Cro, Integer.valueOf(i2)));
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.RemittanceBaseUI", e2, "", new Object[0]);
            this.CqW.setText(getString(R.string.g3m, new Object[]{Integer.valueOf(i2)}));
        }
        this.CqW.setVisibility(0);
    }

    private void eNO() {
        boolean z;
        j aYB;
        i Mx;
        String string;
        String hs = com.tencent.mm.wallet_core.ui.f.hs(com.tencent.mm.wallet_core.ui.f.getDisplayName(this.goe), 10);
        if (!Util.isNullOrNil(this.Crn)) {
            hs = getString(R.string.g22, new Object[]{hs, this.Crn});
        }
        if (this.mScene == 1) {
            String stringExtra = getIntent().getStringExtra("receiver_tips");
            this.CqU.setTextColor(getResources().getColor(R.color.a2x));
            this.CqV.setVisibility(0);
            if (Util.isNullOrNil(this.goe)) {
                string = getString(R.string.g25, new Object[]{this.Crn});
            } else {
                string = getString(R.string.g24, new Object[]{com.tencent.mm.wallet_core.ui.f.hs(com.tencent.mm.wallet_core.ui.f.getDisplayName(this.goe), 10), this.Crn});
            }
            this.CqV.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, string, this.CqV.getTextSize()));
            hs = stringExtra;
        } else if (this.mScene == 6) {
            String stringExtra2 = getIntent().getStringExtra("receiver_tips");
            if (!Util.isNullOrNil(this.qnT)) {
                hs = this.qnT;
            }
            if (Util.isNullOrNil(stringExtra2)) {
                hs = getString(R.string.g23, new Object[]{hs});
            } else {
                hs = Util.safeFormatString(stringExtra2, hs);
            }
        }
        this.CqU.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, hs, this.CqU.getTextSize()));
        if (!g.aAc() || (aYB = p.aYB()) == null || Util.isNullOrNil(this.goe) || ((Mx = aYB.Mx(this.goe)) != null && !Util.isNullOrNil(Mx.aYu()))) {
            z = false;
        } else {
            final long nowMilliSecond = Util.nowMilliSecond();
            ay.a.iDq.a(this.goe, "", new ay.b.a() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass29 */

                @Override // com.tencent.mm.model.ay.b.a
                public final void p(String str, boolean z) {
                    AppMethodBeat.i(67981);
                    if (z) {
                        Log.v("MicroMsg.RemittanceBaseUI", "getContact suc; cost=" + (Util.nowMilliSecond() - nowMilliSecond) + " ms");
                        com.tencent.mm.aj.c.ap(str, 3);
                    } else {
                        Log.w("MicroMsg.RemittanceBaseUI", "getContact failed");
                    }
                    RemittanceBaseUI.this.eNP();
                    AppMethodBeat.o(67981);
                }
            });
            z = true;
        }
        if (Util.isNullOrNil(this.goe) && !Util.isNullOrNil(this.CqO)) {
            Log.i("MicroMsg.RemittanceBaseUI", "use mRecvHeadimgurl(%s) to avatar, mReceiverAvatarIv:%s", this.CqO, this.CqT.getClass().getSimpleName());
            if (this.CqT instanceof CdnImageView) {
                int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 44.0f);
                ((CdnImageView) this.CqT).setRoundCorner(true);
                ((CdnImageView) this.CqT).s(this.CqO, fromDPToPix, fromDPToPix, R.drawable.bca);
            }
        } else if (!z) {
            eNP();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void eNP() {
        final AnonymousClass30 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass30 */

            public final void run() {
                AppMethodBeat.i(67982);
                Bitmap a2 = com.tencent.mm.aj.c.a(RemittanceBaseUI.this.goe, false, -1, null);
                if (a2 == null) {
                    RemittanceBaseUI.this.CqT.setImageResource(R.drawable.bca);
                    AppMethodBeat.o(67982);
                    return;
                }
                RemittanceBaseUI.this.CqT.setImageBitmap(a2);
                AppMethodBeat.o(67982);
            }
        };
        if (MMHandlerThread.isMainThread()) {
            r0.run();
        } else {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass31 */

                public final void run() {
                    AppMethodBeat.i(67983);
                    r0.run();
                    AppMethodBeat.o(67983);
                }
            });
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        this.Cru = "";
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof w) {
                w wVar = (w) qVar;
                af.z(this.mPayScene, wVar.dNQ, i3);
                this.Crm = wVar.CoY;
                if (!Util.isNullOrNil(wVar.Cpg)) {
                    this.Crn = wVar.Cpg;
                }
                if (this.mPayScene == 32 || this.mPayScene == 33) {
                    this.Crw = wVar.qvD;
                } else {
                    this.Crw = wVar.dQp;
                }
                if (this.CqM != null) {
                    this.CqM.k(10000, Integer.valueOf(this.mPayScene), this.goe, Double.valueOf(wVar.Cpj));
                }
                this.Crt = wVar.Cpw == null ? "" : Util.isNullOrNil(wVar.Cpw.Crt) ? this.Crt : wVar.Cpw.Crt;
                if (!a(wVar)) {
                    a(wVar.dNQ, this.goe, this.Crn, wVar);
                } else if (this.mKindaEnable) {
                    hideLoading();
                }
                this.Crv.put(wVar.dNQ, new a(wVar.Cph, wVar.qvD, wVar.qya, wVar.Cpi, wVar.yRL, wVar.dQp, wVar.dDM, wVar.Cpm, Util.getLong(wVar.Cpk, 0)));
            } else if (qVar instanceof ai) {
                ai aiVar = (ai) qVar;
                if (!Util.isNullOrNil(aiVar.HQt)) {
                    ((TextView) findViewById(R.id.h2y)).setText(aiVar.HQt);
                    View findViewById = findViewById(R.id.iob);
                    findViewById.setVisibility(0);
                    findViewById.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass4 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(67953);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            f.a(RemittanceBaseUI.this, RemittanceBaseUI.this.mScene, RemittanceBaseUI.this.Crl, RemittanceBaseUI.this.Cpd);
                            if (RemittanceBaseUI.this.mScene == 1) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(12689, 13, 1);
                            } else {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(12689, 4, 1);
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(67953);
                        }
                    });
                }
                this.Crl = aiVar.Crl;
                this.Cpd = aiVar.Cpd;
                if (this.Cpd == 0.0d) {
                    if (this.mScene == 1) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(12689, 14, 1);
                    } else {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(12689, 5, 1);
                    }
                }
            } else if (qVar instanceof aj) {
                this.Cro = ((aj) qVar).lJj;
                this.Crp = ((aj) qVar).HQy;
                this.Crq = ((aj) qVar).HQz;
                eNM();
                eNL();
            }
            return true;
        }
        if (qVar instanceof aj) {
            Log.i("MicroMsg.RemittanceBaseUI", "net error, use hardcode wording");
            this.CqW.setText("");
            this.CqW.setVisibility(8);
        } else if (qVar instanceof w) {
            if (this.mKindaEnable) {
                hideLoading();
            }
            this.Cry = (w) qVar;
            EventCenter.instance.add(this.CrB);
            af.z(this.mPayScene, "", i3);
            if (c((w) qVar)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean a(w wVar) {
        boolean z;
        String str;
        if (!this.CrC) {
            z = d(wVar);
        } else {
            z = false;
        }
        if (!z && !this.CrD) {
            z = e(wVar);
        }
        if (!z && !this.CrE) {
            z = f(wVar);
        }
        if (!z && !this.CrF) {
            z = c(wVar);
        }
        if (z || Util.isNullOrNil(wVar.Cpk) || Util.isNullOrNil(wVar.Cpl)) {
            return z;
        }
        String hs = com.tencent.mm.wallet_core.ui.f.hs(com.tencent.mm.wallet_core.ui.f.getDisplayName(this.goe), 10);
        if (!Util.isNullOrNil(this.qnT)) {
            hs = this.qnT;
        }
        if (!Util.isNullOrNil(this.Crn)) {
            str = getString(R.string.g22, new Object[]{hs, this.Crn});
        } else {
            str = hs;
        }
        return a(wVar.dNQ, wVar.Cpl, str, wVar.Cpk, wVar);
    }

    private static boolean b(w wVar) {
        if (wVar.Cpv == 1 && wVar.Cpw != null) {
            return true;
        }
        if (wVar.Cpw == null || wVar.Cpw.Lko <= 0) {
            return false;
        }
        return true;
    }

    private boolean c(final w wVar) {
        if (wVar.ebb == null || !wVar.ebb.fPZ()) {
            return false;
        }
        this.CrF = true;
        com.tencent.mm.ui.base.h.c(this, wVar.ebb.dQx, "", wVar.ebb.lHB, wVar.ebb.lHA, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(67955);
                Log.i("MicroMsg.RemittanceBaseUI", "goto h5: %s", wVar.ebb.qwt);
                com.tencent.mm.wallet_core.ui.f.p(RemittanceBaseUI.this.getContext(), wVar.ebb.qwt, false);
                AppMethodBeat.o(67955);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass7 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        return true;
    }

    private boolean d(final w wVar) {
        if (Util.isNullOrNil(wVar.CoX)) {
            return false;
        }
        this.CrC = true;
        bX(1, wVar.dQp);
        com.tencent.mm.ui.base.h.c(this, wVar.CoX, getString(R.string.yd), getString(R.string.g28), getString(R.string.sz), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass8 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(67956);
                RemittanceBaseUI.this.bX(3, wVar.dQp);
                if (!RemittanceBaseUI.this.a((RemittanceBaseUI) wVar)) {
                    RemittanceBaseUI.this.showLoading();
                    RemittanceBaseUI.this.a(wVar.dNQ, RemittanceBaseUI.this.goe, RemittanceBaseUI.this.Crn, wVar);
                }
                AppMethodBeat.o(67956);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass9 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(67957);
                RemittanceBaseUI.this.bX(2, wVar.dQp);
                AppMethodBeat.o(67957);
            }
        });
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void bX(int i2, String str) {
        this.Crz = new kx();
        this.Crz.erW = 2;
        this.Crz.ejA = (long) i2;
        this.Crz.yp(str);
        this.Crz.bfK();
    }

    private boolean e(final w wVar) {
        String str;
        String str2;
        if (wVar.CoV <= 0) {
            return false;
        }
        this.CrD = true;
        if (wVar.CoW != null) {
            if (Util.isNullOrNil(wVar.CoW.dQx)) {
                str = getString(R.string.g47, new Object[]{Integer.valueOf(wVar.CoV)});
            } else {
                str = wVar.CoW.dQx;
            }
            String string = getString(R.string.g28);
            if (Util.isNullOrNil(wVar.CoW.Cpx)) {
                str2 = getString(R.string.g3v);
            } else {
                str2 = wVar.CoW.Cpx;
            }
            b(this, str, "", string, str2, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass10 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(67958);
                    if (!RemittanceBaseUI.this.a((RemittanceBaseUI) wVar)) {
                        RemittanceBaseUI.this.showLoading();
                        RemittanceBaseUI.this.a(wVar.dNQ, RemittanceBaseUI.this.goe, RemittanceBaseUI.this.Crn, wVar);
                    }
                    AppMethodBeat.o(67958);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass11 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(67959);
                    if (Util.isNullOrNil(wVar.CoW.Cpy)) {
                        com.tencent.mm.wallet_core.a.b(RemittanceBaseUI.this, "ShowOrdersInfoProcess", null);
                        AppMethodBeat.o(67959);
                        return;
                    }
                    com.tencent.mm.plugin.account.a.b.a.b(RemittanceBaseUI.this, wVar.CoW.Cpy, 5, true);
                    AppMethodBeat.o(67959);
                }
            });
        } else {
            Log.i("MicroMsg.RemittanceBaseUI", "scene.zaituMessage == null");
            b(this, getString(R.string.g47, new Object[]{Integer.valueOf(wVar.CoV)}), getString(R.string.yd), getString(R.string.g28), getString(R.string.g3v), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass13 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(67961);
                    if (!RemittanceBaseUI.this.a((RemittanceBaseUI) wVar)) {
                        RemittanceBaseUI.this.a(wVar.dNQ, RemittanceBaseUI.this.goe, RemittanceBaseUI.this.Crn, wVar);
                    }
                    AppMethodBeat.o(67961);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass14 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(67962);
                    com.tencent.mm.wallet_core.a.b(RemittanceBaseUI.this, "ShowOrdersInfoProcess", null);
                    AppMethodBeat.o(67962);
                }
            });
        }
        return true;
    }

    private static void b(Context context, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        d.a aVar = new d.a(context);
        aVar.bon(str2);
        aVar.boo(str);
        aVar.bou(str3).c(onClickListener);
        aVar.bov(str4).d(onClickListener2);
        aVar.Dk(false);
        aVar.Dl(true);
        d hbn = aVar.hbn();
        hbn.show();
        com.tencent.mm.ui.base.h.a(context, hbn);
    }

    private boolean f(final w wVar) {
        if (!wVar.Cpc) {
            return false;
        }
        this.CrE = true;
        f.a(this, this.mScene, wVar.Cpf / 100.0d, wVar.Cpe / 100.0d, wVar.CoZ / 100.0d, wVar.Cpb, new View.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass15 */

            public final void onClick(View view) {
                AppMethodBeat.i(67963);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                RemittanceBaseUI.this.showLoading();
                RemittanceBaseUI.this.a(wVar.dNQ, RemittanceBaseUI.this.goe, RemittanceBaseUI.this.Crn, wVar);
                if (RemittanceBaseUI.this.mScene == 1) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(12689, 12, 1);
                } else {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(12689, 3, 1);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBaseUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67963);
            }
        });
        return true;
    }

    private static void aMk(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.RemittanceBaseUI", "msgxml is null");
            return;
        }
        String decode = URLDecoder.decode(str);
        Log.i("MicroMsg.RemittanceBaseUI", "helios:".concat(String.valueOf(decode)));
        String str2 = XmlParser.parseXml(decode, "msg", null).get(".msg.appmsg.wcpayinfo.transferid");
        if (TextUtils.isEmpty(str2)) {
            Log.e("MicroMsg.RemittanceBaseUI", "paymsgid count't be null in appmsg");
        } else {
            c.eMU().eMX().jL(str2, decode);
        }
    }

    private boolean eNQ() {
        return this.mScene == 0 || this.mScene == 2;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        boolean z = true;
        boolean z2 = false;
        Log.i("MicroMsg.RemittanceBaseUI", "reqcode=" + i2 + ", resultCode=" + i3 + ", username=" + Util.nullAs(this.goe, BuildConfig.COMMAND) + ", =" + Util.nullAs(this.qnT, BuildConfig.COMMAND));
        switch (i2) {
            case 1:
                if (i3 != -1) {
                    z = false;
                }
                a(z, intent);
                break;
            case 2:
                if (i3 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (Util.isNullOrNil(stringExtra)) {
                        finish();
                        break;
                    } else {
                        this.goe = stringExtra;
                        eNO();
                        break;
                    }
                } else {
                    finish();
                    break;
                }
            case 5:
                if (i3 == -1) {
                    z2 = true;
                }
                a(z2, intent);
                break;
            case 6:
                if (i3 == -1 && intent != null) {
                    hideTenpayKB();
                    com.tencent.mm.plugin.wallet_core.ui.view.a.a(this, getString(R.string.abz), this.mDesc, getString(R.string.g29), false, intent.getStringExtra("userName"), intent.getStringExtra("telNumber"), intent.getStringExtra("proviceFirstStageName") + intent.getStringExtra("addressCitySecondStageName") + intent.getStringExtra("addressCountiesThirdStageName") + intent.getStringExtra("addressDetailInfo"), new a.AbstractC1922a() {
                        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass16 */

                        @Override // com.tencent.mm.plugin.wallet_core.ui.view.a.AbstractC1922a
                        public final boolean a(boolean z, String str, String str2, String str3, String str4) {
                            AppMethodBeat.i(67964);
                            RemittanceBaseUI.this.Crj = z;
                            if (!Util.isNullOrNil(str)) {
                                RemittanceBaseUI.this.mDesc = str;
                            } else {
                                RemittanceBaseUI.this.mDesc = null;
                            }
                            if (!RemittanceBaseUI.this.Crj) {
                                if (!Util.isNullOrNil(str2)) {
                                    RemittanceBaseUI.this.mName = str2;
                                } else {
                                    RemittanceBaseUI.this.mName = null;
                                }
                                if (!Util.isNullOrNil(str3)) {
                                    RemittanceBaseUI.this.APz = str3;
                                } else {
                                    RemittanceBaseUI.this.APz = null;
                                }
                                if (!Util.isNullOrNil(str4)) {
                                    RemittanceBaseUI.this.Cri = str4;
                                } else {
                                    RemittanceBaseUI.this.Cri = null;
                                }
                            }
                            RemittanceBaseUI.c(RemittanceBaseUI.this);
                            RemittanceBaseUI.d(RemittanceBaseUI.this);
                            AppMethodBeat.o(67964);
                            return true;
                        }
                    }, new f.c() {
                        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass17 */

                        @Override // com.tencent.mm.ui.widget.a.f.c
                        public final void e(boolean z, String str) {
                            AppMethodBeat.i(67966);
                            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass17.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(67965);
                                    RemittanceBaseUI.this.hideVKB();
                                    AppMethodBeat.o(67965);
                                }
                            }, 500);
                            AppMethodBeat.o(67966);
                        }
                    });
                    break;
                }
        }
        super.onActivityResult(i2, i3, intent);
    }

    private void a(boolean z, Intent intent) {
        if (z) {
            if (this.Crx) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(15386, 3, 1);
            }
            String stringExtra = intent.getStringExtra("key_trans_id");
            if (Util.isNullOrNil(this.Crw)) {
                this.Crw = stringExtra;
            }
            if (!(this.mPayScene == 33 || this.mPayScene == 32)) {
                ad.aMh(this.goe);
            }
            if (this.Cpd == 0.0d) {
                if (this.mScene == 1) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(12689, 17, 1);
                } else {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(12689, 8, 1);
                }
            }
            finish();
        } else if (ag.bH(intent)) {
            finish();
            return;
        } else if (ag.bI(intent)) {
            return;
        } else {
            if (this.mScene == 1) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(12689, 16, 1);
            } else {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(12689, 7, 1);
            }
        }
        if (Util.isEqual(this.CqQ, 0)) {
            b(z, intent);
        }
    }

    private void a(w wVar, zd zdVar) {
        this.CrA = true;
        new c(this).a(wVar, zdVar, new c.a() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass18 */

            @Override // com.tencent.mm.plugin.remittance.ui.c.a
            public final void aMb(String str) {
                AppMethodBeat.i(67967);
                Log.i("MicroMsg.RemittanceBaseUI", "onDialogClick  %s", str);
                RemittanceBaseUI.this.Cru = str;
                RemittanceBaseUI.this.eNR();
                AppMethodBeat.o(67967);
            }

            @Override // com.tencent.mm.plugin.remittance.ui.c.a
            public final void onCancel() {
                AppMethodBeat.i(213760);
                RemittanceBaseUI.this.Cru = "";
                RemittanceBaseUI.this.showNormalStWcKb();
                AppMethodBeat.o(213760);
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void a(final String str, final String str2, final String str3, final w wVar) {
        String str4;
        Log.i("MicroMsg.RemittanceBaseUI", "startPay mKindaEnable %s reqKey %s", Boolean.valueOf(this.mKindaEnable), str);
        if (!b(wVar)) {
            if (this.CrA) {
                le leVar = new le();
                leVar.eXN = (long) wVar.yRL;
                le yr = leVar.yr(wVar.username);
                yr.eXG = 5;
                yr.bfK();
            }
            this.CrA = false;
            if (this.mPayScene == 31) {
                aMk(this.Crm);
            }
            PayInfo payInfo = new PayInfo();
            payInfo.dDL = str;
            payInfo.dVv = this.mPayScene;
            if (this.mChannel > 0) {
                payInfo.channel = this.mChannel;
            }
            boolean z = false;
            if (this.mScene == 2 || this.mScene == 5) {
                z = true;
            }
            Bundle bundle = new Bundle();
            bundle.putString("extinfo_key_1", str2);
            bundle.putString("extinfo_key_2", getIntent().getStringExtra("receiver_true_name"));
            bundle.putString("extinfo_key_3", this.Crk);
            bundle.putBoolean("extinfo_key_4", z);
            bundle.putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
            bundle.putString("extinfo_key_6", getIntent().getStringExtra("payer_desc"));
            bundle.putString("extinfo_key_7", this.mDesc);
            bundle.putString("extinfo_key_8", getIntent().getStringExtra("rcvr_new_desc"));
            bundle.putString("extinfo_key_16", this.Crw);
            if (wVar != null) {
                bundle.putString("extinfo_key_19", wVar.Cpt);
            }
            int i2 = 0;
            if (this.mScene == 1 && wVar != null) {
                bundle.putString("extinfo_key_11", wVar.Cph);
                bundle.putInt("extinfo_key_12", wVar.Cpn);
                bundle.putString("extinfo_key_13", wVar.Cpo);
                bundle.putString("extinfo_key_14", wVar.Cpp);
                bundle.putString("extinfo_key_17", wVar.Cpr);
                bundle.putString("extinfo_key_18", wVar.Cps);
                i2 = wVar.Cpq;
            }
            if (wVar != null) {
                bundle.putInt("extinfo_key_15", wVar.yRL);
            }
            if (this.CqR) {
                bundle.putBoolean("extinfo_key_23", this.CqR);
                bundle.putString("extinfo_key_24", this.mName);
                bundle.putString("extinfo_key_25", this.APz);
                bundle.putString("extinfo_key_26", this.Cri);
            }
            payInfo.iqp = bundle;
            Intent intent = new Intent();
            Log.i("MicroMsg.RemittanceBaseUI", "dynamic code flag: %s", Integer.valueOf(i2));
            if (i2 == 1) {
                intent.setClass(this, RemittanceF2fDynamicCodeUI.class);
                intent.putExtra("key_pay_info", payInfo);
                intent.putExtra("key_rcvr_open_id", this.Crs);
                intent.putExtra("key_mch_info", this.CqP);
                intent.putExtra("from_patch_ui", true);
                intent.putExtra("get_dynamic_code_sign", wVar.Cpr);
                intent.putExtra("get_dynamic_code_extend", wVar.Cps);
                intent.putExtra("dynamic_code_spam_wording", wVar.Cpu);
                intent.putExtra("show_paying_wording", wVar.Cpt);
                intent.putExtra("key_transfer_qrcode_id", this.CqS);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(15386, 2, 1);
                this.CrH.alive();
                startActivityForResult(intent, 5);
            } else if (this.mKindaEnable) {
                String str5 = "";
                String str6 = "";
                String string = getString(R.string.ip_);
                if (!Util.isNullOrNil(str2)) {
                    g.aAi();
                    as bjJ = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjJ(str2);
                    if (bjJ != null) {
                        String arJ = bjJ.arJ();
                        str4 = com.tencent.mm.wallet_core.ui.f.bpz(arJ) + (Util.isNullOrNil(this.Crn) ? "" : "(" + this.Crn + ")");
                        str5 = Util.safeFormatString(string, str4);
                        str6 = getString(R.string.g4e, new Object[]{com.tencent.mm.wallet_core.ui.f.bpz(arJ)});
                    } else {
                        Log.e("MicroMsg.RemittanceBaseUI", "can not found contact for user::".concat(String.valueOf(str2)));
                        str4 = "";
                    }
                } else {
                    Log.e("MicroMsg.RemittanceBaseUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                    str4 = "";
                }
                if (payInfo.iqp == null) {
                    payInfo.iqp = new Bundle();
                }
                Bundle bundle2 = payInfo.iqp;
                bundle2.putString("extinfo_key_1", str2);
                bundle2.putString("extinfo_key_2", this.Crn);
                bundle2.putString("cashier_desc", str5);
                bundle2.putString("prepay_page_payee", str4);
                bundle2.putString("succ_tip", str6);
                ((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, payInfo);
            } else {
                hideLoading();
                com.tencent.mm.plugin.wallet.a.a(this.CqM, intent);
                if (wVar.CoD == null || wVar.CoD.dKn.dKq == null) {
                    com.tencent.mm.pluginsdk.wallet.f.a(this, false, "", payInfo, str3, intent, 1);
                } else {
                    com.tencent.mm.pluginsdk.wallet.f.a(wVar.CoD.dKn.dKq, false, "", payInfo, str3, intent, wVar.CoD.dKn.mRequestCode);
                }
            }
        } else if (wVar.Cpw.Lko == 0) {
            this.CrG = wVar.Cpw;
            a(wVar, wVar.Cpw);
        } else if (wVar.Cpw.Lko == 1) {
            le leVar2 = new le();
            leVar2.eXN = (long) ((int) wVar.Cpj);
            le yr2 = leVar2.yr(wVar.username);
            yr2.eXG = 4;
            yr2.bfK();
            com.tencent.mm.ui.base.h.a(this, wVar.Cpw.dQx, wVar.Cpw.title, getResources().getString(R.string.g4s), getResources().getString(R.string.g4r), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass19 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(67968);
                    Log.i("MicroMsg.RemittanceBaseUI", "onClick1 realNameCheckMessage %s", RemittanceBaseUI.this.CrG);
                    le leVar = new le();
                    leVar.eXN = (long) ((int) wVar.Cpj);
                    le yr = leVar.yr(wVar.username);
                    yr.eXG = 9;
                    yr.bfK();
                    wVar.Cpw = null;
                    RemittanceBaseUI.this.a(str, str2, str3, wVar);
                    AppMethodBeat.o(67968);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass20 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(67969);
                    Log.i("MicroMsg.RemittanceBaseUI", "onClick1");
                    le leVar = new le();
                    leVar.eXN = (long) ((int) wVar.Cpj);
                    le yr = leVar.yr(wVar.username);
                    yr.eXG = 8;
                    yr.bfK();
                    AppMethodBeat.o(67969);
                }
            }, (int) R.color.a4s);
        } else if (wVar.Cpw.Lko == 2) {
            com.tencent.mm.ui.base.h.a(this, wVar.Cpw.dQx, wVar.Cpw.title, getResources().getString(R.string.j34), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass21 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public final void eNR() {
        aMj(this.mDesc);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void eNS() {
        Intent intent = new Intent();
        intent.putExtra("recent_remittance_contact_list", ad.eNA());
        intent.setClass(getContext(), SelectRemittanceContactUI.class);
        startActivityForResult(intent, 2);
    }

    @Override // com.tencent.mm.aj.e.a
    public void Mr(String str) {
        Log.i("MicroMsg.RemittanceBaseUI", "onGet");
        if (Util.nullAsNil(str).length() <= 0) {
            Log.e("MicroMsg.RemittanceBaseUI", "notifyChanged: user = ".concat(String.valueOf(str)));
        } else if (str.equals(this.goe)) {
            eNP();
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean needLockPage() {
        if (this.mPayScene == 33 || this.mPayScene == 32) {
            return true;
        }
        return false;
    }

    private boolean a(final String str, String str2, String str3, String str4, final w wVar) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.bn2, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.h9n);
        ((TextView) inflate.findViewById(R.id.h9o)).setText(str2);
        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, str3, textView.getTextSize()));
        ((TextView) inflate.findViewById(R.id.h9m)).setText(String.format("%s%.2f", ah.hhz(), Double.valueOf(Double.valueOf(Util.getDouble(str4, 0.0d)).doubleValue() / 100.0d)));
        d.a aVar = new d.a(this);
        aVar.Dk(false);
        aVar.aoO(R.string.g4j);
        aVar.hs(inflate);
        aVar.aoV(R.string.g28);
        aVar.aoW(R.string.amc);
        aVar.d(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass24 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(67978);
                RemittanceBaseUI.this.showNormalStWcKb();
                AppMethodBeat.o(67978);
            }
        });
        aVar.c(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.AnonymousClass25 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(213761);
                RemittanceBaseUI.this.showLoading();
                RemittanceBaseUI.this.a(str, RemittanceBaseUI.this.goe, RemittanceBaseUI.this.Crn, wVar);
                AppMethodBeat.o(213761);
            }
        });
        aVar.hbn().show();
        return true;
    }

    private void b(boolean z, Intent intent) {
        if (z) {
            this.dYe = 1;
        } else if (intent != null) {
            this.dYe = intent.getIntExtra("key_pay_reslut_type", 3);
            this.CrI = this.jVp;
            this.CrJ = this.mDesc;
            this.CrK = this.Cri;
            this.CrL = this.Crw;
        } else {
            return;
        }
        Log.i("MicroMsg.RemittanceBaseUI", "savePayInfoInReRemittanceUI() mLastPayResult:%s mlastTotalFee:%s mLastDesc:%s mLastAddress:%s mLastTransferId:%s", Integer.valueOf(this.dYe), Double.valueOf(this.CrI), this.CrJ, this.CrK, this.CrL);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        String Cph;
        String Cpi;
        String Cpm;
        long CrW;
        String dDM;
        String dQp;
        String qvD;
        String qya;
        int yRL;

        a(String str, String str2, String str3, String str4, int i2, String str5, String str6, String str7, long j2) {
            this.Cph = str;
            this.qvD = str2;
            this.qya = str3;
            this.Cpi = str4;
            this.yRL = i2;
            this.dQp = str5;
            this.dDM = str6;
            this.Cpm = str7;
            this.CrW = j2;
        }
    }
}
