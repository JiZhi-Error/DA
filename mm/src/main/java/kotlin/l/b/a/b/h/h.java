package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.l.b.a.b.h.h.a;
import kotlin.l.b.a.b.h.j;
import kotlin.l.b.a.b.h.q;
import kotlin.l.b.a.b.h.z;

public final class h<FieldDescriptorType extends a<FieldDescriptorType>> {
    private static final h TDz = new h((byte) 0);
    final v<FieldDescriptorType, Object> TDy = v.avE(16);
    private boolean bUC;
    boolean bUD = false;

    public interface a<T extends a<T>> extends Comparable<T> {
        boolean FJ();

        boolean FK();

        q.a a(q.a aVar, q qVar);

        int getNumber();

        z.a hJA();

        z.b hJB();
    }

    public final /* synthetic */ Object clone() {
        AppMethodBeat.i(59469);
        h<FieldDescriptorType> hJz = hJz();
        AppMethodBeat.o(59469);
        return hJz;
    }

    private h() {
        AppMethodBeat.i(59448);
        AppMethodBeat.o(59448);
    }

    private h(byte b2) {
        AppMethodBeat.i(59449);
        yK();
        AppMethodBeat.o(59449);
    }

    public static <T extends a<T>> h<T> hJx() {
        AppMethodBeat.i(59450);
        h<T> hVar = new h<>();
        AppMethodBeat.o(59450);
        return hVar;
    }

    public static <T extends a<T>> h<T> hJy() {
        return TDz;
    }

    static {
        AppMethodBeat.i(59470);
        AppMethodBeat.o(59470);
    }

    public final void yK() {
        AppMethodBeat.i(59451);
        if (this.bUC) {
            AppMethodBeat.o(59451);
            return;
        }
        this.TDy.yK();
        this.bUC = true;
        AppMethodBeat.o(59451);
    }

    public final Object a(FieldDescriptorType fielddescriptortype) {
        AppMethodBeat.i(59453);
        Object obj = this.TDy.get(fielddescriptortype);
        if (obj instanceof l) {
            q hJL = ((l) obj).hJL();
            AppMethodBeat.o(59453);
            return hJL;
        }
        AppMethodBeat.o(59453);
        return obj;
    }

