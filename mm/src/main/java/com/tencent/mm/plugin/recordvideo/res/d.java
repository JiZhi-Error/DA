package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.vfs.s;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002#$B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001a\u001a\u00020\u0007J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0007J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0017H\u0002J\u0006\u0010\u001f\u001a\u00020\u0007J\u0006\u0010 \u001a\u00020\u0007J\u0006\u0010!\u001a\u00020\u0007J\u0006\u0010\"\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R4\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068F@FX\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/res/VLogPagResLogic;", "", "()V", "TAG", "", "value", "Lkotlin/Function0;", "", "downloadFileSuccessCallback", "getDownloadFileSuccessCallback", "()Lkotlin/jvm/functions/Function0;", "setDownloadFileSuccessCallback", "(Lkotlin/jvm/functions/Function0;)V", "fileExist", "", "getFileExist", "()Z", "fileKeys", "", "[Ljava/lang/String;", "pagResInstance", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "startKey", "", "getStartKey", "()I", "checkRes", "getResParentPath", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "report", "key", "reportLoadFail", "reportLoadStart", "reportLoadSuccess", "unInit", "VLogPagRes32", "VLogPagRes64", "plugin-recordvideo_release"})
public final class d {
    private static final String[] BYg = {"libpag", "libvlog_pag"};
    private static final a BYh;
    private static final int BYi = (BuildInfo.IS_ARM64 ? 40 : 60);
    public static final d BYj = new d();
    private static final String TAG = TAG;

    static {
        a aVar;
        AppMethodBeat.i(237490);
        if (BuildInfo.IS_ARM64) {
            aVar = b.BYm;
        } else {
            aVar = a.BYl;
        }
        BYh = aVar;
        AppMethodBeat.o(237490);
    }

    private d() {
    }

    public static void init() {
        AppMethodBeat.i(237489);
        s.deleteDir(com.tencent.mm.loader.j.b.aKC() + "pag_lib_64/");
        s.deleteDir(com.tencent.mm.loader.j.b.aKC() + "pag_lib_32/");
        AppMethodBeat.o(237489);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/res/VLogPagResLogic$VLogPagRes64;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getFileDirName", "", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResType", "", "getTag", "plugin-recordvideo_release"})
    public static final class b extends a {
        private static final h BYk = new h(40);
        public static final b BYm = new b();

        static {
            AppMethodBeat.i(237488);
            AppMethodBeat.o(237488);
        }

        private b() {
        }

        @Override // com.tencent.mm.plugin.recordvideo.res.a
        public final String getTag() {
            AppMethodBeat.i(237485);
            StringBuilder sb = new StringBuilder();
            d dVar = d.BYj;
            String sb2 = sb.append(d.TAG).append("64").toString();
            AppMethodBeat.o(237485);
            return sb2;
        }

        @Override // com.tencent.mm.plugin.recordvideo.res.a
        public final int eLi() {
            return 77;
        }

        @Override // com.tencent.mm.plugin.recordvideo.res.a
        public final String[] eLj() {
            AppMethodBeat.i(237486);
            d dVar = d.BYj;
            String[] strArr = d.BYg;
            AppMethodBeat.o(237486);
            return strArr;
        }

        @Override // com.tencent.mm.plugin.recordvideo.res.a
        public final String eLk() {
            AppMethodBeat.i(237487);
            String str = com.tencent.mm.loader.j.b.aKC() + "pag_lib_64/";
            AppMethodBeat.o(237487);
            return str;
        }

        @Override // com.tencent.mm.plugin.recordvideo.res.a
        public final String eLl() {
            return "pag_lib_64/";
        }

        @Override // com.tencent.mm.plugin.recordvideo.res.a
        public final /* bridge */ /* synthetic */ b eLh() {
            return BYk;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/res/VLogPagResLogic$VLogPagRes32;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getFileDirName", "", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResType", "", "getTag", "plugin-recordvideo_release"})
    public static final class a extends a {
        private static final h BYk = new h(60);
        public static final a BYl = new a();

        static {
            AppMethodBeat.i(237484);
            AppMethodBeat.o(237484);
        }

        private a() {
        }

        @Override // com.tencent.mm.plugin.recordvideo.res.a
        public final String getTag() {
            AppMethodBeat.i(237481);
            StringBuilder sb = new StringBuilder();
            d dVar = d.BYj;
            String sb2 = sb.append(d.TAG).append("32").toString();
            AppMethodBeat.o(237481);
            return sb2;
        }

        @Override // com.tencent.mm.plugin.recordvideo.res.a
        public final int eLi() {
            return 78;
        }

        @Override // com.tencent.mm.plugin.recordvideo.res.a
        public final String[] eLj() {
            AppMethodBeat.i(237482);
            d dVar = d.BYj;
            String[] strArr = d.BYg;
            AppMethodBeat.o(237482);
            return strArr;
        }

        @Override // com.tencent.mm.plugin.recordvideo.res.a
        public final String eLk() {
            AppMethodBeat.i(237483);
            String str = com.tencent.mm.loader.j.b.aKC() + "pag_lib_32/";
            AppMethodBeat.o(237483);
            return str;
        }

        @Override // com.tencent.mm.plugin.recordvideo.res.a
        public final String eLl() {
            return "pag_lib_32/";
        }

        @Override // com.tencent.mm.plugin.recordvideo.res.a
        public final /* bridge */ /* synthetic */ b eLh() {
            return BYk;
        }
    }
}
