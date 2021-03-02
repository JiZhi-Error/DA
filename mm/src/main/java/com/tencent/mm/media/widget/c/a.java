package com.tencent.mm.media.widget.c;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.plugin.mmsight.model.a.h;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0014J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J2\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0014R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\fj\b\u0012\u0004\u0012\u00020\u0003`\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/media/widget/recorder/AACMediaCodecBufIdRecorder;", "Lcom/tencent/mm/plugin/mmsight/model/encode/MMSightAACMediaCodecRecorder;", "sampleRate", "", FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, "channelCount", "useFFMpegMuxer", "", "(IIIZ)V", "TAG", "", "bufIDs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addShareBufID", "", "bufID", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "bufferId", "tempPath", "isIgnoreCodecConfig", "processOutPutBuffer", "outputBuffer", "Ljava/nio/ByteBuffer;", "info", "Landroid/media/MediaCodec$BufferInfo;", "processOutputBufferWithADTS", Scopes.PROFILE, "freqIdx", "chanCfg", "plugin-mediaeditor_release"})
@TargetApi(16)
public final class a extends h {
    private final String TAG = "MicroMsg.MMSightAACMediaCodecBufIdRecorder";
    private ArrayList<Integer> irw = new ArrayList<>();

    public a(int i2, int i3, int i4, boolean z) {
        super(i2, i3, i4, null, z);
        AppMethodBeat.i(94371);
        AppMethodBeat.o(94371);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.c, com.tencent.mm.plugin.mmsight.model.a.h
    public final int H(int i2, String str) {
        AppMethodBeat.i(94367);
        p.h(str, "tempPath");
        Log.d(this.TAG, "bufferId:" + i2 + " ,tempPath:" + str);
        this.irw.clear();
        this.irw.add(Integer.valueOf(i2));
        int H = super.H(i2, str);
        AppMethodBeat.o(94367);
        return H;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.c, com.tencent.mm.plugin.mmsight.model.a.h
    public final void rA(int i2) {
        AppMethodBeat.i(94368);
        this.irw.add(Integer.valueOf(i2));
        AppMethodBeat.o(94368);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.h
    public final void h(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        AppMethodBeat.i(94369);
        p.h(byteBuffer, "outputBuffer");
        p.h(bufferInfo, "info");
        if (this.irw.size() >= 0 && !this.zvT) {
            Iterator<T> it = this.irw.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                Log.d(this.TAG, "writeAACDataLock  ,bufferInfo.size : " + bufferInfo.size + ", pts: " + bufferInfo.presentationTimeUs);
                SightVideoJNI.writeAACDataLock(intValue, byteBuffer, bufferInfo.size, bufferInfo.presentationTimeUs);
            }
        }
        AppMethodBeat.o(94369);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.h
    public final void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, int i2, int i3, int i4) {
        AppMethodBeat.i(94370);
        p.h(bufferInfo, "info");
        if (this.irw.size() >= 0 && byteBuffer != null && !this.zvT) {
            Log.d(this.TAG, "writeAACDataWithADTSLock  ,bufferInfo.size : " + bufferInfo.size + ", pts: " + bufferInfo.presentationTimeUs);
            Iterator<T> it = this.irw.iterator();
            while (it.hasNext()) {
                SightVideoJNI.writeAACDataWithADTSLock(it.next().intValue(), byteBuffer, bufferInfo.size, bufferInfo.presentationTimeUs, i2, i3, i4);
            }
        }
        AppMethodBeat.o(94370);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.h
    public final boolean aQF() {
        return true;
    }
}
