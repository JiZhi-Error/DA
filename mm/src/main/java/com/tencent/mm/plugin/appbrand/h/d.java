package com.tencent.mm.plugin.appbrand.h;

import com.tencent.luggage.xweb_ext.extendplugin.a.b;
import com.tencent.luggage.xweb_ext.extendplugin.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class d implements c {
    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.c
    public b dW(String str) {
        AppMethodBeat.i(139393);
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1367751899:
                if (str.equals("camera")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1367706280:
                if (str.equals("canvas")) {
                    c2 = 2;
                    break;
                }
                break;
            case 107868:
                if (str.equals("map")) {
                    c2 = 1;
                    break;
                }
                break;
            case 112202875:
                if (str.equals("video")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1693182669:
                if (str.equals("liveplayer")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1702014259:
                if (str.equals("livepusher")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                com.tencent.luggage.xweb_ext.extendplugin.component.video.c cVar = new com.tencent.luggage.xweb_ext.extendplugin.component.video.c();
                cVar.cJb = new com.tencent.mm.plugin.appbrand.jsapi.ag.e.c();
                if (cVar.cJb != null) {
                    cVar.cJb.b(cVar);
                    cVar.cJa = cVar.cJb.QC();
                    cVar.cIZ = cVar.cJb.QD();
                    cVar.cIX = cVar.cJb.QG();
                    cVar.cIW = cVar.cJb.QF();
                    cVar.cIW.b(cVar);
                    cVar.cIW.a(cVar.cJC);
                    cVar.cIW.a(cVar.cEX);
                    cVar.cIY = cVar.cJb.QE();
                    cVar.cIY.a(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00af: INVOKE  
                          (wrap: com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c : 0x00a8: IGET  (r1v42 com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c) = (r0v13 'cVar' com.tencent.luggage.xweb_ext.extendplugin.component.video.c) com.tencent.luggage.xweb_ext.extendplugin.component.video.c.cIY com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c)
                          (wrap: com.tencent.luggage.xweb_ext.extendplugin.component.video.c$44 : 0x00ac: CONSTRUCTOR  (r2v2 com.tencent.luggage.xweb_ext.extendplugin.component.video.c$44) = (r0v13 'cVar' com.tencent.luggage.xweb_ext.extendplugin.component.video.c) call: com.tencent.luggage.xweb_ext.extendplugin.component.video.c.44.<init>(com.tencent.luggage.xweb_ext.extendplugin.component.video.c):void type: CONSTRUCTOR)
                         type: INTERFACE call: com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c.a(com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c$a):void in method: com.tencent.mm.plugin.appbrand.h.d.dW(java.lang.String):com.tencent.luggage.xweb_ext.extendplugin.a.b, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:274)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00ac: CONSTRUCTOR  (r2v2 com.tencent.luggage.xweb_ext.extendplugin.component.video.c$44) = (r0v13 'cVar' com.tencent.luggage.xweb_ext.extendplugin.component.video.c) call: com.tencent.luggage.xweb_ext.extendplugin.component.video.c.44.<init>(com.tencent.luggage.xweb_ext.extendplugin.component.video.c):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.h.d.dW(java.lang.String):com.tencent.luggage.xweb_ext.extendplugin.a.b, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 24 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.luggage.xweb_ext.extendplugin.component.video.c, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 30 more
                        */
                    /*
                    // Method dump skipped, instructions count: 334
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.h.d.dW(java.lang.String):com.tencent.luggage.xweb_ext.extendplugin.a.b");
                }
            }
