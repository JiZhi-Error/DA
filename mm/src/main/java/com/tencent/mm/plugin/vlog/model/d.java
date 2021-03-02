package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.c.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.a.c;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/AudioResampler;", "Lcom/tencent/mm/videocomposition/audio/IAudioResampleFactory;", "destSampleRate", "", "destChannelCount", "(II)V", "TAG", "", "getDestChannelCount", "()I", "getDestSampleRate", "createResampleProcessor", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode$TAVAudioProcessorEffect;", FFmpegMetadataRetriever.METADATA_KEY_TRACK, "Lcom/tencent/mm/videocomposition/CompositionTrack;", "plugin-vlog_release"})
public final class d implements c {
    final int Gxb;
    final int Gxc;
    final String TAG;

    private /* synthetic */ d() {
        this(44100, 1);
    }

    public d(int i2, int i3) {
        this.Gxb = i2;
        this.Gxc = i3;
        this.TAG = "MicroMsg.AudioResampler";
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0018\u001a\u00020\u000fH\u0016J \u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006 "}, hxF = {"com/tencent/mm/plugin/vlog/model/AudioResampler$createResampleProcessor$1", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode$TAVAudioProcessorEffect;", "byteArray", "", "getByteArray", "()[B", "setByteArray", "([B)V", "byteBuffer", "Ljava/nio/ByteBuffer;", "getByteBuffer", "()Ljava/nio/ByteBuffer;", "setByteBuffer", "(Ljava/nio/ByteBuffer;)V", "destAudio", "Lcom/tencent/tav/decoder/AudioInfo;", "getDestAudio", "()Lcom/tencent/tav/decoder/AudioInfo;", "processor", "Lcom/tencent/mm/audio/mix/convert/AudioVariableConvertProcess;", "getProcessor", "()Lcom/tencent/mm/audio/mix/convert/AudioVariableConvertProcess;", "setProcessor", "(Lcom/tencent/mm/audio/mix/convert/AudioVariableConvertProcess;)V", "getDestAudioInfo", "processAudioPCM", "time", "Lcom/tencent/tav/coremedia/CMTime;", "pcmBuffer", "audioInfo", "release", "", "plugin-vlog_release"})
    public static final class a implements TAVAudioProcessorNode.TAVAudioProcessorEffect {
        private g Gxd;
        private final AudioInfo Gxe = new AudioInfo();
        final /* synthetic */ d Gxf;
        final /* synthetic */ com.tencent.mm.videocomposition.d Gxg;
        private ByteBuffer byteBuffer;
        private byte[] jzs = new byte[0];

        a(d dVar, com.tencent.mm.videocomposition.d dVar2) {
            this.Gxf = dVar;
            this.Gxg = dVar2;
            AppMethodBeat.i(190486);
            this.Gxe.sampleRate = dVar.Gxb;
            this.Gxe.channelCount = dVar.Gxc;
            this.Gxe.pcmEncoding = 2;
            AppMethodBeat.o(190486);
        }

        @Override // com.tencent.tav.core.AudioTapProcessor
        public final void release() {
            AppMethodBeat.i(190484);
            g gVar = this.Gxd;
            if (gVar != null) {
                gVar.release();
                AppMethodBeat.o(190484);
                return;
            }
            AppMethodBeat.o(190484);
        }

        @Override // com.tencent.tav.core.AudioTapProcessor
        public final ByteBuffer processAudioPCM(CMTime cMTime, ByteBuffer byteBuffer2, AudioInfo audioInfo) {
            byte[] X;
            AppMethodBeat.i(190485);
            p.h(cMTime, "time");
            p.h(byteBuffer2, "pcmBuffer");
            p.h(audioInfo, "audioInfo");
            if (this.Gxd == null) {
                this.Gxd = new g(this.Gxg.path, audioInfo.sampleRate, audioInfo.channelCount, audioInfo.pcmEncoding, this.Gxe.sampleRate, this.Gxe.channelCount, this.Gxe.pcmEncoding);
                Log.i(this.Gxf.TAG, "processAudioPCM, create convert processor, src:" + audioInfo + ", dst:" + this.Gxe);
            }
            if (this.jzs.length != byteBuffer2.limit()) {
                this.jzs = new byte[byteBuffer2.limit()];
            }
            byteBuffer2.position(0);
            byteBuffer2.get(this.jzs);
            byteBuffer2.position(0);
            g gVar = this.Gxd;
            if (gVar == null || (X = gVar.X(this.jzs)) == null) {
                AppMethodBeat.o(190485);
            } else {
                ByteBuffer byteBuffer3 = this.byteBuffer;
                if (byteBuffer3 == null || byteBuffer3.capacity() != X.length) {
                    byteBuffer2 = ByteBuffer.allocateDirect(X.length).order(ByteOrder.LITTLE_ENDIAN);
                    byteBuffer2.put(X);
                    this.byteBuffer = byteBuffer2;
                    ByteBuffer byteBuffer4 = this.byteBuffer;
                    if (byteBuffer4 != null) {
                        byteBuffer4.position(0);
                    }
                    p.g(byteBuffer2, "newBuffer");
                    AppMethodBeat.o(190485);
                } else {
                    ByteBuffer byteBuffer5 = this.byteBuffer;
                    if (byteBuffer5 != null) {
                        byteBuffer5.position(0);
                    }
                    ByteBuffer byteBuffer6 = this.byteBuffer;
                    if (byteBuffer6 != null) {
                        byteBuffer6.put(X);
                    }
                    ByteBuffer byteBuffer7 = this.byteBuffer;
                    if (byteBuffer7 != null) {
                        byteBuffer7.position(0);
                    }
                    byteBuffer2 = this.byteBuffer;
                    if (byteBuffer2 == null) {
                        p.hyc();
                    }
                    AppMethodBeat.o(190485);
                }
            }
            return byteBuffer2;
        }

        @Override // com.tencent.tav.core.AudioTapProcessor
        public final AudioInfo getDestAudioInfo() {
            return this.Gxe;
        }
    }

    @Override // com.tencent.mm.videocomposition.a.c
    public final TAVAudioProcessorNode.TAVAudioProcessorEffect a(com.tencent.mm.videocomposition.d dVar) {
        AppMethodBeat.i(190487);
        p.h(dVar, FFmpegMetadataRetriever.METADATA_KEY_TRACK);
        a aVar = new a(this, dVar);
        AppMethodBeat.o(190487);
        return aVar;
    }
}
