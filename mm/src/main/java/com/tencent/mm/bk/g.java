package com.tencent.mm.bk;

import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class g {
    private int bufId;
    private long cwj;
    private String gWS;
    private boolean iCs = false;
    private a jtA;
    private List<a> jtB = new ArrayList();
    private List<a> jtC = new ArrayList();
    private String jtD;
    private String jtE;
    private VideoTransPara jtF;
    private long jtG;
    private int jtH = -1;
    private int jtI = -1;
    boolean jtJ = false;
    boolean jtK = false;
    private c jty;
    private a jtz;

    public g() {
        AppMethodBeat.i(127102);
        AppMethodBeat.o(127102);
    }

    /* access modifiers changed from: package-private */
    public class a {
        int index;
        MediaFormat mediaFormat;

        a(MediaFormat mediaFormat2, int i2) {
            this.mediaFormat = mediaFormat2;
            this.index = i2;
        }
    }

    public final void b(String str, String str2, VideoTransPara videoTransPara) {
        AppMethodBeat.i(127103);
        Log.d("MicroMsg.VideoTranferH265toH264", "init() called with: src = [" + str + "], dst = [" + str2 + "], para = [" + videoTransPara + "]");
        long currentTicks = Util.currentTicks();
        c(str, str2, videoTransPara);
        this.jtD = str;
        this.jtE = str2;
        this.jtF = videoTransPara;
        this.jty = new c();
        this.jty.setDataSource(str);
        b(this.jty);
        if (this.jtB == null || this.jtB.size() == 0) {
            f fVar = new f("Can not find video or audio track in this video file.");
            AppMethodBeat.o(127103);
            throw fVar;
        }
        this.jtH = bhN();
        this.jtI = QZ(str);
        this.iCs = true;
        Log.e("MicroMsg.VideoTranferH265toH264", "init cost time %dms", Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(127103);
    }

    public final int AM(long j2) {
        int i2;
        AppMethodBeat.i(127104);
        AN(j2);
        this.jtz = this.jtB.get(0);
        if (!(this.jtC == null || this.jtC.size() == 0)) {
            this.jtA = this.jtC.get(0);
        }
        c cVar = this.jty;
        if (this.jtH <= 0) {
            i2 = 1048576;
        } else {
            i2 = this.jtH;
        }
        if (a(cVar, i2, this.bufId, this.jtD) == -1) {
            Log.e("MicroMsg.VideoTranferH265toH264", "transcodeAndMux error");
            release();
            AppMethodBeat.o(127104);
            return -1;
        }
        AppMethodBeat.o(127104);
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x031d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(com.tencent.mm.compatible.i.c r21, int r22, int r23, java.lang.String r24) {
        /*
        // Method dump skipped, instructions count: 1026
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.bk.g.a(com.tencent.mm.compatible.i.c, int, int, java.lang.String):int");
    }

    private boolean a(c cVar, int i2, int i3) {
        AppMethodBeat.i(127106);
        if (this.jtA == null) {
            AppMethodBeat.o(127106);
        } else {
            cVar.selectTrack(this.jtA.index);
            cVar.seekTo(this.cwj * 1000, 0);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
            try {
                this.jtA.mediaFormat.getInteger("channel-count");
            } catch (Exception e2) {
                Log.e("MicroMsg.VideoTranferH265toH264", "get channel count error: %s", 1);
            }
            Log.i("MicroMsg.VideoTranferH265toH264", "audio channel count");
            while (true) {
                allocateDirect.clear();
                int readSampleData = cVar.readSampleData(allocateDirect, 0);
                if (readSampleData <= 0) {
                    Log.i("MicroMsg.VideoTranferH265toH264", "VideoClipperAPI18.muxAudio size = %d. Saw eos.", Integer.valueOf(readSampleData));
                    break;
                } else if (cVar.gLF.getSampleTime() >= this.jtG * 1000) {
                    break;
                } else if (cVar.gLF.getSampleTrackIndex() != this.jtA.index) {
                    Log.e("MicroMsg.VideoTranferH265toH264", "track index not match! break");
                    break;
                } else {
                    allocateDirect.position(0);
                    MP4MuxerJNI.writeAACDataLock(i3, allocateDirect, readSampleData);
                    cVar.gLF.advance();
                }
            }
            AppMethodBeat.o(127106);
        }
        return false;
    }

    private static void c(String str, String str2, VideoTransPara videoTransPara) {
        AppMethodBeat.i(127107);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || videoTransPara == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format(Locale.CHINA, "Argument's null or nil. src = %s; dst = %s; param = %s", str, str2, videoTransPara));
            AppMethodBeat.o(127107);
            throw illegalArgumentException;
        }
        o oVar = new o(str);
        new o(str2);
        if (!oVar.exists() || !oVar.canRead() || oVar.length() == 0) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(String.format(Locale.CHINA, "Argument src video file can not be read or empty %s", str));
            AppMethodBeat.o(127107);
            throw illegalArgumentException2;
        }
        AppMethodBeat.o(127107);
    }

    private int bhN() {
        AppMethodBeat.i(127109);
        int i2 = -1;
        if (!(this.jtC == null || this.jtC.size() == 0)) {
            for (a aVar : this.jtC) {
                if (aVar.mediaFormat.containsKey("max-input-size")) {
                    i2 = Math.max(aVar.mediaFormat.getInteger("max-input-size"), i2);
                } else {
                    i2 = i2;
                }
            }
            i2 = i2;
        }
        if (!(this.jtB == null || this.jtB.size() == 0)) {
            for (a aVar2 : this.jtB) {
                if (aVar2.mediaFormat.containsKey("max-input-size")) {
                    i2 = Math.max(aVar2.mediaFormat.getInteger("max-input-size"), i2);
                } else {
                    i2 = i2;
                }
            }
            i2 = i2;
        }
        AppMethodBeat.o(127109);
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int QZ(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 135
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.bk.g.QZ(java.lang.String):int");
    }

    private void release() {
        AppMethodBeat.i(127111);
        this.iCs = false;
        if (this.jty != null) {
            this.jty.gLF.release();
        }
        AppMethodBeat.o(127111);
    }

    private void AN(long j2) {
        AppMethodBeat.i(127112);
        Log.e("MicroMsg.VideoTranferH265toH264", "init %s", Boolean.valueOf(this.iCs));
        if (!this.iCs) {
            Log.e("MicroMsg.VideoTranferH265toH264", "checkTimeParameter has not been initialized.");
        }
        this.cwj = 0;
        MediaFormat mediaFormat = this.jtB.get(0).mediaFormat;
        if (!mediaFormat.containsKey("durationUs")) {
            f fVar = new f("Can not find duration.");
            AppMethodBeat.o(127112);
            throw fVar;
        }
        if (j2 <= 0 || j2 > mediaFormat.getLong("durationUs") / 1000) {
            j2 = mediaFormat.getLong("durationUs") / 1000;
        }
        this.jtG = j2;
        AppMethodBeat.o(127112);
    }

    private String bhO() {
        AppMethodBeat.i(127113);
        if (this.gWS == null) {
            this.gWS = this.jtE + "video_temp.mp4";
        }
        String str = this.gWS;
        AppMethodBeat.o(127113);
        return str;
    }

    private void b(c cVar) {
        AppMethodBeat.i(127108);
        int trackCount = cVar.gLF.getTrackCount();
        for (int i2 = 0; i2 < trackCount; i2++) {
            MediaFormat trackFormat = cVar.getTrackFormat(i2);
            if (trackFormat.containsKey("mime") && !Util.isNullOrNil(trackFormat.getString("mime"))) {
                String string = trackFormat.getString("mime");
                Log.i("MicroMsg.VideoTranferH265toH264", "mime: %s", string);
                if (string.startsWith("audio/")) {
                    this.jtC.add(new a(trackFormat, i2));
                } else if (string.startsWith("video/")) {
                    this.jtB.add(new a(trackFormat, i2));
                }
            }
        }
        Log.i("MicroMsg.VideoTranferH265toH264", "findMediaFormat mAudioSelectedTrackList.size() = %d, mVideoSelectedTrackList.size() = %d", Integer.valueOf(this.jtC.size()), Integer.valueOf(this.jtB.size()));
        AppMethodBeat.o(127108);
    }
}
