package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.o;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.baj;
import com.tencent.mm.protocal.protobuf.bak;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u0000 -2\u00020\u0001:\u0001-B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u001c\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u0004\u0018\u00010\u000eJ\b\u0010 \u001a\u00020\u001bH\u0016J>\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J>\u0010,\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderDraftPost;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", FFmpegMetadataRetriever.METADATA_KEY_TRACK, "Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getTrack", "()Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;", "buildSvrObjectDesc", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "objectDesc", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "fix", "getRespFinderObject", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "onGYNetEnd", "Companion", "plugin-finder_release"})
public final class az extends ax {
    public static final a tuZ = new a((byte) 0);
    private i callback;
    private FinderObject feedObject;
    public d iUB;
    public final FinderItem tuX;
    public final axz tuY;

    static {
        AppMethodBeat.i(242368);
        AppMethodBeat.o(242368);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderDraftPost$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private az(FinderItem finderItem, axz axz) {
        super(null);
        byte[] bArr;
        p.h(finderItem, "finderItem");
        p.h(axz, FFmpegMetadataRetriever.METADATA_KEY_TRACK);
        AppMethodBeat.i(242367);
        this.tuX = finderItem;
        this.tuY = axz;
        this.feedObject = this.tuX.getFeedObject();
        d.a aVar = new d.a();
        aVar.sG(getType());
        aVar.MB("/cgi-bin/micromsg-bin/finderpostdraft");
        baj baj = new baj();
        String str = this.tuX.getPostInfo().clientId;
        String str2 = str;
        str = str2 == null || str2.length() == 0 ? "FinderLocal_clip_" + System.nanoTime() : str;
        baj.username = z.aUg();
        baj.LKb = str;
        FinderObjectDesc finderObjectDesc = new FinderObjectDesc();
        FinderObjectDesc finderObjectDesc2 = this.feedObject.objectDesc;
        if (finderObjectDesc2 != null) {
            bArr = finderObjectDesc2.toByteArray();
        } else {
            bArr = null;
        }
        try {
            finderObjectDesc.parseFrom(bArr);
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            finderObjectDesc = null;
        }
        if (finderObjectDesc == null) {
            p.hyc();
        }
        FinderObjectDesc a2 = a(finderObjectDesc);
        if (a2.mediaType == 8) {
            a2.mediaType = 0;
        }
        baj.LJZ = a2;
        baj.LKa = 3;
        am amVar = am.tuw;
        baj.uli = am.cXY();
        baj.scene = 1;
        aVar.c(baj);
        aVar.d(new bak());
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.iUB = aXF;
        Log.i("Finder.NetSceneFinderDraftPost", "NetSceneFinderDraftPost init  localClipNonceId:" + this.tuX.getObjectNonceId());
        AppMethodBeat.o(242367);
    }

    public /* synthetic */ az(FinderItem finderItem, axz axz, byte b2) {
        this(finderItem, axz);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 6649;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(242364);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(242364);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax, com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(242365);
        super.onGYNetEnd(i2, i3, i4, str, sVar, bArr);
        Log.i("Finder.NetSceneFinderDraftPost", "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(242365);
            return;
        }
        AppMethodBeat.o(242365);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
    }

    private final FinderObjectDesc a(FinderObjectDesc finderObjectDesc) {
        AppMethodBeat.i(242366);
        LinkedList<FinderMedia> linkedList = finderObjectDesc.media;
        p.g(linkedList, "objectDesc.media");
        for (T t : linkedList) {
            FinderItem finderItem = this.tuX;
            String mD5String = MD5Util.getMD5String(t.url);
            p.g(mD5String, "MD5Util.getMD5String(media.url)");
            cjl mediaExt = finderItem.mediaExt(mD5String);
            if (mediaExt != null) {
                o oVar = o.vTw;
                p.g(t, "media");
                o.a(t, mediaExt, this.tuX.getHalfVideoMediaExtList());
                if (t.mediaType == 4 && (t.videoDuration <= 0 || t.videoDuration > 2000)) {
                    MultiMediaVideoChecker multiMediaVideoChecker = MultiMediaVideoChecker.GyY;
                    String str = mediaExt.url;
                    if (str == null) {
                        str = "";
                    }
                    MultiMediaVideoChecker.a aTV = multiMediaVideoChecker.aTV(str);
                    t.videoDuration = (aTV != null ? (int) aTV.duration : 0) / 1000;
                    if (t.videoDuration <= 0 || t.videoDuration > 2000) {
                        Log.e("Finder.LogPost.NetSceneFinderPost", "NetSceneFinderPost videoDuration invalid:" + mediaExt.videoDuration);
                        if (BuildInfo.DEBUG) {
                            RuntimeException runtimeException = new RuntimeException("NetSceneFinderPost videoDuration invalid:" + mediaExt.videoDuration);
                            AppMethodBeat.o(242366);
                            throw runtimeException;
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(242366);
        return finderObjectDesc;
    }
}
