package com.c.a.b;

import com.c.a.b.a.a;
import com.tencent.smtt.export.external.interfaces.ISelectionInterface;
import java.util.ArrayList;

public abstract class i {
    static final /* synthetic */ boolean $assertionsDisabled = (!i.class.desiredAssertionStatus());
    protected final long MS;
    protected final n coZ;
    long cpa;
    g cpb;
    int cpc = Integer.MAX_VALUE;
    boolean cpd = false;
    i cpe = null;
    private final ArrayList<i> cpf = new ArrayList<>();
    private ArrayList<i> cpg = null;
    int mSize;

    i(long j2, n nVar) {
        this.MS = j2;
        this.coZ = nVar;
    }

    public final long getId() {
        return this.MS;
    }

    public c Ka() {
        return this.cpb.coS.aS(this.cpa);
    }

    public int getSize() {
        return this.mSize;
    }

    /* access modifiers changed from: protected */
    public final Object a(p pVar) {
        switch (pVar) {
            case OBJECT:
                return this.cpb.coS.aR(Ki());
            case BOOLEAN:
                return Boolean.valueOf(Kl().readByte() != 0);
            case CHAR:
                return Character.valueOf(Kl().readChar());
            case FLOAT:
                return Float.valueOf(Kl().readFloat());
            case DOUBLE:
                return Double.valueOf(Kl().readDouble());
            case BYTE:
                return Byte.valueOf(Kl().readByte());
            case SHORT:
                return Short.valueOf(Kl().readShort());
            case INT:
                return Integer.valueOf(Kl().readInt());
            case LONG:
                return Long.valueOf(Kl().readLong());
            default:
                return null;
        }
    }

    /* access modifiers changed from: protected */
    public final long Ki() {
        switch (this.cpb.coS.b(p.OBJECT)) {
            case 1:
                return (long) Kl().readByte();
            case 2:
                return (long) Kl().readShort();
            case 3:
            case 5:
            case 6:
            case 7:
            default:
                return 0;
            case 4:
                return (long) Kl().readInt();
            case 8:
                return Kl().readLong();
        }
    }

    /* access modifiers changed from: protected */
    public final int readUnsignedByte() {
        return Kl().readByte() & 255;
    }

    /* access modifiers changed from: protected */
    public final int readUnsignedShort() {
        return Kl().readShort() & ISelectionInterface.HELD_NOTHING;
    }

    /* access modifiers changed from: protected */
    public final a Kl() {
        return this.cpb.coS.cpD;
    }

    public final long getUniqueId() {
        return this.MS & this.cpb.coS.cpI;
    }
}
