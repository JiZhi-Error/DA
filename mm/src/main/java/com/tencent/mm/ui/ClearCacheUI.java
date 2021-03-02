package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.g.b;
import com.tencent.mm.g.a.cb;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;

public class ClearCacheUI extends MMBaseActivity {
    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(32994);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_message");
        final long longExtra = getIntent().getLongExtra("key_mask", 0);
        h.a((Context) this, stringExtra, getString(R.string.b5q), getString(R.string.b5p), getString(R.string.b5n), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.ClearCacheUI.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(32990);
                ClearCacheUI.a(ClearCacheUI.this, longExtra);
                ClearCacheUI.this.finish();
                AppMethodBeat.o(32990);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.ClearCacheUI.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(32991);
                ClearCacheUI.this.finish();
                AppMethodBeat.o(32991);
            }
        });
        AppMethodBeat.o(32994);
    }

    static /* synthetic */ void a(ClearCacheUI clearCacheUI, final long j2) {
        AppMethodBeat.i(32995);
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.ui.ClearCacheUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(32993);
                Log.w("MicroMsg.ClearCacheUI", "doClearCache flag %d", Long.valueOf(j2));
                if ((j2 & 1) != 0) {
                    s.dy("wcf://bizimg/", true);
                }
                if ((j2 & 2) != 0) {
                    s.dy(b.icT, true);
                }
                if ((j2 & 4) != 0) {
                    s.dy(com.tencent.mm.loader.j.b.aKQ(), true);
                }
                if ((j2 & 8) != 0) {
                    bg.aVF();
                    s.dy(c.aTh(), true);
                }
                if ((j2 & 16) != 0) {
                    s.dy(com.tencent.mm.plugin.avatar.c.ceF(), true);
                }
                if ((j2 & 32) != 0) {
                    bg.aVF();
                    s.dy(c.aTc(), true);
                }
                if ((j2 & 64) != 0) {
                    bg.aVF();
                    s.dy(c.getAccSnsPath(), true);
                }
                cb cbVar = new cb();
                cbVar.dFh.dFi = j2;
                EventCenter.instance.publish(cbVar);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.ClearCacheUI.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(32992);
                        Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.b5o), 0).show();
                        AppMethodBeat.o(32992);
                    }
                });
                AppMethodBeat.o(32993);
            }
        }, "CleanCacheUIThread");
        AppMethodBeat.o(32995);
    }
}
