package com.tencent.mm.emoji.loader.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;

public abstract class j<V extends View> extends i<Drawable> {
    private static final int gWI = R.id.c0b;
    public static final a gWJ = new a((byte) 0);
    WeakReference<V> gWH;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(EmojiInfo emojiInfo, V v) {
        super(emojiInfo);
        p.h(emojiInfo, "emojiInfo");
        p.h(v, "view");
        this.gWH = new WeakReference<>(v);
        i iVar = (i) v.getTag(gWI);
        if (iVar != null) {
            iVar.cancel();
        }
        v.setTag(gWI, this);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.emoji.loader.d.i
    public void dR(boolean z) {
        V v;
        WeakReference<V> weakReference = this.gWH;
        if (weakReference != null) {
            v = weakReference.get();
        } else {
            v = null;
        }
        if (v != null) {
            v.setTag(gWI, null);
        }
    }

    @Override // com.tencent.mm.emoji.loader.d.i
    public void cancel() {
        V v;
        super.cancel();
        WeakReference<V> weakReference = this.gWH;
        if (weakReference != null) {
            v = weakReference.get();
        } else {
            v = null;
        }
        if (v != null) {
            v.setTag(gWI, null);
        }
        this.gWH = null;
    }
}
