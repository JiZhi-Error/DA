package com.tencent.mm.plugin.finder.video;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.f;
import com.tencent.mm.media.j.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0002\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012#\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020!\u0018\u00010\u001c\u0012%\u0010\"\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020!\u0018\u00010\u001c\u0012\u0006\u0010$\u001a\u00020\u0006\u0012\u0006\u0010%\u001a\u00020\u0006¢\u0006\u0002\u0010&J\b\u0010(\u001a\u00020)H\u0016R\u000e\u0010'\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer;", "musicPath", "", "filePath", "mixType", "", "outputFilePath", "cropRect", "Landroid/graphics/Rect;", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputAudioChannelCount", "outputFps", "startTimeMs", "", "endTimeMs", "useSoftEncode", "", "enableHevc", "videoMinQP", "videoMaxQP", "forceLandscape", "iFrame", "progressListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "", "finishCallback", "path", "videoWidth", "videoHeight", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/graphics/Rect;IIIIIIIJJZZIIZILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;II)V", "TAG", "getRenderer", "Lcom/tencent/mm/media/render/MixRenderer;", "plugin-finder_release"})
public final class n extends f {
    private final String TAG = "Finder.FinderVideoRemuxer";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(String str, String str2, int i2, String str3, Rect rect, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j2, long j3, boolean z, boolean z2, int i10, b<? super Float, x> bVar, b<? super String, x> bVar2, int i11, int i12) {
        super(str, str2, i2, str3, rect, i11, i12, i3, i4, i5, i6, i7, i8, i9, j2, j3, z, z2, 0, 0, false, i10, bVar, bVar2);
        p.h(str2, "filePath");
        p.h(str3, "outputFilePath");
        AppMethodBeat.i(254335);
        AppMethodBeat.o(254335);
    }

    @Override // com.tencent.mm.media.i.f
    public final c aMH() {
        m mVar;
        AppMethodBeat.i(168169);
        if (this.iiC) {
            mVar = new m(this.ihQ, this.ihR, this.outputWidth, this.outputHeight, 2);
        } else {
            mVar = new m(this.ihQ, this.ihR, this.outputWidth, this.outputHeight);
        }
        Rect rect = this.iiw;
        if (rect == null) {
            p.hyc();
        }
        p.h(rect, "rect");
        mVar.ijA = rect;
        int i2 = this.videoWidth;
        int i3 = this.videoHeight;
        mVar.videoWidth = i2;
        mVar.videoHeight = i3;
        Log.i(mVar.TAG, "setVideoSize: " + i2 + ", " + i3);
        Log.i(this.TAG, "videoWidth: " + this.videoWidth + ", videoHeight: " + this.videoHeight + ", cropRect:" + this.iiw);
        m mVar2 = mVar;
        AppMethodBeat.o(168169);
        return mVar2;
    }
}
