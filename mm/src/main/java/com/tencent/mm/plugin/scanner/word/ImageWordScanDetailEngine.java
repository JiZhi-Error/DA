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
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.worddetect.WordDetectNative;
import java.util.concurrent.ConcurrentHashMap;

public class ImageWordScanDetailEngine implements LifecycleObserver, a<String, b> {
    private MutableLiveData<Pair<String, b>> CVx = new MutableLiveData<>();
    private ConcurrentHashMap<String, WordDetectNative.WordDetectDetailResult> CVy = new ConcurrentHashMap<>();
    private MMActivity activity;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.plugin.scanner.word.a$a] */
    @Override // com.tencent.mm.plugin.scanner.word.a
    public final /* synthetic */ void a(String str, final a.AbstractC1683a<String, b> aVar) {
        AppMethodBeat.i(194818);
        final String str2 = str;
        if (Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.ImageWordScanEngineImpl", "input is  nil");
            AppMethodBeat.o(194818);
            return;
        }
        Log.i("MicroMsg.ImageWordScanEngineImpl", "image word scan called");
        if (!this.CVx.hasObservers()) {
            if (this.activity == null || this.activity.isFinishing()) {
                Log.e("MicroMsg.ImageWordScanEngineImpl", "activity destroy called, just return");
                AppMethodBeat.o(194818);
                return;
            }
            this.CVx.observe(this.activity, new Observer<Pair<String, b>>() {
                /* class com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.arch.lifecycle.Observer
                public final /* synthetic */ void onChanged(Pair<String, b> pair) {
                    AppMethodBeat.i(194813);
                    Pair<String, b> pair2 = pair;
                    if (!(aVar == null || pair2 == null)) {
                        aVar.M(pair2.first, pair2.second);
                    }
                    AppMethodBeat.o(194813);
                }
            });
        }
        h.RTc.bqo("MicroMsg.ImageWordScanEngineImpl");
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine.AnonymousClass2 */

            public final void run() {
                WordDetectNative.WordDetectDetailResult da;
                AppMethodBeat.i(194814);
                if (ImageWordScanDetailEngine.this.CVy.contains(str2)) {
                    da = (WordDetectNative.WordDetectDetailResult) ImageWordScanDetailEngine.this.CVy.get(str2);
                } else {
                    da = com.tencent.worddetect.a.da(ImageWordScanDetailEngine.this.activity, str2);
                    ImageWordScanDetailEngine.this.CVy.put(str2, da);
                }
                ImageWordScanDetailEngine.a(ImageWordScanDetailEngine.this, str2, new b(da));
                AppMethodBeat.o(194814);
            }
        }, "MicroMsg.ImageWordScanEngineImpl");
        AppMethodBeat.o(194818);
    }

    public ImageWordScanDetailEngine(MMActivity mMActivity) {
        AppMethodBeat.i(194816);
        mMActivity.getLifecycle().addObserver(this);
        this.activity = mMActivity;
        AppMethodBeat.o(194816);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onActivityDestroy() {
        AppMethodBeat.i(194817);
        this.CVy.clear();
        this.activity.getLifecycle().removeObserver(this);
        h.RTc.bqo("MicroMsg.ImageWordScanEngineImpl");
        this.activity = null;
        AppMethodBeat.o(194817);
    }

    static /* synthetic */ void a(ImageWordScanDetailEngine imageWordScanDetailEngine, final String str, final b bVar) {
        AppMethodBeat.i(194819);
        Log.i("MicroMsg.ImageWordScanEngineImpl", "onScanEnd path = %s, result = %s", str, bVar.CVF);
        h.RTc.aV(new Runnable() {
            /* class com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(194815);
                ImageWordScanDetailEngine.this.CVx.setValue(new Pair(str, bVar));
                AppMethodBeat.o(194815);
            }
        });
        AppMethodBeat.o(194819);
    }
}
