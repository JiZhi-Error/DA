package com.tencent.mm.emoji.loader.d;

import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u0000 \u0018*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003\u0017\u0018\u0019B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0014J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0012\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u0013H\u0014J\u0012\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u0013H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/emoji/loader/request/Request;", "T", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "task", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "getTask", "()Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "setTask", "(Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;)V", "cancel", "", "createTask", "onLoad", "success", "", "reload", "async", "start", "Callback", "Companion", "StateCallback", "plugin-emojisdk_release"})
public abstract class i<T> {
    private static final int gWE = 1;
    private static final int gWF = -1;
    public static final b gWG = new b((byte) 0);
    private com.tencent.mm.emoji.loader.e.c gWD;
    final EmojiInfo gWm;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "", "onResult", "", "success", "", "plugin-emojisdk_release"})
    public interface a {
        void dQ(boolean z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J'\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00018\u0001H&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;", "T", "", "onState", "", "state", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "result", "(ILcom/tencent/mm/storage/emotion/EmojiInfo;Ljava/lang/Object;)V", "plugin-emojisdk_release"})
    public interface c<T> {
        void aY(T t);
    }

    public abstract void dR(boolean z);

    public i(EmojiInfo emojiInfo) {
        p.h(emojiInfo, "emojiInfo");
        this.gWm = emojiInfo;
    }

    public void start(boolean z) {
        dS(z);
    }

    /* access modifiers changed from: private */
    public void dS(boolean z) {
        com.tencent.mm.emoji.loader.e.c cVar = this.gWD;
        if (cVar != null) {
            cVar.d(this);
        }
        this.gWD = auF();
        com.tencent.mm.emoji.loader.e.c cVar2 = this.gWD;
        if (cVar2 != null) {
            cVar2.c(this);
        }
        com.tencent.mm.emoji.loader.e.c cVar3 = this.gWD;
        if (cVar3 != null) {
            cVar3.start(z);
        }
    }

    /* access modifiers changed from: protected */
    public com.tencent.mm.emoji.loader.e.c auF() {
        e eVar = e.gVM;
        return e.c(this.gWm);
    }

    public void cancel() {
        com.tencent.mm.emoji.loader.e.c cVar = this.gWD;
        if (cVar != null) {
            cVar.d(this);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0007¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/emoji/loader/request/Request$Companion;", "", "()V", "StateFailed", "", "StateFailed$annotations", "getStateFailed", "()I", "StateLoading", "StateLoading$annotations", "getStateLoading", "StateSuccess", "StateSuccess$annotations", "getStateSuccess", "plugin-emojisdk_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }
}
