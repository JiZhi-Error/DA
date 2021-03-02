package com.tencent.mm.plugin.expt.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.picker.c;
import java.util.ArrayList;
import java.util.HashMap;

public class ExptAppDebugUI extends MMActivity {
    private Button hPX;
    private Button kjo;
    private TextView sLA;
    private TextView sLB;
    private TextView sLC;
    private TextView sLD;
    private TextView sLE;
    private EditText sLF;
    private Button sLG;
    private Button sLH;
    private int sLI = 0;
    private TextView sLw;
    private Button sLx;
    private Button sLy;
    private Button sLz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(220657);
        super.onCreate(bundle);
        setMMTitle("Expt App debug ui");
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.expt.ui.ExptAppDebugUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(220650);
                ExptAppDebugUI.this.finish();
                AppMethodBeat.o(220650);
                return true;
            }
        });
        this.sLw = (TextView) $(R.id.dyq);
        this.hPX = (Button) $(R.id.b_4);
        this.hPX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.expt.ui.ExptAppDebugUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(220651);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ExptAppDebugUI.a(ExptAppDebugUI.this, Util.getInt(ExptAppDebugUI.this.sLw.getText().toString().trim(), 0));
                a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(220651);
            }
        });
        this.sLF = (EditText) $(R.id.c75);
        this.sLF.setVisibility(8);
        this.sLG = (Button) $(R.id.c76);
        this.sLG.setVisibility(8);
        this.sLx = (Button) $(R.id.c72);
        this.sLx.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.expt.ui.ExptAppDebugUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(220653);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.expt.f.a.cRk();
                ArrayList<Integer> cRo = com.tencent.mm.plugin.expt.f.a.cRo();
                if (cRo.size() > 0) {
                    final String[] strArr = new String[cRo.size()];
                    for (int i2 = 0; i2 < strArr.length; i2++) {
                        strArr[i2] = new StringBuilder().append(cRo.get(i2)).toString();
                    }
                    final c cVar = new c(ExptAppDebugUI.this.getContext(), strArr);
                    cVar.app(0);
                    cVar.QTc = new c.b() {
                        /* class com.tencent.mm.plugin.expt.ui.ExptAppDebugUI.AnonymousClass3.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.widget.picker.c.b
                        public final void onResult(boolean z, Object obj, Object obj2) {
                            AppMethodBeat.i(220652);
                            cVar.hide();
                            ExptAppDebugUI.a(ExptAppDebugUI.this, Util.getInt(strArr[cVar.hci()], 0));
                            AppMethodBeat.o(220652);
                        }
                    };
                    cVar.show();
                }
                a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(220653);
            }
        });
        this.sLy = (Button) $(R.id.h3a);
        this.sLy.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.expt.ui.ExptAppDebugUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(220654);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.expt.a.a.cMx();
                com.tencent.mm.plugin.expt.a.a.cMy();
                a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(220654);
            }
        });
        this.sLz = (Button) $(R.id.h3j);
        this.sLz.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.expt.ui.ExptAppDebugUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(220655);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.expt.f.a.cRk().Hx(1);
                Toast.makeText(ExptAppDebugUI.this.getContext(), "start req expt", 0).show();
                a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(220655);
            }
        });
        this.kjo = (Button) $(R.id.c6y);
        this.kjo.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.expt.ui.ExptAppDebugUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(220656);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(ExptAppDebugUI.this.sLI));
                com.tencent.mm.plugin.expt.f.a.cRk();
                com.tencent.mm.plugin.expt.f.a.b(0, arrayList, null);
                com.tencent.mm.plugin.expt.f.a.cRk();
                com.tencent.mm.plugin.expt.f.a.mq(true);
                ExptAppDebugUI.this.sLE.setText(" del :" + ExptAppDebugUI.this.sLI + " true");
                a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(220656);
            }
        });
        this.sLH = (Button) $(R.id.c6z);
        this.sLH.setVisibility(8);
        this.sLA = (TextView) $(R.id.c70);
        this.sLB = (TextView) $(R.id.dlo);
        this.sLC = (TextView) $(R.id.c73);
        this.sLD = (TextView) $(R.id.c74);
        this.sLE = (TextView) $(R.id.c6x);
        AppMethodBeat.o(220657);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.br;
    }

    static /* synthetic */ void a(ExptAppDebugUI exptAppDebugUI, int i2) {
        AppMethodBeat.i(220658);
        exptAppDebugUI.sLI = i2;
        com.tencent.mm.plugin.expt.f.a.cRk();
        com.tencent.mm.plugin.expt.h.a Hy = com.tencent.mm.plugin.expt.f.a.Hy(exptAppDebugUI.sLI);
        if (Hy == null) {
            exptAppDebugUI.sLA.setText("");
            exptAppDebugUI.sLB.setText("");
            exptAppDebugUI.sLC.setText("");
            exptAppDebugUI.sLD.setText("");
            exptAppDebugUI.sLE.setText("");
            AppMethodBeat.o(220658);
            return;
        }
        if (Hy != null) {
            exptAppDebugUI.sLA.setText(new StringBuilder().append(Hy.sLf).toString());
            exptAppDebugUI.sLB.setText(new StringBuilder().append(Hy.adT).toString());
            exptAppDebugUI.sLC.setText(new StringBuilder().append(Hy.sLg).toString());
            exptAppDebugUI.sLD.setText(" start: " + Hy.startTime + " end: " + Hy.endTime);
        }
        HashMap<String, String> cRH = Hy.cRH();
        if (cRH != null) {
            exptAppDebugUI.sLE.setText(" args : " + cRH.toString());
        }
        AppMethodBeat.o(220658);
    }
}
