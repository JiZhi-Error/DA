package com.tencent.mm.e;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.r;
import com.tencent.mm.c.c;
import com.tencent.mm.cache.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.mm.z.f;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;

public final class e extends b<d> {
    private boolean dsX = false;
    private boolean dsY = false;
    private volatile boolean dsZ = false;
    private TimerTask dta;
    private Rect dtb = new Rect();
    private float dtc = 0.0f;
    private float dtd = 0.0f;
    private int dte = 0;
    private int dtf = 0;
    private boolean dtg = false;
    private c dth = new c(this);
    public com.tencent.mm.af.a dti;
    boolean dtj = false;
    private Timer mTimer = new Timer();
    Matrix xt = new Matrix();

    public e() {
        AppMethodBeat.i(9156);
        AppMethodBeat.o(9156);
    }

    @Override // com.tencent.mm.e.b
    public final void onAlive() {
        AppMethodBeat.i(9157);
        super.onAlive();
        int dimension = (int) MMApplicationContext.getResources().getDimension(R.dimen.ahr);
        int aD = au.aD(this.drS.gth().getContext());
        this.dtb.set((getBoardRect().width() - dimension) / 2, (getBoardRect().height() - ((int) MMApplicationContext.getResources().getDimension(R.dimen.ahq))) - aD, getBoardRect().width() - aD, (dimension + getBoardRect().width()) / 2);
        if (this.dsZ) {
            this.mTimer = new Timer();
        }
        AppMethodBeat.o(9157);
    }

    @Override // com.tencent.mm.e.b
    public final a XS() {
        return a.EMOJI_AND_TEXT;
    }

    @Override // com.tencent.mm.e.b
    public final void XT() {
    }

    @Override // com.tencent.mm.e.b
    public final void onDraw(Canvas canvas) {
        com.tencent.mm.z.c alI;
        AppMethodBeat.i(9158);
        d(canvas);
        d dVar = (d) XU();
        if (!(dVar == null || (alI = dVar.alI()) == null || !alI.gwn)) {
            alI.draw(canvas);
        }
        AppMethodBeat.o(9158);
    }

