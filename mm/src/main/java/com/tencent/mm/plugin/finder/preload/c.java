package com.tencent.mm.plugin.finder.preload;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 &2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0002&'B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0011\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0000H\u0002J\u0013\u0010!\u001a\u00020\"2\b\u0010 \u001a\u0004\u0018\u00010#H\u0002J\b\u0010$\u001a\u00020\u001aH\u0016J\b\u0010%\u001a\u00020\u0007H\u0016R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;)V", "value", "", "fileFormat", "getFileFormat", "()Ljava/lang/String;", "setFileFormat", "(Ljava/lang/String;)V", "mediaTaskId", "getMediaTaskId", "originalMediaId", "getOriginalMediaId", "status", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;", "getStatus", "()Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;", "setStatus", "(Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;)V", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "weight", "", "getWeight", "()I", "setWeight", "(I)V", "compareTo", FacebookRequestErrorClassification.KEY_OTHER, "equals", "", "", "hashCode", "toString", "Companion", "TaskStatus", "plugin-finder_release"})
public final class c extends h implements Comparable<c> {
    public static final a uUg = new a((byte) 0);
    public final s tHN;
    private b uUd = b.PENDING;
    public final String uUe = this.tHN.auA();
    public final String uUf;
    public int weight;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$TaskStatus;", "", "(Ljava/lang/String;I)V", "LOADING", "PENDING", "WAITING", "plugin-finder_release"})
    public enum b {
        LOADING,
        PENDING,
        WAITING;

        static {
            AppMethodBeat.i(249527);
            AppMethodBeat.o(249527);
        }

        public static b valueOf(String str) {
            AppMethodBeat.i(249529);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(249529);
            return bVar;
        }
    }

    static {
        AppMethodBeat.i(249537);
        AppMethodBeat.o(249537);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask$Companion;", "", "()V", "simpleMediaId", "", "mediaId", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String aur(String str) {
            AppMethodBeat.i(249526);
            p.h(str, "mediaId");
            if (str.length() == 0) {
                AppMethodBeat.o(249526);
                return "";
            } else if (str.length() <= 13) {
                AppMethodBeat.o(249526);
                return str;
            } else {
                String substring = str.substring(13, j.na(str.length(), 24));
                p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                AppMethodBeat.o(249526);
                return substring;
            }
        }
    }

    public c(s sVar) {
        p.h(sVar, "video");
        AppMethodBeat.i(249536);
        this.tHN = sVar;
        String str = this.tHN.uIw.mediaId;
        this.uUf = str == null ? "" : str;
        AppMethodBeat.o(249536);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(c cVar) {
        AppMethodBeat.i(249533);
        c cVar2 = cVar;
        p.h(cVar2, FacebookRequestErrorClassification.KEY_OTHER);
        int compare = p.compare(cVar2.weight, this.weight);
        AppMethodBeat.o(249533);
        return compare;
    }

    public final void a(b bVar) {
        AppMethodBeat.i(249530);
        p.h(bVar, "<set-?>");
        this.uUd = bVar;
        AppMethodBeat.o(249530);
    }

    public final String dlG() {
        String str = this.videoFlag;
        if (str == null) {
            return x.V0_VIDEO.detail;
        }
        return str;
    }

    public final void auq(String str) {
        AppMethodBeat.i(249531);
        p.h(str, "value");
        this.videoFlag = str;
        AppMethodBeat.o(249531);
    }

    @Override // com.tencent.mm.i.h
    public final String toString() {
        String str;
        AppMethodBeat.i(249532);
        if (this.field_requestVideoFormat == 1) {
            str = "H264";
        } else if (this.field_requestVideoFormat == 2) {
            str = "H265";
        } else {
            str = "";
        }
        String str2 = "[" + this.uUd + "] " + a.aur(this.uUe) + ' ' + str + " percent=" + this.gqZ + "% minSize=" + Util.getSizeKB(this.preloadMinSize) + " connection=" + this.connectionCount;
        AppMethodBeat.o(249532);
        return str2;
    }

    public final int hashCode() {
        AppMethodBeat.i(249534);
        int hashCode = this.uUe.hashCode();
        AppMethodBeat.o(249534);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(249535);
        if (obj instanceof c) {
            boolean j2 = p.j(this.uUe, ((c) obj).uUe);
            AppMethodBeat.o(249535);
            return j2;
        }
        AppMethodBeat.o(249535);
        return false;
    }
}
