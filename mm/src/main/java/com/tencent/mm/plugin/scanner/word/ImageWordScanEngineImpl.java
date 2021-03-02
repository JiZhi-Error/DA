package com.tencent.mm.plugin.scanner.word;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Pair;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.word.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;

public class ImageWordScanEngineImpl implements LifecycleObserver, a<String, Integer> {
    private MutableLiveData<Pair<String, Integer>> CVx = new MutableLiveData<>();
    private MMActivity activity;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.plugin.scanner.word.a$a] */
    @Override // com.tencent.mm.plugin.scanner.word.a
    public final /* synthetic */ void a(String str, final a.AbstractC1683a<String, Integer> aVar) {
        AppMethodBeat.i(91130);
        final String str2 = str;
        Log.i("MicroMsg.ImageWordScanEngineImpl", "image word scan called");
        if (!this.CVx.hasObservers()) {
            if (this.activity == null || this.activity.isFinishing()) {
                Log.e("MicroMsg.ImageWordScanEngineImpl", "activity destroy called, just return");
                AppMethodBeat.o(91130);
                return;
            }
            this.CVx.observe(this.activity, new Observer<Pair<String, Integer>>() {
                /* class com.tencent.mm.plugin.scanner.word.ImageWordScanEngineImpl.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.arch.lifecycle.Observer
                public final /* synthetic */ void onChanged(Pair<String, Integer> pair) {
                    AppMethodBeat.i(91125);
                    Pair<String, Integer> pair2 = pair;
                    if (!(aVar == null || pair2 == null || ((Integer) pair2.second).intValue() == 0)) {
                        Log.i("MicroMsg.ImageWordScanEngineImpl", "onChanged called, path = %s, result = %d", pair2.first, pair2.second);
                        aVar.M(pair2.first, pair2.second);
                    }
                    AppMethodBeat.o(91125);
                }
            });
        }
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.scanner.word.ImageWordScanEngineImpl.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(91126);
                ImageWordScanEngineImpl.a(ImageWordScanEngineImpl.this, str2, com.tencent.worddetect.a.cZ(ImageWordScanEngineImpl.this.activity, str2));
                AppMethodBeat.o(91126);
            }
        }, "MicroMsg.ImageWordScanEngineImpl");
        AppMethodBeat.o(91130);
    }

    public ImageWordScanEngineImpl(MMActivity mMActivity) {
        AppMethodBeat.i(91128);
        mMActivity.getLifecycle().addObserver(this);
        this.activity = mMActivity;
        AppMethodBeat.o(91128);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        AppMethodBeat.i(91129);
        this.activity.getLifecycle().removeObserver(this);
        h.RTc.bqo("MicroMsg.ImageWordScanEngineImpl");
        this.activity = null;
        AppMethodBeat.o(91129);
    }

    static /* synthetic */ void a(ImageWordScanEngineImpl imageWordScanEngineImpl, final String str, final int i2) {
        AppMethodBeat.i(91131);
        Log.i("MicroMsg.ImageWordScanEngineImpl", "onScanEnd path = %s, result = %d", str, Integer.valueOf(i2));
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.scanner.word.ImageWordScanEngineImpl.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(91127);
                ImageWordScanEngineImpl.this.CVx.setValue(new Pair(str, Integer.valueOf(i2)));
                AppMethodBeat.o(91127);
            }
        });
        AppMethodBeat.o(91131);
    }
}
