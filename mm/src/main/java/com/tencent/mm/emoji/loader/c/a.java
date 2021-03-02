package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.emoji.loader.c.d;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J5\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122#\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R+\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "cdnCallback", "com/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher$cdnCallback$1", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher$cdnCallback$1;", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "createCdnTask", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "fetch", "plugin-emojisdk_release"})
public final class a implements d {
    final String TAG = "MicroMsg.EmojiLoader.EmojiFetcher";
    private b<? super Boolean, x> callback;
    private e gVV;
    private final C0325a gVW = new C0325a(this);

    public a() {
        AppMethodBeat.i(105420);
        AppMethodBeat.o(105420);
    }

    public static final /* synthetic */ e a(a aVar) {
        AppMethodBeat.i(105421);
        e eVar = aVar.gVV;
        if (eVar == null) {
            p.btv("fetcherConfig");
        }
        AppMethodBeat.o(105421);
        return eVar;
    }

    @Override // com.tencent.mm.emoji.loader.c.d
    public final void a(e eVar, b<? super Boolean, x> bVar) {
        AppMethodBeat.i(105419);
        p.h(eVar, "fetcherConfig");
        this.gVV = eVar;
        this.callback = bVar;
        com.tencent.mm.an.b baQ = f.baQ();
        g gVar = new g();
        gVar.taskName = "task_EmojiCdnFetcher";
        e eVar2 = this.gVV;
        if (eVar2 == null) {
            p.btv("fetcherConfig");
        }
        gVar.field_authKey = eVar2.authKey;
        gVar.field_fileType = 19;
        StringBuilder append = new StringBuilder().append(d.a.auE());
        e eVar3 = this.gVV;
        if (eVar3 == null) {
            p.btv("fetcherConfig");
        }
        gVar.field_mediaId = append.append(eVar3.gWm.getMd5()).toString();
        e eVar4 = this.gVV;
        if (eVar4 == null) {
            p.btv("fetcherConfig");
        }
        gVar.field_fullpath = eVar4.path;
        e eVar5 = this.gVV;
        if (eVar5 == null) {
            p.btv("fetcherConfig");
        }
        gVar.gqB = eVar5.url;
        gVar.gqy = this.gVW;
        baQ.e(gVar);
        AppMethodBeat.o(105419);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0014"}, hxF = {"com/tencent/mm/emoji/loader/fetcher/EmojiCdnFetcher$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.loader.c.a$a  reason: collision with other inner class name */
    public static final class C0325a implements g.a {
        final /* synthetic */ a gVX;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C0325a(a aVar) {
            this.gVX = aVar;
        }

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, c cVar, com.tencent.mm.i.d dVar, boolean z) {
            b bVar;
            AppMethodBeat.i(105418);
            Log.i(this.gVX.TAG, "callback " + i2 + ' ' + cVar + ' ' + dVar);
            if (i2 == 0 && dVar != null && dVar.field_retCode == 0) {
                Log.i(this.gVX.TAG, "download " + a.a(this.gVX).gWm.getMd5() + " finish");
                b bVar2 = this.gVX.callback;
                if (bVar2 != null) {
                    bVar2.invoke(Boolean.TRUE);
                }
                AppMethodBeat.o(105418);
            } else {
                if (!((i2 == 0 && (dVar == null || dVar.field_retCode == 0)) || (bVar = this.gVX.callback) == null)) {
                    bVar.invoke(Boolean.FALSE);
                }
                AppMethodBeat.o(105418);
            }
            return 0;
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            return new byte[0];
        }
    }
}
