package com.tencent.mm.xeffect;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public boolean HmG;
    public boolean RxG;
    public boolean RxH;
    public final Rect RxI;
    public final Rect RxJ;
    public int dYT;
    public int height;
    public int ijt;
    public float scale;
    public int textureId;
    public int translateX;
    public int translateY;
    public int width;

    public b(int i2, int i3, int i4) {
        this(i2, i3, i4, false, 0);
    }

    public b(int i2, int i3, int i4, boolean z, int i5) {
        AppMethodBeat.i(236751);
        this.HmG = false;
        this.dYT = 0;
        this.RxG = false;
        this.RxH = true;
        this.RxI = new Rect();
        this.RxJ = new Rect();
        this.ijt = 0;
        this.scale = 1.0f;
        this.translateX = 0;
        this.translateY = 0;
        this.textureId = i2;
        this.width = i3;
        this.height = i4;
        this.HmG = z;
        this.dYT = i5;
        this.RxI.right = i3;
        this.RxI.bottom = i4;
        AppMethodBeat.o(236751);
    }
}
