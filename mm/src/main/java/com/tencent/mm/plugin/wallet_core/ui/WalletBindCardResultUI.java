package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.le;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.zx;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.c.ac;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;

@a(3)
public class WalletBindCardResultUI extends WalletBaseUI {
    private IListener AMo = new IListener<zx>() {
        /* class com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI.AnonymousClass1 */

        {
            AppMethodBeat.i(160882);
            this.__eventId = zx.class.getName().hashCode();
            AppMethodBeat.o(160882);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zx zxVar) {
            AppMethodBeat.i(70748);
            zx zxVar2 = zxVar;
            if (zxVar2 instanceof zx) {
                if (!zxVar2.egC.egD.AKs) {
                    Log.i("MicroMsg.WalletBindCardResultUI", "block pass");
                    AppMethodBeat.o(70748);
                    return true;
                } else if ("1".equals(zxVar2.egC.egD.egd) || "2".equals(zxVar2.egC.egD.egd)) {
                    RealnameGuideHelper realnameGuideHelper = new RealnameGuideHelper();
                    realnameGuideHelper.b(zxVar2.egC.egD.egd, zxVar2.egC.egD.ege, zxVar2.egC.egD.egf, zxVar2.egC.egD.egg, zxVar2.egC.egD.egh, WalletBindCardResultUI.this.mPayInfo == null ? 0 : WalletBindCardResultUI.this.mPayInfo.dVv);
                    Log.i("MicroMsg.WalletBindCardResultUI", "receive guide");
                    WalletBindCardResultUI.this.getInput().putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
            }
            AppMethodBeat.o(70748);
            return false;
        }
    };
    private String APz = null;
    private String Cvu;
    private TextView CwQ;
    private int HYK;
    private BindCardOrder IdC;
    private boolean IdD = false;
    private String IdE;
    private String IdF;
    private s.b IdG;
    private WalletOrderInfoNewUI.b IdH;
    private HashMap<String, WalletOrderInfoNewUI.a> IdI = new HashMap<>();
    private String IdJ;
    private BindCardOrder IdK = null;
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
    private PayInfo mPayInfo;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletBindCardResultUI() {
        AppMethodBeat.i(70755);
        AppMethodBeat.o(70755);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(70756);
        super.onCreate(bundle);
        if (com.tencent.mm.compatible.util.d.oD(21)) {
            if (com.tencent.mm.compatible.util.d.oD(23)) {
                getWindow().setStatusBarColor(getResources().getColor(R.color.afz));
            } else {
                getWindow().setStatusBarColor(getResources().getColor(R.color.BW_90));
            }
        }
        setContentViewVisibility(4);
        com.tencent.mm.wallet_core.a.by(this);
        this.mPayInfo = (PayInfo) getInput().getParcelable("key_pay_info");
        getInput().getInt("key_pay_type", -1);
        BindCardOrder bindCardOrder = (BindCardOrder) getInput().getParcelable("key_bindcard_value_result");
        if (bindCardOrder == null) {
            bindCardOrder = new BindCardOrder();
        }
        this.IdC = bindCardOrder;
        setContentViewVisibility(0);
        initView();
        this.IdY = getProcess();
        fSC();
        qn(1);
        addSceneEndListener(1979);
        EventCenter.instance.addListener(this.AMo);
        this.IdX = true;
        AppMethodBeat.o(70756);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(70757);
        super.onResume();
        Log.i("MicroMsg.WalletBindCardResultUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s", Boolean.valueOf(this.IdX), this.IdK, Boolean.valueOf(this.IdV), Boolean.valueOf(this.IdW), this.IdG);
        if (this.IdX) {
            this.IdX = false;
            AppMethodBeat.o(70757);
        } else if (this.IdK == null || !this.IdW) {
            if (this.IdV && this.IdG != null) {
                doSceneProgress(new ac(new StringBuilder().append(this.IdC.HWA.crw).toString(), new StringBuilder().append(this.IdC.HWA.HYB).toString(), new StringBuilder().append(this.IdC.HWA.HYC).toString(), new StringBuilder().append(this.IdC.HWA.HYD).toString(), this.IdC.HWA.HYE, this.IdC.HWA.HYA, this.IdC.dDj, this.IdC.HWx, this.IdC.HWy, this.IdC.HWy));
            }
            AppMethodBeat.o(70757);
        } else {
            doSceneProgress(new ac(new StringBuilder().append(this.IdK.HWA.crw).toString(), new StringBuilder().append(this.IdK.HWA.HYB).toString(), new StringBuilder().append(this.IdK.HWA.HYC).toString(), new StringBuilder().append(this.IdK.HWA.HYD).toString(), this.IdK.HWA.HYA, this.IdK.HWA.HYE, this.IdC.dDj, this.IdC.HWx, this.IdC.HWy, this.IdC.HWy));
            AppMethodBeat.o(70757);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(70758);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.IdN = (ImageView) findViewById(R.id.jrs);
        this.CwQ = (TextView) findViewById(R.id.g9j);
        this.IdM = (Button) findViewById(R.id.g9f);
        showHomeBtn(false);
        enableBackMenu(false);
        String string = getString(R.string.vl);
        if (this.IdC == null || Util.isNullOrNil(this.IdC.HWt)) {
            this.IdM.setText(string);
        } else {
            this.IdM.setText(this.IdC.HWt);
        }
        this.IdM.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(70749);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletBindCardResultUI.this.done();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70749);
            }
        });
        this.IdU = (ViewGroup) findViewById(R.id.jgk);
        this.IdO = (ViewGroup) findViewById(R.id.inz);
        this.IdP = (CdnImageView) findViewById(R.id.io1);
        this.IdP.setUseSdcardCache(true);
        this.IdQ = (TextView) findViewById(R.id.iny);
        this.IdR = (TextView) findViewById(R.id.io3);
        this.IdT = (Button) findViewById(R.id.inw);
        this.IdS = findViewById(R.id.io0);
        this.IdU.setVisibility(4);
        fSC();
        fSD();
        fSB();
        if (!Util.isNullOrNil(this.IdC.HWv) && !Util.isNullOrNil(this.IdC.HWw)) {
            ((TextView) findViewById(R.id.g9k)).setText(getString(R.string.i8c, new Object[]{this.IdC.HWv, this.IdC.HWw}));
        }
        AppMethodBeat.o(70758);
    }

    private void fSB() {
        AppMethodBeat.i(70759);
        this.IdU.setVisibility(0);
        AppMethodBeat.o(70759);
    }

    private void fSC() {
        AppMethodBeat.i(70760);
        this.CwQ.setText(this.IdC.HWu);
        AppMethodBeat.o(70760);
    }

    private void fSD() {
        AppMethodBeat.i(70761);
        this.IdO.setVisibility(4);
        this.IdW = false;
        this.IdV = false;
        if (this.IdC != null) {
            if (this.IdC.HWA != null) {
                Log.i("MicroMsg.WalletBindCardResultUI", "activityPromotions: %s", this.IdK);
                if (this.IdC != null && ((this.IdC.fQi() || this.IdC.fQk()) && this.IdC.HWA.crw > 0 && !Util.isNullOrNil(this.IdC.HWB.HYF))) {
                    this.IdK = this.IdC;
                    this.IdS.setVisibility(8);
                    this.IdP.setRoundCorner(true);
                    this.IdT.setEnabled(true);
                    this.IdT.setBackgroundResource(R.drawable.k7);
                    this.IdR.setCompoundDrawables(null, null, null, null);
                    WalletOrderInfoNewUI.a aVar = this.IdI.get(new StringBuilder().append(this.IdK.HWA.crw).toString());
                    if (aVar != null) {
                        if (!Util.isNullOrNil(aVar.icon)) {
                            this.IdP.setUrl(aVar.icon);
                        }
                        if (!Util.isNullOrNil(aVar.dQx)) {
                            this.IdQ.setText(aVar.dQx);
                        }
                        if (!Util.isNullOrNil(aVar.IhY)) {
                            this.IdT.setText(aVar.IhY);
                            this.IdT.setBackgroundResource(R.drawable.b48);
                        }
                    } else {
                        this.IdP.setUrl(this.IdC.HWB.Bah);
                        this.IdQ.setText(this.IdC.HWB.name);
                        this.IdT.setText(this.IdC.HWB.HYF);
                    }
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.IdR.getLayoutParams();
                    if (aVar != null && !Util.isNullOrNil(aVar.title)) {
                        this.IdR.setText(aVar.title);
                        layoutParams.addRule(15, 0);
                    } else if (!Util.isNullOrNil(this.IdC.HWB.title)) {
                        this.IdR.setText(this.IdC.HWB.title);
                        layoutParams.addRule(15, 0);
                    } else {
                        this.IdR.setVisibility(8);
                        layoutParams.addRule(15, -1);
                    }
                    this.IdR.setLayoutParams(layoutParams);
                    this.IdT.setVisibility(0);
                    this.IdT.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI.AnonymousClass3 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(70750);
                            b bVar = new b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            Log.i("MicroMsg.WalletBindCardResultUI", "click activity button");
                            WalletBindCardResultUI.b(WalletBindCardResultUI.this);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(70750);
                        }
                    });
                    if (this.IdK.HWA.HYA != 1) {
                        this.IdO.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI.AnonymousClass4 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(70751);
                                b bVar = new b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                Log.i("MicroMsg.WalletBindCardResultUI", "click activity layout");
                                WalletBindCardResultUI.b(WalletBindCardResultUI.this);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(70751);
                            }
                        });
                    }
                    String str = this.IdL;
                    char c2 = 65535;
                    switch (str.hashCode()) {
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                            if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 49:
                            if (str.equals("1")) {
                                c2 = 5;
                                break;
                            }
                            break;
                        case 50:
                            if (str.equals("2")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 51:
                            if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 52:
                            if (str.equals("4")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 1444:
                            if (str.equals("-1")) {
                                c2 = 1;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            this.IdT.setEnabled(false);
                            break;
                    }
                    CharSequence text = this.IdQ.getText();
                    if (!Util.isNullOrNil(text) && text.length() > 9) {
                        this.IdQ.setText(text.subSequence(0, 9));
                        this.IdQ.append("...");
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.IdO.getLayoutParams();
                    marginLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) this, 50);
                    this.IdO.setLayoutParams(marginLayoutParams);
                } else if (this.IdC.HWC != null && !Util.isNullOrNil(this.IdC.HWC.Hwr) && this.IdC.fQj()) {
                    this.IdE = this.IdC.HWC.Hwr;
                    this.IdF = this.IdC.HWC.Hws;
                    this.HYK = this.IdC.HWC.HYK;
                    this.IdG = this.IdC.HWC;
                    this.IdP.setUrl(this.IdC.HWC.HYH);
                    this.IdQ.setText(this.IdC.HWC.HYI);
                    this.IdR.setText(getString(R.string.i5q));
                    this.IdR.setVisibility(0);
                    this.IdP.setRoundCorner(true);
                    this.IdT.setEnabled(true);
                    this.IdT.setBackgroundResource(R.drawable.k7);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.IdR.getLayoutParams();
                    layoutParams2.addRule(15, 0);
                    this.IdR.setLayoutParams(layoutParams2);
                    if (this.IdC.HWA.crw > 0) {
                        if (!Util.isNullOrNil(this.IdC.HWC.HYJ)) {
                            this.IdT.setVisibility(0);
                            this.IdT.setText(this.IdC.HWC.HYJ);
                            this.IdS.setVisibility(8);
                        }
                        WalletOrderInfoNewUI.a aVar2 = this.IdI.get(new StringBuilder().append(this.IdC.HWA.crw).toString());
                        if (aVar2 != null) {
                            if (!Util.isNullOrNil(aVar2.HYH)) {
                                this.IdP.setUrl(aVar2.HYH);
                            }
                            if (!Util.isNullOrNil(aVar2.HYI)) {
                                this.IdQ.setText(aVar2.HYI);
                            }
                            if (!Util.isNullOrNil(aVar2.HYJ)) {
                                this.IdT.setText(aVar2.HYJ);
                                this.IdT.setBackgroundResource(R.drawable.b48);
                            }
                            if (!Util.isNullOrNil(aVar2.Hwr)) {
                                this.IdE = aVar2.Hwr;
                            }
                            if (!Util.isNullOrNil(aVar2.Hws)) {
                                this.IdF = aVar2.Hws;
                            }
                        }
                    } else {
                        this.IdT.setVisibility(8);
                        this.IdS.setVisibility(8);
                    }
                    AnonymousClass5 r0 = new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI.AnonymousClass5 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(70752);
                            b bVar = new b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            Log.i("MicroMsg.WalletBindCardResultUI", "click tiny app, userName: %s, path: %s, version: %s", WalletBindCardResultUI.this.IdE, WalletBindCardResultUI.this.IdF, Integer.valueOf(WalletBindCardResultUI.this.HYK));
                            WalletBindCardResultUI.this.qn(2);
                            wq wqVar = new wq();
                            wqVar.ecI.userName = WalletBindCardResultUI.this.IdE;
                            wqVar.ecI.ecK = Util.nullAs(WalletBindCardResultUI.this.IdF, "");
                            wqVar.ecI.scene = 1034;
                            wqVar.ecI.ecL = 0;
                            if (WalletBindCardResultUI.this.HYK > 0) {
                                wqVar.ecI.appVersion = WalletBindCardResultUI.this.HYK;
                            }
                            EventCenter.instance.publish(wqVar);
                            if (Util.isNullOrNil(WalletBindCardResultUI.this.IdC.HWC.HYJ) || WalletBindCardResultUI.this.IdC.HWA.crw <= 0) {
                                WalletBindCardResultUI.this.IdV = false;
                            } else {
                                WalletBindCardResultUI.this.IdV = true;
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(70752);
                        }
                    };
                    this.IdO.setOnClickListener(r0);
                    this.IdT.setOnClickListener(r0);
                    CharSequence text2 = this.IdQ.getText();
                    if (!Util.isNullOrNil(text2) && text2.length() > 9) {
                        this.IdQ.setText(text2.subSequence(0, 9));
                        this.IdQ.append("...");
                    }
                }
                this.IdO.setVisibility(0);
            }
            if (this.IdQ.getVisibility() == 0) {
                this.IdQ.post(new Runnable() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI.AnonymousClass6 */

                    public final void run() {
                        AppMethodBeat.i(70753);
                        if (WalletBindCardResultUI.this.IdT.getVisibility() == 0 && WalletBindCardResultUI.this.IdQ.getRight() >= WalletBindCardResultUI.this.IdT.getLeft() && !Util.isNullOrNil(WalletBindCardResultUI.this.IdQ.getText())) {
                            float textSize = WalletBindCardResultUI.this.IdQ.getTextSize();
                            Log.i("MicroMsg.WalletBindCardResultUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", Integer.valueOf(WalletBindCardResultUI.this.IdQ.getRight()), Integer.valueOf(WalletBindCardResultUI.this.IdT.getLeft()));
                            Paint paint = new Paint();
                            paint.setTextSize(textSize);
                            String charSequence = WalletBindCardResultUI.this.IdQ.getText().toString();
                            float measureText = paint.measureText(charSequence) - ((float) (WalletBindCardResultUI.this.IdQ.getRight() - WalletBindCardResultUI.this.IdT.getLeft()));
                            int i2 = 1;
                            while (paint.measureText(charSequence.substring(0, (charSequence.length() - i2) - 1)) > measureText && i2 <= charSequence.length() - 1) {
                                i2++;
                            }
                            Log.i("MicroMsg.WalletBindCardResultUI", "tinyAppDescTv, exceed len, final search count: %s, text.length: %s", Integer.valueOf(i2), Integer.valueOf(charSequence.length()));
                            WalletBindCardResultUI.this.IdQ.setText(charSequence.substring(0, (charSequence.length() - i2) - 1));
                            WalletBindCardResultUI.this.IdQ.append("...");
                        }
                        AppMethodBeat.o(70753);
                    }
                });
            }
        }
        if (this.IdO.getVisibility() == 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.IdN.getLayoutParams();
            marginLayoutParams2.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) this, 91);
            this.IdN.setLayoutParams(marginLayoutParams2);
        }
        AppMethodBeat.o(70761);
    }

    private void ahM(String str) {
        AppMethodBeat.i(70762);
        fSE();
        f.p(this, str, false);
        AppMethodBeat.o(70762);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(70763);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.WalletBindCardResultUI", "onActivityResult %d %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 1) {
            Log.i("MicroMsg.WalletBindCardResultUI", "do query pay arawrd");
            doSceneProgress(new ac(this.IdH.HQn, this.IdH.Iia, this.IdH.Iib, this.IdH.Iic, this.IdH.Ian, this.IdH.Iid, this.IdC.dDj, this.IdC.HWx, this.IdC.HWy, this.IdC.HWy));
        }
        AppMethodBeat.o(70763);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    @Deprecated
    public Dialog onCreateDialog(int i2) {
        AppMethodBeat.i(70764);
        Dialog a2 = h.a(getContext(), getString(R.string.ik_), getResources().getStringArray(R.array.ax), "", new h.d() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI.AnonymousClass7 */

            @Override // com.tencent.mm.ui.base.h.d
            public final void oj(int i2) {
                AppMethodBeat.i(70754);
                switch (i2) {
                    case 0:
                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + WalletBindCardResultUI.this.APz));
                        intent.addFlags(268435456);
                        WalletBindCardResultUI walletBindCardResultUI = WalletBindCardResultUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(walletBindCardResultUI, bl.axQ(), "com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$7", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        walletBindCardResultUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(walletBindCardResultUI, "com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$7", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        break;
                }
                AppMethodBeat.o(70754);
            }
        });
        AppMethodBeat.o(70764);
        return a2;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c8b;
    }

    public final void done() {
        AppMethodBeat.i(70765);
        Bundle bundle = new Bundle();
        if (this.IdY != null) {
            this.IdY.a(this, 0, bundle);
            AppMethodBeat.o(70765);
            return;
        }
        finish();
        AppMethodBeat.o(70765);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(70766);
        if (i2 == 4) {
            done();
            AppMethodBeat.o(70766);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(70766);
        return onKeyUp;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(70767);
        super.onDestroy();
        EventCenter.instance.removeListener(this.AMo);
        removeSceneEndListener(1979);
        AppMethodBeat.o(70767);
    }

    private void fSE() {
        int i2 = 0;
        AppMethodBeat.i(70768);
        if (!this.IdD) {
            le leVar = new le();
            leVar.dQr.requestCode = 4;
            le.a aVar = leVar.dQr;
            if (getInput().getBoolean("intent_pay_end", false)) {
                i2 = -1;
            }
            aVar.resultCode = i2;
            EventCenter.instance.publish(leVar);
            this.IdD = true;
        }
        AppMethodBeat.o(70768);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        String string;
        AppMethodBeat.i(70769);
        if (qVar instanceof ac) {
            if (i2 == 0 && i3 == 0) {
                ac acVar = (ac) qVar;
                WalletOrderInfoNewUI.a aVar = new WalletOrderInfoNewUI.a(acVar.lxS);
                if (this.IdH != null) {
                    this.IdI.put(acVar.HQn, aVar);
                    fSD();
                    fSB();
                } else if (this.IdV) {
                    this.IdI.put(acVar.HQn, aVar);
                    fSD();
                    fSB();
                }
            }
        } else if (qVar instanceof r) {
            if (i2 == 0 && i3 == 0) {
                r rVar = (r) qVar;
                String str2 = rVar.HPV;
                if (this.IdK != null && this.IdK.HWA.crw == rVar.HPX.HWA.crw) {
                    Log.i("MicroMsg.WalletBindCardResultUI", "activityAwardState: %s", this.IdK);
                    this.IdL = str2;
                    fSD();
                    fSB();
                    if (!Util.isNullOrNil(rVar.resultMsg) && !TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(str2)) {
                        this.IdT.setText(rVar.resultMsg);
                    }
                }
                if (!"-1".equals(str2) && !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str2) && !Util.isNullOrNil(rVar.HPW)) {
                    h.c(this, rVar.HPW, "", true);
                } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str2)) {
                    if (!Util.isNullOrNil(rVar.HPW)) {
                        string = rVar.HPW;
                    } else {
                        string = getString(R.string.imw);
                    }
                    Toast.makeText(this, string, 0).show();
                }
                AppMethodBeat.o(70769);
                return true;
            }
            if (Util.isNullOrNil(str)) {
                str = getString(R.string.itf);
            }
            h.a((Context) this, str, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI.AnonymousClass8 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            AppMethodBeat.o(70769);
            return true;
        }
        AppMethodBeat.o(70769);
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void setContentViewVisibility(int i2) {
        AppMethodBeat.i(70770);
        getContentView().setVisibility(i2);
        AppMethodBeat.o(70770);
    }

    public final void qn(int i2) {
        AppMethodBeat.i(70771);
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        Object[] objArr = new Object[4];
        objArr[0] = this.IdC.HWA == null ? "" : Util.nullAs(new StringBuilder().append(this.IdC.HWA.crw).toString(), "");
        objArr[1] = this.IdC.HWx;
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = this.IdC.dDj;
        hVar.a(14877, objArr);
        AppMethodBeat.o(70771);
    }

    static /* synthetic */ void b(WalletBindCardResultUI walletBindCardResultUI) {
        AppMethodBeat.i(70772);
        Object[] objArr = new Object[1];
        objArr[0] = Long.valueOf(walletBindCardResultUI.IdK != null ? walletBindCardResultUI.IdK.HWA.crw : 0);
        Log.i("MicroMsg.WalletBindCardResultUI", "onClickActivity, activityId: %s", objArr);
        if (walletBindCardResultUI.IdK != null && walletBindCardResultUI.IdK.HWA.crw > 0) {
            walletBindCardResultUI.qn(2);
            walletBindCardResultUI.IdW = true;
            if (walletBindCardResultUI.IdL.equals("-1") || walletBindCardResultUI.IdL.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                if (walletBindCardResultUI.IdC.fQk()) {
                    BindCardOrder bindCardOrder = walletBindCardResultUI.IdK;
                    walletBindCardResultUI.doSceneForceProgress(new r(bindCardOrder, new StringBuilder().append(bindCardOrder.HWA.crw).toString(), new StringBuilder().append(bindCardOrder.HWA.HYB).toString(), new StringBuilder().append(bindCardOrder.HWA.HYC).toString(), new StringBuilder().append(bindCardOrder.HWA.HYD).toString(), bindCardOrder.HWA.HYE, bindCardOrder.HWA.HYA, walletBindCardResultUI.IdC.dDj, walletBindCardResultUI.IdC.HWx, walletBindCardResultUI.IdC.HWy, walletBindCardResultUI.IdC.HWz));
                    AppMethodBeat.o(70772);
                    return;
                } else if (!walletBindCardResultUI.IdC.fQi() || Util.isNullOrNil(walletBindCardResultUI.IdK.HWB.url)) {
                    Log.e("MicroMsg.WalletBindCardResultUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
                } else if (walletBindCardResultUI.IdI.containsKey(new StringBuilder().append(walletBindCardResultUI.IdK.HWA.crw).toString())) {
                    WalletOrderInfoNewUI.a aVar = walletBindCardResultUI.IdI.get(new StringBuilder().append(walletBindCardResultUI.IdK.HWA.crw).toString());
                    Log.i("MicroMsg.WalletBindCardResultUI", "go to new url %s", aVar.url);
                    if (!Util.isNullOrNil(aVar.url)) {
                        walletBindCardResultUI.ahM(aVar.url);
                        AppMethodBeat.o(70772);
                        return;
                    }
                    walletBindCardResultUI.ahM(walletBindCardResultUI.IdK.HWB.url);
                    AppMethodBeat.o(70772);
                    return;
                } else {
                    walletBindCardResultUI.IdJ = walletBindCardResultUI.IdK.HWB.url;
                    String str = walletBindCardResultUI.IdK.HWB.url;
                    WalletOrderInfoNewUI.b bVar = new WalletOrderInfoNewUI.b(new StringBuilder().append(walletBindCardResultUI.IdK.HWA.crw).toString(), new StringBuilder().append(walletBindCardResultUI.IdK.HWA.HYB).toString(), new StringBuilder().append(walletBindCardResultUI.IdK.HWA.HYC).toString(), new StringBuilder().append(walletBindCardResultUI.IdK.HWA.HYD).toString(), walletBindCardResultUI.getPayReqKey(), walletBindCardResultUI.Cvu, walletBindCardResultUI.IdK.HWA.HYE, walletBindCardResultUI.IdK.HWA.HYA);
                    walletBindCardResultUI.fSE();
                    walletBindCardResultUI.IdH = bVar;
                    f.a((Context) walletBindCardResultUI, str, false, 1);
                    AppMethodBeat.o(70772);
                    return;
                }
            }
        }
        AppMethodBeat.o(70772);
    }
}