    @Override // com.tencent.mm.e.b
    public final boolean q(MotionEvent motionEvent) {
        float f2;
        boolean z;
        AppMethodBeat.i(9159);
        switch (motionEvent.getActionMasked()) {
            case 0:
                Yk();
                com.tencent.mm.z.c x = x(motionEvent.getX(), motionEvent.getY());
                if (x != null) {
                    boolean z2 = x.hop;
                    Yi();
                    this.dsX = true;
                    x.setSelected(true);
                    x.hop = z2;
                    x.hom.set(x.hok);
                    ((d) XU()).b(x);
                    cT(true);
                    Yb();
                    break;
                } else {
                    this.dsX = false;
                    if (XU() == null) {
                        z = false;
                    } else {
                        com.tencent.mm.z.c alI = ((d) XU()).alI();
                        if (alI != null) {
                            z = alI.gwn;
                        } else {
                            z = false;
                        }
                    }
                    if (z) {
                        Yi();
                        cT(false);
                        Yb();
                        break;
                    }
                }
                break;
            case 1:
                if (isAlive()) {
                    if (XU() != null) {
                        com.tencent.mm.z.c alI2 = ((d) XU()).alI();
                        if (alI2 != null) {
                            if (!this.drU.contains((int) alI2.hok.x, (int) alI2.hok.y)) {
                                this.dth.dgZ = true;
                                c cVar = this.dth;
                                cVar.dhb = alI2;
                                cVar.dgQ = alI2.hom.x - alI2.hok.x;
                                cVar.dgR = alI2.hom.y - alI2.hok.y;
                                cVar.dhc = alI2.hoh;
                                c cVar2 = this.dth;
                                if (cVar2.dgZ) {
                                    cVar2.dgN = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("deltaY", 0.0f, cVar2.dgR), PropertyValuesHolder.ofFloat("deltaX", 0.0f, cVar2.dgQ));
                                    cVar2.dgN.addUpdateListener(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x032a: INVOKE  
                                          (wrap: android.animation.ValueAnimator : 0x0323: IGET  (r2v25 android.animation.ValueAnimator) = (r0v26 'cVar2' com.tencent.mm.c.c) com.tencent.mm.c.c.dgN android.animation.ValueAnimator)
                                          (wrap: com.tencent.mm.c.c$1 : 0x0327: CONSTRUCTOR  (r3v12 com.tencent.mm.c.c$1) = (r0v26 'cVar2' com.tencent.mm.c.c) call: com.tencent.mm.c.c.1.<init>(com.tencent.mm.c.c):void type: CONSTRUCTOR)
                                         type: VIRTUAL call: android.animation.ValueAnimator.addUpdateListener(android.animation.ValueAnimator$AnimatorUpdateListener):void in method: com.tencent.mm.e.e.q(android.view.MotionEvent):boolean, file: classes6.dex
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
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0327: CONSTRUCTOR  (r3v12 com.tencent.mm.c.c$1) = (r0v26 'cVar2' com.tencent.mm.c.c) call: com.tencent.mm.c.c.1.<init>(com.tencent.mm.c.c):void type: CONSTRUCTOR in method: com.tencent.mm.e.e.q(android.view.MotionEvent):boolean, file: classes6.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	... 44 more
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.c.c, state: GENERATED_AND_UNLOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	... 50 more
                                        */
                                    /*
                                    // Method dump skipped, instructions count: 996
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.e.e.q(android.view.MotionEvent):boolean");
                                }

                                @Override // com.tencent.mm.e.b
                                public final void onDestroy() {
                                    AppMethodBeat.i(9160);
                                    super.onDestroy();
                                    this.dsZ = true;
                                    Yk();
                                    this.mTimer.cancel();
                                    AppMethodBeat.o(9160);
                                }

                                private com.tencent.mm.z.c x(float f2, float f3) {
                                    com.tencent.mm.z.c cVar;
                                    AppMethodBeat.i(9161);
                                    if (XU() == null) {
                                        Log.e("MicroMsg.EmojiAndTextArtist", "[isContainsItem] getCache is null!");
                                        AppMethodBeat.o(9161);
                                        return null;
                                    }
                                    ListIterator<com.tencent.mm.z.c> alJ = ((d) XU()).alJ();
                                    while (true) {
                                        if (!alJ.hasPrevious()) {
                                            cVar = null;
                                            break;
                                        }
                                        cVar = alJ.previous();
                                        float[] v = v(f2, f3);
                                        if (cVar.z(v[0], v[1])) {
                                            break;
                                        }
                                    }
                                    AppMethodBeat.o(9161);
                                    return cVar;
                                }

                                private com.tencent.mm.z.c Yi() {
                                    com.tencent.mm.z.c cVar = null;
                                    AppMethodBeat.i(9162);
                                    d dVar = (d) XU();
                                    if (dVar == null) {
                                        AppMethodBeat.o(9162);
                                    } else {
                                        ListIterator<com.tencent.mm.z.c> alJ = dVar.alJ();
                                        while (alJ.hasPrevious()) {
                                            com.tencent.mm.z.c previous = alJ.previous();
                                            if (previous.gwn) {
                                                cVar = previous;
                                            }
                                            previous.setSelected(false);
                                        }
                                        AppMethodBeat.o(9162);
                                    }
                                    return cVar;
                                }

                                /* access modifiers changed from: package-private */
                                public class a extends TimerTask {
                                    private b dtk;
                                    private Handler mHandler = new Handler(Looper.getMainLooper());

                                    public a(b bVar) {
                                        AppMethodBeat.i(9154);
                                        this.dtk = bVar;
                                        AppMethodBeat.o(9154);
                                    }

                                    public final void run() {
                                        AppMethodBeat.i(9155);
                                        this.mHandler.post(new Runnable() {
                                            /* class com.tencent.mm.e.e.a.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(9153);
                                                Log.d("MicroMsg.EmojiAndTextArtist", "cancel focus!");
                                                if (e.this.XU() == null) {
                                                    AppMethodBeat.o(9153);
                                                    return;
                                                }
                                                com.tencent.mm.z.c alI = ((d) e.this.XU()).alI();
                                                if (alI != null && alI.gwn) {
                                                    alI.setSelected(false);
                                                    a.this.dtk.cT(false);
                                                    a.this.dtk.Yb();
                                                }
                                                AppMethodBeat.o(9153);
                                            }
                                        });
                                        AppMethodBeat.o(9155);
                                    }
                                }

                                private void Yj() {
                                    AppMethodBeat.i(9163);
                                    Log.d("MicroMsg.EmojiAndTextArtist", "[registerFocusTask]");
                                    if (this.dta != null) {
                                        this.dta.cancel();
                                    }
                                    if (this.dsZ) {
                                        Log.w("MicroMsg.EmojiAndTextArtist", "[registerFocusTask] isTimerCancel=true");
                                        AppMethodBeat.o(9163);
                                        return;
                                    }
                                    this.dta = new a(this);
                                    this.mTimer.schedule(this.dta, 1500);
                                    AppMethodBeat.o(9163);
                                }

                                private void Yk() {
                                    AppMethodBeat.i(9164);
                                    Log.d("MicroMsg.EmojiAndTextArtist", "[unRegisterFocusTask]");
                                    if (this.dta != null) {
                                        this.dta.cancel();
                                    }
                                    AppMethodBeat.o(9164);
                                }

                                public final void a(SpannableString spannableString, int i2, int i3) {
                                    AppMethodBeat.i(9165);
                                    Log.i("MicroMsg.EmojiAndTextArtist", "[addItem] text:%s", spannableString);
                                    if (Util.isNullOrNil(spannableString)) {
                                        AppMethodBeat.o(9165);
                                        return;
                                    }
                                    d dVar = (d) XU();
                                    if (dVar == null) {
                                        Log.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
                                        AppMethodBeat.o(9165);
                                        return;
                                    }
                                    Yk();
                                    Yi();
                                    cT(false);
                                    Rect boardRect = getBoardRect();
                                    f fVar = new f(MMApplicationContext.getContext(), getMainMatrix(), new StringBuilder().append(dVar.ai(true)).toString(), boardRect, spannableString, i2, i3);
                                    fVar.setSelected(true);
                                    fVar.hop = true;
                                    float[] v = v((float) boardRect.centerX(), (float) boardRect.centerY());
                                    fVar.a(v[0], v[1], this.drS.getInitScale() / this.drS.getCurScale(), (int) getRotation());
                                    dVar.a(fVar);
                                    Yb();
                                    Yj();
                                    AppMethodBeat.o(9165);
                                }

                                public final void b(r rVar) {
                                    AppMethodBeat.i(9166);
                                    Log.i("MicroMsg.EmojiAndTextArtist", "[addEmojiItem] item:%s", rVar);
                                    d dVar = (d) XU();
                                    if (dVar == null) {
                                        Log.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
                                        AppMethodBeat.o(9166);
                                        return;
                                    }
                                    Yk();
                                    Yi();
                                    cT(false);
                                    Rect boardRect = getBoardRect();
                                    com.tencent.mm.z.c cVar = new com.tencent.mm.z.c(MMApplicationContext.getContext(), getMainMatrix(), new StringBuilder().append(dVar.ai(true)).toString(), rVar, boardRect);
                                    cVar.setSelected(true);
                                    float[] v = v((float) boardRect.centerX(), (float) boardRect.centerY());
                                    cVar.a(v[0], v[1], this.drS.getInitScale() / this.drS.getCurScale(), (int) getRotation());
                                    dVar.a(cVar);
                                    Yb();
                                    Yj();
                                    AppMethodBeat.o(9166);
                                }

                                public final void a(f fVar, SpannableString spannableString, int i2, int i3) {
                                    AppMethodBeat.i(9167);
                                    d dVar = (d) XU();
                                    if (dVar == null) {
                                        Log.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
                                        AppMethodBeat.o(9167);
                                        return;
                                    }
                                    String str = fVar.hoh;
                                    Log.i("MicroMsg.EmojiAndTextCache", "[delete] id:%s", str);
                                    if (dVar.gpx != null && dVar.gpx.size() > 0) {
                                        com.tencent.mm.z.c peek = dVar.gpx.peek();
                                        if (peek.hoh.equalsIgnoreCase(str)) {
                                            dVar.gpx.pop();
                                        } else {
                                            Log.e("MicroMsg.EmojiAndTextCache", "[delete] id:%s emojiItem:%s", str, peek);
                                        }
                                    }
                                    fVar.setSelected(true);
                                    fVar.hop = true;
                                    Yk();
                                    Yi();
                                    cT(true);
                                    if (!Util.isNullOrNil(spannableString)) {
                                        f fVar2 = new f(MMApplicationContext.getContext(), getMainMatrix(), new StringBuilder().append(dVar.ai(true)).toString(), getBoardRect(), spannableString, i2, i3);
                                        fVar2.setSelected(true);
                                        PointF pointF = fVar.hok;
                                        fVar2.a(pointF.x, pointF.y, this.drS.getInitScale() / this.drS.getCurScale(), fVar.mRotation);
                                        fVar2.dhh = fVar.dhh;
                                        dVar.a(fVar2);
                                    }
                                    Yb();
                                    Yj();
                                    AppMethodBeat.o(9167);
                                }
                            }
