package com.tencent.mm.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.e;
import com.tencent.mm.api.h;
import com.tencent.mm.api.j;
import com.tencent.mm.api.u;
import com.tencent.mm.api.z;
import com.tencent.mm.br.c;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.ArrayList;

@a(19)
public class MMNewPhotoEditUI extends MMActivity implements j {
    private Dialog HLO;
    private String OHL;
    private long OHM;
    private String OHN;
    private String OHO;
    private boolean OHP;
    private boolean OHQ;
    private final d OHR = new d(this);
    private PhotoEditProxy OHS;
    private int gwE;
    private q gxX = null;
    private ab zDV;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MMNewPhotoEditUI() {
        AppMethodBeat.i(103219);
        AppMethodBeat.o(103219);
    }

    static /* synthetic */ void a(MMNewPhotoEditUI mMNewPhotoEditUI, int i2) {
        AppMethodBeat.i(103230);
        mMNewPhotoEditUI.akZ(i2);
        AppMethodBeat.o(103230);
    }

    static /* synthetic */ void b(MMNewPhotoEditUI mMNewPhotoEditUI) {
        AppMethodBeat.i(103231);
        mMNewPhotoEditUI.ku(false);
        AppMethodBeat.o(103231);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bfx;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(103220);
        super.onCreate(bundle);
        fullScreenNoTitleBar(true, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setFlags(1024, 1024);
            getWindow().addFlags(67108864);
            b.e(this, false);
        }
        this.OHS = new PhotoEditProxy(this.OHR);
        this.OHR.connect(new Runnable() {
            /* class com.tencent.mm.ui.MMNewPhotoEditUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(103211);
                Log.i("MicroMsg.MMNewPhotoEditUI", "connected!!!");
                MMNewPhotoEditUI.a(MMNewPhotoEditUI.this);
                MMNewPhotoEditUI.this.initView();
                AppMethodBeat.o(103211);
            }
        });
        AppMethodBeat.o(103220);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        AppMethodBeat.i(103221);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.be9);
        this.zDV = ab.diQ.Uo();
        ab abVar = this.zDV;
        ab.a.C0260a aVar = new ab.a.C0260a();
        if (this.gwE == 291 || this.gwE == 293) {
            z = false;
        } else {
            z = true;
        }
        aVar.diS = z;
        aVar.diW = true;
        aVar.diR = ab.c.PHOTO;
        aVar.path = this.OHL;
        abVar.a(aVar.VJ());
        e bB = this.zDV.bB(getContext());
        bB.setActionBarCallback(this);
        frameLayout.addView(bB, new FrameLayout.LayoutParams(-1, -1));
        bB.setSelectedFeatureListener(new z() {
            /* class com.tencent.mm.ui.MMNewPhotoEditUI.AnonymousClass2 */

            @Override // com.tencent.mm.api.z
            public final void a(h hVar) {
                AppMethodBeat.i(103212);
                Log.i("MicroMsg.MMNewPhotoEditUI", "[onSelectedFeature] features:%s", hVar.name());
                AppMethodBeat.o(103212);
            }

            @Override // com.tencent.mm.api.z
            public final void a(h hVar, int i2, Object obj) {
                AppMethodBeat.i(168715);
                Log.i("MicroMsg.MMNewPhotoEditUI", "[onSelectedDetailFeature] features:%s index:%s", hVar.name(), Integer.valueOf(i2));
                AppMethodBeat.o(168715);
            }

            @Override // com.tencent.mm.api.z
            public final void cH(boolean z) {
                AppMethodBeat.i(103214);
                if (z) {
                    MMNewPhotoEditUI.this.showVKB();
                    AppMethodBeat.o(103214);
                    return;
                }
                MMNewPhotoEditUI.this.hideVKB(MMNewPhotoEditUI.this.getContentView());
                AppMethodBeat.o(103214);
            }
        });
        AppMethodBeat.o(103221);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(103222);
        super.onDestroy();
        this.zDV.onDestroy();
        this.OHR.release();
        AppMethodBeat.o(103222);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(103223);
        if (!this.zDV.Ul()) {
            if (this.gwE == 290 || this.gwE == 291) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13859, 1, 2);
            } else if (this.gwE == 4 || this.gwE == 293) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13859, 2, 2);
            } else {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13859, 0, 2);
            }
            finish();
        }
        AppMethodBeat.o(103223);
    }

    @Override // com.tencent.mm.api.j
    public final void onFinish() {
        AppMethodBeat.i(103224);
        if (this.gwE == 290 || this.gwE == 291) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13859, 1, 1);
        } else if (this.gwE == 4 || this.gwE == 293) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13859, 2, 1);
        } else {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13859, 0, 1);
        }
        if (this.gwE == 291 || this.gwE == 293) {
            l lVar = new l(getContext());
            lVar.HLX = new o.f() {
                /* class com.tencent.mm.ui.MMNewPhotoEditUI.AnonymousClass3 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(103215);
                    mVar.d(0, MMNewPhotoEditUI.this.getString(R.string.g5j));
                    mVar.d(1, MMNewPhotoEditUI.this.getString(R.string.fn9));
                    mVar.d(2, MMNewPhotoEditUI.this.getString(R.string.gaq));
                    AppMethodBeat.o(103215);
                }
            };
            lVar.HLY = new o.g() {
                /* class com.tencent.mm.ui.MMNewPhotoEditUI.AnonymousClass4 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, final int i2) {
                    AppMethodBeat.i(103216);
                    p.a(MMNewPhotoEditUI.this, new Runnable() {
                        /* class com.tencent.mm.ui.MMNewPhotoEditUI.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(204497);
                            MMNewPhotoEditUI.a(MMNewPhotoEditUI.this, i2);
                            AppMethodBeat.o(204497);
                        }
                    }, new Runnable() {
                        /* class com.tencent.mm.ui.MMNewPhotoEditUI.AnonymousClass4.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(204498);
                            Toast.makeText(MMApplicationContext.getContext(), MMNewPhotoEditUI.this.getResources().getString(R.string.by1), 1).show();
                            AppMethodBeat.o(204498);
                        }
                    });
                    AppMethodBeat.o(103216);
                }
            };
            com.tencent.mm.ui.base.h.a(getContext(), lVar.gXI());
            AppMethodBeat.o(103224);
            return;
        }
        akZ(-1);
        AppMethodBeat.o(103224);
    }

    @Override // com.tencent.mm.api.j
    public final void onExit() {
        AppMethodBeat.i(103225);
        onBackPressed();
        AppMethodBeat.o(103225);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(103226);
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 1 && intent != null) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            Log.d("MicroMsg.MMNewPhotoEditUI", "select %s for sending imagePath:%s", stringExtra, this.OHO);
            this.HLO = com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.fm0), false, (DialogInterface.OnCancelListener) null);
            this.OHS.sendImage(intent.getStringExtra("custom_send_text"), this.OHO, this.OHS.getSelfUsername(), stringExtra);
            if (this.HLO != null) {
                this.HLO.dismiss();
            }
            if (!this.OHP) {
                s.deleteFile(this.OHO);
            } else {
                AndroidMediaUtil.refreshMediaScanner(this.OHO, this);
            }
            finish();
            AppMethodBeat.o(103226);
            return;
        }
        if (intent == null && !Util.isNullOrNil(this.OHO) && this.gwE == 291) {
            s.deleteFile(this.OHO);
        }
        AppMethodBeat.o(103226);
    }

    private void akZ(final int i2) {
        AppMethodBeat.i(103227);
        ku(true);
        this.zDV.a(new u() {
            /* class com.tencent.mm.ui.MMNewPhotoEditUI.AnonymousClass5 */

            @Override // com.tencent.mm.api.u
            public final void onError(Exception exc) {
                AppMethodBeat.i(103217);
                MMNewPhotoEditUI.b(MMNewPhotoEditUI.this);
                Log.e("MicroMsg.MMNewPhotoEditUI", "[onRefreshed] %s", exc);
                Toast.makeText(MMApplicationContext.getContext(), MMNewPhotoEditUI.this.getResources().getString(R.string.by1), 1).show();
                MMNewPhotoEditUI.this.setResult(0);
                MMNewPhotoEditUI.this.finish();
                AppMethodBeat.o(103217);
            }

            @Override // com.tencent.mm.api.u
            public final void a(Bitmap bitmap, boolean z) {
                AppMethodBeat.i(103218);
                Log.i("MicroMsg.MMNewPhotoEditUI", "[onSuccess] w:%s h:%s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                try {
                    String exportImagePath = AndroidMediaUtil.getExportImagePath("jpg");
                    BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, exportImagePath, true);
                    Log.i("MicroMsg.MMNewPhotoEditUI", "[onSuccess] photoPath:%s", exportImagePath);
                    MMNewPhotoEditUI.this.OHS.recordImage(MMNewPhotoEditUI.this.OHL, exportImagePath, MMNewPhotoEditUI.this.OHM, MMNewPhotoEditUI.this.zDV.Um().VF(), MMNewPhotoEditUI.this.zDV.Um().VG());
                    if (MMNewPhotoEditUI.this.OHP || i2 == 2) {
                        AndroidMediaUtil.refreshMediaScanner(exportImagePath, MMNewPhotoEditUI.this);
                    }
                    if (i2 != 0 && !bitmap.isRecycled()) {
                        Log.i("MicroMsg.MMNewPhotoEditUI", "bitmap recycle %s", bitmap.toString());
                        bitmap.recycle();
                    }
                    MMNewPhotoEditUI.this.OHO = exportImagePath;
                    if (MMNewPhotoEditUI.this.gwE != 291 && MMNewPhotoEditUI.this.gwE != 293) {
                        MMNewPhotoEditUI.d(MMNewPhotoEditUI.this, exportImagePath);
                    } else if (i2 == 0) {
                        MMNewPhotoEditUI.b(MMNewPhotoEditUI.this, exportImagePath);
                        MMNewPhotoEditUI.b(MMNewPhotoEditUI.this);
                        MMNewPhotoEditUI.b(MMNewPhotoEditUI.this, 1);
                        AppMethodBeat.o(103218);
                        return;
                    } else if (i2 == 1) {
                        MMNewPhotoEditUI.c(MMNewPhotoEditUI.this, exportImagePath);
                        MMNewPhotoEditUI.b(MMNewPhotoEditUI.this, 2);
                        Toast.makeText(MMApplicationContext.getContext(), MMNewPhotoEditUI.this.getString(R.string.c8j), 1).show();
                        MMNewPhotoEditUI.b(MMNewPhotoEditUI.this);
                        MMNewPhotoEditUI.this.finish();
                        AppMethodBeat.o(103218);
                        return;
                    } else if (i2 == 2) {
                        Toast.makeText(MMApplicationContext.getContext(), MMNewPhotoEditUI.this.getString(R.string.c30, new Object[]{AndroidMediaUtil.getSysCameraDirPath()}), 1).show();
                        MMNewPhotoEditUI.b(MMNewPhotoEditUI.this, 3);
                        MMNewPhotoEditUI.b(MMNewPhotoEditUI.this);
                        MMNewPhotoEditUI.this.finish();
                        AppMethodBeat.o(103218);
                        return;
                    }
                    AppMethodBeat.o(103218);
                } catch (IOException e2) {
                    onError(e2);
                    AppMethodBeat.o(103218);
                }
            }
        });
        AppMethodBeat.o(103227);
    }

    private void ku(boolean z) {
        AppMethodBeat.i(103228);
        Log.i("MicroMsg.MMNewPhotoEditUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.gxX = q.a(this, getString(R.string.fph), true, 0, null);
            AppMethodBeat.o(103228);
            return;
        }
        if (this.gxX != null && this.gxX.isShowing()) {
            this.gxX.dismiss();
            this.gxX = null;
        }
        AppMethodBeat.o(103228);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    static /* synthetic */ void a(MMNewPhotoEditUI mMNewPhotoEditUI) {
        AppMethodBeat.i(103229);
        Intent intent = mMNewPhotoEditUI.getIntent();
        mMNewPhotoEditUI.OHL = intent.getStringExtra("raw_photo_path");
        mMNewPhotoEditUI.OHM = intent.getLongExtra("raw_photo_img_id", -1);
        mMNewPhotoEditUI.OHN = intent.getStringExtra("after_photo_edit");
        mMNewPhotoEditUI.gwE = intent.getIntExtra("from_scene", 0);
        mMNewPhotoEditUI.OHQ = intent.getBooleanExtra("from_scene_small_preview", false);
        mMNewPhotoEditUI.OHP = mMNewPhotoEditUI.OHS.isAutoSave();
        AppMethodBeat.o(103229);
    }

    static /* synthetic */ void b(MMNewPhotoEditUI mMNewPhotoEditUI, String str) {
        AppMethodBeat.i(103232);
        Intent intent = new Intent();
        intent.putExtra("scene", 8);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("image_path", str);
        intent.putExtra("Retr_Msg_Type", 0);
        c.c(mMNewPhotoEditUI, ".ui.transmit.SelectConversationUI", intent, 1);
        AppMethodBeat.o(103232);
    }

    static /* synthetic */ void b(MMNewPhotoEditUI mMNewPhotoEditUI, int i2) {
        int i3;
        int i4;
        int i5;
        AppMethodBeat.i(103233);
        int i6 = 0;
        if (mMNewPhotoEditUI.gwE == 290 || mMNewPhotoEditUI.gwE == 291) {
            i6 = 1;
        } else if (mMNewPhotoEditUI.gwE == 4 || mMNewPhotoEditUI.gwE == 293) {
            i6 = 2;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13858, Integer.valueOf(i6), 1, 1, Integer.valueOf(i2));
        int Vy = mMNewPhotoEditUI.zDV.Um().Vy();
        int Vx = mMNewPhotoEditUI.zDV.Um().Vx();
        int Vz = mMNewPhotoEditUI.zDV.Um().Vz();
        int VA = mMNewPhotoEditUI.zDV.Um().VA();
        boolean isCropped = mMNewPhotoEditUI.zDV.Um().isCropped();
        boolean VC = mMNewPhotoEditUI.zDV.Um().VC();
        int VB = mMNewPhotoEditUI.zDV.Um().VB();
        Object[] objArr = new Object[8];
        objArr[0] = Integer.valueOf(Vy);
        objArr[1] = Integer.valueOf(Vx);
        objArr[2] = Integer.valueOf(Vz);
        objArr[3] = Integer.valueOf(VA);
        objArr[4] = Integer.valueOf(isCropped ? 1 : 0);
        objArr[5] = Integer.valueOf(VB);
        objArr[6] = Integer.valueOf(mMNewPhotoEditUI.OHQ ? 5 : 4);
        objArr[7] = Boolean.valueOf(VC);
        Log.i("MicroMsg.MMNewPhotoEditUI", "[reportPhotoEdit] emojiCount:%s,textCount:%s,mosaicCount:%s,penCount:%s,isCrop:%s,undoCount:%s,mSmallPreview:%s isRotaion:%s", objArr);
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        Object[] objArr2 = new Object[11];
        objArr2[0] = 0;
        objArr2[1] = 1;
        objArr2[2] = Integer.valueOf(Vy);
        objArr2[3] = Integer.valueOf(Vx);
        objArr2[4] = Integer.valueOf(Vz);
        objArr2[5] = Integer.valueOf(VA);
        if (isCropped) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        objArr2[6] = Integer.valueOf(i3);
        objArr2[7] = Integer.valueOf(VB);
        objArr2[8] = 1;
        if (mMNewPhotoEditUI.OHQ) {
            i4 = 5;
        } else {
            i4 = 4;
        }
        objArr2[9] = Integer.valueOf(i4);
        if (VC) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        objArr2[10] = Integer.valueOf(i5);
        hVar.a(13857, objArr2);
        AppMethodBeat.o(103233);
    }

    static /* synthetic */ void c(MMNewPhotoEditUI mMNewPhotoEditUI, String str) {
        AppMethodBeat.i(103234);
        mMNewPhotoEditUI.OHS.doFav(str);
        AppMethodBeat.o(103234);
    }

    static /* synthetic */ void d(MMNewPhotoEditUI mMNewPhotoEditUI, String str) {
        AppMethodBeat.i(103235);
        Log.i("MicroMsg.MMNewPhotoEditUI", "[gotoImagePreviewUI] :%s", str);
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> stringArrayListExtra = mMNewPhotoEditUI.getIntent().getStringArrayListExtra("preview_image_list");
        ArrayList<String> stringArrayListExtra2 = mMNewPhotoEditUI.getIntent().getStringArrayListExtra("preview_select_image_list");
        int i2 = 0;
        while (stringArrayListExtra != null && i2 < stringArrayListExtra.size()) {
            String str2 = stringArrayListExtra.get(i2);
            if (str2.equalsIgnoreCase(Util.nullAsNil(mMNewPhotoEditUI.OHL)) || str2.equalsIgnoreCase(Util.nullAsNil(mMNewPhotoEditUI.OHN))) {
                str2 = str;
            }
            arrayList.add(str2);
            i2++;
        }
        int i3 = 0;
        while (stringArrayListExtra2 != null && i3 < stringArrayListExtra2.size()) {
            String str3 = stringArrayListExtra2.get(i3);
            if (str3.equalsIgnoreCase(Util.nullAsNil(mMNewPhotoEditUI.OHL)) || str3.equalsIgnoreCase(Util.nullAsNil(mMNewPhotoEditUI.OHN))) {
                str3 = str;
            }
            arrayList2.add(str3);
            i3++;
        }
        String str4 = null;
        if (!mMNewPhotoEditUI.OHP) {
            str4 = s.k("wcf://temp/photoEdited_" + System.currentTimeMillis(), true);
            s.nw(str, str4);
        }
        s.deleteFile(mMNewPhotoEditUI.OHN);
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("max_select_count", mMNewPhotoEditUI.getIntent().getIntExtra("max_select_count", 9));
        intent.putExtra("isPreviewPhoto", true);
        intent.putExtra("raw_photo_path", mMNewPhotoEditUI.OHL);
        intent.putExtra("raw_photo_img_id", mMNewPhotoEditUI.OHM);
        intent.putExtra("after_photo_edit", str);
        intent.putExtra("tmp_photo_edit", str4);
        Bundle bundle = new Bundle();
        bundle.putString("raw_photo_path", mMNewPhotoEditUI.OHL);
        bundle.putString("after_photo_edit", str);
        bundle.putInt("report_info_emotion_count", mMNewPhotoEditUI.zDV.Um().Vy());
        bundle.putInt("report_info_text_count", mMNewPhotoEditUI.zDV.Um().Vx());
        bundle.putInt("report_info_mosaic_count", mMNewPhotoEditUI.zDV.Um().Vz());
        bundle.putInt("report_info_doodle_count", mMNewPhotoEditUI.zDV.Um().VA());
        bundle.putBoolean("report_info_iscrop", mMNewPhotoEditUI.zDV.Um().isCropped());
        bundle.putInt("report_info_undo_count", mMNewPhotoEditUI.zDV.Um().VB());
        bundle.putBoolean("report_info_is_rotation", mMNewPhotoEditUI.zDV.Um().VC());
        intent.putExtra("report_info", bundle);
        String stringExtra = mMNewPhotoEditUI.getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra2 = mMNewPhotoEditUI.getIntent().getStringExtra("GalleryUI_ToUser");
        if (!Util.isNullOrNil(stringExtra)) {
            intent.putExtra("GalleryUI_FromUser", stringExtra);
        }
        if (!Util.isNullOrNil(stringExtra2)) {
            intent.putExtra("GalleryUI_ToUser", stringExtra2);
        }
        intent.putStringArrayListExtra("preview_image_list", arrayList);
        intent.putStringArrayListExtra("preview_select_image_list", arrayList2);
        mMNewPhotoEditUI.setResult(-1, intent);
        mMNewPhotoEditUI.ku(false);
        mMNewPhotoEditUI.finish();
        AppMethodBeat.o(103235);
    }
}
