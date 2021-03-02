package com.bumptech.glide.e;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.e.a;
import com.bumptech.glide.g.b;
import com.bumptech.glide.g.k;
import com.bumptech.glide.load.b.j;
import com.bumptech.glide.load.d.e.c;
import com.bumptech.glide.load.d.e.f;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.l;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.Map;

public abstract class a<T extends a<T>> implements Cloneable {
    public boolean aFI = true;
    g aFT = com.bumptech.glide.f.a.qq();
    public i aFV = new i();
    Class<?> aFX = Object.class;
    Map<Class<?>, l<?>> aFZ = new b();
    protected com.bumptech.glide.g aGc = com.bumptech.glide.g.NORMAL;
    j aGd = j.aHd;
    boolean aGe;
    boolean aGf = true;
    boolean aGr;
    boolean aHC;
    public boolean aHY;
    int aMU;
    float aMV = 1.0f;
    Drawable aMW;
    int aMX;
    Drawable aMY;
    int aMZ;
    protected int aNa = -1;
    protected int aNb = -1;
    private boolean aNc = true;
    Drawable aNd;
    int aNe;
    Resources.Theme aNf;
    public boolean aNg;
    boolean aNh;

    private static boolean aQ(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    public final T Q(float f2) {
        while (this.aNg) {
            this = this.clone();
        }
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.aMV = f2;
        this.aMU |= 2;
        return this.pY();
    }

    public final T pW() {
        while (this.aNg) {
            this = this.clone();
        }
        this.aHC = true;
        this.aMU |= 1048576;
        return this.pY();
    }

    public final T a(j jVar) {
        while (this.aNg) {
            this = this.clone();
        }
        this.aGd = (j) com.bumptech.glide.g.j.checkNotNull(jVar, "Argument must not be null");
        this.aMU |= 4;
        return this.pY();
    }

    public final T b(com.bumptech.glide.g gVar) {
        while (this.aNg) {
            this = this.clone();
        }
        this.aGc = (com.bumptech.glide.g) com.bumptech.glide.g.j.checkNotNull(gVar, "Argument must not be null");
        this.aMU |= 8;
        return this.pY();
    }

    public final T pX() {
        while (this.aNg) {
            this = this.clone();
        }
        this.aFI = false;
        this.aMU |= 256;
        return this.pY();
    }

    public final T aR(int i2, int i3) {
        while (this.aNg) {
            this = this.clone();
        }
        this.aNb = i2;
        this.aNa = i3;
        this.aMU |= 512;
        return this.pY();
    }

    /* renamed from: nQ */
    public T clone() {
        try {
            T t = (T) ((a) super.clone());
            t.aFV = new i();
            t.aFV.a(this.aFV);
            t.aFZ = new b();
            t.aFZ.putAll(this.aFZ);
            t.aHY = false;
            t.aNg = false;
            return t;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.bumptech.glide.load.l<android.graphics.Bitmap> */
    /* JADX WARN: Multi-variable type inference failed */
    public final T a(l<Bitmap> lVar) {
        while (this.aNg) {
            this = this.clone();
        }
        com.bumptech.glide.load.d.a.j jVar = new com.bumptech.glide.load.d.a.j(lVar, true);
        this.a(Bitmap.class, lVar, true);
        this.a(Drawable.class, jVar, true);
        this.a(BitmapDrawable.class, jVar, true);
        this.a(c.class, new f(lVar), true);
        return this.pY();
    }

    private <Y> T a(Class<Y> cls, l<Y> lVar, boolean z) {
        while (this.aNg) {
            this = this.clone();
        }
        com.bumptech.glide.g.j.checkNotNull(cls, "Argument must not be null");
        com.bumptech.glide.g.j.checkNotNull(lVar, "Argument must not be null");
        this.aFZ.put(cls, lVar);
        this.aMU |= 2048;
        this.aNc = true;
        this.aMU |= 65536;
        this.aGf = false;
        this.aMU |= 131072;
        this.aGe = true;
        return this.pY();
    }

    public T b(a<?> aVar) {
        if (this.aNg) {
            return (T) clone().b(aVar);
        }
        if (aQ(aVar.aMU, 2)) {
            this.aMV = aVar.aMV;
        }
        if (aQ(aVar.aMU, TPMediaCodecProfileLevel.HEVCMainTierLevel52)) {
            this.aNh = aVar.aNh;
        }
        if (aQ(aVar.aMU, 1048576)) {
            this.aHC = aVar.aHC;
        }
        if (aQ(aVar.aMU, 4)) {
            this.aGd = aVar.aGd;
        }
        if (aQ(aVar.aMU, 8)) {
            this.aGc = aVar.aGc;
        }
        if (aQ(aVar.aMU, 16)) {
            this.aMW = aVar.aMW;
            this.aMX = 0;
            this.aMU &= -33;
        }
        if (aQ(aVar.aMU, 32)) {
            this.aMX = aVar.aMX;
            this.aMW = null;
            this.aMU &= -17;
        }
        if (aQ(aVar.aMU, 64)) {
            this.aMY = aVar.aMY;
            this.aMZ = 0;
            this.aMU &= -129;
        }
        if (aQ(aVar.aMU, 128)) {
            this.aMZ = aVar.aMZ;
            this.aMY = null;
            this.aMU &= -65;
        }
        if (aQ(aVar.aMU, 256)) {
            this.aFI = aVar.aFI;
        }
        if (aQ(aVar.aMU, 512)) {
            this.aNb = aVar.aNb;
            this.aNa = aVar.aNa;
        }
        if (aQ(aVar.aMU, 1024)) {
            this.aFT = aVar.aFT;
        }
        if (aQ(aVar.aMU, 4096)) {
            this.aFX = aVar.aFX;
        }
        if (aQ(aVar.aMU, 8192)) {
            this.aNd = aVar.aNd;
            this.aNe = 0;
            this.aMU &= -16385;
        }
        if (aQ(aVar.aMU, 16384)) {
            this.aNe = aVar.aNe;
            this.aNd = null;
            this.aMU &= -8193;
        }
        if (aQ(aVar.aMU, 32768)) {
            this.aNf = aVar.aNf;
        }
        if (aQ(aVar.aMU, 65536)) {
            this.aNc = aVar.aNc;
        }
        if (aQ(aVar.aMU, 131072)) {
            this.aGe = aVar.aGe;
        }
        if (aQ(aVar.aMU, 2048)) {
            this.aFZ.putAll(aVar.aFZ);
            this.aGf = aVar.aGf;
        }
        if (aQ(aVar.aMU, 524288)) {
            this.aGr = aVar.aGr;
        }
        if (!this.aNc) {
            this.aFZ.clear();
            this.aMU &= -2049;
            this.aGe = false;
            this.aMU &= -131073;
            this.aGf = true;
        }
        this.aMU |= aVar.aMU;
        this.aFV.a(aVar.aFV);
        return pY();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (Float.compare(aVar.aMV, this.aMV) == 0 && this.aMX == aVar.aMX && k.h(this.aMW, aVar.aMW) && this.aMZ == aVar.aMZ && k.h(this.aMY, aVar.aMY) && this.aNe == aVar.aNe && k.h(this.aNd, aVar.aNd) && this.aFI == aVar.aFI && this.aNa == aVar.aNa && this.aNb == aVar.aNb && this.aGe == aVar.aGe && this.aNc == aVar.aNc && this.aNh == aVar.aNh && this.aGr == aVar.aGr && this.aGd.equals(aVar.aGd) && this.aGc == aVar.aGc && this.aFV.equals(aVar.aFV) && this.aFZ.equals(aVar.aFZ) && this.aFX.equals(aVar.aFX) && k.h(this.aFT, aVar.aFT) && k.h(this.aNf, aVar.aNf)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return k.a(this.aNf, k.a(this.aFT, k.a(this.aFX, k.a(this.aFZ, k.a(this.aFV, k.a(this.aGc, k.a(this.aGd, k.b(this.aGr, k.b(this.aNh, k.b(this.aNc, k.b(this.aGe, k.hashCode(this.aNb, k.hashCode(this.aNa, k.b(this.aFI, k.a(this.aNd, k.hashCode(this.aNe, k.a(this.aMY, k.hashCode(this.aMZ, k.a(this.aMW, k.hashCode(this.aMX, k.hashCode(this.aMV)))))))))))))))))))));
    }

    /* access modifiers changed from: package-private */
    public final T pY() {
        if (!this.aHY) {
            return this;
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    public final boolean pZ() {
        return k.aT(this.aNb, this.aNa);
    }

    /* access modifiers changed from: protected */
    public final boolean qa() {
        return aQ(this.aMU, 8);
    }
}
