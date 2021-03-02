package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bb.r;
import com.tencent.mm.bb.v;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.ui.g;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.he;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.bp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f extends BaseAdapter {
    private final b EnA;
    private final g EnB;
    final a EnC;
    he EnD;
    final Map<Integer, Integer> Enw = new HashMap();
    final Map<Integer, Integer> Enx = new HashMap();
    int Eny = 0;
    int Enz = 0;
    private final Activity dKq;
    private final MMHandler handler = new MMHandler();
    final List<cnb> list = new ArrayList();
    private String yFy = "";

    public interface a {
        void a(he heVar);

        void b(he heVar);

        void ffj();
    }

    static abstract class b {
        View.OnClickListener EnF = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.f.b.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(97704);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.this.EnI = (a) view.getTag();
                b.this.Zt(b.this.EnI.position);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(97704);
            }
        };
        View.OnClickListener EnG = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.f.b.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(97705);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.this.EnI = (a) view.getTag();
                b.this.Zt(b.this.EnI.position);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(97705);
            }
        };
        View.OnClickListener EnH = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.f.b.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(97706);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.this.EnI = (a) view.getTag();
                b.this.Zt(b.this.EnI.position);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/ArtistAdapter$SnsEventListeners$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(97706);
            }
        };
        public a EnI = new a();

        public static class a {
            public String dRS;
            public int position;
        }

        public abstract void Zt(int i2);
    }

    public f(Activity activity, String str, b bVar, a aVar) {
        AppMethodBeat.i(97707);
        this.dKq = activity;
        this.yFy = str;
        this.EnA = bVar;
        this.EnC = aVar;
        this.EnB = new g(new g.a() {
            /* class com.tencent.mm.plugin.sns.ui.f.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.sns.ui.g.a
            public final void a(List<cnb> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, int i2, int i3, he heVar) {
                AppMethodBeat.i(97702);
                Log.d("MicroMsg.ArtistAdapter", "onFinishFixPos");
                f fVar = f.this;
                if (list == null || list.size() <= 0) {
                    AppMethodBeat.o(97702);
                    return;
                }
                try {
                    fVar.EnD = (he) new he().parseFrom(heVar.toByteArray());
                    fVar.EnC.a(fVar.EnD);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.ArtistAdapter", e2, "", new Object[0]);
                }
                Log.d("MicroMsg.ArtistAdapter", "copy list info");
                int size = list.size();
                fVar.list.clear();
                fVar.Enw.clear();
                fVar.Enx.clear();
                for (int i4 = 0; i4 < size; i4++) {
                    cnb cnb = list.get(i4);
                    fVar.list.add(n.a(cnb.Id, cnb.oUv, cnb.Url, cnb.Msz, cnb.Mcw, cnb.MsA, cnb.Desc));
                }
                for (Integer num : map.keySet()) {
                    int intValue = num.intValue();
                    fVar.Enw.put(Integer.valueOf(intValue), Integer.valueOf(map.get(Integer.valueOf(intValue)).intValue()));
                }
                for (Integer num2 : map2.keySet()) {
                    int intValue2 = num2.intValue();
                    fVar.Enx.put(Integer.valueOf(intValue2), Integer.valueOf(map2.get(Integer.valueOf(intValue2)).intValue()));
                }
                list.clear();
                map.clear();
                map2.clear();
                fVar.Enz = i2;
                fVar.Eny = i3;
                Log.d("MicroMsg.ArtistAdapter", "reallyCount " + i2 + " icount " + i3);
                fVar.notifyDataSetChanged();
                AppMethodBeat.o(97702);
            }

            @Override // com.tencent.mm.plugin.sns.ui.g.a
            public final void ffi() {
                AppMethodBeat.i(97703);
                f fVar = f.this;
                if (fVar.EnC != null) {
                    fVar.EnC.ffj();
                }
                AppMethodBeat.o(97703);
            }
        });
        anp();
        AppMethodBeat.o(97707);
    }

    public final void anp() {
        AppMethodBeat.i(97708);
        if (this.EnB != null) {
            v.bev();
            String bes = r.bes();
            Log.d("MicroMsg.ArtistAdapter", "packgePath: ".concat(String.valueOf(bes)));
            this.EnB.kO(this.yFy, bes);
        }
        AppMethodBeat.o(97708);
    }

    public final int getCount() {
        return this.Eny;
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(97709);
        cnb cnb = this.list.get(i2);
        AppMethodBeat.o(97709);
        return cnb;
    }

    public final long getItemId(int i2) {
        return 0;
    }

    private void a(int i2, ImageView imageView) {
        AppMethodBeat.i(97711);
        imageView.setVisibility(0);
        b.a aVar = new b.a();
        aVar.dRS = "";
        aVar.position = i2;
        imageView.setTag(aVar);
        aj.faL().b((cnb) getItem(i2), imageView, this.dKq.hashCode(), bp.Oqt);
        AppMethodBeat.o(97711);
    }

    class c {
        TextView EnK;
        ImageView EnL;
        ImageView EnM;
        ImageView EnN;
        LinearLayout EnO;
        View EnP;
        TextView hbb;

        c() {
        }
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        c cVar;
        int i3;
        String str;
        int i4;
        AppMethodBeat.i(97710);
        if (view == null) {
            cVar = new c();
            view = View.inflate(this.dKq, R.layout.bv_, null);
            cVar.hbb = (TextView) view.findViewById(R.id.i19);
            cVar.EnK = (TextView) view.findViewById(R.id.i1_);
            cVar.EnL = (ImageView) view.findViewById(R.id.dx3);
            cVar.EnM = (ImageView) view.findViewById(R.id.dx4);
            cVar.EnN = (ImageView) view.findViewById(R.id.dx5);
            cVar.EnO = (LinearLayout) view.findViewById(R.id.ed1);
            cVar.EnP = view.findViewById(R.id.ebv);
            cVar.EnL.setOnClickListener(this.EnA.EnF);
            cVar.EnM.setOnClickListener(this.EnA.EnG);
            cVar.EnN.setOnClickListener(this.EnA.EnH);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        if (this.Enw.get(Integer.valueOf(i2)) != null) {
            i3 = this.Enw.get(Integer.valueOf(i2)).intValue();
        } else {
            i3 = -1;
        }
        cVar.EnL.setVisibility(8);
        cVar.EnM.setVisibility(8);
        cVar.EnN.setVisibility(8);
        cVar.EnP.setVisibility(8);
        if (f.this.yFy.equals(LocaleUtil.ENGLISH)) {
            cVar.hbb.setVisibility(8);
            cVar.EnK.setVisibility(4);
        } else {
            cVar.hbb.setVisibility(4);
            cVar.EnK.setVisibility(8);
        }
        if (i3 >= this.Enz || i3 == -1) {
            view.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
            view.setVisibility(8);
        } else {
            if (i3 - 1 >= 0) {
                str = ((cnb) getItem(i3 - 1)).Desc;
            } else {
                str = "";
            }
            view.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            view.setVisibility(0);
            if (this.Enx.get(Integer.valueOf(i2)) != null) {
                i4 = this.Enx.get(Integer.valueOf(i2)).intValue();
            } else {
                i4 = 1;
            }
            cnb cnb = (cnb) getItem(i3);
            if (cnb.Desc.equals("") || !cnb.Desc.equals(str)) {
                if (this.yFy.equals(LocaleUtil.ENGLISH)) {
                    cVar.EnK.setVisibility(0);
                    cVar.EnK.setText(cnb.Desc);
                    cVar.EnP.setVisibility(0);
                } else {
                    cVar.hbb.setVisibility(0);
                    cVar.hbb.setText(cnb.Desc);
                    cVar.EnP.setVisibility(0);
                }
            }
            if (i4 > 0) {
                a(i3, cVar.EnL);
            }
            if (i4 >= 2) {
                a(i3 + 1, cVar.EnM);
            }
            if (i4 >= 3) {
                a(i3 + 2, cVar.EnN);
            }
            if (this.EnC != null) {
                this.EnC.b(this.EnD);
            }
        }
        AppMethodBeat.o(97710);
        return view;
    }
}
