package kotlin.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.t;

public final class d {
    private static final int TJA = (a.hKX() - 1);
    private static final int TJB = ((TJu | TJv) | TJw);
    private static final int TJC = ((TJv | TJy) | TJz);
    private static final int TJD = (TJy | TJz);
    public static final d TJE = new d(TJA);
    public static final d TJF = new d(TJD);
    public static final d TJG = new d(TJu);
    public static final d TJH = new d(TJv);
    public static final d TJI = new d(TJw);
    public static final d TJJ = new d(TJB);
    public static final d TJK = new d(TJx);
    public static final d TJL = new d(TJy);
    public static final d TJM = new d(TJz);
    public static final d TJN = new d(TJC);
    private static final List<a.C2347a> TJO;
    private static final List<a.C2347a> TJP;
    public static final a TJQ = new a((byte) 0);
    private static int TJt = 1;
    private static final int TJu = a.hKX();
    private static final int TJv = a.hKX();
    private static final int TJw = a.hKX();
    private static final int TJx = a.hKX();
    private static final int TJy = a.hKX();
    private static final int TJz = a.hKX();
    final int TJr;
    public final List<c> TJs;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends kotlin.l.b.a.b.j.f.c> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(int i2, List<? extends c> list) {
        p.h(list, "excludes");
        AppMethodBeat.i(60199);
        this.TJs = list;
        Iterator<T> it = this.TJs.iterator();
        while (it.hasNext()) {
            i2 &= it.next().hKN() ^ -1;
        }
        this.TJr = i2;
        AppMethodBeat.o(60199);
    }

    public final boolean avF(int i2) {
        return (this.TJr & i2) != 0;
    }

    public final String toString() {
        T t;
        boolean z;
        AppMethodBeat.i(60198);
        Iterator<T> it = TJO.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (next.mask == this.TJr) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                t = next;
                break;
            }
        }
        T t2 = t;
        String str = t2 != null ? t2.name : null;
        if (str == null) {
            ArrayList arrayList = new ArrayList();
            for (T t3 : TJP) {
                String str2 = avF(t3.mask) ? t3.name : null;
                if (str2 != null) {
                    arrayList.add(str2);
                }
            }
            str = j.a(arrayList, APLogFileUtil.SEPARATOR_LOG, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (b) null, 62);
        }
        String str3 = "DescriptorKindFilter(" + str + ", " + this.TJs + ')';
        AppMethodBeat.o(60198);
        return str3;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        static int hKX() {
            AppMethodBeat.i(60197);
            int i2 = d.TJt;
            d.TJt <<= 1;
            AppMethodBeat.o(60197);
            return i2;
        }

        /* renamed from: kotlin.l.b.a.b.j.f.d$a$a */
        static final class C2347a {
            final int mask;
            final String name;

            public C2347a(int i2, String str) {
                p.h(str, "name");
                AppMethodBeat.i(60196);
                this.mask = i2;
                this.name = str;
                AppMethodBeat.o(60196);
            }
        }
    }

    static {
        a.C2347a aVar;
        a.C2347a aVar2;
        AppMethodBeat.i(60201);
        Field[] fields = d.class.getFields();
        p.g(fields, "T::class.java.fields");
        ArrayList<Field> arrayList = new ArrayList();
        for (Field field : fields) {
            p.g(field, LocaleUtil.ITALIAN);
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Field field2 : arrayList) {
            Object obj = field2.get(null);
            if (!(obj instanceof d)) {
                obj = null;
            }
            d dVar = (d) obj;
            if (dVar != null) {
                int i2 = dVar.TJr;
                p.g(field2, "field");
                String name = field2.getName();
                p.g(name, "field.name");
                aVar2 = new a.C2347a(i2, name);
            } else {
                aVar2 = null;
            }
            if (aVar2 != null) {
                arrayList2.add(aVar2);
            }
        }
        TJO = j.p(arrayList2);
        Field[] fields2 = d.class.getFields();
        p.g(fields2, "T::class.java.fields");
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            p.g(field3, LocaleUtil.ITALIAN);
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            Field field4 = (Field) obj2;
            p.g(field4, LocaleUtil.ITALIAN);
            if (p.j(field4.getType(), Integer.TYPE)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field5 : arrayList4) {
            Object obj3 = field5.get(null);
            if (obj3 == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(60201);
                throw tVar;
            }
            int intValue = ((Integer) obj3).intValue();
            if (intValue == ((-intValue) & intValue)) {
                p.g(field5, "field");
                String name2 = field5.getName();
                p.g(name2, "field.name");
                aVar = new a.C2347a(intValue, name2);
            } else {
                aVar = null;
            }
            if (aVar != null) {
                arrayList5.add(aVar);
            }
        }
        TJP = j.p(arrayList5);
        AppMethodBeat.o(60201);
    }

    private /* synthetic */ d(int i2) {
        this(i2, v.SXr);
        AppMethodBeat.i(60200);
        AppMethodBeat.o(60200);
    }
}
