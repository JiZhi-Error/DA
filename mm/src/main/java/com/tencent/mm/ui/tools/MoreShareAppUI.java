package com.tencent.mm.ui.tools;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import java.util.List;

public class MoreShareAppUI extends MMActivity {
    private List<g> OLg;
    private a Qvo;
    private DragSortListView rhg;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bbh;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39082);
        super.onCreate(bundle);
        initView();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.tools.MoreShareAppUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39079);
                MoreShareAppUI.this.finish();
                AppMethodBeat.o(39079);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.btn), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.tools.MoreShareAppUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });
        this.Qvo = new a(this, this.OLg);
        this.rhg.setAdapter((ListAdapter) this.Qvo);
        AppMethodBeat.o(39082);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(39083);
        setMMTitle(R.string.all);
        this.rhg = (DragSortListView) findViewById(R.id.ed2);
        this.rhg.setDropListener(new DragSortListView.h() {
            /* class com.tencent.mm.ui.tools.MoreShareAppUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.h
            public final void ey(int i2, int i3) {
                AppMethodBeat.i(39078);
                MoreShareAppUI.this.Qvo.qXp.remove(i2);
                MoreShareAppUI.this.Qvo.notifyDataSetChanged();
                MoreShareAppUI.this.Qvo.insert((g) MoreShareAppUI.this.Qvo.getItem(i2), i3);
                AppMethodBeat.o(39078);
            }
        });
        AppMethodBeat.o(39083);
    }

    /* access modifiers changed from: package-private */
    public static class a extends ArrayAdapter<g> {
        private Context mContext;
        private List<g> qXp;

        public a(Context context, List<g> list) {
            super(context, (int) R.layout.bbi, list);
            this.mContext = context;
            this.qXp = list;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C2128a aVar;
            AppMethodBeat.i(39081);
            if (view == null) {
                view = View.inflate(this.mContext, R.layout.bbi, null);
                C2128a aVar2 = new C2128a(view);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C2128a) view.getTag();
            }
            aVar.jVO.setText(((g) getItem(i2)).field_appName);
            view.setVisibility(0);
            AppMethodBeat.o(39081);
            return view;
        }

        /* renamed from: com.tencent.mm.ui.tools.MoreShareAppUI$a$a  reason: collision with other inner class name */
        static class C2128a {
            TextView jVO;
            ImageView nnL;
            View qXq;
            ImageView qXr;
            MMSwitchBtn sLW;

            public C2128a(View view) {
                AppMethodBeat.i(39080);
                this.qXr = (ImageView) view.findViewById(R.id.dpx);
                this.nnL = (ImageView) view.findViewById(R.id.dtb);
                this.jVO = (TextView) view.findViewById(R.id.ipp);
                this.sLW = (MMSwitchBtn) view.findViewById(R.id.ifl);
                this.qXq = view.findViewById(R.id.be3);
                AppMethodBeat.o(39080);
            }
        }
    }
}
