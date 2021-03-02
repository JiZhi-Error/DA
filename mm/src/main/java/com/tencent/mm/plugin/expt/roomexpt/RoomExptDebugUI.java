package com.tencent.mm.plugin.expt.roomexpt;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

public class RoomExptDebugUI extends MMActivity {
    private ListView krb;
    private ArrayAdapter sKU;
    private TextView sKV;
    private Button sKW;
    private Button sKX;
    private Button sKY;
    private Button sKZ;
    private Button sLa;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void c(RoomExptDebugUI roomExptDebugUI) {
        AppMethodBeat.i(122442);
        roomExptDebugUI.cnp();
        AppMethodBeat.o(122442);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(122437);
        super.onCreate(bundle);
        this.sKW = (Button) $(R.id.djq);
        this.sKW.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(122428);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(122427);
                        RoomExptDebugUI.a(RoomExptDebugUI.this);
                        AppMethodBeat.o(122427);
                    }
                });
                a.a(this, "com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(122428);
            }
        });
        this.sKX = (Button) $(R.id.ahx);
        this.sKX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(122430);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(122429);
                        RoomExptDebugUI.b(RoomExptDebugUI.this);
                        AppMethodBeat.o(122429);
                    }
                });
                a.a(this, "com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(122430);
            }
        });
        this.sKZ = (Button) $(R.id.h4k);
        this.sKZ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(122431);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a.cRz().cRD();
                RoomExptDebugUI.c(RoomExptDebugUI.this);
                Toast.makeText(RoomExptDebugUI.this, "reset finish", 0).show();
                a.a(this, "com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(122431);
            }
        });
        this.sKY = (Button) $(R.id.blj);
        this.sKY.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(122432);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a.cRz().cRC();
                RoomExptDebugUI.this.sKU.clear();
                Toast.makeText(RoomExptDebugUI.this, "del db finish", 0).show();
                a.a(this, "com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(122432);
            }
        });
        this.sLa = (Button) $(R.id.hqv);
        this.sLa.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(122433);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a.cRz().sKK = 3;
                Toast.makeText(RoomExptDebugUI.this, "set show finish", 0).show();
                a.a(this, "com/tencent/mm/plugin/expt/roomexpt/RoomExptDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(122433);
            }
        });
        this.sKV = (TextView) $(R.id.c71);
        cnp();
        this.krb = (ListView) $(R.id.h8_);
        this.sKU = new ArrayAdapter(this) {
            /* class com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI.AnonymousClass6 */

            public final View getView(int i2, View view, ViewGroup viewGroup) {
                AppMethodBeat.i(122434);
                View view2 = super.getView(i2, view, viewGroup);
                TextView textView = (TextView) view2.findViewById(R.id.h83);
                if (i2 % 2 == 0) {
                    textView.setBackgroundResource(R.color.afp);
                } else {
                    textView.setBackgroundResource(R.color.ac_);
                }
                AppMethodBeat.o(122434);
                return view2;
            }
        };
        this.krb.setAdapter((ListAdapter) this.sKU);
        AppMethodBeat.o(122437);
    }

    private void cnp() {
        AppMethodBeat.i(122438);
        this.sKV.setText(a.cRz().cRE());
        AppMethodBeat.o(122438);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.by;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(122439);
        if (this.sKU != null) {
            this.sKU.setNotifyOnChange(false);
            this.sKU.clear();
        }
        super.onDestroy();
        AppMethodBeat.o(122439);
    }

    static /* synthetic */ void a(RoomExptDebugUI roomExptDebugUI) {
        AppMethodBeat.i(122440);
        List<e> cRG = a.cRz().sKG.cRG();
        if (cRG.size() > 0) {
            roomExptDebugUI.sKU.setNotifyOnChange(false);
            roomExptDebugUI.sKU.clear();
            roomExptDebugUI.sKU.addAll(cRG);
        } else {
            roomExptDebugUI.sKU.setNotifyOnChange(false);
            roomExptDebugUI.sKU.clear();
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(122436);
                RoomExptDebugUI.this.sKU.notifyDataSetChanged();
                RoomExptDebugUI.c(RoomExptDebugUI.this);
                AppMethodBeat.o(122436);
            }
        });
        AppMethodBeat.o(122440);
    }

    static /* synthetic */ void b(RoomExptDebugUI roomExptDebugUI) {
        AppMethodBeat.i(122441);
        List<c> cRB = a.cRz().cRB();
        ArrayList arrayList = new ArrayList();
        if (cRB != null) {
            for (c cVar : cRB) {
                arrayList.add(cVar.toString());
            }
        }
        if (arrayList.size() > 0) {
            roomExptDebugUI.sKU.setNotifyOnChange(false);
            roomExptDebugUI.sKU.clear();
            roomExptDebugUI.sKU.addAll(arrayList);
        } else {
            roomExptDebugUI.sKU.setNotifyOnChange(false);
            roomExptDebugUI.sKU.clear();
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(122435);
                RoomExptDebugUI.this.sKU.notifyDataSetChanged();
                RoomExptDebugUI.c(RoomExptDebugUI.this);
                AppMethodBeat.o(122435);
            }
        });
        AppMethodBeat.o(122441);
    }
}
