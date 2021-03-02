package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.n;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class VoiceInputFooter extends BasePanelKeybordLayout {
    MMEditText EJt = null;
    n Kdp;
    ImageButton Kdq;
    private ImageButton Kdr;
    private boolean Kds = false;
    private boolean Kdt = false;
    private final int Kdu = 1;
    private final int Kdv = 2;
    private a Kdw;
    private MMActivity gte;
    private ChatFooterPanel rum;
    LinearLayout zDZ;

    public interface a {
        void gpd();

        void zR(boolean z);
    }

    static /* synthetic */ void a(VoiceInputFooter voiceInputFooter) {
        AppMethodBeat.i(31270);
        voiceInputFooter.gpb();
        AppMethodBeat.o(31270);
    }

    static /* synthetic */ void b(VoiceInputFooter voiceInputFooter) {
        AppMethodBeat.i(31271);
        voiceInputFooter.cbM();
        AppMethodBeat.o(31271);
    }

    public VoiceInputFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(31262);
        this.gte = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) aa.jQ(this.gte).inflate(R.layout.c6l, this);
        this.Kdr = (ImageButton) viewGroup.findViewById(R.id.lg);
        this.Kdr.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.VoiceInputFooter.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(31257);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/VoiceInputFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                VoiceInputFooter.c(VoiceInputFooter.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/VoiceInputFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(31257);
            }
        });
        this.Kdq = (ImageButton) viewGroup.findViewById(R.id.jj);
        this.Kdq.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.VoiceInputFooter.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(31258);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/VoiceInputFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                VoiceInputFooter.d(VoiceInputFooter.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/VoiceInputFooter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(31258);
            }
        });
        if (e.Knc == null) {
            this.rum = new d(this.gte);
            AppMethodBeat.o(31262);
            return;
        }
        this.rum = e.Knc.eZ(getContext());
        this.rum.setEntranceScene(ChatFooterPanel.KbB);
        this.rum.setVisibility(8);
        this.zDZ = (LinearLayout) findViewById(R.id.h8v);
        this.zDZ.setOnClickListener(null);
        this.zDZ.addView(this.rum, -1, KeyBoardUtil.getValidPanelHeight(getContext()));
        this.rum.goD();
        this.rum.onResume();
        this.rum.setOnTextOperationListener(new ChatFooterPanel.a() {
            /* class com.tencent.mm.pluginsdk.ui.VoiceInputFooter.AnonymousClass5 */

            @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
            public final void aHD() {
            }

            @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
            public final void eP(boolean z) {
            }

            @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
            public final void aHC() {
                AppMethodBeat.i(31259);
                VoiceInputFooter.this.EJt.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
                VoiceInputFooter.this.EJt.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
                AppMethodBeat.o(31259);
            }

            @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
            public final void append(String str) {
                AppMethodBeat.i(31260);
                try {
                    VoiceInputFooter.this.EJt.bol(str);
                    AppMethodBeat.o(31260);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.VoiceInputFooter", e2, "", new Object[0]);
                    AppMethodBeat.o(31260);
                }
            }
        });
        AppMethodBeat.o(31262);
    }

    public void setVoiceInputFooterListener(a aVar) {
        this.Kdw = aVar;
    }

    public final boolean fjI() {
        AppMethodBeat.i(31263);
        if (this.rum.getVisibility() == 0) {
            AppMethodBeat.o(31263);
            return true;
        }
        AppMethodBeat.o(31263);
        return false;
    }

    public final boolean gpa() {
        AppMethodBeat.i(31264);
        if (this.Kdp.getVisibility() == 0) {
            AppMethodBeat.o(31264);
            return true;
        }
        AppMethodBeat.o(31264);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void gpb() {
        AppMethodBeat.i(31265);
        this.Kds = false;
        if (this.Kdp != null) {
            this.Kdp.pause();
            this.Kdp.setVisibility(8);
            this.Kdr.setImageResource(R.drawable.b2q);
            this.Kdq.setVisibility(0);
            if (this.Kdw != null) {
                this.Kdw.zR(false);
            }
        }
        AppMethodBeat.o(31265);
    }

    /* access modifiers changed from: package-private */
    public final void cbM() {
        AppMethodBeat.i(31266);
        this.Kdt = false;
        this.rum.onPause();
        this.rum.setVisibility(8);
        AppMethodBeat.o(31266);
    }

    @Override // com.tencent.mm.ui.BasePanelKeybordLayout
    public List<View> getPanelView() {
        AppMethodBeat.i(31267);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.rum);
        arrayList.add(this.Kdp);
        AppMethodBeat.o(31267);
        return arrayList;
    }

    public final void release() {
        AppMethodBeat.i(31268);
        if (this.rum != null) {
            this.rum.goC();
            this.rum.destroy();
        }
        if (this.Kdp != null) {
            this.Kdp.destroy();
        }
        AppMethodBeat.o(31268);
    }

    private static void pl(int i2) {
        AppMethodBeat.i(31269);
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        if (i2 == 1) {
            voiceInputBehavior.smileIconClick = 1;
        } else if (i2 == 2) {
            voiceInputBehavior.voiceIconClick = 1;
        } else {
            AppMethodBeat.o(31269);
            return;
        }
        Log.i("MicroMsg.VoiceInputFooter", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime));
        log_13905 log_13905 = new log_13905();
        log_13905.viOp_ = voiceInputBehavior;
        h.INSTANCE.c(13905, log_13905);
        AppMethodBeat.o(31269);
    }

    static /* synthetic */ void c(VoiceInputFooter voiceInputFooter) {
        AppMethodBeat.i(31272);
        voiceInputFooter.EJt.requestFocus();
        if (voiceInputFooter.Kds) {
            voiceInputFooter.gpb();
            voiceInputFooter.gte.showVKB();
        } else {
            voiceInputFooter.Kds = true;
            voiceInputFooter.gte.hideVKB();
            if (voiceInputFooter.fjI()) {
                voiceInputFooter.cbM();
            }
            if (voiceInputFooter.Kdp != null) {
                voiceInputFooter.Kdp.setVisibility(0);
            }
            voiceInputFooter.Kdr.setImageResource(R.drawable.oh);
            voiceInputFooter.Kdq.setImageResource(R.drawable.of);
            voiceInputFooter.Kdq.setVisibility(8);
            if (voiceInputFooter.Kdw != null) {
                voiceInputFooter.Kdw.zR(true);
            }
        }
        pl(2);
        AppMethodBeat.o(31272);
    }

    static /* synthetic */ void d(VoiceInputFooter voiceInputFooter) {
        AppMethodBeat.i(31273);
        if (voiceInputFooter.gpa()) {
            voiceInputFooter.gpb();
        }
        if (!voiceInputFooter.Kdt) {
            voiceInputFooter.gte.hideVKB();
            voiceInputFooter.Kdt = true;
            voiceInputFooter.rum.onResume();
            voiceInputFooter.rum.setVisibility(0);
            voiceInputFooter.EJt.requestFocus();
            voiceInputFooter.Kdq.setImageResource(R.drawable.oh);
            voiceInputFooter.Kdr.setImageResource(R.drawable.b2q);
        } else {
            voiceInputFooter.EJt.requestFocus();
            voiceInputFooter.cbM();
            voiceInputFooter.gte.showVKB();
            voiceInputFooter.Kdq.setImageResource(R.drawable.of);
        }
        pl(1);
        AppMethodBeat.o(31273);
    }
}
