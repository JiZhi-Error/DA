package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.menu.a.b;
import com.tencent.mm.plugin.appbrand.menu.a.c;
import com.tencent.mm.plugin.appbrand.menu.b.d;
import com.tencent.mm.plugin.appbrand.menu.b.e;
import com.tencent.mm.plugin.appbrand.menu.b.g;
import com.tencent.mm.plugin.appbrand.menu.b.h;
import com.tencent.mm.plugin.appbrand.menu.b.i;
import com.tencent.mm.plugin.appbrand.menu.b.j;
import com.tencent.mm.plugin.appbrand.menu.b.k;
import com.tencent.mm.plugin.appbrand.menu.b.l;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.base.m;
import java.util.ArrayList;
import java.util.Locale;

public final class f extends a<ag> {
    private static final c<ag> neJ;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, com.tencent.mm.ui.base.m, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, m mVar, String str) {
        boolean z = false;
        AppMethodBeat.i(47628);
        ag agVar2 = agVar;
        c<ag> cVar = neJ;
        int i2 = 0;
        while (true) {
            if (i2 >= cVar.nfH.size()) {
                break;
            } else if (cVar.nfH.get(i2).a(context, agVar2, str)) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            mVar.b(u.DevTools.ordinal(), context.getString(R.string.kc), R.raw.appbrand_menu_enable_debug);
        }
        AppMethodBeat.o(47628);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String, com.tencent.mm.plugin.appbrand.menu.t] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, String str, t tVar) {
        String str2;
        AppMethodBeat.i(47627);
        ag agVar2 = agVar;
        c<ag> cVar = neJ;
        String string = MMApplicationContext.getContext().getString(R.string.kc);
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || WeChatEnvironment.hasDebugger()) {
            str2 = String.format(Locale.ENGLISH, "%s (%s)", string, MMApplicationContext.getProcessName().substring(MMApplicationContext.getPackageName().length()));
        } else {
            str2 = string;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < cVar.nfH.size(); i2++) {
            b bVar = cVar.nfH.get(i2);
            if (bVar.a(context, agVar2, str)) {
                arrayList.add(bVar.b(context, agVar2, str));
                arrayList2.add(bVar);
            }
        }
        boolean z = agVar2.btO() || agVar2.isFullScreen();
        com.tencent.mm.plugin.appbrand.platform.window.c cVar2 = agVar2.kEb;
        c.AnonymousClass1 r0 = 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x008d: CONSTRUCTOR  (r0v8 'r0' com.tencent.mm.plugin.appbrand.menu.a.c$1) = 
              (r1v0 'cVar' com.tencent.mm.plugin.appbrand.menu.a.c<com.tencent.mm.plugin.appbrand.page.ag>)
              (r2v2 'arrayList2' java.util.ArrayList)
              (r11v0 'context' android.content.Context)
              (r4v1 'agVar2' com.tencent.mm.plugin.appbrand.page.ag)
              (r13v0 'str' java.lang.String)
             call: com.tencent.mm.plugin.appbrand.menu.a.c.1.<init>(com.tencent.mm.plugin.appbrand.menu.a.c, java.util.List, android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.menu.f.a(android.content.Context, com.tencent.mm.plugin.appbrand.page.ag, java.lang.String, com.tencent.mm.plugin.appbrand.menu.t):void, file: classes3.dex
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.menu.a.c, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            */
        /*
        // Method dump skipped, instructions count: 294
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.menu.f.a(android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String, com.tencent.mm.plugin.appbrand.menu.t):void");
    }

    static {
        AppMethodBeat.i(47629);
        c<ag> cVar = new c<>();
        neJ = cVar;
        cVar.a(new com.tencent.mm.plugin.appbrand.menu.b.c());
        neJ.a(new l());
        neJ.a(new d());
        neJ.a(new g());
        neJ.a(new j());
        neJ.a(new e());
        neJ.a(new k());
        neJ.a(new com.tencent.mm.plugin.appbrand.menu.b.b());
        neJ.a(new com.tencent.mm.plugin.appbrand.menu.b.a());
        neJ.a(h.nfX);
        neJ.a(i.nfY);
        neJ.a(new com.tencent.mm.plugin.appbrand.menu.b.f());
        AppMethodBeat.o(47629);
    }

    public f() {
        super(u.DevTools.ordinal());
        AppMethodBeat.i(47626);
        AppMethodBeat.o(47626);
    }
}
