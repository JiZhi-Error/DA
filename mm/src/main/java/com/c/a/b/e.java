package com.c.a.b;

import com.c.a.b.a.a;
import com.c.a.b.b;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class e {
    private static final Set<String> coK = new HashSet(Arrays.asList(Boolean.class.getName(), Character.class.getName(), Float.class.getName(), Double.class.getName(), Byte.class.getName(), Short.class.getName(), Integer.class.getName(), Long.class.getName()));

    public static String d(Map.Entry<d, Object> entry) {
        return a(entry.getKey(), entry.getValue());
    }

    private static String a(d dVar, Object obj) {
        return dVar.mName + " = " + obj;
    }

    public static boolean b(c cVar) {
        for (c cVar2 = cVar; cVar2.Kd() != null; cVar2 = cVar2.Kd()) {
            if (cVar.mClassName.equals(Thread.class.getName())) {
                return true;
            }
        }
        return false;
    }

    public static String as(Object obj) {
        boolean z;
        boolean z2;
        Integer num;
        boolean z3 = true;
        i iVar = (i) obj;
        List<b.a> Kb = ((b) iVar).Kb();
        Integer num2 = (Integer) b(Kb, "count");
        com.tencent.matrix.resource.analyzer.a.b.checkNotNull(num2, "count");
        if (num2.intValue() == 0) {
            return "";
        }
        Object b2 = b(Kb, "value");
        com.tencent.matrix.resource.analyzer.a.b.checkNotNull(b2, "value");
        if (!(b2 instanceof a) || ((a) b2).cow != p.CHAR) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            a aVar = (a) b2;
            Iterator<b.a> it = Kb.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().coy.mName.equals("offset")) {
                        break;
                    }
                } else {
                    z3 = false;
                    break;
                }
            }
            if (z3) {
                num = (Integer) b(Kb, "offset");
                com.tencent.matrix.resource.analyzer.a.b.checkNotNull(num, "offset");
            } else {
                num = 0;
            }
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            if (a.$assertionsDisabled || aVar.cow == p.CHAR) {
                char[] cArr = new char[intValue2];
                ByteBuffer.wrap(aVar.bR(intValue, intValue2)).order(a.cqa).asCharBuffer().get(cArr);
                return new String(cArr);
            }
            throw new AssertionError();
        }
        if (!(b2 instanceof a) || ((a) b2).cow != p.BYTE) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            a aVar2 = (a) b2;
            try {
                Method declaredMethod = a.class.getDeclaredMethod("bR", Integer.TYPE, Integer.TYPE);
                declaredMethod.setAccessible(true);
                return new String((byte[]) declaredMethod.invoke(aVar2, 0, num2), Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException(e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException(e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException(e4);
            }
        } else {
            throw new UnsupportedOperationException("Could not find char array in ".concat(String.valueOf(iVar)));
        }
    }

    public static boolean aB(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        return coK.contains(((b) obj).Ka().mClassName);
    }

    public static boolean aC(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (aVar.cow != p.OBJECT) {
            return true;
        }
        return coK.contains(aVar.Ka().mClassName);
    }

    public static List<b.a> b(i iVar) {
        return ((b) iVar).Kb();
    }

    public static <T> T b(List<b.a> list, String str) {
        for (b.a aVar : list) {
            if (aVar.coy.mName.equals(str)) {
                return (T) aVar.mValue;
            }
        }
        throw new IllegalArgumentException("Field " + str + " does not exists");
    }

    public static String a(b.a aVar) {
        return a(aVar.coy, aVar.mValue);
    }

    public static String a(i iVar) {
        Object b2 = b(((b) iVar).Kb(), "name");
        if (b2 == null) {
            return "Thread name not available";
        }
        return as(b2);
    }
}
