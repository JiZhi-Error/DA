package com.tencent.mm.plugin.appbrand.debugger;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.d;
import java.util.Iterator;
import java.util.LinkedList;

@SuppressLint({"ViewConstructor"})
public final class w extends FrameLayout {
    private m cBt;
    ViewGroup lja;
    RemoteDebugMoveView ljb;
    private LinkedList<String> ljc = new LinkedList<>();
    private TextView ljd;
    private TextView lje;
    private TextView ljf;
    private TextView ljg;
    private TextView ljh;
    private TextView lji;
    private TextView ljj;
    private ImageView ljk;
    private ImageView ljl;
    private View ljm;
    boolean ljn = false;
    private a ljo;
    private d ljp;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.appbrand.debugger.w.AnonymousClass3 */

        public final void onClick(View view) {
            AppMethodBeat.i(147106);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/debugger/RemoteDebugView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            w wVar = w.this;
            if (view.getId() == R.id.qy) {
                wVar.ljn = true;
                wVar.show();
                RemoteDebugMoveView remoteDebugMoveView = wVar.ljb;
                remoteDebugMoveView.postDelayed(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003c: INVOKE  
                      (r0v3 'remoteDebugMoveView' com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView)
                      (wrap: com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView$3 : 0x0037: CONSTRUCTOR  (r1v7 com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView$3) = (r0v3 'remoteDebugMoveView' com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView) call: com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView.3.<init>(com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView):void type: CONSTRUCTOR)
                      (50 long)
                     type: VIRTUAL call: com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView.postDelayed(java.lang.Runnable, long):boolean in method: com.tencent.mm.plugin.appbrand.debugger.w.3.onClick(android.view.View):void, file: classes8.dex
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0037: CONSTRUCTOR  (r1v7 com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView$3) = (r0v3 'remoteDebugMoveView' com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView) call: com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView.3.<init>(com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.debugger.w.3.onClick(android.view.View):void, file: classes8.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 19 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 25 more
                    */
                /*
                // Method dump skipped, instructions count: 111
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.debugger.w.AnonymousClass3.onClick(android.view.View):void");
            }
        };

        public interface a {
            void bAM();
        }

        static /* synthetic */ boolean c(w wVar) {
            AppMethodBeat.i(147126);
            boolean bBa = wVar.bBa();
            AppMethodBeat.o(147126);
            return bBa;
        }

        static /* synthetic */ void i(w wVar) {
            AppMethodBeat.i(147128);
            wVar.bBd();
            AppMethodBeat.o(147128);
        }

        public w(Context context, m mVar, a aVar) {
            super(context);
            AppMethodBeat.i(147113);
            this.cBt = mVar;
            this.ljo = aVar;
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            setBackgroundColor(getContext().getResources().getColor(R.color.ac_));
            setId(R.id.nj);
            AppMethodBeat.o(147113);
        }

        public final boolean onTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.i(147114);
            if (bBa()) {
                AppMethodBeat.o(147114);
                return true;
            }
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(147114);
            return onTouchEvent;
        }

        public final void bringToFront() {
            AppMethodBeat.i(147116);
            if (this.lja == null) {
                Log.w("MicroMsg.RemoteDebugView", "bringToFront mContentView is null");
                AppMethodBeat.o(147116);
                return;
            }
            AppMethodBeat.o(147116);
        }

        public final void bAZ() {
            AppMethodBeat.i(147117);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.debugger.w.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(147105);
                    if (w.this.lja == null) {
                        Log.w("MicroMsg.RemoteDebugView", "showDebugView mContentView is null");
                        AppMethodBeat.o(147105);
                    } else if (w.c(w.this)) {
                        w.this.setVisibility(0);
                        if (w.this.lja.indexOfChild(w.this) == -1) {
                            w.this.lja.addView(w.this);
                        }
                        w.this.lja.bringChildToFront(w.this);
                        w.this.setBackgroundColor(w.this.getContext().getResources().getColor(R.color.u_));
                        AppMethodBeat.o(147105);
                    } else {
                        w.this.setBackgroundColor(w.this.getContext().getResources().getColor(R.color.ac_));
                        AppMethodBeat.o(147105);
                    }
                }
            });
            AppMethodBeat.o(147117);
        }

