package com.tencent.mm.plugin.finder.nearby.report;

import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0007J.\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012J.\u0010\u0013\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012JH\u0010\u0014\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\u0002J@\u0010\u0014\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/report/NearbyPersonReporter;", "", "()V", "TAG", "", "sessionId", "onConfirmClearAndExitClick", "", "onFilterActionSelect", "filterType", "", "onFilterButtonClick", "onUserClick", "userName", "district", UserDataStore.COUNTRY, "city", "ifSns", "", "onUserExpose", "report", "distance", "", NativeProtocol.WEB_DIALOG_ACTION, "plugin-finder_release"})
public final class b {
    private static String sessionId = "";
    public static final b uSZ = new b();

    static {
        AppMethodBeat.i(249336);
        AppMethodBeat.o(249336);
    }

    private b() {
    }

    public static void JE(int i2) {
        long j2;
        AppMethodBeat.i(249333);
        switch (i2) {
            case 1:
                j2 = 1;
                break;
            case 2:
                j2 = 2;
                break;
            case 3:
                j2 = 3;
                break;
            case 4:
                j2 = 4;
                break;
            case 5:
                j2 = 5;
                break;
            case 6:
                j2 = 6;
                break;
            default:
                j2 = 3;
                break;
        }
        a("", 0, "", "", "", 0, 3, j2);
        AppMethodBeat.o(249333);
    }

    public static void a(String str, String str2, String str3, String str4, boolean z, long j2) {
        String str5;
        long j3;
        long j4;
        AppMethodBeat.i(249334);
        String str6 = "";
        try {
            if (n.a((CharSequence) str2, (CharSequence) " - ", false)) {
                str6 = str2.subSequence(n.a((CharSequence) str2, " - ", 0, false, 6) + 3, str2.length()).toString();
            }
            if (n.a((CharSequence) str2, (CharSequence) "公里", false)) {
                j3 = Long.parseLong(str2.subSequence(0, n.a((CharSequence) str2, "公里", 0, false, 6)).toString()) * 1000;
                str5 = str6;
            } else {
                if (n.a((CharSequence) str2, (CharSequence) "米", false)) {
                    j4 = Long.parseLong(str2.subSequence(0, n.a((CharSequence) str2, "米", 0, false, 6)).toString());
                } else {
                    j4 = 0;
                }
                str5 = str6;
                j3 = j4;
            }
        } catch (Throwable th) {
            Log.e("NearbyPersonReporter", th.toString());
            str5 = str6;
            j3 = 0;
        }
        a(str, j3, str3, str4, str5, z ? 1 : 0, j2, 3);
        AppMethodBeat.o(249334);
    }

    public static void a(String str, long j2, String str2, String str3, String str4, long j3, long j4, long j5) {
        AppMethodBeat.i(249335);
        v vVar = new v();
        if (TextUtils.isEmpty(sessionId)) {
            String cMD = ((c) g.af(c.class)).cMD();
            if (cMD == null) {
                cMD = "";
            }
            sessionId = cMD;
        }
        vVar.hU(sessionId);
        d dVar = d.uTq;
        vVar.hV(d.acj());
        d dVar2 = d.uTq;
        vVar.hW(d.dlz());
        vVar.aca();
        vVar.hY(str);
        vVar.ia(str2);
        vVar.hZ(str3);
        vVar.bR(j2);
        vVar.hX(str4);
        vVar.bS(j3);
        vVar.bT(j4);
        vVar.bU(cl.aWA());
        vVar.bV(j5);
        vVar.bfK();
        Log.d("NearbyPersonReporter", "report " + vVar.abW());
        AppMethodBeat.o(249335);
    }
}
