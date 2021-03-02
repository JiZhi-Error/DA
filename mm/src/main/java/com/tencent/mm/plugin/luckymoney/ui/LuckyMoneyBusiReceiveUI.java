package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.aj;
import com.tencent.mm.plugin.luckymoney.model.ak;
import com.tencent.mm.plugin.luckymoney.model.al;
import com.tencent.mm.plugin.luckymoney.model.ao;
import com.tencent.mm.plugin.luckymoney.model.bf;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.f;
import java.io.IOException;

@a(3)
public class LuckyMoneyBusiReceiveUI extends LuckyMoneyBaseUI {
    private q tipDialog = null;
    private TextView yQk;
    private ImageView yQt;
    private TextView yRk;
    private Button yRl;
    private View yRp;
    private ImageView yTs;
    private String yUc = null;
    private String yUq = null;
    private TextView zcA;
    private Button zcB;
    private TextView zcC;
    private CheckBox zcD;
    private int zcE;
    private String zcF = null;
    private int zcG = 0;
    private al zcH;
    private RealnameGuideHelper zcI;
    private int zcm = 0;
    private TextView zcu;
    private TextView zcv;
    private View zcw;
    private ImageView zcx;
    private TextView zcy;
    private View zcz;

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ View b(LuckyMoneyBusiReceiveUI luckyMoneyBusiReceiveUI) {
        AppMethodBeat.i(65502);
        View contentView = luckyMoneyBusiReceiveUI.getContentView();
        AppMethodBeat.o(65502);
        return contentView;
    }

