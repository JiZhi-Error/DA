package com.tencent.mm.ui.matrix;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.d;
import com.tencent.matrix.report.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.matrix.recyclerview.JsonRecyclerView;
import com.tencent.mm.ui.matrix.recyclerview.b;
import java.util.Iterator;
import org.json.JSONArray;

public class MatrixReportUI extends MMActivity {
    private JSONArray QmN = new JSONArray();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MatrixReportUI() {
        AppMethodBeat.i(38877);
        AppMethodBeat.o(38877);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38878);
        super.onCreate(bundle);
        setMMTitle(getContext().getResources().getString(R.string.eyo));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.matrix.MatrixReportUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(38875);
                MatrixReportUI.this.finish();
                AppMethodBeat.o(38875);
                return true;
            }
        });
        Iterator<h.d> it = d.INSTANCE.cPJ.cWw.iterator();
        while (it.hasNext()) {
            this.QmN.put(it.next().cWe);
        }
        b bVar = new b(this.QmN);
        ((JsonRecyclerView) findViewById(R.id.e5e)).setAdapter(bVar);
        bVar.tib = new View.OnLongClickListener() {
            /* class com.tencent.mm.ui.matrix.MatrixReportUI.AnonymousClass2 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(38876);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/ui/matrix/MatrixReportUI$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                if (view.getTag() != null) {
                    ClipboardHelper.setText(view.getTag().toString());
                    Toast.makeText(MMApplicationContext.getContext(), MatrixReportUI.this.getContext().getResources().getString(R.string.ta), 0).show();
                }
                a.a(true, (Object) this, "com/tencent/mm/ui/matrix/MatrixReportUI$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(38876);
                return true;
            }
        };
        AppMethodBeat.o(38878);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b6s;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(38879);
        super.onDestroy();
        AppMethodBeat.o(38879);
    }
}
