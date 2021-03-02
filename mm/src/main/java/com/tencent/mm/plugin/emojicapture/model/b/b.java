package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixFrameSyncMgr;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MixFrameSyncMgr;", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;", "videoPlayRate", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;I)V", "TAG", "plugin-emojicapture_release"})
public final class b extends g {
    private final String TAG = "MicroMsg.EmojiMixFrameSyncMgr";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(String str, com.tencent.mm.plugin.recordvideo.ui.editor.b.b bVar, int i2) {
        super(str, bVar);
        p.h(str, "videoPath");
        p.h(bVar, "emojiFrameRetriever");
        AppMethodBeat.i(256432);
        this.CdV = i2 * 20;
        if (this.CdV > 30) {
            this.CdV = 30;
        }
        this.CdW /= (float) i2;
        this.CdY = 1000.0f / ((float) this.CdV);
        if (this.CdY < this.CdW) {
            this.CdY = this.CdW;
        }
        this.CdT = (int) (((float) (this.videoDuration / i2)) / this.CdY);
        this.CdU = 0;
        Log.i(this.TAG, "init MixFrameSyncMgr,videoPath:" + str + ", videoPlayRate:" + i2 + ", fps:" + this.CdO + ", duration:" + this.videoDuration + ", frameCount:" + this.videoFrameCount + ", frameDuration:" + this.CdW + ", targetFrameRate:" + this.CdV + ", targetFrameCount:" + this.CdT + ", targetFrameDuration:" + this.CdY);
        AppMethodBeat.o(256432);
    }
}
