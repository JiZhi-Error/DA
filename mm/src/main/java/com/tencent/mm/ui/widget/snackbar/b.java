package com.tencent.mm.ui.widget.snackbar;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.snackbar.a;

public final class b {
    private static boolean QVB = false;

    public static void a(Activity activity, String str, String str2, a.b bVar) {
        AppMethodBeat.i(159712);
        a.C2146a aVar = new a.C2146a(activity);
        aVar.mMessage = str;
        aVar.QVo = str2;
        a(aVar.a((Short) 2500), bVar, null);
        AppMethodBeat.o(159712);
    }

    public static void a(Context context, View view, String str, String str2, a.b bVar) {
        AppMethodBeat.i(168815);
        a.C2146a aVar = new a.C2146a(context, view);
        aVar.mMessage = str;
        aVar.QVo = str2;
        a(aVar.a((Short) 2500), bVar, null);
        AppMethodBeat.o(168815);
    }

    public static void a(Context context, View view, String str, String str2, a.b bVar, a.c cVar) {
        AppMethodBeat.i(159714);
        a.C2146a aVar = new a.C2146a(context, view);
        aVar.mMessage = str;
        aVar.QVo = str2;
        a(aVar.a((Short) 2500), bVar, cVar);
        AppMethodBeat.o(159714);
    }

    public static void a(Activity activity, String str, String str2, a.b bVar, a.c cVar) {
        AppMethodBeat.i(159715);
        a.C2146a aVar = new a.C2146a(activity);
        aVar.mMessage = str;
        aVar.QVo = str2;
        a(aVar.a((Short) 2500), bVar, cVar);
        AppMethodBeat.o(159715);
    }

    public static void a(Context context, View view, String str, a.c cVar) {
        AppMethodBeat.i(159716);
        a.C2146a aVar = new a.C2146a(context, view);
        aVar.mMessage = str;
        a.C2146a a2 = aVar.a((Short) 1500);
        if (cVar != null) {
            a2.a(cVar);
        }
        a2.hcA();
        AppMethodBeat.o(159716);
    }

    public static void r(Activity activity, String str) {
        AppMethodBeat.i(159717);
        a.C2146a aVar = new a.C2146a(activity);
        aVar.mMessage = str;
        a(aVar.a((Short) 1500), null, null);
        AppMethodBeat.o(159717);
    }

    private static void a(a.C2146a aVar, a.b bVar, a.c cVar) {
        AppMethodBeat.i(159718);
        if (bVar != null) {
            aVar.a(bVar);
        }
        if (cVar != null) {
            aVar.a(cVar);
        }
        aVar.hcA();
        AppMethodBeat.o(159718);
    }

    public static boolean bJw() {
        return QVB;
    }

    public static void Dt(boolean z) {
        QVB = z;
    }
}
