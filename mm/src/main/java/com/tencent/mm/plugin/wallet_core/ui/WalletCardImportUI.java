package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;
import java.util.LinkedList;

public class WalletCardImportUI extends WalletBaseUI implements TextView.OnEditorActionListener, WalletFormView.a {
    private static final String[] Ify = {"ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "HSBC_DEBIT"};
    private Orders CwO = null;
    private Authen HFI = new Authen();
    private WalletFormView HJY;
    private int HKd = 1;
    private ElementQuery HRy = new ElementQuery();
    private WalletFormView Idq;
    private WalletFormView IeA;
    private WalletFormView IeB;
    private WalletFormView IeC;
    private WalletFormView IeD;
    private WalletFormView IeE;
    private WalletFormView IeG = null;
    private WalletFormView IeH;
    private CheckBox IeL;
    private String IeM;
    private WalletFormView IeY;
    private WalletFormView Iek;
    private WalletFormView Iel;
    private WalletFormView Ien;
    private WalletFormView Ieo;
    private WalletFormView Iey;
    private WalletFormView Iez;
    private MMScrollView IfA;
    private Bankcard IfB = null;
    private CheckBox IfC;
    private BaseAdapter IfD = new BaseAdapter() {
        /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.AnonymousClass9 */

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(70840);
            Integer uH = uH(i2);
            AppMethodBeat.o(70840);
            return uH;
        }

        public final int getCount() {
            AppMethodBeat.i(70837);
            if (WalletCardImportUI.this.HRy.fQs() != null) {
                int size = WalletCardImportUI.this.HRy.fQs().size();
                AppMethodBeat.o(70837);
                return size;
            }
            AppMethodBeat.o(70837);
            return 0;
        }

        private Integer uH(int i2) {
            AppMethodBeat.i(70838);
            Integer num = WalletCardImportUI.this.HRy.fQs().get(i2);
            AppMethodBeat.o(70838);
            return num;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(70839);
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(WalletCardImportUI.this, R.layout.c9i, null);
            checkedTextView.setText(t.fQQ().av(WalletCardImportUI.this, uH(i2).intValue()));
            if (WalletCardImportUI.this.HKd == uH(i2).intValue()) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            checkedTextView.setBackgroundResource(R.drawable.qa);
            AppMethodBeat.o(70839);
            return checkedTextView;
        }
    };
    private TextView Ifz;
    private Button gxv;
    private Dialog mDialog = null;
    private MMHandler mHandler = new MMHandler();
    private PayInfo mPayInfo = null;
    private String yMR;
    private String yMS;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletCardImportUI() {
        AppMethodBeat.i(70841);
        AppMethodBeat.o(70841);
    }

    static /* synthetic */ boolean d(WalletCardImportUI walletCardImportUI) {
        AppMethodBeat.i(70855);
        boolean bqg = walletCardImportUI.bqg();
        AppMethodBeat.o(70855);
        return bqg;
    }

    static /* synthetic */ void e(WalletCardImportUI walletCardImportUI) {
        AppMethodBeat.i(70856);
        walletCardImportUI.fSH();
        AppMethodBeat.o(70856);
    }

