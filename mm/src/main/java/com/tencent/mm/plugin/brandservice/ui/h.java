package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.sortview.a;

public final class h extends com.tencent.mm.ui.base.sortview.a {
    private static a.b pnV;

    public static class a implements a.AbstractC2082a {
    }

    public h(Object obj) {
        super(0, obj);
        this.OZN = true;
    }

    @Override // com.tencent.mm.ui.base.sortview.a
    public final a.b clS() {
        AppMethodBeat.i(5793);
        if (pnV == null) {
            pnV = new a.b() {
                /* class com.tencent.mm.plugin.brandservice.ui.h.AnonymousClass1 */

                @Override // com.tencent.mm.ui.base.sortview.a.b
                public final boolean a(Context context, com.tencent.mm.ui.base.sortview.a aVar, Object... objArr) {
                    return true;
                }

                @Override // com.tencent.mm.ui.base.sortview.a.b
                public final View c(Context context, View view) {
                    AppMethodBeat.i(5792);
                    if (view == null) {
                        view = new View(context);
                    }
                    AppMethodBeat.o(5792);
                    return view;
                }

                @Override // com.tencent.mm.ui.base.sortview.a.b
                public final void a(Context context, a.AbstractC2082a aVar, com.tencent.mm.ui.base.sortview.a aVar2) {
                }

                @Override // com.tencent.mm.ui.base.sortview.a.b
                public final void a(View view, a.AbstractC2082a aVar) {
                }
            };
        }
        a.b bVar = pnV;
        AppMethodBeat.o(5793);
        return bVar;
    }

    @Override // com.tencent.mm.ui.base.sortview.a
    public final a.AbstractC2082a clT() {
        AppMethodBeat.i(5794);
        a aVar = new a();
        AppMethodBeat.o(5794);
        return aVar;
    }

    @Override // com.tencent.mm.ui.base.sortview.a
    public final void a(Context context, a.AbstractC2082a aVar, Object... objArr) {
    }
}
