package com.tencent.mm.plugin.finder.widget.post;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.ui.post.SdkShareUIC;
import com.tencent.mm.plugin.finder.widget.post.a;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010y\u001a\u00020zJJ\u0010{\u001a\u00020\u000e2\u0006\u0010|\u001a\u00020}2\u0006\u0010~\u001a\u00020\u00062\u0007\u0010\u001a\u00030\u00012\u001d\u0010\u0001\u001a\u0018\u0012\u0005\u0012\u00030\u0001\u0018\u00010#j\u000b\u0012\u0005\u0012\u00030\u0001\u0018\u0001`$2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001JR\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u001a\u00030\u00012\u0006\u0010~\u001a\u00020\u00062\u001d\u0010\u0001\u001a\u0018\u0012\u0005\u0012\u00030\u0001\u0018\u00010#j\u000b\u0012\u0005\u0012\u00030\u0001\u0018\u0001`$2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J8\u0010\u0001\u001a\u00030\u00012\u0006\u0010~\u001a\u00020\u00062\u0007\u0010\u001a\u00030\u00012\u001d\u0010\u0001\u001a\u0018\u0012\u0005\u0012\u00030\u0001\u0018\u00010#j\u000b\u0012\u0005\u0012\u00030\u0001\u0018\u0001`$J\t\u0010\u0001\u001a\u00020zH\u0002J\u0007\u0010\u0001\u001a\u00020zJ#\u0010\u0001\u001a\u00020z2\u0007\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020.2\b\u0010\u0001\u001a\u00030\u0001R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R.\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010#j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R.\u0010)\u001a\u0016\u0012\u0004\u0012\u00020*\u0018\u00010#j\n\u0012\u0004\u0012\u00020*\u0018\u0001`$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R.\u0010-\u001a\u0016\u0012\u0004\u0012\u00020.\u0018\u00010#j\n\u0012\u0004\u0012\u00020.\u0018\u0001`$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0019\"\u0004\b4\u0010\u001bR\u001a\u00105\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R.\u0010:\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010#j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010&\"\u0004\b<\u0010(R\u001a\u0010=\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0019\"\u0004\b?\u0010\u001bR\u001a\u0010@\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0019\"\u0004\bB\u0010\u001bR\u001c\u0010C\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001c\u0010H\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010E\"\u0004\bJ\u0010GR\u001c\u0010K\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\n\"\u0004\bM\u0010\fR\u001c\u0010N\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010E\"\u0004\bP\u0010GR\u0011\u0010Q\u001a\u00020R¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u001e\u0010U\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0010\n\u0002\u0010Z\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001c\u0010[\u001a\u0004\u0018\u00010\\X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001c\u0010a\u001a\u0004\u0018\u00010bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u001a\u0010g\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u00107\"\u0004\bi\u00109R.\u0010j\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010#j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010&\"\u0004\bl\u0010(R.\u0010m\u001a\u0016\u0012\u0004\u0012\u00020.\u0018\u00010#j\n\u0012\u0004\u0012\u00020.\u0018\u0001`$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010&\"\u0004\bo\u0010(R2\u0010p\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010q\u0018\u00010#j\f\u0012\u0006\u0012\u0004\u0018\u00010q\u0018\u0001`$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010&\"\u0004\bs\u0010(R\u001c\u0010t\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010x¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "TAG", "", "compositionInfo", "", "getCompositionInfo", "()[B", "setCompositionInfo", "([B)V", "draftLocalId", "", "getDraftLocalId", "()J", "setDraftLocalId", "(J)V", "extraMusic", "getExtraMusic", "setExtraMusic", "fromCamera", "", "getFromCamera", "()Z", "setFromCamera", "(Z)V", "geoDegree", "Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "getGeoDegree", "()Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "setGeoDegree", "(Lcom/tencent/mm/plugin/finder/utils/GeoDegree;)V", "halfImageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getHalfImageList", "()Ljava/util/ArrayList;", "setHalfImageList", "(Ljava/util/ArrayList;)V", "halfRectList", "Landroid/graphics/Rect;", "getHalfRectList", "setHalfRectList", "imageQualityList", "", "getImageQualityList", "setImageQualityList", "getIntent", "()Landroid/content/Intent;", "isLongVideo", "setLongVideo", "mediaCount", "getMediaCount", "()I", "setMediaCount", "(I)V", "mediaList", "getMediaList", "setMediaList", "mediaMute", "getMediaMute", "setMediaMute", "musicMute", "getMusicMute", "setMusicMute", "originBgmUrl", "getOriginBgmUrl", "()Ljava/lang/String;", "setOriginBgmUrl", "(Ljava/lang/String;)V", "originMusicId", "getOriginMusicId", "setOriginMusicId", "originMusicInfo", "getOriginMusicInfo", "setOriginMusicInfo", "originMusicPath", "getOriginMusicPath", "setOriginMusicPath", "postData", "Landroid/os/Bundle;", "getPostData", "()Landroid/os/Bundle;", "postType", "getPostType", "()Ljava/lang/Integer;", "setPostType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRefFeed", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeed", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "refFeedContent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "getRefFeedContent", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "setRefFeedContent", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;)V", "soundTrackType", "getSoundTrackType", "setSoundTrackType", "thumbList", "getThumbList", "setThumbList", "typeList", "getTypeList", "setTypeList", "videoCropInfoList", "Landroid/os/Parcelable;", "getVideoCropInfoList", "setVideoCropInfoList", "vlogCropRect", "getVlogCropRect", "()Landroid/graphics/Rect;", "setVlogCropRect", "(Landroid/graphics/Rect;)V", "delMedia", "", "doPost", "context", "Landroid/app/Activity;", "desc", "uploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "atContactList", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "activityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "genHoldingPostData", "Lcom/tencent/mm/plugin/finder/upload/HoldingPostData;", "sdkShareUIC", "Lcom/tencent/mm/plugin/finder/ui/post/SdkShareUIC;", "generateFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "initLongVideoCropInfo", "setupPostDataForMediaWidget", "updatePostVideoCoverUrl", "coverUrl", "coverQuality", "cropInfo", "Lcom/tencent/mm/plugin/finder/video/LocalVideoCropInfoParcelable;", "plugin-finder_release"})
public final class c {
    public final String TAG = "Finder.PostDataManager";
    private int dJl;
    public final Intent intent;
    public boolean isLongVideo;
    public boolean mch;
    public int soundTrackType;
    public ArrayList<String> tGk = this.intent.getStringArrayListExtra("postMediaList");
    public String vMV;
    public String vMX;
    public byte[] vMY;
    public String vMZ;
    public azy vTz;
    public final Bundle vUI = new Bundle();
    public Integer wCl = Integer.valueOf(this.intent.getIntExtra("postType", -1));
    public ArrayList<Integer> wCm = this.intent.getIntegerArrayListExtra("key_post_media_quality_list");
    public byte[] wCn = this.intent.getByteArrayExtra("video_composition");
    public ArrayList<Parcelable> wCo;
    public ArrayList<String> wCp;
    public ArrayList<Integer> wCq;
    public FinderObjectDesc wCr;
    public Rect wCs;
    public byte[] wCt;
    public boolean wCu;
    public boolean wCv;
    public long wCw = this.intent.getLongExtra("KEY_FINDER_POST_DRAFT_LOCAL_ID", 0);
    public ArrayList<String> wCx;
    public ArrayList<Rect> wCy;

