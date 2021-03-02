package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wenote.model.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;

public class NoteEditorVoiceBaseView extends TextView implements a.AbstractC2008a {
    private Context context;
    public int dLt;
    private int duration = -1;
    private boolean isRunning = false;
    public String path = "";
    private AlphaAnimation qUh;
    private AnimationDrawable qUi;

    public NoteEditorVoiceBaseView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(30890);
        this.context = context2;
        blc();
        AppMethodBeat.o(30890);
    }

    public NoteEditorVoiceBaseView(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(30891);
        this.context = context2;
        blc();
        AppMethodBeat.o(30891);
    }

    private void blc() {
        AppMethodBeat.i(30892);
        this.qUh = new AlphaAnimation(0.1f, 1.0f);
        this.qUh.setDuration(1000);
        this.qUh.setRepeatCount(-1);
        this.qUh.setRepeatMode(2);
        this.qUi = new com.tencent.mm.ui.f.a();
        Drawable drawable = getResources().getDrawable(R.raw.chatfrom_voice_playing_new_f1);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.qUi.addFrame(drawable, 300);
        Drawable drawable2 = getResources().getDrawable(R.raw.chatfrom_voice_playing_new_f2);
        drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        this.qUi.addFrame(drawable2, 300);
        Drawable drawable3 = getResources().getDrawable(R.raw.chatfrom_voice_playing_new_f3);
        drawable3.setBounds(0, 0, drawable3.getIntrinsicWidth(), drawable3.getIntrinsicHeight());
        this.qUi.addFrame(drawable3, 300);
        this.qUi.setOneShot(false);
        this.qUi.setVisible(true, true);
        AppMethodBeat.o(30892);
    }

    public final void cEA() {
        AppMethodBeat.i(30893);
        if (this.qUh != null && this.qUh.isInitialized()) {
            setAnimation(null);
        }
        this.isRunning = false;
        setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.raw.chatfrom_voice_playing_new), (Drawable) null, (Drawable) null, (Drawable) null);
        this.qUi.stop();
        AppMethodBeat.o(30893);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(30894);
        super.onFinishInflate();
        setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteEditorVoiceBaseView.AnonymousClass1 */

            public final void onClick(View view) {
                String str;
                AppMethodBeat.i(30889);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteEditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Object[] objArr = new Object[3];
                objArr[0] = NoteEditorVoiceBaseView.this.path;
                if (a.gkl().cEF()) {
                    str = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
                } else {
                    str = "false";
                }
                objArr[1] = str;
                objArr[2] = a.gkl().path;
                Log.i("MicroMsg.NoteEditorVoiceBaseView", "clicked path:%s, player isPlay:%s, path:%s", objArr);
                if (com.tencent.mm.q.a.cC(NoteEditorVoiceBaseView.this.context) || com.tencent.mm.q.a.cA(NoteEditorVoiceBaseView.this.context) || com.tencent.mm.q.a.cE(NoteEditorVoiceBaseView.this.context)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteEditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(30889);
                } else if (!e.apn() && !Util.isNullOrNil(NoteEditorVoiceBaseView.this.path)) {
                    u.g(view.getContext(), null);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteEditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(30889);
                } else if (k.gjD().qPk) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteEditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(30889);
                } else {
                    if (!Util.nullAs(NoteEditorVoiceBaseView.this.path, "").equals(a.gkl().path) || !a.gkl().cEF()) {
                        NoteEditorVoiceBaseView.c(NoteEditorVoiceBaseView.this);
                    } else {
                        NoteEditorVoiceBaseView noteEditorVoiceBaseView = NoteEditorVoiceBaseView.this;
                        Log.d("MicroMsg.NoteEditorVoiceBaseView", "stop play");
                        noteEditorVoiceBaseView.cEA();
                        a.gkl().stopPlay();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/voiceview/NoteEditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(30889);
                }
            }
        });
        AppMethodBeat.o(30894);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.AbstractC2008a
    public final void alV(String str) {
        AppMethodBeat.i(30895);
        Log.d("MicroMsg.NoteEditorVoiceBaseView", "on play, my path %s, my duration %d, play path %s", this.path, Integer.valueOf(this.duration), str);
        if (!Util.nullAs(str, "").equals(this.path)) {
            cEA();
        }
        AppMethodBeat.o(30895);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.AbstractC2008a
    public final void cEB() {
        AppMethodBeat.i(30896);
        cEA();
        AppMethodBeat.o(30896);
    }

    static /* synthetic */ void c(NoteEditorVoiceBaseView noteEditorVoiceBaseView) {
        AppMethodBeat.i(30897);
        Log.d("MicroMsg.NoteEditorVoiceBaseView", "start play, path[%s] voiceType[%d]", noteEditorVoiceBaseView.path, Integer.valueOf(noteEditorVoiceBaseView.dLt));
        if (a.gkl().cZ(noteEditorVoiceBaseView.path, noteEditorVoiceBaseView.dLt)) {
            if (!noteEditorVoiceBaseView.isRunning) {
                noteEditorVoiceBaseView.isRunning = true;
                noteEditorVoiceBaseView.setCompoundDrawablesWithIntrinsicBounds(noteEditorVoiceBaseView.qUi, (Drawable) null, (Drawable) null, (Drawable) null);
                noteEditorVoiceBaseView.qUi.stop();
                noteEditorVoiceBaseView.qUi.start();
            }
            AppMethodBeat.o(30897);
            return;
        }
        Toast.makeText(noteEditorVoiceBaseView.getContext(), (int) R.string.cd4, 1).show();
        AppMethodBeat.o(30897);
    }
}
