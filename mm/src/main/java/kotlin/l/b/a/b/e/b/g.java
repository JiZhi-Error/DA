package kotlin.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.e.a;

public final class g {
    public static final a.p a(a.p.C2320a aVar, h hVar) {
        AppMethodBeat.i(59071);
        p.h(aVar, "$this$type");
        p.h(hVar, "typeTable");
        if (aVar.Cm()) {
            a.p pVar = aVar.Tzy;
            AppMethodBeat.o(59071);
            return pVar;
        } else if (aVar.hHi()) {
            a.p avo = hVar.avo(aVar.Tzz);
            AppMethodBeat.o(59071);
            return avo;
        } else {
            AppMethodBeat.o(59071);
            return null;
        }
    }

    public static final a.p a(a.p pVar, h hVar) {
        AppMethodBeat.i(59072);
        p.h(pVar, "$this$flexibleUpperBound");
        p.h(hVar, "typeTable");
        if (pVar.hGV()) {
            a.p pVar2 = pVar.Tzm;
            AppMethodBeat.o(59072);
            return pVar2;
        } else if (pVar.hGW()) {
            a.p avo = hVar.avo(pVar.Tzn);
            AppMethodBeat.o(59072);
            return avo;
        } else {
            AppMethodBeat.o(59072);
            return null;
        }
    }

    public static final a.p a(a.h hVar, h hVar2) {
        AppMethodBeat.i(59073);
        p.h(hVar, "$this$returnType");
        p.h(hVar2, "typeTable");
        if (hVar.hGb()) {
            a.p pVar = hVar.Tyy;
            p.g(pVar, "returnType");
            AppMethodBeat.o(59073);
            return pVar;
        } else if (hVar.hGc()) {
            a.p avo = hVar2.avo(hVar.Tyz);
            AppMethodBeat.o(59073);
            return avo;
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("No returnType in ProtoBuf.Function".toString());
            AppMethodBeat.o(59073);
            throw illegalStateException;
        }
    }

    public static final boolean f(a.h hVar) {
        AppMethodBeat.i(59074);
        p.h(hVar, "$this$hasReceiver");
        if (hVar.hGd() || hVar.hGe()) {
            AppMethodBeat.o(59074);
            return true;
        }
        AppMethodBeat.o(59074);
        return false;
    }

    public static final a.p b(a.h hVar, h hVar2) {
        AppMethodBeat.i(59075);
        p.h(hVar, "$this$receiverType");
        p.h(hVar2, "typeTable");
        if (hVar.hGd()) {
            a.p pVar = hVar.TyA;
            AppMethodBeat.o(59075);
            return pVar;
        } else if (hVar.hGe()) {
            a.p avo = hVar2.avo(hVar.TyB);
            AppMethodBeat.o(59075);
            return avo;
        } else {
            AppMethodBeat.o(59075);
            return null;
        }
    }

    public static final a.p a(a.m mVar, h hVar) {
        AppMethodBeat.i(59076);
        p.h(mVar, "$this$returnType");
        p.h(hVar, "typeTable");
        if (mVar.hGb()) {
            a.p pVar = mVar.Tyy;
            p.g(pVar, "returnType");
            AppMethodBeat.o(59076);
            return pVar;
        } else if (mVar.hGc()) {
            a.p avo = hVar.avo(mVar.Tyz);
            AppMethodBeat.o(59076);
            return avo;
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("No returnType in ProtoBuf.Property".toString());
            AppMethodBeat.o(59076);
            throw illegalStateException;
        }
    }

    public static final boolean e(a.m mVar) {
        AppMethodBeat.i(59077);
        p.h(mVar, "$this$hasReceiver");
        if (mVar.hGd() || mVar.hGe()) {
            AppMethodBeat.o(59077);
            return true;
        }
        AppMethodBeat.o(59077);
        return false;
    }

    public static final a.p b(a.m mVar, h hVar) {
        AppMethodBeat.i(59078);
        p.h(mVar, "$this$receiverType");
        p.h(hVar, "typeTable");
        if (mVar.hGd()) {
            a.p pVar = mVar.TyA;
            AppMethodBeat.o(59078);
            return pVar;
        } else if (mVar.hGe()) {
            a.p avo = hVar.avo(mVar.TyB);
            AppMethodBeat.o(59078);
            return avo;
        } else {
            AppMethodBeat.o(59078);
            return null;
        }
    }

    public static final a.p a(a.t tVar, h hVar) {
        AppMethodBeat.i(59079);
        p.h(tVar, "$this$type");
        p.h(hVar, "typeTable");
        if (tVar.Cm()) {
            a.p pVar = tVar.Tzy;
            p.g(pVar, "type");
            AppMethodBeat.o(59079);
            return pVar;
        } else if (tVar.hHi()) {
            a.p avo = hVar.avo(tVar.Tzz);
            AppMethodBeat.o(59079);
            return avo;
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
            AppMethodBeat.o(59079);
            throw illegalStateException;
        }
    }

    public static final a.p b(a.t tVar, h hVar) {
        AppMethodBeat.i(59080);
        p.h(tVar, "$this$varargElementType");
        p.h(hVar, "typeTable");
        if (tVar.hHO()) {
            a.p pVar = tVar.TzZ;
            AppMethodBeat.o(59080);
            return pVar;
        } else if (tVar.hHP()) {
            a.p avo = hVar.avo(tVar.TAa);
            AppMethodBeat.o(59080);
            return avo;
        } else {
            AppMethodBeat.o(59080);
            return null;
        }
    }

    public static final a.p b(a.p pVar, h hVar) {
        AppMethodBeat.i(59081);
        p.h(pVar, "$this$outerType");
        p.h(hVar, "typeTable");
        if (pVar.hHb()) {
            a.p pVar2 = pVar.Tzs;
            AppMethodBeat.o(59081);
            return pVar2;
        } else if (pVar.hHc()) {
            a.p avo = hVar.avo(pVar.Tzt);
            AppMethodBeat.o(59081);
            return avo;
        } else {
            AppMethodBeat.o(59081);
            return null;
        }
    }

    public static final a.p c(a.p pVar, h hVar) {
        AppMethodBeat.i(59082);
        p.h(pVar, "$this$abbreviatedType");
        p.h(hVar, "typeTable");
        if (pVar.hHd()) {
            a.p pVar2 = pVar.Tzu;
            AppMethodBeat.o(59082);
            return pVar2;
        } else if (pVar.hHe()) {
            a.p avo = hVar.avo(pVar.Tzv);
            AppMethodBeat.o(59082);
            return avo;
        } else {
            AppMethodBeat.o(59082);
            return null;
        }
    }
}
