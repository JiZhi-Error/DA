package com.tencent.thumbplayer.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.b;
import com.tencent.thumbplayer.a.b.a.a;
import com.tencent.thumbplayer.utils.g;

public final class d extends b {
    private int RYs = 0;
    private int[] RYt;

    public d(a aVar) {
        super(aVar);
        AppMethodBeat.i(188990);
        this.RYt = aVar.RYt;
        if (this.RYt == null || this.RYt.length == 0) {
            this.RYt = new int[1];
        }
        AppMethodBeat.o(188990);
    }

    @Override // com.tencent.thumbplayer.a.b.a, com.tencent.thumbplayer.a.b.b
    public final int a(b bVar) {
        AppMethodBeat.i(188991);
        int i2 = this.RYt.length > this.RYs ? this.RYt[this.RYs] : 0;
        if ((i2 == 2 || i2 == 3) && !b(bVar)) {
            i2 = 0;
        }
        g.i("TPThumbPlayer[TPExtStrategy.java]", "strategyForOpen, playerType:".concat(String.valueOf(i2)));
        AppMethodBeat.o(188991);
        return i2;
    }

    @Override // com.tencent.thumbplayer.a.b.a, com.tencent.thumbplayer.a.b.b
    public final int[] hnd() {
        AppMethodBeat.i(188993);
        int[] iArr = {-1};
        if (this.RYs >= this.RYt.length) {
            g.i("TPThumbPlayer[TPExtStrategy.java]", "strategyForDec error, decType:" + iArr[0]);
            AppMethodBeat.o(188993);
        } else {
            if (this.RYt[this.RYs] == 1 || this.RYt[this.RYs] == 2) {
                iArr[0] = 102;
            } else if (this.RYt[this.RYs] == 3) {
                iArr[0] = 101;
            }
            g.i("TPThumbPlayer[TPExtStrategy.java]", "strategyForDec, decType:" + iArr[0]);
            AppMethodBeat.o(188993);
        }
        return iArr;
    }

    @Override // com.tencent.thumbplayer.a.b.a, com.tencent.thumbplayer.a.b.b
    public final int a(b bVar, com.tencent.thumbplayer.a.b.a.b bVar2) {
        int i2;
        AppMethodBeat.i(188992);
        if (bVar2.RYx == 0) {
            int a2 = a(bVar);
            AppMethodBeat.o(188992);
            return a2;
        }
        if (this.RYt.length - 1 > this.RYs) {
            int[] iArr = this.RYt;
            int i3 = this.RYs + 1;
            this.RYs = i3;
            i2 = iArr[i3];
        } else {
            i2 = 0;
        }
        if ((i2 == 2 || i2 == 3) && !b(bVar)) {
            i2 = 0;
        }
        g.i("TPThumbPlayer[TPExtStrategy.java]", "strategyForRetry, playerType:".concat(String.valueOf(i2)));
        AppMethodBeat.o(188992);
        return i2;
    }
}
