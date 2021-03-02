package com.tencent.mm.emoji.loader.d;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.emoji.loader.a.b;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.emoji.view.CoverEmojiStatusView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\fH\u0016¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/emoji/loader/request/EmojiCoverRequest;", "Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "Landroid/widget/ImageView;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/widget/ImageView;)V", "createTask", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "onLoad", "", "success", "", "start", "async", "plugin-emojisdk_release"})
public final class c extends j<ImageView> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(EmojiInfo emojiInfo, ImageView imageView) {
        super(emojiInfo, imageView);
        p.h(emojiInfo, "emojiInfo");
        p.h(imageView, "view");
        AppMethodBeat.i(105462);
        AppMethodBeat.o(105462);
    }

    @Override // com.tencent.mm.emoji.loader.d.i
    public final void start(boolean z) {
        ImageView imageView;
        WeakReference<V> weakReference;
        ImageView imageView2;
        AppMethodBeat.i(105459);
        b bVar = b.gVU;
        Bitmap EP = b.EP(this.gWm.getMd5());
        Log.d(d.TAG, "start: " + this.gWm.getMd5() + ", " + EP);
        if (EP != null) {
            dR(true);
            AppMethodBeat.o(105459);
            return;
        }
        WeakReference<V> weakReference2 = this.gWH;
        if (weakReference2 != null) {
            imageView = (ImageView) weakReference2.get();
        } else {
            imageView = null;
        }
        if (!((imageView instanceof CoverEmojiStatusView) || (weakReference = this.gWH) == null || (imageView2 = (ImageView) weakReference.get()) == null)) {
            imageView2.setImageDrawable(null);
        }
        dS(true);
        AppMethodBeat.o(105459);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.emoji.loader.d.i
    public final com.tencent.mm.emoji.loader.e.c auF() {
        AppMethodBeat.i(105460);
        e eVar = e.gVM;
        com.tencent.mm.emoji.loader.e.c d2 = e.d(this.gWm);
        AppMethodBeat.o(105460);
        return d2;
    }

    @Override // com.tencent.mm.emoji.loader.d.i, com.tencent.mm.emoji.loader.d.j
    public final void dR(boolean z) {
        AppMethodBeat.i(105461);
        super.dR(z);
        WeakReference<V> weakReference = this.gWH;
        ImageView imageView = weakReference != null ? (ImageView) weakReference.get() : null;
        b bVar = b.gVU;
        Bitmap EP = b.EP(this.gWm.getMd5());
        Log.d(d.TAG, "onLoad: " + this.gWm.getMd5() + ", " + EP);
        d.h(new a(z, EP, imageView));
        AppMethodBeat.o(105461);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ boolean $success;
        final /* synthetic */ Bitmap cKG;
        final /* synthetic */ ImageView gWz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(boolean z, Bitmap bitmap, ImageView imageView) {
            super(0);
            this.$success = z;
            this.cKG = bitmap;
            this.gWz = imageView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            ImageView imageView;
            AppMethodBeat.i(105458);
            if (!(!this.$success || this.cKG == null || (imageView = this.gWz) == null)) {
                imageView.setImageBitmap(this.cKG);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(105458);
            return xVar;
        }
    }
}
