package com.google.a;

import com.google.a.ae;
import com.google.a.bw;
import com.google.a.l;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public final class j implements av {
    private static final Set<String> bNA = new HashSet(Arrays.asList("cached_size", "serialized_size", "class"));
    private static a bNB = new a();
    private static final j bNz = new j();

    private j() {
    }

    @Override // com.google.a.av
    public final boolean C(Class<?> cls) {
        return ac.class.isAssignableFrom(cls);
    }

    @Override // com.google.a.av
    public final au D(Class<?> cls) {
        if (!ac.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        l.a AS = E(cls).AS();
        switch (AS.bSr.FQ()) {
            case PROTO2:
                return a(cls, AS);
            case PROTO3:
                return b(cls, AS);
            default:
                throw new IllegalArgumentException("Unsupported syntax: " + AS.bSr.FQ());
        }
    }

    private static at E(Class<?> cls) {
        try {
            return (at) cls.getDeclaredMethod("getDefaultInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e2) {
            throw new IllegalArgumentException("Unable to get default instance for message class " + cls.getName(), e2);
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private final Map<l.a, Boolean> bNH = new ConcurrentHashMap();
        private final Stack<C0091a> bNI = new Stack<>();
        private final Map<l.a, C0091a> bNJ = new HashMap();
        private int index = 0;

        a() {
        }

        public final boolean a(l.a aVar) {
            Boolean bool = this.bNH.get(aVar);
            if (bool != null) {
                return bool.booleanValue();
            }
            synchronized (this) {
                Boolean bool2 = this.bNH.get(aVar);
                if (bool2 != null) {
                    return bool2.booleanValue();
                }
                return b(aVar).bNM.bNO;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.google.a.j$a$a  reason: collision with other inner class name */
        public static class C0091a {
            final l.a bNK;
            int bNL;
            b bNM = null;
            final int index;

            C0091a(l.a aVar, int i2) {
                this.bNK = aVar;
                this.index = i2;
                this.bNL = i2;
            }
        }

        /* access modifiers changed from: package-private */
        public static class b {
            final List<l.a> bNN;
            boolean bNO;

            private b() {
                this.bNN = new ArrayList();
                this.bNO = false;
            }

            /* synthetic */ b(byte b2) {
                this();
            }
        }

        private C0091a b(l.a aVar) {
            C0091a pop;
            int i2 = this.index;
            this.index = i2 + 1;
            C0091a aVar2 = new C0091a(aVar, i2);
            this.bNI.push(aVar2);
            this.bNJ.put(aVar, aVar2);
            for (l.f fVar : aVar.getFields()) {
                if (fVar.bSS.bTz == l.f.a.MESSAGE) {
                    C0091a aVar3 = this.bNJ.get(fVar.FN());
                    if (aVar3 == null) {
                        aVar2.bNL = Math.min(aVar2.bNL, b(fVar.FN()).bNL);
                    } else if (aVar3.bNM == null) {
                        aVar2.bNL = Math.min(aVar2.bNL, aVar3.bNL);
                    }
                }
            }
            if (aVar2.index == aVar2.bNL) {
                b bVar = new b((byte) 0);
                do {
                    pop = this.bNI.pop();
                    pop.bNM = bVar;
                    bVar.bNN.add(pop.bNK);
                } while (pop != aVar2);
                a(bVar);
            }
            return aVar2;
        }

        private void a(b bVar) {
            boolean z;
            Iterator<l.a> it = bVar.bNN.iterator();
            loop0:
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                l.a next = it.next();
                if (next.FA()) {
                    z = true;
                    break;
                }
                Iterator<l.f> it2 = next.getFields().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        l.f next2 = it2.next();
                        if (next2.FH()) {
                            z = true;
                            break loop0;
                        } else if (next2.bSS.bTz == l.f.a.MESSAGE) {
                            C0091a aVar = this.bNJ.get(next2.FN());
                            if (aVar.bNM != bVar && aVar.bNM.bNO) {
                                z = true;
                                break loop0;
                            }
                        }
                    }
                }
            }
            bVar.bNO = z;
            for (l.a aVar2 : bVar.bNN) {
                this.bNH.put(aVar2, Boolean.valueOf(bVar.bNO));
            }
        }
    }

    private static bw a(Class<?> cls, l.a aVar) {
        int i2;
        List<l.f> fields = aVar.getFields();
        bw.a gO = bw.gO(fields.size());
        gO.bZs = E(cls);
        gO.a(bl.PROTO2);
        gO.bWz = aVar.bSq.AG().bRt;
        b bVar = new b((byte) 0);
        int i3 = 0;
        int i4 = 1;
        Field field = null;
        int i5 = 0;
        while (i5 < fields.size()) {
            final l.f fVar = fields.get(i5);
            boolean z = fVar.bSr.bTB.CQ().bQY;
            ae.c cVar = null;
            if (fVar.bSS.bTz == l.f.a.ENUM) {
                cVar = new ae.c() {
                    /* class com.google.a.j.AnonymousClass1 */
                };
            }
            if (fVar.bSU != null) {
                gO.a(a(cls, fVar, bVar, z, cVar));
            } else {
                Field a2 = a(cls, fVar);
                int i6 = fVar.bSP.bPE;
                y a3 = a(fVar);
                if (fVar.FG()) {
                    final l.f gz = fVar.FN().gz(2);
                    if (gz.bSS.bTz == l.f.a.ENUM) {
                        cVar = new ae.c() {
                            /* class com.google.a.j.AnonymousClass2 */
                        };
                    }
                    gO.a(w.a(a2, i6, bt.d(cls, fVar.bSP.getName()), cVar));
                    i2 = i3;
                } else if (!fVar.FJ()) {
                    if (field == null) {
                        field = a(cls, "bitField" + i3 + "_");
                    }
                    if (fVar.FH()) {
                        gO.a(w.b(a2, i6, a3, field, i4, z, cVar));
                    } else {
                        gO.a(w.a(a2, i6, a3, field, i4, z, cVar));
                    }
                } else if (cVar != null) {
                    if (fVar.FK()) {
                        gO.a(w.a(a2, i6, a3, cVar, b(cls, fVar)));
                        i2 = i3;
                    } else {
                        gO.a(w.a(a2, i6, a3, cVar));
                        i2 = i3;
                    }
                } else if (fVar.bSS.bTz == l.f.a.MESSAGE) {
                    gO.a(w.a(a2, i6, a3, d(cls, fVar)));
                    i2 = i3;
                } else if (fVar.FK()) {
                    gO.a(w.a(a2, i6, a3, b(cls, fVar)));
                    i2 = i3;
                } else {
                    gO.a(w.a(a2, i6, a3, z));
                    i2 = i3;
                }
                i5++;
                i3 = i2;
            }
            i4 <<= 1;
            if (i4 == 0) {
                field = null;
                i4 = 1;
                i2 = i3 + 1;
            } else {
                i2 = i3;
            }
            i5++;
            i3 = i2;
        }
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < fields.size(); i7++) {
            l.f fVar2 = fields.get(i7);
            if (!fVar2.FH()) {
                if (fVar2.bSS.bTz == l.f.a.MESSAGE) {
                    if (!bNB.a(fVar2.FN())) {
                    }
                }
            }
            arrayList.add(Integer.valueOf(fVar2.bSP.bPE));
        }
        int[] iArr = new int[arrayList.size()];
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            iArr[i8] = ((Integer) arrayList.get(i8)).intValue();
        }
        gO.bZo = iArr;
        return gO.HF();
    }

    private static bw b(Class<?> cls, l.a aVar) {
        List<l.f> fields = aVar.getFields();
        bw.a gO = bw.gO(fields.size());
        gO.bZs = E(cls);
        gO.a(bl.PROTO3);
        b bVar = new b((byte) 0);
        for (int i2 = 0; i2 < fields.size(); i2++) {
            l.f fVar = fields.get(i2);
            if (fVar.bSU != null) {
                gO.a(a(cls, fVar, bVar, true, null));
            } else if (fVar.FG()) {
                gO.a(w.a(a(cls, fVar), fVar.bSP.bPE, bt.d(cls, fVar.bSP.getName()), (ae.c) null));
            } else if (fVar.FJ() && fVar.bSS.bTz == l.f.a.MESSAGE) {
                gO.a(w.a(a(cls, fVar), fVar.bSP.bPE, a(fVar), d(cls, fVar)));
            } else if (fVar.FK()) {
                gO.a(w.a(a(cls, fVar), fVar.bSP.bPE, a(fVar), b(cls, fVar)));
            } else {
                gO.a(w.a(a(cls, fVar), fVar.bSP.bPE, a(fVar), true));
            }
        }
        return gO.HF();
    }

    private static Class<?> a(Class<?> cls, l.f fVar, y yVar) {
        switch (yVar.bVG) {
            case BOOLEAN:
                return Boolean.class;
            case BYTE_STRING:
                return g.class;
            case DOUBLE:
                return Double.class;
            case FLOAT:
                return Float.class;
            case ENUM:
            case INT:
                return Integer.class;
            case LONG:
                return Long.class;
            case STRING:
                return String.class;
            case MESSAGE:
                return c(cls, fVar);
            default:
                throw new IllegalArgumentException("Invalid type for oneof: ".concat(String.valueOf(yVar)));
        }
    }

    private static y a(l.f fVar) {
        switch (fVar.bSS) {
            case BOOL:
                if (!fVar.FJ()) {
                    return y.BOOL;
                }
                return fVar.FK() ? y.BOOL_LIST_PACKED : y.BOOL_LIST;
            case BYTES:
                return fVar.FJ() ? y.BYTES_LIST : y.BYTES;
            case DOUBLE:
                if (!fVar.FJ()) {
                    return y.DOUBLE;
                }
                return fVar.FK() ? y.DOUBLE_LIST_PACKED : y.DOUBLE_LIST;
            case ENUM:
                if (!fVar.FJ()) {
                    return y.ENUM;
                }
                return fVar.FK() ? y.ENUM_LIST_PACKED : y.ENUM_LIST;
            case FIXED32:
                if (!fVar.FJ()) {
                    return y.FIXED32;
                }
                return fVar.FK() ? y.FIXED32_LIST_PACKED : y.FIXED32_LIST;
            case FIXED64:
                if (!fVar.FJ()) {
                    return y.FIXED64;
                }
                return fVar.FK() ? y.FIXED64_LIST_PACKED : y.FIXED64_LIST;
            case FLOAT:
                if (!fVar.FJ()) {
                    return y.FLOAT;
                }
                return fVar.FK() ? y.FLOAT_LIST_PACKED : y.FLOAT_LIST;
            case GROUP:
                return fVar.FJ() ? y.GROUP_LIST : y.GROUP;
            case INT32:
                if (!fVar.FJ()) {
                    return y.INT32;
                }
                return fVar.FK() ? y.INT32_LIST_PACKED : y.INT32_LIST;
            case INT64:
                if (!fVar.FJ()) {
                    return y.INT64;
                }
                return fVar.FK() ? y.INT64_LIST_PACKED : y.INT64_LIST;
            case MESSAGE:
                if (fVar.FG()) {
                    return y.MAP;
                }
                return fVar.FJ() ? y.MESSAGE_LIST : y.MESSAGE;
            case SFIXED32:
                if (!fVar.FJ()) {
                    return y.SFIXED32;
                }
                return fVar.FK() ? y.SFIXED32_LIST_PACKED : y.SFIXED32_LIST;
            case SFIXED64:
                if (!fVar.FJ()) {
                    return y.SFIXED64;
                }
                return fVar.FK() ? y.SFIXED64_LIST_PACKED : y.SFIXED64_LIST;
            case SINT32:
                if (!fVar.FJ()) {
                    return y.SINT32;
                }
                return fVar.FK() ? y.SINT32_LIST_PACKED : y.SINT32_LIST;
            case SINT64:
                if (!fVar.FJ()) {
                    return y.SINT64;
                }
                return fVar.FK() ? y.SINT64_LIST_PACKED : y.SINT64_LIST;
            case STRING:
                return fVar.FJ() ? y.STRING_LIST : y.STRING;
            case UINT32:
                if (!fVar.FJ()) {
                    return y.UINT32;
                }
                return fVar.FK() ? y.UINT32_LIST_PACKED : y.UINT32_LIST;
            case UINT64:
                if (!fVar.FJ()) {
                    return y.UINT64;
                }
                return fVar.FK() ? y.UINT64_LIST_PACKED : y.UINT64_LIST;
            default:
                throw new IllegalArgumentException("Unsupported field type: " + fVar.bSS);
        }
    }

    private static Field a(Class<?> cls, l.f fVar) {
        return a(cls, b(fVar));
    }

    private static Field b(Class<?> cls, l.f fVar) {
        return a(cls, c(fVar));
    }

    /* access modifiers changed from: private */
    public static Field a(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Exception e2) {
            throw new IllegalArgumentException("Unable to find field " + str + " in message class " + cls.getName());
        }
    }

    private static String c(l.f fVar) {
        return cc(fVar.bSP.getName()) + "MemoizedSerializedSize";
    }

    /* access modifiers changed from: private */
    public static String cc(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 1);
        boolean z = false;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '_') {
                z = true;
            } else if (Character.isDigit(charAt)) {
                sb.append(charAt);
                z = true;
            } else if (z) {
                sb.append(Character.toUpperCase(charAt));
                z = false;
            } else if (i2 == 0) {
                sb.append(Character.toLowerCase(charAt));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    private static String cd(String str) {
        String cc = cc(str);
        return "get" + Character.toUpperCase(cc.charAt(0)) + cc.substring(1, cc.length());
    }

    /* access modifiers changed from: package-private */
    public static final class b {
        private bi[] bNP;

        private b() {
            this.bNP = new bi[2];
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final bi a(Class<?> cls, l.j jVar) {
            int i2 = jVar.index;
            if (i2 >= this.bNP.length) {
                this.bNP = (bi[]) Arrays.copyOf(this.bNP, i2 * 2);
            }
            bi biVar = this.bNP[i2];
            if (biVar != null) {
                return biVar;
            }
            bi b2 = b(cls, jVar);
            this.bNP[i2] = b2;
            return b2;
        }

        private static bi b(Class<?> cls, l.j jVar) {
            String cc = j.cc(jVar.bTP.getName());
            return new bi(jVar.index, j.a(cls, cc + "Case_"), j.a(cls, cc + "_"));
        }
    }

    private static w a(Class<?> cls, l.f fVar, b bVar, boolean z, ae.c cVar) {
        bi a2 = bVar.a(cls, fVar.bSU);
        y a3 = a(fVar);
        return w.a(fVar.bSP.bPE, a3, a2, a(cls, fVar, a3), z, cVar);
    }

    private static String b(l.f fVar) {
        String name = fVar.bSS == l.f.b.GROUP ? fVar.FN().bSq.getName() : fVar.bSP.getName();
        return cc(name) + (bNA.contains(name) ? "__" : "_");
    }

    private static Class<?> c(Class<?> cls, l.f fVar) {
        String name;
        try {
            if (fVar.bSS == l.f.b.GROUP) {
                name = fVar.FN().bSq.getName();
            } else {
                name = fVar.bSP.getName();
            }
            return cls.getDeclaredMethod(cd(name), new Class[0]).getReturnType();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private static Class<?> d(Class<?> cls, l.f fVar) {
        String name;
        try {
            if (fVar.bSS == l.f.b.GROUP) {
                name = fVar.FN().bSq.getName();
            } else {
                name = fVar.bSP.getName();
            }
            return cls.getDeclaredMethod(cd(name), Integer.TYPE).getReturnType();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
