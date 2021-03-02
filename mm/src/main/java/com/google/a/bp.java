package com.google.a;

/* access modifiers changed from: package-private */
public final class bp implements au {
    final aw bXE;
    final Object[] bYp;
    private final int flags;
    final String info;

    @Override // com.google.a.au
    public final aw Hg() {
        return this.bXE;
    }

    @Override // com.google.a.au
    public final bl He() {
        return (this.flags & 1) == 1 ? bl.PROTO2 : bl.PROTO3;
    }

    @Override // com.google.a.au
    public final boolean Hf() {
        return (this.flags & 2) == 2;
    }
}
