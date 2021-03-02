package com.c.a.b;

import com.c.a.a.b.e;
import com.c.a.c.k;
import java.util.ArrayList;
import java.util.Collection;

public final class g {
    k<m> coL = new k<>();
    com.c.a.c.g<n> coM = new com.c.a.c.g<>();
    ArrayList<j> coN = new ArrayList<>();
    com.c.a.c.g<o> coO = new com.c.a.c.g<>();
    k<c> coP = new k<>();
    com.c.a.a.b.k<String, c> coQ = e.JV();
    final k<i> coR = new k<>();
    l coS;
    final int mId;
    private final String mName;

    public g(int i2, String str) {
        this.mId = i2;
        this.mName = str;
    }

    public final n hq(int i2) {
        return this.coM.get(i2);
    }

    public final n bS(int i2, int i3) {
        n nVar = this.coM.get(i2);
        if (nVar == null) {
            return nVar;
        }
        n nVar2 = new n();
        if (nVar.cpN != null) {
            nVar2.cpN = nVar.cpN;
        } else {
            nVar2.cpN = nVar;
        }
        nVar2.fs = nVar.fs + i3;
        return nVar2;
    }

    public final void a(j jVar) {
        jVar.mIndex = this.coN.size();
        this.coN.add(jVar);
    }

    public final o hr(int i2) {
        return this.coO.get(i2);
    }

    public final void a(long j2, i iVar) {
        this.coR.a(j2, iVar);
    }

    public final i aN(long j2) {
        return this.coR.get(j2);
    }

    public final c aO(long j2) {
        return this.coP.get(j2);
    }

    public final c cI(String str) {
        Collection<c> az = this.coQ.az(str);
        if (az.size() == 1) {
            return az.iterator().next();
        }
        return null;
    }
}
