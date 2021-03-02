package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.widget.AppBrandActionBarCustomImageView;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e;
import com.tencent.smtt.sdk.WebView;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class b extends LinearLayout implements i.b, i.d, e {
    private View jBN;
    protected int nYY;
    protected ImageView olL;
    protected View olM;
    protected View olN;
    protected View olO;
    protected TextView olP;
    protected ProgressBar olQ;
    protected CircleProgressDrawable olR;
    protected int olS;
    protected double olT;
    protected boolean olU = false;
    protected boolean olV = false;
    protected c olW = new c();
    private AbstractC0818b olX;
    private AppBrandCapsuleBarPlaceHolderView olY;
    private a olZ = new c(this, (byte) 0);
    private d oma;
    private final Set<a> omb = new LinkedHashSet();
    private boolean omc = false;
    private AppBrandActionBarCustomImageView omd;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.actionbar.b$b  reason: collision with other inner class name */
    public interface AbstractC0818b {
        void setHomeButtonOnClickListener(View.OnClickListener onClickListener);

        void setOptionButtonOnClickListener(View.OnClickListener onClickListener);

        void setStyleColor(int i2);

        void vI(int i2);
    }

    public interface d {
        void io(boolean z);
    }

    public b(Context context) {
        super(context);
        AppMethodBeat.i(135409);
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(R.color.bj);
        this.jBN = LayoutInflater.from(getContext()).inflate(R.layout.cy, (ViewGroup) this, false);
        addView(this.jBN);
        this.nYY = -1;
        this.olS = getResources().getColor(R.color.bj);
        this.olT = 1.0d;
        this.olN = findViewById(R.id.e5);
        this.olL = (ImageView) findViewById(R.id.e6);
        this.olM = findViewById(R.id.e4);
        this.olO = findViewById(R.id.ed);
        this.olP = (TextView) findViewById(R.id.eg);
        this.olQ = (ProgressBar) findViewById(R.id.e3);
        this.olR = new CircleProgressDrawable(getContext());
        this.olY = (AppBrandCapsuleBarPlaceHolderView) findViewById(R.id.dv);
        this.olM.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.actionbar.b.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(219616);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (b.this.olZ != null && !b.this.olZ.cz(view)) {
                    c cVar = b.this.olW;
                    View view2 = b.this.olM;
                    if (!cVar.omk.isEmpty()) {
                        Iterator<View.OnClickListener> it = cVar.omk.iterator();
                        while (it.hasNext()) {
                            it.next().onClick(view2);
                        }
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(219616);
            }
        });
        AppMethodBeat.o(135409);
    }

    public final void setCapsuleBarInteractionDelegate(AbstractC0818b bVar) {
        AppMethodBeat.i(219620);
        this.olX = bVar;
        if (this.olX != null) {
            this.olX.setOptionButtonOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.appbrand.widget.actionbar.b.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(135404);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    c cVar = b.this.olW;
                    if (!cVar.oml.isEmpty()) {
                        Iterator<View.OnClickListener> it = cVar.oml.iterator();
                        while (it.hasNext()) {
                            it.next().onClick(view);
                        }
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(135404);
                }
            });
            this.olX.setHomeButtonOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.appbrand.widget.actionbar.b.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(135405);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    c cVar = b.this.olW;
                    if (!cVar.omj.isEmpty()) {
                        Iterator<View.OnClickListener> it = cVar.omj.iterator();
                        while (it.hasNext()) {
                            it.next().onClick(view);
                        }
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(135405);
                }
            });
        }
        AppMethodBeat.o(219620);
    }

    class c extends a {
        private c() {
        }

        /* synthetic */ c(b bVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.b.a
        public final void a(ImageView imageView, View view, View view2) {
            AppMethodBeat.i(178641);
            if (imageView != null) {
                imageView.setImageResource(R.raw.app_brand_back);
                imageView.setColorFilter(b.this.nYY, PorterDuff.Mode.SRC_ATOP);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.width = b.this.getContext().getResources().getDimensionPixelSize(R.dimen.oo);
                marginLayoutParams.height = b.this.getContext().getResources().getDimensionPixelSize(R.dimen.on);
                marginLayoutParams.leftMargin = b.this.getContext().getResources().getDimensionPixelSize(R.dimen.ow);
                marginLayoutParams.rightMargin = b.this.getContext().getResources().getDimensionPixelSize(R.dimen.oy);
                imageView.setLayoutParams(marginLayoutParams);
            }
            if (view != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams2.leftMargin = 0;
                marginLayoutParams2.rightMargin = 0;
                view.setLayoutParams(marginLayoutParams2);
            }
            AppMethodBeat.o(178641);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.b.a
        public final int bQz() {
            return R.dimen.ow;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final void destroy() {
        AppMethodBeat.i(219621);
        if (this.olR != null) {
            this.olR.stop();
        }
        removeAllViews();
        AppMethodBeat.o(219621);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
    public final void onBackground() {
        AppMethodBeat.i(219622);
        if (this.olR != null) {
            this.olR.stop();
        }
        AppMethodBeat.o(219622);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.d
    public final void onForeground() {
        AppMethodBeat.i(219623);
        if (cag() && this.olR != null) {
            this.olR.start();
        }
        AppMethodBeat.o(219623);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public void setBackButtonClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(135410);
        c cVar = this.olW;
        if (onClickListener == null) {
            AppMethodBeat.o(135410);
            return;
        }
        cVar.omk.add(onClickListener);
        AppMethodBeat.o(135410);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public void setCloseButtonClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(135411);
        c cVar = this.olW;
        if (onClickListener == null) {
            AppMethodBeat.o(135411);
            return;
        }
        cVar.omj.add(onClickListener);
        AppMethodBeat.o(135411);
    }

    public void setOptionButtonClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(135423);
        c cVar = this.olW;
        if (onClickListener == null) {
            AppMethodBeat.o(135423);
            return;
        }
        cVar.oml.add(onClickListener);
        AppMethodBeat.o(135423);
    }

    public void setNavButtonLongClickListener(final View.OnLongClickListener onLongClickListener) {
        AppMethodBeat.i(135413);
        this.olM.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.actionbar.b.AnonymousClass4 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(219617);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                if (onLongClickListener != null) {
                    boolean onLongClick = onLongClickListener.onLongClick(view);
                    com.tencent.mm.hellhoundlib.a.a.a(onLongClick, this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(219617);
                    return onLongClick;
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(219617);
                return false;
            }
        });
        AppMethodBeat.o(135413);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(135414);
        this.omb.add(aVar);
        if (!this.omc) {
            cac();
            this.omc = true;
        }
        AppMethodBeat.o(135414);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public void setMainTitle(CharSequence charSequence) {
        AppMethodBeat.i(135415);
        boolean isLayoutRequested = isLayoutRequested();
        this.olP.setText(charSequence);
        if (isLayoutRequested) {
            requestLayout();
        }
        AppMethodBeat.o(135415);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(135416);
        super.onLayout(z, i2, i3, i4, i5);
        AppMethodBeat.o(135416);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(135417);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(135417);
    }

    public CharSequence getMainTitle() {
        AppMethodBeat.i(135418);
        CharSequence text = this.olP.getText();
        AppMethodBeat.o(135418);
        return text;
    }

    private void cac() {
        AppMethodBeat.i(135419);
        this.olO.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.actionbar.b.AnonymousClass5 */
            private long omg = 0;

            public final void onClick(View view) {
                AppMethodBeat.i(219618);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (System.currentTimeMillis() - this.omg < 250) {
                    for (a aVar : b.this.omb) {
                        aVar.bLE();
                    }
                    this.omg = 0;
                }
                this.omg = System.currentTimeMillis();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(219618);
            }
        });
        AppMethodBeat.o(135419);
    }

    public final double getBackgroundAlpha() {
        return this.olT;
    }

    public final void setBackgroundAlpha(double d2) {
        AppMethodBeat.i(135420);
        this.olT = d2;
        if (!this.olV) {
            Drawable background = super.getBackground();
            if (background == null) {
                setBackgroundColorInternal(this.olS);
                background = super.getBackground();
            }
            background.setAlpha((int) (255.0d * d2));
        }
        AppMethodBeat.o(135420);
    }

    private void setBackgroundColorInternal(int i2) {
        AppMethodBeat.i(135421);
        if (!this.olV) {
            super.setBackgroundColor(i2);
            AppMethodBeat.o(135421);
            return;
        }
        super.setBackgroundColor(0);
        AppMethodBeat.o(135421);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final void setBackgroundColor(int i2) {
        AppMethodBeat.i(135422);
        this.olS = i2;
        setBackgroundColorInternal(i2);
        setBackgroundAlpha(this.olT);
        AppMethodBeat.o(135422);
    }

    public final void zN(int i2) {
        AppMethodBeat.i(178642);
        this.olS = i2;
        super.setBackgroundColor(i2);
        AppMethodBeat.o(178642);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final int getBackgroundColor() {
        if (this.olV) {
            return 0;
        }
        return this.olS;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final void gz(boolean z) {
        int i2 = 0;
        AppMethodBeat.i(135424);
        this.olY.setVisibility(z ? 0 : 4);
        if (this.olY.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.olY.getLayoutParams();
            if (z) {
                i2 = -2;
            }
            layoutParams.width = i2;
            this.olY.requestLayout();
        }
        if (this.olX != null) {
            this.olX.vI(this.olY.getVisibility());
        }
        AppMethodBeat.o(135424);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public void setForegroundStyle(String str) {
        AppMethodBeat.i(135427);
        this.nYY = e.a.afW(str).omu;
        cad();
        AppMethodBeat.o(135427);
    }

    public void setForegroundStyle(boolean z) {
        AppMethodBeat.i(135428);
        this.nYY = z ? WebView.NIGHT_MODE_COLOR : -1;
        cad();
        AppMethodBeat.o(135428);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public void setForegroundColor(int i2) {
        AppMethodBeat.i(135429);
        this.nYY = i2;
        cad();
        AppMethodBeat.o(135429);
    }

    public int getForegroundColor() {
        return this.nYY;
    }

    public final void cad() {
        AppMethodBeat.i(135430);
        if (this.olZ != null) {
            this.olZ.a(this.olL, this.olM, this.olN);
        }
        this.olP.setTextColor(this.nYY);
        this.olR.setStrokeColor(this.nYY);
        this.olQ.setIndeterminateDrawable(this.olR);
        zO(this.nYY);
        AppMethodBeat.o(135430);
    }

    private void zO(int i2) {
        AppMethodBeat.i(135431);
        if (e.a.zP(i2) == e.a.WHITE) {
            if (this.olX != null) {
                this.olX.setStyleColor(-1);
                AppMethodBeat.o(135431);
                return;
            }
        } else if (this.olX != null) {
            this.olX.setStyleColor(WebView.NIGHT_MODE_COLOR);
        }
        AppMethodBeat.o(135431);
    }

    public void setNavHidden(boolean z) {
        AppMethodBeat.i(135433);
        this.olU = z;
        caf();
        cad();
        AppMethodBeat.o(135433);
    }

    public final boolean cae() {
        return this.olU;
    }

    private void caf() {
        AppMethodBeat.i(135434);
        this.olM.setVisibility((this.olV || this.olU) ? 8 : 0);
        requestLayout();
        AppMethodBeat.o(135434);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public void setLoadingIconVisibility(boolean z) {
        AppMethodBeat.i(135435);
        if (this.oma != null) {
            this.oma.io(z);
            AppMethodBeat.o(135435);
            return;
        }
        this.olQ.setVisibility(z ? 0 : 8);
        if (z) {
            this.olR.cbk();
            this.olR.start();
            AppMethodBeat.o(135435);
            return;
        }
        this.olR.stop();
        AppMethodBeat.o(135435);
    }

    public final boolean cag() {
        AppMethodBeat.i(135436);
        if (this.olQ.getVisibility() == 0) {
            AppMethodBeat.o(135436);
            return true;
        }
        AppMethodBeat.o(135436);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public View getActionView() {
        return this;
    }

    public AppBrandCapsuleBarPlaceHolderView getCapsuleView() {
        return this.olY;
    }

    public final boolean isFullscreenMode() {
        return this.olV;
    }

    public void setFullscreenMode(boolean z) {
        AppMethodBeat.i(135437);
        this.olV = z;
        caf();
        this.olO.setVisibility(this.olV ? 4 : 0);
        requestLayout();
        setBackgroundColor(this.olS);
        AppMethodBeat.o(135437);
    }

    public final void gx(boolean z) {
        AppMethodBeat.i(135438);
        this.olM.setVisibility(z ? 0 : 8);
        requestLayout();
        AppMethodBeat.o(135438);
    }

    public final void gy(boolean z) {
        AppMethodBeat.i(135439);
        this.olO.setVisibility(z ? 0 : 8);
        requestLayout();
        AppMethodBeat.o(135439);
    }

    public final void a(final Bitmap bitmap, final View.OnClickListener onClickListener) {
        AppMethodBeat.i(135440);
        post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.widget.actionbar.b.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(219619);
                if (b.this.getParent() == null) {
                    AppMethodBeat.o(219619);
                    return;
                }
                if (b.this.omd == null) {
                    ViewStub viewStub = (ViewStub) b.this.findViewById(R.id.bjr);
                    if (viewStub == null) {
                        AppMethodBeat.o(219619);
                        return;
                    }
                    viewStub.inflate();
                    b.this.omd = (AppBrandActionBarCustomImageView) b.this.findViewById(R.id.bjq);
                }
                b.this.omd.setVisibility(0);
                b.this.omd.setImageBitmap(bitmap);
                b.this.omd.setClickable(true);
                b.this.omd.setOnClickListener(onClickListener);
                AppMethodBeat.o(219619);
            }
        });
        AppMethodBeat.o(135440);
    }

    public void setNavResetStyleListener(a aVar) {
        this.olZ = aVar;
    }

    public a getNavResetStyleListener() {
        return this.olZ;
    }

    public static abstract class a {
        public static final int omi = R.dimen.ow;

        /* access modifiers changed from: protected */
        public abstract void a(ImageView imageView, View view, View view2);

        public abstract int bQz();

        /* access modifiers changed from: protected */
        public boolean cz(View view) {
            return false;
        }
    }

    public void setNavLoadingIconVisibilityResetListener(d dVar) {
        this.oma = dVar;
    }

    public void setNavContainerMinimumWidth(int i2) {
        AppMethodBeat.i(178643);
        if (this.olN != null) {
            this.olN.setMinimumWidth(i2);
        }
        AppMethodBeat.o(178643);
    }

    public void setActionBarHeight(int i2) {
        AppMethodBeat.i(178644);
        ViewGroup.LayoutParams layoutParams = this.jBN.getLayoutParams();
        if (!(layoutParams == null || layoutParams.height == i2)) {
            layoutParams.height = i2;
            this.jBN.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(178644);
    }
}
