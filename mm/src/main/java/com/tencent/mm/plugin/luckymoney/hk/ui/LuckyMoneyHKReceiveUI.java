package com.tencent.mm.plugin.luckymoney.hk.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.luckymoney.hk.a.c;
import com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEmojiSwitch;
import com.tencent.mm.plugin.luckymoney.model.ac;
import com.tencent.mm.plugin.luckymoney.model.ad;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.bg;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.l;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.bez;
import com.tencent.mm.protocal.protobuf.bfb;
import com.tencent.mm.protocal.protobuf.bfd;
import com.tencent.mm.protocal.protobuf.bfe;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.cdh;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.f;
import java.util.Iterator;
import java.util.LinkedList;

@a(7)
public class LuckyMoneyHKReceiveUI extends LuckyMoneyBaseUI {
    private static final String yUb = MMApplicationContext.getContext().getResources().getString(R.string.itf);
    private long gof;
    private int maxSize = 0;
    private TextView nAB;
    private ViewGroup nmW;
    private int textSize = 0;
    private q tipDialog = null;
    private String xGm;
    private ImageView yQt;
    private TextView yRk;
    private Button yRl;
    private View yRm;
    private ImageView yRn;
    private TextView yRo;
    private ImageView yTs;
    private String yUc;
    private LinearLayout yUh;
    private TextView yUi;
    private View yUj;
    private ImageView yUk;
    private RelativeLayout yUl;
    private BaseEmojiView yUm;
    private TextView yUn;
    private LinearLayout yUo;
    private ProgressBar yUp;
    private String yUq;
    private int yUr;
    private ae yUs = null;
    public int yUt = 0;
    private c yUu;
    private TextView yln;

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void c(LuckyMoneyHKReceiveUI luckyMoneyHKReceiveUI) {
        AppMethodBeat.i(213295);
        luckyMoneyHKReceiveUI.eeN();
        AppMethodBeat.o(213295);
    }

