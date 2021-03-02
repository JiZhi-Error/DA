package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.i;
import com.tencent.mm.plugin.remittance.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.rb;
import com.tencent.mm.protocal.protobuf.sh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import e.a.a.c;
import java.util.LinkedList;

@a(19)
public class RemittanceBusiResultUI extends WalletBaseUI {
    private String AJn;
    private int Cof;
    private String Cog;
    private String CqN;
    private TextView CrY;
    private TextView CrZ;
    private String Crs;
    private rb CsA;
    private boolean CsB = false;
    private Runnable CsC = new Runnable() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(67990);
            RemittanceBusiResultUI.a(RemittanceBusiResultUI.this);
            RemittanceBusiResultUI.this.doSceneProgress(new j(RemittanceBusiResultUI.this.CsD, RemittanceBusiResultUI.this.Csu, RemittanceBusiResultUI.this.CsA.cSx, RemittanceBusiResultUI.this.rxM - 1, System.currentTimeMillis()));
            RemittanceBusiResultUI.f(RemittanceBusiResultUI.this);
            AppMethodBeat.o(67990);
        }
    };
    private du CsD = new du();
    private int CsE;
    private c CsF;
    private WalletSuccPageAwardWidget CsG;
    private ViewGroup CsH;
    private ViewGroup CsI;
    private ViewGroup CsJ;
    private TextView CsK;
    private boolean CsL = false;
    private IListener<aaa> CsM = new IListener<aaa>() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI.AnonymousClass2 */

        {
            AppMethodBeat.i(160840);
            this.__eventId = aaa.class.getName().hashCode();
            AppMethodBeat.o(160840);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aaa aaa) {
            AppMethodBeat.i(67991);
            aaa aaa2 = aaa;
            Log.i("MicroMsg.RemittanceBusiResultUI", "receive pay result event, do finish");
            if (aaa2.egJ.egK == 1000 || aaa2.egJ.egK == 1001) {
                RemittanceBusiResultUI.this.finish();
            }
            AppMethodBeat.o(67991);
            return false;
        }
    };
    private boolean CsN = true;
    private Runnable CsO = new Runnable() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI.AnonymousClass8 */

        public final void run() {
            AppMethodBeat.i(67997);
            RemittanceBusiResultUI.n(RemittanceBusiResultUI.this);
            AppMethodBeat.o(67997);
        }
    };
    private TextView Csa;
    private TextView Csb;
    private CdnImageView Csc;
    private TextView Csd;
    private TextView Cse;
    private Button Csf;
    private ViewGroup Csg;
    private ViewGroup Csh;
    private ViewGroup Csi;
    private ViewGroup Csj;
    private View Csk;
    private LinearLayout Csl;
    private String Csm;
    private String Csn;
    private String Cso;
    private double Csp;
    private String Csq;
    private String Csr;
    private String Css;
    private int Cst;
    private String Csu;
    private String Csv;
    private b Csw;
    private boolean Csx = false;
    private String Csy;
    private BusiRemittanceResp Csz;
    private String app_id;
    private int mChannel;
    private TextView mPa;
    private Button nAa;
    private int rxM;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RemittanceBusiResultUI() {
        AppMethodBeat.i(67998);
        AppMethodBeat.o(67998);
    }

    static /* synthetic */ int a(RemittanceBusiResultUI remittanceBusiResultUI) {
        int i2 = remittanceBusiResultUI.rxM;
        remittanceBusiResultUI.rxM = i2 + 1;
        return i2;
    }

    static /* synthetic */ void m(RemittanceBusiResultUI remittanceBusiResultUI) {
        AppMethodBeat.i(213764);
        remittanceBusiResultUI.eNY();
        AppMethodBeat.o(213764);
    }

    static /* synthetic */ void n(RemittanceBusiResultUI remittanceBusiResultUI) {
        AppMethodBeat.i(213765);
        remittanceBusiResultUI.b((j) null);
        AppMethodBeat.o(213765);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void finish() {
        AppMethodBeat.i(67999);
        Log.i("MicroMsg.RemittanceBusiResultUI", "finish this %s %s", this, Util.getStack());
        if (this.CsL) {
            AppMethodBeat.o(67999);
            return;
        }
        super.finish();
        this.CsL = true;
        AppMethodBeat.o(67999);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(68000);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(68000);
        return dispatchTouchEvent;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68001);
        super.onCreate(bundle);
        addSceneEndListener(1537);
        addSceneEndListener(1680);
        addSceneEndListener(2504);
        this.CsM.alive();
        if (d.oD(21)) {
            if (d.oD(23)) {
                getWindow().setStatusBarColor(getContext().getResources().getColor(R.color.afz));
            } else {
                getWindow().setStatusBarColor(getContext().getResources().getColor(R.color.BW_93));
            }
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setBackBtn(null);
        showHomeBtn(false);
        enableBackMenu(false);
        this.CqN = getIntent().getStringExtra("key_mch_name");
        this.Csz = (BusiRemittanceResp) getIntent().getParcelableExtra("BusiRemittanceResp");
        this.Csp = getIntent().getDoubleExtra("key_money", 0.0d);
        this.Cso = getIntent().getStringExtra("key_rcver_name");
        this.Csy = getIntent().getStringExtra("key_rcver_true_name");
        this.Csm = getIntent().getStringExtra("key_rcv_desc");
        this.Csn = getIntent().getStringExtra("key_pay_desc");
        this.Csq = getIntent().getStringExtra("key_f2f_id");
        this.AJn = getIntent().getStringExtra("key_trans_id");
        this.Crs = getIntent().getStringExtra("key_rcvr_open_id");
        this.Csv = getIntent().getStringExtra("key_check_sign");
        this.Csr = getIntent().getStringExtra("key_pay_desc");
        this.Css = getIntent().getStringExtra("key_rcv_desc");
        this.Cst = getIntent().getIntExtra("key_scan_sceen", 0);
        this.mChannel = getIntent().getIntExtra("key_channel", 0);
        this.Csu = getIntent().getStringExtra("key_succ_page_extend");
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("AfterPlaceOrderCommReq");
        this.CsA = i.aMc(getIntent().getStringExtra("key_succ_fault_config"));
        try {
            this.CsD.parseFrom(byteArrayExtra);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.RemittanceBusiResultUI", e2, "", new Object[0]);
        }
        this.CsE = getIntent().getIntExtra("key_succ_show_avatar_type", 0);
        this.Cof = getIntent().getIntExtra("key_succ_show_avatar_show", 0);
        this.Cog = getIntent().getStringExtra("key_succ_show_avatar_url");
        this.app_id = getIntent().getStringExtra("app_id");
        this.Csx = false;
        Log.i("MicroMsg.RemittanceBusiResultUI", "fetch data");
        Log.i("MicroMsg.RemittanceBusiResultUI", "fetchData() mBusiF2FFaultConfig.flag:%s mBusiF2FFaultConfig.succpage_first_delay_ms:%s", Integer.valueOf(this.CsA.cSx), Integer.valueOf(this.CsA.KXU));
        if (Util.isEqual(this.CsA.cSx, 1)) {
            MMHandlerThread.postToMainThreadDelayed(this.CsC, (long) this.CsA.KXU);
        } else {
            doSceneProgress(new j(this.CsD, this.Csu));
        }
        initView();
        AppMethodBeat.o(68001);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(68002);
        this.mPa = (TextView) findViewById(R.id.grz);
        this.CrY = (TextView) findViewById(R.id.grq);
        this.CrZ = (TextView) findViewById(R.id.grw);
        this.Csa = (TextView) findViewById(R.id.grs);
        this.Csb = (TextView) findViewById(R.id.gru);
        this.Csg = (LinearLayout) findViewById(R.id.grv);
        this.Csh = (LinearLayout) findViewById(R.id.grr);
        this.Csi = (LinearLayout) findViewById(R.id.grt);
        this.Csc = (CdnImageView) findViewById(R.id.grm);
        this.Csd = (TextView) findViewById(R.id.gro);
        this.Cse = (TextView) findViewById(R.id.grn);
        this.Csf = (Button) findViewById(R.id.grk);
        this.Csj = (ViewGroup) findViewById(R.id.grl);
        this.nAa = (Button) findViewById(R.id.grp);
        this.Csk = findViewById(R.id.hsb);
        this.Csl = (LinearLayout) findViewById(R.id.h0l);
        this.CrY.setText(f.formatMoney2f(this.Csp));
        MMHandlerThread.postToMainThreadDelayed(this.CsO, 500);
        if (!Util.isNullOrNil(this.Csm)) {
            this.CrZ.setText(this.Csm);
            this.Csg.setVisibility(0);
        } else {
            this.Csg.setVisibility(8);
        }
        if (!Util.isNullOrNil(this.Csn)) {
            this.Csa.setText(this.Csn);
            this.Csh.setVisibility(0);
        } else {
            this.Csh.setVisibility(8);
        }
        this.nAa.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(67992);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (RemittanceBusiResultUI.this.mChannel == 56) {
                    h.INSTANCE.a(19821, 10, RemittanceBusiResultUI.this.app_id, 0);
                }
                RemittanceBusiResultUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67992);
            }
        });
        this.CsG = (WalletSuccPageAwardWidget) findViewById(R.id.xh);
        this.CsH = (ViewGroup) findViewById(R.id.brh);
        this.CsI = (ViewGroup) findViewById(R.id.brf);
        this.CsJ = (ViewGroup) findViewById(R.id.g6m);
        this.CsK = (TextView) findViewById(R.id.g6d);
        AppMethodBeat.o(68002);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        AppMethodBeat.i(68003);
        Log.i("MicroMsg.RemittanceBusiResultUI", "errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + " scenetype:" + qVar.getType());
        if (qVar instanceof j) {
            j jVar = (j) qVar;
            if (i2 != 0 || i3 != 0) {
                Log.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", jVar);
            } else if (this.CsB) {
                Log.i("MicroMsg.RemittanceBusiResultUI", "NetSceneBusiF2fSucpage success(mIfSuccNetSceneBusiF2fSucpage:%s)", Boolean.valueOf(this.CsB));
            } else if (jVar.CoE.pTZ == 0) {
                this.CsB = true;
                MMHandlerThread.removeRunnable(this.CsC);
                Log.i("MicroMsg.RemittanceBusiResultUI", "exposure info: %s", jVar.CoE.Iah);
                this.CsF = jVar.CoE.Iah;
                if (WalletSuccPageAwardWidget.a(this.CsF)) {
                    Log.i("MicroMsg.RemittanceBusiResultUI", "setAwardWidget, mTransId: %s", this.AJn);
                    this.CsG.a(this, this.CsF, this.AJn, true, (ImageView) findViewById(R.id.y1));
                    this.CsG.init();
                    this.CsG.setVisibility(0);
                    final ImageView imageView = (ImageView) findViewById(R.id.y1);
                    final ViewGroup viewGroup = (ViewGroup) findViewById(R.id.hcw);
                    imageView.post(new Runnable() {
                        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(67993);
                            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                            if (viewGroup != null) {
                                layoutParams.width = viewGroup.getWidth();
                                layoutParams.height = viewGroup.getHeight();
                                imageView.setLayoutParams(layoutParams);
                            }
                            AppMethodBeat.o(67993);
                        }
                    });
                    eNY();
                } else {
                    this.CsG.setVisibility(8);
                }
                a(jVar);
                MMHandlerThread.removeRunnable(this.CsO);
                if (!Util.isNullOrNil(jVar.CoE.KYV)) {
                    if (Util.isNullOrNil(jVar.CoE.KYW)) {
                        this.Csb.setTextColor(getResources().getColor(R.color.a2t));
                    } else {
                        this.Csb.setTextColor(g.cI(jVar.CoE.KYW, true));
                    }
                    this.Csb.setText(jVar.CoE.KYV);
                    this.Csi.setVisibility(0);
                } else {
                    this.Csi.setVisibility(8);
                }
                b(jVar);
            } else {
                Log.e("MicroMsg.RemittanceBusiResultUI", "result response: %s, %s, %s", Integer.valueOf(jVar.CoE.pTZ), jVar.CoE.pUa, Boolean.valueOf(jVar.CoE.KYX));
                if (!jVar.CoE.KYX) {
                    this.CsB = true;
                    MMHandlerThread.removeRunnable(this.CsC);
                }
            }
        } else if (qVar instanceof com.tencent.mm.plugin.remittance.model.f) {
            com.tencent.mm.plugin.remittance.model.f fVar = (com.tencent.mm.plugin.remittance.model.f) qVar;
            if (i2 != 0 || i3 != 0) {
                Log.e("MicroMsg.RemittanceBusiResultUI", "net error: %s", fVar);
            } else if (fVar.Cot.pTZ == 0) {
                final sh shVar = fVar.Cot.KXT;
                if (shVar != null) {
                    this.Csc.setUrl(shVar.icon);
                    this.Csd.setText(shVar.title);
                    this.Cse.setText(shVar.HYG);
                    this.Csf.setText(shVar.IhY);
                    this.Csf.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI.AnonymousClass5 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(67994);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            Log.i("MicroMsg.RemittanceBusiResultUI", "app type: %s", Integer.valueOf(shVar.type));
                            if (shVar.type == 1) {
                                RemittanceBusiResultUI.this.Csx = true;
                                wq wqVar = new wq();
                                wqVar.ecI.userName = shVar.KDV;
                                wqVar.ecI.ecK = Util.nullAs(shVar.KDW, "");
                                wqVar.ecI.scene = 1034;
                                wqVar.ecI.ecL = 0;
                                EventCenter.instance.publish(wqVar);
                            } else if (shVar.type == 2) {
                                RemittanceBusiResultUI.this.Csx = true;
                                f.p(RemittanceBusiResultUI.this.getContext(), shVar.url, true);
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(67994);
                        }
                    });
                    this.Csf.setBackgroundResource(R.drawable.ar3);
                    this.Csf.setTextColor(getResources().getColor(R.color.ag3));
                    this.Csj.setVisibility(0);
                    eNY();
                } else {
                    Log.i("MicroMsg.RemittanceBusiResultUI", "app info is null");
                    this.Csj.setVisibility(8);
                }
            } else {
                Log.e("MicroMsg.RemittanceBusiResultUI", "qry response: %s, %s", Integer.valueOf(fVar.Cot.pTZ), fVar.Cot.pUa);
                Toast.makeText(this, fVar.Cot.pUa, 1).show();
            }
        }
        if (this.CsF != null) {
            z = this.CsG.onSceneEnd(i2, i3, str, qVar);
        } else {
            z = false;
        }
        this.Csk.setVisibility(8);
        AppMethodBeat.o(68003);
        return z;
    }

    private static boolean eM(View view) {
        AppMethodBeat.i(68004);
        if (view == null || view.getVisibility() == 8) {
            AppMethodBeat.o(68004);
            return true;
        }
        AppMethodBeat.o(68004);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(68005);
        super.onResume();
        if (this.Csx) {
            Log.i("MicroMsg.RemittanceBusiResultUI", "do act qry");
            doSceneProgress(new com.tencent.mm.plugin.remittance.model.f(this.Csq, this.AJn, this.Crs, (int) Math.round(this.Csp * 100.0d), this.Csw, this.Csv), false);
            this.Csx = false;
        }
        if (this.CsF != null) {
            this.CsG.onResume();
        }
        AppMethodBeat.o(68005);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(68006);
        super.onDestroy();
        removeSceneEndListener(1537);
        removeSceneEndListener(1680);
        removeSceneEndListener(2504);
        this.CsM.dead();
        if (this.CsF != null) {
            this.CsG.onDestroy();
        }
        MMHandlerThread.removeRunnable(this.CsO);
        AppMethodBeat.o(68006);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bmn;
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void setContentViewVisibility(int i2) {
        AppMethodBeat.i(68007);
        getContentView().setVisibility(i2);
        AppMethodBeat.o(68007);
    }

    private void a(j jVar) {
        String str;
        AppMethodBeat.i(68008);
        this.CsI.setVisibility(8);
        this.CsH.setVisibility(8);
        this.CsJ.setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.iu5);
        final View findViewById = findViewById(R.id.iu6);
        if (!(jVar == null || jVar.CoE == null || jVar.CoE.KYR.size() <= 0)) {
            LinkedList<String> linkedList = jVar.CoE.KYR;
            Object[] objArr = new Object[3];
            objArr[0] = linkedList;
            objArr[1] = Integer.valueOf(linkedList != null ? linkedList.size() : 0);
            objArr[2] = Long.valueOf(jVar.CoE.KYQ);
            Log.i("MicroMsg.RemittanceBusiResultUI", "discountInfoList: %s, size: %s received_amount: %s", objArr);
            String str2 = "";
            int size = linkedList.size();
            if (linkedList != null && linkedList.size() > 0) {
                this.CsI.removeAllViews();
                this.CsH.setOnClickListener(null);
                if (size > 1) {
                    str = jVar.CoE.KYU;
                    this.CsN = true;
                    findViewById.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI.AnonymousClass6 */

                        public final void onClick(View view) {
                            boolean z;
                            AppMethodBeat.i(67995);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (RemittanceBusiResultUI.this.CsN) {
                                findViewById.setVisibility(8);
                                RemittanceBusiResultUI.this.CsH.setVisibility(0);
                                RemittanceBusiResultUI remittanceBusiResultUI = RemittanceBusiResultUI.this;
                                ViewGroup unused = RemittanceBusiResultUI.this.CsI;
                                RemittanceBusiResultUI.m(remittanceBusiResultUI);
                            } else {
                                findViewById.setVisibility(0);
                                RemittanceBusiResultUI.this.CsH.setVisibility(8);
                                RemittanceBusiResultUI.m(RemittanceBusiResultUI.this);
                            }
                            RemittanceBusiResultUI remittanceBusiResultUI2 = RemittanceBusiResultUI.this;
                            if (!RemittanceBusiResultUI.this.CsN) {
                                z = true;
                            } else {
                                z = false;
                            }
                            remittanceBusiResultUI2.CsN = z;
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(67995);
                        }
                    });
                    this.CsH.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI.AnonymousClass7 */

                        public final void onClick(View view) {
                            boolean z;
                            AppMethodBeat.i(67996);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (RemittanceBusiResultUI.this.CsN) {
                                findViewById.setVisibility(8);
                                RemittanceBusiResultUI.this.CsH.setVisibility(0);
                                RemittanceBusiResultUI remittanceBusiResultUI = RemittanceBusiResultUI.this;
                                ViewGroup unused = RemittanceBusiResultUI.this.CsI;
                                RemittanceBusiResultUI.m(remittanceBusiResultUI);
                            } else {
                                findViewById.setVisibility(0);
                                RemittanceBusiResultUI.this.CsH.setVisibility(8);
                                RemittanceBusiResultUI.m(RemittanceBusiResultUI.this);
                            }
                            RemittanceBusiResultUI remittanceBusiResultUI2 = RemittanceBusiResultUI.this;
                            if (!RemittanceBusiResultUI.this.CsN) {
                                z = true;
                            } else {
                                z = false;
                            }
                            remittanceBusiResultUI2.CsN = z;
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceBusiResultUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(67996);
                        }
                    });
                } else {
                    str = str2;
                }
                if (size != 1 || linkedList.get(0) == null) {
                    str2 = str;
                } else {
                    str2 = linkedList.get(0);
                }
                for (int i2 = 0; i2 < linkedList.size(); i2++) {
                    TextView textView2 = new TextView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix((Context) this, 6);
                    textView2.setLayoutParams(layoutParams);
                    textView2.setTextSize(1, 12.0f);
                    textView2.setTextColor(getResources().getColor(R.color.Orange));
                    textView2.setText(linkedList.get(i2));
                    this.CsI.addView(textView2);
                }
                this.CsI.setVisibility(0);
                this.CsH.setVisibility(0);
            }
            if (this.CsN) {
                findViewById.setVisibility(0);
                SpannableString spannableString = new SpannableString(Util.nullAs(str2, "") + " ");
                if (size > 1) {
                    findViewById(R.id.iu7).setVisibility(0);
                } else {
                    findViewById(R.id.iu7).setVisibility(8);
                }
                textView.setText(spannableString);
                this.CsH.setVisibility(8);
            }
        }
        AppMethodBeat.o(68008);
    }

    private void eNY() {
        AppMethodBeat.i(68009);
        p.a(this, (ScrollView) findViewById(R.id.hcw), findViewById(R.id.agd), findViewById(R.id.mp), findViewById(R.id.aaq), 32, 0.0f, true);
        AppMethodBeat.o(68009);
    }

    private void b(j jVar) {
        String str;
        String str2;
        AppMethodBeat.i(68010);
        this.Csl.removeAllViews();
        if (this.Csz == null || Util.isNullOrNil(this.Csz.Coq)) {
            if (!Util.isNullOrNil(this.CqN)) {
                str = f.hs(this.CqN, 6);
                if (!Util.isNullOrNil(this.Csy)) {
                    str2 = getString(R.string.g22, new Object[]{str, this.Csy});
                }
            } else {
                str = f.hs(f.getDisplayName(this.Cso), 6);
                if (!Util.isNullOrNil(this.Csy)) {
                    str2 = getString(R.string.g22, new Object[]{str, this.Csy});
                }
            }
            str2 = str;
        } else {
            str2 = this.Csz.Coq;
        }
        if (!eM(this.Csg) || !eM(this.Csh) || !eM(this.CsJ) || !eM(this.Csi) || !eM(this.Csj) || WalletSuccPageAwardWidget.a(this.CsF) || !eM(findViewById(R.id.iu6)) || !eM(this.CsH)) {
            this.Csl.addView((ViewGroup) getLayoutInflater().inflate(R.layout.bmm, (ViewGroup) this.Csl, false));
            CdnImageView cdnImageView = (CdnImageView) findViewById(R.id.h0w);
            View findViewById = findViewById(R.id.e9z);
            TextView textView = (TextView) findViewById(R.id.grx);
            ((TextView) findViewById(R.id.gry)).setText(l.c(this, str2));
            cdnImageView.setVisibility(0);
            if (!Util.isNullOrNil(this.Cog)) {
                if (this.CsE == 1) {
                    cdnImageView.setRoundCorner(true);
                }
                cdnImageView.setUrl(this.Cog);
            } else if (this.CsE == 1) {
                a.b.d(cdnImageView, this.Cso);
            } else {
                a.b.c(cdnImageView, this.Cso);
            }
            findViewById.setVisibility(8);
            textView.setVisibility(8);
            if (jVar != null) {
                if (jVar.CoE.KYT == 1) {
                    findViewById.setVisibility(0);
                    textView.setVisibility(0);
                    textView.setText(f.D(((double) jVar.CoE.KYQ) / 100.0d));
                } else {
                    findViewById.setVisibility(8);
                    textView.setVisibility(8);
                }
            }
        } else {
            ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.a5l, (ViewGroup) this.Csl, false);
            this.Csl.addView(viewGroup);
            CdnImageView cdnImageView2 = (CdnImageView) viewGroup.findViewById(R.id.h0w);
            TextView textView2 = (TextView) viewGroup.findViewById(R.id.gry);
            if (!Util.isNullOrNil(this.Cog)) {
                if (this.CsE == 1) {
                    cdnImageView2.setRoundCorner(true);
                }
                cdnImageView2.setUrl(this.Cog);
            } else if (this.CsE == 1) {
                a.b.d(cdnImageView2, this.Cso);
            } else {
                a.b.c(cdnImageView2, this.Cso);
            }
            textView2.setText(str2);
        }
        eNY();
        AppMethodBeat.o(68010);
    }

    static /* synthetic */ void f(RemittanceBusiResultUI remittanceBusiResultUI) {
        AppMethodBeat.i(68011);
        Log.i("MicroMsg.RemittanceBusiResultUI", "retryFetchData() mRetryTime:%s mBusiF2FFaultConfig.succpage_retry_waiting_ms", Integer.valueOf(remittanceBusiResultUI.rxM), Integer.valueOf(remittanceBusiResultUI.CsA.KXW));
        if (remittanceBusiResultUI.CsA.KXV > remittanceBusiResultUI.rxM) {
            MMHandlerThread.postToMainThreadDelayed(remittanceBusiResultUI.CsC, (long) remittanceBusiResultUI.CsA.KXW);
        }
        AppMethodBeat.o(68011);
    }
}
