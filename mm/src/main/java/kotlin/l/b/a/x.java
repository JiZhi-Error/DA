package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.b.a.b.a.b.e;
import kotlin.l.b.a.b.b.c.w;
import kotlin.l.b.a.b.b.d.a.j;
import kotlin.l.b.a.b.b.d.b.b;
import kotlin.l.b.a.b.f.f;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\bH\u0000\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"moduleByClassLoader", "Ljava/util/concurrent/ConcurrentMap;", "Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "Ljava/lang/ref/WeakReference;", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "clearModuleByClassLoaderCache", "", "getOrCreateModule", "Ljava/lang/Class;", "kotlin-reflection"})
public final class x {
    private static final ConcurrentMap<af, WeakReference<j>> TbB = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(56513);
        AppMethodBeat.o(56513);
    }

    public static final j bs(Class<?> cls) {
        AppMethodBeat.i(56512);
        p.h(cls, "$this$getOrCreateModule");
        ClassLoader bx = b.bx(cls);
        af afVar = new af(bx);
        WeakReference<j> weakReference = TbB.get(afVar);
        if (weakReference != null) {
            j jVar = weakReference.get();
            if (jVar != null) {
                p.g(jVar, LocaleUtil.ITALIAN);
                AppMethodBeat.o(56512);
                return jVar;
            }
            TbB.remove(afVar, weakReference);
        }
        j.a aVar = j.TmQ;
        p.h(bx, "classLoader");
        kotlin.l.b.a.b.l.b bVar = new kotlin.l.b.a.b.l.b("RuntimeModuleData");
        e eVar = new e(bVar, e.a.FROM_DEPENDENCIES);
        f bua = f.bua("<runtime module for " + bx + '>');
        p.g(bua, "Name.special(\"<runtime module for $classLoader>\")");
        w wVar = new w(bua, bVar, eVar, (Map) null, 56);
        eVar.TcN.an(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x009b: INVOKE  
              (wrap: kotlin.l.b.a.b.l.j : 0x0092: IGET  (r4v6 kotlin.l.b.a.b.l.j) = (r27v0 'eVar' kotlin.l.b.a.b.a.b.e) kotlin.l.b.a.b.a.g.TcN kotlin.l.b.a.b.l.j)
              (wrap: kotlin.l.b.a.b.a.g$4 : 0x0098: CONSTRUCTOR  (r5v5 kotlin.l.b.a.b.a.g$4) = (r27v0 'eVar' kotlin.l.b.a.b.a.b.e), (r3v10 'wVar' kotlin.l.b.a.b.b.c.w) call: kotlin.l.b.a.b.a.g.4.<init>(kotlin.l.b.a.b.a.g, kotlin.l.b.a.b.b.c.w):void type: CONSTRUCTOR)
             type: INTERFACE call: kotlin.l.b.a.b.l.j.an(kotlin.g.a.a):java.lang.Object in method: kotlin.l.b.a.x.bs(java.lang.Class<?>):kotlin.l.b.a.b.b.d.a.j, file: classes8.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0098: CONSTRUCTOR  (r5v5 kotlin.l.b.a.b.a.g$4) = (r27v0 'eVar' kotlin.l.b.a.b.a.b.e), (r3v10 'wVar' kotlin.l.b.a.b.b.c.w) call: kotlin.l.b.a.b.a.g.4.<init>(kotlin.l.b.a.b.a.g, kotlin.l.b.a.b.b.c.w):void type: CONSTRUCTOR in method: kotlin.l.b.a.x.bs(java.lang.Class<?>):kotlin.l.b.a.b.b.d.a.j, file: classes8.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: kotlin.l.b.a.b.a.g, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
        // Method dump skipped, instructions count: 730
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.x.bs(java.lang.Class):kotlin.l.b.a.b.b.d.a.j");
    }
}
