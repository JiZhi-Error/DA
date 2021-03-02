package com.tencent.mm.plugin.mv.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.ui.h;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.mv.a.a;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u0000 ;2\u00020\u0001:\t:;<=>?@ABB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000202J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u00020\tH\u0016J\u0012\u00107\u001a\u0004\u0018\u0001022\b\b\u0002\u00108\u001a\u00020\tJ\u0006\u00109\u001a\u000205R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\u000fR\u001a\u0010\u001f\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u000b\"\u0004\b*\u0010\u000fR\u001c\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006C"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "backItem", "getBackItem", "()Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "setBackItem", "(Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;)V", "durationMs", "", "getDurationMs", "()I", "endMs", "getEndMs", "setEndMs", "(I)V", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "getLyricObj", "()Lcom/tencent/mm/plugin/music/model/LyricObj;", "setLyricObj", "(Lcom/tencent/mm/plugin/music/model/LyricObj;)V", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "startMs", "getStartMs", "setStartMs", "syncMusic", "getSyncMusic", "setSyncMusic", "thumbData", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "getThumbData", "()Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "setThumbData", "(Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;)V", "type", "getType", "setType", "videoData", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IVideoData;", "getVideoData", "()Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IVideoData;", "setVideoData", "(Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IVideoData;)V", "getFeedId", "", "getFinderUin", "getItemId", "", "getItemType", "getLyricLine", "currentPos", "isNull", "CaptureThumbData", "Companion", "DefaultThumbData", "FinderThumbData", "FinderVideoData", "GalleryThumbData", "IThumbData", "IVideoData", "LocalVideoData", "plugin-mv_release"})
public final class d implements com.tencent.mm.view.recyclerview.a {
    private static final Object Apr = new Object();
    public static final b Aps = new b((byte) 0);
    com.tencent.mm.plugin.music.model.e Amv;
    public int Apl;
    public int Apm;
    public boolean Apn;
    public g Apo;
    public h App;
    public d Apq;
    public int type;
    public boolean uOQ;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0018\u0010\u000b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IVideoData;", "", "durationMs", "", "getDurationMs", "()J", "setDurationMs", "(J)V", "isLocal", "", "()Z", "startMs", "getStartMs", "setStartMs", "getFinderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getTpMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "plugin-mv_release"})
    public interface h {
        void Hr(long j2);

        void RQ(long j2);

        boolean dkS();

        com.tencent.mm.plugin.thumbplayer.d.a evA();

        FinderObject evB();

        long evz();

        long getDurationMs();
    }

    public d() {
        AppMethodBeat.i(256778);
        a.C1542a aVar = a.Apj;
        int a2 = j.a(kotlin.a.j.r((Collection<?>) a.Api), kotlin.j.c.SYP);
        if (a2 == a.Aph) {
            a.Aph = (a2 + 1) % a.Api.size();
        } else {
            a.Aph = a2;
        }
        a aVar2 = (a) a.Api.get(a.Aph);
        this.Apo = new c(aVar2);
        i iVar = new i(aVar2.getFilePath(), aVar2.getFilePath(), aVar2.durationMs);
        iVar.videoWidth = aVar2.width;
        iVar.videoHeight = aVar2.height;
        iVar.isDefault = true;
        this.App = iVar;
        AppMethodBeat.o(256778);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010J0\u0010\u0014\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00160\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ(\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0016H\u0002J\u0016\u0010\"\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$Companion;", "", "()V", "DATA_TYPE_ALBUM", "", "DATA_TYPE_CAPTURE", "DATA_TYPE_FINDER", "DATA_TYPE_UNKNOWN", "PayloadSelection", "getPayloadSelection", "()Ljava/lang/Object;", "convertFromFinderItem", "", "data", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "convertFromGalleryItem", "videoItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "convertFromMusicInfo", "Lkotlin/Pair;", "", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "trackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "convertMvTrack", "mvTrack", "Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "refObjectList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "copyBasicInfo", "newItem", "plugin-mv_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        public static d a(axz axz, com.tencent.mm.plugin.music.model.e eVar, List<? extends FinderObject> list) {
            FinderObjectDesc finderObjectDesc;
            LinkedList<FinderMedia> linkedList;
            FinderMedia finderMedia;
            AppMethodBeat.i(256757);
            d dVar = new d();
            if (eVar != null && eVar.euw() > 1) {
                dVar.Amv = eVar;
            }
            dVar.Apl = (int) axz.Ghu;
            dVar.Apm = (int) (axz.Ghu + ((long) axz.LIl));
            for (T t : list) {
                if (!(!p.j(t.objectNonceId, axz.LIm) || (finderObjectDesc = t.objectDesc) == null || (linkedList = finderObjectDesc.media) == null || (finderMedia = (FinderMedia) kotlin.a.j.L(linkedList, 0)) == null)) {
                    if (axz.refObjectId != 0) {
                        dVar.Apo = new C1543d(t);
                        dVar.App = new e(t);
                        dVar.type = 2;
                    } else {
                        String str = finderMedia.url;
                        if (str == null) {
                            str = "";
                        }
                        dVar.Apo = new a("", str);
                        String str2 = t.objectNonceId;
                        if (str2 == null) {
                            p.hyc();
                        }
                        p.g(str2, "it.objectNonceId!!");
                        String str3 = finderMedia.url;
                        if (str3 == null) {
                            str3 = "";
                        }
                        dVar.App = new i(str2, str3, (long) (finderMedia.videoDuration * 1000), (int) finderMedia.width, (int) finderMedia.height);
                        dVar.type = 1;
                    }
                    h hVar = dVar.App;
                    if (hVar != null) {
                        hVar.Hr(axz.Ghw);
                    }
                }
            }
            AppMethodBeat.o(256757);
            return dVar;
        }

        public static void a(d dVar, d dVar2) {
            AppMethodBeat.i(256758);
            p.h(dVar, "item");
            p.h(dVar2, "newItem");
            dVar2.Amv = dVar.Amv;
            dVar2.Apl = dVar.Apl;
            dVar2.Apm = dVar.Apm;
            dVar2.uOQ = dVar.uOQ;
            dVar2.Apn = dVar.Apn;
            AppMethodBeat.o(256758);
        }
    }

    static {
        AppMethodBeat.i(256779);
        AppMethodBeat.o(256779);
    }

    public final int getDurationMs() {
        return this.Apm - this.Apl;
    }

    public static /* synthetic */ String a(d dVar) {
        AppMethodBeat.i(256776);
        String Tj = dVar.Tj(dVar.Apl);
        AppMethodBeat.o(256776);
        return Tj;
    }

    public final String Tj(int i2) {
        AppMethodBeat.i(256775);
        com.tencent.mm.plugin.music.model.e eVar = this.Amv;
        if (eVar != null) {
            e.a SQ = eVar.SQ(eVar.Hp((long) i2));
            if (SQ != null) {
                String str = SQ.content;
                AppMethodBeat.o(256775);
                return str;
            }
            AppMethodBeat.o(256775);
            return null;
        }
        AppMethodBeat.o(256775);
        return null;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(256777);
        long hashCode = (long) hashCode();
        AppMethodBeat.o(256777);
        return hashCode;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return 4;
    }

    public final String adk() {
        FinderObject evB;
        AppMethodBeat.i(259165);
        h hVar = this.App;
        String unsignedLongString = Util.getUnsignedLongString((hVar == null || (evB = hVar.evB()) == null) ? 0 : evB.id);
        p.g(unsignedLongString, "Util.getUnsignedLongStri…getFinderObj()?.id ?: 0L)");
        AppMethodBeat.o(259165);
        return unsignedLongString;
    }

    public final String hWt() {
        String str;
        FinderObject evB;
        AppMethodBeat.i(259166);
        h hVar = this.App;
        if (hVar == null || (evB = hVar.evB()) == null || (str = evB.username) == null) {
            str = z.aTY();
        }
        if (str == null) {
            str = "";
        }
        AppMethodBeat.o(259166);
        return str;
    }

    public final long hWu() {
        d dVar = this.Apq;
        if (dVar == null || dVar.type != 0) {
            return 0;
        }
        return 1;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "", "attachThumb", "", "thumbView", "Landroid/widget/ImageView;", "callback", "Lcom/tencent/mm/plugin/gallery/ui/ThumbDrawable$AttachThumbCallback;", "plugin-mv_release"})
    public interface g {
        void a(ImageView imageView, h.a aVar);

        @l(hxD = {1, 1, 16})
        public static final class a {
            public static /* synthetic */ void a(g gVar, ImageView imageView) {
                AppMethodBeat.i(256770);
                gVar.a(imageView, null);
                AppMethodBeat.o(256770);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$DefaultThumbData;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "videoInfo", "Lcom/tencent/mm/plugin/mv/model/DefaultVideoInfo;", "(Lcom/tencent/mm/plugin/mv/model/DefaultVideoInfo;)V", "attachThumb", "", "thumbView", "Landroid/widget/ImageView;", "callback", "Lcom/tencent/mm/plugin/gallery/ui/ThumbDrawable$AttachThumbCallback;", "plugin-mv_release"})
    public static final class c implements g {
        private final a Apt;

        public c(a aVar) {
            p.h(aVar, "videoInfo");
            AppMethodBeat.i(256760);
            this.Apt = aVar;
            AppMethodBeat.o(256760);
        }

        @Override // com.tencent.mm.plugin.mv.a.d.g
        public final void a(ImageView imageView, h.a aVar) {
            AppMethodBeat.i(256759);
            p.h(imageView, "thumbView");
            com.tencent.mm.plugin.gallery.ui.h.a(imageView, 2, this.Apt.thumbPath, this.Apt.getFilePath(), (long) this.Apt.hashCode(), aVar, 0);
            AppMethodBeat.o(256759);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$CaptureThumbData;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "thumbPath", "", "videoPath", "(Ljava/lang/String;Ljava/lang/String;)V", "getThumbPath", "()Ljava/lang/String;", "getVideoPath", "attachThumb", "", "thumbView", "Landroid/widget/ImageView;", "callback", "Lcom/tencent/mm/plugin/gallery/ui/ThumbDrawable$AttachThumbCallback;", "plugin-mv_release"})
    public static final class a implements g {
        private final String thumbPath;
        private final String videoPath;

        public a(String str, String str2) {
            p.h(str, "thumbPath");
            p.h(str2, "videoPath");
            AppMethodBeat.i(256756);
            this.thumbPath = str;
            this.videoPath = str2;
            AppMethodBeat.o(256756);
        }

        @Override // com.tencent.mm.plugin.mv.a.d.g
        public final void a(ImageView imageView, h.a aVar) {
            AppMethodBeat.i(256755);
            p.h(imageView, "thumbView");
            com.tencent.mm.plugin.gallery.ui.h.a(imageView, 2, this.thumbPath, this.videoPath, (long) this.videoPath.hashCode(), aVar, 0);
            AppMethodBeat.o(256755);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$GalleryThumbData;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "videoItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;)V", "attachThumb", "", "thumbView", "Landroid/widget/ImageView;", "callback", "Lcom/tencent/mm/plugin/gallery/ui/ThumbDrawable$AttachThumbCallback;", "plugin-mv_release"})
    public static final class f implements g {
        private final GalleryItem.VideoMediaItem Apy;

        public f(GalleryItem.VideoMediaItem videoMediaItem) {
            p.h(videoMediaItem, "videoItem");
            AppMethodBeat.i(256769);
            this.Apy = videoMediaItem;
            AppMethodBeat.o(256769);
        }

        @Override // com.tencent.mm.plugin.mv.a.d.g
        public final void a(ImageView imageView, h.a aVar) {
            AppMethodBeat.i(256768);
            p.h(imageView, "thumbView");
            com.tencent.mm.plugin.gallery.ui.h.a(imageView, this.Apy.getType(), this.Apy.aQn(), this.Apy.dRh(), this.Apy.xiZ, aVar, this.Apy.xja);
            AppMethodBeat.o(256768);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$FinderThumbData;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "attachThumb", "", "thumbView", "Landroid/widget/ImageView;", "callback", "Lcom/tencent/mm/plugin/gallery/ui/ThumbDrawable$AttachThumbCallback;", "plugin-mv_release"})
    /* renamed from: com.tencent.mm.plugin.mv.a.d$d  reason: collision with other inner class name */
    public static final class C1543d implements g {
        private final FinderObject Apu;

        public C1543d(FinderObject finderObject) {
            p.h(finderObject, "finderObj");
            AppMethodBeat.i(256764);
            this.Apu = finderObject;
            AppMethodBeat.o(256764);
        }

        @Override // com.tencent.mm.plugin.mv.a.d.g
        public final void a(ImageView imageView, h.a aVar) {
            LinkedList<FinderMedia> linkedList;
            FinderMedia finderMedia;
            AppMethodBeat.i(256763);
            p.h(imageView, "thumbView");
            FinderObjectDesc finderObjectDesc = this.Apu.objectDesc;
            if (finderObjectDesc == null || (linkedList = finderObjectDesc.media) == null || (finderMedia = (FinderMedia) kotlin.a.j.kt(linkedList)) == null) {
                AppMethodBeat.o(256763);
                return;
            }
            c.a aVar2 = new c.a();
            com.tencent.mm.plugin.music.model.g gVar = com.tencent.mm.plugin.music.model.g.Aku;
            aVar2.OS(com.tencent.mm.plugin.music.model.g.aHP("thumb_" + this.Apu.id));
            aVar2.bdp();
            aVar2.bdo();
            q.bcV().a(finderMedia.thumbUrl + finderMedia.thumb_url_token, imageView, aVar2.bdv(), new a(this, imageView, aVar));
            AppMethodBeat.o(256763);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\u000b\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\r¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$FinderThumbData$attachThumb$1$1", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "onImageLoadFinish", "", "url", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release"})
        /* renamed from: com.tencent.mm.plugin.mv.a.d$d$a */
        public static final class a implements com.tencent.mm.av.a.c.h {
            final /* synthetic */ C1543d Apv;
            final /* synthetic */ ImageView Apw;
            final /* synthetic */ h.a Apx;

            a(C1543d dVar, ImageView imageView, h.a aVar) {
                this.Apv = dVar;
                this.Apw = imageView;
                this.Apx = aVar;
            }

            @Override // com.tencent.mm.av.a.c.h
            public final void b(String str, View view) {
            }

            @Override // com.tencent.mm.av.a.c.h
            public final Bitmap a(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                AppMethodBeat.i(256761);
                if (bVar == null) {
                    p.hyc();
                }
                Bitmap bitmap = bVar.bitmap;
                p.g(bitmap, "imageData!!.bitmap");
                AppMethodBeat.o(256761);
                return bitmap;
            }

            @Override // com.tencent.mm.av.a.c.h
            public final void b(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                AppMethodBeat.i(256762);
                h.a aVar = this.Apx;
                if (aVar != null) {
                    aVar.dSs();
                    AppMethodBeat.o(256762);
                    return;
                }
                AppMethodBeat.o(256762);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\n\u0010#\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0010XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001f¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$LocalVideoData;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IVideoData;", "mediaId", "", "videoPath", "durationMs", "", "videoWidth", "", "videoHeight", "(Ljava/lang/String;Ljava/lang/String;JII)V", "getDurationMs", "()J", "setDurationMs", "(J)V", "isDefault", "", "()Z", "setDefault", "(Z)V", "isLocal", "localFinderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getMediaId", "()Ljava/lang/String;", "startMs", "getStartMs", "setStartMs", "getVideoHeight", "()I", "setVideoHeight", "(I)V", "getVideoPath", "getVideoWidth", "setVideoWidth", "getFinderObj", "getTpMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "Companion", "plugin-mv_release"})
    public static final class i implements h {
        public static final a ApA = new a((byte) 0);
        private static long jkM;
        private final FinderObject Apz;
        private final boolean dLQ;
        private long durationMs;
        private long eiq;
        public boolean isDefault;
        private final String mediaId;
        public int videoHeight;
        public final String videoPath;
        public int videoWidth;

        static {
            AppMethodBeat.i(256774);
            AppMethodBeat.o(256774);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$LocalVideoData$Companion;", "", "()V", "lastTick", "", "plugin-mv_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        public /* synthetic */ i(String str, String str2, long j2) {
            this(str, str2, j2, 0, 0);
        }

        public i(String str, String str2, long j2, int i2, int i3) {
            p.h(str, "mediaId");
            p.h(str2, "videoPath");
            AppMethodBeat.i(256773);
            this.mediaId = str;
            this.videoPath = str2;
            this.durationMs = j2;
            this.videoWidth = i2;
            this.videoHeight = i3;
            this.dLQ = true;
            this.Apz = new FinderObject();
            long aWy = cl.aWy();
            if (jkM == aWy) {
                jkM++;
            } else {
                jkM = aWy;
            }
            FinderMedia finderMedia = new FinderMedia();
            finderMedia.url = this.videoPath;
            this.Apz.objectNonceId = "local_" + jkM;
            FinderObject finderObject = this.Apz;
            FinderObjectDesc finderObjectDesc = new FinderObjectDesc();
            finderObjectDesc.media.add(finderMedia);
            finderObject.objectDesc = finderObjectDesc;
            AppMethodBeat.o(256773);
        }

        @Override // com.tencent.mm.plugin.mv.a.d.h
        public final void RQ(long j2) {
            this.durationMs = j2;
        }

        @Override // com.tencent.mm.plugin.mv.a.d.h
        public final long getDurationMs() {
            return this.durationMs;
        }

        @Override // com.tencent.mm.plugin.mv.a.d.h
        public final boolean dkS() {
            return this.dLQ;
        }

        @Override // com.tencent.mm.plugin.mv.a.d.h
        public final void Hr(long j2) {
            this.eiq = j2;
        }

        @Override // com.tencent.mm.plugin.mv.a.d.h
        public final long evz() {
            return this.eiq;
        }

        @Override // com.tencent.mm.plugin.mv.a.d.h
        public final com.tencent.mm.plugin.thumbplayer.d.a evA() {
            long j2;
            int i2;
            AppMethodBeat.i(256771);
            com.tencent.mm.plugin.thumbplayer.d.a aVar = new com.tencent.mm.plugin.thumbplayer.d.a(this.mediaId, this.videoPath, "", this.videoWidth, this.videoHeight);
            aVar.Ghr = 2;
            aVar.dVY = "xV2";
            aVar.dLQ = true;
            MultiMediaVideoChecker.a cA = MultiMediaVideoChecker.GyY.cA(this.videoPath, true);
            if (cA != null) {
                j2 = cA.duration;
            } else {
                j2 = 0;
            }
            aVar.pLQ = j2;
            if (cA != null) {
                i2 = cA.dYT;
            } else {
                i2 = 0;
            }
            aVar.dYT = i2;
            AppMethodBeat.o(256771);
            return aVar;
        }

        @Override // com.tencent.mm.plugin.mv.a.d.h
        public final FinderObject evB() {
            LinkedList<FinderMedia> linkedList;
            FinderMedia finderMedia;
            LinkedList<FinderMedia> linkedList2;
            FinderMedia finderMedia2;
            LinkedList<FinderMedia> linkedList3;
            FinderMedia finderMedia3;
            AppMethodBeat.i(256772);
            if (this.isDefault) {
                AppMethodBeat.o(256772);
                return null;
            }
            FinderObjectDesc finderObjectDesc = this.Apz.objectDesc;
            if (!(finderObjectDesc == null || (linkedList3 = finderObjectDesc.media) == null || (finderMedia3 = linkedList3.get(0)) == null)) {
                finderMedia3.width = (float) this.videoWidth;
            }
            FinderObjectDesc finderObjectDesc2 = this.Apz.objectDesc;
            if (!(finderObjectDesc2 == null || (linkedList2 = finderObjectDesc2.media) == null || (finderMedia2 = linkedList2.get(0)) == null)) {
                finderMedia2.height = (float) this.videoHeight;
            }
            FinderObjectDesc finderObjectDesc3 = this.Apz.objectDesc;
            if (!(finderObjectDesc3 == null || (linkedList = finderObjectDesc3.media) == null || (finderMedia = linkedList.get(0)) == null)) {
                finderMedia.videoDuration = kotlin.h.a.cR(((float) this.durationMs) / 1000.0f);
            }
            FinderObject finderObject = this.Apz;
            AppMethodBeat.o(256772);
            return finderObject;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\n¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$FinderVideoData;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IVideoData;", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "durationMs", "", "getDurationMs", "()J", "setDurationMs", "(J)V", "isLocal", "", "()Z", "startMs", "getStartMs", "setStartMs", "getFinderObj", "getTpMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "plugin-mv_release"})
    public static final class e implements h {
        private final FinderObject Apu;
        private final boolean dLQ;
        private long durationMs;
        private long eiq;

        public e(FinderObject finderObject) {
            LinkedList<FinderMedia> linkedList;
            FinderMedia finderMedia;
            p.h(finderObject, "finderObj");
            AppMethodBeat.i(256767);
            this.Apu = finderObject;
            FinderObjectDesc finderObjectDesc = this.Apu.objectDesc;
            this.durationMs = ((long) ((finderObjectDesc == null || (linkedList = finderObjectDesc.media) == null || (finderMedia = (FinderMedia) kotlin.a.j.kt(linkedList)) == null) ? 0 : finderMedia.videoDuration)) * 1000;
            AppMethodBeat.o(256767);
        }

        @Override // com.tencent.mm.plugin.mv.a.d.h
        public final boolean dkS() {
            return this.dLQ;
        }

        @Override // com.tencent.mm.plugin.mv.a.d.h
        public final void RQ(long j2) {
            this.durationMs = j2;
        }

        @Override // com.tencent.mm.plugin.mv.a.d.h
        public final long getDurationMs() {
            AppMethodBeat.i(256765);
            long j2 = this.durationMs;
            AppMethodBeat.o(256765);
            return j2;
        }

        @Override // com.tencent.mm.plugin.mv.a.d.h
        public final void Hr(long j2) {
            this.eiq = j2;
        }

        @Override // com.tencent.mm.plugin.mv.a.d.h
        public final long evz() {
            return this.eiq;
        }

        @Override // com.tencent.mm.plugin.mv.a.d.h
        public final com.tencent.mm.plugin.thumbplayer.d.a evA() {
            LinkedList<FinderMedia> linkedList;
            FinderMedia finderMedia;
            AppMethodBeat.i(256766);
            FinderObjectDesc finderObjectDesc = this.Apu.objectDesc;
            if (finderObjectDesc == null || (linkedList = finderObjectDesc.media) == null || (finderMedia = (FinderMedia) kotlin.a.j.kt(linkedList)) == null) {
                AppMethodBeat.o(256766);
                return null;
            }
            String str = "video_" + this.Apu.id;
            com.tencent.mm.plugin.music.model.g gVar = com.tencent.mm.plugin.music.model.g.Aku;
            String aHQ = com.tencent.mm.plugin.music.model.g.aHQ(str);
            com.tencent.mm.plugin.thumbplayer.a aVar = com.tencent.mm.plugin.thumbplayer.a.Ggt;
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            Bundle k = com.tencent.mm.plugin.thumbplayer.a.k(context, (int) finderMedia.width, (int) finderMedia.height);
            k.getInt("width", 0);
            k.getInt("height", 0);
            String str2 = finderMedia.url;
            if (str2 == null) {
                str2 = "";
            }
            com.tencent.mm.plugin.thumbplayer.d.a aVar2 = new com.tencent.mm.plugin.thumbplayer.d.a(str, aHQ, str2, (int) finderMedia.width, (int) finderMedia.height);
            aVar2.Ghr = 2;
            aVar2.dVY = "xV2";
            String str3 = finderMedia.url_token;
            if (str3 == null) {
                str3 = "";
            }
            aVar2.aTt(str3);
            aVar2.decodeKey = finderMedia.decodeKey;
            aVar2.pLQ = ((long) finderMedia.videoDuration) * 1000;
            aVar2.GR(finderMedia.thumbUrl + finderMedia.thumb_url_token);
            com.tencent.mm.plugin.music.model.g gVar2 = com.tencent.mm.plugin.music.model.g.Aku;
            String aHP = com.tencent.mm.plugin.music.model.g.aHP("thumb_" + this.Apu.id);
            p.h(aHP, "<set-?>");
            aVar2.thumbPath = aHP;
            AppMethodBeat.o(256766);
            return aVar2;
        }

        @Override // com.tencent.mm.plugin.mv.a.d.h
        public final FinderObject evB() {
            return this.Apu;
        }
    }
}
