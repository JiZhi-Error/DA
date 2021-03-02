package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bb.n;
import com.tencent.mm.g.a.pq;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelectPoiCategoryUI extends MMActivity {
    static final String ACy = (ar.NSe + "poi_categories");
    private ArrayAdapter<String> ACA;
    private List<String> ACB;
    private AdapterView.OnItemClickListener ACC = new AdapterView.OnItemClickListener() {
        /* class com.tencent.mm.plugin.nearlife.ui.SelectPoiCategoryUI.AnonymousClass1 */

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(26626);
            b bVar = new b();
            bVar.bm(adapterView);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.zo(j2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearlife/ui/SelectPoiCategoryUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
            Log.d("MicroMsg.SelectPoiCategoryUI", "item click on pos:%d, len:%d", Integer.valueOf(i2), Integer.valueOf(SelectPoiCategoryUI.this.ACB.size()));
            Intent intent = new Intent();
            intent.putExtra("poi_category", (String) SelectPoiCategoryUI.this.ACB.get(i2));
            SelectPoiCategoryUI.this.setResult(-1, intent);
            SelectPoiCategoryUI.this.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearlife/ui/SelectPoiCategoryUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(26626);
        }
    };
    private MenuItem.OnMenuItemClickListener ACt = new MenuItem.OnMenuItemClickListener() {
        /* class com.tencent.mm.plugin.nearlife.ui.SelectPoiCategoryUI.AnonymousClass2 */

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(26627);
            SelectPoiCategoryUI.this.setResult(0, null);
            SelectPoiCategoryUI.this.finish();
            AppMethodBeat.o(26627);
            return true;
        }
    };
    private a ACz;
    private ListView mListView;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SelectPoiCategoryUI() {
        AppMethodBeat.i(26630);
        AppMethodBeat.o(26630);
    }

    static {
        AppMethodBeat.i(26638);
        AppMethodBeat.o(26638);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bpu;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26631);
        super.onCreate(bundle);
        this.ACB = new ArrayList();
        initView();
        this.ACz = new a();
        EventCenter.instance.addListener(this.ACz);
        this.ACz.ACE = this;
        bg.azz().a(new n(17), 0);
        AppMethodBeat.o(26631);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(26632);
        setMMTitle(R.string.fdm);
        setBackBtn(this.ACt);
        this.ACA = new ArrayAdapter<>(this, R.layout.bia);
        this.mListView = (ListView) findViewById(R.id.apy);
        this.mListView.setAdapter((ListAdapter) this.ACA);
        this.mListView.setOnItemClickListener(this.ACC);
        if (!aIy(ACy + "/lastest_poi_categories.dat")) {
            try {
                J(getAssets().open("default_poi_categories.dat"));
            } catch (IOException e2) {
                Log.d("MicroMsg.SelectPoiCategoryUI", "open file from assets failed: " + e2.getMessage());
            }
        }
        exh();
        AppMethodBeat.o(26632);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048 A[SYNTHETIC, Splitter:B:15:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0096 A[SYNTHETIC, Splitter:B:28:0x0096] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean J(java.io.InputStream r7) {
        /*
        // Method dump skipped, instructions count: 194
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.nearlife.ui.SelectPoiCategoryUI.J(java.io.InputStream):boolean");
    }

    private boolean aIy(String str) {
        boolean z = false;
        AppMethodBeat.i(26634);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(26634);
        } else {
            o oVar = new o(str);
            if (!oVar.exists()) {
                AppMethodBeat.o(26634);
            } else {
                try {
                    z = J(s.ao(oVar));
                    AppMethodBeat.o(26634);
                } catch (FileNotFoundException e2) {
                    Log.d("MicroMsg.SelectPoiCategoryUI", "update poi categories failed, path:%s, msg:%s", str, e2.getMessage());
                    AppMethodBeat.o(26634);
                }
            }
        }
        return z;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(26635);
        super.onDestroy();
        EventCenter.instance.removeListener(this.ACz);
        AppMethodBeat.o(26635);
    }

    /* access modifiers changed from: package-private */
    public final void bU(byte[] bArr) {
        AppMethodBeat.i(26636);
        String[] split = new String(bArr).split("\n");
        this.ACB.clear();
        for (String str : split) {
            this.ACB.add(str.trim());
        }
        AppMethodBeat.o(26636);
    }

    /* access modifiers changed from: package-private */
    public final void exh() {
        AppMethodBeat.i(26637);
        this.ACA.clear();
        for (int i2 = 0; i2 < this.ACB.size(); i2++) {
            this.ACA.add(this.ACB.get(i2));
        }
        this.ACA.notifyDataSetChanged();
        AppMethodBeat.o(26637);
    }

    class a extends IListener<pq> {
        SelectPoiCategoryUI ACE;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(pq pqVar) {
            AppMethodBeat.i(26629);
            boolean a2 = a(pqVar);
            AppMethodBeat.o(26629);
            return a2;
        }

        public a() {
            super(0);
            AppMethodBeat.i(161394);
            this.__eventId = pq.class.getName().hashCode();
            AppMethodBeat.o(161394);
        }

        private boolean a(pq pqVar) {
            AppMethodBeat.i(26628);
            if (pqVar instanceof pq) {
                SelectPoiCategoryUI selectPoiCategoryUI = this.ACE;
                byte[] bArr = pqVar.dVG.content;
                o oVar = new o(SelectPoiCategoryUI.ACy);
                if (!oVar.exists()) {
                    oVar.mkdirs();
                }
                try {
                    String str = SelectPoiCategoryUI.ACy + "/lastest_poi_categories.dat";
                    o oVar2 = new o(str);
                    if (!oVar2.exists()) {
                        oVar2.createNewFile();
                    }
                    s.f(str, bArr, bArr.length);
                } catch (Exception e2) {
                    Log.e("MicroMsg.SelectPoiCategoryUI", "write file failed: " + e2.getMessage());
                }
                selectPoiCategoryUI.bU(bArr);
                selectPoiCategoryUI.exh();
            }
            AppMethodBeat.o(26628);
            return false;
        }
    }
}
