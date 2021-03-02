package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tavkit.component.TAVExporter;

public class MMSightRecordViewTestUI extends MMActivity {
    private float ilP = 0.67f;
    private int kyq = TAVExporter.VIDEO_EXPORT_WIDTH;
    private MMSightRecordView lPv;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(94565);
        super.onCreate(bundle);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(94557);
                MMSightRecordViewTestUI.this.finish();
                AppMethodBeat.o(94557);
                return false;
            }
        });
        this.lPv = (MMSightRecordView) findViewById(R.id.gxs);
        this.lPv.setDisplayRatio(this.ilP);
        this.lPv.setPreviewSizeLimit(this.kyq);
        this.lPv.setVideoPara$2e715812(100000);
        this.lPv.setVideoFilePath(b.aKJ() + "mmsighttest.mp4");
        this.lPv.setClipPictureSize(true);
        this.lPv.setClipVideoSize(true);
        this.lPv.zsX.bqN();
        this.lPv.setFlashMode(3);
        this.lPv.setFrameDataCallback(new MMSightRecordView.a() {
            /* class com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.a
            public final void C(byte[] bArr, int i2, int i3) {
            }
        });
        this.lPv.zsX.startPreview();
        this.lPv.zsX.bqI();
        findViewById(R.id.ihl).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(94559);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/mmsight/ui/MMSightRecordViewTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                MMSightRecordViewTestUI.this.lPv.a((MMSightRecordView.g) new MMSightRecordView.g() {
                    /* class com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI.AnonymousClass3.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.g
                    public final void R(Bitmap bitmap) {
                        AppMethodBeat.i(94558);
                        if (bitmap != null) {
                            ((ImageView) MMSightRecordViewTestUI.this.findViewById(R.id.dvz)).setImageBitmap(bitmap);
                        }
                        AppMethodBeat.o(94558);
                    }

                    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.g
                    public final void bFZ() {
                    }
                }, true);
                a.a(this, "com/tencent/mm/plugin/mmsight/ui/MMSightRecordViewTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(94559);
            }
        });
        findViewById(R.id.i4o).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(94562);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/mmsight/ui/MMSightRecordViewTestUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                MMSightRecordViewTestUI.this.lPv.zsX.aai();
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI.AnonymousClass4.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(94561);
                        MMSightRecordViewTestUI.this.lPv.a(new MMSightRecordView.h() {
                            /* class com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI.AnonymousClass4.AnonymousClass1.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.h
                            public final void hs(boolean z) {
                                AppMethodBeat.i(94560);
                                Toast.makeText(MMSightRecordViewTestUI.this, "record finish, error: ".concat(String.valueOf(z)), 0).show();
                                AppMethodBeat.o(94560);
                            }
                        });
                        AppMethodBeat.o(94561);
                    }
                }, 5000);
                a.a(this, "com/tencent/mm/plugin/mmsight/ui/MMSightRecordViewTestUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(94562);
            }
        });
        final TextView textView = (TextView) findViewById(R.id.bl0);
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(94563);
                textView.setText("");
                textView.append(String.format("picture size: %s, ratio: %s\n", MMSightRecordViewTestUI.this.lPv.getPictureSize(), Float.valueOf(((float) Math.min(MMSightRecordViewTestUI.this.lPv.getPictureSize().x, MMSightRecordViewTestUI.this.lPv.getPictureSize().y)) / ((float) Math.max(MMSightRecordViewTestUI.this.lPv.getPictureSize().x, MMSightRecordViewTestUI.this.lPv.getPictureSize().y)))));
                textView.append(String.format("video size: %s, ratio: %s\n", MMSightRecordViewTestUI.this.lPv.getVideoSize(), Float.valueOf(((float) Math.min(MMSightRecordViewTestUI.this.lPv.getVideoSize().x, MMSightRecordViewTestUI.this.lPv.getVideoSize().y)) / ((float) Math.max(MMSightRecordViewTestUI.this.lPv.getVideoSize().x, MMSightRecordViewTestUI.this.lPv.getVideoSize().y)))));
                textView.append(String.format("preview size limit: %s\n", Integer.valueOf(MMSightRecordViewTestUI.this.kyq)));
                textView.append(String.format("display ratio: %s\n", Float.valueOf(MMSightRecordViewTestUI.this.ilP)));
                textView.append(String.format("view size: %s, ratio: %s\n", new Point(MMSightRecordViewTestUI.this.lPv.getWidth(), MMSightRecordViewTestUI.this.lPv.getHeight()), Float.valueOf(((float) MMSightRecordViewTestUI.this.lPv.getWidth()) / ((float) MMSightRecordViewTestUI.this.lPv.getHeight()))));
                AppMethodBeat.o(94563);
            }
        }, 1000);
        findViewById(R.id.if_).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(94564);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/mmsight/ui/MMSightRecordViewTestUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                MMSightRecordViewTestUI.this.lPv.zsX.switchCamera();
                a.a(this, "com/tencent/mm/plugin/mmsight/ui/MMSightRecordViewTestUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(94564);
            }
        });
        AppMethodBeat.o(94565);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(94566);
        super.onDestroy();
        this.lPv.zsX.release();
        AppMethodBeat.o(94566);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bas;
    }
}
