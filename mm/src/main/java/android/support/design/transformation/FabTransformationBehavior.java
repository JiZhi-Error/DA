package android.support.design.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.design.a.e;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.design.a.j;
import android.support.design.circularreveal.c;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.k;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.ArrayList;
import java.util.List;

public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    private final Rect mC;
    private final RectF mD;
    private final RectF mE;
    private final int[] mF;

    /* access modifiers changed from: protected */
    public abstract a h(Context context, boolean z);

    public FabTransformationBehavior() {
        this.mC = new Rect();
        this.mD = new RectF();
        this.mE = new RectF();
        this.mF = new int[2];
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mC = new Rect();
        this.mD = new RectF();
        this.mE = new RectF();
        this.mF = new int[2];
    }

    @Override // android.support.design.transformation.ExpandableBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public final boolean a(View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        } else if (!(view2 instanceof FloatingActionButton)) {
            return false;
        } else {
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            if (expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId()) {
                return true;
            }
            return false;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final void a(CoordinatorLayout.d dVar) {
        if (dVar.qH == 0) {
            dVar.qH = 80;
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.design.transformation.ExpandableTransformationBehavior
    public final AnimatorSet b(final View view, final View view2, final boolean z, boolean z2) {
        i iVar;
        i iVar2;
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ViewGroup e2;
        ObjectAnimator ofFloat3;
        int i2;
        ObjectAnimator ofInt;
        Animator animator;
        ObjectAnimator ofInt2;
        ObjectAnimator ofFloat4;
        a h2 = h(view2.getContext(), z);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            float al = u.al(view2) - u.al(view);
            if (z) {
                if (!z2) {
                    view2.setTranslationZ(-al);
                }
                ofFloat4 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, 0.0f);
            } else {
                ofFloat4 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, -al);
            }
            h2.mM.j("elevation").a((Animator) ofFloat4);
            arrayList.add(ofFloat4);
        }
        RectF rectF = this.mD;
        float a2 = a(view, view2, h2.mN);
        float b2 = b(view, view2, h2.mN);
        if (a2 == 0.0f || b2 == 0.0f) {
            i j2 = h2.mM.j("translationXLinear");
            iVar2 = h2.mM.j("translationYLinear");
            iVar = j2;
        } else if ((!z || b2 >= 0.0f) && (z || b2 <= 0.0f)) {
            i j3 = h2.mM.j("translationXCurveDownwards");
            iVar2 = h2.mM.j("translationYCurveDownwards");
            iVar = j3;
        } else {
            i j4 = h2.mM.j("translationXCurveUpwards");
            iVar2 = h2.mM.j("translationYCurveUpwards");
            iVar = j4;
        }
        if (z) {
            if (!z2) {
                view2.setTranslationX(-a2);
                view2.setTranslationY(-b2);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f);
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f);
            float a3 = a(h2, iVar, -a2);
            float a4 = a(h2, iVar2, -b2);
            Rect rect = this.mC;
            view2.getWindowVisibleDisplayFrame(rect);
            RectF rectF2 = this.mD;
            rectF2.set(rect);
            RectF rectF3 = this.mE;
            a(view2, rectF3);
            rectF3.offset(a3, a4);
            rectF3.intersect(rectF2);
            rectF.set(rectF3);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, -a2);
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, -b2);
        }
        iVar.a((Animator) ofFloat);
        iVar2.a((Animator) ofFloat2);
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        float width = rectF.width();
        float height = rectF.height();
        if ((view2 instanceof c) && (view instanceof ImageView)) {
            final c cVar = (c) view2;
            final Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z) {
                    if (!z2) {
                        drawable.setAlpha(255);
                    }
                    ofInt2 = ObjectAnimator.ofInt(drawable, e.gR, 0);
                } else {
                    ofInt2 = ObjectAnimator.ofInt(drawable, e.gR, 255);
                }
                ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class android.support.design.transformation.FabTransformationBehavior.AnonymousClass2 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        view2.invalidate();
                    }
                });
                h2.mM.j("iconFade").a((Animator) ofInt2);
                arrayList.add(ofInt2);
                arrayList2.add(new AnimatorListenerAdapter() {
                    /* class android.support.design.transformation.FabTransformationBehavior.AnonymousClass3 */

                    public final void onAnimationStart(Animator animator) {
                        cVar.setCircularRevealOverlayDrawable(drawable);
                    }

                    public final void onAnimationEnd(Animator animator) {
                        cVar.setCircularRevealOverlayDrawable(null);
                    }
                });
            }
        }
        if (view2 instanceof c) {
            final c cVar2 = (c) view2;
            j jVar = h2.mN;
            RectF rectF4 = this.mD;
            RectF rectF5 = this.mE;
            a(view, rectF4);
            a(view2, rectF5);
            rectF5.offset(-a(view, view2, jVar), 0.0f);
            float centerX = rectF4.centerX() - rectF5.left;
            j jVar2 = h2.mN;
            RectF rectF6 = this.mD;
            RectF rectF7 = this.mE;
            a(view, rectF6);
            a(view2, rectF7);
            rectF7.offset(0.0f, -b(view, view2, jVar2));
            float centerY = rectF6.centerY() - rectF7.top;
            ((FloatingActionButton) view).b(this.mC);
            float width2 = ((float) this.mC.width()) / 2.0f;
            i j5 = h2.mM.j("expansion");
            if (z) {
                if (!z2) {
                    cVar2.setRevealInfo(new c.d(centerX, centerY, width2));
                }
                float f2 = z2 ? cVar2.getRevealInfo().radius : width2;
                Animator a5 = android.support.design.circularreveal.a.a(cVar2, centerX, centerY, k.c(centerX, centerY, width, height));
                a5.addListener(new AnimatorListenerAdapter() {
                    /* class android.support.design.transformation.FabTransformationBehavior.AnonymousClass4 */

                    public final void onAnimationEnd(Animator animator) {
                        c.d revealInfo = cVar2.getRevealInfo();
                        revealInfo.radius = Float.MAX_VALUE;
                        cVar2.setRevealInfo(revealInfo);
                    }
                });
                a(view2, j5.gY, (int) centerX, (int) centerY, f2, arrayList);
                animator = a5;
            } else {
                float f3 = cVar2.getRevealInfo().radius;
                Animator a6 = android.support.design.circularreveal.a.a(cVar2, centerX, centerY, width2);
                a(view2, j5.gY, (int) centerX, (int) centerY, f3, arrayList);
                long j6 = j5.gY;
                long j7 = j5.duration;
                long totalDuration = h2.mM.getTotalDuration();
                int i3 = (int) centerX;
                int i4 = (int) centerY;
                if (Build.VERSION.SDK_INT >= 21 && j6 + j7 < totalDuration) {
                    Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view2, i3, i4, width2, width2);
                    createCircularReveal.setStartDelay(j6 + j7);
                    createCircularReveal.setDuration(totalDuration - (j6 + j7));
                    arrayList.add(createCircularReveal);
                }
                animator = a6;
            }
            j5.a(animator);
            arrayList.add(animator);
            arrayList2.add(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01dc: INVOKE  
                  (r15v0 'arrayList2' java.util.ArrayList)
                  (wrap: android.support.design.circularreveal.a$1 : 0x01d9: CONSTRUCTOR  (r5v43 android.support.design.circularreveal.a$1) = (r4v41 'cVar2' android.support.design.circularreveal.c) call: android.support.design.circularreveal.a.1.<init>(android.support.design.circularreveal.c):void type: CONSTRUCTOR)
                 type: INTERFACE call: java.util.List.add(java.lang.Object):boolean in method: android.support.design.transformation.FabTransformationBehavior.b(android.view.View, android.view.View, boolean, boolean):android.animation.AnimatorSet, file: classes6.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01d9: CONSTRUCTOR  (r5v43 android.support.design.circularreveal.a$1) = (r4v41 'cVar2' android.support.design.circularreveal.c) call: android.support.design.circularreveal.a.1.<init>(android.support.design.circularreveal.c):void type: CONSTRUCTOR in method: android.support.design.transformation.FabTransformationBehavior.b(android.view.View, android.view.View, boolean, boolean):android.animation.AnimatorSet, file: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 19 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: android.support.design.circularreveal.a, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 25 more
                */
            /*
            // Method dump skipped, instructions count: 1032
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.design.transformation.FabTransformationBehavior.b(android.view.View, android.view.View, boolean, boolean):android.animation.AnimatorSet");
        }

        private float a(View view, View view2, j jVar) {
            RectF rectF = this.mD;
            RectF rectF2 = this.mE;
            a(view, rectF);
            a(view2, rectF2);
            float f2 = 0.0f;
            switch (jVar.gravity & 7) {
                case 1:
                    f2 = rectF2.centerX() - rectF.centerX();
                    break;
                case 3:
                    f2 = rectF2.left - rectF.left;
                    break;
                case 5:
                    f2 = rectF2.right - rectF.right;
                    break;
            }
            return f2 + jVar.ha;
        }

        private float b(View view, View view2, j jVar) {
            RectF rectF = this.mD;
            RectF rectF2 = this.mE;
            a(view, rectF);
            a(view2, rectF2);
            float f2 = 0.0f;
            switch (jVar.gravity & 112) {
                case 16:
                    f2 = rectF2.centerY() - rectF.centerY();
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                    f2 = rectF2.top - rectF.top;
                    break;
                case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                    f2 = rectF2.bottom - rectF.bottom;
                    break;
            }
            return f2 + jVar.hb;
        }

        private void a(View view, RectF rectF) {
            rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
            int[] iArr = this.mF;
            view.getLocationInWindow(iArr);
            rectF.offsetTo((float) iArr[0], (float) iArr[1]);
            rectF.offset((float) ((int) (-view.getTranslationX())), (float) ((int) (-view.getTranslationY())));
        }

        private static ViewGroup e(View view) {
            if (view instanceof ViewGroup) {
                return (ViewGroup) view;
            }
            return null;
        }

        private static void a(View view, long j2, int i2, int i3, float f2, List<Animator> list) {
            if (Build.VERSION.SDK_INT >= 21 && j2 > 0) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
                createCircularReveal.setStartDelay(0);
                createCircularReveal.setDuration(j2);
                list.add(createCircularReveal);
            }
        }

        /* access modifiers changed from: protected */
        public static class a {
            public h mM;
            public j mN;

            protected a() {
            }
        }

        private static float a(a aVar, i iVar, float f2) {
            long j2 = iVar.gY;
            long j3 = iVar.duration;
            i j4 = aVar.mM.j("expansion");
            return android.support.design.a.a.lerp(f2, 0.0f, iVar.getInterpolator().getInterpolation(((float) (((j4.duration + j4.gY) + 17) - j2)) / ((float) j3)));
        }
    }
