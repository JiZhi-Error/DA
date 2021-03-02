package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.os.Message;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bl.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteEditorVoiceBaseView;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class c extends j {
    public NoteEditorVoiceBaseView JKM;
    private l JKN;
    public LinearLayout qOU;
    public LinearLayout qOV;
    public ImageView qOX;
    private TextView qOY;
    private TextView qOZ;
    private final MMHandler qPb = new MMHandler() {
        /* class com.tencent.mm.plugin.wenote.ui.nativenote.a.c.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(30850);
            if (c.this.JKN.qPO) {
                c.this.qPb.removeMessages(4096);
                AppMethodBeat.o(30850);
                return;
            }
            c.this.qOZ.setText(" " + a.J(MMApplicationContext.getContext(), c.this.JKN.qPQ).toString());
            sendEmptyMessageDelayed(4096, 500);
            AppMethodBeat.o(30850);
        }
    };

    public c(View view, k kVar) {
        super(view, kVar);
        AppMethodBeat.i(30851);
        this.qOU = (LinearLayout) view.findViewById(R.id.g1y);
        this.qOV = (LinearLayout) view.findViewById(R.id.g19);
        this.qOX = (ImageView) view.findViewById(R.id.g1z);
        this.qOY = (TextView) view.findViewById(R.id.g21);
        this.qOZ = (TextView) view.findViewById(R.id.g22);
        this.JKM = (NoteEditorVoiceBaseView) view.findViewById(R.id.g1d);
        com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.gkl().a(this.JKM);
        this.kmg.setVisibility(0);
        this.qOU.setVisibility(8);
        this.qOV.setVisibility(0);
        this.dKU.setVisibility(8);
        this.qOs.setVisibility(8);
        this.kmg.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wenote.ui.nativenote.a.c.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(30849);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteChatVoiceItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (c.this.JKN != null && c.this.JKN.qPX.booleanValue()) {
                    c.this.JKN.qPY = Boolean.TRUE;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteChatVoiceItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(30849);
            }
        });
        AppMethodBeat.o(30851);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a, com.tencent.mm.plugin.wenote.ui.nativenote.a.j
    public final void a(com.tencent.mm.plugin.wenote.model.a.c cVar, int i2, int i3) {
        AppMethodBeat.i(30852);
        this.JKN = (l) cVar;
        if (this.JKN.qPO) {
            this.qOV.setVisibility(0);
            this.qOU.setVisibility(8);
            this.kmg.setPadding(0, 0, 0, 0);
            if (cVar.qPH) {
                this.JKM.setBackgroundResource(R.drawable.b5h);
            } else {
                this.JKM.setBackgroundResource(R.drawable.b5g);
            }
            NoteEditorVoiceBaseView noteEditorVoiceBaseView = this.JKM;
            String str = this.JKN.dUs;
            int i4 = this.JKN.dLt;
            String str2 = this.JKN.qPR;
            noteEditorVoiceBaseView.path = Util.nullAs(str, "");
            noteEditorVoiceBaseView.dLt = i4;
            noteEditorVoiceBaseView.setText(str2);
        } else {
            this.kmg.setPadding(26, 7, 0, 7);
            this.qOV.setVisibility(8);
            this.qOU.setVisibility(0);
            ImageView imageView = this.qOX;
            if (imageView.getAnimation() != null) {
                imageView.startAnimation(imageView.getAnimation());
            } else {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(500);
                alphaAnimation.setInterpolator(new LinearInterpolator());
                alphaAnimation.setRepeatCount(-1);
                alphaAnimation.setRepeatMode(2);
                imageView.startAnimation(alphaAnimation);
            }
            if (this.JKN.qPX.booleanValue()) {
                this.qPb.sendEmptyMessage(4096);
                this.qOY.setText(R.string.cd_);
                this.qOZ.setText(" " + a.J(MMApplicationContext.getContext(), this.JKN.qPQ).toString());
            } else {
                this.qOY.setText(R.string.cd9);
                this.qOZ.setText(" " + a.J(MMApplicationContext.getContext(), (int) a.AO((long) this.JKN.dLu)).toString());
            }
        }
        super.a(cVar, i2, i3);
        AppMethodBeat.o(30852);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a
    public final int cCY() {
        return 20;
    }
}
