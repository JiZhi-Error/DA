package com.tencent.mm.plugin.emojicapture.ui.capture;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ce;
import com.tencent.mm.plugin.appbrand.jsapi.cf;
import com.tencent.mm.plugin.emojicapture.ui.c;
import com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer;
import com.tencent.mm.plugin.emojicapture.ui.editor.EmojiEditorItemView;
import com.tencent.mm.plugin.emojicapture.ui.editor.text.FontAnimTextView;
import com.tencent.mm.sticker.f;
import com.tencent.mm.sticker.ui.view.CaptureStickerHint;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0006\u0010\u001e\u001a\u00020\tJ\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J\u0006\u0010%\u001a\u00020#J\u0006\u0010&\u001a\u00020#J\u0010\u0010'\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010\u0012J\u0010\u0010)\u001a\u00020#2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0006\u0010*\u001a\u00020#J\u001a\u0010+\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010\u001d2\b\u0010-\u001a\u0004\u0018\u00010\u001dR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureDecoration;", "Landroid/support/constraint/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionHint", "Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "editorRoot", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "emojiItemView", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EmojiEditorItemView;", "imitateEmoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "stickerInfo", "Lcom/tencent/mm/sticker/StickerPack;", "textHint", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/FontAnimTextView;", "validAreaView", "Landroid/view/View;", "getAttachEmoji", "getAttachEmojiMatrix", "Landroid/graphics/Matrix;", "getText", "", "getTextColor", "onApplyWindowInsets", "Landroid/view/WindowInsets;", "insets", "onRecordStart", "", "onRecordStop", "pause", "resume", "setImitateEmoji", "emojiInfo", "setStickerInfo", "showImitateEmoji", "showTextHint", "text", "colorString", "plugin-emojicapture_release"})
public final class CaptureDecoration extends ConstraintLayout {
    private f roL;
    public final EditorItemContainer rtj;
    public final FontAnimTextView rtk;
    private final CaptureStickerHint rtl;
    private EmojiEditorItemView rtm;
    private EmojiInfo rtn;
    private final View ruL;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CaptureDecoration(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(cf.CTRL_INDEX);
        View.inflate(context, R.layout.a1e, this);
        View findViewById = findViewById(R.id.byz);
        p.g(findViewById, "findViewById(R.id.emoji_…re_editor_item_container)");
        this.rtj = (EditorItemContainer) findViewById;
        View findViewById2 = findViewById(R.id.bzl);
        p.g(findViewById2, "findViewById(R.id.emoji_capture_text_hint)");
        this.rtk = (FontAnimTextView) findViewById2;
        View findViewById3 = findViewById(R.id.bzc);
        p.g(findViewById3, "findViewById(R.id.emoji_capture_sticker_hint)");
        this.rtl = (CaptureStickerHint) findViewById3;
        View findViewById4 = findViewById(R.id.bz4);
        p.g(findViewById4, "findViewById(R.id.emoji_capture_editor_valid_area)");
        this.ruL = findViewById4;
        this.rtj.setDeleteEnalbe(false);
        AppMethodBeat.o(cf.CTRL_INDEX);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CaptureDecoration(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(620);
        AppMethodBeat.o(620);
    }

    public final void setImitateEmoji(EmojiInfo emojiInfo) {
        this.rtn = emojiInfo;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        if ((!kotlin.g.b.p.j(r1, r0)) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setStickerInfo(com.tencent.mm.sticker.f r10) {
        /*
        // Method dump skipped, instructions count: 316
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureDecoration.setStickerInfo(com.tencent.mm.sticker.f):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/emojicapture/ui/capture/CaptureDecoration$showImitateEmoji$1$1"})
    static final class a implements Runnable {
        final /* synthetic */ EmojiInfo rto;
        final /* synthetic */ CaptureDecoration rtp;

        a(EmojiInfo emojiInfo, CaptureDecoration captureDecoration) {
            this.rto = emojiInfo;
            this.rtp = captureDecoration;
        }

        public final void run() {
            float f2;
            float f3;
            AppMethodBeat.i(613);
            if (this.rtp.rtm != null) {
                AppMethodBeat.o(613);
                return;
            }
            RectF validRect = this.rtp.rtj.getValidRect();
            EmojiEditorItemView emojiEditorItemView = new EmojiEditorItemView(this.rtp.getContext());
            emojiEditorItemView.setEmojiInfo(this.rto);
            emojiEditorItemView.resume();
            this.rtp.rtm = emojiEditorItemView;
            EditorItemContainer.a(this.rtp.rtj, emojiEditorItemView);
            Drawable drawable = emojiEditorItemView.getDrawable();
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                float width = validRect.width();
                float height = validRect.height();
                if (intrinsicWidth > intrinsicHeight) {
                    float f4 = width / 3.0f;
                    f2 = f4;
                    f3 = (((float) intrinsicHeight) * f4) / ((float) intrinsicWidth);
                } else {
                    float f5 = height / 3.0f;
                    f2 = (((float) intrinsicWidth) * f5) / ((float) intrinsicHeight);
                    f3 = f5;
                }
                emojiEditorItemView.getTouchMatrix().setPolyToPoly(new float[]{0.0f, 0.0f, (float) intrinsicWidth, (float) intrinsicHeight}, 0, new float[]{validRect.right - f2, validRect.bottom - f3, validRect.right, validRect.bottom}, 0, 2);
                Context context = this.rtp.getContext();
                p.g(context, "context");
                float dimension = context.getResources().getDimension(R.dimen.a1w);
                emojiEditorItemView.getTouchMatrix().postTranslate((-dimension) / 2.0f, (-dimension) / 2.0f);
                AppMethodBeat.o(613);
                return;
            }
            AppMethodBeat.o(613);
        }
    }

    public final String getText() {
        AppMethodBeat.i(615);
        CharSequence text = this.rtk.getText();
        if (text != null) {
            String obj = text.toString();
            AppMethodBeat.o(615);
            return obj;
        }
        AppMethodBeat.o(615);
        return null;
    }

    public final int getTextColor() {
        int i2;
        AppMethodBeat.i(616);
        int textColor = this.rtk.getTextColor();
        if (textColor != 0) {
            i2 = c.Go(textColor);
        } else {
            i2 = -1;
        }
        AppMethodBeat.o(616);
        return i2;
    }

    public final EmojiInfo getAttachEmoji() {
        return this.rtn;
    }

    public final Matrix getAttachEmojiMatrix() {
        T t;
        Matrix matrix;
        AppMethodBeat.i(617);
        Iterator<T> it = this.rtj.getAllItemViews().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t instanceof EmojiEditorItemView) {
                break;
            }
        }
        T t2 = !(t instanceof EmojiEditorItemView) ? null : t;
        if (t2 == null || (matrix = t2.getTouchMatrix()) == null) {
            matrix = new Matrix();
        }
        AppMethodBeat.o(617);
        return matrix;
    }

    public final void resume() {
        AppMethodBeat.i(ce.CTRL_INDEX);
        this.rtj.resume();
        this.rtk.refresh();
        AppMethodBeat.o(ce.CTRL_INDEX);
    }

    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        AppMethodBeat.i(258551);
        if (windowInsets == null) {
            WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
            p.g(onApplyWindowInsets, "super.onApplyWindowInsets(insets)");
            AppMethodBeat.o(258551);
            return onApplyWindowInsets;
        }
        ViewGroup.LayoutParams layoutParams = this.ruL.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.ag4) + windowInsets.getSystemWindowInsetTop();
            this.ruL.setLayoutParams(marginLayoutParams);
        }
        WindowInsets onApplyWindowInsets2 = super.onApplyWindowInsets(windowInsets);
        p.g(onApplyWindowInsets2, "super.onApplyWindowInsets(insets)");
        AppMethodBeat.o(258551);
        return onApplyWindowInsets2;
    }
}
