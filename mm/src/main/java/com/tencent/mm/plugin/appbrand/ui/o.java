package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.statusbar.b;
import kotlin.g.a.a;
import kotlin.x;

@SuppressLint({"ViewConstructor"})
public class o extends b implements ab {
    private View arn;
    private final Bitmap nWt;
    private TextView nWu;

    public o(Context context, Bitmap bitmap) {
        super(context);
        AppMethodBeat.i(48782);
        this.nWt = bitmap;
        CF(true);
        setBackground(new BitmapDrawable(getResources(), bitmap));
        View inflate = LayoutInflater.from(context).inflate(R.layout.fo, (ViewGroup) this, false);
        this.arn = inflate;
        addView(inflate);
        TextView textView = (TextView) inflate.findViewById(R.id.ipm);
        this.nWu = textView;
        textView.setText(R.string.mz);
        inflate.findViewById(R.id.e4p).setVisibility(8);
        AppMethodBeat.o(48782);
    }

    public void setPromptVisible(boolean z) {
        AppMethodBeat.i(227666);
        this.arn.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(227666);
    }

    public void setPromptText(String str) {
        AppMethodBeat.i(227667);
        this.nWu.setText(str);
        AppMethodBeat.o(227667);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final void eo(String str, String str2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public void z(final a<x> aVar) {
        AppMethodBeat.i(227668);
        post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ui.o.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(48781);
                final o oVar = o.this;
                if (oVar.getParent() instanceof ViewGroup) {
                    final ViewGroup viewGroup = (ViewGroup) oVar.getParent();
                    oVar.animate().alpha(0.0f).withEndAction(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.ui.o.AnonymousClass1.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(48780);
                            oVar.setVisibility(8);
                            viewGroup.removeView(oVar);
                            if (aVar != null) {
                                aVar.invoke();
                            }
                            AppMethodBeat.o(48780);
                        }
                    }).withStartAction(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.ui.o.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(48779);
                            o.a(o.this);
                            AppMethodBeat.o(48779);
                        }
                    }).start();
                }
                AppMethodBeat.o(48781);
            }
        });
        AppMethodBeat.o(227668);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(48784);
        super.onDetachedFromWindow();
        this.nWt.recycle();
        AppMethodBeat.o(48784);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public View getView() {
        return this;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public void setProgress(int i2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final void yu(int i2) {
    }

    static /* synthetic */ void a(o oVar) {
        AppMethodBeat.i(48785);
        ProgressBar progressBar = (ProgressBar) oVar.findViewById(R.id.gl7);
        if (progressBar != null && (progressBar.getIndeterminateDrawable() instanceof Animatable)) {
            ((Animatable) progressBar.getIndeterminateDrawable()).stop();
        }
        AppMethodBeat.o(48785);
    }
}
