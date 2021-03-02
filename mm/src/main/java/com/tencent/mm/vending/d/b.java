package com.tencent.mm.vending.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b<T> {
    private volatile List<T> QZM;

    /* synthetic */ b(List list, byte b2) {
        this(list);
    }

    private b(List list) {
        this.QZM = list;
    }

    public static final class a<T> {
        private ArrayList<T> QZN = new ArrayList<>();

        public a() {
            AppMethodBeat.i(74868);
            AppMethodBeat.o(74868);
        }

        private void awI() {
            AppMethodBeat.i(177475);
            if (this.QZN == null) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                AppMethodBeat.o(177475);
                throw illegalAccessError;
            }
            AppMethodBeat.o(177475);
        }

        public final a<T> F(T... tArr) {
            AppMethodBeat.i(74870);
            awI();
            for (int i2 = 0; i2 <= 0; i2++) {
                this.QZN.add(tArr[0]);
            }
            AppMethodBeat.o(74870);
            return this;
        }

        public final b<T> hdv() {
            AppMethodBeat.i(74871);
            awI();
            ArrayList<T> arrayList = this.QZN;
            this.QZN = null;
            b<T> bVar = new b<>(arrayList, (byte) 0);
            AppMethodBeat.o(74871);
            return bVar;
        }
    }

    public final int size() {
        AppMethodBeat.i(74866);
        int size = this.QZM.size();
        AppMethodBeat.o(74866);
        return size;
    }

    public final T get(int i2) {
        AppMethodBeat.i(74867);
        T t = this.QZM.get(i2);
        AppMethodBeat.o(74867);
        return t;
    }
}
