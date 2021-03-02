package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.SynchronizedVideoPlayTextureView;
import com.tencent.mm.sdk.thread.ThreadPool;

public class TopStoryVideoPlayTextureView extends SynchronizedVideoPlayTextureView {
    private Object lock = new Object();

    public TopStoryVideoPlayTextureView(Context context) {
        super(context);
        AppMethodBeat.i(126151);
        AppMethodBeat.o(126151);
    }

    public TopStoryVideoPlayTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(126152);
        AppMethodBeat.o(126152);
    }

    public TopStoryVideoPlayTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(126153);
        AppMethodBeat.o(126153);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView, com.tencent.mm.pluginsdk.ui.tools.SynchronizedVideoPlayTextureView, com.tencent.mm.pluginsdk.ui.tools.j
    public final void stop() {
        AppMethodBeat.i(126156);
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.tools.SynchronizedVideoPlayTextureView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(169156);
                synchronized (SynchronizedVideoPlayTextureView.this.lock) {
                    try {
                        SynchronizedVideoPlayTextureView.b(SynchronizedVideoPlayTextureView.this);
                    } finally {
                        AppMethodBeat.o(169156);
                    }
                }
            }
        }, "player-stop");
        AppMethodBeat.o(126156);
    }
}
