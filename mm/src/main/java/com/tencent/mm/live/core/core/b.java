package com.tencent.mm.live.core.core;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.b.f;
import com.tencent.mm.live.core.core.b.g;
import com.tencent.mm.live.core.mini.AbsLiveMiniView;
import com.tencent.mm.live.core.view.LivePreviewView;

public interface b {
    void A(float f2, float f3);

    int a(Context context, boolean z, boolean z2, int i2, int i3);

    int a(f fVar);

    int a(LivePreviewView livePreviewView, com.tencent.mm.live.core.b.a aVar, com.tencent.mm.live.core.b.b bVar);

    void a(c cVar);

    void a(AbsLiveMiniView absLiveMiniView);

    int aBS();

    void aBT();

    void aBU();

    g aBV();

    void aBW();

    int aBX();

    int aBY();

    void b(c cVar);

    void c(c cVar);

    void switchCamera();

    public static final class a {
        public static /* synthetic */ int a(b bVar, Context context, boolean z, boolean z2, int i2, int i3, int i4) {
            boolean z3 = true;
            AppMethodBeat.i(196388);
            boolean z4 = (i4 & 2) != 0 ? true : z;
            if ((i4 & 4) == 0) {
                z3 = z2;
            }
            int a2 = bVar.a(context, z4, z3, (i4 & 8) != 0 ? 2 : i2, (i4 & 16) != 0 ? 12 : i3);
            AppMethodBeat.o(196388);
            return a2;
        }
    }
}
