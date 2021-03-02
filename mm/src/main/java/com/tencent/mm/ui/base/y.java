package com.tencent.mm.ui.base;

import android.util.SparseArray;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class y {
    int BCE;
    View[] OWp = new View[0];
    int[] OWq = new int[0];
    SparseArray<View>[] OWr;
    SparseArray<View> OWs;

    public y() {
        AppMethodBeat.i(142451);
        AppMethodBeat.o(142451);
    }

    static View d(SparseArray<View> sparseArray, int i2) {
        AppMethodBeat.i(142452);
        int size = sparseArray.size();
        if (size > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                int keyAt = sparseArray.keyAt(i3);
                View view = sparseArray.get(keyAt);
                if (keyAt == i2) {
                    sparseArray.remove(keyAt);
                    AppMethodBeat.o(142452);
                    return view;
                }
            }
            int i4 = size - 1;
            View valueAt = sparseArray.valueAt(i4);
            sparseArray.remove(sparseArray.keyAt(i4));
            AppMethodBeat.o(142452);
            return valueAt;
        }
        AppMethodBeat.o(142452);
        return null;
    }
}
