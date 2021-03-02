package com.tencent.mm.plugin.recordvideo.plugin.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.internal.NativeProtocol;
import com.google.android.exoplayer2.v;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.recordvideo.b.d;
import com.tencent.mm.plugin.recordvideo.b.i;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.LyricsInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ]2\u00020\u00012\u00020\u0002:\u0001]B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+J&\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020/2\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u000e00j\b\u0012\u0004\u0012\u00020\u000e`1J\u0006\u00102\u001a\u00020)J\u0016\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u000e00j\b\u0012\u0004\u0012\u00020\u000e`1J\u0006\u00104\u001a\u00020/J\n\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u00020\u0018H\u0016J\u0012\u00108\u001a\u00020)2\b\u00109\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010:\u001a\u00020)H\u0016J\u0006\u0010;\u001a\u00020)J\b\u0010<\u001a\u00020)H\u0016J\b\u0010=\u001a\u00020)H\u0016J\b\u0010>\u001a\u00020)H\u0016J\u0006\u0010?\u001a\u00020)J\b\u0010@\u001a\u00020)H\u0016J3\u0010A\u001a\u00020)2\b\u0010B\u001a\u0004\u0018\u00010/2\b\u0010C\u001a\u0004\u0018\u00010/2\b\u0010D\u001a\u0004\u0018\u0001062\b\b\u0002\u0010E\u001a\u00020/¢\u0006\u0002\u0010FJ\u0006\u0010G\u001a\u00020)J\u0006\u0010H\u001a\u00020)J\u000e\u0010I\u001a\u00020)2\u0006\u0010J\u001a\u00020KJ\u000e\u0010L\u001a\u00020)2\u0006\u0010M\u001a\u00020/J\u0014\u0010N\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+J\u000e\u0010O\u001a\u00020)2\u0006\u0010P\u001a\u00020\u0018J\"\u0010Q\u001a\u00020)2\u0006\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010U2\b\b\u0002\u0010V\u001a\u00020\u0018J\u0018\u0010W\u001a\u00020)2\b\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010X\u001a\u00020\u0018J\u0010\u0010Y\u001a\u00020)2\u0006\u0010Z\u001a\u00020/H\u0016J\u0006\u0010[\u001a\u00020)J\u0006\u0010\\\u001a\u00020)R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001aR\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006^"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addAudioBtn", "Landroid/widget/ImageView;", "addAudioGroup", "Landroid/view/View;", "addAudioTip", "audioCacheInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getAudioCacheInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "setAudioCacheInfo", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "audioPanel", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView;", "editorConfig", "Lcom/tencent/mm/plugin/recordvideo/config/EditorConfig;", "forceEnable", "", "isNeedHackResume", "()Z", "setNeedHackResume", "(Z)V", "isSetOriginMute", "musicController", "Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addMusicList", "", "audioList", "", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "addMusicListFromAudioCache", FirebaseAnalytics.b.INDEX, "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "checkShowAudioPanel", "getAllAudioCache", "getItemIndex", "name", "", "onBackPress", "onClick", "v", "onDetach", "onLyricsItemDeleted", "onPause", "onResume", "release", "replayAudio", "reset", "resetStyle", "bgResId", "textColor", "text", "selectResId", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;I)V", "restartAudio", "resumeMusic", "seekTo", "timeMs", "", "setBackground", "resId", "setMusicList", "setPlayMusicWhenSearchFinish", "enable", "setUpVideoInfo", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "isCaptureFromPic2Video", "setUpVlog", "showMuteOrigin", "setVisibility", "visibility", "showAudioPanel", "unSelectAudio", "Companion", "plugin-recordvideo_release"})
public final class a implements View.OnClickListener, t {
    public static final C1649a BTG = new C1649a((byte) 0);
    private final ImageView BTA;
    final ImageView BTB;
    private final View BTC;
    private d BTD;
    private boolean BTE;
    private boolean BTF;
    private ViewGroup parent;
    final b wgF;
    public AudioCacheInfo wgG;
    public final EditorAudioView wgL;
    com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;

    static {
        AppMethodBeat.i(75757);
        AppMethodBeat.o(75757);
    }

