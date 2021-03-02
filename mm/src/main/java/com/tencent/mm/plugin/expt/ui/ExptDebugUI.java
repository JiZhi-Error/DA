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
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.picker.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class ExptDebugUI extends MMActivity {
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
    private Button sLz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(122477);
        super.onCreate(bundle);
        setMMTitle("Expt debug ui");
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.expt.ui.ExptDebugUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(122470);
                ExptDebugUI.this.finish();
                AppMethodBeat.o(122470);
                return true;
            }
        });
        this.sLw = (TextView) $(R.id.dyq);
        this.hPX = (Button) $(R.id.b_4);
        this.hPX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.expt.ui.ExptDebugUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(122471);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/expt/ui/ExptDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ExptDebugUI.a(ExptDebugUI.this, Util.getInt(ExptDebugUI.this.sLw.getText().toString().trim(), 0));
                e.INSTANCE.kvStat(9999, "1");
                a.a(this, "com/tencent/mm/plugin/expt/ui/ExptDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(122471);
            }
        });
        this.sLF = (EditText) $(R.id.c75);
        this.sLG = (Button) $(R.id.c76);
        this.sLG.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.expt.ui.ExptDebugUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(122472);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/expt/ui/ExptDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ExptDebugUI.b(ExptDebugUI.this);
                a.a(this, "com/tencent/mm/plugin/expt/ui/ExptDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(122472);
            }
        });
        this.sLx = (Button) $(R.id.c72);
        this.sLx.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.expt.ui.ExptDebugUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(122474);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/expt/ui/ExptDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ArrayList<Integer> cRm = com.tencent.mm.plugin.expt.f.a.cRk().cRm();
                if (cRm != null && cRm.size() > 0) {
                    final String[] strArr = new String[cRm.size()];
                    for (int i2 = 0; i2 < strArr.length; i2++) {
                        strArr[i2] = new StringBuilder().append(cRm.get(i2)).toString();
                    }
                    final c cVar = new c(ExptDebugUI.this.getContext(), strArr);
                    cVar.app(0);
                    cVar.QTc = new c.b() {
                        /* class com.tencent.mm.plugin.expt.ui.ExptDebugUI.AnonymousClass4.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.widget.picker.c.b
                        public final void onResult(boolean z, Object obj, Object obj2) {
                            AppMethodBeat.i(122473);
                            cVar.hide();
                            ExptDebugUI.a(ExptDebugUI.this, Util.getInt(strArr[cVar.hci()], 0));
                            AppMethodBeat.o(122473);
                        }
                    };
                    cVar.show();
                }
                a.a(this, "com/tencent/mm/plugin/expt/ui/ExptDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(122474);
            }
        });
        this.sLz = (Button) $(R.id.h3j);
        this.sLz.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.expt.ui.ExptDebugUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(122475);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/expt/ui/ExptDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.expt.f.a.cRk();
                com.tencent.mm.plugin.expt.f.a.Hw(1);
                Toast.makeText(ExptDebugUI.this.getContext(), "start req expt", 0).show();
                a.a(this, "com/tencent/mm/plugin/expt/ui/ExptDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(122475);
            }
        });
        this.kjo = (Button) $(R.id.c6y);
        this.kjo.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.expt.ui.ExptDebugUI.AnonymousClass6 */

            public final void onClick(View view) {
                boolean z;
                AppMethodBeat.i(122476);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/expt/ui/ExptDebugUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.expt.h.c Hv = com.tencent.mm.plugin.expt.f.a.cRk().Hv(ExptDebugUI.this.sLI);
                if (Hv != null && Hv.cRM()) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(Integer.valueOf(ExptDebugUI.this.sLI));
                    com.tencent.mm.plugin.expt.f.a.cRk();
                    com.tencent.mm.plugin.expt.f.a.a(null, null, linkedList);
                }
                if (Hv != null && Hv.cRN()) {
                    com.tencent.mm.plugin.expt.f.a.cRk();
                    com.tencent.mm.plugin.expt.f.a.f("", false, true);
                }
                if (Hv != null && Hv.cRO()) {
                    com.tencent.mm.plugin.expt.f.a.cRk();
                    com.tencent.mm.plugin.expt.f.a.aY("", true);
                }
                if (Hv != null && Hv.cRP()) {
                    com.tencent.mm.plugin.expt.f.a.cRk();
                    com.tencent.mm.plugin.expt.f.a.b(Hv.cRW(), "", true, false);
                }
                com.tencent.mm.plugin.expt.f.a.cRk();
                com.tencent.mm.plugin.expt.f.a.a(Hv, true);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(ExptDebugUI.this.sLI));
                if (com.tencent.mm.plugin.expt.f.a.cRk().dv(arrayList) > 0) {
                    z = true;
                } else {
                    z = false;
                }
                ExptDebugUI.this.sLE.setText(" del :" + ExptDebugUI.this.sLI + " " + z);
                a.a(this, "com/tencent/mm/plugin/expt/ui/ExptDebugUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(122476);
            }
        });
        this.sLH = (Button) $(R.id.c6z);
        this.sLH.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.expt.ui.ExptDebugUI.AnonymousClass7 */

            /* JADX WARNING: Removed duplicated region for block: B:16:0x009b A[SYNTHETIC, Splitter:B:16:0x009b] */
            /* JADX WARNING: Removed duplicated region for block: B:31:0x0112 A[SYNTHETIC, Splitter:B:31:0x0112] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onClick(android.view.View r9) {
                /*
                // Method dump skipped, instructions count: 311
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.ui.ExptDebugUI.AnonymousClass7.onClick(android.view.View):void");
            }
        });
        this.sLA = (TextView) $(R.id.c70);
        this.sLB = (TextView) $(R.id.dlo);
        this.sLC = (TextView) $(R.id.c73);
        this.sLD = (TextView) $(R.id.c74);
        this.sLE = (TextView) $(R.id.c6x);
        AppMethodBeat.o(122477);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bs;
    }

    static /* synthetic */ void a(ExptDebugUI exptDebugUI, int i2) {
        AppMethodBeat.i(122478);
        exptDebugUI.sLI = i2;
        com.tencent.mm.plugin.expt.h.c Hv = com.tencent.mm.plugin.expt.f.a.cRk().Hv(exptDebugUI.sLI);
        if (Hv == null) {
            exptDebugUI.sLA.setText("");
            exptDebugUI.sLB.setText("");
            exptDebugUI.sLC.setText("");
            exptDebugUI.sLD.setText("");
            exptDebugUI.sLE.setText("");
            AppMethodBeat.o(122478);
            return;
        }
        if (Hv != null) {
            exptDebugUI.sLA.setText(new StringBuilder().append(Hv.field_exptId).toString());
            exptDebugUI.sLB.setText(new StringBuilder().append(Hv.field_groupId).toString());
            exptDebugUI.sLC.setText(new StringBuilder().append(Hv.field_exptSeq).toString());
            exptDebugUI.sLD.setText(" start: " + Hv.field_startTime + " end: " + Hv.field_endTime);
        }
        HashMap<String, String> a2 = com.tencent.mm.plugin.expt.f.a.cRk().a(exptDebugUI.sLI, false, null, new PBool());
        if (a2 != null) {
            exptDebugUI.sLE.setText(" args : " + a2.toString());
        }
        AppMethodBeat.o(122478);
    }

    static /* synthetic */ void b(ExptDebugUI exptDebugUI) {
        AppMethodBeat.i(122479);
        com.tencent.mm.plugin.expt.f.a.cRk().arg(exptDebugUI.sLF.getText().toString().trim());
        exptDebugUI.sLF.setText("");
        AppMethodBeat.o(122479);
    }
}
