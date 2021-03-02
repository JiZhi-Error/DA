package com.tencent.mm.plugin.mv.ui;

import android.graphics.Bitmap;
import android.util.Base64;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.plugin.mv.a.e;
import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axx;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004J.\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001cJ\n\u0010 \u001a\u00020\u0004*\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/MvLogic;", "", "()V", "TAG", "", "canShareMv", "", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "fillMvMakerInfo", "", "mvData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "fillSongInfo", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "generateSongId", "generateSongInfoBase64", "getCoverPath", "url", "getSongId", "getVideoPath", "mediaId", "loadAppIcon", "appId", "iconType", "", "imageView", "Landroid/widget/ImageView;", "defaultRes", "toInfoString", "plugin-mv_release"})
public final class a {
    public static final a ArA = new a();

    static {
        AppMethodBeat.i(256958);
        AppMethodBeat.o(256958);
    }

    private a() {
    }

    public static String aIo(String str) {
        AppMethodBeat.i(256950);
        p.h(str, "url");
        g gVar = g.Aku;
        StringBuilder sb = new StringBuilder("thumb_");
        byte[] bytes = str.getBytes(d.UTF_8);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        String absolutePath = new o(g.aHP(sb.append(com.tencent.mm.b.g.getMessageDigest(bytes)).toString())).getAbsolutePath();
        p.g(absolutePath, "VFSFile(MusicFileNameUti…Array())}\")).absolutePath");
        AppMethodBeat.o(256950);
        return absolutePath;
    }

    public static String aIp(String str) {
        AppMethodBeat.i(256951);
        p.h(str, "mediaId");
        g gVar = g.Aku;
        String absolutePath = new o(g.aHQ(str)).getAbsolutePath();
        p.g(absolutePath, "VFSFile(MusicFileNameUti…th(mediaId)).absolutePath");
        AppMethodBeat.o(256951);
        return absolutePath;
    }

    public static void c(csp csp) {
        FinderObject finderObject;
        FinderObjectDesc finderObjectDesc;
        axw axw;
        FinderObjectDesc finderObjectDesc2;
        axw axw2;
        LinkedList<axz> linkedList;
        long j2;
        FinderObjectDesc finderObjectDesc3;
        axw axw3;
        LinkedList<axz> linkedList2;
        AppMethodBeat.i(256952);
        p.h(csp, "mvData");
        c.a aVar = c.tsp;
        com.tencent.mm.plugin.finder.api.g asG = c.a.asG(z.aUg());
        if (asG != null) {
            FinderObject finderObject2 = csp.MxE;
            if (finderObject2 != null) {
                FinderContact finderContact = new FinderContact();
                finderContact.username = asG.getUsername();
                finderContact.nickname = asG.getNickname();
                finderContact.headUrl = asG.cXH();
                finderContact.signature = asG.getSignature();
                finderContact.coverImgUrl = asG.field_coverImg;
                finderContact.liveCoverImgUrl = asG.field_liveCoverImg;
                finderContact.authInfo = asG.field_authInfo;
                finderObject2.contact = finderContact;
            }
            long j3 = 0;
            FinderObject finderObject3 = csp.MxE;
            int size = (finderObject3 == null || (finderObjectDesc3 = finderObject3.objectDesc) == null || (axw3 = finderObjectDesc3.mvInfo) == null || (linkedList2 = axw3.LId) == null) ? 0 : linkedList2.size();
            FinderObject finderObject4 = csp.MxE;
            if (!(finderObject4 == null || (finderObjectDesc2 = finderObject4.objectDesc) == null || (axw2 = finderObjectDesc2.mvInfo) == null || (linkedList = axw2.LId) == null)) {
                for (T t : linkedList) {
                    if (t.refObjectId != 0) {
                        LinkedList<FinderObject> linkedList3 = csp.LDi;
                        p.g(linkedList3, "mvData.refObjectList");
                        for (T t2 : linkedList3) {
                            T t3 = (t2.id > t.refObjectId ? 1 : (t2.id == t.refObjectId ? 0 : -1)) == 0 ? t2 : null;
                            if (t3 != null) {
                                FinderContact finderContact2 = t3.contact;
                                if ((p.j(finderContact2 != null ? finderContact2.username : null, asG.getUsername()) ? t3 : null) != null) {
                                    j3++;
                                }
                            }
                        }
                    } else {
                        String str = t.LIm;
                        if (str != null) {
                            if (str.length() > 0) {
                                j2 = 1 + j3;
                            } else {
                                j2 = j3;
                            }
                            j3 = j2;
                        }
                    }
                }
            }
            if (((long) size) <= 0 || (finderObject = csp.MxE) == null || (finderObjectDesc = finderObject.objectDesc) == null || (axw = finderObjectDesc.mvInfo) == null) {
                AppMethodBeat.o(256952);
                return;
            }
            axx axx = new axx();
            axx.LIe = ((float) j3) / ((float) size);
            Log.i("SimpleUIComponent", "createPostData originality:" + axx.LIe);
            axw.ApI = axx;
            AppMethodBeat.o(256952);
            return;
        }
        AppMethodBeat.o(256952);
    }

