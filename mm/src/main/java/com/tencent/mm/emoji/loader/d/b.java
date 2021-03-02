package com.tencent.mm.emoji.loader.d;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.emoji.loader.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/emoji/loader/request/EmojiCoverBitmapRequest;", "Lcom/tencent/mm/emoji/loader/request/Request;", "Landroid/graphics/Bitmap;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;)V", "TAG", "", "createTask", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "onLoad", "", "success", "", "start", "async", "plugin-emojisdk_release"})
public final class b extends i<Bitmap> {
    private final String TAG = "MicroMsg.EmojiCoverBitmapRequest";
    private final i.c<Bitmap> gWx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(EmojiInfo emojiInfo, i.c<Bitmap> cVar) {
        super(emojiInfo);
        p.h(emojiInfo, "emojiInfo");
        AppMethodBeat.i(105457);
        this.gWx = cVar;
        AppMethodBeat.o(105457);
    }

    @Override // com.tencent.mm.emoji.loader.d.i
    public final void start(boolean z) {
        AppMethodBeat.i(105454);
        com.tencent.mm.emoji.loader.a.b bVar = com.tencent.mm.emoji.loader.a.b.gVU;
        Bitmap EP = com.tencent.mm.emoji.loader.a.b.EP(this.gWm.getMd5());
        Log.d(this.TAG, "start: " + this.gWm.getMd5() + ", " + EP);
        if (EP != null) {
            dR(true);
            AppMethodBeat.o(105454);
            return;
        }
        i.c<Bitmap> cVar = this.gWx;
        if (cVar != null) {
            cVar.aY(null);
        }
        dS(true);
        AppMethodBeat.o(105454);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.emoji.loader.d.i
    public final c auF() {
        AppMethodBeat.i(105455);
        e eVar = e.gVM;
        c d2 = e.d(this.gWm);
        AppMethodBeat.o(105455);
        return d2;
    }

    @Override // com.tencent.mm.emoji.loader.d.i
    public final void dR(boolean z) {
        AppMethodBeat.i(105456);
        com.tencent.mm.emoji.loader.a.b bVar = com.tencent.mm.emoji.loader.a.b.gVU;
        d.h(new a(this, z, com.tencent.mm.emoji.loader.a.b.EP(this.gWm.getMd5())));
        AppMethodBeat.o(105456);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ boolean $success;
        final /* synthetic */ Bitmap cKG;
        final /* synthetic */ b gWy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(b bVar, boolean z, Bitmap bitmap) {
            super(0);
            this.gWy = bVar;
            this.$success = z;
            this.cKG = bitmap;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(105453);
            if (!this.$success || this.cKG == null) {
                i.c cVar = this.gWy.gWx;
                if (cVar != null) {
                    i.b bVar = i.gWG;
                    int unused = i.gWF;
                    cVar.aY(null);
                }
            } else {
                i.c cVar2 = this.gWy.gWx;
                if (cVar2 != null) {
                    i.b bVar2 = i.gWG;
                    int unused2 = i.gWE;
                    cVar2.aY(this.cKG);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(105453);
            return xVar;
        }
    }
}
