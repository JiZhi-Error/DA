package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.k;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;

public final class i {
    a Iyg;
    BroadcastReceiver Iyh = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.wear.model.i.AnonymousClass3 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(30030);
            if (intent.hasExtra("state") && intent.getIntExtra("state", 2) == 0) {
                i.this.fVY();
            }
            AppMethodBeat.o(30030);
        }
    };
    AudioManager audioManager = ((AudioManager) MMApplicationContext.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE));
    private k.a dJD = new k.a() {
        /* class com.tencent.mm.plugin.wear.model.i.AnonymousClass1 */

        @Override // com.tencent.mm.ak.k.a
        public final void onCompletion() {
            AppMethodBeat.i(30028);
            i.this.Iyg.qUl.a((k.b) null);
            i.this.Iyg.qUl.a((k.a) null);
            i.this.b(i.this.Iyg);
            AppMethodBeat.o(30028);
        }
    };
    private k.b dJE = new k.b() {
        /* class com.tencent.mm.plugin.wear.model.i.AnonymousClass2 */

        @Override // com.tencent.mm.ak.k.b
        public final void onError() {
            AppMethodBeat.i(30029);
            i.this.Iyg.qUl.a((k.b) null);
            i.this.Iyg.qUl.a((k.a) null);
            i.this.b(i.this.Iyg);
            AppMethodBeat.o(30029);
        }
    };

    /* access modifiers changed from: package-private */
    public class a {
        LinkedList<ca> Iyj;
        k qUl;
    }

    public i() {
        AppMethodBeat.i(30031);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        MMApplicationContext.getContext().registerReceiver(this.Iyh, intentFilter);
        AppMethodBeat.o(30031);
    }

    public final void fVY() {
        AppMethodBeat.i(30032);
        a(this.Iyg);
        AppMethodBeat.o(30032);
    }

    private static a a(a aVar) {
        AppMethodBeat.i(30033);
        if (aVar != null) {
            aVar.qUl.stop();
            aVar.qUl.a((k.b) null);
            aVar.qUl.a((k.a) null);
            aVar.Iyj.clear();
        }
        AppMethodBeat.o(30033);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void b(a aVar) {
        String fullPath;
        AppMethodBeat.i(30034);
        do {
            if (aVar != null) {
                if (aVar.Iyj.size() > 0) {
                    ca last = aVar.Iyj.getLast();
                    aVar.Iyj.removeLast();
                    s.ak(last);
                    fullPath = s.getFullPath(last.field_imgPath);
                    Log.i("MicroMsg.Wear.WearVoicePlayLogic", "play: msgid=%d, fullpath=%s", Long.valueOf(last.field_msgId), fullPath);
                } else {
                    a(aVar);
                }
            }
            AppMethodBeat.o(30034);
            return;
        } while (!aVar.qUl.a(fullPath, true, true, -1));
        aVar.qUl.a(this.dJD);
        aVar.qUl.a(this.dJE);
        AppMethodBeat.o(30034);
    }
}
