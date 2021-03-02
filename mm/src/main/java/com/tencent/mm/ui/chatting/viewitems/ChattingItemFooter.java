package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.k;
import com.tencent.mm.al.w;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;

public class ChattingItemFooter extends LinearLayout implements View.OnClickListener {
    private static final int[] PNQ = {R.drawable.mx, R.drawable.mx, R.drawable.mz, R.drawable.my};
    private static final int[] PNR = {R.drawable.aqd, R.drawable.aqe, R.drawable.aqg, R.drawable.aqf};
    private Context mContext;
    private LayoutInflater mInflater;
    private String mRa;

    public ChattingItemFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(37299);
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        AppMethodBeat.o(37299);
    }

    private void c(k kVar) {
        AppMethodBeat.i(37300);
        bg.azz().a(new w(this.mRa, kVar.getInfo()), 0);
        AppMethodBeat.o(37300);
    }

    public void onClick(View view) {
        AppMethodBeat.i(37301);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Object tag = view.getTag();
        if (!(tag instanceof k)) {
            a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37301);
            return;
        }
        k kVar = (k) tag;
        switch (kVar.type) {
            case 1:
                Log.d("ChattingItemFooter", "get latest message");
                kVar.state = k.iOp;
                c(kVar);
                break;
            case 2:
                Log.d("ChattingItemFooter", "start webview url");
                kVar.state = k.iOp;
                c(kVar);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", kVar.value);
                intent.putExtra("showShare", false);
                intent.putExtra("geta8key_username", this.mRa);
                intent.putExtra("key_enable_teen_mode_check", true);
                c.b(this.mContext, "webview", ".ui.tools.WebViewUI", intent);
                break;
        }
        a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37301);
    }
}
