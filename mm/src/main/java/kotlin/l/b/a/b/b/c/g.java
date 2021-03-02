package kotlin.l.b.a.b.b.c;

import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.l.j;

public abstract class g extends a {
    private final an Tik;
    private final l Tko;
    private final boolean Tkp;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 4:
            case 5:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
            case 5:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i2) {
            case 4:
                objArr[1] = "getContainingDeclaration";
                break;
            case 5:
                objArr[1] = "getSource";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 4:
            case 5:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected g(j jVar, l lVar, f fVar, an anVar) {
        super(jVar, fVar);
        if (jVar == null) {
            atM(0);
        }
        if (lVar == null) {
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
        this.Tkp = false;
    }

    @Override // kotlin.l.b.a.b.b.v
    public boolean isExternal() {
        return this.Tkp;
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.m, kotlin.l.b.a.b.b.l
    public final l hzx() {
        l lVar = this.Tko;
        if (lVar == null) {
            atM(4);
        }
        return lVar;
    }

    @Override // kotlin.l.b.a.b.b.o
    public final an hzM() {
        an anVar = this.Tik;
        if (anVar == null) {
            atM(5);
        }
        return anVar;
    }
}
