package com.tencent.luggage.sdk.g;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0005\u001a\u0004\u0018\u0001H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00060\tH\b¢\u0006\u0002\u0010\nJP\u0010\u0005\u001a\u0004\u0018\u0001H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00060\t2 \u0010\u000b\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u0001H\u0006\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\b¢\u0006\u0002\u0010\u000fJ6\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/luggage/sdk/wxa_ktx/Profile;", "", "()V", "TAG", "", "runProfiled", "R", "logName", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "profileFunc", "Lkotlin/Function3;", "", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "run", "Ljava/lang/Runnable;", "Lkotlin/Function2;", "ProfileReturnObject", "luggage-wxa-app_release"})
public final class c {
    public static final c cCI = new c();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, hxF = {"Lcom/tencent/luggage/sdk/wxa_ktx/Profile$ProfileReturnObject;", "", "runProfiledToString", "", "luggage-wxa-app_release"})
    public interface a {
        String Pb();
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "invoke"})
    public static final class b extends q implements m<Long, Long, x> {
        public static final b cCJ = new b();

        static {
            AppMethodBeat.i(219640);
            AppMethodBeat.o(219640);
        }

        b() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Long l, Long l2) {
            AppMethodBeat.i(219639);
            l.longValue();
            l2.longValue();
            x xVar = x.SXb;
            AppMethodBeat.o(219639);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(135555);
        AppMethodBeat.o(135555);
    }

    private c() {
    }

    public static final <R> R a(String str, kotlin.g.a.a<? extends R> aVar, kotlin.g.a.q<? super R, ? super Long, ? super Long, x> qVar) {
        String str2;
        AppMethodBeat.i(219641);
        p.h(str, "logName");
        p.h(aVar, "block");
        p.h(qVar, "profileFunc");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        R r = (R) aVar.invoke();
        if (r instanceof a) {
            str2 = r.Pb();
        } else if (r == null || (str2 = r.toString()) == null) {
            str2 = "";
        }
        boolean LB = ag.LB();
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (elapsedRealtime2 <= 32 || !LB) {
            Log.i("Luggage.Utils.Profile", "runProfiled:log:" + str + " cost " + elapsedRealtime2 + " ms result:" + str2 + " isMainThread: " + LB + ' ');
        } else {
            Log.w("Luggage.Utils.Profile", "block main thread and skip " + ((int) (elapsedRealtime2 / 16)) + " frames! runProfiled:log:" + str + " cost " + elapsedRealtime2 + " ms result:" + str2 + " isMainThread: " + LB + ' ');
        }
        AppMethodBeat.o(219641);
        return r;
    }

    public static final <R> R a(String str, kotlin.g.a.a<? extends R> aVar) {
        String str2;
        AppMethodBeat.i(135553);
        p.h(str, "logName");
        p.h(aVar, "block");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        R r = (R) aVar.invoke();
        if (r instanceof a) {
            str2 = r.Pb();
        } else if (r == null || (str2 = r.toString()) == null) {
            str2 = "";
        }
        boolean LB = ag.LB();
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (elapsedRealtime2 <= 32 || !LB) {
            Log.i("Luggage.Utils.Profile", "runProfiled:log:" + str + " cost " + elapsedRealtime2 + " ms result:" + str2 + " isMainThread: " + LB + ' ');
        } else {
            Log.w("Luggage.Utils.Profile", "block main thread and skip " + ((int) (elapsedRealtime2 / 16)) + " frames! runProfiled:log:" + str + " cost " + elapsedRealtime2 + " ms result:" + str2 + " isMainThread: " + LB + ' ');
        }
        AppMethodBeat.o(135553);
        return r;
    }

    public static final String a(String str, Runnable runnable) {
        AppMethodBeat.i(135554);
        p.h(str, "logName");
        p.h(runnable, "run");
        p.h(b.cCJ, "profileFunc");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        runnable.run();
        String obj = "".toString();
        if (obj == null) {
            obj = "";
        }
        boolean LB = ag.LB();
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (elapsedRealtime2 <= 32 || !LB) {
            Log.i("Luggage.Utils.Profile", "runProfiled:log:" + str + " cost " + elapsedRealtime2 + " ms result:" + obj + " isMainThread: " + LB + ' ');
        } else {
            Log.w("Luggage.Utils.Profile", "block main thread and skip " + ((int) (elapsedRealtime2 / 16)) + " frames! runProfiled:log:" + str + " cost " + elapsedRealtime2 + " ms result:" + obj + " isMainThread: " + LB + ' ');
        }
        AppMethodBeat.o(135554);
        return "";
    }
}