    static /* synthetic */ void i(WalletCardImportUI walletCardImportUI) {
        AppMethodBeat.i(70858);
        walletCardImportUI.updateView();
        AppMethodBeat.o(70858);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(70842);
        super.onCreate(bundle);
        setMMTitle(R.string.ic_);
        this.HRy = (ElementQuery) getInput().getParcelable("elemt_query");
        this.CwO = (Orders) getInput().getParcelable("key_orders");
        this.mPayInfo = (PayInfo) getInput().getParcelable("key_pay_info");
        this.IfB = (Bankcard) getInput().getParcelable("key_import_bankcard");
        if (this.mPayInfo == null) {
            this.mPayInfo = new PayInfo();
        }
        Log.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.mPayInfo);
        initView();
        this.IfA.pageScroll(33);
        f.b(this, getInput(), 3);
        AppMethodBeat.o(70842);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(70843);
        this.IeH = (WalletFormView) findViewById(R.id.jet);
        a.b(this.IeH);
        this.Ieo = (WalletFormView) findViewById(R.id.fgm);
        a.c(this, this.Ieo);
        this.Idq = (WalletFormView) findViewById(R.id.fte);
        a.e(this, this.Idq);
        this.Ien = (WalletFormView) findViewById(R.id.jff);
        this.HJY = (WalletFormView) findViewById(R.id.duk);
        a.d(this.HJY);
        this.IeY = (WalletFormView) findViewById(R.id.jf2);
        this.Iel = (WalletFormView) findViewById(R.id.bk5);
        a.b(this, this.Iel);
        this.Iek = (WalletFormView) findViewById(R.id.bkj);
        a.a(this, this.Iek);
        this.Ifz = (TextView) findViewById(R.id.jhr);
        this.Iey = (WalletFormView) findViewById(R.id.d5d);
        this.Iez = (WalletFormView) findViewById(R.id.e7w);
        this.IeA = (WalletFormView) findViewById(R.id.uj);
        this.IeB = (WalletFormView) findViewById(R.id.hb);
        this.IeC = (WalletFormView) findViewById(R.id.gaa);
        this.IeD = (WalletFormView) findViewById(R.id.gf_);
        this.IeE = (WalletFormView) findViewById(R.id.byt);
        a.e(this.IeE);
        this.IfC = (CheckBox) findViewById(R.id.id);
        this.IeL = (CheckBox) findViewById(R.id.ia);
        this.gxv = (Button) findViewById(R.id.fz0);
        this.IfA = (MMScrollView) findViewById(R.id.ji9);
        MMScrollView mMScrollView = this.IfA;
        mMScrollView.a(mMScrollView, mMScrollView);
        this.IfA.setOnSizeChangeListener(new MMScrollView.b() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.AnonymousClass1 */

            @Override // com.tencent.mm.wallet_core.ui.MMScrollView.b
            public final void ym(boolean z) {
                AppMethodBeat.i(70828);
                final int i2 = z ? 8 : 0;
                Log.d("MicroMsg.WalletCardElmentUI", "onSizeChanged : ".concat(String.valueOf(z)));
                WalletCardImportUI.this.mHandler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(70827);
                        if (i2 != WalletCardImportUI.this.Ifz.getVisibility()) {
                            WalletCardImportUI.this.Ifz.setVisibility(i2);
                        }
                        AppMethodBeat.o(70827);
                    }
                });
                AppMethodBeat.o(70828);
            }
        });
        this.Idq.setOnInputValidChangeListener(this);
        this.IeH.setOnInputValidChangeListener(this);
        this.Ien.setOnInputValidChangeListener(this);
        this.HJY.setOnInputValidChangeListener(this);
        this.Ieo.setOnInputValidChangeListener(this);
        this.Iel.setOnInputValidChangeListener(this);
        this.Iek.setOnInputValidChangeListener(this);
        this.Iey.setOnInputValidChangeListener(this);
        this.Iez.setOnInputValidChangeListener(this);
        this.IeA.setOnInputValidChangeListener(this);
        this.IeB.setOnInputValidChangeListener(this);
        this.IeC.setOnInputValidChangeListener(this);
        this.IeD.setOnInputValidChangeListener(this);
        this.IeE.setOnInputValidChangeListener(this);
        this.Idq.setOnEditorActionListener(this);
        this.IeH.setOnEditorActionListener(this);
        this.Ien.setOnEditorActionListener(this);
        this.HJY.setOnEditorActionListener(this);
        this.Ieo.setOnEditorActionListener(this);
        this.Iel.setOnEditorActionListener(this);
        this.Iek.setOnEditorActionListener(this);
        this.Iey.setOnEditorActionListener(this);
        this.Iez.setOnEditorActionListener(this);
        this.IeA.setOnEditorActionListener(this);
        this.IeB.setOnEditorActionListener(this);
        this.IeC.setOnEditorActionListener(this);
        this.IeD.setOnEditorActionListener(this);
        this.IeE.setOnEditorActionListener(this);
        this.IeY.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(70829);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Bundle bundle = new Bundle();
                bundle.putInt("key_support_bankcard", WalletCardImportUI.this.getInput().getInt("key_support_bankcard", 3));
                bundle.putString("key_bank_type", WalletCardImportUI.this.HRy.dDj);
                bundle.putInt("key_bankcard_type", WalletCardImportUI.this.HRy.HXl);
                com.tencent.mm.wallet_core.a.by(WalletCardImportUI.this).a(WalletCardImportUI.this, WalletCardSelectUI.class, bundle, 1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70829);
            }
        });
        this.Ien.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(70830);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletCardImportUI.this.showDialog(1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70830);
            }
        });
        this.IfC.setChecked(true);
        this.IfC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.AnonymousClass4 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(70831);
                WalletCardImportUI.d(WalletCardImportUI.this);
                AppMethodBeat.o(70831);
            }
        });
        this.IeL.setChecked(true);
        findViewById(R.id.i9).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(70833);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                linkedList.add(WalletCardImportUI.this.getString(R.string.i8v));
                linkedList2.add(0);
                if (WalletCardImportUI.this.HRy != null && WalletCardImportUI.this.HRy.HXD) {
                    linkedList.add(WalletCardImportUI.this.getString(R.string.i8t));
                    linkedList2.add(1);
                }
                h.a(WalletCardImportUI.this, "", linkedList, linkedList2, "", new h.e() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.AnonymousClass5.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.h.e
                    public final void cy(int i2, int i3) {
                        AppMethodBeat.i(70832);
                        Intent intent = new Intent();
                        switch (i2) {
                            case 0:
                                intent.putExtra("rawUrl", WalletCardImportUI.this.getString(R.string.i5i, new Object[]{LocaleUtil.getApplicationLanguage()}));
                                break;
                            case 1:
                                if (WalletCardImportUI.this.HRy != null) {
                                    intent.putExtra("rawUrl", WalletCardImportUI.this.getString(R.string.i5g, new Object[]{LocaleUtil.getApplicationLanguage(), WalletCardImportUI.this.HRy.dDj}));
                                    break;
                                }
                                break;
                        }
                        intent.putExtra("showShare", false);
                        com.tencent.mm.wallet_core.ui.f.aA(WalletCardImportUI.this.getContext(), intent);
                        AppMethodBeat.o(70832);
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70833);
            }
        });
        this.IeA.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(70834);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletCardImportUI.this.startActivityForResult(new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true), 2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70834);
            }
        });
        this.gxv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(70835);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletCardImportUI.e(WalletCardImportUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70835);
            }
        });
        updateView();
        bqg();
        AppMethodBeat.o(70843);
    }

    private void updateView() {
        WalletFormView walletFormView;
        WalletFormView walletFormView2;
        String string;
        AppMethodBeat.i(70844);
        if (this.IfB != null) {
            findViewById(R.id.jf1).setVisibility(0);
            if (!Util.isNullOrNil(getInput().getString("key_bank_username"))) {
                String string2 = getInput().getString("key_recommand_desc");
                if (Util.isNullOrNil(string2)) {
                    this.IeL.setText(getString(R.string.i_3, new Object[]{this.IfB.field_bankName}));
                } else {
                    this.IeL.setText(string2);
                }
                this.IeL.setVisibility(0);
            } else {
                this.IeL.setVisibility(8);
            }
            fSL();
            if (Util.isNullOrNil(this.IfB.field_bankcardTail) || !e(this.IeH, this.IfB.HVy)) {
                this.IeH.setVisibility(8);
                walletFormView = null;
                walletFormView2 = null;
            } else {
                WalletFormView walletFormView3 = this.IeH;
                walletFormView = this.IeH;
                walletFormView2 = walletFormView3;
            }
            if (this.IfB.fQd()) {
                string = getString(R.string.ibk);
            } else {
                string = getString(R.string.ic4);
            }
            if (Util.isNullOrNil(this.IfB.field_bankName) || !e(this.IeY, this.IfB.field_bankName + " " + string)) {
                this.IeY.setVisibility(8);
            } else {
                if (walletFormView2 == null) {
                    walletFormView2 = this.IeY;
                }
                walletFormView = this.IeY;
            }
            if (e(this.Idq, this.IfB.field_trueName)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.Idq;
                }
                walletFormView = this.Idq;
            }
            if (e(this.Ien, t.fQQ().av(getContext(), this.IfB.HUQ))) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.Ien;
                }
                walletFormView = this.Ien;
            }
            if (e(this.HJY, this.IfB.HVx)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.HJY;
                }
                walletFormView = this.HJY;
            }
            if (e(this.Ieo, this.IfB.field_mobile)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.Ieo;
                }
                walletFormView = this.Ieo;
            }
            if (e(this.Iel, this.IfB.HUS)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.Iel;
                }
                walletFormView = this.Iel;
            }
            if (e(this.Iek, this.IfB.HVz)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.Iek;
                }
                walletFormView = this.Iek;
            }
            walletFormView2.setBackgroundResource(R.drawable.qa);
            walletFormView.setBackgroundResource(R.drawable.qa);
            if (t.fQI().fRm()) {
                this.gxv.setText(R.string.i_e);
                AppMethodBeat.o(70844);
                return;
            }
            this.gxv.setText(R.string.i_c);
            AppMethodBeat.o(70844);
            return;
        }
        AppMethodBeat.o(70844);
    }

    private static boolean e(WalletFormView walletFormView, String str) {
        AppMethodBeat.i(70845);
        if (!Util.isNullOrNil(str)) {
            KeyListener keyListener = walletFormView.getKeyListener();
            walletFormView.setKeyListener(null);
            walletFormView.setEnabled(false);
            walletFormView.setClickable(false);
            walletFormView.setText(str);
            walletFormView.setKeyListener(keyListener);
            walletFormView.setVisibility(0);
            AppMethodBeat.o(70845);
            return true;
        }
        walletFormView.setVisibility(8);
        AppMethodBeat.o(70845);
        return false;
    }

    private void fSL() {
        AppMethodBeat.i(70846);
        this.Iey.setVisibility(8);
        this.Iez.setVisibility(8);
        this.IeA.setVisibility(8);
        this.IeB.setVisibility(8);
        this.IeC.setVisibility(8);
        this.IeD.setVisibility(8);
        this.IeE.setVisibility(8);
        AppMethodBeat.o(70846);
    }

    private void fSH() {
        String str;
        boolean z;
        AppMethodBeat.i(70847);
        if (bqg()) {
            f.fUi();
            this.HFI = new Authen();
            getInput().putBoolean("key_is_follow_bank_username", this.IeL.isChecked());
            if (this.IfB == null || Util.isNullOrNil(this.IfB.HVL)) {
                String string = getInput().getString("key_card_id");
                if (this.IeH.getVisibility() == 0) {
                    str = this.IeH.getText();
                } else {
                    str = string;
                }
                this.HFI.BDB = (PayInfo) getInput().getParcelable("key_pay_info");
                this.HFI.HUR = str;
                this.HFI.dDj = this.HRy.dDj;
                this.HFI.HUQ = this.HKd;
                this.HFI.HUO = getInput().getString("key_pwd1");
                if (!Util.isNullOrNil(this.Iel.getText())) {
                    this.HFI.HUS = this.Iel.getText();
                }
                this.HFI.HQc = this.Ieo.getText();
                this.HFI.HUV = this.Iey.getText();
                this.HFI.HUW = this.Iez.getText();
                this.HFI.country = this.IeM;
                this.HFI.fuJ = this.yMR;
                this.HFI.fuK = this.yMS;
                this.HFI.iUO = this.IeB.getText();
                this.HFI.ynV = this.IeC.getText();
                this.HFI.ksV = this.IeD.getText();
                this.HFI.fuD = this.IeE.getText();
                getInput().putString("key_mobile", com.tencent.mm.wallet_core.ui.f.bpt(this.HFI.HQc));
                Bundle input = getInput();
                if (this.HRy.HQg == 2) {
                    z = true;
                } else {
                    z = false;
                }
                input.putBoolean("key_is_oversea", z);
                this.HFI.HUP = this.HJY.getText();
                this.HFI.HTZ = this.Idq.getText();
                this.HFI.HUT = this.Iek.getText();
                Log.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.HFI.BDB + " elemt.bankcardTag : " + this.HRy.HQg);
            } else {
                this.HFI.HCy = this.IfB.HVL;
                this.HFI.ANo = this.IfB.field_bindSerial;
                this.HFI.dDj = this.IfB.field_bankcardType;
                this.HFI.HUQ = this.IfB.HUQ;
                this.HFI.HUO = getInput().getString("key_pwd1");
                this.HFI.token = getInput().getString("kreq_token");
            }
            com.tencent.mm.wallet_core.a.by(this);
            if (getNetController().r(this.HFI, this.CwO)) {
                Log.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
                AppMethodBeat.o(70847);
                return;
            }
            Log.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
        }
        AppMethodBeat.o(70847);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(70848);
        Log.d("MicroMsg.WalletCardElmentUI", " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            Bundle input = getInput();
            Log.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.mPayInfo);
            if (qVar instanceof ad) {
                input.putBoolean("intent_bind_end", true);
                com.tencent.mm.wallet_core.a.l(this, input);
                h.cD(this, getString(R.string.i7l));
                AppMethodBeat.o(70848);
                return true;
            }
            AppMethodBeat.o(70848);
            return false;
        }
        AppMethodBeat.o(70848);
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c8e;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(70849);
        Log.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:".concat(String.valueOf(i2)));
        if (i3 != -1) {
            AppMethodBeat.o(70849);
            return;
        }
        switch (i2) {
            case 1:
                this.HRy = (ElementQuery) intent.getParcelableExtra("elemt_query");
                updateView();
                break;
            case 2:
                String stringExtra = intent.getStringExtra("CountryName");
                String stringExtra2 = intent.getStringExtra("Country");
                this.IeM = stringExtra + "|" + stringExtra2;
                String stringExtra3 = intent.getStringExtra("ProviceName");
                String stringExtra4 = intent.getStringExtra("CityName");
                if (!Util.isNullOrNil(intent.getStringExtra("Contact_City"))) {
                    this.yMR = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                    this.yMS = stringExtra4 + "|" + intent.getStringExtra("Contact_City");
                    this.IeA.setText(stringExtra + " " + stringExtra4);
                } else if (!Util.isNullOrNil(intent.getStringExtra("Contact_Province"))) {
                    this.yMS = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                    this.IeA.setText(stringExtra + " " + stringExtra3);
                } else {
                    this.yMS = this.IeM;
                    this.IeA.setText(stringExtra);
                }
                if (!"US".equals(stringExtra2) && !"CA".equals(stringExtra2) && !this.HRy.HXy) {
                    this.IeD.setVisibility(8);
                    break;
                } else {
                    this.IeD.setVisibility(0);
                    break;
                }
                break;
        }
        bqg();
        AppMethodBeat.o(70849);
    }

    private boolean bqg() {
        boolean z;
        AppMethodBeat.i(70850);
        if (!this.IfC.isChecked()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.gxv.setEnabled(true);
            this.gxv.setClickable(true);
        } else {
            this.gxv.setEnabled(false);
            this.gxv.setClickable(false);
        }
        AppMethodBeat.o(70850);
        return z;
    }

    @Override // com.tencent.mm.wallet_core.ui.formview.WalletFormView.a
    public final void onInputValidChange(boolean z) {
        AppMethodBeat.i(70851);
        bqg();
        AppMethodBeat.o(70851);
    }

    public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(70852);
        Log.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : ".concat(String.valueOf(i2)));
        switch (i2) {
            case 5:
                if (this.IeG == null) {
                    fSH();
                } else if (!this.IeG.isEnabled() || this.IeG.isClickable() || !this.IeG.hhZ()) {
                    this.IeG.performClick();
                } else {
                    this.IeG.hic();
                }
                AppMethodBeat.o(70852);
                return true;
            default:
                if (this.IeG == null) {
                    fSH();
                }
                AppMethodBeat.o(70852);
                return false;
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean getCancelable() {
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(70853);
        if (this.mDialog != null && this.mDialog.isShowing()) {
            this.mDialog.dismiss();
            this.mDialog = null;
        }
        super.onDestroy();
        AppMethodBeat.o(70853);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public Dialog onCreateDialog(int i2) {
        AppMethodBeat.i(70854);
        switch (i2) {
            case 1:
                i iVar = new i(this, R.style.u1);
                iVar.setContentView(R.layout.c9h);
                ListView listView = (ListView) iVar.findViewById(R.id.h4);
                listView.setAdapter((ListAdapter) this.IfD);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.AnonymousClass8 */

                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                        AppMethodBeat.i(70836);
                        b bVar = new b();
                        bVar.bm(adapterView);
                        bVar.bm(view);
                        bVar.pH(i2);
                        bVar.zo(j2);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                        WalletCardImportUI.this.dismissDialog(1);
                        int intValue = WalletCardImportUI.this.HRy.fQs().get(i2).intValue();
                        if (WalletCardImportUI.this.HKd != intValue) {
                            WalletCardImportUI.this.HKd = intValue;
                            WalletCardImportUI.this.Ien.setText(((CheckedTextView) view).getText().toString());
                            WalletCardImportUI.b(WalletCardImportUI.this.HJY, WalletCardImportUI.this.HKd);
                            WalletCardImportUI.this.HJY.eIj();
                            WalletCardImportUI.i(WalletCardImportUI.this);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(70836);
                    }
                });
                AppMethodBeat.o(70854);
                return iVar;
            default:
                Dialog onCreateDialog = super.onCreateDialog(i2);
                AppMethodBeat.o(70854);
                return onCreateDialog;
        }
    }

    static /* synthetic */ void b(WalletFormView walletFormView, int i2) {
        AppMethodBeat.i(70857);
        com.tencent.mm.wallet_core.ui.formview.a.b logicDelegate = walletFormView.getLogicDelegate();
        if (logicDelegate instanceof a.C2170a) {
            ((a.C2170a) logicDelegate).aqn(i2);
        }
        AppMethodBeat.o(70857);
    }
}
