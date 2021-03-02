package com.tencent.mm.storagebase.a;

import android.database.sqlite.SQLiteClosable;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.a.a;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class b<T extends a> extends SQLiteClosable {
    SparseArray<Object> OtK = new SparseArray<>();
    int OtL;
    HashMap<Object, T> OtM = new HashMap<>();
    ArrayList<Object> OtN;
    T OtO;
    int mStartPos = 0;

    public abstract ArrayList<T> bo(ArrayList<Object> arrayList);

    public abstract T gFJ();

    /* access modifiers changed from: package-private */
    public final void b(Object obj, T t) {
        this.OtM.put(obj, t);
    }

    public final boolean akB(int i2) {
        return this.OtK.indexOfKey(i2) >= 0;
    }

    public final void kN(int i2, int i3) {
        if (i3 != 0) {
            Log.e("MicroMsg.CursorDataWindow", "newcursor rowEnd with error %d rowNum : %d", Integer.valueOf(i3), Integer.valueOf(i2));
            this.OtK.remove(i2);
        } else if (this.OtO != null) {
            Object key = this.OtO.getKey();
            b(key, this.OtO);
            this.OtK.put(i2, key);
        }
    }

    public final void clearData() {
        Log.i("MicroMsg.CursorDataWindow", "clearData");
        this.OtK.clear();
        this.OtM.clear();
    }

    /* access modifiers changed from: protected */
    public void onAllReferencesReleased() {
        clearData();
    }

    /* access modifiers changed from: package-private */
    public final void E(Object[] objArr) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        int i2 = 0;
        for (int i3 = 0; i3 < this.OtK.size(); i3++) {
            int keyAt = this.OtK.keyAt(i3);
            Object valueAt = this.OtK.valueAt(i3);
            boolean z = true;
            int length = objArr.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                } else if (objArr[i4].equals(valueAt)) {
                    i2++;
                    z = false;
                    break;
                } else {
                    i4++;
                }
            }
            if (z) {
                sparseArray.put(keyAt - i2, valueAt);
            } else {
                Log.i("MicroMsg.CursorDataWindow", "newcursor delete index : " + i3 + " obj : " + valueAt);
            }
        }
        if (this.OtK.size() != sparseArray.size()) {
            Log.i("MicroMsg.CursorDataWindow", "newcursor oldposition size :" + this.OtK.size() + " newposistion Size : " + sparseArray.size());
        }
        this.OtK = sparseArray;
    }

    public final boolean ed(Object obj) {
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 1) {
                return this.OtM != null && this.OtM.containsKey(objArr[0]);
            }
        }
        return this.OtM != null && this.OtM.containsKey(obj);
    }
}
