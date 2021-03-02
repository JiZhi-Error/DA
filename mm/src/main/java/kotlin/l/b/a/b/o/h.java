package kotlin.l.b.a.b.o;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public final class h<E> extends AbstractList<E> implements RandomAccess {
    private int TRZ;
    private Object TSa;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(61390);
        switch (i2) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 4:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                i3 = 2;
                break;
            case 4:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = "a";
                break;
            default:
                objArr[0] = MessengerShareContentUtility.ELEMENTS;
                break;
        }
        switch (i2) {
            case 2:
            case 3:
                objArr[1] = "iterator";
                break;
            case 4:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 5:
            case 6:
            case 7:
                objArr[1] = "toArray";
                break;
        }
        switch (i2) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                illegalStateException = new IllegalStateException(format);
                break;
            case 4:
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(61390);
        throw illegalStateException;
    }

    @Override // java.util.List, java.util.AbstractList
    public final E get(int i2) {
        AppMethodBeat.i(61383);
        if (i2 < 0 || i2 >= this.TRZ) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("Index: " + i2 + ", Size: " + this.TRZ);
            AppMethodBeat.o(61383);
            throw indexOutOfBoundsException;
        } else if (this.TRZ == 1) {
            E e2 = (E) this.TSa;
            AppMethodBeat.o(61383);
            return e2;
        } else {
            E e3 = (E) ((Object[]) this.TSa)[i2];
            AppMethodBeat.o(61383);
            return e3;
        }
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public final boolean add(E e2) {
        AppMethodBeat.i(61384);
        if (this.TRZ == 0) {
            this.TSa = e2;
        } else if (this.TRZ == 1) {
            this.TSa = new Object[]{this.TSa, e2};
        } else {
            Object[] objArr = (Object[]) this.TSa;
            int length = objArr.length;
            if (this.TRZ >= length) {
                int i2 = ((length * 3) / 2) + 1;
                int i3 = this.TRZ + 1;
                if (i2 >= i3) {
                    i3 = i2;
                }
                Object[] objArr2 = new Object[i3];
                this.TSa = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.TRZ] = e2;
        }
        this.TRZ++;
        this.modCount++;
        AppMethodBeat.o(61384);
        return true;
    }

    @Override // java.util.List, java.util.AbstractList
    public final void add(int i2, E e2) {
        AppMethodBeat.i(61385);
        if (i2 < 0 || i2 > this.TRZ) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("Index: " + i2 + ", Size: " + this.TRZ);
            AppMethodBeat.o(61385);
            throw indexOutOfBoundsException;
        }
        if (this.TRZ == 0) {
            this.TSa = e2;
        } else if (this.TRZ == 1 && i2 == 0) {
            this.TSa = new Object[]{e2, this.TSa};
        } else {
            Object[] objArr = new Object[(this.TRZ + 1)];
            if (this.TRZ == 1) {
                objArr[0] = this.TSa;
            } else {
                Object[] objArr2 = (Object[]) this.TSa;
                System.arraycopy(objArr2, 0, objArr, 0, i2);
                System.arraycopy(objArr2, i2, objArr, i2 + 1, this.TRZ - i2);
            }
            objArr[i2] = e2;
            this.TSa = objArr;
        }
        this.TRZ++;
        this.modCount++;
        AppMethodBeat.o(61385);
    }

    public final int size() {
        return this.TRZ;
    }

    public final void clear() {
        this.TSa = null;
        this.TRZ = 0;
        this.modCount++;
    }

    @Override // java.util.List, java.util.AbstractList
    public final E set(int i2, E e2) {
        E e3;
        AppMethodBeat.i(61386);
        if (i2 < 0 || i2 >= this.TRZ) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("Index: " + i2 + ", Size: " + this.TRZ);
            AppMethodBeat.o(61386);
            throw indexOutOfBoundsException;
        }
        if (this.TRZ == 1) {
            e3 = (E) this.TSa;
            this.TSa = e2;
        } else {
            Object[] objArr = (Object[]) this.TSa;
            Object obj = objArr[i2];
            objArr[i2] = e2;
            e3 = (E) obj;
        }
        AppMethodBeat.o(61386);
        return e3;
    }

    @Override // java.util.List, java.util.AbstractList
    public final E remove(int i2) {
        E e2;
        AppMethodBeat.i(61387);
        if (i2 < 0 || i2 >= this.TRZ) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("Index: " + i2 + ", Size: " + this.TRZ);
            AppMethodBeat.o(61387);
            throw indexOutOfBoundsException;
        }
        if (this.TRZ == 1) {
            e2 = (E) this.TSa;
            this.TSa = null;
        } else {
            Object[] objArr = (Object[]) this.TSa;
            Object obj = objArr[i2];
            if (this.TRZ == 2) {
                this.TSa = objArr[1 - i2];
                e2 = (E) obj;
            } else {
                int i3 = (this.TRZ - i2) - 1;
                if (i3 > 0) {
                    System.arraycopy(objArr, i2 + 1, objArr, i2, i3);
                }
                objArr[this.TRZ - 1] = null;
                e2 = (E) obj;
            }
        }
        this.TRZ--;
        this.modCount++;
        AppMethodBeat.o(61387);
        return e2;
    }

    static class a<T> implements Iterator<T> {
        private static final a TSb = new a();

        private a() {
        }

        static {
            AppMethodBeat.i(61378);
            AppMethodBeat.o(61378);
        }

        public static <T> a<T> hLW() {
            return TSb;
        }

        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public final T next() {
            AppMethodBeat.i(61376);
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            AppMethodBeat.o(61376);
            throw noSuchElementException;
        }

        public final void remove() {
            AppMethodBeat.i(61377);
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.o(61377);
            throw illegalStateException;
        }
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public final Iterator<E> iterator() {
        AppMethodBeat.i(61388);
        if (this.TRZ == 0) {
            a hLW = a.hLW();
            if (hLW == null) {
                atM(2);
            }
            AppMethodBeat.o(61388);
            return hLW;
        } else if (this.TRZ == 1) {
            b bVar = new b();
            AppMethodBeat.o(61388);
            return bVar;
        } else {
            Iterator<E> it = super.iterator();
            if (it == null) {
                atM(3);
            }
            AppMethodBeat.o(61388);
            return it;
        }
    }

    static abstract class c<T> implements Iterator<T> {
        private boolean TSe;

        /* access modifiers changed from: protected */
        public abstract T hLX();

        /* access modifiers changed from: protected */
        public abstract void hLY();

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        public final boolean hasNext() {
            return !this.TSe;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (this.TSe) {
                throw new NoSuchElementException();
            }
            this.TSe = true;
            hLY();
            return hLX();
        }
    }

    class b extends c<E> {
        private final int TSc;

        public b() {
            super((byte) 0);
            AppMethodBeat.i(61379);
            this.TSc = h.this.modCount;
            AppMethodBeat.o(61379);
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.l.b.a.b.o.h.c
        public final E hLX() {
            AppMethodBeat.i(61380);
            E e2 = (E) h.this.TSa;
            AppMethodBeat.o(61380);
            return e2;
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.l.b.a.b.o.h.c
        public final void hLY() {
            AppMethodBeat.i(61381);
            if (h.this.modCount != this.TSc) {
                ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException("ModCount: " + h.this.modCount + "; expected: " + this.TSc);
                AppMethodBeat.o(61381);
                throw concurrentModificationException;
            }
            AppMethodBeat.o(61381);
        }

        public final void remove() {
            AppMethodBeat.i(61382);
            hLY();
            h.this.clear();
            AppMethodBeat.o(61382);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: T[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        AppMethodBeat.i(61389);
        if (tArr == 0) {
            atM(4);
        }
        int length = tArr.length;
        if (this.TRZ == 1) {
            if (length != 0) {
                tArr[0] = this.TSa;
            } else {
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
                tArr2[0] = this.TSa;
                if (tArr2 == 0) {
                    atM(5);
                }
                AppMethodBeat.o(61389);
                return tArr2;
            }
        } else if (length < this.TRZ) {
            T[] tArr3 = (T[]) Arrays.copyOf((Object[]) this.TSa, this.TRZ, tArr.getClass());
            if (tArr3 == null) {
                atM(6);
            }
            AppMethodBeat.o(61389);
            return tArr3;
        } else if (this.TRZ != 0) {
            System.arraycopy(this.TSa, 0, tArr, 0, this.TRZ);
        }
        if (length > this.TRZ) {
            tArr[this.TRZ] = 0;
        }
        if (tArr == 0) {
            atM(7);
        }
        AppMethodBeat.o(61389);
        return tArr;
    }
}
