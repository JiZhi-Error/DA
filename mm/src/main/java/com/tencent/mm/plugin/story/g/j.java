package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.recordvideo.e.c;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.story.e.b;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/story/presenter/StoryDataProtoUtil;", "", "()V", "TAG", "", "signStoryDataMix", "", ch.COL_LOCALID, "", "mixVideoPath", "mixThumbPath", "signStoryDataMixEnable", "storyEditorData", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "signStoryDataMixError", "", "signStoryDataMixTime", "plugin-story_release"})
public final class j {
    public static final j FsI = new j();

    static {
        AppMethodBeat.i(119325);
        AppMethodBeat.o(119325);
    }

    private j() {
    }

    public static void e(long j2, String str, String str2) {
        float f2;
        edt edt;
        AppMethodBeat.i(119323);
        p.h(str, "mixVideoPath");
        p.h(str2, "mixThumbPath");
        Log.d("MicroMsg.Media.StoryDataProtoUtil", "signStoryDataMix localId:" + j2 + " mixVideoPath:" + str + " mixThumbPath:" + str2);
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        com.tencent.mm.plugin.story.i.j aba = j.b.foc().aba((int) j2);
        if (aba != null) {
            int i2 = aba.field_localFlag;
            a.d dVar = a.d.FvM;
            aba.field_localFlag = i2 & (a.d.fro() ^ -1);
            aba.setPostWaiting();
            q.a aVar = q.FmO;
            edt edt2 = new edt();
            StringBuilder sb = new StringBuilder();
            b.a aVar2 = b.FlA;
            StringBuilder append = sb.append(b.Flx);
            String sb2 = new StringBuilder().append(cl.aWz()).append('-').append(Util.currentTicks()).toString();
            Charset charset = d.UTF_8;
            if (sb2 == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(119323);
                throw tVar;
            }
            byte[] bytes = sb2.getBytes(charset);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            edt2.Id = append.append(g.getMessageDigest(bytes)).toString();
            com.tencent.mm.plugin.story.f.l lVar = com.tencent.mm.plugin.story.f.l.FmK;
            String aRW = com.tencent.mm.plugin.story.f.l.aRW(edt2.Id);
            com.tencent.mm.plugin.story.f.l lVar2 = com.tencent.mm.plugin.story.f.l.FmK;
            String aRV = com.tencent.mm.plugin.story.f.l.aRV(edt2.Id);
            com.tencent.mm.plugin.story.f.l lVar3 = com.tencent.mm.plugin.story.f.l.FmK;
            com.tencent.mm.plugin.story.f.l.aLP(aRW);
            com.tencent.mm.plugin.story.f.l lVar4 = com.tencent.mm.plugin.story.f.l.FmK;
            com.tencent.mm.plugin.story.f.l.aLP(aRV);
            com.tencent.mm.plugin.story.f.l lVar5 = com.tencent.mm.plugin.story.f.l.FmK;
            com.tencent.mm.plugin.story.f.l.aRX(aRW);
            com.tencent.mm.plugin.story.f.l lVar6 = com.tencent.mm.plugin.story.f.l.FmK;
            com.tencent.mm.plugin.story.f.l.aRX(aRV);
            long nw = s.nw(str, aRW);
            long nw2 = s.nw(str2, aRV);
            Log.i("MicroMsg.Media.StoryDataProtoUtil", "copy video from " + str + " to " + aRW + ", ret:" + nw);
            Log.i("MicroMsg.Media.StoryDataProtoUtil", "copy thumb from " + str2 + " to " + aRV + ", ret:" + nw2);
            boolean a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_clear_story_tmp_file, true);
            if (a2 && nw >= 0) {
                c cVar = c.Cic;
                c.aLG(str);
            }
            if (a2 && nw2 >= 0) {
                c cVar2 = c.Cic;
                c.aLG(str2);
            }
            com.tencent.mm.plugin.sight.base.a aNx = e.aNx(aRW);
            if (aNx != null) {
                f2 = ((float) aNx.videoDuration) / 1000.0f;
                edt = edt2;
            } else {
                f2 = 0.0f;
                edt = edt2;
            }
            edt.Ned = f2;
            eek frG = aba.frG();
            if (frG.NeB.LoV.size() == 0) {
                frG.NeB.LoV.add(edt2);
            } else {
                frG.NeB.LoV.set(0, edt2);
            }
            aba.b(frG);
            j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
            Log.i("MicroMsg.Media.StoryDataProtoUtil", "update mix storyInfo " + j2 + " newVideoPath:" + aRW + "  newThumbPath:" + aRV + " ret:" + j.b.foc().a((int) j2, aba));
            j.b bVar3 = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.foi().checkPost();
            AppMethodBeat.o(119323);
            return;
        }
        AppMethodBeat.o(119323);
    }

    public static void aaQ(int i2) {
        AppMethodBeat.i(119324);
        Log.i("MicroMsg.Media.StoryDataProtoUtil", "signStoryDataMixError ".concat(String.valueOf(i2)));
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        com.tencent.mm.plugin.story.i.j aba = j.b.foc().aba(i2);
        if (aba != null) {
            aba.setItemDie();
            j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.foc().a(i2, aba);
        }
        AppMethodBeat.o(119324);
    }
}
