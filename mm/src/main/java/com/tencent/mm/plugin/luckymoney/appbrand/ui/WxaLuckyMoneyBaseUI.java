package com.tencent.mm.plugin.luckymoney.appbrand.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.d;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.WxaLuckyMoneyDetailUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyCompleteUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.c;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.b;
import com.tencent.mm.plugin.luckymoney.ui.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public abstract class WxaLuckyMoneyBaseUI extends MMActivity {
    private c yPO = null;
    private int yPP = 4095;
    private final SparseArray<d.a> yPQ = new SparseArray<>();
    private final Class[][] yPR = {new Class[]{b.class, WxaLuckyMoneyReceiveUI.class}, new Class[]{c.class, WxaLuckyMoneyPrepareUI.class}, new Class[]{com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b.class, WxaLuckyMoneyDetailUI.class}, new Class[]{com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.b.class, WxaLuckyMoneyCompleteUI.class}};

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.yPO = new c(this);
        this.yPO.ziK = 1;
        c cVar = this.yPO;
        MMActivity mMActivity = cVar.qdG;
        int i2 = cVar.ziK;
        k.a aVar = new k.a();
        Resources resources = mMActivity.getResources();
        switch (i2) {
            case 1:
                aVar.ziM = new ColorDrawable(resources.getColor(R.color.yd));
                aVar.oAk = resources.getColor(R.color.ye);
                aVar.ziN = resources.getColor(R.color.yl);
                aVar.ziO = resources.getColor(R.color.yl);
                aVar.ziP = R.drawable.aep;
                aVar.olA = resources.getColor(R.color.ys);
                break;
            default:
                aVar.ziM = resources.getDrawable(R.drawable.cbq);
                aVar.oAk = -1;
                aVar.ziO = resources.getColor(R.color.z_);
                aVar.olA = resources.getColor(R.color.y7);
                break;
        }
        if (cVar.qdG.getSupportActionBar() != null) {
            if (aVar.ziM != null) {
                cVar.qdG.getSupportActionBar().setBackgroundDrawable(aVar.ziM);
            }
            View customView = cVar.qdG.getSupportActionBar().getCustomView();
            if (customView != null) {
                View findViewById = customView.findViewById(R.id.brt);
                if (!(findViewById == null || aVar.oAk == 0)) {
                    findViewById.setBackgroundColor(aVar.oAk);
                }
                TextView textView = (TextView) customView.findViewById(16908308);
                if (!(textView == null || aVar.ziN == 0)) {
                    textView.setTextColor(aVar.ziN);
                }
                TextView textView2 = (TextView) customView.findViewById(16908309);
                if (!(textView2 == null || aVar.ziO == 0)) {
                    textView2.setTextColor(aVar.ziO);
                }
                ImageView imageView = (ImageView) customView.findViewById(R.id.ei);
                if (!(imageView == null || aVar.ziP == 0)) {
                    imageView.setImageResource(aVar.ziP);
                }
            }
            if (aVar.olA != 0) {
                int i3 = aVar.olA;
                if (k.egG()) {
                    Window window = cVar.qdG.getWindow();
                    window.addFlags(Integer.MIN_VALUE);
                    window.setStatusBarColor(i3);
                }
            }
        }
    }

    public final void A(Drawable drawable) {
        this.yPO.A(drawable);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        this.yPO = null;
        this.yPQ.clear();
        super.onDestroy();
    }

    private Class<? extends MMActivity> aR(Class cls) {
        Class<? extends MMActivity> cls2 = null;
        Class<? extends MMActivity>[][] clsArr = this.yPR;
        for (Class<? extends MMActivity>[] clsArr2 : clsArr) {
            if (clsArr2[0] == cls) {
                cls2 = clsArr2[1];
            }
        }
        return cls2;
    }

    public final void a(final Class cls, final Intent intent, final d.a aVar) {
        if (getMainLooper().getThread() != Thread.currentThread()) {
            runOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(64890);
                    WxaLuckyMoneyBaseUI.this.a(cls, intent, aVar);
                    AppMethodBeat.o(64890);
                }
            });
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        Class<? extends MMActivity> aR = aR(cls);
        if (aR == null) {
            throw new IllegalStateException("proceed to ui = [" + cls.getName() + "], but Target is null");
        }
        intent.setClass(getContext(), aR);
        if (aVar == null) {
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/luckymoney/appbrand/ui/WxaLuckyMoneyBaseUI", "proceed", "(Ljava/lang/Class;Landroid/content/Intent;Lcom/tencent/mm/plugin/luckymoney/appbrand/ui/WxaLuckyMoneyUIRouter$OnBackListener;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/WxaLuckyMoneyBaseUI", "proceed", "(Ljava/lang/Class;Landroid/content/Intent;Lcom/tencent/mm/plugin/luckymoney/appbrand/ui/WxaLuckyMoneyUIRouter$OnBackListener;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            return;
        }
        int i2 = this.yPP;
        this.yPP = i2 + 1;
        startActivityForResult(intent, i2);
        this.yPQ.put(i2, aVar);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        d.a aVar = this.yPQ.get(i2);
        if (aVar != null) {
            Log.i("MicroMsg.HjLuckyMoneyBaseUI", "damon warns you, requestCode == [%d], I used it, and skip. check your code if needed!!!!", Integer.valueOf(i2));
            aVar.g(i3, intent);
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    public final void f(int i2, Intent intent) {
        setResult(i2, intent);
        finish();
    }
}
