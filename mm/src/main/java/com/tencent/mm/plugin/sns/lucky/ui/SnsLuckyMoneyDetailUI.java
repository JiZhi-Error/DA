package com.tencent.mm.plugin.sns.lucky.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.l.a;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import java.util.LinkedList;
import java.util.List;

public class SnsLuckyMoneyDetailUI extends LuckyMoneyBaseUI {
    private b DGf;
    private ListView yQs;
    AbsListView.OnScrollListener yQz = new AbsListView.OnScrollListener() {
        /* class com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI.AnonymousClass1 */
        private boolean yQA = false;
        private boolean yQB;

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            AppMethodBeat.i(68354);
            if (absListView.getCount() == 0) {
                AppMethodBeat.o(68354);
                return;
            }
            switch (i2) {
                case 0:
                    this.yQA = false;
                    AppMethodBeat.o(68354);
                    return;
                case 1:
                    this.yQA = true;
                    break;
            }
            AppMethodBeat.o(68354);
        }

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            int i5;
            boolean z = true;
            AppMethodBeat.i(68355);
            if (i4 == 0 || !this.yQA) {
                AppMethodBeat.o(68355);
                return;
            }
            if (i2 <= 0) {
                View childAt = absListView.getChildAt(i2);
                if (childAt != null) {
                    i5 = 0 - childAt.getTop();
                } else {
                    i5 = 0;
                }
                if (i5 <= 100) {
                    z = false;
                }
            }
            if (this.yQB != z) {
                if (z) {
                    SnsLuckyMoneyDetailUI.this.getResources().getDrawable(R.color.a96);
                    SnsLuckyMoneyDetailUI.eZN();
                } else {
                    SnsLuckyMoneyDetailUI.eZO();
                }
                this.yQB = z;
            }
            AppMethodBeat.o(68355);
        }
    };
    private final int zec = 750;
    private final int zed = 240;

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsLuckyMoneyDetailUI() {
        AppMethodBeat.i(68357);
        AppMethodBeat.o(68357);
    }

    static /* synthetic */ void eZN() {
    }

    static /* synthetic */ void eZO() {
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68358);
        super.onCreate(bundle);
        initView();
        List<a.C1455a> aDm = a.aDm(getIntent().getStringExtra("key_feedid"));
        if (!(aDm == null || aDm.size() == 0)) {
            b bVar = this.DGf;
            if (aDm == null) {
                new LinkedList();
            } else {
                bVar.yQe = aDm;
            }
            bVar.notifyDataSetChanged();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.a99));
        }
        setMMSubTitle((String) null);
        AppMethodBeat.o(68358);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(68359);
        getResources().getDrawable(R.drawable.cbq);
        setMMTitle(R.string.h88);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(68356);
                SnsLuckyMoneyDetailUI.this.finish();
                AppMethodBeat.o(68356);
                return true;
            }
        });
        this.yQs = (ListView) findViewById(R.id.ezi);
        this.DGf = new b(getContext());
        this.yQs.setAdapter((ListAdapter) this.DGf);
        this.yQs.setOnScrollListener(this.yQz);
        this.yQs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(213844);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/lucky/ui/SnsLuckyMoneyDetailUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/lucky/ui/SnsLuckyMoneyDetailUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(213844);
            }
        });
        AppMethodBeat.o(68359);
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(68360);
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(68360);
        return dispatchKeyEvent;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI
    public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.by_;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(68361);
        super.onDestroy();
        AppMethodBeat.o(68361);
    }
}
