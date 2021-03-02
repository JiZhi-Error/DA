package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.b;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.e;
import com.tencent.mm.bx.a.a;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class d extends j implements e.a {
    a Kbi;
    int Kbj;

    public d(String str) {
        this(str, (byte) 0);
    }

    private d(String str, byte b2) {
        super(new a(a.b.gov()), str, (byte) 0);
        AppMethodBeat.i(152121);
        this.Kbi = (a) this.Boe;
        AppMethodBeat.o(152121);
    }

    /* access modifiers changed from: package-private */
    public static class a implements j.a {
        private j.a Boe;
        b Kbk = null;
        Bitmap pqA = null;

        public a(j.a aVar) {
            this.Boe = aVar;
        }

        @Override // com.tencent.mm.pluginsdk.ui.j.a
        public final Bitmap a(String str, int i2, int i3, int i4) {
            AppMethodBeat.i(152116);
            Bitmap bes = bes(str);
            if (bes == null || bes.isRecycled()) {
                if (this.Boe != null) {
                    bes = this.Boe.a(str, i2, i3, i4);
                }
                Bitmap aJ = aJ(bes);
                v(str, aJ);
                AppMethodBeat.o(152116);
                return aJ;
            }
            AppMethodBeat.o(152116);
            return bes;
        }

        @Override // com.tencent.mm.pluginsdk.ui.j.a
        public final Bitmap fZ(String str) {
            AppMethodBeat.i(152117);
            Bitmap bes = bes(str);
            if (bes == null || bes.isRecycled()) {
                if (this.Kbk != null) {
                    bes = c.a(str, false, -1, this.Kbk);
                } else if (this.Boe != null) {
                    bes = this.Boe.fZ(str);
                }
                Bitmap aJ = aJ(bes);
                v(str, aJ);
                AppMethodBeat.o(152117);
                return aJ;
            }
            AppMethodBeat.o(152117);
            return bes;
        }

        @Override // com.tencent.mm.pluginsdk.ui.j.a
        public final Bitmap ga(String str) {
            AppMethodBeat.i(152118);
            Bitmap bes = bes(str);
            if (bes != null && !bes.isRecycled()) {
                AppMethodBeat.o(152118);
                return bes;
            } else if (this.Boe != null) {
                Bitmap ga = this.Boe.ga(str);
                AppMethodBeat.o(152118);
                return ga;
            } else {
                AppMethodBeat.o(152118);
                return null;
            }
        }

        @Override // com.tencent.mm.pluginsdk.ui.j.a
        public final Bitmap Wg() {
            AppMethodBeat.i(152119);
            if (this.pqA != null && !this.pqA.isRecycled()) {
                Bitmap bitmap = this.pqA;
                AppMethodBeat.o(152119);
                return bitmap;
            } else if (this.Boe != null) {
                Bitmap Wg = this.Boe.Wg();
                AppMethodBeat.o(152119);
                return Wg;
            } else {
                AppMethodBeat.o(152119);
                return null;
            }
        }

        @Override // com.tencent.mm.pluginsdk.ui.j.a
        public final void a(j jVar) {
            AppMethodBeat.i(152120);
            if (this.Boe != null) {
                this.Boe.a(jVar);
            }
            AppMethodBeat.o(152120);
        }

        /* access modifiers changed from: package-private */
        public final Bitmap aJ(Bitmap bitmap) {
            AppMethodBeat.i(223841);
            if (bitmap != null && !bitmap.isRecycled() && gox()) {
                bitmap = BitmapUtil.getRoundedCornerBitmap(bitmap, false, this.Kbk.iJZ * ((float) bitmap.getWidth()));
            }
            AppMethodBeat.o(223841);
            return bitmap;
        }

        private Bitmap bes(String str) {
            com.tencent.mm.bx.a.a aVar;
            AppMethodBeat.i(223842);
            if (!gox() || (aVar = a.C0284a.NAL) == null) {
                AppMethodBeat.o(223842);
                return null;
            }
            Bitmap aCX = aVar.aCX(bet(str));
            AppMethodBeat.o(223842);
            return aCX;
        }

        private void v(String str, Bitmap bitmap) {
            com.tencent.mm.bx.a.a aVar;
            AppMethodBeat.i(223843);
            if (!(bitmap == null || !gox() || (aVar = a.C0284a.NAL) == null)) {
                aVar.p(bet(str), bitmap);
            }
            AppMethodBeat.o(223843);
        }

        private boolean gox() {
            return this.Kbk != null && this.Kbk.iJZ > 0.0f;
        }

        private String bet(String str) {
            AppMethodBeat.i(223844);
            String str2 = str + "-" + this.Kbk.iJZ;
            AppMethodBeat.o(223844);
            return str2;
        }
    }
}