    public final void a(FieldDescriptorType fielddescriptortype, Object obj) {
        AppMethodBeat.i(59454);
        if (!fielddescriptortype.FJ()) {
            a(fielddescriptortype.hJA(), obj);
        } else if (!(obj instanceof List)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            AppMethodBeat.o(59454);
            throw illegalArgumentException;
        } else {
            ArrayList<Object> arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            for (Object obj2 : arrayList) {
                a(fielddescriptortype.hJA(), obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof l) {
            this.bUD = true;
        }
        this.TDy.a(fielddescriptortype, obj);
        AppMethodBeat.o(59454);
    }

    public final void b(FieldDescriptorType fielddescriptortype, Object obj) {
        List list;
        AppMethodBeat.i(59455);
        if (!fielddescriptortype.FJ()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
            AppMethodBeat.o(59455);
            throw illegalArgumentException;
        }
        a(fielddescriptortype.hJA(), obj);
        Object a2 = a(fielddescriptortype);
        if (a2 == null) {
            list = new ArrayList();
            this.TDy.a(fielddescriptortype, list);
        } else {
            list = (List) a2;
        }
        list.add(obj);
        AppMethodBeat.o(59455);
    }

    private static void a(z.a aVar, Object obj) {
        boolean z = false;
        AppMethodBeat.i(59456);
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(59456);
            throw nullPointerException;
        }
        switch (aVar.TEG) {
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
                if ((obj instanceof d) || (obj instanceof byte[])) {
                    z = true;
                    break;
                }
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof j.a)) {
                    z = true;
                    break;
                }
            case MESSAGE:
                if ((obj instanceof q) || (obj instanceof l)) {
                    z = true;
                    break;
                }
        }
        if (!z) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            AppMethodBeat.o(59456);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(59456);
    }

    public final boolean isInitialized() {
        AppMethodBeat.i(59457);
        for (int i2 = 0; i2 < this.TDy.Hx(); i2++) {
            if (!a(this.TDy.gM(i2))) {
                AppMethodBeat.o(59457);
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.TDy.Hy()) {
            if (!a(entry)) {
                AppMethodBeat.o(59457);
                return false;
            }
        }
        AppMethodBeat.o(59457);
        return true;
    }

    private static boolean a(Map.Entry<FieldDescriptorType, Object> entry) {
        AppMethodBeat.i(59458);
        FieldDescriptorType key = entry.getKey();
        if (key.hJB() == z.b.MESSAGE) {
            if (key.FJ()) {
                for (q qVar : (List) entry.getValue()) {
                    if (!qVar.isInitialized()) {
                        AppMethodBeat.o(59458);
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof q) {
                    if (!((q) value).isInitialized()) {
                        AppMethodBeat.o(59458);
                        return false;
                    }
                } else if (value instanceof l) {
                    AppMethodBeat.o(59458);
                    return true;
                } else {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                    AppMethodBeat.o(59458);
                    throw illegalArgumentException;
                }
            }
        }
        AppMethodBeat.o(59458);
        return true;
    }

    static int a(z.a aVar, boolean z) {
        if (z) {
            return 2;
        }
        return aVar.caV;
    }

    private static Object aq(Object obj) {
        AppMethodBeat.i(59459);
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            AppMethodBeat.o(59459);
            return bArr2;
        }
        AppMethodBeat.o(59459);
        return obj;
    }

    /* access modifiers changed from: package-private */
    public final void b(Map.Entry<FieldDescriptorType, Object> entry) {
        AppMethodBeat.i(59460);
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof l) {
            value = ((l) value).hJL();
        }
        if (key.FJ()) {
            Object a2 = a(key);
            if (a2 == null) {
                a2 = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) a2).add(aq(obj));
            }
            this.TDy.a(key, a2);
            AppMethodBeat.o(59460);
        } else if (key.hJB() == z.b.MESSAGE) {
            Object a3 = a(key);
            if (a3 == null) {
                this.TDy.a(key, aq(value));
                AppMethodBeat.o(59460);
                return;
            }
            this.TDy.a(key, key.a(((q) a3).hEw(), (q) value).hEG());
            AppMethodBeat.o(59460);
        } else {
            this.TDy.a(key, aq(value));
            AppMethodBeat.o(59460);
        }
    }

    public static Object a(e eVar, z.a aVar) {
        AppMethodBeat.i(59461);
        switch (aVar) {
            case DOUBLE:
                Double valueOf = Double.valueOf(Double.longBitsToDouble(eVar.zn()));
                AppMethodBeat.o(59461);
                return valueOf;
            case FLOAT:
                Float valueOf2 = Float.valueOf(Float.intBitsToFloat(eVar.zm()));
                AppMethodBeat.o(59461);
                return valueOf2;
            case INT64:
                Long valueOf3 = Long.valueOf(eVar.zl());
                AppMethodBeat.o(59461);
                return valueOf3;
            case UINT64:
                Long valueOf4 = Long.valueOf(eVar.zl());
                AppMethodBeat.o(59461);
                return valueOf4;
            case INT32:
                Integer valueOf5 = Integer.valueOf(eVar.zi());
                AppMethodBeat.o(59461);
                return valueOf5;
            case FIXED64:
                Long valueOf6 = Long.valueOf(eVar.zn());
                AppMethodBeat.o(59461);
                return valueOf6;
            case FIXED32:
                Integer valueOf7 = Integer.valueOf(eVar.zm());
                AppMethodBeat.o(59461);
                return valueOf7;
            case BOOL:
                Boolean valueOf8 = Boolean.valueOf(eVar.yZ());
                AppMethodBeat.o(59461);
                return valueOf8;
            case STRING:
                int zi = eVar.zi();
                if (zi <= eVar.bufferSize - eVar.cbm && zi > 0) {
                    String str = new String(eVar.buffer, eVar.cbm, zi, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    eVar.cbm = zi + eVar.cbm;
                    AppMethodBeat.o(59461);
                    return str;
                } else if (zi == 0) {
                    AppMethodBeat.o(59461);
                    return "";
                } else {
                    String str2 = new String(eVar.avz(zi), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    AppMethodBeat.o(59461);
                    return str2;
                }
            case BYTES:
                d hJt = eVar.hJt();
                AppMethodBeat.o(59461);
                return hJt;
            case UINT32:
                Integer valueOf9 = Integer.valueOf(eVar.zi());
                AppMethodBeat.o(59461);
                return valueOf9;
            case SFIXED32:
                Integer valueOf10 = Integer.valueOf(eVar.zm());
                AppMethodBeat.o(59461);
                return valueOf10;
            case SFIXED64:
                Long valueOf11 = Long.valueOf(eVar.zn());
                AppMethodBeat.o(59461);
                return valueOf11;
            case SINT32:
                int zi2 = eVar.zi();
                Integer valueOf12 = Integer.valueOf((-(zi2 & 1)) ^ (zi2 >>> 1));
                AppMethodBeat.o(59461);
                return valueOf12;
            case SINT64:
                Long valueOf13 = Long.valueOf(e.Ph(eVar.zl()));
                AppMethodBeat.o(59461);
                return valueOf13;
            case GROUP:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
                AppMethodBeat.o(59461);
                throw illegalArgumentException;
            case MESSAGE:
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
                AppMethodBeat.o(59461);
                throw illegalArgumentException2;
            case ENUM:
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
                AppMethodBeat.o(59461);
                throw illegalArgumentException3;
            default:
                RuntimeException runtimeException = new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                AppMethodBeat.o(59461);
                throw runtimeException;
        }
    }

    private static void a(f fVar, z.a aVar, int i2, Object obj) {
        AppMethodBeat.i(59462);
        if (aVar == z.a.GROUP) {
            fVar.br(i2, 3);
            ((q) obj).a(fVar);
            fVar.br(i2, 4);
            AppMethodBeat.o(59462);
            return;
        }
        fVar.br(i2, a(aVar, false));
        a(fVar, aVar, obj);
        AppMethodBeat.o(59462);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static void a(f fVar, z.a aVar, Object obj) {
        AppMethodBeat.i(59463);
        switch (aVar) {
            case DOUBLE:
                fVar.f(((Double) obj).doubleValue());
                AppMethodBeat.o(59463);
                return;
            case FLOAT:
                fVar.ad(((Float) obj).floatValue());
                AppMethodBeat.o(59463);
                return;
            case INT64:
                fVar.aJ(((Long) obj).longValue());
                AppMethodBeat.o(59463);
                return;
            case UINT64:
                fVar.aJ(((Long) obj).longValue());
                AppMethodBeat.o(59463);
                return;
            case INT32:
                fVar.fK(((Integer) obj).intValue());
                AppMethodBeat.o(59463);
                return;
            case FIXED64:
                fVar.Pj(((Long) obj).longValue());
                AppMethodBeat.o(59463);
                return;
            case FIXED32:
                fVar.avB(((Integer) obj).intValue());
                AppMethodBeat.o(59463);
                return;
            case BOOL:
                fVar.be(((Boolean) obj).booleanValue());
                AppMethodBeat.o(59463);
                return;
            case STRING:
                fVar.ca((String) obj);
                AppMethodBeat.o(59463);
                return;
            case BYTES:
                if (obj instanceof d) {
                    fVar.b((d) obj);
                    AppMethodBeat.o(59463);
                    return;
                }
                fVar.dj((byte[]) obj);
                AppMethodBeat.o(59463);
                return;
            case UINT32:
                fVar.hc(((Integer) obj).intValue());
                AppMethodBeat.o(59463);
                return;
            case SFIXED32:
                fVar.avB(((Integer) obj).intValue());
                AppMethodBeat.o(59463);
                return;
            case SFIXED64:
                fVar.Pj(((Long) obj).longValue());
                AppMethodBeat.o(59463);
                return;
            case SINT32:
                fVar.fM(((Integer) obj).intValue());
                AppMethodBeat.o(59463);
                return;
            case SINT64:
                fVar.aw(((Long) obj).longValue());
                AppMethodBeat.o(59463);
                return;
            case GROUP:
                ((q) obj).a(fVar);
                AppMethodBeat.o(59463);
                return;
            case MESSAGE:
                fVar.b((q) obj);
                AppMethodBeat.o(59463);
                return;
            case ENUM:
                if (!(obj instanceof j.a)) {
                    fVar.fK(((Integer) obj).intValue());
                    break;
                } else {
                    fVar.fK(((j.a) obj).getNumber());
                    AppMethodBeat.o(59463);
                    return;
                }
        }
        AppMethodBeat.o(59463);
    }

    public static void a(a<?> aVar, Object obj, f fVar) {
        AppMethodBeat.i(59464);
        z.a hJA = aVar.hJA();
        int number = aVar.getNumber();
        if (aVar.FJ()) {
            List<Object> list = (List) obj;
            if (aVar.FK()) {
                fVar.br(number, 2);
                int i2 = 0;
                for (Object obj2 : list) {
                    i2 += b(hJA, obj2);
                }
                fVar.hc(i2);
                for (Object obj3 : list) {
                    a(fVar, hJA, obj3);
                }
                AppMethodBeat.o(59464);
                return;
            }
            for (Object obj4 : list) {
                a(fVar, hJA, number, obj4);
            }
            AppMethodBeat.o(59464);
        } else if (obj instanceof l) {
            a(fVar, hJA, number, ((l) obj).hJL());
            AppMethodBeat.o(59464);
        } else {
            a(fVar, hJA, number, obj);
            AppMethodBeat.o(59464);
        }
    }

    public final int yC() {
        AppMethodBeat.i(59465);
        int i2 = 0;
        for (int i3 = 0; i3 < this.TDy.Hx(); i3++) {
            Map.Entry<FieldDescriptorType, Object> gM = this.TDy.gM(i3);
            i2 += c(gM.getKey(), gM.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.TDy.Hy()) {
            i2 += c(entry.getKey(), entry.getValue());
        }
        AppMethodBeat.o(59465);
        return i2;
    }

    private static int a(z.a aVar, int i2, Object obj) {
        AppMethodBeat.i(59466);
        int fS = f.fS(i2);
        if (aVar == z.a.GROUP) {
            fS *= 2;
        }
        int b2 = fS + b(aVar, obj);
        AppMethodBeat.o(59466);
        return b2;
    }

    private static int b(z.a aVar, Object obj) {
        AppMethodBeat.i(59467);
        switch (aVar) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                AppMethodBeat.o(59467);
                return 8;
            case FLOAT:
                ((Float) obj).floatValue();
                AppMethodBeat.o(59467);
                return 4;
            case INT64:
                int aK = f.aK(((Long) obj).longValue());
                AppMethodBeat.o(59467);
                return aK;
            case UINT64:
                int aK2 = f.aK(((Long) obj).longValue());
                AppMethodBeat.o(59467);
                return aK2;
            case INT32:
                int fT = f.fT(((Integer) obj).intValue());
                AppMethodBeat.o(59467);
                return fT;
            case FIXED64:
                ((Long) obj).longValue();
                AppMethodBeat.o(59467);
                return 8;
            case FIXED32:
                ((Integer) obj).intValue();
                AppMethodBeat.o(59467);
                return 4;
            case BOOL:
                ((Boolean) obj).booleanValue();
                AppMethodBeat.o(59467);
                return 1;
            case STRING:
                int cb = f.cb((String) obj);
                AppMethodBeat.o(59467);
                return cb;
            case BYTES:
                if (obj instanceof d) {
                    int d2 = f.d((d) obj);
                    AppMethodBeat.o(59467);
                    return d2;
                }
                int D = f.D((byte[]) obj);
                AppMethodBeat.o(59467);
                return D;
            case UINT32:
                int fY = f.fY(((Integer) obj).intValue());
                AppMethodBeat.o(59467);
                return fY;
            case SFIXED32:
                ((Integer) obj).intValue();
                AppMethodBeat.o(59467);
                return 4;
            case SFIXED64:
                ((Long) obj).longValue();
                AppMethodBeat.o(59467);
                return 8;
            case SINT32:
                int fY2 = f.fY(f.fX(((Integer) obj).intValue()));
                AppMethodBeat.o(59467);
                return fY2;
            case SINT64:
                int aK3 = f.aK(f.aC(((Long) obj).longValue()));
                AppMethodBeat.o(59467);
                return aK3;
            case GROUP:
                int yC = ((q) obj).yC();
                AppMethodBeat.o(59467);
                return yC;
            case MESSAGE:
                if (obj instanceof l) {
                    int a2 = f.a((l) obj);
                    AppMethodBeat.o(59467);
                    return a2;
                }
                int c2 = f.c((q) obj);
                AppMethodBeat.o(59467);
                return c2;
            case ENUM:
                if (obj instanceof j.a) {
                    int fT2 = f.fT(((j.a) obj).getNumber());
                    AppMethodBeat.o(59467);
                    return fT2;
                }
                int fT3 = f.fT(((Integer) obj).intValue());
                AppMethodBeat.o(59467);
                return fT3;
            default:
                RuntimeException runtimeException = new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                AppMethodBeat.o(59467);
                throw runtimeException;
        }
    }

    private static int c(a<?> aVar, Object obj) {
        int i2 = 0;
        AppMethodBeat.i(59468);
        z.a hJA = aVar.hJA();
        int number = aVar.getNumber();
        if (!aVar.FJ()) {
            int a2 = a(hJA, number, obj);
            AppMethodBeat.o(59468);
            return a2;
        } else if (aVar.FK()) {
            for (Object obj2 : (List) obj) {
                i2 += b(hJA, obj2);
            }
            int fY = f.fY(i2) + f.fS(number) + i2;
            AppMethodBeat.o(59468);
            return fY;
        } else {
            for (Object obj3 : (List) obj) {
                i2 += a(hJA, number, obj3);
            }
            AppMethodBeat.o(59468);
            return i2;
        }
    }

    public final h<FieldDescriptorType> hJz() {
        AppMethodBeat.i(59452);
        h<FieldDescriptorType> hVar = new h<>();
        for (int i2 = 0; i2 < this.TDy.Hx(); i2++) {
            Map.Entry<FieldDescriptorType, Object> gM = this.TDy.gM(i2);
            hVar.a(gM.getKey(), gM.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.TDy.Hy()) {
            hVar.a(entry.getKey(), entry.getValue());
        }
        hVar.bUD = this.bUD;
        AppMethodBeat.o(59452);
        return hVar;
    }
}
