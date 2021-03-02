package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000fJ\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u000bj\b\u0012\u0004\u0012\u00020\u0015`\rJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rJ\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u001a\u001a\u00020\u000fJ\b\u0010\u001b\u001a\u00020\u0011H\u0016J\u0006\u0010\u001c\u001a\u00020\u0011R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000bj\b\u0012\u0004\u0012\u00020\u000f`\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubVideoFilePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "subVideoPaths", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "videoIsBeauty", "", "addVideoPath", "", "path", "isBeauty", "getMediaItems", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getSize", "", "getVideoList", "initConfig", "isVideoEmpty", "release", "removeTopVideo", "Companion", "plugin-finder_release"})
public final class f implements t {
    public static final a whc = new a((byte) 0);
    private RecordConfigProvider wdm;
    private d wgr;
    public ArrayList<String> wha = new ArrayList<>();
    private ArrayList<Boolean> whb = new ArrayList<>();

    static {
        AppMethodBeat.i(254493);
        AppMethodBeat.o(254493);
    }

    public f(d dVar) {
        p.h(dVar, "status");
        AppMethodBeat.i(254492);
        this.wgr = dVar;
        AppMethodBeat.o(254492);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return null;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(254494);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(254494);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubVideoFilePlugin$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void a(RecordConfigProvider recordConfigProvider) {
        AppMethodBeat.i(254486);
        p.h(recordConfigProvider, "configProvider");
        this.wdm = recordConfigProvider;
        AppMethodBeat.o(254486);
    }

    public final void bw(String str, boolean z) {
        AppMethodBeat.i(254487);
        p.h(str, "path");
        this.wha.add(str);
        this.whb.add(Boolean.valueOf(z));
        Log.i("MicroMsg.FinderSubVideoFilePlugin", "current video size:" + this.wha.size() + " add path:" + str + ", " + z);
        AppMethodBeat.o(254487);
    }

    public final void dFT() {
        boolean z;
        AppMethodBeat.i(254488);
        if (!this.wha.isEmpty()) {
            this.wha.remove(this.wha.size() - 1);
            h.RTc.aZ(new c((String) j.ku(this.wha)));
        }
        if (!this.whb.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.whb.remove(this.whb.size() - 1);
        }
        Log.i("MicroMsg.FinderSubVideoFilePlugin", "current file list size:" + this.wha.size());
        AppMethodBeat.o(254488);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ String mtb;

        c(String str) {
            this.mtb = str;
        }

        public final void run() {
            AppMethodBeat.i(254485);
            s.deleteFile(this.mtb);
            AppMethodBeat.o(254485);
        }
    }

    public final ArrayList<GalleryItem.MediaItem> dFU() {
        AppMethodBeat.i(254489);
        ArrayList<GalleryItem.MediaItem> arrayList = new ArrayList<>();
        int size = this.wha.size();
        int i2 = 0;
        while (i2 < size) {
            GalleryItem.MediaItem a2 = GalleryItem.MediaItem.a(2, 0, this.wha.get(i2), "", "");
            ArrayList<Boolean> arrayList2 = this.whb;
            a2.u("KEY_MEDIA_IS_BEAUTY", (i2 < 0 || i2 > j.kq(arrayList2)) ? Boolean.FALSE : arrayList2.get(i2));
            Log.i("MicroMsg.FinderSubVideoFilePlugin", "add sub video path:" + this.wha.get(i2));
            arrayList.add(a2);
            i2++;
        }
        AppMethodBeat.o(254489);
        return arrayList;
    }

    public final ArrayList<String> dFV() {
        AppMethodBeat.i(254490);
        ArrayList<String> arrayList = new ArrayList<>(this.wha);
        AppMethodBeat.o(254490);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
        AppMethodBeat.i(254491);
        Log.i("MicroMsg.FinderSubVideoFilePlugin", "release");
        h.RTc.aX(new b(this));
        AppMethodBeat.o(254491);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ f whd;

        b(f fVar) {
            this.whd = fVar;
        }

        public final void run() {
            AppMethodBeat.i(254484);
            for (String str : this.whd.wha) {
                com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                com.tencent.mm.plugin.recordvideo.e.c.aLC(str);
            }
            this.whd.wha.clear();
            AppMethodBeat.o(254484);
        }
    }
}
