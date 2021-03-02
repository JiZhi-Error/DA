package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.sortview.a;

public final class f extends com.tencent.mm.ui.base.sortview.a {
    private static a.b pnV;
    int fs;
    long pnZ;
    String poa;
    String ppP;

    public static class a implements a.AbstractC2082a {
        public TextView nnM;
    }

    public f(long j2, int i2, String str) {
        super(2, null);
        this.pnZ = j2;
        this.poa = str;
        this.fs = i2;
    }

    @Override // com.tencent.mm.ui.base.sortview.a
    public final a.b clS() {
        AppMethodBeat.i(5757);
        if (pnV == null) {
            pnV = new a.b() {
                /* class com.tencent.mm.plugin.brandservice.ui.f.AnonymousClass1 */

                @Override // com.tencent.mm.ui.base.sortview.a.b
                public final boolean a(Context context, com.tencent.mm.ui.base.sortview.a aVar, Object... objArr) {
                    int i2;
                    AppMethodBeat.i(5753);
                    if (!(context == null || aVar == null)) {
                        if (objArr == null || objArr.length < 2 || !(objArr[1] instanceof Integer)) {
                            i2 = 0;
                        } else {
                            i2 = ((Integer) objArr[1]).intValue();
                        }
                        f fVar = (f) aVar;
                        Intent intent = new Intent(context, BizSearchDetailPageUI.class);
                        intent.putExtra("keyword", fVar.poa);
                        intent.putExtra("businessType", fVar.pnZ);
                        intent.putExtra("offset", fVar.fs);
                        intent.putExtra("showEditText", true);
                        intent.putExtra("fromScene", i2);
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/brandservice/ui/ReadMoreBtnDataItem$1", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/ui/base/sortview/BaseDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/brandservice/ui/ReadMoreBtnDataItem$1", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/ui/base/sortview/BaseDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    AppMethodBeat.o(5753);
                    return true;
                }

                @Override // com.tencent.mm.ui.base.sortview.a.b
                public final View c(Context context, View view) {
                    AppMethodBeat.i(5754);
                    if (view == null) {
                        view = View.inflate(context, R.layout.bp4, null);
                    }
                    AppMethodBeat.o(5754);
                    return view;
                }

                @Override // com.tencent.mm.ui.base.sortview.a.b
                public final void a(Context context, a.AbstractC2082a aVar, com.tencent.mm.ui.base.sortview.a aVar2) {
                    AppMethodBeat.i(5755);
                    if (context == null || aVar == null || aVar2 == null) {
                        Log.e("MicroMsg.ReadMoreBtnDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
                        AppMethodBeat.o(5755);
                    } else if (!(aVar instanceof a)) {
                        Log.e("MicroMsg.ReadMoreBtnDataItem", "The ViewHolder is not a instance of MoreBtnViewHolder.");
                        AppMethodBeat.o(5755);
                    } else if (!(aVar2 instanceof f)) {
                        Log.e("MicroMsg.ReadMoreBtnDataItem", "The DataItem is not a instance of MoreBtnDataItem.");
                        AppMethodBeat.o(5755);
                    } else {
                        ((a) aVar).nnM.setText(((f) aVar2).ppP);
                        AppMethodBeat.o(5755);
                    }
                }

                @Override // com.tencent.mm.ui.base.sortview.a.b
                public final void a(View view, a.AbstractC2082a aVar) {
                    AppMethodBeat.i(5756);
                    if (!(view == null || aVar == null || !(aVar instanceof a))) {
                        ((a) aVar).nnM = (TextView) view.findViewById(R.id.iow);
                    }
                    AppMethodBeat.o(5756);
                }
            };
        }
        a.b bVar = pnV;
        AppMethodBeat.o(5757);
        return bVar;
    }

    @Override // com.tencent.mm.ui.base.sortview.a
    public final a.AbstractC2082a clT() {
        AppMethodBeat.i(5758);
        a aVar = new a();
        AppMethodBeat.o(5758);
        return aVar;
    }

    @Override // com.tencent.mm.ui.base.sortview.a
    public final void a(Context context, a.AbstractC2082a aVar, Object... objArr) {
        this.ppP = "";
    }
}
