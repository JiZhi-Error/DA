package com.tencent.mm.plugin.textstatus.f.h;

import com.tencent.f.h;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.f.h.b;
import com.tencent.mm.plugin.textstatus.f.h.e;
import com.tencent.mm.plugin.textstatus.g.g;
import com.tencent.mm.plugin.textstatus.g.v;
import com.tencent.mm.plugin.textstatus.j.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/upload/UploadPackHelper;", "", "()V", "TAG", "", "THUMB_DEFAULT_SCALE", "", "commit", "", "postInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "getSendThumbnailPath", "thumbnailPath", "tips", "plugin-textstatus_release"})
public final class d {
    public static final d Gaa = new d();

    static {
        AppMethodBeat.i(216325);
        AppMethodBeat.o(216325);
    }

    private d() {
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ v Gab;

        a(v vVar) {
            this.Gab = vVar;
        }

        public final void run() {
            int i2;
            AppMethodBeat.i(216323);
            e eVar = e.Ggj;
            Log.i("MicroMsg.TxtStatus.UploadPackHelper", String.valueOf(e.c(this.Gab)));
            if (this.Gab.Gba <= 0) {
                f fVar = f.FXJ;
                String ceA = com.tencent.mm.plugin.auth.a.a.ceA();
                p.g(ceA, "Account.username()");
                g gVar = this.Gab.GaU;
                p.g(gVar, "postInfo.textStatusExtInfo");
                this.Gab.Gba = f.a(ceA, "", gVar, 3);
                if (this.Gab.GaW) {
                    this.Gab.Gbb = true;
                }
                c cVar = c.FZX;
                c.a(this.Gab);
            }
            com.tencent.mm.plugin.textstatus.j.a aVar = com.tencent.mm.plugin.textstatus.j.a.GfU;
            String ceA2 = com.tencent.mm.plugin.auth.a.a.ceA();
            p.g(ceA2, "Account.username()");
            s.deleteFile(com.tencent.mm.plugin.textstatus.j.a.lf("thumb", ceA2));
            com.tencent.mm.plugin.textstatus.j.a aVar2 = com.tencent.mm.plugin.textstatus.j.a.GfU;
            String ceA3 = com.tencent.mm.plugin.auth.a.a.ceA();
            p.g(ceA3, "Account.username()");
            s.deleteFile(com.tencent.mm.plugin.textstatus.j.a.lf("image", ceA3));
            com.tencent.mm.plugin.textstatus.j.a aVar3 = com.tencent.mm.plugin.textstatus.j.a.GfU;
            String ceA4 = com.tencent.mm.plugin.auth.a.a.ceA();
            p.g(ceA4, "Account.username()");
            s.deleteFile(com.tencent.mm.plugin.textstatus.j.a.aTo(ceA4));
            if (this.Gab.GaW) {
                new a(this.Gab).fwb();
                AppMethodBeat.o(216323);
                return;
            }
            g gVar2 = this.Gab.GaU;
            if (gVar2 == null || gVar2.Gat != 1) {
                String str = this.Gab.thumbPath;
                com.tencent.mm.plugin.textstatus.j.a aVar4 = com.tencent.mm.plugin.textstatus.j.a.GfU;
                String ceA5 = com.tencent.mm.plugin.auth.a.a.ceA();
                p.g(ceA5, "Account.username()");
                s.nw(str, com.tencent.mm.plugin.textstatus.j.a.lf("thumb", ceA5));
                String str2 = this.Gab.GaX;
                com.tencent.mm.plugin.textstatus.j.a aVar5 = com.tencent.mm.plugin.textstatus.j.a.GfU;
                String ceA6 = com.tencent.mm.plugin.auth.a.a.ceA();
                p.g(ceA6, "Account.username()");
                s.nw(str2, com.tencent.mm.plugin.textstatus.j.a.aTo(ceA6));
            } else {
                String str3 = this.Gab.thumbPath;
                com.tencent.mm.plugin.textstatus.j.a aVar6 = com.tencent.mm.plugin.textstatus.j.a.GfU;
                String ceA7 = com.tencent.mm.plugin.auth.a.a.ceA();
                p.g(ceA7, "Account.username()");
                s.nw(str3, com.tencent.mm.plugin.textstatus.j.a.lf("thumb", ceA7));
                String str4 = this.Gab.GaX;
                com.tencent.mm.plugin.textstatus.j.a aVar7 = com.tencent.mm.plugin.textstatus.j.a.GfU;
                String ceA8 = com.tencent.mm.plugin.auth.a.a.ceA();
                p.g(ceA8, "Account.username()");
                s.nw(str4, com.tencent.mm.plugin.textstatus.j.a.lf("image", ceA8));
            }
            e eVar2 = new e(this.Gab);
            e.b bVar = new e.b(eVar2, System.currentTimeMillis());
            b bVar2 = b.FZU;
            g gVar3 = eVar2.FYQ.GaU;
            if (gVar3 != null) {
                i2 = gVar3.Gat;
            } else {
                i2 = 1;
            }
            String str5 = eVar2.FYQ.GaX;
            String str6 = eVar2.FYQ.thumbPath;
            e.b bVar3 = bVar;
            p.h(bVar3, "uploadCallback");
            String str7 = str5;
            if (!(str7 == null || n.aL(str7))) {
                String str8 = str6;
                if (!(str8 == null || n.aL(str8))) {
                    b.C1823b bVar4 = new b.C1823b(bVar3);
                    if (i2 == 2) {
                        Log.d("MicroMsg.TxtStatus.TextStatusUploader", "isVideo");
                        b.C1823b bVar5 = bVar4;
                        com.tencent.mm.i.g gVar4 = new com.tencent.mm.i.g();
                        gVar4.taskName = "task_TextStatusUploader_1";
                        gVar4.gqy = bVar5;
                        gVar4.field_mediaId = MD5Util.getMD5String(str5);
                        gVar4.field_fullpath = str5;
                        gVar4.field_thumbpath = str6;
                        gVar4.field_talker = "";
                        gVar4.field_needStorage = true;
                        gVar4.field_fileType = CdnLogic.kMediaTypeAppVideo;
                        gVar4.field_appType = 256;
                        gVar4.gqP = 8;
                        gVar4.field_bzScene = 2;
                        gVar4.gqC = 600;
                        gVar4.gqD = 1200;
                        gVar4.field_priority = com.tencent.mm.i.a.gpM;
                        com.tencent.mm.an.f.baQ().f(gVar4);
                        AppMethodBeat.o(216323);
                        return;
                    }
                    Log.d("MicroMsg.TxtStatus.TextStatusUploader", "uploadImage");
                    com.tencent.mm.i.g gVar5 = new com.tencent.mm.i.g();
                    gVar5.taskName = "task_TextStatusUploader_2";
                    gVar5.gqy = bVar4;
                    gVar5.field_mediaId = MD5Util.getMD5String(str5);
                    gVar5.field_fullpath = str5;
                    gVar5.field_thumbpath = str6;
                    gVar5.field_talker = "";
                    gVar5.field_needStorage = true;
                    gVar5.field_fileType = CdnLogic.kMediaTypeAppImageStorage;
                    gVar5.field_appType = 256;
                    gVar5.field_bzScene = 2;
                    gVar5.gqC = 60;
                    gVar5.gqD = 300;
                    gVar5.field_priority = com.tencent.mm.i.a.gpM;
                    com.tencent.mm.an.f.baQ().f(gVar5);
                    AppMethodBeat.o(216323);
                    return;
                }
            }
            AppMethodBeat.o(216323);
        }
    }

    public static void b(v vVar) {
        AppMethodBeat.i(216324);
        p.h(vVar, "postInfo");
        h.RTc.b(new a(vVar), "MicroMsg.TxtStatus.UploadPackHelper");
        AppMethodBeat.o(216324);
    }
}
