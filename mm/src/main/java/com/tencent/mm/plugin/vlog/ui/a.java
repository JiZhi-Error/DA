package com.tencent.mm.plugin.vlog.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.google.android.exoplayer2.v;
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
import com.tencent.mm.plugin.recordvideo.plugin.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.MMEditorRecordButton;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.ui.plugin.e;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.x;

public final class a implements View.OnClickListener, t, e.c, e.d {
    public static final C1857a GDy = new C1857a((byte) 0);
    private final ImageView BTA;
    final ImageView BTB;
    private final View BTC;
    private d BTD;
    private boolean BTE;
    private boolean BTF;
    private e.AbstractC1868e GDw;
    private long GDx;
    private ViewGroup parent;
    private final b wgF;
    AudioCacheInfo wgG;
    List<Object> wgJ;
    final EditorAudioView wgL;
    com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;

    static {
        AppMethodBeat.i(190942);
        AppMethodBeat.o(190942);
    }

    public a(ViewGroup viewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar) {
        p.h(viewGroup, "parent");
        p.h(dVar, "status");
        AppMethodBeat.i(190941);
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
        this.GDx = -1;
        this.wgJ = new ArrayList();
        this.BTE = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_show_mediacomponent_audio, true);
        Log.i("MicroMsg.EditAddMusicPlugin", "forceEnable " + this.BTE);
        ImageView imageView = this.BTB;
        Context context2 = this.parent.getContext();
        p.g(context2, "parent.context");
        imageView.setImageDrawable(context2.getResources().getDrawable(R.raw.popvideo_post_selected));
        this.BTA.setImageDrawable(ar.m(this.parent.getContext(), R.raw.icons_filled_sound, -1));
        this.BTA.setOnClickListener(this);
        if (this.BTE) {
            this.wgL.setOnVisibleChangeCallback(new kotlin.g.a.b<Boolean, x>(this) {
                /* class com.tencent.mm.plugin.vlog.ui.a.AnonymousClass1 */
                final /* synthetic */ a GDz;

                {
                    this.GDz = r2;
                }

                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(Boolean bool) {
                    AppMethodBeat.i(190905);
                    if (bool.booleanValue()) {
                        d.b.a(this.GDz.wgr, d.c.BVg);
                        this.GDz.GDx = -1;
                    } else {
                        d.b.a(this.GDz.wgr, d.c.BVj);
                        com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar = this.GDz.wgr;
                        d.c cVar = d.c.BVh;
                        Bundle bundle = new Bundle();
                        bundle.putLong("PARAM_1_LONG", this.GDz.GDx);
                        dVar.a(cVar, bundle);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(190905);
                    return xVar;
                }
            });
            this.wgL.setCallback(new EditorAudioView.a(this) {
                /* class com.tencent.mm.plugin.vlog.ui.a.AnonymousClass2 */
                final /* synthetic */ a GDz;

                {
                    this.GDz = r1;
                }

                @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.a
                public final void e(boolean z, List<? extends ckm> list) {
                    AppMethodBeat.i(190906);
                    p.h(list, "lyricsInfos");
                    if (list.isEmpty()) {
                        AppMethodBeat.o(190906);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("EDIT_SELECT_MUSIC_LYRICS_LIST", new LyricsInfo(list));
                    bundle.putBoolean("EDIT_SELECT_MUSIC_LYRICS_BOOLEAN", z);
                    this.GDz.wgr.a(d.c.BVm, bundle);
                    AppMethodBeat.o(190906);
                }

                @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.a
                public final void pauseAudio() {
                    AppMethodBeat.i(190907);
                    this.GDz.bdY();
                    AppMethodBeat.o(190907);
                }

                @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.a
                public final void a(AudioCacheInfo audioCacheInfo) {
                    int i2 = 0;
                    AppMethodBeat.i(190908);
                    if (p.j(this.GDz.wgG, audioCacheInfo)) {
                        if (this.GDz.wgG != null) {
                            this.GDz.bdZ();
                        }
                        AppMethodBeat.o(190908);
                    } else if (audioCacheInfo == null) {
                        this.GDz.GDx = 0;
                        this.GDz.wgG = audioCacheInfo;
                        a aVar = this.GDz;
                        aVar.BTB.setVisibility(8);
                        aVar.wgG = null;
                        aVar.bdY();
                        d.b.a(this.GDz.wgr, d.c.BVl);
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("EDIT_SELECT_MUSIC_LYRICS_BOOLEAN", false);
                        this.GDz.wgr.a(d.c.BVm, bundle);
                        this.GDz.wgr.a(d.c.BUI, null);
                        AppMethodBeat.o(190908);
                    } else {
                        int i3 = audioCacheInfo.type;
                        AudioCacheInfo.a aVar2 = AudioCacheInfo.BPo;
                        if (i3 == AudioCacheInfo.BPi) {
                            this.GDz.bdY();
                            AppMethodBeat.o(190908);
                            return;
                        }
                        this.GDz.BTB.setVisibility(0);
                        this.GDz.wgG = audioCacheInfo;
                        d.b.a(this.GDz.wgr, d.c.BVl);
                        v d2 = this.GDz.wgF.d(audioCacheInfo);
                        if (d2 != null) {
                            this.GDz.wgL.setMusicPlayer(d2);
                        }
                        this.GDz.GDx = (long) audioCacheInfo.duration;
                        Iterator<T> it = this.GDz.wgJ.iterator();
                        while (it.hasNext()) {
                            it.next();
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
                        AppMethodBeat.o(190908);
                    }
                }

                @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.a
                public final void b(AudioCacheInfo audioCacheInfo) {
                    AppMethodBeat.i(190909);
                    p.h(audioCacheInfo, "info");
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("EDIT_VLOG_SEARCH_MUSIC_FINISH_PARCELABLE", audioCacheInfo);
                    this.GDz.wgr.a(d.c.BVX, bundle);
                    AppMethodBeat.o(190909);
                }

                @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.a
                public final void oR(boolean z) {
                    AppMethodBeat.i(190910);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("PARAM_EDIT_ORIGIN_VOICE_MUTE_BOOLEAN", z);
                    this.GDz.wgr.a(d.c.BVk, bundle);
                    AppMethodBeat.o(190910);
                }
            });
            this.wgL.setRecordCallback(new EditorAudioView.c(this) {
                /* class com.tencent.mm.plugin.vlog.ui.a.AnonymousClass3 */
                final /* synthetic */ a GDz;

                {
                    this.GDz = r1;
                }

                @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.c
                public final void Ih(long j2) {
                    AppMethodBeat.i(190911);
                    com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar = this.GDz.wgr;
                    d.c cVar = d.c.BWD;
                    Bundle bundle = new Bundle();
                    bundle.putLong("PARAM_1_LONG", j2);
                    dVar.a(cVar, bundle);
                    AppMethodBeat.o(190911);
                }

                @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.c
                public final void eLX() {
                    AppMethodBeat.i(190912);
                    d.b.a(this.GDz.wgr, d.c.BWE);
                    AppMethodBeat.o(190912);
                }

                @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.c
                public final void eLY() {
                    AppMethodBeat.i(190913);
                    Log.d("MicroMsg.EditAddMusicPlugin", "onStartRecording");
                    e.AbstractC1868e eVar = this.GDz.GDw;
                    if (eVar != null) {
                        eVar.resume();
                        AppMethodBeat.o(190913);
                        return;
                    }
                    AppMethodBeat.o(190913);
                }

                @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.c
                public final void eLZ() {
                    AppMethodBeat.i(190914);
                    e.AbstractC1868e eVar = this.GDz.GDw;
                    if (eVar != null) {
                        eVar.pause();
                        AppMethodBeat.o(190914);
                        return;
                    }
                    AppMethodBeat.o(190914);
                }

                @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.c
                public final void PN() {
                    AppMethodBeat.i(190915);
                    e.AbstractC1868e eVar = this.GDz.GDw;
                    if (eVar != null) {
                        eVar.pause();
                        AppMethodBeat.o(190915);
                        return;
                    }
                    AppMethodBeat.o(190915);
                }

                @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.c
                public final void eMa() {
                    AppMethodBeat.i(190916);
                    d.b.a(this.GDz.wgr, d.c.BWF);
                    AppMethodBeat.o(190916);
                }
            });
            AppMethodBeat.o(190941);
            return;
        }
        this.BTC.setVisibility(8);
        AppMethodBeat.o(190941);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    public final boolean fCv() {
        AppMethodBeat.i(190917);
        if (!this.wgL.getWithMusic()) {
            AppMethodBeat.o(190917);
            return true;
        }
        AppMethodBeat.o(190917);
        return false;
    }

    /* renamed from: com.tencent.mm.plugin.vlog.ui.a$a */
    public static final class C1857a {
        private C1857a() {
        }

        public /* synthetic */ C1857a(byte b2) {
            this();
        }
    }

    public final void fCw() {
        AppMethodBeat.i(190918);
        this.wgF.seekTo(0);
        Iterator<T> it = this.wgJ.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(190918);
    }

    public final void fCx() {
        AppMethodBeat.i(190919);
        this.wgL.setBackground(R.drawable.b1l);
        AppMethodBeat.o(190919);
    }

    public final void b(Integer num, Integer num2) {
        AppMethodBeat.i(190920);
        EditorAudioView.a(this.wgL, num, num2, Integer.valueOf((int) R.drawable.ax6), null, Integer.valueOf((int) R.raw.popvideo_post_selected_origin), null, null, null, null, null, null, null, true, 8144);
        ImageView imageView = this.BTB;
        Context context = this.parent.getContext();
        p.g(context, "parent.context");
        imageView.setImageDrawable(context.getResources().getDrawable(R.raw.popvideo_post_selected_origin));
        AppMethodBeat.o(190920);
    }

    public static /* synthetic */ void a(a aVar, com.tencent.mm.media.widget.camerarecordview.b.b bVar, RecordConfigProvider recordConfigProvider, boolean z) {
        boolean z2;
        boolean z3;
        AppMethodBeat.i(190921);
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
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_video_editor_lyrics_enable, 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            dVar.BNb = z2;
        } else if (valueOf != null && valueOf.intValue() == 1) {
            aVar.BTD.a(i.Chatting);
        } else if (valueOf != null && valueOf.intValue() == 3) {
            aVar.BTD.a(i.StoryComm);
            aVar.BTD.BNb = true;
            aVar.BTD.BNa = z4;
            aVar.BTD.BNe = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_visitor_enable, false);
        } else if (valueOf != null && valueOf.intValue() == 5) {
            aVar.BTD.a(i.WXGGame);
        } else if (valueOf != null && valueOf.intValue() == 11) {
            aVar.BTD.a(i.Finder);
            aVar.BTD.BNb = false;
            com.tencent.mm.plugin.recordvideo.b.d dVar2 = aVar.BTD;
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
            dVar2.BNc = z3;
            if (bVar.iqg > recordConfigProvider.BOv) {
                j2 = (long) recordConfigProvider.BOv;
            }
        }
        aVar.BTD.BNd = z;
        aVar.wgL.setPlayMusicWhenSearchFinish(true);
        EditorAudioView.a(aVar.wgL, bVar.iqd, bVar.iqm, (long) bVar.dvv, j2, z4, aVar.BTD, false, 64);
        AppMethodBeat.o(190921);
    }

    public final void setLocalAudioList(List<AudioCacheInfo> list) {
        AppMethodBeat.i(190922);
        p.h(list, "audioList");
        this.wgL.setLocalAudioList(list);
        AppMethodBeat.o(190922);
    }

    public final void fCy() {
        AppMethodBeat.i(190923);
        this.wgL.tw(false);
        AppMethodBeat.o(190923);
    }

    public final void eKP() {
        AppMethodBeat.i(190924);
        if (this.BTD.BNf == i.StoryComm && this.BTD.BNe) {
            this.wgL.setShow(true);
        }
        AppMethodBeat.o(190924);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(190925);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/MultiEditAddMusicPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        this.wgL.setShow(true);
        com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.aLu("KEY_CLICK_MUSIC_COUNT_INT");
        com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.VH(6);
        com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.VI(5);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/MultiEditAddMusicPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(190925);
    }

    public final void fCz() {
        AppMethodBeat.i(190926);
        this.wgL.setShow(true);
        AppMethodBeat.o(190926);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(190927);
        if (this.BTE) {
            this.BTC.setVisibility(i2);
        }
        AppMethodBeat.o(190927);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
        AppMethodBeat.i(190928);
        Log.i("MicroMsg.EditAddMusicPlugin", "pauseAudio");
        bdY();
        AppMethodBeat.o(190928);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
        AppMethodBeat.i(190929);
        reset();
        this.wgG = null;
        this.wgF.release();
        this.wgL.destroy();
        AppMethodBeat.o(190929);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
        AppMethodBeat.i(190930);
        onPause();
        AppMethodBeat.o(190930);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
        AppMethodBeat.i(190931);
        if (!this.BTF && this.wgL.getWithMusic()) {
            bdZ();
        }
        AppMethodBeat.o(190931);
    }

    public final void bdY() {
        AppMethodBeat.i(190932);
        Log.i("MicroMsg.EditAddMusicPlugin", "pauseMusic");
        this.wgF.pauseAudio();
        Iterator<T> it = this.wgJ.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(190932);
    }

    public final void bdZ() {
        AppMethodBeat.i(190933);
        Log.i("MicroMsg.EditAddMusicPlugin", "resumeMusic");
        this.wgF.eKR();
        Iterator<T> it = this.wgJ.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(190933);
    }

    public final void seekTo(long j2) {
        AppMethodBeat.i(190934);
        this.wgF.seekTo(j2);
        Iterator<T> it = this.wgJ.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(190934);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        boolean z;
        AppMethodBeat.i(190935);
        EditorAudioView editorAudioView = this.wgL;
        if (editorAudioView.bJw() && editorAudioView.Ccc) {
            editorAudioView.getCloseIcon().performClick();
            z = true;
        } else if (editorAudioView.bJw() && editorAudioView.Ccb == 1) {
            editorAudioView.VT(0);
            z = true;
        } else if (editorAudioView.bJw()) {
            editorAudioView.back();
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(190935);
            return true;
        }
        this.wgL.reset();
        c.a aVar = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
        com.tencent.mm.plugin.recordvideo.model.audio.c cVar = com.tencent.mm.plugin.recordvideo.model.audio.c.BPz;
        if (cVar != null) {
            cVar.eKf();
        }
        AppMethodBeat.o(190935);
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return "plugin_music";
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
        AppMethodBeat.i(190936);
        this.BTB.setVisibility(8);
        this.wgF.eKQ();
        AppMethodBeat.o(190936);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(190937);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        if (i2 == 84) {
            if (iArr[0] == 0) {
                this.wgL.tz(true);
                AppMethodBeat.o(190937);
                return;
            }
            this.wgL.tz(false);
        }
        AppMethodBeat.o(190937);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.d
    public final void a(ac acVar, long j2, boolean z) {
        float f2;
        AppMethodBeat.i(190938);
        if (acVar != null) {
            EditorAudioView editorAudioView = this.wgL;
            editorAudioView.CbW = acVar.Gez.getDurationMs();
            editorAudioView.eLV();
            MMEditorRecordButton recordControlButton = editorAudioView.getRecordControlButton();
            Float f3 = (Float) j.kv(editorAudioView.CbR);
            if (f3 != null) {
                f2 = f3.floatValue();
            } else {
                f2 = 0.0f;
            }
            recordControlButton.bi(f2);
            AppMethodBeat.o(190938);
            return;
        }
        AppMethodBeat.o(190938);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.c
    public final void a(e.AbstractC1868e eVar) {
        this.GDw = eVar;
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.c
    public final void onProgress(long j2) {
        AppMethodBeat.i(190939);
        EditorAudioView editorAudioView = this.wgL;
        Log.d(EditorAudioView.TAG, "onUpdateProgress:".concat(String.valueOf(j2)));
        editorAudioView.CbX = j2;
        if (editorAudioView.ipv && editorAudioView.CbX == 0) {
            Log.d(EditorAudioView.TAG, "onUpdateProgress, curTimeMs:" + editorAudioView.CbX + ", recordFinish!");
            EditorAudioView.c cVar = editorAudioView.Ccd;
            if (cVar != null) {
                cVar.PN();
            }
            editorAudioView.ipC = true;
            editorAudioView.getRecordControlButton().stopRecord();
            editorAudioView.getRecordControlButton().setTouchEnable(false);
        }
        if (editorAudioView.ipv && !editorAudioView.ipC) {
            editorAudioView.getSubProgressBar().aJ(new ArrayList<>(j.b((Collection) editorAudioView.CbR, (Object) Float.valueOf((((float) editorAudioView.CbX) * 100.0f) / ((float) editorAudioView.CbW)))));
            editorAudioView.getRecordControlButton().bi((((float) editorAudioView.CbX) * 100.0f) / ((float) editorAudioView.CbW));
            String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(((float) (editorAudioView.CbW - editorAudioView.CbX)) / 1000.0f)}, 1));
            p.g(format, "java.lang.String.format(this, *args)");
            TextView recordRemainTimeText = editorAudioView.getRecordRemainTimeText();
            p.g(recordRemainTimeText, "recordRemainTimeText");
            recordRemainTimeText.setText(editorAudioView.getContext().getString(R.string.hwi, format));
            TextView recordRemainTimeText2 = editorAudioView.getRecordRemainTimeText();
            p.g(recordRemainTimeText2, "recordRemainTimeText");
            recordRemainTimeText2.setVisibility(0);
        }
        AppMethodBeat.o(190939);
    }

    public final void VC(int i2) {
        AppMethodBeat.i(190940);
        this.BTA.setImageDrawable(ar.m(this.parent.getContext(), R.raw.icons_filled_sound, i2));
        AppMethodBeat.o(190940);
    }
}
