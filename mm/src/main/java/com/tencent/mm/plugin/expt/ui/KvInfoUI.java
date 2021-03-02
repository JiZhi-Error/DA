package com.tencent.mm.plugin.expt.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.picker.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KvInfoUI extends MMActivity {
    private Button hPX;
    private d kvo;
    private ArrayAdapter sKU;
    private EditText sLS;
    private Button sLT;
    private ListView sLU;
    private TextView sLV;
    private MMSwitchBtn sLW;
    private String sLX;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(KvInfoUI kvInfoUI, String str) {
        AppMethodBeat.i(220680);
        kvInfoUI.arl(str);
        AppMethodBeat.o(220680);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(220676);
        super.onCreate(bundle);
        setMMTitle("Debug show kv log");
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.expt.ui.KvInfoUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(220670);
                KvInfoUI.this.finish();
                AppMethodBeat.o(220670);
                return true;
            }
        });
        this.sLS = (EditText) $(R.id.dyu);
        this.sLV = (TextView) $(R.id.hi0);
        this.sLT = (Button) $(R.id.er9);
        this.sLT.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.expt.ui.KvInfoUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(220672);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/expt/ui/KvInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                HashMap<String, List<com.tencent.mm.plugin.expt.e.b>> hashMap = com.tencent.mm.plugin.expt.e.a.cRf().sJQ;
                if (hashMap != null && hashMap.size() > 0) {
                    final ArrayList arrayList = new ArrayList(hashMap.keySet());
                    final c cVar = new c(KvInfoUI.this.getContext(), arrayList);
                    cVar.app(0);
                    cVar.QTc = new c.b() {
                        /* class com.tencent.mm.plugin.expt.ui.KvInfoUI.AnonymousClass2.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.widget.picker.c.b
                        public final void onResult(boolean z, Object obj, Object obj2) {
                            AppMethodBeat.i(220671);
                            cVar.hide();
                            int hci = cVar.hci();
                            KvInfoUI.a(KvInfoUI.this, (String) arrayList.get(hci));
                            AppMethodBeat.o(220671);
                        }
                    };
                    cVar.show();
                }
                a.a(this, "com/tencent/mm/plugin/expt/ui/KvInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(220672);
            }
        });
        this.sLW = (MMSwitchBtn) $(R.id.bkz);
        this.sLW.setCheck(com.tencent.mm.plugin.expt.e.a.cRf().sJP);
        this.sLW.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.expt.ui.KvInfoUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                AppMethodBeat.i(220673);
                com.tencent.mm.plugin.expt.e.a.cRf().sJP = z;
                AppMethodBeat.o(220673);
            }
        });
        this.hPX = (Button) $(R.id.b_4);
        this.hPX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.expt.ui.KvInfoUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(220674);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/expt/ui/KvInfoUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                KvInfoUI.a(KvInfoUI.this, KvInfoUI.this.sLS.getText().toString().trim());
                a.a(this, "com/tencent/mm/plugin/expt/ui/KvInfoUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(220674);
            }
        });
        this.sLU = (ListView) $(R.id.e6x);
        this.sKU = new ArrayAdapter(this) {
            /* class com.tencent.mm.plugin.expt.ui.KvInfoUI.AnonymousClass5 */

            public final View getView(int i2, View view, ViewGroup viewGroup) {
                AppMethodBeat.i(220675);
                View view2 = super.getView(i2, view, viewGroup);
                com.tencent.mm.plugin.expt.e.b bVar = (com.tencent.mm.plugin.expt.e.b) KvInfoUI.this.sKU.getItem(i2);
                TextView textView = (TextView) view2.findViewById(R.id.e6w);
                if (bVar == null || !bVar.sJV) {
                    textView.setBackgroundResource(R.color.ac_);
                } else {
                    textView.setBackgroundResource(R.color.afp);
                }
                AppMethodBeat.o(220675);
                return view2;
            }
        };
        this.sLU.setAdapter((ListAdapter) this.sKU);
        AppMethodBeat.o(220676);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ay1;
    }

    private void arl(String str) {
        AppMethodBeat.i(220677);
        Log.i("MicroMsg.KvInfoUI", "updateData new[%s] old[%s]", str, this.sLX);
        this.sLX = str;
        List<com.tencent.mm.plugin.expt.e.b> list = com.tencent.mm.plugin.expt.e.a.cRf().sJQ.get(this.sLX);
        if (list != null) {
            this.sLV.setText(this.sLX + ":" + list.size());
            this.sKU.setNotifyOnChange(false);
            this.sKU.clear();
            this.sKU.addAll(list);
            this.sKU.notifyDataSetChanged();
            AppMethodBeat.o(220677);
            return;
        }
        this.sLV.setText(this.sLX + ":0");
        this.sKU.clear();
        AppMethodBeat.o(220677);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(220678);
        if (this.sKU != null) {
            this.sKU.setNotifyOnChange(false);
            this.sKU.clear();
        }
        if (this.kvo != null) {
            this.kvo.dismiss();
        }
        hideVKB();
        super.onDestroy();
        AppMethodBeat.o(220678);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(220679);
        if (!Util.isNullOrNil(this.sLX)) {
            arl(this.sLX);
        }
        super.onResume();
        AppMethodBeat.o(220679);
    }
}
