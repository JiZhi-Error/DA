package com.tencent.mm.emoji.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\b\u0016\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0002+,B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020%H\u0014J\u0010\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020\u0014H\u0016J\b\u0010)\u001a\u00020%H\u0016J\u000e\u0010*\u001a\u00020%2\u0006\u0010\u0019\u001a\u00020\nR(\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006-"}, hxF = {"Lcom/tencent/mm/emoji/view/EmojiStatusView;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "emojiInfo", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "gameUseCover", "", "getGameUseCover", "()Z", "setGameUseCover", "(Z)V", "status", "getStatus", "()I", "setStatus", "(I)V", "statusListener", "Lcom/tencent/mm/emoji/view/EmojiStatusView$StatusListener;", "getStatusListener", "()Lcom/tencent/mm/emoji/view/EmojiStatusView$StatusListener;", "setStatusListener", "(Lcom/tencent/mm/emoji/view/EmojiStatusView$StatusListener;)V", "destroy", "", "onDetachedFromWindow", "onResult", "success", "reload", "setStatusNotify", "Companion", "StatusListener", "plugin-emojisdk_release"})
public class EmojiStatusView extends BaseEmojiView implements i.a {
    public static final a heh = new a((byte) 0);
    private EmojiInfo gWm;
    private boolean hea;
    private b heg;
    private int status;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/emoji/view/EmojiStatusView$StatusListener;", "", "onStatus", "", "status", "", "plugin-emojisdk_release"})
    public interface b {
        void po(int i2);
    }

    static {
        AppMethodBeat.i(105804);
        AppMethodBeat.o(105804);
    }

    public EmojiStatusView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.hea = true;
    }

    public EmojiStatusView(Context context) {
        this(context, null);
    }

    public EmojiStatusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/emoji/view/EmojiStatusView$Companion;", "", "()V", "StatusFail", "", "StatusLoading", "StatusSuccess", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i2) {
        this.status = i2;
    }

    public final b getStatusListener() {
        return this.heg;
    }

    public final void setStatusListener(b bVar) {
        this.heg = bVar;
    }

    public final boolean getGameUseCover() {
        return this.hea;
    }

    public final void setGameUseCover(boolean z) {
        this.hea = z;
    }

    @Override // com.tencent.mm.emoji.view.BaseEmojiView
    public EmojiInfo getEmojiInfo() {
        return this.gWm;
    }

    @Override // com.tencent.mm.emoji.view.BaseEmojiView
    public void setEmojiInfo(EmojiInfo emojiInfo) {
        AppMethodBeat.i(105799);
        this.gWm = emojiInfo;
        reload();
        AppMethodBeat.o(105799);
    }

    public void reload() {
        AppMethodBeat.i(105800);
        EmojiInfo emojiInfo = getEmojiInfo();
        if (emojiInfo != null) {
            Log.i("MicroMsg.EmojiStatusView", "reload: " + emojiInfo.getMd5());
            if (!this.hea || !(emojiInfo.getGroup() == EmojiGroupInfo.VkO || emojiInfo.getGroup() == EmojiInfo.VkV || emojiInfo.getGroup() == EmojiInfo.VkU)) {
                setStatusNotify(0);
                e eVar = e.gVM;
                e.a(emojiInfo, this, this);
                AppMethodBeat.o(105800);
                return;
            }
            setStatusNotify(1);
            setImageBitmap(emojiInfo.A(getContext(), 300));
            AppMethodBeat.o(105800);
            return;
        }
        Log.i("MicroMsg.EmojiStatusView", "reload: emojiInfo is null");
        e eVar2 = e.gVM;
        e.cl(this);
        AppMethodBeat.o(105800);
    }

    public final void setStatusNotify(int i2) {
        AppMethodBeat.i(105801);
        this.status = i2;
        b bVar = this.heg;
        if (bVar != null) {
            bVar.po(i2);
            AppMethodBeat.o(105801);
            return;
        }
        AppMethodBeat.o(105801);
    }

    @Override // com.tencent.mm.emoji.loader.d.i.a
    public final void dQ(boolean z) {
        AppMethodBeat.i(105802);
        setStatusNotify(z ? 1 : -1);
        AppMethodBeat.o(105802);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(105803);
        Log.i("MicroMsg.EmojiStatusView", "destroy: ".concat(String.valueOf(this)));
        e eVar = e.gVM;
        e.cl(this);
        this.heg = null;
        super.onDetachedFromWindow();
        AppMethodBeat.o(105803);
    }
}