    static {
        AppMethodBeat.i(213300);
        AppMethodBeat.o(213300);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(213290);
        fixStatusbar(true);
        this.zbY = false;
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(R.color.ac_));
        }
        this.yUq = getIntent().getStringExtra("key_native_url");
        this.gof = getIntent().getLongExtra("key_msgid", 0);
        this.yUr = getIntent().getIntExtra("key_way", 0);
        try {
            this.yUc = Uri.parse(Util.nullAsNil(this.yUq)).getQueryParameter("sendid");
        } catch (Exception e2) {
            finish();
        }
        initView();
        Log.i("MicroMsg.LuckyMoneyHKReceiveUI", "do receive hb: %s, %s", this.yUq, this.yUc);
        if (this.yUu != null) {
            this.yUu.cancel();
        }
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        this.tipDialog = h.a((Context) getContext(), 3, (int) R.style.lj, getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.luckymoney.hk.ui.LuckyMoneyHKReceiveUI.AnonymousClass5 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(213286);
                if (LuckyMoneyHKReceiveUI.this.tipDialog != null && LuckyMoneyHKReceiveUI.this.tipDialog.isShowing()) {
                    LuckyMoneyHKReceiveUI.this.tipDialog.dismiss();
                }
                LuckyMoneyHKReceiveUI.this.yUu.cancel();
                LuckyMoneyHKReceiveUI.this.finish();
                AppMethodBeat.o(213286);
            }
        });
        this.yUu = new c(this.yUq, this.yUc, this.yUr);
        this.yUu.aYI().b(new com.tencent.mm.vending.c.a<Object, c.a<bfg>>() {
            /* class com.tencent.mm.plugin.luckymoney.hk.ui.LuckyMoneyHKReceiveUI.AnonymousClass6 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(c.a<bfg> aVar) {
                String str;
                boolean z;
                AppMethodBeat.i(213289);
                c.a<bfg> aVar2 = aVar;
                LuckyMoneyHKReceiveUI.this.tipDialog.dismiss();
                Log.i("MicroMsg.LuckyMoneyHKReceiveUI", "do receive hb, errtype: %s, errcode: %s", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode));
                if (aVar2.errType == 0 && aVar2.errCode == 0) {
                    final bfg bfg = (bfg) aVar2.iLC;
                    Log.i("MicroMsg.LuckyMoneyHKReceiveUI", "do receive hb, retcode: %s, %s", Integer.valueOf(bfg.dDN), bfg.qwn);
                    if (bfg.dDN == 0) {
                        Log.i("MicroMsg.LuckyMoneyHKReceiveUI", "jump to h5: %s", Boolean.valueOf(bfg.LOQ));
                        if (bfg.LOQ) {
                            f.bn(LuckyMoneyHKReceiveUI.this.getContext(), LuckyMoneyHKReceiveUI.this.getIntent().getStringExtra("key_hk_url"));
                        } else {
                            ae aeVar = new ae();
                            aeVar.field_mNativeUrl = LuckyMoneyHKReceiveUI.this.yUq;
                            aeVar.field_hbType = bfg.egY;
                            aeVar.field_hbStatus = bfg.egZ;
                            aeVar.field_receiveStatus = bfg.eha;
                            t.fQE().a(aeVar);
                            if (bfg.eha == 2) {
                                LuckyMoneyHKReceiveUI.h(LuckyMoneyHKReceiveUI.this);
                            } else {
                                af.a(LuckyMoneyHKReceiveUI.this.yQt, "", bfg.yVy);
                                af.a(LuckyMoneyHKReceiveUI.this.getContext(), LuckyMoneyHKReceiveUI.this.yRk, LuckyMoneyHKReceiveUI.this.getString(R.string.eso, new Object[]{f.hs(f.getDisplayName(bfg.yVy), 10)}));
                                if (bfg.eha == 1 || bfg.egZ == 4 || bfg.egZ == 5 || bfg.egZ == 1) {
                                    LuckyMoneyHKReceiveUI.this.yRl.setVisibility(8);
                                    if (!Util.isNullOrNil(bfg.yVb)) {
                                        LuckyMoneyHKReceiveUI.this.yln.setText(bfg.yVb);
                                        LuckyMoneyHKReceiveUI.this.yln.setVisibility(0);
                                        LuckyMoneyHKReceiveUI.this.yln.setSingleLine(false);
                                    } else {
                                        LuckyMoneyHKReceiveUI.this.yln.setVisibility(8);
                                    }
                                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) LuckyMoneyHKReceiveUI.this.yRm.getLayoutParams();
                                    layoutParams.bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(LuckyMoneyHKReceiveUI.this.getContext(), 30.0f);
                                    LuckyMoneyHKReceiveUI.this.yRm.setLayoutParams(layoutParams);
                                    z = true;
                                } else {
                                    if (!Util.isNullOrNil(bfg.yVb)) {
                                        LuckyMoneyHKReceiveUI.this.nAB.setText(bfg.yVb);
                                        LuckyMoneyHKReceiveUI.this.nAB.setVisibility(0);
                                    }
                                    if (!Util.isNullOrNil(bfg.yPK)) {
                                        af.a(LuckyMoneyHKReceiveUI.this.getContext(), LuckyMoneyHKReceiveUI.this.yln, bfg.yPK);
                                        LuckyMoneyHKReceiveUI.this.yln.setVisibility(0);
                                        LuckyMoneyHKReceiveUI.this.nAB.setVisibility(8);
                                    }
                                    LuckyMoneyHKReceiveUI.this.yRl.setOnClickListener(new View.OnClickListener() {
                                        /* class com.tencent.mm.plugin.luckymoney.hk.ui.LuckyMoneyHKReceiveUI.AnonymousClass6.AnonymousClass1 */

                                        public final void onClick(View view) {
                                            AppMethodBeat.i(213287);
                                            b bVar = new b();
                                            bVar.bm(view);
                                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKReceiveUI$6$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                            Log.i("MicroMsg.LuckyMoneyHKReceiveUI", "open btn click!");
                                            LuckyMoneyHKReceiveUI.this.yRl.setClickable(false);
                                            LuckyMoneyHKReceiveUI.a(LuckyMoneyHKReceiveUI.this, bfg);
                                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKReceiveUI$6$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                            AppMethodBeat.o(213287);
                                        }
                                    });
                                    z = false;
                                }
                                if (z.aTY().equals(LuckyMoneyHKReceiveUI.this.xGm) || (bfg.egY == 1 && z)) {
                                    if (bfg.egY == 1) {
                                        LuckyMoneyHKReceiveUI.this.yRo.setText(R.string.eoi);
                                    }
                                    LuckyMoneyHKReceiveUI.this.yRm.setVisibility(0);
                                    LuckyMoneyHKReceiveUI.this.yRm.setOnClickListener(new View.OnClickListener() {
                                        /* class com.tencent.mm.plugin.luckymoney.hk.ui.LuckyMoneyHKReceiveUI.AnonymousClass6.AnonymousClass2 */

                                        public final void onClick(View view) {
                                            AppMethodBeat.i(213288);
                                            b bVar = new b();
                                            bVar.bm(view);
                                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKReceiveUI$6$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                            Intent intent = new Intent();
                                            intent.setClass(LuckyMoneyHKReceiveUI.this.getContext(), LuckyMoneyHKBeforeDetailUI.class);
                                            intent.putExtra("key_native_url", LuckyMoneyHKReceiveUI.this.yUq);
                                            intent.putExtra("key_sendid", LuckyMoneyHKReceiveUI.this.yUc);
                                            intent.putExtra("key_lucky_money_can_received", true);
                                            intent.putExtra("key_username", LuckyMoneyHKReceiveUI.this.getIntent().getStringExtra("key_username"));
                                            intent.putExtra("key_msgid", LuckyMoneyHKReceiveUI.this.gof);
                                            LuckyMoneyHKReceiveUI luckyMoneyHKReceiveUI = LuckyMoneyHKReceiveUI.this;
                                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                            com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyHKReceiveUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKReceiveUI$6$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                            luckyMoneyHKReceiveUI.startActivity((Intent) bl.pG(0));
                                            com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyHKReceiveUI, "com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKReceiveUI$6$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                            LuckyMoneyHKReceiveUI.this.finish();
                                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKReceiveUI$6$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                            AppMethodBeat.o(213288);
                                        }
                                    });
                                    LuckyMoneyHKReceiveUI.this.yRn.setVisibility(8);
                                } else {
                                    LuckyMoneyHKReceiveUI.this.yRm.setVisibility(8);
                                    LuckyMoneyHKReceiveUI.this.yRn.setVisibility(0);
                                }
                                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) LuckyMoneyHKReceiveUI.this.yUh.getLayoutParams();
                                layoutParams2.topMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(LuckyMoneyHKReceiveUI.this.getContext(), 118.0f);
                                LuckyMoneyHKReceiveUI.this.yUh.setLayoutParams(layoutParams2);
                                LuckyMoneyHKReceiveUI.r(LuckyMoneyHKReceiveUI.this);
                                LuckyMoneyHKReceiveUI.this.yUj.setVisibility(0);
                                af.eo(LuckyMoneyHKReceiveUI.this.yUj);
                            }
                        }
                    } else {
                        String str2 = LuckyMoneyHKReceiveUI.yUb;
                        if (!Util.isNullOrNil(bfg.qwn)) {
                            str = bfg.qwn;
                        } else {
                            str = str2;
                        }
                        h.cD(LuckyMoneyHKReceiveUI.this.getContext(), str);
                        LuckyMoneyHKReceiveUI.this.finish();
                    }
                } else {
                    String str3 = LuckyMoneyHKReceiveUI.yUb;
                    if (!Util.isNullOrNil(aVar2.errMsg)) {
                        str3 = aVar2.errMsg;
                    }
                    h.cD(LuckyMoneyHKReceiveUI.this.getContext(), str3);
                    LuckyMoneyHKReceiveUI.this.finish();
                }
                AppMethodBeat.o(213289);
                return null;
            }
        }).a(this);
        AppMethodBeat.o(213290);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(213291);
        this.yUj = findViewById(R.id.f47);
        this.nmW = (ViewGroup) findViewById(R.id.f44);
        this.yUh = (LinearLayout) findViewById(R.id.f4r);
        this.yQt = (ImageView) findViewById(R.id.f45);
        this.yRk = (TextView) findViewById(R.id.f46);
        this.nAB = (TextView) findViewById(R.id.f48);
        this.yln = (TextView) findViewById(R.id.f4b);
        this.yUl = (RelativeLayout) findViewById(R.id.f0a);
        this.yUm = (BaseEmojiView) findViewById(R.id.f07);
        this.yUn = (TextView) findViewById(R.id.f4q);
        this.yUo = (LinearLayout) findViewById(R.id.f1m);
        this.yUp = (ProgressBar) findViewById(R.id.c0c);
        this.yRl = (Button) findViewById(R.id.f4f);
        this.yRo = (TextView) findViewById(R.id.f4c);
        this.yRm = findViewById(R.id.f4d);
        this.yRn = (ImageView) findViewById(R.id.ey1);
        this.yUk = (ImageView) findViewById(R.id.f3z);
        this.yUi = (TextView) findViewById(R.id.f4g);
        this.yTs = (ImageView) findViewById(R.id.f4e);
        this.yTs.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.hk.ui.LuckyMoneyHKReceiveUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(213281);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LuckyMoneyHKReceiveUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(213281);
            }
        });
        this.nAB.setLines(2);
        android.support.v4.widget.q.d(this.nAB);
        this.maxSize = (int) (((float) com.tencent.mm.cb.a.aH(getContext(), R.dimen.ab3)) * 1.125f);
        this.textSize = com.tencent.mm.cb.a.aG(getContext(), R.dimen.ab3);
        this.textSize = this.textSize > this.maxSize ? this.maxSize : this.textSize;
        getContentView().setVisibility(8);
        eeN();
        AppMethodBeat.o(213291);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(213292);
        super.onDestroy();
        AppMethodBeat.o(213292);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b4b;
    }

    private void eeN() {
        AppMethodBeat.i(213293);
        if (this.yRl == null) {
            AppMethodBeat.o(213293);
            return;
        }
        d.INSTANCE.TL(this.yRl.getId());
        String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
        if (loadApplicationLanguage == null || loadApplicationLanguage.length() <= 0 || (!loadApplicationLanguage.equals(LocaleUtil.CHINA) && !loadApplicationLanguage.equals(LocaleUtil.TAIWAN) && !loadApplicationLanguage.equals(LocaleUtil.HONGKONG))) {
            this.yRl.setBackgroundResource(R.drawable.afv);
            this.yRl.setText(R.string.er0);
            AppMethodBeat.o(213293);
            return;
        }
        AppMethodBeat.o(213293);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI
    public final boolean onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        return false;
    }

    static /* synthetic */ void a(LuckyMoneyHKReceiveUI luckyMoneyHKReceiveUI, bfb bfb) {
        AppMethodBeat.i(213294);
        Log.i("MicroMsg.LuckyMoneyHKReceiveUI", "go to before detail ui");
        Intent intent = new Intent();
        intent.setClass(luckyMoneyHKReceiveUI.getContext(), LuckyMoneyHKBeforeDetailUI.class);
        intent.putExtra("key_lucky_money_can_received", true);
        intent.putExtra("key_jump_from", 2);
        intent.putExtra("key_native_url", luckyMoneyHKReceiveUI.yUq);
        intent.putExtra("key_sendid", luckyMoneyHKReceiveUI.yUc);
        intent.putExtra("key_anim_slide", true);
        intent.putExtra("key_username", luckyMoneyHKReceiveUI.getIntent().getStringExtra("key_username"));
        intent.putExtra("key_way", luckyMoneyHKReceiveUI.yUr);
        intent.putExtra("key_msgid", luckyMoneyHKReceiveUI.gof);
        intent.putExtra("key_hk_scene", luckyMoneyHKReceiveUI.getIntent().getIntExtra("key_hk_scene", 0));
        LuckyMoneyEmojiSwitch luckyMoneyEmojiSwitch = new LuckyMoneyEmojiSwitch();
        luckyMoneyEmojiSwitch.yVI = bfb.LOK;
        luckyMoneyEmojiSwitch.yVJ = bfb.yVJ;
        intent.putExtra("key_emoji_switch", luckyMoneyEmojiSwitch);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyHKReceiveUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKReceiveUI", "gotoBeforeDetailUI", "(Lcom/tencent/mm/protocal/protobuf/ForeignHbDetailResp;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        luckyMoneyHKReceiveUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyHKReceiveUI, "com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKReceiveUI", "gotoBeforeDetailUI", "(Lcom/tencent/mm/protocal/protobuf/ForeignHbDetailResp;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(213294);
    }

    static /* synthetic */ void a(LuckyMoneyHKReceiveUI luckyMoneyHKReceiveUI, final bfd bfd) {
        com.tencent.mm.plugin.luckymoney.model.q qVar;
        AppMethodBeat.i(213296);
        if (bfd == null) {
            qVar = null;
        } else {
            com.tencent.mm.plugin.luckymoney.model.q qVar2 = new com.tencent.mm.plugin.luckymoney.model.q();
            qVar2.egY = bfd.egY;
            qVar2.egZ = bfd.egZ;
            qVar2.yVb = bfd.yVb;
            qVar2.yPK = bfd.yPK;
            qVar2.yQE = bfd.yQE;
            qVar2.eht = bfd.eht;
            qVar2.yVC = bfd.yVC;
            qVar2.yVh = (long) bfd.yWN;
            qVar2.yVi = bfd.yVi;
            qVar2.qwe = bfd.qwe;
            qVar2.yVj = bfd.yVj;
            qVar2.yVk = bfd.yVk;
            qVar2.yVm = bfd.yVm;
            qVar2.yVn = bfd.yVn;
            qVar2.yVo = bfd.yVo;
            qVar2.eha = bfd.eha;
            qVar2.yRN = bfd.yRN;
            qVar2.yRP = bfd.yRP;
            qVar2.yRO = bfd.yRO;
            qVar2.yVy = bfd.yVy;
            if (!Util.isNullOrNil(qVar2.yVy)) {
                qVar2.yVd = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(qVar2.yVy);
            }
            qVar2.yVz = bfd.yVz;
            qVar2.yVA = bfd.yVA;
            qVar2.yVr = new LinkedList<>();
            if (!bfd.LOI.isEmpty()) {
                Iterator<bfe> it = bfd.LOI.iterator();
                while (it.hasNext()) {
                    bfe next = it.next();
                    bg bgVar = new bg();
                    bgVar.content = next.content;
                    bgVar.yXU = next.yXU;
                    bgVar.gGn = next.gGn;
                    bgVar.iconUrl = next.iconUrl;
                    bgVar.name = next.name;
                    bgVar.yXT = next.yXT;
                    if (next.type == 1) {
                        bgVar.type = "Appid";
                    } else if (next.type == 2) {
                        bgVar.type = "Text";
                    } else if (next.type == 3) {
                        bgVar.type = "Pic";
                    } else if (next.type == 4) {
                        bgVar.type = "Native";
                    }
                    qVar2.yVr.add(bgVar);
                }
            }
            if (bfd.LOJ != null) {
                qVar2.yVs = new bg();
                qVar2.yVs.content = bfd.LOJ.content;
                qVar2.yVs.yXU = bfd.LOJ.yXU;
                qVar2.yVs.gGn = bfd.LOJ.gGn;
                qVar2.yVs.iconUrl = bfd.LOJ.iconUrl;
                qVar2.yVs.name = bfd.LOJ.name;
                qVar2.yVs.yXT = bfd.LOJ.yXT;
                if (bfd.LOJ.type == 1) {
                    qVar2.yVs.type = "Appid";
                } else if (bfd.LOJ.type == 2) {
                    qVar2.yVs.type = "Text";
                } else if (bfd.LOJ.type == 3) {
                    qVar2.yVs.type = "Pic";
                } else if (bfd.LOJ.type == 4) {
                    qVar2.yVs.type = "Native";
                }
            }
            qVar2.yVE = ac.a(bfd.LOL);
            qVar2.yVw = new LinkedList<>();
            if (!bfd.dkr.isEmpty()) {
                Iterator<bez> it2 = bfd.dkr.iterator();
                while (it2.hasNext()) {
                    bez next2 = it2.next();
                    ad adVar = new ad();
                    adVar.yWG = next2.yWG;
                    adVar.yVk = next2.yVk;
                    adVar.yWo = next2.yWo;
                    adVar.yWp = next2.yWp;
                    adVar.userName = next2.userName;
                    adVar.yWH = next2.yWH;
                    if (Util.isNullOrNil(adVar.yWD) && !Util.isNullOrNil(adVar.userName)) {
                        adVar.yWD = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(adVar.userName);
                    }
                    qVar2.yVw.add(adVar);
                }
            }
            qVar = qVar2;
        }
        if (qVar.eha == 2) {
            Intent intent = new Intent();
            intent.setClass(luckyMoneyHKReceiveUI.getContext(), LuckyMoneyHKBeforeDetailUI.class);
            intent.putExtra("key_lucky_money_can_received", true);
            try {
                com.tencent.mm.plugin.luckymoney.a.b.a(luckyMoneyHKReceiveUI.yUc, qVar);
                intent.putExtra("key_jump_from", 2);
            } catch (Exception e2) {
                Log.w("MicroMsg.LuckyMoneyHKReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e2.getLocalizedMessage());
            }
            intent.putExtra("key_native_url", luckyMoneyHKReceiveUI.yUq);
            intent.putExtra("key_sendid", luckyMoneyHKReceiveUI.yUc);
            if (com.tencent.mm.n.h.aqJ().getInt("PlayCoinSound", 0) > 0) {
                intent.putExtra("play_sound", true);
            }
            LuckyMoneyEmojiSwitch luckyMoneyEmojiSwitch = new LuckyMoneyEmojiSwitch();
            luckyMoneyEmojiSwitch.yVI = bfd.LOK;
            luckyMoneyEmojiSwitch.yVJ = bfd.yVJ;
            intent.putExtra("key_emoji_switch", luckyMoneyEmojiSwitch);
            intent.putExtra("key_username", luckyMoneyHKReceiveUI.getIntent().getStringExtra("key_username"));
            intent.putExtra("key_msgid", luckyMoneyHKReceiveUI.gof);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyHKReceiveUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKReceiveUI", "openLuckyDetail", "(Lcom/tencent/mm/protocal/protobuf/ForeignHbOpenResp;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            luckyMoneyHKReceiveUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyHKReceiveUI, "com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKReceiveUI", "openLuckyDetail", "(Lcom/tencent/mm/protocal/protobuf/ForeignHbOpenResp;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            luckyMoneyHKReceiveUI.finish();
            ae aeVar = new ae();
            aeVar.field_mNativeUrl = luckyMoneyHKReceiveUI.yUq;
            aeVar.field_hbType = qVar.egY;
            aeVar.field_receiveAmount = qVar.eht;
            aeVar.field_receiveTime = System.currentTimeMillis();
            aeVar.field_hbStatus = qVar.egZ;
            aeVar.field_receiveStatus = qVar.eha;
            if (aeVar.field_receiveAmount > 0) {
                t.fQE().a(aeVar);
            }
            AppMethodBeat.o(213296);
            return;
        }
        luckyMoneyHKReceiveUI.yRl.setBackgroundResource(R.drawable.cf8);
        luckyMoneyHKReceiveUI.yRl.setText(R.string.eqx);
        luckyMoneyHKReceiveUI.yRl.setOnClickListener(null);
        luckyMoneyHKReceiveUI.yRl.setVisibility(8);
        if (!Util.isNullOrNil(qVar.yRQ)) {
            luckyMoneyHKReceiveUI.nAB.setText(qVar.yRQ);
            luckyMoneyHKReceiveUI.nAB.setVisibility(0);
        } else {
            luckyMoneyHKReceiveUI.nAB.setVisibility(8);
        }
        luckyMoneyHKReceiveUI.yln.setText(qVar.yVb);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) luckyMoneyHKReceiveUI.yRm.getLayoutParams();
        layoutParams.bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(luckyMoneyHKReceiveUI.getContext(), 30.0f);
        luckyMoneyHKReceiveUI.yRm.setLayoutParams(layoutParams);
        if (z.aTY().equals(luckyMoneyHKReceiveUI.xGm) || qVar.egY == 1) {
            luckyMoneyHKReceiveUI.yRm.setVisibility(0);
            luckyMoneyHKReceiveUI.yRm.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.hk.ui.LuckyMoneyHKReceiveUI.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(213285);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKReceiveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent();
                    intent.setClass(LuckyMoneyHKReceiveUI.this.getContext(), LuckyMoneyHKBeforeDetailUI.class);
                    intent.putExtra("key_lucky_money_can_received", true);
                    intent.putExtra("key_native_url", LuckyMoneyHKReceiveUI.this.yUq);
                    intent.putExtra("key_sendid", LuckyMoneyHKReceiveUI.this.yUc);
                    intent.putExtra("key_username", LuckyMoneyHKReceiveUI.this.getIntent().getStringExtra("key_username"));
                    intent.putExtra("key_msgid", LuckyMoneyHKReceiveUI.this.gof);
                    LuckyMoneyEmojiSwitch luckyMoneyEmojiSwitch = new LuckyMoneyEmojiSwitch();
                    luckyMoneyEmojiSwitch.yVI = bfd.LOK;
                    luckyMoneyEmojiSwitch.yVJ = bfd.yVJ;
                    intent.putExtra("key_emoji_switch", luckyMoneyEmojiSwitch);
                    LuckyMoneyHKReceiveUI luckyMoneyHKReceiveUI = LuckyMoneyHKReceiveUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyHKReceiveUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKReceiveUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    luckyMoneyHKReceiveUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyHKReceiveUI, "com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKReceiveUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    LuckyMoneyHKReceiveUI.this.finish();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKReceiveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(213285);
                }
            });
            luckyMoneyHKReceiveUI.yRn.setVisibility(8);
            AppMethodBeat.o(213296);
            return;
        }
        luckyMoneyHKReceiveUI.yRm.setVisibility(8);
        luckyMoneyHKReceiveUI.yRn.setVisibility(0);
        AppMethodBeat.o(213296);
    }

    static /* synthetic */ void h(LuckyMoneyHKReceiveUI luckyMoneyHKReceiveUI) {
        AppMethodBeat.i(213297);
        Log.i("MicroMsg.LuckyMoneyHKReceiveUI", "do query detail");
        new com.tencent.mm.plugin.luckymoney.hk.a.a(luckyMoneyHKReceiveUI.yUq, luckyMoneyHKReceiveUI.yUc, 0, luckyMoneyHKReceiveUI.getIntent().getIntExtra("key_hk_scene", 0)).aYI().b(new com.tencent.mm.vending.c.a<Object, c.a<bfb>>() {
            /* class com.tencent.mm.plugin.luckymoney.hk.ui.LuckyMoneyHKReceiveUI.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(c.a<bfb> aVar) {
                String str;
                AppMethodBeat.i(213282);
                c.a<bfb> aVar2 = aVar;
                if (aVar2.errType == 0 && aVar2.errCode == 0) {
                    bfb bfb = (bfb) aVar2.iLC;
                    if (bfb.dDN == 0) {
                        com.tencent.mm.plugin.luckymoney.a.b.a(LuckyMoneyHKReceiveUI.this.yUc, ac.a(bfb));
                        LuckyMoneyHKReceiveUI.a(LuckyMoneyHKReceiveUI.this, bfb);
                    } else {
                        String str2 = LuckyMoneyHKReceiveUI.yUb;
                        if (!Util.isNullOrNil(bfb.qwn)) {
                            str = bfb.qwn;
                        } else {
                            str = str2;
                        }
                        h.cD(LuckyMoneyHKReceiveUI.this.getContext(), str);
                    }
                } else {
                    String str3 = LuckyMoneyHKReceiveUI.yUb;
                    if (!Util.isNullOrNil(aVar2.errMsg)) {
                        str3 = aVar2.errMsg;
                    }
                    h.cD(LuckyMoneyHKReceiveUI.this.getContext(), str3);
                }
                LuckyMoneyHKReceiveUI.this.finish();
                AppMethodBeat.o(213282);
                return null;
            }
        }).a(luckyMoneyHKReceiveUI);
        AppMethodBeat.o(213297);
    }

    static /* synthetic */ void a(LuckyMoneyHKReceiveUI luckyMoneyHKReceiveUI, bfg bfg) {
        AppMethodBeat.i(213298);
        Log.i("MicroMsg.LuckyMoneyHKReceiveUI", "do open hb");
        new com.tencent.mm.plugin.luckymoney.hk.a.b(luckyMoneyHKReceiveUI.yUq, luckyMoneyHKReceiveUI.yUc, luckyMoneyHKReceiveUI.getIntent().getStringExtra("key_username"), luckyMoneyHKReceiveUI.yUr, bfg.yXR).aYI().b(new com.tencent.mm.vending.c.a<Object, c.a<bfd>>() {
            /* class com.tencent.mm.plugin.luckymoney.hk.ui.LuckyMoneyHKReceiveUI.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(c.a<bfd> aVar) {
                String str;
                com.tencent.mm.plugin.wallet_core.utils.b bVar;
                AppMethodBeat.i(213284);
                c.a<bfd> aVar2 = aVar;
                af.d(LuckyMoneyHKReceiveUI.this.yRl);
                LuckyMoneyHKReceiveUI.this.yRl.setClickable(true);
                LuckyMoneyHKReceiveUI.c(LuckyMoneyHKReceiveUI.this);
                Log.i("MicroMsg.LuckyMoneyHKReceiveUI", "do open hb, errtype: %s, errcode: %s", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode));
                if (aVar2.errType == 0 && aVar2.errCode == 0) {
                    final bfd bfd = (bfd) aVar2.iLC;
                    Log.i("MicroMsg.LuckyMoneyHKReceiveUI", "do open hb, retcode: %s, retmsg: %s", Integer.valueOf(bfd.dDN), bfd.qwn);
                    if (bfd.dDN == 0) {
                        l.a(LuckyMoneyHKReceiveUI.this.getContext(), l.a.NOTSET);
                        if (bfd.LOP == null || !m.a(bfd.LOP).a(LuckyMoneyHKReceiveUI.this.getContext(), new com.tencent.mm.wallet_core.c.g() {
                            /* class com.tencent.mm.plugin.luckymoney.hk.ui.LuckyMoneyHKReceiveUI.AnonymousClass3.AnonymousClass1 */

                            @Override // com.tencent.mm.wallet_core.c.g
                            public final void eeY() {
                                AppMethodBeat.i(213283);
                                LuckyMoneyHKReceiveUI.a(LuckyMoneyHKReceiveUI.this, bfd);
                                AppMethodBeat.o(213283);
                            }
                        })) {
                            cdh cdh = bfd.Lus;
                            if (cdh == null) {
                                bVar = null;
                            } else {
                                bVar = new com.tencent.mm.plugin.wallet_core.utils.b();
                                bVar.dQx = cdh.dQx;
                                bVar.IoL = cdh.IoL;
                                bVar.IoM = cdh.IoM;
                                bVar.IoN = cdh.IoN;
                            }
                            if (com.tencent.mm.plugin.wallet_core.utils.c.a(bVar)) {
                                LuckyMoneyHKReceiveUI.this.setContentViewVisibility(4);
                                com.tencent.mm.plugin.wallet_core.utils.c cVar = new com.tencent.mm.plugin.wallet_core.utils.c(LuckyMoneyHKReceiveUI.this);
                                cVar.IoO = true;
                                cVar.b(bVar);
                                Boolean bool = Boolean.TRUE;
                                AppMethodBeat.o(213284);
                                return bool;
                            }
                            LuckyMoneyHKReceiveUI.a(LuckyMoneyHKReceiveUI.this, bfd);
                        } else {
                            Boolean bool2 = Boolean.TRUE;
                            AppMethodBeat.o(213284);
                            return bool2;
                        }
                    } else if (bfd.dDN == 416) {
                        Log.i("MicroMsg.LuckyMoneyHKReceiveUI", "need verify realname");
                        if (bfd.LgT != null) {
                            dju dju = bfd.LgT;
                            Bundle bundle = new Bundle();
                            bundle.putString("realname_verify_process_jump_activity", ".hk.ui.LuckyMoneyHKReceiveUI");
                            bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                            LuckyMoneyHKReceiveUI.this.yRl.setBackgroundResource(R.drawable.c97);
                            if (dju.KCl == 1) {
                                Log.i("MicroMsg.LuckyMoneyHKReceiveUI", "showRealnameDialog");
                                com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(LuckyMoneyHKReceiveUI.this.getContext(), bundle, null, 1003);
                            } else if (dju.KCl == 2 && !Util.isNullOrNil(dju.yXK)) {
                                Log.i("MicroMsg.LuckyMoneyHKReceiveUI", "showUploadCreditDialog");
                                com.tencent.mm.plugin.wallet_core.id_verify.util.a.a((Activity) LuckyMoneyHKReceiveUI.this.getContext(), dju.yXJ, dju.yXK, dju.lHA, dju.lHB, false, (DialogInterface.OnClickListener) null);
                            }
                        }
                    } else {
                        String str2 = LuckyMoneyHKReceiveUI.yUb;
                        if (!Util.isNullOrNil(bfd.qwn)) {
                            str = bfd.qwn;
                        } else {
                            str = str2;
                        }
                        h.cD(LuckyMoneyHKReceiveUI.this.getContext(), str);
                        LuckyMoneyHKReceiveUI.this.finish();
                    }
                } else {
                    String str3 = LuckyMoneyHKReceiveUI.yUb;
                    if (!Util.isNullOrNil(aVar2.errMsg)) {
                        str3 = aVar2.errMsg;
                    }
                    h.cD(LuckyMoneyHKReceiveUI.this.getContext(), str3);
                    LuckyMoneyHKReceiveUI.this.finish();
                }
                AppMethodBeat.o(213284);
                return null;
            }
        }).a(luckyMoneyHKReceiveUI);
        af.c(luckyMoneyHKReceiveUI.yRl);
        AppMethodBeat.o(213298);
    }

    static /* synthetic */ void r(LuckyMoneyHKReceiveUI luckyMoneyHKReceiveUI) {
        AppMethodBeat.i(213299);
        if (ao.isDarkMode()) {
            luckyMoneyHKReceiveUI.nmW.setBackgroundResource(R.color.BW_0_Alpha_0_8);
            ao.q(luckyMoneyHKReceiveUI, luckyMoneyHKReceiveUI.getResources().getColor(R.color.BW_0_Alpha_0_8));
        } else {
            luckyMoneyHKReceiveUI.nmW.setBackgroundResource(R.color.yr);
            ao.q(luckyMoneyHKReceiveUI, luckyMoneyHKReceiveUI.getResources().getColor(R.color.yr));
        }
        luckyMoneyHKReceiveUI.getContentView().setVisibility(0);
        AppMethodBeat.o(213299);
    }
}
