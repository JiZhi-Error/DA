package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxcredit.a.c;
import com.tencent.mm.plugin.wxcredit.a.e;
import com.tencent.mm.plugin.wxcredit.a.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;

public class WalletWXCreditChangeAmountUI extends WalletBaseUI implements View.OnClickListener {
    private EditText JQA;
    private BaseAdapter JQB = new BaseAdapter() {
        /* class com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.AnonymousClass11 */

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(72346);
            l aht = aht(i2);
            AppMethodBeat.o(72346);
            return aht;
        }

        public final int getCount() {
            AppMethodBeat.i(72343);
            if (WalletWXCreditChangeAmountUI.this.JQl != null) {
                int size = WalletWXCreditChangeAmountUI.this.JQl.size();
                AppMethodBeat.o(72343);
                return size;
            }
            AppMethodBeat.o(72343);
            return 0;
        }

        private l aht(int i2) {
            AppMethodBeat.i(72344);
            l lVar = (l) WalletWXCreditChangeAmountUI.this.JQl.get(i2);
            AppMethodBeat.o(72344);
            return lVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(72345);
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(WalletWXCreditChangeAmountUI.this, R.layout.c9i, null);
            l aht = aht(i2);
            checkedTextView.setText(aht.desc);
            checkedTextView.setChecked(aht.JQb != 0);
            AppMethodBeat.o(72345);
            return checkedTextView;
        }
    };
    private BaseAdapter JQC = new BaseAdapter() {
        /* class com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.AnonymousClass2 */

        public final int getCount() {
            return 2;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            boolean z = true;
            AppMethodBeat.i(72333);
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(WalletWXCreditChangeAmountUI.this, R.layout.c9i, null);
            if (i2 == 0) {
                checkedTextView.setText(R.string.a0_);
            } else {
                checkedTextView.setText(R.string.x6);
            }
            if (WalletWXCreditChangeAmountUI.this.JQq) {
                if (WalletWXCreditChangeAmountUI.this.JQm.JQe == null || !"Y".equals(WalletWXCreditChangeAmountUI.this.JQm.yWF)) {
                    if (i2 == 0) {
                        z = false;
                    }
                    checkedTextView.setChecked(z);
                } else {
                    if (i2 != 0) {
                        z = false;
                    }
                    checkedTextView.setChecked(z);
                }
            } else if (WalletWXCreditChangeAmountUI.this.JQn.JQe == null || !"Y".equals(WalletWXCreditChangeAmountUI.this.JQn.yWF)) {
                if (i2 == 0) {
                    z = false;
                }
                checkedTextView.setChecked(z);
            } else {
                if (i2 != 0) {
                    z = false;
                }
                checkedTextView.setChecked(z);
            }
            AppMethodBeat.o(72333);
            return checkedTextView;
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(72334);
            l lVar = (l) WalletWXCreditChangeAmountUI.this.JQl.get(i2);
            AppMethodBeat.o(72334);
            return lVar;
        }
    };
    private List<l> JQk;
    private List<l> JQl = new ArrayList();
    private l JQm;
    private l JQn;
    private int JQo = -1;
    private boolean JQp;
    private boolean JQq;
    private TextView JQr;
    private TextView JQs;
    private TextView JQt;
    private TextView JQu;
    private TextView JQv;
    private TextView JQw;
    private EditText JQx;
    private EditText JQy;
    private EditText JQz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletWXCreditChangeAmountUI() {
        AppMethodBeat.i(72347);
        AppMethodBeat.o(72347);
    }

    static /* synthetic */ void k(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        AppMethodBeat.i(72356);
        walletWXCreditChangeAmountUI.updateView();
        AppMethodBeat.o(72356);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cah;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(72348);
        super.onCreate(bundle);
        initView();
        updateView();
        AppMethodBeat.o(72348);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(72349);
        setMMTitle(R.string.iwv);
        this.JQr = (TextView) findViewById(R.id.jiu);
        this.JQt = (TextView) findViewById(R.id.jiv);
        this.JQs = (TextView) findViewById(R.id.jiw);
        this.JQu = (TextView) findViewById(R.id.jix);
        this.JQx = (EditText) findViewById(R.id.jik);
        this.JQy = (EditText) findViewById(R.id.jil);
        this.JQz = (EditText) findViewById(R.id.jim);
        this.JQA = (EditText) findViewById(R.id.jin);
        this.JQv = (TextView) findViewById(R.id.jio);
        this.JQw = (TextView) findViewById(R.id.jip);
        this.JQv.setOnClickListener(this);
        this.JQw.setOnClickListener(this);
        this.JQr.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(72332);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletWXCreditChangeAmountUI.this.JQp = true;
                WalletWXCreditChangeAmountUI.a(WalletWXCreditChangeAmountUI.this);
                WalletWXCreditChangeAmountUI.this.showDialog(1);
                a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(72332);
            }
        });
        this.JQs.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(72336);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletWXCreditChangeAmountUI.this.JQp = false;
                WalletWXCreditChangeAmountUI.a(WalletWXCreditChangeAmountUI.this);
                WalletWXCreditChangeAmountUI.this.showDialog(1);
                a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(72336);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(72337);
                WalletWXCreditChangeAmountUI.this.hideVKB();
                WalletWXCreditChangeAmountUI.this.showDialog(3);
                AppMethodBeat.o(72337);
                return true;
            }
        });
        findViewById(R.id.fz0).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(72338);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (WalletWXCreditChangeAmountUI.b(WalletWXCreditChangeAmountUI.this)) {
                    if (WalletWXCreditChangeAmountUI.this.JQm.JQe == null) {
                        WalletWXCreditChangeAmountUI.this.JQm.yWF = WalletWXCreditChangeAmountUI.this.JQx.getText().toString();
                    } else if (WalletWXCreditChangeAmountUI.this.JQy.getVisibility() == 0) {
                        WalletWXCreditChangeAmountUI.this.JQm.JQe.yWF = WalletWXCreditChangeAmountUI.this.JQy.getText().toString();
                    }
                    if (WalletWXCreditChangeAmountUI.this.JQn.JQe == null) {
                        WalletWXCreditChangeAmountUI.this.JQn.yWF = WalletWXCreditChangeAmountUI.this.JQz.getText().toString();
                    } else if (WalletWXCreditChangeAmountUI.this.JQA.getVisibility() == 0) {
                        WalletWXCreditChangeAmountUI.this.JQn.JQe.yWF = WalletWXCreditChangeAmountUI.this.JQA.getText().toString();
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(WalletWXCreditChangeAmountUI.this.JQm);
                    arrayList.add(WalletWXCreditChangeAmountUI.this.JQn);
                    String string = WalletWXCreditChangeAmountUI.this.getInput().getString("kreq_token");
                    WalletWXCreditChangeAmountUI.this.getInput().getString("key_bank_type");
                    WalletWXCreditChangeAmountUI.this.doSceneForceProgress(new c(arrayList, string));
                } else {
                    u.makeText(WalletWXCreditChangeAmountUI.this.getContext(), (int) R.string.iwr, 0).show();
                }
                a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(72338);
            }
        });
        AppMethodBeat.o(72349);
    }

    private void updateView() {
        AppMethodBeat.i(72350);
        if (this.JQm != null) {
            this.JQr.setText(this.JQm.desc);
            if (this.JQm.JQe != null) {
                this.JQv.setVisibility(0);
                this.JQx.setVisibility(8);
                this.JQt.setText(this.JQm.JQe.desc);
                this.JQy.setHint(this.JQm.JQe.pWf);
                if ("Y".equals(this.JQm.yWF)) {
                    this.JQt.setVisibility(0);
                    this.JQy.setVisibility(0);
                    this.JQv.setText(R.string.a0_);
                } else {
                    this.JQt.setVisibility(8);
                    this.JQy.setVisibility(8);
                    if ("N".equals(this.JQm.yWF)) {
                        this.JQv.setText(R.string.x6);
                    }
                }
            } else {
                this.JQv.setVisibility(8);
                this.JQx.setVisibility(0);
                this.JQx.setHint(this.JQm.pWf);
                this.JQt.setVisibility(8);
                this.JQy.setVisibility(8);
            }
        }
        if (this.JQn != null) {
            this.JQs.setText(this.JQn.desc);
            if (this.JQn.JQe != null) {
                this.JQw.setVisibility(0);
                this.JQz.setVisibility(8);
                this.JQu.setText(this.JQn.JQe.desc);
                this.JQA.setHint(this.JQn.JQe.pWf);
                if ("Y".equals(this.JQn.yWF)) {
                    this.JQu.setVisibility(0);
                    this.JQA.setVisibility(0);
                    this.JQw.setText(R.string.a0_);
                    AppMethodBeat.o(72350);
                    return;
                }
                this.JQu.setVisibility(8);
                this.JQA.setVisibility(8);
                if ("N".equals(this.JQn.yWF)) {
                    this.JQw.setText(R.string.x6);
                    AppMethodBeat.o(72350);
                    return;
                }
            } else {
                this.JQw.setVisibility(8);
                this.JQz.setVisibility(0);
                this.JQz.setHint(this.JQn.pWf);
                this.JQu.setVisibility(8);
                this.JQA.setVisibility(8);
            }
        }
        AppMethodBeat.o(72350);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(72351);
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof e) {
                this.JQk = ((e) qVar).JPJ;
                this.JQo = ((e) qVar).JPK;
                if (this.JQk != null && this.JQk.size() >= 2) {
                    this.JQm = this.JQk.get(0);
                    this.JQn = this.JQk.get(1);
                    this.JQm.JQb = 1;
                    this.JQn.JQb = 2;
                }
                updateView();
                AppMethodBeat.o(72351);
                return true;
            }
        } else if (qVar instanceof c) {
            h.a((Context) this, str, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(72335);
                    d by = com.tencent.mm.wallet_core.a.by(WalletWXCreditChangeAmountUI.this);
                    if (by != null) {
                        by.b(WalletWXCreditChangeAmountUI.this, WalletWXCreditChangeAmountUI.this.getInput());
                        AppMethodBeat.o(72335);
                        return;
                    }
                    WalletWXCreditChangeAmountUI.this.finish();
                    AppMethodBeat.o(72335);
                }
            });
            AppMethodBeat.o(72351);
            return true;
        }
        AppMethodBeat.o(72351);
        return false;
    }

    public void onClick(View view) {
        AppMethodBeat.i(72352);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getId() == R.id.jio) {
            this.JQq = true;
            showDialog(2);
        } else if (view.getId() == R.id.jip) {
            this.JQq = false;
            showDialog(2);
        }
        a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72352);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public /* synthetic */ Dialog onCreateDialog(int i2) {
        AppMethodBeat.i(72353);
        switch (i2) {
            case 1:
                View inflate = getLayoutInflater().inflate(R.layout.c9h, (ViewGroup) null);
                ListViewInScrollView listViewInScrollView = (ListViewInScrollView) inflate.findViewById(R.id.h4);
                listViewInScrollView.setAdapter((ListAdapter) this.JQB);
                listViewInScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    /* class com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.AnonymousClass7 */

                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                        AppMethodBeat.i(72339);
                        b bVar = new b();
                        bVar.bm(adapterView);
                        bVar.bm(view);
                        bVar.pH(i2);
                        bVar.zo(j2);
                        a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                        WalletWXCreditChangeAmountUI.this.dismissDialog(1);
                        if (WalletWXCreditChangeAmountUI.this.JQp) {
                            WalletWXCreditChangeAmountUI.this.JQm.JQb = 0;
                            WalletWXCreditChangeAmountUI.this.JQm = (l) WalletWXCreditChangeAmountUI.this.JQl.get(i2);
                            WalletWXCreditChangeAmountUI.this.JQm.JQb = 1;
                        } else {
                            WalletWXCreditChangeAmountUI.this.JQn.JQb = 0;
                            WalletWXCreditChangeAmountUI.this.JQn = (l) WalletWXCreditChangeAmountUI.this.JQl.get(i2);
                            WalletWXCreditChangeAmountUI.this.JQn.JQb = 2;
                        }
                        WalletWXCreditChangeAmountUI.k(WalletWXCreditChangeAmountUI.this);
                        a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(72339);
                    }
                });
                d.a aVar = new d.a(this);
                aVar.aoO(R.string.iwt);
                aVar.hs(inflate);
                aVar.f(null);
                com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
                AppMethodBeat.o(72353);
                return hbn;
            case 2:
                View inflate2 = getLayoutInflater().inflate(R.layout.c9h, (ViewGroup) null);
                ListViewInScrollView listViewInScrollView2 = (ListViewInScrollView) inflate2.findViewById(R.id.h4);
                listViewInScrollView2.setAdapter((ListAdapter) this.JQC);
                listViewInScrollView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    /* class com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.AnonymousClass8 */

                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                        AppMethodBeat.i(72340);
                        b bVar = new b();
                        bVar.bm(adapterView);
                        bVar.bm(view);
                        bVar.pH(i2);
                        bVar.zo(j2);
                        a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                        WalletWXCreditChangeAmountUI.this.dismissDialog(2);
                        if (WalletWXCreditChangeAmountUI.this.JQq) {
                            if (i2 == 0) {
                                WalletWXCreditChangeAmountUI.this.JQm.yWF = "Y";
                            } else {
                                WalletWXCreditChangeAmountUI.this.JQm.yWF = "N";
                            }
                        } else if (i2 == 0) {
                            WalletWXCreditChangeAmountUI.this.JQn.yWF = "Y";
                        } else {
                            WalletWXCreditChangeAmountUI.this.JQn.yWF = "N";
                        }
                        WalletWXCreditChangeAmountUI.k(WalletWXCreditChangeAmountUI.this);
                        a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(72340);
                    }
                });
                d.a aVar2 = new d.a(this);
                aVar2.aoO(R.string.iwp);
                aVar2.hs(inflate2);
                aVar2.f(null);
                com.tencent.mm.ui.widget.a.d hbn2 = aVar2.hbn();
                AppMethodBeat.o(72353);
                return hbn2;
            case 3:
                String string = getString(R.string.iws);
                if (this.JQo > 0) {
                    string = getString(R.string.iwq, new Object[]{Integer.valueOf(this.JQo)});
                }
                com.tencent.mm.ui.widget.a.d a2 = h.a(this, string, (String) null, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.AnonymousClass9 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(72341);
                        com.tencent.mm.wallet_core.d by = com.tencent.mm.wallet_core.a.by(WalletWXCreditChangeAmountUI.this);
                        if (by != null) {
                            by.b(WalletWXCreditChangeAmountUI.this, WalletWXCreditChangeAmountUI.this.getInput());
                            AppMethodBeat.o(72341);
                            return;
                        }
                        WalletWXCreditChangeAmountUI.this.finish();
                        AppMethodBeat.o(72341);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI.AnonymousClass10 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(72342);
                        WalletWXCreditChangeAmountUI.this.showVKB();
                        AppMethodBeat.o(72342);
                    }
                });
                AppMethodBeat.o(72353);
                return a2;
            default:
                com.tencent.mm.ui.widget.a.d c2 = h.c(this, "", "", true);
                AppMethodBeat.o(72353);
                return c2;
        }
    }

    static /* synthetic */ void a(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        AppMethodBeat.i(72354);
        walletWXCreditChangeAmountUI.JQl.clear();
        if (walletWXCreditChangeAmountUI.JQp) {
            for (l lVar : walletWXCreditChangeAmountUI.JQk) {
                if (lVar.JQb != 2) {
                    walletWXCreditChangeAmountUI.JQl.add(lVar);
                }
            }
            AppMethodBeat.o(72354);
            return;
        }
        for (l lVar2 : walletWXCreditChangeAmountUI.JQk) {
            if (lVar2.JQb != 1) {
                walletWXCreditChangeAmountUI.JQl.add(lVar2);
            }
        }
        AppMethodBeat.o(72354);
    }

    static /* synthetic */ boolean b(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        AppMethodBeat.i(72355);
        if (walletWXCreditChangeAmountUI.JQm == null || walletWXCreditChangeAmountUI.JQn == null) {
            AppMethodBeat.o(72355);
            return false;
        } else if (walletWXCreditChangeAmountUI.JQx.getVisibility() == 0 && Util.isNullOrNil(walletWXCreditChangeAmountUI.JQx.getText().toString())) {
            AppMethodBeat.o(72355);
            return false;
        } else if (walletWXCreditChangeAmountUI.JQy.getVisibility() == 0 && Util.isNullOrNil(walletWXCreditChangeAmountUI.JQy.getText().toString())) {
            AppMethodBeat.o(72355);
            return false;
        } else if (walletWXCreditChangeAmountUI.JQv.getVisibility() == 0 && Util.isNullOrNil(walletWXCreditChangeAmountUI.JQv.getText().toString())) {
            AppMethodBeat.o(72355);
            return false;
        } else if (walletWXCreditChangeAmountUI.JQz.getVisibility() == 0 && Util.isNullOrNil(walletWXCreditChangeAmountUI.JQz.getText().toString())) {
            AppMethodBeat.o(72355);
            return false;
        } else if (walletWXCreditChangeAmountUI.JQA.getVisibility() == 0 && Util.isNullOrNil(walletWXCreditChangeAmountUI.JQA.getText().toString())) {
            AppMethodBeat.o(72355);
            return false;
        } else if (walletWXCreditChangeAmountUI.JQw.getVisibility() != 0 || !Util.isNullOrNil(walletWXCreditChangeAmountUI.JQw.getText().toString())) {
            AppMethodBeat.o(72355);
            return true;
        } else {
            AppMethodBeat.o(72355);
            return false;
        }
    }
}
