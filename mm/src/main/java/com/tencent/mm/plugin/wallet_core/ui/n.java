package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet.a.t;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.i;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class n extends i {
    private d HGS;
    private MaxListView IgM = ((MaxListView) this.jBN.findViewById(R.id.jfs));
    private TextView IgN = ((TextView) this.jBN.findViewById(R.id.jfp));
    private a IgO = new a();
    private b IgP;
    private View jBN;
    private LayoutInflater mInflater;

    public interface b {
        void a(FavorPayInfo favorPayInfo);
    }

    static /* synthetic */ void a(n nVar) {
        AppMethodBeat.i(70954);
        nVar.fSR();
        AppMethodBeat.o(70954);
    }

    private n(Context context) {
        super(context, R.style.a66);
        AppMethodBeat.i(70947);
        this.mInflater = LayoutInflater.from(context);
        this.jBN = LayoutInflater.from(context).inflate(R.layout.c8w, (ViewGroup) null);
        this.IgM.setAdapter((ListAdapter) this.IgO);
        this.jBN.findViewById(R.id.jfq).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.n.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(70940);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletFavorDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                n.a(n.this);
                n.this.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletFavorDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70940);
            }
        });
        AppMethodBeat.o(70947);
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(70948);
        super.onCreate(bundle);
        setContentView(this.jBN);
        AppMethodBeat.o(70948);
    }

    @Override // com.tencent.mm.ui.base.i
    public final void dismiss() {
        AppMethodBeat.i(70949);
        try {
            super.dismiss();
            AppMethodBeat.o(70949);
        } catch (Exception e2) {
            Log.e("MicroMsg.WalletFavorDialog", "dismiss exception, e = " + e2.getMessage());
            AppMethodBeat.o(70949);
        }
    }

    public static n a(Context context, Orders orders, String str, b bVar, DialogInterface.OnCancelListener onCancelListener) {
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(70950);
        n nVar = new n(context);
        nVar.setOnCancelListener(onCancelListener);
        nVar.setCancelable(true);
        nVar.setCanceledOnTouchOutside(false);
        nVar.HGS = e.INSTANCE.a(orders);
        if (nVar.HGS == null) {
            Log.w("MicroMsg.WalletFavorDialog", "mFavorLogicHelper null & dismiss");
            nVar.dismiss();
        } else {
            a aVar = nVar.IgO;
            h hVar = n.this.HGS.IcO;
            String aVN = n.this.HGS.aVN(str);
            aVar.IgS = n.this.HGS.fSz();
            aVar.IgT = n.this.HGS.aVJ(aVN);
            aVar.IgR = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= aVar.IgS.size()) {
                    break;
                }
                if (aVar.IgS.get(i2).HFq != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    aVar.IgR = i2;
                    break;
                }
                i2++;
            }
            LinkedList linkedList = new LinkedList();
            if (aVar.IgS != null) {
                for (int i3 = 0; i3 < aVar.IgS.size(); i3++) {
                    linkedList.add(aVar.IgS.get(i3).HEn);
                }
                LinkedList linkedList2 = new LinkedList();
                if (!(hVar == null || hVar.HEu == null)) {
                    for (int i4 = 0; i4 < hVar.HEu.size(); i4++) {
                        String str2 = hVar.HEu.get(i4).HEn;
                        if (!linkedList.contains(str2)) {
                            linkedList2.add(str2);
                        }
                    }
                }
                LinkedList linkedList3 = new LinkedList();
                if (hVar == null || hVar.HEv == null || hVar.HEv.HEH == null) {
                    Log.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] favorInfo.favorComposeList or favorInfo.favorComposeList.favorComposeInfo null");
                    z = false;
                } else {
                    LinkedList<j> linkedList4 = hVar.HEv.HEH;
                    for (int i5 = 0; i5 < linkedList4.size(); i5++) {
                        String str3 = linkedList4.get(i5).HEJ;
                        int i6 = 0;
                        while (true) {
                            if (i6 >= linkedList2.size()) {
                                z2 = false;
                                break;
                            } else if (str3.contains((CharSequence) linkedList2.get(i6))) {
                                z2 = true;
                                break;
                            } else {
                                i6++;
                            }
                        }
                        if (!z2) {
                            linkedList3.add(str3);
                        }
                    }
                    LinkedList linkedList5 = new LinkedList();
                    if (!Util.isNullOrNil(aVN) && !aVN.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        String[] split = aVN.split("-");
                        if (split != null) {
                            for (String str4 : split) {
                                linkedList5.add(str4);
                            }
                        } else {
                            Log.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] preKeyArr null");
                            z = false;
                        }
                    }
                    aVar.IgU.f(linkedList, linkedList5, linkedList3);
                    z = true;
                }
            } else {
                Log.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] mFavorList null");
                z = false;
            }
            if (!z) {
                Log.w("MicroMsg.WalletFavorDialog", "initFavorInfo failed & dismiss");
                nVar.dismiss();
            } else {
                nVar.IgN.setText(R.string.icj);
                nVar.IgM.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.n.AnonymousClass2 */

                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                        AppMethodBeat.i(70941);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(adapterView);
                        bVar.bm(view);
                        bVar.pH(i2);
                        bVar.zo(j2);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletFavorDialog$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                        a aVar = n.this.IgO;
                        p<String> pVar = aVar.IgU;
                        if (i2 < pVar.HYg.size()) {
                            p.a aVar2 = pVar.HYg.get(i2).HYo;
                            p.a aVar3 = p.a.CHECKED;
                            for (int i3 = 0; i3 < pVar.HYg.size(); i3++) {
                                pVar.a(i3, p.a.UNCHECKED);
                            }
                            switch (p.AnonymousClass1.HYi[aVar2.ordinal()]) {
                                case 1:
                                    pVar.a(i2, p.a.CHECKED);
                                    break;
                                case 2:
                                    pVar.a(i2, p.a.UNCHECKED);
                                    break;
                            }
                        }
                        aVar.notifyDataSetChanged();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletFavorDialog$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(70941);
                    }
                });
            }
        }
        nVar.IgP = bVar;
        nVar.show();
        com.tencent.mm.ui.base.h.a(context, nVar);
        AppMethodBeat.o(70950);
        return nVar;
    }

    public final void setCancelable(boolean z) {
        AppMethodBeat.i(70951);
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
        AppMethodBeat.o(70951);
    }

    private void fSR() {
        AppMethodBeat.i(70952);
        Log.d("MicroMsg.WalletFavorDialog", "On selection done");
        if (this.IgO != null) {
            p<String> pVar = this.IgO.IgU;
            this.IgP.a(this.HGS.aVM(pVar.a(pVar.HYg, -1)));
        }
        AppMethodBeat.o(70952);
    }

    public final boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(70953);
        if (i2 == 4) {
            fSR();
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(70953);
        return onKeyUp;
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        int IgR = -1;
        List<t> IgS = new LinkedList();
        j IgT = null;
        p<String> IgU = new p<String>() {
            /* class com.tencent.mm.plugin.wallet_core.ui.n.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.wallet_core.model.p
            public final String a(Vector<p<String>.b> vector, int i2) {
                AppMethodBeat.i(70942);
                if (vector == null) {
                    Log.w("MicroMsg.WalletFavorDialog", "func[getComposedKey] keyList null");
                    AppMethodBeat.o(70942);
                    return "";
                }
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < vector.size(); i3++) {
                    p.a aVar = vector.get(i3).HYo;
                    if (i3 == i2 || aVar == p.a.CHECKED) {
                        sb.append(((String) vector.get(i3).HYn) + "-");
                    }
                }
                if (sb.length() == 0) {
                    AppMethodBeat.o(70942);
                    return AppEventsConstants.EVENT_PARAM_VALUE_NO;
                }
                if (sb.length() > 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                String sb2 = sb.toString();
                AppMethodBeat.o(70942);
                return sb2;
            }
        };

        public a() {
            AppMethodBeat.i(70943);
            AppMethodBeat.o(70943);
        }

        public final int getCount() {
            AppMethodBeat.i(70944);
            int size = this.IgS.size();
            AppMethodBeat.o(70944);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(70945);
            t tVar = this.IgS.get(i2);
            AppMethodBeat.o(70945);
            return tVar;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            c cVar;
            f fVar;
            String str;
            String str2;
            AppMethodBeat.i(70946);
            if (view == null) {
                view = n.this.mInflater.inflate(R.layout.c8n, viewGroup, false);
                c cVar2 = new c();
                cVar2.IgW = view.findViewById(R.id.jfb);
                cVar2.mPa = (TextView) view.findViewById(R.id.jfa);
                cVar2.pYW = (TextView) view.findViewById(R.id.jf_);
                cVar2.jVn = (TextView) view.findViewById(R.id.jf9);
                cVar2.IgY = (CheckBox) view.findViewById(R.id.jf8);
                cVar2.IgX = (ImageView) view.findViewById(R.id.jf7);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            t tVar = (t) getItem(i2);
            if (i2 != this.IgR || this.IgR <= 0) {
                cVar.IgW.setVisibility(8);
                cVar.IgX.setVisibility(0);
            } else {
                cVar.IgW.setVisibility(0);
                cVar.IgX.setVisibility(8);
            }
            if (!Util.isNullOrNil(tVar.HFm)) {
                cVar.mPa.setText(tVar.HFm);
                cVar.mPa.setVisibility(0);
            } else {
                cVar.mPa.setVisibility(8);
            }
            String str3 = tVar.HEn;
            if (this.IgT != null && this.IgT.HEL != null) {
                LinkedList<f> linkedList = this.IgT.HEL;
                int i3 = 0;
                while (true) {
                    if (i3 >= linkedList.size()) {
                        break;
                    } else if (str3.equals(linkedList.get(i3).HEn)) {
                        fVar = linkedList.get(i3);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            fVar = null;
            String str4 = tVar.HEo;
            String str5 = tVar.HEp;
            if (fVar != null) {
                str = fVar.HEo;
                str2 = fVar.HEp;
            } else {
                str = str4;
                str2 = str5;
            }
            if (!Util.isNullOrNil(str)) {
                cVar.pYW.setText(str);
                cVar.pYW.setVisibility(0);
            } else {
                cVar.pYW.setVisibility(8);
            }
            if (!Util.isNullOrNil(str2)) {
                cVar.jVn.setText(str2);
                cVar.jVn.setVisibility(0);
            } else {
                cVar.jVn.setVisibility(8);
            }
            p.a aVar = this.IgU.HYg.get(i2).HYo;
            if (aVar == p.a.DISABLED) {
                cVar.IgY.setChecked(false);
                cVar.IgY.setEnabled(false);
            } else {
                cVar.IgY.setEnabled(true);
                if (aVar == p.a.CHECKED) {
                    cVar.IgY.setChecked(true);
                } else {
                    cVar.IgY.setChecked(false);
                }
            }
            AppMethodBeat.o(70946);
            return view;
        }
    }

    static final class c {
        View IgW;
        ImageView IgX;
        CheckBox IgY;
        TextView jVn;
        TextView mPa;
        TextView pYW;

        c() {
        }
    }
}
