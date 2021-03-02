package com.google.a;

final class ar implements ap {
    ar() {
    }

    @Override // com.google.a.ap
    public final Object au(Object obj) {
        ((ao) obj).bNd = false;
        return obj;
    }

    @Override // com.google.a.ap
    public final Object m(Object obj, Object obj2) {
        ao aoVar;
        ao aoVar2 = (ao) obj;
        ao aoVar3 = (ao) obj2;
        if (aoVar3.isEmpty()) {
            return aoVar2;
        }
        if (!aoVar2.bNd) {
            aoVar = aoVar2.isEmpty() ? new ao() : new ao(aoVar2);
        } else {
            aoVar = aoVar2;
        }
        aoVar.GY();
        if (aoVar3.isEmpty()) {
            return aoVar;
        }
        aoVar.putAll(aoVar3);
        return aoVar;
    }
}
