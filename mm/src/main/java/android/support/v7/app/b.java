package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.u;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AlertController;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.tencent.mm.R;

public final class b extends e implements DialogInterface {
    final AlertController Yt = new AlertController(getContext(), this, getWindow());

    protected b(Context context, int i2) {
        super(context, o(context, i2));
    }

    static int o(Context context, int i2) {
        if (((i2 >>> 24) & 255) > 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.b6, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // android.support.v7.app.e, android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.Yt.setTitle(charSequence);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.e
    public final void onCreate(Bundle bundle) {
        int i2;
        View view;
        boolean z;
        boolean z2;
        View findViewById;
        int i3;
        int i4;
        View findViewById2;
        super.onCreate(bundle);
        AlertController alertController = this.Yt;
        if (alertController.XD == 0 || alertController.XJ != 1) {
            i2 = alertController.XC;
        } else {
            i2 = alertController.XD;
        }
        alertController.WY.setContentView(i2);
        View findViewById3 = alertController.WZ.findViewById(R.id.g8n);
        View findViewById4 = findViewById3.findViewById(R.id.isd);
        View findViewById5 = findViewById3.findViewById(R.id.bec);
        View findViewById6 = findViewById3.findViewById(R.id.agh);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R.id.bjm);
        if (alertController.mView != null) {
            view = alertController.mView;
        } else if (alertController.Xc != 0) {
            view = LayoutInflater.from(alertController.mContext).inflate(alertController.Xc, viewGroup, false);
        } else {
            view = null;
        }
        boolean z3 = view != null;
        if (!z3 || !AlertController.aZ(view)) {
            alertController.WZ.setFlags(131072, 131072);
        }
        if (z3) {
            FrameLayout frameLayout = (FrameLayout) alertController.WZ.findViewById(R.id.bjl);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (alertController.Xh) {
                frameLayout.setPadding(alertController.Xd, alertController.Xe, alertController.Xf, alertController.Xg);
            }
            if (alertController.mListView != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById7 = viewGroup.findViewById(R.id.isd);
        View findViewById8 = viewGroup.findViewById(R.id.bec);
        View findViewById9 = viewGroup.findViewById(R.id.agh);
        ViewGroup d2 = AlertController.d(findViewById7, findViewById4);
        ViewGroup d3 = AlertController.d(findViewById8, findViewById5);
        ViewGroup d4 = AlertController.d(findViewById9, findViewById6);
        alertController.Xu = (NestedScrollView) alertController.WZ.findViewById(R.id.hcl);
        alertController.Xu.setFocusable(false);
        alertController.Xu.setNestedScrollingEnabled(false);
        alertController.Xz = (TextView) d3.findViewById(16908299);
        if (alertController.Xz != null) {
            if (alertController.Xb != null) {
                alertController.Xz.setText(alertController.Xb);
            } else {
                alertController.Xz.setVisibility(8);
                alertController.Xu.removeView(alertController.Xz);
                if (alertController.mListView != null) {
                    ViewGroup viewGroup2 = (ViewGroup) alertController.Xu.getParent();
                    int indexOfChild = viewGroup2.indexOfChild(alertController.Xu);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(alertController.mListView, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    d3.setVisibility(8);
                }
            }
        }
        boolean z4 = false;
        alertController.Xi = (Button) d4.findViewById(16908313);
        alertController.Xi.setOnClickListener(alertController.XK);
        if (!TextUtils.isEmpty(alertController.Xj) || alertController.Xl != null) {
            alertController.Xi.setText(alertController.Xj);
            if (alertController.Xl != null) {
                alertController.Xl.setBounds(0, 0, alertController.Xa, alertController.Xa);
                alertController.Xi.setCompoundDrawables(alertController.Xl, null, null, null);
            }
            alertController.Xi.setVisibility(0);
            z4 = true;
        } else {
            alertController.Xi.setVisibility(8);
        }
        alertController.Xm = (Button) d4.findViewById(16908314);
        alertController.Xm.setOnClickListener(alertController.XK);
        if (!TextUtils.isEmpty(alertController.Xn) || alertController.Xp != null) {
            alertController.Xm.setText(alertController.Xn);
            if (alertController.Xp != null) {
                alertController.Xp.setBounds(0, 0, alertController.Xa, alertController.Xa);
                alertController.Xm.setCompoundDrawables(alertController.Xp, null, null, null);
            }
            alertController.Xm.setVisibility(0);
            z4 |= true;
        } else {
            alertController.Xm.setVisibility(8);
        }
        alertController.Xq = (Button) d4.findViewById(16908315);
        alertController.Xq.setOnClickListener(alertController.XK);
        if (!TextUtils.isEmpty(alertController.Xr) || alertController.Xt != null) {
            alertController.Xq.setText(alertController.Xr);
            if (alertController.Xl != null) {
                alertController.Xl.setBounds(0, 0, alertController.Xa, alertController.Xa);
                alertController.Xi.setCompoundDrawables(alertController.Xl, null, null, null);
            }
            alertController.Xq.setVisibility(0);
            z4 |= true;
        } else {
            alertController.Xq.setVisibility(8);
        }
        Context context = alertController.mContext;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.b4, typedValue, true);
        if (typedValue.data != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (z4) {
                AlertController.a(alertController.Xi);
            } else if (z4) {
                AlertController.a(alertController.Xm);
            } else if (z4) {
                AlertController.a(alertController.Xq);
            }
        }
        if (!(z4)) {
            d4.setVisibility(8);
        }
        if (alertController.XA != null) {
            d2.addView(alertController.XA, 0, new ViewGroup.LayoutParams(-1, -2));
            alertController.WZ.findViewById(R.id.iqy).setVisibility(8);
        } else {
            alertController.Xx = (ImageView) alertController.WZ.findViewById(16908294);
            if (!(!TextUtils.isEmpty(alertController.Hn)) || !alertController.XI) {
                alertController.WZ.findViewById(R.id.iqy).setVisibility(8);
                alertController.Xx.setVisibility(8);
                d2.setVisibility(8);
            } else {
                alertController.Xy = (TextView) alertController.WZ.findViewById(R.id.li);
                alertController.Xy.setText(alertController.Hn);
                if (alertController.Xv != 0) {
                    alertController.Xx.setImageResource(alertController.Xv);
                } else if (alertController.Xw != null) {
                    alertController.Xx.setImageDrawable(alertController.Xw);
                } else {
                    alertController.Xy.setPadding(alertController.Xx.getPaddingLeft(), alertController.Xx.getPaddingTop(), alertController.Xx.getPaddingRight(), alertController.Xx.getPaddingBottom());
                    alertController.Xx.setVisibility(8);
                }
            }
        }
        boolean z5 = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z6 = (d2 == null || d2.getVisibility() == 8) ? false : true;
        if (d4 == null || d4.getVisibility() == 8) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!(z2 || d3 == null || (findViewById2 = d3.findViewById(R.id.ijt)) == null)) {
            findViewById2.setVisibility(0);
        }
        if (z6) {
            if (alertController.Xu != null) {
                alertController.Xu.setClipToPadding(true);
            }
            View view2 = null;
            if (!(alertController.Xb == null && alertController.mListView == null)) {
                view2 = d2.findViewById(R.id.ipn);
            }
            if (view2 != null) {
                view2.setVisibility(0);
            }
        } else if (!(d3 == null || (findViewById = d3.findViewById(R.id.iju)) == null)) {
            findViewById.setVisibility(0);
        }
        if (alertController.mListView instanceof AlertController.RecycleListView) {
            AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) alertController.mListView;
            if (!z2 || !z6) {
                recycleListView.setPadding(recycleListView.getPaddingLeft(), z6 ? recycleListView.getPaddingTop() : recycleListView.Yr, recycleListView.getPaddingRight(), z2 ? recycleListView.getPaddingBottom() : recycleListView.Ys);
            }
        }
        if (!z5) {
            ViewGroup viewGroup3 = alertController.mListView != null ? alertController.mListView : alertController.Xu;
            if (viewGroup3 != null) {
                if (z6) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (z2) {
                    i4 = 2;
                } else {
                    i4 = 0;
                }
                int i5 = i3 | i4;
                View findViewById10 = alertController.WZ.findViewById(R.id.hck);
                View findViewById11 = alertController.WZ.findViewById(R.id.hcj);
                if (Build.VERSION.SDK_INT >= 23) {
                    u.w(viewGroup3, i5);
                    if (findViewById10 != null) {
                        d3.removeView(findViewById10);
                    }
                    if (findViewById11 != null) {
                        d3.removeView(findViewById11);
                    }
                } else {
                    if (findViewById10 != null && (i5 & 1) == 0) {
                        d3.removeView(findViewById10);
                        findViewById10 = null;
                    }
                    if (findViewById11 != null && (i5 & 2) == 0) {
                        d3.removeView(findViewById11);
                        findViewById11 = null;
                    }
                    if (!(findViewById10 == null && findViewById11 == null)) {
                        if (alertController.Xb != null) {
                            alertController.Xu.setOnScrollChangeListener(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x043e: INVOKE  
                                  (wrap: android.support.v4.widget.NestedScrollView : 0x0437: IGET  (r2v38 android.support.v4.widget.NestedScrollView) = (r6v0 'alertController' android.support.v7.app.AlertController) android.support.v7.app.AlertController.Xu android.support.v4.widget.NestedScrollView)
                                  (wrap: android.support.v7.app.AlertController$2 : 0x043b: CONSTRUCTOR  (r3v7 android.support.v7.app.AlertController$2) = 
                                  (r6v0 'alertController' android.support.v7.app.AlertController)
                                  (r1v99 'findViewById10' android.view.View)
                                  (r0v23 'findViewById11' android.view.View)
                                 call: android.support.v7.app.AlertController.2.<init>(android.support.v7.app.AlertController, android.view.View, android.view.View):void type: CONSTRUCTOR)
                                 type: VIRTUAL call: android.support.v4.widget.NestedScrollView.setOnScrollChangeListener(android.support.v4.widget.NestedScrollView$b):void in method: android.support.v7.app.b.onCreate(android.os.Bundle):void, file: classes.dex
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
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
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
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x043b: CONSTRUCTOR  (r3v7 android.support.v7.app.AlertController$2) = 
                                  (r6v0 'alertController' android.support.v7.app.AlertController)
                                  (r1v99 'findViewById10' android.view.View)
                                  (r0v23 'findViewById11' android.view.View)
                                 call: android.support.v7.app.AlertController.2.<init>(android.support.v7.app.AlertController, android.view.View, android.view.View):void type: CONSTRUCTOR in method: android.support.v7.app.b.onCreate(android.os.Bundle):void, file: classes.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	... 39 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: android.support.v7.app.AlertController, state: GENERATED_AND_UNLOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	... 45 more
                                */
                            /*
                            // Method dump skipped, instructions count: 1139
                            */
                            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.b.onCreate(android.os.Bundle):void");
                        }

                        public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
                            boolean z;
                            AlertController alertController = this.Yt;
                            if (alertController.Xu == null || !alertController.Xu.executeKeyEvent(keyEvent)) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (z) {
                                return true;
                            }
                            return super.onKeyDown(i2, keyEvent);
                        }

                        public final boolean onKeyUp(int i2, KeyEvent keyEvent) {
                            boolean z;
                            AlertController alertController = this.Yt;
                            if (alertController.Xu == null || !alertController.Xu.executeKeyEvent(keyEvent)) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (z) {
                                return true;
                            }
                            return super.onKeyUp(i2, keyEvent);
                        }

                        public static class a {
                            public final AlertController.a Yu;
                            private final int mTheme;

                            public a(Context context) {
                                this(context, b.o(context, 0));
                            }

                            private a(Context context, int i2) {
                                this.Yu = new AlertController.a(new ContextThemeWrapper(context, b.o(context, i2)));
                                this.mTheme = i2;
                            }

                            public final b gz() {
                                int i2;
                                ListAdapter cVar;
                                b bVar = new b(this.Yu.mContext, this.mTheme);
                                AlertController.a aVar = this.Yu;
                                AlertController alertController = bVar.Yt;
                                if (aVar.XA != null) {
                                    alertController.XA = aVar.XA;
                                } else {
                                    if (aVar.Hn != null) {
                                        alertController.setTitle(aVar.Hn);
                                    }
                                    if (aVar.Xw != null) {
                                        Drawable drawable = aVar.Xw;
                                        alertController.Xw = drawable;
                                        alertController.Xv = 0;
                                        if (alertController.Xx != null) {
                                            if (drawable != null) {
                                                alertController.Xx.setVisibility(0);
                                                alertController.Xx.setImageDrawable(drawable);
                                            } else {
                                                alertController.Xx.setVisibility(8);
                                            }
                                        }
                                    }
                                    if (aVar.Xv != 0) {
                                        alertController.setIcon(aVar.Xv);
                                    }
                                    if (aVar.XO != 0) {
                                        int i3 = aVar.XO;
                                        TypedValue typedValue = new TypedValue();
                                        alertController.mContext.getTheme().resolveAttribute(i3, typedValue, true);
                                        alertController.setIcon(typedValue.resourceId);
                                    }
                                }
                                if (aVar.Xb != null) {
                                    CharSequence charSequence = aVar.Xb;
                                    alertController.Xb = charSequence;
                                    if (alertController.Xz != null) {
                                        alertController.Xz.setText(charSequence);
                                    }
                                }
                                if (!(aVar.XP == null && aVar.XQ == null)) {
                                    alertController.a(-1, aVar.XP, aVar.XR, null, aVar.XQ);
                                }
                                if (!(aVar.XS == null && aVar.XT == null)) {
                                    alertController.a(-2, aVar.XS, aVar.XU, null, aVar.XT);
                                }
                                if (!(aVar.XV == null && aVar.XW == null)) {
                                    alertController.a(-3, aVar.XV, aVar.XX, null, aVar.XW);
                                }
                                if (!(aVar.Yb == null && aVar.To == null && aVar.GO == null)) {
                                    AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) aVar.mInflater.inflate(alertController.XE, (ViewGroup) null);
                                    if (!aVar.Ye) {
                                        if (aVar.Yf) {
                                            i2 = alertController.XG;
                                        } else {
                                            i2 = alertController.XH;
                                        }
                                        if (aVar.To != null) {
                                            cVar = new SimpleCursorAdapter(aVar.mContext, i2, aVar.To, new String[]{aVar.Yh}, new int[]{16908308});
                                        } else if (aVar.GO != null) {
                                            cVar = aVar.GO;
                                        } else {
                                            cVar = new AlertController.c(aVar.mContext, i2, aVar.Yb);
                                        }
                                    } else if (aVar.To == null) {
                                        cVar = 
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0089: CONSTRUCTOR  (r1v54 'cVar' android.widget.ListAdapter) = 
                                              (r14v0 'aVar' android.support.v7.app.AlertController$a)
                                              (wrap: android.content.Context : 0x0082: IGET  (r3v7 android.content.Context) = (r14v0 'aVar' android.support.v7.app.AlertController$a) android.support.v7.app.AlertController.a.mContext android.content.Context)
                                              (wrap: int : 0x0084: IGET  (r4v3 int) = (r0v2 'alertController' android.support.v7.app.AlertController) android.support.v7.app.AlertController.XF int)
                                              (wrap: java.lang.CharSequence[] : 0x0086: IGET  (r5v2 java.lang.CharSequence[]) = (r14v0 'aVar' android.support.v7.app.AlertController$a) android.support.v7.app.AlertController.a.Yb java.lang.CharSequence[])
                                              (r6v1 'recycleListView' android.support.v7.app.AlertController$RecycleListView)
                                             call: android.support.v7.app.AlertController.a.1.<init>(android.support.v7.app.AlertController$a, android.content.Context, int, java.lang.CharSequence[], android.support.v7.app.AlertController$RecycleListView):void type: CONSTRUCTOR in method: android.support.v7.app.b.a.gz():android.support.v7.app.b, file: classes.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: android.support.v7.app.AlertController, state: GENERATED_AND_UNLOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                            	... 26 more
                                            */
                                        /*
                                        // Method dump skipped, instructions count: 465
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.b.a.gz():android.support.v7.app.b");
                                    }
                                }
                            }
