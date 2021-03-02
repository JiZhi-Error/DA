package com.tencent.mm.plugin.vlog.ui.plugin.read;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.c.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/SimpleAudioRemuxer;", "", "()V", "remux", "", "src", "", "dest", "desSampleRate", "", "desChannels", "desBitDepth", "Companion", "plugin-vlog_release"})
public final class d {
    public static final a GLV = new a((byte) 0);

    static {
        AppMethodBeat.i(191811);
        AppMethodBeat.o(191811);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/SimpleAudioRemuxer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static boolean ak(String str, String str2, int i2) {
        AppMethodBeat.i(191810);
        p.h(str, "src");
        p.h(str2, "dest");
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        MediaExtractor mediaExtractor = new MediaExtractor();
        s.deleteFile(str2);
        s.bpa(str2);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            mediaExtractor.setDataSource(str);
            mediaExtractor.selectTrack(0);
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(0);
            p.g(trackFormat, "extractor.getTrackFormat(0)");
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(trackFormat.getString("mime"));
            p.g(createDecoderByType, "MediaCodec.createDecoder…ng(MediaFormat.KEY_MIME))");
            createDecoderByType.configure(trackFormat, (Surface) null, (MediaCrypto) null, 0);
            createDecoderByType.start();
            g gVar = new g(str, trackFormat.containsKey("sample-rate") ? trackFormat.getInteger("sample-rate") : 44100, trackFormat.containsKey("channel-count") ? trackFormat.getInteger("channel-count") : 1, 2, 44100, i2, 2);
            do {
                int dequeueInputBuffer = createDecoderByType.dequeueInputBuffer(1000);
                if (dequeueInputBuffer >= 0) {
                    ByteBuffer inputBuffer = createDecoderByType.getInputBuffer(dequeueInputBuffer);
                    if (inputBuffer == null) {
                        p.hyc();
                    }
                    int readSampleData = mediaExtractor.readSampleData(inputBuffer, 0);
                    if (readSampleData < 0) {
                        createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, 0, 0, 4);
                    } else {
                        createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, mediaExtractor.getSampleTime(), 0);
                        mediaExtractor.advance();
                    }
                }
                int dequeueOutputBuffer = createDecoderByType.dequeueOutputBuffer(bufferInfo, 1000);
                switch (dequeueOutputBuffer) {
                    case -3:
                    case -1:
                        break;
                    case -2:
                        p.g(createDecoderByType.getOutputFormat(), "decoder.outputFormat");
                        Log.d("MicroMsg.SimpleAudioRemuxer", "get output format");
                        break;
                    default:
                        ByteBuffer outputBuffer = createDecoderByType.getOutputBuffer(dequeueOutputBuffer);
                        byte[] bArr = new byte[bufferInfo.size];
                        if (outputBuffer != null) {
                            outputBuffer.get(bArr, 0, bufferInfo.size);
                        }
                        if (outputBuffer != null) {
                            outputBuffer.clear();
                        }
                        createDecoderByType.releaseOutputBuffer(dequeueOutputBuffer, false);
                        dataOutputStream.write(gVar.X(bArr));
                        break;
                }
            } while (bufferInfo.flags == 0);
            s.C(str2, c.ad(byteArrayOutputStream.toByteArray(), i2));
            createDecoderByType.stop();
            createDecoderByType.release();
            mediaExtractor.release();
            gVar.release();
            Log.d("MicroMsg.SimpleAudioRemuxer", "remux success: ".concat(String.valueOf(str2)));
            AppMethodBeat.o(191810);
            return true;
        } catch (IOException e2) {
            Log.e("MicroMsg.SimpleAudioRemuxer", "remux error:" + e2.getMessage());
            AppMethodBeat.o(191810);
            return false;
        } catch (Exception e3) {
            Log.e("MicroMsg.SimpleAudioRemuxer", "remux error:" + e3.getMessage());
            AppMethodBeat.o(191810);
            return false;
        }
    }
}
