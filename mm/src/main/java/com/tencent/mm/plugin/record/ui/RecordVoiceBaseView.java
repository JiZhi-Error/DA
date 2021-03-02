package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.record.b.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.f.a;
import java.util.Iterator;

public class RecordVoiceBaseView extends TextView implements u.a {
    private u BIz;
    private Context context;
    public int dLt;
    public int duration = -1;
    private boolean isRunning = false;
    public String path = "";
    private AlphaAnimation qUh;
    private AnimationDrawable qUi;

    public RecordVoiceBaseView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(27982);
        this.context = context2;
        blc();
        AppMethodBeat.o(27982);
    }

    public RecordVoiceBaseView(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(27983);
        this.context = context2;
        blc();
        AppMethodBeat.o(27983);
    }

    private void blc() {
        AppMethodBeat.i(27984);
        this.qUh = new AlphaAnimation(0.1f, 1.0f);
        this.qUh.setDuration(1000);
        this.qUh.setRepeatCount(-1);
        this.qUh.setRepeatMode(2);
        this.qUi = new a();
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
        AppMethodBeat.o(27984);
    }

    private void cEA() {
        AppMethodBeat.i(27985);
        if (this.qUh != null && this.qUh.isInitialized()) {
            setAnimation(null);
        }
        this.isRunning = false;
        setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.raw.chatfrom_voice_playing_new), (Drawable) null, (Drawable) null, (Drawable) null);
        this.qUi.stop();
        AppMethodBeat.o(27985);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(27986);
        super.onFinishInflate();
        setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.record.ui.RecordVoiceBaseView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(27981);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/RecordVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.RecordVoiceBaseView", "clicked path %s, isPlay %s", RecordVoiceBaseView.this.path, Boolean.valueOf(RecordVoiceBaseView.this.BIz.cEF()));
                if (com.tencent.mm.q.a.cC(RecordVoiceBaseView.this.context) || com.tencent.mm.q.a.cA(RecordVoiceBaseView.this.context) || com.tencent.mm.q.a.cE(RecordVoiceBaseView.this.context)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(27981);
                } else if (e.apn() || Util.isNullOrNil(RecordVoiceBaseView.this.path)) {
                    if (!Util.nullAs(RecordVoiceBaseView.this.path, "").equals(RecordVoiceBaseView.this.BIz.path)) {
                        RecordVoiceBaseView.d(RecordVoiceBaseView.this);
                    } else if (RecordVoiceBaseView.this.BIz.cEF()) {
                        RecordVoiceBaseView.this.stopPlay();
                    } else if (!RecordVoiceBaseView.e(RecordVoiceBaseView.this)) {
                        RecordVoiceBaseView.d(RecordVoiceBaseView.this);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(27981);
                } else {
                    com.tencent.mm.ui.base.u.g(view.getContext(), null);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(27981);
                }
            }
        });
        AppMethodBeat.o(27986);
    }

    public void setVoiceHelper(u uVar) {
        AppMethodBeat.i(27987);
        this.BIz = uVar;
        u uVar2 = this.BIz;
        Iterator<u.a> it = uVar2.callbacks.iterator();
        while (true) {
            if (it.hasNext()) {
                if (this == it.next()) {
                    break;
                }
            } else {
                uVar2.callbacks.add(this);
                break;
            }
        }
        AppMethodBeat.o(27987);
    }

    public final void stopPlay() {
        AppMethodBeat.i(27988);
        Log.d("MicroMsg.RecordVoiceBaseView", "stop play");
        cEA();
        this.BIz.stopPlay();
        AppMethodBeat.o(27988);
    }

    @Override // com.tencent.mm.plugin.record.b.u.a
    public final void aKZ(String str) {
        AppMethodBeat.i(27989);
        Log.d("MicroMsg.RecordVoiceBaseView", "on play, my path %s, my duration %d, play path %s", this.path, Integer.valueOf(this.duration), str);
        if (!Util.nullAs(str, "").equals(this.path)) {
            cEA();
        }
        AppMethodBeat.o(27989);
    }

    @Override // com.tencent.mm.plugin.record.b.u.a
    public final void onFinish() {
        AppMethodBeat.i(27990);
        stopPlay();
        AppMethodBeat.o(27990);
    }

    static /* synthetic */ void d(RecordVoiceBaseView recordVoiceBaseView) {
        AppMethodBeat.i(27991);
        Log.d("MicroMsg.RecordVoiceBaseView", "start play, path[%s] voiceType[%d]", recordVoiceBaseView.path, Integer.valueOf(recordVoiceBaseView.dLt));
        if (recordVoiceBaseView.BIz.cZ(recordVoiceBaseView.path, recordVoiceBaseView.dLt)) {
            if (!recordVoiceBaseView.isRunning) {
                recordVoiceBaseView.isRunning = true;
                recordVoiceBaseView.setCompoundDrawablesWithIntrinsicBounds(recordVoiceBaseView.qUi, (Drawable) null, (Drawable) null, (Drawable) null);
                recordVoiceBaseView.qUi.stop();
                recordVoiceBaseView.qUi.start();
            }
            AppMethodBeat.o(27991);
            return;
        }
        Toast.makeText(recordVoiceBaseView.getContext(), (int) R.string.cd4, 1).show();
        AppMethodBeat.o(27991);
    }

    static /* synthetic */ boolean e(RecordVoiceBaseView recordVoiceBaseView) {
        AppMethodBeat.i(27992);
        Log.i("MicroMsg.RecordVoiceBaseView", "resume play");
        u uVar = recordVoiceBaseView.BIz;
        Log.i("MicroMsg.RecordVoiceHelper", "resume play");
        MMEntryLock.lock("keep_app_silent");
        if (uVar.qUl == null) {
            Log.w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
            AppMethodBeat.o(27992);
            return false;
        }
        boolean resume = uVar.qUl.resume();
        AppMethodBeat.o(27992);
        return resume;
    }
}