    public c(Intent intent2) {
        int i2 = 0;
        p.h(intent2, "intent");
        AppMethodBeat.i(256114);
        this.intent = intent2;
        ArrayList<String> arrayList = this.tGk;
        this.dJl = arrayList != null ? arrayList.size() : 0;
        Integer num = this.wCl;
        if (num != null && num.intValue() == 8) {
            this.wCq = this.intent.getIntegerArrayListExtra("postTypeList");
        }
        byte[] byteArrayExtra = this.intent.getByteArrayExtra("postRefMediaList");
        if (byteArrayExtra != null) {
            FinderObjectDesc finderObjectDesc = new FinderObjectDesc();
            try {
                finderObjectDesc.parseFrom(byteArrayExtra);
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
                finderObjectDesc = null;
            }
            this.wCr = finderObjectDesc;
        }
        byte[] byteArrayExtra2 = this.intent.getByteArrayExtra("postRefFeedInfo");
        if (byteArrayExtra2 != null) {
            azy azy = new azy();
            azy.parseFrom(byteArrayExtra2);
            this.vTz = azy;
        }
        this.mch = this.intent.getBooleanExtra("KEY_POST_FROM_CAMERA", false);
        this.wCo = this.intent.getParcelableArrayListExtra("postVideoCropList");
        this.wCp = this.intent.getStringArrayListExtra("postThumbList");
        this.wCs = (Rect) this.intent.getParcelableExtra("KEY_POST_VLOG_CROP_RECT");
        this.wCt = this.intent.getByteArrayExtra("MEDIA_EXTRA_MUSIC");
        this.vMX = this.intent.getStringExtra("ORIGIN_MUSIC_ID");
        this.vMY = this.intent.getByteArrayExtra("ORIGIN_MUSIC_INFO");
        this.vMV = this.intent.getStringExtra("ORIGIN_MUSIC_PATH");
        this.vMZ = this.intent.getStringExtra("ORIGIN_BGM_URL");
        this.wCu = this.intent.getBooleanExtra("MEDIA_IS_MUTE", this.wCu);
        this.wCv = this.intent.getBooleanExtra("MUSIC_IS_MUTE", this.wCv);
        this.soundTrackType = this.intent.getIntExtra("SOUND_TRACK_TYPE", 0);
        String stringExtra = this.intent.getStringExtra(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID);
        String stringExtra2 = this.intent.getStringExtra("edit_id");
        if (stringExtra != null) {
            i iVar = i.vfo;
            i.gR(stringExtra, stringExtra2);
        }
        this.isLongVideo = this.intent.getBooleanExtra("isLongVideoPost", false);
        this.wCx = this.intent.getStringArrayListExtra("KEY_POST_HALF_IMAGE_LIST");
        this.wCy = this.intent.getParcelableArrayListExtra("KEY_POST_HALF_RECT_LIST");
        String str = this.TAG;
        StringBuilder append = new StringBuilder("postType ").append(this.wCl).append(", mediaList ").append(this.tGk).append(" mediaCount ").append(this.dJl).append(' ').append("thumbList ").append(this.wCp).append(" thumbCount ");
        ArrayList<String> arrayList2 = this.wCp;
        Log.i(str, append.append(arrayList2 != null ? arrayList2.size() : i2).append(", fromCamera:").append(this.mch).toString());
        AppMethodBeat.o(256114);
    }

