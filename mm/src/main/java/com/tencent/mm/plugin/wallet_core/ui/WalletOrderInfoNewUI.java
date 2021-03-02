package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.g.a.az;
import com.tencent.mm.g.a.ba;
import com.tencent.mm.g.a.ip;
import com.tencent.mm.g.a.le;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.zx;
import com.tencent.mm.g.b.a.kw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.m;
import com.tencent.mm.plugin.wallet_core.c.p;
import com.tencent.mm.plugin.wallet_core.c.s;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.bev;
import com.tencent.mm.protocal.protobuf.bio;
import com.tencent.mm.protocal.protobuf.bl;
import com.tencent.mm.protocal.protobuf.dhq;
import com.tencent.mm.protocal.protobuf.elh;
import com.tencent.mm.protocal.protobuf.yw;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import e.a.a.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class WalletOrderInfoNewUI extends WalletOrderInfoUI {
    private String AJn;
    private IListener AMo = new IListener<zx>() {
        /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.AnonymousClass1 */

        {
            AppMethodBeat.i(160885);
            this.__eventId = zx.class.getName().hashCode();
            AppMethodBeat.o(160885);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zx zxVar) {
            AppMethodBeat.i(70988);
            zx zxVar2 = zxVar;
            if (zxVar2 instanceof zx) {
                if (!zxVar2.egC.egD.AKs) {
                    Log.i("MicroMsg.WalletOrderInfoNewUI", "block pass");
                    AppMethodBeat.o(70988);
                    return true;
                } else if ("1".equals(zxVar2.egC.egD.egd) || "2".equals(zxVar2.egC.egD.egd)) {
                    RealnameGuideHelper realnameGuideHelper = new RealnameGuideHelper();
                    realnameGuideHelper.b(zxVar2.egC.egD.egd, zxVar2.egC.egD.ege, zxVar2.egC.egD.egf, zxVar2.egC.egD.egg, zxVar2.egC.egD.egh, WalletOrderInfoNewUI.this.mPayInfo == null ? 0 : WalletOrderInfoNewUI.this.mPayInfo.dVv);
                    Log.i("MicroMsg.WalletOrderInfoNewUI", "receive guide");
                    WalletOrderInfoNewUI.this.getInput().putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
            }
            AppMethodBeat.o(70988);
            return false;
        }
    };
    private String APz = null;
    private c CsF;
    private WalletSuccPageAwardWidget CsG;
    private ViewGroup CsH;
    private ViewGroup CsI;
    private ViewGroup CsJ;
    private TextView CsK;
    private boolean CsL = false;
    private IListener<aaa> CsM = new IListener<aaa>() {
        /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.AnonymousClass18 */

        {
            AppMethodBeat.i(160887);
            this.__eventId = aaa.class.getName().hashCode();
            AppMethodBeat.o(160887);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aaa aaa) {
            AppMethodBeat.i(71004);
            aaa aaa2 = aaa;
            Log.i("MicroMsg.WalletOrderInfoNewUI", "receive pay result event, do finish");
            if ((aaa2.egJ.egK == 1000 || aaa2.egJ.egK == 1001) && WalletOrderInfoNewUI.this.mPayInfo != null && WalletOrderInfoNewUI.this.mPayInfo.dVv == 46) {
                if (WalletOrderInfoNewUI.this.IdY != null) {
                    WalletOrderInfoNewUI.this.IdY.bz(WalletOrderInfoNewUI.this.getContext());
                }
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.AnonymousClass18.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(71003);
                        WalletOrderInfoNewUI.this.finish();
                        AppMethodBeat.o(71003);
                    }
                }, 100);
            }
            AppMethodBeat.o(71004);
            return false;
        }
    };
    private String Cvu;
    private TextView CwQ;
    private Orders HFH;
    private int HYK;
    private boolean IdD = false;
    private String IdE;
    private String IdF;
    private b IdH;
    private HashMap<String, a> IdI = new HashMap<>();
    private String IdJ;
    private String IdL = "-1";
    private Button IdM;
    private ImageView IdN;
    private ViewGroup IdO;
    private CdnImageView IdP;
    private TextView IdQ;
    private TextView IdR;
    private View IdS;
    private Button IdT;
    private ViewGroup IdU;
    private boolean IdV = false;
    private boolean IdW = false;
    private boolean IdX = false;
    private d IdY;
    private ViewGroup IhA;
    private TextView IhB;
    private CheckBox IhC;
    private ViewGroup IhD;
    private CdnImageView IhE;
    private TextView IhF;
    private ProgressBar IhG;
    private ViewGroup IhH;
    private CdnImageView IhI;
    private TextView IhJ;
    private TextView IhK;
    private Button IhL;
    private int IhM = 0;
    private boolean IhN = false;
    private boolean IhO = false;
    private IListener IhP = new IListener<ba>() {
        /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.AnonymousClass9 */

        {
            AppMethodBeat.i(160886);
            this.__eventId = ba.class.getName().hashCode();
            AppMethodBeat.o(160886);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ba baVar) {
            AppMethodBeat.i(70996);
            ba baVar2 = baVar;
            String str = baVar2.dEe.dEg;
            boolean z = baVar2.dEe.dEh;
            boolean z2 = baVar2.dEe.dEi;
            boolean z3 = baVar2.dEe.dEj;
            Log.i("MicroMsg.WalletOrderInfoNewUI", "ChangePayActivityViewEvent callback, mActivityBtnTitle: %s, isButtonEnable: %s, isButtonHidden: %s, isActivityViewHidden: %s", str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3));
            if (z3 && !Util.isNullOrNil(WalletOrderInfoNewUI.this.IdJ)) {
                WalletOrderInfoNewUI.this.IhH.setVisibility(8);
            }
            if (!Util.isNullOrNil(WalletOrderInfoNewUI.this.IdJ)) {
                WalletOrderInfoNewUI.this.IhL.setClickable(z);
                WalletOrderInfoNewUI.this.IhL.setEnabled(z);
                WalletOrderInfoNewUI.this.IhL.setOnClickListener(null);
                if (z2) {
                    WalletOrderInfoNewUI.this.IhL.setVisibility(8);
                }
            }
            baVar2.dEf.result = true;
            AppMethodBeat.o(70996);
            return false;
        }
    };
    private com.tencent.mm.plugin.wallet_core.c.a IhQ;
    private com.tencent.mm.plugin.wallet_core.c.c IhR;
    private boolean IhS = false;
    private int IhT = 2;
    protected Set<String> Ihn = null;
    private List<Orders.Commodity> Iho = null;
    private Orders.RecommendTinyAppInfo Ihp;
    private String Ihq;
    private Orders.Promotions Ihr = null;
    private TextView Ihs;
    private TextView Iht;
    private WalletTextView Ihu;
    private ViewGroup Ihv;
    private ViewGroup Ihw;
    private ViewGroup Ihx;
    private ViewGroup Ihy;
    private ViewGroup Ihz;
    private TextView PKo;
    private LinearLayout Vgq;
    private RelativeLayout Vgr;
    private CdnImageView Vgs;
    private CdnImageView Vgt;
    private View Vgu;
    private RelativeLayout Vgv;
    private TextView finderDesc;
    private String mAppId = "";
    private PayInfo mPayInfo;
    private String mRa = null;
    private ViewGroup qVm;

    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletOrderInfoNewUI() {
        AppMethodBeat.i(71014);
        AppMethodBeat.o(71014);
    }

    static /* synthetic */ void E(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        AppMethodBeat.i(258758);
        walletOrderInfoNewUI.fSU();
        AppMethodBeat.o(258758);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void finish() {
        AppMethodBeat.i(71015);
        Log.i("MicroMsg.WalletOrderInfoNewUI", "finish this %s %s", this, Util.getStack());
        if (this.CsL) {
            AppMethodBeat.o(71015);
            return;
        }
        this.CsL = true;
        super.finish();
        AppMethodBeat.o(71015);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        int i2;
        AppMethodBeat.i(71016);
        super.onCreate(bundle);
        if (com.tencent.mm.compatible.util.d.oD(21)) {
            if (com.tencent.mm.compatible.util.d.oD(23)) {
                getWindow().setStatusBarColor(getResources().getColor(R.color.f3045c));
                getWindow().getDecorView().setSystemUiVisibility(8192);
            } else {
                getWindow().setStatusBarColor(getResources().getColor(R.color.f3045c));
            }
        }
        setContentViewVisibility(4);
        this.Ihn = new HashSet();
        d by = com.tencent.mm.wallet_core.a.by(this);
        this.mPayInfo = (PayInfo) getInput().getParcelable("key_pay_info");
        this.AJn = getInput().getString("key_trans_id");
        getInput().getInt("key_pay_type", -1);
        Log.i("MicroMsg.WalletOrderInfoNewUI", "mTransId %s", this.AJn);
        this.HFH = fSS();
        if (this.HFH != null) {
            setContentViewVisibility(0);
            c(this.HFH);
            if (!(by == null || this.HFH == null || this.mPayInfo == null)) {
                this.mAppId = this.mPayInfo.appId;
                boolean hgK = by.hgK();
                f.b(this, getInput(), 7);
                int i3 = getInput().getInt("key_support_bankcard", 1) == 2 ? 2 : 1;
                h hVar = h.INSTANCE;
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(this.mPayInfo.dVv);
                objArr[1] = Boolean.valueOf(this.mPayInfo.dVv == 3);
                if (hgK) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                objArr[2] = Integer.valueOf(i2);
                objArr[3] = Integer.valueOf(ab.hhu());
                objArr[4] = Integer.valueOf((int) (this.HFH.dDO * 100.0d));
                objArr[5] = this.HFH.AOl;
                objArr[6] = Integer.valueOf(i3);
                hVar.a(10691, objArr);
            }
            if ((!t.fQI().fRk() && by != null && by.hgK()) || !z.aUj()) {
                z.aUk();
            }
            if (this.HFH == null || this.HFH.HZd == null || this.HFH.HZd.size() <= 0) {
                Log.printInfoStack("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
                com.tencent.mm.ui.base.h.a(getContext(), (int) R.string.ijv, 0, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.AnonymousClass23 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(71009);
                        WalletOrderInfoNewUI.this.done();
                        AppMethodBeat.o(71009);
                    }
                });
            } else {
                this.Iho = this.HFH.HZd;
                Log.i("MicroMsg.WalletOrderInfoNewUI", "init data commoditys size: %s", Integer.valueOf(this.Iho.size()));
                this.AJn = this.Iho.get(0).dDM;
                this.Cvu = this.Iho.get(0).dDM;
                if (!(this.mPayInfo == null || by == null || (!by.hgJ() && !by.hgK()))) {
                    doSceneProgress(new ad(getPayReqKey(), 21));
                }
            }
            ((com.tencent.mm.plugin.fingerprint.b.h) g.af(com.tencent.mm.plugin.fingerprint.b.h.class)).i(this);
        } else {
            Log.printInfoStack("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
            com.tencent.mm.ui.base.h.a(getContext(), (int) R.string.ijv, 0, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.AnonymousClass24 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(71010);
                    WalletOrderInfoNewUI.this.finish();
                    AppMethodBeat.o(71010);
                }
            });
        }
        initView();
        this.IdY = getProcess();
        fSC();
        if (this.mPayInfo != null && this.mPayInfo.dVv == 46) {
            Log.i("MicroMsg.WalletOrderInfoNewUI", "early send result");
            aaa aaa = new aaa();
            Intent intent = new Intent();
            intent.putExtras(getInput());
            if (this.HFH != null) {
                intent.putExtra("key_total_fee", this.HFH.dDO);
            }
            if (this.IdY != null) {
                intent.putExtra("key_is_clear_failure", this.IdY.dQL.getInt("key_is_clear_failure", -1));
            }
            aaa.egJ.intent = intent;
            aaa.egJ.egM = 1;
            aaa.egJ.dDL = getPayReqKey();
            aaa.egJ.result = intent.getBooleanExtra("intent_pay_end", false) ? -1 : 0;
            EventCenter.instance.publish(aaa);
        }
        if (this.HFH == null || this.HFH.HZB == null || this.HFH.HZB.Iaw != 1) {
            addSceneEndListener(1979);
            addSceneEndListener(2948);
            addSceneEndListener(2710);
            EventCenter.instance.addListener(this.IhP);
            EventCenter.instance.addListener(this.AMo);
            this.CsM.alive();
            this.IdX = true;
            af.f(this.mPayInfo == null ? 0 : this.mPayInfo.dVv, this.mPayInfo == null ? "" : this.mPayInfo.dDL, 16, "");
            AppMethodBeat.o(71016);
            return;
        }
        Log.i("MicroMsg.WalletOrderInfoNewUI", "simple cashier");
        fSY();
        AppMethodBeat.o(71016);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(71017);
        super.onResume();
        Log.i("MicroMsg.WalletOrderInfoNewUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s, exposureInfo: %s", Boolean.valueOf(this.IdX), this.Ihr, Boolean.valueOf(this.IdV), Boolean.valueOf(this.IdW), this.Ihp, this.CsF);
        if (WalletSuccPageAwardWidget.a(this.CsF)) {
            this.CsG.onResume();
            AppMethodBeat.o(71017);
        } else if (this.IdX) {
            this.IdX = false;
            AppMethodBeat.o(71017);
        } else if (this.Ihr == null || !this.IdW) {
            if (this.IdV && this.Ihp != null) {
                doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.af(new StringBuilder().append(this.Ihp.Iai).toString(), new StringBuilder().append(this.Ihp.Iak).toString(), new StringBuilder().append(this.Ihp.Ial).toString(), new StringBuilder().append(this.Ihp.Iam).toString(), getPayReqKey(), this.Cvu, this.Ihp.Ian));
            }
            AppMethodBeat.o(71017);
        } else {
            Log.i("MicroMsg.WalletOrderInfoNewUI", "do query payAward, queryAwardStatusParams==null: %s %s, isCallQueryPayAward: %s", Boolean.valueOf(Util.isNullOrNil(this.Ihr.Vgn)), this.Ihr.Vgn, Boolean.valueOf(this.IhO));
            if (this.IhO) {
                AppMethodBeat.o(71017);
                return;
            }
            this.IhO = true;
            if (Util.isNullOrNil(this.Ihr.Vgn)) {
                doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.af(new StringBuilder().append(this.Ihr.crw).toString(), new StringBuilder().append(this.Ihr.Vgh).toString(), new StringBuilder().append(this.Ihr.HYC).toString(), new StringBuilder().append(this.Ihr.HYD).toString(), getPayReqKey(), this.Cvu, this.Ihr.HYE));
                AppMethodBeat.o(71017);
                return;
            }
            doSceneProgress(new p(this.Ihr.Vgn, new StringBuilder().append(this.Ihr.crw).toString()));
            AppMethodBeat.o(71017);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0335, code lost:
        r15.CsF = r1.Iah;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WalletOrderInfoNewUI", "get exposureInfo: %s, from promotion: %s", r15.CsF, java.lang.Integer.valueOf(r1.Vgg));
        r1 = r0;
     */
    @Override // com.tencent.mm.ui.MMActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView() {
        /*
        // Method dump skipped, instructions count: 2008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.initView():void");
    }

    private void fST() {
        AppMethodBeat.i(71019);
        this.IhG.setVisibility(0);
        this.IhE.setVisibility(8);
        AppMethodBeat.o(71019);
    }

    private void fSU() {
        AppMethodBeat.i(71020);
        if (this.IhD.getVisibility() != 0) {
            AppMethodBeat.o(71020);
            return;
        }
        if (!this.IhN) {
            if (!Util.isNullOrNil(this.CsF.Ubn.Ubq)) {
                this.IhE.setUrl(this.CsF.Ubn.Ubq);
            }
            if (!Util.isNullOrNil(this.CsF.Ubn.Ubp)) {
                this.IhF.setText(this.CsF.Ubn.Ubp);
                if (!Util.isNullOrNil(this.CsF.Ubn.Ubr)) {
                    this.IhF.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cI(this.CsF.Ubn.Ubr, true));
                }
                if (this.CsF.Ubn.Ubs > 0) {
                    this.IhF.setTextSize(1, (float) this.CsF.Ubn.Ubs);
                    AppMethodBeat.o(71020);
                    return;
                }
            }
        } else {
            if (!Util.isNullOrNil(this.CsF.Ubn.Ubv)) {
                this.IhE.setUrl(this.CsF.Ubn.Ubv);
            }
            if (!Util.isNullOrNil(this.CsF.Ubn.Ubx)) {
                this.IhF.setText(this.CsF.Ubn.Ubx);
                if (!Util.isNullOrNil(this.CsF.Ubn.Ubw)) {
                    this.IhF.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cI(this.CsF.Ubn.Ubw, true));
                }
                if (this.CsF.Ubn.Ubs > 0) {
                    this.IhF.setTextSize(1, (float) this.CsF.Ubn.Ubs);
                }
            }
        }
        AppMethodBeat.o(71020);
    }

    private void fSB() {
        AppMethodBeat.i(71021);
        this.IdO.getVisibility();
        this.Ihv.getVisibility();
        this.IhA.getVisibility();
        this.IhH.getVisibility();
        this.IdU.post(new Runnable() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.AnonymousClass22 */

            public final void run() {
                int i2;
                boolean z;
                boolean z2;
                int i3;
                int i4;
                int i5;
                View findViewById;
                AppMethodBeat.i(71008);
                int height = WalletOrderInfoNewUI.this.IdU.getHeight();
                if (WalletOrderInfoNewUI.this.qVm != null) {
                    i2 = WalletOrderInfoNewUI.this.qVm.getHeight();
                } else {
                    i2 = 0;
                }
                boolean z3 = WalletOrderInfoNewUI.this.IdO.getVisibility() == 0;
                if (WalletOrderInfoNewUI.this.Ihv.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (WalletOrderInfoNewUI.this.CsG.getVisibility() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z) {
                    i3 = WalletOrderInfoNewUI.this.Ihv.getBottom();
                } else {
                    i3 = -1;
                }
                if (z3) {
                    i4 = WalletOrderInfoNewUI.this.IdO.getBottom();
                } else {
                    i4 = i3;
                }
                if (z2) {
                    i4 = WalletOrderInfoNewUI.this.CsG.getBottom();
                }
                if (i4 <= 0 && (findViewById = WalletOrderInfoNewUI.this.findViewById(R.id.g9h)) != null) {
                    i4 = findViewById.getBottom();
                }
                if (WalletOrderInfoNewUI.this.IhA.getVisibility() == 0 || WalletOrderInfoNewUI.this.IhH.getVisibility() == 0) {
                    i5 = height;
                } else {
                    i5 = com.tencent.mm.cb.a.fromDPToPix((Context) WalletOrderInfoNewUI.this, 70) + height;
                }
                Log.i("MicroMsg.WalletOrderInfoNewUI", "autoAdjustLayout inner, height: %s, topViewPos: %s, contentHeight: %s, topMargin: %s, 50dp: %s", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf((i2 - i4) - i5), Integer.valueOf(com.tencent.mm.cb.a.fromDPToPix((Context) WalletOrderInfoNewUI.this, 50)));
                AppMethodBeat.o(71008);
            }
        });
        AppMethodBeat.o(71021);
    }

    private void fSC() {
        boolean z;
        AppMethodBeat.i(71022);
        if (!(this.HFH == null || this.Iho == null || this.Iho.size() <= 0)) {
            Iterator<Orders.Commodity> it = this.Iho.iterator();
            while (true) {
                if (it.hasNext()) {
                    if ("1".equals(it.next().AOe)) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            this.CwQ.setVisibility(0);
            this.CwQ.setTextSize(1, 17.0f);
            if (!z) {
                this.CwQ.setText(R.string.ikf);
            } else if (!Util.isNullOrNil(this.HFH.HYV) && !Util.isNullOrNil(this.HFH.HYV.trim())) {
                this.CwQ.setText(this.HFH.HYV);
                AppMethodBeat.o(71022);
                return;
            } else if (this.HFH.HQg != 1) {
                this.CwQ.setText(R.string.ike);
                AppMethodBeat.o(71022);
                return;
            } else {
                this.CwQ.setText(R.string.ikd);
                AppMethodBeat.o(71022);
                return;
            }
        }
        AppMethodBeat.o(71022);
    }

    private void fSV() {
        AppMethodBeat.i(71023);
        this.Ihv.setVisibility(8);
        this.CsI.setVisibility(8);
        this.CsH.setVisibility(8);
        this.CsJ.setVisibility(8);
        if (!(this.HFH == null || this.Iho == null || this.Iho.size() <= 0)) {
            Orders.Commodity commodity = this.Iho.get(0);
            List<Orders.DiscountInfo> list = commodity.HZH;
            Object[] objArr = new Object[2];
            objArr[0] = list;
            objArr[1] = Integer.valueOf(list != null ? list.size() : 0);
            Log.i("MicroMsg.WalletOrderInfoNewUI", "discountInfoList: %s, size: %s", objArr);
            if (list != null && list.size() > 0) {
                this.CsI.removeAllViews();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    Orders.DiscountInfo discountInfo = list.get(i2);
                    TextView textView = new TextView(getContext());
                    textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                    textView.setTextSize(1, 14.0f);
                    textView.setTextColor(getResources().getColor(R.color.Orange));
                    if (discountInfo.HZY > 0.0d) {
                        textView.setText(discountInfo.Coh + com.tencent.mm.wallet_core.ui.f.d(discountInfo.HZY / 100.0d, this.HFH.AOl));
                    } else {
                        textView.setText(discountInfo.Coh);
                    }
                    this.CsI.addView(textView);
                }
                this.CsI.setVisibility(0);
                this.Ihv.setVisibility(0);
                this.CsH.setVisibility(0);
            }
            if (commodity.HZE >= 0.0d && commodity.qwJ < commodity.HZE) {
                this.CsK.setText(com.tencent.mm.wallet_core.ui.f.d(commodity.HZE, commodity.AOl));
                this.CsK.getPaint().setFlags(16);
                this.CsJ.setVisibility(0);
                this.Ihv.setVisibility(0);
            }
        }
        AppMethodBeat.o(71023);
    }

    private void fSW() {
        Orders.Promotions promotions;
        AppMethodBeat.i(71024);
        this.IhA.setVisibility(8);
        if (this.HFH != null) {
            c(this.HFH);
            if (this.Iho != null && this.Iho.size() > 0) {
                Orders.Commodity commodity = this.Iho.get(0);
                Log.i("MicroMsg.WalletOrderInfoNewUI", "setSubscribeBizInfo, hasSubscribeBiz: %s", Boolean.valueOf(commodity.HZO));
                if (commodity.HZO && commodity.HZN != null && commodity.HZN.size() > 0) {
                    Iterator<Orders.Promotions> it = commodity.HZN.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            promotions = null;
                            break;
                        }
                        promotions = it.next();
                        if (promotions.type == Orders.HZC) {
                            break;
                        }
                    }
                    Log.i("MicroMsg.WalletOrderInfoNewUI", "subscribePromotions: %s", promotions);
                    if (promotions != null && !Util.isNullOrNil(promotions.dCu)) {
                        this.Cvu = commodity.dDM;
                        h.INSTANCE.a(13033, 1, promotions.dCu, promotions.url, promotions.name, this.Cvu);
                        this.IhB.setText(getString(R.string.ikl, new Object[]{promotions.name}));
                        this.Ihq = promotions.dCu;
                        this.IhC.setVisibility(0);
                        if (this.Ihn.contains(promotions.dCu)) {
                            this.IhC.setChecked(true);
                        } else {
                            this.IhC.setChecked(false);
                        }
                        this.IhA.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.AnonymousClass5 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(258742);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                if (!Util.isNullOrNil(WalletOrderInfoNewUI.this.Ihq)) {
                                    if (WalletOrderInfoNewUI.this.Ihn.contains(WalletOrderInfoNewUI.this.Ihq)) {
                                        WalletOrderInfoNewUI.this.Ihn.remove(WalletOrderInfoNewUI.this.Ihq);
                                        WalletOrderInfoNewUI.this.IhC.setChecked(false);
                                    } else {
                                        WalletOrderInfoNewUI.this.Ihn.add(WalletOrderInfoNewUI.this.Ihq);
                                        WalletOrderInfoNewUI.this.IhC.setChecked(true);
                                    }
                                }
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(258742);
                            }
                        });
                        this.IhA.setVisibility(0);
                    }
                }
            }
        }
        AppMethodBeat.o(71024);
    }

    private void fSX() {
        AppMethodBeat.i(71025);
        this.Ihz.setVisibility(8);
        this.Ihz.removeAllViews();
        if (this.HFH != null && this.HFH.HZp == 1 && this.HFH.HZr != null && this.HFH.HZr.size() > 0) {
            Log.i("MicroMsg.WalletOrderInfoNewUI", "orders.showInfoList: %s %s", this.HFH.HZr, Integer.valueOf(this.HFH.HZr.size()));
            Iterator<Orders.ShowInfo> it = this.HFH.HZr.iterator();
            while (it.hasNext()) {
                final Orders.ShowInfo next = it.next();
                Log.i("MicroMsg.WalletOrderInfoNewUI", "showInfo: %s", next);
                LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.c_b, this.Ihz, false);
                TextView textView = (TextView) linearLayout.findViewById(R.id.eai);
                TextView textView2 = (TextView) linearLayout.findViewById(R.id.h7q);
                textView.setTextSize(1, 14.0f);
                textView2.setTextSize(1, 14.0f);
                if (!Util.isNullOrNil(next.name)) {
                    textView.setText(next.name);
                }
                if (!Util.isNullOrNil(next.xEk)) {
                    try {
                        textView.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cI(next.xEk, true));
                    } catch (Exception e2) {
                    }
                }
                if (!Util.isNullOrNil(next.value)) {
                    textView2.setText(next.value);
                }
                if (next.Iav == 1) {
                    textView2.getPaint().setFlags(16);
                }
                if (!Util.isNullOrNil(next.Iaq)) {
                    try {
                        textView2.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cI(next.Iaq, true));
                    } catch (Exception e3) {
                    }
                }
                if (next.Iar == 1) {
                    if (!Util.isNullOrNil(next.Iau)) {
                        linearLayout.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.AnonymousClass6 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(258743);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                Log.i("MicroMsg.WalletOrderInfoNewUI", "onClick showInfo, jump url: %s", next.Iau);
                                WalletOrderInfoNewUI.this.ahM(next.Iau);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(258743);
                            }
                        });
                    }
                } else if (next.Iar == 2 && !Util.isNullOrNil(next.Ias)) {
                    linearLayout.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.AnonymousClass7 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(258744);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            Log.i("MicroMsg.WalletOrderInfoNewUI", "onClick jump tinyApp, linkWeApp:%s, linkAddr:%s", next.Ias, next.Iat);
                            wq wqVar = new wq();
                            wqVar.ecI.userName = next.Ias;
                            wqVar.ecI.ecK = Util.nullAs(next.Iat, "");
                            wqVar.ecI.scene = 1060;
                            wqVar.ecI.dCw = WalletOrderInfoNewUI.this.AJn;
                            wqVar.ecI.ecL = 0;
                            wqVar.ecI.context = WalletOrderInfoNewUI.this;
                            EventCenter.instance.publish(wqVar);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(258744);
                        }
                    });
                }
                this.Ihz.addView(linearLayout);
            }
            this.Ihv.setVisibility(0);
            this.Ihz.setVisibility(0);
        }
        AppMethodBeat.o(71025);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0026, code lost:
        r0 = r12.Iho.get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void yo(boolean r13) {
        /*
        // Method dump skipped, instructions count: 1022
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.yo(boolean):void");
    }

    /* access modifiers changed from: protected */
    public final void ahM(String str) {
        AppMethodBeat.i(71027);
        Log.i("MicroMsg.WalletOrderInfoNewUI", "jumpToH5: %s", str);
        fSE();
        com.tencent.mm.wallet_core.ui.f.p(this, str, true);
        AppMethodBeat.o(71027);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(71028);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.WalletOrderInfoNewUI", "onActivityResult %d %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 1) {
            Log.i("MicroMsg.WalletOrderInfoNewUI", "do query pay arawrd, query_award_status_params==null: %s, isCallQueryPayAward: %s", Boolean.valueOf(Util.isNullOrNil(this.IdH.Iie)), Boolean.valueOf(this.IhO));
            if (this.IhO) {
                AppMethodBeat.o(71028);
                return;
            }
            this.IhO = true;
            if (Util.isNullOrNil(this.IdH.Iie)) {
                doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.af(this.IdH.HQn, this.IdH.Iia, this.IdH.Iib, this.IdH.Iic, this.IdH.dNQ, this.IdH.CpP, this.IdH.Ian));
                AppMethodBeat.o(71028);
                return;
            }
            doSceneProgress(new p(this.IdH.Iie, this.IdH.HQn));
        }
        AppMethodBeat.o(71028);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    @Deprecated
    public Dialog onCreateDialog(int i2) {
        AppMethodBeat.i(71029);
        Dialog a2 = com.tencent.mm.ui.base.h.a(getContext(), getString(R.string.ik_), getResources().getStringArray(R.array.ax), "", new h.d() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.AnonymousClass13 */

            @Override // com.tencent.mm.ui.base.h.d
            public final void oj(int i2) {
                AppMethodBeat.i(258749);
                switch (i2) {
                    case 0:
                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + WalletOrderInfoNewUI.this.APz));
                        intent.addFlags(268435456);
                        WalletOrderInfoNewUI walletOrderInfoNewUI = WalletOrderInfoNewUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(walletOrderInfoNewUI, bl.axQ(), "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$23", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        walletOrderInfoNewUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(walletOrderInfoNewUI, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$23", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        break;
                }
                AppMethodBeat.o(258749);
            }
        });
        AppMethodBeat.o(71029);
        return a2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI
    public final boolean eOn() {
        return false;
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI, com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c_c;
    }

    private void c(Orders orders) {
        AppMethodBeat.i(71030);
        this.Ihn.clear();
        if (orders == null || orders.HZd == null) {
            Log.w("MicroMsg.WalletOrderInfoNewUI", "hy: orders is null");
            AppMethodBeat.o(71030);
            return;
        }
        for (Orders.Commodity commodity : orders.HZd) {
            if (commodity.HYT == 2 && !Util.isNullOrNil(commodity.HZF)) {
                Log.i("MicroMsg.WalletOrderInfoNewUI", "hy: has username and is force recommend");
                this.Ihn.add(commodity.HZF);
            }
        }
        AppMethodBeat.o(71030);
    }

    public void done() {
        AppMethodBeat.i(71031);
        if (getInput().containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) getInput().getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.WalletOrderInfoNewUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet_core");
                boolean b2 = realnameGuideHelper.b(this, bundle, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.AnonymousClass17 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(258753);
                        WalletOrderInfoNewUI.this.fSY();
                        AppMethodBeat.o(258753);
                    }
                });
                boolean a2 = realnameGuideHelper.a(this, bundle, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.AnonymousClass25 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(258754);
                        WalletOrderInfoNewUI.this.fSY();
                        AppMethodBeat.o(258754);
                    }
                });
                getInput().remove("key_realname_guide_helper");
                if (!b2 && !a2) {
                    fSY();
                }
            }
            AppMethodBeat.o(71031);
            return;
        }
        fSY();
        AppMethodBeat.o(71031);
    }

    public final void fSY() {
        String str;
        int i2 = 1;
        AppMethodBeat.i(71032);
        fSE();
        az azVar = new az();
        azVar.dEc.dEd = true;
        EventCenter.instance.publish(azVar);
        ip ipVar = new ip();
        ipVar.dNj.dNk = "ok";
        EventCenter.instance.publish(ipVar);
        Bundle bundle = new Bundle();
        bundle.putInt("intent_pay_end_errcode", getInput().getInt("intent_pay_end_errcode"));
        bundle.putString("intent_pay_app_url", getInput().getString("intent_pay_app_url"));
        bundle.putBoolean("intent_pay_end", getInput().getBoolean("intent_pay_end"));
        Log.i("MicroMsg.WalletOrderInfoNewUI", "pay done...feedbackData errCode:" + getInput().getInt("intent_pay_end_errcode"));
        for (String str2 : this.Ihn) {
            if (!Util.isNullOrNil(str2)) {
                Log.i("MicroMsg.WalletOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", str2);
                if (this.HFH == null || this.mPayInfo == null) {
                    g.aAg().hqi.a(new com.tencent.mm.wallet_core.c.t(str2), 0);
                } else {
                    com.tencent.mm.ak.t tVar = g.aAg().hqi;
                    String str3 = this.HFH.dDL;
                    if (this.HFH.HZd.size() > 0) {
                        str = this.HFH.HZd.get(0).dDM;
                    } else {
                        str = "";
                    }
                    tVar.a(new com.tencent.mm.wallet_core.c.t(str2, str3, str, this.mPayInfo.dVv, this.mPayInfo.channel, this.HFH.HYT), 0);
                }
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13033, 2, str2, "", "", "");
        }
        if (this.IdY != null) {
            this.IdY.a(this, 0, bundle);
            this.IdY = null;
        } else {
            Log.i("MicroMsg.WalletOrderInfoNewUI", "process is null! finish directly");
            finish();
        }
        if (this.mPayInfo != null && (this.mPayInfo.dVv == 46 || this.mPayInfo.dVv == 3)) {
            kw kwVar = new kw();
            if (this.mPayInfo.dVv == 46) {
                kwVar.eXy = 2;
            } else if (this.mPayInfo.dVv == 3) {
                kwVar.eXy = 1;
            }
            if (this.HFH != null && this.HFH.HZq == 0) {
                kwVar.eXz = 1;
            } else if (this.HFH != null && this.HFH.HZq == 1) {
                kwVar.eXz = 2;
            } else if (this.HFH != null && this.HFH.HZq == 0 && !Util.isNullOrNil(this.HFH.HZt) && !Util.isNullOrNil(this.HFH.HZs)) {
                kwVar.eXz = 3;
            }
            if (!(this.mPayInfo == null || this.mPayInfo.iqp == null)) {
                String string = this.mPayInfo.iqp.getString("extinfo_key_20", "");
                if (!Util.isNullOrNil(string)) {
                    kwVar.eXA = kwVar.x("SourceH5Url", string, false);
                }
                String string2 = this.mPayInfo.iqp.getString("extinfo_key_21", "");
                if (!Util.isNullOrNil(string2)) {
                    kwVar.eXC = kwVar.x("SourceAppPath", string2, true);
                }
                String string3 = this.mPayInfo.iqp.getString("extinfo_key_22", "");
                if (!Util.isNullOrNil(string3)) {
                    kwVar.eXB = kwVar.x("SourceAppUsername", string3, true);
                }
            }
            if (this.HFH != null && this.HFH.HZq == 0 && !Util.isNullOrNil(this.HFH.HZt) && !Util.isNullOrNil(this.HFH.HZs)) {
                kwVar.eXE = kwVar.x("TargetAppPath", this.HFH.HZt, true);
                kwVar.eXD = kwVar.x("TargetAppUsername", this.HFH.HZs, true);
            }
            kwVar.bfK();
            if (this.HFH != null && this.HFH.HZq == 0 && !Util.isNullOrNil(this.HFH.HZt) && !Util.isNullOrNil(this.HFH.HZs)) {
                wq wqVar = new wq();
                wqVar.ecI.userName = this.HFH.HZs;
                wqVar.ecI.ecK = this.HFH.HZt;
                wqVar.ecI.scene = 1060;
                wqVar.ecI.dCw = this.AJn;
                wqVar.ecI.ecL = 0;
                wqVar.ecI.context = this;
                EventCenter.instance.publish(wqVar);
                AppMethodBeat.o(71032);
                return;
            }
        }
        if (this.HFH != null && !Util.isNullOrNil(this.HFH.rCq)) {
            String i3 = i(this.HFH.rCq, this.HFH.dDL, this.HFH.HZd.size() > 0 ? this.HFH.HZd.get(0).dDM : "", this.mPayInfo.pSm, this.mPayInfo.remark);
            Log.d("MicroMsg.WalletOrderInfoNewUI", "url = ".concat(String.valueOf(i3)));
            Intent intent = new Intent();
            intent.putExtra("rawUrl", i3);
            intent.putExtra("showShare", false);
            intent.putExtra("geta8key_username", z.aTY());
            intent.putExtra("stastic_scene", 8);
            com.tencent.mm.wallet_core.ui.f.aA(getContext(), intent);
        }
        if (this.IhD.getVisibility() == 0 && this.CsF.Ubn != null) {
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr = new Object[6];
            objArr[0] = this.Cvu;
            objArr[1] = this.IhF.getText();
            objArr[2] = Integer.valueOf(this.CsF.Ubn.Ubo == 0 ? 1 : 2);
            if (!this.IhN) {
                i2 = 2;
            }
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = Integer.valueOf(this.IhT);
            objArr[5] = Long.valueOf(System.currentTimeMillis());
            hVar.a(17271, objArr);
        }
        AppMethodBeat.o(71032);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(71033);
        if (i2 == 4) {
            done();
            AppMethodBeat.o(71033);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(71033);
        return onKeyUp;
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(71034);
        super.onDestroy();
        if (!this.CsL) {
            ip ipVar = new ip();
            ipVar.dNj.dNk = "ok";
            EventCenter.instance.publish(ipVar);
        }
        Log.i("MicroMsg.WalletOrderInfoNewUI", "do follow card bd mch");
        if (!(this.CsF == null || this.CsF.Ubn == null)) {
            new com.tencent.mm.plugin.wallet_core.c.b(this.CsF.Ubn.LjW, this.CsF.Ubn.Ubo, this.IhM).aYI().h(new com.tencent.mm.vending.c.a<Object, c.a<bev>>() {
                /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.AnonymousClass16 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Object call(c.a<bev> aVar) {
                    AppMethodBeat.i(258752);
                    c.a<bev> aVar2 = aVar;
                    Log.i("MicroMsg.WalletOrderInfoNewUI", "errType: %s, errCode: %s", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode));
                    if (aVar2.errType == 0 && aVar2.errCode == 0) {
                        Log.i("MicroMsg.WalletOrderInfoNewUI", "retCode: %s, retMsg: %s", Integer.valueOf(((bev) aVar2.iLC).pTZ), ((bev) aVar2.iLC).pUa);
                    }
                    AppMethodBeat.o(258752);
                    return null;
                }
            });
        }
        EventCenter.instance.removeListener(this.IhP);
        EventCenter.instance.removeListener(this.AMo);
        removeSceneEndListener(1979);
        removeSceneEndListener(2948);
        removeSceneEndListener(2710);
        this.CsM.dead();
        if (WalletSuccPageAwardWidget.a(this.CsF)) {
            this.CsG.onDestroy();
        }
        if (this.IhQ != null) {
            this.IhQ.cancel();
        }
        if (this.IhR != null) {
            this.IhR.cancel();
        }
        AppMethodBeat.o(71034);
    }

    /* access modifiers changed from: protected */
    public void fSE() {
        int i2 = 0;
        AppMethodBeat.i(71035);
        if (!this.IdD) {
            le leVar = new le();
            leVar.dQr.requestCode = 4;
            le.a aVar = leVar.dQr;
            if (getInput().getBoolean("intent_pay_end", false)) {
                i2 = -1;
            }
            aVar.resultCode = i2;
            leVar.dQr.dQs = new Intent();
            if (this.HFH != null) {
                leVar.dQr.dQs.putExtra("key_jsapi_close_page_after_pay", this.HFH.HZq);
            }
            if (this.HFH != null && this.HFH.HZq == 0 && !Util.isNullOrNil(this.HFH.HZt) && !Util.isNullOrNil(this.HFH.HZs)) {
                leVar.dQr.dQs.putExtra("key_jsapi_close_page_after_pay", 1);
            }
            if (this.IdY != null) {
                leVar.dQr.dQs.putExtra("key_is_clear_failure", this.IdY.dQL.getInt("key_is_clear_failure", -1));
            }
            EventCenter.instance.publish(leVar);
            this.IdD = true;
        }
        AppMethodBeat.o(71035);
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        String string;
        String string2;
        AppMethodBeat.i(71036);
        Log.i("MicroMsg.WalletOrderInfoNewUI", "onSceneEnd, errType: %s, errCode: %s, scene: %s", Integer.valueOf(i2), Integer.valueOf(i3), qVar);
        if (!WalletSuccPageAwardWidget.a(this.CsF) || !this.CsG.onSceneEnd(i2, i3, str, qVar)) {
            if (qVar instanceof com.tencent.mm.plugin.wallet_core.c.af) {
                if (i2 == 0 && i3 == 0) {
                    com.tencent.mm.plugin.wallet_core.c.af afVar = (com.tencent.mm.plugin.wallet_core.c.af) qVar;
                    a aVar = new a(afVar.lxS);
                    if (this.IdH != null) {
                        this.IdI.put(afVar.HQn, aVar);
                        yo(false);
                        fSB();
                    } else if (this.IdV) {
                        this.IdI.put(afVar.HQn, aVar);
                        yo(false);
                        fSB();
                    }
                }
                this.IhO = false;
            } else if (qVar instanceof p) {
                if (i2 == 0 && i3 == 0) {
                    p pVar = (p) qVar;
                    dhq dhq = pVar.HPU;
                    if (dhq.pTZ == 0) {
                        a aVar2 = new a(dhq);
                        if (this.IdH != null) {
                            this.IdI.put(pVar.FJm, aVar2);
                            yo(false);
                            fSB();
                        } else if (this.IdV) {
                            this.IdI.put(pVar.FJm, aVar2);
                            yo(false);
                            fSB();
                        }
                    }
                }
                this.IhO = false;
            } else if (qVar instanceof s) {
                if (i2 == 0 && i3 == 0) {
                    s sVar = (s) qVar;
                    String str2 = sVar.HPV;
                    if (this.Ihr != null && this.Ihr.crw == sVar.HPY.crw) {
                        Log.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", this.Ihr);
                        this.IdL = str2;
                        Log.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", sVar.HPY.HYF);
                        yo(false);
                        fSB();
                        if (!Util.isNullOrNil(sVar.resultMsg) && !TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(str2)) {
                            this.IdT.setText(sVar.resultMsg);
                        }
                    }
                    if (!"-1".equals(str2) && !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str2) && !Util.isNullOrNil(sVar.HPW)) {
                        com.tencent.mm.ui.base.h.c(this, sVar.HPW, "", true);
                    } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str2)) {
                        if (!Util.isNullOrNil(sVar.HPW)) {
                            string2 = sVar.HPW;
                        } else {
                            string2 = getString(R.string.imw);
                        }
                        Toast.makeText(this, string2, 0).show();
                    }
                    AppMethodBeat.o(71036);
                    return true;
                }
                if (Util.isNullOrNil(str)) {
                    str = getString(R.string.itf);
                }
                com.tencent.mm.ui.base.h.a((Context) this, str, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.AnonymousClass26 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(71036);
                return true;
            } else if (qVar instanceof m) {
                if (i2 == 0 && i3 == 0) {
                    m mVar = (m) qVar;
                    bio bio = mVar.HPO;
                    if (bio.pTZ == 0) {
                        String sb = new StringBuilder().append(bio.LSF).toString();
                        if (this.Ihr != null && this.Ihr.crw == mVar.crw) {
                            Log.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", this.Ihr);
                            this.IdL = sb;
                            Log.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", bio.LSH);
                            yo(false);
                            fSB();
                            if (!Util.isNullOrNil(bio.LSH) && !TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(sb)) {
                                this.IdT.setText(bio.LSH);
                            }
                        }
                        if (!"-1".equals(sb) && !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(sb) && !Util.isNullOrNil(bio.LSG)) {
                            com.tencent.mm.ui.base.h.c(this, bio.LSG, "", true);
                        } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(sb)) {
                            if (!Util.isNullOrNil(bio.LSG)) {
                                string = bio.LSG;
                            } else {
                                string = getString(R.string.imw);
                            }
                            Toast.makeText(this, string, 0).show();
                        }
                    }
                    AppMethodBeat.o(71036);
                    return true;
                }
                if (Util.isNullOrNil(str)) {
                    str = getString(R.string.itf);
                }
                com.tencent.mm.ui.base.h.a((Context) this, str, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.AnonymousClass27 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(71036);
                return true;
            }
            AppMethodBeat.o(71036);
            return false;
        }
        AppMethodBeat.o(71036);
        return true;
    }

    /* access modifiers changed from: package-private */
    public static class b {
        public String CpP;
        public String HQn;
        public long Ian;
        public String Iia;
        public String Iib;
        public String Iic;
        public long Iid;
        public String Iie;
        public String dNQ;

        public b(String str, String str2, String str3, String str4, String str5, String str6, long j2, String str7) {
            this.HQn = str;
            this.Iia = str2;
            this.Iib = str3;
            this.Iic = str4;
            this.dNQ = str5;
            this.CpP = str6;
            this.Ian = j2;
            this.Iie = str7;
        }

        public b(String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
            this.HQn = str;
            this.Iia = str2;
            this.Iib = str3;
            this.Iic = str4;
            this.dNQ = str5;
            this.CpP = str6;
            this.Ian = j2;
            this.Iid = j3;
            this.Iie = null;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public String HLz;
        public String HYH;
        public String HYI;
        public String HYJ;
        public String Hwr;
        public String Hws;
        public String IhY;
        public int IhZ;
        public String dQx;
        public String icon;
        public String title;
        public String url;

        public a(JSONObject jSONObject) {
            AppMethodBeat.i(71011);
            if (jSONObject == null) {
                AppMethodBeat.o(71011);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("activity_change_info");
            if (optJSONObject != null) {
                this.url = optJSONObject.optString("url");
                this.dQx = optJSONObject.optString("wording");
                this.icon = optJSONObject.optString("icon");
                this.IhY = optJSONObject.optString("btn_text");
                this.title = optJSONObject.optString("title");
                this.HLz = optJSONObject.optString("tinyapp_name");
                this.HYH = optJSONObject.optString("tinyapp_logo");
                this.HYI = optJSONObject.optString("tinyapp_desc");
                this.Hwr = optJSONObject.optString("tinyapp_username");
                this.Hws = optJSONObject.optString("tinyapp_path");
                this.HYJ = optJSONObject.optString("activity_tinyapp_btn_text");
            }
            AppMethodBeat.o(71011);
        }

        public a(dhq dhq) {
            AppMethodBeat.i(71012);
            if (!(dhq == null || dhq.MMy == null)) {
                bl blVar = dhq.MMy;
                this.url = blVar.url;
                this.dQx = blVar.dQx;
                this.icon = blVar.icon;
                this.IhY = blVar.IhY;
                this.title = blVar.title;
                this.Hwr = blVar.Hwr;
                this.Hws = blVar.Hws;
                this.IhZ = blVar.IhZ;
                this.HLz = this.title;
                this.HYH = this.icon;
                this.HYI = this.dQx;
                this.HYJ = this.IhY;
            }
            AppMethodBeat.o(71012);
        }

        public final String toString() {
            AppMethodBeat.i(71013);
            String str = this.url + " , " + this.dQx + " , " + this.icon + " , " + this.IhY + " , " + this.title;
            AppMethodBeat.o(71013);
            return str;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void setContentViewVisibility(int i2) {
        AppMethodBeat.i(71037);
        getContentView().setVisibility(i2);
        AppMethodBeat.o(71037);
    }

    static /* synthetic */ void h(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        AppMethodBeat.i(71038);
        Log.i("MicroMsg.WalletOrderInfoNewUI", "do uncheck mch service pos");
        if (walletOrderInfoNewUI.IhR != null || walletOrderInfoNewUI.CsF == null || walletOrderInfoNewUI.CsF.Ubn == null) {
            AppMethodBeat.o(71038);
            return;
        }
        walletOrderInfoNewUI.fST();
        walletOrderInfoNewUI.IhM = 0;
        walletOrderInfoNewUI.IhR = new com.tencent.mm.plugin.wallet_core.c.c(walletOrderInfoNewUI.CsF.Ubn.LjW);
        walletOrderInfoNewUI.IhR.aYI().b(new com.tencent.mm.vending.c.a<Object, c.a<elh>>() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.AnonymousClass15 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(c.a<elh> aVar) {
                AppMethodBeat.i(258751);
                c.a<elh> aVar2 = aVar;
                Log.i("MicroMsg.WalletOrderInfoNewUI", "errType: %s, errCode: %s", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode));
                WalletOrderInfoNewUI.this.IhR = null;
                WalletOrderInfoNewUI.B(WalletOrderInfoNewUI.this);
                if (aVar2.errType == 0 && aVar2.errCode == 0) {
                    Log.i("MicroMsg.WalletOrderInfoNewUI", "retCode: %s, retMsg: %s", Integer.valueOf(((elh) aVar2.iLC).pTZ), ((elh) aVar2.iLC).pUa);
                    if (((elh) aVar2.iLC).pTZ == 0) {
                        WalletOrderInfoNewUI.this.IhN = false;
                        WalletOrderInfoNewUI.this.IhT = 1;
                        WalletOrderInfoNewUI.E(WalletOrderInfoNewUI.this);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(17270, WalletOrderInfoNewUI.this.Cvu, WalletOrderInfoNewUI.this.CsF.Ubn.Ubx, 2, 1, 2, Long.valueOf(System.currentTimeMillis()));
                    } else {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(17270, WalletOrderInfoNewUI.this.Cvu, WalletOrderInfoNewUI.this.CsF.Ubn.Ubx, 2, 2, 2, Long.valueOf(System.currentTimeMillis()));
                    }
                } else {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(17270, WalletOrderInfoNewUI.this.Cvu, WalletOrderInfoNewUI.this.CsF.Ubn.Ubx, 2, 2, 2, Long.valueOf(System.currentTimeMillis()));
                }
                AppMethodBeat.o(258751);
                return null;
            }
        });
        AppMethodBeat.o(71038);
    }

    static /* synthetic */ void i(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        AppMethodBeat.i(71039);
        Log.i("MicroMsg.WalletOrderInfoNewUI", "do check mch service pos");
        if (walletOrderInfoNewUI.IhQ != null || walletOrderInfoNewUI.CsF == null || walletOrderInfoNewUI.CsF.Ubn == null) {
            AppMethodBeat.o(71039);
            return;
        }
        walletOrderInfoNewUI.fST();
        walletOrderInfoNewUI.IhM = 1;
        walletOrderInfoNewUI.IhQ = new com.tencent.mm.plugin.wallet_core.c.a(walletOrderInfoNewUI.CsF.Ubn.LjW);
        walletOrderInfoNewUI.IhQ.aYI().b(new com.tencent.mm.vending.c.a<Object, c.a<yw>>() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.AnonymousClass14 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(c.a<yw> aVar) {
                int i2;
                AppMethodBeat.i(258750);
                c.a<yw> aVar2 = aVar;
                Log.i("MicroMsg.WalletOrderInfoNewUI", "errType: %s, errCode: %s", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode));
                WalletOrderInfoNewUI.this.IhQ = null;
                WalletOrderInfoNewUI.B(WalletOrderInfoNewUI.this);
                if (aVar2.errType == 0 && aVar2.errCode == 0) {
                    Log.i("MicroMsg.WalletOrderInfoNewUI", "retCode: %s, retMsg: %s", Integer.valueOf(((yw) aVar2.iLC).pTZ), ((yw) aVar2.iLC).pUa);
                    if (((yw) aVar2.iLC).pTZ == 0) {
                        WalletOrderInfoNewUI.this.IhN = true;
                        if (WalletOrderInfoNewUI.this.CsF.Ubn.Ubt != 1 || WalletOrderInfoNewUI.this.IhS) {
                            i2 = 2;
                        } else {
                            WalletOrderInfoNewUI.a(WalletOrderInfoNewUI.this, WalletOrderInfoNewUI.this.CsF.Ubn.Ubu);
                            i2 = 1;
                        }
                        WalletOrderInfoNewUI.E(WalletOrderInfoNewUI.this);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(17270, WalletOrderInfoNewUI.this.Cvu, WalletOrderInfoNewUI.this.CsF.Ubn.Ubx, 1, 1, Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()));
                    } else {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(17270, WalletOrderInfoNewUI.this.Cvu, WalletOrderInfoNewUI.this.CsF.Ubn.Ubx, 1, 2, 2, Long.valueOf(System.currentTimeMillis()));
                    }
                } else {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(17270, WalletOrderInfoNewUI.this.Cvu, WalletOrderInfoNewUI.this.CsF.Ubn.Ubx, 1, 2, 2, Long.valueOf(System.currentTimeMillis()));
                }
                AppMethodBeat.o(258750);
                return null;
            }
        });
        AppMethodBeat.o(71039);
    }

    static /* synthetic */ void v(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        AppMethodBeat.i(258755);
        Object[] objArr = new Object[1];
        objArr[0] = Long.valueOf(walletOrderInfoNewUI.Ihr != null ? walletOrderInfoNewUI.Ihr.crw : 0);
        Log.i("MicroMsg.WalletOrderInfoNewUI", "onClickActivity, activityId: %s", objArr);
        if (walletOrderInfoNewUI.Ihr != null && walletOrderInfoNewUI.Ihr.crw > 0) {
            walletOrderInfoNewUI.IdW = true;
            if (walletOrderInfoNewUI.IdL.equals("-1") || walletOrderInfoNewUI.IdL.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13472, walletOrderInfoNewUI.Cvu, Integer.valueOf(walletOrderInfoNewUI.Ihr.Vgg), 1, Long.valueOf(walletOrderInfoNewUI.Ihr.crw), Long.valueOf(walletOrderInfoNewUI.Ihr.HYE));
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13033, 2, "", walletOrderInfoNewUI.Ihr.url, walletOrderInfoNewUI.Ihr.name, "");
                if (!Util.isNullOrNil(walletOrderInfoNewUI.Ihr.Vgj) && !Util.isNullOrNil(walletOrderInfoNewUI.Ihr.Vgk)) {
                    Log.i("MicroMsg.WalletOrderInfoNewUI", "promotion jump tiny app, username: %s, path: %s, version: %s", walletOrderInfoNewUI.Ihr.Vgj, walletOrderInfoNewUI.Ihr.Vgk, Integer.valueOf(walletOrderInfoNewUI.Ihr.Vgl));
                    walletOrderInfoNewUI.IdH = new b(new StringBuilder().append(walletOrderInfoNewUI.Ihr.crw).toString(), new StringBuilder().append(walletOrderInfoNewUI.Ihr.Vgh).toString(), new StringBuilder().append(walletOrderInfoNewUI.Ihr.HYC).toString(), new StringBuilder().append(walletOrderInfoNewUI.Ihr.HYD).toString(), walletOrderInfoNewUI.getPayReqKey(), walletOrderInfoNewUI.Cvu, walletOrderInfoNewUI.Ihr.HYE, walletOrderInfoNewUI.Ihr.Vgn);
                    wq wqVar = new wq();
                    wqVar.ecI.userName = walletOrderInfoNewUI.Ihr.Vgj;
                    wqVar.ecI.ecK = Util.nullAs(walletOrderInfoNewUI.Ihr.Vgk, "");
                    wqVar.ecI.scene = 1060;
                    wqVar.ecI.dCw = walletOrderInfoNewUI.AJn;
                    wqVar.ecI.ecL = 0;
                    if (walletOrderInfoNewUI.Ihr.Vgl > 0) {
                        wqVar.ecI.appVersion = walletOrderInfoNewUI.Ihr.Vgl;
                    }
                    wqVar.ecI.context = walletOrderInfoNewUI;
                    EventCenter.instance.publish(wqVar);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14118, walletOrderInfoNewUI.AJn, walletOrderInfoNewUI.getPayReqKey(), 2);
                    AppMethodBeat.o(258755);
                    return;
                } else if (walletOrderInfoNewUI.Ihr.Vgg == 1) {
                    Orders.Promotions promotions = walletOrderInfoNewUI.Ihr;
                    Log.i("MicroMsg.WalletOrderInfoNewUI", "doSceneSendPayAward, getAwardParams==null: %s, %s", Boolean.valueOf(Util.isNullOrNil(promotions.Vgm)), promotions.Vgm);
                    if (!Util.isNullOrNil(promotions.Vgm)) {
                        walletOrderInfoNewUI.doSceneForceProgress(new m(promotions.Vgm, promotions.crw));
                        AppMethodBeat.o(258755);
                        return;
                    }
                    walletOrderInfoNewUI.doSceneForceProgress(new s(promotions, walletOrderInfoNewUI.getPayReqKey(), walletOrderInfoNewUI.AJn, promotions.HYE));
                    AppMethodBeat.o(258755);
                    return;
                } else if (walletOrderInfoNewUI.Ihr.Vgg != 2 || Util.isNullOrNil(walletOrderInfoNewUI.Ihr.url)) {
                    Log.e("MicroMsg.WalletOrderInfoNewUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
                } else if (walletOrderInfoNewUI.IdI.containsKey(new StringBuilder().append(walletOrderInfoNewUI.Ihr.crw).toString())) {
                    a aVar = walletOrderInfoNewUI.IdI.get(new StringBuilder().append(walletOrderInfoNewUI.Ihr.crw).toString());
                    Log.i("MicroMsg.WalletOrderInfoNewUI", "go to new url %s", aVar.url);
                    if (!Util.isNullOrNil(aVar.url)) {
                        walletOrderInfoNewUI.ahM(aVar.url);
                        AppMethodBeat.o(258755);
                        return;
                    }
                    walletOrderInfoNewUI.ahM(walletOrderInfoNewUI.Ihr.url);
                    AppMethodBeat.o(258755);
                    return;
                } else {
                    walletOrderInfoNewUI.IdJ = walletOrderInfoNewUI.Ihr.url;
                    String str = walletOrderInfoNewUI.Ihr.url;
                    b bVar = new b(new StringBuilder().append(walletOrderInfoNewUI.Ihr.crw).toString(), new StringBuilder().append(walletOrderInfoNewUI.Ihr.Vgh).toString(), new StringBuilder().append(walletOrderInfoNewUI.Ihr.HYC).toString(), new StringBuilder().append(walletOrderInfoNewUI.Ihr.HYD).toString(), walletOrderInfoNewUI.getPayReqKey(), walletOrderInfoNewUI.Cvu, walletOrderInfoNewUI.Ihr.HYE, walletOrderInfoNewUI.Ihr.Vgn);
                    Log.i("MicroMsg.WalletOrderInfoNewUI", "jumpToH5: %s", str);
                    walletOrderInfoNewUI.fSE();
                    walletOrderInfoNewUI.IdH = bVar;
                    com.tencent.mm.wallet_core.ui.f.a((Context) walletOrderInfoNewUI, str, false, 1);
                    AppMethodBeat.o(258755);
                    return;
                }
            }
        }
        AppMethodBeat.o(258755);
    }

    static /* synthetic */ void B(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        AppMethodBeat.i(258756);
        walletOrderInfoNewUI.IhG.setVisibility(8);
        walletOrderInfoNewUI.IhE.setVisibility(0);
        AppMethodBeat.o(258756);
    }

    static /* synthetic */ void a(WalletOrderInfoNewUI walletOrderInfoNewUI, e.a.a.h hVar) {
        AppMethodBeat.i(258757);
        Log.i("MicroMsg.WalletOrderInfoNewUI", "show card mch alert");
        if (hVar != null) {
            walletOrderInfoNewUI.IhS = true;
            d.a aVar = new d.a(walletOrderInfoNewUI.getContext());
            aVar.bon(hVar.UbG);
            View inflate = View.inflate(walletOrderInfoNewUI.getContext(), R.layout.o3, null);
            ((CdnImageView) inflate.findViewById(R.id.b4o)).setUrl(hVar.UbI);
            ((TextView) inflate.findViewById(R.id.b4n)).setText(hVar.UbH);
            aVar.hs(inflate);
            aVar.bou(hVar.UbJ);
            com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
            hbn.show();
            walletOrderInfoNewUI.addDialog(hbn);
        }
        AppMethodBeat.o(258757);
    }
}