    static /* synthetic */ View c(LuckyMoneyBusiReceiveUI luckyMoneyBusiReceiveUI) {
        AppMethodBeat.i(65503);
        View contentView = luckyMoneyBusiReceiveUI.getContentView();
        AppMethodBeat.o(65503);
        return contentView;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(65494);
        super.onCreate(bundle);
        this.yUq = getIntent().getStringExtra("key_native_url");
        this.zcE = getIntent().getIntExtra("key_way", 5);
        this.zcm = getIntent().getIntExtra("key_static_from_scene", 0);
        Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "nativeurl=" + Util.nullAsNil(this.yUq) + ", mWay=" + this.zcE);
        init();
        h.INSTANCE.a(11701, 10, 0, 0, 0, 1);
        initView();
        addSceneEndListener(980);
        AppMethodBeat.o(65494);
    }

    private void init() {
        AppMethodBeat.i(65495);
        this.tipDialog = com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI.AnonymousClass1 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(65483);
                if (LuckyMoneyBusiReceiveUI.this.tipDialog != null && LuckyMoneyBusiReceiveUI.this.tipDialog.isShowing()) {
                    LuckyMoneyBusiReceiveUI.this.tipDialog.dismiss();
                }
                LuckyMoneyBusiReceiveUI.this.zbX.forceCancel();
                if (LuckyMoneyBusiReceiveUI.b(LuckyMoneyBusiReceiveUI.this).getVisibility() == 8 || LuckyMoneyBusiReceiveUI.c(LuckyMoneyBusiReceiveUI.this).getVisibility() == 4) {
                    Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "user cancel & finish");
                    LuckyMoneyBusiReceiveUI.this.finish();
                }
                AppMethodBeat.o(65483);
            }
        });
        if (this.zcE == 3) {
            doSceneProgress(new aj(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url")), false);
        } else if (this.zcE == 4) {
            doSceneProgress(new aj(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("key_wxapi_sign"), getIntent().getStringExtra("key_wxapi_package_name")), false);
        } else {
            try {
                this.yUc = Uri.parse(Util.nullAsNil(this.yUq)).getQueryParameter("sendid");
            } catch (Exception e2) {
            }
            if (!Util.isNullOrNil(this.yUc)) {
                doSceneProgress(new al(this.yUc, this.yUq, this.zcE, getIntent().getStringExtra("packageExt")), false);
            } else {
                finish();
                Log.w("MicroMsg.LuckyMoneyBusiReceiveUI", "sendid null & finish");
            }
        }
        bE(0, "");
        AppMethodBeat.o(65495);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(65496);
        if (intent != null && intent.hasExtra("key_is_realname_verify_process")) {
            if (intent.getIntExtra("realname_verify_process_ret", 0) == -1) {
                Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process succ");
                init();
                AppMethodBeat.o(65496);
                return;
            }
            Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process cancel");
            bE(-1, "");
            finish();
        }
        AppMethodBeat.o(65496);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(65497);
        super.onDestroy();
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        removeSceneEndListener(980);
        AppMethodBeat.o(65497);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(65498);
        this.yRp = findViewById(R.id.ey4);
        this.yQt = (ImageView) findViewById(R.id.ey8);
        this.yRk = (TextView) findViewById(R.id.ey9);
        this.zcv = (TextView) findViewById(R.id.ey5);
        this.zcu = (TextView) findViewById(R.id.eyc);
        this.yRl = (Button) findViewById(R.id.ey6);
        this.yTs = (ImageView) findViewById(R.id.eyf);
        this.zcw = findViewById(R.id.ey3);
        this.yQk = (TextView) findViewById(R.id.ey2);
        this.zcx = (ImageView) findViewById(R.id.eyg);
        this.zcy = (TextView) findViewById(R.id.eye);
        this.zcz = findViewById(R.id.ey_);
        this.zcA = (TextView) findViewById(R.id.eya);
        this.zcB = (Button) findViewById(R.id.eyh);
        this.zcC = (TextView) findViewById(R.id.ey7);
        this.zcD = (CheckBox) findViewById(R.id.eyi);
        this.yTs.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(65485);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiReceiveUI");
                bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                if (LuckyMoneyBusiReceiveUI.this.zcI == null || !LuckyMoneyBusiReceiveUI.this.zcI.a(LuckyMoneyBusiReceiveUI.this, bundle, null, null, true)) {
                    LuckyMoneyBusiReceiveUI.this.finish();
                } else {
                    LuckyMoneyBusiReceiveUI.this.zcI = null;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65485);
            }
        });
        setContentViewVisibility(8);
        AppMethodBeat.o(65498);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI
    public final boolean onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        String string;
        AppMethodBeat.i(65499);
        if (qVar instanceof al) {
            if (i2 == 0 && i3 == 0) {
                this.zcH = (al) qVar;
                ae aeVar = new ae();
                aeVar.field_mNativeUrl = this.yUq;
                aeVar.field_hbType = this.zcH.egY;
                aeVar.field_hbStatus = this.zcH.egZ;
                aeVar.field_receiveStatus = this.zcH.eha;
                t.fQE().a(aeVar);
                this.yUc = this.zcH.yQE;
                this.zcG = this.zcH.egY;
                h.INSTANCE.a(13050, Integer.valueOf(this.zcm), 1, this.zcH.yWR);
                if (this.zcH.eha == 2) {
                    bE(-1, "");
                    doSceneProgress(new ao(this.yUc, 11, 0, this.yUq, "v1.0"), false);
                } else {
                    if (this.tipDialog != null && this.tipDialog.isShowing()) {
                        this.tipDialog.hide();
                    }
                    af.r(this.yQt, this.zcH.yWV);
                    af.a(getContext(), this.yRk, this.zcH.yWL);
                    af.o(this.zcx, this.zcH.yVt);
                    if (this.zcH.eha == 1 || this.zcH.egZ == 4 || this.zcH.egZ == 5 || this.zcH.egZ == 1) {
                        h.INSTANCE.a(11701, 11, 0, 0, 0, 3);
                        this.zcu.setVisibility(4);
                        this.zcv.setText(this.zcH.yVb);
                        this.yRl.setVisibility(8);
                        if (this.zcG == 1) {
                            this.zcy.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI.AnonymousClass5 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(65487);
                                    b bVar = new b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    h.INSTANCE.a(11701, 11, 0, 0, 0, 4);
                                    Intent intent = new Intent();
                                    intent.setClass(LuckyMoneyBusiReceiveUI.this.getContext(), LuckyMoneyBusiDetailUI.class);
                                    intent.putExtra("key_native_url", LuckyMoneyBusiReceiveUI.this.yUq);
                                    intent.putExtra("key_sendid", LuckyMoneyBusiReceiveUI.this.zcH.yQE);
                                    intent.putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.this.zcm);
                                    LuckyMoneyBusiReceiveUI luckyMoneyBusiReceiveUI = LuckyMoneyBusiReceiveUI.this;
                                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                    com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyBusiReceiveUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    luckyMoneyBusiReceiveUI.startActivity((Intent) bl.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyBusiReceiveUI, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    LuckyMoneyBusiReceiveUI.this.finish();
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(65487);
                                }
                            });
                            this.zcy.setVisibility(0);
                        } else {
                            this.zcy.setVisibility(8);
                        }
                    } else {
                        if (!Util.isNullOrNil(this.zcH.yWR)) {
                            this.zcF = this.zcH.yWR;
                            if (this.zcH.yWS == 1) {
                                this.zcD.setVisibility(8);
                            } else {
                                Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "show checkbox for " + this.zcH.yWR);
                                if (this.zcH.yWP == 1) {
                                    this.zcD.setChecked(true);
                                } else {
                                    this.zcD.setChecked(false);
                                }
                                this.zcD.setText(this.zcH.yWQ);
                            }
                        }
                        this.yRl.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI.AnonymousClass4 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(65486);
                                b bVar = new b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                h.INSTANCE.a(11701, 10, 0, 0, 0, 2);
                                if (LuckyMoneyBusiReceiveUI.this.zcD.isChecked()) {
                                    h.INSTANCE.a(13050, Integer.valueOf(LuckyMoneyBusiReceiveUI.this.zcm), 2, LuckyMoneyBusiReceiveUI.this.zcH.yWR);
                                } else {
                                    h.INSTANCE.a(13050, Integer.valueOf(LuckyMoneyBusiReceiveUI.this.zcm), 2, "");
                                }
                                LuckyMoneyBusiReceiveUI.i(LuckyMoneyBusiReceiveUI.this);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(65486);
                            }
                        });
                        if (!Util.isNullOrNil(this.zcH.yVb)) {
                            this.zcu.setText(this.zcH.yVb);
                        } else {
                            this.zcu.setVisibility(8);
                        }
                        if (!Util.isNullOrNil(this.zcH.yWW)) {
                            this.zcv.setText(this.zcH.yWW);
                        } else {
                            this.zcv.setVisibility(8);
                        }
                    }
                    af.a(this.yRp, null);
                    getContentView().setVisibility(0);
                }
                AppMethodBeat.o(65499);
                return true;
            }
        } else if (qVar instanceof ak) {
            af.d(this.yRl);
            if (i2 == 0 && i3 == 0) {
                bE(-1, "");
                final ak akVar = (ak) qVar;
                ae aeVar2 = new ae();
                aeVar2.field_mNativeUrl = this.yUq;
                aeVar2.field_hbType = akVar.yWT.egY;
                aeVar2.field_receiveAmount = akVar.yWT.eht;
                aeVar2.field_receiveTime = System.currentTimeMillis();
                aeVar2.field_hbStatus = akVar.yWT.egZ;
                aeVar2.field_receiveStatus = akVar.yWT.eha;
                if (aeVar2.field_receiveAmount > 0) {
                    t.fQE().a(aeVar2);
                }
                if (akVar.eha != 2) {
                    this.zcu.setVisibility(4);
                    this.zcv.setText(akVar.yVb);
                    this.yRl.setVisibility(8);
                    if (this.zcG == 1) {
                        this.zcy.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI.AnonymousClass9 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(65493);
                                b bVar = new b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                Intent intent = new Intent();
                                intent.setClass(LuckyMoneyBusiReceiveUI.this.getContext(), LuckyMoneyBusiDetailUI.class);
                                if (akVar.yRu != null) {
                                    intent.putExtra("key_realname_guide_helper", akVar.yRu);
                                }
                                intent.putExtra("key_native_url", LuckyMoneyBusiReceiveUI.this.yUq);
                                intent.putExtra("key_sendid", akVar.yQE);
                                intent.putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.this.zcm);
                                LuckyMoneyBusiReceiveUI luckyMoneyBusiReceiveUI = LuckyMoneyBusiReceiveUI.this;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyBusiReceiveUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                luckyMoneyBusiReceiveUI.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyBusiReceiveUI, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                LuckyMoneyBusiReceiveUI.this.finish();
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(65493);
                            }
                        });
                        this.zcy.setVisibility(0);
                    } else {
                        this.zcy.setVisibility(8);
                    }
                } else if (akVar.qwe <= 1 || !(akVar.yVq == null || akVar.yVq.gGn == 1)) {
                    Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can not atomic go detail");
                    Intent intent = new Intent();
                    intent.putExtra("key_sendid", akVar.yQE);
                    intent.putExtra("key_static_from_scene", this.zcm);
                    if (akVar.yRu != null) {
                        intent.putExtra("key_realname_guide_helper", akVar.yRu);
                    }
                    try {
                        intent.putExtra("key_detail_info", akVar.yWT.toByteArray());
                        intent.putExtra("key_jump_from", 2);
                    } catch (IOException e2) {
                        Log.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e2.getLocalizedMessage());
                    }
                    if (com.tencent.mm.n.h.aqJ().getInt("PlayCoinSound", 0) > 0) {
                        intent.putExtra("play_sound", true);
                    }
                    c.b(getContext(), "luckymoney", ".ui.LuckyMoneyBusiDetailUI", intent);
                    finish();
                    AppMethodBeat.o(65499);
                    return true;
                } else {
                    final View findViewById = findViewById(R.id.eyd);
                    TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-findViewById.getHeight()));
                    translateAnimation.setDuration(400);
                    translateAnimation.setFillAfter(true);
                    translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI.AnonymousClass6 */

                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            AppMethodBeat.i(65488);
                            findViewById.setVisibility(8);
                            AppMethodBeat.o(65488);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    findViewById.startAnimation(translateAnimation);
                    this.yQk.setText(f.formatMoney2f(((double) akVar.eht) / 100.0d));
                    this.yRk.setText(akVar.yWL);
                    this.zcu.setVisibility(8);
                    this.zcv.setVisibility(8);
                    this.zcw.setVisibility(0);
                    this.yRl.setVisibility(8);
                    if (!Util.isNullOrNil(akVar.yWO)) {
                        string = akVar.yWO;
                    } else {
                        string = getString(R.string.es7);
                    }
                    this.zcB.setText(string);
                    this.zcC.setVisibility(0);
                    h.INSTANCE.a(11701, 12, 0, 0, 0, 1);
                    Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "totalNum:" + akVar.qwe);
                    if (akVar.qwe > 1 || (akVar.yVq != null && akVar.yVq.gGn == 1)) {
                        Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can atomic");
                        this.zcI = akVar.yRu;
                        this.zcB.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI.AnonymousClass7 */

                            public final void onClick(View view) {
                                String string;
                                AppMethodBeat.i(65491);
                                b bVar = new b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                LuckyMoneyBusiReceiveUI.this.yRp.setVisibility(4);
                                LuckyMoneyBusiReceiveUI.this.zcC.setVisibility(8);
                                LuckyMoneyBusiReceiveUI.this.zcw.setVisibility(8);
                                if (akVar.yVq == null || Util.isNullOrNil(akVar.yVq.yUH)) {
                                    string = LuckyMoneyBusiReceiveUI.this.getString(R.string.es8);
                                } else {
                                    string = akVar.yVq.yUH;
                                }
                                LuckyMoneyBusiReceiveUI.this.zcB.setText(string);
                                LuckyMoneyBusiReceiveUI.this.zcA.setText(akVar.yWM);
                                LuckyMoneyBusiReceiveUI.this.zcz.setVisibility(0);
                                LuckyMoneyBusiReceiveUI.this.zcB.setOnClickListener(new View.OnClickListener() {
                                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI.AnonymousClass7.AnonymousClass1 */

                                    public final void onClick(View view) {
                                        AppMethodBeat.i(65489);
                                        b bVar = new b();
                                        bVar.bm(view);
                                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$6$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                        h.INSTANCE.a(11701, 12, 0, 0, 0, 2);
                                        af.a((MMActivity) LuckyMoneyBusiReceiveUI.this, 1, false);
                                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$6$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                        AppMethodBeat.o(65489);
                                    }
                                });
                                af.a(LuckyMoneyBusiReceiveUI.this.yRp, new Animation.AnimationListener() {
                                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI.AnonymousClass7.AnonymousClass2 */

                                    public final void onAnimationStart(Animation animation) {
                                        AppMethodBeat.i(65490);
                                        LuckyMoneyBusiReceiveUI.this.yRp.setVisibility(0);
                                        AppMethodBeat.o(65490);
                                    }

                                    public final void onAnimationRepeat(Animation animation) {
                                    }

                                    public final void onAnimationEnd(Animation animation) {
                                    }
                                });
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(65491);
                            }
                        });
                    } else {
                        this.zcB.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI.AnonymousClass8 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(65492);
                                b bVar = new b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                LuckyMoneyBusiReceiveUI.this.finish();
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(65492);
                            }
                        });
                    }
                    this.zcB.setVisibility(0);
                }
                AppMethodBeat.o(65499);
                return true;
            } else if (i3 == 416) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.hide();
                }
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiReceiveUI");
                bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                this.yRl.setBackgroundResource(R.drawable.c97);
                boolean a2 = af.a(this, i3, qVar, bundle, false, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI.AnonymousClass10 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                }, new d.a() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI.AnonymousClass2 */

                    @Override // com.tencent.mm.wallet_core.d.a
                    public final Intent q(int i2, Bundle bundle) {
                        AppMethodBeat.i(65484);
                        Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "re");
                        AppMethodBeat.o(65484);
                        return null;
                    }
                }, 1005);
                AppMethodBeat.o(65499);
                return a2;
            }
        } else if (qVar instanceof bf) {
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.ui.base.h.cD(this, getString(R.string.dzo));
                h.INSTANCE.a(11701, 12, 0, 0, 0, 4);
                finish();
                AppMethodBeat.o(65499);
                return true;
            }
            com.tencent.mm.ui.base.h.cD(this, str);
            AppMethodBeat.o(65499);
            return true;
        } else if (qVar instanceof aj) {
            if (i2 == 0 && i3 == 0) {
                doSceneProgress(new al(this.yUc, this.yUq, this.zcE, getIntent().getStringExtra("packageExt")));
                AppMethodBeat.o(65499);
                return true;
            }
        } else if (qVar instanceof ag) {
            AppMethodBeat.o(65499);
            return true;
        } else if (qVar instanceof ao) {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.hide();
            }
            if (i2 == 0 && i3 == 0) {
                ao aoVar = (ao) qVar;
                Intent intent2 = new Intent();
                intent2.setClass(getContext(), LuckyMoneyBusiDetailUI.class);
                try {
                    intent2.putExtra("key_detail_info", aoVar.yWT.toByteArray());
                    intent2.putExtra("key_jump_from", 2);
                } catch (IOException e3) {
                    Log.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e3.getLocalizedMessage());
                }
                intent2.putExtra("key_native_url", this.yUq);
                intent2.putExtra("key_sendid", this.yUc);
                intent2.putExtra("key_static_from_scene", this.zcm);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBusiReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                finish();
                AppMethodBeat.o(65499);
                return true;
            }
        }
        if (!(i2 == 0 && i3 == 0)) {
            bE(2, str);
        }
        AppMethodBeat.o(65499);
        return false;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(65500);
        switch (i2) {
            case 1:
                if (i3 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    h.INSTANCE.a(11701, 12, 0, 0, 0, 3, stringExtra);
                    if (!Util.isNullOrNil(stringExtra)) {
                        doSceneProgress(new bf(stringExtra, this.yUc, "v1.0"));
                        break;
                    }
                }
                break;
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(65500);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b3j;
    }

    private void bE(int i2, String str) {
        AppMethodBeat.i(65501);
        Log.i("MicroMsg.LuckyMoneyBusiReceiveUI", "markResult resultCode:%d errMsg:%s", Integer.valueOf(i2), str);
        Intent intent = new Intent();
        intent.putExtra("key_result_errmsg", str);
        setResult(i2, intent);
        AppMethodBeat.o(65501);
    }

    static /* synthetic */ void i(LuckyMoneyBusiReceiveUI luckyMoneyBusiReceiveUI) {
        AppMethodBeat.i(65504);
        luckyMoneyBusiReceiveUI.doSceneProgress(new ak(luckyMoneyBusiReceiveUI.zcH.yQE, luckyMoneyBusiReceiveUI.zcH.egX, luckyMoneyBusiReceiveUI.zcH.yWU, luckyMoneyBusiReceiveUI.getIntent().getStringExtra("packageExt"), luckyMoneyBusiReceiveUI.getIntent().getStringExtra("key_username")), false);
        af.b(luckyMoneyBusiReceiveUI.yRl);
        AppMethodBeat.o(65504);
    }
}
