package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.b;
import com.tencent.mm.plugin.gif.c;
import com.tencent.mm.plugin.gif.d;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;

public class MMEmojiView extends MMAnimateView {
    protected int Kor;
    protected int Kos;
    private boolean Kot;
    private boolean Kou;
    private boolean Kov;
    private int mScreenWidth;
    protected EmojiInfo rfq;

    public MMEmojiView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
        AppMethodBeat.i(104709);
        init(context);
        AppMethodBeat.o(104709);
    }

    public MMEmojiView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(104710);
        this.Kot = false;
        this.Kou = false;
        this.Kov = false;
        init(context);
        AppMethodBeat.o(104710);
    }

    private void init(Context context) {
        AppMethodBeat.i(104711);
        this.Kor = context.getResources().getDimensionPixelSize(R.dimen.a3i);
        this.Kos = context.getResources().getDimensionPixelSize(R.dimen.a3g);
        this.mScreenWidth = a.jn(context);
        setAdjustViewBounds(true);
        setMaxWidth(this.Kor);
        setMaxHeight(this.Kor);
        setMinimumWidth(this.Kos);
        setMinimumHeight(this.Kos);
        AppMethodBeat.o(104711);
    }

    public final void b(EmojiInfo emojiInfo, String str) {
        b dVar;
        AppMethodBeat.i(104712);
        this.rfq = emojiInfo;
        String hYx = emojiInfo.hYx();
        if ((emojiInfo.field_reserved4 & EmojiInfo.Vll) != EmojiInfo.Vll) {
            hU(hYx, str);
            AppMethodBeat.o(104712);
        } else if (c.dXx().aBd(str) != null) {
            setImageDrawable(c.dXx().aBd(str));
            AppMethodBeat.o(104712);
        } else {
            EmojiInfo emojiInfo2 = this.rfq;
            byte[] a2 = ((PluginEmoji) g.ah(PluginEmoji.class)).getProvider().a(this.rfq);
            this.rfq = emojiInfo2;
            try {
                if (!Util.isNullOrNil(a2)) {
                    if (!Util.isNullOrNil(str)) {
                        setCacheKey(str);
                        dVar = c.dXx().s(getCacheKey(), a2);
                    } else {
                        if (!ImgUtil.isWXGF(a2) || !((PluginEmoji) g.ah(PluginEmoji.class)).getProvider().cFP()) {
                            Log.v("MicroMsg.emoji.MMEmojiView", "set with gif");
                            dVar = new d(a2);
                        } else {
                            dVar = new h(a2);
                            this.Kou = true;
                        }
                        if (!dVar.isRunning()) {
                            dVar.reset();
                        }
                    }
                    setImageDrawable(dVar);
                    AppMethodBeat.o(104712);
                    return;
                }
            } catch (MMGIFException e2) {
                a(e2);
                if (e2.getErrorCode() == 103) {
                    Log.d("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray D_GIF_ERR_NOT_GIF_FILE");
                    Bitmap decodeByteArray = BitmapUtil.decodeByteArray(a2);
                    if (decodeByteArray != null) {
                        decodeByteArray.setDensity(getEmojiDensity());
                        setImageBitmap(decodeByteArray);
                        AppMethodBeat.o(104712);
                        return;
                    }
                    Log.w("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", a2.toString());
                    if (this.rfq != null) {
                        this.rfq.hYj();
                        Log.i("MicroMsg.emoji.MMEmojiView", "delete file.");
                    }
                    init();
                    AppMethodBeat.o(104712);
                    return;
                }
                Log.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", e2.toString());
                if (this.rfq != null) {
                    this.rfq.hYj();
                    Log.i("MicroMsg.emoji.MMEmojiView", "delete file.");
                }
            } catch (IOException e3) {
                Log.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", e3.toString());
            } catch (NullPointerException e4) {
                Log.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", e4.toString());
            }
            if (this.rfq != null) {
                this.rfq.hYj();
                Log.i("MicroMsg.emoji.MMEmojiView", "delete file.");
            }
            init();
            AppMethodBeat.o(104712);
        }
    }

    @Override // android.support.v7.widget.AppCompatImageView
    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(104713);
        super.setImageDrawable(drawable);
        if (!(drawable == null || this.rfq == null)) {
            float f2 = 1.0f;
            if (drawable instanceof d) {
                f2 = ((d) drawable).getEmojiDensityScale();
            } else if (drawable instanceof h) {
                f2 = ((h) drawable).getEmojiDensityScale();
            } else if (!(drawable instanceof BitmapDrawable)) {
                AppMethodBeat.o(104713);
                return;
            }
            float intrinsicWidth = ((float) drawable.getIntrinsicWidth()) / f2;
            float intrinsicHeight = ((float) drawable.getIntrinsicHeight()) / f2;
            if (this.Kov && (this.rfq.field_width == 0 || this.rfq.field_height == 0)) {
                this.rfq.field_width = (int) intrinsicWidth;
                this.rfq.field_height = (int) intrinsicHeight;
                ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(this.rfq);
            }
        }
        AppMethodBeat.o(104713);
    }

    public void setIsMaxSizeLimit(boolean z) {
        AppMethodBeat.i(104714);
        this.Kot = z;
        if (z) {
            setAdjustViewBounds(true);
            setMaxWidth(this.Kor);
            setMaxHeight(this.Kor);
            AppMethodBeat.o(104714);
            return;
        }
        setMaxHeight(Integer.MAX_VALUE);
        setMaxHeight(Integer.MAX_VALUE);
        AppMethodBeat.o(104714);
    }

    public void setMaxSize(int i2) {
        this.Kor = i2;
    }

    public void setUpdateEmojiSize(boolean z) {
        this.Kov = z;
    }
}
