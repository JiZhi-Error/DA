package com.tencent.mm.ui.widget.a;

import android.annotation.SuppressLint;
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
import com.tencent.mm.ui.au;

public final class b extends e {
    private FrameLayout DAU;
    private Context mContext;

    public b(Context context) {
        this(context, (byte) 0);
    }

    private b(Context context, byte b2) {
        super(context, R.style.ht);
        AppMethodBeat.i(159284);
        this.mContext = context;
        gR();
        AppMethodBeat.o(159284);
    }

    @Override // android.support.v7.app.e, android.app.Dialog
    public final void setContentView(View view) {
        AppMethodBeat.i(159285);
        super.setContentView(b(0, view, null));
        AppMethodBeat.o(159285);
    }

    @Override // android.support.v7.app.e
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(159286);
        super.setContentView(b(0, view, layoutParams));
        AppMethodBeat.o(159286);
    }

    @Override // android.support.v7.app.e, android.app.Dialog
    public final void setContentView(int i2) {
        AppMethodBeat.i(159287);
        super.setContentView(b(i2, null, null));
        AppMethodBeat.o(159287);
    }

    @Override // android.support.v7.app.e
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(159288);
        super.onCreate(bundle);
        getWindow().setLayout(-1, -1);
        AppMethodBeat.o(159288);
    }

    public final void onAttachedToWindow() {
        AppMethodBeat.i(198214);
        super.onAttachedToWindow();
        hbi();
        AppMethodBeat.o(198214);
    }

    private View b(int i2, View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(159289);
        Window window = getWindow();
        if (isLandscape()) {
            window.setGravity(5);
            window.setWindowAnimations(R.style.t2);
        } else {
            window.setGravity(80);
            window.setWindowAnimations(R.style.fr);
        }
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (isLandscape()) {
            attributes.width = -2;
            attributes.height = -1;
        } else {
            attributes.width = -1;
            attributes.height = -2;
        }
        window.setAttributes(attributes);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.b75, (ViewGroup) null);
        View findViewById = viewGroup.findViewById(R.id.iua);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, viewGroup, false);
        }
        if (isLandscape()) {
            this.DAU = (FrameLayout) viewGroup.findViewById(R.id.fdm);
        } else {
            this.DAU = (FrameLayout) viewGroup.findViewById(R.id.fdk);
        }
        hbi();
        this.DAU.setVisibility(0);
        if (layoutParams == null) {
            this.DAU.addView(view);
        } else {
            this.DAU.addView(view, layoutParams);
        }
        if (ghl()) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.widget.a.b.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(159283);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/ui/widget/dialog/CustomSheetDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (b.this.isShowing()) {
                        b.this.cancel();
                    }
                    a.a(this, "com/tencent/mm/ui/widget/dialog/CustomSheetDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(159283);
                }
            });
        }
        AppMethodBeat.o(159289);
        return viewGroup;
    }

    private boolean ghl() {
        AppMethodBeat.i(159290);
        if (Build.VERSION.SDK_INT < 11) {
            AppMethodBeat.o(159290);
            return true;
        }
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(16843611, typedValue, true)) {
            AppMethodBeat.o(159290);
            return false;
        } else if (typedValue.data != 0) {
            AppMethodBeat.o(159290);
            return true;
        } else {
            AppMethodBeat.o(159290);
            return false;
        }
    }

    private boolean isLandscape() {
        AppMethodBeat.i(159291);
        if (this.mContext.getResources().getConfiguration().orientation == 2) {
            AppMethodBeat.o(159291);
            return true;
        }
        AppMethodBeat.o(159291);
        return false;
    }

    @SuppressLint({"WrongConstant"})
    private int getRotation() {
        AppMethodBeat.i(159292);
        int rotation = getWindow().getWindowManager().getDefaultDisplay().getRotation();
        AppMethodBeat.o(159292);
        return rotation;
    }

    private void hbi() {
        int i2;
        AppMethodBeat.i(198215);
        if (!au.aA(this.mContext) || Build.VERSION.SDK_INT >= 30) {
            i2 = 0;
        } else {
            i2 = au.aD(this.mContext);
        }
        if (isLandscape()) {
            if (this.DAU != null) {
                CoordinatorLayout.d dVar = (CoordinatorLayout.d) this.DAU.getLayoutParams();
                if (getRotation() == 1) {
                    dVar.setMargins(0, 0, i2, 0);
                } else if (getRotation() == 3) {
                    dVar.setMargins(i2, 0, 0, 0);
                }
                this.DAU.setLayoutParams(dVar);
                AppMethodBeat.o(198215);
                return;
            }
        } else if (this.DAU != null) {
            CoordinatorLayout.d dVar2 = (CoordinatorLayout.d) this.DAU.getLayoutParams();
            dVar2.setMargins(0, 0, 0, i2);
            this.DAU.setLayoutParams(dVar2);
        }
        AppMethodBeat.o(198215);
    }
}
