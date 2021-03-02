package com.tencent.mm.plugin.music.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.h;
import com.tencent.mm.ay.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.taskbar.api.c;
import com.tencent.mm.protocal.protobuf.cso;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u000f\u001a\u00020\bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0006\u0010\u0013\u001a\u00020\bR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/music/model/MusicPlayerMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/AbsMultiTaskHelper;", "()V", "ADD_HISTORY_DURATION_LIMIT", "", "getADD_HISTORY_DURATION_LIMIT", "()I", "fillMultiTaskData", "", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "shareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "extras", "Landroid/os/Bundle;", "onClose", "", "way", "ended", "reset", "Companion", "plugin-music_release"})
public final class k extends com.tencent.mm.plugin.multitask.b.a {
    private static final b AkG = new b();
    public static final a AkH = new a((byte) 0);
    private final int AkF = 10000;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/music/model/MusicPlayerMultiTaskHelper$Companion;", "", "()V", "TAG", "", "taskBarEventListener", "com/tencent/mm/plugin/music/model/MusicPlayerMultiTaskHelper$Companion$taskBarEventListener$1", "Lcom/tencent/mm/plugin/music/model/MusicPlayerMultiTaskHelper$Companion$taskBarEventListener$1;", "startListeningTaskBarEvent", "", "stopListeningTaskBarEvent", "plugin-music_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/music/model/MusicPlayerMultiTaskHelper$Companion$taskBarEventListener$1", "Lcom/tencent/mm/plugin/taskbar/api/ITaskBarViewService$ITaskBarEventListener;", "onTaskBarItemClicked", "", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "onTaskBarItemExposed", "onTaskBarItemRemoved", "plugin-music_release"})
    public static final class b implements c.a {
        b() {
        }

        @Override // com.tencent.mm.plugin.taskbar.api.c.a
        public final void a(MultiTaskInfo multiTaskInfo) {
            AppMethodBeat.i(219982);
            p.h(multiTaskInfo, "info");
            AppMethodBeat.o(219982);
        }

        @Override // com.tencent.mm.plugin.taskbar.api.c.a
        public final void b(MultiTaskInfo multiTaskInfo) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            AppMethodBeat.i(219983);
            p.h(multiTaskInfo, "info");
            if (!((aj) g.ah(aj.class)).canEnterMvAndShowToast()) {
                AppMethodBeat.o(219983);
                return;
            }
            cso cso = new cso();
            try {
                cso.parseFrom(multiTaskInfo.field_data);
                com.tencent.mm.ay.a.c(i.a(cso.musicType, cso.Djf, cso.name, cso.lDR, cso.lDS, cso.Mxy, cso.Mxz, cso.dSF, cso.MxA, cso.MxB, cso.MxC, cso.appId, h.a(cso.dSF, cso.jfy)));
                cst cst = new cst();
                com.tencent.mm.plugin.comm.a aVar = com.tencent.mm.plugin.comm.a.qCo;
                cst.sGQ = com.tencent.mm.plugin.comm.a.cAK();
                cst.MxI = 86;
                cst.scene = 7;
                Intent intent = new Intent();
                css css = cso.jfy;
                intent.putExtra("key_scene", 12);
                intent.putExtra("key_mv_feed_id", css.Ktn);
                intent.putExtra("key_mv_nonce_id", css.Kto);
                intent.putExtra("key_mv_cover_url", css.Ktp);
                intent.putExtra("key_mv_poster", css.Ktq);
                if (css == null || (str = css.BPc) == null) {
                    str = "";
                }
                intent.putExtra("key_mv_song_name", str);
                if (css == null || (str2 = css.songLyric) == null) {
                    str2 = "";
                }
                intent.putExtra("key_mv_song_lyric", str2);
                if (css == null || (str3 = css.singerName) == null) {
                    str3 = "";
                }
                intent.putExtra("key_mv_singer_name", str3);
                if (css == null || (str4 = css.albumName) == null) {
                    str4 = "";
                }
                intent.putExtra("key_mv_album_name", str4);
                if (css == null || (str5 = css.musicGenre) == null) {
                    str5 = "";
                }
                intent.putExtra("key_mv_music_genre", str5);
                if (css == null || (str6 = String.valueOf(css.issueDate)) == null) {
                    str6 = "";
                }
                intent.putExtra("key_mv_issue_date", str6);
                if (css == null || (str7 = css.EsK) == null) {
                    str7 = "";
                }
                intent.putExtra("key_mv_album_cover_url", str7);
                if (css == null || (str8 = css.identification) == null) {
                    str8 = "";
                }
                intent.putExtra("key_mv_identification", str8);
                if (css == null || (str9 = css.extraInfo) == null) {
                    str9 = "";
                }
                intent.putExtra("key_mv_extra_info", str9);
                intent.putExtra("key_mv_music_duration", css != null ? css.Alz : 0);
                if (css == null || (str10 = css.jfz) == null) {
                    str10 = "";
                }
                intent.putExtra("key_mv_thumb_path", str10);
                intent.putExtra("key_mv_report_data", cst.toByteArray());
                intent.setFlags(268435456);
                com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "mv", ".ui.MusicMvMainUI", intent);
                AppMethodBeat.o(219983);
            } catch (Throwable th) {
                Log.e("MicroMsg.MusicPlayerMultiTaskHelper", "MusicMultiTaskData parse failed");
                AppMethodBeat.o(219983);
            }
        }

        @Override // com.tencent.mm.plugin.taskbar.api.c.a
        public final void c(MultiTaskInfo multiTaskInfo) {
            AppMethodBeat.i(219984);
            p.h(multiTaskInfo, "info");
            AppMethodBeat.o(219984);
        }
    }

    static {
        AppMethodBeat.i(219986);
        AppMethodBeat.o(219986);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean O(int i2, boolean z) {
        AppMethodBeat.i(219985);
        com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
        p.g(euj, "MusicPlayerManager.Instance()");
        d etW = euj.etW();
        int etn = etW != null ? etW.etn() : 0;
        Log.i("MicroMsg.MusicPlayerMultiTaskHelper", "onClose ".concat(String.valueOf(etn)));
        if (this.Abp == null) {
            AppMethodBeat.o(219985);
        } else {
            if (etn > this.AkF) {
                Log.i("MicroMsg.MusicPlayerMultiTaskHelper", "add historyTaskInfo");
                ai(null);
            } else {
                c(null, false);
            }
            this.Abp = null;
            AppMethodBeat.o(219985);
        }
        return true;
    }

    public static final void euA() {
        AppMethodBeat.i(219987);
        c cVar = (c) g.af(c.class);
        if (cVar != null) {
            cVar.a(6, AkG);
            AppMethodBeat.o(219987);
            return;
        }
        AppMethodBeat.o(219987);
    }

    public static final void euB() {
        AppMethodBeat.i(219988);
        c cVar = (c) g.af(c.class);
        if (cVar != null) {
            cVar.b(6, AkG);
            AppMethodBeat.o(219988);
            return;
        }
        AppMethodBeat.o(219988);
    }
}
