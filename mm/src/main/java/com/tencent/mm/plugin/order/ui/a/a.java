package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.c;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a implements a.AbstractC1568a {
    public c AQq;

    @Override // com.tencent.mm.plugin.order.model.a.AbstractC1568a
    public final List<Preference> a(final Context context, final f fVar, final MallTransactionObject mallTransactionObject) {
        boolean z;
        String string;
        boolean z2;
        AppMethodBeat.i(66800);
        ArrayList arrayList = new ArrayList();
        if (mallTransactionObject.dyc == 2) {
            z = true;
        } else {
            z = false;
        }
        if (!Util.isNullOrNil(mallTransactionObject.AOm) && !Util.isNullOrNil(mallTransactionObject.jyi)) {
            d dVar = new d(context);
            dVar.rcG = mallTransactionObject.jyi;
            dVar.mName = mallTransactionObject.AOm;
            dVar.mOnClickListener = new View.OnClickListener() {
                /* class com.tencent.mm.plugin.order.ui.a.a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(66791);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!Util.isNullOrNil(mallTransactionObject.dCu)) {
                        com.tencent.mm.wallet_core.ui.f.am(context, mallTransactionObject.dCu);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(66791);
                }
            };
            arrayList.add(dVar);
            arrayList.add(new PreferenceSmallCategory(context));
        }
        i iVar = new i(context);
        iVar.AQQ = com.tencent.mm.wallet_core.ui.f.d(mallTransactionObject.qwJ, mallTransactionObject.AOl);
        if (z) {
            string = context.getString(R.string.ijg);
        } else if (mallTransactionObject.efQ == 11) {
            string = context.getString(R.string.ikg);
        } else {
            string = context.getString(R.string.ijf);
        }
        iVar.setTitle(string);
        if (!Util.isNullOrNil(mallTransactionObject.AOd)) {
            iVar.aJH(mallTransactionObject.AOd);
        }
        arrayList.add(iVar);
        boolean z3 = false;
        if (mallTransactionObject.qwJ != mallTransactionObject.AOq) {
            h hVar = new h(context);
            hVar.AQN = false;
            hVar.AQO = true;
            arrayList.add(hVar);
            f fVar2 = new f(context);
            fVar2.setContent(com.tencent.mm.wallet_core.ui.f.d(mallTransactionObject.AOq, mallTransactionObject.AOl));
            fVar2.setTitle(R.string.ik6);
            arrayList.add(fVar2);
            z3 = true;
        }
        if (mallTransactionObject.qwJ != mallTransactionObject.AOq && !Util.isNullOrNil(mallTransactionObject.AOp)) {
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
        h hVar2 = new h(context);
        hVar2.AQN = z3;
        hVar2.AQO = true;
        arrayList.add(hVar2);
        if (!z && !Util.isNullOrNil(mallTransactionObject.AOz)) {
            g.aAi();
            as Kn = ((l) g.af(l.class)).aSN().Kn(mallTransactionObject.AOz);
            if (Kn != null && ((int) Kn.gMZ) > 0) {
                String arJ = Kn.arJ();
                f fVar3 = new f(context);
                fVar3.setTitle(R.string.ikj);
                fVar3.setContent(arJ);
                arrayList.add(fVar3);
            }
        }
        if (mallTransactionObject.efQ == 31 && z && !Util.isNullOrNil(mallTransactionObject.AOG)) {
            g.aAi();
            as Kn2 = ((l) g.af(l.class)).aSN().Kn(mallTransactionObject.AOG);
            if (Kn2 != null && ((int) Kn2.gMZ) > 0) {
                String arJ2 = Kn2.arJ();
                f fVar4 = new f(context);
                fVar4.setTitle(R.string.ik4);
                fVar4.setContent(arJ2);
                arrayList.add(fVar4);
            }
        }
        if (!Util.isNullOrNil(mallTransactionObject.desc)) {
            if (z) {
                f fVar5 = new f(context);
                if (mallTransactionObject.efQ == 32 || mallTransactionObject.efQ == 33 || mallTransactionObject.efQ == 31) {
                    fVar5.setTitle(R.string.ijk);
                } else {
                    fVar5.setTitle(R.string.ik4);
                }
                fVar5.setContent(mallTransactionObject.desc);
                arrayList.add(fVar5);
            } else {
                final f fVar6 = new f(context);
                if (mallTransactionObject.efQ == 31) {
                    fVar6.setTitle(R.string.ikc);
                } else {
                    fVar6.setTitle(R.string.ijq);
                }
                if (!Util.isNullOrNil(mallTransactionObject.AOb)) {
                    String string2 = context.getString(R.string.ijj);
                    fVar6.a(mallTransactionObject.desc + " " + string2, mallTransactionObject.desc.length() + 1, string2.length() + mallTransactionObject.desc.length() + 1, new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.order.ui.a.a.AnonymousClass2 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(66792);
                            b bVar = new b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            fVar6.setContent(mallTransactionObject.desc + "\n" + mallTransactionObject.AOb);
                            fVar.notifyDataSetChanged();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(66792);
                        }
                    });
                } else {
                    fVar6.setContent(mallTransactionObject.desc);
                }
                arrayList.add(fVar6);
            }
        }
        if (!Util.isNullOrNil(mallTransactionObject.AOK)) {
            f fVar7 = new f(context);
            fVar7.setTitle(R.string.ikv);
            fVar7.setContent(mallTransactionObject.AOK);
            arrayList.add(fVar7);
        }
        if (!Util.isNullOrNil(mallTransactionObject.AOJ)) {
            f fVar8 = new f(context);
            fVar8.setTitle(R.string.ikw);
            fVar8.setContent(mallTransactionObject.AOJ);
            arrayList.add(fVar8);
        }
        if (!TextUtils.isEmpty(mallTransactionObject.AOB)) {
            f fVar9 = new f(context);
            fVar9.setTitle(R.string.iji);
            fVar9.setContent(mallTransactionObject.AOB);
            arrayList.add(fVar9);
        }
        if (!Util.isNullOrNil(mallTransactionObject.AOa)) {
            f fVar10 = new f(context);
            fVar10.setTitle(R.string.ik5);
            fVar10.setContent(mallTransactionObject.AOa);
            arrayList.add(fVar10);
        }
        if (!Util.isNullOrNil(mallTransactionObject.AOf)) {
            f fVar11 = new f(context);
            fVar11.setTitle(R.string.ikk);
            if (mallTransactionObject.efQ != 31 || z.aTY().equals(mallTransactionObject.AOz) || mallTransactionObject.AOA <= 0 || Util.isNullOrNil(mallTransactionObject.AOz) || Util.isNullOrNil(mallTransactionObject.dDM)) {
                fVar11.setContent(mallTransactionObject.AOf);
                if (!Util.isNullOrNil(mallTransactionObject.AOg)) {
                    fVar11.aJG(mallTransactionObject.AOg);
                }
            } else {
                String string3 = context.getString(R.string.g4_);
                fVar11.a(mallTransactionObject.AOf + " " + string3, mallTransactionObject.AOf.length() + 1, string3.length() + mallTransactionObject.AOf.length() + 1, new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.order.ui.a.a.AnonymousClass3 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(66794);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        h.c(context, context.getString(R.string.g27), context.getString(R.string.yd), context.getString(R.string.g49), context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.order.ui.a.a.AnonymousClass3.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(66793);
                                Intent intent = new Intent();
                                intent.putExtra(FirebaseAnalytics.b.TRANSACTION_ID, mallTransactionObject.dDM);
                                intent.putExtra("receiver_name", mallTransactionObject.AOz);
                                intent.putExtra("resend_msg_from_flag", 1);
                                com.tencent.mm.br.c.b(context, "remittance", ".ui.RemittanceResendMsgUI", intent);
                                AppMethodBeat.o(66793);
                            }
                        }, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.order.ui.a.a.AnonymousClass3.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(66794);
                    }
                });
            }
            arrayList.add(fVar11);
        }
        f fVar12 = new f(context);
        fVar12.setTitle(R.string.ijn);
        fVar12.setContent(com.tencent.mm.wallet_core.ui.f.rZ(mallTransactionObject.iXu));
        arrayList.add(fVar12);
        if (!Util.isNullOrNil(mallTransactionObject.AOj)) {
            f fVar13 = new f(context);
            fVar13.setTitle(R.string.ik8);
            String str = mallTransactionObject.AOj;
            if (!Util.isNullOrNil(mallTransactionObject.AOk)) {
                str = str + "(" + mallTransactionObject.AOk + ")";
            }
            fVar13.setContent(str);
            arrayList.add(fVar13);
        }
        if (!Util.isNullOrNil(mallTransactionObject.dDM)) {
            f fVar14 = new f(context);
            fVar14.setTitle(R.string.ikr);
            fVar14.setContent(mallTransactionObject.dDM);
            arrayList.add(fVar14);
        }
        if (!Util.isNullOrNil(mallTransactionObject.AOi)) {
            f fVar15 = new f(context);
            fVar15.setTitle(R.string.ikh);
            if (mallTransactionObject.efQ == 8) {
                fVar15.setContent(context.getString(R.string.iki));
                c cVar = new c(context);
                final Bitmap b2 = com.tencent.mm.by.a.a.b(context, mallTransactionObject.AOi, 5, 0);
                cVar.AQy = com.tencent.mm.wallet_core.ui.f.bpw(mallTransactionObject.AOi);
                cVar.iKs = b2;
                cVar.mOnClickListener = new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.order.ui.a.a.AnonymousClass4 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(66795);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (a.this.AQq != null) {
                            a aVar = a.this;
                            Bitmap bitmap = b2;
                            String str = mallTransactionObject.AOi;
                            if (aVar.AQq != null) {
                                aVar.AQq.nC(str, str);
                                aVar.AQq.AKT = bitmap;
                                aVar.AQq.AKU = bitmap;
                                aVar.AQq.hhQ();
                            }
                            a.this.AQq.aa(view, true);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(66795);
                    }
                };
                arrayList.add(fVar15);
                arrayList.add(cVar);
            } else {
                fVar15.setContent(mallTransactionObject.AOi);
                arrayList.add(fVar15);
            }
        }
        if (mallTransactionObject.ANM.size() == 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2 || (Util.isNullOrNil(mallTransactionObject.AOu) && Util.isNullOrNil(mallTransactionObject.dCu) && Util.isNullOrNil(mallTransactionObject.ANP))) {
            h hVar3 = new h(context);
            hVar3.AQN = true;
            hVar3.oAJ = false;
            arrayList.add(hVar3);
        } else {
            h hVar4 = new h(context);
            hVar4.AQN = true;
            arrayList.add(hVar4);
            arrayList.add(com.tencent.mm.plugin.order.model.a.a(context, mallTransactionObject));
        }
        if (z2) {
            j jVar = new j(context);
            if (mallTransactionObject.ANN == 1) {
                if (!Util.isNullOrNil(mallTransactionObject.AOu) || !Util.isNullOrNil(mallTransactionObject.dCu) || !Util.isNullOrNil(mallTransactionObject.ANP)) {
                    if (!Util.isNullOrNil(mallTransactionObject.AOv)) {
                        jVar.AQR = mallTransactionObject.AOv;
                    } else {
                        jVar.AQR = context.getString(R.string.ikp);
                    }
                    jVar.AQS = new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.order.ui.a.a.AnonymousClass5 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(66797);
                            b bVar = new b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
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
                                com.tencent.mm.plugin.order.model.a.a(((Integer) linkedList2.get(0)).intValue(), context, mallTransactionObject);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(66797);
                                return;
                            }
                            h.b(context, (String) null, linkedList, linkedList2, (String) null, new h.e() {
                                /* class com.tencent.mm.plugin.order.ui.a.a.AnonymousClass5.AnonymousClass1 */

                                @Override // com.tencent.mm.ui.base.h.e
                                public final void cy(int i2, int i3) {
                                    AppMethodBeat.i(66796);
                                    com.tencent.mm.plugin.order.model.a.a(i3, context, mallTransactionObject);
                                    AppMethodBeat.o(66796);
                                }
                            });
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(66797);
                        }
                    };
                }
            } else if (!Util.isNullOrNil(mallTransactionObject.AOv)) {
                jVar.AQR = mallTransactionObject.AOv;
                jVar.AQS = new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.order.ui.a.a.AnonymousClass6 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(66798);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        a.a(context, mallTransactionObject.AOu, mallTransactionObject);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(66798);
                    }
                };
            }
            jVar.ANM = mallTransactionObject.ANM;
            jVar.mOnClickListener = new View.OnClickListener() {
                /* class com.tencent.mm.plugin.order.ui.a.a.AnonymousClass7 */

                public final void onClick(View view) {
                    AppMethodBeat.i(66799);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (view.getTag() == null) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(66799);
                        return;
                    }
                    if (view.getTag() instanceof MallOrderDetailObject.HelpCenter) {
                        a.a(context, ((MallOrderDetailObject.HelpCenter) view.getTag()).url, mallTransactionObject);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(66799);
                }
            };
            h hVar5 = new h(context);
            hVar5.AQN = true;
            arrayList.add(hVar5);
            arrayList.add(jVar);
        }
        AppMethodBeat.o(66800);
        return arrayList;
    }

    static /* synthetic */ void a(Context context, String str, MallTransactionObject mallTransactionObject) {
        WifiInfo connectionInfo;
        AppMethodBeat.i(66801);
        Intent intent = new Intent();
        Uri parse = Uri.parse(str);
        String str2 = mallTransactionObject.dDM;
        String aoG = q.aoG();
        String str3 = d.ics;
        String str4 = Build.MODEL;
        String aoL = q.aoL();
        WifiManager wifiManager = (WifiManager) MMApplicationContext.getContext().getSystemService("wifi");
        String uri = parse.buildUpon().appendQueryParameter("trans_id", str2).appendQueryParameter("deviceid", aoG).appendQueryParameter(TPDownloadProxyEnum.USER_BSSID, (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) ? TPDownloadProxyEnum.USER_BSSID : Util.nullAs(connectionInfo.getBSSID(), "")).appendQueryParameter("deviceType", str3).appendQueryParameter("deviceName", str4).appendQueryParameter("ostype", aoL).build().toString();
        Log.i("MicroMsg.DefaultOrderPrefFactory", "new url %s", uri);
        intent.putExtra("rawUrl", uri);
        intent.putExtra("geta8key_username", z.aTY());
        com.tencent.mm.wallet_core.ui.f.aA(context, intent);
        AppMethodBeat.o(66801);
    }
}
