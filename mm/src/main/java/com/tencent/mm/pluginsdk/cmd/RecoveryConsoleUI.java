package com.tencent.mm.pluginsdk.cmd;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecoveryConsoleUI extends MMActivity implements AdapterView.OnItemClickListener {
    ListView GP;
    List<b.a> JTg;
    SimpleAdapter JTh;
    List<Map<String, String>> qXp;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(151618);
        super.onCreate(bundle);
        setTitle("Recovery Console");
        this.JTg = b.gmb();
        this.qXp = new ArrayList(this.JTg.size());
        for (b.a aVar : this.JTg) {
            HashMap hashMap = new HashMap();
            hashMap.put("title", getString(aVar.nBF));
            this.qXp.add(hashMap);
        }
        this.JTh = new SimpleAdapter(this, this.qXp, R.layout.b8j, new String[]{"title"}, new int[]{16908310});
        this.GP = (ListView) findViewById(16908298);
        this.GP.setAdapter((ListAdapter) this.JTh);
        this.GP.setOnItemClickListener(this);
        AppMethodBeat.o(151618);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b_g;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(151619);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        a.b("com/tencent/mm/pluginsdk/cmd/RecoveryConsoleUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        b.a aVar = this.JTg.get(i2);
        if (aVar.JTl != null) {
            aVar.JTl.a(this, aVar.ehK.split(" +"), "");
        } else {
            b.Q(this, aVar.ehK, "");
        }
        a.a(this, "com/tencent/mm/pluginsdk/cmd/RecoveryConsoleUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(151619);
    }
}
