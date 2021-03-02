package kotlin.e;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import kotlin.g.b.p;
import kotlin.j.b;
import kotlin.j.c;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, hxF = {"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "ReflectAddSuppressedMethod", "kotlin-stdlib"})
public class a {

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lkotlin/internal/PlatformImplementations$ReflectAddSuppressedMethod;", "", "()V", FirebaseAnalytics.b.METHOD, "Ljava/lang/reflect/Method;", "kotlin-stdlib"})
    /* renamed from: kotlin.e.a$a  reason: collision with other inner class name */
    public static final class C2263a {
        public static final C2263a SYd = new C2263a();
        public static final Method method;

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0060 A[LOOP:0: B:1:0x001e->B:16:0x0060, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0055 A[SYNTHETIC] */
        static {
            /*
                r1 = 0
                r10 = 128990(0x1f7de, float:1.80753E-40)
                r3 = 1
                r4 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.i(r10)
                kotlin.e.a$a r0 = new kotlin.e.a$a
                r0.<init>()
                kotlin.e.a.C2263a.SYd = r0
                java.lang.Class<java.lang.Throwable> r6 = java.lang.Throwable.class
                java.lang.reflect.Method[] r7 = r6.getMethods()
                java.lang.String r0 = "throwableClass.methods"
                kotlin.g.b.p.g(r7, r0)
                int r8 = r7.length
                r5 = r4
            L_0x001e:
                if (r5 >= r8) goto L_0x0056
                r2 = r7[r5]
                java.lang.String r0 = "it"
                kotlin.g.b.p.g(r2, r0)
                java.lang.String r0 = r2.getName()
                java.lang.String r9 = "addSuppressed"
                boolean r0 = kotlin.g.b.p.j(r0, r9)
                if (r0 == 0) goto L_0x005e
                java.lang.Class[] r0 = r2.getParameterTypes()
                java.lang.String r9 = "it.parameterTypes"
                kotlin.g.b.p.g(r0, r9)
                java.lang.String r9 = "$this$singleOrNull"
                kotlin.g.b.p.h(r0, r9)
                int r9 = r0.length
                if (r9 != r3) goto L_0x005c
                r0 = r0[r4]
            L_0x004a:
                java.lang.Class r0 = (java.lang.Class) r0
                boolean r0 = kotlin.g.b.p.j(r0, r6)
                if (r0 == 0) goto L_0x005e
                r0 = r3
            L_0x0053:
                if (r0 == 0) goto L_0x0060
                r1 = r2
            L_0x0056:
                kotlin.e.a.C2263a.method = r1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r10)
                return
            L_0x005c:
                r0 = r1
                goto L_0x004a
            L_0x005e:
                r0 = r4
                goto L_0x0053
            L_0x0060:
                int r0 = r5 + 1
                r5 = r0
                goto L_0x001e
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.e.a.C2263a.<clinit>():void");
        }

        private C2263a() {
        }
    }

    public void a(Throwable th, Throwable th2) {
        AppMethodBeat.i(128995);
        p.h(th, "cause");
        p.h(th2, "exception");
        Method method = C2263a.method;
        if (method != null) {
            method.invoke(th, th2);
            AppMethodBeat.o(128995);
            return;
        }
        AppMethodBeat.o(128995);
    }

    public static c hxN() {
        AppMethodBeat.i(128996);
        b bVar = new b();
        AppMethodBeat.o(128996);
        return bVar;
    }
}
