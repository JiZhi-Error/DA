package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.cedit.api.c;

public class SnsUploadSayFooter extends InputPanelLinearLayout {
    private int ECP = -1;
    private int ECQ = -1;
    private c EPA = null;
    private boolean EPB = true;
    private boolean EPC = false;
    private MMActivity gte;
    private int moe = 0;
    ChatFooterPanel rum;
    private ImageButton ziQ;

    public SnsUploadSayFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(99554);
        this.gte = (MMActivity) context;
        this.ziQ = (ImageButton) ((ViewGroup) aa.jQ(this.gte).inflate(R.layout.by1, this)).findViewById(R.id.jj);
        this.ziQ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUploadSayFooter.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(203760);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/sns/ui/SnsUploadSayFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SnsUploadSayFooter.a(SnsUploadSayFooter.this);
                a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadSayFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203760);
            }
        });
        if (e.Knc == null) {
            this.rum = new d(this.gte);
            AppMethodBeat.o(99554);
            return;
        }
        this.rum = e.Knc.eZ(getContext());
        this.rum.setEntranceScene(ChatFooterPanel.BKM);
        this.rum.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.h8v);
        linearLayout.setOnClickListener(null);
        this.moe = KeyBoardUtil.getValidPanelHeight(getContext());
        linearLayout.addView(this.rum, -1, this.moe);
        this.rum.goD();
        fhZ();
        this.rum.onResume();
        this.rum.setOnTextOperationListener(new ChatFooterPanel.a() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUploadSayFooter.AnonymousClass3 */

            @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
            public final void aHD() {
            }

            @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
            public final void eP(boolean z) {
            }

            @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
            public final void aHC() {
                AppMethodBeat.i(203761);
                SnsUploadSayFooter.this.EPA.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
                SnsUploadSayFooter.this.EPA.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
                AppMethodBeat.o(203761);
            }

            @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
            public final void append(String str) {
                AppMethodBeat.i(203762);
                try {
                    SnsUploadSayFooter.this.EPA.bol(str);
                    AppMethodBeat.o(203762);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.SnsUploadSayFooter", e2, "", new Object[0]);
                    AppMethodBeat.o(203762);
                }
            }
        });
        AppMethodBeat.o(99554);
    }

    public final void fjH() {
        AppMethodBeat.i(99555);
        setVisibility(0);
        if (this.ziQ != null) {
            this.ziQ.setImageResource(R.drawable.aw_);
        }
        AppMethodBeat.o(99555);
    }

    public void setMMEditText(c cVar) {
        AppMethodBeat.i(203764);
        this.EPA = cVar;
        cVar.a(new c.a() {
            /* class com.tencent.mm.plugin.sns.ui.SnsUploadSayFooter.AnonymousClass1 */

            @Override // com.tencent.mm.ui.widget.cedit.api.c.a
            public final boolean ZY(int i2) {
                return false;
            }
        });
        AppMethodBeat.o(203764);
    }

    public final boolean fjI() {
        AppMethodBeat.i(99557);
        if (this.rum.getVisibility() == 0) {
            AppMethodBeat.o(99557);
            return true;
        }
        AppMethodBeat.o(99557);
        return false;
    }

    public final void fjJ() {
        AppMethodBeat.i(99558);
        cbM();
        setVisibility(4);
        AppMethodBeat.o(99558);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(99559);
        super.onConfigurationChanged(configuration);
        if (this.rum != null) {
            fhZ();
        }
        AppMethodBeat.o(99559);
    }

    private void cbM() {
        AppMethodBeat.i(99560);
        this.EPC = false;
        this.rum.onPause();
        if (KeyBoardUtil.isPortOrientation(getContext())) {
            getInputPanelHelper().aP(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.SnsUploadSayFooter.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(203763);
                    SnsUploadSayFooter.this.rum.setVisibility(8);
                    AppMethodBeat.o(203763);
                }
            });
            AppMethodBeat.o(99560);
            return;
        }
        this.rum.setVisibility(8);
        AppMethodBeat.o(99560);
    }

    @Override // com.tencent.mm.ui.widget.b.a, com.tencent.mm.ui.widget.InputPanelLinearLayout
    public final void f(boolean z, int i2) {
        AppMethodBeat.i(99561);
        Log.i("MicroMsg.SnsUploadSayFooter", "onInputPanelChange: %s, %s", Boolean.valueOf(z), Integer.valueOf(i2));
        super.f(z, i2);
        if (!(this.moe == i2 || i2 == 0)) {
            this.moe = i2;
            i.C(getContext(), i2);
            fhZ();
        }
        if (z) {
            fjH();
            AppMethodBeat.o(99561);
            return;
        }
        if (!this.EPC) {
            setVisibility(4);
        }
        AppMethodBeat.o(99561);
    }

    private void fhZ() {
        AppMethodBeat.i(99562);
        int validPanelHeight = KeyBoardUtil.getValidPanelHeight(getContext());
        this.rum.setPortHeightPx(validPanelHeight);
        ViewGroup.LayoutParams layoutParams = this.rum.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = validPanelHeight;
        }
        AppMethodBeat.o(99562);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(99563);
        super.onLayout(z, i2, i3, i4, i5);
        this.ECP = this.ECP < i5 ? i5 : this.ECP;
        this.ECQ = i5;
        AppMethodBeat.o(99563);
    }

    static /* synthetic */ void a(SnsUploadSayFooter snsUploadSayFooter) {
        boolean z = true;
        AppMethodBeat.i(99564);
        if (snsUploadSayFooter.rum.getVisibility() == 8) {
            snsUploadSayFooter.gte.hideVKB();
            snsUploadSayFooter.EPC = true;
            snsUploadSayFooter.rum.onResume();
            snsUploadSayFooter.fhZ();
            if (KeyBoardUtil.isPortOrientation(snsUploadSayFooter.getContext())) {
                int aD = ao.aD(snsUploadSayFooter.getContext());
                Log.i("MicroMsg.SnsUploadSayFooter", "is show key board %d, %d, %d", Integer.valueOf(snsUploadSayFooter.ECQ), Integer.valueOf(snsUploadSayFooter.ECP), Integer.valueOf(aD));
                if (snsUploadSayFooter.ECQ <= 0 || snsUploadSayFooter.ECQ >= snsUploadSayFooter.ECP - aD) {
                    z = false;
                }
                if (z || snsUploadSayFooter.EPB) {
                    snsUploadSayFooter.EPB = false;
                    snsUploadSayFooter.getInputPanelHelper().aQ(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsUploadSayFooter.AnonymousClass5 */

                        public final void run() {
                            AppMethodBeat.i(99552);
                            SnsUploadSayFooter.this.rum.setVisibility(0);
                            AppMethodBeat.o(99552);
                        }
                    });
                    snsUploadSayFooter.EPA.gYJ();
                    snsUploadSayFooter.ziQ.setImageResource(R.drawable.avt);
                    AppMethodBeat.o(99564);
                    return;
                }
            }
            snsUploadSayFooter.rum.setVisibility(0);
            snsUploadSayFooter.EPA.gYJ();
            snsUploadSayFooter.ziQ.setImageResource(R.drawable.avt);
            AppMethodBeat.o(99564);
            return;
        }
        snsUploadSayFooter.EPA.gYJ();
        snsUploadSayFooter.cbM();
        snsUploadSayFooter.gte.showVKB();
        snsUploadSayFooter.ziQ.setImageResource(R.drawable.aw_);
        AppMethodBeat.o(99564);
    }
}
