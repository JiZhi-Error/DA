package kotlin.l.b.a.b.b.c;

import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.l.g;

public abstract class al extends ak {
    static final /* synthetic */ boolean $assertionsDisabled = (!al.class.desiredAssertionStatus());
    protected final boolean TmC;
    protected g<kotlin.l.b.a.b.j.b.g<?>> TmD;

    private static /* synthetic */ void atM(int i2) {
        Object[] objArr = new Object[3];
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
                objArr[0] = "compileTimeInitializer";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        switch (i2) {
            case 4:
                objArr[2] = "setCompileTimeInitializer";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public al(l lVar, kotlin.l.b.a.b.b.a.g gVar, f fVar, boolean z, an anVar) {
        super(lVar, gVar, fVar, null, anVar);
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
        this.TmC = z;
    }

    @Override // kotlin.l.b.a.b.b.ax
    public final boolean hBF() {
        return this.TmC;
    }

    @Override // kotlin.l.b.a.b.b.ax
    public final kotlin.l.b.a.b.j.b.g<?> hBG() {
        if (this.TmD != null) {
            return (kotlin.l.b.a.b.j.b.g) this.TmD.invoke();
        }
        return null;
    }

    public final void a(g<kotlin.l.b.a.b.j.b.g<?>> gVar) {
        if (gVar == null) {
            atM(4);
        }
        if ($assertionsDisabled || !this.TmC) {
            this.TmD = gVar;
            return;
        }
        throw new AssertionError("Constant value for variable initializer should be recorded only for final variables: " + hAH());
    }
}
