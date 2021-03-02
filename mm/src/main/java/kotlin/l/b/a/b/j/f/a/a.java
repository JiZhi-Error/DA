package kotlin.l.b.a.b.j.f.a;

import kotlin.l.b.a.b.m.ab;

public abstract class a implements e {
    private final e TKm;
    protected final ab Tqr;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 1:
            case 2:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 1:
            case 2:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 2:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
                break;
            default:
                objArr[0] = "receiverType";
                break;
        }
        switch (i2) {
            case 1:
                objArr[1] = "getType";
                break;
            case 2:
                objArr[1] = "getOriginal";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
                break;
        }
        switch (i2) {
            case 1:
            case 2:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 1:
            case 2:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public a(ab abVar, e eVar) {
        if (abVar == null) {
            atM(0);
        }
        this.Tqr = abVar;
        this.TKm = eVar == null ? this : eVar;
    }

    @Override // kotlin.l.b.a.b.j.f.a.e
    public final ab hBy() {
        ab abVar = this.Tqr;
        if (abVar == null) {
            atM(1);
        }
        return abVar;
    }
}
