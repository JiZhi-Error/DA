package kotlin.l.b.a.b.b.c;

import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.aq;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.bh;

public abstract class b extends e {
    private static /* synthetic */ void atM(int i2) {
        Object[] objArr = new Object[3];
        switch (i2) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "variance";
                break;
            case 4:
                objArr[0] = "source";
                break;
            case 5:
                objArr[0] = "supertypeLoopChecker";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        objArr[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(j jVar, l lVar, f fVar, bh bhVar, boolean z, int i2, an anVar, aq aqVar) {
        super(jVar, lVar, g.a.hBP(), fVar, bhVar, z, i2, anVar, aqVar);
        if (jVar == null) {
            atM(0);
        }
        if (lVar == null) {
            atM(1);
        }
        if (fVar == null) {
            atM(2);
        }
        if (bhVar == null) {
            atM(3);
        }
        if (anVar == null) {
            atM(4);
        }
        if (aqVar == null) {
            atM(5);
        }
        g.a aVar = g.TiC;
    }

    @Override // kotlin.l.b.a.b.b.c.j
    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = this.Tkf ? "reified " : "";
        objArr[1] = hAJ() == bh.INVARIANT ? "" : hAJ() + " ";
        objArr[2] = hAH();
        return String.format("%s%s%s", objArr);
    }
}
