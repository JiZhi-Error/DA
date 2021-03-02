package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.wallet_core.c.f;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView;
import com.tencent.mm.plugin.wallet_core.utils.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.sortview.d;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class WalletBankCardSelectUI extends WalletBaseUI {
    private static final String TAG = "WalletBankCardSelectUI";
    protected List<ElementQuery> bankcardList;
    private List<d> bankcardQueryList;
    public List<ElementQuery> bankcardTypeList;
    private boolean isSearchMode = false;
    protected a mBankCardComparator = new a((byte) 0);
    protected BankCardSelectSortView mBankCardSelectSortView;
    private s mSearchViewHelper;
    private List<d> origBankcardList;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletBankCardSelectUI() {
        AppMethodBeat.i(70699);
        AppMethodBeat.o(70699);
    }

    static /* synthetic */ void access$200(WalletBankCardSelectUI walletBankCardSelectUI, Map map) {
        AppMethodBeat.i(70708);
        walletBankCardSelectUI.refreshData(map);
        AppMethodBeat.o(70708);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(70700);
        super.onCreate(bundle);
        setMMTitle(R.string.ac2);
        this.bankcardList = t.fQQ().HQe;
        initView();
        fetchData();
        addSearchMenu(true, this.mSearchViewHelper);
        AppMethodBeat.o(70700);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(70701);
        this.mBankCardSelectSortView = (BankCardSelectSortView) findViewById(R.id.a1y);
        this.mBankCardSelectSortView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(70690);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBankCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                WalletBankCardSelectUI.this.onItemSelect(((d) adapterView.getAdapter().getItem(i2)).data, i2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBankCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(70690);
            }
        });
        this.mSearchViewHelper = new s((byte) 0);
        this.mSearchViewHelper.Qwi = new s.b() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnz() {
                AppMethodBeat.i(70691);
                WalletBankCardSelectUI.this.isSearchMode = true;
                WalletBankCardSelectUI.this.mBankCardSelectSortView.BF(false);
                WalletBankCardSelectUI.this.mBankCardSelectSortView.setMode(1);
                AppMethodBeat.o(70691);
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bny() {
                AppMethodBeat.i(70692);
                WalletBankCardSelectUI.this.isSearchMode = false;
                WalletBankCardSelectUI.this.hideVKB();
                WalletBankCardSelectUI.this.mBankCardSelectSortView.BF(true);
                WalletBankCardSelectUI.this.mBankCardSelectSortView.setMode(0);
                AppMethodBeat.o(70692);
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void SO(String str) {
                AppMethodBeat.i(70693);
                Log.d(WalletBankCardSelectUI.TAG, "search text: %s", str);
                WalletBankCardSelectUI.this.mBankCardSelectSortView.bmm(str);
                AppMethodBeat.o(70693);
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final boolean SN(String str) {
                AppMethodBeat.i(70694);
                WalletBankCardSelectUI.this.hideVKB();
                AppMethodBeat.o(70694);
                return false;
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnA() {
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnB() {
            }
        };
        AppMethodBeat.o(70701);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c86;
    }

    /* access modifiers changed from: protected */
    public void onItemSelect(Object obj, int i2) {
        AppMethodBeat.i(70702);
        BankCardSelectSortView.a aVar = (BankCardSelectSortView.a) obj;
        if (aVar != null) {
            hideVKB();
            Intent intent = new Intent();
            intent.putExtra("bank_name", aVar.AOj);
            Log.i(TAG, "item bank: %s", aVar.AOj);
            setResult(-1, intent);
            finish();
        }
        AppMethodBeat.o(70702);
    }

    private boolean containByBankName(ElementQuery elementQuery) {
        AppMethodBeat.i(70703);
        for (d dVar : this.origBankcardList) {
            BankCardSelectSortView.a aVar = (BankCardSelectSortView.a) dVar.data;
            if (!Util.isNullOrNil(elementQuery.ynT) && elementQuery.ynT.equals(aVar.AOj)) {
                AppMethodBeat.o(70703);
                return true;
            }
        }
        AppMethodBeat.o(70703);
        return false;
    }

    public void fetchData() {
        AppMethodBeat.i(70704);
        this.origBankcardList = new ArrayList();
        refreshData(null);
        com.tencent.mm.plugin.wallet_core.utils.a aVar = new com.tencent.mm.plugin.wallet_core.utils.a();
        LinkedList linkedList = new LinkedList();
        if (this.bankcardList != null) {
            for (ElementQuery elementQuery : this.bankcardList) {
                Bankcard bankcard = new Bankcard();
                bankcard.field_bankName = elementQuery.ynT;
                bankcard.field_bankcardType = elementQuery.dDj;
                linkedList.add(bankcard);
            }
        }
        getContext();
        AnonymousClass3 r0 = new a.AbstractC1923a() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.wallet_core.utils.a.AbstractC1923a
            public final void bc(Map<String, e> map) {
                AppMethodBeat.i(70695);
                Log.i(WalletBankCardSelectUI.TAG, "get logo callback: %s", Integer.valueOf(map.size()));
                WalletBankCardSelectUI.access$200(WalletBankCardSelectUI.this, map);
                AppMethodBeat.o(70695);
            }
        };
        HashMap hashMap = new HashMap();
        if (linkedList.isEmpty()) {
            Log.w("MicroMsg.BankcardLogoHelper", "req is null");
            r0.bc(hashMap);
            AppMethodBeat.o(70704);
            return;
        }
        g.en(linkedList).d(new com.tencent.mm.vending.c.a<Object, List<Bankcard>>() {
            /* class com.tencent.mm.plugin.wallet_core.utils.a.AnonymousClass9 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(List<Bankcard> list) {
                AppMethodBeat.i(71623);
                Object ie = ie(list);
                AppMethodBeat.o(71623);
                return ie;
            }

            private Object ie(List<Bankcard> list) {
                AppMethodBeat.i(71622);
                if (list != null && list.size() > 0) {
                    int size = list.size();
                    a.this.Iow = new LinkedList<>();
                    for (int i2 = 0; i2 < size; i2++) {
                        Bankcard bankcard = list.get(i2);
                        if (bankcard.fQb()) {
                            Log.i("MicroMsg.BankcardLogoHelper", "ignore balance!!");
                        } else {
                            a.this.Iow.add(bankcard.field_bankcardType);
                        }
                    }
                    if (a.this.Iow.size() > 0) {
                        Log.i("MicroMsg.BankcardLogoHelper", "need fetch bank logo, %s", Integer.valueOf(a.this.Iow.size()));
                        final com.tencent.mm.vending.g.b hdx = g.hdx();
                        f fVar = new f(a.this.Iow);
                        com.tencent.mm.kernel.g.aAi();
                        com.tencent.mm.kernel.g.aAg().hqi.a(1650, new i() {
                            /* class com.tencent.mm.plugin.wallet_core.utils.a.AnonymousClass9.AnonymousClass1 */

                            @Override // com.tencent.mm.ak.i
                            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                                AppMethodBeat.i(71621);
                                com.tencent.mm.kernel.g.aAi();
                                com.tencent.mm.kernel.g.aAg().hqi.b(1650, this);
                                a.this.Iow = null;
                                g.a(hdx, new Object[0]);
                                AppMethodBeat.o(71621);
                            }
                        });
                        com.tencent.mm.kernel.g.aAi();
                        com.tencent.mm.kernel.g.aAg().hqi.a(fVar, 0);
                        hdx.hdw();
                    }
                }
                Void r0 = QZL;
                AppMethodBeat.o(71622);
                return r0;
            }
        }).d(new com.tencent.mm.vending.c.a<Object, Object>(linkedList, hashMap, r0) {
            /* class com.tencent.mm.plugin.wallet_core.utils.a.AnonymousClass8 */
            final /* synthetic */ List HGM;
            final /* synthetic */ Map IoC;
            final /* synthetic */ AbstractC1923a IoD;

            {
                this.HGM = r2;
                this.IoC = r3;
                this.IoD = r4;
            }

            @Override // com.tencent.mm.vending.c.a
            public final Object call(Object obj) {
                AppMethodBeat.i(71620);
                for (Bankcard bankcard : this.HGM) {
                    this.IoC.put(bankcard.field_bankcardType, com.tencent.mm.plugin.wallet_core.d.b.aVz(bankcard.field_bankcardType));
                }
                if (this.IoD != null) {
                    this.IoD.bc(this.IoC);
                }
                Void r0 = QZL;
                AppMethodBeat.o(71620);
                return r0;
            }
        });
        AppMethodBeat.o(70704);
    }

    private void refreshData(Map<String, e> map) {
        e eVar;
        AppMethodBeat.i(70705);
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(map != null);
        Log.d(TAG, "refresh data: %s", objArr);
        this.origBankcardList.clear();
        if (this.bankcardList == null || this.bankcardList.isEmpty()) {
            Log.w(TAG, "bankcardlist is null");
            AppMethodBeat.o(70705);
            return;
        }
        for (ElementQuery elementQuery : this.bankcardList) {
            if (!containByBankName(elementQuery)) {
                d dVar = new d();
                BankCardSelectSortView.a aVar = new BankCardSelectSortView.a();
                aVar.AOj = elementQuery.ynT;
                if (!(map == null || (eVar = map.get(elementQuery.dDj)) == null)) {
                    aVar.icon = eVar.AAU;
                    aVar.ImL = eVar.HWe;
                    aVar.pinyin = eVar.pinyin;
                }
                if (!Util.isNullOrNil(aVar.pinyin)) {
                    Log.d(TAG, "have pinyin：%s", aVar.pinyin);
                } else {
                    aVar.pinyin = getFullPY(aVar.AOj, "#", "_", true);
                }
                dVar.Pae = new StringBuilder().append(aVar.pinyin.toUpperCase().charAt(0)).toString();
                dVar.data = aVar;
                this.origBankcardList.add(dVar);
            }
        }
        Collections.sort(this.origBankcardList, this.mBankCardComparator);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(70696);
                WalletBankCardSelectUI.this.mBankCardSelectSortView.hy(WalletBankCardSelectUI.this.origBankcardList);
                AppMethodBeat.o(70696);
            }
        });
        AppMethodBeat.o(70705);
    }

    public static char getAlpha(String str, char c2, boolean z) {
        AppMethodBeat.i(70706);
        char charAt = getFullPY(str, String.valueOf(c2), "_", z).charAt(0);
        AppMethodBeat.o(70706);
        return charAt;
    }

    public static String getFullPY(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(70707);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(70707);
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            String x = SpellMap.x(str.charAt(i2));
            if (!Util.isNullOrNil(x)) {
                if (z) {
                    sb.append(x.toUpperCase());
                } else {
                    sb.append(x);
                }
                if (i2 != length - 1) {
                    sb.append(str3);
                }
            }
        }
        String sb2 = sb.toString();
        Log.d(TAG, "full py: %s", sb2);
        if (!Util.isNullOrNil(sb2)) {
            AppMethodBeat.o(70707);
            return sb2;
        }
        AppMethodBeat.o(70707);
        return str2;
    }

    /* access modifiers changed from: package-private */
    public static class a implements Comparator<d> {
        private Collator Idb;

        private a() {
            AppMethodBeat.i(70697);
            this.Idb = Collator.getInstance(Locale.getDefault());
            AppMethodBeat.o(70697);
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(d dVar, d dVar2) {
            String fullPY;
            String fullPY2;
            AppMethodBeat.i(70698);
            d dVar3 = dVar;
            d dVar4 = dVar2;
            if (!(dVar3 == null && dVar4 == null)) {
                if (dVar3 == null) {
                    AppMethodBeat.o(70698);
                    return -1;
                } else if (dVar4 == null) {
                    AppMethodBeat.o(70698);
                    return 1;
                } else {
                    BankCardSelectSortView.a aVar = (BankCardSelectSortView.a) dVar3.data;
                    BankCardSelectSortView.a aVar2 = (BankCardSelectSortView.a) dVar4.data;
                    if (!Util.isNullOrNil(aVar.pinyin)) {
                        fullPY = aVar.pinyin.toUpperCase();
                    } else {
                        Log.e(WalletBankCardSelectUI.TAG, "should not go here");
                        fullPY = WalletBankCardSelectUI.getFullPY(aVar.AOj, "#", "_", true);
                    }
                    if (!Util.isNullOrNil(aVar2.pinyin)) {
                        fullPY2 = aVar2.pinyin.toUpperCase();
                    } else {
                        fullPY2 = WalletBankCardSelectUI.getFullPY(aVar2.AOj, "#", "_", true);
                    }
                    if (fullPY.equals("#")) {
                        AppMethodBeat.o(70698);
                        return 1;
                    } else if (fullPY2.equals("#")) {
                        AppMethodBeat.o(70698);
                        return -1;
                    } else {
                        int min = Math.min(fullPY.length(), fullPY2.length());
                        for (int i2 = 0; i2 < min; i2++) {
                            char charAt = fullPY.charAt(i2);
                            char charAt2 = fullPY2.charAt(i2);
                            if (charAt == '_' && charAt2 == '_') {
                                int compare = this.Idb.compare(aVar.AOj, aVar2.AOj);
                                AppMethodBeat.o(70698);
                                return compare;
                            } else if (charAt != charAt2) {
                                if (charAt == '_') {
                                    AppMethodBeat.o(70698);
                                    return -1;
                                } else if (charAt2 == '_') {
                                    AppMethodBeat.o(70698);
                                    return 1;
                                } else if (charAt < charAt2) {
                                    AppMethodBeat.o(70698);
                                    return -1;
                                } else {
                                    AppMethodBeat.o(70698);
                                    return 1;
                                }
                            }
                        }
                        if (fullPY.length() > min) {
                            AppMethodBeat.o(70698);
                            return 1;
                        } else if (fullPY2.length() > min) {
                            AppMethodBeat.o(70698);
                            return -1;
                        }
                    }
                }
            }
            AppMethodBeat.o(70698);
            return 0;
        }
    }
}
