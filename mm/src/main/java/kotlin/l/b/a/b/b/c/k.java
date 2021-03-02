package kotlin.l.b.a.b.b.c;

import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.m;
import kotlin.l.b.a.b.b.o;
import kotlin.l.b.a.b.f.f;

public abstract class k extends j implements m {
    private final an Tik;
    private final l Tko;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 4:
            case 5:
            case 6:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 4:
                objArr[1] = "getOriginal";
                break;
            case 5:
                objArr[1] = "getContainingDeclaration";
                break;
            case 6:
                objArr[1] = "getSource";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 4:
            case 5:
            case 6:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected k(l lVar, g gVar, f fVar, an anVar) {
        super(gVar, fVar);
        if (lVar == null) {
            atM(0);
        }
        if (gVar == null) {
            atM(1);
        }
        if (fVar == null) {
            atM(2);
        }
        if (anVar == null) {
            atM(3);
        }
        this.Tko = lVar;
        this.Tik = anVar;
    }

    /* renamed from: hBT */
    public o hAE() {
        o oVar = (o) super.hAE();
        if (oVar == null) {
            atM(4);
        }
        return oVar;
    }

    @Override // kotlin.l.b.a.b.b.m, kotlin.l.b.a.b.b.l
    public l hzx() {
        l lVar = this.Tko;
        if (lVar == null) {
            atM(5);
        }
        return lVar;
    }

    @Override // kotlin.l.b.a.b.b.o
    public an hzM() {
        an anVar = this.Tik;
        if (anVar == null) {
            atM(6);
        }
        return anVar;
    }
}
