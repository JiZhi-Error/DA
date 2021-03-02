package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.j.c;
import kotlin.m.d;
import kotlin.m.h;
import kotlin.n.n;

public class i extends h {

    public static final class a implements h<T> {
        final /* synthetic */ Object[] SXl;

        public a(Object[] objArr) {
            this.SXl = objArr;
        }

        @Override // kotlin.m.h
        public final Iterator<T> iterator() {
            AppMethodBeat.i(129151);
            Iterator<T> af = kotlin.g.b.b.af(this.SXl);
            AppMethodBeat.o(129151);
            return af;
        }
    }

    public static final <T> boolean contains(T[] tArr, T t) {
        AppMethodBeat.i(129075);
        p.h(tArr, "$this$contains");
        if (e.indexOf(tArr, t) >= 0) {
            AppMethodBeat.o(129075);
            return true;
        }
        AppMethodBeat.o(129075);
        return false;
    }

    public static final boolean contains(int[] iArr, int i2) {
        AppMethodBeat.i(129076);
        p.h(iArr, "$this$contains");
        if (e.n(iArr, i2) >= 0) {
            AppMethodBeat.o(129076);
            return true;
        }
        AppMethodBeat.o(129076);
        return false;
    }

    public static final boolean contains(char[] cArr, char c2) {
        AppMethodBeat.i(129077);
        p.h(cArr, "$this$contains");
        if (e.b(cArr, c2) >= 0) {
            AppMethodBeat.o(129077);
            return true;
        }
        AppMethodBeat.o(129077);
        return false;
    }

