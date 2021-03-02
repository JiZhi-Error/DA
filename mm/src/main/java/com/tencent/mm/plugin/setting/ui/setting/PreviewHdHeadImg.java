package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.n;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.a.xr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.a;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.s;
import com.tencent.tavkit.component.TAVExporter;

public class PreviewHdHeadImg extends MMActivity {
    private final int CZo = 1;
    private final int CZp = 3;
    private GetHdHeadImageGalleryView CZq;
    private f CZr;
    private String CZs;
    private final int jUw = 2;
    private String username;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(PreviewHdHeadImg previewHdHeadImg, Bitmap bitmap, String str) {
        AppMethodBeat.i(256471);
        previewHdHeadImg.d(bitmap, str);
        AppMethodBeat.o(256471);
    }

    static /* synthetic */ void e(PreviewHdHeadImg previewHdHeadImg) {
        AppMethodBeat.i(256472);
        previewHdHeadImg.eSK();
        AppMethodBeat.o(256472);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(73927);
        customfixStatusbar(true);
        super.onCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        initView();
        AppMethodBeat.o(73927);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.atg;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(73928);
        setMMTitle(R.string.gnm);
        setActionbarColor(getResources().getColor(R.color.ac_));
        setNavigationbarColor(getResources().getColor(R.color.BW_0));
        this.username = z.aTY();
        this.CZq = (GetHdHeadImageGalleryView) findViewById(R.id.dci);
        this.CZq.setUsername(this.username);
        eSK();
        addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(73921);
                e eVar = new e((Context) PreviewHdHeadImg.this, 1, false);
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(73919);
                        mVar.kV(1, R.string.gno);
                        Bitmap a2 = c.a(PreviewHdHeadImg.this.username, true, -1, null);
                        p.aYn();
                        if (s.YS(com.tencent.mm.aj.e.M(z.aTY() + ".last", true))) {
                            mVar.kV(3, R.string.gtn);
                        }
                        if (a2 != null) {
                            mVar.kV(2, R.string.dv6);
                        }
                        AppMethodBeat.o(73919);
                    }
                };
                eVar.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg.AnonymousClass1.AnonymousClass2 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(73920);
                        switch (menuItem.getItemId()) {
                            case 1:
                                a.jRu.s(PreviewHdHeadImg.this);
                                AppMethodBeat.o(73920);
                                return;
                            case 2:
                                PreviewHdHeadImg.b(PreviewHdHeadImg.this);
                                AppMethodBeat.o(73920);
                                return;
                            case 3:
                                Intent intent = new Intent();
                                intent.setClass(PreviewHdHeadImg.this.getContext(), PreviewLastHdHeadImg.class);
                                p.aYn();
                                intent.putExtra("CropImage_OutputPath", com.tencent.mm.aj.e.M(z.aTY() + ".crop", true));
                                p.aYn();
                                intent.putExtra("last_avatar_path", com.tencent.mm.aj.e.M(z.aTY() + ".last", true));
                                PreviewHdHeadImg.this.startActivityForResult(intent, 4);
                                break;
                        }
                        AppMethodBeat.o(73920);
                    }
                };
                eVar.dGm();
                AppMethodBeat.o(73921);
                return true;
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(73922);
                PreviewHdHeadImg.this.finish();
                AppMethodBeat.o(73922);
                return true;
            }
        });
        AppMethodBeat.o(73928);
    }

    private void eSK() {
        AppMethodBeat.i(73929);
        if (!g.aAh().isSDCardAvailable()) {
            u.g(getContext(), null);
            d(p.aYn().cW(getContext()), null);
            AppMethodBeat.o(73929);
            return;
        }
        final Bitmap eSL = eSL();
        if (eSL == null || eSL.isRecycled()) {
            Log.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is not in the cache, use default avatar", this.username);
        } else {
            Log.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is in the cache", this.username);
            this.CZq.setThumbImage(eSL);
        }
        p.aYn();
        Bitmap Mo = com.tencent.mm.aj.e.Mo(this.username);
        if (Mo == null || Mo.isRecycled()) {
            this.CZr = new f();
            this.CZr.a(this.username, new f.c() {
                /* class com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg.AnonymousClass4 */

                @Override // com.tencent.mm.aj.f.c
                public final int dp(int i2, int i3) {
                    AppMethodBeat.i(256469);
                    PreviewHdHeadImg.this.CZr.sQ();
                    Log.i("MicroMsg.PreviewHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", Integer.valueOf(i2), Integer.valueOf(i3));
                    if (i2 == 0 && i3 == 0) {
                        p.aYn();
                        Bitmap Mo = com.tencent.mm.aj.e.Mo(PreviewHdHeadImg.this.username);
                        if (Mo != null) {
                            PreviewHdHeadImg previewHdHeadImg = PreviewHdHeadImg.this;
                            p.aYn();
                            PreviewHdHeadImg.a(previewHdHeadImg, Mo, com.tencent.mm.aj.e.L(PreviewHdHeadImg.this.username, true));
                        } else {
                            PreviewHdHeadImg.a(PreviewHdHeadImg.this, eSL, null);
                        }
                        AppMethodBeat.o(256469);
                    } else {
                        PreviewHdHeadImg.a(PreviewHdHeadImg.this, eSL, null);
                        AppMethodBeat.o(256469);
                    }
                    return 0;
                }
            });
            AppMethodBeat.o(73929);
            return;
        }
        Log.i("MicroMsg.PreviewHdHeadImg", "The HDAvatar of %s is already exists", this.username);
        p.aYn();
        d(Mo, com.tencent.mm.aj.e.L(this.username, true));
        AppMethodBeat.o(73929);
    }

    private Bitmap eSL() {
        AppMethodBeat.i(73930);
        Bitmap a2 = c.a(this.username, true, -1, null);
        if (a2 == null) {
            a2 = BitmapFactory.decodeResource(getResources(), R.drawable.bca);
        }
        AppMethodBeat.o(73930);
        return a2;
    }

    private void d(Bitmap bitmap, String str) {
        Bitmap bitmap2;
        AppMethodBeat.i(73931);
        if (bitmap == null) {
            AppMethodBeat.o(73931);
            return;
        }
        try {
            if (bitmap.getWidth() < 480) {
                float width = 480.0f / ((float) bitmap.getWidth());
                Matrix matrix = new Matrix();
                matrix.postScale(width, width);
                bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } else {
                bitmap2 = bitmap;
            }
            Log.d("MicroMsg.PreviewHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(bitmap2.getWidth()), Integer.valueOf(bitmap2.getHeight()));
            this.CZq.setHdHeadImage(bitmap2);
            this.CZq.setHdHeadImagePath(str);
            this.CZs = str;
            AppMethodBeat.o(73931);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.PreviewHdHeadImg", e2, "", new Object[0]);
            AppMethodBeat.o(73931);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(73932);
        Log.i("MicroMsg.PreviewHdHeadImg", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (intent == null) {
            Log.e("MicroMsg.PreviewHdHeadImg", "wtf!!! data is null!!!");
        }
        if (i3 != -1) {
            if (i2 == 2 || i2 == 4) {
                new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(73925);
                        xr xrVar = new xr();
                        xrVar.edW.edY = true;
                        EventCenter.instance.publish(xrVar);
                        AppMethodBeat.o(73925);
                    }
                });
            }
            AppMethodBeat.o(73932);
            return;
        }
        switch (i2) {
            case 2:
                if (intent == null) {
                    AppMethodBeat.o(73932);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 1);
                intent2.putExtra("CropImage_Filter", true);
                p.aYn();
                intent2.putExtra("CropImage_OutputPath", com.tencent.mm.aj.e.L(z.aTY() + ".crop", true));
                intent2.putExtra("CropImage_ImgPath", (String) null);
                intent2.putExtra("CropImage_from_scene", 3);
                com.tencent.mm.plugin.setting.c.jRt.a(this, intent, intent2, d.aSY(), 4, (a.AbstractC2129a) null);
                AppMethodBeat.o(73932);
                return;
            case 3:
            default:
                AppMethodBeat.o(73932);
                return;
            case 4:
                new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg.AnonymousClass6 */

                    public final void run() {
                        AppMethodBeat.i(73926);
                        xr xrVar = new xr();
                        xrVar.edW.edY = true;
                        EventCenter.instance.publish(xrVar);
                        AppMethodBeat.o(73926);
                    }
                });
                if (intent == null) {
                    AppMethodBeat.o(73932);
                    return;
                }
                String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                final Bitmap bitmapNative = BitmapUtil.getBitmapNative(this.CZs);
                if (stringExtra == null) {
                    Log.e("MicroMsg.PreviewHdHeadImg", "crop picture failed");
                    AppMethodBeat.o(73932);
                    return;
                }
                d(BitmapUtil.getBitmapNative(stringExtra), null);
                new n(getContext(), stringExtra).G(new Runnable() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(256470);
                        Log.d("MicroMsg.PreviewHdHeadImg", "updateHeadImg hasUin:%b user:%s", Boolean.valueOf(g.aAc()), z.aTY());
                        if (g.aAc()) {
                            if (bitmapNative != null) {
                                p.aYn();
                                PreviewHdHeadImg.e(bitmapNative, com.tencent.mm.aj.e.M(z.aTY() + ".last", true));
                            }
                            bf.iDu.Km(c.Me(z.aTY()));
                        }
                        PreviewHdHeadImg.e(PreviewHdHeadImg.this);
                        AppMethodBeat.o(256470);
                    }
                });
                AppMethodBeat.o(73932);
                return;
        }
    }

    public static boolean e(Bitmap bitmap, String str) {
        AppMethodBeat.i(73933);
        if (str != null && !str.equals("")) {
            try {
                BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, str, true);
                AppMethodBeat.o(73933);
                return true;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.PreviewHdHeadImg", e2, "", new Object[0]);
                Log.e("MicroMsg.PreviewHdHeadImg", "saveBitmapToImage failed:" + e2.toString());
            }
        }
        AppMethodBeat.o(73933);
        return false;
    }

    static /* synthetic */ void b(PreviewHdHeadImg previewHdHeadImg) {
        AppMethodBeat.i(73934);
        com.tencent.mm.platformtools.p.a(previewHdHeadImg.getContext(), previewHdHeadImg.CZs, new p.a() {
            /* class com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg.AnonymousClass3 */

            @Override // com.tencent.mm.platformtools.p.a
            public final void bP(String str, String str2) {
                AppMethodBeat.i(256467);
                AndroidMediaUtil.refreshMediaScanner(str2, PreviewHdHeadImg.this.getContext());
                Toast.makeText(PreviewHdHeadImg.this.getContext(), PreviewHdHeadImg.this.getContext().getString(R.string.dv7, new Object[]{AndroidMediaUtil.getSysCameraDirPath()}), 1).show();
                AppMethodBeat.o(256467);
            }

            @Override // com.tencent.mm.platformtools.p.a
            public final void bQ(String str, String str2) {
                AppMethodBeat.i(256468);
                Toast.makeText(PreviewHdHeadImg.this.getContext(), s.YS(PreviewHdHeadImg.this.CZs) ? PreviewHdHeadImg.this.getContext().getString(R.string.gao) : PreviewHdHeadImg.this.getContext().getString(R.string.gnn), 1).show();
                AppMethodBeat.o(256468);
            }
        });
        AppMethodBeat.o(73934);
    }
}
