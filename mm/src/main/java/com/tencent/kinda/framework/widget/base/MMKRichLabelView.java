package com.tencent.kinda.framework.widget.base;

import android.widget.TextView;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.KRichLabelView;
import com.tencent.kinda.gen.KText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class MMKRichLabelView extends MMKLabelView implements KRichLabelView {
    private MMKRichText richText;

    @Override // com.tencent.kinda.gen.KRichLabelView
    public void setRichText(KText kText) {
        AppMethodBeat.i(19103);
        if (kText != null && (kText instanceof MMKRichText)) {
            this.richText = (MMKRichText) kText;
            ((TextView) getView()).setText(this.richText.get());
            if (this.richText.hasLinkAndCanCallback) {
                ((TextView) getView()).setClickable(true);
            } else {
                ((TextView) getView()).setClickable(false);
            }
            Log.d("MMKRichLabelView", "setRichText: %s, raw color: %s, color: %s, colorHex: %s", this.richText.get().toString(), new StringBuilder().append(getTextColor()).toString(), Integer.valueOf(MMKViewUtil.argbColor(ColorUtil.getColorByMode(getTextColor(), ColorUtil.MMViewType.MMKRichLabelView))), Integer.toHexString(MMKViewUtil.argbColor(ColorUtil.getColorByModeNoCompat(getTextColor()))));
            setTextColor(getTextColor());
            notifyChanged();
        }
        AppMethodBeat.o(19103);
    }

    @Override // com.tencent.kinda.framework.widget.base.MMKLabelView, com.tencent.kinda.gen.KLabelView
    public void setTextColor(DynamicColor dynamicColor) {
        AppMethodBeat.i(19104);
        super.setTextColor(dynamicColor);
        Log.d("MMKRichLabelView", "setTextColor: " + Integer.toHexString(MMKViewUtil.argbColor(ColorUtil.getColorByMode(dynamicColor, ColorUtil.MMViewType.MMKRichLabelView))));
        ((TextView) getView()).setTextColor(MMKViewUtil.argbColor(ColorUtil.getColorByModeNoCompat(dynamicColor)));
        notifyChanged();
        AppMethodBeat.o(19104);
    }

    @Override // com.tencent.kinda.gen.KRichLabelView
    public KText getRichText() {
        return this.richText;
    }
}
