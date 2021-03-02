package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.a;
import com.tencent.mm.bh.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.LauncherUI;

public final class p implements a {
    Runnable PTi = new Runnable() {
        /* class com.tencent.mm.ui.conversation.p.AnonymousClass10 */

        public final void run() {
            AppMethodBeat.i(38734);
            p pVar = p.this;
            LauncherUI launcherUI = (LauncherUI) pVar.dKq;
            if (launcherUI == null || launcherUI.ODR.getMainTabUI().acm == 0) {
                ConversationListView conversationListView = pVar.QfG;
                if (conversationListView.getFirstVisiblePosition() > conversationListView.getFirstHeaderVisible() + 16) {
                    conversationListView.setSelection(conversationListView.getFirstHeaderVisible() + 16);
                }
                conversationListView.post(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0034: INVOKE  
                      (r0v2 'conversationListView' com.tencent.mm.ui.conversation.ConversationListView)
                      (wrap: com.tencent.mm.ui.conversation.ConversationListView$4 : 0x0031: CONSTRUCTOR  (r1v2 com.tencent.mm.ui.conversation.ConversationListView$4) = (r0v2 'conversationListView' com.tencent.mm.ui.conversation.ConversationListView) call: com.tencent.mm.ui.conversation.ConversationListView.4.<init>(com.tencent.mm.ui.conversation.ConversationListView):void type: CONSTRUCTOR)
                     type: VIRTUAL call: com.tencent.mm.ui.conversation.ConversationListView.post(java.lang.Runnable):boolean in method: com.tencent.mm.ui.conversation.p.10.run():void, file: classes5.dex
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
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0031: CONSTRUCTOR  (r1v2 com.tencent.mm.ui.conversation.ConversationListView$4) = (r0v2 'conversationListView' com.tencent.mm.ui.conversation.ConversationListView) call: com.tencent.mm.ui.conversation.ConversationListView.4.<init>(com.tencent.mm.ui.conversation.ConversationListView):void type: CONSTRUCTOR in method: com.tencent.mm.ui.conversation.p.10.run():void, file: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 19 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.ui.conversation.ConversationListView, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 25 more
                    */
                /*
                    this = this;
                    r3 = 38734(0x974e, float:5.4278E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    com.tencent.mm.ui.conversation.p r1 = com.tencent.mm.ui.conversation.p.this
                    android.app.Activity r0 = r1.dKq
                    com.tencent.mm.ui.LauncherUI r0 = (com.tencent.mm.ui.LauncherUI) r0
                    if (r0 == 0) goto L_0x0018
                    com.tencent.mm.ui.HomeUI r0 = r0.ODR
                    com.tencent.mm.ui.MainTabUI r0 = r0.getMainTabUI()
                    int r0 = r0.acm
                    if (r0 != 0) goto L_0x0037
                L_0x0018:
                    com.tencent.mm.ui.conversation.ConversationListView r0 = r1.QfG
                    int r1 = r0.getFirstVisiblePosition()
                    int r2 = r0.getFirstHeaderVisible()
                    int r2 = r2 + 16
                    if (r1 <= r2) goto L_0x002f
                    int r1 = r0.getFirstHeaderVisible()
                    int r1 = r1 + 16
                    r0.setSelection(r1)
                L_0x002f:
                    com.tencent.mm.ui.conversation.ConversationListView$4 r1 = new com.tencent.mm.ui.conversation.ConversationListView$4
                    r1.<init>()
                    r0.post(r1)
                L_0x0037:
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.conversation.p.AnonymousClass10.run():void");
            }
        };
        i Qct;
        ConversationListView QfG;
        IListener Qhb = null;
        IListener Qhc = null;
        Activity dKq;
        MessageQueue.IdleHandler pzA;
        IListener qZo = null;

        public p() {
            AppMethodBeat.i(38735);
            AppMethodBeat.o(38735);
        }

        @Override // com.tencent.mm.bh.a
        public final void h(String str, String str2, String str3) {
            AppMethodBeat.i(38736);
            if (this.Qct != null) {
                this.Qct.notifyDataSetChanged();
            }
            AppMethodBeat.o(38736);
        }

        public final void gGx() {
            AppMethodBeat.i(234255);
            if (g.jpy != null) {
                g.jpy.b(this);
            }
            o.gWh();
            LauncherUI launcherUI = (LauncherUI) this.dKq;
            if (launcherUI != null) {
                launcherUI.getHomeUI().aI(this.PTi);
            }
            AppMethodBeat.o(234255);
        }
    }
