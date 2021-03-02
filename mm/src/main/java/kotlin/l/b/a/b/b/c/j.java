package kotlin.l.b.a.b.b.c;

import kotlin.l.b.a.b.b.a.b;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.i.c;

public abstract class j extends b implements l {
    private final f TjT;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 2:
            case 3:
            case 5:
            case 6:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 4:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 2:
            case 3:
            case 5:
            case 6:
                i3 = 2;
                break;
            case 4:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
                break;
            case 4:
                objArr[0] = "descriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        switch (i2) {
            case 2:
                objArr[1] = "getName";
                break;
            case 3:
                objArr[1] = "getOriginal";
                break;
            case 4:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
                break;
            case 5:
            case 6:
                objArr[1] = "toString";
                break;
        }
        switch (i2) {
            case 2:
            case 3:
            case 5:
            case 6:
                break;
            case 4:
                objArr[2] = "toString";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 2:
            case 3:
            case 5:
            case 6:
                throw new IllegalStateException(format);
            case 4:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(g gVar, f fVar) {
        super(gVar);
        if (gVar == null) {
            atM(0);
        }
        if (fVar == null) {
            atM(1);
        }
        this.TjT = fVar;
    }

    @Override // kotlin.l.b.a.b.b.z
    public final f hAH() {
        f fVar = this.TjT;
        if (fVar == null) {
            atM(2);
        }
        return fVar;
    }

    @Override // kotlin.l.b.a.b.b.l
    public l hAE() {
        if (this == null) {
            atM(3);
        }
        return this;
    }

    public String toString() {
        return i(this);
    }

    public static String i(l lVar) {
        String str;
        try {
            str = c.TFj.k(lVar) + "[" + lVar.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(lVar)) + "]";
            if (str == null) {
                atM(5);
            }
        } catch (Throwable th) {
            str = lVar.getClass().getSimpleName() + " " + lVar.hAH();
            if (str == null) {
                atM(6);
            }
        }
        return str;
    }
}
