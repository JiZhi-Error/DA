package com.tencent.mm.plugin.fav.ui;

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
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.f.a;

public class FavChatVoiceView extends TextView implements n.a {
    private Context context;
    private int dLt;
    private int duration = -1;
    private boolean isRunning = false;
    private String path = "";
    private AlphaAnimation qUh;
    private AnimationDrawable qUi;
    private n tbL;

    public FavChatVoiceView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(106623);
        this.context = context2;
        blc();
        AppMethodBeat.o(106623);
    }

    public FavChatVoiceView(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(106624);
        this.context = context2;
        blc();
        AppMethodBeat.o(106624);
    }

    private void blc() {
        AppMethodBeat.i(106625);
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
        AppMethodBeat.o(106625);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(106626);
        super.onFinishInflate();
        setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavChatVoiceView.AnonymousClass1 */

            public final void onClick(View view) {
                String str;
                AppMethodBeat.i(106622);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavChatVoiceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Object[] objArr = new Object[3];
                objArr[0] = FavChatVoiceView.this.path;
                if (FavChatVoiceView.this.tbL.cEF()) {
                    str = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
                } else {
                    str = "false";
                }
                objArr[1] = str;
                objArr[2] = FavChatVoiceView.this.tbL.path;
                Log.i("MicroMsg.FavChatVoiceView", "clicked path:%s, player isPlay:%s, path:%s", objArr);
                if (com.tencent.mm.q.a.cC(FavChatVoiceView.this.context) || com.tencent.mm.q.a.cA(FavChatVoiceView.this.context) || com.tencent.mm.q.a.cE(FavChatVoiceView.this.context)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavChatVoiceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(106622);
                } else if (e.apn() || Util.isNullOrNil(FavChatVoiceView.this.path)) {
                    if (!Util.nullAs(FavChatVoiceView.this.path, "").equals(FavChatVoiceView.this.tbL.path) || !FavChatVoiceView.this.tbL.cEF()) {
                        FavChatVoiceView.d(FavChatVoiceView.this);
                    } else {
                        FavChatVoiceView.this.stopPlay();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavChatVoiceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(106622);
                } else {
                    u.g(view.getContext(), null);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavChatVoiceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(106622);
                }
            }
        });
        AppMethodBeat.o(106626);
    }

    public final void I(String str, int i2, String str2) {
        AppMethodBeat.i(106627);
        this.path = Util.nullAs(str, "");
        this.dLt = i2;
        setText(str2);
        AppMethodBeat.o(106627);
    }

    public final void stopPlay() {
        AppMethodBeat.i(106628);
        Log.d("MicroMsg.FavChatVoiceView", "stop play");
        if (this.qUh != null && this.qUh.isInitialized()) {
            setAnimation(null);
        }
        this.isRunning = false;
        setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.raw.chatfrom_voice_playing_new), (Drawable) null, (Drawable) null, (Drawable) null);
        this.qUi.stop();
        this.tbL.stopPlay();
        AppMethodBeat.o(106628);
    }

    public void setVoiceHelper(n nVar) {
        AppMethodBeat.i(106629);
        this.tbL = nVar;
        this.tbL.a(this);
        AppMethodBeat.o(106629);
    }

    @Override // com.tencent.mm.plugin.fav.a.n.a
    public final void dt(String str, int i2) {
        AppMethodBeat.i(106630);
        if (!this.path.equals(str)) {
            stopPlay();
        }
        AppMethodBeat.o(106630);
    }

    @Override // com.tencent.mm.plugin.fav.a.n.a
    public final void onFinish() {
        AppMethodBeat.i(106631);
        stopPlay();
        AppMethodBeat.o(106631);
    }

    @Override // com.tencent.mm.plugin.fav.a.n.a
    public final void onPause() {
        AppMethodBeat.i(106632);
        stopPlay();
        AppMethodBeat.o(106632);
    }

    static /* synthetic */ void d(FavChatVoiceView favChatVoiceView) {
        AppMethodBeat.i(106633);
        Log.d("MicroMsg.FavChatVoiceView", "start play, path[%s] voiceType[%d]", favChatVoiceView.path, Integer.valueOf(favChatVoiceView.dLt));
        if (favChatVoiceView.tbL.cZ(favChatVoiceView.path, favChatVoiceView.dLt)) {
            if (!favChatVoiceView.isRunning) {
                favChatVoiceView.isRunning = true;
                favChatVoiceView.setCompoundDrawablesWithIntrinsicBounds(favChatVoiceView.qUi, (Drawable) null, (Drawable) null, (Drawable) null);
                favChatVoiceView.qUi.stop();
                favChatVoiceView.qUi.start();
            }
            AppMethodBeat.o(106633);
            return;
        }
        Toast.makeText(favChatVoiceView.getContext(), (int) R.string.cd4, 1).show();
        AppMethodBeat.o(106633);
    }
}
