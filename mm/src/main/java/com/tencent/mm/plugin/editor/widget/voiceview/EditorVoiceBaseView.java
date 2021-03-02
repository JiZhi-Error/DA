package com.tencent.mm.plugin.editor.widget.voiceview;

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
import com.tencent.mm.plugin.editor.model.c;
import com.tencent.mm.plugin.editor.widget.voiceview.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;

public class EditorVoiceBaseView extends TextView implements a.AbstractC0951a {
    private Context context;
    private int dLt;
    private int duration = -1;
    private boolean isRunning = false;
    private String path = "";
    private AlphaAnimation qUh;
    private AnimationDrawable qUi;

    public EditorVoiceBaseView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(181995);
        this.context = context2;
        blc();
        AppMethodBeat.o(181995);
    }

    public EditorVoiceBaseView(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(181996);
        this.context = context2;
        blc();
        AppMethodBeat.o(181996);
    }

    private void blc() {
        AppMethodBeat.i(181997);
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
        AppMethodBeat.o(181997);
    }

    public final void cEA() {
        AppMethodBeat.i(181998);
        if (this.qUh != null && this.qUh.isInitialized()) {
            setAnimation(null);
        }
        this.isRunning = false;
        setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.raw.chatfrom_voice_playing_new), (Drawable) null, (Drawable) null, (Drawable) null);
        this.qUi.stop();
        AppMethodBeat.o(181998);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(181999);
        super.onFinishInflate();
        setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.editor.widget.voiceview.EditorVoiceBaseView.AnonymousClass1 */

            public final void onClick(View view) {
                String str;
                AppMethodBeat.i(181994);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Object[] objArr = new Object[3];
                objArr[0] = EditorVoiceBaseView.this.path;
                if (a.cEC().cEF()) {
                    str = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
                } else {
                    str = "false";
                }
                objArr[1] = str;
                objArr[2] = a.cEC().path;
                Log.i("MicroMsg.NoteEditorVoiceBaseView", "clicked path:%s, player isPlay:%s, path:%s", objArr);
                if (com.tencent.mm.q.a.cC(EditorVoiceBaseView.this.context) || com.tencent.mm.q.a.cA(EditorVoiceBaseView.this.context) || com.tencent.mm.q.a.cE(EditorVoiceBaseView.this.context)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(181994);
                } else if (!e.apn() && !Util.isNullOrNil(EditorVoiceBaseView.this.path)) {
                    u.g(view.getContext(), null);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(181994);
                } else if (c.cCZ().qPk) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(181994);
                } else {
                    if (!Util.nullAs(EditorVoiceBaseView.this.path, "").equals(a.cEC().path) || !a.cEC().cEF()) {
                        EditorVoiceBaseView.c(EditorVoiceBaseView.this);
                    } else {
                        EditorVoiceBaseView editorVoiceBaseView = EditorVoiceBaseView.this;
                        Log.d("MicroMsg.NoteEditorVoiceBaseView", "stop play");
                        editorVoiceBaseView.cEA();
                        a.cEC().stopPlay();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(181994);
                }
            }
        });
        AppMethodBeat.o(181999);
    }

    @Override // com.tencent.mm.plugin.editor.widget.voiceview.a.AbstractC0951a
    public final void alV(String str) {
        AppMethodBeat.i(182000);
        Log.d("MicroMsg.NoteEditorVoiceBaseView", "on play, my path %s, my duration %d, play path %s", this.path, Integer.valueOf(this.duration), str);
        if (!Util.nullAs(str, "").equals(this.path)) {
            cEA();
        }
        AppMethodBeat.o(182000);
    }

    @Override // com.tencent.mm.plugin.editor.widget.voiceview.a.AbstractC0951a
    public final void cEB() {
        AppMethodBeat.i(182001);
        cEA();
        AppMethodBeat.o(182001);
    }

    static /* synthetic */ void c(EditorVoiceBaseView editorVoiceBaseView) {
        AppMethodBeat.i(182002);
        Log.d("MicroMsg.NoteEditorVoiceBaseView", "start play, path[%s] voiceType[%d]", editorVoiceBaseView.path, Integer.valueOf(editorVoiceBaseView.dLt));
        if (a.cEC().cZ(editorVoiceBaseView.path, editorVoiceBaseView.dLt)) {
            if (!editorVoiceBaseView.isRunning) {
                editorVoiceBaseView.isRunning = true;
                editorVoiceBaseView.setCompoundDrawablesWithIntrinsicBounds(editorVoiceBaseView.qUi, (Drawable) null, (Drawable) null, (Drawable) null);
                editorVoiceBaseView.qUi.stop();
                editorVoiceBaseView.qUi.start();
            }
            AppMethodBeat.o(182002);
            return;
        }
        Toast.makeText(editorVoiceBaseView.getContext(), (int) R.string.cd4, 1).show();
        AppMethodBeat.o(182002);
    }
}
