package com.c.a.b;

public class a extends i {
    static final /* synthetic */ boolean $assertionsDisabled = (!a.class.desiredAssertionStatus());
    public final p cow;
    private final long cox;
    private final int mLength;

    public a(long j2, n nVar, p pVar, int i2, long j3) {
        super(j2, nVar);
        this.cow = pVar;
        this.mLength = i2;
        this.cox = j3;
    }

    public final Object[] JZ() {
        Object[] objArr = new Object[this.mLength];
        Kl().aT(this.cox);
        for (int i2 = 0; i2 < this.mLength; i2++) {
            objArr[i2] = a(this.cow);
        }
        return objArr;
    }

    /* access modifiers changed from: package-private */
    public byte[] bR(int i2, int i3) {
        Kl().aT(this.cox);
        if (!$assertionsDisabled && this.cow == p.OBJECT) {
            throw new AssertionError();
        } else if ($assertionsDisabled || i2 + i3 <= this.mLength) {
            byte[] bArr = new byte[(this.cow.mSize * i3)];
            Kl().y(bArr, this.cow.mSize * i2, this.cow.mSize * i3);
            return bArr;
        } else {
            throw new AssertionError();
        }
    }

    @Override // com.c.a.b.i
    public final int getSize() {
        return this.mLength * this.cpb.coS.b(this.cow);
    }

    @Override // com.c.a.b.i
    public final c Ka() {
        if (this.cow == p.OBJECT) {
            return super.Ka();
        }
        return this.cpb.coS.cJ(p.c(this.cow));
    }

    public final String toString() {
        String str = Ka().mClassName;
        if (str.endsWith("[]")) {
            str = str.substring(0, str.length() - 2);
        }
        return String.format("%s[%d]@%d (0x%x)", str, Integer.valueOf(this.mLength), Long.valueOf(getUniqueId()), Long.valueOf(getUniqueId()));
    }
}
