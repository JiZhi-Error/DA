package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.je;
import com.tencent.mm.plugin.story.f.g;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "call", "", "checkRemuxVideo", "", "filePath", "", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "doUploadStory", "uniqueId", "Companion", "plugin-story_release"})
public final class e extends com.tencent.mm.loader.g.c {
    public static final a FqK = new a((byte) 0);
    private static final String TAG = TAG;
    private j Fqr;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        public static final b FqL = new b();

        static {
            AppMethodBeat.i(119131);
            AppMethodBeat.o(119131);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        public static final c FqM = new c();

        static {
            AppMethodBeat.i(119132);
            AppMethodBeat.o(119132);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    public e(j jVar) {
        p.h(jVar, "storyInfo");
        AppMethodBeat.i(119136);
        this.Fqr = jVar;
        AppMethodBeat.o(119136);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/story/model/upload/UploadTask$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119137);
        AppMethodBeat.o(119137);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x015b, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.getInt(((com.tencent.mm.plugin.zero.b.a) r3).aqJ().getValue("StoryCheckSendVideoBitrateExceed"), 0) == 1) goto L_0x015d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0346  */
    @Override // com.tencent.mm.loader.g.c
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void call() {
        /*
        // Method dump skipped, instructions count: 1196
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.f.g.e.call():void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/story/model/upload/UploadTask$doUploadStory$sightUpload$1", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;", "onSightUpLoadEnd", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", "isOk", "", "upload", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload;", "plugin-story_release"})
    public static final class d implements g.a {
        final /* synthetic */ e FqN;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(e eVar) {
            this.FqN = eVar;
        }

        @Override // com.tencent.mm.plugin.story.f.g.a
        public final void a(int i2, boolean z, g gVar) {
            AppMethodBeat.i(119133);
            p.h(gVar, "upload");
            h hVar = h.FuH;
            h.fqs().rt((long) i2);
            h hVar2 = h.FuH;
            je fqs = h.fqs();
            long currentTimeMillis = System.currentTimeMillis();
            h hVar3 = h.FuH;
            fqs.rs(currentTimeMillis - h.fqs().agP());
            h hVar4 = h.FuH;
            h.fqt();
            if (z) {
                this.FqN.a(com.tencent.mm.loader.g.j.OK);
                AppMethodBeat.o(119133);
                return;
            }
            this.FqN.a(com.tencent.mm.loader.g.j.Fail);
            AppMethodBeat.o(119133);
        }
    }

    @Override // com.tencent.mm.loader.g.c
    public final String auK() {
        AppMethodBeat.i(119135);
        String valueOf = String.valueOf((int) this.Fqr.systemRowid);
        AppMethodBeat.o(119135);
        return valueOf;
    }
}