    public static final <T> T Q(T[] tArr) {
        boolean z;
        AppMethodBeat.i(129078);
        p.h(tArr, "$this$first");
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            NoSuchElementException noSuchElementException = new NoSuchElementException("Array is empty.");
            AppMethodBeat.o(129078);
            throw noSuchElementException;
        }
        T t = tArr[0];
        AppMethodBeat.o(129078);
        return t;
    }

    public static final <T> T R(T[] tArr) {
        AppMethodBeat.i(129079);
        p.h(tArr, "$this$firstOrNull");
        if (tArr.length == 0) {
            AppMethodBeat.o(129079);
            return null;
        }
        T t = tArr[0];
        AppMethodBeat.o(129079);
        return t;
    }

    public static final <T> T f(T[] tArr, int i2) {
        AppMethodBeat.i(129080);
        p.h(tArr, "$this$getOrNull");
        if (i2 < 0 || i2 > e.V(tArr)) {
            AppMethodBeat.o(129080);
            return null;
        }
        T t = tArr[i2];
        AppMethodBeat.o(129080);
        return t;
    }

    public static final Integer m(int[] iArr, int i2) {
        AppMethodBeat.i(129081);
        p.h(iArr, "$this$getOrNull");
        if (i2 < 0 || i2 > e.X(iArr)) {
            AppMethodBeat.o(129081);
            return null;
        }
        Integer valueOf = Integer.valueOf(iArr[i2]);
        AppMethodBeat.o(129081);
        return valueOf;
    }

    public static final <T> int indexOf(T[] tArr, T t) {
        int i2 = 0;
        AppMethodBeat.i(129082);
        p.h(tArr, "$this$indexOf");
        if (t == null) {
            int length = tArr.length;
            while (i2 < length) {
                if (tArr[i2] == null) {
                    AppMethodBeat.o(129082);
                    return i2;
                }
                i2++;
            }
        } else {
            int length2 = tArr.length;
            while (i2 < length2) {
                if (p.j(t, tArr[i2])) {
                    AppMethodBeat.o(129082);
                    return i2;
                }
                i2++;
            }
        }
        AppMethodBeat.o(129082);
        return -1;
    }

    public static final int n(int[] iArr, int i2) {
        AppMethodBeat.i(129083);
        p.h(iArr, "$this$indexOf");
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i2 == iArr[i3]) {
                AppMethodBeat.o(129083);
                return i3;
            }
        }
        AppMethodBeat.o(129083);
        return -1;
    }

    public static final int b(char[] cArr, char c2) {
        AppMethodBeat.i(206277);
        p.h(cArr, "$this$indexOf");
        int length = cArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (c2 == cArr[i2]) {
                AppMethodBeat.o(206277);
                return i2;
            }
        }
        AppMethodBeat.o(206277);
        return -1;
    }

    public static final <T> T S(T[] tArr) {
        AppMethodBeat.i(129084);
        p.h(tArr, "$this$last");
        if (tArr.length == 0) {
            NoSuchElementException noSuchElementException = new NoSuchElementException("Array is empty.");
            AppMethodBeat.o(129084);
            throw noSuchElementException;
        }
        T t = tArr[e.V(tArr)];
        AppMethodBeat.o(129084);
        return t;
    }

    public static final <T> T a(T[] tArr, c cVar) {
        AppMethodBeat.i(206278);
        p.h(tArr, "$this$random");
        p.h(cVar, "random");
        if (tArr.length == 0) {
            NoSuchElementException noSuchElementException = new NoSuchElementException("Array is empty.");
            AppMethodBeat.o(206278);
            throw noSuchElementException;
        }
        T t = tArr[cVar.nextInt(tArr.length)];
        AppMethodBeat.o(206278);
        return t;
    }

    public static final <T> T T(T[] tArr) {
        AppMethodBeat.i(129085);
        p.h(tArr, "$this$single");
        switch (tArr.length) {
            case 0:
                NoSuchElementException noSuchElementException = new NoSuchElementException("Array is empty.");
                AppMethodBeat.o(129085);
                throw noSuchElementException;
            case 1:
                T t = tArr[0];
                AppMethodBeat.o(129085);
                return t;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Array has more than one element.");
                AppMethodBeat.o(129085);
                throw illegalArgumentException;
        }
    }

    public static final char c(char[] cArr) {
        AppMethodBeat.i(129086);
        p.h(cArr, "$this$single");
        switch (cArr.length) {
            case 0:
                NoSuchElementException noSuchElementException = new NoSuchElementException("Array is empty.");
                AppMethodBeat.o(129086);
                throw noSuchElementException;
            case 1:
                char c2 = cArr[0];
                AppMethodBeat.o(129086);
                return c2;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Array has more than one element.");
                AppMethodBeat.o(129086);
                throw illegalArgumentException;
        }
    }

    public static final <C extends Collection<? super T>, T> C a(T[] tArr, C c2) {
        AppMethodBeat.i(129087);
        p.h(tArr, "$this$filterNotNullTo");
        p.h(c2, "destination");
        for (T t : tArr) {
            if (t != null) {
                c2.add(t);
            }
        }
        AppMethodBeat.o(129087);
        return c2;
    }

    public static final <T> List<T> U(T[] tArr) {
        AppMethodBeat.i(129088);
        p.h(tArr, "$this$take");
        if (20 >= tArr.length) {
            List<T> W = e.W(tArr);
            AppMethodBeat.o(129088);
            return W;
        }
        ArrayList arrayList = new ArrayList(20);
        int length = tArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            arrayList.add(tArr[i2]);
            int i4 = i3 + 1;
            if (i4 == 20) {
                break;
            }
            i2++;
            i3 = i4;
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(129088);
        return arrayList2;
    }

    public static final <T> void am(T[] tArr) {
        AppMethodBeat.i(259500);
        p.h(tArr, "$this$reverse");
        int length = (tArr.length / 2) - 1;
        if (length < 0) {
            AppMethodBeat.o(259500);
            return;
        }
        int V = e.V(tArr);
        int i2 = 0;
        if (length >= 0) {
            while (true) {
                T t = tArr[i2];
                tArr[i2] = tArr[V];
                tArr[V] = t;
                V--;
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        AppMethodBeat.o(259500);
    }

    public static final <T> List<T> b(T[] tArr, Comparator<? super T> comparator) {
        boolean z;
        AppMethodBeat.i(206279);
        p.h(tArr, "$this$sortedWith");
        p.h(comparator, "comparator");
        p.h(tArr, "$this$sortedArrayWith");
        p.h(comparator, "comparator");
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            tArr = (T[]) Arrays.copyOf(tArr, tArr.length);
            p.g(tArr, "java.util.Arrays.copyOf(this, size)");
            e.a(tArr, comparator);
        }
        List<T> asList = e.asList(tArr);
        AppMethodBeat.o(206279);
        return asList;
    }

    public static final <T> int V(T[] tArr) {
        AppMethodBeat.i(129089);
        p.h(tArr, "$this$lastIndex");
        int length = tArr.length - 1;
        AppMethodBeat.o(129089);
        return length;
    }

    public static final int X(int[] iArr) {
        AppMethodBeat.i(129090);
        p.h(iArr, "$this$lastIndex");
        int length = iArr.length - 1;
        AppMethodBeat.o(129090);
        return length;
    }

    public static final float[] b(Float[] fArr) {
        AppMethodBeat.i(129091);
        p.h(fArr, "$this$toFloatArray");
        int length = fArr.length;
        float[] fArr2 = new float[length];
        for (int i2 = 0; i2 < length; i2++) {
            fArr2[i2] = fArr[i2].floatValue();
        }
        AppMethodBeat.o(129091);
        return fArr2;
    }

    public static final <T, C extends Collection<? super T>> C b(T[] tArr, C c2) {
        AppMethodBeat.i(129092);
        p.h(tArr, "$this$toCollection");
        p.h(c2, "destination");
        for (T t : tArr) {
            c2.add(t);
        }
        AppMethodBeat.o(129092);
        return c2;
    }

    public static final <T> List<T> W(T[] tArr) {
        AppMethodBeat.i(129093);
        p.h(tArr, "$this$toList");
        switch (tArr.length) {
            case 0:
                v vVar = v.SXr;
                AppMethodBeat.o(129093);
                return vVar;
            case 1:
                List<T> listOf = j.listOf(tArr[0]);
                AppMethodBeat.o(129093);
                return listOf;
            default:
                List<T> X = e.X(tArr);
                AppMethodBeat.o(129093);
                return X;
        }
    }

    public static final List<Byte> df(byte[] bArr) {
        AppMethodBeat.i(129094);
        p.h(bArr, "$this$toList");
        switch (bArr.length) {
            case 0:
                v vVar = v.SXr;
                AppMethodBeat.o(129094);
                return vVar;
            case 1:
                List<Byte> listOf = j.listOf(Byte.valueOf(bArr[0]));
                AppMethodBeat.o(129094);
                return listOf;
            default:
                p.h(bArr, "$this$toMutableList");
                ArrayList arrayList = new ArrayList(bArr.length);
                for (byte b2 : bArr) {
                    arrayList.add(Byte.valueOf(b2));
                }
                ArrayList arrayList2 = arrayList;
                AppMethodBeat.o(129094);
                return arrayList2;
        }
    }

    public static final List<Short> b(short[] sArr) {
        AppMethodBeat.i(129095);
        p.h(sArr, "$this$toList");
        switch (sArr.length) {
            case 0:
                v vVar = v.SXr;
                AppMethodBeat.o(129095);
                return vVar;
            case 1:
                List<Short> listOf = j.listOf(Short.valueOf(sArr[0]));
                AppMethodBeat.o(129095);
                return listOf;
            default:
                p.h(sArr, "$this$toMutableList");
                ArrayList arrayList = new ArrayList(sArr.length);
                for (short s : sArr) {
                    arrayList.add(Short.valueOf(s));
                }
                ArrayList arrayList2 = arrayList;
                AppMethodBeat.o(129095);
                return arrayList2;
        }
    }

    public static final List<Integer> Y(int[] iArr) {
        AppMethodBeat.i(129096);
        p.h(iArr, "$this$toList");
        switch (iArr.length) {
            case 0:
                v vVar = v.SXr;
                AppMethodBeat.o(129096);
                return vVar;
            case 1:
                List<Integer> listOf = j.listOf(Integer.valueOf(iArr[0]));
                AppMethodBeat.o(129096);
                return listOf;
            default:
                List<Integer> Z = e.Z(iArr);
                AppMethodBeat.o(129096);
                return Z;
        }
    }

    public static final List<Long> h(long[] jArr) {
        AppMethodBeat.i(129097);
        p.h(jArr, "$this$toList");
        switch (jArr.length) {
            case 0:
                v vVar = v.SXr;
                AppMethodBeat.o(129097);
                return vVar;
            case 1:
                List<Long> listOf = j.listOf(Long.valueOf(jArr[0]));
                AppMethodBeat.o(129097);
                return listOf;
            default:
                List<Long> i2 = e.i(jArr);
                AppMethodBeat.o(129097);
                return i2;
        }
    }

    public static final List<Float> s(float[] fArr) {
        AppMethodBeat.i(129098);
        p.h(fArr, "$this$toList");
        switch (fArr.length) {
            case 0:
                v vVar = v.SXr;
                AppMethodBeat.o(129098);
                return vVar;
            case 1:
                List<Float> listOf = j.listOf(Float.valueOf(fArr[0]));
                AppMethodBeat.o(129098);
                return listOf;
            default:
                List<Float> t = e.t(fArr);
                AppMethodBeat.o(129098);
                return t;
        }
    }

    public static final List<Double> d(double[] dArr) {
        AppMethodBeat.i(129099);
        p.h(dArr, "$this$toList");
        switch (dArr.length) {
            case 0:
                v vVar = v.SXr;
                AppMethodBeat.o(129099);
                return vVar;
            case 1:
                List<Double> listOf = j.listOf(Double.valueOf(dArr[0]));
                AppMethodBeat.o(129099);
                return listOf;
            default:
                p.h(dArr, "$this$toMutableList");
                ArrayList arrayList = new ArrayList(dArr.length);
                for (double d2 : dArr) {
                    arrayList.add(Double.valueOf(d2));
                }
                ArrayList arrayList2 = arrayList;
                AppMethodBeat.o(129099);
                return arrayList2;
        }
    }

    public static final List<Boolean> d(boolean[] zArr) {
        AppMethodBeat.i(129100);
        p.h(zArr, "$this$toList");
        switch (zArr.length) {
            case 0:
                v vVar = v.SXr;
                AppMethodBeat.o(129100);
                return vVar;
            case 1:
                List<Boolean> listOf = j.listOf(Boolean.valueOf(zArr[0]));
                AppMethodBeat.o(129100);
                return listOf;
            default:
                p.h(zArr, "$this$toMutableList");
                ArrayList arrayList = new ArrayList(zArr.length);
                for (boolean z : zArr) {
                    arrayList.add(Boolean.valueOf(z));
                }
                ArrayList arrayList2 = arrayList;
                AppMethodBeat.o(129100);
                return arrayList2;
        }
    }

    public static final List<Character> d(char[] cArr) {
        AppMethodBeat.i(129101);
        p.h(cArr, "$this$toList");
        switch (cArr.length) {
            case 0:
                v vVar = v.SXr;
                AppMethodBeat.o(129101);
                return vVar;
            case 1:
                List<Character> listOf = j.listOf(Character.valueOf(cArr[0]));
                AppMethodBeat.o(129101);
                return listOf;
            default:
                p.h(cArr, "$this$toMutableList");
                ArrayList arrayList = new ArrayList(cArr.length);
                for (char c2 : cArr) {
                    arrayList.add(Character.valueOf(c2));
                }
                ArrayList arrayList2 = arrayList;
                AppMethodBeat.o(129101);
                return arrayList2;
        }
    }

    public static final <T> List<T> X(T[] tArr) {
        AppMethodBeat.i(129102);
        p.h(tArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(j.ab(tArr));
        AppMethodBeat.o(129102);
        return arrayList;
    }

    public static final List<Integer> Z(int[] iArr) {
        AppMethodBeat.i(129103);
        p.h(iArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i2 : iArr) {
            arrayList.add(Integer.valueOf(i2));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(129103);
        return arrayList2;
    }

    public static final List<Long> i(long[] jArr) {
        AppMethodBeat.i(206280);
        p.h(jArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j2 : jArr) {
            arrayList.add(Long.valueOf(j2));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(206280);
        return arrayList2;
    }

    public static final List<Float> t(float[] fArr) {
        AppMethodBeat.i(168692);
        p.h(fArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f2 : fArr) {
            arrayList.add(Float.valueOf(f2));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(168692);
        return arrayList2;
    }

    public static final <T> Set<T> Y(T[] tArr) {
        AppMethodBeat.i(129104);
        p.h(tArr, "$this$toSet");
        switch (tArr.length) {
            case 0:
                x xVar = x.SXt;
                AppMethodBeat.o(129104);
                return xVar;
            case 1:
                Set<T> of = ak.setOf(tArr[0]);
                AppMethodBeat.o(129104);
                return of;
            default:
                Set<T> set = (Set) e.b(tArr, new LinkedHashSet(ae.atJ(tArr.length)));
                AppMethodBeat.o(129104);
                return set;
        }
    }

    public static final <T, R> List<R> a(T[] tArr, kotlin.g.a.b<? super T, ? extends R> bVar) {
        AppMethodBeat.i(129105);
        p.h(tArr, "$this$map");
        p.h(bVar, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T t : tArr) {
            arrayList.add(bVar.invoke(t));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(129105);
        return arrayList2;
    }

    public static final <T> Iterable<y<T>> Z(T[] tArr) {
        AppMethodBeat.i(129106);
        p.h(tArr, "$this$withIndex");
        z zVar = new z(new b(tArr));
        AppMethodBeat.o(129106);
        return zVar;
    }

    static final class b extends q implements kotlin.g.a.a<Iterator<? extends T>> {
        final /* synthetic */ Object[] SXm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Object[] objArr) {
            super(0);
            this.SXm = objArr;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(129236);
            Iterator af = kotlin.g.b.b.af(this.SXm);
            AppMethodBeat.o(129236);
            return af;
        }
    }

    public static final Integer aa(int[] iArr) {
        AppMethodBeat.i(206281);
        p.h(iArr, "$this$max");
        int i2 = iArr[0];
        int i3 = 1;
        int X = e.X(iArr);
        if (X > 0) {
            while (true) {
                int i4 = iArr[i3];
                if (i2 < i4) {
                    i2 = i4;
                }
                if (i3 == X) {
                    break;
                }
                i3++;
            }
        }
        Integer valueOf = Integer.valueOf(i2);
        AppMethodBeat.o(206281);
        return valueOf;
    }

    public static final <T, A extends Appendable> A a(T[] tArr, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, kotlin.g.a.b<? super T, ? extends CharSequence> bVar) {
        AppMethodBeat.i(129107);
        p.h(tArr, "$this$joinTo");
        p.h(a2, "buffer");
        p.h(charSequence, "separator");
        p.h(charSequence2, "prefix");
        p.h(charSequence3, "postfix");
        p.h(charSequence4, "truncated");
        a2.append(charSequence2);
        int i3 = 0;
        for (T t : tArr) {
            i3++;
            if (i3 > 1) {
                a2.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            n.a(a2, t, bVar);
        }
        if (i2 >= 0 && i3 > i2) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        AppMethodBeat.o(129107);
        return a2;
    }

    public static final <A extends Appendable> A a(byte[] bArr, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, kotlin.g.a.b<? super Byte, ? extends CharSequence> bVar) {
        AppMethodBeat.i(206282);
        p.h(bArr, "$this$joinTo");
        p.h(a2, "buffer");
        p.h(charSequence, "separator");
        p.h(charSequence2, "prefix");
        p.h(charSequence3, "postfix");
        p.h(charSequence4, "truncated");
        a2.append(charSequence2);
        int i3 = 0;
        for (byte b2 : bArr) {
            i3++;
            if (i3 > 1) {
                a2.append(charSequence);
            }
            if (bVar != null) {
                a2.append((CharSequence) bVar.invoke(Byte.valueOf(b2)));
            } else {
                a2.append(String.valueOf((int) b2));
            }
        }
        a2.append(charSequence3);
        AppMethodBeat.o(206282);
        return a2;
    }

    public static /* synthetic */ String a(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, kotlin.g.a.b bVar, int i3) {
        AppMethodBeat.i(129110);
        String a2 = e.a(objArr, (i3 & 1) != 0 ? ", " : charSequence, (i3 & 2) != 0 ? "" : charSequence2, (i3 & 4) != 0 ? "" : charSequence3, (i3 & 8) != 0 ? -1 : i2, (i3 & 16) != 0 ? "..." : charSequence4, (i3 & 32) != 0 ? null : bVar);
        AppMethodBeat.o(129110);
        return a2;
    }

    public static final <T> String a(T[] tArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, kotlin.g.a.b<? super T, ? extends CharSequence> bVar) {
        AppMethodBeat.i(129109);
        p.h(tArr, "$this$joinToString");
        p.h(charSequence, "separator");
        p.h(charSequence2, "prefix");
        p.h(charSequence3, "postfix");
        p.h(charSequence4, "truncated");
        String sb = ((StringBuilder) e.a(tArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, bVar)).toString();
        p.g(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        AppMethodBeat.o(129109);
        return sb;
    }

    public static /* synthetic */ String a(byte[] bArr, CharSequence charSequence, kotlin.g.a.b bVar) {
        AppMethodBeat.i(129112);
        String a2 = e.a(bArr, charSequence, "", "", "...", bVar);
        AppMethodBeat.o(129112);
        return a2;
    }

    public static final String a(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, kotlin.g.a.b<? super Byte, ? extends CharSequence> bVar) {
        AppMethodBeat.i(129111);
        p.h(bArr, "$this$joinToString");
        p.h(charSequence, "separator");
        p.h(charSequence2, "prefix");
        p.h(charSequence3, "postfix");
        p.h(charSequence4, "truncated");
        String sb = ((StringBuilder) e.a(bArr, new StringBuilder(), charSequence, charSequence2, charSequence3, -1, charSequence4, bVar)).toString();
        p.g(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        AppMethodBeat.o(129111);
        return sb;
    }

    public static final <T> h<T> aa(T[] tArr) {
        boolean z;
        AppMethodBeat.i(129113);
        p.h(tArr, "$this$asSequence");
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            d dVar = d.TSv;
            AppMethodBeat.o(129113);
            return dVar;
        }
        a aVar = new a(tArr);
        AppMethodBeat.o(129113);
        return aVar;
    }
}
