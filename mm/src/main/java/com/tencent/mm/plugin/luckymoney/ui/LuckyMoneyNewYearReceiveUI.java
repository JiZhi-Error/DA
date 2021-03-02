package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ay;
import com.tencent.mm.plugin.luckymoney.model.bd;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollView;
import com.tencent.mm.plugin.luckymoney.ui.l;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a;
import com.tencent.mm.plugin.wallet_core.utils.c;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.vfs.s;
import com.tencent.mm.wallet_core.ui.f;

@a(3)
public class LuckyMoneyNewYearReceiveUI extends LuckyMoneyBaseUI {
    private String egX;
    private String gAn;
    private String imagePath = "";
    private MMHandler mHandler = new MMHandler();
    private TextView nnA;
    private ca qnv;
    private ImageView qyu;
    private d.a rbg = new d.a() {
        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.emoji.model.d.a
        public final void a(final boolean z, final EmojiInfo emojiInfo) {
            AppMethodBeat.i(65662);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(65661);
                    if (!(emojiInfo == null || LuckyMoneyNewYearReceiveUI.this.rfq == null || !LuckyMoneyNewYearReceiveUI.this.rfq.getMd5().equals(emojiInfo.getMd5()))) {
                        if (z) {
                            Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "somethings success.");
                            LuckyMoneyNewYearReceiveUI.this.rfq = k.getEmojiStorageMgr().OpN.blk(LuckyMoneyNewYearReceiveUI.this.rfq.getMd5());
                            LuckyMoneyNewYearReceiveUI.this.zfc.setVisibility(8);
                            LuckyMoneyNewYearReceiveUI.this.zfm.setVisibility(0);
                            LuckyMoneyNewYearReceiveUI.this.zfm.setEmojiInfo(LuckyMoneyNewYearReceiveUI.this.rfq);
                            AppMethodBeat.o(65661);
                            return;
                        }
                        Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "somethings error.");
                        LuckyMoneyNewYearReceiveUI.this.zfc.setVisibility(8);
                        LuckyMoneyNewYearReceiveUI.this.zfe.setVisibility(0);
                    }
                    AppMethodBeat.o(65661);
                }
            });
            AppMethodBeat.o(65662);
        }
    };
    private EmojiInfo rfq;
    private q tipDialog = null;
    private View yRp;
    private String yUc;
    public int yXD = 0;
    private TextView yln;
    private LuckyMoneyAutoScrollView zeW;
    private TextView zeX;
    private TextView zeY;
    private LinearLayout zeZ;
    private ImageView zfa;
    private LinearLayout zfb;
    private LinearLayout zfc;
    private MMAnimateView zfd;
    private TextView zfe;
    private LinearLayout zff;
    private TextView zfg;
    private ImageView zfh;
    private ImageView zfi;
    private MMAnimateView zfj;
    private ImageView zfk;
    private View zfl;
    private BaseEmojiView zfm;
    private boolean zfn = false;
    private String zfo = "";
    private int zfp;
    private String zfq = "";
    private String zfr = "";
    private boolean zfs = false;

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LuckyMoneyNewYearReceiveUI() {
        AppMethodBeat.i(65673);
        AppMethodBeat.o(65673);
    }

    static /* synthetic */ void a(LuckyMoneyNewYearReceiveUI luckyMoneyNewYearReceiveUI, int i2, int i3, String str, String str2, String str3) {
        AppMethodBeat.i(65687);
        luckyMoneyNewYearReceiveUI.a(i2, i3, str, str2, str3);
        AppMethodBeat.o(65687);
    }

    static /* synthetic */ void e(LuckyMoneyNewYearReceiveUI luckyMoneyNewYearReceiveUI) {
        AppMethodBeat.i(65684);
        luckyMoneyNewYearReceiveUI.ego();
        AppMethodBeat.o(65684);
    }

    static /* synthetic */ View g(LuckyMoneyNewYearReceiveUI luckyMoneyNewYearReceiveUI) {
        AppMethodBeat.i(65685);
        View contentView = luckyMoneyNewYearReceiveUI.getContentView();
        AppMethodBeat.o(65685);
        return contentView;
    }

    static /* synthetic */ View h(LuckyMoneyNewYearReceiveUI luckyMoneyNewYearReceiveUI) {
        AppMethodBeat.i(65686);
        View contentView = luckyMoneyNewYearReceiveUI.getContentView();
        AppMethodBeat.o(65686);
        return contentView;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(65674);
        super.onCreate(bundle);
        this.gAn = getIntent().getStringExtra("key_username");
        this.zfo = getIntent().getStringExtra("key_emoji_md5");
        this.qnv = ((l) g.af(l.class)).eiy().Hb(getIntent().getLongExtra("key_msgid", 0));
        this.zfp = getIntent().getIntExtra("key_msg_newyear_localreceivestatus", 0);
        this.egX = getIntent().getStringExtra("key_native_url");
        Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "emojiMd5:" + this.zfo);
        Uri parse = Uri.parse(Util.nullAsNil(this.egX));
        try {
            this.yUc = parse.getQueryParameter("sendid");
        } catch (Exception e2) {
            Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "onCreate() Exception:%s", e2.getMessage());
        }
        initView();
        if (!Util.isNullOrNil(this.yUc)) {
            doSceneProgress(new bd(Util.getInt(parse.getQueryParameter("channelid"), 1), this.yUc, this.egX, 1, "v1.0", ""), false);
            if (this.tipDialog != null) {
                this.tipDialog.show();
            }
            AppMethodBeat.o(65674);
            return;
        }
        finish();
        Log.w("MicroMsg.LuckyMoneyNewYearReceiveUI", "sendid null & finish");
        AppMethodBeat.o(65674);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(65675);
        super.onResume();
        if (this.zfs) {
            finish();
        }
        AppMethodBeat.o(65675);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(65676);
        super.onDestroy();
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        k.cGd().rbg = null;
        AppMethodBeat.o(65676);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(65677);
        setActionbarColor(-839716110);
        this.yRp = findViewById(R.id.f2z);
        this.zeW = (LuckyMoneyAutoScrollView) findViewById(R.id.f2v);
        this.zeX = (TextView) findViewById(R.id.ey0);
        this.yln = (TextView) findViewById(R.id.f36);
        this.qyu = (ImageView) findViewById(R.id.f2w);
        this.zeZ = (LinearLayout) findViewById(R.id.f34);
        this.nnA = (TextView) findViewById(R.id.f32);
        this.zfa = (ImageView) findViewById(R.id.f33);
        this.zeY = (TextView) findViewById(R.id.f35);
        this.zfb = (LinearLayout) findViewById(R.id.f31);
        this.zfj = (MMAnimateView) findViewById(R.id.g8u);
        this.zfk = (ImageView) findViewById(R.id.f2m);
        this.zfl = findViewById(R.id.f2j);
        this.zfm = (BaseEmojiView) findViewById(R.id.f2f);
        this.zfe = (TextView) findViewById(R.id.f2q);
        this.zfc = (LinearLayout) findViewById(R.id.f2n);
        this.zfd = (MMAnimateView) findViewById(R.id.epj);
        this.zff = (LinearLayout) findViewById(R.id.eyk);
        this.zfg = (TextView) findViewById(R.id.eyl);
        this.zfe.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(65663);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LuckyMoneyNewYearReceiveUI.e(LuckyMoneyNewYearReceiveUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65663);
            }
        });
        this.zfh = (ImageView) findViewById(R.id.f2t);
        this.zfh.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(65664);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LuckyMoneyNewYearReceiveUI.this.finish();
                h.INSTANCE.a(13079, 6, 2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65664);
            }
        });
        this.zfi = (ImageView) findViewById(R.id.f2s);
        this.zfi.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(65665);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LuckyMoneyNewYearReceiveUI.this.finish();
                h.INSTANCE.a(13079, 6, 2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65665);
            }
        });
        setContentViewVisibility(8);
        this.tipDialog = com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.AnonymousClass5 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(65666);
                if (LuckyMoneyNewYearReceiveUI.this.tipDialog != null && LuckyMoneyNewYearReceiveUI.this.tipDialog.isShowing()) {
                    LuckyMoneyNewYearReceiveUI.this.tipDialog.dismiss();
                }
                LuckyMoneyNewYearReceiveUI.this.zbX.forceCancel();
                if (LuckyMoneyNewYearReceiveUI.g(LuckyMoneyNewYearReceiveUI.this).getVisibility() == 8 || LuckyMoneyNewYearReceiveUI.h(LuckyMoneyNewYearReceiveUI.this).getVisibility() == 4) {
                    Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "usr cancel, & visibility not visiable, so finish");
                    LuckyMoneyNewYearReceiveUI.this.finish();
                }
                AppMethodBeat.o(65666);
            }
        });
        AppMethodBeat.o(65677);
    }

    private void ego() {
        AppMethodBeat.i(65678);
        this.zfe.setVisibility(8);
        this.rfq = k.getEmojiStorageMgr().OpN.blk(this.zfo);
        if (this.rfq == null) {
            Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showExpression() mEmojiInfo == null ");
            AppMethodBeat.o(65678);
        } else if (s.boW(this.rfq.hYx()) > 0 || this.rfq.NA() || this.rfq.hYm()) {
            this.zfm.setVisibility(0);
            this.zfm.setEmojiInfo(this.rfq);
            AppMethodBeat.o(65678);
        } else {
            this.zfm.setVisibility(8);
            this.zfc.setVisibility(0);
            this.zfd.setImageResource(R.raw.lucky_money_newyear_creat_loading);
            k.cGd().rbg = this.rbg;
            k.cGd().u(this.rfq);
            AppMethodBeat.o(65678);
        }
    }

    private void egp() {
        AppMethodBeat.i(65679);
        this.zfj.setImageResource(R.raw.lucky_money_newyear_particle);
        AppMethodBeat.o(65679);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI
    public final boolean onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        boolean z;
        AppMethodBeat.i(65680);
        Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "onSceneEnd() errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + " netsceneType:" + qVar.getType());
        if (!(qVar instanceof bd)) {
            if (qVar instanceof ay) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.dismiss();
                }
                if (i2 == 0 && i3 == 0) {
                    final ay ayVar = (ay) qVar;
                    if (c.a(ayVar.yXE)) {
                        setContentViewVisibility(4);
                        c cVar = new c(this);
                        cVar.IoO = true;
                        cVar.b(ayVar.yXE);
                        AppMethodBeat.o(65680);
                        return true;
                    }
                    this.yXD = ayVar.yXD;
                    if (!Util.isEqual(this.yXD, 1)) {
                        this.zfl.setVisibility(8);
                        this.zfk.setVisibility(0);
                    }
                    com.tencent.mm.plugin.luckymoney.model.q qVar2 = ayVar.yWT;
                    this.nnA.setText(ayVar.yWT.yVb);
                    String formatMoney2f = f.formatMoney2f(((double) ayVar.yWT.eht) / 100.0d);
                    this.zeW.setContentDescription(formatMoney2f);
                    this.zeW.setFinalText(formatMoney2f);
                    this.zeW.a(new LuckyMoneyAutoScrollView.a() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.AnonymousClass7 */

                        @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollView.a
                        public final void efY() {
                            AppMethodBeat.i(65670);
                            LuckyMoneyNewYearReceiveUI.this.yln.setVisibility(4);
                            af.a(LuckyMoneyNewYearReceiveUI.this.getContext(), LuckyMoneyNewYearReceiveUI.this.yln, ayVar.yWT.yPK);
                            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                            alphaAnimation.setDuration(500);
                            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.AnonymousClass7.AnonymousClass1 */

                                public final void onAnimationStart(Animation animation) {
                                    AppMethodBeat.i(65668);
                                    LuckyMoneyNewYearReceiveUI.this.yln.setVisibility(0);
                                    AppMethodBeat.o(65668);
                                }

                                public final void onAnimationRepeat(Animation animation) {
                                }

                                public final void onAnimationEnd(Animation animation) {
                                    AppMethodBeat.i(65669);
                                    if (com.tencent.mm.n.h.aqJ().getInt("PlayCoinSound", 0) > 0) {
                                        l.a(LuckyMoneyNewYearReceiveUI.this, l.a.NOTSET);
                                    }
                                    if (ayVar.yRu != null) {
                                        ayVar.yRu.b(LuckyMoneyNewYearReceiveUI.this, null, null);
                                    }
                                    AppMethodBeat.o(65669);
                                }
                            });
                            LuckyMoneyNewYearReceiveUI.this.yln.startAnimation(alphaAnimation);
                            AppMethodBeat.o(65670);
                        }
                    });
                    if (qVar2.egZ == 4 && !TextUtils.isEmpty(ayVar.yWT.yVb)) {
                        this.zfa.setVisibility(8);
                    }
                    qN(false);
                    setContentViewVisibility(0);
                    af.a(this.yRp, null);
                    PU(2);
                    egp();
                    AppMethodBeat.o(65680);
                    return true;
                } else if (i3 == 416) {
                    if (this.tipDialog != null && this.tipDialog.isShowing()) {
                        this.tipDialog.dismiss();
                    }
                    this.zfs = true;
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyNewYearReceiveUI");
                    bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                    boolean a2 = af.a(this, i3, qVar, bundle, true, null, null, 1004);
                    AppMethodBeat.o(65680);
                    return a2;
                }
            }
            AppMethodBeat.o(65680);
            return false;
        } else if (i2 == 0 && i3 == 0) {
            final bd bdVar = (bd) qVar;
            this.yXD = bdVar.yXD;
            if (bdVar.yVm == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is Sender hb!");
                if (bdVar.egZ != 4) {
                    this.zfb.setVisibility(8);
                }
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.dismiss();
                }
                if (bdVar.egZ != 5) {
                    String formatMoney2f2 = f.formatMoney2f(((double) bdVar.yXO) / 100.0d);
                    this.zeW.setContentDescription(formatMoney2f2);
                    this.zeW.setFinalText(formatMoney2f2);
                    this.zeW.efX();
                    af.a(getContext(), this.yln, bdVar.yPK);
                    this.zeZ.setVisibility(8);
                    this.zfb.setVisibility(0);
                    if (bdVar.egZ == 4) {
                        a.b.d(this.qyu, this.gAn);
                        PU(2);
                    } else {
                        this.qyu.setVisibility(8);
                    }
                    this.zeY.setText(bdVar.yVb);
                    this.zeY.setTextSize(1, 16.0f);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.zfb.getLayoutParams();
                    layoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix((Context) this, 82);
                    this.zfb.setLayoutParams(layoutParams);
                    this.zfb.invalidate();
                    egp();
                } else {
                    findViewById(R.id.f2x).setVisibility(8);
                    ((TextView) findViewById(R.id.f2y)).setText(bdVar.yVb);
                    ((TextView) findViewById(R.id.f2y)).setVisibility(0);
                    ((TextView) findViewById(R.id.f2y)).setTextSize(24.0f);
                    qN(true);
                    PU(1);
                }
                setContentViewVisibility(0);
                af.a(this.yRp, null);
                this.zfh.setVisibility(0);
                this.zfi.setVisibility(8);
            } else {
                Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is receiver hb!");
                if (!TextUtils.isEmpty(getIntent().getStringExtra("key_username"))) {
                    a.b.d(this.qyu, getIntent().getStringExtra("key_username"));
                } else if (!TextUtils.isEmpty(bdVar.yVe)) {
                    af.a(this.qyu, bdVar.yVe, bdVar.yVy);
                }
                this.zeY.setTextSize(1, 16.0f);
                af.a(getContext(), this.zeY, bdVar.yXN + getString(R.string.eqm));
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.zfb.getLayoutParams();
                layoutParams2.bottomMargin = com.tencent.mm.cb.a.fromDPToPix((Context) this, 30);
                this.zfb.setLayoutParams(layoutParams2);
                this.zfb.invalidate();
                this.zfb.setVisibility(0);
                this.zeZ.setVisibility(8);
                if (bdVar.eha != 0 || bdVar.egZ == 4 || bdVar.egZ == 5 || bdVar.egZ == 1) {
                    if (this.tipDialog != null && this.tipDialog.isShowing()) {
                        this.tipDialog.dismiss();
                    }
                    if (bdVar.egZ != 5) {
                        String formatMoney2f3 = f.formatMoney2f(((double) bdVar.yXO) / 100.0d);
                        this.zeW.setContentDescription(formatMoney2f3);
                        this.zeW.setFinalText(formatMoney2f3);
                        this.zeW.efX();
                        af.a(getContext(), this.yln, bdVar.yPK);
                        PU(2);
                        egp();
                        qN(false);
                    } else {
                        this.zff.setVisibility(8);
                        findViewById(R.id.f2x).setVisibility(8);
                        ((TextView) findViewById(R.id.f2y)).setText(bdVar.yVb);
                        ((TextView) findViewById(R.id.f2y)).setVisibility(0);
                        ((TextView) findViewById(R.id.f2y)).setTextSize(24.0f);
                        PU(1);
                    }
                    setContentViewVisibility(0);
                    af.a(this.yRp, null);
                } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(bdVar.yWY)) {
                    new com.tencent.mm.plugin.wallet_core.id_verify.util.a().a(this, this.zbX, bdVar.yWZ, bdVar.yXa, bdVar.yXb, bdVar.yXc, new a.AbstractC1915a() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.AnonymousClass6 */

                        @Override // com.tencent.mm.plugin.wallet_core.id_verify.util.a.AbstractC1915a
                        public final boolean run(int i2, int i3, String str, boolean z) {
                            AppMethodBeat.i(65667);
                            Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showDisclaimerDialog resultCode=" + i2 + ";errCode=" + i3 + ";errMsg=" + str + ";hadAgree = " + z);
                            if (i2 == 1) {
                                LuckyMoneyNewYearReceiveUI.this.finish();
                            } else if (i2 == 2) {
                                LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, bdVar.msgType, bdVar.channelId, bdVar.yQE, bdVar.egX, bdVar.yXR);
                            } else if (i2 == 0 && z) {
                                LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, bdVar.msgType, bdVar.channelId, bdVar.yQE, bdVar.egX, bdVar.yXR);
                            }
                            AppMethodBeat.o(65667);
                            return true;
                        }
                    }, true, 1005);
                } else {
                    a(bdVar.msgType, bdVar.channelId, bdVar.yQE, bdVar.egX, bdVar.yXR);
                }
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.zeZ.getLayoutParams();
                layoutParams3.topMargin = getResources().getDimensionPixelOffset(R.dimen.abv);
                this.zeZ.setLayoutParams(layoutParams3);
                this.zeZ.invalidate();
                this.nnA.setTextSize(1, 12.0f);
                this.zfh.setVisibility(8);
                this.zfi.setVisibility(0);
            }
            boolean z2 = true;
            if (bdVar.egZ == 5 || bdVar.egZ == 1) {
                z2 = false;
            }
            Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "receiveScene.hbStatus is " + bdVar.egZ + ", isValidStatus is " + z2);
            boolean z3 = Util.isEqual(this.yXD, 1) && !Util.isNullOrNil(this.zfo);
            if (!z3 || !z2) {
                this.zfl.setVisibility(8);
                this.zfk.setVisibility(0);
            } else {
                this.zfl.setVisibility(0);
                this.zfk.setVisibility(8);
                ego();
            }
            if (!z3 || !z2) {
                this.yln.setTextSize(1, 21.0f);
                this.zeX.setTextSize(1, 18.0f);
                this.zeW.gV(getResources().getDimensionPixelOffset(R.dimen.abs), getResources().getDimensionPixelOffset(R.dimen.abo));
                this.zeW.invalidate();
            } else {
                this.yln.getLayoutParams();
                this.yln.setTextSize(1, 21.0f);
                this.zeX.setTextSize(1, 15.0f);
                this.zeW.gV(getResources().getDimensionPixelOffset(R.dimen.abr), getResources().getDimensionPixelOffset(R.dimen.abn));
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.zeW.getLayoutParams();
                layoutParams4.topMargin = getResources().getDimensionPixelOffset(R.dimen.aba);
                this.zeW.setLayoutParams(layoutParams4);
                this.zeW.invalidate();
            }
            AppMethodBeat.o(65680);
            return true;
        } else {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            AppMethodBeat.o(65680);
            return false;
        }
    }

    private void a(int i2, int i3, String str, String str2, String str3) {
        AppMethodBeat.i(65681);
        doSceneProgress(new ay(i2, i3, str, str2, af.efj(), z.aUa(), getIntent().getStringExtra("key_username"), "v1.0", str3), false);
        AppMethodBeat.o(65681);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b45;
    }

    private void PU(int i2) {
        StringBuilder sb;
        AppMethodBeat.i(65682);
        Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() localReceiveStatus:%s newStatus:%s", Integer.valueOf(this.zfp), Integer.valueOf(i2));
        if (this.qnv == null) {
            Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() mEmojiInfo == null");
            AppMethodBeat.o(65682);
        } else if (Util.isEqual(this.zfp, i2) || Util.isEqual(this.zfp, 2)) {
            AppMethodBeat.o(65682);
        } else {
            try {
                StringBuilder sb2 = new StringBuilder(this.qnv.field_content);
                StringBuilder sb3 = new StringBuilder();
                int indexOf = sb2.indexOf("<localreceivestatus>");
                if (indexOf <= 0 || indexOf >= sb2.length()) {
                    int indexOf2 = sb2.indexOf("<emoji>");
                    if (indexOf2 <= 0 || indexOf2 >= sb2.length()) {
                        int indexOf3 = sb2.indexOf("<wcpayinfo>");
                        sb3.append("<emoji><localreceivestatus>").append(i2).append("</localreceivestatus></emoji>");
                        StringBuilder sb4 = new StringBuilder(sb2.substring(0, indexOf3));
                        sb4.append((CharSequence) sb3).append(sb2.substring(indexOf3).trim());
                        sb = sb4;
                    } else {
                        sb3.append("<localreceivestatus>").append(i2).append("</localreceivestatus>");
                        StringBuilder sb5 = new StringBuilder(sb2.substring(0, indexOf2 + 7));
                        sb5.append((CharSequence) sb3).append(sb2.substring(indexOf2 + 7).trim());
                        sb = sb5;
                    }
                } else {
                    StringBuilder sb6 = new StringBuilder(sb2.substring(0, indexOf + 20));
                    sb6.append(i2).append(sb2.substring(indexOf + 21));
                    sb = sb6;
                }
                this.qnv.setContent(sb.toString());
                ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(this.qnv.field_msgId, this.qnv);
                Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() success msgXml:%s", sb);
                AppMethodBeat.o(65682);
            } catch (Exception e2) {
                Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() Exception:%s", e2.getMessage());
                AppMethodBeat.o(65682);
            }
        }
    }

    private void qN(boolean z) {
        AppMethodBeat.i(65683);
        if (z) {
            this.zff.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.zff.getLayoutParams()).addRule(3, R.id.f2y);
            this.zfg.setText(getString(R.string.erq));
            this.zff.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.AnonymousClass8 */

                public final void onClick(View view) {
                    AppMethodBeat.i(65671);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "goto detail!");
                    Intent intent = new Intent();
                    intent.putExtra("key_native_url", LuckyMoneyNewYearReceiveUI.this.egX);
                    com.tencent.mm.br.c.b(LuckyMoneyNewYearReceiveUI.this, "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", intent);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(65671);
                }
            });
            AppMethodBeat.o(65683);
            return;
        }
        this.zff.setVisibility(0);
        this.zff.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(65672);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "goto BalanceManagerUI!");
                com.tencent.mm.pluginsdk.wallet.f.aF(LuckyMoneyNewYearReceiveUI.this.getContext(), 1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyNewYearReceiveUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65672);
            }
        });
        this.zfg.setText(getString(R.string.ero));
        AppMethodBeat.o(65683);
    }
}
