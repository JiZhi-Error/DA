package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d extends BaseAdapter implements Filterable {
    private static String TAG = "MicroMsg.MobileHistoryAdapter";
    private AutoCompleteTextView BDD;
    List<String[]> BDG;
    public List<com.tencent.mm.plugin.recharge.model.a> BDM = new ArrayList();
    public boolean BDN = false;
    private List<com.tencent.mm.plugin.recharge.model.a> BDO;
    private String BDQ;
    private MallFormView BFp;
    private b BGc;
    public AbstractC1629d BGd = null;
    public a BGe = null;
    private Context mContext;

    public interface a {
        void eHY();
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.form.d$d  reason: collision with other inner class name */
    public interface AbstractC1629d {
    }

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(67328);
        com.tencent.mm.plugin.recharge.model.a Vp = Vp(i2);
        AppMethodBeat.o(67328);
        return Vp;
    }

    public d(MallFormView mallFormView, List<String[]> list) {
        AppMethodBeat.i(67321);
        this.mContext = mallFormView.getContext();
        this.BFp = mallFormView;
        this.BDD = (AutoCompleteTextView) mallFormView.getContentEditText();
        this.BDG = list;
        AppMethodBeat.o(67321);
    }

    public final synchronized void ga(List<com.tencent.mm.plugin.recharge.model.a> list) {
        AppMethodBeat.i(67322);
        this.BDO = list;
        notifyDataSetChanged();
        AppMethodBeat.o(67322);
    }

    public final Filter getFilter() {
        AppMethodBeat.i(67323);
        Log.d(TAG, "getFilter");
        if (this.BGc == null) {
            this.BGc = new b(this, (byte) 0);
        }
        b bVar = this.BGc;
        AppMethodBeat.o(67323);
        return bVar;
    }

    public final int getCount() {
        AppMethodBeat.i(67324);
        if (this.BDN) {
            int size = this.BDM.size() + 2;
            AppMethodBeat.o(67324);
            return size;
        } else if (this.BDM.size() > 0) {
            int size2 = this.BDM.size() + 1;
            AppMethodBeat.o(67324);
            return size2;
        } else {
            AppMethodBeat.o(67324);
            return 0;
        }
    }

    public final synchronized com.tencent.mm.plugin.recharge.model.a Vp(int i2) {
        com.tencent.mm.plugin.recharge.model.a aVar = null;
        synchronized (this) {
            AppMethodBeat.i(67325);
            if (this.BDN) {
                if (i2 == 0) {
                    AppMethodBeat.o(67325);
                } else if (i2 <= this.BDM.size()) {
                    aVar = this.BDM.get(i2 - 1);
                    AppMethodBeat.o(67325);
                } else {
                    AppMethodBeat.o(67325);
                }
            } else if (i2 < this.BDM.size()) {
                aVar = this.BDM.get(i2);
                AppMethodBeat.o(67325);
            } else {
                AppMethodBeat.o(67325);
            }
        }
        return aVar;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        c cVar;
        AppMethodBeat.i(67326);
        switch (getItemViewType(i2)) {
            case 0:
                if (view == null) {
                    view = View.inflate(this.mContext, R.layout.blb, null);
                    c cVar2 = new c(this, (byte) 0);
                    cVar2.BDU = (TextView) view.findViewById(R.id.f7b);
                    cVar2.gxs = (TextView) view.findViewById(R.id.f7a);
                    cVar2.BGh = (ImageView) view.findViewById(R.id.ist);
                    view.setTag(cVar2);
                    cVar = cVar2;
                } else {
                    cVar = (c) view.getTag();
                }
                if (!(cVar == null || cVar.BGh == null)) {
                    if (i2 == 0) {
                        cVar.BGh.setVisibility(0);
                    } else {
                        cVar.BGh.setVisibility(8);
                    }
                }
                com.tencent.mm.plugin.recharge.model.a Vp = Vp(i2);
                if (!(Vp == null || cVar == null || cVar.BDU == null || cVar.gxs == null)) {
                    String aKR = com.tencent.mm.plugin.recharge.model.b.aKR(Vp.BCX);
                    Log.d(TAG, "record.record " + aKR + ", record.name " + Vp.name + "，record.location " + Vp.ljO);
                    if (!com.tencent.mm.plugin.recharge.model.a.BCV.equals(Vp.BCY)) {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aKR);
                        int[] iArr = Vp.BCY;
                        for (int i3 : iArr) {
                            if (i3 >= 0) {
                                if (i3 >= 7) {
                                    i3 += 2;
                                } else if (i3 >= 3) {
                                    i3++;
                                }
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.color.a57)), i3, i3 + 1, 34);
                            }
                        }
                        cVar.BDU.setTextSize(24.0f);
                        cVar.BDU.setTextColor(this.mContext.getResources().getColor(R.color.a2x));
                        cVar.gxs.setTextColor(this.mContext.getResources().getColor(R.color.a2x));
                        cVar.BDU.setText(spannableStringBuilder);
                    } else {
                        cVar.BDU.setTextSize(16.0f);
                        cVar.BDU.setTextColor(this.mContext.getResources().getColor(R.color.uj));
                        cVar.gxs.setTextColor(this.mContext.getResources().getColor(R.color.uj));
                        cVar.BDU.setText(aKR);
                    }
                    if (Vp.name == null || Util.isNullOrNil(Vp.name.trim())) {
                        if (!Util.isNullOrNil(Vp.ljO)) {
                            cVar.gxs.setText(this.mContext.getString(R.string.iqf) + this.mContext.getString(R.string.iq6, Vp.ljO));
                            break;
                        } else {
                            cVar.gxs.setText(this.mContext.getString(R.string.iqf));
                            break;
                        }
                    } else {
                        if (!Util.isNullOrNil(Vp.ljO)) {
                            cVar.gxs.setText(Vp.name + this.mContext.getString(R.string.iq6, Vp.ljO));
                        } else {
                            cVar.gxs.setText(Vp.name);
                        }
                        if (Vp.name.equals(this.mContext.getString(R.string.iqd))) {
                            cVar.gxs.setTextColor(this.mContext.getResources().getColor(R.color.a54));
                            break;
                        } else {
                            cVar.gxs.setTextColor(this.mContext.getResources().getColor(R.color.a2t));
                            break;
                        }
                    }
                }
                break;
            case 1:
                view = View.inflate(this.mContext, R.layout.blc, null);
                view.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.recharge.ui.form.d.AnonymousClass2 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(67315);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        com.tencent.mm.plugin.recharge.a.a.eHL().ga(null);
                        d.this.BFp.eIj();
                        d.this.ga(new LinkedList());
                        if (d.this.BGe != null) {
                            d.this.BGe.eHY();
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(67315);
                    }
                });
                break;
            case 2:
                view = View.inflate(this.mContext, R.layout.bla, null);
                view.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.recharge.ui.form.d.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(67314);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        d.this.BDD.dismissDropDown();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(67314);
                    }
                });
                break;
            case 3:
                view = View.inflate(this.mContext, R.layout.blc, null);
                ((TextView) view.findViewById(R.id.guy)).setText(R.string.exm);
                view.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.recharge.ui.form.d.AnonymousClass3 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(67316);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        d.this.BDD.dismissDropDown();
                        d.this.BFp.eIi();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recharge/ui/form/MobileHistoryAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(67316);
                    }
                });
                break;
        }
        AppMethodBeat.o(67326);
        return view;
    }

    public final int getItemViewType(int i2) {
        AppMethodBeat.i(67327);
        if (this.BDN) {
            if (i2 == 0) {
                AppMethodBeat.o(67327);
                return 2;
            } else if (i2 <= this.BDM.size()) {
                AppMethodBeat.o(67327);
                return 0;
            } else {
                AppMethodBeat.o(67327);
                return 3;
            }
        } else if (i2 < this.BDM.size()) {
            AppMethodBeat.o(67327);
            return 0;
        } else {
            AppMethodBeat.o(67327);
            return 1;
        }
    }

    public final int getViewTypeCount() {
        return 4;
    }

    class b extends Filter {
        private b() {
        }

        /* synthetic */ b(d dVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final synchronized Filter.FilterResults performFiltering(CharSequence charSequence) {
            boolean z;
            Filter.FilterResults filterResults;
            AppMethodBeat.i(67318);
            Filter.FilterResults filterResults2 = new Filter.FilterResults();
            ArrayList arrayList = new ArrayList();
            String Ts = charSequence != null ? com.tencent.mm.plugin.recharge.model.b.Ts(charSequence.toString()) : "";
            if (!Ts.equals(d.this.BDQ) || Ts.equals("")) {
                d.this.BDQ = Ts;
                if (d.this.BDO != null && !d.this.BDO.isEmpty()) {
                    for (com.tencent.mm.plugin.recharge.model.a aVar : d.this.BDO) {
                        aVar.BCY = com.tencent.mm.plugin.recharge.model.a.BCV;
                    }
                }
                if (d.this.BFp.bql()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Log.i(d.TAG, "performFiltering2 ".concat(String.valueOf(charSequence)));
                    com.tencent.mm.plugin.recharge.model.a eHN = com.tencent.mm.plugin.recharge.a.a.eHN();
                    if (eHN == null || !Ts.equals(eHN.BCX)) {
                        if (d.this.BDG == null || d.this.BDG.isEmpty()) {
                            d.this.BDG = com.tencent.mm.pluginsdk.b.dO(d.this.mContext);
                        }
                        if (d.this.BDG != null) {
                            Iterator it = d.this.BDG.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                String[] strArr = (String[]) it.next();
                                String Ts2 = com.tencent.mm.plugin.recharge.model.b.Ts(strArr[2]);
                                int[] jy = jy(d.this.BDQ, Ts2);
                                if (com.tencent.mm.plugin.recharge.model.a.BCV.equals(jy)) {
                                    AppMethodBeat.o(67318);
                                    filterResults = filterResults2;
                                    break;
                                } else if (!com.tencent.mm.plugin.recharge.model.a.BCW.equals(jy) && arrayList.size() < 4) {
                                    com.tencent.mm.plugin.recharge.model.a aVar2 = new com.tencent.mm.plugin.recharge.model.a(Ts2, strArr[1], 1);
                                    aVar2.BCY = jy;
                                    arrayList.add(aVar2);
                                }
                            }
                        }
                        for (com.tencent.mm.plugin.recharge.model.a aVar3 : com.tencent.mm.plugin.recharge.a.a.eHL().eHM()) {
                            int[] jy2 = jy(d.this.BDQ, com.tencent.mm.plugin.recharge.model.b.Ts(aVar3.BCX));
                            if (com.tencent.mm.plugin.recharge.model.a.BCV.equals(jy2)) {
                                AppMethodBeat.o(67318);
                                filterResults = filterResults2;
                                break;
                            } else if (!com.tencent.mm.plugin.recharge.model.a.BCW.equals(jy2) && arrayList.size() < 4) {
                                aVar3.BCY = jy2;
                                arrayList.add(aVar3);
                            }
                        }
                        Log.d(d.TAG, " search phone number cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
                        z = true;
                    } else {
                        AppMethodBeat.o(67318);
                        filterResults = filterResults2;
                    }
                } else if (!Util.isNullOrNil(d.this.BDQ)) {
                    Log.i(d.TAG, "performFiltering1 ".concat(String.valueOf(charSequence)));
                    for (com.tencent.mm.plugin.recharge.model.a aVar4 : d.this.BDO) {
                        if (aVar4.BCX.startsWith(d.this.BDQ)) {
                            arrayList.add(aVar4);
                        }
                    }
                    z = false;
                } else {
                    arrayList.addAll(d.this.BDO);
                    z = false;
                }
                filterResults2.count = arrayList.size();
                filterResults2.values = arrayList;
                d.this.BDN = z;
                AppMethodBeat.o(67318);
                filterResults = filterResults2;
            } else {
                d.this.BDD.post(new Runnable() {
                    /* class com.tencent.mm.plugin.recharge.ui.form.d.b.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(67317);
                        AppMethodBeat.o(67317);
                    }
                });
                filterResults2.count = d.this.BDM.size();
                filterResults2.values = d.this.BDM;
                AppMethodBeat.o(67318);
                filterResults = filterResults2;
            }
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            AppMethodBeat.i(67319);
            if (filterResults.values == null) {
                d.this.BDM = new ArrayList();
            } else {
                d.this.BDM = (List) filterResults.values;
            }
            if (filterResults.count == 0) {
                d.this.BFp.BFZ = true;
            } else {
                d.this.BFp.BFZ = false;
            }
            Log.i(d.TAG, "results.count " + filterResults.count);
            if (filterResults.count > 0) {
                d.this.notifyDataSetChanged();
            }
            AppMethodBeat.o(67319);
        }

        private static int[] jy(String str, String str2) {
            AppMethodBeat.i(67320);
            if (str.equals(str2)) {
                int[] iArr = com.tencent.mm.plugin.recharge.model.a.BCV;
                AppMethodBeat.o(67320);
                return iArr;
            }
            if (str2 != null && str.length() == str2.length()) {
                int i2 = 0;
                int[] iArr2 = {-1, -1};
                for (int length = str.length() - 1; length > 0; length--) {
                    if (str2.charAt(length) != str.charAt(length)) {
                        i2++;
                        if (i2 > 2) {
                            break;
                        }
                        iArr2[i2 - 1] = length;
                    }
                }
                if (i2 <= 2) {
                    AppMethodBeat.o(67320);
                    return iArr2;
                }
            }
            int[] iArr3 = com.tencent.mm.plugin.recharge.model.a.BCW;
            AppMethodBeat.o(67320);
            return iArr3;
        }
    }

    class c {
        TextView BDU;
        ImageView BGh;
        TextView gxs;

        private c() {
        }

        /* synthetic */ c(d dVar, byte b2) {
            this();
        }
    }
}
