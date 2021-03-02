package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aw.b;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.tools.s;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CountryCodeUI extends MMActivity {
    private VerticalScrollBar.a PTg;
    private c Qpt;
    private VerticalScrollBar Qpu;
    private String[] Qpv = null;
    private String countryCode;
    private s gzP;
    private String jbZ;
    private String kdi = "";
    private String klq;
    private List<b.a> list;
    private String title = null;
    private boolean yuQ = false;
    private ListView yvg;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39000);
        super.onCreate(bundle);
        this.jbZ = Util.nullAs(getIntent().getStringExtra("country_name"), "");
        this.countryCode = Util.nullAs(getIntent().getStringExtra("couttry_code"), "");
        this.klq = Util.nullAs(getIntent().getStringExtra("iso_code"), "");
        this.yuQ = getIntent().getBooleanExtra("CountryCodeUI_isShowCountryCode", true);
        this.Qpv = getIntent().getStringArrayExtra("exclude_countries_iso");
        this.title = getIntent().getStringExtra("ui_title");
        initView();
        AppMethodBeat.o(39000);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        AppMethodBeat.i(39001);
        if (LocaleUtil.isTraditionalChineseAppLang()) {
            AppMethodBeat.o(39001);
            return R.layout.ym;
        }
        AppMethodBeat.o(39001);
        return R.layout.yl;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(39002);
        super.onPause();
        if (this.gzP != null) {
            this.gzP.gXP();
        }
        AppMethodBeat.o(39002);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        AppMethodBeat.i(39003);
        if (!Util.isNullOrNil(this.title)) {
            setMMTitle(this.title);
        } else {
            setMMTitle(R.string.g5);
        }
        this.list = b.Pf(getString(R.string.bj8));
        if (this.Qpv != null && this.Qpv.length > 0) {
            for (int size = this.list.size() - 1; size >= 0; size--) {
                String str = this.list.get(size).jbX;
                String[] strArr = this.Qpv;
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    } else if (strArr[i2].equals(str)) {
                        Log.i("MicroMsg.CountryCodeUI", "exclude country: %s", str);
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    this.list.remove(size);
                }
            }
        }
        if (!LocaleUtil.isTraditionalChineseAppLang()) {
            Collections.sort(this.list, new Comparator<b.a>() {
                /* class com.tencent.mm.ui.tools.CountryCodeUI.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(b.a aVar, b.a aVar2) {
                    AppMethodBeat.i(38994);
                    int compareTo = aVar.jca.compareTo(aVar2.jca);
                    AppMethodBeat.o(38994);
                    return compareTo;
                }
            });
        } else {
            Collections.sort(this.list, new Comparator<b.a>() {
                /* class com.tencent.mm.ui.tools.CountryCodeUI.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* bridge */ /* synthetic */ int compare(b.a aVar, b.a aVar2) {
                    return aVar.jcb - aVar2.jcb;
                }
            });
        }
        this.gzP = new s((byte) 0);
        this.gzP.Qwi = new s.b() {
            /* class com.tencent.mm.ui.tools.CountryCodeUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.tools.s.b
            public final void SO(String str) {
                AppMethodBeat.i(38995);
                CountryCodeUI.this.kdi = str;
                CountryCodeUI.a(CountryCodeUI.this);
                AppMethodBeat.o(38995);
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bny() {
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnz() {
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final boolean SN(String str) {
                return false;
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnA() {
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnB() {
            }
        };
        addSearchMenu(true, this.gzP);
        this.yvg = (ListView) findViewById(R.id.h4);
        this.Qpt = new c(this, this.list);
        this.Qpt.yuQ = this.yuQ;
        this.yvg.setAdapter((ListAdapter) this.Qpt);
        this.yvg.setVisibility(0);
        this.Qpu = (VerticalScrollBar) findViewById(R.id.hl);
        if (!LocaleUtil.isTraditionalChineseAppLang()) {
            this.PTg = new VerticalScrollBar.a() {
                /* class com.tencent.mm.ui.tools.CountryCodeUI.AnonymousClass4 */

                @Override // com.tencent.mm.ui.base.VerticalScrollBar.a
                public final void DP(String str) {
                    AppMethodBeat.i(38996);
                    char charAt = str.charAt(0);
                    if (CountryCodeUI.this.getString(R.string.gf5).equals(str)) {
                        CountryCodeUI.this.yvg.setSelection(0);
                        AppMethodBeat.o(38996);
                        return;
                    }
                    int[] iArr = CountryCodeUI.this.Qpt.yuP;
                    if (iArr == null) {
                        AppMethodBeat.o(38996);
                        return;
                    }
                    for (int i2 = 0; i2 < iArr.length; i2++) {
                        if (iArr[i2] == charAt) {
                            CountryCodeUI.this.yvg.setSelection(i2 + CountryCodeUI.this.yvg.getHeaderViewsCount());
                            AppMethodBeat.o(38996);
                            return;
                        }
                    }
                    AppMethodBeat.o(38996);
                }
            };
        } else {
            this.PTg = new VerticalScrollBar.a() {
                /* class com.tencent.mm.ui.tools.CountryCodeUI.AnonymousClass5 */

                @Override // com.tencent.mm.ui.base.VerticalScrollBar.a
                public final void DP(String str) {
                    AppMethodBeat.i(38997);
                    if (CountryCodeUI.this.getString(R.string.gf5).equals(str)) {
                        CountryCodeUI.this.yvg.setSelection(0);
                        AppMethodBeat.o(38997);
                        return;
                    }
                    int intValue = Integer.decode(str.substring(0, str.length() - 1)).intValue();
                    int[] iArr = CountryCodeUI.this.Qpt.yuP;
                    if (iArr == null) {
                        AppMethodBeat.o(38997);
                        return;
                    }
                    for (int i2 = 0; i2 < iArr.length; i2++) {
                        if (iArr[i2] == intValue) {
                            CountryCodeUI.this.yvg.setSelection(i2 + CountryCodeUI.this.yvg.getHeaderViewsCount());
                            AppMethodBeat.o(38997);
                            return;
                        }
                    }
                    AppMethodBeat.o(38997);
                }
            };
        }
        this.Qpu.setOnScrollBarTouchListener(this.PTg);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.tools.CountryCodeUI.AnonymousClass6 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(38998);
                CountryCodeUI.this.hideVKB();
                Intent intent = new Intent();
                intent.putExtra("country_name", CountryCodeUI.this.jbZ);
                intent.putExtra("couttry_code", CountryCodeUI.this.countryCode);
                intent.putExtra("iso_code", CountryCodeUI.this.klq);
                CountryCodeUI.this.setResult(100, intent);
                CountryCodeUI.this.finish();
                AppMethodBeat.o(38998);
                return true;
            }
        });
        this.yvg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.ui.tools.CountryCodeUI.AnonymousClass7 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(38999);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/ui/tools/CountryCodeUI$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                Intent intent = new Intent();
                if (i2 >= CountryCodeUI.this.yvg.getHeaderViewsCount()) {
                    b.a aVar = (b.a) CountryCodeUI.this.Qpt.getItem(i2 - CountryCodeUI.this.yvg.getHeaderViewsCount());
                    intent.putExtra("country_name", aVar.jbZ);
                    intent.putExtra("couttry_code", aVar.jbY);
                    intent.putExtra("iso_code", aVar.jbX);
                    CountryCodeUI.this.setResult(100, intent);
                }
                CountryCodeUI.this.finish();
                a.a(this, "com/tencent/mm/ui/tools/CountryCodeUI$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(38999);
            }
        });
        AppMethodBeat.o(39003);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(39004);
        if (i2 == 4) {
            Intent intent = new Intent();
            intent.putExtra("country_name", this.jbZ);
            intent.putExtra("couttry_code", this.countryCode);
            intent.putExtra("iso_code", this.klq);
            setResult(100, intent);
            finish();
            AppMethodBeat.o(39004);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(39004);
        return onKeyUp;
    }

    static /* synthetic */ void a(CountryCodeUI countryCodeUI) {
        AppMethodBeat.i(39005);
        if (countryCodeUI.Qpt != null) {
            countryCodeUI.Qpt.SM(countryCodeUI.kdi);
        }
        AppMethodBeat.o(39005);
    }
}
