package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
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

public final class e extends android.support.v7.app.e {
    private Context mContext;

    public e(Context context) {
        this(context, (byte) 0);
    }

    private e(Context context, byte b2) {
        super(context, R.style.kv);
        AppMethodBeat.i(80990);
        gR();
        this.mContext = context;
        AppMethodBeat.o(80990);
    }

    @Override // android.support.v7.app.e, android.app.Dialog
    public final void setContentView(int i2) {
        AppMethodBeat.i(80991);
        super.setContentView(b(i2, null, null));
        AppMethodBeat.o(80991);
    }

    @Override // android.support.v7.app.e
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(80992);
        super.onCreate(bundle);
        getWindow().setLayout(-1, -1);
        AppMethodBeat.o(80992);
    }

    @Override // android.support.v7.app.e, android.app.Dialog
    public final void setContentView(View view) {
        AppMethodBeat.i(80993);
        super.setContentView(b(0, view, null));
        AppMethodBeat.o(80993);
    }

    @Override // android.support.v7.app.e
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(80994);
        super.setContentView(b(0, view, layoutParams));
        AppMethodBeat.o(80994);
    }

    private View b(int i2, View view, ViewGroup.LayoutParams layoutParams) {
        FrameLayout frameLayout;
        AppMethodBeat.i(80995);
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
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.arm, (ViewGroup) null);
        View findViewById = viewGroup.findViewById(R.id.iua);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, viewGroup, false);
        }
        if (isLandscape()) {
            frameLayout = (FrameLayout) viewGroup.findViewById(R.id.fdm);
        } else {
            frameLayout = (FrameLayout) viewGroup.findViewById(R.id.fdk);
        }
        frameLayout.setVisibility(0);
        if (layoutParams == null) {
            frameLayout.addView(view);
        } else {
            frameLayout.addView(view, layoutParams);
        }
        if (ghl()) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.game.menu.e.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(80989);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/webview/ui/tools/game/menu/GameSheetDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (e.this.isShowing()) {
                        e.this.cancel();
                    }
                    a.a(this, "com/tencent/mm/plugin/webview/ui/tools/game/menu/GameSheetDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(80989);
                }
            });
        }
        AppMethodBeat.o(80995);
        return viewGroup;
    }

    private boolean ghl() {
        AppMethodBeat.i(80996);
        if (Build.VERSION.SDK_INT < 11) {
            AppMethodBeat.o(80996);
            return true;
        }
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(16843611, typedValue, true)) {
            AppMethodBeat.o(80996);
            return false;
        } else if (typedValue.data != 0) {
            AppMethodBeat.o(80996);
            return true;
        } else {
            AppMethodBeat.o(80996);
            return false;
        }
    }

    private boolean isLandscape() {
        AppMethodBeat.i(80997);
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            AppMethodBeat.o(80997);
            return true;
        }
        AppMethodBeat.o(80997);
        return false;
    }
}
