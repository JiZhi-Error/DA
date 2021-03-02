package com.tencent.mm.plugin.gallery.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.ab;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.plugin.appbrand.jsapi.audio.g;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.d;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.s;
import com.tencent.mm.plugin.gallery.model.t;
import com.tencent.mm.plugin.gallery.ui.VLogPreloadUI;
import com.tencent.mm.plugin.gif.f;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

@a(19)
@TargetApi(16)
public class ImagePreviewUI extends MMActivity {
    private int kyt;
    private int mediaType = 0;
    private String path;
    private boolean qoL;
    private int wnd;
    private TextView xnV;
    private ArrayList<GalleryItem.MediaItem> xno;
    private String xnr;
    private HashMap<String, Integer> xoA = new HashMap<>();
    private HashSet<String> xoB;
    private boolean xob = true;
    private boolean xoc;
    private boolean xoe;
    private boolean xof;
    private long xol = 0;
    private int xoo;
    private boolean xpA;
    private MTimerHandler xqA;
    private float xqB = 0.0f;
    private ImageButton xqC;
    private TextView xqD;
    private ViewGroup xqE;
    private ViewGroup xqF;
    private boolean xqG = true;
    private boolean xqH = true;
    private int xqI = 0;
    private int xqJ = 10;
    private TextView xqK;
    private TextView xqL;
    private TextView xqM;
    private TextView xqN;
    private View xqO;
    private TextView xqP;
    private ProgressBar xqQ;
    private boolean xqR = false;
    boolean xqS = false;
    private d.b xqT = null;
    private String xqU;
    private String xqV = "";
    private int xqW = 300000;
    private String xqX;
    private int xqY = 1000;
    private String xqZ;
    private d xqr;
    private MMViewPager xqs;
    private RecyclerView xqt;
    private ArrayList<String> xqu;
    private ArrayList<String> xqv;
    private ArrayList<GalleryItem.MediaItem> xqw;
    private Integer xqx;
    private ImageButton xqy;
    private TextView xqz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ImagePreviewUI() {
        AppMethodBeat.i(111592);
        AppMethodBeat.o(111592);
    }

    static /* synthetic */ void a(ImagePreviewUI imagePreviewUI, GalleryItem.MediaItem mediaItem) {
        AppMethodBeat.i(257756);
        imagePreviewUI.j(mediaItem);
        AppMethodBeat.o(257756);
    }

    static /* synthetic */ void a(ImagePreviewUI imagePreviewUI, String str) {
        AppMethodBeat.i(111627);
        imagePreviewUI.ayZ(str);
        AppMethodBeat.o(111627);
    }

    static /* synthetic */ void a(ImagePreviewUI imagePreviewUI, String str, GalleryItem.MediaItem mediaItem) {
        AppMethodBeat.i(257755);
        imagePreviewUI.a(str, mediaItem);
        AppMethodBeat.o(257755);
    }

    static /* synthetic */ void a(ImagePreviewUI imagePreviewUI, boolean z, boolean z2, GalleryItem.MediaItem mediaItem) {
        AppMethodBeat.i(257759);
        imagePreviewUI.a(z, z2, mediaItem);
        AppMethodBeat.o(257759);
    }

    static /* synthetic */ boolean a(ImagePreviewUI imagePreviewUI, String str, GalleryItem.VideoMediaItem videoMediaItem, boolean z) {
        AppMethodBeat.i(257758);
        boolean a2 = imagePreviewUI.a(str, videoMediaItem, z);
        AppMethodBeat.o(257758);
        return a2;
    }

    static /* synthetic */ int dSq() {
        AppMethodBeat.i(111632);
        int dSo = dSo();
        AppMethodBeat.o(111632);
        return dSo;
    }

    static /* synthetic */ void j(ImagePreviewUI imagePreviewUI) {
        AppMethodBeat.i(111625);
        imagePreviewUI.goBack();
        AppMethodBeat.o(111625);
    }

    static /* synthetic */ ArrayList l(ImagePreviewUI imagePreviewUI) {
        AppMethodBeat.i(111626);
        ArrayList<String> dSm = imagePreviewUI.dSm();
        AppMethodBeat.o(111626);
        return dSm;
    }

