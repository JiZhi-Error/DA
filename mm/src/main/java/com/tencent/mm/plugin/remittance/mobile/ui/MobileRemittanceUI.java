package com.tencent.mm.plugin.remittance.mobile.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.d;
import com.tencent.mm.av.q;
import com.tencent.mm.av.r;
import com.tencent.mm.g.a.mo;
import com.tencent.mm.g.b.a.lc;
import com.tencent.mm.g.b.a.ld;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.plugin.remittance.mobile.cgi.g;
import com.tencent.mm.plugin.remittance.ui.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.protocal.protobuf.eju;
import com.tencent.mm.protocal.protobuf.eki;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MobileRemittanceUI extends MobileRemitBaseUI {
    private String CnA;
    private String CnB;
    private String CnC;
    private LinearLayout CnD;
    private TextView CnE;
    private TextView CnF;
    private View CnG;
    private TextView CnH;
    private CdnImageView CnI;
    private LinearLayout CnJ;
    private RelativeLayout CnK;
    private TextView CnL;
    private String CnM;
    protected int CnN = 0;
    protected int CnO = 0;
    private String CnP;
    public Intent CnQ;
    private Map<String, a> CnR = new HashMap();
    private Map<String, Boolean> CnS = new HashMap();
    private IListener<mo> CnT = new IListener<mo>() {
        /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass1 */

        {
            AppMethodBeat.i(160836);
            this.__eventId = mo.class.getName().hashCode();
            AppMethodBeat.o(160836);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mo moVar) {
            AppMethodBeat.i(67757);
            String str = moVar.dSd.dDL;
            Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "MobilePayCheckEvent reqKey:%s", str);
            MobileRemittanceUI.a(MobileRemittanceUI.this, str);
            if (MobileRemittanceUI.this.CnS != null && MobileRemittanceUI.this.CnS.containsKey(str)) {
                a aVar = (a) MobileRemittanceUI.this.CnR.get(str);
                String str2 = "";
                if (aVar != null) {
                    str2 = aVar.dFw;
                }
                if (((Boolean) MobileRemittanceUI.this.CnS.get(str)).booleanValue()) {
                    MobileRemittanceUI.bW(7, str2);
                } else {
                    MobileRemittanceUI.bW(6, str2);
                }
            }
            AppMethodBeat.o(67757);
            return false;
        }
    };
    private com.tencent.mm.plugin.remittance.mobile.a.a CnU = new com.tencent.mm.plugin.remittance.mobile.a.a<String>() {
        /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass15 */

        @Override // com.tencent.mm.wallet_core.c.l.a
        public final /* synthetic */ void dP(Object obj) {
            AppMethodBeat.i(67777);
            Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "dialog click action:continue");
            MobileRemittanceUI.b(MobileRemittanceUI.this, (String) obj);
            AppMethodBeat.o(67777);
        }

        @Override // com.tencent.mm.wallet_core.c.l.a
        public final /* synthetic */ void eNw() {
            AppMethodBeat.i(67778);
            Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "dialog click action:exit");
            MobileRemittanceUI.this.eNv();
            AppMethodBeat.o(67778);
        }
    };
    private String Cnh;
    private String Cni;
    protected int Cnm;
    private String Cnn;
    private String Cno;
    private String Cnt;
    private String Cnu;
    private int Cnv;
    private List<agg> Cnw = new ArrayList();
    private String Cnx;
    private String Cny;
    private String Cnz;
    private int jVe;
    protected ScrollView jVf;
    private WcPayKeyboard jVg;
    private TextView jVh;
    private WalletFormView jVj;
    private RelativeLayout jVk;
    private TextView jVl;
    private RelativeLayout jVm;
    private TextView jVn;
    private TextView jVo;
    protected double jVp;
    private Runnable jVx = new Runnable() {
        /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass7 */

        public final void run() {
            AppMethodBeat.i(67763);
            if (MobileRemittanceUI.this.state == 2 && MobileRemittanceUI.this.isHandleAutoShowNormalStWcKb()) {
                MobileRemittanceUI.this.showNormalStWcKb();
            }
            AppMethodBeat.o(67763);
        }
    };
    protected String mDesc;
    private int state = 0;

    @Override // com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MobileRemittanceUI() {
        AppMethodBeat.i(67795);
        AppMethodBeat.o(67795);
    }

    static /* synthetic */ void Wf(int i2) {
        AppMethodBeat.i(67815);
        Wa(i2);
        AppMethodBeat.o(67815);
    }

    static /* synthetic */ void a(MobileRemittanceUI mobileRemittanceUI, boolean z) {
        AppMethodBeat.i(213726);
        mobileRemittanceUI.gf(z);
        AppMethodBeat.o(213726);
    }

    static /* synthetic */ void b(MobileRemittanceUI mobileRemittanceUI, String str) {
        AppMethodBeat.i(213729);
        mobileRemittanceUI.aMa(str);
        AppMethodBeat.o(213729);
    }

    static /* synthetic */ void bW(int i2, String str) {
        AppMethodBeat.i(67814);
        bV(i2, str);
        AppMethodBeat.o(67814);
    }

    static /* synthetic */ void n(MobileRemittanceUI mobileRemittanceUI) {
        AppMethodBeat.i(213723);
        mobileRemittanceUI.We(1);
        AppMethodBeat.o(213723);
    }

    static /* synthetic */ void x(MobileRemittanceUI mobileRemittanceUI) {
        AppMethodBeat.i(213727);
        mobileRemittanceUI.af(true, true);
        AppMethodBeat.o(213727);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bb9;
    }

    @Override // com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(67796);
        super.onCreate(bundle);
        this.Cnh = getIntent().getStringExtra("key_rcvr_openid");
        this.Cni = getIntent().getStringExtra("key_rcvr_token");
        this.Cnn = getIntent().getStringExtra("key_wx_name");
        this.Cno = getIntent().getStringExtra("key_real_name");
        this.Cnt = getIntent().getStringExtra("key_phone");
        this.Cnu = getIntent().getStringExtra("key_img_url");
        this.Cnv = getIntent().getIntExtra("key_amount_remind_bit", 4);
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("key_delay_options");
        if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
            this.Cnw.addAll(NetSceneMobileRemitGetRecvInfo.gq(parcelableArrayListExtra));
        }
        this.Cnx = getIntent().getStringExtra("key_check_name_wording");
        this.Cny = getIntent().getStringExtra("key_check_name_mask");
        this.Cnz = getIntent().getStringExtra("key_get_rcvr_ext");
        this.CnA = getIntent().getStringExtra("key_timestamp_ms");
        initView();
        addSceneEndListener(2878);
        addSceneEndListener(2694);
        this.CnT.alive();
        this.state = 1;
        AppMethodBeat.o(67796);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(67797);
        super.initView();
        this.jVf = (ScrollView) findViewById(R.id.h9a);
        this.jVg = (WcPayKeyboard) findViewById(R.id.joy);
        this.CnD = (LinearLayout) findViewById(R.id.fhq);
        this.jVh = (TextView) findViewById(R.id.fho);
        this.CnE = (TextView) findViewById(R.id.fhp);
        this.CnF = (TextView) findViewById(R.id.fhz);
        this.CnG = findViewById(R.id.fia);
        this.CnH = (TextView) findViewById(R.id.fi_);
        this.CnI = (CdnImageView) findViewById(R.id.fhl);
        this.jVj = (WalletFormView) findViewById(R.id.fhn);
        this.jVk = (RelativeLayout) findViewById(R.id.jg1);
        this.jVl = (TextView) findViewById(R.id.jg4);
        this.jVm = (RelativeLayout) findViewById(R.id.jfz);
        this.CnJ = (LinearLayout) findViewById(R.id.fhf);
        this.jVn = (TextView) findViewById(R.id.h13);
        this.jVo = (TextView) findViewById(R.id.gw);
        this.CnK = (RelativeLayout) findViewById(R.id.fhd);
        this.CnL = (TextView) findViewById(R.id.fhe);
        if (LocaleUtil.getApplicationLanguage().equals(LocaleUtil.CHINA) || LocaleUtil.getApplicationLanguage().equals(LocaleUtil.TAIWAN) || LocaleUtil.getApplicationLanguage().equals(LocaleUtil.HONGKONG)) {
            this.jVk.post(new Runnable() {
                /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(67761);
                    MobileRemittanceUI.this.jVe = MobileRemittanceUI.this.jVk.getWidth();
                    MobileRemittanceUI.this.jVm.setVisibility(8);
                    Log.d("MicroMsg.mobileRemit.MobileRemittanceUI", "post: mMaxUnitWidth:%s", Integer.valueOf(MobileRemittanceUI.this.jVe));
                    AppMethodBeat.o(67761);
                }
            });
            this.jVj.setmWalletFormViewListener(new WalletFormView.c() {
                /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass6 */

                @Override // com.tencent.mm.wallet_core.ui.formview.WalletFormView.c
                public final void p(CharSequence charSequence) {
                    AppMethodBeat.i(67762);
                    if (Util.isEqual(MobileRemittanceUI.this.Cnv, 0)) {
                        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mAmountRemindBit == 0");
                        MobileRemittanceUI.this.jVm.setVisibility(8);
                        AppMethodBeat.o(67762);
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
                    if (i3 >= MobileRemittanceUI.this.Cnv) {
                        int k = MobileRemittanceUI.this.jVj.k(charSequence, MobileRemittanceUI.this.jVe, i2);
                        if (k != 0) {
                            MobileRemittanceUI.this.jVm.setVisibility(0);
                            MobileRemittanceUI.this.jVl.setText(ag.aR(MMApplicationContext.getContext(), i3));
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) MobileRemittanceUI.this.jVk.getLayoutParams();
                            layoutParams.leftMargin = k;
                            MobileRemittanceUI.this.jVk.setLayoutParams(layoutParams);
                            AppMethodBeat.o(67762);
                            return;
                        }
                        MobileRemittanceUI.this.jVm.setVisibility(8);
                        AppMethodBeat.o(67762);
                        return;
                    }
                    MobileRemittanceUI.this.jVm.setVisibility(8);
                    AppMethodBeat.o(67762);
                }
            });
        } else {
            this.jVm.setVisibility(8);
        }
        this.jVg.fEW();
        this.jVg.setActionText(getString(R.string.g3u));
        ((RelativeLayout.LayoutParams) this.jVg.getLayoutParams()).addRule(12);
        gf(false);
        setWPKeyboard(this.jVj.getContentEt(), true, false);
        this.jVj.setmContentAbnormalMoneyCheck(true);
        this.jVj.post(new Runnable() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(67760);
                MobileRemittanceUI.this.jVj.getContentEt().requestFocus();
                AppMethodBeat.o(67760);
            }
        });
        final AnonymousClass25 r0 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass25 */

            public final void onClick(View view) {
                AppMethodBeat.i(67794);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                MobileRemittanceUI.this.jVp = Util.getDouble(MobileRemittanceUI.this.jVj.getText(), 0.0d);
                if (!MobileRemittanceUI.this.jVj.bql()) {
                    u.makeText(MobileRemittanceUI.this.getContext(), (int) R.string.i7f, 0).show();
                } else if (MobileRemittanceUI.this.jVp < 0.01d) {
                    u.makeText(MobileRemittanceUI.this.getContext(), (int) R.string.g1j, 0).show();
                } else {
                    MobileRemittanceUI.this.hideWcKb();
                    MobileRemittanceUI.p(MobileRemittanceUI.this);
                    MobileRemittanceUI.Wf(10);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67794);
            }
        };
        this.jVj.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass2 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(67758);
                if (keyEvent == null || keyEvent.getAction() != 1 || keyEvent.getKeyCode() != 66 || !MobileRemittanceUI.this.jVg.isShown()) {
                    AppMethodBeat.o(67758);
                } else {
                    Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "click enter");
                    r0.onClick(null);
                    AppMethodBeat.o(67758);
                }
                return true;
            }
        });
        this.jVj.a(new TextWatcher() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass3 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(67759);
                double d2 = Util.getDouble(editable.toString(), 0.0d);
                if (!MobileRemittanceUI.this.jVj.bql() || d2 < 0.01d) {
                    MobileRemittanceUI.a(MobileRemittanceUI.this, false);
                    AppMethodBeat.o(67759);
                    return;
                }
                MobileRemittanceUI.a(MobileRemittanceUI.this, true);
                AppMethodBeat.o(67759);
            }
        });
        this.jVj.hib();
        ao.a(this.jVo.getPaint(), 0.8f);
        this.CnJ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass19 */

            public final void onClick(View view) {
                AppMethodBeat.i(67786);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                MobileRemittanceUI.this.showCircleStWcKb();
                com.tencent.mm.plugin.wallet_core.ui.view.a.a(MobileRemittanceUI.this, MobileRemittanceUI.this.getString(R.string.g1h), MobileRemittanceUI.this.mDesc, MobileRemittanceUI.this.getString(R.string.g1o), true, 20, new h.b() {
                    /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass19.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.h.b
                    public final boolean onFinish(CharSequence charSequence) {
                        AppMethodBeat.i(67783);
                        if (!Util.isNullOrNil(charSequence.toString())) {
                            MobileRemittanceUI.this.mDesc = charSequence.toString();
                            MobileRemittanceUI.d(MobileRemittanceUI.this);
                        } else {
                            MobileRemittanceUI.this.mDesc = null;
                            MobileRemittanceUI.d(MobileRemittanceUI.this);
                        }
                        AppMethodBeat.o(67783);
                        return true;
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass19.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(67785);
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass19.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(67784);
                                MobileRemittanceUI.this.hideVKB();
                                AppMethodBeat.o(67784);
                            }
                        }, 500);
                        AppMethodBeat.o(67785);
                    }
                });
                MobileRemittanceUI.Wf(6);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67786);
            }
        });
        if (this.Cnw == null || this.Cnw.isEmpty()) {
            Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mDelayOptions is null");
        } else {
            this.Cnm = this.Cnw.get(0).code;
            this.CnL.setText(this.Cnw.get(0).ClZ);
            this.CnK.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass12 */

                public final void onClick(View view) {
                    AppMethodBeat.i(67773);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "DelayOption View show bottomView");
                    MobileRemittanceUI.this.showCircleStWcKb();
                    MobileRemittanceUI.this.CnN = MobileRemittanceUI.this.CnO;
                    MobileRemittanceUI.c(MobileRemittanceUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(67773);
                }
            });
        }
        setMMTitle("");
        hideActionbarLine();
        this.jVf.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass20 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(67787);
                if (!MobileRemittanceUI.this.mWcKeyboard.isShown() || !MobileRemittanceUI.this.mWcKeyboard.hgP()) {
                    AppMethodBeat.o(67787);
                    return false;
                }
                MobileRemittanceUI.this.mWcKeyboard.hgN();
                AppMethodBeat.o(67787);
                return true;
            }
        });
        this.CnM = this.Cno;
        this.CnD.post(new Runnable() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass21 */

            public final void run() {
                AppMethodBeat.i(67788);
                int measuredWidth = MobileRemittanceUI.this.CnD.getMeasuredWidth();
                String string = MobileRemittanceUI.this.getString(R.string.f20, new Object[]{MobileRemittanceUI.this.Cnn});
                String string2 = MobileRemittanceUI.this.getString(R.string.f2a, new Object[]{MobileRemittanceUI.this.Cno});
                if (measuredWidth != 0) {
                    float measureText = MobileRemittanceUI.this.jVh.getPaint().measureText(string);
                    float measureText2 = MobileRemittanceUI.this.CnE.getPaint().measureText(string2) + ((float) com.tencent.mm.cb.a.fromDPToPix((Context) MobileRemittanceUI.this, 17));
                    if (measureText + measureText2 > ((float) measuredWidth)) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) MobileRemittanceUI.this.jVh.getLayoutParams();
                        layoutParams.width = (int) (((float) measuredWidth) - measureText2);
                        MobileRemittanceUI.this.jVh.setLayoutParams(layoutParams);
                    }
                }
                MobileRemittanceUI.this.jVh.setText(string);
                MobileRemittanceUI.this.CnE.setText(string2);
                AppMethodBeat.o(67788);
            }
        });
        this.CnF.setText(this.Cnt);
        if (Util.isNullOrNil(this.Cnu)) {
            this.CnI.setImageResource(R.drawable.bca);
        } else {
            q.bcQ();
            Bitmap EP = d.EP(this.Cnu);
            if (EP != null) {
                this.CnI.setImageBitmap(BitmapUtil.getRoundedCornerBitmap(EP, false, ((float) EP.getWidth()) * 0.1f));
            } else {
                q.bcU().a(this.Cnu, new r.a() {
                    /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass22 */

                    @Override // com.tencent.mm.av.r.a
                    public final void a(String str, final Bitmap bitmap, String str2) {
                        AppMethodBeat.i(67790);
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass22.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(67789);
                                MobileRemittanceUI.this.CnI.setImageBitmap(BitmapUtil.getRoundedCornerBitmap(bitmap, false, ((float) bitmap.getWidth()) * 0.1f));
                                AppMethodBeat.o(67789);
                            }
                        });
                        AppMethodBeat.o(67790);
                    }
                });
            }
        }
        String string = getString(R.string.f28);
        f.a(this.CnH, string, 0, string.length(), new e(new e.a() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass23 */

            @Override // com.tencent.mm.wallet_core.ui.e.a
            public final void bmr() {
                AppMethodBeat.i(213719);
                Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "click verify real name");
                MobileRemittanceUI.n(MobileRemittanceUI.this);
                MobileRemittanceUI.Wf(8);
                AppMethodBeat.o(213719);
            }
        }), getContext());
        ImageView imageView = (ImageView) findViewById(R.id.jfy);
        if (ao.isDarkMode()) {
            findViewById(R.id.jg3).setVisibility(8);
            findViewById(R.id.jg0).setVisibility(0);
            imageView.setBackgroundResource(R.drawable.crl);
            AppMethodBeat.o(67797);
            return;
        }
        findViewById(R.id.jg3).setVisibility(0);
        findViewById(R.id.jg0).setVisibility(8);
        imageView.setBackgroundResource(R.drawable.crk);
        AppMethodBeat.o(67797);
    }

    private void We(final int i2) {
        AppMethodBeat.i(67798);
        showCircleStWcKb();
        c cVar = new c(this);
        String str = this.Cnx;
        String str2 = this.Cny;
        cVar.CqB = new c.a() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass24 */

            @Override // com.tencent.mm.plugin.remittance.ui.c.a
            public final void aMb(String str) {
                AppMethodBeat.i(67792);
                Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mVerifyNameTv onINputName() name:%s", str);
                MobileRemittanceUI.this.hideVKB();
                MobileRemittanceUI.a(MobileRemittanceUI.this, i2, str);
                AppMethodBeat.o(67792);
            }

            @Override // com.tencent.mm.plugin.remittance.ui.c.a
            public final void onCancel() {
                AppMethodBeat.i(67793);
                Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mVerifyNameTv onCancel()");
                MobileRemittanceUI.this.hideVKB();
                MobileRemittanceUI.this.showNormalStWcKb();
                AppMethodBeat.o(67793);
            }
        };
        View inflate = View.inflate(cVar.mContext, R.layout.bl5, null);
        EditText editText = (EditText) inflate.findViewById(R.id.d5c);
        ((MMNeat7extView) inflate.findViewById(R.id.be9)).aw(str);
        ((TextView) inflate.findViewById(R.id.e7v)).setText(str2);
        d.a aVar = new d.a(cVar.mContext);
        aVar.bon(cVar.mContext.getString(R.string.f2d)).hs(inflate);
        com.tencent.mm.ui.tools.b.c.f(editText).a(f.a.MODE_CHINESE_AS_1).lv(1, 1).CN(false).a((c.a) null);
        MMHandlerThread.postToMainThreadDelayed(new Runnable(editText) {
            /* class com.tencent.mm.plugin.remittance.ui.c.AnonymousClass6 */
            final /* synthetic */ EditText CqC;

            {
                this.CqC = r2;
            }

            public final void run() {
                AppMethodBeat.i(213756);
                this.CqC.requestFocus();
                ((InputMethodManager) c.this.mContext.getSystemService("input_method")).showSoftInput(this.CqC, 0);
                AppMethodBeat.o(213756);
            }
        }, 200);
        aVar.bou(cVar.mContext.getResources().getString(R.string.f29)).aoX(-2141754475).a(false, new DialogInterface.OnClickListener(editText) {
            /* class com.tencent.mm.plugin.remittance.ui.c.AnonymousClass7 */
            final /* synthetic */ EditText CqC;

            {
                this.CqC = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(67938);
                if (this.CqC.length() > 0 && c.this.CqB != null) {
                    dialogInterface.dismiss();
                    c.this.CqB.aMb(this.CqC.getText().toString());
                }
                AppMethodBeat.o(67938);
            }
        });
        aVar.bov(cVar.mContext.getResources().getString(R.string.amc)).d(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.c.AnonymousClass8 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(213757);
                if (c.this.CqB != null) {
                    c.this.CqB.onCancel();
                }
                AppMethodBeat.o(213757);
            }
        });
        com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
        hbn.show();
        editText.addTextChangedListener(new TextWatcher(editText, hbn) {
            /* class com.tencent.mm.plugin.remittance.ui.c.AnonymousClass9 */
            final /* synthetic */ EditText CqC;
            final /* synthetic */ com.tencent.mm.ui.widget.a.d kce;

            {
                this.CqC = r2;
                this.kce = r3;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(213758);
                if (this.CqC.length() > 0) {
                    this.kce.ajL(c.this.mContext.getResources().getColor(R.color.Link_100));
                    AppMethodBeat.o(213758);
                    return;
                }
                this.kce.ajL(-2141754475);
                AppMethodBeat.o(213758);
            }
        });
        AppMethodBeat.o(67798);
    }

    @Override // com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(67799);
        super.onResume();
        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "onResume()");
        if (this.state == 3 && isHandleAutoShowNormalStWcKb()) {
            showNormalStWcKb();
        }
        this.state = 2;
        AppMethodBeat.o(67799);
    }

    @Override // com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(67800);
        super.onPause();
        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "onPause()");
        if (!this.jVg.hgQ()) {
            this.state = 3;
        }
        AppMethodBeat.o(67800);
    }

    @Override // com.tencent.mm.ui.widget.a.c, com.tencent.mm.ui.MMActivity
    public void onDialogDismiss(Dialog dialog) {
        AppMethodBeat.i(67801);
        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "onDialogDismiss()");
        MMHandlerThread.postToMainThreadDelayed(this.jVx, 300);
        AppMethodBeat.o(67801);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean isHandleAutoShowNormalStWcKb() {
        AppMethodBeat.i(67802);
        boolean hgR = this.jVg.hgR();
        AppMethodBeat.o(67802);
        return hgR;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(67803);
        if (this.jVg == null || !this.jVg.onKeyUp(i2, keyEvent)) {
            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(67803);
            return onKeyUp;
        }
        AppMethodBeat.o(67803);
        return true;
    }

    @Override // com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(67804);
        super.onDestroy();
        this.CnT.dead();
        removeSceneEndListener(2878);
        removeSceneEndListener(2694);
        if (this.CnR != null) {
            this.CnR.clear();
        }
        AppMethodBeat.o(67804);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        boolean z;
        AppMethodBeat.i(67805);
        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "reqcode=" + i2 + ", resultCode=" + i3);
        switch (i2) {
            case 1:
                if (i3 == -1) {
                    z = true;
                } else {
                    z = false;
                }
                Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "processResult() isOk:%s", Boolean.valueOf(z));
                if (!z) {
                    if (!ag.bH(intent)) {
                        ag.bI(intent);
                        break;
                    } else {
                        finish();
                        break;
                    }
                } else {
                    finish();
                    break;
                }
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(67805);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, final com.tencent.mm.ak.q qVar) {
        eju eju;
        AppMethodBeat.i(67806);
        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + " scenetype:" + qVar.getType());
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof com.tencent.mm.plugin.remittance.mobile.cgi.b) {
                com.tencent.mm.plugin.remittance.mobile.cgi.b bVar = (com.tencent.mm.plugin.remittance.mobile.cgi.b) qVar;
                if (bVar.ClP == null) {
                    eju = null;
                } else {
                    eju = bVar.ClP;
                }
                if (eju == null) {
                    h.a((Context) getContext(), getString(R.string.ibn), "", getResources().getString(R.string.f1r), false, (DialogInterface.OnClickListener) null).show();
                } else {
                    if (eju.Nja != null) {
                        l.a(getContext(), eju.Nja, (Object) null, new com.tencent.mm.plugin.remittance.mobile.a.a() {
                            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass8 */

                            @Override // com.tencent.mm.wallet_core.c.l.a
                            public final void eNw() {
                                AppMethodBeat.i(67764);
                                Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "checkNameResp.jump_win dialog click jumpItem.action:exit");
                                MobileRemittanceUI.this.eNv();
                                AppMethodBeat.o(67764);
                            }

                            @Override // com.tencent.mm.wallet_core.c.l.a
                            public final void dP(Object obj) {
                                AppMethodBeat.i(67765);
                                Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "checkNameResp.jump_win dialog click jumpItem.action:continue");
                                MobileRemittanceUI.x(MobileRemittanceUI.this);
                                AppMethodBeat.o(67765);
                            }
                        });
                    } else if (eju.pTZ == 0) {
                        this.CnH.setText(R.string.f2b);
                        this.CnH.setTextColor(getResources().getColor(R.color.a2t));
                        this.CnH.setOnClickListener(null);
                        this.CnH.setOnTouchListener(null);
                        this.CnE.setText(getString(R.string.f2a, new Object[]{eju.Njg}));
                        this.CnM = eju.Njg;
                        this.CnB = eju.Njf;
                        if (((com.tencent.mm.plugin.remittance.mobile.cgi.b) qVar).bDZ == 2) {
                            af(true, true);
                            bV(2, "");
                        } else {
                            final Toast makeText = Toast.makeText(getContext(), "", 0);
                            View inflate = View.inflate(getContext(), R.layout.pd, null);
                            ((WeImageView) inflate.findViewById(R.id.irc)).setImageResource(R.raw.icons_filled_done);
                            ((TextView) inflate.findViewById(R.id.ird)).setText(getContext().getResources().getString(R.string.f2c));
                            makeText.setGravity(17, 0, 0);
                            makeText.setView(inflate);
                            makeText.show();
                            new MMHandler().postDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass9 */

                                public final void run() {
                                    AppMethodBeat.i(213715);
                                    makeText.cancel();
                                    Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "mobile_remit_verify_name_success dialog dismiss");
                                    if (((com.tencent.mm.plugin.remittance.mobile.cgi.b) qVar).bDZ == 2) {
                                        MobileRemittanceUI.x(MobileRemittanceUI.this);
                                        MobileRemittanceUI.eNy();
                                    }
                                    AppMethodBeat.o(213715);
                                }
                            }, 750);
                        }
                        Wa(9);
                    } else {
                        h.a((Context) getContext(), Util.isNullOrNil(eju.pUa) ? getString(R.string.ibn) : eju.pUa, "", getResources().getString(R.string.f1r), false, (DialogInterface.OnClickListener) null).show();
                    }
                    this.CnB = eju.Njf;
                }
                AppMethodBeat.o(67806);
                return true;
            } else if (qVar instanceof g) {
                final eki eNo = ((g) qVar).eNo();
                if (eNo == null) {
                    Log.e("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder placeOrderResp is null");
                    AppMethodBeat.o(67806);
                    return true;
                } else if (eNo.pTZ != 0) {
                    Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder ret_code:%s ret_code_action:%s", Integer.valueOf(eNo.pTZ), Integer.valueOf(eNo.Njw));
                    h.a((Context) getContext(), Util.isNullOrNil(eNo.pUa) ? getString(R.string.ibn) : eNo.pUa, "", getResources().getString(R.string.f1r), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass10 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(67767);
                            if (eNo.Njw == 1) {
                                MobileRemittanceUI.this.finish();
                            }
                            AppMethodBeat.o(67767);
                        }
                    }).show();
                } else {
                    this.CnC = eNo.Njv;
                    this.CnP = eNo.Nje;
                    if (eNo.Nja != null) {
                        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show jump_win");
                        l.a(getContext(), eNo.Nja, (Object) null, new com.tencent.mm.plugin.remittance.mobile.a.a() {
                            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass11 */

                            @Override // com.tencent.mm.wallet_core.c.l.a
                            public final void eNw() {
                                AppMethodBeat.i(174408);
                                Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder jump_win dialog click action:exit");
                                MobileRemittanceUI.this.eNv();
                                AppMethodBeat.o(174408);
                            }

                            @Override // com.tencent.mm.wallet_core.c.l.a
                            public final void dP(Object obj) {
                                AppMethodBeat.i(174409);
                                Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder jump_win dialog click action:continue");
                                AppMethodBeat.o(174409);
                            }
                        });
                    } else if (eNo.Njx != 0) {
                        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show verify dilog");
                        We(2);
                        bV(1, "");
                    } else if (eNo.Njy != null) {
                        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show remind_win");
                        l.a(getContext(), eNo.Njy, eNo.dNQ, this.CnU);
                        a((g) qVar);
                    } else if (eNo.Njz != null) {
                        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show check_win");
                        l.a(getContext(), eNo.Njz, eNo.dNQ, new com.tencent.mm.plugin.remittance.mobile.a.a<String>() {
                            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass13 */

                            @Override // com.tencent.mm.wallet_core.c.l.a
                            public final /* synthetic */ void dP(Object obj) {
                                AppMethodBeat.i(174411);
                                Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "dialog click action:continue");
                                MobileRemittanceUI.b(MobileRemittanceUI.this, (String) obj);
                                AppMethodBeat.o(174411);
                            }

                            @Override // com.tencent.mm.wallet_core.c.l.a, com.tencent.mm.plugin.remittance.mobile.a.a
                            public final /* synthetic */ void eNr() {
                                AppMethodBeat.i(174410);
                                Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "dialog click action:continue");
                                MobileRemittanceUI.bW(9, eNo.KBM);
                                AppMethodBeat.o(174410);
                            }

                            @Override // com.tencent.mm.wallet_core.c.l.a
                            public final /* synthetic */ void eNw() {
                                AppMethodBeat.i(174412);
                                Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "dialog click action:exit");
                                MobileRemittanceUI.this.eNv();
                                AppMethodBeat.o(174412);
                            }
                        }, new com.tencent.mm.plugin.remittance.mobile.a.a<String>() {
                            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass14 */

                            @Override // com.tencent.mm.wallet_core.c.l.a
                            public final /* synthetic */ void dP(Object obj) {
                                AppMethodBeat.i(67776);
                                Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "dialog click action:continue");
                                MobileRemittanceUI.b(MobileRemittanceUI.this, (String) obj);
                                AppMethodBeat.o(67776);
                            }

                            @Override // com.tencent.mm.wallet_core.c.l.a, com.tencent.mm.plugin.remittance.mobile.a.a
                            public final /* synthetic */ void eNr() {
                                AppMethodBeat.i(174413);
                                Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "dialog click action:continue");
                                MobileRemittanceUI.bW(8, eNo.KBM);
                                AppMethodBeat.o(174413);
                            }

                            @Override // com.tencent.mm.wallet_core.c.l.a
                            public final /* synthetic */ void eNw() {
                                AppMethodBeat.i(67775);
                                Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "dialog click action:exit");
                                MobileRemittanceUI.this.eNv();
                                AppMethodBeat.o(67775);
                            }
                        });
                        a((g) qVar);
                    } else if (eNo.NjA != null) {
                        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "NetSceneMobileRemitPlaceOrder show dup_pay_win");
                        AppCompatActivity context = getContext();
                        dmq dmq = eNo.NjA;
                        String str2 = eNo.dNQ;
                        com.tencent.mm.plugin.remittance.mobile.a.a aVar = this.CnU;
                        com.tencent.mm.plugin.remittance.mobile.a.a aVar2 = this.CnU;
                        if (dmq == null) {
                            Log.i("MicroMsg.JumpItemUtil", "showRemindWin3() remindWin3 == null");
                        } else {
                            String str3 = dmq.dQx;
                            String str4 = dmq.MQj.dQx;
                            String str5 = dmq.MQi.dQx;
                            l.AnonymousClass5 r9 = new DialogInterface.OnClickListener(context, dmq, str2, aVar2) {
                                /* class com.tencent.mm.wallet_core.c.l.AnonymousClass5 */
                                final /* synthetic */ dmq RtA;
                                final /* synthetic */ a Rty;
                                final /* synthetic */ Object iap;
                                final /* synthetic */ Context val$context;

                                {
                                    this.val$context = r1;
                                    this.RtA = r2;
                                    this.iap = r3;
                                    this.Rty = r4;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(72747);
                                    Log.i("MicroMsg.JumpItemUtil", "showRemindWin3() right_button click!");
                                    l.a(this.val$context, this.RtA.MQj, this.iap, this.Rty);
                                    AppMethodBeat.o(72747);
                                }
                            };
                            l.AnonymousClass6 r4 = new DialogInterface.OnClickListener(context, dmq, str2, aVar) {
                                /* class com.tencent.mm.wallet_core.c.l.AnonymousClass6 */
                                final /* synthetic */ dmq RtA;
                                final /* synthetic */ a Rtz;
                                final /* synthetic */ Object iap;
                                final /* synthetic */ Context val$context;

                                {
                                    this.val$context = r1;
                                    this.RtA = r2;
                                    this.iap = r3;
                                    this.Rtz = r4;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(72748);
                                    Log.i("MicroMsg.JumpItemUtil", "showRemindWin3() left_button click!");
                                    l.a(this.val$context, this.RtA.MQi, this.iap, this.Rtz);
                                    AppMethodBeat.o(72748);
                                }
                            };
                            d.a aVar3 = new d.a(context);
                            aVar3.bon("");
                            aVar3.boo(str3);
                            aVar3.bou(str4).c(r9);
                            aVar3.bov(str5).d(r4);
                            aVar3.Dk(false);
                            aVar3.Dl(true);
                            com.tencent.mm.ui.widget.a.d hbn = aVar3.hbn();
                            hbn.show();
                            h.a(context, hbn);
                        }
                        a((g) qVar);
                    } else {
                        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "go to start pay");
                        a((g) qVar);
                        aMa(eNo.dNQ);
                    }
                    AppMethodBeat.o(67806);
                    return true;
                }
            }
        } else if (i3 == 0) {
            h.a((Context) getContext(), Util.isNullOrNil(str) ? getString(R.string.f1s) : str, "", getResources().getString(R.string.f1r), false, (DialogInterface.OnClickListener) null).show();
        }
        AppMethodBeat.o(67806);
        return false;
    }

    private void aMa(String str) {
        AppMethodBeat.i(67807);
        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() reqKey:%s", str);
        a aVar = this.CnR.get(str);
        if (aVar == null) {
            Log.e("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() strut == null fail!!");
            AppMethodBeat.o(67807);
            return;
        }
        if (aVar.Cme) {
            this.CnS.put(str, Boolean.valueOf(aVar.Cmf));
        }
        PayInfo payInfo = new PayInfo();
        payInfo.dDL = str;
        payInfo.dVv = 56;
        payInfo.channel = com.tencent.mm.plugin.remittance.mobile.a.b.eNt();
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", aVar.dFw);
        bundle.putString("extinfo_key_2", aVar.qvD);
        bundle.putString("extinfo_key_3", aVar.Cob);
        bundle.putString("extinfo_key_4", aVar.Cod);
        bundle.putInt("extinfo_key_5", aVar.yRL);
        bundle.putString("extinfo_key_6", aVar.Coe);
        bundle.putString("extinfo_key_7", aVar.Coc);
        bundle.putInt("extinfo_key_8", aVar.Cmd);
        bundle.putString("extinfo_key_9", this.Cnn);
        bundle.putString("extinfo_key_10", this.Cno);
        bundle.putString("extinfo_key_11", str);
        if (!Util.isNullOrNil(this.CnM)) {
            bundle.putString("extinfo_key_12", getString(R.string.f1q, new Object[]{this.Cnn, this.CnM}));
        }
        payInfo.iqp = bundle;
        if (eNx()) {
            Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() for kinda");
            hideProgress();
            hideLoading();
            this.CnQ = new Intent(getContext(), MobileRemitResultUI.class);
            this.CnQ.putExtras(bundle);
            showProgress();
            ((com.tencent.mm.pluginsdk.wallet.a) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(getContext(), payInfo);
            AppMethodBeat.o(67807);
            return;
        }
        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "startPay() for native");
        com.tencent.mm.pluginsdk.wallet.f.a(this, payInfo, 1);
        AppMethodBeat.o(67807);
    }

    private void a(g gVar) {
        AppMethodBeat.i(67808);
        this.CnR.put(gVar.eNo().dNQ, new a(gVar.eNo().dNQ, gVar.eNo().KBM, gVar.eNo().KHN, this.Cnh, gVar.yRL, gVar.eNo().NjB, this.Cni, gVar.eNo().Njt, gVar.Cmd, gVar.Cme, gVar.Cmf));
        AppMethodBeat.o(67808);
    }

    private void gf(boolean z) {
        AppMethodBeat.i(67809);
        this.jVg.DH(z);
        AppMethodBeat.o(67809);
    }

    private void af(boolean z, boolean z2) {
        AppMethodBeat.i(67810);
        doSceneProgress(new g(this.Cnh, this.Cni, this.Cnz, this.jVp, this.mDesc, this.Cnm, this.CnB, this.CnA, z, this.CnC, z2), true);
        AppMethodBeat.o(67810);
    }

    private static void Wa(int i2) {
        AppMethodBeat.i(67811);
        lc lcVar = new lc();
        lcVar.ejA = (long) i2;
        lcVar.bfK();
        AppMethodBeat.o(67811);
    }

    private static void bV(int i2, String str) {
        AppMethodBeat.i(67812);
        ld ldVar = new ld();
        ldVar.erW = (long) i2;
        ldVar.yq(str);
        ldVar.bfK();
        AppMethodBeat.o(67812);
    }

    private static boolean eNx() {
        AppMethodBeat.i(213720);
        com.tencent.mm.wallet_core.b.hgC();
        boolean b2 = com.tencent.mm.wallet_core.b.b(b.a.clicfg_kinda_open, true);
        com.tencent.mm.wallet_core.b.hgC();
        boolean b3 = com.tencent.mm.wallet_core.b.b(b.a.clicfg_open_kinda_mobile_remittance, false);
        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "isKindaEnable: %s，isKindaMobileRemittanceEnable ：%s", Boolean.valueOf(b2), Boolean.valueOf(b3));
        if (!b2 || !b3) {
            AppMethodBeat.o(213720);
            return false;
        }
        AppMethodBeat.o(213720);
        return true;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        int Cmd;
        boolean Cme;
        boolean Cmf;
        String Cob;
        String Coc;
        String Cod;
        String Coe;
        String dDL;
        String dFw;
        String qvD;
        int yRL;

        public a(String str, String str2, String str3, String str4, int i2, String str5, String str6, String str7, int i3, boolean z, boolean z2) {
            this.dDL = str;
            this.dFw = str2;
            this.qvD = str3;
            this.Cob = str4;
            this.yRL = i2;
            this.Coc = str5;
            this.Cod = str6;
            this.Coe = str7;
            this.Cmd = i3;
            this.Cme = z;
            this.Cmf = z2;
        }
    }

    static /* synthetic */ void a(MobileRemittanceUI mobileRemittanceUI, String str) {
        AppMethodBeat.i(67813);
        a aVar = mobileRemittanceUI.CnR.get(str);
        Log.d("MicroMsg.mobileRemit.MobileRemittanceUI", "match reqKey: %s, %d", str, Integer.valueOf(mobileRemittanceUI.CnR.size()));
        if (aVar == null) {
            Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "no data for: %s", str);
            AppMethodBeat.o(67813);
            return;
        }
        com.tencent.mm.kernel.g.azz().a(new com.tencent.mm.plugin.remittance.mobile.cgi.f(str, aVar.dFw, aVar.qvD, aVar.Cob, (long) aVar.yRL, aVar.Coc, aVar.Cod, aVar.Coe), 0);
        AppMethodBeat.o(67813);
    }

    static /* synthetic */ void c(MobileRemittanceUI mobileRemittanceUI) {
        AppMethodBeat.i(213721);
        final com.tencent.mm.ui.widget.a.g gVar = new com.tencent.mm.ui.widget.a.g(mobileRemittanceUI.getContext(), 1, 3);
        gVar.b(mobileRemittanceUI.getContext().getString(R.string.f21), mobileRemittanceUI.getContext().getString(R.string.f24));
        View inflate = View.inflate(mobileRemittanceUI.getContext(), R.layout.bb1, null);
        ao.a(((TextView) inflate.findViewById(R.id.ipm)).getPaint(), 0.8f);
        View inflate2 = View.inflate(mobileRemittanceUI.getContext(), R.layout.bb0, null);
        LinearLayout linearLayout = (LinearLayout) inflate2.findViewById(R.id.be9);
        gVar.a(new g.a() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass16 */

            @Override // com.tencent.mm.ui.widget.a.g.a
            public final void onClick() {
                AppMethodBeat.i(213716);
                Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "DelayOption View click cancel!");
                gVar.bMo();
                AppMethodBeat.o(213716);
            }
        }, new g.a() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass17 */

            @Override // com.tencent.mm.ui.widget.a.g.a
            public final void onClick() {
                AppMethodBeat.i(213717);
                agg agg = (agg) MobileRemittanceUI.this.Cnw.get(MobileRemittanceUI.this.CnN);
                Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "DelayOption View click confirm! (code:%s option:%s)", Integer.valueOf(agg.code), agg.ClZ);
                MobileRemittanceUI.this.CnO = MobileRemittanceUI.this.CnN;
                MobileRemittanceUI.this.Cnm = agg.code;
                MobileRemittanceUI.this.CnL.setText(agg.ClZ);
                gVar.bMo();
                AppMethodBeat.o(213717);
            }
        });
        final ArrayList arrayList = new ArrayList();
        AnonymousClass18 r9 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.AnonymousClass18 */

            public final void onClick(View view) {
                AppMethodBeat.i(213718);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                for (View view2 : arrayList) {
                    view2.findViewById(R.id.fh8).setVisibility(8);
                }
                ImageView imageView = (ImageView) view.getTag();
                MobileRemittanceUI.this.CnN = ((Integer) imageView.getTag()).intValue();
                imageView.setVisibility(0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(213718);
            }
        };
        for (int i2 = 0; i2 < mobileRemittanceUI.Cnw.size(); i2++) {
            View inflate3 = mobileRemittanceUI.getLayoutInflater().inflate(R.layout.bb2, (ViewGroup) null);
            ((TextView) inflate3.findViewById(R.id.fh_)).setText(mobileRemittanceUI.Cnw.get(i2).ClZ);
            ImageView imageView = (ImageView) inflate3.findViewById(R.id.fh8);
            imageView.getDrawable().setColorFilter(mobileRemittanceUI.getResources().getColor(R.color.Brand), PorterDuff.Mode.SRC_ATOP);
            if (mobileRemittanceUI.CnO == i2) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            imageView.setTag(Integer.valueOf(i2));
            inflate3.setTag(imageView);
            inflate3.setOnClickListener(r9);
            linearLayout.addView(inflate3);
            arrayList.add(inflate3);
        }
        gVar.setHeaderView(inflate);
        gVar.setCustomView(inflate2);
        gVar.dGm();
        Wa(7);
        AppMethodBeat.o(213721);
    }

    static /* synthetic */ void d(MobileRemittanceUI mobileRemittanceUI) {
        AppMethodBeat.i(213722);
        if (Util.isNullOrNil(mobileRemittanceUI.mDesc)) {
            mobileRemittanceUI.jVn.setVisibility(8);
            mobileRemittanceUI.jVo.setText(R.string.g1h);
            mobileRemittanceUI.jVo.setVisibility(0);
            AppMethodBeat.o(213722);
            return;
        }
        new com.tencent.mm.plugin.wallet_core.ui.l(mobileRemittanceUI.getContext());
        String string = mobileRemittanceUI.getString(R.string.g3a);
        SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(mobileRemittanceUI, mobileRemittanceUI.getString(R.string.b6m, new Object[]{mobileRemittanceUI.mDesc, string}));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(c2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(mobileRemittanceUI.getResources().getColor(R.color.x0)), c2.length() - string.length(), c2.length(), 34);
        mobileRemittanceUI.jVn.setText(spannableStringBuilder);
        mobileRemittanceUI.jVo.setVisibility(8);
        mobileRemittanceUI.jVn.setVisibility(0);
        AppMethodBeat.o(213722);
    }

    static /* synthetic */ void a(MobileRemittanceUI mobileRemittanceUI, int i2, String str) {
        AppMethodBeat.i(213724);
        Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "do check name: %s", Integer.valueOf(i2));
        String str2 = "";
        if (i2 == 2) {
            str2 = mobileRemittanceUI.CnP;
        }
        mobileRemittanceUI.doSceneProgress(new com.tencent.mm.plugin.remittance.mobile.cgi.b(i2, mobileRemittanceUI.Cnh, mobileRemittanceUI.Cni, str, mobileRemittanceUI.Cnz, str2), true);
        AppMethodBeat.o(213724);
    }

    static /* synthetic */ void p(MobileRemittanceUI mobileRemittanceUI) {
        AppMethodBeat.i(213725);
        mobileRemittanceUI.af(false, false);
        AppMethodBeat.o(213725);
    }

    static /* synthetic */ void eNy() {
        AppMethodBeat.i(213728);
        bV(2, "");
        AppMethodBeat.o(213728);
    }
}
