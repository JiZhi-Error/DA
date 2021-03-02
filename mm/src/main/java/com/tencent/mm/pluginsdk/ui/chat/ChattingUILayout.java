package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import java.util.ArrayList;
import java.util.List;

public class ChattingUILayout extends BasePanelKeybordLayout {
    public ChattingUILayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mm.ui.BasePanelKeybordLayout
    public List<View> getPanelView() {
        AppMethodBeat.i(31742);
        ArrayList arrayList = new ArrayList();
        AppMethodBeat.o(31742);
        return arrayList;
    }
}
