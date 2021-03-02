package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mall.a.k;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private SparseArray<String> zjr = null;
    private int zjs;
    private final int zkb = 3;
    private final int zkc = 9;
    private final int zkd = 3;
    List<ArrayList<c>> zke = new ArrayList();
    d zkf;
    private boolean zkg = true;
    private int zkh = 0;
    private int zki = 0;
    private boolean zkj = false;
    private boolean zkk = false;

    public interface d {
        void a(int i2, MallFunction mallFunction);
    }

    public b(Context context, int i2) {
        AppMethodBeat.i(66035);
        this.mContext = context;
        this.zjs = i2;
        this.mInflater = LayoutInflater.from(this.mContext);
        AppMethodBeat.o(66035);
    }

    public final void ax(ArrayList<MallFunction> arrayList) {
        int i2;
        int i3;
        AppMethodBeat.i(66036);
        this.zke.clear();
        if (arrayList != null) {
            int i4 = 0;
            while (i4 < arrayList.size()) {
                ArrayList<c> arrayList2 = new ArrayList<>();
                int i5 = 0;
                while (i5 < 3 && i4 + i5 < arrayList.size()) {
                    int i6 = i4 + i5;
                    if (i5 > 0 && (i4 + i5) - 1 >= 0 && arrayList.get(i3).type != arrayList.get(i6).type) {
                        break;
                    }
                    c cVar = new c();
                    cVar.zkJ = i4 + i5;
                    cVar.zkI = arrayList.get(i4 + i5);
                    arrayList2.add(cVar);
                    i5++;
                }
                if (arrayList2.size() > 0) {
                    this.zke.add(arrayList2);
                }
                i4 += i5;
            }
            this.zkh = 0;
            this.zki = 0;
            int i7 = -1;
            for (ArrayList<c> arrayList3 : this.zke) {
                if (arrayList3.size() > 0) {
                    if (!(i7 == -1 || i7 == arrayList3.get(0).zkI.type)) {
                        break;
                    }
                    this.zkh += arrayList3.size();
                    this.zki++;
                    i2 = arrayList3.get(0).zkI.type;
                } else {
                    i2 = i7;
                }
                i7 = i2;
            }
            this.zki--;
        }
        this.zjr = k.egL().Qd(this.zjs).zjr;
        this.zkj = egR();
        Log.i("MicroMsg.FunctionListAdapter", "hasMoreNewAtFirstSectionBottom: %s", Boolean.valueOf(this.zkj));
        notifyDataSetChanged();
        AppMethodBeat.o(66036);
    }

    public final int getCount() {
        AppMethodBeat.i(66037);
        int size = this.zke.size();
        AppMethodBeat.o(66037);
        return size;
    }

    public final Object getItem(int i2) {
        return null;
    }

    public final long getItemId(int i2) {
        return 0;
    }

    private boolean Qf(int i2) {
        boolean z;
        AppMethodBeat.i(66038);
        if (this.zkh > 9) {
            int i3 = 0;
            for (int i4 = 0; i4 <= i2; i4++) {
                i3 += this.zke.get(i4).size();
            }
            int i5 = this.zki > 3 ? 3 : this.zki;
            if (i3 >= 9) {
                if (this.zkg && i2 == i5) {
                    z = true;
                    AppMethodBeat.o(66038);
                    return z;
                } else if (i2 == this.zki && !this.zkg) {
                    z = true;
                    AppMethodBeat.o(66038);
                    return z;
                }
            }
        }
        z = false;
        AppMethodBeat.o(66038);
        return z;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        int i3;
        boolean z;
        int i4;
        C1469b bVar;
        int i5 = 3;
        AppMethodBeat.i(66039);
        boolean Qf = Qf(i2);
        if (this.zkh > 9) {
            if (this.zki <= 3) {
                i5 = this.zki;
            }
            i3 = i5;
        } else {
            i3 = -1;
        }
        if (Qf || i2 + 1 >= this.zke.size()) {
            z = false;
        } else {
            z = Qf(i2 + 1);
        }
        if (Qf) {
            i4 = 1;
        } else if (z) {
            i4 = 2;
        } else {
            i4 = 0;
        }
        if (view == null) {
            C1469b bVar2 = new C1469b();
            view = this.mInflater.inflate(R.layout.b56, viewGroup, false);
            bVar2.zkz = (LinearLayout) view.findViewById(R.id.f6z);
            bVar2.zkA = (TextView) view.findViewById(R.id.f6y);
            bVar2.zkB = view.findViewById(R.id.brt);
            bVar2.zkC = view.findViewById(R.id.ebz);
            bVar2.zkD = view.findViewById(R.id.f_f);
            bVar2.zkF = (TextView) view.findViewById(R.id.f_g);
            bVar2.zkE = (ImageView) view.findViewById(R.id.f_e);
            bVar2.zkG = view.findViewById(R.id.fka);
            bVar2.zkH = view.findViewById(R.id.aal);
            bVar2.zkD.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.mall.ui.b.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(66033);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/FunctionListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    b.this.zkg = !b.this.zkg;
                    b.this.zkk = true;
                    b.this.notifyDataSetChanged();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/FunctionListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(66033);
                }
            });
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (C1469b) view.getTag();
        }
        if (Qf) {
            bVar.zkA.setVisibility(8);
            bVar.zkB.setVisibility(8);
            bVar.zkC.setVisibility(8);
            bVar.zkD.setVisibility(0);
            bVar.zkE.setImageResource(R.raw.icons_outlined_arrow);
            bVar.zkE.setColorFilter(this.mContext.getResources().getColor(R.color.x0), PorterDuff.Mode.SRC_ATOP);
            bVar.zkE.setPivotX((float) (bVar.zkE.getWidth() / 2));
            bVar.zkE.setPivotY((float) (bVar.zkE.getHeight() / 2));
            bVar.zkE.setRotation(90.0f);
            bVar.zkF.setText(this.mContext.getString(R.string.evw));
            if (!this.zkj || this.zkk) {
                bVar.zkG.setVisibility(8);
            } else {
                bVar.zkG.setVisibility(0);
            }
            if (this.zkg) {
                bVar.zkz.setVisibility(8);
                bVar.zkF.setText(this.mContext.getString(R.string.evw));
            } else {
                bVar.zkz.setVisibility(0);
                a(i2, bVar, i4);
                bVar.zkE.setImageResource(R.raw.icons_outlined_arrow);
                bVar.zkE.setColorFilter(this.mContext.getResources().getColor(R.color.x0), PorterDuff.Mode.SRC_ATOP);
                bVar.zkE.setPivotX((float) (bVar.zkE.getWidth() / 2));
                bVar.zkE.setPivotY((float) (bVar.zkE.getHeight() / 2));
                bVar.zkE.setRotation(270.0f);
                bVar.zkF.setText(this.mContext.getString(R.string.evu));
            }
        } else if (i3 <= 0 || !this.zkg || i2 < i3 || i2 > this.zki) {
            bVar.zkz.setVisibility(0);
            a(i2, bVar, i4);
            bVar.zkD.setVisibility(8);
            bVar.zkG.setVisibility(8);
        } else {
            bVar.zkz.setVisibility(8);
            bVar.zkD.setVisibility(8);
            bVar.zkG.setVisibility(8);
            bVar.zkA.setVisibility(8);
            bVar.zkB.setVisibility(8);
            bVar.zkC.setVisibility(8);
        }
        if (i2 == getCount() - 1) {
            bVar.zkH.setBackgroundColor(e.eht());
            bVar.zkH.setVisibility(0);
        } else {
            bVar.zkH.setVisibility(8);
        }
        AppMethodBeat.o(66039);
        return view;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00fb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r10, com.tencent.mm.plugin.mall.ui.b.C1469b r11, int r12) {
        /*
        // Method dump skipped, instructions count: 463
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mall.ui.b.a(int, com.tencent.mm.plugin.mall.ui.b$b, int):void");
    }

    private View z(ViewGroup viewGroup) {
        AppMethodBeat.i(66041);
        a aVar = new a();
        View inflate = this.mInflater.inflate(R.layout.b5c, viewGroup, false);
        aVar.zko = inflate.findViewById(R.id.f76);
        aVar.zkp = (ImageView) inflate.findViewById(R.id.f73);
        aVar.zkr = (TextView) inflate.findViewById(R.id.f78);
        aVar.zks = (TextView) inflate.findViewById(R.id.f72);
        aVar.zkq = (ImageView) inflate.findViewById(R.id.fxf);
        aVar.zkv = (ImageView) inflate.findViewById(R.id.bsn);
        aVar.zkw = (ImageView) inflate.findViewById(R.id.bsl);
        aVar.zkx = (ImageView) inflate.findViewById(R.id.bsd);
        aVar.zky = (ImageView) inflate.findViewById(R.id.bsh);
        inflate.setTag(aVar);
        AppMethodBeat.o(66041);
        return inflate;
    }

    private static void a(a aVar) {
        AppMethodBeat.i(66042);
        aVar.zkv.setVisibility(0);
        aVar.zkw.setVisibility(4);
        aVar.zkx.setVisibility(4);
        aVar.zky.setVisibility(4);
        AppMethodBeat.o(66042);
    }

    private static void a(a aVar, int i2, int i3) {
        AppMethodBeat.i(66043);
        aVar.zky.setVisibility(4);
        if (i2 == 0) {
            aVar.zkw.setVisibility(0);
        } else if (i2 == 1) {
            aVar.zkw.setVisibility(0);
        } else if (i2 == 2) {
            aVar.zkw.setVisibility(4);
        }
        if (i3 == 0) {
            aVar.zkv.setVisibility(0);
            aVar.zkx.setVisibility(4);
            AppMethodBeat.o(66043);
        } else if (i3 == 1) {
            aVar.zkv.setVisibility(4);
            aVar.zkx.setVisibility(0);
            AppMethodBeat.o(66043);
        } else {
            aVar.zkv.setVisibility(0);
            aVar.zkx.setVisibility(0);
            AppMethodBeat.o(66043);
        }
    }

    private boolean egR() {
        ArrayList<c> arrayList;
        AppMethodBeat.i(66044);
        if (this.zke.size() > 3 && (arrayList = this.zke.get(3)) != null && arrayList.size() > 0) {
            int i2 = arrayList.get(0).zkI.type;
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.zkI.type != i2) {
                    break;
                } else if (a(next.zkI)) {
                    AppMethodBeat.o(66044);
                    return true;
                }
            }
        }
        AppMethodBeat.o(66044);
        return false;
    }

    public static boolean a(MallFunction mallFunction) {
        AppMethodBeat.i(66045);
        if (mallFunction.Icf == null || Util.isNullOrNil(mallFunction.Icf.Icn) || !b(mallFunction) || com.tencent.mm.plugin.wallet_core.model.mall.d.fSk().aVx(mallFunction.kHR) == null) {
            AppMethodBeat.o(66045);
            return false;
        }
        AppMethodBeat.o(66045);
        return true;
    }

    private void a(View view, c cVar, int i2, int i3) {
        AppMethodBeat.i(66046);
        if (view == null) {
            AppMethodBeat.o(66046);
            return;
        }
        a aVar = (a) view.getTag();
        final MallFunction mallFunction = cVar.zkI;
        final int i4 = cVar.zkJ;
        aVar.zku = mallFunction.zku;
        aVar.zkt = mallFunction.zkt;
        com.tencent.mm.plugin.mall.b.a.d(aVar.zkp, aVar.zkt, R.raw.mall_index_icon_default);
        aVar.zkr.setText(mallFunction.edq);
        aVar.zkq.setVisibility(8);
        if (mallFunction.Icf == null || Util.isNullOrNil(mallFunction.Icf.Icn) || !b(mallFunction)) {
            if (mallFunction.Icf == null || mallFunction.Icf.Icr != 1) {
                aVar.zks.setText("");
                aVar.zks.setVisibility(4);
            } else {
                aVar.zks.setText(mallFunction.Icf.Icn);
                aVar.zks.setVisibility(0);
            }
            aVar.zkq.setImageBitmap(null);
            aVar.zkq.setVisibility(8);
        } else {
            if (com.tencent.mm.plugin.wallet_core.model.mall.d.fSk().aVx(mallFunction.kHR) != null) {
                Log.w("MicroMsg.FunctionListAdapter", "show the news : " + com.tencent.mm.plugin.wallet_core.model.mall.d.fSk().aVx(mallFunction.kHR).Icn);
                aVar.zks.setText(mallFunction.Icf.Icn);
                aVar.zks.setVisibility(0);
            } else {
                aVar.zks.setVisibility(4);
            }
            com.tencent.mm.plugin.mall.b.a.t(aVar.zkq, aVar.zku);
            aVar.zkq.setVisibility(0);
        }
        view.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.mall.ui.b.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(66034);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/FunctionListAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.v("MicroMsg.FunctionListAdapter", "on Click");
                if (b.this.zkf != null) {
                    b.this.zkf.a(i4, mallFunction);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/FunctionListAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(66034);
            }
        });
        aVar.zko.setVisibility(0);
        view.setEnabled(true);
        view.setClickable(true);
        a(aVar, i2, i3);
        AppMethodBeat.o(66046);
    }

    private static boolean b(MallFunction mallFunction) {
        AppMethodBeat.i(66047);
        MallNews aVx = com.tencent.mm.plugin.wallet_core.model.mall.d.fSk().aVx(mallFunction.kHR);
        if (aVx == null || Util.isNullOrNil(aVx.FJm) || !aVx.FJm.equals(mallFunction.Icf.FJm)) {
            Log.d("MicroMsg.FunctionListAdapter", "old news null or should be replaced %s %s", mallFunction.Icf.FJm, mallFunction.edq);
            com.tencent.mm.plugin.wallet_core.model.mall.d.fSk().b(mallFunction.Icf);
            AppMethodBeat.o(66047);
            return true;
        } else if (aVx == null) {
            AppMethodBeat.o(66047);
            return false;
        } else if (!AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(aVx.Icl)) {
            Log.d("MicroMsg.FunctionListAdapter", "still old news or clicked, then should not show");
            AppMethodBeat.o(66047);
            return false;
        } else {
            Log.d("MicroMsg.FunctionListAdapter", "still old news and should show");
            AppMethodBeat.o(66047);
            return true;
        }
    }

    private String Qg(int i2) {
        AppMethodBeat.i(66048);
        if (this.zjr == null) {
            AppMethodBeat.o(66048);
            return null;
        }
        String str = this.zjr.get(i2);
        AppMethodBeat.o(66048);
        return str;
    }

    /* access modifiers changed from: package-private */
    public class a {
        public View zko = null;
        public ImageView zkp = null;
        public ImageView zkq = null;
        public TextView zkr = null;
        public TextView zks = null;
        public String zkt = null;
        public String zku = null;
        public ImageView zkv = null;
        public ImageView zkw = null;
        public ImageView zkx = null;
        public ImageView zky = null;

        a() {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.mall.ui.b$b  reason: collision with other inner class name */
    public class C1469b {
        TextView zkA;
        View zkB;
        View zkC;
        View zkD;
        ImageView zkE;
        TextView zkF;
        View zkG = null;
        View zkH;
        LinearLayout zkz;

        C1469b() {
        }
    }

    /* access modifiers changed from: package-private */
    public class c {
        MallFunction zkI;
        int zkJ;

        c() {
        }
    }
}
