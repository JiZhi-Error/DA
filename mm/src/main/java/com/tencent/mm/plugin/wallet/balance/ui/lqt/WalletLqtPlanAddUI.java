package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.wallet.balance.model.lqt.k;
import com.tencent.mm.plugin.wallet.balance.model.lqt.r;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdNewUI;
import com.tencent.mm.plugin.wallet_core.ui.j;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.protocal.protobuf.cqy;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.ddt;
import com.tencent.mm.protocal.protobuf.dfd;
import com.tencent.mm.protocal.protobuf.dlf;
import com.tencent.mm.protocal.protobuf.dn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.wallet_core.c.a;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.h;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class WalletLqtPlanAddUI extends WalletLqtBasePresenterUI implements WcPayKeyboard.a {
    private static final int Hys = a.fromDPToPix(MMApplicationContext.getContext(), 48);
    private static final int Hyt = a.fromDPToPix(MMApplicationContext.getContext(), 8);
    private IListener<lj> AJa = new IListener<lj>() {
        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass15 */

        {
            AppMethodBeat.i(160855);
            this.__eventId = lj.class.getName().hashCode();
            AppMethodBeat.o(160855);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lj ljVar) {
            AppMethodBeat.i(68849);
            lj ljVar2 = ljVar;
            Log.i("MicroMsg.WalletLqtPlanAddUI", "KindaBindCardEvent callback");
            if (ljVar2 == null || !(ljVar2 instanceof lj)) {
                AppMethodBeat.o(68849);
                return false;
            }
            z.hhs();
            if (ljVar2.dQz != null) {
                if (ljVar2.dQz.dQA) {
                    Log.i("MicroMsg.WalletLqtPlanAddUI", "KindaBindCardEvent bindCard Succ");
                    Log.i("MicroMsg.WalletLqtPlanAddUI", "bind card serial: %s", ljVar2.dQz.dQm);
                    Bankcard a2 = WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this, ljVar2.dQz.dQm);
                    if (a2 != null) {
                        WalletLqtPlanAddUI.this.HyU.Htm = a2.field_bindSerial;
                        WalletLqtPlanAddUI.this.HyU.dDj = a2.field_bankcardType;
                        WalletLqtPlanAddUI.this.HyU.ynT = a2.field_bankName;
                        WalletLqtPlanAddUI.this.HyU.AOk = a2.field_bankcardTail;
                        WalletLqtPlanAddUI.o(WalletLqtPlanAddUI.this);
                    }
                    WalletLqtPlanAddUI.v(WalletLqtPlanAddUI.this);
                } else {
                    Log.i("MicroMsg.WalletLqtPlanAddUI", "KindaBindCardEvent bindCard Cancel");
                }
            }
            EventCenter.instance.removeListener(WalletLqtPlanAddUI.this.AJa);
            AppMethodBeat.o(68849);
            return true;
        }
    };
    private TextView HyA;
    private CdnImageView HyB;
    private TextView HyC;
    private LinearLayout HyD;
    private TextView HyE;
    private LinearLayout HyF;
    private Button HyG;
    private CheckBox HyH;
    private TextView HyI;
    private LinearLayout HyJ;
    private View HyK;
    private View HyL;
    private View HyM;
    private com.tencent.mm.plugin.wallet.balance.model.lqt.z HyN = ((com.tencent.mm.plugin.wallet.balance.model.lqt.z) aq(com.tencent.mm.plugin.wallet.balance.model.lqt.z.class));
    private boolean HyO = false;
    private String HyP;
    private List<Bankcard> HyQ = new ArrayList();
    private cda HyR;
    private dfd HyS;
    private boolean HyT;
    private dbt HyU = new dbt();
    private LinearLayout HyV;
    private long HyW;
    private int HyX;
    private String HyY;
    private String HyZ;
    private ScrollView Hyu;
    private TextView Hyv;
    private TextView Hyw;
    private TextView Hyx;
    private TextView Hyy;
    private WalletFormView Hyz;
    private String[] Hza;
    private Button Hzb;
    private Button Hzc;
    private Button Hzd;
    private RelativeLayout Hze;
    private List<dlf> Hzf = new ArrayList();
    private boolean Hzg = false;
    private boolean Hzh = true;
    private boolean Hzi = true;
    private WcPayKeyboard jVg;
    private int mMode;
    private com.tencent.mm.wallet_core.ui.a mTenpayKBStateListener;
    private String mTitle;
    private int ygg = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletLqtPlanAddUI() {
        AppMethodBeat.i(68865);
        AppMethodBeat.o(68865);
    }

    static /* synthetic */ Bankcard a(WalletLqtPlanAddUI walletLqtPlanAddUI, String str) {
        AppMethodBeat.i(68893);
        Bankcard aUM = walletLqtPlanAddUI.aUM(str);
        AppMethodBeat.o(68893);
        return aUM;
    }

    static /* synthetic */ void h(WalletLqtPlanAddUI walletLqtPlanAddUI) {
        AppMethodBeat.i(68887);
        walletLqtPlanAddUI.fNL();
        AppMethodBeat.o(68887);
    }

    static /* synthetic */ void o(WalletLqtPlanAddUI walletLqtPlanAddUI) {
        AppMethodBeat.i(68890);
        walletLqtPlanAddUI.fNJ();
        AppMethodBeat.o(68890);
    }

    static /* synthetic */ void q(WalletLqtPlanAddUI walletLqtPlanAddUI) {
        AppMethodBeat.i(68892);
        walletLqtPlanAddUI.fNK();
        AppMethodBeat.o(68892);
    }

    static /* synthetic */ void v(WalletLqtPlanAddUI walletLqtPlanAddUI) {
        AppMethodBeat.i(68894);
        walletLqtPlanAddUI.xN(false);
        AppMethodBeat.o(68894);
    }

    static {
        AppMethodBeat.i(68896);
        AppMethodBeat.o(68896);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68866);
        fixStatusbar(true);
        super.onCreate(bundle);
        setMMTitle("");
        setActionbarColor(getResources().getColor(R.color.afz));
        hideActionbarLine();
        this.mMode = getIntent().getIntExtra("key_mode", 0);
        if (this.mMode == 2) {
            try {
                dbt dbt = new dbt();
                byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_plan_item");
                if (byteArrayExtra != null) {
                    this.HyU = (dbt) dbt.parseFrom(byteArrayExtra);
                    this.HyW = this.HyU.eht;
                    this.HyX = this.HyU.grV;
                    this.HyY = this.HyU.Htm;
                }
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.WalletLqtPlanAddUI", e2, "", new Object[0]);
            }
        }
        this.Hza = new String[28];
        for (int i2 = 0; i2 < 28; i2++) {
            this.Hza[i2] = getString(R.string.ihc, new Object[]{String.valueOf(i2 + 1)});
        }
        initView();
        updateView();
        xN(true);
        AppMethodBeat.o(68866);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(68867);
        this.Hyu = (ScrollView) findViewById(R.id.euv);
        this.Hyv = (TextView) findViewById(R.id.eum);
        this.Hyw = (TextView) findViewById(R.id.eul);
        this.Hyx = (TextView) findViewById(R.id.euq);
        this.Hyy = (TextView) findViewById(R.id.euo);
        this.Hyz = (WalletFormView) findViewById(R.id.eug);
        this.HyA = (TextView) findViewById(R.id.euf);
        this.HyB = (CdnImageView) findViewById(R.id.eu_);
        this.HyC = (TextView) findViewById(R.id.eub);
        this.HyD = (LinearLayout) findViewById(R.id.eua);
        this.HyE = (TextView) findViewById(R.id.eur);
        this.HyF = (LinearLayout) findViewById(R.id.eup);
        this.HyG = (Button) findViewById(R.id.eud);
        this.HyH = (CheckBox) findViewById(R.id.eus);
        this.HyI = (TextView) findViewById(R.id.euu);
        this.HyJ = (LinearLayout) findViewById(R.id.eut);
        this.HyV = (LinearLayout) findViewById(R.id.eue);
        this.jVg = (WcPayKeyboard) findViewById(R.id.joy);
        this.HyK = findViewById(R.id.euw);
        this.HyL = findViewById(R.id.eux);
        this.HyM = findViewById(R.id.euc);
        this.Hze = (RelativeLayout) findViewById(R.id.gvk);
        this.Hzb = (Button) findViewById(R.id.gvl);
        this.Hzc = (Button) findViewById(R.id.gvm);
        this.Hzd = (Button) findViewById(R.id.gvn);
        this.Hyz.setContentPadding$3b4dfe4b(0);
        this.Hyz.setTitleText(ah.hhz());
        setWPKeyboard(this.Hyz.getContentEt(), false, false);
        if (d.oD(28)) {
            this.Hyz.post(new Runnable() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(68833);
                    WalletFormView walletFormView = WalletLqtPlanAddUI.this.Hyz;
                    if (walletFormView.Rwe != null) {
                        walletFormView.Rwe.setFocusable(true);
                        walletFormView.Rwe.requestFocus();
                    }
                    AppMethodBeat.o(68833);
                }
            });
        }
        this.jVg.setActionText(getString(R.string.z9));
        this.jVg.DH(false);
        ((RelativeLayout.LayoutParams) this.jVg.getLayoutParams()).addRule(12);
        this.Hyz.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass12 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(68846);
                if (keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 66) {
                    Log.i("MicroMsg.WalletLqtPlanAddUI", "click enter");
                    WalletLqtPlanAddUI.this.hideWcKb();
                    AppMethodBeat.o(68846);
                } else {
                    AppMethodBeat.o(68846);
                }
                return true;
            }
        });
        this.HyG.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass23 */

            public final void onClick(View view) {
                AppMethodBeat.i(68857);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (WalletLqtPlanAddUI.this.jVg.isShown()) {
                    WalletLqtPlanAddUI.this.hideWcKb();
                }
                Log.i("MicroMsg.WalletLqtPlanAddUI", "click btn");
                WalletLqtPlanAddUI.c(WalletLqtPlanAddUI.this);
                if (!WalletLqtPlanAddUI.this.HyG.isEnabled()) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(68857);
                    return;
                }
                if (WalletLqtPlanAddUI.this.mMode == 1) {
                    WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this, 0);
                } else {
                    WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this, 4);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68857);
            }
        });
        this.HyH.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass24 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(68858);
                WalletLqtPlanAddUI.c(WalletLqtPlanAddUI.this);
                AppMethodBeat.o(68858);
            }
        });
        this.HyD.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass25 */

            public final void onClick(View view) {
                AppMethodBeat.i(68859);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletLqtPlanAddUI.f(WalletLqtPlanAddUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68859);
            }
        });
        this.HyF.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass26 */

            public final void onClick(View view) {
                AppMethodBeat.i(68860);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletLqtPlanAddUI.g(WalletLqtPlanAddUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68860);
            }
        });
        this.Hyz.a(new TextWatcher() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass27 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(68861);
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 2) {
                    editable.delete(indexOf + 3, length);
                }
                WalletLqtPlanAddUI.h(WalletLqtPlanAddUI.this);
                WalletLqtPlanAddUI.c(WalletLqtPlanAddUI.this);
                if (length == 0) {
                    WalletLqtPlanAddUI.this.jVg.DH(false);
                    AppMethodBeat.o(68861);
                    return;
                }
                WalletLqtPlanAddUI.this.jVg.DH(true);
                AppMethodBeat.o(68861);
            }
        });
        this.mTenpayKBStateListener = new com.tencent.mm.wallet_core.ui.a() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass28 */

            @Override // com.tencent.mm.wallet_core.ui.a
            public final void onVisibleStateChange(final boolean z) {
                AppMethodBeat.i(68863);
                Log.i("MicroMsg.WalletLqtPlanAddUI", "onVisibleStateChange() visitable:%s", Boolean.valueOf(z));
                if (WalletLqtPlanAddUI.this.jVg.hgS()) {
                    AppMethodBeat.o(68863);
                    return;
                }
                WalletLqtPlanAddUI.this.mWcKeyboard.post(new Runnable() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass28.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(68862);
                        WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this, z);
                        AppMethodBeat.o(68862);
                    }
                });
                AppMethodBeat.o(68863);
            }
        };
        setTenpayKBStateListener(this.mTenpayKBStateListener);
        this.Hyu.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass29 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(68864);
                if (!WalletLqtPlanAddUI.this.mWcKeyboard.isShown() || !WalletLqtPlanAddUI.this.mWcKeyboard.hgP()) {
                    AppMethodBeat.o(68864);
                    return false;
                }
                WalletLqtPlanAddUI.this.hideWcKb();
                AppMethodBeat.o(68864);
                return true;
            }
        });
        setResult(0);
        this.Hze.setVisibility(8);
        e(this.Hzb);
        e(this.Hzc);
        e(this.Hzd);
        setWcKbHeightListener(this);
        AppMethodBeat.o(68867);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(68868);
        super.onDestroy();
        AppMethodBeat.o(68868);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI
    public int getLayoutId() {
        return R.layout.b3a;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(68869);
        if (!this.jVg.isShown() || !Util.isNullOrNil(this.Hyz.getText())) {
            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(68869);
            return onKeyUp;
        }
        hideWcKb();
        AppMethodBeat.o(68869);
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(68870);
        Log.i("MicroMsg.WalletLqtPlanAddUI", "activity result: %s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0) {
            if (i3 == -1) {
                String stringExtra = intent.getStringExtra("encrypt_pwd");
                int nE = f.nE(this.Hyz.getText(), "100");
                String str = this.HyU.dDj;
                String str2 = this.HyU.AOk;
                String str3 = this.HyU.Htm;
                int i4 = this.HyU.grV;
                int i5 = this.HyU.Htr;
                final Dialog c2 = h.c(getContext(), false, null);
                g.a(stringExtra, str, str2, str3, Integer.valueOf(nE), Integer.valueOf(i4), Integer.valueOf(i5)).c(this.HyN.Hue).f(new com.tencent.mm.vending.c.a<Object, dn>() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass5 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ Object call(dn dnVar) {
                        AppMethodBeat.i(68838);
                        c2.dismiss();
                        WalletLqtPlanAddUI.this.setResult(-1);
                        WalletLqtPlanAddUI.this.finish();
                        AppMethodBeat.o(68838);
                        return null;
                    }
                }).a(new d.a() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass4 */

                    @Override // com.tencent.mm.vending.g.d.a
                    public final void cn(Object obj) {
                        AppMethodBeat.i(68837);
                        c2.dismiss();
                        if (obj instanceof m) {
                            ((m) obj).G(WalletLqtPlanAddUI.this.getContext(), false);
                        }
                        AppMethodBeat.o(68837);
                    }
                });
            }
        } else if (i2 == 4 && i3 == -1) {
            String stringExtra2 = intent.getStringExtra("encrypt_pwd");
            int nE2 = f.nE(this.Hyz.getText(), "100");
            int i6 = this.HyU.Htr;
            String str4 = this.HyU.dDj;
            String str5 = this.HyU.AOk;
            String str6 = this.HyU.Htm;
            int i7 = this.HyU.grV;
            final Dialog c3 = h.c(getContext(), false, null);
            g.a(Integer.valueOf(i6), str4, str5, str6, Integer.valueOf(nE2), Integer.valueOf(i7), stringExtra2).c(this.HyN.Huf).f(new com.tencent.mm.vending.c.a<Object, cqy>() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass7 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Object call(cqy cqy) {
                    AppMethodBeat.i(68840);
                    c3.dismiss();
                    WalletLqtPlanAddUI.this.setResult(-1);
                    WalletLqtPlanAddUI.this.finish();
                    AppMethodBeat.o(68840);
                    return null;
                }
            }).a(new d.a() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass6 */

                @Override // com.tencent.mm.vending.g.d.a
                public final void cn(Object obj) {
                    AppMethodBeat.i(68839);
                    c3.dismiss();
                    if (obj instanceof m) {
                        ((m) obj).G(WalletLqtPlanAddUI.this.getContext(), false);
                    }
                    AppMethodBeat.o(68839);
                }
            });
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(68870);
    }

    private void xN(final boolean z) {
        int i2;
        final Dialog dialog = null;
        AppMethodBeat.i(68871);
        Log.i("MicroMsg.WalletLqtPlanAddUI", "do pre add plan: %s", Boolean.valueOf(z));
        if (this.mMode != 2 || this.HyU == null) {
            i2 = 0;
        } else {
            i2 = this.HyU.Htr;
            dialog = h.c(getContext(), false, null);
        }
        r rVar = new r();
        rVar.b(new k(this.mMode, i2));
        rVar.a(new a.AbstractC2168a<ddt>() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int] */
            @Override // com.tencent.mm.wallet_core.c.a.AbstractC2168a
            public final /* synthetic */ void d(ddt ddt, int i2, int i3) {
                AppMethodBeat.i(258731);
                ddt ddt2 = ddt;
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (ddt2 == null) {
                    m.jU(0, 0).G(WalletLqtPlanAddUI.this.getContext(), true);
                    AppMethodBeat.o(258731);
                } else if (ddt2.pTZ == 0) {
                    WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this, ddt2, z);
                    AppMethodBeat.o(258731);
                } else {
                    m.a(true, ddt2.pTZ, 0, ddt2.pUa).G(WalletLqtPlanAddUI.this.getContext(), true);
                    AppMethodBeat.o(258731);
                }
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.wallet_core.c.a.AbstractC2168a
            public final /* synthetic */ void dx(ddt ddt) {
                AppMethodBeat.i(68836);
                ddt ddt2 = ddt;
                if (ddt2 != null) {
                    WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this, ddt2, z);
                }
                AppMethodBeat.o(68836);
            }
        }, 0);
        AppMethodBeat.o(68871);
    }

    private void updateView() {
        AppMethodBeat.i(68872);
        fNI();
        fNJ();
        fNK();
        fNM();
        fNL();
        this.Hyu.post(new Runnable() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(68843);
                if (WalletLqtPlanAddUI.this.HyM != null) {
                    WalletLqtPlanAddUI.this.HyM.setVisibility(0);
                }
                p.a((Context) WalletLqtPlanAddUI.this, WalletLqtPlanAddUI.this.Hyu, WalletLqtPlanAddUI.this.findViewById(R.id.g8q), WalletLqtPlanAddUI.this.HyK, WalletLqtPlanAddUI.this.HyM, 24);
                AppMethodBeat.o(68843);
            }
        });
        AppMethodBeat.o(68872);
    }

    private void fNI() {
        AppMethodBeat.i(68873);
        if (this.mMode == 2) {
            BigDecimal b2 = f.b(new StringBuilder().append(this.HyU.eht).toString(), "100", 2, RoundingMode.HALF_UP);
            if (((double) b2.intValue()) == b2.doubleValue()) {
                this.Hyz.setText(new StringBuilder().append(b2.intValue()).toString());
                AppMethodBeat.o(68873);
                return;
            }
            this.Hyz.setText(b2.toString());
        }
        AppMethodBeat.o(68873);
    }

    private void fNJ() {
        AppMethodBeat.i(68874);
        final Bankcard aUM = aUM(this.HyU.Htm);
        if (aUM != null) {
            this.Hyy.setVisibility(8);
            if (Util.isNullOrNil(aUM.field_bankcardTypeName)) {
                this.HyC.setText(String.format("%s(%s)", this.HyU.ynT, this.HyU.AOk));
            } else {
                this.HyC.setText(String.format("%s %s(%s)", this.HyU.ynT, aUM.field_bankcardTypeName, this.HyU.AOk));
            }
            this.HyB.setTag(this.HyU.Htm);
            if (aUM.fQb()) {
                this.HyB.setImageResource(R.drawable.cqo);
                AppMethodBeat.o(68874);
                return;
            }
            String str = "";
            e j2 = com.tencent.mm.plugin.wallet_core.d.b.j(this, aUM.field_bankcardType, aUM.fQa());
            if (j2 != null) {
                str = j2.AAU;
            }
            Bitmap a2 = u.a(new c(str));
            if (a2 != null) {
                this.HyB.setImageBitmap(a2);
            }
            u.a(new u.a() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass11 */

                @Override // com.tencent.mm.platformtools.u.a
                public final void k(String str, final Bitmap bitmap) {
                    AppMethodBeat.i(68845);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass11.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(68844);
                            if (!(aUM == null || WalletLqtPlanAddUI.this.HyB.getTag() == null || !WalletLqtPlanAddUI.this.HyB.getTag().equals(aUM.field_bindSerial))) {
                                WalletLqtPlanAddUI.this.HyB.setImageBitmap(bitmap);
                            }
                            AppMethodBeat.o(68844);
                        }
                    });
                    AppMethodBeat.o(68845);
                }
            });
            AppMethodBeat.o(68874);
            return;
        }
        this.Hyy.setVisibility(0);
        AppMethodBeat.o(68874);
    }

    private void fNK() {
        AppMethodBeat.i(68875);
        int i2 = this.HyU.grV - 1;
        Log.i("MicroMsg.WalletLqtPlanAddUI", "select day index: %s", Integer.valueOf(i2));
        if (i2 < 0 || i2 >= this.Hza.length) {
            this.Hyx.setVisibility(0);
            AppMethodBeat.o(68875);
            return;
        }
        this.Hyx.setVisibility(8);
        this.HyE.setText(this.Hza[i2]);
        AppMethodBeat.o(68875);
    }

    private void fNL() {
        AppMethodBeat.i(68876);
        double d2 = Util.getDouble(this.Hyz.getText(), 0.0d);
        Log.i("MicroMsg.WalletLqtPlanAddUI", "money: %s", Double.valueOf(d2));
        Bankcard aUM = aUM(this.HyU.Htm);
        if (aUM == null || d2 <= aUM.field_dayQuotaKind) {
            this.HyA.setText(this.HyP);
            this.HyA.setTextColor(getResources().getColor(R.color.a2t));
            this.HyV.setVisibility(0);
            AppMethodBeat.o(68876);
            return;
        }
        Log.i("MicroMsg.WalletLqtPlanAddUI", "show over alert");
        this.HyA.setText(this.HyZ);
        this.HyA.setTextColor(getResources().getColor(R.color.a5e));
        this.HyV.setVisibility(0);
        AppMethodBeat.o(68876);
    }

    private void fNM() {
        AppMethodBeat.i(68877);
        if (this.HyS == null || Util.isNullOrNil(this.HyS.title)) {
            this.HyJ.setVisibility(8);
            AppMethodBeat.o(68877);
            return;
        }
        this.HyI.setClickable(true);
        this.HyI.setOnTouchListener(new o(this));
        q qVar = new q(new q.a() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass13 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
            public final void dF(View view) {
                AppMethodBeat.i(68847);
                f.p(WalletLqtPlanAddUI.this.getContext(), WalletLqtPlanAddUI.this.HyS.url, true);
                AppMethodBeat.o(68847);
            }
        });
        String string = getString(R.string.ihr);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        spannableStringBuilder.append((CharSequence) this.HyS.title);
        spannableStringBuilder.setSpan(qVar, string.length(), spannableStringBuilder.length(), 18);
        this.HyI.setText(spannableStringBuilder);
        if (this.HyS.MKd) {
            this.HyH.setChecked(true);
        }
        this.HyJ.setVisibility(0);
        AppMethodBeat.o(68877);
    }

    private Bankcard aUM(String str) {
        AppMethodBeat.i(68878);
        for (Bankcard bankcard : this.HyQ) {
            if (bankcard.field_bindSerial.equals(str)) {
                AppMethodBeat.o(68878);
                return bankcard;
            }
        }
        Bankcard aVm = t.fQI().aVm(str);
        AppMethodBeat.o(68878);
        return aVm;
    }

    private void e(final Button button) {
        AppMethodBeat.i(68879);
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass16 */

            public final void onClick(View view) {
                AppMethodBeat.i(68850);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletLqtPlanAddUI.this.Hyz.setText(button.getText().toString().substring(1));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanAddUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68850);
            }
        });
        AppMethodBeat.o(68879);
    }

    private static String LR(long j2) {
        AppMethodBeat.i(68880);
        String valueOf = String.valueOf(j2);
        if (valueOf.length() == 1) {
            String concat = "0.0".concat(String.valueOf(j2));
            AppMethodBeat.o(68880);
            return concat;
        } else if (valueOf.length() == 2) {
            String concat2 = "0.".concat(String.valueOf(j2));
            AppMethodBeat.o(68880);
            return concat2;
        } else {
            String substring = valueOf.substring(0, valueOf.length() - 2);
            AppMethodBeat.o(68880);
            return substring;
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void hideWcKb() {
        AppMethodBeat.i(68881);
        if (this.mWcKeyboard != null) {
            if (this.mTenpayKBStateListener != null) {
                this.mTenpayKBStateListener.onVisibleStateChange(false);
            }
            this.mWcKeyboard.hideWcKb();
        }
        AppMethodBeat.o(68881);
    }

    @Override // com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a
    public final void bO(float f2) {
        boolean z;
        AppMethodBeat.i(68882);
        Log.i("MicroMsg.WalletLqtPlanAddUI", "onUpdateWcPayKeyboardHeight");
        if (this.Hzi) {
            this.Hzi = false;
            int height = ((WindowManager) getSystemService("window")).getDefaultDisplay().getHeight();
            Rect rect = new Rect();
            this.HyD.getGlobalVisibleRect(rect);
            Log.i("MicroMsg.WalletLqtPlanAddUI", "screenHeight：%s，mWcKeyboard.getHeight():%s,pageBottomRect.bottom:%s", Integer.valueOf(height), Integer.valueOf(this.mWcKeyboard.getHeight()), Integer.valueOf(rect.bottom));
            if ((height - this.mWcKeyboard.getHeight()) - rect.bottom > at.fromDPToPix(this, 22)) {
                z = false;
            } else {
                z = true;
            }
            this.Hzh = z;
        }
        AppMethodBeat.o(68882);
    }

    static /* synthetic */ void c(WalletLqtPlanAddUI walletLqtPlanAddUI) {
        AppMethodBeat.i(68883);
        double d2 = Util.getDouble(walletLqtPlanAddUI.Hyz.getText(), 0.0d);
        Bankcard aUM = walletLqtPlanAddUI.aUM(walletLqtPlanAddUI.HyU.Htm);
        Log.i("MicroMsg.WalletLqtPlanAddUI", "mode: %s, money: %s, bankcard: %s, day: %s", Integer.valueOf(walletLqtPlanAddUI.mMode), Double.valueOf(d2), walletLqtPlanAddUI.HyU.dDj, Integer.valueOf(walletLqtPlanAddUI.HyU.grV));
        if (aUM == null || walletLqtPlanAddUI.HyU.grV <= 0 || d2 <= 0.0d || d2 > aUM.field_onceQuotaKind || (walletLqtPlanAddUI.HyJ.getVisibility() == 0 && !walletLqtPlanAddUI.HyH.isChecked())) {
            walletLqtPlanAddUI.HyG.setEnabled(false);
            AppMethodBeat.o(68883);
        } else if (walletLqtPlanAddUI.mMode == 2 && f.b(String.valueOf(d2), "100", RoundingMode.HALF_UP) == ((double) walletLqtPlanAddUI.HyW) && walletLqtPlanAddUI.HyU.grV == walletLqtPlanAddUI.HyX && walletLqtPlanAddUI.HyU.Htm.equals(walletLqtPlanAddUI.HyY)) {
            Log.i("MicroMsg.WalletLqtPlanAddUI", "no changed old");
            walletLqtPlanAddUI.HyG.setEnabled(false);
            AppMethodBeat.o(68883);
        } else {
            walletLqtPlanAddUI.HyG.setEnabled(true);
            AppMethodBeat.o(68883);
        }
    }

    static /* synthetic */ void a(WalletLqtPlanAddUI walletLqtPlanAddUI, int i2) {
        AppMethodBeat.i(68884);
        Log.i("MicroMsg.WalletLqtPlanAddUI", "go to check pwd");
        Intent intent = new Intent(walletLqtPlanAddUI, WalletCheckPwdNewUI.class);
        intent.putExtra("scene", 3);
        intent.putExtra("title", com.tencent.mm.plugin.wallet.balance.model.lqt.ah.aeo(i2));
        walletLqtPlanAddUI.startActivityForResult(intent, i2);
        AppMethodBeat.o(68884);
    }

    static /* synthetic */ void f(WalletLqtPlanAddUI walletLqtPlanAddUI) {
        AppMethodBeat.i(68885);
        Log.i("MicroMsg.WalletLqtPlanAddUI", "show bankcard menu");
        if (walletLqtPlanAddUI.jVg.isShown()) {
            walletLqtPlanAddUI.hideWcKb();
        }
        j.a(walletLqtPlanAddUI, walletLqtPlanAddUI.HyQ, walletLqtPlanAddUI.aUM(walletLqtPlanAddUI.HyU.Htm), walletLqtPlanAddUI.getString(R.string.ih5), "", !walletLqtPlanAddUI.HyT, walletLqtPlanAddUI.getString(R.string.ih7), new o.g() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass8 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(68841);
                if (i2 < WalletLqtPlanAddUI.this.HyQ.size()) {
                    Bankcard bankcard = (Bankcard) WalletLqtPlanAddUI.this.HyQ.get(i2);
                    WalletLqtPlanAddUI.this.HyU.Htm = bankcard.field_bindSerial;
                    WalletLqtPlanAddUI.this.HyU.dDj = bankcard.field_bankcardType;
                    WalletLqtPlanAddUI.this.HyU.ynT = bankcard.field_bankName;
                    WalletLqtPlanAddUI.this.HyU.AOk = bankcard.field_bankcardTail;
                    WalletLqtPlanAddUI.o(WalletLqtPlanAddUI.this);
                    WalletLqtPlanAddUI.h(WalletLqtPlanAddUI.this);
                    WalletLqtPlanAddUI.c(WalletLqtPlanAddUI.this);
                    AppMethodBeat.o(68841);
                    return;
                }
                WalletLqtPlanAddUI.p(WalletLqtPlanAddUI.this);
                AppMethodBeat.o(68841);
            }
        });
        AppMethodBeat.o(68885);
    }

    static /* synthetic */ void g(WalletLqtPlanAddUI walletLqtPlanAddUI) {
        AppMethodBeat.i(68886);
        Log.i("MicroMsg.WalletLqtPlanAddUI", "show date picker");
        if (walletLqtPlanAddUI.jVg.isShown()) {
            walletLqtPlanAddUI.hideWcKb();
        }
        final com.tencent.mm.ui.widget.picker.c cVar = new com.tencent.mm.ui.widget.picker.c(walletLqtPlanAddUI, walletLqtPlanAddUI.Hza);
        if (walletLqtPlanAddUI.HyU.grV - 1 >= 0) {
            cVar.app(walletLqtPlanAddUI.HyU.grV - 1);
        }
        cVar.QTc = new c.b() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass9 */

            @Override // com.tencent.mm.ui.widget.picker.c.b
            public final void onResult(boolean z, Object obj, Object obj2) {
                AppMethodBeat.i(68842);
                cVar.hide();
                if (z) {
                    WalletLqtPlanAddUI.this.HyU.grV = cVar.hci() + 1;
                    WalletLqtPlanAddUI.q(WalletLqtPlanAddUI.this);
                    WalletLqtPlanAddUI.c(WalletLqtPlanAddUI.this);
                }
                AppMethodBeat.o(68842);
            }
        };
        cVar.show();
        AppMethodBeat.o(68886);
    }

    static /* synthetic */ void a(WalletLqtPlanAddUI walletLqtPlanAddUI, boolean z) {
        AppMethodBeat.i(68888);
        final float fromDPToPix = (float) com.tencent.mm.cb.a.fromDPToPix((Context) walletLqtPlanAddUI, 56);
        final float fromDPToPix2 = (float) com.tencent.mm.cb.a.fromDPToPix((Context) walletLqtPlanAddUI, 86);
        if (!z || walletLqtPlanAddUI.Hzg) {
            if (!z && walletLqtPlanAddUI.Hzg) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(walletLqtPlanAddUI.HyL, "translationY", (float) (-walletLqtPlanAddUI.ygg), 0.0f);
                ofFloat.setDuration(300L);
                ofFloat.setInterpolator(new LinearInterpolator());
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass21 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(68855);
                        int abs = (int) Math.abs(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        if (((float) abs) < fromDPToPix || ((float) abs) > fromDPToPix2) {
                            if (WalletLqtPlanAddUI.this.HyO) {
                                WalletLqtPlanAddUI.this.setTitleAlpha(0.0f);
                                WalletLqtPlanAddUI.this.setMMTitle("");
                            }
                            WalletLqtPlanAddUI.this.HyO = false;
                        } else {
                            WalletLqtPlanAddUI.this.HyO = true;
                            float f2 = (((float) abs) - fromDPToPix) / (fromDPToPix2 - fromDPToPix);
                            WalletLqtPlanAddUI.this.setTitleAlpha(f2);
                            Log.d("MicroMsg.WalletLqtPlanAddUI", "onAnimationUpdate alpha:%s", Float.valueOf(f2));
                        }
                        Log.d("MicroMsg.WalletLqtPlanAddUI", "downMoveAnimator onAnimationUpdate() translationY:%s", Integer.valueOf(abs));
                        AppMethodBeat.o(68855);
                    }
                });
                ofFloat.start();
                walletLqtPlanAddUI.jVg.post(new Runnable() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass22 */

                    public final void run() {
                        AppMethodBeat.i(68856);
                        WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this, Boolean.FALSE);
                        AppMethodBeat.o(68856);
                    }
                });
                walletLqtPlanAddUI.Hzg = z;
            }
            AppMethodBeat.o(68888);
            return;
        }
        if (walletLqtPlanAddUI.ygg == 0) {
            walletLqtPlanAddUI.ygg = walletLqtPlanAddUI.Hyw.getBottom() + com.tencent.mm.cb.a.fromDPToPix((Context) walletLqtPlanAddUI, 6);
        }
        if (walletLqtPlanAddUI.ygg == 0) {
            walletLqtPlanAddUI.ygg = com.tencent.mm.cb.a.fromDPToPix((Context) walletLqtPlanAddUI, 132);
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(walletLqtPlanAddUI.HyL, "translationY", 0.0f, (float) (-walletLqtPlanAddUI.ygg));
        ofFloat2.setDuration(300L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass19 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                String str;
                AppMethodBeat.i(68853);
                int abs = (int) Math.abs(((Float) valueAnimator.getAnimatedValue()).floatValue());
                if (((float) abs) < fromDPToPix || ((float) abs) > fromDPToPix2) {
                    if (WalletLqtPlanAddUI.this.HyO) {
                        WalletLqtPlanAddUI.this.setActionbarColor(WalletLqtPlanAddUI.this.getResources().getColor(R.color.afz));
                    }
                    WalletLqtPlanAddUI.this.HyO = false;
                } else {
                    if (!WalletLqtPlanAddUI.this.HyO) {
                        WalletLqtPlanAddUI.this.setTitleAlpha(0.0f);
                        if (Util.isNullOrNil(WalletLqtPlanAddUI.this.mTitle)) {
                            str = WalletLqtPlanAddUI.this.getString(R.string.ii7);
                        } else {
                            str = WalletLqtPlanAddUI.this.mTitle;
                        }
                        WalletLqtPlanAddUI.this.setMMTitle(str);
                    }
                    WalletLqtPlanAddUI.this.HyO = true;
                    float f2 = (((float) abs) - fromDPToPix) / (fromDPToPix2 - fromDPToPix);
                    WalletLqtPlanAddUI.this.setTitleAlpha(f2);
                    Log.d("MicroMsg.WalletLqtPlanAddUI", "onAnimationUpdate alpha:%s", Float.valueOf(f2));
                }
                Log.d("MicroMsg.WalletLqtPlanAddUI", "upMoveAnimator onAnimationUpdate() translationY:%s", Integer.valueOf(abs));
                AppMethodBeat.o(68853);
            }
        });
        if (!walletLqtPlanAddUI.Hzh) {
            Log.i("MicroMsg.WalletLqtPlanAddUI", "do not Scroll Lv ");
            AppMethodBeat.o(68888);
            return;
        }
        ofFloat2.start();
        walletLqtPlanAddUI.jVg.post(new Runnable() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass20 */

            public final void run() {
                AppMethodBeat.i(68854);
                WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this, Boolean.TRUE);
                AppMethodBeat.o(68854);
            }
        });
        walletLqtPlanAddUI.Hzg = z;
        AppMethodBeat.o(68888);
    }

    static /* synthetic */ void a(WalletLqtPlanAddUI walletLqtPlanAddUI, ddt ddt, boolean z) {
        Bankcard aUM;
        AppMethodBeat.i(68889);
        walletLqtPlanAddUI.HyR = ddt.MII;
        walletLqtPlanAddUI.HyS = ddt.MIJ;
        walletLqtPlanAddUI.HyT = ddt.MpH;
        walletLqtPlanAddUI.HyZ = ddt.MIK;
        walletLqtPlanAddUI.mTitle = ddt.Htl;
        walletLqtPlanAddUI.HyP = ddt.MIO;
        walletLqtPlanAddUI.Hzf = ddt.MIR;
        if (ddt.LSL != null && !ddt.LSL.isEmpty()) {
            Log.i("MicroMsg.WalletLqtPlanAddUI", "array size: %s", ddt.LSL);
            walletLqtPlanAddUI.HyQ.clear();
            for (Bankcard bankcard : com.tencent.mm.plugin.wallet_core.model.d.hX(ddt.LSL)) {
                if (bankcard.field_support_lqt_turn_in == 1) {
                    walletLqtPlanAddUI.HyQ.add(bankcard);
                } else {
                    Log.i("MicroMsg.WalletLqtPlanAddUI", "not support: %s", bankcard.field_bankcardTypeName);
                }
            }
        }
        if (z && (aUM = walletLqtPlanAddUI.aUM(ddt.MpG)) != null) {
            walletLqtPlanAddUI.HyU.Htm = ddt.MpG;
            walletLqtPlanAddUI.HyU.dDj = aUM.field_bankcardType;
            walletLqtPlanAddUI.HyU.ynT = aUM.field_bankName;
            walletLqtPlanAddUI.HyU.AOk = aUM.field_bankcardTail;
        }
        walletLqtPlanAddUI.HyU.Htr = ddt.Htr;
        if (walletLqtPlanAddUI.mMode == 1 || walletLqtPlanAddUI.mMode == 3) {
            walletLqtPlanAddUI.HyU.grV = ddt.MIL;
            walletLqtPlanAddUI.HyU.eht = ddt.MIM;
        }
        if (!Util.isNullOrNil(ddt.Htl)) {
            walletLqtPlanAddUI.Hyv.setText(ddt.Htl);
        }
        if (!Util.isNullOrNil(ddt.MIN)) {
            walletLqtPlanAddUI.Hyw.setText(ddt.MIN);
        }
        if (!Util.isNullOrNil(ddt.MIP)) {
            walletLqtPlanAddUI.Hyx.setText(ddt.MIP);
        }
        if (!Util.isNullOrNil(ddt.MIQ)) {
            walletLqtPlanAddUI.Hyy.setText(ddt.MIQ);
        }
        walletLqtPlanAddUI.updateView();
        walletLqtPlanAddUI.Hyu.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(68834);
                WalletLqtPlanAddUI.this.Hyu.scrollTo(0, WalletLqtPlanAddUI.this.Hyz.getTop());
                AppMethodBeat.o(68834);
            }
        }, 100);
        if (!walletLqtPlanAddUI.Hzf.isEmpty()) {
            Log.i("MicroMsg.WalletLqtPlanAddUI", "mRecommendedAmt Money: %s，%s,%s", Long.valueOf(walletLqtPlanAddUI.Hzf.get(0).MPg), Long.valueOf(walletLqtPlanAddUI.Hzf.get(1).MPg), Long.valueOf(walletLqtPlanAddUI.Hzf.get(2).MPg));
            walletLqtPlanAddUI.Hzb.setText(walletLqtPlanAddUI.getString(R.string.ii4, new Object[]{LR(walletLqtPlanAddUI.Hzf.get(0).MPg)}));
            walletLqtPlanAddUI.Hzc.setText(walletLqtPlanAddUI.getString(R.string.ii4, new Object[]{LR(walletLqtPlanAddUI.Hzf.get(1).MPg)}));
            walletLqtPlanAddUI.Hzd.setText(walletLqtPlanAddUI.getString(R.string.ii4, new Object[]{LR(walletLqtPlanAddUI.Hzf.get(2).MPg)}));
            AppMethodBeat.o(68889);
            return;
        }
        walletLqtPlanAddUI.Hzb.setText(walletLqtPlanAddUI.getString(R.string.ii4, new Object[]{LR(20000)}));
        walletLqtPlanAddUI.Hzc.setText(walletLqtPlanAddUI.getString(R.string.ii4, new Object[]{LR(80000)}));
        walletLqtPlanAddUI.Hzd.setText(walletLqtPlanAddUI.getString(R.string.ii4, new Object[]{LR(2000000)}));
        AppMethodBeat.o(68889);
    }

    static /* synthetic */ void p(WalletLqtPlanAddUI walletLqtPlanAddUI) {
        boolean z = false;
        AppMethodBeat.i(68891);
        Log.i("MicroMsg.WalletLqtPlanAddUI", "go to bindcard");
        Bundle bundle = new Bundle();
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putBoolean("key_is_bind_bankcard", true);
        com.tencent.mm.wallet_core.b.hgC();
        if (com.tencent.mm.wallet_core.b.b(b.a.clicfg_open_kinda_bind_card, true)) {
            EventCenter.instance.add(walletLqtPlanAddUI.AJa);
            Log.d("MicroMsg.WalletLqtPlanAddUI", "startKindaBindCard:true");
            ab.mg(6, bundle.getInt("key_bind_scene"));
            z.aqh(bundle.getInt("key_bind_scene"));
            ((com.tencent.mm.pluginsdk.wallet.a) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(walletLqtPlanAddUI, bundle);
            z = true;
        } else {
            Log.d("MicroMsg.WalletLqtPlanAddUI", "startKindaBindCard:false");
        }
        if (!z) {
            com.tencent.mm.wallet_core.a.a(walletLqtPlanAddUI, c.class, bundle, new d.a() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass14 */

                @Override // com.tencent.mm.wallet_core.d.a
                public final Intent q(int i2, Bundle bundle) {
                    AppMethodBeat.i(68848);
                    Log.i("MicroMsg.WalletLqtPlanAddUI", "bind card finish: %s", Integer.valueOf(i2));
                    if (i2 == -1) {
                        BindCardOrder bindCardOrder = (BindCardOrder) bundle.getParcelable("key_bindcard_value_result");
                        if (bindCardOrder != null) {
                            Log.i("MicroMsg.WalletLqtPlanAddUI", "bind card serial: %s", bindCardOrder.HWx);
                            Bankcard a2 = WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this, bindCardOrder.HWx);
                            if (a2 != null) {
                                WalletLqtPlanAddUI.this.HyU.Htm = a2.field_bindSerial;
                                WalletLqtPlanAddUI.this.HyU.dDj = a2.field_bankcardType;
                                WalletLqtPlanAddUI.this.HyU.ynT = a2.field_bankName;
                                WalletLqtPlanAddUI.this.HyU.AOk = a2.field_bankcardTail;
                                WalletLqtPlanAddUI.o(WalletLqtPlanAddUI.this);
                            }
                        }
                        WalletLqtPlanAddUI.v(WalletLqtPlanAddUI.this);
                    }
                    AppMethodBeat.o(68848);
                    return null;
                }
            });
        }
        AppMethodBeat.o(68891);
    }

    static /* synthetic */ void a(WalletLqtPlanAddUI walletLqtPlanAddUI, final Boolean bool) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        AppMethodBeat.i(68895);
        if (bool.booleanValue()) {
            ofFloat = ObjectAnimator.ofFloat(walletLqtPlanAddUI.Hze, "translationY", 0.0f, (float) ((-walletLqtPlanAddUI.jVg.getHeight()) + 10));
            ofFloat2 = ObjectAnimator.ofFloat(walletLqtPlanAddUI.HyM, "translationY", 0.0f, (float) ((-walletLqtPlanAddUI.jVg.getHeight()) / 5));
        } else {
            ofFloat = ObjectAnimator.ofFloat(walletLqtPlanAddUI.Hze, "translationY", (float) ((-walletLqtPlanAddUI.jVg.getHeight()) + 10), 0.0f);
            ofFloat2 = ObjectAnimator.ofFloat(walletLqtPlanAddUI.HyM, "translationY", (float) ((-walletLqtPlanAddUI.jVg.getHeight()) / 5), 0.0f);
        }
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat2.setDuration(300L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass17 */

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(68851);
                if (!bool.booleanValue()) {
                    WalletLqtPlanAddUI.this.Hze.setVisibility(8);
                }
                AppMethodBeat.o(68851);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        ofFloat2.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.AnonymousClass18 */

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(68852);
                if (bool.booleanValue()) {
                    WalletLqtPlanAddUI.this.HyM.setVisibility(8);
                    AppMethodBeat.o(68852);
                    return;
                }
                WalletLqtPlanAddUI.this.HyM.setVisibility(0);
                AppMethodBeat.o(68852);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        ofFloat.start();
        ofFloat2.start();
        AppMethodBeat.o(68895);
    }
}
