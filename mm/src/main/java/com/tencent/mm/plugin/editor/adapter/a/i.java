package com.tencent.mm.plugin.editor.adapter.a;

import android.os.Message;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.editor.b;
import com.tencent.mm.plugin.editor.model.a.m;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;
import com.tencent.mm.plugin.editor.widget.voiceview.VoiceView;
import com.tencent.mm.plugin.editor.widget.voiceview.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class i extends d {
    private LinearLayout kmg;
    public LinearLayout qOU;
    public LinearLayout qOV;
    public VoiceView qOW;
    public ImageView qOX;
    private TextView qOY;
    private TextView qOZ;
    private m qPa;
    private final MMHandler qPb = new MMHandler() {
        /* class com.tencent.mm.plugin.editor.adapter.a.i.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(181666);
            if (i.this.qPa.qPO) {
                i.this.qPb.removeMessages(4096);
                AppMethodBeat.o(181666);
                return;
            }
            i.this.qOZ.setText(" " + b.J(MMApplicationContext.getContext(), i.this.qPa.qPQ).toString());
            sendEmptyMessageDelayed(4096, 500);
            AppMethodBeat.o(181666);
        }
    };

    public i(View view, j jVar) {
        super(view, jVar);
        AppMethodBeat.i(181667);
        this.kmg = (LinearLayout) view.findViewById(R.id.g1w);
        this.qOU = (LinearLayout) view.findViewById(R.id.g1y);
        this.qOV = (LinearLayout) view.findViewById(R.id.g1x);
        this.qOX = (ImageView) view.findViewById(R.id.g1z);
        this.qOY = (TextView) view.findViewById(R.id.g21);
        this.qOZ = (TextView) view.findViewById(R.id.g22);
        this.qOW = (VoiceView) view.findViewById(R.id.g1e);
        this.qOW.setVoiceHelper(a.cEC());
        this.kmg.setVisibility(0);
        this.qOU.setVisibility(8);
        this.qOV.setVisibility(0);
        this.dKU.setVisibility(8);
        this.qOs.setVisibility(8);
        this.kmg.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.editor.adapter.a.i.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(181665);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/adapter/itemholder/EditorVoiceItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (i.this.qPa != null && i.this.qPa.qPX.booleanValue()) {
                    i.this.qPa.qPY = Boolean.TRUE;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorVoiceItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(181665);
            }
        });
        AppMethodBeat.o(181667);
    }

    @Override // com.tencent.mm.plugin.editor.adapter.a.d, com.tencent.mm.plugin.editor.adapter.a.a
    public final void a(com.tencent.mm.plugin.editor.model.a.a aVar, int i2, int i3) {
        boolean z;
        boolean YY;
        AppMethodBeat.i(181668);
        this.qPa = (m) aVar;
        if (this.qPa.qPO) {
            this.kmg.setBackgroundResource(0);
            this.qOV.setVisibility(0);
            this.qOU.setVisibility(8);
            this.kmg.setPadding(0, 0, 0, 0);
            if (aVar.qPH) {
                z = true;
            } else {
                z = false;
            }
            VoiceView voiceView = this.qOW;
            String str = this.qPa.dUs;
            int i4 = this.qPa.dLt;
            int i5 = this.qPa.dLu;
            voiceView.path = Util.nullAs(str, "");
            voiceView.dLt = i4;
            voiceView.duration = i5;
            if (z) {
                voiceView.maskView.setVisibility(0);
            } else {
                voiceView.maskView.setVisibility(8);
            }
            if (!voiceView.path.equals(voiceView.qUw.path)) {
                voiceView.qUx.FD(i5);
            } else if (voiceView.qUw.cEF()) {
                Log.i("MicroMsg.NoteVoiceView", "updateInfo .isPlay()");
                VoiceView.a aVar2 = voiceView.qUx;
                voiceView.qUw.ZY();
                aVar2.lp(true);
            } else {
                a aVar3 = voiceView.qUw;
                if (aVar3.qUl == null) {
                    Log.w("MicroMsg.RecordVoiceHelper", "check is pause, but player is null");
                    YY = false;
                } else {
                    YY = aVar3.qUl.YY();
                }
                if (YY) {
                    Log.i("MicroMsg.NoteVoiceView", "updateInfo .isPause()");
                    VoiceView.a aVar4 = voiceView.qUx;
                    voiceView.qUw.ZY();
                    aVar4.lp(false);
                } else {
                    voiceView.qUx.FD(i5);
                }
            }
        } else {
            this.kmg.setBackgroundResource(R.drawable.t4);
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
            if (this.qPa.qPX.booleanValue()) {
                this.qPb.sendEmptyMessage(4096);
                this.qOY.setText(R.string.cd_);
                this.qOZ.setText(" " + b.J(MMApplicationContext.getContext(), this.qPa.qPQ).toString());
            } else {
                this.qOY.setText(R.string.cd9);
                this.qOZ.setText(" " + b.J(MMApplicationContext.getContext(), (int) b.AO((long) this.qPa.dLu)).toString());
            }
        }
        super.a(aVar, i2, i3);
        AppMethodBeat.o(181668);
    }

    @Override // com.tencent.mm.plugin.editor.adapter.a.a
    public final int cCY() {
        return 4;
    }
}
