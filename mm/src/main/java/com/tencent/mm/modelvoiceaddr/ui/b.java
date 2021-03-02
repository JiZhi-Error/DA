package com.tencent.mm.modelvoiceaddr.ui;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.f;
import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.tools.s;

public final class b extends s {
    public boolean jxF = true;
    public int jxG;
    public int jxH;
    a jxI;
    public VoiceSearchLayout jxJ;
    private VoiceSearchLayout.a jxK = new VoiceSearchLayout.a() {
        /* class com.tencent.mm.modelvoiceaddr.ui.b.AnonymousClass1 */

        @Override // com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.a
        public final void biI() {
            AppMethodBeat.i(148632);
            if (com.tencent.mm.q.a.cC(MMApplicationContext.getContext()) || com.tencent.mm.q.a.cA(MMApplicationContext.getContext()) || com.tencent.mm.q.a.cE(MMApplicationContext.getContext())) {
                AppMethodBeat.o(148632);
                return;
            }
            Log.d("MicroMsg.VoiceSearchViewHelper", "on voice search start");
            h.INSTANCE.a(10453, Integer.valueOf(b.this.jxG), 3);
            if (b.this.jxI != null) {
                b.this.jxI.biM();
            }
            AppMethodBeat.o(148632);
        }

        @Override // com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.a
        public final void biJ() {
            AppMethodBeat.i(148633);
            Log.d("MicroMsg.VoiceSearchViewHelper", "on voice search cancel");
            h.INSTANCE.a(10453, Integer.valueOf(b.this.jxG), 4);
            if (b.this.Qwh != null) {
                b.this.Qwh.setEditTextEnabled(true);
                b.this.Qwh.setStatusBtnEnabled(true);
            }
            AppMethodBeat.o(148633);
        }

        @Override // com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.a
        public final void a(boolean z, String[] strArr, long j2) {
            AppMethodBeat.i(148634);
            Log.d("MicroMsg.VoiceSearchViewHelper", "on voice search return, success %B, voice id %d", Boolean.valueOf(z), Long.valueOf(j2));
            if (b.this.jxI != null) {
                b.this.jxI.a(z, strArr, j2, b.this.jxH);
            }
            AppMethodBeat.o(148634);
        }
    };

    public interface a extends s.b {
        void a(boolean z, String[] strArr, long j2, int i2);

        void biM();
    }

    public b() {
        AppMethodBeat.i(148635);
        AppMethodBeat.o(148635);
    }

    public b(byte b2) {
        super((byte) 0);
        AppMethodBeat.i(148636);
        AppMethodBeat.o(148636);
    }

    public final void a(a aVar) {
        this.jxI = aVar;
        this.Qwi = aVar;
    }

    public final void cancel() {
        AppMethodBeat.i(148637);
        Log.d("MicroMsg.VoiceSearchViewHelper", "do cancel");
        if (this.jxJ != null) {
            this.jxJ.biE();
        }
        if (this.Qwh != null) {
            this.Qwh.setEditTextEnabled(true);
            this.Qwh.setStatusBtnEnabled(true);
        }
        AppMethodBeat.o(148637);
    }

    public final void onPause() {
        AppMethodBeat.i(148638);
        gXP();
        cancel();
        AppMethodBeat.o(148638);
    }

    @Override // com.tencent.mm.ui.tools.s
    public final boolean biK() {
        boolean z = false;
        AppMethodBeat.i(148639);
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.jxF);
        if (this.jxJ == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        Log.d("MicroMsg.VoiceSearchViewHelper", "check has voice search, Enable %B, layout is null ? %B", objArr);
        boolean z2 = this.jxF;
        AppMethodBeat.o(148639);
        return z2;
    }