        private boolean bBa() {
            AppMethodBeat.i(147118);
            if (this.cBt.bAI() || this.cBt.isQuit() || this.cBt.bAJ()) {
                AppMethodBeat.o(147118);
                return true;
            }
            AppMethodBeat.o(147118);
            return false;
        }

        private void bBb() {
            AppMethodBeat.i(147119);
            this.ljb = (RemoteDebugMoveView) LayoutInflater.from(getContext()).inflate(R.layout.fd, (ViewGroup) null);
            this.lje = (TextView) this.ljb.findViewById(R.id.qv);
            this.ljd = (TextView) this.ljb.findViewById(R.id.r4);
            this.ljf = (TextView) this.ljb.findViewById(R.id.qz);
            this.ljg = (TextView) this.ljb.findViewById(R.id.r1);
            this.ljh = (TextView) this.ljb.findViewById(R.id.qy);
            this.lji = (TextView) this.ljb.findViewById(R.id.qt);
            this.ljj = (TextView) this.ljb.findViewById(R.id.qx);
            this.ljl = (ImageView) this.ljb.findViewById(R.id.qu);
            this.ljk = (ImageView) this.ljb.findViewById(R.id.r2);
            this.ljm = this.ljb.findViewById(R.id.qw);
            show();
            bBc();
            AppMethodBeat.o(147119);
        }

        private void bBc() {
            AppMethodBeat.i(147120);
            this.ljh.setOnClickListener(this.mOnClickListener);
            this.lji.setOnClickListener(this.mOnClickListener);
            this.ljg.setOnClickListener(this.mOnClickListener);
            AppMethodBeat.o(147120);
        }

