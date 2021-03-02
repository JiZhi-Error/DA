package com.tencent.mm.plugin.expt.hellhound.core.a.b;

import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/core/component/reflector/HellKReflector;", "", "()V", "Companion", "plugin-expt_release"})
public final class a {
    public static final C1025a szr = new C1025a((byte) 0);

    static {
        AppMethodBeat.i(122559);
        AppMethodBeat.o(122559);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0007J\u000e\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0007J2\u0010\u0013\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0018\u00010\u0014j\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0018\u0001`\u00152\f\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0007J*\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0018H\u0002J\u0018\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0007J\"\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\f\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0007J?\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\f\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010!\u001a\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0004\u0018\u00010\"H\u0007¢\u0006\u0002\u0010#J<\u0010$\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010%2\f\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0007J,\u0010'\u001a\u0004\u0018\u00010\u00012\f\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0007J\u001e\u0010'\u001a\u0004\u0018\u00010\u00012\b\u0010&\u001a\u0004\u0018\u00010\u00012\b\u0010(\u001a\u0004\u0018\u00010\u001cH\u0007J(\u0010'\u001a\u0004\u0018\u00010\u00012\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\u0010&\u001a\u0004\u0018\u00010\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0007J2\u0010)\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010%2\f\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0007J\"\u0010*\u001a\u0004\u0018\u00010\u00012\f\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0007J\b\u0010+\u001a\u00020\u000bH\u0002J[\u0010,\u001a\u0004\u0018\u00010\u00012\f\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00012\b\u0010 \u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010!\u001a\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0004\u0018\u00010\"2\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"H\u0007¢\u0006\u0002\u0010.J9\u0010,\u001a\u0004\u0018\u00010\u00012\b\u0010&\u001a\u0004\u0018\u00010\u00012\b\u0010/\u001a\u0004\u0018\u00010\u001f2\u0014\b\u0002\u00100\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\"H\u0007¢\u0006\u0002\u00101JS\u00102\u001a\u0004\u0018\u00010\u00012\f\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010!\u001a\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0004\u0018\u00010\"2\u0012\b\u0002\u0010-\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\"H\u0007¢\u0006\u0002\u00103J \u00104\u001a\u0002052\b\u0010&\u001a\u0004\u0018\u00010\u00012\f\u00106\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0007J7\u00107\u001a\u0004\u0018\u00010\u00012\b\u00108\u001a\u0004\u0018\u0001092\u0012\u0010:\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0018\u00010\"2\b\u0010;\u001a\u0004\u0018\u00010<H\u0007¢\u0006\u0002\u0010=J\u0012\u0010>\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u00010?H\u0007J&\u0010@\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010\u001c2\b\u0010&\u001a\u0004\u0018\u00010\u00012\b\u0010A\u001a\u0004\u0018\u00010\u0001H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/core/component/reflector/HellKReflector$Companion;", "", "()V", "ActivityThreadClass", "Ljava/lang/Class;", "TAG", "", "sCurrentActivityThread", "sMainThreadHandler", "Landroid/os/Handler;", "execOnMainThread", "", "runnable", "Ljava/lang/Runnable;", "execOnMainThreadDelayed", "delayMillis", "", "getActivityThread", "getActivityThreadClazz", "getAllInterfaces", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "clazz", "interfacesFound", "Ljava/util/HashSet;", "getClass", "className", "getDeclaredField", "Ljava/lang/reflect/Field;", "fieldName", "getDeclaredMethod", "Ljava/lang/reflect/Method;", "methodName", "paramTypes", "", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "getFieldAndObj", "Lkotlin/Pair;", "obj", "getFieldObject", "field", "getStaticFieldAndObj", "getStaticFieldObject", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "invokeMethod", NativeProtocol.WEB_DIALOG_PARAMS, "(Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;", FirebaseAnalytics.b.METHOD, "args", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "invokeStaticMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;", "isInstance", "", "classType", "newProxy", "classLoader", "Ljava/lang/ClassLoader;", "interfaces", "handle", "Ljava/lang/reflect/InvocationHandler;", "(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;", "reflect", "Lcom/tencent/mm/plugin/expt/hellhound/core/component/reflector/HellKArgs;", "setField", "value", "plugin-expt_release"})
    /* renamed from: com.tencent.mm.plugin.expt.hellhound.core.a.b.a$a  reason: collision with other inner class name */
    public static final class C1025a {
        private C1025a() {
        }

        public /* synthetic */ C1025a(byte b2) {
            this();
        }

        public static Class<?> getClass(String str) {
            AppMethodBeat.i(122557);
            try {
                Class<?> cls = Class.forName(str);
                AppMethodBeat.o(122557);
                return cls;
            } catch (ClassNotFoundException e2) {
                AppMethodBeat.o(122557);
                return null;
            }
        }

        public static boolean b(Object obj, Class<?> cls) {
            AppMethodBeat.i(122558);
            if (cls != null) {
                boolean isInstance = cls.isInstance(obj);
                AppMethodBeat.o(122558);
                return isInstance;
            }
            AppMethodBeat.o(122558);
            return false;
        }
    }
}