    public static String b(axy axy) {
        AppMethodBeat.i(256954);
        p.h(axy, "songInfo");
        byte[] encode = Base64.encode(axy.toByteArray(), 2);
        p.g(encode, "Base64.encode(songInfo.t…eArray(), Base64.NO_WRAP)");
        String str = new String(encode, d.UTF_8);
        AppMethodBeat.o(256954);
        return str;
    }

    public static void a(com.tencent.mm.plugin.music.model.e.a aVar, axy axy) {
        AppMethodBeat.i(256955);
        p.h(aVar, "music");
        p.h(axy, "songInfo");
        axy.BPc = aVar.field_songName;
        axy.lDR = aVar.field_songSinger;
        axy.LIg = aVar.field_songWebUrl;
        axy.LIf = aVar.field_appId;
        axy.musicDataUrl = aVar.field_songWifiUrl;
        axy.Djf = aVar.field_songHAlbumUrl;
        axy.LIh = aVar.field_songLyric;
        axy.AqO = "";
        AppMethodBeat.o(256955);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/mv/ui/MvLogic$loadAppIcon$1", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$ILoadTarget;", "beforeLoadBitmap", "", "key", "", "onBitmapLoaded", "bitmap", "Landroid/graphics/Bitmap;", "onLoadFailed", "plugin-mv_release"})
    /* renamed from: com.tencent.mm.plugin.mv.ui.a$a  reason: collision with other inner class name */
    public static final class C1545a implements b.k {
        final /* synthetic */ int ArB = 0;
        final /* synthetic */ String ArC;
        final /* synthetic */ ImageView hYC;

        C1545a(ImageView imageView, String str) {
            this.hYC = imageView;
            this.ArC = str;
        }

        @Override // com.tencent.mm.modelappbrand.a.b.k
        public final void aYg() {
            AppMethodBeat.i(256947);
            this.hYC.setImageResource(this.ArB);
            AppMethodBeat.o(256947);
        }

        @Override // com.tencent.mm.modelappbrand.a.b.k
        public final void I(Bitmap bitmap) {
            AppMethodBeat.i(256948);
            if (bitmap == null || bitmap.isRecycled()) {
                oD();
                AppMethodBeat.o(256948);
                return;
            }
            this.hYC.setImageBitmap(bitmap);
            AppMethodBeat.o(256948);
        }

        @Override // com.tencent.mm.modelappbrand.a.b.k
        public final void oD() {
            AppMethodBeat.i(256949);
            Log.e("MicroMsg.Mv.MvLogic", "alvinluo loadAppIcon failed");
            this.hYC.setImageResource(this.ArB);
            AppMethodBeat.o(256949);
        }

        @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
        public final String Lb() {
            return this.ArC;
        }
    }

    public static String a(axy axy) {
        AppMethodBeat.i(259227);
        p.h(axy, "$this$toInfoString");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("songId: ").append(axy.AqO).append("\n");
        stringBuffer.append("songName: ").append(axy.BPc).append("\n");
        stringBuffer.append("singer: ").append(axy.lDR).append("\n");
        stringBuffer.append("albumName: ").append(axy.albumName).append("\n");
        stringBuffer.append("albumUrl: ").append(axy.Djf).append("\n");
        stringBuffer.append("genre: ").append(axy.LIi).append("\n");
        stringBuffer.append("publicTime: ").append(axy.LIk).append("\n");
        stringBuffer.append("duration: ").append(axy.duration).append("\n");
        stringBuffer.append("dataUrl: ").append(axy.musicDataUrl).append("\n");
        stringBuffer.append("webUrl: ").append(axy.LIg).append("\n");
        stringBuffer.append("songLyric: ").append(axy.LIh).append("\n");
        String str = "FinderMVSongInfo " + stringBuffer;
        AppMethodBeat.o(259227);
        return str;
    }

    public static boolean c(e eVar) {
        AppMethodBeat.i(256956);
        p.h(eVar, "musicMv");
        if (eVar.ApM == 1) {
            AppMethodBeat.o(256956);
            return true;
        } else if (eVar.ApM == 4) {
            AppMethodBeat.o(256956);
            return true;
        } else {
            AppMethodBeat.o(256956);
            return false;
        }
    }

    public static /* synthetic */ boolean i(String str, ImageView imageView) {
        boolean z;
        String str2;
        String str3;
        AppMethodBeat.i(259226);
        String str4 = str;
        if (str4 == null || str4.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(259226);
            return false;
        } else if (imageView == null) {
            AppMethodBeat.o(259226);
            return false;
        } else {
            com.tencent.mm.pluginsdk.model.app.g aJw = h.aJw(str);
            String aJy = a.C1616a.eAZ().aJy(str);
            if (s.YS(aJy)) {
                str2 = "file://".concat(String.valueOf(aJy));
            } else {
                str2 = (aJw == null || (str3 = aJw.field_appIconUrl) == null) ? "" : str3;
            }
            b.aXY().a(new C1545a(imageView, str2), str2, (b.h) null);
            AppMethodBeat.o(259226);
            return true;
        }
    }
}
