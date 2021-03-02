package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.Set;
import kotlin.a.x;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.v;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.i.b;
import kotlin.l.b.a.b.i.c;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.k;

public final class j implements i {
    static final /* synthetic */ k[] cLI = {aa.a(new v(aa.bp(j.class), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), aa.a(new v(aa.bp(j.class), "withDefinedIn", "getWithDefinedIn()Z")), aa.a(new v(aa.bp(j.class), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), aa.a(new v(aa.bp(j.class), "modifiers", "getModifiers()Ljava/util/Set;")), aa.a(new v(aa.bp(j.class), "startFromName", "getStartFromName()Z")), aa.a(new v(aa.bp(j.class), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), aa.a(new v(aa.bp(j.class), "debugMode", "getDebugMode()Z")), aa.a(new v(aa.bp(j.class), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), aa.a(new v(aa.bp(j.class), "verbose", "getVerbose()Z")), aa.a(new v(aa.bp(j.class), "unitReturnType", "getUnitReturnType()Z")), aa.a(new v(aa.bp(j.class), "withoutReturnType", "getWithoutReturnType()Z")), aa.a(new v(aa.bp(j.class), "enhancedTypes", "getEnhancedTypes()Z")), aa.a(new v(aa.bp(j.class), "normalizedVisibilities", "getNormalizedVisibilities()Z")), aa.a(new v(aa.bp(j.class), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), aa.a(new v(aa.bp(j.class), "renderDefaultModality", "getRenderDefaultModality()Z")), aa.a(new v(aa.bp(j.class), "renderConstructorDelegation", "getRenderConstructorDelegation()Z")), aa.a(new v(aa.bp(j.class), "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z")), aa.a(new v(aa.bp(j.class), "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z")), aa.a(new v(aa.bp(j.class), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), aa.a(new v(aa.bp(j.class), "includePropertyConstant", "getIncludePropertyConstant()Z")), aa.a(new v(aa.bp(j.class), "withoutTypeParameters", "getWithoutTypeParameters()Z")), aa.a(new v(aa.bp(j.class), "withoutSuperTypes", "getWithoutSuperTypes()Z")), aa.a(new v(aa.bp(j.class), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), aa.a(new v(aa.bp(j.class), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), aa.a(new v(aa.bp(j.class), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), aa.a(new v(aa.bp(j.class), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), aa.a(new v(aa.bp(j.class), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), aa.a(new v(aa.bp(j.class), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), aa.a(new v(aa.bp(j.class), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), aa.a(new v(aa.bp(j.class), "receiverAfterName", "getReceiverAfterName()Z")), aa.a(new v(aa.bp(j.class), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), aa.a(new v(aa.bp(j.class), "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;")), aa.a(new v(aa.bp(j.class), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), aa.a(new v(aa.bp(j.class), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), aa.a(new v(aa.bp(j.class), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), aa.a(new v(aa.bp(j.class), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), aa.a(new v(aa.bp(j.class), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), aa.a(new v(aa.bp(j.class), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), aa.a(new v(aa.bp(j.class), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), aa.a(new v(aa.bp(j.class), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), aa.a(new v(aa.bp(j.class), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), aa.a(new v(aa.bp(j.class), "renderTypeExpansions", "getRenderTypeExpansions()Z")), aa.a(new v(aa.bp(j.class), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), aa.a(new v(aa.bp(j.class), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), aa.a(new v(aa.bp(j.class), "renderFunctionContracts", "getRenderFunctionContracts()Z")), aa.a(new v(aa.bp(j.class), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), aa.a(new v(aa.bp(j.class), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z")), aa.a(new v(aa.bp(j.class), "informativeErrorType", "getInformativeErrorType()Z"))};
    private final kotlin.i.c TFV = fy(b.c.TFa);
    final kotlin.i.c TFW = fy(Boolean.TRUE);
    final kotlin.i.c TFX = fy(Boolean.TRUE);
    private final kotlin.i.c TFY = fy(h.TFS);
    private final kotlin.i.c TFZ = fy(Boolean.FALSE);
    private final kotlin.i.c TGA = fy(o.DEBUG);
    final kotlin.i.c TGB = fy(Boolean.FALSE);
    final kotlin.i.c TGC = fy(Boolean.FALSE);
    final kotlin.i.c TGD = fy(x.SXt);
    private final kotlin.i.c TGE;
    final kotlin.i.c TGF;
    private final kotlin.i.c TGG;
    private final kotlin.i.c TGH;
    final kotlin.i.c TGI;
    private final kotlin.i.c TGJ;
    private final kotlin.i.c TGK;
    private final kotlin.i.c TGL;
    private final kotlin.i.c TGM;
    private final kotlin.i.c TGN;
    private final kotlin.i.c TGO;
    private final kotlin.i.c TGP;
    private final kotlin.i.c TGQ;
    private final kotlin.i.c TGa = fy(Boolean.FALSE);
    private final kotlin.i.c TGb = fy(Boolean.FALSE);
    final kotlin.i.c TGc = fy(Boolean.FALSE);
    private final kotlin.i.c TGd = fy(Boolean.FALSE);
    final kotlin.i.c TGe = fy(Boolean.TRUE);
    final kotlin.i.c TGf = fy(Boolean.FALSE);
    private final kotlin.i.c TGg = fy(Boolean.FALSE);
    final kotlin.i.c TGh = fy(Boolean.FALSE);
    private final kotlin.i.c TGi = fy(Boolean.TRUE);
    final kotlin.i.c TGj = fy(Boolean.TRUE);
    final kotlin.i.c TGk = fy(Boolean.FALSE);
    private final kotlin.i.c TGl = fy(Boolean.FALSE);
    private final kotlin.i.c TGm = fy(Boolean.FALSE);
    private final kotlin.i.c TGn = fy(Boolean.FALSE);
    private final kotlin.i.c TGo = fy(Boolean.FALSE);
    private final kotlin.i.c TGp = fy(Boolean.FALSE);
    final kotlin.i.c TGq = fy(Boolean.FALSE);
    final kotlin.i.c TGr = fy(c.TGT);
    private final kotlin.i.c TGs = fy(a.TGR);
    private final kotlin.i.c TGt = fy(Boolean.TRUE);
    private final kotlin.i.c TGu = fy(m.RENDER_OPEN);
    private final kotlin.i.c TGv = fy(c.l.a.TFw);
    private final kotlin.i.c TGw = fy(p.THj);
    final kotlin.i.c TGx = fy(n.THb);
    final kotlin.i.c TGy = fy(Boolean.FALSE);
    final kotlin.i.c TGz = fy(Boolean.FALSE);
    boolean aHY;

    static {
        AppMethodBeat.i(59810);
        AppMethodBeat.o(59810);
    }

    @Override // kotlin.l.b.a.b.i.i
    public final void D(Set<kotlin.l.b.a.b.f.b> set) {
        AppMethodBeat.i(59845);
        p.h(set, "<set-?>");
        this.TGE.a(cLI[35], set);
        AppMethodBeat.o(59845);
    }

    @Override // kotlin.l.b.a.b.i.i
    public final void E(Set<? extends h> set) {
        AppMethodBeat.i(59817);
        p.h(set, "<set-?>");
        this.TFY.a(cLI[3], set);
        AppMethodBeat.o(59817);
    }

    @Override // kotlin.l.b.a.b.i.i
    public final void EK(boolean z) {
        AppMethodBeat.i(59841);
        this.TGy.a(cLI[29], Boolean.valueOf(z));
        AppMethodBeat.o(59841);
    }

    @Override // kotlin.l.b.a.b.i.i
    public final void EL(boolean z) {
        AppMethodBeat.i(59842);
        this.TGz.a(cLI[30], Boolean.valueOf(z));
        AppMethodBeat.o(59842);
    }

    @Override // kotlin.l.b.a.b.i.i
    public final void EM(boolean z) {
        AppMethodBeat.i(59819);
        this.TFZ.a(cLI[4], Boolean.valueOf(z));
        AppMethodBeat.o(59819);
    }

    @Override // kotlin.l.b.a.b.i.i
    public final void EN(boolean z) {
        AppMethodBeat.i(59824);
        this.TGd.a(cLI[8], Boolean.valueOf(z));
        AppMethodBeat.o(59824);
    }

    @Override // kotlin.l.b.a.b.i.i
    public final void EO(boolean z) {
        AppMethodBeat.i(59815);
        this.TFW.a(cLI[1], Boolean.valueOf(z));
        AppMethodBeat.o(59815);
    }

    @Override // kotlin.l.b.a.b.i.i
    public final void EP(boolean z) {
        AppMethodBeat.i(59833);
        this.TGq.a(cLI[21], Boolean.valueOf(z));
        AppMethodBeat.o(59833);
    }

    @Override // kotlin.l.b.a.b.i.i
    public final void EQ(boolean z) {
        AppMethodBeat.i(59832);
        this.TGp.a(cLI[20], Boolean.valueOf(z));
        AppMethodBeat.o(59832);
    }

    @Override // kotlin.l.b.a.b.i.i
    public final void a(a aVar) {
        AppMethodBeat.i(59847);
        p.h(aVar, "<set-?>");
        this.TGG.a(cLI[37], aVar);
        AppMethodBeat.o(59847);
    }

    @Override // kotlin.l.b.a.b.i.i
    public final void a(b bVar) {
        AppMethodBeat.i(59814);
        p.h(bVar, "<set-?>");
        this.TFV.a(cLI[0], bVar);
        AppMethodBeat.o(59814);
    }

    @Override // kotlin.l.b.a.b.i.i
    public final void a(n nVar) {
        AppMethodBeat.i(59840);
        p.h(nVar, "<set-?>");
        this.TGx.a(cLI[28], nVar);
        AppMethodBeat.o(59840);
    }

    @Override // kotlin.l.b.a.b.i.i
    public final void a(p pVar) {
        AppMethodBeat.i(59839);
        p.h(pVar, "<set-?>");
        this.TGw.a(cLI[27], pVar);
        AppMethodBeat.o(59839);
    }

    @Override // kotlin.l.b.a.b.i.i
    public final a hJV() {
        AppMethodBeat.i(59846);
        a aVar = (a) this.TGG.a(cLI[37]);
        AppMethodBeat.o(59846);
        return aVar;
    }

    @Override // kotlin.l.b.a.b.i.i
    public final boolean hJW() {
        AppMethodBeat.i(59821);
        boolean booleanValue = ((Boolean) this.TGb.a(cLI[6])).booleanValue();
        AppMethodBeat.o(59821);
        return booleanValue;
    }

    @Override // kotlin.l.b.a.b.i.i
    public final boolean hJX() {
        AppMethodBeat.i(59825);
        boolean booleanValue = ((Boolean) this.TGg.a(cLI[11])).booleanValue();
        AppMethodBeat.o(59825);
        return booleanValue;
    }

    @Override // kotlin.l.b.a.b.i.i
    public final Set<kotlin.l.b.a.b.f.b> hJY() {
        AppMethodBeat.i(59844);
        Set<kotlin.l.b.a.b.f.b> set = (Set) this.TGE.a(cLI[35]);
        AppMethodBeat.o(59844);
        return set;
    }

    public final b hJZ() {
        AppMethodBeat.i(59813);
        b bVar = (b) this.TFV.a(cLI[0]);
        AppMethodBeat.o(59813);
        return bVar;
    }

    public final Set<h> hKa() {
        AppMethodBeat.i(59816);
        Set<h> set = (Set) this.TFY.a(cLI[3]);
        AppMethodBeat.o(59816);
        return set;
    }

    public final boolean hKb() {
        AppMethodBeat.i(59818);
        boolean booleanValue = ((Boolean) this.TFZ.a(cLI[4])).booleanValue();
        AppMethodBeat.o(59818);
        return booleanValue;
    }

    public final boolean hKc() {
        AppMethodBeat.i(59820);
        boolean booleanValue = ((Boolean) this.TGa.a(cLI[5])).booleanValue();
        AppMethodBeat.o(59820);
        return booleanValue;
    }

    public final boolean hKd() {
        AppMethodBeat.i(59823);
        boolean booleanValue = ((Boolean) this.TGd.a(cLI[8])).booleanValue();
        AppMethodBeat.o(59823);
        return booleanValue;
    }

    public final boolean hKe() {
        AppMethodBeat.i(59826);
        boolean booleanValue = ((Boolean) this.TGi.a(cLI[13])).booleanValue();
        AppMethodBeat.o(59826);
        return booleanValue;
    }

    public final boolean hKf() {
        AppMethodBeat.i(59827);
        boolean booleanValue = ((Boolean) this.TGl.a(cLI[16])).booleanValue();
        AppMethodBeat.o(59827);
        return booleanValue;
    }

    public final boolean hKg() {
        AppMethodBeat.i(59828);
        boolean booleanValue = ((Boolean) this.TGm.a(cLI[17])).booleanValue();
        AppMethodBeat.o(59828);
        return booleanValue;
    }

    public final boolean hKh() {
        AppMethodBeat.i(59829);
        boolean booleanValue = ((Boolean) this.TGn.a(cLI[18])).booleanValue();
        AppMethodBeat.o(59829);
        return booleanValue;
    }

    public final boolean hKi() {
        AppMethodBeat.i(59830);
        boolean booleanValue = ((Boolean) this.TGo.a(cLI[19])).booleanValue();
        AppMethodBeat.o(59830);
        return booleanValue;
    }

    public final boolean hKj() {
        AppMethodBeat.i(59831);
        boolean booleanValue = ((Boolean) this.TGp.a(cLI[20])).booleanValue();
        AppMethodBeat.o(59831);
        return booleanValue;
    }

    public final kotlin.g.a.b<av, String> hKk() {
        AppMethodBeat.i(59834);
        kotlin.g.a.b<av, String> bVar = (kotlin.g.a.b) this.TGs.a(cLI[23]);
        AppMethodBeat.o(59834);
        return bVar;
    }

    public final boolean hKl() {
        AppMethodBeat.i(59835);
        boolean booleanValue = ((Boolean) this.TGt.a(cLI[24])).booleanValue();
        AppMethodBeat.o(59835);
        return booleanValue;
    }

    public final m hKm() {
        AppMethodBeat.i(59836);
        m mVar = (m) this.TGu.a(cLI[25]);
        AppMethodBeat.o(59836);
        return mVar;
    }

    public final c.l hKn() {
        AppMethodBeat.i(59837);
        c.l lVar = (c.l) this.TGv.a(cLI[26]);
        AppMethodBeat.o(59837);
        return lVar;
    }

    public final p hKo() {
        AppMethodBeat.i(59838);
        p pVar = (p) this.TGw.a(cLI[27]);
        AppMethodBeat.o(59838);
        return pVar;
    }

    public final o hKp() {
        AppMethodBeat.i(59843);
        o oVar = (o) this.TGA.a(cLI[31]);
        AppMethodBeat.o(59843);
        return oVar;
    }

    public final boolean hKq() {
        AppMethodBeat.i(59848);
        boolean booleanValue = ((Boolean) this.TGH.a(cLI[38])).booleanValue();
        AppMethodBeat.o(59848);
        return booleanValue;
    }

    public final boolean hKr() {
        AppMethodBeat.i(59849);
        boolean booleanValue = ((Boolean) this.TGJ.a(cLI[40])).booleanValue();
        AppMethodBeat.o(59849);
        return booleanValue;
    }

    public final boolean hKs() {
        AppMethodBeat.i(59850);
        boolean booleanValue = ((Boolean) this.TGK.a(cLI[41])).booleanValue();
        AppMethodBeat.o(59850);
        return booleanValue;
    }

    public final boolean hKt() {
        AppMethodBeat.i(59851);
        boolean booleanValue = ((Boolean) this.TGL.a(cLI[42])).booleanValue();
        AppMethodBeat.o(59851);
        return booleanValue;
    }

    public final boolean hKu() {
        AppMethodBeat.i(59852);
        boolean booleanValue = ((Boolean) this.TGM.a(cLI[43])).booleanValue();
        AppMethodBeat.o(59852);
        return booleanValue;
    }

    public final boolean hKv() {
        AppMethodBeat.i(59853);
        boolean booleanValue = ((Boolean) this.TGO.a(cLI[45])).booleanValue();
        AppMethodBeat.o(59853);
        return booleanValue;
    }

    public final boolean hKw() {
        AppMethodBeat.i(59854);
        boolean booleanValue = ((Boolean) this.TGP.a(cLI[46])).booleanValue();
        AppMethodBeat.o(59854);
        return booleanValue;
    }

    public final boolean hKx() {
        AppMethodBeat.i(186258);
        boolean booleanValue = ((Boolean) this.TGQ.a(cLI[47])).booleanValue();
        AppMethodBeat.o(186258);
        return booleanValue;
    }

    @Override // kotlin.l.b.a.b.i.i
    public final void setDebugMode(boolean z) {
        AppMethodBeat.i(59822);
        this.TGb.a(cLI[6], Boolean.valueOf(z));
        AppMethodBeat.o(59822);
    }

    static final class a extends q implements kotlin.g.a.b<av, String> {
        public static final a TGR = new a();

        static {
            AppMethodBeat.i(59806);
            AppMethodBeat.o(59806);
        }

        a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(av avVar) {
            AppMethodBeat.i(59805);
            p.h(avVar, LocaleUtil.ITALIAN);
            AppMethodBeat.o(59805);
            return "...";
        }
    }

    static final class c extends q implements kotlin.g.a.b<ab, ab> {
        public static final c TGT = new c();

        static {
            AppMethodBeat.i(59809);
            AppMethodBeat.o(59809);
        }

        c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ ab invoke(ab abVar) {
            AppMethodBeat.i(59808);
            ab abVar2 = abVar;
            p.h(abVar2, LocaleUtil.ITALIAN);
            AppMethodBeat.o(59808);
            return abVar2;
        }
    }

    public j() {
        AppMethodBeat.i(59855);
        k kVar = k.TGV;
        this.TGE = fy(k.hKy());
        this.TGF = fy(null);
        this.TGG = fy(a.NO_ARGUMENTS);
        this.TGH = fy(Boolean.FALSE);
        this.TGI = fy(Boolean.TRUE);
        this.TGJ = fy(Boolean.TRUE);
        this.TGK = fy(Boolean.FALSE);
        this.TGL = fy(Boolean.TRUE);
        this.TGM = fy(Boolean.TRUE);
        this.TGN = fy(Boolean.FALSE);
        this.TGO = fy(Boolean.FALSE);
        this.TGP = fy(Boolean.FALSE);
        this.TGQ = fy(Boolean.TRUE);
        AppMethodBeat.o(59855);
    }

    public final void lock() {
        AppMethodBeat.i(59811);
        boolean z = !this.aHY;
        if (!kotlin.aa.SXc || z) {
            this.aHY = true;
            AppMethodBeat.o(59811);
            return;
        }
        AssertionError assertionError = new AssertionError("Assertion failed");
        AppMethodBeat.o(59811);
        throw assertionError;
    }

    public static final class b extends kotlin.i.b<T> {
        final /* synthetic */ j TGS;
        final /* synthetic */ Object mKT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Object obj, Object obj2, j jVar) {
            super(obj2);
            this.mKT = obj;
            this.TGS = jVar;
        }

        @Override // kotlin.i.b
        public final boolean b(k<?> kVar) {
            AppMethodBeat.i(59807);
            p.h(kVar, "property");
            if (this.TGS.aHY) {
                IllegalStateException illegalStateException = new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
                AppMethodBeat.o(59807);
                throw illegalStateException;
            }
            AppMethodBeat.o(59807);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final <T> kotlin.i.c<j, T> fy(T t) {
        AppMethodBeat.i(59812);
        kotlin.i.a aVar = kotlin.i.a.SYL;
        b bVar = new b(t, t, this);
        AppMethodBeat.o(59812);
        return bVar;
    }
}
