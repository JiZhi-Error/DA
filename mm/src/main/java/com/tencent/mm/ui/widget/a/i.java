package com.tencent.mm.ui.widget.a;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.e;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.au;

public final class i extends e {
    private FrameLayout DAU;
    private Context mContext;

    public i(Context context) {
        super(context, R.style.ht);
        AppMethodBeat.i(198284);
        this.mContext = context;
        gR();
        AppMethodBeat.o(198284);
    }

    public final void onAttachedToWindow() {
        AppMethodBeat.i(198285);
        super.onAttachedToWindow();
        hbi();
        AppMethodBeat.o(198285);
    }

    @Override // android.support.v7.app.e, android.app.Dialog
    public final void setContentView(View view) {
        AppMethodBeat.i(198286);
        super.setContentView(b(0, view, null));
        AppMethodBeat.o(198286);
    }

    @Override // android.support.v7.app.e
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(198287);
        super.setContentView(b(0, view, layoutParams));
        AppMethodBeat.o(198287);
    }

    @Override // android.support.v7.app.e, android.app.Dialog
    public final void setContentView(int i2) {
        AppMethodBeat.i(198288);
        super.setContentView(b(i2, null, null));
        AppMethodBeat.o(198288);
    }

    @Override // android.support.v7.app.e
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(198289);
        super.onCreate(bundle);
        getWindow().setLayout(-1, -1);
        AppMethodBeat.o(198289);
    }

    private View b(int i2, View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(198290);
        Window window = getWindow();
        if (isLandscape()) {
            window.setGravity(1);
            window.setWindowAnimations(R.style.fs);
        } else {
            window.setGravity(80);
            window.setWindowAnimations(R.style.fs);
        }
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (isLandscape()) {
            attributes.width = -2;
            attributes.height = -2;
        } else {
            attributes.width = -1;
            attributes.height = -2;
        }
        window.setAttributes(attributes);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.bfv, (ViewGroup) null);
        View findViewById = viewGroup.findViewById(R.id.iua);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, viewGroup, false);
        }
        if (isLandscape()) {
            this.DAU = (FrameLayout) viewGroup.findViewById(R.id.fdl);
        } else {
            this.DAU = (FrameLayout) viewGroup.findViewById(R.id.fdk);
            hbi();
        }
        this.DAU.setVisibility(0);
        if (layoutParams == null) {
            this.DAU.addView(view);
        } else {
            this.DAU.addView(view, layoutParams);
        }
        if (ghl()) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.widget.a.i.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(198283);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/ui/widget/dialog/NewBottomSheetDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (i.this.isShowing()) {
                        i.this.cancel();
                    }
                    a.a(this, "com/tencent/mm/ui/widget/dialog/NewBottomSheetDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(198283);
                }
            });
        }
        AppMethodBeat.o(198290);
        return viewGroup;
    }

    private boolean ghl() {
        AppMethodBeat.i(198291);
        if (Build.VERSION.SDK_INT < 11) {
            AppMethodBeat.o(198291);
            return true;
        }
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(16843611, typedValue, true)) {
            AppMethodBeat.o(198291);
            return false;
        } else if (typedValue.data != 0) {
            AppMethodBeat.o(198291);
            return true;
        } else {
            AppMethodBeat.o(198291);
            return false;
        }
    }

    private boolean isLandscape() {
        AppMethodBeat.i(198292);
        if (this.mContext.getResources().getConfiguration().orientation == 2) {
            AppMethodBeat.o(198292);
            return true;
        }
        AppMethodBeat.o(198292);
        return false;
    }

    private void hbi() {
        int i2;
        AppMethodBeat.i(198293);
        if (this.DAU != null && !isLandscape()) {
            if (!au.aA(this.mContext) || Build.VERSION.SDK_INT >= 30) {
                i2 = 0;
            } else {
                i2 = au.aD(this.mContext);
            }
            CoordinatorLayout.d dVar = (CoordinatorLayout.d) this.DAU.getLayoutParams();
            dVar.setMargins(0, 0, 0, i2);
            this.DAU.setLayoutParams(dVar);
        }
        AppMethodBeat.o(198293);
    }
}
