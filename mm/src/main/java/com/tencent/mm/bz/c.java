package com.tencent.mm.bz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.api.x;
import com.tencent.mm.bt.b;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.cache.d;
import com.tencent.mm.cache.i;
import com.tencent.mm.e.a;
import com.tencent.mm.z.f;
import java.util.Iterator;
import java.util.Stack;

public final class c implements x {
    private boolean dbi = true;
    private b drS;

    public c(b bVar) {
        this.drS = bVar;
    }

    @Override // com.tencent.mm.api.x
    public final int Vx() {
        AppMethodBeat.i(9333);
        d dVar = (d) ArtistCacheManager.alA().a(a.EMOJI_AND_TEXT);
        if (dVar == null) {
            AppMethodBeat.o(9333);
            return 0;
        }
        int i2 = dVar.dm(this.dbi)[1];
        AppMethodBeat.o(9333);
        return i2;
    }

    @Override // com.tencent.mm.api.x
    public final int Vy() {
        AppMethodBeat.i(9334);
        d dVar = (d) ArtistCacheManager.alA().a(a.EMOJI_AND_TEXT);
        if (dVar == null) {
            AppMethodBeat.o(9334);
            return 0;
        }
        int i2 = dVar.dm(this.dbi)[0];
        AppMethodBeat.o(9334);
        return i2;
    }

    @Override // com.tencent.mm.api.x
    public final int Vz() {
        AppMethodBeat.i(9335);
        i iVar = (i) ArtistCacheManager.alA().a(a.MOSAIC);
        if (iVar == null) {
            AppMethodBeat.o(9335);
            return 0;
        }
        int ai = iVar.ai(this.dbi);
        AppMethodBeat.o(9335);
        return ai;
    }

    @Override // com.tencent.mm.api.x
    public final int VA() {
        AppMethodBeat.i(9336);
        com.tencent.mm.cache.b bVar = (com.tencent.mm.cache.b) ArtistCacheManager.alA().a(a.DOODLE);
        if (bVar == null) {
            AppMethodBeat.o(9336);
            return 0;
        }
        int ai = bVar.ai(this.dbi);
        AppMethodBeat.o(9336);
        return ai;
    }

    @Override // com.tencent.mm.api.x
    public final int VB() {
        AppMethodBeat.i(9337);
        int i2 = 0;
        com.tencent.mm.cache.b bVar = (com.tencent.mm.cache.b) ArtistCacheManager.alA().a(a.DOODLE);
        if (bVar != null) {
            i2 = bVar.gpA + 0;
        }
        i iVar = (i) ArtistCacheManager.alA().a(a.MOSAIC);
        if (iVar != null) {
            i2 += iVar.gpA;
        }
        AppMethodBeat.o(9337);
        return i2;
    }

    @Override // com.tencent.mm.api.x
    public final boolean isCropped() {
        AppMethodBeat.i(9338);
        com.tencent.mm.cache.a aVar = (com.tencent.mm.cache.a) ArtistCacheManager.alA().a(a.CROP_PHOTO);
        if (aVar == null) {
            AppMethodBeat.o(9338);
            return false;
        } else if (aVar.ai(this.dbi) > 0) {
            AppMethodBeat.o(9338);
            return true;
        } else {
            AppMethodBeat.o(9338);
            return false;
        }
    }

    @Override // com.tencent.mm.api.x
    public final boolean VC() {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(9339);
        com.tencent.mm.e.b c2 = this.drS.c(h.CROP_PHOTO);
        if (c2 != null && c2.XS() == a.CROP_PHOTO) {
            if (((com.tencent.mm.e.c) c2).getRotation() != 0.0f) {
                z = true;
            } else {
                z = false;
            }
            z2 = z;
        }
        AppMethodBeat.o(9339);
        return z2;
    }

    @Override // com.tencent.mm.api.x
    public final int getTextColor() {
        Stack<com.tencent.mm.z.c> stack;
        int i2;
        AppMethodBeat.i(9340);
        d dVar = (d) ArtistCacheManager.alA().a(a.EMOJI_AND_TEXT);
        if (dVar == null) {
            AppMethodBeat.o(9340);
            return 0;
        }
        if (this.dbi) {
            stack = dVar.gpx;
        } else {
            stack = dVar.gpy;
        }
        if (stack != null) {
            Iterator<com.tencent.mm.z.c> it = stack.iterator();
            i2 = 0;
            while (it.hasNext()) {
                com.tencent.mm.z.c next = it.next();
                if (next instanceof f) {
                    f fVar = (f) next;
                    int[] iArr = com.tencent.mm.view.footer.a.RoQ;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= iArr.length) {
                            break;
                        } else if (fVar.mColor == iArr[i3]) {
                            i2 = (1 << i3) | i2;
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
            }
        } else {
            i2 = 0;
        }
        AppMethodBeat.o(9340);
        return i2;
    }

    @Override // com.tencent.mm.api.x
    public final int VD() {
        Stack<com.tencent.mm.z.b> stack;
        AppMethodBeat.i(9341);
        com.tencent.mm.cache.b bVar = (com.tencent.mm.cache.b) ArtistCacheManager.alA().a(a.DOODLE);
        if (bVar == null) {
            AppMethodBeat.o(9341);
            return 0;
        }
        int[] iArr = new int[com.tencent.mm.view.footer.a.RoQ.length];
        if (this.dbi) {
            stack = bVar.gpx;
        } else {
            stack = bVar.gpy;
        }
        if (stack != null) {
            Iterator<com.tencent.mm.z.b> it = stack.iterator();
            while (it.hasNext()) {
                com.tencent.mm.z.b next = it.next();
                int[] iArr2 = com.tencent.mm.view.footer.a.RoQ;
                int i2 = 0;
                while (true) {
                    if (i2 >= iArr2.length) {
                        break;
                    } else if (next.mColor == iArr2[i2]) {
                        iArr[i2] = iArr[i2] + 1;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        int i3 = 0;
        for (int i4 : iArr) {
            if (i4 > 0) {
                i3++;
            }
        }
        AppMethodBeat.o(9341);
        return i3;
    }

    @Override // com.tencent.mm.api.x
    public final boolean VE() {
        AppMethodBeat.i(9342);
        com.tencent.mm.cache.b bVar = (com.tencent.mm.cache.b) ArtistCacheManager.alA().a(a.DOODLE);
        i iVar = (i) ArtistCacheManager.alA().a(a.MOSAIC);
        com.tencent.mm.cache.a aVar = (com.tencent.mm.cache.a) ArtistCacheManager.alA().a(a.CROP_PHOTO);
        d dVar = (d) ArtistCacheManager.alA().a(a.EMOJI_AND_TEXT);
        if ((bVar == null || bVar.ai(true) <= 0) && ((iVar == null || iVar.ai(true) <= 0) && ((dVar == null || dVar.ai(true) <= 0) && (aVar == null || aVar.ai(true) <= 0)))) {
            AppMethodBeat.o(9342);
            return false;
        }
        AppMethodBeat.o(9342);
        return true;
    }

    @Override // com.tencent.mm.api.x
    public final String VF() {
        AppMethodBeat.i(9343);
        String str = ((d) ArtistCacheManager.alA().a(a.EMOJI_AND_TEXT)).Dq(",")[0];
        AppMethodBeat.o(9343);
        return str;
    }

    @Override // com.tencent.mm.api.x
    public final String VG() {
        AppMethodBeat.i(9344);
        String str = ((d) ArtistCacheManager.alA().a(a.EMOJI_AND_TEXT)).Dq("||")[1];
        AppMethodBeat.o(9344);
        return str;
    }
}
