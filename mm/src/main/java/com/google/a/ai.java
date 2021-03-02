package com.google.a;

public class ai {
    private static final r bNc = r.Gd();
    private g bXH;
    private r bXI;
    protected volatile aw bXJ;
    private volatile g bXK;

    public ai(r rVar, g gVar) {
        if (rVar == null) {
            throw new NullPointerException("found null ExtensionRegistry");
        } else if (gVar == null) {
            throw new NullPointerException("found null ByteString");
        } else {
            this.bXI = rVar;
            this.bXH = gVar;
        }
    }

    public ai() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ai)) {
            return false;
        }
        ai aiVar = (ai) obj;
        aw awVar = this.bXJ;
        aw awVar2 = aiVar.bXJ;
        if (awVar == null && awVar2 == null) {
            return yI().equals(aiVar.yI());
        }
        if (awVar != null && awVar2 != null) {
            return awVar.equals(awVar2);
        }
        if (awVar != null) {
            return awVar.equals(aiVar.g(awVar.AP()));
        }
        return g(awVar2.AP()).equals(awVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final aw g(aw awVar) {
        i(awVar);
        return this.bXJ;
    }

    public final aw h(aw awVar) {
        aw awVar2 = this.bXJ;
        this.bXH = null;
        this.bXK = null;
        this.bXJ = awVar;
        return awVar2;
    }

    public final int yC() {
        if (this.bXK != null) {
            return this.bXK.size();
        }
        if (this.bXH != null) {
            return this.bXH.size();
        }
        if (this.bXJ != null) {
            return this.bXJ.yC();
        }
        return 0;
    }

    public final g yI() {
        if (this.bXK != null) {
            return this.bXK;
        }
        if (this.bXH != null) {
            return this.bXH;
        }
        synchronized (this) {
            if (this.bXK != null) {
                return this.bXK;
            }
            if (this.bXJ == null) {
                this.bXK = g.bNg;
            } else {
                this.bXK = this.bXJ.yI();
            }
            return this.bXK;
        }
    }

    private void i(aw awVar) {
        if (this.bXJ == null) {
            synchronized (this) {
                if (this.bXJ == null) {
                    try {
                        if (this.bXH != null) {
                            this.bXJ = (aw) awVar.AK().e(this.bXH, this.bXI);
                            this.bXK = this.bXH;
                        } else {
                            this.bXJ = awVar;
                            this.bXK = g.bNg;
                        }
                    } catch (af e2) {
                        this.bXJ = awVar;
                        this.bXK = g.bNg;
                    }
                }
            }
        }
    }
}
