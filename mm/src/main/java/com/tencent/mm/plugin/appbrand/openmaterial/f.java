package com.tencent.mm.plugin.appbrand.openmaterial;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002\u001a\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0002\u001a\u0014\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"ELLIPSIS_NORMAL", "", "GROUP_ID_OPEN_MATERIAL", "", "MAX_MENU_ITEM_COUNT", "TAG", "getFirstLineEndPos", "textPaint", "Landroid/text/TextPaint;", "text", "", "lineWidth", "getRawFunctionName2Show", "Lcom/tencent/mm/plugin/appbrand/openmaterial/RawFunctionName2Show;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialModel;", "setText", "", "Landroid/widget/TextView;", "rawFunctionName2Show", "plugin-appbrand-integration_release"})
public final class f {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ TextView nlf;
        final /* synthetic */ l nlg;

        a(TextView textView, l lVar) {
            this.nlf = textView;
            this.nlg = lVar;
        }

        public final void run() {
            int lineEnd;
            String sb;
            AppMethodBeat.i(229125);
            int width = (this.nlf.getWidth() - this.nlf.getPaddingLeft()) - this.nlf.getPaddingRight();
            Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "setText, lineWidth: ".concat(String.valueOf(width)));
            TextPaint paint = this.nlf.getPaint();
            p.g(paint, "paint");
            StaticLayout staticLayout = new StaticLayout(this.nlg.line1, paint, width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            if (staticLayout.getLineCount() <= 0) {
                Log.w("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "getFirstLineEndPos, lineCount(" + staticLayout.getLineCount() + ") is illegal");
                lineEnd = 0;
            } else {
                lineEnd = staticLayout.getLineEnd(0);
            }
            Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "setText, firstLineEndPos: ".concat(String.valueOf(lineEnd)));
            int length = this.nlg.line1.length();
            if (lineEnd <= 0 || length < lineEnd) {
                this.nlf.setText(this.nlg.nll);
                AppMethodBeat.o(229125);
                return;
            }
            if (lineEnd == this.nlg.line1.length()) {
                sb = this.nlg.line1;
            } else {
                StringBuilder sb2 = new StringBuilder();
                String str = this.nlg.line1;
                int i2 = lineEnd - 1;
                if (str == null) {
                    t tVar = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(229125);
                    throw tVar;
                }
                String substring = str.substring(0, i2);
                p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb = sb2.append(substring).append("…").toString();
            }
            String str2 = sb + "\n" + this.nlg.line2;
            Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "setText, functionName2Show: ".concat(String.valueOf(str2)));
            this.nlf.setText(str2);
            AppMethodBeat.o(229125);
        }
    }
}
