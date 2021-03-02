package com.tencent.mm.emoji.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "value", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "emojiInfo", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setEmojiInfo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "isHevc", "", "setImageBitmap", "", "bm", "Landroid/graphics/Bitmap;", "setMMGIFFileByteArray", "bytes", "", "plugin-emojisdk_release"})
public class BaseEmojiView extends MMAnimateView {
    private final String TAG;
    private EmojiInfo gWm;
    public boolean isHevc;

    public BaseEmojiView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.TAG = "MicroMsg.BaseEmojiView";
    }

    public BaseEmojiView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmojiInfo getEmojiInfo() {
        return this.gWm;
    }

    public void setEmojiInfo(EmojiInfo emojiInfo) {
        AppMethodBeat.i(105785);
        if (p.j(this.gWm, emojiInfo)) {
            AppMethodBeat.o(105785);
            return;
        }
        this.gWm = emojiInfo;
        if (emojiInfo != null) {
            if (emojiInfo.getGroup() == EmojiGroupInfo.VkO || emojiInfo.getGroup() == EmojiInfo.VkV || emojiInfo.getGroup() == EmojiInfo.VkU) {
                setImageBitmap(emojiInfo.A(getContext(), 300));
                AppMethodBeat.o(105785);
                return;
            } else if (emojiInfo.hYm()) {
                c(EmojiInfo.m37do(getContext(), emojiInfo.getName()), "");
                AppMethodBeat.o(105785);
                return;
            } else {
                a ah = g.ah(PluginEmoji.class);
                p.g(ah, "MMKernel.plugin(PluginEmoji::class.java)");
                setMMGIFFileByteArray(((PluginEmoji) ah).getProvider().a(getEmojiInfo()));
            }
        }
        AppMethodBeat.o(105785);
    }

    @Override // android.support.v7.widget.AppCompatImageView
    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(105786);
        if (bitmap != null) {
            bitmap.setDensity(320);
        }
        super.setImageBitmap(bitmap);
        AppMethodBeat.o(105786);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0042 A[Catch:{ MMGIFException -> 0x0061, IOException -> 0x00c9, NullPointerException -> 0x00db }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setMMGIFFileByteArray(byte[] r7) {
        /*
        // Method dump skipped, instructions count: 237
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.emoji.view.BaseEmojiView.setMMGIFFileByteArray(byte[]):void");
    }
}
