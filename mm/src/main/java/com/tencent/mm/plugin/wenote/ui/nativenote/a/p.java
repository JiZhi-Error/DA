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
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class p extends j {
    private l JKN;
    public NoteVoiceView JLj;
    private LinearLayout kmg;
    public LinearLayout qOU;
    public LinearLayout qOV;
    public ImageView qOX;
    private TextView qOY;
    private TextView qOZ;
    private final MMHandler qPb = new MMHandler() {
        /* class com.tencent.mm.plugin.wenote.ui.nativenote.a.p.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(30886);
            if (p.this.JKN.qPO) {
                p.this.qPb.removeMessages(4096);
                AppMethodBeat.o(30886);
                return;
            }
            p.this.qOZ.setText(" " + a.J(MMApplicationContext.getContext(), p.this.JKN.qPQ).toString());
            sendEmptyMessageDelayed(4096, 500);
            AppMethodBeat.o(30886);
        }
    };

    public p(View view, k kVar) {
        super(view, kVar);
        AppMethodBeat.i(30887);
        this.kmg = (LinearLayout) view.findViewById(R.id.g1w);
        this.qOU = (LinearLayout) view.findViewById(R.id.g1y);
        this.qOV = (LinearLayout) view.findViewById(R.id.g1x);
        this.qOX = (ImageView) view.findViewById(R.id.g1z);
        this.qOY = (TextView) view.findViewById(R.id.g21);
        this.qOZ = (TextView) view.findViewById(R.id.g22);
        this.JLj = (NoteVoiceView) view.findViewById(R.id.g1e);
        this.JLj.setVoiceHelper(com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.gkl());
        this.kmg.setVisibility(0);
        this.qOU.setVisibility(8);
        this.qOV.setVisibility(0);
        this.dKU.setVisibility(8);
        this.qOs.setVisibility(8);
        this.kmg.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wenote.ui.nativenote.a.p.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(30885);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteVoiceItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (p.this.JKN != null && p.this.JKN.qPX.booleanValue()) {
                    p.this.JKN.qPY = Boolean.TRUE;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteVoiceItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(30885);
            }
        });
        AppMethodBeat.o(30887);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a, com.tencent.mm.plugin.wenote.ui.nativenote.a.j
    public final void a(c cVar, int i2, int i3) {
        boolean z;
        boolean YY;
        AppMethodBeat.i(30888);
        this.JKN = (l) cVar;
        if (this.JKN.qPO) {
            this.kmg.setBackgroundResource(0);
            this.qOV.setVisibility(0);
            this.qOU.setVisibility(8);
            this.kmg.setPadding(0, 0, 0, 0);
            if (cVar.qPH) {
                z = true;
            } else {
                z = false;
            }
            NoteVoiceView noteVoiceView = this.JLj;
            String str = this.JKN.dUs;
            int i4 = this.JKN.dLt;
            int i5 = this.JKN.dLu;
            noteVoiceView.path = Util.nullAs(str, "");
            noteVoiceView.dLt = i4;
            noteVoiceView.duration = i5;
            if (z) {
                noteVoiceView.maskView.setVisibility(0);
            } else {
                noteVoiceView.maskView.setVisibility(8);
            }
            if (!noteVoiceView.path.equals(noteVoiceView.JLo.path)) {
                noteVoiceView.JLp.FD(i5);
            } else if (noteVoiceView.JLo.cEF()) {
                Log.i("MicroMsg.NoteVoiceView", "updateInfo .isPlay()");
                NoteVoiceView.a aVar = noteVoiceView.JLp;
                noteVoiceView.JLo.ZY();
                aVar.lp(true);
            } else {
                com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a aVar2 = noteVoiceView.JLo;
                if (aVar2.qUl == null) {
                    Log.w("MicroMsg.RecordVoiceHelper", "check is pause, but player is null");
                    YY = false;
                } else {
                    YY = aVar2.qUl.YY();
                }
                if (YY) {
                    Log.i("MicroMsg.NoteVoiceView", "updateInfo .isPause()");
                    NoteVoiceView.a aVar3 = noteVoiceView.JLp;
                    noteVoiceView.JLo.ZY();
                    aVar3.lp(false);
                } else {
                    noteVoiceView.JLp.FD(i5);
                }
            }
        } else {
            this.kmg.setBackgroundResource(R.drawable.b5x);
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
        AppMethodBeat.o(30888);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a
    public final int cCY() {
        return 4;
    }
}
