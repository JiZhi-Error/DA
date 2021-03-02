package com.tencent.mm.emoji.a;

import android.graphics.Paint;
import android.graphics.PointF;
import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/emoji/egg/ChattingViewProvider;", "", "getItemTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "itemView", "Landroid/view/View;", "getParentView", "getViewByMsgId", "msgId", "", "Companion", "plugin-emojisdk_release"})
public interface a {
    public static final C0316a gUT = C0316a.gUU;

    MMNeat7extView ck(View view);

    View zh(long j2);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/emoji/egg/ChattingViewProvider$Companion;", "", "()V", "getEmojiCenter", "Landroid/graphics/PointF;", "textView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.a.a$a  reason: collision with other inner class name */
    public static final class C0316a {
        static final /* synthetic */ C0316a gUU = new C0316a();

        static {
            AppMethodBeat.i(199869);
            AppMethodBeat.o(199869);
        }

        private C0316a() {
        }

        public static PointF a(MMNeat7extView mMNeat7extView) {
            AppMethodBeat.i(199868);
            p.h(mMNeat7extView, "textView");
            com.tencent.neattextview.textview.layout.a layout = mMNeat7extView.getLayout();
            if (layout != null) {
                float lineRight = layout.getLineRight(0);
                float lineWidth = layout.getLineWidth(0);
                int lineBaseline = layout.getLineBaseline(0);
                float paddingStart = (lineRight - (lineWidth / 2.0f)) + ((float) mMNeat7extView.getPaddingStart());
                TextPaint paint = mMNeat7extView.getPaint();
                p.g(paint, "textView.paint");
                Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                float f2 = (float) lineBaseline;
                PointF pointF = new PointF(paddingStart, ((float) mMNeat7extView.getPaddingTop()) + f2 + (((float) (fontMetricsInt.ascent + fontMetricsInt.descent)) / 2.0f));
                AppMethodBeat.o(199868);
                return pointF;
            }
            PointF pointF2 = new PointF(0.0f, 0.0f);
            AppMethodBeat.o(199868);
            return pointF2;
        }
    }
}
