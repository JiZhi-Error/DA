package com.tencent.kinda.framework.widget.base;

import com.facebook.yoga.YogaNode;
import com.tencent.kinda.framework.widget.tools.FlexBoxAttr;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ViewBase {
    protected FlexBoxAttr flexAttr = new FlexBoxAttr(new FlexBoxAttr.IFlexBoxChange() {
        /* class com.tencent.kinda.framework.widget.base.ViewBase.AnonymousClass1 */

        @Override // com.tencent.kinda.framework.widget.tools.FlexBoxAttr.IFlexBoxChange
        public void onChange() {
            AppMethodBeat.i(19296);
            ViewBase.this.onFlexAttribute();
            AppMethodBeat.o(19296);
        }
    });

    public ViewBase() {
        AppMethodBeat.i(19297);
        AppMethodBeat.o(19297);
    }

    /* access modifiers changed from: protected */
    public void onFlexAttribute() {
    }

    public YogaNode node() {
        AppMethodBeat.i(19298);
        YogaNode node = this.flexAttr.node();
        AppMethodBeat.o(19298);
        return node;
    }
}
