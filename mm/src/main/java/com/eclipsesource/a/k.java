package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;
import java.util.Arrays;

public final class k extends l {
    private final char[] bah;

    private k(char[] cArr) {
        this.bah = cArr;
    }

    public static k dD(int i2) {
        AppMethodBeat.i(74792);
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("number is negative");
            AppMethodBeat.o(74792);
            throw illegalArgumentException;
        }
        char[] cArr = new char[i2];
        Arrays.fill(cArr, ' ');
        k kVar = new k(cArr);
        AppMethodBeat.o(74792);
        return kVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.eclipsesource.a.l
    public final i a(Writer writer) {
        AppMethodBeat.i(74793);
        a aVar = new a(writer, this.bah, (byte) 0);
        AppMethodBeat.o(74793);
        return aVar;
    }

    static class a extends i {
        private final char[] bah;
        private int bai;

        /* synthetic */ a(Writer writer, char[] cArr, byte b2) {
            this(writer, cArr);
        }

        private a(Writer writer, char[] cArr) {
            super(writer);
            this.bah = cArr;
        }

        /* access modifiers changed from: protected */
        @Override // com.eclipsesource.a.i
        public final void sH() {
            AppMethodBeat.i(74784);
            this.bai++;
            this.bag.write(91);
            sO();
            AppMethodBeat.o(74784);
        }

        /* access modifiers changed from: protected */
        @Override // com.eclipsesource.a.i
        public final void sI() {
            AppMethodBeat.i(74785);
            this.bai--;
            sO();
            this.bag.write(93);
            AppMethodBeat.o(74785);
        }

        /* access modifiers changed from: protected */
        @Override // com.eclipsesource.a.i
        public final void sJ() {
            AppMethodBeat.i(74786);
            this.bag.write(44);
            if (!sO()) {
                this.bag.write(32);
            }
            AppMethodBeat.o(74786);
        }

        /* access modifiers changed from: protected */
        @Override // com.eclipsesource.a.i
        public final void sK() {
            AppMethodBeat.i(74787);
            this.bai++;
            this.bag.write(123);
            sO();
            AppMethodBeat.o(74787);
        }

        /* access modifiers changed from: protected */
        @Override // com.eclipsesource.a.i
        public final void sL() {
            AppMethodBeat.i(74788);
            this.bai--;
            sO();
            this.bag.write(125);
            AppMethodBeat.o(74788);
        }

        /* access modifiers changed from: protected */
        @Override // com.eclipsesource.a.i
        public final void sM() {
            AppMethodBeat.i(74789);
            this.bag.write(58);
            this.bag.write(32);
            AppMethodBeat.o(74789);
        }

        /* access modifiers changed from: protected */
        @Override // com.eclipsesource.a.i
        public final void sN() {
            AppMethodBeat.i(74790);
            this.bag.write(44);
            if (!sO()) {
                this.bag.write(32);
            }
            AppMethodBeat.o(74790);
        }

        private boolean sO() {
            AppMethodBeat.i(74791);
            if (this.bah == null) {
                AppMethodBeat.o(74791);
                return false;
            }
            this.bag.write(10);
            for (int i2 = 0; i2 < this.bai; i2++) {
                this.bag.write(this.bah);
            }
            AppMethodBeat.o(74791);
            return true;
        }
    }
}
