package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class SnsSightUploadSayFooter extends BasePanelKeybordLayout {
    private MMEditText EJt = null;
    SightRangeWidget EJu;
    SightLocationWidget EJv;
    MMActivity gte;
    ChatFooterPanel rum;
    private ImageButton ziQ;
    private boolean ziU = true;

    static /* synthetic */ void a(SnsSightUploadSayFooter snsSightUploadSayFooter) {
        AppMethodBeat.i(99127);
        snsSightUploadSayFooter.cbM();
        AppMethodBeat.o(99127);
    }

    public SnsSightUploadSayFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(99122);
        this.gte = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) inflate(this.gte, R.layout.bx7, this);
        this.ziQ = (ImageButton) viewGroup.findViewById(R.id.jj);
        this.ziQ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSightUploadSayFooter.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(99119);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/sns/ui/SnsSightUploadSayFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SnsSightUploadSayFooter.d(SnsSightUploadSayFooter.this);
                a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightUploadSayFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99119);
            }
        });
        if (e.Knc == null) {
            this.rum = new d(this.gte);
        } else {
            this.rum = e.Knc.eZ(getContext());
            this.rum.setEntranceScene(ChatFooterPanel.BKM);
            this.rum.setVisibility(8);
            ((LinearLayout) findViewById(R.id.h8v)).addView(this.rum, -1, 0);
            this.rum.goD();
            this.rum.onResume();
            this.rum.setOnTextOperationListener(new ChatFooterPanel.a() {
                /* class com.tencent.mm.plugin.sns.ui.SnsSightUploadSayFooter.AnonymousClass5 */

                @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
                public final void aHD() {
                }

                @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
                public final void eP(boolean z) {
                }

                @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
                public final void aHC() {
                    AppMethodBeat.i(99120);
                    SnsSightUploadSayFooter.this.EJt.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
                    SnsSightUploadSayFooter.this.EJt.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
                    AppMethodBeat.o(99120);
                }

                @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
                public final void append(String str) {
                    AppMethodBeat.i(99121);
                    try {
                        SnsSightUploadSayFooter.this.EJt.bol(str);
                        AppMethodBeat.o(99121);
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.SnsSightUploadSayFooter", e2, "", new Object[0]);
                        AppMethodBeat.o(99121);
                    }
                }
            });
        }
        this.EJu = (SightRangeWidget) viewGroup.findViewById(R.id.gr7);
        this.EJu.Eoy = null;
        this.EJu.style = 1;
        this.EJv = (SightLocationWidget) viewGroup.findViewById(R.id.er1);
        AppMethodBeat.o(99122);
    }

    public void setMMEditText(MMEditText mMEditText) {
        AppMethodBeat.i(99123);
        this.EJt = mMEditText;
        mMEditText.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSightUploadSayFooter.AnonymousClass1 */

            public final void onClick(View view) {
                boolean z;
                AppMethodBeat.i(99117);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/sns/ui/SnsSightUploadSayFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (SnsSightUploadSayFooter.this.getVisibility() == 8) {
                    SnsSightUploadSayFooter.this.setVisibility(0);
                }
                if (SnsSightUploadSayFooter.this.rum.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    SnsSightUploadSayFooter.a(SnsSightUploadSayFooter.this);
                }
                a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightUploadSayFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99117);
            }
        });
        mMEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSightUploadSayFooter.AnonymousClass2 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return false;
            }
        });
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSightUploadSayFooter.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(99118);
                SnsSightUploadSayFooter.this.EJt.performClick();
                SnsSightUploadSayFooter.this.EJt.requestFocus();
                SnsSightUploadSayFooter.this.gte.showVKB();
                AppMethodBeat.o(99118);
            }
        }, 200);
        AppMethodBeat.o(99123);
    }

    private void cbM() {
        AppMethodBeat.i(99124);
        this.rum.onPause();
        this.rum.setVisibility(8);
        AppMethodBeat.o(99124);
    }

    @Override // com.tencent.mm.ui.BasePanelKeybordLayout
    public List<View> getPanelView() {
        AppMethodBeat.i(99125);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.rum);
        AppMethodBeat.o(99125);
        return arrayList;
    }

    public cjy getLocation() {
        AppMethodBeat.i(99126);
        cjy location = this.EJv.getLocation();
        AppMethodBeat.o(99126);
        return location;
    }

    static /* synthetic */ void d(SnsSightUploadSayFooter snsSightUploadSayFooter) {
        AppMethodBeat.i(99128);
        if (snsSightUploadSayFooter.rum.getVisibility() == 8) {
            snsSightUploadSayFooter.gte.hideVKB();
            snsSightUploadSayFooter.rum.onResume();
            snsSightUploadSayFooter.rum.setVisibility(0);
            snsSightUploadSayFooter.EJt.requestFocus();
            snsSightUploadSayFooter.ziQ.setImageResource(R.raw.sight_icon_keyboard);
            snsSightUploadSayFooter.ziU = false;
            AppMethodBeat.o(99128);
            return;
        }
        snsSightUploadSayFooter.ziU = false;
        snsSightUploadSayFooter.EJt.requestFocus();
        snsSightUploadSayFooter.cbM();
        snsSightUploadSayFooter.gte.showVKB();
        snsSightUploadSayFooter.ziQ.setImageResource(R.raw.sight_icon_emoji);
        AppMethodBeat.o(99128);
    }
}
