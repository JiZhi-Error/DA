package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
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
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.o;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort3rdAppUI extends MMActivity {
    private long Btv;
    private a OLf;
    private List<g> OLg;
    private DragSortListView rhg;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.byb;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(33756);
        super.onCreate(bundle);
        this.Btv = getIntent().getLongExtra("KFlag", -1);
        initView();
        this.OLg = h.b((Context) this, this.Btv, true);
        final List<String> Mq = ao.gng().Mq(this.Btv);
        if (Mq != null && Mq.size() > 0) {
            Collections.sort(this.OLg, new Comparator<g>() {
                /* class com.tencent.mm.ui.Sort3rdAppUI.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(g gVar, g gVar2) {
                    AppMethodBeat.i(33751);
                    int indexOf = Mq.indexOf(gVar2.field_appId) - Mq.indexOf(gVar.field_appId);
                    AppMethodBeat.o(33751);
                    return indexOf;
                }
            });
        }
        this.OLf = new a(this, this.OLg, this.Btv);
        this.rhg.setAdapter((ListAdapter) this.OLf);
        AppMethodBeat.o(33756);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(33757);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.Sort3rdAppUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(33749);
                Sort3rdAppUI.this.finish();
                AppMethodBeat.o(33749);
                return true;
            }
        });
        setMMTitle(getString(R.string.cx));
        this.rhg = (DragSortListView) findViewById(R.id.ed2);
        this.rhg.setDropListener(new DragSortListView.h() {
            /* class com.tencent.mm.ui.Sort3rdAppUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.h
            public final void ey(int i2, int i3) {
                AppMethodBeat.i(33750);
                g gVar = (g) Sort3rdAppUI.this.OLf.getItem(i2);
                Sort3rdAppUI.this.OLf.remove(gVar);
                Sort3rdAppUI.this.OLf.insert(gVar, i3);
                AppMethodBeat.o(33750);
            }
        });
        AppMethodBeat.o(33757);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(33758);
        super.onDestroy();
        AppMethodBeat.o(33758);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(33759);
        super.onPause();
        if (this.OLf != null) {
            List<g> list = this.OLf.qXp;
            p gng = ao.gng();
            long j2 = this.Btv;
            StringBuilder sb = new StringBuilder();
            sb.append("delete from AppSort");
            sb.append(" where flag = ").append(j2).append(" ");
            gng.db.execSQL("AppSort", sb.toString());
            if (list != null && list.size() > 0) {
                bg.aVF();
                long beginTransaction = c.getDataDB().beginTransaction(Thread.currentThread().getId());
                p gng2 = ao.gng();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    o oVar = new o();
                    oVar.field_flag = this.Btv;
                    oVar.field_appId = list.get(i2).field_appId;
                    oVar.field_sortId = i2;
                    gng2.a(oVar);
                }
                bg.aVF();
                c.getDataDB().endTransaction(beginTransaction);
            }
        }
        AppMethodBeat.o(33759);
    }

    /* access modifiers changed from: package-private */
    public static class a extends ArrayAdapter<g> {
        private long Btv;
        private Context mContext;
        List<g> qXp;
        private com.tencent.mm.av.a.a.c rFu;

        public a(Context context, List<g> list, long j2) {
            super(context, (int) R.layout.byc, list);
            AppMethodBeat.i(33754);
            this.Btv = j2;
            this.mContext = context;
            this.qXp = list;
            c.a aVar = new c.a();
            aVar.jbq = R.drawable.biz;
            this.rFu = aVar.bdv();
            AppMethodBeat.o(33754);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C2074a aVar;
            boolean z = true;
            AppMethodBeat.i(33755);
            if (view == null) {
                view = View.inflate(this.mContext, R.layout.byc, null);
                C2074a aVar2 = new C2074a(view);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C2074a) view.getTag();
            }
            final g gVar = (g) getItem(i2);
            aVar.jVO.setText(gVar.field_appName);
            Bitmap c2 = h.c(gVar.field_appId, 1, com.tencent.mm.cb.a.getDensity(this.mContext));
            if (c2 == null || c2.isRecycled()) {
                q.bcV().a(gVar.field_appIconUrl, aVar.nnL, this.rFu);
            } else {
                aVar.nnL.setImageBitmap(c2);
            }
            MMSwitchBtn mMSwitchBtn = aVar.sLW;
            if ((gVar.field_appInfoFlag & 16384) != 0) {
                z = false;
            }
            mMSwitchBtn.setCheck(z);
            aVar.sLW.setSwitchListener(new MMSwitchBtn.a() {
                /* class com.tencent.mm.ui.Sort3rdAppUI.a.AnonymousClass1 */

                @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
                public final void onStatusChange(boolean z) {
                    AppMethodBeat.i(33752);
                    if (z) {
                        gVar.field_appInfoFlag &= -16385;
                    } else {
                        gVar.field_appInfoFlag |= 16384;
                    }
                    ao.eAS().a(gVar, new String[0]);
                    AppMethodBeat.o(33752);
                }
            });
            view.setVisibility(0);
            AppMethodBeat.o(33755);
            return view;
        }

        /* renamed from: com.tencent.mm.ui.Sort3rdAppUI$a$a  reason: collision with other inner class name */
        static class C2074a {
            TextView jVO;
            ImageView nnL;
            View qXq;
            ImageView qXr;
            MMSwitchBtn sLW;

            public C2074a(View view) {
                AppMethodBeat.i(33753);
                this.qXr = (ImageView) view.findViewById(R.id.dpx);
                this.nnL = (ImageView) view.findViewById(R.id.dtb);
                this.jVO = (TextView) view.findViewById(R.id.ipp);
                this.sLW = (MMSwitchBtn) view.findViewById(R.id.ifl);
                this.qXq = view.findViewById(R.id.be3);
                AppMethodBeat.o(33753);
            }
        }
    }
}
