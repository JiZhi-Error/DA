package kotlin.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.f.f;

/* JADX WARN: Init of enum Tfd can be incorrect */
/* JADX WARN: Init of enum Tfe can be incorrect */
/* JADX WARN: Init of enum Tff can be incorrect */
/* JADX WARN: Init of enum Tfg can be incorrect */
public enum l {
    UBYTE(r3),
    USHORT(r3),
    UINT(r3),
    ULONG(r3);
    
    final f TeD;
    final a Tfi = new a(this.Tfj.hIY(), f.btY(this.TeD.sG() + "Array"));
    final a Tfj;

    public static l valueOf(String str) {
        AppMethodBeat.i(56700);
        l lVar = (l) Enum.valueOf(l.class, str);
        AppMethodBeat.o(56700);
        return lVar;
    }

    private l(a aVar) {
        AppMethodBeat.i(56698);
        this.Tfj = aVar;
        f hJa = this.Tfj.hJa();
        p.g(hJa, "classId.shortClassName");
        this.TeD = hJa;
        AppMethodBeat.o(56698);
    }

    static {
        AppMethodBeat.i(56697);
        p.g(a.btX("kotlin/UByte"), "ClassId.fromString(\"kotlin/UByte\")");
        p.g(a.btX("kotlin/UShort"), "ClassId.fromString(\"kotlin/UShort\")");
        p.g(a.btX("kotlin/UInt"), "ClassId.fromString(\"kotlin/UInt\")");
        p.g(a.btX("kotlin/ULong"), "ClassId.fromString(\"kotlin/ULong\")");
        AppMethodBeat.o(56697);
    }
}
