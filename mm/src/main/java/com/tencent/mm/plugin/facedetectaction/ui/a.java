package com.tencent.mm.plugin.facedetectaction.ui;

import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.ui.ao;

public final class a extends p {
    private boolean sYU = true;
    private int sYV = 0;
    private boolean sYW = true;
    private AbstractC1041a sYX;
    private String text = "";
    private int textColor = 0;

    /* renamed from: com.tencent.mm.plugin.facedetectaction.ui.a$a  reason: collision with other inner class name */
    public interface AbstractC1041a {
        void arG(String str);
    }

    public a(String str, int i2, int i3, AbstractC1041a aVar) {
        super(i2, i3);
        this.textColor = i2;
        this.sYV = i3;
        this.sYW = true;
        this.text = str;
        this.sYX = aVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.p
    public final void setColor(int i2, int i3) {
        AppMethodBeat.i(186415);
        super.setColor(i2, i3);
        this.textColor = i2;
        this.sYV = i3;
        AppMethodBeat.o(186415);
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.p
    public final void updateDrawState(TextPaint textPaint) {
        AppMethodBeat.i(186416);
        super.updateDrawState(textPaint);
        if (this.sYW) {
            ao.a(textPaint, 0.8f);
        }
        AppMethodBeat.o(186416);
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.p
    public final void onClick(View view) {
        AppMethodBeat.i(186417);
        if (this.sYU && this.sYX != null) {
            this.sYX.arG(this.text);
        }
        AppMethodBeat.o(186417);
    }
}
