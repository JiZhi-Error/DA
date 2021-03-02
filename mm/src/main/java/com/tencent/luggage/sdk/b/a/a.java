package com.tencent.luggage.sdk.b.a;

import com.tencent.luggage.sdk.b.a.a.AbstractC0178a;
import com.tencent.luggage.sdk.b.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a<ComponentImpType extends b, ComponentLogicImp extends AbstractC0178a, Component extends f> {
    private ConcurrentHashMap<String, Class<? extends ComponentLogicImp>> czl = new ConcurrentHashMap<>(2);

    public interface b {
    }

    public a() {
        AppMethodBeat.i(146714);
        AppMethodBeat.o(146714);
    }

    public final void a(ComponentImpType componentimptype, Class<? extends ComponentLogicImp> cls) {
        AppMethodBeat.i(146715);
        this.czl.put(componentimptype.getClass().getName(), cls);
        AppMethodBeat.o(146715);
    }

    public final ComponentLogicImp a(ComponentImpType componentimptype, Component component) {
        AppMethodBeat.i(146716);
        Class<? extends ComponentLogicImp> cls = this.czl.get(componentimptype.getClass().getName());
        if (cls != null) {
            try {
                ComponentLogicImp componentlogicimp = (ComponentLogicImp) ((AbstractC0178a) org.a.a.bF(cls).ak(component).object);
                AppMethodBeat.o(146716);
                return componentlogicimp;
            } catch (Exception e2) {
                Log.printErrStackTrace("Luggage.AppBrandLogicFactory", e2, "hy: construct failed!", new Object[0]);
                AppMethodBeat.o(146716);
                return null;
            }
        } else {
            Log.w("Luggage.AppBrandLogicFactory", "hy: implement corresponding to type %s not found!", componentimptype);
            AppMethodBeat.o(146716);
            return null;
        }
    }

    /* renamed from: com.tencent.luggage.sdk.b.a.a$a  reason: collision with other inner class name */
    public static abstract class AbstractC0178a<Component extends f> {
        protected Component czm;
        protected final Map<Class, Object> czn = new HashMap(2);

        public AbstractC0178a(Component component) {
            this.czm = component;
        }

        public final synchronized Component NN() {
            return this.czm;
        }

        /* access modifiers changed from: protected */
        public final <T> void b(Class<T> cls, T t) {
            synchronized (this.czn) {
                this.czn.put(cls, t);
            }
        }

        public <T> T S(Class<T> cls) {
            T cast;
            synchronized (this.czn) {
                cast = cls.cast(this.czn.get(cls));
                if (cast == null) {
                    Iterator<Object> it = this.czn.values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            cast = null;
                            break;
                        }
                        Object next = it.next();
                        if (cls.isInstance(next)) {
                            cast = cls.cast(next);
                            break;
                        }
                    }
                }
            }
            return cast;
        }

        /* access modifiers changed from: protected */
        public final Collection<Object> NO() {
            LinkedList linkedList;
            synchronized (this.czn) {
                linkedList = new LinkedList(this.czn.values());
            }
            return linkedList;
        }
    }
}
