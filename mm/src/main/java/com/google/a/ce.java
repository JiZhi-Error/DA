package com.google.a;

final class ce extends cb<cd, cd> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* access modifiers changed from: package-private */
    @Override // com.google.a.cb
    public final /* bridge */ /* synthetic */ void p(Object obj, cd cdVar) {
        ((ab) obj).bVX = cdVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* access modifiers changed from: package-private */
    @Override // com.google.a.cb
    public final /* synthetic */ cd q(cd cdVar, cd cdVar2) {
        cd cdVar3 = cdVar;
        cd cdVar4 = cdVar2;
        if (cdVar4.equals(cd.HR())) {
            return cdVar3;
        }
        return cd.a(cdVar3, cdVar4);
    }

    ce() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.a.cb
    public final void ap(Object obj) {
        ((ab) obj).bVX.bNd = false;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: package-private */
    @Override // com.google.a.cb
    public final /* bridge */ /* synthetic */ cd aw(Object obj) {
        return ((ab) obj).bVX;
    }
}
