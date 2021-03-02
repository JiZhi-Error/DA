package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.ipcall.a.b;
import com.tencent.mm.plugin.ipcall.model.c;
import com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeScrollbar;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@a(3)
public class IPCallCountryCodeSelectUI extends MMActivity {
    private String countryCode;
    private s gzP;
    private String jbZ;
    private String kdi = "";
    private List<a> list;
    public LinearLayout yuH;
    private boolean yuQ = false;
    private ListView yvg;
    private f yvh;
    private IPCallCountryCodeScrollbar yvi;
    private IPCallCountryCodeScrollbar.a yvj;
    private boolean yvk = false;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25736);
        super.onCreate(bundle);
        this.list = new ArrayList();
        this.jbZ = Util.nullAs(getIntent().getStringExtra("country_name"), "");
        this.countryCode = Util.nullAs(getIntent().getStringExtra("couttry_code"), "");
        this.yuQ = getIntent().getBooleanExtra("CountryCodeUI_isShowCountryCode", false);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeSelectUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25729);
                IPCallCountryCodeSelectUI.this.finish();
                AppMethodBeat.o(25729);
                return false;
            }
        });
        initView();
        AppMethodBeat.o(25736);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(25737);
        super.finish();
        overridePendingTransition(-1, R.anim.f6do);
        AppMethodBeat.o(25737);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.awk;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(25738);
        super.onPause();
        if (this.gzP != null) {
            this.gzP.gXP();
        }
        AppMethodBeat.o(25738);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        int i2;
        AppMethodBeat.i(25739);
        setMMTitle(R.string.g5);
        this.gzP = new s((byte) 0);
        this.gzP.Qwi = new s.b() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeSelectUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.tools.s.b
            public final void SO(String str) {
                AppMethodBeat.i(25730);
                IPCallCountryCodeSelectUI.this.kdi = str;
                IPCallCountryCodeSelectUI.a(IPCallCountryCodeSelectUI.this);
                AppMethodBeat.o(25730);
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bny() {
                AppMethodBeat.i(25731);
                IPCallCountryCodeSelectUI.this.kdi = "";
                IPCallCountryCodeSelectUI.a(IPCallCountryCodeSelectUI.this);
                AppMethodBeat.o(25731);
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
        this.yvi = (IPCallCountryCodeScrollbar) findViewById(R.id.hl);
        long currentTimeMillis = System.currentTimeMillis();
        int i3 = 0;
        for (Integer num : c.ead().eag()) {
            int intValue = num.intValue();
            if (i3 >= 5) {
                break;
            }
            String aCv = com.tencent.mm.plugin.ipcall.a.a.aCv(String.valueOf(intValue));
            if (Util.isNullOrNil(aCv) || c.ead().OY(intValue)) {
                i2 = i3;
            } else {
                this.list.add(new a(aCv, String.valueOf(intValue), 0, AppEventsConstants.EVENT_PARAM_VALUE_NO));
                i2 = i3 + 1;
            }
            i3 = i2;
        }
        if (i3 > 0) {
            this.yvk = true;
        }
        if (LocaleUtil.isChineseAppLang()) {
            for (Map.Entry<String, b> entry : com.tencent.mm.plugin.ipcall.a.a.ebJ().entrySet()) {
                entry.getKey();
                b value = entry.getValue();
                String str = value.yAg;
                if (str != null && !"".equals(str.trim())) {
                    char[] charArray = str.toCharArray();
                    StringBuffer stringBuffer = new StringBuffer();
                    int length = charArray.length;
                    for (int i4 = 0; i4 < length; i4++) {
                        String x = SpellMap.x(charArray[i4]);
                        if (!Util.isNullOrNil(x)) {
                            stringBuffer.append(x);
                        } else {
                            stringBuffer.append(charArray[i4]);
                        }
                    }
                    str = stringBuffer.toString();
                }
                String upperCase = str.toUpperCase();
                if (Util.isNullOrNil(upperCase)) {
                    upperCase = " ";
                }
                if (!c.ead().OY(Util.getInt(value.yAf, 0))) {
                    this.list.add(new a(value.yAg, value.yAf, upperCase.charAt(0), upperCase));
                }
            }
        } else {
            for (Map.Entry<String, b> entry2 : com.tencent.mm.plugin.ipcall.a.a.ebJ().entrySet()) {
                entry2.getKey();
                b value2 = entry2.getValue();
                String upperCase2 = value2.yAg.toUpperCase();
                if (Util.isNullOrNil(upperCase2)) {
                    upperCase2 = " ";
                }
                if (!c.ead().OY(Util.getInt(value2.yAf, 0))) {
                    this.list.add(new a(value2.yAg, value2.yAf, upperCase2.charAt(0), upperCase2));
                }
            }
        }
        Collections.sort(this.list, new Comparator<a>() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeSelectUI.AnonymousClass6 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(a aVar, a aVar2) {
                AppMethodBeat.i(25735);
                int compareTo = aVar.jca.compareTo(aVar2.jca);
                AppMethodBeat.o(25735);
                return compareTo;
            }
        });
        for (a aVar : this.list) {
            int ebc = aVar.ebc();
            if (ebc != 0) {
                this.yvi.aCk(String.valueOf((char) ebc));
            }
        }
        Log.d("MicroMsg.IPCallCountryCodeSelectUI", "initCountryCode used: %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        this.yuH = (LinearLayout) findViewById(R.id.hs);
        this.yvg = (ListView) findViewById(R.id.h4);
        this.yvh = new f(this, this.list);
        this.yvh.yuQ = this.yuQ;
        this.yvh.yuR = this.yvk;
        this.yvg.setAdapter((ListAdapter) this.yvh);
        this.yvg.setVisibility(0);
        this.yvj = new IPCallCountryCodeScrollbar.a() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeSelectUI.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeScrollbar.a
            public final void DP(String str) {
                AppMethodBeat.i(25732);
                char charAt = str.charAt(0);
                if ("↑".equals(str)) {
                    IPCallCountryCodeSelectUI.this.yvg.setSelection(0);
                    AppMethodBeat.o(25732);
                    return;
                }
                int[] iArr = IPCallCountryCodeSelectUI.this.yvh.yuP;
                if (iArr == null) {
                    AppMethodBeat.o(25732);
                    return;
                }
                for (int i2 = 0; i2 < iArr.length; i2++) {
                    if (iArr[i2] == charAt) {
                        IPCallCountryCodeSelectUI.this.yvg.setSelection(i2 + IPCallCountryCodeSelectUI.this.yvg.getHeaderViewsCount());
                        AppMethodBeat.o(25732);
                        return;
                    }
                }
                AppMethodBeat.o(25732);
            }
        };
        this.yvi.setOnScrollBarTouchListener(this.yvj);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeSelectUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25733);
                IPCallCountryCodeSelectUI.this.hideVKB();
                Intent intent = new Intent();
                intent.putExtra("country_name", IPCallCountryCodeSelectUI.this.jbZ);
                intent.putExtra("couttry_code", IPCallCountryCodeSelectUI.this.countryCode);
                IPCallCountryCodeSelectUI.this.setResult(100, intent);
                IPCallCountryCodeSelectUI.this.finish();
                AppMethodBeat.o(25733);
                return true;
            }
        });
        this.yvg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeSelectUI.AnonymousClass5 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(25734);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallCountryCodeSelectUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                Intent intent = new Intent();
                if (i2 >= IPCallCountryCodeSelectUI.this.yvg.getHeaderViewsCount()) {
                    a aVar = (a) IPCallCountryCodeSelectUI.this.yvh.getItem(i2 - IPCallCountryCodeSelectUI.this.yvg.getHeaderViewsCount());
                    intent.putExtra("country_name", aVar.jbZ);
                    intent.putExtra("couttry_code", aVar.countryCode);
                    IPCallCountryCodeSelectUI.this.setResult(100, intent);
                }
                IPCallCountryCodeSelectUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallCountryCodeSelectUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(25734);
            }
        });
        AppMethodBeat.o(25739);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(25740);
        if (i2 == 4) {
            Intent intent = new Intent();
            intent.putExtra("country_name", this.jbZ);
            intent.putExtra("couttry_code", this.countryCode);
            setResult(100, intent);
            finish();
            AppMethodBeat.o(25740);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(25740);
        return onKeyDown;
    }

    static /* synthetic */ void a(IPCallCountryCodeSelectUI iPCallCountryCodeSelectUI) {
        AppMethodBeat.i(25741);
        if (iPCallCountryCodeSelectUI.yvh != null) {
            iPCallCountryCodeSelectUI.yvh.SM(iPCallCountryCodeSelectUI.kdi);
        }
        AppMethodBeat.o(25741);
    }
}