        /* access modifiers changed from: package-private */
        public final void bBd() {
            AppMethodBeat.i(147121);
            if (this.ljp == null || !this.ljp.isShowing()) {
                Context context = getContext();
                if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                    this.ljp = new d.a(context).bon(context.getString(R.string.qv)).boo("").aoV(R.string.ame).c(new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.appbrand.debugger.w.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(147107);
                            if (w.this.ljo != null) {
                                w.this.ljo.bAM();
                            }
                            AppMethodBeat.o(147107);
                        }
                    }).aoW(R.string.amc).hbn();
                    this.ljp.show();
                    AppMethodBeat.o(147121);
                    return;
                }
                AppMethodBeat.o(147121);
                return;
            }
            AppMethodBeat.o(147121);
        }

        public final void bBe() {
            AppMethodBeat.i(147122);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.debugger.w.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(147108);
                    if (w.this.cBt.bAI()) {
                        w.this.ljl.setImageResource(R.drawable.f13do);
                        w.this.lje.setText(w.this.getContext().getString(R.string.qq));
                    } else if (w.this.cBt.isReady()) {
                        w.this.ljl.setImageResource(R.drawable.f13do);
                        w.this.lje.setText(w.this.getContext().getString(R.string.qr));
                    } else {
                        w.this.ljl.setImageResource(R.drawable.dn);
                        w.this.lje.setText(w.this.getContext().getString(R.string.qp));
                    }
                    w.h(w.this);
                    AppMethodBeat.o(147108);
                }
            });
            AppMethodBeat.o(147122);
        }

        public final void show() {
            AppMethodBeat.i(147123);
            if (this.ljn) {
                this.ljm.setVisibility(0);
                if (this.ljc.size() > 0) {
                    this.ljj.setVisibility(0);
                } else {
                    this.ljj.setVisibility(8);
                }
                this.ljh.setVisibility(8);
            } else {
                this.ljm.setVisibility(8);
                this.ljj.setVisibility(8);
                this.ljh.setVisibility(0);
            }
            invalidate();
            AppMethodBeat.o(147123);
        }

        public final void bBf() {
            AppMethodBeat.i(147124);
            bAZ();
            bBe();
            AppMethodBeat.o(147124);
        }

        public final void Ya(final String str) {
            AppMethodBeat.i(147125);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(147125);
                return;
            }
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.debugger.w.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(147112);
                    w.a(w.this, str);
                    AppMethodBeat.o(147112);
                }
            });
            AppMethodBeat.o(147125);
        }

        public final void T(AppBrandRuntime appBrandRuntime) {
            AppMethodBeat.i(229886);
            this.lja = appBrandRuntime.kAt;
            if (getParent() instanceof ViewGroup) {
                ((ViewGroup) getParent()).removeView(this);
            }
            appBrandRuntime.ct(this);
            bBb();
            postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.debugger.w.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(147104);
                    RemoteDebugMoveView remoteDebugMoveView = w.this.ljb;
                    int width = w.this.getWidth();
                    int height = w.this.getHeight();
                    remoteDebugMoveView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    remoteDebugMoveView.hbc = width;
                    remoteDebugMoveView.oh = height;
                    remoteDebugMoveView.post(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002a: INVOKE  
                          (r0v1 'remoteDebugMoveView' com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView)
                          (wrap: com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView$1 : 0x0027: CONSTRUCTOR  (r1v2 com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView$1) = (r0v1 'remoteDebugMoveView' com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView) call: com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView.1.<init>(com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView):void type: CONSTRUCTOR)
                         type: VIRTUAL call: com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView.post(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.appbrand.debugger.w.1.run():void, file: classes8.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0027: CONSTRUCTOR  (r1v2 com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView$1) = (r0v1 'remoteDebugMoveView' com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView) call: com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView.1.<init>(com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.debugger.w.1.run():void, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 14 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 20 more
                        */
                    /*
                        this = this;
                        r5 = 147104(0x23ea0, float:2.06137E-40)
                        r4 = -2
                        com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
                        com.tencent.mm.plugin.appbrand.debugger.w r0 = com.tencent.mm.plugin.appbrand.debugger.w.this
                        com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView r0 = com.tencent.mm.plugin.appbrand.debugger.w.a(r0)
                        com.tencent.mm.plugin.appbrand.debugger.w r1 = com.tencent.mm.plugin.appbrand.debugger.w.this
                        int r1 = r1.getWidth()
                        com.tencent.mm.plugin.appbrand.debugger.w r2 = com.tencent.mm.plugin.appbrand.debugger.w.this
                        int r2 = r2.getHeight()
                        android.view.ViewGroup$LayoutParams r3 = new android.view.ViewGroup$LayoutParams
                        r3.<init>(r4, r4)
                        r0.setLayoutParams(r3)
                        r0.hbc = r1
                        r0.oh = r2
                        com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView$1 r1 = new com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView$1
                        r1.<init>()
                        r0.post(r1)
                        com.tencent.mm.plugin.appbrand.debugger.w r0 = com.tencent.mm.plugin.appbrand.debugger.w.this
                        com.tencent.mm.plugin.appbrand.debugger.w r1 = com.tencent.mm.plugin.appbrand.debugger.w.this
                        com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView r1 = com.tencent.mm.plugin.appbrand.debugger.w.a(r1)
                        r0.addView(r1)
                        com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.debugger.w.AnonymousClass1.run():void");
                }
            }, 100);
            AppMethodBeat.o(229886);
        }

        static /* synthetic */ void h(w wVar) {
            AppMethodBeat.i(147127);
            if (wVar.cBt.isBusy() || !wVar.cBt.isReady()) {
                wVar.ljk.setImageResource(R.drawable.dn);
                wVar.ljd.setText(wVar.getContext().getString(R.string.qw));
                AppMethodBeat.o(147127);
                return;
            }
            wVar.ljk.setImageResource(R.drawable.f13do);
            wVar.ljd.setText(wVar.getContext().getString(R.string.qx));
            AppMethodBeat.o(147127);
        }

        static /* synthetic */ void j(w wVar) {
            AppMethodBeat.i(147129);
            wVar.ljf.setText(wVar.getContext().getString(R.string.qt, Integer.valueOf(wVar.cBt.lih.size()), Integer.valueOf(wVar.cBt.lig.size()), Long.valueOf(wVar.cBt.lim)));
            AppMethodBeat.o(147129);
        }

        static /* synthetic */ void a(w wVar, String str) {
            AppMethodBeat.i(147130);
            wVar.ljc.add(0, str);
            while (wVar.ljc.size() > 10) {
                wVar.ljc.removeLast();
            }
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = wVar.ljc.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("\n");
            }
            wVar.ljj.setText(sb.toString());
            if (wVar.ljn) {
                wVar.ljj.setVisibility(0);
                AppMethodBeat.o(147130);
                return;
            }
            wVar.ljj.setVisibility(8);
            AppMethodBeat.o(147130);
        }
    }
