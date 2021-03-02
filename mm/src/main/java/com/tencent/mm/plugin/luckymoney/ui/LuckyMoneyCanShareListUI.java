package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.model.at;
import com.tencent.mm.plugin.luckymoney.model.y;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import java.util.LinkedList;
import java.util.List;

public class LuckyMoneyCanShareListUI extends LuckyMoneyBaseUI {
    private int fs = 0;
    private boolean mwr = false;
    private List<y> yQe = new LinkedList();
    private MMLoadMoreListView zcN;
    private f zcO;
    private boolean zci = true;
    private String zcp = "";

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LuckyMoneyCanShareListUI() {
        AppMethodBeat.i(65508);
        AppMethodBeat.o(65508);
    }

    static /* synthetic */ void d(LuckyMoneyCanShareListUI luckyMoneyCanShareListUI) {
        AppMethodBeat.i(65513);
        luckyMoneyCanShareListUI.egc();
        AppMethodBeat.o(65513);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(65509);
        super.onCreate(bundle);
        initView();
        egc();
        AppMethodBeat.o(65509);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(65510);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(65505);
                LuckyMoneyCanShareListUI.this.finish();
                AppMethodBeat.o(65505);
                return true;
            }
        });
        this.zcN = (MMLoadMoreListView) findViewById(R.id.f27);
        setMMTitle(getString(R.string.epx));
        this.zcO = new g(getContext());
        this.zcN.setAdapter((ListAdapter) this.zcO);
        this.zcN.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(65506);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyCanShareListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                y PT = LuckyMoneyCanShareListUI.this.zcO.getItem((int) j2);
                if (PT != null && !Util.isNullOrNil(PT.yQE)) {
                    Intent intent = new Intent();
                    intent.setClass(LuckyMoneyCanShareListUI.this.getContext(), LuckyMoneyBeforeDetailUI.class);
                    intent.putExtra("key_sendid", PT.yQE);
                    LuckyMoneyCanShareListUI luckyMoneyCanShareListUI = LuckyMoneyCanShareListUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    a.a(luckyMoneyCanShareListUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyCanShareListUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    luckyMoneyCanShareListUI.startActivity((Intent) bl.pG(0));
                    a.a(luckyMoneyCanShareListUI, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyCanShareListUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyCanShareListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(65506);
            }
        });
        this.zcN.setOnLoadMoreListener(new MMLoadMoreListView.a() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.base.MMLoadMoreListView.a
            public final void onLoadMore() {
                AppMethodBeat.i(65507);
                if (LuckyMoneyCanShareListUI.this.zci && !LuckyMoneyCanShareListUI.this.mwr) {
                    LuckyMoneyCanShareListUI.d(LuckyMoneyCanShareListUI.this);
                }
                AppMethodBeat.o(65507);
            }
        });
        AppMethodBeat.o(65510);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI
    public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(65511);
        if ((qVar instanceof at) && i2 == 0 && i3 == 0) {
            at atVar = (at) qVar;
            LinkedList<y> linkedList = atVar.yXx.yVw;
            this.zcp = atVar.yXg;
            if (linkedList != null) {
                for (int i4 = 0; i4 < linkedList.size(); i4++) {
                    this.yQe.add(linkedList.get(i4));
                }
                this.fs += linkedList.size();
                this.zci = atVar.efl();
                this.mwr = false;
                this.zcO.fq(this.yQe);
            }
            if (this.zci) {
                this.zcN.gKM();
            } else {
                this.zcN.gKN();
            }
            AppMethodBeat.o(65511);
            return true;
        }
        AppMethodBeat.o(65511);
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b42;
    }

    private void egc() {
        AppMethodBeat.i(65512);
        this.mwr = true;
        if (this.fs == 0) {
            this.zcp = "";
        }
        doSceneProgress(new at(10, this.fs, 3, "", "v1.0", this.zcp));
        AppMethodBeat.o(65512);
    }
}
