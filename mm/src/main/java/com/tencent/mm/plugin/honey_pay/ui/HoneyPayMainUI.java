package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.honey_pay.a.f;
import com.tencent.mm.plugin.honey_pay.model.HoneyPayCardType;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.cak;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.dbi;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.wallet_core.c.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HoneyPayMainUI extends HoneyPayBaseUI {
    private LinearLayout ncf;
    private LinearLayout ylr;
    private ImageView yls;
    private RelativeLayout ylt;
    private Button ylu;
    private TextView ylv;
    private ArrayList<HoneyPayCardLayout> ylw = new ArrayList<>();

    @Override // com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public HoneyPayMainUI() {
        AppMethodBeat.i(64783);
        AppMethodBeat.o(64783);
    }

    static /* synthetic */ void a(HoneyPayMainUI honeyPayMainUI, String str, String str2) {
        AppMethodBeat.i(64801);
        honeyPayMainUI.d(str, false, str2);
        AppMethodBeat.o(64801);
    }

    @Override // com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64784);
        fixStatusbar(true);
        super.onCreate(bundle);
        addSceneEndListener(2725);
        addSceneEndListener(2618);
        addSceneEndListener(2926);
        aC(getIntent());
        initView();
        qi(true);
        setMMTitle("");
        AppMethodBeat.o(64784);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(64785);
        this.ncf = (LinearLayout) findViewById(R.id.ds4);
        this.ylt = (RelativeLayout) findViewById(R.id.ds_);
        this.yls = (ImageView) findViewById(R.id.ds9);
        this.ylu = (Button) findViewById(R.id.ds7);
        this.ylv = (TextView) findViewById(R.id.dsa);
        this.ylr = (LinearLayout) findViewById(R.id.ds5);
        this.ylr.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(64771);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayMainUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d(HoneyPayMainUI.this.TAG, "click add friend");
                HoneyPayMainUI.a(HoneyPayMainUI.this);
                a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayMainUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64771);
            }
        });
        this.ylu.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(64777);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayMainUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i(HoneyPayMainUI.this.TAG, "click empty header add friend");
                HoneyPayMainUI.a(HoneyPayMainUI.this);
                a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayMainUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64777);
            }
        });
        if (ao.isDarkMode()) {
            this.yls.setImageResource(R.raw.honey_pay_input_logo_dm);
        }
        AppMethodBeat.o(64785);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(64786);
        super.onDestroy();
        removeSceneEndListener(2725);
        removeSceneEndListener(2618);
        removeSceneEndListener(2926);
        AppMethodBeat.o(64786);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(64787);
        if (qVar instanceof f) {
            final f fVar = (f) qVar;
            fVar.a(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.AnonymousClass11 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64780);
                    HoneyPayMainUI.b(HoneyPayMainUI.this);
                    HoneyPayMainUI.this.removeAllOptionMenu();
                    if (fVar.yjC.MhD == null || fVar.yjC.MhD.isEmpty()) {
                        Log.i(HoneyPayMainUI.this.TAG, "empty card");
                        HoneyPayMainUI.a(HoneyPayMainUI.this, fVar.yjC.MhE);
                        HoneyPayMainUI.this.ylr.setVisibility(8);
                        HoneyPayMainUI.this.wwG = R.color.afz;
                        HoneyPayMainUI.this.setMMTitle("");
                    } else {
                        HoneyPayMainUI.d(HoneyPayMainUI.this);
                        HoneyPayMainUI.a(HoneyPayMainUI.this, fVar.yjC.MhD);
                        Log.i(HoneyPayMainUI.this.TAG, "show open card: %s", Boolean.valueOf(fVar.yjC.MhG));
                        if (fVar.yjC.MhG) {
                            HoneyPayMainUI.this.ylr.setVisibility(0);
                        } else {
                            HoneyPayMainUI.this.ylr.setVisibility(8);
                        }
                        HoneyPayMainUI.this.wwG = R.color.ul;
                        HoneyPayMainUI.this.setMMTitle(R.string.e0n);
                    }
                    HoneyPayMainUI.a(HoneyPayMainUI.this, fVar.yjC.MhH);
                    HoneyPayMainUI.this.dYP();
                    HoneyPayMainUI.this.findViewById(R.id.dse).setBackgroundResource(HoneyPayMainUI.this.wwG);
                    c.b(HoneyPayMainUI.this, fVar.yjC.MhF, null, 0, null);
                    HoneyPayMainUI.this.findViewById(R.id.ds6).setVisibility(8);
                    h.INSTANCE.n(875, 0, 1);
                    AppMethodBeat.o(64780);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.AnonymousClass10 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64779);
                    h.INSTANCE.n(875, 1, 1);
                    AppMethodBeat.o(64779);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.AnonymousClass9 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64778);
                    h.INSTANCE.n(875, 1, 1);
                    AppMethodBeat.o(64778);
                }
            });
        } else if (qVar instanceof com.tencent.mm.plugin.honey_pay.a.a) {
            final com.tencent.mm.plugin.honey_pay.a.a aVar = (com.tencent.mm.plugin.honey_pay.a.a) qVar;
            aVar.a(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.AnonymousClass14 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64782);
                    if (aVar.yjx.LjA != null) {
                        Log.i(HoneyPayMainUI.this.TAG, "do realname guide");
                        Bundle bundle = new Bundle();
                        bundle.putString("realname_verify_process_jump_activity", ".ui.HoneyPayMainUI");
                        c.a(HoneyPayMainUI.this, bundle, aVar.yjx.LjA, true);
                        AppMethodBeat.o(64782);
                        return;
                    }
                    HoneyPayMainUI.b(HoneyPayMainUI.this, aVar.yjx.LjB);
                    AppMethodBeat.o(64782);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.AnonymousClass13 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64781);
                    if (aVar.yjx.LjA != null) {
                        Log.i(HoneyPayMainUI.this.TAG, "do realname guide");
                        Bundle bundle = new Bundle();
                        bundle.putString("realname_verify_process_jump_activity", ".ui.HoneyPayMainUI");
                        c.a(HoneyPayMainUI.this, bundle, aVar.yjx.LjA, true);
                    }
                    AppMethodBeat.o(64781);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.AnonymousClass12 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                }
            });
        } else if (qVar instanceof com.tencent.mm.plugin.honey_pay.a.b) {
            final com.tencent.mm.plugin.honey_pay.a.b bVar = (com.tencent.mm.plugin.honey_pay.a.b) qVar;
            bVar.a(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64772);
                    HoneyPayMainUI.a(HoneyPayMainUI.this, bVar.yjy.LjF, bVar.yjy.LjE, bVar.yjy.LjG, bVar.yjy.LjH, bVar.username);
                    AppMethodBeat.o(64772);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.AnonymousClass15 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                }
            });
        }
        AppMethodBeat.o(64787);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.auo;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(64788);
        Log.i(this.TAG, "on new intent");
        aC(intent);
        super.onNewIntent(intent);
        AppMethodBeat.o(64788);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(64789);
        if (i2 == 3) {
            qi(false);
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(64789);
    }

    private void aC(Intent intent) {
        AppMethodBeat.i(64790);
        boolean booleanExtra = intent.getBooleanExtra("key_create_succ", false);
        String stringExtra = intent.getStringExtra("key_card_no");
        String stringExtra2 = intent.getStringExtra("key_card_type");
        Log.i(this.TAG, "create succ: %s", Boolean.valueOf(booleanExtra));
        if (booleanExtra) {
            d(stringExtra, true, stringExtra2);
        }
        AppMethodBeat.o(64790);
    }

    private void qi(boolean z) {
        AppMethodBeat.i(64791);
        Log.i(this.TAG, "get payer list");
        f fVar = new f();
        fVar.t(this);
        doSceneProgress(fVar, z);
        AppMethodBeat.o(64791);
    }

    private void d(String str, boolean z, String str2) {
        AppMethodBeat.i(64792);
        Log.i(this.TAG, "go to card manager: %s", str);
        Intent intent = new Intent(this, HoneyPayCardManagerUI.class);
        intent.putExtra("key_card_no", str);
        intent.putExtra("key_scene", 0);
        intent.putExtra("key_is_create", z);
        intent.putExtra("key_card_type", str2);
        startActivityForResult(intent, 3);
        AppMethodBeat.o(64792);
    }

    static /* synthetic */ void a(HoneyPayMainUI honeyPayMainUI) {
        AppMethodBeat.i(64793);
        Log.i(honeyPayMainUI.TAG, "do check payer");
        com.tencent.mm.plugin.honey_pay.a.a aVar = new com.tencent.mm.plugin.honey_pay.a.a();
        aVar.t(honeyPayMainUI);
        honeyPayMainUI.doSceneProgress(aVar, true);
        AppMethodBeat.o(64793);
    }

    static /* synthetic */ void b(HoneyPayMainUI honeyPayMainUI) {
        AppMethodBeat.i(64794);
        Iterator<HoneyPayCardLayout> it = honeyPayMainUI.ylw.iterator();
        while (it.hasNext()) {
            honeyPayMainUI.ncf.removeView(it.next());
        }
        honeyPayMainUI.ylw.clear();
        AppMethodBeat.o(64794);
    }

    static /* synthetic */ void a(HoneyPayMainUI honeyPayMainUI, final dbi dbi) {
        AppMethodBeat.i(64795);
        honeyPayMainUI.ylt.setVisibility(0);
        if (dbi == null || Util.isNullOrNil(dbi.MGq)) {
            Log.w(honeyPayMainUI.TAG, "empty help word!");
            honeyPayMainUI.ylv.setVisibility(8);
            AppMethodBeat.o(64795);
            return;
        }
        honeyPayMainUI.ylv.setClickable(true);
        honeyPayMainUI.ylv.setOnTouchListener(new o(honeyPayMainUI));
        com.tencent.mm.plugin.wallet_core.ui.q qVar = new com.tencent.mm.plugin.wallet_core.ui.q(new q.a() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
            public final void dF(View view) {
                AppMethodBeat.i(64775);
                if (!Util.isNullOrNil(dbi.MGr)) {
                    com.tencent.mm.wallet_core.ui.f.o(HoneyPayMainUI.this.getContext(), dbi.MGr, true);
                }
                h.INSTANCE.a(15191, 1, 0, 0, 0, 0, 0);
                AppMethodBeat.o(64775);
            }
        });
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(dbi.MGq);
        spannableStringBuilder.setSpan(qVar, 0, spannableStringBuilder.length(), 18);
        honeyPayMainUI.ylv.setText(spannableStringBuilder);
        AppMethodBeat.o(64795);
    }

    static /* synthetic */ void d(HoneyPayMainUI honeyPayMainUI) {
        AppMethodBeat.i(64796);
        honeyPayMainUI.ylt.setVisibility(8);
        AppMethodBeat.o(64796);
    }

    static /* synthetic */ void a(HoneyPayMainUI honeyPayMainUI, List list) {
        AppMethodBeat.i(64797);
        int i2 = 1;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final cbv cbv = (cbv) it.next();
            HoneyPayCardLayout honeyPayCardLayout = new HoneyPayCardLayout(honeyPayMainUI);
            honeyPayCardLayout.setCardRecord(cbv);
            honeyPayCardLayout.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.AnonymousClass7 */

                public final void onClick(View view) {
                    AppMethodBeat.i(64776);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayMainUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    HoneyPayMainUI.a(HoneyPayMainUI.this, cbv.LWD, cbv.pTn);
                    a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayMainUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(64776);
                }
            });
            honeyPayMainUI.ncf.addView(honeyPayCardLayout, i2);
            honeyPayMainUI.ylw.add(honeyPayCardLayout);
            i2++;
        }
        AppMethodBeat.o(64797);
    }

    static /* synthetic */ void a(HoneyPayMainUI honeyPayMainUI, final jh jhVar) {
        AppMethodBeat.i(64798);
        if (jhVar == null || Util.isNullOrNil(jhVar.title)) {
            final zt ztVar = new zt();
            ztVar.efM.scene = "14";
            ztVar.callback = new Runnable() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(64774);
                    if (!Util.isNullOrNil(ztVar.efN.efO)) {
                        Log.i(HoneyPayMainUI.this.TAG, "show notice banner");
                        com.tencent.mm.wallet_core.ui.f.a((TextView) HoneyPayMainUI.this.findViewById(R.id.a2b), ztVar.efN.efO, ztVar.efN.content, ztVar.efN.url);
                    }
                    AppMethodBeat.o(64774);
                }
            };
            EventCenter.instance.publish(ztVar);
            AppMethodBeat.o(64798);
            return;
        }
        TextView textView = (TextView) honeyPayMainUI.findViewById(R.id.a2b);
        textView.setText(jhVar.title);
        textView.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(64773);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayMainUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.wallet_core.ui.f.o(HoneyPayMainUI.this.getContext(), jhVar.url, true);
                a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayMainUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64773);
            }
        });
        textView.setVisibility(0);
        AppMethodBeat.o(64798);
    }

    static /* synthetic */ void b(HoneyPayMainUI honeyPayMainUI, List list) {
        AppMethodBeat.i(64799);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new HoneyPayCardType((cak) it.next()));
            }
        }
        Intent intent = new Intent(honeyPayMainUI, HoneyPaySelectCardTypeUI.class);
        intent.putParcelableArrayListExtra("key_card_type_list", arrayList);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        a.a(honeyPayMainUI, bl.axQ(), "com/tencent/mm/plugin/honey_pay/ui/HoneyPayMainUI", "gotoSelectCardTypeUI", "(Ljava/util/List;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        honeyPayMainUI.startActivity((Intent) bl.pG(0));
        a.a(honeyPayMainUI, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayMainUI", "gotoSelectCardTypeUI", "(Ljava/util/List;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(64799);
    }

    static /* synthetic */ void a(HoneyPayMainUI honeyPayMainUI, long j2, long j3, String str, String str2, String str3) {
        AppMethodBeat.i(64800);
        Log.i(honeyPayMainUI.TAG, "go to give card");
        Intent intent = new Intent(honeyPayMainUI, HoneyPayGiveCardUI.class);
        intent.putExtra("key_max_credit_line", j2);
        intent.putExtra("key_min_credit_line", j3);
        intent.putExtra("key_true_name", str);
        intent.putExtra("key_take_message", str2);
        intent.putExtra("key_username", str3);
        honeyPayMainUI.startActivityForResult(intent, 2);
        AppMethodBeat.o(64800);
    }
}
