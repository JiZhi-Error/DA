package com.tencent.thumbplayer.a.b;

import com.tencent.thumbplayer.a.b.a.a;
import com.tencent.thumbplayer.a.b.b.c;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;

public abstract class b implements a {
    protected a RYr;

    public b(a aVar) {
        this.RYr = aVar;
    }

    @Override // com.tencent.thumbplayer.a.b.a
    public int a(com.tencent.thumbplayer.a.b bVar) {
        switch (this.RYr.RYv) {
            case 0:
                return !b(bVar) ? 1 : 2;
            case 1:
                return !b(bVar) ? 0 : 2;
            case 2:
                return !b(bVar) ? 1 : 2;
            case 3:
                return c(bVar) ? 1 : 0;
            case 4:
                if (c(bVar)) {
                    return 1;
                }
                return !TPNativeLibraryLoader.isLibLoaded() ? 0 : 2;
            default:
                return 0;
        }
    }

    @Override // com.tencent.thumbplayer.a.b.a
    public int[] hnd() {
        switch (this.RYr.RYu) {
            case 0:
                return new int[]{102, 101};
            case 1:
                return new int[]{102};
            case 2:
                return new int[]{102, 101};
            case 3:
                return new int[]{101};
            case 4:
                return new int[]{101, 102};
            default:
                return null;
        }
    }

    private static boolean c(com.tencent.thumbplayer.a.b bVar) {
        return c.e(bVar);
    }

    @Override // com.tencent.thumbplayer.a.b.a
    public int a(com.tencent.thumbplayer.a.b bVar, com.tencent.thumbplayer.a.b.a.b bVar2) {
        if (bVar2.RYx == 0) {
            return a(bVar);
        }
        return 0;
    }

    static boolean b(com.tencent.thumbplayer.a.b bVar) {
        return TPNativeLibraryLoader.isLibLoaded() && c.d(bVar);
    }
}
