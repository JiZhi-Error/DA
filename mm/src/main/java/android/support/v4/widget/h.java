package android.support.v4.widget;

import android.support.v4.e.l;
import android.support.v4.e.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class h<T> {
    public final l.a<ArrayList<T>> Tw = new l.b(10);
    public final n<T, ArrayList<T>> Tx = new n<>();
    private final ArrayList<T> Ty = new ArrayList<>();
    private final HashSet<T> Tz = new HashSet<>();

    public final void I(T t) {
        if (!this.Tx.containsKey(t)) {
            this.Tx.put(t, null);
        }
    }

    public final List J(T t) {
        return this.Tx.get(t);
    }

    public final List<T> K(T t) {
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        int size = this.Tx.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList<T> valueAt = this.Tx.valueAt(i2);
            if (valueAt != null && valueAt.contains(t)) {
                if (arrayList2 == null) {
                    arrayList = new ArrayList();
                } else {
                    arrayList = arrayList2;
                }
                arrayList.add(this.Tx.keyAt(i2));
                arrayList2 = arrayList;
            }
        }
        return arrayList2;
    }

    public final ArrayList<T> fT() {
        this.Ty.clear();
        this.Tz.clear();
        int size = this.Tx.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(this.Tx.keyAt(i2), this.Ty, this.Tz);
        }
        return this.Ty;
    }

    private void a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (hashSet.contains(t)) {
                throw new RuntimeException("This graph contains cyclic dependencies");
            }
            hashSet.add(t);
            ArrayList<T> arrayList2 = this.Tx.get(t);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    a(arrayList2.get(i2), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
        }
    }
}
