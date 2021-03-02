package com.tencent.mm.plugin.emojicapture.ui.editor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.p.x;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.emojicapture.c.c;
import com.tencent.mm.plugin.emojicapture.e.b;
import com.tencent.mm.plugin.gif.d;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0006\u0010\u001b\u001a\u00020\u0013J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u001dH\u0016J\u0012\u0010&\u001a\u00020\u00112\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0018\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EmojiEditorItemView;", "Lcom/tencent/mm/emoji/view/EmojiStatusView;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorItemContract$IPresenter;", "applyTouchMatrix", "", "m", "Landroid/graphics/Matrix;", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "getItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "getTouchMatrix", "handleRemove", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setEditing", "editing", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setValidArea", "bounds", "Landroid/graphics/RectF;", "radius", "", "plugin-emojicapture_release"})
public final class EmojiEditorItemView extends EmojiStatusView implements c.b {
    private final String TAG;
    final c.a rvc;

    public EmojiEditorItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(e.CTRL_INDEX);
        this.TAG = "MicroMsg.EmojiEditorItemView";
        this.rvc = new b(this);
        AppMethodBeat.o(e.CTRL_INDEX);
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.g
    public final a cJO() {
        return null;
    }

    public EmojiEditorItemView(Context context) {
        this(context, null);
    }

    public EmojiEditorItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.editor.a
    public final void a(RectF rectF, float f2) {
        AppMethodBeat.i(769);
        p.h(rectF, "bounds");
        this.rvc.a(rectF, f2);
        AppMethodBeat.o(769);
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.editor.a
    public final void setEditing(boolean z) {
        AppMethodBeat.i(770);
        this.rvc.setEditing(z);
        AppMethodBeat.o(770);
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.editor.a
    public final boolean cJP() {
        return false;
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.c.b
    public final EditorItemContainer getItemContainer() {
        AppMethodBeat.i(771);
        ViewParent parent = getParent();
        p.g(parent, "parent");
        if (parent.getParent() instanceof EditorItemContainer) {
            ViewParent parent2 = getParent();
            p.g(parent2, "parent");
            ViewParent parent3 = parent2.getParent();
            if (parent3 == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer");
                AppMethodBeat.o(771);
                throw tVar;
            }
            EditorItemContainer editorItemContainer = (EditorItemContainer) parent3;
            AppMethodBeat.o(771);
            return editorItemContainer;
        }
        AppMethodBeat.o(771);
        return null;
    }

    @Override // android.support.v7.widget.AppCompatImageView
    public final void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(x.CTRL_INDEX);
        super.setImageDrawable(drawable);
        if (drawable != null) {
            this.rvc.fF(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        AppMethodBeat.o(x.CTRL_INDEX);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(h.CTRL_INDEX);
        p.h(motionEvent, "event");
        boolean R = this.rvc.R(motionEvent);
        AppMethodBeat.o(h.CTRL_INDEX);
        return R;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(774);
        p.h(canvas, "canvas");
        canvas.save();
        this.rvc.q(canvas);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.draw(canvas);
        }
        canvas.restore();
        this.rvc.r(canvas);
        AppMethodBeat.o(774);
    }

    public final Matrix getTouchMatrix() {
        AppMethodBeat.i(775);
        Matrix matrix = this.rvc.getTouchTracker().gT;
        AppMethodBeat.o(775);
        return matrix;
    }

    @Override // com.tencent.mm.plugin.recordvideo.ui.editor.item.g
    public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix matrix) {
        AppMethodBeat.i(256448);
        if (getEmojiInfo() == null) {
            AppMethodBeat.o(256448);
            return null;
        } else if (getDrawable() instanceof BitmapDrawable) {
            Drawable drawable = getDrawable();
            if (drawable == null) {
                t tVar = new t("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
                AppMethodBeat.o(256448);
                throw tVar;
            }
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Matrix matrix2 = new Matrix();
            matrix2.set(this.rvc.getTouchTracker().gT);
            if (matrix != null) {
                matrix2.postConcat(matrix);
            }
            com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c cVar = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(bitmap, matrix2);
            AppMethodBeat.o(256448);
            return cVar;
        } else {
            float f2 = 1.0f;
            if (getDrawable() instanceof d) {
                Drawable drawable2 = getDrawable();
                if (drawable2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
                    AppMethodBeat.o(256448);
                    throw tVar2;
                }
                f2 = ((d) drawable2).getEmojiDensityScale();
            } else if (getDrawable() instanceof com.tencent.mm.plugin.gif.h) {
                Drawable drawable3 = getDrawable();
                if (drawable3 == null) {
                    t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
                    AppMethodBeat.o(256448);
                    throw tVar3;
                }
                f2 = ((com.tencent.mm.plugin.gif.h) drawable3).getEmojiDensityScale();
            }
            Matrix matrix3 = new Matrix();
            matrix3.setScale(f2, f2);
            matrix3.postConcat(this.rvc.getTouchTracker().gT);
            if (matrix != null) {
                matrix3.postConcat(matrix);
            }
            EmojiInfo emojiInfo = getEmojiInfo();
            if (emojiInfo == null) {
                p.hyc();
            }
            com.tencent.mm.plugin.recordvideo.ui.editor.item.a.e eVar = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.e(emojiInfo, matrix3);
            AppMethodBeat.o(256448);
            return eVar;
        }
    }
}