    public final com.tencent.mm.plugin.finder.upload.p a(g gVar, String str, ArrayList<cjj> arrayList, SdkShareUIC sdkShareUIC, azs azs) {
        String str2;
        String str3;
        String str4;
        int i2;
        AppMethodBeat.i(256112);
        axt axt = new axt();
        aqp aqp = new aqp();
        azy azy = null;
        Bundle bundle = this.vUI;
        a.C1355a aVar = a.wCk;
        byte[] byteArray = bundle.getByteArray(a.dIY());
        if (byteArray != null) {
            axt.parseFrom(byteArray);
        }
        Bundle bundle2 = this.vUI;
        a.C1355a aVar2 = a.wCk;
        byte[] byteArray2 = bundle2.getByteArray(a.dIZ());
        if (byteArray2 != null) {
            aqp.parseFrom(byteArray2);
        }
        Bundle bundle3 = this.vUI;
        a.C1355a aVar3 = a.wCk;
        int i3 = bundle3.getInt(a.dJd(), 0);
        Bundle bundle4 = this.vUI;
        a.C1355a aVar4 = a.wCk;
        boolean z = bundle4.getBoolean(a.dJc(), false);
        Bundle bundle5 = this.vUI;
        a.C1355a aVar5 = a.wCk;
        byte[] byteArray3 = bundle5.getByteArray(a.dJa());
        Bundle bundle6 = this.vUI;
        a.C1355a aVar6 = a.wCk;
        byte[] byteArray4 = bundle6.getByteArray(a.dJb());
        if (!(byteArray3 == null || byteArray4 == null)) {
            azy azy2 = new azy();
            try {
                azy2.parseFrom(byteArray3);
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
                azy2 = null;
            }
            azy = azy2;
        }
        boolean z2 = this.vUI.getBoolean("isNews");
        arm arm = new arm();
        if (sdkShareUIC == null || (str2 = sdkShareUIC.vRz) == null) {
            str2 = "";
        }
        arm.dNI = str2;
        int i4 = gVar.type;
        String nullAsNil = Util.nullAsNil(str);
        p.g(nullAsNil, "Util.nullAsNil(desc)");
        cjk cjk = gVar.wDD;
        String str5 = gVar.vTB;
        boolean z3 = this.isLongVideo;
        if (sdkShareUIC == null || (str3 = sdkShareUIC.tsW) == null) {
            str3 = "";
        }
        if (sdkShareUIC == null || (str4 = sdkShareUIC.tsX) == null) {
            str4 = "";
        }
        if (sdkShareUIC == null) {
            i2 = 0;
        } else if (Util.isNullOrNil(sdkShareUIC.dAO())) {
            i2 = 0;
        } else if (Util.isNullOrNil(sdkShareUIC.tsW)) {
            i2 = SdkShareUIC.vRA;
        } else {
            i2 = SdkShareUIC.vRB;
        }
        com.tencent.mm.plugin.finder.upload.p pVar = new com.tencent.mm.plugin.finder.upload.p(i4, nullAsNil, cjk, axt, aqp, i3, azy, z, str5, arrayList, z3, z2, arm, str3, str4, i2, azs);
        Log.i(this.TAG, "doPost, mediaType:" + pVar.mediaType + ", isLongVideo:" + pVar.isLongVideo + ", sdkShareType:" + pVar.sdkShareType);
        AppMethodBeat.o(256112);
        return pVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:191:0x05f8, code lost:
        if (com.tencent.mm.plugin.finder.storage.c.drO() != false) goto L_0x05fa;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.finder.storage.FinderItem a(java.lang.String r27, com.tencent.mm.plugin.finder.widget.post.g r28, java.util.ArrayList<com.tencent.mm.protocal.protobuf.cjj> r29) {
        /*
        // Method dump skipped, instructions count: 2492
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.widget.post.c.a(java.lang.String, com.tencent.mm.plugin.finder.widget.post.g, java.util.ArrayList):com.tencent.mm.plugin.finder.storage.FinderItem");
    }
}
