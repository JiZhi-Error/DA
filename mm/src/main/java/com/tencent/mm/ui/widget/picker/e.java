package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.BottomSheetBehavior;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;
import java.util.HashMap;

public final class e {
    public TextView FdD = ((TextView) this.lJI.findViewById(R.id.dox));
    public o.f HLX;
    public o.g HLY;
    public m HMc = new m(this.mContext);
    public ListView QTo = ((ListView) this.lJI.findViewById(R.id.fng));
    public View QTp = this.lJI.findViewById(R.id.dog);
    public ArrayList<Integer> QTq;
    public a QTr;
    public b QTs;
    public Button hPX = ((Button) this.lJI.findViewById(R.id.g3k));
    public Button hSq = ((Button) this.lJI.findViewById(R.id.aib));
    public View lJI = View.inflate(this.mContext, R.layout.bc6, null);
    public Context mContext;
    public int mLJ;
    private BottomSheetBehavior mLK;
    public android.support.design.widget.a yfL = new android.support.design.widget.a(this.mContext);

    public interface b {
        void tK(boolean z);
    }

    public e(Context context) {
        AppMethodBeat.i(159571);
        this.mContext = context;
        this.yfL.setContentView(this.lJI);
        this.mLJ = at.aH(this.mContext, R.dimen.w) + at.aH(this.mContext, R.dimen.x);
        this.mLK = BottomSheetBehavior.l((View) this.lJI.getParent());
        if (this.mLK != null) {
            this.mLK.J(this.mLJ);
            this.mLK.ob = false;
        }
        this.yfL.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.ui.widget.picker.e.AnonymousClass1 */

            public final void onDismiss(DialogInterface dialogInterface) {
                e.this.yfL = null;
            }
        });
        AppMethodBeat.o(159571);
    }

    public final void hide() {
        AppMethodBeat.i(159572);
        if (this.yfL != null) {
            this.yfL.dismiss();
        }
        AppMethodBeat.o(159572);
    }

    public class a extends BaseAdapter {
        public HashMap<Integer, Boolean> QTu = new HashMap<>();
        private ArrayList<Integer> QTv;
        private Context context;

        /* renamed from: com.tencent.mm.ui.widget.picker.e$a$a  reason: collision with other inner class name */
        class C2145a {
            LinearLayout HMm;
            CheckBox checkBox;
            TextView jBR;
            TextView jVO;

            C2145a() {
            }
        }

        public a(Context context2) {
            AppMethodBeat.i(159565);
            this.context = context2;
            AppMethodBeat.o(159565);
        }

        public final int getCount() {
            AppMethodBeat.i(159566);
            int size = e.this.HMc.size();
            AppMethodBeat.o(159566);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(159567);
            MenuItem menuItem = e.this.HMc.ORD.get(i2);
            AppMethodBeat.o(159567);
            return menuItem;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(final int i2, View view, ViewGroup viewGroup) {
            C2145a aVar;
            AppMethodBeat.i(159568);
            final n nVar = (n) e.this.HMc.ORD.get(i2);
            LayoutInflater from = LayoutInflater.from(this.context);
            if (view == null) {
                view = from.inflate(R.layout.bc5, (ViewGroup) null);
                C2145a aVar2 = new C2145a();
                aVar2.HMm = (LinearLayout) view.findViewById(R.id.e2x);
                aVar2.checkBox = (CheckBox) view.findViewById(R.id.e21);
                aVar2.jVO = (TextView) view.findViewById(R.id.e40);
                aVar2.jBR = (TextView) view.findViewById(R.id.e28);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C2145a) view.getTag();
            }
            aVar.jVO.setText(nVar.getTitle());
            aVar.HMm.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.widget.picker.e.a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(159564);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MultiPicker$ListViewAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (e.this.HLY != null) {
                        e.this.HLY.onMMMenuItemSelected(e.this.HMc.getItem(i2), i2);
                    }
                    if (nVar.neT) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MultiPicker$ListViewAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(159564);
                        return;
                    }
                    if (((Boolean) a.this.QTu.get(Integer.valueOf(i2))).booleanValue()) {
                        a.this.QTu.put(Integer.valueOf(i2), Boolean.FALSE);
                    } else {
                        a.this.QTu.put(Integer.valueOf(i2), Boolean.TRUE);
                    }
                    a.this.QTu = a.this.QTu;
                    a.this.notifyDataSetChanged();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MultiPicker$ListViewAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(159564);
                }
            });
            if (aVar.jBR != null) {
                if (nVar.xdb == null || nVar.xdb.length() <= 0) {
                    aVar.jBR.setVisibility(8);
                } else {
                    aVar.jBR.setVisibility(0);
                    aVar.jBR.setText(nVar.xdb);
                }
            }
            if (nVar.neT) {
                aVar.jVO.setTextColor(e.this.mContext.getResources().getColor(R.color.g1));
                aVar.jBR.setTextColor(e.this.mContext.getResources().getColor(R.color.g1));
                aVar.checkBox.setChecked(this.QTu.get(Integer.valueOf(i2)).booleanValue());
                aVar.checkBox.setEnabled(false);
            } else {
                aVar.jVO.setTextColor(e.this.mContext.getResources().getColor(R.color.g0));
                aVar.jBR.setTextColor(e.this.mContext.getResources().getColor(R.color.g2));
                aVar.checkBox.setChecked(this.QTu.get(Integer.valueOf(i2)).booleanValue());
                aVar.checkBox.setEnabled(true);
            }
            AppMethodBeat.o(159568);
            return view;
        }

        public final void hck() {
            AppMethodBeat.i(159569);
            if (e.this.QTq == null) {
                AppMethodBeat.o(159569);
                return;
            }
            for (int i2 = 0; i2 < getCount(); i2++) {
                if (e.this.QTq.contains(Integer.valueOf(i2))) {
                    this.QTu.put(Integer.valueOf(i2), Boolean.TRUE);
                } else {
                    this.QTu.put(Integer.valueOf(i2), Boolean.FALSE);
                }
            }
            AppMethodBeat.o(159569);
        }

        public final ArrayList<Integer> hcl() {
            AppMethodBeat.i(159570);
            if (this.QTu == null) {
                AppMethodBeat.o(159570);
                return null;
            }
            this.QTv = new ArrayList<>();
            for (int i2 = 0; i2 < getCount(); i2++) {
                if (this.QTu.get(Integer.valueOf(i2)).booleanValue()) {
                    this.QTv.add(Integer.valueOf(i2));
                }
            }
            ArrayList<Integer> arrayList = this.QTv;
            AppMethodBeat.o(159570);
            return arrayList;
        }
    }

    static /* synthetic */ void a(e eVar, boolean z) {
        AppMethodBeat.i(159573);
        if (eVar.QTs != null) {
            eVar.QTs.tK(z);
        }
        AppMethodBeat.o(159573);
    }
}
