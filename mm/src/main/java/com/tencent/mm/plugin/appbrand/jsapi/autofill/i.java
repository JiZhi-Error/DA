package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.SpannableString;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.kp;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.phonenumber.u;
import com.tencent.mm.plugin.appbrand.phonenumber.y;
import com.tencent.mm.plugin.appbrand.ui.AppBrandRedirectUI;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import kotlin.g.a.b;
import kotlin.x;

public final class i {
    static boolean isInit = false;

    public static void init() {
        AppMethodBeat.i(46120);
        if (isInit) {
            AppMethodBeat.o(46120);
            return;
        }
        isInit = true;
        u uVar = u.nAe;
        u.a(new com.tencent.mm.plugin.appbrand.phonenumber.i() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.i.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.phonenumber.i, com.tencent.mm.plugin.appbrand.phonenumber.n
            public final SpannableString n(Context context, String str, String str2) {
                AppMethodBeat.i(46115);
                String string = context.getString(R.string.a2n);
                String format = String.format(context.getString(R.string.a2o), string);
                WxaExposedParams.a aVar = new WxaExposedParams.a();
                aVar.appId = str;
                aVar.pageId = str2;
                aVar.from = 8;
                a aVar2 = new a(w.b(aVar.bAv()));
                SpannableString spannableString = new SpannableString(format);
                spannableString.setSpan(aVar2, format.indexOf(string), string.length() + format.indexOf(string), 18);
                AppMethodBeat.o(46115);
                return spannableString;
            }

            @Override // com.tencent.mm.plugin.appbrand.phonenumber.i, com.tencent.mm.plugin.appbrand.phonenumber.n
            public final void dL(Context context) {
                AppMethodBeat.i(46116);
                if (context instanceof MMActivity) {
                    ((MMActivity) context).hideVKB();
                }
                AppMethodBeat.o(46116);
            }

            @Override // com.tencent.mm.plugin.appbrand.phonenumber.i, com.tencent.mm.plugin.appbrand.phonenumber.n
            public final void dM(Context context) {
                AppMethodBeat.i(46117);
                if (context instanceof MMActivity) {
                    ((MMActivity) context).showVKB();
                }
                AppMethodBeat.o(46117);
            }

            @Override // com.tencent.mm.plugin.appbrand.phonenumber.i, com.tencent.mm.plugin.appbrand.phonenumber.n
            public final void a(final Context context, final b<? super Integer, x> bVar) {
                AppMethodBeat.i(46118);
                h.a(context, false, context.getString(R.string.ll), context.getString(R.string.lm), context.getString(R.string.lt), context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.i.AnonymousClass1.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(46113);
                        Intent intent = new Intent(context, AppBrandRedirectUI.class);
                        intent.putExtra("key_from_scene", 0);
                        f.aK(context).a(intent, new f.b() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.i.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                            @Override // com.tencent.luggage.h.f.b
                            public final void a(int i2, Intent intent) {
                                AppMethodBeat.i(46112);
                                bVar.invoke(Integer.valueOf(i2));
                                AppMethodBeat.o(46112);
                            }
                        });
                        AppMethodBeat.o(46113);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.i.AnonymousClass1.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(46114);
                        dialogInterface.dismiss();
                        bVar.invoke(0);
                        AppMethodBeat.o(46114);
                    }
                }, R.color.ts, R.color.ts);
                AppMethodBeat.o(46118);
            }

            @Override // com.tencent.mm.plugin.appbrand.phonenumber.i, com.tencent.mm.plugin.appbrand.phonenumber.n
            public final void a(y yVar) {
                AppMethodBeat.i(174779);
                kp kpVar = new kp();
                kpVar.eWC = yVar.nAE;
                kpVar.eWD = yVar.nAF;
                kpVar.eWE = yVar.nAG;
                kpVar.eWF = yVar.nAH;
                kpVar.eWG = yVar.nAI;
                kpVar.eWH = yVar.nAJ;
                kpVar.eWI = yVar.nAK;
                kpVar.eWJ = yVar.nAL;
                kpVar.eWK = yVar.nAM;
                kpVar.eWL = yVar.nAN;
                kpVar.eWM = yVar.nAO;
                kpVar.eWN = yVar.nAP;
                kpVar.eWO = yVar.nBc;
                kpVar.eWP = yVar.nAR;
                kpVar.eWQ = yVar.nAS;
                kpVar.eWR = yVar.nAT;
                kpVar.eWS = yVar.nAU;
                kpVar.eWT = yVar.nAV;
                kpVar.eWU = yVar.nAW;
                kpVar.eWV = yVar.nAX;
                kpVar.eWW = yVar.nAY;
                kpVar.eWX = yVar.nAZ;
                kpVar.eWY = yVar.nBa;
                kpVar.eWZ = yVar.nBb;
                kpVar.eXa = yVar.nBc;
                kpVar.eXb = yVar.nBd;
                kpVar.bfK();
                AppMethodBeat.o(174779);
            }
        });
        AppMethodBeat.o(46120);
    }
}
