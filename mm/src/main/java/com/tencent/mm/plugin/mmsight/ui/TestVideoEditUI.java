package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.e;
import com.tencent.mm.api.h;
import com.tencent.mm.api.j;
import com.tencent.mm.api.u;
import com.tencent.mm.api.z;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;

public class TestVideoEditUI extends MMActivity implements j {
    private ab zDV;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ View a(TestVideoEditUI testVideoEditUI) {
        AppMethodBeat.i(94753);
        View contentView = testVideoEditUI.getContentView();
        AppMethodBeat.o(94753);
        return contentView;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(94747);
        super.onCreate(bundle);
        fullScreenNoTitleBar(true);
        this.zDV = ab.diQ.Uo();
        ab abVar = this.zDV;
        ab.a.C0260a aVar = new ab.a.C0260a();
        aVar.diS = false;
        aVar.diW = true;
        aVar.diX = new Rect(0, 0, 1080, 1080);
        aVar.diR = ab.c.diY;
        abVar.a(aVar.VJ());
        e bB = this.zDV.bB(getContext());
        bB.setActionBarCallback(this);
        ((FrameLayout) findViewById(R.id.be9)).addView(bB, new FrameLayout.LayoutParams(-1, -1));
        bB.setSelectedFeatureListener(new z() {
            /* class com.tencent.mm.plugin.mmsight.ui.TestVideoEditUI.AnonymousClass1 */

            @Override // com.tencent.mm.api.z
            public final void a(h hVar) {
                AppMethodBeat.i(94743);
                Log.i("MicroMsg.TestVideoEditUI", "[onSelectedFeature] features:%s", hVar.name());
                AppMethodBeat.o(94743);
            }

            @Override // com.tencent.mm.api.z
            public final void a(h hVar, int i2, Object obj) {
                AppMethodBeat.i(169420);
                Log.i("MicroMsg.TestVideoEditUI", "[onSelectedDetailFeature] features:%s index:%s", hVar.name(), Integer.valueOf(i2));
                AppMethodBeat.o(169420);
            }

            @Override // com.tencent.mm.api.z
            public final void cH(boolean z) {
                AppMethodBeat.i(94745);
                if (z) {
                    TestVideoEditUI.this.showVKB();
                    AppMethodBeat.o(94745);
                    return;
                }
                TestVideoEditUI.this.hideVKB(TestVideoEditUI.a(TestVideoEditUI.this));
                AppMethodBeat.o(94745);
            }
        });
        AppMethodBeat.o(94747);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(94748);
        super.onDestroy();
        this.zDV.onDestroy();
        AppMethodBeat.o(94748);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(94749);
        if (!this.zDV.Ul()) {
            finish();
        }
        AppMethodBeat.o(94749);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
    public void onSwipeBack() {
        AppMethodBeat.i(94750);
        super.onSwipeBack();
        AppMethodBeat.o(94750);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c26;
    }

    @Override // com.tencent.mm.api.j
    public final void onFinish() {
        AppMethodBeat.i(94751);
        this.zDV.a(new u() {
            /* class com.tencent.mm.plugin.mmsight.ui.TestVideoEditUI.AnonymousClass2 */

            @Override // com.tencent.mm.api.u
            public final void onError(Exception exc) {
            }

            @Override // com.tencent.mm.api.u
            public final void a(Bitmap bitmap, boolean z) {
                AppMethodBeat.i(94746);
                Log.i("MicroMsg.TestVideoEditUI", "[onSuccess] w:%s h:%s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                try {
                    BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, b.aKS() + String.format("%s%d.%s", "wx_photo_edit_", Long.valueOf(System.currentTimeMillis()), "png"), true);
                    AppMethodBeat.o(94746);
                } catch (IOException e2) {
                    AppMethodBeat.o(94746);
                }
            }
        });
        AppMethodBeat.o(94751);
    }

    @Override // com.tencent.mm.api.j
    public final void onExit() {
        AppMethodBeat.i(94752);
        finish();
        AppMethodBeat.o(94752);
    }
}
