package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.r;
import com.tencent.mm.emoji.d.i;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.b.a.ex;
import com.tencent.mm.g.b.a.ey;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.ab;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.model.aw;
import com.tencent.mm.plugin.luckymoney.model.ba;
import com.tencent.mm.plugin.luckymoney.model.bc;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollView;
import com.tencent.mm.plugin.luckymoney.ui.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.wallet_core.ui.f;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

@a(3)
public class LuckyMoneyNewYearSendUI extends LuckyMoneyBaseUI {
    private int dYe = 0;
    private View.OnClickListener kuO = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.AnonymousClass6 */

        public final void onClick(View view) {
            AppMethodBeat.i(65693);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearSendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getId() == R.id.f2r) {
                h.INSTANCE.a(13079, 5, 1);
                Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSendBtn click!");
                LuckyMoneyNewYearSendUI.b(LuckyMoneyNewYearSendUI.this);
            } else if (view.getId() == R.id.f2t) {
                LuckyMoneyNewYearSendUI.this.finish();
                h.INSTANCE.a(13079, 6, 1);
                LuckyMoneyNewYearSendUI.this.zfO = new ex();
                LuckyMoneyNewYearSendUI.this.zfO.eEH = 11;
                LuckyMoneyNewYearSendUI.this.zfO.bfK();
                LuckyMoneyNewYearSendUI.d(LuckyMoneyNewYearSendUI.this);
            } else if (view.getId() == R.id.f2g || view.getId() == R.id.f2l) {
                LuckyMoneyNewYearSendUI.this.zfO = new ex();
                LuckyMoneyNewYearSendUI.this.zfO.eEH = 3;
                LuckyMoneyNewYearSendUI.this.zfO.bfK();
                LuckyMoneyNewYearSendUI.e(LuckyMoneyNewYearSendUI.this);
            } else if (view.getId() == R.id.f2i) {
                LuckyMoneyNewYearSendUI.this.rfq = null;
                LuckyMoneyNewYearSendUI.this.zfN = null;
                LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 0);
                g.aAh().azQ().set(ar.a.USERINFO_WALLET_HONGBAO_NEW_YEAR_LAST_SEND_EMOJI_MD5_STRING, "");
                h.INSTANCE.a(13079, 3, 1);
                LuckyMoneyNewYearSendUI.this.zfO = new ex();
                LuckyMoneyNewYearSendUI.this.zfO.eEH = 5;
                LuckyMoneyNewYearSendUI.this.zfO.bfK();
            } else if (view.getId() == R.id.f2o) {
                LuckyMoneyAutoScrollView luckyMoneyAutoScrollView = LuckyMoneyNewYearSendUI.this.zeW;
                luckyMoneyAutoScrollView.hasCallBack = false;
                luckyMoneyAutoScrollView.zbJ.setVisibility(0);
                luckyMoneyAutoScrollView.zbK.setVisibility(0);
                luckyMoneyAutoScrollView.zbL.setVisibility(0);
                luckyMoneyAutoScrollView.zbP.setVisibility(4);
                luckyMoneyAutoScrollView.zbQ.setVisibility(4);
                luckyMoneyAutoScrollView.zbR.setVisibility(4);
                LuckyMoneyNewYearSendUI.i(LuckyMoneyNewYearSendUI.this);
                h.INSTANCE.a(13079, 4, 1);
                LuckyMoneyNewYearSendUI.this.zfO = new ex();
                LuckyMoneyNewYearSendUI.this.zfO.eEH = 2;
                LuckyMoneyNewYearSendUI.this.zfO.bfK();
            } else if (view.getId() == R.id.f2p) {
                i iVar = i.hdO;
                i.zm(LuckyMoneyNewYearSendUI.this.zfW);
                LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, false);
                LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 4);
            } else if (view.getId() == R.id.f2f) {
                LuckyMoneyNewYearSendUI.e(LuckyMoneyNewYearSendUI.this);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearSendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65693);
        }
    };
    private int mChannel;
    private MMHandler mHandler = new MMHandler();
    private EmojiInfo rfq;
    private Button rlN;
    private Dialog tipDialog = null;
    private String yUc = "";
    private int yUr;
    private String yXk;
    private int yXm;
    private int yXt = 0;
    private LinkedList<ab> yXw;
    private String yYP;
    private TextView yln;
    private int zdC = 0;
    private a zdk;
    private View zdl;
    private ChatFooterPanel zdv;
    private ViewGroup zdx;
    private LuckyMoneyAutoScrollView zeW;
    private TextView zeX;
    private TextView zfA;
    private ImageView zfB;
    private TextView zfC;
    private ImageView zfD;
    private ImageView zfE;
    private TextView zfF;
    private LinearLayout zfG;
    private MMAnimateView zfH;
    private LinearLayout zfI;
    private String zfJ;
    private boolean zfK = true;
    private int zfL = 0;
    private int zfM = 0;
    private EmojiInfo zfN;
    private ex zfO;
    private ey zfP;
    private int zfQ = 1;
    private int zfR = 0;
    private int zfS = 0;
    private int zfT = 0;
    private int zfU = 0;
    private int zfV = 0;
    private long zfW = 0;
    private String zfX = "";
    private int zfY = 0;
    private com.tencent.mm.emoji.d.a zfZ = new com.tencent.mm.emoji.d.a() {
        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.AnonymousClass4 */

        @Override // com.tencent.mm.emoji.d.a
        public final void a(long j2, boolean z, String str) {
            boolean z2 = false;
            AppMethodBeat.i(65691);
            Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "onResult() mTimeEnter:%s  timeEnter:%s  success:%s  md5:%s", Long.valueOf(LuckyMoneyNewYearSendUI.this.zfW), Long.valueOf(j2), Boolean.valueOf(z), str);
            if (Util.isEqual(LuckyMoneyNewYearSendUI.this.zfW, j2)) {
                if (z) {
                    LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, str);
                } else {
                    if (Util.isEqual(LuckyMoneyNewYearSendUI.this.zfY, 0)) {
                        EmojiInfo Nl = bj.gCJ().OpN.Nl(LuckyMoneyNewYearSendUI.this.zfW);
                        if (Nl != null && Nl.hYs() == EmojiInfo.a.STATUS_UPLOAD_FAIL) {
                            switch (b.AnonymousClass1.rnE[Nl.hYv().ordinal()]) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                    z2 = true;
                                    break;
                            }
                        }
                        if (z2) {
                            LuckyMoneyNewYearSendUI.z(LuckyMoneyNewYearSendUI.this);
                            LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 3);
                            AppMethodBeat.o(65691);
                            return;
                        }
                    }
                    LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, 5);
                }
                LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, true);
                com.tencent.mm.emoji.d.b bVar = com.tencent.mm.emoji.d.b.hdv;
                com.tencent.mm.emoji.d.b.b(LuckyMoneyNewYearSendUI.this.zfW, LuckyMoneyNewYearSendUI.this.zfZ);
            }
            AppMethodBeat.o(65691);
        }
    };
    private ImageView zfk;
    private View zfl;
    private BaseEmojiView zfm;
    private View zfy;
    private View zfz;
    private String zga = "";

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LuckyMoneyNewYearSendUI() {
        AppMethodBeat.i(65703);
        AppMethodBeat.o(65703);
    }

    static /* synthetic */ void a(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI, int i2) {
        AppMethodBeat.i(65721);
        luckyMoneyNewYearSendUI.PW(i2);
        AppMethodBeat.o(65721);
    }

    static /* synthetic */ void a(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI, String str) {
        AppMethodBeat.i(174382);
        luckyMoneyNewYearSendUI.aDE(str);
        AppMethodBeat.o(174382);
    }

    static /* synthetic */ void a(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI, boolean z) {
        AppMethodBeat.i(65723);
        luckyMoneyNewYearSendUI.qO(z);
        AppMethodBeat.o(65723);
    }

    static /* synthetic */ void d(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        AppMethodBeat.i(65719);
        luckyMoneyNewYearSendUI.PV(2);
        AppMethodBeat.o(65719);
    }

    static /* synthetic */ void i(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        AppMethodBeat.i(65722);
        luckyMoneyNewYearSendUI.egr();
        AppMethodBeat.o(65722);
    }

    static /* synthetic */ void o(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        AppMethodBeat.i(174379);
        luckyMoneyNewYearSendUI.egq();
        AppMethodBeat.o(174379);
    }

    static /* synthetic */ View q(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        AppMethodBeat.i(65727);
        View contentView = luckyMoneyNewYearSendUI.getContentView();
        AppMethodBeat.o(65727);
        return contentView;
    }

    static /* synthetic */ View r(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        AppMethodBeat.i(174380);
        View contentView = luckyMoneyNewYearSendUI.getContentView();
        AppMethodBeat.o(174380);
        return contentView;
    }

    static /* synthetic */ void x(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        AppMethodBeat.i(174381);
        luckyMoneyNewYearSendUI.PX(1);
        AppMethodBeat.o(174381);
    }

    static /* synthetic */ int z(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        int i2 = luckyMoneyNewYearSendUI.zfY;
        luckyMoneyNewYearSendUI.zfY = i2 + 1;
        return i2;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(65704);
        super.onCreate(bundle);
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "lucky send ui create");
        this.zfJ = getIntent().getStringExtra("key_username");
        this.yUr = getIntent().getIntExtra("key_way", 0);
        this.mChannel = getIntent().getIntExtra("pay_channel", -1);
        if (Util.isNullOrNil(this.zfJ)) {
            Log.w("MicroMsg.LuckyMoneyNewYearSendUI", "name null finish");
            finish();
        }
        initView();
        doSceneProgress(new aq(8, "v1.0", ((Integer) g.aAh().azQ().get(ar.a.USERINFO_LUCKY_MONEY_ENVELOPE_HAS_SOURCE_INT_SYNC, (Object) 0)).intValue()));
        h.INSTANCE.a(13079, 1, 1);
        AppMethodBeat.o(65704);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(65705);
        super.onDestroy();
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (this.zdv != null) {
            Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "commentfooter release");
            this.zdv.onPause();
            this.zdv.goC();
            this.zdv.destroy();
        }
        com.tencent.mm.emoji.d.b bVar = com.tencent.mm.emoji.d.b.hdv;
        com.tencent.mm.emoji.d.b.b(this.zfW, this.zfZ);
        AppMethodBeat.o(65705);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(65706);
        setActionbarColor(-839716110);
        setContentViewVisibility(8);
        this.zfy = findViewById(R.id.f37);
        this.zeX = (TextView) findViewById(R.id.ey0);
        this.zeW = (LuckyMoneyAutoScrollView) findViewById(R.id.f2d);
        this.yln = (TextView) findViewById(R.id.f2u);
        this.rlN = (Button) findViewById(R.id.f2r);
        this.rlN.setOnClickListener(this.kuO);
        ((ImageView) findViewById(R.id.f2t)).setOnClickListener(this.kuO);
        this.zfk = (ImageView) findViewById(R.id.f2m);
        this.zfz = findViewById(R.id.f2k);
        this.zfA = (TextView) findViewById(R.id.f2l);
        this.zfB = (ImageView) findViewById(R.id.f2g);
        this.zfB.setOnClickListener(this.kuO);
        this.zfC = (TextView) findViewById(R.id.f2l);
        this.zfC.setOnClickListener(this.kuO);
        this.zfl = findViewById(R.id.f2j);
        this.zfm = (BaseEmojiView) findViewById(R.id.f2f);
        this.zfm.setOnClickListener(this.kuO);
        this.zfE = (ImageView) findViewById(R.id.f2i);
        this.zfE.setOnClickListener(this.kuO);
        this.zfD = (ImageView) findViewById(R.id.f2h);
        this.zfF = (TextView) findViewById(R.id.f2p);
        this.zfF.setOnClickListener(this.kuO);
        this.zfG = (LinearLayout) findViewById(R.id.f2e);
        this.zfH = (MMAnimateView) findViewById(R.id.epj);
        this.zfI = (LinearLayout) findViewById(R.id.f2o);
        this.zfI.setOnClickListener(this.kuO);
        this.zdk = new a(this);
        this.zdl = getLayoutInflater().inflate(R.layout.b3s, (ViewGroup) null);
        this.zdk.setContentView(this.zdl, new ViewGroup.LayoutParams(-1, -1));
        this.zdl.findViewById(R.id.f0_).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(65688);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearSendUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearSendUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65688);
            }
        });
        this.zdk.zbp = new a.AbstractC1468a() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.luckymoney.ui.a.AbstractC1468a
            public final void efU() {
                AppMethodBeat.i(65692);
                LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
                AppMethodBeat.o(65692);
            }
        };
        this.zdx = (ViewGroup) this.zdl.findViewById(R.id.f0b);
        this.zdv = e.Knc.eZ(getContext());
        this.zdv.setTalkerName(this.zfJ);
        this.zdv.setShowSmiley(false);
        AppMethodBeat.o(65706);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(65707);
        PV(2);
        finish();
        AppMethodBeat.o(65707);
    }

    private void PV(int i2) {
        AppMethodBeat.i(65708);
        this.zfP = new ey();
        this.zfP.enl = (long) i2;
        this.zfP.eEI = (long) this.zfQ;
        this.zfP.eEJ = (long) this.zfR;
        this.zfP.eEK = (long) this.zfS;
        this.zfP.eEL = (long) this.zfT;
        this.zfP.eEO = (long) this.zfU;
        this.zfP.eEM = (long) this.zfV;
        this.zfP.rU(this.rfq == null ? "" : this.rfq.getMd5());
        this.zfP.bfK();
        AppMethodBeat.o(65708);
    }

    private void egq() {
        int i2;
        AppMethodBeat.i(65709);
        this.zfO = new ex();
        this.zfO.eEH = 10;
        this.zfO.bfK();
        this.zdC = 2;
        this.zdk.show();
        if (Util.isEqual(this.zfL, 1)) {
            i2 = ChatFooterPanel.KbK;
        } else {
            i2 = ChatFooterPanel.KbH;
        }
        com.tencent.mm.plugin.luckymoney.ui.a.b.a(this.zdx, this.zdv, i2, new ac.a() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.AnonymousClass7 */

            @Override // com.tencent.mm.api.ac.a
            public final void a(r rVar) {
                AppMethodBeat.i(65694);
                Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "[onSelectedEmoji] emojiInfo:%s", rVar);
                LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, rVar);
                LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
                AppMethodBeat.o(65694);
            }

            @Override // com.tencent.mm.api.ac.a
            public final void onHide() {
                AppMethodBeat.i(258689);
                LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this);
                AppMethodBeat.o(258689);
            }
        });
        AppMethodBeat.o(65709);
    }

    private void aDE(String str) {
        AppMethodBeat.i(65710);
        this.rfq = k.getEmojiStorageMgr().OpN.blk(str);
        this.zfm.setEmojiInfo(this.rfq);
        PW(2);
        g.aAh().azQ().set(ar.a.USERINFO_WALLET_HONGBAO_NEW_YEAR_LAST_SEND_EMOJI_MD5_STRING, str);
        AppMethodBeat.o(65710);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void PW(int i2) {
        AppMethodBeat.i(65711);
        if (Util.isEqual(this.yXt, 0)) {
            this.zfk.setVisibility(0);
            this.zfz.setVisibility(8);
            this.zfl.setVisibility(8);
            AppMethodBeat.o(65711);
            return;
        }
        this.zfk.setVisibility(8);
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "exchangeExpressionState() state:%s", Integer.valueOf(i2));
        switch (i2) {
            case 0:
                this.zfz.setVisibility(0);
                this.zfA.setText(R.string.env);
                this.zfl.setVisibility(8);
                AppMethodBeat.o(65711);
                return;
            case 1:
                this.zfz.setVisibility(8);
                this.zfl.setVisibility(0);
                this.zfD.setVisibility(0);
                this.zfm.setVisibility(8);
                this.zfE.setVisibility(8);
                this.zfF.setVisibility(8);
                this.zfG.setVisibility(8);
                AppMethodBeat.o(65711);
                return;
            case 2:
                if (this.zfN != null) {
                    this.zfO = new ex();
                    this.zfO.eEH = 4;
                    this.zfO.bfK();
                }
                this.zfN = this.rfq;
                if (this.zdC == 0) {
                    if (com.tencent.mm.plugin.emoji.h.b.y(this.rfq)) {
                        this.zfQ = 2;
                    } else if (com.tencent.mm.plugin.emoji.h.b.w(this.rfq)) {
                        this.zfQ = 4;
                    } else {
                        this.zfQ = 3;
                    }
                } else if (this.zdC == 1) {
                    this.zfQ = 2;
                    this.zfS++;
                } else if (this.zdC == 2) {
                    if (com.tencent.mm.plugin.emoji.h.b.y(this.rfq)) {
                        this.zfQ = 2;
                        this.zfV++;
                    } else if (com.tencent.mm.plugin.emoji.h.b.w(this.rfq)) {
                        this.zfQ = 4;
                        this.zfU++;
                    } else {
                        this.zfQ = 3;
                        this.zfT++;
                    }
                }
                this.zfz.setVisibility(8);
                this.zfl.setVisibility(0);
                this.zfD.setVisibility(8);
                this.zfm.setVisibility(0);
                this.zfE.setVisibility(0);
                this.zfF.setVisibility(8);
                this.zfG.setVisibility(8);
                AppMethodBeat.o(65711);
                return;
            case 3:
                this.zfz.setVisibility(8);
                this.zfl.setVisibility(0);
                this.zfD.setVisibility(8);
                this.zfm.setVisibility(8);
                this.zfE.setVisibility(8);
                this.zfF.setVisibility(0);
                this.zfG.setVisibility(8);
                AppMethodBeat.o(65711);
                return;
            case 4:
                this.zfz.setVisibility(8);
                this.zfl.setVisibility(0);
                this.zfD.setVisibility(8);
                this.zfm.setVisibility(8);
                this.zfE.setVisibility(8);
                this.zfF.setVisibility(8);
                this.zfG.setVisibility(0);
                this.zfH.setImageResource(R.raw.lucky_money_newyear_creat_loading);
                AppMethodBeat.o(65711);
                return;
            case 5:
                this.zfz.setVisibility(0);
                this.zfA.setText(R.string.eqi);
                this.zfl.setVisibility(8);
                break;
        }
        AppMethodBeat.o(65711);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b44;
    }

    private void PX(int i2) {
        AppMethodBeat.i(65712);
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend()");
        h.INSTANCE.a(11701, 15, 3, 0, 1, 1);
        if (this.tipDialog == null) {
            this.tipDialog = com.tencent.mm.wallet_core.ui.h.a((Context) getContext(), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.AnonymousClass10 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(65698);
                    if (LuckyMoneyNewYearSendUI.this.tipDialog != null && LuckyMoneyNewYearSendUI.this.tipDialog.isShowing()) {
                        LuckyMoneyNewYearSendUI.this.tipDialog.dismiss();
                    }
                    if (LuckyMoneyNewYearSendUI.q(LuckyMoneyNewYearSendUI.this).getVisibility() == 8 || LuckyMoneyNewYearSendUI.r(LuckyMoneyNewYearSendUI.this).getVisibility() == 4) {
                        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "usr cancel, & visibility not visiable, so finish");
                        LuckyMoneyNewYearSendUI.this.finish();
                    }
                    LuckyMoneyNewYearSendUI.this.zbX.forceCancel();
                    AppMethodBeat.o(65698);
                }
            });
        } else if (!this.tipDialog.isShowing()) {
            this.tipDialog.show();
        }
        String aTY = z.aTY();
        String str = "";
        int i3 = 0;
        if (this.rfq != null) {
            str = this.rfq.getMd5();
            i3 = this.rfq.field_type;
        }
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend() mUniqueId:%s userConfirmJump:%s lastPayResult:%s mSendId:%s", this.zfX, Integer.valueOf(i2), Integer.valueOf(this.dYe), this.yUc);
        doSceneProgress(new bc(this.yXm, this.yXk, af.aDw(aTY), this.zfJ, aTY, z.aUa(), this.yUr, str, i3, this.zfX, i2, this.dYe, this.yUc), false);
        AppMethodBeat.o(65712);
    }

    private void egr() {
        int i2;
        AppMethodBeat.i(65713);
        this.zfR++;
        if (this.yXw == null || this.yXw.size() <= 0) {
            Log.e("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex yearMessList is empty!");
            i2 = -1;
        } else {
            g.aAi();
            g.aAf();
            int uin = com.tencent.mm.kernel.a.getUin();
            int size = this.yXw.size();
            i2 = (new Random((long) uin).nextInt(size) + ((int) (System.currentTimeMillis() % ((long) size)))) % size;
            Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex retRand:".concat(String.valueOf(i2)));
        }
        this.zfM = i2;
        if (this.zfM >= 0 && this.zfM < this.yXw.size()) {
            this.yXm = this.yXw.get(this.zfM).yWB;
            this.yXk = this.yXw.get(this.zfM).yWC;
        }
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSelectIndex:" + this.zfM + " randomAmount:" + this.yXm + " randomWishing:" + this.yXk);
        this.zeW.setFinalText(f.formatMoney2f(((double) this.yXm) / 100.0d));
        qO(false);
        this.zeW.setFocusable(false);
        this.zeW.setContentDescription("");
        this.zeW.a(new LuckyMoneyAutoScrollView.a() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.AnonymousClass11 */

            @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollView.a
            public final void efY() {
                AppMethodBeat.i(65700);
                if (LuckyMoneyNewYearSendUI.this.zfK) {
                    LuckyMoneyNewYearSendUI.this.yln.setVisibility(4);
                    af.a(LuckyMoneyNewYearSendUI.this.getContext(), LuckyMoneyNewYearSendUI.this.yln, LuckyMoneyNewYearSendUI.this.yXk);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(500);
                    alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.AnonymousClass11.AnonymousClass1 */

                        public final void onAnimationStart(Animation animation) {
                            AppMethodBeat.i(65699);
                            LuckyMoneyNewYearSendUI.this.yln.setVisibility(0);
                            AppMethodBeat.o(65699);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                        }
                    });
                    LuckyMoneyNewYearSendUI.this.yln.startAnimation(alphaAnimation);
                    LuckyMoneyNewYearSendUI.this.zfK = false;
                } else {
                    af.a(LuckyMoneyNewYearSendUI.this.getContext(), LuckyMoneyNewYearSendUI.this.yln, LuckyMoneyNewYearSendUI.this.yXk);
                    LuckyMoneyNewYearSendUI.this.yln.invalidate();
                }
                LuckyMoneyNewYearSendUI.a(LuckyMoneyNewYearSendUI.this, true);
                LuckyMoneyNewYearSendUI.this.zeW.setFocusable(true);
                LuckyMoneyNewYearSendUI.this.zeW.setContentDescription(new StringBuilder().append(((double) LuckyMoneyNewYearSendUI.this.yXm) / 100.0d).toString());
                AppMethodBeat.o(65700);
            }
        });
        AppMethodBeat.o(65713);
    }

    private void qO(boolean z) {
        AppMethodBeat.i(65714);
        this.rlN.setClickable(z);
        if (z) {
            if (!(this.rlN.getBackground() == null || this.rlN.getBackground().mutate() == null)) {
                this.rlN.getBackground().mutate().setAlpha(255);
            }
            this.rlN.setTextColor(getResources().getColor(R.color.z3));
            AppMethodBeat.o(65714);
            return;
        }
        if (!(this.rlN.getBackground() == null || this.rlN.getBackground().mutate() == null)) {
            this.rlN.getBackground().mutate().setAlpha(128);
        }
        this.rlN.setTextColor(getResources().getColor(R.color.z4));
        AppMethodBeat.o(65714);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI
    public final boolean onSceneEnd(int i2, int i3, String str, final q qVar) {
        AppMethodBeat.i(65715);
        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + " netsceneType:" + qVar.getType());
        if (qVar instanceof aq) {
            if (i2 == 0 && i3 == 0) {
                aq aqVar = (aq) qVar;
                this.yXm = aqVar.yXm;
                this.yXk = aqVar.yXk;
                this.zfL = aqVar.yXs;
                this.yXt = aqVar.yXt;
                this.zfX = aqVar.dUb;
                this.yXw = aqVar.yXw;
                Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "enableSelfIe is %s", Integer.valueOf(this.zfL));
                egr();
                Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:updateView");
                if (this.yXw == null || this.yXw.size() <= 0) {
                    Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is not valid!");
                    this.zfI.setVisibility(8);
                } else {
                    Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is valid!");
                    this.zfI.setVisibility(0);
                }
                this.yln.getLayoutParams();
                this.yln.setTextSize(1, 21.0f);
                this.zeX.setTextSize(1, 15.0f);
                this.zeW.gV(getResources().getDimensionPixelOffset(R.dimen.abr), getResources().getDimensionPixelOffset(R.dimen.abn));
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.zeW.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.aba);
                this.zeW.setLayoutParams(layoutParams);
                this.zeW.invalidate();
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.zfI.getLayoutParams();
                layoutParams2.topMargin = getResources().getDimensionPixelOffset(R.dimen.abd);
                this.zfI.setLayoutParams(layoutParams2);
                this.zfI.invalidate();
                String str2 = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_HONGBAO_NEW_YEAR_LAST_SEND_EMOJI_MD5_STRING, "");
                if (Util.isNullOrNil(str2)) {
                    PW(0);
                } else {
                    aDE(str2);
                }
                setContentViewVisibility(0);
                af.a(this.zfy, null);
                AppMethodBeat.o(65715);
                return true;
            }
            finish();
        } else if (qVar instanceof ba) {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            if (i2 == 0 && i3 == 0) {
                Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
                ba baVar = (ba) qVar;
                this.yYP = baVar.yXH;
                PayInfo payInfo = new PayInfo();
                payInfo.dDL = baVar.wFL;
                payInfo.dVv = 37;
                payInfo.channel = this.mChannel;
                com.tencent.mm.pluginsdk.wallet.f.a(this, payInfo, 1);
                AppMethodBeat.o(65715);
                return true;
            }
            Log.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
        } else if (qVar instanceof bc) {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            if (i2 == 0 && i3 == 0) {
                Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
                bc bcVar = (bc) qVar;
                this.yYP = bcVar.yXH;
                this.yUc = bcVar.yQE;
                if (bcVar.isJumpRemind()) {
                    Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() NetScenePrepareNewYearLuckyMoney show JumpRemind Alert");
                    bcVar.jumpRemind.a(this, new com.tencent.mm.wallet_core.c.h() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.AnonymousClass12 */

                        @Override // com.tencent.mm.wallet_core.c.h
                        public final void bG(int i2, String str) {
                            AppMethodBeat.i(65701);
                            Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() scene:NetScenePrepareNewYearLuckyMoney JumpRemind:onNext()");
                            if (!Util.isEqual(i2, 2) || !Util.isEqual(str, "requestwxhb")) {
                                if (Util.isEqual(i2, 1)) {
                                    com.tencent.mm.plugin.account.a.b.a.b(LuckyMoneyNewYearSendUI.this, str, 0, true);
                                }
                                AppMethodBeat.o(65701);
                                return;
                            }
                            LuckyMoneyNewYearSendUI.x(LuckyMoneyNewYearSendUI.this);
                            AppMethodBeat.o(65701);
                        }

                        @Override // com.tencent.mm.wallet_core.c.h
                        public final void onCancel() {
                            AppMethodBeat.i(65702);
                            Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() scene:NetScenePrepareNewYearLuckyMoney JumpRemind:onCancel()");
                            AppMethodBeat.o(65702);
                        }
                    });
                    AppMethodBeat.o(65715);
                    return true;
                }
                PayInfo payInfo2 = new PayInfo();
                payInfo2.dDL = bcVar.wFL;
                payInfo2.dVv = 37;
                payInfo2.channel = this.mChannel;
                com.tencent.mm.pluginsdk.wallet.f.a(this, payInfo2, 1);
                AppMethodBeat.o(65715);
                return true;
            } else if (i3 == 268502454) {
                com.tencent.mm.ui.base.h.d(this, str, "", new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(65689);
                        if (ba.l(qVar)) {
                            LuckyMoneyNewYearSendUI.this.finish();
                            AppMethodBeat.o(65689);
                            return;
                        }
                        AppMethodBeat.o(65689);
                    }
                });
                AppMethodBeat.o(65715);
                return true;
            } else {
                Log.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
            }
        } else if (qVar instanceof aw) {
            AppMethodBeat.o(65715);
            return true;
        }
        AppMethodBeat.o(65715);
        return false;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        aw awVar;
        boolean z;
        EmojiInfo emojiInfo;
        RealnameGuideHelper realnameGuideHelper;
        boolean z2;
        AppMethodBeat.i(65716);
        switch (i2) {
            case 1:
                if (i3 == -1) {
                    Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay success!");
                    h.INSTANCE.a(11701, 15, 3, 0, 1, 2);
                    if (intent == null || !intent.hasExtra("key_realname_guide_helper") || (realnameGuideHelper = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper")) == null) {
                        z = false;
                    } else {
                        if (!realnameGuideHelper.b(this, null, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.AnonymousClass3 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(65690);
                                LuckyMoneyNewYearSendUI.this.finish();
                                AppMethodBeat.o(65690);
                            }
                        })) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z = z2;
                    }
                    if (this.rfq == null) {
                        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() mEmojiInfo == null");
                    } else {
                        try {
                            int indexOf = this.yYP.indexOf("<wcpayinfo>");
                            if (indexOf > 0 && indexOf < this.yYP.length()) {
                                StringBuilder sb = new StringBuilder();
                                if (this.rfq == null) {
                                    emojiInfo = new EmojiInfo();
                                } else {
                                    emojiInfo = this.rfq;
                                }
                                com.tencent.mm.plugin.luckymoney.a.e.a(sb, emojiInfo, 0);
                                StringBuilder sb2 = new StringBuilder(this.yYP.substring(0, indexOf));
                                sb2.append((CharSequence) sb).append(this.yYP.substring(indexOf).trim());
                                this.yYP = sb2.toString();
                            }
                            Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() success");
                        } catch (Exception e2) {
                            Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() Exception:%s", e2.getMessage());
                        }
                    }
                    Map<String, String> parseXml = XmlParser.parseXml(this.yYP, "msg", null);
                    if (parseXml == null) {
                        Log.e("MicroMsg.LuckyMoneyNewYearSendUI", "luckymoneyNewYearSendUI onActivityResult values is null");
                        finish();
                        AppMethodBeat.o(65716);
                        return;
                    }
                    if (com.tencent.mm.plugin.luckymoney.b.a.eex().eeB().aDu(parseXml.get(".msg.appmsg.wcpayinfo.paymsgid"))) {
                        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "sendLocalMsg() for hb! mMsgXml:%s", this.yYP);
                        af.ac(this.yYP, this.zfJ, 3);
                    } else {
                        Log.e("MicroMsg.LuckyMoneyNewYearSendUI", "it is a duplicate msg");
                    }
                    if (!z) {
                        finish();
                    }
                    this.zfO = new ex();
                    if (this.zfQ == 1) {
                        this.zfO.eEH = 8;
                    } else if (this.zfQ == 2) {
                        this.zfO.eEH = 6;
                    } else if (this.zfQ == 3) {
                        this.zfO.eEH = 7;
                    } else if (this.zfQ == 4) {
                        this.zfO.eEH = 14;
                    }
                    this.zfO.bfK();
                    PV(1);
                } else {
                    Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay cancel or failed!");
                }
                String aTY = z.aTY();
                if (i3 == -1) {
                    Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() resultCode == RESULT_OK");
                    this.dYe = 1;
                    this.zga = "";
                    awVar = new aw(this.yUc, this.zfX, 1, aTY, Util.nullAsNil(this.zfJ));
                } else {
                    if (intent != null) {
                        this.dYe = intent.getIntExtra("key_pay_reslut_type", 3);
                    } else {
                        Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "doNetSceneLuckyMoneyReport() data == null");
                        this.dYe = 3;
                    }
                    this.zga = this.yUc;
                    Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() resultCode != RESULT_OK  payType:%s", Integer.valueOf(this.dYe));
                    awVar = new aw(this.yUc, this.zfX, this.dYe, aTY, Util.nullAsNil(this.zfJ));
                }
                g.aAg().hqi.a(awVar, 0);
                AppMethodBeat.o(65716);
                return;
            case 1111:
                if (i3 != -1) {
                    Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "go emoji capture failed!");
                    break;
                } else {
                    if (intent != null) {
                        this.zfW = intent.getLongExtra("key_enter_time", 0);
                    }
                    if (!Util.isEqual(this.zfW, 0)) {
                        PW(4);
                        qO(false);
                        com.tencent.mm.emoji.d.b bVar = com.tencent.mm.emoji.d.b.hdv;
                        com.tencent.mm.emoji.d.b.a(this.zfW, this.zfZ);
                        AppMethodBeat.o(65716);
                        return;
                    }
                    Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "mTimeEnter == 0L go emoji capture failed!");
                    AppMethodBeat.o(65716);
                    return;
                }
        }
        AppMethodBeat.o(65716);
    }

    static /* synthetic */ void a(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        AppMethodBeat.i(65717);
        com.tencent.mm.plugin.luckymoney.ui.a.b.a(luckyMoneyNewYearSendUI, luckyMoneyNewYearSendUI.zdv);
        luckyMoneyNewYearSendUI.zdk.dismiss();
        AppMethodBeat.o(65717);
    }

    static /* synthetic */ void b(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        AppMethodBeat.i(65718);
        luckyMoneyNewYearSendUI.PX(0);
        AppMethodBeat.o(65718);
    }

    static /* synthetic */ void e(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        AppMethodBeat.i(65720);
        if (Util.isEqual(luckyMoneyNewYearSendUI.yXt, 1)) {
            if (!Util.isEqual(luckyMoneyNewYearSendUI.zfL, 1)) {
                luckyMoneyNewYearSendUI.egq();
                AppMethodBeat.o(65720);
                return;
            }
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) luckyMoneyNewYearSendUI.getContext(), 1, false);
            eVar.HLX = new o.f() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.AnonymousClass8 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(65696);
                    if (Util.isEqual(LuckyMoneyNewYearSendUI.this.zfL, 1)) {
                        mVar.kV(1, R.string.eqn);
                    }
                    mVar.kV(2, R.string.eru);
                    AppMethodBeat.o(65696);
                }
            };
            eVar.HLY = new o.g() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.AnonymousClass9 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(65697);
                    Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "showLuckyHbDlg() onMMMenuItemSelected menuItemId:%s", Integer.valueOf(menuItem.getItemId()));
                    switch (menuItem.getItemId()) {
                        case 1:
                            LuckyMoneyNewYearSendUI.this.zfY = 0;
                            com.tencent.mm.plugin.emojicapture.api.b.b(LuckyMoneyNewYearSendUI.this, 3, LuckyMoneyNewYearSendUI.this.zfJ);
                            LuckyMoneyNewYearSendUI.this.zdC = 1;
                            LuckyMoneyNewYearSendUI.this.zfO = new ex();
                            LuckyMoneyNewYearSendUI.this.zfO.eEH = 9;
                            LuckyMoneyNewYearSendUI.this.zfO.bfK();
                            AppMethodBeat.o(65697);
                            return;
                        case 2:
                            LuckyMoneyNewYearSendUI.o(LuckyMoneyNewYearSendUI.this);
                            break;
                    }
                    AppMethodBeat.o(65697);
                }
            };
            eVar.dGm();
        }
        AppMethodBeat.o(65720);
    }

    static /* synthetic */ void a(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI, r rVar) {
        AppMethodBeat.i(65724);
        if (rVar == null) {
            luckyMoneyNewYearSendUI.PW(0);
            AppMethodBeat.o(65724);
            return;
        }
        luckyMoneyNewYearSendUI.aDE(rVar.getMd5());
        AppMethodBeat.o(65724);
    }
}
