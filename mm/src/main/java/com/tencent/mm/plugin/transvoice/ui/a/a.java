package com.tencent.mm.plugin.transvoice.ui.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.List;

public final class a extends RecyclerView.a<b> {
    public int Gwo = -1;
    private ImageView Gwp = null;
    public List<C1843a> gzD = new ArrayList();

    public a() {
        AppMethodBeat.i(185311);
        AppMethodBeat.o(185311);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(b bVar, int i2) {
        AppMethodBeat.i(185314);
        final b bVar2 = bVar;
        String str = this.gzD.get(i2).Gws;
        final int i3 = this.gzD.get(i2).Gwt;
        bVar2.titleTv.setText(str);
        if (this.Gwo == i3) {
            bVar2.gBZ.setVisibility(0);
            this.Gwp = bVar2.gBZ;
        } else {
            bVar2.gBZ.setVisibility(8);
        }
        bVar2.aus.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.transvoice.ui.a.a.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(185309);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/adapter/LanguageChoiceAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (a.this.Gwp != null) {
                    a.this.Gwp.setVisibility(8);
                }
                bVar2.gBZ.setVisibility(0);
                a.this.Gwp = bVar2.gBZ;
                a.this.Gwo = i3;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/adapter/LanguageChoiceAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(185309);
            }
        });
        AppMethodBeat.o(185314);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(185312);
        int size = this.gzD.size();
        AppMethodBeat.o(185312);
        return size;
    }

    public final void hy(List<C1843a> list) {
        AppMethodBeat.i(185313);
        this.gzD.clear();
        this.gzD.addAll(list);
        AppMethodBeat.o(185313);
    }

    class b extends RecyclerView.v {
        public ImageView gBZ = null;
        public TextView titleTv = null;

        public b(View view) {
            super(view);
            AppMethodBeat.i(185310);
            this.titleTv = (TextView) view.findViewById(R.id.fye);
            this.gBZ = (ImageView) view.findViewById(R.id.fy_);
            AppMethodBeat.o(185310);
        }
    }

    /* renamed from: com.tencent.mm.plugin.transvoice.ui.a.a$a  reason: collision with other inner class name */
    public static class C1843a {
        public String Gws = "";
        public int Gwt = -1;

        public C1843a(String str, int i2) {
            this.Gws = str;
            this.Gwt = i2;
        }
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ b a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(185315);
        b bVar = new b(View.inflate(viewGroup.getContext(), R.layout.bg2, null));
        AppMethodBeat.o(185315);
        return bVar;
    }
}
