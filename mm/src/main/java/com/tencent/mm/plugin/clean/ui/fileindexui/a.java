package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.List;

public final class a extends BaseAdapter {
    private List<c> dataList;
    HashSet<Integer> oMG = new HashSet<>();
    CleanChattingUI qqi;

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(22855);
        c EO = EO(i2);
        AppMethodBeat.o(22855);
        return EO;
    }

    public a(CleanChattingUI cleanChattingUI, List<c> list) {
        AppMethodBeat.i(22850);
        this.qqi = cleanChattingUI;
        this.dataList = list;
        AppMethodBeat.o(22850);
    }

    public final int getCount() {
        AppMethodBeat.i(22851);
        int size = this.dataList.size();
        AppMethodBeat.o(22851);
        return size;
    }

    public final c EO(int i2) {
        AppMethodBeat.i(22852);
        if (i2 < 0 || i2 >= this.dataList.size()) {
            AppMethodBeat.o(22852);
            return null;
        }
        c cVar = this.dataList.get(i2);
        AppMethodBeat.o(22852);
        return cVar;
    }

    public final long getItemId(int i2) {
        return -1;
    }

    public final View getView(final int i2, View view, ViewGroup viewGroup) {
        C0925a aVar;
        AppMethodBeat.i(22853);
        if (view == null) {
            view = this.qqi.getLayoutInflater().inflate(R.layout.up, viewGroup, false);
            C0925a aVar2 = new C0925a();
            aVar2.gvv = (ImageView) view.findViewById(R.id.x1);
            aVar2.jVO = (TextView) view.findViewById(R.id.ir3);
            aVar2.jBR = (TextView) view.findViewById(R.id.bn6);
            aVar2.jVQ = (CheckBox) view.findViewById(R.id.hhc);
            aVar2.oMI = (RelativeLayout) view.findViewById(R.id.hhd);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (C0925a) view.getTag();
        }
        aVar.oMI.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.clean.ui.fileindexui.a.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(22849);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (a.this.oMG.contains(Integer.valueOf(i2))) {
                    a.this.oMG.remove(Integer.valueOf(i2));
                } else {
                    a.this.oMG.add(Integer.valueOf(i2));
                }
                a.this.notifyDataSetChanged();
                a.this.qqi.a(a.this.oMG);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(22849);
            }
        });
        c EO = EO(i2);
        if (EO == null) {
            Log.e("MicroMsg.CleanChattingAdapter", "get item is null. [%d]", Integer.valueOf(i2));
            EO = new c();
            EO.size = 0;
            EO.username = "";
        }
        a.b.c(aVar.gvv, EO.username);
        aVar.jVO.setText(Util.getSizeKB(EO.size));
        if (ab.Eq(EO.username)) {
            aVar.jBR.setText(l.b(this.qqi, aa.getDisplayName(EO.username, EO.username), aVar.jBR.getTextSize()));
        } else {
            aVar.jBR.setText(l.b(this.qqi, aa.getDisplayName(EO.username), aVar.jBR.getTextSize()));
        }
        if (this.oMG.contains(Integer.valueOf(i2))) {
            aVar.jVQ.setChecked(true);
        } else {
            aVar.jVQ.setChecked(false);
        }
        AppMethodBeat.o(22853);
        return view;
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.a$a  reason: collision with other inner class name */
    class C0925a {
        ImageView gvv;
        TextView jBR;
        TextView jVO;
        CheckBox jVQ;
        RelativeLayout oMI;

        C0925a() {
        }
    }

    public final void cyS() {
        AppMethodBeat.i(22854);
        this.oMG.clear();
        this.qqi.a(this.oMG);
        AppMethodBeat.o(22854);
    }
}
