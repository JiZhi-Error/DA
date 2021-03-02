package com.tencent.mm.plugin.mv.ui;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvSongControlUIC;
import com.tencent.mm.plugin.secdata.c;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.ui.report.MMSecDataActivity;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u0018\u0010\u0007\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0018\u00010\bH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "()V", "TAG", "", "getForceOrientation", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-mv_release"})
public abstract class BaseMusicMvUI extends MMSecDataActivity {
    private final String TAG = "MicroMsg.Mv.BaseMusicMvUI";
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.ui.MMFragmentActivity
    public Set<Class<? extends UIComponent>> importUIComponents() {
        return ak.setOf((Object[]) new Class[]{SecDataUIC.class, MusicMvSongControlUIC.class});
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a aVar = a.PRN;
        ((SecDataUIC) a.b(this).get(SecDataUIC.class)).a(new c(cst.class, 7, (byte) 0));
        SecDataUIC.a aVar2 = SecDataUIC.CWq;
        cst cst = (cst) SecDataUIC.a.a(this, 7, cst.class);
        if (cst != null) {
            SecDataUIC.a aVar3 = SecDataUIC.CWq;
            cst cst2 = (cst) SecDataUIC.a.b(this, 7, cst.class);
            if (cst2 != null) {
                cst.scene = cst2.scene;
                cst.sGQ = cst2.sGQ;
                cst.MxI = cst2.MxI;
                cst.MxJ = cst2.MxJ;
                cst.Vkb = cst2.Vkb;
                Log.i(this.TAG, "init mv page scene:" + cst2.scene + " contextId:" + cst2.sGQ + " finderCommentScene:" + cst2.MxI + " finderContextId:" + cst2.Vkb);
            }
        }
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_mv_report_data");
        if (byteArrayExtra != null) {
            try {
                cst cst3 = new cst();
                cst3.parseFrom(byteArrayExtra);
                SecDataUIC.a aVar4 = SecDataUIC.CWq;
                cst cst4 = (cst) SecDataUIC.a.a(this, 7, cst.class);
                if (cst4 != null) {
                    cst4.scene = cst3.scene;
                    cst4.sGQ = cst3.sGQ;
                    cst4.MxI = cst3.MxI;
                    cst4.MxJ = cst4.MxJ;
                    Log.i(this.TAG, "init mv page report data from intent, " + cst3.scene + ' ' + cst3.sGQ + ' ' + cst3.MxI);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace(this.TAG, e2, e2.getMessage(), new Object[0]);
            }
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }
}
