package com.c.a.b;

import java.util.Arrays;

public final class d {
    public final p cow;
    public final String mName;

    public d(p pVar, String str) {
        this.cow = pVar;
        this.mName = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.cow == dVar.cow && this.mName.equals(dVar.mName);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.cow, this.mName});
    }
}
