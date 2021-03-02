package com.tencent.mm.plugin.recordvideo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u00102\u001a\u000203J\b\u00104\u001a\u00020\u0011H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\u001e\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u001a\u0010/\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\f\"\u0004\b1\u0010\u000e¨\u00065"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "Ljava/io/Serializable;", "()V", "audioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getAudioInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "setAudioInfo", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "audioMixType", "", "getAudioMixType", "()I", "setAudioMixType", "(I)V", "fakeVideoImageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getFakeVideoImageList", "()Ljava/util/ArrayList;", "setFakeVideoImageList", "(Ljava/util/ArrayList;)V", "isCaptureVideo", "", "()Z", "setCaptureVideo", "(Z)V", "isPhotoToVideo", "setPhotoToVideo", "recordThumb", "getRecordThumb", "()Ljava/lang/String;", "setRecordThumb", "(Ljava/lang/String;)V", "recordVideo", "getRecordVideo", "setRecordVideo", "remuxEnd", "", "getRemuxEnd", "()J", "setRemuxEnd", "(J)V", "remuxStart", "getRemuxStart", "setRemuxStart", "videoRotate", "getVideoRotate", "setVideoRotate", "reset", "", "toString", "plugin-recordvideo_release"})
public final class c implements Serializable {
    public String BMT = "";
    public String BMU = "";
    public long BMV;
    public long BMW;
    public boolean BMX;
    public int BMY;
    public ArrayList<String> BMZ = new ArrayList<>();
    public int ihS;
    public boolean iqf;
    public AudioCacheInfo uPh;

    public c() {
        AppMethodBeat.i(75368);
        AppMethodBeat.o(75368);
    }

    public final void aLo(String str) {
        AppMethodBeat.i(75364);
        p.h(str, "<set-?>");
        this.BMT = str;
        AppMethodBeat.o(75364);
    }

    public final void aLp(String str) {
        AppMethodBeat.i(75365);
        p.h(str, "<set-?>");
        this.BMU = str;
        AppMethodBeat.o(75365);
    }

    public final void aI(ArrayList<String> arrayList) {
        AppMethodBeat.i(75366);
        p.h(arrayList, "<set-?>");
        this.BMZ = arrayList;
        AppMethodBeat.o(75366);
    }

    public final String toString() {
        AppMethodBeat.i(75367);
        String str = "CaptureInfo(sourceVideoPath='" + this.BMT + "', sourceThumb='" + this.BMU + "', remuxStart=" + this.BMV + ", remuxEnd=" + this.BMW + ", isCaptureVideo=" + this.iqf + ", audioMixType=" + this.BMY + ", audioInfo=" + this.uPh + ", videoRotate=" + this.ihS + ')';
        AppMethodBeat.o(75367);
        return str;
    }
}
