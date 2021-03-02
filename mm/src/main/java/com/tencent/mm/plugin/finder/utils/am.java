package com.tencent.mm.plugin.finder.utils;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/SimpleAudioExtractor;", "", "()V", "TAG", "", "extract", "", "src", "dest", "plugin-finder_release"})
public final class am {
    public static final am waD = new am();

    static {
        AppMethodBeat.i(253821);
        AppMethodBeat.o(253821);
    }

    private am() {
    }

    public static boolean hi(String str, String str2) {
        int i2;
        AppMethodBeat.i(253820);
        p.h(str, "src");
        p.h(str2, "dest");
        try {
            if (!s.YS(str)) {
                Log.i("MicroMsg.SimpleAudioExtractor", "src empty :".concat(String.valueOf(str)));
                AppMethodBeat.o(253820);
                return false;
            }
            s.deleteFile(str2);
            s.bpa(str2);
            long boW = s.boW(str);
            c cVar = new c();
            cVar.setDataSource(str);
            int trackCount = cVar.getTrackCount();
            int i3 = 0;
            while (true) {
                if (i3 >= trackCount) {
                    i2 = -1;
                    break;
                }
                MediaFormat trackFormat = cVar.getTrackFormat(i3);
                p.g(trackFormat, "extractor.getTrackFormat(trackIndex)");
                String string = trackFormat.getString("mime");
                p.g(string, "mime");
                if (n.a((CharSequence) string, (CharSequence) SlookAirButtonRecentMediaAdapter.AUDIO_TYPE, false)) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            if (i2 == -1) {
                AppMethodBeat.o(253820);
                return false;
            }
            MediaFormat trackFormat2 = cVar.getTrackFormat(i2);
            p.g(trackFormat2, "extractor.getTrackFormat(audioIndex)");
            String k = s.k(str2, true);
            if (k == null) {
                p.hyc();
            }
            MediaMuxer mediaMuxer = new MediaMuxer(k, 0);
            mediaMuxer.addTrack(trackFormat2);
            mediaMuxer.start();
            Log.i("MicroMsg.SimpleAudioExtractor", "[extract] src = " + str + ",length:" + boW);
            ByteBuffer allocate = ByteBuffer.allocate(1048576);
            cVar.selectTrack(i2);
            long currentTimeMillis = System.currentTimeMillis();
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            while (true) {
                int readSampleData = cVar.readSampleData(allocate, 0);
                if (readSampleData >= 0) {
                    bufferInfo.offset = 0;
                    bufferInfo.size = readSampleData;
                    bufferInfo.presentationTimeUs = cVar.getSampleTime();
                    bufferInfo.flags = cVar.getSampleFlags();
                    Log.d("MicroMsg.SimpleAudioExtractor", "extract audio pts:" + bufferInfo.presentationTimeUs);
                    mediaMuxer.writeSampleData(0, allocate, bufferInfo);
                    cVar.advance();
                } else {
                    mediaMuxer.stop();
                    mediaMuxer.release();
                    cVar.release();
                    long currentTimeMillis2 = System.currentTimeMillis();
                    Log.d("MicroMsg.SimpleAudioExtractor", "extract aac success:" + str2 + ", length:" + s.boW(str2) + ", cost:" + (currentTimeMillis2 - currentTimeMillis) + LocaleUtil.MALAY);
                    AppMethodBeat.o(253820);
                    return true;
                }
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.SimpleAudioExtractor", "extract aac error:" + e2.getMessage());
            AppMethodBeat.o(253820);
            return false;
        }
    }
}
