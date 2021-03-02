package kotlin.l.b.a.b.b.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ag;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.f.f;

public abstract class z extends k implements ag {
    static final /* synthetic */ boolean $assertionsDisabled = (!z.class.desiredAssertionStatus());
    private final ah TkG;
    public ba TkL;
    public final boolean TkO;
    public final boolean Tkp;
    private final w Tkq;
    private final b.a Tla;
    public t Tlb;
    public boolean isDefault;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 7:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                i3 = 2;
                break;
            case 7:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "visibility";
                break;
            case 2:
                objArr[0] = "correspondingProperty";
                break;
            case 3:
                objArr[0] = "annotations";
                break;
            case 4:
                objArr[0] = "name";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 7:
                objArr[0] = "substitutor";
                break;
            case 14:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "modality";
                break;
        }
        switch (i2) {
            case 6:
                objArr[1] = "getKind";
                break;
            case 7:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getModality";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getCorrespondingVariable";
                break;
            case 12:
                objArr[1] = "getCorrespondingProperty";
                break;
            case 13:
                objArr[1] = "getOverriddenDescriptors";
                break;
        }
        switch (i2) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            case 7:
                objArr[2] = "substitute";
                break;
            case 14:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(format);
            case 7:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    /* renamed from: hCo */
    public abstract ag hBT();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(w wVar, ba baVar, ah ahVar, g gVar, f fVar, boolean z, boolean z2, boolean z3, b.a aVar, an anVar) {
        super(ahVar.hzx(), gVar, fVar, anVar);
        if (wVar == null) {
            atM(0);
        }
        if (baVar == null) {
            atM(1);
        }
        if (ahVar == null) {
            atM(2);
        }
        if (gVar == null) {
            atM(3);
        }
        if (fVar == null) {
            atM(4);
        }
        if (anVar == null) {
            atM(5);
        }
        this.Tlb = null;
        this.Tkq = wVar;
        this.TkL = baVar;
        this.TkG = ahVar;
        this.isDefault = z;
        this.Tkp = z2;
        this.TkO = z3;
        this.Tla = aVar;
    }

    @Override // kotlin.l.b.a.b.b.ag
    public final boolean isDefault() {
        return this.isDefault;
    }

    @Override // kotlin.l.b.a.b.b.b
    public final b.a hAA() {
        b.a aVar = this.Tla;
        if (aVar == null) {
            atM(6);
        }
        return aVar;
    }

    @Override // kotlin.l.b.a.b.b.t
    public final boolean hAW() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.t
    public final boolean hAX() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final boolean isExternal() {
        return this.Tkp;
    }

    @Override // kotlin.l.b.a.b.b.t
    public final boolean hzI() {
        return this.TkO;
    }

    @Override // kotlin.l.b.a.b.b.t
    public final boolean hzX() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.t
    public final boolean hAZ() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final boolean hzJ() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final boolean hzK() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.t
    /* renamed from: c */
    public final t f(kotlin.l.b.a.b.m.ba baVar) {
        if (baVar == null) {
            atM(7);
        }
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.l.b.a.b.b.a
    public final List<as> hAt() {
        List<as> emptyList = Collections.emptyList();
        if (emptyList == null) {
            atM(8);
        }
        return emptyList;
    }

    @Override // kotlin.l.b.a.b.b.a
    public final boolean hAx() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final w hzC() {
        w wVar = this.Tkq;
        if (wVar == null) {
            atM(9);
        }
        return wVar;
    }

    @Override // kotlin.l.b.a.b.b.v, kotlin.l.b.a.b.b.p
    public final ba hzE() {
        ba baVar = this.TkL;
        if (baVar == null) {
            atM(10);
        }
        return baVar;
    }

    @Override // kotlin.l.b.a.b.b.ag
    public final ah hBm() {
        ah ahVar = this.TkG;
        if (ahVar == null) {
            atM(12);
        }
        return ahVar;
    }

    @Override // kotlin.l.b.a.b.b.a
    public final ak hAr() {
        return hBm().hAr();
    }

    @Override // kotlin.l.b.a.b.b.a
    public final ak hAs() {
        return hBm().hAs();
    }

    @Override // kotlin.l.b.a.b.b.t
    public final t.a<? extends t> hBa() {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    /* access modifiers changed from: protected */
    public final Collection<ag> EE(boolean z) {
        ArrayList arrayList = new ArrayList(0);
        for (ah ahVar : hBm().hAy()) {
            ag hBn = z ? ahVar.hBn() : ahVar.hBo();
            if (hBn != null) {
                arrayList.add(hBn);
            }
        }
        return arrayList;
    }

    @Override // kotlin.l.b.a.b.b.b
    public final void x(Collection<? extends b> collection) {
        if (collection == null) {
            atM(14);
        }
        if (!$assertionsDisabled && !collection.isEmpty()) {
            throw new AssertionError("Overridden accessors should be empty");
        }
    }

    @Override // kotlin.l.b.a.b.b.t
    public final t hAU() {
        return this.Tlb;
    }

    @Override // kotlin.l.b.a.b.b.t
    public final boolean hAV() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.t
    public final boolean hAY() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.a
    public final <V> V a(a.AbstractC2276a<V> aVar) {
        return null;
    }

    @Override // kotlin.l.b.a.b.b.b
    public final /* synthetic */ b a(l lVar, w wVar, ba baVar, b.a aVar) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }
}
