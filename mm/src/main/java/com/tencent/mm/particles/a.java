package com.tencent.mm.particles;

import android.content.res.Resources;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class a {
    private static int jIh;
    private static int jIi;
    private static int jIj;
    private static int jIk;
    private static int jIl;
    private static int jIm;
    public c hRg;

    public a(ViewGroup viewGroup) {
        AppMethodBeat.i(151345);
        if (jIh == 0) {
            Resources resources = viewGroup.getResources();
            jIh = resources.getDimensionPixelSize(R.dimen.yl);
            jIi = resources.getDimensionPixelOffset(R.dimen.yq);
            jIj = resources.getDimensionPixelOffset(R.dimen.yp);
            jIk = resources.getDimensionPixelOffset(R.dimen.yo);
            jIl = resources.getDimensionPixelOffset(R.dimen.yr);
            jIm = resources.getDimensionPixelOffset(R.dimen.ym);
        }
        AppMethodBeat.o(151345);
    }

    public static a a(ViewGroup viewGroup, b bVar) {
        AppMethodBeat.i(151346);
        a aVar = new a(viewGroup);
        c az = new c(viewGroup.getContext(), bVar, new d(viewGroup.getWidth() / 2, viewGroup.getHeight() + 400), viewGroup).G(0.0f, 800.0f).H(-2000.0f, 1250.0f).az(2000.0f);
        az.jIV = 3000.0f;
        az.jIW = 500.0f;
        c bkG = az.bkG();
        bkG.jIy = e.bkO();
        aVar.hRg = bkG.bkH().bkI();
        AppMethodBeat.o(151346);
        return aVar;
    }

    public final c G(int i2, long j2) {
        AppMethodBeat.i(151347);
        c cVar = this.hRg;
        cVar.jIu = 0;
        cVar.jIv = j2;
        c bkJ = cVar.ax((float) i2).bkJ();
        AppMethodBeat.o(151347);
        return bkJ;
    }
}
