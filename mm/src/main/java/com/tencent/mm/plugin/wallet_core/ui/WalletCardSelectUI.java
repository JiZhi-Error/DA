package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class WalletCardSelectUI extends WalletBaseUI {
    private int HDE = -1;
    private int HJE = 3;
    private List<ElementQuery> IfI = new LinkedList();
    private List<ElementQuery> IfJ = new LinkedList();
    private CheckedTextView IfK;
    private CheckedTextView IfL;
    private String IfM;
    private int IfN;
    private int IfO = -1;
    private int IfP = -1;
    private a IfQ;
    private MaxListView IfR;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletCardSelectUI() {
        AppMethodBeat.i(70870);
        AppMethodBeat.o(70870);
    }

    static /* synthetic */ void a(WalletCardSelectUI walletCardSelectUI, boolean z) {
        AppMethodBeat.i(70874);
        walletCardSelectUI.yn(z);
        AppMethodBeat.o(70874);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(70871);
        super.onCreate(bundle);
        setMMTitle(R.string.iae);
        initView();
        this.IfJ.clear();
        this.IfI.clear();
        if (t.fQQ().HQe != null) {
            for (ElementQuery elementQuery : t.fQQ().HQe) {
                if (this.HDE == 5 && !elementQuery.HXH) {
                    elementQuery.HXr = getString(R.string.iv_);
                }
                if (elementQuery.fQd()) {
                    this.IfJ.add(elementQuery);
                } else if (elementQuery.fQr()) {
                    this.IfI.add(elementQuery);
                }
            }
        }
        if (this.HJE == 3 && !this.IfJ.isEmpty()) {
            if (t.fQI().fRt()) {
                Collections.sort(this.IfJ, new Comparator<ElementQuery>() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI.AnonymousClass6 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // java.util.Comparator
                    public final /* bridge */ /* synthetic */ int compare(ElementQuery elementQuery, ElementQuery elementQuery2) {
                        return elementQuery.HQg - elementQuery2.HQg;
                    }
                });
            } else {
                Collections.sort(this.IfJ, new Comparator<ElementQuery>() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI.AnonymousClass7 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // java.util.Comparator
                    public final /* bridge */ /* synthetic */ int compare(ElementQuery elementQuery, ElementQuery elementQuery2) {
                        return elementQuery2.HQg - elementQuery.HQg;
                    }
                });
            }
        }
        if (this.IfI.isEmpty()) {
            int size = this.IfJ.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (this.IfJ.get(i2).dDj.equals(this.IfM)) {
                    this.IfP = i2;
                    yn(false);
                    enableOptionMenu(true);
                    break;
                } else {
                    i2++;
                }
            }
            if (this.IfP < 0) {
                yn(false);
                enableOptionMenu(false);
            }
            this.IfK.setVisibility(8);
            this.IfL.setBackgroundResource(R.drawable.qa);
            this.IfL.setCheckMarkDrawable(R.drawable.arh);
            AppMethodBeat.o(70871);
        } else if (Util.isNullOrNil(this.IfM)) {
            this.IfK.setChecked(false);
            this.IfL.setChecked(false);
            this.IfR.setVisibility(8);
            AppMethodBeat.o(70871);
        } else if (this.IfN == 2) {
            int size2 = this.IfJ.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size2) {
                    break;
                } else if (this.IfJ.get(i3).dDj.equals(this.IfM)) {
                    this.IfP = i3;
                    yn(false);
                    enableOptionMenu(true);
                    break;
                } else {
                    i3++;
                }
            }
            if (this.IfP < 0) {
                yn(false);
                enableOptionMenu(false);
            }
            AppMethodBeat.o(70871);
        } else {
            int size3 = this.IfI.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size3) {
                    break;
                } else if (this.IfI.get(i4).dDj.equals(this.IfM)) {
                    this.IfO = i4;
                    yn(true);
                    enableOptionMenu(true);
                    break;
                } else {
                    i4++;
                }
            }
            if (this.IfO < 0) {
                yn(false);
                enableOptionMenu(false);
            }
            AppMethodBeat.o(70871);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(70872);
        this.IfM = getInput().getString("key_bank_type");
        this.IfN = getInput().getInt("key_bankcard_type", 1);
        this.HJE = getInput().getInt("key_support_bankcard", 1);
        this.HDE = getInput().getInt("key_bind_scene", -1);
        this.IfR = (MaxListView) findViewById(R.id.hmp);
        this.IfK = (CheckedTextView) findViewById(R.id.b0i);
        this.IfL = (CheckedTextView) findViewById(R.id.b0j);
        this.IfQ = new a(this);
        this.IfR.setAdapter((ListAdapter) this.IfQ);
        this.IfR.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(70859);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                ElementQuery aeQ = WalletCardSelectUI.this.IfQ.aeQ(i2);
                if (!Util.isNullOrNil(aeQ.HXr)) {
                    h.a((Context) WalletCardSelectUI.this, aeQ.HXr, (String) null, true, (DialogInterface.OnClickListener) null);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(70859);
                    return;
                }
                if (aeQ.fQr()) {
                    WalletCardSelectUI.this.IfO = i2;
                } else {
                    WalletCardSelectUI.this.IfP = i2;
                }
                WalletCardSelectUI.this.enableOptionMenu(true);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(70859);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(70860);
                WalletCardSelectUI.this.finish();
                AppMethodBeat.o(70860);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.vl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(70861);
                ElementQuery elementQuery = null;
                Intent intent = new Intent();
                if (WalletCardSelectUI.this.IfK.isChecked() && WalletCardSelectUI.this.IfO >= 0) {
                    elementQuery = (ElementQuery) WalletCardSelectUI.this.IfI.get(WalletCardSelectUI.this.IfO);
                } else if (WalletCardSelectUI.this.IfL.isChecked() && WalletCardSelectUI.this.IfP >= 0) {
                    elementQuery = (ElementQuery) WalletCardSelectUI.this.IfJ.get(WalletCardSelectUI.this.IfP);
                }
                if (elementQuery != null) {
                    intent.putExtra("elemt_query", elementQuery);
                    WalletCardSelectUI.this.setResult(-1, intent);
                } else {
                    WalletCardSelectUI.this.setResult(0);
                }
                WalletCardSelectUI.this.finish();
                AppMethodBeat.o(70861);
                return true;
            }
        }, null, t.b.GREEN);
        enableOptionMenu(false);
        this.IfK.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(70862);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletCardSelectUI.a(WalletCardSelectUI.this, true);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70862);
            }
        });
        this.IfL.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(70863);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletCardSelectUI.a(WalletCardSelectUI.this, false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70863);
            }
        });
        AppMethodBeat.o(70872);
    }

    private void yn(boolean z) {
        AppMethodBeat.i(70873);
        this.IfR.setVisibility(0);
        if (z) {
            this.IfK.setChecked(true);
            this.IfL.setChecked(false);
            this.IfQ.iHf = this.IfI;
            this.IfQ.notifyDataSetChanged();
            this.IfR.clearChoices();
            if (this.IfO >= 0) {
                this.IfR.setItemChecked(this.IfO, true);
                enableOptionMenu(true);
                AppMethodBeat.o(70873);
                return;
            }
            enableOptionMenu(false);
            AppMethodBeat.o(70873);
            return;
        }
        this.IfK.setChecked(false);
        this.IfL.setChecked(true);
        this.IfQ.iHf = this.IfJ;
        this.IfQ.notifyDataSetChanged();
        this.IfR.clearChoices();
        if (this.IfP >= 0) {
            this.IfR.setItemChecked(this.IfP, true);
            enableOptionMenu(true);
            AppMethodBeat.o(70873);
            return;
        }
        enableOptionMenu(false);
        AppMethodBeat.o(70873);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c8f;
    }

    public class a extends BaseAdapter {
        private Context context;
        List<ElementQuery> iHf = new ArrayList();

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(70869);
            ElementQuery aeQ = aeQ(i2);
            AppMethodBeat.o(70869);
            return aeQ;
        }

        public a(Context context2) {
            AppMethodBeat.i(70864);
            this.context = context2;
            AppMethodBeat.o(70864);
        }

        public final boolean isEnabled(int i2) {
            AppMethodBeat.i(70865);
            boolean isNullOrNil = Util.isNullOrNil(this.iHf.get(i2).HXr);
            AppMethodBeat.o(70865);
            return isNullOrNil;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            String str;
            AppMethodBeat.i(70866);
            C1918a aVar = new C1918a();
            View inflate = View.inflate(this.context, R.layout.c7v, null);
            aVar.IfT = (CheckedTextView) inflate.findViewById(R.id.b0h);
            ElementQuery elementQuery = this.iHf.get(i2);
            String nullAs = Util.nullAs(elementQuery.ynT, "");
            if (!Util.isNullOrNil(elementQuery.HXr)) {
                str = nullAs + "[" + elementQuery.HXr + "]";
                aVar.IfT.setEnabled(false);
            } else {
                aVar.IfT.setEnabled(true);
                str = nullAs;
            }
            aVar.IfT.setText(str);
            AppMethodBeat.o(70866);
            return inflate;
        }

        public final int getCount() {
            AppMethodBeat.i(70867);
            int size = this.iHf.size();
            AppMethodBeat.o(70867);
            return size;
        }

        public final ElementQuery aeQ(int i2) {
            AppMethodBeat.i(70868);
            ElementQuery elementQuery = this.iHf.get(i2);
            AppMethodBeat.o(70868);
            return elementQuery;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI$a$a  reason: collision with other inner class name */
        class C1918a {
            CheckedTextView IfT;

            C1918a() {
            }
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean checkProcLife() {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }
}
