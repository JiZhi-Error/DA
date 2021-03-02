package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public final class b implements a.AbstractC1568a {
    @Override // com.tencent.mm.plugin.order.model.a.AbstractC1568a
    public final List<Preference> a(final Context context, final f fVar, final MallTransactionObject mallTransactionObject) {
        String string;
        boolean z;
        AppMethodBeat.i(66804);
        ArrayList arrayList = new ArrayList();
        boolean z2 = mallTransactionObject.dyc == 2;
        if (!Util.isNullOrNil(mallTransactionObject.AOm) && !Util.isNullOrNil(mallTransactionObject.jyi)) {
            d dVar = new d(context);
            dVar.rcG = mallTransactionObject.jyi;
            dVar.mName = mallTransactionObject.AOm;
            dVar.mOnClickListener = new View.OnClickListener() {
                /* class com.tencent.mm.plugin.order.ui.a.b.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(66802);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/preference/FetchOrderPrefFactory$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!Util.isNullOrNil(mallTransactionObject.dCu)) {
                        com.tencent.mm.wallet_core.ui.f.am(context, mallTransactionObject.dCu);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/FetchOrderPrefFactory$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(66802);
                }
            };
            arrayList.add(dVar);
            arrayList.add(new PreferenceSmallCategory(context));
        }
        Log.i("MicroMsg.FetchOrderPrefFactory", "getOrderPrefList() chargeFee is " + mallTransactionObject.AOB + " and fetchTotalFee is " + mallTransactionObject.AOL);
        if (!TextUtils.isEmpty(mallTransactionObject.AOB)) {
            i iVar = new i(context);
            iVar.AQQ = com.tencent.mm.wallet_core.ui.f.d(mallTransactionObject.AOL, mallTransactionObject.AOl);
            iVar.setTitle(context.getString(R.string.ijh));
            if (!Util.isNullOrNil(mallTransactionObject.AOM)) {
                iVar.aJH(mallTransactionObject.AOM);
            }
            arrayList.add(iVar);
            h hVar = new h(context);
            hVar.AQN = false;
            hVar.AQO = true;
            arrayList.add(hVar);
            f fVar2 = new f(context);
            fVar2.setTitle(R.string.ijy);
            fVar2.setContent(com.tencent.mm.wallet_core.ui.f.d(mallTransactionObject.qwJ, mallTransactionObject.AOl));
            arrayList.add(fVar2);
            f fVar3 = new f(context);
            fVar3.setTitle(R.string.iji);
            fVar3.setContent(mallTransactionObject.AOB);
            arrayList.add(fVar3);
        } else {
            i iVar2 = new i(context);
            iVar2.AQQ = com.tencent.mm.wallet_core.ui.f.d(mallTransactionObject.qwJ, mallTransactionObject.AOl);
            if (z2) {
                string = context.getString(R.string.ijg);
            } else {
                string = context.getString(R.string.ijy);
            }
            iVar2.setTitle(string);
            if (!Util.isNullOrNil(mallTransactionObject.AOd)) {
                iVar2.aJH(mallTransactionObject.AOd);
            }
            arrayList.add(iVar2);
            if (mallTransactionObject.qwJ == mallTransactionObject.AOq || mallTransactionObject.AOq <= 0.0d) {
                z = false;
            } else {
                h hVar2 = new h(context);
                hVar2.AQN = false;
                hVar2.AQO = true;
                arrayList.add(hVar2);
                f fVar4 = new f(context);
                fVar4.setContent(com.tencent.mm.wallet_core.ui.f.d(mallTransactionObject.AOq, mallTransactionObject.AOl));
                fVar4.setTitle(R.string.ik6);
                arrayList.add(fVar4);
                z = true;
                if (!Util.isNullOrNil(mallTransactionObject.AOp)) {
                    g gVar = new g(context);
                    gVar.setTitle(R.string.ijs);
                    gVar.nRm = fVar;
                    String[] split = mallTransactionObject.AOp.split("\n");
                    if (split.length == 1) {
                        gVar.AQG = split[0];
                    } else {
                        gVar.AQG = context.getString(R.string.iju, Integer.valueOf(split.length), com.tencent.mm.wallet_core.ui.f.d(mallTransactionObject.AOq - mallTransactionObject.qwJ, mallTransactionObject.AOl));
                        gVar.a(split, TextUtils.TruncateAt.MIDDLE);
                    }
                    arrayList.add(gVar);
                }
            }
            h hVar3 = new h(context);
            hVar3.AQN = z;
            hVar3.AQO = true;
            arrayList.add(hVar3);
        }
        if (!Util.isNullOrNil(mallTransactionObject.desc)) {
            if (z2) {
                f fVar5 = new f(context);
                fVar5.setTitle(R.string.ik4);
                fVar5.setContent(mallTransactionObject.desc);
                arrayList.add(fVar5);
            } else {
                final f fVar6 = new f(context);
                fVar6.setTitle(R.string.ijq);
                if (!Util.isNullOrNil(mallTransactionObject.AOb)) {
                    String string2 = context.getString(R.string.ijj);
                    fVar6.a(mallTransactionObject.desc + " " + string2, mallTransactionObject.desc.length() + 1, string2.length() + mallTransactionObject.desc.length() + 1, new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.order.ui.a.b.AnonymousClass2 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(66803);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/preference/FetchOrderPrefFactory$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            fVar6.setContent(mallTransactionObject.desc + "\n" + mallTransactionObject.AOb);
                            fVar.notifyDataSetChanged();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/FetchOrderPrefFactory$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(66803);
                        }
                    });
                } else {
                    fVar6.setContent(mallTransactionObject.desc);
                }
                arrayList.add(fVar6);
            }
        }
        if (!Util.isNullOrNil(mallTransactionObject.AOa)) {
            f fVar7 = new f(context);
            fVar7.setTitle(R.string.ik5);
            fVar7.setContent(mallTransactionObject.AOa);
            arrayList.add(fVar7);
        }
        if (!Util.isNullOrNil(mallTransactionObject.AOf)) {
            f fVar8 = new f(context);
            fVar8.setTitle(R.string.ikk);
            fVar8.setContent(mallTransactionObject.AOf);
            if (!Util.isNullOrNil(mallTransactionObject.AOg)) {
                fVar8.aJG(mallTransactionObject.AOg);
            }
            arrayList.add(fVar8);
        }
        f fVar9 = new f(context);
        fVar9.setTitle(R.string.ik1);
        fVar9.setContent(com.tencent.mm.wallet_core.ui.f.rZ(mallTransactionObject.iXu));
        arrayList.add(fVar9);
        if (mallTransactionObject.AOx > 0) {
            f fVar10 = new f(context);
            fVar10.setTitle(R.string.ijz);
            fVar10.setContent(com.tencent.mm.wallet_core.ui.f.rZ(mallTransactionObject.AOx));
            arrayList.add(fVar10);
        } else if (mallTransactionObject.AOw > 0) {
            f fVar11 = new f(context);
            fVar11.setTitle(R.string.ik2);
            fVar11.setContent(com.tencent.mm.wallet_core.ui.f.rZ(mallTransactionObject.AOw));
            arrayList.add(fVar11);
        } else {
            Log.e("MicroMsg.FetchOrderPrefFactory", "hy: is fetch but no arrive time or fetch time");
        }
        if (!Util.isNullOrNil(mallTransactionObject.AOj)) {
            f fVar12 = new f(context);
            fVar12.setTitle(R.string.ik0);
            String str = mallTransactionObject.AOj;
            if (!Util.isNullOrNil(mallTransactionObject.AOk)) {
                str = str + "(" + mallTransactionObject.AOk + ")";
            }
            fVar12.setContent(str);
            arrayList.add(fVar12);
        }
        if (!Util.isNullOrNil(mallTransactionObject.AOi)) {
            f fVar13 = new f(context);
            fVar13.setTitle(R.string.ik3);
            fVar13.setContent(mallTransactionObject.AOi);
            arrayList.add(fVar13);
        }
        if (!Util.isNullOrNil(mallTransactionObject.AOu) || !Util.isNullOrNil(mallTransactionObject.dCu) || !Util.isNullOrNil(mallTransactionObject.ANP)) {
            h hVar4 = new h(context);
            hVar4.AQN = true;
            arrayList.add(hVar4);
            arrayList.add(a.a(context, mallTransactionObject));
        } else {
            h hVar5 = new h(context);
            hVar5.AQN = true;
            hVar5.oAJ = false;
            arrayList.add(hVar5);
        }
        AppMethodBeat.o(66804);
        return arrayList;
    }
}
