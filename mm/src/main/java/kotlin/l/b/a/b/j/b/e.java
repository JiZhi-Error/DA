package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;

public final class e extends p<Character> {
    public e(char c2) {
        super(Character.valueOf(c2));
        AppMethodBeat.i(60049);
        AppMethodBeat.o(60049);
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final /* synthetic */ ab b(y yVar) {
        AppMethodBeat.i(60047);
        p.h(yVar, "module");
        aj a2 = yVar.hBh().a(h.CHAR);
        if (a2 == null) {
            g.atM(61);
        }
        p.g(a2, "module.builtIns.charType");
        aj ajVar = a2;
        AppMethodBeat.o(60047);
        return ajVar;
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final String toString() {
        String str;
        boolean z;
        AppMethodBeat.i(60048);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(((Character) getValue()).charValue());
        char charValue = ((Character) getValue()).charValue();
        switch (charValue) {
            case '\b':
                str = "\\b";
                break;
            case '\t':
                str = "\\t";
                break;
            case '\n':
                str = "\\n";
                break;
            case 11:
            default:
                byte type = (byte) Character.getType(charValue);
                if (type == 0 || type == 13 || type == 14 || type == 15 || type == 16 || type == 18 || type == 19) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    str = "?";
                    break;
                } else {
                    str = String.valueOf(charValue);
                    break;
                }
                break;
            case '\f':
                str = "\\f";
                break;
            case '\r':
                str = "\\r";
                break;
        }
        objArr[1] = str;
        String format = String.format("\\u%04X ('%s')", Arrays.copyOf(objArr, 2));
        p.g(format, "java.lang.String.format(this, *args)");
        AppMethodBeat.o(60048);
        return format;
    }
}
