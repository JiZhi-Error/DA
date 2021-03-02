package com.tencent.mm.plugin.emoji.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Util;

public class MMCopiableTextView extends EditText implements View.OnLongClickListener {
    private final String TAG = "MicroMsg.MMCopiableTextView";
    private int owQ;
    private int rnu;

    public MMCopiableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(109429);
        init();
        AppMethodBeat.o(109429);
    }

    public MMCopiableTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(109430);
        init();
        AppMethodBeat.o(109430);
    }

    private void init() {
        AppMethodBeat.i(109431);
        setOnLongClickListener(this);
        setLongClickable(true);
        AppMethodBeat.o(109431);
    }

    /* access modifiers changed from: protected */
    public void onCreateContextMenu(ContextMenu contextMenu) {
    }

    /* access modifiers changed from: protected */
    public boolean getDefaultEditable() {
        return false;
    }

    public boolean onLongClick(View view) {
        AppMethodBeat.i(109432);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/emoji/ui/widget/MMCopiableTextView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
        String obj = getEditableText().toString();
        if (!Util.isNullOrNil(obj) && this.owQ > 0 && this.rnu > 0 && this.rnu > this.owQ) {
            ClipboardHelper.setText(obj.substring(this.owQ, this.rnu).trim());
            Toast.makeText(getContext(), (int) R.string.ta, 0).show();
        }
        a.a(false, (Object) this, "com/tencent/mm/plugin/emoji/ui/widget/MMCopiableTextView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(109432);
        return false;
    }

    public void setStartIndex(int i2) {
        this.owQ = i2;
    }

    public void setEndIndex(int i2) {
        this.rnu = i2;
    }
}
