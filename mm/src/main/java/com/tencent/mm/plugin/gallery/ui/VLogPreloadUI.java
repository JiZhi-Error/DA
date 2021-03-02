package com.tencent.mm.plugin.gallery.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(3)
@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0014J\b\u0010\f\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/gallery/ui/VLogPreloadUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setWindowStyle", "Companion", "plugin-gallery_release"})
public final class VLogPreloadUI extends MMActivity {
    public static final a xsx = new a((byte) 0);
    private q nUq;

    static {
        AppMethodBeat.i(111806);
        AppMethodBeat.o(111806);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/gallery/ui/VLogPreloadUI$Companion;", "", "()V", "INDEX", "", "TAG", "jumpToVLogPreloadUI", "", "context", "Landroid/content/Context;", "videoList", "Ljava/util/ArrayList;", "imageList", FirebaseAnalytics.b.INDEX, "", "previewSize", "Landroid/graphics/Point;", "plugin-gallery_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Context context, ArrayList<String> arrayList, ArrayList<String> arrayList2, int[] iArr) {
            AppMethodBeat.i(257869);
            p.h(context, "context");
            p.h(arrayList, "videoList");
            p.h(arrayList2, "imageList");
            p.h(iArr, FirebaseAnalytics.b.INDEX);
            Intent intent = new Intent(context, VLogPreloadUI.class);
            intent.putStringArrayListExtra("key_select_video_list", arrayList);
            intent.putStringArrayListExtra("key_select_image_list", arrayList2);
            intent.putExtra(FirebaseAnalytics.b.INDEX, iArr);
            ((Activity) context).startActivityForResult(intent, 4381);
            ((Activity) context).overridePendingTransition(0, 0);
            AppMethodBeat.o(257869);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.c6_;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(111805);
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        setSelfNavigationBarVisible(8);
        d.rb(true);
        getWindow().setFormat(-3);
        this.nUq = h.a((Context) getContext(), getString(R.string.ek_), false, (DialogInterface.OnCancelListener) null);
        getIntent().getStringArrayListExtra("key_select_video_list");
        getIntent().getStringArrayListExtra("key_select_image_list");
        getIntent().getIntArrayExtra(FirebaseAnalytics.b.INDEX);
        Point gx = ao.gx(this);
        Point az = ao.az(this);
        int intExtra = getIntent().getIntExtra("KEY_PREVIEW_WIDTH", -1);
        Log.i("MicroMsg.VLogPreloadUI", "screen x:" + gx.x + " y:" + gx.y + "  realScreen x:" + az.x + " y:" + az.y + ", previewSize:" + intExtra + ',' + getIntent().getIntExtra("KEY_PREVIEW_HEIGHT", -1));
        AppMethodBeat.o(111805);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(257870);
        super.onDestroy();
        Log.i("MicroMsg.VLogPreloadUI", "VLogPreloadUI onDestroy");
        AppMethodBeat.o(257870);
    }
}
