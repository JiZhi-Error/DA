package com.tencent.mm.ui.widget.picker.e;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.WheelView;

public final class b extends Handler {
    private final WheelView QUD;

    public b(WheelView wheelView) {
        this.QUD = wheelView;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void handleMessage(Message message) {
        AppMethodBeat.i(198523);
        switch (message.what) {
            case 1000:
                this.QUD.invalidate();
                AppMethodBeat.o(198523);
                return;
            case 2000:
                this.QUD.a(WheelView.a.FLING);
                AppMethodBeat.o(198523);
                return;
            case 3000:
                WheelView wheelView = this.QUD;
                wheelView.hcn();
                if (wheelView.QTP != null) {
                    wheelView.postDelayed(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0033: INVOKE  
                          (r0v1 'wheelView' com.tencent.mm.ui.widget.picker.WheelView)
                          (wrap: com.tencent.mm.ui.widget.picker.WheelView$1 : 0x002e: CONSTRUCTOR  (r1v1 com.tencent.mm.ui.widget.picker.WheelView$1) = (r0v1 'wheelView' com.tencent.mm.ui.widget.picker.WheelView) call: com.tencent.mm.ui.widget.picker.WheelView.1.<init>(com.tencent.mm.ui.widget.picker.WheelView):void type: CONSTRUCTOR)
                          (200 long)
                         type: VIRTUAL call: com.tencent.mm.ui.widget.picker.WheelView.postDelayed(java.lang.Runnable, long):boolean in method: com.tencent.mm.ui.widget.picker.e.b.handleMessage(android.os.Message):void, file: classes6.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002e: CONSTRUCTOR  (r1v1 com.tencent.mm.ui.widget.picker.WheelView$1) = (r0v1 'wheelView' com.tencent.mm.ui.widget.picker.WheelView) call: com.tencent.mm.ui.widget.picker.WheelView.1.<init>(com.tencent.mm.ui.widget.picker.WheelView):void type: CONSTRUCTOR in method: com.tencent.mm.ui.widget.picker.e.b.handleMessage(android.os.Message):void, file: classes6.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 24 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.ui.widget.picker.WheelView, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 30 more
                        */
                    /*
                        this = this;
                        r4 = 198523(0x3077b, float:2.7819E-40)
                        com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                        int r0 = r6.what
                        switch(r0) {
                            case 1000: goto L_0x000f;
                            case 2000: goto L_0x0018;
                            case 3000: goto L_0x0023;
                            default: goto L_0x000b;
                        }
                    L_0x000b:
                        com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                    L_0x000e:
                        return
                    L_0x000f:
                        com.tencent.mm.ui.widget.picker.WheelView r0 = r5.QUD
                        r0.invalidate()
                        com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                        goto L_0x000e
                    L_0x0018:
                        com.tencent.mm.ui.widget.picker.WheelView r0 = r5.QUD
                        com.tencent.mm.ui.widget.picker.WheelView$a r1 = com.tencent.mm.ui.widget.picker.WheelView.a.FLING
                        r0.a(r1)
                        com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                        goto L_0x000e
                    L_0x0023:
                        com.tencent.mm.ui.widget.picker.WheelView r0 = r5.QUD
                        r0.hcn()
                        com.tencent.mm.ui.widget.picker.d.c r1 = r0.QTP
                        if (r1 == 0) goto L_0x000b
                        com.tencent.mm.ui.widget.picker.WheelView$1 r1 = new com.tencent.mm.ui.widget.picker.WheelView$1
                        r1.<init>()
                        r2 = 200(0xc8, double:9.9E-322)
                        r0.postDelayed(r1, r2)
                        goto L_0x000b
                        switch-data {1000->0x000f, 2000->0x0018, 3000->0x0023, }
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.widget.picker.e.b.handleMessage(android.os.Message):void");
                }
            }
