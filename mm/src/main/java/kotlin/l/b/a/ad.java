package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.lang.reflect.Method;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.l.b.a.b.b.d.b.b;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, hxF = {"signature", "", "Ljava/lang/reflect/Method;", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "kotlin-reflection"})
public final class ad {
    static final String c(Method method) {
        AppMethodBeat.i(56553);
        StringBuilder append = new StringBuilder().append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        p.g(parameterTypes, "parameterTypes");
        StringBuilder append2 = append.append(e.a(parameterTypes, "", "(", ")", 0, (CharSequence) null, a.TbK, 24));
        Class<?> returnType = method.getReturnType();
        p.g(returnType, "returnType");
        String sb = append2.append(b.bC(returnType)).toString();
        AppMethodBeat.o(56553);
        return sb;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"})
    public static final class a extends q implements kotlin.g.a.b<Class<?>, String> {
        public static final a TbK = new a();

        static {
            AppMethodBeat.i(56552);
            AppMethodBeat.o(56552);
        }

        a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(Class<?> cls) {
            AppMethodBeat.i(56551);
            Class<?> cls2 = cls;
            p.g(cls2, LocaleUtil.ITALIAN);
            String bC = b.bC(cls2);
            AppMethodBeat.o(56551);
            return bC;
        }
    }
}
