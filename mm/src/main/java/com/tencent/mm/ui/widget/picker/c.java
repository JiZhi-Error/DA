package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.picker.d.d;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.List;

public final class c implements ViewTreeObserver.OnGlobalLayoutListener {
    private LinearLayout PTf;
    private Button QSR;
    private String[] QSW;
    private ArrayList<List<String>> QSX = null;
    private ArrayList<List<String>> QSY = null;
    private CustomOptionPickNew QSZ;
    public CustomOptionPickNew QTa;
    private CustomOptionPickNew QTb;
    public b QTc;
    private a QTd;
    private LinearLayout QTe;
    private LinearLayout QTf;
    private LinearLayout QTg;
    private LinearLayout QTh;
    private boolean QTi = false;
    private Button hPX;
    private Button hSq;
    private View lJI;
    private Context mContext;
    private int mLJ;
    private BottomSheetBehavior mLK;
    private android.support.design.widget.a yfL;

    public interface a<T> {
        void a(boolean z, T t, T t2, T t3);
    }

    public interface b<T> {
        void onResult(boolean z, T t, T t2);
    }

    static /* synthetic */ String[] a(c cVar, int i2) {
        AppMethodBeat.i(159550);
        String[] anz = cVar.anz(i2);
        AppMethodBeat.o(159550);
        return anz;
    }

    static /* synthetic */ String[] b(c cVar, int i2) {
        AppMethodBeat.i(198439);
        String[] apq = cVar.apq(i2);
        AppMethodBeat.o(198439);
        return apq;
    }

    public c(Context context, String[] strArr) {
        AppMethodBeat.i(159539);
        this.mContext = context;
        this.QSW = strArr;
        initView();
        AppMethodBeat.o(159539);
    }

