package com.tencent.kinda.framework.widget.base;

import android.app.Activity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KActionSheet;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.List;

public class KindaActionSheetImpl implements KActionSheet {
    private List<VoidCallback> buttonCallbacks = new ArrayList();
    private List<String> buttonTitles = new ArrayList();
    private int mDestructiveIndex = -1;
    private e sheet;
    private String title;

    public KindaActionSheetImpl() {
        AppMethodBeat.i(18832);
        AppMethodBeat.o(18832);
    }

    @Override // com.tencent.kinda.gen.KActionSheet
    public void setTitle(String str) {
        this.title = str;
    }

    @Override // com.tencent.kinda.gen.KActionSheet
    public void setCancelButtonTitle(String str) {
    }

    @Override // com.tencent.kinda.gen.KActionSheet
    public void addButtonImpl(String str, VoidCallback voidCallback) {
        AppMethodBeat.i(18833);
        this.buttonTitles.add(str);
        this.buttonCallbacks.add(voidCallback);
        AppMethodBeat.o(18833);
    }

    @Override // com.tencent.kinda.gen.KActionSheet
    public void show() {
        AppMethodBeat.i(18834);
        final Activity topOrUIPageFragmentActivity = KindaContext.getTopOrUIPageFragmentActivity();
        if (topOrUIPageFragmentActivity != null) {
            boolean z = this.title != null;
            this.sheet = new e(topOrUIPageFragmentActivity, 1, z);
            if (z) {
                View inflate = aa.jQ(topOrUIPageFragmentActivity).inflate(R.layout.b7r, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.iqz);
                textView.setText(this.title);
                textView.setTextSize(14.0f);
                textView.setGravity(17);
                this.sheet.V(inflate, false);
            }
            this.sheet.HLX = new o.f() {
                /* class com.tencent.kinda.framework.widget.base.KindaActionSheetImpl.AnonymousClass1 */

                @Override // com.tencent.mm.ui.base.o.f
                public void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(18830);
                    int i2 = 0;
                    for (String str : KindaActionSheetImpl.this.buttonTitles) {
                        if (KindaActionSheetImpl.this.mDestructiveIndex < 0 || KindaActionSheetImpl.this.mDestructiveIndex != i2) {
                            mVar.add(0, i2, 0, str);
                        } else {
                            mVar.a(i2, topOrUIPageFragmentActivity.getResources().getColor(R.color.Red), str);
                        }
                        i2++;
                    }
                    AppMethodBeat.o(18830);
                }
            };
            this.sheet.HLY = new o.g() {
                /* class com.tencent.kinda.framework.widget.base.KindaActionSheetImpl.AnonymousClass2 */

                @Override // com.tencent.mm.ui.base.o.g
                public void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(18831);
                    if (i2 < KindaActionSheetImpl.this.buttonCallbacks.size()) {
                        ((VoidCallback) KindaActionSheetImpl.this.buttonCallbacks.get(i2)).call();
                    }
                    AppMethodBeat.o(18831);
                }
            };
            this.sheet.dGm();
        }
        AppMethodBeat.o(18834);
    }

    @Override // com.tencent.kinda.gen.KActionSheet
    public void setDestructiveIndex(int i2) {
        this.mDestructiveIndex = i2;
    }
}
