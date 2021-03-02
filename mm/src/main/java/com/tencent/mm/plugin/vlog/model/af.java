package com.tencent.mm.plugin.vlog.model;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003Jw\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0003HÖ\u0001J\t\u0010:\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013R\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010\u0013¨\u0006;"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;", "", "outputDurationMs", "", "outputAudioType", "outputPath", "", "targetWidth", "targetHeight", "videoBitrate", "audioBitrate", "frameRate", "videoRotate", "audioSampleRate", "audioChannelCount", "(IILjava/lang/String;IIIIIIII)V", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "getAudioChannelCount", "setAudioChannelCount", "getAudioSampleRate", "setAudioSampleRate", "getFrameRate", "setFrameRate", "getOutputAudioType", "setOutputAudioType", "getOutputDurationMs", "setOutputDurationMs", "getOutputPath", "()Ljava/lang/String;", "setOutputPath", "(Ljava/lang/String;)V", "getTargetHeight", "setTargetHeight", "getTargetWidth", "setTargetWidth", "getVideoBitrate", "setVideoBitrate", "getVideoRotate", "setVideoRotate", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-vlog_release"})
public final class af {
    public int GzL;
    public int GzM;
    public int audioBitrate;
    public int audioChannelCount;
    public int audioSampleRate;
    public int frameRate;
    public int ihS;
    public String rpE;
    public int targetHeight;
    public int targetWidth;
    public int videoBitrate;

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0052, code lost:
        if (r3.audioChannelCount == r4.audioChannelCount) goto L_0x0054;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 110939(0x1b15b, float:1.55459E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0054
            boolean r0 = r4 instanceof com.tencent.mm.plugin.vlog.model.af
            if (r0 == 0) goto L_0x0059
            com.tencent.mm.plugin.vlog.model.af r4 = (com.tencent.mm.plugin.vlog.model.af) r4
            int r0 = r3.GzL
            int r1 = r4.GzL
            if (r0 != r1) goto L_0x0059
            int r0 = r3.GzM
            int r1 = r4.GzM
            if (r0 != r1) goto L_0x0059
            java.lang.String r0 = r3.rpE
            java.lang.String r1 = r4.rpE
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0059
            int r0 = r3.targetWidth
            int r1 = r4.targetWidth
            if (r0 != r1) goto L_0x0059
            int r0 = r3.targetHeight
            int r1 = r4.targetHeight
            if (r0 != r1) goto L_0x0059
            int r0 = r3.videoBitrate
            int r1 = r4.videoBitrate
            if (r0 != r1) goto L_0x0059
            int r0 = r3.audioBitrate
            int r1 = r4.audioBitrate
            if (r0 != r1) goto L_0x0059
            int r0 = r3.frameRate
            int r1 = r4.frameRate
            if (r0 != r1) goto L_0x0059
            int r0 = r3.ihS
            int r1 = r4.ihS
            if (r0 != r1) goto L_0x0059
            int r0 = r3.audioSampleRate
            int r1 = r4.audioSampleRate
            if (r0 != r1) goto L_0x0059
            int r0 = r3.audioChannelCount
            int r1 = r4.audioChannelCount
            if (r0 != r1) goto L_0x0059
        L_0x0054:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0058:
            return r0
        L_0x0059:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0058
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.model.af.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(110938);
        int i2 = ((this.GzL * 31) + this.GzM) * 31;
        String str = this.rpE;
        int hashCode = (((((((((((((((((str != null ? str.hashCode() : 0) + i2) * 31) + this.targetWidth) * 31) + this.targetHeight) * 31) + this.videoBitrate) * 31) + this.audioBitrate) * 31) + this.frameRate) * 31) + this.ihS) * 31) + this.audioSampleRate) * 31) + this.audioChannelCount;
        AppMethodBeat.o(110938);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(110937);
        String str = "VLogGenerateModel(outputDurationMs=" + this.GzL + ", outputAudioType=" + this.GzM + ", outputPath=" + this.rpE + ", targetWidth=" + this.targetWidth + ", targetHeight=" + this.targetHeight + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.audioBitrate + ", frameRate=" + this.frameRate + ", videoRotate=" + this.ihS + ", audioSampleRate=" + this.audioSampleRate + ", audioChannelCount=" + this.audioChannelCount + ")";
        AppMethodBeat.o(110937);
        return str;
    }

    private af(String str) {
        p.h(str, "outputPath");
        AppMethodBeat.i(110935);
        this.GzL = 0;
        this.GzM = 0;
        this.rpE = str;
        this.targetWidth = 0;
        this.targetHeight = 0;
        this.videoBitrate = 0;
        this.audioBitrate = 0;
        this.frameRate = 0;
        this.ihS = 0;
        this.audioSampleRate = 0;
        this.audioChannelCount = 1;
        AppMethodBeat.o(110935);
    }

    public /* synthetic */ af() {
        this("");
        AppMethodBeat.i(110936);
        AppMethodBeat.o(110936);
    }

    public final void aUb(String str) {
        AppMethodBeat.i(110934);
        p.h(str, "<set-?>");
        this.rpE = str;
        AppMethodBeat.o(110934);
    }
}