    @Override // com.tencent.mm.ui.tools.s
    public final void biL() {
        boolean z;
        AppMethodBeat.i(148640);
        Log.d("MicroMsg.VoiceSearchViewHelper", "do require voice search");
        if (this.Qwh != null) {
            this.Qwh.setEditTextEnabled(false);
            this.Qwh.setStatusBtnEnabled(false);
        }
        if (this.jxJ == null || this.jxJ.getVisibility() != 8) {
            AppMethodBeat.o(148640);
            return;
        }
        Log.d("MicroMsg.VoiceSearchViewHelper", "do voice search layout start");
        VoiceSearchLayout voiceSearchLayout = this.jxJ;
        int i2 = this.jxH;
        boolean n = com.tencent.mm.pluginsdk.permission.b.n(voiceSearchLayout.getContext(), "android.permission.RECORD_AUDIO");
        Log.i("MicroMsg.VoiceSearchLayout", "summerper checkPermission checkMicrophone[%b]", Boolean.valueOf(n));
        if (n) {
            Log.d("MicroMsg.VoiceSearchLayout", "doStart " + voiceSearchLayout.isStart);
            voiceSearchLayout.jxq = i2;
            voiceSearchLayout.isStart = true;
            voiceSearchLayout.jxp = false;
            if (voiceSearchLayout.jxn != null) {
                voiceSearchLayout.jxn.biI();
            }
            voiceSearchLayout.setVisibility(0);
            voiceSearchLayout.jxC.startTimer(50);
            voiceSearchLayout.fW(true);
            voiceSearchLayout.jxB = 0;
            voiceSearchLayout.jxu = new f(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0098: IPUT  
                  (wrap: com.tencent.mm.modelvoiceaddr.f : 0x0095: CONSTRUCTOR  (r4v5 com.tencent.mm.modelvoiceaddr.f) = 
                  (wrap: com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout$4 : 0x0092: CONSTRUCTOR  (r5v5 com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout$4) = (r0v6 'voiceSearchLayout' com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout) call: com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.4.<init>(com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout):void type: CONSTRUCTOR)
                  (r3v3 'i2' int)
                 call: com.tencent.mm.modelvoiceaddr.f.<init>(com.tencent.mm.modelvoiceaddr.f$b, int):void type: CONSTRUCTOR)
                  (r0v6 'voiceSearchLayout' com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout)
                 com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.jxu com.tencent.mm.modelvoiceaddr.f in method: com.tencent.mm.modelvoiceaddr.ui.b.biL():void, file: classes9.dex
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
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0095: CONSTRUCTOR  (r4v5 com.tencent.mm.modelvoiceaddr.f) = 
                  (wrap: com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout$4 : 0x0092: CONSTRUCTOR  (r5v5 com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout$4) = (r0v6 'voiceSearchLayout' com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout) call: com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.4.<init>(com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout):void type: CONSTRUCTOR)
                  (r3v3 'i2' int)
                 call: com.tencent.mm.modelvoiceaddr.f.<init>(com.tencent.mm.modelvoiceaddr.f$b, int):void type: CONSTRUCTOR in method: com.tencent.mm.modelvoiceaddr.ui.b.biL():void, file: classes9.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 25 more
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0092: CONSTRUCTOR  (r5v5 com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout$4) = (r0v6 'voiceSearchLayout' com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout) call: com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.4.<init>(com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout):void type: CONSTRUCTOR in method: com.tencent.mm.modelvoiceaddr.ui.b.biL():void, file: classes9.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:663)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 29 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 35 more
                */
            /*
            // Method dump skipped, instructions count: 248
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoiceaddr.ui.b.biL():void");
        }

        @Override // com.tencent.mm.ui.tools.s
        public final void a(Activity activity, Menu menu) {
            AppMethodBeat.i(148641);
            super.a(activity, menu);
            if (this.jxJ != null) {
                this.jxJ.setOnSearchListener(this.jxK);
            }
            AppMethodBeat.o(148641);
        }

        @Override // com.tencent.mm.ui.tools.s
        public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
            boolean z;
            AppMethodBeat.i(148642);
            if (4 == i2) {
                if (this.jxJ == null || this.jxJ.getVisibility() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                Log.d("MicroMsg.VoiceSearchViewHelper", "on back key down, try hide voice search panel, it is visiable[%B]", Boolean.valueOf(z));
                cancel();
                if (z) {
                    AppMethodBeat.o(148642);
                    return true;
                }
            }
            Log.d("MicroMsg.VoiceSearchViewHelper", "not match key code, pass to super");
            boolean onKeyDown = super.onKeyDown(i2, keyEvent);
            AppMethodBeat.o(148642);
            return onKeyDown;
        }

        @Override // com.tencent.mm.ui.tools.s
        public final void c(Menu menu) {
            AppMethodBeat.i(148643);
            cancel();
            AppMethodBeat.o(148643);
        }
    }