    static /* synthetic */ String n(ImagePreviewUI imagePreviewUI) {
        AppMethodBeat.i(111629);
        String dSl = imagePreviewUI.dSl();
        AppMethodBeat.o(111629);
        return dSl;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    @TargetApi(16)
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(111593);
        final long currentTicks = Util.currentTicks();
        super.onCreate(bundle);
        fullScreenNoTitleBar(true);
        ao.bm(this);
        new MMHandler().post(new Runnable() {
            /* class com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(111559);
                ImagePreviewUI.a(ImagePreviewUI.this, true);
                Log.v("MicroMsg.ImagePreviewUI", "test oncreate post: %d", Long.valueOf(Util.ticksToNow(currentTicks)));
                AppMethodBeat.o(111559);
            }
        });
        Log.v("MicroMsg.ImagePreviewUI", "test oncreate: %d", Long.valueOf(Util.ticksToNow(currentTicks)));
        initView();
        AppMethodBeat.o(111593);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(111594);
        super.onResume();
        AppMethodBeat.o(111594);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(111595);
        if (this.xqA != null) {
            this.xqA.stopTimer();
        }
        super.onPause();
        AppMethodBeat.o(111595);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.avo;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void dealContentView(View view) {
        AppMethodBeat.i(111596);
        if (b.cv(this)) {
            setContentView(view);
            AppMethodBeat.o(111596);
            return;
        }
        ao.p(ao.a(getWindow(), (View) null), getBodyView());
        ((ViewGroup) getBodyView().getParent()).removeView(getBodyView());
        ((ViewGroup) getWindow().getDecorView()).addView(getBodyView(), 0);
        AppMethodBeat.o(111596);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x012d, code lost:
        if (r11.xqx.intValue() < 0) goto L_0x012f;
     */
    @Override // com.tencent.mm.ui.MMActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView() {
        /*
        // Method dump skipped, instructions count: 1348
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.initView():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0113  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void ayZ(java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 769
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.ayZ(java.lang.String):void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        int i4 = 0;
        AppMethodBeat.i(111599);
        Log.i("MicroMsg.ImagePreviewUI", "test onActivityResult");
        if (i2 == 4371) {
            if (i3 == -1) {
                setResult(-1, intent);
                finish();
            } else if (this.xqv.size() > 0) {
                ayZ(this.xqv.get(0));
            } else {
                Log.e("MicroMsg.ImagePreviewUI", "selectedPath has unexpected size() [%d]", Integer.valueOf(this.xqv.size()));
            }
        } else if (i2 == 4370) {
            if (i3 == -1) {
                CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel = (CaptureDataManager.CaptureVideoNormalModel) intent.getParcelableExtra("KSEGMENTMEDIAINFO");
                intent.putExtra("K_SEGMENTVIDEOPATH", captureVideoNormalModel.videoPath);
                intent.putExtra("KSEGMENTVIDEOTHUMBPATH", captureVideoNormalModel.thumbPath);
                intent.putExtra("KSEGMENTMEDIAEDITID", new StringBuilder().append(captureVideoNormalModel.eJJ().y("KEY_EDIT_PUBLISHID_INT", -1)).toString());
                setResult(-1, intent);
            }
            if (intent != null) {
                setResult(-1, intent.putExtra("GalleryUI_IsSendImgBackground", true));
                finish();
            }
        }
        if (i2 != 4372) {
            if (i2 == 4381) {
                if (i3 != -1) {
                    Toast.makeText(this, (int) R.string.eka, 1).show();
                    AppMethodBeat.o(111599);
                    return;
                } else if (this.xob) {
                    RecordConfigProvider jB = RecordConfigProvider.jB("", "");
                    jB.BOv = getIntent().getIntExtra("key_edit_video_max_time_length", 10) * 1000;
                    jB.scene = 2;
                    VideoCaptureReportInfo videoCaptureReportInfo = new VideoCaptureReportInfo();
                    videoCaptureReportInfo.sQn = 1;
                    jB.BOE = videoCaptureReportInfo;
                    UICustomParam.a aVar = new UICustomParam.a();
                    aVar.apE();
                    aVar.apD();
                    aVar.dz(true);
                    jB.BOn = aVar.gLU;
                    com.tencent.mm.plugin.recordvideo.jumper.a aVar2 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
                    com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4370, R.anim.ei, -1, jB, 4, 0);
                    AppMethodBeat.o(111599);
                    return;
                } else if (22 == e.dQK().mcq) {
                    setResult(-1, intent);
                    finish();
                    AppMethodBeat.o(111599);
                    return;
                }
            } else if (intent != null) {
                setResult(-1, intent.putExtra("GalleryUI_IsSendImgBackground", true));
                finish();
            }
            AppMethodBeat.o(111599);
        } else if (intent == null || this.xqt == null) {
            AppMethodBeat.o(111599);
        } else {
            CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel2 = (CaptureDataManager.CaptureVideoNormalModel) intent.getParcelableExtra("KSEGMENTMEDIAINFO");
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            ArrayList<String> arrayList3 = ((g) this.xqt.getAdapter()).xrn;
            ArrayList<String> arrayList4 = this.xqv;
            this.xqV += captureVideoNormalModel2.eJJ().y("KEY_EDIT_PUBLISHID_INT", -1) + ";";
            int i5 = 0;
            while (arrayList3 != null && i5 < arrayList3.size()) {
                String str = arrayList3.get(i5);
                if (str.equalsIgnoreCase(Util.nullAsNil(this.path)) || str.equalsIgnoreCase(Util.nullAsNil(this.xqU))) {
                    str = captureVideoNormalModel2.thumbPath;
                }
                arrayList.add(str);
                i5++;
            }
            while (arrayList4 != null && i4 < arrayList4.size()) {
                String str2 = arrayList4.get(i4);
                if (str2.equalsIgnoreCase(Util.nullAsNil(this.path)) || str2.equalsIgnoreCase(Util.nullAsNil(this.xqU))) {
                    str2 = captureVideoNormalModel2.thumbPath;
                }
                arrayList2.add(str2);
                i4++;
            }
            s.deleteFile(this.xqU);
            intent.putExtra("max_select_count", 9);
            intent.putExtra("isPreviewPhoto", true);
            intent.putExtra("raw_photo_path", this.path);
            intent.putExtra("after_photo_edit", captureVideoNormalModel2.thumbPath);
            intent.putStringArrayListExtra("preview_image_list", arrayList);
            intent.putStringArrayListExtra("preview_select_image_list", arrayList2);
            Bundle bundle = new Bundle();
            bundle.putString("raw_photo_path", this.path);
            bundle.putString("after_photo_edit", captureVideoNormalModel2.thumbPath);
            intent.putExtra("report_info", bundle);
            e(i3, intent);
            AppMethodBeat.o(111599);
        }
    }

    private void e(int i2, final Intent intent) {
        AppMethodBeat.i(111600);
        if (i2 == -1 && intent != null) {
            this.xqS = true;
            String stringExtra = intent.getStringExtra("raw_photo_path");
            Iterator<Bundle> it = e.dQO().iterator();
            while (stringExtra != null && it.hasNext()) {
                if (stringExtra.equals(it.next().getString("raw_photo_path"))) {
                    it.remove();
                }
            }
            e.dQO().add(intent.getBundleExtra("report_info"));
            final String stringExtra2 = intent.getStringExtra("after_photo_edit");
            String stringExtra3 = intent.getStringExtra("tmp_photo_edit");
            Log.i("MicroMsg.ImagePreviewUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s", stringExtra, stringExtra2);
            if (this.xqu != null) {
                this.xqu.clear();
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("preview_image_list");
                if (stringArrayListExtra != null) {
                    this.xqu.addAll(stringArrayListExtra);
                }
                GalleryItem.MediaItem NS = this.xqr.NS(this.xqx.intValue());
                if (NS == null) {
                    Log.e("MicroMsg.ImagePreviewUI", "item is null!!! mPosition:%s rawEditPhotoPath:%s lastEditPhotoPath:%s", this.xqx, stringExtra, stringExtra2);
                    AppMethodBeat.o(111600);
                    return;
                }
                NS.xiX = stringExtra;
                NS.xiW = stringExtra2;
                NS.sUB = stringExtra2;
                NS.xiY = stringExtra3;
                NS.mMimeType = "edit";
                e.dQN().add(NS);
                if (this.xqT != null) {
                    e.dQJ().b(this.xqT);
                }
                c dQJ = e.dQJ();
                AnonymousClass10 r2 = new d.b() {
                    /* class com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.AnonymousClass10 */

                    @Override // com.tencent.mm.plugin.gallery.model.d.b
                    public final void ayR(final String str) {
                        AppMethodBeat.i(111571);
                        new MMHandler(ImagePreviewUI.this.getMainLooper()).post(new Runnable() {
                            /* class com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.AnonymousClass10.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(111570);
                                ImagePreviewUI.this.xqr.as(ImagePreviewUI.this.xqu);
                                g gVar = (g) ImagePreviewUI.this.xqt.getAdapter();
                                ArrayList arrayList = ImagePreviewUI.this.xqu;
                                gVar.xrn.clear();
                                gVar.xrn.addAll(arrayList);
                                gVar.atj.notifyChanged();
                                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("preview_select_image_list");
                                ImagePreviewUI.this.xqv.clear();
                                if (stringArrayListExtra != null) {
                                    ImagePreviewUI.this.xqv.addAll(stringArrayListExtra);
                                }
                                ImagePreviewUI.this.updateOptionMenuText(0, ImagePreviewUI.n(ImagePreviewUI.this));
                                ImagePreviewUI.this.xnV.setText(ImagePreviewUI.this.getContext().getString(R.string.dm8) + ImagePreviewUI.dSp());
                                if (!ImagePreviewUI.this.xqv.contains(com.tencent.mm.plugin.gallery.a.d.azi(str))) {
                                    ImagePreviewUI.this.xqC.performClick();
                                }
                                AppMethodBeat.o(111570);
                            }
                        });
                        e.dQJ().b(this);
                        AppMethodBeat.o(111571);
                    }

                    @Override // com.tencent.mm.plugin.gallery.model.d.b
                    public final String dQG() {
                        AppMethodBeat.i(179472);
                        String a2 = com.tencent.mm.plugin.gallery.a.d.a(stringExtra2, (s.e) null, -1);
                        AppMethodBeat.o(179472);
                        return a2;
                    }

                    public final String toString() {
                        AppMethodBeat.i(111572);
                        String str = "fileKey:" + stringExtra2 + " this: " + super.toString();
                        AppMethodBeat.o(111572);
                        return str;
                    }
                };
                this.xqT = r2;
                dQJ.a(r2);
                e.dQJ().a(stringExtra2, NS.getType(), stringExtra2, NS.xiZ, NS.xja);
                Log.i("MicroMsg.ImagePreviewUI", "photo_edit_back!");
            }
        }
        AppMethodBeat.o(111600);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    private String dSl() {
        AppMethodBeat.i(111601);
        switch (e.dQK().mcq) {
            case 4:
            case 8:
            case 13:
            case 14:
            case 22:
                if (this.xqR && com.tencent.mm.plugin.gallery.a.d.at(this.xqw)) {
                    String str = getString(R.string.dmc) + "(" + this.xqv.size() + FilePathGenerator.ANDROID_DIR_SEP + this.wnd + ")";
                    AppMethodBeat.o(111601);
                    return str;
                } else if (this.xqv.size() == 0 || this.wnd <= 1) {
                    String string = getString(R.string.dm_);
                    AppMethodBeat.o(111601);
                    return string;
                } else {
                    String str2 = getString(R.string.dm_) + "(" + this.xqv.size() + FilePathGenerator.ANDROID_DIR_SEP + this.wnd + ")";
                    AppMethodBeat.o(111601);
                    return str2;
                }
            case 5:
            case 6:
            case 9:
            case 10:
            case 12:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            default:
                if (this.xqv.size() == 0 || this.wnd <= 1) {
                    String string2 = getString(R.string.yq);
                    AppMethodBeat.o(111601);
                    return string2;
                }
                String string3 = getString(R.string.dm1, new Object[]{Integer.valueOf(this.xqv.size()), Integer.valueOf(this.wnd)});
                AppMethodBeat.o(111601);
                return string3;
            case 7:
            case 15:
            case 16:
            case 25:
                if ((Util.isNullOrNil(this.xnr) || !this.xnr.equals("album_business_bubble_media_by_coordinate")) && e.dQK().mcq != 25) {
                    if (this.xqv.size() == 0 || this.wnd <= 1) {
                        String string4 = getString(R.string.dm_);
                        AppMethodBeat.o(111601);
                        return string4;
                    }
                    String str3 = getString(R.string.dm_) + "(" + this.xqv.size() + FilePathGenerator.ANDROID_DIR_SEP + this.wnd + ")";
                    AppMethodBeat.o(111601);
                    return str3;
                } else if (this.xqv.size() == 0 || this.wnd <= 1) {
                    String string5 = getString(R.string.x5);
                    AppMethodBeat.o(111601);
                    return string5;
                } else {
                    String str4 = getString(R.string.x5) + "(" + this.xqv.size() + FilePathGenerator.ANDROID_DIR_SEP + this.wnd + ")";
                    AppMethodBeat.o(111601);
                    return str4;
                }
            case 11:
            case 24:
                String string6 = getString(R.string.bw1);
                AppMethodBeat.o(111601);
                return string6;
        }
    }

    private ArrayList<String> dSm() {
        AppMethodBeat.i(111602);
        if (this.xpA) {
            ArrayList<String> arrayList = this.xqv;
            AppMethodBeat.o(111602);
            return arrayList;
        } else if (this.xqv != null) {
            ArrayList<String> arrayList2 = new ArrayList<>(this.xqv.size());
            Iterator<String> it = this.xqu.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (this.xqv.contains(next)) {
                    arrayList2.add(next);
                }
            }
            AppMethodBeat.o(111602);
            return arrayList2;
        } else {
            ArrayList<String> arrayList3 = new ArrayList<>(1);
            AppMethodBeat.o(111602);
            return arrayList3;
        }
    }

    private void pE(boolean z) {
        AppMethodBeat.i(111603);
        if (e.dQK().mcq == 4) {
            AppMethodBeat.o(111603);
        } else if (this.xqr == null) {
            Log.i("MicroMsg.ImagePreviewUI", "[setTopTipVisibility] adapter == null");
            AppMethodBeat.o(111603);
        } else {
            final GalleryItem.MediaItem NS = this.xqr.NS(this.xqx.intValue());
            if (!z || NS == null) {
                this.xqO.setVisibility(8);
                AppMethodBeat.o(111603);
                return;
            }
            this.xqO.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.AnonymousClass15 */

                public final void run() {
                    AppMethodBeat.i(111578);
                    ImagePreviewUI.a(ImagePreviewUI.this, NS);
                    AppMethodBeat.o(111578);
                }
            }, 400);
            AppMethodBeat.o(111603);
        }
    }

    private void pF(boolean z) {
        View findViewById;
        AppMethodBeat.i(111604);
        Log.d("MicroMsg.ImagePreviewUI", "setFooterVisibility() called with: visible = [" + z + "], selectedNormalFooter = " + this.xqG);
        if (this.xqG) {
            findViewById = findViewById(R.id.bj0);
        } else {
            findViewById = findViewById(R.id.dcl);
            if (e.dQK().mcq == 15) {
                AppMethodBeat.o(111604);
                return;
            }
        }
        if (findViewById == null) {
            Object[] objArr = new Object[2];
            objArr[0] = this.xqG ? "normal" : "edit_tips";
            objArr[1] = Boolean.valueOf(z);
            Log.w("MicroMsg.ImagePreviewUI", "set footer[%s] visibility[%B], but footerbar null", objArr);
            AppMethodBeat.o(111604);
        } else if ((!z || findViewById.getVisibility() != 0) && (z || findViewById.getVisibility() != 8)) {
            if (z) {
                findViewById.setVisibility(0);
                findViewById.startAnimation(AnimationUtils.loadAnimation(this, R.anim.br));
            } else {
                findViewById.setVisibility(8);
                findViewById.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bs));
            }
            if (!z || this.xqt.getVisibility() != 8 || this.xqv.size() <= 0) {
                if (!z && this.xqt.getVisibility() == 0) {
                    this.xqt.setVisibility(8);
                    this.xqt.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bs));
                }
                AppMethodBeat.o(111604);
                return;
            }
            this.xqt.setVisibility(0);
            this.xqt.startAnimation(AnimationUtils.loadAnimation(this, R.anim.br));
            AppMethodBeat.o(111604);
        } else {
            AppMethodBeat.o(111604);
        }
    }

    private void goBack() {
        boolean z = true;
        AppMethodBeat.i(111605);
        Intent intent = new Intent();
        boolean z2 = !this.qoL;
        if (!this.xob) {
            z = z2;
        }
        intent.putExtra("CropImage_Compress_Img", z);
        intent.putStringArrayListExtra("preview_image_list", dSm());
        intent.putExtra("show_photo_edit_tip", this.xqS);
        setResult(0, intent);
        finish();
        AppMethodBeat.o(111605);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(111606);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(111606);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(111606);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(111607);
        super.onDestroy();
        Log.i("MicroMsg.ImagePreviewUI", "onDestroy, %s.", this);
        if (e.dQK().mcq == 3 && getIntent().getBooleanExtra("preview_image", false) && getIntent().getIntExtra("max_select_count", 0) == 1) {
            Log.i("MicroMsg.ImagePreviewUI", "clear photo edit cache!");
            e.dQN().clear();
        }
        if (this.xqr != null) {
            this.xqr.release();
        }
        e.ao(null);
        ab.diQ.Uo().Un();
        if (this.xqT != null) {
            e.dQJ().b(this.xqT);
        }
        AppMethodBeat.o(111607);
    }

    private void a(String str, GalleryItem.MediaItem mediaItem) {
        AppMethodBeat.i(111608);
        if (mediaItem != null && mediaItem.getType() == 2 && (e.dQK().mcq == 4 || e.dQK().mcq == 14 || e.dQK().mcq == 13)) {
            if (mediaItem == null || mediaItem.getType() != 1 || mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                this.xqK.setVisibility(8);
            } else {
                this.xqK.setVisibility(0);
            }
            if (e.dQK().mcq == 25) {
                this.xqK.setVisibility(8);
            }
            aza(str);
            final GalleryItem.VideoMediaItem videoMediaItem = (GalleryItem.VideoMediaItem) mediaItem;
            enableOptionMenu(false);
            this.xqG = false;
            this.xqE.setVisibility(8);
            this.xqF.setVisibility(0);
            this.xqP.setVisibility(8);
            if (azb(str)) {
                AppMethodBeat.o(111608);
            } else if (!Util.isNullOrNil(videoMediaItem.jkQ)) {
                Log.d("MicroMsg.ImagePreviewUI", "got MediaItem directly path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", videoMediaItem.xiW, Integer.valueOf(videoMediaItem.jkS), Integer.valueOf(videoMediaItem.videoHeight), Integer.valueOf(videoMediaItem.videoWidth));
                a(this.xqR, a(str, videoMediaItem, this.xqR), videoMediaItem);
                AppMethodBeat.o(111608);
            } else {
                enableOptionMenu(false);
                this.xqG = true;
                this.xqE.setVisibility(0);
                this.xqF.setVisibility(8);
                this.xqz.setVisibility(8);
                a(str, mediaItem, false);
                azd(str);
                t tVar = new t(str, this.xqx.intValue(), videoMediaItem, new t.a() {
                    /* class com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.AnonymousClass16 */

                    @Override // com.tencent.mm.plugin.gallery.model.t.a
                    public final void a(t tVar) {
                        AppMethodBeat.i(111579);
                        if (tVar.equals(ImagePreviewUI.this.xqQ.getTag())) {
                            ImagePreviewUI.this.xqQ.setTag(null);
                        }
                        if (tVar.position != ImagePreviewUI.this.xqx.intValue()) {
                            AppMethodBeat.o(111579);
                            return;
                        }
                        ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.this.xqR, ImagePreviewUI.a(ImagePreviewUI.this, tVar.path, tVar.xjZ, ImagePreviewUI.this.xqR), videoMediaItem);
                        AppMethodBeat.o(111579);
                    }
                });
                if (tVar.equals(this.xqQ.getTag())) {
                    Log.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", str);
                    AppMethodBeat.o(111608);
                    return;
                }
                this.xqQ.setTag(tVar);
                h.RTc.aX(tVar);
                if (e.dQK().mcq == 15) {
                    this.xqK.setVisibility(8);
                }
                if (this.xoc) {
                    this.xqK.setVisibility(8);
                }
                AppMethodBeat.o(111608);
            }
        } else {
            this.xqG = true;
            this.xqE.setVisibility(0);
            this.xqF.setVisibility(8);
            this.xqQ.setVisibility(8);
            a(str, mediaItem, false);
            azd(str);
            enableOptionMenu(true);
            this.xqz.setVisibility(8);
            if (mediaItem == null || mediaItem.getType() != 1 || mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                Log.i("MicroMsg.ImagePreviewUI", "QuerySource:%s isPreViewImage:%s  path:%s", Integer.valueOf(e.dQK().mcq), Boolean.valueOf(getIntent().getBooleanExtra("preview_image", false)), str);
                if (mediaItem != null || Util.isNullOrNil(str)) {
                    this.xqK.setVisibility(8);
                } else {
                    this.xqK.setVisibility(0);
                }
            } else {
                this.xqK.setVisibility(0);
            }
            if (e.dQK().mcq == 15) {
                this.xqK.setVisibility(8);
            }
            if (this.xoc) {
                this.xqK.setVisibility(8);
            }
            aza(str);
            AppMethodBeat.o(111608);
        }
    }

    private void a(boolean z, boolean z2, GalleryItem.MediaItem mediaItem) {
        AppMethodBeat.i(111609);
        if (!z2) {
            AppMethodBeat.o(111609);
            return;
        }
        if (z && com.tencent.mm.plugin.gallery.a.d.at(this.xqw)) {
            this.xqP.setVisibility(8);
            this.xqz.setVisibility(8);
            this.xqF.setVisibility(8);
            enableOptionMenu(true);
            a(this.path, mediaItem, z);
        }
        AppMethodBeat.o(111609);
    }

    private void aza(String str) {
        AppMethodBeat.i(111610);
        if (this.xqv.size() < 9 || this.xqv.contains(str)) {
            this.xqK.setEnabled(true);
            this.xqK.setTextColor(getContext().getResources().getColor(R.color.ag2));
            AppMethodBeat.o(111610);
            return;
        }
        this.xqK.setTextColor(getContext().getResources().getColor(R.color.ag3));
        this.xqK.setEnabled(false);
        AppMethodBeat.o(111610);
    }

    private boolean a(String str, GalleryItem.VideoMediaItem videoMediaItem, boolean z) {
        AppMethodBeat.i(111611);
        enableOptionMenu(false);
        this.xqG = false;
        this.xqE.setVisibility(8);
        this.xqF.setVisibility(0);
        this.xqP.setVisibility(8);
        if (e.dQK().mcq == 13) {
            this.xqF.setVisibility(8);
            this.xqE.setVisibility(8);
            this.xqL.setVisibility(8);
            this.xqM.setVisibility(8);
            enableOptionMenu(true);
            AppMethodBeat.o(111611);
            return true;
        } else if (c(videoMediaItem)) {
            AppMethodBeat.o(111611);
            return false;
        } else if (a(videoMediaItem, false)) {
            AppMethodBeat.o(111611);
            return false;
        } else if (z || !b(videoMediaItem)) {
            enableOptionMenu(true);
            this.xqG = true;
            this.xqE.setVisibility(0);
            this.xqF.setVisibility(8);
            this.xqz.setVisibility(0);
            this.xqQ.setVisibility(8);
            a(str, (GalleryItem.MediaItem) videoMediaItem, false);
            azd(str);
            AppMethodBeat.o(111611);
            return true;
        } else {
            AppMethodBeat.o(111611);
            return false;
        }
    }

    private void j(GalleryItem.MediaItem mediaItem) {
        AppMethodBeat.i(111612);
        if (mediaItem == null) {
            Log.e("MicroMsg.ImagePreviewUI", "[updateTopTip] null == item");
            AppMethodBeat.o(111612);
        } else if (mediaItem.getType() == 2) {
            GalleryItem.VideoMediaItem videoMediaItem = (GalleryItem.VideoMediaItem) mediaItem;
            this.xqW = 300000;
            this.xqX = getString(R.string.dmk);
            if (this.xqI == 3) {
                com.tencent.mm.n.a aVar = com.tencent.mm.n.a.gLV;
                this.xqW = com.tencent.mm.n.a.apH() * 1000;
                com.tencent.mm.n.a aVar2 = com.tencent.mm.n.a.gLV;
                this.xqX = getString(R.string.dmj, new Object[]{Integer.valueOf(com.tencent.mm.n.a.apH() / 60)});
            } else if (this.xqI == 4) {
                com.tencent.mm.n.a aVar3 = com.tencent.mm.n.a.gLV;
                this.xqW = com.tencent.mm.n.a.apI() * 1000;
                com.tencent.mm.n.a aVar4 = com.tencent.mm.n.a.gLV;
                this.xqX = getString(R.string.dmj, new Object[]{Integer.valueOf(com.tencent.mm.n.a.apI() / 60)});
            }
            this.xqY = 1000;
            this.xqZ = getString(R.string.dmm);
            if ((this.xnr != null && (this.xnr.equals("album_business_bubble_media_by_coordinate") || this.xnr.equals("album_business_bubble_media_by_jsapi_choosevideo"))) || e.dQK().mcq == 25) {
                this.xqW = (this.kyt * 1000) + 500;
                this.xqX = getString(R.string.dnc, new Object[]{Integer.valueOf(this.kyt)});
                if (this.xoo != 0) {
                    this.xqY = this.xoo * 1000;
                    this.xqZ = getString(R.string.dnb, new Object[]{Integer.valueOf(this.xoo)});
                }
            }
            if (!Util.isNullOrNil(videoMediaItem.jkQ)) {
                Log.d("MicroMsg.ImagePreviewUI", "path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", videoMediaItem.xiW, Integer.valueOf(videoMediaItem.jkS), Integer.valueOf(videoMediaItem.videoHeight), Integer.valueOf(videoMediaItem.videoWidth));
                if (videoMediaItem.jkS >= this.xqW || (videoMediaItem.jkS > 0 && videoMediaItem.jkS < this.xqY)) {
                    this.xqO.setVisibility(0);
                    this.xqN.setText(videoMediaItem.jkS >= this.xqW ? this.xqX : this.xqZ);
                    this.xqD.setEnabled(false);
                    this.xqC.setEnabled(false);
                    this.xqD.setTextColor(getResources().getColor(R.color.ag3));
                    if (this.xqv.size() == 0) {
                        enableOptionMenu(false);
                        AppMethodBeat.o(111612);
                        return;
                    }
                } else if (a(videoMediaItem, true)) {
                    this.xqO.setVisibility(0);
                    this.xqN.setText(getString(R.string.dme));
                    this.xqD.setEnabled(false);
                    this.xqC.setEnabled(false);
                    this.xqD.setTextColor(getResources().getColor(R.color.ag3));
                    if (this.xqv.size() == 0) {
                        enableOptionMenu(false);
                        AppMethodBeat.o(111612);
                        return;
                    }
                } else {
                    this.xqD.setEnabled(true);
                    this.xqC.setEnabled(true);
                    this.xqD.setTextColor(getResources().getColor(R.color.ag2));
                    this.xqO.setVisibility(8);
                    AppMethodBeat.o(111612);
                    return;
                }
            } else {
                t tVar = new t(mediaItem.xiW, this.xqx.intValue(), videoMediaItem, new t.a() {
                    /* class com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.AnonymousClass17 */

                    @Override // com.tencent.mm.plugin.gallery.model.t.a
                    public final void a(t tVar) {
                        AppMethodBeat.i(111580);
                        if (tVar.equals(ImagePreviewUI.this.xqQ.getTag())) {
                            ImagePreviewUI.this.xqQ.setTag(null);
                        }
                        if (tVar.position != ImagePreviewUI.this.xqx.intValue()) {
                            AppMethodBeat.o(111580);
                        } else if (TextUtils.isEmpty(tVar.xjZ.jkQ)) {
                            String string = ImagePreviewUI.this.getString(R.string.dme);
                            ImagePreviewUI.this.xqO.setVisibility(0);
                            ImagePreviewUI.this.xqN.setText(string);
                            ImagePreviewUI.this.xqD.setEnabled(false);
                            ImagePreviewUI.this.xqC.setEnabled(false);
                            ImagePreviewUI.this.xqD.setTextColor(ImagePreviewUI.this.getResources().getColor(R.color.ag3));
                            if (ImagePreviewUI.this.xqv.size() == 0) {
                                ImagePreviewUI.this.enableOptionMenu(false);
                            }
                            AppMethodBeat.o(111580);
                        } else {
                            if (tVar.xjZ.jkS >= ImagePreviewUI.this.xqW || (tVar.xjZ.jkS > 0 && tVar.xjZ.jkS < ImagePreviewUI.this.xqY)) {
                                ImagePreviewUI.this.xqO.setVisibility(0);
                                ImagePreviewUI.this.xqN.setText(tVar.xjZ.jkS >= ImagePreviewUI.this.xqW ? ImagePreviewUI.this.xqX : ImagePreviewUI.this.xqZ);
                                ImagePreviewUI.this.xqD.setEnabled(false);
                                ImagePreviewUI.this.xqC.setEnabled(false);
                                ImagePreviewUI.this.xqD.setTextColor(ImagePreviewUI.this.getResources().getColor(R.color.ag3));
                                if (ImagePreviewUI.this.xqv.size() == 0) {
                                    ImagePreviewUI.this.enableOptionMenu(false);
                                    AppMethodBeat.o(111580);
                                    return;
                                }
                            } else {
                                ImagePreviewUI.this.xqD.setEnabled(true);
                                ImagePreviewUI.this.xqC.setEnabled(true);
                                ImagePreviewUI.this.xqD.setTextColor(ImagePreviewUI.this.getResources().getColor(R.color.ag2));
                                ImagePreviewUI.this.xqO.setVisibility(8);
                            }
                            AppMethodBeat.o(111580);
                        }
                    }
                });
                if (tVar.equals(this.xqQ.getTag())) {
                    Log.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", this.path);
                    AppMethodBeat.o(111612);
                    return;
                }
                this.xqQ.setTag(tVar);
                h.RTc.aX(tVar);
            }
            AppMethodBeat.o(111612);
        } else if (mediaItem.getType() != 1 || mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
            if (mediaItem.getType() == 1 && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                f fVar = new f(mediaItem.xiW);
                long boW = com.tencent.mm.vfs.s.boW(mediaItem.xiW);
                try {
                    if ((!this.xqv.contains(mediaItem.xiW) || boW == 0 || boW <= ((long) com.tencent.mm.plugin.gallery.a.d.aqp())) && fVar.ydT[0] <= com.tencent.mm.plugin.gallery.a.d.aqo() && fVar.ydT[1] <= com.tencent.mm.plugin.gallery.a.d.aqo()) {
                        this.xqD.setTextColor(getResources().getColor(R.color.ag2));
                        this.xqD.setEnabled(true);
                        this.xqC.setEnabled(true);
                        AppMethodBeat.o(111612);
                        return;
                    }
                    this.xqD.setTextColor(getResources().getColor(R.color.ag3));
                    this.xqD.setEnabled(false);
                    this.xqC.setEnabled(false);
                    AppMethodBeat.o(111612);
                    return;
                } catch (Exception e2) {
                    Log.e("MicroMsg.ImagePreviewUI", Util.stackTraceToString(e2));
                }
            }
            AppMethodBeat.o(111612);
        } else {
            this.xqD.setEnabled(true);
            this.xqC.setEnabled(true);
            this.xqD.setTextColor(getResources().getColor(R.color.ag2));
            if (!this.qoL || !this.xqv.contains(mediaItem.xiW) || com.tencent.mm.vfs.s.boW(mediaItem.xiW) <= 26214400) {
                this.xqO.setVisibility(8);
                AppMethodBeat.o(111612);
                return;
            }
            this.xqO.setVisibility(0);
            this.xqN.setText(getString(R.string.dmr));
            AppMethodBeat.o(111612);
        }
    }

    private boolean azb(String str) {
        AppMethodBeat.i(111613);
        if (com.tencent.mm.vfs.s.boW(str) > TPAudioFrame.TP_CH_STEREO_RIGHT) {
            this.xqL.setText(getString(R.string.dmi));
            this.xqM.setText(getString(R.string.dmh));
            AppMethodBeat.o(111613);
            return true;
        }
        AppMethodBeat.o(111613);
        return false;
    }

    private boolean b(GalleryItem.VideoMediaItem videoMediaItem) {
        AppMethodBeat.i(111614);
        Log.d("MicroMsg.ImagePreviewUI", "check duration %d", Integer.valueOf(videoMediaItem.jkS));
        if (e.dQK().mcq == 13) {
            AppMethodBeat.o(111614);
            return false;
        } else if (videoMediaItem.jkS <= 1000) {
            this.xqL.setText(getString(R.string.dmn));
            this.xqM.setText(getString(R.string.dmm));
            AppMethodBeat.o(111614);
            return true;
        } else if (videoMediaItem.jkS >= 300000) {
            this.xqL.setText(getString(R.string.dml));
            this.xqM.setText(getString(R.string.dmk));
            AppMethodBeat.o(111614);
            return true;
        } else if (videoMediaItem.jkS >= (this.xqJ * 1000) + 500) {
            this.xqL.setText(getString(R.string.dm7));
            this.xqM.setText(getString(R.string.dm6, new Object[]{Integer.valueOf(this.xqJ)}));
            this.xqP.setVisibility(0);
            AppMethodBeat.o(111614);
            return true;
        } else {
            AppMethodBeat.o(111614);
            return false;
        }
    }

    private boolean dSn() {
        AppMethodBeat.i(111615);
        this.xqL.setText(getString(R.string.dmd));
        this.xqM.setText(getString(R.string.dme));
        AppMethodBeat.o(111615);
        return true;
    }

    private boolean c(GalleryItem.VideoMediaItem videoMediaItem) {
        AppMethodBeat.i(111616);
        if (videoMediaItem == null || videoMediaItem.videoWidth <= 0 || videoMediaItem.videoHeight <= 0 || ((float) videoMediaItem.videoWidth) / ((float) videoMediaItem.videoHeight) > 3.0f || ((float) videoMediaItem.videoWidth) / ((float) videoMediaItem.videoHeight) < 0.3f) {
            if (videoMediaItem != null) {
                Log.d("MicroMsg.ImagePreviewUI", "check ratio faild width = [%d], height = [%d]", Integer.valueOf(videoMediaItem.videoWidth), Integer.valueOf(videoMediaItem.videoHeight));
            }
            this.xqL.setText(getString(R.string.dmf));
            this.xqM.setText(getString(R.string.dmg));
            AppMethodBeat.o(111616);
            return true;
        }
        AppMethodBeat.o(111616);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem r8, boolean r9) {
        /*
        // Method dump skipped, instructions count: 137
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.a(com.tencent.mm.plugin.gallery.model.GalleryItem$VideoMediaItem, boolean):boolean");
    }

    private boolean azc(String str) {
        AppMethodBeat.i(111618);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(111618);
            return true;
        }
        if (this.xoB == null) {
            this.xoB = new HashSet<>();
            this.xoB.add(".h264");
            this.xoB.add(".h26l");
            this.xoB.add(".264");
            this.xoB.add(".avc");
            this.xoB.add(".mov");
            this.xoB.add(".mp4");
            this.xoB.add(".m4a");
            this.xoB.add(".3gp");
            this.xoB.add(".3g2");
            this.xoB.add(".mj2");
            this.xoB.add(".m4v");
        }
        String trim = str.trim();
        int lastIndexOf = trim.lastIndexOf(".");
        if (lastIndexOf < 0 || lastIndexOf >= trim.length()) {
            AppMethodBeat.o(111618);
            return true;
        } else if (!this.xoB.contains(trim.substring(lastIndexOf).toLowerCase())) {
            AppMethodBeat.o(111618);
            return true;
        } else {
            AppMethodBeat.o(111618);
            return false;
        }
    }

    private void a(String str, GalleryItem.MediaItem mediaItem, boolean z) {
        AppMethodBeat.i(111619);
        int i2 = e.dQK().xjo;
        int i3 = e.dQK().mcq;
        boolean z2 = i3 != 16 && (i2 == 2 || i2 == 3);
        if (mediaItem == null || mediaItem.getType() != 2 || i3 != 4 || z || z2) {
            if (this.wnd == 1) {
                this.xqC.setVisibility(8);
                this.xqD.setVisibility(8);
            } else {
                this.xqC.setVisibility(0);
                this.xqD.setVisibility(0);
            }
            if (!this.xqv.contains(str)) {
                this.xqC.setImageResource(R.raw.radio_off);
                AppMethodBeat.o(111619);
                return;
            }
            this.xqC.setImageResource(dSo());
            AppMethodBeat.o(111619);
            return;
        }
        this.xqC.setVisibility(8);
        this.xqD.setVisibility(8);
        AppMethodBeat.o(111619);
    }

    private void azd(String str) {
        Boolean bool;
        boolean z = true;
        AppMethodBeat.i(111620);
        Boolean bool2 = Boolean.FALSE;
        switch (e.dQK().mcq) {
            case 4:
            case 7:
            case 13:
            case 14:
            case 15:
            case 16:
                bool = Boolean.TRUE;
                break;
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            default:
                bool = Boolean.FALSE;
                break;
        }
        GalleryItem.MediaItem ayS = e.ayS(str);
        if (ayS != null && ayS.getType() == 2) {
            bool = Boolean.TRUE;
            z = false;
        } else if (ayS == null || ayS.getType() != 1) {
            z = false;
        }
        if (ayS == null && ImgUtil.isGif(str)) {
            bool = Boolean.TRUE;
        } else if (ayS != null && ayS.mMimeType.equalsIgnoreCase("image/gif")) {
            bool = Boolean.TRUE;
        }
        if ((!this.xoe || !z) && bool.booleanValue()) {
            this.xqy.setVisibility(8);
            this.xnV.setVisibility(8);
            AppMethodBeat.o(111620);
            return;
        }
        this.xqy.setVisibility(0);
        this.xnV.setVisibility(0);
        AppMethodBeat.o(111620);
    }

    private void c(int i2, int i3, String str, int i4) {
        int indexOf;
        AppMethodBeat.i(111621);
        Log.i("MicroMsg.ImagePreviewUI", "count:%s selectPosition:%s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (-1 != i3 && !this.xpA) {
            this.xqt.getAdapter().b(i3, Integer.valueOf(i3));
        } else if (-1 != i3) {
            if (i4 == 0 && i2 > 0) {
                ((g) this.xqt.getAdapter()).aze(str);
                ((g) this.xqt.getAdapter()).gJ(i2 - 1, this.xqx.intValue());
                this.xqt.getAdapter().cj(i2 - 1);
                RecyclerView recyclerView = this.xqt;
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i2 - 1, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI", "notifyRecycleViewWhenSelected", "(IILjava/lang/String;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
                recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI", "notifyRecycleViewWhenSelected", "(IILjava/lang/String;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
            } else if (i4 == 1 && -1 != (indexOf = ((g) this.xqt.getAdapter()).indexOf(str))) {
                ((g) this.xqt.getAdapter()).remove(indexOf);
                this.xqt.getAdapter().ck(indexOf);
            }
        }
        boolean z = e.dQK().mcq == 13;
        GalleryItem.MediaItem NS = this.xqr.NS(this.xqx.intValue());
        if (i2 == 0 || (((this.xob && !this.xqR) || z) && this.xqr != null && NS != null && NS.getType() == 2)) {
            this.xqt.setVisibility(8);
            AppMethodBeat.o(111621);
            return;
        }
        this.xqt.setVisibility(0);
        AppMethodBeat.o(111621);
    }

    private static int dSo() {
        AppMethodBeat.i(111622);
        if (e.dQK().mcq == 15) {
            AppMethodBeat.o(111622);
            return R.raw.checkbox_selected_game;
        } else if (e.dQK().mcq == 25) {
            AppMethodBeat.o(111622);
            return R.raw.checkbox_selected_orange;
        } else {
            AppMethodBeat.o(111622);
            return R.raw.checkbox_selected_small;
        }
    }

    static /* synthetic */ void a(ImagePreviewUI imagePreviewUI, boolean z) {
        AppMethodBeat.i(111623);
        if (z) {
            imagePreviewUI.fullScreenNoTitleBar(false);
            imagePreviewUI.pE(z);
            imagePreviewUI.pF(true);
            AppMethodBeat.o(111623);
            return;
        }
        imagePreviewUI.fullScreenNoTitleBar(true);
        imagePreviewUI.pE(z);
        imagePreviewUI.pF(false);
        AppMethodBeat.o(111623);
    }

    static /* synthetic */ String dSp() {
        return "";
    }

    static /* synthetic */ void a(ImagePreviewUI imagePreviewUI, int i2) {
        AppMethodBeat.i(111624);
        GalleryItem.MediaItem NS = imagePreviewUI.xqr.NS(i2);
        if (NS != null) {
            imagePreviewUI.j(NS);
        }
        AppMethodBeat.o(111624);
    }

    static /* synthetic */ void a(ImagePreviewUI imagePreviewUI, Intent intent, boolean z, boolean z2) {
        AppMethodBeat.i(111628);
        intent.putExtra("CropImage_Compress_Img", z ? true : z2);
        ArrayList<String> dSm = imagePreviewUI.dSm();
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        intent.putExtra("KSEGMENTMEDIAEDITID", imagePreviewUI.xqV);
        if (dSm == null || dSm.size() <= 0) {
            Log.i("MicroMsg.ImagePreviewUI", "no img selected. keep current ui.");
            AppMethodBeat.o(111628);
            return;
        }
        Iterator<String> it = dSm.iterator();
        while (it.hasNext()) {
            String next = it.next();
            GalleryItem.MediaItem ayS = e.ayS(next);
            if (ayS == null || ayS.getType() != 2) {
                if (ayS != null && ayS.getType() != 2 && ayS.mMimeType.equals("edit") && !Util.isNullOrNil(ayS.xiY)) {
                    next = ayS.xiY;
                }
                arrayList.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        Log.i("MicroMsg.ImagePreviewUI", "dealWithSend, enableVLog:%s", Boolean.valueOf(imagePreviewUI.xqR));
        if (imagePreviewUI.xqR && com.tencent.mm.plugin.gallery.a.d.at(imagePreviewUI.xqw)) {
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            int[] iArr = new int[imagePreviewUI.wnd];
            int i2 = 0;
            Iterator<GalleryItem.MediaItem> it2 = imagePreviewUI.xqw.iterator();
            while (it2.hasNext()) {
                GalleryItem.MediaItem next2 = it2.next();
                if (next2.getType() == 1) {
                    if (!next2.mMimeType.equals("edit") || Util.isNullOrNil(next2.xiY)) {
                        arrayList3.add(next2.xiW);
                    } else {
                        arrayList3.add(next2.xiY);
                    }
                    i2++;
                    iArr[i2] = 1;
                } else if (next2.getType() == 2) {
                    arrayList4.add(next2.xiW);
                    i2++;
                    iArr[i2] = 2;
                } else {
                    i2 = i2;
                }
            }
            Log.i("MicroMsg.ImagePreviewUI", "try send vlog, videoList:%s, imageList:%s", Integer.valueOf(arrayList4.size()), Integer.valueOf(arrayList3.size()));
            if (com.tencent.mm.plugin.recordvideo.activity.a.b.q(arrayList3, arrayList4) == 4) {
                VLogPreloadUI.a aVar = VLogPreloadUI.xsx;
                VLogPreloadUI.a.a(imagePreviewUI, arrayList4, arrayList3, iArr);
                AppMethodBeat.o(111628);
                return;
            }
        }
        boolean z3 = e.dQK().mcq == 14;
        if ((z || z3) && arrayList.size() == 0 && arrayList2.size() == 1) {
            GalleryItem.MediaItem ayS2 = e.ayS(arrayList2.get(0));
            if (ayS2 == null || !(ayS2 instanceof GalleryItem.VideoMediaItem) || ((GalleryItem.VideoMediaItem) ayS2).jkS == -1) {
                Log.e("MicroMsg.ImagePreviewUI", "dealWithSend VideoMediaItem not found.");
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("K_SEGMENTVIDEOPATH", ayS2.xiW);
                intent2.putExtra("KSEGMENTVIDEOTHUMBPATH", ayS2.sUB);
                if (z) {
                    com.tencent.mm.br.c.b(imagePreviewUI, "mmsight", ".segment.VideoCompressUI", intent2, 4371);
                    AppMethodBeat.o(111628);
                    return;
                }
                imagePreviewUI.setResult(-1, intent2);
                imagePreviewUI.finish();
                AppMethodBeat.o(111628);
                return;
            }
        }
        intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList);
        intent.putStringArrayListExtra("key_select_video_list", arrayList2);
        boolean booleanExtra = imagePreviewUI.getIntent().getBooleanExtra("isTakePhoto", false);
        if (booleanExtra && imagePreviewUI.dSm().size() > 0) {
            String str = imagePreviewUI.dSm().get(0);
            BackwardSupportUtil.ExifHelper.LatLongData exifLatLong = BackwardSupportUtil.ExifHelper.getExifLatLong(str);
            Intent intent3 = new Intent(imagePreviewUI, ImagePreviewUI.class);
            Log.d("MicroMsg.ImagePreviewUI", "findlatlng %s", str);
            if (exifLatLong != null) {
                Log.d("MicroMsg.ImagePreviewUI", "findlatlng %f %f", Float.valueOf(exifLatLong.latitude), Float.valueOf(exifLatLong.longtitude));
                intent3.putExtra("KlatLng", exifLatLong);
            }
        }
        Log.d("MicroMsg.ImagePreviewUI", "summersafecdn send image, previewImageCount:%d, chooseForTimeline:%b, forTimeline:%b, beCompress:%b", Integer.valueOf(e.dQR()), Boolean.valueOf(imagePreviewUI.xob), Boolean.valueOf(z), Boolean.valueOf(z2));
        com.tencent.mm.plugin.gallery.a.d.bw(11610, (imagePreviewUI.xob ? 3 : 2) + "," + e.dQR());
        e.dQQ();
        Log.d("MicroMsg.ImagePreviewUI", "isTaskPhoto ? " + booleanExtra + " | isPreviewPhoto ? " + intent.getBooleanExtra("isPreviewPhoto", false));
        intent.putExtra("isTakePhoto", booleanExtra);
        String stringExtra = imagePreviewUI.getIntent().getStringExtra("GalleryUI_ToUser");
        if (Util.isNullOrNil(imagePreviewUI.getIntent().getStringExtra("GalleryUI_FromUser")) || "medianote".equals(stringExtra)) {
            imagePreviewUI.setResult(-1, intent);
            imagePreviewUI.finish();
            AppMethodBeat.o(111628);
        } else if (Util.currentTicks() - imagePreviewUI.xol < 1000) {
            Log.w("MicroMsg.ImagePreviewUI", "sendimg btn event frequence limit");
            AppMethodBeat.o(111628);
        } else {
            imagePreviewUI.xol = Util.currentTicks();
            Log.i("MicroMsg.ImagePreviewUI", "switch to SendImgProxyUI");
            intent.setClassName(imagePreviewUI, "com.tencent.mm.ui.chatting.SendImgProxyUI");
            intent.putExtra("GalleryUI_FromUser", imagePreviewUI.getIntent().getStringExtra("GalleryUI_FromUser"));
            intent.putExtra("GalleryUI_ToUser", imagePreviewUI.getIntent().getStringExtra("GalleryUI_ToUser"));
            intent.putExtra("CropImage_limit_Img_Size", 26214400);
            imagePreviewUI.startActivityForResult(intent, 4369);
            AppMethodBeat.o(111628);
        }
    }

    static /* synthetic */ void o(ImagePreviewUI imagePreviewUI) {
        AppMethodBeat.i(111630);
        String stringExtra = imagePreviewUI.getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra2 = imagePreviewUI.getIntent().getStringExtra("GalleryUI_ToUser");
        Intent intent = new Intent();
        Log.i("MicroMsg.ImagePreviewUI", "edit image path:%s mPosition:%s", imagePreviewUI.xqr.getItem(imagePreviewUI.xqx.intValue()), imagePreviewUI.xqx);
        intent.putExtra("GalleryUI_FromUser", stringExtra);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        intent.putExtra("from_scene", e.dQK().mcq);
        intent.putExtra("preview_image_list", ((g) imagePreviewUI.xqt.getAdapter()).xrn);
        if (e.dQK().mcq == 4) {
            intent.putExtra("from_scene", 289);
        } else if (e.dQK().mcq == 3) {
            intent.putExtra("from_scene", g.CTRL_INDEX);
        }
        intent.putExtra("preview_select_image_list", imagePreviewUI.xqv);
        GalleryItem.MediaItem NS = imagePreviewUI.xqr.NS(imagePreviewUI.xqx.intValue());
        if (NS != null) {
            Log.i("MicroMsg.ImagePreviewUI", "[gotoPhotoEditUI] raw:%s orignal:%s", NS.xiX, NS.xiW);
            imagePreviewUI.path = NS.xiX;
            if (Util.isNullOrNil(imagePreviewUI.path)) {
                imagePreviewUI.path = NS.xiW;
                intent.putExtra("after_photo_edit", "");
                imagePreviewUI.xqU = "";
            } else {
                intent.putExtra("after_photo_edit", NS.xiW);
                imagePreviewUI.xqU = NS.xiW;
            }
        } else {
            Log.i("MicroMsg.ImagePreviewUI", "[gotoPhotoEditUI] item == null mPosition:%s", imagePreviewUI.xqx);
            imagePreviewUI.path = imagePreviewUI.xqr.getItem(imagePreviewUI.xqx.intValue());
            GalleryItem.MediaItem a2 = GalleryItem.MediaItem.a(1, (long) imagePreviewUI.xqx.intValue(), imagePreviewUI.path, imagePreviewUI.path, "edit");
            ArrayList arrayList = new ArrayList();
            arrayList.add(a2);
            e.ao(arrayList);
        }
        RecordConfigProvider jA = RecordConfigProvider.jA(imagePreviewUI.path, "");
        jA.scene = e.dQK().mcq;
        VideoCaptureReportInfo videoCaptureReportInfo = new VideoCaptureReportInfo();
        if (jA.scene == 4) {
            videoCaptureReportInfo.sQn = 1;
        } else if (jA.scene == 3) {
            videoCaptureReportInfo.sQn = 3;
        }
        jA.BOE = videoCaptureReportInfo;
        UICustomParam.a aVar = new UICustomParam.a();
        aVar.apE();
        aVar.apD();
        aVar.dz(true);
        jA.BOn = aVar.gLU;
        com.tencent.mm.plugin.recordvideo.jumper.a aVar2 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(imagePreviewUI.getContext(), 4372, R.anim.ei, -1, jA, 1, 1);
        AppMethodBeat.o(111630);
    }

    static /* synthetic */ void a(ImagePreviewUI imagePreviewUI, final int i2, String str) {
        final int i3;
        AppMethodBeat.i(111631);
        if (str == null) {
            AppMethodBeat.o(111631);
            return;
        }
        g gVar = (g) imagePreviewUI.xqt.getAdapter();
        if (!imagePreviewUI.xpA) {
            Log.i("MicroMsg.ImagePreviewUI", "[notifyRecycleViewWhenPageSelected] :%s %s", Integer.valueOf(i2), imagePreviewUI.xqx);
            gVar.gJ(i2, i2);
            gVar.b(imagePreviewUI.xqx.intValue(), new Object());
            gVar.b(i2, new Object());
            imagePreviewUI.xqt.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.AnonymousClass18 */

                public final void run() {
                    AppMethodBeat.i(111581);
                    RecyclerView recyclerView = ImagePreviewUI.this.xqt;
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$25", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                    recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$25", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                    AppMethodBeat.o(111581);
                }
            }, 66);
            AppMethodBeat.o(111631);
            return;
        }
        if (imagePreviewUI.xqv.contains(str)) {
            i3 = imagePreviewUI.xqv.indexOf(str);
        } else {
            i3 = -1;
        }
        Log.i("MicroMsg.ImagePreviewUI", "[notifyRecycleViewWhenPageSelected] :%s indexInBar:%s %s", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(imagePreviewUI.xpA));
        gVar.gJ(i3, i2);
        gVar.atj.notifyChanged();
        if (i3 != -1) {
            imagePreviewUI.xqt.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.AnonymousClass19 */

                public final void run() {
                    AppMethodBeat.i(111582);
                    RecyclerView recyclerView = ImagePreviewUI.this.xqt;
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i3, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$26", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                    recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/gallery/ui/ImagePreviewUI$26", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                    AppMethodBeat.o(111582);
                }
            }, 66);
        }
        AppMethodBeat.o(111631);
    }

    static /* synthetic */ void w(ImagePreviewUI imagePreviewUI) {
        AppMethodBeat.i(257757);
        if (imagePreviewUI.xqA == null || imagePreviewUI.xqA.stopped()) {
            imagePreviewUI.xqA = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.AnonymousClass14 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    boolean z;
                    AppMethodBeat.i(111577);
                    ImagePreviewUI imagePreviewUI = ImagePreviewUI.this;
                    if (!ImagePreviewUI.this.xqH) {
                        z = true;
                    } else {
                        z = false;
                    }
                    imagePreviewUI.xqH = z;
                    ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.this.xqH);
                    AppMethodBeat.o(111577);
                    return false;
                }
            }, false);
            imagePreviewUI.xqA.startTimer(350);
            AppMethodBeat.o(257757);
            return;
        }
        imagePreviewUI.xqA.stopTimer();
        AppMethodBeat.o(257757);
    }
}
