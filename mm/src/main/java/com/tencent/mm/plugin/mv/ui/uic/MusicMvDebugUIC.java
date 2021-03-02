package com.tencent.mm.plugin.mv.ui.uic;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.plugin.mv.a.a.m;
import com.tencent.mm.plugin.mv.a.a.n;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axx;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.LinkedList;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvDebugUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TAG", "", "copySongInfo", "genCgiInfo", "genMvHeadInfo", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "genMvRefObjInfo", "genMvTrackInfo", "longClickMoreMenu", "", "Companion", "plugin-mv_release"})
public final class MusicMvDebugUIC extends UIComponent {
    public static final a Att = new a((byte) 0);
    public final String TAG = "MicroMsg.Mv.MusicMvDebugUIC";

    static {
        AppMethodBeat.i(257119);
        AppMethodBeat.o(257119);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMvDebugUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(257118);
        AppMethodBeat.o(257118);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvDebugUIC$Companion;", "", "()V", "MENU_ID_DEBUG_CLEAR_CACHE", "", "MENU_ID_DEBUG_MV_CGI_INFO", "MENU_ID_DEBUG_MV_HEAD_INFO", "MENU_ID_DEBUG_MV_REF_OBJ_LIST_INFO", "MENU_ID_DEBUG_MV_TRACK_LIST_INFO", "MENU_ID_DEBUG_SONG_INFO", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class b implements o.f {
        final /* synthetic */ MusicMvDebugUIC Atu;

        public b(MusicMvDebugUIC musicMvDebugUIC) {
            this.Atu = musicMvDebugUIC;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(257114);
            mVar.a(1101, (CharSequence) this.Atu.getContext().getString(R.string.bkx), R.raw.bottomsheet_icon_star, this.Atu.getContext().getResources().getColor(R.color.Brand), false);
            mVar.a(1102, (CharSequence) this.Atu.getContext().getString(R.string.j85), R.raw.bottomsheet_icon_star, this.Atu.getContext().getResources().getColor(R.color.Brand), false);
            mVar.a(1103, (CharSequence) this.Atu.getContext().getString(R.string.j87), R.raw.bottomsheet_icon_star, this.Atu.getContext().getResources().getColor(R.color.Brand), false);
            mVar.a(1104, (CharSequence) this.Atu.getContext().getString(R.string.j86), R.raw.bottomsheet_icon_star, this.Atu.getContext().getResources().getColor(R.color.Brand), false);
            mVar.a(1105, (CharSequence) this.Atu.getContext().getString(R.string.j84), R.raw.bottomsheet_icon_star, this.Atu.getContext().getResources().getColor(R.color.Brand), false);
            AppMethodBeat.o(257114);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class c implements o.f {
        final /* synthetic */ MusicMvDebugUIC Atu;

        public c(MusicMvDebugUIC musicMvDebugUIC) {
            this.Atu = musicMvDebugUIC;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(259240);
            mVar.a(TXLiteAVCode.WARNING_MICROPHONE_DEVICE_EMPTY, (CharSequence) this.Atu.getContext().getString(R.string.bkw), R.raw.bottomsheet_icon_star, this.Atu.getContext().getResources().getColor(R.color.Brand), false);
            AppMethodBeat.o(259240);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class d implements o.g {
        final /* synthetic */ MusicMvDebugUIC Atu;
        final /* synthetic */ String UZV;
        final /* synthetic */ String UZW;
        final /* synthetic */ String UZX;
        final /* synthetic */ String UZY;
        final /* synthetic */ String UZZ;

        public d(MusicMvDebugUIC musicMvDebugUIC, String str, String str2, String str3, String str4, String str5) {
            this.Atu = musicMvDebugUIC;
            this.UZV = str;
            this.UZW = str2;
            this.UZX = str3;
            this.UZY = str4;
            this.UZZ = str5;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(259241);
            p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 1101:
                    ClipboardHelper.setText(this.UZV);
                    Toast.makeText(this.Atu.getActivity(), (int) R.string.ta, 0).show();
                    AppMethodBeat.o(259241);
                    return;
                case 1102:
                    ClipboardHelper.setText(this.UZW);
                    Toast.makeText(this.Atu.getActivity(), (int) R.string.ta, 0).show();
                    AppMethodBeat.o(259241);
                    return;
                case 1103:
                    ClipboardHelper.setText(this.UZX);
                    Toast.makeText(this.Atu.getActivity(), (int) R.string.ta, 0).show();
                    AppMethodBeat.o(259241);
                    return;
                case 1104:
                    ClipboardHelper.setText(this.UZY);
                    Toast.makeText(this.Atu.getActivity(), (int) R.string.ta, 0).show();
                    AppMethodBeat.o(259241);
                    return;
                case 1105:
                    ClipboardHelper.setText(this.UZZ);
                    Toast.makeText(this.Atu.getActivity(), (int) R.string.ta, 0).show();
                    break;
            }
            AppMethodBeat.o(259241);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class e implements o.g {
        final /* synthetic */ MusicMvDebugUIC Atu;

        public e(MusicMvDebugUIC musicMvDebugUIC) {
            this.Atu = musicMvDebugUIC;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(259242);
            p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case TXLiteAVCode.WARNING_MICROPHONE_DEVICE_EMPTY:
                    g gVar = g.Aku;
                    s.deleteDir(g.eux());
                    this.Atu.getActivity().finish();
                    Toast.makeText(this.Atu.getActivity(), (int) R.string.t4, 0).show();
                    break;
            }
            AppMethodBeat.o(259242);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class f implements e.b {
        public static final f Vaa = new f();

        static {
            AppMethodBeat.i(259243);
            AppMethodBeat.o(259243);
        }

        f() {
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
        }
    }

    public static String l(com.tencent.mm.plugin.mv.a.e eVar) {
        String str;
        Float f2 = null;
        AppMethodBeat.i(259244);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ch.COL_LOCALID, eVar.ApB);
        jSONObject.put("localCoverPath", eVar.ApD);
        jSONObject.put("mvObjectId", eVar.ApE);
        Long l = eVar.ApE;
        jSONObject.put("unsignedMvObjectId", com.tencent.mm.ac.d.zs(l != null ? l.longValue() : 0));
        jSONObject.put("mvObjectNonceId", eVar.ApF);
        jSONObject.put("mvMakerNickName", eVar.ApG);
        FinderContact finderContact = eVar.ApJ;
        if (finderContact != null) {
            str = finderContact.username;
        } else {
            str = null;
        }
        jSONObject.put("mvMakerUsername", str);
        jSONObject.put("coverUrl", eVar.coverUrl);
        jSONObject.put("likeCount", eVar.likeCount);
        jSONObject.put("forwardCount", eVar.forwardCount);
        jSONObject.put("commentCount", eVar.commentCount);
        jSONObject.put("mvPostStatus", eVar.ApM);
        jSONObject.put("isDelete", eVar.tav);
        axx axx = eVar.ApI;
        if (axx != null) {
            f2 = Float.valueOf(axx.LIe);
        }
        jSONObject.put("originality", f2);
        String jSONObject2 = jSONObject.toString();
        p.g(jSONObject2, "mvHeadInfo.toString()");
        AppMethodBeat.o(259244);
        return jSONObject2;
    }

    public static String m(com.tencent.mm.plugin.mv.a.e eVar) {
        AppMethodBeat.i(259245);
        JSONArray jSONArray = new JSONArray();
        int i2 = 0;
        for (T t : eVar.ApH) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            T t2 = t;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(FirebaseAnalytics.b.INDEX, i2);
            jSONObject.put("refObjectId", t2.refObjectId);
            jSONObject.put("unsignedRefObjectId", com.tencent.mm.ac.d.zs(t2.refObjectId));
            jSONObject.put("refNonceId", t2.LIm);
            jSONObject.put("timeOffsetInMvMs", t2.Ghu);
            jSONObject.put("timeLengthInMvMs", t2.LIl);
            jSONObject.put("timeOffsetInClipMs", t2.Ghw);
            jSONObject.put("isFirstUpload", t2.Vjw);
            jSONArray.put(jSONObject);
            i2 = i3;
        }
        String jSONArray2 = jSONArray.toString();
        p.g(jSONArray2, "trackInfoList.toString()");
        AppMethodBeat.o(259245);
        return jSONArray2;
    }

    public static String n(com.tencent.mm.plugin.mv.a.e eVar) {
        LinkedList<FinderMedia> linkedList;
        FinderMedia finderMedia;
        AppMethodBeat.i(259246);
        JSONArray jSONArray = new JSONArray();
        int i2 = 0;
        for (T t : eVar.ApL) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            T t2 = t;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(FirebaseAnalytics.b.INDEX, i2);
            jSONObject.put("id", t2.id);
            jSONObject.put("unsignedId", com.tencent.mm.ac.d.zs(t2.id));
            jSONObject.put("objectNonceId", t2.objectNonceId);
            FinderContact finderContact = t2.contact;
            jSONObject.put(ch.COL_USERNAME, finderContact != null ? finderContact.username : null);
            FinderContact finderContact2 = t2.contact;
            jSONObject.put("nickname", finderContact2 != null ? finderContact2.nickname : null);
            String str = t2.id != 0 ? "video_" + t2.id : "video_" + t2.objectNonceId;
            jSONObject.put("mediaId", str);
            com.tencent.mm.plugin.mv.ui.a aVar = com.tencent.mm.plugin.mv.ui.a.ArA;
            jSONObject.put("videoPath", com.tencent.mm.plugin.mv.ui.a.aIp(str));
            FinderObjectDesc finderObjectDesc = t2.objectDesc;
            if (!(finderObjectDesc == null || (linkedList = finderObjectDesc.media) == null || (finderMedia = (FinderMedia) j.kt(linkedList)) == null)) {
                jSONObject.put("video_url", finderMedia.url + finderMedia.url_token);
                jSONObject.put("decodeKey", finderMedia.decodeKey);
                jSONObject.put("fileSize", finderMedia.fileSize);
                jSONObject.put("width", Float.valueOf(finderMedia.width));
                jSONObject.put("height", Float.valueOf(finderMedia.height));
                jSONObject.put("videoDuration", finderMedia.videoDuration);
                jSONObject.put("mediaType", finderMedia.mediaType);
                jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, finderMedia.bitrate);
                jSONObject.put("coverUrl", finderMedia.coverUrl);
            }
            jSONArray.put(jSONObject);
            i2 = i3;
        }
        String jSONArray2 = jSONArray.toString();
        p.g(jSONArray2, "refInfoList.toString()");
        AppMethodBeat.o(259246);
        return jSONArray2;
    }

    public static String hWE() {
        AppMethodBeat.i(259247);
        Map e2 = ae.e(new kotlin.o(5286, "NetSceneMusicMvCheckPermission"), new kotlin.o(3710, "NetSceneMusicMvFinderLike"), new kotlin.o(5904, "NetSceneMusicMvGetBeatTrack"), new kotlin.o(6860, "NetSceneMusicMvGetRecommendList"), new kotlin.o(3966, "NetSceneMusicMvGetFinderFavFeed"), new kotlin.o(3763, "NetSceneMusicMvGetFinderFeedDetail"), new kotlin.o(3965, "NetSceneMusicMvGetFinderLikeFeed"), new kotlin.o(5292, "NetSceneMusicMvGetSongStatus"), new kotlin.o(6820, "NetSceneMusicMvHeartbeat"), new kotlin.o(6893, "NetSceneMusicMvJoin"), new kotlin.o(6672, "NetSceneMusicMvPostLiveMsg"));
        JSONObject jSONObject = new JSONObject();
        m.a aVar = com.tencent.mm.plugin.mv.a.a.m.UZC;
        for (Map.Entry entry : com.tencent.mm.plugin.mv.a.a.m.UZB.entrySet()) {
            String str = (String) e2.get(entry.getKey());
            if (str == null) {
                str = String.valueOf(((Number) entry.getKey()).intValue());
            }
            jSONObject.put(str, ((n) entry.getValue()).toString());
        }
        String jSONObject2 = jSONObject.toString();
        p.g(jSONObject2, "cgiInfoObj.toString()");
        AppMethodBeat.o(259247);
        return jSONObject2;
    }
}
