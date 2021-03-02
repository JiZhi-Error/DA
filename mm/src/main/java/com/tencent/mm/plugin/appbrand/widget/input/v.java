package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.support.v4.view.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class v extends LinearLayout implements ac {
    private static final int VIEW_ID = R.id.p5;
    static com.tencent.mm.plugin.appbrand.n.a otP = null;
    static boolean otQ = false;
    EditText mEditText;
    View otK;
    private boolean otL = false;
    private a otM;
    AppBrandNumberKeyboardView otN;
    View otO;

    public interface a {
        void onDone();
    }

    static /* synthetic */ void a(v vVar) {
        AppMethodBeat.i(136489);
        vVar.onDone();
        AppMethodBeat.o(136489);
    }

    public static v da(View view) {
        AppMethodBeat.i(136477);
        v vVar = (v) view.getRootView().findViewById(VIEW_ID);
        AppMethodBeat.o(136477);
        return vVar;
    }

    public final void setComponentView(boolean z) {
        otQ = z;
    }

    public static v a(View view, com.tencent.mm.plugin.appbrand.n.a aVar) {
        AppMethodBeat.i(230582);
        if (otP != aVar) {
            Log.d("MicroMsg.AppBrandNumberKeyboardPanel", "mComponentView != componentView so we set mComponentView = componentView;");
            otP = aVar;
        }
        v da = da(view);
        if (da == null) {
            n cW = n.cW(view);
            if (cW == null) {
                AppMethodBeat.o(230582);
                return null;
            }
            da = new v(view.getContext());
            cW.n(da, false);
        }
        AppMethodBeat.o(230582);
        return da;
    }

    private v(Context context) {
        super(context);
        ViewGroup viewGroup;
        AppMethodBeat.i(136479);
        Log.d("MicroMsg.AppBrandNumberKeyboardPanel", APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        super.setId(VIEW_ID);
        setOrientation(1);
        setBackgroundColor(-1);
        if (otQ) {
            this.otO = otP;
            if (!(this.otO == null || (viewGroup = (ViewGroup) this.otO.getParent()) == null)) {
                Log.i("MicroMsg.AppBrandNumberKeyboardPanel", "toolbar is already exsited in a layout,the class of the parent is %s  the id is : %d", viewGroup.getClass().toString(), Integer.valueOf(viewGroup.getId()));
                viewGroup.removeView(this.otO);
            }
            addView(this.otO);
        }
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 30));
        this.otK = LayoutInflater.from(getContext()).inflate(R.layout.go, (ViewGroup) null);
        this.otK.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.v.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(136476);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/input/AppBrandNumberKeyboardPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                v.a(v.this);
                v.this.setVisibility(8);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/AppBrandNumberKeyboardPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(136476);
            }
        });
        addView(this.otK, layoutParams);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 240));
        AppBrandNumberKeyboardView appBrandNumberKeyboardView = new AppBrandNumberKeyboardView(getContext());
        this.otN = appBrandNumberKeyboardView;
        addView(appBrandNumberKeyboardView, layoutParams2);
        AppMethodBeat.o(136479);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ac
    public final boolean cbD() {
        AppMethodBeat.i(136480);
        boolean az = u.az(this);
        AppMethodBeat.o(136480);
        return az;
    }

    public final void setOnDoneListener(a aVar) {
        this.otM = aVar;
    }

    private void onDone() {
        AppMethodBeat.i(136481);
        if (!this.otL && this.otM != null) {
            this.otL = true;
            this.otM.onDone();
            this.otL = false;
        }
        AppMethodBeat.o(136481);
    }

    public static void db(View view) {
        ViewGroup viewGroup;
        AppMethodBeat.i(230583);
        if (!(view == null || (viewGroup = (ViewGroup) view.getParent()) == null)) {
            viewGroup.removeView(view);
        }
        AppMethodBeat.o(230583);
    }

    public final void setId(int i2) {
    }

    public final void setVisibility(int i2) {
        AppMethodBeat.i(136482);
        if (getVisibility() == i2 && (getVisibility() == 0 || getVisibility() == 8)) {
            AppMethodBeat.o(136482);
        } else if (i2 != 0) {
            super.setVisibility(8);
            onDone();
            AppMethodBeat.o(136482);
        } else {
            super.setVisibility(i2);
            AppMethodBeat.o(136482);
        }
    }

    public final int getPanelHeight() {
        AppMethodBeat.i(136483);
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(getContext(), 270);
        AppMethodBeat.o(136483);
        return fromDPToPix;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0064, code lost:
        r0 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <_Input extends android.widget.EditText & com.tencent.mm.plugin.appbrand.widget.input.numberpad.a> void setInputEditText(_Input r6) {
        /*
        // Method dump skipped, instructions count: 102
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.widget.input.v.setInputEditText(android.widget.EditText):void");
    }

    public final EditText getAttachedEditText() {
        return this.mEditText;
    }

    public final void setXMode(int i2) {
        AppMethodBeat.i(136485);
        this.otN.setXMode(i2);
        AppMethodBeat.o(136485);
    }

    /* access modifiers changed from: package-private */
    public final void cbE() {
        AppMethodBeat.i(136486);
        if (this.mEditText != null) {
            this.mEditText.clearFocus();
            this.mEditText = null;
            this.otM = null;
            this.otL = false;
        }
        AppMethodBeat.o(136486);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(136488);
        super.onDetachedFromWindow();
        removeAllViews();
        AppMethodBeat.o(136488);
    }
}