    public a(ViewGroup viewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar) {
        p.h(viewGroup, "parent");
        p.h(dVar, "status");
        AppMethodBeat.i(75756);
        this.parent = viewGroup;
        this.wgr = dVar;
        View findViewById = this.parent.findViewById(R.id.bwf);
        p.g(findViewById, "parent.findViewById(R.id.editor_add_audio)");
        this.BTA = (ImageView) findViewById;
        View findViewById2 = this.parent.findViewById(R.id.bwg);
        p.g(findViewById2, "parent.findViewById(R.id.editor_add_audio_check)");
        this.BTB = (ImageView) findViewById2;
        View findViewById3 = this.parent.findViewById(R.id.bwh);
        p.g(findViewById3, "parent.findViewById(R.id.editor_add_audio_group)");
        this.BTC = findViewById3;
        View findViewById4 = this.parent.findViewById(R.id.bwy);
        p.g(findViewById4, "parent.findViewById(R.id.editor_audio_panel)");
        this.wgL = (EditorAudioView) findViewById4;
        Context context = this.parent.getContext();
        p.g(context, "parent.context");
        this.wgF = new b(context);
        this.BTD = new d();
        this.BTE = true;
        this.BTE = ((b) g.af(b.class)).a(b.a.clicfg_show_mediacomponent_audio, true);
        Log.i("MicroMsg.EditAddMusicPlugin", "forceEnable " + this.BTE);
        ImageView imageView = this.BTB;
        Context context2 = this.parent.getContext();
        p.g(context2, "parent.context");
        imageView.setImageDrawable(context2.getResources().getDrawable(R.raw.popvideo_post_selected));
        this.BTA.setImageDrawable(ar.m(this.parent.getContext(), R.raw.icons_filled_music, -1));
        this.BTA.setOnClickListener(this);
        if (this.BTE) {
            this.wgL.setOnVisibleChangeCallback(new kotlin.g.a.b<Boolean, x>(this) {
                /* class com.tencent.mm.plugin.recordvideo.plugin.a.a.AnonymousClass1 */
                final /* synthetic */ a BTH;

                {
                    this.BTH = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(Boolean bool) {
                    AppMethodBeat.i(75738);
                    if (bool.booleanValue()) {
                        d.b.a(this.BTH.wgr, d.c.BVg);
                    } else {
                        d.b.a(this.BTH.wgr, d.c.BVj);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(75738);
                    return xVar;
                }
            });
            this.wgL.setCallback(new EditorAudioView.a(this) {
                /* class com.tencent.mm.plugin.recordvideo.plugin.a.a.AnonymousClass2 */
                final /* synthetic */ a BTH;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.BTH = r1;
                }

                @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.a
                public final void e(boolean z, List<? extends ckm> list) {
                    AppMethodBeat.i(75739);
                    p.h(list, "lyricsInfos");
                    if (list.isEmpty()) {
                        AppMethodBeat.o(75739);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("EDIT_SELECT_MUSIC_LYRICS_LIST", new LyricsInfo(list));
                    bundle.putBoolean("EDIT_SELECT_MUSIC_LYRICS_BOOLEAN", z);
                    this.BTH.wgr.a(d.c.BVm, bundle);
                    AppMethodBeat.o(75739);
                }

                @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.a
                public final void pauseAudio() {
                    AppMethodBeat.i(75740);
                    this.BTH.wgF.pauseAudio();
                    AppMethodBeat.o(75740);
                }

                @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.a
                public final void a(AudioCacheInfo audioCacheInfo) {
                    int i2 = 0;
                    AppMethodBeat.i(75741);
                    if (audioCacheInfo == null) {
                        a aVar = this.BTH;
                        aVar.BTB.setVisibility(8);
                        aVar.wgG = null;
                        aVar.wgF.pauseAudio();
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("EDIT_SELECT_MUSIC_LYRICS_BOOLEAN", false);
                        this.BTH.wgr.a(d.c.BVm, bundle);
                        this.BTH.wgr.a(d.c.BUI, null);
                        AppMethodBeat.o(75741);
                        return;
                    }
                    int i3 = audioCacheInfo.type;
                    AudioCacheInfo.a aVar2 = AudioCacheInfo.BPo;
                    if (i3 == AudioCacheInfo.BPi) {
                        this.BTH.wgF.pauseAudio();
                        AppMethodBeat.o(75741);
                        return;
                    }
                    this.BTH.BTB.setVisibility(0);
                    this.BTH.wgG = audioCacheInfo;
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("EDIT_SELECT_MUSIC_PARCELABLE", audioCacheInfo);
                    this.BTH.wgr.a(d.c.BVl, bundle2);
                    v d2 = this.BTH.wgF.d(audioCacheInfo);
                    if (d2 != null) {
                        this.BTH.wgL.setMusicPlayer(d2);
                    }
                    c cVar = c.BXI;
                    c.x("KEY_MUSIC_ID_INT", Integer.valueOf(audioCacheInfo.BOX));
                    c cVar2 = c.BXI;
                    int i4 = audioCacheInfo.source;
                    AudioCacheInfo.a aVar3 = AudioCacheInfo.BPo;
                    c.x("KEY_MUSIC_INDEX_INT", Integer.valueOf(i4 == AudioCacheInfo.BPn ? 0 : audioCacheInfo.position + 1));
                    c cVar3 = c.BXI;
                    c.x("KEY_MUSIC_REQ_ID_INT", Long.valueOf(audioCacheInfo.BPd));
                    c cVar4 = c.BXI;
                    int i5 = audioCacheInfo.source;
                    AudioCacheInfo.a aVar4 = AudioCacheInfo.BPo;
                    if (i5 == AudioCacheInfo.BPn) {
                        i2 = 1;
                    }
                    c.x("KEY_SEARCH_MUSIC_INT", Integer.valueOf(i2));
                    AppMethodBeat.o(75741);
                }

                @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.a
                public final void b(AudioCacheInfo audioCacheInfo) {
                    AppMethodBeat.i(75742);
                    p.h(audioCacheInfo, "info");
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("EDIT_VLOG_SEARCH_MUSIC_FINISH_PARCELABLE", audioCacheInfo);
                    this.BTH.wgr.a(d.c.BVX, bundle);
                    AppMethodBeat.o(75742);
                }

                @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.a
                public final void oR(boolean z) {
                    AppMethodBeat.i(75743);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN", z);
                    this.BTH.wgr.a(d.c.BVk, bundle);
                    AppMethodBeat.o(75743);
                }
            });
        } else {
            this.BTC.setVisibility(8);
        }
        this.wgL.eLT();
        AppMethodBeat.o(75756);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(237400);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237400);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    /* renamed from: com.tencent.mm.plugin.recordvideo.plugin.a.a$a  reason: collision with other inner class name */
    public static final class C1649a {
        private C1649a() {
        }

        public /* synthetic */ C1649a(byte b2) {
            this();
        }
    }

    public static /* synthetic */ void a(a aVar, com.tencent.mm.media.widget.camerarecordview.b.b bVar, RecordConfigProvider recordConfigProvider) {
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(237399);
        p.h(bVar, "info");
        c.a aVar2 = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
        com.tencent.mm.plugin.recordvideo.model.audio.c.BPz = new com.tencent.mm.plugin.recordvideo.model.audio.c();
        aVar.BTD = new com.tencent.mm.plugin.recordvideo.b.d();
        ArrayList<String> arrayList = bVar.iqm;
        boolean z4 = !(arrayList == null || arrayList.isEmpty());
        Log.i("MicroMsg.EditAddMusicPlugin", "editorConfig : " + aVar.BTD);
        long j2 = (long) bVar.iqg;
        Integer valueOf = recordConfigProvider != null ? Integer.valueOf(recordConfigProvider.scene) : null;
        if (valueOf != null && valueOf.intValue() == 2) {
            aVar.BTD.a(i.SNSComm);
            com.tencent.mm.plugin.recordvideo.b.d dVar = aVar.BTD;
            if (((b) g.af(b.class)).a(b.a.clicfg_video_editor_lyrics_enable, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            dVar.BNb = z;
        } else if (valueOf != null && valueOf.intValue() == 1) {
            aVar.BTD.a(i.Chatting);
            com.tencent.mm.plugin.recordvideo.b.d dVar2 = aVar.BTD;
            if (((b) g.af(b.class)).a(b.a.clicfg_video_editor_lyrics_enable_c2c, 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            dVar2.BNb = z2;
        } else if (valueOf != null && valueOf.intValue() == 3) {
            aVar.BTD.a(i.StoryComm);
            aVar.BTD.BNb = true;
            aVar.BTD.BNa = z4;
            aVar.BTD.BNe = ((b) g.af(b.class)).a(b.a.clicfg_story_visitor_enable, false);
        } else if (valueOf != null && valueOf.intValue() == 5) {
            aVar.BTD.a(i.WXGGame);
        } else if (valueOf != null && valueOf.intValue() == 11) {
            aVar.BTD.a(i.Finder);
            aVar.BTD.BNb = false;
            com.tencent.mm.plugin.recordvideo.b.d dVar3 = aVar.BTD;
            if (bVar.iqp != null) {
                Bundle bundle = bVar.iqp;
                if (bundle == null) {
                    p.hyc();
                }
                AudioCacheInfo.a aVar3 = AudioCacheInfo.BPo;
                z3 = bundle.getBoolean(AudioCacheInfo.BPg, false);
            } else {
                z3 = false;
            }
            dVar3.BNc = z3;
            if (bVar.iqg > recordConfigProvider.BOv) {
                j2 = (long) recordConfigProvider.BOv;
            }
        }
        aVar.setPlayMusicWhenSearchFinish(true);
        EditorAudioView.a(aVar.wgL, bVar.iqd, bVar.iqm, (long) bVar.dvv, j2, z4, aVar.BTD, false, 64);
        AppMethodBeat.o(237399);
    }

    public final void gh(List<? extends clp> list) {
        AppMethodBeat.i(75745);
        p.h(list, "audioList");
        this.wgL.eL(list);
        AppMethodBeat.o(75745);
    }

    public final void gi(List<? extends clp> list) {
        AppMethodBeat.i(75746);
        p.h(list, "audioList");
        this.wgL.eL(list);
        this.wgL.aN(0, true);
        AppMethodBeat.o(75746);
    }

    public final void setPlayMusicWhenSearchFinish(boolean z) {
        AppMethodBeat.i(75747);
        this.wgL.setPlayMusicWhenSearchFinish(z);
        AppMethodBeat.o(75747);
    }

    public final void eKP() {
        AppMethodBeat.i(163464);
        if (this.BTD.BNf == i.StoryComm && this.BTD.BNe) {
            this.wgL.setShow(true);
        }
        AppMethodBeat.o(163464);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(75748);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(view != null ? view.getContext() : null)) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(75748);
            return;
        }
        this.wgL.setShow(true);
        com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.aLu("KEY_CLICK_MUSIC_COUNT_INT");
        com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.VH(6);
        com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.VI(5);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(75748);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(75749);
        if (this.BTE) {
            this.BTC.setVisibility(i2);
        }
        AppMethodBeat.o(75749);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
        AppMethodBeat.i(75750);
        Log.i("MicroMsg.EditAddMusicPlugin", "pauseAudio");
        this.wgF.pauseAudio();
        AppMethodBeat.o(75750);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
        AppMethodBeat.i(75751);
        reset();
        this.wgG = null;
        this.wgF.release();
        this.wgL.destroy();
        AppMethodBeat.o(75751);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
        AppMethodBeat.i(75752);
        onPause();
        AppMethodBeat.o(75752);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
        AppMethodBeat.i(75753);
        if (!this.BTF && this.wgL.getWithMusic()) {
            Log.i("MicroMsg.EditAddMusicPlugin", "resumeMusic");
            this.wgF.eKR();
        }
        AppMethodBeat.o(75753);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        AppMethodBeat.i(75754);
        if (this.wgL.bJw()) {
            this.wgL.back();
            AppMethodBeat.o(75754);
            return true;
        }
        this.wgL.reset();
        c.a aVar = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
        com.tencent.mm.plugin.recordvideo.model.audio.c cVar = com.tencent.mm.plugin.recordvideo.model.audio.c.BPz;
        if (cVar != null) {
            cVar.eKf();
        }
        AppMethodBeat.o(75754);
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return "plugin_music";
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
        AppMethodBeat.i(75755);
        this.BTB.setVisibility(8);
        AppMethodBeat.o(75755);
    }

    public static /* synthetic */ void a(a aVar, Integer num, Integer num2) {
        AppMethodBeat.i(237398);
        EditorAudioView.a(aVar.wgL, num, num2, Integer.valueOf((int) R.drawable.ax5), Integer.valueOf((int) R.color.am), Integer.valueOf((int) R.raw.ui_rescoures_checkbox_selected), Integer.valueOf((int) R.color.am), Integer.valueOf((int) R.drawable.fq), Integer.valueOf((int) R.raw.icons_filled_music), Integer.valueOf((int) R.color.a_b), Integer.valueOf((int) R.color.a_i), Integer.valueOf((int) R.color.a_f), Integer.valueOf((int) R.drawable.g1), false, 8192);
        AppMethodBeat.o(237398);
    }
}
