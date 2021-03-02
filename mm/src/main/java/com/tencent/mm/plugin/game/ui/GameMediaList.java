package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameMediaList extends LinearLayout implements View.OnClickListener {
    String appId = "";
    Context mContext;
    int sQn = -1;
    int xSP = 0;
    private int xUq;
    private LinkedList<String> xUr;

    public static class a {
        public String dkZ;
        public int type;
        public String url;
    }

    public GameMediaList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setItemLayout(int i2) {
        this.xUq = i2;
    }

    public void setMediaList(LinkedList<a> linkedList) {
        AppMethodBeat.i(42255);
        if (linkedList == null || linkedList.size() == 0) {
            setVisibility(8);
            AppMethodBeat.o(42255);
            return;
        }
        this.xUr = new LinkedList<>();
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            a aVar = linkedList.get(i2);
            if (!Util.isNullOrNil(aVar.url) && aVar.type == 0) {
                this.xUr.add(aVar.url);
            }
        }
        removeAllViews();
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        for (int i3 = 0; i3 < linkedList.size(); i3++) {
            a aVar2 = linkedList.get(i3);
            if (!Util.isNullOrNil(aVar2.dkZ)) {
                View inflate = layoutInflater.inflate(this.xUq, (ViewGroup) this, false);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.fc1);
                com.tencent.mm.av.a.a bcV = q.bcV();
                String str = aVar2.dkZ;
                c.a aVar3 = new c.a();
                aVar3.jbe = true;
                bcV.a(str, imageView, aVar3.bdv());
                if (aVar2.type == 1) {
                    inflate.findViewById(R.id.fbu).setVisibility(0);
                }
                addView(inflate);
                imageView.setTag(aVar2);
                imageView.setOnClickListener(this);
            }
        }
        setVisibility(0);
        AppMethodBeat.o(42255);
    }

    public void onClick(View view) {
        AppMethodBeat.i(42256);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameMediaList", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            Log.i("MicroMsg.GameMediaList", "Invalid tag");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMediaList", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42256);
            return;
        }
        a aVar = (a) view.getTag();
        switch (aVar.type) {
            case 0:
                int indexOf = this.xUr.indexOf(aVar.url);
                if (indexOf < 0) {
                    indexOf = 0;
                }
                Intent intent = new Intent(getContext(), GameGalleryUI.class);
                String[] strArr = new String[this.xUr.size()];
                this.xUr.toArray(strArr);
                intent.putExtra("URLS", strArr);
                intent.putExtra("CURRENT", indexOf);
                intent.putExtra("REPORT_APPID", this.appId);
                intent.putExtra("REPORT_SCENE", this.sQn);
                intent.putExtra("SOURCE_SCENE", this.xSP);
                Context context = getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/game/ui/GameMediaList", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/game/ui/GameMediaList", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                break;
            case 1:
                com.tencent.mm.plugin.game.e.c.aQ(getContext(), aVar.url);
                f.a(this.mContext, this.sQn, TXLiteAVCode.WARNING_SPEAKER_DEVICE_EMPTY, 1, 13, this.appId, this.xSP, null);
                break;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameMediaList", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42256);
    }
}
