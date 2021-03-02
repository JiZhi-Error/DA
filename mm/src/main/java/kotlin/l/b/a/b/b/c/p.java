package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.a.i;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ax;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.aj;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ay;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.o.h;

public abstract class p extends k implements t {
    private List<as> Thx;
    private List<av> TkH;
    private ab TkI;
    private ak TkJ;
    protected ak TkK;
    public ba TkL;
    public boolean TkM;
    public boolean TkN;
    public boolean TkO;
    public boolean TkP;
    public boolean TkQ;
    boolean TkR;
    boolean TkS;
    boolean TkT;
    public boolean TkU;
    private boolean TkV;
    private boolean TkW;
    private Collection<? extends t> TkX;
    private volatile kotlin.g.a.a<Collection<t>> TkY;
    private final t TkZ;
    public boolean Tkp;
    private w Tkq;
    private final b.a Tla;
    private t Tlb;
    protected Map<a.AbstractC2276a<?>, Object> Tlc;

    public static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                i3 = 2;
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
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
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "source";
                break;
            case 5:
                objArr[0] = "typeParameters";
                break;
            case 6:
            case 26:
            case 28:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 7:
            case 9:
                objArr[0] = "visibility";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 10:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case 11:
                objArr[0] = "extensionReceiverParameter";
                break;
            case 15:
                objArr[0] = "overriddenDescriptors";
                break;
            case 20:
                objArr[0] = "originalSubstitutor";
                break;
            case 22:
            case 27:
            case 29:
                objArr[0] = "substitutor";
                break;
            case 23:
                objArr[0] = "configuration";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 8:
                objArr[1] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 12:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 13:
                objArr[1] = "getModality";
                break;
            case 14:
                objArr[1] = "getVisibility";
                break;
            case 16:
                objArr[1] = "getTypeParameters";
                break;
            case 17:
                objArr[1] = "getValueParameters";
                break;
            case 18:
                objArr[1] = "getOriginal";
                break;
            case 19:
                objArr[1] = "getKind";
                break;
            case 21:
                objArr[1] = "newCopyBuilder";
                break;
            case 24:
                objArr[1] = "copy";
                break;
            case 25:
                objArr[1] = "getSourceToUseForCopy";
                break;
        }
        switch (i2) {
            case 5:
            case 6:
            case 7:
                objArr[2] = "initialize";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 10:
                objArr[2] = "setReturnType";
                break;
            case 11:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case 15:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 20:
                objArr[2] = "substitute";
                break;
            case 22:
                objArr[2] = "newCopyBuilder";
                break;
            case 23:
                objArr[2] = "doSubstitute";
                break;
            case 26:
            case 27:
            case 28:
            case 29:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                throw new IllegalStateException(format);
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    /* access modifiers changed from: protected */
    public abstract p a(l lVar, t tVar, b.a aVar, f fVar, g gVar, an anVar);

    @Override // kotlin.l.b.a.b.b.b
    public /* synthetic */ b a(l lVar, w wVar, ba baVar, b.a aVar) {
        return b(lVar, wVar, baVar, aVar, false);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected p(l lVar, t tVar, g gVar, f fVar, b.a aVar, an anVar) {
        super(lVar, gVar, fVar, anVar);
        if (lVar == null) {
            atM(0);
        }
        if (gVar == null) {
            atM(1);
        }
        if (fVar == null) {
            atM(2);
        }
        if (aVar == null) {
            atM(3);
        }
        if (anVar == null) {
            atM(4);
        }
        this.TkL = az.ThY;
        this.TkM = false;
        this.TkN = false;
        this.Tkp = false;
        this.TkO = false;
        this.TkP = false;
        this.TkQ = false;
        this.TkR = false;
        this.TkS = false;
        this.TkT = false;
        this.TkU = false;
        this.TkV = true;
        this.TkW = false;
        this.TkX = null;
        this.TkY = null;
        this.Tlb = null;
        this.Tlc = null;
        this.TkZ = tVar == null ? this : tVar;
        this.Tla = aVar;
    }

    public p a(ak akVar, ak akVar2, List<? extends as> list, List<av> list2, ab abVar, w wVar, ba baVar) {
        if (list == null) {
            atM(5);
        }
        if (list2 == null) {
            atM(6);
        }
        if (baVar == null) {
            atM(7);
        }
        this.Thx = j.p(list);
        this.TkH = j.p(list2);
        this.TkI = abVar;
        this.Tkq = wVar;
        this.TkL = baVar;
        this.TkJ = akVar;
        this.TkK = akVar2;
        for (int i2 = 0; i2 < list.size(); i2++) {
            as asVar = (as) list.get(i2);
            if (asVar.getIndex() != i2) {
                throw new IllegalStateException(asVar + " index is " + asVar.getIndex() + " but position is " + i2);
            }
        }
        for (int i3 = 0; i3 < list2.size(); i3++) {
            av avVar = list2.get(i3);
            if (avVar.getIndex() != i3 + 0) {
                throw new IllegalStateException(avVar + "index is " + avVar.getIndex() + " but position is " + i3);
            }
        }
        if (this == null) {
            atM(8);
        }
        return this;
    }

    public final void I(ab abVar) {
        if (abVar == null) {
            atM(10);
        }
        this.TkI = abVar;
    }

    public void EC(boolean z) {
        this.TkV = z;
    }

    public void ED(boolean z) {
        this.TkW = z;
    }

    @Override // kotlin.l.b.a.b.b.a
    public final ak hAr() {
        return this.TkJ;
    }

    @Override // kotlin.l.b.a.b.b.a
    public final ak hAs() {
        return this.TkK;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final w hzC() {
        w wVar = this.Tkq;
        if (wVar == null) {
            atM(13);
        }
        return wVar;
    }

    @Override // kotlin.l.b.a.b.b.v, kotlin.l.b.a.b.b.p
    public final ba hzE() {
        ba baVar = this.TkL;
        if (baVar == null) {
            atM(14);
        }
        return baVar;
    }

    @Override // kotlin.l.b.a.b.b.t
    public final boolean hAW() {
        if (this.TkM) {
            return true;
        }
        for (t tVar : hBT().hAy()) {
            if (tVar.hAW()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.l.b.a.b.b.t
    public final boolean hAX() {
        if (this.TkN) {
            return true;
        }
        for (t tVar : hBT().hAy()) {
            if (tVar.hAX()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.l.b.a.b.b.v
    public boolean isExternal() {
        return this.Tkp;
    }

    @Override // kotlin.l.b.a.b.b.t
    public boolean hzI() {
        return this.TkO;
    }

    @Override // kotlin.l.b.a.b.b.t
    public boolean hzX() {
        return this.TkP;
    }

    @Override // kotlin.l.b.a.b.b.t
    public boolean hAZ() {
        return this.TkU;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final boolean hzJ() {
        return this.TkQ;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final boolean hzK() {
        return this.TkR;
    }

    @Override // kotlin.l.b.a.b.b.a
    public <V> V a(a.AbstractC2276a<V> aVar) {
        if (this.Tlc == null) {
            return null;
        }
        return (V) this.Tlc.get(aVar);
    }

    @Override // kotlin.l.b.a.b.b.t
    public final boolean hAV() {
        return this.TkS;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Collection<? extends kotlin.l.b.a.b.b.b> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.l.b.a.b.b.b
    public void x(Collection<? extends b> collection) {
        if (collection == 0) {
            atM(15);
        }
        this.TkX = collection;
        for (t tVar : this.TkX) {
            if (tVar.hAY()) {
                this.TkT = true;
                return;
            }
        }
    }

    @Override // kotlin.l.b.a.b.b.a
    public final List<as> hAt() {
        List<as> list = this.Thx;
        if (list == null) {
            atM(16);
        }
        return list;
    }

    @Override // kotlin.l.b.a.b.b.a
    public final List<av> hAw() {
        List<av> list = this.TkH;
        if (list == null) {
            atM(17);
        }
        return list;
    }

    public boolean hCc() {
        return this.TkV;
    }

    @Override // kotlin.l.b.a.b.b.a
    public boolean hAx() {
        return this.TkW;
    }

    @Override // kotlin.l.b.a.b.b.a
    public ab hAu() {
        return this.TkI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.l.b.a.b.b.t] */
    /* JADX WARN: Type inference failed for: r1v3 */
    @Override // kotlin.l.b.a.b.b.t
    /* renamed from: hAT */
    public t hBT() {
        t tVar = this.TkZ;
        ?? r1 = this;
        if (tVar != this) {
            r1 = this.TkZ.hAT();
        }
        if (r1 == 0) {
            atM(18);
        }
        return r1;
    }

    @Override // kotlin.l.b.a.b.b.b
    public final b.a hAA() {
        b.a aVar = this.Tla;
        if (aVar == null) {
            atM(19);
        }
        return aVar;
    }

    @Override // kotlin.l.b.a.b.b.t
    public final boolean hAY() {
        return this.TkT;
    }

    public class a implements t.a<t> {
        protected f TjT;
        protected ak TkK;
        boolean TkS;
        boolean TkT;
        protected t TkZ;
        protected b.a Tla;
        Map<a.AbstractC2276a<?>, Object> Tlc;
        final /* synthetic */ p Tle;
        protected ay Tlg;
        protected l Tlh;
        protected w Tli;
        protected ba Tlj;
        protected List<av> Tlk;
        protected ak Tll;
        protected ab Tlm;
        protected boolean Tln;
        protected boolean Tlo;
        protected boolean Tlp;
        protected boolean Tlq;
        List<as> Tlr;
        g Tls;
        public Boolean Tlt;
        protected boolean Tlu;

        private static /* synthetic */ void atM(int i2) {
            String str;
            int i3;
            Throwable illegalStateException;
            AppMethodBeat.i(57116);
            switch (i2) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i2) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    i3 = 2;
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    i3 = 3;
                    break;
            }
            Object[] objArr = new Object[i3];
            switch (i2) {
                case 1:
                    objArr[0] = "newOwner";
                    break;
                case 2:
                    objArr[0] = "newModality";
                    break;
                case 3:
                    objArr[0] = "newVisibility";
                    break;
                case 4:
                case 13:
                    objArr[0] = "kind";
                    break;
                case 5:
                    objArr[0] = "newValueParameterDescriptors";
                    break;
                case 6:
                    objArr[0] = "newReturnType";
                    break;
                case 7:
                    objArr[0] = "owner";
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 9:
                    objArr[0] = "modality";
                    break;
                case 11:
                    objArr[0] = "visibility";
                    break;
                case 16:
                    objArr[0] = "name";
                    break;
                case 18:
                case 20:
                    objArr[0] = "parameters";
                    break;
                case 22:
                    objArr[0] = "type";
                    break;
                case 32:
                    objArr[0] = "additionalAnnotations";
                    break;
                case 34:
                default:
                    objArr[0] = "substitution";
                    break;
                case 36:
                    objArr[0] = "userDataKey";
                    break;
            }
            switch (i2) {
                case 8:
                    objArr[1] = "setOwner";
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 10:
                    objArr[1] = "setModality";
                    break;
                case 12:
                    objArr[1] = "setVisibility";
                    break;
                case 14:
                    objArr[1] = "setKind";
                    break;
                case 15:
                    objArr[1] = "setCopyOverrides";
                    break;
                case 17:
                    objArr[1] = "setName";
                    break;
                case 19:
                    objArr[1] = "setValueParameters";
                    break;
                case 21:
                    objArr[1] = "setTypeParameters";
                    break;
                case 23:
                    objArr[1] = "setReturnType";
                    break;
                case 24:
                    objArr[1] = "setExtensionReceiverParameter";
                    break;
                case 25:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case 26:
                    objArr[1] = "setOriginal";
                    break;
                case 27:
                    objArr[1] = "setSignatureChange";
                    break;
                case 28:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 29:
                    objArr[1] = "setDropOriginalInContainingParts";
                    break;
                case 30:
                    objArr[1] = "setHiddenToOvercomeSignatureClash";
                    break;
                case 31:
                    objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                case 33:
                    objArr[1] = "setAdditionalAnnotations";
                    break;
                case 35:
                    objArr[1] = "setSubstitution";
                    break;
                case 37:
                    objArr[1] = "putUserData";
                    break;
                case 38:
                    objArr[1] = "getSubstitution";
                    break;
                case 39:
                    objArr[1] = "setJustForTypeSubstitution";
                    break;
            }
            switch (i2) {
                case 7:
                    objArr[2] = "setOwner";
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    break;
                case 9:
                    objArr[2] = "setModality";
                    break;
                case 11:
                    objArr[2] = "setVisibility";
                    break;
                case 13:
                    objArr[2] = "setKind";
                    break;
                case 16:
                    objArr[2] = "setName";
                    break;
                case 18:
                    objArr[2] = "setValueParameters";
                    break;
                case 20:
                    objArr[2] = "setTypeParameters";
                    break;
                case 22:
                    objArr[2] = "setReturnType";
                    break;
                case 32:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                case 34:
                    objArr[2] = "setSubstitution";
                    break;
                case 36:
                    objArr[2] = "putUserData";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i2) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    illegalStateException = new IllegalStateException(format);
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    illegalStateException = new IllegalArgumentException(format);
                    break;
            }
            AppMethodBeat.o(57116);
            throw illegalStateException;
        }

        /* Return type fixed from 'kotlin.l.b.a.b.b.t$a' to match base method */
        @Override // kotlin.l.b.a.b.b.t.a
        public final /* synthetic */ t.a<t> G(ab abVar) {
            AppMethodBeat.i(57109);
            if (abVar == null) {
                atM(22);
            }
            this.Tlm = abVar;
            AppMethodBeat.o(57109);
            return this;
        }

        /* Return type fixed from 'kotlin.l.b.a.b.b.t$a' to match base method */
        @Override // kotlin.l.b.a.b.b.t.a
        public final /* synthetic */ t.a<t> a(g gVar) {
            AppMethodBeat.i(57107);
            if (gVar == null) {
                atM(32);
            }
            this.Tls = gVar;
            AppMethodBeat.o(57107);
            return this;
        }

        /* Return type fixed from 'kotlin.l.b.a.b.b.t$a' to match base method */
        @Override // kotlin.l.b.a.b.b.t.a
        public final /* synthetic */ t.a<t> a(b.a aVar) {
            AppMethodBeat.i(57112);
            if (aVar == null) {
                atM(13);
            }
            this.Tla = aVar;
            AppMethodBeat.o(57112);
            return this;
        }

        /* Return type fixed from 'kotlin.l.b.a.b.b.t$a' to match base method */
        @Override // kotlin.l.b.a.b.b.t.a
        public final /* synthetic */ t.a<t> a(ba baVar) {
            AppMethodBeat.i(57113);
            if (baVar == null) {
                atM(11);
            }
            this.Tlj = baVar;
            AppMethodBeat.o(57113);
            return this;
        }

        /* Return type fixed from 'kotlin.l.b.a.b.b.t$a' to match base method */
        @Override // kotlin.l.b.a.b.b.t.a
        public final /* synthetic */ t.a<t> a(w wVar) {
            AppMethodBeat.i(57114);
            if (wVar == null) {
                atM(9);
            }
            this.Tli = wVar;
            AppMethodBeat.o(57114);
            return this;
        }

        /* Return type fixed from 'kotlin.l.b.a.b.b.t$a' to match base method */
        @Override // kotlin.l.b.a.b.b.t.a
        public final /* synthetic */ t.a<t> b(ay ayVar) {
            AppMethodBeat.i(57106);
            if (ayVar == null) {
                atM(34);
            }
            this.Tlg = ayVar;
            AppMethodBeat.o(57106);
            return this;
        }

        /* Return type fixed from 'kotlin.l.b.a.b.b.t$a' to match base method */
        @Override // kotlin.l.b.a.b.b.t.a
        public final /* synthetic */ t.a<t> d(b bVar) {
            AppMethodBeat.i(57108);
            a f2 = f(bVar);
            AppMethodBeat.o(57108);
            return f2;
        }

        /* Return type fixed from 'kotlin.l.b.a.b.b.t$a' to match base method */
        @Override // kotlin.l.b.a.b.b.t.a
        public final /* synthetic */ t.a<t> d(f fVar) {
            AppMethodBeat.i(57111);
            if (fVar == null) {
                atM(16);
            }
            this.TjT = fVar;
            AppMethodBeat.o(57111);
            return this;
        }

        /* Return type fixed from 'kotlin.l.b.a.b.b.t$a' to match base method */
        @Override // kotlin.l.b.a.b.b.t.a
        public final /* synthetic */ t.a<t> h(l lVar) {
            AppMethodBeat.i(57115);
            if (lVar == null) {
                atM(7);
            }
            this.Tlh = lVar;
            AppMethodBeat.o(57115);
            return this;
        }

        /* Return type fixed from 'kotlin.l.b.a.b.b.t$a' to match base method */
        @Override // kotlin.l.b.a.b.b.t.a
        public final /* synthetic */ t.a<t> hBc() {
            AppMethodBeat.i(186244);
            a hCd = hCd();
            AppMethodBeat.o(186244);
            return hCd;
        }

        /* Return type fixed from 'kotlin.l.b.a.b.b.t$a' to match base method */
        @Override // kotlin.l.b.a.b.b.t.a
        public final /* synthetic */ t.a<t> kz(List list) {
            AppMethodBeat.i(57110);
            a kB = kB(list);
            AppMethodBeat.o(57110);
            return kB;
        }

        /* JADX WARN: Incorrect types in method signature: (Lkotlin/l/b/a/b/m/ay;Lkotlin/l/b/a/b/b/l;Lkotlin/l/b/a/b/b/w;Lkotlin/l/b/a/b/b/ba;Lkotlin/l/b/a/b/b/b$a;Ljava/util/List<Lkotlin/l/b/a/b/b/av;>;Lkotlin/l/b/a/b/b/ak;Lkotlin/l/b/a/b/m/ab;Lkotlin/l/b/a/b/f/f;)V */
        public a(p pVar, ay ayVar, l lVar, w wVar, ba baVar, b.a aVar, List list, ak akVar, ab abVar) {
            if (ayVar == null) {
                atM(0);
            }
            if (lVar == null) {
                atM(1);
            }
            if (wVar == null) {
                atM(2);
            }
            if (baVar == null) {
                atM(3);
            }
            if (aVar == null) {
                atM(4);
            }
            if (list == null) {
                atM(5);
            }
            if (abVar == null) {
                atM(6);
            }
            this.Tle = pVar;
            AppMethodBeat.i(57101);
            this.TkZ = null;
            this.TkK = this.Tle.TkK;
            this.Tln = true;
            this.Tlo = false;
            this.Tlp = false;
            this.Tlq = false;
            this.TkS = this.Tle.TkS;
            this.Tlr = null;
            this.Tls = null;
            this.TkT = this.Tle.TkT;
            this.Tlc = new LinkedHashMap();
            this.Tlt = null;
            this.Tlu = false;
            this.Tlg = ayVar;
            this.Tlh = lVar;
            this.Tli = wVar;
            this.Tlj = baVar;
            this.Tla = aVar;
            this.Tlk = list;
            this.Tll = akVar;
            this.Tlm = abVar;
            this.TjT = null;
            AppMethodBeat.o(57101);
        }

        public final a kB(List<av> list) {
            AppMethodBeat.i(57102);
            if (list == null) {
                atM(18);
            }
            this.Tlk = list;
            if (this == null) {
                atM(19);
            }
            AppMethodBeat.o(57102);
            return this;
        }

        public final a f(b bVar) {
            AppMethodBeat.i(57103);
            this.TkZ = (t) bVar;
            if (this == null) {
                atM(26);
            }
            AppMethodBeat.o(57103);
            return this;
        }

        public final a hCd() {
            AppMethodBeat.i(186243);
            this.Tlp = true;
            if (this == null) {
                atM(28);
            }
            AppMethodBeat.o(186243);
            return this;
        }

        @Override // kotlin.l.b.a.b.b.t.a
        public final t hBg() {
            AppMethodBeat.i(57104);
            t a2 = this.Tle.a(this);
            AppMethodBeat.o(57104);
            return a2;
        }

        public final a hCe() {
            AppMethodBeat.i(57105);
            this.Tlu = true;
            if (this == null) {
                atM(39);
            }
            AppMethodBeat.o(57105);
            return this;
        }

        /* Return type fixed from 'kotlin.l.b.a.b.b.t$a' to match base method */
        @Override // kotlin.l.b.a.b.b.t.a
        public final /* bridge */ /* synthetic */ t.a<t> hBf() {
            this.TkT = true;
            return this;
        }

        /* Return type fixed from 'kotlin.l.b.a.b.b.t$a' to match base method */
        @Override // kotlin.l.b.a.b.b.t.a
        public final /* bridge */ /* synthetic */ t.a<t> hBe() {
            this.TkS = true;
            return this;
        }

        /* Return type fixed from 'kotlin.l.b.a.b.b.t$a' to match base method */
        @Override // kotlin.l.b.a.b.b.t.a
        public final /* bridge */ /* synthetic */ t.a<t> hBd() {
            this.Tlq = true;
            return this;
        }

        /* Return type fixed from 'kotlin.l.b.a.b.b.t$a' to match base method */
        @Override // kotlin.l.b.a.b.b.t.a
        public final /* bridge */ /* synthetic */ t.a<t> hBb() {
            this.Tlo = true;
            return this;
        }

        /* Return type fixed from 'kotlin.l.b.a.b.b.t$a' to match base method */
        @Override // kotlin.l.b.a.b.b.t.a
        public final /* bridge */ /* synthetic */ t.a<t> b(ak akVar) {
            this.TkK = akVar;
            return this;
        }

        /* Return type fixed from 'kotlin.l.b.a.b.b.t$a' to match base method */
        @Override // kotlin.l.b.a.b.b.t.a
        public final /* bridge */ /* synthetic */ t.a<t> a(ak akVar) {
            this.Tll = akVar;
            return this;
        }

        /* Return type fixed from 'kotlin.l.b.a.b.b.t$a' to match base method */
        @Override // kotlin.l.b.a.b.b.t.a
        public final /* bridge */ /* synthetic */ t.a<t> EB(boolean z) {
            this.Tln = z;
            return this;
        }
    }

    @Override // kotlin.l.b.a.b.b.t
    public t.a<? extends t> hBa() {
        return h(kotlin.l.b.a.b.m.ba.TOF);
    }

    /* access modifiers changed from: protected */
    public final a h(kotlin.l.b.a.b.m.ba baVar) {
        if (baVar == null) {
            atM(22);
        }
        return new a(this, baVar.hLK(), hzx(), hzC(), hzE(), hAA(), hAw(), this.TkJ, hAu());
    }

    /* access modifiers changed from: protected */
    public t a(a aVar) {
        an anVar;
        List<as> list;
        ad adVar;
        ak akVar;
        ab c2;
        t tVar;
        if (aVar == null) {
            atM(23);
        }
        boolean[] zArr = new boolean[1];
        g a2 = aVar.Tls != null ? i.a(hzL(), aVar.Tls) : hzL();
        l lVar = aVar.Tlh;
        t tVar2 = aVar.TkZ;
        b.a aVar2 = aVar.Tla;
        f fVar = aVar.TjT;
        boolean z = aVar.Tlp;
        t tVar3 = aVar.TkZ;
        if (z) {
            if (tVar3 == null) {
                tVar3 = hBT();
            }
            anVar = tVar3.hzM();
        } else {
            anVar = an.ThK;
        }
        if (anVar == null) {
            atM(25);
        }
        p a3 = a(lVar, tVar2, aVar2, fVar, a2, anVar);
        if (aVar.Tlr == null) {
            list = hAt();
        } else {
            list = aVar.Tlr;
        }
        zArr[0] = (!list.isEmpty()) | zArr[0];
        ArrayList arrayList = new ArrayList(list.size());
        final kotlin.l.b.a.b.m.ba a4 = kotlin.l.b.a.b.m.p.a(list, aVar.Tlg, a3, arrayList, zArr);
        if (a4 == null) {
            return null;
        }
        if (aVar.Tll != null) {
            ab c3 = a4.c(aVar.Tll.hBy(), bh.IN_VARIANCE);
            if (c3 == null) {
                return null;
            }
            ad adVar2 = new ad(a3, new kotlin.l.b.a.b.j.f.a.b(a3, c3, aVar.Tll.hBt()), aVar.Tll.hzL());
            zArr[0] = (c3 != aVar.Tll.hBy()) | zArr[0];
            adVar = adVar2;
        } else {
            adVar = null;
        }
        if (aVar.TkK != null) {
            ak e2 = aVar.TkK.e(a4);
            if (e2 == null) {
                return null;
            }
            zArr[0] = (e2 != aVar.TkK) | zArr[0];
            akVar = e2;
        } else {
            akVar = null;
        }
        List<av> a5 = a(a3, aVar.Tlk, a4, aVar.Tlq, aVar.Tlp, zArr);
        if (a5 == null || (c2 = a4.c(aVar.Tlm, bh.OUT_VARIANCE)) == null) {
            return null;
        }
        zArr[0] = (c2 != aVar.Tlm) | zArr[0];
        if (!zArr[0] && aVar.Tlu) {
            return this;
        }
        a3.a(adVar, akVar, arrayList, a5, c2, aVar.Tli, aVar.Tlj);
        a3.TkM = this.TkM;
        a3.TkN = this.TkN;
        a3.Tkp = this.Tkp;
        a3.TkO = this.TkO;
        a3.TkP = this.TkP;
        a3.TkU = this.TkU;
        a3.TkQ = this.TkQ;
        a3.TkR = this.TkR;
        a3.EC(this.TkV);
        a3.TkS = aVar.TkS;
        a3.TkT = aVar.TkT;
        a3.ED(aVar.Tlt != null ? aVar.Tlt.booleanValue() : this.TkW);
        if (!aVar.Tlc.isEmpty() || this.Tlc != null) {
            Map<a.AbstractC2276a<?>, Object> map = aVar.Tlc;
            if (this.Tlc != null) {
                for (Map.Entry<a.AbstractC2276a<?>, Object> entry : this.Tlc.entrySet()) {
                    if (!map.containsKey(entry.getKey())) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (map.size() == 1) {
                a3.Tlc = Collections.singletonMap(map.keySet().iterator().next(), map.values().iterator().next());
            } else {
                a3.Tlc = map;
            }
        }
        if (aVar.Tlo || this.Tlb != null) {
            if (this.Tlb != null) {
                tVar = this.Tlb;
            } else {
                tVar = this;
            }
            a3.Tlb = tVar.c(a4);
        }
        if (aVar.Tln && !hBT().hAy().isEmpty()) {
            if (aVar.Tlg.isEmpty()) {
                kotlin.g.a.a<Collection<t>> aVar3 = this.TkY;
                if (aVar3 != null) {
                    a3.TkY = aVar3;
                } else {
                    a3.x(hAy());
                }
            } else {
                a3.TkY = new kotlin.g.a.a<Collection<t>>() {
                    /* class kotlin.l.b.a.b.b.c.p.AnonymousClass1 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ Collection<t> invoke() {
                        AppMethodBeat.i(57100);
                        h hVar = new h();
                        for (t tVar : p.this.hAy()) {
                            hVar.add(tVar.c(a4));
                        }
                        AppMethodBeat.o(57100);
                        return hVar;
                    }
                };
            }
        }
        return a3;
    }

    public t b(l lVar, w wVar, ba baVar, b.a aVar, boolean z) {
        t hBg = hBa().h(lVar).a(wVar).a(baVar).a(aVar).EB(z).hBg();
        if (hBg == null) {
            atM(24);
        }
        return hBg;
    }

    @Override // kotlin.l.b.a.b.b.l
    public <R, D> R a(n<R, D> nVar, D d2) {
        return nVar.a(this, d2);
    }

    public static List<av> a(t tVar, List<av> list, kotlin.l.b.a.b.m.ba baVar, boolean z, boolean z2, boolean[] zArr) {
        if (list == null) {
            atM(28);
        }
        if (baVar == null) {
            atM(29);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (av avVar : list) {
            ab c2 = baVar.c(avVar.hBy(), bh.IN_VARIANCE);
            ab hBB = avVar.hBB();
            ab c3 = hBB == null ? null : baVar.c(hBB, bh.IN_VARIANCE);
            if (c2 == null) {
                return null;
            }
            if (!((c2 == avVar.hBy() && hBB == c3) || zArr == null)) {
                zArr[0] = true;
            }
            AnonymousClass2 r12 = null;
            if (avVar instanceof aj.b) {
                final List<ax> hCz = ((aj.b) avVar).hCz();
                r12 = new kotlin.g.a.a<List<ax>>() {
                    /* class kotlin.l.b.a.b.b.c.p.AnonymousClass2 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* bridge */ /* synthetic */ List<ax> invoke() {
                        return hCz;
                    }
                };
            }
            arrayList.add(aj.a(tVar, z ? null : avVar, avVar.getIndex(), avVar.hzL(), avVar.hAH(), c2, avVar.hBA(), avVar.hBD(), avVar.hBE(), c3, z2 ? avVar.hzM() : an.ThK, r12));
        }
        return arrayList;
    }

    @Override // kotlin.l.b.a.b.b.t
    public final t hAU() {
        return this.Tlb;
    }

    public final <V> void a(a.AbstractC2276a<V> aVar, Object obj) {
        if (this.Tlc == null) {
            this.Tlc = new LinkedHashMap();
        }
        this.Tlc.put(aVar, obj);
    }

    @Override // kotlin.l.b.a.b.b.b, kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.t
    public Collection<? extends t> hAy() {
        kotlin.g.a.a<Collection<t>> aVar = this.TkY;
        if (aVar != null) {
            this.TkX = aVar.invoke();
            this.TkY = null;
        }
        Collection<? extends t> emptyList = this.TkX != null ? this.TkX : Collections.emptyList();
        if (emptyList == null) {
            atM(12);
        }
        return emptyList;
    }

    @Override // kotlin.l.b.a.b.b.t
    /* renamed from: c */
    public t f(kotlin.l.b.a.b.m.ba baVar) {
        if (baVar == null) {
            atM(20);
        }
        return baVar.Tlg.isEmpty() ? this : h(baVar).f(hBT()).hCd().hCe().hBg();
    }
}