    public c(Context context, ArrayList<String> arrayList) {
        AppMethodBeat.i(159540);
        this.mContext = context;
        if (arrayList != null) {
            this.QSW = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        initView();
        AppMethodBeat.o(159540);
    }

    public c(Context context, ArrayList<String> arrayList, ArrayList<List<String>> arrayList2) {
        AppMethodBeat.i(159541);
        this.mContext = context;
        if (arrayList != null) {
            this.QSW = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        this.QSX = arrayList2;
        initView();
        AppMethodBeat.o(159541);
    }

    public c(Context context, ArrayList<String> arrayList, ArrayList<List<String>> arrayList2, ArrayList<List<String>> arrayList3) {
        AppMethodBeat.i(198429);
        this.mContext = context;
        if (arrayList != null) {
            this.QSW = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        this.QSX = arrayList2;
        this.QSY = arrayList3;
        this.QTi = false;
        initView();
        AppMethodBeat.o(198429);
    }

    public final void a(a aVar) {
        this.QTd = aVar;
    }

    public final void onGlobalLayout() {
    }

    private void initView() {
        AppMethodBeat.i(159542);
        this.yfL = new android.support.design.widget.a(this.mContext);
        this.lJI = View.inflate(this.mContext, R.layout.bh5, null);
        this.PTf = (LinearLayout) this.lJI.findViewById(R.id.g54);
        this.QTh = (LinearLayout) this.lJI.findViewById(R.id.g53);
        this.QTe = (LinearLayout) this.lJI.findViewById(R.id.g52);
        this.QSZ = new CustomOptionPickNew(this.mContext);
        this.QSZ.setOptionsArray(this.QSW);
        this.QTe.removeAllViews();
        this.QTe.setGravity(17);
        this.QTe.addView(this.QSZ.getView(), new LinearLayout.LayoutParams(-2, -1));
        this.QTf = (LinearLayout) this.lJI.findViewById(R.id.g55);
        this.QTg = (LinearLayout) this.lJI.findViewById(R.id.g56);
        if (this.QSX != null) {
            this.QTf.setVisibility(0);
            this.QTa = new CustomOptionPickNew(this.mContext);
            this.QTf.removeAllViews();
            this.QTf.setGravity(17);
            this.QTf.addView(this.QTa.getView(), new LinearLayout.LayoutParams(-2, -1));
            this.QTa.setOptionsArray(anz(this.QSZ.getValue()));
            if (!this.QTi) {
                this.QSZ.setOnValueChangedListener(new d() {
                    /* class com.tencent.mm.ui.widget.picker.c.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.picker.d.d
                    public final void uO(int i2) {
                        AppMethodBeat.i(198424);
                        c.this.QTa.setOptionsArray(c.a(c.this, i2));
                        if (!(c.this.QSY == null || c.this.QTb == null)) {
                            int i3 = 0;
                            for (int i4 = 0; i4 < i2; i4++) {
                                i3 += ((List) c.this.QSX.get(i4)).size();
                            }
                            c.this.QTb.setOptionsArray(c.b(c.this, c.this.QTa.getValue() + i3));
                        }
                        AppMethodBeat.o(198424);
                    }
                });
            }
        } else {
            this.QTf.setVisibility(8);
        }
        if (this.QSY != null) {
            this.QTg.setVisibility(0);
            this.QTb = new CustomOptionPickNew(this.mContext);
            this.QTg.removeAllViews();
            this.QTg.setGravity(17);
            this.QTg.addView(this.QTb.getView(), new LinearLayout.LayoutParams(-2, -1));
            this.QTb.setOptionsArray(apq(this.QTa.getValue()));
            if (!this.QTi) {
                this.QTa.setOnValueChangedListener(new d() {
                    /* class com.tencent.mm.ui.widget.picker.c.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.widget.picker.d.d
                    public final void uO(int i2) {
                        AppMethodBeat.i(198425);
                        int value = c.this.QSZ.getValue();
                        int i3 = 0;
                        for (int i4 = 0; i4 < value; i4++) {
                            i3 += ((List) c.this.QSX.get(i4)).size();
                        }
                        c.this.QTb.setOptionsArray(c.b(c.this, i3 + i2));
                        AppMethodBeat.o(198425);
                    }
                });
            }
        } else {
            this.QTg.setVisibility(8);
        }
        this.hPX = (Button) this.lJI.findViewById(R.id.g3k);
        this.hPX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.widget.picker.c.AnonymousClass3 */

            public final void onClick(View view) {
                String str = null;
                AppMethodBeat.i(159537);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMOptionPicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c.a(c.this, true, c.this.QSZ == null ? null : c.this.QSZ.currentValue(), c.this.QTa == null ? null : c.this.QTa.currentValue());
                c cVar = c.this;
                String currentValue = c.this.QSZ == null ? null : c.this.QSZ.currentValue();
                String currentValue2 = c.this.QTa == null ? null : c.this.QTa.currentValue();
                if (c.this.QTb != null) {
                    str = c.this.QTb.currentValue();
                }
                c.a(cVar, true, currentValue, currentValue2, str);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMOptionPicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159537);
            }
        });
        this.hSq = (Button) this.lJI.findViewById(R.id.aib);
        this.hSq.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.widget.picker.c.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(198426);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMOptionPicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c.a(c.this, false, null, null);
                c.a(c.this, false, null, null, null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMOptionPicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(198426);
            }
        });
        this.QSR = (Button) this.lJI.findViewById(R.id.af_);
        this.QSR.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.widget.picker.c.AnonymousClass5 */

            public final void onClick(View view) {
                String str = null;
                AppMethodBeat.i(198427);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMOptionPicker$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c.a(c.this, true, c.this.QSZ == null ? null : c.this.QSZ.currentValue(), c.this.QTa == null ? null : c.this.QTa.currentValue());
                c cVar = c.this;
                String currentValue = c.this.QSZ == null ? null : c.this.QSZ.currentValue();
                String currentValue2 = c.this.QTa == null ? null : c.this.QTa.currentValue();
                if (c.this.QTb != null) {
                    str = c.this.QTb.currentValue();
                }
                c.a(cVar, true, currentValue, currentValue2, str);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMOptionPicker$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(198427);
            }
        });
        this.yfL.setContentView(this.lJI);
        this.mLJ = at.fromDPToPix(this.mContext, v2helper.EMethodSetPlayerPreCorrectCofOn);
        this.mLK = BottomSheetBehavior.l((View) this.lJI.getParent());
        if (this.mLK != null) {
            this.mLK.J(this.mLJ);
            this.mLK.ob = false;
        }
        this.yfL.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.ui.widget.picker.c.AnonymousClass6 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(198428);
                c.this.yfL = null;
                AppMethodBeat.o(198428);
            }
        });
        AppMethodBeat.o(159542);
    }

    public final void aF(CharSequence charSequence) {
        AppMethodBeat.i(198430);
        if (this.hPX != null) {
            this.hPX.setText(charSequence);
        }
        AppMethodBeat.o(198430);
    }

    public final void apd(int i2) {
        AppMethodBeat.i(198431);
        if (this.hSq != null) {
            this.hSq.setTextColor(i2);
        }
        AppMethodBeat.o(198431);
    }

    public final void axw(int i2) {
        AppMethodBeat.i(258271);
        if (this.hPX != null) {
            this.hPX.setBackgroundResource(i2);
        }
        AppMethodBeat.o(258271);
    }

    public final void hch() {
        AppMethodBeat.i(198433);
        if (this.hPX != null) {
            this.hPX.setTextColor(this.mContext.getResources().getColor(R.color.jq));
            this.hPX.setBackgroundResource(R.drawable.kb);
        }
        AppMethodBeat.o(198433);
    }

    public final void setHeaderView(View view) {
        AppMethodBeat.i(198434);
        if (this.PTf != null) {
            if (view == null) {
                this.PTf.setVisibility(8);
                AppMethodBeat.o(198434);
                return;
            }
            this.PTf.setVisibility(0);
            this.PTf.removeAllViews();
            this.PTf.setGravity(17);
            this.PTf.addView(view, new LinearLayout.LayoutParams(-1, -2));
        }
        AppMethodBeat.o(198434);
    }

    public final void setFooterView(View view) {
        AppMethodBeat.i(198435);
        if (this.QTh != null) {
            if (view == null) {
                this.QTh.setVisibility(8);
                AppMethodBeat.o(198435);
                return;
            }
            this.QTh.setVisibility(0);
            this.QTh.removeAllViews();
            this.QTh.setGravity(17);
            this.QTh.addView(view, new LinearLayout.LayoutParams(-1, -2));
        }
        AppMethodBeat.o(198435);
    }

    public final void show() {
        AppMethodBeat.i(159544);
        if (this.yfL != null) {
            this.yfL.show();
        }
        AppMethodBeat.o(159544);
    }

    public final void hide() {
        AppMethodBeat.i(159545);
        if (this.yfL != null) {
            this.yfL.dismiss();
        }
        AppMethodBeat.o(159545);
    }

    public final int hci() {
        AppMethodBeat.i(159546);
        int i2 = 0;
        if (this.QSZ != null) {
            i2 = this.QSZ.getValue();
        }
        AppMethodBeat.o(159546);
        return i2;
    }

    public final void app(int i2) {
        AppMethodBeat.i(159547);
        if (this.QSZ != null) {
            this.QSZ.setValue(i2);
            this.QSZ.apo(i2);
            if (!(this.QTa == null || this.QSX == null)) {
                this.QTa.setOptionsArray(anz(i2));
            }
        }
        AppMethodBeat.o(159547);
    }

    public final void lM(int i2, int i3) {
        AppMethodBeat.i(159548);
        if (!(this.QSZ == null || this.QTa == null)) {
            this.QSZ.setValue(i2);
            this.QSZ.apo(i2);
            this.QTa.setOptionsArray(anz(i2));
            this.QTa.setValue(i3);
            this.QTa.apo(i3);
            this.QTa.invalidate();
        }
        AppMethodBeat.o(159548);
    }

    public final void hcj() {
        AppMethodBeat.i(198436);
        if (!(this.QSZ == null || this.QTa == null || this.QTb == null)) {
            this.QSZ.setValue(1);
            this.QSZ.apo(1);
            this.QTa.setOptionsArray(anz(1));
            this.QTa.setValue(12);
            this.QTa.apo(12);
            this.QTa.invalidate();
            this.QTb.setOptionsArray(apq(12));
            this.QTb.setValue(0);
            this.QTb.apo(0);
            this.QTb.invalidate();
        }
        AppMethodBeat.o(198436);
    }

    private String[] anz(int i2) {
        ArrayList arrayList;
        AppMethodBeat.i(198437);
        if (this.QSX == null || (arrayList = (ArrayList) this.QSX.get(i2)) == null) {
            AppMethodBeat.o(198437);
            return null;
        }
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        AppMethodBeat.o(198437);
        return strArr;
    }

    private String[] apq(int i2) {
        ArrayList arrayList;
        AppMethodBeat.i(198438);
        if (this.QSY == null || (arrayList = (ArrayList) this.QSY.get(i2)) == null) {
            AppMethodBeat.o(198438);
            return null;
        }
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        AppMethodBeat.o(198438);
        return strArr;
    }

    static /* synthetic */ void a(c cVar, boolean z, Object obj, Object obj2) {
        AppMethodBeat.i(198440);
        if (cVar.QTc != null) {
            cVar.QTc.onResult(z, obj, obj2);
        }
        AppMethodBeat.o(198440);
    }

    static /* synthetic */ void a(c cVar, boolean z, Object obj, Object obj2, Object obj3) {
        AppMethodBeat.i(198441);
        if (cVar.QTd != null) {
            cVar.QTd.a(z, obj, obj2, obj3);
        }
        AppMethodBeat.o(198441);
    }
}
