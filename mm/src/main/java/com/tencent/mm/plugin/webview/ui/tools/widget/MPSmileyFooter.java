package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.ad;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class MPSmileyFooter extends InputPanelLinearLayout {
    private WeImageView AxC;
    private int ECP = -1;
    private int ECQ = -1;
    private MMEditText EJt = null;
    private boolean EPB = true;
    private LinearLayout Jzc;
    private LinearLayout Jzd;
    private int Jze = 0;
    private boolean Jzf = false;
    private MMActivity activity;
    private Context context;
    private int moe = 0;
    public ChatFooterPanel rum;

    static /* synthetic */ void a(MPSmileyFooter mPSmileyFooter) {
        AppMethodBeat.i(82265);
        mPSmileyFooter.cbM();
        AppMethodBeat.o(82265);
    }

    public MPSmileyFooter(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.context = context2;
    }

    private MMActivity getActivity() {
        AppMethodBeat.i(82249);
        if (this.activity == null) {
            if (this.context instanceof MMActivity) {
                this.activity = (MMActivity) this.context;
            } else {
                Context context2 = this.context;
                while (!(context2 instanceof MMActivity) && (context2 instanceof ContextWrapper)) {
                    context2 = ((ContextWrapper) context2).getBaseContext();
                }
                this.activity = (MMActivity) context2;
            }
        }
        MMActivity mMActivity = this.activity;
        AppMethodBeat.o(82249);
        return mMActivity;
    }

    private int ahf(int i2) {
        AppMethodBeat.i(82250);
        TypedValue typedValue = new TypedValue();
        this.context.getTheme().resolveAttribute(i2, typedValue, true);
        int i3 = typedValue.resourceId;
        AppMethodBeat.o(82250);
        return i3;
    }

    public final void fjH() {
        AppMethodBeat.i(82251);
        setVisibility(0);
        if (this.AxC != null) {
            this.AxC.setImageResource(ahf(R.attr.h3));
        }
        AppMethodBeat.o(82251);
    }

    public final void giv() {
        AppMethodBeat.i(82252);
        if (fjI()) {
            AppMethodBeat.o(82252);
            return;
        }
        setVisibility(8);
        AppMethodBeat.o(82252);
    }

    public void setMMEditText(MMEditText mMEditText) {
        AppMethodBeat.i(82253);
        this.EJt = mMEditText;
        mMEditText.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.MPSmileyFooter.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(82245);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (MPSmileyFooter.this.getVisibility() == 8) {
                    MPSmileyFooter.this.setVisibility(0);
                }
                if (MPSmileyFooter.this.fjI()) {
                    MPSmileyFooter.a(MPSmileyFooter.this);
                }
                a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(82245);
            }
        });
        mMEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.MPSmileyFooter.AnonymousClass2 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return false;
            }
        });
        AppMethodBeat.o(82253);
    }

    public final boolean giw() {
        AppMethodBeat.i(82254);
        if (fjI() || getVisibility() == 0) {
            AppMethodBeat.o(82254);
            return true;
        }
        AppMethodBeat.o(82254);
        return false;
    }

    public final boolean fjI() {
        AppMethodBeat.i(82255);
        if (this.rum.getVisibility() == 0) {
            AppMethodBeat.o(82255);
            return true;
        }
        AppMethodBeat.o(82255);
        return false;
    }

    public final void fjJ() {
        AppMethodBeat.i(82256);
        cbM();
        setVisibility(8);
        AppMethodBeat.o(82256);
    }

    public final void init(boolean z) {
        AppMethodBeat.i(82257);
        this.AxC = (WeImageView) ((ViewGroup) aa.jQ(this.context).inflate(R.layout.bbr, this)).findViewById(R.id.jj);
        this.AxC.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.MPSmileyFooter.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(82246);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                MPSmileyFooter.b(MPSmileyFooter.this);
                a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(82246);
            }
        });
        this.rum = ad.l(this.context, z);
        if (this.rum == null) {
            this.rum = new d(this.context);
            AppMethodBeat.o(82257);
            return;
        }
        this.rum.setEntranceScene(ChatFooterPanel.BKM);
        this.rum.setVisibility(8);
        this.Jzc = (LinearLayout) findViewById(R.id.htl);
        this.Jzd = (LinearLayout) findViewById(R.id.fiu);
        this.Jzc.setOnClickListener(null);
        this.moe = KeyBoardUtil.getValidPanelHeight(getContext());
        this.Jzc.addView(this.rum, -1, this.moe);
        this.rum.goD();
        this.rum.onResume();
        fhZ();
        this.rum.setOnTextOperationListener(new ChatFooterPanel.a() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.MPSmileyFooter.AnonymousClass4 */

            @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
            public final void aHD() {
            }

            @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
            public final void eP(boolean z) {
            }

            @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
            public final void aHC() {
                AppMethodBeat.i(82247);
                MPSmileyFooter.this.EJt.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
                MPSmileyFooter.this.EJt.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
                AppMethodBeat.o(82247);
            }

            @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
            public final void append(String str) {
                AppMethodBeat.i(82248);
                try {
                    MPSmileyFooter.this.EJt.bol(str);
                    AppMethodBeat.o(82248);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.SnsUploadSayFooter", e2, "", new Object[0]);
                    AppMethodBeat.o(82248);
                }
            }
        });
        AppMethodBeat.o(82257);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(82258);
        super.onConfigurationChanged(configuration);
        if (this.rum != null) {
            fhZ();
        }
        AppMethodBeat.o(82258);
    }

    private void cbM() {
        AppMethodBeat.i(82259);
        this.rum.onPause();
        this.rum.setVisibility(8);
        AppMethodBeat.o(82259);
    }

    @Override // com.tencent.mm.ui.widget.b.a, com.tencent.mm.ui.widget.InputPanelLinearLayout
    public final void f(boolean z, int i2) {
        AppMethodBeat.i(82260);
        super.f(z, i2);
        if (!(this.moe == i2 || i2 == 0)) {
            this.moe = i2;
            i.C(getContext(), i2);
            fhZ();
        }
        AppMethodBeat.o(82260);
    }

    private void fhZ() {
        AppMethodBeat.i(82261);
        ViewGroup.LayoutParams layoutParams = this.Jzc.getLayoutParams();
        layoutParams.height = this.moe + this.Jze;
        this.Jzc.setLayoutParams(layoutParams);
        int validPanelHeight = KeyBoardUtil.getValidPanelHeight(getContext());
        this.rum.setPortHeightPx(validPanelHeight);
        ViewGroup.LayoutParams layoutParams2 = this.rum.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = validPanelHeight;
        }
        AppMethodBeat.o(82261);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(82263);
        super.onLayout(z, i2, i3, i4, i5);
        this.ECP = this.ECP < i5 ? i5 : this.ECP;
        this.ECQ = i5;
        AppMethodBeat.o(82263);
    }

    public void setExtraAddHeight(int i2) {
        this.Jze = i2;
    }

    public void setSmileHeight(int i2) {
        AppMethodBeat.i(82264);
        ViewGroup.LayoutParams layoutParams = this.Jzc.getLayoutParams();
        layoutParams.height = i2;
        this.Jzc.setLayoutParams(layoutParams);
        int validPanelHeight = KeyBoardUtil.getValidPanelHeight(getContext());
        this.rum.setPortHeightPx(validPanelHeight);
        ViewGroup.LayoutParams layoutParams2 = this.rum.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = validPanelHeight;
        }
        AppMethodBeat.o(82264);
    }

    public void setFobbidenWhenLandscape(boolean z) {
        this.Jzf = z;
    }

    static /* synthetic */ void b(MPSmileyFooter mPSmileyFooter) {
        AppMethodBeat.i(82266);
        if (mPSmileyFooter.rum.getVisibility() == 8) {
            mPSmileyFooter.getActivity().hideVKB();
            mPSmileyFooter.rum.onResume();
            if (KeyBoardUtil.getScreenOrientation(mPSmileyFooter.context) != 2 || !mPSmileyFooter.Jzf) {
                mPSmileyFooter.fhZ();
            }
            mPSmileyFooter.rum.setVisibility(0);
            mPSmileyFooter.EJt.requestFocus();
            mPSmileyFooter.AxC.setImageResource(mPSmileyFooter.ahf(R.attr.h2));
            AppMethodBeat.o(82266);
            return;
        }
        mPSmileyFooter.EJt.requestFocus();
        mPSmileyFooter.cbM();
        mPSmileyFooter.getActivity().showVKB();
        mPSmileyFooter.AxC.setImageResource(mPSmileyFooter.ahf(R.attr.h3));
        AppMethodBeat.o(82266);
    }
}
