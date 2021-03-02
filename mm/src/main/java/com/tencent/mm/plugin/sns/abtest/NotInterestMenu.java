package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.ui.aa;

public class NotInterestMenu extends LinearLayout {
    private static int[] Drk = {R.string.h6x, R.string.h6v, R.string.h6w};
    private SnsInfo DqO = null;
    private ListView Drj;
    private c Drl = null;
    private b Drm = null;
    private Context mContext = null;

    public interface b {
        void eWx();
    }

    public interface c {
        void c(SnsInfo snsInfo);

        void d(SnsInfo snsInfo);

        void e(SnsInfo snsInfo);
    }

    public NotInterestMenu(Context context) {
        super(context);
        AppMethodBeat.i(94941);
        this.mContext = context;
        init();
        AppMethodBeat.o(94941);
    }

    public NotInterestMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(94942);
        this.mContext = context;
        init();
        AppMethodBeat.o(94942);
    }

    public void setOnSelectMenuItemListener(c cVar) {
        this.Drl = cVar;
    }

    public void setOnClickMenuListener(b bVar) {
        this.Drm = bVar;
    }

    public void setSnsInfo(SnsInfo snsInfo) {
        this.DqO = snsInfo;
    }

    private void init() {
        AppMethodBeat.i(94943);
        aa.jQ(this.mContext).inflate(R.layout.bg8, this);
        this.Drj = (ListView) findViewById(R.id.g0v);
        this.Drj.setAdapter((ListAdapter) new a());
        this.Drj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.sns.abtest.NotInterestMenu.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(94937);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/abtest/NotInterestMenu$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (NotInterestMenu.this.Drm != null) {
                    NotInterestMenu.this.Drm.eWx();
                }
                if (NotInterestMenu.this.Drl != null) {
                    switch (i2) {
                        case 0:
                            NotInterestMenu.this.Drl.c(NotInterestMenu.this.DqO);
                            break;
                        case 1:
                            NotInterestMenu.this.Drl.d(NotInterestMenu.this.DqO);
                            break;
                        case 2:
                            NotInterestMenu.this.Drl.e(NotInterestMenu.this.DqO);
                            break;
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/abtest/NotInterestMenu$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(94937);
            }
        });
        AppMethodBeat.o(94943);
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        a() {
        }

        public final int getCount() {
            AppMethodBeat.i(94938);
            int length = NotInterestMenu.Drk.length;
            AppMethodBeat.o(94938);
            return length;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(94939);
            Integer valueOf = Integer.valueOf(NotInterestMenu.Drk[i2]);
            AppMethodBeat.o(94939);
            return valueOf;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(94940);
            if (view == null) {
                view = aa.jQ(NotInterestMenu.this.mContext).inflate(R.layout.bg9, viewGroup, false);
                C1701a aVar = new C1701a();
                aVar.Dro = (TextView) view.findViewById(R.id.g0w);
                view.setTag(aVar);
            }
            ((C1701a) view.getTag()).Dro.setText(NotInterestMenu.Drk[i2]);
            AppMethodBeat.o(94940);
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.sns.abtest.NotInterestMenu$a$a  reason: collision with other inner class name */
        class C1701a {
            TextView Dro;

            C1701a() {
            }
        }
    }
}
