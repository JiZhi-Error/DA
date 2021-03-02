package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class j implements i {
    public final Set<i.f> lxE = Collections.newSetFromMap(new ConcurrentHashMap());
    public final Set<i.b> lxF = Collections.newSetFromMap(new ConcurrentHashMap());
    public final Set<i.d> lxG = Collections.newSetFromMap(new ConcurrentHashMap());
    public final Set<i.c> lxH = Collections.newSetFromMap(new ConcurrentHashMap());
    public final Set<i.a> lxI = Collections.newSetFromMap(new ConcurrentHashMap());
    public final Set<Object> lxJ = Collections.newSetFromMap(new ConcurrentHashMap());
    public final Set<i.e> lxK = Collections.newSetFromMap(new ConcurrentHashMap());
    public final Set<Object> lxL = Collections.newSetFromMap(new ConcurrentHashMap());
    private boolean lxM = true;

    public j() {
        AppMethodBeat.i(140627);
        AppMethodBeat.o(140627);
    }

    public final void a(i.f fVar) {
        AppMethodBeat.i(140628);
        this.lxE.add(fVar);
        AppMethodBeat.o(140628);
    }

    public final void b(i.f fVar) {
        AppMethodBeat.i(140629);
        this.lxE.remove(fVar);
        AppMethodBeat.o(140629);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i
    public final void a(i.b bVar) {
        AppMethodBeat.i(140630);
        this.lxF.add(bVar);
        AppMethodBeat.o(140630);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i
    public final void b(i.b bVar) {
        AppMethodBeat.i(140631);
        this.lxF.remove(bVar);
        AppMethodBeat.o(140631);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i
    public final void a(i.d dVar) {
        AppMethodBeat.i(140632);
        this.lxG.add(dVar);
        AppMethodBeat.o(140632);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i
    public final void b(i.d dVar) {
        AppMethodBeat.i(140633);
        this.lxG.remove(dVar);
        AppMethodBeat.o(140633);
    }

    public final void hh(boolean z) {
        AppMethodBeat.i(174621);
        if (this.lxM && !z) {
            Iterator<Object> it = this.lxL.iterator();
            while (it.hasNext()) {
                it.next();
            }
        } else if (!this.lxM && z) {
            for (i.e eVar : this.lxK) {
                eVar.NZ();
            }
        }
        this.lxM = z;
        AppMethodBeat.o(174621);
    }

    public final void a(i.e eVar) {
        AppMethodBeat.i(174622);
        this.lxK.add(eVar);
        AppMethodBeat.o(174622);
    }

    public final void b(i.e eVar) {
        AppMethodBeat.i(174623);
        this.lxK.remove(eVar);
        AppMethodBeat.o(174623);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i
    public final void a(i.c cVar) {
        AppMethodBeat.i(140634);
        this.lxH.add(cVar);
        AppMethodBeat.o(140634);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i
    public final void b(i.c cVar) {
        AppMethodBeat.i(140635);
        this.lxH.remove(cVar);
        AppMethodBeat.o(140635);
    }
}
