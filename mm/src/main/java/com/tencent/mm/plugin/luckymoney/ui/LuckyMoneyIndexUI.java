package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.model.ar;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.ui.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t;
import java.util.LinkedList;

public class LuckyMoneyIndexUI extends LuckyMoneyBaseUI {
    private int mChannel;
    private LinearLayout zeu;
    private LinearLayout zev;
    private LinearLayout zew;

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(65603);
        super.onCreate(bundle);
        ((b) g.af(b.class)).a(this, null);
        initView();
        if (af.IA(getIntent().getStringExtra("key_username"))) {
            doSceneProgress(new ar("v1.0", ((Integer) g.aAh().azQ().get(ar.a.USERINFO_LUCKY_MONEY_ENVELOPE_HAS_SOURCE_UNION_INT_SYNC, (Object) 0)).intValue()), false);
        } else {
            doSceneProgress(new aq("v1.0", ((Integer) g.aAh().azQ().get(ar.a.USERINFO_LUCKY_MONEY_ENVELOPE_HAS_SOURCE_INT_SYNC, (Object) 0)).intValue()), false);
        }
        this.mChannel = getIntent().getIntExtra("pay_channel", -1);
        h.INSTANCE.a(11701, 3, 0, 0, 0, 1);
        AppMethodBeat.o(65603);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(65604);
        super.onResume();
        b bVar = (b) g.af(b.class);
        bVar.a(this, bVar.fUE(), null);
        AppMethodBeat.o(65604);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(65605);
        setMMTitle(R.string.ese);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(65598);
                LuckyMoneyIndexUI.this.finish();
                AppMethodBeat.o(65598);
                return true;
            }
        });
        this.zeu = (LinearLayout) findViewById(R.id.f1k);
        this.zev = (LinearLayout) findViewById(R.id.f1i);
        this.zew = (LinearLayout) findViewById(R.id.f1f);
        ((Button) findViewById(R.id.f1j)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(65599);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyIndexUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.INSTANCE.a(11701, 3, 0, 0, 0, 3);
                LuckyMoneyIndexUI.a(LuckyMoneyIndexUI.this, 0);
                a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyIndexUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65599);
            }
        });
        ((Button) findViewById(R.id.f1h)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(65600);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyIndexUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.INSTANCE.a(11701, 3, 0, 0, 0, 2);
                LuckyMoneyIndexUI.a(LuckyMoneyIndexUI.this, 1);
                a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyIndexUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65600);
            }
        });
        addTextOptionMenu(0, getString(R.string.eq3), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(65602);
                h.INSTANCE.a(11701, 3, 0, 0, 0, 4);
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                linkedList.add(LuckyMoneyIndexUI.this.getString(R.string.eqb));
                linkedList2.add(0);
                linkedList.add(LuckyMoneyIndexUI.this.getString(R.string.eqd));
                linkedList2.add(1);
                com.tencent.mm.ui.base.h.b(LuckyMoneyIndexUI.this.getContext(), "", linkedList, linkedList2, "", new h.e() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI.AnonymousClass4.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.h.e
                    public final void cy(int i2, int i3) {
                        int i4 = 1;
                        AppMethodBeat.i(65601);
                        switch (i3) {
                            case 1:
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 3, 0, 0, 0, 6);
                                break;
                            default:
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, 3, 0, 0, 0, 5);
                                i4 = 2;
                                break;
                        }
                        Intent intent = new Intent();
                        intent.setClass(LuckyMoneyIndexUI.this.getContext(), LuckyMoneyMyRecordUI.class);
                        intent.putExtra("key_username", LuckyMoneyIndexUI.this.getIntent().getStringExtra("key_username"));
                        intent.putExtra("key_type", i4);
                        LuckyMoneyIndexUI luckyMoneyIndexUI = LuckyMoneyIndexUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        a.a(luckyMoneyIndexUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyIndexUI$4$1", "onClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        luckyMoneyIndexUI.startActivity((Intent) bl.pG(0));
                        a.a(luckyMoneyIndexUI, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyIndexUI$4$1", "onClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(65601);
                    }
                });
                AppMethodBeat.o(65602);
                return true;
            }
        }, null, t.b.TRANSPARENT_GOLD_TEXT);
        egi();
        AppMethodBeat.o(65605);
    }

    private void egi() {
        o efe;
        AppMethodBeat.i(65606);
        if (af.IA(getIntent().getStringExtra("key_username"))) {
            com.tencent.mm.plugin.luckymoney.b.a.eex();
            efe = com.tencent.mm.plugin.luckymoney.b.a.eez().efe();
        } else {
            com.tencent.mm.plugin.luckymoney.b.a.eex();
            efe = com.tencent.mm.plugin.luckymoney.b.a.eey().efe();
        }
        if (efe == null) {
            AppMethodBeat.o(65606);
            return;
        }
        ImageView imageView = (ImageView) findViewById(R.id.f1l);
        if ((efe.yUT & 1) == 1) {
            Log.i("MicroMsg.LuckyMoneyIndexUI", "initView: topBg use money bg");
            imageView.setImageResource(R.drawable.cdh);
            AppMethodBeat.o(65606);
            return;
        }
        imageView.setImageResource(R.drawable.cdi);
        AppMethodBeat.o(65606);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b3y;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI
    public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(65607);
        if (qVar instanceof aq) {
            if (i2 == 0 && i3 == 0) {
                aq aqVar = (aq) qVar;
                i.c cVar = new i.c();
                cVar.textColor = getResources().getColor(R.color.yy);
                cVar.zgy = 101;
                i.a(this, this.zeu, aqVar.yVs, cVar, "Text");
                i.c cVar2 = new i.c();
                cVar2.textColor = getResources().getColor(R.color.yy);
                cVar2.zgy = 100;
                i.a(this, this.zev, aqVar.yXq, cVar2, "Text");
                i.c cVar3 = new i.c();
                cVar3.zgy = 102;
                i.a(this, this.zew, aqVar.yXo, cVar3, "Pic");
                egi();
            }
            AppMethodBeat.o(65607);
            return true;
        }
        AppMethodBeat.o(65607);
        return false;
    }

    static /* synthetic */ void a(LuckyMoneyIndexUI luckyMoneyIndexUI, int i2) {
        AppMethodBeat.i(65608);
        Intent intent = new Intent();
        intent.setClass(luckyMoneyIndexUI.getContext(), LuckyMoneyPrepareUI.class);
        intent.putExtra("key_way", 3);
        intent.putExtra("key_type", i2);
        intent.putExtra("pay_channel", luckyMoneyIndexUI.mChannel);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        a.a(luckyMoneyIndexUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyIndexUI", "goPrepareLuckmoney", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        luckyMoneyIndexUI.startActivity((Intent) bl.pG(0));
        a.a(luckyMoneyIndexUI, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyIndexUI", "goPrepareLuckmoney", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(65608);
    }
}
