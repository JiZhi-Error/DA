package com.tencent.mm.plugin.thumbplayer.d;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.thumbplayer.view.MMThumbPlayerTextureView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b-\n\u0002\u0010\t\n\u0002\b\u001e\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0007HÆ\u0003J\t\u0010V\u001a\u00020\u0007HÆ\u0003J;\u0010W\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010X\u001a\u00020\u00102\b\u0010Y\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Z\u001a\u00020\u0007HÖ\u0001J\t\u0010[\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\fR\u001c\u0010#\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010.\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR\u001a\u00101\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0019\"\u0004\b3\u0010\u001bR\u001a\u00104\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\f\"\u0004\b6\u0010\u000eR\u001a\u00107\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\f\"\u0004\b9\u0010\u000eR\u001a\u0010:\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\f\"\u0004\b<\u0010\u000eR\u001a\u0010=\u001a\u00020>X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020>X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010@\"\u0004\bE\u0010BR\u001a\u0010F\u001a\u00020>X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010@\"\u0004\bH\u0010BR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\fR\u001a\u0010J\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\f\"\u0004\bL\u0010\u000eR\u001a\u0010M\u001a\u00020>X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010@\"\u0004\bO\u0010BR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0019\"\u0004\bQ\u0010\u001b¨\u0006\\"}, hxF = {"Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "", "mediaId", "", "path", "url", "width", "", "height", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "decodeKey", "getDecodeKey", "()Ljava/lang/String;", "setDecodeKey", "(Ljava/lang/String;)V", "defaultVideo", "", "getDefaultVideo", "()Z", "setDefaultVideo", "(Z)V", "fileFormat", "getFileFormat", "setFileFormat", "getHeight", "()I", "setHeight", "(I)V", "isLocal", "setLocal", "loop", "getLoop", "setLoop", "getMediaId", "getPath", "refObj", "getRefObj", "()Ljava/lang/Object;", "setRefObj", "(Ljava/lang/Object;)V", "reqFormat", "getReqFormat", "()Ljava/lang/Integer;", "setReqFormat", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, "getRotate", "setRotate", "scaleType", "getScaleType", "setScaleType", "thumbPath", "getThumbPath", "setThumbPath", "thumbUrl", "getThumbUrl", "setThumbUrl", "thumbUrlToken", "getThumbUrlToken", "setThumbUrlToken", "timeLengthInMvMs", "", "getTimeLengthInMvMs", "()J", "setTimeLengthInMvMs", "(J)V", "timeOffsetInClipMs", "getTimeOffsetInClipMs", "setTimeOffsetInClipMs", "timeOffsetInMvMs", "getTimeOffsetInMvMs", "setTimeOffsetInMvMs", "getUrl", "urlToken", "getUrlToken", "setUrlToken", "videoDuration", "getVideoDuration", "setVideoDuration", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-thumbplayer_release"})
public final class a {
    public Integer Ghr;
    public String Ghs;
    public boolean Ght;
    public long Ghu;
    public long Ghv;
    public long Ghw;
    public Object Ghx;
    public boolean dLQ;
    public String dVY;
    public int dYT;
    public String decodeKey;
    public int height;
    public boolean loop;
    public final String mediaId;
    public long pLQ;
    public final String path;
    public int scaleType;
    public String thumbPath;
    public String thumbUrl;
    public final String url;
    public String viB = "";
    public int width;

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        if (r3.height == r4.height) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 238680(0x3a458, float:3.34462E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0038
            boolean r0 = r4 instanceof com.tencent.mm.plugin.thumbplayer.d.a
            if (r0 == 0) goto L_0x003d
            com.tencent.mm.plugin.thumbplayer.d.a r4 = (com.tencent.mm.plugin.thumbplayer.d.a) r4
            java.lang.String r0 = r3.mediaId
            java.lang.String r1 = r4.mediaId
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003d
            java.lang.String r0 = r3.path
            java.lang.String r1 = r4.path
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003d
            java.lang.String r0 = r3.url
            java.lang.String r1 = r4.url
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003d
            int r0 = r3.width
            int r1 = r4.width
            if (r0 != r1) goto L_0x003d
            int r0 = r3.height
            int r1 = r4.height
            if (r0 != r1) goto L_0x003d
        L_0x0038:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x003c:
            return r0
        L_0x003d:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x003c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.thumbplayer.d.a.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(238679);
        String str = this.mediaId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.path;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
        String str3 = this.url;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = ((((hashCode2 + i2) * 31) + this.width) * 31) + this.height;
        AppMethodBeat.o(238679);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(238678);
        String str = "TPMediaInfo(mediaId=" + this.mediaId + ", path=" + this.path + ", url=" + this.url + ", width=" + this.width + ", height=" + this.height + ")";
        AppMethodBeat.o(238678);
        return str;
    }

    public a(String str, String str2, String str3, int i2, int i3) {
        p.h(str, "mediaId");
        p.h(str2, "path");
        p.h(str3, "url");
        AppMethodBeat.i(238677);
        this.mediaId = str;
        this.path = str2;
        this.url = str3;
        this.width = i2;
        this.height = i3;
        MMThumbPlayerTextureView.a aVar = MMThumbPlayerTextureView.GiC;
        this.scaleType = MMThumbPlayerTextureView.Giy;
        this.thumbUrl = "";
        this.Ghs = "";
        this.thumbPath = "";
        AppMethodBeat.o(238677);
    }

    public final void aTt(String str) {
        AppMethodBeat.i(238674);
        p.h(str, "<set-?>");
        this.viB = str;
        AppMethodBeat.o(238674);
    }

    public final void GR(String str) {
        AppMethodBeat.i(238675);
        p.h(str, "<set-?>");
        this.thumbUrl = str;
        AppMethodBeat.o(238675);
    }

    public final void aTu(String str) {
        AppMethodBeat.i(238676);
        p.h(str, "<set-?>");
        this.Ghs = str;
        AppMethodBeat.o(238676);
    }
}
