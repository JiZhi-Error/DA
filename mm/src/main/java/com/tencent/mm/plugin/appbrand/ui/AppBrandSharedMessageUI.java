package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.ui.MMActivity;

public class AppBrandSharedMessageUI extends MMActivity {
    private ListView mListView;
    private MRecyclerView nWH;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.fl;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48788);
        super.onCreate(bundle);
        this.mListView = (ListView) findViewById(R.id.ecx);
        this.nWH = (MRecyclerView) findViewById(R.id.bkg);
        this.mListView.setAdapter((ListAdapter) new b(getLayoutInflater()));
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandSharedMessageUI.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(227669);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandSharedMessageUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandSharedMessageUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(227669);
            }
        });
        this.nWH.setLayoutManager(new LinearLayoutManager(1, false));
        this.nWH.setAdapter(new a());
        this.nWH.addHeaderView(getLayoutInflater().inflate(R.layout.fk, (ViewGroup) null));
        AppMethodBeat.o(48788);
    }

    static class b extends BaseAdapter {
        private LayoutInflater mInflater;

        public b(LayoutInflater layoutInflater) {
            this.mInflater = layoutInflater;
        }

        public final int getCount() {
            return 0;
        }

        public final Object getItem(int i2) {
            return null;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final int getItemViewType(int i2) {
            AppMethodBeat.i(48787);
            int itemViewType = super.getItemViewType(i2);
            AppMethodBeat.o(48787);
            return itemViewType;
        }

        public final int getViewTypeCount() {
            return 4;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            return null;
        }
    }

    public static class a extends RecyclerView.a {
        @Override // android.support.v7.widget.RecyclerView.a
        public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
            return null;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2) {
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            return 0;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(48786);
            int itemViewType = super.getItemViewType(i2);
            AppMethodBeat.o(48786);
            return itemViewType;
        }
    }
}
