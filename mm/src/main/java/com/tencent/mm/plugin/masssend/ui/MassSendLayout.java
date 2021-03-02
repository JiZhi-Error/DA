package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import java.util.ArrayList;
import java.util.List;

public class MassSendLayout extends BasePanelKeybordLayout {
    private View qdl;

    public MassSendLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MassSendLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setPanel(View view) {
        this.qdl = view;
    }

    @Override // com.tencent.mm.ui.BasePanelKeybordLayout
    public List<View> getPanelView() {
        AppMethodBeat.i(26445);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.qdl);
        AppMethodBeat.o(26445);
        return arrayList;
    }
}
