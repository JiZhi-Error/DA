package com.google.a;

import com.google.a.ae;
import com.google.a.ah;
import com.google.a.aw;
import com.google.a.cj;
import com.google.a.x.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class x<FieldDescriptorType extends a<FieldDescriptorType>> {
    private static final x bUE = new x((byte) 0);
    final bv<FieldDescriptorType, Object> bUB = bv.gL(16);
    boolean bUC;
    private boolean bUD = false;

    public interface a<T extends a<T>> extends Comparable<T> {
        cj.b FD();

        cj.a FE();

        boolean FJ();

        boolean FK();

        aw.a a(aw.a aVar, aw awVar);

        int getNumber();
    }

    private x() {
    }

    private x(byte b2) {
        yK();
    }

    public static <T extends a<T>> x<T> Gi() {
        return new x<>();
    }

    public static <T extends a<T>> x<T> Gj() {
        return bUE;
    }

    public final void yK() {
        if (!this.bUC) {
            this.bUB.yK();
            this.bUC = true;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        return this.bUB.equals(((x) obj).bUB);
    }

    public final int hashCode() {
        return this.bUB.hashCode();
    }

    public final Map<FieldDescriptorType, Object> FS() {
        if (!this.bUD) {
            return this.bUB.bUC ? this.bUB : Collections.unmodifiableMap(this.bUB);
        }
        bv gL = bv.gL(16);
        for (int i2 = 0; i2 < this.bUB.Hx(); i2++) {
            a(gL, this.bUB.gM(i2));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.bUB.Hy()) {
            a(gL, entry);
        }
        if (this.bUB.bUC) {
            gL.yK();
        }
        return gL;
    }

    private static void a(Map<FieldDescriptorType, Object> map, Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof ah) {
            map.put(key, ((ah) value).GO());
        } else {
            map.put(key, value);
        }
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        if (this.bUD) {
            return new ah.b(this.bUB.entrySet().iterator());
        }
        return this.bUB.entrySet().iterator();
    }

    public final boolean a(FieldDescriptorType fielddescriptortype) {
        if (!fielddescriptortype.FJ()) {
            return this.bUB.get(fielddescriptortype) != null;
        }
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    public final Object b(FieldDescriptorType fielddescriptortype) {
        Object obj = this.bUB.get(fielddescriptortype);
        if (obj instanceof ah) {
            return ((ah) obj).GO();
        }
        return obj;
    }

    public final void a(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.FJ()) {
            a(fielddescriptortype.FE(), obj);
        } else if (!(obj instanceof List)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        } else {
            ArrayList<Object> arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            for (Object obj2 : arrayList) {
                a(fielddescriptortype.FE(), obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof ah) {
            this.bUD = true;
        }
        this.bUB.put(fielddescriptortype, obj);
    }

    public final void c(FieldDescriptorType fielddescriptortype) {
        this.bUB.remove(fielddescriptortype);
        if (this.bUB.isEmpty()) {
            this.bUD = false;
        }
    }

    public final void b(FieldDescriptorType fielddescriptortype, Object obj) {
        List list;
        if (!fielddescriptortype.FJ()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        a(fielddescriptortype.FE(), obj);
        Object b2 = b(fielddescriptortype);
        if (b2 == null) {
            list = new ArrayList();
            this.bUB.put(fielddescriptortype, list);
        } else {
            list = (List) b2;
        }
        list.add(obj);
    }

    private static void a(cj.a aVar, Object obj) {
        boolean z = false;
        ae.checkNotNull(obj);
        switch (aVar.caU) {
            case INT:
                z = obj instanceof Integer;
                break;
            case LONG:
                z = obj instanceof Long;
                break;
            case FLOAT:
                z = obj instanceof Float;
                break;
            case DOUBLE:
                z = obj instanceof Double;
                break;
            case BOOLEAN:
                z = obj instanceof Boolean;
                break;
            case STRING:
                z = obj instanceof String;
                break;
            case BYTE_STRING:
                if ((obj instanceof g) || (obj instanceof byte[])) {
                    z = true;
                    break;
                }
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof ae.a)) {
                    z = true;
                    break;
                }
            case MESSAGE:
                if ((obj instanceof aw) || (obj instanceof ah)) {
                    z = true;
                    break;
                }
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public final boolean isInitialized() {
        for (int i2 = 0; i2 < this.bUB.Hx(); i2++) {
            if (!a(this.bUB.gM(i2))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.bUB.Hy()) {
            if (!a(entry)) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.FD() == cj.b.MESSAGE) {
            if (key.FJ()) {
                for (aw awVar : (List) entry.getValue()) {
                    if (!awVar.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof aw) {
                    if (!((aw) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof ah) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    static int a(cj.a aVar, boolean z) {
        if (z) {
            return 2;
        }
        return aVar.caV;
    }

    public final void a(x<FieldDescriptorType> xVar) {
        for (int i2 = 0; i2 < xVar.bUB.Hx(); i2++) {
            b(xVar.bUB.gM(i2));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : xVar.bUB.Hy()) {
            b(entry);
        }
    }

    private static Object aq(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private void b(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof ah) {
            value = ((ah) value).GO();
        }
        if (key.FJ()) {
            Object b2 = b(key);
            if (b2 == null) {
                b2 = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) b2).add(aq(obj));
            }
            this.bUB.put(key, b2);
        } else if (key.FD() == cj.b.MESSAGE) {
            Object b3 = b(key);
            if (b3 == null) {
                this.bUB.put(key, aq(value));
                return;
            }
            this.bUB.put(key, key.a(((aw) b3).AN(), (aw) value).Bp());
        } else {
            this.bUB.put(key, aq(value));
        }
    }

    static void a(Map.Entry<FieldDescriptorType, Object> entry, i iVar) {
        aw awVar;
        FieldDescriptorType key = entry.getKey();
        if (key.FD() != cj.b.MESSAGE || key.FJ() || key.FK()) {
            a((a<?>) key, entry.getValue(), iVar);
            return;
        }
        Object value = entry.getValue();
        if (value instanceof ah) {
            awVar = ((ah) value).GO();
        } else {
            awVar = value;
        }
        iVar.b(entry.getKey().getNumber(), (aw) awVar);
    }

    private static void a(i iVar, cj.a aVar, int i2, Object obj) {
        if (aVar == cj.a.GROUP) {
            iVar.e(i2, (aw) obj);
            return;
        }
        iVar.br(i2, a(aVar, false));
        a(iVar, aVar, obj);
    }

    private static void a(i iVar, cj.a aVar, Object obj) {
        switch (aVar) {
            case DOUBLE:
                iVar.f(((Double) obj).doubleValue());
                return;
            case FLOAT:
                iVar.ad(((Float) obj).floatValue());
                return;
            case INT64:
                iVar.av(((Long) obj).longValue());
                return;
            case UINT64:
                iVar.av(((Long) obj).longValue());
                return;
            case INT32:
                iVar.fK(((Integer) obj).intValue());
                return;
            case FIXED64:
                iVar.ax(((Long) obj).longValue());
                return;
            case FIXED32:
                iVar.fN(((Integer) obj).intValue());
                return;
            case BOOL:
                iVar.be(((Boolean) obj).booleanValue());
                return;
            case GROUP:
                ((aw) obj).a(iVar);
                return;
            case MESSAGE:
                iVar.c((aw) obj);
                return;
            case STRING:
                if (obj instanceof g) {
                    iVar.a((g) obj);
                    return;
                } else {
                    iVar.ca((String) obj);
                    return;
                }
            case BYTES:
                if (obj instanceof g) {
                    iVar.a((g) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                iVar.r(bArr, bArr.length);
                return;
            case UINT32:
                iVar.fL(((Integer) obj).intValue());
                return;
            case SFIXED32:
                iVar.fN(((Integer) obj).intValue());
                return;
            case SFIXED64:
                iVar.ax(((Long) obj).longValue());
                return;
            case SINT32:
                iVar.fM(((Integer) obj).intValue());
                return;
            case SINT64:
                iVar.aw(((Long) obj).longValue());
                return;
            case ENUM:
                if (obj instanceof ae.a) {
                    iVar.fK(((ae.a) obj).getNumber());
                    return;
                } else {
                    iVar.fK(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static void a(a<?> aVar, Object obj, i iVar) {
        cj.a FE = aVar.FE();
        int number = aVar.getNumber();
        if (aVar.FJ()) {
            List<Object> list = (List) obj;
            if (aVar.FK()) {
                iVar.br(number, 2);
                int i2 = 0;
                for (Object obj2 : list) {
                    i2 += b(FE, obj2);
                }
                iVar.fL(i2);
                for (Object obj3 : list) {
                    a(iVar, FE, obj3);
                }
                return;
            }
            for (Object obj4 : list) {
                a(iVar, FE, number, obj4);
            }
        } else if (obj instanceof ah) {
            a(iVar, FE, number, ((ah) obj).GO());
        } else {
            a(iVar, FE, number, obj);
        }
    }

    public final int yC() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.bUB.Hx(); i3++) {
            Map.Entry<FieldDescriptorType, Object> gM = this.bUB.gM(i3);
            i2 += c(gM.getKey(), gM.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.bUB.Hy()) {
            i2 += c(entry.getKey(), entry.getValue());
        }
        return i2;
    }

    static int c(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.FD() != cj.b.MESSAGE || key.FJ() || key.FK()) {
            return c(key, value);
        }
        if (value instanceof ah) {
            return i.a(entry.getKey().getNumber(), (ah) value);
        }
        return i.d(entry.getKey().getNumber(), (aw) value);
    }

    private static int a(cj.a aVar, int i2, Object obj) {
        int fS = i.fS(i2);
        if (aVar == cj.a.GROUP) {
            fS *= 2;
        }
        return fS + b(aVar, obj);
    }

    private static int b(cj.a aVar, Object obj) {
        switch (aVar) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                return i.zx();
            case FLOAT:
                ((Float) obj).floatValue();
                return i.zw();
            case INT64:
                return i.az(((Long) obj).longValue());
            case UINT64:
                return i.aA(((Long) obj).longValue());
            case INT32:
                return i.fT(((Integer) obj).intValue());
            case FIXED64:
                ((Long) obj).longValue();
                return i.zu();
            case FIXED32:
                ((Integer) obj).intValue();
                return i.zs();
            case BOOL:
                ((Boolean) obj).booleanValue();
                return i.zy();
            case GROUP:
                return i.e((aw) obj);
            case MESSAGE:
                if (obj instanceof ah) {
                    return i.a((ah) obj);
                }
                return i.d((aw) obj);
            case STRING:
                if (obj instanceof g) {
                    return i.b((g) obj);
                }
                return i.cb((String) obj);
            case BYTES:
                if (obj instanceof g) {
                    return i.b((g) obj);
                }
                return i.D((byte[]) obj);
            case UINT32:
                return i.fU(((Integer) obj).intValue());
            case SFIXED32:
                ((Integer) obj).intValue();
                return i.zt();
            case SFIXED64:
                ((Long) obj).longValue();
                return i.zv();
            case SINT32:
                return i.fV(((Integer) obj).intValue());
            case SINT64:
                return i.aB(((Long) obj).longValue());
            case ENUM:
                if (obj instanceof ae.a) {
                    return i.fW(((ae.a) obj).getNumber());
                }
                return i.fW(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int c(a<?> aVar, Object obj) {
        int i2 = 0;
        cj.a FE = aVar.FE();
        int number = aVar.getNumber();
        if (!aVar.FJ()) {
            return a(FE, number, obj);
        }
        if (aVar.FK()) {
            for (Object obj2 : (List) obj) {
                i2 += b(FE, obj2);
            }
            return i.fY(i2) + i.fS(number) + i2;
        }
        for (Object obj3 : (List) obj) {
            i2 += a(FE, number, obj3);
        }
        return i2;
    }

    /* renamed from: Gk */
    public final x<FieldDescriptorType> clone() {
        x<FieldDescriptorType> xVar = new x<>();
        for (int i2 = 0; i2 < this.bUB.Hx(); i2++) {
            Map.Entry<FieldDescriptorType, Object> gM = this.bUB.gM(i2);
            xVar.a(gM.getKey(), gM.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.bUB.Hy()) {
            xVar.a(entry.getKey(), entry.getValue());
        }
        xVar.bUD = this.bUD;
        return xVar;
    }
}
