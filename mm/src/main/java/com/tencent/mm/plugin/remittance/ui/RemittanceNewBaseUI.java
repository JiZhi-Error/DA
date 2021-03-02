package com.tencent.mm.plugin.remittance.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import com.tencent.mm.plugin.wallet_core.c.aj;
import com.tencent.mm.plugin.wallet_core.ui.view.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.zd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@com.tencent.mm.ui.base.a(2)
public abstract class RemittanceNewBaseUI extends WalletBaseUI implements e.a, WcPayKeyboard.a {
    protected String APz;
    protected int Cnv = 4;
    private double Cpd;
    protected com.tencent.mm.plugin.wallet.a CqM = null;
    protected String CqN;
    protected String CqP;
    private int CqQ = -1;
    protected boolean CqR = false;
    protected String CqS;
    protected ImageView CqT;
    protected TextView CqU;
    protected TextView CqV;
    protected TextView CqX;
    protected TextView CqY;
    private TextView CqZ;
    private boolean CrA = false;
    private IListener CrB = new IListener<zs>() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass9 */

        {
            AppMethodBeat.i(160848);
            this.__eventId = zs.class.getName().hashCode();
            AppMethodBeat.o(160848);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zs zsVar) {
            AppMethodBeat.i(68221);
            if (Util.isEqual(RemittanceNewBaseUI.this.Cry.getUri(), zsVar.efL.uri) && Util.isEqual(RemittanceNewBaseUI.this.Cry.yXM, 1)) {
                RemittanceNewBaseUI.this.finish();
            }
            AppMethodBeat.o(68221);
            return false;
        }
    };
    private boolean CrC = false;
    private boolean CrD = false;
    private boolean CrE = false;
    private boolean CrF = false;
    private zd CrG = null;
    private IListener CrH = new IListener<gl>() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass27 */

        {
            AppMethodBeat.i(160849);
            this.__eventId = gl.class.getName().hashCode();
            AppMethodBeat.o(160849);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(gl glVar) {
            AppMethodBeat.i(68238);
            gl glVar2 = glVar;
            if (glVar2.dKn.dKp == 1) {
                h.INSTANCE.a(15386, 4, 1);
            } else {
                h.INSTANCE.a(15386, 5, 1);
            }
            String str = glVar2.dKn.dKo;
            Log.i("MicroMsg.RemittanceNewBaseUI", "receive dynamic req: %s, %s", Integer.valueOf(glVar2.dKn.dKp), str);
            if (RemittanceNewBaseUI.this.mPayScene == 33) {
                RemittanceNewBaseUI.this.a(RemittanceNewBaseUI.this.mDesc, RemittanceNewBaseUI.this.CqQ, RemittanceNewBaseUI.this.mName, RemittanceNewBaseUI.this.APz, RemittanceNewBaseUI.this.Cri, RemittanceNewBaseUI.this.Crk, str, glVar2);
            } else {
                RemittanceNewBaseUI.this.a(RemittanceNewBaseUI.this.mDesc, RemittanceNewBaseUI.this.CqQ, RemittanceNewBaseUI.this.mName, RemittanceNewBaseUI.this.APz, RemittanceNewBaseUI.this.Cri, null, str, glVar2);
            }
            AppMethodBeat.o(68238);
            return false;
        }
    };
    protected double CrI = 0.0d;
    protected String CrJ = "";
    protected String CrK = "";
    protected String CrL = "";
    private IListener<gn> CrM = new IListener<gn>() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass30 */

        {
            AppMethodBeat.i(213829);
            this.__eventId = gn.class.getName().hashCode();
            AppMethodBeat.o(213829);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(gn gnVar) {
            boolean z = true;
            AppMethodBeat.i(213830);
            gn gnVar2 = gnVar;
            String str = gnVar2.dKu.dDL;
            RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, str, gnVar2.dKu.dDM);
            if (gnVar2.dKu.isKinda) {
                Log.f("MicroMsg.RemittanceNewBaseUI", "F2fPayCheckEvent is from kinda");
                RemittanceNewBaseUI.this.CtP = false;
                MMHandlerThread.postToMainThreadDelayed(RemittanceNewBaseUI.this.jVx, 300);
                if (gnVar2.dKu.dDN == 1) {
                    RemittanceNewBaseUI.a(RemittanceNewBaseUI.this, str, gnVar2.dKu.dDM);
                    if (gnVar2.dKu.dKv == RemittanceNewBaseUI.this.getContext().hashCode()) {
                        c.eMU().eMX().jM(RemittanceNewBaseUI.this.Crw, RemittanceNewBaseUI.this.goe);
                    } else {
                        Log.w("MicroMsg.RemittanceNewBaseUI", "callback to wrong page: %s, %s", Integer.valueOf(gnVar2.dKu.dKv), Integer.valueOf(RemittanceNewBaseUI.this.getContext().hashCode()));
                    }
                } else if (gnVar2.dKu.dDN == 2) {
                    if (!(RemittanceNewBaseUI.this.mScene == 2 || RemittanceNewBaseUI.this.mScene == 5)) {
                        z = false;
                    }
                    if (Util.isNullOrNil(RemittanceNewBaseUI.this.goe) || z) {
                        RemittanceNewBaseUI.this.finish();
                    } else {
                        Intent intent = new Intent();
                        intent.putExtra("Chat_User", RemittanceNewBaseUI.this.goe);
                        intent.putExtra("finish_direct", false);
                        com.tencent.mm.br.c.f(RemittanceNewBaseUI.this, ".ui.chatting.ChattingUI", intent);
                    }
                }
                AppMethodBeat.o(213830);
            } else {
                AppMethodBeat.o(213830);
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
    protected boolean CtP = false;
    private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 270);
    private String dRM;
    protected int dYe = 0;
    protected String goe;
    private int jVe;
    protected ScrollView jVf;
    private WcPayKeyboard jVg;
    private RelativeLayout jVk;
    private TextView jVl;
    private RelativeLayout jVm;
    protected double jVp;
    private Runnable jVx = new Runnable() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(68214);
            if (RemittanceNewBaseUI.this.state == 2 && RemittanceNewBaseUI.this.isHandleAutoShowNormalStWcKb()) {
                RemittanceNewBaseUI.this.showNormalStWcKb();
            }
            AppMethodBeat.o(68214);
        }
    };
    private int mChannel;
    protected String mDesc;
    protected String mName;
    protected int mPayScene;
    protected int mScene;
    protected WalletFormView qAh;
    private g qAx;
    protected String qnT;
    private int state = 0;

    public abstract void a(String str, int i2, String str2, String str3, String str4, String str5, String str6, gl glVar);

    public abstract void eNK();

    public abstract void eNN();

    public abstract void eOj();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    /* renamed from: onWindowFocusChanged  reason: collision with other method in class */
    public void m26onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(RemittanceNewBaseUI remittanceNewBaseUI, String str, String str2) {
        a aVar = remittanceNewBaseUI.Crv.get(str);
        Log.d("MicroMsg.RemittanceNewBaseUI", "match reqKey: %s, %d", str, Integer.valueOf(remittanceNewBaseUI.Crv.size()));
        if (aVar == null) {
            Log.i("MicroMsg.RemittanceNewBaseUI", "no data for: %s", str);
        } else {
            Log.i("MicroMsg.RemittanceNewBaseUI", "pay check: %d", Integer.valueOf(remittanceNewBaseUI.mPayScene));
            if (Util.isNullOrNil(aVar.dDM)) {
                aVar.dDM = str2;
            }
            if (Util.isNullOrNil(aVar.qvD)) {
                aVar.qvD = str2;
            }
            if (remittanceNewBaseUI.mPayScene == 31) {
                com.tencent.mm.kernel.g.azz().a(new t(str, aVar.dQp, aVar.dDM, aVar.Cpm, aVar.CrW, aVar.qya), 0);
            } else {
                com.tencent.mm.kernel.g.azz().a(new o(aVar.Cph, aVar.qvD, aVar.qya, aVar.Cpi, aVar.yRL), 0);
            }
        }
        remittanceNewBaseUI.Crv.clear();
    }

    static /* synthetic */ void k(RemittanceNewBaseUI remittanceNewBaseUI) {
        String str;
        String str2;
        remittanceNewBaseUI.showCircleStWcKb();
        h.INSTANCE.a(12689, 9, 1);
        if (remittanceNewBaseUI.mScene == 1 || remittanceNewBaseUI.mScene == 6) {
            String string = remittanceNewBaseUI.getString(R.string.g1i);
            String string2 = remittanceNewBaseUI.getString(R.string.g29);
            h.INSTANCE.a(14074, 1);
            str = string2;
            str2 = string;
        } else {
            String string3 = remittanceNewBaseUI.getString(R.string.g1h);
            String string4 = remittanceNewBaseUI.getString(R.string.g1o);
            if (!Util.isEqual(remittanceNewBaseUI.CqQ, 0) || !remittanceNewBaseUI.CqR) {
                str = string4;
                str2 = string3;
            } else {
                com.tencent.mm.plugin.wallet_core.ui.view.a.a(remittanceNewBaseUI, string3, remittanceNewBaseUI.mDesc, string4, remittanceNewBaseUI.Crj, remittanceNewBaseUI.mName, remittanceNewBaseUI.APz, remittanceNewBaseUI.Cri, true, new a.AbstractC1922a() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass32 */

                    @Override // com.tencent.mm.plugin.wallet_core.ui.view.a.AbstractC1922a
                    public final boolean a(boolean z, String str, String str2, String str3, String str4) {
                        AppMethodBeat.i(213832);
                        RemittanceNewBaseUI.this.Crj = z;
                        if (!Util.isNullOrNil(str)) {
                            RemittanceNewBaseUI.this.mDesc = str;
                        } else {
                            RemittanceNewBaseUI.this.mDesc = null;
                        }
                        if (!RemittanceNewBaseUI.this.Crj) {
                            if (!Util.isNullOrNil(str2)) {
                                RemittanceNewBaseUI.this.mName = str2;
                            } else {
                                RemittanceNewBaseUI.this.mName = null;
                            }
                            if (!Util.isNullOrNil(str3)) {
                                RemittanceNewBaseUI.this.APz = str3;
                            } else {
                                RemittanceNewBaseUI.this.APz = null;
                            }
                            if (!Util.isNullOrNil(str4)) {
                                RemittanceNewBaseUI.this.Cri = str4;
                            } else {
                                RemittanceNewBaseUI.this.Cri = null;
                            }
                        } else {
                            RemittanceNewBaseUI.this.mName = null;
                            RemittanceNewBaseUI.this.APz = null;
                            RemittanceNewBaseUI.this.Cri = null;
                        }
                        RemittanceNewBaseUI.q(RemittanceNewBaseUI.this);
                        RemittanceNewBaseUI.r(RemittanceNewBaseUI.this);
                        AppMethodBeat.o(213832);
                        return true;
                    }
                }, new f.c() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass33 */

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                        AppMethodBeat.i(213834);
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass33.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(213833);
                                RemittanceNewBaseUI.this.hideVKB();
                                AppMethodBeat.o(213833);
                            }
                        }, 500);
                        AppMethodBeat.o(213834);
                    }
                });
                return;
            }
        }
        com.tencent.mm.plugin.wallet_core.ui.view.a.a(remittanceNewBaseUI, str2, remittanceNewBaseUI.mDesc, str, true, 20, new h.b() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass35 */

            @Override // com.tencent.mm.ui.base.h.b
            public final boolean onFinish(CharSequence charSequence) {
                AppMethodBeat.i(213835);
                if (!Util.isNullOrNil(charSequence.toString())) {
                    RemittanceNewBaseUI.this.mDesc = charSequence.toString();
                    RemittanceNewBaseUI.r(RemittanceNewBaseUI.this);
                } else {
                    RemittanceNewBaseUI.this.mDesc = null;
                    RemittanceNewBaseUI.r(RemittanceNewBaseUI.this);
                }
                AppMethodBeat.o(213835);
                return true;
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass36 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(213837);
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass36.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(213836);
                        RemittanceNewBaseUI.this.hideVKB();
                        AppMethodBeat.o(213836);
                    }
                }, 500);
                AppMethodBeat.o(213837);
            }
        });
    }

    static /* synthetic */ void q(RemittanceNewBaseUI remittanceNewBaseUI) {
        if (remittanceNewBaseUI.mPayScene != 33 && remittanceNewBaseUI.mPayScene != 32) {
            if (!Util.isEqual(remittanceNewBaseUI.CqQ, 0) || Util.isNullOrNil(remittanceNewBaseUI.mName)) {
                remittanceNewBaseUI.Cre.setVisibility(8);
                return;
            }
            remittanceNewBaseUI.Cre.setVisibility(0);
            remittanceNewBaseUI.Crf.setText(remittanceNewBaseUI.mName + "  " + remittanceNewBaseUI.APz);
            remittanceNewBaseUI.Crg.setText(remittanceNewBaseUI.Cri);
        }
    }

    static /* synthetic */ void r(RemittanceNewBaseUI remittanceNewBaseUI) {
        if (Util.isNullOrNil(remittanceNewBaseUI.mDesc)) {
            remittanceNewBaseUI.CqX.setVisibility(8);
            if (remittanceNewBaseUI.mScene == 1) {
                remittanceNewBaseUI.aMn(remittanceNewBaseUI.getString(R.string.g1i));
            } else {
                remittanceNewBaseUI.aMn(remittanceNewBaseUI.getString(R.string.g1h));
            }
            remittanceNewBaseUI.CqY.setVisibility(0);
            return;
        }
        String string = remittanceNewBaseUI.getString(R.string.g3a);
        SpannableString c2 = l.c(remittanceNewBaseUI, remittanceNewBaseUI.getString(R.string.b6m, new Object[]{remittanceNewBaseUI.mDesc, string}));
        com.tencent.mm.wallet_core.ui.f.a(remittanceNewBaseUI.CqX, c2.toString(), c2.length() - string.length(), c2.length(), new com.tencent.mm.wallet_core.ui.e(new e.a() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass2 */

            @Override // com.tencent.mm.wallet_core.ui.e.a
            public final void bmr() {
                AppMethodBeat.i(213823);
                RemittanceNewBaseUI.k(RemittanceNewBaseUI.this);
                AppMethodBeat.o(213823);
            }
        }), remittanceNewBaseUI.getContext());
        remittanceNewBaseUI.CqY.setVisibility(8);
        remittanceNewBaseUI.CqX.setVisibility(0);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
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
        if (this instanceof RemittanceUI) {
            this.CqQ = 0;
        }
        super.onCreate(bundle);
        this.CqM = com.tencent.mm.plugin.wallet.a.be(getIntent());
        this.CqS = getIntent().getStringExtra("scan_remittance_id");
        this.jVp = getIntent().getDoubleExtra("fee", 0.0d);
        this.goe = getIntent().getStringExtra("receiver_name");
        this.qnT = getIntent().getStringExtra("receiver_nick_name");
        this.Crn = getIntent().getStringExtra("receiver_true_name");
        this.CqN = getIntent().getStringExtra("mch_name");
        this.CqP = getIntent().getStringExtra("mch_info");
        this.mChannel = getIntent().getIntExtra("pay_channel", 0);
        this.Crs = Util.nullAs(getIntent().getStringExtra("rcvr_open_id"), "");
        Log.i("MicroMsg.RemittanceNewBaseUI", "mUserName %s", this.goe);
        com.tencent.mm.kernel.g.aAi();
        long longValue = ((Long) com.tencent.mm.kernel.g.aAh().azQ().get(147457, (Object) 0L)).longValue();
        if ((16 & longValue) != 0) {
            this.Crr = 1;
        } else if ((longValue & 32) != 0) {
            this.Crr = 2;
        } else {
            this.Crr = 0;
        }
        eOj();
        p.aYn().a(this);
        initView();
        this.CrM.alive();
        com.tencent.mm.wallet_core.b.hgC();
        this.mKindaEnable = com.tencent.mm.wallet_core.b.b(b.a.clicfg_kinda_open, true);
        this.state = 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        super.onResume();
        Log.i("MicroMsg.RemittanceNewBaseUI", "onResume()");
        if (this.state == 3 && isHandleAutoShowNormalStWcKb()) {
            showNormalStWcKb();
        }
        this.state = 2;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        super.onPause();
        Log.i("MicroMsg.RemittanceNewBaseUI", "onPause()");
        if (!this.jVg.hgQ()) {
            this.state = 3;
        }
    }

    @Override // com.tencent.mm.ui.widget.a.c, com.tencent.mm.ui.MMActivity
    public void onDialogDismiss(Dialog dialog) {
        Log.i("MicroMsg.RemittanceNewBaseUI", "onDialogDismiss()");
        MMHandlerThread.postToMainThreadDelayed(this.jVx, 300);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean isHandleAutoShowNormalStWcKb() {
        if (this.mKindaEnable) {
            return !this.CtP && this.jVg.hgR();
        }
        return this.jVg.hgR();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        super.onDestroy();
        Log.i("MicroMsg.RemittanceNewBaseUI", "onDestroy()");
        MMHandlerThread.removeRunnable(this.jVx);
        EventCenter.instance.removeListener(this.CrB);
        p.aYn().b(this);
        this.CrM.dead();
        this.CrH.dead();
        com.tencent.mm.plugin.wallet.pay.a.b.aUV(this.dRM);
    }

    @Override // com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a
    public final void bO(float f2) {
    }

    public final void eNI() {
        u uVar = new u(this.goe, this.CqS);
        uVar.setProcessName("RemittanceProcess");
        doSceneProgress(uVar);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        hideActionbarLine();
        if (this.mPayScene == 33 || this.mPayScene == 32) {
            setMMTitle(R.string.g1y);
        } else {
            setMMTitle(R.string.g4o);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass12 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(68223);
                if (RemittanceNewBaseUI.this.mScene == 1 || RemittanceNewBaseUI.this.mScene == 6) {
                    RemittanceNewBaseUI.this.eNI();
                    RemittanceNewBaseUI.this.finish();
                } else if (RemittanceNewBaseUI.this.mScene == 2 || RemittanceNewBaseUI.this.mScene == 5) {
                    RemittanceNewBaseUI.this.finish();
                } else {
                    RemittanceNewBaseUI.this.eNS();
                }
                AppMethodBeat.o(68223);
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
        this.Cre = (LinearLayout) findViewById(R.id.h0d);
        this.Crf = (TextView) findViewById(R.id.fth);
        this.Crg = (TextView) findViewById(R.id.ha);
        eNO();
        this.qAh = (WalletFormView) findViewById(R.id.fjf);
        if (this.mPayScene == 33) {
            this.Cra.setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(this.jVp));
            this.Crb.setText(ah.hhz());
            this.Crk = getIntent().getStringExtra("desc");
            if (!Util.isNullOrNil(this.Crk)) {
                this.CqZ.setText(l.b(getContext(), this.Crk, this.CqZ.getTextSize()));
                this.CqZ.setVisibility(0);
            } else {
                this.CqZ.setVisibility(8);
            }
            this.Crc.setVisibility(0);
            this.Crd.setVisibility(8);
        } else {
            this.qAh.getTitleTv().setText(String.format(getString(R.string.g3d), "¥"));
            this.qAh.a(new TextWatcher() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass6 */

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void afterTextChanged(Editable editable) {
                    AppMethodBeat.i(68219);
                    double d2 = Util.getDouble(editable.toString(), 0.0d);
                    if (!RemittanceNewBaseUI.this.qAh.bql() || d2 < 0.01d) {
                        RemittanceNewBaseUI.this.gf(false);
                        AppMethodBeat.o(68219);
                        return;
                    }
                    RemittanceNewBaseUI.this.gf(true);
                    AppMethodBeat.o(68219);
                }
            });
            this.qAh.hib();
            this.jVg = (WcPayKeyboard) findViewById(R.id.joy);
            gf(false);
            setWPKeyboard(this.qAh.getContentEt(), true, false);
            this.qAh.post(new Runnable() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(68220);
                    RemittanceNewBaseUI.this.qAh.getContentEt().requestFocus();
                    AppMethodBeat.o(68220);
                }
            });
            setWcKbHeightListener(this);
            this.jVg.setActionText(getString(R.string.g3u));
            ((RelativeLayout.LayoutParams) this.jVg.getLayoutParams()).addRule(12);
            findViewById(R.id.gc4);
            findViewById(R.id.h2a).setVisibility(0);
            this.Crc.setVisibility(8);
            this.Crd.setVisibility(0);
            setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass8 */

                @Override // com.tencent.mm.wallet_core.ui.a
                public final void onVisibleStateChange(boolean z) {
                }
            });
        }
        ImageView imageView = (ImageView) findViewById(R.id.jfy);
        if (ao.isDarkMode()) {
            findViewById(R.id.jg3).setVisibility(8);
            findViewById(R.id.jg0).setVisibility(0);
            imageView.setBackgroundResource(R.drawable.crl);
        } else {
            findViewById(R.id.jg3).setVisibility(0);
            findViewById(R.id.jg0).setVisibility(8);
            imageView.setBackgroundResource(R.drawable.crk);
        }
        final AnonymousClass23 r0 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass23 */

            public final void onClick(View view) {
                AppMethodBeat.i(68235);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (RemittanceNewBaseUI.this.mPayScene == 33) {
                    RemittanceNewBaseUI.this.a(RemittanceNewBaseUI.this.mDesc, RemittanceNewBaseUI.this.CqQ, RemittanceNewBaseUI.this.mName, RemittanceNewBaseUI.this.APz, RemittanceNewBaseUI.this.Cri, RemittanceNewBaseUI.this.Crk, "", null);
                } else {
                    RemittanceNewBaseUI.this.jVp = Util.getDouble(RemittanceNewBaseUI.this.qAh.getText(), 0.0d);
                    if (!RemittanceNewBaseUI.this.qAh.bql()) {
                        com.tencent.mm.ui.base.u.makeText(RemittanceNewBaseUI.this.getContext(), (int) R.string.i7f, 0).show();
                    } else if (RemittanceNewBaseUI.this.jVp < 0.01d) {
                        RemittanceNewBaseUI.this.eNK();
                    } else {
                        RemittanceNewBaseUI.this.hideWcKb();
                        RemittanceNewBaseUI.this.a(RemittanceNewBaseUI.this.mDesc, RemittanceNewBaseUI.this.CqQ, RemittanceNewBaseUI.this.mName, RemittanceNewBaseUI.this.APz, RemittanceNewBaseUI.this.Cri, null, "", null);
                    }
                }
                if (RemittanceNewBaseUI.this.Cpd == 0.0d) {
                    if (RemittanceNewBaseUI.this.mScene == 1) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(12689, 15, 1);
                    } else {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(12689, 6, 1);
                    }
                }
                if (RemittanceNewBaseUI.this.mScene == 1 && !Util.isNullOrNil(RemittanceNewBaseUI.this.mDesc)) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14074, 2);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68235);
            }
        };
        this.qAh.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass34 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(68241);
                if (keyEvent != null && keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 66) {
                    Log.i("MicroMsg.RemittanceNewBaseUI", "click enter");
                    r0.onClick(null);
                    AppMethodBeat.o(68241);
                } else {
                    AppMethodBeat.o(68241);
                }
                return true;
            }
        });
        this.qAh.setmContentAbnormalMoneyCheck(true);
        this.CqX = (TextView) findViewById(R.id.h13);
        this.CqY = (TextView) findViewById(R.id.gw);
        if (this.mScene == 1 || this.mScene == 6) {
            aMn(getString(R.string.g1i));
        } else {
            aMn(getString(R.string.g1h));
        }
        if (!z.aUo() && Util.isEqual(this.CqQ, 0)) {
            this.jVm = (RelativeLayout) findViewById(R.id.jfz);
            if (LocaleUtil.getApplicationLanguage().equals(LocaleUtil.CHINA) || LocaleUtil.getApplicationLanguage().equals(LocaleUtil.TAIWAN) || LocaleUtil.getApplicationLanguage().equals(LocaleUtil.HONGKONG)) {
                this.jVk = (RelativeLayout) findViewById(R.id.jg1);
                this.jVl = (TextView) findViewById(R.id.jg4);
                this.jVk.post(new Runnable() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass37 */

                    public final void run() {
                        AppMethodBeat.i(213838);
                        RemittanceNewBaseUI.this.jVe = RemittanceNewBaseUI.this.jVk.getWidth();
                        RemittanceNewBaseUI.this.jVm.setVisibility(8);
                        Log.d("MicroMsg.RemittanceNewBaseUI", "post: mMaxUnitWidth:%s", Integer.valueOf(RemittanceNewBaseUI.this.jVe));
                        AppMethodBeat.o(213838);
                    }
                });
                this.qAh.setmWalletFormViewListener(new WalletFormView.c() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass38 */

                    @Override // com.tencent.mm.wallet_core.ui.formview.WalletFormView.c
                    public final void p(CharSequence charSequence) {
                        AppMethodBeat.i(213839);
                        if (Util.isEqual(RemittanceNewBaseUI.this.Cnv, 0)) {
                            Log.i("MicroMsg.RemittanceNewBaseUI", "mAmountRemindBit == 0");
                            RemittanceNewBaseUI.this.jVm.setVisibility(8);
                            AppMethodBeat.o(213839);
                            return;
                        }
                        long longValue = Double.valueOf(Util.getDouble(charSequence.toString(), 0.0d)).longValue();
                        int i2 = 0;
                        int i3 = 0;
                        while (longValue != 0) {
                            i2 = (int) (longValue % 10);
                            longValue /= 10;
                            i3++;
                        }
                        if (i3 >= RemittanceNewBaseUI.this.Cnv) {
                            int k = RemittanceNewBaseUI.this.qAh.k(charSequence, RemittanceNewBaseUI.this.jVe, i2);
                            if (k != 0) {
                                RemittanceNewBaseUI.this.jVm.setVisibility(0);
                                RemittanceNewBaseUI.this.jVl.setText(ag.aR(MMApplicationContext.getContext(), i3));
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) RemittanceNewBaseUI.this.jVk.getLayoutParams();
                                layoutParams.leftMargin = k;
                                RemittanceNewBaseUI.this.jVk.setLayoutParams(layoutParams);
                                AppMethodBeat.o(213839);
                                return;
                            }
                            RemittanceNewBaseUI.this.jVm.setVisibility(8);
                            AppMethodBeat.o(213839);
                            return;
                        }
                        RemittanceNewBaseUI.this.jVm.setVisibility(8);
                        AppMethodBeat.o(213839);
                    }
                });
            } else {
                this.jVm.setVisibility(8);
            }
        }
        if (this.mScene == 1) {
            com.tencent.mm.kernel.g.aAi();
            if (((String) com.tencent.mm.kernel.g.aAh().azQ().get(327732, AppEventsConstants.EVENT_PARAM_VALUE_NO)).equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                com.tencent.mm.ui.base.h.a(getContext(), (int) R.string.g3g, (int) R.string.g3h, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass39 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAh().azQ().set(327732, "1");
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAh().azQ().gBI();
            }
        }
        this.Crh = (LinearLayout) findViewById(R.id.h2a);
        eNM();
        eNN();
        eNL();
        if (this.mPayScene != 33 && this.mPayScene != 32) {
            this.jVf.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass40 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(213840);
                    if (!RemittanceNewBaseUI.this.mWcKeyboard.isShown() || !RemittanceNewBaseUI.this.mWcKeyboard.hgP()) {
                        AppMethodBeat.o(213840);
                        return false;
                    }
                    RemittanceNewBaseUI.this.mWcKeyboard.hgN();
                    AppMethodBeat.o(213840);
                    return true;
                }
            });
        }
    }

    private void eNL() {
        if (!eNQ() || Util.isNullOrNil(this.Crp) || this.Crr == 0 || this.Crq != 1) {
            removeAllOptionMenu();
        } else {
            addIconOptionMenu(0, R.drawable.crt, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass41 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(213841);
                    com.tencent.mm.wallet_core.ui.f.p(RemittanceNewBaseUI.this.getContext(), RemittanceNewBaseUI.this.Crp, false);
                    AppMethodBeat.o(213841);
                    return false;
                }
            });
        }
    }

    private void eNM() {
        int i2;
        if (Util.isNullOrNil(this.Cro) || this.Crr == 0) {
            this.jVg.fEW();
            return;
        }
        if (this.Crr == 1) {
            i2 = 2;
        } else {
            i2 = 24;
        }
        try {
            this.jVg.setTipText(String.format(this.Cro, Integer.valueOf(i2)));
        } catch (Exception e2) {
            Log.i("MicroMsg.RemittanceNewBaseUI", "updatePlaceHolderTv() Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            this.jVg.setTipText(getString(R.string.g3m, new Object[]{Integer.valueOf(i2)}));
        }
    }

    /* access modifiers changed from: protected */
    public final void eNO() {
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
            this.CqV.setText(l.b(this, string, this.CqV.getTextSize()));
            hs = stringExtra;
        } else if (this.mScene == 6) {
            String stringExtra2 = getIntent().getStringExtra("receiver_tips");
            if (Util.isNullOrNil(stringExtra2)) {
                hs = getString(R.string.g23, new Object[]{hs});
            } else {
                hs = Util.safeFormatString(stringExtra2, hs);
            }
        }
        this.CqU.setText(l.b(this, hs, this.CqU.getTextSize()));
        if (!com.tencent.mm.kernel.g.aAc() || (aYB = p.aYB()) == null || Util.isNullOrNil(this.goe) || ((Mx = aYB.Mx(this.goe)) != null && !Util.isNullOrNil(Mx.aYu()))) {
            z = false;
        } else {
            final long nowMilliSecond = Util.nowMilliSecond();
            ay.a.iDq.a(this.goe, "", new ay.b.a() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass3 */

                @Override // com.tencent.mm.model.ay.b.a
                public final void p(String str, boolean z) {
                    AppMethodBeat.i(68216);
                    if (z) {
                        Log.v("MicroMsg.RemittanceNewBaseUI", "getContact suc; cost=" + (Util.nowMilliSecond() - nowMilliSecond) + " ms");
                        com.tencent.mm.aj.c.ap(str, 3);
                    } else {
                        Log.w("MicroMsg.RemittanceNewBaseUI", "getContact failed");
                    }
                    RemittanceNewBaseUI.this.eNP();
                    AppMethodBeat.o(68216);
                }
            });
            z = true;
        }
        if (!z) {
            eNP();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void eNP() {
        final AnonymousClass4 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(68217);
                Bitmap a2 = com.tencent.mm.aj.c.a(RemittanceNewBaseUI.this.goe, false, -1, null);
                if (a2 == null) {
                    RemittanceNewBaseUI.this.CqT.setImageResource(R.drawable.bca);
                    AppMethodBeat.o(68217);
                    return;
                }
                RemittanceNewBaseUI.this.CqT.setImageBitmap(a2);
                AppMethodBeat.o(68217);
            }
        };
        if (MMHandlerThread.isMainThread()) {
            r0.run();
        } else {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(68218);
                    r0.run();
                    AppMethodBeat.o(68218);
                }
            });
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (this.jVg == null || !this.jVg.onKeyUp(i2, keyEvent)) {
            return super.onKeyUp(i2, keyEvent);
        }
        return true;
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
            Log.i("MicroMsg.RemittanceNewBaseUI", "net error, use hardcode wording");
            this.mWcKeyboard.fEW();
        } else if (qVar instanceof w) {
            if (this.mKindaEnable) {
                hideLoading();
            }
            this.Cry = (w) qVar;
            EventCenter.instance.addListener(this.CrB);
            af.z(this.mPayScene, "", i3);
            if (c((w) qVar)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void gf(boolean z) {
        this.jVg.DH(z);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean a(w wVar) {
        boolean z;
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
        if (!Util.isNullOrNil(this.Crn)) {
            hs = getString(R.string.g22, new Object[]{hs, this.Crn});
        }
        return a(wVar.dNQ, wVar.Cpl, hs, wVar.Cpk, wVar);
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
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass10 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(68222);
                Log.i("MicroMsg.RemittanceNewBaseUI", "goto h5: %s", wVar.ebb.qwt);
                com.tencent.mm.wallet_core.ui.f.p(RemittanceNewBaseUI.this.getContext(), wVar.ebb.qwt, false);
                AppMethodBeat.o(68222);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass11 */

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
        com.tencent.mm.ui.base.h.c(this, wVar.CoX, "", getString(R.string.g28), getString(R.string.g3_), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass13 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(68224);
                RemittanceNewBaseUI.this.bX(3, wVar.dQp);
                if (!RemittanceNewBaseUI.this.a((RemittanceNewBaseUI) wVar)) {
                    RemittanceNewBaseUI.this.showLoading();
                    RemittanceNewBaseUI.this.a(wVar.dNQ, RemittanceNewBaseUI.this.goe, RemittanceNewBaseUI.this.Crn, wVar);
                }
                AppMethodBeat.o(68224);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass14 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(68225);
                RemittanceNewBaseUI.this.bX(2, wVar.dQp);
                if (RemittanceNewBaseUI.this.mScene == 1 || RemittanceNewBaseUI.this.mScene == 6) {
                    RemittanceNewBaseUI.this.eNI();
                    RemittanceNewBaseUI.this.finish();
                    AppMethodBeat.o(68225);
                } else if (RemittanceNewBaseUI.this.mScene == 2 || RemittanceNewBaseUI.this.mScene == 5) {
                    RemittanceNewBaseUI.this.finish();
                    AppMethodBeat.o(68225);
                } else {
                    RemittanceNewBaseUI.this.eNS();
                    AppMethodBeat.o(68225);
                }
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
            String string = getString(R.string.g4j);
            String string2 = getString(R.string.g28);
            if (Util.isNullOrNil(wVar.CoW.Cpx)) {
                str2 = getString(R.string.g3v);
            } else {
                str2 = wVar.CoW.Cpx;
            }
            a(this, str, string, string2, str2, new g.a() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass15 */

                @Override // com.tencent.mm.ui.widget.a.g.a
                public final void onClick() {
                    AppMethodBeat.i(213824);
                    if (RemittanceNewBaseUI.this.qAx != null) {
                        RemittanceNewBaseUI.this.qAx.bMo();
                        RemittanceNewBaseUI.this.qAx = null;
                    }
                    if (!RemittanceNewBaseUI.this.a((RemittanceNewBaseUI) wVar)) {
                        if (RemittanceNewBaseUI.this.mKindaEnable) {
                            RemittanceNewBaseUI.this.showLoading();
                        }
                        RemittanceNewBaseUI.this.a(wVar.dNQ, RemittanceNewBaseUI.this.goe, RemittanceNewBaseUI.this.Crn, wVar);
                    }
                    AppMethodBeat.o(213824);
                }
            }, new g.a() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass16 */

                @Override // com.tencent.mm.ui.widget.a.g.a
                public final void onClick() {
                    AppMethodBeat.i(213825);
                    if (RemittanceNewBaseUI.this.qAx != null) {
                        RemittanceNewBaseUI.this.qAx.bMo();
                        RemittanceNewBaseUI.this.qAx = null;
                    }
                    if (Util.isNullOrNil(wVar.CoW.Cpy)) {
                        com.tencent.mm.wallet_core.a.b(RemittanceNewBaseUI.this, "ShowOrdersInfoProcess", null);
                        AppMethodBeat.o(213825);
                        return;
                    }
                    com.tencent.mm.plugin.account.a.b.a.b(RemittanceNewBaseUI.this, wVar.CoW.Cpy, 5, true);
                    AppMethodBeat.o(213825);
                }
            });
        } else {
            Log.i("MicroMsg.RemittanceNewBaseUI", "scene.zaituMessage == null");
            a(this, getString(R.string.g47, new Object[]{Integer.valueOf(wVar.CoV)}), getString(R.string.g4j), getString(R.string.g28), getString(R.string.g3v), new g.a() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass17 */

                @Override // com.tencent.mm.ui.widget.a.g.a
                public final void onClick() {
                    AppMethodBeat.i(213826);
                    if (RemittanceNewBaseUI.this.qAx != null) {
                        RemittanceNewBaseUI.this.qAx.bMo();
                        RemittanceNewBaseUI.this.qAx = null;
                    }
                    if (!RemittanceNewBaseUI.this.a((RemittanceNewBaseUI) wVar)) {
                        RemittanceNewBaseUI.this.showLoading();
                        RemittanceNewBaseUI.this.a(wVar.dNQ, RemittanceNewBaseUI.this.goe, RemittanceNewBaseUI.this.Crn, wVar);
                    }
                    AppMethodBeat.o(213826);
                }
            }, new g.a() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass18 */

                @Override // com.tencent.mm.ui.widget.a.g.a
                public final void onClick() {
                    AppMethodBeat.i(213827);
                    if (RemittanceNewBaseUI.this.qAx != null) {
                        RemittanceNewBaseUI.this.qAx.bMo();
                        RemittanceNewBaseUI.this.qAx = null;
                    }
                    com.tencent.mm.wallet_core.a.b(RemittanceNewBaseUI.this, "ShowOrdersInfoProcess", null);
                    AppMethodBeat.o(213827);
                }
            });
        }
        return true;
    }

    private void a(Context context, String str, String str2, String str3, String str4, g.a aVar, g.a aVar2) {
        if (this.qAx != null) {
            this.qAx.bMo();
            this.qAx = null;
        }
        this.qAx = new g(context, 1, 3);
        this.qAx.b(str4, str3);
        this.qAx.a(aVar2, aVar);
        View inflate = View.inflate(context, R.layout.bmy, null);
        TextView textView = (TextView) inflate.findViewById(R.id.dmw);
        ao.a(textView.getPaint(), 0.8f);
        textView.setText(str2);
        this.qAx.setHeaderView(inflate);
        View inflate2 = View.inflate(context, R.layout.bmx, null);
        TextView textView2 = (TextView) inflate2.findViewById(R.id.dmu);
        ao.a(textView2.getPaint(), 0.8f);
        textView2.setText(str);
        this.qAx.setCustomView(inflate2);
        this.qAx.dGm();
    }

    private boolean f(final w wVar) {
        if (!wVar.Cpc) {
            return false;
        }
        this.CrE = true;
        f.a(this, this.mScene, wVar.Cpf / 100.0d, wVar.Cpe / 100.0d, wVar.CoZ / 100.0d, wVar.Cpb, new View.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass19 */

            public final void onClick(View view) {
                AppMethodBeat.i(68230);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                RemittanceNewBaseUI.this.showLoading();
                RemittanceNewBaseUI.this.a(wVar.dNQ, RemittanceNewBaseUI.this.goe, RemittanceNewBaseUI.this.Crn, wVar);
                if (RemittanceNewBaseUI.this.mScene == 1) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(12689, 12, 1);
                } else {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(12689, 3, 1);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68230);
            }
        });
        return true;
    }

    private static void aMk(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.RemittanceNewBaseUI", "msgxml is null");
            return;
        }
        String decode = URLDecoder.decode(str);
        Log.i("MicroMsg.RemittanceNewBaseUI", "helios:".concat(String.valueOf(decode)));
        String str2 = XmlParser.parseXml(decode, "msg", null).get(".msg.appmsg.wcpayinfo.transferid");
        if (TextUtils.isEmpty(str2)) {
            Log.e("MicroMsg.RemittanceNewBaseUI", "paymsgid count't be null in appmsg");
        } else {
            c.eMU().eMX().jL(str2, decode);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean eNQ() {
        return this.mScene == 0 || this.mScene == 2;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        boolean z = true;
        Log.i("MicroMsg.RemittanceNewBaseUI", "reqcode=" + i2 + ", resultCode=" + i3 + ", username=" + this.goe);
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
                if (i3 != -1) {
                    z = false;
                }
                a(z, intent);
                break;
            case 6:
                if (i3 == -1 && intent != null) {
                    hideWcKb();
                    com.tencent.mm.plugin.wallet_core.ui.view.a.a(this, getString(R.string.abz), this.mDesc, getString(R.string.g29), false, intent.getStringExtra("userName"), intent.getStringExtra("telNumber"), intent.getStringExtra("proviceFirstStageName") + intent.getStringExtra("addressCitySecondStageName") + intent.getStringExtra("addressCountiesThirdStageName") + intent.getStringExtra("addressDetailInfo"), true, new a.AbstractC1922a() {
                        /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass20 */

                        @Override // com.tencent.mm.plugin.wallet_core.ui.view.a.AbstractC1922a
                        public final boolean a(boolean z, String str, String str2, String str3, String str4) {
                            AppMethodBeat.i(68231);
                            RemittanceNewBaseUI.this.Crj = z;
                            if (!Util.isNullOrNil(str)) {
                                RemittanceNewBaseUI.this.mDesc = str;
                            } else {
                                RemittanceNewBaseUI.this.mDesc = null;
                            }
                            if (!RemittanceNewBaseUI.this.Crj) {
                                if (!Util.isNullOrNil(str2)) {
                                    RemittanceNewBaseUI.this.mName = str2;
                                } else {
                                    RemittanceNewBaseUI.this.mName = null;
                                }
                                if (!Util.isNullOrNil(str3)) {
                                    RemittanceNewBaseUI.this.APz = str3;
                                } else {
                                    RemittanceNewBaseUI.this.APz = null;
                                }
                                if (!Util.isNullOrNil(str4)) {
                                    RemittanceNewBaseUI.this.Cri = str4;
                                } else {
                                    RemittanceNewBaseUI.this.Cri = null;
                                }
                            }
                            RemittanceNewBaseUI.q(RemittanceNewBaseUI.this);
                            RemittanceNewBaseUI.r(RemittanceNewBaseUI.this);
                            AppMethodBeat.o(68231);
                            return true;
                        }
                    }, new f.c() {
                        /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass21 */

                        @Override // com.tencent.mm.ui.widget.a.f.c
                        public final void e(boolean z, String str) {
                            AppMethodBeat.i(68233);
                            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass21.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(68232);
                                    RemittanceNewBaseUI.this.hideVKB();
                                    AppMethodBeat.o(68232);
                                }
                            }, 500);
                            AppMethodBeat.o(68233);
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
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass22 */

            @Override // com.tencent.mm.plugin.remittance.ui.c.a
            public final void aMb(String str) {
                AppMethodBeat.i(68234);
                Log.i("MicroMsg.RemittanceNewBaseUI", "onDialogClick  %s", str);
                RemittanceNewBaseUI.this.Cru = str;
                RemittanceNewBaseUI.this.eNR();
                AppMethodBeat.o(68234);
            }

            @Override // com.tencent.mm.plugin.remittance.ui.c.a
            public final void onCancel() {
                AppMethodBeat.i(174431);
                RemittanceNewBaseUI.this.Cru = "";
                RemittanceNewBaseUI.this.hideLoading();
                RemittanceNewBaseUI.this.showNormalStWcKb();
                AppMethodBeat.o(174431);
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void a(final String str, final String str2, final String str3, final w wVar) {
        String str4;
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
            Log.i("MicroMsg.RemittanceNewBaseUI", "dynamic code flag: %s", Integer.valueOf(i2));
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
                    com.tencent.mm.kernel.g.aAi();
                    as bjJ = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjJ(str2);
                    if (bjJ != null) {
                        String arJ = bjJ.arJ();
                        str4 = com.tencent.mm.wallet_core.ui.f.bpz(arJ) + (Util.isNullOrNil(this.Crn) ? "" : "(" + this.Crn + ")");
                        str5 = Util.safeFormatString(string, str4);
                        str6 = getString(R.string.g4e, new Object[]{com.tencent.mm.wallet_core.ui.f.bpz(arJ)});
                    } else {
                        Log.e("MicroMsg.RemittanceNewBaseUI", "can not found contact for user::".concat(String.valueOf(str2)));
                        str4 = "";
                    }
                } else {
                    Log.e("MicroMsg.RemittanceNewBaseUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
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
                ((com.tencent.mm.pluginsdk.wallet.a) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, payInfo);
                this.CtP = true;
            } else {
                hideLoading();
                com.tencent.mm.plugin.wallet.a.a(this.CqM, intent);
                payInfo.KxB = this.dRM;
                payInfo.bex = this.Crx;
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
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass24 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(68236);
                    Log.i("MicroMsg.RemittanceNewBaseUI", "onClick1 realNameCheckMessage %s", RemittanceNewBaseUI.this.CrG);
                    le leVar = new le();
                    leVar.eXN = (long) ((int) wVar.Cpj);
                    le yr = leVar.yr(wVar.username);
                    yr.eXG = 9;
                    yr.bfK();
                    wVar.Cpw = null;
                    RemittanceNewBaseUI.this.a(str, str2, str3, wVar);
                    AppMethodBeat.o(68236);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass25 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(68237);
                    Log.i("MicroMsg.RemittanceNewBaseUI", "onClick1");
                    le leVar = new le();
                    leVar.eXN = (long) ((int) wVar.Cpj);
                    le yr = leVar.yr(wVar.username);
                    yr.eXG = 8;
                    yr.bfK();
                    RemittanceNewBaseUI.this.hideLoading();
                    AppMethodBeat.o(68237);
                }
            }, (int) R.color.a4s);
        } else if (wVar.Cpw.Lko == 2) {
            com.tencent.mm.ui.base.h.a(this, wVar.Cpw.dQx, wVar.Cpw.title, getResources().getString(R.string.j34), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass26 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(174432);
                    RemittanceNewBaseUI.this.hideLoading();
                    AppMethodBeat.o(174432);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public final void eNR() {
        if (this.mPayScene == 33) {
            a(this.mDesc, this.CqQ, this.mName, this.APz, this.Cri, this.Crk, "", null);
        } else {
            a(this.mDesc, this.CqQ, this.mName, this.APz, this.Cri, null, "", null);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public final void eNS() {
        Intent intent = new Intent();
        intent.putExtra("recent_remittance_contact_list", ad.eNA());
        intent.setClass(getContext(), SelectRemittanceContactUI.class);
        startActivityForResult(intent, 2);
    }

    @Override // com.tencent.mm.aj.e.a
    public final void Mr(String str) {
        Log.i("MicroMsg.RemittanceNewBaseUI", "onGet");
        if (Util.nullAsNil(str).length() <= 0) {
            Log.e("MicroMsg.RemittanceNewBaseUI", "notifyChanged: user = ".concat(String.valueOf(str)));
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
        textView.setText(l.b(this, str3, textView.getTextSize()));
        ((TextView) inflate.findViewById(R.id.h9m)).setText(String.format("%s%.2f", ah.hhz(), Double.valueOf(Double.valueOf(Util.getDouble(str4, 0.0d)).doubleValue() / 100.0d)));
        d.a aVar = new d.a(this);
        aVar.Dk(false);
        aVar.aoO(R.string.g4j);
        aVar.hs(inflate);
        aVar.aoV(R.string.g28);
        aVar.aoW(R.string.amc);
        aVar.d(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass28 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(68239);
                RemittanceNewBaseUI.this.showNormalStWcKb();
                AppMethodBeat.o(68239);
            }
        });
        aVar.c(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass29 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(213828);
                RemittanceNewBaseUI.this.showLoading();
                RemittanceNewBaseUI.this.a(str, RemittanceNewBaseUI.this.goe, RemittanceNewBaseUI.this.Crn, wVar);
                AppMethodBeat.o(213828);
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
        Log.i("MicroMsg.RemittanceNewBaseUI", "savePayInfoInReRemittanceUI() mLastPayResult:%s mlastTotalFee:%s mLastDesc:%s mLastAddress:%s mLastTransferId:%s", Integer.valueOf(this.dYe), Double.valueOf(this.CrI), this.CrJ, this.CrK, this.CrL);
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

    private void aMn(String str) {
        com.tencent.mm.wallet_core.ui.f.a(this.CqY, str, 0, str.length(), new com.tencent.mm.wallet_core.ui.e(new e.a() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.AnonymousClass31 */

            @Override // com.tencent.mm.wallet_core.ui.e.a
            public final void bmr() {
                AppMethodBeat.i(213831);
                RemittanceNewBaseUI.k(RemittanceNewBaseUI.this);
                AppMethodBeat.o(213831);
            }
        }), getContext());
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    /* renamed from: onWindowFocusChanged */
    public void m26onWindowFocusChanged(boolean z) {
        Log.i("MicroMsg.RemittanceNewBaseUI", "onWindowFocusChanged");
        if (this.qAx != null && !this.qAx.isShowing()) {
            this.qAx.bMo();
            this.qAx = null;
            if (this.jVx != null) {
                MMHandlerThread.postToMainThreadDelayed(this.jVx, 300);
            }
        }
        super.onWindowFocusChanged(z);
    }
}
