package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.Iterator;
import java.util.LinkedList;

public class a extends FrameLayout {
    public f oEB = new f();
    protected LinearLayout oEC;
    protected String oED;
    protected int oEE;
    protected int oEF;
    protected LinkedList<C0826a> oEG = new LinkedList<>();
    public LinkedList<Pair<d, d>> oEH = new LinkedList<>();
    private int oEI = 0;
    private b oEJ;

    public interface b {
        void aq(int i2, String str);
    }

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(135537);
        aVar.refreshView();
        AppMethodBeat.o(135537);
    }

    static /* synthetic */ void a(a aVar, Animator animator) {
        AppMethodBeat.i(135538);
        aVar.a(animator, (Runnable) null);
        AppMethodBeat.o(135538);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.tabbar.a$a  reason: collision with other inner class name */
    public static class C0826a {
        public String mText;
        public String mUrl;
        public d oEW;
        public d oEX;
        public boolean oEY = false;
        public boolean oEZ;
        public String oFa;
        public int oFb;
        public int oFc;

        public C0826a() {
            AppMethodBeat.i(135518);
            cde();
            AppMethodBeat.o(135518);
        }

        /* access modifiers changed from: package-private */
        public final void cde() {
            this.oEZ = false;
            this.oFa = "";
            this.oFb = 0;
            this.oFc = -1;
        }
    }

    public a(Context context) {
        super(context);
        AppMethodBeat.i(135519);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.oEC = new LinearLayout(context);
        this.oEC.setOrientation(0);
        this.oEC.setGravity(16);
        this.oEC.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        addView(this.oEC);
        AppMethodBeat.o(135519);
    }

    public void setPosition(String str) {
        this.oED = str;
    }

    public String getPosition() {
        return this.oED;
    }

    public final void j(final String str, final String str2, final String str3, final String str4) {
        AppMethodBeat.i(135520);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.widget.tabbar.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(135505);
                a.a(a.this, str, str2);
                a.b(a.this, str3, str4);
                a.a(a.this);
                AppMethodBeat.o(135505);
            }
        });
        AppMethodBeat.o(135520);
    }

    private void runOnUiThread(Runnable runnable) {
        AppMethodBeat.i(135521);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
            AppMethodBeat.o(135521);
            return;
        }
        post(runnable);
        AppMethodBeat.o(135521);
    }

    public void setClickListener(b bVar) {
        this.oEJ = bVar;
    }

    public final void a(String str, String str2, String str3, String str4, AppBrandTabBarItem appBrandTabBarItem) {
        AppMethodBeat.i(219635);
        C0826a aVar = new C0826a();
        aVar.oEW = new b(str3, new c() {
            /* class com.tencent.mm.plugin.appbrand.widget.tabbar.a.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.appbrand.widget.tabbar.c
            public final void a(String str, d dVar) {
                AppMethodBeat.i(135510);
                super.a(str, dVar);
                Log.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(str)));
                AppMethodBeat.o(135510);
            }
        });
        aVar.oEX = new b(str4, new c() {
            /* class com.tencent.mm.plugin.appbrand.widget.tabbar.a.AnonymousClass7 */

            @Override // com.tencent.mm.plugin.appbrand.widget.tabbar.c
            public final void a(String str, d dVar) {
                AppMethodBeat.i(135511);
                super.a(str, dVar);
                Log.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(str)));
                AppMethodBeat.o(135511);
            }
        });
        aVar.mText = str2;
        aVar.mUrl = str;
        this.oEH.add(new Pair<>(aVar.oEW, aVar.oEX));
        if (aVar.mText == null && (aVar.oEW.cdg() == null || aVar.oEX.cdg() == null)) {
            Log.e("MicroMsg.AppBrandPageTabBar", "illegal data");
            AppMethodBeat.o(219635);
            return;
        }
        if (appBrandTabBarItem == null) {
            appBrandTabBarItem = new AppBrandTabBarItem(getContext());
        }
        a(appBrandTabBarItem, aVar);
        appBrandTabBarItem.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.tabbar.a.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(135512);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/tabbar/AppBrandPageTabBar$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a.this.AI(a.this.oEC.indexOfChild(view));
                a.this.cdd();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/tabbar/AppBrandPageTabBar$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(135512);
            }
        });
        this.oEG.add(aVar);
        this.oEC.addView(appBrandTabBarItem);
        AppMethodBeat.o(219635);
    }

    public final void AI(int i2) {
        AppMethodBeat.i(135523);
        this.oEG.get(this.oEI).oEY = false;
        if (i2 <= 0 || i2 >= this.oEG.size()) {
            this.oEI = 0;
        } else {
            this.oEI = i2;
        }
        this.oEG.get(this.oEI).oEY = true;
        refreshView();
        AppMethodBeat.o(135523);
    }

    public final void a(int i2, String str, d dVar, d dVar2) {
        AppMethodBeat.i(135524);
        if (i2 >= this.oEG.size()) {
            AppMethodBeat.o(135524);
            return;
        }
        C0826a aVar = this.oEG.get(i2);
        if (str == null) {
            str = aVar.mText;
        }
        aVar.mText = str;
        if (dVar != null) {
            if (dVar.cdg() == null) {
                dVar = aVar.oEW;
            }
            aVar.oEW = dVar;
        }
        if (dVar2 != null) {
            if (dVar2.cdg() == null) {
                dVar2 = aVar.oEX;
            }
            aVar.oEX = dVar2;
        }
        refreshView();
        AppMethodBeat.o(135524);
    }

    public final void d(int i2, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(135525);
        int cu = g.cu(str3, 0);
        int cu2 = g.cu(str4, -1);
        for (int i3 = 0; i3 < this.oEG.size(); i3++) {
            if (i3 == i2) {
                this.oEG.get(i3).cde();
                if ("redDot".equals(str)) {
                    this.oEG.get(i3).oEZ = true;
                } else if ("text".equals(str)) {
                    this.oEG.get(i3).oFa = str2;
                    this.oEG.get(i3).oFb = cu;
                    this.oEG.get(i3).oFc = cu2;
                } else if ("none".equals(str)) {
                    this.oEG.get(i3).oEZ = false;
                    this.oEG.get(i3).oFa = "";
                }
            }
        }
        refreshView();
        AppMethodBeat.o(135525);
    }

    public final void eQ(final boolean z) {
        AppMethodBeat.i(135526);
        if (!MMHandlerThread.isMainThread()) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.widget.tabbar.a.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(135513);
                    a.this.eQ(z);
                    AppMethodBeat.o(135513);
                }
            });
            AppMethodBeat.o(135526);
            return;
        }
        float[] fArr = new float[2];
        fArr[0] = 0.0f;
        fArr[1] = (float) (("top".equals(this.oED) ? -1 : 1) * getHeight());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", fArr);
        ofFloat.setDuration(z ? 250 : 0);
        a(ofFloat, new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.widget.tabbar.a.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(135514);
                a.this.setVisibility(8);
                AppMethodBeat.o(135514);
            }
        });
        AppMethodBeat.o(135526);
    }

    public final void aD(boolean z) {
        AppMethodBeat.i(135527);
        float[] fArr = new float[2];
        fArr[0] = (float) (("top".equals(this.oED) ? -1 : 1) * getHeight());
        fArr[1] = 0.0f;
        final ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", fArr);
        ofFloat.setDuration(z ? 250 : 0);
        post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.widget.tabbar.a.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(135515);
                a.this.setVisibility(0);
                a.a(a.this, ofFloat);
                AppMethodBeat.o(135515);
            }
        });
        AppMethodBeat.o(135527);
    }

    private void a(Animator animator, final Runnable runnable) {
        AppMethodBeat.i(135528);
        animator.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.appbrand.widget.tabbar.a.AnonymousClass12 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(135516);
                if (runnable != null) {
                    a.this.post(runnable);
                }
                AppMethodBeat.o(135516);
            }
        });
        animator.start();
        AppMethodBeat.o(135528);
    }

    private void refreshView() {
        AppMethodBeat.i(135529);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.widget.tabbar.a.AnonymousClass13 */

            public final void run() {
                AppMethodBeat.i(135517);
                for (int i2 = 0; i2 < a.this.oEG.size(); i2++) {
                    a.this.a(a.this.oEC.getChildAt(i2), a.this.oEG.get(i2));
                }
                AppMethodBeat.o(135517);
            }
        });
        AppMethodBeat.o(135529);
    }

    /* access modifiers changed from: protected */
    public final void cdd() {
        AppMethodBeat.i(135530);
        if (this.oEJ != null) {
            this.oEJ.aq(this.oEI, this.oEG.get(this.oEI).mUrl);
        }
        AppMethodBeat.o(135530);
    }

    /* access modifiers changed from: protected */
    public final void a(View view, C0826a aVar) {
        AppMethodBeat.i(135531);
        final RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.r9);
        final ImageView imageView = (ImageView) view.findViewById(R.id.r_);
        final TextView textView = (TextView) view.findViewById(R.id.r8);
        final ImageView imageView2 = (ImageView) view.findViewById(R.id.rc);
        final TextView textView2 = (TextView) view.findViewById(R.id.rd);
        View findViewById = view.findViewById(R.id.rb);
        if ("top".equals(this.oED)) {
            view.setLayoutParams(new LinearLayout.LayoutParams(0, fromDPToPix(getContext(), 40), 1.0f));
            imageView.setVisibility(8);
            textView2.setTextSize(1, 14.0f);
            if (aVar.oEY) {
                findViewById.setBackgroundColor(this.oEF);
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(4);
            }
        } else {
            if (aVar.oEW.cdg() != null) {
                if (aVar.mText == null || aVar.mText.equals("")) {
                    view.setLayoutParams(new LinearLayout.LayoutParams(0, fromDPToPix(getContext(), 48), 1.0f));
                    imageView.setVisibility(0);
                    imageView.getLayoutParams().width = fromDPToPix(getContext(), 32);
                    imageView.getLayoutParams().height = fromDPToPix(getContext(), 28);
                    textView2.setVisibility(8);
                } else {
                    view.setLayoutParams(new LinearLayout.LayoutParams(0, fromDPToPix(getContext(), 54), 1.0f));
                    imageView.setVisibility(0);
                    imageView.getLayoutParams().width = fromDPToPix(getContext(), 32);
                    imageView.getLayoutParams().height = fromDPToPix(getContext(), 28);
                    textView2.setVisibility(0);
                    textView2.setTextSize(1, 12.0f);
                }
            } else if (aVar.mText != null && !aVar.mText.equals("")) {
                view.setLayoutParams(new LinearLayout.LayoutParams(0, fromDPToPix(getContext(), 49), 1.0f));
                imageView.setVisibility(8);
                textView2.setVisibility(0);
                textView2.setTextSize(1, 16.0f);
            }
            findViewById.setVisibility(4);
        }
        Drawable background = textView.getBackground();
        if (background != null) {
            background.setColorFilter(aVar.oFb, PorterDuff.Mode.SRC_ATOP);
        }
        textView.setVisibility(aVar.oFa.isEmpty() ? 4 : 0);
        textView.setText(aVar.oFa);
        textView.setTextColor(aVar.oFc);
        imageView2.setVisibility(aVar.oEZ ? 0 : 4);
        if (!aVar.oEY || aVar.oEX.cdg() == null) {
            aVar.oEW.a(new e() {
                /* class com.tencent.mm.plugin.appbrand.widget.tabbar.a.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.appbrand.widget.tabbar.e
                public final void a(Bitmap bitmap, d dVar) {
                    AppMethodBeat.i(135507);
                    super.a(bitmap, dVar);
                    a.this.b(bitmap, imageView);
                    AppMethodBeat.o(135507);
                }
            });
            aVar.oEW.cdf();
        } else {
            aVar.oEX.a(new e() {
                /* class com.tencent.mm.plugin.appbrand.widget.tabbar.a.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.widget.tabbar.e
                public final void a(Bitmap bitmap, d dVar) {
                    AppMethodBeat.i(135506);
                    super.a(bitmap, dVar);
                    a.this.b(bitmap, imageView);
                    AppMethodBeat.o(135506);
                }
            });
            aVar.oEX.cdf();
        }
        textView2.setText(aVar.mText);
        if (aVar.oEY) {
            textView2.setTextColor(this.oEF);
        } else {
            textView2.setTextColor(this.oEE);
        }
        if (!"top".equals(this.oED)) {
            textView2.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.widget.tabbar.a.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(135508);
                    int measuredWidth = (textView2.getMeasuredWidth() - imageView.getMeasuredWidth()) >> 1;
                    if (measuredWidth <= 0 || imageView.getVisibility() == 8) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
                        int dimensionPixelSize = a.this.getResources().getDimensionPixelSize(R.dimen.s5);
                        if (layoutParams.leftMargin != dimensionPixelSize) {
                            layoutParams.leftMargin = dimensionPixelSize;
                            relativeLayout.updateViewLayout(textView, layoutParams);
                        }
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
                        int dimensionPixelSize2 = a.this.getResources().getDimensionPixelSize(R.dimen.s6);
                        if (layoutParams2.leftMargin != dimensionPixelSize2) {
                            layoutParams2.leftMargin = dimensionPixelSize2;
                            relativeLayout.updateViewLayout(imageView2, layoutParams2);
                        }
                        AppMethodBeat.o(135508);
                        return;
                    }
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
                    int dimensionPixelSize3 = a.this.getResources().getDimensionPixelSize(R.dimen.s5) - measuredWidth;
                    if (layoutParams3.leftMargin != dimensionPixelSize3) {
                        layoutParams3.leftMargin = dimensionPixelSize3;
                        relativeLayout.updateViewLayout(textView, layoutParams3);
                    }
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
                    int dimensionPixelSize4 = a.this.getResources().getDimensionPixelSize(R.dimen.s6) - measuredWidth;
                    if (layoutParams4.leftMargin != dimensionPixelSize4) {
                        layoutParams4.leftMargin = dimensionPixelSize4;
                        relativeLayout.updateViewLayout(imageView2, layoutParams4);
                    }
                    AppMethodBeat.o(135508);
                }
            });
        }
        AppMethodBeat.o(135531);
    }

    /* access modifiers changed from: protected */
    public final void b(final Bitmap bitmap, final ImageView imageView) {
        AppMethodBeat.i(135532);
        imageView.post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.widget.tabbar.a.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(135509);
                imageView.setImageBitmap(bitmap);
                AppMethodBeat.o(135509);
            }
        });
        AppMethodBeat.o(135532);
    }

    public final int agk(String str) {
        C0826a aVar;
        AppMethodBeat.i(135533);
        LinkedList<C0826a> linkedList = this.oEG;
        String dM = l.dM(str);
        Iterator<C0826a> it = this.oEG.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            aVar = it.next();
            if (l.dM(aVar.mUrl).equals(dM)) {
                break;
            }
        }
        int indexOf = linkedList.indexOf(aVar);
        AppMethodBeat.o(135533);
        return indexOf;
    }

    private static int fromDPToPix(Context context, int i2) {
        AppMethodBeat.i(135534);
        int round = Math.round(context.getResources().getDisplayMetrics().density * ((float) i2));
        AppMethodBeat.o(135534);
        return round;
    }

    static /* synthetic */ void a(a aVar, String str, String str2) {
        AppMethodBeat.i(135535);
        aVar.oEE = g.cu(str, Color.parseColor("#E6000000"));
        aVar.oEF = g.cu(str2, Color.parseColor("#07C160"));
        AppMethodBeat.o(135535);
    }

    static /* synthetic */ void b(a aVar, String str, String str2) {
        int i2;
        AppMethodBeat.i(135536);
        float fromDPToPix = (float) fromDPToPix(aVar.getContext(), 1);
        if (fromDPToPix / 2.0f > 1.0f) {
            i2 = (int) (fromDPToPix / 2.0f);
        } else {
            i2 = 1;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(g.cu(str, -1));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(0);
        if ("white".equals(str2)) {
            gradientDrawable2.setStroke(i2, 872415231);
        } else {
            gradientDrawable2.setStroke(i2, 855638016);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, gradientDrawable2});
        if ("top".equals(aVar.oED)) {
            layerDrawable.setLayerInset(1, -i2, -i2, -i2, -i2);
        } else {
            layerDrawable.setLayerInset(1, -i2, 0, -i2, -i2);
        }
        aVar.setBackground(layerDrawable);
        AppMethodBeat.o(135536);
    }
}
