package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public class GameLibraryCategoriesView extends LinearLayout implements View.OnClickListener {
    private int hC;
    private Context mContext;
    private LinearLayout tmh;
    private int vXu;
    private int xGR;

    public static class a {
        public String kVZ;
        public int position;
        public String xTA;
        public int xTz;
        public String xjU;
    }

    public GameLibraryCategoriesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42198);
        super.onFinishInflate();
        this.tmh = (LinearLayout) findViewById(R.id.dgt);
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        this.hC = (width * 100) / 750;
        this.vXu = (width - (this.hC * 6)) / 14;
        this.tmh.setPadding(this.vXu, com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12), this.vXu, com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12));
        AppMethodBeat.o(42198);
    }

    public void setSourceScene(int i2) {
        this.xGR = i2;
    }

    public void setData(LinkedList<a> linkedList) {
        AppMethodBeat.i(42199);
        if (linkedList == null || linkedList.size() == 0) {
            Log.e("MicroMsg.GameLibraryCategoriesView", "No categories");
            setVisibility(8);
            AppMethodBeat.o(42199);
            return;
        }
        setVisibility(0);
        this.tmh.removeAllViews();
        Iterator<a> it = linkedList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            ImageView imageView = new ImageView(this.mContext);
            ImageView.ScaleType scaleType = ImageView.ScaleType.MATRIX;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            com.tencent.mm.av.a.a bcV = q.bcV();
            String str = next.kVZ;
            c.a aVar = new c.a();
            aVar.jbe = true;
            bcV.a(str, imageView, aVar.bdv());
            linearLayout.addView(imageView, this.hC, this.hC);
            TextView textView = new TextView(this.mContext);
            textView.setText(next.xjU);
            textView.setTextSize(1, 14.0f);
            textView.setTextColor(getResources().getColor(R.color.uj));
            textView.setSingleLine(true);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setGravity(17);
            textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            textView.setPadding(0, com.tencent.mm.cb.a.fromDPToPix(this.mContext, 6), 0, 0);
            linearLayout.addView(textView);
            linearLayout.setTag(next);
            linearLayout.setOnClickListener(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(this.vXu, 0, this.vXu, 0);
            this.tmh.addView(linearLayout, layoutParams);
        }
        AppMethodBeat.o(42199);
    }

    public void onClick(View view) {
        AppMethodBeat.i(42200);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameLibraryCategoriesView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (!(view.getTag() instanceof a)) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameLibraryCategoriesView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42200);
            return;
        }
        a aVar = (a) view.getTag();
        int i2 = 7;
        if (!Util.isNullOrNil(aVar.xTA)) {
            com.tencent.mm.plugin.game.e.c.aQ(this.mContext, aVar.xTA);
        } else {
            Intent intent = new Intent(this.mContext, GameCategoryUI.class);
            intent.putExtra("extra_type", 1);
            intent.putExtra("extra_category_id", aVar.xTz);
            intent.putExtra("extra_category_name", aVar.xjU);
            intent.putExtra("game_report_from_scene", aVar.xTz + 100);
            Context context = this.mContext;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/game/ui/GameLibraryCategoriesView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/game/ui/GameLibraryCategoriesView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            i2 = 6;
        }
        f.a(this.mContext, 11, aVar.xTz + 100, aVar.position, i2, this.xGR, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameLibraryCategoriesView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42200);
    }
}
