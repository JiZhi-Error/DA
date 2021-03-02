package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@TargetApi(16)
public abstract class a implements f {
    long cwj;
    private String gWS;
    private boolean iCs = false;
    private List<C1481a> jtB = new ArrayList();
    private List<C1481a> jtC = new ArrayList();
    String jtD;
    String jtE;
    VideoTransPara jtF;
    long jtG;
    int jtH = -1;
    int jtI = -1;
    private c jty;

    public abstract int QZ(String str);

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.mmsight.segment.a$a  reason: collision with other inner class name */
    public class C1481a {
        int index;
        MediaFormat mediaFormat;

        C1481a(MediaFormat mediaFormat2, int i2) {
            this.mediaFormat = mediaFormat2;
            this.index = i2;
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.f
    public void b(String str, String str2, VideoTransPara videoTransPara) {
        Log.d("BaseMediaCodecClipper", "init() called with: src = [" + str + "], dst = [" + str2 + "], para = [" + videoTransPara + "]");
        long currentTicks = Util.currentTicks();
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || videoTransPara == null) {
            throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument's null or nil. src = %s; dst = %s; param = %s", str, str2, videoTransPara));
        }
        o oVar = new o(str);
        new o(str2);
        if (!oVar.canRead() || oVar.length() == 0) {
            throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument src video file can not be read or empty %s", str));
        }
        this.jtD = str;
        this.jtE = str2;
        this.jtF = videoTransPara;
        this.jty = new c();
        this.jty.setDataSource(str);
        b(this.jty);
        if (this.jtB == null || this.jtB.size() == 0) {
            throw new o("Can not find video or audio track in this video file.");
        }
        this.jtH = bhN();
        this.jtI = QZ(str);
        this.iCs = true;
        Log.e("BaseMediaCodecClipper", "init cost time %dms", Long.valueOf(Util.ticksToNow(currentTicks)));
    }

    private void b(c cVar) {
        int trackCount = cVar.gLF.getTrackCount();
        for (int i2 = 0; i2 < trackCount; i2++) {
            MediaFormat trackFormat = cVar.getTrackFormat(i2);
            if (trackFormat.containsKey("mime") && !Util.isNullOrNil(trackFormat.getString("mime"))) {
                String string = trackFormat.getString("mime");
                Log.i("BaseMediaCodecClipper", "mime: %s", string);
                if (string.startsWith("audio/")) {
                    this.jtC.add(new C1481a(trackFormat, i2));
                } else if (string.startsWith("video/")) {
                    this.jtB.add(new C1481a(trackFormat, i2));
                }
            }
        }
        Log.i("BaseMediaCodecClipper", "findMediaFormat mAudioSelectedTrackList.size() = %d, mVideoSelectedTrackList.size() = %d", Integer.valueOf(this.jtC.size()), Integer.valueOf(this.jtB.size()));
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.f
    public int ab(long j2, long j3) {
        if (!this.iCs) {
            Log.e("BaseMediaCodecClipper", "checkTimeParameter has not been initialized.");
            throw new IllegalStateException("Please init this component first.");
        }
        if (j2 < 0) {
            j2 = 0;
        }
        this.cwj = j2;
        MediaFormat mediaFormat = this.jtB.get(0).mediaFormat;
        if (!mediaFormat.containsKey("durationUs")) {
            throw new o("Can not find duration.");
        }
        if (j3 <= 0 || j3 > mediaFormat.getLong("durationUs") / 1000) {
            j3 = mediaFormat.getLong("durationUs") / 1000;
        }
        this.jtG = j3;
        return a(this.jty, this.jtC, this.jtB);
    }

    /* access modifiers changed from: protected */
    public int a(c cVar, List<C1481a> list, List<C1481a> list2) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final String bhO() {
        if (this.gWS == null) {
            this.gWS = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_clip_temp.mp4";
        }
        return this.gWS;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.f
    public final void release() {
        this.iCs = false;
        if (this.jty != null) {
            this.jty.gLF.release();
        }
    }

    private int bhN() {
        int i2 = -1;
        if (!(this.jtC == null || this.jtC.size() == 0)) {
            for (C1481a aVar : this.jtC) {
                if (aVar.mediaFormat.containsKey("max-input-size")) {
                    i2 = Math.max(aVar.mediaFormat.getInteger("max-input-size"), i2);
                } else {
                    i2 = i2;
                }
            }
            i2 = i2;
        }
        if (this.jtB == null || this.jtB.size() == 0) {
            return i2;
        }
        for (C1481a aVar2 : this.jtB) {
            if (aVar2.mediaFormat.containsKey("max-input-size")) {
                i2 = Math.max(aVar2.mediaFormat.getInteger("max-input-size"), i2);
            } else {
                i2 = i2;
            }
        }
        return i2;
    }
}
