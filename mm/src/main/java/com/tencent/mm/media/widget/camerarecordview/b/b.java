package com.tencent.mm.media.widget.camerarecordview.b;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p.u;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.vfs.s;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.ArrayList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bE\n\u0002\u0010\u0002\n\u0002\b\u0006\b\b\u0018\u0000 b2\u00020\u0001:\u0001bBÉ\u0001\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0010j\b\u0012\u0004\u0012\u00020\u0003`\u0011\u0012\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0010j\b\u0012\u0004\u0012\u00020\u0003`\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\b¢\u0006\u0002\u0010\u0019J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\u0019\u0010F\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0010j\b\u0012\u0004\u0012\u00020\u0003`\u0011HÆ\u0003J\u0019\u0010G\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0010j\b\u0012\u0004\u0012\u00020\u0003`\u0011HÆ\u0003J\t\u0010H\u001a\u00020\u0006HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010J\u001a\u00020\u0017HÆ\u0003J\t\u0010K\u001a\u00020\bHÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0006HÆ\u0003J\t\u0010N\u001a\u00020\bHÆ\u0003J\t\u0010O\u001a\u00020\bHÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\bHÆ\u0003J\t\u0010S\u001a\u00020\bHÆ\u0003JË\u0001\u0010T\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0010j\b\u0012\u0004\u0012\u00020\u0003`\u00112\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0010j\b\u0012\u0004\u0012\u00020\u0003`\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\bHÆ\u0001J\u0006\u0010U\u001a\u00020\u0006J\u0006\u0010V\u001a\u00020\u0006J\u0013\u0010W\u001a\u00020\u00062\b\u0010X\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010Y\u001a\u00020\u0003J\u0006\u0010Z\u001a\u00020\u0003J\t\u0010[\u001a\u00020\bHÖ\u0001J\"\u0010\\\u001a\u00020]2\u001a\u0010^\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0011J\"\u0010_\u001a\u00020]2\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0011J\t\u0010`\u001a\u00020\u0003HÖ\u0001J\u0006\u0010a\u001a\u00020]R\u001a\u0010\u0018\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\f\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010.\"\u0004\b/\u00100R\u001a\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010.\"\u0004\b1\u00100R*\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0010j\b\u0012\u0004\u0012\u00020\u0003`\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010!\"\u0004\b7\u0010#R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010!\"\u0004\b=\u0010#R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010!\"\u0004\b?\u0010#R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001b\"\u0004\bA\u0010\u001dR*\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0010j\b\u0012\u0004\u0012\u00020\u0003`\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00103\"\u0004\bC\u00105¨\u0006c"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "", "sourceVideoPath", "", "sourceThumb", "isCaptureVideo", "", "startTime", "", "endTime", "daemonVideoPath", "daemonSourceThumb", "daemonStartTime", "daemonEndTime", "photoPath", "photoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "videoList", "isLandscape", IssueStorage.COLUMN_EXT_INFO, "Landroid/os/Bundle;", "rect", "Landroid/graphics/Rect;", "backgroundColor", "(Ljava/lang/String;Ljava/lang/String;ZIILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;ZLandroid/os/Bundle;Landroid/graphics/Rect;I)V", "getBackgroundColor", "()I", u.NAME, "(I)V", "getDaemonEndTime", "setDaemonEndTime", "getDaemonSourceThumb", "()Ljava/lang/String;", "setDaemonSourceThumb", "(Ljava/lang/String;)V", "getDaemonStartTime", "setDaemonStartTime", "getDaemonVideoPath", "setDaemonVideoPath", "getEndTime", "setEndTime", "getExtInfo", "()Landroid/os/Bundle;", "setExtInfo", "(Landroid/os/Bundle;)V", "()Z", "setCaptureVideo", "(Z)V", "setLandscape", "getPhotoList", "()Ljava/util/ArrayList;", "setPhotoList", "(Ljava/util/ArrayList;)V", "getPhotoPath", "setPhotoPath", "getRect", "()Landroid/graphics/Rect;", "setRect", "(Landroid/graphics/Rect;)V", "getSourceThumb", "setSourceThumb", "getSourceVideoPath", "setSourceVideoPath", "getStartTime", "setStartTime", "getVideoList", "setVideoList", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "enableBaseVideo", "enableDaemonVideo", "equals", FacebookRequestErrorClassification.KEY_OTHER, "getPreviewThumbUrl", "getPreviewUrl", "hashCode", "setImages", "", "imageList", "setVideos", "toString", "videoCheck", "Companion", "plugin-mediaeditor_release"})
public final class b {
    public static final a iqq = new a((byte) 0);
    public int backgroundColor;
    public int dvv;
    public String iqd;
    public String iqe;
    public boolean iqf;
    public int iqg;
    public String iqh;
    public String iqi;
    public int iqj;
    public int iqk;
    public String iql;
    public ArrayList<String> iqm;
    public ArrayList<String> iqn;
    public boolean iqo;
    public Bundle iqp;
    public Rect rect;

    static {
        AppMethodBeat.i(94282);
        AppMethodBeat.o(94282);
    }

    public b() {
        this(null, null, false, null, null, null, null, null, null, 65535);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0090, code lost:
        if (r3.backgroundColor == r4.backgroundColor) goto L_0x0092;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
        // Method dump skipped, instructions count: 156
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.widget.camerarecordview.b.b.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 1;
        int i3 = 0;
        AppMethodBeat.i(94284);
        String str = this.iqd;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.iqe;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
        boolean z = this.iqf;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (((((i4 + hashCode2) * 31) + this.dvv) * 31) + this.iqg) * 31;
        String str3 = this.iqh;
        int hashCode3 = ((str3 != null ? str3.hashCode() : 0) + i7) * 31;
        String str4 = this.iqi;
        int hashCode4 = ((((((str4 != null ? str4.hashCode() : 0) + hashCode3) * 31) + this.iqj) * 31) + this.iqk) * 31;
        String str5 = this.iql;
        int hashCode5 = ((str5 != null ? str5.hashCode() : 0) + hashCode4) * 31;
        ArrayList<String> arrayList = this.iqm;
        int hashCode6 = ((arrayList != null ? arrayList.hashCode() : 0) + hashCode5) * 31;
        ArrayList<String> arrayList2 = this.iqn;
        int hashCode7 = ((arrayList2 != null ? arrayList2.hashCode() : 0) + hashCode6) * 31;
        boolean z2 = this.iqo;
        if (!z2) {
            i2 = z2 ? 1 : 0;
        }
        int i8 = (hashCode7 + i2) * 31;
        Bundle bundle = this.iqp;
        int hashCode8 = ((bundle != null ? bundle.hashCode() : 0) + i8) * 31;
        Rect rect2 = this.rect;
        if (rect2 != null) {
            i3 = rect2.hashCode();
        }
        int i9 = ((hashCode8 + i3) * 31) + this.backgroundColor;
        AppMethodBeat.o(94284);
        return i9;
    }

    public final String toString() {
        AppMethodBeat.i(94283);
        String str = "MediaCaptureInfo(sourceVideoPath=" + this.iqd + ", sourceThumb=" + this.iqe + ", isCaptureVideo=" + this.iqf + ", startTime=" + this.dvv + ", endTime=" + this.iqg + ", daemonVideoPath=" + this.iqh + ", daemonSourceThumb=" + this.iqi + ", daemonStartTime=" + this.iqj + ", daemonEndTime=" + this.iqk + ", photoPath=" + this.iql + ", photoList=" + this.iqm + ", videoList=" + this.iqn + ", isLandscape=" + this.iqo + ", extInfo=" + this.iqp + ", rect=" + this.rect + ", backgroundColor=" + this.backgroundColor + ")";
        AppMethodBeat.o(94283);
        return str;
    }

    private b(String str, String str2, boolean z, String str3, String str4, String str5, ArrayList<String> arrayList, ArrayList<String> arrayList2, Rect rect2) {
        p.h(str, "sourceVideoPath");
        p.h(str2, "sourceThumb");
        p.h(str3, "daemonVideoPath");
        p.h(str4, "daemonSourceThumb");
        p.h(str5, "photoPath");
        p.h(arrayList, "photoList");
        p.h(arrayList2, "videoList");
        p.h(rect2, "rect");
        AppMethodBeat.i(218883);
        this.iqd = str;
        this.iqe = str2;
        this.iqf = z;
        this.dvv = 0;
        this.iqg = 0;
        this.iqh = str3;
        this.iqi = str4;
        this.iqj = 0;
        this.iqk = 0;
        this.iql = str5;
        this.iqm = arrayList;
        this.iqn = arrayList2;
        this.iqo = false;
        this.iqp = null;
        this.rect = rect2;
        this.backgroundColor = 0;
        AppMethodBeat.o(218883);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ b(java.lang.String r12, java.lang.String r13, boolean r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.util.ArrayList r18, java.util.ArrayList r19, android.graphics.Rect r20, int r21) {
        /*
        // Method dump skipped, instructions count: 115
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.widget.camerarecordview.b.b.<init>(java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.util.ArrayList, java.util.ArrayList, android.graphics.Rect, int):void");
    }

    public final void Hw(String str) {
        AppMethodBeat.i(94277);
        p.h(str, "<set-?>");
        this.iqd = str;
        AppMethodBeat.o(94277);
    }

    public final void Hx(String str) {
        AppMethodBeat.i(94278);
        p.h(str, "<set-?>");
        this.iqe = str;
        AppMethodBeat.o(94278);
    }

    public final void Hy(String str) {
        AppMethodBeat.i(94279);
        p.h(str, "<set-?>");
        this.iql = str;
        AppMethodBeat.o(94279);
    }

    public final void s(ArrayList<String> arrayList) {
        AppMethodBeat.i(218880);
        p.h(arrayList, "<set-?>");
        this.iqm = arrayList;
        AppMethodBeat.o(218880);
    }

    public final void t(ArrayList<String> arrayList) {
        AppMethodBeat.i(218881);
        p.h(arrayList, "<set-?>");
        this.iqn = arrayList;
        AppMethodBeat.o(218881);
    }

    public final void setRect(Rect rect2) {
        AppMethodBeat.i(218882);
        p.h(rect2, "<set-?>");
        this.rect = rect2;
        AppMethodBeat.o(218882);
    }

    public final boolean aQo() {
        AppMethodBeat.i(94274);
        if (TextUtils.isEmpty(this.iqh) || !s.YS(this.iqh)) {
            AppMethodBeat.o(94274);
            return false;
        }
        AppMethodBeat.o(94274);
        return true;
    }

    public final boolean aQp() {
        AppMethodBeat.i(94275);
        if (TextUtils.isEmpty(this.iqd) || !s.YS(this.iqd)) {
            AppMethodBeat.o(94275);
            return false;
        }
        AppMethodBeat.o(94275);
        return true;
    }

    public final String aQq() {
        AppMethodBeat.i(94276);
        if (aQp()) {
            String str = this.iqd;
            AppMethodBeat.o(94276);
            return str;
        }
        String str2 = this.iqh;
        AppMethodBeat.o(94276);
        return str2;
    }

    public final void aQr() {
        AppMethodBeat.i(218879);
        if (this.iqm.size() == 0 && this.iqn.size() == 1) {
            this.iqd = (String) j.ks(this.iqn);
            com.tencent.mm.plugin.sight.base.a aNx = e.aNx(this.iqd);
            if (aNx != null) {
                this.iqg = aNx.videoDuration;
            }
        }
        AppMethodBeat.o(218879);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001e\u0010\b\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00060\tj\b\u0012\u0004\u0012\u00020\u0006`\nJ\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo$Companion;", "", "()V", "getCapturePhotoInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "input", "", "getExternalPhotoInfo", "getExternalPhotosInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getExternalVideoInfo", "startTime", "", "endTime", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b Hz(String str) {
            AppMethodBeat.i(218878);
            p.h(str, "input");
            b bVar = new b(null, null, true, null, null, str, null, null, null, 65019);
            AppMethodBeat.o(218878);
            return bVar;
        }
    }
}
