package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.b;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.and;
import java.util.HashSet;
import java.util.LinkedList;

public final class n extends b {
    private HashSet<Long> tlU = new HashSet<>();
    final int tlc;

    public static class a extends b.C1049b {
        TextView tlW;
        ImageView tlo;
    }

    public n(o oVar) {
        super(oVar);
        AppMethodBeat.i(107483);
        this.tlc = com.tencent.mm.cb.a.aG(oVar.context, R.dimen.eb);
        AppMethodBeat.o(107483);
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final View a(View view, ViewGroup viewGroup, final g gVar) {
        a aVar;
        AppMethodBeat.i(107484);
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, R.layout.a7l, null), aVar, gVar);
            aVar.tlo = (ImageView) view.findViewById(R.id.cc_);
            aVar.tlW = (TextView) view.findViewById(R.id.cdv);
        } else {
            aVar = (a) view.getTag();
        }
        LinkedList<aml> linkedList = gVar.field_favProto.ppH;
        if (linkedList.size() > 0) {
            int i2 = linkedList.getFirst().duration;
            aVar.tlW.setText(m.J(context, i2));
            if (gVar != null && i2 <= 1 && !this.tlU.contains(Long.valueOf(gVar.field_localId))) {
                this.tlU.add(Long.valueOf(gVar.field_localId));
                com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.fav.ui.d.n.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(107482);
                        com.tencent.mm.plugin.fav.a.b.o(gVar);
                        AppMethodBeat.o(107482);
                    }
                });
            }
            aVar.tlW.setVisibility(0);
        } else {
            aVar.tlW.setVisibility(8);
        }
        a(aVar, gVar);
        this.tdg.a(aVar.tlo, com.tencent.mm.plugin.fav.a.b.c(gVar), gVar, R.raw.app_attach_file_icon_video, this.tlc, this.tlc);
        AppMethodBeat.o(107484);
        return view;
    }

    @Override // com.tencent.mm.plugin.fav.ui.d.b
    public final void a(View view, and and) {
        AppMethodBeat.i(107485);
        ((y) com.tencent.mm.kernel.g.af(y.class)).a(view.getContext(), ((a) view.getTag()).tbr, and);
        AppMethodBeat.o(107485);
    }
}
