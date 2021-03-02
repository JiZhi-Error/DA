package kotlin.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.DownloadSetting;
import java.lang.annotation.Annotation;
import kotlin.g.b.aa;
import kotlin.g.b.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.b;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u001f\u0010\u0018\u001a\u00020\u0019\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\r*\u0006\u0012\u0002\b\u00030\u001a¢\u0006\u0002\u0010\u001b\"'\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"-\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00018G¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"&\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\u0002H\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000e\";\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018Ç\u0002X\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"+\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000b\"-\u0010\u0013\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000b\"+\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, hxF = {"annotationClass", "Lkotlin/reflect/KClass;", "T", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "java", "Ljava/lang/Class;", "java$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "javaClass$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-stdlib"})
public final class a {
    public static final <T> Class<T> a(b<T> bVar) {
        AppMethodBeat.i(129345);
        p.h(bVar, "$this$java");
        Class<T> cls = (Class<T>) ((g) bVar).hxU();
        if (cls == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.Class<T>");
            AppMethodBeat.o(129345);
            throw tVar;
        }
        AppMethodBeat.o(129345);
        return cls;
    }

    public static final <T> Class<T> b(b<T> bVar) {
        AppMethodBeat.i(129346);
        p.h(bVar, "$this$javaPrimitiveType");
        Class<T> cls = (Class<T>) ((g) bVar).hxU();
        if (!cls.isPrimitive()) {
            String name = cls.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -2056817302:
                        if (name.equals("java.lang.Integer")) {
                            Class<T> cls2 = Integer.TYPE;
                            AppMethodBeat.o(129346);
                            return cls2;
                        }
                        break;
                    case -527879800:
                        if (name.equals("java.lang.Float")) {
                            Class<T> cls3 = Float.TYPE;
                            AppMethodBeat.o(129346);
                            return cls3;
                        }
                        break;
                    case -515992664:
                        if (name.equals("java.lang.Short")) {
                            Class<T> cls4 = Short.TYPE;
                            AppMethodBeat.o(129346);
                            return cls4;
                        }
                        break;
                    case 155276373:
                        if (name.equals("java.lang.Character")) {
                            Class<T> cls5 = Character.TYPE;
                            AppMethodBeat.o(129346);
                            return cls5;
                        }
                        break;
                    case 344809556:
                        if (name.equals("java.lang.Boolean")) {
                            Class<T> cls6 = Boolean.TYPE;
                            AppMethodBeat.o(129346);
                            return cls6;
                        }
                        break;
                    case 398507100:
                        if (name.equals("java.lang.Byte")) {
                            Class<T> cls7 = Byte.TYPE;
                            AppMethodBeat.o(129346);
                            return cls7;
                        }
                        break;
                    case 398795216:
                        if (name.equals("java.lang.Long")) {
                            Class<T> cls8 = Long.TYPE;
                            AppMethodBeat.o(129346);
                            return cls8;
                        }
                        break;
                    case 399092968:
                        if (name.equals("java.lang.Void")) {
                            Class<T> cls9 = Void.TYPE;
                            AppMethodBeat.o(129346);
                            return cls9;
                        }
                        break;
                    case 761287205:
                        if (name.equals("java.lang.Double")) {
                            Class<T> cls10 = Double.TYPE;
                            AppMethodBeat.o(129346);
                            return cls10;
                        }
                        break;
                }
            }
            AppMethodBeat.o(129346);
            return null;
        } else if (cls == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.Class<T>");
            AppMethodBeat.o(129346);
            throw tVar;
        } else {
            AppMethodBeat.o(129346);
            return cls;
        }
    }

    public static final <T> Class<T> c(b<T> bVar) {
        AppMethodBeat.i(129347);
        p.h(bVar, "$this$javaObjectType");
        Class<T> cls = (Class<T>) ((g) bVar).hxU();
        if (cls.isPrimitive()) {
            String name = cls.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -1325958191:
                        if (name.equals("double")) {
                            cls = (Class<T>) Double.class;
                            break;
                        }
                        break;
                    case 104431:
                        if (name.equals("int")) {
                            cls = (Class<T>) Integer.class;
                            break;
                        }
                        break;
                    case 3039496:
                        if (name.equals("byte")) {
                            cls = (Class<T>) Byte.class;
                            break;
                        }
                        break;
                    case 3052374:
                        if (name.equals("char")) {
                            cls = (Class<T>) Character.class;
                            break;
                        }
                        break;
                    case 3327612:
                        if (name.equals("long")) {
                            cls = (Class<T>) Long.class;
                            break;
                        }
                        break;
                    case 3625364:
                        if (name.equals("void")) {
                            cls = (Class<T>) Void.class;
                            break;
                        }
                        break;
                    case 64711720:
                        if (name.equals(DownloadSetting.TYPE_BOOLEAN)) {
                            cls = (Class<T>) Boolean.class;
                            break;
                        }
                        break;
                    case 97526364:
                        if (name.equals("float")) {
                            cls = (Class<T>) Float.class;
                            break;
                        }
                        break;
                    case 109413500:
                        if (name.equals("short")) {
                            cls = (Class<T>) Short.class;
                            break;
                        }
                        break;
                }
            }
            if (cls == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.Class<T>");
                AppMethodBeat.o(129347);
                throw tVar;
            }
            AppMethodBeat.o(129347);
        } else if (cls == null) {
            t tVar2 = new t("null cannot be cast to non-null type java.lang.Class<T>");
            AppMethodBeat.o(129347);
            throw tVar2;
        } else {
            AppMethodBeat.o(129347);
        }
        return cls;
    }

    public static final <T> b<T> bo(Class<T> cls) {
        AppMethodBeat.i(129348);
        p.h(cls, "$this$kotlin");
        b<T> bp = aa.bp(cls);
        AppMethodBeat.o(129348);
        return bp;
    }

    public static final <T extends Annotation> b<? extends T> a(T t) {
        AppMethodBeat.i(129349);
        p.h(t, "$this$annotationClass");
        Class<? extends Annotation> annotationType = t.annotationType();
        p.g(annotationType, "(this as java.lang.annot…otation).annotationType()");
        b<? extends T> bo = bo(annotationType);
        if (bo == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
            AppMethodBeat.o(129349);
            throw tVar;
        }
        AppMethodBeat.o(129349);
        return bo;
    }
}
