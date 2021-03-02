package com.tencent.mm.q;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.hx;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.g.a.t;
import com.tencent.mm.g.a.zi;
import com.tencent.mm.model.an;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;

public final class a {
    private static an dnl;

    public static boolean cA(Context context) {
        AppMethodBeat.i(150031);
        if (att()) {
            Log.i("MicroMsg.DeviceOccupy", "isMultiTalking");
            h.a(context, "", context.getString(R.string.f68), context.getString(R.string.w0), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.q.a.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            AppMethodBeat.o(150031);
            return true;
        }
        AppMethodBeat.o(150031);
        return false;
    }

    public static boolean a(Context context, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(223501);
        if (att()) {
            Log.i("MicroMsg.DeviceOccupy", "isMultiTalking");
            h.a(context, "", context.getString(R.string.f68), context.getString(R.string.w0), onClickListener);
            AppMethodBeat.o(223501);
            return true;
        }
        AppMethodBeat.o(223501);
        return false;
    }

    public static boolean att() {
        AppMethodBeat.i(150032);
        mu muVar = new mu();
        muVar.dSs.action = 1;
        EventCenter.instance.publish(muVar);
        boolean z = muVar.dSt.isStart;
        AppMethodBeat.o(150032);
        return z;
    }

    public static boolean o(Context context, boolean z) {
        boolean z2;
        String string;
        AppMethodBeat.i(223502);
        zi ziVar = new zi();
        EventCenter.instance.publish(ziVar);
        if (ziVar.efv.dCH) {
            Log.i("MicroMsg.DeviceOccupy", "isCameraUsing");
            if (z) {
                h.a(context, "", q(context, ziVar.efv.efw), context.getString(R.string.w0), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.q.a.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
            }
            boolean z3 = ziVar.efv.dCH;
            AppMethodBeat.o(223502);
            return z3;
        }
        hx hxVar = new hx();
        EventCenter.instance.publish(hxVar);
        Log.i("MicroMsg.DeviceOccupy", "checkFinderLive isLiving %b isAnchor %b", Boolean.valueOf(hxVar.dMy.isStart), Boolean.valueOf(hxVar.dMy.dMz));
        boolean z4 = hxVar.dMy.isStart && hxVar.dMy.dMz;
        if (z4 && z) {
            if (hxVar.dMy.dMz) {
                string = context.getString(R.string.cy8);
            } else {
                string = context.getString(R.string.cy9);
            }
            u.makeText(context, string, 0).show();
        }
        if (z4) {
            AppMethodBeat.o(223502);
            return true;
        }
        lv lvVar = new lv();
        EventCenter.instance.publish(lvVar);
        Log.i("MicroMsg.DeviceOccupy", "isLiving %b isAnchor %b isAudioMicing %s isVideoMicing %s", Boolean.valueOf(lvVar.dRl.isStart), Boolean.valueOf(lvVar.dRl.dMz), Boolean.valueOf(lvVar.dRl.dRm), Boolean.valueOf(lvVar.dRl.dRn));
        if (lvVar.dRl.dMz) {
            z2 = lvVar.dRl.isStart;
        } else {
            z2 = lvVar.dRl.dRn;
        }
        if (z2 && z) {
            h.a(context, "", context.getString(R.string.ehs), context.getString(R.string.w0), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.q.a.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
        }
        AppMethodBeat.o(223502);
        return z2;
    }

    public static boolean b(Context context, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(223503);
        zi ziVar = new zi();
        EventCenter.instance.publish(ziVar);
        if (ziVar.efv.dCH) {
            Log.i("MicroMsg.DeviceOccupy", "isCameraUsing");
            h.a(context, "", q(context, ziVar.efv.efw), context.getString(R.string.w0), onClickListener);
            boolean z = ziVar.efv.dCH;
            AppMethodBeat.o(223503);
            return z;
        }
        boolean cB = cB(context);
        AppMethodBeat.o(223503);
        return cB;
    }

    public static boolean cB(Context context) {
        AppMethodBeat.i(223504);
        lv lvVar = new lv();
        EventCenter.instance.publish(lvVar);
        Log.i("MicroMsg.DeviceOccupy", "isLiving %b isAnchor %b", Boolean.valueOf(lvVar.dRl.isStart), Boolean.valueOf(lvVar.dRl.dMz));
        boolean z = lvVar.dRl.isStart;
        if (z) {
            h.a(context, "", context.getString(R.string.ehs), context.getString(R.string.w0), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.q.a.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
        }
        AppMethodBeat.o(223504);
        return z;
    }

    public static boolean atu() {
        AppMethodBeat.i(223505);
        lv lvVar = new lv();
        EventCenter.instance.publish(lvVar);
        Log.i("MicroMsg.DeviceOccupy", "isLiving %b isAnchor %b", Boolean.valueOf(lvVar.dRl.isStart), Boolean.valueOf(lvVar.dRl.dMz));
        boolean z = lvVar.dRl.isStart;
        AppMethodBeat.o(223505);
        return z;
    }

    public static boolean p(Context context, boolean z) {
        String string;
        AppMethodBeat.i(223506);
        hx hxVar = new hx();
        EventCenter.instance.publish(hxVar);
        Log.i("MicroMsg.DeviceOccupy", "checkFinderLive isLiving %b isAnchor %b", Boolean.valueOf(hxVar.dMy.isStart), Boolean.valueOf(hxVar.dMy.dMz));
        boolean z2 = hxVar.dMy.isStart;
        if (z2 && z) {
            if (hxVar.dMy.dMz) {
                string = context.getString(R.string.cy8);
            } else {
                string = context.getString(R.string.cy9);
            }
            u.makeText(context, string, 0).show();
        }
        AppMethodBeat.o(223506);
        return z2;
    }

    public static boolean atv() {
        AppMethodBeat.i(223507);
        zi ziVar = new zi();
        EventCenter.instance.publish(ziVar);
        boolean z = ziVar.efv.dCI;
        AppMethodBeat.o(223507);
        return z;
    }

    public static boolean cC(Context context) {
        AppMethodBeat.i(150034);
        zi ziVar = new zi();
        EventCenter.instance.publish(ziVar);
        if (ziVar.efv.dCI) {
            Log.i("MicroMsg.DeviceOccupy", "isVoiceUsing");
            h.a(context, "", q(context, ziVar.efv.efw), context.getString(R.string.w0), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.q.a.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            boolean z = ziVar.efv.dCI;
            AppMethodBeat.o(150034);
            return z;
        } else if (p(context, true)) {
            AppMethodBeat.o(150034);
            return true;
        } else {
            boolean cB = cB(context);
            AppMethodBeat.o(150034);
            return cB;
        }
    }

    public static boolean c(Context context, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(223508);
        zi ziVar = new zi();
        EventCenter.instance.publish(ziVar);
        if (ziVar.efv.dCI) {
            Log.i("MicroMsg.DeviceOccupy", "isVoiceUsing");
            h.a(context, "", q(context, ziVar.efv.efw), context.getString(R.string.w0), onClickListener);
            boolean z = ziVar.efv.dCI;
            AppMethodBeat.o(223508);
            return z;
        }
        boolean cB = cB(context);
        AppMethodBeat.o(223508);
        return cB;
    }

    public static boolean d(Context context, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(223509);
        gt gtVar = new gt();
        EventCenter.instance.publish(gtVar);
        if (gtVar.dKN.dKO) {
            Log.i("MicroMsg.DeviceOccupy", "is Face page exist");
            h.a(context, "", context.getString(R.string.c5y), context.getString(R.string.w0), onClickListener);
            boolean z = gtVar.dKN.dKO;
            AppMethodBeat.o(223509);
            return z;
        }
        AppMethodBeat.o(223509);
        return false;
    }

    private static String q(Context context, boolean z) {
        AppMethodBeat.i(150035);
        if (z) {
            String string = context.getString(R.string.amx);
            AppMethodBeat.o(150035);
            return string;
        }
        String string2 = context.getString(R.string.amz);
        AppMethodBeat.o(150035);
        return string2;
    }

    public static an Xi() {
        AppMethodBeat.i(150036);
        if (dnl == null) {
            dnl = com.tencent.mm.booter.a.akp();
        }
        an anVar = dnl;
        AppMethodBeat.o(150036);
        return anVar;
    }

    public static boolean cD(Context context) {
        AppMethodBeat.i(223510);
        boolean r = r(context, true);
        AppMethodBeat.o(223510);
        return r;
    }

    public static boolean r(Context context, boolean z) {
        AppMethodBeat.i(223511);
        t tVar = new t();
        EventCenter.instance.publish(tVar);
        Log.i("MicroMsg.DeviceOccupy", "checkAppBrandCameraUsingAndShowToast isVoiceUsing:%b, isCameraUsing:%b", Boolean.valueOf(tVar.dCG.dCI), Boolean.valueOf(tVar.dCG.dCH));
        if (tVar.dCG.dCH) {
            Log.i("MicroMsg.DeviceOccupy", "app brand voip camera using");
            if (z) {
                Toast.makeText(context, q(context, tVar.dCG.dCH), 0).show();
            }
        }
        boolean z2 = tVar.dCG.dCH;
        AppMethodBeat.o(223511);
        return z2;
    }

    public static boolean cE(Context context) {
        AppMethodBeat.i(223512);
        t tVar = new t();
        EventCenter.instance.publish(tVar);
        Log.i("MicroMsg.DeviceOccupy", "checkAppBrandVoiceUsingAndShowToast isVoiceUsing:%b, isCameraUsing:%b", Boolean.valueOf(tVar.dCG.dCI), Boolean.valueOf(tVar.dCG.dCH));
        if (tVar.dCG.dCI) {
            Log.i("MicroMsg.DeviceOccupy", "app brand voip voice using");
            h.a(context, "", q(context, tVar.dCG.dCH), context.getString(R.string.w0), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.q.a.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
        }
        boolean z = tVar.dCG.dCI;
        AppMethodBeat.o(223512);
        return z;
    }

    public static boolean e(Context context, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(223513);
        t tVar = new t();
        EventCenter.instance.publish(tVar);
        Log.i("MicroMsg.DeviceOccupy", "checkAppBrandVoiceUsingAndShowToast isVoiceUsing:%b, isCameraUsing:%b", Boolean.valueOf(tVar.dCG.dCI), Boolean.valueOf(tVar.dCG.dCH));
        if (tVar.dCG.dCI) {
            Log.i("MicroMsg.DeviceOccupy", "app brand voip voice using");
            h.a(context, "", q(context, tVar.dCG.dCH), context.getString(R.string.w0), onClickListener);
        }
        boolean z = tVar.dCG.dCI;
        AppMethodBeat.o(223513);
        return z;
    }

    public static boolean atw() {
        AppMethodBeat.i(223514);
        t tVar = new t();
        EventCenter.instance.publish(tVar);
        Log.i("MicroMsg.DeviceOccupy", "checkAppBrandVoiceUsing isVoiceUsing:%b, isCameraUsing:%b", Boolean.valueOf(tVar.dCG.dCI), Boolean.valueOf(tVar.dCG.dCH));
        if (tVar.dCG.dCI) {
            Log.i("MicroMsg.DeviceOccupy", "app brand voip voice using");
        }
        boolean z = tVar.dCG.dCI;
        AppMethodBeat.o(223514);
        return z;
    }

    public static boolean atx() {
        AppMethodBeat.i(223515);
        t tVar = new t();
        EventCenter.instance.publish(tVar);
        Log.i("MicroMsg.DeviceOccupy", "checkAppBrandCameraUsing isVoiceUsing:%b, isCameraUsing:%b", Boolean.valueOf(tVar.dCG.dCI), Boolean.valueOf(tVar.dCG.dCH));
        if (tVar.dCG.dCH) {
            Log.i("MicroMsg.DeviceOccupy", "app brand voip camera using");
        }
        boolean z = tVar.dCG.dCH;
        AppMethodBeat.o(223515);
        return z;
    }

    public static boolean aty() {
        AppMethodBeat.i(223516);
        boolean p = p(null, false);
        Log.i("MicroMsg.DeviceOccupy", "checkMutePlay:%s", Boolean.valueOf(p));
        AppMethodBeat.o(223516);
        return p;
    }
}
