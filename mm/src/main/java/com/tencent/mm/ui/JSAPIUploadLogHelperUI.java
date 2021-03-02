package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.av;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.d;

public class JSAPIUploadLogHelperUI extends MMBaseActivity {
    private static byte[] ODG = new byte[0];
    private static volatile boolean mIsRunning = false;

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(33288);
        Log.i("MicroMsg.JSAPIUploadLogHelperUI", "onCreate called, isRunning:%b", Boolean.valueOf(mIsRunning));
        super.onCreate(bundle);
        setContentView(R.layout.hl);
        synchronized (ODG) {
            try {
                if (mIsRunning) {
                    Log.w("MicroMsg.JSAPIUploadLogHelperUI", "reentered while last one is running, finish myself.");
                    finish();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(33288);
                throw th;
            }
        }
        final String stringExtra = getIntent().getStringExtra("key_user");
        final int intExtra = getIntent().getIntExtra("key_time", 0);
        Object[] objArr = new Object[2];
        if (stringExtra == null || !stringExtra.equals(z.aTY())) {
            z = false;
        } else {
            z = true;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(intExtra);
        Log.i("MicroMsg.JSAPIUploadLogHelperUI", "upload log from jsapi, in upload activity, username-recv-well:%b, time:%d", objArr);
        if (stringExtra == null) {
            Log.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: userName is null.");
            finish();
            AppMethodBeat.o(33288);
        } else if (intExtra < 0) {
            Log.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: illegal time value: %d", Integer.valueOf(intExtra));
            finish();
            AppMethodBeat.o(33288);
        } else {
            getString(R.string.zb);
            final q a2 = h.a((Context) this, getString(R.string.j5c), false, (DialogInterface.OnCancelListener) null);
            bg.azz().a(new bu(new bu.a() {
                /* class com.tencent.mm.ui.JSAPIUploadLogHelperUI.AnonymousClass1 */

                @Override // com.tencent.mm.model.bu.a
                public final void a(g gVar) {
                    AppMethodBeat.i(33285);
                    synchronized (JSAPIUploadLogHelperUI.ODG) {
                        try {
                            boolean unused = JSAPIUploadLogHelperUI.mIsRunning = true;
                        } catch (Throwable th) {
                            AppMethodBeat.o(33285);
                            throw th;
                        }
                    }
                    bg.azz().a(1, "", 0, false);
                    Log.appenderFlush();
                    bg.azz().a(2, stringExtra, intExtra, bg.aAc());
                    AppMethodBeat.o(33285);
                }
            }), 0);
            final AnonymousClass2 r1 = new DialogInterface.OnDismissListener() {
                /* class com.tencent.mm.ui.JSAPIUploadLogHelperUI.AnonymousClass2 */

                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(33286);
                    if (!JSAPIUploadLogHelperUI.this.isFinishing()) {
                        JSAPIUploadLogHelperUI.this.finish();
                    }
                    AppMethodBeat.o(33286);
                }
            };
            bg.a(new av() {
                /* class com.tencent.mm.ui.JSAPIUploadLogHelperUI.AnonymousClass3 */

                @Override // com.tencent.mm.model.av
                public final void rU(int i2) {
                    AppMethodBeat.i(33287);
                    if (i2 < 0) {
                        Log.e("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, error happened, percent:%d", Integer.valueOf(i2));
                        bg.a((av) null);
                        if (a2 != null) {
                            a2.dismiss();
                        }
                        d n = h.n(JSAPIUploadLogHelperUI.this, R.string.htd, R.string.zb);
                        if (n != null) {
                            n.setOnDismissListener(r1);
                        }
                        synchronized (JSAPIUploadLogHelperUI.ODG) {
                            try {
                                boolean unused = JSAPIUploadLogHelperUI.mIsRunning = false;
                            } finally {
                                AppMethodBeat.o(33287);
                            }
                        }
                    } else if (i2 >= 100) {
                        Log.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi done.");
                        bg.a((av) null);
                        if (a2 != null) {
                            a2.dismiss();
                        }
                        d n2 = h.n(JSAPIUploadLogHelperUI.this, R.string.hth, R.string.zb);
                        if (n2 != null) {
                            n2.setOnDismissListener(r1);
                        }
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(12975, Long.valueOf(System.currentTimeMillis() / 1000));
                        synchronized (JSAPIUploadLogHelperUI.ODG) {
                            try {
                                boolean unused2 = JSAPIUploadLogHelperUI.mIsRunning = false;
                            } finally {
                                AppMethodBeat.o(33287);
                            }
                        }
                    } else {
                        Log.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, ipxx progress:%d", Integer.valueOf(i2));
                        if (a2 != null) {
                            a2.setMessage(JSAPIUploadLogHelperUI.this.getString(R.string.hte) + i2 + "%");
                        }
                        AppMethodBeat.o(33287);
                    }
                }
            });
            AppMethodBeat.o(33288);
        }
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(33289);
        Log.i("MicroMsg.JSAPIUploadLogHelperUI", "onDestroy called, isRunning:%b", Boolean.valueOf(mIsRunning));
        super.onDestroy();
        AppMethodBeat.o(33289);
    }
}
