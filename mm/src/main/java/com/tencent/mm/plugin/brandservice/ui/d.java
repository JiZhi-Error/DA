package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.sortview.a;

public final class d extends com.tencent.mm.ui.base.sortview.a {
    private static a.b pnV;
    String pnW;

    public static class a implements a.AbstractC2082a {
        public TextView pnP;
    }

    public d(Object obj) {
        super(1, obj);
    }

    @Override // com.tencent.mm.ui.base.sortview.a
    public final a.b clS() {
        AppMethodBeat.i(5680);
        if (pnV == null) {
            pnV = new a.b() {
                /* class com.tencent.mm.plugin.brandservice.ui.d.AnonymousClass1 */

                @Override // com.tencent.mm.ui.base.sortview.a.b
                public final boolean a(Context context, com.tencent.mm.ui.base.sortview.a aVar, Object... objArr) {
                    return true;
                }

                @Override // com.tencent.mm.ui.base.sortview.a.b
                public final View c(Context context, View view) {
                    AppMethodBeat.i(5677);
                    if (view == null) {
                        view = View.inflate(context, R.layout.bp3, null);
                    }
                    AppMethodBeat.o(5677);
                    return view;
                }

                @Override // com.tencent.mm.ui.base.sortview.a.b
                public final void a(Context context, a.AbstractC2082a aVar, com.tencent.mm.ui.base.sortview.a aVar2) {
                    AppMethodBeat.i(5678);
                    if (context == null || aVar == null || aVar2 == null) {
                        Log.e("MicroMsg.CatalogDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
                        AppMethodBeat.o(5678);
                    } else if (!(aVar instanceof a)) {
                        Log.e("MicroMsg.CatalogDataItem", "The ViewHolder is not a instance of CatalogViewHolder.");
                        AppMethodBeat.o(5678);
                    } else if (!(aVar2 instanceof d)) {
                        Log.e("MicroMsg.CatalogDataItem", "The DataItem is not a instance of CatalogDataItem.");
                        AppMethodBeat.o(5678);
                    } else {
                        com.tencent.mm.plugin.brandservice.b.d.c(((a) aVar).pnP, ((d) aVar2).pnW);
                        AppMethodBeat.o(5678);
                    }
                }

                @Override // com.tencent.mm.ui.base.sortview.a.b
                public final void a(View view, a.AbstractC2082a aVar) {
                    AppMethodBeat.i(5679);
                    if (!(view == null || aVar == null || !(aVar instanceof a))) {
                        ((a) aVar).pnP = (TextView) view.findViewById(R.id.apx);
                    }
                    AppMethodBeat.o(5679);
                }
            };
        }
        a.b bVar = pnV;
        AppMethodBeat.o(5680);
        return bVar;
    }

    @Override // com.tencent.mm.ui.base.sortview.a
    public final a.AbstractC2082a clT() {
        AppMethodBeat.i(5681);
        a aVar = new a();
        AppMethodBeat.o(5681);
        return aVar;
    }

    @Override // com.tencent.mm.ui.base.sortview.a
    public final void a(Context context, a.AbstractC2082a aVar, Object... objArr) {
        if (this.data instanceof String) {
            this.pnW = (String) this.data;
        }
    }
}
