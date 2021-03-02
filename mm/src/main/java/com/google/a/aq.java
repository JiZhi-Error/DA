package com.google.a;

import com.google.a.an;

public class aq implements ap {
    aq() {
    }

    @Override // com.google.a.ap
    public final Object au(Object obj) {
        ((an) obj).bNd = false;
        return obj;
    }

    @Override // com.google.a.ap
    public final Object m(Object obj, Object obj2) {
        an anVar = (an) obj;
        an anVar2 = (an) obj2;
        if (!anVar.bNd) {
            new an(anVar.bXW, an.c.MAP, ao.d(anVar.GV()));
        }
        if (anVar.bXT != an.c.MAP) {
            if (anVar.bXT == an.c.LIST) {
                anVar.bXU = anVar.C(anVar.bXV);
            }
            anVar.bXV = null;
            anVar.bXT = an.c.MAP;
        }
        anVar.bXU.putAll(ao.d(anVar2.GV()));
        return anVar;
    }
}
