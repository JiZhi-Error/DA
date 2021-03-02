package android.arch.b;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
public final class j<T> extends AbstractList<T> {
    private static final List eZ = new ArrayList();
    private int eT;
    int fe;
    final ArrayList<List<T>> ff;
    int fg;
    private int fh;
    int fi;
    int fj;
    int fk;

    j() {
        this.fe = 0;
        this.ff = new ArrayList<>();
        this.fg = 0;
        this.fh = 0;
        this.fi = 0;
        this.eT = 1;
        this.fj = 0;
        this.fk = 0;
    }

    j(j<T> jVar) {
        this.fe = jVar.fe;
        this.ff = new ArrayList<>(jVar.ff);
        this.fg = jVar.fg;
        this.fh = jVar.fh;
        this.fi = jVar.fi;
        this.eT = jVar.eT;
        this.fj = jVar.fj;
        this.fk = jVar.fk;
    }

    @Override // java.util.List, java.util.AbstractList
    public final T get(int i2) {
        boolean z;
        int i3;
        int i4 = 0;
        if (i2 < 0 || i2 >= size()) {
            throw new IndexOutOfBoundsException("Index: " + i2 + ", Size: " + size());
        }
        int i5 = i2 - this.fe;
        if (i5 < 0 || i5 >= this.fi) {
            return null;
        }
        if (this.eT > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i3 = i5 / this.eT;
            i5 %= this.eT;
        } else {
            int size = this.ff.size();
            while (i4 < size) {
                int size2 = this.ff.get(i4).size();
                if (size2 > i5) {
                    break;
                }
                i5 -= size2;
                i4++;
            }
            i3 = i4;
        }
        List<T> list = this.ff.get(i3);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(i5);
    }

    public final int size() {
        return this.fe + this.fi + this.fg;
    }

    /* access modifiers changed from: package-private */
    public final int az() {
        int i2 = this.fe;
        int size = this.ff.size();
        for (int i3 = 0; i3 < size; i3++) {
            List<T> list = this.ff.get(i3);
            if (!(list == null || list == eZ)) {
                break;
            }
            i2 += this.eT;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final int aA() {
        int i2 = this.fg;
        for (int size = this.ff.size() - 1; size >= 0; size--) {
            List<T> list = this.ff.get(size);
            if (!(list == null || list == eZ)) {
                break;
            }
            i2 += this.eT;
        }
        return i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("leading " + this.fe + ", storage " + this.fi + ", trailing " + this.fg);
        for (int i2 = 0; i2 < this.ff.size(); i2++) {
            sb.append(" ").append(this.ff.get(i2));
        }
        return sb.toString();
    }
}
