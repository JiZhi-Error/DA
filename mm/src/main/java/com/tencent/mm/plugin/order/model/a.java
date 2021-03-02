package com.tencent.mm.plugin.order.model;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.contact.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.order.ui.a.e;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;
import java.util.List;

public final class a {

    /* renamed from: com.tencent.mm.plugin.order.model.a$a  reason: collision with other inner class name */
    public interface AbstractC1568a {
        List<Preference> a(Context context, f fVar, MallTransactionObject mallTransactionObject);
    }

    public static e a(final Context context, final MallTransactionObject mallTransactionObject) {
        AppMethodBeat.i(66656);
        e eVar = new e(context);
        if (!Util.isNullOrNil(mallTransactionObject.AOu)) {
            eVar.AQz = context.getString(R.string.ikm);
        } else {
            eVar.AQz = context.getString(R.string.ikp);
        }
        eVar.mOnClickListener = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.order.model.a.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(66655);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/model/MallOrderPreferenceManager$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                if (!Util.isNullOrNil(mallTransactionObject.dCu)) {
                    linkedList2.add(0);
                    linkedList.add(context.getString(R.string.ikn));
                }
                if (!Util.isNullOrNil(mallTransactionObject.ANP)) {
                    linkedList2.add(1);
                    linkedList.add(context.getString(R.string.iko));
                }
                if (!Util.isNullOrNil(mallTransactionObject.AOu)) {
                    linkedList2.add(2);
                    linkedList.add(context.getString(R.string.ikq));
                }
                if (linkedList2.size() == 1) {
                    a.a(((Integer) linkedList2.get(0)).intValue(), context, mallTransactionObject);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/model/MallOrderPreferenceManager$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(66655);
                    return;
                }
                h.b(context, (String) null, linkedList, linkedList2, (String) null, new h.e() {
                    /* class com.tencent.mm.plugin.order.model.a.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.h.e
                    public final void cy(int i2, int i3) {
                        AppMethodBeat.i(66654);
                        a.a(i3, context, mallTransactionObject);
                        AppMethodBeat.o(66654);
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/model/MallOrderPreferenceManager$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(66655);
            }
        };
        AppMethodBeat.o(66656);
        return eVar;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(int i2, Context context, MallTransactionObject mallTransactionObject) {
        AppMethodBeat.i(66657);
        switch (i2) {
            case 0:
                g.aAi();
                as Kn = ((l) g.af(l.class)).aSN().Kn(mallTransactionObject.dCu);
                if (Kn == null || !c.oR(Kn.field_type)) {
                    com.tencent.mm.wallet_core.ui.f.am(context, mallTransactionObject.dCu);
                    AppMethodBeat.o(66657);
                    return;
                }
                com.tencent.mm.wallet_core.ui.f.ao(context, mallTransactionObject.dCu);
                AppMethodBeat.o(66657);
                return;
            case 1:
                com.tencent.mm.wallet_core.ui.f.cM(context, mallTransactionObject.ANP);
                AppMethodBeat.o(66657);
                return;
            case 2:
                com.tencent.mm.wallet_core.ui.f.p(context, mallTransactionObject.AOu, false);
                break;
        }
        AppMethodBeat.o(66657);
    }
}
