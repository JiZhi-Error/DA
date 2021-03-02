package com.tencent.mm.kernel.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import junit.framework.Assert;

public final class a {
    private static ThreadLocal<Stack<b>> hsE = new ThreadLocal<>();

    static {
        AppMethodBeat.i(158358);
        AppMethodBeat.o(158358);
    }

    static void start() {
        AppMethodBeat.i(158356);
        b bVar = new b();
        Stack<b> stack = hsE.get();
        if (stack == null) {
            stack = new Stack<>();
            hsE.set(stack);
        }
        stack.push(bVar);
        AppMethodBeat.o(158356);
    }

    static class b {
        public HashMap<Class, C0365a> mMap = null;

        b() {
        }
    }

    /* renamed from: com.tencent.mm.kernel.a.b.a$a  reason: collision with other inner class name */
    public static class C0365a {
        Object hsB;
        Class hsF;
        Set hsG = new HashSet();

        C0365a(Object obj, Class cls) {
            AppMethodBeat.i(158352);
            this.hsB = obj;
            if (cls != null) {
                this.hsF = cls;
            }
            bH(this.hsB);
            AppMethodBeat.o(158352);
        }

        private void bH(Object obj) {
            AppMethodBeat.i(158353);
            Assert.assertNotNull(obj);
            Assert.assertNotNull(this.hsF);
            if (!this.hsF.isInstance(obj)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Your depend object " + obj + " must implement your type " + this.hsF);
                AppMethodBeat.o(158353);
                throw illegalArgumentException;
            }
            AppMethodBeat.o(158353);
        }

        public final C0365a bI(Object obj) {
            AppMethodBeat.i(158354);
            this.hsG.add(obj);
            bH(obj);
            AppMethodBeat.o(158354);
            return this;
        }
    }

    public static C0365a a(Object obj, Class cls) {
        AppMethodBeat.i(158355);
        b peek = hsE.get().peek();
        Assert.assertNotNull(peek);
        if (peek.mMap == null) {
            peek.mMap = new HashMap<>();
        }
        C0365a aVar = peek.mMap.get(cls);
        if (aVar == null) {
            aVar = new C0365a(obj, cls);
            peek.mMap.put(aVar.hsF, aVar);
        }
        AppMethodBeat.o(158355);
        return aVar;
    }

    static b aAI() {
        AppMethodBeat.i(158357);
        b pop = hsE.get().pop();
        AppMethodBeat.o(158357);
        return pop;
    }
}
