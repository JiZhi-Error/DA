package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.ui.bu;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class l implements q.a {
    private ab Ept = null;

    public l(ab abVar) {
        this.Ept = abVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.q.a
    public final void b(View view, Object obj) {
        int measuredWidth;
        int i2;
        int max;
        int i3;
        AppMethodBeat.i(97845);
        if (this.Ept.ffr() != null) {
            this.Ept.ffr().fcl();
        }
        if (this.Ept.ffs() != null) {
            this.Ept.ffs().fcl();
        }
        if (this.Ept.fft() != null) {
            this.Ept.fft().ffL();
        }
        if (this.Ept.ffu() != null) {
            this.Ept.ffu().fka();
            this.Ept.ffu().onr = true;
            bu ffu = this.Ept.ffu();
            if (ffu.DQx || !(view instanceof SnsCommentPreloadTextView)) {
                AppMethodBeat.o(97845);
                return;
            }
            SnsCommentPreloadTextView snsCommentPreloadTextView = (SnsCommentPreloadTextView) view;
            if (ffu.DQu != null) {
                if (ffu.DQu.getTag() instanceof bu.a) {
                    ffu.fw(((bu.a) ffu.DQu.getTag()).Atk);
                    AppMethodBeat.o(97845);
                    return;
                }
                ffu.fka();
                AppMethodBeat.o(97845);
                return;
            } else if (view.getTag() == null || !(view.getTag() instanceof m)) {
                AppMethodBeat.o(97845);
                return;
            } else {
                m mVar = (m) view.getTag();
                if (Util.isNullOrNil(mVar.DIu.MYY) || mVar.DIu.MYY.get(0) == null || Util.isNullOrNil(mVar.DIu.MYY.get(0).Md5)) {
                    Log.w("MicroMsg.AdNotLikeHelper", "skip show emoji dialog. md5 is null");
                    AppMethodBeat.o(97845);
                    return;
                }
                ffu.DQu = new AbsoluteLayout(ffu.mContext);
                ffu.DQu.setId(R.id.h2);
                ffu.DQu.setOnClickListener(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x011a: INVOKE  
                      (wrap: android.widget.AbsoluteLayout : 0x0113: IGET  (r4v14 android.widget.AbsoluteLayout) = (r7v0 'ffu' com.tencent.mm.plugin.sns.ui.bu) com.tencent.mm.plugin.sns.ui.bu.DQu android.widget.AbsoluteLayout)
                      (wrap: com.tencent.mm.plugin.sns.ui.bu$1 : 0x0117: CONSTRUCTOR  (r5v4 com.tencent.mm.plugin.sns.ui.bu$1) = (r7v0 'ffu' com.tencent.mm.plugin.sns.ui.bu) call: com.tencent.mm.plugin.sns.ui.bu.1.<init>(com.tencent.mm.plugin.sns.ui.bu):void type: CONSTRUCTOR)
                     type: VIRTUAL call: android.widget.AbsoluteLayout.setOnClickListener(android.view.View$OnClickListener):void in method: com.tencent.mm.plugin.sns.ui.l.b(android.view.View, java.lang.Object):void, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0117: CONSTRUCTOR  (r5v4 com.tencent.mm.plugin.sns.ui.bu$1) = (r7v0 'ffu' com.tencent.mm.plugin.sns.ui.bu) call: com.tencent.mm.plugin.sns.ui.bu.1.<init>(com.tencent.mm.plugin.sns.ui.bu):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.sns.ui.l.b(android.view.View, java.lang.Object):void, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 34 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.sns.ui.bu, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 40 more
                    */
                /*
                // Method dump skipped, instructions count: 724
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.l.b(android.view.View, java.lang.Object):void");
            }
        }
