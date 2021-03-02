package com.tencent.mm.view.b;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import com.tencent.mm.c.d;
import com.tencent.mm.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.WebView;

public final class c extends a {
    private d RnT = new d(this);
    private PointF RnU = new PointF();
    private float RnV = 0.0f;
    private boolean RnW = false;
    public boolean RnX = false;
    private float mOR = 0.0f;

    public c(Context context, b bVar) {
        super(context, bVar);
        AppMethodBeat.i(9394);
        AppMethodBeat.o(9394);
    }

    @Override // com.tencent.mm.view.b.a
    public final boolean hgb() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.b.a
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(9395);
        canvas.drawColor(WebView.NIGHT_MODE_COLOR);
        if (this.Rnv != null) {
            this.drT.set(this.Rnv);
            canvas.setMatrix(this.Rnv);
        } else {
            canvas.setMatrix(getMainMatrix());
        }
        canvas.save();
        canvas.clipRect(getAliveRect());
        Bitmap gtm = getPresenter().gtm();
        if (gtm != null && !gtm.isRecycled()) {
            canvas.drawBitmap(gtm, 0.0f, 0.0f, (Paint) null);
        }
        canvas.restore();
        getPresenter().onDraw(canvas);
        AppMethodBeat.o(9395);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.b.a
    public final void aA(MotionEvent motionEvent) {
        float f2;
        AppMethodBeat.i(9396);
        float x = motionEvent.getX(motionEvent.getPointerCount() - 1);
        float y = motionEvent.getY(motionEvent.getPointerCount() - 1);
        if (!getPresenter().gte()) {
            AppMethodBeat.o(9396);
            return;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.RnU.set(x, y);
                this.RnV = 0.0f;
                this.mOR = getCurScale();
                d dVar = this.RnT;
                Log.d("MicroMsg.StickRoundAnim", "[cancel]");
                if (dVar.dgN != null && (dVar.dgN.isRunning() || dVar.dgN.isStarted())) {
                    dVar.dgN.cancel();
                }
                this.RnX = false;
                break;
            case 1:
                this.RnV = 0.0f;
                if (this.RnX) {
                    d dVar2 = this.RnT;
                    if (dVar2.dgZ) {
                        Log.d("MicroMsg.StickRoundAnim", "[play] start");
                        RectF curImageRect = dVar2.dhg.getCurImageRect();
                        Rect boardRect = dVar2.dhg.getBoardRect();
                        dVar2.dhi = curImageRect.centerX();
                        dVar2.dhj = curImageRect.centerY();
                        float centerY = ((float) boardRect.centerY()) - curImageRect.centerY();
                        float centerX = ((float) boardRect.centerX()) - curImageRect.centerX();
                        float curScale = dVar2.dhg.getCurScale();
                        float maxScale = dVar2.dhg.getMaxScale();
                        float minScale = dVar2.dhg.getMinScale();
                        if (curScale > maxScale) {
                            dVar2.dhh = maxScale;
                            dVar2.dhk = true;
                        } else if (curScale < minScale) {
                            dVar2.dhh = minScale;
                            dVar2.dhk = true;
                        } else {
                            dVar2.dhk = false;
                        }
                        boolean z = ((float) boardRect.height()) < curImageRect.height();
                        boolean z2 = ((float) boardRect.width()) < curImageRect.width();
                        if (z) {
                            centerY = 0.0f;
                        }
                        if (z2) {
                            centerX = 0.0f;
                        }
                        if (curImageRect.top > ((float) boardRect.top) && z) {
                            f2 = ((float) boardRect.top) - curImageRect.top;
                        } else if (curImageRect.bottom >= ((float) boardRect.bottom) || !z) {
                            f2 = centerY;
                        } else {
                            f2 = ((float) boardRect.bottom) - curImageRect.bottom;
                        }
                        if (curImageRect.left > ((float) boardRect.left) && z2) {
                            centerX = ((float) boardRect.left) - curImageRect.left;
                        } else if (curImageRect.right < ((float) boardRect.right) && z2) {
                            centerX = ((float) boardRect.right) - curImageRect.right;
                        }
                        Log.d("MicroMsg.StickRoundAnim", "%s %s ", Float.valueOf(centerX), Float.valueOf(f2));
                        if (curScale > maxScale) {
                            dVar2.dhl = true;
                        } else {
                            dVar2.dhl = false;
                        }
                        dVar2.dgN = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("deltaY", 0.0f, f2), PropertyValuesHolder.ofFloat("deltaX", 0.0f, centerX), PropertyValuesHolder.ofFloat("scale", 0.0f, 80.0f));
                        dVar2.dgN.addUpdateListener(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0180: INVOKE  
                              (wrap: android.animation.ValueAnimator : 0x0179: IGET  (r0v69 android.animation.ValueAnimator) = (r6v0 'dVar2' com.tencent.mm.c.d) com.tencent.mm.c.d.dgN android.animation.ValueAnimator)
                              (wrap: com.tencent.mm.c.d$1 : 0x017d: CONSTRUCTOR  (r1v31 com.tencent.mm.c.d$1) = (r6v0 'dVar2' com.tencent.mm.c.d), (r9v0 'curScale' float) call: com.tencent.mm.c.d.1.<init>(com.tencent.mm.c.d, float):void type: CONSTRUCTOR)
                             type: VIRTUAL call: android.animation.ValueAnimator.addUpdateListener(android.animation.ValueAnimator$AnimatorUpdateListener):void in method: com.tencent.mm.view.b.c.aA(android.view.MotionEvent):void, file: classes7.dex
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
                            	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:274)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x017d: CONSTRUCTOR  (r1v31 com.tencent.mm.c.d$1) = (r6v0 'dVar2' com.tencent.mm.c.d), (r9v0 'curScale' float) call: com.tencent.mm.c.d.1.<init>(com.tencent.mm.c.d, float):void type: CONSTRUCTOR in method: com.tencent.mm.view.b.c.aA(android.view.MotionEvent):void, file: classes7.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 33 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.c.d, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 39 more
                            */
                        /*
                        // Method dump skipped, instructions count: 692
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.view.b.c.aA(android.view.MotionEvent):void");
                    }

                    private void translate(float f2, float f3) {
                        AppMethodBeat.i(9397);
                        RectF curImageRect = getCurImageRect();
                        float f4 = f2 - this.RnU.x;
                        float f5 = f3 - this.RnU.y;
                        if (f4 > 0.0f) {
                            if (((float) getBoardRect().left) <= curImageRect.left) {
                                f4 *= 0.5f;
                            } else if (Math.abs(f4) > Math.abs(curImageRect.left - ((float) getBoardRect().left))) {
                                f4 = ((float) getBoardRect().left) - curImageRect.left;
                            }
                        } else if (((float) getBoardRect().right) >= curImageRect.right) {
                            f4 *= 0.5f;
                        } else if (Math.abs(f4) > Math.abs(((float) getBoardRect().right) - curImageRect.right)) {
                            f4 = ((float) getBoardRect().right) - curImageRect.right;
                        }
                        if (f5 > 0.0f) {
                            if (((float) getBoardRect().top) <= curImageRect.top) {
                                f5 *= 0.5f;
                            } else if (Math.abs(f5) > Math.abs(curImageRect.top - ((float) getBoardRect().top))) {
                                f5 = ((float) getBoardRect().top) - curImageRect.top;
                            }
                        } else if (((float) getBoardRect().bottom) >= curImageRect.bottom) {
                            f5 *= 0.5f;
                        } else if (Math.abs(f5) > Math.abs(((float) getBoardRect().bottom) - curImageRect.bottom)) {
                            f5 = ((float) getBoardRect().bottom) - curImageRect.bottom;
                        }
                        getMainMatrix().postTranslate(f4, f5);
                        AppMethodBeat.o(9397);
                    }

                    @Override // com.tencent.mm.view.b.a
                    public final float getMinScale() {
                        AppMethodBeat.i(9398);
                        if (getPresenter().gti().XS() == a.CROP_PHOTO) {
                            float width = ((float) getBoardRect().width()) / getCurImageRect().width();
                            float height = ((float) getBoardRect().height()) / getCurImageRect().height();
                            if (width <= height) {
                                width = height;
                            }
                            float curScale = width * getCurScale();
                            AppMethodBeat.o(9398);
                            return curScale;
                        }
                        float minScale = super.getMinScale();
                        AppMethodBeat.o(9398);
                        return minScale;
                    }
                }
