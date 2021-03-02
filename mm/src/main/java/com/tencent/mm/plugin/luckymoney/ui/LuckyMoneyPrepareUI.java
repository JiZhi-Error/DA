package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.r;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.pi;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.b.a.hf;
import com.tencent.mm.g.b.a.hg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.am;
import com.tencent.mm.plugin.luckymoney.model.an;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.luckymoney.model.aw;
import com.tencent.mm.plugin.luckymoney.model.ba;
import com.tencent.mm.plugin.luckymoney.model.bb;
import com.tencent.mm.plugin.luckymoney.model.bf;
import com.tencent.mm.plugin.luckymoney.model.h;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.ui.a;
import com.tencent.mm.plugin.luckymoney.ui.i;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.d;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.c.a;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.y.c;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

public class LuckyMoneyPrepareUI extends LuckyMoneyBaseUI implements h {
    private static final String yQK = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1p) + "/touch/scene_product.html?scene_id=kf7");
    private boolean UYE = false;
    private boolean UYF = false;
    private boolean UYG = false;
    private int dYe = 0;
    private int gwE;
    private MTimerHandler klF = null;
    private int mChannel;
    protected View mKBLayout;
    protected MyKeyboardWindow mKeyboard;
    private boolean mKindaEnable;
    private IListener<pi> mPayLoopInterruptListener = new IListener<pi>() {
        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass1 */

        {
            AppMethodBeat.i(160806);
            this.__eventId = pi.class.getName().hashCode();
            AppMethodBeat.o(160806);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(pi piVar) {
            AppMethodBeat.i(65827);
            if (1 == piVar.dVr.ret) {
                LuckyMoneyPrepareUI.this.finish();
            }
            AppMethodBeat.o(65827);
            return false;
        }
    };
    private String mSessionId;
    private int mType;
    private TextView nAB;
    private TextView qAC = null;
    private EmojiInfo rfq;
    private Button rlN = null;
    public Dialog tipDialog = null;
    private o yPZ;
    private LuckyMoneyNumInputView yQL = null;
    private LuckyMoneyTextInputView yQN = null;
    private Button yQO = null;
    private MMScrollView yQR;
    private TextView yQS;
    private c yQU = new c();
    private String yUc = "";
    private int yUr;
    private h yVa;
    private int yXu;
    private LuckyMoneyMoneyInputView yYI = null;
    private View yYJ;
    private View yYK;
    private ViewGroup yYL;
    private String yYM;
    private int yYN;
    private boolean yYO;
    private String yYP;
    private int zdC = 0;
    private a zdk;
    private View zdl;
    private ChatFooterPanel zdv;
    private ViewGroup zdx;
    private hf zdz;
    private int zfQ = 1;
    private String zfX;
    private String zga = "";
    private Dialog zhA = null;
    private RelativeLayout zhB;
    private TextView zhC;
    private TextView zhD;
    private ImageView zhE;
    private ImageView zhF;
    private ImageView zhG;
    private TextView zhH;
    private ViewGroup zhI;
    private TextView zhJ;
    private ViewGroup zhK;
    private TextView zhL;
    private ImageView zhM;
    private TextView zhN;
    private ViewGroup zhO;
    private WeImageView zhP;
    private TextView zhQ;
    private int zhR = 1;
    private String zhS = f.bpq("CNY");
    private String zhT = null;
    private RealnameGuideHelper zhU;
    private String zhV;
    private String zhW;
    private String zhX;
    private hg zhY;
    private int zhZ;
    private Dialog zhz = null;
    private String zia;
    private String zib;
    private boolean zic = false;
    private boolean zid;
    private int zie;
    private String zif;
    private int zig;
    private long zih;
    private long zii;
    private String zij;
    private d zik;
    private boolean zil = false;
    private boolean zim = false;
    private boolean zin = false;
    private boolean zio = false;
    private IListener<ut> zip = new IListener<ut>() {
        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass20 */

        {
            AppMethodBeat.i(213488);
            this.__eventId = ut.class.getName().hashCode();
            AppMethodBeat.o(213488);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ut utVar) {
            AppMethodBeat.i(213489);
            ut utVar2 = utVar;
            if (LuckyMoneyPrepareUI.this.tipDialog != null && LuckyMoneyPrepareUI.this.tipDialog.isShowing()) {
                LuckyMoneyPrepareUI.this.tipDialog.dismiss();
            }
            final a aVar = utVar2.eba.ebb;
            if (aVar != null && aVar.fPZ()) {
                Log.i("MicroMsg.LuckyMoneyPrepareUI", "show 261 alert item");
                LuckyMoneyPrepareUI.this.zio = true;
                com.tencent.mm.ui.base.h.c(LuckyMoneyPrepareUI.this.getContext(), aVar.dQx, "", aVar.lHB, aVar.lHA, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass20.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(213486);
                        Log.i("MicroMsg.LuckyMoneyPrepareUI", "goto h5: %s", aVar.qwt);
                        f.p(LuckyMoneyPrepareUI.this.getContext(), aVar.qwt, false);
                        LuckyMoneyPrepareUI.this.zio = false;
                        AppMethodBeat.o(213486);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass20.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(213487);
                        LuckyMoneyPrepareUI.this.zio = false;
                        AppMethodBeat.o(213487);
                    }
                });
            }
            AppMethodBeat.o(213489);
            return false;
        }
    };

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LuckyMoneyPrepareUI() {
        AppMethodBeat.i(65882);
        AppMethodBeat.o(65882);
    }

    static /* synthetic */ void E(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        AppMethodBeat.i(258727);
        luckyMoneyPrepareUI.Qb(1);
        AppMethodBeat.o(258727);
    }

    static /* synthetic */ void b(LuckyMoneyPrepareUI luckyMoneyPrepareUI, int i2) {
        AppMethodBeat.i(258721);
        luckyMoneyPrepareUI.Qa(i2);
        AppMethodBeat.o(258721);
    }

    static /* synthetic */ void b(LuckyMoneyPrepareUI luckyMoneyPrepareUI, EmojiInfo emojiInfo) {
        AppMethodBeat.i(258729);
        luckyMoneyPrepareUI.A(emojiInfo);
        AppMethodBeat.o(258729);
    }

    static /* synthetic */ int n(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        AppMethodBeat.i(213523);
        int efB = luckyMoneyPrepareUI.efB();
        AppMethodBeat.o(213523);
        return efB;
    }

    static /* synthetic */ View v(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        AppMethodBeat.i(258722);
        View contentView = luckyMoneyPrepareUI.getContentView();
        AppMethodBeat.o(258722);
        return contentView;
    }

    static /* synthetic */ View w(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        AppMethodBeat.i(213527);
        View contentView = luckyMoneyPrepareUI.getContentView();
        AppMethodBeat.o(213527);
        return contentView;
    }

    static /* synthetic */ View y(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        AppMethodBeat.i(258723);
        View contentView = luckyMoneyPrepareUI.getContentView();
        AppMethodBeat.o(258723);
        return contentView;
    }

    static /* synthetic */ View z(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        AppMethodBeat.i(258724);
        View contentView = luckyMoneyPrepareUI.getContentView();
        AppMethodBeat.o(258724);
        return contentView;
    }

    static {
        AppMethodBeat.i(213535);
        AppMethodBeat.o(213535);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(65883);
        super.onCreate(bundle);
        setActionbarColor(getResources().getColor(R.color.yw));
        setActionbarElementColor(getResources().getColor(R.color.FG_0));
        hideActionbarLine();
        this.mType = getIntent().getIntExtra("key_type", 1);
        this.yUr = getIntent().getIntExtra("key_way", 3);
        this.gwE = getIntent().getIntExtra("key_from", 0);
        this.yYO = this.gwE == 1;
        this.mChannel = getIntent().getIntExtra("pay_channel", -1);
        this.mSessionId = getIntent().getStringExtra("key_session_id");
        qR(false);
        if (((b) g.af(b.class)).a(b.a.clicfg_android_revert_redenvelopes_launchmode_config, 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        int intExtra = getIntent().getIntExtra("key_chatroom_num", 0);
        if (!this.yYO || intExtra <= 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2 && com.tencent.mm.plugin.luckymoney.b.a.UXs >= 0 && z) {
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "use cached hb type: %s", Integer.valueOf(com.tencent.mm.plugin.luckymoney.b.a.UXs));
            this.mType = com.tencent.mm.plugin.luckymoney.b.a.UXs;
            this.UYE = true;
            if (this.mType != 1) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(22237, 1);
            }
        }
        if (af.IA(getIntent().getStringExtra("key_username"))) {
            com.tencent.mm.plugin.luckymoney.b.a.eex();
            this.yPZ = com.tencent.mm.plugin.luckymoney.b.a.eez().efe();
            com.tencent.mm.plugin.luckymoney.b.a.eex();
            this.yVa = com.tencent.mm.plugin.luckymoney.b.a.eez().eff();
        } else if (this.gwE == 3) {
            com.tencent.mm.plugin.luckymoney.b.a.eex();
            this.yPZ = com.tencent.mm.plugin.luckymoney.b.a.hWa().efe();
            com.tencent.mm.plugin.luckymoney.b.a.eex();
            this.yVa = com.tencent.mm.plugin.luckymoney.b.a.hWa().eff();
        } else {
            com.tencent.mm.plugin.luckymoney.b.a.eex();
            this.yPZ = com.tencent.mm.plugin.luckymoney.b.a.eey().efe();
            com.tencent.mm.plugin.luckymoney.b.a.eex();
            this.yVa = com.tencent.mm.plugin.luckymoney.b.a.eey().eff();
        }
        if (this.gwE == 3) {
            setMMSubTitle(R.string.jdq);
            m.vli.a(s.bh.EXPOSE_ONLY_PART_USER_INTERCEPT_UI, s.bg.UNKNOWN, true);
        }
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "mInWay:" + this.yUr + "mChannel:" + this.mChannel);
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.yYO + ", config " + this.yPZ);
        initView();
        EventCenter.instance.add(this.zip);
        this.mPayLoopInterruptListener.alive();
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 4, 0, 0, Integer.valueOf(efB()), 1);
        com.tencent.mm.wallet_core.b.hgC();
        this.mKindaEnable = com.tencent.mm.wallet_core.b.b(b.a.clicfg_kinda_open, true);
        ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
        com.tencent.soter.a.a.hlD();
        AppMethodBeat.o(65883);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(65884);
        super.onResume();
        addSceneEndListener(1970);
        AppMethodBeat.o(65884);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(65885);
        super.onStop();
        removeSceneEndListener(1970);
        AppMethodBeat.o(65885);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(65886);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass12 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(65838);
                LuckyMoneyPrepareUI.this.finish();
                AppMethodBeat.o(65838);
                return true;
            }
        });
        this.yYJ = findViewById(R.id.f3l);
        this.yYK = findViewById(R.id.f3o);
        this.rlN = (Button) findViewById(R.id.f3n);
        this.yQN = (LuckyMoneyTextInputView) findViewById(R.id.f58);
        this.yQN.setHintText(getString(R.string.eof));
        this.yQO = (Button) findViewById(R.id.f3c);
        this.mKeyboard = (MyKeyboardWindow) findViewById(R.id.ijb);
        this.mKBLayout = findViewById(R.id.ija);
        this.nAB = (TextView) findViewById(R.id.f3a);
        this.yQL = (LuckyMoneyNumInputView) findViewById(R.id.f38);
        this.yYI = (LuckyMoneyMoneyInputView) findViewById(R.id.exy);
        this.qAC = (TextView) findViewById(R.id.f3p);
        this.yYL = (ViewGroup) findViewById(R.id.f3j);
        this.yQR = (MMScrollView) findViewById(R.id.f4s);
        this.yQS = (TextView) findViewById(R.id.f3h);
        this.zhB = (RelativeLayout) findViewById(R.id.f0f);
        this.zhC = (TextView) findViewById(R.id.f0m);
        this.zhD = (TextView) findViewById(R.id.f0k);
        this.zhE = (ImageView) findViewById(R.id.f0e);
        this.zhF = (ImageView) findViewById(R.id.f0d);
        this.zhG = (ImageView) findViewById(R.id.f0g);
        this.zhH = (TextView) findViewById(R.id.f0h);
        this.zhI = (ViewGroup) findViewById(R.id.f1n);
        this.zhJ = (TextView) findViewById(R.id.f1o);
        this.zhK = (ViewGroup) findViewById(R.id.f0r);
        this.zhL = (TextView) findViewById(R.id.f3i);
        this.zhM = (ImageView) findViewById(R.id.f0q);
        this.zhN = (TextView) findViewById(R.id.f0t);
        this.zhO = (ViewGroup) findViewById(R.id.eyo);
        this.zhP = (WeImageView) findViewById(R.id.eyn);
        this.zhQ = (TextView) findViewById(R.id.eyp);
        this.zdk = new a(this);
        this.zdl = getLayoutInflater().inflate(R.layout.b3s, (ViewGroup) null);
        this.zdk.setContentView(this.zdl, new ViewGroup.LayoutParams(-1, -1));
        this.zdl.findViewById(R.id.f0_).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass22 */

            public final void onClick(View view) {
                AppMethodBeat.i(65851);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65851);
            }
        });
        this.zdk.zbp = new a.AbstractC1468a() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass33 */

            @Override // com.tencent.mm.plugin.luckymoney.ui.a.AbstractC1468a
            public final void efU() {
                AppMethodBeat.i(65865);
                LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this);
                AppMethodBeat.o(65865);
            }
        };
        this.zdx = (ViewGroup) this.zdl.findViewById(R.id.f0b);
        this.zdv = e.Knc.eZ(getContext());
        this.zhW = getIntent().getStringExtra("key_username");
        this.zdv.setTalkerName(this.zhW);
        this.zdv.setShowSmiley(false);
        if (this.mType == 1) {
            setMMTitle(R.string.epq);
            this.yYI.setTitle(getString(R.string.esk));
            this.yYI.setShowGroupIcon(true);
        } else {
            setMMTitle(R.string.eqo);
            this.yYI.setTitle(getString(R.string.esl));
            this.yYI.setShowGroupIcon(false);
        }
        if (af.IA(getIntent().getStringExtra("key_username"))) {
            this.yYI.setRtxLuckyMoney(1);
        } else if (this.gwE == 3) {
            this.yYI.setRtxLuckyMoney(2);
        } else {
            this.yYI.setRtxLuckyMoney(0);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, com.tencent.mm.cb.a.aG(this, R.dimen.ab9));
        if (this.mType == 1) {
            layoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 13);
            layoutParams2.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 13);
        } else {
            layoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 16);
            layoutParams2.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 16);
        }
        this.yQN.setLayoutParams(layoutParams);
        this.zhB.setLayoutParams(layoutParams2);
        this.yYI.setOnInputValidChangerListener(this);
        this.yYI.setHint(getString(R.string.eqa));
        this.yQL.setOnInputValidChangerListener(this);
        this.yQL.setHint(getString(R.string.eqq));
        if (af.IA(getIntent().getStringExtra("key_username"))) {
            this.yQL.setRtxLuckyMoney(1);
        } else if (this.gwE == 3) {
            this.yQL.setRtxLuckyMoney(2);
        } else {
            this.yQL.setRtxLuckyMoney(0);
        }
        this.yQN.setOnInputValidChangerListener(this);
        if (ao.isDarkMode()) {
            this.zhG.setImageResource(R.drawable.cey);
        } else {
            this.zhG.setImageResource(R.drawable.cex);
        }
        final EditText editText = (EditText) this.yYI.findViewById(R.id.f0o);
        final EditText editText2 = (EditText) this.yQL.findViewById(R.id.f0o);
        f.setNoSystemInputOnEditText(editText);
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(editText, 0);
        editText.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass13 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(65839);
                String obj = editable.toString();
                if (obj.startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                } else if (WalletFormView.a(obj, editText)) {
                    AppMethodBeat.o(65839);
                    return;
                }
                String obj2 = editable.toString();
                int indexOf = obj2.indexOf(".");
                int length = obj2.length();
                if (indexOf >= 0 && length - indexOf > 3) {
                    editable.delete(indexOf + 3, length);
                } else if (indexOf > 6) {
                    editable.delete(6, indexOf);
                } else if (indexOf == -1 && length > 6) {
                    editable.delete(6, length);
                }
                editText.setContentDescription(editable.toString());
                AppMethodBeat.o(65839);
            }
        });
        editText2.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass14 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(213482);
                editText2.setContentDescription(editable.toString());
                AppMethodBeat.o(213482);
            }
        });
        editText.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass15 */

            public final void onClick(View view) {
                AppMethodBeat.i(65841);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                LuckyMoneyPrepareUI.this.ak(LuckyMoneyPrepareUI.this.yYI, 2);
                LuckyMoneyPrepareUI.this.ak(LuckyMoneyPrepareUI.this.yQL, 0);
                LuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
                LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65841);
            }
        });
        if (((b) g.af(b.class)).a(b.a.clicfg_android_revert_redenvelopes_cell_config, 1) == 1) {
            int intExtra = getIntent().getIntExtra("key_chatroom_num", 0);
            if (!this.yYO || intExtra != 0) {
                editText2.requestFocus();
            } else {
                editText.requestFocus();
            }
        } else {
            editText.requestFocus();
        }
        TextView textView = (TextView) this.yYI.findViewById(R.id.exz);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass16 */

                public final void onClick(View view) {
                    AppMethodBeat.i(65842);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    editText.setOnClickListener(null);
                    editText2.setOnClickListener(null);
                    LuckyMoneyPrepareUI.this.ak(LuckyMoneyPrepareUI.this.yYI, 2);
                    LuckyMoneyPrepareUI.this.ak(LuckyMoneyPrepareUI.this.yQL, 0);
                    LuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
                    LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(editText);
                    LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(65842);
                }
            });
        }
        f.setNoSystemInputOnEditText(editText2);
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(editText2, 0);
        editText2.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass17 */

            public final void onClick(View view) {
                AppMethodBeat.i(213483);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                LuckyMoneyPrepareUI.this.ak(LuckyMoneyPrepareUI.this.yYI, 2);
                LuckyMoneyPrepareUI.this.ak(LuckyMoneyPrepareUI.this.yQL, 0);
                LuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
                LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(213483);
            }
        });
        ((MMEditText) this.yQN.findViewById(R.id.f4t)).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass18 */

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(213484);
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                LuckyMoneyPrepareUI.this.ak(LuckyMoneyPrepareUI.this.yYI, 2);
                LuckyMoneyPrepareUI.this.ak(LuckyMoneyPrepareUI.this.yQL, 0);
                AppMethodBeat.o(213484);
            }
        });
        if (this.yPZ != null) {
            if (this.mType == 1) {
                this.yYI.setMaxAmount(this.yPZ.yPy);
            } else {
                this.yYI.setMaxAmount(this.yPZ.yPw);
            }
            this.yYI.setMinAmount(this.yPZ.yPx);
            if (this.yPZ.qww != 1) {
                aDH(this.yPZ.yPB);
            }
        }
        if (!this.yYO || getIntent().getIntExtra("key_chatroom_num", 0) > 1) {
            this.yQL.setNum("");
        } else {
            this.yQL.setNum("1");
        }
        this.yQL.setMaxNum(this.yPZ.yPv);
        this.yQL.setMinNum(1);
        Log.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.yQL.getInput());
        this.yYI.setMaxLen(12);
        if (egE()) {
            this.yQO.setText(getString(R.string.erd, new Object[]{this.yPZ.yUV}));
        }
        if (this.yYO || this.gwE == 2 || this.gwE == 3) {
            if (egE()) {
                setMMTitle(getString(R.string.esh, new Object[]{this.yPZ.yUV}));
            } else {
                setMMTitle(R.string.esg);
            }
            int intExtra2 = getIntent().getIntExtra("key_chatroom_num", 0);
            if (!this.yYO || intExtra2 != 0) {
                if (getIntent().getIntExtra("key_chatroom_num", 0) > 0 || !this.yYO) {
                    this.zhI.setVisibility(0);
                    Qa(-1);
                    this.zhI.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass46 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(213515);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            LuckyMoneyPrepareUI.this.hideTenpayKB();
                            LuckyMoneyPrepareUI.this.hideVKB();
                            d dVar = new d(LuckyMoneyPrepareUI.this.getContext(), (byte) 0);
                            dVar.HLX = new o.f() {
                                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass46.AnonymousClass1 */

                                @Override // com.tencent.mm.ui.base.o.f
                                public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                                    AppMethodBeat.i(213513);
                                    mVar.d(1, LuckyMoneyPrepareUI.this.getString(R.string.eq8));
                                    mVar.d(2, LuckyMoneyPrepareUI.this.getString(R.string.eq9));
                                    ((b) g.af(b.class)).a(b.a.clicfg_android_exclusive_lucky_money, 0);
                                    int intExtra = LuckyMoneyPrepareUI.this.getIntent().getIntExtra("key_chatroom_num", 0);
                                    if (LuckyMoneyPrepareUI.this.yPZ.yUY && LuckyMoneyPrepareUI.this.zhR == 1 && !ab.Iz(LuckyMoneyPrepareUI.this.getIntent().getStringExtra("key_username")) && LuckyMoneyPrepareUI.this.gwE != 2 && LuckyMoneyPrepareUI.this.gwE != 3 && intExtra > 1) {
                                        mVar.d(3, LuckyMoneyPrepareUI.this.getString(R.string.eq6));
                                    }
                                    AppMethodBeat.o(213513);
                                }
                            };
                            dVar.HLY = new o.g() {
                                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass46.AnonymousClass2 */

                                @Override // com.tencent.mm.ui.base.o.g
                                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                    AppMethodBeat.i(213514);
                                    int itemId = menuItem.getItemId();
                                    int i3 = LuckyMoneyPrepareUI.this.mType;
                                    if (itemId == 1) {
                                        LuckyMoneyPrepareUI.this.mType = 1;
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 4, 0, 0, Integer.valueOf(LuckyMoneyPrepareUI.n(LuckyMoneyPrepareUI.this)), 2);
                                    } else if (itemId == 2) {
                                        LuckyMoneyPrepareUI.this.mType = 0;
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 4, 0, 0, Integer.valueOf(LuckyMoneyPrepareUI.n(LuckyMoneyPrepareUI.this)), 3);
                                    } else if (itemId == 3) {
                                        LuckyMoneyPrepareUI.this.mType = 3;
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 4, 0, 0, Integer.valueOf(LuckyMoneyPrepareUI.n(LuckyMoneyPrepareUI.this)), 13);
                                    }
                                    if (LuckyMoneyPrepareUI.this.UYE && i3 != LuckyMoneyPrepareUI.this.mType) {
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(22237, 2);
                                        LuckyMoneyPrepareUI.this.UYF = true;
                                    }
                                    LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this, i3);
                                    AppMethodBeat.o(213514);
                                }
                            };
                            dVar.dGm();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(213515);
                        }
                    });
                    this.zhK.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass2 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(213474);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            LuckyMoneyPrepareUI.this.hideTenpayKB();
                            LuckyMoneyPrepareUI.this.hideVKB();
                            Intent intent = new Intent(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyExclusiveSelectContactUI.class);
                            intent.putExtra("chatroomName", LuckyMoneyPrepareUI.this.zhW);
                            LuckyMoneyPrepareUI.this.startActivityForResult(intent, 6);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(213474);
                        }
                    });
                } else {
                    this.zhI.setVisibility(8);
                    this.zhK.setVisibility(8);
                }
                if (this.yYO && intExtra2 > 0) {
                    Log.i("MicroMsg.LuckyMoneyPrepareUI", "group hb,%d people", Integer.valueOf(intExtra2));
                    this.zhL.setText(getString(R.string.eqp, new Object[]{Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8))}));
                } else if (this.gwE == 2) {
                    Log.i("MicroMsg.LuckyMoneyPrepareUI", "f2f hb");
                    this.yQN.setVisibility(8);
                }
                this.yYI.setGroupIconIv(R.drawable.cd_);
            } else {
                Log.i("MicroMsg.LuckyMoneyPrepareUI", "single hb");
                this.yQL.setVisibility(8);
                this.zhI.setVisibility(8);
                this.zhK.setVisibility(8);
            }
        } else if (this.mType == 1) {
            this.nAB.setText(this.yPZ.yUR);
            this.nAB.setVisibility(0);
        } else if (this.mType == 0) {
            this.nAB.setText(this.yPZ.yUS);
            this.nAB.setVisibility(0);
        }
        this.yQO.setOnClickListener(new x() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass42 */

            @Override // com.tencent.mm.ui.x
            public final void czW() {
                AppMethodBeat.i(213509);
                LuckyMoneyPrepareUI.this.zdz = new hf();
                LuckyMoneyPrepareUI.this.zdz.eEH = 6;
                LuckyMoneyPrepareUI.this.zdz.bfK();
                if (!((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(LuckyMoneyPrepareUI.this)) {
                    Log.w("MicroMsg.LuckyMoneyPrepareUI", "can not request hb while authen");
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(965, 55);
                    AppMethodBeat.o(213509);
                    return;
                }
                LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this);
                AppMethodBeat.o(213509);
            }
        });
        this.yQU.t((TextView) findViewById(R.id.f3e));
        this.klF = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass43 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                double d2;
                AppMethodBeat.i(213510);
                if (LuckyMoneyPrepareUI.this.yYI.eeH() == 3 || LuckyMoneyPrepareUI.this.yQL.eeH() == 3) {
                    d2 = 0.0d;
                } else {
                    int input = LuckyMoneyPrepareUI.this.yQL.getInput();
                    d2 = LuckyMoneyPrepareUI.this.yYI.getInput();
                    if (LuckyMoneyPrepareUI.this.mType == 0) {
                        d2 *= (double) input;
                    } else if (LuckyMoneyPrepareUI.this.mType == 3 && Util.isNullOrNil(LuckyMoneyPrepareUI.this.zhX)) {
                        d2 = 0.0d;
                    }
                }
                if (d2 == 0.0d || d2 > LuckyMoneyPrepareUI.this.yPZ.yPy || LuckyMoneyPrepareUI.this.yQU.egk()) {
                    LuckyMoneyPrepareUI.this.yQO.setClickable(false);
                    LuckyMoneyPrepareUI.this.yQO.setEnabled(false);
                } else {
                    LuckyMoneyPrepareUI.this.yQO.setClickable(true);
                    LuckyMoneyPrepareUI.this.yQO.setEnabled(true);
                }
                Log.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d2 + ", hasErr=" + LuckyMoneyPrepareUI.this.yQU.egk());
                LuckyMoneyPrepareUI.this.klF.stopped();
                AppMethodBeat.o(213510);
                return false;
            }
        }, false);
        if (this.yQR != null) {
            this.yQR.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass44 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(213511);
                    if (motionEvent.getAction() == 0) {
                        LuckyMoneyPrepareUI.this.hideTenpayKB();
                        LuckyMoneyPrepareUI.this.hideVKB();
                    }
                    AppMethodBeat.o(213511);
                    return false;
                }
            });
        }
        this.yYI.setType(this.mType);
        init();
        final boolean a2 = c.axV().a(ar.a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_STRING_SYNC, ar.a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_HOME_STRING_SYNC);
        this.zhB.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(213479);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.LuckyMoneyPrepareUI", "click envelope layout: %s", Integer.valueOf(LuckyMoneyPrepareUI.this.zhZ));
                if (LuckyMoneyPrepareUI.this.zhZ == 0) {
                    LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, null, false, a2);
                } else {
                    final Dialog gu = af.gu(LuckyMoneyPrepareUI.this.getContext());
                    k eeZ = k.eeZ();
                    eeZ.b(new com.tencent.mm.plugin.luckymoney.model.d("", 1));
                    eeZ.a(new a.AbstractC2168a<bvi>() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass8.AnonymousClass1 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int] */
                        @Override // com.tencent.mm.wallet_core.c.a.AbstractC2168a
                        public final /* synthetic */ void d(bvi bvi, int i2, int i3) {
                            AppMethodBeat.i(258719);
                            bvi bvi2 = bvi;
                            if (gu != null && gu.isShowing()) {
                                gu.dismiss();
                            }
                            Log.i("MicroMsg.LuckyMoneyPrepareUI", "do get show source net callback");
                            if (bvi2 != null) {
                                Log.i("MicroMsg.LuckyMoneyPrepareUI", "retcode: %s", Integer.valueOf(bvi2.dDN));
                                if (bvi2.dDN == 0) {
                                    try {
                                        LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this, bvi2.toByteArray(), true, a2);
                                    } catch (Exception e2) {
                                        Log.printErrStackTrace("MicroMsg.LuckyMoneyPrepareUI", e2, "", new Object[0]);
                                    }
                                    LuckyMoneyPrepareUI.this.zhH.setVisibility(8);
                                    c.axV().c(ar.a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_STRING_SYNC, ar.a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_HOME_STRING_SYNC);
                                    AppMethodBeat.o(258719);
                                    return;
                                }
                                f.bpB(bvi2.qwn);
                                AppMethodBeat.o(258719);
                                return;
                            }
                            f.ar(LuckyMoneyPrepareUI.this.getContext(), "");
                            AppMethodBeat.o(258719);
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.mm.wallet_core.c.a.AbstractC2168a
                        public final /* bridge */ /* synthetic */ void dx(bvi bvi) {
                        }
                    }, 0);
                }
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr = new Object[3];
                objArr[0] = 2;
                objArr[1] = Integer.valueOf(a2 ? 2 : 1);
                objArr[2] = LuckyMoneyPrepareUI.this.mSessionId;
                hVar.a(18890, objArr);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(16822, 1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(213479);
            }
        });
        if (a2) {
            this.zhH.setVisibility(0);
        }
        if (this.yVa != null) {
            b(this.yVa.yUC);
        }
        if (af.IA(getIntent().getStringExtra("key_username"))) {
            b((cbe) null);
        }
        AppMethodBeat.o(65886);
    }

    private void egC() {
        AppMethodBeat.i(213516);
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "init custom envelope entrance: %s", Integer.valueOf(((Integer) g.aAh().azQ().get(ar.a.USERINFO_LUCKY_MONEY_CUSTOM_ENVELOPE_ENTRANCE_INT_SYNC, (Object) 0)).intValue()));
        if (this.yPZ == null || this.yPZ.yUZ == null || this.gwE == 2) {
            this.zhO.setVisibility(8);
            AppMethodBeat.o(213516);
        } else if (!Util.isNullOrNil(this.yPZ.yUZ.dQx)) {
            this.zhQ.setText(this.yPZ.yUZ.dQx);
            int jn = com.tencent.mm.cb.a.jn(getContext()) - com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 70);
            if (jn > 0) {
                this.zhQ.setMaxWidth(jn);
            }
            this.zhO.setVisibility(0);
            this.UYG = true;
            if (!Util.isNullOrNil(this.yPZ.yUZ.qGB)) {
                c.a aVar = new c.a();
                com.tencent.mm.plugin.luckymoney.b.a.eex();
                aVar.prefixPath = com.tencent.mm.plugin.luckymoney.b.a.eeA();
                q.bcW();
                aVar.jbw = null;
                aVar.jbf = true;
                aVar.iaT = false;
                aVar.jbd = true;
                q.bcV().a(this.yPZ.yUZ.qGB, this.zhP, aVar.bdv());
            }
            this.zhO.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass45 */

                public final void onClick(View view) {
                    AppMethodBeat.i(213512);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("MicroMsg.LuckyMoneyPrepareUI", "jump to action type: %s", Integer.valueOf(LuckyMoneyPrepareUI.this.yPZ.yUZ.pTI));
                    switch (LuckyMoneyPrepareUI.this.yPZ.yUZ.pTI) {
                        case 1:
                            f.p(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyPrepareUI.this.yPZ.yUZ.yUK, false);
                            break;
                        case 2:
                            f.am(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyPrepareUI.this.yPZ.yUZ.yUL);
                            break;
                        case 3:
                            f.u(LuckyMoneyPrepareUI.this.yPZ.yUZ.yUL, LuckyMoneyPrepareUI.this.yPZ.yUZ.yUK, 0, 1100);
                            break;
                        case 4:
                            Intent intent = new Intent();
                            intent.putExtra("finder_username", LuckyMoneyPrepareUI.this.yPZ.yUZ.yUL);
                            ((aj) g.ah(aj.class)).enterFinderProfileUI(LuckyMoneyPrepareUI.this.getContext(), intent);
                            break;
                        case 5:
                        case 6:
                            Intent intent2 = new Intent();
                            intent2.putExtra("extra_id", LuckyMoneyPrepareUI.this.yPZ.yUZ.yUL);
                            intent2.putExtra("preceding_scence", 21);
                            com.tencent.mm.br.c.b(LuckyMoneyPrepareUI.this.getContext(), "emoji", ".ui.EmojiStoreDetailUI", intent2);
                            break;
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(213512);
                }
            });
            AppMethodBeat.o(213516);
        } else {
            this.zhO.setVisibility(8);
            AppMethodBeat.o(213516);
        }
    }

    private void Qa(int i2) {
        AppMethodBeat.i(213517);
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "update view by mode: %s, %s", Integer.valueOf(this.mType), Integer.valueOf(i2));
        if (i2 == this.mType) {
            AppMethodBeat.o(213517);
        } else if (this.mType == 0) {
            this.zhJ.setText(R.string.eq9);
            this.zhK.setVisibility(8);
            this.yQL.setVisibility(0);
            this.zhL.setVisibility(0);
            this.nAB.setVisibility(8);
            this.yQU.a(this.yQL);
            this.yQU.a(this.yYI);
            this.yQU.a(this.yQN);
            int input = this.yQL.getInput();
            double input2 = this.yYI.getInput();
            this.yYI.setType(this.mType);
            this.yYI.setShowGroupIcon(false);
            this.yYI.setTitle(getString(R.string.esl));
            if (input2 > 0.0d && input > 0) {
                this.yYI.setAmount(f.formatMoney2f(input2 / ((double) input)));
            }
            this.yYI.setMaxAmount(this.yPZ.yPw);
            AppMethodBeat.o(213517);
        } else if (this.mType == 1) {
            this.zhJ.setText(R.string.eq8);
            this.zhK.setVisibility(8);
            this.yQL.setVisibility(0);
            this.zhL.setVisibility(0);
            this.nAB.setVisibility(8);
            this.yQU.a(this.yQL);
            this.yQU.a(this.yYI);
            this.yQU.a(this.yQN);
            int input3 = this.yQL.getInput();
            double input4 = this.yYI.getInput();
            this.yYI.setType(this.mType);
            this.yYI.setMaxAmount(this.yPZ.yPy);
            this.yYI.setTitle(getString(R.string.esk));
            this.yYI.setShowGroupIcon(true);
            if (i2 != 3 || input4 <= 0.0d) {
                if (input4 > 0.0d && input3 > 0) {
                    this.yYI.setAmount(f.formatMoney2f(input4 * ((double) input3)));
                }
                AppMethodBeat.o(213517);
                return;
            }
            this.yYI.setAmount(f.formatMoney2f(input4));
            AppMethodBeat.o(213517);
        } else {
            if (this.mType == 3) {
                this.zhJ.setText(R.string.eq6);
                this.zhK.setVisibility(0);
                this.yQL.setVisibility(8);
                this.zhL.setVisibility(8);
                this.nAB.setVisibility(8);
                this.yQU.b(this.yQL);
                this.yQU.a(this.yYI);
                this.yQU.a(this.yQN);
                int input5 = this.yQL.getInput();
                double input6 = this.yYI.getInput();
                this.yYI.setType(this.mType);
                this.yYI.setShowGroupIcon(false);
                this.yYI.setTitle(getString(R.string.esi));
                if (i2 == 0 && input6 > 0.0d && input5 > 0) {
                    this.yYI.setAmount(f.formatMoney2f(input6 * ((double) input5)));
                } else if (input6 > 0.0d) {
                    this.yYI.setAmount(f.formatMoney2f(input6));
                }
                this.yYI.setMaxAmount(this.yPZ.yPw);
                if (!this.zid) {
                    this.zhK.post(new Runnable() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(213475);
                            int left = (((ImageView) LuckyMoneyPrepareUI.this.findViewById(R.id.f0p)).getLeft() - com.tencent.mm.cb.a.fromDPToPix((Context) LuckyMoneyPrepareUI.this.getContext(), 8)) - (((TextView) LuckyMoneyPrepareUI.this.findViewById(R.id.f0s)).getRight() + com.tencent.mm.cb.a.fromDPToPix((Context) LuckyMoneyPrepareUI.this.getContext(), 52));
                            if (left > 0) {
                                Log.d("MicroMsg.LuckyMoneyPrepareUI", "usernametv maxwidth: %s", Integer.valueOf(left));
                                LuckyMoneyPrepareUI.this.zhN.setMaxWidth(left);
                            }
                            AppMethodBeat.o(213475);
                        }
                    });
                    this.zid = true;
                }
            }
            AppMethodBeat.o(213517);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(65887);
        finish();
        AppMethodBeat.o(65887);
    }

    private void Qb(int i2) {
        long E;
        as asVar;
        AppMethodBeat.i(213518);
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick() userConfirmJump:%s", Integer.valueOf(i2));
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 4, 0, 0, Integer.valueOf(efB()), 4);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(15511, Integer.valueOf(this.zhR), 2);
        if (this.yYI.eeH() != 0) {
            u.makeText(getContext(), (int) R.string.i7f, 0).show();
            AppMethodBeat.o(213518);
            return;
        }
        int input = this.yQL.getInput();
        double input2 = this.yYI.getInput();
        long j2 = 0;
        if (this.mType == 1) {
            E = f.E(input2);
            g.aAi();
            g.aAh().azQ().set(356354, Integer.valueOf(input));
        } else if (this.mType == 3) {
            E = f.E(input2);
        } else {
            E = f.E(((double) input) * input2);
            j2 = f.E(input2);
            g.aAi();
            g.aAh().azQ().set(356353, Integer.valueOf(input));
        }
        String replace = this.yQN.getInput().replace("\r", "").replace("\n", "");
        if (Util.isNullOrNil(replace)) {
            replace = Util.isNullOrNil(this.zhT) ? getString(R.string.eof) : this.zhT;
        }
        hideTenpayKB();
        if (this.gwE == 2) {
            doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.d(input, (int) E, this.mType, (int) j2), false);
        } else {
            String stringExtra = getIntent().getStringExtra("key_username");
            if (this.zhR == 1) {
                Log.i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick() ifGetConfig=%s mUniqueId=%s waitingGetConfig=%s ifAutoRMBPrePareBtn=%s", Boolean.valueOf(this.zil), Util.nullAsNil(this.zfX), Boolean.valueOf(this.zim), Boolean.valueOf(this.zin));
                if (this.zil) {
                    a(i2, stringExtra, input, E, j2, replace);
                    AppMethodBeat.o(213518);
                    return;
                }
                this.zin = true;
                this.zie = i2;
                this.zif = stringExtra;
                this.zig = input;
                this.zih = E;
                this.zii = j2;
                this.zij = replace;
                if (this.zhA != null) {
                    this.zhA.show();
                } else {
                    this.zhA = com.tencent.mm.ui.base.h.a((Context) this, 3, (int) R.style.lj, getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass4 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(65830);
                            Log.i("MicroMsg.LuckyMoneyPrepareUI", "coperationTipDialogNoTransparent onCancel()");
                            LuckyMoneyPrepareUI.this.zin = false;
                            LuckyMoneyPrepareUI.this.zim = false;
                            if (LuckyMoneyPrepareUI.this.zhA != null && LuckyMoneyPrepareUI.this.zhA.isShowing()) {
                                LuckyMoneyPrepareUI.this.zhA.dismiss();
                            }
                            if (LuckyMoneyPrepareUI.v(LuckyMoneyPrepareUI.this).getVisibility() == 8 || LuckyMoneyPrepareUI.w(LuckyMoneyPrepareUI.this).getVisibility() == 4) {
                                Log.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
                                LuckyMoneyPrepareUI.this.finish();
                            }
                            LuckyMoneyPrepareUI.this.zbX.forceCancel();
                            AppMethodBeat.o(65830);
                        }
                    });
                }
                if (!this.zim) {
                    qR(false);
                }
                AppMethodBeat.o(213518);
                return;
            }
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "currency=%s userConfiremJump:%s", Integer.valueOf(this.zhR), Integer.valueOf(i2));
            addSceneEndListener(1647);
            if (!this.yYO || Util.isNullOrNil(stringExtra)) {
                asVar = new as(input, E, j2, this.mType, replace, null, af.efj(), z.aTY(), this.zhR);
            } else {
                asVar = new as(input, E, j2, this.mType, replace, stringExtra, af.efj(), z.aTY(), this.zhR);
            }
            doSceneProgress(asVar, false);
        }
        egD();
        AppMethodBeat.o(213518);
    }

    private void egD() {
        AppMethodBeat.i(213519);
        if (this.tipDialog != null) {
            this.tipDialog.show();
            AppMethodBeat.o(213519);
            return;
        }
        this.tipDialog = com.tencent.mm.wallet_core.ui.h.a((Context) getContext(), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass5 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(213476);
                if (LuckyMoneyPrepareUI.this.tipDialog != null && LuckyMoneyPrepareUI.this.tipDialog.isShowing()) {
                    LuckyMoneyPrepareUI.this.tipDialog.dismiss();
                }
                if (LuckyMoneyPrepareUI.y(LuckyMoneyPrepareUI.this).getVisibility() == 8 || LuckyMoneyPrepareUI.z(LuckyMoneyPrepareUI.this).getVisibility() == 4) {
                    Log.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
                    LuckyMoneyPrepareUI.this.finish();
                }
                LuckyMoneyPrepareUI.this.zbX.forceCancel();
                AppMethodBeat.o(213476);
            }
        });
        this.tipDialog.setCancelable(false);
        AppMethodBeat.o(213519);
    }

    private void a(int i2, String str, int i3, long j2, long j3, String str2) {
        ba baVar;
        bb bbVar;
        AppMethodBeat.i(213520);
        String str3 = "";
        int i4 = 0;
        if (this.rfq != null) {
            str3 = this.rfq.getMd5();
            i4 = this.rfq.field_type;
        }
        String str4 = "";
        if (this.yVa != null) {
            str4 = this.yVa.yUD;
        }
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "currency is RMB. userConfirmJump:%s lastPayResult:%s mSendId:%s mUniqueId:%s", Integer.valueOf(i2), Integer.valueOf(this.dYe), this.yUc, this.zfX);
        if (af.IA(getIntent().getStringExtra("key_username"))) {
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "doRMBPrePareBtnClick use rtx luckmoney");
            if (!this.yYO || Util.isNullOrNil(str)) {
                bbVar = new bb(i3, j2, j3, this.mType, str2, af.efj(), null, null, z.aTY(), z.aUa(), this.yUr, str4, this.zfX, i2, this.dYe, this.yUc, str3, i4);
            } else {
                bbVar = new bb(i3, j2, j3, this.mType, str2, af.efj(), str, af.Ir(str), z.aTY(), z.aUa(), this.yUr, str4, this.zfX, i2, this.dYe, this.yUc, str3, i4);
            }
            doSceneProgress(bbVar, false);
        } else {
            if (this.gwE == 3) {
                baVar = new com.tencent.mm.plugin.luckymoney.model.a.c(i3, j2, j3, this.mType, str2, af.efj(), af.Ir(str), z.aTY(), z.aUa(), this.yUr, str4, this.zfX, i2, this.dYe, this.yUc, str3, i4, this.zhX, getIntent().getStringExtra("key_live_id"), getIntent().getStringExtra("key_live_attach"), getIntent().getIntExtra("key_live_anchor_type", 0));
            } else {
                Log.i("MicroMsg.LuckyMoneyPrepareUI", "doRMBPrePareBtnClick use normal luckmoney");
                if (!this.yYO || Util.isNullOrNil(str)) {
                    baVar = new ba(i3, j2, j3, this.mType, str2, af.efj(), null, null, z.aTY(), z.aUa(), this.yUr, str4, this.zfX, i2, this.dYe, this.yUc, str3, i4, this.zhX);
                } else {
                    baVar = new ba(i3, j2, j3, this.mType, str2, af.efj(), str, af.Ir(str), z.aTY(), z.aUa(), this.yUr, str4, this.zfX, i2, this.dYe, this.yUc, str3, i4, this.zhX);
                }
            }
            doSceneProgress(baVar, false);
        }
        if (!Util.isNullOrNil(str4)) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(991, 11);
        }
        egD();
        AppMethodBeat.o(213520);
    }

    private void init() {
        AppMethodBeat.i(65891);
        if (this.zhR == 1) {
            addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass6 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(65832);
                    LuckyMoneyPrepareUI.A(LuckyMoneyPrepareUI.this);
                    AppMethodBeat.o(65832);
                    return true;
                }
            });
        } else {
            addIconOptionMenu(0, R.drawable.af_, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass7 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(213477);
                    if (LuckyMoneyPrepareUI.this.yPZ == null || Util.isNullOrNil(LuckyMoneyPrepareUI.this.yPZ.yUU)) {
                        f.p(LuckyMoneyPrepareUI.this.getContext(), "https://hkwallet.moneydata.hk/hybrid/www/weixin/hongbao_hk_v2/zh_hk/faq.shtml", false);
                    } else {
                        f.p(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyPrepareUI.this.yPZ.yUU, false);
                    }
                    AppMethodBeat.o(213477);
                    return true;
                }
            });
        }
        egC();
        AppMethodBeat.o(65891);
    }

    private void b(cbe cbe) {
        AppMethodBeat.i(65892);
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "update envelope");
        if (this.yVa == null || cbe == null || this.gwE == 2) {
            this.zhB.setVisibility(8);
        } else {
            this.zhB.setVisibility(0);
            boolean a2 = com.tencent.mm.y.c.axV().a(ar.a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_STRING_SYNC, ar.a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_HOME_STRING_SYNC);
            if (!this.zic) {
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr = new Object[3];
                objArr[0] = 1;
                objArr[1] = Integer.valueOf(a2 ? 2 : 1);
                objArr[2] = this.mSessionId;
                hVar.a(18890, objArr);
                this.zic = true;
            }
            if (this.yVa.yUE && !Util.isNullOrNil(this.yVa.yUF)) {
                List<String> stringToList = Util.stringToList((String) g.aAh().azQ().get(ar.a.USERINFO_LUCKY_MONEY_ENVELOPE_ILLEGAL_STRING_SYNC, ""), ",");
                for (String str : stringToList) {
                    if (str.equals(this.yVa.yUC.Lot)) {
                        Log.d("MicroMsg.LuckyMoneyPrepareUI", "has alert illegal: %s", str);
                        AppMethodBeat.o(65892);
                        return;
                    }
                }
                stringToList.add(this.yVa.yUC.Lot);
                g.aAh().azQ().set(ar.a.USERINFO_LUCKY_MONEY_ENVELOPE_ILLEGAL_STRING_SYNC, Util.listToString(stringToList, ","));
                Log.i("MicroMsg.LuckyMoneyPrepareUI", "show alert illegal: %s", this.yVa.yUC.Lot);
                com.tencent.mm.ui.base.h.a(getContext(), this.yVa.yUF, "", getString(R.string.j34), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass9 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
            }
        }
        if (cbe != null && cbe.dfT == 1) {
            this.zhB.setEnabled(false);
            if (!Util.isNullOrNil(cbe.MgQ)) {
                this.zhC.setText(cbe.MgQ);
            }
            this.zhE.setImageBitmap(null);
            this.zhF.setVisibility(8);
            this.zhC.setTextColor(getResources().getColor(R.color.BW_0_Alpha_0_3));
        } else if (cbe == null || Util.isNullOrNil(cbe.MgB)) {
            this.zhB.setEnabled(true);
            this.zhE.setImageBitmap(null);
            this.zhC.setText("");
            this.zhF.setVisibility(0);
            this.zhC.setTextColor(getResources().getColor(R.color.fq));
        } else {
            this.zhB.setEnabled(true);
            this.zhC.setText(cbe.MgB);
            ((com.tencent.mm.plugin.luckymoney.a.a) g.af(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.zhE, cbe);
            this.zhF.setVisibility(0);
            this.zhC.setTextColor(getResources().getColor(R.color.fq));
        }
        if (cbe == null || cbe.iwy != 2) {
            this.zhD.setVisibility(8);
            AppMethodBeat.o(65892);
            return;
        }
        this.zhD.setVisibility(0);
        AppMethodBeat.o(65892);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(65893);
        super.onDestroy();
        this.yQU.clear();
        this.klF.stopped();
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (this.zdv != null) {
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "commentfooter release");
            this.zdv.onPause();
            this.zdv.goC();
            this.zdv.destroy();
        }
        EventCenter.instance.removeListener(this.zip);
        this.mPayLoopInterruptListener.dead();
        if (this.UYG) {
            g.aAh().azQ().set(ar.a.USERINFO_LUCKY_MONEY_CUSTOM_ENVELOPE_ENTRANCE_INT_SYNC, Integer.valueOf(((Integer) g.aAh().azQ().get(ar.a.USERINFO_LUCKY_MONEY_CUSTOM_ENVELOPE_ENTRANCE_INT_SYNC, (Object) 0)).intValue() + 1));
        }
        AppMethodBeat.o(65893);
    }

    private void qR(boolean z) {
        AppMethodBeat.i(65894);
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "do get config");
        if (z) {
            this.zhz = af.gu(getContext());
        }
        this.zim = true;
        if (af.IA(getIntent().getStringExtra("key_username"))) {
            int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_LUCKY_MONEY_ENVELOPE_HAS_SOURCE_UNION_INT_SYNC, (Object) 0)).intValue();
            this.zhZ = intValue;
            doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.ar("v1.0", intValue), false);
            AppMethodBeat.o(65894);
        } else if (this.gwE == 3) {
            int intValue2 = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_LUCKY_MONEY_ENVELOPE_HAS_SOURCE_INT_SYNC, (Object) 0)).intValue();
            this.zhZ = intValue2;
            doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.a.a("v1.0", intValue2), false);
            AppMethodBeat.o(65894);
        } else {
            int intValue3 = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_LUCKY_MONEY_ENVELOPE_HAS_SOURCE_INT_SYNC, (Object) 0)).intValue();
            this.zhZ = intValue3;
            doSceneProgress(new aq("v1.0", intValue3), false);
            AppMethodBeat.o(65894);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        AppMethodBeat.i(213521);
        boolean z = ((b) g.af(b.class)).a(b.a.clicfg_android_revert_redenvelopes_cell_config, 1) == 1;
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "is open: %s", Boolean.valueOf(z));
        if (z) {
            AppMethodBeat.o(213521);
            return R.layout.b4a;
        }
        AppMethodBeat.o(213521);
        return R.layout.b4_;
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(65895);
        if (keyEvent.getKeyCode() == 4 && this.yYJ.getVisibility() == 0) {
            this.yYJ.setVisibility(8);
            efZ();
            AppMethodBeat.o(65895);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(65895);
        return dispatchKeyEvent;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI
    public final boolean onSceneEnd(int i2, int i3, String str, final com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(65896);
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + " scenetype:" + qVar.getType());
        if (qVar instanceof ba) {
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "onsceneEnd： scene instanceof NetScenePrepareLuckyMoney");
            if (this.zio) {
                Log.i("MicroMsg.LuckyMoneyPrepareUI", "has show alert return");
                AppMethodBeat.o(65896);
                return true;
            }
            ba baVar = (ba) qVar;
            if (i2 == 0 && i3 == 0) {
                boolean z = this.mKindaEnable;
                if (this.tipDialog != null && this.tipDialog.isShowing() && !z) {
                    this.tipDialog.dismiss();
                }
                this.yYN = baVar.qwe;
                this.yYM = baVar.yQE;
                this.yYP = baVar.yXH;
                this.yUc = baVar.yQE;
                this.zhV = baVar.yXL;
                if (((ba) qVar).isJumpRemind()) {
                    Log.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() NetScenePrepareLuckyMoney show JumpRemind Alert");
                    ((ba) qVar).jumpRemind.a(this, new com.tencent.mm.wallet_core.c.h() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass21 */

                        @Override // com.tencent.mm.wallet_core.c.h
                        public final void bG(int i2, String str) {
                            AppMethodBeat.i(213490);
                            Log.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() scene:NetScenePrepareLuckyMoney JumpRemind:onNext()");
                            if (!Util.isEqual(i2, 2) || !Util.isEqual(str, "requestwxhb")) {
                                if (Util.isEqual(i2, 1)) {
                                    com.tencent.mm.plugin.account.a.b.a.b(LuckyMoneyPrepareUI.this, str, 0, true);
                                }
                                AppMethodBeat.o(213490);
                                return;
                            }
                            LuckyMoneyPrepareUI.E(LuckyMoneyPrepareUI.this);
                            AppMethodBeat.o(213490);
                        }

                        @Override // com.tencent.mm.wallet_core.c.h
                        public final void onCancel() {
                            AppMethodBeat.i(213491);
                            Log.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() scene:NetScenePrepareLuckyMoney JumpRemind:onCancel()");
                            AppMethodBeat.o(213491);
                        }
                    });
                    AppMethodBeat.o(65896);
                    return true;
                }
                PayInfo payInfo = new PayInfo();
                payInfo.dDL = baVar.wFL;
                payInfo.dVv = 37;
                payInfo.channel = this.mChannel;
                if (this.mKindaEnable) {
                    ((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, payInfo);
                } else {
                    com.tencent.mm.pluginsdk.wallet.f.a(this, payInfo, 1);
                }
                AppMethodBeat.o(65896);
                return true;
            }
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            if (i3 == 401) {
                this.yQO.setEnabled(false);
                this.yQO.setClickable(false);
                this.klF.startTimer(5000);
                com.tencent.mm.ui.base.h.cD(this, str);
                AppMethodBeat.o(65896);
                return true;
            } else if (i3 == 268502454) {
                com.tencent.mm.ui.base.h.d(this, str, "", new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass23 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(213492);
                        if (ba.l(qVar)) {
                            LuckyMoneyPrepareUI.this.finish();
                            AppMethodBeat.o(213492);
                            return;
                        }
                        AppMethodBeat.o(213492);
                    }
                });
                AppMethodBeat.o(65896);
                return true;
            } else {
                this.dYe = 2;
                if (TextUtils.isEmpty(str)) {
                    str = getString(R.string.itf);
                }
                com.tencent.mm.ui.base.h.a((Context) this, str, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass19 */

                    {
                        AppMethodBeat.i(160807);
                        AppMethodBeat.o(160807);
                    }

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(213485);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(213485);
                    }
                });
                AppMethodBeat.o(65896);
                return true;
            }
        } else {
            if (qVar instanceof bf) {
                if (i2 == 0 && i3 == 0) {
                    if (this.yYO) {
                        com.tencent.mm.ui.widget.snackbar.b.r(this, getString(R.string.dzo));
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass24 */

                            public final void run() {
                                AppMethodBeat.i(65853);
                                LuckyMoneyPrepareUI.this.finish();
                                AppMethodBeat.o(65853);
                            }
                        }, 1800);
                    } else {
                        ega();
                        this.yYK.setVisibility(0);
                        this.yYK.postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass25 */

                            public final void run() {
                                AppMethodBeat.i(213493);
                                Intent intent = new Intent();
                                intent.putExtra("key_username", LuckyMoneyPrepareUI.this.zhW);
                                intent.setClass(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyIndexUI.class);
                                intent.addFlags(67108864);
                                AppCompatActivity context = LuckyMoneyPrepareUI.this.getContext();
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$32", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                context.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$32", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                LuckyMoneyPrepareUI.this.finish();
                                AppMethodBeat.o(213493);
                            }
                        }, 1000);
                    }
                    AppMethodBeat.o(65896);
                    return true;
                } else if (i3 == 402) {
                    com.tencent.mm.ui.base.h.c(getContext(), str, "", getString(R.string.es0), getString(R.string.sz), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass26 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(65844);
                            Intent intent = new Intent();
                            intent.setClass(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyMyRecordUI.class);
                            intent.putExtra("key_type", 1);
                            intent.putExtra("key_username", LuckyMoneyPrepareUI.this.getIntent().getStringExtra("key_username"));
                            LuckyMoneyPrepareUI luckyMoneyPrepareUI = LuckyMoneyPrepareUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyPrepareUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$33", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            luckyMoneyPrepareUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyPrepareUI, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$33", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(65844);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass27 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    AppMethodBeat.o(65896);
                    return true;
                }
            } else if (qVar instanceof aq) {
                Log.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig resp,errType=" + i2 + ";errCode=" + i3 + ";errMsg=" + str);
                if (this.zhz != null && this.zhz.isShowing()) {
                    this.zhz.dismiss();
                }
                if (this.zhA != null && this.zhA.isShowing()) {
                    this.zhA.dismiss();
                }
                if (i2 == 0 && i3 == 0) {
                    final aq aqVar = (aq) qVar;
                    this.zil = true;
                    this.yXu = aqVar.yXu;
                    if (!Util.isEqual(aqVar.yXv, 1)) {
                        this.yQN.qS(true);
                    } else {
                        this.yQN.qS(false);
                        if (this.rfq != null && !Util.isNullOrNil(this.rfq.getMd5())) {
                            this.yQN.A(this.rfq);
                        }
                        this.yQN.setmOnEmojiSelectClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass28 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(213496);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                LuckyMoneyPrepareUI.this.zdz = new hf();
                                LuckyMoneyPrepareUI.this.zdz.eEH = 2;
                                LuckyMoneyPrepareUI.this.zdz.bfK();
                                final boolean isEqual = Util.isEqual(view.getTag(), "delete");
                                if (isEqual || Util.isEqual(aqVar.yXu, 1)) {
                                    d dVar = new d(LuckyMoneyPrepareUI.this.getContext());
                                    dVar.HLX = new o.f() {
                                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass28.AnonymousClass1 */

                                        @Override // com.tencent.mm.ui.base.o.f
                                        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                                            AppMethodBeat.i(213494);
                                            if (!isEqual) {
                                                if (Util.isEqual(aqVar.yXu, 1)) {
                                                    mVar.kV(1, R.string.eqn);
                                                }
                                                mVar.kV(2, R.string.eru);
                                                AppMethodBeat.o(213494);
                                                return;
                                            }
                                            mVar.a(3, LuckyMoneyPrepareUI.this.getResources().getColor(R.color.z5), LuckyMoneyPrepareUI.this.getContext().getString(R.string.eog));
                                            AppMethodBeat.o(213494);
                                        }
                                    };
                                    dVar.HLY = new o.g() {
                                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass28.AnonymousClass2 */

                                        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                                        @Override // com.tencent.mm.ui.base.o.g
                                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                            AppMethodBeat.i(213495);
                                            Log.i("MicroMsg.LuckyMoneyPrepareUI", "showLuckyHbDlg() onMMMenuItemSelected menuItemId:%s", Integer.valueOf(menuItem.getItemId()));
                                            switch (menuItem.getItemId()) {
                                                case 1:
                                                    LuckyMoneyPrepareUI.this.zdC = 1;
                                                    com.tencent.mm.plugin.emojicapture.api.b.b(LuckyMoneyPrepareUI.this, 4, LuckyMoneyPrepareUI.this.zhW);
                                                    LuckyMoneyPrepareUI.this.zdz = new hf();
                                                    LuckyMoneyPrepareUI.this.zdz.eEH = 4;
                                                    LuckyMoneyPrepareUI.this.zdz.bfK();
                                                    AppMethodBeat.o(213495);
                                                    return;
                                                case 2:
                                                    LuckyMoneyPrepareUI.this.zdC = 2;
                                                    LuckyMoneyPrepareUI.F(LuckyMoneyPrepareUI.this);
                                                    AppMethodBeat.o(213495);
                                                    return;
                                                case 3:
                                                    LuckyMoneyPrepareUI.this.zfQ = 1;
                                                    LuckyMoneyTextInputView luckyMoneyTextInputView = LuckyMoneyPrepareUI.this.yQN;
                                                    luckyMoneyTextInputView.ziF.setTag("");
                                                    luckyMoneyTextInputView.ziG.setVisibility(0);
                                                    luckyMoneyTextInputView.ziH.setVisibility(8);
                                                    LuckyMoneyPrepareUI.this.rfq = null;
                                                    LuckyMoneyPrepareUI.this.zdz = new hf();
                                                    LuckyMoneyPrepareUI.this.zdz.eEH = 5;
                                                    LuckyMoneyPrepareUI.this.zdz.bfK();
                                                    break;
                                            }
                                            AppMethodBeat.o(213495);
                                        }
                                    };
                                    dVar.dGm();
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(213496);
                                    return;
                                }
                                LuckyMoneyPrepareUI.this.zdC = 2;
                                LuckyMoneyPrepareUI.F(LuckyMoneyPrepareUI.this);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(213496);
                            }
                        });
                    }
                    if (af.IA(getIntent().getStringExtra("key_username"))) {
                        com.tencent.mm.plugin.luckymoney.b.a.eex();
                        this.yPZ = com.tencent.mm.plugin.luckymoney.b.a.eez().efe();
                    } else if (this.gwE == 3) {
                        com.tencent.mm.plugin.luckymoney.b.a.eex();
                        this.yPZ = com.tencent.mm.plugin.luckymoney.b.a.hWa().efe();
                    } else {
                        com.tencent.mm.plugin.luckymoney.b.a.eex();
                        this.yPZ = com.tencent.mm.plugin.luckymoney.b.a.eey().efe();
                    }
                    Log.i("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.yPZ);
                    if (this.mType == 1) {
                        this.yYI.setMaxAmount(this.yPZ.yPy);
                    } else {
                        this.yYI.setMaxAmount(this.yPZ.yPw);
                    }
                    this.yYI.setMinAmount(this.yPZ.yPx);
                    this.yQL.setMaxNum(this.yPZ.yPv);
                    this.zhS = aqVar.yPA;
                    this.zhR = aqVar.qww;
                    this.zhT = aqVar.yPK;
                    if (Util.isNullOrNil(this.zfX)) {
                        this.zfX = aqVar.dUb;
                    }
                    if (!Util.isNullOrNil(this.zhT) && this.yQN != null) {
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass29 */

                            public final void run() {
                                AppMethodBeat.i(213497);
                                LuckyMoneyPrepareUI.this.yQN.setHintText(LuckyMoneyPrepareUI.this.zhT);
                                AppMethodBeat.o(213497);
                            }
                        });
                    }
                    if (aqVar.yXl && this.yYO) {
                        TextView textView = (TextView) findViewById(R.id.f3f);
                        textView.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass30 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(65860);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 4, 0, 0, Integer.valueOf(LuckyMoneyPrepareUI.n(LuckyMoneyPrepareUI.this)), 9);
                                Intent intent = new Intent();
                                intent.setClass(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyCanShareListUI.class);
                                LuckyMoneyPrepareUI luckyMoneyPrepareUI = LuckyMoneyPrepareUI.this;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyPrepareUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$37", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                luckyMoneyPrepareUI.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyPrepareUI, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$37", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(65860);
                            }
                        });
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 4, 0, 0, Integer.valueOf(efB()), 8);
                        textView.setVisibility(8);
                    }
                    if (!Util.isNullOrNil(aqVar.jTx)) {
                        Log.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + aqVar.jTx);
                        this.yQS.setText(aqVar.jTx);
                        if (!Util.isNullOrNil(aqVar.yXn)) {
                            this.yQS.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass31 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(213498);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    f.p(LuckyMoneyPrepareUI.this.getContext(), aqVar.yXn, false);
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(213498);
                                }
                            });
                        }
                        this.yQS.setVisibility(0);
                    } else {
                        this.yQS.setVisibility(8);
                    }
                    i.c cVar = new i.c();
                    if (aqVar.yXp == null || Util.isNullOrNil(aqVar.yXp.content)) {
                        cVar.textColor = getResources().getColor(R.color.u_);
                    } else {
                        cVar.textColor = getResources().getColor(R.color.ae6);
                    }
                    this.yYL.removeAllViews();
                    i.a(this, this.yYL, aqVar.yXp, cVar);
                    aDH(aqVar.yPB);
                    if (this.zhR != 1) {
                        b(this.yYI.getInput(), this.zhS);
                    } else if (this.mType == 1) {
                        b(this.yYI.getInput(), this.zhS);
                    } else if (this.mType == 3) {
                        b(this.yYI.getInput(), this.zhS);
                    }
                    if (af.IA(getIntent().getStringExtra("key_username"))) {
                        com.tencent.mm.plugin.luckymoney.b.a.eex();
                        this.yVa = com.tencent.mm.plugin.luckymoney.b.a.eez().eff();
                    } else if (this.gwE == 3) {
                        com.tencent.mm.plugin.luckymoney.b.a.eex();
                        this.yVa = com.tencent.mm.plugin.luckymoney.b.a.hWa().eff();
                    } else {
                        com.tencent.mm.plugin.luckymoney.b.a.eex();
                        this.yVa = com.tencent.mm.plugin.luckymoney.b.a.eey().eff();
                    }
                    init();
                    if (this.yVa != null) {
                        if (this.yVa.yUC != null) {
                            this.zhZ = this.yVa.yUC.MgP;
                            this.zia = this.yVa.yUC.MgN;
                            this.zib = this.yVa.yUC.MgO;
                        }
                        b(this.yVa.yUC);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(991, 10);
                    } else {
                        b((cbe) null);
                    }
                    if (this.zin) {
                        Log.i("MicroMsg.LuckyMoneyPrepareUI", "doRMBPrePareBtnClick()");
                        a(this.zie, this.zif, this.zig, this.zih, this.zii, this.zij);
                    }
                } else if (this.zin) {
                    if (Util.isNullOrNil(str)) {
                        str = getString(R.string.u5);
                    }
                    u.makeText(this, str, 0).show();
                }
                Log.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig waitingGetConfig:%s ifAutoRMBPrePareBtn:%s", Boolean.valueOf(this.zim), Boolean.valueOf(this.zin));
                this.zim = false;
                this.zin = false;
                AppMethodBeat.o(65896);
                return true;
            } else if (qVar instanceof as) {
                removeSceneEndListener(1647);
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.dismiss();
                }
                if (i2 == 0 && i3 == 0) {
                    String str2 = ((as) qVar).qwI;
                    if (!Util.isNullOrNil(str2)) {
                        Log.i("MicroMsg.LuckyMoneyPrepareUI", "payUrl is not null");
                        f.a((Context) getContext(), str2, false, 3);
                    } else {
                        Log.e("MicroMsg.LuckyMoneyPrepareUI", "payUrl is null");
                    }
                    AppMethodBeat.o(65896);
                    return true;
                }
            } else if (qVar instanceof com.tencent.mm.plugin.luckymoney.f2f.a.d) {
                if (i2 == 0 && i3 == 0) {
                    boolean z2 = this.mKindaEnable;
                    if (this.tipDialog != null && this.tipDialog.isShowing() && !z2) {
                        this.tipDialog.dismiss();
                    }
                    com.tencent.mm.plugin.luckymoney.f2f.a.d dVar = (com.tencent.mm.plugin.luckymoney.f2f.a.d) qVar;
                    if (com.tencent.mm.plugin.wallet_core.utils.c.a(dVar.yRV.Lus)) {
                        if (this.tipDialog != null) {
                            this.tipDialog.dismiss();
                        }
                        new com.tencent.mm.plugin.wallet_core.utils.c(this).b(dVar.yRV.Lus);
                        AppMethodBeat.o(65896);
                        return true;
                    }
                    this.yUc = ((com.tencent.mm.plugin.luckymoney.f2f.a.d) qVar).yQE;
                    this.zhV = ((com.tencent.mm.plugin.luckymoney.f2f.a.d) qVar).yRW;
                    PayInfo payInfo2 = new PayInfo();
                    payInfo2.dDL = ((com.tencent.mm.plugin.luckymoney.f2f.a.d) qVar).dDL;
                    payInfo2.dVv = 37;
                    if (this.mKindaEnable) {
                        if (payInfo2.iqp == null) {
                            payInfo2.iqp = new Bundle();
                        }
                        payInfo2.iqp.putBoolean("isF2FHongBao", true);
                        ((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(this, payInfo2);
                    } else {
                        com.tencent.mm.wallet_core.c.af.z(37, payInfo2.dDL, i3);
                        com.tencent.mm.pluginsdk.wallet.f.a(this, payInfo2, 4);
                    }
                } else {
                    com.tencent.mm.wallet_core.c.af.z(37, "", i3);
                    if (!Util.isNullOrNil(str)) {
                        com.tencent.mm.ui.base.h.c(this, str, getString(R.string.eo2), true);
                    }
                    this.tipDialog.dismiss();
                }
                AppMethodBeat.o(65896);
                return true;
            } else if (qVar instanceof aw) {
                AppMethodBeat.o(65896);
                return true;
            }
            AppMethodBeat.o(65896);
            return false;
        }
    }

    private void A(EmojiInfo emojiInfo) {
        AppMethodBeat.i(65897);
        this.yQN.A(emojiInfo);
        if (this.zdC == 0 || this.zdC == 2) {
            if (com.tencent.mm.plugin.emoji.h.b.y(emojiInfo)) {
                this.zfQ = 2;
            } else if (com.tencent.mm.plugin.emoji.h.b.w(emojiInfo)) {
                this.zfQ = 4;
            } else {
                this.zfQ = 3;
            }
        } else if (this.zdC == 1) {
            this.zfQ = 2;
        }
        this.zdz = new hf();
        this.zdz.eEH = 1;
        this.zdz.bfK();
        AppMethodBeat.o(65897);
    }

    private void aDH(String str) {
        AppMethodBeat.i(65898);
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "initH5LuckyMoneyView  currencyWording=".concat(String.valueOf(str)));
        TextView textView = (TextView) findViewById(R.id.exz);
        if (!Util.isNullOrNil(str)) {
            textView.setText(str);
            AppMethodBeat.o(65898);
            return;
        }
        textView.setText(getString(R.string.eo0));
        AppMethodBeat.o(65898);
    }

    private void h(int i2, Intent intent) {
        aw awVar;
        AppMethodBeat.i(65899);
        String stringExtra = getIntent().getStringExtra("key_username");
        String aTY = z.aTY();
        if (i2 == -1) {
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult() resultCode == RESULT_OK");
            this.dYe = 1;
            this.zga = "";
            awVar = new aw(this.yUc, this.zfX, 1, aTY, Util.nullAsNil(stringExtra));
        } else {
            if (intent != null) {
                this.dYe = intent.getIntExtra("key_pay_reslut_type", 3);
            } else {
                Log.i("MicroMsg.LuckyMoneyPrepareUI", "doNetSceneLuckyMoneyReport() data == null");
                this.dYe = 3;
            }
            this.zga = this.yUc;
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult() resultCode != RESULT_OK  payType:%s", Integer.valueOf(this.dYe));
            awVar = new aw(this.yUc, this.zfX, this.dYe, aTY, Util.nullAsNil(stringExtra));
        }
        g.aAg().hqi.a(awVar, 0);
        AppMethodBeat.o(65899);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String md5;
        AppMethodBeat.i(65900);
        switch (i2) {
            case 1:
                if (intent != null && intent.hasExtra("key_realname_guide_helper")) {
                    this.zhU = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
                }
                if (i3 != -1) {
                    if (!ag.bH(intent)) {
                        if (!ag.bI(intent)) {
                            h(i3, intent);
                            break;
                        } else {
                            AppMethodBeat.o(65900);
                            return;
                        }
                    } else {
                        finish();
                        AppMethodBeat.o(65900);
                        return;
                    }
                } else {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 4, 0, 0, Integer.valueOf(efB()), 5);
                    String stringExtra = getIntent().getStringExtra("key_username");
                    if ((!this.yYO || Util.isNullOrNil(stringExtra)) && this.gwE != 3) {
                        ega();
                        View findViewById = findViewById(R.id.f3m);
                        this.yYJ.setVisibility(0);
                        af.a(findViewById, null);
                        this.rlN.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass34 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(65866);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 4, 0, 0, Integer.valueOf(LuckyMoneyPrepareUI.n(LuckyMoneyPrepareUI.this)), 6);
                                af.a((MMActivity) LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.this.mType, LuckyMoneyPrepareUI.this.yYN, true);
                                LuckyMoneyPrepareUI.this.yYJ.postDelayed(new Runnable() {
                                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass34.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(213501);
                                        LuckyMoneyPrepareUI.this.yYJ.setVisibility(8);
                                        LuckyMoneyPrepareUI.this.efZ();
                                        AppMethodBeat.o(213501);
                                    }
                                }, 100);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(65866);
                            }
                        });
                        ((ImageView) findViewById(R.id.f3d)).setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass35 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(65868);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                LuckyMoneyPrepareUI.this.yYJ.setVisibility(8);
                                LuckyMoneyPrepareUI.this.efZ();
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(65868);
                            }
                        });
                        h(i3, intent);
                    } else {
                        Map<String, String> parseXml = XmlParser.parseXml(this.yYP, "msg", null);
                        if (parseXml == null) {
                            Log.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
                            finish();
                            AppMethodBeat.o(65900);
                            return;
                        }
                        String str = parseXml.get(".msg.appmsg.wcpayinfo.paymsgid");
                        if (com.tencent.mm.plugin.luckymoney.b.a.eex().eeB().aDu(str)) {
                            Log.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
                            if (!af.ac(this.yYP, stringExtra, 1)) {
                                Log.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
                                com.tencent.mm.plugin.luckymoney.b.a.eex().eeB().aDv(str);
                            }
                        } else {
                            Log.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
                        }
                        h(i3, intent);
                        this.zhY = new hg();
                        this.zhY.eLv = (long) this.zfQ;
                        if (this.rfq == null) {
                            md5 = "";
                        } else {
                            md5 = this.rfq.getMd5();
                        }
                        this.zhY.uV(md5);
                        this.zhY.bfK();
                        Log.i("MicroMsg.LuckyMoneyPrepareUI", "Report RedEnvSendWithEmoticonDataStruct, Scene: %d, md5: %s", Integer.valueOf(this.zfQ), md5);
                        finish();
                    }
                    String str2 = "";
                    if (intent != null) {
                        str2 = intent.getStringExtra("key_trans_id");
                    }
                    aDI(str2);
                    break;
                }
                break;
            case 2:
                if (i3 != -1 || intent == null) {
                    if (i3 == 0) {
                        Intent intent2 = new Intent();
                        intent2.setClass(getContext(), LuckyMoneyMyRecordUI.class);
                        intent2.putExtra("key_username", getIntent().getStringExtra("key_username"));
                        intent2.putExtra("key_type", 1);
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        break;
                    }
                } else {
                    String stringExtra2 = intent.getStringExtra("Select_Conv_User");
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 4, 0, 0, Integer.valueOf(efB()), 7, stringExtra2);
                    if (Util.isNullOrNil(stringExtra2)) {
                        finish();
                        break;
                    } else {
                        doSceneProgress(new bf(stringExtra2.replaceAll(",", "|"), this.yYM, "v1.0"));
                        break;
                    }
                }
                break;
            case 3:
                if (intent != null && intent.hasExtra("result_data")) {
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra == null) {
                        Log.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY bundle is null");
                        break;
                    } else {
                        int i4 = Util.getInt(bundleExtra.getString("payState", "2"), 0);
                        Log.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY payState is " + i4 + ";STATE_H5_PAY_SUCC=0");
                        if (i4 == 0) {
                            com.tencent.mm.plugin.luckymoney.b.a.UXs = this.mType;
                            if (this.UYE) {
                                if (this.UYF) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(22237, 4);
                                } else if (this.mType != 1) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(22237, 3);
                                }
                            }
                            finish();
                            break;
                        }
                    }
                }
                break;
            case 4:
                i(i3, intent);
                break;
            case 5:
                if (i3 != -1) {
                    qR(false);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(16822, 2);
                    break;
                } else {
                    this.yYL.removeAllViews();
                    qR(true);
                    break;
                }
            case 6:
                if (i3 == -1) {
                    this.zhX = intent.getStringExtra("Select_Contact");
                    Log.i("MicroMsg.LuckyMoneyPrepareUI", "select user: %s", this.zhX);
                    if (!Util.isNullOrNil(this.zhX)) {
                        com.tencent.mm.ui.g.a.a.c(this.zhM, this.zhX);
                        this.zhN.setText(l.b(getContext(), f.ht(((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(this.zhX, this.zhW), 8), this.zhN.getTextSize()));
                        this.zhM.setVisibility(0);
                        this.zhN.setVisibility(0);
                    }
                }
                eeI();
                break;
            case 1111:
                if (i3 != -1) {
                    Log.i("MicroMsg.LuckyMoneyPrepareUI", "go emoji capture failed!");
                    break;
                } else {
                    String str3 = "";
                    if (intent != null) {
                        str3 = intent.getStringExtra("gif_md5");
                    }
                    if (Util.isNullOrNil(str3)) {
                        Log.i("MicroMsg.LuckyMoneyPrepareUI", "md5 == null go emoji capture failed!");
                        break;
                    } else {
                        this.rfq = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.blk(str3);
                        A(this.rfq);
                        break;
                    }
                }
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(65900);
    }

    public final void i(int i2, Intent intent) {
        AppMethodBeat.i(65901);
        if (i2 == -1) {
            String str = "";
            if (intent != null) {
                str = intent.getStringExtra("key_trans_id");
            }
            aDI(str);
        }
        finish();
        AppMethodBeat.o(65901);
    }

    public final void j(int i2, Intent intent) {
        AppMethodBeat.i(65902);
        if (!(this.yVa == null || this.yVa.yUC == null)) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(22296, this.yVa.yUC.Lot);
        }
        if (intent.hasExtra("key_realname_guide_helper")) {
            this.zhU = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
        }
        if (i2 == -1) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 4, 0, 0, Integer.valueOf(efB()), 5);
            String stringExtra = getIntent().getStringExtra("key_username");
            if ((!this.yYO || Util.isNullOrNil(stringExtra)) && this.gwE != 3) {
                ega();
                View findViewById = findViewById(R.id.f3m);
                this.yYJ.setVisibility(0);
                af.a(findViewById, null);
                this.rlN.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass36 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(65869);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 4, 0, 0, Integer.valueOf(LuckyMoneyPrepareUI.n(LuckyMoneyPrepareUI.this)), 6);
                        af.a((MMActivity) LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.this.mType, LuckyMoneyPrepareUI.this.yYN, true);
                        LuckyMoneyPrepareUI.this.yYJ.postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass36.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(213502);
                                LuckyMoneyPrepareUI.this.yYJ.setVisibility(8);
                                LuckyMoneyPrepareUI.this.efZ();
                                AppMethodBeat.o(213502);
                            }
                        }, 100);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(65869);
                    }
                });
                ((ImageView) findViewById(R.id.f3d)).setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass37 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(213503);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        LuckyMoneyPrepareUI.this.yYJ.setVisibility(8);
                        LuckyMoneyPrepareUI.this.efZ();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(213503);
                    }
                });
                h(i2, intent);
            } else {
                com.tencent.mm.ui.base.h.cD(this, getString(R.string.dzo));
                Map<String, String> parseXml = XmlParser.parseXml(this.yYP, "msg", null);
                if (parseXml == null) {
                    Log.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
                    finish();
                    AppMethodBeat.o(65902);
                    return;
                }
                String str = parseXml.get(".msg.appmsg.wcpayinfo.paymsgid");
                if (com.tencent.mm.plugin.luckymoney.b.a.eex().eeB().aDu(str)) {
                    Log.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
                    if (!af.ac(this.yYP, stringExtra, 1)) {
                        Log.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
                        com.tencent.mm.plugin.luckymoney.b.a.eex().eeB().aDv(str);
                    }
                } else {
                    Log.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
                }
                h(i2, intent);
                com.tencent.mm.plugin.luckymoney.story.b.e eVar = new com.tencent.mm.plugin.luckymoney.story.b.e();
                eVar.field_send_id = str;
                if (!com.tencent.mm.plugin.luckymoney.b.a.eex().eew().get(eVar, new String[0])) {
                    eVar.field_open_count = 0;
                    Log.d("MicroMsg.LuckyMoneyPrepareUI", "insert record: %s, %s", str, Boolean.valueOf(com.tencent.mm.plugin.luckymoney.b.a.eex().eew().insert(eVar)));
                }
                com.tencent.mm.plugin.luckymoney.b.a.UXs = this.mType;
                if (this.UYE) {
                    if (this.UYF) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(22237, 4);
                    } else if (this.mType != 1) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(22237, 3);
                    }
                }
                this.zhY = new hg();
                this.zhY.eLv = (long) this.zfQ;
                String md5 = this.rfq == null ? "" : this.rfq.getMd5();
                this.zhY.uV(md5);
                this.zhY.bfK();
                Log.i("MicroMsg.LuckyMoneyPrepareUI", "Report RedEnvSendWithEmoticonDataStruct, Scene: %d, md5: %s", Integer.valueOf(this.zfQ), md5);
                finish();
            }
            aDI(intent.getStringExtra("key_trans_id"));
            AppMethodBeat.o(65902);
            return;
        }
        h(i2, intent);
        AppMethodBeat.o(65902);
    }

    /* access modifiers changed from: protected */
    public final void ak(final View view, final int i2) {
        AppMethodBeat.i(65903);
        this.mKeyboard = (MyKeyboardWindow) findViewById(R.id.ijb);
        this.mKBLayout = findViewById(R.id.ija);
        View findViewById = findViewById(R.id.ijc);
        final EditText editText = (EditText) view.findViewById(R.id.f0o);
        if (this.mKeyboard == null || editText == null || this.mKBLayout == null) {
            AppMethodBeat.o(65903);
            return;
        }
        f.setNoSystemInputOnEditText(editText);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass38 */
            boolean firstTime;
            final /* synthetic */ boolean val$isShowSysKB = false;

            {
                this.firstTime = true;
            }

            public final void onFocusChange(final View view, boolean z) {
                AppMethodBeat.i(213506);
                if (!view.isFocused() || this.val$isShowSysKB) {
                    new MMHandler().postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass38.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(213505);
                            LuckyMoneyPrepareUI.this.yYL.setVisibility(0);
                            LuckyMoneyPrepareUI.this.hideTenpayKB();
                            ((InputMethodManager) LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
                            AppMethodBeat.o(213505);
                        }
                    }, 200);
                    AppMethodBeat.o(213506);
                    return;
                }
                ((InputMethodManager) LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                new MMHandler().postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass38.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(213504);
                        if (!LuckyMoneyPrepareUI.this.mKBLayout.isShown() && view.isShown()) {
                            LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
                            LuckyMoneyPrepareUI.this.yYL.setVisibility(8);
                        }
                        LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this, i2);
                        LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                        ((InputMethodManager) LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        AppMethodBeat.o(213504);
                    }
                }, 300);
                AppMethodBeat.o(213506);
            }
        });
        editText.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass39 */
            final /* synthetic */ boolean val$isShowSysKB = false;

            public final void onClick(View view) {
                AppMethodBeat.i(65875);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!LuckyMoneyPrepareUI.this.mKBLayout.isShown() && !this.val$isShowSysKB) {
                    LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
                    LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                    LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this, i2);
                } else if (this.val$isShowSysKB) {
                    LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(8);
                    LuckyMoneyPrepareUI.this.yYL.setVisibility(0);
                    ((InputMethodManager) LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65875);
            }
        });
        TextView textView = (TextView) view.findViewById(R.id.exz);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass40 */
                final /* synthetic */ boolean val$isShowSysKB = false;

                public final void onClick(View view) {
                    AppMethodBeat.i(65876);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$46", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!LuckyMoneyPrepareUI.this.mKBLayout.isShown() || this.val$isShowSysKB) {
                        if (!LuckyMoneyPrepareUI.this.mKBLayout.isShown() && !this.val$isShowSysKB) {
                            ((InputMethodManager) LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                            new MMHandler().postDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass40.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(213507);
                                    LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(0);
                                    view.requestFocus();
                                    if (LuckyMoneyPrepareUI.this.mKeyboard != null) {
                                        LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(editText);
                                    }
                                    LuckyMoneyPrepareUI.d(LuckyMoneyPrepareUI.this, i2);
                                    AppMethodBeat.o(213507);
                                }
                            }, 200);
                        } else if (this.val$isShowSysKB) {
                            LuckyMoneyPrepareUI.this.mKBLayout.setVisibility(8);
                            ((InputMethodManager) LuckyMoneyPrepareUI.this.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
                        }
                    } else if (LuckyMoneyPrepareUI.this.mKeyboard != null) {
                        LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(editText);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$46", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(65876);
                }
            });
        }
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass41 */

            public final void onClick(View view) {
                AppMethodBeat.i(213508);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$47", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LuckyMoneyPrepareUI.this.hideTenpayKB();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$47", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(213508);
            }
        });
        AppMethodBeat.o(65903);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(65904);
        if (i2 != 4 || this.mKBLayout == null || !this.mKBLayout.isShown()) {
            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(65904);
            return onKeyUp;
        }
        this.mKBLayout.setVisibility(8);
        AppMethodBeat.o(65904);
        return true;
    }

    /* access modifiers changed from: protected */
    public final void hideTenpayKB() {
        AppMethodBeat.i(65905);
        if (this.mKBLayout != null && this.mKBLayout.isShown()) {
            this.mKBLayout.setVisibility(8);
        }
        AppMethodBeat.o(65905);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.h
    public final void eeI() {
        double d2;
        double d3;
        boolean z;
        AppMethodBeat.i(65906);
        if (af.IA(getIntent().getStringExtra("key_username"))) {
            com.tencent.mm.plugin.luckymoney.b.a.eex();
            this.yPZ = com.tencent.mm.plugin.luckymoney.b.a.eez().efe();
        } else if (this.gwE == 3) {
            com.tencent.mm.plugin.luckymoney.b.a.eex();
            this.yPZ = com.tencent.mm.plugin.luckymoney.b.a.hWa().efe();
        } else {
            com.tencent.mm.plugin.luckymoney.b.a.eex();
            this.yPZ = com.tencent.mm.plugin.luckymoney.b.a.eey().efe();
        }
        if (this.mType == 3 && this.yYI.eeH() != 3) {
            double input = this.yYI.getInput();
            if (Util.isNullOrNil(this.zhX)) {
                d2 = 0.0d;
                d3 = input;
            } else {
                d2 = input;
                d3 = input;
            }
        } else if (this.mType == 3 || this.yYI.eeH() == 3 || this.yQL.eeH() == 3) {
            d2 = 0.0d;
            d3 = 0.0d;
        } else {
            int input2 = this.yQL.getInput();
            double input3 = this.yYI.getInput();
            if (this.mType == 0) {
                double d4 = input3 * ((double) input2);
                d2 = this.yYI.getInput();
                d3 = d4;
            } else if (input2 > 0) {
                d2 = f.a(String.valueOf(input3), String.valueOf(input2), String.valueOf(this.yPZ.yPv).length() + 2, RoundingMode.HALF_UP);
                d3 = input3;
            } else {
                d2 = 0.0d;
                d3 = input3;
            }
        }
        if (this.yQU.egj()) {
            Log.i("MicroMsg.LuckyMoneyPrepareUI", "has error");
            this.yQO.setClickable(false);
            this.yQO.setEnabled(false);
        } else {
            if (d3 == 0.0d || d2 == 0.0d) {
                z = true;
            } else if (d3 > this.yPZ.yPy && this.yPZ.yPy > 0.0d) {
                this.yQU.aeu(getString(R.string.esj, new Object[]{new StringBuilder().append(Math.round(this.yPZ.yPy)).toString(), Util.nullAs(this.yPZ.yPB, "")}));
                z = true;
            } else if (d2 > 0.0d) {
                Log.i("MicroMsg.LuckyMoneyPrepareUI", "perAmount ".concat(String.valueOf(d2)));
                if (this.mType == 0) {
                    if (d2 > this.yPZ.yPw && this.yPZ.yPw > 0.0d) {
                        if (egE()) {
                            this.yQU.aeu(getString(R.string.er2, new Object[]{this.yPZ.yUV, new StringBuilder().append(Math.round(this.yPZ.yPw)).toString(), Util.nullAs(this.yPZ.yPB, "")}));
                        } else {
                            this.yQU.aeu(getString(R.string.er1, new Object[]{new StringBuilder().append(Math.round(this.yPZ.yPw)).toString(), Util.nullAs(this.yPZ.yPB, "")}));
                        }
                        z = true;
                    }
                    z = false;
                } else {
                    if (d2 > this.yPZ.yPz && this.yPZ.yPz > 0.0d) {
                        if (this.yPZ == null || Util.isNullOrNil(this.yPZ.yUV)) {
                            this.yQU.aeu(getString(R.string.er1, new Object[]{new StringBuilder().append(Math.round(this.yPZ.yPz)).toString(), Util.nullAs(this.yPZ.yPB, "")}));
                        } else {
                            this.yQU.aeu(getString(R.string.er2, new Object[]{this.yPZ.yUV, new StringBuilder().append(Math.round(this.yPZ.yPz)).toString(), Util.nullAs(this.yPZ.yPB, "")}));
                        }
                        this.yQL.onError();
                        this.yYI.onError();
                        z = true;
                    }
                    z = false;
                }
                Log.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + z + " for max value");
                if (!z) {
                    if (this.mType == 0) {
                        if (d2 < this.yPZ.yPx) {
                            if (egE()) {
                                this.yQU.aeu(getString(R.string.er4, new Object[]{this.yPZ.yUV, f.formatMoney2f(this.yPZ.yPx), Util.nullAs(this.yPZ.yPB, "")}));
                            } else {
                                this.yQU.aeu(getString(R.string.er3, new Object[]{f.formatMoney2f(this.yPZ.yPx), Util.nullAs(this.yPZ.yPB, "")}));
                            }
                            z = true;
                        }
                    } else if (d2 < 0.01d) {
                        if (egE()) {
                            this.yQU.aeu(getString(R.string.er4, new Object[]{this.yPZ.yUV, "0.01", Util.nullAs(this.yPZ.yPB, "")}));
                        } else {
                            this.yQU.aeu(getString(R.string.er3, new Object[]{"0.01", Util.nullAs(this.yPZ.yPB, "")}));
                        }
                        this.yQL.onError();
                        this.yYI.onError();
                        z = true;
                    }
                }
                Log.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + z + " for min value");
            } else {
                z = false;
            }
            if (z) {
                this.yQO.setClickable(false);
                this.yQO.setEnabled(false);
            } else {
                this.yQO.setClickable(true);
                this.yQO.setEnabled(true);
            }
        }
        b(d3, this.zhS);
        AppMethodBeat.o(65906);
    }

    private boolean egE() {
        AppMethodBeat.i(65907);
        if (this.yPZ == null || Util.isNullOrNil(this.yPZ.yUV)) {
            AppMethodBeat.o(65907);
            return false;
        }
        AppMethodBeat.o(65907);
        return true;
    }

    private void b(double d2, String str) {
        AppMethodBeat.i(65908);
        if (Util.isNullOrNil(str)) {
            this.qAC.setText(f.D(d2));
            AppMethodBeat.o(65908);
            return;
        }
        this.qAC.setText(str + f.formatMoney2f(d2));
        AppMethodBeat.o(65908);
    }

    private int efB() {
        AppMethodBeat.i(65909);
        if (!this.yYO) {
            AppMethodBeat.o(65909);
            return 3;
        } else if (getIntent().getIntExtra("key_chatroom_num", 0) > 0) {
            AppMethodBeat.o(65909);
            return 2;
        } else {
            AppMethodBeat.o(65909);
            return 1;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(65910);
        if (this.zhU != null) {
            Intent intent = new Intent();
            intent.putExtra("key_realname_guide_helper", this.zhU);
            com.tencent.mm.br.c.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", intent);
        }
        super.finish();
        AppMethodBeat.o(65910);
    }

    private void aDI(String str) {
        AppMethodBeat.i(65911);
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "do business callback");
        if (af.IA(getIntent().getStringExtra("key_username"))) {
            doSceneProgress(new an(this.yUc, str, this.zhV), false);
            AppMethodBeat.o(65911);
            return;
        }
        doSceneProgress(new am(this.yUc, str, this.zhV), false);
        AppMethodBeat.o(65911);
    }

    static /* synthetic */ void a(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        AppMethodBeat.i(65912);
        com.tencent.mm.plugin.luckymoney.ui.a.b.a(luckyMoneyPrepareUI, luckyMoneyPrepareUI.zdv);
        luckyMoneyPrepareUI.zdk.dismiss();
        AppMethodBeat.o(65912);
    }

    static /* synthetic */ void c(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        AppMethodBeat.i(213522);
        Log.i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick()");
        luckyMoneyPrepareUI.Qb(0);
        AppMethodBeat.o(213522);
    }

    static /* synthetic */ void A(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        AppMethodBeat.i(258725);
        luckyMoneyPrepareUI.zik = new d(luckyMoneyPrepareUI);
        luckyMoneyPrepareUI.zik.HLX = new o.f() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass10 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                AppMethodBeat.i(213480);
                mVar.add(0, 0, 0, LuckyMoneyPrepareUI.this.getString(R.string.eoc));
                mVar.add(0, 1, 0, LuckyMoneyPrepareUI.this.getString(R.string.ie0));
                AppMethodBeat.o(213480);
            }
        };
        luckyMoneyPrepareUI.zik.HLY = new o.g() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass11 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(213481);
                if (i2 == 0) {
                    Intent intent = new Intent();
                    intent.setClass(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyMyRecordUI.class);
                    intent.putExtra("key_username", LuckyMoneyPrepareUI.this.getIntent().getStringExtra("key_username"));
                    intent.putExtra("key_type", 2);
                    LuckyMoneyPrepareUI luckyMoneyPrepareUI = LuckyMoneyPrepareUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyPrepareUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$19", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    luckyMoneyPrepareUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyPrepareUI, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$19", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(213481);
                    return;
                }
                if (i2 == 1) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(15511, Integer.valueOf(LuckyMoneyPrepareUI.this.zhR), 1);
                    if (LuckyMoneyPrepareUI.this.zhR == 1) {
                        f.p(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyPrepareUI.yQK, false);
                        AppMethodBeat.o(213481);
                        return;
                    }
                    Object[] objArr = new Object[1];
                    objArr[0] = LuckyMoneyPrepareUI.this.yPZ != null ? LuckyMoneyPrepareUI.this.yPZ.yUU : "";
                    Log.i("MicroMsg.LuckyMoneyPrepareUI", "show qa foreign, config url: %s", objArr);
                    if (LuckyMoneyPrepareUI.this.yPZ == null || Util.isNullOrNil(LuckyMoneyPrepareUI.this.yPZ.yUU)) {
                        f.p(LuckyMoneyPrepareUI.this.getContext(), "https://hkwallet.moneydata.hk/hybrid/www/weixin/hongbao_hk_v2/zh_hk/faq.shtml", false);
                    } else {
                        f.p(LuckyMoneyPrepareUI.this.getContext(), LuckyMoneyPrepareUI.this.yPZ.yUU, false);
                        AppMethodBeat.o(213481);
                        return;
                    }
                }
                AppMethodBeat.o(213481);
            }
        };
        luckyMoneyPrepareUI.zik.dGm();
        AppMethodBeat.o(258725);
    }

    static /* synthetic */ void a(LuckyMoneyPrepareUI luckyMoneyPrepareUI, byte[] bArr, boolean z, boolean z2) {
        AppMethodBeat.i(258726);
        Intent intent = new Intent(luckyMoneyPrepareUI.getContext(), LuckyMoneyPickEnvelopeUI.class);
        if (bArr != null && bArr.length > 0) {
            intent.putExtra(e.i.Oze, bArr);
        }
        intent.putExtra("key_session_id", luckyMoneyPrepareUI.mSessionId);
        intent.putExtra(e.i.Ozf, z);
        intent.putExtra(e.i.Ozi, z2);
        intent.putExtra(e.i.Ozg, luckyMoneyPrepareUI.zia);
        intent.putExtra(e.i.Ozh, luckyMoneyPrepareUI.zib);
        luckyMoneyPrepareUI.startActivityForResult(intent, 5);
        AppMethodBeat.o(258726);
    }

    static /* synthetic */ void F(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        int i2;
        AppMethodBeat.i(258728);
        luckyMoneyPrepareUI.zdz = new hf();
        luckyMoneyPrepareUI.zdz.eEH = 3;
        luckyMoneyPrepareUI.zdz.bfK();
        luckyMoneyPrepareUI.hideTenpayKB();
        luckyMoneyPrepareUI.hideVKB();
        luckyMoneyPrepareUI.zdk.show();
        if (Util.isEqual(luckyMoneyPrepareUI.yXu, 1)) {
            i2 = ChatFooterPanel.KbL;
        } else {
            i2 = ChatFooterPanel.KbI;
        }
        com.tencent.mm.plugin.luckymoney.ui.a.b.a(luckyMoneyPrepareUI.zdx, luckyMoneyPrepareUI.zdv, i2, new ac.a() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.AnonymousClass32 */

            @Override // com.tencent.mm.api.ac.a
            public final void a(r rVar) {
                AppMethodBeat.i(213499);
                Log.i("MicroMsg.LuckyMoneyPrepareUI", "[onSelectedEmoji] emojiInfo:%s", rVar);
                LuckyMoneyPrepareUI.this.rfq = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.blk(rVar.getMd5());
                LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.this.rfq);
                LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this);
                AppMethodBeat.o(213499);
            }

            @Override // com.tencent.mm.api.ac.a
            public final void onHide() {
                AppMethodBeat.i(258720);
                LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this);
                AppMethodBeat.o(258720);
            }
        });
        AppMethodBeat.o(258728);
    }

    static /* synthetic */ void d(LuckyMoneyPrepareUI luckyMoneyPrepareUI, int i2) {
        AppMethodBeat.i(258730);
        luckyMoneyPrepareUI.mKeyboard.setXMode(i2);
        AppMethodBeat.o(258730);
    }
}
