package com.tencent.mm.plugin.emoji.ui;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;

public abstract class EmojiBaseActivity extends MMActivity {
    b rfA;
    private a rfz;

    public abstract void j(Message message);

    public abstract void k(Message message);

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.rfz = new a(com.tencent.f.j.a.bqt("EmojiBaseActivity_handlerThread"));
        this.rfA = new b(getMainLooper());
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        if (!(this.rfz == null || this.rfz.getLooper() == null)) {
            this.rfz.getSerial().RUS.quit();
        }
        this.rfz = null;
        this.rfA = null;
    }

    class b extends MMHandler {
        b(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(108858);
            super.handleMessage(message);
            EmojiBaseActivity.this.k(message);
            AppMethodBeat.o(108858);
        }
    }

    public final void fC(int i2, int i3) {
        if (this.rfA != null) {
            this.rfA.sendEmptyMessageDelayed(i2, (long) i3);
        }
    }

    public final void l(Message message) {
        if (this.rfA != null) {
            this.rfA.sendMessage(message);
        }
    }

    public final void cHg() {
        if (this.rfA != null) {
            this.rfA.removeMessages(131074);
        }
    }

    class a extends MMHandler {
        a(com.tencent.f.j.a aVar) {
            super(aVar);
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(108857);
            super.handleMessage(message);
            EmojiBaseActivity.this.j(message);
            AppMethodBeat.o(108857);
        }
    }

    public final void m(Message message) {
        if (this.rfz != null) {
            this.rfz.sendMessage(message);
        }
    }
}
