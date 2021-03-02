package com.tencent.mm.plugin.fingerprint.ui;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.soter.a.b.c;

public class SoterPayTestUI extends MMActivity implements i {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64560);
        super.onCreate(bundle);
        findViewById(R.id.i2m).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fingerprint.ui.SoterPayTestUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(64557);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/fingerprint/ui/SoterPayTestUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.SoterPayTestUI", "hy: start get challenge");
                g.aAi();
                g.aAg().hqi.a(1586, SoterPayTestUI.this);
                g.aAi();
                g.aAg().hqi.a(new com.tencent.mm.plugin.fingerprint.c.a(0), 0);
                a.a(this, "com/tencent/mm/plugin/fingerprint/ui/SoterPayTestUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64557);
            }
        });
        findViewById(R.id.gzk).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fingerprint.ui.SoterPayTestUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(64558);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/fingerprint/ui/SoterPayTestUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.SoterPayTestUI", "hy: regen and upload ask");
                com.tencent.soter.a.a.a(new com.tencent.soter.a.b.b<c>() {
                    /* class com.tencent.mm.plugin.fingerprint.ui.SoterPayTestUI.AnonymousClass2.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.soter.a.b.e] */
                    @Override // com.tencent.soter.a.b.b
                    public final /* bridge */ /* synthetic */ void a(c cVar) {
                    }
                }, false, null);
                a.a(this, "com/tencent/mm/plugin/fingerprint/ui/SoterPayTestUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64558);
            }
        });
        findViewById(R.id.gzl).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fingerprint.ui.SoterPayTestUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(64559);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/fingerprint/ui/SoterPayTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a.a(this, "com/tencent/mm/plugin/fingerprint/ui/SoterPayTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64559);
            }
        });
        AppMethodBeat.o(64560);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.aln;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(64561);
        Log.i("MicroMsg.SoterPayTestUI", "hy: on scene end: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        u.makeText(this, String.format("on scene end: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str), 1).show();
        g.aAi();
        g.aAg().hqi.b(qVar.getType(), this);
        AppMethodBeat.o(64561);
    }
}
